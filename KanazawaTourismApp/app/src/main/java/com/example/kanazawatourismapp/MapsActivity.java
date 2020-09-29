package com.example.kanazawatourismapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class MapsActivity extends AppCompatActivity {
    Globals Global_data;
    MapFragment mf;
    Globals spot;

    String[] latitude = {"36.5621", "36.5609", " 36.5713", "36.5725", "36.5642", "36.5554"};
    String[] longitude = {"136.6627", "136.6582", "136.6568", "136.6670", "136.6500", "136.6490"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Global_data = (Globals) getApplication();
        spot = (Globals) getApplication();
        Button button5 = (Button) findViewById(R.id.start_guide);
        final Button button6 = (Button) findViewById(R.id.finish_guide);
        final TextView destination = (TextView) findViewById(R.id.text_destination);
        destination.setText("次の目的地は" + Global_data.get1() + "です");


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global_data.size() == 0) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapsActivity.this);
                    alertDialog.setTitle("次の観光地が存在しません");      //タイトル設定
                    alertDialog.setMessage("タイトルへ戻ります");  //内容(メッセージ)設定

                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // OKボタン押下時の処理
                            Global_data.clear();
                            Intent intent = new Intent(getApplication(), MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.create();
                    alertDialog.show();
                }else{
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setClassName("com.google.android.apps.maps",
                            "com.google.android.maps.MapsActivity");

                    // 出発地, 目的地, 交通手段
                    String str = String.format(Locale.US,
                            "https://www.google.com/maps/dir/?api=1&destination=" + latitude[spot.spotget(0)] + "," +
                                    longitude[spot.spotget(0)] + "&travelmode=walking");

                    intent.setData(Uri.parse(str));
                    startActivity(intent);
                    Global_data.remove();

                    }
                if(Global_data.size() != 0) {
                    destination.setText("次の目的地は" + Global_data.get1() + "です");
                }else{
                    destination.setText("次の目的地が存在しません");
                }

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Global_data.clear();
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        public boolean onOptionsItemSelected (MenuItem item){
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



