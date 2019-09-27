package com.introvd.template.component.videofetcher.p238b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.C5355a;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p237a.C5356a;
import com.introvd.template.component.videofetcher.p237a.C5357b;
import com.introvd.template.component.videofetcher.p239c.C5393c;
import com.introvd.template.component.videofetcher.p239c.C5395e;
import com.introvd.template.component.videofetcher.utils.C5486d;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.utils.C5492i;
import com.introvd.template.component.videofetcher.utils.C5498l;
import com.introvd.template.component.videofetcher.view.C5516i;
import com.introvd.template.component.videofetcher.view.RoundTransparencyProgressView;
import com.introvd.template.component.videofetcher.view.RoundTransparencyProgressView.C5500a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.p051a.p053b.C1487a;

/* renamed from: com.introvd.template.component.videofetcher.b.e */
public class C5381e extends C1008a<C5387a> {
    private final Activity activity;
    private final int cjK;
    private List<C5393c> cjh = new ArrayList();
    /* access modifiers changed from: private */
    public final Context context;

    /* renamed from: com.introvd.template.component.videofetcher.b.e$a */
    protected class C5387a extends C1034u {
        ImageView cjO;
        RoundTransparencyProgressView cjP;
        ImageView cjQ;
        TextView cjR;
        ProgressBar progressBar;

        public C5387a(View view) {
            super(view);
            this.cjO = (ImageView) view.findViewById(R.id.imgview_thumbnail);
            this.cjP = (RoundTransparencyProgressView) view.findViewById(R.id.round_imag_progress);
            this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
            this.cjQ = (ImageView) view.findViewById(R.id.btn_cancel);
            this.cjR = (TextView) view.findViewById(R.id.textview_hint);
        }
    }

    public C5381e(Activity activity2, Context context2) {
        this.activity = activity2;
        this.context = context2.getApplicationContext();
        this.cjK = C5486d.m14894O(context2, 80);
    }

