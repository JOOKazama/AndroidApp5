package com.All.Operations;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.All.Main.MainActivity;
import com.All.R;
import com.All.Validators.Validators;

public class Login extends AppCompatActivity
{
    EditText email, password;
    TextView result_validation;
    Button button_login;
    Validators validator=new Validators();

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Login");

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        result_validation=findViewById(R.id.result_validation);
        button_login=findViewById(R.id.button_login);
    }

    public void Login_Try(View v) { new Thread(LoginTask).start(); }
    public void Return_Main(View v) { startActivity(new Intent(Login.this, MainActivity.class)); }
    Runnable LoginTask=new Runnable() { @Override public void run() { validator.ValidatorLogin(email, password, result_validation); } };
}