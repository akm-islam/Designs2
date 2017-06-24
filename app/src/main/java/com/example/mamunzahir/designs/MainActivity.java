package com.example.mamunzahir.designs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.mamunzahir.designs.R.id.wind;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Resources mResources;
    private TextView mTextView;
    private TextView temp;
    private TextView wind;
    String imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfinal);
        temp= (TextView) findViewById(R.id.textView);
        wind= (TextView) findViewById(R.id.textView5);

        imageUrl = "http://api.openweathermap.org/data/2.5/weather?q="+"Dhaka"+"&units=metric&APPID=b683a7fcfe33979bf18003ebc9c397dd";
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, imageUrl, (String)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject obj=response.getJSONObject("main");
                    JSONObject obj2=response.getJSONObject("wind");
                    String temperature=obj.getString("temp");
                    String speed=obj2.getString("speed");
                    temp.setText(temperature);
                    wind.setText("Wind : "+speed);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        AppController.getInstance().addToRequestQueue(request);

    }

}

