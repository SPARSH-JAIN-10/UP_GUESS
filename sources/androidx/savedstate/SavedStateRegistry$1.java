package androidx.savedstate;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
class SavedStateRegistry$1 implements e {

    /* renamed from: a */
    final /* synthetic */ a f53a;

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        a aVar2;
        boolean z;
        if (aVar == d.a.ON_START) {
            aVar2 = this.f53a;
            z = true;
        } else {
            if (aVar != d.a.ON_STOP) {
                return;
            }
            aVar2 = this.f53a;
            z = false;
        }
        aVar2.f54a = z;
    }
}
