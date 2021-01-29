package com.github.robertomanfreda.poc.authorization.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BaseResponse {
    private Integer httpStatus;
}
