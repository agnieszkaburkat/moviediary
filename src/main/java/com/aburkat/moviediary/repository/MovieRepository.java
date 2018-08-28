package com.aburkat.moviediary.repository;

import com.aburkat.moviediary.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {


}
