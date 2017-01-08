package mx.grupogarcia.t1c4servicio.fragment;

//import com.coursera.sacbe.petagramaxelsegura.adapter.MascotaAdaptador;
//import com.coursera.sacbe.petagramaxelsegura.pojo.FotoMascota;

import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;
import mx.grupogarcia.t1c4servicio.adapter.MascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by Luis García on 03/01/2017.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLyout();

    public MascotaAdaptador crearAdaptador(ArrayList<FotoMascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
