package juez.david.transportbcn.provider.bus;

import juez.david.transportbcn.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code bus} table.
 */
public interface BusModel extends BaseModel {

    /**
     * Get the {@code idbus} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIdbus();

    /**
     * Get the {@code street_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStreetName();

    /**
     * Get the {@code city} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCity();

    /**
     * Get the {@code utm_x} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getUtmX();

    /**
     * Get the {@code utm_y} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getUtmY();

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
     * Get the {@code furniture} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFurniture();

    /**
     * Get the {@code buses} value.
     * Can be {@code null}.
     */
    @Nullable
    String getBuses();

    /**
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getSynctime();
}
