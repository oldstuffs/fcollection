package io.github.portlek.fcollection.repository;

import io.github.portlek.fcollection.models.Movie;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * an interface that determines movie repository.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  /**
   * finds all movies by genre.
   *
   * @param genre the genre to find.
   *
   * @return found movies by genre.
   */
  Collection<Movie> findAllByGenre(String genre);

  /**
   * finds all movies by name.
   *
   * @param name the name to find.
   *
   * @return found movies by name.
   */
  Collection<Movie> findAllByName(String name);
}
