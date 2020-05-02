package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NaytalisatiedotActivity extends AppCompatActivity {

    private TextView pvm, ika, paino, pituus, bmi, lisatiedot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naytalisatiedot);

        pvm = findViewById(R.id.paivamaaraTulos);
        ika = findViewById(R.id.ikaTulos);
        paino = findViewById(R.id.painoTulos);
        pituus = findViewById(R.id.pituusTulos);
        bmi = findViewById(R.id.bmiTulos);
        lisatiedot = findViewById(R.id.lisatiedotTulos);

        //saadaan painetun paivamaaran sijainti.
        int position = getIntent().getIntExtra(EdistyminenActivity.EXTRA, 0);

        //asetetaan saadut tiedot niille kuuluville paikoille.
        String paivamaara = EdistyminenActivity.edistymiset.get(position).getPvm();
        pvm.setText(paivamaara);

        int saatuIka = EdistyminenActivity.edistymiset.get(position).getIka();
        String stringIka = saatuIka + " vuotta";
        ika.setText(stringIka);

        float saatuPaino = EdistyminenActivity.edistymiset.get(position).getPaino();
        String stringPaino = saatuPaino + " kg";
        paino.setText(stringPaino);

        float saatuPituus = EdistyminenActivity.edistymiset.get(position).getPituus();
        String stringPituus = saatuPituus + " cm";
        pituus.setText(stringPituus);

        float saatuBmi = EdistyminenActivity.edistymiset.get(position).getBmi();
        String stringBmi = Float.toString(saatuBmi);
        bmi.setText(stringBmi);

        String saatuLisatieto = EdistyminenActivity.edistymiset.get(position).getLisatietoja();
        lisatiedot.setText(saatuLisatieto);
    }
}
