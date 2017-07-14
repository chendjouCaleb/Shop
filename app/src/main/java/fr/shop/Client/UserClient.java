package fr.shop.Client;
import java.util.List;

import fr.shop.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chendjou on 09/07/2017.
 */

public interface UserClient {
    @GET("/api/users/{id}")
    Call<List<User>> getById(@Path("id")int id);

    @GET("/api/users/{id}")
    Call<User> findById(@Path("id")int id);
}
