package com.example.hakurou_momiji.time_schedule;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class memo extends AppCompatActivity {


    //宣言関係

    //テキストビュー関係
    TextView Now_day;
    EditText EditData;
    //文字列の宣言
    ArrayList<String> memo_send_strArray;
    ArrayList<String> homework_send_strArray;
    String[] data;
    int num;
    String memo_save_data;

    //入力している番号
    int memo_nmb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);


        //テキストビュー
        Now_day = (TextView) findViewById(R.id.OA_memo_now_text);
        EditData=(EditText)findViewById(R.id.OA_memo_Edit);

        //ArrayListのnew
        memo_send_strArray=new ArrayList<String>();

        //メモデータのロード
        memo_save_data = null;
        try {
            FileInputStream fileInputStream;
            fileInputStream = openFileInput("OA_memo_data.txt");
            byte[] readBytes;
            readBytes = new byte[fileInputStream.available()];
            fileInputStream.read(readBytes);
            memo_save_data = new String(readBytes);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        //インテントで渡されたデータをロードする。
        Intent home_work_getIntent = getIntent();
        homework_send_strArray = home_work_getIntent.getStringArrayListExtra("homework_data");
        Intent food_data_getIntent = getIntent();
        data = food_data_getIntent.getStringArrayExtra("DATA");
        Intent food_int_getIntent = getIntent();
        num = food_int_getIntent.getIntExtra("NUM", 0);


    }

    //日付の入力
    public void OA_onclick_memo_day(View view) {

        // 現在の日付を取得
        final Calendar calendar = Calendar.getInstance();
        int year  = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day   = calendar.get(Calendar.DAY_OF_MONTH);

        // 日付選択ダイアログを生成して日付を選ばせる
        DatePickerDialog datePicker = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view,
                                          int year, int monthOfYear, int dayOfMonth) {
                        // 「設定」ボタンクリック時の処理
                        Now_day.setText(String.valueOf(year) + "/" + String.valueOf(monthOfYear + 1) +
                                "/" + String.valueOf(dayOfMonth));
                    }
                },
                year, month, day);

        // 表示
        datePicker.show();

    }

    //保存ボタンが押された時
    public void OA_onclick_memo_save(View view) throws IOException {



        //日付を保存
        memo_send_strArray.add(memo_nmb,Now_day.getText().toString());
        //memo_send_strArray[0]="aho";
        //内容を保存
        memo_send_strArray.add(memo_nmb + 1, EditData.getText().toString());
        //メモということを保存
        memo_send_strArray.add(memo_nmb + 2, "メモ");


        //番号の更新
        memo_nmb++;

        //データの保存
        FileOutputStream out = openFileOutput("OA_memo_data.txt", MODE_PRIVATE);
        out.write(memo_save_data.getBytes());



    }

    //メモから宿題へ遷移
    public void OA_onClick_memo_homework(View view) {
        switch (view.getId()){
            case R.id.OA_memo_homework:


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

    //メモから食事画面へ
    public void OA_onClick_memo_food(View view) {
        switch (view.getId()){
            case R.id.OA_memo_food:

                //インテントの生成
                Intent intent = new Intent(this, food.class);

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

    //メモからスケジュールに戻る
    public void OA_onclick_memo_Main(View view) {

        switch (view.getId()){
            case R.id.OA_memo_Main:

                //インテントの生成
                Intent intent = new Intent(this, MainActivity.class);

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
