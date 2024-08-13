package com.gitrepo.exception.handler;

import com.gitrepo.dto.ErrorResponse;
import com.gitrepo.exception.GitRepoException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = GitRepoException.class)
    public @ResponseBody ErrorResponse handleException(GitRepoException ex) {
        return new ErrorResponse(ex);
    }
}
