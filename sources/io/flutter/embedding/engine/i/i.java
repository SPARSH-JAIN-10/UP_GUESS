package io.flutter.embedding.engine.i;

import b.a.c.a.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    public final b.a.c.a.i f197a;

    /* renamed from: b */
    private h f198b;
    final i.c c;

    /* loaded from: classes.dex */
    public class a implements i.c {
        a() {
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:11:0x00a8. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0107 A[Catch: JSONException -> 0x01d4, TryCatch #2 {JSONException -> 0x01d4, blocks: (B:7:0x002c, B:8:0x0030, B:12:0x00ab, B:14:0x00b0, B:16:0x00c9, B:17:0x00d8, B:19:0x00dd, B:27:0x00e1, B:22:0x00fb, B:24:0x0107, B:29:0x00e6, B:30:0x0114, B:31:0x0140, B:47:0x01a1, B:33:0x01ba, B:69:0x0137, B:38:0x013b, B:63:0x0163, B:45:0x017f, B:57:0x019c, B:51:0x01b5, B:37:0x01ce, B:70:0x0035, B:73:0x0040, B:76:0x004a, B:79:0x0055, B:82:0x005f, B:85:0x006a, B:88:0x0074, B:91:0x007e, B:94:0x0088, B:97:0x0092, B:100:0x009d, B:41:0x0168), top: B:6:0x002c, inners: #3, #7, #8, #9 }] */
        @Override // b.a.c.a.i.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(b.a.c.a.h r6, b.a.c.a.i.d r7) {
            /*
                Method dump skipped, instructions count: 566
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.i.a.a(b.a.c.a.h, b.a.c.a.i$d):void");
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f200a;

        /* renamed from: b */
        static final /* synthetic */ int[] f201b;

        static {
            int[] iArr = new int[k.values().length];
            f201b = iArr;
            try {
                iArr[k.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f201b[k.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[f.values().length];
            f200a = iArr2;
            try {
                iArr2[f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f200a[f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f200a[f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f200a[f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public final int f202a;

        /* renamed from: b */
        public final String f203b;

        public c(int i, String str) {
            this.f202a = i;
            this.f203b = str;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");


        /* renamed from: a */
        private String f205a;

        d(String str) {
            this.f205a = str;
        }

        static d a(String str) {
            for (d dVar : values()) {
                if (dVar.f205a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        PLAIN_TEXT("text/plain");


        /* renamed from: a */
        private String f207a;

        e(String str) {
            this.f207a = str;
        }

        static e a(String str) {
            for (e eVar : values()) {
                if (eVar.f207a.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");


        /* renamed from: a */
        private String f209a;

        f(String str) {
            this.f209a = str;
        }

        static f a(String str) {
            for (f fVar : values()) {
                if (fVar.f209a.equals(str)) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");


        /* renamed from: a */
        private final String f211a;

        g(String str) {
            this.f211a = str;
        }

        static g a(String str) {
            for (g gVar : values()) {
                String str2 = gVar.f211a;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void b();

        void c(int i);

        void d(c cVar);

        void e(g gVar);

        void f(List<k> list);

        void g();

        void h(String str);

        boolean i();

        void j(EnumC0018i enumC0018i);

        CharSequence k(e eVar);

        void l(j jVar);
    }

    /* renamed from: io.flutter.embedding.engine.i.i$i */
    /* loaded from: classes.dex */
    public enum EnumC0018i {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");


        /* renamed from: a */
        private final String f213a;

        EnumC0018i(String str) {
            this.f213a = str;
        }

        static EnumC0018i a(String str) {
            for (EnumC0018i enumC0018i : values()) {
                if (enumC0018i.f213a.equals(str)) {
                    return enumC0018i;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a */
        public final Integer f214a;

        /* renamed from: b */
        public final d f215b;
        public final Integer c;
        public final d d;
        public final Integer e;

        public j(Integer num, d dVar, Integer num2, d dVar2, Integer num3) {
            this.f214a = num;
            this.f215b = dVar;
            this.c = num2;
            this.d = dVar2;
            this.e = num3;
        }
    }

    /* loaded from: classes.dex */
    public enum k {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");


        /* renamed from: a */
        private String f217a;

        k(String str) {
            this.f217a = str;
        }

        static k a(String str) {
            for (k kVar : values()) {
                if (kVar.f217a.equals(str)) {
                    return kVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public i(io.flutter.embedding.engine.e.a aVar) {
        a aVar2 = new a();
        this.c = aVar2;
        b.a.c.a.i iVar = new b.a.c.a.i(aVar, "flutter/platform", b.a.c.a.e.f73a);
        this.f197a = iVar;
        iVar.e(aVar2);
    }

    public c f(JSONObject jSONObject) {
        int i = jSONObject.getInt("primaryColor");
        if (i != 0) {
            i |= -16777216;
        }
        return new c(i, jSONObject.getString("label"));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x003e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int g(org.json.JSONArray r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L38
            java.lang.String r4 = r10.getString(r1)
            io.flutter.embedding.engine.i.i$f r4 = io.flutter.embedding.engine.i.i.f.a(r4)
            int[] r8 = io.flutter.embedding.engine.i.i.b.f200a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L30
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L2a
            if (r4 == r5) goto L27
            goto L32
        L27:
            r2 = r2 | 8
            goto L32
        L2a:
            r2 = r2 | 2
            goto L32
        L2d:
            r2 = r2 | 4
            goto L32
        L30:
            r2 = r2 | 1
        L32:
            if (r3 != 0) goto L35
            r3 = r2
        L35:
            int r1 = r1 + 1
            goto L4
        L38:
            if (r2 == 0) goto L57
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L56;
                case 3: goto L4d;
                case 4: goto L4c;
                case 5: goto L4a;
                case 6: goto L4d;
                case 7: goto L4d;
                case 8: goto L49;
                case 9: goto L4d;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L4d;
                case 15: goto L42;
                default: goto L41;
            }
        L41:
            goto L53
        L42:
            r10 = 13
            return r10
        L45:
            return r6
        L46:
            r10 = 11
            return r10
        L49:
            return r1
        L4a:
            r10 = 12
        L4c:
            return r10
        L4d:
            if (r3 == r6) goto L56
            if (r3 == r5) goto L55
            if (r3 == r1) goto L54
        L53:
            return r7
        L54:
            return r1
        L55:
            return r10
        L56:
            return r0
        L57:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.i.g(org.json.JSONArray):int");
    }

    public j h(JSONObject jSONObject) {
        d a2 = !jSONObject.isNull("systemNavigationBarIconBrightness") ? d.a(jSONObject.getString("systemNavigationBarIconBrightness")) : null;
        Integer valueOf = !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null;
        return new j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? d.a(jSONObject.getString("statusBarIconBrightness")) : null, valueOf, a2, jSONObject.isNull("systemNavigationBarDividerColor") ? null : Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")));
    }

    public List<k> i(JSONArray jSONArray) {
        k kVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = b.f201b[k.a(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                kVar = k.TOP_OVERLAYS;
            } else if (i2 == 2) {
                kVar = k.BOTTOM_OVERLAYS;
            }
            arrayList.add(kVar);
        }
        return arrayList;
    }

    public void j(h hVar) {
        this.f198b = hVar;
    }
}
