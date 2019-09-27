package com.introvd.template.component.videofetcher.p238b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p240d.C5403a;
import com.introvd.template.component.videofetcher.p240d.C5408e;
import com.introvd.template.component.videofetcher.p241ui.ShareActivity;
import com.introvd.template.component.videofetcher.utils.C5481a;
import com.introvd.template.component.videofetcher.utils.C5484b;
import com.introvd.template.component.videofetcher.utils.C5485c;
import com.introvd.template.component.videofetcher.utils.C5486d;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.utils.C5492i;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.p051a.p053b.C1487a;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.component.videofetcher.b.b */
public class C5369b extends C1008a<C5372a> {
    /* access modifiers changed from: private */
    public final Context aIY;
    /* access modifiers changed from: private */
    public C5403a<C5391a> cjp;
    /* access modifiers changed from: private */
    public List<C5391a> mList;

    /* renamed from: com.introvd.template.component.videofetcher.b.b$a */
    protected class C5372a extends C1034u implements OnClickListener {
        /* access modifiers changed from: private */
        public final ImageView cju;
        /* access modifiers changed from: private */
        public final TextView cjv;
        private final ImageView cjw;
        /* access modifiers changed from: private */
        public final FrameLayout cjx;

        public C5372a(View view) {
            super(view);
            this.cju = (ImageView) view.findViewById(R.id.download_img_complete_thum);
            this.cjv = (TextView) view.findViewById(R.id.download_tv_complete_time);
            this.cjw = (ImageView) view.findViewById(R.id.download_iv_complete_more);
            this.cjx = (FrameLayout) view.findViewById(R.id.download_img_compelte_container);
            this.cjw.setOnClickListener(this);
            this.cjx.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (!C5485c.m14893ig(HttpStatus.SC_INTERNAL_SERVER_ERROR)) {
                if (view == this.cjw) {
                    if (C5369b.this.cjp != null) {
                        C5369b.this.cjp.mo27031c(getAdapterPosition(), C5369b.this.mList.get(getAdapterPosition()));
                    }
                } else if (view == this.cjx) {
                    C5391a aVar = (C5391a) C5369b.this.mList.get(getAdapterPosition());
                    if (aVar != null) {
                        C5402d.m14716ZG().mo27029a(C5369b.this.aIY, "Video_Downloader_MyVideo_Video_Click", new HashMap());
                        ShareActivity.m14793b(C5369b.this.aIY, aVar.getFilePath(), 17, aVar.thumbnailPath);
                    }
                }
            }
        }
    }

    public C5369b(Context context) {
        this.aIY = context;
    }

    /* renamed from: a */
    private int[] m14618a(int i, int i2, FrameLayout frameLayout) {
        LayoutParams layoutParams = frameLayout.getLayoutParams();
        int O = (C5486d.m14895el(this.aIY).width - (C5486d.m14894O(this.aIY, 10) * 3)) / 2;
        int i3 = (i2 * O) / i;
        layoutParams.width = O;
        layoutParams.height = i3;
        frameLayout.setLayoutParams(layoutParams);
        StringBuilder sb = new StringBuilder();
        sb.append("imageViewWidth--");
        sb.append(O);
        sb.append("--imageViewHeight--");
        sb.append(i3);
        C5489g.m14902d("ruomiz", sb.toString());
        return new int[]{O, i3};
    }

    /* renamed from: jU */
    private C5391a m14621jU(int i) {
        if (this.mList == null || i >= this.mList.size()) {
            return null;
        }
        return (C5391a) this.mList.get(i);
    }

