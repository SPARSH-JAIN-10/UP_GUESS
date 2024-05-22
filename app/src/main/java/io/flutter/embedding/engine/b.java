package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b */
    private static b f148b;

    /* renamed from: a */
    private final Map<String, a> f149a = new HashMap();

    b() {
    }

    public static b b() {
        if (f148b == null) {
            f148b = new b();
        }
        return f148b;
    }

    public a a(String str) {
        return this.f149a.get(str);
    }

    public void c(String str, a aVar) {
        if (aVar != null) {
            this.f149a.put(str, aVar);
        } else {
            this.f149a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
