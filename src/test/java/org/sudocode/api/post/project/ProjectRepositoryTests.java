package org.sudocode.api.post.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.sudocode.api.post.Vote;
import org.sudocode.api.user.User;
import testingutils.ProjectViewMock;
import testingutils.UserViewMock;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.Pageable.unpaged;
import static org.sudocode.api.post.project.Difficulty.BASIC;
import static org.sudocode.api.post.project.Difficulty.INTERMEDIATE;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
class ProjectRepositoryTests {

	private static final String DONT_USE_THIS = "don't use this title";

	@Autowired
	private ProjectRepository repo;

	@Autowired
	private TestEntityManager tem;

	private ProjectViewMock projectView1;

	private UserViewMock userView1;

	private Project project1;

	private User user1;

	@BeforeEach
	void setUp() {
		this.user1 = tem.persistAndFlush(User.builder().id(1L).login("user-1").build());

		this.project1 = tem
				.persistAndFlush(Project.builder(user1).description("Spring Security 5")
						.difficulty(BASIC).title("Spring Security 5").build());

		this.userView1 = UserViewMock.builder().id(user1.getId()).login(user1.getLogin())
				.avatarUrl(user1.getAvatarUrl()).hireable(user1.isHireable()).build();

		this.projectView1 = new ProjectViewMock(project1.getId(), project1.getTitle(),
				project1.getDifficulty(), project1.getDescription(),
				project1.getDatePosted(), project1.getLastModifiedDate(), userView1);

	}

	@Test
	void fetchAllProjections_ProjectionMatch() {
		Page<ProjectView> page = repo.filterAll("t", BASIC, "", PageRequest.of(0, 1));

		ProjectView expectedResult = page.getContent().get(0);

		assertAll("Fetch-All -- empty description",
				() -> assertTrue(page.getTotalElements() > 0,
						"Page should have more than 1 element."),
				() -> assertNotNull(expectedResult, "First element should not be null"),
				() -> assertEquals(project1.getDescription(),
						expectedResult.getDescription(), "Descriptions should match"),
				() -> assertNotNull(projectView1.getId(),
						"project view ID should not be null"),
				() -> assertEquals(project1.getTitle(), projectView1.getTitle(),
						"Titles should be equal"),
				() -> assertEquals(projectView1.getAuthor(), userView1,
						"UserView's should be equal")

		);
	}

	@AfterEach
	void tearDown() {
		tem.clear();
	}

	@Test
	void fetchAll_filterSearches() {
		User user2 = tem.persistAndFlush(User.builder().id(2L).build());
		Project project2 = tem.persistAndFlush(Project.builder(user2)
				.title("I like spring").description("I also like angular").build());

		tem.persistAndFlush(
				Project.builder(user2).title("Effective Java").difficulty(INTERMEDIATE)
						.description("Pretty good book if I do say so myself").build());

		var query1 = repo.filterAll("g", BASIC, "", unpaged()).getContent();
		var springTitleQuery = repo.filterAll("sPrInG", null, null, unpaged())
				.getContent();

		assertAll("FilterAll -- filtering searches",
				() -> assertTrue(
						springTitleQuery.stream().allMatch(
								p -> containsIgnoreCase(p.getTitle(), "spring")),
						"All projects should have 'spring' in the title"),
				() -> assertTrue(
						query1.stream().noneMatch(p -> p.getDifficulty() != BASIC),
						"Difficulty filter should filter out any other than what was searched"),
				() -> assertEquals(1, query1.stream()
						.filter(p -> p.getId().equals(project2.getId())).count()));
	}

	@Test
	void fetchById() {
		var projectMock = repo.save(Project.builder(user1).build());
		System.out.println(projectMock);

		assertAll("Fetch by id",
				() -> assertTrue(repo.fetchById(projectMock.getId()).isPresent(),
						"Should be present"),
				() -> assertFalse(projectMock.isNew(), "Shouldn't be new"),
				() -> assertNotNull(projectMock.getDatePosted(),
						"Date posted should not be null. Make sure JPA auditing is enabled on test"));
	}

	@Test
	void findViewById() {
		assertAll("Fetch View by id",
				() -> assertTrue(repo.findViewById(project1.getId()).isPresent(),
						"Should be present"),
				() -> assertTrue(repo.findViewById(project1.getId())
						.filter(p -> p.getTitle().equals(project1.getTitle()))
						.isPresent(), "Title's should match."));
	}

	@Test
	void vote_rating() {
		project1.vote(Vote.UPVOTE);
		System.out.println(project1.getRating());
		project1 = tem.persistFlushFind(project1);

		assertEquals(2, repo.vote(project1.getId(), Vote.UPVOTE.primitiveValue()));
	}

}