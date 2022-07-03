package com.biraj.backbase.movie.movieapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rating implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @Id
    private Users userId;
    @Id
    private String movie;
    private double rating;
}
