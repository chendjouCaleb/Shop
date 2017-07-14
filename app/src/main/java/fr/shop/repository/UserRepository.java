package fr.shop.repository;

import fr.shop.Client.UserClient;
import fr.shop.R;
import fr.shop.entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chendjou on 09/07/2017.
 */

public class UserRepository{
    private static final String API_URL = "http://192.168.43.48:9000/";
    private Retrofit.Builder builder;
    public User user;

    public void findById(int id, Callback<User> callback) {
       String text = ("enter  ");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.findById(id);
        call.enqueue(callback);
    }



    public Object save(Object obj) {
        return null;
    }


    public Object delete(Object obj) {
        return null;
    }


    public Object update(Object obj) {
        return null;
    }
}
