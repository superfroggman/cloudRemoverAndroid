package anton.vastkustit.cloud_remover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Scanner;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textView = (TextView) findViewById(R.id.hahaha);
        textView.setText("tryckningar");

        final VideoView videoView = (VideoView)findViewById(R.id.vidd);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();


        if (Intent.ACTION_SEND.equals(action)) {
            if ("text/plain".equals(type)) {
                String dataText = intent.getClipData().getItemAt(0).getText().toString();
                textView.setText(dataText);
                //saska
            }

            if ("video/*".equals(type)) {
                String videoPath = intent.getClipData().getItemAt(0).getUri().toString();
                videoView.setVideoPath(videoPath);
                videoView.start();

                //replay stuff
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        videoView.start();
                    }
                });
                textView.setText(videoPath);
                //saska
            }

        }

    }

}
