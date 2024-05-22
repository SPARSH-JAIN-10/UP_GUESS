package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.i.e;
import io.flutter.embedding.engine.i.f;
import io.flutter.embedding.engine.i.g;
import io.flutter.embedding.engine.i.h;
import io.flutter.embedding.engine.i.i;
import io.flutter.embedding.engine.i.k;
import io.flutter.embedding.engine.i.l;
import io.flutter.embedding.engine.i.m;
import io.flutter.embedding.engine.i.n;
import io.flutter.plugin.platform.j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private final FlutterJNI f145a;

    /* renamed from: b */
    private final io.flutter.embedding.engine.renderer.a f146b;
    private final io.flutter.embedding.engine.e.a c;
    private final c d;
    private final b.a.c.b.a e;
    private final io.flutter.embedding.engine.i.b f;
    private final io.flutter.embedding.engine.i.c g;
    private final io.flutter.embedding.engine.i.d h;
    private final e i;
    private final f j;
    private final g k;
    private final h l;
    private final k m;
    private final i n;
    private final l o;
    private final m p;
    private final n q;
    private final j r;
    private final Set<b> s;
    private final b t;

    /* renamed from: io.flutter.embedding.engine.a$a */
    /* loaded from: classes.dex */
    public class C0011a implements b {
        C0011a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
            b.a.b.e("FlutterEngine", "onPreEngineRestart()");
            Iterator it = a.this.s.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
            a.this.r.T();
            a.this.m.g();
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();
    }

    public a(Context context, io.flutter.embedding.engine.g.c cVar, FlutterJNI flutterJNI, j jVar, String[] strArr, boolean z, boolean z2) {
        AssetManager assets;
        this.s = new HashSet();
        this.t = new C0011a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        io.flutter.embedding.engine.e.a aVar = new io.flutter.embedding.engine.e.a(flutterJNI, assets);
        this.c = aVar;
        aVar.j();
        io.flutter.embedding.engine.f.a a2 = b.a.a.c().a();
        this.f = new io.flutter.embedding.engine.i.b(aVar, flutterJNI);
        io.flutter.embedding.engine.i.c cVar2 = new io.flutter.embedding.engine.i.c(aVar);
        this.g = cVar2;
        this.h = new io.flutter.embedding.engine.i.d(aVar);
        this.i = new e(aVar);
        f fVar = new f(aVar);
        this.j = fVar;
        this.k = new g(aVar);
        this.l = new h(aVar);
        this.n = new i(aVar);
        this.m = new k(aVar, z2);
        this.o = new l(aVar);
        this.p = new m(aVar);
        this.q = new n(aVar);
        if (a2 != null) {
            a2.f(cVar2);
        }
        b.a.c.b.a aVar2 = new b.a.c.b.a(context, fVar);
        this.e = aVar2;
        this.f145a = flutterJNI;
        cVar = cVar == null ? b.a.a.c().b() : cVar;
        if (!flutterJNI.isAttached()) {
            cVar.g(context.getApplicationContext());
            cVar.d(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.t);
        flutterJNI.setPlatformViewsController(jVar);
        flutterJNI.setLocalizationPlugin(aVar2);
        flutterJNI.setDeferredComponentManager(b.a.a.c().a());
        if (!flutterJNI.isAttached()) {
            d();
        }
        this.f146b = new io.flutter.embedding.engine.renderer.a(flutterJNI);
        this.r = jVar;
        jVar.N();
        this.d = new c(context.getApplicationContext(), this, cVar);
        if (z && cVar.c()) {
            v();
        }
    }

    public a(Context context, String[] strArr, boolean z, boolean z2) {
        this(context, null, new FlutterJNI(), new j(), strArr, z, z2);
    }

    private void d() {
        b.a.b.e("FlutterEngine", "Attaching to JNI.");
        this.f145a.attachToNative(false);
        if (!u()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean u() {
        return this.f145a.isAttached();
    }

    private void v() {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", a.class).invoke(null, this);
        } catch (Exception unused) {
            b.a.b.f("FlutterEngine", "Tried to automatically register plugins with FlutterEngine (" + this + ") but could not find and invoke the GeneratedPluginRegistrant.");
        }
    }

    public void e() {
        b.a.b.e("FlutterEngine", "Destroying.");
        Iterator<b> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.d.l();
        this.r.P();
        this.c.k();
        this.f145a.removeEngineLifecycleListener(this.t);
        this.f145a.setDeferredComponentManager(null);
        this.f145a.detachFromNativeAndReleaseResources();
        if (b.a.a.c().a() != null) {
            b.a.a.c().a().d();
            this.g.c(null);
        }
    }

    public io.flutter.embedding.engine.i.b f() {
        return this.f;
    }

    public io.flutter.embedding.engine.h.b.b g() {
        return this.d;
    }

    public io.flutter.embedding.engine.e.a h() {
        return this.c;
    }

    public io.flutter.embedding.engine.i.d i() {
        return this.h;
    }

    public e j() {
        return this.i;
    }

    public b.a.c.b.a k() {
        return this.e;
    }

    public g l() {
        return this.k;
    }

    public h m() {
        return this.l;
    }

    public i n() {
        return this.n;
    }

    public j o() {
        return this.r;
    }

    public io.flutter.embedding.engine.renderer.a p() {
        return this.f146b;
    }

    public k q() {
        return this.m;
    }

    public l r() {
        return this.o;
    }

    public m s() {
        return this.p;
    }

    public n t() {
        return this.q;
    }
}
