package org.sudocode.api.post.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
@Transactional(
        rollbackFor = Exception.class,
        propagation = Propagation.MANDATORY
)
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUserId(Long userId);

    @Query("SELECT v FROM Vote v "
           + "WHERE v.project.id = :projectId "
           + "AND v.user.id = :userId")
    Optional<Vote> fetchByUserAndProjectId(@Param("projectId") Long projectId,
                                           @Param("userId") Long userId);


    @Query("SELECT v FROM Vote v WHERE v.project.id = :id")
    Stream<Vote> fetchAllByProjectId(@Param("id") Long id);

}
