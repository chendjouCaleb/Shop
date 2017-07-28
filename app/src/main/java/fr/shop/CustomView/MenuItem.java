package fr.shop.CustomView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.shop.R;
import fr.shop.activity.ShopActivity;
import fr.shop.entity.Article;
import fr.shop.entity.Category;

/**
 * Created by Chendjou on 20/07/2017.
 */

public class MenuItem extends TextView {
    private Category category;
    private ShopActivity shopActivity;
    public static List<MenuItem> items = new ArrayList<MenuItem>();
    public MenuItem(ShopActivity shopActivity, Category category) {
        super(shopActivity);
        this.shopActivity = shopActivity;
        this.category = category;
        items.add(this);
        init();
        addEvent();
    }

    private void init(){
        this.setTextColor(getResources().getColor(R.color.colorWhite));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20,0,20,0);
        this.setLayoutParams(params);
        this.setPadding(0,0,0,20);
        this.setText(category.getName());

    }

    private void addEvent(){
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBorder();
                MenuItem.this.setPadding(20,20,20,20);
                MenuItem.this.setBackgroundResource(R.drawable.border_bottom_focuses);
                shopActivity.category = category;

                Toast.makeText(shopActivity, "Catégories: "+ category.getName(),Toast.LENGTH_LONG).show();
                shopActivity.hydrateShop(shopActivity);
            }
        });
    }

    private void removeBorder(){
        for(MenuItem item:items){
            item.setBackgroundColor(Color.argb(0,0,0,0));
        }
    }
}
