package mx.grupogarcia.t1c4servicio.restApi.adapter;

//import com.coursera.sacbe.petagramaxelsegura.restApi.ConstantesRestApi;
//import com.coursera.sacbe.petagramaxelsegura.restApi.IEndPointsApi;
//import com.coursera.sacbe.petagramaxelsegura.restApi.deserializador.MascotaDeserializador;
//import com.coursera.sacbe.petagramaxelsegura.restApi.deserializador.SeguidorDeserializador;
//import com.coursera.sacbe.petagramaxelsegura.restApi.deserializador.UsuarioDeserializador;
//import com.coursera.sacbe.petagramaxelsegura.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mx.grupogarcia.t1c4servicio.restApi.model.MascotaResponse;
import mx.grupogarcia.t1c4servicio.restApi.deserializador.UsuarioDeserializador;
import mx.grupogarcia.t1c4servicio.restApi.deserializador.SeguidorDeserializador;
import mx.grupogarcia.t1c4servicio.restApi.deserializador.MascotaDeserializador;
import mx.grupogarcia.t1c4servicio.restApi.IEndPointsApi;
import mx.grupogarcia.t1c4servicio.restApi.ConstantesRestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luis García on 03/01/2017.
 */
public class RestApiAdapter {

    public IEndPointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndPointsApi.class);

    }

    public Gson construyeGsonDeserializadorMediaRecent(){

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorUserInformation(){

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new UsuarioDeserializador());

        return gsonBuilder.create();

    }

    public Gson construyeGsonDeserializadorSeguidores(){

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new SeguidorDeserializador());

        return gsonBuilder.create();

    }

}
