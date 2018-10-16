package org.sudocode.api.project.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.project.ProjectDTO;
import org.sudocode.api.project.ProjectSummaryDTO;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Project repository.
 *
 * Not to be accessed without an ongoing transaction (preferably from {@link org.sudocode.api.project.ProjectServiceImpl}.
 */
@Repository
@Transactional(
        readOnly = true,
        propagation = Propagation.MANDATORY,
        rollbackFor = Exception.class
)
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT NEW " +
            "org.sudocode.api.project.ProjectSummaryDTO" +
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

    @Query("SELECT max(p.datePosted) FROM Project p WHERE p.author.id = :id")
    LocalDateTime fetchLatestPostDateByAuthorId(@Param("id") Long id);

    @Query("SELECT NEW org.sudocode.api.project.ProjectDTO" +
                "(p.id, p.title, p.difficulty, p.description, p.datePosted, p.lastModifiedDate, " +
                "u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM Project p JOIN p.author AS u WHERE p.id = :id")
    Optional<ProjectDTO> fetchDTOById(@Param("id") Long id);

}
