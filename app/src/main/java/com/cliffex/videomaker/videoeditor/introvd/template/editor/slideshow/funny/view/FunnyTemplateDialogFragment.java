package com.introvd.template.editor.slideshow.funny.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.p021v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.C4677g;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.p278a.C6738a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.router.slide.FunnySlideRouter;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xyui.video.C9183a;
import com.introvd.template.xyui.video.VideoView;
import com.p131c.p132a.p135c.C2575a;
import org.json.JSONException;
import org.json.JSONObject;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;

public class FunnyTemplateDialogFragment extends DialogFragment {
    private String csh;
    /* access modifiers changed from: private */
    public ImageView dgG;
    private RelativeLayout dgH;
    /* access modifiers changed from: private */
    public TextView dgK;
    /* access modifiers changed from: private */
    public ProgressBar dgN;
    /* access modifiers changed from: private */
    public int dgR = -1;
    private C9183a dgS = new C9183a() {
        public boolean aqu() {
            return false;
        }

        public void aqv() {
        }

        public void aqw() {
        }

        public void aqx() {
        }

        /* renamed from: oU */
        public void mo30103oU(int i) {
        }

        public void onBuffering(boolean z) {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (mediaPlayer.getCurrentPosition() == 0) {
                FunnyTemplateDialogFragment.this.dgG.setVisibility(0);
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            FunnyTemplateDialogFragment.this.m19928he(false);
            if (mediaPlayer != null) {
                FunnyTemplateDialogFragment.this.dhC.setBackgroundColor(0);
                FunnyTemplateDialogFragment.this.dhC.start();
            }
        }
    };
    /* access modifiers changed from: private */
    public RelativeLayout dhA;
    /* access modifiers changed from: private */
    public RelativeLayout dhB;
    /* access modifiers changed from: private */
    public VideoView dhC;
    /* access modifiers changed from: private */
    public ImageView dhD;
    private String dhE;
    private String dhF;
    private String dhG;
    C8707b dhH = new C8707b() {
        public void arB() {
        }

        public void arC() {
        }

        /* renamed from: iA */
        public void mo30336iA(String str) {
            if (FunnyTemplateDialogFragment.this.templateId.equals(str) && FunnyTemplateDialogFragment.this.dgR != 1) {
                FunnyTemplateDialogFragment.this.m19933ph(FunnyTemplateDialogFragment.this.mo30404iw(FunnyTemplateDialogFragment.this.templateId));
                FunnyTemplateDialogFragment.this.dgR = 1;
                if (FunnyTemplateDialogFragment.this.getActivity() != null) {
                    FunnySlideRouter.launchFunnyEdit(FunnyTemplateDialogFragment.this.getActivity(), C2575a.m7391rq(FunnyTemplateDialogFragment.this.templateId));
                }
                FunnyTemplateDialogFragment.this.dismissAllowingStateLoss();
            }
        }

        /* renamed from: iB */
        public void mo30337iB(String str) {
            FunnyTemplateDialogFragment.this.dgN.setVisibility(8);
            FunnyTemplateDialogFragment.this.dgK.setText(R.string.xiaoying_str_funny_template_create);
            FunnyTemplateDialogFragment.this.dgK.setBackgroundResource(R.drawable.editor_shape_funny_template_detail_create);
        }

        /* renamed from: iC */
        public void mo30338iC(String str) {
            FunnyTemplateDialogFragment.this.dgN.setVisibility(8);
            FunnyTemplateDialogFragment.this.dgK.setText(R.string.xiaoying_str_funny_template_create);
            FunnyTemplateDialogFragment.this.dgK.setBackgroundResource(R.drawable.editor_shape_funny_template_detail_create);
            FunnyTemplateDialogFragment.this.dgR = 2;
        }

        /* renamed from: ix */
        public void mo30340ix(String str) {
        }

        /* renamed from: iy */
        public void mo30341iy(String str) {
            FunnyTemplateDialogFragment.this.dgR = 0;
        }

        /* renamed from: iz */
        public void mo30342iz(String str) {
        }

        /* renamed from: w */
        public void mo30344w(String str, int i) {
            if (FunnyTemplateDialogFragment.this.templateId.equals(str) && FunnyTemplateDialogFragment.this.dgR != -1) {
                FunnyTemplateDialogFragment.this.dgR = 0;
                FunnyTemplateDialogFragment.this.dgK.setBackgroundColor(0);
                FunnyTemplateDialogFragment.this.dgN.setVisibility(0);
                FunnyTemplateDialogFragment.this.dgN.setProgress(i);
                TextView k = FunnyTemplateDialogFragment.this.dgK;
                StringBuilder sb = new StringBuilder();
                sb.append(FunnyTemplateDialogFragment.this.getString(R.string.xiaoying_str_com_msg_download));
                sb.append(" ");
                sb.append(i);
                sb.append("%");
                k.setText(sb.toString());
            }
        }
    };
    /* access modifiers changed from: private */
    public RelativeLayout dhz;

    /* renamed from: po */
    private OnClickListener f3515po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(FunnyTemplateDialogFragment.this.dhA)) {
                C6738a.m19560bM(VivaBaseApplication.m8749FZ(), "create");
                FunnyTemplateDialogFragment.this.arZ();
            } else if (view.equals(FunnyTemplateDialogFragment.this.dhB)) {
                C6738a.m19560bM(VivaBaseApplication.m8749FZ(), "more_template");
                FunnyTemplateDialogFragment.this.dismissAllowingStateLoss();
            } else if (view.equals(FunnyTemplateDialogFragment.this.dhD)) {
                C6738a.m19560bM(VivaBaseApplication.m8749FZ(), "close");
                FunnyTemplateDialogFragment.this.dismissAllowingStateLoss();
            } else if (view.equals(FunnyTemplateDialogFragment.this.dgG)) {
                if (FunnyTemplateDialogFragment.this.dhC != null) {
                    FunnyTemplateDialogFragment.this.dhC.start();
                    FunnyTemplateDialogFragment.this.dgG.setVisibility(8);
                }
            } else if (view.equals(FunnyTemplateDialogFragment.this.dhz) && FunnyTemplateDialogFragment.this.dhC != null) {
                FunnyTemplateDialogFragment.this.dgG.setVisibility(0);
                FunnyTemplateDialogFragment.this.dhC.pause();
            }
        }
    };
    /* access modifiers changed from: private */
    public String templateId;

    private void arA() {
        C8705e.m25369gZ(VivaBaseApplication.m8749FZ()).mo35081b(this.templateId, this.dhE, this.dhG, asa());
    }

    private void arW() {
        String valueOf = String.valueOf(QTemplateIDUtils.getTemplateType(C2575a.m7391rq(this.templateId)));
        String bn = C8450a.m24469bn(C2575a.m7391rq(this.templateId));
        TemplateInfo Z = C8735f.aMf().mo35140Z(VivaBaseApplication.m8749FZ(), valueOf, bn);
        if (Z != null) {
            this.csh = Z.strPreviewurl;
            this.dhG = Z.strUrl;
            arY();
            return;
        }
        C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ITEM_INFO, (C8354a) new C8354a() {
            /* renamed from: a */
            public void mo23009a(Context context, String str, int i, Bundle bundle) {
                C68271 r2;
                RelativeLayout relativeLayout;
                C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ITEM_INFO);
                if (i == 131072) {
                    try {
                        FunnyTemplateDialogFragment.this.m19925f(new JSONObject(bundle.getString(SocialServiceDef.XIAOYING_SERVER_RESPONSE)));
                        relativeLayout = FunnyTemplateDialogFragment.this.dhA;
                        r2 = new Runnable() {
                            public void run() {
                                FunnyTemplateDialogFragment.this.arY();
                            }
                        };
                    } catch (JSONException e) {
                        e.printStackTrace();
                        relativeLayout = FunnyTemplateDialogFragment.this.dhA;
                        r2 = new Runnable() {
                            public void run() {
                                FunnyTemplateDialogFragment.this.arY();
                            }
                        };
                    } catch (Throwable th) {
                        FunnyTemplateDialogFragment.this.dhA.post(new Runnable() {
                            public void run() {
                                FunnyTemplateDialogFragment.this.arY();
                            }
                        });
                        throw th;
                    }
                    relativeLayout.post(r2);
                    return;
                }
                FunnyTemplateDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        C8346e.m24072U(VivaBaseApplication.m8749FZ(), valueOf, bn);
    }

    private void arX() {
        int ii = Constants.getScreenSize().width - (C7689a.m22599ii(84) * 2);
        LayoutParams layoutParams = this.dhz.getLayoutParams();
        layoutParams.height = (int) (((float) ii) * 1.7777778f);
        this.dhz.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void arY() {
        this.dhC.setVideoViewListener(this.dgS);
        C8705e.m25369gZ(VivaBaseApplication.m8749FZ()).mo35079a(this.dhH);
        if (!TextUtils.isEmpty(this.csh)) {
            this.dhC.setVideoURI(Uri.parse(this.csh));
        }
        m19928he(true);
    }

    /* access modifiers changed from: private */
    public void arZ() {
        int iw = this.dgR == 0 ? 8 : mo30404iw(this.templateId);
        if (iw == 1) {
            C6738a.m19555A(VivaBaseApplication.m8749FZ(), "not_downloaded", this.templateId);
            if (!BaseSocialNotify.isNetworkAvaliable(VivaBaseApplication.m8749FZ())) {
                ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_msg_network_inactive, 1);
                return;
            }
            arA();
        } else if (iw == 3) {
            C6738a.m19555A(VivaBaseApplication.m8749FZ(), "downloaded", this.templateId);
            if (getActivity() != null) {
                FunnySlideRouter.launchFunnyEdit(getActivity(), C2575a.m7391rq(this.templateId));
            }
            dismissAllowingStateLoss();
        } else if (iw == 8) {
            C8705e.m25369gZ(VivaBaseApplication.m8749FZ()).mo35083pi(this.templateId);
        }
    }

    private int asa() {
        TemplateInfo cB = C8735f.aMf().mo35146cB(VivaBaseApplication.m8749FZ(), this.templateId);
        if (cB != null) {
            return cB.nSize;
        }
        return 0;
    }

    /* renamed from: bS */
    private void m19920bS(View view) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        this.dgK = (TextView) view.findViewById(R.id.create);
        this.dhA = (RelativeLayout) view.findViewById(R.id.create_container);
        this.dhz = (RelativeLayout) view.findViewById(R.id.video_container);
        this.dhB = (RelativeLayout) view.findViewById(R.id.more_container);
        this.dhC = (VideoView) view.findViewById(R.id.video);
        this.dgG = (ImageView) view.findViewById(R.id.video_play);
        this.dhD = (ImageView) view.findViewById(R.id.close_image);
        this.dgN = (ProgressBar) view.findViewById(R.id.download_progress);
        this.dgH = (RelativeLayout) view.findViewById(R.id.xiaoying_com_progress_video_loading);
        arX();
        this.dhA.setOnClickListener(this.f3515po);
        this.dhB.setOnClickListener(this.f3515po);
        this.dhD.setOnClickListener(this.f3515po);
        this.dgG.setOnClickListener(this.f3515po);
        this.dhz.setOnClickListener(this.f3515po);
        textView.setText(this.dhF);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m19925f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dhE = jSONObject.optString(C7234b.TAG);
            this.csh = jSONObject.optString(C4677g.TAG);
            this.dhG = jSONObject.optString("x");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: he */
    public void m19928he(boolean z) {
        if (z) {
            this.dgH.setVisibility(0);
        } else {
            this.dgH.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ph */
    public void m19933ph(int i) {
        if (i == 1 || i == 3) {
            this.dgK.setText(R.string.xiaoying_str_funny_template_create);
            this.dgK.setBackgroundResource(R.drawable.editor_shape_funny_template_detail_create);
            this.dgN.setVisibility(8);
        }
    }

    /* renamed from: iw */
    public int mo30404iw(String str) {
        TemplateItemData bD = C8762d.aMt().mo35227bD(C2575a.m7391rq(str));
        return (bD == null || bD.shouldOnlineDownload() || bD.nDelFlag == 1) ? 1 : 3;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.editor_dialog_funnytemplate, viewGroup, false);
        getDialog().setCanceledOnTouchOutside(false);
        this.templateId = C3742b.m9111II().mo23134JB();
        m19920bS(inflate);
        arW();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            C8705e.m25369gZ(getActivity().getApplicationContext()).mo35080b(this.dhH);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        if (getActivity() == null || !getActivity().isFinishing()) {
            if (this.dhC != null) {
                this.dhC.pause();
            }
        } else if (this.dhC != null) {
            this.dhC.stop();
            this.dhC = null;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.dhC != null) {
            this.dhC.setBackgroundColor(0);
            this.dhC.start();
            this.dgG.setVisibility(8);
        }
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) VivaBaseApplication.m8749FZ().getApplicationContext().getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
    }

    public void setTitle(String str) {
        this.dhF = str;
    }
}
