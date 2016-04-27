package com.epicodus.guest.movieapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.guest.movieapp.R;
import com.epicodus.guest.movieapp.models.Movie;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/27/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }


    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);

        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

        public class MovieViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.movieNameTextView)
            TextView mMovieNameTextView;
            @Bind(R.id.ratingTextView)
            TextView mRatingTextView;
            @Bind(R.id.releaseTextView)
            TextView mReleaseTextView;
            private Context mContext;

            public MovieViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mContext = itemView.getContext();
            }

            public void bindMovie(Movie movie) {
                mMovieNameTextView.setText(movie.getMovieName());
                mReleaseTextView.setText(movie.getmReleaseDate());
                mRatingTextView.setText("Rating: " + movie.getmVoteAverage() + "/10");
            }
        }

    }
