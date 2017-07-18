package fr.shop.repository.api;

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
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.findById(id);
        call.enqueue(callback);
    }

    public void findByEmail(String email, Callback<User> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.findByEmail(email);
        call.enqueue(callback);
    }

    public void findByEmailAndPassword(String email,String password, Callback<User> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.findByEmailAndPassword(email, password);
        call.enqueue(callback);
    }





    public void save(final User user, Callback<User> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.save(user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword());
        call.enqueue(callback);
    }


    public Object delete(Object obj) {
        return null;
    }


    public Object update(Object obj) {
        return null;
    }
}
