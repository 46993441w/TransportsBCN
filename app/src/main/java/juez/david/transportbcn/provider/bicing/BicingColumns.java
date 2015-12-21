package juez.david.transportbcn.provider.bicing;

import android.net.Uri;
import android.provider.BaseColumns;

import juez.david.transportbcn.provider.TransportProvider;
import juez.david.transportbcn.provider.bicing.BicingColumns;
import juez.david.transportbcn.provider.bus.BusColumns;
import juez.david.transportbcn.provider.metro.MetroColumns;

/**
 * Columns for the {@code bicing} table.
 */
public class BicingColumns implements BaseColumns {
    public static final String TABLE_NAME = "bicing";
    public static final Uri CONTENT_URI = Uri.parse(TransportProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String LAT = "lat";

    public static final String LON = "lon";

    public static final String NEARBY_STATIONS = "nearby_stations";


    public static final String DEFAULT_ORDER = TABLE_NAME + "build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            LAT,
            LON,
            NEARBY_STATIONS
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + NAME)) return true;
            if (c.equals(LAT) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + LAT)) return true;
            if (c.equals(LON) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + LON)) return true;
            if (c.equals(NEARBY_STATIONS) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + NEARBY_STATIONS)) return true;
        }
        return false;
    }

}
