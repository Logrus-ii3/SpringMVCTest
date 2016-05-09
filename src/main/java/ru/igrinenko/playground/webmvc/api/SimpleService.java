/**
 */
package ru.igrinenko.playground.webmvc.api;

import java.util.List;

/**
 * This service is used to work with Lists.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @param <T> is an entity to be listed.
 * @since 0.1
 */
public interface SimpleService<T> {
    /**
     * Use this to get full list of entities.
     * @return List of Artists.
     */
    List<T> enlist();

    /**
     * Returns requested by id element.
     * @param id Element's id.
     * @return Element.
     */
    T element(long id);

    /**
     * Use this to delete an element from the list.
     * @param id Element's id.
     */
    void delete(long id);

    /**
     * Adds new element.
     * @param element An element to be added.
     * @return New element's id.
     */
    long add(T element);

    /**
     * Updates an element.
     * @param id The id of the element to be updated.
     * @param element An element's info to be used for update.
     */
    void update(long id, T element);
}
