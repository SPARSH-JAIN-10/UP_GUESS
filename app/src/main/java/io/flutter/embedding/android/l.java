package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class l {
    private static l c;

    /* renamed from: a */
    private final LongSparseArray<MotionEvent> f137a = new LongSparseArray<>();

    /* renamed from: b */
    private final PriorityQueue<Long> f138b = new PriorityQueue<>();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: b */
        private static final AtomicLong f139b = new AtomicLong(0);

        /* renamed from: a */
        private final long f140a;

        private a(long j) {
            this.f140a = j;
        }

        public static a b() {
            return c(f139b.incrementAndGet());
        }

        public static a c(long j) {
            return new a(j);
        }

        public long d() {
            return this.f140a;
        }
    }

    private l() {
    }

    public static l a() {
        if (c == null) {
            c = new l();
        }
        return c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f138b.isEmpty() && this.f138b.peek().longValue() < aVar.f140a) {
            this.f137a.remove(this.f138b.poll().longValue());
        }
        if (!this.f138b.isEmpty() && this.f138b.peek().longValue() == aVar.f140a) {
            this.f138b.poll();
        }
        MotionEvent motionEvent = this.f137a.get(aVar.f140a);
        this.f137a.remove(aVar.f140a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a b2 = a.b();
        this.f137a.put(b2.f140a, MotionEvent.obtain(motionEvent));
        this.f138b.add(Long.valueOf(b2.f140a));
        return b2;
    }
}
