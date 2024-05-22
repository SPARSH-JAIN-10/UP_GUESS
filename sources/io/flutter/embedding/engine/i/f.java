package io.flutter.embedding.engine.i;

import android.os.Build;
import b.a.c.a.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public final b.a.c.a.i f190a;

    /* renamed from: b */
    private b f191b;
    public final i.c c;

    /* loaded from: classes.dex */
    public class a implements i.c {
        a() {
        }

        @Override // b.a.c.a.i.c
        public void a(b.a.c.a.h hVar, i.d dVar) {
            if (f.this.f191b == null) {
                return;
            }
            String str = hVar.f74a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) hVar.a();
            try {
                dVar.b(f.this.f191b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e) {
                dVar.a("error", e.getMessage(), null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        String a(String str, String str2);
    }

    public f(io.flutter.embedding.engine.e.a aVar) {
        a aVar2 = new a();
        this.c = aVar2;
        b.a.c.a.i iVar = new b.a.c.a.i(aVar, "flutter/localization", b.a.c.a.e.f73a);
        this.f190a = iVar;
        iVar.e(aVar2);
    }

    public void b(List<Locale> list) {
        b.a.b.e("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            b.a.b.e("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.f190a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f191b = bVar;
    }
}
