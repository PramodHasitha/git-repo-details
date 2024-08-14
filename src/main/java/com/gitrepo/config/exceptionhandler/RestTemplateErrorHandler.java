package com.gitrepo.config.exceptionhandler;

import com.gitrepo.common.enums.ErrorMessageEnum;
import com.gitrepo.exception.GitRepoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError()
                || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new GitRepoException(ErrorMessageEnum.OWNER_REPO_NOT_FOUNT);
        }

        throw new GitRepoException(ErrorMessageEnum.ERROR_WHILE_RETRIEVING_DATA);
    }
}
