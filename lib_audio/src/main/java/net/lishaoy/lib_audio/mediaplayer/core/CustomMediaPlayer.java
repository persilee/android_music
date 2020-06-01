package net.lishaoy.lib_audio.mediaplayer.core;

import android.media.MediaPlayer;

import java.io.IOException;

public class CustomMediaPlayer extends MediaPlayer implements MediaPlayer.OnCompletionListener{

    public enum Status {
        IDLE, INITIALIZED, STARTED, PAUSED, STOPPED, COMPLETED;
    }

    private Status mStatus;

    public void setState(Status mState) {
        this.mStatus = mState;
    }

    public Status getState() {
        return mStatus;
    }

    private OnCompletionListener mCompletionListener;

    public CustomMediaPlayer() {
        super();
        mStatus = Status.IDLE;
        super.setOnCompletionListener(this);
    }

    @Override
    public void reset() {
        super.reset();
        mStatus = Status.IDLE;
    }

    @Override
    public void setDataSource(String path) throws IOException, IllegalArgumentException, IllegalStateException, SecurityException {
        super.setDataSource(path);
        mStatus = Status.INITIALIZED;
    }

    @Override
    public void start() throws IllegalStateException {
        super.start();
        mStatus = Status.STARTED;
    }

    @Override
    public void pause() throws IllegalStateException {
        super.pause();
        mStatus = Status.PAUSED;
    }

    @Override
    public void stop() throws IllegalStateException {
        super.stop();
        mStatus = Status.STOPPED;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mStatus = Status.COMPLETED;
    }

    public Status getmStatus() {
        return mStatus;
    }

    public boolean isComplete() {
        return mStatus == Status.COMPLETED;
    }

    public void setCompleteListener(OnCompletionListener listener) {
        mCompletionListener = listener;
    }
}
