package anton.vastkustit.cloud_remover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
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
                //videoView.setVideoPath(videoLink);
                //videoView.start();

                removeCloud(videoLink);

                textView.setText(videoLink);
                //saskap
            }

        }

    }

    void removeCloud(String videoLink){
        //MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        System.out.println(videoLink);

        Bitmap bmp = null;
        //try {
            MediaMetadataRetriever retriever = new  MediaMetadataRetriever();
            retriever.setDataSource(videoLink, new HashMap<String, String>());
            bmp = retriever.getFrameAtTime();
        //} catch (Exception e) {
          //  e.printStackTrace();
        //}


        ImageView img = (ImageView) findViewById(R.id.image1);

        img.setImageBitmap(bmp);

        //img.setImageBitmap(retriever.getFrameAtTime(10000,MediaMetadataRetriever.OPTION_CLOSEST));
    }



}
