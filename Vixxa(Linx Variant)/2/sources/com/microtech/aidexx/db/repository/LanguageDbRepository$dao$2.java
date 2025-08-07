package com.microtech.aidexx.db.repository;

import com.microtech.aidexx.db.dao.LanguageDao;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/db/dao/LanguageDao;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageDbRepository.kt */
final class LanguageDbRepository$dao$2 extends Lambda implements Function0<LanguageDao> {
    public static final LanguageDbRepository$dao$2 INSTANCE = new LanguageDbRepository$dao$2();

    LanguageDbRepository$dao$2() {
        super(0);
    }

    public final LanguageDao invoke() {
        return new LanguageDao();
    }
}
