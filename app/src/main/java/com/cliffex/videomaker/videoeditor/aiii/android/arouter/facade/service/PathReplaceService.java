package com.aiii.android.arouter.facade.service;

import android.net.Uri;
import com.aiii.android.arouter.facade.template.C1949c;

public interface PathReplaceService extends C1949c {
    String forString(String str);

    Uri forUri(Uri uri);
}