    /* renamed from: a */
    private void m14649a(TextView textView, C5393c cVar) {
        String af = C5356a.m14585af((float) cVar.progress);
        if (cVar.state == 3) {
            textView.setText(C5356a.m14584U(this.context, cVar.state));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C5356a.m14584U(this.context, cVar.state));
        sb.append("...");
        sb.append(af);
        sb.append("%");
        textView.setText(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14652a(C5393c cVar) {
        if (cVar != null) {
            C5357b.m14586ZJ().mo26928m(this.context, cVar.name, cVar.videoUrl);
            mo26963e(cVar.name, 1, "");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14653a(final C5393c cVar, int i) {
        final C5516i iVar = new C5516i(this.activity);
        iVar.mo27235ki(R.string.video_fetcher_str_ask_cancel_share_tip);
        iVar.mo27233b(R.string.video_fetcher_str_no, new OnClickListener() {
            public void onClick(View view) {
            }
        });
        iVar.mo27232a(R.string.video_fetcher_str_yes, new OnClickListener() {
            public void onClick(View view) {
                C5357b.m14586ZJ().mo26926d(C5381e.this.context, cVar.name, cVar.videoUrl, cVar.cka);
                C5381e.this.m14659d(cVar);
                iVar.dismiss();
            }
        });
        iVar.show();
    }

    /* renamed from: a */
    private void m14654a(C5393c cVar, C5387a aVar) {
        int i = cVar.state;
        if (i == 0 || i == 4) {
            aVar.cjP.mo27189dF(false);
        } else {
            aVar.cjP.stop(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14656b(C5393c cVar) {
        if (cVar.state != 0) {
            C5357b.m14586ZJ().mo26927e(this.context, cVar.name, cVar.videoUrl, C5355a.ciX);
            mo26963e(cVar.name, 0, "");
        }
    }

    /* renamed from: c */
    private void m14658c(C5393c cVar) {
        m14659d(cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m14659d(C5393c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("download---removeDataItem--name--");
        sb.append(this.cjh.size());
        C5489g.m14902d("ruomiz", sb.toString());
        if (this.cjh != null && !this.cjh.isEmpty() && this.cjh.contains(cVar)) {
            Iterator it = this.cjh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C5393c cVar2 = (C5393c) it.next();
                if (cVar2.name.equals(cVar.name)) {
                    if (this.cjh.contains(cVar)) {
                        this.cjh.remove(cVar2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("download---remove--name--");
                        sb2.append(this.cjh.size());
                        C5489g.m14902d("ruomiz", sb2.toString());
                        if (this.cjh != null && this.cjh.size() == 0) {
                            C10021c.aZH().mo38493aB(new C5395e(0, "", ""));
                        }
                    }
                }
            }
            C1487a.aUa().mo10058o(new Runnable() {
                public void run() {
                    C5381e.this.notifyDataSetChanged();
                }
            });
        }
    }

    /* renamed from: jV */
    private C5393c m14660jV(int i) {
        if (this.cjh == null || i >= this.cjh.size()) {
            return null;
        }
        return (C5393c) this.cjh.get(i);
    }

    /* renamed from: a */
    public void onBindViewHolder(C5387a aVar, final int i) {
        aVar.itemView.setTag(Integer.valueOf(i));
        final C5393c jV = m14660jV(i);
        if (jV != null) {
            if (jV.progress == 100) {
                aVar.cjP.setVisibility(8);
                aVar.progressBar.setVisibility(8);
                aVar.cjR.setVisibility(8);
                m14658c(jV);
            } else {
                aVar.cjP.setVisibility(0);
                aVar.progressBar.setVisibility(0);
                aVar.cjR.setVisibility(0);
                aVar.progressBar.setProgress(jV.progress);
                aVar.cjP.setmProgress(jV.progress);
                String fR = C5492i.aaE().mo27182fR(jV.name);
                if (TextUtils.isEmpty(fR) || !C5488f.m14899fN(fR)) {
                    Bitmap fQ = C5492i.aaE().mo27181fQ(jV.name);
                    if (fQ != null) {
                        aVar.cjO.setScaleType(ScaleType.CENTER_CROP);
                        aVar.cjO.setImageBitmap(fQ);
                    } else {
                        aVar.cjO.setScaleType(ScaleType.CENTER_INSIDE);
                        aVar.cjO.setImageResource(R.drawable.fetcher_icon_download_seat);
                    }
                } else {
                    Bitmap decodeFile = BitmapFactory.decodeFile(fR);
                    if (decodeFile != null) {
                        aVar.cjO.setImageBitmap(decodeFile);
                        aVar.cjO.setScaleType(ScaleType.CENTER_CROP);
                    } else {
                        aVar.cjO.setScaleType(ScaleType.CENTER_INSIDE);
                        aVar.cjO.setImageResource(R.drawable.fetcher_icon_download_seat);
                    }
                }
                m14654a(jV, aVar);
                m14649a(aVar.cjR, jV);
                aVar.cjQ.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C5381e.this.m14653a(jV, i);
                    }
                });
            }
            aVar.cjP.setStateProgressListner(new C5500a() {
                /* renamed from: ZL */
                public boolean mo26966ZL() {
                    if (jV != null) {
                        C5381e.this.m14656b(jV);
                        return true;
                    }
                    C5498l.show(C5381e.this.context, R.string.video_fetcher_str_ve_clip_file_lost_tip, 1);
                    return false;
                }

                /* renamed from: ZM */
                public void mo26967ZM() {
                    C5381e.this.m14652a(jV);
                }
            });
        }
    }

    /* renamed from: b */
    public void mo26961b(String str, int i, int i2) {
        for (C5393c cVar : this.cjh) {
            if (cVar.name.equals(str)) {
                cVar.progress = i;
                cVar.state = i2;
                int indexOf = this.cjh.indexOf(cVar);
                if (indexOf < this.cjh.size()) {
                    notifyItemChanged(indexOf);
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: e */
    public void mo26962e(C5393c cVar) {
        if (this.cjh != null && !this.cjh.contains(cVar)) {
            C5489g.m14902d("ruomiz", "TASKmanager ---add");
            this.cjh.add(cVar);
            notifyDataSetChanged();
        }
    }

    /* renamed from: e */
    public void mo26963e(String str, int i, String str2) {
        if (i == 4) {
            Iterator it = this.cjh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C5393c cVar = (C5393c) it.next();
                if (cVar.state == 4) {
                    this.cjh.remove(cVar);
                    break;
                }
            }
        }
        Iterator it2 = this.cjh.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            C5393c cVar2 = (C5393c) it2.next();
            if (cVar2.name.equals(str)) {
                cVar2.state = i;
                break;
            }
        }
        Collections.sort(this.cjh);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.cjh == null) {
            return 0;
        }
        return this.cjh.size();
    }

    /* renamed from: v */
    public C5387a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_view_download_item_downloading, viewGroup, false);
        inflate.setLayoutParams(new LayoutParams(-1, this.cjK));
        return new C5387a(inflate);
    }
}
