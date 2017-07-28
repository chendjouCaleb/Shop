package fr.shop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.shop.CustomView.MenuItem;
import fr.shop.CustomView.PersonnalFont;
import fr.shop.CustomView.SimpleArticle;
import fr.shop.CustomView.TitleBar;
import fr.shop.R;
import fr.shop.entity.Article;
import fr.shop.entity.Category;

public class ArticleDescriptionActivity extends Activity {
    public static final String ARTICLE_ID = "fr.shop.activity.ARTICLE_ID";
    public Category category;
    Article articles;
    Layout root;
    TextView articleName;
    TextView articlePrice;
    TextView shippingTime;
    TextView disponibility;
    TextView descriptionLabel;
    TextView articleDescription;
    ImageView articleImage;
    Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_description);

        Button prevBtn = (Button) findViewById(R.id.prev_btn);
        Button cartBtn = (Button) findViewById(R.id.cart_btn);
        Button likeBtn = (Button) findViewById(R.id.like_btn);
        Button timeBtn = (Button) findViewById(R.id.time_btn);
        checkBtn = (Button) findViewById(R.id.check_btn);


        articleName = (TextView) findViewById(R.id.article_name);
        articleImage = (ImageView) findViewById(R.id.article_image);
        shippingTime = (TextView) findViewById(R.id.shipping_time);
        articlePrice = (TextView) findViewById(R.id.article_price);
        disponibility = (TextView) findViewById(R.id.article_disponibility);
        descriptionLabel = (TextView) findViewById(R.id.article_description_label);
        articleDescription = (TextView) findViewById(R.id.article_description);

        PersonnalFont.setFont(this, descriptionLabel, PersonnalFont.LATO_BOLD);
        PersonnalFont.setFont(this, articleDescription, PersonnalFont.LATO);
        TitleBar titleBar = new TitleBar(this);
        titleBar.handleprevBtn(prevBtn);
        titleBar.handleCartBtn(cartBtn);
        titleBar.handleLikeBtn(likeBtn);
        titleBar.handleTimeBtn(timeBtn);
        PersonnalFont.setFont(this, checkBtn, PersonnalFont.SEGOE_MDL2_ASSETS);


        Category c1 = new Category(1, "Ordinateur");
        Article a1 = new Article();
        a1.setName("HP Pavillon 15");
        a1.setPrice(245000);
        a1.setAmount(0);
        a1.setDescription("loremmddjfje fzeiezfoefljjfffjjjf frrrrrrrrrrrrrrrrr rrrrrrrrrrrrrrrrrrrrrrrr");
        a1.setCategory(c1);

        hydrateArticle(a1);
    }

    public void hydrateArticle(Article article){
        articleName.setText(article.getName());
        shippingTime.setText("5 jours");

        if(article.getAmount() > 0){
            checkBtn.setText(R.string.check_icon);
            disponibility.setText("En STOCK (" + article.getAmount() +")");
        }else{
            checkBtn.setText(R.string.out_icon);
            checkBtn.setTextColor(getResources().getColor(R.color.errorColor));
            disponibility.setText("sTOCK épuisé");
        }
        disponibility.setAllCaps(true);

        articleDescription.setText(article.getDescription());
        articlePrice.setText(article.formatPrice());
    }
}
