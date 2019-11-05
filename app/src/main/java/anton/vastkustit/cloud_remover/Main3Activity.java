package anton.vastkustit.cloud_remover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


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
                String vidData = intent.getClipData().getItemAt(0).getUri().toString();
                videoView.setVideoPath(vidData);
                videoView.start();

                //removeCloud(vidData);!

                textView.setText(vidData);
                //saska
            }

        }

    }

    void removeCloud(String vidData){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(vidData);

        ImageView img = (ImageView) findViewById(R.id.image1);

        img.setImageBitmap(retriever.getFrameAtTime(10000,MediaMetadataRetriever.OPTION_CLOSEST));
    }

}
