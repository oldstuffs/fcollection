package io.github.portlek.fcollection.service;

import io.github.portlek.fcollection.models.Movie;
import io.github.portlek.fcollection.models.MovieEntry;
import io.github.portlek.fcollection.repository.MovieRepository;
import java.util.Collection;
import java.util.Optional;
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
   * adds the movie.
   *
   * @param entry the entry to add.
   *
   * @return added movie.
   */
  public Movie addMovie(final MovieEntry entry) {
    return this.movieRepository.save(entry.createMovie());
  }

  /**
   * changes the movie.
   *
   * @param id the id to change.
   * @param entry the entry to change.
   */
  public Optional<Movie> changeMovie(final String id, final MovieEntry entry) {
    final var movie = this.movieRepository.findByUniqueId(id);
    if (movie.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(this.movieRepository.save(entry.createMovie(movie.get().getUniqueId())));
  }

  /**
   * deletes the movie by unique id.
   *
   * @param uniqueId the unique id to delete.
   */
  public void deleteMovie(final String uniqueId) {
    this.movieRepository.deleteByUniqueId(uniqueId);
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
  public Collection<Movie> getMovies(final String genre, final String name, final String performer,
                                     final boolean sortByDate) {
    return this.movieRepository.findAllByGenreOrNameOrPerformer(genre, name, performer, sortByDate);
  }
}
