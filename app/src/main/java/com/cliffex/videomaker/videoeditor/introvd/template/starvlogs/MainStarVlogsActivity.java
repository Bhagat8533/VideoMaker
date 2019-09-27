package com.introvd.template.starvlogs;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.app.FragmentStatePagerAdapter;
import android.support.p021v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.base.utlisads.CrashAll;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.videoeditor.intromaker.StartFuntion;
import java.util.ArrayList;
import java.util.List;

public class MainStarVlogsActivity extends FragmentActivity implements OnClickListener, Runnable {
    private static final int KEY_AUTO_CHANGE = 181;
    /* access modifiers changed from: private */
    public int[] autoScroll = {2, 1, 0, 1};
    /* access modifiers changed from: private */
    public int count = 0;
    private Handler handler = new Handler() {
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == MainStarVlogsActivity.KEY_AUTO_CHANGE) {
                if (MainStarVlogsActivity.this.count > 3) {
                    MainStarVlogsActivity.this.count = 0;
                }
                MainStarVlogsActivity.this.viewpager.setCurrentItem(MainStarVlogsActivity.this.autoScroll[MainStarVlogsActivity.this.count]);
                MainStarVlogsActivity.this.count = MainStarVlogsActivity.this.count + 1;
            }
        }
    };
    private ImageView img_ads_main;
    private ImageView img_create;
    private ImageView img_edit;
    private ImageView img_record;
    private LinearLayout lnl_mystudio;
    private LinearLayout lnl_selfie;
    private LinearLayout lnl_support;
    private LinearLayout lnl_themes;
    private Thread thread;
    /* access modifiers changed from: private */
    public ViewPager viewpager;

    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ToolsUtils.getIdLayout(this, "main_activity_starvlogs"));
        CrashAll.init(this);
        initImageLoader();
        findViewId();
        startActionAds();
    }

    public void startActionAds() {
        Drawable drawable = ((ImageView) findViewById(ToolsUtils.findViewId(this, "btn_ads_main"))).getDrawable();
        ((AnimationDrawable) drawable).start();
        ((AnimationDrawable) drawable).setOneShot(false);
    }

    public void findViewId() {
        this.viewpager = (ViewPager) findViewById(ToolsUtils.findViewId(this, "viewpager"));
        this.lnl_selfie = (LinearLayout) findViewById(ToolsUtils.findViewId(this, "lnl_selfie"));
        this.lnl_themes = (LinearLayout) findViewById(ToolsUtils.findViewId(this, "lnl_themes"));
        this.lnl_mystudio = (LinearLayout) findViewById(ToolsUtils.findViewId(this, "lnl_mystudio"));
        this.lnl_support = (LinearLayout) findViewById(ToolsUtils.findViewId(this, "lnl_support_me"));
        this.img_record = (ImageView) findViewById(ToolsUtils.findViewId(this, "img_record"));
        this.img_create = (ImageView) findViewById(ToolsUtils.findViewId(this, "img_create"));
        this.img_edit = (ImageView) findViewById(ToolsUtils.findViewId(this, "img_edit"));
        this.lnl_selfie.setOnClickListener(this);
        this.lnl_themes.setOnClickListener(this);
        this.lnl_mystudio.setOnClickListener(this);
        this.lnl_support.setOnClickListener(this);
        this.img_record.setOnClickListener(this);
        this.img_create.setOnClickListener(this);
        this.img_edit.setOnClickListener(this);
        setUpViewPager();
    }

    public void setUpViewPager() {
        this.thread = new Thread(this);
        this.thread.start();
        final List<CommonFragment> fragments = new ArrayList<>();
        final String[] imageArray = {"assets://image1.png", "assets://image2.png", "assets://image3.png"};
        this.viewpager.setPageTransformer(false, new CustPagerTransformer(this));
        for (int i = 0; i < 3; i++) {
            fragments.add(new CommonFragment());
        }
        this.viewpager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            public Fragment getItem(int position) {
                CommonFragment fragment = (CommonFragment) fragments.get(position % 10);
                fragment.bindData(imageArray[position % imageArray.length]);
                return fragment;
            }

            public int getCount() {
                return 3;
            }
        });
        this.viewpager.setCurrentItem(1);
    }

    public void initImageLoader() {
        ImageLoader.getInstance().init(new Builder(this).memoryCacheExtraOptions(480, 800).threadPoolSize(3).threadPriority(4).tasksProcessingOrder(QueueProcessingType.FIFO).denyCacheImageMultipleSizesInMemory().memoryCache(new LruMemoryCache(2097152)).memoryCacheSize(2097152).memoryCacheSizePercentage(13).discCacheSize(52428800).discCacheFileCount(100).discCacheFileNameGenerator(new HashCodeFileNameGenerator()).imageDownloader(new BaseImageDownloader(this)).defaultDisplayImageOptions(DisplayImageOptions.createSimple()).writeDebugLogs().build());
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == this.lnl_selfie.getId()) {
            StartFuntion.startCameraSelfie(this);
            ActionFirebaseStarVlogs.actionClickSelfieCamera(this);
        } else if (id == this.lnl_themes.getId()) {
            StartFuntion.startThemeStore(this);
            ActionFirebaseStarVlogs.actionClickThemesActivity(this);
        } else if (id == this.lnl_mystudio.getId()) {
            StartFuntion.startIntroStudio(this);
            ActionFirebaseStarVlogs.actionClickMyStudioActivity(this);
        } else if (id == this.lnl_support.getId()) {
            CrashAll.loadAndshow(this, "las_support_me");
            ActionFirebaseStarVlogs.actionClickSupportMe(this);
        } else if (id == this.img_record.getId()) {
            StartFuntion.startCameraPhoto(this);
            ActionFirebaseStarVlogs.actionClickRecorderActivity(this);
        } else if (id == this.img_create.getId()) {
            StartFuntion.startCreateIntroVideo(this);
            ActionFirebaseStarVlogs.actionClickCreateVideoActivity(this);
        } else if (id == this.img_edit.getId()) {
            StartFuntion.startEditVideo(this);
            ActionFirebaseStarVlogs.actionClickEditActivity(this);
        }
    }

    private void clickMainMyStudio() {
        ActionMain.startMyStudio();
        Log.d("LeoVirgo", "clickMainMyStudio");
    }

    private void clickMainSupportMe() {
        ActionMain.startSupport();
        Log.d("LeoVirgo", "clickMainSupportMe");
    }

    private void clickMainTheme() {
        ActionMain.startThemes();
        Log.d("LeoVirgo", "clickMainTheme");
    }

    private void clickMainSelfie() {
        Log.d("LeoVirgo", "clickMainSelfie");
    }

    private void clickMainEditVideo() {
        ActionMain.startEdit();
        Log.d("LeoVirgo", "clickMainEditVideo");
    }

    private void clickMainRecord() {
        ActionMain.startRecord();
        Log.d("LeoVirgo", "clickMainRecord");
    }

    private void clickMainCreateVideo() {
        ActionMain.startCreate();
        Log.d("LeoVirgo", "clickMainCreateVideo");
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                Message message = new Message();
                message.what = KEY_AUTO_CHANGE;
                this.handler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void onClickButtonAds(View view) {
        CrashAll.loadAndshow(this, "las_btn_ads_main");
        ActionFirebaseStarVlogs.actionClickButtonAdsMain(this);
    }
}
