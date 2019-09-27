package com.introvd.template.common.p236ui.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.introvd.template.p203b.C4583d;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.popup.PopupMenu */
public class PopupMenu {
    private static float bRW = 40.0f;
    private static float bRX = 10.0f;

    /* renamed from: Jn */
    private View f3455Jn;
    private TextPaint aeI;
    public boolean bForceUnder;
    private WindowManager bRY;
    private ListView bRZ;
    /* access modifiers changed from: private */
    public List<MenuItem> bSa;
    private float bSb;
    /* access modifiers changed from: private */
    public OnItemSelectedListener chZ;
    private int cia;
    private int cic;
    private boolean cid;
    private int cie;
    private Context mContext;
    /* access modifiers changed from: private */
    public LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public PopupWindow mPopupWindow;
    private int mWidth;
    private int selectedIndex;

    /* renamed from: com.introvd.template.common.ui.popup.PopupMenu$OnItemSelectedListener */
    public interface OnItemSelectedListener {
        void onItemSelected(MenuItem menuItem);
    }

    /* renamed from: com.introvd.template.common.ui.popup.PopupMenu$a */
    private class C5337a extends ArrayAdapter<MenuItem> {
        private boolean cig = false;
        private int selectedIndex = 0;

        public C5337a(Context context, List<MenuItem> list, boolean z) {
            super(context, 0, list);
            this.cig = z;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C5338b bVar;
            if (view == null) {
                view = PopupMenu.this.mInflater.inflate(C10122R.C10126layout.xiaoying_com_popup_menu_list_item, null);
                bVar = new C5338b();
                bVar.cih = (DynamicLoadingImageView) view.findViewById(C10122R.C10124id.popup_item_icon);
                bVar.alJ = (TextView) view.findViewById(C10122R.C10124id.popup_item_title);
                view.setTag(bVar);
            } else {
                bVar = (C5338b) view.getTag();
            }
            MenuItem menuItem = (MenuItem) getItem(i);
            if (menuItem == null) {
                return view;
            }
            if (!TextUtils.isEmpty(menuItem.getIconUrl())) {
                bVar.cih.setImageURI(menuItem.getIconUrl());
                bVar.cih.setVisibility(0);
            } else if (menuItem.getIconResId() > 0) {
                bVar.cih.setImage(menuItem.getIconResId());
                bVar.cih.setVisibility(0);
            } else {
                bVar.cih.setVisibility(8);
            }
            bVar.alJ.setText(menuItem.getTitle());
            if (this.cig) {
                if (this.selectedIndex == i) {
                    bVar.alJ.setBackgroundColor(-1118482);
                } else {
                    bVar.alJ.setBackgroundColor(-1);
                }
                LayoutParams layoutParams = (LayoutParams) bVar.alJ.getLayoutParams();
                layoutParams.width = -1;
                bVar.alJ.setLayoutParams(layoutParams);
                bVar.alJ.setMinHeight((int) C4583d.dpToPixel(getContext(), 40.0f));
                view.setPadding(0, 0, 0, 0);
            }
            return view;
        }

        /* renamed from: jT */
        public void mo26847jT(int i) {
            this.selectedIndex = i;
        }
    }

    /* renamed from: com.introvd.template.common.ui.popup.PopupMenu$b */
    static class C5338b {
        TextView alJ;
        DynamicLoadingImageView cih;

        C5338b() {
        }
    }

    public PopupMenu(Context context) {
        this.mWidth = 200;
        this.bForceUnder = false;
        this.cid = false;
        this.selectedIndex = 0;
        this.cie = C10122R.C10123drawable.viva_india_bg_popup;
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.bRY = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.bRY.getDefaultDisplay().getMetrics(displayMetrics);
        this.bSb = displayMetrics.scaledDensity;
        this.bSa = new ArrayList();
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        this.aeI = textView.getPaint();
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setTouchInterceptor(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                PopupMenu.this.mPopupWindow.dismiss();
                return true;
            }
        });
        setContentView(this.mInflater.inflate(C10122R.C10126layout.xiaoying_com_popup_menu, null));
    }

    public PopupMenu(Context context, boolean z, int i) {
        this(context);
        this.cid = z;
        this.selectedIndex = i;
    }

    /* renamed from: WU */
    private void m14527WU() {
        this.cic = (int) (((float) this.mWidth) * this.bSb);
        if (this.cia > 0) {
            this.cic = (int) (((float) this.cia) + (this.bSb * 85.0f));
        }
        this.mPopupWindow.setWidth(this.cic);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setAnimationStyle(16973826);
        this.mPopupWindow.setBackgroundDrawable(this.mContext.getResources().getDrawable(this.cie));
    }

    /* renamed from: a */
    private static Rect m14528a(String str, Paint paint) {
        Rect rect = new Rect();
        FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.bottom - fontMetrics.top;
        float measureText = paint.measureText(str);
        rect.left = 0;
        rect.top = 0;
        rect.right = (int) measureText;
        rect.bottom = (int) f;
        return rect;
    }

    private void setContentView(View view) {
        this.f3455Jn = view;
        this.bRZ = (ListView) view.findViewById(C10122R.C10124id.popup_items);
        this.mPopupWindow.setContentView(view);
    }

    public MenuItem add(int i, String str) {
        MenuItem menuItem = new MenuItem();
        menuItem.setItemId(i);
        menuItem.setTitle(str);
        this.bSa.add(menuItem);
        this.cia = Math.max(this.cia, m14528a(str, this.aeI).width());
        return menuItem;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.chZ = onItemSelectedListener;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setWindowBg(int i) {
        this.cie = i;
    }

    public void show(View view) {
        if (this.bSa.size() != 0) {
            m14527WU();
            C5337a aVar = new C5337a(this.mContext, this.bSa, this.cid);
            if (this.cid) {
                aVar.mo26847jT(this.selectedIndex);
            }
            this.bRZ.setAdapter(aVar);
            this.bRZ.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (PopupMenu.this.chZ != null) {
                        PopupMenu.this.chZ.onItemSelected((MenuItem) PopupMenu.this.bSa.get(i));
                    }
                    PopupMenu.this.mPopupWindow.dismiss();
                }
            });
            boolean z = false;
            if (view == null) {
                this.mPopupWindow.showAtLocation(((Activity) this.mContext).getWindow().getDecorView(), 17, 0, 0);
                return;
            }
            this.f3455Jn.invalidate();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
            this.f3455Jn.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f3455Jn.measure(-2, -2);
            int size = (int) ((bRW + bRX) * this.bSb * ((float) this.bSa.size()));
            int centerX = (int) (((float) rect.centerX()) - (((float) this.cic) - (this.bSb * 59.0f)));
            if (rect.top > size) {
                z = true;
            }
            int i = (this.bForceUnder || !z) ? this.bForceUnder ? rect.bottom + 10 : rect.bottom - 20 : rect.top - size;
            this.mPopupWindow.showAtLocation(view, 8388659, centerX, i);
            return;
        }
        throw new IllegalStateException("PopupMenu#add was not called with a menu item to display.");
    }
}
