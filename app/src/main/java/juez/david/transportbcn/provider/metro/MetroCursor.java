package juez.david.transportbcn.provider.metro;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import juez.david.transportbcn.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code metro} table.
 */
public class MetroCursor extends AbstractCursor implements MetroModel {
    public MetroCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(MetroColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code line} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLine() {
        String res = getStringOrNull(MetroColumns.LINE);
        return res;
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(MetroColumns.NAME);
        return res;
    }

    /**
     * Get the {@code accessibility} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getAccessibility() {
        String res = getStringOrNull(MetroColumns.ACCESSIBILITY);
        return res;
    }

    /**
     * Get the {@code zone} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getZone() {
        String res = getStringOrNull(MetroColumns.ZONE);
        return res;
    }

    /**
     * Get the {@code connections} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConnections() {
        String res = getStringOrNull(MetroColumns.CONNECTIONS);
        return res;
    }

    /**
     * Get the {@code lat} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLat() {
        Double res = getDoubleOrNull(MetroColumns.LAT);
        return res;
    }

    /**
     * Get the {@code lon} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLon() {
        Double res = getDoubleOrNull(MetroColumns.LON);
        return res;
    }
}
