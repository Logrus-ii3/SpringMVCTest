/**
 */
package ru.igrinenko.playground.webmvc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents an Artist who has a name().
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Artist {

    /**
     * The id of the Artist.
     */
    private final int id;

    /**
     * The name of the Artist.
     */
    private final String name;

    /**
     * The URL of the artist's photo.
     */
    private final String photo;

    /**
     * Creates an Artist using given name.
     * @param id An id for new Artist.
     * @param name A name for new Artist.
     * @param photo URL for artist's photo.
     */
    public Artist(@JsonProperty("id") final int id,
        @JsonProperty("name") final String name,
        @JsonProperty("photo_url") final String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    /**
     * Use this to get the name of the Artist.
     * @return The name of the Artist.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Use this to get the id of the Artist.
     * @return The id of the Artist.
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Use this to get the URL of the artist's photo.
     * @return The URL of artist's photo.
     */
    public final String getPhoto() {
        return this.photo;
    }

}
