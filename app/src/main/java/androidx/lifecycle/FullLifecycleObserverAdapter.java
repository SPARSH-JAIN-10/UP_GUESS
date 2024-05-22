package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements e {

    /* renamed from: a */
    private final b f34a;

    /* renamed from: b */
    private final e f35b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f36a;

        static {
            int[] iArr = new int[d.a.values().length];
            f36a = iArr;
            try {
                iArr[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36a[d.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36a[d.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36a[d.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        switch (a.f36a[aVar.ordinal()]) {
            case 1:
                this.f34a.e(gVar);
                break;
            case 2:
                this.f34a.f(gVar);
                break;
            case 3:
                this.f34a.a(gVar);
                break;
            case 4:
                this.f34a.b(gVar);
                break;
            case 5:
                this.f34a.d(gVar);
                break;
            case 6:
                this.f34a.c(gVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f35b;
        if (eVar != null) {
            eVar.g(gVar, aVar);
        }
    }
}
