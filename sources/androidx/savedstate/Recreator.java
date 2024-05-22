package androidx.savedstate;

import android.annotation.SuppressLint;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements e {

    /* renamed from: a */
    private final b f52a;

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        if (aVar != d.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        gVar.d().b(this);
        this.f52a.j().a("androidx.savedstate.Restarter");
        throw null;
    }
}
