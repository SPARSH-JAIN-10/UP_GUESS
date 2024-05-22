package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements e, a {

        /* renamed from: a */
        private final androidx.lifecycle.d f25a;

        /* renamed from: b */
        private final c f26b;
        private a c;
        final /* synthetic */ OnBackPressedDispatcher d;

        @Override // androidx.activity.a
        public void cancel() {
            this.f25a.b(this);
            this.f26b.a(this);
            a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
                this.c = null;
            }
        }

        @Override // androidx.lifecycle.e
        public void g(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                this.d.a(this.f26b);
                throw null;
            }
            if (aVar != d.a.ON_STOP) {
                if (aVar == d.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }

    a a(c cVar) {
        throw null;
    }

    public void b() {
        throw null;
    }
}
