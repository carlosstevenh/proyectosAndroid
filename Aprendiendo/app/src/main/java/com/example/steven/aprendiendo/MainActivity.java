package com.example.steven.aprendiendo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.steven.aprendiendo.ClickEvents.ClickListener;
import com.example.steven.aprendiendo.Model.User;
import com.example.steven.aprendiendo.ViewModel.ViewModelLogin;
import com.example.steven.aprendiendo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding bindig = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewModelLogin login = new ViewModelLogin("Enter Password","Enter email","forgot password","Login");
        bindig.setLogin(login);
        bindig.setModelClickListener(new ClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this,bindig.getLogin().getErrorEmails(),Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,bindig.getLogin().getErrorPassword(),Toast.LENGTH_LONG).show();
            }
        });
        //bindig.setText("Hola mundo");

        //final Act
    }
}
