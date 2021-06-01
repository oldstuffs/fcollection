package io.github.portlek.fcollection.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * a class that represents a Language.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Language")
@Table(name = "supported_languages")
public class Language {

  /**
   * id of the language.
   */
  @Id
  @SequenceGenerator(
    name = "supported_language_sequence",
    sequenceName = "supported_language_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "supported_language_sequence"
  )
  @Column(
    name = "id",
    updatable = false
  )
  private long id;

  /**
   * language name of the language.
   */
  @Column(
    name = "language",
    unique = true
  )
  private String language;

  /**
   * ctor.
   *
   * @param language the language.
   */
  public Language(final String language) {
    this.language = language;
  }
}
