package com.introvd.template.origin.device;

import com.introvd.template.router.app.device.DeviceLoginObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.introvd.template.origin.device.d */
class C8136d {
    private CopyOnWriteArrayList<DeviceLoginObserver> dWx = new CopyOnWriteArrayList<>();

    C8136d() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33190a(DeviceLoginObserver deviceLoginObserver) {
        if (deviceLoginObserver == null) {
            throw new NullPointerException();
        } else if (!this.dWx.contains(deviceLoginObserver)) {
            this.dWx.add(deviceLoginObserver);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: sQ */
    public void mo33191sQ(int i) {
        Iterator it = this.dWx.iterator();
        while (it.hasNext()) {
            ((DeviceLoginObserver) it.next()).onChange(i);
        }
    }
}
