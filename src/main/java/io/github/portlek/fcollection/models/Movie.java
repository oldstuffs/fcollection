package io.github.portlek.fcollection.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * a class that represents a Movie.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "Movies")
public class Movie {

  /**
   * description of the movie.
   */
  private String description;

  /**
   * genre of the movie.
   */
  private String genre;

  /**
   * media url of the movie.
   */
  private String mediaUrl;

  /**
   * name of the movie.
   */
  private String name;

  /**
   * performers of the movie.
   */
  private Collection<Performer> performers;

  /**
   * released date of the movie.
   */
  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date released;

  /**
   * supported languages of the movie.
   */
  private Collection<String> supportedLanguages;

  /**
   * unique id of the movie.
   */
  @Id
  private String uniqueId;

  /**
   * ctor.
   *
   * @param uniqueId the unique id.
   * @param name the name.
   * @param description the description.
   * @param genre the genre.
   * @param mediaUrl the media url.
   * @param performers the performers.
   * @param released the release.
   * @param supportedLanguages the supported languages.
   */
  public Movie(final String uniqueId, final String name, final String description, final String genre,
               final String mediaUrl, final Collection<Performer> performers, final Date released,
               final Collection<String> supportedLanguages) {
    this.uniqueId = uniqueId;
    this.name = name;
    this.description = description;
    this.genre = genre;
    this.mediaUrl = mediaUrl;
    this.performers = performers;
    this.released = released;
    this.supportedLanguages = supportedLanguages;
  }

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
               final Collection<Performer> performers, final Date released,
               final Collection<String> supportedLanguages) {
    this(UUID.randomUUID().toString(), name, description, genre, mediaUrl, performers, released, supportedLanguages);
  }
}
