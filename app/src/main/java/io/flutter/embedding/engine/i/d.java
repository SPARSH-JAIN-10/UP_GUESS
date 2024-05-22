package io.flutter.embedding.engine.i;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import b.a.c.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private a f185a;

    /* renamed from: b */
    public final b.a.c.a.a<Object> f186b;

    /* loaded from: classes.dex */
    public interface a {
        void a(KeyEvent keyEvent);

        void b(KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final KeyEvent f187a;

        /* renamed from: b */
        public final Character f188b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f187a = keyEvent;
            this.f188b = ch;
        }
    }

    public d(b.a.c.a.b bVar) {
        this.f186b = new b.a.c.a.a<>(bVar, "flutter/keyevent", b.a.c.a.d.f72a);
    }

    private void b(b bVar, Map<String, Object> map) {
        int i;
        map.put("flags", Integer.valueOf(bVar.f187a.getFlags()));
        int i2 = 0;
        map.put("plainCodePoint", Integer.valueOf(bVar.f187a.getUnicodeChar(0)));
        map.put("codePoint", Integer.valueOf(bVar.f187a.getUnicodeChar()));
        map.put("keyCode", Integer.valueOf(bVar.f187a.getKeyCode()));
        map.put("scanCode", Integer.valueOf(bVar.f187a.getScanCode()));
        map.put("metaState", Integer.valueOf(bVar.f187a.getMetaState()));
        Character ch = bVar.f188b;
        if (ch != null) {
            map.put("character", ch.toString());
        }
        map.put("source", Integer.valueOf(bVar.f187a.getSource()));
        InputDevice device = InputDevice.getDevice(bVar.f187a.getDeviceId());
        if (device == null || Build.VERSION.SDK_INT < 19) {
            i = 0;
        } else {
            i2 = device.getVendorId();
            i = device.getProductId();
        }
        map.put("vendorId", Integer.valueOf(i2));
        map.put("productId", Integer.valueOf(i));
        map.put("deviceId", Integer.valueOf(bVar.f187a.getDeviceId()));
        map.put("repeatCount", Integer.valueOf(bVar.f187a.getRepeatCount()));
    }

    /* renamed from: e */
    public /* synthetic */ void f(KeyEvent keyEvent, Object obj) {
        a aVar = this.f185a;
        if (aVar == null) {
            return;
        }
        try {
            if (obj == null) {
                aVar.a(keyEvent);
            } else if (((JSONObject) obj).getBoolean("handled")) {
                this.f185a.b(keyEvent);
            } else {
                this.f185a.a(keyEvent);
            }
        } catch (JSONException e) {
            b.a.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e);
            this.f185a.a(keyEvent);
        }
    }

    a.e<Object> a(KeyEvent keyEvent) {
        return new a.e() { // from class: io.flutter.embedding.engine.i.a

            /* renamed from: b */
            public final /* synthetic */ KeyEvent f178b;

            public /* synthetic */ a(KeyEvent keyEvent2) {
                keyEvent = keyEvent2;
            }

            @Override // b.a.c.a.a.e
            public final void a(Object obj) {
                d.this.f(keyEvent, obj);
            }
        };
    }

    public void c(b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keydown");
        hashMap.put("keymap", "android");
        b(bVar, hashMap);
        this.f186b.d(hashMap, a(bVar.f187a));
    }

    public void d(b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keyup");
        hashMap.put("keymap", "android");
        b(bVar, hashMap);
        this.f186b.d(hashMap, a(bVar.f187a));
    }

    public void g(a aVar) {
        this.f185a = aVar;
    }
}