    /* renamed from: a */
    public void onBindViewHolder(final C5372a aVar, int i) {
        C5391a jU = m14621jU(i);
        if (jU != null) {
            if (TextUtils.isEmpty(jU.thumbnailPath)) {
                String fR = C5492i.aaE().mo27182fR(jU.getName());
                if (TextUtils.isEmpty(fR) || !C5488f.m14899fN(fR)) {
                    Bitmap fQ = C5492i.aaE().mo27181fQ(jU.getName());
                    if (fQ != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("bitmap--getThumImage-xixi-");
                        sb.append(fQ.getWidth());
                        C5489g.m14904i("ruomiz", sb.toString());
                        int width = fQ.getWidth();
                        int height = fQ.getHeight();
                        if (width == 0 || height == 0) {
                            width = 100;
                            height = 100;
                        }
                        int[] a = m14618a(width, height, aVar.cjx);
                        Bitmap b = C5481a.aaB().mo27170b(fQ, a[0], a[1]);
                        aVar.cju.setScaleType(ScaleType.CENTER_CROP);
                        aVar.cju.setImageBitmap(b);
                    } else {
                        m14618a(100, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, aVar.cjx);
                        aVar.cju.setScaleType(ScaleType.CENTER_INSIDE);
                        aVar.cju.setImageResource(R.drawable.fetcher_bg_download_item_thumb);
                    }
                } else {
                    C5489g.m14904i("ruomiz", "bitmap--getThumPathByName--");
                    Bitmap decodeFile = BitmapFactory.decodeFile(fR);
                    if (decodeFile != null) {
                        int width2 = decodeFile.getWidth();
                        int height2 = decodeFile.getHeight();
                        if (width2 == 0 || height2 == 0) {
                            width2 = 100;
                            height2 = 100;
                        }
                        int[] a2 = m14618a(width2, height2, aVar.cjx);
                        aVar.cju.setImageBitmap(C5481a.aaB().mo27170b(decodeFile, a2[0], a2[1]));
                        aVar.cju.setScaleType(ScaleType.CENTER_CROP);
                    } else {
                        m14618a(100, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, aVar.cjx);
                        aVar.cju.setImageResource(R.drawable.fetcher_bg_download_item_thumb);
                        aVar.cju.setScaleType(ScaleType.CENTER_INSIDE);
                    }
                }
            } else {
                int ZQ = jU.mo26979ZQ();
                int ZR = jU.mo26980ZR();
                if (ZQ == 0 || ZR == 0) {
                    int[] fL = C5484b.aaD().mo27172fL(jU.thumbnailPath);
                    int i2 = fL[0];
                    ZR = fL[1];
                    ZQ = i2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("thumbWidth--");
                sb2.append(ZQ);
                sb2.append("--thumHeight--");
                sb2.append(ZR);
                C5489g.m14902d("ruomiz", sb2.toString());
                int[] a3 = m14618a(ZQ, ZR, aVar.cjx);
                if (!TextUtils.isEmpty(jU.thumbnailPath) && C5488f.m14899fN(jU.thumbnailPath)) {
                    C5489g.m14904i("ruomiz", "bitmap--getThumImage-db-");
                    aVar.cju.setImageBitmap(C5481a.aaB().mo27171c(jU.thumbnailPath, a3[0], a3[1]));
                    aVar.cju.setScaleType(ScaleType.CENTER_CROP);
                }
            }
            if (TextUtils.isEmpty(jU.duration)) {
                C5492i.aaE().mo27177a(jU.filePath, new C5408e() {
                    /* renamed from: dV */
                    public void mo26946dV(final String str) {
                        C1487a.aUa().mo10058o(new Runnable() {
                            public void run() {
                                aVar.cjv.setText(str);
                            }
                        });
                    }
                });
            } else {
                aVar.cjv.setText(jU.duration);
            }
        }
    }

    /* renamed from: a */
    public void mo26943a(C5403a<C5391a> aVar) {
        this.cjp = aVar;
    }

    /* renamed from: aD */
    public void mo26944aD(List<C5391a> list) {
        this.mList = list;
        StringBuilder sb = new StringBuilder();
        sb.append("添加下载之后的数据");
        sb.append(this.mList.size());
        sb.append("");
        C5489g.m14902d("ruomiz", sb.toString());
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    /* renamed from: t */
    public C5372a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C5372a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_view_download_item_complete, viewGroup, false));
    }
}
