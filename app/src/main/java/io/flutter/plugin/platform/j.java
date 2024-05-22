package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.h;
import io.flutter.embedding.android.l;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.i.j;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.plugin.platform.j;
import io.flutter.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class j implements i {

    /* renamed from: b */
    private io.flutter.embedding.android.b f306b;
    private Context c;
    private View d;
    private io.flutter.view.d e;
    private io.flutter.plugin.editing.d f;
    private io.flutter.embedding.engine.i.j g;
    private int n = 0;
    private boolean o = false;
    private final j.e s = new a();

    /* renamed from: a */
    private final h f305a = new h();
    final HashMap<Integer, k> i = new HashMap<>();
    private final c h = new c();
    private final HashMap<Context, View> j = new HashMap<>();
    private final SparseArray<io.flutter.embedding.android.h> m = new SparseArray<>();
    private HashSet<Integer> p = new HashSet<>();
    private HashSet<Integer> q = new HashSet<>();
    private final SparseArray<e> k = new SparseArray<>();
    private final SparseArray<io.flutter.embedding.engine.mutatorsstack.a> l = new SparseArray<>();
    private final l r = l.a();

    /* loaded from: classes.dex */
    public class a implements j.e {

        /* renamed from: io.flutter.plugin.platform.j$a$a */
        /* loaded from: classes.dex */
        class RunnableC0023a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ k f308a;

            /* renamed from: b */
            final /* synthetic */ Runnable f309b;

            RunnableC0023a(k kVar, Runnable runnable) {
                this.f308a = kVar;
                this.f309b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                j.this.a0(this.f308a);
                this.f309b.run();
            }
        }

        a() {
        }

        private void i(int i) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= i) {
                return;
            }
            throw new IllegalStateException("Trying to use platform views with API " + i2 + ", required API level is: " + i);
        }

        /* renamed from: j */
        public /* synthetic */ void k(j.b bVar, View view, boolean z) {
            if (z) {
                j.this.g.d(bVar.f222a);
            }
        }

        @Override // io.flutter.embedding.engine.i.j.e
        public void a(int i) {
            i(20);
            j.this.i.get(Integer.valueOf(i)).d().clearFocus();
        }

        @Override // io.flutter.embedding.engine.i.j.e
        public void b(j.c cVar, Runnable runnable) {
            i(20);
            k kVar = j.this.i.get(Integer.valueOf(cVar.f224a));
            if (kVar == null) {
                throw new IllegalStateException("Trying to resize a platform view with unknown id: " + cVar.f224a);
            }
            int Z = j.this.Z(cVar.f225b);
            int Z2 = j.this.Z(cVar.c);
            j.this.c0(Z, Z2);
            j.this.M(kVar);
            kVar.i(Z, Z2, new RunnableC0023a(kVar, runnable));
        }

        @Override // io.flutter.embedding.engine.i.j.e
        public void c(int i) {
            e eVar = (e) j.this.k.get(i);
            io.flutter.embedding.engine.mutatorsstack.a aVar = (io.flutter.embedding.engine.mutatorsstack.a) j.this.l.get(i);
            if (eVar != null) {
                if (aVar != null) {
                    aVar.removeView(eVar.f());
                }
                j.this.k.remove(i);
                eVar.c();
            }
            if (aVar != null) {
                ((ViewGroup) aVar.getParent()).removeView(aVar);
                j.this.l.remove(i);
            }
        }

        @Override // io.flutter.embedding.engine.i.j.e
        public void d(int i) {
            i(20);
            k kVar = j.this.i.get(Integer.valueOf(i));
            if (kVar == null) {
                throw new IllegalStateException("Trying to dispose a platform view with unknown id: " + i);
            }
            if (j.this.f != null) {
                j.this.f.j(i);
            }
            j.this.j.remove(kVar.d().getContext());
            kVar.c();
            j.this.i.remove(Integer.valueOf(i));
        }

        @Override // io.flutter.embedding.engine.i.j.e
        @TargetApi(17)
        public long e(j.b bVar) {
            i(20);
            if (!j.b0(bVar.e)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + bVar.e + "(view id: " + bVar.f222a + ")");
            }
            if (j.this.i.containsKey(Integer.valueOf(bVar.f222a))) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + bVar.f222a);
            }
            f a2 = j.this.f305a.a(bVar.f223b);
            if (a2 == null) {
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + bVar.f223b);
            }
            Object a3 = bVar.f != null ? a2.b().a(bVar.f) : null;
            int Z = j.this.Z(bVar.c);
            int Z2 = j.this.Z(bVar.d);
            j.this.c0(Z, Z2);
            d.a a4 = j.this.e.a();
            k a5 = k.a(j.this.c, j.this.h, a2, a4, Z, Z2, bVar.f222a, a3, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.a

                /* renamed from: b */
                public final /* synthetic */ j.b f295b;

                public /* synthetic */ a(j.b bVar2) {
                    bVar = bVar2;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    j.a.this.k(bVar, view, z);
                }
            });
            if (a5 == null) {
                throw new IllegalStateException("Failed creating virtual display for a " + bVar2.f223b + " with id: " + bVar2.f222a);
            }
            if (j.this.d != null) {
                a5.e(j.this.d);
            }
            j.this.i.put(Integer.valueOf(bVar2.f222a), a5);
            View d = a5.d();
            d.setLayoutDirection(bVar2.e);
            j.this.j.put(d.getContext(), d);
            return a4.b();
        }

        @Override // io.flutter.embedding.engine.i.j.e
        @TargetApi(17)
        public void f(int i, int i2) {
            if (!j.b0(i2)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + ")");
            }
            i(20);
            View d = j.this.i.get(Integer.valueOf(i)).d();
            if (d != null) {
                d.setLayoutDirection(i2);
                return;
            }
            throw new IllegalStateException("Sending touch to an unknown view with id: " + i2);
        }

        @Override // io.flutter.embedding.engine.i.j.e
        public void g(j.b bVar) {
            i(19);
            if (!j.b0(bVar.e)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + bVar.e + "(view id: " + bVar.f222a + ")");
            }
            f a2 = j.this.f305a.a(bVar.f223b);
            if (a2 != null) {
                j.this.k.put(bVar.f222a, a2.a(j.this.c, bVar.f222a, bVar.f != null ? a2.b().a(bVar.f) : null));
                return;
            }
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + bVar.f223b);
        }

        @Override // io.flutter.embedding.engine.i.j.e
        public void h(j.d dVar) {
            int i = dVar.f226a;
            float f = j.this.c.getResources().getDisplayMetrics().density;
            i(20);
            if (j.this.i.containsKey(Integer.valueOf(i))) {
                j.this.i.get(Integer.valueOf(dVar.f226a)).b(j.this.Y(f, dVar, true));
            } else {
                if (j.this.k.get(i) == null) {
                    throw new IllegalStateException("Sending touch to an unknown view with id: " + i);
                }
                MotionEvent Y = j.this.Y(f, dVar, false);
                View f2 = ((e) j.this.k.get(dVar.f226a)).f();
                if (f2 != null) {
                    f2.dispatchTouchEvent(Y);
                }
            }
        }
    }

    private void E(boolean z) {
        for (int i = 0; i < this.m.size(); i++) {
            int keyAt = this.m.keyAt(i);
            io.flutter.embedding.android.h valueAt = this.m.valueAt(i);
            if (this.p.contains(Integer.valueOf(keyAt))) {
                ((io.flutter.embedding.android.k) this.d).j(valueAt);
                z &= valueAt.d();
            } else {
                if (!this.o) {
                    valueAt.c();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            int keyAt2 = this.l.keyAt(i2);
            io.flutter.embedding.engine.mutatorsstack.a aVar = this.l.get(keyAt2);
            if (z && this.q.contains(Integer.valueOf(keyAt2))) {
                aVar.setVisibility(0);
            } else {
                aVar.setVisibility(8);
            }
        }
    }

    private void F() {
        Iterator<k> it = this.i.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.i.clear();
        while (this.k.size() > 0) {
            this.s.c(this.k.keyAt(0));
        }
    }

    private float G() {
        return this.c.getResources().getDisplayMetrics().density;
    }

    private void J() {
        if (this.o) {
            return;
        }
        ((io.flutter.embedding.android.k) this.d).m();
        this.o = true;
    }

    /* renamed from: K */
    public /* synthetic */ void L() {
        E(false);
    }

    public void M(k kVar) {
        io.flutter.plugin.editing.d dVar = this.f;
        if (dVar == null) {
            return;
        }
        dVar.s();
        kVar.g();
    }

    private static MotionEvent.PointerCoords U(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> V(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(U(it.next(), f));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties W(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> X(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(W(it.next()));
        }
        return arrayList;
    }

    public int Z(double d) {
        double G = G();
        Double.isNaN(G);
        return (int) Math.round(d * G);
    }

    public void a0(k kVar) {
        io.flutter.plugin.editing.d dVar = this.f;
        if (dVar == null) {
            return;
        }
        dVar.F();
        kVar.h();
    }

    public static boolean b0(int i) {
        return i == 0 || i == 1;
    }

    public void c0(int i, int i2) {
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels || i > displayMetrics.widthPixels) {
            b.a.b.f("PlatformViewsController", "Creating a virtual display of size: [" + i + ", " + i2 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + displayMetrics.widthPixels + ", " + displayMetrics.heightPixels + "].");
        }
    }

    public void A() {
        for (int i = 0; i < this.m.size(); i++) {
            this.m.keyAt(i);
            io.flutter.embedding.android.h valueAt = this.m.valueAt(i);
            valueAt.c();
            View view = this.d;
            if (view != null) {
                ((io.flutter.embedding.android.k) view).removeView(valueAt);
            }
        }
        this.m.clear();
    }

    public void B() {
        io.flutter.embedding.engine.i.j jVar = this.g;
        if (jVar != null) {
            jVar.e(null);
        }
        A();
        this.g = null;
        this.c = null;
        this.e = null;
    }

    public void C() {
        A();
        this.d = null;
        Iterator<k> it = this.i.values().iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public void D() {
        this.f = null;
    }

    public g H() {
        return this.f305a;
    }

    void I(int i) {
        e eVar = this.k.get(i);
        if (eVar == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.l.get(i) != null) {
            return;
        }
        if (eVar.f() == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (eVar.f().getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.c;
        io.flutter.embedding.engine.mutatorsstack.a aVar = new io.flutter.embedding.engine.mutatorsstack.a(context, context.getResources().getDisplayMetrics().density, this.f306b);
        this.l.put(i, aVar);
        aVar.addView(eVar.f());
        ((io.flutter.embedding.android.k) this.d).addView(aVar);
    }

    public void N() {
    }

    public void O() {
        this.p.clear();
        this.q.clear();
    }

    public void P() {
        F();
    }

    public void Q(int i, int i2, int i3, int i4, int i5) {
        if (this.m.get(i) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i + ") doesn't exist");
        }
        J();
        io.flutter.embedding.android.h hVar = this.m.get(i);
        if (hVar.getParent() == null) {
            ((io.flutter.embedding.android.k) this.d).addView(hVar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        hVar.setLayoutParams(layoutParams);
        hVar.setVisibility(0);
        hVar.bringToFront();
        this.p.add(Integer.valueOf(i));
    }

    public void R(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        J();
        I(i);
        io.flutter.embedding.engine.mutatorsstack.a aVar = this.l.get(i);
        aVar.a(flutterMutatorsStack, i2, i3, i4, i5);
        aVar.setVisibility(0);
        aVar.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        View f = this.k.get(i).f();
        if (f != null) {
            f.setLayoutParams(layoutParams);
            f.bringToFront();
        }
        this.q.add(Integer.valueOf(i));
    }

    public void S() {
        io.flutter.embedding.android.k kVar = (io.flutter.embedding.android.k) this.d;
        boolean z = false;
        if (this.o && this.q.isEmpty()) {
            this.o = false;
            kVar.w(new Runnable() { // from class: io.flutter.plugin.platform.b
                public /* synthetic */ b() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.L();
                }
            });
        } else {
            if (this.o && kVar.g()) {
                z = true;
            }
            E(z);
        }
    }

    public void T() {
        F();
    }

    public MotionEvent Y(float f, j.d dVar, boolean z) {
        MotionEvent b2 = this.r.b(l.a.c(dVar.p));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) X(dVar.f).toArray(new MotionEvent.PointerProperties[dVar.e]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) V(dVar.g, f).toArray(new MotionEvent.PointerCoords[dVar.e]);
        return (z || b2 == null) ? MotionEvent.obtain(dVar.f227b.longValue(), dVar.c.longValue(), dVar.d, dVar.e, pointerPropertiesArr, pointerCoordsArr, dVar.h, dVar.i, dVar.j, dVar.k, dVar.l, dVar.m, dVar.n, dVar.o) : MotionEvent.obtain(b2.getDownTime(), b2.getEventTime(), b2.getAction(), dVar.e, pointerPropertiesArr, pointerCoordsArr, b2.getMetaState(), b2.getButtonState(), b2.getXPrecision(), b2.getYPrecision(), b2.getDeviceId(), b2.getEdgeFlags(), b2.getSource(), b2.getFlags());
    }

    @Override // io.flutter.plugin.platform.i
    public View a(Integer num) {
        if (this.k.get(num.intValue()) != null) {
            return this.k.get(num.intValue()).f();
        }
        k kVar = this.i.get(num);
        if (kVar == null) {
            return null;
        }
        return kVar.d();
    }

    @Override // io.flutter.plugin.platform.i
    public boolean b(Integer num) {
        return this.i.containsKey(num);
    }

    @Override // io.flutter.plugin.platform.i
    public void c(io.flutter.view.c cVar) {
        this.h.b(cVar);
    }

    @Override // io.flutter.plugin.platform.i
    public void d() {
        this.h.b(null);
    }

    public void t(Context context, io.flutter.view.d dVar, io.flutter.embedding.engine.e.a aVar) {
        if (this.c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.c = context;
        this.e = dVar;
        io.flutter.embedding.engine.i.j jVar = new io.flutter.embedding.engine.i.j(aVar);
        this.g = jVar;
        jVar.e(this.s);
    }

    public void u(io.flutter.plugin.editing.d dVar) {
        this.f = dVar;
    }

    public void v(io.flutter.embedding.engine.renderer.a aVar) {
        this.f306b = new io.flutter.embedding.android.b(aVar, true);
    }

    public void w(View view) {
        this.d = view;
        Iterator<k> it = this.i.values().iterator();
        while (it.hasNext()) {
            it.next().e(view);
        }
    }

    public boolean x(View view) {
        if (view == null || !this.j.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.j.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    @TargetApi(19)
    public FlutterOverlaySurface y() {
        return z(new io.flutter.embedding.android.h(this.d.getContext(), this.d.getWidth(), this.d.getHeight(), h.b.overlay));
    }

    @TargetApi(19)
    public FlutterOverlaySurface z(io.flutter.embedding.android.h hVar) {
        int i = this.n;
        this.n = i + 1;
        this.m.put(i, hVar);
        return new FlutterOverlaySurface(i, hVar.getSurface());
    }
}
