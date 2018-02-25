package it.dandandin.pivandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assegnaGliOnClick();
    }

    private void assegnaGliOnClick() {
        //apri calcolo
        TextView calcoloTV = (TextView) (findViewById(R.id.tV_calcolo));
        calcoloTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this,CalcoloActivity.class);
                startActivity(i);
            }
        });

        //apri genera
        TextView generaTV = (TextView) (findViewById(R.id.tV_genera));
        generaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,GeneraActivity.class);
                startActivity(i);
            }
        });
    }
}
