package com.introvd.template.app.p199v5.common.p200ui.videolist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.R;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.app.p199v5.common.p200ui.EventHorizontalScrollView;
import com.introvd.template.app.p199v5.videoexplore.VideoExploreActivity;
import com.introvd.template.app.publish.ResultPageActivity;
import com.introvd.template.app.videoplayer.C4465a;
import com.introvd.template.app.videoplayer.C4465a.C4468a;
import com.introvd.template.app.videoplayer.VideoCardForCreationView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.banner.LoopViewPager;
import com.introvd.template.common.p236ui.banner.LoopViewPager.PagerFormatData;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo.AdItemInfo;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo.VideoInfo;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.p325a.C7572a;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.VivaCommunityRouter.FeedVideoActivityParams;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.app.v5.common.ui.videolist.a */
public class C4426a extends BaseAdapter {
    /* access modifiers changed from: private */
    public int bFA;
    private C4433a bFB;
    private boolean bFC = true;
    private View bFD = null;
    /* access modifiers changed from: private */
    public C4465a bFE;
    private ViewAdsListener bFF = new ViewAdsListener() {
        public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            if (adPositionInfoParam.position != 45) {
                C4426a.this.notifyDataSetChanged();
            }
        }
    };
    private View bFx = null;
    private SparseArray<C4465a> bFy;
    private HashMap<String, Long> bFz;
    /* access modifiers changed from: private */
    public Context context;
    private List<ModeItemInfo> mItemInfoList;

    /* renamed from: com.introvd.template.app.v5.common.ui.videolist.a$a */
    private class C4433a {
        int bFJ;
        String bFK;
        String bFL;
        C4433a bFM;

        public C4433a(int i) {
            this.bFJ = i;
            m11211hR(i);
        }

        /* renamed from: hR */
        private void m11211hR(int i) {
            switch (i) {
                case 12:
                    this.bFK = "Ad_Export_Result_Show";
                    this.bFL = "Ad_Export_Result_Click";
                    return;
                case 13:
                    this.bFK = "Ad_Home_Recomm_Show";
                    this.bFL = "Ad_Home_Recomm_Click";
                    return;
                default:
                    return;
            }
        }

        /* renamed from: j */
        public C4433a mo24537j(int i, String str, String str2) {
            this.bFM = new C4433a(i);
            this.bFM.bFK = str;
            this.bFM.bFL = str2;
            return this;
        }
    }

    /* renamed from: com.introvd.template.app.v5.common.ui.videolist.a$b */
    public static class C4434b {
        private SparseArray<View> bvE = new SparseArray<>();
        View bvF;

        public C4434b(View view) {
            this.bvF = view;
        }

        /* renamed from: n */
        public View mo24538n(int i) {
            View view = (View) this.bvE.get(i);
            if (view != null) {
                return view;
            }
            View findViewById = this.bvF.findViewById(i);
            this.bvE.put(i, findViewById);
            return findViewById;
        }
    }

    /* renamed from: com.introvd.template.app.v5.common.ui.videolist.a$c */
    private class C4435c {
        int bFN;
        int height;
        int padding;
        int type;
        int width;

        public C4435c(int i, MSize mSize, int i2, int i3) {
            this.type = i;
            this.width = mSize.width;
            this.height = mSize.height;
            this.padding = i2;
            this.bFN = i3;
        }
    }

    public C4426a(Context context2, List<ModeItemInfo> list, int i) {
        this.mItemInfoList = list;
        this.context = context2;
        this.bFA = i;
        this.bFz = new HashMap<>();
    }

    /* renamed from: QW */
    private void m11179QW() {
        if (this.bFC) {
            this.bFC = false;
            C7589a.m22363h(this.bFB.bFJ, this.bFF);
            C7589a.m22360aj(this.context, this.bFB.bFJ);
            if (this.bFB.bFM != null) {
                C7589a.m22363h(this.bFB.bFM.bFJ, this.bFF);
                C7589a.m22360aj(this.context, this.bFB.bFM.bFJ);
            }
        }
    }

    /* renamed from: QX */
    private TextView m11180QX() {
        TextView textView = new TextView(this.context);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setTextSize(11.0f);
        textView.setShadowLayer(1.0f, 0.0f, 1.0f, R.color.black_p75);
        textView.setTextColor(this.context.getResources().getColor(R.color.white));
        LayoutParams layoutParams = new LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(C4583d.m11671P(5.0f));
        } else {
            layoutParams.rightMargin = C4583d.m11671P(5.0f);
        }
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* renamed from: T */
    private void m11181T(String str, String str2) {
        if (m11198ej(str)) {
            m11199ek(str);
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            UserBehaviorLog.onKVEvent(this.context, str2, hashMap);
        }
    }

    /* renamed from: a */
    private View m11183a(ModeItemInfo modeItemInfo, int i) {
        View view;
        int O = C4583d.m11670O(this.context, 15);
        int modeType = modeItemInfo.getModeType();
        if (modeType != 1) {
            if (modeType != 6) {
                if (modeType != 101) {
                    switch (modeType) {
                        case 3:
                            break;
                        case 4:
                            view = m11195d(modeItemInfo, i);
                            break;
                        default:
                            switch (modeType) {
                                case 21:
                                    view = m11197e(modeItemInfo, i);
                                    break;
                                case 22:
                                    view = m11194c(modeItemInfo, i);
                                    break;
                                case 23:
                                    view = m11196e(modeItemInfo);
                                    break;
                                default:
                                    view = null;
                                    break;
                            }
                    }
                } else {
                    view = m11200f(modeItemInfo);
                }
            }
            view = m11201f(modeItemInfo, i);
        } else {
            view = m11190b(modeItemInfo, i);
        }
        if (view != null) {
            view.setPadding(O, 0, O, 0);
        }
        return view;
    }

    /* renamed from: a */
    private View m11184a(ModeItemInfo modeItemInfo, boolean z, C4435c cVar, int i) {
        EventHorizontalScrollView eventHorizontalScrollView;
        LayoutInflater layoutInflater;
        String[] strArr;
        int i2;
        View view;
        final AdItemInfo adItemInfo;
        AdItemInfo adItemInfo2;
        int i3;
        final ModeItemInfo modeItemInfo2 = modeItemInfo;
        C4435c cVar2 = cVar;
        final int i4 = i;
        EventHorizontalScrollView eventHorizontalScrollView2 = new EventHorizontalScrollView(this.context);
        LinearLayout linearLayout = new LinearLayout(this.context);
        int i5 = 0;
        linearLayout.setOrientation(0);
        LayoutInflater from = LayoutInflater.from(this.context);
        int size = modeItemInfo2.adItemInfoList.size();
        String[] strArr2 = new String[size];
        int i6 = 0;
        while (i6 < size) {
            AdItemInfo adItemInfo3 = (AdItemInfo) modeItemInfo2.adItemInfoList.get(i6);
            strArr2[i6] = adItemInfo3.adName;
            View inflate = from.inflate(R.layout.creation_home_list_child_item_layout, null);
            TextView textView = (TextView) inflate.findViewById(R.id.creation_item_text);
            if (z) {
                if (!TextUtils.isEmpty(adItemInfo3.adName)) {
                    textView.setText(adItemInfo3.adName);
                    textView.setVisibility(i5);
                } else {
                    textView.setVisibility(8);
                }
            } else if (!TextUtils.isEmpty(adItemInfo3.description)) {
                textView.setText(adItemInfo3.description);
                textView.setVisibility(i5);
            } else {
                textView.setVisibility(8);
            }
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.creation_home_item_play_info_layout);
            TextView textView2 = (TextView) inflate.findViewById(R.id.creation_home_item_play_num);
            RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.creation_item_img_layout);
            if (z) {
                View view2 = inflate;
                relativeLayout.setVisibility(0);
                final VideoInfo videoInfo = adItemInfo3.mVideoInfo;
                String str = "0";
                if (videoInfo != null) {
                    adItemInfo2 = adItemInfo3;
                    i3 = i6;
                    str = C4436b.m11214M(this.context, (int) videoInfo.mViewCount);
                } else {
                    adItemInfo2 = adItemInfo3;
                    i3 = i6;
                }
                if (!AppStateModel.getInstance().isCommunitySupport()) {
                    textView2.setText(str);
                }
                view = view2;
                AdItemInfo adItemInfo4 = adItemInfo2;
                final ModeItemInfo modeItemInfo3 = modeItemInfo;
                eventHorizontalScrollView = eventHorizontalScrollView2;
                layoutInflater = from;
                i2 = i3;
                C44293 r11 = r0;
                final int i7 = i;
                strArr = strArr2;
                final AdItemInfo adItemInfo5 = adItemInfo4;
                C44293 r0 = new OnClickListener() {
                    public void onClick(View view) {
                        if (videoInfo != null) {
                            if (modeItemInfo3.todoCode > 0) {
                                TODOParamModel tODOParamModel = new TODOParamModel();
                                tODOParamModel.mTODOCode = modeItemInfo3.todoCode;
                                tODOParamModel.mJsonParam = modeItemInfo3.todoParameter;
                                if (C4426a.this.bFA == 47) {
                                    TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_EXPORT_RESULT_BANNER, modeItemInfo3.itemName);
                                } else {
                                    TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_TYPE_CREATION_BANNER, modeItemInfo3.itemName);
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_CREATION);
                                BizAppTodoActionManager.getInstance().executeTodo((Activity) C4426a.this.context, tODOParamModel, bundle);
                            } else if (AppStateModel.getInstance().isCommunitySupport()) {
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("puid", videoInfo.puid);
                                StringBuilder sb = new StringBuilder();
                                sb.append(videoInfo.mVer);
                                sb.append("");
                                jsonObject.addProperty("pver", sb.toString());
                                VivaRouter.getRouterBuilder(FeedVideoActivityParams.URL).mo10399f(FeedVideoActivityParams.EXTRA_VIDEO_TYPE_SINGLE_JSON, new Gson().toJson((JsonElement) jsonObject)).mo10406h(FeedVideoActivityParams.EXTRA_VIDEO_PAGE_FROM, C4426a.this.bFA).mo10394aZ(R.anim.activity_right_enter_translate, R.anim.activity_left_exit_translate).mo10382H(C4426a.this.context);
                            } else {
                                Intent intent = new Intent(C4426a.this.context, VideoExploreActivity.class);
                                intent.putExtra("intent_extra_key_video_pver", String.valueOf(videoInfo.mVer));
                                intent.putExtra("intent_extra_key_video_puid", videoInfo.puid);
                                C4426a.this.context.startActivity(intent);
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(videoInfo.puid);
                            sb2.append("_");
                            sb2.append(videoInfo.mVer);
                            UserBehaviorUtils.recordMonHomeGroupVideoClick(C4426a.this.context, "Home_Group_Video_Click", sb2.toString());
                            HashMap hashMap = new HashMap();
                            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C4426a.this.bFA == 47 ? "导出结果页" : "首页资源位");
                            UserBehaviorLog.onKVEvent(C4426a.this.context, "Click_Resource_GoToFeed", hashMap);
                            Context a = C4426a.this.context;
                            int i = i7;
                            String str = adItemInfo5.adName;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(modeItemInfo3.rawId);
                            sb3.append("");
                            UserBehaviorABTestUtils.onEventHomeRecommendGroup(a, i, str, sb3.toString(), false);
                        }
                    }
                };
                relativeLayout2.setOnClickListener(r11);
                adItemInfo = adItemInfo4;
            } else {
                view = inflate;
                strArr = strArr2;
                eventHorizontalScrollView = eventHorizontalScrollView2;
                layoutInflater = from;
                i2 = i6;
                adItemInfo = adItemInfo3;
                relativeLayout2.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        TODOParamModel tODOParamModel = new TODOParamModel();
                        tODOParamModel.mTODOCode = adItemInfo.adTodoCode;
                        tODOParamModel.mJsonParam = adItemInfo.adTodoParameter;
                        if (C4426a.this.bFA == 47) {
                            TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_EXPORT_RESULT_BANNER, modeItemInfo2.itemName);
                        } else {
                            TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_TYPE_CREATION_BANNER, modeItemInfo2.itemName);
                        }
                        if (modeItemInfo2.todoCode == 16004) {
                            C7835b.m22861lq("首页运营位");
                        }
                        if ((C4426a.this.context instanceof Activity) && ((Activity) C4426a.this.context).getIntent() != null) {
                            ((Activity) C4426a.this.context).getIntent().removeExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_CREATION);
                        BizAppTodoActionManager.getInstance().executeTodo((Activity) C4426a.this.context, tODOParamModel, bundle);
                        HashMap hashMap = new HashMap();
                        hashMap.put("name", adItemInfo.adName);
                        UserBehaviorLog.onKVEvent(C4426a.this.context, "Home_Group_Recommend_Click", hashMap);
                        Context a = C4426a.this.context;
                        int i = i4;
                        String str = adItemInfo.adName;
                        StringBuilder sb = new StringBuilder();
                        sb.append(modeItemInfo2.rawId);
                        sb.append("");
                        UserBehaviorABTestUtils.onEventHomeRecommendGroup(a, i, str, sb.toString(), false);
                        UserBehaviorUtils.recordHomeClick("推荐组");
                    }
                });
                relativeLayout.setVisibility(8);
            }
            DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) view.findViewById(R.id.creation_item_img);
            ImageLoader.loadImage(adItemInfo.adImgUrl, R.drawable.home_icon_place_bg, R.drawable.home_icon_place_bg, (Drawable) new ColorDrawable(dynamicLoadingImageView.getResources().getColor(R.color.color_aaaaaa_p40)), dynamicLoadingImageView);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dynamicLoadingImageView.getLayoutParams();
            layoutParams.width = cVar2.width;
            layoutParams.height = cVar2.height;
            dynamicLoadingImageView.setLayoutParams(layoutParams);
            LayoutParams layoutParams2 = new LayoutParams(cVar2.width, -2);
            if (i2 >= size - 1) {
                layoutParams2.setMargins(0, 0, 0, 0);
            } else if (VERSION.SDK_INT >= 17) {
                layoutParams2.setMarginStart(0);
                layoutParams2.topMargin = 0;
                layoutParams2.setMarginEnd(cVar2.bFN);
                layoutParams2.bottomMargin = 0;
            } else {
                layoutParams2.setMargins(0, 0, cVar2.bFN, 0);
            }
            linearLayout.setPadding(cVar2.padding, linearLayout.getPaddingTop(), cVar2.padding, linearLayout.getPaddingBottom());
            linearLayout.addView(view, layoutParams2);
            m11181T(strArr[i2], "Home_Group_Recommend_Show");
            Context context2 = this.context;
            String str2 = strArr[i2];
            StringBuilder sb = new StringBuilder();
            sb.append(modeItemInfo2.rawId);
            sb.append("");
            UserBehaviorABTestUtils.onEventHomeRecommendGroup(context2, i4, str2, sb.toString(), true);
            i6 = i2 + 1;
            strArr2 = strArr;
            from = layoutInflater;
            eventHorizontalScrollView2 = eventHorizontalScrollView;
            i5 = 0;
        }
        EventHorizontalScrollView eventHorizontalScrollView3 = eventHorizontalScrollView2;
        eventHorizontalScrollView3.addView(linearLayout);
        eventHorizontalScrollView3.setHorizontalScrollBarEnabled(false);
        return eventHorizontalScrollView3;
    }

    /* renamed from: a */
    private MSize m11186a(C4436b bVar, int i) {
        if (bVar.bGd == 0) {
            bVar.bGd = 1;
        }
        int i2 = Constants.getScreenSize().width - (i * 2);
        return new MSize(i2, (int) (((((double) i2) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) * ((double) bVar.bGe)) / ((double) bVar.bGd)));
    }

    /* renamed from: a */
    private void m11187a(C4434b bVar, ModeItemInfo modeItemInfo) {
    }

    /* renamed from: as */
    private List<PagerFormatData> m11188as(List<AdItemInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (AdItemInfo adItemInfo : list) {
            PagerFormatData pagerFormatData = new PagerFormatData();
            pagerFormatData.imgUrl = adItemInfo.adImgUrl;
            pagerFormatData.todoCode = Integer.valueOf(adItemInfo.adTodoCode);
            pagerFormatData.todoContent = adItemInfo.adTodoParameter;
            pagerFormatData.name = adItemInfo.adName;
            arrayList.add(pagerFormatData);
        }
        return arrayList;
    }

    /* renamed from: b */
    private View m11190b(final ModeItemInfo modeItemInfo, final int i) {
        if (this.context instanceof ResultPageActivity) {
            m11181T(modeItemInfo.title, "Result_Single_Recommend_Show");
            Context context2 = this.context;
            String str = modeItemInfo.title;
            StringBuilder sb = new StringBuilder();
            sb.append(modeItemInfo.rawId);
            sb.append("");
            UserBehaviorABTestUtils.onEventExportdoneRecommend(context2, i, str, sb.toString(), true);
        } else {
            m11181T(modeItemInfo.title, "Home_Single_Recommend_Show");
            Context context3 = this.context;
            String str2 = modeItemInfo.title;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(modeItemInfo.rawId);
            sb2.append("");
            UserBehaviorABTestUtils.onEventHomeRecommend(context3, i, str2, sb2.toString(), true);
        }
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.creation_home_list_child_item_layout, null);
        TextView textView = (TextView) inflate.findViewById(R.id.creation_item_text);
        if (!TextUtils.isEmpty(modeItemInfo.description)) {
            textView.setText(modeItemInfo.description);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) inflate.findViewById(R.id.creation_item_img);
        C7572a.m22333a(dynamicLoadingImageView, modeItemInfo, modeItemInfo.todoParameter);
        dynamicLoadingImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str;
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = modeItemInfo.todoCode;
                tODOParamModel.mJsonParam = modeItemInfo.todoParameter;
                if (C4426a.this.bFA == 47) {
                    TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_EXPORT_RESULT_BANNER, modeItemInfo.itemName);
                } else {
                    TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_TYPE_CREATION_BANNER, modeItemInfo.itemName);
                }
                if (modeItemInfo.todoCode == 16004) {
                    C7835b.m22861lq(C4426a.this.bFA == 23 ? "首页运营位" : "结果页运营位");
                }
                if ((C4426a.this.context instanceof Activity) && ((Activity) C4426a.this.context).getIntent() != null) {
                    ((Activity) C4426a.this.context).getIntent().removeExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
                }
                Bundle bundle = new Bundle();
                bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_CREATION);
                BizAppTodoActionManager.getInstance().executeTodo((Activity) C4426a.this.context, tODOParamModel, bundle);
                HashMap hashMap = new HashMap();
                hashMap.put("name", modeItemInfo.title);
                if (C4426a.this.context instanceof ResultPageActivity) {
                    str = "Result_Single_Recommend_Click";
                    Context a = C4426a.this.context;
                    int i = i;
                    String str2 = modeItemInfo.title;
                    StringBuilder sb = new StringBuilder();
                    sb.append(modeItemInfo.rawId);
                    sb.append("");
                    UserBehaviorABTestUtils.onEventExportdoneRecommend(a, i, str2, sb.toString(), false);
                } else {
                    str = "Home_Single_Recommend_Click";
                    Context a2 = C4426a.this.context;
                    int i2 = i;
                    String str3 = modeItemInfo.title;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(modeItemInfo.rawId);
                    sb2.append("");
                    UserBehaviorABTestUtils.onEventHomeRecommend(a2, i2, str3, sb2.toString(), false);
                }
                UserBehaviorLog.onKVEvent(C4426a.this.context, str, hashMap);
                UserBehaviorUtils.recordHomeClick("单一推荐位");
            }
        });
        ImageLoader.loadImage(modeItemInfo.itemImgUrl, R.drawable.home_icon_place_bg, R.drawable.home_icon_place_bg, (Drawable) new ColorDrawable(dynamicLoadingImageView.getResources().getColor(R.color.color_aaaaaa_p40)), dynamicLoadingImageView);
        MSize hP = m11202hP(Constants.getScreenSize().width - C4583d.m11670O(this.context, 30));
        ViewGroup.LayoutParams layoutParams = dynamicLoadingImageView.getLayoutParams();
        layoutParams.height = hP.height;
        layoutParams.width = hP.width;
        dynamicLoadingImageView.setLayoutParams(layoutParams);
        return inflate;
    }

    /* renamed from: b */
    private void m11191b(C4434b bVar, ModeItemInfo modeItemInfo) {
        C44326 r3;
        View n = bVar.mo24538n(R.id.creation_home_list_title_layout);
        View n2 = bVar.mo24538n(R.id.creation_title_more);
        if (!modeItemInfo.isVideoItem() || !modeItemInfo.isVideoListStart || AppStateModel.getInstance().isCommunitySupport()) {
            n2.setVisibility(8);
            r3 = null;
        } else {
            n2.setVisibility(0);
            r3 = new OnClickListener() {
                public void onClick(View view) {
                    C4426a.this.context.startActivity(new Intent(C4426a.this.context, VideoExploreActivity.class));
                    UserBehaviorLog.onKVEvent(C4426a.this.context, "Home_Video_More_Click", new HashMap());
                }
            };
        }
        n.setOnClickListener(r3);
    }

    /* renamed from: bK */
    private MSize m11192bK(int i, int i2) {
        int i3 = (int) ((((double) (i - (i2 * 2))) * 3.0d) / 7.0d);
        return new MSize(i3, (int) (((((double) i3) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) * 95.0d) / 150.0d));
    }

    /* renamed from: bV */
    private void m11193bV(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeAllViews();
        }
    }

    /* renamed from: c */
    private View m11194c(ModeItemInfo modeItemInfo, int i) {
        int P = C4583d.m11671P(5.0f);
        C4435c cVar = new C4435c(21, m11192bK(Constants.getScreenSize().width - C4583d.m11671P(30.0f), P), 0, P);
        return m11184a(modeItemInfo, false, cVar, i);
    }

    /* renamed from: d */
    private View m11195d(ModeItemInfo modeItemInfo, int i) {
        int P = C4583d.m11671P(0.0f);
        int P2 = C4583d.m11671P(5.0f);
        C4435c cVar = new C4435c(21, m11203w(Constants.getScreenSize().width - C4583d.m11671P(30.0f), (P * 2) + P2, 2), P, P2);
        return m11184a(modeItemInfo, true, cVar, i);
    }

    /* renamed from: e */
    private View m11196e(ModeItemInfo modeItemInfo) {
        ArrayList<AdItemInfo> arrayList = modeItemInfo.adItemInfoList;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.context).inflate(R.layout.app_com_bannerview_layout, null);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.creation_default_img);
        LoopViewPager loopViewPager = (LoopViewPager) viewGroup.findViewById(R.id.creation_viewpager);
        loopViewPager.mBannerCode = this.bFA == 47 ? 10504 : 10503;
        loopViewPager.init(m11188as(arrayList), true, true);
        loopViewPager.handleCollision(new View[0]);
        loopViewPager.setOffscreenPageLimit(3);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.creation_pager_dot_layout);
        linearLayout.setBackgroundColor(this.context.getResources().getColor(R.color.black_p20));
        int P = C4583d.m11671P(5.0f);
        linearLayout.setPadding(P, 0, P, 0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = C4583d.m11671P(27.0f);
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.addView(m11180QX());
        loopViewPager.initIndicator(R.drawable.v5_viewpager_dot_focus, R.drawable.v5_viewpager_dot, linearLayout);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) loopViewPager.getLayoutParams();
        layoutParams2.width = Constants.getScreenSize().width;
        layoutParams2.height = (Constants.getScreenSize().width * 9) / 16;
        loopViewPager.setLayoutParams(layoutParams2);
        if (arrayList.size() < 1) {
            if ("zh".equals(this.context.getResources().getConfiguration().locale.getLanguage().toLowerCase())) {
                imageView.setImageResource(R.drawable.v5_xiaoying_home_banner_default_cn);
            } else {
                imageView.setImageResource(R.drawable.v5_xiaoying_home_banner_default_o);
            }
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        return viewGroup;
    }

    /* renamed from: e */
    private View m11197e(ModeItemInfo modeItemInfo, int i) {
        int P = C4583d.m11671P(5.0f);
        C4435c cVar = new C4435c(21, m11203w(Constants.getScreenSize().width - C4583d.m11671P(30.0f), P, 2), 0, P);
        return m11184a(modeItemInfo, false, cVar, i);
    }

    /* renamed from: ej */
    private boolean m11198ej(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!this.bFz.containsKey(str)) {
            return true;
        }
        if (System.currentTimeMillis() - ((Long) this.bFz.get(str)).longValue() > DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) {
            z = true;
        }
        return z;
    }

    /* renamed from: ek */
    private void m11199ek(String str) {
        this.bFz.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: f */
    private View m11200f(ModeItemInfo modeItemInfo) {
        String str = null;
        if (this.bFB == null || C8072q.aBx().mo33072ku(C7825a.AD.getId())) {
            return null;
        }
        this.bFC = true;
        this.bFD = C7589a.getAdView(this.context, this.bFB.bFJ);
        if (this.bFD != null) {
            str = this.bFB.bFK;
        } else if (this.bFB.bFM != null) {
            this.bFD = C7589a.getAdView(this.context, this.bFB.bFM.bFJ);
            if (this.bFD != null) {
                if ((this.bFD instanceof ViewGroup) && ((ViewGroup) this.bFD).getChildCount() == 0) {
                    return null;
                }
                int P = C4583d.m11671P(300.0f);
                int i = (P * 11) / 10;
                int i2 = (P * 5) / 6;
                if (this.bFD.getLayoutParams() == null) {
                    this.bFD.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
                } else {
                    ViewGroup.LayoutParams layoutParams = this.bFD.getLayoutParams();
                    layoutParams.height = i2;
                    layoutParams.width = i;
                }
                str = this.bFB.bFM.bFK;
            }
        }
        if (!(this.bFD == null || this.bFD == this.bFx)) {
            if (this.bFx != null) {
                AppPreferencesSetting.getInstance().setAppSettingStr("key_ad_show_time_stamp", String.valueOf(System.currentTimeMillis()));
            }
            this.bFx = this.bFD;
            HashMap hashMap = new HashMap();
            String W = C7591a.m22370W(this.bFD.getTag());
            hashMap.put("platform", W);
            UserBehaviorLog.onKVEvent(this.context, str, hashMap);
            C7592b.m22379F(this.context, str, W);
        }
        return this.bFD;
    }

    /* renamed from: f */
    private View m11201f(final ModeItemInfo modeItemInfo, int i) {
        if (this.context instanceof ResultPageActivity) {
            m11181T(modeItemInfo.title, "Result_Single_Recommend_Show");
            Context context2 = this.context;
            String str = modeItemInfo.title;
            StringBuilder sb = new StringBuilder();
            sb.append(modeItemInfo.rawId);
            sb.append("");
            UserBehaviorABTestUtils.onEventExportdoneRecommend(context2, i, str, sb.toString(), true);
        } else {
            m11181T(modeItemInfo.title, "Home_Single_Recommend_Show");
            Context context3 = this.context;
            String str2 = modeItemInfo.title;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(modeItemInfo.rawId);
            sb2.append("");
            UserBehaviorABTestUtils.onEventHomeRecommend(context3, i, str2, sb2.toString(), true);
        }
        VideoCardForCreationView videoCardForCreationView = new VideoCardForCreationView(this.context);
        videoCardForCreationView.setBehaviorParams(i, modeItemInfo.rawId);
        C4436b g = C4436b.m11215g(modeItemInfo);
        if (g == null) {
            return null;
        }
        C4465a aVar = new C4465a(this.bFA);
        aVar.mo24657a((C4468a) new C4468a() {
            /* renamed from: a */
            public void mo24534a(C4465a aVar) {
                C4426a.this.bFE = aVar;
            }

            /* renamed from: bW */
            public boolean mo24535bW(View view) {
                if (modeItemInfo.todoCode <= 0) {
                    return false;
                }
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = modeItemInfo.todoCode;
                tODOParamModel.mJsonParam = modeItemInfo.todoParameter;
                if (C4426a.this.bFA == 47) {
                    TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_EXPORT_RESULT_BANNER, modeItemInfo.itemName);
                } else {
                    TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_TYPE_CREATION_BANNER, modeItemInfo.itemName);
                }
                Bundle bundle = new Bundle();
                bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_CREATION);
                BizAppTodoActionManager.getInstance().executeTodo((Activity) C4426a.this.context, tODOParamModel, bundle);
                return true;
            }
        });
        if (this.bFy == null) {
            this.bFy = new SparseArray<>();
        }
        this.bFy.put(i, aVar);
        aVar.mo24659c(g, m11186a(g, C4583d.m11670O(this.context, 15)).width);
        aVar.mo24656a(videoCardForCreationView);
        return videoCardForCreationView;
    }

    /* renamed from: hP */
    private MSize m11202hP(int i) {
        return new MSize(i, (i * IronSourceConstants.USING_CACHE_FOR_INIT_EVENT) / 345);
    }

    /* renamed from: w */
    private MSize m11203w(int i, int i2, int i3) {
        int i4 = (i - ((i3 - 1) * i2)) / i3;
        return new MSize(i4, (int) (((((double) i4) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) * 95.0d) / 150.0d));
    }

    /* renamed from: bU */
    public void mo24519bU(boolean z) {
        if (z) {
            m11179QW();
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.mItemInfoList.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4434b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.creation_home_list_item_layout, null);
            bVar = new C4434b(view);
            view.setTag(bVar);
        } else {
            bVar = (C4434b) view.getTag();
        }
        ModeItemInfo modeItemInfo = (ModeItemInfo) this.mItemInfoList.get(i);
        ViewGroup viewGroup2 = (ViewGroup) bVar.mo24538n(R.id.creation_item_content_layout);
        try {
            viewGroup2.removeAllViews();
        } catch (Exception unused) {
        }
        View a = m11183a(modeItemInfo, i);
        View n = bVar.mo24538n(R.id.creation_home_list_title_layout);
        if (a != null) {
            m11193bV(a);
            view.setVisibility(0);
            viewGroup2.addView(a);
            m11187a(bVar, modeItemInfo);
            n.setVisibility(0);
            String str = modeItemInfo.title;
            if (!TextUtils.isEmpty(str)) {
                m11191b(bVar, modeItemInfo);
                TextView textView = (TextView) bVar.mo24538n(R.id.creation_ad_title);
                textView.setText(str);
                if ((modeItemInfo.isVideoItem() || modeItemInfo.isInVideoList) && !modeItemInfo.isVideoListStart) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                }
            } else {
                n.setVisibility(8);
            }
        } else {
            view.setVisibility(8);
            view.setVisibility(8);
            n.setVisibility(8);
        }
        return view;
    }

    /* renamed from: hM */
    public void mo24524hM(int i) {
        this.bFB = new C4433a(i);
        if (i == 13) {
            this.bFB.mo24537j(45, "Ad_Home_B_Show", "Ad_Home_B_Click");
        }
    }

    /* renamed from: hN */
    public ModeItemInfo getItem(int i) {
        if (this.mItemInfoList == null || this.mItemInfoList.size() <= i || i < 0) {
            return null;
        }
        return (ModeItemInfo) this.mItemInfoList.get(i);
    }

    /* renamed from: hO */
    public String mo24526hO(int i) {
        String str = "";
        ModeItemInfo hN = getItem(i);
        if (hN == null) {
            return str;
        }
        String str2 = hN.title;
        return (!hN.isAdvItem() || AppStateModel.getInstance().isInChina()) ? str2 : this.context.getString(R.string.xiaoying_str_publish_result_recommend);
    }

    /* renamed from: hQ */
    public C4465a mo24527hQ(int i) {
        if (this.bFy == null) {
            return null;
        }
        return (C4465a) this.bFy.get(i);
    }

    public void onPause() {
        if (this.bFE != null && this.bFE.isPlaying()) {
            this.bFE.resetPlayer();
        }
    }

    public void onResume() {
        if (this.bFE != null) {
            this.bFE.mo24661i(this.context, VideoAutoPlayHelper.canAutoPlay(this.context));
        }
    }

    public void release() {
        if (this.bFy != null) {
            int size = this.bFy.size();
            for (int i = 0; i < size; i++) {
                ((C4465a) this.bFy.get(i)).release();
            }
            this.bFy = null;
        }
    }
}
