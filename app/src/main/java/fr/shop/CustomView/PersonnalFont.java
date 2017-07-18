package fr.shop.CustomView;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Chendjou on 18/07/2017.
 */

public class PersonnalFont {
    public static String LATO_REGULAR = "Lato-Regular";
    public static String LATO_LIGHT = "Lato-Light";
    public static String SEGOE_MDL2_ASSETS = "segoe-mdl2-assets.ttf";

    public static void setFont(Activity activity,TextView view, String font){
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/" + font);
        view.setTypeface(typeface);
    }

    public static void setFont(Activity activity, Button view, String font){
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/" + font);
        view.setTypeface(typeface);
    }

    public static void setFont(Activity activity, EditText view, String font){
        Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/" + font);
        view.setTypeface(typeface);
    }
}
