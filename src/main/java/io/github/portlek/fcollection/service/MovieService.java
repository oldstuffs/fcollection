package io.github.portlek.fcollection.service;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.repository.MovieRepository;
import io.github.portlek.fcollection.repository.PerformerRepository;
import java.util.ArrayList;
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
   * the performer repository.
   */
  @Autowired
  private final PerformerRepository performerRepository;

  /**
   * gets the movies by performer name.
   *
   * @param name the name to get.
   *
   * @return obtained movies by performer name.
   */
  public Collection<Movie> getMoviesByPerformerName(final String name) {
    final var movies = new ArrayList<Movie>();
    final var performers = this.performerRepository.findAllByName(name);
    // SELECT * FROM movie_performers  WHERE performers_id = 3;
    performers.forEach(performer -> {
    });
    return movies;
  }
}
