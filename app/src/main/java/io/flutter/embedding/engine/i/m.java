package io.flutter.embedding.engine.i;

import java.util.HashMap;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a */
    public final b.a.c.a.a<Object> f238a;

    public m(io.flutter.embedding.engine.e.a aVar) {
        this.f238a = new b.a.c.a.a<>(aVar, "flutter/system", b.a.c.a.d.f72a);
    }

    public void a() {
        b.a.b.e("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f238a.c(hashMap);
    }
}
