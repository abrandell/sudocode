package org.sudocode.api.project.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(
        propagation = Propagation.MANDATORY,
        rollbackFor = Exception.class
)
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Deprecated
    @Query(value = "SELECT c FROM Comment c JOIN FETCH c.project JOIN FETCH c.author WHERE c.project.id = :id",
        countQuery = "SELECT count(c) FROM Comment c WHERE c.project.id = :id")
    Page<Comment> fetchAllByProjectId(@Param("id") Long id, Pageable pageable);

    @Query("SELECT c FROM Comment c JOIN FETCH c.author WHERE c.id = :id")
    Optional<Comment> fetchById(@Param("id") Long id);

    @Query("SELECT max(c.datePosted) FROM Comment c WHERE c.author.id = :id")
    Optional<LocalDateTime> fetchLatestPostDateByAuthorId(@Param("id") Long id);

    @Deprecated
    @Query("SELECT NEW org.sudocode.api.project.comment.CommentDTO" +
                "(c.id, c.body, c.datePosted, c.lastModifiedDate, u.id, u.login, u.avatarUrl, u.hireable) " +
            "FROM Comment c JOIN c.author AS u " +
            "WHERE c.project.id = :id")
    Page<CommentDTO> fetchCommentPageDTOByProjectId(@Param("id") Long id, Pageable pageable);

    @Deprecated
    @Query("SELECT c FROM Comment c JOIN c.author AS u WHERE c.project.id = :id")
    Page<Comment> fetchCommentsByProjectId(@Param("id") Long id, Pageable pageable);

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    @Query("DELETE FROM Comment c WHERE c.project.id = :id")
    void deleteCommentsByProjectId(@Param("id") Long id);


    @Query("SELECT " +
            "c.id AS id, " +
            "c.body AS body, " +
            "c.author AS author, " +
            "c.datePosted AS datePosted, " +
            "c.lastModifiedDate AS lastModifiedDate " +
            "FROM Comment c WHERE c.project.id = :id")
    Page<CommentView> fetchCommentViewsByProjectId(@Param("id") Long id, Pageable pageable);

}
