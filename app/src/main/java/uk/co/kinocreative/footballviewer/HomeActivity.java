package uk.co.kinocreative.footballviewer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.net.Uri;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import rejasupotaro.asyncrssclient.AsyncRssClient;
import rejasupotaro.asyncrssclient.AsyncRssResponseHandler;
import rejasupotaro.asyncrssclient.RssFeed;
import rejasupotaro.asyncrssclient.RssItem;

import org.apache.http.Header;

public class HomeActivity extends AppCompatActivity {

    AsyncRssClient client = new AsyncRssClient();
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewGroup layout = (ViewGroup) findViewById(R.id.rss_feed);

        VideoView videoView = (VideoView) findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.luxury);
        Log.d("Video", uri.toString());
        //layout.addView(videoView);
        videoView.setVideoURI(uri);
        videoView.seekTo(10000);
        //videoView.start();

        client.read("http://feeds.bbci.co.uk/news/uk/rss.xml", new AsyncRssResponseHandler() {
            @Override
            public void onSuccess(RssFeed rssFeed) {
                String title = rssFeed.getTitle();
                String description = rssFeed.getDescription();

                setUpScoreboard();


                /*ScoreView scoreView;

                for( Integer i = 0; i < 2; i++) {
                    scoreView = new ScoreView(context);
                    scoreView.setScores("Newcastle", 2, "Sunderland", 1);
                    layout.addView(scoreView);
                    Log.d("Scores", i.toString());
                }*/

                Log.d("RSS Feed", title);
                Log.d("RSS Feed", description);

                /*for (RssItem rssItem : rssFeed.getRssItems()) {

                    String rssString = "";

                    TextView rssView = new TextView(context);

                    rssString = rssString + rssItem.getTitle();
                    rssString += "\n\n" + rssItem.getDescription() + "\n\n\n";

                    rssView.setText(rssString);
                    layout.addView(rssView);
                    title = rssItem.getTitle();
                    Log.d("RSS Feed", title);


                }*/

                RssItem rssItem = rssFeed.getRssItems().get(0);
                rssItem.getTitle();

                MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.luxury);
                mediaPlayer.start();

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }
        });


    }

    public void onButtonClick(View v) {

        VideoView videoView = (VideoView) findViewById(R.id.videoview);
        videoView.seekTo(0);
        //Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.luxury);
        //videoView.setVideoURI(uri);
        videoView.start();

    }

    public void setUpScoreboard() {

        ViewGroup layout = (ViewGroup) findViewById(R.id.score_board);
        ScoreView scoreView = new ScoreView(context);
        scoreView.setScores("Newcastle", 27, "Saracens", 35);
        layout.addView(scoreView);
        scoreView = new ScoreView(context);
        scoreView.setScores("Worcester", 41,"Bristol",24);
        layout.addView(scoreView);

        TextView date = new TextView(context);
        date.setText("Saturday 5th March");
        date.setPadding(64,8,8,8);

        layout.addView(date);

        scoreView = new ScoreView(context);
        scoreView.setScores("Gloucester", 27, "Harlequins", 30);
        layout.addView(scoreView);
        scoreView = new ScoreView(context);
        scoreView.setScores("Bath", 3, "Wasps", 24);
        layout.addView(scoreView);

    }
}
