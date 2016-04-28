package com.epicodus.guest.movieapp;

import com.epicodus.guest.movieapp.models.Movie;

/**
 * Created by Guest on 4/27/16.
 */
public class Constants {
    public static final String MOVIE_API_KEY = BuildConfig.MOVIE_API_KEY;

    public static final String MOVIE_BASE_URL = "http://api.themoviedb.org/3/search/movie"; //MIGHT NEED "?" AND "="
    public static final String TITLE_QUERY_PARAMETER = "query";
    public static final String MOVIE_API_KEY_QUERY_PARAMETER = "api_key";

    public static final String CREDITS_BASE_URL= "http://api.themoviedb.org/3/movie/";

}
