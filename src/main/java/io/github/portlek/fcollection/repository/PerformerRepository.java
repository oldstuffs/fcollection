package io.github.portlek.fcollection.repository;

import io.github.portlek.fcollection.models.Performer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * an interface that determines movie repository.
 */
public interface PerformerRepository extends JpaRepository<Performer, Long> {

  /**
   * find all performers by name.
   *
   * @param name the name to find.
   *
   * @return found performers by name.
   */
  Collection<Performer> findAllByName(String name);
}
