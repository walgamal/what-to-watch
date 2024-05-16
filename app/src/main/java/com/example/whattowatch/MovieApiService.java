package com.example.whattowatch;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieApiService {

    private Context context;
    private String movieApiURL = "http://www.omdbapi.com/?i=tt3896198&apikey=9537f2b9&t=";
    private Movie movie = new Movie();

    public MovieApiService(Context context){
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onResponse(Movie movie);
    }

    public void getMovie(VolleyResponseListener volleyResponseListener, String title) {

        String url = movieApiURL + title + "/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject responseObj) {

                        try {

                            if(responseObj.getBoolean("Response") == true){

                                if(responseObj.has("Title"))
                                    movie.setTitle(responseObj.getString("Title"));

                                if(responseObj.has("Year"))
                                    movie.setYear(responseObj.getString("Year"));

                                if(responseObj.has("Rated"))
                                    movie.setRated(responseObj.getString("Rated"));

                                if(responseObj.has("Genre"))
                                    movie.setGenre(responseObj.getString("Genre"));

                                if(responseObj.has("Plot"))
                                    movie.setPlot(responseObj.getString("Plot"));

                                if(responseObj.has("Language"))
                                    movie.setLanguage(responseObj.getString("Language"));

                                if(responseObj.has("imdbRating"))
                                    movie.setRatings(responseObj.getString("imdbRating"));

                                if(responseObj.has("Type"))
                                    movie.setType(responseObj.getString("Type"));

                                if(responseObj.has("Poster"))
                                    movie.setPosterUrl(responseObj.getString("Poster"));

                                volleyResponseListener.onResponse(movie);
                            } else {
                                movie.setResponse(false);
                            }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
    }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = null;
                if (error instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else
                    if (error instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (error instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (error instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
