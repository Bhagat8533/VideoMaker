package com.introvd.template.editor.clipedit.trim;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.preview.p271b.C6550a;
import com.introvd.template.editor.preview.theme.duration.SeekBarDuration;
import com.introvd.template.editor.preview.theme.duration.SeekBarDuration.C6666a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.sdk.editor.cache.C8440a;
import org.greenrobot.eventbus.C10021c;
import xiaoying.engine.base.QRange;

@SuppressLint({"ViewConstructor"})
public class PicTrimOperationView extends BaseOperationView<C5831b> {
    private C8440a cCG;
    private TextView cDr;
    /* access modifiers changed from: private */
    public int cDs = 0;
    /* access modifiers changed from: private */
    public int cDt = 0;
    /* access modifiers changed from: private */
    public SeekBarDuration cDu;
    private View cze;
    /* access modifiers changed from: private */
    public ImageButton czf;
    private int startPos = 0;

    public PicTrimOperationView(Activity activity) {
        super(activity, C5831b.class);
    }

    private void aeR() {
        Terminator terminator = (Terminator) findViewById(R.id.terminator);
        terminator.setTitle((CharSequence) getContext().getResources().getString(R.string.xiaoying_str_ve_preview_mv_tab_title));
        terminator.setTerminatorListener(new C5858a() {
            public void aeW() {
                if (!PicTrimOperationView.this.aeV()) {
                    PicTrimOperationView.this.exit();
                }
            }

            public void aeX() {
                if (PicTrimOperationView.this.czf.isSelected()) {
                    C5554b.m15023aD(PicTrimOperationView.this.getContext(), "图片时长");
                }
                if (PicTrimOperationView.this.age()) {
                    int progress = PicTrimOperationView.this.cDu.getProgress();
                    int oL = PicTrimOperationView.this.cDu.mo30053oL(PicTrimOperationView.this.cDs);
                    if (!(PicTrimOperationView.this.getVideoOperator() == null || progress == oL)) {
                        PicTrimOperationView.this.getVideoOperator().setAutoPlayWhenReady(true);
                    }
                }
                PicTrimOperationView.this.exit();
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean aeV() {
        if (!aeA() || getActivity() == null) {
            return false;
        }
        String string = getActivity().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getActivity(), getContext().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                PicTrimOperationView.this.exit();
            }
        }).mo10313qu().show();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean age() {
        if (getEditor() == null || this.cCG == null || !aeA()) {
            return false;
        }
        boolean isSelected = this.czf.isSelected();
        ((C5831b) this.cyD).mo27884a(C6312c.CLIP_PIC_TRIM, isSelected, true);
        if (((C5831b) getEditor()).mo28177i(((C5831b) getEditor()).getFocusIndex(), (int) (this.cDu.mo30054oM(this.cDu.getProgress()) * 1000.0f), isSelected)) {
            if (isSelected) {
                C10021c.aZH().mo38492aA(new C6550a(2));
            } else {
                C10021c.aZH().mo38492aA(new C6550a(1, ((C5831b) this.cyD).aeK()));
            }
            C6293a.anj().ann();
            ((C5831b) getEditor()).adL().mo34669jt(true);
            return true;
        }
        C6293a.anj().anm();
        return false;
    }

    public boolean aeA() {
        return this.czf.isSelected() || this.cDs != ((int) (this.cDu.mo30054oM(this.cDu.getProgress()) * 1000.0f));
    }

    public void aex() {
        super.aex();
        this.cDu = (SeekBarDuration) findViewById(R.id.pic_trim_seekbar_duration);
        this.cCG = ((C5831b) getEditor()).mo27893lf(((C5831b) getEditor()).getFocusIndex());
        if (!(getEditor() == null || this.cCG == null)) {
            QRange aHT = this.cCG.aHT();
            if (aHT != null) {
                this.cDs = aHT.get(1);
            }
        }
        this.cze = findViewById(R.id.apply_all_layout);
        this.czf = (ImageButton) findViewById(R.id.apply_all_btn);
        this.cDr = (TextView) findViewById(R.id.apply_all_tv);
        this.cDr.setText(getResources().getString(R.string.xiaoying_str_ve_clipedit_apply_to_all_photo_clips));
        this.cze.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PicTrimOperationView.this.czf.setSelected(!PicTrimOperationView.this.czf.isSelected());
            }
        });
        this.cDu.setProgress(this.cDu.mo30053oL(this.cDs));
        this.cDu.setTvDuration(this.cDu.mo30053oL(this.cDs));
        aeR();
        this.cDu.setOnSeekBarChangeListener(new C6666a() {
            public void agf() {
            }

            public void agg() {
                PicTrimOperationView.this.cDt = PicTrimOperationView.this.cDu.getProgress();
            }

            public void agh() {
                int progress = PicTrimOperationView.this.cDu.getProgress();
                if (progress != PicTrimOperationView.this.cDt && PicTrimOperationView.this.getEditor() != null) {
                    ((C5831b) PicTrimOperationView.this.getEditor()).aeb();
                    ((C5831b) PicTrimOperationView.this.getEditor()).mo27868b(0, (int) (PicTrimOperationView.this.cDu.mo30054oM(progress) * 1000.0f), true, 0);
                }
            }
        });
        if (this.cCG != null && this.cCG.aHT() != null) {
            this.startPos = this.cCG.aHT().get(0);
        }
    }

    public void aez() {
        super.aez();
        ((C5831b) getEditor()).mo27868b(0, this.cDs, false, 0);
    }

    public int getLayoutId() {
        return R.layout.editor_clip_pic_trim_layout;
    }

    public int getPlayerInitTime() {
        return this.startPos;
    }

    public int getStreamType() {
        return 1;
    }
}
