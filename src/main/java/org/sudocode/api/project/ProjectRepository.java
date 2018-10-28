package org.sudocode.api.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.project.web.ProjectDTO;
import org.sudocode.api.project.web.ProjectSummaryDTO;
import org.sudocode.api.project.web.ProjectView;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Project repository.
 * <p>
 * Not to be accessed without an ongoing transaction (preferably from {@link org.sudocode.api.project.ProjectService}.
 */
@Repository
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class,
        propagation = Propagation.MANDATORY
)
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT NEW " +
            "org.sudocode.api.project.web.ProjectSummaryDTO" +
            "(p.id, p.title, p.difficulty, p.description, p.datePosted, u.id, u.login, u.avatarUrl) " +
            "FROM Project p " +
            "JOIN p.author AS u " +
            "WHERE (:title is null or lower(p.title) LIKE concat('%', lower(:title), '%')) " +
            "AND (:difficulty is null or p.difficulty = :difficulty) " +
            "AND (:description is null or lower(p.description) LIKE concat('%', lower(:description), '%'))")
    Page<ProjectSummaryDTO> fetchAll(@Param("title") String title,
                                     @Param("difficulty") Difficulty difficulty,
                                     @Param("description") String description,
                                     Pageable pageable);

    @Query("SELECT " +
            "p.id AS id, " +
            "p.title AS title, " +
            "p.difficulty AS difficulty, " +
            "p.description AS description, " +
            "p.datePosted AS datePosted, " +
            "p.author AS author " +
            "FROM Project p " +
            "WHERE (:title is null or lower(p.title) LIKE concat('%', lower(:title), '%')) " +
            "AND (:difficulty is null or p.difficulty = :difficulty) " +
            "AND (:description is null or lower(p.description) LIKE concat('%', lower(:description), '%'))")
    Page<ProjectView> fetchAllProjections(@Param("title") String title,
                                                @Param("difficulty") Difficulty difficulty,
                                                @Param("description") String description,
                                                Pageable pageable);


    @Query("SELECT max(p.datePosted) FROM Project p WHERE p.author.id = :id")
    Optional<LocalDateTime> fetchLatestPostDateByAuthorId(@Param("id") Long id);

    @Deprecated
    @Query("SELECT NEW org.sudocode.api.project.web.ProjectDTO" +
            "(p.id, p.title, p.difficulty, p.description, p.datePosted, p.lastModifiedDate, " +
            "u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM Project p JOIN p.author AS u WHERE p.id = :id")
    Optional<ProjectDTO> fetchDTOById(@Param("id") Long id);

    @Query("SELECT p FROM Project p JOIN FETCH  p.author WHERE p.id = :id")
    Optional<Project> fetchById(@Param("id") Long id);

    @Query("SELECT "
            + "p.id AS id, "
            + "p.title AS title, "
            + "p.difficulty AS difficulty, "
            + "p.description AS description, "
            + "p.datePosted AS datePosted, "
            + "p.author AS author" +
            " FROM Project p WHERE p.id = :id")
    Optional<ProjectView> fetchViewById(@Param("id") Long id);

}
