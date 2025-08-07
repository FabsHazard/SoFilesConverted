package com.microtech.aidexx.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/data/DataTaskType;", "", "()V", "Download", "Upload", "UploadDel", "Lcom/microtech/aidexx/data/DataTaskType$Download;", "Lcom/microtech/aidexx/data/DataTaskType$Upload;", "Lcom/microtech/aidexx/data/DataTaskType$UploadDel;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataSyncController.kt */
public abstract class DataTaskType {
    public /* synthetic */ DataTaskType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/microtech/aidexx/data/DataTaskType$Upload;", "Lcom/microtech/aidexx/data/DataTaskType;", "()V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataSyncController.kt */
    public static final class Upload extends DataTaskType {
        public static final Upload INSTANCE = new Upload();

        private Upload() {
            super((DefaultConstructorMarker) null);
        }
    }

    private DataTaskType() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/microtech/aidexx/data/DataTaskType$Download;", "Lcom/microtech/aidexx/data/DataTaskType;", "()V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataSyncController.kt */
    public static final class Download extends DataTaskType {
        public static final Download INSTANCE = new Download();

        private Download() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/microtech/aidexx/data/DataTaskType$UploadDel;", "Lcom/microtech/aidexx/data/DataTaskType;", "()V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataSyncController.kt */
    public static final class UploadDel extends DataTaskType {
        public static final UploadDel INSTANCE = new UploadDel();

        private UploadDel() {
            super((DefaultConstructorMarker) null);
        }
    }
}
