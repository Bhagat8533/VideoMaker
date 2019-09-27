package com.introvd.template.editor.effects.p257fx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p409g.C8762d;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.editor.effects.fx.c */
public class C6141c extends C1008a<C6150h> {
    private static final int cLj = R.layout.editor_effect_fx_recycler_item_category_group_detail;
    /* access modifiers changed from: private */
    public C6138a<C6151i> cLl;
    private List<C6151i> cLp;
    /* access modifiers changed from: private */
    @SuppressLint({"UseSparseArrays"})
    public Map<Long, C6151i> cLq = new HashMap();
    /* access modifiers changed from: private */
    public C6151i cLr;
    /* access modifiers changed from: private */
    public C6151i cLs;
    private C6144a cLt;
    private Context context;
    /* access modifiers changed from: private */
    public C8703d czd;
    private String sceneCode;

    /* renamed from: com.introvd.template.editor.effects.fx.c$a */
    static abstract class C6144a {
        C6144a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ay */
        public abstract C6151i mo28886ay(long j);
    }

    /* renamed from: com.introvd.template.editor.effects.fx.c$b */
    static abstract class C6145b {
        C6145b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: mM */
        public final TextView mo28917mM(int i) {
            View mN = mo28885mN(i);
            if (mN == null) {
                return null;
            }
            return (TextView) mN.findViewById(R.id.tv_download_process);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: mN */
        public abstract View mo28885mN(int i);
    }

