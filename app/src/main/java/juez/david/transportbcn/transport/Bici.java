package juez.david.transportbcn.transport;

public class Bici {

    private String id;
    private String name;
    private String lat;
    private String lon;
    private String nearbyStations;

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     *     The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     *     The lon
     */
    public String getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     *     The lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     *
     * @return
     *     The nearbyStations
     */
    public String getNearbyStations() {
        return nearbyStations;
    }

    /**
     *
     * @param nearbyStations
     *     The nearby_stations
     */
    public void setNearbyStations(String nearbyStations) {
        this.nearbyStations = nearbyStations;
    }

}