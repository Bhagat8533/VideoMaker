package com.introvd.template.template.p408f;

import android.text.TextUtils;
import com.firebase.jobdispatcher.DefaultJobValidator;
import com.introvd.template.common.FileUtils;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.introvd.template.template.f.e */
public class C8751e {
    /* renamed from: a */
    public static ArrayList<StoryBoardItemInfo> m25576a(String[] strArr, boolean z) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList<StoryBoardItemInfo> arrayList = new ArrayList<>();
        C8752f fVar = new C8752f();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (!TextUtils.isEmpty(str) && FileUtils.fileSize(str) > ((long) DefaultJobValidator.MAX_EXTRAS_SIZE_BYTES)) {
                StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
                try {
                    fVar.parse(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!z || (z && fVar.aMo())) {
                    String aMn = fVar.aMn();
                    storyBoardItemInfo.mFontName = TextUtils.isEmpty(aMn) ? FileUtils.getFileName(str) : aMn;
                    if (TextUtils.isEmpty(aMn)) {
                        if (m25578qB(storyBoardItemInfo.mFontName)) {
                            storyBoardItemInfo.mFontName = "小影";
                        } else {
                            storyBoardItemInfo.mFontName = "VivaVideo";
                        }
                    }
                    storyBoardItemInfo.mFontPath = str;
                    arrayList.add(storyBoardItemInfo);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: qA */
    public static String[] m25577qA(String str) {
        if (FileUtils.isDirectoryExisted(str)) {
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                String[] strArr = new String[listFiles.length];
                int i = 0;
                for (File file : listFiles) {
                    if (file != null && file.exists() && !file.isDirectory()) {
                        String name = file.getName();
                        if (TextUtils.indexOf(name.toLowerCase(Locale.US), "ttf") >= 0 || TextUtils.indexOf(name.toLowerCase(Locale.US), "otf") >= 0) {
                            int i2 = i + 1;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(name);
                            strArr[i] = sb.toString();
                            i = i2;
                        }
                    }
                }
                return strArr;
            }
        }
        return null;
    }

    /* renamed from: qB */
    private static boolean m25578qB(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 19968 && charArray[i] <= 40891) {
                return true;
            }
        }
        return false;
    }
}
