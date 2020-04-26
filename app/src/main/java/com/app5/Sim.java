package com.app5;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class Sim extends AppCompatActivity
{
    Handler handler=new Handler();
    TextView textView, textView2, tv;
    ProgressBar progressBar;
    Button return2, button5;
    Random rand=new Random();
    String strlogin, strdl, strlogin1, strdl1;
    int logintime, dltime, max;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sim);
        return2=findViewById(R.id.return2);
        button5=findViewById(R.id.button5);
        progressBar=findViewById(R.id.progressBar);
        tv=findViewById(R.id.view2);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        progressBar.setVisibility(View.INVISIBLE);
        dltime=(rand.nextInt(2)+3);
        logintime=(rand.nextInt(3)+2);
    }

    public void Returnit(View view) { startActivity(new Intent(Sim.this, MainActivity.class)); }

    public void Checkit(View view)
    {
        DownloadTask dt=new DownloadTask();
        LoginTask lt=new LoginTask();
        new Thread(dt).start();
        new Thread(lt).start();

        return2.setEnabled(false);
        button5.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        max=(Math.max(dltime, logintime))*1000;
        handler.postDelayed(runnable, max);
    }

    Runnable runnable=new Runnable()
    {
        @SuppressLint("SetTextI18n") @Override public void run()
        {
            return2.setEnabled(true);
            button5.setEnabled(true);
            progressBar.setVisibility(View.INVISIBLE);
            if(strlogin1.equals("true") && strdl1.equals("true")) tv.setText("Both are successful!");
            else tv.setText("One of them or both are unsuccessful!");
        }
    };

    class DownloadTask implements Runnable
    {
        @Override public void run()
        {
            runOnUiThread(new Runnable()
            {
                @Override public void run()
                {
                    if(String.valueOf((Math.random()<0.5)).equals("true")) { strdl="Success! "+dltime+" sec."; strdl1="true"; }
                    else { strdl="Not Successful! "+dltime+" sec."; strdl1="false"; }
                    textView.setText(strdl);
                }
            });
        }
    }

    class LoginTask implements Runnable
    {
        @Override public void run()
        {
            runOnUiThread(new Runnable()
            {
                @Override public void run()
                {
                    if(String.valueOf((Math.random()<0.5)).equals("true")) { strlogin="Success! "+logintime+" sec."; strlogin1="true"; }
                    else { strlogin="Not Successful! "+logintime+" sec."; strlogin1="false"; }
                    textView2.setText(strlogin);
                }
            });
        }
    }
}