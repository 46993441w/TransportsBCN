package juez.david.transportbcn.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import juez.david.transportbcn.BuildConfig;
import juez.david.transportbcn.provider.bicing.BicingColumns;
import juez.david.transportbcn.provider.bus.BusColumns;
import juez.david.transportbcn.provider.metro.MetroColumns;

public class TransportSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = TransportSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "transport.db";
    private static final int DATABASE_VERSION = 1;
    private static TransportSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final TransportSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_BICING = "CREATE TABLE IF NOT EXISTS "
            + BicingColumns.TABLE_NAME + " ( "
            + BicingColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + BicingColumns.NAME + " TEXT, "
            + BicingColumns.LAT + " REAL, "
            + BicingColumns.LON + " REAL, "
            + BicingColumns.NEARBY_STATIONS + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_BUS = "CREATE TABLE IF NOT EXISTS "
            + BusColumns.TABLE_NAME + " ( "
            + BusColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + BusColumns.STREET_NAME + " TEXT, "
            + BusColumns.CITY + " TEXT, "
            + BusColumns.UTM_X + " REAL, "
            + BusColumns.UTM_Y + " REAL, "
            + BusColumns.LAT + " REAL, "
            + BusColumns.LON + " REAL, "
            + BusColumns.FURNITURE + " TEXT, "
            + BusColumns.BUSES + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_METRO = "CREATE TABLE IF NOT EXISTS "
            + MetroColumns.TABLE_NAME + " ( "
            + MetroColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MetroColumns.LINE + " TEXT, "
            + MetroColumns.NAME + " TEXT, "
            + MetroColumns.ACCESSIBILITY + " TEXT, "
            + MetroColumns.ZONE + " TEXT, "
            + MetroColumns.CONNECTIONS + " TEXT, "
            + MetroColumns.LAT + " REAL, "
            + MetroColumns.LON + " REAL "
            + " );";

    // @formatter:on

    public static TransportSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static TransportSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static TransportSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new TransportSQLiteOpenHelper(context);
    }

    private TransportSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new TransportSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static TransportSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new TransportSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private TransportSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new TransportSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_BICING);
        db.execSQL(SQL_CREATE_TABLE_BUS);
        db.execSQL(SQL_CREATE_TABLE_METRO);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
