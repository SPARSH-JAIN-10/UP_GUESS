package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.d;

@TargetApi(20)
/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private final Context f310a;

    /* renamed from: b */
    private final c f311b;
    private final int c;
    private final d.a d;
    private final View.OnFocusChangeListener e;
    private VirtualDisplay f;
    SingleViewPresentation g;
    private Surface h;

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f312a;

        /* renamed from: b */
        final /* synthetic */ Runnable f313b;

        /* renamed from: io.flutter.plugin.platform.k$a$a */
        /* loaded from: classes.dex */
        class RunnableC0024a implements Runnable {
            RunnableC0024a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f312a.postDelayed(aVar.f313b, 128L);
            }
        }

        a(k kVar, View view, Runnable runnable) {
            this.f312a = view;
            this.f313b = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.a(this.f312a, new RunnableC0024a());
            this.f312a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    @TargetApi(16)
    /* loaded from: classes.dex */
    public static class b implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a */
        final View f315a;

        /* renamed from: b */
        Runnable f316b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f315a.getViewTreeObserver().removeOnDrawListener(b.this);
            }
        }

        b(View view, Runnable runnable) {
            this.f315a = view;
            this.f316b = runnable;
        }

        static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new b(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f316b;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f316b = null;
            this.f315a.post(new a());
        }
    }

    private k(Context context, c cVar, VirtualDisplay virtualDisplay, f fVar, Surface surface, d.a aVar, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        this.f310a = context;
        this.f311b = cVar;
        this.d = aVar;
        this.e = onFocusChangeListener;
        this.h = surface;
        this.f = virtualDisplay;
        this.c = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f.getDisplay(), fVar, cVar, i, obj, onFocusChangeListener);
        this.g = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static k a(Context context, c cVar, f fVar, d.a aVar, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        aVar.c().setDefaultBufferSize(i, i2);
        Surface surface = new Surface(aVar.c());
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new k(context, cVar, createVirtualDisplay, fVar, surface, aVar, onFocusChangeListener, i3, obj);
    }

    public void b(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public void c() {
        e view = this.g.getView();
        this.g.cancel();
        this.g.detachState();
        view.c();
        this.f.release();
        this.d.a();
    }

    public View d() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().f();
    }

    public void e(View view) {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().d(view);
    }

    public void f() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().e();
    }

    public void g() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().b();
    }

    public void h() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().a();
    }

    public void i(int i, int i2, Runnable runnable) {
        boolean isFocused = d().isFocused();
        SingleViewPresentation.e detachState = this.g.detachState();
        this.f.setSurface(null);
        this.f.release();
        this.d.c().setDefaultBufferSize(i, i2);
        this.f = ((DisplayManager) this.f310a.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, this.c, this.h, 0);
        View d = d();
        d.addOnAttachStateChangeListener(new a(this, d, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f310a, this.f.getDisplay(), this.f311b, detachState, this.e, isFocused);
        singleViewPresentation.show();
        this.g.cancel();
        this.g = singleViewPresentation;
    }
}
