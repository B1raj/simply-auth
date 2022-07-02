package com.biraj.backbase.movie.movieapi.repository;

import com.biraj.backbase.movie.movieapi.entity.Users;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

/**
 * @author birajmishra
 */
public interface UserRepository extends CrudRepository<Users, Integer> {

	Optional<Users> findByUserid(String userid);

}