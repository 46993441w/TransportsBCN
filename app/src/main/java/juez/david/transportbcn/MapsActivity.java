package juez.david.transportbcn;

import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.android.airmapview.AirMapInterface;
import com.airbnb.android.airmapview.AirMapMarker;
import com.airbnb.android.airmapview.AirMapView;
import com.airbnb.android.airmapview.AirMapViewTypes;
import com.airbnb.android.airmapview.DefaultAirMapViewBuilder;
import com.airbnb.android.airmapview.MapType;
import com.airbnb.android.airmapview.WebAirMapViewBuilder;
import com.airbnb.android.airmapview.listeners.OnCameraChangeListener;
import com.airbnb.android.airmapview.listeners.OnCameraMoveListener;
import com.airbnb.android.airmapview.listeners.OnInfoWindowClickListener;
import com.airbnb.android.airmapview.listeners.OnLatLngScreenLocationCallback;
import com.airbnb.android.airmapview.listeners.OnMapClickListener;
import com.airbnb.android.airmapview.listeners.OnMapInitializedListener;
import com.airbnb.android.airmapview.listeners.OnMapMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;

import juez.david.transportbcn.transport.Bici;
import juez.david.transportbcn.transport.Metro;
import juez.david.transportbcn.transport.Tmb;

public class MapsActivity extends AppCompatActivity
        implements OnCameraChangeListener, OnMapInitializedListener,
        OnMapClickListener, OnCameraMoveListener, OnMapMarkerClickListener,
        OnInfoWindowClickListener, OnLatLngScreenLocationCallback {

    private AirMapView map;
    private DefaultAirMapViewBuilder mapViewBuilder;
    private TextView textLogs;
    private ScrollView logsScrollView;
    private List<Object> items;
    private String tipus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tipus = "bicing";

        items = new ArrayList<>();

        mapViewBuilder = new DefaultAirMapViewBuilder(this);
        map = (AirMapView) findViewById(R.id.map);
        textLogs = (TextView) findViewById(R.id.textLogs);
        logsScrollView = (ScrollView) findViewById(R.id.logsScrollView);
        Button btnMapTypeNormal = (Button) findViewById(R.id.btnMapTypeNormal);
        Button btnMapTypeSattelite = (Button) findViewById(R.id.btnMapTypeSattelite);
        Button btnMapTypeTerrain = (Button) findViewById(R.id.btnMapTypeTerrain);

        btnMapTypeNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View v) {
                map.setMapType(MapType.MAP_TYPE_NORMAL);
            }
        });

        btnMapTypeSattelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View v) {
                map.setMapType(MapType.MAP_TYPE_SATELLITE);
            }
        });

        btnMapTypeTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View v) {
                map.setMapType(MapType.MAP_TYPE_TERRAIN);
            }
        });

        //update();
        map.setOnMapClickListener(this);
        map.setOnCameraChangeListener(this);
        map.setOnCameraMoveListener(this);
        map.setOnMarkerClickListener(this);
        map.setOnMapInitializedListener(this);
        map.setOnInfoWindowClickListener(this);
        map.initialize(getSupportFragmentManager());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        AirMapInterface airMapInterface = null;

        if (id == R.id.action_refresh) {
            update();
        } else{
            if (id == R.id.action_bici) {
                tipus = "bicing";
            } else if (id == R.id.action_bus) {
                tipus = "bus";
            } else if (id == R.id.action_metro) {
                tipus = "metro";
            }
            canvi();
        }
        try {
            airMapInterface = mapViewBuilder.builder(AirMapViewTypes.NATIVE).build();
        } catch (UnsupportedOperationException e) {
            airMapInterface = mapViewBuilder.builder(AirMapViewTypes.WEB).build();
        }

        if (airMapInterface != null) {
            map.initialize(getSupportFragmentManager(), airMapInterface);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCameraChanged(LatLng latLng, int zoom) {
        appendLog("Map onCameraChanged triggered with lat: " + latLng.latitude + ", lng: "
                + latLng.longitude);
    }

    @Override
    public void onMapInitialized() {
        appendLog("Map onMapInitialized initialized");
        int contador= items.size();
        for(int i = 0; i < contador; i++){
            if(tipus.equals("bus") && items.get(i) instanceof Tmb ) {
                Tmb bus = (Tmb) items.get(i);
                addMarker(bus.getStreetName(), new LatLng(Double.parseDouble(bus.getLat()), Double.parseDouble(bus.getLon())), i);
            } else if(tipus.equals("bicing") && items.get(i) instanceof Bici){
                Bici bici = (Bici) items.get(i);
                addMarker(bici.getName(), new LatLng(Double.parseDouble(bici.getLat()), Double.parseDouble(bici.getLon())), i);
            } else if(tipus.equals("metro") && items.get(i) instanceof Metro ){
                Metro metro = (Metro) items.get(i);
                addMarker(metro.getName(), new LatLng(Double.parseDouble(metro.getLat()), Double.parseDouble(metro.getLon())), i);
            }
        }
        final LatLng airbnbLatLng = new LatLng(41.3890, 2.1479);
        map.animateCenterZoom(airbnbLatLng, 15);
        // enable my location
        map.setMyLocationEnabled(true);
    }

    private void addMarker(String title, LatLng latLng, int id) {
        if(tipus.equals("bicing")) {
            map.addMarker(new AirMapMarker.Builder()
                    .id(id)
                    .position(latLng)
                    .title(title)
                    .iconId(R.drawable.bike9)
                    .build());
        } else if(tipus.equals("bus")) {
            map.addMarker(new AirMapMarker.Builder()
                    .id(id)
                    .position(latLng)
                    .title(title)
                    .iconId(R.drawable.bus4)
                    .build());
        } else if(tipus.equals("metro")){
            map.addMarker(new AirMapMarker.Builder()
                    .id(id)
                    .position(latLng)
                    .title(title)
                    .iconId(R.drawable.location76)
                    .build());
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (latLng != null) {
            appendLog(
                    "Map onMapClick triggered with lat: " + latLng.latitude + ", lng: "
                            + latLng.longitude);

            map.getMapInterface().getScreenLocation(latLng, this);
        } else {
            appendLog("Map onMapClick triggered with null latLng");
        }
    }

    @Override
    public void onCameraMove() {
        appendLog("Map onCameraMove triggered");
    }

    private void appendLog(String msg) {
        textLogs.setText(textLogs.getText() + "\n" + msg);
        logsScrollView.fullScroll(View.FOCUS_DOWN);
    }

    @Override
    public void onMapMarkerClick(long id) {
        appendLog("Map onMapMarkerClick triggered with id " + id);
    }

    @Override
    public void onMapMarkerClick(Marker marker) {
        appendLog("Map onMapMarkerClick triggered with marker " + marker.getId());
    }

    @Override
    public void onInfoWindowClick(long id) {
        appendLog("Map onInfoWindowClick triggered with id " + id);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        appendLog("Map onInfoWindowClick triggered with marker " + marker.getId());
        if(tipus.equals("bus")) {
            Tmb bus = (Tmb) items.get(Integer.parseInt(marker.getId().substring(1)));
            Toast.makeText(this, "Busos: " + bus.getBuses(),
                    Toast.LENGTH_SHORT).show();
        } else if(tipus.equals("bicing")) {
            Bici bici = (Bici) items.get(Integer.parseInt(marker.getId().substring(1)));
            Toast.makeText(this, "Estacions Properes: " + bici.getNearbyStations(),
                    Toast.LENGTH_SHORT).show();
        } else if(tipus.equals("metro")){
            Metro metro = (Metro) items.get(Integer.parseInt(marker.getId().substring(1)));
            Toast.makeText(this, "Linia: " + metro.getLine() + " ,Conneccions: " + metro.getConnections(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLatLngScreenLocationReady(Point point) {
        appendLog("LatLng location on screen (x,y): (" + point.x + "," + point.y + ")");
    }

    public void canvi(){
        // es crea la clase retrofit per accedir a les dades de la api segons els nostres valors
        TransportAPI apiClient = new TransportAPI(getApplicationContext());
        apiClient.transports(items, tipus);
    }

    public void update(){
        // es crea la clase retrofit per accedir a les dades de la api segons els nostres valors
        TransportAPI apiClient = new TransportAPI(getApplicationContext());
        apiClient.update();
    }
}
