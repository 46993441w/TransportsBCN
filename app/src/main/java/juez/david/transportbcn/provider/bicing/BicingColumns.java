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

    public static final String IDBICING = "idBicing";

    public static final String NAME = "name";

    public static final String LAT = "lat";

    public static final String LON = "lon";

    public static final String NEARBY_STATIONS = "nearby_stations";

    public static final String SYNCTIME = "syncTime";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            IDBICING,
            NAME,
            LAT,
            LON,
            NEARBY_STATIONS,
            SYNCTIME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(IDBICING) || c.contains("." + IDBICING)) return true;
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(LAT) || c.contains("." + LAT)) return true;
            if (c.equals(LON) || c.contains("." + LON)) return true;
            if (c.equals(NEARBY_STATIONS) || c.contains("." + NEARBY_STATIONS)) return true;
            if (c.equals(SYNCTIME) || c.contains("." + SYNCTIME)) return true;
        }
        return false;
    }

}
