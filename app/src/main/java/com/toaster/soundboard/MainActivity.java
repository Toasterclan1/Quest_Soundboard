package com.toaster.soundboard;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    private LinearLayout buttonContainer;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO
        }, 1);

        buttonContainer = findViewById(R.id.buttonContainer);

        File downloadDir = new File("/sdcard/Download");
        if (downloadDir.exists() && downloadDir.isDirectory()) {
            File[] files = downloadDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().endsWith(".mp3") || f.getName().endsWith(".wav")) {
                        Button btn = new Button(this);
                        btn.setText(f.getName());
                        btn.setOnClickListener(v -> playSound(f));
                        buttonContainer.addView(btn);
                    }
                }
            }
        }
    }

    private void playSound(File file) {
        if (mediaPlayer != null) mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(this, Uri.fromFile(file));
        mediaPlayer.start();
    }
}

