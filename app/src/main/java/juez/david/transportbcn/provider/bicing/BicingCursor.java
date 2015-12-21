package juez.david.transportbcn.provider.bicing;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import juez.david.transportbcn.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code bicing} table.
 */
public class BicingCursor extends AbstractCursor implements BicingModel {
    public BicingCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(BicingColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(BicingColumns.NAME);
        return res;
    }

    /**
     * Get the {@code lat} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLat() {
        Double res = getDoubleOrNull(BicingColumns.LAT);
        return res;
    }

    /**
     * Get the {@code lon} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLon() {
        Double res = getDoubleOrNull(BicingColumns.LON);
        return res;
    }

    /**
     * Get the {@code nearby_stations} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getNearbyStations() {
        String res = getStringOrNull(BicingColumns.NEARBY_STATIONS);
        return res;
    }
}
