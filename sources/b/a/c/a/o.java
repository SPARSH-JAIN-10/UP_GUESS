package b.a.c.a;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class o implements g<Object> {

    /* renamed from: a */
    public static final o f84a = new o();

    /* renamed from: b */
    private static final boolean f85b;
    private static final Charset c;

    /* loaded from: classes.dex */
    public static final class a extends ByteArrayOutputStream {
        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        f85b = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        c = Charset.forName("UTF8");
    }

    protected static final void c(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position() % i;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i) - position);
        }
    }

    protected static final byte[] d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[e(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    protected static final int e(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        int i = byteBuffer.get() & 255;
        return i < 254 ? i : i == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
    }

    protected static final void h(ByteArrayOutputStream byteArrayOutputStream, int i) {
        int size = byteArrayOutputStream.size() % i;
        if (size != 0) {
            for (int i2 = 0; i2 < i - size; i2++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    protected static final void i(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        n(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    protected static final void j(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (f85b) {
            byteArrayOutputStream.write(i);
            i >>>= 8;
        } else {
            byteArrayOutputStream.write(i >>> 8);
        }
        byteArrayOutputStream.write(i);
    }

    protected static final void k(ByteArrayOutputStream byteArrayOutputStream, double d) {
        m(byteArrayOutputStream, Double.doubleToLongBits(d));
    }

    protected static final void l(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (f85b) {
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i >>> 8);
            byteArrayOutputStream.write(i >>> 16);
            i >>>= 24;
        } else {
            byteArrayOutputStream.write(i >>> 24);
            byteArrayOutputStream.write(i >>> 16);
            byteArrayOutputStream.write(i >>> 8);
        }
        byteArrayOutputStream.write(i);
    }

    protected static final void m(ByteArrayOutputStream byteArrayOutputStream, long j) {
        if (f85b) {
            byteArrayOutputStream.write((byte) j);
            byteArrayOutputStream.write((byte) (j >>> 8));
            byteArrayOutputStream.write((byte) (j >>> 16));
            byteArrayOutputStream.write((byte) (j >>> 24));
            byteArrayOutputStream.write((byte) (j >>> 32));
            byteArrayOutputStream.write((byte) (j >>> 40));
            byteArrayOutputStream.write((byte) (j >>> 48));
            j >>>= 56;
        } else {
            byteArrayOutputStream.write((byte) (j >>> 56));
            byteArrayOutputStream.write((byte) (j >>> 48));
            byteArrayOutputStream.write((byte) (j >>> 40));
            byteArrayOutputStream.write((byte) (j >>> 32));
            byteArrayOutputStream.write((byte) (j >>> 24));
            byteArrayOutputStream.write((byte) (j >>> 16));
            byteArrayOutputStream.write((byte) (j >>> 8));
        }
        byteArrayOutputStream.write((byte) j);
    }

    protected static final void n(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (i < 254) {
            byteArrayOutputStream.write(i);
        } else if (i <= 65535) {
            byteArrayOutputStream.write(254);
            j(byteArrayOutputStream, i);
        } else {
            byteArrayOutputStream.write(255);
            l(byteArrayOutputStream, i);
        }
    }

    @Override // b.a.c.a.g
    public Object a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f = f(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return f;
    }

    @Override // b.a.c.a.g
    public ByteBuffer b(Object obj) {
        if (obj == null) {
            return null;
        }
        a aVar = new a();
        o(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    public final Object f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return g(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    protected Object g(byte b2, ByteBuffer byteBuffer) {
        int e;
        long[] jArr;
        int i = 0;
        switch (b2) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                return new BigInteger(new String(d(byteBuffer), c), 16);
            case 6:
                c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                return new String(d(byteBuffer), c);
            case 8:
                return d(byteBuffer);
            case 9:
                int e2 = e(byteBuffer);
                int[] iArr = new int[e2];
                c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr);
                byteBuffer.position(byteBuffer.position() + (e2 * 4));
                return iArr;
            case 10:
                e = e(byteBuffer);
                long[] jArr2 = new long[e];
                c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr2);
                jArr = jArr2;
                break;
            case 11:
                e = e(byteBuffer);
                double[] dArr = new double[e];
                c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr);
                jArr = dArr;
                break;
            case 12:
                int e3 = e(byteBuffer);
                ArrayList arrayList = new ArrayList(e3);
                while (i < e3) {
                    arrayList.add(f(byteBuffer));
                    i++;
                }
                return arrayList;
            case 13:
                int e4 = e(byteBuffer);
                HashMap hashMap = new HashMap();
                while (i < e4) {
                    hashMap.put(f(byteBuffer), f(byteBuffer));
                    i++;
                }
                return hashMap;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
        byteBuffer.position(byteBuffer.position() + (e * 8));
        return jArr;
    }

    public void o(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i = 0;
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                l(byteArrayOutputStream, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                m(byteArrayOutputStream, ((Long) obj).longValue());
                return;
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                h(byteArrayOutputStream, 8);
                k(byteArrayOutputStream, ((Number) obj).doubleValue());
                return;
            } else {
                if (!(obj instanceof BigInteger)) {
                    throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                }
                byteArrayOutputStream.write(5);
                i(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(c));
                return;
            }
        }
        if (obj instanceof String) {
            byteArrayOutputStream.write(7);
            i(byteArrayOutputStream, ((String) obj).getBytes(c));
            return;
        }
        if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            i(byteArrayOutputStream, (byte[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            n(byteArrayOutputStream, iArr.length);
            h(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i < length) {
                l(byteArrayOutputStream, iArr[i]);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            n(byteArrayOutputStream, jArr.length);
            h(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i < length2) {
                m(byteArrayOutputStream, jArr[i]);
                i++;
            }
            return;
        }
        if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            n(byteArrayOutputStream, dArr.length);
            h(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i < length3) {
                k(byteArrayOutputStream, dArr[i]);
                i++;
            }
            return;
        }
        if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List list = (List) obj;
            n(byteArrayOutputStream, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                o(byteArrayOutputStream, it.next());
            }
            return;
        }
        if (!(obj instanceof Map)) {
            throw new IllegalArgumentException("Unsupported value: " + obj);
        }
        byteArrayOutputStream.write(13);
        Map map = (Map) obj;
        n(byteArrayOutputStream, map.size());
        for (Map.Entry entry : map.entrySet()) {
            o(byteArrayOutputStream, entry.getKey());
            o(byteArrayOutputStream, entry.getValue());
        }
    }
}
