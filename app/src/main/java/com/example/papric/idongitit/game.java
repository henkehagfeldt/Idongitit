package com.example.papric.idongitit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Henke on 2016-08-28.
 */
public class game{
    public class MyView extends View {
        public MyView(Context context){
            super(context);

        }

        Rect r1     = new Rect();
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);

            canvas.drawColor(-1);			// BAKGRUND
            invalidate();
        }
    }
    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
    // super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_game);
    // MyView torkel = new MyView(this);
    //  setContentView(torkel);
    //}
}
