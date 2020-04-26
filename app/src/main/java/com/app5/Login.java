package com.app5;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity
{
    EditText editText, editText2;
    TextView textView3;
    Button button;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        textView3=findViewById(R.id.textView3);
        button=findViewById(R.id.button);
    }

    public void Login1(View v) { new Thread(LoginTask).start(); }

    public void Returnit(View v) { startActivity(new Intent(Login.this, MainActivity.class)); }

    Runnable LoginTask=new Runnable()
    {
        @SuppressLint("SetTextI18n") @Override public void run()
        {
            String str;
            String str1="!@#$%&*";

            if(editText2.getText().toString().length()==0 || editText.getText().toString().length()==0)
            runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("It should not be empty!"); } });

            if(editText2.getText().toString().length()>16 || editText.getText().toString().length()>40)
            runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("The length is bigger than 16 characters!"); } });

            if(editText2.getText().toString().length()>=13)
            {
                str=editText2.getText().toString();
                if(!Character.isUpperCase(str.charAt(6)) || !Character.isUpperCase(str.charAt(13)))
                runOnUiThread(new Runnable() { @Override  public void run() { textView3.setText("The required characters are not uppercase's!"); } });
            }

            if(editText2.getText().toString().length()>5 && editText2.getText().toString().length()<13)
            {
                str=editText2.getText().toString();
                if(!Character.isUpperCase(str.charAt(6)))
                runOnUiThread(new Runnable() { @Override  public void run() { textView3.setText("The required characters are not uppercase's!"); } });
            }

            if(editText2.getText().toString().length()>1 && editText2.getText().toString().length()<5)
            {
                str=editText2.getText().toString();
                if(!Character.isDigit(str.charAt(2)))
                runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("The required characters are not digits!"); } });
            }

            if(editText2.getText().toString().length()>1 && editText2.getText().toString().length()<8)
            {
                str=editText2.getText().toString();
                if(!Character.isDigit(str.charAt(2)) || !Character.isDigit(str.charAt(5)))
                runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("The required characters are not digits!"); } });
            }

            if(editText2.getText().toString().length()>1 && editText2.getText().toString().length()<11)
            {
                str=editText2.getText().toString();
                if(!Character.isDigit(str.charAt(2)) || !Character.isDigit(str.charAt(5)) || !Character.isDigit(str.charAt(8)))
                runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("The required characters are not digits!"); } });
            }

            if(editText2.getText().toString().length()>1 && editText2.getText().toString().length()>=11)
            {
                str=editText2.getText().toString();
                if(!Character.isDigit(str.charAt(2)) || !Character.isDigit(str.charAt(5)) || !Character.isDigit(str.charAt(8)) || !Character.isDigit(str.charAt(11)))
                runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("The required characters are not digits!"); } });
            }

            if(editText2.getText().toString().length()>6 && editText2.getText().toString().length()<15)
            {
                str=editText2.getText().toString();
                for (int i=0; i<str1.length(); i++)
                {
                    if (str.charAt(7) != str1.charAt(i))
                    runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("The required characters are not special symbols!"); } });
                }
            }

            if(editText2.getText().toString().length()>6 && editText2.getText().toString().length()>=15)
            {
                str=editText2.getText().toString();
                for (int i=0; i<str1.length(); i++)
                {
                    if (str.charAt(7) != str1.charAt(i) || str.charAt(15) != str1.charAt(i))
                    runOnUiThread(new Runnable() { @Override public void run() { textView3.setText("The required characters are not special symbols!"); } });
                }
            }
        }
    };
}