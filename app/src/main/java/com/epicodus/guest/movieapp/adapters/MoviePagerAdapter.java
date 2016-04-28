package com.epicodus.guest.movieapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.epicodus.guest.movieapp.models.Cast;
import com.epicodus.guest.movieapp.models.Movie;
import com.epicodus.guest.movieapp.ui.MovieDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 4/28/16.
 */
public class MoviePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Movie> mMovies;
//    private ArrayList<Cast> mCast;

    public MoviePagerAdapter(FragmentManager fm, ArrayList<Movie> movies) {
        super(fm);
        mMovies = movies;
        Log.d("mMoviesSize", mMovies + "");
//        mCast = cast;
    }

    @Override
    public Fragment getItem(int position) {
        return MovieDetailFragment.newInstance(mMovies.get(position));
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMovies.get(position).getMovieName();
    }

}
