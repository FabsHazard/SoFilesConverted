package com.huawei.hms.scankit.p;

import androidx.core.location.LocationRequestCompat;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Code128Reader */
public final class r0 extends g5 {
    public static final int[][] a;

    static {
        int[] iArr = new int[6];
        int[] iArr2 = iArr;
        // fill-array-data instruction
        iArr[0] = 2;
        iArr[1] = 1;
        iArr[2] = 2;
        iArr[3] = 2;
        iArr[4] = 2;
        iArr[5] = 2;
        int[] iArr3 = new int[6];
        int[] iArr4 = iArr3;
        // fill-array-data instruction
        iArr3[0] = 2;
        iArr3[1] = 2;
        iArr3[2] = 2;
        iArr3[3] = 1;
        iArr3[4] = 2;
        iArr3[5] = 2;
        int[] iArr5 = new int[6];
        int[] iArr6 = iArr5;
        // fill-array-data instruction
        iArr5[0] = 2;
        iArr5[1] = 2;
        iArr5[2] = 2;
        iArr5[3] = 2;
        iArr5[4] = 2;
        iArr5[5] = 1;
        int[] iArr7 = new int[6];
        int[] iArr8 = iArr7;
        // fill-array-data instruction
        iArr7[0] = 1;
        iArr7[1] = 2;
        iArr7[2] = 1;
        iArr7[3] = 2;
        iArr7[4] = 2;
        iArr7[5] = 3;
        int[] iArr9 = new int[6];
        int[] iArr10 = iArr9;
        // fill-array-data instruction
        iArr9[0] = 1;
        iArr9[1] = 2;
        iArr9[2] = 1;
        iArr9[3] = 3;
        iArr9[4] = 2;
        iArr9[5] = 2;
        int[] iArr11 = new int[6];
        int[] iArr12 = iArr11;
        // fill-array-data instruction
        iArr11[0] = 1;
        iArr11[1] = 3;
        iArr11[2] = 1;
        iArr11[3] = 2;
        iArr11[4] = 2;
        iArr11[5] = 2;
        int[] iArr13 = new int[6];
        int[] iArr14 = iArr13;
        // fill-array-data instruction
        iArr13[0] = 1;
        iArr13[1] = 2;
        iArr13[2] = 2;
        iArr13[3] = 2;
        iArr13[4] = 1;
        iArr13[5] = 3;
        int[] iArr15 = new int[6];
        int[] iArr16 = iArr15;
        // fill-array-data instruction
        iArr15[0] = 1;
        iArr15[1] = 2;
        iArr15[2] = 2;
        iArr15[3] = 3;
        iArr15[4] = 1;
        iArr15[5] = 2;
        int[] iArr17 = new int[6];
        int[] iArr18 = iArr17;
        // fill-array-data instruction
        iArr17[0] = 1;
        iArr17[1] = 3;
        iArr17[2] = 2;
        iArr17[3] = 2;
        iArr17[4] = 1;
        iArr17[5] = 2;
        int[] iArr19 = new int[6];
        int[] iArr20 = iArr19;
        // fill-array-data instruction
        iArr19[0] = 2;
        iArr19[1] = 2;
        iArr19[2] = 1;
        iArr19[3] = 2;
        iArr19[4] = 1;
        iArr19[5] = 3;
        int[] iArr21 = new int[6];
        int[] iArr22 = iArr21;
        // fill-array-data instruction
        iArr21[0] = 2;
        iArr21[1] = 2;
        iArr21[2] = 1;
        iArr21[3] = 3;
        iArr21[4] = 1;
        iArr21[5] = 2;
        int[] iArr23 = new int[6];
        int[] iArr24 = iArr23;
        // fill-array-data instruction
        iArr23[0] = 2;
        iArr23[1] = 3;
        iArr23[2] = 1;
        iArr23[3] = 2;
        iArr23[4] = 1;
        iArr23[5] = 2;
        int[] iArr25 = new int[6];
        int[] iArr26 = iArr25;
        // fill-array-data instruction
        iArr25[0] = 1;
        iArr25[1] = 1;
        iArr25[2] = 2;
        iArr25[3] = 2;
        iArr25[4] = 3;
        iArr25[5] = 2;
        int[] iArr27 = new int[6];
        int[] iArr28 = iArr27;
        // fill-array-data instruction
        iArr27[0] = 1;
        iArr27[1] = 2;
        iArr27[2] = 2;
        iArr27[3] = 1;
        iArr27[4] = 3;
        iArr27[5] = 2;
        int[] iArr29 = new int[6];
        // fill-array-data instruction
        iArr29[0] = 1;
        iArr29[1] = 2;
        iArr29[2] = 2;
        iArr29[3] = 2;
        iArr29[4] = 3;
        iArr29[5] = 1;
        int[] iArr30 = iArr2;
        int[] iArr31 = new int[6];
        int[] iArr32 = iArr31;
        // fill-array-data instruction
        iArr31[0] = 1;
        iArr31[1] = 1;
        iArr31[2] = 3;
        iArr31[3] = 2;
        iArr31[4] = 2;
        iArr31[5] = 2;
        int[] iArr33 = new int[6];
        int[] iArr34 = iArr33;
        // fill-array-data instruction
        iArr33[0] = 1;
        iArr33[1] = 2;
        iArr33[2] = 3;
        iArr33[3] = 1;
        iArr33[4] = 2;
        iArr33[5] = 2;
        int[] iArr35 = new int[6];
        int[] iArr36 = iArr35;
        // fill-array-data instruction
        iArr35[0] = 1;
        iArr35[1] = 2;
        iArr35[2] = 3;
        iArr35[3] = 2;
        iArr35[4] = 2;
        iArr35[5] = 1;
        int[] iArr37 = new int[6];
        int[] iArr38 = iArr37;
        // fill-array-data instruction
        iArr37[0] = 2;
        iArr37[1] = 2;
        iArr37[2] = 3;
        iArr37[3] = 2;
        iArr37[4] = 1;
        iArr37[5] = 1;
        int[] iArr39 = new int[6];
        int[] iArr40 = iArr39;
        // fill-array-data instruction
        iArr39[0] = 2;
        iArr39[1] = 2;
        iArr39[2] = 1;
        iArr39[3] = 1;
        iArr39[4] = 3;
        iArr39[5] = 2;
        int[] iArr41 = new int[6];
        int[] iArr42 = iArr41;
        // fill-array-data instruction
        iArr41[0] = 2;
        iArr41[1] = 2;
        iArr41[2] = 1;
        iArr41[3] = 2;
        iArr41[4] = 3;
        iArr41[5] = 1;
        int[] iArr43 = new int[6];
        int[] iArr44 = iArr43;
        // fill-array-data instruction
        iArr43[0] = 2;
        iArr43[1] = 1;
        iArr43[2] = 3;
        iArr43[3] = 2;
        iArr43[4] = 1;
        iArr43[5] = 2;
        int[] iArr45 = new int[6];
        int[] iArr46 = iArr45;
        // fill-array-data instruction
        iArr45[0] = 2;
        iArr45[1] = 2;
        iArr45[2] = 3;
        iArr45[3] = 1;
        iArr45[4] = 1;
        iArr45[5] = 2;
        int[] iArr47 = new int[6];
        int[] iArr48 = iArr47;
        // fill-array-data instruction
        iArr47[0] = 3;
        iArr47[1] = 1;
        iArr47[2] = 2;
        iArr47[3] = 1;
        iArr47[4] = 3;
        iArr47[5] = 1;
        int[] iArr49 = new int[6];
        int[] iArr50 = iArr49;
        // fill-array-data instruction
        iArr49[0] = 3;
        iArr49[1] = 1;
        iArr49[2] = 1;
        iArr49[3] = 2;
        iArr49[4] = 2;
        iArr49[5] = 2;
        int[] iArr51 = new int[6];
        int[] iArr52 = iArr51;
        // fill-array-data instruction
        iArr51[0] = 3;
        iArr51[1] = 2;
        iArr51[2] = 1;
        iArr51[3] = 1;
        iArr51[4] = 2;
        iArr51[5] = 2;
        int[] iArr53 = new int[6];
        int[] iArr54 = iArr53;
        // fill-array-data instruction
        iArr53[0] = 3;
        iArr53[1] = 2;
        iArr53[2] = 1;
        iArr53[3] = 2;
        iArr53[4] = 2;
        iArr53[5] = 1;
        int[] iArr55 = new int[6];
        int[] iArr56 = iArr55;
        // fill-array-data instruction
        iArr55[0] = 3;
        iArr55[1] = 1;
        iArr55[2] = 2;
        iArr55[3] = 2;
        iArr55[4] = 1;
        iArr55[5] = 2;
        int[] iArr57 = new int[6];
        int[] iArr58 = iArr57;
        // fill-array-data instruction
        iArr57[0] = 3;
        iArr57[1] = 2;
        iArr57[2] = 2;
        iArr57[3] = 1;
        iArr57[4] = 1;
        iArr57[5] = 2;
        int[] iArr59 = new int[6];
        int[] iArr60 = iArr59;
        // fill-array-data instruction
        iArr59[0] = 3;
        iArr59[1] = 2;
        iArr59[2] = 2;
        iArr59[3] = 2;
        iArr59[4] = 1;
        iArr59[5] = 1;
        int[] iArr61 = new int[6];
        int[] iArr62 = iArr61;
        // fill-array-data instruction
        iArr61[0] = 2;
        iArr61[1] = 1;
        iArr61[2] = 2;
        iArr61[3] = 1;
        iArr61[4] = 2;
        iArr61[5] = 3;
        int[] iArr63 = new int[6];
        int[] iArr64 = iArr63;
        // fill-array-data instruction
        iArr63[0] = 2;
        iArr63[1] = 1;
        iArr63[2] = 2;
        iArr63[3] = 3;
        iArr63[4] = 2;
        iArr63[5] = 1;
        int[] iArr65 = new int[6];
        int[] iArr66 = iArr65;
        // fill-array-data instruction
        iArr65[0] = 2;
        iArr65[1] = 3;
        iArr65[2] = 2;
        iArr65[3] = 1;
        iArr65[4] = 2;
        iArr65[5] = 1;
        int[] iArr67 = new int[6];
        int[] iArr68 = iArr67;
        // fill-array-data instruction
        iArr67[0] = 1;
        iArr67[1] = 1;
        iArr67[2] = 1;
        iArr67[3] = 3;
        iArr67[4] = 2;
        iArr67[5] = 3;
        int[] iArr69 = new int[6];
        int[] iArr70 = iArr69;
        // fill-array-data instruction
        iArr69[0] = 1;
        iArr69[1] = 3;
        iArr69[2] = 1;
        iArr69[3] = 1;
        iArr69[4] = 2;
        iArr69[5] = 3;
        int[] iArr71 = new int[6];
        int[] iArr72 = iArr71;
        // fill-array-data instruction
        iArr71[0] = 1;
        iArr71[1] = 3;
        iArr71[2] = 1;
        iArr71[3] = 3;
        iArr71[4] = 2;
        iArr71[5] = 1;
        int[] iArr73 = new int[6];
        int[] iArr74 = iArr73;
        // fill-array-data instruction
        iArr73[0] = 1;
        iArr73[1] = 1;
        iArr73[2] = 2;
        iArr73[3] = 3;
        iArr73[4] = 1;
        iArr73[5] = 3;
        int[] iArr75 = new int[6];
        int[] iArr76 = iArr75;
        // fill-array-data instruction
        iArr75[0] = 1;
        iArr75[1] = 3;
        iArr75[2] = 2;
        iArr75[3] = 1;
        iArr75[4] = 1;
        iArr75[5] = 3;
        int[] iArr77 = new int[6];
        int[] iArr78 = iArr77;
        // fill-array-data instruction
        iArr77[0] = 1;
        iArr77[1] = 3;
        iArr77[2] = 2;
        iArr77[3] = 3;
        iArr77[4] = 1;
        iArr77[5] = 1;
        int[] iArr79 = new int[6];
        int[] iArr80 = iArr79;
        // fill-array-data instruction
        iArr79[0] = 2;
        iArr79[1] = 1;
        iArr79[2] = 1;
        iArr79[3] = 3;
        iArr79[4] = 1;
        iArr79[5] = 3;
        int[] iArr81 = new int[6];
        int[] iArr82 = iArr81;
        // fill-array-data instruction
        iArr81[0] = 2;
        iArr81[1] = 3;
        iArr81[2] = 1;
        iArr81[3] = 1;
        iArr81[4] = 1;
        iArr81[5] = 3;
        int[] iArr83 = new int[6];
        int[] iArr84 = iArr83;
        // fill-array-data instruction
        iArr83[0] = 2;
        iArr83[1] = 3;
        iArr83[2] = 1;
        iArr83[3] = 3;
        iArr83[4] = 1;
        iArr83[5] = 1;
        int[] iArr85 = new int[6];
        int[] iArr86 = iArr85;
        // fill-array-data instruction
        iArr85[0] = 1;
        iArr85[1] = 1;
        iArr85[2] = 2;
        iArr85[3] = 1;
        iArr85[4] = 3;
        iArr85[5] = 3;
        int[] iArr87 = new int[6];
        int[] iArr88 = iArr87;
        // fill-array-data instruction
        iArr87[0] = 1;
        iArr87[1] = 1;
        iArr87[2] = 2;
        iArr87[3] = 3;
        iArr87[4] = 3;
        iArr87[5] = 1;
        int[] iArr89 = new int[6];
        int[] iArr90 = iArr89;
        // fill-array-data instruction
        iArr89[0] = 1;
        iArr89[1] = 3;
        iArr89[2] = 2;
        iArr89[3] = 1;
        iArr89[4] = 3;
        iArr89[5] = 1;
        int[] iArr91 = new int[6];
        int[] iArr92 = iArr91;
        // fill-array-data instruction
        iArr91[0] = 1;
        iArr91[1] = 1;
        iArr91[2] = 3;
        iArr91[3] = 1;
        iArr91[4] = 2;
        iArr91[5] = 3;
        int[] iArr93 = new int[6];
        int[] iArr94 = iArr93;
        // fill-array-data instruction
        iArr93[0] = 1;
        iArr93[1] = 1;
        iArr93[2] = 3;
        iArr93[3] = 3;
        iArr93[4] = 2;
        iArr93[5] = 1;
        int[] iArr95 = new int[6];
        int[] iArr96 = iArr95;
        // fill-array-data instruction
        iArr95[0] = 1;
        iArr95[1] = 3;
        iArr95[2] = 3;
        iArr95[3] = 1;
        iArr95[4] = 2;
        iArr95[5] = 1;
        int[] iArr97 = new int[6];
        int[] iArr98 = iArr97;
        // fill-array-data instruction
        iArr97[0] = 3;
        iArr97[1] = 1;
        iArr97[2] = 3;
        iArr97[3] = 1;
        iArr97[4] = 2;
        iArr97[5] = 1;
        int[] iArr99 = new int[6];
        int[] iArr100 = iArr99;
        // fill-array-data instruction
        iArr99[0] = 2;
        iArr99[1] = 1;
        iArr99[2] = 1;
        iArr99[3] = 3;
        iArr99[4] = 3;
        iArr99[5] = 1;
        int[] iArr101 = new int[6];
        int[] iArr102 = iArr101;
        // fill-array-data instruction
        iArr101[0] = 2;
        iArr101[1] = 3;
        iArr101[2] = 1;
        iArr101[3] = 1;
        iArr101[4] = 3;
        iArr101[5] = 1;
        int[] iArr103 = new int[6];
        int[] iArr104 = iArr103;
        // fill-array-data instruction
        iArr103[0] = 2;
        iArr103[1] = 1;
        iArr103[2] = 3;
        iArr103[3] = 1;
        iArr103[4] = 1;
        iArr103[5] = 3;
        int[] iArr105 = new int[6];
        int[] iArr106 = iArr105;
        // fill-array-data instruction
        iArr105[0] = 2;
        iArr105[1] = 1;
        iArr105[2] = 3;
        iArr105[3] = 3;
        iArr105[4] = 1;
        iArr105[5] = 1;
        int[] iArr107 = new int[6];
        int[] iArr108 = iArr107;
        // fill-array-data instruction
        iArr107[0] = 2;
        iArr107[1] = 1;
        iArr107[2] = 3;
        iArr107[3] = 1;
        iArr107[4] = 3;
        iArr107[5] = 1;
        int[] iArr109 = new int[6];
        int[] iArr110 = iArr109;
        // fill-array-data instruction
        iArr109[0] = 3;
        iArr109[1] = 1;
        iArr109[2] = 1;
        iArr109[3] = 1;
        iArr109[4] = 2;
        iArr109[5] = 3;
        int[] iArr111 = new int[6];
        int[] iArr112 = iArr111;
        // fill-array-data instruction
        iArr111[0] = 3;
        iArr111[1] = 1;
        iArr111[2] = 1;
        iArr111[3] = 3;
        iArr111[4] = 2;
        iArr111[5] = 1;
        int[] iArr113 = new int[6];
        int[] iArr114 = iArr113;
        // fill-array-data instruction
        iArr113[0] = 3;
        iArr113[1] = 3;
        iArr113[2] = 1;
        iArr113[3] = 1;
        iArr113[4] = 2;
        iArr113[5] = 1;
        int[] iArr115 = new int[6];
        int[] iArr116 = iArr115;
        // fill-array-data instruction
        iArr115[0] = 3;
        iArr115[1] = 1;
        iArr115[2] = 2;
        iArr115[3] = 1;
        iArr115[4] = 1;
        iArr115[5] = 3;
        int[] iArr117 = new int[6];
        int[] iArr118 = iArr117;
        // fill-array-data instruction
        iArr117[0] = 3;
        iArr117[1] = 1;
        iArr117[2] = 2;
        iArr117[3] = 3;
        iArr117[4] = 1;
        iArr117[5] = 1;
        int[] iArr119 = new int[6];
        int[] iArr120 = iArr119;
        // fill-array-data instruction
        iArr119[0] = 3;
        iArr119[1] = 3;
        iArr119[2] = 2;
        iArr119[3] = 1;
        iArr119[4] = 1;
        iArr119[5] = 1;
        int[] iArr121 = new int[6];
        int[] iArr122 = iArr121;
        // fill-array-data instruction
        iArr121[0] = 3;
        iArr121[1] = 1;
        iArr121[2] = 4;
        iArr121[3] = 1;
        iArr121[4] = 1;
        iArr121[5] = 1;
        int[] iArr123 = new int[6];
        int[] iArr124 = iArr123;
        // fill-array-data instruction
        iArr123[0] = 2;
        iArr123[1] = 2;
        iArr123[2] = 1;
        iArr123[3] = 4;
        iArr123[4] = 1;
        iArr123[5] = 1;
        int[] iArr125 = new int[6];
        int[] iArr126 = iArr125;
        // fill-array-data instruction
        iArr125[0] = 4;
        iArr125[1] = 3;
        iArr125[2] = 1;
        iArr125[3] = 1;
        iArr125[4] = 1;
        iArr125[5] = 1;
        int[] iArr127 = new int[6];
        int[] iArr128 = iArr127;
        // fill-array-data instruction
        iArr127[0] = 1;
        iArr127[1] = 1;
        iArr127[2] = 1;
        iArr127[3] = 2;
        iArr127[4] = 2;
        iArr127[5] = 4;
        int[] iArr129 = new int[6];
        int[] iArr130 = iArr129;
        // fill-array-data instruction
        iArr129[0] = 1;
        iArr129[1] = 1;
        iArr129[2] = 1;
        iArr129[3] = 4;
        iArr129[4] = 2;
        iArr129[5] = 2;
        int[] iArr131 = new int[6];
        int[] iArr132 = iArr131;
        // fill-array-data instruction
        iArr131[0] = 1;
        iArr131[1] = 2;
        iArr131[2] = 1;
        iArr131[3] = 1;
        iArr131[4] = 2;
        iArr131[5] = 4;
        int[] iArr133 = new int[6];
        int[] iArr134 = iArr133;
        // fill-array-data instruction
        iArr133[0] = 1;
        iArr133[1] = 2;
        iArr133[2] = 1;
        iArr133[3] = 4;
        iArr133[4] = 2;
        iArr133[5] = 1;
        int[] iArr135 = new int[6];
        int[] iArr136 = iArr135;
        // fill-array-data instruction
        iArr135[0] = 1;
        iArr135[1] = 4;
        iArr135[2] = 1;
        iArr135[3] = 1;
        iArr135[4] = 2;
        iArr135[5] = 2;
        int[] iArr137 = new int[6];
        int[] iArr138 = iArr137;
        // fill-array-data instruction
        iArr137[0] = 1;
        iArr137[1] = 4;
        iArr137[2] = 1;
        iArr137[3] = 2;
        iArr137[4] = 2;
        iArr137[5] = 1;
        int[] iArr139 = new int[6];
        int[] iArr140 = iArr139;
        // fill-array-data instruction
        iArr139[0] = 1;
        iArr139[1] = 1;
        iArr139[2] = 2;
        iArr139[3] = 2;
        iArr139[4] = 1;
        iArr139[5] = 4;
        int[] iArr141 = new int[6];
        int[] iArr142 = iArr141;
        // fill-array-data instruction
        iArr141[0] = 1;
        iArr141[1] = 1;
        iArr141[2] = 2;
        iArr141[3] = 4;
        iArr141[4] = 1;
        iArr141[5] = 2;
        int[] iArr143 = new int[6];
        int[] iArr144 = iArr143;
        // fill-array-data instruction
        iArr143[0] = 1;
        iArr143[1] = 2;
        iArr143[2] = 2;
        iArr143[3] = 1;
        iArr143[4] = 1;
        iArr143[5] = 4;
        int[] iArr145 = new int[6];
        int[] iArr146 = iArr145;
        // fill-array-data instruction
        iArr145[0] = 1;
        iArr145[1] = 2;
        iArr145[2] = 2;
        iArr145[3] = 4;
        iArr145[4] = 1;
        iArr145[5] = 1;
        int[] iArr147 = new int[6];
        int[] iArr148 = iArr147;
        // fill-array-data instruction
        iArr147[0] = 1;
        iArr147[1] = 4;
        iArr147[2] = 2;
        iArr147[3] = 1;
        iArr147[4] = 1;
        iArr147[5] = 2;
        int[] iArr149 = new int[6];
        int[] iArr150 = iArr149;
        // fill-array-data instruction
        iArr149[0] = 1;
        iArr149[1] = 4;
        iArr149[2] = 2;
        iArr149[3] = 2;
        iArr149[4] = 1;
        iArr149[5] = 1;
        int[] iArr151 = new int[6];
        int[] iArr152 = iArr151;
        // fill-array-data instruction
        iArr151[0] = 2;
        iArr151[1] = 4;
        iArr151[2] = 1;
        iArr151[3] = 2;
        iArr151[4] = 1;
        iArr151[5] = 1;
        int[] iArr153 = new int[6];
        int[] iArr154 = iArr153;
        // fill-array-data instruction
        iArr153[0] = 2;
        iArr153[1] = 2;
        iArr153[2] = 1;
        iArr153[3] = 1;
        iArr153[4] = 1;
        iArr153[5] = 4;
        int[] iArr155 = new int[6];
        int[] iArr156 = iArr155;
        // fill-array-data instruction
        iArr155[0] = 4;
        iArr155[1] = 1;
        iArr155[2] = 3;
        iArr155[3] = 1;
        iArr155[4] = 1;
        iArr155[5] = 1;
        int[] iArr157 = new int[6];
        int[] iArr158 = iArr157;
        // fill-array-data instruction
        iArr157[0] = 2;
        iArr157[1] = 4;
        iArr157[2] = 1;
        iArr157[3] = 1;
        iArr157[4] = 1;
        iArr157[5] = 2;
        int[] iArr159 = new int[6];
        int[] iArr160 = iArr159;
        // fill-array-data instruction
        iArr159[0] = 1;
        iArr159[1] = 3;
        iArr159[2] = 4;
        iArr159[3] = 1;
        iArr159[4] = 1;
        iArr159[5] = 1;
        int[] iArr161 = new int[6];
        int[] iArr162 = iArr161;
        // fill-array-data instruction
        iArr161[0] = 1;
        iArr161[1] = 1;
        iArr161[2] = 1;
        iArr161[3] = 2;
        iArr161[4] = 4;
        iArr161[5] = 2;
        int[] iArr163 = new int[6];
        int[] iArr164 = iArr163;
        // fill-array-data instruction
        iArr163[0] = 1;
        iArr163[1] = 2;
        iArr163[2] = 1;
        iArr163[3] = 1;
        iArr163[4] = 4;
        iArr163[5] = 2;
        int[] iArr165 = new int[6];
        int[] iArr166 = iArr165;
        // fill-array-data instruction
        iArr165[0] = 1;
        iArr165[1] = 2;
        iArr165[2] = 1;
        iArr165[3] = 2;
        iArr165[4] = 4;
        iArr165[5] = 1;
        int[] iArr167 = new int[6];
        int[] iArr168 = iArr167;
        // fill-array-data instruction
        iArr167[0] = 1;
        iArr167[1] = 1;
        iArr167[2] = 4;
        iArr167[3] = 2;
        iArr167[4] = 1;
        iArr167[5] = 2;
        int[] iArr169 = new int[6];
        int[] iArr170 = iArr169;
        // fill-array-data instruction
        iArr169[0] = 1;
        iArr169[1] = 2;
        iArr169[2] = 4;
        iArr169[3] = 1;
        iArr169[4] = 1;
        iArr169[5] = 2;
        int[] iArr171 = new int[6];
        int[] iArr172 = iArr171;
        // fill-array-data instruction
        iArr171[0] = 1;
        iArr171[1] = 2;
        iArr171[2] = 4;
        iArr171[3] = 2;
        iArr171[4] = 1;
        iArr171[5] = 1;
        int[] iArr173 = new int[6];
        int[] iArr174 = iArr173;
        // fill-array-data instruction
        iArr173[0] = 4;
        iArr173[1] = 1;
        iArr173[2] = 1;
        iArr173[3] = 2;
        iArr173[4] = 1;
        iArr173[5] = 2;
        int[] iArr175 = new int[6];
        int[] iArr176 = iArr175;
        // fill-array-data instruction
        iArr175[0] = 4;
        iArr175[1] = 2;
        iArr175[2] = 1;
        iArr175[3] = 1;
        iArr175[4] = 1;
        iArr175[5] = 2;
        int[] iArr177 = new int[6];
        int[] iArr178 = iArr177;
        // fill-array-data instruction
        iArr177[0] = 4;
        iArr177[1] = 2;
        iArr177[2] = 1;
        iArr177[3] = 2;
        iArr177[4] = 1;
        iArr177[5] = 1;
        int[] iArr179 = new int[6];
        int[] iArr180 = iArr179;
        // fill-array-data instruction
        iArr179[0] = 2;
        iArr179[1] = 1;
        iArr179[2] = 2;
        iArr179[3] = 1;
        iArr179[4] = 4;
        iArr179[5] = 1;
        int[] iArr181 = new int[6];
        int[] iArr182 = iArr181;
        // fill-array-data instruction
        iArr181[0] = 2;
        iArr181[1] = 1;
        iArr181[2] = 4;
        iArr181[3] = 1;
        iArr181[4] = 2;
        iArr181[5] = 1;
        int[] iArr183 = new int[6];
        int[] iArr184 = iArr183;
        // fill-array-data instruction
        iArr183[0] = 4;
        iArr183[1] = 1;
        iArr183[2] = 2;
        iArr183[3] = 1;
        iArr183[4] = 2;
        iArr183[5] = 1;
        int[] iArr185 = new int[6];
        int[] iArr186 = iArr185;
        // fill-array-data instruction
        iArr185[0] = 1;
        iArr185[1] = 1;
        iArr185[2] = 1;
        iArr185[3] = 1;
        iArr185[4] = 4;
        iArr185[5] = 3;
        int[] iArr187 = new int[6];
        int[] iArr188 = iArr187;
        // fill-array-data instruction
        iArr187[0] = 1;
        iArr187[1] = 1;
        iArr187[2] = 1;
        iArr187[3] = 3;
        iArr187[4] = 4;
        iArr187[5] = 1;
        int[] iArr189 = new int[6];
        int[] iArr190 = iArr189;
        // fill-array-data instruction
        iArr189[0] = 1;
        iArr189[1] = 3;
        iArr189[2] = 1;
        iArr189[3] = 1;
        iArr189[4] = 4;
        iArr189[5] = 1;
        int[] iArr191 = new int[6];
        int[] iArr192 = iArr191;
        // fill-array-data instruction
        iArr191[0] = 1;
        iArr191[1] = 1;
        iArr191[2] = 4;
        iArr191[3] = 1;
        iArr191[4] = 1;
        iArr191[5] = 3;
        int[] iArr193 = new int[6];
        int[] iArr194 = iArr193;
        // fill-array-data instruction
        iArr193[0] = 1;
        iArr193[1] = 1;
        iArr193[2] = 4;
        iArr193[3] = 3;
        iArr193[4] = 1;
        iArr193[5] = 1;
        int[] iArr195 = new int[6];
        int[] iArr196 = iArr195;
        // fill-array-data instruction
        iArr195[0] = 4;
        iArr195[1] = 1;
        iArr195[2] = 1;
        iArr195[3] = 1;
        iArr195[4] = 1;
        iArr195[5] = 3;
        int[] iArr197 = new int[6];
        int[] iArr198 = iArr197;
        // fill-array-data instruction
        iArr197[0] = 4;
        iArr197[1] = 1;
        iArr197[2] = 1;
        iArr197[3] = 3;
        iArr197[4] = 1;
        iArr197[5] = 1;
        int[] iArr199 = new int[6];
        int[] iArr200 = iArr199;
        // fill-array-data instruction
        iArr199[0] = 1;
        iArr199[1] = 1;
        iArr199[2] = 3;
        iArr199[3] = 1;
        iArr199[4] = 4;
        iArr199[5] = 1;
        int[] iArr201 = new int[6];
        int[] iArr202 = iArr201;
        // fill-array-data instruction
        iArr201[0] = 1;
        iArr201[1] = 1;
        iArr201[2] = 4;
        iArr201[3] = 1;
        iArr201[4] = 3;
        iArr201[5] = 1;
        int[] iArr203 = new int[6];
        int[] iArr204 = iArr203;
        // fill-array-data instruction
        iArr203[0] = 3;
        iArr203[1] = 1;
        iArr203[2] = 1;
        iArr203[3] = 1;
        iArr203[4] = 4;
        iArr203[5] = 1;
        int[] iArr205 = new int[6];
        int[] iArr206 = iArr205;
        // fill-array-data instruction
        iArr205[0] = 4;
        iArr205[1] = 1;
        iArr205[2] = 1;
        iArr205[3] = 1;
        iArr205[4] = 3;
        iArr205[5] = 1;
        int[] iArr207 = new int[6];
        int[] iArr208 = iArr207;
        // fill-array-data instruction
        iArr207[0] = 2;
        iArr207[1] = 1;
        iArr207[2] = 1;
        iArr207[3] = 4;
        iArr207[4] = 1;
        iArr207[5] = 2;
        int[] iArr209 = new int[6];
        // fill-array-data instruction
        iArr209[0] = 2;
        iArr209[1] = 1;
        iArr209[2] = 1;
        iArr209[3] = 2;
        iArr209[4] = 1;
        iArr209[5] = 4;
        int[] iArr210 = new int[6];
        int[] iArr211 = iArr210;
        // fill-array-data instruction
        iArr210[0] = 2;
        iArr210[1] = 1;
        iArr210[2] = 1;
        iArr210[3] = 2;
        iArr210[4] = 3;
        iArr210[5] = 2;
        int[] iArr212 = new int[7];
        // fill-array-data instruction
        iArr212[0] = 2;
        iArr212[1] = 3;
        iArr212[2] = 3;
        iArr212[3] = 1;
        iArr212[4] = 1;
        iArr212[5] = 1;
        iArr212[6] = 2;
        a = new int[][]{iArr30, iArr4, iArr6, iArr8, iArr10, iArr12, iArr14, iArr16, iArr18, iArr20, iArr22, iArr24, iArr26, iArr28, iArr29, iArr32, iArr34, iArr36, iArr38, iArr40, iArr42, iArr44, iArr46, iArr48, iArr50, iArr52, iArr54, iArr56, iArr58, iArr60, iArr62, iArr64, iArr66, iArr68, iArr70, iArr72, iArr74, iArr76, iArr78, iArr80, iArr82, iArr84, iArr86, iArr88, iArr90, iArr92, iArr94, iArr96, iArr98, iArr100, iArr102, iArr104, iArr106, iArr108, iArr110, iArr112, iArr114, iArr116, iArr118, iArr120, iArr122, iArr124, iArr126, iArr128, iArr130, iArr132, iArr134, iArr136, iArr138, iArr140, iArr142, iArr144, iArr146, iArr148, iArr150, iArr152, iArr154, iArr156, iArr158, iArr160, iArr162, iArr164, iArr166, iArr168, iArr170, iArr172, iArr174, iArr176, iArr178, iArr180, iArr182, iArr184, iArr186, iArr188, iArr190, iArr192, iArr194, iArr196, iArr198, iArr200, iArr202, iArr204, iArr206, iArr208, iArr209, iArr211, iArr212};
    }

