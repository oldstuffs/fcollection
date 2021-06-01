package io.github.portlek.fcollection.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * a class that represents a Performer.
 */
@Getter
@Setter
@NoArgsConstructor
public class Performer {

  /**
   * last name of the performer.
   */
  private String lastName;

  /**
   * name of the performer.
   */
  private String name;

  /**
   * role of the performer.
   */
  private String role;

  /**
   * ctor.
   *
   * @param name the name.
   * @param lastName the last name.
   * @param role the role.
   */
  public Performer(final String name, final String lastName, final String role) {
    this.name = name;
    this.lastName = lastName;
    this.role = role;
  }

  /**
   * ctor.
   *
   * @param lastName the last name.
   * @param name the name.
   */
  public Performer(final String name, final String lastName) {
    this(name, lastName, null);
  }
}
