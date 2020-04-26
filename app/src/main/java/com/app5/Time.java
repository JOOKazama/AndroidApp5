package com.app5;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Time extends AppCompatActivity
{
    Button button2, button4;
    TextView textView4;
    Thread thread=new Thread();
    Boolean pause=false;
    Handler handler=new Handler(Looper.getMainLooper());

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);

        button2=findViewById(R.id.button2);
        button4=findViewById(R.id.button4);
        textView4=findViewById(R.id.textView4);
        thread=new Thread(runnable);
        thread.start();
    }

    public void Pause(View view)
    {
        pause=true;
        try { Thread.sleep(5000); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void Returnit(View view) { startActivity(new Intent(Time.this, MainActivity.class)); }

    Runnable runnable=new Runnable()
    {
        @SuppressLint("SetTextI18n") @Override public void run()
        {
                for(int i=0; i<100000; i++)
                {
                    final int finalI = i;
                    handler.post(new Runnable() { @Override public void run() { textView4.setText(finalI +" sec."); } });
                    if(pause)
                    {
                         i=i-5;
                         pause=false;
                    }
                    else
                    {
                        try { Thread.sleep(1000); }
                        catch (InterruptedException e) { e.printStackTrace(); }
                    }
                }
            }

    };
}