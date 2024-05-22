package io.flutter.embedding.engine.i;

import b.a.c.a.i;
import b.a.c.a.p;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    public final boolean f228a;

    /* renamed from: b */
    private byte[] f229b;
    private b.a.c.a.i c;
    private i.d d;
    private boolean e;
    private boolean f;
    private final i.c g;

    /* loaded from: classes.dex */
    public class a implements i.d {

        /* renamed from: a */
        final /* synthetic */ byte[] f230a;

        a(byte[] bArr) {
            this.f230a = bArr;
        }

        @Override // b.a.c.a.i.d
        public void a(String str, String str2, Object obj) {
            b.a.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // b.a.c.a.i.d
        public void b(Object obj) {
            k.this.f229b = this.f230a;
        }

        @Override // b.a.c.a.i.d
        public void c() {
        }
    }

    /* loaded from: classes.dex */
    public class b implements i.c {
        b() {
        }

        @Override // b.a.c.a.i.c
        public void a(b.a.c.a.h hVar, i.d dVar) {
            Map i;
            String str = hVar.f74a;
            Object obj = hVar.f75b;
            str.hashCode();
            if (str.equals("get")) {
                k.this.f = true;
                if (!k.this.e) {
                    k kVar = k.this;
                    if (kVar.f228a) {
                        kVar.d = dVar;
                        return;
                    }
                }
                k kVar2 = k.this;
                i = kVar2.i(kVar2.f229b);
            } else if (!str.equals("put")) {
                dVar.c();
                return;
            } else {
                k.this.f229b = (byte[]) obj;
                i = null;
            }
            dVar.b(i);
        }
    }

    k(b.a.c.a.i iVar, boolean z) {
        this.e = false;
        this.f = false;
        b bVar = new b();
        this.g = bVar;
        this.c = iVar;
        this.f228a = z;
        iVar.e(bVar);
    }

    public k(io.flutter.embedding.engine.e.a aVar, boolean z) {
        this(new b.a.c.a.i(aVar, "flutter/restoration", p.f86b), z);
    }

    public Map<String, Object> i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void g() {
        this.f229b = null;
    }

    public byte[] h() {
        return this.f229b;
    }

    public void j(byte[] bArr) {
        this.e = true;
        i.d dVar = this.d;
        if (dVar != null) {
            dVar.b(i(bArr));
            this.d = null;
        } else if (this.f) {
            this.c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f229b = bArr;
    }
}
