package com.epicodus.guest.movieapp.ui;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.guest.movieapp.R;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.titleEditText) EditText mTitleEditText;
    @Bind(R.id.submitButton) Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitButton) {
            String title = mTitleEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
            intent.putExtra("title", title);
            startActivity(intent);
        }
    }
}
