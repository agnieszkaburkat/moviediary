package com.aburkat.moviediary.filmweb;

import com.aburkat.moviediary.model.Movie;

import java.util.List;

public interface FilmwebLibrary {

  List<Movie> findMoviesByTitle(String title);

}
