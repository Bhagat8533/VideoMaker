package com.introvd.template.app.homepage.creation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.manager.C4047b;
import com.introvd.template.app.utils.C4407f;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.xyui.ripple.C9175b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

public class MainToolItemView extends LinearLayout {
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof ModeItemInfo) && !C4580b.m11632Sf()) {
                ModeItemInfo modeItemInfo = (ModeItemInfo) view.getTag();
                if (modeItemInfo != null) {
                    UserBehaviorUtilsV5.onEventHomeEditV5(MainToolItemView.this.getContext(), BizAppTodoActionManager.getInstance().getTodoCodeName(modeItemInfo.todoCode), modeItemInfo.itemName);
                    if (!(MainToolItemView.this.brL != null ? MainToolItemView.this.brL.mo23508b(modeItemInfo) : false)) {
                        if (modeItemInfo.todoCode == 408) {
                            UtilsPrefs with = UtilsPrefs.with(MainToolItemView.this.getContext(), AppRouter.VIVA_APP_PREF_FILENAME, true);
                            if (!with.readBoolean("key_show_main_tool_mv_tip", false)) {
                                with.writeBoolean("key_show_main_tool_mv_tip", true);
                                UserBehaviorABTestUtils.homeFunctionTipClick(MainToolItemView.this.getContext(), "Mv_tip");
                                if (MainToolItemView.this.brL != null) {
                                    MainToolItemView.this.brL.mo23507LF();
                                }
                                MainToolItemView.this.brH.setImageDrawable(null);
                                MainToolItemView.this.brH.setVisibility(8);
                                MainToolItemView.this.brI.setImageDrawable(null);
                                MainToolItemView.this.brI.setVisibility(8);
                            }
                        } else if (modeItemInfo.todoCode == 401) {
                            UtilsPrefs with2 = UtilsPrefs.with(MainToolItemView.this.getContext(), AppRouter.VIVA_APP_PREF_FILENAME, true);
                            if (!with2.readBoolean("key_show_main_tool_editor_tip", false)) {
                                with2.writeBoolean("key_show_main_tool_editor_tip", true);
                                UserBehaviorABTestUtils.homeFunctionTipClick(MainToolItemView.this.getContext(), "edit_tip");
                                if (MainToolItemView.this.brL != null) {
                                    MainToolItemView.this.brL.mo23507LF();
                                }
                                MainToolItemView.this.brH.setImageDrawable(null);
                                MainToolItemView.this.brH.setVisibility(8);
                                MainToolItemView.this.brI.setImageDrawable(null);
                                MainToolItemView.this.brI.setVisibility(8);
                            }
                        }
                        C4047b.m10067a((Activity) MainToolItemView.this.getContext(), modeItemInfo);
                    }
                }
            }
        }
    };
    private RelativeLayout brD;
    private RelativeLayout brE;
    private DynamicLoadingImageView brF;
    private DynamicLoadingImageView brG;
    /* access modifiers changed from: private */
    public DynamicLoadingImageView brH;
    /* access modifiers changed from: private */
    public DynamicLoadingImageView brI;
    private TextView brJ;
    private TextView brK;
    /* access modifiers changed from: private */
    public C3949b brL;

    public MainToolItemView(Context context) {
        super(context);
        m9717Iu();
    }

    public MainToolItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9717Iu();
    }

    public MainToolItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9717Iu();
    }

    /* renamed from: Iu */
    private void m9717Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.home_main_tool_item_view, this, true);
        findViewById(R.id.root_layout).getLayoutParams().height = C3948a.m9737co(getContext());
        this.brD = (RelativeLayout) findViewById(R.id.btn1);
        this.brE = (RelativeLayout) findViewById(R.id.btn2);
        this.brF = (DynamicLoadingImageView) findViewById(R.id.icon1);
        this.brG = (DynamicLoadingImageView) findViewById(R.id.icon2);
        this.brJ = (TextView) findViewById(R.id.textview1);
        this.brK = (TextView) findViewById(R.id.textview2);
        this.brH = (DynamicLoadingImageView) findViewById(R.id.shining_bg1);
        this.brI = (DynamicLoadingImageView) findViewById(R.id.shining_bg2);
    }

    /* renamed from: a */
    public static void m9719a(ModeItemInfo modeItemInfo, View view, int i) {
        int O = C4583d.m11670O(view.getContext(), 4);
        if (TextUtils.isEmpty(modeItemInfo.bgStartColor) && TextUtils.isEmpty(modeItemInfo.bgEndColor)) {
            view.setBackgroundDrawable(C9175b.m26701N(VivaBaseApplication.m8749FZ().getResources().getDrawable(i)));
        } else if (TextUtils.isEmpty(modeItemInfo.bgStartColor)) {
            view.setBackgroundDrawable(C9175b.m26706dU(Color.parseColor(modeItemInfo.bgEndColor), O));
        } else if (TextUtils.isEmpty(modeItemInfo.bgEndColor)) {
            view.setBackgroundDrawable(C9175b.m26706dU(Color.parseColor(modeItemInfo.bgStartColor), O));
        } else {
            new GradientDrawable(Orientation.TL_BR, new int[]{Color.parseColor(modeItemInfo.bgStartColor), Color.parseColor(modeItemInfo.bgEndColor)}).setCornerRadius((float) C4583d.m11670O(VivaBaseApplication.m8749FZ(), 4));
            view.setBackgroundDrawable(C9175b.m26706dU(Color.parseColor(modeItemInfo.bgStartColor), O));
        }
    }

    /* renamed from: a */
    public static void m9720a(ModeItemInfo modeItemInfo, TextView textView) {
        if (!TextUtils.isEmpty(modeItemInfo.itemName)) {
            textView.setText(modeItemInfo.itemName.trim());
            if (!TextUtils.isEmpty(modeItemInfo.textColor)) {
                C4407f.m11131a(textView, modeItemInfo.textColor);
            }
        } else if (modeItemInfo.itemNameBackupRes > 0) {
            textView.setText(modeItemInfo.itemNameBackupRes);
        }
    }

    /* renamed from: a */
    public static void m9721a(ModeItemInfo modeItemInfo, DynamicLoadingImageView dynamicLoadingImageView) {
        if (!TextUtils.isEmpty(modeItemInfo.itemImgUrl)) {
            dynamicLoadingImageView.setImageURI(modeItemInfo.itemImgUrl);
        } else if (modeItemInfo.itemImgBackupRes != null) {
            dynamicLoadingImageView.setImage(((Integer) modeItemInfo.itemImgBackupRes).intValue());
        }
    }

    /* renamed from: a */
    public void mo23493a(ModeItemInfo modeItemInfo, ModeItemInfo modeItemInfo2) {
        m9721a(modeItemInfo, this.brF);
        m9720a(modeItemInfo, this.brJ);
        m9721a(modeItemInfo2, this.brG);
        m9720a(modeItemInfo2, this.brK);
        m9719a(modeItemInfo, this.brD, R.drawable.main_tool_btn_editor_bg);
        m9719a(modeItemInfo2, this.brE, R.drawable.main_tool_btn_camera_bg);
        Context context = getContext();
        String str = modeItemInfo.itemName;
        StringBuilder sb = new StringBuilder();
        sb.append(modeItemInfo.rawId);
        sb.append("");
        UserBehaviorABTestUtils.onEventShowHomeMain(context, 0, str, sb.toString());
        Context context2 = getContext();
        String str2 = modeItemInfo2.itemName;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(modeItemInfo2.rawId);
        sb2.append("");
        UserBehaviorABTestUtils.onEventShowHomeMain(context2, 1, str2, sb2.toString());
        this.brD.setTag(modeItemInfo);
        this.brE.setTag(modeItemInfo2);
        this.brD.setOnClickListener(this.acD);
        this.brE.setOnClickListener(this.acD);
    }

    /* renamed from: by */
    public void mo23494by(boolean z) {
        if (this.acD != null && this.brD != null && this.brE != null) {
            this.acD.onClick(z ? this.brD : this.brE);
        }
    }

    /* renamed from: c */
    public void mo23495c(List<ModeItemInfo> list, int i) {
        if (((ModeItemInfo) list.get(0)).todoCode == i || ((ModeItemInfo) list.get(1)).todoCode == i) {
            DynamicLoadingImageView dynamicLoadingImageView = ((ModeItemInfo) list.get(0)).todoCode == i ? !C4580b.m11666qi() ? this.brH : this.brI : !C4580b.m11666qi() ? this.brI : this.brH;
            dynamicLoadingImageView.setImage(R.drawable.homepage_maintoolview_tip_bg);
            dynamicLoadingImageView.setVisibility(0);
        }
    }

    public void setMainToolItemViewListener(C3949b bVar) {
        this.brL = bVar;
    }
}
