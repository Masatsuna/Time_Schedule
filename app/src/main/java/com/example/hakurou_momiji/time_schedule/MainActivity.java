package com.example.hakurou_momiji.time_schedule;

import android.app.AlertDialog;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String jugyou;
    String save;


    //文字列の宣言
    ArrayList<String> memo_send_strArray;
    ArrayList<String> homework_send_strArray;
    String[] data;
    int z_num;
    String memo_save_data;



    int num = 0;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;

    Button btn[] = new Button[30];
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //インテントで渡されたデータをロードする。
        Intent home_work_getIntent = getIntent();
        homework_send_strArray = home_work_getIntent.getStringArrayListExtra("homework_data");
        Intent food_data_getIntent = getIntent();
        data = food_data_getIntent.getStringArrayExtra("DATA");
        Intent food_int_getIntent = getIntent();
        z_num = food_int_getIntent.getIntExtra("NUM", 0);
        Intent memo_getIntent = getIntent();
        memo_send_strArray = memo_getIntent.getStringArrayListExtra("memo_data");




        pref = getSharedPreferences("TEST", Context.MODE_PRIVATE);
        editor = pref.edit();
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int day   = calendar.get(Calendar.DAY_OF_MONTH);
        tv1 = (TextView)findViewById(R.id.KA_textView);
        tv2 = (TextView)findViewById(R.id.KA_textView2);
        tv3 = (TextView)findViewById(R.id.KA_textView4);
        tv4 = (TextView)findViewById(R.id.KA_textView5);
        tv5 = (TextView)findViewById(R.id.KA_textView6);
        tv6 = (TextView)findViewById(R.id.KA_textView7);
        tv7 = (TextView)findViewById(R.id.KA_textView13);
        tv8 = (TextView)findViewById(R.id.KA_textView15);
        tv9 = (TextView)findViewById(R.id.KA_textView17);
        tv1.setText(String.valueOf(month) + "/" + String.valueOf(day));
        tv2.setText(String.valueOf(month) + "/" + String.valueOf(day+1));
        tv3.setText(String.valueOf(month) + "/" + String.valueOf(day+2));
        tv4.setText(String.valueOf(month) + "/" + String.valueOf(day+3));
        tv5.setText(String.valueOf(month) + "/" + String.valueOf(day+4));
        tv6.setText(String.valueOf(month) + "/" + String.valueOf(day+5));

        for(i=0; i<=29; i++){
            if(i==0) {
                btn[i] = (Button)findViewById(R.id.KA_button);
            }else if(i==1){
                btn[i] = (Button)findViewById(R.id.KA_button2);
            }else if(i==2){
                btn[i] = (Button)findViewById(R.id.KA_button3);
            }else if(i==3){
                btn[i] = (Button)findViewById(R.id.KA_button4);
            }else if(i==4){
                btn[i] = (Button)findViewById(R.id.KA_button5);
            }else if(i==5){
                btn[i] = (Button)findViewById(R.id.KA_button6);
            }else if(i==6){
                btn[i] = (Button)findViewById(R.id.KA_button7);
            }else if(i==7){
                btn[i] = (Button)findViewById(R.id.KA_button8);
            }else if(i==8){
                btn[i] = (Button)findViewById(R.id.KA_button9);
            }else if(i==9){
                btn[i] = (Button)findViewById(R.id.KA_button10);
            }else if(i==10){
                btn[i] = (Button)findViewById(R.id.KA_button11);
            }else if(i==11){
                btn[i] = (Button)findViewById(R.id.KA_button12);
            }else if(i==12){
                btn[i] = (Button)findViewById(R.id.KA_button13);
            }else if(i==13){
                btn[i] = (Button)findViewById(R.id.KA_button14);
            }else if(i==14){
                btn[i] = (Button)findViewById(R.id.KA_button15);
            }else if(i==15){
                btn[i] = (Button)findViewById(R.id.KA_button16);
            }else if(i==16){
                btn[i] = (Button)findViewById(R.id.KA_button17);
            }else if(i==17){
                btn[i] = (Button)findViewById(R.id.KA_button18);
            }else if(i==18){
                btn[i] = (Button)findViewById(R.id.KA_button19);
            }else if(i==19){
                btn[i] = (Button)findViewById(R.id.KA_button20);
            }else if(i==20){
                btn[i] = (Button)findViewById(R.id.KA_button21);
            }else if(i==21){
                btn[i] = (Button)findViewById(R.id.KA_button22);
            }else if(i==22){
                btn[i] = (Button)findViewById(R.id.KA_button23);
            }else if(i==23){
                btn[i] = (Button)findViewById(R.id.KA_button24);
            }else if(i==24){
                btn[i] = (Button)findViewById(R.id.KA_button25);
            }else if(i==25){
                btn[i] = (Button)findViewById(R.id.KA_button26);
            }else if(i==26){
                btn[i] = (Button)findViewById(R.id.KA_button27);
            }else if(i==27){
                btn[i] = (Button)findViewById(R.id.KA_button28);
            }else if(i==28){
                btn[i] = (Button)findViewById(R.id.KA_button29);
            }else if(i==29){
                btn[i] = (Button)findViewById(R.id.KA_button30);
            }else if(i==30){
                btn[i] = (Button)findViewById(R.id.KA_button31);
            }

        }


    }
    public void set(View view){
        switch (view.getId()) {//押されたボタンによってそれぞれの値を入力
            case R.id.KA_button2:
                num = 1;
                break;

            case R.id.KA_button3:
                num = 2;
                break;

            case R.id.KA_button4:
                num = 3;
                break;

            case R.id.KA_button5:
                num = 4;
                break;

            case R.id.KA_button6:
                num = 5;
                break;

            case R.id.KA_button7:
                num = 6;
                break;

            case R.id.KA_button8:
                num = 7;
                break;

            case R.id.KA_button9:
                num = 8;
                break;

            case R.id.KA_button10:
                num = 9;
                break;

            case R.id.KA_button11:
                num = 10;
                break;
            case R.id.KA_button12:
                num = 11;
                break;

            case R.id.KA_button13:
                num = 12;
                break;

            case R.id.KA_button14:
                num = 13;
                break;

            case R.id.KA_button15:
                num = 14;
                break;

            case R.id.KA_button16:
                num = 15;
                break;

            case R.id.KA_button17:
                num = 16;
                break;

            case R.id.KA_button18:
                num = 17;
                break;

            case R.id.KA_button19:
                num = 18;
                break;

            case R.id.KA_button20:
                num = 19;
                break;

            case R.id.KA_button21:
                num = 20;
                break;

            case R.id.KA_button22:
                num = 21;
                break;

            case R.id.KA_button23:
                num = 22;
                break;

            case R.id.KA_button24:
                num = 23;
                break;

            case R.id.KA_button25:
                num = 24;
                break;

            case R.id.KA_button26:
                num = 25;
                break;

            case R.id.KA_button27:
                num = 26;
                break;

            case R.id.KA_button28:
                num = 27;
                break;

            case R.id.KA_button29:
                num = 28;
                break;

            case R.id.KA_button30:
                num = 29;
                break;

            case R.id.KA_button31:
                num = 30;
                break;
        }
        input(view);
    }

    public void input(View arg0) {

        if(Load() == null) {
            //テキスト入力を受け付けるビューを作成します。
            final EditText tuition = new EditText(MainActivity.this);
            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setTitle("予定の入力")
                            //setViewにてビューを設定します。
                    .setView(tuition)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            btn[num].setText("○");
                            jugyou = String.valueOf(tuition.getText().toString());
                            tv9.setText(jugyou);

                            save(jugyou);
                        }
                    })

                    .setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                        }
                    })
                    .show();
        }else{
            tv9.setText(Load());
        }
    }

    private void save(String a) {
        //Log.d("a",String.valueOf(savea));
        //save = save;
        editor.putString("save" + String.valueOf(num), a);
        editor.apply();

//        try{
//            FileOutputStream out = openFileOutput("Schedule.txt",MODE_PRIVATE);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }

    private String Load(){
        Log.d("a",String.valueOf(num));
        String load = pref.getString("save" +String.valueOf(num) ,null);
        Log.d("a",String.valueOf(load));
//        try{
//            FileInputStream fileInputStream;
//            fileInputStream = openFileInput("Schedule.txt");
//            byte[] readBytes = new byte[fileInputStream.available()];
//            fileInputStream.read(readBytes);
//            load = new String(readBytes);
//            Log.v("load",load);
//        }catch(FileNotFoundException e){
//            return null;
//        }catch(IOException e){
//            return null;
//        }
        return load;
    }

    public void jump(View view){
        switch (view.getId()){
            case R.id.KA_button:

                //インテントの生成
                Intent intent = new Intent(this,memo.class);

                //インテントにバンドルを持たせる
                intent.putExtra("memo_data", memo_send_strArray);
                intent.putExtra("homework_data",homework_send_strArray);
                intent.putExtra("DATA", data);
                intent.putExtra("NUM", this.z_num);



                //別アクティビティへ移動
                startActivity(intent);
                break;
        }
    }
}
