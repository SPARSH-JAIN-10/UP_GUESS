package b.a.c.a;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class d implements g<Object> {

    /* renamed from: a */
    public static final d f72a = new d();

    private d() {
    }

    @Override // b.a.c.a.g
    public Object a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(q.f89b.a(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // b.a.c.a.g
    public ByteBuffer b(Object obj) {
        q qVar;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object a2 = f.a(obj);
        if (a2 instanceof String) {
            qVar = q.f89b;
            obj2 = JSONObject.quote((String) a2);
        } else {
            qVar = q.f89b;
            obj2 = a2.toString();
        }
        return qVar.b(obj2);
    }
}
