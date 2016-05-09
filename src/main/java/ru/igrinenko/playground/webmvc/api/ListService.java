/**
 */
package ru.igrinenko.playground.webmvc.api;

import java.util.List;

/**
 * Provides lists.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @param <T> is a type of enlisted entities.
 * @since 0.1
 */
public interface ListService<T> {
    /**
     * Returns requested list.
     * @return List requested.
     */
    List<T> fetchList();
}
