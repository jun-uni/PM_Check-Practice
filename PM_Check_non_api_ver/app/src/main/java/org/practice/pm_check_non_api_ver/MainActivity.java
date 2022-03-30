package org.practice.pm_check_non_api_ver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView pm_status_;
    private EditText location_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location_ = (EditText)findViewById(R.id.location);
        pm_status_ = (TextView)findViewById(R.id.pm_status);
    }

    public void mOnClickSearch(View v){
        String location = location_.getText().toString();


        String url = "https://search.daum.net/search?nil_suggest=btn&w=tot&DA=SBC&q=" +
                     location +
                     "미세먼지";

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

            AirPollution data = MyParser.ParseData(s);
            String result = MyParser.OutputFormat(data);

            pm_status_.setText(result);
            Log.d("onPostEx", "출력 값 : " + s);
        }
    }

}
