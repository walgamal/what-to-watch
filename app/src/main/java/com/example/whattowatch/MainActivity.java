package com.example.whattowatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SearchFragment.SearchFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getUpdateMovieDisplay(TextView movieTitle, TextView essentialDetails, ImageView moviePoster,
                                      TextView movieGenre, TextView moviePlot, TextView movieLanguage, TextView movieRatings, Movie movie){

        DisplayFragment.updateMovieDisplay(movieTitle, essentialDetails, moviePoster, movieGenre, moviePlot, movieLanguage, movieRatings, movie);

    }

    public TextView getMovieTitle(){
        return DisplayFragment.getMovieTitle();
    }

    public TextView getEssentialDetails(){
        return DisplayFragment.getEssentialDetails();
    }

    public ImageView getMoviePoster(){
        return DisplayFragment.getMoviePoster();
    }

    public TextView getMovieGenre(){
        return DisplayFragment.getMovieGenre();
    }

    public TextView getMoviePlot(){
        return DisplayFragment.getMoviePlot();
    }

    public TextView getMovieLanguage(){
        return DisplayFragment.getMovieLanguage();
    }

    public TextView getMovieRatings(){
        return DisplayFragment.getMovieRatings();
    }
}