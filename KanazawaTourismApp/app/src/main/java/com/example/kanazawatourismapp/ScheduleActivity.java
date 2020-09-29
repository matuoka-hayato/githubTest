package com.example.kanazawatourismapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScheduleActivity extends AppCompatActivity {
    int i;
    Intent intent;
    Globals Global_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Global_data = (Globals) getApplication();

        Button button1 = (Button) findViewById(R.id.returnbutton);
        Button button2 = (Button) findViewById(R.id.nextbutton2);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Global_data.clear();
                Intent intent = new Intent(ScheduleActivity.this, ChoiceActivity.class );
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, MapsActivity.class );
                startActivity(intent);
            }
        });

        TextView destination1 = (TextView) findViewById(R.id.destination1);
        TextView destination2 = (TextView) findViewById(R.id.destination2);
        TextView destination3 = (TextView) findViewById(R.id.destination3);

        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);
        TextView text3 = (TextView) findViewById(R.id.text3);

            Intent intent = getIntent();

            String data1 = intent.getStringExtra("key1");
            Global_data.dataadd1(data1);
            if (Global_data.size() > 0) {
                text1.setText("1番目の観光地は");
            }
            destination1.setText(Global_data.get1());

            String data2 = intent.getStringExtra("key2");
            Global_data.dataadd2(data2);
            if (Global_data.size() > 1) {
            text2.setText("2番目の観光地は");
            }
            destination2.setText(Global_data.get2());

            String data3 = intent.getStringExtra("key3");
            Global_data.dataadd3(data3);
            if (Global_data.size() > 2) {
            text3.setText("3番目の観光地は");
            }
            destination3.setText(Global_data.get3());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sightseeing:
                Global_data.clear();
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}