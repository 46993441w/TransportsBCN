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

    public static final String IDBUS = "idBus";

    public static final String STREET_NAME = "street_name";

    public static final String CITY = "city";

    public static final String UTM_X = "utm_x";

    public static final String UTM_Y = "utm_y";

    public static final String LAT = "lat";

    public static final String LON = "lon";

    public static final String FURNITURE = "furniture";

    public static final String BUSES = "buses";

    public static final String SYNCTIME = "syncTime";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            IDBUS,
            STREET_NAME,
            CITY,
            UTM_X,
            UTM_Y,
            LAT,
            LON,
            FURNITURE,
            BUSES,
            SYNCTIME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(IDBUS) || c.contains("." + IDBUS)) return true;
            if (c.equals(STREET_NAME) || c.contains("." + STREET_NAME)) return true;
            if (c.equals(CITY) || c.contains("." + CITY)) return true;
            if (c.equals(UTM_X) || c.contains("." + UTM_X)) return true;
            if (c.equals(UTM_Y) || c.contains("." + UTM_Y)) return true;
            if (c.equals(LAT) || c.contains("." + LAT)) return true;
            if (c.equals(LON) || c.contains("." + LON)) return true;
            if (c.equals(FURNITURE) || c.contains("." + FURNITURE)) return true;
            if (c.equals(BUSES) || c.contains("." + BUSES)) return true;
            if (c.equals(SYNCTIME) || c.contains("." + SYNCTIME)) return true;
        }
        return false;
    }

}
