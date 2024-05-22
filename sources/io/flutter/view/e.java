package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public class e {
    private static e c;

    /* renamed from: a */
    private final WindowManager f343a;

    /* renamed from: b */
    private final FlutterJNI.b f344b = new a();

    /* loaded from: classes.dex */
    public class a implements FlutterJNI.b {

        /* renamed from: io.flutter.view.e$a$a */
        /* loaded from: classes.dex */
        class ChoreographerFrameCallbackC0026a implements Choreographer.FrameCallback {

            /* renamed from: a */
            final /* synthetic */ long f346a;

            ChoreographerFrameCallbackC0026a(long j) {
                this.f346a = j;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                double refreshRate = e.this.f343a.getDefaultDisplay().getRefreshRate();
                Double.isNaN(refreshRate);
                FlutterJNI.nativeOnVsync(j, j + ((long) (1.0E9d / refreshRate)), this.f346a);
            }
        }

        a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j) {
            Choreographer.getInstance().postFrameCallback(new ChoreographerFrameCallbackC0026a(j));
        }
    }

    private e(WindowManager windowManager) {
        this.f343a = windowManager;
    }

    public static e b(WindowManager windowManager) {
        if (c == null) {
            c = new e(windowManager);
        }
        return c;
    }

    public void c() {
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.f344b);
        FlutterJNI.setRefreshRateFPS(this.f343a.getDefaultDisplay().getRefreshRate());
    }
}
