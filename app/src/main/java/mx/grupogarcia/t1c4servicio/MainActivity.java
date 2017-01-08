package mx.grupogarcia.t1c4servicio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//import com.coursera.sacbe.petagramaxelsegura.adapter.PageAdapter;
//import com.coursera.sacbe.petagramaxelsegura.fragment.PerfilFragment;
//import com.coursera.sacbe.petagramaxelsegura.fragment.RecyclerViewFragment;

import mx.grupogarcia.t1c4servicio.fragment.RecyclerViewFragment;
import mx.grupogarcia.t1c4servicio.fragment.PerfilFragment;
import mx.grupogarcia.t1c4servicio.adapter.PageAdapter;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        setUpViewPager();

        if(toolbar != null){

            setSupportActionBar(toolbar);
        }

        estableceCuentaInstagramDefault();

    }

    public void estableceCuentaInstagramDefault(){

        SharedPreferences miPreferenciaCompartida = getSharedPreferences("MisDatosPersonales", Context.MODE_PRIVATE);

        String nombrePerfilActual = miPreferenciaCompartida.getString(getResources().getString(R.string.pNombrePerfil), "");

        if(nombrePerfilActual==""){

            SharedPreferences.Editor editor = miPreferenciaCompartida.edit();
            editor.putString(getResources().getString(R.string.pNombrePerfil), getResources().getString(R.string.cuentaInstagramDefault));
            editor.commit();
        }

    }

    private void  setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_pet_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet_footprint);
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_petagram, menu);
        return true;
        /*MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_petagram, menu);
        return true;
        */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Toast.makeText(this, getResources().getString(R.string.item_about), Toast.LENGTH_SHORT).show();
                Intent iAbout = new Intent(this, AboutActivity.class);
                startActivity(iAbout);
                break;
            case R.id.mContact:
                Toast.makeText(this, getResources().getString(R.string.item_contact), Toast.LENGTH_SHORT).show();
                Intent iContact = new Intent(this, ContactActivity.class);
                startActivity(iContact);
                break;
            case R.id.mConfig:
                Toast.makeText(this, getResources().getString(R.string.item_config), Toast.LENGTH_SHORT).show();
                Intent iConfig = new Intent(this, ConfigurarCuenta.class);
                startActivity(iConfig);
                break;
            case R.id.mFavoritos:
                Toast.makeText(this, getResources().getString(R.string.item_fav), Toast.LENGTH_SHORT).show();
                Intent iFav = new Intent(this, MascotaFavorita.class);
                startActivity(iFav);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
