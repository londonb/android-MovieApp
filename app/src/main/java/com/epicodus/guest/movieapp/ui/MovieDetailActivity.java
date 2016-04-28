package com.epicodus.guest.movieapp.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.epicodus.guest.movieapp.R;
import com.epicodus.guest.movieapp.adapters.MovieListAdapter;
import com.epicodus.guest.movieapp.adapters.MoviePagerAdapter;
import com.epicodus.guest.movieapp.models.Cast;
import com.epicodus.guest.movieapp.models.Movie;
import com.epicodus.guest.movieapp.services.MovieService;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private MoviePagerAdapter adapterViewPager;
    Movie movie;
    ArrayList<Movie> mMovies = new ArrayList<>();
    ArrayList<Cast> mCast = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Log.d("it", "works");
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mMovies = Parcels.unwrap(intent.getParcelableExtra("movies"));
//        mCast = Parcels.unwrap(intent.getParcelableExtra("cast"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        movie = mMovies.get(startingPosition);
//        final MovieService movieService = new MovieService();
//        movieService.findCredits(movie.getId(), new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                mCast = movieService.processCastResults(response);
//
//                MovieDetailActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
//            }
//        });
        adapterViewPager = new MoviePagerAdapter(getSupportFragmentManager(), mMovies);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
