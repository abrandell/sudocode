package org.sudocode.api.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.sudocode.api.project.ProjectNotFoundException;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;
import org.sudocode.api.project.dto.ProjectDTO;
import org.sudocode.api.project.dto.ProjectSummary;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
//@EnableCaching
public class RepoCacheConfig {

    private final CommentRepository commentRepository;
    private final ProjectRepository projectRepository;

    public RepoCacheConfig(CommentRepository commentRepository, ProjectRepository projectRepository) {
        this.commentRepository = commentRepository;
        this.projectRepository = projectRepository;
    }

//    @Bean
//    public CacheManager cacheManager() {
//        // configure and return an implementation of Spring's CacheManager SPI
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        LoadingCache<Long, LocalDateTime> commentTimeOutCache = CacheBuilder
//
//        return cacheManager;
//    }

    @Bean
    public LoadingCache<Long, LocalDateTime> loadingCache() {
        CacheLoader<Long, LocalDateTime> loader = new CacheLoader<>() {
            @Override
            public LocalDateTime load(Long key) throws Exception {
                return commentRepository.fetchLatestByAuthorId(key);
            }
        };

        return CacheBuilder.newBuilder()
                           .expireAfterWrite(10, TimeUnit.MINUTES)
                           .maximumSize(50).build(loader);

//    }
//
//    @Bean
//    public LoadingCache<Long, Project> projectCache() {
//        CacheLoader<Long, Project> loader = new CacheLoader<Long, Project>() {
//            @Override
//            public Project load(Long key) throws ProjectNotFoundException {
//                return projectRepository.findById(key).orElseThrow(() -> new ProjectNotFoundException(key));
//            }
//        };
//
//        return CacheBuilder.newBuilder()
//                           .expireAfterWrite(10, TimeUnit.MINUTES)
//                            .maximumSize(50).build(loader);
//    }

    }

}
