package com.example.whattowatch;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SearchFragment extends Fragment {

    private Button displayMovieButton;
    private EditText movieInput;

    private SearchFragmentListener listener;

    private String movieName;

    public SearchFragment() {
        // Required empty public constructor
    }

    public interface SearchFragmentListener{
        TextView getMovieTitle();
        TextView getEssentialDetails();
        ImageView getMoviePoster();
        TextView getMovieGenre();
        TextView getMoviePlot();
        TextView getMovieLanguage();
        TextView getMovieRatings();
        void getUpdateMovieDisplay(TextView movieTitle, TextView essentialDetails, ImageView moviePoster,
                                   TextView movieGenre, TextView moviePlot, TextView movieLanguage, TextView movieRatings, Movie movie);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        MovieApiService movieApiService = new MovieApiService(view.getContext());

        movieInput = view.findViewById(R.id.MovieInput);
        displayMovieButton = (Button) view.findViewById(R.id.DisplayMovieButton);

        displayMovieButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                movieName = movieInput.getText().toString();

                movieApiService.getMovie(new MovieApiService.VolleyResponseListener() {
                    @Override
                    public void onResponse(Movie movie) {

                        listener.getUpdateMovieDisplay(listener.getMovieTitle(), listener.getEssentialDetails(), listener.getMoviePoster(), listener.getMovieGenre(),
                                listener.getMoviePlot(), listener.getMovieLanguage(), listener.getMovieRatings(), movie);

                    }
                }, movieName);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof SearchFragmentListener){
            listener = (SearchFragmentListener) context;
        } else {
            throw new RuntimeException(context + " must implement SearchFragmentListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }
}