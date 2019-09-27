package com.introvd.template.common.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class UtilsBitmap {
    public static void saveBitmap(String str, Bitmap bitmap) {
        saveBitmap(str, bitmap, 85);
    }

    public static void saveBitmap(String str, Bitmap bitmap, int i) {
        if (str != null && bitmap != null) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    String upperCase = str.toUpperCase(Locale.US);
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    if (upperCase.endsWith(".PNG")) {
                        compressFormat = CompressFormat.PNG;
                    }
                    bitmap.compress(compressFormat, i, fileOutputStream);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                } catch (FileNotFoundException unused2) {
                }
            } catch (IOException unused3) {
            }
        }
    }
}
