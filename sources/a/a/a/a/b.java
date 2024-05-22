package a.a.a.a;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    c<K, V> f0a;

    /* renamed from: b */
    private c<K, V> f1b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.a.a.a.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // a.a.a.a.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* renamed from: a.a.a.a.b$b */
    /* loaded from: classes.dex */
    public static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.a.a.a.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }

        @Override // a.a.a.a.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        final K f2a;

        /* renamed from: b */
        final V f3b;
        c<K, V> c;
        c<K, V> d;

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f2a.equals(cVar.f2a) && this.f3b.equals(cVar.f3b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2a.hashCode() ^ this.f3b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2a + "=" + this.f3b;
        }
    }

    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a */
        private c<K, V> f4a;

        /* renamed from: b */
        private boolean f5b = true;

        d() {
        }

        @Override // a.a.a.a.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f4a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.d;
                this.f4a = cVar3;
                this.f5b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f5b) {
                this.f5b = false;
                cVar = b.this.f0a;
            } else {
                c<K, V> cVar2 = this.f4a;
                cVar = cVar2 != null ? cVar2.c : null;
            }
            this.f4a = cVar;
            return this.f4a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5b) {
                return b.this.f0a != null;
            }
            c<K, V> cVar = this.f4a;
            return (cVar == null || cVar.c == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a */
        c<K, V> f6a;

        /* renamed from: b */
        c<K, V> f7b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f6a = cVar2;
            this.f7b = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f7b;
            c<K, V> cVar2 = this.f6a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // a.a.a.a.b.f
        public void a(c<K, V> cVar) {
            if (this.f6a == cVar && cVar == this.f7b) {
                this.f7b = null;
                this.f6a = null;
            }
            c<K, V> cVar2 = this.f6a;
            if (cVar2 == cVar) {
                this.f6a = b(cVar2);
            }
            if (this.f7b == cVar) {
                this.f7b = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f7b;
            this.f7b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7b != null;
        }
    }

    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0000b c0000b = new C0000b(this.f1b, this.f0a);
        this.c.put(c0000b, Boolean.FALSE);
        return c0000b;
    }

    public Map.Entry<K, V> b() {
        return this.f0a;
    }

    protected c<K, V> c(K k) {
        c<K, V> cVar = this.f0a;
        while (cVar != null && !cVar.f2a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.f1b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public V f(K k) {
        c<K, V> c2 = c(k);
        if (c2 == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            Iterator<f<K, V>> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(c2);
            }
        }
        c<K, V> cVar = c2.d;
        c<K, V> cVar2 = c2.c;
        if (cVar != null) {
            cVar.c = cVar2;
        } else {
            this.f0a = cVar2;
        }
        c<K, V> cVar3 = c2.c;
        if (cVar3 != null) {
            cVar3.d = cVar;
        } else {
            this.f1b = cVar;
        }
        c2.c = null;
        c2.d = null;
        return c2.f3b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f0a, this.f1b);
        this.c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
