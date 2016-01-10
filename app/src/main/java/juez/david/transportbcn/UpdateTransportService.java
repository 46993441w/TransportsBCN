package juez.david.transportbcn;

import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.TaskParams;

public class UpdateTransportService extends GcmTaskService {
    public static void runNow(Context context) {
        OneoffTask tasca = new OneoffTask.Builder()
                .setExecutionWindow(0, 1)
                .setPersisted(true)
                .setRequiredNetwork(OneoffTask.NETWORK_STATE_CONNECTED)
                .setRequiresCharging(false)
                .setService(UpdateTransportService.class)
                .setTag("update_transport_now")
                .setUpdateCurrent(true)
                .build();
        GcmNetworkManager.getInstance(context).schedule(tasca);
    }

    public static void runDaily(Context context) {
        PeriodicTask tasca = new PeriodicTask.Builder()
                .setPeriod(24 * 60 * 60)
                .setPersisted(true)
                .setRequiredNetwork(OneoffTask.NETWORK_STATE_CONNECTED)
                .setRequiresCharging(false)
                .setService(UpdateTransportService.class)
                .setUpdateCurrent(false)
                .setTag("update_transport_periodic")
                .build();
        GcmNetworkManager.getInstance(context).schedule(tasca);
    }

    public static void forceRun(Context context) {
        ForceRefreshTask task = new ForceRefreshTask();
        task.execute(context);
    }

    @Override
    public int onRunTask(TaskParams taskParams) {
        TransportAPI apiClient = new TransportAPI(this);
        apiClient.update();

        return 0;
    }

    static class ForceRefreshTask extends AsyncTask {
        @Override
        protected Void doInBackground(Object... params) {
            Context context = (Context) params[0];

            TransportAPI apiClient = new TransportAPI(context);
            apiClient.update();

            return null;
        }
    }
}