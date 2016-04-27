package com.epicodus.guest.movieapp.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 4/27/16.
 */
@Parcel
public class Movie {
    public String mMovieName;
    public double mVoteAverage; //RATING
    public String mReleaseDate;


    public Movie() {

    }

    public Movie(String movieName, double voteAverage, String releaseDate) {
        this.mMovieName = movieName;
        this.mVoteAverage = voteAverage;
        this.mReleaseDate = releaseDate;
    }

    public String getMovieName() {
        return mMovieName;
    }

    public double getmVoteAverage() {
        return mVoteAverage;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }
}