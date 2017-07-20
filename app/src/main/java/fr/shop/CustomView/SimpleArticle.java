package fr.shop.CustomView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.shop.R;

/**
 * Created by Chendjou on 19/07/2017.
 */

public class SimpleArticle extends LinearLayout {
    public int width;
    public int height;
    private Activity activity;
    private LinearLayout.LayoutParams textLayout ;
    public SimpleArticle(Context context, Activity activity) {
        super(context);
        setSize(activity.getWindowManager());
        this.activity = activity;
        init();
    }

    public SimpleArticle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleArticle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.setOrientation(VERTICAL);
        this.setBackgroundResource(R.drawable.article);

        textLayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        textLayout.setMargins(10,10,10,10);

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        p.setMargins(50,50,50,50);
        this.setLayoutParams(p);
        this.setPadding(5,5,5,5);

        this.addImage();
        this.addName();
        this.addPrice();

    }

    public void setSize(WindowManager windowManager){
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = (size.x - 40)/2;
        height = (size.y -20)/3;
        //this.setMeasuredDimension(width, width);
    }

    private void addImage(){
        ImageView image = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width,height);
        image.setLayoutParams(params);
        image.setImageResource(R.drawable.hppavillon);
        image.setBackgroundResource(R.drawable.border_bottom_normal);
        this.addView(image);
    }

    private void addName(){
        TextView name = new TextView(getContext());
        name.setTextColor(getResources().getColor(R.color.colorWhite));
        name.setText("HPPAVILLON");
        name.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        PersonnalFont.setFont(activity,name, PersonnalFont.LATO_LIGHT);
        name.setLayoutParams(textLayout);
        this.addView(name);
    }
    private void addPrice(){
        TextView name = new TextView(getContext());
        name.setText("245 000 FCFA");
        PersonnalFont.setFont(activity,name, PersonnalFont.LATO_BOLD);
        name.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        name.setTextColor(getResources().getColor(R.color.colorWhite));
        name.setLayoutParams(textLayout);
        this.addView(name);
    }



}
