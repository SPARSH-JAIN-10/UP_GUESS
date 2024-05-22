package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: a */
    int f38a;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements Object {
        final g d;
        final /* synthetic */ LiveData e;

        public void g(g gVar, d.a aVar) {
            if (this.d.d().a() == d.b.DESTROYED) {
                this.e.d(this.f39a);
            } else {
                h(i());
            }
        }

        boolean i() {
            return this.d.d().a().a(d.b.STARTED);
        }
    }

    /* loaded from: classes.dex */
    private abstract class a {

        /* renamed from: a */
        final j<? super T> f39a;

        /* renamed from: b */
        boolean f40b;
        final /* synthetic */ LiveData c;

        void h(boolean z) {
            if (z == this.f40b) {
                return;
            }
            this.f40b = z;
            LiveData liveData = this.c;
            int i = liveData.f38a;
            boolean z2 = i == 0;
            liveData.f38a = i + (z ? 1 : -1);
            if (z2 && z) {
                liveData.b();
            }
            LiveData liveData2 = this.c;
            if (liveData2.f38a == 0 && !this.f40b) {
                liveData2.c();
            }
            if (this.f40b) {
                this.c.a(this);
            }
        }
    }

    abstract void a(LiveData<T>.a aVar);

    protected abstract void b();

    protected abstract void c();

    public abstract void d(j<? super T> jVar);
}
