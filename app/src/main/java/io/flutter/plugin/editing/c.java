package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import io.flutter.embedding.engine.i.n;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c extends SpannableStringBuilder {

    /* renamed from: a */
    private int f271a = 0;

    /* renamed from: b */
    private int f272b = 0;
    private ArrayList<b> c = new ArrayList<>();
    private ArrayList<b> d = new ArrayList<>();
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private BaseInputConnection k;

    /* loaded from: classes.dex */
    public class a extends BaseInputConnection {

        /* renamed from: a */
        final /* synthetic */ Editable f273a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c cVar, View view, boolean z, Editable editable) {
            super(view, z);
            this.f273a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f273a;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z, boolean z2, boolean z3);
    }

    public c(n.e eVar, View view) {
        if (eVar != null) {
            l(eVar);
        }
        this.k = new a(this, view, true, this);
    }

    private void h(b bVar, boolean z, boolean z2, boolean z3) {
        this.f272b++;
        bVar.a(z, z2, z3);
        this.f272b--;
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (z || z2 || z3) {
            Iterator<b> it = this.c.iterator();
            while (it.hasNext()) {
                h(it.next(), z, z2, z3);
            }
        }
    }

    public void a(b bVar) {
        ArrayList<b> arrayList;
        if (this.f272b > 0) {
            b.a.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f271a > 0) {
            b.a.b.f("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.d;
        } else {
            arrayList = this.c;
        }
        arrayList.add(bVar);
    }

    public void b() {
        this.f271a++;
        if (this.f272b > 0) {
            b.a.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f271a != 1 || this.c.isEmpty()) {
            return;
        }
        this.f = toString();
        this.g = g();
        this.h = f();
        this.i = e();
        this.j = d();
    }

    public void c() {
        int i = this.f271a;
        if (i == 0) {
            b.a.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i == 1) {
            Iterator<b> it = this.d.iterator();
            while (it.hasNext()) {
                h(it.next(), true, true, true);
            }
            if (!this.c.isEmpty()) {
                b.a.b.e("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.c.size()) + " listener(s)");
                i(!toString().equals(this.f), (this.g == g() && this.h == f()) ? false : true, (this.i == e() && this.j == d()) ? false : true);
            }
        }
        this.c.addAll(this.d);
        this.d.clear();
        this.f271a--;
    }

    public final int d() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int e() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int f() {
        return Selection.getSelectionEnd(this);
    }

    public final int g() {
        return Selection.getSelectionStart(this);
    }

    public void j(b bVar) {
        if (this.f272b > 0) {
            b.a.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.c.remove(bVar);
        if (this.f271a > 0) {
            this.d.remove(bVar);
        }
    }

    public void k(int i, int i2) {
        if (i < 0 || i >= i2) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.k.setComposingRegion(i, i2);
        }
    }

    public void l(n.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f250a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f251b, eVar.c);
        } else {
            Selection.removeSelection(this);
        }
        k(eVar.d, eVar.e);
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (this.f272b > 0) {
            b.a.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        int i5 = i2 - i;
        boolean z = true;
        boolean z2 = i5 != i4 - i3;
        for (int i6 = 0; i6 < i5 && !z2; i6++) {
            z2 |= charAt(i + i6) != charSequence.charAt(i3 + i6);
        }
        if (z2) {
            this.e = null;
        }
        int g = g();
        int f = f();
        int e = e();
        int d = d();
        SpannableStringBuilder replace = super.replace(i, i2, charSequence, i3, i4);
        if (this.f271a > 0) {
            return replace;
        }
        boolean z3 = (g() == g && f() == f) ? false : true;
        if (e() == e && d() == d) {
            z = false;
        }
        i(z2, z3, z);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.e = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
