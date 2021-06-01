package io.github.portlek.fcollection.controller;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.models.MovieEntry;
import io.github.portlek.fcollection.service.MovieService;
import java.util.Collection;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
   * adds the movie.
   *
   * @param entry the entry to add.
   */
  @PostMapping
  public void addMovie(@RequestBody final MovieEntry entry) {
    this.service.addMovie(entry);
  }

  /**
   * adds the movie.
   *
   * @param entry the entry to add.
   */
  @PutMapping("/{id}")
  public void changeMovie(
    @PathVariable("id") final String id,
    @RequestBody final MovieEntry entry) {
    this.service.changeMovie(id, entry);
  }

  /**
   * deletes the movie by unique id.
   *
   * @param uniqueId the unique id to delete.
   */
  @DeleteMapping("/{id}")
  public void deleteMovie(
    @PathVariable("id") final String uniqueId) {
    this.service.deleteMovie(uniqueId);
  }

  /**
   * gets the movies by genre, name, performer.
   *
   * @param genre the genre to get.
   * @param name the name to get.
   * @param performer the performer to get.
   * @param sortByDate the sort by date to get.
   *
   * @return obtained movies by genre, name, performer.
   */
  @GetMapping
  public Collection<Movie> getMovies(
    @RequestParam(name = "genre", required = false) final String genre,
    @RequestParam(name = "name", required = false) final String name,
    @RequestParam(name = "performer", required = false) final String performer,
    @RequestParam(name = "sortByDate", required = false) final boolean sortByDate) {
    return this.service.getMovies(genre, name, performer, sortByDate);
  }
}
