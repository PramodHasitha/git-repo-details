package com.gitrepo.common.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessageEnum {

    OWNER_REPO_NOT_FOUNT("Unable to find repository", HttpStatus.NOT_FOUND),

    ERROR_WHILE_RETRIEVING_DATA("Error while retrieving the repository data from GitHub.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus httpStatus;

    ErrorMessageEnum(String message, HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
