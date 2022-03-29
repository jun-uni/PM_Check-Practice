package org.practice.pm_check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class MainActivity extends AppCompatActivity {

    private TextView pm_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pm_status = (TextView)findViewById(R.id.pm_status);

        String service_key = "1eNVUOhrQ5%2FHZVz73nAYuNVJbG03WSt96DzlwXi0zkbWp45Lj1U1lO8giZWCS1gza6rlErvJGWfDBDMPR0x4Pg%3D%3D";
        String station_name = "강남구";
        String data_term = "month";
        String page_no = "1";
        String num_of_rows = "100";

        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?" +
                "stationName=" + station_name +
                "&dataTerm=" + data_term +
                "&pageNo=" + page_no +
                "&numOfRows=" + num_of_rows +
                "&returnType=xml" +
                "&serviceKey=" + service_key;

        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();


    }



    public class NetworkTask extends AsyncTask<Void, Void, String> {
        private String url_;
        private ContentValues values_;

        public NetworkTask(String url, ContentValues values){
            this.url_ = url;
            this.values_ = values;
        }
        @Override
        protected String doInBackground(Void... params){
            String result;

            RequestHttp request_http_url_connection = new RequestHttp();
            result = request_http_url_connection.Request(url_, values_);

            return result;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            pm_status.setText(s);
            Log.d("onPostEx", "출력 값 : " + s);
        }
    }

}



