package com.All.Validators;
import android.annotation.SuppressLint;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("SetTextI18n")
public class Validators extends AppCompatActivity
{

   public void ValidatorLogin(EditText email, EditText password, final TextView result_validation)
   {
       String string_password;
       String symbol_validators="!@#$%&*";

       if(password.getText().toString().length()==0 || email.getText().toString().length()==0)
       runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("It should not be empty!"); } });

       else if(password.getText().toString().length()>16 || email.getText().toString().length()>40)
       runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("The length is bigger than 16 characters!"); } });

       else if(password.getText().toString().length()>=13)
       {
           string_password=password.getText().toString();
           if(!Character.isUpperCase(string_password.charAt(6)) || !Character.isUpperCase(string_password.charAt(13)))
           runOnUiThread(new Runnable() { @Override  public void run() { result_validation.setText("The required characters are not uppercase's!"); } });
       }

       else if(password.getText().toString().length()>5 && password.getText().toString().length()<13)
       {
           string_password=password.getText().toString();
           if(!Character.isUpperCase(string_password.charAt(6)))
           runOnUiThread(new Runnable() { @Override  public void run() { result_validation.setText("The required characters are not uppercase's!"); } });
       }

       else if(password.getText().toString().length()>1 && password.getText().toString().length()<5)
       {
           string_password=password.getText().toString();
           if(!Character.isDigit(string_password.charAt(2)))
           runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("The required characters are not digits!"); } });
       }

       else if(password.getText().toString().length()>1 && password.getText().toString().length()<8)
       {
           string_password=password.getText().toString();
           if(!Character.isDigit(string_password.charAt(2)) || !Character.isDigit(string_password.charAt(5)))
           runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("The required characters are not digits!"); } });
       }

       else if(password.getText().toString().length()>1 && password.getText().toString().length()<11)
       {
           string_password=password.getText().toString();
           if(!Character.isDigit(string_password.charAt(2)) || !Character.isDigit(string_password.charAt(5)) || !Character.isDigit(string_password.charAt(8)))
           runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("The required characters are not digits!"); } });
       }

       else if(password.getText().toString().length()>1 && password.getText().toString().length()>=11)
       {
           string_password=password.getText().toString();
           if(!Character.isDigit(string_password.charAt(2)) || !Character.isDigit(string_password.charAt(5)) || !Character.isDigit(string_password.charAt(8)) || !Character.isDigit(string_password.charAt(11)))
           runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("The required characters are not digits!"); } });
       }

       else if(password.getText().toString().length()>6 && password.getText().toString().length()<15)
       {
           string_password=password.getText().toString();
           for(int i=0; i<symbol_validators.length(); i++)
           {
               if(string_password.charAt(7)!=symbol_validators.charAt(i))
               runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("The required characters are not special symbols!"); } });
           }
       }

       else if(password.getText().toString().length()>6 && password.getText().toString().length()>=15)
       {
           string_password=password.getText().toString();
           for(int i=0; i<symbol_validators.length(); i++)
           {
               if(string_password.charAt(7)!=symbol_validators.charAt(i) || string_password.charAt(15)!=symbol_validators.charAt(i))
               runOnUiThread(new Runnable() { @Override public void run() { result_validation.setText("The required characters are not special symbols!"); } });
           }
       }
   }
}