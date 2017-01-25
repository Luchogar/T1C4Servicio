package mx.grupogarcia.t1c4servicio.restApi.adapter;


import com.google.gson.Gson;
import retrofit2.Retrofit;
import com.google.gson.GsonBuilder;
import mx.grupogarcia.t1c4servicio.restApi.IEndPointsApi;
import retrofit2.converter.gson.GsonConverterFactory;
import mx.grupogarcia.t1c4servicio.restApi.ConstantesRestApi;
import mx.grupogarcia.t1c4servicio.restApi.model.MascotaResponse;
import mx.grupogarcia.t1c4servicio.restApi.deserializador.UsuarioDeserializador;
import mx.grupogarcia.t1c4servicio.restApi.deserializador.SeguidorDeserializador;
import mx.grupogarcia.t1c4servicio.restApi.deserializador.MascotaDeserializador;






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

    public IEndPointsApi establecerConexionRestApiHeroku(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.HEROKU_ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(IEndPointsApi.class);

    }


}
