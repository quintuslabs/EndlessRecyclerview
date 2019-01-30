package com.quintus.labs.endlessrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/*
 * created on 30-jan-2019
 * www.quintuslabs.com
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    OnBottomReachedListener onBottomReachedListener;
    int lastPosition = -1;
    Context context;
    private List<Movie> moviesList;

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    //adding onbottom reached
    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener) {

        this.onBottomReachedListener = onBottomReachedListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //set position
        if (position == moviesList.size() - 1) {
            onBottomReachedListener.onBottomReached(position);
        }


        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            genre = view.findViewById(R.id.genre);
            year = view.findViewById(R.id.year);
        }
    }
}