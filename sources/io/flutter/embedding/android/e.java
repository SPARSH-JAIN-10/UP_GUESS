package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.d;
import io.flutter.embedding.android.f;

/* loaded from: classes.dex */
public class e extends Activity implements f.b, androidx.lifecycle.g {

    /* renamed from: a */
    protected f f110a;

    /* renamed from: b */
    private androidx.lifecycle.h f111b = new androidx.lifecycle.h(this);

    private void B() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    private void C() {
        if (E() == g.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View D() {
        return this.f110a.m(null, null, null);
    }

    private Drawable H() {
        try {
            Bundle G = G();
            int i = G != null ? G.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i != 0) {
                return Build.VERSION.SDK_INT > 21 ? getResources().getDrawable(i, getTheme()) : getResources().getDrawable(i);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private boolean I() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private void J() {
        this.f110a.n();
        this.f110a.o();
        this.f110a.A();
        this.f110a = null;
    }

    private boolean K(String str) {
        if (this.f110a != null) {
            return true;
        }
        b.a.b.f("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after release.");
        return false;
    }

    private void L() {
        try {
            Bundle G = G();
            if (G != null) {
                int i = G.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i != -1) {
                    setTheme(i);
                }
            } else {
                b.a.b.e("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            b.a.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Override // io.flutter.embedding.android.f.b
    public void A(i iVar) {
    }

    protected g E() {
        return getIntent().hasExtra("background_mode") ? g.valueOf(getIntent().getStringExtra("background_mode")) : g.opaque;
    }

    protected io.flutter.embedding.engine.a F() {
        return this.f110a.g();
    }

    protected Bundle G() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    @Override // io.flutter.embedding.android.f.b
    public void a() {
        b.a.b.f("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + F() + " evicted by another attaching activity");
        J();
    }

    @Override // io.flutter.plugin.platform.d.c
    public boolean b() {
        return false;
    }

    @Override // io.flutter.embedding.android.f.b
    public void c() {
        if (Build.VERSION.SDK_INT >= 21) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.embedding.android.f.b, androidx.lifecycle.g
    public androidx.lifecycle.d d() {
        return this.f111b;
    }

    @Override // io.flutter.embedding.android.f.b
    public void e() {
    }

    @Override // io.flutter.embedding.android.f.b
    public Activity f() {
        return this;
    }

    @Override // io.flutter.embedding.android.f.b
    public String g() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle G = G();
            if (G != null) {
                return G.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.f.b
    public io.flutter.embedding.engine.d h() {
        return io.flutter.embedding.engine.d.a(getIntent());
    }

    @Override // io.flutter.embedding.android.f.b
    public String k() {
        String dataString;
        if (I() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // io.flutter.embedding.android.f.b
    public io.flutter.embedding.engine.a l(Context context) {
        return null;
    }

    @Override // io.flutter.embedding.android.f.b
    public boolean m() {
        return true;
    }

    @Override // io.flutter.embedding.android.f.b
    public m n() {
        return E() == g.opaque ? m.surface : m.texture;
    }

    @Override // io.flutter.embedding.android.f.b
    public boolean o() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (s() != null || this.f110a.h()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (K("onActivityResult")) {
            this.f110a.j(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (K("onBackPressed")) {
            this.f110a.l();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        L();
        super.onCreate(bundle);
        f fVar = new f(this);
        this.f110a = fVar;
        fVar.k(this);
        this.f110a.t(bundle);
        this.f111b.g(d.a.ON_CREATE);
        C();
        setContentView(D());
        B();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (K("onDestroy")) {
            J();
        }
        this.f111b.g(d.a.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (K("onNewIntent")) {
            this.f110a.p(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (K("onPause")) {
            this.f110a.q();
        }
        this.f111b.g(d.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (K("onPostResume")) {
            this.f110a.r();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (K("onRequestPermissionsResult")) {
            this.f110a.s(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f111b.g(d.a.ON_RESUME);
        if (K("onResume")) {
            this.f110a.u();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (K("onSaveInstanceState")) {
            this.f110a.v(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f111b.g(d.a.ON_START);
        if (K("onStart")) {
            this.f110a.w();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (K("onStop")) {
            this.f110a.x();
        }
        this.f111b.g(d.a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (K("onTrimMemory")) {
            this.f110a.y(i);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (K("onUserLeaveHint")) {
            this.f110a.z();
        }
    }

    @Override // io.flutter.embedding.android.f.b
    public boolean p() {
        try {
            Bundle G = G();
            if (G != null) {
                return G.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.embedding.android.f.b
    public p q() {
        return E() == g.opaque ? p.opaque : p.transparent;
    }

    @Override // io.flutter.embedding.android.f.b
    public void r(j jVar) {
    }

    @Override // io.flutter.embedding.android.f.b
    public String s() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.f.b
    public void t(io.flutter.embedding.engine.a aVar) {
        io.flutter.embedding.engine.h.f.a.a(aVar);
    }

    @Override // io.flutter.embedding.android.f.b
    public boolean u() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : s() == null;
    }

    @Override // io.flutter.embedding.android.f.b
    public String v() {
        try {
            Bundle G = G();
            String string = G != null ? G.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.f.b
    public void w(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.f.b
    public o x() {
        Drawable H = H();
        if (H != null) {
            return new c(H);
        }
        return null;
    }

    @Override // io.flutter.embedding.android.f.b
    public io.flutter.plugin.platform.d y(Activity activity, io.flutter.embedding.engine.a aVar) {
        f();
        return new io.flutter.plugin.platform.d(this, aVar.n(), this);
    }

    @Override // io.flutter.embedding.android.f.b
    public Context z() {
        return this;
    }
}
