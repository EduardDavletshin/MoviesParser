package com.example.eddy.moviesparser;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eddy.moviesparser.Models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by eddy on 1/4/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    @BindView(R.id.card_view)
    CardView cardView;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Resources res = holder.movie.getResources();
        final Movie dataPosition = movies.get(position);
        holder.movie.setText(dataPosition.getMovie());
        holder.year.setText(res.getString(R.string.year, String.valueOf(dataPosition.getYear())));
        holder.rating.setText(res.getString(R.string.rating, String.valueOf(dataPosition.getRating())));
        holder.duration.setText(res.getString(R.string.duration, dataPosition.getDuration()));
        holder.director.setText(res.getString(R.string.director, dataPosition.getDirector()));
        holder.tagline.setText("\"" + dataPosition.getTagline() + "\"");

        StringBuilder builder = new StringBuilder();
        builder.append(res.getString(R.string.cast));
        for (int i = 0; i < dataPosition.getCast().size() - 1; i++) {
            builder.append(dataPosition.getCast().get(i).getName()).append(", ");
        }
        builder.append((dataPosition.getCast().get(dataPosition.getCast().size()).getName()));
        holder.cast.setText(builder);

        Picasso.with(holder.imageMovie.getContext()).load(dataPosition.getImage())
                .placeholder(R.drawable.movie_image_placeholder).into(holder.imageMovie);
        holder.story.setText(res.getString(R.string.story, dataPosition.getStory()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(true);
                Intent intent = new Intent(v.getContext(), DetailedMovieActivity.class);
                int id = holder.getAdapterPosition();
                intent.putExtra("movie", movies.get(id));
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }
}
