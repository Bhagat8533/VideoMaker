package com.introvd.template.common;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.widget.Toast;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;

public class Toaster implements Runnable {
    Context ccV;
    CharSequence ccW;
    int ccX;
    Activity ccY;

    public Toaster(Activity activity, Context context, CharSequence charSequence, int i) {
        this.ccY = activity;
        this.ccV = context;
        this.ccW = charSequence;
        this.ccX = i;
    }

    public void run() {
        try {
            Toast makeText = Toast.makeText(this.ccV, this.ccW, this.ccX);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } catch (Exception unused) {
        }
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(Toaster.this.ccX == 0 ? 1000 : AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Process.killProcess(Process.myPid());
            }
        }).start();
    }
}
