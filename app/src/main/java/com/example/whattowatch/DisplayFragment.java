package com.example.whattowatch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayFragment extends Fragment {

    private static TextView movieTitle;
    private static TextView essentialDetails;
    private static ImageView moviePoster;
    private static TextView movieGenre;
    private static TextView moviePlot;
    private static TextView movieLanguage;
    private static TextView movieRatings;
    private ImageView displayBackground;

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static TextView getMovieTitle() {
        return movieTitle;
    }

    public static TextView getEssentialDetails() {
        return essentialDetails;
    }

    public static ImageView getMoviePoster() {
        return moviePoster;
    }

    public static TextView getMovieGenre() {
        return movieGenre;
    }

    public static TextView getMoviePlot() {
        return moviePlot;
    }

    public static TextView getMovieLanguage() {
        return movieLanguage;
    }

    public static TextView getMovieRatings() {
        return movieRatings;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        movieTitle = view.findViewById(R.id.MovieTitle);
        essentialDetails = view.findViewById(R.id.EssentialDetails);
        moviePoster = view.findViewById(R.id.MovieImage);
        movieGenre = view.findViewById(R.id.MovieGenre);
        moviePlot = view.findViewById(R.id.MoviePlot);
        movieLanguage = view.findViewById(R.id.MovieLanguage);
        movieRatings = view.findViewById(R.id.MovieRatings);

        return view;
    }

    public static void updateMovieDisplay(TextView movieTitle, TextView essentialDetails, ImageView moviePoster,
                                          TextView movieGenre, TextView moviePlot, TextView movieLanguage, TextView movieRatings, Movie movie) {

        movieTitle.setText(movie.getTitle());
        essentialDetails.setText("(" + movie.getYear() + ", " + movie.getRated() + ", " + movie.getType() + ")");
        Picasso.get().load(movie.getPosterUrl()).into(moviePoster);
        movieGenre.setText("(" + movie.getGenre() + ")");
        moviePlot.setText(movie.getPlot());
        movieLanguage.setText(movie.getLanguage());
        movieRatings.setText(movie.getRatings());

    }
}