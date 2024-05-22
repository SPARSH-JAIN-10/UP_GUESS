package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Keep
@TargetApi(17)
/* loaded from: classes.dex */
public class SingleViewPresentation extends Presentation {
    private final io.flutter.plugin.platform.c accessibilityEventsDelegate;
    private FrameLayout container;
    private Object createParams;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private e state;
    private final io.flutter.plugin.platform.f viewFactory;
    private int viewId;

    /* loaded from: classes.dex */
    public static class a extends FrameLayout {

        /* renamed from: a */
        private final io.flutter.plugin.platform.c f283a;

        /* renamed from: b */
        private final View f284b;

        public a(Context context, io.flutter.plugin.platform.c cVar, View view) {
            super(context);
            this.f283a = cVar;
            this.f284b = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f283a.a(this.f284b, view, accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup {

        /* renamed from: a */
        private final Rect f285a;

        /* renamed from: b */
        private final Rect f286b;

        public b(Context context) {
            super(context);
            this.f285a = new Rect();
            this.f286b = new Rect();
        }

        private static int a(int i) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.f285a.set(i, i2, i3, i4);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f285a, layoutParams.x, layoutParams.y, this.f286b);
                Rect rect = this.f286b;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).measure(a(i), a(i2));
            }
            super.onMeasure(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ContextWrapper {

        /* renamed from: a */
        private final InputMethodManager f287a;

        c(Context context) {
            this(context, null);
        }

        private c(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f287a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new c(super.createDisplayContext(display), this.f287a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f287a : super.getSystemService(str);
        }
    }

    /* loaded from: classes.dex */
    private static class d extends ContextWrapper {

        /* renamed from: a */
        private final f f288a;

        /* renamed from: b */
        private WindowManager f289b;
        private final Context c;

        d(Context context, f fVar, Context context2) {
            super(context);
            this.f288a = fVar;
            this.c = context2;
        }

        private WindowManager a() {
            if (this.f289b == null) {
                this.f289b = this.f288a.b();
            }
            return this.f289b;
        }

        private boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i = 0; i < stackTrace.length && i < 11; i++) {
                if (stackTrace[i].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a */
        private io.flutter.plugin.platform.e f290a;

        /* renamed from: b */
        private f f291b;
        private b c;

        e() {
        }
    }

    /* loaded from: classes.dex */
    public static class f implements InvocationHandler {

        /* renamed from: a */
        private final WindowManager f292a;

        /* renamed from: b */
        b f293b;

        f(WindowManager windowManager, b bVar) {
            this.f292a = windowManager;
            this.f293b = bVar;
        }

        private void a(Object[] objArr) {
            b bVar = this.f293b;
            if (bVar == null) {
                b.a.b.f("PlatformViewsController", "Embedded view called addView while detached from presentation");
            } else {
                bVar.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        private void c(Object[] objArr) {
            b bVar = this.f293b;
            if (bVar == null) {
                b.a.b.f("PlatformViewsController", "Embedded view called removeView while detached from presentation");
            } else {
                bVar.removeView((View) objArr[0]);
            }
        }

        private void d(Object[] objArr) {
            if (this.f293b == null) {
                b.a.b.f("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.f293b.removeView(view);
        }

        private void e(Object[] objArr) {
            b bVar = this.f293b;
            if (bVar == null) {
                b.a.b.f("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
            } else {
                bVar.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        public WindowManager b() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case -1148522778:
                    if (name.equals("addView")) {
                        c = 0;
                        break;
                    }
                    break;
                case 542766184:
                    if (name.equals("removeViewImmediate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 931413976:
                    if (name.equals("updateViewLayout")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1098630473:
                    if (name.equals("removeView")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a(objArr);
                    return null;
                case 1:
                    d(objArr);
                    return null;
                case 2:
                    e(objArr);
                    return null;
                case 3:
                    c(objArr);
                    return null;
                default:
                    try {
                        return method.invoke(this.f292a, objArr);
                    } catch (InvocationTargetException e) {
                        throw e.getCause();
                    }
            }
        }
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.c cVar, e eVar, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = cVar;
        this.viewFactory = null;
        this.state = eVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.f fVar, io.flutter.plugin.platform.c cVar, int i, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        super(new c(context), display);
        this.startFocused = false;
        this.viewFactory = fVar;
        this.accessibilityEventsDelegate = cVar;
        this.viewId = i;
        this.createParams = obj;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        this.state = new e();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public e detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public io.flutter.plugin.platform.e getView() {
        if (this.state.f290a == null) {
            return null;
        }
        return this.state.f290a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.c == null) {
            this.state.c = new b(getContext());
        }
        if (this.state.f291b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            e eVar = this.state;
            eVar.f291b = new f(windowManager, eVar.c);
        }
        this.container = new FrameLayout(getContext());
        d dVar = new d(getContext(), this.state.f291b, this.outerContext);
        if (this.state.f290a == null) {
            this.state.f290a = this.viewFactory.a(dVar, this.viewId, this.createParams);
        }
        View f2 = this.state.f290a.f();
        this.container.addView(f2);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, f2);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.c);
        f2.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            f2.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}
