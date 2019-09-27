package com.introvd.template.p414ui.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.p203b.C4583d;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.b */
public class C8944b extends Dialog implements OnClickListener {

    /* renamed from: NW */
    private CheckBox f3622NW;
    private TextView aeU;
    private OnClickListener bDF;
    private RelativeLayout bua;
    private Object cqZ = Integer.valueOf(-1);
    private Object crb = Integer.valueOf(-1);
    private int evX = 15;
    private int evY = 15;
    private Object evZ = Integer.valueOf(-1);
    private Object ewa = Integer.valueOf(-1);
    private Object ewb = Integer.valueOf(-1);
    private Object ewc = Integer.valueOf(-1);
    private Object ewd = Integer.valueOf(-1);
    private boolean ewe = true;
    private TextView ewf;
    private RelativeLayout ewg;
    private TextView ewh;
    private Button ewi;
    private Button ewj;
    private Button ewk;
    private RelativeLayout ewl;
    private RelativeLayout ewm;
    private RelativeLayout ewn;
    private LinearLayout ewo;
    private RelativeLayout ewp;
    private boolean ewq;
    private ImageView ewr;
    private Object ews = Integer.valueOf(-1);
    private Object ewt = Integer.valueOf(-1);
    private Object ewu = Integer.valueOf(-1);
    private int ewv = -1;
    private int eww = -1;
    private ImageView mImgIcon;

    public C8944b(Context context, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, boolean z, OnClickListener onClickListener, boolean z2, Object obj9, Object obj10) {
        Context context2 = context;
        super(context, C10122R.style.xiaoying_style_com_dialog);
        m26305a(context, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, z, onClickListener, z2, obj9, obj10);
    }

    /* renamed from: a */
    private void m26305a(Context context, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, boolean z, OnClickListener onClickListener, boolean z2, Object obj9, Object obj10) {
        requestWindowFeature(1);
        this.cqZ = obj;
        this.evZ = obj2;
        this.crb = obj3;
        this.ewa = obj4;
        this.ewc = obj6;
        this.ewb = obj7;
        this.ewd = obj8;
        this.ewe = z;
        this.bDF = onClickListener;
        this.ewq = z2;
        this.evX = C4583d.m11670O(context, 15);
        this.evY = C4583d.m11670O(context, 12);
        this.ews = obj9;
        this.ewt = obj5;
        this.ewu = obj10;
    }

    public void onBackPressed() {
        boolean isChecked = this.f3622NW != null ? this.f3622NW.isChecked() : false;
        if (this.bDF != null) {
            if (this.ewq) {
                if (this.ewj != null) {
                    this.ewj.setTag(C10122R.C10124id.com_dialog_checkbox, Boolean.valueOf(isChecked));
                    this.ewj.setTag(C10122R.C10124id.com_dialog_layout, Boolean.valueOf(true));
                }
                this.bDF.onClick(this.ewj);
            } else if (((Integer) this.ewc).intValue() == -1) {
                if (this.ewi != null) {
                    this.ewi.setTag(C10122R.C10124id.com_dialog_checkbox, Boolean.valueOf(isChecked));
                    this.ewi.setTag(C10122R.C10124id.com_dialog_layout, Boolean.valueOf(true));
                }
                this.bDF.onClick(this.ewi);
            } else {
                if (this.ewj != null) {
                    this.ewj.setTag(C10122R.C10124id.com_dialog_checkbox, Boolean.valueOf(isChecked));
                    this.ewj.setTag(C10122R.C10124id.com_dialog_layout, Boolean.valueOf(true));
                }
                this.bDF.onClick(this.ewj);
            }
        }
    }

