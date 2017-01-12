package com.example.eddy.moviesparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eddy.moviesparser.Models.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedMovieActivity extends AppCompatActivity {

    @BindView(R.id.card_view_detailed)
    CardView cardView;
    @BindView(R.id.text_movie2)
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
    Movie moviewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_movie);
        ButterKnife.bind(this);
        moviewItem = getIntent().getExtras().getParcelable("movie");
        if (moviewItem != null) {
            movie.setText(moviewItem.getMovie());
            year.setText(getString(R.string.year, String.valueOf(moviewItem.getYear())));
            rating.setText(getString(R.string.rating, String.valueOf(moviewItem.getRating())));
            duration.setText(getString(R.string.duration, String.valueOf(moviewItem.getDuration())));
            director.setText(getString(R.string.director, moviewItem.getDirector()));
            tagline.setText("\"" + moviewItem.getTagline() + "\"");

            StringBuilder builder = new StringBuilder();
            builder.append(getString(R.string.cast));
            for (int i = 0; i < moviewItem.getCast().size() - 1; i++) {
                builder.append(moviewItem.getCast().get(i).getName()).append(", ");
            }
            builder.append((moviewItem.getCast().get(moviewItem.getCast().size()).getName()));
            cast.setText(builder);

            Picasso.with(imageMovie.getContext()).load(moviewItem.getImage()).placeholder(R.drawable
                    .movie_image_placeholder).into(imageMovie);
            story.setText(getString(R.string.story, moviewItem.getStory()));
        }
    }
}
