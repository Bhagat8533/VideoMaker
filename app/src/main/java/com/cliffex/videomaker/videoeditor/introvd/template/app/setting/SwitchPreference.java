package com.introvd.template.app.setting;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.introvd.template.common.p236ui.Switch;

public class SwitchPreference extends CheckBoxPreference implements OnTouchListener, OnCheckedChangeListener {
    private C4316a bDb;
    LayoutInflater mInflater;

    /* renamed from: com.introvd.template.app.setting.SwitchPreference$a */
    public interface C4316a {
        /* renamed from: PF */
        boolean mo24369PF();
    }

    public SwitchPreference(Context context) {
        super(context);
        this.mInflater = LayoutInflater.from(context);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInflater = LayoutInflater.from(context);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInflater = LayoutInflater.from(context);
    }

    public View getView(View view, ViewGroup viewGroup) {
        View view2 = super.getView(view, viewGroup);
        Switch switchR = (Switch) view2.findViewById(16908289);
        if (switchR != null) {
            switchR.setOnTouchListener(this);
            switchR.setOnCheckedChangeListener(this);
            if (switchR.isEnabled()) {
                switchR.setAlpha(255);
            } else {
                switchR.setAlpha(50);
            }
        }
        return view2;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        setChecked(z);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.bDb != null && this.bDb.mo24369PF();
    }
}
