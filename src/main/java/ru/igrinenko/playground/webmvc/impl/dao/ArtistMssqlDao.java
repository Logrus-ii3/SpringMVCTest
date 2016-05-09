/**
 */
package ru.igrinenko.playground.webmvc.impl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ru.igrinenko.playground.webmvc.api.Artist;
import ru.igrinenko.playground.webmvc.api.dao.SimpleDao;
import ru.igrinenko.playground.webmvc.dao.rowmappers.ArtistRowMapper;

/**
 * This DAO gets list of artists from MSSQL.
 * @author Ivan Grinenko (ivan.grinenko@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArtistMssqlDao implements SimpleDao<Artist> {

    /**
     * The name of the field which contains table's primary key.
     */
    public static final String ID_FIELD_NAME = "id";

    /**
     * The table's name.
     */
    private static final String TABLE = "artists";

    /**
     * The main query for artists lists.
     */
    private static final String LIST_QUERY = String.format(
        "select %s, name, photo_url from %s", ArtistMssqlDao.ID_FIELD_NAME,
        ArtistMssqlDao.TABLE
        );

    /**
     * The query for deleting purposes.
     */
    private static final String DELETE_QUERY = String.format(
        "delete from %s where %s=:id", ArtistMssqlDao.TABLE,
        ArtistMssqlDao.ID_FIELD_NAME
        );

    /**
     * The query for updating purposes.
     */
    private static final String UPDATE_QUERY = String.format(
        "update %s set [name]=:name, photo_url=:photo_url where %s=:id",
        ArtistMssqlDao.TABLE, ArtistMssqlDao.ID_FIELD_NAME
        );

    /**
     * The query for getting info about an artist.
     */
    private static final String FIND_ARTIST_BY_ID = String
        .format("select id, name, photo_url from %s where id=:id", ArtistMssqlDao.TABLE);

    /**
     * JDBC-object to interact with DB.
     */
    private final NamedParameterJdbcTemplate jdbc;

    /**
     * JDBC-object to insert new artists.
     */
    private final SimpleJdbcInsert inserter;

    /**
     * Mapper who maps.
     */
    private final RowMapper<Artist> mapper;

    /**
     * Constructor.
     * @param source The data source.
     */
    public ArtistMssqlDao(final DataSource source) {
        this.jdbc = new NamedParameterJdbcTemplate(source);
        this.inserter =
            new SimpleJdbcInsert(source).withTableName(ArtistMssqlDao.TABLE)
                .usingGeneratedKeyColumns(ArtistMssqlDao.ID_FIELD_NAME);
        this.mapper = new ArtistRowMapper();
    }

    @Override
    public final List<Artist> fetchList() {
        return this.jdbc.query(ArtistMssqlDao.LIST_QUERY, this.mapper);
    }

    @Override
    public final void delete(final long id) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(ArtistMssqlDao.ID_FIELD_NAME, id);
        this.jdbc.update(ArtistMssqlDao.DELETE_QUERY, parameters);
    }

    @Override
    public final long add(final Artist element) {
        final BeanPropertySqlParameterSource params =
            new BeanPropertySqlParameterSource(element);
        return this.inserter.executeAndReturnKey(params).longValue();
    }

    @Override
    public final void update(final long id, final Artist element) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(ArtistMssqlDao.ID_FIELD_NAME, id);
        parameters.put("name", element.getName());
        parameters.put("photo_url", element.getPhoto());
        this.jdbc.update(ArtistMssqlDao.UPDATE_QUERY, parameters);
    }

    @Override
    public final Artist getElement(final long id) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put(ArtistMssqlDao.ID_FIELD_NAME, id);
        final List<Artist> result = this.jdbc.query(ArtistMssqlDao.FIND_ARTIST_BY_ID, parameters, this.mapper);
        if (result.size() == 1) {
            return result.get(0);
        }
        
        throw new ElementNotFoundException();
    }

}
