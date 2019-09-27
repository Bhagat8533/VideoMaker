package com.introvd.template.app.school.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.homepage.creation.C3949b;
import com.introvd.template.app.homepage.creation.SubToolViewTabWidget;
import com.introvd.template.app.manager.C4047b;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.app.school.C4205m;
import com.introvd.template.app.utils.C4407f;
import com.introvd.template.common.Constants;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

public class CreationEditorSubToolLayout extends RelativeLayout {

    /* renamed from: VC */
    private C1022l f3394VC = new C1022l() {
        /* renamed from: k */
        private float m10690k(RecyclerView recyclerView) {
            int i = C4580b.m11666qi() ? -1 : 1;
            if (!recyclerView.canScrollHorizontally(-i)) {
                return 0.0f;
            }
            if (!recyclerView.canScrollHorizontally(i)) {
                return 100.0f;
            }
            if (recyclerView.getLayoutManager() == null) {
                return 0.0f;
            }
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            View childAt = recyclerView.getChildAt(0);
            if (childAt == null) {
                return 0.0f;
            }
            return (CreationEditorSubToolLayout.this.brN.getStepProgress() * ((float) findFirstVisibleItemPosition)) + ((CreationEditorSubToolLayout.this.brN.getStepProgress() * Math.abs(C4580b.m11666qi() ? (float) (childAt.getRight() - recyclerView.getRight()) : (float) childAt.getLeft())) / ((float) childAt.getMeasuredWidth()));
        }

        /* renamed from: a */
        public void mo8095a(RecyclerView recyclerView, int i, int i2) {
            CreationEditorSubToolLayout.this.brN.setProgress(m10690k(recyclerView));
        }

        /* renamed from: d */
        public void mo8096d(RecyclerView recyclerView, int i) {
            super.mo8096d(recyclerView, i);
            if (i == 0) {
                CreationEditorSubToolLayout.this.brN.setProgress(m10690k(recyclerView));
            }
        }
    };

    /* renamed from: Vu */
    private RecyclerView f3395Vu;
    /* access modifiers changed from: private */
    public SubToolViewTabWidget brN;
    /* access modifiers changed from: private */
    public C3949b brO;

    /* renamed from: com.introvd.template.app.school.view.CreationEditorSubToolLayout$a */
    private class C4262a extends C1034u {
        DynamicLoadingImageView bkv;
        TextView brQ;

        C4262a(View view) {
            super(view);
            this.bkv = (DynamicLoadingImageView) view.findViewById(R.id.sub_btn_icon);
            this.brQ = (TextView) view.findViewById(R.id.sub_btn_text);
            CreationEditorSubToolLayout.m10687b(this.brQ);
        }
    }

