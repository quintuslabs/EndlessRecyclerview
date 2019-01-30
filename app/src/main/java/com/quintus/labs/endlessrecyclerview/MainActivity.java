package com.quintus.labs.endlessrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

/*
 * created on 30-jan-2019
 * www.quintuslabs.com
 */
public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private int previous = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressbar);
        prepareMovieData();

    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);
        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);
        setupRecyclerView();


    }

    private void setupRecyclerView() {
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        mAdapter.setOnBottomReachedListener(new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int position) {
                //your code goes here
                loadMoreData();
            }
        });
        recyclerView.smoothScrollToPosition(previous);

    }


    private void loadMoreData() {

        progressBar.setVisibility(View.VISIBLE);
        //to show progressbar for 5sec
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }

        }, 5000);

        List<Movie> movieList1 = new ArrayList<>();
        Movie movie = new Movie("sxtgghf : jhgjmjk", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList1.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList1.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList1.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList1.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList1.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList1.add(movie);


        movie = new Movie("Up", "Animation", "2009");
        movieList1.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList1.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList1.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList1.add(movie);


        previous = movieList.size();
        movieList.addAll(movieList1);


    }


}