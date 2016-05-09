/**
 */
package ru.igrinenko.playground.webmvc.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.igrinenko.playground.webmvc.api.ViewsPaths;

/**
 * All the views.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Controller
public final class Views {

    /**
     * Qulice told me to make this private.
     */
    private Views() {
    }

    /**
     * Returns the view with the list of artists.
     * @return Artists' list view
     */
    @RequestMapping(value = ViewsPaths.ARTISTS_LIST, method = RequestMethod.GET)
    public static String artistsList() {
        return "artists/list";
    }

}
