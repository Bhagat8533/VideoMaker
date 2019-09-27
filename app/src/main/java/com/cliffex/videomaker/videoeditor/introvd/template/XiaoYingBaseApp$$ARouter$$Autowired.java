package com.introvd.template;

import com.aiii.android.arouter.facade.service.SerializationService;
import com.aiii.android.arouter.facade.template.C1953g;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.crash.ICrashFlavour;

public class XiaoYingBaseApp$$ARouter$$Autowired implements C1953g {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) C1919a.m5529sc().mo10356i(SerializationService.class);
        ((C4681i) obj).bgs = (ICrashFlavour) C1919a.m5529sc().mo10355al(ICrashFlavour.VIVA_ROUTER_CRASH).mo10412rX();
    }
}
