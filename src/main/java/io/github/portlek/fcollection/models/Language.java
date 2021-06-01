package io.github.portlek.fcollection.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Language")
@Table(name = "supported_languages")
public class Language {

  @Id
  @GeneratedValue
  @Column(
    name = "id",
    updatable = false
  )
  private long id;

  @Column(
    name = "language",
    unique = true
  )
  private String language;

  public Language(final String language) {
    this.language = language;
  }
}
