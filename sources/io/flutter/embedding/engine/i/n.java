package io.flutter.embedding.engine.i;

import android.os.Bundle;
import b.a.c.a.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a */
    public final b.a.c.a.i f239a;

    /* renamed from: b */
    private f f240b;
    private final i.c c;

    /* loaded from: classes.dex */
    public class a implements i.c {
        a() {
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00b5. Please report as an issue. */
        @Override // b.a.c.a.i.c
        public void a(b.a.c.a.h hVar, i.d dVar) {
            String message;
            Bundle bundle;
            if (n.this.f240b == null) {
                return;
            }
            String str = hVar.f74a;
            Object obj = hVar.f75b;
            b.a.b.e("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c = 1;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c = 3;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c = 4;
                        break;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            try {
                switch (c) {
                    case 0:
                        n.this.f240b.e(((Integer) obj).intValue());
                        return;
                    case 1:
                        n.this.f240b.j(e.a((JSONObject) obj));
                        dVar.b(null);
                        return;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            n.this.f240b.f(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                            dVar.b(null);
                            return;
                        } catch (NoSuchFieldException | JSONException e) {
                            message = e.getMessage();
                            dVar.a("error", message, null);
                            return;
                        }
                    case 3:
                        n.this.f240b.i();
                        dVar.b(null);
                        return;
                    case 4:
                        n.this.f240b.d();
                        dVar.b(null);
                        return;
                    case 5:
                        JSONObject jSONObject = (JSONObject) obj;
                        String string = jSONObject.getString("action");
                        String string2 = jSONObject.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        n.this.f240b.a(string, bundle);
                        dVar.b(null);
                        return;
                    case 6:
                        JSONObject jSONObject2 = (JSONObject) obj;
                        double d = jSONObject2.getDouble("width");
                        double d2 = jSONObject2.getDouble("height");
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i = 0; i < 16; i++) {
                            dArr[i] = jSONArray2.getDouble(i);
                        }
                        n.this.f240b.g(d, d2, dArr);
                        return;
                    case 7:
                        n.this.f240b.h(((Boolean) obj).booleanValue());
                        dVar.b(null);
                        return;
                    case '\b':
                        n.this.f240b.c();
                        dVar.b(null);
                        return;
                    case '\t':
                        n.this.f240b.b();
                        dVar.b(null);
                        return;
                    default:
                        dVar.c();
                        return;
                }
            } catch (JSONException e2) {
                message = e2.getMessage();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final boolean f242a;

        /* renamed from: b */
        public final boolean f243b;
        public final boolean c;
        public final d d;
        public final c e;
        public final Integer f;
        public final String g;
        public final a h;
        public final b[] i;

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a */
            public final String f244a;

            /* renamed from: b */
            public final String[] f245b;
            public final e c;

            public a(String str, String[] strArr, e eVar) {
                this.f244a = str;
                this.f245b = strArr;
                this.c = eVar;
            }

            public static a a(JSONObject jSONObject) {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = b(jSONArray.getString(i));
                }
                return new a(string, strArr, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x00a3, code lost:
            
                if (r16.equals("familyName") == false) goto L643;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static java.lang.String b(java.lang.String r16) {
                /*
                    Method dump skipped, instructions count: 802
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.n.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z, boolean z2, boolean z3, d dVar, c cVar, Integer num, String str, a aVar, b[] bVarArr) {
            this.f242a = z;
            this.f243b = z2;
            this.c = z3;
            this.d = dVar;
            this.e = cVar;
            this.f = num;
            this.g = str;
            this.h = aVar;
            this.i = bVarArr;
        }

        public static b a(JSONObject jSONObject) {
            b[] bVarArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                b[] bVarArr2 = new b[length];
                for (int i = 0; i < length; i++) {
                    bVarArr2[i] = a(jSONArray.getJSONObject(i));
                }
                bVarArr = bVarArr2;
            }
            return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), d.a(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), b(string), jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), bVarArr);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0072, code lost:
        
            if (r12.equals("TextInputAction.done") == false) goto L175;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.lang.Integer b(java.lang.String r12) {
            /*
                r12.hashCode()
                int r0 = r12.hashCode()
                r1 = 7
                r2 = 6
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 0
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                r11 = -1
                switch(r0) {
                    case -810971940: goto L75;
                    case -737377923: goto L6c;
                    case -737089298: goto L61;
                    case -737080013: goto L56;
                    case -736940669: goto L4b;
                    case 469250275: goto L40;
                    case 1241689507: goto L35;
                    case 1539450297: goto L2a;
                    case 2110497650: goto L1e;
                    default: goto L1b;
                }
            L1b:
                r7 = -1
                goto L7f
            L1e:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L27
                goto L1b
            L27:
                r7 = 8
                goto L7f
            L2a:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L33
                goto L1b
            L33:
                r7 = 7
                goto L7f
            L35:
                java.lang.String r0 = "TextInputAction.go"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L3e
                goto L1b
            L3e:
                r7 = 6
                goto L7f
            L40:
                java.lang.String r0 = "TextInputAction.search"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L49
                goto L1b
            L49:
                r7 = 5
                goto L7f
            L4b:
                java.lang.String r0 = "TextInputAction.send"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L54
                goto L1b
            L54:
                r7 = 4
                goto L7f
            L56:
                java.lang.String r0 = "TextInputAction.none"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L5f
                goto L1b
            L5f:
                r7 = 3
                goto L7f
            L61:
                java.lang.String r0 = "TextInputAction.next"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L6a
                goto L1b
            L6a:
                r7 = 2
                goto L7f
            L6c:
                java.lang.String r0 = "TextInputAction.done"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7f
                goto L1b
            L75:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7e
                goto L1b
            L7e:
                r7 = 0
            L7f:
                switch(r7) {
                    case 0: goto La3;
                    case 1: goto L9e;
                    case 2: goto L99;
                    case 3: goto L98;
                    case 4: goto L93;
                    case 5: goto L8e;
                    case 6: goto L89;
                    case 7: goto L88;
                    case 8: goto L83;
                    default: goto L82;
                }
            L82:
                return r10
            L83:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L88:
                return r8
            L89:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
                return r12
            L8e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L93:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L98:
                return r8
            L99:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L9e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            La3:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.n.b.b(java.lang.String):java.lang.Integer");
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public final g f246a;

        /* renamed from: b */
        public final boolean f247b;
        public final boolean c;

        public c(g gVar, boolean z, boolean z2) {
            this.f246a = gVar;
            this.f247b = z;
            this.c = z2;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.a(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        /* renamed from: a */
        private final String f249a;

        d(String str) {
            this.f249a = str;
        }

        static d a(String str) {
            for (d dVar : values()) {
                if (dVar.f249a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a */
        public final String f250a;

        /* renamed from: b */
        public final int f251b;
        public final int c;
        public final int d;
        public final int e;

        public e(String str, int i, int i2, int i3, int i4) {
            if (!(i == -1 && i2 == -1) && (i < 0 || i2 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i) + ", " + String.valueOf(i2) + ")");
            }
            if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i3 >= i4)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i3) + ", " + String.valueOf(i4) + ")");
            }
            if (i4 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i3));
            }
            if (i > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i));
            }
            if (i2 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i2));
            }
            this.f250a = str;
            this.f251b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i = this.d;
            return i >= 0 && this.e > i;
        }

        public boolean c() {
            return this.f251b >= 0;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str, Bundle bundle);

        void b();

        void c();

        void d();

        void e(int i);

        void f(int i, b bVar);

        void g(double d, double d2, double[] dArr);

        void h(boolean z);

        void i();

        void j(e eVar);
    }

    /* loaded from: classes.dex */
    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword");


        /* renamed from: a */
        private final String f253a;

        g(String str) {
            this.f253a = str;
        }

        static g a(String str) {
            for (g gVar : values()) {
                if (gVar.f253a.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public n(io.flutter.embedding.engine.e.a aVar) {
        a aVar2 = new a();
        this.c = aVar2;
        b.a.c.a.i iVar = new b.a.c.a.i(aVar, "flutter/textinput", b.a.c.a.e.f73a);
        this.f239a = iVar;
        iVar.e(aVar2);
    }

    private static HashMap<Object, Object> b(String str, int i, int i2, int i3, int i4) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i));
        hashMap.put("selectionExtent", Integer.valueOf(i2));
        hashMap.put("composingBase", Integer.valueOf(i3));
        hashMap.put("composingExtent", Integer.valueOf(i4));
        return hashMap;
    }

    public void c(int i) {
        b.a.b.e("TextInputChannel", "Sending 'done' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.done"));
    }

    public void d(int i) {
        b.a.b.e("TextInputChannel", "Sending 'go' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.go"));
    }

    public void e(int i) {
        b.a.b.e("TextInputChannel", "Sending 'newline' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.newline"));
    }

    public void f(int i) {
        b.a.b.e("TextInputChannel", "Sending 'next' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.next"));
    }

    public void g(int i, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.f239a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i), hashMap));
    }

    public void h(int i) {
        b.a.b.e("TextInputChannel", "Sending 'previous' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.previous"));
    }

    public void i() {
        this.f239a.c("TextInputClient.requestExistingInputState", null);
    }

    public void j(int i) {
        b.a.b.e("TextInputChannel", "Sending 'search' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.search"));
    }

    public void k(int i) {
        b.a.b.e("TextInputChannel", "Sending 'send' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.send"));
    }

    public void l(f fVar) {
        this.f240b = fVar;
    }

    public void m(int i) {
        b.a.b.e("TextInputChannel", "Sending 'unspecified' message.");
        this.f239a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.unspecified"));
    }

    public void n(int i, String str, int i2, int i3, int i4, int i5) {
        b.a.b.e("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i2 + "\nSelection end: " + i3 + "\nComposing start: " + i4 + "\nComposing end: " + i5);
        this.f239a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i), b(str, i2, i3, i4, i5)));
    }

    public void o(int i, HashMap<String, e> hashMap) {
        b.a.b.e("TextInputChannel", "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, e> entry : hashMap.entrySet()) {
            e value = entry.getValue();
            hashMap2.put(entry.getKey(), b(value.f250a, value.f251b, value.c, -1, -1));
        }
        this.f239a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i), hashMap2));
    }
}
