package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releaseMediaPlayer();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you goind ?", "minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name ?", "tinne oyaase'na",
                R.raw.phrase_what_is_your_name));
        words.add(new Word("three", "tolookosu", R.raw.phrase_my_name_is));
        words.add(new Word("four", "oyyisa", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("five", "massokka", R.raw.phrase_im_feeling_good));
        words.add(new Word("six", "temmokka", R.raw.phrase_are_you_coming));
        words.add(new Word("seven", "kenekaku", R.raw.phrase_im_coming));
        words.add(new Word("eight", "kawinta", R.raw.phrase_lets_go));
        words.add(new Word("nine", "wo’e", R.raw.phrase_come_here));

        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                /**
                 * Release the media player if it currently exists
                 * because we are about to play a different sound file
                 */
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
                /**
                 * Setup a listener on the media player, so that we can stop and release
                 * the mediaplayer once the sound has finished playing.
                 */
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        /**
         * When the activity is stopped, release the media player resource because
         * we won't be playing any more sounds
         */
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
