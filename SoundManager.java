package com.ludocashking.audio;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {
    private MediaPlayer bgMusic;
    private MediaPlayer diceSound;
    private MediaPlayer killSound;

    public void playBackgroundMusic(Context context) {
        // یہ مدھم سی میوزک چلائے گا
        // bg_music.mp3 فائل آپ کے res/raw فولڈر میں ہونی چاہیے
        // bgMusic = MediaPlayer.create(context, R.raw.bg_music);
        // bgMusic.setLooping(true);
        // bgMusic.setVolume(0.3f, 0.3f); // والیوم کم رکھنا تاکہ شور نہ ہو
        // bgMusic.start();
    }

    public void playDiceSound(Context context) {
        // ڈائس گھومنے کی آواز
        // diceSound = MediaPlayer.create(context, R.raw.dice_roll);
        // diceSound.start();
    }

    public void playKillSound(Context context) {
        // جب گولی مرے گی تو یہ آواز آئے گی
        // killSound = MediaPlayer.create(context, R.raw.kill_effect);
        // killSound.start();
    }
}