    private static boolean a(r rVar, int i, int i2) {
        return rVar.a(i, i2, false, false);
    }

    private static float b(r rVar, int[] iArr, int i) {
        int[] iArr2 = new int[7];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        for (int i2 : iArr) {
            i += i2;
        }
        boolean z = true;
        int i3 = 0;
        while (z && i < rVar.e()) {
            if (rVar.b(i)) {
                i3++;
                i++;
            } else {
                iArr2[6] = i3;
                z = false;
            }
        }
        int[][] iArr3 = a;
        return g5.a(iArr2, iArr3[iArr3.length - 1], 0.7f);
    }

    private int[] c(StringBuilder sb, int[] iArr) throws a {
        int i;
        int i2 = 0;
        int i3 = iArr[0];
        int i4 = iArr[1] == 1 ? 1 : 0;
        int i5 = iArr[2] == 1 ? 1 : 0;
        int i6 = iArr[3] == 1 ? 1 : 0;
        int i7 = iArr[4];
        int i8 = iArr[5] == 1 ? 1 : 0;
        int i9 = iArr[6] == 1 ? 1 : 0;
        if (i3 < 100) {
            if (i3 < 10) {
                sb.append('0');
            }
            sb.append(i3);
            i2 = i6;
        } else {
            if (i3 == 106) {
                i2 = i6;
            }
            if (i3 != 106) {
                switch (i3) {
                    case 100:
                        i = 100;
                        break;
                    case 101:
                        i = 101;
                        break;
                    case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY:
                        break;
                    default:
                        throw a.a();
                }
            } else {
                i9 = 1;
            }
        }
        i = i7;
        return new int[]{i3, i4, i5, i2, i, i8, i9};
    }

