package juez.david.transportbcn;


import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import juez.david.transportbcn.transport.Data;
import juez.david.transportbcn.transport.Tmb;
import juez.david.transportbcn.transport.Transport;
import retrofit.Call;
import retrofit.Callback;
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

    public TransportAPI(Context context){
        // al crear la clase es connecta amb la api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TRANSPORT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TranspotsBarcelona.class);
    }

    /**
     *  Mètode que obté el resultat de la connexió amb la api
     * @param tipus   el tipus de llista que es vol mostrar
     */
    public void transports(final TransportAdapter adapter, String tipus) {
        // fa la connexió amb la api amb la clau i el tipus de cerca que es vol
        Call<Transport> transportCall = service.getTransport(
                tipus
        );
        transportCall.enqueue(new Callback<Transport>() {
            /**
             * Mètode quant tot ha anat bé
             * @param response    La resposta que rep de la connexió
             * @param retrofit    El retrofit amb el que es connecta
             */
            @Override
            public void onResponse(Response<Transport> response, Retrofit retrofit) {
                // la resposta la torna objecte, que hem creat prèviament,
                Transport transport = response.body();
                Data data = transport.getData();
                // modifiquem el adaptador per a que mostri els canvis
                adapter.clear();
                adapter.addAll(data.getTmbs());
            }

            /**
             * Mètode quant alguna cosa ha sortit malament
             * @param t
             */
            @Override
            public void onFailure(Throwable t) {
                Log.e("Update movies", Arrays.toString(t.getStackTrace()));
            }
        });
    }
}