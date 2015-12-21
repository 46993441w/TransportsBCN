package juez.david.transportbcn.provider.bicing;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import juez.david.transportbcn.provider.base.AbstractSelection;

/**
 * Selection for the {@code bicing} table.
 */
public class BicingSelection extends AbstractSelection<BicingSelection> {
    @Override
    protected Uri baseUri() {
        return BicingColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code BicingCursor} object, which is positioned before the first entry, or null.
     */
    public BicingCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new BicingCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public BicingCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code BicingCursor} object, which is positioned before the first entry, or null.
     */
    public BicingCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new BicingCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public BicingCursor query(Context context) {
        return query(context, null);
    }


    public BicingSelection id(long... value) {
        addEquals("bicing." + BicingColumns._ID, toObjectArray(value));
        return this;
    }

    public BicingSelection idNot(long... value) {
        addNotEquals("bicing." + BicingColumns._ID, toObjectArray(value));
        return this;
    }

    public BicingSelection orderById(boolean desc) {
        orderBy("bicing." + BicingColumns._ID, desc);
        return this;
    }

    public BicingSelection orderById() {
        return orderById(false);
    }

    public BicingSelection name(String... value) {
        addEquals(BicingColumns.NAME, value);
        return this;
    }

    public BicingSelection nameNot(String... value) {
        addNotEquals(BicingColumns.NAME, value);
        return this;
    }

    public BicingSelection nameLike(String... value) {
        addLike(BicingColumns.NAME, value);
        return this;
    }

    public BicingSelection nameContains(String... value) {
        addContains(BicingColumns.NAME, value);
        return this;
    }

    public BicingSelection nameStartsWith(String... value) {
        addStartsWith(BicingColumns.NAME, value);
        return this;
    }

    public BicingSelection nameEndsWith(String... value) {
        addEndsWith(BicingColumns.NAME, value);
        return this;
    }

    public BicingSelection orderByName(boolean desc) {
        orderBy(BicingColumns.NAME, desc);
        return this;
    }

    public BicingSelection orderByName() {
        orderBy(BicingColumns.NAME, false);
        return this;
    }

    public BicingSelection lat(Double... value) {
        addEquals(BicingColumns.LAT, value);
        return this;
    }

    public BicingSelection latNot(Double... value) {
        addNotEquals(BicingColumns.LAT, value);
        return this;
    }

    public BicingSelection latGt(double value) {
        addGreaterThan(BicingColumns.LAT, value);
        return this;
    }

    public BicingSelection latGtEq(double value) {
        addGreaterThanOrEquals(BicingColumns.LAT, value);
        return this;
    }

    public BicingSelection latLt(double value) {
        addLessThan(BicingColumns.LAT, value);
        return this;
    }

    public BicingSelection latLtEq(double value) {
        addLessThanOrEquals(BicingColumns.LAT, value);
        return this;
    }

    public BicingSelection orderByLat(boolean desc) {
        orderBy(BicingColumns.LAT, desc);
        return this;
    }

    public BicingSelection orderByLat() {
        orderBy(BicingColumns.LAT, false);
        return this;
    }

    public BicingSelection lon(Double... value) {
        addEquals(BicingColumns.LON, value);
        return this;
    }

    public BicingSelection lonNot(Double... value) {
        addNotEquals(BicingColumns.LON, value);
        return this;
    }

    public BicingSelection lonGt(double value) {
        addGreaterThan(BicingColumns.LON, value);
        return this;
    }

    public BicingSelection lonGtEq(double value) {
        addGreaterThanOrEquals(BicingColumns.LON, value);
        return this;
    }

    public BicingSelection lonLt(double value) {
        addLessThan(BicingColumns.LON, value);
        return this;
    }

    public BicingSelection lonLtEq(double value) {
        addLessThanOrEquals(BicingColumns.LON, value);
        return this;
    }

    public BicingSelection orderByLon(boolean desc) {
        orderBy(BicingColumns.LON, desc);
        return this;
    }

    public BicingSelection orderByLon() {
        orderBy(BicingColumns.LON, false);
        return this;
    }

    public BicingSelection nearbyStations(String... value) {
        addEquals(BicingColumns.NEARBY_STATIONS, value);
        return this;
    }

    public BicingSelection nearbyStationsNot(String... value) {
        addNotEquals(BicingColumns.NEARBY_STATIONS, value);
        return this;
    }

    public BicingSelection nearbyStationsLike(String... value) {
        addLike(BicingColumns.NEARBY_STATIONS, value);
        return this;
    }

    public BicingSelection nearbyStationsContains(String... value) {
        addContains(BicingColumns.NEARBY_STATIONS, value);
        return this;
    }

    public BicingSelection nearbyStationsStartsWith(String... value) {
        addStartsWith(BicingColumns.NEARBY_STATIONS, value);
        return this;
    }

    public BicingSelection nearbyStationsEndsWith(String... value) {
        addEndsWith(BicingColumns.NEARBY_STATIONS, value);
        return this;
    }

    public BicingSelection orderByNearbyStations(boolean desc) {
        orderBy(BicingColumns.NEARBY_STATIONS, desc);
        return this;
    }

    public BicingSelection orderByNearbyStations() {
        orderBy(BicingColumns.NEARBY_STATIONS, false);
        return this;
    }
}
