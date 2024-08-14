package com.gitrepo.config.exceptionhandler;

import com.gitrepo.dto.ErrorResponse;
import com.gitrepo.exception.GitRepoException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = GitRepoException.class)
    public @ResponseBody ErrorResponse handleException(GitRepoException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getErrorMessageEnum().getMessage());
        errorResponse.setStatus(ex.getErrorMessageEnum().getHttpStatus().value());
        errorResponse.setError(ex.getErrorMessageEnum().getHttpStatus().getReasonPhrase());
        errorResponse.setPath(request.getDescription(false).substring(4));
        errorResponse.setTimestamp(LocalDateTime.now());

        return errorResponse;
    }
}
