package com.introvd.template.common.bitmapfun;

import com.introvd.template.common.ResultListener;
import java.util.Random;

public class ImageFetcher extends ImageResizer {
    private static ResultListener bKf;
    private static ImageFetcherHttpListener cdH;
    private static Random cdI = new Random(System.currentTimeMillis());
    private static DiskLruCache cdJ = null;

    public interface ImageFetcherHttpListener {
    }

    public static void setFetcherHttpListener(ImageFetcherHttpListener imageFetcherHttpListener) {
        cdH = imageFetcherHttpListener;
    }
}
