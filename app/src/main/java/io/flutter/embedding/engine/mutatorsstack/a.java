package io.flutter.embedding.engine.mutatorsstack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.android.b;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: a */
    private FlutterMutatorsStack f257a;

    /* renamed from: b */
    private float f258b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final b g;

    public a(Context context, float f, b bVar) {
        super(context, null);
        this.f258b = f;
        this.g = bVar;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f257a.getFinalMatrix());
        float f = this.f258b;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate(-this.c, -this.d);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i, int i2, int i3, int i4) {
        this.f257a = flutterMutatorsStack;
        this.c = i;
        this.d = i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f257a.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.c, -this.d);
            canvas.clipPath(path);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        float f;
        if (this.g == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i2 = this.c;
            this.e = i2;
            i = this.d;
            this.f = i;
            f = i2;
        } else {
            if (action == 2) {
                matrix.postTranslate(this.e, this.f);
                this.e = this.c;
                this.f = this.d;
                return this.g.f(motionEvent, matrix);
            }
            f = this.c;
            i = this.d;
        }
        matrix.postTranslate(f, i);
        return this.g.f(motionEvent, matrix);
    }
}
