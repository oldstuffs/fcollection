package io.github.portlek.fcollection.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * a class that represents a Movie.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Movie {

  /**
   * performer of the movie.
   */
  @ElementCollection
  @Column(
    name = "performers"
  )
  private Set<Performer> performers = new HashSet<>();

  /**
   * description of the movie.
   */
  @Column(
    name = "description"
  )
  private String description;

  /**
   * genre of the movie.
   */
  @Column(
    name = "genre"
  )
  private String genre;

  /**
   * id of the movie.
   */
  @Id
  @SequenceGenerator(
    name = "movie_sequence",
    sequenceName = "movie_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "movie_sequence"
  )
  @Column(
    name = "id",
    updatable = false
  )
  private long id;

  /**
   * media url of the movie.
   */
  @Column(
    name = "media_url"
  )
  private String mediaUrl;

  /**
   * name of the movie.
   */
  @Column(
    name = "name"
  )
  private String name;

  /**
   * released date of the movie.
   */
  @Column(
    name = "released"
  )
  private Date released;

  /**
   * supported languages of the movie.
   * <p>
   * scheme:
   * <pre>
   * (language-1),(language-2),(language-2)
   * </pre>
   */
  @ElementCollection
  @Column(
    name = "supported_languages"
  )
  private Set<String> supportedLanguages = new HashSet<>();
}
