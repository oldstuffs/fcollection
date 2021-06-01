package io.github.portlek.fcollection.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * a class that represents a Performer.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Performer")
@Table(name = "performers")
public class Performer {

  /**
   * id of the performer.
   */
  @Id
  @GeneratedValue
  private long id;

  /**
   * last name of the performer.
   */
  @Column(
    name = "last_name",
    nullable = false
  )
  private String lastName;

  /**
   * name of the performer.
   */
  @Column(
    name = "name",
    nullable = false
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
