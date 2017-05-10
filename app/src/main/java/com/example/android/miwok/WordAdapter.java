package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Archangel on 5/4/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words*/
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //Get the {@link Word} object located at this position in the list

        Word currentWord = getItem(position);

        //Find the TextView in the list_item.xml layout with the id miwok_text_view

        TextView miwokTExtView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView

        miwokTExtView.setText(currentWord.getmMiwokTranslation());

        //Find the TextView in the list_item.xml layout with the id default_text_view

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        //Get the default translation from the currentWord object and set this text on
        // the default TextView

        defaultTextView.setText(currentWord.getDefaultTranslation());

        //Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView

        if(currentWord.hasImage()){
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResourceId());
            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
