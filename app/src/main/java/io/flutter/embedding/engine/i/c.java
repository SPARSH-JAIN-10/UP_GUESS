package io.flutter.embedding.engine.i;

import b.a.c.a.i;
import b.a.c.a.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private final b.a.c.a.i f182a;

    /* renamed from: b */
    private io.flutter.embedding.engine.f.a f183b;
    private Map<String, List<i.d>> c;
    final i.c d;

    /* loaded from: classes.dex */
    public class a implements i.c {
        a() {
        }

        @Override // b.a.c.a.i.c
        public void a(b.a.c.a.h hVar, i.d dVar) {
            String str;
            if (c.this.f183b == null) {
                return;
            }
            String str2 = hVar.f74a;
            Map map = (Map) hVar.a();
            b.a.b.e("DeferredComponentChannel", "Received '" + str2 + "' message.");
            int intValue = ((Integer) map.get("loadingUnitId")).intValue();
            String str3 = (String) map.get("componentName");
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1004447972:
                    if (str2.equals("uninstallDeferredComponent")) {
                        c = 0;
                        break;
                    }
                    break;
                case 399701758:
                    if (str2.equals("getDeferredComponentInstallState")) {
                        c = 1;
                        break;
                    }
                    break;
                case 520962947:
                    if (str2.equals("installDeferredComponent")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    c.this.f183b.c(intValue, str3);
                    str = null;
                    break;
                case 1:
                    str = c.this.f183b.a(intValue, str3);
                    break;
                case 2:
                    c.this.f183b.b(intValue, str3);
                    if (!c.this.c.containsKey(str3)) {
                        c.this.c.put(str3, new ArrayList());
                    }
                    ((List) c.this.c.get(str3)).add(dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
            dVar.b(str);
        }
    }

    public c(io.flutter.embedding.engine.e.a aVar) {
        a aVar2 = new a();
        this.d = aVar2;
        b.a.c.a.i iVar = new b.a.c.a.i(aVar, "flutter/deferredcomponent", p.f86b);
        this.f182a = iVar;
        iVar.e(aVar2);
        this.f183b = b.a.a.c().a();
        this.c = new HashMap();
    }

    public void c(io.flutter.embedding.engine.f.a aVar) {
        this.f183b = aVar;
    }
}
