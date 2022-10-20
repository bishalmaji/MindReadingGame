package com.bishal.mindreadinggame;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Interpolator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bishal.mindreadinggame.adapters.RecyclerOneAdapter;
import com.bishal.mindreadinggame.adapters.RecyclerThreeAdapter;
import com.bishal.mindreadinggame.adapters.RecyclerTwoAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    String[] arr=new String[21];
    String[] a1 =new String[7];
    String[] a2 =new String[7];
    String[] a3 =new String[7];
    boolean entry=true;
    Button b1,b2,b3;
    RecyclerView r1,r2,r3;
    ConstraintLayout c1,c2,c3;
    int clickCount=1;
    RecyclerOneAdapter adapter1;
    RecyclerTwoAdapter adapter2;
    RecyclerThreeAdapter adapter3;
    ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
           if (result.getResultCode()==80){
               Intent intent =result.getData();
               if (intent!=null){
                   boolean bool=intent.getBooleanExtra("finish",true);
                   if (bool)
                       finish();

               }
           }
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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

                        }
                    }
                });
        hideSystemBar();


        fillTheArr();

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        r1=findViewById(R.id.recycler1);
        r2=findViewById(R.id.recycler2);
        r3=findViewById(R.id.recycler3);
        c1=findViewById(R.id.constraintLayout1);
        c2=findViewById(R.id.constraintLayout2);
        c3=findViewById(R.id.constraintLayout3);

        r1.setLayoutManager(new LinearLayoutManager(this));
        r2.setLayoutManager(new LinearLayoutManager(this));
        r3.setLayoutManager(new LinearLayoutManager(this));


        setTheInitial();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickCount<3){
                    b1click();
                    clickCount++;
                } else if(clickCount==3) {
                    changethearray1();
                    Distribute();
                    showFinalDialog(arr[10]);
                    clickCount++;
                }else{
                    Toast.makeText(GameActivity.this, "Game Finished", Toast.LENGTH_SHORT).show();
                }
            }

            private void b1click() {
                changethearray1();
                Distribute();
                AnimateCard();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        seTheRecyclerViewes();
                    }
                },2000);



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickCount<3){
                    b2click();
                    clickCount++;
                } else if(clickCount==3) {
                    changethearray2();
                    Distribute();
                    showFinalDialog(arr[10]);
                    clickCount++;
                }else{
                    Toast.makeText(GameActivity.this, "Game Finished", Toast.LENGTH_SHORT).show();
                }
            }

            private void b2click() {
                changethearray2();
                Distribute();
                AnimateCard();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        seTheRecyclerViewes();
                    }
                },2000);


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickCount<3){
                    b3click();
                    clickCount++;
                }
                else if(clickCount==3) {
                    changethearray3();
                    Distribute();
                    showFinalDialog(arr[10]);
                    clickCount++;
                }else{
                    Toast.makeText(GameActivity.this, "Game Finished", Toast.LENGTH_SHORT).show();
                }
            }

            private void b3click() {
                changethearray3();
                Distribute();
                AnimateCard();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        seTheRecyclerViewes();
                    }
                },2000);

            }
        });



    }

    private void AnimateCard() {
        Animation card_anim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.card_anim);

        c1.startAnimation(card_anim);
        c2.startAnimation(card_anim);
        c3.startAnimation(card_anim);
    }



    private void showFinalDialog(String s) {
        Intent intent=new Intent(GameActivity.this,GameFinishActivity.class);
        intent.putExtra("image",s);
        activityResultLauncher.launch(intent);


    }

    private void fillTheArr() {
        arr= getIntent().getStringArrayListExtra("imageArray").toArray(new String[0]);
    }



    private void changethearray3() {
        int j=0;
        for(int i=0;i<7;i++){
            arr[j]=a1[i];
            j++;
        }
        for(int i=0;i<7;i++){
            arr[j]=a3[i];
            j++;
        }
        for(int i=0;i<7;i++){
            arr[j]=a2[i];
            j++;
        }
    }

    private void changethearray2() {
        int j=0;
        for(int i=0;i<7;i++){
            arr[j]=a1[i];
            j++;
        }
        for(int i=0;i<7;i++){
            arr[j]=a2[i];
            j++;
        }
        for(int i=0;i<7;i++){
            arr[j]=a3[i];
            j++;
        }
    }

    private void Distribute() {
        int j=0;
        for(int i=0;i<7;i++){
            a1[i]=arr[j];
            j++;
            a2[i]=arr[j];
            j++;
            a3[i]=arr[j];
            j++;
        }
    }

    private void changethearray1() {
        int j=0;
        for(int i=0;i<7;i++){
            arr[j]=a2[i];
            j++;
        }
        for(int i=0;i<7;i++){
            arr[j]=a1[i];
            j++;
        }
        for(int i=0;i<7;i++){
            arr[j]=a3[i];
            j++;
        }

    }

    private void setTheInitial() {
        int j=0;
        for(int i=0;i<7;i++){
            a1[i]=arr[j];
            j++;
        }

        for(int i=0;i<7;i++){
            a2[i]=arr[j];
            j++;
        }

        for(int i=0;i<7;i++){
            a3[i]=arr[j];
            j++;
        }
        //set RecyclerView 1;
        seTheRecyclerViewes();

    }

    private void seTheRecyclerViewes() {
        adapter1=new RecyclerOneAdapter(Arrays.asList(a1),GameActivity.this);
        adapter2=new RecyclerTwoAdapter(Arrays.asList(a2),GameActivity.this);
        adapter3=new RecyclerThreeAdapter(Arrays.asList(a3),GameActivity.this);
        r1.setAdapter(adapter1);
        r2.setAdapter(adapter2);
        r3.setAdapter(adapter3);
        if (entry){
            int dy=1000;
            int dy_back=-1000;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    r1.smoothScrollBy(0,dy, new AccelerateDecelerateInterpolator());

                }
            },2000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    r1.smoothScrollBy(0,dy_back,new AccelerateDecelerateInterpolator());

                }
            },4000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    r2.smoothScrollBy(0,dy, new AccelerateDecelerateInterpolator());

                }
            },3000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    r2.smoothScrollBy(0,dy_back,new AccelerateDecelerateInterpolator());

                }
            },5000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    r3.smoothScrollBy(0,dy, new AccelerateDecelerateInterpolator());

                }
            },4000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    r3.smoothScrollBy(0,dy_back,new AccelerateDecelerateInterpolator());

                }
            },6000);
            entry=false;
        }

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