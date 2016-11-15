package com.example.sihua.drawpannel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Sihua on 2016/11/15.
 */
public class DrawView extends View {
    float preX;
    float preY;
    private Path path;
    public Paint paint;
    Bitmap cacheBitmap=null;
    Canvas cacheCanvas=null;
    public DrawView(Context context, int width,int height) {
        super(context);
        //get a bitmap
        cacheBitmap=Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        cacheCanvas=new Canvas();
        //cacheCanvas set to cacheBitmap
        cacheCanvas.setBitmap(cacheBitmap);
        path=new Path();
        paint=new Paint(Paint.DITHER_FLAG);
        //set paint properties
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint bmpPaint=new Paint();
        canvas.drawBitmap(cacheBitmap,0,0,bmpPaint);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                preX=x;
                preY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX,preY,x,y);
                preX=x;
                preY=y;
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path,paint);
                path.reset();
                break;
        }
        invalidate();
        return true;
    }
}
