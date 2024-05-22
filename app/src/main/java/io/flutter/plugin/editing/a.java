package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private final FlutterJNI f268a;

    public a(FlutterJNI flutterJNI) {
        this.f268a = flutterJNI;
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = length - 1;
        if (i >= i2) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i);
        int charCount = Character.charCount(codePointAt);
        int i3 = i + charCount;
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i3) == 13) {
                charCount++;
            }
            return i + charCount;
        }
        if (g(codePointAt)) {
            if (i3 >= i2 || !g(Character.codePointAt(charSequence, i3))) {
                return i3;
            }
            int i5 = i;
            while (i5 > 0 && g(Character.codePointBefore(charSequence, i))) {
                i5 -= Character.charCount(Character.codePointBefore(charSequence, i));
                i4++;
            }
            if (i4 % 2 == 0) {
                charCount += 2;
            }
            return i + charCount;
        }
        if (f(codePointAt)) {
            charCount += Character.charCount(codePointAt);
        }
        if (codePointAt == 8419) {
            int codePointBefore = Character.codePointBefore(charSequence, i3);
            int charCount2 = i3 + Character.charCount(codePointBefore);
            if (charCount2 < length && i(codePointBefore)) {
                int codePointAt2 = Character.codePointAt(charSequence, charCount2);
                if (f(codePointAt2)) {
                    charCount += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                }
            } else if (f(codePointBefore)) {
                charCount += Character.charCount(codePointBefore);
            }
            return i + charCount;
        }
        if (c(codePointAt)) {
            boolean z = false;
            int i6 = 0;
            do {
                if (z) {
                    charCount += Character.charCount(codePointAt) + i6 + 1;
                    z = false;
                }
                if (d(codePointAt)) {
                    break;
                }
                if (i3 < length) {
                    codePointAt = Character.codePointAt(charSequence, i3);
                    i3 += Character.charCount(codePointAt);
                    if (codePointAt != 8419) {
                        if (!d(codePointAt) && !i(codePointAt)) {
                            if (codePointAt == 8205) {
                                codePointAt = Character.codePointAt(charSequence, i3);
                                i3 += Character.charCount(codePointAt);
                                if (i3 < length && i(codePointAt)) {
                                    codePointAt = Character.codePointAt(charSequence, i3);
                                    int charCount3 = Character.charCount(codePointAt);
                                    i3 += Character.charCount(codePointAt);
                                    i6 = charCount3;
                                    z = true;
                                    if (i3 < length || !z) {
                                        break;
                                        break;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            charCount += Character.charCount(codePointAt) + 0;
                            break;
                        }
                    } else {
                        int codePointBefore2 = Character.codePointBefore(charSequence, i3);
                        int charCount4 = i3 + Character.charCount(codePointBefore2);
                        if (charCount4 < length && i(codePointBefore2)) {
                            int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                            if (f(codePointAt3)) {
                                charCount += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                            }
                        } else if (f(codePointBefore2)) {
                            charCount += Character.charCount(codePointBefore2);
                        }
                        return i + charCount;
                    }
                }
                i6 = 0;
                if (i3 < length) {
                    break;
                }
            } while (c(codePointAt));
        }
        return i + charCount;
    }

    public int b(CharSequence charSequence, int i) {
        int codePointBefore;
        int charCount;
        int charCount2;
        int i2 = 0;
        int i3 = 1;
        if (i <= 1 || (charCount2 = i - (charCount = Character.charCount((codePointBefore = Character.codePointBefore(charSequence, i))))) == 0) {
            return 0;
        }
        if (codePointBefore == 10) {
            if (Character.codePointBefore(charSequence, charCount2) == 13) {
                charCount++;
            }
            return i - charCount;
        }
        if (g(codePointBefore)) {
            int codePointBefore2 = Character.codePointBefore(charSequence, charCount2);
            int charCount3 = charCount2 - Character.charCount(codePointBefore2);
            while (charCount3 > 0 && g(codePointBefore2)) {
                codePointBefore2 = Character.codePointBefore(charSequence, charCount3);
                charCount3 -= Character.charCount(codePointBefore2);
                i3++;
            }
            if (i3 % 2 == 0) {
                charCount += 2;
            }
            return i - charCount;
        }
        if (codePointBefore == 8419) {
            int codePointBefore3 = Character.codePointBefore(charSequence, charCount2);
            int charCount4 = charCount2 - Character.charCount(codePointBefore3);
            if (charCount4 > 0 && i(codePointBefore3)) {
                int codePointBefore4 = Character.codePointBefore(charSequence, charCount4);
                if (f(codePointBefore4)) {
                    charCount += Character.charCount(codePointBefore3) + Character.charCount(codePointBefore4);
                }
            } else if (f(codePointBefore3)) {
                charCount += Character.charCount(codePointBefore3);
            }
            return i - charCount;
        }
        if (codePointBefore == 917631) {
            while (true) {
                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                charCount2 -= Character.charCount(codePointBefore);
                if (charCount2 <= 0 || !h(codePointBefore)) {
                    break;
                }
                charCount += Character.charCount(codePointBefore);
            }
            if (!c(codePointBefore)) {
                return i - 2;
            }
            charCount += Character.charCount(codePointBefore);
        }
        if (i(codePointBefore)) {
            codePointBefore = Character.codePointBefore(charSequence, charCount2);
            if (!c(codePointBefore)) {
                return i - charCount;
            }
            charCount += Character.charCount(codePointBefore);
            charCount2 -= charCount;
        }
        if (c(codePointBefore)) {
            boolean z = false;
            int i4 = 0;
            while (true) {
                if (z) {
                    charCount += Character.charCount(codePointBefore) + i4 + 1;
                    z = false;
                }
                if (d(codePointBefore)) {
                    int codePointBefore5 = Character.codePointBefore(charSequence, charCount2);
                    int charCount5 = charCount2 - Character.charCount(codePointBefore5);
                    if (charCount5 > 0 && i(codePointBefore5)) {
                        codePointBefore5 = Character.codePointBefore(charSequence, charCount5);
                        if (!c(codePointBefore5)) {
                            return i - charCount;
                        }
                        i2 = Character.charCount(codePointBefore5);
                        Character.charCount(codePointBefore5);
                    }
                    if (e(codePointBefore5)) {
                        charCount += i2 + Character.charCount(codePointBefore5);
                    }
                } else {
                    if (charCount2 > 0) {
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        charCount2 -= Character.charCount(codePointBefore);
                        if (codePointBefore == 8205) {
                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                            charCount2 -= Character.charCount(codePointBefore);
                            if (charCount2 > 0 && i(codePointBefore)) {
                                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                int charCount6 = Character.charCount(codePointBefore);
                                charCount2 -= Character.charCount(codePointBefore);
                                i4 = charCount6;
                                z = true;
                                if (charCount2 != 0 || !z || !c(codePointBefore)) {
                                    break;
                                    break;
                                }
                            } else {
                                z = true;
                            }
                        }
                    }
                    i4 = 0;
                    if (charCount2 != 0) {
                        break;
                    }
                }
            }
        }
        return i - charCount;
    }

    public boolean c(int i) {
        return this.f268a.nativeFlutterTextUtilsIsEmoji(i);
    }

    public boolean d(int i) {
        return this.f268a.nativeFlutterTextUtilsIsEmojiModifier(i);
    }

    public boolean e(int i) {
        return this.f268a.nativeFlutterTextUtilsIsEmojiModifierBase(i);
    }

    public boolean f(int i) {
        return (48 <= i && i <= 57) || i == 35 || i == 42;
    }

    public boolean g(int i) {
        return this.f268a.nativeFlutterTextUtilsIsRegionalIndicator(i);
    }

    public boolean h(int i) {
        return 917536 <= i && i <= 917630;
    }

    public boolean i(int i) {
        return this.f268a.nativeFlutterTextUtilsIsVariationSelector(i);
    }
}
