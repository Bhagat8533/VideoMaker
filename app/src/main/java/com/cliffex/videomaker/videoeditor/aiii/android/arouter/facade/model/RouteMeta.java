package com.cliffex.videomaker.videoeditor.aiii.android.arouter.facade.model;

import android.renderscript.Element;

import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.facade.p096c.C1945a;
import java.util.Map;
//import javax.lang.model.element;

public class RouteMeta {
    private Class<?> destination;
    private int extra;
    private String group;
    private Map<String, Integer> paramsType;
    private String path;
    private int priority;
    private Element rawType;
    private C1945a type;

    public RouteMeta() {
        this.priority = -1;
    }

    public RouteMeta(C1942a aVar, Class<?> cls, C1945a aVar2) {
        this(aVar2, null, cls, aVar.mo10417rZ(), aVar.group(), null, aVar.mo10419sb(), aVar.mo10418sa());
    }

    public RouteMeta(C1942a aVar, Element element, C1945a aVar2, Map<String, Integer> map) {
        this(aVar2, element, null, aVar.mo10417rZ(), aVar.group(), map, aVar.mo10419sb(), aVar.mo10418sa());
    }

    public RouteMeta(C1945a aVar, Element element, Class<?> cls, String str, String str2, Map<String, Integer> map, int i, int i2) {
        this.priority = -1;
        this.type = aVar;
        this.destination = cls;
        this.rawType = element;
        this.path = str;
        this.group = str2;
        this.paramsType = map;
        this.priority = i;
        this.extra = i2;
    }

    public static RouteMeta build(C1945a aVar, Class<?> cls, String str, String str2, int i, int i2) {
        RouteMeta routeMeta = new RouteMeta(aVar, null, cls, str, str2, null, i, i2);
        return routeMeta;
    }

    public static RouteMeta build(C1945a aVar, Class<?> cls, String str, String str2, Map<String, Integer> map, int i, int i2) {
        RouteMeta routeMeta = new RouteMeta(aVar, null, cls, str, str2, map, i, i2);
        return routeMeta;
    }

    public Class<?> getDestination() {
        return this.destination;
    }

    public int getExtra() {
        return this.extra;
    }

    public String getGroup() {
        return this.group;
    }

    public Map<String, Integer> getParamsType() {
        return this.paramsType;
    }

    public String getPath() {
        return this.path;
    }

    public int getPriority() {
        return this.priority;
    }

    public Element getRawType() {
        return this.rawType;
    }

    public C1945a getType() {
        return this.type;
    }

    public RouteMeta setDestination(Class<?> cls) {
        this.destination = cls;
        return this;
    }

    public RouteMeta setExtra(int i) {
        this.extra = i;
        return this;
    }

    public RouteMeta setGroup(String str) {
        this.group = str;
        return this;
    }

    public RouteMeta setParamsType(Map<String, Integer> map) {
        this.paramsType = map;
        return this;
    }

    public RouteMeta setPath(String str) {
        this.path = str;
        return this;
    }

    public RouteMeta setPriority(int i) {
        this.priority = i;
        return this;
    }

    public RouteMeta setRawType(Element element) {
        this.rawType = element;
        return this;
    }

    public RouteMeta setType(C1945a aVar) {
        this.type = aVar;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RouteMeta{type=");
        sb.append(this.type);
        sb.append(", rawType=");
        sb.append(this.rawType);
        sb.append(", destination=");
        sb.append(this.destination);
        sb.append(", path='");
        sb.append(this.path);
        sb.append('\'');
        sb.append(", group='");
        sb.append(this.group);
        sb.append('\'');
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append('}');
        return sb.toString();
    }
}
