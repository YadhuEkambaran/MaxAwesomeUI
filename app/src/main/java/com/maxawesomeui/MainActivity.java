package com.maxawesomeui;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maxui.AwesomeTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AwesomeTextView aui = findViewById(R.id.aui_text_view);
        aui.setStrokeColor(R.color.colorPrimaryDark);
        aui.setBGColor(R.color.colorAccent);
        aui.setStrokeWidth(4);
    }
}
