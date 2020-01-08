package com.dvision.cardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_contacts:
                Intent intent = new Intent(this, ContactsActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_calender:

                break;
            case R.id.btn_settings:

                break;
        }
    }

}
