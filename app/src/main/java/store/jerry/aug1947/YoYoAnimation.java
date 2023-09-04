package store.jerry.aug1947;

import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


//    implementation 'com.daimajia.androidanimations:library:2.4@aar'


public class YoYoAnimation {

    public void tada(View view){
        YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(5)
                .playOn(view);
    }

    public void bounceLeft(View view){
        YoYo.with(Techniques.BounceInLeft)
                .duration(700)
                .repeat(5)
                .playOn(view);
    }

    public void pulse(View view){
        YoYo.with(Techniques.Pulse)
                .duration(700)
                .repeat(2)
                .playOn(view);
    }


    public void zoomIn(View view){
        YoYo.with(Techniques.ZoomIn)
                .duration(1000)
                .repeat(0)
                .playOn(view);
    }

    public void slideUp(View view){
        YoYo.with(Techniques.SlideInUp)
                .duration(1000)
                .repeat(0)
                .playOn(view);
    }

    public void slideDown(View view){
        YoYo.with(Techniques.SlideOutDown)
                .duration(1000)
                .repeat(0)
                .playOn(view);
    }

    public void flipInX(View view){
        YoYo.with(Techniques.FlipInX)
                .duration(1000)
                .repeat(0)
                .playOn(view);
    }



}
