package com.example.eddy.moviesparser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eddy on 1/4/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.text_movie)
    TextView movie;
    @BindView(R.id.text_year)
    TextView year;
    @BindView(R.id.text_rating)
    TextView rating;
    @BindView(R.id.text_duration)
    TextView duration;
    @BindView(R.id.text_director)
    TextView director;
    @BindView(R.id.text_tagline)
    TextView tagline;
    @BindView(R.id.text_cast)
    TextView cast;
    @BindView(R.id.image_movie)
    ImageView imageMovie;
    @BindView(R.id.text_story)
    TextView story;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
