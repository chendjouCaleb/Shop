package fr.shop.repository.api;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

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
        Call<User> call = client.findByEmailAndPassword(email, CryptToSHA256(password));
        call.enqueue(callback);
    }

    public void save(final User user, Callback<User> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.save(user.getName(),
                user.getSurname(),
                user.getEmail(),
                CryptToSHA256(user.getPassword()));
        call.enqueue(callback);
    }


    public Object delete(Object obj) {
        return null;
    }


    public Object update(Object obj) {
        return null;
    }
    public String CryptToSHA256(String word){
        String sha1 = null;
        try{
            MessageDigest crypt = MessageDigest.getInstance("SHA-256");
            crypt.reset();
            crypt.update(word.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return sha1;
    }

    private String byteToHex(final byte[] hash){
        Formatter formatter = new Formatter();
        for(byte b: hash){
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