    C6141c(Context context2, final C6145b bVar, C6144a aVar) {
        this.context = context2;
        this.cLt = aVar;
        this.czd = new C8703d(context2, new C8708f() {
            /* renamed from: b */
            public void mo24951b(Long l) {
                C6151i a = C6141c.this.m17519ax(l.longValue());
                if (a != null) {
                    EffectInfoModel akN = a.akN();
                    if (akN != null) {
                        akN.setDownloading(true);
                    }
                }
            }

            /* renamed from: c */
            public void mo24952c(long j, int i) {
                C6151i a = C6141c.this.m17519ax(j);
                if (a != null && i >= a.akP()) {
                    a.mo28951mU(i);
                    C6141c.this.m17523c(bVar.mo28917mM(a.getPosition()), a.akP());
                    C6141c.this.m17512P(a.getPosition(), false);
                }
            }

            /* renamed from: c */
            public void mo24953c(Long l) {
                C6151i a = C6141c.this.m17519ax(l.longValue());
                C6141c.this.cLq.remove(l);
                if (a != null) {
                    EffectInfoModel akN = a.akN();
                    if (akN != null) {
                        akN.setDownloading(false);
                        akN.setDownloaded(true);
                        akN.setbNeedDownload(false);
                    }
                    C6141c.this.cLs = C6141c.this.cLr;
                    C6141c.this.cLr = a;
                    C6141c.this.m17512P(a.getPosition(), true);
                    if (C6141c.this.cLl != null) {
                        C6141c.this.cLl.mo28880S(a);
                    }
                }
            }

            /* renamed from: o */
            public void mo27389o(Long l) {
            }

            /* renamed from: p */
            public void mo27390p(Long l) {
                C6151i iVar = (C6151i) C6141c.this.cLq.get(l);
                if (iVar != null) {
                    EffectInfoModel akN = iVar.akN();
                    if (akN != null) {
                        akN.setDownloading(false);
                        akN.setbNeedDownload(true);
                        akN.setDownloaded(false);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m17512P(int i, boolean z) {
        if (this.cLp != null) {
            if (this.cLs != null) {
                notifyItemChanged(this.cLs.getPosition(), "");
            }
            if (z && this.cLr == null && this.cLp.size() > i && i >= 0) {
                this.cLr = (C6151i) this.cLp.get(i);
            }
            notifyItemChanged(i, "");
        }
    }

    /* renamed from: a */
    private void m17518a(C6150h hVar, C6151i iVar) {
        EffectInfoModel akN = iVar.akN();
        long j = akN.mTemplateId;
        View n = hVar.mo28942n(R.id.iv_download_flag);
        TextView textView = (TextView) hVar.mo28942n(R.id.tv_download_process);
        if (akN.isDownloading()) {
            n.setVisibility(4);
            textView.setVisibility(0);
            m17523c(textView, iVar.akP());
        } else if (akN.isbNeedDownload()) {
            n.setVisibility(0);
            textView.setVisibility(8);
        } else {
            n.setVisibility(4);
            textView.setVisibility(8);
        }
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) hVar.mo28942n(R.id.iv_thumb);
        if (this.cLr != null) {
            EffectInfoModel akN2 = this.cLr.akN();
            if (akN.isbNeedDownload() || akN2.mTemplateId != j) {
                dynamicLoadingImageView.setBackgroundResource(R.color.transparent);
            } else {
                dynamicLoadingImageView.setBackgroundResource(R.drawable.editor_shape_fx_chosen_state);
            }
        } else {
            dynamicLoadingImageView.setBackgroundResource(R.color.transparent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ax */
    public C6151i m17519ax(long j) {
        C6151i iVar = (C6151i) this.cLq.get(Long.valueOf(j));
        if (iVar == null) {
            iVar = this.cLt.mo28886ay(j);
            if (iVar != null && !TextUtils.isEmpty(this.sceneCode) && this.sceneCode.equals(iVar.akw())) {
                this.cLq.put(Long.valueOf(j), iVar);
            }
        }
        return iVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17523c(TextView textView, int i) {
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("%");
            textView.setText(sb.toString());
        }
    }

    /* renamed from: G */
    public C6150h onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6150h(LayoutInflater.from(this.context).inflate(cLj, viewGroup, false));
    }

    /* renamed from: a */
    public int mo28909a(C6151i iVar) {
        int i = -1;
        if (iVar == null || iVar.akN() == null || TextUtils.isEmpty(iVar.akN().mPath) || getItemCount() <= 0) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= getItemCount()) {
                break;
            }
            C6151i iVar2 = (C6151i) this.cLp.get(i2);
            if (iVar2 != null && iVar2.akN() != null && iVar.akN().mPath.equals(iVar2.akN().mPath)) {
                i = i2;
                break;
            }
            i2++;
        }
        return i;
    }

    /* renamed from: a */
    public void mo28910a(C6138a<C6151i> aVar) {
        this.cLl = aVar;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: a */
    public void onBindViewHolder(C6150h hVar, int i) {
        final C6151i iVar = (C6151i) this.cLp.get(i);
        iVar.setPosition(i);
        m17518a(hVar, iVar);
        final EffectInfoModel akN = iVar.akN();
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) hVar.mo28942n(R.id.iv_thumb);
        if (!TextUtils.isEmpty(iVar.akO())) {
            ImageLoader.loadImage(iVar.akO(), dynamicLoadingImageView);
        } else {
            String templateExternalFile = C8762d.aMt().getTemplateExternalFile(akN.mTemplateId, 0, 3);
            if (FileUtils.isFileExisted(templateExternalFile)) {
                ImageLoader.loadImage(templateExternalFile, dynamicLoadingImageView);
            } else if (iVar.getThumbnail() != null) {
                dynamicLoadingImageView.setImageBitmap(iVar.getThumbnail());
            }
        }
        final View n = hVar.mo28942n(R.id.iv_download_flag);
        hVar.akM().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C6141c.this.cLs = C6141c.this.cLr;
                int position = iVar.getPosition();
                C6141c.this.cLr = iVar;
                if (!akN.isDownloading()) {
                    if (akN.isbNeedDownload()) {
                        C6141c.this.cLq.put(Long.valueOf(akN.mTemplateId), iVar);
                        C6141c.this.czd.mo35077a(akN, "fx");
                        n.setVisibility(8);
                        C6141c.this.notifyItemChanged(position, "");
                        return;
                    }
                    if (C6141c.this.cLr != null) {
                        C6141c.this.m17512P(C6141c.this.cLr.getPosition(), true);
                    }
                    if (C6141c.this.cLl != null) {
                        C6141c.this.cLl.mo28880S(iVar);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void onBindViewHolder(C6150h hVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(hVar, i);
            return;
        }
        C6151i iVar = (C6151i) this.cLp.get(i);
        iVar.setPosition(i);
        m17518a(hVar, iVar);
    }

    /* renamed from: a */
    public void mo28913a(C6151i iVar, boolean z) {
        this.cLr = iVar;
        if (z) {
            notifyDataSetChanged();
        }
    }

    /* renamed from: c */
    public void mo28914c(String str, List<C6151i> list) {
        this.sceneCode = str;
        if (list != null && !list.isEmpty()) {
            if (this.cLp == null) {
                this.cLp = new ArrayList(list);
            } else {
                this.cLp.clear();
                this.cLp.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void destroy() {
        if (this.czd != null) {
            this.czd.mo35076VD();
        }
    }

    public int getItemCount() {
        if (this.cLp == null) {
            return 0;
        }
        return this.cLp.size();
    }
}
