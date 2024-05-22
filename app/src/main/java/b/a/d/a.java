package b.a.d;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class a {
    public static String a(Context context) {
        return (Build.VERSION.SDK_INT >= 21 ? context.getCodeCacheDir() : context.getCacheDir()).getPath();
    }

    public static String b(Context context) {
        return context.getDir("flutter", 0).getPath();
    }

    public static String c(Context context) {
        return context.getFilesDir().getPath();
    }
}
