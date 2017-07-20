package fr.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.shop.BlurBuilder;
import fr.shop.CustomView.MenuItem;
import fr.shop.CustomView.PersonnalFont;
import fr.shop.CustomView.SimpleArticle;
import fr.shop.CustomView.TitleBar;
import fr.shop.R;
import fr.shop.entity.Article;
import fr.shop.entity.Category;
import fr.shop.entity.User;
import fr.shop.repository.api.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static fr.shop.activity.RegisterActivity.USER_ID;

public class ShopActivity extends Activity {

    public Category category;
    List<Article> articles;
    GridLayout gridLayout;
    LinearLayout menuLayout;
    String textFilter;
    EditText textFilterInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        articles = new ArrayList<Article>();
        View root = findViewById(R.id.root_layout);
        menuLayout = (LinearLayout)findViewById(R.id.menu);
        textFilterInput = (EditText) findViewById(R.id.text_filter);
        textFilterInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                textFilter = textFilterInput.getText().toString();
                Toast.makeText(ShopActivity.this, "Pattern: " + textFilter, Toast.LENGTH_LONG).show();
                hydrateShop(ShopActivity.this);
                return false;
            }
        });

        Button menuBtn = (Button) findViewById(R.id.menu_btn);
        Button cartBttn = (Button) findViewById(R.id.cart_btn);
        TitleBar titleBar = new TitleBar(this, menuBtn);
        titleBar.handleMenuBtn(menuBtn);
        titleBar.handleCartBtn(cartBttn);

        TextView iconSearch = (TextView) findViewById(R.id.icon_search);
        iconSearch.setText(R.string.search_icon);
        PersonnalFont.setFont(this, iconSearch, PersonnalFont.SEGOE_MDL2_ASSETS);
        gridLayout = (GridLayout) findViewById(R.id.article_grid);

        Category c1 = new Category(1, "Ordinateur");
        Category c2 = new Category(2, "Frigo");
        Category c3 = new Category(3, "Téléviseur");
        Category c4 = new Category(4, "Téléphone");
        Category c5 = new Category(5, "Tablettes");

        MenuItem m1 = new MenuItem(this, c1);
        MenuItem m2 = new MenuItem(this, c2);
        MenuItem m3 = new MenuItem(this, c3);
        MenuItem m4 = new MenuItem(this, c4);
        MenuItem m5 = new MenuItem(this, c5);
        menuLayout.addView(m1);
        menuLayout.addView(m2);
        menuLayout.addView(m3);
        menuLayout.addView(m4);
        menuLayout.addView(m5);


        Article a1 = new Article();
        a1.setName("HP Pavillon 15");
        a1.setPrice(245000);
        a1.setCategory(c1);
        Article a2 = new Article();
        a2.setName("Acer Travel Mate P253");
        a2.setPrice(200000);
        a2.setCategory(c1);

        Article a3 = new Article();
        a3.setName("Surface Pro 3");
        a3.setPrice(1450000);
        a3.setCategory(c2);

        Article a4 = new Article();
        a4.setName("Apple Mac Book");
        a4.setPrice(1350000);
        a4.setCategory(c2);



        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        hydrateShop(this);


    }

    public void hydrateShop(Activity activity){
        String text = null;
        if(textFilter != null && textFilter.trim().length() > 0){
            text = textFilter.trim().toLowerCase();
        }
        List<Article> finalList = new ArrayList<>();
        gridLayout.removeAllViewsInLayout();
        if(category == null && text == null){
            finalList = articles;
        }else if(category != null && text == null){
            for(Article article: articles){
                if(article.getCategory().equals(category)){
                    finalList.add(article);
                }
            }
        }else if(category == null && text != null){
            for(Article article: articles){
                if(article.getName().toLowerCase().contains(text)){
                    finalList.add(article);
                }
            }
        }else if(category != null && textFilter != null){
            for(Article article: articles){
                if(article.getCategory().equals(category) && article.getName().toLowerCase().contains(text)){
                    finalList.add(article);
                }
            }
        }

        for(Article article: finalList){
            SimpleArticle sa = new SimpleArticle(gridLayout.getContext(), activity, article);
            gridLayout.addView(sa);
        }
    }

    public void hygrateMenu(){

    }
}
