package com.kagetsuki.myfirstapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ResultActivity extends AppCompatActivity {
    String bmiResult=new String(" ");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        final float bmi=intent.getFloatExtra(getString(R.string.bmi_extra),0);
        final int age=intent.getIntExtra("AGE_EXTRA",0);
        final String gender=intent.getStringExtra("GENDER_EXTRA");
        Log.d("Socket","Start a client AsyncTask");
        AsyncTask<Void,Void,Boolean> client=new AsyncTask<Void,Void,Boolean>(){

            @Override
            protected Boolean doInBackground(Void... params) {
                String modifiedSentence;
                BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
                try {
                    Socket clientSocket = new Socket("34.216.142.71", 9999);
                    PrintStream writer = new PrintStream(clientSocket.getOutputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    writer.println(bmi+" "+age+" "+gender);
                    writer.flush();
                    //System.out.println("Server:" + reader.readLine());
                    bmiResult+=reader.readLine();
                    Log.d("Client Result",bmiResult);
                    clientSocket.close();
                }
                catch(Exception e){
                    Log.d("Socket",e.getMessage().toString());
                }

                return true;
            }
        };
        try{
            Boolean atr=client.execute().get();
            TextView result=(TextView)findViewById(R.id.result);
            result.setText("Your BMI is "+bmi+"\n"+bmiResult+"\n");
        }
        catch(Exception e){

        }
        //Bundle bag=intent.getExtras();
        //String testing=bag.getString("TEST_EXTRA",null);

    }
}

