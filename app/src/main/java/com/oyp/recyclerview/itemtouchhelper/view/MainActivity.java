package com.oyp.recyclerview.itemtouchhelper.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.oyp.recyclerview.itemtouchhelper.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv1:
                startActivity(new Intent(this,RecyclerListActivity.class));
                break;
            case R.id.tv2:
                startActivity(new Intent(this,RecyclerGridActivity.class));
                break;
            default:
                break;
        }
    }
}
