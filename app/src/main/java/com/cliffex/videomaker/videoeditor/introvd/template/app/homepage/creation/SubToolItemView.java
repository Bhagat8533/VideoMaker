package com.introvd.template.app.homepage.creation;

import android.app.Activity;
import android.content.Context;
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
import com.introvd.template.app.manager.C4047b;
import com.introvd.template.app.p199v5.common.C4417b;
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

public class SubToolItemView extends RelativeLayout {

    /* renamed from: VC */
    private C1022l f3380VC = new C1022l() {
        /* renamed from: k */
        private float m9733k(RecyclerView recyclerView) {
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
            return (SubToolItemView.this.brN.getStepProgress() * ((float) findFirstVisibleItemPosition)) + ((SubToolItemView.this.brN.getStepProgress() * Math.abs(C4580b.m11666qi() ? (float) (childAt.getRight() - recyclerView.getRight()) : (float) childAt.getLeft())) / ((float) childAt.getMeasuredWidth()));
        }

        /* renamed from: a */
        public void mo8095a(RecyclerView recyclerView, int i, int i2) {
            SubToolItemView.this.brN.setProgress(m9733k(recyclerView));
        }

        /* renamed from: d */
        public void mo8096d(RecyclerView recyclerView, int i) {
            super.mo8096d(recyclerView, i);
            if (i == 0) {
                SubToolItemView.this.brN.setProgress(m9733k(recyclerView));
            }
        }
    };

    /* renamed from: Vu */
    private RecyclerView f3381Vu;
    /* access modifiers changed from: private */
    public SubToolViewTabWidget brN;
    /* access modifiers changed from: private */
    public C3949b brO;

    /* renamed from: com.introvd.template.app.homepage.creation.SubToolItemView$a */
    private class C3945a extends C1034u {
        DynamicLoadingImageView bkv;
        TextView brQ;

        public C3945a(View view) {
            super(view);
            this.bkv = (DynamicLoadingImageView) view.findViewById(R.id.sub_btn_icon);
            this.brQ = (TextView) view.findViewById(R.id.sub_btn_text);
            SubToolItemView.m9730b(this.brQ);
        }
    }

    /* renamed from: com.introvd.template.app.homepage.creation.SubToolItemView$b */
    private class C3946b extends C4417b<ModeItemInfo> {
        private C3946b() {
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
                C3945a aVar = (C3945a) uVar;
                SubToolItemView.m9730b(aVar.brQ);
                if (!TextUtils.isEmpty(modeItemInfo.itemName)) {
                    aVar.brQ.setText(modeItemInfo.itemName.trim());
                    if (!TextUtils.isEmpty(modeItemInfo.textColor)) {
                        C4407f.m11131a(aVar.brQ, modeItemInfo.textColor);
                    } else {
                        aVar.brQ.setTextColor(aVar.brQ.getContext().getResources().getColor(R.color.color_333333));
                    }
                } else if (modeItemInfo.itemNameBackupRes > 0) {
                    aVar.brQ.setText(modeItemInfo.itemNameBackupRes);
                }
                if (!TextUtils.isEmpty(modeItemInfo.itemImgUrl)) {
                    aVar.bkv.setImageURI(modeItemInfo.itemImgUrl);
                } else if (modeItemInfo.itemImgBackupRes != null) {
                    aVar.bkv.setImage(((Integer) modeItemInfo.itemImgBackupRes).intValue());
                }
                Context context = SubToolItemView.this.getContext();
                String str = modeItemInfo.itemName;
                StringBuilder sb = new StringBuilder();
                sb.append(modeItemInfo.rawId);
                sb.append("");
                UserBehaviorABTestUtils.onEventShowHomeSecondary(context, i, str, sb.toString());
                C2579b.m7399a(new C2582a<View>() {
                    public void onClick(View view) {
                        boolean b = SubToolItemView.this.brO != null ? SubToolItemView.this.brO.mo23508b(modeItemInfo) : false;
                        UserBehaviorUtilsV5.onEventHomeEditV5(SubToolItemView.this.getContext(), BizAppTodoActionManager.getInstance().getTodoCodeName(modeItemInfo.todoCode), modeItemInfo.itemName);
                        if (!b) {
                            C4047b.m10067a((Activity) SubToolItemView.this.getContext(), modeItemInfo);
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
            View inflate = LayoutInflater.from(SubToolItemView.this.getContext()).inflate(R.layout.sub_tool_list_item, null);
            inflate.setLayoutParams(new LayoutParams((int) (((float) (Constants.getScreenSize().width - C4583d.m11670O(SubToolItemView.this.getContext(), 30))) / 4.5f), C3948a.m9737co(SubToolItemView.this.getContext())));
            return new C3945a(inflate);
        }
    }

    public SubToolItemView(Context context) {
        super(context);
        m9727Ll();
    }

    public SubToolItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9727Ll();
    }

    public SubToolItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9727Ll();
    }

    /* renamed from: Ll */
    private void m9727Ll() {
        this.f3381Vu = new RecyclerView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C3948a.m9737co(getContext()));
        layoutParams.setMargins(C4583d.m11670O(getContext(), 15), 0, C4583d.m11670O(getContext(), 15), 0);
        addView(this.f3381Vu, layoutParams);
        try {
            this.f3381Vu.setBackgroundResource(R.drawable.sub_tool_view_bg);
        } catch (Exception unused) {
        }
        this.f3381Vu.setId(R.id.view_pager);
        this.f3381Vu.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.brN = new SubToolViewTabWidget(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(C4583d.m11670O(getContext(), 40), C4583d.m11670O(getContext(), 2));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, this.f3381Vu.getId());
        layoutParams2.bottomMargin = C4583d.m11670O(getContext(), 6);
        addView(this.brN, layoutParams2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m9730b(TextView textView) {
        if (textView != null) {
            if (Constants.getScreenSize().width * Constants.getScreenSize().height <= 409920) {
                textView.setTextSize(1, 10.0f);
            } else if (Constants.getScreenSize().width * Constants.getScreenSize().height < 921600) {
                textView.setTextSize(1, 12.0f);
            }
        }
    }

    /* renamed from: W */
    public void mo23498W(List<ModeItemInfo> list) {
        C3946b bVar = new C3946b();
        bVar.setDataList(list);
        this.f3381Vu.setAdapter(bVar);
        this.f3381Vu.mo7737a(this.f3380VC);
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
