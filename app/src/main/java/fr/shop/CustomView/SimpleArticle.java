package fr.shop.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import fr.shop.R;

/**
 * Created by Chendjou on 19/07/2017.
 */

public class SimpleArticle extends LinearLayout {
    public SimpleArticle(Context context) {
        super(context);
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
    }
}
