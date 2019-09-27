package com.introvd.template.editor.export;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Rect;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.sns.SnsShareInfo.Builder;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.introvd.template.sns.VideoShareInfo;
import com.quvideo.sns.base.p228b.C4982c;
import java.util.List;

/* renamed from: com.introvd.template.editor.export.m */
public class C6263m extends Dialog {

    /* renamed from: Jn */
    private View f3503Jn;
    /* access modifiers changed from: private */
    public C6267a cQA;
    private RecyclerView cQy = ((RecyclerView) this.f3503Jn.findViewById(R.id.share_btn_list));
    private ImageView cQz = ((ImageView) this.f3503Jn.findViewById(R.id.btn_cancel));

    /* renamed from: com.introvd.template.editor.export.m$a */
    public interface C6267a {
        /* renamed from: a */
        void mo29088a(MyResolveInfo myResolveInfo);

        void alL();
    }

    /* renamed from: com.introvd.template.editor.export.m$b */
    class C6268b extends C4417b<MyResolveInfo> {
        C6268b() {
        }

        public boolean isSupportFooterItem() {
            return false;
        }

        public boolean isSupportHeaderItem() {
            return false;
        }

        public void onBindFooterViewHolder(C1034u uVar, int i) {
        }

        public void onBindHeaderViewHolder(C1034u uVar, int i) {
        }

        public void onBindItemViewHolder(C1034u uVar, int i) {
            ImageView imageView = (ImageView) uVar.itemView;
            final MyResolveInfo myResolveInfo = (MyResolveInfo) getListItem(i);
            if (myResolveInfo != null) {
                imageView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        VideoShareInfo videoShareInfo = new VideoShareInfo();
                        videoShareInfo.strPageUrl = "https://j8ef.app.link/do1ZOvOVLB";
                        videoShareInfo.strThumbUrl = "https://hybrid.xiaoying.tv/web/vivavideo_logo.jpg";
                        videoShareInfo.strThumbPath = "https://hybrid.xiaoying.tv/web/vivavideo_logo.jpg";
                        videoShareInfo.strTitle = C6263m.this.getContext().getString(R.string.xiaoying_str_com_share_activity_title_notrans);
                        videoShareInfo.strDesc = C6263m.this.getContext().getString(R.string.xiaoying_str_com_share_activity_title_notrans);
                        SnsShareManager.shareLink((Activity) C6263m.this.getContext(), myResolveInfo.snsType, new Builder().strTitle(videoShareInfo.strTitle).strDesc(videoShareInfo.strDesc).strImgUrl(videoShareInfo.strThumbUrl).strLinkUrl(videoShareInfo.strPageUrl).snsShareListener(new C4982c() {
                            public void onHandleIntentShare(int i) {
                            }

                            public void onShareCanceled(int i) {
                            }

                            public void onShareFailed(int i, int i2, String str) {
                            }

                            public void onShareSuccess(int i) {
                                C6253g.m17916no(2);
                            }
                        }).build(), "unlock_share");
                        C6263m.this.dismiss();
                        UserBehaviorUtilsV5.onEventHDFreeExportDialogAction(C6263m.this.getContext().getApplicationContext(), "share");
                        if (C6263m.this.cQA != null) {
                            C6263m.this.cQA.mo29088a(myResolveInfo);
                        }
                    }
                });
            }
        }

        public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
            return null;
        }

        public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
            return null;
        }

        public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setLayoutParams(new LayoutParams(-2, -2));
            return new C4419b(imageView);
        }
    }

    public C6263m(Activity activity) {
        super(activity, R.style.xiaoying_style_com_dialog);
        this.f3503Jn = LayoutInflater.from(activity).inflate(R.layout.editor_share_dialog2_layout, null);
        this.cQz.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C6263m.this.dismiss();
                C6263m.this.amc();
            }
        });
        aaJ();
        setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                C6263m.this.amc();
            }
        });
    }

    /* renamed from: a */
    public static void m17940a(Activity activity, C6267a aVar) {
        C6263m mVar = new C6263m(activity);
        mVar.mo29197a(aVar);
        mVar.show();
    }

    private void aaJ() {
        List foreignSNSInfo = SnsShareTypeUtil.getForeignSNSInfo(getContext());
        C6268b bVar = new C6268b();
        bVar.setDataList(foreignSNSInfo);
        this.cQy.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.cQy.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                if (recyclerView.mo7745aM(view) == 0) {
                    rect.left = C4583d.m11670O(C6263m.this.getContext(), 22);
                }
                rect.right = C4583d.m11670O(C6263m.this.getContext(), 21);
            }
        });
        this.cQy.setAdapter(bVar);
    }

    /* access modifiers changed from: private */
    public void amc() {
        UserBehaviorUtilsV5.onEventHDFreeExportDialogAction(getContext().getApplicationContext(), "cancel");
        if (this.cQA != null) {
            this.cQA.alL();
        }
    }

    /* renamed from: a */
    public void mo29197a(C6267a aVar) {
        this.cQA = aVar;
    }

    public void show() {
        if (this.f3503Jn != null) {
            setContentView(this.f3503Jn);
        }
        super.show();
    }
}
