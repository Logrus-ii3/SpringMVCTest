/**
 */
package ru.igrinenko.playground.webmvc.api.dao;

import java.util.List;

/**
 * Data Access Object used for fetching lists of entities.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @param <T> is a type of fetching entities.
 * @since 0.1
 */
public interface SimpleDao<T> {
    /**
     * Returns requested list.
     * @return The list of entities.
     */
    List<T> fetchList();

    /**
     * Returns requested element.
     * @param id Element's id.
     * @return Element requested.
     */
    T getElement(long id);

    /**
     * Deletes an element.
     * @param id Element's id.
     */
    void delete(long id);

    /**
     * Adds an element to data storage.
     * @param element An element to be added.
     * @return The id of the added element.
     */
    long add(T element);

    /**
     * Updates the element to data storage.
     * @param id The id of the element to be updated.
     * @param element New element's info.
     */
    void update(long id, T element);
}
