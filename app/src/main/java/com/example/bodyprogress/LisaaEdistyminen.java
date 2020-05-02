package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LisaaEdistyminen extends AppCompatActivity {
    public static final String PVM = "pvm";
    public static final String PAINO = "paino";
    public static final String PITUUS = "pituus";
    public static final String BMIARVO = "bmiarvo";
    public static final String IKA = "ikä";
    public static final String LISATIEDOT = "lisatiedot";

    private TextView BMI;
    private EditText paino, pituus, pvm, ika, lisatiedot;
    private BMICalculator bmiCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_edistyminen);

        paino = (EditText) findViewById(R.id.PainoText);
        pituus = (EditText) findViewById(R.id.PituusText);
        BMI = (TextView) findViewById(R.id.BMINumero);
        pvm = (EditText) findViewById(R.id.PaivamaaraText);
        ika = (EditText) findViewById(R.id.IkaText);
        lisatiedot = (EditText) findViewById(R.id.KuvausBox);

    }

    //laskee BMI arvon ja päivittää sen kohdan
    public void onLaskeBMIClick(View v){
        laskeBMI();
    }
    private void laskeBMI(){

        //ottaa käyttäjän asettaman painon ja muutta sen merkkijonoksi.
        String stringPaino = paino.getText().toString();
        String stringPituus = pituus.getText().toString();

        //String to -> float.
        float laskettavaPaino = Float.parseFloat(stringPaino);
        float laskettavaPituus = Float.parseFloat(stringPituus);

        //uusi bmilaskuri olio, annetaan float arvot paino ja pituus.
        bmiCalculator = new BMICalculator(laskettavaPaino, laskettavaPituus);

        //saadaan laskurista BMI arvo ja asetetaan float muutujaan bmiArvo.
        float bmiArvo = bmiCalculator.getBMI();

        //laitetaan BMI:n teksiosuuteen arvo joka saatiin laskurista
        BMI.setText(Float.toString(bmiArvo));

    }
//    //luodaan intent jossa valitaan kuva galleriasta, ja aloitetaan aktiviteetti.
//    private void avaaGalleria(){
//        Intent valitseGalleriasta = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(valitseGalleriasta, PICK_IMAGE);
//    }
//    //asettaa valitun kuvan imageButtonin kohdalle jos kuvan valitseminen onnistui
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //kun käyttäjä on valinnut kuvan onnistuneesti se laitetaan kuvan paikalle.
//        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
//            ImageUri = data.getData();
//            userImage.setImageURI(ImageUri);
//        }
//    }

    //painaessa tallena nappia tallentaa tiedot shared preferenceihin yksitellen. (oli ongelmia saada koko lista)
    public void onTallennaClick(View v){

        //muutetaan ensin saadut tiedot käyttäjältä sopiviin muotoihin.
        String stringPvm = pvm.getText().toString();
        int intIka = Integer.parseInt(ika.getText().toString());
        float floatPaino = Float.parseFloat(paino.getText().toString());
        float floatPituus = Float.parseFloat(pituus.getText().toString());
        float floatBmi = Float.parseFloat(BMI.getText().toString());
        String stringLisatiedot = lisatiedot.getText().toString();


        //sen jälkeen tallennetaan tiedot
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PVM, stringPvm);
        editor.putInt(IKA, intIka);
        editor.putFloat(PAINO, floatPaino);
        editor.putFloat(PITUUS, floatPituus);
        editor.putFloat(BMIARVO, floatBmi);
        editor.putString(LISATIEDOT, stringLisatiedot);
        editor.apply();

        //lopuksi ilmoitetaan käyttäjälle että tiedot on tallennettu ja päivitä edistymisesi.
        Toast.makeText(LisaaEdistyminen.this, "Tiedot tallennettu, päivitä edistymisesi!", Toast.LENGTH_LONG).show();
    }
}
