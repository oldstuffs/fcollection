package io.github.portlek.fcollection.service;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.repository.MovieRepository;
import java.util.Collection;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

/**
 * a class that represents movie services.
 */
@Service
@RequiredArgsConstructor
public class MovieService {

  /**
   * the repository.
   */
  @Autowired
  private final MovieRepository repository;

  /**
   * gets the movies by performer name.
   *
   * @param name the name to get.
   *
   * @return obtained movies by performer name.
   */
  public Collection<Movie> getMoviesByPerformerName(final String name) {
    return Collections.emptySet();
  }
}
