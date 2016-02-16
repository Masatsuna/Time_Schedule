package com.example.hakurou_momiji.time_schedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class food extends AppCompatActivity {


    //文字列の宣言
    ArrayList<String> memo_send_strArray;
    ArrayList<String> homework_send_strArray;
    String[] data;
    int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        //インテントで渡されたデータをロードする。
        Intent home_work_getIntent = getIntent();
        homework_send_strArray = home_work_getIntent.getStringArrayListExtra("homework_data");
        Intent memo_getIntent = getIntent();
        memo_send_strArray = memo_getIntent.getStringArrayListExtra("memo_data");
        Intent food_data_getIntent = getIntent();
        data = food_data_getIntent.getStringArrayExtra("DATA");
        Intent food_int_getIntent = getIntent();
        num = food_int_getIntent.getIntExtra("NUM",0);
    }





    //評価のボタンによってテキスト表示
    public void Z_review(View view) {
        String review = null;
        TextView tv = (TextView) findViewById(R.id.Z_textview);

        switch (view.getId()) {

            case R.id.Z_button1:
                review = "1";
                break;

            case R.id.Z_button2:
                review = "2";
                break;

            case R.id.Z_button3:
                review = "3";
                break;

            case R.id.Z_button4:
                review = "4";
                break;

            case R.id.Z_button5:
                review = "5";
                break;
        }

        tv.setText(review);
    }

    public void Z_onClick(View view) {

        switch (view.getId()) {

            //保存ボタン
            case R.id.Z_button19:
                Z_information();
                break;

            //キャンセルボタン
            case R.id.Z_button20:
                Z_cancel();
                break;

            //終了ボタン
            case R.id.Z_button21:
                Z_exit();
                break;
        }

    }


    //保存ボタンの処理
    private void Z_information() {

        TextView tv = (TextView) findViewById(R.id.Z_textview);

        EditText et1 = (EditText) findViewById(R.id.edittext1);
        EditText et2 = (EditText) findViewById(R.id.edittext2);
        EditText et3 = (EditText) findViewById(R.id.edittext3);

        String str;


        String sNum = Integer.toString(num);

        num++;


        //データの文字列をファイルに書き込み
        try {
            str = sNum + "#" + et1 + "#" + et2 + "#" + et3 + "#" + tv + "#";

            str = loadFile() + str;

            FileOutputStream out = openFileOutput("Z_data.txt", MODE_PRIVATE);

            out.write(str.getBytes());

        } catch (IOException e) {

            e.printStackTrace();

        }

        //データの個数をファイルに書き込み
        try {

            FileOutputStream out = openFileOutput("Z_numData.txt", MODE_PRIVATE);

            out.write(sNum.getBytes());

        } catch (IOException e) {

            e.printStackTrace();

        }

        et1.setText("");
        et2.setText("");
        et3.setText("");
        tv.setText("");


    }

    //キャンセルボタンの処理
    public void Z_cancel() {

        TextView tv = (TextView) findViewById(R.id.Z_textview);

        EditText et1 = (EditText) findViewById(R.id.edittext1);
        EditText et2 = (EditText) findViewById(R.id.edittext2);
        EditText et3 = (EditText) findViewById(R.id.edittext3);

        et1.setText("");
        et2.setText("");
        et3.setText("");
        tv.setText("");

        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }

    //終了ボタンの処理
    public void Z_exit() {

        String str = loadFile();
        if (str !=null){
            data = str.split("#", 0);
        }



        Intent intent = new Intent(getApplication(), MainActivity.class);
        intent.putExtra("DATA", data);
        intent.putExtra("NUM", this.num);
        intent.putExtra("memo_data", memo_send_strArray);
        intent.putExtra("homework_data",homework_send_strArray);
        startActivity(intent);
    }

    //textファイルのロード
    private String loadFile() {

        String readString = null;

        try {
            FileInputStream fileInputStream;
            fileInputStream = openFileInput("Z_data.txt");
            byte[] readBytes = new byte[fileInputStream.available()];
            fileInputStream.read(readBytes);
            readString = new String(readBytes);
            Log.v("readString", readString);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return readString;
    }

    public void Z_onclick_food_memo(View view) {
        switch (view.getId()){
            case R.id.Z_food_memo:


                //インテントの生成
                Intent intent = new Intent(this, memo.class);

                //インテントにバンドルを持たせる
                intent.putExtra("memo_data", memo_send_strArray);
                intent.putExtra("homework_data",homework_send_strArray);
                intent.putExtra("DATA", data);
                intent.putExtra("NUM", this.num);

                //別アクティビティへ移動
                startActivity(intent);
                break;
        }
    }

    public void Z_onClick_food_homework(View view) {

        switch (view.getId()){
            case R.id.Z_food_home_work:


                //インテントの生成
                Intent intent = new Intent(this, home_work.class);

                //インテントにバンドルを持たせる
                intent.putExtra("memo_data", memo_send_strArray);
                intent.putExtra("homework_data",homework_send_strArray);
                intent.putExtra("DATA", data);
                intent.putExtra("NUM", this.num);

                //別アクティビティへ移動
                startActivity(intent);
                break;
        }
    }
}
