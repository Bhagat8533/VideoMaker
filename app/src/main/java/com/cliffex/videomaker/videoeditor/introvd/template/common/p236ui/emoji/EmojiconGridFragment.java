package com.introvd.template.common.p236ui.emoji;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import com.introvd.template.common.FragmentBase;
import java.util.Arrays;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.emoji.EmojiconGridFragment */
public class EmojiconGridFragment extends FragmentBase implements OnItemClickListener {
    private boolean chD = false;
    private OnEmojiconClickedListener chG;
    private Emojicon[] chH;

    /* renamed from: com.introvd.template.common.ui.emoji.EmojiconGridFragment$OnEmojiconClickedListener */
    public interface OnEmojiconClickedListener {
        void onDelBtnClicked();

        void onEmojiconClicked(Emojicon emojicon);
    }

    /* renamed from: com.introvd.template.common.ui.emoji.EmojiconGridFragment$a */
    class C5330a extends ArrayAdapter<Emojicon> {
        private boolean chD = false;

        /* renamed from: com.introvd.template.common.ui.emoji.EmojiconGridFragment$a$a */
        class C5331a {
            EmojiconTextView chJ;

            C5331a() {
            }
        }

        public C5330a(Context context, Emojicon[] emojiconArr, boolean z) {
            super(context, C10122R.C10126layout.xiaoying_emoji_icon_item, emojiconArr);
            this.chD = z;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), C10122R.C10126layout.xiaoying_emoji_icon_item, null);
                C5331a aVar = new C5331a();
                aVar.chJ = (EmojiconTextView) view.findViewById(C10122R.C10124id.emojicon_icon);
                aVar.chJ.setUseSystemDefault(this.chD);
                view.setTag(aVar);
            }
            Emojicon emojicon = (Emojicon) getItem(i);
            C5331a aVar2 = (C5331a) view.getTag();
            if (emojicon.getIcon() != 0) {
                Drawable drawable = getContext().getResources().getDrawable(emojicon.getIcon());
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                if (VERSION.SDK_INT >= 17) {
                    aVar2.chJ.setCompoundDrawablesRelative(drawable, null, null, null);
                } else {
                    aVar2.chJ.setCompoundDrawables(drawable, null, null, null);
                }
            } else {
                aVar2.chJ.setText(emojicon.getEmoji());
            }
            return view;
        }
    }

    protected static EmojiconGridFragment newInstance(Emojicon[] emojiconArr) {
        return newInstance(emojiconArr, false);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.introvd.template.common.ui.emoji.Emojicon[], java.io.Serializable] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.introvd.template.common.ui.emoji.Emojicon[], code=null, for r3v0, types: [com.introvd.template.common.ui.emoji.Emojicon[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.introvd.template.common.p236ui.emoji.EmojiconGridFragment newInstance(com.introvd.template.common.p236ui.emoji.Emojicon[] r3, boolean r4) {
        /*
            com.introvd.template.common.ui.emoji.EmojiconGridFragment r0 = new com.introvd.template.common.ui.emoji.EmojiconGridFragment
            r0.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "emojicons"
            r1.putSerializable(r2, r3)
            java.lang.String r3 = "useSystemDefaults"
            r1.putBoolean(r3, r4)
            r0.setArguments(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.p236ui.emoji.EmojiconGridFragment.newInstance(com.introvd.template.common.ui.emoji.Emojicon[], boolean):com.introvd.template.common.ui.emoji.EmojiconGridFragment");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnEmojiconClickedListener) {
            this.chG = (OnEmojiconClickedListener) activity;
        } else if (getParentFragment() instanceof OnEmojiconClickedListener) {
            this.chG = (OnEmojiconClickedListener) getParentFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C10122R.C10126layout.xiaoying_emoji_icon_grid, viewGroup, false);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.chG != null) {
            Emojicon emojicon = (Emojicon) adapterView.getItemAtPosition(i);
            if (emojicon.isDelBtn()) {
                this.chG.onDelBtnClicked();
            } else {
                this.chG.onEmojiconClicked(emojicon);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.introvd.template.common.ui.emoji.Emojicon[], java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0, types: [com.introvd.template.common.ui.emoji.Emojicon[], java.io.Serializable]
      assigns: [com.introvd.template.common.ui.emoji.Emojicon[]]
      uses: [java.io.Serializable]
      mth insns count: 5
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSaveInstanceState(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onSaveInstanceState(r3)
            java.lang.String r0 = "emojicons"
            com.introvd.template.common.ui.emoji.Emojicon[] r1 = r2.chH
            r3.putSerializable(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.p236ui.emoji.EmojiconGridFragment.onSaveInstanceState(android.os.Bundle):void");
    }

    public void onViewCreated(View view, Bundle bundle) {
        GridView gridView = (GridView) view.findViewById(C10122R.C10124id.Emoji_GridView);
        gridView.setSelector(new ColorDrawable(0));
        Bundle arguments = getArguments();
        if (arguments == null) {
            this.chH = EmojiData.DATA1;
            this.chD = false;
        } else {
            Object[] objArr = (Object[]) getArguments().getSerializable("emojicons");
            this.chH = (Emojicon[]) Arrays.asList(objArr).toArray(new Emojicon[objArr.length]);
            this.chD = arguments.getBoolean("useSystemDefaults");
        }
        gridView.setAdapter(new C5330a(view.getContext(), this.chH, this.chD));
        gridView.setOnItemClickListener(this);
    }

    public void setmOnEmojiconClickedListener(OnEmojiconClickedListener onEmojiconClickedListener) {
        this.chG = onEmojiconClickedListener;
    }
}
