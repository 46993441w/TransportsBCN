package juez.david.transportbcn.provider.metro;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import juez.david.transportbcn.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code metro} table.
 */
public class MetroContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MetroColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MetroSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MetroSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MetroContentValues putLine(@Nullable String value) {
        mContentValues.put(MetroColumns.LINE, value);
        return this;
    }

    public MetroContentValues putLineNull() {
        mContentValues.putNull(MetroColumns.LINE);
        return this;
    }

    public MetroContentValues putName(@Nullable String value) {
        mContentValues.put(MetroColumns.NAME, value);
        return this;
    }

    public MetroContentValues putNameNull() {
        mContentValues.putNull(MetroColumns.NAME);
        return this;
    }

    public MetroContentValues putAccessibility(@Nullable String value) {
        mContentValues.put(MetroColumns.ACCESSIBILITY, value);
        return this;
    }

    public MetroContentValues putAccessibilityNull() {
        mContentValues.putNull(MetroColumns.ACCESSIBILITY);
        return this;
    }

    public MetroContentValues putZone(@Nullable String value) {
        mContentValues.put(MetroColumns.ZONE, value);
        return this;
    }

    public MetroContentValues putZoneNull() {
        mContentValues.putNull(MetroColumns.ZONE);
        return this;
    }

    public MetroContentValues putConnections(@Nullable String value) {
        mContentValues.put(MetroColumns.CONNECTIONS, value);
        return this;
    }

    public MetroContentValues putConnectionsNull() {
        mContentValues.putNull(MetroColumns.CONNECTIONS);
        return this;
    }

    public MetroContentValues putLat(@Nullable Double value) {
        mContentValues.put(MetroColumns.LAT, value);
        return this;
    }

    public MetroContentValues putLatNull() {
        mContentValues.putNull(MetroColumns.LAT);
        return this;
    }

    public MetroContentValues putLon(@Nullable Double value) {
        mContentValues.put(MetroColumns.LON, value);
        return this;
    }

    public MetroContentValues putLonNull() {
        mContentValues.putNull(MetroColumns.LON);
        return this;
    }
}
