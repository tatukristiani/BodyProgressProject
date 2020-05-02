package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button progressButton = findViewById(R.id.ProfileButton);

    }
    //Siirtyy edistymisten aktiviteetille
    public void onProgressButtonClick (View v) {
        Intent progressIntent = new Intent(this, EdistyminenActivity.class);
        startActivity(progressIntent);
    }
//    public void onFoodDiaryButtonClick (View v) {
//        Intent foodDiaryIntent = new Intent(this, RuokapaivakirjaActivity.class);
//        startActivity(foodDiaryIntent);
//    }
//    public void onTrainingButtonClick(View v){
//        Intent trainingDiaryIntent = new Intent(this, TreenipaivakirjaActivity.class);
//        startActivity(trainingDiaryIntent);
//    }
//    public void onProfileButtonClick(View v){
//        Intent profileIntent = new Intent(this, ProfiiliActivity.class);
//        startActivity(profileIntent);
//    }

}
