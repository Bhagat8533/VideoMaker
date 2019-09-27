package com.introvd.template.editor.widget.picker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import biii.aiii.aiii.p080b.C1859a;
import com.introvd.template.common.Constants;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.widget.picker.UKeyBackEditText.C7046a;
import com.introvd.template.editor.widget.picker.p293a.C7048a;
import com.introvd.template.editor.widget.picker.p293a.C7051b;
import com.introvd.template.editor.widget.picker.p293a.C7052c;
import com.introvd.template.editor.widget.picker.p293a.C7053d;
import com.introvd.template.editor.widget.picker.p294b.C7059a;
import com.introvd.template.explorer.C7134a;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.utils.C8545d;
import com.introvd.template.template.p404d.C8651b;
import com.introvd.template.template.p404d.C8652c;
import com.introvd.template.template.p404d.C8653d;
import com.introvd.template.template.p404d.C8654e;
import com.introvd.template.template.p408f.C8750d;
import com.introvd.template.videoeditor.model.BROWSE_TYPE;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.p131c.p132a.p134b.C2571a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class EditorGalleryBoard extends RelativeLayout {
    public static final int dqj = C4583d.m11671P(44.0f);
    private RelativeLayout bHu;
    /* access modifiers changed from: private */
    public boolean blp;
    private RelativeLayout bof;
    private int dqA;
    private int dqB;
    private int dqC;
    private boolean dqD;
    private boolean dqE;
    private boolean dqF;
    /* access modifiers changed from: private */
    public C8654e dqG;
    /* access modifiers changed from: private */
    public C8651b dqH;
    /* access modifiers changed from: private */
    public C7043b dqI;
    /* access modifiers changed from: private */
    public String dqJ;
    /* access modifiers changed from: private */
    public List<String> dqK;
    /* access modifiers changed from: private */
    public HashMap<String, String> dqL;
    private C7042a dqM;
    /* access modifiers changed from: private */
    public C7059a dqN;
    private boolean dqO;
    /* access modifiers changed from: private */
    public C7045d dqi;
    private RelativeLayout dqk;
    private RelativeLayout dql;
    private RelativeLayout dqm;
    /* access modifiers changed from: private */
    public RecyclerView dqn;
    private RecyclerView dqo;
    /* access modifiers changed from: private */
    public RecyclerView dqp;
    private ImageButton dqq;
    /* access modifiers changed from: private */
    public UKeyBackEditText dqr;
    /* access modifiers changed from: private */
    public LinearLayout dqs;
    private C7053d dqt;
    /* access modifiers changed from: private */
    public C7048a dqu;
    private C7053d dqv;
    private C7044c dqw;
    private C7044c dqx;
    /* access modifiers changed from: private */
    public C7149c dqy;
    /* access modifiers changed from: private */
    public boolean dqz;

    /* renamed from: com.introvd.template.editor.widget.picker.EditorGalleryBoard$a */
    private class C7042a extends ExAsyncTask<Object, Void, String> {
        private C7042a() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(Object... objArr) {
            String str;
            String str2 = objArr[0];
            EditorGalleryBoard.this.dqK.add(str2);
            try {
                Process.setThreadPriority(0);
                str = C8750d.m25573jM(str2) ? str2 : C8545d.m24986e(str2, EditorGalleryBoard.this.dqJ, false);
                try {
                    EditorGalleryBoard.this.dqK.remove(str2);
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    if (!EditorGalleryBoard.this.dqL.containsKey(str2)) {
                        EditorGalleryBoard.this.dqL.put(str2, str);
                    }
                    return str;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return str;
                }
            } catch (Exception e2) {
                e = e2;
                str = null;
                e.printStackTrace();
                return str;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (!TextUtils.isEmpty(str)) {
                EditorGalleryBoard.this.m20604iS(str);
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* renamed from: com.introvd.template.editor.widget.picker.EditorGalleryBoard$b */
    private static class C7043b extends Handler {
        private WeakReference<EditorGalleryBoard> dqX;

        C7043b(EditorGalleryBoard editorGalleryBoard) {
            this.dqX = new WeakReference<>(editorGalleryBoard);
        }

        public void handleMessage(Message message) {
            EditorGalleryBoard editorGalleryBoard = (EditorGalleryBoard) this.dqX.get();
            if (editorGalleryBoard != null) {
                switch (message.what) {
                    case 4097:
                        if (editorGalleryBoard.dqi == C7045d.MODE_GIF) {
                            if (editorGalleryBoard.dqs.isShown()) {
                                editorGalleryBoard.dqs.setVisibility(8);
                            }
                            if (editorGalleryBoard.dqu != null) {
                                editorGalleryBoard.dqu.mo30987bL((List) message.obj);
                                break;
                            }
                        }
                        break;
                    case 4098:
                        if (editorGalleryBoard.dqi == C7045d.MODE_GIF) {
                            if (editorGalleryBoard.dqs.isShown()) {
                                editorGalleryBoard.dqs.setVisibility(8);
                            }
                            if (editorGalleryBoard.dqu != null) {
                                editorGalleryBoard.dqu.mo30988bM((List) message.obj);
                                break;
                            }
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.widget.picker.EditorGalleryBoard$c */
    private class C7044c extends ExAsyncTask<Object, Void, C7045d> {
        private WeakReference<C7149c> dqY = null;
        private C7149c dqZ = null;

        C7044c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public C7045d doInBackground(Object... objArr) {
            Process.setThreadPriority(0);
            this.dqY = objArr[0];
            C7045d dVar = objArr[1];
            this.dqZ = new C7149c();
            if (dVar == C7045d.MODE_PIC) {
                this.dqZ.mo31610a(EditorGalleryBoard.this.getContext(), MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, BROWSE_TYPE.PHOTO);
            } else if (dVar == C7045d.MODE_VIDEO) {
                this.dqZ.mo31610a(EditorGalleryBoard.this.getContext(), MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, BROWSE_TYPE.VIDEO);
            }
            return dVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(C7045d dVar) {
            if (!EditorGalleryBoard.this.dqz) {
                if (this.dqY == null) {
                    if (this.dqZ != null) {
                        this.dqZ.unInit();
                        this.dqZ = null;
                    }
                    super.onPostExecute(dVar);
                } else if (EditorGalleryBoard.this.dqn == null || EditorGalleryBoard.this.dqp == null) {
                    if (this.dqZ != null) {
                        this.dqZ.unInit();
                        this.dqZ = null;
                    }
                    super.onPostExecute(dVar);
                } else {
                    if (EditorGalleryBoard.this.dqy != null) {
                        EditorGalleryBoard.this.dqy.unInit();
                    }
                    EditorGalleryBoard.this.dqy = this.dqZ;
                    this.dqZ = null;
                    if (dVar == C7045d.MODE_PIC || dVar == C7045d.MODE_VIDEO) {
                        EditorGalleryBoard.this.m20591b(dVar);
                    }
                    super.onPostExecute(dVar);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            if (this.dqZ != null) {
                this.dqZ.unInit();
                this.dqZ = null;
            }
            super.onCancelled();
        }
    }

    /* renamed from: com.introvd.template.editor.widget.picker.EditorGalleryBoard$d */
    public enum C7045d {
        MODE_UNKNOW,
        MODE_PIC,
        MODE_GIF,
        MODE_VIDEO
    }

    public EditorGalleryBoard(Context context) {
        this(context, null);
    }

    public EditorGalleryBoard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorGalleryBoard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dqi = C7045d.MODE_UNKNOW;
        this.dqI = new C7043b(this);
        this.dqK = new ArrayList();
        this.dqL = new HashMap<>();
        this.dqO = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditorGalleryBoard);
            this.dqD = obtainStyledAttributes.getBoolean(R.styleable.EditorGalleryBoard_picNoneItem, false);
            this.dqE = obtainStyledAttributes.getBoolean(R.styleable.EditorGalleryBoard_picFocus, false);
            this.dqF = obtainStyledAttributes.getBoolean(R.styleable.EditorGalleryBoard_topTransparent, false);
            obtainStyledAttributes.recycle();
        }
        m20581Oj();
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m20580A(boolean z, boolean z2) {
        if (this.dqN != null) {
            this.dqN.mo27985eA(z);
        }
        if (z) {
            this.dqm.setBackgroundColor(getResources().getColor(R.color.black));
            this.blp = true;
            m20585a(this.bof, this.dqA, this.dqB, 50, true, z2);
            return;
        }
        if (this.dqF) {
            this.dqm.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
        this.blp = false;
        if (this.dqi == C7045d.MODE_GIF) {
            m20600hE(false);
        }
        m20585a(this.bof, this.dqB, this.dqA, this.dqi == C7045d.MODE_GIF ? 300 : 50, false, z2);
    }

    /* renamed from: Oj */
    private void m20581Oj() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_view_collage_board, this, true);
        this.bof = (RelativeLayout) findViewById(R.id.collage_board_content);
        this.dqk = (RelativeLayout) findViewById(R.id.collage_pic_layout);
        this.dql = (RelativeLayout) findViewById(R.id.collage_gif_layout);
        this.bHu = (RelativeLayout) findViewById(R.id.collage_video_layout);
        this.dqs = (LinearLayout) findViewById(R.id.collage_loading_layout);
        this.dqn = (RecyclerView) findViewById(R.id.rc_collage_pic);
        this.dqo = (RecyclerView) findViewById(R.id.rc_collage_gif);
        this.dqp = (RecyclerView) findViewById(R.id.rc_video_pic);
        this.dqq = (ImageButton) findViewById(R.id.btn_expand);
        this.dqq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!C4580b.m11632Sf()) {
                    EditorGalleryBoard.this.m20580A(!EditorGalleryBoard.this.blp, false);
                }
            }
        });
        this.dqr = (UKeyBackEditText) findViewById(R.id.btn_search_gif);
        this.dqr.setKeyBackListener(new C7046a() {
            public void auH() {
                EditorGalleryBoard.this.m20600hE(true);
            }
        });
        this.dqm = (RelativeLayout) findViewById(R.id.board_top);
        this.dqm.measure(0, 0);
        if (this.dqF) {
            this.dqm.setBackgroundColor(getResources().getColor(R.color.transparent));
        } else {
            this.dqm.setBackgroundColor(getResources().getColor(R.color.black));
        }
        this.dqC = this.dqm.getMeasuredHeight();
        this.dqB = (Constants.getScreenSize().height - dqj) - this.dqC;
        auC();
        this.dqG = C8654e.aKD();
        ams();
    }

    /* renamed from: a */
    private ValueAnimator m20582a(final ViewGroup viewGroup, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                View childAt = viewGroup.getChildAt(1);
                View childAt2 = viewGroup.getChildAt(2);
                View childAt3 = viewGroup.getChildAt(3);
                if (childAt != null) {
                    LayoutParams layoutParams = childAt.getLayoutParams();
                    layoutParams.height = intValue;
                    childAt.setLayoutParams(layoutParams);
                }
                if (childAt2 != null) {
                    LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    layoutParams2.height = intValue;
                    childAt2.setLayoutParams(layoutParams2);
                }
                if (childAt3 != null) {
                    LayoutParams layoutParams3 = childAt3.getLayoutParams();
                    layoutParams3.height = intValue;
                    childAt3.setLayoutParams(layoutParams3);
                }
            }
        });
        return ofInt;
    }

    /* renamed from: a */
    private void m20585a(ViewGroup viewGroup, int i, int i2, int i3, final boolean z, final boolean z2) {
        ValueAnimator a = m20582a(viewGroup, i, i2);
        a.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    if (EditorGalleryBoard.this.dqi == C7045d.MODE_GIF) {
                        EditorGalleryBoard.this.dqI.postDelayed(new Runnable() {
                            public void run() {
                                EditorGalleryBoard.this.m20601hF(z2);
                            }
                        }, 200);
                    }
                    EditorGalleryBoard.this.setArrowUpOrDown(false);
                    return;
                }
                if (EditorGalleryBoard.this.dqi == C7045d.MODE_GIF) {
                    EditorGalleryBoard.this.dqr.clearFocus();
                    EditorGalleryBoard.this.dqr.setFocusable(false);
                }
                EditorGalleryBoard.this.setArrowUpOrDown(true);
            }
        });
        a.setStartDelay((long) i3);
        a.start();
    }

    private void ams() {
        C10021c.aZH().mo38494ax(this);
        this.dqr.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!EditorGalleryBoard.this.blp) {
                    EditorGalleryBoard.this.m20580A(true, true);
                } else {
                    EditorGalleryBoard.this.m20601hF(true);
                }
                return false;
            }
        });
        this.dqH = new C8651b() {
            /* renamed from: a */
            public void mo27626a(C8653d dVar) {
            }

            /* renamed from: aG */
            public void mo27627aG(List<C8653d> list) {
                EditorGalleryBoard.this.dqI.sendMessage(EditorGalleryBoard.this.dqI.obtainMessage(4097, list));
            }

            /* renamed from: cm */
            public void mo27628cm(int i, int i2) {
            }
        };
        this.dqr.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (EditorGalleryBoard.this.dqN != null) {
                        EditorGalleryBoard.this.dqN.afp();
                    }
                    EditorGalleryBoard.this.m20600hE(false);
                    if (C4600l.m11739k(EditorGalleryBoard.this.getContext(), true)) {
                        if (EditorGalleryBoard.this.dqu != null) {
                            EditorGalleryBoard.this.dqu.mo30989qd(1002);
                        }
                        EditorGalleryBoard.this.dqG.aKB();
                        Editable text = EditorGalleryBoard.this.dqr.getText();
                        String obj = text == null ? "" : text.toString();
                        if (!TextUtils.isEmpty(obj) && obj.length() > 0) {
                            if (!EditorGalleryBoard.this.dqs.isShown()) {
                                EditorGalleryBoard.this.dqs.setVisibility(0);
                            }
                            EditorGalleryBoard.this.dqG.mo34947a(obj, (C8651b) new C8651b() {
                                /* renamed from: a */
                                public void mo27626a(C8653d dVar) {
                                }

                                /* renamed from: aG */
                                public void mo27627aG(List<C8653d> list) {
                                    EditorGalleryBoard.this.dqI.sendMessage(EditorGalleryBoard.this.dqI.obtainMessage(4098, list));
                                }

                                /* renamed from: cm */
                                public void mo27628cm(int i, int i2) {
                                }
                            });
                        }
                    } else {
                        ToastUtils.show(EditorGalleryBoard.this.getContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
                    }
                }
                return false;
            }
        });
        this.dqr.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ((TextUtils.isEmpty(charSequence) || charSequence.length() == 0) && EditorGalleryBoard.this.dqu != null) {
                    EditorGalleryBoard.this.dqu.mo30989qd(1001);
                }
            }
        });
    }

    private void auC() {
        this.dqt = new C7053d(getContext(), this.dqD, this.dqE, this.dqO);
        this.dqt.mo30992a((C7052c) new C7052c() {
            public void auI() {
                if (EditorGalleryBoard.this.dqN != null) {
                    EditorGalleryBoard.this.dqN.afn();
                }
            }

            public void auJ() {
                if (EditorGalleryBoard.this.dqN != null) {
                    EditorGalleryBoard.this.dqN.afo();
                }
                EditorRouter.launchLocalFileAlbumActivity(EditorGalleryBoard.this.getContext(), 2);
            }

            /* renamed from: iT */
            public void mo30963iT(String str) {
                if (EditorGalleryBoard.this.blp) {
                    EditorGalleryBoard.this.m20580A(false, false);
                }
                EditorGalleryBoard.this.m20603iR(str);
            }
        });
        this.dqv = new C7053d(getContext(), this.dqD, this.dqE, this.dqO);
        this.dqv.mo30992a((C7052c) new C7052c() {
            public void auI() {
                if (EditorGalleryBoard.this.dqN != null) {
                    EditorGalleryBoard.this.dqN.afn();
                }
            }

            public void auJ() {
                if (EditorGalleryBoard.this.dqN != null) {
                    EditorGalleryBoard.this.dqN.afo();
                }
                EditorRouter.launchLocalFileAlbumActivity(EditorGalleryBoard.this.getContext(), 1);
            }

            /* renamed from: iT */
            public void mo30963iT(String str) {
                if (EditorGalleryBoard.this.blp) {
                    EditorGalleryBoard.this.m20580A(false, false);
                }
                EditorGalleryBoard.this.m20603iR(str);
            }
        });
        this.dqu = new C7048a(getContext());
        this.dqu.mo30986a((C7051b) new C7051b() {
            /* renamed from: a */
            public void mo30964a(final int i, C8653d dVar) {
                EditorGalleryBoard.this.dqG.mo34945a(EditorGalleryBoard.this.getContext(), dVar, new C8652c() {
                    public void auK() {
                        EditorGalleryBoard.this.dqI.post(new Runnable() {
                            public void run() {
                                EditorGalleryBoard.this.dqu.notifyItemChanged(i);
                            }
                        });
                    }

                    /* renamed from: iV */
                    public void mo30967iV(String str) {
                        EditorGalleryBoard.this.dqI.post(new Runnable() {
                            public void run() {
                                EditorGalleryBoard.this.dqu.notifyItemChanged(i);
                            }
                        });
                    }

                    public void onStart() {
                    }

                    /* renamed from: q */
                    public void mo30969q(int i, String str) {
                    }
                }, EditorGalleryBoard.this.dqI);
            }

            /* renamed from: iU */
            public void mo30965iU(String str) {
                if (EditorGalleryBoard.this.blp) {
                    EditorGalleryBoard.this.m20580A(false, false);
                }
                EditorGalleryBoard.this.m20603iR(str);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.dqn.setLayoutManager(gridLayoutManager);
        this.dqn.setAdapter(this.dqt);
        this.dqn.mo7733a((C1018h) new C7058b(getContext().getResources().getDimensionPixelSize(R.dimen.video_editor_collage_pic_space) / 2));
        this.dqp.setLayoutManager(new GridLayoutManager(getContext(), 5));
        this.dqp.setAdapter(this.dqv);
        this.dqp.mo7733a((C1018h) new C7058b(getContext().getResources().getDimensionPixelSize(R.dimen.video_editor_collage_pic_space) / 2));
        this.dqo.setLayoutManager(staggeredGridLayoutManager);
        this.dqo.setAdapter(this.dqu);
        this.dqo.mo7733a((C1018h) new C7058b(getContext().getResources().getDimensionPixelSize(R.dimen.video_editor_collage_gif_space) / 2));
        this.dqo.mo7737a((C1022l) new C2571a() {
            public void auG() {
                super.auG();
                if (EditorGalleryBoard.this.dqG != null) {
                    EditorGalleryBoard.this.dqG.mo34946a(EditorGalleryBoard.this.dqH);
                }
            }

            /* renamed from: d */
            public void mo8096d(RecyclerView recyclerView, int i) {
                super.mo8096d(recyclerView, i);
                if (EditorGalleryBoard.this.blp && i == 1) {
                    EditorGalleryBoard.this.m20600hE(true);
                }
            }
        });
    }

    private void auD() {
        if (this.dqM != null) {
            this.dqK.clear();
            this.dqM.cancel(true);
        }
        if (this.blp) {
            this.blp = false;
            auE();
            setArrowUpOrDown(true);
        }
        this.dqr.clearFocus();
        this.dqr.setFocusable(false);
    }

    private void auE() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqk.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dql.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.bHu.getLayoutParams();
        layoutParams.height = this.dqA;
        layoutParams2.height = this.dqA;
        layoutParams3.height = this.dqA;
        this.dqk.setLayoutParams(layoutParams);
        this.dql.setLayoutParams(layoutParams2);
        this.bHu.setLayoutParams(layoutParams3);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20591b(C7045d dVar) {
        if (this.dqy != null) {
            if (this.dqt == null) {
                auC();
            }
            MediaGroupItem awy = this.dqy.awy();
            if (awy != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = awy.getMediaItemList().iterator();
                while (it.hasNext()) {
                    ExtMediaItem extMediaItem = (ExtMediaItem) it.next();
                    if (!TextUtils.isEmpty(extMediaItem.path)) {
                        arrayList.add(new C7047a(0, extMediaItem.path, false));
                    }
                }
                if (dVar == C7045d.MODE_PIC) {
                    this.dqt.setData(arrayList);
                } else if (dVar == C7045d.MODE_VIDEO) {
                    this.dqv.setData(arrayList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hE */
    public void m20600hE(boolean z) {
        C1859a.m5362br(this.dqr);
        if (z) {
            this.dqr.clearFocus();
            this.dqr.setFocusable(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hF */
    public void m20601hF(boolean z) {
        this.dqr.setFocusable(true);
        this.dqr.setFocusableInTouchMode(true);
        if (z) {
            this.dqr.requestFocus();
            this.dqr.findFocus();
            C1859a.showKeyboard(this.dqr);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iR */
    public void m20603iR(String str) {
        if (!this.dqL.containsKey(str) && !this.dqK.contains(str)) {
            this.dqM = new C7042a();
            try {
                this.dqM.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.dqL.containsKey(str)) {
            m20604iS((String) this.dqL.get(str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iS */
    public void m20604iS(String str) {
        if (this.dqN != null) {
            this.dqN.mo27986gI(str);
        }
    }

    /* renamed from: a */
    public void mo30946a(C7045d dVar) {
        if (this.dqi != dVar) {
            this.dqi = dVar;
            switch (dVar) {
                case MODE_PIC:
                    if (this.dqs.isShown()) {
                        this.dqs.setVisibility(8);
                    }
                    this.dql.setVisibility(8);
                    this.bHu.setVisibility(8);
                    this.dqk.setVisibility(0);
                    m20600hE(true);
                    this.dqw = new C7044c();
                    this.dqw.execute((Params[]) new Object[]{new WeakReference(this.dqy), dVar});
                    break;
                case MODE_VIDEO:
                    if (this.dqs.isShown()) {
                        this.dqs.setVisibility(8);
                    }
                    this.dqk.setVisibility(8);
                    this.dql.setVisibility(8);
                    this.bHu.setVisibility(0);
                    m20600hE(true);
                    this.dqx = new C7044c();
                    this.dqx.execute((Params[]) new Object[]{new WeakReference(this.dqy), dVar});
                    break;
                case MODE_GIF:
                    this.bHu.setVisibility(8);
                    this.dqk.setVisibility(8);
                    this.dql.setVisibility(0);
                    if (this.blp) {
                        m20601hF(true);
                    }
                    if (this.dqG != null && this.dqu != null && this.dqu.getItemCount() == 0 && C4600l.m11739k(getContext(), true)) {
                        if (!this.dqs.isShown()) {
                            this.dqs.setVisibility(0);
                        }
                        this.dqG.mo34946a(this.dqH);
                        break;
                    }
            }
        }
    }

    /* renamed from: a */
    public void mo30947a(C7045d dVar, boolean z) {
        mo30946a(dVar);
        this.dqO = z;
    }

    public void auF() {
        clearAnimation();
        C10021c.aZH().mo38496az(this);
        this.dqz = true;
        if (this.dqw != null) {
            this.dqw.cancel(true);
        }
        if (this.dqx != null) {
            this.dqx.cancel(true);
        }
        if (this.dqM != null) {
            this.dqM.cancel(true);
        }
        if (this.dqy != null) {
            this.dqy.unInit();
            this.dqy = null;
        }
    }

    /* renamed from: hD */
    public void mo30949hD(boolean z) {
        if (this.dqt != null) {
            this.dqt.mo30994hG(z);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onFileChooseEvent(C7134a aVar) {
        if (this.blp) {
            m20580A(false, false);
        }
        m20603iR(aVar.getFilePath());
        setFocusItem(aVar.getFilePath());
    }

    public void setArrowUpOrDown(boolean z) {
        this.dqq.setSelected(!z);
    }

    public void setBoardVisibility(int i) {
        if (i == 0) {
            if (!isShown()) {
                setVisibility(0);
                startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_in_from_bottom));
            }
        } else if (isShown()) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_out_to_bottom));
            setVisibility(8);
            auD();
        }
    }

    public void setCompressedFilePath(String str) {
        this.dqJ = str;
    }

    public void setFocusItem(String str) {
        if (this.dqt != null) {
            this.dqt.mo30995iW(str);
        }
    }

    public void setGalleryBoardListener(C7059a aVar) {
        this.dqN = aVar;
    }

    public void setNormalHeight(int i) {
        this.dqA = i - this.dqC;
        auE();
    }
}
