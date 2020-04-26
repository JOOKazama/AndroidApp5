package com.app5;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    Button first, second, third;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);

        first.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Login.class)); } });

        second.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Time.class)); } });

        third.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Sim.class)); } });
    }
}