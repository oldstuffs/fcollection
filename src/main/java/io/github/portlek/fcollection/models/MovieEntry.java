package io.github.portlek.fcollection.models;

import java.util.Collection;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * a class that represents a {@link Movie}'s entries to create {@link Movie}.
 */
@ToString
@RequiredArgsConstructor
public final class MovieEntry {

  /**
   * description of the movie.
   */
  private final String description;

  /**
   * genre of the movie.
   */
  private final String genre;

  /**
   * media url of the movie.
   */
  private final String mediaUrl;

  /**
   * name of the movie.
   */
  private final String name;

  /**
   * performers of the movie.
   */
  private final Collection<Performer> performers;

  /**
   * released date of the movie.
   */
  private final Date released;

  /**
   * supported languages of the movie.
   */
  private final Collection<String> supportedLanguages;

  /**
   * creates a movie.
   *
   * @return movie.
   */
  public Movie createMovie() {
    return new Movie(this.name, this.description, this.genre, this.mediaUrl, this.performers, this.released,
      this.supportedLanguages);
  }
}
