package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.embedding.engine.e.a;
import io.flutter.plugin.platform.d;
import java.util.Arrays;

/* loaded from: classes.dex */
public class f implements d<Activity> {

    /* renamed from: a */
    private b f112a;

    /* renamed from: b */
    private io.flutter.embedding.engine.a f113b;
    private FlutterSplashView c;
    private k d;
    private io.flutter.plugin.platform.d e;
    private boolean f;
    private final io.flutter.embedding.engine.renderer.b g = new a();

    /* loaded from: classes.dex */
    public class a implements io.flutter.embedding.engine.renderer.b {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void c() {
            f.this.f112a.c();
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void e() {
            f.this.f112a.e();
        }
    }

    /* loaded from: classes.dex */
    public interface b extends d.c {
        void A(i iVar);

        void a();

        void c();

        androidx.lifecycle.d d();

        void e();

        Activity f();

        String g();

        io.flutter.embedding.engine.d h();

        String k();

        io.flutter.embedding.engine.a l(Context context);

        boolean m();

        m n();

        boolean o();

        boolean p();

        p q();

        void r(j jVar);

        String s();

        void t(io.flutter.embedding.engine.a aVar);

        boolean u();

        String v();

        void w(io.flutter.embedding.engine.a aVar);

        o x();

        io.flutter.plugin.platform.d y(Activity activity, io.flutter.embedding.engine.a aVar);

        Context z();
    }

    public f(b bVar) {
        this.f112a = bVar;
    }

