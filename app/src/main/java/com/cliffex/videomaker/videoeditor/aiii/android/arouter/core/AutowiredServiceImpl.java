package com.aiii.android.arouter.core;

import android.content.Context;
import android.util.LruCache;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.facade.service.AutowiredService;
import com.aiii.android.arouter.facade.template.C1953g;
import java.util.ArrayList;
import java.util.List;

@C1942a(mo10417rZ = "/arouter/service/autowired")
public class AutowiredServiceImpl implements AutowiredService {
    private List<String> blackList;
    private LruCache<String, C1953g> classCache;

    public void autowire(Object obj) {
        String name = obj.getClass().getName();
        try {
            if (!this.blackList.contains(name)) {
                C1953g gVar = (C1953g) this.classCache.get(name);
                if (gVar == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(obj.getClass().getName());
                    sb.append("$$ARouter$$Autowired");
                    gVar = (C1953g) Class.forName(sb.toString()).getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                gVar.inject(obj);
                this.classCache.put(name, gVar);
            }
        } catch (Exception unused) {
            this.blackList.add(name);
        }
    }

    public void init(Context context) {
        this.classCache = new LruCache<>(66);
        this.blackList = new ArrayList();
    }
}
