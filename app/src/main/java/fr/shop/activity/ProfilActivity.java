package fr.shop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.shop.CustomView.RoundedImageView;
import fr.shop.R;
import fr.shop.entity.User;
import fr.shop.repository.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Chendjou on 09/07/2017.
 */

public class ProfilActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);}
        View root = findViewById(R.id.root_layout);
    ImageView img = new RoundedImageView(this.getApplicationContext());



        /*final TextView name = (TextView) findViewById(R.id.name);
        final TextView surname = (TextView) findViewById(R.id.surname);
        final TextView email = (TextView) findViewById(R.id.email);
        final TextView date = (TextView) findViewById(R.id.date);
        final TextView error = (TextView) findViewById(R.id.error);
        final Button submit = (Button) findViewById(R.id.submit);
        final TextView search_id = (TextView) findViewById(R.id.search_id);
        final Callback<User> call = new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                name.setText("Nom: " + user.getName());
                email.setText("Prénom: " + user.getEmail());
                surname.setText("Adresse électronique: " + user.getSurname());
                date.setText("Date d'enregistrement: " + user.getRegistrationDate());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                error.setVisibility(View.VISIBLE);
                error.setText("Echec de la demande\nCause: " + t.getMessage());

            }
        };
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setVisibility(View.INVISIBLE);
                int id = 0;
                try{
                    id=Integer.parseInt(search_id.getText().toString());
                    UserRepository repository = new UserRepository();
                    repository.findById(id, call);
                }catch (Exception e){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Veuillez me donner un nombre correct");
                }
            }
        });
*/

    }