    private static int[] a(r rVar) throws a {
        int e = rVar.e();
        int c = rVar.c(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i = 0;
        int i2 = c;
        while (c < e) {
            if (rVar.b(c) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i == 5) {
                    int i3 = -1;
                    float f = 0.25f;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float a2 = g5.a(iArr, a[i4], 0.7f);
                        if (a2 < f) {
                            i3 = i4;
                            f = a2;
                        }
                    }
                    if (i3 >= 0) {
                        return new int[]{i2, c, i3};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i] = 0;
                    i--;
                } else {
                    i++;
                }
                iArr[i] = 1;
                z = !z;
            }
            c++;
        }
        throw a.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0068, code lost:
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r6 = r7;
        r5 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] b(java.lang.StringBuilder r11, int[] r12) throws com.huawei.hms.scankit.p.a {
        /*
            r10 = this;
            r0 = 0
            r1 = r12[r0]
            r2 = 1
            r3 = r12[r2]
            if (r3 != r2) goto L_0x000a
            r3 = r2
            goto L_0x000b
        L_0x000a:
            r3 = r0
        L_0x000b:
            r4 = 2
            r4 = r12[r4]
            if (r4 != r2) goto L_0x0012
            r4 = r2
            goto L_0x0013
        L_0x0012:
            r4 = r0
        L_0x0013:
            r5 = 3
            r5 = r12[r5]
            if (r5 != r2) goto L_0x001a
            r5 = r2
            goto L_0x001b
        L_0x001a:
            r5 = r0
        L_0x001b:
            r6 = 4
            r6 = r12[r6]
            r7 = 5
            r7 = r12[r7]
            if (r7 != r2) goto L_0x0025
            r7 = r2
            goto L_0x0026
        L_0x0025:
            r7 = r0
        L_0x0026:
            r8 = 6
            r12 = r12[r8]
            if (r12 != r2) goto L_0x002d
            r12 = r2
            goto L_0x002e
        L_0x002d:
            r12 = r0
        L_0x002e:
            r8 = 96
            if (r1 >= r8) goto L_0x0043
            if (r3 != r4) goto L_0x003b
            int r2 = r1 + 32
            char r2 = (char) r2
            r11.append(r2)
            goto L_0x0041
        L_0x003b:
            int r2 = r1 + 160
            char r2 = (char) r2
            r11.append(r2)
        L_0x0041:
            r2 = r0
            goto L_0x0076
        L_0x0043:
            r11 = 106(0x6a, float:1.49E-43)
            if (r1 == r11) goto L_0x0048
            r5 = r0
        L_0x0048:
            if (r1 == r11) goto L_0x007c
            r11 = 101(0x65, float:1.42E-43)
            switch(r1) {
                case 96: goto L_0x0075;
                case 97: goto L_0x0075;
                case 98: goto L_0x006e;
                case 99: goto L_0x0066;
                case 100: goto L_0x0054;
                case 101: goto L_0x0068;
                case 102: goto L_0x0075;
                default: goto L_0x004f;
            }
        L_0x004f:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()
            throw r11
        L_0x0054:
            if (r4 != 0) goto L_0x005f
            if (r3 == 0) goto L_0x005f
            r3 = r2
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            r2 = r0
            goto L_0x0083
        L_0x005f:
            if (r4 == 0) goto L_0x0076
            if (r3 == 0) goto L_0x0076
            r2 = r0
            r3 = r2
            goto L_0x0077
        L_0x0066:
            r11 = 99
        L_0x0068:
            r2 = r3
            r3 = r4
            r4 = r5
            r6 = r7
            r5 = r11
            goto L_0x007a
        L_0x006e:
            r7 = r12
            r6 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r11
            goto L_0x0083
        L_0x0075:
            r2 = r3
        L_0x0076:
            r3 = r4
        L_0x0077:
            r4 = r5
            r5 = r6
            r6 = r7
        L_0x007a:
            r7 = r12
            goto L_0x0083
        L_0x007c:
            r9 = r7
            r7 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
        L_0x0083:
            int[] r11 = new int[]{r1, r2, r3, r4, r5, r6, r7}
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r0.b(java.lang.StringBuilder, int[]):int[]");
    }

    private static int a(r rVar, int[] iArr, int i) throws a {
        float f;
        g5.a(rVar, i, iArr);
        float f2 = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = a;
            if (i3 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i3];
            if (i3 == iArr2.length - 1) {
                f = b(rVar, iArr, i);
            } else {
                f = g5.a(iArr, iArr3, 0.7f);
            }
            if (f < f2) {
                i2 = i3;
                f2 = f;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw a.a();
    }

    public s6 a(int i, r rVar, Map<l1, ?> map) throws a {
        int[] a2 = a(rVar);
        int i2 = a2[0];
        int i3 = i2 - (((a2[1] - i2) / 11) * 10);
        if (i3 <= 0 || i3 >= i2) {
            r rVar2 = rVar;
        } else if (!a(rVar, i3, i2)) {
            throw a.a();
        }
        int i4 = a2[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i4));
        int i5 = i4 == 103 ? 101 : i4 == 104 ? 100 : i4 == 105 ? 99 : 0;
        if (i5 != 0) {
            StringBuilder sb = new StringBuilder(20);
            int[] iArr = new int[7];
            iArr[6] = i5;
            a(sb, a2, iArr, i4, rVar, arrayList);
            int i6 = iArr[0];
            int i7 = iArr[1];
            int i8 = iArr[2];
            int i9 = iArr[3];
            int i10 = iArr[4];
            boolean z = iArr[5] == 1;
            int i11 = iArr[6];
            int i12 = i7 - i6;
            if ((i9 - (i10 * i8)) % 103 == i8) {
                int length = sb.length();
                if (length != 0) {
                    if (length > 0 && z) {
                        if (i11 == 99) {
                            sb.delete(length - 2, length);
                        } else {
                            sb.delete(length - 1, length);
                        }
                    }
                    float f = (float) a2[0];
                    float f2 = (float) (i6 + ((i12 * 13) / 11));
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i13 = 0; i13 < size; i13++) {
                        bArr[i13] = ((Byte) arrayList.get(i13)).byteValue();
                    }
                    float f3 = (float) i;
                    return new s6(sb.toString(), bArr, new u6[]{new u6(f, f3), new u6(f2, f3)}, BarcodeFormat.CODE_128);
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private void a(StringBuilder sb, int[] iArr, int[] iArr2, int i, r rVar, List<Byte> list) throws a {
        r0 r0Var = this;
        StringBuilder sb2 = sb;
        boolean z = false;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int[] iArr3 = new int[6];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 1;
        int i11 = iArr2[6];
        int i12 = i3;
        int i13 = i2;
        int i14 = i;
        while (i4 == 0) {
            int a2 = a(rVar, iArr3, i12);
            list.add(Byte.valueOf((byte) a2));
            if (a2 != 106) {
                i6++;
                i14 += i6 * a2;
                i10 = 1;
            }
            int i15 = i12;
            for (int i16 = 0; i16 < 6; i16++) {
                i15 += iArr3[i16];
            }
            if (a2 != 105) {
                int[] iArr4 = {a2, i7, i8, i10, i11, 0, i4};
                if (i11 == 101) {
                    iArr4 = r0Var.a(sb2, iArr4);
                } else if (i11 == 100) {
                    iArr4 = r0Var.b(sb2, iArr4);
                } else if (i11 == 99) {
                    iArr4 = r0Var.c(sb2, iArr4);
                }
                int i17 = iArr4[0];
                i7 = iArr4[1] == 1 ? 1 : 0;
                i8 = iArr4[2] == 1 ? 1 : 0;
                int i18 = iArr4[3] == 1 ? 1 : 0;
                boolean z3 = iArr4[5] == 1;
                int i19 = iArr4[6] == 1 ? 1 : 0;
                i11 = z2 ? iArr4[4] == 101 ? 100 : 101 : iArr4[4];
                z2 = z3;
                i5 = i9;
                z = false;
                i4 = i19;
                i9 = i17;
                r0Var = this;
                i10 = i18;
                i13 = i12;
                i12 = i15;
            } else {
                throw a.a();
            }
        }
        iArr2[z] = i13;
        iArr2[1] = i12;
        iArr2[2] = i5;
        iArr2[3] = i14;
        iArr2[4] = i6;
        iArr2[5] = i10;
        iArr2[6] = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0082, code lost:
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r6 = r7;
        r5 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] a(java.lang.StringBuilder r11, int[] r12) throws com.huawei.hms.scankit.p.a {
        /*
            r10 = this;
            r0 = 0
            r1 = r12[r0]
            r2 = 1
            r3 = r12[r2]
            if (r3 != r2) goto L_0x000a
            r3 = r2
            goto L_0x000b
        L_0x000a:
            r3 = r0
        L_0x000b:
            r4 = 2
            r4 = r12[r4]
            if (r4 != r2) goto L_0x0012
            r4 = r2
            goto L_0x0013
        L_0x0012:
            r4 = r0
        L_0x0013:
            r5 = 3
            r5 = r12[r5]
            if (r5 != r2) goto L_0x001a
            r5 = r2
            goto L_0x001b
        L_0x001a:
            r5 = r0
        L_0x001b:
            r6 = 4
            r6 = r12[r6]
            r7 = 5
            r7 = r12[r7]
            if (r7 != r2) goto L_0x0025
            r7 = r2
            goto L_0x0026
        L_0x0025:
            r7 = r0
        L_0x0026:
            r8 = 6
            r12 = r12[r8]
            if (r12 != r2) goto L_0x002d
            r12 = r2
            goto L_0x002e
        L_0x002d:
            r12 = r0
        L_0x002e:
            r8 = 64
            if (r1 >= r8) goto L_0x0042
            if (r3 != r4) goto L_0x003b
            int r2 = r1 + 32
            char r2 = (char) r2
            r11.append(r2)
            goto L_0x0055
        L_0x003b:
            int r2 = r1 + 160
            char r2 = (char) r2
            r11.append(r2)
            goto L_0x0055
        L_0x0042:
            r8 = 96
            if (r1 >= r8) goto L_0x005d
            if (r3 != r4) goto L_0x004f
            int r2 = r1 + -64
            char r2 = (char) r2
            r11.append(r2)
            goto L_0x0055
        L_0x004f:
            int r2 = r1 + 64
            char r2 = (char) r2
            r11.append(r2)
        L_0x0055:
            r2 = r0
        L_0x0056:
            r3 = r4
        L_0x0057:
            r4 = r5
            r5 = r6
            r6 = r7
        L_0x005a:
            r7 = r12
            goto L_0x0098
        L_0x005d:
            r11 = 106(0x6a, float:1.49E-43)
            if (r1 == r11) goto L_0x0062
            r5 = r0
        L_0x0062:
            if (r1 == r11) goto L_0x0091
            r11 = 100
            switch(r1) {
                case 96: goto L_0x008f;
                case 97: goto L_0x008f;
                case 98: goto L_0x0088;
                case 99: goto L_0x0080;
                case 100: goto L_0x0082;
                case 101: goto L_0x006e;
                case 102: goto L_0x008f;
                default: goto L_0x0069;
            }
        L_0x0069:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()
            throw r11
        L_0x006e:
            if (r4 != 0) goto L_0x0079
            if (r3 == 0) goto L_0x0079
            r3 = r2
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            r2 = r0
            goto L_0x0098
        L_0x0079:
            if (r4 == 0) goto L_0x0056
            if (r3 == 0) goto L_0x0056
            r2 = r0
            r3 = r2
            goto L_0x0057
        L_0x0080:
            r11 = 99
        L_0x0082:
            r2 = r3
            r3 = r4
            r4 = r5
            r6 = r7
            r5 = r11
            goto L_0x005a
        L_0x0088:
            r7 = r12
            r6 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r11
            goto L_0x0098
        L_0x008f:
            r2 = r3
            goto L_0x0056
        L_0x0091:
            r9 = r7
            r7 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
        L_0x0098:
            int[] r11 = new int[]{r1, r2, r3, r4, r5, r6, r7}
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r0.a(java.lang.StringBuilder, int[]):int[]");
    }
}
