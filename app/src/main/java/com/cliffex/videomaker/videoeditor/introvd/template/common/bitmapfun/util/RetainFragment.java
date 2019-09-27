package com.introvd.template.common.bitmapfun.util;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;

public class RetainFragment extends Fragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
