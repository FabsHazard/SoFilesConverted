package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.LanguageEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class LanguageEntityCursor extends Cursor<LanguageEntity> {
    private static final LanguageEntity_.LanguageEntityIdGetter ID_GETTER = LanguageEntity_.__ID_GETTER;
    private static final int __ID_key = LanguageEntity_.key.id;
    private static final int __ID_language = LanguageEntity_.language.id;
    private static final int __ID_module = LanguageEntity_.module.id;
    private static final int __ID_value = LanguageEntity_.value.id;
    private static final int __ID_version = LanguageEntity_.version.id;

    static final class Factory implements CursorFactory<LanguageEntity> {
        Factory() {
        }

        public Cursor<LanguageEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new LanguageEntityCursor(transaction, j, boxStore);
        }
    }

    public LanguageEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, LanguageEntity_.__INSTANCE, boxStore);
    }

    public long getId(LanguageEntity languageEntity) {
        return ID_GETTER.getId(languageEntity);
    }

    public long put(LanguageEntity languageEntity) {
        String key = languageEntity.getKey();
        int i = 0;
        int i2 = key != null ? __ID_key : 0;
        String value = languageEntity.getValue();
        int i3 = value != null ? __ID_value : 0;
        String language = languageEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String module = languageEntity.getModule();
        collect400000(this.cursor, 0, 1, i2, key, i3, value, i4, language, module != null ? __ID_module : 0, module);
        Long id = languageEntity.getId();
        String version = languageEntity.getVersion();
        if (version != null) {
            i = __ID_version;
        }
        long collect313311 = collect313311(this.cursor, id != null ? id.longValue() : 0, 2, i, version, 0, (String) null, 0, (String) null, 0, (byte[]) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        languageEntity.setId(Long.valueOf(collect313311));
        return collect313311;
    }
}
