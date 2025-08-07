package com.microtech.aidexx.db.entity.event;

import com.google.gson.JsonDeserializer;
import java.util.Date;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/microtech/aidexx/db/entity/event/BaseEventDetail$convertToEntityProperty$gson$1$1", "Lcom/google/gson/JsonDeserializer;", "Ljava/util/Date;", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventDetail.kt */
public final class BaseEventDetail$convertToEntityProperty$gson$1$1 implements JsonDeserializer<Date> {
    BaseEventDetail$convertToEntityProperty$gson$1$1() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date deserialize(com.google.gson.JsonElement r4, java.lang.reflect.Type r5, com.google.gson.JsonDeserializationContext r6) {
        /*
            r3 = this;
            r5 = 0
            if (r4 == 0) goto L_0x0079
            java.lang.String r4 = r4.getAsString()
            if (r4 == 0) goto L_0x0079
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0064 }
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "AM"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0064 }
            r1 = 1
            boolean r6 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r6, (java.lang.CharSequence) r0, (boolean) r1)     // Catch:{ all -> 0x0064 }
            if (r6 != 0) goto L_0x0052
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "PM"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0064 }
            boolean r6 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r6, (java.lang.CharSequence) r0, (boolean) r1)     // Catch:{ all -> 0x0064 }
            if (r6 == 0) goto L_0x0027
            goto L_0x0052
        L_0x0027:
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = ","
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0064 }
            r1 = 0
            r2 = 2
            boolean r6 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0064 }
            if (r6 == 0) goto L_0x0044
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "MMM dd, yyyy HH:mm:ss"
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0064 }
            r6.<init>(r0, r1)     // Catch:{ all -> 0x0064 }
            java.util.Date r4 = r6.parse(r4)     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x0044:
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ssZ"
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0064 }
            r6.<init>(r0, r1)     // Catch:{ all -> 0x0064 }
            java.util.Date r4 = r6.parse(r4)     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x0052:
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "MMM dd, yyyy hh:mm:ss a"
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0064 }
            r6.<init>(r0, r1)     // Catch:{ all -> 0x0064 }
            java.util.Date r4 = r6.parse(r4)     // Catch:{ all -> 0x0064 }
        L_0x005f:
            java.lang.Object r4 = kotlin.Result.m343constructorimpl(r4)     // Catch:{ all -> 0x0064 }
            goto L_0x006f
        L_0x0064:
            r4 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m343constructorimpl(r4)
        L_0x006f:
            boolean r6 = kotlin.Result.m349isFailureimpl(r4)
            if (r6 == 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r5 = r4
        L_0x0077:
            java.util.Date r5 = (java.util.Date) r5
        L_0x0079:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.event.BaseEventDetail$convertToEntityProperty$gson$1$1.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):java.util.Date");
    }
}
