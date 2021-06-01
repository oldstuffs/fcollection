package io.github.portlek.fcollection;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.models.Performer;
import io.github.portlek.fcollection.repository.MovieRepository;
import java.time.Instant;
import java.util.Date;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FCollectionApplication {

  public static void main(final String[] args) {
    SpringApplication.run(FCollectionApplication.class, args);
  }
}
