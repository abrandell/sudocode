package org.sudocode.api.core;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.sudocode.api.core.exceptions.CommentNotFoundException;
import org.sudocode.api.core.exceptions.InvalidDifficultyException;
import org.sudocode.api.core.exceptions.NotPostAuthorException;
import org.sudocode.api.core.exceptions.ProjectNotFoundException;
import org.sudocode.api.core.exceptions.TooManyRequestException;
import org.sudocode.api.core.exceptions.UserNotFoundException;
import org.sudocode.api.core.exceptions.UserNotLoggedInException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice(annotations = RestController.class)
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProjectNotFoundException.class)
	@ResponseStatus(NOT_FOUND)
	public VndErrors projectNotFound(ProjectNotFoundException ex) {
		return new VndErrors(NOT_FOUND.toString(), ex.getMessage());
	}

	@ExceptionHandler(InvalidDifficultyException.class)
	@ResponseStatus(BAD_REQUEST)
	public VndErrors invalidDifficulty(InvalidDifficultyException ex) {
		return new VndErrors(BAD_REQUEST.toString(), ex.getMessage());
	}

	@ExceptionHandler(UserNotLoggedInException.class)
	@ResponseStatus(UNAUTHORIZED)
	public VndErrors notLoggedIn(UserNotLoggedInException ex) {
		return new VndErrors(UNAUTHORIZED.toString(), ex.getMessage());
	}

	@ExceptionHandler(NotPostAuthorException.class)
	@ResponseStatus(UNAUTHORIZED)
	public VndErrors notPostAuthor(NotPostAuthorException ex) {
		return new VndErrors(UNAUTHORIZED.toString(), ex.getMessage());
	}

	@ExceptionHandler(TooManyRequestException.class)
	@ResponseStatus(TOO_MANY_REQUESTS)
	public VndErrors tooManyRequests(TooManyRequestException ex) {
		return new VndErrors(TOO_MANY_REQUESTS.toString(), ex.getMessage());
	}

	@ExceptionHandler(CommentNotFoundException.class)
	@ResponseStatus(NOT_FOUND)
	public VndErrors commentNotFound(CommentNotFoundException ex) {
		return new VndErrors(NOT_FOUND.toString(), ex.getMessage());
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(NOT_FOUND)
	public VndErrors userNotFound(UserNotFoundException ex) {
		return new VndErrors(NOT_FOUND.toString(), ex.getMessage());
	}
}
