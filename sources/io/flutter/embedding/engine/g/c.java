package io.flutter.embedding.engine.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private boolean f169a;

    /* renamed from: b */
    private C0015c f170b;
    private long c;
    private io.flutter.embedding.engine.g.b d;
    private FlutterJNI e;
    Future<b> f;

    /* loaded from: classes.dex */
    public class a implements Callable<b> {

        /* renamed from: a */
        final /* synthetic */ Context f171a;

        /* renamed from: io.flutter.embedding.engine.g.c$a$a */
        /* loaded from: classes.dex */
        public class RunnableC0014a implements Runnable {
            RunnableC0014a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e.prefetchDefaultFontManager();
            }
        }

        a(Context context) {
            this.f171a = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public b call() {
            d f = c.this.f(this.f171a);
            c.this.e.loadLibrary();
            Executors.newSingleThreadExecutor().execute(new RunnableC0014a());
            if (f == null) {
                return new b(b.a.d.a.c(this.f171a), b.a.d.a.a(this.f171a), b.a.d.a.b(this.f171a), null);
            }
            f.a();
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        final String f174a;

        /* renamed from: b */
        final String f175b;

        private b(String str, String str2, String str3) {
            this.f174a = str;
            this.f175b = str2;
        }

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    /* renamed from: io.flutter.embedding.engine.g.c$c */
    /* loaded from: classes.dex */
    public static class C0015c {

        /* renamed from: a */
        private String f176a;

        public String a() {
            return this.f176a;
        }
    }

    public c() {
        this(new FlutterJNI());
    }

    public c(FlutterJNI flutterJNI) {
        this.f169a = false;
        this.e = flutterJNI;
    }

    public d f(Context context) {
        return null;
    }

    public boolean c() {
        return this.d.e;
    }

    public void d(Context context, String[] strArr) {
        if (this.f169a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f170b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            b bVar = this.f.get();
            ArrayList arrayList = new ArrayList();
            arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
            StringBuilder sb = new StringBuilder();
            sb.append("--icu-native-lib-path=");
            sb.append(this.d.d);
            String str = File.separator;
            sb.append(str);
            sb.append("libflutter.so");
            arrayList.add(sb.toString());
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            arrayList.add("--aot-shared-library-name=" + this.d.f167a);
            arrayList.add("--aot-shared-library-name=" + this.d.d + str + this.d.f167a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("--cache-dir-path=");
            sb2.append(bVar.f175b);
            arrayList.add(sb2.toString());
            if (this.d.c != null) {
                arrayList.add("--domain-network-policy=" + this.d.c);
            }
            if (this.f170b.a() != null) {
                arrayList.add("--log-tag=" + this.f170b.a());
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            int i = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
            if (i == 0) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                double d = memoryInfo.totalMem;
                Double.isNaN(d);
                i = (int) ((d / 1000000.0d) / 2.0d);
            }
            arrayList.add("--old-gen-heap-size=" + i);
            if (bundle != null && bundle.getBoolean("io.flutter.embedding.android.EnableSkParagraph")) {
                arrayList.add("--enable-skparagraph");
            }
            this.e.init(context, (String[]) arrayList.toArray(new String[0]), null, bVar.f174a, bVar.f175b, SystemClock.uptimeMillis() - this.c);
            this.f169a = true;
        } catch (Exception e) {
            b.a.b.c("FlutterLoader", "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    public String e() {
        return this.d.f168b;
    }

    public void g(Context context) {
        h(context, new C0015c());
    }

    public void h(Context context, C0015c c0015c) {
        if (this.f170b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        Context applicationContext = context.getApplicationContext();
        this.f170b = c0015c;
        this.c = SystemClock.uptimeMillis();
        this.d = io.flutter.embedding.engine.g.a.e(applicationContext);
        e.b((WindowManager) applicationContext.getSystemService("window")).c();
        this.f = Executors.newSingleThreadExecutor().submit(new a(applicationContext));
    }
}
