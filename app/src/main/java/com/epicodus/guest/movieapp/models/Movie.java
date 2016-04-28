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
    public String mPosterPath;
//    public String mId;


    public Movie() {}

    public Movie(String movieName, double voteAverage, String releaseDate, String posterPath) {
        this.mMovieName = movieName;
        this.mVoteAverage = voteAverage;
        this.mReleaseDate = releaseDate;
        this.mPosterPath = "http://image.tmdb.org/t/p/w500" + posterPath;
//        this.mId = id;
    }

    public String getMovieName() {
        return mMovieName;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

//    public String getId() {
//        return mId;
//    }
}

