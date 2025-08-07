package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LanguageDao$$ExternalSyntheticLambda6 implements Callable {
    public final /* synthetic */ LanguageDao f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ LanguageDao$$ExternalSyntheticLambda6(LanguageDao languageDao, String str, String str2, String str3) {
        this.f$0 = languageDao;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = str3;
    }

    public final Object call() {
        return LanguageDao.query$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
