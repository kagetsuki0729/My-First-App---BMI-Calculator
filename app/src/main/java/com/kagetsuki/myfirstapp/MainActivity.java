package com.kagetsuki.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        findViews();
        String title = getString(R.string.mytitle);

    }

    public void bmi(View v) {
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        try {
            float weight = Float.parseFloat(w);
            float height = Float.parseFloat(h);
            float bmi = weight / (height * height);
            Log.d("BMI", String.valueOf(bmi));
            //Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();
            //new AlertDialog.Builder(this).setMessage(bmi+" ").setTitle("BMI Result").setPositiveButton("OK",null).show();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(getString(R.string.bmi_extra), bmi);
            Bundle bag = new Bundle();
            bag.putFloat(getString(R.string.bmi_extra), bmi);
            bag.putString("TEST_EXTRA", "Testing");
            intent.putExtras(bag);
            startActivity(intent);
        } catch (Exception e) {
            Log.d("Exception ", e.getMessage());
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_LONG).show();
        }
    }

    private void findViews() {
        //get view elements
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
        //bHelp = (Button) findViewById(R.id.b_help);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
        Log.d(" a","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
        Log.d(" a","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
        Log.d(" a","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
        Log.d(" a","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
        Log.d(" a","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
        Log.d(" a","onRestart");
    }
}
