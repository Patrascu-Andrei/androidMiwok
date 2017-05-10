package com.example.android.miwok;

/**
 * Created by Archangel on 5/4/2017.
 * {@link Word} represents a vocabulary word that the user wants to elarn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {

    /** Default translation for the word*/
    private String mDefaultTranslation;

    /** Miwok translation for the word*/
    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation  is the word in the Miwok language
     */

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }
    /**
     * Create a new word object.
     *
     * @param DefaultTranslation  is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     *
     * @param imageResourceId is the drawable resource ID for the image asociated with the word
     */

    public Word(String DefaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

    }

    /**Get the default translation of the word
     *
     * @return
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**Get the miwok translation of the word
     *
     * @return
     */
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the audio resource ID of the word.
     * @return
     */
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    /**
     * Return whether or not there is an image for this word.
     *
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}

