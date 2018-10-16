package org.sudocode.api.project.comment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.TimeOutService;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.user.UserService;

@Service
@Transactional(
        readOnly = true,
        rollbackFor = Exception.class
)
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProjectService projectService;
    private final TimeOutService timeOutService;
    private static final Log LOG = LogFactory.getLog(CommentService.class);

    @Autowired
    public CommentService(CommentRepository commentRepository, UserService userService,
                          ProjectService projectService, TimeOutService timeOutService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.projectService = projectService;
        this.timeOutService = timeOutService;
    }
}
