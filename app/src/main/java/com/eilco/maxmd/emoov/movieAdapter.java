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



class movieAdapter extends RecyclerView.Adapter<movieViewholder> {


    private Context mContext;
    private List<Movie> m;


    public movieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        m = movies;
    }

    @Override
    public movieViewholder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_mainactivity_view, viewGroup, false);



        return new movieViewholder(view);
    }

    @Override
    public void onBindViewHolder(movieViewholder holder, int position) {

        final Movie movie = m.get(position);

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
        holder.movieTitle.setText(String.valueOf(movie.getTitle()));

        int maxSize = 180;
        String sizedMovieResume = String.valueOf(movie.getDescription());
        if(sizedMovieResume.length()>maxSize){
            sizedMovieResume = sizedMovieResume.substring(0,maxSize)+"...";
        }

        holder.movieResume.setText(sizedMovieResume);
        Picasso.with(mContext).load(movie.getPoster()).into(holder.movieImage);


    }

    @Override
    public int getItemCount() {
        return m.size();
    }
}