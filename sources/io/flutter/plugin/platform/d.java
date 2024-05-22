package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import io.flutter.embedding.engine.i.i;
import java.io.FileNotFoundException;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private final Activity f298a;

    /* renamed from: b */
    private final io.flutter.embedding.engine.i.i f299b;
    private final c c;
    private i.j d;
    private int e;
    final i.h f;

    /* loaded from: classes.dex */
    public class a implements i.h {
        a() {
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void b() {
            d.this.m();
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void c(int i) {
            d.this.r(i);
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void d(i.c cVar) {
            d.this.p(cVar);
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void e(i.g gVar) {
            d.this.u(gVar);
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void f(List<i.k> list) {
            d.this.q(list);
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void g() {
            d.this.n();
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void h(String str) {
            d.this.o(str);
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public boolean i() {
            CharSequence k = d.this.k(i.e.PLAIN_TEXT);
            return k != null && k.length() > 0;
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void j(i.EnumC0018i enumC0018i) {
            d.this.l(enumC0018i);
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public CharSequence k(i.e eVar) {
            return d.this.k(eVar);
        }

        @Override // io.flutter.embedding.engine.i.i.h
        public void l(i.j jVar) {
            d.this.s(jVar);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f301a;

        /* renamed from: b */
        static final /* synthetic */ int[] f302b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[i.d.values().length];
            c = iArr;
            try {
                iArr[i.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[i.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[i.k.values().length];
            f302b = iArr2;
            try {
                iArr2[i.k.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f302b[i.k.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[i.g.values().length];
            f301a = iArr3;
            try {
                iArr3[i.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f301a[i.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f301a[i.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f301a[i.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f301a[i.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean b();
    }

    public d(Activity activity, io.flutter.embedding.engine.i.i iVar, c cVar) {
        a aVar = new a();
        this.f = aVar;
        this.f298a = activity;
        this.f299b = iVar;
        iVar.j(aVar);
        this.c = cVar;
        this.e = 1280;
    }

    public CharSequence k(i.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f298a.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip == null) {
                return null;
            }
            if (eVar != null && eVar != i.e.PLAIN_TEXT) {
                return null;
            }
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getUri() != null) {
                this.f298a.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
            }
            return itemAt.coerceToText(this.f298a);
        } catch (FileNotFoundException unused) {
            return null;
        } catch (SecurityException e) {
            b.a.b.g("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e);
            return null;
        }
    }

    public void l(i.EnumC0018i enumC0018i) {
        if (enumC0018i == i.EnumC0018i.CLICK) {
            this.f298a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m() {
        c cVar = this.c;
        if (cVar == null || !cVar.b()) {
            Activity activity = this.f298a;
            if (activity instanceof androidx.activity.d) {
                ((androidx.activity.d) activity).i().b();
                throw null;
            }
            activity.finish();
        }
    }

    public void n() {
        t();
    }

    public void o(String str) {
        ((ClipboardManager) this.f298a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    public void p(i.c cVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return;
        }
        if (i < 28 && i > 21) {
            this.f298a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f203b, (Bitmap) null, cVar.f202a));
        }
        if (i >= 28) {
            this.f298a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f203b, 0, cVar.f202a));
        }
    }

    public void q(List<i.k> list) {
        int i = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = b.f302b[list.get(i2).ordinal()];
            if (i3 == 1) {
                i &= -5;
            } else if (i3 == 2) {
                i = i & (-513) & (-3);
            }
        }
        this.e = i;
        t();
    }

    public void r(int i) {
        this.f298a.setRequestedOrientation(i);
    }

    public void s(i.j jVar) {
        Window window = this.f298a.getWindow();
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            i.d dVar = jVar.d;
            if (dVar != null) {
                int i2 = b.c[dVar.ordinal()];
                if (i2 == 1) {
                    systemUiVisibility |= 16;
                } else if (i2 == 2) {
                    systemUiVisibility &= -17;
                }
            }
            Integer num = jVar.c;
            if (num != null) {
                window.setNavigationBarColor(num.intValue());
            }
        }
        if (i >= 23) {
            i.d dVar2 = jVar.f215b;
            if (dVar2 != null) {
                int i3 = b.c[dVar2.ordinal()];
                if (i3 == 1) {
                    systemUiVisibility |= 8192;
                } else if (i3 == 2) {
                    systemUiVisibility &= -8193;
                }
            }
            Integer num2 = jVar.f214a;
            if (num2 != null) {
                window.setStatusBarColor(num2.intValue());
            }
        }
        if (jVar.e != null && i >= 28) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(134217728);
            window.setNavigationBarDividerColor(jVar.e.intValue());
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        this.d = jVar;
    }

    public void j() {
        this.f299b.j(null);
    }

    public void t() {
        this.f298a.getWindow().getDecorView().setSystemUiVisibility(this.e);
        i.j jVar = this.d;
        if (jVar != null) {
            s(jVar);
        }
    }

    void u(i.g gVar) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        View decorView = this.f298a.getWindow().getDecorView();
        int i3 = b.f301a[gVar.ordinal()];
        int i4 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                i4 = 3;
                if (i3 != 3) {
                    i4 = 4;
                    if (i3 != 4) {
                        if (i3 != 5 || i2 < 21) {
                            return;
                        }
                    } else if (i2 < 23) {
                        return;
                    } else {
                        i = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i4);
            return;
        }
        i = 0;
        decorView.performHapticFeedback(i);
    }
}
