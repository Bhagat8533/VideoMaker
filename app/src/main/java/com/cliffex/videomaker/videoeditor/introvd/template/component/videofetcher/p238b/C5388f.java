package com.introvd.template.component.videofetcher.p238b;

import android.content.Context;
import android.net.Uri;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p239c.C5399i;
import com.introvd.template.component.videofetcher.p240d.C5403a;
import com.introvd.template.component.videofetcher.p241ui.ShareActivity;
import com.introvd.template.component.videofetcher.utils.C5485c;
import com.introvd.template.component.videofetcher.utils.C5486d;
import com.introvd.template.component.videofetcher.utils.C5487e;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.List;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.component.videofetcher.b.f */
public class C5388f extends C1008a<C5389a> {
    /* access modifiers changed from: private */
    public Context aIY;
    /* access modifiers changed from: private */
    public List<C5399i> cjS;
    /* access modifiers changed from: private */
    public C5403a<C5399i> cjp;

    /* renamed from: com.introvd.template.component.videofetcher.b.f$a */
    class C5389a extends C1034u implements OnClickListener {
        ImageButton cjT;
        ImageView cju;
        TextView cjv;
        FrameLayout cjx;

        C5389a(View view) {
            super(view);
            this.cju = (ImageView) view.findViewById(R.id.download_img_complete_thum);
            this.cjv = (TextView) view.findViewById(R.id.download_tv_complete_time);
            this.cjT = (ImageButton) view.findViewById(R.id.download_iv_complete_more);
            this.cjx = (FrameLayout) view.findViewById(R.id.download_img_compelte_container);
            this.cjT.setOnClickListener(this);
            this.cjx.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (!C5485c.m14893ig(HttpStatus.SC_INTERNAL_SERVER_ERROR)) {
                if (view == this.cjT) {
                    if (C5388f.this.cjp != null) {
                        C5388f.this.cjp.mo27031c(getAdapterPosition(), C5388f.this.cjS.get(getAdapterPosition()));
                    }
                } else if (view == this.cjx) {
                    C5399i iVar = (C5399i) C5388f.this.cjS.get(getAdapterPosition());
                    if (!(iVar == null || C5388f.this.aIY == null)) {
                        C5402d.m14716ZG().mo27029a(C5388f.this.aIY, "Video_Downloader_WhatsApp_Video_Click", new HashMap());
                        ShareActivity.m14793b(C5388f.this.aIY, iVar.getPath(), 19, iVar.mo27010ZP());
                    }
                }
            }
        }
    }

    public C5388f(Context context) {
        this.aIY = context;
    }

    /* renamed from: b */
    private void m14670b(int i, int i2, FrameLayout frameLayout) {
        LayoutParams layoutParams = frameLayout.getLayoutParams();
        int O = (C5486d.m14895el(this.aIY).width - (C5486d.m14894O(this.aIY, 10) * 3)) / 2;
        int i3 = (i2 * O) / i;
        layoutParams.width = O;
        layoutParams.height = i3;
        frameLayout.setLayoutParams(layoutParams);
    }

    /* renamed from: jW */
    private C5399i m14672jW(int i) {
        if (this.cjS == null || this.cjS.isEmpty()) {
            return null;
        }
        return (C5399i) this.cjS.get(i);
    }

    /* renamed from: a */
    public void onBindViewHolder(C5389a aVar, int i) {
        C5399i jW = m14672jW(i);
        if (jW != null) {
            aVar.cjv.setText(C5487e.m14896kf((int) jW.getDuration()));
            if (TextUtils.isEmpty(jW.mo27010ZP()) || !C5488f.m14899fN(jW.mo27010ZP())) {
                aVar.cju.setScaleType(ScaleType.CENTER_INSIDE);
                aVar.cju.setImageResource(R.drawable.fetcher_bg_download_item_thumb);
                m14670b(100, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, aVar.cjx);
                C5489g.m14902d("ruomiz", "whatsAppStatus--thumb--为空");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("whatsAppStatus--thumb--");
                sb.append(jW.mo27010ZP());
                C5489g.m14902d("ruomiz", sb.toString());
                aVar.cju.setScaleType(ScaleType.CENTER_CROP);
                aVar.cju.setImageURI(Uri.parse(jW.mo27010ZP()));
                int width = jW.getWidth();
                int height = jW.getHeight();
                if (width == 0 || height == 0) {
                    height = 100;
                    width = 100;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("whatsAppStatus--thumbWidth--");
                sb2.append(width);
                sb2.append("--thumHeight--");
                sb2.append(height);
                C5489g.m14902d("ruomiz", sb2.toString());
                m14670b(width, height, aVar.cjx);
            }
        }
    }

    /* renamed from: a */
    public void mo26972a(C5403a<C5399i> aVar) {
        this.cjp = aVar;
    }

    public int getItemCount() {
        if (this.cjS == null) {
            return 0;
        }
        return this.cjS.size();
    }

    public void setData(List<C5399i> list) {
        this.cjS = list;
        notifyDataSetChanged();
    }

    /* renamed from: w */
    public C5389a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C5389a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_view_download_item_complete, viewGroup, false));
    }
}
