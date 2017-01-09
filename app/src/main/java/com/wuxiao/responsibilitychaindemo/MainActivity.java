package com.wuxiao.responsibilitychaindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    View view_1, view_2, view_3,view_4;
    ViewStatus startViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_1 = findViewById(R.id.view1);
        view_2 = findViewById(R.id.view2);
        view_3 = findViewById(R.id.view3);
        view_4 = findViewById(R.id.view4);

        //生成事件处理责任链,startViewStatus为链头，处理顺序由外向内
        ViewStatus viewStatus3 = new VisibleViewStatus(null, null);
        ViewStatus viewStatus2 = new InVisibleViewStatus(viewStatus3, view_4);
        ViewStatus viewStatus1 = new InVisibleViewStatus(viewStatus2, view_3);
        startViewStatus = new InVisibleViewStatus(viewStatus1, view_2);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startViewStatus.onStatus(view_1);
            }
        });
    }





}
