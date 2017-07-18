package fr.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.shop.BlurBuilder;
import fr.shop.CustomView.TitleBar;
import fr.shop.R;
import fr.shop.entity.User;
import fr.shop.repository.api.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static fr.shop.activity.RegisterActivity.USER_ID;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View root = findViewById(R.id.root_layout);
        BlurBuilder.blurBackgroundWiew(this, root, R.drawable.maxresdefault);

        Button prevBtn = (Button) findViewById(R.id.prev_btn);
        TitleBar titleBar = new TitleBar(this, prevBtn);
        titleBar.handleBtn(this);

        final EditText emailEdit = (EditText) findViewById(R.id.EditTextEmail);
        final EditText passwordEdit = (EditText) findViewById(R.id.EditTextPassword);
        final TextView textError = (TextView) findViewById(R.id.ConnectionError);
        final Button submit = (Button) findViewById(R.id.loginBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textError.setVisibility(View.VISIBLE);
                textError.setText("");
                String email = emailEdit.getText().toString().trim();
                String password = passwordEdit.getText().toString().trim();
                if(email == null || password == null){
                    textError.setText("Veuillez renseigner votre adresse électronique et votre mot de passe");
                    textError.setVisibility(View.VISIBLE);
                }else{
                    UserRepository userRepository = new UserRepository();
                    userRepository.findByEmailAndPassword(email, password, new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            int id = response.body().getId();
                            submit.setText("connection réussie");
                            Intent profil = new Intent(LoginActivity.this, ProfilActivity.class);
                            profil.putExtra(USER_ID, id);
                            startActivity(profil);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            textError.setText("Echec de la connection. Cause: " +t.getMessage());
                            textError.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }
        });



    }
}
