package com.fju.guess100;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random =new Random();
int g =random.nextInt(100)+1;
   int  min =1;
    int max =100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /*public void findViews(View view){
        TextView secret =(TextView) findViewById(R.id.secret);
        TextView info =(TextView) findViewById(R.id.info);
        EditText number =(EditText)findViewById(R.id.number);
        Button send =(Button)findViewById(R.id.send);*/
//真的不會用


    public  void guess(View view){
        EditText number =(EditText)findViewById(R.id.number);
        TextView secret = (TextView)findViewById(R.id.secret);
        secret.setText(Integer.toString(g));
        int n = Integer.parseInt(number.getText().toString());
        if(n>=max){

            Toast.makeText(MainActivity.this, "請再次輸入:"+min+"~"+max, Toast.LENGTH_SHORT).show();
        }
        if(n<=min){

            Toast.makeText(MainActivity.this, "請再次輸入:"+min+"~"+max, Toast.LENGTH_SHORT).show();
        }

        if(n==g){
            new AlertDialog.Builder(this)
                    .setMessage("答對了")
                    .setNeutralButton("OK",null)
                    .show();
        }
        while (n>min&&n<max&&n<g){
            min= n;
            new AlertDialog.Builder(this)
                    .setMessage(min+"to"+max)
                    .show();
            break;



        }
        while (n>min&&n<max&&n>g){
            max= n;
            new AlertDialog.Builder(this)
                    .setMessage(min+"to"+max)
                    .show();
            break;

        }

    }

}
