package com.epicodus.guest.movieapp.services;

import android.util.Log;

import com.epicodus.guest.movieapp.Constants;
import com.epicodus.guest.movieapp.models.Movie;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 4/27/16.
 */
public class MovieService {
    public static final String TAG = MovieService.class.getSimpleName();

    public static void findMovie(String title, Callback callback) {
        String MOVIE_API_KEY = Constants.MOVIE_API_KEY;

        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.TITLE_QUERY_PARAMETER, title);
        urlBuilder.addQueryParameter(Constants.MOVIE_API_KEY_QUERY_PARAMETER, MOVIE_API_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Log.v(TAG, "url: " + request);
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject movieDataBaseJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = movieDataBaseJSON.getJSONArray("results");
                for(int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject moviesJSON = resultsJSON.getJSONObject(i);
                    String title = moviesJSON.getString ("original_title");
                    double voteAverage = moviesJSON.getDouble("vote_average");
                    String releaseDate = moviesJSON.getString("release_date");
                    Movie movie = new Movie(title, voteAverage, releaseDate);
                    movies.add(movie);
                }//FOR
            }//IF
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
