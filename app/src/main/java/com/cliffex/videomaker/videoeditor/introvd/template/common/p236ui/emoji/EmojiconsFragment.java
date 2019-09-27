package com.introvd.template.common.p236ui.emoji;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentStatePagerAdapter;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.common.p236ui.emoji.EmojiconGridFragment.OnEmojiconClickedListener;
import com.introvd.template.p203b.C4583d;
import java.util.Arrays;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.emoji.EmojiconsFragment */
public class EmojiconsFragment extends FragmentBase {
    private static float bKM = -1.0f;
    private OnEmojiconClickedListener chG;
    private OnEmojiconBackspaceClickedListener chQ;
    private C5333a chR;
    private int chS = 0;
    private LinearLayout chT;
    private XYViewPager chU;

    /* renamed from: com.introvd.template.common.ui.emoji.EmojiconsFragment$OnEmojiconBackspaceClickedListener */
    public interface OnEmojiconBackspaceClickedListener {
    }

    /* renamed from: com.introvd.template.common.ui.emoji.EmojiconsFragment$a */
    private static class C5333a extends FragmentStatePagerAdapter {
        private List<EmojiconGridFragment> bVk;

        public C5333a(FragmentManager fragmentManager, List<EmojiconGridFragment> list) {
            super(fragmentManager);
            this.bVk = list;
        }

        /* renamed from: a */
        public void mo26820a(OnEmojiconClickedListener onEmojiconClickedListener) {
            for (EmojiconGridFragment emojiconGridFragment : this.bVk) {
                emojiconGridFragment.setmOnEmojiconClickedListener(onEmojiconClickedListener);
            }
        }

        public int getCount() {
            return this.bVk.size();
        }

        public Fragment getItem(int i) {
            return (Fragment) this.bVk.get(i);
        }
    }

    /* renamed from: Zz */
    private void m14518Zz() {
        this.chT.removeAllViews();
        int dpFloatToPixel = dpFloatToPixel(getActivity(), 4.0f);
        for (int i = 0; i < this.chR.getCount(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(C10122R.C10123drawable.v4_xiaoying_com_emoji_selector);
            LayoutParams layoutParams = new LayoutParams(dpFloatToPixel, dpFloatToPixel);
            if (i > 0) {
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(C4583d.m11670O(getActivity(), 6));
                } else {
                    layoutParams.leftMargin = C4583d.m11670O(getActivity(), 6);
                }
            }
            imageView.setEnabled(false);
            this.chT.addView(imageView, layoutParams);
        }
        this.chS = 0;
        m14520jS(this.chS);
    }

    public static int dpFloatToPixel(Context context, float f) {
        return (int) (dpToPixel(context, f) + 0.5f);
    }

    public static synchronized float dpToPixel(Context context, float f) {
        float f2;
        synchronized (EmojiconsFragment.class) {
            if (bKM < 0.0f) {
                bKM = context.getResources().getDisplayMetrics().density;
            }
            f2 = bKM * f;
        }
        return f2;
    }

    /* access modifiers changed from: private */
    /* renamed from: jS */
    public void m14520jS(int i) {
        if (i >= 0 && i <= this.chT.getChildCount() - 1) {
            this.chT.getChildAt(this.chS).setSelected(false);
            this.chT.getChildAt(i).setSelected(true);
            this.chS = i;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof OnEmojiconBackspaceClickedListener) {
            this.chQ = (OnEmojiconBackspaceClickedListener) getActivity();
        } else if (getParentFragment() instanceof OnEmojiconBackspaceClickedListener) {
            this.chQ = (OnEmojiconBackspaceClickedListener) getParentFragment();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            getArguments().getBoolean("useSystemDefaults");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C10122R.C10126layout.xiaoying_emoji_icons, viewGroup, false);
        this.chU = (XYViewPager) inflate.findViewById(C10122R.C10124id.emojis_pager);
        this.chT = (LinearLayout) inflate.findViewById(C10122R.C10124id.bottom_layout);
        this.chR = new C5333a(getFragmentManager(), Arrays.asList(new EmojiconGridFragment[]{EmojiconGridFragment.newInstance(EmojiData.DATA1), EmojiconGridFragment.newInstance(EmojiData.DATA2), EmojiconGridFragment.newInstance(EmojiData.DATA3), EmojiconGridFragment.newInstance(EmojiData.DATA4)}));
        if (this.chG != null) {
            this.chR.mo26820a(this.chG);
        }
        this.chU.setAdapter(this.chR);
        m14518Zz();
        this.chU.setCurrentItem(0, false);
        this.chU.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                EmojiconsFragment.this.m14520jS(i);
            }
        });
        return inflate;
    }

    public void onDetach() {
        this.chQ = null;
        super.onDetach();
    }
}
