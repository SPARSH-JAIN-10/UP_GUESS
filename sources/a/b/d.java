package a.b;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class d<K, V> {
    static Object[] d;
    static int e;
    static Object[] f;
    static int g;

    /* renamed from: a */
    int[] f19a = b.f8a;

    /* renamed from: b */
    Object[] f20b = b.f9b;
    int c = 0;

    private void a(int i) {
        if (i == 8) {
            synchronized (d.class) {
                Object[] objArr = f;
                if (objArr != null) {
                    this.f20b = objArr;
                    f = (Object[]) objArr[0];
                    this.f19a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (d.class) {
                Object[] objArr2 = d;
                if (objArr2 != null) {
                    this.f20b = objArr2;
                    d = (Object[]) objArr2[0];
                    this.f19a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    e--;
                    return;
                }
            }
        }
        this.f19a = new int[i];
        this.f20b = new Object[i << 1];
    }

    private static int b(int[] iArr, int i, int i2) {
        try {
            return b.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (g < 10) {
                    objArr[0] = f;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f = objArr;
                    g++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (d.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        }
    }

    public void c(int i) {
        int i2 = this.c;
        int[] iArr = this.f19a;
        if (iArr.length < i) {
            Object[] objArr = this.f20b;
            a(i);
            if (this.c > 0) {
                System.arraycopy(iArr, 0, this.f19a, 0, i2);
                System.arraycopy(objArr, 0, this.f20b, 0, i2 << 1);
            }
            d(iArr, objArr, i2);
        }
        if (this.c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.c;
        if (i > 0) {
            int[] iArr = this.f19a;
            Object[] objArr = this.f20b;
            this.f19a = b.f8a;
            this.f20b = b.f9b;
            this.c = 0;
            d(iArr, objArr, i);
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.f19a, i2, i);
        if (b2 < 0 || obj.equals(this.f20b[b2 << 1])) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.f19a[i3] == i) {
            if (obj.equals(this.f20b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = b2 - 1; i4 >= 0 && this.f19a[i4] == i; i4--) {
            if (obj.equals(this.f20b[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (size() != dVar.size()) {
                return false;
            }
            for (int i = 0; i < this.c; i++) {
                try {
                    K i2 = i(i);
                    V l = l(i);
                    Object obj2 = dVar.get(i2);
                    if (l == null) {
                        if (obj2 != null || !dVar.containsKey(i2)) {
                            return false;
                        }
                    } else if (!l.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.c; i3++) {
                try {
                    K i4 = i(i3);
                    V l2 = l(i3);
                    Object obj3 = map.get(i4);
                    if (l2 == null) {
                        if (obj3 != null || !map.containsKey(i4)) {
                            return false;
                        }
                    } else if (!l2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int b2 = b(this.f19a, i, 0);
        if (b2 < 0 || this.f20b[b2 << 1] == null) {
            return b2;
        }
        int i2 = b2 + 1;
        while (i2 < i && this.f19a[i2] == 0) {
            if (this.f20b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = b2 - 1; i3 >= 0 && this.f19a[i3] == 0; i3--) {
            if (this.f20b[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int f2 = f(obj);
        return f2 >= 0 ? (V) this.f20b[(f2 << 1) + 1] : v;
    }

    public int h(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.f20b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f19a;
        Object[] objArr = this.f20b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public K i(int i) {
        return (K) this.f20b[i << 1];
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public V j(int i) {
        Object[] objArr = this.f20b;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.c;
        int i4 = 0;
        if (i3 <= 1) {
            d(this.f19a, objArr, i3);
            this.f19a = b.f8a;
            this.f20b = b.f9b;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f19a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.f20b;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.f20b;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f19a, 0, i);
                    System.arraycopy(objArr, 0, this.f20b, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.f19a, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.f20b, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.c) {
            throw new ConcurrentModificationException();
        }
        this.c = i4;
        return v;
    }

    public V k(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f20b;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public V l(int i) {
        return (V) this.f20b[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int e2;
        int i2 = this.c;
        if (k == null) {
            e2 = g();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            e2 = e(k, hashCode);
        }
        if (e2 >= 0) {
            int i3 = (e2 << 1) + 1;
            Object[] objArr = this.f20b;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = e2 ^ (-1);
        int[] iArr = this.f19a;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.f20b;
            a(i5);
            if (i2 != this.c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f19a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f20b, 0, objArr2.length);
            }
            d(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f19a;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f20b;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.c - i4) << 1);
        }
        int i7 = this.c;
        if (i2 == i7) {
            int[] iArr4 = this.f19a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f20b;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.c = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int f2 = f(obj);
        if (f2 >= 0) {
            return j(f2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f2 = f(obj);
        if (f2 < 0) {
            return false;
        }
        V l = l(f2);
        if (obj2 != l && (obj2 == null || !obj2.equals(l))) {
            return false;
        }
        j(f2);
        return true;
    }

    public V replace(K k, V v) {
        int f2 = f(k);
        if (f2 >= 0) {
            return k(f2, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int f2 = f(k);
        if (f2 < 0) {
            return false;
        }
        V l = l(f2);
        if (l != v && (v == null || !v.equals(l))) {
            return false;
        }
        k(f2, v2);
        return true;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K i2 = i(i);
            if (i2 != this) {
                sb.append(i2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l = l(i);
            if (l != this) {
                sb.append(l);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
