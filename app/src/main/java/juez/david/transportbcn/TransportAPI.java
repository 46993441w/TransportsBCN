package juez.david.transportbcn;


import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import juez.david.transportbcn.provider.bicing.BicingColumns;
import juez.david.transportbcn.provider.bicing.BicingContentValues;
import juez.david.transportbcn.provider.bicing.BicingCursor;
import juez.david.transportbcn.provider.bicing.BicingSelection;
import juez.david.transportbcn.provider.bus.BusColumns;
import juez.david.transportbcn.provider.bus.BusContentValues;
import juez.david.transportbcn.provider.bus.BusCursor;
import juez.david.transportbcn.provider.bus.BusSelection;
import juez.david.transportbcn.provider.metro.MetroColumns;
import juez.david.transportbcn.provider.metro.MetroContentValues;
import juez.david.transportbcn.provider.metro.MetroCursor;
import juez.david.transportbcn.provider.metro.MetroSelection;
import juez.david.transportbcn.transport.Bici;
import juez.david.transportbcn.transport.Data;
import juez.david.transportbcn.transport.Metro;
import juez.david.transportbcn.transport.Tmb;
import juez.david.transportbcn.transport.Transport;
import retrofit.Call;
import retrofit.Response;
import retrofit.http.Path;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * Interface de la API de Transports de Barcelona
 */
interface TranspotsBarcelona {
    // subtitueix {} pel tipus de transport que vols que surti
    @GET("{tipus}/stations.json")
    Call<Transport> getTransport(
            @Path("tipus") String tipus); // tipus de transport
}

/**
 * Classe Retrofit
 */
public class TransportAPI  {

    private final TranspotsBarcelona service; // interface
    private final String TRANSPORT_BASE_URL = "http://barcelonaapi.marcpous.com/"; // base per a la api
    private final Context context;
    private final Handler handler;

    public TransportAPI(Context context){
        // al crear la clase es connecta amb la api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TRANSPORT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TranspotsBarcelona.class);
        this.context = context;
        handler = new Handler(context.getMainLooper());
    }

    /**
     *  Mètode que obté el resultat de la connexió amb la api
     */
    public void update() {
        toast("Comença la sincronització");

        String bus = "bus";
        String bici = "bicing";
        String metro = "metro";

        long syncTime = System.currentTimeMillis();

        // fa la connexió amb la api amb la clau i el tipus de cerca que es vol
        Call<Transport> transportCall = service.getTransport(
                bus
        );
        processCall(transportCall, bus, syncTime);

        transportCall = service.getTransport(
                bici
        );
        processCall(transportCall, bici, syncTime);

        transportCall = service.getTransport(
                metro
        );
        processCall(transportCall, metro, syncTime);

        deleteOldTransport(syncTime);

        toast("Acaba la sincronització");
    }

