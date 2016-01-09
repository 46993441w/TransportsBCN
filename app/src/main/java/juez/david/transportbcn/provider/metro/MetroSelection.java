package juez.david.transportbcn.provider.metro;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import juez.david.transportbcn.provider.base.AbstractSelection;

/**
 * Selection for the {@code metro} table.
 */
public class MetroSelection extends AbstractSelection<MetroSelection> {
    @Override
    protected Uri baseUri() {
        return MetroColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MetroCursor} object, which is positioned before the first entry, or null.
     */
    public MetroCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MetroCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MetroCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MetroCursor} object, which is positioned before the first entry, or null.
     */
    public MetroCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MetroCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MetroCursor query(Context context) {
        return query(context, null);
    }


    public MetroSelection id(long... value) {
        addEquals("metro." + MetroColumns._ID, toObjectArray(value));
        return this;
    }

    public MetroSelection idNot(long... value) {
        addNotEquals("metro." + MetroColumns._ID, toObjectArray(value));
        return this;
    }

    public MetroSelection orderById(boolean desc) {
        orderBy("metro." + MetroColumns._ID, desc);
        return this;
    }

    public MetroSelection orderById() {
        return orderById(false);
    }

    public MetroSelection idmetro(Integer... value) {
        addEquals(MetroColumns.IDMETRO, value);
        return this;
    }

    public MetroSelection idmetroNot(Integer... value) {
        addNotEquals(MetroColumns.IDMETRO, value);
        return this;
    }

    public MetroSelection idmetroGt(int value) {
        addGreaterThan(MetroColumns.IDMETRO, value);
        return this;
    }

    public MetroSelection idmetroGtEq(int value) {
        addGreaterThanOrEquals(MetroColumns.IDMETRO, value);
        return this;
    }

    public MetroSelection idmetroLt(int value) {
        addLessThan(MetroColumns.IDMETRO, value);
        return this;
    }

    public MetroSelection idmetroLtEq(int value) {
        addLessThanOrEquals(MetroColumns.IDMETRO, value);
        return this;
    }

    public MetroSelection orderByIdmetro(boolean desc) {
        orderBy(MetroColumns.IDMETRO, desc);
        return this;
    }

    public MetroSelection orderByIdmetro() {
        orderBy(MetroColumns.IDMETRO, false);
        return this;
    }

    public MetroSelection line(String... value) {
        addEquals(MetroColumns.LINE, value);
        return this;
    }

    public MetroSelection lineNot(String... value) {
        addNotEquals(MetroColumns.LINE, value);
        return this;
    }

    public MetroSelection lineLike(String... value) {
        addLike(MetroColumns.LINE, value);
        return this;
    }

    public MetroSelection lineContains(String... value) {
        addContains(MetroColumns.LINE, value);
        return this;
    }

    public MetroSelection lineStartsWith(String... value) {
        addStartsWith(MetroColumns.LINE, value);
        return this;
    }

    public MetroSelection lineEndsWith(String... value) {
        addEndsWith(MetroColumns.LINE, value);
        return this;
    }

    public MetroSelection orderByLine(boolean desc) {
        orderBy(MetroColumns.LINE, desc);
        return this;
    }

    public MetroSelection orderByLine() {
        orderBy(MetroColumns.LINE, false);
        return this;
    }

    public MetroSelection name(String... value) {
        addEquals(MetroColumns.NAME, value);
        return this;
    }

    public MetroSelection nameNot(String... value) {
        addNotEquals(MetroColumns.NAME, value);
        return this;
    }

    public MetroSelection nameLike(String... value) {
        addLike(MetroColumns.NAME, value);
        return this;
    }

    public MetroSelection nameContains(String... value) {
        addContains(MetroColumns.NAME, value);
        return this;
    }

    public MetroSelection nameStartsWith(String... value) {
        addStartsWith(MetroColumns.NAME, value);
        return this;
    }

    public MetroSelection nameEndsWith(String... value) {
        addEndsWith(MetroColumns.NAME, value);
        return this;
    }

    public MetroSelection orderByName(boolean desc) {
        orderBy(MetroColumns.NAME, desc);
        return this;
    }

    public MetroSelection orderByName() {
        orderBy(MetroColumns.NAME, false);
        return this;
    }

    public MetroSelection accessibility(String... value) {
        addEquals(MetroColumns.ACCESSIBILITY, value);
        return this;
    }

    public MetroSelection accessibilityNot(String... value) {
        addNotEquals(MetroColumns.ACCESSIBILITY, value);
        return this;
    }

    public MetroSelection accessibilityLike(String... value) {
        addLike(MetroColumns.ACCESSIBILITY, value);
        return this;
    }

    public MetroSelection accessibilityContains(String... value) {
        addContains(MetroColumns.ACCESSIBILITY, value);
        return this;
    }

    public MetroSelection accessibilityStartsWith(String... value) {
        addStartsWith(MetroColumns.ACCESSIBILITY, value);
        return this;
    }

    public MetroSelection accessibilityEndsWith(String... value) {
        addEndsWith(MetroColumns.ACCESSIBILITY, value);
        return this;
    }

    public MetroSelection orderByAccessibility(boolean desc) {
        orderBy(MetroColumns.ACCESSIBILITY, desc);
        return this;
    }

    public MetroSelection orderByAccessibility() {
        orderBy(MetroColumns.ACCESSIBILITY, false);
        return this;
    }

    public MetroSelection zone(String... value) {
        addEquals(MetroColumns.ZONE, value);
        return this;
    }

    public MetroSelection zoneNot(String... value) {
        addNotEquals(MetroColumns.ZONE, value);
        return this;
    }

    public MetroSelection zoneLike(String... value) {
        addLike(MetroColumns.ZONE, value);
        return this;
    }

    public MetroSelection zoneContains(String... value) {
        addContains(MetroColumns.ZONE, value);
        return this;
    }

    public MetroSelection zoneStartsWith(String... value) {
        addStartsWith(MetroColumns.ZONE, value);
        return this;
    }

    public MetroSelection zoneEndsWith(String... value) {
        addEndsWith(MetroColumns.ZONE, value);
        return this;
    }

    public MetroSelection orderByZone(boolean desc) {
        orderBy(MetroColumns.ZONE, desc);
        return this;
    }

    public MetroSelection orderByZone() {
        orderBy(MetroColumns.ZONE, false);
        return this;
    }

    public MetroSelection connections(String... value) {
        addEquals(MetroColumns.CONNECTIONS, value);
        return this;
    }

    public MetroSelection connectionsNot(String... value) {
        addNotEquals(MetroColumns.CONNECTIONS, value);
        return this;
    }

    public MetroSelection connectionsLike(String... value) {
        addLike(MetroColumns.CONNECTIONS, value);
        return this;
    }

    public MetroSelection connectionsContains(String... value) {
        addContains(MetroColumns.CONNECTIONS, value);
        return this;
    }

    public MetroSelection connectionsStartsWith(String... value) {
        addStartsWith(MetroColumns.CONNECTIONS, value);
        return this;
    }

    public MetroSelection connectionsEndsWith(String... value) {
        addEndsWith(MetroColumns.CONNECTIONS, value);
        return this;
    }

    public MetroSelection orderByConnections(boolean desc) {
        orderBy(MetroColumns.CONNECTIONS, desc);
        return this;
    }

    public MetroSelection orderByConnections() {
        orderBy(MetroColumns.CONNECTIONS, false);
        return this;
    }

    public MetroSelection lat(Double... value) {
        addEquals(MetroColumns.LAT, value);
        return this;
    }

    public MetroSelection latNot(Double... value) {
        addNotEquals(MetroColumns.LAT, value);
        return this;
    }

    public MetroSelection latGt(double value) {
        addGreaterThan(MetroColumns.LAT, value);
        return this;
    }

    public MetroSelection latGtEq(double value) {
        addGreaterThanOrEquals(MetroColumns.LAT, value);
        return this;
    }

    public MetroSelection latLt(double value) {
        addLessThan(MetroColumns.LAT, value);
        return this;
    }

    public MetroSelection latLtEq(double value) {
        addLessThanOrEquals(MetroColumns.LAT, value);
        return this;
    }

    public MetroSelection orderByLat(boolean desc) {
        orderBy(MetroColumns.LAT, desc);
        return this;
    }

    public MetroSelection orderByLat() {
        orderBy(MetroColumns.LAT, false);
        return this;
    }

    public MetroSelection lon(Double... value) {
        addEquals(MetroColumns.LON, value);
        return this;
    }

    public MetroSelection lonNot(Double... value) {
        addNotEquals(MetroColumns.LON, value);
        return this;
    }

    public MetroSelection lonGt(double value) {
        addGreaterThan(MetroColumns.LON, value);
        return this;
    }

    public MetroSelection lonGtEq(double value) {
        addGreaterThanOrEquals(MetroColumns.LON, value);
        return this;
    }

    public MetroSelection lonLt(double value) {
        addLessThan(MetroColumns.LON, value);
        return this;
    }

    public MetroSelection lonLtEq(double value) {
        addLessThanOrEquals(MetroColumns.LON, value);
        return this;
    }

    public MetroSelection orderByLon(boolean desc) {
        orderBy(MetroColumns.LON, desc);
        return this;
    }

    public MetroSelection orderByLon() {
        orderBy(MetroColumns.LON, false);
        return this;
    }

    public MetroSelection synctime(Date... value) {
        addEquals(MetroColumns.SYNCTIME, value);
        return this;
    }

    public MetroSelection synctimeNot(Date... value) {
        addNotEquals(MetroColumns.SYNCTIME, value);
        return this;
    }

    public MetroSelection synctime(Long... value) {
        addEquals(MetroColumns.SYNCTIME, value);
        return this;
    }

    public MetroSelection synctimeAfter(Date value) {
        addGreaterThan(MetroColumns.SYNCTIME, value);
        return this;
    }

    public MetroSelection synctimeAfterEq(Date value) {
        addGreaterThanOrEquals(MetroColumns.SYNCTIME, value);
        return this;
    }

    public MetroSelection synctimeBefore(Date value) {
        addLessThan(MetroColumns.SYNCTIME, value);
        return this;
    }

    public MetroSelection synctimeBeforeEq(Date value) {
        addLessThanOrEquals(MetroColumns.SYNCTIME, value);
        return this;
    }

    public MetroSelection orderBySynctime(boolean desc) {
        orderBy(MetroColumns.SYNCTIME, desc);
        return this;
    }

    public MetroSelection orderBySynctime() {
        orderBy(MetroColumns.SYNCTIME, false);
        return this;
    }
}
