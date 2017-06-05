package com.example.mamunzahir.designs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Resources mResources;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfinal);

        // Get the application context
        mContext = getApplicationContext();

        // Get the Resources
        mResources = getResources();
       // mTextView = (TextView) findViewById(R.id.tv);
       // applyBlurMaskFilter(mTextView, BlurMaskFilter.Blur.OUTER);
    }
    protected void applyBlurMaskFilter(TextView tv, BlurMaskFilter.Blur style){

        float radius = tv.getTextSize()/8;

        // Initialize a new BlurMaskFilter instance
        BlurMaskFilter filter = new BlurMaskFilter(radius,style);

        tv.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        tv.getPaint().setMaskFilter(filter);
    }
}