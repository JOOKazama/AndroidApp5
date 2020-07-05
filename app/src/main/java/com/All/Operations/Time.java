package com.All.Operations;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.All.Main.MainActivity;
import com.All.R;

public class Time extends AppCompatActivity
{
    Button button_pause, button_return;
    TextView display_seconds;
    static Thread thread=new Thread();
    Boolean pause=false;
    Handler handler=new Handler(Looper.getMainLooper());

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);
        setTitle("Timer");

        button_pause=findViewById(R.id.button_pause);
        button_return=findViewById(R.id.button_return);
        display_seconds=findViewById(R.id.display_seconds);
        thread=new Thread(runnable);
        thread.start();

        button_pause.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                if(!pause)
                {
                    pause=true;
                    button_pause.setText("Start!");
                }
                else
                {
                    pause=false;
                    button_pause.setText("Pause!");
                }
            }
        });
    }

    public void Return_Main(View view) { startActivity(new Intent(Time.this, MainActivity.class)); }

    Runnable runnable=new Runnable()
    {
        @SuppressLint("SetTextI18n")
        @Override public void run()
        {
            for(int i=0; i<10000000; i++)
            {
                if(button_pause.getText().equals("Pause!"))
                {
                    final int final_integer=i;
                    handler.post(new Runnable() { @Override public void run() { display_seconds.setText(final_integer+" seconds passed!"); } });
                    try{ Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                else{ i=Integer.parseInt(display_seconds.getText().toString().split("[ a-z]")[0]); }
            }
        }
    };
}