package com.biraj.backbase.movie.movieapi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author birajmishra
 * User Entity
 */



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {
	@Id
	private String userid;
	private String password;
}