package birzeit.edu;

import android.app.Activity;
import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.util.List;


public class ConnectionAsyncTask extends AsyncTask<String,String,String> {

    Activity activity;

    public ConnectionAsyncTask(Activity activity) {
        this.activity=activity;
    }

    @Override
    protected void onPreExecute() {
        ((MainActivity)activity).setButtonText("connecting");
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String data=HttpManager.getData(params[0]);

        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ((MainActivity)activity).setButtonText("connected");
        List<Car> cars=CarJasonParser.getObjectFromJason(s);
        ((MainActivity)activity).fillCars(cars);

    }


}