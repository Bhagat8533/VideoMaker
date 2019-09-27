package com.aiii.android.arouter.facade.service;

import com.aiii.android.arouter.facade.template.C1949c;
import java.lang.reflect.Type;

public interface SerializationService extends C1949c {
    @Deprecated
    <T> T json2Object(String str, Class<T> cls);

    String object2Json(Object obj);

    <T> T parseObject(String str, Type type);
}
