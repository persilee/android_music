package net.lishaoy.lib_audio.mediaplayer.events;

import net.lishaoy.lib_audio.mediaplayer.model.AudioBean;

public class AudioLoadEvent {
  public AudioBean mAudioBean;

  public AudioLoadEvent(AudioBean audioBean) {
    this.mAudioBean = audioBean;
  }
}
