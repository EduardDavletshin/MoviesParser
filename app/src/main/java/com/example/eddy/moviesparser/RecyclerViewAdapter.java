package com.example.eddy.moviesparser;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eddy.moviesparser.Models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by eddy on 1/4/2017.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Movie> movies;

    RecyclerViewAdapter(ArrayList<Movie> list) {
        movies = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Resources res = holder.movie.getResources();
        Movie dataPosition = movies.get(position);
        holder.movie.setText(dataPosition.getMovie());
        holder.year.setText(String.format("%s%s", res.getString(R.string.year), String
                .valueOf(dataPosition.getYear())));
        holder.rating.setText(String.format("%s%s", res.getString(R.string.rating), String
                .valueOf(dataPosition.getRating())));
        holder.duration.setText(String.format("%s%s", res.getString(R.string.duration), dataPosition
                .getDuration()));
        holder.director.setText(String.format("%s%s", res.getString(R.string.director), dataPosition
                .getDirector()));
        holder.tagline.setText("\"" + dataPosition.getTagline() + "\"");
        StringBuilder builder = new StringBuilder();
        builder.append(res.getString(R.string.cast));
        for (int i = 0; i < dataPosition.getCast().size(); i++) {
            if (i != dataPosition.getCast().size() - 1) {
                builder.append(dataPosition.getCast().get(i).getName()).append(", ");
            } else builder.append((dataPosition.getCast().get(i).getName()));
        }
        holder.cast.setText(builder);
        Picasso.with(holder.imageMovie.getContext()).load(dataPosition.getImage()).into(holder.imageMovie);
        holder.story.setText(String.format("%s%s", res.getString(R.string.story), dataPosition.getStory()));
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }
}
