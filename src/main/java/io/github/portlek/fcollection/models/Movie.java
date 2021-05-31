package io.github.portlek.fcollection.models;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table
public class Movie {

  /**
   * description of the movie.
   */
  @Column(
    nullable = false
  )
  private String description;

  /**
   * genre of the movie.
   */
  @Column(
    nullable = false
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
    updatable = false
  )
  private long id;

  /**
   * media url of the movie.
   */
  @Column(
    name = "media_url",
    nullable = false
  )
  private String mediaUrl;

  /**
   * name of the movie.
   */
  @Column(
    nullable = false
  )
  private String name;

  /**
   * performer of the movie.
   */
  @ElementCollection
  @Column(
    nullable = false
  )
  private Set<Performer> performers;

  /**
   * released date of the movie.
   */
  @Column(
    nullable = false
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
    name = "supported_languages",
    nullable = false
  )
  private Set<String> supportedLanguages;
}
