package juez.david.transportbcn.provider.metro;

import android.net.Uri;
import android.provider.BaseColumns;

import juez.david.transportbcn.provider.TransportProvider;
import juez.david.transportbcn.provider.bicing.BicingColumns;
import juez.david.transportbcn.provider.bus.BusColumns;
import juez.david.transportbcn.provider.metro.MetroColumns;

/**
 * Columns for the {@code metro} table.
 */
public class MetroColumns implements BaseColumns {
    public static final String TABLE_NAME = "metro";
    public static final Uri CONTENT_URI = Uri.parse(TransportProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String LINE = "line";

    public static final String NAME = "name";

    public static final String ACCESSIBILITY = "accessibility";

    public static final String ZONE = "zone";

    public static final String CONNECTIONS = "connections";

    public static final String LAT = "lat";

    public static final String LON = "lon";


    public static final String DEFAULT_ORDER = TABLE_NAME + "build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            LINE,
            NAME,
            ACCESSIBILITY,
            ZONE,
            CONNECTIONS,
            LAT,
            LON
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(LINE) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + LINE)) return true;
            if (c.equals(NAME) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + NAME)) return true;
            if (c.equals(ACCESSIBILITY) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + ACCESSIBILITY)) return true;
            if (c.equals(ZONE) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + ZONE)) return true;
            if (c.equals(CONNECTIONS) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + CONNECTIONS)) return true;
            if (c.equals(LAT) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + LAT)) return true;
            if (c.equals(LON) || c.contains("build/intermediates/exploded-aar/com.google.android.gms/play-services-location/8.1.0/res" + LON)) return true;
        }
        return false;
    }

}
