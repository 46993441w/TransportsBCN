package juez.david.transportbcn.provider.bus;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import juez.david.transportbcn.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code bus} table.
 */
public class BusContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return BusColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable BusSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable BusSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public BusContentValues putStreetName(@Nullable String value) {
        mContentValues.put(BusColumns.STREET_NAME, value);
        return this;
    }

    public BusContentValues putStreetNameNull() {
        mContentValues.putNull(BusColumns.STREET_NAME);
        return this;
    }

    public BusContentValues putCity(@Nullable String value) {
        mContentValues.put(BusColumns.CITY, value);
        return this;
    }

    public BusContentValues putCityNull() {
        mContentValues.putNull(BusColumns.CITY);
        return this;
    }

    public BusContentValues putUtmX(@Nullable Double value) {
        mContentValues.put(BusColumns.UTM_X, value);
        return this;
    }

    public BusContentValues putUtmXNull() {
        mContentValues.putNull(BusColumns.UTM_X);
        return this;
    }

    public BusContentValues putUtmY(@Nullable Double value) {
        mContentValues.put(BusColumns.UTM_Y, value);
        return this;
    }

    public BusContentValues putUtmYNull() {
        mContentValues.putNull(BusColumns.UTM_Y);
        return this;
    }

    public BusContentValues putLat(@Nullable Double value) {
        mContentValues.put(BusColumns.LAT, value);
        return this;
    }

    public BusContentValues putLatNull() {
        mContentValues.putNull(BusColumns.LAT);
        return this;
    }

    public BusContentValues putLon(@Nullable Double value) {
        mContentValues.put(BusColumns.LON, value);
        return this;
    }

    public BusContentValues putLonNull() {
        mContentValues.putNull(BusColumns.LON);
        return this;
    }

    public BusContentValues putFurniture(@Nullable String value) {
        mContentValues.put(BusColumns.FURNITURE, value);
        return this;
    }

    public BusContentValues putFurnitureNull() {
        mContentValues.putNull(BusColumns.FURNITURE);
        return this;
    }

    public BusContentValues putBuses(@Nullable String value) {
        mContentValues.put(BusColumns.BUSES, value);
        return this;
    }

    public BusContentValues putBusesNull() {
        mContentValues.putNull(BusColumns.BUSES);
        return this;
    }
}
