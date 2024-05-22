package io.flutter.embedding.engine.e;

import android.content.res.AssetManager;
import b.a.c.a.b;
import b.a.c.a.q;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a implements b.a.c.a.b {

    /* renamed from: a */
    private final FlutterJNI f155a;

    /* renamed from: b */
    private final AssetManager f156b;
    private final io.flutter.embedding.engine.e.b c;
    private final b.a.c.a.b d;
    private boolean e;
    private String f;
    private d g;
    private final b.a h;

    /* renamed from: io.flutter.embedding.engine.e.a$a */
    /* loaded from: classes.dex */
    public class C0013a implements b.a {
        C0013a() {
        }

        @Override // b.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0006b interfaceC0006b) {
            a.this.f = q.f89b.a(byteBuffer);
            if (a.this.g != null) {
                a.this.g.a(a.this.f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final String f158a;

        /* renamed from: b */
        public final String f159b = null;
        public final String c;

        public b(String str, String str2) {
            this.f158a = str;
            this.c = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f158a.equals(bVar.f158a)) {
                return this.c.equals(bVar.c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f158a.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f158a + ", function: " + this.c + " )";
        }
    }

    /* loaded from: classes.dex */
    public static class c implements b.a.c.a.b {

        /* renamed from: a */
        private final io.flutter.embedding.engine.e.b f160a;

        private c(io.flutter.embedding.engine.e.b bVar) {
            this.f160a = bVar;
        }

        /* synthetic */ c(io.flutter.embedding.engine.e.b bVar, C0013a c0013a) {
            this(bVar);
        }

        @Override // b.a.c.a.b
        public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0006b interfaceC0006b) {
            this.f160a.a(str, byteBuffer, interfaceC0006b);
        }

        @Override // b.a.c.a.b
        public void d(String str, b.a aVar) {
            this.f160a.d(str, aVar);
        }
    }

    /* loaded from: classes.dex */
    interface d {
        void a(String str);
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.e = false;
        C0013a c0013a = new C0013a();
        this.h = c0013a;
        this.f155a = flutterJNI;
        this.f156b = assetManager;
        io.flutter.embedding.engine.e.b bVar = new io.flutter.embedding.engine.e.b(flutterJNI);
        this.c = bVar;
        bVar.d("flutter/isolate", c0013a);
        this.d = new c(bVar, null);
        if (flutterJNI.isAttached()) {
            this.e = true;
        }
    }

    @Override // b.a.c.a.b
    @Deprecated
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0006b interfaceC0006b) {
        this.d.a(str, byteBuffer, interfaceC0006b);
    }

    @Override // b.a.c.a.b
    @Deprecated
    public void d(String str, b.a aVar) {
        this.d.d(str, aVar);
    }

    public void f(b bVar) {
        if (this.e) {
            b.a.b.f("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        b.a.b.e("DartExecutor", "Executing Dart entrypoint: " + bVar);
        this.f155a.runBundleAndSnapshotFromLibrary(bVar.f158a, bVar.c, bVar.f159b, this.f156b);
        this.e = true;
    }

    public String g() {
        return this.f;
    }

    public boolean h() {
        return this.e;
    }

    public void i() {
        if (this.f155a.isAttached()) {
            this.f155a.notifyLowMemoryWarning();
        }
    }

    public void j() {
        b.a.b.e("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f155a.setPlatformMessageHandler(this.c);
    }

    public void k() {
        b.a.b.e("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f155a.setPlatformMessageHandler(null);
    }
}
