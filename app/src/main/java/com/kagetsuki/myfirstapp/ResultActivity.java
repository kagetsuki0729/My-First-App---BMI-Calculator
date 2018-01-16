package com.kagetsuki.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        float bmi=intent.getFloatExtra(getString(R.string.bmi_extra),0);
        Bundle bag=intent.getExtras();
        String testing=bag.getString("TEST_EXTRA",null);
        TextView result=(TextView)findViewById(R.id.result);
        result.setText("Your BMI is "+bmi+"\n"+testing);
    }
}
