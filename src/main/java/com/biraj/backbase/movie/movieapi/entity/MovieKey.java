package com.biraj.backbase.movie.movieapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.List;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieKey implements Serializable {

    @Column(nullable = false)
    private int releaseYear;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean isAwarded;

}

