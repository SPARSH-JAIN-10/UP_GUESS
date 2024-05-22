package io.flutter.embedding.engine.i;

import b.a.c.a.a;
import b.a.c.a.o;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.c;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public final b.a.c.a.a<Object> f179a;

    /* renamed from: b */
    public final FlutterJNI f180b;
    private InterfaceC0017b c;
    private final a.d<Object> d;

    /* loaded from: classes.dex */
    public class a implements a.d<Object> {
        a() {
        }

        @Override // b.a.c.a.a.d
        public void a(Object obj, a.e<Object> eVar) {
            if (b.this.c == null) {
                return;
            }
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            HashMap hashMap2 = (HashMap) hashMap.get("data");
            b.a.b.e("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1140076541:
                    if (str.equals("tooltip")) {
                        c = 0;
                        break;
                    }
                    break;
                case -649620375:
                    if (str.equals("announce")) {
                        c = 1;
                        break;
                    }
                    break;
                case 114595:
                    if (str.equals("tap")) {
                        c = 2;
                        break;
                    }
                    break;
                case 114203431:
                    if (str.equals("longPress")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        b.this.c.b(str2);
                        break;
                    }
                    break;
                case 1:
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        b.this.c.f(str3);
                        break;
                    }
                    break;
                case 2:
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        b.this.c.e(num.intValue());
                        break;
                    }
                    break;
                case 3:
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        b.this.c.d(num2.intValue());
                        break;
                    }
                    break;
            }
            eVar.a(null);
        }
    }

    /* renamed from: io.flutter.embedding.engine.i.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0017b extends FlutterJNI.a {
        void b(String str);

        void d(int i);

        void e(int i);

        void f(String str);
    }

    public b(io.flutter.embedding.engine.e.a aVar, FlutterJNI flutterJNI) {
        a aVar2 = new a();
        this.d = aVar2;
        b.a.c.a.a<Object> aVar3 = new b.a.c.a.a<>(aVar, "flutter/accessibility", o.f84a);
        this.f179a = aVar3;
        aVar3.e(aVar2);
        this.f180b = flutterJNI;
    }

    public void b(int i, c.f fVar) {
        this.f180b.dispatchSemanticsAction(i, fVar);
    }

    public void c(int i, c.f fVar, Object obj) {
        this.f180b.dispatchSemanticsAction(i, fVar, obj);
    }

    public void d() {
        this.f180b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f180b.setSemanticsEnabled(true);
    }

    public void f(int i) {
        this.f180b.setAccessibilityFeatures(i);
    }

    public void g(InterfaceC0017b interfaceC0017b) {
        this.c = interfaceC0017b;
        this.f180b.setAccessibilityDelegate(interfaceC0017b);
    }
}
