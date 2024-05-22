package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    Object f30b;

    /* renamed from: a */
    public int f29a = -1;
    public byte[] c = null;
    public Parcelable d = null;
    public int e = 0;
    public int f = 0;
    public ColorStateList g = null;
    PorterDuff.Mode h = j;
    public String i = null;

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    private static String d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    private static String g(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public int a() {
        int i = this.f29a;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f30b);
        }
        if (i == 2) {
            return this.e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String c() {
        int i = this.f29a;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return d((Icon) this.f30b);
        }
        if (i == 2) {
            return ((String) this.f30b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public void e() {
        Parcelable parcelable;
        this.h = PorterDuff.Mode.valueOf(this.i);
        int i = this.f29a;
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f30b = this.c;
                        return;
                    } else if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                    }
                }
                this.f30b = new String(this.c, Charset.forName("UTF-16"));
                return;
            }
            parcelable = this.d;
            if (parcelable == null) {
                byte[] bArr = this.c;
                this.f30b = bArr;
                this.f29a = 3;
                this.e = 0;
                this.f = bArr.length;
                return;
            }
        } else {
            parcelable = this.d;
            if (parcelable == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        this.f30b = parcelable;
    }

    public void f(boolean z) {
        this.i = this.h.name();
        int i = this.f29a;
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    this.c = ((String) this.f30b).getBytes(Charset.forName("UTF-16"));
                    return;
                }
                if (i == 3) {
                    this.c = (byte[]) this.f30b;
                    return;
                } else if (i == 4) {
                    this.c = this.f30b.toString().getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (z) {
                Bitmap bitmap = (Bitmap) this.f30b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.c = byteArrayOutputStream.toByteArray();
                return;
            }
        } else if (z) {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        this.d = (Parcelable) this.f30b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if (r1 != 5) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f29a
            r1 = -1
            if (r0 != r1) goto Lc
            java.lang.Object r0 = r4.f30b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        Lc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f29a
            java.lang.String r1 = g(r1)
            r0.append(r1)
            int r1 = r4.f29a
            r2 = 1
            if (r1 == r2) goto L77
            r3 = 2
            if (r1 == r3) goto L4f
            r2 = 3
            if (r1 == r2) goto L39
            r2 = 4
            if (r1 == r2) goto L2e
            r2 = 5
            if (r1 == r2) goto L77
            goto L97
        L2e:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f30b
            r0.append(r1)
            goto L97
        L39:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.e
            r0.append(r1)
            int r1 = r4.f
            if (r1 == 0) goto L97
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f
            goto L94
        L4f:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.c()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r2 = 0
            int r3 = r4.a()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L97
        L77:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f30b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f30b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L94:
            r0.append(r1)
        L97:
            android.content.res.ColorStateList r1 = r4.g
            if (r1 == 0) goto La5
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.g
            r0.append(r1)
        La5:
            android.graphics.PorterDuff$Mode r1 = r4.h
            android.graphics.PorterDuff$Mode r2 = androidx.core.graphics.drawable.IconCompat.j
            if (r1 == r2) goto Lb5
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.h
            r0.append(r1)
        Lb5:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
