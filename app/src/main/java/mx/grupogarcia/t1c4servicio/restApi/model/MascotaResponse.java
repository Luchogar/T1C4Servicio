package mx.grupogarcia.t1c4servicio.restApi.model;

//import com.coursera.sacbe.petagramaxelsegura.pojo.FotoMascota;
import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;

import java.util.ArrayList;

/**
 * Created by Luis García on 03/01/2017.
 */
public class MascotaResponse {

    private ArrayList<FotoMascota> mascotas;
    //private ArrayList<>
    private FotoMascota userInformation;

    public ArrayList<FotoMascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<FotoMascota> mascotas) {
        this.mascotas = mascotas;
    }

    public FotoMascota getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(FotoMascota userInformation) {
        this.userInformation = userInformation;
    }
}
