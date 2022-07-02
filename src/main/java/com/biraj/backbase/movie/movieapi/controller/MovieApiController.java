package com.biraj.backbase.movie.movieapi.controller;

import com.biraj.backbase.movie.movieapi.bean.AuthenticatorResponse;
import com.biraj.backbase.movie.movieapi.bean.LoginResponse;
import com.biraj.backbase.movie.movieapi.bean.UserTokens;
import com.biraj.backbase.movie.movieapi.constant.MovieConstant;
import com.biraj.backbase.movie.movieapi.exception.AuthenticationException;
import com.biraj.backbase.movie.movieapi.service.AccessFactory;
import com.biraj.backbase.movie.movieapi.service.AuthenticatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping(value = "/v1/api")
public class MovieApiController {

    @Autowired
    private AccessFactory tokenFactory;

    @Autowired
    AuthenticatorService authenticatorService;


    @PostMapping(value = "/login")
    private ResponseEntity<LoginResponse> login(HttpServletRequest request,
                                                @RequestHeader(value = MovieConstant.UUID) String uuid,
                                                @RequestHeader(value = MovieConstant.AUTHORIZATION) String authorization)
            throws AuthenticationException {

        // 1. verify credentials
        AuthenticatorResponse response = authenticatorService.authenticate(authorization);
        // 2. generate JWT
        UserTokens userToken = tokenFactory.createToken(response.getUserInfo());
        log.info("User Token's successfully created.");
        if (log.isTraceEnabled()) log.trace("MovieApiController :  login : userToken : " + userToken);
        // 3. return
        return new ResponseEntity(LoginResponse.builder().accessToken(userToken.getAccessToken()).build(), HttpStatus.CREATED);
    }

}
