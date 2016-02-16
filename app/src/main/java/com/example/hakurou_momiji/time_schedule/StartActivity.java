package com.example.hakurou_momiji.time_schedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {


    //文字列の宣言
    ArrayList<String> memo_send_strArray;
    ArrayList<String> homework_send_strArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //エラーの防止のために初期化
        //memo_send_strArray.add("null");
        //homework_send_strArray.add("null");

    }

    public void api_start_onClick(View view) {
        switch (view.getId()){
            case R.id.api_start:

                //インテントの生成
                //Intent intent = new Intent(this, MainActivity.class);
                Intent intent = new Intent(this, MainActivity.class);

                //インテントにバンドルを持たせる
                intent.putExtra("memo_data", memo_send_strArray);
                intent.putExtra("homework_data",homework_send_strArray);



                //別アクティビティへ移動
                startActivity(intent);
                break;
        }


    }
}
