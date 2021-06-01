package io.github.portlek.fcollection.repository;

import io.github.portlek.fcollection.models.Movie;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * an interface that determines movie repository.
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {

  /**
   * finds all movies by genre.
   *
   * @param genre the genre to find.
   *
   * @return found movies by genre.
   */
  Collection<Movie> findAllByGenre(String genre);

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
  default Collection<Movie> findAllByGenreOrNameOrPerformer(final String genre, final String name,
                                                            final String performer, final boolean sortByDate) {
    final List<Movie> movies;
    if (sortByDate) {
      final var sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "released"));
      movies = this.findAll(sort);
    } else {
      movies = this.findAll();
    }
    return movies.stream()
      .filter(movie -> {
        final var genreControl = genre == null || Objects.equals(movie.getGenre(), genre);
        if (!genreControl) {
          return false;
        }
        final var nameControl = name == null || Objects.equals(movie.getName(), name);
        if (!nameControl) {
          return false;
        }
        final var performerControl = performer == null || movie.getPerformers().stream()
          .anyMatch(perf -> Objects.equals(perf.getName(), performer));
        return performerControl;
      })
      .collect(Collectors.toList());
  }

  /**
   * finds all movies by name.
   *
   * @param name the name to find.
   *
   * @return found movies by name.
   */
  Collection<Movie> findAllByName(String name);

  /**
   * gets the movies by performer name.
   *
   * @param name the name to get.
   *
   * @return obtained movies by performer name.
   */
  default Collection<Movie> findAllByPerformerName(final String name) {
    return this.findAll().stream()
      .filter(movie -> movie.getPerformers().stream()
        .anyMatch(performer -> Objects.equals(performer.getName(), name)))
      .collect(Collectors.toSet());
  }
}
