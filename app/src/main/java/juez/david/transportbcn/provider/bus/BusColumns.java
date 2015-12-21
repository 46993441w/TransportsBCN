package juez.david.transportbcn.provider.bus;

import android.net.Uri;
import android.provider.BaseColumns;

import juez.david.transportbcn.provider.TransportProvider;
import juez.david.transportbcn.provider.bicing.BicingColumns;
import juez.david.transportbcn.provider.bus.BusColumns;
import juez.david.transportbcn.provider.metro.MetroColumns;

/**
 * Columns for the {@code bus} table.
 */
public class BusColumns implements BaseColumns {
    public static final String TABLE_NAME = "bus";
    public static final Uri CONTENT_URI = Uri.parse(TransportProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String STREET_NAME = "street_name";

    public static final String CITY = "city";

    public static final String UTM_X = "utm_x";

    public static final String UTM_Y = "utm_y";

    public static final String LAT = "lat";

    public static final String LON = "lon";

    public static final String FURNITURE = "furniture";

    public static final String BUSES = "buses";


    public static final String DEFAULT_ORDER = TABLE_NAME + "build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            STREET_NAME,
            CITY,
            UTM_X,
            UTM_Y,
            LAT,
            LON,
            FURNITURE,
            BUSES
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(STREET_NAME) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + STREET_NAME)) return true;
            if (c.equals(CITY) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + CITY)) return true;
            if (c.equals(UTM_X) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + UTM_X)) return true;
            if (c.equals(UTM_Y) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + UTM_Y)) return true;
            if (c.equals(LAT) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + LAT)) return true;
            if (c.equals(LON) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + LON)) return true;
            if (c.equals(FURNITURE) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + FURNITURE)) return true;
            if (c.equals(BUSES) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + BUSES)) return true;
        }
        return false;
    }

}
