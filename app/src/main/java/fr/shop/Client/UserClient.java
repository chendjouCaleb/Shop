package fr.shop.Client;
import java.util.List;

import fr.shop.entity.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Chendjou on 09/07/2017.
 */

public interface UserClient {
    @GET("/api/users/{email}")
    Call<User> findByEmail(@Path("email")String email);

    @GET("/api/users/{id}")
    Call<User> findById(@Path("id")int id);

    @POST("/api/users")
    @FormUrlEncoded
    Call<User> save(
            @Field("name") String name,
            @Field("surname") String surname,
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("/api/users/auth")
    @FormUrlEncoded
    Call<User> findByEmailAndPassword(
            @Field("email") String email,
            @Field("password") String password
    );
}
