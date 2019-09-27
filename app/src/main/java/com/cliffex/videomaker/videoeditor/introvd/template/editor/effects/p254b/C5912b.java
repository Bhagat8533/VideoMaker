package com.introvd.template.editor.effects.p254b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.support.p021v4.content.ContextCompat;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter.VisibleListener;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.utils.C8500b;
import java.util.List;

/* renamed from: com.introvd.template.editor.effects.b.b */
public class C5912b extends Dialog implements OnClickListener {
    /* access modifiers changed from: private */
    public RecyclerView cNI;
    private CustomRecyclerViewAdapter cNJ;
    /* access modifiers changed from: private */
    public int cNK;
    /* access modifiers changed from: private */
    public LinearGradient cNL;
    /* access modifiers changed from: private */
    public boolean cNM = false;
    private ImageView cNN;
    /* access modifiers changed from: private */
    public Paint mPaint;

    public C5912b(Context context) {
        super(context);
        requestWindowFeature(1);
        setContentView(R.layout.editor_effect_select_dialog_layout);
        mo28517Oj();
        setCanceledOnTouchOutside(false);
    }

    /* renamed from: Oj */
    public void mo28517Oj() {
        this.cNN = (ImageView) findViewById(R.id.close_image);
        this.cNN.setOnClickListener(this);
        this.cNI = (RecyclerView) findViewById(R.id.select_recycler_view);
        this.cNI.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.cNJ = new CustomRecyclerViewAdapter();
        this.cNJ.setOnVisibleListener(new VisibleListener() {
            public void onItemVisible(int i, BaseItem baseItem) {
                StringBuilder sb = new StringBuilder();
                sb.append("onItemVisible position = ");
                sb.append(i);
                sb.append(", baseItem = ");
                sb.append(baseItem);
                LogUtilsV2.m14227d(sb.toString());
            }
        });
        this.cNI.setAdapter(this.cNJ);
        if (VERSION.SDK_INT >= 21) {
            alh();
        }
    }

    public void alh() {
        if (this.cNI != null) {
            this.mPaint = new Paint();
            final PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(Mode.DST_IN);
            this.mPaint.setXfermode(porterDuffXfermode);
            final int color = ContextCompat.getColor(getContext(), R.color.white);
            final int color2 = ContextCompat.getColor(getContext(), R.color.color_00FFFFFF);
            this.cNI.mo7733a((C1018h) new C1018h() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                    super.getItemOffsets(rect, view, recyclerView, rVar);
                }

                @SuppressLint({"NewApi"})
                public void onDraw(Canvas canvas, RecyclerView recyclerView, C1031r rVar) {
                    super.onDraw(canvas, recyclerView, rVar);
                    C5912b.this.cNK = canvas.saveLayer(0.0f, 0.0f, (float) recyclerView.getWidth(), (float) recyclerView.getHeight(), C5912b.this.mPaint);
                }

                public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C1031r rVar) {
                    super.onDrawOver(canvas, recyclerView, rVar);
                    if (C5912b.this.cNL == null) {
                        C5912b bVar = C5912b.this;
                        LinearGradient linearGradient = new LinearGradient(0.0f, (float) (recyclerView.getHeight() - C8500b.m24591P(54.0f)), 0.0f, (float) (recyclerView.getHeight() - C8500b.m24591P(15.0f)), new int[]{color, color2}, new float[]{0.2f, 0.8f}, TileMode.CLAMP);
                        bVar.cNL = linearGradient;
                    }
                    C5912b.this.mPaint.setXfermode(porterDuffXfermode);
                    C5912b.this.mPaint.setShader(C5912b.this.cNL);
                    canvas.drawRect(0.0f, (float) (recyclerView.getHeight() - C8500b.m24591P(54.0f)), (float) recyclerView.getWidth(), (float) recyclerView.getHeight(), C5912b.this.mPaint);
                    C5912b.this.mPaint.setXfermode(null);
                    canvas.restoreToCount(C5912b.this.cNK);
                    if (!C5912b.this.cNM) {
                        C5912b.this.cNM = true;
                        C5912b.this.cNI.postInvalidate();
                    }
                }
            });
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.close_image) {
            dismiss();
        }
    }

    public void setData(List<BaseItem> list) {
        this.cNJ.setData(list);
    }

    public void showDialog() {
        Window window = getWindow();
        window.setBackgroundDrawableResource(17170445);
        LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.y = -C8500b.m24591P(101.0f);
        window.setDimAmount(0.8f);
        window.addFlags(2);
        window.setAttributes(attributes);
        show();
    }
}
