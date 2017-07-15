package fr.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import fr.shop.BlurBuilder;
import fr.shop.CustomView.TitleBar;
import fr.shop.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_login);
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


    }
}
