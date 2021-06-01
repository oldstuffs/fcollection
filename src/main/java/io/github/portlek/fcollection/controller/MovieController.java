package io.github.portlek.fcollection.controller;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.service.MovieService;
import java.util.Collection;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a class that represents movie controller.
 */
@Data
@RestController
@RequestMapping("movie")
@RequiredArgsConstructor
public class MovieController {

  /**
   * the service.
   */
  @Autowired
  private final MovieService service;

  /**
   * gets the movies by genre.
   *
   * @param name the name to get.
   *
   * @return obtained movies by genre.
   */
  @GetMapping("/genre/{genre}")
  public Collection<Movie> getMoviesByGenre(
    @PathVariable("genre") final String name) {
    return this.service.getMoviesByGenre(name);
  }

  /**
   * gets the movies by name.
   *
   * @param name the name to get.
   *
   * @return obtained movies by name.
   */
  @GetMapping("/name/{name}")
  public Collection<Movie> getMoviesByName(
    @PathVariable("name") final String name) {
    return this.service.getMoviesByName(name);
  }

  /**
   * gets the movies by performer name.
   *
   * @param name the name to get.
   *
   * @return obtained movies by performer name.
   */
  @GetMapping("/performer/{name}")
  public Collection<Movie> getMoviesByPerformerName(
    @PathVariable("name") final String name) {
    return this.service.getMoviesByPerformerName(name);
  }
}
