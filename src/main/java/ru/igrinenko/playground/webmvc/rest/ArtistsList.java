/**
 */
package ru.igrinenko.playground.webmvc.rest;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.igrinenko.playground.webmvc.api.Artist;
import ru.igrinenko.playground.webmvc.api.SimpleService;

/**
 * This class provides the list of artists using REST.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Controller
public class ArtistsList {

    /**
     * Artists to be returned.
     */
    private final SimpleService<Artist> artists;

    /**
     * Constructor.
     * @param artists Artists to be enlisted.
     */
    public ArtistsList(final SimpleService<Artist> artists) {
        this.artists = artists;
    }

    /**
     * Returns list of artists.
     * @return List of artists
     */
    @RequestMapping(value = "/rest/artists", method = RequestMethod.GET)
    @ResponseBody
    public final List<Artist> listArtists() {
        return this.artists.enlist();
    }

    /**
     * Returns artist's info.
     * @param id Artist's id.
     * @return Artist's info.
     */
    @RequestMapping(value = "/rest/artists/{id}", method = RequestMethod.GET)
    @ResponseBody
    public final Artist artist(@PathVariable final long id, final HttpServletResponse response) {
        return this.artists.element(id);
    }

    /**
     * Deletes an artist's entry.
     * @param id The id of the artist to be deleted.
     * @return Returns "Ok" in case of success.
     */
    @RequestMapping(value = "/rest/artists/{id}/delete",
        method = RequestMethod.POST)
    @ResponseBody
    public final String deleteArtist(@PathVariable final long id) {
        this.artists.delete(id);
        return "";
    }

    /**
     * Adds an artist.
     * @param artist An artist to be added.
     * @return New artists's id.
     */
    @RequestMapping(value = "/rest/artists/add", method = RequestMethod.POST)
    @ResponseBody
    public final long addArtist(@RequestBody final Artist artist) {
        return this.artists.add(artist);
    }

    /**
     * Updates an artist.
     * @param id The id of the artist to be updated.
     * @param artist An artist to be updated.
     * @return New artists's id.
     */
    @RequestMapping(value = "/rest/artists/{id}/update",
        method = RequestMethod.POST)
    @ResponseBody
    public final String updateArtist(@PathVariable final long id,
        @RequestBody final Artist artist) {
        this.artists.update(id, artist);
        return "";
    }

}
