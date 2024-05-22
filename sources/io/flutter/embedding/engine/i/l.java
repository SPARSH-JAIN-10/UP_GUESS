package io.flutter.embedding.engine.i;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    public final b.a.c.a.a<Object> f233a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final b.a.c.a.a<Object> f234a;

        /* renamed from: b */
        private Map<String, Object> f235b = new HashMap();

        a(b.a.c.a.a<Object> aVar) {
            this.f234a = aVar;
        }

        public void a() {
            b.a.b.e("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f235b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f235b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f235b.get("platformBrightness"));
            this.f234a.c(this.f235b);
        }

        public a b(b bVar) {
            this.f235b.put("platformBrightness", bVar.f237a);
            return this;
        }

        public a c(float f) {
            this.f235b.put("textScaleFactor", Float.valueOf(f));
            return this;
        }

        public a d(boolean z) {
            this.f235b.put("alwaysUse24HourFormat", Boolean.valueOf(z));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        light("light"),
        dark("dark");


        /* renamed from: a */
        public String f237a;

        b(String str) {
            this.f237a = str;
        }
    }

    public l(io.flutter.embedding.engine.e.a aVar) {
        this.f233a = new b.a.c.a.a<>(aVar, "flutter/settings", b.a.c.a.d.f72a);
    }

    public a a() {
        return new a(this.f233a);
    }
}
