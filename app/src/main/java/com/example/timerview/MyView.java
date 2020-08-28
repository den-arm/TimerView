package com.example.timerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    private Paint paint = new Paint();
    private int x,y;
    private int line_x = 500, line_y = 500;
    private  float count;
    private  GameLoop loop;

    MyView(Context ctx){
        super(ctx);
        init();
        loop = new GameLoop(this);
        loop.start();
    }

    public void init(){
        count = 0;
        x = (int)(400.0*Math.cos(2*Math.PI*count/12.0));
        y = (int)(400.0*Math.sin(2*Math.PI*count/12.0));
    }

    public void onUpdate(){
        if(count > 12) count = 0;
        x = (int)(400.0*Math.cos(2*Math.PI*count/12.0));
        y = (int)(400.0*Math.sin(2*Math.PI*count/12.0));
        count++;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        canvas.drawLine(line_x,line_y,line_x+x,line_y+y,paint);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        canvas.drawRect(line_x-20,line_y-20,line_x+20,line_y+20,paint);
        paint.setColor(Color.CYAN);
        canvas.drawRect(line_x-15,line_y-15,line_x+15,line_y+15,paint);

        loop.loopResume();
    }
}
