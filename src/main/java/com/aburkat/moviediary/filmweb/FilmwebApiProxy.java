package com.aburkat.moviediary.filmweb;

import com.aburkat.moviediary.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Proxy class for using to gain access to filmweb api.
 */
@Service
public class FilmwebApiProxy implements FilmwebLibrary {

  private FilmwebLibrary filmwebImpl;

  /**
   * Method returning list of movies matching the input criteria.
   *
   * @param title movie title to be found
   * @return list of {@link Movie} objects with title like {@param title}
   */
  @Override
  public List<Movie> findMoviesByTitle(String title) {
    if (filmwebImpl == null) filmwebImpl = new FilmwebImpl();
    return filmwebImpl.findMoviesByTitle(title);
  }

  public void checkConnection() {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, "filmweb connection checkup"));
    executorService.scheduleAtFixedRate(() -> System.out.println("lol"), 10, 30, TimeUnit.SECONDS);
  }

}
