package com.epicodus.guest.movieapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.guest.movieapp.R;
import com.epicodus.guest.movieapp.models.Cast;
import com.epicodus.guest.movieapp.models.Movie;
import com.epicodus.guest.movieapp.ui.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/27/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> mMovies = new ArrayList<>();
//    private ArrayList<Cast> mCast = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
//        mCast = cast;
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
//        holder.bindCast(mCast.get(position));
    }

    @Override
    public int getItemCount() {
        Log.v("This", "is working");
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.movieNameTextView) TextView mMovieNameTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;
        @Bind(R.id.releaseTextView) TextView mReleaseTextView;
        @Bind(R.id.posterImageView) ImageView mPosterImageView;
//        @Bind(R.id.castTextView) TextView mCastTextView;
//        @Bind(R.id.directorTextView) TextView mDirectorTextView;
        private Context mContext;
        private static final int MAX_WIDTH = 400;
        private static final int MAX_HEIGHT = 300;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, MovieDetailActivity.class);
                    intent.putExtra("position", itemPosition + "");
                    intent.putExtra("movies", Parcels.wrap(mMovies));
//                    intent.putExtra("cast", Parcels.wrap(mCast));
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindMovie(Movie movie) {
            Log.v("poster", movie.getPosterPath());

            Picasso.with(mContext).load(movie.getPosterPath())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mPosterImageView);
            mMovieNameTextView.setText(movie.getMovieName());
            mReleaseTextView.setText(movie.getmReleaseDate());
            mRatingTextView.setText("Rating: " + movie.getVoteAverage() + "/10");
        }

//        public void bindCast(Cast cast) {
//            mCastTextView.setText(cast.getCast());
//            mDirectorTextView.setText(cast.getDirector());
//        }
    }
}


