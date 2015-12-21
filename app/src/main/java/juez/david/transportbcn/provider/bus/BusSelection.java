package juez.david.transportbcn.provider.bus;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import juez.david.transportbcn.provider.base.AbstractSelection;

/**
 * Selection for the {@code bus} table.
 */
public class BusSelection extends AbstractSelection<BusSelection> {
    @Override
    protected Uri baseUri() {
        return BusColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code BusCursor} object, which is positioned before the first entry, or null.
     */
    public BusCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new BusCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public BusCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code BusCursor} object, which is positioned before the first entry, or null.
     */
    public BusCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new BusCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public BusCursor query(Context context) {
        return query(context, null);
    }


    public BusSelection id(long... value) {
        addEquals("bus." + BusColumns._ID, toObjectArray(value));
        return this;
    }

    public BusSelection idNot(long... value) {
        addNotEquals("bus." + BusColumns._ID, toObjectArray(value));
        return this;
    }

    public BusSelection orderById(boolean desc) {
        orderBy("bus." + BusColumns._ID, desc);
        return this;
    }

    public BusSelection orderById() {
        return orderById(false);
    }

    public BusSelection streetName(String... value) {
        addEquals(BusColumns.STREET_NAME, value);
        return this;
    }

    public BusSelection streetNameNot(String... value) {
        addNotEquals(BusColumns.STREET_NAME, value);
        return this;
    }

    public BusSelection streetNameLike(String... value) {
        addLike(BusColumns.STREET_NAME, value);
        return this;
    }

    public BusSelection streetNameContains(String... value) {
        addContains(BusColumns.STREET_NAME, value);
        return this;
    }

    public BusSelection streetNameStartsWith(String... value) {
        addStartsWith(BusColumns.STREET_NAME, value);
        return this;
    }

    public BusSelection streetNameEndsWith(String... value) {
        addEndsWith(BusColumns.STREET_NAME, value);
        return this;
    }

    public BusSelection orderByStreetName(boolean desc) {
        orderBy(BusColumns.STREET_NAME, desc);
        return this;
    }

    public BusSelection orderByStreetName() {
        orderBy(BusColumns.STREET_NAME, false);
        return this;
    }

    public BusSelection city(String... value) {
        addEquals(BusColumns.CITY, value);
        return this;
    }

    public BusSelection cityNot(String... value) {
        addNotEquals(BusColumns.CITY, value);
        return this;
    }

    public BusSelection cityLike(String... value) {
        addLike(BusColumns.CITY, value);
        return this;
    }

    public BusSelection cityContains(String... value) {
        addContains(BusColumns.CITY, value);
        return this;
    }

    public BusSelection cityStartsWith(String... value) {
        addStartsWith(BusColumns.CITY, value);
        return this;
    }

    public BusSelection cityEndsWith(String... value) {
        addEndsWith(BusColumns.CITY, value);
        return this;
    }

    public BusSelection orderByCity(boolean desc) {
        orderBy(BusColumns.CITY, desc);
        return this;
    }

    public BusSelection orderByCity() {
        orderBy(BusColumns.CITY, false);
        return this;
    }

    public BusSelection utmX(Double... value) {
        addEquals(BusColumns.UTM_X, value);
        return this;
    }

    public BusSelection utmXNot(Double... value) {
        addNotEquals(BusColumns.UTM_X, value);
        return this;
    }

    public BusSelection utmXGt(double value) {
        addGreaterThan(BusColumns.UTM_X, value);
        return this;
    }

    public BusSelection utmXGtEq(double value) {
        addGreaterThanOrEquals(BusColumns.UTM_X, value);
        return this;
    }

    public BusSelection utmXLt(double value) {
        addLessThan(BusColumns.UTM_X, value);
        return this;
    }

    public BusSelection utmXLtEq(double value) {
        addLessThanOrEquals(BusColumns.UTM_X, value);
        return this;
    }

    public BusSelection orderByUtmX(boolean desc) {
        orderBy(BusColumns.UTM_X, desc);
        return this;
    }

    public BusSelection orderByUtmX() {
        orderBy(BusColumns.UTM_X, false);
        return this;
    }

    public BusSelection utmY(Double... value) {
        addEquals(BusColumns.UTM_Y, value);
        return this;
    }

    public BusSelection utmYNot(Double... value) {
        addNotEquals(BusColumns.UTM_Y, value);
        return this;
    }

    public BusSelection utmYGt(double value) {
        addGreaterThan(BusColumns.UTM_Y, value);
        return this;
    }

    public BusSelection utmYGtEq(double value) {
        addGreaterThanOrEquals(BusColumns.UTM_Y, value);
        return this;
    }

    public BusSelection utmYLt(double value) {
        addLessThan(BusColumns.UTM_Y, value);
        return this;
    }

    public BusSelection utmYLtEq(double value) {
        addLessThanOrEquals(BusColumns.UTM_Y, value);
        return this;
    }

    public BusSelection orderByUtmY(boolean desc) {
        orderBy(BusColumns.UTM_Y, desc);
        return this;
    }

    public BusSelection orderByUtmY() {
        orderBy(BusColumns.UTM_Y, false);
        return this;
    }

    public BusSelection lat(Double... value) {
        addEquals(BusColumns.LAT, value);
        return this;
    }

    public BusSelection latNot(Double... value) {
        addNotEquals(BusColumns.LAT, value);
        return this;
    }

    public BusSelection latGt(double value) {
        addGreaterThan(BusColumns.LAT, value);
        return this;
    }

    public BusSelection latGtEq(double value) {
        addGreaterThanOrEquals(BusColumns.LAT, value);
        return this;
    }

    public BusSelection latLt(double value) {
        addLessThan(BusColumns.LAT, value);
        return this;
    }

    public BusSelection latLtEq(double value) {
        addLessThanOrEquals(BusColumns.LAT, value);
        return this;
    }

    public BusSelection orderByLat(boolean desc) {
        orderBy(BusColumns.LAT, desc);
        return this;
    }

    public BusSelection orderByLat() {
        orderBy(BusColumns.LAT, false);
        return this;
    }

    public BusSelection lon(Double... value) {
        addEquals(BusColumns.LON, value);
        return this;
    }

    public BusSelection lonNot(Double... value) {
        addNotEquals(BusColumns.LON, value);
        return this;
    }

    public BusSelection lonGt(double value) {
        addGreaterThan(BusColumns.LON, value);
        return this;
    }

    public BusSelection lonGtEq(double value) {
        addGreaterThanOrEquals(BusColumns.LON, value);
        return this;
    }

    public BusSelection lonLt(double value) {
        addLessThan(BusColumns.LON, value);
        return this;
    }

    public BusSelection lonLtEq(double value) {
        addLessThanOrEquals(BusColumns.LON, value);
        return this;
    }

    public BusSelection orderByLon(boolean desc) {
        orderBy(BusColumns.LON, desc);
        return this;
    }

    public BusSelection orderByLon() {
        orderBy(BusColumns.LON, false);
        return this;
    }

    public BusSelection furniture(String... value) {
        addEquals(BusColumns.FURNITURE, value);
        return this;
    }

    public BusSelection furnitureNot(String... value) {
        addNotEquals(BusColumns.FURNITURE, value);
        return this;
    }

    public BusSelection furnitureLike(String... value) {
        addLike(BusColumns.FURNITURE, value);
        return this;
    }

    public BusSelection furnitureContains(String... value) {
        addContains(BusColumns.FURNITURE, value);
        return this;
    }

    public BusSelection furnitureStartsWith(String... value) {
        addStartsWith(BusColumns.FURNITURE, value);
        return this;
    }

    public BusSelection furnitureEndsWith(String... value) {
        addEndsWith(BusColumns.FURNITURE, value);
        return this;
    }

    public BusSelection orderByFurniture(boolean desc) {
        orderBy(BusColumns.FURNITURE, desc);
        return this;
    }

    public BusSelection orderByFurniture() {
        orderBy(BusColumns.FURNITURE, false);
        return this;
    }

    public BusSelection buses(String... value) {
        addEquals(BusColumns.BUSES, value);
        return this;
    }

    public BusSelection busesNot(String... value) {
        addNotEquals(BusColumns.BUSES, value);
        return this;
    }

    public BusSelection busesLike(String... value) {
        addLike(BusColumns.BUSES, value);
        return this;
    }

    public BusSelection busesContains(String... value) {
        addContains(BusColumns.BUSES, value);
        return this;
    }

    public BusSelection busesStartsWith(String... value) {
        addStartsWith(BusColumns.BUSES, value);
        return this;
    }

    public BusSelection busesEndsWith(String... value) {
        addEndsWith(BusColumns.BUSES, value);
        return this;
    }

    public BusSelection orderByBuses(boolean desc) {
        orderBy(BusColumns.BUSES, desc);
        return this;
    }

    public BusSelection orderByBuses() {
        orderBy(BusColumns.BUSES, false);
        return this;
    }
}
