/**
 */
package ru.igrinenko.playground.webmvc.impl;

import java.util.List;
import ru.igrinenko.playground.webmvc.api.Artist;
import ru.igrinenko.playground.webmvc.api.SimpleService;
import ru.igrinenko.playground.webmvc.api.dao.SimpleDao;

/**
 * This class is a list of Artists.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArtistsService implements SimpleService<Artist> {

    /**
     * DAO object to interact with.
     */
    private final SimpleDao<Artist> dao;

    /**
     * Constructor.
     * @param dao The service to provide the list.
     */
    public ArtistsService(final SimpleDao<Artist> dao) {
        this.dao = dao;
    }

    /**
     * Returns the list of Artists.
     * @return List
     */
    public final List<Artist> enlist() {
        return this.dao.fetchList();
    }

    @Override
    public final void delete(final long id) {
        this.dao.delete(id);
    }

    @Override
    public final long add(final Artist element) {
        return this.dao.add(element);
    }

    @Override
    public final Artist element(final long id) {
        return this.dao.getElement(id);
    }

    @Override
    public final void update(final long id, final Artist element) {
        this.dao.update(id, element);
    }

}
