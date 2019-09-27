package com.introvd.template.starvlogs.rate;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import java.util.ArrayList;

public class RateDialog extends Dialog implements OnClickListener {
    public Activity activity;
    private ArrayList<ImageView> arrImages = new ArrayList<>();
    private ImageView imgFiveStar;
    private ImageView imgFourStar;
    private ImageView imgOneStar;
    private ImageView imgThreeStar;
    private ImageView imgTwoStar;

    public RateDialog(Context context) {
        super(context);
        this.activity = (Activity) context;
        initView();
    }

    private void initView() {
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(this.activity.getResources().getIdentifier("dialog_rate_for_app", "layout", this.activity.getPackageName()));
        this.imgOneStar = (ImageView) findViewById(this.activity.getResources().getIdentifier("img_one_star", "id", this.activity.getPackageName()));
        this.imgTwoStar = (ImageView) findViewById(this.activity.getResources().getIdentifier("img_two_star", "id", this.activity.getPackageName()));
        this.imgThreeStar = (ImageView) findViewById(this.activity.getResources().getIdentifier("img_three_star", "id", this.activity.getPackageName()));
        this.imgFourStar = (ImageView) findViewById(this.activity.getResources().getIdentifier("img_four_star", "id", this.activity.getPackageName()));
        this.imgFiveStar = (ImageView) findViewById(this.activity.getResources().getIdentifier("img_five_star", "id", this.activity.getPackageName()));
        this.arrImages.add(this.imgOneStar);
        this.arrImages.add(this.imgTwoStar);
        this.arrImages.add(this.imgThreeStar);
        this.arrImages.add(this.imgFourStar);
        this.arrImages.add(this.imgFiveStar);
        for (int i = 0; i < this.arrImages.size(); i++) {
            ((ImageView) this.arrImages.get(i)).setOnClickListener(this);
        }
    }

    public void onClick(View v) {
        if (v.getId() == this.imgOneStar.getId()) {
            setImageViewRate(0);
            startFeedback();
        } else if (v.getId() == this.imgTwoStar.getId()) {
            setImageViewRate(1);
            startFeedback();
        } else if (v.getId() == this.imgThreeStar.getId()) {
            setImageViewRate(2);
            startFeedback();
        } else if (v.getId() == this.imgFourStar.getId()) {
            setImageViewRate(3);
            startRate();
        } else if (v.getId() == this.imgFiveStar.getId()) {
            setImageViewRate(4);
            startRate();
        }
    }

    public static void showDialogRate(Activity activity2) {
        if (isShowRate(activity2)) {
            new RateDialog(activity2).show();
        }
    }

    private void setImageViewRate(int i) {
        for (int j = 0; j < this.arrImages.size(); j++) {
            if (j <= i) {
                ((ImageView) this.arrImages.get(j)).setImageResource(this.activity.getResources().getIdentifier("ic_star_select", "drawable", this.activity.getPackageName()));
            } else {
                ((ImageView) this.arrImages.get(j)).setImageResource(this.activity.getResources().getIdentifier("ic_star_unselect", "drawable", this.activity.getPackageName()));
            }
        }
    }

    private void startRate() {
        setRateYesOrNo(this.activity);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    RateDialog.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + RateDialog.this.activity.getPackageName())));
                } catch (ActivityNotFoundException e) {
                    RateDialog.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + RateDialog.this.activity.getPackageName())));
                }
            }
        }, 500);
    }

    private void startFeedback() {
        setRateYesOrNo(this.activity);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent Email = new Intent("android.intent.action.SEND");
                Email.setType("text/email");
                Email.putExtra("android.intent.extra.EMAIL", new String[]{"admin@gmail.com"});
                Email.putExtra("android.intent.extra.SUBJECT", "Feedback for Intro Maker");
                RateDialog.this.activity.startActivity(Intent.createChooser(Email, "Send Feedback :"));
            }
        }, 500);
    }

    public static void setRateYesOrNo(Activity activity2) {
        Editor editor = activity2.getSharedPreferences("SHOW_RATE", 0).edit();
        editor.putBoolean("RATE_FOR_APP", false);
        editor.commit();
    }

    public static boolean isShowRate(Activity activity2) {
        return activity2.getSharedPreferences("SHOW_RATE", 0).getBoolean("RATE_FOR_APP", true);
    }
}
