package io.github.portlek.fcollection;

import io.github.portlek.fcollection.models.Language;
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

  @Bean
  public CommandLineRunner commandLineRunner(final MovieRepository repository) {
    return args -> {
      final var performer = new Performer("Hasan", "Demirtaş");
      final var languages = Set.of(new Language("tr_TR"), new Language("en_US"));
      final var movie1 = new Movie(
        "Movie 1",
        "fdese",
        "asdasd",
        "aslşdjasd",
        Set.of(performer),
        Date.from(Instant.now()),
        languages);
      final var movie2 = new Movie(
        "Movie 2",
        "fdese",
        "asdasd",
        "aslşdjasd",
        Set.of(performer),
        Date.from(Instant.now()),
        languages);
      repository.saveAll(Set.of(movie1, movie2));
    };
  }
}
