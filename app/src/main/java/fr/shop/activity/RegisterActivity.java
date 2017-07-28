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
import fr.shop.form.RegisterForm;
import fr.shop.repository.api.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends Activity {
public static final String USER_ID = "fr.shop.activity.USER_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        View root = findViewById(R.id.root_layout);
        BlurBuilder.blurBackgroundWiew(this, root,R.drawable.maxresdefault);

        Button prevBtn = (Button) findViewById(R.id.prev_btn);
        TitleBar titleBar = new TitleBar(this, prevBtn);
        titleBar.handleBtn(this);

        final RegisterForm form = new RegisterForm();

        final EditText email = (EditText) findViewById(R.id.EditTextEmail);
        final EditText name = (EditText) findViewById(R.id.EditTextName);
        final EditText surname = (EditText) findViewById(R.id.EditTextSurname);
        final EditText password = (EditText) findViewById(R.id.EditTextPassword);
        final EditText passwordConf = (EditText) findViewById(R.id.EditTextPasswordConfirmation);

        final TextView nameError = (TextView) findViewById(R.id.EditTextNameError);
        final TextView surnameError = (TextView) findViewById(R.id.EditTextSurnameError);
        final TextView passwordError = (TextView) findViewById(R.id.EditTextPasswordError);
        final TextView passwordConfError = (TextView) findViewById(R.id.EditTextPasswordConfirmationError);
        final TextView emailError = (TextView) findViewById(R.id.EditTextEmailError);

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                form.validEmail(email,emailError);
            }
        });
        final Button submit = (Button) findViewById(R.id.register_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                form.validName(name,nameError);
                form.validSurname(surname,surnameError);
                form.validEmail(email,emailError);
                form.validPassword(password,passwordError);
                form.validPasswordConf(password, passwordConf, passwordConfError);

                if(form.isValid()){
                    submit.setText("Le formulaire est valide");
                    User user = new User();

                    user.setName(name.getText().toString());
                    user.setSurname(surname.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassword(password.getText().toString());
                    UserRepository userRepository = new UserRepository();
                    userRepository.save(user, new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            int id = response.body().getId();
                            submit.setText("Enregistrement réussi");
                            Intent profil = new Intent(RegisterActivity.this, ShopActivity.class);

                            //profil.putExtra(USER_ID, id);
                            startActivity(profil);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            submit.setText("Echec de l'enregistrement");
                            passwordConfError.setText(t.getMessage());
                            passwordConfError.setVisibility(View.VISIBLE);
                        }
                    });
                }else{
                    submit.setText("Le formulaire est invalide");
                }
            }
        });

    }
}
