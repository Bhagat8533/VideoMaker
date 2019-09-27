package com.introvd.template.component.videofetcher.p241ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.introvd.template.component.videofetcher.C5355a;
import com.introvd.template.component.videofetcher.C5390c;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.dao.C5412b;
import com.introvd.template.component.videofetcher.p238b.C5373c;
import com.introvd.template.component.videofetcher.p238b.C5373c.C5374a;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p239c.C5394d;
import com.introvd.template.component.videofetcher.p239c.C5395e;
import com.introvd.template.component.videofetcher.utils.C5487e;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.view.C5512g;
import com.introvd.template.datacenter.SocialConstDef;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.ui.ShareActivity */
public class ShareActivity extends Activity implements OnClickListener {
    SeekBar clA;
    SurfaceView clB;
    ImageButton clC;
    /* access modifiers changed from: private */
    public int clD;
    C1495b clE;
    /* access modifiers changed from: private */
    public int clF = -1;
    private OnCompletionListener clG = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (ShareActivity.this.clr != null) {
                ShareActivity.this.clr.seekTo(0);
                ShareActivity.this.m14804ke(0);
                ShareActivity.this.clF = -1;
            }
            if (ShareActivity.this.clE != null) {
                ShareActivity.this.clE.dispose();
            }
            if (ShareActivity.this.clC != null && !ShareActivity.this.clC.isShown()) {
                ShareActivity.this.clC.setVisibility(0);
            }
        }
    };
    private OnVideoSizeChangedListener clH = new OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            int measuredWidth = ShareActivity.this.clB.getMeasuredWidth();
            int measuredHeight = ShareActivity.this.clB.getMeasuredHeight();
            int videoWidth = ShareActivity.this.clr.getVideoWidth();
            int videoHeight = ShareActivity.this.clr.getVideoHeight();
            float max = ShareActivity.this.getResources().getConfiguration().orientation == 1 ? Math.max(((float) videoWidth) / ((float) measuredWidth), ((float) videoHeight) / ((float) measuredHeight)) : Math.max(((float) videoWidth) / ((float) measuredHeight), ((float) videoHeight) / ((float) measuredWidth));
            LayoutParams layoutParams = new LayoutParams((int) Math.ceil((double) (((float) videoWidth) / max)), (int) Math.ceil((double) (((float) videoHeight) / max)));
            layoutParams.addRule(13);
            ShareActivity.this.clu.setLayoutParams(layoutParams);
        }
    };
    private OnPreparedListener clI = new OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            ShareActivity.this.cls = true;
            ShareActivity.this.aat();
            if (ShareActivity.this.clr != null) {
                String kg = C5487e.m14897kg(ShareActivity.this.clr.getDuration());
                if (!TextUtils.isEmpty(kg)) {
                    ShareActivity.this.clw.setText(kg);
                }
                ShareActivity.this.clr.seekTo(0);
                ShareActivity.this.m14804ke(0);
                ShareActivity.this.clF = -1;
            }
        }
    };
    private Callback clJ = new Callback() {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(final SurfaceHolder surfaceHolder) {
            C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    if (ShareActivity.this.clr != null) {
                        ShareActivity.this.clr.reset();
                        ShareActivity.this.clr.release();
                    }
                    ShareActivity.this.aas();
                    try {
                        ShareActivity.this.clr.setDisplay(surfaceHolder);
                        ShareActivity.this.clr.prepareAsync();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 50, TimeUnit.MILLISECONDS);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    };
    private OnErrorListener clK = new OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnError - Error code: ");
            sb.append(i);
            sb.append(" Extra code: ");
            sb.append(i2);
            C5489g.m14902d("ruomiz", sb.toString());
            return false;
        }
    };
    private C5373c clp;
    /* access modifiers changed from: private */
    public String clq;
    /* access modifiers changed from: private */
    public MediaPlayer clr;
    /* access modifiers changed from: private */
    public boolean cls;
    RelativeLayout clt;
    RelativeLayout clu;
    TextView clv;
    TextView clw;
    TextView clx;
    TextView cly;
    TextView clz;
    /* access modifiers changed from: private */
    public String thumbPath;

    /* renamed from: Oj */
    private void m14786Oj() {
        aar();
        ((ImageView) findViewById(R.id.share_iv_back)).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.share_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.mo7733a((C1018h) new C5512g());
        this.clp = new C5373c();
        recyclerView.setAdapter(this.clp);
        this.clp.mo26949a((C5374a) new C5374a() {
            /* renamed from: a */
            public void mo26953a(int i, C5395e eVar) {
                if (eVar != null) {
                    C5390c ZH = C5402d.m14716ZG().mo27026ZH();
                    if (ZH != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SocialConstDef.TBL_NAME_SNS, eVar.mo27001ZT());
                        ZH.mo24462a(ShareActivity.this.getApplicationContext(), "Video_Downloader_Share_SNS", hashMap);
                        if (ShareActivity.this.clD != 19) {
                            ZH.mo24461S(eVar.mo27001ZT(), ShareActivity.this.clq);
                        } else if (!TextUtils.isEmpty(ShareActivity.this.clq) && C5488f.m14899fN(ShareActivity.this.clq)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(C5355a.ciX);
                            sb.append(ShareActivity.this.aap());
                            String sb2 = sb.toString();
                            if (!C5488f.m14899fN(sb2)) {
                                ShareActivity.this.m14800h(sb2, false);
                            }
                            ZH.mo24461S(eVar.mo27001ZT(), sb2);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String aap() {
        if (!this.clq.contains("/")) {
            return null;
        }
        int lastIndexOf = this.clq.lastIndexOf("/");
        StringBuilder sb = new StringBuilder();
        sb.append("copy");
        sb.append(this.clq.substring(lastIndexOf + 1, this.clq.length()));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void aaq() {
        C1487a.aUa().mo10058o(new Runnable() {
            public void run() {
                Toast.makeText(ShareActivity.this.getApplicationContext(), ShareActivity.this.getString(R.string.video_fetcher_str_save_success), 0).show();
            }
        });
    }

    private void aar() {
        this.clu = (RelativeLayout) findViewById(R.id.preview_layout);
        this.clt = (RelativeLayout) findViewById(R.id.seekbar_layout);
        this.clv = (TextView) findViewById(R.id.txtview_cur_time);
        this.clw = (TextView) findViewById(R.id.txtview_duration);
        this.clx = (TextView) findViewById(R.id.btn_video_edit);
        this.cly = (TextView) findViewById(R.id.btn_video_save);
        this.clz = (TextView) findViewById(R.id.tv_video_path);
        this.clA = (SeekBar) findViewById(R.id.seek_bar);
        this.clC = (ImageButton) findViewById(R.id.btn_play);
        this.clC.setOnClickListener(this);
        this.clu.setOnClickListener(this);
        this.clx.setOnClickListener(this);
        this.cly.setOnClickListener(this);
        this.clB = (SurfaceView) findViewById(R.id.preview_surface);
        this.clB.getHolder().addCallback(this.clJ);
    }

    /* access modifiers changed from: private */
    public void aas() {
        this.clr = new MediaPlayer();
        if (!TextUtils.isEmpty(this.clq) && C5488f.m14899fN(this.clq)) {
            try {
                this.clr.setAudioStreamType(3);
                this.clr.setDataSource(this.clq);
                this.clr.setLooping(false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.clr.setOnPreparedListener(this.clI);
            this.clr.setOnCompletionListener(this.clG);
            this.clr.setOnVideoSizeChangedListener(this.clH);
            this.clr.setOnErrorListener(this.clK);
        }
    }

    /* access modifiers changed from: private */
    public void aat() {
        if (this.clr != null) {
            this.clA.setMax(this.clr.getDuration());
        }
        this.clA.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    String kg = C5487e.m14897kg(i);
                    if (!TextUtils.isEmpty(kg)) {
                        ShareActivity.this.clv.setText(kg);
                    }
                    if (ShareActivity.this.clr != null) {
                        ShareActivity.this.clr.seekTo(i);
                    }
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                ShareActivity.this.pauseVideo();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (ShareActivity.this.clr != null) {
                    ShareActivity.this.clr.seekTo(seekBar.getProgress());
                }
                ShareActivity.this.m14804ke(seekBar.getProgress());
                ShareActivity.this.aav();
            }
        });
    }

    private void aau() {
        StringBuilder sb = new StringBuilder();
        sb.append(C5355a.ciX);
        sb.append(aap());
        String sb2 = sb.toString();
        if (!C5488f.m14899fN(sb2)) {
            m14800h(sb2, true);
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.video_fetcher_str_save_success), 0).show();
        }
    }

    /* access modifiers changed from: private */
    public void aav() {
        C5402d.m14716ZG().mo27029a(getApplicationContext(), "Video_Downloader_Share_Video_Play", new HashMap());
        if (this.clC != null) {
            this.clC.setVisibility(8);
        }
        if (this.clt != null && !this.clt.isShown()) {
            this.clt.setVisibility(0);
        }
        if (this.clr != null) {
            this.clr.start();
        }
        if (this.clE != null) {
            this.clE.dispose();
        }
        C1834l.m5252a(0, 100, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Long>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                ShareActivity.this.clE = bVar;
            }

            /* renamed from: h */
            public void mo9886K(Long l) {
                if (ShareActivity.this.clr != null) {
                    int currentPosition = ShareActivity.this.clr.getCurrentPosition();
                    if (currentPosition > ShareActivity.this.clF) {
                        ShareActivity.this.m14804ke(currentPosition);
                    }
                    ShareActivity.this.clF = currentPosition;
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: b */
    public static void m14793b(Context context, String str, int i, String str2) {
        Intent intent = new Intent(context, ShareActivity.class);
        intent.putExtra("sharepath", str);
        intent.putExtra("bytestart", i);
        intent.putExtra("thumpath", str2);
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left);
            return;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m14800h(final String str, final boolean z) {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                try {
                    if (!C5488f.m14899fN(C5355a.ciX)) {
                        C5488f.m14900fO(C5355a.ciX);
                    }
                    if (C5488f.copyFile(ShareActivity.this.clq, str) && z) {
                        ShareActivity.this.aaq();
                    }
                    C5391a aVar = new C5391a();
                    aVar.setName(ShareActivity.this.aap());
                    aVar.filePath = str;
                    if (!TextUtils.isEmpty(ShareActivity.this.thumbPath)) {
                        aVar.thumbnailPath = ShareActivity.this.thumbPath;
                    }
                    C5412b.m14731ZZ().aaa().mo27039b(aVar);
                    if (C5488f.m14899fN(str)) {
                        ShareActivity.this.mo27090au(ShareActivity.this.getApplicationContext(), str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initData() {
        this.clz.setText(getString(R.string.video_fetcher_str_save_path, new Object[]{"/Sdcard/DCIM/VivaDownloader/"}));
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new C5395e(R.drawable.fetcher_icon_share_whatsapp, getString(R.string.video_fetcher_str_share_item_whatsapp), "WhatsApp"));
        arrayList.add(new C5395e(R.drawable.fetcher_icon_share_facebook, getString(R.string.video_fetcher_str_share_item_fackbook), "Facebook"));
        arrayList.add(new C5395e(R.drawable.fetcher_icon_share_instagram, getString(R.string.video_fetcher_str_share_item_intagram), "Instagram"));
        arrayList.add(new C5395e(R.drawable.fetcher_icon_share_youtube, getString(R.string.video_fetcher_str_share_item_youtube), "Youtube"));
        arrayList.add(new C5395e(R.drawable.fetcher_icon_share_messager, getString(R.string.video_fetcher_str_share_item_messager), "FBMessenger"));
        if (this.clp != null) {
            this.clp.mo26951aC(arrayList);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ke */
    public void m14804ke(int i) {
        String kg = C5487e.m14897kg(i);
        if (!TextUtils.isEmpty(kg)) {
            this.clv.setText(kg);
        }
        this.clA.setProgress(i);
    }

    /* access modifiers changed from: private */
    public void pauseVideo() {
        if (this.clr != null && this.clr.isPlaying()) {
            this.clr.pause();
        }
        if (this.clE != null) {
            this.clE.dispose();
        }
        if (this.clC != null && !this.clC.isShown()) {
            this.clC.setVisibility(0);
        }
    }

    /* renamed from: au */
    public void mo27090au(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.share_iv_back) {
            finish();
        } else if (view == this.clC) {
            if (this.cls) {
                aav();
            }
        } else if (view == this.clu) {
            pauseVideo();
        } else if (view == this.clx) {
            C5390c ZH = C5402d.m14716ZG().mo27026ZH();
            if (ZH != null) {
                ZH.mo24462a(getApplicationContext(), "Video_Downloader_Share_Edit_Btn", new HashMap());
                ZH.mo24464d(this, this.clq);
            }
        } else if (view == this.cly) {
            C5390c ZH2 = C5402d.m14716ZG().mo27026ZH();
            if (ZH2 != null) {
                ZH2.mo24462a(getApplicationContext(), "Video_Downlaoder_Save_Click", new HashMap());
            }
            if (this.clD == 19) {
                aau();
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.video_fetcher_str_save_success), 0).show();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fetcher_act_share);
        this.clq = getIntent().getStringExtra("sharepath");
        this.thumbPath = getIntent().getStringExtra("thumpath");
        this.clD = getIntent().getIntExtra("bytestart", 0);
        m14786Oj();
        initData();
        C10021c.aZH().mo38494ax(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.clE != null) {
            this.clE.dispose();
        }
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onExit(C5394d dVar) {
        if (dVar.name == 7 && !isFinishing()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        pauseVideo();
        if (isFinishing() && this.clr != null) {
            this.clr.release();
            this.clr = null;
        }
    }
}
