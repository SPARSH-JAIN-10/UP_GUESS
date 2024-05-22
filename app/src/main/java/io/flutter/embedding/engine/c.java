package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.c.a.k;
import b.a.c.a.l;
import b.a.c.a.m;
import b.a.c.a.n;
import io.flutter.embedding.engine.h.a;
import io.flutter.embedding.engine.h.b.c;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements io.flutter.embedding.engine.h.b.b {

    /* renamed from: b */
    private final io.flutter.embedding.engine.a f151b;
    private final a.b c;

    @Deprecated
    private Activity e;
    private io.flutter.embedding.android.d<Activity> f;
    private C0012c g;
    private Service j;
    private BroadcastReceiver l;
    private ContentProvider n;

    /* renamed from: a */
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.a> f150a = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.b.a> d = new HashMap();
    private boolean h = false;
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.e.a> i = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.c.a> k = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.d.a> m = new HashMap();

    /* loaded from: classes.dex */
    public static class b implements a.InterfaceC0016a {
        private b(io.flutter.embedding.engine.g.c cVar) {
        }

        /* synthetic */ b(io.flutter.embedding.engine.g.c cVar, a aVar) {
            this(cVar);
        }
    }

    /* renamed from: io.flutter.embedding.engine.c$c */
    /* loaded from: classes.dex */
    public static class C0012c implements io.flutter.embedding.engine.h.b.c {

        /* renamed from: a */
        private final Set<m> f152a = new HashSet();

        /* renamed from: b */
        private final Set<k> f153b = new HashSet();
        private final Set<l> c = new HashSet();
        private final Set<n> d = new HashSet();
        private final Set<c.a> e = new HashSet();

        public C0012c(Activity activity, androidx.lifecycle.d dVar) {
            new HiddenLifecycleReference(dVar);
        }

        boolean a(int i, int i2, Intent intent) {
            boolean z;
            Iterator it = new HashSet(this.f153b).iterator();
            while (true) {
                while (it.hasNext()) {
                    z = ((k) it.next()).c(i, i2, intent) || z;
                }
                return z;
            }
        }

        void b(Intent intent) {
            Iterator<l> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().d(intent);
            }
        }

        boolean c(int i, String[] strArr, int[] iArr) {
            boolean z;
            Iterator<m> it = this.f152a.iterator();
            while (true) {
                while (it.hasNext()) {
                    z = it.next().b(i, strArr, iArr) || z;
                }
                return z;
            }
        }

        void d(Bundle bundle) {
            Iterator<c.a> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().a(bundle);
            }
        }

        void e(Bundle bundle) {
            Iterator<c.a> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().e(bundle);
            }
        }

        void f() {
            Iterator<n> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().f();
            }
        }
    }

    public c(Context context, io.flutter.embedding.engine.a aVar, io.flutter.embedding.engine.g.c cVar) {
        this.f151b = aVar;
        this.c = new a.b(context, aVar, aVar.h(), aVar.p(), aVar.o().H(), new b(cVar));
    }

    private void j(Activity activity, androidx.lifecycle.d dVar) {
        this.g = new C0012c(activity, dVar);
        this.f151b.o().t(activity, this.f151b.p(), this.f151b.h());
        for (io.flutter.embedding.engine.h.b.a aVar : this.d.values()) {
            if (this.h) {
                aVar.c(this.g);
            } else {
                aVar.b(this.g);
            }
        }
        this.h = false;
    }

    private Activity k() {
        io.flutter.embedding.android.d<Activity> dVar = this.f;
        return dVar != null ? dVar.b() : this.e;
    }

    private void m() {
        this.f151b.o().B();
        this.f = null;
        this.e = null;
        this.g = null;
    }

    private void n() {
        if (r()) {
            h();
            return;
        }
        if (u()) {
            q();
        } else if (s()) {
            o();
        } else if (t()) {
            p();
        }
    }

    private boolean r() {
        return (this.e == null && this.f == null) ? false : true;
    }

    private boolean s() {
        return this.l != null;
    }

    private boolean t() {
        return this.n != null;
    }

    private boolean u() {
        return this.j != null;
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public void a(Bundle bundle) {
        b.a.b.e("FlutterEngineCxnRegstry", "Forwarding onRestoreInstanceState() to plugins.");
        if (r()) {
            this.g.d(bundle);
        } else {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public boolean b(int i, String[] strArr, int[] iArr) {
        b.a.b.e("FlutterEngineCxnRegstry", "Forwarding onRequestPermissionsResult() to plugins.");
        if (r()) {
            return this.g.c(i, strArr, iArr);
        }
        b.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public boolean c(int i, int i2, Intent intent) {
        b.a.b.e("FlutterEngineCxnRegstry", "Forwarding onActivityResult() to plugins.");
        if (r()) {
            return this.g.a(i, i2, intent);
        }
        b.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public void d(Intent intent) {
        b.a.b.e("FlutterEngineCxnRegstry", "Forwarding onNewIntent() to plugins.");
        if (r()) {
            this.g.b(intent);
        } else {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public void e(Bundle bundle) {
        b.a.b.e("FlutterEngineCxnRegstry", "Forwarding onSaveInstanceState() to plugins.");
        if (r()) {
            this.g.e(bundle);
        } else {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public void f() {
        b.a.b.e("FlutterEngineCxnRegstry", "Forwarding onUserLeaveHint() to plugins.");
        if (r()) {
            this.g.f();
        } else {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public void g(io.flutter.embedding.android.d<Activity> dVar, androidx.lifecycle.d dVar2) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Attaching to an exclusive Activity: ");
        sb.append(dVar.b());
        if (r()) {
            str = " evicting previous activity " + k();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(".");
        sb.append(this.h ? " This is after a config change." : "");
        b.a.b.e("FlutterEngineCxnRegstry", sb.toString());
        io.flutter.embedding.android.d<Activity> dVar3 = this.f;
        if (dVar3 != null) {
            dVar3.a();
        }
        n();
        if (this.e != null) {
            throw new AssertionError("Only activity or exclusiveActivity should be set");
        }
        this.f = dVar;
        j(dVar.b(), dVar2);
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public void h() {
        if (!r()) {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        b.a.b.e("FlutterEngineCxnRegstry", "Detaching from an Activity: " + k());
        Iterator<io.flutter.embedding.engine.h.b.a> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        m();
    }

    @Override // io.flutter.embedding.engine.h.b.b
    public void i() {
        if (!r()) {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        b.a.b.e("FlutterEngineCxnRegstry", "Detaching from an Activity for config changes: " + k());
        this.h = true;
        Iterator<io.flutter.embedding.engine.h.b.a> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        m();
    }

    public void l() {
        b.a.b.e("FlutterEngineCxnRegstry", "Destroying.");
        n();
        x();
    }

    public void o() {
        if (!s()) {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        b.a.b.e("FlutterEngineCxnRegstry", "Detaching from BroadcastReceiver: " + this.l);
        Iterator<io.flutter.embedding.engine.h.c.a> it = this.k.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void p() {
        if (!t()) {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        b.a.b.e("FlutterEngineCxnRegstry", "Detaching from ContentProvider: " + this.n);
        Iterator<io.flutter.embedding.engine.h.d.a> it = this.m.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void q() {
        if (!u()) {
            b.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        b.a.b.e("FlutterEngineCxnRegstry", "Detaching from a Service: " + this.j);
        Iterator<io.flutter.embedding.engine.h.e.a> it = this.i.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.j = null;
    }

    public void v(Class<? extends io.flutter.embedding.engine.h.a> cls) {
        io.flutter.embedding.engine.h.a aVar = this.f150a.get(cls);
        if (aVar != null) {
            b.a.b.e("FlutterEngineCxnRegstry", "Removing plugin: " + aVar);
            if (aVar instanceof io.flutter.embedding.engine.h.b.a) {
                if (r()) {
                    ((io.flutter.embedding.engine.h.b.a) aVar).a();
                }
                this.d.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.h.e.a) {
                if (u()) {
                    ((io.flutter.embedding.engine.h.e.a) aVar).a();
                }
                this.i.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.h.c.a) {
                if (s()) {
                    ((io.flutter.embedding.engine.h.c.a) aVar).a();
                }
                this.k.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.h.d.a) {
                if (t()) {
                    ((io.flutter.embedding.engine.h.d.a) aVar).a();
                }
                this.m.remove(cls);
            }
            aVar.a(this.c);
            this.f150a.remove(cls);
        }
    }

    public void w(Set<Class<? extends io.flutter.embedding.engine.h.a>> set) {
        Iterator<Class<? extends io.flutter.embedding.engine.h.a>> it = set.iterator();
        while (it.hasNext()) {
            v(it.next());
        }
    }

    public void x() {
        w(new HashSet(this.f150a.keySet()));
        this.f150a.clear();
    }
}
