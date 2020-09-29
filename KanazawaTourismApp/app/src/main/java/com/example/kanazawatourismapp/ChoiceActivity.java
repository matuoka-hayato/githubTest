package com.example.kanazawatourismapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChoiceActivity extends AppCompatActivity {

    TextView[] tv = new TextView[3];
    Spinner[] sp = new Spinner[3];
    String[] str = {"兼六園", "21世紀美術館", "近江町市場", "東茶屋街", "武家屋敷", "忍者寺"};
    String[] str1 = {"1番目の観光地は", "2番目の観光地は", "3番目の観光地は"};
    //public ArrayList<Integer> position = new ArrayList<>();
    String item1,item2,item3;
    Button button;
    TextView text,data1,data2,data3;
    int i,position1,position2,position3;
    Globals spot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);
        spot = (Globals) getApplication();


        TextView text = new TextView(this);
        text.setText("行きたい観光名所を選んでください");

        Button button = new Button(this);
        button.setText("決定");

        for (i = 0; i < 3; i++) {
            tv[i] = new TextView(this);
            sp[i] = new Spinner(this);  //スピナーの生成
        }

        // ArrayAdapter
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);  //テキストをリストビュー、スピナーに渡すためのアレイアダプター
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //アレイアダプターにドロップダウンリストを設定

        //ll.addView(text);
        for (i = 0; i < 3; i++) {
            sp[i].setAdapter(ad); //スピナーにアレイアダプターを登録
            ll.addView(tv[i]);
            ll.addView(sp[i]);  //リニアレイアウトにスピナーを設定
        }
        sp[0].setOnItemSelectedListener(new ExSampleItemSelectedListener0());  //スピナーのアイテム選択時のリスナー登録
        sp[1].setOnItemSelectedListener(new ExSampleItemSelectedListener1());  //スピナーのアイテム選択時のリスナー登録
        sp[2].setOnItemSelectedListener(new ExSampleItemSelectedListener2());  //スピナーのアイテム選択時のリスナー登録
        ll.addView(button);

        // clickイベント追加
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ScheduleActivity.class);
                // インテントへのインスタンス生成
                intent.putExtra("key1", item1);
                spot.spotadd1((Integer) position1);
                // インテントへのインスタンス生成
                intent.putExtra("key2", item2);
                spot.spotadd2((Integer) position2);
                // インテントへのインスタンス生成
                intent.putExtra("key3", item3);
                spot.spotadd3((Integer) position3);
                startActivity(intent);
            }
        });
    }
    class ExSampleItemSelectedListener0 implements OnItemSelectedListener {  //スピナーのアイテムクリック時のイベント処理
        public void onItemSelected(AdapterView<?> v, View iv, int pos, long id) {
            TextView data1 = (TextView) iv;
            tv[0].setText("1番目の目的地は" + data1.getText());
            item1 = (String) sp[0].getItemAtPosition(pos);
            position1 = sp[0].getSelectedItemPosition();
        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    class ExSampleItemSelectedListener1 implements OnItemSelectedListener {  //スピナーのアイテムクリック時のイベント処理
        public void onItemSelected(AdapterView<?> v, View iv, int pos, long id) {
            TextView data2 = (TextView) iv;
            tv[1].setText("2番目の目的地は" + data2.getText());
            item2 = (String) sp[1].getItemAtPosition(pos);
            position2 = sp[1].getSelectedItemPosition();

        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    class ExSampleItemSelectedListener2 implements OnItemSelectedListener {  //スピナーのアイテムクリック時のイベント処理
        public void onItemSelected(AdapterView<?> v, View iv, int pos, long id) {
            TextView data3 = (TextView) iv;
            tv[2].setText("3番目の目的地は" + data3.getText());
            item3 =  (String) sp[2].getItemAtPosition(pos);
            position3 = sp[2].getSelectedItemPosition();


        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sightseeing:
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


