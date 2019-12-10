package anton.vastkustit.cloud_remover;

import androidx.appcompat.app.AppCompatActivity;
import wseemann.media.FFmpegMediaMetadataRetriever;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.net.URI;


public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textView = (TextView) findViewById(R.id.hahaha);
        textView.setText("tryckningar");

        final VideoView videoView = (VideoView) findViewById(R.id.vidd);

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
                Uri videoLink = intent.getClipData().getItemAt(0).getUri();
                //videoView.setVideoPath(videoLink);
                //videoView.start();

                removeCloud(videoLink);

                //textView.setText(videoLink);

                //DO NOT REMOVE saskapp!
                //saskapp
            }

        }

    }

    void removeCloud(Uri videoLink) {
        System.out.println(videoLink);

        FFmpegMediaMetadataRetriever med = new FFmpegMediaMetadataRetriever();
        med.setDataSource("https://marksism.space/fina_bilder/vid_haha.mp4");
        Bitmap bmp = med.getFrameAtTime(1000000, FFmpegMediaMetadataRetriever.OPTION_CLOSEST);

        ImageView img = (ImageView) findViewById(R.id.image1);
        img.setImageBitmap(bmp);

        //img.setImageBitmap(retriever.getFrameAtTime(10000,MediaMetadataRetriever.OPTION_CLOSEST));
    }


}
