package io.github.portlek.fcollection.models;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * a class that represents a Movie.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Movie")
@Table(name = "movie")
public class Movie {

  /**
   * description of the movie.
   */
  @Column(
    name = "description",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String description;

  /**
   * genre of the movie.
   */
  @Column(
    name = "genre",
    nullable = false,
    columnDefinition = "TEXT"
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
    name = "media_url",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String mediaUrl;

  /**
   * name of the movie.
   */
  @Column(
    name = "name",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String name;

  /**
   * performer of the movie.
   */
  @ManyToMany(
    targetEntity = Performer.class,
    cascade = CascadeType.ALL
  )
  private Set<Performer> performers;

  /**
   * released date of the movie.
   */
  @Column(
    name = "released",
    nullable = false
  )
  private Date released;

  /**
   * supported languages of the movie.
   */
  @ElementCollection(targetClass = String.class)
  @JoinTable(
    name = "supported_languages"
  )
  private Set<String> supportedLanguages;

  /**
   * ctor.
   *
   * @param name the name.
   * @param description the description.
   * @param genre the genre.
   * @param mediaUrl the media url.
   * @param performers the performers.
   * @param released the release.
   * @param supportedLanguages the supported languages.
   */
  public Movie(final String name, final String description, final String genre, final String mediaUrl,
               final Set<Performer> performers, final Date released, final Set<String> supportedLanguages) {
    this.name = name;
    this.description = description;
    this.genre = genre;
    this.mediaUrl = mediaUrl;
    this.performers = performers;
    this.released = released;
    this.supportedLanguages = supportedLanguages;
  }
}
