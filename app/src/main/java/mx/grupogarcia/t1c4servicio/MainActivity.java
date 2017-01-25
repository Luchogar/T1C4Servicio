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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//import com.coursera.sacbe.petagramaxelsegura.adapter.PageAdapter;
//import com.coursera.sacbe.petagramaxelsegura.fragment.PerfilFragment;
//import com.coursera.sacbe.petagramaxelsegura.fragment.RecyclerViewFragment;

import mx.grupogarcia.t1c4servicio.fragment.RecyclerViewFragment;
import mx.grupogarcia.t1c4servicio.fragment.PerfilFragment;
import mx.grupogarcia.t1c4servicio.adapter.PageAdapter;
import mx.grupogarcia.t1c4servicio.restApi.IEndPointsApi;
import mx.grupogarcia.t1c4servicio.restApi.adapter.RestApiAdapter;
import mx.grupogarcia.t1c4servicio.restApi.model.UsuarioInstagram;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
            case R.id.mRecibirNotificaciones:
                Toast.makeText(this, getResources().getString(R.string.receiver), Toast.LENGTH_SHORT).show();
                String idDispositivo = FirebaseInstanceId.getInstance().getToken();
                String idUsuarioInstagram = obtenerCuentaConfigurada();

                enviarTokenRegistro(idDispositivo,idUsuarioInstagram);
                Toast.makeText(this, R.string.registration + " " + idUsuarioInstagram, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mFavoritos:
                Toast.makeText(this, getResources().getString(R.string.item_fav), Toast.LENGTH_SHORT).show();
                Intent iFav = new Intent(this, MascotaFavorita.class);
                startActivity(iFav);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    private void enviarTokenRegistro(String idDispositivo, String idUsuarioInstagram){

        Log.d("ID_DISPOSITIVO", idDispositivo);
        Log.d("ID_USUARIO_INSTAGRAM", idUsuarioInstagram);

        RestApiAdapter restApiAdapter = new RestApiAdapter();

        IEndPointsApi endpoints = restApiAdapter.establecerConexionRestApiHeroku();
        Call<UsuarioInstagram> usuarioResponseCall = endpoints.registrarUsuarioID(idDispositivo,idUsuarioInstagram);

        usuarioResponseCall.enqueue(new Callback<UsuarioInstagram>() {
            @Override
            public void onResponse(Call<UsuarioInstagram> call, Response<UsuarioInstagram> response) {
                UsuarioInstagram usuarioResponse = response.body();
                Log.d("ID", usuarioResponse.getId());
                Log.d("ID_DISPOSITIVO", usuarioResponse.getIdDispositivo());
                Log.d("ID_USUARIO_INSTAGRAM", usuarioResponse.getIdUsuarioInstagram());
            }

            @Override
            public void onFailure(Call<UsuarioInstagram> call, Throwable t) {

            }
        });


    }

    private String obtenerCuentaConfigurada(){

        SharedPreferences miPreferenciaCompartida = getSharedPreferences("MisDatosPersonales", Context.MODE_PRIVATE);

        String nombrePerfilActual = miPreferenciaCompartida.getString(getResources().getString(R.string.pNombrePerfil), "");

        return nombrePerfilActual;
    }

}


