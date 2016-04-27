package com.epicodus.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.guest.movieapp.R;
import com.epicodus.guest.movieapp.models.Movie;
import com.epicodus.guest.movieapp.services.MovieService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MoviesActivity extends AppCompatActivity {
    public ArrayList<Movie> mMovies = new ArrayList<>();
    public static final String TAG = MoviesActivity.class.getSimpleName();
    @Bind(R.id.movieListView) ListView mMovieListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        getMovies(title);
    }

    private void getMovies(String title) {
        final MovieService movieService = new MovieService();

        MovieService.findMovie(title, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mMovies = movieService.processResults(response);

                MoviesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] movieTitles = new String[mMovies.size()];
                        for (int i = 0; i < movieTitles.length; i++) {
                            movieTitles[i] = mMovies.get(i).getMovieName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(MoviesActivity.this, android.R.layout.simple_list_item_1, movieTitles);
                        mMovieListView.setAdapter(adapter);

                        for (Movie movie : mMovies) {
                            Log.d(TAG, "Name: " + movie.getMovieName());
                            Log.d(TAG, "Rating: " + movie.getmVoteAverage());
                            Log.d(TAG, "Release Date: " + movie.getmReleaseDate());
                        }
                    }
                });
            }
        });
    }
}
