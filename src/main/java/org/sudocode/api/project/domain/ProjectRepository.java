package org.sudocode.api.project.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.project.dto.ProjectSummary;

@Repository
@Transactional(
        readOnly = true,
        propagation = Propagation.MANDATORY,
        rollbackFor = Exception.class
)
public interface ProjectRepository extends JpaRepository<Project, Long> {

    String FETCH_ALL_WHERE_CLAUSE =
            "WHERE (:title is null or lower(p.title) LIKE concat('%', lower(:title), '%')) " +
                    "AND (:difficulty is null or p.difficulty = :difficulty) " +
                    "AND (:description is null or lower(p.description) LIKE concat('%', lower(:description), '%'))";

    @Query(value = "SELECT NEW " +
            "org.sudocode.api.project.dto.ProjectSummary" +
                "(p.id, p.title, p.difficulty, p.description, p.datePosted, u.id, u.login, u.avatarUrl) " +
            "FROM Project p " +
            "JOIN p.author AS u " + FETCH_ALL_WHERE_CLAUSE,
            countQuery = "SELECT count(p) FROM Project p " + FETCH_ALL_WHERE_CLAUSE)
    Page<ProjectSummary> fetchAll(@Param("title") String title,
                                  @Param("difficulty") Difficulty difficulty,
                                  @Param("description") String description,
                                  Pageable pageable);


}
/*   private final EntityManager em;

    private final String ACCOUNT_RESOURCE =
            " org.sudocode.api.account.rest.AccountResource(a.username, a.realName, a.displayName, a.githubId, a.gitlabId) ";

    public AccountRepository(EntityManager em) {
        this.em = em;
    }

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    public Account save(Account user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    public Optional<AccountResource> fetchByIdDTO(Long id) {
        return fetchOrEmpty(() ->
                em.createQuery("" +
                        "SELECT NEW" + ACCOUNT_RESOURCE +
                        "FROM Account a WHERE a.id = :id", AccountResource.class)
                  .setParameter("id", id)
                  .getSingleResult());
    }

    public boolean existsById(Long id) {
        return (boolean) em.createQuery(
                "SELECT CASE "
                        + "WHEN COUNT(u) > 0 "
                        + "THEN true ELSE false END "
                        + "FROM Account u WHERE u.id =: id"
        ).setParameter("id", id).getSingleResult();
    }

    List<AccountResource> fetchAll(int page, int size, String direction) {
        return em.createQuery(
                "SELECT NEW org.sudocode.api.account.rest.AccountResource" +
                        "(a.username, a.name, a.displayName, a.githubId, a.gitlabId) " +
                        "FROM Account a " +
                        "ORDER BY a.creationDate " + direction, AccountResource.class
        ).setMaxResults(size)
                 .setFirstResult((page == 0 ? page : --page) * size)
                 .getResultList();
    }


//    public AccountResource fetchByIdDTO()
//
//    public Iterable<Account> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    public long count() {
//        return 0;
//    }
//
//    public void deleteById(Long aLong) {
//
//    }
//
//    public void delete(Account entity) {
//
//    }
//
//    public void deleteAll(Iterable<? extends Account> entities) {
//
//    }
//
//    public void deleteAll() {
//
//    }*/