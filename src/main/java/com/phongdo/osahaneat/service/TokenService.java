package com.phongdo.osahaneat.service;

import com.phongdo.osahaneat.domain.model.TokenPayload;
import com.phongdo.osahaneat.exception.AppException;

public interface TokenService {
    String generateAccessToken(TokenPayload payload);

    TokenPayload validateAccessToken(String token) throws AppException;
}
