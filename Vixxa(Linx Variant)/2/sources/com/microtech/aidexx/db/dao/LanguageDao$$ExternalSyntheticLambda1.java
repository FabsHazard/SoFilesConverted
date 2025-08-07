package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LanguageDao$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ LanguageDao f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LanguageDao$$ExternalSyntheticLambda1(LanguageDao languageDao, String str) {
        this.f$0 = languageDao;
        this.f$1 = str;
    }

    public final Object call() {
        return LanguageDao.removeLanguageOfOtherVersion$lambda$7(this.f$0, this.f$1);
    }
}
