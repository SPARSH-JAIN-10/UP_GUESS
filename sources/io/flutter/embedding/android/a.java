package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import io.flutter.embedding.engine.i.d;
import java.util.ArrayDeque;
import java.util.Deque;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private final io.flutter.embedding.engine.i.d f101a;

    /* renamed from: b */
    private int f102b;
    private C0010a c;

    /* renamed from: io.flutter.embedding.android.a$a */
    /* loaded from: classes.dex */
    public static class C0010a implements d.a {

        /* renamed from: a */
        final Deque<KeyEvent> f103a = new ArrayDeque();

        /* renamed from: b */
        private final View f104b;
        private final io.flutter.plugin.editing.d c;

        public C0010a(View view, io.flutter.plugin.editing.d dVar) {
            this.f104b = view;
            this.c = dVar;
        }

        public KeyEvent f(KeyEvent keyEvent) {
            for (KeyEvent keyEvent2 : this.f103a) {
                if (keyEvent2 == keyEvent) {
                    return keyEvent2;
                }
            }
            return null;
        }

        private void g(KeyEvent keyEvent) {
            if (this.c.o().isAcceptingText() && this.c.p() != null && this.c.p().sendKeyEvent(keyEvent)) {
                h(keyEvent);
                return;
            }
            View view = this.f104b;
            if (view != null) {
                view.getRootView().dispatchKeyEvent(keyEvent);
            }
        }

        public void h(KeyEvent keyEvent) {
            this.f103a.remove(keyEvent);
        }

        @Override // io.flutter.embedding.engine.i.d.a
        public void a(KeyEvent keyEvent) {
            g(f(keyEvent));
        }

        @Override // io.flutter.embedding.engine.i.d.a
        public void b(KeyEvent keyEvent) {
            h(keyEvent);
        }

        public void e(KeyEvent keyEvent) {
            this.f103a.addLast(keyEvent);
            if (this.f103a.size() > 1000) {
                b.a.b.b("AndroidKeyProcessor", "There are " + this.f103a.size() + " keyboard events that have not yet received a response. Are responses being sent?");
            }
        }
    }

    public a(View view, io.flutter.embedding.engine.i.d dVar, io.flutter.plugin.editing.d dVar2) {
        this.f101a = dVar;
        dVar2.A(this);
        C0010a c0010a = new C0010a(view, dVar2);
        this.c = c0010a;
        dVar.g(c0010a);
    }

    private Character a(int i) {
        if (i == 0) {
            return null;
        }
        char c = (char) i;
        if ((Integer.MIN_VALUE & i) != 0) {
            int i2 = i & Integer.MAX_VALUE;
            int i3 = this.f102b;
            if (i3 != 0) {
                i2 = KeyCharacterMap.getDeadChar(i3, i2);
            }
            this.f102b = i2;
        } else {
            int i4 = this.f102b;
            if (i4 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                if (deadChar > 0) {
                    c = (char) deadChar;
                }
                this.f102b = 0;
            }
        }
        return Character.valueOf(c);
    }

    public void b() {
        this.f101a.g(null);
    }

    public boolean c(KeyEvent keyEvent) {
        return this.c.f(keyEvent) != null;
    }

    public boolean d(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action != 0 && action != 1) {
            return false;
        }
        if (c(keyEvent)) {
            this.c.h(keyEvent);
            return false;
        }
        d.b bVar = new d.b(keyEvent, a(keyEvent.getUnicodeChar()));
        this.c.e(keyEvent);
        io.flutter.embedding.engine.i.d dVar = this.f101a;
        if (action == 0) {
            dVar.c(bVar);
        } else {
            dVar.d(bVar);
        }
        return true;
    }
}
