package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.i.n;
import io.flutter.plugin.editing.c;
import io.flutter.plugin.platform.j;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d implements c.b {

    /* renamed from: a */
    private final View f274a;

    /* renamed from: b */
    private final InputMethodManager f275b;
    private final AutofillManager c;
    private final n d;
    private c e = new c(c.a.NO_TARGET, 0);
    private n.b f;
    private SparseArray<n.b> g;
    private io.flutter.plugin.editing.c h;
    private boolean i;
    private InputConnection j;
    private j k;
    private Rect l;
    private ImeSyncDeferringInsetsCallback m;
    private io.flutter.embedding.android.a n;
    private n.e o;
    private boolean p;

    /* loaded from: classes.dex */
    public class a implements n.f {
        a() {
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void a(String str, Bundle bundle) {
            d.this.z(str, bundle);
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void b() {
            d.this.v();
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void c() {
            d.this.k();
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void d() {
            d dVar = d.this;
            dVar.E(dVar.f274a);
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void e(int i) {
            d.this.B(i);
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void f(int i, n.b bVar) {
            d.this.C(i, bVar);
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void g(double d, double d2, double[] dArr) {
            d.this.y(d, d2, dArr);
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void h(boolean z) {
            if (Build.VERSION.SDK_INT < 26 || d.this.c == null) {
                return;
            }
            if (z) {
                d.this.c.commit();
            } else {
                d.this.c.cancel();
            }
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void i() {
            d dVar = d.this;
            dVar.q(dVar.f274a);
        }

        @Override // io.flutter.embedding.engine.i.n.f
        public void j(n.e eVar) {
            d dVar = d.this;
            dVar.D(dVar.f274a, eVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements InterfaceC0022d {

        /* renamed from: a */
        final /* synthetic */ boolean f277a;

        /* renamed from: b */
        final /* synthetic */ double[] f278b;
        final /* synthetic */ double[] c;

        b(d dVar, boolean z, double[] dArr, double[] dArr2) {
            this.f277a = z;
            this.f278b = dArr;
            this.c = dArr2;
        }

        @Override // io.flutter.plugin.editing.d.InterfaceC0022d
        public void a(double d, double d2) {
            double d3 = 1.0d;
            if (!this.f277a) {
                double[] dArr = this.f278b;
                d3 = 1.0d / (((dArr[3] * d) + (dArr[7] * d2)) + dArr[15]);
            }
            double[] dArr2 = this.f278b;
            double d4 = ((dArr2[0] * d) + (dArr2[4] * d2) + dArr2[12]) * d3;
            double d5 = ((dArr2[1] * d) + (dArr2[5] * d2) + dArr2[13]) * d3;
            double[] dArr3 = this.c;
            if (d4 < dArr3[0]) {
                dArr3[0] = d4;
            } else if (d4 > dArr3[1]) {
                dArr3[1] = d4;
            }
            if (d5 < dArr3[2]) {
                dArr3[2] = d5;
            } else if (d5 > dArr3[3]) {
                dArr3[3] = d5;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        a f279a;

        /* renamed from: b */
        int f280b;

        /* loaded from: classes.dex */
        public enum a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            PLATFORM_VIEW
        }

        public c(a aVar, int i) {
            this.f279a = aVar;
            this.f280b = i;
        }
    }

    /* renamed from: io.flutter.plugin.editing.d$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0022d {
        void a(double d, double d2);
    }

    @SuppressLint({"NewApi"})
    public d(View view, n nVar, j jVar) {
        this.f274a = view;
        this.f275b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i = Build.VERSION.SDK_INT;
        this.c = i >= 26 ? (AutofillManager) view.getContext().getSystemService(AutofillManager.class) : null;
        if (i >= 30) {
            int navigationBars = (view.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : 0;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (view.getWindowSystemUiVisibility() & 4) == 0 ? navigationBars | WindowInsets.Type.statusBars() : navigationBars, WindowInsets.Type.ime());
            this.m = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.d = nVar;
        nVar.l(new a());
        nVar.i();
        this.k = jVar;
        jVar.u(this);
    }

    public void B(int i) {
        this.f274a.requestFocus();
        this.e = new c(c.a.PLATFORM_VIEW, i);
        this.f275b.restartInput(this.f274a);
        this.i = false;
    }

    public void E(View view) {
        view.requestFocus();
        this.f275b.showSoftInput(view, 0);
    }

    private void G(n.b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (bVar == null || bVar.h == null) {
            this.g = null;
            return;
        }
        n.b[] bVarArr = bVar.i;
        SparseArray<n.b> sparseArray = new SparseArray<>();
        this.g = sparseArray;
        if (bVarArr == null) {
            sparseArray.put(bVar.h.f244a.hashCode(), bVar);
            return;
        }
        for (n.b bVar2 : bVarArr) {
            n.b.a aVar = bVar2.h;
            if (aVar != null) {
                this.g.put(aVar.f244a.hashCode(), bVar2);
                this.c.notifyValueChanged(this.f274a, aVar.f244a.hashCode(), AutofillValue.forText(aVar.c.f250a));
            }
        }
    }

    private static boolean l(n.e eVar, n.e eVar2) {
        int i = eVar.e - eVar.d;
        if (i != eVar2.e - eVar2.d) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (eVar.f250a.charAt(eVar.d + i2) != eVar2.f250a.charAt(eVar2.d + i2)) {
                return true;
            }
        }
        return false;
    }

    public void q(View view) {
        w();
        this.f275b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int r(n.c cVar, boolean z, boolean z2, boolean z3, n.d dVar) {
        n.g gVar = cVar.f246a;
        if (gVar == n.g.DATETIME) {
            return 4;
        }
        if (gVar == n.g.NUMBER) {
            int i = cVar.f247b ? 4098 : 2;
            return cVar.c ? i | 8192 : i;
        }
        if (gVar == n.g.PHONE) {
            return 3;
        }
        int i2 = 1;
        if (gVar == n.g.MULTILINE) {
            i2 = 131073;
        } else if (gVar == n.g.EMAIL_ADDRESS) {
            i2 = 33;
        } else if (gVar == n.g.URL) {
            i2 = 17;
        } else if (gVar == n.g.VISIBLE_PASSWORD) {
            i2 = 145;
        } else if (gVar == n.g.NAME) {
            i2 = 97;
        } else if (gVar == n.g.POSTAL_ADDRESS) {
            i2 = 113;
        }
        if (z) {
            i2 = i2 | 524288 | 128;
        } else {
            if (z2) {
                i2 |= 32768;
            }
            if (!z3) {
                i2 |= 524288;
            }
        }
        return dVar == n.d.CHARACTERS ? i2 | 4096 : dVar == n.d.WORDS ? i2 | 8192 : dVar == n.d.SENTENCES ? i2 | 16384 : i2;
    }

    private boolean t() {
        return this.g != null;
    }

    private void u(String str) {
        if (Build.VERSION.SDK_INT < 26 || this.c == null || !t()) {
            return;
        }
        this.c.notifyValueChanged(this.f274a, this.f.h.f244a.hashCode(), AutofillValue.forText(str));
    }

    public void v() {
        if (Build.VERSION.SDK_INT < 26 || this.c == null || !t()) {
            return;
        }
        String str = this.f.h.f244a;
        int[] iArr = new int[2];
        this.f274a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.l);
        rect.offset(iArr[0], iArr[1]);
        this.c.notifyViewEntered(this.f274a, str.hashCode(), rect);
    }

    private void w() {
        n.b bVar;
        if (Build.VERSION.SDK_INT < 26 || this.c == null || (bVar = this.f) == null || bVar.h == null || !t()) {
            return;
        }
        this.c.notifyViewExited(this.f274a, this.f.h.f244a.hashCode());
    }

    public void y(double d, double d2, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d3 = dArr[12] / dArr[15];
        dArr2[1] = d3;
        dArr2[0] = d3;
        double d4 = dArr[13] / dArr[15];
        dArr2[3] = d4;
        dArr2[2] = d4;
        b bVar = new b(this, z, dArr, dArr2);
        bVar.a(d, 0.0d);
        bVar.a(d, d2);
        bVar.a(0.0d, d2);
        Float valueOf = Float.valueOf(this.f274a.getContext().getResources().getDisplayMetrics().density);
        double d5 = dArr2[0];
        double floatValue = valueOf.floatValue();
        Double.isNaN(floatValue);
        double d6 = dArr2[2];
        double floatValue2 = valueOf.floatValue();
        Double.isNaN(floatValue2);
        int i = (int) (d6 * floatValue2);
        double d7 = dArr2[1];
        double floatValue3 = valueOf.floatValue();
        Double.isNaN(floatValue3);
        int ceil = (int) Math.ceil(d7 * floatValue3);
        double d8 = dArr2[3];
        double floatValue4 = valueOf.floatValue();
        Double.isNaN(floatValue4);
        this.l = new Rect((int) (d5 * floatValue), i, ceil, (int) Math.ceil(d8 * floatValue4));
    }

    public void A(io.flutter.embedding.android.a aVar) {
        this.n = aVar;
    }

    void C(int i, n.b bVar) {
        w();
        this.e = new c(c.a.FRAMEWORK_CLIENT, i);
        io.flutter.plugin.editing.c cVar = this.h;
        if (cVar != null) {
            cVar.j(this);
        }
        n.b.a aVar = bVar.h;
        this.h = new io.flutter.plugin.editing.c(aVar != null ? aVar.c : null, this.f274a);
        this.f = bVar;
        G(bVar);
        this.i = true;
        F();
        this.l = null;
        this.h.a(this);
    }

    void D(View view, n.e eVar) {
        n.e eVar2;
        if (!this.i && (eVar2 = this.o) != null && eVar2.b()) {
            boolean l = l(this.o, eVar);
            this.i = l;
            if (l) {
                b.a.b.d("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.o = eVar;
        this.h.l(eVar);
        if (this.i) {
            this.f275b.restartInput(view);
            this.i = false;
        }
    }

    public void F() {
        this.p = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r7 == r0.e) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // io.flutter.plugin.editing.c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.c r9 = r8.h
            java.lang.String r9 = r9.toString()
            r8.u(r9)
        Lb:
            io.flutter.plugin.editing.c r9 = r8.h
            int r9 = r9.g()
            io.flutter.plugin.editing.c r10 = r8.h
            int r10 = r10.f()
            io.flutter.plugin.editing.c r11 = r8.h
            int r11 = r11.e()
            io.flutter.plugin.editing.c r0 = r8.h
            int r7 = r0.d()
            io.flutter.embedding.engine.i.n$e r0 = r8.o
            if (r0 == 0) goto L4c
            io.flutter.plugin.editing.c r0 = r8.h
            java.lang.String r0 = r0.toString()
            io.flutter.embedding.engine.i.n$e r1 = r8.o
            java.lang.String r1 = r1.f250a
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4a
            io.flutter.embedding.engine.i.n$e r0 = r8.o
            int r1 = r0.f251b
            if (r9 != r1) goto L4a
            int r1 = r0.c
            if (r10 != r1) goto L4a
            int r1 = r0.d
            if (r11 != r1) goto L4a
            int r0 = r0.e
            if (r7 != r0) goto L4a
            goto L4c
        L4a:
            r0 = 0
            goto L4d
        L4c:
            r0 = 1
        L4d:
            if (r0 != 0) goto L90
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "send EditingState to flutter: "
            r0.append(r1)
            io.flutter.plugin.editing.c r1 = r8.h
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TextInputPlugin"
            b.a.b.e(r1, r0)
            io.flutter.embedding.engine.i.n r0 = r8.d
            io.flutter.plugin.editing.d$c r1 = r8.e
            int r1 = r1.f280b
            io.flutter.plugin.editing.c r2 = r8.h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.n(r1, r2, r3, r4, r5, r6)
            io.flutter.embedding.engine.i.n$e r6 = new io.flutter.embedding.engine.i.n$e
            io.flutter.plugin.editing.c r0 = r8.h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.o = r6
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.d.a(boolean, boolean, boolean):void");
    }

    public void i(SparseArray<AutofillValue> sparseArray) {
        n.b.a aVar;
        n.b.a aVar2;
        if (Build.VERSION.SDK_INT >= 26 && (aVar = this.f.h) != null) {
            HashMap<String, n.e> hashMap = new HashMap<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                n.b bVar = this.g.get(sparseArray.keyAt(i));
                if (bVar != null && (aVar2 = bVar.h) != null) {
                    String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                    n.e eVar = new n.e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (aVar2.f244a.equals(aVar.f244a)) {
                        this.h.l(eVar);
                    } else {
                        hashMap.put(aVar2.f244a, eVar);
                    }
                }
            }
            this.d.o(this.e.f280b, hashMap);
        }
    }

    public void j(int i) {
        c cVar = this.e;
        if (cVar.f279a == c.a.PLATFORM_VIEW && cVar.f280b == i) {
            this.e = new c(c.a.NO_TARGET, 0);
            q(this.f274a);
            this.f275b.restartInput(this.f274a);
            this.i = false;
        }
    }

    void k() {
        if (this.e.f279a == c.a.PLATFORM_VIEW) {
            return;
        }
        this.h.j(this);
        w();
        G(null);
        this.e = new c(c.a.NO_TARGET, 0);
        F();
        this.l = null;
    }

    public InputConnection m(View view, EditorInfo editorInfo) {
        InputConnection onCreateInputConnection;
        c cVar = this.e;
        c.a aVar = cVar.f279a;
        if (aVar == c.a.NO_TARGET) {
            onCreateInputConnection = null;
        } else {
            if (aVar != c.a.PLATFORM_VIEW) {
                n.b bVar = this.f;
                int r = r(bVar.e, bVar.f242a, bVar.f243b, bVar.c, bVar.d);
                editorInfo.inputType = r;
                editorInfo.imeOptions = 33554432;
                Integer num = this.f.f;
                int intValue = num == null ? (r & 131072) != 0 ? 1 : 6 : num.intValue();
                String str = this.f.g;
                if (str != null) {
                    editorInfo.actionLabel = str;
                    editorInfo.actionId = intValue;
                }
                editorInfo.imeOptions = intValue | editorInfo.imeOptions;
                io.flutter.plugin.editing.b bVar2 = new io.flutter.plugin.editing.b(view, this.e.f280b, this.d, this.n, this.h, editorInfo);
                editorInfo.initialSelStart = this.h.g();
                editorInfo.initialSelEnd = this.h.f();
                this.j = bVar2;
                return bVar2;
            }
            if (this.p) {
                return this.j;
            }
            onCreateInputConnection = this.k.a(Integer.valueOf(cVar.f280b)).onCreateInputConnection(editorInfo);
        }
        this.j = onCreateInputConnection;
        return onCreateInputConnection;
    }

    @SuppressLint({"NewApi"})
    public void n() {
        this.k.D();
        this.d.l(null);
        w();
        io.flutter.plugin.editing.c cVar = this.h;
        if (cVar != null) {
            cVar.j(this);
        }
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.m;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public InputMethodManager o() {
        return this.f275b;
    }

    public InputConnection p() {
        return this.j;
    }

    public void s() {
        if (this.e.f279a == c.a.PLATFORM_VIEW) {
            this.p = true;
        }
    }

    public void x(ViewStructure viewStructure, int i) {
        ViewStructure viewStructure2;
        CharSequence charSequence;
        Rect rect;
        if (Build.VERSION.SDK_INT < 26 || !t()) {
            return;
        }
        String str = this.f.h.f244a;
        AutofillId autofillId = viewStructure.getAutofillId();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            int keyAt = this.g.keyAt(i2);
            n.b.a aVar = this.g.valueAt(i2).h;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i2);
                newChild.setAutofillId(autofillId, keyAt);
                newChild.setAutofillHints(aVar.f245b);
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                if (str.hashCode() != keyAt || (rect = this.l) == null) {
                    viewStructure2 = newChild;
                    viewStructure2.setDimens(0, 0, 0, 0, 1, 1);
                    charSequence = aVar.c.f250a;
                } else {
                    viewStructure2 = newChild;
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.l.height());
                    charSequence = this.h;
                }
                viewStructure2.setAutofillValue(AutofillValue.forText(charSequence));
            }
        }
    }

    public void z(String str, Bundle bundle) {
        this.f275b.sendAppPrivateCommand(this.f274a, str, bundle);
    }
}
