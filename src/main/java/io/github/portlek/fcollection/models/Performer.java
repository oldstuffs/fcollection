package io.github.portlek.fcollection.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * a class that represents a Performer.
 */
@Getter
@Setter
@Embeddable
public final class Performer {

  /**
   * name of the performer.
   */
  @Column(
    name = "name"
  )
  private String name;

  /**
   * role of the performer.
   */
  @Column(
    name = "role"
  )
  private String role;

  /**
   * surname of the performer.
   */
  @Column(
    name = "surname"
  )
  private String surname;
}
