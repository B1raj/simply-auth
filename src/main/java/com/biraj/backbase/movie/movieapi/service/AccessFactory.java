package com.biraj.backbase.movie.movieapi.service;

import javax.servlet.http.HttpServletRequest;

import com.biraj.backbase.movie.movieapi.bean.AccessToken;
import com.biraj.backbase.movie.movieapi.bean.AccessTokenPayload;
import com.biraj.backbase.movie.movieapi.bean.UserInfo;
import com.biraj.backbase.movie.movieapi.bean.UserTokens;
import com.biraj.backbase.movie.movieapi.exception.AccessTokenException;
import com.biraj.backbase.movie.movieapi.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author birajmishra
 */
@Component
@Slf4j
public class AccessFactory {
	@Autowired
	private JwtTokenService tokenUtil;

	@Autowired
	HttpServletRequest request;

	@Value("${accesstoken.issuer}")
	private String accessTokenIssuer;

	@Value("${accesstoken.audience}")
	private String audience;

	@Value("${jwt.secret}")
	private String secret;

	public UserTokens createToken(UserInfo userInfo) {
		UserTokens response = new UserTokens();
		// fetch profile

		// prepare token payload
		AccessTokenPayload payload = computeAccessTokenPayload(userInfo, accessTokenIssuer);

		// create token
		response.setAccessToken(tokenUtil.generateAccessToken(payload, secret));

		log.info("AccessTokenFactory : access token geneated for  user: {} ", userInfo.getUsername());
		if (log.isTraceEnabled()) {
			log.trace("AccessTokenFactory : createToken : response : " + response.toString());
		}
		return response;
	}

	public AccessToken verifyAccessToken(String accessToken) throws AccessTokenException {
		log.info("AccessTokenFactory : verifyAccessToken : verifying access token {}", accessToken);
		AccessToken token = tokenUtil.verifyAccessToken(accessToken, secret);
		return token;
	}


	private AccessTokenPayload computeAccessTokenPayload(UserInfo userInfo, String iss) {

		AccessTokenPayload payload = new AccessTokenPayload();
		payload.setIssuer(iss);
		payload.setIssuedDate(DateUtil.currentDate());
		payload.setAudience(audience);

		if (log.isTraceEnabled()) {
			log.trace("AccessTokenFactory : computeAccessTokenPayload : payload : " + payload.toString());
		}
		return payload;
	}

}
