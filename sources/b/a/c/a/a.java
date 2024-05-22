package b.a.c.a;

import b.a.c.a.b;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a */
    private final b.a.c.a.b f62a;

    /* renamed from: b */
    private final String f63b;
    private final g<T> c;

    /* loaded from: classes.dex */
    public final class b implements b.a {

        /* renamed from: a */
        private final d<T> f64a;

        /* renamed from: b.a.c.a.a$b$a */
        /* loaded from: classes.dex */
        class C0005a implements e<T> {

            /* renamed from: a */
            final /* synthetic */ b.InterfaceC0006b f66a;

            C0005a(b.InterfaceC0006b interfaceC0006b) {
                this.f66a = interfaceC0006b;
            }

            @Override // b.a.c.a.a.e
            public void a(T t) {
                this.f66a.a(a.this.c.b(t));
            }
        }

        private b(d<T> dVar) {
            this.f64a = dVar;
        }

        /* synthetic */ b(a aVar, d dVar, C0004a c0004a) {
            this(dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0006b interfaceC0006b) {
            try {
                this.f64a.a(a.this.c.a(byteBuffer), new C0005a(interfaceC0006b));
            } catch (RuntimeException e) {
                b.a.b.c("BasicMessageChannel#" + a.this.f63b, "Failed to handle message", e);
                interfaceC0006b.a(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class c implements b.InterfaceC0006b {

        /* renamed from: a */
        private final e<T> f68a;

        private c(e<T> eVar) {
            this.f68a = eVar;
        }

        /* synthetic */ c(a aVar, e eVar, C0004a c0004a) {
            this(eVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.a.c.a.b.InterfaceC0006b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f68a.a(a.this.c.a(byteBuffer));
            } catch (RuntimeException e) {
                b.a.b.c("BasicMessageChannel#" + a.this.f63b, "Failed to handle message reply", e);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t, e<T> eVar);
    }

    /* loaded from: classes.dex */
    public interface e<T> {
        void a(T t);
    }

    public a(b.a.c.a.b bVar, String str, g<T> gVar) {
        this.f62a = bVar;
        this.f63b = str;
        this.c = gVar;
    }

    public void c(T t) {
        d(t, null);
    }

    public void d(T t, e<T> eVar) {
        this.f62a.a(this.f63b, this.c.b(t), eVar != null ? new c(eVar) : null);
    }

    public void e(d<T> dVar) {
        this.f62a.d(this.f63b, dVar != null ? new b(dVar) : null);
    }
}
