package com.microtech.aidexx.db.entity;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.flyco.roundview.BuildConfig;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.event.DietEntity_;
import com.microtech.aidexx.db.entity.event.ExerciseEntity_;
import com.microtech.aidexx.db.entity.event.InsulinEntity_;
import com.microtech.aidexx.db.entity.event.MedicationEntity_;
import com.microtech.aidexx.db.entity.event.OthersEntity_;
import com.microtech.aidexx.db.entity.event.UnitEntity_;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity_;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import io.objectbox.BoxStoreBuilder;
import io.objectbox.ModelBuilder;
import okhttp3.internal.ws.WebSocketProtocol;

public class MyObjectBox {
    public static BoxStoreBuilder builder() {
        BoxStoreBuilder boxStoreBuilder = new BoxStoreBuilder(getModel());
        boxStoreBuilder.entity(BloodGlucoseEntity_.__INSTANCE);
        boxStoreBuilder.entity(CalibrateEntity_.__INSTANCE);
        boxStoreBuilder.entity(DietEntity_.__INSTANCE);
        boxStoreBuilder.entity(DietSysPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(DietUsrPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(ExerciseEntity_.__INSTANCE);
        boxStoreBuilder.entity(HistoryDeviceInfo_.__INSTANCE);
        boxStoreBuilder.entity(InsulinEntity_.__INSTANCE);
        boxStoreBuilder.entity(InsulinSysPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(InsulinUsrPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(LanguageConfEntity_.__INSTANCE);
        boxStoreBuilder.entity(LanguageEntity_.__INSTANCE);
        boxStoreBuilder.entity(MedicationEntity_.__INSTANCE);
        boxStoreBuilder.entity(MedicineSysPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(MedicineUsrPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(OtaResourceEntity_.__INSTANCE);
        boxStoreBuilder.entity(OthersEntity_.__INSTANCE);
        boxStoreBuilder.entity(RealCgmHistoryEntity_.__INSTANCE);
        boxStoreBuilder.entity(SportSysPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(SportUsrPresetEntity_.__INSTANCE);
        boxStoreBuilder.entity(TimezoneHistoryEntity_.__INSTANCE);
        boxStoreBuilder.entity(TransmitterEntity_.__INSTANCE);
        boxStoreBuilder.entity(UnitEntity_.__INSTANCE);
        boxStoreBuilder.entity(UserEntity_.__INSTANCE);
        return boxStoreBuilder;
    }

    private static byte[] getModel() {
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.lastEntityId(31, 1455564533730082879L);
        modelBuilder.lastIndexId(139, 4381851029577242793L);
        modelBuilder.lastRelationId(0, 0);
        buildEntityBloodGlucoseEntity(modelBuilder);
        buildEntityCalibrateEntity(modelBuilder);
        buildEntityDietEntity(modelBuilder);
        buildEntityDietSysPresetEntity(modelBuilder);
        buildEntityDietUsrPresetEntity(modelBuilder);
        buildEntityExerciseEntity(modelBuilder);
        buildEntityHistoryDeviceInfo(modelBuilder);
        buildEntityInsulinEntity(modelBuilder);
        buildEntityInsulinSysPresetEntity(modelBuilder);
        buildEntityInsulinUsrPresetEntity(modelBuilder);
        buildEntityLanguageConfEntity(modelBuilder);
        buildEntityLanguageEntity(modelBuilder);
        buildEntityMedicationEntity(modelBuilder);
        buildEntityMedicineSysPresetEntity(modelBuilder);
        buildEntityMedicineUsrPresetEntity(modelBuilder);
        buildEntityOtaResourceEntity(modelBuilder);
        buildEntityOthersEntity(modelBuilder);
        buildEntityRealCgmHistoryEntity(modelBuilder);
        buildEntitySportSysPresetEntity(modelBuilder);
        buildEntitySportUsrPresetEntity(modelBuilder);
        buildEntityTimezoneHistoryEntity(modelBuilder);
        buildEntityTransmitterEntity(modelBuilder);
        buildEntityUnitEntity(modelBuilder);
        buildEntityUserEntity(modelBuilder);
        return modelBuilder.build();
    }

    private static void buildEntityBloodGlucoseEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("BloodGlucoseEntity");
        entity.id(2, 2659511795003322512L).lastPropertyId(27, 7969081728773238869L);
        entity.flags(1);
        entity.property("idx", 6).id(2, 132622069839520723L).flags(131);
        entity.property("state", 5).id(3, 7469246945412476484L).flags(8).indexId(59, 3314888078337147835L);
        entity.property("id", 9).id(8, 4599134780404586536L);
        entity.property("userId", 9).id(17, 1841717514043120297L).flags(2048).indexId(53, 2592750264887561755L);
        entity.property("recordIndex", 6).id(4, 4930819974189718995L).flags(10).indexId(60, 5124199896012888691L);
        entity.property("appCreateTime", 10).id(26, 2884966976741368834L);
        entity.property("recordId", 9).id(5, 276290224271292949L);
        entity.property("deleteStatus", 5).id(6, 6349895750968589994L).flags(8).indexId(61, 7606689938840029604L);
        entity.property("language", 9).id(13, 3426559270158399144L);
        entity.property("uploadState", 5).id(15, 1870172707163954533L);
        entity.property("autoIncrementColumn", 6).id(19, 7769021705376890940L).flags(10).indexId(54, 2222283051497754930L);
        entity.property("timestamp", 6).id(20, 4849691174432895349L).flags(8).indexId(107, 8711721386851594917L);
        entity.property("moment", 5).id(25, 2189339613815624930L);
        entity.property("appTime", 9).id(21, 2450385978921859339L).flags(2048).indexId(132, 638033228048089918L);
        entity.property("appTimeZone", 9).id(22, 9113565389350266489L);
        entity.property("dstOffset", 9).id(23, 579426193175041894L);
        entity.property("bloodGlucoseId", 9).id(16, 3254201271799334166L);
        entity.property("testTag", 5).id(10, 5002277780203697071L);
        entity.property("bloodGlucoseMg", 7).id(14, 223752725644405909L);
        entity.entityDone();
    }

    private static void buildEntityCalibrateEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("CalibrateEntity");
        entity.id(3, 3935464691192281220L).lastPropertyId(37, 2956092476096890092L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 1659475645645355696L).flags(131);
        entity.property("state", 5).id(2, 267084330545205383L).flags(8).indexId(62, 5833506585539992206L);
        entity.property("id", 9).id(7, 1980594159120035336L);
        entity.property("userId", 9).id(21, 129030978577544381L).flags(2048).indexId(63, 7337538415516076991L);
        entity.property("recordIndex", 6).id(10, 8843164036468077693L).flags(10).indexId(64, 1409759998386140371L);
        entity.property("appCreateTime", 10).id(36, 1868467687668979737L);
        entity.property("recordId", 9).id(6, 3544707884318661333L);
        entity.property("deleteStatus", 5).id(11, 1539410403693338774L).flags(8).indexId(65, 8655618364661843764L);
        entity.property("language", 9).id(34, 9001348856415619724L);
        entity.property("uploadState", 5).id(20, 7857804310421410618L);
        entity.property("autoIncrementColumn", 6).id(28, 5143879068194770694L).flags(10).indexId(82, 7678948453197238663L);
        entity.property("timestamp", 6).id(29, 3542958750742038442L).flags(8).indexId(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 1284854798266887207L);
        entity.property("moment", 5).id(35, 4005768965931230206L);
        entity.property("appTime", 9).id(30, 6162618427988063463L).flags(2048).indexId(133, 5655998173074535865L);
        entity.property("appTimeZone", 9).id(31, 5775313631615037224L);
        entity.property("dstOffset", 9).id(32, 5141536478271644702L);
        entity.property("calTime", 10).id(4, 7582371188781171911L);
        entity.property("deviceId", 9).id(8, 5963483377146069117L);
        entity.property("eventIndex", 5).id(9, 1922739751931604979L);
        entity.property("calibrationId", 9).id(22, 4482092923245523151L).flags(34848).indexId(56, 6610165944256252297L);
        entity.property("sensorIndex", 5).id(13, 8125956428621912240L);
        entity.property("sensorId", 9).id(23, 4149425479326426113L).flags(2048).indexId(57, 623505747218863944L);
        entity.property("referenceGlucose", 7).id(14, 7767299514313661035L);
        entity.property("indexBeforeCal", 5).id(15, 517456111586816415L);
        entity.property("indexAfterCal", 5).id(16, 1633386326437593131L);
        entity.property("cf", 7).id(24, 8540917887690577320L);
        entity.property(TypedValues.CycleType.S_WAVE_OFFSET, 7).id(25, 7495105757775643748L);
        entity.property("isValid", 5).id(19, 5332175561973877501L).flags(2);
        entity.property("index", 5).id(26, 2016549721122492285L);
        entity.property("timeOffset", 5).id(27, 6783204365051668306L).flags(8).indexId(58, 7564228627611390971L);
        entity.entityDone();
    }

    private static void buildEntityDietEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("DietEntity");
        entity.id(4, 31306500703423503L).lastPropertyId(29, 8493704736834831483L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 8736052162967047297L).flags(131);
        entity.property("state", 5).id(2, 8398299769075168865L).flags(8).indexId(1, 568424772314311462L);
        entity.property("id", 9).id(3, 3274176445097742570L);
        entity.property("userId", 9).id(18, 3707427638935263519L).flags(2048).indexId(47, 79869320129662959L);
        entity.property("recordIndex", 6).id(5, 5930182334723381631L).flags(10).indexId(2, 7275748217190641693L);
        entity.property("appCreateTime", 10).id(28, 283189452117080884L);
        entity.property("recordId", 9).id(12, 3272834351114810061L);
        entity.property("deleteStatus", 5).id(6, 1430618255546017495L).flags(8).indexId(3, 7255728185658764644L);
        entity.property("language", 9).id(16, 6454178309052537251L);
        entity.property("uploadState", 5).id(17, 207094887177331273L);
        entity.property("autoIncrementColumn", 6).id(24, 3974990352578971967L).flags(10).indexId(83, 628598436875707327L);
        entity.property("timestamp", 6).id(20, 3263858770712291482L).flags(8).indexId(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 1000264017552478805L);
        entity.property("moment", 5).id(27, 6037008240831689813L);
        entity.property("appTime", 9).id(21, 7674304024881368077L).flags(2048).indexId(134, 5232772020052197550L);
        entity.property("appTimeZone", 9).id(22, 1352945123859162310L);
        entity.property("dstOffset", 9).id(23, 5006517634173716351L);
        entity.property("mealTime", 10).id(7, 1280207553588203793L).flags(8).indexId(4, 26280075633966475L);
        entity.property("foodId", 9).id(25, 6688105346314967640L).flags(2048).indexId(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 778484902091773442L);
        entity.property("mealRemark", 9).id(9, 5316782204110360416L);
        entity.property("carbohydrate", 5).id(10, 7558181467341666796L).flags(2);
        entity.property("isPreset", 1).id(11, 6361412788343398349L);
        entity.property("expandList", 9).id(26, 4379017716405474123L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityDietSysPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("DietSysPresetEntity");
        entity.id(20, 2468575246959347917L).lastPropertyId(15, 6472623158525299404L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 5616096943835559550L).flags(1);
        entity.property("name", 9).id(2, 3672920084467557279L).flags(2048).indexId(89, 2157544036888837275L);
        entity.property("userId", 9).id(3, 7581747399085491341L);
        entity.property("deleteFlag", 5).id(13, 8726936976284065470L);
        entity.property("language", 9).id(12, 1895697921389436377L).flags(2048).indexId(91, 5822379580074844283L);
        entity.property("protein", 8).id(5, 486801086680242374L);
        entity.property("fat", 8).id(6, 22710529896567162L);
        entity.property("carbohydrate", 8).id(7, 6715703934837946895L);
        entity.property("quantity", 8).id(8, 3635147302098665782L);
        entity.property("unit", 5).id(9, 5118200925144776079L);
        entity.property("energyKcal", 8).id(10, 1987358723175454301L);
        entity.property("foodSysPresetId", 6).id(11, 1122289115369176582L).flags(2);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(15, 6472623158525299404L);
        entity.entityDone();
    }

    private static void buildEntityDietUsrPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("DietUsrPresetEntity");
        entity.id(22, 1832060993466422500L).lastPropertyId(13, 6316346519726067968L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 4421311631590951345L).flags(1);
        entity.property("name", 9).id(2, 3257057460710871674L).flags(2048).indexId(92, 7261024731234573297L);
        entity.property("userId", 9).id(3, 5961435730923929613L);
        entity.property("deleteFlag", 5).id(13, 6316346519726067968L);
        entity.property("language", 9).id(5, 3666783162703748779L).flags(2048).indexId(93, 6803387429408632632L);
        entity.property("protein", 8).id(6, 4492350391294095870L);
        entity.property("fat", 8).id(7, 4588004530924347214L);
        entity.property("carbohydrate", 8).id(8, 4447413205383394435L);
        entity.property("quantity", 8).id(9, 4112701171661699861L);
        entity.property("unit", 5).id(10, 1376984434860818858L);
        entity.property("foodUserPresetId", 9).id(11, 7574666260849540306L);
        entity.property("autoIncrementColumn", 6).id(12, 6615376839286868827L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityExerciseEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("ExerciseEntity");
        entity.id(5, 6182581021651504097L).lastPropertyId(28, 4091080300034293098L);
        entity.flags(1);
        entity.property("idx", 6).id(2, 4907160252678804421L).flags(131);
        entity.property("state", 5).id(3, 910071053042800435L).flags(8).indexId(7, 4795177988159928948L);
        entity.property("id", 9).id(4, 6273846280360064145L);
        entity.property("userId", 9).id(17, 8975143310055443872L).flags(2048).indexId(48, 8989698478573302387L);
        entity.property("recordIndex", 6).id(5, 988563463125558468L).flags(10).indexId(9, 2383950932554992071L);
        entity.property("appCreateTime", 10).id(27, 5519400445349740434L);
        entity.property("recordId", 9).id(12, 1466297911193755905L);
        entity.property("deleteStatus", 5).id(6, 174964739822827513L).flags(8).indexId(10, 5042139989135211828L);
        entity.property("language", 9).id(15, 3227804047353850320L);
        entity.property("uploadState", 5).id(16, 7143208131821765487L);
        entity.property("autoIncrementColumn", 6).id(23, 6234866494794812502L).flags(10).indexId(84, 711543162680977393L);
        entity.property("timestamp", 6).id(19, 6999493615056499554L).flags(8).indexId(110, 4230264328969194958L);
        entity.property("moment", 5).id(26, 8656250967508961869L);
        entity.property("appTime", 9).id(20, 3949554488971213085L).flags(2048).indexId(135, 2348194469391998258L);
        entity.property("appTimeZone", 9).id(21, 4669662072843838113L);
        entity.property("dstOffset", 9).id(22, 7521034597164352364L);
        entity.property("exerciseId", 9).id(24, 8380064575831014528L).flags(2048).indexId(103, 4380849916484975771L);
        entity.property("startTime", 10).id(8, 8970526300760346691L).flags(8).indexId(12, 7676122701989233005L);
        entity.property(TypedValues.TransitionType.S_DURATION, 5).id(9, 3707699986454493942L).flags(2);
        entity.property("intensity", 5).id(10, 1287171270769075193L).flags(2);
        entity.property("isPreset", 1).id(11, 9203718409971281997L);
        entity.property("expandList", 9).id(25, 4835259137349614069L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityHistoryDeviceInfo(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("HistoryDeviceInfo");
        entity.id(27, 4384700248466900906L).lastPropertyId(15, 2172533182584752937L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 2256085287853661061L).flags(1);
        entity.property("deviceId", 9).id(2, 9034952929032124796L);
        entity.property("userId", 9).id(3, 1029730291555361963L);
        entity.property("sensorId", 9).id(4, 5623795344835499733L);
        entity.property("sensorIndex", 5).id(5, 8027261356143614081L);
        entity.property("sensorStartUp", 10).id(6, 1318528388025443079L);
        entity.property("startUpTimeZone", 9).id(7, 749200512857774575L);
        entity.property("deviceModel", 5).id(8, 1546702258521641512L);
        entity.property("deviceSn", 9).id(9, 1428024561358246977L).flags(34848).indexId(124, 3096654673525374584L);
        entity.property("deviceMac", 9).id(10, 3687832090412056131L);
        entity.property("deviceKey", 9).id(11, 83629949689631071L);
        entity.property("registerTime", 10).id(12, 7734517528381146718L);
        entity.property("unregisterTime", 10).id(13, 2468569461220254728L);
        entity.property("et", 5).id(14, 3968463069923532950L);
        entity.property("name", 9).id(15, 2172533182584752937L);
        entity.entityDone();
    }

    private static void buildEntityInsulinEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("InsulinEntity");
        entity.id(6, 2416889281656664236L).lastPropertyId(29, 1783799210363667523L);
        entity.flags(1);
        entity.property("idx", 6).id(2, 4604381433581510557L).flags(131);
        entity.property("state", 5).id(3, 7335198915791057648L).flags(8).indexId(14, 7350648359440155127L);
        entity.property("id", 9).id(4, 3281572235647422828L);
        entity.property("userId", 9).id(18, 325600874915340522L).flags(2048).indexId(49, 5457304678723546875L);
        entity.property("recordIndex", 6).id(5, 106137149998599121L).flags(10).indexId(15, 3091532100494447155L);
        entity.property("appCreateTime", 10).id(28, 670157836234390536L);
        entity.property("recordId", 9).id(15, 6360114125267440917L);
        entity.property("deleteStatus", 5).id(6, 6910551164116248734L).flags(8).indexId(16, 6731017993397375500L);
        entity.property("language", 9).id(16, 5535791003825223038L);
        entity.property("uploadState", 5).id(17, 8285770155396111806L);
        entity.property("autoIncrementColumn", 6).id(24, 4910212114341671644L).flags(10).indexId(85, 8097248361484965588L);
        entity.property("timestamp", 6).id(20, 5837773453940885663L).flags(8).indexId(111, 4939206304394540204L);
        entity.property("moment", 5).id(27, 5255100178545898670L);
        entity.property("appTime", 9).id(21, 4723332371845297273L).flags(2048).indexId(136, 4949441006714431068L);
        entity.property("appTimeZone", 9).id(22, 3591141967469950425L);
        entity.property("dstOffset", 9).id(23, 2474050780261922788L);
        entity.property("injectionTime", 10).id(7, 5078393237525217994L);
        entity.property("insulinName", 9).id(8, 1918655477591970382L);
        entity.property("insulinId", 9).id(25, 6943507319237023456L).flags(2048).indexId(LocationRequestCompat.QUALITY_LOW_POWER, 5247506206118677409L);
        entity.property("insulinDosage", 7).id(10, 5542473427154253154L).flags(2);
        entity.property("isPreset", 1).id(11, 1670128331277709055L);
        entity.property("expandList", 9).id(26, 3269722083594655439L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityInsulinSysPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("InsulinSysPresetEntity");
        entity.id(21, 5572864439451460832L).lastPropertyId(12, 1768330017792595754L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 6901269936013746758L).flags(1);
        entity.property("name", 9).id(2, 5014823643526654523L).flags(2048).indexId(90, 3498404011456693842L);
        entity.property("userId", 9).id(3, 7244379589710310090L);
        entity.property("deleteFlag", 5).id(11, 5208981275410975449L);
        entity.property("language", 9).id(10, 5699872332351823744L).flags(2048).indexId(94, 5582776403068052227L);
        entity.property("categoryName", 9).id(5, 7564285494600676152L);
        entity.property("tradeName", 9).id(6, 147585614195831089L);
        entity.property("manufacturer", 9).id(7, 2971617163064853914L);
        entity.property("comment", 9).id(8, 2849185324113082112L);
        entity.property("insulinSysPresetId", 6).id(9, 8146437294477652007L).flags(2);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(12, 1768330017792595754L);
        entity.entityDone();
    }

    private static void buildEntityInsulinUsrPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("InsulinUsrPresetEntity");
        entity.id(23, 5262590652966658448L).lastPropertyId(12, 6294846315542738971L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 2386519118488295253L).flags(1);
        entity.property("name", 9).id(2, 5831624817619291799L).flags(2048).indexId(95, 7732343552169915899L);
        entity.property("userId", 9).id(3, 2695844741841527320L);
        entity.property("deleteFlag", 5).id(12, 6294846315542738971L);
        entity.property("language", 9).id(5, 7932405839284009869L).flags(2048).indexId(96, 554742143373834682L);
        entity.property("categoryName", 9).id(6, 5835250810819036531L);
        entity.property("tradeName", 9).id(7, 7391963934103121816L);
        entity.property("manufacturer", 9).id(8, 7012726277747028705L);
        entity.property("comment", 9).id(9, 1227292873497910717L);
        entity.property("insulinUserPresetId", 9).id(10, 3058709410981865713L);
        entity.property("autoIncrementColumn", 6).id(11, 1632329533523413071L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityLanguageConfEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("LanguageConfEntity");
        entity.id(26, 1394050152852526191L).lastPropertyId(8, 6812933366931028477L);
        entity.property("id", 6).id(1, 4910702244691538147L).flags(3);
        entity.property("name", 9).id(2, 1420632504292872075L).flags(2048).indexId(120, 5480781226479900504L);
        entity.property("chineseName", 9).id(3, 6733980562130932886L);
        entity.property("code", 9).id(8, 6812933366931028477L).flags(2048).indexId(WebSocketProtocol.PAYLOAD_SHORT, 1787237848506588224L);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(7, 1076796548118034917L).flags(2048).indexId(125, 8531824948293500033L);
        entity.entityDone();
    }

    private static void buildEntityLanguageEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("LanguageEntity");
        entity.id(25, 1427408717192841464L).lastPropertyId(6, 3846256734689009489L);
        entity.property("id", 6).id(1, 5363728080836365659L).flags(3);
        entity.property("key", 9).id(2, 7037259140514999646L);
        entity.property("value", 9).id(3, 5144873761686809870L);
        entity.property("language", 9).id(4, 6189265443214906938L).flags(2048).indexId(115, 3879603874006052199L);
        entity.property("module", 9).id(5, 5046728434083632439L).flags(2048).indexId(116, 3143160686766882314L);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(6, 3846256734689009489L).flags(2048).indexId(117, 9023363476471754759L);
        entity.entityDone();
    }

    private static void buildEntityMedicationEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("MedicationEntity");
        entity.id(7, 7734804275381559465L).lastPropertyId(29, 2631182173098039993L);
        entity.flags(1);
        entity.property("idx", 6).id(2, 5076665026869096694L).flags(131);
        entity.property("state", 5).id(3, 4237827023557649377L).flags(8).indexId(19, 8751653104049114890L);
        entity.property("id", 9).id(4, 8201738998473504311L);
        entity.property("userId", 9).id(18, 2598528315334054185L).flags(2048).indexId(50, 623640250611916628L);
        entity.property("recordIndex", 6).id(5, 5178745355362076858L).flags(10).indexId(20, 2474816827483347774L);
        entity.property("appCreateTime", 10).id(28, 1614025419670985477L);
        entity.property("recordId", 9).id(15, 8986096121625046197L);
        entity.property("deleteStatus", 5).id(6, 3781059239641010483L).flags(8).indexId(21, 3137939709092585813L);
        entity.property("language", 9).id(16, 281034542187993381L);
        entity.property("uploadState", 5).id(17, 6724080037284163879L);
        entity.property("autoIncrementColumn", 6).id(24, 6453187588323283910L).flags(10).indexId(86, 5373358982783068681L);
        entity.property("timestamp", 6).id(20, 3295012446919470031L).flags(8).indexId(112, 4206366859718425483L);
        entity.property("moment", 5).id(27, 755864418463837730L);
        entity.property("appTime", 9).id(21, 7701036706524925159L).flags(2048).indexId(137, 3476572920721342096L);
        entity.property("appTimeZone", 9).id(22, 8549379521314455337L);
        entity.property("dstOffset", 9).id(23, 8349012982142642402L);
        entity.property("medicationId", 9).id(25, 6501625751319765338L).flags(2048).indexId(105, 7011583210046466237L);
        entity.property("takenTime", 10).id(8, 690594194040617503L);
        entity.property("medicineName", 9).id(9, 1929256666003151289L).flags(2048).indexId(23, 5317146979340168770L);
        entity.property("medicineDosage", 7).id(10, 4316032610691863633L).flags(2);
        entity.property("isPreset", 1).id(11, 9062615321823156235L);
        entity.property("expandList", 9).id(26, 310492549741306083L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityMedicineSysPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("MedicineSysPresetEntity");
        entity.id(16, 230598812869108449L).lastPropertyId(16, 4456804601835513204L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 839305702948064662L).flags(1);
        entity.property("name", 9).id(5, 8765549828509710499L).flags(2048).indexId(75, 169785436486606814L);
        entity.property("userId", 9).id(11, 2073865280257856352L);
        entity.property("deleteFlag", 5).id(15, 1393224545434078483L);
        entity.property("language", 9).id(14, 8053719901033127369L).flags(2048).indexId(97, 2095225766448713251L);
        entity.property("categoryName", 9).id(7, 2891241756080242261L);
        entity.property("tradeName", 9).id(8, 6400993133879425859L);
        entity.property("manufacturer", 9).id(9, 6037311673920469566L);
        entity.property("englishName", 9).id(10, 4981825404314015423L);
        entity.property("medicationSysPresetId", 6).id(13, 7030868982667396259L).flags(2);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(16, 4456804601835513204L);
        entity.entityDone();
    }

    private static void buildEntityMedicineUsrPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("MedicineUsrPresetEntity");
        entity.id(17, 1441456769400823407L).lastPropertyId(16, 6676729039775413938L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 817769302369218230L).flags(1);
        entity.property("name", 9).id(5, 7426010963327179133L).flags(2048).indexId(77, 6632668292008092872L);
        entity.property("userId", 9).id(11, 1497282247011293548L);
        entity.property("deleteFlag", 5).id(16, 6676729039775413938L);
        entity.property("language", 9).id(15, 1238492539191019300L).flags(2048).indexId(98, 3978217519159262566L);
        entity.property("categoryName", 9).id(7, 7714245760792645244L);
        entity.property("tradeName", 9).id(8, 138041281995540151L);
        entity.property("manufacturer", 9).id(9, 2953046330987811843L);
        entity.property("englishName", 9).id(10, 2594749615362945206L);
        entity.property("medicationUserPresetId", 9).id(13, 7137682077166508805L);
        entity.property("autoIncrementColumn", 6).id(14, 8425128931409802492L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityOtaResourceEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("OtaResourceEntity");
        entity.id(30, 6130100184537646788L).lastPropertyId(12, 5200835398403155045L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 5310528507134035564L).flags(3);
        entity.property("settingTypeVersionKey", 9).id(11, 219695282878191835L).flags(34848).indexId(129, 3847843898767660996L);
        entity.property("settingVersion", 9).id(9, 7145704980757765234L);
        entity.property("localFilePath", 9).id(12, 5200835398403155045L);
        entity.property("settingContent", 9).id(10, 5474766477368570404L);
        entity.property("sha256", 9).id(2, 5193579335838948614L);
        entity.property("ossFileUrl", 9).id(3, 4471653122554534804L);
        entity.property("settingType", 9).id(4, 1706474762458354929L);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(5, 6712048282125172647L);
        entity.property("fileType", 5).id(6, 5953040550399082910L).flags(2);
        entity.property("md5", 9).id(7, 4934052691990838880L);
        entity.property("aidexVersion", 9).id(8, 6029145497773373629L);
        entity.entityDone();
    }

    private static void buildEntityOthersEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("OthersEntity");
        entity.id(8, 5959231583720793488L).lastPropertyId(24, 4134622984481010725L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 231634116288283183L).flags(131);
        entity.property("state", 5).id(2, 6639692005171542944L).flags(8).indexId(25, 643221337065915852L);
        entity.property("id", 9).id(3, 5378724771458021647L);
        entity.property("userId", 9).id(14, 8373353369990769081L).flags(2048).indexId(51, 9130098604746787676L);
        entity.property("recordIndex", 6).id(4, 8472596890987941037L).flags(10).indexId(26, 1973341430569902265L);
        entity.property("appCreateTime", 10).id(23, 3331623087478432305L);
        entity.property("recordId", 9).id(7, 4800271423632820088L);
        entity.property("deleteStatus", 5).id(5, 8220772618017366296L).flags(8).indexId(27, 9021707043073863426L);
        entity.property("language", 9).id(12, 662835533929687718L);
        entity.property("uploadState", 5).id(13, 3366882856164866860L);
        entity.property("autoIncrementColumn", 6).id(20, 5834180895063576346L).flags(10).indexId(87, 4023905306640191364L);
        entity.property("timestamp", 6).id(16, 4760127723403330413L).flags(8).indexId(113, 3756416356878977837L);
        entity.property("moment", 5).id(22, 3420216362314518723L);
        entity.property("appTime", 9).id(17, 2357242151231560913L).flags(2048).indexId(138, 256934770337281580L);
        entity.property("appTimeZone", 9).id(18, 5736585505090992667L);
        entity.property("dstOffset", 9).id(19, 1759697923625793047L);
        entity.property("otherId", 9).id(21, 1329983598866059621L).flags(2048).indexId(106, 5132997832980388387L);
        entity.property("content", 9).id(9, 4610017212778107812L);
        entity.property("deleteFlag", 5).id(10, 3864163103650362356L).flags(2);
        entity.entityDone();
    }

    private static void buildEntityRealCgmHistoryEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("RealCgmHistoryEntity");
        entity.id(9, 1281865382070029411L).lastPropertyId(65, 4983760692756039307L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 7774340849224291465L).flags(131);
        entity.property("state", 5).id(2, 759784193136900331L).flags(8).indexId(30, 8485324655691349027L);
        entity.property("id", 9).id(3, 3920934502885595785L);
        entity.property("userId", 9).id(33, 3157319850465245279L).flags(2048).indexId(46, 2325138591350480946L);
        entity.property("recordIndex", 6).id(9, 4707153166140360029L).flags(10).indexId(36, 4950328117420779418L);
        entity.property("appCreateTime", 10).id(64, 2247162095092178624L);
        entity.property("recordId", 9).id(20, 6607829920651423365L);
        entity.property("deleteStatus", 5).id(10, 8559857442734129906L).flags(8).indexId(37, 362770565879664664L);
        entity.property("language", 9).id(62, 7577912289732818909L);
        entity.property("uploadState", 5).id(54, 6472260824571677571L);
        entity.property("autoIncrementColumn", 6).id(44, 7950856483469054349L).flags(10).indexId(88, 1249643392544483985L);
        entity.property("timestamp", 6).id(59, 4901062422866883723L).flags(8).indexId(BuildConfig.VERSION_CODE, 7463630457957761413L);
        entity.property("moment", 5).id(63, 8685576284229221316L);
        entity.property("appTime", 9).id(56, 4198519154773990451L).flags(2048).indexId(139, 4381851029577242793L);
        entity.property("appTimeZone", 9).id(57, 1031989466292031523L);
        entity.property("dstOffset", 9).id(58, 2419817678544761057L);
        entity.property("briefUploadState", 5).id(51, 5051581535612258853L);
        entity.property("rawUploadState", 5).id(52, 5554561454357975629L);
        entity.property("deviceSn", 9).id(4, 2955604200161958004L).flags(2048).indexId(31, 7707040477477461448L);
        entity.property("cgmRecordId", 9).id(31, 3740232419888884820L);
        entity.property("sensorId", 9).id(32, 319124425573520711L).flags(2048).indexId(45, 620130620315634431L);
        entity.property("deviceTime", 10).id(5, 9020526704142927652L).flags(8).indexId(32, 5138778630921901380L);
        entity.property("eventIndex", 5).id(6, 6412397568069288907L).flags(8).indexId(33, 5096082798764056690L);
        entity.property("sensorIndex", 5).id(7, 4267778144084067517L).flags(8).indexId(34, 152048962967062282L);
        entity.property("dataStatus", 5).id(8, 2922009898687648972L).flags(8).indexId(35, 4163367501650236207L);
        entity.property("eventType", 5).id(11, 4288764375733271922L).flags(2);
        entity.property("glucose", 7).id(34, 7076026704345347581L).flags(2);
        entity.property("eventDataOrigin", 7).id(35, 7687806530581750913L).flags(2);
        entity.property("rawIsValid", 5).id(40, 3778842531090069005L).flags(2);
        entity.property("glucoseIsValid", 5).id(41, 1870335223406484129L).flags(8).indexId(119, 112320457527936412L);
        entity.property("quality", 5).id(42, 2678688041167224115L);
        entity.property(NotificationCompat.CATEGORY_STATUS, 5).id(43, 436723832342262560L);
        entity.property("timeOffset", 5).id(45, 1809539983538925164L);
        entity.property("rawOne", 7).id(46, 7824999053193971088L).flags(2);
        entity.property("rawTwo", 7).id(47, 2840457384809138529L).flags(2);
        entity.property("rawVc", 7).id(48, 450906255681858780L).flags(2);
        entity.property("eventWarning", 5).id(16, 5492023250716114192L).flags(8).indexId(38, 7693357691308798086L);
        entity.property("referenceGlucose", 7).id(49, 3293109521467586739L);
        entity.property("deviceId", 9).id(17, 7272628096749465202L).flags(2048).indexId(39, 7337063607250533803L);
        entity.property(TransmitterActivityKt.OPERATION_TYPE, 5).id(18, 8349849253754277399L);
        entity.property("frontRecordId", 9).id(50, 1546768995711315395L).flags(34848).indexId(44, 867163585421651598L);
        entity.property("rawData1", 7).id(22, 8325123352433713637L).flags(2);
        entity.property("rawData2", 7).id(23, 174029453286223787L).flags(2);
        entity.property("rawData3", 7).id(24, 5031932398040525536L).flags(2);
        entity.property("rawData4", 7).id(25, 4043029889373613776L).flags(2);
        entity.property("rawData5", 7).id(26, 82357702018128834L).flags(2);
        entity.property("rawData6", 7).id(27, 8629793627484526073L).flags(2);
        entity.property("rawData7", 7).id(28, 5204009571890846237L).flags(2);
        entity.property("rawData8", 7).id(29, 7437656456032274069L).flags(2);
        entity.property("rawData9", 7).id(30, 8301117392026408993L).flags(2);
        entity.entityDone();
    }

    private static void buildEntitySportSysPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("SportSysPresetEntity");
        entity.id(18, 2888979766327085758L).lastPropertyId(14, 5530150273781876835L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 7702178776425526634L).flags(1);
        entity.property("name", 9).id(5, 8437957016839740109L).flags(2048).indexId(79, 1898940898161365580L);
        entity.property("userId", 9).id(9, 5399662144516503536L);
        entity.property("deleteFlag", 5).id(13, 3481368993643283185L);
        entity.property("language", 9).id(12, 5521060030922100843L).flags(2048).indexId(99, 4702949799930030537L);
        entity.property("intensityCategoryName", 9).id(7, 928408589993260957L);
        entity.property("hourKcalPerKg", 8).id(8, 5596235481741252461L);
        entity.property("exerciseSysPresetId", 6).id(11, 8842553304781019871L).flags(2);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(14, 5530150273781876835L);
        entity.entityDone();
    }

    private static void buildEntitySportUsrPresetEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("SportUsrPresetEntity");
        entity.id(19, 3093376186392196830L).lastPropertyId(14, 2658315098652742920L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 3772716870092767007L).flags(1);
        entity.property("name", 9).id(5, 7657679776839343684L).flags(2048).indexId(81, 6864984910230962352L);
        entity.property("userId", 9).id(9, 6393009847902179323L);
        entity.property("deleteFlag", 5).id(14, 2658315098652742920L);
        entity.property("language", 9).id(13, 3700202965636030854L).flags(2048).indexId(100, 6955336751651290164L);
        entity.property("intensityCategoryName", 9).id(7, 173822806302238268L);
        entity.property("hourKcalPerKg", 8).id(8, 7939084480900066824L);
        entity.property("autoIncrementColumn", 6).id(11, 7579753999505436216L).flags(2);
        entity.property("exerciseUserPresetId", 9).id(12, 889655440191268397L);
        entity.entityDone();
    }

    private static void buildEntityTimezoneHistoryEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("TimezoneHistoryEntity");
        entity.id(31, 1455564533730082879L).lastPropertyId(11, 50875933265720959L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 7348849818499267593L).flags(131);
        entity.property(TypedValues.TransitionType.S_FROM, 9).id(2, 604415115628132006L);
        entity.property(TypedValues.TransitionType.S_TO, 9).id(3, 655712953328421698L);
        entity.property("dstOffset", 5).id(11, 50875933265720959L);
        entity.property("isDstChange", 1).id(9, 7193876998338060349L);
        entity.property("userId", 9).id(4, 5368796658826425248L);
        entity.property("sensorId", 9).id(5, 411826166043720767L).flags(2048).indexId(130, 6337986629171057978L);
        entity.property("timestamp", 6).id(6, 7925292495922177467L);
        entity.property("uploadState", 5).id(7, 1176062672786567330L);
        entity.property("frontRecordId", 9).id(8, 2542650683199434025L).flags(34848).indexId(131, 4564494180574930872L);
        entity.entityDone();
    }

    private static void buildEntityTransmitterEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("TransmitterEntity");
        entity.id(10, 8312283434910987553L).lastPropertyId(24, 970446492065537772L);
        entity.flags(1);
        entity.property("calIndex", 5).id(1, 8852676303101427946L);
        entity.property("idx", 6).id(2, 1907463493222633610L).flags(131);
        entity.property("id", 9).id(3, 2516137005189196136L);
        entity.property("deviceMac", 9).id(4, 6607004478044637294L).flags(34848).indexId(42, 76693503561160768L);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(5, 6702598845206826687L);
        entity.property("deviceSn", 9).id(6, 1471188205402179479L);
        entity.property("accessId", 23).id(7, 194088174213386239L);
        entity.property("encryptionKey", 23).id(8, 1523611623514261594L);
        entity.property("sensorStartTime", 10).id(9, 2773119542604221667L);
        entity.property("needReplace", 1).id(10, 4003024307704102405L);
        entity.property("deviceModel", 5).id(11, 7947785106983963470L);
        entity.property("modelName", 9).id(24, 970446492065537772L);
        entity.property("expirationTime", 5).id(12, 9116867184336820837L);
        entity.property("sensorIndex", 5).id(13, 1143447042418773117L);
        entity.property("eventIndex", 5).id(14, 8455553075089098734L);
        entity.property("fullEventIndex", 5).id(15, 231536206505450851L);
        entity.property("fullSensorIndex", 5).id(16, 971575884460700567L);
        entity.property("hyperThreshold", 7).id(17, 2722609664653320609L);
        entity.property("hypoThreshold", 7).id(18, 3542885398649950966L);
        entity.property("deviceKey", 9).id(19, 8908744047534069421L);
        entity.property("et", 5).id(20, 8542043355854019709L);
        entity.property("deviceName", 9).id(21, 3086046395037033013L);
        entity.property("deviceType", 5).id(22, 1955193999848926154L);
        entity.property("sensorId", 9).id(23, 1578053285249837212L).flags(2048).indexId(55, 6222054459191935891L);
        entity.entityDone();
    }

