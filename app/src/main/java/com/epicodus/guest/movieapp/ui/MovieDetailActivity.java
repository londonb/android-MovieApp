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


import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MovieDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private MoviePagerAdapter adapterViewPager;
    ArrayList<Movie> mMovies = new ArrayList<>();
//    ArrayList<Cast> mCast = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        mMovies = Parcels.unwrap(getIntent().getParcelableExtra("movies"));
//        mCast = Parcels.unwrap(intent.getParcelableExtra("cast"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new MoviePagerAdapter(getSupportFragmentManager(), mMovies);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
