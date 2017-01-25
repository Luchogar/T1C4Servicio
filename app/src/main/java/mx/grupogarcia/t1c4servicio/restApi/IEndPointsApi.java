package mx.grupogarcia.t1c4servicio.restApi;

import mx.grupogarcia.t1c4servicio.restApi.model.MascotaResponse;
import mx.grupogarcia.t1c4servicio.restApi.model.MascotaResponse;

import mx.grupogarcia.t1c4servicio.restApi.model.UsuarioInstagram;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Luis García on 03/01/2017.
 */
public interface IEndPointsApi {
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET(ConstantesRestApi.URL_SEARCH_USER_BY_NAME)
    Call<MascotaResponse> getUserByName(@Query("q") String userName);

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
    Call<MascotaResponse> getRecentMedia(@Path("user-id") Long userId);

    @GET(ConstantesRestApi.URL_GET_FOLLOWED_BY)
    Call<MascotaResponse> getFollowedBy();
    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioInstagram> registrarTokenID(@Field("token") String token);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_REGISTRAR_USUARIO)
    Call<UsuarioInstagram> registrarUsuarioID(@Field("idDispositivo") String idDispositivo, @Field("idUsuarioInstagram") String idUsuarioInstagram);


}
