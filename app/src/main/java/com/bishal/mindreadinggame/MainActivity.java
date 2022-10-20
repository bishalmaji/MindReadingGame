package com.bishal.mindreadinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bishal.mindreadinggame.models.Root;
import com.bishal.mindreadinggame.network.ImageApi;
import com.bishal.mindreadinggame.network.RetrofitClient;
import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list=new ArrayList<>();
    String [] categoryArray={"magic","girls","blossom","lifestyle","food","wings","car","smiling","party","Nature","monuments","luxury","rain","spring","eco","blossom","health","wings","surf","festival"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton launchGame=findViewById(R.id.goBtn);
        launchGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,GameActivity.class);
                intent.putStringArrayListExtra("imageArray", list);
              startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
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
        init();
        getImages();

    }
    private int getRandomNo(int a,int b){
        return ThreadLocalRandom.current().nextInt(a,b+1);
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


    private KenBurnsView i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21;
    private void init(){
        i1=findViewById(R.id.imageView16);
        i2=findViewById(R.id.imageView15);
        i3=findViewById(R.id.imageView14);
        i4=findViewById(R.id.imageView13);
        i5=findViewById(R.id.imageView12);
        i6=findViewById(R.id.imageView11);
        i7=findViewById(R.id.imageView10);
        i8=findViewById(R.id.imageView9);
        i9=findViewById(R.id.imageView8);
        i10=findViewById(R.id.imageView7);
        i11=findViewById(R.id.imageView6);
        i12=findViewById(R.id.imageView5);
        i13=findViewById(R.id.imageView4);
        i14=findViewById(R.id.imageView3);
        i15=findViewById(R.id.imageView2);
        i16=findViewById(R.id.imageView17);
        i17=findViewById(R.id.imageView18);
        i18=findViewById(R.id.imageView19);
        i19=findViewById(R.id.imageView20);
        i20=findViewById(R.id.imageView21);
        i21=findViewById(R.id.imageView22);


    }
    private void getImages() {
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ImageApi api = retrofit.create(ImageApi.class);
        int random=getRandomNo(0,19);
        String category=categoryArray[random];
        Call<Root> call = api.getImages(category,1,100);
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.body()!=null){
                    for (int i = 0; i < 21; i++) {
                        list.add(response.body().getResults().get(i).getUrls().getRegular());
                    }
                    setImages();

                }
            }



            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(MainActivity.this, "fail"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                list.add(null);
            }
        });

    }
    private void setImages() {
        Glide.with(this).load(list.get(0)).into(i1);
        Glide.with(this).load(list.get(1)).into(i2);
        Glide.with(this).load(list.get(2)).into(i3);
        Glide.with(this).load(list.get(3)).into(i4);
        Glide.with(this).load(list.get(4)).into(i5);
        Glide.with(this).load(list.get(5)).into(i6);
        Glide.with(this).load(list.get(6)).into(i7);
        Glide.with(this).load(list.get(7)).into(i8);
        Glide.with(this).load(list.get(8)).into(i9);
        Glide.with(this).load(list.get(9)).into(i10);
        Glide.with(this).load(list.get(10)).into(i11);
        Glide.with(this).load(list.get(11)).into(i12);
        Glide.with(this).load(list.get(12)).into(i13);
        Glide.with(this).load(list.get(13)).into(i14);
        Glide.with(this).load(list.get(14)).into(i15);
        Glide.with(this).load(list.get(15)).into(i16);
        Glide.with(this).load(list.get(16)).into(i17);
        Glide.with(this).load(list.get(17)).into(i18);
        Glide.with(this).load(list.get(18)).into(i19);
        Glide.with(this).load(list.get(19)).into(i20);
        Glide.with(this).load(list.get(20)).into(i21);


    }

}