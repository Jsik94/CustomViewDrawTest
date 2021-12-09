package com.jsikmc15.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    public CustomView(Context context) {
        super(context);

    }
    private int ix,iy,ex,ey;
    private Path path = new Path();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String TAG = "CHECKER";


    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);


        canvas.drawColor(Color.rgb(232,221,121));

        //paint 스타일 속성임
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);

        //스타일 속성 셋업
        paint.setColor(Color.RED);
        paint.setStrokeWidth(15);
        canvas.drawPath(path,paint);
//
//        //점
//        canvas.drawPoint(100,100,paint);
//        //선
//        paint.setColor(Color.BLUE);
//        paint.setStrokeWidth(30);
//        canvas.drawLine(150,150,300,504,paint);
//
//        paint.setColor(0x880000ff);
//        paint.setStrokeWidth(8);
//        canvas.drawRect(150,150,500,350,paint);
//
//        canvas.drawCircle(700,700,300,paint);


//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_lock_airplane_mode_alpha);
//
//        //원본크기
////        canvas.drawBitmap(bitmap,500,200,null);
//        //크기확장
//        canvas.drawBitmap(bitmap,null,new Rect(250,550,250+400,550+400),null);
//
//        //특정 부분만 추출
//
//        int width =bitmap.getWidth();
//        int height = bitmap.getHeight();
//        Log.i(TAG, "onDraw bitmap width : " + width+" height : " + height);
//        canvas.drawBitmap(bitmap,400,300,null);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ix = (int)event.getX();
        iy = (int)event.getY();

        if(event.getAction()==MotionEvent.ACTION_UP){
            ex= (int)event.getX();
            ey=(int)event.getY();
        }else if(event.getAction()==MotionEvent.ACTION_DOWN){

            path.moveTo(ix,iy);
        } else if(event.getAction()==MotionEvent.ACTION_MOVE){

            path.lineTo(ix,iy);
        } else{
            return false;
        }

        invalidate();

        return true;
    }
}
