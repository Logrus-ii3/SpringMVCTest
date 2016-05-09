/**
 */
package ru.igrinenko.playground.webmvc.impl.dao;

import java.util.ArrayList;
import java.util.List;
import ru.igrinenko.playground.webmvc.api.Artist;
import ru.igrinenko.playground.webmvc.api.dao.SimpleDao;

/**
 * Dao for testing purposes.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArtistDummyDao implements SimpleDao<Artist> {

    /**
     * The starting quantity of artists for tests.
     */
    private static final int ARTISTS_COUNT = 3;

    /**
     * The list to be returned.
     */
    private final List<Artist> artists;

    /**
     * Constructor.
     */
    public ArtistDummyDao() {
        this.artists = new ArrayList<>(ArtistDummyDao.ARTISTS_COUNT);
    }

    /**
     * Returns requested list.
     * @return The list of entities.
     */
    public final List<Artist> fetchList() {
        if (this.artists.isEmpty()) {
            this.artists.add(new Artist(1, "The First", ""));
            this.artists.add(new Artist(2, "The Black", ""));
            this.artists
                .add(new Artist(ArtistDummyDao.ARTISTS_COUNT, "The Fury", ""));
        }
        return this.artists;
    }

    @Override
    public final void delete(final long id) {
        if (this.artists.get(1) != null) {
            this.artists.remove(1);
        }
    }

    @Override
    public final long add(final Artist element) {
        this.artists
            .add(new Artist(this.artists.size(), element.getName(), ""));
        return this.artists.size() - 1;
    }

    @Override
    public final Artist getElement(final long id) {
        return this.artists.get((int) id);
    }

    @Override
    public final void update(final long id, final Artist element) {
        this.artists.set((int) id, element);
    }

}
