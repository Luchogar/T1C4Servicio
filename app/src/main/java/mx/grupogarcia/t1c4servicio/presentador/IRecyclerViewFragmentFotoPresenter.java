package mx.grupogarcia.t1c4servicio.presentador;

//import com.coursera.sacbe.petagramaxelsegura.pojo.FotoMascota;
import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;

import java.util.ArrayList;

/**
 * Created by Luis García on 03/01/2017.
 */
public interface IRecyclerViewFragmentFotoPresenter {

    public void mostrarMascotasRV();

    public void obtenerMediosRecientes();

    public ArrayList<FotoMascota> getFotosMascotas();

    public void obtenerUserId(String userName);

    //public void obtenerSeguidores();

}
