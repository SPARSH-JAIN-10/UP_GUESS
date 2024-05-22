package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes.dex */
public class i extends SurfaceView implements io.flutter.embedding.engine.renderer.c {

    /* renamed from: a */
    private final boolean f122a;

    /* renamed from: b */
    private boolean f123b;
    private boolean c;
    private io.flutter.embedding.engine.renderer.a d;
    private final SurfaceHolder.Callback e;
    private final io.flutter.embedding.engine.renderer.b f;

    /* loaded from: classes.dex */
    public class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            b.a.b.e("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (i.this.c) {
                i.this.j(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            b.a.b.e("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            i.this.f123b = true;
            if (i.this.c) {
                i.this.k();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            b.a.b.e("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            i.this.f123b = false;
            if (i.this.c) {
                i.this.l();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements io.flutter.embedding.engine.renderer.b {
        b() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void c() {
            b.a.b.e("FlutterSurfaceView", "onFlutterUiDisplayed()");
            i.this.setAlpha(1.0f);
            if (i.this.d != null) {
                i.this.d.l(this);
            }
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void e() {
        }
    }

    private i(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.f123b = false;
        this.c = false;
        this.e = new a();
        this.f = new b();
        this.f122a = z;
        m();
    }

    public i(Context context, boolean z) {
        this(context, null, z);
    }

    public void j(int i, int i2) {
        if (this.d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        b.a.b.e("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.d.q(i, i2);
    }

    public void k() {
        if (this.d == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.d.o(getHolder().getSurface());
    }

    public void l() {
        io.flutter.embedding.engine.renderer.a aVar = this.d;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.p();
    }

    private void m() {
        if (this.f122a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.e);
        setAlpha(0.0f);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a(io.flutter.embedding.engine.renderer.a aVar) {
        b.a.b.e("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.d != null) {
            b.a.b.e("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.d.p();
            this.d.l(this.f);
        }
        this.d = aVar;
        this.c = true;
        aVar.f(this.f);
        if (this.f123b) {
            b.a.b.e("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            k();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b() {
        if (this.d == null) {
            b.a.b.f("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.d = null;
            this.c = false;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
        if (this.d == null) {
            b.a.b.f("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            b.a.b.e("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            l();
        }
        setAlpha(0.0f);
        this.d.l(this.f);
        this.d = null;
        this.c = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.d;
    }
}
