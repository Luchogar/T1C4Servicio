package mx.grupogarcia.t1c4servicio.restApi;

//import com.coursera.sacbe.petagramaxelsegura.restApi.model.MascotaResponse;
import mx.grupogarcia.t1c4servicio.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
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
}
