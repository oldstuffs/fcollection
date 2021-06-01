package io.github.portlek.fcollection.service;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.repository.MovieRepository;
import java.util.Collection;
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
  public Collection<Movie> getMovies(final String genre, final String name, final String performer,
                                     final boolean sortByDate) {
    return this.movieRepository.findAllByGenreOrNameOrPerformer(genre, name, performer, sortByDate);
  }
}
