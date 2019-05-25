package ru.geekbrains.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements WeatherString {

    private Button toSecondActivity;
    private TextView weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnClickButNextActivity();
        Toast.makeText(getApplicationContext(), "MainActivity onCreate()", Toast.LENGTH_SHORT).show();
        Log.i("LifeCycle","MainActivity onCreate()");
        setWeather();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "MainActivity onStart()", Toast.LENGTH_SHORT).show();
        Log.i("LifeCycle","MainActivity onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "MainActivity onRestart()", Toast.LENGTH_SHORT).show();
        Log.i("LifeCycle","MainActivity onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "MainActivity onPause()", Toast.LENGTH_SHORT).show();
        Log.i("LifeCycle","MainActivity onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "MainActivity onCreate()", Toast.LENGTH_SHORT).show();
        Log.i("LifeCycle","MainActivity onCreate()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "MainActivity onStop()", Toast.LENGTH_SHORT).show();
        Log.i("LifeCycle","MainActivity onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "MainActivity onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i("LifeCycle","MainActivity onDestroy()");
    }

    private void setOnClickButNextActivity() {
        toSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        weather = findViewById(R.id.weather);
        toSecondActivity = findViewById(R.id.butNextActivity);
    }

    private void setWeather() {
        Weather builder = new Weather(this);
        String text = builder.getText();
        weather.setText(text);
    }

    @Override
    public String getvVsibilityString() {
        return getString(R.string.wclear);
    }

    @Override
    public String getCityString() {
        return getString(R.string.city);
    }

    @Override
    public String getTemperatureString() {
        return getString(R.string.temperature);
    }
}