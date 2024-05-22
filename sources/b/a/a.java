package b.a;

import io.flutter.embedding.engine.g.c;

/* loaded from: classes.dex */
public final class a {
    private static a c;

    /* renamed from: a */
    private c f58a;

    /* renamed from: b */
    private io.flutter.embedding.engine.f.a f59b;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        private c f60a;

        /* renamed from: b */
        private io.flutter.embedding.engine.f.a f61b;

        private void b() {
            if (this.f60a == null) {
                this.f60a = new c();
            }
        }

        public a a() {
            b();
            return new a(this.f60a, this.f61b);
        }
    }

    private a(c cVar, io.flutter.embedding.engine.f.a aVar) {
        this.f58a = cVar;
        this.f59b = aVar;
    }

    /* synthetic */ a(c cVar, io.flutter.embedding.engine.f.a aVar, C0003a c0003a) {
        this(cVar, aVar);
    }

    public static a c() {
        if (c == null) {
            c = new b().a();
        }
        return c;
    }

    public io.flutter.embedding.engine.f.a a() {
        return this.f59b;
    }

    public c b() {
        return this.f58a;
    }
}
