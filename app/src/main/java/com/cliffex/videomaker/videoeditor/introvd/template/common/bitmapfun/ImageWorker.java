package com.introvd.template.common.bitmapfun;

import com.introvd.template.common.SerialExecutor;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract class ImageWorker {
    private static Map<String, Long> cdK = Collections.synchronizedMap(new LinkedHashMap());
    private static long cdL = 0;
    private static final Executor mExecutor = new SerialExecutor("ImageWork", 2, 10, 5);
}
