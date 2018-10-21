package com.example.vova.androidacademylessons;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ThreadsActivity extends AppCompatActivity {

    private static final String TAG_DEBUGZ = "DEBUGZ";
    static boolean isLeftStep = true;
    static boolean isLeftRunning = false;
    static boolean isRightRunning = false;

    private static Thread leftLegThread;
    private static Thread rightLegThread;
    private Runnable leftLeg;
    private Runnable rightLeg;

    public static synchronized void makeStep() {
        if (isLeftStep) {
            Log.i(TAG_DEBUGZ, "Left");
            isLeftStep = false;
            try {
                leftLegThread.sleep(1000);
            } catch (InterruptedException e) {

            }
        } else {
            Log.i(TAG_DEBUGZ, "Right");
            isLeftStep = true;
            try {
                rightLegThread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    private void runThreads() {
        isLeftRunning = true;
        isRightRunning = true;
        leftLeg = new LeftLeg();
        rightLeg = new RightLeg();
        leftLegThread = new Thread(leftLeg);
        rightLegThread = new Thread(rightLeg);
        leftLegThread.start();
        rightLegThread.start();
    }

    private void stopThreads() {
        isRightRunning = false;
        isLeftRunning = false;

        leftLeg = null;
        rightLeg = null;

        leftLegThread = null;
        rightLegThread = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        runThreads();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopThreads();
    }

    private static class LeftLeg implements Runnable {
        @Override
        public void run() {
            while (isLeftRunning) {
                makeStep();
            }
        }
    }

    private static class RightLeg implements Runnable {
        @Override
        public void run() {
            while (isRightRunning) {
                makeStep();
            }
        }
    }
}
