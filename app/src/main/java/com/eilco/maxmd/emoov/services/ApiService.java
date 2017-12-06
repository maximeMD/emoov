package com.eilco.maxmd.emoov.services;


import com.eilco.maxmd.emoov.models.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<Movie.MovieResult> getPopularMovies(@Query("api_key") String apiKey, @Query("language") String language);


}
