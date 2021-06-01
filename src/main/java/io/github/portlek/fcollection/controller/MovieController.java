package io.github.portlek.fcollection.controller;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.service.MovieService;
import java.util.Collection;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a class that represents movie controller.
 */
@Data
@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {

  /**
   * the service.
   */
  @Autowired
  private final MovieService service;

  /**
   * gets the movies by genre, name, performer.
   *
   * @param genre the genre to get.
   *
   * @return obtained movies by genre, name, performer.
   */
  @GetMapping
  public Collection<Movie> getMovies(
    @Param("genre") final String genre,
    @Param("name") final String name,
    @Param("performer") final String performer) {
    return this.service.getMovies(genre, name, performer);
  }
}
