/**
 */
package ru.igrinenko.playground.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world class.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Controller
public final class FriendlyClass {

    /**
     * Just a hello word.
     */
    private final String word;

    /**
     * Constructor.
     */
    public FriendlyClass() {
        this.word = "Hi again!";
    }

    /**
     * Just a test.
     * @return Text
     */
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return this.word;
    }

}
