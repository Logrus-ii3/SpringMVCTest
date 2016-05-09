/**
 */
package ru.igrinenko.playground.webmvc.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ru.igrinenko.playground.webmvc.api.Artist;
import ru.igrinenko.playground.webmvc.impl.dao.ArtistMssqlDao;

/**
 * This class maps every row from the result set to a new Artist.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArtistRowMapper implements RowMapper<Artist> {

    @Override
    public final Artist mapRow(final ResultSet result, final int number)
        throws SQLException {
        final int id = result.getInt(ArtistMssqlDao.ID_FIELD_NAME);
        final String name = result.getString("name");
        final String photo = result.getString("photo_url");
        return new Artist(id, name, photo);
    }

}
