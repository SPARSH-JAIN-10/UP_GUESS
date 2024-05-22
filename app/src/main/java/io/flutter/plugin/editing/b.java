package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.i.n;
import io.flutter.plugin.editing.c;

/* loaded from: classes.dex */
public class b extends BaseInputConnection implements c.b {

    /* renamed from: a */
    private final View f269a;

    /* renamed from: b */
    private final int f270b;
    private final n c;
    private final io.flutter.embedding.android.a d;
    private final c e;
    private final EditorInfo f;
    private ExtractedTextRequest g;
    private boolean h;
    private CursorAnchorInfo.Builder i;
    private ExtractedText j;
    private InputMethodManager k;
    private final Layout l;
    private a m;
    private int n;

    public b(View view, int i, n nVar, io.flutter.embedding.android.a aVar, c cVar, EditorInfo editorInfo) {
        this(view, i, nVar, aVar, cVar, editorInfo, new FlutterJNI());
    }

    public b(View view, int i, n nVar, io.flutter.embedding.android.a aVar, c cVar, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.h = false;
        this.j = new ExtractedText();
        this.n = 0;
        this.f269a = view;
        this.f270b = i;
        this.c = nVar;
        this.e = cVar;
        cVar.a(this);
        this.f = editorInfo;
        this.d = aVar;
        this.m = new a(flutterJNI);
        this.l = new DynamicLayout(cVar, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.k = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    private boolean b(int i) {
        if (i == 16908319) {
            setSelection(0, this.e.length());
            return true;
        }
        if (i == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.e);
            int selectionEnd = Selection.getSelectionEnd(this.e);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f269a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.e.subSequence(min, max)));
                this.e.delete(min, max);
                setSelection(min, min);
            }
            return true;
        }
        if (i == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.e);
            int selectionEnd2 = Selection.getSelectionEnd(this.e);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f269a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.e.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        }
        if (i != 16908322) {
            return false;
        }
        ClipData primaryClip = ((ClipboardManager) this.f269a.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip != null) {
            CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f269a.getContext());
            int max2 = Math.max(0, Selection.getSelectionStart(this.e));
            int max3 = Math.max(0, Selection.getSelectionEnd(this.e));
            int min2 = Math.min(max2, max3);
            int max4 = Math.max(max2, max3);
            if (min2 != max4) {
                this.e.delete(min2, max4);
            }
            this.e.insert(min2, coerceToText);
            int length = min2 + coerceToText.length();
            setSelection(length, length);
        }
        return true;
    }

    private CursorAnchorInfo c() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.i;
        if (builder == null) {
            this.i = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.i.setSelectionRange(this.e.g(), this.e.f());
        int e = this.e.e();
        int d = this.e.d();
        if (e < 0 || d <= e) {
            this.i.setComposingText(-1, "");
        } else {
            this.i.setComposingText(e, this.e.toString().subSequence(e, d));
        }
        return this.i.build();
    }

    private ExtractedText d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.j;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.e.g();
        this.j.selectionEnd = this.e.f();
        this.j.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.e.toString() : this.e;
        return this.j;
    }

    private boolean e(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.e);
        int selectionEnd = Selection.getSelectionEnd(this.e);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int max = z ? Math.max(this.m.b(this.e, selectionEnd), 0) : Math.min(this.m.a(this.e, selectionEnd), this.e.length());
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        if (z3) {
            setSelection(max, max);
        } else {
            setSelection(selectionStart, max);
        }
        return true;
    }

    private boolean f(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.e);
        int selectionEnd = Selection.getSelectionEnd(this.e);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        if (z3) {
            if (z) {
                Selection.moveUp(this.e, this.l);
            } else {
                Selection.moveDown(this.e, this.l);
            }
            int selectionStart2 = Selection.getSelectionStart(this.e);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(this.e, this.l);
            } else {
                Selection.extendDown(this.e, this.l);
            }
            setSelection(Selection.getSelectionStart(this.e), Selection.getSelectionEnd(this.e));
        }
        endBatchEdit();
        return true;
    }

    @Override // io.flutter.plugin.editing.c.b
    public void a(boolean z, boolean z2, boolean z3) {
        this.k.updateSelection(this.f269a, this.e.g(), this.e.f(), this.e.e(), this.e.d());
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        ExtractedTextRequest extractedTextRequest = this.g;
        if (extractedTextRequest != null) {
            this.k.updateExtractedText(this.f269a, extractedTextRequest.token, d(extractedTextRequest));
        }
        if (this.h) {
            this.k.updateCursorAnchorInfo(this.f269a, c());
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.e.b();
        this.n++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        return super.clearMetaKeyStates(i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.e.j(this);
        while (this.n > 0) {
            endBatchEdit();
            this.n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        if (this.e.g() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return super.deleteSurroundingTextInCodePoints(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.n--;
        this.e.c();
        return endBatchEdit;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.e;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = (i & 1) != 0;
        if (z == (this.g == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z ? "on" : "off");
            b.a.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.g = z ? extractedTextRequest : null;
        return d(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        beginBatchEdit();
        boolean b2 = b(i);
        endBatchEdit();
        return b2;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        if (i == 0) {
            this.c.m(this.f270b);
        } else if (i == 1) {
            this.c.e(this.f270b);
        } else if (i == 2) {
            this.c.d(this.f270b);
        } else if (i == 3) {
            this.c.j(this.f270b);
        } else if (i == 4) {
            this.c.k(this.f270b);
        } else if (i == 5) {
            this.c.f(this.f270b);
        } else if (i != 7) {
            this.c.c(this.f270b);
        } else {
            this.c.h(this.f270b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.c.g(this.f270b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i & 1) != 0) {
            this.k.updateCursorAnchorInfo(this.f269a, c());
        }
        boolean z = (i & 2) != 0;
        if (z != this.h) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z ? "on" : "off");
            b.a.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.h = z;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        io.flutter.embedding.android.a aVar = this.d;
        if (aVar != null && !aVar.c(keyEvent) && this.d.d(keyEvent)) {
            return true;
        }
        if (keyEvent.getAction() != 0) {
            if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 59 && keyEvent.getKeyCode() != 60)) {
                return false;
            }
            int selectionEnd = Selection.getSelectionEnd(this.e);
            setSelection(selectionEnd, selectionEnd);
            return true;
        }
        if (keyEvent.getKeyCode() == 21) {
            return e(true, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 22) {
            return e(false, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 19) {
            return f(true, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 20) {
            return f(false, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
            EditorInfo editorInfo = this.f;
            if ((131072 & editorInfo.inputType) == 0) {
                performEditorAction(editorInfo.imeOptions & 255);
                return true;
            }
        }
        int selectionStart = Selection.getSelectionStart(this.e);
        int selectionEnd2 = Selection.getSelectionEnd(this.e);
        int unicodeChar = keyEvent.getUnicodeChar();
        if (selectionStart < 0 || selectionEnd2 < 0 || unicodeChar == 0) {
            return false;
        }
        int min = Math.min(selectionStart, selectionEnd2);
        int max = Math.max(selectionStart, selectionEnd2);
        beginBatchEdit();
        if (min != max) {
            this.e.delete(min, max);
        }
        this.e.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
        int i = min + 1;
        setSelection(i, i);
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        return super.setComposingRegion(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        beginBatchEdit();
        boolean commitText = charSequence.length() == 0 ? super.commitText(charSequence, i) : super.setComposingText(charSequence, i);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        beginBatchEdit();
        boolean selection = super.setSelection(i, i2);
        endBatchEdit();
        return selection;
    }
}
