package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import static com.example.bodyprogress.LisaaEdistyminen.BMIARVO;
import static com.example.bodyprogress.LisaaEdistyminen.IKA;
import static com.example.bodyprogress.LisaaEdistyminen.LISATIEDOT;
import static com.example.bodyprogress.LisaaEdistyminen.PAINO;
import static com.example.bodyprogress.LisaaEdistyminen.PITUUS;
import static com.example.bodyprogress.LisaaEdistyminen.PVM;

public class EdistyminenActivity extends AppCompatActivity {


    private static final String TAG = "clicked" ;
    public static final String EXTRA = "element";
    private ListView listView;
    private TextView edistyminen;
    private Button edistysLisaa, paivita;
    public static List<Edistyminen> edistymiset;
    private static ArrayAdapter<Edistyminen> adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edistyminen);

        listView = (ListView) findViewById(R.id.listView);
        edistyminen = (TextView) findViewById(R.id.EdistyminenOtsikko);
        edistysLisaa = (Button) findViewById(R.id.LisaaEdistysButton);
        paivita = (Button) findViewById(R.id.buildList);

        //haetaan jo valmiiksi luodut edistymiset ja laitetan näytille.
        haeDataLista();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, edistymiset);
        listView.setAdapter(adapter);

        //kun jotain päivämäärää painetaan, niin siirtää elementin paikan seuraavalle activitylle(NaytalisatiedotActivity).
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"onItemClick(" + position + ")");
                Intent intent = new Intent(EdistyminenActivity.this, NaytalisatiedotActivity.class);
                intent.putExtra(EXTRA, position);
                startActivity(intent);
            }
        });
    }
    //aloittaa vain edistymisen lisäys aktiviteetin
    public void onLisaaEdistyminenClick (View v){

        Intent lisaaEdistyminen = new Intent(this, LisaaEdistyminen.class);
        startActivity(lisaaEdistyminen);
    }
    //päivittää listanäkymän
    public void onPaivitaClick (View v) {

        //saadaan tiedot jotka on lisätty yksitellen ja käännetään ne niiden oikeille muodoille jotka Edistyminen olio vaatii
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String paivamaara = prefs.getString(PVM, "ei löydy pvm");
        int ika = prefs.getInt(IKA, 0);
        float paino = prefs.getFloat(PAINO, (float) 0.0);
        float pituus = prefs.getFloat(PITUUS, (float) 0.0);
        float bmiArvo = prefs.getFloat(BMIARVO, (float) 0.0);
        String lisatiedotEdistys = prefs.getString(LISATIEDOT, "ei löydy lisatietoja");

        //jos on lisätty uusi tieto niin suorittaa seuraavan koodin
        if (!paivamaara.contains("ei löydy pvm")) {

            //lisää olion saaduilla tiedoilla olio listaan, tallentaa shared preferenceihin listana. hakee päivitetyn olio listan ja asettaa näkymän sen mukaan.
            edistymiset.add(new Edistyminen(paivamaara, ika, paino, pituus, bmiArvo, lisatiedotEdistys));
            tallennaDataListaan();
            haeDataLista();
            listView.setAdapter(adapter);

            //lopuksi poistaa yksittäiset shared preferencet, mutta ei listaa joka tallennettiin juuri äsken.
            //Ilman tätä painaessa päivitä tulisi sama edistys uudelleen.
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor edit = preferences.edit();
            edit.remove(PVM);
            edit.remove(IKA);
            edit.remove(PAINO);
            edit.remove(PITUUS);
            edit.remove(BMIARVO);
            edit.remove(LISATIEDOT);
            edit.apply();
        }
    }

    //tallentaa olio listan hyödyntämällä Gson/Json.
    public void tallennaDataListaan(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared list", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(edistymiset);
        editor.putString("edistymiset lista", json);
        editor.apply();

    }
    //hakee olio listan sisältämän datan.
    public void haeDataLista() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared list", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("edistymiset lista", null);
        Type type = new TypeToken<ArrayList<Edistyminen>>() {}.getType();
        edistymiset = gson.fromJson(json, type);

        if(edistymiset == null) {
            edistymiset = new ArrayList<>();
        }
    }
}
