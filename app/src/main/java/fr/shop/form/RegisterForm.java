package fr.shop.form;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
    private Map<EditText, String> errors = new HashMap<EditText, String>();
    private static final String NAME_REGEX = "^[a-zA-Z]+$";
    public void validName(EditText editText, TextView errorText){
        String name = getText(editText);
        if(name != null){
            if(name.length() < 3){
                errors.put(editText, "Ce champ doit contenir au moins trois caractères");
            }else if(!name.matches(NAME_REGEX)){
                errors.put(editText, "Veuillez entrez un nom correct");
            }
        }else{
            errors.put(editText, "Veuillez renseignez votre nom");
        }
        showError(editText, errorText);
    }

    public void validSurname(EditText editText, TextView errorText){
        String name = getText(editText);
        if(name != null){
            if(name.length() < 3) {
                errors.put(editText, "Ce champ doit contenir au moins trois caractères");
            }else if(!name.matches(NAME_REGEX)){
                errors.put(editText, "Veuillez entrez un nom correct");
            }
        }
        showError(editText, errorText);
    }
    private static final String EMAIL_REGEX = "^[a-z0-9._-]+@[a-z0-9._-]+\\.[a-z]{2,6}$";
    public void validEmail(EditText editText, TextView errorText){
        String email = getText(editText);
        if(email != null && email.trim().length() != 0){
            if(!email.matches(EMAIL_REGEX)){
                errors.put(editText, "Veuillez renseignez une adresse électronique valide");
            }
        }else{
            errors.put(editText, "Veuillez renseignez votre adresse électronique");
        }
        showError(editText, errorText);
    }

    public void validPasswordOne(EditText editText, TextView errorText){
        String password = getText(editText);
        if(password != null){
            if(password.length() < 8){
                errors.put(editText, "Ce champ doit contenir au moins huit caractères");
            }

        }else{
            errors.put(editText, "Veuillez renseignez votre mot de passe");
        }
        showError(editText, errorText);
    }

    public void validPasswordConf(EditText editText1, EditText editTextConf, TextView errorText){
        String password = getText(editText1);
        String passwordConf = getText(editTextConf);
        if(passwordConf == null) {
            errors.put(editTextConf, "Veuillez confirmez votre mot de passe");
        }else {
            if((password != null) && !password.equals(passwordConf)){
                errors.put(editTextConf, "Le mots de passe ne correspondent pas");
            }
        }

        showError(editTextConf, errorText);
    }
    public String getText(EditText editText){
        String text = editText.getText().toString();
        if(text.trim().length() > 0){
            return text.trim();
        }
        return null;
    }
    public boolean isValid(){
        return  errors.size() == 0;
    }

    public void showError(final EditText editText, final TextView errorText){

        if(errors.containsKey(editText)){
            String error = errors.get(editText);
            if(error.trim().length() > 0){
                errorText.setText(error + ": " + editText.getText().toString());
                errorText.setVisibility(View.VISIBLE);
            }else{
                errorText.setVisibility(View.INVISIBLE);
            }
        }else{
            errorText.setVisibility(View.INVISIBLE);
        }
    }
}
