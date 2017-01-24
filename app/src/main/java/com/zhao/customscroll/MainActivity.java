package com.zhao.customscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    CustomScrollView customScrollView;
    ScrollView parentScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
    }
    public void intiView(){
        customScrollView = (CustomScrollView) findViewById(R.id.custom_scroll);
        parentScrollView = (ScrollView) findViewById(R.id.parent_scroll);
        customScrollView.setParentView(parentScrollView);
    }
}
