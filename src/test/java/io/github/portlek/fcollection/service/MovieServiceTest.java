package io.github.portlek.fcollection.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.github.portlek.fcollection.models.MovieEntry;
import io.github.portlek.fcollection.models.Performer;
import io.github.portlek.fcollection.repository.MovieRepository;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
final class MovieServiceTest {

  @Autowired
  private MovieRepository repository;

  @Autowired
  private MovieService service;

  @Test
  @Order(0)
  void addMovie() {
    final var entry = new MovieEntry(
      "description",
      "genre",
      "mediaUrl",
      "name",
      List.of(new Performer("performer-name", "performer-last-name", "performer-rol")),
      Date.from(Instant.now()),
      List.of("tr_TR", "en_US"));
    final var movie = this.service.addMovie(entry);
    assertTrue(this.repository.findByUniqueId(movie.getUniqueId()).isPresent(),
      "The movie couldn't added into the database!");
  }

  @Test
  @Order(2)
  void changeMovie() {
    final var expectedMovieName = "name";
    final var movie = this.service.getMovies(null, expectedMovieName, null, false).stream()
      .findFirst()
      .orElseThrow(() ->
        new IllegalStateException(String.format("Movie called %s not found!", expectedMovieName)));
    final var entry = new MovieEntry(
      "description-2",
      "genre-2",
      "mediaUrl-2",
      "name-2",
      movie.getPerformers(),
      movie.getReleased(),
      movie.getSupportedLanguages());
    final var changedMovie = this.service.changeMovie(movie.getUniqueId(), entry)
      .orElseThrow(() ->
        new IllegalStateException("The movie couldn't changed because it's not found!"));
    assertEquals("name-2", changedMovie.getName(), "The movie's names couldn't change!");
  }

  @Test
  @Order(3)
  void deleteMovie() {
    final var expectedMovieName = "name-2";
    final var movie = this.service.getMovies(null, expectedMovieName, null, false).stream()
      .findFirst()
      .orElseThrow(() ->
        new IllegalStateException(String.format("Movie called %s not found!", expectedMovieName)));
    this.service.deleteMovie(movie.getUniqueId());
    assertTrue(this.service.getMovies(null, "name-2", null, false).isEmpty(),
      String.format("The movie called %s couldn't delete!", expectedMovieName));
  }

  @Test
  @Order(1)
  void getMovies() {
    assertFalse(this.service.getMovies(null, "name", null, false).isEmpty(),
      "Any movie couldn't find!");
  }
}