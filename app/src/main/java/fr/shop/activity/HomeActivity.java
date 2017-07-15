package fr.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import fr.shop.BlurBuilder;
import fr.shop.R;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        View root = (View) findViewById(R.id.root_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maxresdefault);
        Bitmap blurredBitmap = BlurBuilder.blur( this, originalBitmap );
        root.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        Button signin_btn = (Button) findViewById(R.id.signin_btn);
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(HomeActivity.this, ProfilActivity.class);
                startActivity(login);
            }
        });
        final TextView result = (TextView) findViewById(R.id.result);
        Typeface latoLight = Typeface.createFromAsset(getAssets(), "fonts/Lato-Light.ttf");
        Button u = (Button) findViewById(R.id.register);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profil = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(profil);
            }
        });
        TextView description = (TextView)findViewById(R.id.description);
        description.setTypeface(latoLight);



    }
}
