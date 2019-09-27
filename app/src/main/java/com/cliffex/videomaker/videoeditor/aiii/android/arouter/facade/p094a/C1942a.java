package com.aiii.android.arouter.facade.p094a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* renamed from: com.aiii.android.arouter.facade.a.a */
public @interface C1942a {
    String group() default "";

    /* renamed from: rZ */
    String mo10417rZ();

    /* renamed from: sa */
    int mo10418sa() default Integer.MIN_VALUE;

    /* renamed from: sb */
    int mo10419sb() default -1;
}
