package com.dellpc.helo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but;
    private Button bt;
    private TextView th;
    private int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        th = (TextView) findViewById(R.id.hell_or);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(this);

        but = (Button) findViewById(R.id.link);
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.link:
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);
            break;
            case R.id.button:
                k++;
                if (k%2!=0)th.setText("Hell or World!");
                else th.setText("");
            break;
            default:break;
        }
    }
}
