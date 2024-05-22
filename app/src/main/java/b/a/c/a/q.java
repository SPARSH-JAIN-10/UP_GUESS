package b.a.c.a;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class q implements g<String> {

    /* renamed from: a */
    private static final Charset f88a = Charset.forName("UTF8");

    /* renamed from: b */
    public static final q f89b = new q();

    private q() {
    }

    @Override // b.a.c.a.g
    /* renamed from: c */
    public String a(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i = 0;
        }
        return new String(bArr, i, remaining, f88a);
    }

    @Override // b.a.c.a.g
    /* renamed from: d */
    public ByteBuffer b(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f88a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}