    private void d() {
        if (this.f112a.s() == null && !this.f113b.h().h()) {
            String g = this.f112a.g();
            if (g == null && (g = i(this.f112a.f().getIntent())) == null) {
                g = "/";
            }
            b.a.b.e("FlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.f112a.v() + ", and sending initial route: " + g);
            this.f113b.m().c(g);
            String k = this.f112a.k();
            if (k == null || k.isEmpty()) {
                k = b.a.a.c().b().e();
            }
            this.f113b.h().f(new a.b(k, this.f112a.v()));
        }
    }

    private void e() {
        if (this.f112a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String i(Intent intent) {
        Uri data;
        if (!this.f112a.p() || (data = intent.getData()) == null || data.getPath().isEmpty()) {
            return null;
        }
        String path = data.getPath();
        if (data.getQuery() == null || data.getQuery().isEmpty()) {
            return path;
        }
        return path + "?" + data.getQuery();
    }

    public void A() {
        this.f112a = null;
        this.f113b = null;
        this.d = null;
        this.e = null;
    }

    void B() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String s = this.f112a.s();
        if (s != null) {
            io.flutter.embedding.engine.a a2 = io.flutter.embedding.engine.b.b().a(s);
            this.f113b = a2;
            this.f = true;
            if (a2 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + s + "'");
        }
        b bVar = this.f112a;
        io.flutter.embedding.engine.a l = bVar.l(bVar.z());
        this.f113b = l;
        if (l != null) {
            this.f = true;
            return;
        }
        b.a.b.e("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f113b = new io.flutter.embedding.engine.a(this.f112a.z(), this.f112a.h().b(), false, this.f112a.u());
        this.f = false;
    }

    @Override // io.flutter.embedding.android.d
    public void a() {
        if (!this.f112a.o()) {
            this.f112a.a();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f112a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    @Override // io.flutter.embedding.android.d
    /* renamed from: f */
    public Activity b() {
        Activity f = this.f112a.f();
        if (f != null) {
            return f;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    public io.flutter.embedding.engine.a g() {
        return this.f113b;
    }

    public boolean h() {
        return this.f;
    }

    public void j(int i, int i2, Intent intent) {
        e();
        if (this.f113b == null) {
            b.a.b.f("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        b.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
        this.f113b.g().c(i, i2, intent);
    }

    public void k(Context context) {
        e();
        if (this.f113b == null) {
            B();
        }
        if (this.f112a.m()) {
            b.a.b.e("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f113b.g().g(this, this.f112a.d());
        }
        b bVar = this.f112a;
        this.e = bVar.y(bVar.f(), this.f113b);
        this.f112a.t(this.f113b);
    }

    public void l() {
        e();
        if (this.f113b == null) {
            b.a.b.f("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
        } else {
            b.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
            this.f113b.m().a();
        }
    }

    public View m(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k kVar;
        b.a.b.e("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        e();
        if (this.f112a.n() == m.surface) {
            i iVar = new i(this.f112a.f(), this.f112a.q() == p.transparent);
            this.f112a.A(iVar);
            kVar = new k(this.f112a.f(), iVar);
        } else {
            j jVar = new j(this.f112a.f());
            this.f112a.r(jVar);
            kVar = new k(this.f112a.f(), jVar);
        }
        this.d = kVar;
        this.d.i(this.g);
        FlutterSplashView flutterSplashView = new FlutterSplashView(this.f112a.z());
        this.c = flutterSplashView;
        flutterSplashView.setId(Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : 486947586);
        this.c.g(this.d, this.f112a.x());
        b.a.b.e("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
        this.d.k(this.f113b);
        return this.c;
    }

    public void n() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        e();
        this.d.o();
        this.d.u(this.g);
    }

    public void o() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onDetach()");
        e();
        this.f112a.w(this.f113b);
        if (this.f112a.m()) {
            b.a.b.e("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f112a.f().isChangingConfigurations()) {
                this.f113b.g().i();
            } else {
                this.f113b.g().h();
            }
        }
        io.flutter.plugin.platform.d dVar = this.e;
        if (dVar != null) {
            dVar.j();
            this.e = null;
        }
        this.f113b.j().a();
        if (this.f112a.o()) {
            this.f113b.e();
            if (this.f112a.s() != null) {
                io.flutter.embedding.engine.b.b().d(this.f112a.s());
            }
            this.f113b = null;
        }
    }

    public void p(Intent intent) {
        e();
        if (this.f113b == null) {
            b.a.b.f("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        b.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
        this.f113b.g().d(intent);
        String i = i(intent);
        if (i == null || i.isEmpty()) {
            return;
        }
        this.f113b.m().b(i);
    }

    public void q() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onPause()");
        e();
        this.f113b.j().b();
    }

    public void r() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onPostResume()");
        e();
        if (this.f113b == null) {
            b.a.b.f("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        io.flutter.plugin.platform.d dVar = this.e;
        if (dVar != null) {
            dVar.t();
        }
    }

    public void s(int i, String[] strArr, int[] iArr) {
        e();
        if (this.f113b == null) {
            b.a.b.f("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        b.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f113b.g().b(i, strArr, iArr);
    }

    public void t(Bundle bundle) {
        Bundle bundle2;
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        e();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f112a.u()) {
            this.f113b.q().j(bArr);
        }
        if (this.f112a.m()) {
            this.f113b.g().a(bundle2);
        }
    }

    public void u() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onResume()");
        e();
        this.f113b.j().d();
    }

    public void v(Bundle bundle) {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        e();
        if (this.f112a.u()) {
            bundle.putByteArray("framework", this.f113b.q().h());
        }
        if (this.f112a.m()) {
            Bundle bundle2 = new Bundle();
            this.f113b.g().e(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    public void w() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onStart()");
        e();
        d();
    }

    public void x() {
        b.a.b.e("FlutterActivityAndFragmentDelegate", "onStop()");
        e();
        this.f113b.j().c();
    }

    public void y(int i) {
        e();
        io.flutter.embedding.engine.a aVar = this.f113b;
        if (aVar == null) {
            b.a.b.f("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        aVar.h().i();
        if (i == 10) {
            b.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
            this.f113b.s().a();
        }
    }

    public void z() {
        e();
        if (this.f113b == null) {
            b.a.b.f("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        } else {
            b.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f113b.g().f();
        }
    }
}
