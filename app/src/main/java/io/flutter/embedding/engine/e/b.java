package io.flutter.embedding.engine.e;

import b.a.c.a.b;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b implements b.a.c.a.b, c {

    /* renamed from: a */
    private final FlutterJNI f161a;
    private int d = 1;

    /* renamed from: b */
    private final Map<String, b.a> f162b = new HashMap();
    private final Map<Integer, b.InterfaceC0006b> c = new HashMap();

    /* loaded from: classes.dex */
    static class a implements b.InterfaceC0006b {

        /* renamed from: a */
        private final FlutterJNI f163a;

        /* renamed from: b */
        private final int f164b;
        private final AtomicBoolean c = new AtomicBoolean(false);

        a(FlutterJNI flutterJNI, int i) {
            this.f163a = flutterJNI;
            this.f164b = i;
        }

        @Override // b.a.c.a.b.InterfaceC0006b
        public void a(ByteBuffer byteBuffer) {
            if (this.c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f163a.invokePlatformMessageEmptyResponseCallback(this.f164b);
            } else {
                this.f163a.invokePlatformMessageResponseCallback(this.f164b, byteBuffer, byteBuffer.position());
            }
        }
    }

    public b(FlutterJNI flutterJNI) {
        this.f161a = flutterJNI;
    }

    private static void e(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    @Override // b.a.c.a.b
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0006b interfaceC0006b) {
        int i;
        b.a.b.e("DartMessenger", "Sending message with callback over channel '" + str + "'");
        if (interfaceC0006b != null) {
            i = this.d;
            this.d = i + 1;
            this.c.put(Integer.valueOf(i), interfaceC0006b);
        } else {
            i = 0;
        }
        if (byteBuffer == null) {
            this.f161a.dispatchEmptyPlatformMessage(str, i);
        } else {
            this.f161a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
        }
    }

    @Override // io.flutter.embedding.engine.e.c
    public void b(int i, byte[] bArr) {
        b.a.b.e("DartMessenger", "Received message reply from Dart.");
        b.InterfaceC0006b remove = this.c.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                b.a.b.e("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.a(bArr == null ? null : ByteBuffer.wrap(bArr));
            } catch (Error e) {
                e(e);
            } catch (Exception e2) {
                b.a.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e2);
            }
        }
    }

    @Override // io.flutter.embedding.engine.e.c
    public void c(String str, byte[] bArr, int i) {
        b.a.b.e("DartMessenger", "Received message from Dart over channel '" + str + "'");
        b.a aVar = this.f162b.get(str);
        if (aVar != null) {
            try {
                b.a.b.e("DartMessenger", "Deferring to registered handler to process message.");
                aVar.a(bArr == null ? null : ByteBuffer.wrap(bArr), new a(this.f161a, i));
                return;
            } catch (Error e) {
                e(e);
                return;
            } catch (Exception e2) {
                b.a.b.c("DartMessenger", "Uncaught exception in binary message listener", e2);
            }
        } else {
            b.a.b.e("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f161a.invokePlatformMessageEmptyResponseCallback(i);
    }

    @Override // b.a.c.a.b
    public void d(String str, b.a aVar) {
        if (aVar == null) {
            b.a.b.e("DartMessenger", "Removing handler for channel '" + str + "'");
            this.f162b.remove(str);
            return;
        }
        b.a.b.e("DartMessenger", "Setting handler for channel '" + str + "'");
        this.f162b.put(str, aVar);
    }
}
