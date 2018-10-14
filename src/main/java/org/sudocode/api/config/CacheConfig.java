package org.sudocode.api.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.sudocode.api.project.ProjectNotFoundException;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    private final CommentRepository commentRepository;
    private final ProjectRepository projectRepository;

    public CacheConfig(CommentRepository commentRepository, ProjectRepository projectRepository) {
        this.commentRepository = commentRepository;
        this.projectRepository = projectRepository;
    }



    @Bean
    public LoadingCache<Long, LocalDateTime> loadingCache() {
        return CacheBuilder.newBuilder()
                           .expireAfterWrite(10, TimeUnit.MINUTES)
                           .maximumSize(50)
                           .build(new CacheLoader<>() {
                               @Override
                               public LocalDateTime load(@NonNull Long key) throws Exception {
                                   var lastCommented = commentRepository.fetchLatestPostDateByAuthorId(key);
                                   var lastPosted = projectRepository.fetchLatestPostDateByAuthorId(key);

                                   return lastCommented.compareTo(lastPosted) > 0 ? lastCommented : lastPosted;
                               }
                           });

    }

}
