package com.example.timerview;

public class GameLoop extends Thread {
    private  MyView mView;
    private  boolean bRunning;

    GameLoop(MyView v){
        mView = v;
        bRunning = false;
    }

    public void run(){
        while (true){
            if(bRunning){
                mView.onUpdate();
                mView.postInvalidateDelayed(1000);
                loopPause();
            }
        }
    }

    public void loopPause(){
        bRunning = false;
    }

    public void loopResume(){
        bRunning = true;
    }

}
