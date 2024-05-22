package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
class Fragment$2 implements e {

    /* renamed from: a */
    final /* synthetic */ a f31a;

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        View view;
        if (aVar != d.a.ON_STOP || (view = this.f31a.f32a) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}
