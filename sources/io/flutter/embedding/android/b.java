package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b {
    private static final Matrix d = new Matrix();

    /* renamed from: a */
    private final io.flutter.embedding.engine.renderer.a f105a;

    /* renamed from: b */
    private final l f106b = l.a();
    private final boolean c;

    public b(io.flutter.embedding.engine.renderer.a aVar, boolean z) {
        this.f105a = aVar;
        this.c = z;
    }

    private void a(MotionEvent motionEvent, int i, int i2, int i3, Matrix matrix, ByteBuffer byteBuffer) {
        long j;
        double d2;
        double d3;
        double d4;
        InputDevice.MotionRange motionRange;
        if (i2 == -1) {
            return;
        }
        long d5 = this.c ? this.f106b.c(motionEvent).d() : 0L;
        int c = c(motionEvent.getToolType(i));
        int i4 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(d5);
        byteBuffer.putLong(eventTime);
        byteBuffer.putLong(i2);
        byteBuffer.putLong(c);
        byteBuffer.putLong(i4);
        byteBuffer.putLong(motionEvent.getPointerId(i));
        byteBuffer.putLong(0L);
        matrix.mapPoints(new float[]{motionEvent.getX(i), motionEvent.getY(i)});
        byteBuffer.putDouble(r9[0]);
        byteBuffer.putDouble(r9[1]);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        if (c == 1) {
            j = motionEvent.getButtonState() & 31;
            if (j == 0 && motionEvent.getSource() == 8194 && (i2 == 4 || i2 == 5)) {
                j = 1;
            }
        } else {
            j = c == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        byteBuffer.putLong(j);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i));
        double d6 = 1.0d;
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d2 = 0.0d;
        } else {
            double min = motionRange.getMin();
            d6 = motionRange.getMax();
            d2 = min;
        }
        byteBuffer.putDouble(d2);
        byteBuffer.putDouble(d6);
        if (c == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i));
            d3 = 0.0d;
        } else {
            d3 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(motionEvent.getSize(i));
        byteBuffer.putDouble(motionEvent.getToolMajor(i));
        byteBuffer.putDouble(motionEvent.getToolMinor(i));
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i));
        if (c == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i));
        } else {
            byteBuffer.putDouble(d3);
        }
        byteBuffer.putLong(i3);
        if (i4 == 1) {
            byteBuffer.putDouble(-motionEvent.getAxisValue(10));
            d4 = -motionEvent.getAxisValue(9);
        } else {
            d4 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d4);
    }

    private int b(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 6;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return 6;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 7) {
            return 3;
        }
        if (i == 3) {
            return 0;
        }
        return i == 8 ? 3 : -1;
    }

    private int c(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i != 3) {
            return i != 4 ? 4 : 3;
        }
        return 1;
    }

    public boolean d(MotionEvent motionEvent) {
        boolean z = Build.VERSION.SDK_INT >= 18 && motionEvent.isFromSource(2);
        boolean z2 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!z || !z2) {
            return false;
        }
        int b2 = b(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 29 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        a(motionEvent, motionEvent.getActionIndex(), b2, 0, d, allocateDirect);
        if (allocateDirect.position() % 232 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.f105a.g(allocateDirect, allocateDirect.position());
        return true;
    }

    public boolean e(MotionEvent motionEvent) {
        return f(motionEvent, d);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r0 * 29
            int r1 = r1 * 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            int r2 = r13.getActionMasked()
            int r3 = r13.getActionMasked()
            int r9 = r12.b(r3)
            r3 = 0
            r10 = 1
            if (r2 == 0) goto L27
            r4 = 5
            if (r2 != r4) goto L25
            goto L27
        L25:
            r4 = 0
            goto L28
        L27:
            r4 = 1
        L28:
            if (r4 != 0) goto L31
            if (r2 == r10) goto L2f
            r5 = 6
            if (r2 != r5) goto L31
        L2f:
            r2 = 1
            goto L32
        L31:
            r2 = 0
        L32:
            if (r4 == 0) goto L42
        L34:
            int r4 = r13.getActionIndex()
            r6 = 0
            r2 = r12
            r3 = r13
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            goto L6f
        L42:
            r11 = 0
            if (r2 == 0) goto L60
        L45:
            if (r11 >= r0) goto L34
            int r2 = r13.getActionIndex()
            if (r11 == r2) goto L5d
            int r2 = r13.getToolType(r11)
            if (r2 != r10) goto L5d
            r5 = 5
            r6 = 1
            r2 = r12
            r3 = r13
            r4 = r11
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
        L5d:
            int r11 = r11 + 1
            goto L45
        L60:
            if (r11 >= r0) goto L6f
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r11
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            int r11 = r11 + 1
            goto L60
        L6f:
            int r13 = r1.position()
            int r13 = r13 % 232
            if (r13 != 0) goto L81
            io.flutter.embedding.engine.renderer.a r13 = r12.f105a
            int r14 = r1.position()
            r13.g(r1, r14)
            return r10
        L81:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r14 = "Packet position is not on field boundary"
            r13.<init>(r14)
            goto L8a
        L89:
            throw r13
        L8a:
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.b.f(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}
