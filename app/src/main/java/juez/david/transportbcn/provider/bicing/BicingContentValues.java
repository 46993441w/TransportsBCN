package juez.david.transportbcn.provider.bicing;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import juez.david.transportbcn.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code bicing} table.
 */
public class BicingContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return BicingColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable BicingSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable BicingSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public BicingContentValues putIdbicing(@Nullable Integer value) {
        mContentValues.put(BicingColumns.IDBICING, value);
        return this;
    }

    public BicingContentValues putIdbicingNull() {
        mContentValues.putNull(BicingColumns.IDBICING);
        return this;
    }

    public BicingContentValues putName(@Nullable String value) {
        mContentValues.put(BicingColumns.NAME, value);
        return this;
    }

    public BicingContentValues putNameNull() {
        mContentValues.putNull(BicingColumns.NAME);
        return this;
    }

    public BicingContentValues putLat(@Nullable Double value) {
        mContentValues.put(BicingColumns.LAT, value);
        return this;
    }

    public BicingContentValues putLatNull() {
        mContentValues.putNull(BicingColumns.LAT);
        return this;
    }

    public BicingContentValues putLon(@Nullable Double value) {
        mContentValues.put(BicingColumns.LON, value);
        return this;
    }

    public BicingContentValues putLonNull() {
        mContentValues.putNull(BicingColumns.LON);
        return this;
    }

    public BicingContentValues putNearbyStations(@Nullable String value) {
        mContentValues.put(BicingColumns.NEARBY_STATIONS, value);
        return this;
    }

    public BicingContentValues putNearbyStationsNull() {
        mContentValues.putNull(BicingColumns.NEARBY_STATIONS);
        return this;
    }

    public BicingContentValues putSynctime(@Nullable Date value) {
        mContentValues.put(BicingColumns.SYNCTIME, value == null ? null : value.getTime());
        return this;
    }

    public BicingContentValues putSynctimeNull() {
        mContentValues.putNull(BicingColumns.SYNCTIME);
        return this;
    }

    public BicingContentValues putSynctime(@Nullable Long value) {
        mContentValues.put(BicingColumns.SYNCTIME, value);
        return this;
    }
}
