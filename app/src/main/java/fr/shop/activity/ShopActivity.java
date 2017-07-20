package fr.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import fr.shop.BlurBuilder;
import fr.shop.CustomView.PersonnalFont;
import fr.shop.CustomView.SimpleArticle;
import fr.shop.CustomView.TitleBar;
import fr.shop.R;
import fr.shop.entity.User;
import fr.shop.repository.api.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static fr.shop.activity.RegisterActivity.USER_ID;

public class ShopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        View root = findViewById(R.id.root_layout);

        Button menuBtn = (Button) findViewById(R.id.menu_btn);
        Button cartBttn = (Button) findViewById(R.id.cart_btn);
        TitleBar titleBar = new TitleBar(this, menuBtn);
        titleBar.handleMenuBtn(menuBtn);
        titleBar.handleCartBtn(cartBttn);

        TextView iconSearch = (TextView) findViewById(R.id.icon_search);
        iconSearch.setText(R.string.search_icon);
        PersonnalFont.setFont(this, iconSearch, PersonnalFont.SEGOE_MDL2_ASSETS);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.article_grid);
        SimpleArticle sa = new SimpleArticle(this, this);
        gridLayout.addView(sa);

        SimpleArticle sa1 = new SimpleArticle(this, this);
        gridLayout.addView(sa1);

        SimpleArticle sa2 = new SimpleArticle(this, this);
        gridLayout.addView(sa2);

        SimpleArticle sa3 = new SimpleArticle(this, this);
        gridLayout.addView(sa3);

        SimpleArticle sa4 = new SimpleArticle(this, this);
        gridLayout.addView(sa4);
    }
}
