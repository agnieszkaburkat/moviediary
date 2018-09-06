package com.aburkat.moviediary.filmweb;

import com.aburkat.moviediary.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Proxy class used to gain access to filmweb api.
 */
@Service
@Slf4j
public class FilmwebApiProxy implements FilmwebLibrary {

  private static RestTemplate restTemplate = new RestTemplate();
  private FilmwebLibrary filmwebImpl;
  private static final String filwebSearchUrl = "http://www.filmweb.pl/search/live?q=alien";

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

  public static void checkConnection() {
    ResponseEntity<String> forEntity = restTemplate.getForEntity(getUrl(), String.class);
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, "filmweb connection checkup"));
    executorService.scheduleAtFixedRate(() -> {
      HttpStatus statusCode = forEntity.getStatusCode();
      if (statusCode.equals(HttpStatus.OK)) {
        log.info("Connecting to filmweb, status: " + statusCode);
      } else {
        log.error("Connecting to filmweb failed, status code: " + statusCode);
      }
    }, 10, 30, TimeUnit.SECONDS);
  }

  private static String getUrl() {
    return UriComponentsBuilder.fromHttpUrl(filwebSearchUrl).build().toUri().toASCIIString();
  }

}