    /* renamed from: com.introvd.template.app.school.view.CreationEditorSubToolLayout$b */
    private class C4263b extends C4417b<ModeItemInfo> {
        private C4263b() {
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
            final ModeItemInfo modeItemInfo = (ModeItemInfo) getListItem(i);
            if (modeItemInfo != null) {
                C4262a aVar = (C4262a) uVar;
                CreationEditorSubToolLayout.m10687b(aVar.brQ);
                if (!TextUtils.isEmpty(modeItemInfo.itemName)) {
                    aVar.brQ.setText(modeItemInfo.itemName.trim());
                    if (!TextUtils.isEmpty(modeItemInfo.textColor)) {
                        C4407f.m11131a(aVar.brQ, modeItemInfo.textColor);
                    } else {
                        aVar.brQ.setTextColor(aVar.brQ.getContext().getResources().getColor(R.color.color_666666));
                    }
                } else if (modeItemInfo.itemNameBackupRes > 0) {
                    aVar.brQ.setText(modeItemInfo.itemNameBackupRes);
                }
                if (!TextUtils.isEmpty(modeItemInfo.itemImgUrl)) {
                    aVar.bkv.setImageURI(modeItemInfo.itemImgUrl);
                } else if (modeItemInfo.itemImgBackupRes != null) {
                    aVar.bkv.setImage(((Integer) modeItemInfo.itemImgBackupRes).intValue());
                }
                Context context = CreationEditorSubToolLayout.this.getContext();
                String str = modeItemInfo.itemName;
                StringBuilder sb = new StringBuilder();
                sb.append(modeItemInfo.rawId);
                sb.append("");
                UserBehaviorABTestUtils.onEventShowHomeSecondary(context, i, str, sb.toString());
                C2579b.m7399a(new C2582a<View>() {
                    public void onClick(View view) {
                        C4205m.m10502r(modeItemInfo.itemName, modeItemInfo.itemNameBackupRes);
                        boolean b = CreationEditorSubToolLayout.this.brO != null ? CreationEditorSubToolLayout.this.brO.mo23508b(modeItemInfo) : false;
                        UserBehaviorUtilsV5.onEventHomeEditV5(CreationEditorSubToolLayout.this.getContext(), BizAppTodoActionManager.getInstance().getTodoCodeName(modeItemInfo.todoCode), modeItemInfo.itemName);
                        if (!b) {
                            C4047b.m10067a((Activity) CreationEditorSubToolLayout.this.getContext(), modeItemInfo);
                        }
                    }
                }, aVar.itemView);
            }
        }

        public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
            return null;
        }

        public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
            return null;
        }

        public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(CreationEditorSubToolLayout.this.getContext()).inflate(R.layout.app_view_creation_editor_sub_tool_list_item, null);
            inflate.setLayoutParams(new LayoutParams((int) (((float) (Constants.getScreenSize().width - C4583d.m11670O(CreationEditorSubToolLayout.this.getContext(), 15))) / 4.5f), C4583d.m11673ii(50)));
            return new C4262a(inflate);
        }
    }

    public CreationEditorSubToolLayout(Context context) {
        super(context);
        m10684Ll();
    }

    public CreationEditorSubToolLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10684Ll();
    }

    public CreationEditorSubToolLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10684Ll();
    }

    /* renamed from: Ll */
    private void m10684Ll() {
        this.f3395Vu = new RecyclerView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C4583d.m11673ii(86));
        layoutParams.setMargins(C4583d.m11670O(getContext(), 15), 0, 0, 0);
        addView(this.f3395Vu, layoutParams);
        this.f3395Vu.setId(R.id.view_pager);
        this.f3395Vu.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.brN = new SubToolViewTabWidget(getContext());
        this.brN.setFocusColor(Color.parseColor("#ff6333"));
        this.brN.setUnFocusColor(Color.parseColor("#f5f5fa"));
        this.brN.setThumbCornerRadius(C4583d.m11673ii(2));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(C4583d.m11673ii(40), C4583d.m11673ii(2));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, this.f3395Vu.getId());
        layoutParams2.bottomMargin = C4583d.m11673ii(16);
        addView(this.brN, layoutParams2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m10687b(TextView textView) {
        if (textView != null) {
            if (Constants.getScreenSize().width * Constants.getScreenSize().height <= 409920) {
                textView.setTextSize(1, 10.0f);
            } else if (Constants.getScreenSize().width * Constants.getScreenSize().height < 921600) {
                textView.setTextSize(1, 12.0f);
            }
        }
    }

    /* renamed from: W */
    public void mo24261W(List<ModeItemInfo> list) {
        C4263b bVar = new C4263b();
        bVar.setDataList(list);
        this.f3395Vu.setAdapter(bVar);
        this.f3395Vu.mo7737a(this.f3394VC);
        if (((list.size() - 1) / 4) + 1 > 1) {
            this.brN.mo23501gN(list.size());
            this.brN.setVisibility(0);
            return;
        }
        this.brN.setVisibility(8);
    }

    public void setSubToolItemViewListener(C3949b bVar) {
        this.brO = bVar;
    }
}
