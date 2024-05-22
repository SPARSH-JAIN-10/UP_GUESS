package a.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V> extends d<K, V> implements Map<K, V> {
    c<K, V> h;

    /* renamed from: a.b.a$a */
    /* loaded from: classes.dex */
    public class C0001a extends c<K, V> {
        C0001a() {
        }

        @Override // a.b.c
        protected void a() {
            a.this.clear();
        }

        @Override // a.b.c
        protected Object b(int i, int i2) {
            return a.this.f20b[(i << 1) + i2];
        }

        @Override // a.b.c
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // a.b.c
        protected int d() {
            return a.this.c;
        }

        @Override // a.b.c
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // a.b.c
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // a.b.c
        protected void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // a.b.c
        protected void h(int i) {
            a.this.j(i);
        }

        @Override // a.b.c
        protected V i(int i, V v) {
            return a.this.k(i, v);
        }
    }

    private c<K, V> m() {
        if (this.h == null) {
            this.h = new C0001a();
        }
        return this.h;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
