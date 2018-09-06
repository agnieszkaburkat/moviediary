package com.aburkat.moviediary.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;
  private String alternativeTitle;
  private String cast;
  private String imageUrl;
  private Integer premiereYear;
  private Long filmwebId;
  private String remarks;

 // private Genre genre;
  private String director;
  private float ranting;

}
