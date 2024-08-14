package com.gitrepo.exception;

import com.gitrepo.common.enums.ErrorMessageEnum;
import lombok.Getter;


@Getter
public class GitRepoException extends RuntimeException {

    private final ErrorMessageEnum errorMessageEnum;

    public GitRepoException(ErrorMessageEnum errorMessageEnum) {
        super(errorMessageEnum.getMessage());
        this.errorMessageEnum = errorMessageEnum;
    }

    public GitRepoException(ErrorMessageEnum errorMessageEnum, String message) {
        super(message);
        this.errorMessageEnum = errorMessageEnum;
    }


}
