package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: classes.dex */
public class j extends TextureView implements io.flutter.embedding.engine.renderer.c {

    /* renamed from: a */
    private boolean f126a;

    /* renamed from: b */
    private boolean f127b;
    private io.flutter.embedding.engine.renderer.a c;
    private Surface d;
    private final TextureView.SurfaceTextureListener e;

    /* loaded from: classes.dex */
    public class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.a.b.e("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            j.this.f126a = true;
            if (j.this.f127b) {
                j.this.j();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.a.b.e("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            j.this.f126a = false;
            if (!j.this.f127b) {
                return true;
            }
            j.this.k();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.a.b.e("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (j.this.f127b) {
                j.this.i(i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f126a = false;
        this.f127b = false;
        this.e = new a();
        l();
    }

    public void i(int i, int i2) {
        if (this.c == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        b.a.b.e("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.c.q(i, i2);
    }

    public void j() {
        if (this.c == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = new Surface(getSurfaceTexture());
        this.d = surface;
        this.c.o(surface);
    }

    public void k() {
        io.flutter.embedding.engine.renderer.a aVar = this.c;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.p();
        Surface surface = this.d;
        if (surface != null) {
            surface.release();
            this.d = null;
        }
    }

    private void l() {
        setSurfaceTextureListener(this.e);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a(io.flutter.embedding.engine.renderer.a aVar) {
        b.a.b.e("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.c != null) {
            b.a.b.e("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.c.p();
        }
        this.c = aVar;
        this.f127b = true;
        if (this.f126a) {
            b.a.b.e("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            j();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b() {
        if (this.c == null) {
            b.a.b.f("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.c = null;
            this.f127b = false;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
        if (this.c == null) {
            b.a.b.f("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            b.a.b.e("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            k();
        }
        this.c = null;
        this.f127b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.c;
    }
}
