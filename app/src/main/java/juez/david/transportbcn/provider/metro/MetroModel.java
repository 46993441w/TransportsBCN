package juez.david.transportbcn.provider.metro;

import juez.david.transportbcn.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code metro} table.
 */
public interface MetroModel extends BaseModel {

    /**
     * Get the {@code idmetro} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIdmetro();

    /**
     * Get the {@code line} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLine();

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Get the {@code accessibility} value.
     * Can be {@code null}.
     */
    @Nullable
    String getAccessibility();

    /**
     * Get the {@code zone} value.
     * Can be {@code null}.
     */
    @Nullable
    String getZone();

    /**
     * Get the {@code connections} value.
     * Can be {@code null}.
     */
    @Nullable
    String getConnections();

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
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getSynctime();
}
