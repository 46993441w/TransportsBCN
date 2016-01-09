package juez.david.transportbcn.provider.bus;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import juez.david.transportbcn.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code bus} table.
 */
public class BusCursor extends AbstractCursor implements BusModel {
    public BusCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(BusColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code idbus} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getIdbus() {
        Integer res = getIntegerOrNull(BusColumns.IDBUS);
        return res;
    }

    /**
     * Get the {@code street_name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStreetName() {
        String res = getStringOrNull(BusColumns.STREET_NAME);
        return res;
    }

    /**
     * Get the {@code city} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCity() {
        String res = getStringOrNull(BusColumns.CITY);
        return res;
    }

    /**
     * Get the {@code utm_x} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getUtmX() {
        Double res = getDoubleOrNull(BusColumns.UTM_X);
        return res;
    }

    /**
     * Get the {@code utm_y} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getUtmY() {
        Double res = getDoubleOrNull(BusColumns.UTM_Y);
        return res;
    }

    /**
     * Get the {@code lat} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLat() {
        Double res = getDoubleOrNull(BusColumns.LAT);
        return res;
    }

    /**
     * Get the {@code lon} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLon() {
        Double res = getDoubleOrNull(BusColumns.LON);
        return res;
    }

    /**
     * Get the {@code furniture} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getFurniture() {
        String res = getStringOrNull(BusColumns.FURNITURE);
        return res;
    }

    /**
     * Get the {@code buses} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getBuses() {
        String res = getStringOrNull(BusColumns.BUSES);
        return res;
    }

    /**
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getSynctime() {
        Date res = getDateOrNull(BusColumns.SYNCTIME);
        return res;
    }
}
