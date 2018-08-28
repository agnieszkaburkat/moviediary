package com.aburkat.moviediary;

import com.aburkat.moviediary.filmweb.FilmwebApiProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class MultimediaApplication {

  public static void main(String[] args) {
    FilmwebApiProxy.checkConnection(); // <-- here
    SpringApplication.run(MultimediaApplication.class, args);
  }

}
