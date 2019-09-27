package com.introvd.template.sdk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.introvd.template.sdk.utils.z */
public class C8573z {
    public static ArrayList<String> UnZipFolder(String str, String str2) throws Exception {
        String str3;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            ArrayList<String> arrayList = new ArrayList<>();
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(File.separator);
                    sb.append(substring);
                    new File(sb.toString()).mkdirs();
                } else {
                    if (!str2.endsWith(File.separator)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(File.separator);
                        str3 = sb2.toString();
                    } else {
                        str3 = str2;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str3);
                    sb3.append(name);
                    String sb4 = sb3.toString();
                    if (name.contains(File.separator)) {
                        int lastIndexOf = sb4.lastIndexOf(File.separator);
                        if (lastIndexOf != -1) {
                            new File(sb4.substring(0, lastIndexOf)).mkdirs();
                        }
                    }
                    File file = new File(sb4);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                    arrayList.add(sb4);
                }
            }
            zipInputStream.close();
            try {
                fileInputStream.close();
            } catch (Exception unused) {
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }
}
