package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements e {

    /* renamed from: a */
    private final c[] f33a;

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        i iVar = new i();
        for (c cVar : this.f33a) {
            cVar.a(gVar, aVar, false, iVar);
        }
        for (c cVar2 : this.f33a) {
            cVar2.a(gVar, aVar, true, iVar);
        }
    }
}
