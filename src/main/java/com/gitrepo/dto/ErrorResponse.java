package com.gitrepo.dto;

import com.gitrepo.exception.GitRepoException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String errorMessage;
    public int status;

    public ErrorResponse(GitRepoException ex) {
        this.errorMessage = ex.getErrorMessageEnum().getMessage();
        this.status = ex.getErrorMessageEnum().getHttpStatus().value();
    }
}
