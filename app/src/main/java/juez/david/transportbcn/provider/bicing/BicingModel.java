package juez.david.transportbcn.provider.bicing;

import juez.david.transportbcn.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code bicing} table.
 */
public interface BicingModel extends BaseModel {

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Get the {@code lat} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getLat();

    /**
     * Get the {@code lon} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getLon();

    /**
     * Get the {@code nearby_stations} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNearbyStations();
}
