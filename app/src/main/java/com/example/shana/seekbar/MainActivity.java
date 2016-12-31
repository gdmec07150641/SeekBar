package com.example.shana.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar sb;
    private TextView status,status_values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb= (SeekBar) findViewById(R.id.seekbar);
        status= (TextView) findViewById(R.id.status);
        status_values= (TextView) findViewById(R.id.status_status);
        sb.setProgress(30);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               status_values.setText(i+"%");//这儿单独写入int不会报错但是运行会出现出错，需进行类型转换int→string
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                status.setText(getString(R.string.trackingTouch));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                status.setText(getString(R.string.noTouch));
            }
        });
    }
}
