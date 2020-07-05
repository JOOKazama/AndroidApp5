package com.All.Operations;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.All.Main.MainActivity;
import com.All.R;

import java.util.Random;

public class Sim extends AppCompatActivity
{
    Handler handler=new Handler();
    TextView first_task, second_task, result;
    ProgressBar progress_bar;
    Button button_check, button_return;
    Random rand=new Random();
    String string_login, string_download, string_login1, string_download1;
    int login_time, download_time, max_time;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sim);
        setTitle("Simulation");

        button_check=findViewById(R.id.button_check);
        button_return=findViewById(R.id.button_return);
        progress_bar=findViewById(R.id.progress_bar);
        result=findViewById(R.id.result);
        first_task=findViewById(R.id.first_task);
        second_task=findViewById(R.id.second_task);
        progress_bar.setVisibility(View.INVISIBLE);
        download_time=(rand.nextInt(2)+3);
        login_time=(rand.nextInt(3)+2);
    }

    public void Return_Main(View view) { startActivity(new Intent(Sim.this, MainActivity.class)); }

    public void Check(View view)
    {
        DownloadTask download_task=new DownloadTask();
        LoginTask login_task=new LoginTask();
        new Thread(download_task).start();
        new Thread(login_task).start();

        button_check.setEnabled(false);
        button_return.setEnabled(false);
        progress_bar.setVisibility(View.VISIBLE);
        max_time=(Math.max(download_time, login_time))*1000;
        handler.postDelayed(runnable, max_time);
    }

    Runnable runnable=new Runnable()
    {
        @SuppressLint("SetTextI18n") @Override public void run()
        {
            button_check.setEnabled(true);
            button_return.setEnabled(true);
            progress_bar.setVisibility(View.INVISIBLE);
            if(string_login1.equals("true") && string_download1.equals("true")) result.setText("Both are successful!");
            else result.setText("One of them or both are unsuccessful!");
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
                    if(String.valueOf((Math.random()<0.5)).equals("true")) { string_download="Success! "+download_time+" sec."; string_download1="true"; }
                    else { string_download="Not Successful! "+download_time+" sec."; string_download1="false"; }
                    first_task.setText(string_download);
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
                    if(String.valueOf((Math.random()<0.5)).equals("true")) { string_login="Success! "+download_time+" sec."; string_login1="true"; }
                    else { string_login="Not Successful! "+login_time+" sec."; string_login1="false"; }
                    second_task.setText(string_login);
                }
            });
        }
    }
}