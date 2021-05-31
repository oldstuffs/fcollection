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
public class Performer {

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
   * last name of the performer.
   */
  @Column(
    name = "last_name"
  )
  private String lastName;
}
