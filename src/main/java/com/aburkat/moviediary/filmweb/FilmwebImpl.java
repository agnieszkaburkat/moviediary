package com.aburkat.moviediary.filmweb;

import com.aburkat.moviediary.model.Movie;
import info.talacha.filmweb.api.FilmwebApi;
import info.talacha.filmweb.search.models.FilmSearchResult;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilmwebImpl implements FilmwebLibrary {

  private FilmwebApi filmwebApi = new FilmwebApi();


  @Override
  public List<Movie> findMoviesByTitle(String title) {
    List<FilmSearchResult> filmSearchResults = filmwebApi.findFilm(title);
    return filmSearchResults.stream().map(FilmwebImpl::mapToMovie).collect(toList());
  }

  private static Movie mapToMovie(FilmSearchResult filmSearchResult) {
    return Movie.builder()
        .cast(filmSearchResult.getCast())
        .title(filmSearchResult.getTitle())
        .alternativeTitle(filmSearchResult.getPolishTitle())
        .premiereYear(filmSearchResult.getYear())
        .remarks(String.join(" , ", filmSearchResult.getAlternativeTitle(), filmSearchResult.getImageURL(), filmSearchResult.getId().toString()))
        .build();
  }
}
