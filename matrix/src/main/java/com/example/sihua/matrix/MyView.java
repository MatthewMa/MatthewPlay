package com.example.sihua.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by Sihua on 2016/11/15.
 */
public class MyView extends View{
    private Bitmap bitmap=null;
    private Matrix matrix=new Matrix();
    private float scale=1.0f;
    private float sx=0.0f;
    private int width,height;
    private boolean isScale=false;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.a)).getBitmap();
        width=bitmap.getWidth();
        height=bitmap.getHeight();
        this.setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        matrix.reset();
        if(isScale){
            matrix.setScale(scale,scale);
        }else{
            matrix.setSkew(sx,0);
        }
        Bitmap bitmap1=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        canvas.drawBitmap(bitmap1,matrix,null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_A:
                isScale=false;
                //LEFT SKEW
                sx+=0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_D:
                isScale=false;
                sx-=0.1;
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_W:
                isScale=true;
                if(scale<2){
                    scale+=0.1;
                }
                postInvalidate();
                break;
            case KeyEvent.KEYCODE_S:
                isScale=true;
                if(scale>0.5){
                    scale-=0.1;
                }
                postInvalidate();
                break;
        }
        return super.onKeyDown(keyCode,event);
    }
}
