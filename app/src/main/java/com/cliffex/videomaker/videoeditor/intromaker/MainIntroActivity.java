package com.cliffex.videomaker.videoeditor.intromaker;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import com.cliffex.videomaker.videoeditor.intromaker.libviewpager.CommonFragment;
import com.cliffex.videomaker.videoeditor.intromaker.libviewpager.CustPagerTransformer;
import    com.introvd.base.fulrryconfig.RemotesMoreApp;


import java.util.ArrayList;
import java.util.List;

public class MainIntroActivity extends BaseFragmentActivity implements Runnable, OnClickListener {
    private static final int KEY_AUTO_CHANGE = 181;
    /* access modifiers changed from: private */
    public int[] autoScroll = {1, 2, 1, 0};
    /* access modifiers changed from: private */
    public int count = 0;
    /* access modifiers changed from: private */
    public List<CommonFragment> fragments = new ArrayList();
    private Handler handler = new Handler() {
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == MainIntroActivity.KEY_AUTO_CHANGE) {
                if (MainIntroActivity.this.count > 3) {
                    MainIntroActivity.this.count = 0;
                }
                MainIntroActivity.this.viewPager.setCurrentItem(MainIntroActivity.this.autoScroll[MainIntroActivity.this.count]);
                MainIntroActivity.this.count = MainIntroActivity.this.count + 1;
            }
        }
    };
    /* access modifiers changed from: private */
    public final ArrayList<Integer> images = new ArrayList<>();
    private ImageButton imgMainCreateVideo;
    private ImageButton imgMainRecord;
    private RelativeLayout rltMainEditVideo;
    private RelativeLayout rltMainMyWorks;
    private RelativeLayout rltMainSelfie;
    private RelativeLayout rltMainSupportMe;
    private RelativeLayout rltMainTheme;
    private Thread thread;
    /* access modifiers changed from: private */
    public ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RemotesMoreApp.getdataMoreApp(this);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView("activity_main_intro_maker");
        initData();
        initView();
    }

    private void initView() {
        this.imgMainCreateVideo = (ImageButton) findViewById("img_main__create_video");
        this.imgMainRecord = (ImageButton) findViewById("img_main__record");
        this.rltMainEditVideo = (RelativeLayout) findViewById("rlt_main__edit_video");
        this.rltMainSelfie = (RelativeLayout) findViewById("rlt_main__selfie");
        this.rltMainTheme = (RelativeLayout) findViewById("rlt_main__theme");
        this.rltMainSupportMe = (RelativeLayout) findViewById("rlt_main__support_me");
        this.rltMainMyWorks = (RelativeLayout) findViewById("rlt_main__my_works");
        this.imgMainCreateVideo.setOnClickListener(this);
        this.imgMainRecord.setOnClickListener(this);
        this.rltMainEditVideo.setOnClickListener(this);
        this.rltMainSelfie.setOnClickListener(this);
        this.rltMainTheme.setOnClickListener(this);
        this.rltMainSupportMe.setOnClickListener(this);
        this.rltMainMyWorks.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == this.imgMainCreateVideo.getId()) {
            clickMainCreateVideo();
        } else if (view.getId() == this.imgMainRecord.getId()) {
            clickMainRecord();
        } else if (view.getId() == this.rltMainEditVideo.getId()) {
            clickMainEditVideo();
        } else if (view.getId() == this.rltMainSelfie.getId()) {
            clickMainSelfie();
        } else if (view.getId() == this.rltMainTheme.getId()) {
            clickMainTheme();
        } else if (view.getId() == this.rltMainSupportMe.getId()) {
            clickMainSupportMe();
        } else if (view.getId() == this.rltMainMyWorks.getId()) {
            clickMainMyWorks();
        }
    }

    private void clickMainMyWorks() {
        StartFuntion.startIntroStudio(this);
        Log.d("TAG", "clickMainMyWorks: AAAAAAAAA");
    }

    private void clickMainSupportMe() {
        RemotesMoreApp.showMoreApp(this);
    }

    private void clickMainTheme() {
        StartFuntion.startThemeStore(this);
        Log.d("TAG", "clickMainMyWorks: BBBBBBBBBB");
    }

    private void clickMainSelfie() {
        StartFuntion.startCameraSelfie(this);
        Log.d("TAG", "clickMainMyWorks: ccccccccc");
    }

    private void clickMainEditVideo() {
        StartFuntion.startEditVideo(this);
        Log.d("TAG", "clickMainMyWorks: ddddddddd");
    }

    private void clickMainRecord() {
        StartFuntion.startCameraPhoto(this);
        Log.d("TAG", "clickMainMyWorks: eeeeeeeeeeee");
    }

    private void clickMainCreateVideo() {
        StartFuntion.startCreateIntroVideo(this);
        Log.d("TAG", "clickMainMyWorks: fffffffffff");
    }

    private void initData() {
        this.thread = new Thread(this);
        this.thread.start();
        String str = "drawable";
        this.images.add(new Integer(getResources().getIdentifier("img_viewpager_one", str, getPackageName())));
        this.images.add(new Integer(getResources().getIdentifier("img_viewpager_two", str, getPackageName())));
        this.images.add(new Integer(getResources().getIdentifier("img_viewpager_three", str, getPackageName())));
        this.viewPager = (ViewPager) findViewById("viewpager");
        this.viewPager.setPageTransformer(false, new CustPagerTransformer(this));
        for (int i = 0; i < 3; i++) {
            this.fragments.add(new CommonFragment());
        }
        this.viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            public Fragment getItem(int position) {
                CommonFragment fragment = (CommonFragment) MainIntroActivity.this.fragments.get(position);
                fragment.bindData(((Integer) MainIntroActivity.this.images.get(position)).intValue());
                return fragment;
            }

            public int getCount() {
                return 3;
            }
        });
        this.viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                Message message = new Message();
                message.what = KEY_AUTO_CHANGE;
                this.handler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void onBackPressed() {
        ThemeConfig.setShowIntroBack(this);
        super.onBackPressed();
    }
}
