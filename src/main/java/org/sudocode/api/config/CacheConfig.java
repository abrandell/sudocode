package org.sudocode.api.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    private final CommentRepository commentRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public CacheConfig(CommentRepository commentRepository, ProjectRepository projectRepository) {
        this.commentRepository = commentRepository;
        this.projectRepository = projectRepository;
    }


    /**
     * LoadingCache that fetches the last {@link LocalDateTime} of the most recent postProject a user made by their ID.<br>
     * Returns the most recent date between both the latest {@link Project} and {@link Comment} made.<br>
     * <p>
     * This is mainly to check if a user is spamming/posting too often.
     *
     * @return LoadingCache that fetches both dates (if they exist) for the last {@link Project} and {@link Comment} posted.
     *         The load function returns the latest.
     * @see LoadingCache
     */
    @Bean
    public LoadingCache<Long, LocalDateTime> loadingCache() {
        return CacheBuilder.newBuilder()
                           .expireAfterWrite(6, TimeUnit.MINUTES)
                           .maximumSize(100)
                           .build(new CacheLoader<>() {
                               @Override
                               public LocalDateTime load(@NonNull Long userId) {
                                   var lastCommented = commentRepository.fetchLatestPostDateByAuthorId(userId);
                                   var lastPosted = projectRepository.fetchLatestPostDateByAuthorId(userId);

                                   return lastCommented.compareTo(lastPosted) > 0 ? lastCommented : lastPosted;
                               }
                           });

    }

}
