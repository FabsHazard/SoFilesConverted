package com.microtech.aidexx.db.entity;

import com.microtech.aidexx.db.entity.LanguageConfEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class LanguageConfEntityCursor extends Cursor<LanguageConfEntity> {
    private static final LanguageConfEntity_.LanguageConfEntityIdGetter ID_GETTER = LanguageConfEntity_.__ID_GETTER;
    private static final int __ID_chineseName = LanguageConfEntity_.chineseName.id;
    private static final int __ID_code = LanguageConfEntity_.code.id;
    private static final int __ID_name = LanguageConfEntity_.name.id;
    private static final int __ID_version = LanguageConfEntity_.version.id;

    static final class Factory implements CursorFactory<LanguageConfEntity> {
        Factory() {
        }

        public Cursor<LanguageConfEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new LanguageConfEntityCursor(transaction, j, boxStore);
        }
    }

    public LanguageConfEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, LanguageConfEntity_.__INSTANCE, boxStore);
    }

    public long getId(LanguageConfEntity languageConfEntity) {
        return ID_GETTER.getId(languageConfEntity);
    }

    public long put(LanguageConfEntity languageConfEntity) {
        Long id = languageConfEntity.getId();
        String name = languageConfEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String chineseName = languageConfEntity.getChineseName();
        int i3 = chineseName != null ? __ID_chineseName : 0;
        String code = languageConfEntity.getCode();
        int i4 = code != null ? __ID_code : 0;
        String version = languageConfEntity.getVersion();
        if (version != null) {
            i = __ID_version;
        }
        long collect400000 = collect400000(this.cursor, id != null ? id.longValue() : 0, 3, i2, name, i3, chineseName, i4, code, i, version);
        languageConfEntity.setId(Long.valueOf(collect400000));
        return collect400000;
    }
}
