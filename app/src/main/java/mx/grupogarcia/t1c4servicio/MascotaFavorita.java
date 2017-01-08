package mx.grupogarcia.t1c4servicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.TextView;

//import com.coursera.sacbe.petagramaxelsegura.adapter.MascotaAdaptador;
//import com.coursera.sacbe.petagramaxelsegura.fragment.IRecyclerViewFavoritas;
//import com.coursera.sacbe.petagramaxelsegura.pojo.FotoMascota;
//import com.coursera.sacbe.petagramaxelsegura.pojo.Mascota;
//import com.coursera.sacbe.petagramaxelsegura.presentador.IRecyclerViewFavoritasPresenter;
//import com.coursera.sacbe.petagramaxelsegura.presentador.RecyclerViewFavoritasPresenter;

import mx.grupogarcia.t1c4servicio.adapter.MascotaAdaptador;
import mx.grupogarcia.t1c4servicio.fragment.IRecyclerViewFavoritas;
import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;
import mx.grupogarcia.t1c4servicio.pojo.Mascota;
import mx.grupogarcia.t1c4servicio.presentador.IRecyclerViewFavoritasPresenter;
import mx.grupogarcia.t1c4servicio.presentador.RecyclerViewFavoritasPresenter;


import java.util.ArrayList;

/**
 * Created by Luis García on 03/01/2017.
 */
public class MascotaFavorita extends AppCompatActivity implements IRecyclerViewFavoritas {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private TextView tituloPantalla;
    private IRecyclerViewFavoritasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotaFav);
        presenter = new RecyclerViewFavoritasPresenter(this, getBaseContext());

        //inicializarListaMascotas();
        //inicializarAdaptador();
    }

    /*
    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.husky, "Miky", "Husky"));
        mascotas.add(new Mascota(R.drawable.bostonterrier, "Terry", "Boston Terrier"));
        //mascotas.add(new Mascota(R.drawable.braco, "Toth", "Braco"));
        mascotas.add(new Mascota(R.drawable.chowchow, "Oso", "Chow Chow"));
        mascotas.add(new Mascota(R.drawable.bullterrier, "Seth", "Bull Terrier"));
        //mascotas.add(new Mascota(R.drawable.foxhound, "Lasha", "Foxhound"));
        //mascotas.add(new Mascota(R.drawable.goldenretriever, "Anubis", "Golden Retriever"));
        //mascotas.add(new Mascota(R.drawable.pastoraustraliano, "Boby", "Pastor Australiano"));
        mascotas.add(new Mascota(R.drawable.perrocrestado, "Pelos", "Crestado"));

    }
    */

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MascotaFavorita.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public void generarLinearLyout() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<FotoMascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}