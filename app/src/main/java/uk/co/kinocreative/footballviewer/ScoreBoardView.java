package uk.co.kinocreative.footballviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by nemo on 10/03/17.
 */

public class ScoreBoardView extends LinearLayout {

    private Context context;

    public ScoreBoardView(Context context) {
        super(context);
        initializeViews(context);
    }

    public ScoreBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.score_board_view, this);
        setUpScoreboard();
    }

    public void setUpScoreboard() {

        ViewGroup viewGroup = (ViewGroup) getRootView();
        ViewGroup layout = (ViewGroup) this.findViewById(R.id.scores);
        //Log.d("Scoreboard", layout.toString());
        ScoreView scoreView = new ScoreView(this.getContext());
        scoreView.setScores("Newcastle", 27, "Saracens", 35);

        layout.addView(scoreView);
        scoreView = new ScoreView(this.getContext());
        scoreView.setScores("Worcester", 41,"Bristol",24);
        layout.addView(scoreView);


        TextView date = new TextView(this.getContext());
        date.setText("Saturday 5th March");
        date.setPadding(64,8,8,8);

        layout.addView(date);

        scoreView = new ScoreView(this.getContext());
        scoreView.setScores("Gloucester", 27, "Harlequins", 30);
        layout.addView(scoreView);
        scoreView = new ScoreView(this.getContext());
        scoreView.setScores("Bath", 3, "Wasps", 24);
        layout.addView(scoreView);

    }

}
