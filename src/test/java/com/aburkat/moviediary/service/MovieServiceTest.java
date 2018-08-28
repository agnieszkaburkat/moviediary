package com.aburkat.moviediary.service;

import com.aburkat.moviediary.filmweb.FilmwebLibrary;
import com.aburkat.moviediary.model.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

  @Mock
  FilmwebLibrary filmwebLibrary;

  @InjectMocks
  MovieService movieService;

  @Test
  public void findMoviesByTitleReturnsMovies() {
    String testingTitle = "testingTitle";
    when(filmwebLibrary.findMoviesByTitle(testingTitle)).thenReturn(moviesList());
    assertThat(movieService.findMoviesByTitle(testingTitle), hasSize(2));
  }

  private List<Movie> moviesList() {
    return Arrays.asList(
        Movie.builder().title("First movie").build(),
        Movie.builder().title("Second movie").build()
    );
  }
}