package a.a.a.a;

import a.a.a.a.b;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> e = new HashMap<>();

    @Override // a.a.a.a.b
    protected b.c<K, V> c(K k) {
        return this.e.get(k);
    }

    public boolean contains(K k) {
        return this.e.containsKey(k);
    }

    @Override // a.a.a.a.b
    public V f(K k) {
        V v = (V) super.f(k);
        this.e.remove(k);
        return v;
    }
}
