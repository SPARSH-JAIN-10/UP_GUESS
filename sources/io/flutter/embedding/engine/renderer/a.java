package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.d;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a */
    private final FlutterJNI f259a;
    private Surface c;
    private final io.flutter.embedding.engine.renderer.b e;

    /* renamed from: b */
    private final AtomicLong f260b = new AtomicLong(0);
    private boolean d = false;

    /* renamed from: io.flutter.embedding.engine.renderer.a$a */
    /* loaded from: classes.dex */
    public class C0020a implements io.flutter.embedding.engine.renderer.b {
        C0020a() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void c() {
            a.this.d = true;
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void e() {
            a.this.d = false;
        }
    }

    /* loaded from: classes.dex */
    public final class b implements d.a {

        /* renamed from: a */
        private final long f262a;

        /* renamed from: b */
        private final SurfaceTextureWrapper f263b;
        private boolean c;
        private SurfaceTexture.OnFrameAvailableListener d = new C0021a();

        /* renamed from: io.flutter.embedding.engine.renderer.a$b$a */
        /* loaded from: classes.dex */
        public class C0021a implements SurfaceTexture.OnFrameAvailableListener {
            C0021a() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (b.this.c || !a.this.f259a.isAttached()) {
                    return;
                }
                b bVar = b.this;
                a.this.j(bVar.f262a);
            }
        }

        b(long j, SurfaceTexture surfaceTexture) {
            this.f262a = j;
            this.f263b = new SurfaceTextureWrapper(surfaceTexture);
            if (Build.VERSION.SDK_INT >= 21) {
                c().setOnFrameAvailableListener(this.d, new Handler());
            } else {
                c().setOnFrameAvailableListener(this.d);
            }
        }

        @Override // io.flutter.view.d.a
        public void a() {
            if (this.c) {
                return;
            }
            b.a.b.e("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f262a + ").");
            this.f263b.release();
            a.this.s(this.f262a);
            this.c = true;
        }

        @Override // io.flutter.view.d.a
        public long b() {
            return this.f262a;
        }

        @Override // io.flutter.view.d.a
        public SurfaceTexture c() {
            return this.f263b.surfaceTexture();
        }

        public SurfaceTextureWrapper f() {
            return this.f263b;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a */
        public float f265a = 1.0f;

        /* renamed from: b */
        public int f266b = 0;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public int f = 0;
        public int g = 0;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int o = 0;
    }

    public a(FlutterJNI flutterJNI) {
        C0020a c0020a = new C0020a();
        this.e = c0020a;
        this.f259a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(c0020a);
    }

    public void j(long j) {
        this.f259a.markTextureFrameAvailable(j);
    }

    private void k(long j, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f259a.registerTexture(j, surfaceTextureWrapper);
    }

    public void s(long j) {
        this.f259a.unregisterTexture(j);
    }

    @Override // io.flutter.view.d
    public d.a a() {
        b.a.b.e("FlutterRenderer", "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        b bVar = new b(this.f260b.getAndIncrement(), surfaceTexture);
        b.a.b.e("FlutterRenderer", "New SurfaceTexture ID: " + bVar.b());
        k(bVar.b(), bVar.f());
        return bVar;
    }

    public void f(io.flutter.embedding.engine.renderer.b bVar) {
        this.f259a.addIsDisplayingFlutterUiListener(bVar);
        if (this.d) {
            bVar.c();
        }
    }

    public void g(ByteBuffer byteBuffer, int i) {
        this.f259a.dispatchPointerDataPacket(byteBuffer, i);
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return this.f259a.getIsSoftwareRenderingEnabled();
    }

    public void l(io.flutter.embedding.engine.renderer.b bVar) {
        this.f259a.removeIsDisplayingFlutterUiListener(bVar);
    }

    public void m(boolean z) {
        this.f259a.setSemanticsEnabled(z);
    }

    public void n(c cVar) {
        b.a.b.e("FlutterRenderer", "Setting viewport metrics\nSize: " + cVar.f266b + " x " + cVar.c + "\nPadding - L: " + cVar.g + ", T: " + cVar.d + ", R: " + cVar.e + ", B: " + cVar.f + "\nInsets - L: " + cVar.k + ", T: " + cVar.h + ", R: " + cVar.i + ", B: " + cVar.j + "\nSystem Gesture Insets - L: " + cVar.o + ", T: " + cVar.l + ", R: " + cVar.m + ", B: " + cVar.j);
        this.f259a.setViewportMetrics(cVar.f265a, cVar.f266b, cVar.c, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, cVar.i, cVar.j, cVar.k, cVar.l, cVar.m, cVar.n, cVar.o);
    }

    public void o(Surface surface) {
        if (this.c != null) {
            p();
        }
        this.c = surface;
        this.f259a.onSurfaceCreated(surface);
    }

    public void p() {
        this.f259a.onSurfaceDestroyed();
        this.c = null;
        if (this.d) {
            this.e.e();
        }
        this.d = false;
    }

    public void q(int i, int i2) {
        this.f259a.onSurfaceChanged(i, i2);
    }

    public void r(Surface surface) {
        this.c = surface;
        this.f259a.onSurfaceWindowChanged(surface);
    }
}