    private void toast(final String text){
        handler.post(new Runnable() {
            @Override
            public void run(){
                Toast.makeText(context,text,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void deleteOldTransport(long syncTime) {
        context.getContentResolver().delete(
                BusColumns.CONTENT_URI,
                BusColumns.SYNCTIME + " < ?",
                new String[]{Long.toString(syncTime)}
        );
        context.getContentResolver().delete(
                BicingColumns.CONTENT_URI,
                BicingColumns.SYNCTIME + " < ?",
                new String[]{Long.toString(syncTime)}
        );
        context.getContentResolver().delete(
                MetroColumns.CONTENT_URI,
                MetroColumns.SYNCTIME + " < ?",
                new String[]{Long.toString(syncTime)}
        );
    }

    /**
     * Mètode que obté les latituts i longituts de la base de dades
     * @param items llista on es guardan les latituts i longituts de cada marca
     * @param tipus el tipus de llista que es vol mostrar
     */
    public void transports(List items, String tipus) {
        if (tipus.equals("bus")){
            BusCursor bussos = new BusSelection().query(context);
            bussos.moveToNext();
            while(!bussos.isAfterLast()){
                items.add(cursorToBus(bussos));
                bussos.moveToNext();
            }
        } else if(tipus.equals("bicing")){
            BicingCursor bicings = new BicingSelection().query(context);
            bicings.moveToNext();
            while(!bicings.isAfterLast()){
                items.add(cursorToBicing(bicings));
                bicings.moveToNext();
            }
        } else if (tipus.equals("metro")){
            MetroCursor metros = new MetroSelection().query(context);
            metros.moveToNext();
            while(!metros.isAfterLast()){
                items.add(cursorToMetro(metros));
                metros.moveToNext();
            }
        }
    }

    private Metro cursorToMetro(MetroCursor metros) {
        Metro metro = new Metro();
        metro.setId(String.valueOf(metros.getIdmetro()));
        metro.setLine(metros.getLine());
        metro.setName(metros.getName());
        metro.setAccessibility(metros.getAccessibility());
        metro.setZone(metros.getZone());
        metro.setConnections(metros.getConnections());
        metro.setLat(String.valueOf(metros.getLat()));
        metro.setLon(String.valueOf(metros.getLon()));
        return metro;
    }

    private Bici cursorToBicing(BicingCursor bicings) {
        Bici bici = new Bici();
        bici.setId(String.valueOf(bicings.getIdbicing()));
        bici.setName(bicings.getName());
        bici.setLat(String.valueOf(bicings.getLat()));
        bici.setLon(String.valueOf(bicings.getLon()));
        bici.setNearbyStations(bicings.getNearbyStations());
        return bici;
    }

    private Tmb cursorToBus(BusCursor bussos) {
        Tmb tmb = new Tmb();
        tmb.setId(String.valueOf(bussos.getIdbus()));
        tmb.setStreetName(bussos.getStreetName());
        tmb.setCity(bussos.getCity());
        tmb.setUtmX(String.valueOf(bussos.getUtmX()));
        tmb.setUtmY(String.valueOf(bussos.getUtmY()));
        tmb.setLat(String.valueOf(bussos.getLat()));
        tmb.setLon(String.valueOf(bussos.getLon()));
        tmb.setFurniture(bussos.getFurniture());
        tmb.setBuses(bussos.getBuses());
        return tmb;
    }

    /**
     * Mètode que obté el resultat de la connexió amb la api
     * @param transportCall connexió amb la api
     * @param tipus el tipus de llista que es vol mostrar
     * @param syncTime el temps actual per a poder diferenciar del antics
     */
    public void processCall(Call<Transport> transportCall,final String tipus, final long syncTime) {
        try {
            Response<Transport> response = transportCall.execute();
            if (response.isSuccess()) {
                // la resposta la torna objecte, que hem creat prèviament,
                Transport transport = response.body();
                Data data = transport.getData();

                ContentValues[] bulkToInsert;
                List<ContentValues> mValueList = new ArrayList<>();
                if (tipus.equals("bus")) {
                    for (Tmb result : data.getTmbs()) {
                        BusContentValues values = new BusContentValues();

                        values.putIdbus(Integer.valueOf(result.getId()));
                        values.putStreetName(result.getStreetName());
                        values.putCity(result.getCity());
                        values.putUtmX(Double.parseDouble(result.getUtmX().replace(',','.')));
                        values.putUtmY(Double.parseDouble(result.getUtmY().replace(',','.')));
                        values.putLat(Double.parseDouble(result.getLat()));
                        values.putLon(Double.parseDouble(result.getLon()));
                        values.putFurniture(result.getFurniture());
                        values.putBuses(result.getBuses());
                        values.putSynctime(syncTime);

                        mValueList.add(values.values());
                    }
                    bulkToInsert = new ContentValues[mValueList.size()];
                    mValueList.toArray(bulkToInsert);
                    context.getContentResolver().bulkInsert(BusColumns.CONTENT_URI, bulkToInsert);
                } else if (tipus.equals("bicing")) {
                    for (Bici result : data.getBici()) {
                        BicingContentValues values = new BicingContentValues();

                        values.putIdbicing(Integer.valueOf(result.getId()));
                        values.putName(result.getName());
                        values.putLat(Double.valueOf(result.getLat()));
                        values.putLon(Double.valueOf(result.getLon()));
                        values.putNearbyStations(result.getNearbyStations());
                        values.putSynctime(syncTime);

                        mValueList.add(values.values());
                    }
                    bulkToInsert = new ContentValues[mValueList.size()];
                    mValueList.toArray(bulkToInsert);
                    context.getContentResolver().bulkInsert(BicingColumns.CONTENT_URI, bulkToInsert);
                } else if (tipus.equals("metro")) {
                    for (Metro result : data.getMetro()) {
                        MetroContentValues values = new MetroContentValues();

                        values.putIdmetro(Integer.valueOf(result.getId()));
                        values.putLine(result.getLine());
                        values.putName(result.getName());
                        values.putAccessibility(result.getAccessibility());
                        values.putZone(result.getZone());
                        values.putConnections(result.getConnections());
                        values.putLat(Double.valueOf(result.getLat()));
                        values.putLon(Double.valueOf(result.getLon()));
                        values.putSynctime(syncTime);

                        mValueList.add(values.values());
                    }
                    bulkToInsert = new ContentValues[mValueList.size()];
                    mValueList.toArray(bulkToInsert);
                    context.getContentResolver().bulkInsert(MetroColumns.CONTENT_URI, bulkToInsert);
                }

            } else {
                Log.e("Update transports", response.errorBody().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}