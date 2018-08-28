package com.aburkat.moviediary.controller;

import com.aburkat.moviediary.model.Movie;
import com.aburkat.moviediary.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "api/movie/")
public class MoviesController {

  @Autowired
  private MovieService movieService;

  @RequestMapping(value = "{title}/filmweb", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Movie>> findByTitle(@PathVariable String title) throws Exception {
    List<Movie> listCreated = movieService.findMoviesByTitle(title);
    return new ResponseEntity<>(listCreated, HttpStatus.OK);
  }
}
