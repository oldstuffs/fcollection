package io.github.portlek.fcollection.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Collection;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * a class that represents a {@link Movie}'s entries to create {@link Movie}.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class MovieEntry {

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
  private long released;

  /**
   * supported languages of the movie.
   */
  private Collection<String> supportedLanguages;

  /**
   * creates a movie.
   *
   * @return movie.
   */
  public Movie createMovie() {
    return new Movie(this.name, this.description, this.genre, this.mediaUrl, this.performers, this.released,
      this.supportedLanguages);
  }

  /**
   * creates a movie with unique id.
   *
   * @param uniqueId the unique id.
   *
   * @return movie.
   */
  public Movie createMovie(final String uniqueId) {
    return new Movie(uniqueId, this.name, this.description, this.genre, this.mediaUrl, this.performers, this.released,
      this.supportedLanguages);
  }
}
