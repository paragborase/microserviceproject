package com.lcwd.rating.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="user_ratings")
public class Rating {
    @Id 
    @Column(name= "ID")
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}