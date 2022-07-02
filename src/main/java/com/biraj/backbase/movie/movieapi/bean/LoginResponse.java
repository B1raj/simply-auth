package com.biraj.backbase.movie.movieapi.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author birajmishra
 *Response of login 
 */
@Component
@Scope("prototype")
@Slf4j
@Data
@AllArgsConstructor
@Builder
public class LoginResponse {
																		

	private String accessToken;


	}
