package com.app.designdemo1;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        Button coordinator_btn = (Button) findViewById(R.id.coordinator_btn);
        coordinator_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v,"Snackbar is CoordinatorLayout",Snackbar.LENGTH_LONG)
                .setAction("exit",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }).show();
    }
}
