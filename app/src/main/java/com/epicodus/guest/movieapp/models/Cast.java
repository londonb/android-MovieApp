package com.epicodus.guest.movieapp.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 4/28/16.
 */
@Parcel
public class Cast {
    public String mDirector;
    public String mCast;

    public Cast() {

    }

    public Cast(String director, String cast) {
        this.mDirector = director;
        this.mCast = cast;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getCast() {
        return mCast;
    }
}


