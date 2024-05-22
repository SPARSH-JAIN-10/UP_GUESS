package io.flutter.embedding.engine.i;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a */
    public final b.a.c.a.i f196a;

    public h(io.flutter.embedding.engine.e.a aVar) {
        this.f196a = new b.a.c.a.i(aVar, "flutter/navigation", b.a.c.a.e.f73a);
    }

    public void a() {
        b.a.b.e("NavigationChannel", "Sending message to pop route.");
        this.f196a.c("popRoute", null);
    }

    public void b(String str) {
        b.a.b.e("NavigationChannel", "Sending message to push route '" + str + "'");
        this.f196a.c("pushRoute", str);
    }

    public void c(String str) {
        b.a.b.e("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f196a.c("setInitialRoute", str);
    }
}
