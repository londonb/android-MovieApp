package com.epicodus.guest.movieapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.guest.movieapp.R;
import com.epicodus.guest.movieapp.models.Cast;
import com.epicodus.guest.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    @Bind(R.id.posterImageView) ImageView mPosterImageView;
    @Bind(R.id.movieNameTextView) TextView mMovieNameTextView;
    @Bind(R.id.ratingTextView) TextView mRatingTextView;
    @Bind(R.id.releaseDateTextView) TextView mReleaseDateTextView;
//    @Bind(R.id.directorTextView) TextView mDirectorTextView;
//    @Bind(R.id.castTextView) TextView mCastTextView;
    @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;
//    @Bind(R.id.viewWebsiteButton) Button mViewWebsiteButton;

    private Movie mMovie;
//    private Cast mCast;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
//        args.putParcelable("cast", Parcels.wrap(cast));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
//        mCast = Parcels.unwrap(getArguments().getParcelable("cast"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mMovie.getPosterPath()).into(mPosterImageView);
        mMovieNameTextView.setText(mMovie.getMovieName());
        mRatingTextView.setText(Double.toString(mMovie.getVoteAverage()) + "/10");
        mReleaseDateTextView.setText(mMovie.getmReleaseDate());
        mDescriptionTextView.setText(mMovie.getOverview());
//        mDirectorTextView.setText(mCast.getDirector());
//        mCastTextView.setText(mCast.getCast());
        return view;
    }

}
