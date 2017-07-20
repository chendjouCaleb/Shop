package fr.shop.CustomView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.shop.R;

import static android.app.Activity.RESULT_OK;

/**
 * TODO: document your custom view class.
 */
public class TitleBar{
    Button btn;
    TextView label;
    Activity activity;
    public TitleBar(Activity context, Button btn){
        this.btn = btn;
        this.activity = context;
    }

    public TitleBar(Activity context){
        this.activity = context;
    }

    public void handleBtn(final Activity activity){
        btn.setText(R.string.back_icon);
        PersonnalFont.setFont(activity, btn, PersonnalFont.SEGOE_MDL2_ASSETS);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                activity.setResult(RESULT_OK, intent);
                activity.finish();

            }
        });
    }

    public void handleCartBtn(final Button btn){
        btn.setText(R.string.cart_icon);
        PersonnalFont.setFont(activity, btn, PersonnalFont.SEGOE_MDL2_ASSETS);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                activity.setResult(RESULT_OK, intent);
                activity.finish();

            }
        });*/
    }

    public void handleLikeBtn(final Button btn){
        btn.setText(R.string.star_icon);
        PersonnalFont.setFont(activity, btn, PersonnalFont.SEGOE_MDL2_ASSETS);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText(R.string.star_fill_icon);
            }
        });
    }

    public void handleTimeBtn(final Button btn){
        btn.setText(R.string.time_icon);
        PersonnalFont.setFont(activity, btn, PersonnalFont.SEGOE_MDL2_ASSETS);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText(R.string.star_fill_icon);
            }
        });*/
    }

    public void handleprevBtn(final Button btn){
        btn.setText(R.string.back_icon);
        PersonnalFont.setFont(activity, btn, PersonnalFont.SEGOE_MDL2_ASSETS);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                activity.setResult(RESULT_OK, intent);
                activity.finish();

            }
        });
    }

    public void handleMenuBtn(final Button btn){
        btn.setText(R.string.menu_icon);
        PersonnalFont.setFont(activity, btn, PersonnalFont.SEGOE_MDL2_ASSETS);
       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                activity.setResult(RESULT_OK, intent);
                activity.finish();

            }
        });*/
    }

    private void handleLabel(){

    }

    private void handleLayout(){
    }
}
