package mx.grupogarcia.t1c4servicio.fragment;

//import com.coursera.sacbe.petagramaxelsegura.adapter.FotoMascotaAdaptador;
//import com.coursera.sacbe.petagramaxelsegura.pojo.FotoMascota;

import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;
import mx.grupogarcia.t1c4servicio.adapter.FotoMascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by Luis García on 03/01/2017.
 */
public interface IRecyclerViewFragmentFoto {

    public FotoMascotaAdaptador crearAdaptador(ArrayList<FotoMascota> mascotas);

    public void inicializarAdaptador(FotoMascotaAdaptador adaptador);

    public void generarGridLyout();

    //public void generarLinearLyout();

}
