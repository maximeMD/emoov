package com.eilco.maxmd.emoov;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eilco.maxmd.emoov.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by max on 28/11/2017.
 */

public class movieAdapterBig extends RecyclerView.Adapter<movieViewHolderBig> {
    private Context mContext;
    private List<Movie> movies;


    public movieAdapterBig(Context context, List<Movie> mov) {
        mContext = context;
        movies = mov;

    }

    @Override
    public movieViewHolderBig onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_mainactivity_big_view, viewGroup, false);
        return new movieViewHolderBig(view);
    }

    @Override
    public void onBindViewHolder(movieViewHolderBig holder, int position) {

        final Movie movie = movies.get(position);

        View view = holder.itemView;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SingleMovieActivity.class);
                Bundle extras = new Bundle();
                extras.putString(SingleMovieActivity.EXTRA_MOVIE_TITLE,movie.getTitle());
                extras.putString(SingleMovieActivity.EXTRA_MOVIE_RESUME,movie.getDescription());
                extras.putString(SingleMovieActivity.EXTRA_MOVIE_IMAGE,movie.getPoster());
                intent.putExtras(extras);
                view.getContext().startActivity(intent);
            }
        });
        Picasso.with(mContext).load(movie.getPoster()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
