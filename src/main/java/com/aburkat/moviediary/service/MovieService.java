package com.aburkat.moviediary.service;

import com.aburkat.moviediary.filmweb.FilmwebApiProxy;
import com.aburkat.moviediary.filmweb.FilmwebLibrary;
import com.aburkat.moviediary.model.Movie;
import com.aburkat.moviediary.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  private FilmwebLibrary filmwebApi = new FilmwebApiProxy();

  public List<Movie> findMoviesByTitle(String title) {
    List<Movie> filmSearchResults = filmwebApi.findMoviesByTitle(title);
    return filmSearchResults;
  }

}
