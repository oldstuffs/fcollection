package io.github.portlek.fcollection.service;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.repository.MovieRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * a class that represents movie services.
 */
@Service
@RequiredArgsConstructor
public class MovieService {

  /**
   * the movie repository.
   */
  @Autowired
  private final MovieRepository movieRepository;

  public Collection<Movie> getMovies(final String genre, final String name, final String performer) {
    if (genre != null) {
      return this.getMoviesByGenre(genre);
    }
    if (name != null) {
      return this.getMoviesByName(name);
    }
    if (performer != null) {
      return this.getMoviesByPerformerName(performer);
    }
    return Collections.emptySet();
  }

  /**
   * gets the movies by genre.
   *
   * @param genre the genre to get.
   *
   * @return obtained movies by genre.
   */
  public Collection<Movie> getMoviesByGenre(final String genre) {
    return this.movieRepository.findAllByGenre(genre);
  }

  /**
   * gets the movies by name.
   *
   * @param name the name to get.
   *
   * @return obtained movies by name.
   */
  public Collection<Movie> getMoviesByName(final String name) {
    return this.movieRepository.findAllByName(name);
  }

  /**
   * gets the movies by performer name.
   *
   * @param name the name to get.
   *
   * @return obtained movies by performer name.
   */
  public Collection<Movie> getMoviesByPerformerName(final String name) {
    return this.movieRepository.findAll().stream()
      .filter(movie -> movie.getPerformers().stream()
        .anyMatch(performer -> Objects.equals(performer.getName(), name)))
      .collect(Collectors.toSet());
  }
}
