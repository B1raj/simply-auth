package com.biraj.backbase.movie.movieapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author birajmishra
 * User Entity
 */



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movies {
	@EmbeddedId
	private MovieKey movieKey;
	private String category;

	//@OneToMany(mappedBy="movie")
	//private Set<Rating> ratings;
}