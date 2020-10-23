package ru.nicolas.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button sw_button;
    private FlashClass flashClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        sw_button = findViewById(R.id.sw_button);
        flashClass = new FlashClass(this);
    }
    public void onClickFlash(View view){
        if(flashClass.isFlash_status()){
            flashClass.flash_off();
            sw_button.setText("ON");
            sw_button.setBackgroundResource(R.drawable.circle_green);
        }
        else {
            flashClass.flash_on();
            sw_button.setText("OFF");
            sw_button.setBackgroundResource(R.drawable.circle_red);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flashClass.isFlash_status()){
            flashClass.flash_off();
        }
    }
}