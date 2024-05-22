package b.a.c.a;

import b.a.c.a.o;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class p implements j {

    /* renamed from: b */
    public static final p f86b = new p(o.f84a);

    /* renamed from: a */
    private final o f87a;

    public p(o oVar) {
        this.f87a = oVar;
    }

    private static String g(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // b.a.c.a.j
    public ByteBuffer a(String str, String str2, Object obj, String str3) {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f87a.o(aVar, str);
        this.f87a.o(aVar, str2);
        if (obj instanceof Throwable) {
            this.f87a.o(aVar, g((Throwable) obj));
        } else {
            this.f87a.o(aVar, obj);
        }
        this.f87a.o(aVar, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // b.a.c.a.j
    public ByteBuffer b(h hVar) {
        o.a aVar = new o.a();
        this.f87a.o(aVar, hVar.f74a);
        this.f87a.o(aVar, hVar.f75b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // b.a.c.a.j
    public ByteBuffer c(String str, String str2, Object obj) {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f87a.o(aVar, str);
        this.f87a.o(aVar, str2);
        if (obj instanceof Throwable) {
            this.f87a.o(aVar, g((Throwable) obj));
        } else {
            this.f87a.o(aVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // b.a.c.a.j
    public ByteBuffer d(Object obj) {
        o.a aVar = new o.a();
        aVar.write(0);
        this.f87a.o(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // b.a.c.a.j
    public h e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f = this.f87a.f(byteBuffer);
        Object f2 = this.f87a.f(byteBuffer);
        if (!(f instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new h((String) f, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 == 1) goto L73;
     */
    @Override // b.a.c.a.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object f(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L4a
            goto L1e
        L11:
            b.a.c.a.o r0 = r4.f87a
            java.lang.Object r0 = r0.f(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            b.a.c.a.o r0 = r4.f87a
            java.lang.Object r0 = r0.f(r5)
            b.a.c.a.o r1 = r4.f87a
            java.lang.Object r1 = r1.f(r5)
            b.a.c.a.o r2 = r4.f87a
            java.lang.Object r2 = r2.f(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L4a
            if (r1 == 0) goto L3a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L4a
        L3a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L4a
            b.a.c.a.c r5 = new b.a.c.a.c
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L4a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.c.a.p.f(java.nio.ByteBuffer):java.lang.Object");
    }
}
