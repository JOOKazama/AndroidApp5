package com.All.Main;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.All.Operations.Login;
import com.All.Operations.Sim;
import com.All.Operations.Time;
import com.All.R;

public class MainActivity extends AppCompatActivity
{
    Button first_assignment, second_assignment, third_assignment;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Page");

        first_assignment=findViewById(R.id.first_assignment);
        second_assignment=findViewById(R.id.second_assignment);
        third_assignment=findViewById(R.id.third_assignment);

        first_assignment.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Login.class)); } });

        second_assignment.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Time.class)); } });

        third_assignment.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Sim.class)); } });
    }
}