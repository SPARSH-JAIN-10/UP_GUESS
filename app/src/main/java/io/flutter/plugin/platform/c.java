package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private io.flutter.view.c f297a;

    public boolean a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.c cVar = this.f297a;
        if (cVar == null) {
            return false;
        }
        return cVar.r(view, view2, accessibilityEvent);
    }

    public void b(io.flutter.view.c cVar) {
        this.f297a = cVar;
    }
}
