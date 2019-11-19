package anton.vastkustit.cloud_remover;

import androidx.appcompat.app.AppCompatActivity;
import wseemann.media.FFmpegMediaMetadataRetriever;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.HashMap;


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
                String videoLink = intent.getClipData().getItemAt(0).getUri().toString();
                videoView.setVideoPath(videoLink);
                videoView.start();

                removeCloud(videoLink);

                textView.setText(videoLink);
                //saskap
            }

        }

    }

    void removeCloud(String videoLink){
        System.out.println(videoLink);

        FFmpegMediaMetadataRetriever med = new FFmpegMediaMetadataRetriever();
        med.setDataSource(videoLink);

        Bitmap bmp = med.getFrameAtTime(1000000, FFmpegMediaMetadataRetriever.OPTION_CLOSEST);

        ImageView img = (ImageView) findViewById(R.id.image1);
        img.setImageBitmap(bmp);

        //img.setImageBitmap(retriever.getFrameAtTime(10000,MediaMetadataRetriever.OPTION_CLOSEST));
    }



}
