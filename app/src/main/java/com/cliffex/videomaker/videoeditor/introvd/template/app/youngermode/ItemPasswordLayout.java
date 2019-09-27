package com.introvd.template.app.youngermode;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;

public class ItemPasswordLayout extends RelativeLayout {
    /* access modifiers changed from: private */
    public ImageView[] bJI;
    /* access modifiers changed from: private */
    public StringBuffer bJJ;
    /* access modifiers changed from: private */
    public String bJK;
    /* access modifiers changed from: private */
    public TextView[] bJL;
    /* access modifiers changed from: private */
    public C4536a bJM;
    /* access modifiers changed from: private */
    public int count;
    /* access modifiers changed from: private */
    public EditText editText;

    /* renamed from: com.introvd.template.app.youngermode.ItemPasswordLayout$a */
    public interface C4536a {
        /* renamed from: RE */
        void mo24770RE();

        void delete();
    }

    public ItemPasswordLayout(Context context) {
        this(context, null);
    }

    public ItemPasswordLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemPasswordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJJ = new StringBuffer();
        this.count = 4;
        this.bJI = new ImageView[4];
        this.bJL = new TextView[4];
        View.inflate(context, R.layout.viva_younger_password_layout, this);
        this.editText = (EditText) findViewById(R.id.item_edittext);
        this.bJL[0] = (TextView) findViewById(R.id.item_password_tv1);
        this.bJL[1] = (TextView) findViewById(R.id.item_password_tv2);
        this.bJL[2] = (TextView) findViewById(R.id.item_password_tv3);
        this.bJL[3] = (TextView) findViewById(R.id.item_password_tv4);
        this.bJI[0] = (ImageView) findViewById(R.id.item_password_iv1);
        this.bJI[1] = (ImageView) findViewById(R.id.item_password_iv2);
        this.bJI[2] = (ImageView) findViewById(R.id.item_password_iv3);
        this.bJI[3] = (ImageView) findViewById(R.id.item_password_iv4);
        this.editText.setCursorVisible(false);
        m11447In();
    }

    /* renamed from: In */
    private void m11447In() {
        this.editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")) {
                    if (ItemPasswordLayout.this.bJJ.length() > 3) {
                        ItemPasswordLayout.this.editText.setText("");
                        return;
                    }
                    ItemPasswordLayout.this.bJJ.append(editable);
                    ItemPasswordLayout.this.editText.setText("");
                    StringBuilder sb = new StringBuilder();
                    sb.append("afterTextChanged: stringBuffer is ");
                    sb.append(ItemPasswordLayout.this.bJJ);
                    Log.e("TAG", sb.toString());
                    ItemPasswordLayout.this.count = ItemPasswordLayout.this.bJJ.length();
                    ItemPasswordLayout.this.bJK = ItemPasswordLayout.this.bJJ.toString();
                    if (ItemPasswordLayout.this.bJJ.length() == 4 && ItemPasswordLayout.this.bJM != null) {
                        ItemPasswordLayout.this.bJM.mo24770RE();
                    }
                    for (final int i = 0; i < ItemPasswordLayout.this.bJJ.length(); i++) {
                        TextView textView = ItemPasswordLayout.this.bJL[i];
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(ItemPasswordLayout.this.bJJ.charAt(i));
                        textView.setText(sb2.toString());
                        ItemPasswordLayout.this.getHandler().postDelayed(new Runnable() {
                            public void run() {
                                ItemPasswordLayout.this.bJL[i].setVisibility(8);
                                ItemPasswordLayout.this.bJI[i].setImageResource(R.drawable.app_bg_has_password);
                            }
                        }, 200);
                    }
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.editText.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    return ItemPasswordLayout.this.mo24758RD() ? true : true;
                }
                return false;
            }
        });
    }

    /* renamed from: RD */
    public boolean mo24758RD() {
        if (this.count == 0) {
            this.count = 4;
            return true;
        }
        if (this.bJJ.length() > 0) {
            this.bJJ.delete(this.count - 1, this.count);
            this.count--;
            StringBuilder sb = new StringBuilder();
            sb.append("afterTextChanged: stringBuffer is ");
            sb.append(this.bJJ);
            Log.e("TAG", sb.toString());
            this.bJK = this.bJJ.toString();
            this.bJI[this.bJJ.length()].setImageResource(R.drawable.app_bg_no_password);
            this.bJL[this.bJJ.length()].setText("");
            this.bJL[this.bJJ.length()].setVisibility(0);
            if (this.bJM != null) {
                this.bJM.delete();
            }
        }
        return false;
    }

    public void clearText() {
        for (int i = 0; i < 4; i++) {
            this.bJL[i].setText("");
            this.bJL[i].setVisibility(0);
            this.bJI[i].setImageResource(R.drawable.app_bg_no_password);
        }
        this.editText.setText("");
        this.bJK = "";
        this.bJJ = new StringBuffer();
    }

    public EditText getEditText() {
        return this.editText;
    }

    public String getStrPassword() {
        return this.bJK;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void setContent(String str) {
        this.editText.setText(str);
    }

    public void setInputCompleteListener(C4536a aVar) {
        this.bJM = aVar;
    }
}