    private static void buildEntityUnitEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("UnitEntity");
        entity.id(24, 3159698116653616097L).lastPropertyId(12, 7042769886058225672L);
        entity.property("id", 6).id(1, 5505896521975402768L).flags(1);
        entity.property("eventType", 5).id(10, 8958925414707893062L);
        entity.property("value", 5).id(11, 5384264172867784614L);
        entity.property("isDefault", 5).id(3, 509787977203700025L);
        entity.property("language", 9).id(5, 6712105696579830370L);
        entity.property("name", 9).id(7, 8176928836060804735L);
        entity.property("ratio", 8).id(8, 366203480795099449L);
        entity.property(WiseOpenHianalyticsData.UNION_VERSION, 9).id(12, 7042769886058225672L);
        entity.entityDone();
    }

    private static void buildEntityUserEntity(ModelBuilder modelBuilder) {
        ModelBuilder.EntityBuilder entity = modelBuilder.entity("UserEntity");
        entity.id(11, 7133388229107183159L).lastPropertyId(35, 4236125472347666459L);
        entity.flags(1);
        entity.property("idx", 6).id(1, 1666002627097307908L).flags(1);
        entity.property("userId", 9).id(8, 1517671189220769977L).flags(2080).indexId(118, 2288979470787846953L);
        entity.property("isGuideStateChange", 1).id(34, 7673937021244147597L);
        entity.property("isGuide", 5).id(24, 7811559704107918424L);
        entity.property("isUnitGuide", 5).id(35, 4236125472347666459L);
        entity.property("userInformationId", 9).id(9, 493770869486567421L);
        entity.property(NotificationCompat.CATEGORY_EMAIL, 9).id(10, 6487268747576107762L);
        entity.property("phone", 9).id(11, 7668265505944492156L);
        entity.property("avatar", 9).id(7, 1175741528005477122L);
        entity.property("name", 9).id(12, 8966641974021389281L);
        entity.property("fullName", 9).id(23, 8508036505796957717L);
        entity.property("gender", 5).id(16, 7108538480967286139L).flags(2);
        entity.property("birthDate", 9).id(17, 3891904480099121663L);
        entity.property("height", 5).id(18, 3554707240316205937L).flags(2);
        entity.property("bodyWeight", 5).id(19, 9032122393512847112L).flags(2);
        entity.property("diabetesType", 5).id(20, 7363912060902012851L).flags(2);
        entity.property("diabetesTypeValue", 5).id(25, 8026177937734306413L).flags(2);
        entity.property("diabetesTypeDisplayName", 9).id(26, 6128050955277925703L);
        entity.property("diagnosisDate", 9).id(21, 9115505945995373086L);
        entity.property("complications", 9).id(22, 4940100248988904699L);
        entity.property("complicationsDisplayName", 9).id(27, 8492580463863658576L);
        entity.property("treatment", 9).id(28, 7214060536858517355L);
        entity.property("treatmentDisplayName", 9).id(29, 4402322136027280519L);
        entity.property("otherDiseases", 9).id(30, 7814100922489500499L);
        entity.property("otherDiseasesDisplayName", 9).id(31, 279352964062908935L);
        entity.property("isSettedPassword", 5).id(33, 974857832630925223L);
        entity.entityDone();
    }
}
