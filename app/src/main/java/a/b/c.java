package a.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class c<K, V> {

    /* renamed from: a */
    c<K, V>.b f10a;

    /* renamed from: b */
    c<K, V>.C0002c f11b;
    c<K, V>.e c;

    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f12a;

        /* renamed from: b */
        int f13b;
        int c;
        boolean d = false;

        a(int i) {
            this.f12a = i;
            this.f13b = c.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.f13b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) c.this.b(this.c, this.f12a);
            this.c++;
            this.d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            int i = this.c - 1;
            this.c = i;
            this.f13b--;
            this.d = false;
            c.this.h(i);
        }
    }

    /* loaded from: classes.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d = c.this.d();
            for (Map.Entry<K, V> entry : collection) {
                c.this.g(entry.getKey(), entry.getValue());
            }
            return d != c.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            c.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e = c.this.e(entry.getKey());
            if (e < 0) {
                return false;
            }
            return a.b.b.b(c.this.b(e, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return c.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int d = c.this.d() - 1; d >= 0; d--) {
                Object b2 = c.this.b(d, 0);
                Object b3 = c.this.b(d, 1);
                i += (b2 == null ? 0 : b2.hashCode()) ^ (b3 == null ? 0 : b3.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return c.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a.b.c$c */
    /* loaded from: classes.dex */
    public final class C0002c implements Set<K> {
        C0002c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            c.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return c.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return c.j(c.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return c.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int d = c.this.d() - 1; d >= 0; d--) {
                Object b2 = c.this.b(d, 0);
                i += b2 == null ? 0 : b2.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e = c.this.e(obj);
            if (e < 0) {
                return false;
            }
            c.this.h(e);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return c.o(c.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return c.p(c.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return c.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return c.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c.this.r(tArr, 0);
        }
    }

    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f16a;
        boolean c = false;

        /* renamed from: b */
        int f17b = -1;

        d() {
            this.f16a = c.this.d() - 1;
        }

        public Map.Entry<K, V> a() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f17b++;
            this.c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a.b.b.b(entry.getKey(), c.this.b(this.f17b, 0)) && a.b.b.b(entry.getValue(), c.this.b(this.f17b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.c) {
                return (K) c.this.b(this.f17b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.c) {
                return (V) c.this.b(this.f17b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17b < this.f16a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b2 = c.this.b(this.f17b, 0);
            Object b3 = c.this.b(this.f17b, 1);
            return (b2 == null ? 0 : b2.hashCode()) ^ (b3 != null ? b3.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
                throw new IllegalStateException();
            }
            c.this.h(this.f17b);
            this.f17b--;
            this.f16a--;
            this.c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.c) {
                return (V) c.this.i(this.f17b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            c.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return c.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f = c.this.f(obj);
            if (f < 0) {
                return false;
            }
            c.this.h(f);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d = c.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(c.this.b(i, 1))) {
                    c.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d = c.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(c.this.b(i, 1))) {
                    c.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return c.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return c.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i, int i2);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k, V v);

    protected abstract void h(int i);

    protected abstract V i(int i, V v);

    public Set<Map.Entry<K, V>> l() {
        if (this.f10a == null) {
            this.f10a = new b();
        }
        return this.f10a;
    }

    public Set<K> m() {
        if (this.f11b == null) {
            this.f11b = new C0002c();
        }
        return this.f11b;
    }

    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }

    public Object[] q(int i) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
        }
        for (int i2 = 0; i2 < d2; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
