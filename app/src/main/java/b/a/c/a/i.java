package b.a.c.a;

import b.a.c.a.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    private final b.a.c.a.b f76a;

    /* renamed from: b */
    private final String f77b;
    private final j c;

    /* loaded from: classes.dex */
    public final class a implements b.a {

        /* renamed from: a */
        private final c f78a;

        /* renamed from: b.a.c.a.i$a$a */
        /* loaded from: classes.dex */
        class C0007a implements d {

            /* renamed from: a */
            final /* synthetic */ b.InterfaceC0006b f80a;

            C0007a(b.InterfaceC0006b interfaceC0006b) {
                this.f80a = interfaceC0006b;
            }

            @Override // b.a.c.a.i.d
            public void a(String str, String str2, Object obj) {
                this.f80a.a(i.this.c.c(str, str2, obj));
            }

            @Override // b.a.c.a.i.d
            public void b(Object obj) {
                this.f80a.a(i.this.c.d(obj));
            }

            @Override // b.a.c.a.i.d
            public void c() {
                this.f80a.a(null);
            }
        }

        a(c cVar) {
            this.f78a = cVar;
        }

        private String b(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        @Override // b.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0006b interfaceC0006b) {
            try {
                this.f78a.a(i.this.c.e(byteBuffer), new C0007a(interfaceC0006b));
            } catch (RuntimeException e) {
                b.a.b.c("MethodChannel#" + i.this.f77b, "Failed to handle method call", e);
                interfaceC0006b.a(i.this.c.a("error", e.getMessage(), null, b(e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public final class b implements b.InterfaceC0006b {

        /* renamed from: a */
        private final d f82a;

        b(d dVar) {
            this.f82a = dVar;
        }

        @Override // b.a.c.a.b.InterfaceC0006b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f82a.c();
                } else {
                    try {
                        this.f82a.b(i.this.c.f(byteBuffer));
                    } catch (b.a.c.a.c e) {
                        this.f82a.a(e.f70a, e.getMessage(), e.f71b);
                    }
                }
            } catch (RuntimeException e2) {
                b.a.b.c("MethodChannel#" + i.this.f77b, "Failed to handle method call result", e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(h hVar, d dVar);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(String str, String str2, Object obj);

        void b(Object obj);

        void c();
    }

    public i(b.a.c.a.b bVar, String str, j jVar) {
        this.f76a = bVar;
        this.f77b = str;
        this.c = jVar;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f76a.a(this.f77b, this.c.b(new h(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        this.f76a.d(this.f77b, cVar == null ? null : new a(cVar));
    }
}
