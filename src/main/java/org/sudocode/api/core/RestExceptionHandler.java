package org.sudocode.api.core;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.sudocode.api.project.NotPostAuthorException;
import org.sudocode.api.project.domain.InvalidDifficultyException;
import org.sudocode.api.project.ProjectNotFoundException;
import org.sudocode.api.user.UserNotLoggedInException;

import static org.springframework.hateoas.MediaTypes.*;

@RestControllerAdvice(annotations = RestController.class)
@RequestMapping(produces = HAL_JSON_VALUE)
public class RestExceptionHandler {

    @ExceptionHandler(ProjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public VndErrors projectNotFound(ProjectNotFoundException ex) {
        return new VndErrors("404", ex.getMessage());
    }

    @ExceptionHandler(InvalidDifficultyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public VndErrors invalidDifficulty(InvalidDifficultyException ex) {
        return new VndErrors("400", ex.getMessage());
    }

    @ExceptionHandler(UserNotLoggedInException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public VndErrors notLoggedIn(UserNotLoggedInException ex) {
        return new VndErrors("401", ex.getMessage());
    }

    @ExceptionHandler(NotPostAuthorException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public VndErrors notPostAuthor(NotPostAuthorException ex) {
        return new VndErrors("401", ex.getMessage());
    }
}
