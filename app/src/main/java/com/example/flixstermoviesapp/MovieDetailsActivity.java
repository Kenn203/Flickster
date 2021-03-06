package com.example.flixstermoviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixstermoviesapp.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {
    Movie movie;

    TextView tvTitle;
    TextView tvOverview;
    ImageView imageView2;
    RatingBar rbVoteAverage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        Glide.with(this).load(movie.getPosterPath()).into(imageView2);


        float voteAverage = movie.voteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage / 2.0f);
    }
}