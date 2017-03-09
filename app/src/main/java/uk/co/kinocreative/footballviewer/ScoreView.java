package uk.co.kinocreative.footballviewer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * TODO: document your custom view class.
 */
public class ScoreView extends LinearLayout {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    public ScoreView(Context context) {
        super(context);
        initializeViews(context);
    }

    public ScoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public void setScores(String team1, Integer team1Score, String team2, Integer team2Score) {
        TextView team1Name = (TextView) this.findViewById(R.id.team_1_name);
        team1Name.setText(team1);
        TextView team1ScoreView = (TextView) this.findViewById(R.id.team_1_score);
        team1ScoreView.setText(team1Score.toString());
        TextView team2Name = (TextView) this.findViewById(R.id.team_2_name);
        team2Name.setText(team2);
        TextView team2ScoreView = (TextView) this.findViewById(R.id.team_2_score);
        team2ScoreView.setText(team2Score.toString());
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sample_score_view, this);
    }

}
