package com.github.robertomanfreda.poc.authorization.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LoginResponse extends BaseResponse {
    private String sessionID;

    @Builder
    public LoginResponse(String sessionID, Integer httpStatus) {
        super(httpStatus);
        this.sessionID = sessionID;
    }
}