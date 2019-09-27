package com.introvd.template.editor.effects.p254b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;

/* renamed from: com.introvd.template.editor.effects.b.d */
public class C5917d extends BaseItem {
    private int cNV = -1;
    /* access modifiers changed from: private */
    public C5911a cNW;
    private String text = "defaultText";

    public C5917d(Context context, C8441b bVar) {
        super(context, bVar);
    }

    /* renamed from: a */
    public void mo28524a(C5911a aVar) {
        this.cNW = aVar;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.editor_effect_select_recycle_text_item;
    }

    /* access modifiers changed from: protected */
    public int getSpanSize() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        final C8441b bVar = (C8441b) getItemData();
        if (bVar != null && bVar.aIg() != null) {
            ScaleRotateViewState aIg = bVar.aIg();
            if (aIg.mTextBubbleInfo != null) {
                TextBubble dftTextBubble = aIg.mTextBubbleInfo.getDftTextBubble();
                if (dftTextBubble != null) {
                    this.text = dftTextBubble.mText;
                    this.cNV = dftTextBubble.mTextColor;
                    TextView textView = (TextView) baseHolder.findViewById(R.id.item_text);
                    textView.setText(this.text);
                    textView.setTextColor(this.cNV);
                    textView.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            if (C5917d.this.cNW != null) {
                                C5917d.this.cNW.mo28516cB(2002, bVar.aId());
                            }
                        }
                    });
                }
            }
        }
    }
}
