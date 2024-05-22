package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b extends a {
    private final SparseIntArray d;
    private final Parcel e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a.b.a(), new a.b.a(), new a.b.a());
    }

    private b(Parcel parcel, int i, int i2, String str, a.b.a<String, Method> aVar, a.b.a<String, Method> aVar2, a.b.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = parcel;
        this.f = i;
        this.g = i2;
        this.j = i;
        this.h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.e.writeInt(-1);
        } else {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i) {
        this.e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int i2 = this.d.get(i);
            int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i2);
            this.e.writeInt(dataPosition - i2);
            this.e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        return new b(parcel, dataPosition, i, this.h + "  ", this.f56a, this.f57b, this.c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i) {
        while (this.j < this.g) {
            int i2 = this.k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int readInt = this.e.readInt();
            this.k = this.e.readInt();
            this.j += readInt;
        }
        return this.k == i;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i) {
        a();
        this.i = i;
        this.d.put(i, this.e.dataPosition());
        E(0);
        E(i);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z) {
        this.e.writeInt(z ? 1 : 0);
    }
}
