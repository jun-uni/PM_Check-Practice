package org.practice.pm_check_non_api_ver;

import android.content.ContentValues;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class RequestHttp {
    public String Request(String target_url, ContentValues params){
        HttpURLConnection ulr_connection = null;

        StringBuffer sb_params = new StringBuffer();

        if(params == null){
            sb_params.append("");
        }else{
            boolean is_first = true;

            String key;
            String value;

            for(Map.Entry < String, Object > parameter : params.valueSet()){
                key = parameter.getKey();
                value = parameter.getValue().toString();

                if(!is_first)
                    sb_params.append("&");

                sb_params.append(key).append("=").append(value);

                if(is_first){
                    if(params.size() >= 2){
                        is_first = false;
                    }
                }
            }
        }

        try{
            URL url = new URL(target_url);
            ulr_connection = (HttpURLConnection) url.openConnection();

            ulr_connection.setRequestMethod("GET");
            ulr_connection.setRequestProperty("Accept-Charset", "UTF-8");
            ulr_connection.setDoOutput(false);

            if(ulr_connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                Log.d("HTTP_OK", "연결 요청 실패");
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(ulr_connection.getInputStream()));

            String line;
            String page = "";

            while((line = reader.readLine()) != null){
                page += line;
            }

            return page;

        }catch(MalformedURLException e){
            Log.d("MalformedURLException", String.valueOf(e));
            e.printStackTrace();
        }catch(IOException e){
            Log.d("IOException", String.valueOf(e));
            e.printStackTrace();
        }finally{
            if(ulr_connection != null){
                ulr_connection.disconnect();
            }
        }

        return null;
    }
}
