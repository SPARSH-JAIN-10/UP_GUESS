package a.b;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    static final int[] f8a = new int[0];

    /* renamed from: b */
    static final Object[] f9b = new Object[0];

    public static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return i4 ^ (-1);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
