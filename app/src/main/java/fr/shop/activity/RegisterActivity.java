package fr.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.shop.BlurBuilder;
import fr.shop.R;
import fr.shop.form.RegisterForm;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        View root = findViewById(R.id.root_layout);
        BlurBuilder.blurBackgroundWiew(this, root);

        Typeface SegoeMDL2Assets = Typeface.createFromAsset(getAssets(), "fonts/segoe-mdl2-assets.ttf");
        Button prevBtn = (Button) findViewById(R.id.prev_btn);
        prevBtn.setTypeface(SegoeMDL2Assets);
        prevBtn.setText(R.string.back_icon);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });


        /*RegisterForm form = new RegisterForm();
        form.validName(name,nameError);
        form.validSurname(surname,surnameError);
        form.validEmail(email,emailError);
        form.validPasswordOne(password,passwordError);
        form.validPasswordConf(password, passwordConf, passwordError);
*/
        final Button submit = (Button) findViewById(R.id.register_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nameError = (TextView) findViewById(R.id.EditTextNameError);
                TextView surnameError = (TextView) findViewById(R.id.EditTextSurnameError);
                TextView emailError = (TextView) findViewById(R.id.EditTextEmailError);
                TextView passwordError = (TextView) findViewById(R.id.EditTextPasswordError);
                TextView passwordConfError = (TextView) findViewById(R.id.EditTextPasswordConfirmationError);

                EditText name = (EditText) findViewById(R.id.EditTextName);
                EditText surname = (EditText) findViewById(R.id.EditTextSurname);
                EditText email = (EditText) findViewById(R.id.EditTextEmail);
                EditText password = (EditText) findViewById(R.id.EditTextPassword);
                EditText passwordConf = (EditText) findViewById(R.id.EditTextPasswordConfirmation);



                RegisterForm form = new RegisterForm();
                form.validName(name,nameError);
                form.validSurname(surname,surnameError);
                form.validEmail(email,emailError);
                form.validPasswordOne(password,passwordError);
                form.validPasswordConf(password, passwordConf, passwordConfError);

                if(form.isValid()){
                    submit.setText("Le formulaire est valide");
                }else{
                    submit.setText("Le formulaire est invalide");
                }
            }
        });

    }
}
