package com.huawei.hms.scankit.p;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import kotlin.text.Typography;
import org.apache.commons.codec.language.Soundex;

/* compiled from: DecodedBitStreamParser */
final class o1 {
    private static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] b;
    private static final char[] c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] d;
    private static final char[] e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* compiled from: DecodedBitStreamParser */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.hms.scankit.p.o1$b[] r0 = com.huawei.hms.scankit.p.o1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.scankit.p.o1$b r1 = com.huawei.hms.scankit.p.o1.b.C40_ENCODE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.scankit.p.o1$b r1 = com.huawei.hms.scankit.p.o1.b.TEXT_ENCODE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.scankit.p.o1$b r1 = com.huawei.hms.scankit.p.o1.b.ANSIX12_ENCODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.scankit.p.o1$b r1 = com.huawei.hms.scankit.p.o1.b.EDIFACT_ENCODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.scankit.p.o1$b r1 = com.huawei.hms.scankit.p.o1.b.BASE256_ENCODE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.o1.a.<clinit>():void");
        }
    }

    /* compiled from: DecodedBitStreamParser */
    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        UPPER_ENCODE
    }

    static {
        char[] cArr = {'!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', Soundex.SILENT_MARKER, '.', '/', ':', ';', Typography.less, '=', Typography.greater, '?', '@', '[', '\\', ']', '^', '_'};
        b = cArr;
        d = cArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.huawei.hms.scankit.p.w1 a(byte[] r9, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r10) throws com.huawei.hms.scankit.p.a {
        /*
            com.huawei.hms.scankit.p.w r0 = new com.huawei.hms.scankit.p.w
            r0.<init>(r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 0
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 1
            r4.<init>(r5)
            com.huawei.hms.scankit.p.o1$b r6 = com.huawei.hms.scankit.p.o1.b.ASCII_ENCODE
        L_0x001a:
            com.huawei.hms.scankit.p.o1$b r7 = com.huawei.hms.scankit.p.o1.b.ASCII_ENCODE
            if (r6 != r7) goto L_0x0023
            com.huawei.hms.scankit.p.o1$b r6 = a((com.huawei.hms.scankit.p.w) r0, (java.lang.StringBuilder) r1, (java.lang.StringBuilder) r2)
            goto L_0x0054
        L_0x0023:
            int[] r8 = com.huawei.hms.scankit.p.o1.a.a
            int r6 = r6.ordinal()
            r6 = r8[r6]
            if (r6 == r5) goto L_0x0050
            r8 = 2
            if (r6 == r8) goto L_0x004c
            r8 = 3
            if (r6 == r8) goto L_0x0048
            r8 = 4
            if (r6 == r8) goto L_0x0044
            r8 = 5
            if (r6 != r8) goto L_0x003d
            a((com.huawei.hms.scankit.p.w) r0, (java.lang.StringBuilder) r1, (java.util.Collection<byte[]>) r4)
            goto L_0x0053
        L_0x003d:
            java.lang.String r9 = "AIScanException"
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a(r9)
            throw r9
        L_0x0044:
            c(r0, r1)
            goto L_0x0053
        L_0x0048:
            a((com.huawei.hms.scankit.p.w) r0, (java.lang.StringBuilder) r1)
            goto L_0x0053
        L_0x004c:
            d(r0, r1)
            goto L_0x0053
        L_0x0050:
            b(r0, r1)
        L_0x0053:
            r6 = r7
        L_0x0054:
            com.huawei.hms.scankit.p.o1$b r7 = com.huawei.hms.scankit.p.o1.b.PAD_ENCODE
            if (r6 == r7) goto L_0x005e
            int r7 = r0.a()
            if (r7 > 0) goto L_0x001a
        L_0x005e:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x0067
            r1.append(r2)
        L_0x0067:
            int r0 = r1.length()
            byte[] r2 = new byte[r0]
        L_0x006d:
            if (r3 >= r0) goto L_0x0079
            char r5 = r1.charAt(r3)
            byte r5 = (byte) r5
            r2[r3] = r5
            int r3 = r3 + 1
            goto L_0x006d
        L_0x0079:
            java.lang.String r10 = com.huawei.hms.scankit.p.c7.a((byte[]) r2, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r10)
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0090 }
            r0.<init>(r2, r10)     // Catch:{ UnsupportedEncodingException -> 0x0090 }
            com.huawei.hms.scankit.p.w1 r10 = new com.huawei.hms.scankit.p.w1
            boolean r1 = r4.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x008c
            r4 = r2
        L_0x008c:
            r10.<init>(r9, r0, r4, r2)
            return r10
        L_0x0090:
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.o1.a(byte[], java.util.Map):com.huawei.hms.scankit.p.w1");
    }

    private static void b(w wVar, StringBuilder sb) throws a {
        int a2;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (wVar.a() != 8 && (a2 = wVar.a(8)) != 254) {
            a(a2, wVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int[] b2 = b(sb, i, iArr[i2], z);
                i = b2[0];
                z = b2[1] == 1;
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void c(w wVar, StringBuilder sb) {
        while (wVar.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int a2 = wVar.a(6);
                if (a2 == 31) {
                    int b2 = 8 - wVar.b();
                    if (b2 != 8) {
                        wVar.a(b2);
                        return;
                    }
                    return;
                }
                if ((a2 & 32) == 0) {
                    a2 |= 64;
                }
                sb.append((char) a2);
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(w wVar, StringBuilder sb) throws a {
        int a2;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (wVar.a() != 8 && (a2 = wVar.a(8)) != 254) {
            a(a2, wVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int[] a3 = a(sb, i, iArr[i2], z);
                i = a3[0];
                z = a3[1] == 1;
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [boolean, int], vars: [r8v0 ?, r8v1 ?, r8v2 ?, r8v3 ?, r8v4 ?, r8v5 ?, r8v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private static int[] b(java.lang.StringBuilder r5, int r6, int r7, 
/*
Method generation error in method: com.huawei.hms.scankit.p.o1.b(java.lang.StringBuilder, int, int, boolean):int[], dex: classes2.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/

    private static b a(w wVar, StringBuilder sb, StringBuilder sb2) throws a {
        boolean z = false;
        do {
            int a2 = wVar.a(8);
            if (a2 == 0) {
                throw a.a("AIScanException");
            } else if (a2 <= 128) {
                if (z) {
                    a2 += 128;
                }
                sb.append((char) (a2 - 1));
                return b.ASCII_ENCODE;
            } else if (a2 == 129) {
                return b.PAD_ENCODE;
            } else {
                if (a2 <= 229) {
                    int i = a2 - 130;
                    if (i < 10) {
                        sb.append('0');
                    }
                    sb.append(i);
                } else {
                    b a3 = a(a2, sb, sb2, wVar);
                    if (a3 != null) {
                        if (a3 != b.UPPER_ENCODE) {
                            return a3;
                        }
                        z = true;
                    }
                }
            }
        } while (wVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static b a(int i, StringBuilder sb, StringBuilder sb2, w wVar) throws a {
        switch (i) {
            case 230:
                return b.C40_ENCODE;
            case 231:
                return b.BASE256_ENCODE;
            case 232:
                sb.append(29);
                return null;
            case 233:
            case 234:
            case 241:
                return null;
            case 235:
                return b.UPPER_ENCODE;
            case 236:
                sb.append("[)>\u001e05\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case 237:
                sb.append("[)>\u001e06\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case 238:
                return b.ANSIX12_ENCODE;
            case 239:
                return b.TEXT_ENCODE;
            case 240:
                return b.EDIFACT_ENCODE;
            default:
                if (i == 254 && wVar.a() == 0) {
                    return null;
                }
                throw a.a("AIScanException");
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [boolean, int], vars: [r8v0 ?, r8v1 ?, r8v2 ?, r8v3 ?, r8v4 ?, r8v5 ?, r8v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private static int[] a(java.lang.StringBuilder r5, int r6, int r7, 
/*
Method generation error in method: com.huawei.hms.scankit.p.o1.a(java.lang.StringBuilder, int, int, boolean):int[], dex: classes2.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/

    private static void a(w wVar, StringBuilder sb) throws a {
        int a2;
        int[] iArr = new int[3];
        while (wVar.a() != 8 && (a2 = wVar.a(8)) != 254) {
            a(a2, wVar.a(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append(13);
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append(Typography.greater);
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw a.a("AIScanException");
                }
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void a(w wVar, StringBuilder sb, Collection<byte[]> collection) throws a {
        int c2 = wVar.c();
        int i = c2 + 2;
        int a2 = a(wVar.a(8), c2 + 1);
        if (a2 == 0) {
            a2 = wVar.a() / 8;
        } else if (a2 >= 250) {
            a2 = ((a2 - 249) * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + a(wVar.a(8), i);
            i = c2 + 3;
        }
        if (a2 >= 0) {
            byte[] bArr = new byte[a2];
            int i2 = 0;
            while (i2 < a2) {
                if (wVar.a() >= 8) {
                    bArr[i2] = (byte) a(wVar.a(8), i);
                    i2++;
                    i++;
                } else {
                    throw a.a("AIScanException");
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + e2);
            }
        } else {
            throw a.a("AIScanException");
        }
    }

    private static int a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
