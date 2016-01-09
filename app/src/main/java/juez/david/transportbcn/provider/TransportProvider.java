package juez.david.transportbcn.provider;

import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import juez.david.transportbcn.BuildConfig;
import juez.david.transportbcn.provider.base.BaseContentProvider;
import juez.david.transportbcn.provider.bicing.BicingColumns;
import juez.david.transportbcn.provider.bus.BusColumns;
import juez.david.transportbcn.provider.metro.MetroColumns;

public class TransportProvider extends BaseContentProvider {
    private static final String TAG = TransportProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "juez.david.transportbcn.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_BICING = 0;
    private static final int URI_TYPE_BICING_ID = 1;

    private static final int URI_TYPE_BUS = 2;
    private static final int URI_TYPE_BUS_ID = 3;

    private static final int URI_TYPE_METRO = 4;
    private static final int URI_TYPE_METRO_ID = 5;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, BicingColumns.TABLE_NAME, URI_TYPE_BICING);
        URI_MATCHER.addURI(AUTHORITY, BicingColumns.TABLE_NAME + "/#", URI_TYPE_BICING_ID);
        URI_MATCHER.addURI(AUTHORITY, BusColumns.TABLE_NAME, URI_TYPE_BUS);
        URI_MATCHER.addURI(AUTHORITY, BusColumns.TABLE_NAME + "/#", URI_TYPE_BUS_ID);
        URI_MATCHER.addURI(AUTHORITY, MetroColumns.TABLE_NAME, URI_TYPE_METRO);
        URI_MATCHER.addURI(AUTHORITY, MetroColumns.TABLE_NAME + "/#", URI_TYPE_METRO_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return TransportSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_BICING:
                return TYPE_CURSOR_DIR + BicingColumns.TABLE_NAME;
            case URI_TYPE_BICING_ID:
                return TYPE_CURSOR_ITEM + BicingColumns.TABLE_NAME;

            case URI_TYPE_BUS:
                return TYPE_CURSOR_DIR + BusColumns.TABLE_NAME;
            case URI_TYPE_BUS_ID:
                return TYPE_CURSOR_ITEM + BusColumns.TABLE_NAME;

            case URI_TYPE_METRO:
                return TYPE_CURSOR_DIR + MetroColumns.TABLE_NAME;
            case URI_TYPE_METRO_ID:
                return TYPE_CURSOR_ITEM + MetroColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_BICING:
            case URI_TYPE_BICING_ID:
                res.table = BicingColumns.TABLE_NAME;
                res.idColumn = BicingColumns._ID;
                res.tablesWithJoins = BicingColumns.TABLE_NAME;
                res.orderBy = BicingColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_BUS:
            case URI_TYPE_BUS_ID:
                res.table = BusColumns.TABLE_NAME;
                res.idColumn = BusColumns._ID;
                res.tablesWithJoins = BusColumns.TABLE_NAME;
                res.orderBy = BusColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_METRO:
            case URI_TYPE_METRO_ID:
                res.table = MetroColumns.TABLE_NAME;
                res.idColumn = MetroColumns._ID;
                res.tablesWithJoins = MetroColumns.TABLE_NAME;
                res.orderBy = MetroColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_BICING_ID:
            case URI_TYPE_BUS_ID:
            case URI_TYPE_METRO_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
