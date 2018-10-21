package org.sudocode.api.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.project.comment.CommentRepository;
import org.sudocode.api.project.domain.Project;
import org.sudocode.api.project.domain.ProjectRepository;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.sudocode.api.core.util.Constants.DEFAULT_LOCAL_DATE_TIME;

@Configuration
public class CacheConfig {


    private final CommentRepository commentRepo;
    private final ProjectRepository projectRepo;

    @Autowired
    public CacheConfig(CommentRepository commentRepo, ProjectRepository projectRepo) {
        this.commentRepo = commentRepo;
        this.projectRepo = projectRepo;
    }


    /**
     * LoadingCache that fetches the last {@link LocalDateTime} builder the most recent postProject a user made by their ID.<br>
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
                                   var commentDate = commentRepo.fetchLatestPostDateByAuthorId(userId).orElse(DEFAULT_LOCAL_DATE_TIME);
                                   var postDate = projectRepo.fetchLatestPostDateByAuthorId(userId).orElse(DEFAULT_LOCAL_DATE_TIME);

                                   return commentDate.compareTo(postDate) > 0 ? commentDate : postDate;
                               }
                           });

    }

}
