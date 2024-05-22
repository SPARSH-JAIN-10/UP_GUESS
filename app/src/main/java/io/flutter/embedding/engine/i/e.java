package io.flutter.embedding.engine.i;

import b.a.c.a.q;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    public final b.a.c.a.a<String> f189a;

    public e(io.flutter.embedding.engine.e.a aVar) {
        this.f189a = new b.a.c.a.a<>(aVar, "flutter/lifecycle", q.f89b);
    }

    public void a() {
        b.a.b.e("LifecycleChannel", "Sending AppLifecycleState.detached message.");
        this.f189a.c("AppLifecycleState.detached");
    }

    public void b() {
        b.a.b.e("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
        this.f189a.c("AppLifecycleState.inactive");
    }

    public void c() {
        b.a.b.e("LifecycleChannel", "Sending AppLifecycleState.paused message.");
        this.f189a.c("AppLifecycleState.paused");
    }

    public void d() {
        b.a.b.e("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
        this.f189a.c("AppLifecycleState.resumed");
    }
}
