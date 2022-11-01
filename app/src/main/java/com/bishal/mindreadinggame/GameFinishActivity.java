package com.bishal.mindreadinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.ImageView;

import com.bishal.mindreadinggame.models.Root;
import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;

public class GameFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finish);

        View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    hideSystemBar();
                                }
                            },2000);
                            // TODO: The system bars are visible. Make any desired
                            // adjustments to your UI, such as showing the action bar or
                            // other navigational controls.
                        } else {
                            // TODO: The system bars are NOT visible. Make any desired
                            // adjustments to your UI, such as hiding the action bar or
                            // other navigational controls.
                        }
                    }
                });
        hideSystemBar();
        KenBurnsView image=findViewById(R.id.game_finish_iv);
        ImageView finalImage=findViewById(R.id.game_finish_image);
        Button finishGame=findViewById(R.id.finishGame);
        String link=getIntent().getStringExtra("image");
        Glide.with(this).load(link).into(image);
        Glide.with(this).load(link).into(finalImage);
        finishGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("finish",true);
                setResult(80,intent);
                finish();
            }
        });
    }

    private void hideSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController controller = getWindow().getInsetsController();

            if (controller != null)
                controller.hide(WindowInsets.Type.statusBars());
        }
        else {

            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
    }
}