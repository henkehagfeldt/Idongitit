package com.example.papric.idongitit;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.view.Window;
import android.view.WindowManager;
import android.hardware.SensorEvent;

public class gameActivity extends AppCompatActivity {

    public class MyView extends View {




        public MyView(Context context){
            super(context);
        }
        Bitmap hacke 	= BitmapFactory.decodeResource(getResources(), R.drawable.hacke1);
        Bitmap hacke2 	= BitmapFactory.decodeResource(getResources(), R.drawable.hacke2);
        Bitmap hacke3 	= BitmapFactory.decodeResource(getResources(), R.drawable.hacke3);
        int getX= 200;
        int getY= 300;
        int sHeight = 0;
        int sWidth = 0;
        void getScreen()	// HÄMTAR SKÄRMSTORLEK
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            sHeight = displaymetrics.heightPixels;
            sWidth = displaymetrics.widthPixels;
            hacke3 = changeBitmapSize(hacke3, (int)(sHeight*0.12), (int)(sWidth*0.15));
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                //diff = extras.getInt("diff");
            }
            // choice 	= r.nextInt(diff*2 - 1 + 1) + 1;
            //scoreX = (float) (sWidth*0.45);
        }
        void Calc()
        {
            getScreen();
        }
        public Bitmap changeBitmapSize(Bitmap bm, int newHeight, int newWidth) // ÄNDRAR STORLEK PÅ BILDER
        {
            int width = bm.getWidth();
            int height = bm.getHeight();
            float scaleWidth = ((float) newWidth) / width;
            float scaleHeight = ((float) newHeight) / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
            return resizedBitmap;
        }


        public boolean onTouchEvent(MotionEvent event) {	// KOLLAR VIDRÖRING
            getX = (int)event.getX();
            getY = (int)event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:                // VID NEDTRYCKNING, KOLLA PLACEHOLDER (SVART RUTA) SAMT MENY VID FÖRLUST
                    //resetting = false;
                    //start = false;
                    /*if (lost == false) {
                        if (placeHolder == true) {
                            if (getX < (xPos + 50) && getX > (xPos - 50) && getY > (yPos - 50) && getY < (yPos + 50)) {
                                run = true;
                                placeHolder = false;
                            }
                        } else {
                            run = true;
                        }
                    } else if (getX > (sWidth / 2 - 300) + 50 && getX < (sWidth / 2 - 300) + 250 && getY > (sHeight / 2 - 600) + 400 && getY < (sHeight / 2 - 600) + 600) {
                        // MENY STARTA OM
                        reset();
                        resetting = true;
                    } else if (getX > (sWidth / 2 - 300) + 350 && getX < (sWidth / 2 - 300) + 550 && getY > (sHeight / 2 - 600) + 400 && getY < (sHeight / 2 - 600) + 600) {
                        // MENY KRYSS
                        finish();
                    }*/
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:    // VID UPPSLÄPP, SKAPAR PLACEHOLDER OCH PAUSAR
                   /* if (placeHolder == false && lost == false && resetting == false) {
                        run = false;
                        placeHolder = true;
                        xPos = getX;
                        yPos = getY;
                    }*/
                    break;
                default:
                    return false;
            }
            return true;
        }
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Calc();
            Paint p = new Paint();
            // p.setAntiAlias(true);
            canvas.drawColor(-1);			// BAKGRUND
            canvas.drawBitmap(hacke3,  getX-100, getY-100, p);
            invalidate();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set window fullscreen and remove title bar, and force landscape orientation
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game2);
        MyView hack = new MyView((this));
        setContentView(hack);

    }
}
