package com.example.steven.aprendiendo.ViewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.steven.aprendiendo.BR;
import com.example.steven.aprendiendo.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewModelLogin extends BaseObservable {
    public String password;
    public String email;

    private String userPass;
    private String userEmal;

    public String forgetPassText;
    public String loginButtonText;

    private String errorPass;
    private String errorEmail;

    public ViewModelLogin(String password, String email, String forgetPassText, String loginButtonText) {
        this.password = password;
        this.email = email;
        this.forgetPassText = forgetPassText;
        this.loginButtonText = loginButtonText;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
        notifyPropertyChanged(R.id.PasswordEditText);
        notifyPropertyChanged(BR.errorPassword);
    }

    public String getUserEmal() {
        return userEmal;
    }

    public void setUserEmal(String userEmal) {
        this.userEmal = userEmal;
        notifyPropertyChanged(R.id.EmailEditText);
        notifyPropertyChanged(BR.errorEmails);
    }

    public String getForgetPassText() {
        return forgetPassText;
    }

    public void setForgetPassText(String forgetPassText) {
        this.forgetPassText = forgetPassText;
    }

    public String getLoginButtonText() {
        return loginButtonText;
    }

    public void setLoginButtonText(String loginButtonText) {
        this.loginButtonText = loginButtonText;
    }

    public String getErrorPass() {
        return errorPass;
    }

    public void setErrorPass(String errorPass) {
        this.errorPass = errorPass;
    }

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }

    public static boolean isValidatePassword(final String password){
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%&]).{6,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    @Bindable
    public String getErrorPassword(){
        if(userPass==null)
            return password;
        else if (userPass.length()<6)
            return "Too short!!";
        else if (!isValidatePassword(userPass))
            return "Contraseña invalida";
        else
            return null;
    }

    public static boolean isValidateEmail(final String email){
        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\" + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    @Bindable
    public String getErrorEmails(){
        if(userPass==null)
            return email;
        else if (userPass.length()<6)
            return "Too short!!";
        else if (!isValidateEmail(userEmal))
            return "correo invalido";
        else
            return null;
    }

}