package org.sudocode.api.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.sudocode.api.project.domain.Difficulty;
import org.sudocode.api.project.domain.ProjectRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @InjectMocks
    private ProjectService service;

    @Mock
    private ProjectRepository repo;

    @BeforeEach
    void setUp() {
    }

    @Test
    void postProject() {
    }

    @Test
    void postProjectDTO() {
    }

    @Test
    void fetchAll() {
    }

    @Test
    void fetchDTOById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void postComment() {
    }

    @Test
    void deleteCommentById() {
    }

    @Test
    void fetchCommentsByProjectId() {
    }
}