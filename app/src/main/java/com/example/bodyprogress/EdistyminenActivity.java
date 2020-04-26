package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class EdistyminenActivity extends AppCompatActivity {
    ListView edistyminen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edistyminen);
    }
    public void onLisaaEdistyminenClick(View v){
        Intent lisaaEdistyminen = new Intent(this, LisaaEdistyminen.class);
        startActivity(lisaaEdistyminen);
    }
}
