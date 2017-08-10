package com.example.zigotero.reproductorv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Youtube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    YouTubePlayerView youTubePlayerView;
    String claveyoutube="AIzaSyCeVVz9o7CiURJ2wa-XXKOEgbWhjSXV_nY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        Intent i = getIntent();
        if (i!=null){
            String url= i.getStringExtra("videourl");
            Toast.makeText(this, "ulr"+ url, Toast.LENGTH_SHORT).show();
        }

        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.yotube_view);
        
        youTubePlayerView.initialize(claveyoutube, this);



    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean restaurado) {
        if(!restaurado){
            youTubePlayer.cueVideo("CJinWua98NA");

        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this, 1).show();
        } else{
            String Error= "Error al inicializar youtube"+ youTubeInitializationResult.toString();
            Toast.makeText(getApplication(), Error, Toast.LENGTH_SHORT).show();
        }
    }

    protected  void onActivityResult(int requestcode , int resultcode , int  intentdata){

        if(resultcode==1){
            getyoutubeplayerporvider().initialize(claveyoutube, this);
        }
    }
    protected   YouTubePlayer.Provider getyoutubeplayerporvider(){
        return  youTubePlayerView;
    }
}
