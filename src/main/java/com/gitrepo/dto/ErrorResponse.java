package com.gitrepo.dto;

import com.gitrepo.exception.GitRepoException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String errorMessage;
    private String error;
    private String path;
    public int status;
}