    public void onClick(View view) {
        if (!(view == null || this.f3622NW == null)) {
            view.setTag(C10122R.C10124id.com_dialog_checkbox, Boolean.valueOf(this.f3622NW.isChecked()));
            view.setTag(C10122R.C10124id.com_dialog_layout, Boolean.valueOf(false));
        }
        if (this.bDF != null) {
            this.bDF.onClick(view);
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"ResourceAsColor"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C10122R.C10126layout.xiaoying_com_dialog);
        this.bua = (RelativeLayout) findViewById(C10122R.C10124id.dialog_title_layout);
        this.aeU = (TextView) findViewById(C10122R.C10124id.com_dialog_txt_title);
        this.ewf = (TextView) findViewById(C10122R.C10124id.com_dialog_txt_title_second);
        this.ewg = (RelativeLayout) findViewById(C10122R.C10124id.layout_second_title);
        this.ewh = (TextView) findViewById(C10122R.C10124id.com_dialog_txt_desc);
        this.ewi = (Button) findViewById(C10122R.C10124id.com_dialog_btn_left);
        this.ewk = (Button) findViewById(C10122R.C10124id.com_dialog_btn_middle);
        this.ewj = (Button) findViewById(C10122R.C10124id.com_dialog_btn_right);
        this.ewl = (RelativeLayout) findViewById(C10122R.C10124id.com_dialog_btn_layout_left);
        this.ewm = (RelativeLayout) findViewById(C10122R.C10124id.com_dialog_btn_layout_middle);
        this.ewn = (RelativeLayout) findViewById(C10122R.C10124id.com_dialog_btn_layout_right);
        this.f3622NW = (CheckBox) findViewById(C10122R.C10124id.com_dialog_checkbox);
        this.ewp = (RelativeLayout) findViewById(C10122R.C10124id.com_dialog_layout);
        this.ewo = (LinearLayout) findViewById(C10122R.C10124id.com_dialog_btns_layout);
        this.mImgIcon = (ImageView) findViewById(C10122R.C10124id.com_dialog_img_icon);
        this.ewr = (ImageView) findViewById(C10122R.C10124id.imageview_desc);
        if (!(this.cqZ instanceof Integer) || ((Integer) this.cqZ).intValue() != -1) {
            this.bua.setVisibility(0);
            if (this.cqZ instanceof Integer) {
                this.aeU.setText(((Integer) this.cqZ).intValue());
            } else if (this.cqZ instanceof String) {
                this.aeU.setText((String) this.cqZ);
            }
        } else {
            this.bua.setVisibility(8);
        }
        if (!(this.evZ instanceof Integer) || ((Integer) this.evZ).intValue() != -1) {
            this.ewg.setVisibility(0);
            if (this.evZ instanceof Integer) {
                this.ewf.setText(((Integer) this.evZ).intValue());
            } else if (this.evZ instanceof String) {
                this.ewf.setText((String) this.evZ);
            }
        } else {
            this.ewg.setVisibility(8);
        }
        if (!(this.crb instanceof Integer) || ((Integer) this.crb).intValue() != -1) {
            this.ewh.setVisibility(0);
            if (this.crb instanceof Integer) {
                this.ewh.setText(((Integer) this.crb).intValue());
            } else if (this.crb instanceof String) {
                this.ewh.setText((String) this.crb);
            }
        } else {
            this.ewh.setVisibility(8);
        }
        if (!(this.ewa instanceof Integer) || ((Integer) this.ewa).intValue() != -1) {
            this.ewi.setTag(Integer.valueOf(0));
            this.ewl.setVisibility(0);
            this.ewi.setOnClickListener(this);
            if (this.ewa instanceof Integer) {
                this.ewi.setText(((Integer) this.ewa).intValue());
            } else if (this.ewa instanceof String) {
                this.ewi.setText((String) this.ewa);
            }
            if (this.ewq) {
                this.ewi.setTextSize((float) this.evY);
            }
            if (this.ewv != -1) {
                this.ewi.setTextColor(this.ewv);
            }
        } else {
            this.ewl.setVisibility(8);
            this.ewi.setTag(Integer.valueOf(0));
        }
        if (!(this.ewc instanceof Integer) || ((Integer) this.ewc).intValue() != -1) {
            this.ewk.setTag(Integer.valueOf(2));
            this.ewm.setVisibility(0);
            this.ewk.setOnClickListener(this);
            if (this.ewc instanceof Integer) {
                this.ewk.setText(((Integer) this.ewc).intValue());
            } else if (this.ewc instanceof String) {
                this.ewk.setText((String) this.ewc);
            }
            if (this.ewq) {
                this.ewk.setTextSize((float) this.evY);
            }
        } else {
            this.ewm.setVisibility(8);
            this.ewk.setTag(Integer.valueOf(2));
        }
        if (!(this.ewb instanceof Integer) || ((Integer) this.ewb).intValue() != -1) {
            this.ewj.setTag(Integer.valueOf(1));
            this.ewn.setVisibility(0);
            this.ewj.setOnClickListener(this);
            if (this.ewb instanceof Integer) {
                this.ewj.setText(((Integer) this.ewb).intValue());
            } else if (this.ewb instanceof String) {
                this.ewj.setText((String) this.ewb);
            }
            if (this.ewq) {
                this.ewj.setTextSize((float) this.evY);
            }
            if (this.eww != -1) {
                this.ewi.setTextColor(this.eww);
            }
        } else {
            this.ewn.setVisibility(8);
            this.ewj.setTag(Integer.valueOf(1));
        }
        if (!(this.ewd instanceof Integer) || ((Integer) this.ewd).intValue() != -1) {
            this.f3622NW.setVisibility(0);
            if (this.ewd instanceof Integer) {
                this.f3622NW.setText(((Integer) this.ewd).intValue());
            } else if (this.ewd instanceof String) {
                this.f3622NW.setText((String) this.ewd);
            }
            this.f3622NW.setEnabled(this.ewe);
        } else {
            this.f3622NW.setVisibility(8);
        }
        if (((Integer) this.ews).intValue() != -1) {
            this.mImgIcon.setVisibility(0);
            this.mImgIcon.setImageResource(((Integer) this.ews).intValue());
        } else {
            this.mImgIcon.setVisibility(8);
        }
        if (-1 != ((Integer) this.ewt).intValue()) {
            this.ewi.setBackgroundResource(((Integer) this.ewt).intValue());
            this.ewi.setTextColor(C10122R.color.black);
        }
        if (-1 != ((Integer) this.ewu).intValue()) {
            this.ewr.setVisibility(0);
            this.ewr.setImageResource(((Integer) this.ewu).intValue());
            return;
        }
        this.ewr.setVisibility(8);
    }
}
