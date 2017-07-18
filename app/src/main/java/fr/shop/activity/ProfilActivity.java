package fr.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import fr.shop.BlurBuilder;
import fr.shop.CustomView.TitleBar;
import fr.shop.R;
import fr.shop.entity.User;
import fr.shop.repository.api.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        View root = findViewById(R.id.root_layout);
        Button prevBtn = (Button) findViewById(R.id.prev_btn);
        TitleBar titleBar = new TitleBar(this, prevBtn);
        titleBar.handleBtn(this);


        Typeface lato = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");
        Typeface light = Typeface.createFromAsset(getAssets(), "fonts/Lato-Light.ttf");
        TextView username = (TextView) findViewById(R.id.username);
        TextView localisation = (TextView) findViewById(R.id.localisation);
        username.setTypeface(lato);
        localisation.setTypeface(light);

        RelativeLayout user_description = (RelativeLayout) findViewById(R.id.user_description);
        BlurBuilder.blurBackgroundWiew(this, user_description, R.drawable.messi);

        final TextView emailLabel = (TextView) findViewById(R.id.emailLabel);
        final TextView registrationDateLabel = (TextView) findViewById(R.id.registrationDateLabel);
        final TextView phoneLabel = (TextView) findViewById(R.id.phoneLabel);

        final TextView emailValue = (TextView) findViewById(R.id.emailValue);
        final TextView registrationDateValue = (TextView) findViewById(R.id.registrationDateValue);
        final TextView phoneValue = (TextView) findViewById(R.id.phoneValue);
        emailValue.setTypeface(lato);
        registrationDateValue.setTypeface(lato);
        registrationDateValue.setText(new Date().toString());
        phoneValue.setTypeface(lato);

        emailLabel.setTypeface(light);
        registrationDateLabel.setTypeface(light);
        phoneLabel.setTypeface(light);
        Intent i = getIntent();
        int id = i.getIntExtra(RegisterActivity.USER_ID, 0);
        Toast.makeText(this, "Vous avez choisi le bouton " + id, Toast.LENGTH_SHORT).show();
        hydrateView(username, emailValue, registrationDateValue, id);
    }
    public void hydrateView(final TextView name, final TextView email, final TextView date, int id){
        UserRepository userRepository = new UserRepository();
        if (id != 0){
            userRepository.findById(id, new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    name.setText(user.getName() + " " + user.getSurname());
                    email.setText(user.getEmail());
                    date.setText(user.getRegistrationDate());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        }
    }

    }

