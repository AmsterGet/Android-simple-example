package com.dellpc.helo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.Drawable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but;
    private Button bt;
    private Button third;
    private Button inf;
    private Button piz;
    private Button laba_4;
    private TextView th;
    private RelativeLayout layout;
    private Toast toast;
    private int k;

    int idx=0;
    private static int colval[]={R.color.red,R.color.colorAccent,R.color.colorPrimary, R.color.black};
    private static int colors[]={R.color.hmm, R.color.yellow,R.color.white, R.color.orange};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        th = (TextView) findViewById(R.id.hell_or);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(this);

        but = (Button) findViewById(R.id.link);
        but.setOnClickListener(this);

        third=(Button) findViewById(R.id.third);
        third.setOnClickListener(this);
        layout = (RelativeLayout) findViewById(R.id.layout);

        inf = (Button) findViewById(R.id.inf);
        inf.setOnClickListener(this);

        piz=(Button) findViewById(R.id.piz);
        piz.setOnClickListener(this);

        laba_4=(Button) findViewById(R.id.laba_4);
        laba_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.link:
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);
            break;
            case R.id.laba_4:
                Intent rintent = new Intent(MainActivity.this, Activity_3.class);
                startActivity(rintent);
                break;
            case R.id.button:
                k++;
                if (k%2!=0) th.setText("HEll OR WORLD!");
                else th.setText("");
                th.setTextColor(getResources().getColor(colval[idx]));
                idx=(idx+1)%colval.length;
            break;
            case R.id.third:
                layout.setBackgroundColor(getResources().getColor(colors[idx]));
                idx=(idx+1)%colors.length;
                toast = Toast.makeText(this, "Welcome to a new background color", Toast.LENGTH_SHORT);
                toast.show();
            break;
            case R.id.inf:
                toast = Toast.makeText(this, "Goncharik, Ivanovskaya, Khorovets are created this app", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.piz:
                layout.setBackgroundResource(R.drawable.piz);
            break;
            default:break;
        }
    }
}
