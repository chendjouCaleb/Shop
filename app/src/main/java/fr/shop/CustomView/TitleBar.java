package fr.shop.CustomView;

import android.content.Context;
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

/**
 * TODO: document your custom view class.
 */
public class TitleBar extends LinearLayout {
    Button backButton;
    TextView title;
    public TitleBar(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        addBackButton();
        addTitle();
    }

    public void addBackButton() {
        this.backButton = new Button(getContext());
        backButton.setText("prev");
    }

    public void addTitle(){
        title = new TextView(getContext());
        title.setText("bonjour");
    }
}
