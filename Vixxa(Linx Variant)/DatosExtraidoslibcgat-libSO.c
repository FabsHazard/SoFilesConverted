typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned int    dword;
typedef unsigned long    ulong;
typedef unsigned short    undefined2;
typedef unsigned int    undefined4;
typedef unsigned long long    undefined8;
typedef unsigned short    word;
typedef struct Elf32_Phdr Elf32_Phdr, *PElf32_Phdr;

typedef enum Elf_ProgramHeaderType_ARM {
    PT_NULL=0,
    PT_LOAD=1,
    PT_DYNAMIC=2,
    PT_INTERP=3,
    PT_NOTE=4,
    PT_SHLIB=5,
    PT_PHDR=6,
    PT_TLS=7,
    PT_GNU_EH_FRAME=1685382480,
    PT_GNU_STACK=1685382481,
    PT_GNU_RELRO=1685382482,
    PT_ARM_EXIDX=1879048192
} Elf_ProgramHeaderType_ARM;

struct Elf32_Phdr {
    enum Elf_ProgramHeaderType_ARM p_type;
    dword p_offset;
    dword p_vaddr;
    dword p_paddr;
    dword p_filesz;
    dword p_memsz;
    dword p_flags;
    dword p_align;
};

typedef enum Elf32_DynTag_ARM {
    DT_NULL=0,
    DT_NEEDED=1,
    DT_PLTRELSZ=2,
    DT_PLTGOT=3,
    DT_HASH=4,
    DT_STRTAB=5,
    DT_SYMTAB=6,
    DT_RELA=7,
    DT_RELASZ=8,
    DT_RELAENT=9,
    DT_STRSZ=10,
    DT_SYMENT=11,
    DT_INIT=12,
    DT_FINI=13,
    DT_SONAME=14,
    DT_RPATH=15,
    DT_SYMBOLIC=16,
    DT_REL=17,
    DT_RELSZ=18,
    DT_RELENT=19,
    DT_PLTREL=20,
    DT_DEBUG=21,
    DT_TEXTREL=22,
    DT_JMPREL=23,
    DT_BIND_NOW=24,
    DT_INIT_ARRAY=25,
    DT_FINI_ARRAY=26,
    DT_INIT_ARRAYSZ=27,
    DT_FINI_ARRAYSZ=28,
    DT_RUNPATH=29,
    DT_FLAGS=30,
    DT_PREINIT_ARRAY=32,
    DT_PREINIT_ARRAYSZ=33,
    DT_RELRSZ=35,
    DT_RELR=36,
    DT_RELRENT=37,
    DT_ANDROID_REL=1610612751,
    DT_ANDROID_RELSZ=1610612752,
    DT_ANDROID_RELA=1610612753,
    DT_ANDROID_RELASZ=1610612754,
    DT_ANDROID_RELR=1879040000,
    DT_ANDROID_RELRSZ=1879040001,
    DT_ANDROID_RELRENT=1879040003,
    DT_GNU_PRELINKED=1879047669,
    DT_GNU_CONFLICTSZ=1879047670,
    DT_GNU_LIBLISTSZ=1879047671,
    DT_CHECKSUM=1879047672,
    DT_PLTPADSZ=1879047673,
    DT_MOVEENT=1879047674,
    DT_MOVESZ=1879047675,
    DT_FEATURE_1=1879047676,
    DT_POSFLAG_1=1879047677,
    DT_SYMINSZ=1879047678,
    DT_SYMINENT=1879047679,
    DT_GNU_XHASH=1879047924,
    DT_GNU_HASH=1879047925,
    DT_TLSDESC_PLT=1879047926,
    DT_TLSDESC_GOT=1879047927,
    DT_GNU_CONFLICT=1879047928,
    DT_GNU_LIBLIST=1879047929,
    DT_CONFIG=1879047930,
    DT_DEPAUDIT=1879047931,
    DT_AUDIT=1879047932,
    DT_PLTPAD=1879047933,
    DT_MOVETAB=1879047934,
    DT_SYMINFO=1879047935,
    DT_VERSYM=1879048176,
    DT_RELACOUNT=1879048185,
    DT_RELCOUNT=1879048186,
    DT_FLAGS_1=1879048187,
    DT_VERDEF=1879048188,
    DT_VERDEFNUM=1879048189,
    DT_VERNEED=1879048190,
    DT_VERNEEDNUM=1879048191,
    DT_AUXILIARY=2147483645,
    DT_FILTER=2147483647
} Elf32_DynTag_ARM;

typedef struct GnuBuildId GnuBuildId, *PGnuBuildId;

struct GnuBuildId {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[4]; // Vendor name
    byte hash[20];
};

typedef struct Elf32_Rel Elf32_Rel, *PElf32_Rel;

struct Elf32_Rel {
    dword r_offset; // location to apply the relocation action
    dword r_info; // the symbol table index and the type of relocation
};

typedef enum Elf_SectionHeaderType_ARM {
    SHT_NULL=0,
    SHT_PROGBITS=1,
    SHT_SYMTAB=2,
    SHT_STRTAB=3,
    SHT_RELA=4,
    SHT_HASH=5,
    SHT_DYNAMIC=6,
    SHT_NOTE=7,
    SHT_NOBITS=8,
    SHT_REL=9,
    SHT_SHLIB=10,
    SHT_DYNSYM=11,
    SHT_INIT_ARRAY=14,
    SHT_FINI_ARRAY=15,
    SHT_PREINIT_ARRAY=16,
    SHT_GROUP=17,
    SHT_SYMTAB_SHNDX=18,
    SHT_ANDROID_REL=1610612737,
    SHT_ANDROID_RELA=1610612738,
    SHT_GNU_ATTRIBUTES=1879048181,
    SHT_GNU_HASH=1879048182,
    SHT_GNU_LIBLIST=1879048183,
    SHT_CHECKSUM=1879048184,
    SHT_SUNW_move=1879048186,
    SHT_SUNW_COMDAT=1879048187,
    SHT_SUNW_syminfo=1879048188,
    SHT_GNU_verdef=1879048189,
    SHT_GNU_verneed=1879048190,
    SHT_GNU_versym=1879048191,
    SHT_ARM_EXIDX=1879048193,
    SHT_ARM_PREEMPTMAP=1879048194,
    SHT_ARM_ATTRIBUTES=1879048195,
    SHT_ARM_DEBUGOVERLAY=1879048196,
    SHT_ARM_OVERLAYSECTION=1879048197
} Elf_SectionHeaderType_ARM;

typedef struct Elf32_Shdr Elf32_Shdr, *PElf32_Shdr;

struct Elf32_Shdr {
    dword sh_name;
    enum Elf_SectionHeaderType_ARM sh_type;
    dword sh_flags;
    dword sh_addr;
    dword sh_offset;
    dword sh_size;
    dword sh_link;
    dword sh_info;
    dword sh_addralign;
    dword sh_entsize;
};

typedef struct Elf32_Sym Elf32_Sym, *PElf32_Sym;

struct Elf32_Sym {
    dword st_name;
    dword st_value;
    dword st_size;
    byte st_info;
    byte st_other;
    word st_shndx;
};

typedef struct ElfNote_8_132 ElfNote_8_132, *PElfNote_8_132;

struct ElfNote_8_132 {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[8]; // Vendor name
    byte description[132]; // Blob value
};

typedef struct Elf32_Dyn_ARM Elf32_Dyn_ARM, *PElf32_Dyn_ARM;

struct Elf32_Dyn_ARM {
    enum Elf32_DynTag_ARM d_tag;
    dword d_val;
};

typedef struct Elf32_Ehdr Elf32_Ehdr, *PElf32_Ehdr;

struct Elf32_Ehdr {
    byte e_ident_magic_num;
    char e_ident_magic_str[3];
    byte e_ident_class;
    byte e_ident_data;
    byte e_ident_version;
    byte e_ident_osabi;
    byte e_ident_abiversion;
    byte e_ident_pad[7];
    word e_type;
    word e_machine;
    dword e_version;
    dword e_entry;
    dword e_phoff;
    dword e_shoff;
    dword e_flags;
    word e_ehsize;
    word e_phentsize;
    word e_phnum;
    word e_shentsize;
    word e_shnum;
    word e_shstrndx;
};

typedef ulong size_t;




void processEntry entry(void)

{
  __cxa_finalize(&DAT_00023860);
  return;
}



void FUN_00012bc0(void)

{
  return;
}



void _FINI_0(void)

{
  return;
}



void JNI_OnLoad(int *param_1)

{
  int *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  local_28 = (int *)0x0;
  (**(code **)(*param_1 + 0x18))(param_1,&local_28,0x10004);
  DAT_00024b40 = (**(code **)(*local_28 + 0x18))(local_28,"com/microtechmd/cgat/CGA");
  DAT_00024b44 = (**(code **)(*local_28 + 0x178))(local_28,DAT_00024b40,"colSize",&DAT_00012b5e);
  DAT_00024b48 = (**(code **)(*local_28 + 0x178))(local_28,DAT_00024b40,"rowSize",&DAT_00012b5e);
  DAT_00024b4c = (**(code **)(*local_28 + 0x178))(local_28,DAT_00024b40,"dataPtr",&DAT_00012ba3);
  DAT_00024b50 = (**(code **)(*local_28 + 0x178))
                           (local_28,DAT_00024b40,"selectedDataPtr",&DAT_00012ba3);
  DAT_00024b54 = (**(code **)(*local_28 + 0x178))(local_28,DAT_00024b40,"mbgPtr",&DAT_00012ba3);
  DAT_00024b58 = (**(code **)(*local_28 + 0x178))(local_28,DAT_00024b40,"sdbgPtr",&DAT_00012ba3);
  DAT_00024b5c = (**(code **)(*local_28 + 0x178))(local_28,DAT_00024b40,"cvPtr",&DAT_00012ba3);
  datools_initialize();
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_24);
  }
  return;
}



void JNI_OnUnload(void)

{
  datools_terminate();
  return;
}



void Java_com_microtechmd_cgat_CGA_constructor(int *param_1,undefined4 param_2,undefined4 param_3)

{
  int iVar1;
  undefined4 uVar2;
  uint uVar3;
  int *piVar4;
  uint uVar5;
  undefined8 *puVar6;
  int iVar7;
  undefined8 *puVar8;
  undefined8 *puVar9;
  uint uVar10;
  int iVar11;
  int iVar12;
  int iVar13;
  bool bVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  uint local_30;
  int iStack_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar1 = (**(code **)(*param_1 + 0x2ac))(param_1,param_3);
  if (iVar1 != 0) {
    uVar2 = (**(code **)(*param_1 + 0x2b4))(param_1,param_3,0);
    iVar1 = (**(code **)(*param_1 + 0x2ac))(param_1,param_3);
    uVar3 = (**(code **)(*param_1 + 0x2ac))(param_1,uVar2);
    local_30 = uVar3;
    iStack_2c = iVar1;
    piVar4 = (int *)emxCreateND_real_T(2,&local_30);
    if (0 < iVar1) {
      iVar13 = 0;
      iVar12 = 0;
      uVar5 = uVar3 & 0xfffffffe;
      do {
        uVar2 = (**(code **)(*param_1 + 0x2b4))(param_1,param_3,iVar12);
        puVar6 = (undefined8 *)(**(code **)(*param_1 + 0x2f8))(param_1,uVar2,0);
        if (0 < (int)uVar3) {
          iVar7 = *piVar4;
          if (uVar3 == 1) {
LAB_00012e80:
            uVar10 = 0;
          }
          else {
            puVar8 = (undefined8 *)(iVar7 + uVar3 * iVar12 * 8);
            bVar14 = puVar8 < puVar6 + uVar3;
            if (bVar14) {
              puVar8 = (undefined8 *)(iVar7 + (uVar3 * iVar12 + uVar3) * 8);
            }
            if (bVar14 && puVar6 < puVar8) goto LAB_00012e80;
            puVar9 = (undefined8 *)(iVar7 + iVar13 * 8);
            puVar8 = puVar6;
            uVar10 = uVar5;
            do {
              uVar15 = *puVar8;
              uVar16 = puVar8[1];
              puVar8 = puVar8 + 2;
              uVar10 = uVar10 - 2;
              *puVar9 = uVar15;
              puVar9[1] = uVar16;
              puVar9 = puVar9 + 2;
            } while (uVar10 != 0);
            uVar10 = uVar5;
            if (uVar3 == uVar5) goto LAB_00012df6;
          }
          puVar9 = puVar6 + uVar10;
          iVar11 = uVar3 - uVar10;
          puVar8 = (undefined8 *)(iVar7 + (uVar10 + iVar13) * 8);
          do {
            uVar15 = *puVar9;
            puVar9 = puVar9 + 1;
            iVar11 = iVar11 + -1;
            *puVar8 = uVar15;
            puVar8 = puVar8 + 1;
          } while (iVar11 != 0);
        }
LAB_00012df6:
        (**(code **)(*param_1 + 0x318))(param_1,uVar2,puVar6,2);
        iVar12 = iVar12 + 1;
        iVar13 = iVar13 + uVar3;
      } while (iVar12 != iVar1);
    }
    neg2nan(piVar4);
    uVar15 = emxCreateND_real_T(2,&local_30);
    SAFilter(piVar4,(int)((ulonglong)uVar15 >> 0x20),0,0x3ff00000,0,0x40380000,(int)uVar15);
    emxDestroyArray_real_T(piVar4);
    (**(code **)(*param_1 + 0x1b8))
              (param_1,param_2,DAT_00024b4c,*(code **)(*param_1 + 0x1b8),(int)uVar15,0);
    Java_com_microtechmd_cgat_CGA_selectPeriod(param_1,param_2,0,0,0,0x40380000);
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void Java_com_microtechmd_cgat_CGA_selectPeriod
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
               undefined8 param_5)

{
  int iVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 uVar5;
  undefined4 extraout_r1;
  undefined4 local_44;
  undefined4 local_40;
  undefined4 local_3c;
  undefined4 local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  iVar1 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar1 != 0) {
    uVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
    uVar3 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b54);
    uVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b58);
    uVar5 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b5c);
    emxDestroyArray_real_T(uVar2);
    emxInitArray_real_T(&local_38,2);
    SelectByHour(iVar1,extraout_r1,param_3,param_4,param_5,local_38);
    (**(code **)(*param_1 + 0x1b8))
              (param_1,param_2,DAT_00024b50,*(code **)(*param_1 + 0x1b8),local_38,0);
    emxDestroyArray_real_T(uVar3);
    emxInitArray_real_T(&local_3c,2);
    MBG(local_38,local_3c);
    (**(code **)(*param_1 + 0x1b8))
              (param_1,param_2,DAT_00024b54,*(code **)(*param_1 + 0x1b8),local_3c,0);
    emxDestroyArray_real_T(uVar4);
    emxInitArray_real_T(&local_40,2);
    SDBG(local_38,local_40);
    (**(code **)(*param_1 + 0x1b8))
              (param_1,param_2,DAT_00024b58,*(code **)(*param_1 + 0x1b8),local_40,0);
    emxDestroyArray_real_T(uVar5);
    emxInitArray_real_T(&local_44,2);
    CV(local_3c,local_40,local_44);
    (**(code **)(*param_1 + 0x1b8))
              (param_1,param_2,DAT_00024b5c,*(code **)(*param_1 + 0x1b8),local_44,0);
  }
  if (__stack_chk_guard != local_34) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_34);
  }
  return;
}



void Java_com_microtechmd_cgat_CGA_destructor(int *param_1,undefined4 param_2)

{
  undefined4 uVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 uVar5;
  
  uVar1 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  uVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  uVar3 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b54);
  uVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b58);
  uVar5 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b5c);
  emxDestroyArray_real_T(uVar3);
  emxDestroyArray_real_T(uVar4);
  emxDestroyArray_real_T(uVar5);
  emxDestroyArray_real_T(uVar2);
  emxDestroyArray_real_T(uVar1);
  (**(code **)(*param_1 + 0x1b8))(param_1,param_2,DAT_00024b54,*(code **)(*param_1 + 0x1b8),0,0);
  (**(code **)(*param_1 + 0x1b8))(param_1,param_2,DAT_00024b58,*(code **)(*param_1 + 0x1b8),0,0);
  (**(code **)(*param_1 + 0x1b8))(param_1,param_2,DAT_00024b5c,*(code **)(*param_1 + 0x1b8),0,0);
  (**(code **)(*param_1 + 0x1b8))(param_1,param_2,DAT_00024b50,*(code **)(*param_1 + 0x1b8),0,0);
  (**(code **)(*param_1 + 0x1b8))(param_1,param_2,DAT_00024b4c,*(code **)(*param_1 + 0x1b8),0,0);
  return;
}



void Java_com_microtechmd_cgat_CGA_getDailyTrendMean(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar4 == 0) goto LAB_000132ba;
  emxInitArray_real_T(&local_28,1);
  DailyTrendMean(iVar4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00013286;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_00013286:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_000132ba:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getDailyTrendPrctile
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  undefined4 extraout_r1;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar4 == 0) goto LAB_000133c0;
  emxInitArray_real_T(&local_28,1);
  DailyTrendPrctile(iVar4,extraout_r1,param_3,param_4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_0001338c;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_0001338c:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_000133c0:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getPeriodLBGD
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 extraout_r1;
  int iVar5;
  int iVar6;
  int iVar7;
  int *local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  iVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar2 != 0) {
    emxInitArray_real_T(&local_38,2);
    LBGD(iVar2,extraout_r1,0x55555555,0x3fb55555,CONCAT44(param_4,param_3),local_38);
    piVar1 = local_38;
    if ((local_38 != (int *)0x0) && (local_38[3] == 2)) {
      iVar6 = *(int *)local_38[1];
      iVar2 = ((int *)local_38[1])[1];
      uVar3 = (**(code **)(*param_1 + 0x18))(param_1,&DAT_00012b91);
      uVar3 = (**(code **)(*param_1 + 0x2b0))(param_1,iVar2,uVar3,0);
      if (0 < iVar2) {
        iVar7 = 0;
        iVar5 = 0;
        do {
          uVar4 = (**(code **)(*param_1 + 0x2d8))(param_1,iVar6);
          (**(code **)(*param_1 + 0x358))(param_1,uVar4,0,iVar6,*piVar1 + iVar7);
          (**(code **)(*param_1 + 0x2b8))(param_1,uVar3,iVar5,uVar4);
          iVar5 = iVar5 + 1;
          iVar7 = iVar7 + iVar6 * 8;
        } while (iVar2 != iVar5);
      }
    }
    emxDestroyArray_real_T(local_38);
  }
  if (__stack_chk_guard == local_34) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_34);
}



void Java_com_microtechmd_cgat_CGA_getPeriodHBGD
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 extraout_r1;
  int iVar5;
  int iVar6;
  int iVar7;
  int *local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  iVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar2 != 0) {
    emxInitArray_real_T(&local_38,2);
    HBGD(iVar2,extraout_r1,0x55555555,0x3fb55555,CONCAT44(param_4,param_3),local_38);
    piVar1 = local_38;
    if ((local_38 != (int *)0x0) && (local_38[3] == 2)) {
      iVar6 = *(int *)local_38[1];
      iVar2 = ((int *)local_38[1])[1];
      uVar3 = (**(code **)(*param_1 + 0x18))(param_1,&DAT_00012b91);
      uVar3 = (**(code **)(*param_1 + 0x2b0))(param_1,iVar2,uVar3,0);
      if (0 < iVar2) {
        iVar7 = 0;
        iVar5 = 0;
        do {
          uVar4 = (**(code **)(*param_1 + 0x2d8))(param_1,iVar6);
          (**(code **)(*param_1 + 0x358))(param_1,uVar4,0,iVar6,*piVar1 + iVar7);
          (**(code **)(*param_1 + 0x2b8))(param_1,uVar3,iVar5,uVar4);
          iVar5 = iVar5 + 1;
          iVar7 = iVar7 + iVar6 * 8;
        } while (iVar2 != iVar5);
      }
    }
    emxDestroyArray_real_T(local_38);
  }
  if (__stack_chk_guard == local_34) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_34);
}



void Java_com_microtechmd_cgat_CGA_getPeriodNUM(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar4 == 0) goto LAB_00013736;
  emxInitArray_real_T(&local_28,2);
  NUM(iVar4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00013702;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_00013702:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_00013736:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getPeriodMAXBG(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar4 == 0) goto LAB_00013832;
  emxInitArray_real_T(&local_28,2);
  MAXBG(iVar4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_000137fe;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_000137fe:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_00013832:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getPeriodMINBG(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar4 == 0) goto LAB_0001392e;
  emxInitArray_real_T(&local_28,2);
  MINBG(iVar4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_000138fa;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_000138fa:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_0001392e:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



undefined4 Java_com_microtechmd_cgat_CGA_getPeriodMBG(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  uint *puVar4;
  undefined4 uVar5;
  int iVar6;
  int iVar7;
  uint uVar8;
  undefined1 (*pauVar9) [16];
  uint uVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  puVar3 = (undefined4 *)(**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b54);
  if (puVar3 == (undefined4 *)0x0) {
    return 0;
  }
  puVar4 = (uint *)puVar3[1];
  iVar6 = puVar3[3];
  uVar10 = *puVar4;
  if (1 < iVar6) {
    uVar8 = iVar6 - 1;
    iVar7 = 1;
    if (3 < uVar8) {
      uVar11 = uVar8 & 0xfffffffc;
      pauVar9 = (undefined1 (*) [16])(puVar4 + 1);
      iVar7 = uVar11 + 1;
      auVar12._0_8_ = (ulonglong)uVar10 & 0xffff | 0x100000000;
      auVar12._8_8_ = 0x100000001;
      uVar10 = uVar11;
      do {
        auVar2 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar10 = uVar10 - 4;
        auVar12 = VectorMultiply(auVar2,auVar12,4);
      } while (uVar10 != 0);
      auVar1._16_16_ = auVar12;
      auVar1._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
      uVar5 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar5,4);
      uVar10 = auVar12._0_4_;
      if (uVar8 == uVar11) goto LAB_000139cc;
    }
    iVar6 = iVar6 - iVar7;
    puVar4 = puVar4 + iVar7;
    do {
      iVar6 = iVar6 + -1;
      uVar10 = *puVar4 * uVar10;
      puVar4 = puVar4 + 1;
    } while (iVar6 != 0);
  }
LAB_000139cc:
  uVar5 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar10);
  (**(code **)(*param_1 + 0x358))(param_1,uVar5,0,uVar10,*puVar3);
  return uVar5;
}



void Java_com_microtechmd_cgat_CGA_getPeriodMValue
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  undefined4 extraout_r1;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar4 == 0) goto LAB_00013ae8;
  emxInitArray_real_T(&local_28,2);
  MValue(iVar4,extraout_r1,param_3,param_4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00013ab4;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_00013ab4:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_00013ae8:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



undefined4 Java_com_microtechmd_cgat_CGA_getPeriodSDBG(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  uint *puVar4;
  undefined4 uVar5;
  int iVar6;
  int iVar7;
  uint uVar8;
  undefined1 (*pauVar9) [16];
  uint uVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  puVar3 = (undefined4 *)(**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b58);
  if (puVar3 == (undefined4 *)0x0) {
    return 0;
  }
  puVar4 = (uint *)puVar3[1];
  iVar6 = puVar3[3];
  uVar10 = *puVar4;
  if (1 < iVar6) {
    uVar8 = iVar6 - 1;
    iVar7 = 1;
    if (3 < uVar8) {
      uVar11 = uVar8 & 0xfffffffc;
      pauVar9 = (undefined1 (*) [16])(puVar4 + 1);
      iVar7 = uVar11 + 1;
      auVar12._0_8_ = (ulonglong)uVar10 & 0xffff | 0x100000000;
      auVar12._8_8_ = 0x100000001;
      uVar10 = uVar11;
      do {
        auVar2 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar10 = uVar10 - 4;
        auVar12 = VectorMultiply(auVar2,auVar12,4);
      } while (uVar10 != 0);
      auVar1._16_16_ = auVar12;
      auVar1._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
      uVar5 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar5,4);
      uVar10 = auVar12._0_4_;
      if (uVar8 == uVar11) goto LAB_00013b84;
    }
    iVar6 = iVar6 - iVar7;
    puVar4 = puVar4 + iVar7;
    do {
      iVar6 = iVar6 + -1;
      uVar10 = *puVar4 * uVar10;
      puVar4 = puVar4 + 1;
    } while (iVar6 != 0);
  }
LAB_00013b84:
  uVar5 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar10);
  (**(code **)(*param_1 + 0x358))(param_1,uVar5,0,uVar10,*puVar3);
  return uVar5;
}



undefined4 Java_com_microtechmd_cgat_CGA_getPeriodCV(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  uint *puVar4;
  undefined4 uVar5;
  int iVar6;
  int iVar7;
  uint uVar8;
  undefined1 (*pauVar9) [16];
  uint uVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  puVar3 = (undefined4 *)(**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b5c);
  if (puVar3 == (undefined4 *)0x0) {
    return 0;
  }
  puVar4 = (uint *)puVar3[1];
  iVar6 = puVar3[3];
  uVar10 = *puVar4;
  if (1 < iVar6) {
    uVar8 = iVar6 - 1;
    iVar7 = 1;
    if (3 < uVar8) {
      uVar11 = uVar8 & 0xfffffffc;
      pauVar9 = (undefined1 (*) [16])(puVar4 + 1);
      iVar7 = uVar11 + 1;
      auVar12._0_8_ = (ulonglong)uVar10 & 0xffff | 0x100000000;
      auVar12._8_8_ = 0x100000001;
      uVar10 = uVar11;
      do {
        auVar2 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar10 = uVar10 - 4;
        auVar12 = VectorMultiply(auVar2,auVar12,4);
      } while (uVar10 != 0);
      auVar1._16_16_ = auVar12;
      auVar1._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
      uVar5 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar5,4);
      uVar10 = auVar12._0_4_;
      if (uVar8 == uVar11) goto LAB_00013c38;
    }
    iVar6 = iVar6 - iVar7;
    puVar4 = puVar4 + iVar7;
    do {
      iVar6 = iVar6 + -1;
      uVar10 = *puVar4 * uVar10;
      puVar4 = puVar4 + 1;
    } while (iVar6 != 0);
  }
LAB_00013c38:
  uVar5 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar10);
  (**(code **)(*param_1 + 0x358))(param_1,uVar5,0,uVar10,*puVar3);
  return uVar5;
}



void Java_com_microtechmd_cgat_CGA_getPeriodJIndex(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  int iVar5;
  uint *puVar6;
  undefined4 uVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b54);
  if ((iVar4 == 0) ||
     (iVar5 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b58), iVar5 == 0))
  goto LAB_00013d68;
  emxInitArray_real_T(&local_28,2);
  JINDEX(iVar4,iVar5,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar6 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar6;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar5 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar6 + 1);
        iVar5 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar7 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar7,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00013d34;
      }
      iVar4 = iVar4 - iVar5;
      puVar6 = puVar6 + iVar5;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar6 * uVar9;
        puVar6 = puVar6 + 1;
      } while (iVar4 != 0);
    }
LAB_00013d34:
    uVar7 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar7,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_00013d68:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getPeriodIQR(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar4 == 0) goto LAB_00013e66;
  emxInitArray_real_T(&local_28,2);
  IQR(iVar4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00013e32;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_00013e32:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_00013e66:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getPeriodPT(int *param_1,undefined4 param_2,undefined4 param_3)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 uVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  int *local_34;
  undefined4 local_30;
  undefined4 uStack_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar2 != 0) {
    uVar3 = (**(code **)(*param_1 + 0x2ac))(param_1,param_3);
    uVar4 = (**(code **)(*param_1 + 0x2f8))(param_1,param_3,0);
    uStack_2c = 1;
    local_30 = uVar3;
    uVar3 = emxCreateWrapperND_real_T(uVar4,2,&local_30);
    emxInitArray_real_T(&local_34,2);
    PT(iVar2,uVar3,local_34);
    piVar1 = local_34;
    if ((local_34 != (int *)0x0) && (local_34[3] == 2)) {
      iVar8 = *(int *)local_34[1];
      iVar2 = ((int *)local_34[1])[1];
      uVar4 = (**(code **)(*param_1 + 0x18))(param_1,&DAT_00012b91);
      uVar4 = (**(code **)(*param_1 + 0x2b0))(param_1,iVar2,uVar4,0);
      if (0 < iVar2) {
        iVar7 = 0;
        iVar6 = 0;
        do {
          uVar5 = (**(code **)(*param_1 + 0x2d8))(param_1,iVar8);
          (**(code **)(*param_1 + 0x358))(param_1,uVar5,0,iVar8,*piVar1 + iVar7);
          (**(code **)(*param_1 + 0x2b8))(param_1,uVar4,iVar6,uVar5);
          iVar6 = iVar6 + 1;
          iVar7 = iVar7 + iVar8 * 8;
        } while (iVar2 != iVar6);
      }
    }
    emxDestroyArray_real_T(local_34);
    emxDestroyArray_real_T(uVar3);
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_28);
}



void Java_com_microtechmd_cgat_CGA_getPeriodAAC
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  undefined4 extraout_r1;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar4 == 0) goto LAB_000140c4;
  emxInitArray_real_T(&local_28,2);
  AAC(iVar4,extraout_r1,param_3,param_4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00014090;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_00014090:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_000140c4:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getPeriodAUC
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  undefined4 extraout_r1;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b50);
  if (iVar4 == 0) goto LAB_000141c8;
  emxInitArray_real_T(&local_28,2);
  AUC(iVar4,extraout_r1,param_3,param_4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00014194;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_00014194:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_000141c8:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



double Java_com_microtechmd_cgat_CGA_getHBA1C(int *param_1,undefined4 param_2)

{
  bool bVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  double *pdVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  uint uVar9;
  double dVar10;
  undefined8 uVar11;
  double dVar12;
  int *piStack_1c4;
  double adStack_1c0 [48];
  int iStack_3c;
  
  iVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar2 == 0) {
    return rtNaN;
  }
  iStack_3c = __stack_chk_guard;
  emxInit_real_T(&piStack_1c4,1);
  b_nanmean(iVar2,piStack_1c4);
  iVar2 = (int)(longlong)((double)(longlong)*(int *)piStack_1c4[1] / 48.0);
  if (iVar2 == 0) {
    adStack_1c0[0x2f] = rtNaN;
    adStack_1c0[0x2e] = rtNaN;
    adStack_1c0[0x2d] = rtNaN;
    adStack_1c0[0x2c] = rtNaN;
    adStack_1c0[0x2b] = rtNaN;
    adStack_1c0[0x2a] = rtNaN;
    adStack_1c0[0x29] = rtNaN;
    adStack_1c0[0x28] = rtNaN;
    adStack_1c0[0x27] = rtNaN;
    adStack_1c0[0x26] = rtNaN;
    adStack_1c0[0x25] = rtNaN;
    adStack_1c0[0x24] = rtNaN;
    adStack_1c0[0x23] = rtNaN;
    adStack_1c0[0x22] = rtNaN;
    adStack_1c0[0x21] = rtNaN;
    adStack_1c0[0x20] = rtNaN;
    adStack_1c0[0x1f] = rtNaN;
    adStack_1c0[0x1e] = rtNaN;
    adStack_1c0[0x1d] = rtNaN;
    adStack_1c0[0x1c] = rtNaN;
    adStack_1c0[0x1b] = rtNaN;
    adStack_1c0[0x1a] = rtNaN;
    adStack_1c0[0x19] = rtNaN;
    adStack_1c0[0x18] = rtNaN;
    adStack_1c0[0x17] = rtNaN;
    adStack_1c0[0x16] = rtNaN;
    adStack_1c0[0x15] = rtNaN;
    adStack_1c0[0x14] = rtNaN;
    adStack_1c0[0x13] = rtNaN;
    adStack_1c0[0x12] = rtNaN;
    adStack_1c0[0x11] = rtNaN;
    adStack_1c0[0x10] = rtNaN;
    adStack_1c0[0xf] = rtNaN;
    adStack_1c0[0xe] = rtNaN;
    adStack_1c0[0xd] = rtNaN;
    adStack_1c0[0xc] = rtNaN;
    adStack_1c0[0xb] = rtNaN;
    adStack_1c0[10] = rtNaN;
    adStack_1c0[9] = rtNaN;
    adStack_1c0[8] = rtNaN;
    adStack_1c0[7] = rtNaN;
    adStack_1c0[6] = rtNaN;
    adStack_1c0[5] = rtNaN;
    adStack_1c0[4] = rtNaN;
    adStack_1c0[3] = rtNaN;
    adStack_1c0[2] = rtNaN;
    adStack_1c0[1] = rtNaN;
    adStack_1c0[0] = rtNaN;
  }
  else {
    iVar6 = -1;
    iVar8 = -1;
    do {
      iVar7 = iVar8 + 1;
      uVar11 = *(undefined8 *)(*piStack_1c4 + iVar7 * 8);
      iVar3 = rtIsNaN((int)uVar11,(int)((ulonglong)uVar11 >> 0x20));
      bVar1 = iVar3 == 0;
      if (bVar1) {
        dVar10 = *(double *)(*piStack_1c4 + iVar7 * 8);
      }
      else {
        dVar10 = 0.0;
      }
      uVar9 = (uint)bVar1;
      if (1 < iVar2) {
        iVar3 = iVar8 * 8 + 0x10;
        iVar7 = iVar8 + iVar2;
        iVar8 = iVar2 + -1;
        uVar9 = (uint)bVar1;
        do {
          iVar4 = rtIsNaN((int)*(undefined8 *)(*piStack_1c4 + iVar3),
                          (int)((ulonglong)*(undefined8 *)(*piStack_1c4 + iVar3) >> 0x20));
          if (iVar4 == 0) {
            uVar9 = uVar9 + 1;
            dVar10 = dVar10 + *(double *)(*piStack_1c4 + iVar3);
          }
          iVar3 = iVar3 + 8;
          iVar8 = iVar8 + -1;
        } while (iVar8 != 0);
      }
      dVar12 = rtNaN;
      if (uVar9 != 0) {
        dVar12 = dVar10 / (double)(longlong)(int)uVar9;
      }
      iVar6 = iVar6 + 1;
      adStack_1c0[iVar6] = dVar12;
      iVar8 = iVar7;
    } while (iVar6 != 0x2f);
  }
  emxFree_real_T(&piStack_1c4);
  iVar2 = 8;
  dVar10 = adStack_1c0[0];
  do {
    pdVar5 = (double *)((int)adStack_1c0 + iVar2);
    iVar2 = iVar2 + 8;
    dVar10 = dVar10 + *pdVar5;
  } while (iVar2 != 0x180);
  if (__stack_chk_guard != iStack_3c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iStack_3c,__stack_chk_guard);
  }
  return (dVar10 / 48.0 + 0.582) / 1.198;
}



undefined8 Java_com_microtechmd_cgat_CGA_getLBGI(int *param_1,undefined4 param_2)

{
  uint *puVar1;
  uint uVar2;
  int iVar3;
  undefined8 *puVar4;
  double *pdVar5;
  undefined8 *puVar6;
  uint uVar7;
  undefined8 *puVar8;
  uint uVar9;
  undefined8 *puVar10;
  bool bVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  double dVar14;
  int *piStack_24;
  uint *puStack_20;
  int iStack_1c;
  
  puVar1 = (uint *)(**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (puVar1 == (uint *)0x0) {
    return rtNaN;
  }
  iStack_1c = __stack_chk_guard;
  emxInit_real_T(&puStack_20,1);
  iVar3 = *(int *)puStack_20[1];
  *(int *)puStack_20[1] = ((int *)puVar1[1])[1] * *(int *)puVar1[1];
  emxEnsureCapacity_real_T1(puStack_20,iVar3);
  uVar2 = *(int *)puVar1[1] * ((int *)puVar1[1])[1];
  if ((int)uVar2 < 1) goto LAB_000196a2;
  puVar10 = (undefined8 *)*puVar1;
  puVar8 = (undefined8 *)*puStack_20;
  if (uVar2 == 1) {
LAB_00019658:
    uVar9 = 0;
LAB_0001965a:
    puVar10 = puVar10 + uVar9;
    puVar8 = puVar8 + uVar9;
    iVar3 = uVar2 - uVar9;
    do {
      uVar12 = *puVar10;
      puVar10 = puVar10 + 1;
      iVar3 = iVar3 + -1;
      *puVar8 = uVar12;
      puVar8 = puVar8 + 1;
    } while (iVar3 != 0);
  }
  else {
    puVar4 = puVar10 + uVar2;
    bVar11 = puVar8 < puVar4;
    if (bVar11) {
      puVar4 = puVar8 + uVar2;
    }
    if (bVar11 && puVar10 < puVar4) goto LAB_00019658;
    uVar9 = uVar2 & 0xfffffffe;
    puVar4 = puVar10;
    puVar6 = puVar8;
    uVar7 = uVar9;
    do {
      uVar12 = *puVar4;
      uVar13 = puVar4[1];
      puVar4 = puVar4 + 2;
      uVar7 = uVar7 - 2;
      *puVar6 = uVar12;
      puVar6[1] = uVar13;
      puVar6 = puVar6 + 2;
    } while (uVar7 != 0);
    if (uVar2 - uVar9 != 0) goto LAB_0001965a;
  }
  if (0 < (int)uVar2) {
    pdVar5 = (double *)*puStack_20;
    do {
      dVar14 = *pdVar5;
      if (dVar14 != 6.25 && dVar14 < 6.25 == NAN(dVar14)) {
        *(undefined4 *)pdVar5 = 0;
        *(undefined4 *)((int)pdVar5 + 4) = 0x40190000;
      }
      pdVar5 = pdVar5 + 1;
      uVar2 = uVar2 - 1;
    } while (uVar2 != 0);
  }
LAB_000196a2:
  emxInit_real_T(&piStack_24,1);
  b_log(puStack_20);
  c_power(puStack_20,piStack_24);
  emxEnsureCapacity_real_T1(piStack_24,*(undefined4 *)piStack_24[1]);
  iVar3 = *(int *)piStack_24[1];
  if (0 < iVar3) {
    pdVar5 = (double *)*piStack_24;
    do {
      iVar3 = iVar3 + -1;
      *pdVar5 = (*pdVar5 + -1.861) * 1.794;
      pdVar5 = pdVar5 + 1;
    } while (iVar3 != 0);
  }
  b_power(piStack_24,puStack_20);
  emxEnsureCapacity_real_T1(puStack_20,*(undefined4 *)puStack_20[1]);
  iVar3 = *(int *)puStack_20[1];
  emxFree_real_T(&piStack_24);
  if (0 < iVar3) {
    pdVar5 = (double *)*puStack_20;
    do {
      iVar3 = iVar3 + -1;
      *pdVar5 = *pdVar5 * 10.0;
      pdVar5 = pdVar5 + 1;
    } while (iVar3 != 0);
  }
  uVar12 = c_nanmean();
  emxFree_real_T(&puStack_20);
  if (__stack_chk_guard == iStack_1c) {
    return uVar12;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iStack_1c,__stack_chk_guard);
}



undefined8 Java_com_microtechmd_cgat_CGA_getHBGI(int *param_1,undefined4 param_2)

{
  uint *puVar1;
  uint uVar2;
  int iVar3;
  undefined8 *puVar4;
  double *pdVar5;
  undefined8 *puVar6;
  uint uVar7;
  undefined8 *puVar8;
  uint uVar9;
  undefined8 *puVar10;
  bool bVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  int *piStack_24;
  uint *puStack_20;
  int iStack_1c;
  
  puVar1 = (uint *)(**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (puVar1 == (uint *)0x0) {
    return rtNaN;
  }
  iStack_1c = __stack_chk_guard;
  emxInit_real_T(&puStack_20,1);
  iVar3 = *(int *)puStack_20[1];
  *(int *)puStack_20[1] = ((int *)puVar1[1])[1] * *(int *)puVar1[1];
  emxEnsureCapacity_real_T1(puStack_20,iVar3);
  uVar2 = *(int *)puVar1[1] * ((int *)puVar1[1])[1];
  if ((int)uVar2 < 1) goto LAB_000188fa;
  puVar10 = (undefined8 *)*puVar1;
  puVar8 = (undefined8 *)*puStack_20;
  if (uVar2 == 1) {
LAB_000188b0:
    uVar9 = 0;
LAB_000188b2:
    puVar10 = puVar10 + uVar9;
    puVar8 = puVar8 + uVar9;
    iVar3 = uVar2 - uVar9;
    do {
      uVar12 = *puVar10;
      puVar10 = puVar10 + 1;
      iVar3 = iVar3 + -1;
      *puVar8 = uVar12;
      puVar8 = puVar8 + 1;
    } while (iVar3 != 0);
  }
  else {
    puVar4 = puVar10 + uVar2;
    bVar11 = puVar8 < puVar4;
    if (bVar11) {
      puVar4 = puVar8 + uVar2;
    }
    if (bVar11 && puVar10 < puVar4) goto LAB_000188b0;
    uVar9 = uVar2 & 0xfffffffe;
    puVar4 = puVar10;
    puVar6 = puVar8;
    uVar7 = uVar9;
    do {
      uVar12 = *puVar4;
      uVar13 = puVar4[1];
      puVar4 = puVar4 + 2;
      uVar7 = uVar7 - 2;
      *puVar6 = uVar12;
      puVar6[1] = uVar13;
      puVar6 = puVar6 + 2;
    } while (uVar7 != 0);
    if (uVar2 - uVar9 != 0) goto LAB_000188b2;
  }
  if (0 < (int)uVar2) {
    pdVar5 = (double *)*puStack_20;
    do {
      if ((int)((uint)(*pdVar5 < 6.25) << 0x1f) < 0) {
        *(undefined4 *)pdVar5 = 0;
        *(undefined4 *)((int)pdVar5 + 4) = 0x40190000;
      }
      pdVar5 = pdVar5 + 1;
      uVar2 = uVar2 - 1;
    } while (uVar2 != 0);
  }
LAB_000188fa:
  emxInit_real_T(&piStack_24,1);
  b_log(puStack_20);
  c_power(puStack_20,piStack_24);
  emxEnsureCapacity_real_T1(piStack_24,*(undefined4 *)piStack_24[1]);
  iVar3 = *(int *)piStack_24[1];
  if (0 < iVar3) {
    pdVar5 = (double *)*piStack_24;
    do {
      iVar3 = iVar3 + -1;
      *pdVar5 = (*pdVar5 + -1.861) * 1.794;
      pdVar5 = pdVar5 + 1;
    } while (iVar3 != 0);
  }
  b_power(piStack_24,puStack_20);
  emxEnsureCapacity_real_T1(puStack_20,*(undefined4 *)puStack_20[1]);
  iVar3 = *(int *)puStack_20[1];
  emxFree_real_T(&piStack_24);
  if (0 < iVar3) {
    pdVar5 = (double *)*puStack_20;
    do {
      iVar3 = iVar3 + -1;
      *pdVar5 = *pdVar5 * 10.0;
      pdVar5 = pdVar5 + 1;
    } while (iVar3 != 0);
  }
  uVar12 = c_nanmean();
  emxFree_real_T(&puStack_20);
  if (__stack_chk_guard == iStack_1c) {
    return uVar12;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iStack_1c,__stack_chk_guard);
}



// WARNING: Restarted to delay deadcode elimination for space: register

undefined8 Java_com_microtechmd_cgat_CGA_getADRR(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [16];
  undefined1 auVar2 [16];
  undefined1 auVar3 [32];
  undefined1 auVar4 [32];
  byte bVar5;
  undefined1 uVar6;
  int *piVar7;
  int iVar8;
  int iVar9;
  double *pdVar10;
  int iVar11;
  undefined1 (*pauVar12) [16];
  undefined8 *puVar13;
  undefined4 *puVar14;
  char *pcVar15;
  int iVar16;
  undefined1 (*pauVar17) [16];
  uint uVar18;
  uint uVar19;
  int *piVar20;
  uint uVar21;
  double *pdVar22;
  int iVar23;
  double *pdVar24;
  uint uVar25;
  uint uVar26;
  int iVar27;
  int iVar28;
  int iVar29;
  int iVar30;
  undefined1 (*pauVar31) [16];
  undefined1 (*pauVar32) [16];
  bool bVar33;
  uint in_fpscr;
  double dVar34;
  undefined1 in_q8 [16];
  undefined1 auVar35 [16];
  undefined1 auVar36 [16];
  double dVar37;
  undefined4 uVar38;
  ulonglong uVar39;
  undefined1 in_q10 [16];
  undefined1 auVar40 [16];
  int *piStack_50;
  int *piStack_4c;
  int *piStack_48;
  int *piStack_44;
  int *piStack_40;
  int *piStack_3c;
  int *piStack_38;
  int iStack_34;
  
  piVar7 = (int *)(**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (piVar7 == (int *)0x0) {
    return rtNaN;
  }
  iStack_34 = __stack_chk_guard;
  emxInit_real_T1(&piStack_38,2);
  iVar27 = piVar7[1];
  piVar20 = (int *)piStack_38[1];
  iVar16 = *piVar20;
  iVar23 = piVar20[1];
  *piVar20 = 1;
  piVar20[1] = *(int *)(iVar27 + 4);
  emxEnsureCapacity_real_T(piStack_38,iVar23 * iVar16);
  if (0 < ((int *)piVar7[1])[1]) {
    iVar27 = *(int *)piVar7[1];
    iVar30 = 8;
    iVar16 = 1;
    iVar23 = 0;
    do {
      iVar11 = iVar16;
      iVar16 = iVar23 * iVar27;
      dVar34 = *(double *)(*piVar7 + iVar16 * 8);
      if (1 < iVar27) {
        iVar29 = iVar23 * iVar27 + iVar27;
        iVar8 = rtIsNaN(SUB84(dVar34,0),(int)((ulonglong)dVar34 >> 0x20));
        if (iVar8 == 0) {
          iVar16 = iVar16 + 1;
        }
        else {
          iVar8 = iVar16 + 2;
          iVar28 = iVar30;
          do {
            iVar16 = iVar8;
            in_q8._0_8_ = *(double *)(*piVar7 + iVar28);
            iVar9 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
            if (iVar9 == 0) {
              dVar34 = *(double *)(*piVar7 + iVar28);
              break;
            }
            if (iVar29 <= iVar16) break;
            iVar28 = iVar28 + 8;
            iVar8 = iVar16 + 1;
          } while (iVar9 != 0);
        }
        if (iVar16 < iVar29) {
          pdVar10 = (double *)(*piVar7 + iVar16 * 8);
          do {
            in_q8._0_8_ = *pdVar10;
            pdVar10 = pdVar10 + 1;
            iVar16 = iVar16 + 1;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < dVar34) << 0x1f |
                       (uint)(in_q8._0_8_ == dVar34) << 0x1e | (uint)(dVar34 <= in_q8._0_8_) << 0x1d
            ;
            if ((int)in_fpscr < 0) {
              dVar34 = in_q8._0_8_;
            }
          } while (iVar16 < iVar29);
        }
      }
      iVar30 = iVar30 + iVar27 * 8;
      iVar8 = *(int *)(piVar7[1] + 4);
      *(double *)(*piStack_38 + iVar23 * 8) = dVar34;
      iVar16 = iVar11 + 1;
      iVar23 = iVar11;
    } while (iVar11 < iVar8);
  }
  emxInit_real_T1(&piStack_3c,2);
  iVar27 = piVar7[1];
  piVar20 = (int *)piStack_3c[1];
  iVar16 = *piVar20;
  iVar23 = piVar20[1];
  *piVar20 = 1;
  piVar20[1] = *(int *)(iVar27 + 4);
  emxEnsureCapacity_real_T(piStack_3c,iVar23 * iVar16);
  if (0 < ((int *)piVar7[1])[1]) {
    iVar27 = *(int *)piVar7[1];
    iVar30 = 8;
    iVar16 = 1;
    iVar23 = 0;
    do {
      iVar11 = iVar16;
      iVar16 = iVar23 * iVar27;
      dVar34 = *(double *)(*piVar7 + iVar16 * 8);
      if (1 < iVar27) {
        iVar29 = iVar23 * iVar27 + iVar27;
        iVar8 = rtIsNaN(SUB84(dVar34,0),(int)((ulonglong)dVar34 >> 0x20));
        if (iVar8 == 0) {
          iVar16 = iVar16 + 1;
        }
        else {
          iVar8 = iVar16 + 2;
          iVar28 = iVar30;
          do {
            iVar16 = iVar8;
            in_q8._0_8_ = *(double *)(*piVar7 + iVar28);
            iVar9 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
            if (iVar9 == 0) {
              dVar34 = *(double *)(*piVar7 + iVar28);
              break;
            }
            if (iVar29 <= iVar16) break;
            iVar28 = iVar28 + 8;
            iVar8 = iVar16 + 1;
          } while (iVar9 != 0);
        }
        if (iVar16 < iVar29) {
          pdVar10 = (double *)(*piVar7 + iVar16 * 8);
          do {
            in_q8._0_8_ = *pdVar10;
            pdVar10 = pdVar10 + 1;
            iVar16 = iVar16 + 1;
            uVar25 = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < dVar34) << 0x1f |
                     (uint)(in_q8._0_8_ == dVar34) << 0x1e;
            in_fpscr = uVar25 | (uint)(NAN(in_q8._0_8_) || NAN(dVar34)) << 0x1c;
            bVar5 = (byte)(uVar25 >> 0x18);
            if (!(bool)(bVar5 >> 6 & 1) && bVar5 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              dVar34 = in_q8._0_8_;
            }
          } while (iVar16 < iVar29);
        }
      }
      iVar30 = iVar30 + iVar27 * 8;
      iVar8 = *(int *)(piVar7[1] + 4);
      *(double *)(*piStack_3c + iVar23 * 8) = dVar34;
      iVar16 = iVar11 + 1;
      iVar23 = iVar11;
    } while (iVar11 < iVar8);
  }
  emxInit_real_T1(&piStack_40,2);
  emxInit_real_T1(&piStack_44,2);
  FUN_00015998(piStack_3c,piStack_40);
  iVar23 = piStack_40[1];
  piVar7 = (int *)piStack_44[1];
  uVar25 = *(uint *)(iVar23 + 4);
  iVar16 = *piVar7;
  iVar27 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(iVar23 + 4);
  emxEnsureCapacity_real_T(piStack_44,iVar27 * iVar16);
  if (0 < (int)uVar25) {
    pauVar31 = (undefined1 (*) [16])*piStack_40;
    pauVar32 = (undefined1 (*) [16])*piStack_44;
    if (uVar25 == 1) {
      uVar21 = 0;
    }
    else {
      pauVar12 = (undefined1 (*) [16])(*pauVar31 + uVar25 * 8);
      uVar21 = 0;
      bVar33 = pauVar32 < pauVar12;
      if (bVar33) {
        pauVar12 = (undefined1 (*) [16])(*pauVar32 + uVar25 * 8);
      }
      if (!bVar33 || pauVar12 <= pauVar31) {
        uVar21 = uVar25 & 0xfffffffe;
        pauVar12 = pauVar31;
        pauVar17 = pauVar32;
        uVar18 = uVar21;
        do {
          in_q8 = *pauVar12;
          pauVar12 = pauVar12 + 1;
          dVar34 = in_q8._0_8_;
          uVar26 = (uint)(dVar34 != 0.0 && dVar34 < 0.0 == NAN(dVar34));
          dVar34 = in_q8._8_8_;
          uVar19 = in_fpscr & 0xfffffff | (uint)(dVar34 < 0.0) << 0x1f |
                   (uint)(dVar34 == 0.0) << 0x1e;
          in_fpscr = uVar19 | (uint)NAN(dVar34) << 0x1c;
          bVar5 = (byte)(uVar19 >> 0x18);
          uVar19 = (uint)(!(bool)(bVar5 >> 6 & 1) && bVar5 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1));
          if (uVar19 != 0) {
            uVar19 = 0xffffffff;
          }
          auVar35._12_4_ = uVar19;
          auVar35._8_4_ = uVar19;
          if (uVar26 != 0) {
            uVar26 = 0xffffffff;
          }
          auVar35._4_4_ = uVar26;
          auVar35._0_4_ = uVar26;
          in_q8 = in_q8 & auVar35;
          uVar18 = uVar18 - 2;
          *(longlong *)*pauVar17 = in_q8._0_8_;
          *(longlong *)(*pauVar17 + 8) = in_q8._8_8_;
          pauVar17 = pauVar17 + 1;
        } while (uVar18 != 0);
        if (uVar25 == uVar21) goto LAB_00015556;
      }
    }
    puVar13 = (undefined8 *)(*pauVar32 + uVar21 * 8);
    pdVar10 = (double *)(*pauVar31 + uVar21 * 8);
    iVar16 = uVar25 - uVar21;
    do {
      in_q8._0_8_ = *pdVar10;
      in_q8._8_8_ = 0;
      pdVar10 = pdVar10 + 1;
      uVar25 = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < 0.0) << 0x1f |
               (uint)(in_q8._0_8_ == 0.0) << 0x1e;
      in_fpscr = uVar25 | (uint)NAN(in_q8._0_8_) << 0x1c;
      bVar5 = (byte)(uVar25 >> 0x18);
      if (!(bool)(bVar5 >> 6 & 1) && bVar5 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
        in_q8._8_8_ = in_q8._0_8_;
      }
      *puVar13 = in_q8._8_8_;
      puVar13 = puVar13 + 1;
      iVar16 = iVar16 + -1;
    } while (iVar16 != 0);
  }
LAB_00015556:
  emxInit_boolean_T1(&piStack_48,2);
  piVar7 = (int *)piStack_48[1];
  iVar23 = piStack_40[1];
  iVar16 = *piVar7;
  iVar27 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(iVar23 + 4);
  emxEnsureCapacity_boolean_T1(piStack_48,iVar27 * iVar16);
  iVar16 = ((int *)piStack_40[1])[1] * *(int *)piStack_40[1];
  if (0 < iVar16) {
    in_q8._0_8_ = *(double *)*piStack_40;
    uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
    *(undefined1 *)*piStack_48 = uVar6;
    if (iVar16 != 1) {
      iVar23 = 1;
      iVar27 = 8;
      do {
        in_q8._0_8_ = *(double *)(*piStack_40 + iVar27);
        uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
        iVar27 = iVar27 + 8;
        *(undefined1 *)(*piStack_48 + iVar23) = uVar6;
        iVar23 = iVar23 + 1;
      } while (iVar16 - iVar23 != 0);
    }
  }
  uVar25 = *(uint *)(piStack_48[1] + 4);
  if ((int)uVar25 < 1) {
    iVar16 = 0;
  }
  else {
    if (uVar25 < 4) {
      uVar18 = 0;
      iVar16 = 0;
    }
    else {
      uVar18 = uVar25 & 0xfffffffc;
      auVar35 = ZEXT816(0);
      auVar1 = SIMDExpandImmediate(0,0,1);
      puVar14 = (undefined4 *)*piStack_48;
      uVar21 = uVar18;
      do {
        in_q8._8_8_ = in_q10._0_8_;
        uVar21 = uVar21 - 4;
                    // WARNING: Ignoring partial resolution of indirect
        uVar38 = *puVar14;
        auVar40 = VectorCopyLong(in_q8._8_8_,1,1);
        uVar39 = VectorCompareEqual(auVar40._0_8_,0,2);
        in_q10 = VectorCopyLong(~uVar39,2,1);
        in_q10 = in_q10 & auVar1;
        auVar35 = VectorAdd(auVar35,in_q10,4);
        puVar14 = puVar14 + 1;
      } while (uVar21 != 0);
      auVar3._16_16_ = auVar35;
      auVar3._0_16_ = auVar35;
      auVar35 = VectorAdd(auVar35,auVar3._8_16_,4);
      in_q8._8_8_ = CONCAT44(auVar35._4_4_,auVar35._4_4_);
      auVar1._8_8_ = in_q8._8_8_;
      auVar1._0_8_ = in_q8._8_8_;
      in_q8 = VectorAdd(auVar35,auVar1,4);
      iVar16 = in_q8._0_4_;
      if (uVar25 == uVar18) goto LAB_00015646;
    }
    iVar23 = uVar25 - uVar18;
    pcVar15 = (char *)(*piStack_48 + uVar18);
    do {
      if (*pcVar15 != '\0') {
        iVar16 = iVar16 + 1;
      }
      iVar23 = iVar23 + -1;
      pcVar15 = pcVar15 + 1;
    } while (iVar23 != 0);
  }
LAB_00015646:
  emxInit_int32_T(&piStack_4c,2);
  piVar7 = (int *)piStack_4c[1];
  iVar23 = *piVar7;
  iVar27 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = iVar16;
  emxEnsureCapacity_int32_T(piStack_4c,iVar27 * iVar23);
  if (0 < (int)uVar25) {
    uVar21 = 0;
    iVar16 = *piStack_48;
    iVar23 = 0;
    do {
      pcVar15 = (char *)(iVar16 + uVar21);
      uVar21 = uVar21 + 1;
      if (*pcVar15 != '\0') {
        *(uint *)(*piStack_4c + iVar23 * 4) = uVar21;
        iVar23 = iVar23 + 1;
      }
    } while (uVar25 != uVar21);
  }
  iVar16 = *(int *)piStack_4c[1] * ((int *)piStack_4c[1])[1];
  if (0 < iVar16) {
    iVar23 = *piStack_44;
    piVar7 = (int *)*piStack_4c;
    do {
      iVar16 = iVar16 + -1;
      in_q8._0_8_ = (double)rtNaN;
      *(undefined8 *)(iVar23 + *piVar7 * 8 + -8) = rtNaN;
      piVar7 = piVar7 + 1;
    } while (iVar16 != 0);
  }
  emxFree_int32_T(&piStack_4c);
  FUN_00015998(piStack_38,piStack_3c);
  piVar7 = (int *)piStack_38[1];
  iVar23 = piStack_3c[1];
  iVar16 = *piVar7;
  iVar27 = piVar7[1];
  uVar25 = *(uint *)(iVar23 + 4);
  *piVar7 = 1;
  piVar7[1] = *(int *)(iVar23 + 4);
  emxEnsureCapacity_real_T(piStack_38,iVar27 * iVar16);
  if (0 < (int)uVar25) {
    pauVar32 = (undefined1 (*) [16])*piStack_3c;
    pauVar31 = (undefined1 (*) [16])*piStack_38;
    if (uVar25 == 1) {
      uVar21 = 0;
    }
    else {
      pauVar12 = (undefined1 (*) [16])(*pauVar32 + uVar25 * 8);
      uVar21 = 0;
      bVar33 = pauVar31 < pauVar12;
      if (bVar33) {
        pauVar12 = (undefined1 (*) [16])(*pauVar31 + uVar25 * 8);
      }
      if (!bVar33 || pauVar12 <= pauVar32) {
        uVar21 = uVar25 & 0xfffffffe;
        pauVar12 = pauVar32;
        pauVar17 = pauVar31;
        uVar18 = uVar21;
        do {
          in_q8 = *pauVar12;
          pauVar12 = pauVar12 + 1;
          dVar34 = in_q8._0_8_;
          uVar19 = (uint)((int)(in_fpscr & 0xfffffff | (uint)(dVar34 < 0.0) << 0x1f |
                                (uint)(dVar34 == 0.0) << 0x1e | (uint)(0.0 <= dVar34) << 0x1d) < 0);
          dVar34 = in_q8._8_8_;
          in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar34 < 0.0) << 0x1f |
                     (uint)(dVar34 == 0.0) << 0x1e | (uint)(0.0 <= dVar34) << 0x1d;
          uVar26 = (uint)((int)in_fpscr < 0);
          if (uVar26 != 0) {
            uVar26 = 0xffffffff;
          }
          auVar40._12_4_ = uVar26;
          auVar40._8_4_ = uVar26;
          if (uVar19 != 0) {
            uVar19 = 0xffffffff;
          }
          auVar40._4_4_ = uVar19;
          auVar40._0_4_ = uVar19;
          in_q8 = in_q8 & auVar40;
          uVar18 = uVar18 - 2;
          *(longlong *)*pauVar17 = in_q8._0_8_;
          *(longlong *)(*pauVar17 + 8) = in_q8._8_8_;
          pauVar17 = pauVar17 + 1;
        } while (uVar18 != 0);
        if (uVar25 == uVar21) goto LAB_0001578a;
      }
    }
    puVar13 = (undefined8 *)(*pauVar31 + uVar21 * 8);
    pdVar10 = (double *)(*pauVar32 + uVar21 * 8);
    iVar16 = uVar25 - uVar21;
    do {
      in_q8._0_8_ = *pdVar10;
      in_q8._8_8_ = 0;
      pdVar10 = pdVar10 + 1;
      in_fpscr = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < 0.0) << 0x1f |
                 (uint)(in_q8._0_8_ == 0.0) << 0x1e | (uint)(0.0 <= in_q8._0_8_) << 0x1d;
      if ((int)in_fpscr < 0) {
        in_q8._8_8_ = in_q8._0_8_;
      }
      *puVar13 = in_q8._8_8_;
      puVar13 = puVar13 + 1;
      iVar16 = iVar16 + -1;
    } while (iVar16 != 0);
  }
LAB_0001578a:
  iVar27 = piStack_3c[1];
  piVar7 = (int *)piStack_48[1];
  iVar16 = *piVar7;
  iVar23 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(iVar27 + 4);
  emxEnsureCapacity_boolean_T1(piStack_48,iVar23 * iVar16);
  iVar16 = ((int *)piStack_3c[1])[1] * *(int *)piStack_3c[1];
  if (0 < iVar16) {
    in_q8._0_8_ = *(double *)*piStack_3c;
    uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
    *(undefined1 *)*piStack_48 = uVar6;
    if (iVar16 != 1) {
      iVar23 = 1;
      iVar27 = 8;
      do {
        in_q8._0_8_ = *(double *)(*piStack_3c + iVar27);
        uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
        iVar27 = iVar27 + 8;
        *(undefined1 *)(*piStack_48 + iVar23) = uVar6;
        iVar23 = iVar23 + 1;
      } while (iVar16 - iVar23 != 0);
    }
  }
  uVar25 = *(uint *)(piStack_48[1] + 4);
  if ((int)uVar25 < 1) {
    iVar16 = 0;
  }
  else {
    if (uVar25 < 4) {
      uVar18 = 0;
      iVar16 = 0;
    }
    else {
      uVar18 = uVar25 & 0xfffffffc;
      auVar35 = ZEXT816(0);
      auVar1 = SIMDExpandImmediate(0,0,1);
      puVar14 = (undefined4 *)*piStack_48;
      uVar21 = uVar18;
      do {
        in_q8._8_8_ = in_q10._0_8_;
        uVar21 = uVar21 - 4;
                    // WARNING: Ignoring partial resolution of indirect
        uVar38 = *puVar14;
        auVar40 = VectorCopyLong(in_q8._8_8_,1,1);
        uVar39 = VectorCompareEqual(auVar40._0_8_,0,2);
        in_q10 = VectorCopyLong(~uVar39,2,1);
        in_q10 = in_q10 & auVar1;
        auVar35 = VectorAdd(auVar35,in_q10,4);
        puVar14 = puVar14 + 1;
      } while (uVar21 != 0);
      auVar4._16_16_ = auVar35;
      auVar4._0_16_ = auVar35;
      auVar35 = VectorAdd(auVar35,auVar4._8_16_,4);
      in_q8._8_8_ = CONCAT44(auVar35._4_4_,auVar35._4_4_);
      auVar2._8_8_ = in_q8._8_8_;
      auVar2._0_8_ = in_q8._8_8_;
      in_q8 = VectorAdd(auVar35,auVar2,4);
      iVar16 = in_q8._0_4_;
      if (uVar25 == uVar18) goto LAB_0001586c;
    }
    iVar23 = uVar25 - uVar18;
    pcVar15 = (char *)(*piStack_48 + uVar18);
    do {
      if (*pcVar15 != '\0') {
        iVar16 = iVar16 + 1;
      }
      iVar23 = iVar23 + -1;
      pcVar15 = pcVar15 + 1;
    } while (iVar23 != 0);
  }
LAB_0001586c:
  emxInit_int32_T(&piStack_50,2);
  piVar7 = (int *)piStack_50[1];
  iVar23 = *piVar7;
  iVar27 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = iVar16;
  emxEnsureCapacity_int32_T(piStack_50,iVar27 * iVar23);
  if (0 < (int)uVar25) {
    uVar21 = 0;
    iVar23 = 0;
    iVar16 = *piStack_48;
    do {
      pcVar15 = (char *)(iVar16 + uVar21);
      uVar21 = uVar21 + 1;
      if (*pcVar15 != '\0') {
        *(uint *)(*piStack_50 + iVar23 * 4) = uVar21;
        iVar23 = iVar23 + 1;
      }
    } while (uVar25 != uVar21);
  }
  emxFree_boolean_T(&piStack_48);
  iVar16 = *(int *)piStack_50[1] * ((int *)piStack_50[1])[1];
  if (0 < iVar16) {
    iVar23 = *piStack_38;
    piVar7 = (int *)*piStack_50;
    do {
      iVar16 = iVar16 + -1;
      in_q8._0_8_ = (double)rtNaN;
      *(undefined8 *)(iVar23 + *piVar7 * 8 + -8) = rtNaN;
      piVar7 = piVar7 + 1;
    } while (iVar16 != 0);
  }
  emxFree_int32_T(&piStack_50);
  power(piStack_44,piStack_40);
  power(piStack_38,piStack_3c);
  piVar7 = (int *)piStack_38[1];
  iVar23 = piStack_40[1];
  iVar16 = *piVar7;
  iVar27 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(iVar23 + 4);
  emxEnsureCapacity_real_T(piStack_38,iVar27 * iVar16);
  iVar23 = *(int *)piStack_40[1];
  iVar16 = ((int *)piStack_40[1])[1];
  emxFree_real_T(&piStack_44);
  iVar16 = iVar16 * iVar23;
  if (0 < iVar16) {
    auVar36._8_8_ = (double)in_q8._8_8_;
    auVar36._0_8_ = 10.0;
    pdVar22 = (double *)*piStack_3c;
    pdVar24 = (double *)*piStack_40;
    pdVar10 = (double *)*piStack_38;
    do {
      dVar34 = *pdVar22;
      pdVar22 = pdVar22 + 1;
      dVar37 = *pdVar24;
      pdVar24 = pdVar24 + 1;
      iVar16 = iVar16 + -1;
      auVar36._8_8_ = (dVar37 + dVar34) * auVar36._0_8_;
      *pdVar10 = auVar36._8_8_;
      pdVar10 = pdVar10 + 1;
    } while (iVar16 != 0);
  }
  emxFree_real_T(&piStack_40);
  emxFree_real_T(&piStack_3c);
  in_q8._8_8_ = nanmean(piStack_38);
  emxFree_real_T(&piStack_38);
  if (__stack_chk_guard == iStack_34) {
    return in_q8._8_8_;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iStack_34,__stack_chk_guard);
}



void Java_com_microtechmd_cgat_CGA_getGRADE
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
               undefined8 param_5)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 local_48;
  undefined8 uStack_40;
  undefined8 local_38;
  undefined8 uStack_30;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar1 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar1 != 0) {
    local_48 = 0;
    uStack_40 = 0;
    local_38 = 0;
    uStack_30 = 0;
    GRADE(iVar1,&local_38,param_3,param_4,param_5,&local_48);
    uVar2 = (**(code **)(*param_1 + 0x2d8))(param_1,4);
    (**(code **)(*param_1 + 0x358))(param_1,uVar2,0,4,&local_48);
  }
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getLAGE(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar4 == 0) goto LAB_0001443e;
  emxInitArray_real_T(&local_28,2);
  LAGE(iVar4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_0001440a;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_0001440a:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_0001443e:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getMAGE
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 extraout_r1;
  int iVar5;
  int iVar6;
  int iVar7;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar2 != 0) {
    emxInitArray_real_T(&local_2c,2);
    MAGE(iVar2,extraout_r1,param_3,param_4,local_2c);
    piVar1 = local_2c;
    if ((local_2c != (int *)0x0) && (local_2c[3] == 2)) {
      iVar6 = *(int *)local_2c[1];
      iVar2 = ((int *)local_2c[1])[1];
      uVar3 = (**(code **)(*param_1 + 0x18))(param_1,&DAT_00012b91);
      uVar3 = (**(code **)(*param_1 + 0x2b0))(param_1,iVar2,uVar3,0);
      if (0 < iVar2) {
        iVar7 = 0;
        iVar5 = 0;
        do {
          uVar4 = (**(code **)(*param_1 + 0x2d8))(param_1,iVar6);
          (**(code **)(*param_1 + 0x358))(param_1,uVar4,0,iVar6,*piVar1 + iVar7);
          (**(code **)(*param_1 + 0x2b8))(param_1,uVar3,iVar5,uVar4);
          iVar5 = iVar5 + 1;
          iVar7 = iVar7 + iVar6 * 8;
        } while (iVar2 != iVar5);
      }
    }
    emxDestroyArray_real_T(local_2c);
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_28);
}



void Java_com_microtechmd_cgat_CGA_getMAG
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  undefined4 extraout_r1;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar4 == 0) goto LAB_00014660;
  emxInitArray_real_T(&local_28,2);
  MAG(iVar4,extraout_r1,param_3,param_4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_0001462c;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_0001462c:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_00014660:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getMODD(int *param_1,undefined4 param_2)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar4 == 0) goto LAB_0001475a;
  emxInitArray_real_T(&local_28,2);
  MODD(iVar4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_00014726;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_00014726:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_0001475a:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getCONGA
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined1 auVar1 [32];
  undefined1 auVar2 [16];
  undefined4 *puVar3;
  int iVar4;
  uint *puVar5;
  undefined4 uVar6;
  undefined4 extraout_r1;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined1 (*pauVar10) [16];
  uint uVar11;
  undefined1 auVar12 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (iVar4 == 0) goto LAB_00014860;
  emxInitArray_real_T(&local_28,2);
  CONGA(iVar4,extraout_r1,param_3,param_4,local_28);
  puVar3 = local_28;
  if (local_28 == (undefined4 *)0x0) {
    local_28 = (undefined4 *)0x0;
  }
  else {
    puVar5 = (uint *)local_28[1];
    iVar4 = local_28[3];
    uVar9 = *puVar5;
    if (1 < iVar4) {
      uVar8 = iVar4 - 1;
      iVar7 = 1;
      if (3 < uVar8) {
        uVar11 = uVar8 & 0xfffffffc;
        pauVar10 = (undefined1 (*) [16])(puVar5 + 1);
        iVar7 = uVar11 + 1;
        auVar12._0_8_ = (ulonglong)uVar9 & 0xffff | 0x100000000;
        auVar12._8_8_ = 0x100000001;
        uVar9 = uVar11;
        do {
          auVar2 = *pauVar10;
          pauVar10 = pauVar10 + 1;
          uVar9 = uVar9 - 4;
          auVar12 = VectorMultiply(auVar2,auVar12,4);
        } while (uVar9 != 0);
        auVar1._16_16_ = auVar12;
        auVar1._0_16_ = auVar12;
        auVar12 = VectorMultiply(auVar12,auVar1._8_16_,4);
        uVar6 = VectorGetElement(auVar12._0_8_,1,4,0);
        auVar12 = VectorMultiply(auVar12,uVar6,4);
        uVar9 = auVar12._0_4_;
        if (uVar8 == uVar11) goto LAB_0001482c;
      }
      iVar4 = iVar4 - iVar7;
      puVar5 = puVar5 + iVar7;
      do {
        iVar4 = iVar4 + -1;
        uVar9 = *puVar5 * uVar9;
        puVar5 = puVar5 + 1;
      } while (iVar4 != 0);
    }
LAB_0001482c:
    uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,uVar9);
    (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,uVar9,*puVar3);
  }
  emxDestroyArray_real_T(local_28);
LAB_00014860:
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_24);
}



void Java_com_microtechmd_cgat_CGA_getPentagon(int *param_1,undefined4 param_2)

{
  int *piVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  undefined4 uVar5;
  undefined4 uVar6;
  int iVar7;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar2 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b4c);
  if (((iVar2 != 0) &&
      (iVar3 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b54), iVar3 != 0)) &&
     (iVar4 = (**(code **)(*param_1 + 0x194))(param_1,param_2,DAT_00024b5c), iVar4 != 0)) {
    emxInitArray_real_T(&local_2c,2);
    Pentagon(iVar2,iVar3,iVar4,local_2c);
    piVar1 = local_2c;
    if ((local_2c != (int *)0x0) && (local_2c[3] == 2)) {
      iVar2 = *(int *)local_2c[1];
      iVar3 = ((int *)local_2c[1])[1];
      uVar5 = (**(code **)(*param_1 + 0x18))(param_1,&DAT_00012b91);
      uVar5 = (**(code **)(*param_1 + 0x2b0))(param_1,iVar3,uVar5,0);
      if (0 < iVar3) {
        iVar7 = 0;
        iVar4 = 0;
        do {
          uVar6 = (**(code **)(*param_1 + 0x2d8))(param_1,iVar2);
          (**(code **)(*param_1 + 0x358))(param_1,uVar6,0,iVar2,*piVar1 + iVar7);
          (**(code **)(*param_1 + 0x2b8))(param_1,uVar5,iVar4,uVar6);
          iVar4 = iVar4 + 1;
          iVar7 = iVar7 + iVar2 * 8;
        } while (iVar3 != iVar4);
      }
    }
    emxDestroyArray_real_T(local_2c);
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_28);
}



void Java_com_microtechmd_cgat_CGATools_smoothMean
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
               undefined4 param_5)

{
  undefined4 uVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  undefined1 uStack_29;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uStack_29 = 1;
  uVar1 = (**(code **)(*param_1 + 0x2f4))(param_1,param_3,&uStack_29);
  uVar2 = (**(code **)(*param_1 + 0x2f4))(param_1,param_3,0);
  smooth_mean(uVar1,uVar2,param_4,param_5);
  uVar3 = (**(code **)(*param_1 + 0x2d4))(param_1,param_4);
  (**(code **)(*param_1 + 0x354))(param_1,uVar3,0,param_4,uVar1);
  (**(code **)(*param_1 + 0x314))(param_1,param_3,uVar1,0);
  (**(code **)(*param_1 + 0x314))(param_1,param_3,uVar2,0);
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_28);
  }
  return;
}



undefined4
Java_com_microtechmd_cgat_CGATools_smoothGauss
          (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,undefined4 param_5)

{
  undefined4 uVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  
  uVar1 = (**(code **)(*param_1 + 0x2d4))(param_1,param_4);
  uVar2 = (**(code **)(*param_1 + 0x2f4))(param_1,uVar1,0);
  uVar3 = (**(code **)(*param_1 + 0x2f4))(param_1,param_3,0);
  smooth_gauss(uVar2,uVar3,param_4,param_5);
  (**(code **)(*param_1 + 0x354))(param_1,uVar1,0,param_4,uVar2);
  return uVar1;
}



void b_abs(int *param_1,int *param_2)

{
  int iVar1;
  undefined4 uVar2;
  double *pdVar3;
  double *pdVar4;
  double dVar5;
  
  uVar2 = *(undefined4 *)param_2[1];
  *(undefined4 *)param_2[1] = *(undefined4 *)param_1[1];
  emxEnsureCapacity_real_T1(param_2,uVar2);
  iVar1 = *(int *)param_1[1];
  if (0 < iVar1) {
    pdVar3 = (double *)*param_2;
    pdVar4 = (double *)*param_1;
    do {
      dVar5 = *pdVar4;
      pdVar4 = pdVar4 + 1;
      iVar1 = iVar1 + -1;
      *pdVar3 = ABS(dVar5);
      pdVar3 = pdVar3 + 1;
    } while (iVar1 != 0);
  }
  return;
}



void AAC(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  undefined1 uVar1;
  uint uVar2;
  uint uVar3;
  uint *puVar4;
  undefined4 uVar5;
  int iVar6;
  undefined8 *puVar7;
  double *pdVar8;
  int iVar9;
  uint uVar10;
  double *pdVar11;
  uint uVar12;
  int *piVar13;
  uint uVar14;
  undefined8 *puVar15;
  undefined8 *puVar16;
  uint uVar17;
  undefined8 *puVar18;
  int iVar19;
  int iVar20;
  bool bVar21;
  undefined8 uVar22;
  double dVar23;
  undefined8 uVar24;
  double dVar25;
  int *local_58;
  int *local_54;
  int *local_50;
  int *local_4c;
  uint *local_48;
  int local_44;
  
  local_44 = __stack_chk_guard;
  uVar2 = param_1[1];
  piVar13 = (int *)param_5[1];
  iVar6 = *piVar13;
  iVar9 = piVar13[1];
  *piVar13 = 1;
  piVar13[1] = *(int *)(uVar2 + 4) + 1;
  emxEnsureCapacity_real_T(param_5,iVar9 * iVar6);
  uVar22 = rtNaN;
  iVar6 = *(int *)(param_1[1] + 4);
  if (-1 < iVar6) {
    uVar2 = iVar6 + 1;
    puVar16 = (undefined8 *)*param_5;
    if (uVar2 < 2) {
      uVar3 = 0;
    }
    else if ((&rtNaN < puVar16) || (puVar16 + iVar6 + 1 < (undefined8 *)((int)&rtNaN + 1))) {
      uVar3 = uVar2 & 0xfffffffe;
      puVar15 = puVar16;
      uVar14 = uVar3;
      do {
        *puVar15 = uVar22;
        puVar15[1] = uVar22;
        puVar15 = puVar15 + 2;
        uVar14 = uVar14 - 2;
      } while (uVar14 != 0);
      if (uVar2 == uVar3) goto LAB_00014bd2;
    }
    else {
      uVar3 = 0;
    }
    puVar16 = puVar16 + uVar3;
    iVar6 = (iVar6 - uVar3) + 1;
    do {
      iVar6 = iVar6 + -1;
      *puVar16 = rtNaN;
      puVar16 = puVar16 + 1;
    } while (iVar6 != 0);
  }
LAB_00014bd2:
  emxInit_real_T(&local_48,1);
  emxInit_real_T(&local_4c,1);
  emxInit_boolean_T(&local_50,1);
  emxInit_boolean_T(&local_54,1);
  emxInit_real_T(&local_58,1);
  puVar4 = (uint *)param_1[1];
  uVar2 = puVar4[1];
  if (-1 < (int)uVar2) {
    iVar6 = 0;
    uVar14 = 0;
    do {
      uVar3 = uVar14 + 1;
      if ((int)uVar2 >> 0x1f < (int)(uint)(uVar2 < uVar3)) {
        iVar9 = *(int *)local_48[1];
        *(int *)local_48[1] = *puVar4 * uVar2;
        emxEnsureCapacity_real_T1(local_48,iVar9);
        uVar2 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar2) {
          puVar16 = (undefined8 *)*param_1;
          puVar15 = (undefined8 *)*local_48;
          if (uVar2 == 1) {
LAB_00014d12:
            uVar17 = 0;
          }
          else {
            puVar18 = puVar16 + uVar2;
            bVar21 = puVar15 < puVar18;
            if (bVar21) {
              puVar18 = puVar15 + uVar2;
            }
            if (bVar21 && puVar16 < puVar18) goto LAB_00014d12;
            uVar17 = uVar2 & 0xfffffffe;
            puVar18 = puVar16;
            puVar7 = puVar15;
            uVar10 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar10 = uVar10 - 2;
              *puVar7 = uVar22;
              puVar7[1] = uVar24;
              puVar7 = puVar7 + 2;
            } while (uVar10 != 0);
            if (uVar2 - uVar17 == 0) goto LAB_00014d30;
          }
          puVar16 = puVar16 + uVar17;
          puVar15 = puVar15 + uVar17;
          iVar9 = uVar2 - uVar17;
          do {
            uVar22 = *puVar16;
            puVar16 = puVar16 + 1;
            iVar9 = iVar9 + -1;
            *puVar15 = uVar22;
            puVar15 = puVar15 + 1;
          } while (iVar9 != 0);
        }
      }
      else {
        uVar10 = *puVar4;
        puVar4 = (uint *)local_48[1];
        uVar17 = *puVar4;
        *puVar4 = uVar10;
        emxEnsureCapacity_real_T1(local_48,uVar17,puVar4,uVar2 - uVar3);
        if (0 < (int)uVar10) {
          uVar2 = *param_1;
          puVar16 = (undefined8 *)*local_48;
          iVar9 = *(int *)param_1[1];
          if ((uVar10 == 1) ||
             ((puVar16 < (undefined8 *)(iVar9 * uVar14 * 8 + uVar2 + uVar10 * 8) &&
              ((undefined8 *)(iVar9 * uVar14 * 8 + uVar2) < puVar16 + uVar10)))) {
            uVar17 = 0;
          }
          else {
            puVar18 = (undefined8 *)(iVar9 * iVar6 + uVar2);
            uVar17 = uVar10 & 0xfffffffe;
            puVar15 = puVar16;
            uVar12 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar12 = uVar12 - 2;
              *puVar15 = uVar22;
              puVar15[1] = uVar24;
              puVar15 = puVar15 + 2;
            } while (uVar12 != 0);
            if (uVar10 == uVar17) goto LAB_00014d30;
          }
          puVar16 = puVar16 + uVar17;
          iVar19 = uVar10 - uVar17;
          puVar15 = (undefined8 *)(uVar2 + (iVar9 * uVar14 + uVar17) * 8);
          do {
            uVar22 = *puVar15;
            puVar15 = puVar15 + 1;
            iVar19 = iVar19 + -1;
            *puVar16 = uVar22;
            puVar16 = puVar16 + 1;
          } while (iVar19 != 0);
        }
      }
LAB_00014d30:
      uVar5 = *(undefined4 *)local_4c[1];
      *(undefined4 *)local_4c[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_real_T1(local_4c,uVar5);
      iVar9 = *(int *)local_48[1];
      if (0 < iVar9) {
        pdVar8 = (double *)*local_48;
        pdVar11 = (double *)*local_4c;
        do {
          dVar23 = *pdVar8;
          pdVar8 = pdVar8 + 1;
          iVar9 = iVar9 + -1;
          *pdVar11 = (double)CONCAT44(param_4,param_3) - dVar23;
          pdVar11 = pdVar11 + 1;
        } while (iVar9 != 0);
      }
      uVar5 = *(undefined4 *)local_58[1];
      *(undefined4 *)local_58[1] = *(undefined4 *)local_4c[1];
      emxEnsureCapacity_real_T1(local_58,uVar5);
      iVar9 = *(int *)local_4c[1];
      if (0 < iVar9) {
        pdVar8 = (double *)*local_4c;
        pdVar11 = (double *)*local_58;
        do {
          dVar23 = *pdVar8;
          dVar25 = 0.0;
          pdVar8 = pdVar8 + 1;
          if (dVar23 != 0.0 && dVar23 < 0.0 == NAN(dVar23)) {
            dVar25 = 1.0;
          }
          iVar9 = iVar9 + -1;
          *pdVar11 = dVar23 * dVar25;
          pdVar11 = pdVar11 + 1;
        } while (iVar9 != 0);
      }
      dVar23 = (double)nansum(local_58);
      uVar5 = *(undefined4 *)local_50[1];
      *(undefined4 *)local_50[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_boolean_T(local_50,uVar5);
      iVar9 = *(int *)local_48[1];
      if (0 < iVar9) {
        uVar1 = rtIsNaN((int)*(undefined8 *)*local_48,
                        (int)((ulonglong)*(undefined8 *)*local_48 >> 0x20));
        *(undefined1 *)*local_50 = uVar1;
        if (iVar9 != 1) {
          iVar20 = 1;
          iVar19 = 8;
          do {
            uVar1 = rtIsNaN((int)*(undefined8 *)(*local_48 + iVar19),
                            (int)((ulonglong)*(undefined8 *)(*local_48 + iVar19) >> 0x20));
            iVar19 = iVar19 + 8;
            *(undefined1 *)(*local_50 + iVar20) = uVar1;
            iVar20 = iVar20 + 1;
          } while (iVar9 != iVar20);
        }
      }
      uVar5 = *(undefined4 *)local_54[1];
      *(undefined4 *)local_54[1] = *(undefined4 *)local_50[1];
      emxEnsureCapacity_boolean_T(local_54,uVar5);
      iVar9 = *(int *)local_50[1];
      if ((0 < iVar9) && (*(bool *)*local_54 = *(char *)*local_50 == '\0', iVar9 != 1)) {
        iVar19 = 1;
        do {
          *(bool *)(*local_54 + iVar19) = *(char *)(*local_50 + iVar19) == '\0';
          iVar19 = iVar19 + 1;
        } while (iVar9 != iVar19);
      }
      dVar25 = (double)sum(local_54);
      iVar6 = iVar6 + 8;
      puVar4 = (uint *)param_1[1];
      uVar2 = puVar4[1];
      *(double *)(*param_5 + uVar14 * 8) = dVar23 / dVar25;
      bVar21 = (int)uVar14 < (int)uVar2;
      uVar14 = uVar3;
    } while (bVar21);
  }
  emxFree_real_T(&local_58);
  emxFree_boolean_T(&local_54);
  emxFree_boolean_T(&local_50);
  emxFree_real_T(&local_4c);
  emxFree_real_T(&local_48);
  if (__stack_chk_guard == local_44) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void b_AAC(uint *param_1,int *param_2)

{
  undefined1 uVar1;
  int *piVar2;
  uint uVar3;
  uint uVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  undefined8 *puVar8;
  double *pdVar9;
  int iVar10;
  uint uVar11;
  double *pdVar12;
  uint uVar13;
  undefined8 *puVar14;
  undefined8 *puVar15;
  uint uVar16;
  uint uVar17;
  undefined8 *puVar18;
  int iVar19;
  int iVar20;
  bool bVar21;
  undefined8 uVar22;
  double dVar23;
  undefined8 uVar24;
  double dVar25;
  int *local_58;
  int *local_54;
  int *local_50;
  int *local_4c;
  uint *local_48;
  int local_44;
  
  local_44 = __stack_chk_guard;
  piVar2 = (int *)param_2[1];
  uVar3 = param_1[1];
  iVar7 = *piVar2;
  iVar10 = piVar2[1];
  *piVar2 = 1;
  piVar2[1] = *(int *)(uVar3 + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar10 * iVar7);
  uVar22 = rtNaN;
  iVar7 = *(int *)(param_1[1] + 4);
  if (-1 < iVar7) {
    uVar3 = iVar7 + 1;
    puVar14 = (undefined8 *)*param_2;
    if (uVar3 < 2) {
      uVar4 = 0;
    }
    else if ((&rtNaN < puVar14) || (puVar14 + iVar7 + 1 < (undefined8 *)((int)&rtNaN + 1))) {
      uVar4 = uVar3 & 0xfffffffe;
      puVar15 = puVar14;
      uVar16 = uVar4;
      do {
        *puVar15 = uVar22;
        puVar15[1] = uVar22;
        puVar15 = puVar15 + 2;
        uVar16 = uVar16 - 2;
      } while (uVar16 != 0);
      if (uVar3 == uVar4) goto LAB_00014f8e;
    }
    else {
      uVar4 = 0;
    }
    puVar14 = puVar14 + uVar4;
    iVar7 = (iVar7 - uVar4) + 1;
    do {
      iVar7 = iVar7 + -1;
      *puVar14 = rtNaN;
      puVar14 = puVar14 + 1;
    } while (iVar7 != 0);
  }
LAB_00014f8e:
  emxInit_real_T(&local_48,1);
  emxInit_real_T(&local_4c,1);
  emxInit_boolean_T(&local_50,1);
  emxInit_boolean_T(&local_54,1);
  emxInit_real_T(&local_58,1);
  puVar5 = (uint *)param_1[1];
  uVar3 = puVar5[1];
  if (-1 < (int)uVar3) {
    iVar7 = 0;
    uVar16 = 0;
    do {
      uVar4 = uVar16 + 1;
      if ((int)uVar3 >> 0x1f < (int)(uint)(uVar3 < uVar4)) {
        iVar10 = *(int *)local_48[1];
        *(int *)local_48[1] = *puVar5 * uVar3;
        emxEnsureCapacity_real_T1(local_48,iVar10);
        uVar3 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar3) {
          puVar14 = (undefined8 *)*param_1;
          puVar15 = (undefined8 *)*local_48;
          if (uVar3 == 1) {
LAB_000150ce:
            uVar17 = 0;
          }
          else {
            puVar18 = puVar14 + uVar3;
            bVar21 = puVar15 < puVar18;
            if (bVar21) {
              puVar18 = puVar15 + uVar3;
            }
            if (bVar21 && puVar14 < puVar18) goto LAB_000150ce;
            uVar17 = uVar3 & 0xfffffffe;
            puVar18 = puVar14;
            puVar8 = puVar15;
            uVar11 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar11 = uVar11 - 2;
              *puVar8 = uVar22;
              puVar8[1] = uVar24;
              puVar8 = puVar8 + 2;
            } while (uVar11 != 0);
            if (uVar3 - uVar17 == 0) goto LAB_000150ec;
          }
          puVar14 = puVar14 + uVar17;
          puVar15 = puVar15 + uVar17;
          iVar10 = uVar3 - uVar17;
          do {
            uVar22 = *puVar14;
            puVar14 = puVar14 + 1;
            iVar10 = iVar10 + -1;
            *puVar15 = uVar22;
            puVar15 = puVar15 + 1;
          } while (iVar10 != 0);
        }
      }
      else {
        uVar11 = *puVar5;
        puVar5 = (uint *)local_48[1];
        uVar17 = *puVar5;
        *puVar5 = uVar11;
        emxEnsureCapacity_real_T1(local_48,uVar17,puVar5,uVar3 - uVar4);
        if (0 < (int)uVar11) {
          uVar3 = *param_1;
          puVar14 = (undefined8 *)*local_48;
          iVar10 = *(int *)param_1[1];
          if ((uVar11 == 1) ||
             ((puVar14 < (undefined8 *)(iVar10 * uVar16 * 8 + uVar3 + uVar11 * 8) &&
              ((undefined8 *)(iVar10 * uVar16 * 8 + uVar3) < puVar14 + uVar11)))) {
            uVar17 = 0;
          }
          else {
            puVar18 = (undefined8 *)(iVar10 * iVar7 + uVar3);
            uVar17 = uVar11 & 0xfffffffe;
            puVar15 = puVar14;
            uVar13 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar13 = uVar13 - 2;
              *puVar15 = uVar22;
              puVar15[1] = uVar24;
              puVar15 = puVar15 + 2;
            } while (uVar13 != 0);
            if (uVar11 == uVar17) goto LAB_000150ec;
          }
          puVar14 = puVar14 + uVar17;
          iVar19 = uVar11 - uVar17;
          puVar15 = (undefined8 *)(uVar3 + (iVar10 * uVar16 + uVar17) * 8);
          do {
            uVar22 = *puVar15;
            puVar15 = puVar15 + 1;
            iVar19 = iVar19 + -1;
            *puVar14 = uVar22;
            puVar14 = puVar14 + 1;
          } while (iVar19 != 0);
        }
      }
LAB_000150ec:
      uVar6 = *(undefined4 *)local_4c[1];
      *(undefined4 *)local_4c[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_real_T1(local_4c,uVar6);
      iVar10 = *(int *)local_48[1];
      if (0 < iVar10) {
        pdVar9 = (double *)*local_48;
        pdVar12 = (double *)*local_4c;
        do {
          dVar23 = *pdVar9;
          pdVar9 = pdVar9 + 1;
          iVar10 = iVar10 + -1;
          *pdVar12 = 3.9 - dVar23;
          pdVar12 = pdVar12 + 1;
        } while (iVar10 != 0);
      }
      uVar6 = *(undefined4 *)local_58[1];
      *(undefined4 *)local_58[1] = *(undefined4 *)local_4c[1];
      emxEnsureCapacity_real_T1(local_58,uVar6);
      iVar10 = *(int *)local_4c[1];
      if (0 < iVar10) {
        pdVar9 = (double *)*local_4c;
        pdVar12 = (double *)*local_58;
        do {
          dVar23 = *pdVar9;
          dVar25 = 0.0;
          pdVar9 = pdVar9 + 1;
          if (dVar23 != 0.0 && dVar23 < 0.0 == NAN(dVar23)) {
            dVar25 = 1.0;
          }
          iVar10 = iVar10 + -1;
          *pdVar12 = dVar23 * dVar25;
          pdVar12 = pdVar12 + 1;
        } while (iVar10 != 0);
      }
      dVar23 = (double)nansum(local_58);
      uVar6 = *(undefined4 *)local_50[1];
      *(undefined4 *)local_50[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_boolean_T(local_50,uVar6);
      iVar10 = *(int *)local_48[1];
      if (0 < iVar10) {
        uVar1 = rtIsNaN((int)*(undefined8 *)*local_48,
                        (int)((ulonglong)*(undefined8 *)*local_48 >> 0x20));
        *(undefined1 *)*local_50 = uVar1;
        if (iVar10 != 1) {
          iVar20 = 1;
          iVar19 = 8;
          do {
            uVar1 = rtIsNaN((int)*(undefined8 *)(*local_48 + iVar19),
                            (int)((ulonglong)*(undefined8 *)(*local_48 + iVar19) >> 0x20));
            iVar19 = iVar19 + 8;
            *(undefined1 *)(*local_50 + iVar20) = uVar1;
            iVar20 = iVar20 + 1;
          } while (iVar10 != iVar20);
        }
      }
      uVar6 = *(undefined4 *)local_54[1];
      *(undefined4 *)local_54[1] = *(undefined4 *)local_50[1];
      emxEnsureCapacity_boolean_T(local_54,uVar6);
      iVar10 = *(int *)local_50[1];
      if ((0 < iVar10) && (*(bool *)*local_54 = *(char *)*local_50 == '\0', iVar10 != 1)) {
        iVar19 = 1;
        do {
          *(bool *)(*local_54 + iVar19) = *(char *)(*local_50 + iVar19) == '\0';
          iVar19 = iVar19 + 1;
        } while (iVar10 != iVar19);
      }
      dVar25 = (double)sum(local_54);
      iVar7 = iVar7 + 8;
      puVar5 = (uint *)param_1[1];
      uVar3 = puVar5[1];
      *(double *)(*param_2 + uVar16 * 8) = dVar23 / dVar25;
      bVar21 = (int)uVar16 < (int)uVar3;
      uVar16 = uVar4;
    } while (bVar21);
  }
  emxFree_real_T(&local_58);
  emxFree_boolean_T(&local_54);
  emxFree_boolean_T(&local_50);
  emxFree_real_T(&local_4c);
  emxFree_real_T(&local_48);
  if (__stack_chk_guard == local_44) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Restarted to delay deadcode elimination for space: register
// WARNING: Restarted to delay deadcode elimination for space: stack

void ADRR(int *param_1)

{
  undefined1 auVar1 [16];
  undefined1 auVar2 [16];
  undefined1 auVar3 [32];
  undefined1 auVar4 [32];
  byte bVar5;
  undefined1 uVar6;
  int iVar7;
  int iVar8;
  double *pdVar9;
  int iVar10;
  undefined1 (*pauVar11) [16];
  undefined8 *puVar12;
  undefined4 *puVar13;
  char *pcVar14;
  int iVar15;
  undefined1 (*pauVar16) [16];
  uint uVar17;
  uint uVar18;
  int *piVar19;
  uint uVar20;
  double *pdVar21;
  int iVar22;
  double *pdVar23;
  uint uVar24;
  uint uVar25;
  int iVar26;
  int iVar27;
  int iVar28;
  int iVar29;
  undefined1 (*pauVar30) [16];
  undefined1 (*pauVar31) [16];
  bool bVar32;
  uint in_fpscr;
  double dVar33;
  undefined1 in_q8 [16];
  undefined1 auVar34 [16];
  undefined1 auVar35 [16];
  double dVar36;
  undefined4 uVar37;
  ulonglong uVar38;
  undefined1 in_q10 [16];
  undefined1 auVar39 [16];
  int *local_50;
  int *local_4c;
  int *local_48;
  int *local_44;
  int *local_40;
  int *local_3c;
  int *local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  emxInit_real_T1(&local_38,2);
  iVar26 = param_1[1];
  piVar19 = (int *)local_38[1];
  iVar15 = *piVar19;
  iVar22 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = *(int *)(iVar26 + 4);
  emxEnsureCapacity_real_T(local_38,iVar22 * iVar15);
  if (0 < ((int *)param_1[1])[1]) {
    iVar26 = *(int *)param_1[1];
    iVar29 = 8;
    iVar15 = 1;
    iVar22 = 0;
    do {
      iVar10 = iVar15;
      iVar15 = iVar22 * iVar26;
      dVar33 = *(double *)(*param_1 + iVar15 * 8);
      if (1 < iVar26) {
        iVar28 = iVar22 * iVar26 + iVar26;
        iVar7 = rtIsNaN(SUB84(dVar33,0),(int)((ulonglong)dVar33 >> 0x20));
        if (iVar7 == 0) {
          iVar15 = iVar15 + 1;
        }
        else {
          iVar7 = iVar15 + 2;
          iVar27 = iVar29;
          do {
            iVar15 = iVar7;
            in_q8._0_8_ = *(double *)(*param_1 + iVar27);
            iVar8 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
            if (iVar8 == 0) {
              dVar33 = *(double *)(*param_1 + iVar27);
              break;
            }
            if (iVar28 <= iVar15) break;
            iVar27 = iVar27 + 8;
            iVar7 = iVar15 + 1;
          } while (iVar8 != 0);
        }
        if (iVar15 < iVar28) {
          pdVar9 = (double *)(*param_1 + iVar15 * 8);
          do {
            in_q8._0_8_ = *pdVar9;
            pdVar9 = pdVar9 + 1;
            iVar15 = iVar15 + 1;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < dVar33) << 0x1f |
                       (uint)(in_q8._0_8_ == dVar33) << 0x1e | (uint)(dVar33 <= in_q8._0_8_) << 0x1d
            ;
            if ((int)in_fpscr < 0) {
              dVar33 = in_q8._0_8_;
            }
          } while (iVar15 < iVar28);
        }
      }
      iVar29 = iVar29 + iVar26 * 8;
      iVar7 = *(int *)(param_1[1] + 4);
      *(double *)(*local_38 + iVar22 * 8) = dVar33;
      iVar15 = iVar10 + 1;
      iVar22 = iVar10;
    } while (iVar10 < iVar7);
  }
  emxInit_real_T1(&local_3c,2);
  iVar26 = param_1[1];
  piVar19 = (int *)local_3c[1];
  iVar15 = *piVar19;
  iVar22 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = *(int *)(iVar26 + 4);
  emxEnsureCapacity_real_T(local_3c,iVar22 * iVar15);
  if (0 < ((int *)param_1[1])[1]) {
    iVar26 = *(int *)param_1[1];
    iVar29 = 8;
    iVar15 = 1;
    iVar22 = 0;
    do {
      iVar10 = iVar15;
      iVar15 = iVar22 * iVar26;
      dVar33 = *(double *)(*param_1 + iVar15 * 8);
      if (1 < iVar26) {
        iVar28 = iVar22 * iVar26 + iVar26;
        iVar7 = rtIsNaN(SUB84(dVar33,0),(int)((ulonglong)dVar33 >> 0x20));
        if (iVar7 == 0) {
          iVar15 = iVar15 + 1;
        }
        else {
          iVar7 = iVar15 + 2;
          iVar27 = iVar29;
          do {
            iVar15 = iVar7;
            in_q8._0_8_ = *(double *)(*param_1 + iVar27);
            iVar8 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
            if (iVar8 == 0) {
              dVar33 = *(double *)(*param_1 + iVar27);
              break;
            }
            if (iVar28 <= iVar15) break;
            iVar27 = iVar27 + 8;
            iVar7 = iVar15 + 1;
          } while (iVar8 != 0);
        }
        if (iVar15 < iVar28) {
          pdVar9 = (double *)(*param_1 + iVar15 * 8);
          do {
            in_q8._0_8_ = *pdVar9;
            pdVar9 = pdVar9 + 1;
            iVar15 = iVar15 + 1;
            uVar24 = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < dVar33) << 0x1f |
                     (uint)(in_q8._0_8_ == dVar33) << 0x1e;
            in_fpscr = uVar24 | (uint)(NAN(in_q8._0_8_) || NAN(dVar33)) << 0x1c;
            bVar5 = (byte)(uVar24 >> 0x18);
            if (!(bool)(bVar5 >> 6 & 1) && bVar5 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              dVar33 = in_q8._0_8_;
            }
          } while (iVar15 < iVar28);
        }
      }
      iVar29 = iVar29 + iVar26 * 8;
      iVar7 = *(int *)(param_1[1] + 4);
      *(double *)(*local_3c + iVar22 * 8) = dVar33;
      iVar15 = iVar10 + 1;
      iVar22 = iVar10;
    } while (iVar10 < iVar7);
  }
  emxInit_real_T1(&local_40,2);
  emxInit_real_T1(&local_44,2);
  FUN_00015998(local_3c,local_40);
  iVar22 = local_40[1];
  piVar19 = (int *)local_44[1];
  uVar24 = *(uint *)(iVar22 + 4);
  iVar15 = *piVar19;
  iVar26 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = *(int *)(iVar22 + 4);
  emxEnsureCapacity_real_T(local_44,iVar26 * iVar15);
  if (0 < (int)uVar24) {
    pauVar30 = (undefined1 (*) [16])*local_40;
    pauVar31 = (undefined1 (*) [16])*local_44;
    if (uVar24 == 1) {
      uVar20 = 0;
    }
    else {
      pauVar11 = (undefined1 (*) [16])(*pauVar30 + uVar24 * 8);
      uVar20 = 0;
      bVar32 = pauVar31 < pauVar11;
      if (bVar32) {
        pauVar11 = (undefined1 (*) [16])(*pauVar31 + uVar24 * 8);
      }
      if (!bVar32 || pauVar11 <= pauVar30) {
        uVar20 = uVar24 & 0xfffffffe;
        pauVar11 = pauVar30;
        pauVar16 = pauVar31;
        uVar17 = uVar20;
        do {
          in_q8 = *pauVar11;
          pauVar11 = pauVar11 + 1;
          dVar33 = in_q8._0_8_;
          uVar25 = (uint)(dVar33 != 0.0 && dVar33 < 0.0 == NAN(dVar33));
          dVar33 = in_q8._8_8_;
          uVar18 = in_fpscr & 0xfffffff | (uint)(dVar33 < 0.0) << 0x1f |
                   (uint)(dVar33 == 0.0) << 0x1e;
          in_fpscr = uVar18 | (uint)NAN(dVar33) << 0x1c;
          bVar5 = (byte)(uVar18 >> 0x18);
          uVar18 = (uint)(!(bool)(bVar5 >> 6 & 1) && bVar5 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1));
          if (uVar18 != 0) {
            uVar18 = 0xffffffff;
          }
          auVar34._12_4_ = uVar18;
          auVar34._8_4_ = uVar18;
          if (uVar25 != 0) {
            uVar25 = 0xffffffff;
          }
          auVar34._4_4_ = uVar25;
          auVar34._0_4_ = uVar25;
          in_q8 = in_q8 & auVar34;
          uVar17 = uVar17 - 2;
          *(longlong *)*pauVar16 = in_q8._0_8_;
          *(longlong *)(*pauVar16 + 8) = in_q8._8_8_;
          pauVar16 = pauVar16 + 1;
        } while (uVar17 != 0);
        if (uVar24 == uVar20) goto LAB_00015556;
      }
    }
    puVar12 = (undefined8 *)(*pauVar31 + uVar20 * 8);
    pdVar9 = (double *)(*pauVar30 + uVar20 * 8);
    iVar15 = uVar24 - uVar20;
    do {
      in_q8._0_8_ = *pdVar9;
      in_q8._8_8_ = 0;
      pdVar9 = pdVar9 + 1;
      uVar24 = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < 0.0) << 0x1f |
               (uint)(in_q8._0_8_ == 0.0) << 0x1e;
      in_fpscr = uVar24 | (uint)NAN(in_q8._0_8_) << 0x1c;
      bVar5 = (byte)(uVar24 >> 0x18);
      if (!(bool)(bVar5 >> 6 & 1) && bVar5 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
        in_q8._8_8_ = in_q8._0_8_;
      }
      *puVar12 = in_q8._8_8_;
      puVar12 = puVar12 + 1;
      iVar15 = iVar15 + -1;
    } while (iVar15 != 0);
  }
LAB_00015556:
  emxInit_boolean_T1(&local_48,2);
  piVar19 = (int *)local_48[1];
  iVar22 = local_40[1];
  iVar15 = *piVar19;
  iVar26 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = *(int *)(iVar22 + 4);
  emxEnsureCapacity_boolean_T1(local_48,iVar26 * iVar15);
  iVar15 = ((int *)local_40[1])[1] * *(int *)local_40[1];
  if (0 < iVar15) {
    in_q8._0_8_ = *(double *)*local_40;
    uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
    *(undefined1 *)*local_48 = uVar6;
    if (iVar15 != 1) {
      iVar22 = 1;
      iVar26 = 8;
      do {
        in_q8._0_8_ = *(double *)(*local_40 + iVar26);
        uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
        iVar26 = iVar26 + 8;
        *(undefined1 *)(*local_48 + iVar22) = uVar6;
        iVar22 = iVar22 + 1;
      } while (iVar15 - iVar22 != 0);
    }
  }
  uVar24 = *(uint *)(local_48[1] + 4);
  if ((int)uVar24 < 1) {
    iVar15 = 0;
  }
  else {
    if (uVar24 < 4) {
      uVar17 = 0;
      iVar15 = 0;
    }
    else {
      uVar17 = uVar24 & 0xfffffffc;
      auVar34 = ZEXT816(0);
      auVar1 = SIMDExpandImmediate(0,0,1);
      puVar13 = (undefined4 *)*local_48;
      uVar20 = uVar17;
      do {
        in_q8._8_8_ = in_q10._0_8_;
        uVar20 = uVar20 - 4;
                    // WARNING: Ignoring partial resolution of indirect
        uVar37 = *puVar13;
        auVar39 = VectorCopyLong(in_q8._8_8_,1,1);
        uVar38 = VectorCompareEqual(auVar39._0_8_,0,2);
        in_q10 = VectorCopyLong(~uVar38,2,1);
        in_q10 = in_q10 & auVar1;
        auVar34 = VectorAdd(auVar34,in_q10,4);
        puVar13 = puVar13 + 1;
      } while (uVar20 != 0);
      auVar3._16_16_ = auVar34;
      auVar3._0_16_ = auVar34;
      auVar34 = VectorAdd(auVar34,auVar3._8_16_,4);
      in_q8._8_8_ = CONCAT44(auVar34._4_4_,auVar34._4_4_);
      auVar1._8_8_ = in_q8._8_8_;
      auVar1._0_8_ = in_q8._8_8_;
      in_q8 = VectorAdd(auVar34,auVar1,4);
      iVar15 = in_q8._0_4_;
      if (uVar24 == uVar17) goto LAB_00015646;
    }
    iVar22 = uVar24 - uVar17;
    pcVar14 = (char *)(*local_48 + uVar17);
    do {
      if (*pcVar14 != '\0') {
        iVar15 = iVar15 + 1;
      }
      iVar22 = iVar22 + -1;
      pcVar14 = pcVar14 + 1;
    } while (iVar22 != 0);
  }
LAB_00015646:
  emxInit_int32_T(&local_4c,2);
  piVar19 = (int *)local_4c[1];
  iVar22 = *piVar19;
  iVar26 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = iVar15;
  emxEnsureCapacity_int32_T(local_4c,iVar26 * iVar22);
  if (0 < (int)uVar24) {
    uVar20 = 0;
    iVar15 = *local_48;
    iVar22 = 0;
    do {
      pcVar14 = (char *)(iVar15 + uVar20);
      uVar20 = uVar20 + 1;
      if (*pcVar14 != '\0') {
        *(uint *)(*local_4c + iVar22 * 4) = uVar20;
        iVar22 = iVar22 + 1;
      }
    } while (uVar24 != uVar20);
  }
  iVar15 = *(int *)local_4c[1] * ((int *)local_4c[1])[1];
  if (0 < iVar15) {
    iVar22 = *local_44;
    piVar19 = (int *)*local_4c;
    do {
      iVar15 = iVar15 + -1;
      in_q8._0_8_ = (double)rtNaN;
      *(undefined8 *)(iVar22 + *piVar19 * 8 + -8) = rtNaN;
      piVar19 = piVar19 + 1;
    } while (iVar15 != 0);
  }
  emxFree_int32_T(&local_4c);
  FUN_00015998(local_38,local_3c);
  piVar19 = (int *)local_38[1];
  iVar22 = local_3c[1];
  iVar15 = *piVar19;
  iVar26 = piVar19[1];
  uVar24 = *(uint *)(iVar22 + 4);
  *piVar19 = 1;
  piVar19[1] = *(int *)(iVar22 + 4);
  emxEnsureCapacity_real_T(local_38,iVar26 * iVar15);
  if (0 < (int)uVar24) {
    pauVar31 = (undefined1 (*) [16])*local_3c;
    pauVar30 = (undefined1 (*) [16])*local_38;
    if (uVar24 == 1) {
      uVar20 = 0;
    }
    else {
      pauVar11 = (undefined1 (*) [16])(*pauVar31 + uVar24 * 8);
      uVar20 = 0;
      bVar32 = pauVar30 < pauVar11;
      if (bVar32) {
        pauVar11 = (undefined1 (*) [16])(*pauVar30 + uVar24 * 8);
      }
      if (!bVar32 || pauVar11 <= pauVar31) {
        uVar20 = uVar24 & 0xfffffffe;
        pauVar11 = pauVar31;
        pauVar16 = pauVar30;
        uVar17 = uVar20;
        do {
          in_q8 = *pauVar11;
          pauVar11 = pauVar11 + 1;
          dVar33 = in_q8._0_8_;
          uVar18 = (uint)((int)(in_fpscr & 0xfffffff | (uint)(dVar33 < 0.0) << 0x1f |
                                (uint)(dVar33 == 0.0) << 0x1e | (uint)(0.0 <= dVar33) << 0x1d) < 0);
          dVar33 = in_q8._8_8_;
          in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar33 < 0.0) << 0x1f |
                     (uint)(dVar33 == 0.0) << 0x1e | (uint)(0.0 <= dVar33) << 0x1d;
          uVar25 = (uint)((int)in_fpscr < 0);
          if (uVar25 != 0) {
            uVar25 = 0xffffffff;
          }
          auVar39._12_4_ = uVar25;
          auVar39._8_4_ = uVar25;
          if (uVar18 != 0) {
            uVar18 = 0xffffffff;
          }
          auVar39._4_4_ = uVar18;
          auVar39._0_4_ = uVar18;
          in_q8 = in_q8 & auVar39;
          uVar17 = uVar17 - 2;
          *(longlong *)*pauVar16 = in_q8._0_8_;
          *(longlong *)(*pauVar16 + 8) = in_q8._8_8_;
          pauVar16 = pauVar16 + 1;
        } while (uVar17 != 0);
        if (uVar24 == uVar20) goto LAB_0001578a;
      }
    }
    puVar12 = (undefined8 *)(*pauVar30 + uVar20 * 8);
    pdVar9 = (double *)(*pauVar31 + uVar20 * 8);
    iVar15 = uVar24 - uVar20;
    do {
      in_q8._0_8_ = *pdVar9;
      in_q8._8_8_ = 0;
      pdVar9 = pdVar9 + 1;
      in_fpscr = in_fpscr & 0xfffffff | (uint)(in_q8._0_8_ < 0.0) << 0x1f |
                 (uint)(in_q8._0_8_ == 0.0) << 0x1e | (uint)(0.0 <= in_q8._0_8_) << 0x1d;
      if ((int)in_fpscr < 0) {
        in_q8._8_8_ = in_q8._0_8_;
      }
      *puVar12 = in_q8._8_8_;
      puVar12 = puVar12 + 1;
      iVar15 = iVar15 + -1;
    } while (iVar15 != 0);
  }
LAB_0001578a:
  iVar26 = local_3c[1];
  piVar19 = (int *)local_48[1];
  iVar15 = *piVar19;
  iVar22 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = *(int *)(iVar26 + 4);
  emxEnsureCapacity_boolean_T1(local_48,iVar22 * iVar15);
  iVar15 = ((int *)local_3c[1])[1] * *(int *)local_3c[1];
  if (0 < iVar15) {
    in_q8._0_8_ = *(double *)*local_3c;
    uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
    *(undefined1 *)*local_48 = uVar6;
    if (iVar15 != 1) {
      iVar22 = 1;
      iVar26 = 8;
      do {
        in_q8._0_8_ = *(double *)(*local_3c + iVar26);
        uVar6 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
        iVar26 = iVar26 + 8;
        *(undefined1 *)(*local_48 + iVar22) = uVar6;
        iVar22 = iVar22 + 1;
      } while (iVar15 - iVar22 != 0);
    }
  }
  uVar24 = *(uint *)(local_48[1] + 4);
  if ((int)uVar24 < 1) {
    iVar15 = 0;
  }
  else {
    if (uVar24 < 4) {
      uVar17 = 0;
      iVar15 = 0;
    }
    else {
      uVar17 = uVar24 & 0xfffffffc;
      auVar34 = ZEXT816(0);
      auVar1 = SIMDExpandImmediate(0,0,1);
      puVar13 = (undefined4 *)*local_48;
      uVar20 = uVar17;
      do {
        in_q8._8_8_ = in_q10._0_8_;
        uVar20 = uVar20 - 4;
                    // WARNING: Ignoring partial resolution of indirect
        uVar37 = *puVar13;
        auVar39 = VectorCopyLong(in_q8._8_8_,1,1);
        uVar38 = VectorCompareEqual(auVar39._0_8_,0,2);
        in_q10 = VectorCopyLong(~uVar38,2,1);
        in_q10 = in_q10 & auVar1;
        auVar34 = VectorAdd(auVar34,in_q10,4);
        puVar13 = puVar13 + 1;
      } while (uVar20 != 0);
      auVar4._16_16_ = auVar34;
      auVar4._0_16_ = auVar34;
      auVar34 = VectorAdd(auVar34,auVar4._8_16_,4);
      in_q8._8_8_ = CONCAT44(auVar34._4_4_,auVar34._4_4_);
      auVar2._8_8_ = in_q8._8_8_;
      auVar2._0_8_ = in_q8._8_8_;
      in_q8 = VectorAdd(auVar34,auVar2,4);
      iVar15 = in_q8._0_4_;
      if (uVar24 == uVar17) goto LAB_0001586c;
    }
    iVar22 = uVar24 - uVar17;
    pcVar14 = (char *)(*local_48 + uVar17);
    do {
      if (*pcVar14 != '\0') {
        iVar15 = iVar15 + 1;
      }
      iVar22 = iVar22 + -1;
      pcVar14 = pcVar14 + 1;
    } while (iVar22 != 0);
  }
LAB_0001586c:
  emxInit_int32_T(&local_50,2);
  piVar19 = (int *)local_50[1];
  iVar22 = *piVar19;
  iVar26 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = iVar15;
  emxEnsureCapacity_int32_T(local_50,iVar26 * iVar22);
  if (0 < (int)uVar24) {
    uVar20 = 0;
    iVar22 = 0;
    iVar15 = *local_48;
    do {
      pcVar14 = (char *)(iVar15 + uVar20);
      uVar20 = uVar20 + 1;
      if (*pcVar14 != '\0') {
        *(uint *)(*local_50 + iVar22 * 4) = uVar20;
        iVar22 = iVar22 + 1;
      }
    } while (uVar24 != uVar20);
  }
  emxFree_boolean_T(&local_48);
  iVar15 = *(int *)local_50[1] * ((int *)local_50[1])[1];
  if (0 < iVar15) {
    iVar22 = *local_38;
    piVar19 = (int *)*local_50;
    do {
      iVar15 = iVar15 + -1;
      in_q8._0_8_ = (double)rtNaN;
      *(undefined8 *)(iVar22 + *piVar19 * 8 + -8) = rtNaN;
      piVar19 = piVar19 + 1;
    } while (iVar15 != 0);
  }
  emxFree_int32_T(&local_50);
  power(local_44,local_40);
  power(local_38,local_3c);
  piVar19 = (int *)local_38[1];
  iVar22 = local_40[1];
  iVar15 = *piVar19;
  iVar26 = piVar19[1];
  *piVar19 = 1;
  piVar19[1] = *(int *)(iVar22 + 4);
  emxEnsureCapacity_real_T(local_38,iVar26 * iVar15);
  iVar22 = *(int *)local_40[1];
  iVar15 = ((int *)local_40[1])[1];
  emxFree_real_T(&local_44);
  iVar15 = iVar15 * iVar22;
  if (0 < iVar15) {
    auVar35._8_8_ = (double)in_q8._8_8_;
    auVar35._0_8_ = 10.0;
    pdVar21 = (double *)*local_3c;
    pdVar23 = (double *)*local_40;
    pdVar9 = (double *)*local_38;
    do {
      dVar33 = *pdVar21;
      pdVar21 = pdVar21 + 1;
      dVar36 = *pdVar23;
      pdVar23 = pdVar23 + 1;
      iVar15 = iVar15 + -1;
      auVar35._8_8_ = (dVar36 + dVar33) * auVar35._0_8_;
      *pdVar9 = auVar35._8_8_;
      pdVar9 = pdVar9 + 1;
    } while (iVar15 != 0);
  }
  emxFree_real_T(&local_40);
  emxFree_real_T(&local_3c);
  nanmean(local_38);
  emxFree_real_T(&local_38);
  if (__stack_chk_guard == local_34) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_34,__stack_chk_guard);
}



void FUN_00015998(int *param_1,int *param_2)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  undefined4 extraout_r1;
  int *piVar4;
  double *pdVar5;
  int iVar6;
  int iVar7;
  double *pdVar8;
  int iVar9;
  undefined8 *puVar10;
  double dVar11;
  undefined8 uVar12;
  int *piVar13;
  int *in_stack_ffffffd4;
  
  iVar1 = __stack_chk_guard;
  piVar13 = &__stack_chk_guard;
  emxInit_real_T1(&stack0xffffffd4,2);
  iVar9 = param_1[1];
  piVar4 = (int *)in_stack_ffffffd4[1];
  iVar3 = *piVar4;
  iVar7 = piVar4[1];
  *piVar4 = 1;
  piVar4[1] = *(int *)(iVar9 + 4);
  emxEnsureCapacity_real_T(in_stack_ffffffd4,iVar7 * iVar3);
  iVar3 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if (0 < iVar3) {
    pdVar5 = (double *)*param_1;
    pdVar8 = (double *)*in_stack_ffffffd4;
    do {
      dVar11 = *pdVar5;
      pdVar5 = pdVar5 + 1;
      iVar3 = iVar3 + -1;
      *pdVar8 = dVar11 * 18.0;
      pdVar8 = pdVar8 + 1;
    } while (iVar3 != 0);
  }
  iVar3 = in_stack_ffffffd4[1];
  iVar7 = *(int *)(iVar3 + 4);
  if (0 < iVar7) {
    iVar9 = iVar7;
    puVar10 = (undefined8 *)*in_stack_ffffffd4;
    do {
      uVar2 = (undefined4)*puVar10;
      log((double)CONCAT44(in_stack_ffffffd4,piVar13));
      *(undefined4 *)puVar10 = uVar2;
      *(undefined4 *)((int)puVar10 + 4) = extraout_r1;
      iVar9 = iVar9 + -1;
      puVar10 = puVar10 + 1;
    } while (iVar9 != 0);
  }
  piVar4 = (int *)param_2[1];
  iVar9 = *piVar4;
  iVar6 = piVar4[1];
  *piVar4 = 1;
  piVar4[1] = *(int *)(iVar3 + 4);
  emxEnsureCapacity_real_T(param_2,iVar6 * iVar9);
  if (0 < iVar7) {
    iVar3 = 0;
    do {
      uVar12 = rt_powd_snf((int)*(undefined8 *)(*in_stack_ffffffd4 + iVar3),
                           (int)((ulonglong)*(undefined8 *)(*in_stack_ffffffd4 + iVar3) >> 0x20),
                           0x624dd2f2,0x3ff15810);
      iVar9 = *param_2;
      iVar7 = iVar7 + -1;
      *(int *)(iVar9 + iVar3) = (int)uVar12;
      iVar9 = iVar9 + iVar3;
      iVar3 = iVar3 + 8;
      *(int *)(iVar9 + 4) = (int)((ulonglong)uVar12 >> 0x20);
    } while (iVar7 != 0);
  }
  emxFree_real_T(&stack0xffffffd4);
  piVar4 = (int *)param_2[1];
  iVar3 = *piVar4;
  *piVar4 = 1;
  emxEnsureCapacity_real_T(param_2,piVar4[1] * iVar3);
  iVar3 = *(int *)param_2[1] * ((int *)param_2[1])[1];
  if (0 < iVar3) {
    pdVar5 = (double *)*param_2;
    do {
      iVar3 = iVar3 + -1;
      *pdVar5 = (*pdVar5 + -5.381) * 1.509;
      pdVar5 = pdVar5 + 1;
    } while (iVar3 != 0);
  }
  if (*piVar13 == iVar1) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void AUC(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  undefined1 uVar1;
  uint uVar2;
  uint uVar3;
  uint *puVar4;
  undefined4 uVar5;
  int iVar6;
  undefined8 *puVar7;
  double *pdVar8;
  int iVar9;
  uint uVar10;
  double *pdVar11;
  uint uVar12;
  int *piVar13;
  uint uVar14;
  undefined8 *puVar15;
  undefined8 *puVar16;
  uint uVar17;
  undefined8 *puVar18;
  int iVar19;
  int iVar20;
  bool bVar21;
  undefined8 uVar22;
  double dVar23;
  undefined8 uVar24;
  double dVar25;
  int *local_58;
  int *local_54;
  int *local_50;
  int *local_4c;
  uint *local_48;
  int local_44;
  
  local_44 = __stack_chk_guard;
  uVar2 = param_1[1];
  piVar13 = (int *)param_5[1];
  iVar6 = *piVar13;
  iVar9 = piVar13[1];
  *piVar13 = 1;
  piVar13[1] = *(int *)(uVar2 + 4) + 1;
  emxEnsureCapacity_real_T(param_5,iVar9 * iVar6);
  uVar22 = rtNaN;
  iVar6 = *(int *)(param_1[1] + 4);
  if (-1 < iVar6) {
    uVar2 = iVar6 + 1;
    puVar16 = (undefined8 *)*param_5;
    if (uVar2 < 2) {
      uVar3 = 0;
    }
    else if ((&rtNaN < puVar16) || (puVar16 + iVar6 + 1 < (undefined8 *)((int)&rtNaN + 1))) {
      uVar3 = uVar2 & 0xfffffffe;
      puVar15 = puVar16;
      uVar14 = uVar3;
      do {
        *puVar15 = uVar22;
        puVar15[1] = uVar22;
        puVar15 = puVar15 + 2;
        uVar14 = uVar14 - 2;
      } while (uVar14 != 0);
      if (uVar2 == uVar3) goto LAB_00015ba2;
    }
    else {
      uVar3 = 0;
    }
    puVar16 = puVar16 + uVar3;
    iVar6 = (iVar6 - uVar3) + 1;
    do {
      iVar6 = iVar6 + -1;
      *puVar16 = rtNaN;
      puVar16 = puVar16 + 1;
    } while (iVar6 != 0);
  }
LAB_00015ba2:
  emxInit_real_T(&local_48,1);
  emxInit_real_T(&local_4c,1);
  emxInit_boolean_T(&local_50,1);
  emxInit_boolean_T(&local_54,1);
  emxInit_real_T(&local_58,1);
  puVar4 = (uint *)param_1[1];
  uVar2 = puVar4[1];
  if (-1 < (int)uVar2) {
    iVar6 = 0;
    uVar14 = 0;
    do {
      uVar3 = uVar14 + 1;
      if ((int)uVar2 >> 0x1f < (int)(uint)(uVar2 < uVar3)) {
        iVar9 = *(int *)local_48[1];
        *(int *)local_48[1] = *puVar4 * uVar2;
        emxEnsureCapacity_real_T1(local_48,iVar9);
        uVar2 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar2) {
          puVar16 = (undefined8 *)*param_1;
          puVar15 = (undefined8 *)*local_48;
          if (uVar2 == 1) {
LAB_00015ce2:
            uVar17 = 0;
          }
          else {
            puVar18 = puVar16 + uVar2;
            bVar21 = puVar15 < puVar18;
            if (bVar21) {
              puVar18 = puVar15 + uVar2;
            }
            if (bVar21 && puVar16 < puVar18) goto LAB_00015ce2;
            uVar17 = uVar2 & 0xfffffffe;
            puVar18 = puVar16;
            puVar7 = puVar15;
            uVar10 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar10 = uVar10 - 2;
              *puVar7 = uVar22;
              puVar7[1] = uVar24;
              puVar7 = puVar7 + 2;
            } while (uVar10 != 0);
            if (uVar2 - uVar17 == 0) goto LAB_00015d00;
          }
          puVar16 = puVar16 + uVar17;
          puVar15 = puVar15 + uVar17;
          iVar9 = uVar2 - uVar17;
          do {
            uVar22 = *puVar16;
            puVar16 = puVar16 + 1;
            iVar9 = iVar9 + -1;
            *puVar15 = uVar22;
            puVar15 = puVar15 + 1;
          } while (iVar9 != 0);
        }
      }
      else {
        uVar10 = *puVar4;
        puVar4 = (uint *)local_48[1];
        uVar17 = *puVar4;
        *puVar4 = uVar10;
        emxEnsureCapacity_real_T1(local_48,uVar17,puVar4,uVar2 - uVar3);
        if (0 < (int)uVar10) {
          uVar2 = *param_1;
          puVar16 = (undefined8 *)*local_48;
          iVar9 = *(int *)param_1[1];
          if ((uVar10 == 1) ||
             ((puVar16 < (undefined8 *)(iVar9 * uVar14 * 8 + uVar2 + uVar10 * 8) &&
              ((undefined8 *)(iVar9 * uVar14 * 8 + uVar2) < puVar16 + uVar10)))) {
            uVar17 = 0;
          }
          else {
            puVar18 = (undefined8 *)(iVar9 * iVar6 + uVar2);
            uVar17 = uVar10 & 0xfffffffe;
            puVar15 = puVar16;
            uVar12 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar12 = uVar12 - 2;
              *puVar15 = uVar22;
              puVar15[1] = uVar24;
              puVar15 = puVar15 + 2;
            } while (uVar12 != 0);
            if (uVar10 == uVar17) goto LAB_00015d00;
          }
          puVar16 = puVar16 + uVar17;
          iVar19 = uVar10 - uVar17;
          puVar15 = (undefined8 *)(uVar2 + (iVar9 * uVar14 + uVar17) * 8);
          do {
            uVar22 = *puVar15;
            puVar15 = puVar15 + 1;
            iVar19 = iVar19 + -1;
            *puVar16 = uVar22;
            puVar16 = puVar16 + 1;
          } while (iVar19 != 0);
        }
      }
LAB_00015d00:
      uVar5 = *(undefined4 *)local_4c[1];
      *(undefined4 *)local_4c[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_real_T1(local_4c,uVar5);
      iVar9 = *(int *)local_48[1];
      if (0 < iVar9) {
        pdVar8 = (double *)*local_48;
        pdVar11 = (double *)*local_4c;
        do {
          dVar23 = *pdVar8;
          pdVar8 = pdVar8 + 1;
          iVar9 = iVar9 + -1;
          *pdVar11 = dVar23 - (double)CONCAT44(param_4,param_3);
          pdVar11 = pdVar11 + 1;
        } while (iVar9 != 0);
      }
      uVar5 = *(undefined4 *)local_58[1];
      *(undefined4 *)local_58[1] = *(undefined4 *)local_4c[1];
      emxEnsureCapacity_real_T1(local_58,uVar5);
      iVar9 = *(int *)local_4c[1];
      if (0 < iVar9) {
        pdVar8 = (double *)*local_4c;
        pdVar11 = (double *)*local_58;
        do {
          dVar23 = *pdVar8;
          dVar25 = 0.0;
          pdVar8 = pdVar8 + 1;
          if (dVar23 != 0.0 && dVar23 < 0.0 == NAN(dVar23)) {
            dVar25 = 1.0;
          }
          iVar9 = iVar9 + -1;
          *pdVar11 = dVar23 * dVar25;
          pdVar11 = pdVar11 + 1;
        } while (iVar9 != 0);
      }
      dVar23 = (double)nansum(local_58);
      uVar5 = *(undefined4 *)local_50[1];
      *(undefined4 *)local_50[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_boolean_T(local_50,uVar5);
      iVar9 = *(int *)local_48[1];
      if (0 < iVar9) {
        uVar1 = rtIsNaN((int)*(undefined8 *)*local_48,
                        (int)((ulonglong)*(undefined8 *)*local_48 >> 0x20));
        *(undefined1 *)*local_50 = uVar1;
        if (iVar9 != 1) {
          iVar20 = 1;
          iVar19 = 8;
          do {
            uVar1 = rtIsNaN((int)*(undefined8 *)(*local_48 + iVar19),
                            (int)((ulonglong)*(undefined8 *)(*local_48 + iVar19) >> 0x20));
            iVar19 = iVar19 + 8;
            *(undefined1 *)(*local_50 + iVar20) = uVar1;
            iVar20 = iVar20 + 1;
          } while (iVar9 != iVar20);
        }
      }
      uVar5 = *(undefined4 *)local_54[1];
      *(undefined4 *)local_54[1] = *(undefined4 *)local_50[1];
      emxEnsureCapacity_boolean_T(local_54,uVar5);
      iVar9 = *(int *)local_50[1];
      if ((0 < iVar9) && (*(bool *)*local_54 = *(char *)*local_50 == '\0', iVar9 != 1)) {
        iVar19 = 1;
        do {
          *(bool *)(*local_54 + iVar19) = *(char *)(*local_50 + iVar19) == '\0';
          iVar19 = iVar19 + 1;
        } while (iVar9 != iVar19);
      }
      dVar25 = (double)sum(local_54);
      iVar6 = iVar6 + 8;
      puVar4 = (uint *)param_1[1];
      uVar2 = puVar4[1];
      *(double *)(*param_5 + uVar14 * 8) = dVar23 / dVar25;
      bVar21 = (int)uVar14 < (int)uVar2;
      uVar14 = uVar3;
    } while (bVar21);
  }
  emxFree_real_T(&local_58);
  emxFree_boolean_T(&local_54);
  emxFree_boolean_T(&local_50);
  emxFree_real_T(&local_4c);
  emxFree_real_T(&local_48);
  if (__stack_chk_guard == local_44) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void b_AUC(uint *param_1,int *param_2)

{
  undefined1 uVar1;
  int *piVar2;
  uint uVar3;
  uint uVar4;
  uint *puVar5;
  undefined4 uVar6;
  int iVar7;
  undefined8 *puVar8;
  double *pdVar9;
  int iVar10;
  uint uVar11;
  double *pdVar12;
  uint uVar13;
  undefined8 *puVar14;
  undefined8 *puVar15;
  uint uVar16;
  uint uVar17;
  undefined8 *puVar18;
  int iVar19;
  int iVar20;
  bool bVar21;
  undefined8 uVar22;
  double dVar23;
  undefined8 uVar24;
  double dVar25;
  int *local_58;
  int *local_54;
  int *local_50;
  int *local_4c;
  uint *local_48;
  int local_44;
  
  local_44 = __stack_chk_guard;
  piVar2 = (int *)param_2[1];
  uVar3 = param_1[1];
  iVar7 = *piVar2;
  iVar10 = piVar2[1];
  *piVar2 = 1;
  piVar2[1] = *(int *)(uVar3 + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar10 * iVar7);
  uVar22 = rtNaN;
  iVar7 = *(int *)(param_1[1] + 4);
  if (-1 < iVar7) {
    uVar3 = iVar7 + 1;
    puVar14 = (undefined8 *)*param_2;
    if (uVar3 < 2) {
      uVar4 = 0;
    }
    else if ((&rtNaN < puVar14) || (puVar14 + iVar7 + 1 < (undefined8 *)((int)&rtNaN + 1))) {
      uVar4 = uVar3 & 0xfffffffe;
      puVar15 = puVar14;
      uVar16 = uVar4;
      do {
        *puVar15 = uVar22;
        puVar15[1] = uVar22;
        puVar15 = puVar15 + 2;
        uVar16 = uVar16 - 2;
      } while (uVar16 != 0);
      if (uVar3 == uVar4) goto LAB_00015f5e;
    }
    else {
      uVar4 = 0;
    }
    puVar14 = puVar14 + uVar4;
    iVar7 = (iVar7 - uVar4) + 1;
    do {
      iVar7 = iVar7 + -1;
      *puVar14 = rtNaN;
      puVar14 = puVar14 + 1;
    } while (iVar7 != 0);
  }
LAB_00015f5e:
  emxInit_real_T(&local_48,1);
  emxInit_real_T(&local_4c,1);
  emxInit_boolean_T(&local_50,1);
  emxInit_boolean_T(&local_54,1);
  emxInit_real_T(&local_58,1);
  puVar5 = (uint *)param_1[1];
  uVar3 = puVar5[1];
  if (-1 < (int)uVar3) {
    iVar7 = 0;
    uVar16 = 0;
    do {
      uVar4 = uVar16 + 1;
      if ((int)uVar3 >> 0x1f < (int)(uint)(uVar3 < uVar4)) {
        iVar10 = *(int *)local_48[1];
        *(int *)local_48[1] = *puVar5 * uVar3;
        emxEnsureCapacity_real_T1(local_48,iVar10);
        uVar3 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar3) {
          puVar14 = (undefined8 *)*param_1;
          puVar15 = (undefined8 *)*local_48;
          if (uVar3 == 1) {
LAB_0001609e:
            uVar17 = 0;
          }
          else {
            puVar18 = puVar14 + uVar3;
            bVar21 = puVar15 < puVar18;
            if (bVar21) {
              puVar18 = puVar15 + uVar3;
            }
            if (bVar21 && puVar14 < puVar18) goto LAB_0001609e;
            uVar17 = uVar3 & 0xfffffffe;
            puVar18 = puVar14;
            puVar8 = puVar15;
            uVar11 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar11 = uVar11 - 2;
              *puVar8 = uVar22;
              puVar8[1] = uVar24;
              puVar8 = puVar8 + 2;
            } while (uVar11 != 0);
            if (uVar3 - uVar17 == 0) goto LAB_000160bc;
          }
          puVar14 = puVar14 + uVar17;
          puVar15 = puVar15 + uVar17;
          iVar10 = uVar3 - uVar17;
          do {
            uVar22 = *puVar14;
            puVar14 = puVar14 + 1;
            iVar10 = iVar10 + -1;
            *puVar15 = uVar22;
            puVar15 = puVar15 + 1;
          } while (iVar10 != 0);
        }
      }
      else {
        uVar11 = *puVar5;
        puVar5 = (uint *)local_48[1];
        uVar17 = *puVar5;
        *puVar5 = uVar11;
        emxEnsureCapacity_real_T1(local_48,uVar17,puVar5,uVar3 - uVar4);
        if (0 < (int)uVar11) {
          uVar3 = *param_1;
          puVar14 = (undefined8 *)*local_48;
          iVar10 = *(int *)param_1[1];
          if ((uVar11 == 1) ||
             ((puVar14 < (undefined8 *)(iVar10 * uVar16 * 8 + uVar3 + uVar11 * 8) &&
              ((undefined8 *)(iVar10 * uVar16 * 8 + uVar3) < puVar14 + uVar11)))) {
            uVar17 = 0;
          }
          else {
            puVar18 = (undefined8 *)(iVar10 * iVar7 + uVar3);
            uVar17 = uVar11 & 0xfffffffe;
            puVar15 = puVar14;
            uVar13 = uVar17;
            do {
              uVar22 = *puVar18;
              uVar24 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar13 = uVar13 - 2;
              *puVar15 = uVar22;
              puVar15[1] = uVar24;
              puVar15 = puVar15 + 2;
            } while (uVar13 != 0);
            if (uVar11 == uVar17) goto LAB_000160bc;
          }
          puVar14 = puVar14 + uVar17;
          iVar19 = uVar11 - uVar17;
          puVar15 = (undefined8 *)(uVar3 + (iVar10 * uVar16 + uVar17) * 8);
          do {
            uVar22 = *puVar15;
            puVar15 = puVar15 + 1;
            iVar19 = iVar19 + -1;
            *puVar14 = uVar22;
            puVar14 = puVar14 + 1;
          } while (iVar19 != 0);
        }
      }
LAB_000160bc:
      uVar6 = *(undefined4 *)local_4c[1];
      *(undefined4 *)local_4c[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_real_T1(local_4c,uVar6);
      iVar10 = *(int *)local_48[1];
      if (0 < iVar10) {
        pdVar9 = (double *)*local_48;
        pdVar12 = (double *)*local_4c;
        do {
          dVar23 = *pdVar9;
          pdVar9 = pdVar9 + 1;
          iVar10 = iVar10 + -1;
          *pdVar12 = dVar23 + -8.9;
          pdVar12 = pdVar12 + 1;
        } while (iVar10 != 0);
      }
      uVar6 = *(undefined4 *)local_58[1];
      *(undefined4 *)local_58[1] = *(undefined4 *)local_4c[1];
      emxEnsureCapacity_real_T1(local_58,uVar6);
      iVar10 = *(int *)local_4c[1];
      if (0 < iVar10) {
        pdVar9 = (double *)*local_4c;
        pdVar12 = (double *)*local_58;
        do {
          dVar23 = *pdVar9;
          dVar25 = 0.0;
          pdVar9 = pdVar9 + 1;
          if (dVar23 != 0.0 && dVar23 < 0.0 == NAN(dVar23)) {
            dVar25 = 1.0;
          }
          iVar10 = iVar10 + -1;
          *pdVar12 = dVar23 * dVar25;
          pdVar12 = pdVar12 + 1;
        } while (iVar10 != 0);
      }
      dVar23 = (double)nansum(local_58);
      uVar6 = *(undefined4 *)local_50[1];
      *(undefined4 *)local_50[1] = *(undefined4 *)local_48[1];
      emxEnsureCapacity_boolean_T(local_50,uVar6);
      iVar10 = *(int *)local_48[1];
      if (0 < iVar10) {
        uVar1 = rtIsNaN((int)*(undefined8 *)*local_48,
                        (int)((ulonglong)*(undefined8 *)*local_48 >> 0x20));
        *(undefined1 *)*local_50 = uVar1;
        if (iVar10 != 1) {
          iVar20 = 1;
          iVar19 = 8;
          do {
            uVar1 = rtIsNaN((int)*(undefined8 *)(*local_48 + iVar19),
                            (int)((ulonglong)*(undefined8 *)(*local_48 + iVar19) >> 0x20));
            iVar19 = iVar19 + 8;
            *(undefined1 *)(*local_50 + iVar20) = uVar1;
            iVar20 = iVar20 + 1;
          } while (iVar10 != iVar20);
        }
      }
      uVar6 = *(undefined4 *)local_54[1];
      *(undefined4 *)local_54[1] = *(undefined4 *)local_50[1];
      emxEnsureCapacity_boolean_T(local_54,uVar6);
      iVar10 = *(int *)local_50[1];
      if ((0 < iVar10) && (*(bool *)*local_54 = *(char *)*local_50 == '\0', iVar10 != 1)) {
        iVar19 = 1;
        do {
          *(bool *)(*local_54 + iVar19) = *(char *)(*local_50 + iVar19) == '\0';
          iVar19 = iVar19 + 1;
        } while (iVar10 != iVar19);
      }
      dVar25 = (double)sum(local_54);
      iVar7 = iVar7 + 8;
      puVar5 = (uint *)param_1[1];
      uVar3 = puVar5[1];
      *(double *)(*param_2 + uVar16 * 8) = dVar23 / dVar25;
      bVar21 = (int)uVar16 < (int)uVar3;
      uVar16 = uVar4;
    } while (bVar21);
  }
  emxFree_real_T(&local_58);
  emxFree_boolean_T(&local_54);
  emxFree_boolean_T(&local_50);
  emxFree_real_T(&local_4c);
  emxFree_real_T(&local_48);
  if (__stack_chk_guard == local_44) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



double combineVectorElements(undefined4 *param_1)

{
  byte *pbVar1;
  int iVar2;
  double dVar3;
  
  iVar2 = *(int *)param_1[1];
  if (iVar2 != 0) {
    pbVar1 = (byte *)*param_1;
    dVar3 = (double)*pbVar1;
    if (1 < iVar2) {
      iVar2 = iVar2 + -1;
      do {
        pbVar1 = pbVar1 + 1;
        iVar2 = iVar2 + -1;
        dVar3 = dVar3 + (double)*pbVar1;
      } while (iVar2 != 0);
    }
    return dVar3;
  }
  return 0.0;
}



void CONGA(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  undefined4 uVar1;
  int iVar2;
  undefined4 extraout_r1;
  double *pdVar3;
  int *piVar4;
  uint *puVar5;
  undefined8 *puVar6;
  int iVar7;
  double *pdVar8;
  int iVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  int *piVar13;
  uint uVar14;
  undefined8 *puVar15;
  undefined8 *puVar16;
  undefined8 *puVar17;
  uint uVar18;
  double *pdVar19;
  bool bVar20;
  int iVar21;
  double dVar22;
  undefined8 uVar23;
  double dVar24;
  undefined8 uVar25;
  undefined4 in_stack_ffffffb8;
  int *piVar26;
  int *local_3c;
  uint *local_38;
  int local_34;
  
  piVar26 = &__stack_chk_guard;
  local_34 = __stack_chk_guard;
  piVar4 = (int *)param_1[1];
  piVar13 = (int *)param_5[1];
  iVar2 = *piVar13;
  iVar9 = piVar13[1];
  iVar21 = *piVar4;
  *piVar13 = 1;
  piVar13[1] = piVar4[1] + 1;
  emxEnsureCapacity_real_T(param_5,iVar9 * iVar2);
  uVar1 = SUB84(((double)(longlong)iVar21 * (double)CONCAT44(param_4,param_3)) / 24.0,0);
  floor((double)CONCAT44(piVar26,in_stack_ffffffb8));
  uVar23 = rtNaN;
  iVar2 = *(int *)(param_1[1] + 4);
  if (-1 < iVar2) {
    uVar10 = iVar2 + 1;
    puVar17 = (undefined8 *)*param_5;
    if ((uVar10 < 2) ||
       ((puVar17 < (undefined8 *)((int)&rtNaN + 1U) && (&rtNaN < puVar17 + iVar2 + 1)))) {
      uVar14 = 0;
    }
    else {
      uVar14 = uVar10 & 0xfffffffe;
      puVar15 = puVar17;
      uVar18 = uVar14;
      do {
        *puVar15 = uVar23;
        puVar15[1] = uVar23;
        puVar15 = puVar15 + 2;
        uVar18 = uVar18 - 2;
      } while (uVar18 != 0);
      if (uVar10 == uVar14) goto LAB_00016364;
    }
    puVar17 = puVar17 + uVar14;
    iVar2 = (iVar2 - uVar14) + 1;
    do {
      iVar2 = iVar2 + -1;
      *puVar17 = rtNaN;
      puVar17 = puVar17 + 1;
    } while (iVar2 != 0);
  }
LAB_00016364:
  emxInit_real_T(&local_38,1);
  emxInit_real_T(&local_3c,1);
  puVar5 = (uint *)param_1[1];
  uVar10 = puVar5[1];
  if (-1 < (int)uVar10) {
    iVar2 = 0;
    dVar22 = (double)CONCAT44(extraout_r1,uVar1) + 1.0;
    uVar14 = 0;
    do {
      if ((int)uVar10 >> 0x1f < (int)(uint)(uVar10 < uVar14 + 1)) {
        iVar9 = *(int *)local_38[1];
        *(int *)local_38[1] = *puVar5 * uVar10;
        emxEnsureCapacity_real_T1(local_38,iVar9);
        uVar10 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar10) {
          puVar17 = (undefined8 *)*param_1;
          puVar15 = (undefined8 *)*local_38;
          if (uVar10 == 1) {
LAB_00016496:
            uVar18 = 0;
          }
          else {
            puVar16 = puVar17 + uVar10;
            bVar20 = puVar15 < puVar16;
            if (bVar20) {
              puVar16 = puVar15 + uVar10;
            }
            if (bVar20 && puVar17 < puVar16) goto LAB_00016496;
            uVar18 = uVar10 & 0xfffffffe;
            puVar16 = puVar17;
            puVar6 = puVar15;
            uVar11 = uVar18;
            do {
              uVar23 = *puVar16;
              uVar25 = puVar16[1];
              puVar16 = puVar16 + 2;
              uVar11 = uVar11 - 2;
              *puVar6 = uVar23;
              puVar6[1] = uVar25;
              puVar6 = puVar6 + 2;
            } while (uVar11 != 0);
            if (uVar10 - uVar18 == 0) goto LAB_000164b4;
          }
          puVar17 = puVar17 + uVar18;
          puVar15 = puVar15 + uVar18;
          iVar9 = uVar10 - uVar18;
          do {
            uVar23 = *puVar17;
            puVar17 = puVar17 + 1;
            iVar9 = iVar9 + -1;
            *puVar15 = uVar23;
            puVar15 = puVar15 + 1;
          } while (iVar9 != 0);
        }
      }
      else {
        uVar18 = *puVar5;
        uVar10 = *(uint *)local_38[1];
        *(uint *)local_38[1] = uVar18;
        emxEnsureCapacity_real_T1(local_38,uVar10);
        if (0 < (int)uVar18) {
          uVar10 = *param_1;
          iVar9 = *(int *)param_1[1];
          puVar17 = (undefined8 *)*local_38;
          if ((uVar18 == 1) ||
             ((puVar17 < (undefined8 *)(iVar9 * uVar14 * 8 + uVar10 + uVar18 * 8) &&
              ((undefined8 *)(iVar9 * uVar14 * 8 + uVar10) < puVar17 + uVar18)))) {
            uVar11 = 0;
          }
          else {
            puVar16 = (undefined8 *)(iVar9 * iVar2 + uVar10);
            uVar11 = uVar18 & 0xfffffffe;
            puVar15 = puVar17;
            uVar12 = uVar11;
            do {
              uVar23 = *puVar16;
              uVar25 = puVar16[1];
              puVar16 = puVar16 + 2;
              uVar12 = uVar12 - 2;
              *puVar15 = uVar23;
              puVar15[1] = uVar25;
              puVar15 = puVar15 + 2;
            } while (uVar12 != 0);
            if (uVar18 == uVar11) goto LAB_000164b4;
          }
          iVar21 = uVar18 - uVar11;
          puVar15 = (undefined8 *)(uVar10 + (iVar9 * uVar14 + uVar11) * 8);
          puVar17 = puVar17 + uVar11;
          do {
            uVar23 = *puVar15;
            puVar15 = puVar15 + 1;
            iVar21 = iVar21 + -1;
            *puVar17 = uVar23;
            puVar17 = puVar17 + 1;
          } while (iVar21 != 0);
        }
      }
LAB_000164b4:
      iVar7 = *(int *)local_38[1];
      dVar24 = (double)(longlong)iVar7;
      iVar21 = *(int *)local_3c[1];
      iVar9 = (int)(longlong)dVar22 + -1;
      if (dVar22 != dVar24 && dVar22 < dVar24 == (NAN(dVar22) || NAN(dVar24))) {
        iVar9 = 0;
        iVar7 = 0;
      }
      iVar7 = iVar7 - iVar9;
      *(int *)local_3c[1] = iVar7;
      emxEnsureCapacity_real_T1(local_3c,iVar21);
      if (0 < iVar7) {
        pdVar8 = (double *)*local_38;
        pdVar3 = (double *)*local_3c;
        do {
          pdVar19 = pdVar8 + iVar9;
          dVar24 = *pdVar8;
          pdVar8 = pdVar8 + 1;
          iVar7 = iVar7 + -1;
          *pdVar3 = *pdVar19 - dVar24;
          pdVar3 = pdVar3 + 1;
        } while (iVar7 != 0);
      }
      uVar23 = nanstd(local_3c);
      iVar2 = iVar2 + 8;
      iVar9 = *param_5;
      puVar5 = (uint *)param_1[1];
      *(int *)(iVar9 + uVar14 * 8) = (int)uVar23;
      uVar10 = puVar5[1];
      *(int *)(iVar9 + uVar14 * 8 + 4) = (int)((ulonglong)uVar23 >> 0x20);
      bVar20 = (int)uVar14 < (int)uVar10;
      uVar14 = uVar14 + 1;
    } while (bVar20);
  }
  emxFree_real_T(&local_3c);
  emxFree_real_T(&local_38);
  if (*piVar26 == local_34) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void CV(int *param_1,int *param_2,int *param_3)

{
  int *piVar1;
  int iVar2;
  double *pdVar3;
  int iVar4;
  double *pdVar5;
  int iVar6;
  double *pdVar7;
  double dVar8;
  double dVar9;
  
  piVar1 = (int *)param_3[1];
  iVar2 = *piVar1;
  iVar4 = piVar1[1];
  iVar6 = param_2[1];
  *piVar1 = 1;
  piVar1[1] = *(int *)(iVar6 + 4);
  emxEnsureCapacity_real_T(param_3,iVar4 * iVar2);
  iVar2 = *(int *)param_2[1] * ((int *)param_2[1])[1];
  if (0 < iVar2) {
    pdVar3 = (double *)*param_3;
    pdVar5 = (double *)*param_1;
    pdVar7 = (double *)*param_2;
    do {
      dVar8 = *pdVar7;
      pdVar7 = pdVar7 + 1;
      dVar9 = *pdVar5;
      pdVar5 = pdVar5 + 1;
      iVar2 = iVar2 + -1;
      *pdVar3 = (dVar8 * 100.0) / dVar9;
      pdVar3 = pdVar3 + 1;
    } while (iVar2 != 0);
  }
  return;
}



void emxCreateND_real_T(uint param_1,undefined1 (*param_2) [16])

{
  undefined1 auVar1 [32];
  undefined4 uVar2;
  undefined1 auVar3 [16];
  undefined4 *puVar4;
  undefined8 *puVar5;
  int *piVar6;
  void *pvVar7;
  uint uVar8;
  int iVar9;
  int *piVar10;
  uint uVar11;
  int iVar12;
  undefined8 *puVar13;
  undefined1 (*pauVar14) [16];
  size_t __nmemb;
  undefined1 auVar15 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  emxInit_real_T1(&local_28,param_1);
  puVar4 = local_28;
  if ((int)param_1 < 1) {
    __nmemb = 1;
  }
  else {
    puVar5 = (undefined8 *)local_28[1];
    if ((param_1 < 4) ||
       ((puVar5 < *param_2 + param_1 * 4 &&
        (param_2 < (undefined1 (*) [16])((int)puVar5 + param_1 * 4))))) {
      __nmemb = 1;
      uVar8 = 0;
    }
    else {
      uVar8 = param_1 & 0xfffffffc;
      auVar15 = SIMDExpandImmediate(0,0,1);
      uVar11 = uVar8;
      puVar13 = puVar5;
      pauVar14 = param_2;
      do {
        auVar3 = *pauVar14;
        pauVar14 = pauVar14 + 1;
        uVar11 = uVar11 - 4;
        auVar15 = VectorMultiply(auVar3,auVar15,4);
        *puVar13 = auVar3._0_8_;
        puVar13[1] = auVar3._8_8_;
        puVar13 = puVar13 + 2;
      } while (uVar11 != 0);
      auVar1._16_16_ = auVar15;
      auVar1._0_16_ = auVar15;
      auVar15 = VectorMultiply(auVar15,auVar1._8_16_,4);
      uVar2 = VectorGetElement(auVar15._0_8_,1,4,0);
      auVar15 = VectorMultiply(auVar15,uVar2,4);
      __nmemb = auVar15._0_4_;
      if (uVar8 == param_1) goto LAB_0001668e;
    }
    iVar9 = param_1 - uVar8;
    piVar6 = (int *)((int)puVar5 + uVar8 * 4);
    piVar10 = (int *)(*param_2 + uVar8 * 4);
    do {
      iVar12 = *piVar10;
      iVar9 = iVar9 + -1;
      *piVar6 = iVar12;
      __nmemb = iVar12 * __nmemb;
      piVar6 = piVar6 + 1;
      piVar10 = piVar10 + 1;
    } while (iVar9 != 0);
  }
LAB_0001668e:
  pvVar7 = calloc(__nmemb,8);
  *puVar4 = pvVar7;
  local_28[2] = __nmemb;
  local_28[3] = param_1;
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void emxCreateWrapperND_real_T(undefined4 param_1,uint param_2,undefined1 (*param_3) [16])

{
  undefined1 auVar1 [32];
  undefined4 uVar2;
  undefined1 auVar3 [16];
  undefined8 *puVar4;
  int iVar5;
  int *piVar6;
  undefined8 *puVar7;
  int iVar8;
  uint uVar9;
  uint uVar10;
  int iVar11;
  int *piVar12;
  undefined1 (*pauVar13) [16];
  undefined1 auVar14 [16];
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  emxInit_real_T1(&local_28);
  if ((int)param_2 < 1) {
    iVar8 = 1;
  }
  else {
    puVar4 = (undefined8 *)local_28[1];
    if ((param_2 < 4) ||
       ((puVar4 < *param_3 + param_2 * 4 &&
        (param_3 < (undefined1 (*) [16])((int)puVar4 + param_2 * 4))))) {
      iVar8 = 1;
      uVar10 = 0;
    }
    else {
      uVar10 = param_2 & 0xfffffffc;
      auVar14 = SIMDExpandImmediate(0,0,1);
      puVar7 = puVar4;
      uVar9 = uVar10;
      pauVar13 = param_3;
      do {
        auVar3 = *pauVar13;
        pauVar13 = pauVar13 + 1;
        uVar9 = uVar9 - 4;
        auVar14 = VectorMultiply(auVar3,auVar14,4);
        *puVar7 = auVar3._0_8_;
        puVar7[1] = auVar3._8_8_;
        puVar7 = puVar7 + 2;
      } while (uVar9 != 0);
      auVar1._16_16_ = auVar14;
      auVar1._0_16_ = auVar14;
      auVar14 = VectorMultiply(auVar14,auVar1._8_16_,4);
      uVar2 = VectorGetElement(auVar14._0_8_,1,4,0);
      auVar14 = VectorMultiply(auVar14,uVar2,4);
      iVar8 = auVar14._0_4_;
      if (uVar10 == param_2) goto LAB_00016756;
    }
    iVar11 = param_2 - uVar10;
    piVar6 = (int *)((int)puVar4 + uVar10 * 4);
    piVar12 = (int *)(*param_3 + uVar10 * 4);
    do {
      iVar5 = *piVar12;
      iVar11 = iVar11 + -1;
      *piVar6 = iVar5;
      iVar8 = iVar5 * iVar8;
      piVar6 = piVar6 + 1;
      piVar12 = piVar12 + 1;
    } while (iVar11 != 0);
  }
LAB_00016756:
  *local_28 = param_1;
  *(undefined1 *)(local_28 + 4) = 0;
  local_28[2] = iVar8;
  local_28[3] = param_2;
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void emxCreateWrapper_real_T(undefined4 param_1,int param_2,int param_3)

{
  int *piVar1;
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  emxInit_real_T1(&local_28,2);
  piVar1 = (int *)local_28[1];
  *piVar1 = param_2;
  piVar1[1] = param_3;
  *local_28 = param_1;
  *(undefined1 *)(local_28 + 4) = 0;
  local_28[2] = param_3 * param_2;
  local_28[3] = 2;
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void emxCreate_real_T(int param_1,int param_2)

{
  int *piVar1;
  void *pvVar2;
  undefined4 *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  emxInit_real_T1(&local_28,2);
  piVar1 = (int *)local_28[1];
  *piVar1 = param_1;
  piVar1[1] = param_2;
  pvVar2 = calloc(param_2 * param_1,8);
  *local_28 = pvVar2;
  local_28[2] = param_2 * param_1;
  local_28[3] = 2;
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void emxDestroyArray_real_T(undefined4 param_1)

{
  undefined4 local_18;
  int local_14;
  
  local_14 = __stack_chk_guard;
  local_18 = param_1;
  emxFree_real_T(&local_18);
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void emxInitArray_real_T(void)

{
  emxInit_real_T1();
  return;
}



void emxEnsureCapacity_boolean_T(undefined4 *param_1,uint param_2)

{
  bool bVar1;
  undefined1 auVar2 [32];
  undefined4 uVar3;
  undefined1 auVar4 [16];
  int iVar5;
  uint uVar6;
  void *__dest;
  uint uVar7;
  int iVar8;
  size_t __nmemb;
  undefined1 (*pauVar9) [16];
  int *piVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  uVar7 = param_1[3];
  if ((int)uVar7 < 1) {
    iVar5 = 1;
  }
  else {
    if (uVar7 < 4) {
      iVar5 = 1;
      uVar11 = 0;
    }
    else {
      uVar11 = uVar7 & 0xfffffffc;
      auVar12 = SIMDExpandImmediate(0,0,1);
      uVar6 = uVar11;
      pauVar9 = (undefined1 (*) [16])param_1[1];
      do {
        auVar4 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar6 = uVar6 - 4;
        auVar12 = VectorMultiply(auVar4,auVar12,4);
      } while (uVar6 != 0);
      auVar2._16_16_ = auVar12;
      auVar2._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar2._8_16_,4);
      uVar3 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar3,4);
      iVar5 = auVar12._0_4_;
      if (uVar7 == uVar11) goto LAB_000168cc;
    }
    iVar8 = uVar7 - uVar11;
    piVar10 = (int *)(*(undefined1 (*) [16])param_1[1] + uVar11 * 4);
    do {
      iVar8 = iVar8 + -1;
      iVar5 = *piVar10 * iVar5;
      piVar10 = piVar10 + 1;
    } while (iVar8 != 0);
  }
LAB_000168cc:
  __nmemb = param_1[2];
  if ((int)__nmemb < iVar5) {
    if ((int)__nmemb < 0x11) {
      __nmemb = 0x10;
    }
    while ((int)__nmemb < iVar5) {
      bVar1 = 0x3fffffff < (int)__nmemb;
      __nmemb = __nmemb << 1;
      if (bVar1) {
        __nmemb = 0x7fffffff;
      }
    }
    __dest = calloc(__nmemb,1);
    if (((void *)*param_1 != (void *)0x0) &&
       (memcpy(__dest,(void *)*param_1,param_2 & ~((int)param_2 >> 0x1f)),
       *(char *)(param_1 + 4) != '\0')) {
      free((void *)*param_1);
    }
    *(undefined1 *)(param_1 + 4) = 1;
    param_1[2] = __nmemb;
    *param_1 = __dest;
  }
  return;
}



void emxEnsureCapacity_boolean_T1(undefined4 *param_1,uint param_2)

{
  bool bVar1;
  undefined1 auVar2 [32];
  undefined4 uVar3;
  undefined1 auVar4 [16];
  int iVar5;
  uint uVar6;
  void *__dest;
  uint uVar7;
  int iVar8;
  size_t __nmemb;
  undefined1 (*pauVar9) [16];
  int *piVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  uVar7 = param_1[3];
  if ((int)uVar7 < 1) {
    iVar5 = 1;
  }
  else {
    if (uVar7 < 4) {
      iVar5 = 1;
      uVar11 = 0;
    }
    else {
      uVar11 = uVar7 & 0xfffffffc;
      auVar12 = SIMDExpandImmediate(0,0,1);
      uVar6 = uVar11;
      pauVar9 = (undefined1 (*) [16])param_1[1];
      do {
        auVar4 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar6 = uVar6 - 4;
        auVar12 = VectorMultiply(auVar4,auVar12,4);
      } while (uVar6 != 0);
      auVar2._16_16_ = auVar12;
      auVar2._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar2._8_16_,4);
      uVar3 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar3,4);
      iVar5 = auVar12._0_4_;
      if (uVar7 == uVar11) goto LAB_00016988;
    }
    iVar8 = uVar7 - uVar11;
    piVar10 = (int *)(*(undefined1 (*) [16])param_1[1] + uVar11 * 4);
    do {
      iVar8 = iVar8 + -1;
      iVar5 = *piVar10 * iVar5;
      piVar10 = piVar10 + 1;
    } while (iVar8 != 0);
  }
LAB_00016988:
  __nmemb = param_1[2];
  if ((int)__nmemb < iVar5) {
    if ((int)__nmemb < 0x11) {
      __nmemb = 0x10;
    }
    while ((int)__nmemb < iVar5) {
      bVar1 = 0x3fffffff < (int)__nmemb;
      __nmemb = __nmemb << 1;
      if (bVar1) {
        __nmemb = 0x7fffffff;
      }
    }
    __dest = calloc(__nmemb,1);
    if (((void *)*param_1 != (void *)0x0) &&
       (memcpy(__dest,(void *)*param_1,param_2 & ~((int)param_2 >> 0x1f)),
       *(char *)(param_1 + 4) != '\0')) {
      free((void *)*param_1);
    }
    *(undefined1 *)(param_1 + 4) = 1;
    param_1[2] = __nmemb;
    *param_1 = __dest;
  }
  return;
}



void emxEnsureCapacity_int32_T(undefined4 *param_1,uint param_2)

{
  bool bVar1;
  undefined1 auVar2 [32];
  undefined4 uVar3;
  undefined1 auVar4 [16];
  int iVar5;
  uint uVar6;
  void *__dest;
  uint uVar7;
  int iVar8;
  size_t __nmemb;
  undefined1 (*pauVar9) [16];
  int *piVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  uVar7 = param_1[3];
  if ((int)uVar7 < 1) {
    iVar5 = 1;
  }
  else {
    if (uVar7 < 4) {
      iVar5 = 1;
      uVar11 = 0;
    }
    else {
      uVar11 = uVar7 & 0xfffffffc;
      auVar12 = SIMDExpandImmediate(0,0,1);
      uVar6 = uVar11;
      pauVar9 = (undefined1 (*) [16])param_1[1];
      do {
        auVar4 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar6 = uVar6 - 4;
        auVar12 = VectorMultiply(auVar4,auVar12,4);
      } while (uVar6 != 0);
      auVar2._16_16_ = auVar12;
      auVar2._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar2._8_16_,4);
      uVar3 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar3,4);
      iVar5 = auVar12._0_4_;
      if (uVar7 == uVar11) goto LAB_00016a44;
    }
    iVar8 = uVar7 - uVar11;
    piVar10 = (int *)(*(undefined1 (*) [16])param_1[1] + uVar11 * 4);
    do {
      iVar8 = iVar8 + -1;
      iVar5 = *piVar10 * iVar5;
      piVar10 = piVar10 + 1;
    } while (iVar8 != 0);
  }
LAB_00016a44:
  __nmemb = param_1[2];
  if ((int)__nmemb < iVar5) {
    if ((int)__nmemb < 0x11) {
      __nmemb = 0x10;
    }
    while ((int)__nmemb < iVar5) {
      bVar1 = 0x3fffffff < (int)__nmemb;
      __nmemb = __nmemb << 1;
      if (bVar1) {
        __nmemb = 0x7fffffff;
      }
    }
    __dest = calloc(__nmemb,4);
    if (((void *)*param_1 != (void *)0x0) &&
       (memcpy(__dest,(void *)*param_1,(param_2 & ~((int)param_2 >> 0x1f)) << 2),
       *(char *)(param_1 + 4) != '\0')) {
      free((void *)*param_1);
    }
    param_1[2] = __nmemb;
    *(undefined1 *)(param_1 + 4) = 1;
    *param_1 = __dest;
  }
  return;
}



void emxEnsureCapacity_int32_T1(undefined4 *param_1,uint param_2)

{
  bool bVar1;
  undefined1 auVar2 [32];
  undefined4 uVar3;
  undefined1 auVar4 [16];
  int iVar5;
  uint uVar6;
  void *__dest;
  uint uVar7;
  int iVar8;
  size_t __nmemb;
  undefined1 (*pauVar9) [16];
  int *piVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  uVar7 = param_1[3];
  if ((int)uVar7 < 1) {
    iVar5 = 1;
  }
  else {
    if (uVar7 < 4) {
      iVar5 = 1;
      uVar11 = 0;
    }
    else {
      uVar11 = uVar7 & 0xfffffffc;
      auVar12 = SIMDExpandImmediate(0,0,1);
      uVar6 = uVar11;
      pauVar9 = (undefined1 (*) [16])param_1[1];
      do {
        auVar4 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar6 = uVar6 - 4;
        auVar12 = VectorMultiply(auVar4,auVar12,4);
      } while (uVar6 != 0);
      auVar2._16_16_ = auVar12;
      auVar2._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar2._8_16_,4);
      uVar3 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar3,4);
      iVar5 = auVar12._0_4_;
      if (uVar7 == uVar11) goto LAB_00016afe;
    }
    iVar8 = uVar7 - uVar11;
    piVar10 = (int *)(*(undefined1 (*) [16])param_1[1] + uVar11 * 4);
    do {
      iVar8 = iVar8 + -1;
      iVar5 = *piVar10 * iVar5;
      piVar10 = piVar10 + 1;
    } while (iVar8 != 0);
  }
LAB_00016afe:
  __nmemb = param_1[2];
  if ((int)__nmemb < iVar5) {
    if ((int)__nmemb < 0x11) {
      __nmemb = 0x10;
    }
    while ((int)__nmemb < iVar5) {
      bVar1 = 0x3fffffff < (int)__nmemb;
      __nmemb = __nmemb << 1;
      if (bVar1) {
        __nmemb = 0x7fffffff;
      }
    }
    __dest = calloc(__nmemb,4);
    if (((void *)*param_1 != (void *)0x0) &&
       (memcpy(__dest,(void *)*param_1,(param_2 & ~((int)param_2 >> 0x1f)) << 2),
       *(char *)(param_1 + 4) != '\0')) {
      free((void *)*param_1);
    }
    param_1[2] = __nmemb;
    *(undefined1 *)(param_1 + 4) = 1;
    *param_1 = __dest;
  }
  return;
}



void emxEnsureCapacity_real_T(undefined4 *param_1,uint param_2)

{
  bool bVar1;
  undefined1 auVar2 [32];
  undefined4 uVar3;
  undefined1 auVar4 [16];
  int iVar5;
  uint uVar6;
  void *__dest;
  uint uVar7;
  int iVar8;
  size_t __nmemb;
  undefined1 (*pauVar9) [16];
  int *piVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  uVar7 = param_1[3];
  if ((int)uVar7 < 1) {
    iVar5 = 1;
  }
  else {
    if (uVar7 < 4) {
      iVar5 = 1;
      uVar11 = 0;
    }
    else {
      uVar11 = uVar7 & 0xfffffffc;
      auVar12 = SIMDExpandImmediate(0,0,1);
      uVar6 = uVar11;
      pauVar9 = (undefined1 (*) [16])param_1[1];
      do {
        auVar4 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar6 = uVar6 - 4;
        auVar12 = VectorMultiply(auVar4,auVar12,4);
      } while (uVar6 != 0);
      auVar2._16_16_ = auVar12;
      auVar2._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar2._8_16_,4);
      uVar3 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar3,4);
      iVar5 = auVar12._0_4_;
      if (uVar7 == uVar11) goto LAB_00016bb8;
    }
    iVar8 = uVar7 - uVar11;
    piVar10 = (int *)(*(undefined1 (*) [16])param_1[1] + uVar11 * 4);
    do {
      iVar8 = iVar8 + -1;
      iVar5 = *piVar10 * iVar5;
      piVar10 = piVar10 + 1;
    } while (iVar8 != 0);
  }
LAB_00016bb8:
  __nmemb = param_1[2];
  if ((int)__nmemb < iVar5) {
    if ((int)__nmemb < 0x11) {
      __nmemb = 0x10;
    }
    while ((int)__nmemb < iVar5) {
      bVar1 = 0x3fffffff < (int)__nmemb;
      __nmemb = __nmemb << 1;
      if (bVar1) {
        __nmemb = 0x7fffffff;
      }
    }
    __dest = calloc(__nmemb,8);
    if (((void *)*param_1 != (void *)0x0) &&
       (memcpy(__dest,(void *)*param_1,(param_2 & ~((int)param_2 >> 0x1f)) << 3),
       *(char *)(param_1 + 4) != '\0')) {
      free((void *)*param_1);
    }
    param_1[2] = __nmemb;
    *(undefined1 *)(param_1 + 4) = 1;
    *param_1 = __dest;
  }
  return;
}



void emxEnsureCapacity_real_T1(undefined4 *param_1,uint param_2)

{
  bool bVar1;
  undefined1 auVar2 [32];
  undefined4 uVar3;
  undefined1 auVar4 [16];
  int iVar5;
  uint uVar6;
  void *__dest;
  uint uVar7;
  int iVar8;
  size_t __nmemb;
  undefined1 (*pauVar9) [16];
  int *piVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  uVar7 = param_1[3];
  if ((int)uVar7 < 1) {
    iVar5 = 1;
  }
  else {
    if (uVar7 < 4) {
      iVar5 = 1;
      uVar11 = 0;
    }
    else {
      uVar11 = uVar7 & 0xfffffffc;
      auVar12 = SIMDExpandImmediate(0,0,1);
      uVar6 = uVar11;
      pauVar9 = (undefined1 (*) [16])param_1[1];
      do {
        auVar4 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar6 = uVar6 - 4;
        auVar12 = VectorMultiply(auVar4,auVar12,4);
      } while (uVar6 != 0);
      auVar2._16_16_ = auVar12;
      auVar2._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar2._8_16_,4);
      uVar3 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar3,4);
      iVar5 = auVar12._0_4_;
      if (uVar7 == uVar11) goto LAB_00016c72;
    }
    iVar8 = uVar7 - uVar11;
    piVar10 = (int *)(*(undefined1 (*) [16])param_1[1] + uVar11 * 4);
    do {
      iVar8 = iVar8 + -1;
      iVar5 = *piVar10 * iVar5;
      piVar10 = piVar10 + 1;
    } while (iVar8 != 0);
  }
LAB_00016c72:
  __nmemb = param_1[2];
  if ((int)__nmemb < iVar5) {
    if ((int)__nmemb < 0x11) {
      __nmemb = 0x10;
    }
    while ((int)__nmemb < iVar5) {
      bVar1 = 0x3fffffff < (int)__nmemb;
      __nmemb = __nmemb << 1;
      if (bVar1) {
        __nmemb = 0x7fffffff;
      }
    }
    __dest = calloc(__nmemb,8);
    if (((void *)*param_1 != (void *)0x0) &&
       (memcpy(__dest,(void *)*param_1,(param_2 & ~((int)param_2 >> 0x1f)) << 3),
       *(char *)(param_1 + 4) != '\0')) {
      free((void *)*param_1);
    }
    param_1[2] = __nmemb;
    *(undefined1 *)(param_1 + 4) = 1;
    *param_1 = __dest;
  }
  return;
}



void emxEnsureCapacity_uint32_T(undefined4 *param_1,uint param_2)

{
  bool bVar1;
  undefined1 auVar2 [32];
  undefined4 uVar3;
  undefined1 auVar4 [16];
  int iVar5;
  uint uVar6;
  void *__dest;
  uint uVar7;
  int iVar8;
  size_t __nmemb;
  undefined1 (*pauVar9) [16];
  int *piVar10;
  uint uVar11;
  undefined1 auVar12 [16];
  
  uVar7 = param_1[3];
  if ((int)uVar7 < 1) {
    iVar5 = 1;
  }
  else {
    if (uVar7 < 4) {
      iVar5 = 1;
      uVar11 = 0;
    }
    else {
      uVar11 = uVar7 & 0xfffffffc;
      auVar12 = SIMDExpandImmediate(0,0,1);
      uVar6 = uVar11;
      pauVar9 = (undefined1 (*) [16])param_1[1];
      do {
        auVar4 = *pauVar9;
        pauVar9 = pauVar9 + 1;
        uVar6 = uVar6 - 4;
        auVar12 = VectorMultiply(auVar4,auVar12,4);
      } while (uVar6 != 0);
      auVar2._16_16_ = auVar12;
      auVar2._0_16_ = auVar12;
      auVar12 = VectorMultiply(auVar12,auVar2._8_16_,4);
      uVar3 = VectorGetElement(auVar12._0_8_,1,4,0);
      auVar12 = VectorMultiply(auVar12,uVar3,4);
      iVar5 = auVar12._0_4_;
      if (uVar7 == uVar11) goto LAB_00016d2c;
    }
    iVar8 = uVar7 - uVar11;
    piVar10 = (int *)(*(undefined1 (*) [16])param_1[1] + uVar11 * 4);
    do {
      iVar8 = iVar8 + -1;
      iVar5 = *piVar10 * iVar5;
      piVar10 = piVar10 + 1;
    } while (iVar8 != 0);
  }
LAB_00016d2c:
  __nmemb = param_1[2];
  if ((int)__nmemb < iVar5) {
    if ((int)__nmemb < 0x11) {
      __nmemb = 0x10;
    }
    while ((int)__nmemb < iVar5) {
      bVar1 = 0x3fffffff < (int)__nmemb;
      __nmemb = __nmemb << 1;
      if (bVar1) {
        __nmemb = 0x7fffffff;
      }
    }
    __dest = calloc(__nmemb,4);
    if (((void *)*param_1 != (void *)0x0) &&
       (memcpy(__dest,(void *)*param_1,(param_2 & ~((int)param_2 >> 0x1f)) << 2),
       *(char *)(param_1 + 4) != '\0')) {
      free((void *)*param_1);
    }
    param_1[2] = __nmemb;
    *(undefined1 *)(param_1 + 4) = 1;
    *param_1 = __dest;
  }
  return;
}



void emxFreeMatrix_cell_wrap_1(undefined4 *param_1,undefined4 param_2,uint param_3)

{
  void *pvVar1;
  undefined4 *puVar2;
  
  puVar2 = (undefined4 *)*param_1;
  if (puVar2 != (undefined4 *)0x0) {
    pvVar1 = (void *)*puVar2;
    if (pvVar1 != (void *)0x0) {
      param_3 = (uint)*(byte *)(puVar2 + 4);
    }
    if (pvVar1 != (void *)0x0 && param_3 != 0) {
      free(pvVar1);
      puVar2 = (undefined4 *)*param_1;
    }
    free((void *)puVar2[1]);
    free((void *)*param_1);
    *param_1 = 0;
  }
  puVar2 = (undefined4 *)param_1[1];
  if (puVar2 != (undefined4 *)0x0) {
    pvVar1 = (void *)*puVar2;
    if (pvVar1 != (void *)0x0) {
      param_3 = (uint)*(byte *)(puVar2 + 4);
    }
    if (pvVar1 != (void *)0x0 && param_3 != 0) {
      free(pvVar1);
      puVar2 = (undefined4 *)param_1[1];
    }
    free((void *)puVar2[1]);
    free((void *)param_1[1]);
    param_1[1] = 0;
  }
  return;
}



void emxFree_boolean_T(undefined4 *param_1,undefined4 param_2,uint param_3)

{
  void *__ptr;
  undefined4 *puVar1;
  
  puVar1 = (undefined4 *)*param_1;
  if (puVar1 != (undefined4 *)0x0) {
    __ptr = (void *)*puVar1;
    if (__ptr != (void *)0x0) {
      param_3 = (uint)*(byte *)(puVar1 + 4);
    }
    if (__ptr != (void *)0x0 && param_3 != 0) {
      free(__ptr);
      puVar1 = (undefined4 *)*param_1;
    }
    free((void *)puVar1[1]);
    free((void *)*param_1);
    *param_1 = 0;
  }
  return;
}



void emxFree_int32_T(undefined4 *param_1,undefined4 param_2,uint param_3)

{
  void *__ptr;
  undefined4 *puVar1;
  
  puVar1 = (undefined4 *)*param_1;
  if (puVar1 != (undefined4 *)0x0) {
    __ptr = (void *)*puVar1;
    if (__ptr != (void *)0x0) {
      param_3 = (uint)*(byte *)(puVar1 + 4);
    }
    if (__ptr != (void *)0x0 && param_3 != 0) {
      free(__ptr);
      puVar1 = (undefined4 *)*param_1;
    }
    free((void *)puVar1[1]);
    free((void *)*param_1);
    *param_1 = 0;
  }
  return;
}



void emxFree_real_T(undefined4 *param_1,undefined4 param_2,uint param_3)

{
  void *__ptr;
  undefined4 *puVar1;
  
  puVar1 = (undefined4 *)*param_1;
  if (puVar1 != (undefined4 *)0x0) {
    __ptr = (void *)*puVar1;
    if (__ptr != (void *)0x0) {
      param_3 = (uint)*(byte *)(puVar1 + 4);
    }
    if (__ptr != (void *)0x0 && param_3 != 0) {
      free(__ptr);
      puVar1 = (undefined4 *)*param_1;
    }
    free((void *)puVar1[1]);
    free((void *)*param_1);
    *param_1 = 0;
  }
  return;
}



void emxFree_uint32_T(undefined4 *param_1,undefined4 param_2,uint param_3)

{
  void *__ptr;
  undefined4 *puVar1;
  
  puVar1 = (undefined4 *)*param_1;
  if (puVar1 != (undefined4 *)0x0) {
    __ptr = (void *)*puVar1;
    if (__ptr != (void *)0x0) {
      param_3 = (uint)*(byte *)(puVar1 + 4);
    }
    if (__ptr != (void *)0x0 && param_3 != 0) {
      free(__ptr);
      puVar1 = (undefined4 *)*param_1;
    }
    free((void *)puVar1[1]);
    free((void *)*param_1);
    *param_1 = 0;
  }
  return;
}



void emxInitMatrix_cell_wrap_1(undefined4 *param_1)

{
  undefined4 *puVar1;
  undefined4 *puVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = 2;
  *puVar1 = 0;
  puVar2 = (undefined4 *)malloc(8);
  *puVar2 = 0;
  puVar2[1] = 0;
  puVar1[1] = puVar2;
  puVar1[2] = 0;
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1 = (undefined4 *)malloc(0x14);
  param_1[1] = puVar1;
  puVar1[3] = 2;
  *puVar1 = 0;
  puVar2 = (undefined4 *)malloc(8);
  *puVar2 = 0;
  puVar2[1] = 0;
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = puVar2;
  puVar1[2] = 0;
  return;
}



void emxInit_boolean_T(undefined4 *param_1,int param_2)

{
  undefined4 *puVar1;
  void *pvVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = param_2;
  *puVar1 = 0;
  pvVar2 = malloc(param_2 << 2);
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = pvVar2;
  puVar1[2] = 0;
  if (0 < param_2) {
    FUN_00022030(pvVar2,param_2 << 2);
  }
  return;
}



void emxInit_boolean_T1(undefined4 *param_1,int param_2)

{
  undefined4 *puVar1;
  void *pvVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = param_2;
  *puVar1 = 0;
  pvVar2 = malloc(param_2 << 2);
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = pvVar2;
  puVar1[2] = 0;
  if (0 < param_2) {
    FUN_00022030(pvVar2,param_2 << 2);
  }
  return;
}



void emxInit_int32_T(undefined4 *param_1,int param_2)

{
  undefined4 *puVar1;
  void *pvVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = param_2;
  *puVar1 = 0;
  pvVar2 = malloc(param_2 << 2);
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = pvVar2;
  puVar1[2] = 0;
  if (0 < param_2) {
    FUN_00022030(pvVar2,param_2 << 2);
  }
  return;
}



void emxInit_int32_T1(undefined4 *param_1,int param_2)

{
  undefined4 *puVar1;
  void *pvVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = param_2;
  *puVar1 = 0;
  pvVar2 = malloc(param_2 << 2);
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = pvVar2;
  puVar1[2] = 0;
  if (0 < param_2) {
    FUN_00022030(pvVar2,param_2 << 2);
  }
  return;
}



void emxInit_real_T(undefined4 *param_1,int param_2)

{
  undefined4 *puVar1;
  void *pvVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = param_2;
  *puVar1 = 0;
  pvVar2 = malloc(param_2 << 2);
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = pvVar2;
  puVar1[2] = 0;
  if (0 < param_2) {
    FUN_00022030(pvVar2,param_2 << 2);
  }
  return;
}



void emxInit_real_T1(undefined4 *param_1,int param_2)

{
  undefined4 *puVar1;
  void *pvVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = param_2;
  *puVar1 = 0;
  pvVar2 = malloc(param_2 << 2);
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = pvVar2;
  puVar1[2] = 0;
  if (0 < param_2) {
    FUN_00022030(pvVar2,param_2 << 2);
  }
  return;
}



void emxInit_uint32_T(undefined4 *param_1,int param_2)

{
  undefined4 *puVar1;
  void *pvVar2;
  
  puVar1 = (undefined4 *)malloc(0x14);
  *param_1 = puVar1;
  puVar1[3] = param_2;
  *puVar1 = 0;
  pvVar2 = malloc(param_2 << 2);
  *(undefined1 *)(puVar1 + 4) = 1;
  puVar1[1] = pvVar2;
  puVar1[2] = 0;
  if (0 < param_2) {
    FUN_00022030(pvVar2,param_2 << 2);
  }
  return;
}



void datools_initialize(void)

{
  rtNaN = rtGetNaN();
  rtNaNF = rtGetNaNF();
  rtInf = rtGetInf();
  rtInfF = rtGetInfF();
  rtMinusInf = rtGetMinusInf();
  rtMinusInfF = rtGetMinusInfF();
  return;
}



double rt_powd_snf(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                  double param_5,double param_6)

{
  int iVar1;
  undefined **ppuVar2;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  double unaff_d8;
  double dVar3;
  double dVar4;
  
  iVar1 = rtIsNaN();
  if (iVar1 == 0) {
    dVar4 = (double)CONCAT44(param_4,param_3);
    iVar1 = rtIsNaN(param_3,param_4);
    if (iVar1 == 0) {
      dVar3 = (double)CONCAT44(param_2,param_1);
      iVar1 = rtIsInf(param_3,param_4);
      if (iVar1 != 0) {
        dVar3 = ABS(dVar3);
        if (dVar3 == 1.0) {
          return 1.0;
        }
        if (dVar3 == 1.0 || dVar3 < 1.0 != NAN(dVar3)) {
          if (dVar4 != 0.0 && dVar4 < 0.0 == NAN(dVar4)) {
            return 0.0;
          }
        }
        else if (dVar4 == 0.0 || dVar4 < 0.0 != NAN(dVar4)) {
          return 0.0;
        }
        ppuVar2 = &PTR_rtInf_00023944;
        goto LAB_000170e4;
      }
      if (dVar4 == 0.0) {
        return 1.0;
      }
      if (ABS(dVar4) == 1.0) {
        if (dVar4 != 0.0 && dVar4 < 0.0 == NAN(dVar4)) {
          return dVar3;
        }
        return 1.0 / dVar3;
      }
      if (dVar4 == 2.0) {
        return dVar3 * dVar3;
      }
      if ((dVar3 < 0.0 == NAN(dVar3)) && (dVar4 == 0.5)) {
        return SQRT(dVar3);
      }
      floor(unaff_d8);
      if ((-1 < (int)((uint)(dVar3 < 0.0) << 0x1f)) ||
         (-1 < (int)((uint)((double)CONCAT44(extraout_r1,param_3) < dVar4) << 0x1f))) {
        pow(param_5,param_6);
        return (double)CONCAT44(extraout_r1_00,param_1);
      }
    }
  }
  ppuVar2 = &PTR_rtNaN_00023940;
LAB_000170e4:
  return *(double *)*ppuVar2;
}



void datools_terminate(void)

{
  return;
}



void DailyTrendMean(void)

{
  b_nanmean();
  return;
}



// WARNING: Restarted to delay deadcode elimination for space: register
// WARNING: Restarted to delay deadcode elimination for space: stack

void DailyTrendPrctile(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                      int *param_5)

{
  undefined1 auVar1 [32];
  byte bVar2;
  undefined1 uVar3;
  uint uVar4;
  double *pdVar5;
  char *pcVar6;
  undefined4 uVar7;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  undefined4 extraout_r1_02;
  undefined4 extraout_r1_03;
  undefined4 extraout_r1_04;
  undefined4 extraout_r1_05;
  undefined4 extraout_r1_06;
  int *piVar8;
  undefined8 *puVar9;
  undefined8 *puVar10;
  undefined1 (*pauVar11) [16];
  uint uVar12;
  double *pdVar13;
  int iVar14;
  undefined4 *puVar15;
  undefined1 (*pauVar16) [16];
  undefined1 (*pauVar17) [16];
  int iVar18;
  int iVar19;
  int iVar20;
  undefined1 (*pauVar21) [16];
  double *pdVar22;
  int iVar23;
  uint uVar24;
  int *piVar25;
  int iVar26;
  int iVar27;
  int iVar28;
  bool bVar29;
  bool bVar30;
  uint in_fpscr;
  double dVar31;
  double dVar32;
  double dVar33;
  double dVar34;
  double dVar35;
  double dVar36;
  double dVar37;
  double dVar40;
  double dVar41;
  undefined1 auVar38 [16];
  undefined1 auVar39 [16];
  ulonglong uVar42;
  undefined1 in_q9 [16];
  undefined1 auVar43 [16];
  undefined8 uVar44;
  int *piVar45;
  int *piVar46;
  int local_a8;
  int *local_9c;
  int *local_98;
  int *local_94;
  int *local_90;
  int *local_8c;
  int *local_88;
  int *local_84;
  double local_80;
  undefined4 local_78;
  undefined4 uStack_74;
  int local_6c;
  
  piVar46 = &__stack_chk_guard;
  local_6c = __stack_chk_guard;
  emxInit_real_T(&local_84,1);
  iVar28 = **(int **)(param_1 + 4);
  piVar45 = local_84;
  percentile_array(param_1,local_84,param_3,param_4);
  uVar7 = *(undefined4 *)param_5[1];
  *(undefined4 *)param_5[1] = *(undefined4 *)local_84[1];
  emxEnsureCapacity_real_T1(param_5,uVar7);
  uVar4 = *(uint *)local_84[1];
  if ((int)uVar4 < 1) goto LAB_000172ac;
  pauVar16 = (undefined1 (*) [16])*local_84;
  pauVar21 = (undefined1 (*) [16])*param_5;
  if (uVar4 == 1) {
LAB_0001728e:
    uVar24 = 0;
  }
  else {
    pauVar17 = (undefined1 (*) [16])(*pauVar16 + uVar4 * 8);
    bVar29 = pauVar21 < pauVar17;
    if (bVar29) {
      pauVar17 = (undefined1 (*) [16])(*pauVar21 + uVar4 * 8);
    }
    if (bVar29 && pauVar16 < pauVar17) goto LAB_0001728e;
    uVar24 = uVar4 & 0xfffffffe;
    pauVar17 = pauVar21;
    pauVar11 = pauVar16;
    uVar12 = uVar24;
    do {
      auVar39 = *pauVar11;
      pauVar11 = pauVar11 + 1;
      uVar12 = uVar12 - 2;
      *(longlong *)*pauVar17 = auVar39._0_8_;
      *(longlong *)(*pauVar17 + 8) = auVar39._8_8_;
      pauVar17 = pauVar17 + 1;
    } while (uVar12 != 0);
    if (uVar4 == uVar24) goto LAB_000172ac;
  }
  puVar9 = (undefined8 *)(*pauVar16 + uVar24 * 8);
  puVar10 = (undefined8 *)(*pauVar21 + uVar24 * 8);
  iVar23 = uVar4 - uVar24;
  do {
    uVar44 = *puVar9;
    puVar9 = puVar9 + 1;
    iVar23 = iVar23 + -1;
    *puVar10 = uVar44;
    puVar10 = puVar10 + 1;
  } while (iVar23 != 0);
LAB_000172ac:
  uStack_74 = 0x40080000;
  local_78 = 0;
  dVar34 = (double)(longlong)**(int **)(param_1 + 4) / 48.0;
  local_80 = dVar34;
  emxInit_int32_T1(&local_88,1);
  emxInit_boolean_T(&local_8c,1);
  emxInit_real_T1(&local_90,2);
  emxInit_real_T1(&local_94,2);
  emxInit_real_T(&local_98,1);
  emxInit_int32_T1(&local_9c,1);
  bVar29 = true;
  local_a8 = 1;
  dVar31 = (double)(longlong)iVar28;
  do {
    if (0 < iVar28) {
      dVar33 = dVar31 - dVar34;
      iVar23 = 0;
      dVar32 = 0.0;
      do {
        dVar32 = dVar32 + 1.0;
        in_fpscr = in_fpscr & 0xfffffff;
        if (dVar32 <= dVar34) {
          dVar35 = (double)(iVar23 + iVar28 + 1) - dVar34;
          uVar4 = in_fpscr | (uint)(dVar35 < dVar31) << 0x1f | (uint)(dVar35 == dVar31) << 0x1e;
          in_fpscr = uVar4 | (uint)(NAN(dVar35) || NAN(dVar31)) << 0x1c;
          bVar2 = (byte)(uVar4 >> 0x18);
          if ((bool)(bVar2 >> 6 & 1) || bVar2 >> 7 != ((byte)(in_fpscr >> 0x1c) & 1)) {
            uVar7 = SUB84(dVar35,0);
            floor((double)CONCAT44(piVar46,piVar45));
            in_fpscr = in_fpscr & 0xfffffff |
                       (uint)((double)CONCAT44(extraout_r1,uVar7) == dVar35) << 0x1e;
            if ((byte)(in_fpscr >> 0x1e) == 0) {
              uVar7 = SUB84((dVar31 - dVar35) + 0.5,0);
              floor((double)CONCAT44(piVar46,piVar45));
              dVar37 = (double)CONCAT44(extraout_r1_03,uVar7);
              dVar40 = ABS(dVar35);
              dVar36 = dVar35 + dVar37;
              dVar41 = dVar31;
              if (dVar40 != dVar31 && dVar40 < dVar31 == (NAN(dVar40) || NAN(dVar31))) {
                dVar41 = dVar40;
              }
              in_q9._0_8_ = dVar41 * 4.440892098500626e-16;
              dVar41 = dVar36 - dVar31;
              in_q9._8_8_ = ABS(dVar41);
              uVar4 = in_fpscr & 0xfffffff | (uint)(in_q9._8_8_ < in_q9._0_8_) << 0x1f |
                      (uint)(in_q9._8_8_ == in_q9._0_8_) << 0x1e |
                      (uint)(in_q9._0_8_ <= in_q9._8_8_) << 0x1d;
              if ((int)uVar4 < 0) {
                dVar37 = dVar37 + 1.0;
                dVar36 = dVar31;
              }
              else {
                uVar24 = in_fpscr & 0xfffffff | (uint)(dVar41 < 0.0) << 0x1f |
                         (uint)(dVar41 == 0.0) << 0x1e;
                uVar4 = uVar24 | (uint)NAN(dVar41) << 0x1c;
                bVar2 = (byte)(uVar24 >> 0x18);
                if ((bool)(bVar2 >> 6 & 1) || bVar2 >> 7 != ((byte)(uVar4 >> 0x1c) & 1)) {
                  dVar37 = dVar37 + 1.0;
                }
                else {
                  dVar36 = dVar35 + dVar37 + -1.0;
                }
              }
              uVar4 = uVar4 & 0xfffffff | (uint)(dVar37 < 0.0) << 0x1f |
                      (uint)(dVar37 == 0.0) << 0x1e;
              in_fpscr = uVar4 | (uint)NAN(dVar37) << 0x1c;
              bVar2 = (byte)(uVar4 >> 0x18);
              dVar41 = 0.0;
              if (!(bool)(bVar2 >> 6 & 1) && bVar2 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
                dVar41 = dVar37;
              }
              iVar14 = (int)(longlong)dVar41;
              piVar8 = (int *)local_90[1];
              iVar20 = *piVar8;
              iVar27 = piVar8[1];
              *piVar8 = 1;
              piVar8[1] = iVar14;
              emxEnsureCapacity_real_T(local_90,iVar27 * iVar20);
              if (0 < iVar14) {
                pdVar5 = (double *)*local_90;
                *pdVar5 = dVar35;
                if (iVar14 != 1) {
                  iVar27 = iVar14 + -1;
                  pdVar5[iVar27] = dVar36;
                  iVar20 = iVar27 / 2;
                  if (4 < iVar14) {
                    auVar39._8_8_ = dVar41;
                    auVar39._0_8_ = 1.0;
                    iVar26 = 2;
                    if (2 < iVar20) {
                      iVar26 = iVar20;
                    }
                    pdVar13 = pdVar5 + iVar14 + -2;
                    iVar26 = iVar26 + -1;
                    pdVar22 = pdVar5;
                    do {
                      pdVar22 = pdVar22 + 1;
                      dVar41 = auVar39._0_8_;
                      auVar39._8_8_ = dVar35 + dVar41;
                      iVar26 = iVar26 + -1;
                      in_q9._0_8_ = dVar36 - dVar41;
                      auVar39._0_8_ = dVar41 + 1.0;
                      *pdVar22 = auVar39._8_8_;
                      *pdVar13 = in_q9._0_8_;
                      pdVar13 = pdVar13 + -1;
                    } while (iVar26 != 0);
                  }
                  if (iVar27 == iVar20 * 2) {
                    pdVar5[iVar20] = (dVar35 + dVar36) * 0.5;
                  }
                  else {
                    pdVar5[iVar20] = dVar35 + (double)(longlong)iVar20;
                    (pdVar5 + iVar20)[1] = dVar36 - (double)(longlong)iVar20;
                  }
                }
              }
            }
            else {
              uVar7 = SUB84(dVar31 - dVar35,0);
              floor((double)CONCAT44(piVar46,piVar45));
              iVar26 = (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar7);
              piVar8 = (int *)local_90[1];
              iVar20 = *piVar8;
              iVar27 = piVar8[1];
              iVar14 = iVar26 + 1;
              *piVar8 = 1;
              piVar8[1] = iVar14;
              emxEnsureCapacity_real_T(local_90,iVar27 * iVar20);
              if (-1 < iVar26) {
                pdVar5 = (double *)*local_90;
                iVar27 = *(int *)local_90[1];
                iVar20 = 0;
                do {
                  iVar26 = iVar20 + 1;
                  *pdVar5 = dVar35 + (double)(longlong)iVar20;
                  pdVar5 = pdVar5 + iVar27;
                  iVar20 = iVar26;
                } while (iVar14 != iVar26);
              }
            }
          }
          else {
            piVar8 = (int *)local_90[1];
            iVar20 = *piVar8;
            iVar27 = piVar8[1];
            *piVar8 = 1;
            piVar8[1] = 0;
            emxEnsureCapacity_real_T(local_90,iVar27 * iVar20);
          }
          uVar7 = SUB84(dVar34 + dVar32 + -1.0,0);
          floor((double)CONCAT44(piVar46,piVar45));
          iVar26 = (int)(longlong)(double)CONCAT44(extraout_r1_05,uVar7);
          piVar8 = (int *)local_94[1];
          iVar20 = *piVar8;
          iVar27 = piVar8[1];
          iVar14 = iVar26 + 1;
          *piVar8 = 1;
          piVar8[1] = iVar14;
          emxEnsureCapacity_real_T(local_94,iVar27 * iVar20);
          if (iVar26 < 0) {
            piVar8 = (int *)local_94[1];
          }
          else {
            pdVar5 = (double *)*local_94;
            piVar8 = (int *)local_94[1];
            iVar27 = *piVar8;
            iVar20 = 0;
            do {
              iVar26 = iVar20 + 1;
              *pdVar5 = (double)(longlong)iVar20 + 1.0;
              pdVar5 = pdVar5 + iVar27;
              iVar20 = iVar26;
            } while (iVar14 != iVar26);
          }
          iVar20 = *(int *)local_9c[1];
          *(int *)local_9c[1] = *(int *)(local_90[1] + 4) + piVar8[1];
          emxEnsureCapacity_int32_T1(local_9c,iVar20);
          piVar8 = (int *)local_90[1];
          iVar20 = piVar8[1];
          if (0 < iVar20) {
            iVar26 = 0;
            iVar27 = *local_90;
            iVar14 = *local_9c;
            do {
              *(int *)(iVar14 + iVar26 * 4) =
                   (int)(longlong)*(double *)(iVar27 + iVar26 * *piVar8 * 8) + -1;
              iVar26 = iVar26 + 1;
            } while (iVar20 != iVar26);
          }
          piVar25 = (int *)local_94[1];
          iVar20 = piVar25[1];
          if (0 < iVar20) {
            iVar14 = 0;
            iVar27 = *local_94;
            iVar26 = *local_9c;
            do {
              iVar18 = iVar14 * *piVar25;
              iVar19 = piVar8[1] + iVar14;
              iVar14 = iVar14 + 1;
              *(int *)(iVar26 + iVar19 * 4) = (int)(longlong)*(double *)(iVar27 + iVar18 * 8) + -1;
            } while (iVar20 != iVar14);
            iVar20 = piVar25[1];
          }
          iVar27 = *(int *)local_98[1];
          *(int *)local_98[1] = piVar8[1] + iVar20;
          emxEnsureCapacity_real_T1(local_98,iVar27);
          iVar20 = *(int *)(local_94[1] + 4) + *(int *)(local_90[1] + 4);
          if (0 < iVar20) {
            puVar10 = (undefined8 *)*local_98;
            iVar27 = *local_84;
            piVar8 = (int *)*local_9c;
            do {
              iVar20 = iVar20 + -1;
              *puVar10 = *(undefined8 *)(iVar27 + *piVar8 * 8);
              puVar10 = puVar10 + 1;
              piVar8 = piVar8 + 1;
            } while (iVar20 != 0);
          }
        }
        else {
          dVar35 = dVar32 - dVar34;
          if (dVar32 == dVar33 || dVar32 < dVar33 != (NAN(dVar32) || NAN(dVar33))) {
            uVar24 = *(uint *)local_98[1];
            dVar36 = dVar34 + dVar32;
            iVar20 = (int)(longlong)dVar36;
            uVar4 = in_fpscr | (uint)(dVar35 < dVar36) << 0x1f | (uint)(dVar35 == dVar36) << 0x1e;
            in_fpscr = uVar4 | (uint)(NAN(dVar35) || NAN(dVar36)) << 0x1c;
            iVar27 = (int)(longlong)dVar35 + -1;
            bVar2 = (byte)(uVar4 >> 0x18);
            if (!(bool)(bVar2 >> 6 & 1) && bVar2 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              iVar20 = 0;
              iVar27 = 0;
            }
            uVar4 = iVar20 - iVar27;
            *(uint *)local_98[1] = uVar4;
            emxEnsureCapacity_real_T1(local_98,uVar24);
            if (0 < (int)uVar4) {
              pauVar16 = (undefined1 (*) [16])*local_98;
              iVar14 = *local_84;
              if (uVar4 == 1) {
LAB_00017542:
                uVar24 = 0;
              }
              else {
                pauVar21 = (undefined1 (*) [16])(iVar14 + iVar20 * 8);
                pauVar17 = (undefined1 (*) [16])(iVar14 + iVar27 * 8);
                bVar30 = pauVar16 < pauVar21;
                if (bVar30) {
                  pauVar21 = (undefined1 (*) [16])((int)pauVar16 + uVar4 * 8);
                }
                if (bVar30 && pauVar17 < pauVar21) goto LAB_00017542;
                uVar24 = uVar4 & 0xfffffffe;
                pauVar21 = pauVar16;
                uVar12 = uVar24;
                do {
                  auVar39 = *pauVar17;
                  pauVar17 = pauVar17 + 1;
                  uVar12 = uVar12 - 2;
                  *(longlong *)*pauVar21 = auVar39._0_8_;
                  *(longlong *)(*pauVar21 + 8) = auVar39._8_8_;
                  pauVar21 = pauVar21 + 1;
                } while (uVar12 != 0);
                if (uVar4 == uVar24) goto LAB_00017350;
              }
              puVar9 = (undefined8 *)(*pauVar16 + uVar24 * 8);
              iVar20 = (uVar24 + iVar27) - iVar20;
              puVar10 = (undefined8 *)(iVar14 + (uVar24 + iVar27) * 8);
              do {
                uVar44 = *puVar10;
                puVar10 = puVar10 + 1;
                bVar30 = iVar20 != -1;
                iVar20 = iVar20 + 1;
                *puVar9 = uVar44;
                puVar9 = puVar9 + 1;
              } while (bVar30);
            }
          }
          else {
            uVar4 = in_fpscr | (uint)(dVar35 < dVar31) << 0x1f | (uint)(dVar35 == dVar31) << 0x1e;
            uVar24 = uVar4 | (uint)(NAN(dVar35) || NAN(dVar31)) << 0x1c;
            bVar2 = (byte)(uVar4 >> 0x18);
            if ((bool)(bVar2 >> 6 & 1) || bVar2 >> 7 != ((byte)(uVar24 >> 0x1c) & 1)) {
              uVar7 = SUB84(dVar35,0);
              floor((double)CONCAT44(piVar46,piVar45));
              uVar24 = uVar24 & 0xfffffff |
                       (uint)((double)CONCAT44(extraout_r1_01,uVar7) == dVar35) << 0x1e;
              if ((byte)(uVar24 >> 0x1e) == 0) {
                uVar7 = SUB84((dVar31 - dVar35) + 0.5,0);
                floor((double)CONCAT44(piVar46,piVar45));
                dVar37 = (double)CONCAT44(extraout_r1_04,uVar7);
                dVar40 = ABS(dVar35);
                dVar36 = dVar35 + dVar37;
                dVar41 = dVar31;
                if (dVar40 != dVar31 && dVar40 < dVar31 == (NAN(dVar40) || NAN(dVar31))) {
                  dVar41 = dVar40;
                }
                in_q9._0_8_ = dVar41 * 4.440892098500626e-16;
                dVar41 = dVar36 - dVar31;
                in_q9._8_8_ = ABS(dVar41);
                uVar4 = uVar24 & 0xfffffff | (uint)(in_q9._8_8_ < in_q9._0_8_) << 0x1f |
                        (uint)(in_q9._8_8_ == in_q9._0_8_) << 0x1e |
                        (uint)(in_q9._0_8_ <= in_q9._8_8_) << 0x1d;
                if ((int)uVar4 < 0) {
                  dVar37 = dVar37 + 1.0;
                  dVar36 = dVar31;
                }
                else {
                  uVar24 = uVar24 & 0xfffffff | (uint)(dVar41 < 0.0) << 0x1f |
                           (uint)(dVar41 == 0.0) << 0x1e;
                  uVar4 = uVar24 | (uint)NAN(dVar41) << 0x1c;
                  bVar2 = (byte)(uVar24 >> 0x18);
                  if ((bool)(bVar2 >> 6 & 1) || bVar2 >> 7 != ((byte)(uVar4 >> 0x1c) & 1)) {
                    dVar37 = dVar37 + 1.0;
                  }
                  else {
                    dVar36 = dVar35 + dVar37 + -1.0;
                  }
                }
                uVar4 = uVar4 & 0xfffffff | (uint)(dVar37 < 0.0) << 0x1f |
                        (uint)(dVar37 == 0.0) << 0x1e;
                uVar24 = uVar4 | (uint)NAN(dVar37) << 0x1c;
                bVar2 = (byte)(uVar4 >> 0x18);
                dVar41 = 0.0;
                if (!(bool)(bVar2 >> 6 & 1) && bVar2 >> 7 == ((byte)(uVar24 >> 0x1c) & 1)) {
                  dVar41 = dVar37;
                }
                iVar14 = (int)(longlong)dVar41;
                piVar8 = (int *)local_90[1];
                iVar20 = *piVar8;
                iVar27 = piVar8[1];
                *piVar8 = 1;
                piVar8[1] = iVar14;
                emxEnsureCapacity_real_T(local_90,iVar27 * iVar20);
                if (0 < iVar14) {
                  pdVar5 = (double *)*local_90;
                  *pdVar5 = dVar35;
                  if (iVar14 != 1) {
                    iVar27 = iVar14 + -1;
                    pdVar5[iVar27] = dVar36;
                    iVar20 = iVar27 / 2;
                    if (4 < iVar14) {
                      auVar38._8_8_ = dVar41;
                      auVar38._0_8_ = 1.0;
                      iVar26 = 2;
                      if (2 < iVar20) {
                        iVar26 = iVar20;
                      }
                      pdVar13 = pdVar5 + iVar14 + -2;
                      iVar26 = iVar26 + -1;
                      pdVar22 = pdVar5;
                      do {
                        pdVar22 = pdVar22 + 1;
                        dVar41 = auVar38._0_8_;
                        auVar38._8_8_ = dVar35 + dVar41;
                        iVar26 = iVar26 + -1;
                        in_q9._0_8_ = dVar36 - dVar41;
                        auVar38._0_8_ = dVar41 + 1.0;
                        *pdVar22 = auVar38._8_8_;
                        *pdVar13 = in_q9._0_8_;
                        pdVar13 = pdVar13 + -1;
                      } while (iVar26 != 0);
                    }
                    if (iVar27 == iVar20 * 2) {
                      pdVar5[iVar20] = (dVar35 + dVar36) * 0.5;
                    }
                    else {
                      pdVar5[iVar20] = dVar35 + (double)(longlong)iVar20;
                      (pdVar5 + iVar20)[1] = dVar36 - (double)(longlong)iVar20;
                    }
                  }
                }
              }
              else {
                uVar7 = SUB84(dVar31 - dVar35,0);
                floor((double)CONCAT44(piVar46,piVar45));
                iVar26 = (int)(longlong)(double)CONCAT44(extraout_r1_02,uVar7);
                piVar8 = (int *)local_90[1];
                iVar20 = *piVar8;
                iVar27 = piVar8[1];
                iVar14 = iVar26 + 1;
                *piVar8 = 1;
                piVar8[1] = iVar14;
                emxEnsureCapacity_real_T(local_90,iVar27 * iVar20);
                if (-1 < iVar26) {
                  pdVar5 = (double *)*local_90;
                  iVar27 = *(int *)local_90[1];
                  iVar20 = 0;
                  do {
                    iVar26 = iVar20 + 1;
                    *pdVar5 = dVar35 + (double)(longlong)iVar20;
                    pdVar5 = pdVar5 + iVar27;
                    iVar20 = iVar26;
                  } while (iVar14 != iVar26);
                }
              }
            }
            else {
              piVar8 = (int *)local_90[1];
              iVar20 = *piVar8;
              iVar27 = piVar8[1];
              *piVar8 = 1;
              piVar8[1] = 0;
              emxEnsureCapacity_real_T(local_90,iVar27 * iVar20);
            }
            piVar8 = local_94;
            piVar25 = (int *)local_94[1];
            iVar20 = *piVar25;
            iVar27 = piVar25[1];
            *piVar25 = 1;
            dVar35 = (dVar34 + dVar32) - dVar31;
            in_fpscr = uVar24 & 0xfffffff | (uint)(dVar35 < 1.0) << 0x1f |
                       (uint)(dVar35 == 1.0) << 0x1e | (uint)(1.0 <= dVar35) << 0x1d;
            if ((int)in_fpscr < 0) {
              piVar25[1] = 0;
              emxEnsureCapacity_real_T(local_94,iVar27 * iVar20);
            }
            else {
              uVar7 = SUB84(dVar35 + -1.0,0);
              floor((double)CONCAT44(piVar46,piVar45));
              iVar26 = (int)(longlong)(double)CONCAT44(extraout_r1_06,uVar7);
              iVar14 = iVar26 + 1;
              piVar25[1] = iVar14;
              emxEnsureCapacity_real_T(piVar8,iVar27 * iVar20);
              if (-1 < iVar26) {
                pdVar5 = (double *)*local_94;
                iVar27 = *(int *)local_94[1];
                iVar20 = 0;
                do {
                  iVar26 = iVar20 + 1;
                  *pdVar5 = (double)(longlong)iVar20 + 1.0;
                  pdVar5 = pdVar5 + iVar27;
                  iVar20 = iVar26;
                } while (iVar14 != iVar26);
              }
            }
            iVar20 = *(int *)local_9c[1];
            *(int *)local_9c[1] = *(int *)(local_94[1] + 4) + *(int *)(local_90[1] + 4);
            emxEnsureCapacity_int32_T1(local_9c,iVar20);
            piVar8 = (int *)local_90[1];
            iVar20 = piVar8[1];
            if (0 < iVar20) {
              iVar26 = 0;
              iVar27 = *local_90;
              iVar14 = *local_9c;
              do {
                *(int *)(iVar14 + iVar26 * 4) =
                     (int)(longlong)*(double *)(iVar27 + iVar26 * *piVar8 * 8) + -1;
                iVar26 = iVar26 + 1;
              } while (iVar20 != iVar26);
            }
            piVar25 = (int *)local_94[1];
            iVar20 = piVar25[1];
            if (0 < iVar20) {
              iVar14 = 0;
              iVar27 = *local_94;
              iVar26 = *local_9c;
              do {
                iVar18 = iVar14 * *piVar25;
                iVar19 = piVar8[1] + iVar14;
                iVar14 = iVar14 + 1;
                *(int *)(iVar26 + iVar19 * 4) = (int)(longlong)*(double *)(iVar27 + iVar18 * 8) + -1
                ;
              } while (iVar20 != iVar14);
              iVar20 = piVar25[1];
            }
            iVar27 = *(int *)local_98[1];
            *(int *)local_98[1] = piVar8[1] + iVar20;
            emxEnsureCapacity_real_T1(local_98,iVar27);
            iVar20 = *(int *)(local_94[1] + 4) + *(int *)(local_90[1] + 4);
            if (0 < iVar20) {
              puVar10 = (undefined8 *)*local_98;
              iVar27 = *local_84;
              piVar8 = (int *)*local_9c;
              do {
                iVar20 = iVar20 + -1;
                *puVar10 = *(undefined8 *)(iVar27 + *piVar8 * 8);
                puVar10 = puVar10 + 1;
                piVar8 = piVar8 + 1;
              } while (iVar20 != 0);
            }
          }
        }
LAB_00017350:
        uVar44 = c_nanmean(local_98);
        iVar27 = *param_5;
        *(int *)(iVar27 + iVar23 * 8) = (int)uVar44;
        iVar20 = iVar23 * 8;
        iVar23 = iVar23 + 1;
        *(int *)(iVar27 + iVar20 + 4) = (int)((ulonglong)uVar44 >> 0x20);
      } while (iVar23 != iVar28);
    }
    uVar7 = *(undefined4 *)local_8c[1];
    *(undefined4 *)local_8c[1] = *(undefined4 *)local_84[1];
    emxEnsureCapacity_boolean_T(local_8c,uVar7);
    iVar23 = *(int *)local_84[1];
    if (0 < iVar23) {
      uVar3 = rtIsNaN((int)*(undefined8 *)*local_84,
                      (int)((ulonglong)*(undefined8 *)*local_84 >> 0x20));
      *(undefined1 *)*local_8c = uVar3;
      if (iVar23 != 1) {
        iVar20 = 1;
        iVar27 = 8;
        do {
          uVar3 = rtIsNaN((int)*(undefined8 *)(*local_84 + iVar27),
                          (int)((ulonglong)*(undefined8 *)(*local_84 + iVar27) >> 0x20));
          iVar27 = iVar27 + 8;
          *(undefined1 *)(*local_8c + iVar20) = uVar3;
          iVar20 = iVar20 + 1;
        } while (iVar23 != iVar20);
      }
    }
    auVar39 = SIMDExpandImmediate(0,0,1);
    uVar4 = *(uint *)local_8c[1];
    if ((int)uVar4 < 1) {
      uVar7 = *(undefined4 *)local_88[1];
      *(undefined4 *)local_88[1] = 0;
      emxEnsureCapacity_int32_T1(local_88,uVar7);
    }
    else {
      if (uVar4 < 4) {
        uVar12 = 0;
        iVar23 = 0;
LAB_00017b3e:
        iVar20 = uVar4 - uVar12;
        pcVar6 = (char *)(*local_8c + uVar12);
        do {
          if (*pcVar6 != '\0') {
            iVar23 = iVar23 + 1;
          }
          iVar20 = iVar20 + -1;
          pcVar6 = pcVar6 + 1;
        } while (iVar20 != 0);
      }
      else {
        uVar12 = uVar4 & 0xfffffffc;
        auVar38 = ZEXT816(0);
        uVar24 = uVar12;
        puVar15 = (undefined4 *)*local_8c;
        do {
          uVar44 = in_q9._0_8_;
          uVar24 = uVar24 - 4;
                    // WARNING: Ignoring partial resolution of indirect
          uVar7 = *puVar15;
          auVar43 = VectorCopyLong(uVar44,1,1);
          uVar42 = VectorCompareEqual(auVar43._0_8_,0,2);
          in_q9 = VectorCopyLong(~uVar42,2,1);
          in_q9 = in_q9 & auVar39;
          auVar38 = VectorAdd(auVar38,in_q9,4);
          puVar15 = puVar15 + 1;
        } while (uVar24 != 0);
        auVar1._16_16_ = auVar38;
        auVar1._0_16_ = auVar38;
        auVar39 = VectorAdd(auVar38,auVar1._8_16_,4);
        uVar44 = CONCAT44(auVar39._4_4_,auVar39._4_4_);
        in_q9._8_8_ = (double)uVar44;
        in_q9._0_8_ = (double)uVar44;
        auVar39 = VectorAdd(auVar39,in_q9,4);
        iVar23 = auVar39._0_4_;
        if (uVar4 != uVar12) goto LAB_00017b3e;
      }
      iVar20 = *(int *)local_88[1];
      *(int *)local_88[1] = iVar23;
      emxEnsureCapacity_int32_T1(local_88,iVar20);
      if (0 < (int)uVar4) {
        uVar24 = 0;
        iVar20 = 0;
        iVar23 = *local_8c;
        do {
          pcVar6 = (char *)(iVar23 + uVar24);
          uVar24 = uVar24 + 1;
          if (*pcVar6 != '\0') {
            *(uint *)(*local_88 + iVar20 * 4) = uVar24;
            iVar20 = iVar20 + 1;
          }
        } while (uVar4 != uVar24);
      }
    }
    iVar23 = *(int *)local_88[1];
    if (0 < iVar23) {
      iVar20 = *param_5;
      piVar8 = (int *)*local_88;
      do {
        iVar23 = iVar23 + -1;
        *(undefined8 *)(iVar20 + *piVar8 * 8 + -8) = rtNaN;
        piVar8 = piVar8 + 1;
      } while (iVar23 != 0);
    }
    uVar7 = *(undefined4 *)local_84[1];
    *(undefined4 *)local_84[1] = *(undefined4 *)param_5[1];
    emxEnsureCapacity_real_T1(local_84,uVar7);
    uVar4 = *(uint *)param_5[1];
    if (0 < (int)uVar4) {
      pauVar16 = (undefined1 (*) [16])*param_5;
      pauVar21 = (undefined1 (*) [16])*local_84;
      if (uVar4 == 1) {
LAB_00017bfc:
        uVar24 = 0;
      }
      else {
        pauVar17 = (undefined1 (*) [16])(*pauVar16 + uVar4 * 8);
        bVar30 = pauVar21 < pauVar17;
        if (bVar30) {
          pauVar17 = (undefined1 (*) [16])(*pauVar21 + uVar4 * 8);
        }
        if (bVar30 && pauVar16 < pauVar17) goto LAB_00017bfc;
        uVar24 = uVar4 & 0xfffffffe;
        pauVar17 = pauVar16;
        pauVar11 = pauVar21;
        uVar12 = uVar24;
        do {
          auVar39 = *pauVar17;
          pauVar17 = pauVar17 + 1;
          uVar12 = uVar12 - 2;
          *(longlong *)*pauVar11 = auVar39._0_8_;
          *(longlong *)(*pauVar11 + 8) = auVar39._8_8_;
          pauVar11 = pauVar11 + 1;
        } while (uVar12 != 0);
        if (uVar4 == uVar24) goto LAB_00017c1a;
      }
      puVar10 = (undefined8 *)(*pauVar16 + uVar24 * 8);
      puVar9 = (undefined8 *)(*pauVar21 + uVar24 * 8);
      iVar23 = uVar4 - uVar24;
      do {
        uVar44 = *puVar10;
        puVar10 = puVar10 + 1;
        iVar23 = iVar23 + -1;
        *puVar9 = uVar44;
        puVar9 = puVar9 + 1;
      } while (iVar23 != 0);
    }
LAB_00017c1a:
    if (!bVar29) {
      emxFree_int32_T(&local_9c);
      emxFree_real_T(&local_98);
      emxFree_real_T(&local_94);
      emxFree_real_T(&local_90);
      emxFree_boolean_T(&local_8c);
      emxFree_int32_T(&local_88);
      emxFree_real_T(&local_84);
      if (*piVar46 == local_6c) {
        return;
      }
                    // WARNING: Subroutine does not return
      __stack_chk_fail();
    }
    pdVar5 = &local_80 + local_a8;
    local_a8 = 2;
    dVar34 = *pdVar5;
    bVar29 = false;
  } while( true );
}



void b_diff(undefined4 *param_1,undefined4 *param_2)

{
  byte bVar1;
  undefined4 uVar2;
  int iVar3;
  double *pdVar4;
  double *pdVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  byte *pbVar9;
  uint uVar10;
  double *pdVar11;
  undefined8 uVar12;
  ulonglong in_d16;
  ulonglong uVar13;
  undefined2 uVar14;
  double in_d17;
  ulonglong uVar15;
  undefined1 auVar16 [16];
  undefined1 auVar17 [16];
  
  if (*(int *)param_1[1] < 2) {
    uVar2 = *(undefined4 *)param_2[1];
    *(undefined4 *)param_2[1] = 0;
    emxEnsureCapacity_real_T1(param_2,uVar2);
    return;
  }
  iVar3 = *(int *)param_2[1];
  *(int *)param_2[1] = *(int *)param_1[1] + -1;
  emxEnsureCapacity_real_T1(param_2,iVar3);
  if ((*(int *)param_2[1] != 0) && (iVar3 = *(int *)param_1[1], 1 < iVar3)) {
    pbVar9 = (byte *)*param_1;
    uVar8 = iVar3 - 1;
    pdVar11 = (double *)*param_2;
    uVar6 = (uint)*pbVar9;
    if ((uVar8 < 2) || ((pdVar11 < pbVar9 + iVar3 && (pbVar9 + 1 < pdVar11 + iVar3 + -1)))) {
      uVar10 = 1;
      uVar7 = 0;
    }
    else {
      uVar7 = uVar8 & 0xfffffffe;
      uVar10 = uVar8 | 1;
      pdVar4 = (double *)(pbVar9 + 1);
      pdVar5 = pdVar11;
      uVar6 = uVar7;
      uVar13 = in_d16 & 0xffff0000ffffffff;
      do {
        uVar6 = uVar6 - 2;
                    // WARNING (jumptable): Ignoring partial resolution of indirect
                    // WARNING: Ignoring partial resolution of indirect
        uVar14 = *(undefined2 *)pdVar4;
        auVar16 = VectorCopyLong(in_d17,1,1);
        auVar17 = VectorCopyLong(auVar16._0_8_,2,1);
        uVar15 = auVar17._0_8_;
        auVar16._8_8_ = uVar15;
        auVar16._0_8_ = uVar13;
        uVar12 = VectorSub(uVar15,auVar16._4_8_,4);
        in_d17 = (double)(longlong)(int)((ulonglong)uVar12 >> 0x20);
        *pdVar5 = (double)(longlong)(int)uVar12;
        pdVar5[1] = in_d17;
        pdVar5 = pdVar5 + 2;
        pdVar4 = (double *)((int)pdVar4 + 2);
        uVar13 = uVar15;
      } while (uVar6 != 0);
      if (uVar8 == uVar7) {
        return;
      }
      uVar6 = auVar17._4_4_;
    }
    iVar3 = iVar3 + ~uVar7;
    pdVar11 = pdVar11 + uVar7;
    pbVar9 = pbVar9 + uVar10;
    do {
      bVar1 = *pbVar9;
      iVar3 = iVar3 + -1;
      *pdVar11 = (double)(longlong)(int)(bVar1 - uVar6);
      pdVar11 = pdVar11 + 1;
      pbVar9 = pbVar9 + 1;
      uVar6 = (uint)bVar1;
    } while (iVar3 != 0);
  }
  return;
}



void diff(int *param_1,int *param_2)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  double *pdVar4;
  double *pdVar5;
  double dVar6;
  double dVar7;
  
  iVar1 = *(int *)param_1[1];
  if ((iVar1 != 0) && (1 < iVar1)) {
    iVar3 = *(int *)param_2[1];
    *(int *)param_2[1] = iVar1 + -1;
    emxEnsureCapacity_real_T1(param_2,iVar3);
    if (*(int *)param_2[1] != 0) {
      if (*(int *)param_1[1] < 2) {
        return;
      }
      pdVar5 = (double *)*param_1;
      iVar1 = *(int *)param_1[1] + -1;
      pdVar4 = (double *)*param_2;
      dVar6 = *pdVar5;
      do {
        pdVar5 = pdVar5 + 1;
        dVar7 = *pdVar5;
        iVar1 = iVar1 + -1;
        *pdVar4 = dVar7 - dVar6;
        pdVar4 = pdVar4 + 1;
        dVar6 = dVar7;
      } while (iVar1 != 0);
    }
    return;
  }
  uVar2 = *(undefined4 *)param_2[1];
  *(undefined4 *)param_2[1] = 0;
  emxEnsureCapacity_real_T1(param_2,uVar2);
  return;
}



void b_exp(undefined4 *param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r4;
  int iVar2;
  undefined4 unaff_r5;
  undefined8 *puVar3;
  
  iVar2 = *(int *)(param_1[1] + 4);
  if (0 < iVar2) {
    puVar3 = (undefined8 *)*param_1;
    do {
      uVar1 = (undefined4)*puVar3;
      exp((double)CONCAT44(unaff_r5,unaff_r4));
      *(undefined4 *)puVar3 = uVar1;
      *(undefined4 *)((int)puVar3 + 4) = extraout_r1;
      iVar2 = iVar2 + -1;
      puVar3 = puVar3 + 1;
    } while (iVar2 != 0);
  }
  return;
}



// WARNING: Restarted to delay deadcode elimination for space: register

void GRADE(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,double param_5,
          undefined8 *param_6)

{
  uint uVar1;
  int iVar2;
  undefined8 *puVar3;
  undefined4 uVar4;
  int iVar5;
  int *piVar6;
  undefined8 *puVar7;
  int iVar8;
  uint uVar9;
  double *pdVar10;
  uint uVar11;
  double *pdVar12;
  undefined8 *puVar13;
  uint uVar14;
  int iVar15;
  undefined8 *puVar16;
  bool bVar17;
  uint in_fpscr;
  double dVar18;
  double dVar19;
  undefined8 uVar20;
  undefined8 uVar21;
  double in_d17;
  double dVar22;
  double dVar23;
  int *local_68;
  int *local_64;
  int *local_60;
  int *local_5c;
  int *local_58;
  int *local_54;
  uint *local_50;
  int local_4c;
  
  local_4c = __stack_chk_guard;
  emxInit_real_T(&local_50,1);
  iVar2 = *(int *)local_50[1];
  *(int *)local_50[1] = ((int *)param_1[1])[1] * *(int *)param_1[1];
  emxEnsureCapacity_real_T1(local_50,iVar2);
  uVar1 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  if (0 < (int)uVar1) {
    puVar16 = (undefined8 *)*param_1;
    puVar13 = (undefined8 *)*local_50;
    if (uVar1 == 1) {
LAB_00017e7e:
      uVar11 = 0;
    }
    else {
      puVar3 = puVar16 + uVar1;
      bVar17 = puVar13 < puVar3;
      if (bVar17) {
        puVar3 = puVar13 + uVar1;
      }
      if (bVar17 && puVar16 < puVar3) goto LAB_00017e7e;
      uVar11 = uVar1 & 0xfffffffe;
      puVar3 = puVar16;
      puVar7 = puVar13;
      uVar9 = uVar11;
      do {
        uVar20 = *puVar3;
        in_d17 = (double)puVar3[1];
        puVar3 = puVar3 + 2;
        uVar9 = uVar9 - 2;
        *puVar7 = uVar20;
        puVar7[1] = in_d17;
        puVar7 = puVar7 + 2;
      } while (uVar9 != 0);
      if (uVar1 - uVar11 == 0) goto LAB_00017e9c;
    }
    puVar16 = puVar16 + uVar11;
    puVar13 = puVar13 + uVar11;
    iVar2 = uVar1 - uVar11;
    do {
      uVar20 = *puVar16;
      puVar16 = puVar16 + 1;
      iVar2 = iVar2 + -1;
      *puVar13 = uVar20;
      puVar13 = puVar13 + 1;
    } while (iVar2 != 0);
  }
LAB_00017e9c:
  emxInit_real_T(&local_54,1);
  b_log10(local_50);
  b_log10(local_50);
  uVar4 = *(undefined4 *)local_54[1];
  *(undefined4 *)local_54[1] = *(undefined4 *)local_50[1];
  emxEnsureCapacity_real_T1(local_54,uVar4);
  iVar2 = *(int *)local_50[1];
  if (0 < iVar2) {
    pdVar10 = (double *)*local_50;
    pdVar12 = (double *)*local_54;
    do {
      in_d17 = *pdVar10;
      pdVar10 = pdVar10 + 1;
      iVar2 = iVar2 + -1;
      in_d17 = in_d17 + 0.16;
      *pdVar12 = in_d17;
      pdVar12 = pdVar12 + 1;
    } while (iVar2 != 0);
  }
  b_power(local_54);
  emxEnsureCapacity_real_T1(local_50,*(undefined4 *)local_50[1]);
  iVar2 = *(int *)local_50[1];
  if (0 < iVar2) {
    pdVar10 = (double *)*local_50;
    do {
      iVar2 = iVar2 + -1;
      in_d17 = *pdVar10 * 425.0;
      *pdVar10 = in_d17;
      pdVar10 = pdVar10 + 1;
    } while (iVar2 != 0);
  }
  dVar18 = (double)CONCAT44(param_4,param_3);
  dVar19 = (double)nansum();
  uVar20 = c_nanmean(local_50);
  uVar1 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if ((int)uVar1 < 1) {
    emxInit_int32_T1(&local_58,1);
    uVar4 = *(undefined4 *)local_58[1];
    *(undefined4 *)local_58[1] = 0;
    emxEnsureCapacity_int32_T1(local_58,uVar4);
  }
  else {
    uVar11 = 0;
    iVar2 = 0;
    if (uVar1 == 1) {
LAB_00017fb2:
      pdVar10 = (double *)*param_1 + uVar11;
      iVar5 = uVar1 - uVar11;
      do {
        dVar22 = *pdVar10;
        pdVar10 = pdVar10 + 1;
        in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar22 < dVar18) << 0x1f |
                   (uint)(dVar22 == dVar18) << 0x1e | (uint)(dVar18 <= dVar22) << 0x1d;
        if ((int)in_fpscr < 0) {
          iVar2 = iVar2 + 1;
        }
        iVar5 = iVar5 + -1;
      } while (iVar5 != 0);
    }
    else {
      uVar11 = uVar1 & 0xfffffffe;
      uVar21 = 0;
      uVar9 = uVar11;
      pdVar10 = (double *)*param_1;
      do {
        dVar22 = *pdVar10;
        pdVar10 = pdVar10 + 2;
        in_fpscr = in_fpscr & 0xfffffff;
        uVar14 = (uint)((int)(in_fpscr | (uint)(dVar22 < dVar18) << 0x1f |
                              (uint)(dVar22 == dVar18) << 0x1e | (uint)(dVar18 <= dVar22) << 0x1d) <
                       0);
        if (uVar14 != 0) {
          uVar14 = 0xffffffff;
        }
        in_d17 = (double)((ulonglong)in_d17 & 0xffff0000ffff0000 | (ulonglong)uVar14 & 0xffff);
        uVar9 = uVar9 - 2;
        uVar21 = VectorSub(uVar21,in_d17,4);
      } while (uVar9 != 0);
      uVar4 = (undefined4)((ulonglong)uVar21 >> 0x20);
      in_d17 = (double)CONCAT44(uVar4,uVar4);
      uVar21 = VectorAdd(uVar21,in_d17,4);
      iVar2 = (int)uVar21;
      if (uVar1 - uVar11 != 0) goto LAB_00017fb2;
    }
    emxInit_int32_T1(&local_58,1);
    iVar5 = *(int *)local_58[1];
    *(int *)local_58[1] = iVar2;
    emxEnsureCapacity_int32_T1(local_58,iVar5);
    if (0 < (int)uVar1) {
      iVar2 = 0;
      pdVar10 = (double *)*param_1;
      iVar5 = 0;
      do {
        dVar22 = *pdVar10;
        iVar2 = iVar2 + 1;
        pdVar10 = pdVar10 + 1;
        in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar22 < dVar18) << 0x1f |
                   (uint)(dVar22 == dVar18) << 0x1e | (uint)(dVar18 <= dVar22) << 0x1d;
        if ((int)in_fpscr < 0) {
          *(int *)(*local_58 + iVar5 * 4) = iVar2;
          iVar5 = iVar5 + 1;
        }
      } while (uVar1 - iVar2 != 0);
    }
  }
  uVar4 = *(undefined4 *)local_54[1];
  *(undefined4 *)local_54[1] = *(undefined4 *)local_58[1];
  emxEnsureCapacity_real_T1(local_54,uVar4);
  iVar2 = *(int *)local_58[1];
  if (0 < iVar2) {
    uVar1 = *local_50;
    puVar16 = (undefined8 *)*local_54;
    piVar6 = (int *)*local_58;
    do {
      iVar2 = iVar2 + -1;
      *puVar16 = *(undefined8 *)(uVar1 + *piVar6 * 8 + -8);
      puVar16 = puVar16 + 1;
      piVar6 = piVar6 + 1;
    } while (iVar2 != 0);
  }
  emxFree_int32_T(&local_58);
  emxInit_boolean_T(&local_5c,1);
  dVar22 = (double)nansum(local_54);
  iVar2 = *(int *)local_5c[1];
  *(int *)local_5c[1] = ((int *)param_1[1])[1] * *(int *)param_1[1];
  emxEnsureCapacity_boolean_T(local_5c,iVar2);
  iVar2 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  if (0 < iVar2) {
    iVar5 = 0;
    iVar8 = 0;
    do {
      pdVar10 = (double *)(*param_1 + iVar5);
      iVar5 = iVar5 + 8;
      *(bool *)(*local_5c + iVar8) = *pdVar10 < dVar18 == (NAN(*pdVar10) || NAN(dVar18));
      iVar8 = iVar8 + 1;
    } while (iVar2 - iVar8 != 0);
  }
  emxInit_boolean_T(&local_60,1);
  iVar2 = *(int *)local_60[1];
  *(int *)local_60[1] = ((int *)param_1[1])[1] * *(int *)param_1[1];
  emxEnsureCapacity_boolean_T(local_60,iVar2);
  iVar2 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  if (0 < iVar2) {
    iVar5 = 0;
    iVar8 = 0;
    do {
      pdVar10 = (double *)(*param_1 + iVar5);
      iVar5 = iVar5 + 8;
      *(bool *)(*local_60 + iVar8) = *pdVar10 <= param_5;
      iVar8 = iVar8 + 1;
    } while (iVar2 - iVar8 != 0);
  }
  iVar2 = *(int *)local_5c[1];
  if (iVar2 < 1) {
    emxInit_int32_T1(&local_64,1);
    uVar4 = *(undefined4 *)local_64[1];
    *(undefined4 *)local_64[1] = 0;
    emxEnsureCapacity_int32_T1(local_64,uVar4);
  }
  else {
    iVar5 = 0;
    iVar8 = 0;
    do {
      if ((*(char *)(*local_5c + iVar5) != '\0') && (*(char *)(*local_60 + iVar5) != '\0')) {
        iVar8 = iVar8 + 1;
      }
      iVar5 = iVar5 + 1;
    } while (iVar2 != iVar5);
    emxInit_int32_T1(&local_64,1);
    iVar5 = *(int *)local_64[1];
    *(int *)local_64[1] = iVar8;
    emxEnsureCapacity_int32_T1(local_64,iVar5);
    if (0 < iVar2) {
      iVar8 = 0;
      iVar15 = 0;
      iVar5 = *local_5c;
      do {
        if ((*(char *)(iVar5 + iVar8) != '\0') && (*(char *)(*local_60 + iVar8) != '\0')) {
          *(int *)(*local_64 + iVar15 * 4) = iVar8 + 1;
          iVar15 = iVar15 + 1;
        }
        iVar8 = iVar8 + 1;
      } while (iVar2 != iVar8);
    }
  }
  emxFree_boolean_T(&local_60);
  emxFree_boolean_T(&local_5c);
  uVar4 = *(undefined4 *)local_54[1];
  *(undefined4 *)local_54[1] = *(undefined4 *)local_64[1];
  emxEnsureCapacity_real_T1(local_54,uVar4);
  iVar2 = *(int *)local_64[1];
  if (0 < iVar2) {
    uVar1 = *local_50;
    puVar16 = (undefined8 *)*local_54;
    piVar6 = (int *)*local_64;
    do {
      iVar2 = iVar2 + -1;
      *puVar16 = *(undefined8 *)(uVar1 + *piVar6 * 8 + -8);
      puVar16 = puVar16 + 1;
      piVar6 = piVar6 + 1;
    } while (iVar2 != 0);
  }
  emxFree_int32_T(&local_64);
  dVar18 = (double)nansum(local_54);
  uVar1 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if ((int)uVar1 < 1) {
    emxInit_int32_T1(&local_68,1);
    uVar4 = *(undefined4 *)local_68[1];
    *(undefined4 *)local_68[1] = 0;
    emxEnsureCapacity_int32_T1(local_68,uVar4);
    goto LAB_0001830e;
  }
  uVar11 = 0;
  iVar2 = 0;
  if (uVar1 == 1) {
LAB_00018296:
    pdVar10 = (double *)*param_1 + uVar11;
    iVar5 = uVar1 - uVar11;
    do {
      dVar23 = *pdVar10;
      pdVar10 = pdVar10 + 1;
      if (dVar23 != param_5 && dVar23 < param_5 == (NAN(dVar23) || NAN(param_5))) {
        iVar2 = iVar2 + 1;
      }
      iVar5 = iVar5 + -1;
    } while (iVar5 != 0);
  }
  else {
    uVar11 = uVar1 & 0xfffffffe;
    uVar21 = 0;
    uVar9 = uVar11;
    pdVar10 = (double *)*param_1;
    do {
      dVar23 = *pdVar10;
      pdVar10 = pdVar10 + 2;
      uVar14 = (uint)(dVar23 != param_5 && dVar23 < param_5 == (NAN(dVar23) || NAN(param_5)));
      if (uVar14 != 0) {
        uVar14 = 0xffffffff;
      }
      in_d17 = (double)((ulonglong)in_d17 & 0xffff0000ffff0000 | (ulonglong)uVar14 & 0xffff);
      uVar9 = uVar9 - 2;
      uVar21 = VectorSub(uVar21,in_d17,4);
    } while (uVar9 != 0);
    uVar4 = (undefined4)((ulonglong)uVar21 >> 0x20);
    uVar21 = VectorAdd(uVar21,CONCAT44(uVar4,uVar4),4);
    iVar2 = (int)uVar21;
    if (uVar1 - uVar11 != 0) goto LAB_00018296;
  }
  emxInit_int32_T1(&local_68,1);
  iVar5 = *(int *)local_68[1];
  *(int *)local_68[1] = iVar2;
  emxEnsureCapacity_int32_T1(local_68,iVar5);
  if (0 < (int)uVar1) {
    iVar2 = 0;
    pdVar10 = (double *)*param_1;
    iVar5 = 0;
    do {
      dVar23 = *pdVar10;
      iVar2 = iVar2 + 1;
      pdVar10 = pdVar10 + 1;
      if (dVar23 != param_5 && dVar23 < param_5 == (NAN(dVar23) || NAN(param_5))) {
        *(int *)(*local_68 + iVar5 * 4) = iVar2;
        iVar5 = iVar5 + 1;
      }
    } while (uVar1 - iVar2 != 0);
  }
LAB_0001830e:
  uVar4 = *(undefined4 *)local_54[1];
  *(undefined4 *)local_54[1] = *(undefined4 *)local_68[1];
  emxEnsureCapacity_real_T1(local_54,uVar4);
  iVar2 = *(int *)local_68[1];
  if (0 < iVar2) {
    uVar1 = *local_50;
    puVar16 = (undefined8 *)*local_54;
    piVar6 = (int *)*local_68;
    do {
      iVar2 = iVar2 + -1;
      *puVar16 = *(undefined8 *)(uVar1 + *piVar6 * 8 + -8);
      puVar16 = puVar16 + 1;
      piVar6 = piVar6 + 1;
    } while (iVar2 != 0);
  }
  emxFree_int32_T(&local_68);
  emxFree_real_T(&local_50);
  dVar23 = (double)nansum(local_54);
  *param_6 = uVar20;
  param_6[1] = (dVar22 * 100.0) / dVar19;
  param_6[2] = (dVar18 * 100.0) / dVar19;
  param_6[3] = (dVar23 * 100.0) / dVar19;
  emxFree_real_T(&local_54);
  if (__stack_chk_guard == local_4c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void HbA1c(undefined4 param_1)

{
  bool bVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  uint uVar7;
  int iVar8;
  double dVar9;
  undefined8 uVar10;
  double dVar11;
  int *local_1c4;
  double local_1c0 [48];
  int local_3c;
  
  local_3c = __stack_chk_guard;
  emxInit_real_T(&local_1c4,1);
  b_nanmean(param_1,local_1c4);
  iVar8 = (int)(longlong)((double)(longlong)*(int *)local_1c4[1] / 48.0);
  if (iVar8 == 0) {
    local_1c0[0] = rtNaN;
    local_1c0[1] = local_1c0[0];
    local_1c0[2] = local_1c0[0];
    local_1c0[3] = local_1c0[0];
    local_1c0[4] = local_1c0[0];
    local_1c0[5] = local_1c0[0];
    local_1c0[6] = local_1c0[0];
    local_1c0[7] = local_1c0[0];
    local_1c0[8] = local_1c0[0];
    local_1c0[9] = local_1c0[0];
    local_1c0[10] = local_1c0[0];
    local_1c0[0xb] = local_1c0[0];
    local_1c0[0xc] = local_1c0[0];
    local_1c0[0xd] = local_1c0[0];
    local_1c0[0xe] = local_1c0[0];
    local_1c0[0xf] = local_1c0[0];
    local_1c0[0x10] = local_1c0[0];
    local_1c0[0x11] = local_1c0[0];
    local_1c0[0x12] = local_1c0[0];
    local_1c0[0x13] = local_1c0[0];
    local_1c0[0x14] = local_1c0[0];
    local_1c0[0x15] = local_1c0[0];
    local_1c0[0x16] = local_1c0[0];
    local_1c0[0x17] = local_1c0[0];
    local_1c0[0x18] = local_1c0[0];
    local_1c0[0x19] = local_1c0[0];
    local_1c0[0x1a] = local_1c0[0];
    local_1c0[0x1b] = local_1c0[0];
    local_1c0[0x1c] = local_1c0[0];
    local_1c0[0x1d] = local_1c0[0];
    local_1c0[0x1e] = local_1c0[0];
    local_1c0[0x1f] = local_1c0[0];
    local_1c0[0x20] = local_1c0[0];
    local_1c0[0x21] = local_1c0[0];
    local_1c0[0x22] = local_1c0[0];
    local_1c0[0x23] = local_1c0[0];
    local_1c0[0x24] = local_1c0[0];
    local_1c0[0x25] = local_1c0[0];
    local_1c0[0x26] = local_1c0[0];
    local_1c0[0x27] = local_1c0[0];
    local_1c0[0x28] = local_1c0[0];
    local_1c0[0x29] = local_1c0[0];
    local_1c0[0x2a] = local_1c0[0];
    local_1c0[0x2b] = local_1c0[0];
    local_1c0[0x2c] = local_1c0[0];
    local_1c0[0x2d] = local_1c0[0];
    local_1c0[0x2e] = local_1c0[0];
    local_1c0[0x2f] = local_1c0[0];
  }
  else {
    iVar4 = -1;
    iVar6 = -1;
    do {
      iVar5 = iVar6 + 1;
      uVar10 = *(undefined8 *)(*local_1c4 + iVar5 * 8);
      iVar2 = rtIsNaN((int)uVar10,(int)((ulonglong)uVar10 >> 0x20));
      bVar1 = iVar2 == 0;
      if (bVar1) {
        dVar9 = *(double *)(*local_1c4 + iVar5 * 8);
      }
      else {
        dVar9 = 0.0;
      }
      uVar7 = (uint)bVar1;
      if (1 < iVar8) {
        iVar2 = iVar6 * 8 + 0x10;
        iVar5 = iVar6 + iVar8;
        iVar6 = iVar8 + -1;
        uVar7 = (uint)bVar1;
        do {
          iVar3 = rtIsNaN((int)*(undefined8 *)(*local_1c4 + iVar2),
                          (int)((ulonglong)*(undefined8 *)(*local_1c4 + iVar2) >> 0x20));
          if (iVar3 == 0) {
            uVar7 = uVar7 + 1;
            dVar9 = dVar9 + *(double *)(*local_1c4 + iVar2);
          }
          iVar2 = iVar2 + 8;
          iVar6 = iVar6 + -1;
        } while (iVar6 != 0);
      }
      dVar11 = rtNaN;
      if (uVar7 != 0) {
        dVar11 = dVar9 / (double)(longlong)(int)uVar7;
      }
      iVar4 = iVar4 + 1;
      local_1c0[iVar4] = dVar11;
      iVar6 = iVar5;
    } while (iVar4 != 0x2f);
  }
  emxFree_real_T(&local_1c4);
  iVar8 = 8;
  do {
    iVar8 = iVar8 + 8;
  } while (iVar8 != 0x180);
  if (__stack_chk_guard != local_3c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_3c,__stack_chk_guard);
  }
  return;
}



void HBGD(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,double param_5,
         int *param_6)

{
  bool bVar1;
  bool bVar2;
  int *piVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  double *pdVar7;
  int iVar8;
  int iVar9;
  double *pdVar10;
  undefined8 *puVar11;
  undefined8 *puVar12;
  int iVar13;
  undefined8 uVar14;
  double dVar15;
  double dVar16;
  double dVar17;
  double dVar18;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  piVar3 = (int *)param_6[1];
  iVar4 = param_1[1];
  iVar6 = *piVar3;
  iVar9 = piVar3[1];
  *piVar3 = 2;
  piVar3[1] = *(int *)(iVar4 + 4) + 1;
  emxEnsureCapacity_real_T(param_6,iVar9 * iVar6);
  piVar3 = (int *)param_1[1];
  iVar4 = piVar3[1];
  if (0 < iVar4 * 2 + 2) {
    FUN_00022030(*param_6,iVar4 * 0x10 + 0x10);
  }
  iVar9 = 0;
  iVar6 = iVar9;
  if (0 < iVar4) {
    iVar13 = *piVar3;
    bVar1 = false;
    iVar5 = 0;
    dVar15 = 0.0;
    dVar16 = 0.0;
    do {
      if (0 < iVar13) {
        pdVar10 = (double *)(*param_1 + iVar9 * 8);
        iVar6 = iVar13;
        do {
          dVar18 = dVar16 + 1.0;
          dVar17 = *pdVar10;
          dVar15 = dVar15 + 1.0;
          dVar16 = 0.0;
          if (dVar17 != param_5 && dVar17 < param_5 == (NAN(dVar17) || NAN(param_5))) {
            dVar15 = 0.0;
            dVar16 = dVar18;
          }
          if ((!bVar1) && (dVar16 < 2.0 == NAN(dVar16))) {
            pdVar7 = (double *)(*param_6 + iVar5 * *(int *)param_6[1] * 8);
            *pdVar7 = *pdVar7 + 1.0;
            bVar1 = true;
          }
          bVar2 = false;
          if (!bVar1) {
            bVar2 = bVar1;
          }
          if (dVar15 < 2.0 != NAN(dVar15)) {
            bVar2 = bVar1;
          }
          bVar1 = bVar2;
          if (bVar1) {
            iVar8 = *param_6 + iVar5 * *(int *)param_6[1] * 8;
            *(double *)(iVar8 + 8) = *(double *)(iVar8 + 8) + (double)CONCAT44(param_4,param_3);
          }
          pdVar10 = pdVar10 + 1;
          iVar6 = iVar6 + -1;
        } while (iVar6 != 0);
      }
      iVar5 = iVar5 + 1;
      iVar9 = iVar9 + iVar13;
      iVar6 = iVar4;
    } while (iVar5 != iVar4);
  }
  emxInit_real_T1(&local_2c,2);
  piVar3 = (int *)local_2c[1];
  iVar9 = *piVar3;
  iVar5 = piVar3[1];
  *piVar3 = 2;
  piVar3[1] = iVar6;
  emxEnsureCapacity_real_T(local_2c,iVar5 * iVar9);
  if (iVar4 < 1) {
    iVar4 = *param_6;
    iVar9 = *(int *)param_6[1];
  }
  else {
    iVar4 = *param_6;
    iVar9 = *(int *)param_6[1];
    iVar5 = *(int *)local_2c[1];
    puVar12 = (undefined8 *)(*local_2c + 8);
    puVar11 = (undefined8 *)(iVar4 + 8);
    do {
      iVar6 = iVar6 + -1;
      puVar12[-1] = puVar11[-1];
      uVar14 = *puVar11;
      puVar11 = puVar11 + iVar9;
      *puVar12 = uVar14;
      puVar12 = puVar12 + iVar5;
    } while (iVar6 != 0);
  }
  b_sum(local_2c,iVar4 + *(int *)(param_1[1] + 4) * iVar9 * 8);
  emxFree_real_T(&local_2c);
  if (-1 < *(int *)(param_1[1] + 4)) {
    iVar4 = *(int *)(param_1[1] + 4) + 1;
    iVar6 = *(int *)param_6[1];
    pdVar10 = (double *)(*param_6 + 8);
    do {
      dVar15 = pdVar10[-1];
      if (dVar15 != 0.0 && dVar15 < 0.0 == NAN(dVar15)) {
        *pdVar10 = *pdVar10 / dVar15;
      }
      pdVar10 = pdVar10 + iVar6;
      iVar4 = iVar4 + -1;
    } while (iVar4 != 0);
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void HBGI(uint *param_1)

{
  uint uVar1;
  int iVar2;
  undefined8 *puVar3;
  double *pdVar4;
  undefined8 *puVar5;
  uint uVar6;
  undefined8 *puVar7;
  uint uVar8;
  undefined8 *puVar9;
  bool bVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  int *local_24;
  uint *local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  emxInit_real_T(&local_20,1);
  iVar2 = *(int *)local_20[1];
  *(int *)local_20[1] = ((int *)param_1[1])[1] * *(int *)param_1[1];
  emxEnsureCapacity_real_T1(local_20,iVar2);
  uVar1 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  if ((int)uVar1 < 1) goto LAB_000188fa;
  puVar9 = (undefined8 *)*param_1;
  puVar7 = (undefined8 *)*local_20;
  if (uVar1 == 1) {
LAB_000188b0:
    uVar8 = 0;
LAB_000188b2:
    puVar9 = puVar9 + uVar8;
    puVar7 = puVar7 + uVar8;
    iVar2 = uVar1 - uVar8;
    do {
      uVar11 = *puVar9;
      puVar9 = puVar9 + 1;
      iVar2 = iVar2 + -1;
      *puVar7 = uVar11;
      puVar7 = puVar7 + 1;
    } while (iVar2 != 0);
  }
  else {
    puVar3 = puVar9 + uVar1;
    bVar10 = puVar7 < puVar3;
    if (bVar10) {
      puVar3 = puVar7 + uVar1;
    }
    if (bVar10 && puVar9 < puVar3) goto LAB_000188b0;
    uVar8 = uVar1 & 0xfffffffe;
    puVar3 = puVar9;
    puVar5 = puVar7;
    uVar6 = uVar8;
    do {
      uVar11 = *puVar3;
      uVar12 = puVar3[1];
      puVar3 = puVar3 + 2;
      uVar6 = uVar6 - 2;
      *puVar5 = uVar11;
      puVar5[1] = uVar12;
      puVar5 = puVar5 + 2;
    } while (uVar6 != 0);
    if (uVar1 - uVar8 != 0) goto LAB_000188b2;
  }
  if (0 < (int)uVar1) {
    pdVar4 = (double *)*local_20;
    do {
      if ((int)((uint)(*pdVar4 < 6.25) << 0x1f) < 0) {
        *(undefined4 *)pdVar4 = 0;
        *(undefined4 *)((int)pdVar4 + 4) = 0x40190000;
      }
      pdVar4 = pdVar4 + 1;
      uVar1 = uVar1 - 1;
    } while (uVar1 != 0);
  }
LAB_000188fa:
  emxInit_real_T(&local_24,1);
  b_log(local_20);
  c_power(local_20,local_24);
  emxEnsureCapacity_real_T1(local_24,*(undefined4 *)local_24[1]);
  iVar2 = *(int *)local_24[1];
  if (0 < iVar2) {
    pdVar4 = (double *)*local_24;
    do {
      iVar2 = iVar2 + -1;
      *pdVar4 = (*pdVar4 + -1.861) * 1.794;
      pdVar4 = pdVar4 + 1;
    } while (iVar2 != 0);
  }
  b_power(local_24,local_20);
  emxEnsureCapacity_real_T1(local_20,*(undefined4 *)local_20[1]);
  iVar2 = *(int *)local_20[1];
  emxFree_real_T(&local_24);
  if (0 < iVar2) {
    pdVar4 = (double *)*local_20;
    do {
      iVar2 = iVar2 + -1;
      *pdVar4 = *pdVar4 * 10.0;
      pdVar4 = pdVar4 + 1;
    } while (iVar2 != 0);
  }
  c_nanmean();
  emxFree_real_T(&local_20);
  if (__stack_chk_guard == local_1c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_1c,__stack_chk_guard);
}



void IQR(uint *param_1,int *param_2)

{
  undefined1 uVar1;
  int *piVar2;
  undefined4 uVar3;
  double *pdVar4;
  uint uVar5;
  uint *puVar6;
  undefined4 uVar7;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  double *pdVar8;
  int iVar9;
  undefined8 *puVar10;
  int iVar11;
  uint uVar12;
  uint uVar13;
  undefined8 *puVar14;
  undefined8 *puVar15;
  uint uVar16;
  uint uVar17;
  int iVar18;
  undefined8 *puVar19;
  int iVar20;
  uint uVar21;
  bool bVar22;
  double dVar23;
  undefined8 uVar24;
  undefined8 uVar25;
  undefined4 in_stack_ffffff98;
  int *piVar26;
  int *local_5c;
  uint *local_58;
  int local_54;
  
  piVar26 = &__stack_chk_guard;
  local_54 = __stack_chk_guard;
  piVar2 = (int *)param_2[1];
  uVar5 = param_1[1];
  iVar9 = *piVar2;
  iVar11 = piVar2[1];
  *piVar2 = 1;
  piVar2[1] = *(int *)(uVar5 + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar11 * iVar9);
  uVar24 = rtNaN;
  iVar9 = *(int *)(param_1[1] + 4);
  if (-1 < iVar9) {
    uVar5 = iVar9 + 1;
    puVar14 = (undefined8 *)*param_2;
    if ((uVar5 < 2) ||
       ((puVar14 < (undefined8 *)((int)&rtNaN + 1U) && (&rtNaN < puVar14 + iVar9 + 1)))) {
      uVar16 = 0;
    }
    else {
      uVar16 = uVar5 & 0xfffffffe;
      puVar15 = puVar14;
      uVar21 = uVar16;
      do {
        *puVar15 = uVar24;
        puVar15[1] = uVar24;
        puVar15 = puVar15 + 2;
        uVar21 = uVar21 - 2;
      } while (uVar21 != 0);
      if (uVar5 == uVar16) goto LAB_00018a42;
    }
    puVar14 = puVar14 + uVar16;
    iVar9 = (iVar9 - uVar16) + 1;
    do {
      iVar9 = iVar9 + -1;
      *puVar14 = rtNaN;
      puVar14 = puVar14 + 1;
    } while (iVar9 != 0);
  }
LAB_00018a42:
  emxInit_real_T(&local_58,1);
  emxInit_boolean_T(&local_5c,1);
  puVar6 = (uint *)param_1[1];
  uVar5 = puVar6[1];
  if (-1 < (int)uVar5) {
    iVar9 = 0;
    uVar16 = 0;
    do {
      uVar21 = uVar16 + 1;
      if ((int)uVar5 >> 0x1f < (int)(uint)(uVar5 < uVar21)) {
        iVar11 = *(int *)local_58[1];
        *(int *)local_58[1] = *puVar6 * uVar5;
        emxEnsureCapacity_real_T1(local_58,iVar11);
        uVar5 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar5) {
          puVar14 = (undefined8 *)*param_1;
          puVar15 = (undefined8 *)*local_58;
          if (uVar5 == 1) {
LAB_00018b4e:
            uVar17 = 0;
          }
          else {
            puVar19 = puVar14 + uVar5;
            bVar22 = puVar15 < puVar19;
            if (bVar22) {
              puVar19 = puVar15 + uVar5;
            }
            if (bVar22 && puVar14 < puVar19) goto LAB_00018b4e;
            uVar17 = uVar5 & 0xfffffffe;
            puVar19 = puVar14;
            puVar10 = puVar15;
            uVar12 = uVar17;
            do {
              uVar24 = *puVar19;
              uVar25 = puVar19[1];
              puVar19 = puVar19 + 2;
              uVar12 = uVar12 - 2;
              *puVar10 = uVar24;
              puVar10[1] = uVar25;
              puVar10 = puVar10 + 2;
            } while (uVar12 != 0);
            if (uVar5 - uVar17 == 0) goto LAB_00018b6c;
          }
          puVar14 = puVar14 + uVar17;
          puVar15 = puVar15 + uVar17;
          iVar11 = uVar5 - uVar17;
          do {
            uVar24 = *puVar14;
            puVar14 = puVar14 + 1;
            iVar11 = iVar11 + -1;
            *puVar15 = uVar24;
            puVar15 = puVar15 + 1;
          } while (iVar11 != 0);
        }
      }
      else {
        uVar12 = *puVar6;
        puVar6 = (uint *)local_58[1];
        uVar17 = *puVar6;
        *puVar6 = uVar12;
        emxEnsureCapacity_real_T1(local_58,uVar17,puVar6,uVar5 - uVar21);
        if (0 < (int)uVar12) {
          uVar5 = *param_1;
          puVar14 = (undefined8 *)*local_58;
          iVar11 = *(int *)param_1[1];
          if ((uVar12 == 1) ||
             ((puVar14 < (undefined8 *)(iVar11 * uVar16 * 8 + uVar5 + uVar12 * 8) &&
              ((undefined8 *)(iVar11 * uVar16 * 8 + uVar5) < puVar14 + uVar12)))) {
            uVar17 = 0;
          }
          else {
            puVar19 = (undefined8 *)(iVar11 * iVar9 + uVar5);
            uVar17 = uVar12 & 0xfffffffe;
            puVar15 = puVar14;
            uVar13 = uVar17;
            do {
              uVar24 = *puVar19;
              uVar25 = puVar19[1];
              puVar19 = puVar19 + 2;
              uVar13 = uVar13 - 2;
              *puVar15 = uVar24;
              puVar15[1] = uVar25;
              puVar15 = puVar15 + 2;
            } while (uVar13 != 0);
            if (uVar12 == uVar17) goto LAB_00018b6c;
          }
          puVar14 = puVar14 + uVar17;
          iVar18 = uVar12 - uVar17;
          puVar15 = (undefined8 *)(uVar5 + (iVar11 * uVar16 + uVar17) * 8);
          do {
            uVar24 = *puVar15;
            puVar15 = puVar15 + 1;
            iVar18 = iVar18 + -1;
            *puVar14 = uVar24;
            puVar14 = puVar14 + 1;
          } while (iVar18 != 0);
        }
      }
LAB_00018b6c:
      uVar7 = *(undefined4 *)local_5c[1];
      *(undefined4 *)local_5c[1] = *(undefined4 *)local_58[1];
      emxEnsureCapacity_boolean_T(local_5c,uVar7);
      iVar11 = *(int *)local_58[1];
      if (0 < iVar11) {
        uVar1 = rtIsNaN((int)*(undefined8 *)*local_58,
                        (int)((ulonglong)*(undefined8 *)*local_58 >> 0x20));
        *(undefined1 *)*local_5c = uVar1;
        if (iVar11 != 1) {
          iVar18 = 1;
          iVar20 = 8;
          do {
            uVar1 = rtIsNaN((int)*(undefined8 *)(*local_58 + iVar20),
                            (int)((ulonglong)*(undefined8 *)(*local_58 + iVar20) >> 0x20));
            iVar20 = iVar20 + 8;
            *(undefined1 *)(*local_5c + iVar18) = uVar1;
            iVar18 = iVar18 + 1;
          } while (iVar11 != iVar18);
        }
      }
      nullAssignment(local_58,local_5c);
      iVar11 = *(int *)local_58[1];
      if (7 < iVar11) {
        sort();
        dVar23 = ((double)(longlong)iVar11 + 1.0) * 0.25;
        uVar7 = SUB84(dVar23 * 3.0,0);
        floor((double)CONCAT44(piVar26,in_stack_ffffff98));
        uVar3 = SUB84(dVar23,0);
        floor((double)CONCAT44(piVar26,in_stack_ffffff98));
        pdVar8 = (double *)(*local_58 + (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar3) * 8);
        pdVar4 = (double *)(*local_58 + (int)(longlong)(double)CONCAT44(extraout_r1,uVar7) * 8);
        *(double *)(*param_2 + uVar16 * 8) =
             (pdVar4[-1] +
             (dVar23 * 3.0 - (double)CONCAT44(extraout_r1,uVar7)) * (pdVar4[1] - *pdVar4)) -
             (pdVar8[-1] + (dVar23 - (double)CONCAT44(extraout_r1_00,uVar3)) * (pdVar8[1] - *pdVar8)
             );
      }
      puVar6 = (uint *)param_1[1];
      iVar9 = iVar9 + 8;
      uVar5 = puVar6[1];
      bVar22 = (int)uVar16 < (int)uVar5;
      uVar16 = uVar21;
    } while (bVar22);
  }
  emxFree_boolean_T(&local_5c);
  emxFree_real_T(&local_58);
  if (*piVar26 == local_54) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void JINDEX(int *param_1,int *param_2,int *param_3)

{
  int iVar1;
  int *piVar2;
  double *pdVar3;
  int iVar4;
  double *pdVar5;
  int iVar6;
  double *pdVar7;
  double dVar8;
  double dVar9;
  int *local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  emxInit_real_T1(&local_28,2);
  iVar6 = param_1[1];
  piVar2 = (int *)local_28[1];
  iVar1 = *piVar2;
  iVar4 = piVar2[1];
  *piVar2 = 1;
  piVar2[1] = *(int *)(iVar6 + 4);
  emxEnsureCapacity_real_T(local_28,iVar4 * iVar1);
  iVar1 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if (0 < iVar1) {
    pdVar3 = (double *)*param_2;
    pdVar5 = (double *)*param_1;
    pdVar7 = (double *)*local_28;
    do {
      dVar8 = *pdVar3;
      pdVar3 = pdVar3 + 1;
      dVar9 = *pdVar5;
      pdVar5 = pdVar5 + 1;
      iVar1 = iVar1 + -1;
      *pdVar7 = dVar9 + dVar8;
      pdVar7 = pdVar7 + 1;
    } while (iVar1 != 0);
  }
  power(local_28,param_3);
  piVar2 = (int *)param_3[1];
  iVar1 = *piVar2;
  *piVar2 = 1;
  emxEnsureCapacity_real_T(param_3,piVar2[1] * iVar1);
  iVar4 = *(int *)param_3[1];
  iVar1 = ((int *)param_3[1])[1];
  emxFree_real_T(&local_28);
  iVar1 = iVar1 * iVar4;
  if (0 < iVar1) {
    pdVar3 = (double *)*param_3;
    do {
      iVar1 = iVar1 + -1;
      *pdVar3 = *pdVar3 * 0.324;
      pdVar3 = pdVar3 + 1;
    } while (iVar1 != 0);
  }
  if (__stack_chk_guard == local_24) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void LAGE(int *param_1,uint *param_2)

{
  int iVar1;
  int iVar2;
  double *pdVar3;
  int iVar4;
  uint uVar5;
  int *piVar6;
  double *pdVar7;
  undefined8 *puVar8;
  int iVar9;
  double *pdVar10;
  undefined8 *puVar11;
  uint uVar12;
  int iVar13;
  uint uVar14;
  int iVar15;
  int iVar16;
  int iVar17;
  int iVar18;
  undefined8 *puVar19;
  undefined8 *puVar20;
  int *piVar21;
  bool bVar22;
  double dVar23;
  double dVar24;
  double dVar25;
  undefined8 uVar26;
  double dVar27;
  undefined8 uVar28;
  undefined8 uVar29;
  int *local_44;
  uint *local_40;
  int local_3c;
  
  local_3c = __stack_chk_guard;
  emxInit_real_T1(&local_40,2);
  iVar13 = param_1[1];
  piVar6 = (int *)local_40[1];
  iVar4 = *piVar6;
  iVar9 = piVar6[1];
  *piVar6 = 1;
  piVar6[1] = *(int *)(iVar13 + 4);
  emxEnsureCapacity_real_T(local_40,iVar9 * iVar4);
  if (0 < ((int *)param_1[1])[1]) {
    iVar15 = *(int *)param_1[1];
    iVar13 = 8;
    iVar4 = 1;
    iVar9 = 0;
    do {
      iVar17 = iVar4;
      iVar4 = iVar9 * iVar15;
      dVar23 = *(double *)(*param_1 + iVar4 * 8);
      if (1 < iVar15) {
        iVar18 = iVar9 * iVar15 + iVar15;
        iVar1 = rtIsNaN(SUB84(dVar23,0),(int)((ulonglong)dVar23 >> 0x20));
        if (iVar1 == 0) {
          iVar4 = iVar4 + 1;
        }
        else {
          iVar1 = iVar4 + 2;
          iVar16 = iVar13;
          do {
            iVar4 = iVar1;
            iVar2 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar16),
                            (int)((ulonglong)*(undefined8 *)(*param_1 + iVar16) >> 0x20));
            if (iVar2 == 0) {
              dVar23 = *(double *)(*param_1 + iVar16);
              break;
            }
            if (iVar18 <= iVar4) break;
            iVar16 = iVar16 + 8;
            iVar1 = iVar4 + 1;
          } while (iVar2 != 0);
        }
        if (iVar4 < iVar18) {
          pdVar3 = (double *)(*param_1 + iVar4 * 8);
          do {
            dVar24 = *pdVar3;
            pdVar3 = pdVar3 + 1;
            iVar4 = iVar4 + 1;
            if (dVar24 != dVar23 && dVar24 < dVar23 == (NAN(dVar24) || NAN(dVar23))) {
              dVar23 = dVar24;
            }
          } while (iVar4 < iVar18);
        }
      }
      iVar13 = iVar13 + iVar15 * 8;
      iVar1 = *(int *)(param_1[1] + 4);
      *(double *)(*local_40 + iVar9 * 8) = dVar23;
      iVar4 = iVar17 + 1;
      iVar9 = iVar17;
    } while (iVar17 < iVar1);
  }
  emxInit_real_T1(&local_44,2);
  iVar13 = param_1[1];
  piVar6 = (int *)local_44[1];
  iVar4 = *piVar6;
  iVar9 = piVar6[1];
  *piVar6 = 1;
  piVar6[1] = *(int *)(iVar13 + 4);
  emxEnsureCapacity_real_T(local_44,iVar9 * iVar4);
  iVar9 = *(int *)param_1[1];
  iVar4 = ((int *)param_1[1])[1];
  if (0 < iVar4) {
    iVar17 = 8;
    iVar13 = 1;
    iVar15 = 0;
    do {
      iVar1 = iVar13;
      iVar4 = iVar15 * iVar9;
      dVar23 = *(double *)(*param_1 + iVar4 * 8);
      if (1 < iVar9) {
        iVar18 = iVar15 * iVar9 + iVar9;
        iVar13 = rtIsNaN(SUB84(dVar23,0),(int)((ulonglong)dVar23 >> 0x20));
        if (iVar13 == 0) {
          iVar4 = iVar4 + 1;
        }
        else {
          iVar13 = iVar4 + 2;
          iVar16 = iVar17;
          do {
            iVar4 = iVar13;
            iVar2 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar16),
                            (int)((ulonglong)*(undefined8 *)(*param_1 + iVar16) >> 0x20));
            if (iVar2 == 0) {
              dVar23 = *(double *)(*param_1 + iVar16);
              break;
            }
            if (iVar18 <= iVar4) break;
            iVar16 = iVar16 + 8;
            iVar13 = iVar4 + 1;
          } while (iVar2 != 0);
        }
        if (iVar4 < iVar18) {
          pdVar3 = (double *)(*param_1 + iVar4 * 8);
          do {
            dVar24 = *pdVar3;
            pdVar3 = pdVar3 + 1;
            iVar4 = iVar4 + 1;
            if ((int)((uint)(dVar24 < dVar23) << 0x1f) < 0) {
              dVar23 = dVar24;
            }
          } while (iVar4 < iVar18);
        }
      }
      iVar17 = iVar17 + iVar9 * 8;
      piVar6 = (int *)param_1[1];
      iVar4 = piVar6[1];
      *(double *)(*local_44 + iVar15 * 8) = dVar23;
      iVar13 = iVar1 + 1;
      iVar15 = iVar1;
    } while (iVar1 < iVar4);
    iVar9 = *piVar6;
  }
  iVar9 = iVar9 * iVar4;
  dVar23 = *(double *)*param_1;
  if (iVar9 < 2) {
    dVar24 = *(double *)*param_1;
  }
  else {
    iVar4 = rtIsNaN(SUB84(dVar23,0),(int)((ulonglong)dVar23 >> 0x20));
    if (iVar4 == 0) {
      iVar4 = 1;
    }
    else {
      iVar15 = 8;
      iVar13 = 2;
      do {
        iVar4 = iVar13;
        iVar17 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar15),
                         (int)((ulonglong)*(undefined8 *)(*param_1 + iVar15) >> 0x20));
        if (iVar17 == 0) {
          dVar23 = *(double *)(*param_1 + iVar15);
          break;
        }
        if (iVar9 <= iVar4) break;
        iVar15 = iVar15 + 8;
        iVar13 = iVar4 + 1;
      } while (iVar17 != 0);
    }
    iVar15 = ((int *)param_1[1])[1] * *(int *)param_1[1];
    iVar13 = iVar15;
    if (iVar4 < iVar15) {
      iVar13 = iVar9;
    }
    if (iVar4 < iVar13) {
      pdVar3 = (double *)*param_1 + iVar4;
      iVar9 = iVar9 - iVar4;
      do {
        dVar24 = *pdVar3;
        pdVar3 = pdVar3 + 1;
        if (dVar24 != dVar23 && dVar24 < dVar23 == (NAN(dVar24) || NAN(dVar23))) {
          dVar23 = dVar24;
        }
        iVar9 = iVar9 + -1;
      } while (iVar9 != 0);
    }
    dVar24 = *(double *)*param_1;
    if (1 < iVar15) {
      iVar4 = rtIsNaN(SUB84(dVar24,0),(int)((ulonglong)dVar24 >> 0x20));
      if (iVar4 == 0) {
        iVar4 = 1;
      }
      else {
        iVar13 = 8;
        iVar9 = 2;
        do {
          iVar4 = iVar9;
          iVar17 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar13),
                           (int)((ulonglong)*(undefined8 *)(*param_1 + iVar13) >> 0x20));
          if (iVar17 == 0) {
            dVar24 = *(double *)(*param_1 + iVar13);
            break;
          }
          if (iVar15 <= iVar4) break;
          iVar13 = iVar13 + 8;
          iVar9 = iVar4 + 1;
        } while (iVar17 != 0);
      }
      iVar9 = *(int *)param_1[1] * ((int *)param_1[1])[1];
      if (iVar4 < iVar9) {
        iVar9 = iVar15;
      }
      if (iVar4 < iVar9) {
        iVar15 = iVar15 - iVar4;
        pdVar3 = (double *)(*param_1 + iVar4 * 8);
        do {
          dVar25 = *pdVar3;
          pdVar3 = pdVar3 + 1;
          if ((int)((uint)(dVar25 < dVar24) << 0x1f) < 0) {
            dVar24 = dVar25;
          }
          iVar15 = iVar15 + -1;
        } while (iVar15 != 0);
      }
    }
  }
  piVar6 = (int *)param_2[1];
  iVar4 = *piVar6;
  iVar9 = piVar6[1];
  *piVar6 = 1;
  piVar6[1] = *(int *)(local_40[1] + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar9 * iVar4);
  iVar4 = ((int *)local_40[1])[1];
  if (0 < iVar4) {
    pdVar3 = (double *)*param_2;
    pdVar7 = (double *)*local_44;
    iVar13 = *(int *)local_40[1];
    iVar9 = *(int *)param_2[1];
    iVar15 = *(int *)local_44[1];
    pdVar10 = (double *)*local_40;
    do {
      dVar25 = *pdVar7;
      pdVar7 = pdVar7 + iVar15;
      dVar27 = *pdVar10;
      pdVar10 = pdVar10 + iVar13;
      iVar4 = iVar4 + -1;
      *pdVar3 = dVar27 - dVar25;
      pdVar3 = pdVar3 + iVar9;
    } while (iVar4 != 0);
  }
  emxFree_real_T(&local_44);
  pdVar3 = (double *)*param_2;
  iVar4 = ((int *)param_2[1])[1];
  uVar12 = iVar4 - 1;
  pdVar3[*(int *)param_2[1] * *(int *)(local_40[1] + 4)] = dVar23 - dVar24;
  dVar23 = *pdVar3;
  if (iVar4 < 2) {
    uVar12 = 0;
  }
  if (1 < (int)uVar12) {
    iVar4 = rtIsNaN(SUB84(dVar23,0),(int)((ulonglong)dVar23 >> 0x20));
    if (iVar4 == 0) {
      iVar4 = 1;
    }
    else {
      iVar13 = 8;
      iVar9 = 2;
      do {
        iVar4 = iVar9;
        iVar15 = rtIsNaN((int)*(undefined8 *)(*param_2 + iVar13),
                         (int)((ulonglong)*(undefined8 *)(*param_2 + iVar13) >> 0x20));
        if (iVar15 == 0) {
          dVar23 = *(double *)(*param_2 + iVar13);
          if ((int)uVar12 <= iVar4) goto LAB_0001919a;
          goto LAB_0001917a;
        }
        if ((int)uVar12 <= iVar4) break;
        iVar13 = iVar13 + 8;
        iVar9 = iVar4 + 1;
      } while (iVar15 != 0);
    }
    if (iVar4 < (int)uVar12) {
LAB_0001917a:
      iVar9 = uVar12 - iVar4;
      pdVar3 = (double *)(*param_2 + iVar4 * 8);
      do {
        dVar24 = *pdVar3;
        pdVar3 = pdVar3 + 1;
        if (dVar24 != dVar23 && dVar24 < dVar23 == (NAN(dVar24) || NAN(dVar23))) {
          dVar23 = dVar24;
        }
        iVar9 = iVar9 + -1;
      } while (iVar9 != 0);
    }
  }
LAB_0001919a:
  piVar6 = (int *)local_40[1];
  iVar4 = *piVar6;
  iVar9 = piVar6[1];
  *piVar6 = 1;
  piVar6[1] = uVar12;
  emxEnsureCapacity_real_T(local_40,iVar9 * iVar4);
  if (0 < (int)uVar12) {
    puVar20 = (undefined8 *)*param_2;
    puVar19 = (undefined8 *)*local_40;
    iVar4 = *(int *)local_40[1];
    uVar5 = 0;
    if ((uVar12 != 1) && (iVar4 == 1)) {
      puVar8 = puVar20 + uVar12;
      bVar22 = puVar19 < puVar8;
      if (bVar22) {
        puVar8 = puVar19 + uVar12;
      }
      if (bVar22 && puVar20 < puVar8) {
        uVar5 = 0;
      }
      else {
        uVar5 = uVar12 & 0xfffffffe;
        puVar8 = puVar20;
        puVar11 = puVar19;
        uVar14 = uVar5;
        do {
          uVar26 = *puVar8;
          uVar28 = puVar8[1];
          puVar8 = puVar8 + 2;
          uVar14 = uVar14 - 2;
          *puVar11 = uVar26;
          puVar11[1] = uVar28;
          puVar11 = puVar11 + 2;
        } while (uVar14 != 0);
        if (uVar12 == uVar5) goto LAB_00019226;
      }
    }
    puVar20 = puVar20 + uVar5;
    iVar9 = uVar12 - uVar5;
    puVar19 = puVar19 + uVar5 * iVar4;
    do {
      uVar26 = *puVar20;
      puVar20 = puVar20 + 1;
      iVar9 = iVar9 + -1;
      *puVar19 = uVar26;
      puVar19 = puVar19 + iVar4;
    } while (iVar9 != 0);
  }
LAB_00019226:
  uVar26 = nanmean(local_40);
  uVar12 = param_2[1];
  piVar6 = (int *)local_40[1];
  iVar4 = *piVar6;
  iVar9 = piVar6[1];
  *piVar6 = 1;
  piVar6[1] = *(int *)(uVar12 + 4) + 2;
  emxEnsureCapacity_real_T(local_40,iVar9 * iVar4);
  piVar6 = (int *)param_2[1];
  uVar12 = piVar6[1];
  if ((int)uVar12 < 1) {
    iVar4 = *piVar6;
    puVar19 = (undefined8 *)*local_40;
    piVar21 = (int *)local_40[1];
    iVar9 = *piVar21;
  }
  else {
    iVar4 = *piVar6;
    uVar5 = 0;
    puVar19 = (undefined8 *)*local_40;
    piVar21 = (int *)local_40[1];
    puVar20 = (undefined8 *)*param_2;
    iVar9 = *piVar21;
    if ((uVar12 != 1) && (iVar9 == 1 && iVar4 == 1)) {
      puVar8 = puVar20 + uVar12;
      bVar22 = puVar19 < puVar8;
      if (bVar22) {
        puVar8 = puVar19 + uVar12;
      }
      if (bVar22 && puVar20 < puVar8) {
        uVar5 = 0;
      }
      else {
        uVar5 = uVar12 & 0xfffffffe;
        uVar14 = uVar5;
        puVar8 = puVar20;
        puVar11 = puVar19;
        do {
          uVar28 = *puVar8;
          uVar29 = puVar8[1];
          puVar8 = puVar8 + iVar4 * 2;
          uVar14 = uVar14 - 2;
          *puVar11 = uVar28;
          puVar11[1] = uVar29;
          puVar11 = puVar11 + iVar9 * 2;
        } while (uVar14 != 0);
        if (uVar12 == uVar5) goto LAB_000192bc;
      }
    }
    iVar13 = uVar12 - uVar5;
    puVar20 = puVar20 + uVar5 * iVar4;
    puVar8 = puVar19 + uVar5 * iVar9;
    do {
      uVar28 = *puVar20;
      puVar20 = puVar20 + iVar4;
      iVar13 = iVar13 + -1;
      *puVar8 = uVar28;
      puVar8 = puVar8 + iVar9;
    } while (iVar13 != 0);
  }
LAB_000192bc:
  *piVar6 = 1;
  piVar6[1] = piVar21[1];
  puVar19[iVar9 * uVar12] = uVar26;
  puVar19[iVar9 * (uVar12 + 1)] = dVar23;
  emxEnsureCapacity_real_T(param_2,iVar4 * uVar12);
  uVar12 = ((int *)local_40[1])[1];
  if (0 < (int)uVar12) {
    puVar19 = (undefined8 *)*param_2;
    uVar5 = 0;
    iVar4 = *(int *)local_40[1];
    puVar20 = (undefined8 *)*local_40;
    iVar9 = *(int *)param_2[1];
    if ((uVar12 != 1) && (iVar9 == 1 && iVar4 == 1)) {
      puVar8 = puVar20 + uVar12;
      bVar22 = puVar19 < puVar8;
      if (bVar22) {
        puVar8 = puVar19 + uVar12;
      }
      if (bVar22 && puVar20 < puVar8) {
        uVar5 = 0;
      }
      else {
        uVar5 = uVar12 & 0xfffffffe;
        puVar8 = puVar19;
        puVar11 = puVar20;
        uVar14 = uVar5;
        do {
          uVar26 = *puVar11;
          uVar28 = puVar11[1];
          puVar11 = puVar11 + iVar4 * 2;
          uVar14 = uVar14 - 2;
          *puVar8 = uVar26;
          puVar8[1] = uVar28;
          puVar8 = puVar8 + iVar9 * 2;
        } while (uVar14 != 0);
        if (uVar12 == uVar5) goto LAB_00019346;
      }
    }
    iVar13 = uVar12 - uVar5;
    puVar20 = puVar20 + uVar5 * iVar4;
    puVar19 = puVar19 + uVar5 * iVar9;
    do {
      uVar26 = *puVar20;
      puVar20 = puVar20 + iVar4;
      iVar13 = iVar13 + -1;
      *puVar19 = uVar26;
      puVar19 = puVar19 + iVar9;
    } while (iVar13 != 0);
  }
LAB_00019346:
  emxFree_real_T(&local_40);
  if (__stack_chk_guard != local_3c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void LBGD(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,double param_5,
         int *param_6)

{
  bool bVar1;
  bool bVar2;
  int *piVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  double *pdVar7;
  int iVar8;
  int iVar9;
  double *pdVar10;
  undefined8 *puVar11;
  undefined8 *puVar12;
  int iVar13;
  undefined8 uVar14;
  double dVar15;
  double dVar16;
  double dVar17;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  piVar3 = (int *)param_6[1];
  iVar4 = param_1[1];
  iVar6 = *piVar3;
  iVar9 = piVar3[1];
  *piVar3 = 2;
  piVar3[1] = *(int *)(iVar4 + 4) + 1;
  emxEnsureCapacity_real_T(param_6,iVar9 * iVar6);
  piVar3 = (int *)param_1[1];
  iVar4 = piVar3[1];
  if (0 < iVar4 * 2 + 2) {
    FUN_00022030(*param_6,iVar4 * 0x10 + 0x10);
  }
  iVar9 = 0;
  iVar6 = iVar9;
  if (0 < iVar4) {
    iVar13 = *piVar3;
    bVar1 = false;
    iVar5 = 0;
    dVar15 = 0.0;
    dVar16 = 0.0;
    do {
      if (0 < iVar13) {
        pdVar10 = (double *)(*param_1 + iVar9 * 8);
        iVar6 = iVar13;
        do {
          dVar17 = dVar16 + 1.0;
          dVar15 = dVar15 + 1.0;
          dVar16 = 0.0;
          if ((int)((uint)(*pdVar10 < param_5) << 0x1f) < 0) {
            dVar15 = 0.0;
            dVar16 = dVar17;
          }
          if ((!bVar1) && (dVar16 < 2.0 == NAN(dVar16))) {
            pdVar7 = (double *)(*param_6 + iVar5 * *(int *)param_6[1] * 8);
            *pdVar7 = *pdVar7 + 1.0;
            bVar1 = true;
          }
          bVar2 = false;
          if (!bVar1) {
            bVar2 = bVar1;
          }
          if (dVar15 < 2.0 != NAN(dVar15)) {
            bVar2 = bVar1;
          }
          bVar1 = bVar2;
          if (bVar1) {
            iVar8 = *param_6 + iVar5 * *(int *)param_6[1] * 8;
            *(double *)(iVar8 + 8) = *(double *)(iVar8 + 8) + (double)CONCAT44(param_4,param_3);
          }
          pdVar10 = pdVar10 + 1;
          iVar6 = iVar6 + -1;
        } while (iVar6 != 0);
      }
      iVar5 = iVar5 + 1;
      iVar9 = iVar9 + iVar13;
      iVar6 = iVar4;
    } while (iVar5 != iVar4);
  }
  emxInit_real_T1(&local_2c,2);
  piVar3 = (int *)local_2c[1];
  iVar9 = *piVar3;
  iVar5 = piVar3[1];
  *piVar3 = 2;
  piVar3[1] = iVar6;
  emxEnsureCapacity_real_T(local_2c,iVar5 * iVar9);
  if (iVar4 < 1) {
    iVar4 = *param_6;
    iVar9 = *(int *)param_6[1];
  }
  else {
    iVar4 = *param_6;
    iVar9 = *(int *)param_6[1];
    iVar5 = *(int *)local_2c[1];
    puVar12 = (undefined8 *)(*local_2c + 8);
    puVar11 = (undefined8 *)(iVar4 + 8);
    do {
      iVar6 = iVar6 + -1;
      puVar12[-1] = puVar11[-1];
      uVar14 = *puVar11;
      puVar11 = puVar11 + iVar9;
      *puVar12 = uVar14;
      puVar12 = puVar12 + iVar5;
    } while (iVar6 != 0);
  }
  b_sum(local_2c,iVar4 + *(int *)(param_1[1] + 4) * iVar9 * 8);
  emxFree_real_T(&local_2c);
  if (-1 < *(int *)(param_1[1] + 4)) {
    iVar4 = *(int *)(param_1[1] + 4) + 1;
    iVar6 = *(int *)param_6[1];
    pdVar10 = (double *)(*param_6 + 8);
    do {
      dVar15 = pdVar10[-1];
      if (dVar15 != 0.0 && dVar15 < 0.0 == NAN(dVar15)) {
        *pdVar10 = *pdVar10 / dVar15;
      }
      pdVar10 = pdVar10 + iVar6;
      iVar4 = iVar4 + -1;
    } while (iVar4 != 0);
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void LBGI(uint *param_1)

{
  uint uVar1;
  int iVar2;
  undefined8 *puVar3;
  double *pdVar4;
  undefined8 *puVar5;
  uint uVar6;
  undefined8 *puVar7;
  uint uVar8;
  undefined8 *puVar9;
  bool bVar10;
  undefined8 uVar11;
  undefined8 uVar12;
  double dVar13;
  int *local_24;
  uint *local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  emxInit_real_T(&local_20,1);
  iVar2 = *(int *)local_20[1];
  *(int *)local_20[1] = ((int *)param_1[1])[1] * *(int *)param_1[1];
  emxEnsureCapacity_real_T1(local_20,iVar2);
  uVar1 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  if ((int)uVar1 < 1) goto LAB_000196a2;
  puVar9 = (undefined8 *)*param_1;
  puVar7 = (undefined8 *)*local_20;
  if (uVar1 == 1) {
LAB_00019658:
    uVar8 = 0;
LAB_0001965a:
    puVar9 = puVar9 + uVar8;
    puVar7 = puVar7 + uVar8;
    iVar2 = uVar1 - uVar8;
    do {
      uVar11 = *puVar9;
      puVar9 = puVar9 + 1;
      iVar2 = iVar2 + -1;
      *puVar7 = uVar11;
      puVar7 = puVar7 + 1;
    } while (iVar2 != 0);
  }
  else {
    puVar3 = puVar9 + uVar1;
    bVar10 = puVar7 < puVar3;
    if (bVar10) {
      puVar3 = puVar7 + uVar1;
    }
    if (bVar10 && puVar9 < puVar3) goto LAB_00019658;
    uVar8 = uVar1 & 0xfffffffe;
    puVar3 = puVar9;
    puVar5 = puVar7;
    uVar6 = uVar8;
    do {
      uVar11 = *puVar3;
      uVar12 = puVar3[1];
      puVar3 = puVar3 + 2;
      uVar6 = uVar6 - 2;
      *puVar5 = uVar11;
      puVar5[1] = uVar12;
      puVar5 = puVar5 + 2;
    } while (uVar6 != 0);
    if (uVar1 - uVar8 != 0) goto LAB_0001965a;
  }
  if (0 < (int)uVar1) {
    pdVar4 = (double *)*local_20;
    do {
      dVar13 = *pdVar4;
      if (dVar13 != 6.25 && dVar13 < 6.25 == NAN(dVar13)) {
        *(undefined4 *)pdVar4 = 0;
        *(undefined4 *)((int)pdVar4 + 4) = 0x40190000;
      }
      pdVar4 = pdVar4 + 1;
      uVar1 = uVar1 - 1;
    } while (uVar1 != 0);
  }
LAB_000196a2:
  emxInit_real_T(&local_24,1);
  b_log(local_20);
  c_power(local_20,local_24);
  emxEnsureCapacity_real_T1(local_24,*(undefined4 *)local_24[1]);
  iVar2 = *(int *)local_24[1];
  if (0 < iVar2) {
    pdVar4 = (double *)*local_24;
    do {
      iVar2 = iVar2 + -1;
      *pdVar4 = (*pdVar4 + -1.861) * 1.794;
      pdVar4 = pdVar4 + 1;
    } while (iVar2 != 0);
  }
  b_power(local_24,local_20);
  emxEnsureCapacity_real_T1(local_20,*(undefined4 *)local_20[1]);
  iVar2 = *(int *)local_20[1];
  emxFree_real_T(&local_24);
  if (0 < iVar2) {
    pdVar4 = (double *)*local_20;
    do {
      iVar2 = iVar2 + -1;
      *pdVar4 = *pdVar4 * 10.0;
      pdVar4 = pdVar4 + 1;
    } while (iVar2 != 0);
  }
  c_nanmean();
  emxFree_real_T(&local_20);
  if (__stack_chk_guard == local_1c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_1c,__stack_chk_guard);
}



void b_log(undefined4 *param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r4;
  int iVar2;
  undefined4 unaff_r5;
  undefined8 *puVar3;
  
  iVar2 = *(int *)param_1[1];
  if (0 < iVar2) {
    puVar3 = (undefined8 *)*param_1;
    do {
      uVar1 = (undefined4)*puVar3;
      log((double)CONCAT44(unaff_r5,unaff_r4));
      *(undefined4 *)puVar3 = uVar1;
      *(undefined4 *)((int)puVar3 + 4) = extraout_r1;
      iVar2 = iVar2 + -1;
      puVar3 = puVar3 + 1;
    } while (iVar2 != 0);
  }
  return;
}



void b_log10(undefined4 *param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r4;
  int iVar2;
  undefined4 unaff_r5;
  undefined8 *puVar3;
  
  iVar2 = *(int *)param_1[1];
  if (0 < iVar2) {
    puVar3 = (undefined8 *)*param_1;
    do {
      uVar1 = (undefined4)*puVar3;
      log10((double)CONCAT44(unaff_r5,unaff_r4));
      *(undefined4 *)puVar3 = uVar1;
      *(undefined4 *)((int)puVar3 + 4) = extraout_r1;
      iVar2 = iVar2 + -1;
      puVar3 = puVar3 + 1;
    } while (iVar2 != 0);
  }
  return;
}



void MAG(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  undefined4 uVar1;
  int iVar2;
  undefined4 extraout_r1;
  int *piVar3;
  uint *puVar4;
  undefined8 *puVar5;
  int iVar6;
  double *pdVar7;
  int iVar8;
  uint uVar9;
  uint uVar10;
  double *pdVar11;
  uint uVar12;
  uint uVar13;
  undefined8 *puVar14;
  uint uVar15;
  double *pdVar16;
  int *piVar17;
  undefined8 *puVar18;
  undefined8 *puVar19;
  bool bVar20;
  int iVar21;
  double dVar22;
  undefined8 uVar23;
  double dVar24;
  undefined8 uVar25;
  undefined4 in_stack_ffffffb8;
  int *piVar26;
  int *local_3c;
  uint *local_38;
  int local_34;
  
  piVar26 = &__stack_chk_guard;
  local_34 = __stack_chk_guard;
  piVar3 = (int *)param_1[1];
  piVar17 = (int *)param_5[1];
  iVar2 = *piVar17;
  iVar8 = piVar17[1];
  iVar21 = *piVar3;
  *piVar17 = 1;
  piVar17[1] = piVar3[1] + 1;
  emxEnsureCapacity_real_T(param_5,iVar8 * iVar2);
  uVar1 = SUB84(((double)(longlong)iVar21 * (double)CONCAT44(param_4,param_3)) / 24.0,0);
  floor((double)CONCAT44(piVar26,in_stack_ffffffb8));
  uVar23 = rtNaN;
  iVar2 = *(int *)(param_1[1] + 4);
  if (-1 < iVar2) {
    uVar9 = iVar2 + 1;
    puVar18 = (undefined8 *)*param_5;
    if (uVar9 < 2) {
      uVar13 = 0;
    }
    else if ((&rtNaN < puVar18) || (puVar18 + iVar2 + 1 < (undefined8 *)((int)&rtNaN + 1))) {
      uVar13 = uVar9 & 0xfffffffe;
      puVar14 = puVar18;
      uVar15 = uVar13;
      do {
        *puVar14 = uVar23;
        puVar14[1] = uVar23;
        puVar14 = puVar14 + 2;
        uVar15 = uVar15 - 2;
      } while (uVar15 != 0);
      if (uVar9 == uVar13) goto LAB_0001987a;
    }
    else {
      uVar13 = 0;
    }
    puVar18 = puVar18 + uVar13;
    iVar2 = (iVar2 - uVar13) + 1;
    do {
      iVar2 = iVar2 + -1;
      *puVar18 = rtNaN;
      puVar18 = puVar18 + 1;
    } while (iVar2 != 0);
  }
LAB_0001987a:
  emxInit_real_T(&local_38,1);
  emxInit_real_T(&local_3c,1);
  puVar4 = (uint *)param_1[1];
  uVar9 = puVar4[1];
  if (-1 < (int)uVar9) {
    iVar2 = 0;
    dVar22 = (double)CONCAT44(extraout_r1,uVar1) + 1.0;
    uVar15 = 0;
    do {
      if ((int)uVar9 >> 0x1f < (int)(uint)(uVar9 < uVar15 + 1)) {
        iVar8 = *(int *)local_38[1];
        *(int *)local_38[1] = *puVar4 * uVar9;
        emxEnsureCapacity_real_T1(local_38,iVar8);
        uVar9 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar9) {
          puVar18 = (undefined8 *)*param_1;
          puVar14 = (undefined8 *)*local_38;
          if (uVar9 == 1) {
LAB_000199b2:
            uVar13 = 0;
          }
          else {
            puVar19 = puVar18 + uVar9;
            bVar20 = puVar14 < puVar19;
            if (bVar20) {
              puVar19 = puVar14 + uVar9;
            }
            if (bVar20 && puVar18 < puVar19) goto LAB_000199b2;
            uVar13 = uVar9 & 0xfffffffe;
            puVar19 = puVar18;
            puVar5 = puVar14;
            uVar10 = uVar13;
            do {
              uVar23 = *puVar19;
              uVar25 = puVar19[1];
              puVar19 = puVar19 + 2;
              uVar10 = uVar10 - 2;
              *puVar5 = uVar23;
              puVar5[1] = uVar25;
              puVar5 = puVar5 + 2;
            } while (uVar10 != 0);
            if (uVar9 - uVar13 == 0) goto LAB_000199d0;
          }
          puVar18 = puVar18 + uVar13;
          puVar14 = puVar14 + uVar13;
          iVar8 = uVar9 - uVar13;
          do {
            uVar23 = *puVar18;
            puVar18 = puVar18 + 1;
            iVar8 = iVar8 + -1;
            *puVar14 = uVar23;
            puVar14 = puVar14 + 1;
          } while (iVar8 != 0);
        }
      }
      else {
        uVar13 = *puVar4;
        uVar9 = *(uint *)local_38[1];
        *(uint *)local_38[1] = uVar13;
        emxEnsureCapacity_real_T1(local_38,uVar9);
        if (0 < (int)uVar13) {
          uVar9 = *param_1;
          iVar8 = *(int *)param_1[1];
          puVar18 = (undefined8 *)*local_38;
          if ((uVar13 == 1) ||
             ((puVar18 < (undefined8 *)(iVar8 * uVar15 * 8 + uVar9 + uVar13 * 8) &&
              ((undefined8 *)(iVar8 * uVar15 * 8 + uVar9) < puVar18 + uVar13)))) {
            uVar10 = 0;
          }
          else {
            puVar19 = (undefined8 *)(iVar8 * iVar2 + uVar9);
            uVar10 = uVar13 & 0xfffffffe;
            puVar14 = puVar18;
            uVar12 = uVar10;
            do {
              uVar23 = *puVar19;
              uVar25 = puVar19[1];
              puVar19 = puVar19 + 2;
              uVar12 = uVar12 - 2;
              *puVar14 = uVar23;
              puVar14[1] = uVar25;
              puVar14 = puVar14 + 2;
            } while (uVar12 != 0);
            if (uVar13 == uVar10) goto LAB_000199d0;
          }
          iVar21 = uVar13 - uVar10;
          puVar14 = (undefined8 *)(uVar9 + (iVar8 * uVar15 + uVar10) * 8);
          puVar18 = puVar18 + uVar10;
          do {
            uVar23 = *puVar14;
            puVar14 = puVar14 + 1;
            iVar21 = iVar21 + -1;
            *puVar18 = uVar23;
            puVar18 = puVar18 + 1;
          } while (iVar21 != 0);
        }
      }
LAB_000199d0:
      iVar6 = *(int *)local_38[1];
      dVar24 = (double)(longlong)iVar6;
      iVar21 = *(int *)local_3c[1];
      iVar8 = (int)(longlong)dVar22 + -1;
      if (dVar22 != dVar24 && dVar22 < dVar24 == (NAN(dVar22) || NAN(dVar24))) {
        iVar8 = 0;
        iVar6 = 0;
      }
      iVar6 = iVar6 - iVar8;
      *(int *)local_3c[1] = iVar6;
      emxEnsureCapacity_real_T1(local_3c,iVar21);
      if (0 < iVar6) {
        pdVar11 = (double *)*local_38;
        pdVar7 = (double *)*local_3c;
        do {
          pdVar16 = pdVar11 + iVar8;
          dVar24 = *pdVar11;
          pdVar11 = pdVar11 + 1;
          iVar6 = iVar6 + -1;
          *pdVar7 = *pdVar16 - dVar24;
          pdVar7 = pdVar7 + 1;
        } while (iVar6 != 0);
      }
      b_abs(local_3c,local_38);
      uVar23 = c_nanmean(local_38);
      iVar2 = iVar2 + 8;
      iVar8 = *param_5;
      puVar4 = (uint *)param_1[1];
      *(int *)(iVar8 + uVar15 * 8) = (int)uVar23;
      uVar9 = puVar4[1];
      *(int *)(iVar8 + uVar15 * 8 + 4) = (int)((ulonglong)uVar23 >> 0x20);
      bVar20 = (int)uVar15 < (int)uVar9;
      uVar15 = uVar15 + 1;
    } while (bVar20);
  }
  emxFree_real_T(&local_3c);
  emxFree_real_T(&local_38);
  if (*piVar26 == local_34) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Restarted to delay deadcode elimination for space: register

void MAGE(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  int iVar1;
  undefined1 uVar2;
  int iVar3;
  int iVar4;
  undefined4 uVar5;
  uint uVar6;
  uint uVar7;
  char cVar8;
  int iVar9;
  undefined8 *puVar10;
  ulonglong *puVar11;
  uint *puVar12;
  double *pdVar13;
  uint uVar14;
  uint uVar15;
  int iVar16;
  uint uVar17;
  uint uVar18;
  int iVar19;
  double *pdVar20;
  uint uVar21;
  int *piVar22;
  undefined8 *puVar23;
  undefined8 *puVar24;
  int iVar25;
  uint uVar26;
  int iVar27;
  undefined8 *puVar28;
  ulonglong *puVar29;
  byte bVar30;
  byte bVar31;
  bool bVar32;
  uint in_fpscr;
  ulonglong uVar33;
  int iVar34;
  double dVar35;
  undefined8 uVar36;
  double dVar37;
  double dVar38;
  double dVar39;
  undefined8 uVar40;
  double dVar41;
  undefined8 uVar42;
  int *local_b4;
  int *local_b0;
  int *local_ac;
  uint *local_a8;
  int *local_a4;
  int *local_a0;
  int *local_9c;
  int *local_98;
  int *local_94;
  int *local_90;
  int *local_8c;
  int *local_88;
  uint *local_84;
  uint *local_80;
  int *local_7c;
  int *local_78;
  uint *local_74;
  uint *local_70;
  int local_6c;
  
  local_6c = __stack_chk_guard;
  emxInit_real_T1(&local_70,2);
  iVar34 = **(int **)(param_1 + 4);
  b_SAFilter(param_1,local_70);
  iVar4 = *(int *)(param_1 + 4);
  piVar22 = (int *)param_5[1];
  iVar9 = *piVar22;
  iVar16 = piVar22[1];
  *piVar22 = 3;
  piVar22[1] = *(int *)(iVar4 + 4) + 1;
  emxEnsureCapacity_real_T(param_5,iVar16 * iVar9);
  uVar36 = rtNaN;
  iVar4 = *(int *)(*(int *)(param_1 + 4) + 4);
  uVar17 = iVar4 * 3 + 3;
  if (0 < (int)uVar17) {
    puVar23 = (undefined8 *)*param_5;
    if ((uVar17 == 1) ||
       ((puVar23 < (undefined8 *)((int)&rtNaN + 1U) && (&rtNaN < puVar23 + uVar17)))) {
      uVar21 = 0;
    }
    else {
      uVar21 = uVar17 & 0xfffffffe;
      puVar24 = puVar23;
      uVar26 = uVar21;
      do {
        *puVar24 = uVar36;
        puVar24[1] = uVar36;
        puVar24 = puVar24 + 2;
        uVar26 = uVar26 - 2;
      } while (uVar26 != 0);
      if (uVar17 == uVar21) goto LAB_00019b1c;
    }
    puVar23 = puVar23 + uVar21;
    iVar4 = uVar21 + iVar4 * -3 + -3;
    do {
      bVar32 = iVar4 != -1;
      iVar4 = iVar4 + 1;
      *puVar23 = rtNaN;
      puVar23 = puVar23 + 1;
    } while (bVar32);
  }
LAB_00019b1c:
  emxInit_real_T(&local_74,1);
  emxInit_boolean_T(&local_78,1);
  emxInit_real_T(&local_7c,1);
  emxInit_real_T(&local_80,1);
  emxInit_real_T(&local_84,1);
  emxInit_real_T(&local_88,1);
  emxInit_boolean_T(&local_8c,1);
  emxInit_uint32_T(&local_90,2);
  emxInit_boolean_T(&local_94,1);
  emxInit_int32_T1(&local_98,1);
  emxInit_int32_T1(&local_9c,1);
  emxInit_int32_T1(&local_a0,1);
  emxInit_int32_T1(&local_a4,1);
  emxInit_real_T(&local_a8,1);
  emxInit_boolean_T(&local_ac,1);
  emxInit_boolean_T(&local_b0,1);
  emxInit_boolean_T(&local_b4,1);
  uVar17 = *(uint *)(*(int *)(param_1 + 4) + 4);
  if (-1 < (int)uVar17) {
    dVar41 = 24.0;
    dVar35 = (double)(longlong)iVar34 / 24.0;
    iVar4 = 0;
    uVar21 = 0;
    do {
      if ((int)uVar17 >> 0x1f < (int)(uint)(uVar17 < uVar21 + 1)) {
        iVar9 = *(int *)local_74[1];
        *(int *)local_74[1] = ((int *)local_70[1])[1] * *(int *)local_70[1];
        emxEnsureCapacity_real_T1(local_74,iVar9);
        uVar17 = *(int *)local_70[1] * ((int *)local_70[1])[1];
        if (0 < (int)uVar17) {
          puVar23 = (undefined8 *)*local_70;
          puVar24 = (undefined8 *)*local_74;
          if (uVar17 == 1) {
LAB_00019d16:
            uVar26 = 0;
          }
          else {
            puVar28 = puVar23 + uVar17;
            bVar32 = puVar24 < puVar28;
            if (bVar32) {
              puVar28 = puVar24 + uVar17;
            }
            if (bVar32 && puVar23 < puVar28) goto LAB_00019d16;
            uVar26 = uVar17 & 0xfffffffe;
            puVar28 = puVar23;
            puVar10 = puVar24;
            uVar18 = uVar26;
            do {
              uVar36 = *puVar28;
              dVar41 = (double)puVar28[1];
              puVar28 = puVar28 + 2;
              uVar18 = uVar18 - 2;
              *puVar10 = uVar36;
              puVar10[1] = dVar41;
              puVar10 = puVar10 + 2;
            } while (uVar18 != 0);
            if (uVar17 - uVar26 == 0) goto LAB_00019d34;
          }
          puVar23 = puVar23 + uVar26;
          puVar24 = puVar24 + uVar26;
          iVar9 = uVar17 - uVar26;
          do {
            uVar36 = *puVar23;
            puVar23 = puVar23 + 1;
            iVar9 = iVar9 + -1;
            *puVar24 = uVar36;
            puVar24 = puVar24 + 1;
          } while (iVar9 != 0);
        }
      }
      else {
        uVar26 = *(uint *)local_70[1];
        uVar17 = *(uint *)local_74[1];
        *(uint *)local_74[1] = uVar26;
        emxEnsureCapacity_real_T1(local_74,uVar17);
        if (0 < (int)uVar26) {
          uVar17 = *local_70;
          puVar23 = (undefined8 *)*local_74;
          iVar9 = *(int *)local_70[1];
          if ((uVar26 == 1) ||
             ((puVar23 < (undefined8 *)(iVar9 * uVar21 * 8 + uVar17 + uVar26 * 8) &&
              ((undefined8 *)(iVar9 * uVar21 * 8 + uVar17) < puVar23 + uVar26)))) {
            uVar18 = 0;
          }
          else {
            puVar28 = (undefined8 *)(iVar9 * iVar4 + uVar17);
            uVar18 = uVar26 & 0xfffffffe;
            puVar24 = puVar23;
            uVar14 = uVar18;
            do {
              uVar36 = *puVar28;
              dVar41 = (double)puVar28[1];
              puVar28 = puVar28 + 2;
              uVar14 = uVar14 - 2;
              *puVar24 = uVar36;
              puVar24[1] = dVar41;
              puVar24 = puVar24 + 2;
            } while (uVar14 != 0);
            if (uVar26 == uVar18) goto LAB_00019d34;
          }
          iVar16 = uVar26 - uVar18;
          puVar24 = (undefined8 *)(uVar17 + (iVar9 * uVar21 + uVar18) * 8);
          puVar23 = puVar23 + uVar18;
          do {
            uVar36 = *puVar24;
            puVar24 = puVar24 + 1;
            iVar16 = iVar16 + -1;
            *puVar23 = uVar36;
            puVar23 = puVar23 + 1;
          } while (iVar16 != 0);
        }
      }
LAB_00019d34:
      piVar22 = (int *)local_90[1];
      iVar9 = *piVar22;
      iVar34 = piVar22[1];
      iVar16 = *(int *)local_74[1];
      *piVar22 = 1;
      if (iVar16 < 1) {
        piVar22[1] = 0;
        emxEnsureCapacity_uint32_T(local_90,iVar34 * iVar9);
      }
      else {
        piVar22[1] = iVar16;
        emxEnsureCapacity_uint32_T(local_90,iVar34 * iVar9);
        iVar34 = 0;
        iVar9 = *local_90;
        piVar22 = (int *)local_90[1];
        do {
          iVar19 = iVar34 * *piVar22;
          iVar34 = iVar34 + 1;
          *(int *)(iVar9 + iVar19 * 4) = iVar34;
        } while (iVar16 != iVar34);
      }
      dVar37 = (double)nanstd(local_74);
      diff(local_74,local_a8);
      iVar9 = *(int *)local_8c[1];
      *(int *)local_8c[1] = *(int *)local_a8[1] + 1;
      emxEnsureCapacity_boolean_T(local_8c,iVar9);
      iVar9 = *(int *)local_a8[1];
      if (0 < iVar9) {
        in_fpscr = in_fpscr & 0xfffffff | (uint)(*(double *)*local_a8 == 0.0) << 0x1e;
        *(bool *)*local_8c = (byte)(in_fpscr >> 0x1e) != 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_a8 + iVar34);
            iVar34 = iVar34 + 8;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(*pdVar20 == 0.0) << 0x1e;
            *(bool *)(*local_8c + iVar16) = (byte)(in_fpscr >> 0x1e) != 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
        iVar9 = *(int *)local_a8[1];
      }
      *(undefined1 *)(*local_8c + iVar9) = 0;
      uVar5 = *(undefined4 *)local_94[1];
      *(undefined4 *)local_94[1] = *(undefined4 *)local_74[1];
      emxEnsureCapacity_boolean_T(local_94,uVar5);
      iVar9 = *(int *)local_74[1];
      if (0 < iVar9) {
        uVar2 = rtIsNaN((int)*(undefined8 *)*local_74,
                        (int)((ulonglong)*(undefined8 *)*local_74 >> 0x20));
        *(undefined1 *)*local_94 = uVar2;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            uVar2 = rtIsNaN((int)*(undefined8 *)(*local_74 + iVar34),
                            (int)((ulonglong)*(undefined8 *)(*local_74 + iVar34) >> 0x20));
            iVar34 = iVar34 + 8;
            *(undefined1 *)(*local_94 + iVar16) = uVar2;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      uVar5 = *(undefined4 *)local_a8[1];
      *(undefined4 *)local_a8[1] = *(undefined4 *)(local_90[1] + 4);
      emxEnsureCapacity_real_T1(local_a8,uVar5);
      uVar17 = ((int *)local_90[1])[1];
      if (0 < (int)uVar17) {
        uVar26 = 0;
        iVar9 = *(int *)local_90[1];
        puVar29 = (ulonglong *)*local_90;
        pdVar20 = (double *)*local_a8;
        if ((uVar17 != 1) && (iVar9 == 1)) {
          uVar26 = uVar17 & 0xfffffffe;
          puVar11 = puVar29;
          pdVar13 = pdVar20;
          uVar18 = uVar26;
          do {
            uVar33 = *puVar11;
            puVar11 = puVar11 + 1;
            uVar18 = uVar18 - 2;
            dVar41 = (double)(uVar33 >> 0x20);
            *pdVar13 = (double)(uVar33 & 0xffffffff);
            pdVar13[1] = dVar41;
            pdVar13 = pdVar13 + 2;
          } while (uVar18 != 0);
          if (uVar17 == uVar26) goto LAB_00019eda;
        }
        pdVar20 = pdVar20 + uVar26;
        iVar16 = uVar17 - uVar26;
        puVar12 = (uint *)((int)puVar29 + uVar26 * iVar9 * 4);
        do {
          uVar17 = *puVar12;
          puVar12 = puVar12 + iVar9;
          iVar16 = iVar16 + -1;
          *pdVar20 = (double)uVar17;
          pdVar20 = pdVar20 + 1;
        } while (iVar16 != 0);
      }
LAB_00019eda:
      uVar5 = *(undefined4 *)local_ac[1];
      *(undefined4 *)local_ac[1] = *(undefined4 *)local_8c[1];
      emxEnsureCapacity_boolean_T(local_ac,uVar5);
      iVar9 = *(int *)local_8c[1];
      if (0 < iVar9) {
        iVar16 = 0;
        while( true ) {
          if (*(char *)(*local_8c + iVar16) == '\0') {
            cVar8 = *(char *)(*local_94 + iVar16);
            if (cVar8 != '\0') {
              cVar8 = '\x01';
            }
          }
          else {
            cVar8 = '\x01';
          }
          *(char *)(*local_ac + iVar16) = cVar8;
          if (iVar9 + -1 == iVar16) break;
          iVar16 = iVar16 + 1;
        }
      }
      dVar37 = dVar37 * (double)CONCAT44(param_4,param_3);
      FUN_0001afcc(local_a8,local_74,local_ac,local_84,local_88);
      diff(local_88,local_a8);
      b_abs(local_a8,local_80);
      uVar5 = *(undefined4 *)local_78[1];
      *(undefined4 *)local_78[1] = *(undefined4 *)local_80[1];
      emxEnsureCapacity_boolean_T(local_78,uVar5);
      iVar9 = *(int *)local_80[1];
      if (0 < iVar9) {
        dVar38 = *(double *)*local_80;
        in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar37) << 0x1f |
                   (uint)(dVar38 == dVar37) << 0x1e | (uint)(dVar37 <= dVar38) << 0x1d;
        *(bool *)*local_78 = (int)in_fpscr < 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_80 + iVar34);
            iVar34 = iVar34 + 8;
            dVar38 = *pdVar20;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar37) << 0x1f |
                       (uint)(dVar38 == dVar37) << 0x1e | (uint)(dVar37 <= dVar38) << 0x1d;
            *(bool *)(*local_78 + iVar16) = (int)in_fpscr < 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      iVar9 = *(int *)local_b0[1];
      *(int *)local_b0[1] = *(int *)local_78[1] + 1;
      emxEnsureCapacity_boolean_T(local_b0,iVar9);
      iVar9 = *(int *)local_78[1];
      if (0 < iVar9) {
        *(undefined1 *)*local_b0 = *(undefined1 *)*local_78;
        if (iVar9 != 1) {
          iVar16 = 1;
          do {
            *(undefined1 *)(*local_b0 + iVar16) = *(undefined1 *)(*local_78 + iVar16);
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
        iVar9 = *(int *)local_78[1];
      }
      *(undefined1 *)(*local_b0 + iVar9) = 0;
      iVar9 = *(int *)local_ac[1];
      *(int *)local_ac[1] = *(int *)local_78[1] + 1;
      emxEnsureCapacity_boolean_T(local_ac,iVar9);
      *(undefined1 *)*local_ac = 0;
      piVar22 = (int *)local_78[1];
      iVar9 = *piVar22;
      if (0 < iVar9) {
        *(undefined1 *)(*local_ac + 1) = *(undefined1 *)*local_78;
        if (iVar9 != 1) {
          iVar16 = 0;
          do {
            iVar34 = *local_78 + iVar16;
            iVar19 = *local_ac + iVar16;
            iVar16 = iVar16 + 1;
            *(undefined1 *)(iVar19 + 2) = *(undefined1 *)(iVar34 + 1);
          } while (iVar9 + -1 != iVar16);
        }
        piVar22 = (int *)local_78[1];
        iVar9 = *piVar22;
      }
      *piVar22 = *(int *)local_b0[1];
      emxEnsureCapacity_boolean_T(local_78,iVar9);
      iVar9 = *(int *)local_b0[1];
      if (0 < iVar9) {
        iVar16 = 0;
        while( true ) {
          if (*(char *)(*local_b0 + iVar16) == '\0') {
            cVar8 = '\0';
          }
          else {
            cVar8 = *(char *)(*local_ac + iVar16);
            if (cVar8 != '\0') {
              cVar8 = '\x01';
            }
          }
          *(char *)(*local_78 + iVar16) = cVar8;
          if (iVar9 + -1 == iVar16) break;
          iVar16 = iVar16 + 1;
        }
      }
      b_diff(local_78,local_a8);
      uVar5 = *(undefined4 *)local_94[1];
      *(undefined4 *)local_94[1] = *(undefined4 *)local_a8[1];
      emxEnsureCapacity_boolean_T(local_94,uVar5);
      iVar9 = *(int *)local_a8[1];
      if (0 < iVar9) {
        in_fpscr = in_fpscr & 0xfffffff | (uint)(*(double *)*local_a8 == 1.0) << 0x1e;
        *(bool *)*local_94 = (byte)(in_fpscr >> 0x1e) != 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_a8 + iVar34);
            iVar34 = iVar34 + 8;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(*pdVar20 == 1.0) << 0x1e;
            *(bool *)(*local_94 + iVar16) = (byte)(in_fpscr >> 0x1e) != 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      iVar16 = *(int *)local_94[1];
      iVar9 = *(int *)local_98[1];
      *(int *)local_98[1] = iVar16;
      emxEnsureCapacity_int32_T1(local_98,iVar9);
      if (iVar16 < 1) {
        if (*(int *)local_94[1] != 1) {
          uVar17 = 0;
          goto LAB_0001a170;
        }
LAB_0001a15c:
        uVar26 = *(uint *)local_98[1];
        *(uint *)local_98[1] = 0;
LAB_0001a178:
        emxEnsureCapacity_int32_T1(local_98,uVar26);
      }
      else {
        iVar9 = 1;
        iVar34 = *local_94;
        uVar17 = 0;
        do {
          if (*(char *)(iVar9 + iVar34 + -1) == '\0') {
            iVar9 = iVar9 + 1;
            bVar32 = false;
          }
          else {
            *(int *)(*local_98 + uVar17 * 4) = iVar9;
            uVar17 = uVar17 + 1;
            if ((int)uVar17 < iVar16) {
              iVar9 = iVar9 + 1;
            }
            bVar32 = iVar16 <= (int)uVar17;
          }
        } while ((iVar9 <= iVar16) && (!bVar32));
        if (*(int *)local_94[1] != 1) {
          uVar17 = uVar17 & ~((int)uVar17 >> 0x1f);
LAB_0001a170:
          uVar26 = *(uint *)local_98[1];
          *(uint *)local_98[1] = uVar17;
          goto LAB_0001a178;
        }
        if (uVar17 == 0) goto LAB_0001a15c;
      }
      uVar5 = *(undefined4 *)local_7c[1];
      *(undefined4 *)local_7c[1] = *(undefined4 *)local_98[1];
      emxEnsureCapacity_real_T1(local_7c,uVar5);
      iVar9 = *(int *)local_98[1];
      if (0 < iVar9) {
        pdVar20 = (double *)*local_7c;
        piVar22 = (int *)*local_98;
        do {
          iVar9 = iVar9 + -1;
          *pdVar20 = (double)(longlong)*piVar22 + 1.0;
          pdVar20 = pdVar20 + 1;
          piVar22 = piVar22 + 1;
        } while (iVar9 != 0);
      }
      b_diff(local_78,local_a8);
      uVar5 = *(undefined4 *)local_94[1];
      *(undefined4 *)local_94[1] = *(undefined4 *)local_a8[1];
      emxEnsureCapacity_boolean_T(local_94,uVar5);
      iVar9 = *(int *)local_a8[1];
      if (0 < iVar9) {
        in_fpscr = in_fpscr & 0xfffffff | (uint)(*(double *)*local_a8 == -1.0) << 0x1e;
        *(bool *)*local_94 = (byte)(in_fpscr >> 0x1e) != 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_a8 + iVar34);
            iVar34 = iVar34 + 8;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(*pdVar20 == -1.0) << 0x1e;
            *(bool *)(*local_94 + iVar16) = (byte)(in_fpscr >> 0x1e) != 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      iVar16 = *(int *)local_94[1];
      iVar9 = *(int *)local_98[1];
      *(int *)local_98[1] = iVar16;
      emxEnsureCapacity_int32_T1(local_98,iVar9);
      if (iVar16 < 1) {
        if (*(int *)local_94[1] != 1) {
          uVar17 = 0;
          goto LAB_0001a298;
        }
LAB_0001a284:
        uVar26 = *(uint *)local_98[1];
        *(uint *)local_98[1] = 0;
LAB_0001a2a0:
        emxEnsureCapacity_int32_T1(local_98,uVar26);
      }
      else {
        iVar9 = 1;
        iVar34 = *local_94;
        uVar17 = 0;
        do {
          if (*(char *)(iVar9 + iVar34 + -1) == '\0') {
            iVar9 = iVar9 + 1;
            bVar32 = false;
          }
          else {
            *(int *)(*local_98 + uVar17 * 4) = iVar9;
            uVar17 = uVar17 + 1;
            if ((int)uVar17 < iVar16) {
              iVar9 = iVar9 + 1;
            }
            bVar32 = iVar16 <= (int)uVar17;
          }
        } while ((iVar9 <= iVar16) && (!bVar32));
        if (*(int *)local_94[1] != 1) {
          uVar17 = uVar17 & ~((int)uVar17 >> 0x1f);
LAB_0001a298:
          uVar26 = *(uint *)local_98[1];
          *(uint *)local_98[1] = uVar17;
          goto LAB_0001a2a0;
        }
        if (uVar17 == 0) goto LAB_0001a284;
      }
      uVar5 = *(undefined4 *)local_80[1];
      *(undefined4 *)local_80[1] = *(undefined4 *)local_98[1];
      emxEnsureCapacity_real_T1(local_80,uVar5);
      uVar17 = *(uint *)local_98[1];
      if (0 < (int)uVar17) {
        puVar23 = (undefined8 *)*local_98;
        pdVar20 = (double *)*local_80;
        if (uVar17 == 1) {
          uVar18 = 0;
        }
        else {
          uVar18 = uVar17 & 0xfffffffe;
          puVar24 = puVar23;
          pdVar13 = pdVar20;
          uVar26 = uVar18;
          do {
            uVar36 = *puVar24;
            puVar24 = puVar24 + 1;
            uVar26 = uVar26 - 2;
            dVar41 = (double)(longlong)(int)((ulonglong)uVar36 >> 0x20);
            *pdVar13 = (double)(longlong)(int)uVar36;
            pdVar13[1] = dVar41;
            pdVar13 = pdVar13 + 2;
          } while (uVar26 != 0);
          if (uVar17 == uVar18) goto LAB_0001a30e;
        }
        pdVar20 = pdVar20 + uVar18;
        iVar9 = uVar17 - uVar18;
        piVar22 = (int *)((int)puVar23 + uVar18 * 4);
        do {
          iVar9 = iVar9 + -1;
          *pdVar20 = (double)(longlong)*piVar22;
          pdVar20 = pdVar20 + 1;
          piVar22 = piVar22 + 1;
        } while (iVar9 != 0);
      }
LAB_0001a30e:
      if (0 < *(int *)local_7c[1]) {
        iVar9 = 0;
        do {
          dVar41 = *(double *)(*local_7c + iVar9 * 8);
          dVar38 = *(double *)(*local_80 + iVar9 * 8);
          iVar19 = (int)(longlong)dVar38;
          iVar34 = *local_88;
          uVar17 = in_fpscr & 0xfffffff | (uint)(dVar41 < dVar38) << 0x1f |
                   (uint)(dVar41 == dVar38) << 0x1e;
          uVar26 = uVar17 | (uint)(NAN(dVar41) || NAN(dVar38)) << 0x1c;
          bVar31 = (byte)(uVar17 >> 0x18);
          iVar16 = (int)(longlong)dVar41 + -1;
          if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(uVar26 >> 0x1c) & 1)) {
            iVar16 = 0;
            iVar19 = 0;
          }
          iVar19 = iVar19 - iVar16;
          if (iVar19 < 2) {
            iVar27 = 1;
          }
          else {
            dVar41 = *(double *)(iVar34 + iVar16 * 8);
            iVar34 = rtIsNaN(SUB84(dVar41,0),(int)((ulonglong)dVar41 >> 0x20));
            if (iVar34 == 0) {
              iVar25 = 1;
              iVar27 = 1;
            }
            else {
              iVar34 = iVar16 * 8;
              iVar1 = 2;
              while( true ) {
                iVar25 = iVar1;
                iVar34 = iVar34 + 8;
                iVar3 = rtIsNaN((int)*(undefined8 *)(*local_88 + iVar34),
                                (int)((ulonglong)*(undefined8 *)(*local_88 + iVar34) >> 0x20));
                if (iVar3 == 0) break;
                iVar27 = 1;
                if ((iVar19 <= iVar25) || (iVar1 = iVar25 + 1, iVar3 == 0)) goto LAB_0001a426;
              }
              dVar41 = *(double *)(*local_88 + iVar34);
              iVar27 = iVar25;
            }
LAB_0001a426:
            iVar34 = *local_88;
            if (iVar25 < iVar19) {
              pdVar20 = (double *)(iVar34 + (iVar16 + iVar25) * 8);
              do {
                dVar38 = *pdVar20;
                iVar25 = iVar25 + 1;
                pdVar20 = pdVar20 + 1;
                uVar17 = uVar26 & 0xfffffff | (uint)(dVar38 < dVar41) << 0x1f |
                         (uint)(dVar38 == dVar41) << 0x1e;
                uVar26 = uVar17 | (uint)(NAN(dVar38) || NAN(dVar41)) << 0x1c;
                bVar31 = (byte)(uVar17 >> 0x18);
                if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(uVar26 >> 0x1c) & 1)) {
                  iVar27 = iVar25;
                  dVar41 = dVar38;
                }
              } while (iVar25 < iVar19);
            }
          }
          dVar41 = *(double *)(*local_80 + iVar9 * 8);
          dVar38 = *(double *)(*local_7c + iVar9 * 8);
          iVar16 = (int)(longlong)dVar41;
          uVar17 = uVar26 & 0xfffffff | (uint)(dVar38 < dVar41) << 0x1f |
                   (uint)(dVar38 == dVar41) << 0x1e;
          in_fpscr = uVar17 | (uint)(NAN(dVar38) || NAN(dVar41)) << 0x1c;
          bVar31 = (byte)(uVar17 >> 0x18);
          bVar30 = bVar31 >> 7;
          bVar32 = (bool)(bVar31 >> 6 & 1);
          bVar31 = (byte)(in_fpscr >> 0x1c) & 1;
          if (!bVar32 && bVar30 == bVar31) {
            iVar16 = 0;
          }
          iVar19 = (int)(longlong)dVar38 + -1;
          if (!bVar32 && bVar30 == bVar31) {
            iVar19 = 0;
          }
          iVar16 = iVar16 - iVar19;
          if (iVar16 < 2) {
            iVar34 = 1;
          }
          else {
            dVar41 = *(double *)(iVar34 + iVar19 * 8);
            iVar34 = rtIsNaN(SUB84(dVar41,0),(int)((ulonglong)dVar41 >> 0x20));
            if (iVar34 == 0) {
              iVar25 = 1;
            }
            else {
              iVar34 = iVar19 * 8;
              iVar1 = 2;
              do {
                iVar25 = iVar1;
                iVar34 = iVar34 + 8;
                iVar3 = rtIsNaN((int)*(undefined8 *)(*local_88 + iVar34),
                                (int)((ulonglong)*(undefined8 *)(*local_88 + iVar34) >> 0x20));
                if (iVar3 == 0) {
                  dVar41 = *(double *)(*local_88 + iVar34);
                  iVar34 = iVar25;
                  goto joined_r0x0001a4f6;
                }
              } while ((iVar25 < iVar16) && (iVar1 = iVar25 + 1, iVar3 != 0));
            }
            iVar34 = 1;
joined_r0x0001a4f6:
            if (iVar25 < iVar16) {
              pdVar20 = (double *)(*local_88 + (iVar19 + iVar25) * 8);
              do {
                dVar38 = *pdVar20;
                iVar25 = iVar25 + 1;
                pdVar20 = pdVar20 + 1;
                in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar41) << 0x1f |
                           (uint)(dVar38 == dVar41) << 0x1e | (uint)(dVar41 <= dVar38) << 0x1d;
                if ((int)in_fpscr < 0) {
                  iVar34 = iVar25;
                  dVar41 = dVar38;
                }
              } while (iVar25 < iVar16);
            }
          }
          iVar16 = iVar9 * 8;
          iVar9 = iVar9 + 1;
          dVar38 = *(double *)(*local_7c + iVar16);
          dVar41 = dVar38 + (double)(longlong)iVar34 + -1.0;
          *(undefined1 *)
           (*local_78 + (int)(longlong)(dVar38 + (double)(longlong)iVar27 + -1.0) + -1) = 0;
          *(undefined1 *)(*local_78 + (int)(longlong)dVar41 + -1) = 0;
        } while (iVar9 < *(int *)local_7c[1]);
      }
      FUN_0001afcc(local_84,local_88,local_78,local_7c,local_74);
      diff(local_74,local_a8);
      b_abs(local_a8,local_80);
      uVar5 = *(undefined4 *)local_78[1];
      *(undefined4 *)local_78[1] = *(undefined4 *)local_80[1];
      emxEnsureCapacity_boolean_T(local_78,uVar5);
      dVar38 = dVar37 * 0.5;
      iVar9 = *(int *)local_80[1];
      if (0 < iVar9) {
        dVar39 = *(double *)*local_80;
        in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar39 < dVar38) << 0x1f |
                   (uint)(dVar39 == dVar38) << 0x1e | (uint)(dVar38 <= dVar39) << 0x1d;
        *(bool *)*local_78 = (int)in_fpscr < 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_80 + iVar34);
            iVar34 = iVar34 + 8;
            dVar39 = *pdVar20;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar39 < dVar38) << 0x1f |
                       (uint)(dVar39 == dVar38) << 0x1e | (uint)(dVar38 <= dVar39) << 0x1d;
            *(bool *)(*local_78 + iVar16) = (int)in_fpscr < 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      diff(local_7c,local_a8);
      b_abs(local_a8,local_80);
      uVar5 = *(undefined4 *)local_8c[1];
      *(undefined4 *)local_8c[1] = *(undefined4 *)local_80[1];
      emxEnsureCapacity_boolean_T(local_8c,uVar5);
      iVar9 = *(int *)local_80[1];
      if (0 < iVar9) {
        dVar39 = *(double *)*local_80;
        in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar39 < dVar35) << 0x1f |
                   (uint)(dVar39 == dVar35) << 0x1e | (uint)(dVar35 <= dVar39) << 0x1d;
        *(bool *)*local_8c = (int)in_fpscr < 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_80 + iVar34);
            iVar34 = iVar34 + 8;
            dVar39 = *pdVar20;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar39 < dVar35) << 0x1f |
                       (uint)(dVar39 == dVar35) << 0x1e | (uint)(dVar35 <= dVar39) << 0x1d;
            *(bool *)(*local_8c + iVar16) = (int)in_fpscr < 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      emxEnsureCapacity_boolean_T(local_78,*(undefined4 *)local_78[1]);
      iVar9 = *(int *)local_78[1];
      if (0 < iVar9) {
        iVar16 = 0;
        do {
          if (*(char *)(*local_78 + iVar16) == '\0') {
            cVar8 = '\0';
          }
          else {
            cVar8 = *(char *)(*local_8c + iVar16);
            if (cVar8 != '\0') {
              cVar8 = '\x01';
            }
          }
          *(char *)(*local_78 + iVar16) = cVar8;
          iVar16 = iVar16 + 1;
        } while (iVar9 != iVar16);
        iVar9 = *(int *)local_78[1];
      }
      iVar16 = *(int *)local_b4[1];
      *(int *)local_b4[1] = iVar9 + 1;
      emxEnsureCapacity_boolean_T(local_b4,iVar16);
      iVar9 = *(int *)local_78[1];
      if (0 < iVar9) {
        *(undefined1 *)*local_b4 = *(undefined1 *)*local_78;
        if (iVar9 != 1) {
          iVar16 = 1;
          do {
            *(undefined1 *)(*local_b4 + iVar16) = *(undefined1 *)(*local_78 + iVar16);
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
        iVar9 = *(int *)local_78[1];
      }
      *(undefined1 *)(*local_b4 + iVar9) = 0;
      iVar9 = *(int *)local_ac[1];
      *(int *)local_ac[1] = *(int *)local_78[1] + 1;
      emxEnsureCapacity_boolean_T(local_ac,iVar9);
      *(undefined1 *)*local_ac = 0;
      iVar9 = *(int *)local_78[1];
      if ((0 < iVar9) && (*(undefined1 *)(*local_ac + 1) = *(undefined1 *)*local_78, iVar9 != 1)) {
        iVar16 = 0;
        do {
          iVar34 = *local_78 + iVar16;
          iVar19 = *local_ac + iVar16;
          iVar16 = iVar16 + 1;
          *(undefined1 *)(iVar19 + 2) = *(undefined1 *)(iVar34 + 1);
        } while (iVar9 + -1 != iVar16);
      }
      uVar5 = *(undefined4 *)local_b0[1];
      *(undefined4 *)local_b0[1] = *(undefined4 *)local_b4[1];
      emxEnsureCapacity_boolean_T(local_b0,uVar5);
      iVar9 = *(int *)local_b4[1];
      if (0 < iVar9) {
        iVar16 = 0;
        while( true ) {
          if (*(char *)(*local_b4 + iVar16) == '\0') {
            cVar8 = '\0';
          }
          else {
            cVar8 = *(char *)(*local_ac + iVar16);
            if (cVar8 != '\0') {
              cVar8 = '\x01';
            }
          }
          *(char *)(*local_b0 + iVar16) = cVar8;
          if (iVar9 + -1 == iVar16) break;
          iVar16 = iVar16 + 1;
        }
      }
      FUN_0001afcc(local_7c,local_74,local_b0,local_84,local_88);
      diff(local_88,local_a8);
      b_abs(local_a8,local_80);
      uVar5 = *(undefined4 *)local_78[1];
      *(undefined4 *)local_78[1] = *(undefined4 *)local_80[1];
      emxEnsureCapacity_boolean_T(local_78,uVar5);
      iVar9 = *(int *)local_80[1];
      if (0 < iVar9) {
        dVar39 = *(double *)*local_80;
        in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar39 < dVar38) << 0x1f |
                   (uint)(dVar39 == dVar38) << 0x1e | (uint)(dVar38 <= dVar39) << 0x1d;
        *(bool *)*local_78 = (int)in_fpscr < 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_80 + iVar34);
            iVar34 = iVar34 + 8;
            dVar39 = *pdVar20;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar39 < dVar38) << 0x1f |
                       (uint)(dVar39 == dVar38) << 0x1e | (uint)(dVar38 <= dVar39) << 0x1d;
            *(bool *)(*local_78 + iVar16) = (int)in_fpscr < 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      diff(local_84,local_a8);
      b_abs(local_a8,local_80);
      uVar5 = *(undefined4 *)local_8c[1];
      *(undefined4 *)local_8c[1] = *(undefined4 *)local_80[1];
      emxEnsureCapacity_boolean_T(local_8c,uVar5);
      iVar9 = *(int *)local_80[1];
      if (0 < iVar9) {
        dVar38 = *(double *)*local_80;
        in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar35) << 0x1f |
                   (uint)(dVar38 == dVar35) << 0x1e | (uint)(dVar35 <= dVar38) << 0x1d;
        *(bool *)*local_8c = (int)in_fpscr < 0;
        if (iVar9 != 1) {
          iVar16 = 1;
          iVar34 = 8;
          do {
            pdVar20 = (double *)(*local_80 + iVar34);
            iVar34 = iVar34 + 8;
            dVar38 = *pdVar20;
            in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar35) << 0x1f |
                       (uint)(dVar38 == dVar35) << 0x1e | (uint)(dVar35 <= dVar38) << 0x1d;
            *(bool *)(*local_8c + iVar16) = (int)in_fpscr < 0;
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
      }
      emxEnsureCapacity_boolean_T(local_78,*(undefined4 *)local_78[1]);
      iVar9 = *(int *)local_78[1];
      if (0 < iVar9) {
        iVar16 = 0;
        do {
          if (*(char *)(*local_78 + iVar16) == '\0') {
            cVar8 = '\0';
          }
          else {
            cVar8 = *(char *)(*local_8c + iVar16);
            if (cVar8 != '\0') {
              cVar8 = '\x01';
            }
          }
          *(char *)(*local_78 + iVar16) = cVar8;
          iVar16 = iVar16 + 1;
        } while (iVar9 != iVar16);
        iVar9 = *(int *)local_78[1];
      }
      iVar16 = *(int *)local_b4[1];
      *(int *)local_b4[1] = iVar9 + 1;
      emxEnsureCapacity_boolean_T(local_b4,iVar16);
      iVar9 = *(int *)local_78[1];
      if (0 < iVar9) {
        *(undefined1 *)*local_b4 = *(undefined1 *)*local_78;
        if (iVar9 != 1) {
          iVar16 = 1;
          do {
            *(undefined1 *)(*local_b4 + iVar16) = *(undefined1 *)(*local_78 + iVar16);
            iVar16 = iVar16 + 1;
          } while (iVar9 != iVar16);
        }
        iVar9 = *(int *)local_78[1];
      }
      *(undefined1 *)(*local_b4 + iVar9) = 0;
      iVar9 = *(int *)local_ac[1];
      *(int *)local_ac[1] = *(int *)local_78[1] + 1;
      emxEnsureCapacity_boolean_T(local_ac,iVar9);
      *(undefined1 *)*local_ac = 0;
      iVar9 = *(int *)local_78[1];
      if ((0 < iVar9) && (*(undefined1 *)(*local_ac + 1) = *(undefined1 *)*local_78, iVar9 != 1)) {
        iVar16 = 0;
        do {
          iVar34 = *local_78 + iVar16;
          iVar19 = *local_ac + iVar16;
          iVar16 = iVar16 + 1;
          *(undefined1 *)(iVar19 + 2) = *(undefined1 *)(iVar34 + 1);
        } while (iVar9 + -1 != iVar16);
      }
      uVar5 = *(undefined4 *)local_b0[1];
      *(undefined4 *)local_b0[1] = *(undefined4 *)local_b4[1];
      emxEnsureCapacity_boolean_T(local_b0,uVar5);
      iVar9 = *(int *)local_b4[1];
      if (0 < iVar9) {
        iVar16 = 0;
        while( true ) {
          if (*(char *)(*local_b4 + iVar16) == '\0') {
            cVar8 = *(char *)(*local_ac + iVar16);
            if (cVar8 != '\0') {
              cVar8 = '\x01';
            }
          }
          else {
            cVar8 = '\x01';
          }
          *(char *)(*local_b0 + iVar16) = cVar8;
          if (iVar9 + -1 == iVar16) break;
          iVar16 = iVar16 + 1;
        }
      }
      FUN_0001afcc(local_84,local_88,local_b0,local_7c,local_74);
      diff(local_74,local_7c);
      b_abs(local_7c,local_80);
      iVar16 = 2;
      iVar9 = 2;
      uVar17 = *(uint *)local_80[1];
      if ((int)uVar17 < 2) {
        iVar16 = 1;
      }
      uVar26 = uVar17 - 1;
      if ((int)uVar17 < 1) {
        iVar9 = 1;
        uVar26 = 0xffffffff;
      }
      uVar18 = uVar17;
      if ((int)uVar17 < 2) {
        uVar18 = 0;
      }
      if ((int)uVar17 < 1) {
        uVar5 = *(undefined4 *)local_9c[1];
        *(undefined4 *)local_9c[1] = 0;
        emxEnsureCapacity_int32_T1(local_9c,uVar5);
      }
      else {
        if (uVar17 == 1) {
          uVar6 = 0;
          iVar34 = 0;
LAB_0001aa28:
          pdVar20 = (double *)*local_80 + uVar6;
          iVar19 = uVar17 - uVar6;
          do {
            dVar38 = *pdVar20;
            pdVar20 = pdVar20 + 1;
            uVar14 = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar37) << 0x1f |
                     (uint)(dVar38 == dVar37) << 0x1e;
            in_fpscr = uVar14 | (uint)(NAN(dVar38) || NAN(dVar37)) << 0x1c;
            bVar31 = (byte)(uVar14 >> 0x18);
            if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              iVar34 = iVar34 + 1;
            }
            iVar19 = iVar19 + -1;
          } while (iVar19 != 0);
        }
        else {
          uVar6 = uVar17 & 0xfffffffe;
          uVar36 = 0;
          uVar14 = uVar6;
          pdVar20 = (double *)*local_80;
          do {
            dVar38 = *pdVar20;
            pdVar20 = pdVar20 + 2;
            in_fpscr = in_fpscr & 0xfffffff;
            uVar7 = (uint)(dVar38 != dVar37 && dVar38 < dVar37 == (NAN(dVar38) || NAN(dVar37)));
            if (uVar7 != 0) {
              uVar7 = 0xffffffff;
            }
            dVar41 = (double)((ulonglong)dVar41 & 0xffff0000ffff0000 | (ulonglong)uVar7 & 0xffff);
            uVar14 = uVar14 - 2;
            uVar36 = VectorSub(uVar36,dVar41,4);
          } while (uVar14 != 0);
          uVar5 = (undefined4)((ulonglong)uVar36 >> 0x20);
          dVar41 = (double)CONCAT44(uVar5,uVar5);
          uVar36 = VectorAdd(uVar36,dVar41,4);
          iVar34 = (int)uVar36;
          if (uVar17 != uVar6) goto LAB_0001aa28;
        }
        iVar19 = *(int *)local_9c[1];
        *(int *)local_9c[1] = iVar34;
        emxEnsureCapacity_int32_T1(local_9c,iVar19);
        if (0 < (int)uVar17) {
          uVar14 = 0;
          iVar34 = 0;
          pdVar20 = (double *)*local_80;
          do {
            dVar38 = *pdVar20;
            uVar14 = uVar14 + 1;
            pdVar20 = pdVar20 + 1;
            uVar6 = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar37) << 0x1f |
                    (uint)(dVar38 == dVar37) << 0x1e;
            in_fpscr = uVar6 | (uint)(NAN(dVar38) || NAN(dVar37)) << 0x1c;
            bVar31 = (byte)(uVar6 >> 0x18);
            if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              *(uint *)(*local_9c + iVar34 * 4) = uVar14;
              iVar34 = iVar34 + 1;
            }
          } while (uVar17 != uVar14);
        }
      }
      uVar5 = *(undefined4 *)local_a8[1];
      *(undefined4 *)local_a8[1] = *(undefined4 *)local_9c[1];
      emxEnsureCapacity_real_T1(local_a8,uVar5);
      iVar34 = *(int *)local_9c[1];
      if (0 < iVar34) {
        uVar14 = *local_80;
        puVar23 = (undefined8 *)*local_a8;
        piVar22 = (int *)*local_9c;
        do {
          iVar34 = iVar34 + -1;
          *puVar23 = *(undefined8 *)(uVar14 + *piVar22 * 8 + -8);
          puVar23 = puVar23 + 1;
          piVar22 = piVar22 + 1;
        } while (iVar34 != 0);
      }
      uVar36 = c_nanmean(local_a8);
      uVar14 = uVar26;
      if ((int)uVar26 < 0) {
        uVar14 = -uVar26;
      }
      uVar6 = uVar14 >> (uint)(0 < (int)uVar17);
      if (0x7fffffff < uVar26) {
        uVar14 = uVar14 & iVar9 - 1U;
        if (uVar14 != 0) {
          uVar14 = 0xffffffff;
        }
        uVar6 = uVar14 - uVar6;
      }
      if ((int)uVar6 < 0) {
        uVar5 = *(undefined4 *)local_a0[1];
        *(undefined4 *)local_a0[1] = 0;
        emxEnsureCapacity_int32_T1(local_a0,uVar5);
      }
      else {
        uVar14 = uVar6 + 1;
        uVar26 = 0;
        if (uVar14 < 2) {
          iVar34 = 0;
LAB_0001ab90:
          iVar19 = (uVar6 - uVar26) + 1;
          pdVar20 = (double *)*local_80 + iVar9 * uVar26;
          do {
            dVar38 = *pdVar20;
            pdVar20 = pdVar20 + iVar9;
            uVar26 = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar37) << 0x1f |
                     (uint)(dVar38 == dVar37) << 0x1e;
            in_fpscr = uVar26 | (uint)(NAN(dVar38) || NAN(dVar37)) << 0x1c;
            bVar31 = (byte)(uVar26 >> 0x18);
            if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              iVar34 = iVar34 + 1;
            }
            iVar19 = iVar19 + -1;
          } while (iVar19 != 0);
        }
        else {
          iVar34 = 0;
          if (0 < (int)uVar17) goto LAB_0001ab90;
          uVar26 = uVar14 & 0xfffffffe;
          uVar40 = 0;
          pdVar20 = (double *)*local_80;
          uVar7 = uVar26;
          do {
            dVar38 = *pdVar20;
            pdVar20 = pdVar20 + iVar9 * 2;
            in_fpscr = in_fpscr & 0xfffffff;
            uVar15 = (uint)(dVar38 != dVar37 && dVar38 < dVar37 == (NAN(dVar38) || NAN(dVar37)));
            if (uVar15 != 0) {
              uVar15 = 0xffffffff;
            }
            dVar41 = (double)((ulonglong)dVar41 & 0xffff0000ffff0000 | (ulonglong)uVar15 & 0xffff);
            uVar7 = uVar7 - 2;
            uVar40 = VectorSub(uVar40,dVar41,4);
          } while (uVar7 != 0);
          uVar5 = (undefined4)((ulonglong)uVar40 >> 0x20);
          dVar41 = (double)CONCAT44(uVar5,uVar5);
          uVar40 = VectorAdd(uVar40,dVar41,4);
          iVar34 = (int)uVar40;
          if (uVar14 != uVar26) goto LAB_0001ab90;
        }
        iVar19 = *(int *)local_a0[1];
        *(int *)local_a0[1] = iVar34;
        emxEnsureCapacity_int32_T1(local_a0,iVar19);
        if (-1 < (int)uVar6) {
          iVar34 = 0;
          uVar26 = 0xffffffff;
          pdVar20 = (double *)*local_80;
          do {
            dVar38 = *pdVar20;
            uVar14 = in_fpscr & 0xfffffff | (uint)(dVar38 < dVar37) << 0x1f |
                     (uint)(dVar38 == dVar37) << 0x1e;
            in_fpscr = uVar14 | (uint)(NAN(dVar38) || NAN(dVar37)) << 0x1c;
            bVar31 = (byte)(uVar14 >> 0x18);
            if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              *(uint *)(*local_a0 + iVar34 * 4) = uVar26 + 2;
              iVar34 = iVar34 + 1;
            }
            uVar26 = uVar26 + 1;
            pdVar20 = pdVar20 + iVar9;
          } while (uVar6 != uVar26);
        }
      }
      uVar5 = *(undefined4 *)local_84[1];
      *(undefined4 *)local_84[1] = *(undefined4 *)local_a0[1];
      emxEnsureCapacity_real_T1(local_84,uVar5);
      iVar34 = *(int *)local_a0[1];
      if (0 < iVar34) {
        uVar26 = *local_80;
        puVar23 = (undefined8 *)*local_84;
        piVar22 = (int *)*local_a0;
        do {
          iVar34 = iVar34 + -1;
          *puVar23 = *(undefined8 *)(uVar26 + (*piVar22 + -1) * iVar9 * 8);
          puVar23 = puVar23 + 1;
          piVar22 = piVar22 + 1;
        } while (iVar34 != 0);
      }
      uVar5 = *(undefined4 *)local_a8[1];
      *(undefined4 *)local_a8[1] = *(undefined4 *)local_84[1];
      emxEnsureCapacity_real_T1(local_a8,uVar5);
      uVar26 = *(uint *)local_84[1];
      if (0 < (int)uVar26) {
        puVar23 = (undefined8 *)*local_84;
        puVar24 = (undefined8 *)*local_a8;
        if (uVar26 == 1) {
          uVar14 = 0;
        }
        else {
          puVar28 = puVar23 + uVar26;
          bVar32 = puVar24 < puVar28;
          if (bVar32) {
            puVar28 = puVar24 + uVar26;
          }
          if (bVar32 && puVar23 < puVar28) {
            uVar14 = 0;
          }
          else {
            uVar14 = uVar26 & 0xfffffffe;
            puVar28 = puVar23;
            puVar10 = puVar24;
            uVar6 = uVar14;
            do {
              uVar40 = *puVar28;
              dVar41 = (double)puVar28[1];
              puVar28 = puVar28 + 2;
              uVar6 = uVar6 - 2;
              *puVar10 = uVar40;
              puVar10[1] = dVar41;
              puVar10 = puVar10 + 2;
            } while (uVar6 != 0);
            if (uVar26 == uVar14) goto LAB_0001acc8;
          }
        }
        puVar23 = puVar23 + uVar14;
        puVar24 = puVar24 + uVar14;
        iVar9 = uVar26 - uVar14;
        do {
          uVar40 = *puVar23;
          puVar23 = puVar23 + 1;
          iVar9 = iVar9 + -1;
          *puVar24 = uVar40;
          puVar24 = puVar24 + 1;
        } while (iVar9 != 0);
      }
LAB_0001acc8:
      uVar18 = uVar18 - iVar16;
      dVar38 = (double)c_nanmean(local_a8);
      uVar26 = uVar18;
      if ((int)uVar18 < 0) {
        uVar26 = -uVar18;
      }
      uVar14 = uVar26 >> (uint)(1 < (int)uVar17);
      if (0x7fffffff < uVar18) {
        uVar26 = uVar26 & iVar16 - 1U;
        if (uVar26 != 0) {
          uVar26 = 0xffffffff;
        }
        uVar14 = uVar26 - uVar14;
      }
      if ((int)uVar14 < 0) {
        uVar5 = *(undefined4 *)local_a4[1];
        *(undefined4 *)local_a4[1] = 0;
        emxEnsureCapacity_int32_T1(local_a4,uVar5);
      }
      else {
        uVar26 = uVar14 + 1;
        uVar18 = 0;
        if (uVar26 < 2) {
          iVar9 = 0;
LAB_0001adae:
          iVar34 = (uVar14 - uVar18) + 1;
          pdVar20 = (double *)(*local_80 + iVar16 * (uVar18 + 1) * 8 + -8);
          do {
            dVar41 = *pdVar20;
            pdVar20 = pdVar20 + iVar16;
            uVar17 = in_fpscr & 0xfffffff | (uint)(dVar41 < dVar37) << 0x1f |
                     (uint)(dVar41 == dVar37) << 0x1e;
            in_fpscr = uVar17 | (uint)(NAN(dVar41) || NAN(dVar37)) << 0x1c;
            bVar31 = (byte)(uVar17 >> 0x18);
            if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              iVar9 = iVar9 + 1;
            }
            iVar34 = iVar34 + -1;
          } while (iVar34 != 0);
        }
        else {
          iVar9 = 0;
          if (1 < (int)uVar17) goto LAB_0001adae;
          uVar18 = uVar26 & 0xfffffffe;
          pdVar20 = (double *)(*local_80 + iVar16 * 8 + -8);
          uVar40 = 0;
          uVar17 = uVar18;
          do {
            dVar39 = *pdVar20;
            pdVar20 = pdVar20 + iVar16 * 2;
            in_fpscr = in_fpscr & 0xfffffff;
            uVar6 = (uint)(dVar39 != dVar37 && dVar39 < dVar37 == (NAN(dVar39) || NAN(dVar37)));
            if (uVar6 != 0) {
              uVar6 = 0xffffffff;
            }
            dVar41 = (double)((ulonglong)dVar41 & 0xffff0000ffff0000 | (ulonglong)uVar6 & 0xffff);
            uVar17 = uVar17 - 2;
            uVar40 = VectorSub(uVar40,dVar41,4);
          } while (uVar17 != 0);
          uVar5 = (undefined4)((ulonglong)uVar40 >> 0x20);
          uVar40 = VectorAdd(uVar40,CONCAT44(uVar5,uVar5),4);
          iVar9 = (int)uVar40;
          if (uVar26 != uVar18) goto LAB_0001adae;
        }
        iVar34 = *(int *)local_a4[1];
        *(int *)local_a4[1] = iVar9;
        emxEnsureCapacity_int32_T1(local_a4,iVar34);
        if (-1 < (int)uVar14) {
          iVar9 = 0;
          uVar17 = 0xffffffff;
          pdVar20 = (double *)(*local_80 + iVar16 * 8 + -8);
          do {
            dVar41 = *pdVar20;
            uVar26 = in_fpscr & 0xfffffff | (uint)(dVar41 < dVar37) << 0x1f |
                     (uint)(dVar41 == dVar37) << 0x1e;
            in_fpscr = uVar26 | (uint)(NAN(dVar41) || NAN(dVar37)) << 0x1c;
            bVar31 = (byte)(uVar26 >> 0x18);
            if (!(bool)(bVar31 >> 6 & 1) && bVar31 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
              *(uint *)(*local_a4 + iVar9 * 4) = uVar17 + 2;
              iVar9 = iVar9 + 1;
            }
            uVar17 = uVar17 + 1;
            pdVar20 = pdVar20 + iVar16;
          } while (uVar14 != uVar17);
        }
      }
      uVar5 = *(undefined4 *)local_a8[1];
      *(undefined4 *)local_a8[1] = *(undefined4 *)local_a4[1];
      emxEnsureCapacity_real_T1(local_a8,uVar5);
      iVar9 = *(int *)local_a4[1];
      if (0 < iVar9) {
        uVar17 = *local_80;
        puVar23 = (undefined8 *)*local_a8;
        piVar22 = (int *)*local_a4;
        do {
          iVar9 = iVar9 + -1;
          *puVar23 = *(undefined8 *)(uVar17 + *piVar22 * iVar16 * 8 + -8);
          puVar23 = puVar23 + 1;
          piVar22 = piVar22 + 1;
        } while (iVar9 != 0);
      }
      uVar5 = *(undefined4 *)local_80[1];
      *(undefined4 *)local_80[1] = *(undefined4 *)local_a8[1];
      emxEnsureCapacity_real_T1(local_80,uVar5);
      uVar17 = *(uint *)local_a8[1];
      if (0 < (int)uVar17) {
        puVar23 = (undefined8 *)*local_a8;
        puVar24 = (undefined8 *)*local_80;
        if (uVar17 == 1) {
          uVar26 = 0;
        }
        else {
          puVar28 = puVar23 + uVar17;
          bVar32 = puVar24 < puVar28;
          if (bVar32) {
            puVar28 = puVar24 + uVar17;
          }
          if (bVar32 && puVar23 < puVar28) {
            uVar26 = 0;
          }
          else {
            uVar26 = uVar17 & 0xfffffffe;
            puVar28 = puVar23;
            puVar10 = puVar24;
            uVar18 = uVar26;
            do {
              uVar40 = *puVar28;
              uVar42 = puVar28[1];
              puVar28 = puVar28 + 2;
              uVar18 = uVar18 - 2;
              *puVar10 = uVar40;
              puVar10[1] = uVar42;
              puVar10 = puVar10 + 2;
            } while (uVar18 != 0);
            if (uVar17 == uVar26) goto LAB_00019be6;
          }
        }
        puVar23 = puVar23 + uVar26;
        puVar24 = puVar24 + uVar26;
        iVar9 = uVar17 - uVar26;
        do {
          uVar40 = *puVar23;
          puVar23 = puVar23 + 1;
          iVar9 = iVar9 + -1;
          *puVar24 = uVar40;
          puVar24 = puVar24 + 1;
        } while (iVar9 != 0);
      }
LAB_00019be6:
      dVar41 = (double)c_nanmean(local_80);
      iVar4 = iVar4 + 8;
      dVar37 = *(double *)*local_7c;
      in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar37 < 0.0) << 0x1f | (uint)(dVar37 == 0.0) << 0x1e
                 | (uint)(0.0 <= dVar37) << 0x1d;
      dVar37 = dVar38;
      if ((int)in_fpscr < 0) {
        dVar37 = dVar41;
        dVar41 = dVar38;
      }
      uVar17 = *(uint *)(*(int *)(param_1 + 4) + 4);
      puVar23 = (undefined8 *)(*param_5 + *(int *)param_5[1] * uVar21 * 8);
      *puVar23 = uVar36;
      puVar23[1] = dVar37;
      puVar23[2] = dVar41;
      bVar32 = (int)uVar21 < (int)uVar17;
      uVar21 = uVar21 + 1;
    } while (bVar32);
  }
  emxFree_boolean_T(&local_b4);
  emxFree_boolean_T(&local_b0);
  emxFree_boolean_T(&local_ac);
  emxFree_real_T(&local_a8);
  emxFree_int32_T(&local_a4);
  emxFree_int32_T(&local_a0);
  emxFree_int32_T(&local_9c);
  emxFree_int32_T(&local_98);
  emxFree_boolean_T(&local_94);
  emxFree_uint32_T(&local_90);
  emxFree_boolean_T(&local_8c);
  emxFree_real_T(&local_88);
  emxFree_real_T(&local_84);
  emxFree_real_T(&local_80);
  emxFree_real_T(&local_7c);
  emxFree_boolean_T(&local_78);
  emxFree_real_T(&local_74);
  emxFree_real_T(&local_70);
  if (__stack_chk_guard != local_6c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



// WARNING: Restarted to delay deadcode elimination for space: register
// WARNING: Restarted to delay deadcode elimination for space: stack

void FUN_0001afcc(int *param_1,int *param_2,int *param_3,int *param_4,int *param_5)

{
  undefined1 auVar1 [16];
  undefined1 auVar2 [32];
  undefined1 auVar3 [32];
  int iVar4;
  undefined4 *puVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  char *pcVar9;
  char cVar10;
  int iVar11;
  double *pdVar12;
  uint uVar13;
  uint uVar14;
  double in_d16;
  undefined1 auVar15 [16];
  undefined1 auVar16 [16];
  undefined8 uVar17;
  ulonglong uVar18;
  undefined1 in_q10 [16];
  undefined1 auVar19 [16];
  int *local_3c;
  int *local_38;
  int *local_34;
  undefined4 local_30;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  auVar16._8_8_ = in_d16;
  emxInit_boolean_T(&local_2c,1);
  emxInit_real_T(&local_30,1);
  emxInit_real_T(&local_34,1);
  *(undefined1 *)*param_3 = 0;
  *(undefined1 *)(*param_3 + *(int *)param_3[1] + -1) = 0;
  nullAssignment(param_1,param_3);
  nullAssignment(param_2,param_3);
  diff(param_2,local_30);
  b_sign(local_30);
  diff(local_30,local_34);
  uVar6 = *(undefined4 *)local_2c[1];
  *(undefined4 *)local_2c[1] = *(undefined4 *)local_34[1];
  emxEnsureCapacity_boolean_T(local_2c,uVar6);
  iVar4 = *(int *)local_34[1];
  if (0 < iVar4) {
    auVar16._8_8_ = *(double *)*local_34;
    auVar16._0_8_ = -2.0;
    *(bool *)*local_2c = auVar16._8_8_ == -2.0;
    if (iVar4 != 1) {
      iVar7 = 1;
      iVar11 = 8;
      do {
        pdVar12 = (double *)(*local_34 + iVar11);
        iVar11 = iVar11 + 8;
        auVar16._8_8_ = *pdVar12;
        *(bool *)(*local_2c + iVar7) = auVar16._8_8_ == auVar16._0_8_;
        iVar7 = iVar7 + 1;
      } while (iVar4 != iVar7);
    }
  }
  emxInit_boolean_T(&local_38,1);
  diff(param_2,local_30);
  b_sign(local_30);
  diff(local_30,local_34);
  uVar6 = *(undefined4 *)local_38[1];
  *(undefined4 *)local_38[1] = *(undefined4 *)local_34[1];
  emxEnsureCapacity_boolean_T(local_38,uVar6);
  iVar4 = *(int *)local_34[1];
  emxFree_real_T(&local_30);
  if (0 < iVar4) {
    auVar15._8_8_ = auVar16._8_8_;
    auVar15._0_8_ = 2.0;
    iVar7 = 0;
    iVar11 = 0;
    do {
      pdVar12 = (double *)(*local_34 + iVar7);
      iVar7 = iVar7 + 8;
      auVar15._8_8_ = *pdVar12;
      *(bool *)(*local_38 + iVar11) = auVar15._8_8_ == auVar15._0_8_;
      iVar11 = iVar11 + 1;
    } while (iVar4 != iVar11);
  }
  emxFree_real_T(&local_34);
  emxInit_boolean_T(&local_3c,1);
  iVar4 = *(int *)local_3c[1];
  *(int *)local_3c[1] = *(int *)local_2c[1] + 2;
  emxEnsureCapacity_boolean_T(local_3c,iVar4);
  *(undefined1 *)*local_3c = 1;
  iVar4 = *(int *)local_2c[1];
  if (0 < iVar4) {
    iVar7 = 0;
    do {
      if (*(char *)(*local_2c + iVar7) == '\0') {
        cVar10 = *(char *)(*local_38 + iVar7);
        if (cVar10 != '\0') {
          cVar10 = '\x01';
        }
      }
      else {
        cVar10 = '\x01';
      }
      iVar11 = *local_3c + iVar7;
      iVar7 = iVar7 + 1;
      *(char *)(iVar11 + 1) = cVar10;
    } while (iVar4 != iVar7);
    iVar4 = *(int *)local_2c[1];
  }
  *(undefined1 *)(iVar4 + *local_3c + 1) = 1;
  uVar14 = *(uint *)local_3c[1];
  if ((int)uVar14 < 1) {
    uVar6 = *(undefined4 *)param_5[1];
    *(undefined4 *)param_5[1] = 0;
    emxEnsureCapacity_real_T1(param_5,uVar6);
  }
  else {
    if (uVar14 < 4) {
      iVar4 = 0;
      uVar8 = 0;
LAB_0001b1fa:
      iVar7 = uVar14 - uVar8;
      pcVar9 = (char *)(*local_3c + uVar8);
      do {
        if (*pcVar9 != '\0') {
          iVar4 = iVar4 + 1;
        }
        iVar7 = iVar7 + -1;
        pcVar9 = pcVar9 + 1;
      } while (iVar7 != 0);
    }
    else {
      uVar8 = uVar14 & 0xfffffffc;
      auVar16 = ZEXT816(0);
      auVar15 = SIMDExpandImmediate(0,0,1);
      puVar5 = (undefined4 *)*local_3c;
      uVar13 = uVar8;
      do {
        uVar17 = in_q10._0_8_;
        uVar13 = uVar13 - 4;
                    // WARNING: Ignoring partial resolution of indirect
        uVar6 = *puVar5;
        auVar19 = VectorCopyLong(uVar17,1,1);
        uVar18 = VectorCompareEqual(auVar19._0_8_,0,2);
        in_q10 = VectorCopyLong(~uVar18,2,1);
        in_q10 = in_q10 & auVar15;
        auVar16 = VectorAdd(auVar16,in_q10,4);
        puVar5 = puVar5 + 1;
      } while (uVar13 != 0);
      auVar2._16_16_ = auVar16;
      auVar2._0_16_ = auVar16;
      auVar16 = VectorAdd(auVar16,auVar2._8_16_,4);
      uVar17 = CONCAT44(auVar16._4_4_,auVar16._4_4_);
      auVar19._8_8_ = uVar17;
      auVar19._0_8_ = uVar17;
      auVar16 = VectorAdd(auVar16,auVar19,4);
      iVar4 = auVar16._0_4_;
      if (uVar14 != uVar8) goto LAB_0001b1fa;
    }
    iVar7 = *(int *)param_5[1];
    *(int *)param_5[1] = iVar4;
    emxEnsureCapacity_real_T1(param_5,iVar7);
    if (0 < (int)uVar14) {
      iVar4 = 0;
      iVar7 = 0;
      pcVar9 = (char *)*local_3c;
      do {
        if (*pcVar9 != '\0') {
          iVar11 = iVar7 * 8;
          iVar7 = iVar7 + 1;
          *(undefined8 *)(*param_5 + iVar11) = *(undefined8 *)(*param_2 + iVar4);
        }
        pcVar9 = pcVar9 + 1;
        iVar4 = iVar4 + 8;
        uVar14 = uVar14 - 1;
      } while (uVar14 != 0);
    }
  }
  iVar4 = *(int *)local_3c[1];
  *(int *)local_3c[1] = *(int *)local_2c[1] + 2;
  emxEnsureCapacity_boolean_T(local_3c,iVar4);
  *(undefined1 *)*local_3c = 1;
  iVar4 = *(int *)local_2c[1];
  if (0 < iVar4) {
    iVar7 = 0;
    while( true ) {
      if (*(char *)(*local_2c + iVar7) == '\0') {
        cVar10 = *(char *)(*local_38 + iVar7);
        if (cVar10 != '\0') {
          cVar10 = '\x01';
        }
      }
      else {
        cVar10 = '\x01';
      }
      *(char *)(*local_3c + iVar7 + 1) = cVar10;
      if (iVar4 + -1 == iVar7) break;
      iVar7 = iVar7 + 1;
    }
  }
  emxFree_boolean_T(&local_38);
  *(undefined1 *)(*(int *)local_2c[1] + *local_3c + 1) = 1;
  uVar14 = *(uint *)local_3c[1];
  emxFree_boolean_T(&local_2c);
  if ((int)uVar14 < 1) {
    uVar6 = *(undefined4 *)param_4[1];
    *(undefined4 *)param_4[1] = 0;
    emxEnsureCapacity_real_T1(param_4,uVar6);
    goto LAB_0001b394;
  }
  if (uVar14 < 4) {
    iVar4 = 0;
    uVar8 = 0;
LAB_0001b338:
    iVar7 = uVar14 - uVar8;
    pcVar9 = (char *)(*local_3c + uVar8);
    do {
      if (*pcVar9 != '\0') {
        iVar4 = iVar4 + 1;
      }
      iVar7 = iVar7 + -1;
      pcVar9 = pcVar9 + 1;
    } while (iVar7 != 0);
  }
  else {
    uVar8 = uVar14 & 0xfffffffc;
    auVar16 = ZEXT816(0);
    auVar15 = SIMDExpandImmediate(0,0,1);
    puVar5 = (undefined4 *)*local_3c;
    uVar13 = uVar8;
    do {
      uVar17 = in_q10._0_8_;
      uVar13 = uVar13 - 4;
                    // WARNING: Ignoring partial resolution of indirect
      uVar6 = *puVar5;
      auVar19 = VectorCopyLong(uVar17,1,1);
      uVar18 = VectorCompareEqual(auVar19._0_8_,0,2);
      in_q10 = VectorCopyLong(~uVar18,2,1);
      in_q10 = in_q10 & auVar15;
      auVar16 = VectorAdd(auVar16,in_q10,4);
      puVar5 = puVar5 + 1;
    } while (uVar13 != 0);
    auVar3._16_16_ = auVar16;
    auVar3._0_16_ = auVar16;
    auVar16 = VectorAdd(auVar16,auVar3._8_16_,4);
    uVar17 = CONCAT44(auVar16._4_4_,auVar16._4_4_);
    auVar1._8_8_ = uVar17;
    auVar1._0_8_ = uVar17;
    auVar16 = VectorAdd(auVar16,auVar1,4);
    iVar4 = auVar16._0_4_;
    if (uVar14 != uVar8) goto LAB_0001b338;
  }
  iVar7 = *(int *)param_4[1];
  *(int *)param_4[1] = iVar4;
  emxEnsureCapacity_real_T1(param_4,iVar7);
  if (0 < (int)uVar14) {
    iVar4 = 0;
    iVar7 = 0;
    pcVar9 = (char *)*local_3c;
    do {
      if (*pcVar9 != '\0') {
        iVar11 = iVar7 * 8;
        iVar7 = iVar7 + 1;
        *(undefined8 *)(*param_4 + iVar11) = *(undefined8 *)(*param_1 + iVar4);
      }
      pcVar9 = pcVar9 + 1;
      iVar4 = iVar4 + 8;
      uVar14 = uVar14 - 1;
    } while (uVar14 != 0);
  }
LAB_0001b394:
  emxFree_boolean_T(&local_3c);
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void MAXBG(int *param_1,uint *param_2)

{
  int iVar1;
  double *pdVar2;
  uint uVar3;
  int iVar4;
  int iVar5;
  uint uVar6;
  int *piVar7;
  undefined8 *puVar8;
  int iVar9;
  undefined8 *puVar10;
  int iVar11;
  uint uVar12;
  int iVar13;
  int iVar14;
  int iVar15;
  int iVar16;
  undefined8 *puVar17;
  undefined8 *puVar18;
  bool bVar19;
  double dVar20;
  double dVar21;
  undefined8 uVar22;
  undefined8 uVar23;
  uint *local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  emxInit_real_T1(&local_38,2);
  iVar13 = param_1[1];
  piVar7 = (int *)local_38[1];
  iVar4 = *piVar7;
  iVar9 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(iVar13 + 4);
  emxEnsureCapacity_real_T(local_38,iVar9 * iVar4);
  iVar9 = *(int *)param_1[1];
  iVar4 = ((int *)param_1[1])[1];
  if (0 < iVar4) {
    iVar16 = 8;
    iVar13 = 1;
    iVar11 = 0;
    do {
      iVar5 = iVar13;
      iVar4 = iVar11 * iVar9;
      dVar20 = *(double *)(*param_1 + iVar4 * 8);
      if (1 < iVar9) {
        iVar15 = iVar11 * iVar9 + iVar9;
        iVar13 = rtIsNaN(SUB84(dVar20,0),(int)((ulonglong)dVar20 >> 0x20));
        if (iVar13 == 0) {
          iVar4 = iVar4 + 1;
        }
        else {
          iVar13 = iVar4 + 2;
          iVar14 = iVar16;
          do {
            iVar4 = iVar13;
            iVar1 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar14),
                            (int)((ulonglong)*(undefined8 *)(*param_1 + iVar14) >> 0x20));
            if (iVar1 == 0) {
              dVar20 = *(double *)(*param_1 + iVar14);
              break;
            }
            if (iVar15 <= iVar4) break;
            iVar14 = iVar14 + 8;
            iVar13 = iVar4 + 1;
          } while (iVar1 != 0);
        }
        if (iVar4 < iVar15) {
          pdVar2 = (double *)(*param_1 + iVar4 * 8);
          do {
            dVar21 = *pdVar2;
            pdVar2 = pdVar2 + 1;
            iVar4 = iVar4 + 1;
            if (dVar21 != dVar20 && dVar21 < dVar20 == (NAN(dVar21) || NAN(dVar20))) {
              dVar20 = dVar21;
            }
          } while (iVar4 < iVar15);
        }
      }
      iVar16 = iVar16 + iVar9 * 8;
      piVar7 = (int *)param_1[1];
      iVar4 = piVar7[1];
      *(double *)(*local_38 + iVar11 * 8) = dVar20;
      iVar13 = iVar5 + 1;
      iVar11 = iVar5;
    } while (iVar5 < iVar4);
    iVar9 = *piVar7;
  }
  iVar9 = iVar9 * iVar4;
  dVar20 = *(double *)*param_1;
  if (1 < iVar9) {
    iVar4 = rtIsNaN(SUB84(dVar20,0),(int)((ulonglong)dVar20 >> 0x20));
    if (iVar4 == 0) {
      iVar4 = 1;
    }
    else {
      iVar11 = 8;
      iVar13 = 2;
      do {
        iVar4 = iVar13;
        iVar16 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar11),
                         (int)((ulonglong)*(undefined8 *)(*param_1 + iVar11) >> 0x20));
        if (iVar16 == 0) {
          dVar20 = *(double *)(*param_1 + iVar11);
          break;
        }
        if (iVar9 <= iVar4) break;
        iVar11 = iVar11 + 8;
        iVar13 = iVar4 + 1;
      } while (iVar16 != 0);
    }
    iVar13 = *(int *)param_1[1] * ((int *)param_1[1])[1];
    if (iVar4 < iVar13) {
      iVar13 = iVar9;
    }
    if (iVar4 < iVar13) {
      iVar9 = iVar9 - iVar4;
      pdVar2 = (double *)(*param_1 + iVar4 * 8);
      do {
        dVar21 = *pdVar2;
        pdVar2 = pdVar2 + 1;
        if (dVar21 != dVar20 && dVar21 < dVar20 == (NAN(dVar21) || NAN(dVar20))) {
          dVar20 = dVar21;
        }
        iVar9 = iVar9 + -1;
      } while (iVar9 != 0);
    }
  }
  piVar7 = (int *)param_2[1];
  iVar4 = *piVar7;
  iVar9 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(local_38[1] + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar9 * iVar4);
  uVar3 = ((int *)local_38[1])[1];
  if ((int)uVar3 < 1) {
    puVar18 = (undefined8 *)*param_2;
    iVar4 = *(int *)param_2[1];
  }
  else {
    puVar18 = (undefined8 *)*param_2;
    uVar12 = 0;
    iVar9 = *(int *)local_38[1];
    puVar17 = (undefined8 *)*local_38;
    iVar4 = *(int *)param_2[1];
    if ((uVar3 != 1) && (iVar4 == 1 && iVar9 == 1)) {
      puVar8 = puVar17 + uVar3;
      bVar19 = puVar18 < puVar8;
      if (bVar19) {
        puVar8 = puVar18 + uVar3;
      }
      if (bVar19 && puVar17 < puVar8) {
        uVar12 = 0;
      }
      else {
        uVar12 = uVar3 & 0xfffffffe;
        uVar6 = uVar12;
        puVar8 = puVar17;
        puVar10 = puVar18;
        do {
          uVar22 = *puVar8;
          uVar23 = puVar8[1];
          puVar8 = puVar8 + iVar9 * 2;
          uVar6 = uVar6 - 2;
          *puVar10 = uVar22;
          puVar10[1] = uVar23;
          puVar10 = puVar10 + iVar4 * 2;
        } while (uVar6 != 0);
        if (uVar3 == uVar12) goto LAB_0001b5b0;
      }
    }
    iVar13 = uVar3 - uVar12;
    puVar17 = puVar17 + uVar12 * iVar9;
    puVar8 = puVar18 + uVar12 * iVar4;
    do {
      uVar22 = *puVar17;
      puVar17 = puVar17 + iVar9;
      iVar13 = iVar13 + -1;
      *puVar8 = uVar22;
      puVar8 = puVar8 + iVar4;
    } while (iVar13 != 0);
  }
LAB_0001b5b0:
  puVar18[iVar4 * uVar3] = dVar20;
  emxFree_real_T(&local_38);
  if (__stack_chk_guard != local_34) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void MBG(int param_1,uint *param_2)

{
  int *piVar1;
  uint uVar2;
  int iVar3;
  undefined8 *puVar4;
  int iVar5;
  undefined8 *puVar6;
  uint uVar7;
  uint uVar8;
  int iVar9;
  undefined8 *puVar10;
  undefined8 *puVar11;
  bool bVar12;
  undefined8 uVar13;
  undefined8 uVar14;
  undefined8 uVar15;
  uint *local_2c;
  int local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  emxInit_real_T1(&local_2c,2);
  d_nanmean(param_1,local_2c);
  local_28 = (*(int **)(param_1 + 4))[1] * **(int **)(param_1 + 4);
  uVar13 = c_nanmean();
  piVar1 = (int *)param_2[1];
  iVar3 = *piVar1;
  iVar5 = piVar1[1];
  uVar7 = local_2c[1];
  *piVar1 = 1;
  piVar1[1] = *(int *)(uVar7 + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar5 * iVar3);
  uVar7 = ((int *)local_2c[1])[1];
  if ((int)uVar7 < 1) {
    puVar11 = (undefined8 *)*param_2;
    iVar3 = *(int *)param_2[1];
  }
  else {
    puVar11 = (undefined8 *)*param_2;
    uVar8 = 0;
    iVar5 = *(int *)local_2c[1];
    puVar10 = (undefined8 *)*local_2c;
    iVar3 = *(int *)param_2[1];
    if ((uVar7 != 1) && (iVar3 == 1 && iVar5 == 1)) {
      puVar4 = puVar10 + uVar7;
      bVar12 = puVar11 < puVar4;
      if (bVar12) {
        puVar4 = puVar11 + uVar7;
      }
      if (bVar12 && puVar10 < puVar4) {
        uVar8 = 0;
      }
      else {
        uVar8 = uVar7 & 0xfffffffe;
        uVar2 = uVar8;
        puVar4 = puVar10;
        puVar6 = puVar11;
        do {
          uVar14 = *puVar4;
          uVar15 = puVar4[1];
          puVar4 = puVar4 + iVar5 * 2;
          uVar2 = uVar2 - 2;
          *puVar6 = uVar14;
          puVar6[1] = uVar15;
          puVar6 = puVar6 + iVar3 * 2;
        } while (uVar2 != 0);
        if (uVar7 == uVar8) goto LAB_0001b6fc;
      }
    }
    iVar9 = uVar7 - uVar8;
    puVar10 = puVar10 + uVar8 * iVar5;
    puVar4 = puVar11 + uVar8 * iVar3;
    do {
      uVar14 = *puVar10;
      puVar10 = puVar10 + iVar5;
      iVar9 = iVar9 + -1;
      *puVar4 = uVar14;
      puVar4 = puVar4 + iVar3;
    } while (iVar9 != 0);
  }
LAB_0001b6fc:
  puVar11[iVar3 * uVar7] = uVar13;
  emxFree_real_T(&local_2c);
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void MINBG(int *param_1,uint *param_2)

{
  int iVar1;
  double *pdVar2;
  uint uVar3;
  int iVar4;
  int iVar5;
  uint uVar6;
  int *piVar7;
  undefined8 *puVar8;
  int iVar9;
  undefined8 *puVar10;
  int iVar11;
  uint uVar12;
  int iVar13;
  int iVar14;
  int iVar15;
  int iVar16;
  undefined8 *puVar17;
  undefined8 *puVar18;
  bool bVar19;
  double dVar20;
  double dVar21;
  undefined8 uVar22;
  undefined8 uVar23;
  uint *local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  emxInit_real_T1(&local_38,2);
  iVar13 = param_1[1];
  piVar7 = (int *)local_38[1];
  iVar4 = *piVar7;
  iVar9 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(iVar13 + 4);
  emxEnsureCapacity_real_T(local_38,iVar9 * iVar4);
  iVar9 = *(int *)param_1[1];
  iVar4 = ((int *)param_1[1])[1];
  if (0 < iVar4) {
    iVar16 = 8;
    iVar13 = 1;
    iVar11 = 0;
    do {
      iVar5 = iVar13;
      iVar4 = iVar11 * iVar9;
      dVar20 = *(double *)(*param_1 + iVar4 * 8);
      if (1 < iVar9) {
        iVar15 = iVar11 * iVar9 + iVar9;
        iVar13 = rtIsNaN(SUB84(dVar20,0),(int)((ulonglong)dVar20 >> 0x20));
        if (iVar13 == 0) {
          iVar4 = iVar4 + 1;
        }
        else {
          iVar13 = iVar4 + 2;
          iVar14 = iVar16;
          do {
            iVar4 = iVar13;
            iVar1 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar14),
                            (int)((ulonglong)*(undefined8 *)(*param_1 + iVar14) >> 0x20));
            if (iVar1 == 0) {
              dVar20 = *(double *)(*param_1 + iVar14);
              break;
            }
            if (iVar15 <= iVar4) break;
            iVar14 = iVar14 + 8;
            iVar13 = iVar4 + 1;
          } while (iVar1 != 0);
        }
        if (iVar4 < iVar15) {
          pdVar2 = (double *)(*param_1 + iVar4 * 8);
          do {
            dVar21 = *pdVar2;
            pdVar2 = pdVar2 + 1;
            iVar4 = iVar4 + 1;
            if ((int)((uint)(dVar21 < dVar20) << 0x1f) < 0) {
              dVar20 = dVar21;
            }
          } while (iVar4 < iVar15);
        }
      }
      iVar16 = iVar16 + iVar9 * 8;
      piVar7 = (int *)param_1[1];
      iVar4 = piVar7[1];
      *(double *)(*local_38 + iVar11 * 8) = dVar20;
      iVar13 = iVar5 + 1;
      iVar11 = iVar5;
    } while (iVar5 < iVar4);
    iVar9 = *piVar7;
  }
  iVar9 = iVar9 * iVar4;
  dVar20 = *(double *)*param_1;
  if (1 < iVar9) {
    iVar4 = rtIsNaN(SUB84(dVar20,0),(int)((ulonglong)dVar20 >> 0x20));
    if (iVar4 == 0) {
      iVar4 = 1;
    }
    else {
      iVar11 = 8;
      iVar13 = 2;
      do {
        iVar4 = iVar13;
        iVar16 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar11),
                         (int)((ulonglong)*(undefined8 *)(*param_1 + iVar11) >> 0x20));
        if (iVar16 == 0) {
          dVar20 = *(double *)(*param_1 + iVar11);
          break;
        }
        if (iVar9 <= iVar4) break;
        iVar11 = iVar11 + 8;
        iVar13 = iVar4 + 1;
      } while (iVar16 != 0);
    }
    iVar13 = *(int *)param_1[1] * ((int *)param_1[1])[1];
    if (iVar4 < iVar13) {
      iVar13 = iVar9;
    }
    if (iVar4 < iVar13) {
      iVar9 = iVar9 - iVar4;
      pdVar2 = (double *)(*param_1 + iVar4 * 8);
      do {
        dVar21 = *pdVar2;
        pdVar2 = pdVar2 + 1;
        if ((int)((uint)(dVar21 < dVar20) << 0x1f) < 0) {
          dVar20 = dVar21;
        }
        iVar9 = iVar9 + -1;
      } while (iVar9 != 0);
    }
  }
  piVar7 = (int *)param_2[1];
  iVar4 = *piVar7;
  iVar9 = piVar7[1];
  *piVar7 = 1;
  piVar7[1] = *(int *)(local_38[1] + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar9 * iVar4);
  uVar3 = ((int *)local_38[1])[1];
  if ((int)uVar3 < 1) {
    puVar18 = (undefined8 *)*param_2;
    iVar4 = *(int *)param_2[1];
  }
  else {
    puVar18 = (undefined8 *)*param_2;
    uVar12 = 0;
    iVar9 = *(int *)local_38[1];
    puVar17 = (undefined8 *)*local_38;
    iVar4 = *(int *)param_2[1];
    if ((uVar3 != 1) && (iVar4 == 1 && iVar9 == 1)) {
      puVar8 = puVar17 + uVar3;
      bVar19 = puVar18 < puVar8;
      if (bVar19) {
        puVar8 = puVar18 + uVar3;
      }
      if (bVar19 && puVar17 < puVar8) {
        uVar12 = 0;
      }
      else {
        uVar12 = uVar3 & 0xfffffffe;
        uVar6 = uVar12;
        puVar8 = puVar17;
        puVar10 = puVar18;
        do {
          uVar22 = *puVar8;
          uVar23 = puVar8[1];
          puVar8 = puVar8 + iVar9 * 2;
          uVar6 = uVar6 - 2;
          *puVar10 = uVar22;
          puVar10[1] = uVar23;
          puVar10 = puVar10 + iVar4 * 2;
        } while (uVar6 != 0);
        if (uVar3 == uVar12) goto LAB_0001b960;
      }
    }
    iVar13 = uVar3 - uVar12;
    puVar17 = puVar17 + uVar12 * iVar9;
    puVar8 = puVar18 + uVar12 * iVar4;
    do {
      uVar22 = *puVar17;
      puVar17 = puVar17 + iVar9;
      iVar13 = iVar13 + -1;
      *puVar8 = uVar22;
      puVar8 = puVar8 + iVar4;
    } while (iVar13 != 0);
  }
LAB_0001b960:
  puVar18[iVar4 * uVar3] = dVar20;
  emxFree_real_T(&local_38);
  if (__stack_chk_guard != local_34) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void MODD(int *param_1,uint *param_2)

{
  int iVar1;
  int iVar2;
  double *pdVar3;
  uint uVar4;
  int *piVar5;
  double *pdVar6;
  undefined8 *puVar7;
  int iVar8;
  int *piVar9;
  int iVar10;
  undefined8 *puVar11;
  undefined8 *puVar12;
  int iVar13;
  uint uVar14;
  int iVar15;
  uint uVar16;
  int iVar17;
  int iVar18;
  undefined8 *puVar19;
  int iVar20;
  uint uVar21;
  bool bVar22;
  double dVar23;
  undefined8 uVar24;
  double dVar25;
  undefined8 uVar26;
  undefined8 uVar27;
  uint *local_34;
  int *local_30;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  emxInit_real_T1(&local_2c,2);
  piVar5 = (int *)param_1[1];
  iVar8 = piVar5[1];
  if (iVar8 < 2) {
    piVar9 = (int *)local_2c[1];
    iVar8 = *piVar9;
    iVar15 = piVar9[1];
    *piVar9 = *piVar5;
    piVar9[1] = 0;
    emxEnsureCapacity_real_T(local_2c,iVar15 * iVar8);
    piVar5 = (int *)local_2c[1];
    iVar8 = *piVar5;
    iVar15 = iVar8;
  }
  else {
    piVar9 = (int *)local_2c[1];
    iVar15 = *piVar9;
    iVar13 = piVar9[1];
    *piVar9 = *piVar5;
    piVar9[1] = iVar8 + -1;
    emxEnsureCapacity_real_T(local_2c,iVar13 * iVar15);
    piVar5 = (int *)local_2c[1];
    iVar8 = *piVar5;
    if (iVar8 == 0) {
      iVar8 = 0;
      iVar15 = 0;
    }
    else {
      iVar13 = *(int *)param_1[1];
      iVar15 = iVar8;
      if (0 < iVar13) {
        iVar20 = *param_1;
        iVar15 = 0;
        iVar10 = ((int *)param_1[1])[1];
        iVar2 = iVar20 + iVar13 * 8;
        do {
          if (1 < iVar10) {
            iVar1 = *local_2c;
            iVar17 = 0;
            iVar18 = iVar10 + -1;
            dVar23 = *(double *)(iVar20 + iVar15 * 8);
            do {
              iVar18 = iVar18 + -1;
              dVar25 = *(double *)(iVar2 + iVar17);
              pdVar3 = (double *)(iVar1 + iVar15 * 8 + iVar17);
              iVar17 = iVar17 + iVar13 * 8;
              *pdVar3 = dVar25 - dVar23;
              dVar23 = dVar25;
            } while (iVar18 != 0);
          }
          iVar15 = iVar15 + 1;
          iVar2 = iVar2 + 8;
        } while (iVar15 != iVar13);
        iVar15 = *piVar5;
      }
    }
  }
  iVar13 = piVar5[1];
  emxInit_real_T1(&local_30,2);
  piVar5 = (int *)local_30[1];
  iVar2 = *piVar5;
  iVar10 = piVar5[1];
  *piVar5 = iVar15;
  piVar5[1] = iVar13;
  emxEnsureCapacity_real_T(local_30,iVar10 * iVar2);
  iVar13 = iVar13 * iVar8;
  if (0 < iVar13) {
    pdVar6 = (double *)*local_2c;
    pdVar3 = (double *)*local_30;
    do {
      dVar23 = *pdVar6;
      pdVar6 = pdVar6 + 1;
      iVar13 = iVar13 + -1;
      *pdVar3 = ABS(dVar23);
      pdVar3 = pdVar3 + 1;
    } while (iVar13 != 0);
  }
  emxFree_real_T(&local_2c);
  emxInit_real_T1(&local_34,2);
  d_nanmean(local_30,param_2);
  uVar24 = nanmean(param_2);
  uVar4 = param_2[1];
  piVar5 = (int *)local_34[1];
  iVar8 = *piVar5;
  iVar15 = piVar5[1];
  *piVar5 = 1;
  piVar5[1] = *(int *)(uVar4 + 4) + 2;
  emxEnsureCapacity_real_T(local_34,iVar15 * iVar8);
  uVar4 = *(uint *)(param_2[1] + 4);
  *(undefined8 *)*local_34 = rtNaN;
  emxFree_real_T(&local_30);
  if ((int)uVar4 < 1) {
    piVar5 = (int *)param_2[1];
    uVar21 = *local_34;
    piVar9 = (int *)local_34[1];
    iVar8 = *piVar9;
    iVar15 = *piVar5;
  }
  else {
    uVar16 = 0;
    puVar19 = (undefined8 *)*param_2;
    piVar5 = (int *)param_2[1];
    uVar21 = *local_34;
    piVar9 = (int *)local_34[1];
    iVar8 = *piVar9;
    iVar15 = *piVar5;
    if ((uVar4 != 1) && (iVar8 == 1 && iVar15 == 1)) {
      puVar11 = puVar19 + uVar4;
      bVar22 = (undefined8 *)(uVar21 + 8) < puVar11;
      if (bVar22) {
        puVar11 = (undefined8 *)(uVar21 + uVar4 * 8 + 8);
      }
      if (bVar22 && puVar19 < puVar11) {
        uVar16 = 0;
      }
      else {
        uVar16 = uVar4 & 0xfffffffe;
        puVar7 = (undefined8 *)(uVar21 + iVar8 * 8);
        puVar11 = puVar19;
        uVar14 = uVar16;
        do {
          uVar26 = *puVar11;
          uVar27 = puVar11[1];
          puVar11 = puVar11 + iVar15 * 2;
          uVar14 = uVar14 - 2;
          *puVar7 = uVar26;
          puVar7[1] = uVar27;
          puVar7 = puVar7 + iVar8 * 2;
        } while (uVar14 != 0);
        if (uVar4 == uVar16) goto LAB_0001bbc8;
      }
    }
    iVar13 = uVar4 - uVar16;
    puVar19 = puVar19 + uVar16 * iVar15;
    puVar11 = (undefined8 *)(uVar21 + iVar8 * (uVar16 + 1) * 8);
    do {
      uVar26 = *puVar19;
      puVar19 = puVar19 + iVar15;
      iVar13 = iVar13 + -1;
      *puVar11 = uVar26;
      puVar11 = puVar11 + iVar8;
    } while (iVar13 != 0);
  }
LAB_0001bbc8:
  iVar13 = piVar5[1];
  *piVar5 = 1;
  piVar5[1] = piVar9[1];
  *(undefined8 *)(uVar21 + (iVar13 + 1) * iVar8 * 8) = uVar24;
  emxEnsureCapacity_real_T(param_2,iVar15 * iVar13);
  uVar4 = ((int *)local_34[1])[1];
  if (0 < (int)uVar4) {
    puVar19 = (undefined8 *)*param_2;
    uVar21 = 0;
    iVar8 = *(int *)local_34[1];
    puVar11 = (undefined8 *)*local_34;
    iVar15 = *(int *)param_2[1];
    if ((uVar4 != 1) && (iVar15 == 1 && iVar8 == 1)) {
      puVar7 = puVar11 + uVar4;
      bVar22 = puVar19 < puVar7;
      if (bVar22) {
        puVar7 = puVar19 + uVar4;
      }
      if (bVar22 && puVar11 < puVar7) {
        uVar21 = 0;
      }
      else {
        uVar21 = uVar4 & 0xfffffffe;
        puVar7 = puVar19;
        puVar12 = puVar11;
        uVar16 = uVar21;
        do {
          uVar24 = *puVar12;
          uVar26 = puVar12[1];
          puVar12 = puVar12 + iVar8 * 2;
          uVar16 = uVar16 - 2;
          *puVar7 = uVar24;
          puVar7[1] = uVar26;
          puVar7 = puVar7 + iVar15 * 2;
        } while (uVar16 != 0);
        if (uVar4 == uVar21) goto LAB_0001bc48;
      }
    }
    iVar13 = uVar4 - uVar21;
    puVar11 = puVar11 + uVar21 * iVar8;
    puVar19 = puVar19 + uVar21 * iVar15;
    do {
      uVar24 = *puVar11;
      puVar11 = puVar11 + iVar8;
      iVar13 = iVar13 + -1;
      *puVar19 = uVar24;
      puVar19 = puVar19 + iVar15;
    } while (iVar13 != 0);
  }
LAB_0001bc48:
  emxFree_real_T(&local_34);
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void MValue(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  uint uVar1;
  undefined4 uVar2;
  int iVar3;
  uint *puVar4;
  undefined8 *puVar5;
  int iVar6;
  int iVar7;
  uint uVar8;
  double *pdVar9;
  uint uVar10;
  undefined8 *puVar11;
  undefined8 *puVar12;
  int *piVar13;
  uint uVar14;
  uint uVar15;
  double *pdVar16;
  int iVar17;
  undefined8 *puVar18;
  bool bVar19;
  undefined8 uVar20;
  double dVar21;
  undefined8 uVar22;
  int *local_44;
  uint *local_40;
  int local_3c;
  
  local_3c = __stack_chk_guard;
  uVar1 = param_1[1];
  piVar13 = (int *)param_5[1];
  iVar3 = *piVar13;
  iVar7 = piVar13[1];
  *piVar13 = 1;
  piVar13[1] = *(int *)(uVar1 + 4) + 1;
  emxEnsureCapacity_real_T(param_5,iVar7 * iVar3);
  uVar20 = rtNaN;
  iVar3 = *(int *)(param_1[1] + 4);
  if (-1 < iVar3) {
    uVar1 = iVar3 + 1;
    puVar11 = (undefined8 *)*param_5;
    if ((uVar1 < 2) ||
       ((puVar11 < (undefined8 *)((int)&rtNaN + 1U) && (&rtNaN < puVar11 + iVar3 + 1)))) {
      uVar14 = 0;
    }
    else {
      uVar14 = uVar1 & 0xfffffffe;
      puVar12 = puVar11;
      uVar15 = uVar14;
      do {
        *puVar12 = uVar20;
        puVar12[1] = uVar20;
        puVar12 = puVar12 + 2;
        uVar15 = uVar15 - 2;
      } while (uVar15 != 0);
      if (uVar1 == uVar14) goto LAB_0001bd6e;
    }
    puVar11 = puVar11 + uVar14;
    iVar3 = (iVar3 - uVar14) + 1;
    do {
      iVar3 = iVar3 + -1;
      *puVar11 = rtNaN;
      puVar11 = puVar11 + 1;
    } while (iVar3 != 0);
  }
LAB_0001bd6e:
  emxInit_real_T(&local_40,1);
  emxInit_real_T(&local_44,1);
  puVar4 = (uint *)param_1[1];
  uVar1 = puVar4[1];
  if (-1 < (int)uVar1) {
    iVar3 = 0;
    uVar14 = 0;
    do {
      if ((int)uVar1 >> 0x1f < (int)(uint)(uVar1 < uVar14 + 1)) {
        iVar7 = *(int *)local_40[1];
        *(int *)local_40[1] = *puVar4 * uVar1;
        emxEnsureCapacity_real_T1(local_40,iVar7);
        uVar1 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        if (0 < (int)uVar1) {
          puVar11 = (undefined8 *)*param_1;
          puVar12 = (undefined8 *)*local_40;
          if (uVar1 == 1) {
LAB_0001be90:
            uVar15 = 0;
          }
          else {
            puVar18 = puVar11 + uVar1;
            bVar19 = puVar12 < puVar18;
            if (bVar19) {
              puVar18 = puVar12 + uVar1;
            }
            if (bVar19 && puVar11 < puVar18) goto LAB_0001be90;
            uVar15 = uVar1 & 0xfffffffe;
            puVar18 = puVar11;
            puVar5 = puVar12;
            uVar8 = uVar15;
            do {
              uVar20 = *puVar18;
              uVar22 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar8 = uVar8 - 2;
              *puVar5 = uVar20;
              puVar5[1] = uVar22;
              puVar5 = puVar5 + 2;
            } while (uVar8 != 0);
            if (uVar1 - uVar15 == 0) goto LAB_0001beae;
          }
          puVar11 = puVar11 + uVar15;
          puVar12 = puVar12 + uVar15;
          iVar7 = uVar1 - uVar15;
          do {
            uVar20 = *puVar11;
            puVar11 = puVar11 + 1;
            iVar7 = iVar7 + -1;
            *puVar12 = uVar20;
            puVar12 = puVar12 + 1;
          } while (iVar7 != 0);
        }
      }
      else {
        uVar15 = *puVar4;
        uVar1 = *(uint *)local_40[1];
        *(uint *)local_40[1] = uVar15;
        emxEnsureCapacity_real_T1(local_40,uVar1);
        if (0 < (int)uVar15) {
          uVar1 = *param_1;
          iVar7 = *(int *)param_1[1];
          puVar11 = (undefined8 *)*local_40;
          if ((uVar15 == 1) ||
             ((puVar11 < (undefined8 *)(iVar7 * uVar14 * 8 + uVar1 + uVar15 * 8) &&
              ((undefined8 *)(iVar7 * uVar14 * 8 + uVar1) < puVar11 + uVar15)))) {
            uVar8 = 0;
          }
          else {
            puVar18 = (undefined8 *)(iVar7 * iVar3 + uVar1);
            uVar8 = uVar15 & 0xfffffffe;
            puVar12 = puVar11;
            uVar10 = uVar8;
            do {
              uVar20 = *puVar18;
              uVar22 = puVar18[1];
              puVar18 = puVar18 + 2;
              uVar10 = uVar10 - 2;
              *puVar12 = uVar20;
              puVar12[1] = uVar22;
              puVar12 = puVar12 + 2;
            } while (uVar10 != 0);
            if (uVar15 == uVar8) goto LAB_0001beae;
          }
          iVar17 = uVar15 - uVar8;
          puVar12 = (undefined8 *)(uVar1 + (iVar7 * uVar14 + uVar8) * 8);
          puVar11 = puVar11 + uVar8;
          do {
            uVar20 = *puVar12;
            puVar12 = puVar12 + 1;
            iVar17 = iVar17 + -1;
            *puVar11 = uVar20;
            puVar11 = puVar11 + 1;
          } while (iVar17 != 0);
        }
      }
LAB_0001beae:
      rdivide(local_40,local_44,param_3,param_4,local_44);
      b_log10(local_44);
      uVar2 = *(undefined4 *)local_40[1];
      *(undefined4 *)local_40[1] = *(undefined4 *)local_44[1];
      emxEnsureCapacity_real_T1(local_40,uVar2);
      iVar7 = *(int *)local_44[1];
      if (0 < iVar7) {
        pdVar9 = (double *)*local_44;
        pdVar16 = (double *)*local_40;
        do {
          dVar21 = *pdVar9;
          pdVar9 = pdVar9 + 1;
          iVar7 = iVar7 + -1;
          *pdVar16 = dVar21 * 10.0;
          pdVar16 = pdVar16 + 1;
        } while (iVar7 != 0);
      }
      b_abs(local_40);
      iVar7 = *(int *)local_40[1];
      iVar17 = *(int *)local_44[1];
      *(int *)local_40[1] = iVar17;
      emxEnsureCapacity_real_T1(local_40,iVar7);
      if (0 < iVar17) {
        iVar7 = 0;
        do {
          uVar20 = rt_powd_snf((int)*(undefined8 *)(*local_44 + iVar7),
                               (int)((ulonglong)*(undefined8 *)(*local_44 + iVar7) >> 0x20),0,
                               0x40080000);
          iVar17 = iVar17 + -1;
          uVar1 = *local_40;
          *(int *)(uVar1 + iVar7) = (int)uVar20;
          iVar6 = uVar1 + iVar7;
          iVar7 = iVar7 + 8;
          *(int *)(iVar6 + 4) = (int)((ulonglong)uVar20 >> 0x20);
        } while (iVar17 != 0);
      }
      uVar20 = c_nanmean(local_40);
      iVar3 = iVar3 + 8;
      iVar7 = *param_5;
      puVar4 = (uint *)param_1[1];
      *(int *)(iVar7 + uVar14 * 8) = (int)uVar20;
      uVar1 = puVar4[1];
      *(int *)(iVar7 + uVar14 * 8 + 4) = (int)((ulonglong)uVar20 >> 0x20);
      bVar19 = (int)uVar14 < (int)uVar1;
      uVar14 = uVar14 + 1;
    } while (bVar19);
  }
  emxFree_real_T(&local_44);
  emxFree_real_T(&local_40);
  if (__stack_chk_guard == local_3c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void b_nanmean(int *param_1,int *param_2)

{
  int iVar1;
  double *pdVar2;
  int iVar3;
  int iVar4;
  undefined4 uVar5;
  int *piVar6;
  uint uVar7;
  uint uVar8;
  double *pdVar9;
  uint uVar10;
  int iVar11;
  int iVar12;
  int iVar13;
  double dVar14;
  double dVar15;
  undefined8 uVar16;
  
  uVar5 = *(undefined4 *)param_2[1];
  *(undefined4 *)param_2[1] = *(undefined4 *)param_1[1];
  emxEnsureCapacity_real_T1(param_2,uVar5);
  piVar6 = (int *)param_1[1];
  iVar1 = *piVar6;
  if (iVar1 != 0) {
    piVar6 = (int *)piVar6[1];
  }
  if (iVar1 != 0 && piVar6 != (int *)0x0) {
    if (0 < iVar1) {
      iVar13 = -1;
      iVar12 = iVar1 * 8;
      do {
        iVar13 = iVar13 + 1;
        uVar16 = *(undefined8 *)(*param_1 + iVar13 * 8);
        iVar3 = rtIsNaN((int)uVar16,(int)((ulonglong)uVar16 >> 0x20));
        if (iVar3 == 0) {
          dVar14 = *(double *)(*param_1 + iVar13 * 8);
        }
        else {
          dVar14 = 0.0;
        }
        uVar10 = (uint)(iVar3 == 0);
        if (1 < *(int *)(param_1[1] + 4)) {
          iVar11 = 1;
          iVar3 = iVar12;
          do {
            iVar4 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar3),
                            (int)((ulonglong)*(undefined8 *)(*param_1 + iVar3) >> 0x20));
            if (iVar4 == 0) {
              uVar10 = uVar10 + 1;
              dVar14 = dVar14 + *(double *)(*param_1 + iVar3);
            }
            iVar3 = iVar3 + iVar1 * 8;
            iVar11 = iVar11 + 1;
          } while (iVar11 < *(int *)(param_1[1] + 4));
        }
        dVar15 = rtNaN;
        if (uVar10 != 0) {
          dVar15 = dVar14 / (double)(longlong)(int)uVar10;
        }
        iVar12 = iVar12 + 8;
        *(double *)(*param_2 + iVar13 * 8) = dVar15;
      } while (iVar13 != iVar1 + -1);
    }
  }
  else {
    uVar10 = *(uint *)param_2[1];
    emxEnsureCapacity_real_T1(param_2,uVar10);
    dVar14 = rtNaN;
    if (0 < (int)uVar10) {
      pdVar2 = (double *)*param_2;
      if ((uVar10 == 1) || ((pdVar2 < (double *)((int)&rtNaN + 1U) && (&rtNaN < pdVar2 + uVar10))))
      {
        uVar7 = 0;
      }
      else {
        uVar7 = uVar10 & 0xfffffffe;
        uVar8 = uVar7;
        pdVar9 = pdVar2;
        do {
          *pdVar9 = dVar14;
          pdVar9[1] = dVar14;
          pdVar9 = pdVar9 + 2;
          uVar8 = uVar8 - 2;
        } while (uVar8 != 0);
        if (uVar10 == uVar7) {
          return;
        }
      }
      pdVar2 = pdVar2 + uVar7;
      iVar1 = uVar10 - uVar7;
      do {
        iVar1 = iVar1 + -1;
        *pdVar2 = rtNaN;
        pdVar2 = pdVar2 + 1;
      } while (iVar1 != 0);
    }
  }
  return;
}



double c_nanmean(int *param_1)

{
  int iVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  double dVar5;
  double dVar6;
  
  dVar6 = rtNaN;
  if ((*(int *)param_1[1] != 0) && (0 < *(int *)param_1[1])) {
    dVar5 = 0.0;
    iVar3 = 0;
    iVar2 = 0;
    iVar4 = 0;
    do {
      iVar1 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar3),
                      (int)((ulonglong)*(undefined8 *)(*param_1 + iVar3) >> 0x20));
      if (iVar1 == 0) {
        iVar4 = iVar4 + 1;
        dVar5 = dVar5 + *(double *)(*param_1 + iVar3);
      }
      iVar3 = iVar3 + 8;
      iVar2 = iVar2 + 1;
    } while (iVar2 < *(int *)param_1[1]);
    dVar6 = rtNaN;
    if (iVar4 != 0) {
      dVar6 = dVar5 / (double)(longlong)iVar4;
    }
  }
  return dVar6;
}



void d_nanmean(int *param_1,int *param_2)

{
  bool bVar1;
  int *piVar2;
  uint uVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  double *pdVar7;
  int iVar8;
  uint uVar9;
  double *pdVar10;
  int iVar11;
  uint uVar12;
  int iVar13;
  double dVar14;
  double dVar15;
  undefined8 uVar16;
  
  piVar2 = (int *)param_2[1];
  iVar6 = *piVar2;
  iVar8 = piVar2[1];
  iVar13 = *(int *)(param_1[1] + 4);
  *piVar2 = 1;
  piVar2[1] = iVar13;
  emxEnsureCapacity_real_T(param_2,iVar8 * iVar6);
  piVar2 = (int *)param_1[1];
  iVar6 = *piVar2;
  if (iVar6 != 0) {
    piVar2 = (int *)piVar2[1];
  }
  if (iVar6 != 0 && piVar2 != (int *)0x0) {
    if (0 < (int)piVar2) {
      iVar13 = -1;
      iVar6 = -1;
      iVar8 = 1;
      do {
        iVar11 = iVar6 + 1;
        uVar16 = *(undefined8 *)(*param_1 + iVar11 * 8);
        iVar4 = rtIsNaN((int)uVar16,(int)((ulonglong)uVar16 >> 0x20));
        if (iVar4 == 0) {
          dVar14 = *(double *)(*param_1 + iVar11 * 8);
        }
        else {
          dVar14 = 0.0;
        }
        uVar3 = (uint)(iVar4 == 0);
        piVar2 = (int *)param_1[1];
        if (1 < *piVar2) {
          iVar11 = iVar6 * 8 + 0x10;
          iVar4 = 1;
          do {
            iVar5 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar11),
                            (int)((ulonglong)*(undefined8 *)(*param_1 + iVar11) >> 0x20));
            if (iVar5 == 0) {
              uVar3 = uVar3 + 1;
              dVar14 = dVar14 + *(double *)(*param_1 + iVar11);
            }
            piVar2 = (int *)param_1[1];
            iVar11 = iVar11 + 8;
            iVar4 = iVar4 + 1;
          } while (iVar4 < *piVar2);
          iVar11 = iVar4 + iVar6;
        }
        iVar6 = iVar11;
        dVar15 = rtNaN;
        if (uVar3 != 0) {
          dVar15 = dVar14 / (double)(longlong)(int)uVar3;
        }
        iVar13 = iVar13 + 1;
        iVar11 = piVar2[1];
        *(double *)(*param_2 + iVar13 * 8) = dVar15;
        bVar1 = iVar8 < iVar11;
        iVar8 = iVar8 + 1;
      } while (bVar1);
    }
  }
  else {
    piVar2 = (int *)param_2[1];
    iVar6 = *piVar2;
    *piVar2 = 1;
    emxEnsureCapacity_real_T(param_2,piVar2[1] * iVar6);
    dVar14 = rtNaN;
    uVar3 = ((int *)param_2[1])[1];
    if (0 < (int)uVar3) {
      iVar6 = *(int *)param_2[1];
      uVar12 = 0;
      pdVar10 = (double *)*param_2;
      if ((uVar3 != 1) && (iVar6 == 1)) {
        if ((&rtNaN < pdVar10) || (pdVar10 + uVar3 < (double *)((int)&rtNaN + 1))) {
          uVar12 = uVar3 & 0xfffffffe;
          pdVar7 = pdVar10;
          uVar9 = uVar12;
          do {
            *pdVar7 = dVar14;
            pdVar7[1] = dVar14;
            pdVar7 = pdVar7 + 2;
            uVar9 = uVar9 - 2;
          } while (uVar9 != 0);
          if (uVar3 == uVar12) {
            return;
          }
        }
        else {
          uVar12 = 0;
        }
      }
      iVar8 = uVar3 - uVar12;
      pdVar10 = pdVar10 + uVar12 * iVar6;
      do {
        iVar8 = iVar8 + -1;
        *pdVar10 = rtNaN;
        pdVar10 = pdVar10 + iVar6;
      } while (iVar8 != 0);
    }
  }
  return;
}



double nanmean(int *param_1)

{
  int iVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  double dVar5;
  double dVar6;
  
  dVar6 = rtNaN;
  if ((*(int *)(param_1[1] + 4) != 0) && (0 < *(int *)(param_1[1] + 4))) {
    dVar5 = 0.0;
    iVar3 = 0;
    iVar2 = 0;
    iVar4 = 0;
    do {
      iVar1 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar3),
                      (int)((ulonglong)*(undefined8 *)(*param_1 + iVar3) >> 0x20));
      if (iVar1 == 0) {
        iVar4 = iVar4 + 1;
        dVar5 = dVar5 + *(double *)(*param_1 + iVar3);
      }
      iVar3 = iVar3 + 8;
      iVar2 = iVar2 + 1;
    } while (iVar2 < *(int *)(param_1[1] + 4));
    dVar6 = rtNaN;
    if (iVar4 != 0) {
      dVar6 = dVar5 / (double)(longlong)iVar4;
    }
  }
  return dVar6;
}



double nanstd(int *param_1)

{
  int iVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  double dVar6;
  double dVar7;
  double dVar8;
  
  iVar2 = *(int *)param_1[1];
  dVar7 = rtNaN;
  if ((iVar2 != 0) && (0 < iVar2)) {
    dVar6 = 0.0;
    iVar4 = 0;
    iVar5 = 0;
    iVar3 = iVar2;
    do {
      iVar1 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar4),
                      (int)((ulonglong)*(undefined8 *)(*param_1 + iVar4) >> 0x20));
      if (iVar1 == 0) {
        iVar5 = iVar5 + 1;
        dVar6 = dVar6 + *(double *)(*param_1 + iVar4);
      }
      iVar4 = iVar4 + 8;
      iVar3 = iVar3 + -1;
    } while (iVar3 != 0);
    dVar7 = rtNaN;
    if (iVar5 != 0) {
      if (iVar2 < 1) {
        dVar7 = 0.0;
      }
      else {
        iVar3 = 0;
        dVar7 = 0.0;
        do {
          iVar4 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar3),
                          (int)((ulonglong)*(undefined8 *)(*param_1 + iVar3) >> 0x20));
          if (iVar4 == 0) {
            dVar8 = *(double *)(*param_1 + iVar3) - dVar6 / (double)(longlong)iVar5;
            dVar7 = dVar7 + dVar8 * dVar8;
          }
          iVar3 = iVar3 + 8;
          iVar2 = iVar2 + -1;
        } while (iVar2 != 0);
      }
      iVar2 = iVar5 + -1;
      if (iVar5 + -1 == 0 || iVar5 < 1) {
        iVar2 = iVar5;
      }
      dVar7 = dVar7 / (double)(longlong)iVar2;
    }
  }
  return SQRT(dVar7);
}



double nansum(int *param_1)

{
  int iVar1;
  int iVar2;
  int iVar3;
  double dVar4;
  
  dVar4 = 0.0;
  if (0 < *(int *)param_1[1]) {
    iVar2 = 0;
    iVar3 = 0;
    do {
      iVar1 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar2),
                      (int)((ulonglong)*(undefined8 *)(*param_1 + iVar2) >> 0x20));
      if (iVar1 == 0) {
        dVar4 = dVar4 + *(double *)(*param_1 + iVar2);
      }
      iVar2 = iVar2 + 8;
      iVar3 = iVar3 + 1;
    } while (iVar3 < *(int *)param_1[1]);
  }
  return dVar4;
}



// WARNING: Restarted to delay deadcode elimination for space: register

void neg2nan(int *param_1)

{
  uint uVar1;
  int iVar2;
  double *pdVar3;
  undefined4 uVar4;
  int *piVar5;
  uint uVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  undefined8 uVar10;
  ulonglong in_d17;
  double dVar11;
  int *local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  uVar9 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if ((int)uVar9 < 1) {
    emxInit_int32_T1(&local_20,1);
    uVar4 = *(undefined4 *)local_20[1];
    *(undefined4 *)local_20[1] = 0;
    emxEnsureCapacity_int32_T1(local_20,uVar4);
    goto LAB_0001c63e;
  }
  uVar1 = 0;
  iVar7 = 0;
  if (uVar9 == 1) {
LAB_0001c5cc:
    pdVar3 = (double *)*param_1 + uVar1;
    iVar2 = uVar9 - uVar1;
    do {
      dVar11 = *pdVar3;
      pdVar3 = pdVar3 + 1;
      if (dVar11 <= 0.0) {
        iVar7 = iVar7 + 1;
      }
      iVar2 = iVar2 + -1;
    } while (iVar2 != 0);
  }
  else {
    uVar1 = uVar9 & 0xfffffffe;
    uVar10 = 0;
    uVar6 = uVar1;
    pdVar3 = (double *)*param_1;
    do {
      dVar11 = *pdVar3;
      pdVar3 = pdVar3 + 2;
      uVar8 = (uint)(dVar11 <= 0.0);
      if (uVar8 != 0) {
        uVar8 = 0xffffffff;
      }
      in_d17 = in_d17 & 0xffff0000ffff0000 | (ulonglong)uVar8 & 0xffff;
      uVar6 = uVar6 - 2;
      uVar10 = VectorSub(uVar10,in_d17,4);
    } while (uVar6 != 0);
    uVar4 = (undefined4)((ulonglong)uVar10 >> 0x20);
    uVar10 = VectorAdd(uVar10,CONCAT44(uVar4,uVar4),4);
    iVar7 = (int)uVar10;
    if (uVar9 - uVar1 != 0) goto LAB_0001c5cc;
  }
  emxInit_int32_T1(&local_20,1);
  iVar2 = *(int *)local_20[1];
  *(int *)local_20[1] = iVar7;
  emxEnsureCapacity_int32_T1(local_20,iVar2);
  if (0 < (int)uVar9) {
    iVar7 = 0;
    pdVar3 = (double *)*param_1;
    iVar2 = 0;
    do {
      dVar11 = *pdVar3;
      iVar7 = iVar7 + 1;
      pdVar3 = pdVar3 + 1;
      if (dVar11 <= 0.0) {
        *(int *)(*local_20 + iVar2 * 4) = iVar7;
        iVar2 = iVar2 + 1;
      }
    } while (uVar9 - iVar7 != 0);
  }
LAB_0001c63e:
  iVar7 = *(int *)local_20[1];
  if (0 < iVar7) {
    iVar2 = *param_1;
    piVar5 = (int *)*local_20;
    do {
      iVar7 = iVar7 + -1;
      *(undefined8 *)(iVar2 + *piVar5 * 8 + -8) = rtNaN;
      piVar5 = piVar5 + 1;
    } while (iVar7 != 0);
  }
  emxFree_int32_T(&local_20);
  if (__stack_chk_guard == local_1c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Restarted to delay deadcode elimination for space: register
// WARNING: Restarted to delay deadcode elimination for space: stack

void nullAssignment(int *param_1,int *param_2)

{
  undefined1 auVar1 [32];
  uint uVar2;
  undefined1 (*pauVar3) [16];
  undefined4 uVar4;
  undefined1 (*pauVar5) [16];
  undefined8 *puVar6;
  undefined1 (*pauVar7) [16];
  undefined8 *puVar8;
  byte *pbVar9;
  int iVar10;
  undefined1 (*pauVar11) [16];
  int iVar12;
  uint uVar13;
  undefined4 *puVar14;
  int iVar15;
  uint uVar16;
  int iVar17;
  int iVar18;
  bool bVar19;
  undefined8 uVar20;
  undefined1 auVar21 [16];
  undefined1 in_q9 [16];
  undefined1 auVar22 [16];
  undefined4 *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar2 = *(uint *)param_2[1];
  iVar17 = *(int *)param_1[1];
  if ((int)uVar2 < 1) {
    iVar12 = 0;
  }
  else {
    if (uVar2 < 4) {
      iVar12 = 0;
      iVar18 = 1;
    }
    else {
      uVar13 = uVar2 & 0xfffffffc;
      auVar21 = ZEXT816(0);
      iVar18 = uVar13 + 1;
      uVar16 = uVar13;
      puVar14 = (undefined4 *)*param_2;
      do {
        uVar20 = in_q9._0_8_;
        uVar16 = uVar16 - 4;
                    // WARNING: Ignoring partial resolution of indirect
        uVar4 = *puVar14;
        auVar22 = VectorCopyLong(uVar20,1,1);
        in_q9 = VectorCopyLong(auVar22._0_8_,2,1);
        auVar21 = VectorAdd(auVar21,in_q9,4);
        puVar14 = puVar14 + 1;
      } while (uVar16 != 0);
      auVar1._16_16_ = auVar21;
      auVar1._0_16_ = auVar21;
      auVar22 = VectorAdd(auVar21,auVar1._8_16_,4);
      uVar20 = CONCAT44(auVar22._4_4_,auVar22._4_4_);
      auVar21._8_8_ = uVar20;
      auVar21._0_8_ = uVar20;
      auVar21 = VectorAdd(auVar22,auVar21,4);
      iVar12 = auVar21._0_4_;
      if (uVar2 == uVar13) goto LAB_0001c724;
    }
    iVar15 = (uVar2 - iVar18) + 1;
    pbVar9 = (byte *)(*param_2 + iVar18 + -1);
    do {
      iVar15 = iVar15 + -1;
      iVar12 = iVar12 + (uint)*pbVar9;
      pbVar9 = pbVar9 + 1;
    } while (iVar15 != 0);
  }
LAB_0001c724:
  uVar16 = iVar17 - iVar12;
  if (0 < iVar17) {
    iVar18 = -1;
    iVar15 = 1;
    iVar12 = 0;
    do {
      iVar10 = iVar12 + 1;
      if ((int)uVar2 < iVar10) {
LAB_0001c738:
        iVar18 = iVar18 + 1;
        *(undefined8 *)(*param_1 + iVar18 * 8) = *(undefined8 *)(*param_1 + iVar12 * 8);
      }
      else if (*(char *)(*param_2 + iVar12) == '\0') {
        iVar12 = iVar15 + -1;
        goto LAB_0001c738;
      }
      iVar15 = iVar15 + 1;
      iVar12 = iVar10;
    } while (iVar17 != iVar10);
  }
  emxInit_real_T(&local_2c,1);
  uVar13 = uVar16 & ~((int)uVar16 >> 0x1f);
  uVar2 = *(uint *)local_2c[1];
  *(uint *)local_2c[1] = uVar13;
  emxEnsureCapacity_real_T1(local_2c,uVar2);
  if (0 < (int)uVar16) {
    pauVar3 = (undefined1 (*) [16])*param_1;
    pauVar11 = (undefined1 (*) [16])*local_2c;
    if (uVar13 < 2) {
LAB_0001c7ca:
      uVar2 = 0;
    }
    else {
      pauVar5 = (undefined1 (*) [16])(*pauVar3 + uVar13 * 8);
      bVar19 = pauVar11 < pauVar5;
      if (bVar19) {
        pauVar5 = (undefined1 (*) [16])(*pauVar11 + uVar13 * 8);
      }
      if (bVar19 && pauVar3 < pauVar5) goto LAB_0001c7ca;
      uVar2 = uVar13 & 0x7ffffffe;
      pauVar5 = pauVar3;
      pauVar7 = pauVar11;
      uVar16 = uVar2;
      do {
        auVar21 = *pauVar5;
        pauVar5 = pauVar5 + 1;
        uVar16 = uVar16 - 2;
        *(longlong *)*pauVar7 = auVar21._0_8_;
        *(longlong *)(*pauVar7 + 8) = auVar21._8_8_;
        pauVar7 = pauVar7 + 1;
      } while (uVar16 != 0);
      if (uVar13 == uVar2) goto LAB_0001c7ee;
    }
    puVar6 = (undefined8 *)(*pauVar3 + uVar2 * 8);
    puVar8 = (undefined8 *)(*pauVar11 + uVar2 * 8);
    iVar17 = uVar13 - uVar2;
    do {
      uVar20 = *puVar6;
      puVar6 = puVar6 + 1;
      iVar17 = iVar17 + -1;
      *puVar8 = uVar20;
      puVar8 = puVar8 + 1;
    } while (iVar17 != 0);
  }
LAB_0001c7ee:
  uVar4 = *(undefined4 *)param_1[1];
  *(undefined4 *)param_1[1] = *(undefined4 *)local_2c[1];
  emxEnsureCapacity_real_T1(param_1,uVar4);
  uVar2 = *(uint *)local_2c[1];
  if ((int)uVar2 < 1) goto LAB_0001c860;
  pauVar11 = (undefined1 (*) [16])*param_1;
  pauVar3 = (undefined1 (*) [16])*local_2c;
  if (uVar2 == 1) {
LAB_0001c842:
    uVar16 = 0;
  }
  else {
    pauVar5 = (undefined1 (*) [16])(*pauVar3 + uVar2 * 8);
    bVar19 = pauVar11 < pauVar5;
    if (bVar19) {
      pauVar5 = (undefined1 (*) [16])(*pauVar11 + uVar2 * 8);
    }
    if (bVar19 && pauVar3 < pauVar5) goto LAB_0001c842;
    uVar16 = uVar2 & 0xfffffffe;
    pauVar5 = pauVar11;
    pauVar7 = pauVar3;
    uVar13 = uVar16;
    do {
      auVar21 = *pauVar7;
      pauVar7 = pauVar7 + 1;
      uVar13 = uVar13 - 2;
      *(longlong *)*pauVar5 = auVar21._0_8_;
      *(longlong *)(*pauVar5 + 8) = auVar21._8_8_;
      pauVar5 = pauVar5 + 1;
    } while (uVar13 != 0);
    if (uVar2 == uVar16) goto LAB_0001c860;
  }
  puVar8 = (undefined8 *)(*pauVar3 + uVar16 * 8);
  puVar6 = (undefined8 *)(*pauVar11 + uVar16 * 8);
  iVar17 = uVar2 - uVar16;
  do {
    uVar20 = *puVar8;
    puVar8 = puVar8 + 1;
    iVar17 = iVar17 + -1;
    *puVar6 = uVar20;
    puVar6 = puVar6 + 1;
  } while (iVar17 != 0);
LAB_0001c860:
  emxFree_real_T(&local_2c);
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void NUM(int *param_1,int *param_2)

{
  undefined1 uVar1;
  byte *pbVar2;
  int iVar3;
  int *piVar4;
  int iVar5;
  int *piVar6;
  byte *pbVar7;
  int iVar8;
  int iVar9;
  double *pdVar10;
  int iVar11;
  int iVar12;
  bool bVar13;
  double dVar14;
  int *local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  emxInit_boolean_T1(&local_38,2);
  piVar6 = (int *)param_1[1];
  piVar4 = (int *)local_38[1];
  iVar3 = *piVar4;
  iVar8 = piVar4[1];
  *piVar4 = *piVar6;
  piVar4[1] = piVar6[1];
  emxEnsureCapacity_boolean_T1(local_38,iVar8 * iVar3);
  iVar3 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if (0 < iVar3) {
    iVar9 = 0;
    iVar8 = 0;
    do {
      uVar1 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar9),
                      (int)((ulonglong)*(undefined8 *)(*param_1 + iVar9) >> 0x20));
      iVar9 = iVar9 + 8;
      *(undefined1 *)(*local_38 + iVar8) = uVar1;
      iVar8 = iVar8 + 1;
    } while (iVar3 - iVar8 != 0);
  }
  emxEnsureCapacity_boolean_T1(local_38,*(int *)local_38[1] * ((int *)local_38[1])[1]);
  piVar4 = (int *)local_38[1];
  iVar8 = *piVar4;
  iVar3 = iVar8 * piVar4[1];
  if (0 < iVar3) {
    *(char *)*local_38 = *(char *)*local_38 == '\0';
    if (iVar3 != 1) {
      iVar8 = 1;
      do {
        *(bool *)(*local_38 + iVar8) = *(char *)(*local_38 + iVar8) == '\0';
        iVar8 = iVar8 + 1;
      } while (iVar3 - iVar8 != 0);
    }
    piVar4 = (int *)local_38[1];
    iVar8 = *piVar4;
  }
  iVar3 = piVar4[1];
  if (iVar8 != 0) {
    if (iVar3 != 0) {
      piVar6 = (int *)param_2[1];
      iVar3 = *piVar6;
      iVar8 = piVar6[1];
      *piVar6 = 1;
      piVar6[1] = piVar4[1];
      emxEnsureCapacity_real_T(param_2,iVar8 * iVar3);
      iVar3 = ((int *)local_38[1])[1];
      if (0 < iVar3) {
        iVar12 = *local_38;
        iVar5 = *(int *)local_38[1];
        iVar11 = *param_2;
        pbVar2 = (byte *)(iVar12 + 1);
        iVar8 = 0;
        iVar9 = 1;
        do {
          pdVar10 = (double *)(iVar11 + iVar8 * 8);
          dVar14 = (double)*(byte *)(iVar12 + iVar5 * iVar8);
          *pdVar10 = dVar14;
          iVar8 = iVar5 + -1;
          pbVar7 = pbVar2;
          if (1 < iVar5) {
            do {
              iVar8 = iVar8 + -1;
              dVar14 = dVar14 + (double)*pbVar7;
              *pdVar10 = dVar14;
              pbVar7 = pbVar7 + 1;
            } while (iVar8 != 0);
          }
          pbVar2 = pbVar2 + iVar5;
          bVar13 = iVar9 != iVar3;
          iVar8 = iVar9;
          iVar9 = iVar9 + 1;
        } while (bVar13);
      }
      goto LAB_0001c9f6;
    }
    iVar3 = 0;
  }
  piVar4 = (int *)param_2[1];
  iVar8 = *piVar4;
  iVar9 = piVar4[1];
  *piVar4 = 1;
  piVar4[1] = iVar3;
  emxEnsureCapacity_real_T(param_2,iVar9 * iVar8);
  if (0 < iVar3) {
    FUN_00022030(*param_2,iVar3 << 3);
  }
LAB_0001c9f6:
  emxFree_boolean_T(&local_38);
  piVar4 = (int *)param_2[1];
  iVar3 = piVar4[1];
  if (iVar3 == 0) {
    dVar14 = 0.0;
  }
  else {
    pdVar10 = (double *)*param_2;
    dVar14 = *pdVar10;
    if (1 < iVar3) {
      iVar8 = iVar3 + -1;
      do {
        pdVar10 = pdVar10 + 1;
        iVar8 = iVar8 + -1;
        dVar14 = dVar14 + *pdVar10;
      } while (iVar8 != 0);
    }
  }
  piVar4[1] = iVar3 + 1;
  emxEnsureCapacity_real_T(param_2,iVar3 * *piVar4);
  *(double *)(*param_2 + iVar3 * 8) = dVar14;
  if (__stack_chk_guard == local_34) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Heritage AFTER dead removal. Example location: r0x00024b60 : 0x0001ce3c
// WARNING: Restarted to delay deadcode elimination for space: ram
// WARNING: Restarted to delay deadcode elimination for space: register
// WARNING: Restarted to delay deadcode elimination for space: stack

void Pentagon(undefined4 param_1,int *param_2,int *param_3,int *param_4)

{
  undefined1 auVar1 [16];
  undefined1 auVar2 [16];
  undefined1 auVar3 [32];
  undefined8 *puVar4;
  double *pdVar5;
  double *pdVar6;
  char cVar7;
  undefined1 auVar8 [16];
  byte bVar9;
  undefined1 uVar10;
  undefined8 *puVar11;
  int iVar12;
  undefined1 (*pauVar13) [16];
  undefined8 *puVar14;
  int iVar15;
  int iVar16;
  int iVar17;
  int *piVar18;
  uint uVar19;
  int iVar20;
  int iVar21;
  double *pdVar22;
  char *pcVar23;
  int *piVar24;
  double *pdVar25;
  int iVar26;
  int iVar27;
  uint uVar28;
  uint uVar29;
  uint uVar30;
  int iVar31;
  int iVar32;
  double *pdVar33;
  int iVar34;
  uint uVar35;
  undefined4 *puVar36;
  undefined1 (*pauVar37) [16];
  int iVar38;
  undefined1 (*pauVar39) [16];
  undefined1 (*pauVar40) [16];
  bool bVar41;
  uint in_fpscr;
  undefined1 in_q8 [16];
  undefined1 auVar42 [16];
  undefined1 auVar43 [16];
  double dVar44;
  undefined1 in_q9 [16];
  undefined1 auVar45 [16];
  undefined4 uVar46;
  ulonglong uVar47;
  undefined1 in_q10 [16];
  undefined1 auVar48 [16];
  int *local_68;
  int *local_64;
  int *local_60;
  int *local_5c;
  int *local_58;
  int *local_54;
  int *local_50;
  int *local_4c;
  int *local_48;
  int *local_44;
  int *local_40;
  int *local_3c;
  int *local_38;
  int *local_34;
  int *local_30;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  emxInit_boolean_T1(&local_2c,2);
  iVar32 = param_2[1];
  piVar18 = (int *)local_2c[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar32 + 4);
  emxEnsureCapacity_boolean_T1(local_2c,iVar21 * iVar12);
  iVar12 = ((int *)param_2[1])[1] * *(int *)param_2[1];
  if (0 < iVar12) {
    iVar32 = 0;
    iVar21 = 0;
    do {
      in_q8._0_8_ = *(double *)(*param_2 + iVar32);
      uVar10 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
      iVar32 = iVar32 + 8;
      *(undefined1 *)(*local_2c + iVar21) = uVar10;
      iVar21 = iVar21 + 1;
    } while (iVar12 - iVar21 != 0);
  }
  emxInit_real_T1(&local_30,2);
  iVar32 = param_2[1];
  piVar18 = (int *)local_30[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar32 + 4);
  emxEnsureCapacity_real_T(local_30,iVar21 * iVar12);
  piVar18 = (int *)param_2[1];
  iVar12 = piVar18[1] * *piVar18;
  if (0 < iVar12) {
    in_q8._0_8_ = 18.0;
    pdVar22 = (double *)*param_2;
    pdVar33 = (double *)*local_30;
    do {
      in_q8._8_8_ = *pdVar22;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = in_q8._8_8_ * in_q8._0_8_;
      *pdVar33 = in_q8._8_8_;
      pdVar33 = pdVar33 + 1;
    } while (iVar12 != 0);
  }
  iVar12 = local_30[1];
  uVar28 = *(uint *)(iVar12 + 4);
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar12 + 4);
  emxEnsureCapacity_real_T(param_2);
  if (0 < (int)uVar28) {
    pauVar40 = (undefined1 (*) [16])*param_2;
    pauVar39 = (undefined1 (*) [16])*local_30;
    if (uVar28 == 1) {
      uVar19 = 0;
    }
    else {
      pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      uVar19 = 0;
      bVar41 = pauVar40 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar28 * 8);
      }
      if (!bVar41 || pauVar37 <= pauVar39) {
        uVar19 = uVar28 & 0xfffffffe;
        in_q9._8_8_ = 0x4056800000000000;
        in_q9._0_8_ = 90.0;
        in_q8._0_8_ = 90.0;
        pauVar37 = pauVar39;
        pauVar13 = pauVar40;
        uVar29 = uVar19;
        do {
          auVar43 = *pauVar37;
          pauVar37 = pauVar37 + 1;
          dVar44 = auVar43._0_8_;
          uVar30 = (uint)(dVar44 != 90.0 && dVar44 < 90.0 == NAN(dVar44));
          dVar44 = auVar43._8_8_;
          uVar35 = in_fpscr & 0xfffffff | (uint)(dVar44 < 90.0) << 0x1f |
                   (uint)(dVar44 == 90.0) << 0x1e;
          in_fpscr = uVar35 | (uint)NAN(dVar44) << 0x1c;
          bVar9 = (byte)(uVar35 >> 0x18);
          uVar35 = (uint)(!(bool)(bVar9 >> 6 & 1) && bVar9 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1));
          if (uVar35 != 0) {
            uVar35 = 0xffffffff;
          }
          auVar1._12_4_ = uVar35;
          auVar1._8_4_ = uVar35;
          if (uVar30 != 0) {
            uVar30 = 0xffffffff;
          }
          auVar1._4_4_ = uVar30;
          auVar1._0_4_ = uVar30;
          in_q10 = VectorBitwiseInsertIfFalse(auVar43,in_q9,auVar1);
          uVar29 = uVar29 - 2;
          *(longlong *)*pauVar13 = in_q10._0_8_;
          *(longlong *)(*pauVar13 + 8) = in_q10._8_8_;
          pauVar13 = pauVar13 + 1;
        } while (uVar29 != 0);
        if (uVar28 == uVar19) goto LAB_0001cc04;
      }
    }
    pdVar22 = (double *)(*pauVar40 + uVar19 * 8);
    pdVar33 = (double *)(*pauVar39 + uVar19 * 8);
    iVar12 = uVar28 - uVar19;
    in_q8._0_8_ = 90.0;
    do {
      in_q8._8_8_ = *pdVar33;
      pdVar33 = pdVar33 + 1;
      uVar28 = in_fpscr & 0xfffffff | (uint)(in_q8._8_8_ < in_q8._0_8_) << 0x1f |
               (uint)(in_q8._8_8_ == in_q8._0_8_) << 0x1e;
      in_fpscr = uVar28 | (uint)(NAN(in_q8._8_8_) || NAN(in_q8._0_8_)) << 0x1c;
      bVar9 = (byte)(uVar28 >> 0x18);
      dVar44 = in_q8._0_8_;
      if (!(bool)(bVar9 >> 6 & 1) && bVar9 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
        dVar44 = in_q8._8_8_;
      }
      in_q9._0_8_ = dVar44;
      *pdVar22 = dVar44;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
    } while (iVar12 != 0);
  }
LAB_0001cc04:
  piVar18 = (int *)local_2c[1];
  iVar12 = piVar18[1];
  if (0 < iVar12) {
    iVar32 = 0;
    pcVar23 = (char *)*local_2c;
    iVar21 = iVar12;
    do {
      cVar7 = *pcVar23;
      pcVar23 = pcVar23 + 1;
      if (cVar7 != '\0') {
        in_q8._0_8_ = (double)rtNaN;
        *(undefined8 *)(*param_2 + iVar32) = rtNaN;
      }
      iVar32 = iVar32 + 8;
      iVar21 = iVar21 + -1;
    } while (iVar21 != 0);
  }
  iVar21 = *piVar18;
  iVar32 = param_3[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar32 + 4);
  emxEnsureCapacity_boolean_T1(local_2c,iVar21 * iVar12);
  piVar18 = (int *)param_3[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  if (0 < iVar21 * iVar12) {
    iVar34 = 0;
    iVar32 = 0;
    do {
      in_q8._0_8_ = *(double *)(*param_3 + iVar34);
      uVar10 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
      iVar34 = iVar34 + 8;
      *(undefined1 *)(*local_2c + iVar32) = uVar10;
      iVar32 = iVar32 + 1;
    } while (iVar21 * iVar12 - iVar32 != 0);
    piVar18 = (int *)param_3[1];
  }
  piVar24 = (int *)local_30[1];
  iVar12 = *piVar24;
  iVar21 = piVar24[1];
  *piVar24 = 1;
  piVar24[1] = piVar18[1];
  emxEnsureCapacity_real_T(local_30,iVar21 * iVar12);
  piVar18 = (int *)param_3[1];
  uVar19 = piVar18[1];
  uVar28 = uVar19 * *piVar18;
  if (0 < (int)uVar28) {
    pauVar40 = (undefined1 (*) [16])*param_3;
    pauVar39 = (undefined1 (*) [16])*local_30;
    if (uVar28 == 1) {
LAB_0001ccee:
      uVar29 = 0;
    }
    else {
      pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar28 * 8);
      bVar41 = pauVar39 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      }
      if (bVar41 && pauVar40 < pauVar37) goto LAB_0001ccee;
      uVar29 = uVar28 & 0xfffffffe;
      pauVar37 = pauVar40;
      pauVar13 = pauVar39;
      uVar35 = uVar29;
      do {
        in_q8 = *pauVar37;
        pauVar37 = pauVar37 + 1;
        uVar35 = uVar35 - 2;
        *(longlong *)*pauVar13 = in_q8._0_8_;
        *(longlong *)(*pauVar13 + 8) = in_q8._8_8_;
        pauVar13 = pauVar13 + 1;
      } while (uVar35 != 0);
      if (uVar28 - uVar29 == 0) goto LAB_0001cd0c;
    }
    puVar11 = (undefined8 *)(*pauVar40 + uVar29 * 8);
    puVar14 = (undefined8 *)(*pauVar39 + uVar29 * 8);
    iVar12 = uVar28 - uVar29;
    do {
      in_q8._0_8_ = (double)*puVar11;
      puVar11 = puVar11 + 1;
      iVar12 = iVar12 + -1;
      *puVar14 = in_q8._0_8_;
      puVar14 = puVar14 + 1;
    } while (iVar12 != 0);
  }
LAB_0001cd0c:
  *piVar18 = 1;
  emxEnsureCapacity_real_T(param_3);
  if (0 < (int)uVar19) {
    pauVar40 = (undefined1 (*) [16])*param_3;
    pauVar39 = (undefined1 (*) [16])*local_30;
    if (uVar19 == 1) {
      uVar28 = 0;
    }
    else {
      pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar19 * 8);
      uVar28 = 0;
      bVar41 = pauVar40 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar19 * 8);
      }
      if (!bVar41 || pauVar37 <= pauVar39) {
        in_q8._0_8_ = 17.0;
        uVar28 = uVar19 & 0xfffffffe;
        in_q9._8_8_ = 0x4031000000000000;
        in_q9._0_8_ = 17.0;
        pauVar37 = pauVar39;
        pauVar13 = pauVar40;
        uVar29 = uVar28;
        do {
          auVar43 = *pauVar37;
          pauVar37 = pauVar37 + 1;
          dVar44 = auVar43._0_8_;
          uVar30 = (uint)(dVar44 != 17.0 && dVar44 < 17.0 == NAN(dVar44));
          dVar44 = auVar43._8_8_;
          uVar35 = in_fpscr & 0xfffffff | (uint)(dVar44 < 17.0) << 0x1f |
                   (uint)(dVar44 == 17.0) << 0x1e;
          in_fpscr = uVar35 | (uint)NAN(dVar44) << 0x1c;
          bVar9 = (byte)(uVar35 >> 0x18);
          uVar35 = (uint)(!(bool)(bVar9 >> 6 & 1) && bVar9 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1));
          if (uVar35 != 0) {
            uVar35 = 0xffffffff;
          }
          auVar48._12_4_ = uVar35;
          auVar48._8_4_ = uVar35;
          if (uVar30 != 0) {
            uVar30 = 0xffffffff;
          }
          auVar48._4_4_ = uVar30;
          auVar48._0_4_ = uVar30;
          in_q10 = VectorBitwiseInsertIfFalse(auVar43,in_q9,auVar48);
          uVar29 = uVar29 - 2;
          *(longlong *)*pauVar13 = in_q10._0_8_;
          *(longlong *)(*pauVar13 + 8) = in_q10._8_8_;
          pauVar13 = pauVar13 + 1;
        } while (uVar29 != 0);
        if (uVar19 == uVar28) goto LAB_0001ce1e;
      }
    }
    in_q8._0_8_ = 17.0;
    pdVar22 = (double *)(*pauVar40 + uVar28 * 8);
    pdVar33 = (double *)(*pauVar39 + uVar28 * 8);
    iVar12 = uVar19 - uVar28;
    do {
      in_q8._8_8_ = *pdVar33;
      pdVar33 = pdVar33 + 1;
      uVar28 = in_fpscr & 0xfffffff | (uint)(in_q8._8_8_ < in_q8._0_8_) << 0x1f |
               (uint)(in_q8._8_8_ == in_q8._0_8_) << 0x1e;
      in_fpscr = uVar28 | (uint)(NAN(in_q8._8_8_) || NAN(in_q8._0_8_)) << 0x1c;
      bVar9 = (byte)(uVar28 >> 0x18);
      dVar44 = in_q8._0_8_;
      if (!(bool)(bVar9 >> 6 & 1) && bVar9 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
        dVar44 = in_q8._8_8_;
      }
      in_q9._0_8_ = dVar44;
      *pdVar22 = dVar44;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
    } while (iVar12 != 0);
  }
LAB_0001ce1e:
  iVar12 = *(int *)(local_2c[1] + 4);
  if (0 < iVar12) {
    iVar21 = 0;
    pcVar23 = (char *)*local_2c;
    do {
      cVar7 = *pcVar23;
      pcVar23 = pcVar23 + 1;
      if (cVar7 != '\0') {
        in_q8._0_8_ = (double)rtNaN;
        *(undefined8 *)(*param_3 + iVar21) = rtNaN;
      }
      iVar21 = iVar21 + 8;
      iVar12 = iVar12 + -1;
    } while (iVar12 != 0);
  }
  emxFree_boolean_T(&local_2c);
  emxInit_real_T1(&local_34,2);
  b_PT(param_1,local_34);
  piVar18 = (int *)local_34[1];
  iVar12 = *piVar18;
  *piVar18 = 4;
  emxEnsureCapacity_real_T(local_34,piVar18[1] * iVar12);
  iVar12 = *(int *)local_34[1] * ((int *)local_34[1])[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_34;
    in_q8._8_8_ = 1440.0;
    in_q8._0_8_ = 100.0;
    do {
      iVar12 = iVar12 + -1;
      in_q9._0_8_ = (*pdVar22 / 100.0) * 1440.0;
      *pdVar22 = in_q9._0_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  emxInit_real_T1(&local_38,2);
  piVar18 = (int *)local_38[1];
  iVar21 = *(int *)(local_34[1] + 4);
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 2;
  piVar18[1] = iVar21;
  emxEnsureCapacity_real_T(local_38,iVar32 * iVar12);
  if (0 < iVar21) {
    iVar32 = *(int *)local_34[1];
    puVar11 = (undefined8 *)(*local_34 + 8);
    iVar12 = *(int *)local_38[1];
    puVar14 = (undefined8 *)(*local_38 + 8);
    do {
      iVar21 = iVar21 + -1;
      puVar14[-1] = *puVar11;
      in_q8._0_8_ = (double)puVar11[1];
      puVar11 = puVar11 + iVar32;
      *puVar14 = in_q8._0_8_;
      puVar14 = puVar14 + iVar12;
    } while (iVar21 != 0);
  }
  emxInit_real_T1(&local_3c,2);
  d_sum(local_38,local_3c);
  piVar18 = (int *)local_3c[1];
  iVar12 = *piVar18;
  *piVar18 = 1;
  emxEnsureCapacity_real_T(local_3c,piVar18[1] * iVar12);
  iVar12 = *(int *)local_3c[1] * ((int *)local_3c[1])[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_3c;
    in_q8._0_8_ = 1440.0;
    do {
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = in_q8._0_8_ - *pdVar22;
      *pdVar22 = in_q8._8_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  emxInit_real_T1(&local_40,2);
  emxInit_real_T1(&local_44,2);
  b_AAC(param_1,local_30);
  b_AUC(param_1,local_40);
  piVar18 = (int *)local_44[1];
  iVar21 = local_30[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_44,iVar32 * iVar12);
  iVar12 = *(int *)local_30[1] * ((int *)local_30[1])[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_30;
    pdVar33 = (double *)*local_44;
    in_q8._8_8_ = 1440.0;
    in_q8._0_8_ = 18.0;
    do {
      dVar44 = *pdVar22;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
      in_q9._0_8_ = dVar44 * 18.0 * 1440.0;
      *pdVar33 = in_q9._0_8_;
      pdVar33 = pdVar33 + 1;
    } while (iVar12 != 0);
  }
  emxInit_real_T1(&local_48,2);
  power(local_44,local_48);
  piVar18 = (int *)local_44[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  uVar28 = *(uint *)(local_34[1] + 4);
  *piVar18 = 1;
  piVar18[1] = uVar28;
  emxEnsureCapacity_real_T(local_44,iVar21 * iVar12);
  if (0 < (int)uVar28) {
    uVar19 = 0;
    pauVar39 = (undefined1 (*) [16])*local_44;
    pauVar40 = (undefined1 (*) [16])*local_34;
    iVar21 = *(int *)local_44[1];
    iVar12 = *(int *)local_34[1];
    if ((uVar28 != 1) && (iVar21 == 1 && iVar12 == 1)) {
      pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar28 * 8);
      bVar41 = pauVar39 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      }
      if (bVar41 && pauVar40 < pauVar37) {
        uVar19 = 0;
      }
      else {
        uVar19 = uVar28 & 0xfffffffe;
        pauVar37 = pauVar40;
        pauVar13 = pauVar39;
        uVar29 = uVar19;
        do {
          in_q8 = *pauVar37;
          pauVar37 = pauVar37 + iVar12;
          uVar29 = uVar29 - 2;
          *(longlong *)*pauVar13 = in_q8._0_8_;
          *(longlong *)(*pauVar13 + 8) = in_q8._8_8_;
          pauVar13 = pauVar13 + iVar21;
        } while (uVar29 != 0);
        if (uVar28 == uVar19) goto LAB_0001d03a;
      }
    }
    iVar32 = uVar28 - uVar19;
    puVar14 = (undefined8 *)(*pauVar40 + uVar19 * iVar12 * 8);
    puVar11 = (undefined8 *)(*pauVar39 + uVar19 * iVar21 * 8);
    do {
      in_q8._0_8_ = (double)*puVar14;
      puVar14 = puVar14 + iVar12;
      iVar32 = iVar32 + -1;
      *puVar11 = in_q8._0_8_;
      puVar11 = puVar11 + iVar21;
    } while (iVar32 != 0);
  }
LAB_0001d03a:
  emxInit_real_T1(&local_4c,2);
  power(local_44,local_4c);
  piVar18 = (int *)local_48[1];
  iVar12 = *piVar18;
  *piVar18 = 1;
  emxEnsureCapacity_real_T(local_48,piVar18[1] * iVar12);
  iVar12 = *(int *)local_48[1] * ((int *)local_48[1])[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_48;
    pdVar33 = (double *)*local_4c;
    do {
      in_q8._8_8_ = *pdVar33;
      pdVar33 = pdVar33 + 1;
      iVar12 = iVar12 + -1;
      in_q8._0_8_ = in_q8._8_8_ + *pdVar22;
      *pdVar22 = in_q8._0_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  b_sqrt();
  piVar18 = (int *)local_44[1];
  iVar21 = local_40[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_44,iVar32 * iVar12);
  iVar12 = *(int *)local_40[1] * ((int *)local_40[1])[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_40;
    pdVar33 = (double *)*local_44;
    in_q8._8_8_ = 1440.0;
    in_q8._0_8_ = 18.0;
    do {
      dVar44 = *pdVar22;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
      in_q9._0_8_ = dVar44 * 18.0 * 1440.0;
      *pdVar33 = in_q9._0_8_;
      pdVar33 = pdVar33 + 1;
    } while (iVar12 != 0);
  }
  emxInit_real_T1(&local_50,2);
  power(local_44,local_50);
  piVar18 = (int *)local_38[1];
  iVar21 = *(int *)(local_34[1] + 4);
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 2;
  piVar18[1] = iVar21;
  emxEnsureCapacity_real_T(local_38,iVar32 * iVar12);
  if (0 < iVar21) {
    iVar32 = *(int *)local_38[1];
    iVar12 = *(int *)local_34[1];
    puVar11 = (undefined8 *)(*local_34 + 0x10);
    puVar14 = (undefined8 *)(*local_38 + 8);
    do {
      iVar21 = iVar21 + -1;
      puVar14[-1] = *puVar11;
      in_q8._0_8_ = (double)puVar11[1];
      puVar11 = puVar11 + iVar12;
      *puVar14 = in_q8._0_8_;
      puVar14 = puVar14 + iVar32;
    } while (iVar21 != 0);
  }
  d_sum(local_38,local_4c);
  power(local_4c,local_30);
  piVar18 = (int *)local_50[1];
  iVar12 = *piVar18;
  *piVar18 = 1;
  emxEnsureCapacity_real_T(local_50,piVar18[1] * iVar12);
  iVar21 = *(int *)local_50[1];
  iVar12 = ((int *)local_50[1])[1];
  emxFree_real_T(&local_38);
  iVar12 = iVar12 * iVar21;
  if (0 < iVar12) {
    pdVar33 = (double *)*local_30;
    pdVar22 = (double *)*local_50;
    do {
      in_q8._8_8_ = *pdVar33;
      pdVar33 = pdVar33 + 1;
      iVar12 = iVar12 + -1;
      in_q8._0_8_ = in_q8._8_8_ + *pdVar22;
      *pdVar22 = in_q8._0_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  b_sqrt(local_50);
  piVar18 = (int *)local_44[1];
  iVar21 = local_3c[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_44,iVar32 * iVar12);
  iVar12 = ((int *)local_3c[1])[1] * *(int *)local_3c[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_3c;
    in_q8._0_8_ = 0.00614;
    pdVar33 = (double *)*local_44;
    do {
      in_q8._8_8_ = *pdVar22;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = in_q8._8_8_ * in_q8._0_8_;
      *pdVar33 = in_q8._8_8_;
      pdVar33 = pdVar33 + 1;
    } while (iVar12 != 0);
  }
  d_power(local_44,local_30);
  piVar18 = (int *)local_30[1];
  iVar12 = *piVar18;
  *piVar18 = 1;
  emxEnsureCapacity_real_T(local_30,piVar18[1] * iVar12);
  iVar12 = *(int *)local_30[1] * ((int *)local_30[1])[1];
  if (0 < iVar12) {
    in_q8._0_8_ = 14.0;
    pdVar22 = (double *)*local_30;
    do {
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = *pdVar22 + in_q8._0_8_;
      *pdVar22 = in_q8._8_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  piVar18 = (int *)local_44[1];
  iVar21 = local_50[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_44,iVar32 * iVar12);
  iVar12 = ((int *)local_50[1])[1] * *(int *)local_50[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_50;
    in_q8._0_8_ = 0.000115;
    pdVar33 = (double *)*local_44;
    do {
      in_q8._8_8_ = *pdVar22;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = in_q8._8_8_ * in_q8._0_8_;
      *pdVar33 = in_q8._8_8_;
      pdVar33 = pdVar33 + 1;
    } while (iVar12 != 0);
  }
  e_power(local_44,local_40);
  piVar18 = (int *)local_40[1];
  iVar12 = *piVar18;
  *piVar18 = 1;
  emxEnsureCapacity_real_T(local_40,piVar18[1] * iVar12);
  iVar12 = *(int *)local_40[1] * ((int *)local_40[1])[1];
  if (0 < iVar12) {
    in_q8._0_8_ = 14.0;
    pdVar22 = (double *)*local_40;
    do {
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = *pdVar22 + in_q8._0_8_;
      *pdVar22 = in_q8._8_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  iVar32 = param_2[1];
  piVar18 = (int *)local_44[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar32 + 4);
  emxEnsureCapacity_real_T(local_44,iVar21 * iVar12);
  iVar12 = *(int *)param_2[1] * ((int *)param_2[1])[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*param_2;
    pdVar33 = (double *)*local_44;
    in_q8._8_8_ = 0.0217;
    in_q8._0_8_ = -90.0;
    do {
      dVar44 = *pdVar22;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
      in_q9._0_8_ = (dVar44 + -90.0) * 0.0217;
      *pdVar33 = in_q9._0_8_;
      pdVar33 = pdVar33 + 1;
    } while (iVar12 != 0);
  }
  emxInit_real_T1(&local_54,2);
  f_power(local_44,local_54);
  piVar18 = (int *)local_54[1];
  iVar12 = *piVar18;
  *piVar18 = 1;
  emxEnsureCapacity_real_T(local_54,piVar18[1] * iVar12);
  iVar12 = *(int *)local_54[1] * ((int *)local_54[1])[1];
  if (0 < iVar12) {
    in_q8._0_8_ = 14.0;
    pdVar22 = (double *)*local_54;
    do {
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = *pdVar22 + in_q8._0_8_;
      *pdVar22 = in_q8._8_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  piVar18 = (int *)local_4c[1];
  iVar21 = local_48[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_4c,iVar32 * iVar12);
  iVar12 = *(int *)local_48[1] * ((int *)local_48[1])[1];
  if (0 < iVar12) {
    pdVar22 = (double *)*local_48;
    in_q8._0_8_ = 0.00057;
    pdVar33 = (double *)*local_4c;
    do {
      in_q8._8_8_ = *pdVar22;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = in_q8._8_8_ * in_q8._0_8_;
      *pdVar33 = in_q8._8_8_;
      pdVar33 = pdVar33 + 1;
    } while (iVar12 != 0);
  }
  emxInit_real_T1(&local_58,2);
  b_exp(local_4c);
  piVar18 = (int *)local_58[1];
  iVar21 = local_30[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 5;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_58,iVar32 * iVar12);
  uVar28 = ((int *)local_30[1])[1];
  if (0 < (int)uVar28) {
    uVar19 = 0;
    iVar12 = *(int *)local_30[1];
    pauVar39 = (undefined1 (*) [16])*local_58;
    pauVar40 = (undefined1 (*) [16])*local_30;
    iVar21 = *(int *)local_58[1];
    if ((uVar28 != 1) && (iVar21 == 1 && iVar12 == 1)) {
      pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar28 * 8);
      bVar41 = pauVar39 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      }
      if (bVar41 && pauVar40 < pauVar37) {
        uVar19 = 0;
      }
      else {
        uVar19 = uVar28 & 0xfffffffe;
        pauVar37 = pauVar39;
        pauVar13 = pauVar40;
        uVar29 = uVar19;
        do {
          in_q8 = *pauVar13;
          pauVar13 = pauVar13 + iVar12;
          uVar29 = uVar29 - 2;
          *(longlong *)*pauVar37 = in_q8._0_8_;
          *(longlong *)(*pauVar37 + 8) = in_q8._8_8_;
          pauVar37 = pauVar37 + iVar21;
        } while (uVar29 != 0);
        if (uVar28 == uVar19) goto LAB_0001d450;
      }
    }
    iVar32 = uVar28 - uVar19;
    puVar14 = (undefined8 *)(*pauVar40 + uVar19 * iVar12 * 8);
    puVar11 = (undefined8 *)(*pauVar39 + uVar19 * iVar21 * 8);
    do {
      in_q8._0_8_ = (double)*puVar14;
      puVar14 = puVar14 + iVar12;
      iVar32 = iVar32 + -1;
      *puVar11 = in_q8._0_8_;
      puVar11 = puVar11 + iVar21;
    } while (iVar32 != 0);
  }
LAB_0001d450:
  iVar12 = ((int *)param_3[1])[1];
  if (0 < iVar12) {
    iVar32 = *(int *)param_3[1];
    iVar21 = *(int *)local_58[1];
    in_q8._8_8_ = 14.0;
    in_q8._0_8_ = -17.0;
    pdVar22 = (double *)*param_3;
    pdVar33 = (double *)(*local_58 + 8);
    auVar43._8_8_ = (double)in_q9._8_8_;
    auVar43._0_8_ = 0.92;
    do {
      dVar44 = *pdVar22;
      pdVar22 = pdVar22 + iVar32;
      iVar12 = iVar12 + -1;
      auVar43._8_8_ = dVar44 + -17.0;
      in_q10._0_8_ = auVar43._8_8_ * auVar43._0_8_ + 14.0;
      *pdVar33 = in_q10._0_8_;
      pdVar33 = pdVar33 + iVar21;
    } while (iVar12 != 0);
  }
  iVar12 = ((int *)local_4c[1])[1];
  if (0 < iVar12) {
    in_q8._0_8_ = 13.0;
    iVar21 = *(int *)local_4c[1];
    iVar32 = *(int *)local_58[1];
    pdVar22 = (double *)*local_4c;
    pdVar33 = (double *)(*local_58 + 0x10);
    do {
      in_q8._8_8_ = *pdVar22;
      pdVar22 = pdVar22 + iVar21;
      iVar12 = iVar12 + -1;
      in_q8._8_8_ = in_q8._8_8_ + in_q8._0_8_;
      *pdVar33 = in_q8._8_8_;
      pdVar33 = pdVar33 + iVar32;
    } while (iVar12 != 0);
  }
  emxFree_real_T(&local_4c);
  uVar28 = ((int *)local_40[1])[1];
  if (0 < (int)uVar28) {
    pauVar39 = (undefined1 (*) [16])*local_40;
    uVar19 = 0;
    iVar32 = *local_58;
    iVar12 = *(int *)local_40[1];
    iVar21 = *(int *)local_58[1];
    if ((uVar28 != 1) && (iVar21 == 1 && iVar12 == 1)) {
      pauVar40 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      pauVar37 = (undefined1 (*) [16])(iVar32 + 0x18);
      bVar41 = pauVar37 < pauVar40;
      if (bVar41) {
        pauVar40 = (undefined1 (*) [16])(iVar32 + uVar28 * 8 + 0x18);
      }
      if (bVar41 && pauVar39 < pauVar40) {
        uVar19 = 0;
      }
      else {
        uVar19 = uVar28 & 0xfffffffe;
        pauVar40 = pauVar39;
        uVar29 = uVar19;
        do {
          in_q8 = *pauVar40;
          pauVar40 = pauVar40 + iVar12;
          uVar29 = uVar29 - 2;
          *(longlong *)*pauVar37 = in_q8._0_8_;
          *(longlong *)(*pauVar37 + 8) = in_q8._8_8_;
          pauVar37 = pauVar37 + iVar21;
        } while (uVar29 != 0);
        if (uVar28 == uVar19) goto LAB_0001d532;
      }
    }
    iVar34 = uVar28 - uVar19;
    puVar14 = (undefined8 *)(*pauVar39 + uVar19 * iVar12 * 8);
    puVar11 = (undefined8 *)(iVar32 + uVar19 * iVar21 * 8 + 0x18);
    do {
      in_q8._0_8_ = (double)*puVar14;
      puVar14 = puVar14 + iVar12;
      iVar34 = iVar34 + -1;
      *puVar11 = in_q8._0_8_;
      puVar11 = puVar11 + iVar21;
    } while (iVar34 != 0);
  }
LAB_0001d532:
  emxFree_real_T(&local_40);
  uVar28 = ((int *)local_54[1])[1];
  if (0 < (int)uVar28) {
    pauVar39 = (undefined1 (*) [16])*local_54;
    uVar19 = 0;
    iVar32 = *local_58;
    iVar12 = *(int *)local_54[1];
    iVar21 = *(int *)local_58[1];
    if ((uVar28 != 1) && (iVar21 == 1 && iVar12 == 1)) {
      pauVar40 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      pauVar37 = (undefined1 (*) [16])(iVar32 + 0x20);
      bVar41 = pauVar37 < pauVar40;
      if (bVar41) {
        pauVar40 = (undefined1 (*) [16])(iVar32 + uVar28 * 8 + 0x20);
      }
      if (bVar41 && pauVar39 < pauVar40) {
        uVar19 = 0;
      }
      else {
        uVar19 = uVar28 & 0xfffffffe;
        pauVar40 = pauVar39;
        uVar29 = uVar19;
        do {
          in_q8 = *pauVar40;
          pauVar40 = pauVar40 + iVar12;
          uVar29 = uVar29 - 2;
          *(longlong *)*pauVar37 = in_q8._0_8_;
          *(longlong *)(*pauVar37 + 8) = in_q8._8_8_;
          pauVar37 = pauVar37 + iVar21;
        } while (uVar29 != 0);
        if (uVar28 == uVar19) goto LAB_0001d598;
      }
    }
    iVar34 = uVar28 - uVar19;
    puVar14 = (undefined8 *)(*pauVar39 + uVar19 * iVar12 * 8);
    puVar11 = (undefined8 *)(iVar32 + uVar19 * iVar21 * 8 + 0x20);
    do {
      in_q8._0_8_ = (double)*puVar14;
      puVar14 = puVar14 + iVar12;
      iVar34 = iVar34 + -1;
      *puVar11 = in_q8._0_8_;
      puVar11 = puVar11 + iVar21;
    } while (iVar34 != 0);
  }
LAB_0001d598:
  emxFree_real_T(&local_54);
  emxInit_boolean_T1(&local_5c,2);
  piVar18 = (int *)local_5c[1];
  iVar21 = local_58[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 5;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_boolean_T1(local_5c,iVar32 * iVar12);
  iVar12 = ((int *)local_58[1])[1] * *(int *)local_58[1];
  if (0 < iVar12) {
    in_q8._0_8_ = *(double *)*local_58;
    uVar10 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
    *(undefined1 *)*local_5c = uVar10;
    if (iVar12 != 1) {
      iVar32 = 1;
      iVar21 = 8;
      do {
        in_q8._0_8_ = *(double *)(*local_58 + iVar21);
        uVar10 = rtIsNaN(SUB84(in_q8._0_8_,0),(int)((ulonglong)in_q8._0_8_ >> 0x20));
        iVar21 = iVar21 + 8;
        *(undefined1 *)(*local_5c + iVar32) = uVar10;
        iVar32 = iVar32 + 1;
      } while (iVar12 - iVar32 != 0);
    }
  }
  emxInit_real_T1(&local_60,2);
  piVar18 = (int *)local_60[1];
  iVar21 = local_58[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 5;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_60,iVar32 * iVar12);
  uVar28 = *(int *)local_58[1] * ((int *)local_58[1])[1];
  if (0 < (int)uVar28) {
    pauVar39 = (undefined1 (*) [16])*local_58;
    pauVar40 = (undefined1 (*) [16])*local_60;
    if (uVar28 == 1) {
LAB_0001d67a:
      uVar19 = 0;
    }
    else {
      pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      bVar41 = pauVar40 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar28 * 8);
      }
      if (bVar41 && pauVar39 < pauVar37) goto LAB_0001d67a;
      uVar19 = uVar28 & 0xfffffffe;
      pauVar37 = pauVar39;
      pauVar13 = pauVar40;
      uVar29 = uVar19;
      do {
        in_q8 = *pauVar37;
        pauVar37 = pauVar37 + 1;
        uVar29 = uVar29 - 2;
        *(longlong *)*pauVar13 = in_q8._0_8_;
        *(double *)(*pauVar13 + 8) = in_q8._8_8_;
        pauVar13 = pauVar13 + 1;
      } while (uVar29 != 0);
      if (uVar28 - uVar19 == 0) goto LAB_0001d698;
    }
    puVar11 = (undefined8 *)(*pauVar39 + uVar19 * 8);
    puVar14 = (undefined8 *)(*pauVar40 + uVar19 * 8);
    iVar12 = uVar28 - uVar19;
    do {
      in_q8._0_8_ = (double)*puVar11;
      puVar11 = puVar11 + 1;
      iVar12 = iVar12 + -1;
      *puVar14 = in_q8._0_8_;
      puVar14 = puVar14 + 1;
    } while (iVar12 != 0);
  }
LAB_0001d698:
  emxInit_real_T1(&local_64,2);
  piVar18 = (int *)local_64[1];
  iVar12 = piVar18[1];
  piVar18[1] = *(int *)(local_58[1] + 4);
  emxEnsureCapacity_real_T(local_64,iVar12 * *piVar18);
  piVar18 = (int *)local_58[1];
  iVar12 = *piVar18;
  *piVar18 = 5;
  emxEnsureCapacity_real_T(local_58,piVar18[1] * iVar12);
  if (0 < *(int *)(local_64[1] + 4)) {
    uVar28 = *(int *)(local_64[1] + 4) * 5;
    if ((int)uVar28 < 2) {
      uVar28 = 1;
    }
    pauVar40 = (undefined1 (*) [16])*local_58;
    pauVar39 = (undefined1 (*) [16])*local_60;
    if (uVar28 < 2) {
      uVar19 = 0;
    }
    else {
      pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
      uVar19 = 0;
      bVar41 = pauVar40 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar28 * 8);
      }
      if (!bVar41 || pauVar37 <= pauVar39) {
        uVar19 = uVar28 & 0x7ffffffe;
        auVar45._8_8_ = 0x4053000000000000;
        auVar45._0_8_ = 0x4053000000000000;
        pauVar37 = pauVar39;
        pauVar13 = pauVar40;
        uVar29 = uVar19;
        do {
          auVar43 = *pauVar37;
          pauVar37 = pauVar37 + 1;
          dVar44 = auVar43._0_8_;
          uVar35 = (uint)((int)(in_fpscr & 0xfffffff | (uint)(dVar44 < 76.0) << 0x1f |
                                (uint)(dVar44 == 76.0) << 0x1e | (uint)(76.0 <= dVar44) << 0x1d) < 0
                         );
          dVar44 = auVar43._8_8_;
          in_fpscr = in_fpscr & 0xfffffff | (uint)(dVar44 < 76.0) << 0x1f |
                     (uint)(dVar44 == 76.0) << 0x1e | (uint)(76.0 <= dVar44) << 0x1d;
          uVar30 = (uint)((int)in_fpscr < 0);
          if (uVar30 != 0) {
            uVar30 = 0xffffffff;
          }
          auVar8._12_4_ = uVar30;
          auVar8._8_4_ = uVar30;
          if (uVar35 != 0) {
            uVar35 = 0xffffffff;
          }
          auVar8._4_4_ = uVar35;
          auVar8._0_4_ = uVar35;
          in_q10 = VectorBitwiseInsertIfFalse(auVar43,auVar45,auVar8);
          uVar29 = uVar29 - 2;
          *(longlong *)*pauVar13 = in_q10._0_8_;
          *(longlong *)(*pauVar13 + 8) = in_q10._8_8_;
          pauVar13 = pauVar13 + 1;
        } while (uVar29 != 0);
        if (uVar28 == uVar19) goto LAB_0001d79a;
      }
    }
    pdVar22 = (double *)(*pauVar40 + uVar19 * 8);
    pdVar33 = (double *)(*pauVar39 + uVar19 * 8);
    iVar12 = uVar28 - uVar19;
    auVar42._8_8_ = in_q8._8_8_;
    auVar42._0_8_ = 76.0;
    do {
      auVar42._8_8_ = *pdVar33;
      pdVar33 = pdVar33 + 1;
      in_fpscr = in_fpscr & 0xfffffff | (uint)(auVar42._8_8_ < auVar42._0_8_) << 0x1f |
                 (uint)(auVar42._8_8_ == auVar42._0_8_) << 0x1e |
                 (uint)(auVar42._0_8_ <= auVar42._8_8_) << 0x1d;
      in_q8._8_8_ = auVar42._0_8_;
      if ((int)in_fpscr < 0) {
        in_q8._8_8_ = auVar42._8_8_;
      }
      *pdVar22 = in_q8._8_8_;
      pdVar22 = pdVar22 + 1;
      iVar12 = iVar12 + -1;
    } while (iVar12 != 0);
  }
LAB_0001d79a:
  iVar12 = *(int *)(local_5c[1] + 4);
  if (iVar12 < 1) {
    emxInit_int32_T1(&local_68,1);
    uVar46 = *(undefined4 *)local_68[1];
    *(undefined4 *)local_68[1] = 0;
    emxEnsureCapacity_int32_T1(local_68,uVar46);
  }
  else {
    uVar28 = iVar12 * 5;
    uVar19 = uVar28;
    if ((int)uVar28 < 2) {
      uVar19 = 1;
    }
    if (uVar19 < 4) {
      uVar35 = 0;
      iVar21 = 0;
LAB_0001d830:
      iVar32 = uVar19 - uVar35;
      pcVar23 = (char *)(*local_5c + uVar35);
      do {
        if (*pcVar23 != '\0') {
          iVar21 = iVar21 + 1;
        }
        iVar32 = iVar32 + -1;
        pcVar23 = pcVar23 + 1;
      } while (iVar32 != 0);
    }
    else {
      auVar43 = ZEXT816(0);
      auVar1 = SIMDExpandImmediate(0,0,1);
      uVar35 = uVar19 & 0x7ffffffc;
      uVar29 = uVar35;
      puVar36 = (undefined4 *)*local_5c;
      do {
        in_q9._8_8_ = in_q10._0_8_;
        uVar29 = uVar29 - 4;
                    // WARNING: Ignoring partial resolution of indirect
        uVar46 = *puVar36;
        auVar48 = VectorCopyLong(in_q9._8_8_,1,1);
        uVar47 = VectorCompareEqual(auVar48._0_8_,0,2);
        in_q10 = VectorCopyLong(~uVar47,2,1);
        in_q10 = in_q10 & auVar1;
        auVar43 = VectorAdd(auVar43,in_q10,4);
        puVar36 = puVar36 + 1;
      } while (uVar29 != 0);
      auVar3._16_16_ = auVar43;
      auVar3._0_16_ = auVar43;
      auVar43 = VectorAdd(auVar43,auVar3._8_16_,4);
      in_q9._8_8_ = CONCAT44(auVar43._4_4_,auVar43._4_4_);
      auVar2._8_8_ = in_q9._8_8_;
      auVar2._0_8_ = in_q9._8_8_;
      auVar43 = VectorAdd(auVar43,auVar2,4);
      iVar21 = auVar43._0_4_;
      if (uVar19 != uVar35) goto LAB_0001d830;
    }
    emxInit_int32_T1(&local_68,1);
    iVar32 = *(int *)local_68[1];
    *(int *)local_68[1] = iVar21;
    emxEnsureCapacity_int32_T1(local_68,iVar32);
    if (0 < iVar12) {
      iVar21 = 0;
      iVar32 = 0;
      iVar12 = *local_5c;
      do {
        pcVar23 = (char *)(iVar12 + iVar21);
        iVar21 = iVar21 + 1;
        if (*pcVar23 != '\0') {
          *(int *)(*local_68 + iVar32 * 4) = iVar21;
          iVar32 = iVar32 + 1;
        }
      } while (iVar21 < (int)uVar28);
    }
  }
  emxFree_boolean_T(&local_5c);
  iVar12 = *(int *)local_68[1];
  if (0 < iVar12) {
    iVar21 = *local_58;
    piVar18 = (int *)*local_68;
    do {
      iVar12 = iVar12 + -1;
      *(undefined8 *)(iVar21 + *piVar18 * 8 + -8) = rtNaN;
      piVar18 = piVar18 + 1;
    } while (iVar12 != 0);
  }
  emxFree_int32_T(&local_68);
  piVar18 = (int *)local_34[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  uVar28 = *(uint *)(local_58[1] + 4);
  *piVar18 = 4;
  piVar18[1] = uVar28;
  emxEnsureCapacity_real_T(local_34,iVar21 * iVar12);
  if ((int)uVar28 < 1) {
    piVar18 = (int *)local_58[1];
  }
  else {
    piVar18 = (int *)local_58[1];
    iVar12 = *(int *)local_34[1];
    puVar11 = (undefined8 *)(*local_58 + 0x20);
    iVar21 = *piVar18;
    puVar14 = (undefined8 *)(*local_34 + 0x10);
    uVar19 = uVar28;
    do {
      uVar19 = uVar19 - 1;
      puVar14[-2] = puVar11[-3];
      puVar14[-1] = puVar11[-2];
      *puVar14 = puVar11[-1];
      in_q9._8_8_ = *puVar11;
      puVar11 = puVar11 + iVar21;
      puVar14[1] = in_q9._8_8_;
      puVar14 = puVar14 + iVar12;
    } while (uVar19 != 0);
  }
  uVar19 = piVar18[1];
  piVar18 = (int *)local_44[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = uVar19;
  emxEnsureCapacity_real_T(local_44,iVar21 * iVar12);
  if (0 < (int)uVar19) {
    uVar29 = 0;
    pauVar39 = (undefined1 (*) [16])*local_44;
    pauVar40 = (undefined1 (*) [16])*local_58;
    iVar21 = *(int *)local_44[1];
    iVar12 = *(int *)local_58[1];
    if ((uVar19 != 1) && (iVar21 == 1 && iVar12 == 1)) {
      pauVar37 = (undefined1 (*) [16])(*pauVar40 + uVar19 * 8);
      bVar41 = pauVar39 < pauVar37;
      if (bVar41) {
        pauVar37 = (undefined1 (*) [16])(*pauVar39 + uVar19 * 8);
      }
      if (bVar41 && pauVar40 < pauVar37) {
        uVar29 = 0;
      }
      else {
        uVar29 = uVar19 & 0xfffffffe;
        pauVar37 = pauVar39;
        pauVar13 = pauVar40;
        uVar35 = uVar29;
        do {
          auVar43 = *pauVar13;
          pauVar13 = pauVar13 + iVar12;
          uVar35 = uVar35 - 2;
          *(longlong *)*pauVar37 = auVar43._0_8_;
          *(longlong *)(*pauVar37 + 8) = auVar43._8_8_;
          pauVar37 = pauVar37 + iVar21;
        } while (uVar35 != 0);
        if (uVar19 == uVar29) goto LAB_0001d990;
      }
    }
    iVar32 = uVar19 - uVar29;
    puVar14 = (undefined8 *)(*pauVar40 + uVar29 * iVar12 * 8);
    puVar11 = (undefined8 *)(*pauVar39 + uVar29 * iVar21 * 8);
    do {
      in_q9._8_8_ = *puVar14;
      puVar14 = puVar14 + iVar12;
      iVar32 = iVar32 + -1;
      *puVar11 = in_q9._8_8_;
      puVar11 = puVar11 + iVar21;
    } while (iVar32 != 0);
  }
LAB_0001d990:
  piVar18 = (int *)local_64[1];
  iVar12 = *piVar18;
  iVar21 = piVar18[1];
  *piVar18 = 5;
  piVar18[1] = uVar28;
  emxEnsureCapacity_real_T(local_64,iVar21 * iVar12);
  if ((int)uVar28 < 1) {
    emxFree_real_T(&local_34);
  }
  else {
    iVar12 = *(int *)local_64[1];
    puVar11 = (undefined8 *)(*local_64 + 0x10);
    puVar14 = (undefined8 *)(*local_34 + 0x10);
    uVar19 = 0;
    do {
      uVar19 = uVar19 + 1;
      puVar11[-2] = puVar14[-2];
      puVar11[-1] = puVar14[-1];
      *puVar11 = *puVar14;
      puVar4 = puVar14 + 1;
      puVar14 = puVar14 + 4;
      puVar11[1] = *puVar4;
      puVar11 = puVar11 + iVar12;
    } while (uVar28 != uVar19);
    emxFree_real_T(&local_34);
    if (0 < (int)uVar28) {
      iVar21 = *local_64;
      pauVar39 = (undefined1 (*) [16])*local_44;
      iVar12 = *(int *)local_64[1];
      uVar19 = 0;
      if ((uVar28 != 1) && (iVar12 == 1)) {
        pauVar40 = (undefined1 (*) [16])(*pauVar39 + uVar28 * 8);
        pauVar37 = (undefined1 (*) [16])(iVar21 + 0x20);
        bVar41 = pauVar37 < pauVar40;
        if (bVar41) {
          pauVar40 = (undefined1 (*) [16])(iVar21 + uVar28 * 8 + 0x20);
        }
        if (bVar41 && pauVar39 < pauVar40) {
          uVar19 = 0;
        }
        else {
          uVar19 = uVar28 & 0xfffffffe;
          pauVar40 = pauVar39;
          uVar29 = uVar19;
          do {
            auVar43 = *pauVar40;
            pauVar40 = pauVar40 + 1;
            uVar29 = uVar29 - 2;
            *(longlong *)*pauVar37 = auVar43._0_8_;
            *(longlong *)(*pauVar37 + 8) = auVar43._8_8_;
            pauVar37 = pauVar37 + 1;
          } while (uVar29 != 0);
          if (uVar28 == uVar19) goto LAB_0001dbb4;
        }
      }
      puVar14 = (undefined8 *)(*pauVar39 + uVar19 * 8);
      iVar32 = uVar28 - uVar19;
      puVar11 = (undefined8 *)(iVar21 + uVar19 * iVar12 * 8 + 0x20);
      do {
        in_q9._8_8_ = *puVar14;
        puVar14 = puVar14 + 1;
        iVar32 = iVar32 + -1;
        *puVar11 = in_q9._8_8_;
        puVar11 = puVar11 + iVar12;
      } while (iVar32 != 0);
    }
  }
LAB_0001dbb4:
  emxFree_real_T(&local_44);
  piVar18 = (int *)local_60[1];
  iVar21 = local_58[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 5;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_60,iVar32 * iVar12);
  iVar12 = ((int *)local_58[1])[1];
  if (0 < iVar12) {
    iVar32 = *(int *)local_58[1];
    pdVar22 = (double *)*local_64;
    pdVar33 = (double *)*local_60;
    iVar21 = *(int *)local_64[1];
    iVar34 = *(int *)local_60[1];
    pdVar25 = (double *)(*local_58 + 0x10);
    do {
      iVar12 = iVar12 + -1;
      *pdVar33 = pdVar25[-2] * 0.5 * *pdVar22 * 0.9510565;
      pdVar33[1] = pdVar25[-1] * 0.5 * pdVar22[1] * 0.9510565;
      pdVar33[2] = *pdVar25 * 0.5 * pdVar22[2] * 0.9510565;
      pdVar33[3] = pdVar25[1] * 0.5 * pdVar22[3] * 0.9510565;
      pdVar5 = pdVar25 + 2;
      pdVar25 = pdVar25 + iVar32;
      pdVar6 = pdVar22 + 4;
      pdVar22 = pdVar22 + iVar21;
      pdVar33[4] = *pdVar5 * 0.5 * *pdVar6 * 0.9510565;
      pdVar33 = pdVar33 + iVar34;
    } while (iVar12 != 0);
  }
  emxFree_real_T(&local_64);
  piVar18 = (int *)local_30[1];
  iVar21 = local_60[1];
  iVar12 = *piVar18;
  iVar32 = piVar18[1];
  *piVar18 = 1;
  piVar18[1] = *(int *)(iVar21 + 4);
  emxEnsureCapacity_real_T(local_30,iVar32 * iVar12);
  iVar12 = *(int *)(local_60[1] + 4);
  if (0 < iVar12) {
    pdVar22 = (double *)*local_30;
    pdVar33 = (double *)(*local_60 + 0x10);
    do {
      in_q8._8_8_ = pdVar33[-2];
      iVar12 = iVar12 + -1;
      *pdVar22 = in_q8._8_8_;
      in_q8._8_8_ = pdVar33[-1] + in_q8._8_8_;
      *pdVar22 = in_q8._8_8_;
      in_q8._8_8_ = *pdVar33 + in_q8._8_8_;
      *pdVar22 = in_q8._8_8_;
      in_q8._8_8_ = pdVar33[1] + in_q8._8_8_;
      *pdVar22 = in_q8._8_8_;
      pdVar25 = pdVar33 + 2;
      pdVar33 = pdVar33 + 5;
      *pdVar22 = *pdVar25 + in_q8._8_8_;
      pdVar22 = pdVar22 + 1;
    } while (iVar12 != 0);
  }
  emxFree_real_T(&local_60);
  iVar21 = *(int *)(param_3[1] + 4);
  iVar12 = *(int *)(local_3c[1] + 4);
  iVar32 = iVar12;
  if ((iVar12 == 0) && (iVar32 = iVar21, iVar21 == 0)) {
    iVar32 = *(int *)(local_48[1] + 4);
    if ((iVar32 != 0) ||
       ((iVar32 = *(int *)(local_50[1] + 4), iVar32 != 0 ||
        (iVar32 = *(int *)(param_2[1] + 4), iVar32 != 0)))) {
      iVar21 = 0;
      goto LAB_0001dd64;
    }
    iVar38 = 0;
    iVar32 = *(int *)(local_58[1] + 4);
    if (iVar32 != 0) {
      iVar26 = 0;
      iVar31 = 0;
      iVar34 = 0;
      iVar21 = 0;
      iVar12 = 0;
      goto LAB_0001dd92;
    }
    iVar26 = 1;
    iVar34 = 1;
    iVar12 = 1;
    iVar21 = 1;
    iVar31 = 1;
    iVar20 = 1;
  }
  else {
LAB_0001dd64:
    iVar26 = *(int *)(param_2[1] + 4);
    iVar31 = *(int *)(local_50[1] + 4);
    iVar34 = *(int *)(local_48[1] + 4);
    if (iVar12 != 0) {
      iVar12 = 1;
    }
    if (iVar26 != 0) {
      iVar26 = 1;
    }
    if (iVar31 != 0) {
      iVar31 = 1;
    }
    if (iVar34 != 0) {
      iVar34 = 1;
    }
LAB_0001dd92:
    iVar20 = *(int *)(local_30[1] + 4);
    if (iVar21 != 0) {
      iVar21 = 1;
    }
    iVar38 = iVar32;
    if (iVar20 != 0) {
      iVar20 = 1;
    }
  }
  iVar32 = iVar34 + iVar21 + iVar12;
  iVar15 = iVar32 + iVar31;
  piVar18 = (int *)param_4[1];
  iVar16 = iVar15 + iVar26 + 5;
  iVar17 = *piVar18;
  iVar27 = piVar18[1];
  *piVar18 = iVar20 + iVar16;
  piVar18[1] = iVar38;
  emxEnsureCapacity_real_T(param_4,iVar27 * iVar17);
  if (iVar38 < 1) {
    emxFree_real_T(&local_3c);
LAB_0001de90:
    emxFree_real_T(&local_48);
LAB_0001de96:
    emxFree_real_T(&local_50);
  }
  else {
    iVar17 = 0;
    iVar27 = 0;
    do {
      if (iVar12 != 0) {
        *(undefined8 *)(*param_4 + iVar27 * *(int *)param_4[1] * 8) =
             *(undefined8 *)(*local_3c + iVar17);
      }
      iVar27 = iVar27 + 1;
      iVar17 = iVar17 + 8;
    } while (iVar38 != iVar27);
    emxFree_real_T(&local_3c);
    if (iVar38 < 1) goto LAB_0001de90;
    iVar17 = 0;
    iVar27 = 0;
    do {
      if (iVar21 != 0) {
        *(undefined8 *)(*param_4 + (*(int *)param_4[1] * iVar27 + iVar12) * 8) =
             *(undefined8 *)(*param_3 + iVar17);
      }
      iVar27 = iVar27 + 1;
      iVar17 = iVar17 + 8;
    } while (iVar38 != iVar27);
    if (iVar38 < 1) goto LAB_0001de90;
    iVar17 = 0;
    iVar27 = 0;
    do {
      if (iVar34 != 0) {
        *(undefined8 *)(*param_4 + (*(int *)param_4[1] * iVar27 + iVar21 + iVar12) * 8) =
             *(undefined8 *)(*local_48 + iVar17);
      }
      iVar27 = iVar27 + 1;
      iVar17 = iVar17 + 8;
    } while (iVar38 != iVar27);
    emxFree_real_T(&local_48);
    if (iVar38 < 1) goto LAB_0001de96;
    iVar17 = 0;
    iVar27 = 0;
    do {
      if (iVar31 != 0) {
        *(undefined8 *)(*param_4 + (*(int *)param_4[1] * iVar27 + iVar32) * 8) =
             *(undefined8 *)(*local_50 + iVar17);
      }
      iVar27 = iVar27 + 1;
      iVar17 = iVar17 + 8;
    } while (iVar38 != iVar27);
    emxFree_real_T(&local_50);
    if (0 < iVar38) {
      iVar32 = 0;
      iVar17 = 0;
      do {
        if (iVar26 != 0) {
          *(undefined8 *)(*param_4 + (*(int *)param_4[1] * iVar17 + iVar15) * 8) =
               *(undefined8 *)(*param_2 + iVar32);
        }
        iVar17 = iVar17 + 1;
        iVar32 = iVar32 + 8;
      } while (iVar38 != iVar17);
      if (0 < iVar38) {
        iVar32 = *(int *)param_4[1];
        puVar14 = (undefined8 *)(*local_58 + 0x10);
        puVar11 = (undefined8 *)(*param_4 + (iVar12 + iVar26 + iVar34 + iVar31 + iVar21) * 8 + 0x10)
        ;
        iVar12 = iVar38;
        do {
          iVar12 = iVar12 + -1;
          puVar11[-2] = puVar14[-2];
          puVar11[-1] = puVar14[-1];
          *puVar11 = *puVar14;
          puVar11[1] = puVar14[1];
          puVar4 = puVar14 + 2;
          puVar14 = puVar14 + 5;
          puVar11[2] = *puVar4;
          puVar11 = puVar11 + iVar32;
        } while (iVar12 != 0);
        emxFree_real_T(&local_58);
        if (0 < iVar38) {
          iVar12 = 0;
          iVar21 = 0;
          do {
            if (iVar20 != 0) {
              *(undefined8 *)(*param_4 + (*(int *)param_4[1] * iVar21 + iVar16) * 8) =
                   *(undefined8 *)(*local_30 + iVar12);
            }
            iVar21 = iVar21 + 1;
            iVar12 = iVar12 + 8;
          } while (iVar38 != iVar21);
        }
        goto LAB_0001dea2;
      }
    }
  }
  emxFree_real_T(&local_58);
LAB_0001dea2:
  emxFree_real_T(&local_30);
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void b_power(int *param_1,int *param_2)

{
  double *pdVar1;
  int iVar2;
  double *pdVar3;
  int iVar4;
  double dVar5;
  
  iVar2 = *(int *)param_2[1];
  iVar4 = *(int *)param_1[1];
  *(int *)param_2[1] = iVar4;
  emxEnsureCapacity_real_T1(param_2,iVar2);
  if (0 < iVar4) {
    pdVar1 = (double *)*param_2;
    pdVar3 = (double *)*param_1;
    do {
      dVar5 = *pdVar3;
      pdVar3 = pdVar3 + 1;
      iVar4 = iVar4 + -1;
      *pdVar1 = dVar5 * dVar5;
      pdVar1 = pdVar1 + 1;
    } while (iVar4 != 0);
  }
  return;
}



void c_power(int *param_1,int *param_2)

{
  int iVar1;
  int iVar2;
  int iVar3;
  undefined8 uVar4;
  
  iVar1 = *(int *)param_2[1];
  iVar3 = *(int *)param_1[1];
  *(int *)param_2[1] = iVar3;
  emxEnsureCapacity_real_T1(param_2,iVar1);
  if (0 < iVar3) {
    iVar1 = 0;
    do {
      uVar4 = rt_powd_snf((int)*(undefined8 *)(*param_1 + iVar1),
                          (int)((ulonglong)*(undefined8 *)(*param_1 + iVar1) >> 0x20),0xf9db22d1,
                          0x3ff06a7e);
      iVar2 = *param_2;
      iVar3 = iVar3 + -1;
      *(int *)(iVar2 + iVar1) = (int)uVar4;
      iVar2 = iVar2 + iVar1;
      iVar1 = iVar1 + 8;
      *(int *)(iVar2 + 4) = (int)((ulonglong)uVar4 >> 0x20);
    } while (iVar3 != 0);
  }
  return;
}



void d_power(int *param_1,int *param_2)

{
  int *piVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  undefined8 uVar6;
  
  piVar1 = (int *)param_2[1];
  iVar3 = param_1[1];
  iVar2 = *piVar1;
  iVar4 = piVar1[1];
  iVar5 = *(int *)(iVar3 + 4);
  *piVar1 = 1;
  piVar1[1] = *(int *)(iVar3 + 4);
  emxEnsureCapacity_real_T(param_2,iVar4 * iVar2);
  if (0 < iVar5) {
    iVar2 = 0;
    do {
      uVar6 = rt_powd_snf((int)*(undefined8 *)(*param_1 + iVar2),
                          (int)((ulonglong)*(undefined8 *)(*param_1 + iVar2) >> 0x20),0xa7ef9db2,
                          0x3ff94bc6);
      iVar3 = *param_2;
      iVar5 = iVar5 + -1;
      *(int *)(iVar3 + iVar2) = (int)uVar6;
      iVar3 = iVar3 + iVar2;
      iVar2 = iVar2 + 8;
      *(int *)(iVar3 + 4) = (int)((ulonglong)uVar6 >> 0x20);
    } while (iVar5 != 0);
  }
  return;
}



void e_power(int *param_1,int *param_2)

{
  int *piVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  undefined8 uVar6;
  
  piVar1 = (int *)param_2[1];
  iVar3 = param_1[1];
  iVar2 = *piVar1;
  iVar4 = piVar1[1];
  iVar5 = *(int *)(iVar3 + 4);
  *piVar1 = 1;
  piVar1[1] = *(int *)(iVar3 + 4);
  emxEnsureCapacity_real_T(param_2,iVar4 * iVar2);
  if (0 < iVar5) {
    iVar2 = 0;
    do {
      uVar6 = rt_powd_snf((int)*(undefined8 *)(*param_1 + iVar2),
                          (int)((ulonglong)*(undefined8 *)(*param_1 + iVar2) >> 0x20),0xc28f5c29,
                          0x3ff828f5);
      iVar3 = *param_2;
      iVar5 = iVar5 + -1;
      *(int *)(iVar3 + iVar2) = (int)uVar6;
      iVar3 = iVar3 + iVar2;
      iVar2 = iVar2 + 8;
      *(int *)(iVar3 + 4) = (int)((ulonglong)uVar6 >> 0x20);
    } while (iVar5 != 0);
  }
  return;
}



void f_power(int *param_1,int *param_2)

{
  int *piVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  undefined8 uVar6;
  
  piVar1 = (int *)param_2[1];
  iVar3 = param_1[1];
  iVar2 = *piVar1;
  iVar4 = piVar1[1];
  iVar5 = *(int *)(iVar3 + 4);
  *piVar1 = 1;
  piVar1[1] = *(int *)(iVar3 + 4);
  emxEnsureCapacity_real_T(param_2,iVar4 * iVar2);
  if (0 < iVar5) {
    iVar2 = 0;
    do {
      uVar6 = rt_powd_snf((int)*(undefined8 *)(*param_1 + iVar2),
                          (int)((ulonglong)*(undefined8 *)(*param_1 + iVar2) >> 0x20),0x70a3d70a,
                          0x40050a3d);
      iVar3 = *param_2;
      iVar5 = iVar5 + -1;
      *(int *)(iVar3 + iVar2) = (int)uVar6;
      iVar3 = iVar3 + iVar2;
      iVar2 = iVar2 + 8;
      *(int *)(iVar3 + 4) = (int)((ulonglong)uVar6 >> 0x20);
    } while (iVar5 != 0);
  }
  return;
}



void power(int *param_1,int *param_2)

{
  int *piVar1;
  double *pdVar2;
  int iVar3;
  double *pdVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  double dVar8;
  
  piVar1 = (int *)param_2[1];
  iVar5 = param_1[1];
  iVar3 = *piVar1;
  iVar6 = piVar1[1];
  iVar7 = *(int *)(iVar5 + 4);
  *piVar1 = 1;
  piVar1[1] = *(int *)(iVar5 + 4);
  emxEnsureCapacity_real_T(param_2,iVar6 * iVar3);
  if (0 < iVar7) {
    pdVar2 = (double *)*param_2;
    pdVar4 = (double *)*param_1;
    do {
      dVar8 = *pdVar4;
      pdVar4 = pdVar4 + 1;
      iVar7 = iVar7 + -1;
      *pdVar2 = dVar8 * dVar8;
      pdVar2 = pdVar2 + 1;
    } while (iVar7 != 0);
  }
  return;
}



void percentile_array(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                     int *param_5)

{
  double *pdVar1;
  int iVar2;
  int iVar3;
  undefined4 *puVar4;
  undefined4 uVar5;
  int iVar6;
  undefined8 *extraout_r1;
  undefined8 *puVar7;
  int iVar8;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  undefined4 uVar9;
  int iVar10;
  undefined8 *puVar11;
  undefined8 *puVar12;
  uint *puVar13;
  uint uVar14;
  undefined8 *puVar15;
  uint uVar16;
  double *pdVar17;
  undefined8 *puVar18;
  undefined8 *puVar19;
  int iVar20;
  undefined8 *puVar21;
  undefined8 *puVar22;
  int iVar23;
  uint uVar24;
  int iVar25;
  undefined8 *puVar26;
  uint uVar27;
  int iVar28;
  undefined8 *puVar29;
  uint uVar30;
  int *piVar31;
  uint uVar32;
  bool bVar33;
  double dVar34;
  double dVar35;
  undefined8 uVar36;
  double dVar37;
  undefined8 uVar38;
  undefined4 in_stack_ffffff40;
  int *piVar39;
  undefined8 *local_a4;
  uint *local_78;
  int *local_74;
  uint *local_70;
  int local_6c;
  
  piVar39 = &__stack_chk_guard;
  local_6c = __stack_chk_guard;
  iVar6 = *(int *)param_5[1];
  iVar10 = *(int *)param_1[1];
  *(int *)param_5[1] = iVar10;
  emxEnsureCapacity_real_T1(param_5,iVar6);
  emxInit_real_T(&local_70,1);
  emxInit_int32_T1(&local_74,1);
  emxInit_int32_T1(&local_78,1);
  bVar33 = *(int *)param_1[1] != 0;
  if (bVar33) {
    iVar10 = ((int *)param_1[1])[1];
  }
  if ((bVar33 && iVar10 != 0) && (*(int *)param_5[1] != 0)) {
    iVar6 = *(int *)local_70[1];
    *(int *)local_70[1] = iVar10;
    emxEnsureCapacity_real_T1(local_70,iVar6);
    puVar13 = (uint *)param_1[1];
    puVar18 = (undefined8 *)*puVar13;
    puVar7 = puVar18;
    if (0 < (int)puVar18) {
      iVar6 = -1;
      iVar10 = 0;
      local_a4 = puVar18;
      do {
        iVar6 = iVar6 + 1;
        iVar2 = *param_1;
        uVar14 = puVar13[1];
        puVar7 = (undefined8 *)*local_70;
        *puVar7 = *(undefined8 *)(iVar2 + iVar6 * 8);
        if (1 < (int)uVar14) {
          uVar30 = uVar14 - 1;
          iVar28 = 2;
          iVar20 = iVar6;
          if ((1 < uVar30) && (puVar18 == (undefined8 *)0x1)) {
            puVar19 = puVar7 + 1;
            puVar12 = (undefined8 *)(iVar2 + (uVar14 + iVar10) * 8);
            bVar33 = puVar19 < puVar12;
            puVar22 = (undefined8 *)((int)puVar18 * 8);
            if (bVar33) {
              puVar12 = puVar7 + uVar14;
              puVar22 = (undefined8 *)(iVar2 + (iVar10 + 1) * 8);
            }
            if (bVar33 && puVar22 < puVar12) {
              iVar28 = 2;
            }
            else {
              uVar32 = uVar30 & 0xfffffffe;
              iVar28 = uVar32 + 2;
              puVar12 = (undefined8 *)(iVar2 + (int)local_a4 * 8);
              uVar24 = uVar32;
              do {
                uVar36 = *puVar12;
                uVar38 = puVar12[1];
                puVar12 = puVar12 + 2;
                uVar24 = uVar24 - 2;
                *puVar19 = uVar36;
                puVar19[1] = uVar38;
                puVar19 = puVar19 + 2;
              } while (uVar24 != 0);
              iVar20 = uVar32 + iVar6;
              if (uVar30 == uVar32) goto LAB_0001e49c;
            }
          }
          puVar7 = puVar7 + iVar28 + -1;
          iVar28 = (uVar14 - iVar28) + 1;
          puVar12 = (undefined8 *)(iVar2 + ((int)puVar18 + iVar20) * 8);
          do {
            uVar36 = *puVar12;
            puVar12 = puVar12 + (int)puVar18;
            iVar28 = iVar28 + -1;
            *puVar7 = uVar36;
            puVar7 = puVar7 + 1;
          } while (iVar28 != 0);
        }
LAB_0001e49c:
        iVar20 = *(int *)local_70[1];
        iVar2 = *(int *)local_74[1];
        *(int *)local_74[1] = iVar20;
        emxEnsureCapacity_int32_T1(local_74,iVar2);
        if (0 < iVar20) {
          FUN_00022030(*local_74,iVar20 << 2);
        }
        iVar2 = *(int *)local_78[1];
        *(int *)local_78[1] = iVar20;
        emxEnsureCapacity_int32_T1(local_78,iVar2);
        if (1 < iVar20) {
          iVar28 = 1;
          iVar23 = 0;
          iVar2 = 0;
          do {
            iVar25 = iVar2 + 1;
            dVar37 = ((double *)(*local_70 + iVar23))[1];
            if ((*(double *)(*local_70 + iVar23) <= dVar37) ||
               (iVar3 = rtIsNaN(SUB84(dVar37,0),(int)((ulonglong)dVar37 >> 0x20)), iVar3 != 0)) {
              iVar3 = *local_74;
              *(int *)(iVar3 + iVar2 * 4) = iVar25;
              iVar25 = iVar28 + 1;
            }
            else {
              iVar3 = *local_74;
              *(int *)(iVar3 + iVar2 * 4) = iVar2 + 2;
            }
            iVar8 = iVar2 + 3;
            iVar23 = iVar23 + 0x10;
            iVar28 = iVar28 + 2;
            *(int *)(iVar3 + iVar2 * 4 + 4) = iVar25;
            iVar2 = iVar2 + 2;
          } while (iVar8 < iVar20);
        }
        puVar13 = (uint *)local_70[1];
        puVar7 = (undefined8 *)*puVar13;
        if (((uint)puVar7 & 1) != 0) {
          *(undefined8 **)(*local_74 + (int)puVar7 * 4 + -4) = puVar7;
        }
        if (2 < iVar20) {
          uVar14 = 2;
          do {
            puVar12 = (undefined8 *)(uVar14 | 1);
            uVar30 = uVar14 * 2;
            if ((int)puVar12 <= iVar20) {
              puVar22 = (undefined8 *)0x1;
              do {
                puVar19 = (undefined8 *)((int)puVar22 + uVar30);
                if ((int)(iVar20 + 1U) < (int)((int)puVar22 + uVar30)) {
                  puVar19 = (undefined8 *)(iVar20 + 1U);
                }
                puVar15 = (undefined8 *)((int)puVar19 - (int)puVar22);
                if (0 < (int)puVar15) {
                  iVar2 = 0;
                  puVar11 = puVar22;
                  puVar29 = (undefined8 *)((int)puVar12 - 1);
                  piVar31 = local_74;
                  do {
                    dVar37 = *(double *)(*local_70 + *(int *)(*piVar31 + (int)puVar29 * 4) * 8 + -8)
                    ;
                    if ((*(double *)
                          (*local_70 + *(int *)(*piVar31 + ((int)puVar11 - 1U) * 4) * 8 + -8) <=
                         dVar37) ||
                       (iVar28 = rtIsNaN(SUB84(dVar37,0),(int)((ulonglong)dVar37 >> 0x20)),
                       piVar31 = local_74, iVar28 != 0)) {
                      puVar26 = (undefined8 *)((int)puVar11 + 1);
                      iVar28 = *piVar31;
                      uVar24 = *local_78;
                      puVar7 = *(undefined8 **)(iVar28 + ((int)puVar11 - 1U) * 4);
                      *(undefined8 **)(uVar24 + iVar2 * 4) = puVar7;
                      puVar21 = puVar29;
                      if ((puVar26 == puVar12) &&
                         (puVar11 = (undefined8 *)((int)puVar29 + 1), (int)puVar11 < (int)puVar19))
                      {
                        uVar32 = (int)puVar19 + ~(uint)puVar29;
                        if (3 < uVar32) {
                          puVar7 = (undefined8 *)(iVar28 + (int)puVar29 * 4);
                          puVar26 = (undefined8 *)((iVar28 + (int)puVar19 * 4) - 4);
                          puVar21 = (undefined8 *)(uVar24 + iVar2 * 4 + 4);
                          bVar33 = puVar21 < puVar26;
                          if (bVar33) {
                            puVar26 = (undefined8 *)
                                      (uVar24 + ((int)puVar19 + (iVar2 - (int)puVar29)) * 4);
                          }
                          if (!bVar33 || puVar26 <= puVar7) {
                            uVar27 = uVar32 & 0xfffffffc;
                            iVar2 = iVar2 + uVar27;
                            puVar29 = (undefined8 *)((int)puVar29 + uVar27);
                            puVar11 = (undefined8 *)((int)puVar11 + uVar27);
                            uVar16 = uVar27;
                            do {
                              uVar36 = *puVar7;
                              uVar38 = puVar7[1];
                              puVar7 = puVar7 + 2;
                              uVar16 = uVar16 - 4;
                              *puVar21 = uVar36;
                              puVar21[1] = uVar38;
                              puVar21 = puVar21 + 2;
                            } while (uVar16 != 0);
                            puVar26 = puVar12;
                            puVar21 = puVar29;
                            if (uVar32 == uVar27) goto LAB_0001e5c4;
                          }
                        }
                        do {
                          puVar21 = puVar11;
                          *(undefined4 *)((int)(uVar24 + 4) + iVar2 * 4) =
                               *(undefined4 *)(iVar28 + (int)puVar29 * 4);
                          iVar2 = iVar2 + 1;
                          puVar7 = (undefined8 *)(uVar24 + 4);
                          puVar11 = (undefined8 *)((int)puVar21 + 1U);
                          puVar26 = puVar12;
                          puVar29 = puVar21;
                        } while (puVar19 != (undefined8 *)((int)puVar21 + 1U));
                      }
                    }
                    else {
                      puVar21 = (undefined8 *)((int)puVar29 + 1);
                      iVar28 = *local_74;
                      uVar24 = *local_78;
                      *(undefined4 *)(uVar24 + iVar2 * 4) =
                           *(undefined4 *)(iVar28 + (int)puVar29 * 4);
                      puVar7 = puVar21;
                      puVar26 = puVar11;
                      if (((undefined8 *)((int)puVar29 + 2U) == puVar19) &&
                         ((int)puVar11 < (int)puVar12)) {
                        uVar32 = (int)puVar12 - (int)puVar11;
                        if (3 < uVar32) {
                          uVar16 = iVar28 - 4;
                          uVar27 = uVar24 + 4;
                          bVar33 = uVar27 + iVar2 * 4 < uVar16 + (int)puVar12 * 4;
                          if (bVar33) {
                            uVar16 = uVar16 + (int)puVar11 * 4;
                            uVar27 = uVar27 + ((int)puVar12 + (iVar2 - (int)puVar11)) * 4;
                          }
                          if (!bVar33 || uVar27 <= uVar16) {
                            uVar27 = uVar32 & 0xfffffffc;
                            iVar23 = (int)puVar11 * 4;
                            iVar25 = iVar2 * 4;
                            iVar2 = iVar2 + uVar27;
                            puVar29 = (undefined8 *)(uVar24 + iVar25 + 4);
                            puVar11 = (undefined8 *)((int)puVar11 + uVar27);
                            puVar7 = (undefined8 *)((iVar28 + iVar23) - 4);
                            uVar16 = uVar27;
                            do {
                              uVar36 = *puVar7;
                              uVar38 = puVar7[1];
                              puVar7 = puVar7 + 2;
                              uVar16 = uVar16 - 4;
                              *puVar29 = uVar36;
                              puVar29[1] = uVar38;
                              puVar29 = puVar29 + 2;
                            } while (uVar16 != 0);
                            puVar26 = puVar12;
                            if (uVar32 == uVar27) goto LAB_0001e5c4;
                          }
                        }
                        puVar7 = (undefined8 *)(uVar24 + 4);
                        do {
                          iVar23 = (int)puVar11 * 4;
                          puVar11 = (undefined8 *)((int)puVar11 + 1);
                          *(undefined4 *)((int)puVar7 + iVar2 * 4) =
                               *(undefined4 *)(iVar28 + -4 + iVar23);
                          iVar2 = iVar2 + 1;
                          puVar26 = puVar12;
                        } while (puVar12 != puVar11);
                      }
                    }
LAB_0001e5c4:
                    iVar2 = iVar2 + 1;
                    puVar11 = puVar26;
                    puVar29 = puVar21;
                  } while (iVar2 < (int)puVar15);
                  if (0 < (int)puVar15) {
                    iVar2 = *local_74;
                    puVar12 = (undefined8 *)*local_78;
                    if (puVar15 < (undefined8 *)0x4) {
LAB_0001e7a2:
                      puVar11 = (undefined8 *)0x0;
                    }
                    else {
                      puVar7 = (undefined8 *)(iVar2 - 4);
                      bVar33 = (uint)((int)puVar7 + (int)puVar22 * 4) <
                               (uint)((int)puVar12 + (int)puVar15 * 4);
                      if (bVar33) {
                        puVar7 = (undefined8 *)((int)puVar7 + (int)puVar19 * 4);
                      }
                      if (bVar33 && puVar12 < puVar7) goto LAB_0001e7a2;
                      puVar26 = (undefined8 *)(iVar2 + (int)puVar22 * 4 + -4);
                      puVar11 = (undefined8 *)((uint)puVar15 & 0xfffffffc);
                      puVar7 = puVar12;
                      puVar29 = puVar11;
                      do {
                        uVar36 = *puVar7;
                        uVar38 = puVar7[1];
                        puVar7 = puVar7 + 2;
                        puVar29 = (undefined8 *)((int)puVar29 + -4);
                        *puVar26 = uVar36;
                        puVar26[1] = uVar38;
                        puVar26 = puVar26 + 2;
                      } while (puVar29 != (undefined8 *)0x0);
                      puVar7 = puVar15;
                      if (puVar15 == puVar11) goto LAB_0001e578;
                    }
                    iVar28 = ((int)puVar11 + (int)puVar22) - (int)puVar19;
                    puVar4 = (undefined4 *)(iVar2 + ((int)puVar11 + (int)puVar22) * 4 + -4);
                    puVar12 = (undefined8 *)((int)puVar12 + (int)puVar11 * 4);
                    do {
                      puVar7 = (undefined8 *)((int)puVar12 + 4);
                      bVar33 = iVar28 != -1;
                      iVar28 = iVar28 + 1;
                      *puVar4 = *(undefined4 *)puVar12;
                      puVar4 = puVar4 + 1;
                      puVar12 = puVar7;
                    } while (bVar33);
                  }
                }
LAB_0001e578:
                puVar12 = (undefined8 *)((int)puVar19 + uVar14);
                puVar22 = puVar19;
              } while ((int)puVar12 <= iVar20);
            }
            uVar14 = uVar30;
          } while ((int)uVar30 < iVar20);
          puVar13 = (uint *)local_70[1];
        }
        uVar14 = *puVar13;
        do {
          uVar30 = uVar14;
          dVar37 = rtNaN;
          if ((int)uVar30 < 1) goto LAB_0001e87a;
          uVar36 = *(undefined8 *)(*local_70 + *(int *)(*local_74 + uVar30 * 4 + -4) * 8 + -8);
          uVar36 = rtIsNaN((int)uVar36,(int)((ulonglong)uVar36 >> 0x20));
          puVar7 = (undefined8 *)((ulonglong)uVar36 >> 0x20);
          uVar14 = uVar30 - 1;
        } while ((int)uVar36 != 0);
        if (uVar14 == 0) {
LAB_0001e868:
          iVar2 = *(int *)*local_74;
LAB_0001e870:
          puVar7 = (undefined8 *)*local_70;
          dVar37 = (double)puVar7[iVar2 + -1];
        }
        else {
          dVar35 = (double)(longlong)(int)uVar30;
          dVar34 = ((double)CONCAT44(param_4,param_3) / 100.0) * dVar35;
          dVar37 = dVar34;
          if ((int)((uint)(ABS(dVar34) < 4503599627370496.0) << 0x1f) < 0) {
            if (dVar34 < 0.5 == NAN(dVar34)) {
              uVar5 = SUB84(dVar34 + 0.5,0);
              floor((double)CONCAT44(piVar39,in_stack_ffffff40));
              uVar9 = extraout_r1_00;
            }
            else {
              if (dVar34 != -0.5 && dVar34 < -0.5 == NAN(dVar34)) {
                dVar37 = dVar34 * 0.0;
                goto LAB_0001e85e;
              }
              uVar5 = SUB84(dVar34 + -0.5,0);
              ceil((double)CONCAT44(piVar39,in_stack_ffffff40));
              uVar9 = extraout_r1_01;
            }
            dVar37 = (double)CONCAT44(uVar9,uVar5);
          }
LAB_0001e85e:
          if ((int)((uint)(dVar37 < 1.0) << 0x1f) < 0) goto LAB_0001e868;
          if (dVar37 < dVar35 == (NAN(dVar37) || NAN(dVar35))) {
            iVar2 = *(int *)(*local_74 + uVar14 * 4);
            goto LAB_0001e870;
          }
          puVar7 = (undefined8 *)*local_70;
          dVar37 = ((dVar34 - dVar37) + 0.5) *
                   (double)puVar7[*(int *)(*local_74 + (int)(longlong)(dVar37 + 1.0) * 4 + -4) + -1]
                   + (0.5 - (dVar34 - dVar37)) *
                     (double)puVar7[*(int *)(*local_74 + (int)(longlong)dVar37 * 4 + -4) + -1];
        }
LAB_0001e87a:
        *(double *)(*param_5 + iVar6 * 8) = dVar37;
        if (iVar6 == (int)puVar18 - 1U) break;
        puVar13 = (uint *)param_1[1];
        local_a4 = (undefined8 *)((int)local_a4 + 1);
        iVar10 = iVar10 + 1;
      } while( true );
    }
  }
  else {
    puVar18 = *(undefined8 **)param_5[1];
    emxEnsureCapacity_real_T1(param_5,puVar18);
    dVar37 = rtNaN;
    puVar7 = extraout_r1;
    if (0 < (int)puVar18) {
      pdVar1 = (double *)*param_5;
      if ((puVar18 == (undefined8 *)0x1) ||
         ((pdVar1 < (double *)((int)&rtNaN + 1U) && (&rtNaN < pdVar1 + (int)puVar18)))) {
        puVar7 = (undefined8 *)0x0;
      }
      else {
        puVar7 = (undefined8 *)((uint)puVar18 & 0xfffffffe);
        puVar12 = puVar7;
        pdVar17 = pdVar1;
        do {
          *pdVar17 = dVar37;
          pdVar17[1] = dVar37;
          pdVar17 = pdVar17 + 2;
          puVar12 = (undefined8 *)((int)puVar12 - 2);
        } while (puVar12 != (undefined8 *)0x0);
        if (puVar18 == puVar7) goto LAB_0001e356;
      }
      pdVar1 = pdVar1 + (int)puVar7;
      puVar7 = (undefined8 *)((int)puVar18 - (int)puVar7);
      do {
        puVar7 = (undefined8 *)((int)puVar7 - 1);
        *pdVar1 = rtNaN;
        pdVar1 = pdVar1 + 1;
      } while (puVar7 != (undefined8 *)0x0);
    }
  }
LAB_0001e356:
  emxFree_int32_T(&local_78,puVar7);
  emxFree_int32_T(&local_74);
  emxFree_real_T(&local_70);
  if (*piVar39 == local_6c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Restarted to delay deadcode elimination for space: stack

void PT(uint *param_1,uint *param_2,int *param_3)

{
  byte bVar1;
  undefined1 uVar2;
  int *piVar3;
  int iVar4;
  uint *puVar5;
  uint extraout_r1;
  undefined4 uVar6;
  undefined8 *puVar7;
  double *pdVar8;
  int *piVar9;
  uint uVar10;
  undefined2 *puVar11;
  int iVar12;
  uint uVar13;
  int iVar14;
  double *pdVar15;
  int iVar16;
  uint uVar17;
  double *pdVar18;
  int iVar19;
  int iVar20;
  double *pdVar21;
  undefined8 *puVar22;
  undefined2 *puVar23;
  byte *pbVar24;
  int iVar25;
  uint uVar26;
  int iVar27;
  int iVar28;
  int iVar29;
  int iVar30;
  uint uVar31;
  int iVar32;
  undefined8 *puVar33;
  int iVar34;
  int iVar35;
  bool bVar36;
  double dVar37;
  double dVar38;
  double dVar39;
  double dVar40;
  double dVar41;
  undefined2 uVar42;
  double in_d17;
  undefined1 auVar43 [16];
  undefined1 auVar44 [16];
  undefined8 uVar45;
  int *local_84;
  int *local_80;
  int *local_7c;
  uint *local_78;
  int *local_74;
  uint *local_70;
  int *local_6c;
  int *local_68;
  int *local_64;
  uint *local_60;
  int local_5c;
  
  local_5c = __stack_chk_guard;
  piVar3 = (int *)param_3[1];
  piVar9 = (int *)param_1[1];
  uVar31 = *(uint *)param_2[1];
  iVar12 = *piVar3;
  iVar25 = piVar3[1];
  iVar29 = *piVar9;
  iVar28 = piVar9[1];
  *piVar3 = uVar31 - 1;
  piVar3[1] = piVar9[1] + 1;
  emxEnsureCapacity_real_T(param_3,iVar25 * iVar12);
  iVar12 = (*(int *)param_2[1] + -1) * (*(int *)(param_1[1] + 4) + 1);
  if (0 < iVar12) {
    FUN_00022030(*param_3,iVar12 * 8);
  }
  emxInit_real_T(&local_60,1);
  emxInit_boolean_T1(&local_64,2);
  emxInit_real_T1(&local_68,2);
  emxInit_real_T1(&local_6c,2);
  emxInit_real_T1(&local_70,2);
  emxInit_real_T1(&local_74,2);
  emxInit_real_T(&local_78,1);
  emxInit_boolean_T(&local_7c,1);
  emxInit_boolean_T(&local_80,1);
  emxInit_real_T(&local_84,1);
  puVar5 = (uint *)param_1[1];
  uVar10 = puVar5[1];
  if (-1 < (int)uVar10) {
    iVar30 = 0;
    dVar37 = (double)(longlong)iVar29;
    iVar25 = *(int *)param_2[1];
    dVar38 = (double)(longlong)iVar28;
    dVar39 = dVar38 * dVar37;
    iVar12 = 0;
    do {
      iVar28 = iVar12 * 8;
      dVar41 = (double)(longlong)iVar12 + 1.0;
      if (dVar41 == dVar38 || dVar41 < dVar38 != (NAN(dVar41) || NAN(dVar38))) {
        uVar26 = *puVar5;
        uVar10 = *(uint *)local_60[1];
        *(uint *)local_60[1] = uVar26;
        emxEnsureCapacity_real_T1(local_60,uVar10);
        dVar40 = dVar37;
        if (0 < (int)uVar26) {
          uVar10 = *param_1;
          iVar29 = *(int *)param_1[1];
          pdVar18 = (double *)*local_60;
          if ((uVar26 == 1) ||
             ((pdVar18 < (double *)(iVar29 * iVar28 + uVar10 + uVar26 * 8) &&
              ((double *)(iVar29 * iVar28 + uVar10) < pdVar18 + uVar26)))) {
            uVar13 = 0;
          }
          else {
            pdVar15 = (double *)(iVar29 * iVar30 + uVar10);
            uVar13 = uVar26 & 0xfffffffe;
            pdVar21 = pdVar18;
            uVar17 = uVar13;
            do {
              dVar41 = *pdVar15;
              in_d17 = pdVar15[1];
              pdVar15 = pdVar15 + 2;
              uVar17 = uVar17 - 2;
              *pdVar21 = dVar41;
              pdVar21[1] = in_d17;
              pdVar21 = pdVar21 + 2;
            } while (uVar17 != 0);
            if (uVar26 == uVar13) goto LAB_0001eb4e;
          }
          iVar27 = uVar26 - uVar13;
          pdVar21 = (double *)(uVar10 + (iVar29 * iVar12 + uVar13) * 8);
          pdVar18 = pdVar18 + uVar13;
          do {
            dVar41 = *pdVar21;
            pdVar21 = pdVar21 + 1;
            iVar27 = iVar27 + -1;
            *pdVar18 = dVar41;
            pdVar18 = pdVar18 + 1;
          } while (iVar27 != 0);
        }
      }
      else {
        iVar29 = *(int *)local_60[1];
        *(int *)local_60[1] = *puVar5 * uVar10;
        emxEnsureCapacity_real_T1(local_60,iVar29);
        uVar10 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        dVar40 = dVar39;
        if (0 < (int)uVar10) {
          pdVar18 = (double *)*param_1;
          pdVar21 = (double *)*local_60;
          if (uVar10 == 1) {
LAB_0001eb2c:
            uVar26 = 0;
          }
          else {
            pdVar15 = pdVar18 + uVar10;
            bVar36 = pdVar21 < pdVar15;
            if (bVar36) {
              pdVar15 = pdVar21 + uVar10;
            }
            if (bVar36 && pdVar18 < pdVar15) goto LAB_0001eb2c;
            uVar26 = uVar10 & 0xfffffffe;
            pdVar15 = pdVar18;
            pdVar8 = pdVar21;
            uVar13 = uVar26;
            do {
              dVar41 = *pdVar15;
              in_d17 = pdVar15[1];
              pdVar15 = pdVar15 + 2;
              uVar13 = uVar13 - 2;
              *pdVar8 = dVar41;
              pdVar8[1] = in_d17;
              pdVar8 = pdVar8 + 2;
            } while (uVar13 != 0);
            if (uVar10 - uVar26 == 0) goto LAB_0001eb4e;
          }
          pdVar18 = pdVar18 + uVar26;
          pdVar21 = pdVar21 + uVar26;
          iVar29 = uVar10 - uVar26;
          do {
            dVar41 = *pdVar18;
            pdVar18 = pdVar18 + 1;
            iVar29 = iVar29 + -1;
            *pdVar21 = dVar41;
            pdVar21 = pdVar21 + 1;
          } while (iVar29 != 0);
        }
      }
LAB_0001eb4e:
      piVar3 = (int *)local_70[1];
      piVar9 = (int *)local_60[1];
      iVar29 = *piVar3;
      iVar27 = piVar3[1];
      *piVar3 = 1;
      piVar3[1] = *piVar9;
      emxEnsureCapacity_real_T(local_70,iVar27 * iVar29);
      uVar10 = *(uint *)local_60[1];
      if ((int)uVar10 < 1) {
        piVar3 = (int *)local_70[1];
      }
      else {
        pdVar21 = (double *)*local_60;
        uVar26 = 0;
        pdVar18 = (double *)*local_70;
        piVar3 = (int *)local_70[1];
        iVar29 = *piVar3;
        if ((uVar10 != 1) && (iVar29 == 1)) {
          pdVar15 = pdVar21 + uVar10;
          bVar36 = pdVar18 < pdVar15;
          if (bVar36) {
            pdVar15 = pdVar18 + uVar10;
          }
          if (bVar36 && pdVar21 < pdVar15) {
            uVar26 = 0;
          }
          else {
            uVar26 = uVar10 & 0xfffffffe;
            pdVar15 = pdVar18;
            uVar13 = uVar26;
            pdVar8 = pdVar21;
            do {
              dVar41 = *pdVar8;
              in_d17 = pdVar8[1];
              pdVar8 = pdVar8 + 2;
              uVar13 = uVar13 - 2;
              *pdVar15 = dVar41;
              pdVar15[1] = in_d17;
              pdVar15 = pdVar15 + 2;
            } while (uVar13 != 0);
            if (uVar10 == uVar26) goto LAB_0001ebfa;
          }
        }
        pdVar21 = pdVar21 + uVar26;
        iVar27 = uVar10 - uVar26;
        pdVar18 = pdVar18 + uVar26 * iVar29;
        do {
          dVar41 = *pdVar21;
          pdVar21 = pdVar21 + 1;
          iVar27 = iVar27 + -1;
          *pdVar18 = dVar41;
          pdVar18 = pdVar18 + iVar29;
        } while (iVar27 != 0);
      }
LAB_0001ebfa:
      uVar13 = piVar3[1];
      puVar5 = (uint *)local_68[1];
      uVar10 = *puVar5;
      uVar26 = puVar5[1];
      *puVar5 = uVar31;
      puVar5[1] = uVar13;
      emxEnsureCapacity_real_T(local_68,uVar26 * uVar10);
      iVar29 = *(int *)(local_70[1] + 4);
      if (((0 < iVar29) && (uVar13 != 0)) && (uVar31 != 0 && iVar29 != 0)) {
        iVar14 = 0;
        iVar19 = -1;
        iVar4 = 0;
        iVar27 = 1;
        do {
          if (0 < (int)uVar31) {
            iVar32 = *local_68;
            pdVar18 = (double *)(*local_70 + iVar4 * 8);
            if ((uVar31 == 1) ||
               ((iVar32 + uVar31 * iVar4 * 8 < (int)pdVar18 + 1U &&
                (pdVar18 < (double *)(iVar32 + (uVar31 * iVar4 + uVar31) * 8))))) {
              uVar10 = 1;
            }
            else {
              dVar41 = *pdVar18;
              pdVar21 = (double *)(iVar32 + iVar14 * 8);
              uVar10 = uVar31 & 0xfffffffe;
              do {
                *pdVar21 = dVar41;
                pdVar21[1] = dVar41;
                pdVar21 = pdVar21 + 2;
                uVar10 = uVar10 - 2;
              } while (uVar10 != 0);
              uVar10 = uVar31 | 1;
              in_d17 = dVar41;
              if (uVar31 == (uVar31 & 0xfffffffe)) goto LAB_0001efe8;
            }
            iVar34 = (uVar31 + 1) - uVar10;
            pdVar21 = (double *)(iVar32 + (uVar10 + iVar19) * 8);
            do {
              dVar41 = *pdVar18;
              iVar34 = iVar34 + -1;
              *pdVar21 = dVar41;
              pdVar21 = pdVar21 + 1;
            } while (iVar34 != 0);
          }
LAB_0001efe8:
          iVar19 = iVar19 + uVar31;
          iVar14 = iVar14 + uVar31;
          iVar4 = iVar4 + 1;
          bVar36 = iVar27 != iVar29;
          iVar27 = iVar27 + 1;
        } while (bVar36);
      }
      iVar29 = (int)(longlong)dVar40;
      piVar3 = (int *)local_6c[1];
      iVar27 = *piVar3;
      iVar14 = piVar3[1];
      *piVar3 = iVar25;
      piVar3[1] = iVar29;
      emxEnsureCapacity_real_T(local_6c,iVar14 * iVar27);
      if (0 < iVar29) {
        uVar10 = extraout_r1;
        if (iVar25 != 0) {
          uVar10 = *(uint *)param_2[1];
        }
        if (iVar25 != 0 && uVar10 != 0) {
          iVar4 = 0;
          iVar14 = -1;
          iVar19 = 0;
          iVar27 = 1;
          do {
            if (0 < (int)uVar10) {
              iVar32 = *local_6c;
              pdVar18 = (double *)*param_2;
              if (uVar10 == 1) {
LAB_0001efae:
                uVar26 = 1;
              }
              else {
                pdVar21 = (double *)(iVar32 + uVar10 * iVar19 * 8);
                bVar36 = pdVar21 < pdVar18 + uVar10;
                if (bVar36) {
                  pdVar21 = (double *)(iVar32 + (uVar10 * iVar19 + uVar10) * 8);
                }
                if (bVar36 && pdVar18 < pdVar21) goto LAB_0001efae;
                pdVar15 = (double *)(iVar32 + iVar4 * 8);
                uVar26 = uVar10 & 0xfffffffe;
                pdVar21 = pdVar18;
                do {
                  dVar41 = *pdVar21;
                  in_d17 = pdVar21[1];
                  pdVar21 = pdVar21 + 2;
                  uVar26 = uVar26 - 2;
                  *pdVar15 = dVar41;
                  pdVar15[1] = in_d17;
                  pdVar15 = pdVar15 + 2;
                } while (uVar26 != 0);
                uVar26 = uVar10 | 1;
                if (uVar10 == (uVar10 & 0xfffffffe)) goto LAB_0001ef50;
              }
              iVar34 = (uVar10 + 1) - uVar26;
              pdVar21 = (double *)(iVar32 + (uVar26 + iVar14) * 8);
              pdVar18 = pdVar18 + (uVar26 - 1);
              do {
                dVar41 = *pdVar18;
                pdVar18 = pdVar18 + 1;
                iVar34 = iVar34 + -1;
                *pdVar21 = dVar41;
                pdVar21 = pdVar21 + 1;
              } while (iVar34 != 0);
            }
LAB_0001ef50:
            iVar14 = iVar14 + uVar10;
            iVar4 = iVar4 + uVar10;
            iVar19 = iVar19 + 1;
            bVar36 = iVar27 != iVar29;
            iVar27 = iVar27 + 1;
          } while (bVar36);
        }
      }
      piVar3 = (int *)local_64[1];
      piVar9 = (int *)local_68[1];
      iVar29 = *piVar3;
      iVar27 = piVar3[1];
      *piVar3 = *piVar9;
      piVar3[1] = piVar9[1];
      emxEnsureCapacity_boolean_T1(local_64,iVar27 * iVar29);
      iVar29 = *(int *)local_68[1] * ((int *)local_68[1])[1];
      if (0 < iVar29) {
        in_d17 = *(double *)*local_68;
        dVar41 = *(double *)*local_6c;
        *(bool *)*local_64 = in_d17 < dVar41 == (NAN(in_d17) || NAN(dVar41));
        if (iVar29 != 1) {
          iVar27 = 1;
          iVar14 = 8;
          do {
            in_d17 = *(double *)(*local_68 + iVar14);
            dVar41 = *(double *)(*local_6c + iVar14);
            iVar14 = iVar14 + 8;
            *(bool *)(*local_64 + iVar27) = in_d17 < dVar41 == (NAN(in_d17) || NAN(dVar41));
            iVar27 = iVar27 + 1;
          } while (iVar29 - iVar27 != 0);
        }
      }
      piVar3 = (int *)local_64[1];
      iVar29 = *piVar3;
      if ((iVar29 == 0) || (iVar29 < 2)) {
        iVar27 = piVar3[1];
        piVar3 = (int *)local_74[1];
        iVar29 = *piVar3;
        iVar14 = piVar3[1];
        *piVar3 = 0;
        piVar3[1] = iVar27;
        emxEnsureCapacity_real_T(local_74,iVar14 * iVar29);
      }
      else {
        uVar26 = iVar29 - 1;
        puVar5 = (uint *)local_74[1];
        uVar10 = *puVar5;
        uVar13 = puVar5[1];
        *puVar5 = uVar26;
        puVar5[1] = piVar3[1];
        emxEnsureCapacity_real_T(local_74,uVar13 * uVar10);
        piVar3 = (int *)local_74[1];
        iVar27 = *piVar3;
        if (iVar27 != 0) {
          piVar3 = (int *)piVar3[1];
        }
        if ((iVar27 != 0 && piVar3 != (int *)0x0) &&
           (iVar27 = *(int *)(local_64[1] + 4), 0 < iVar27)) {
          pdVar21 = (double *)*local_74;
          iVar19 = *local_64;
          uVar10 = uVar26 & 0xfffffffe;
          iVar34 = 0;
          iVar32 = 0;
          iVar4 = 0;
          puVar11 = (undefined2 *)(iVar19 + 1);
          pdVar18 = pdVar21;
          iVar14 = 1;
          do {
            uVar13 = (uint)*(byte *)(iVar19 + iVar4);
            if (uVar26 < 2) {
LAB_0001f1c0:
              iVar16 = 2;
              iVar20 = iVar4;
              iVar35 = iVar32;
LAB_0001f1c6:
              iVar16 = (iVar29 + 1) - iVar16;
              pdVar15 = pdVar21 + iVar35;
              pbVar24 = (byte *)(iVar19 + 1 + iVar20);
              do {
                bVar1 = *pbVar24;
                iVar16 = iVar16 + -1;
                dVar41 = (double)(longlong)(int)(bVar1 - uVar13);
                *pdVar15 = dVar41;
                pdVar15 = pdVar15 + 1;
                pbVar24 = pbVar24 + 1;
                uVar13 = (uint)bVar1;
              } while (iVar16 != 0);
            }
            else {
              pdVar8 = (double *)(iVar29 * iVar34);
              pdVar15 = (double *)((iVar29 * 8 + -8) * iVar34);
              bVar36 = (double *)((int)pdVar21 + (int)pdVar15) <
                       (double *)((int)pdVar8 + iVar19 + iVar29);
              if (bVar36) {
                pdVar15 = (double *)((int)pdVar15 + (int)(pdVar21 + uVar26));
                pdVar8 = (double *)((int)pdVar8 + iVar19 + 1);
              }
              if (bVar36 && pdVar8 < pdVar15) goto LAB_0001f1c0;
              pdVar15 = pdVar18;
              puVar23 = puVar11;
              uVar13 = uVar10;
              dVar40 = (double)((ulonglong)dVar41 & 0xffff0000ffffffff);
              do {
                uVar13 = uVar13 - 2;
                    // WARNING: Ignoring partial resolution of indirect
                uVar42 = *puVar23;
                auVar43 = VectorCopyLong(in_d17,1,1);
                auVar44 = VectorCopyLong(auVar43._0_8_,2,1);
                dVar41 = auVar44._0_8_;
                auVar43._8_8_ = dVar41;
                auVar43._0_8_ = dVar40;
                uVar45 = VectorSub(dVar41,auVar43._4_8_,4);
                in_d17 = (double)(longlong)(int)((ulonglong)uVar45 >> 0x20);
                *pdVar15 = (double)(longlong)(int)uVar45;
                pdVar15[1] = in_d17;
                pdVar15 = pdVar15 + 2;
                puVar23 = puVar23 + 1;
                dVar40 = dVar41;
              } while (uVar13 != 0);
              if (uVar26 != uVar10) {
                uVar13 = auVar44._4_4_;
                iVar16 = uVar10 + 2;
                iVar20 = iVar4 + uVar10;
                iVar35 = iVar32 + uVar10;
                goto LAB_0001f1c6;
              }
            }
            iVar34 = iVar34 + 1;
            pdVar18 = pdVar18 + iVar29 + -1;
            puVar11 = (undefined2 *)((int)puVar11 + iVar29);
            iVar32 = iVar32 + uVar26;
            iVar4 = iVar4 + iVar29;
            bVar36 = iVar14 != iVar27;
            iVar14 = iVar14 + 1;
          } while (bVar36);
        }
      }
      emxEnsureCapacity_real_T(local_74,*(int *)local_74[1] * ((int *)local_74[1])[1]);
      piVar3 = (int *)local_74[1];
      iVar14 = *piVar3;
      iVar29 = piVar3[1];
      iVar27 = iVar29 * iVar14;
      if (0 < iVar27) {
        pdVar18 = (double *)*local_74;
        do {
          iVar27 = iVar27 + -1;
          *pdVar18 = -*pdVar18;
          pdVar18 = pdVar18 + 1;
        } while (iVar27 != 0);
      }
      if (iVar14 == 0 || iVar29 == 0) {
        iVar27 = *piVar3;
        iVar29 = *(int *)local_78[1];
        *(int *)local_78[1] = iVar27;
        emxEnsureCapacity_real_T1(local_78,iVar29);
        if (0 < iVar27) {
          FUN_00022030(*local_78,iVar27 << 3);
        }
      }
      else {
        iVar29 = *(int *)local_78[1];
        *(int *)local_78[1] = iVar14;
        emxEnsureCapacity_real_T1(local_78,iVar29);
        if (0 < iVar14) {
          pdVar18 = (double *)*local_74;
          pdVar21 = (double *)*local_78;
          iVar29 = iVar14;
          do {
            dVar41 = *pdVar18;
            pdVar18 = pdVar18 + 1;
            iVar29 = iVar29 + -1;
            *pdVar21 = (double)(longlong)(int)(longlong)dVar41;
            pdVar21 = pdVar21 + 1;
          } while (iVar29 != 0);
        }
        iVar29 = *(int *)(local_74[1] + 4);
        if (1 < iVar29) {
          iVar27 = iVar14;
          iVar4 = 2;
          do {
            if (0 < iVar14) {
              pdVar21 = (double *)*local_78;
              pdVar18 = (double *)(*local_74 + iVar27 * 8);
              iVar19 = iVar14;
              do {
                dVar41 = *pdVar18;
                pdVar18 = pdVar18 + 1;
                in_d17 = *pdVar21;
                iVar19 = iVar19 + -1;
                *pdVar21 = in_d17 + (double)(longlong)(int)(longlong)dVar41;
                pdVar21 = pdVar21 + 1;
              } while (iVar19 != 0);
            }
            iVar27 = iVar27 + iVar14;
            bVar36 = iVar4 != iVar29;
            iVar4 = iVar4 + 1;
          } while (bVar36);
        }
      }
      uVar6 = *(undefined4 *)local_7c[1];
      *(undefined4 *)local_7c[1] = *(undefined4 *)local_60[1];
      emxEnsureCapacity_boolean_T(local_7c,uVar6);
      iVar29 = *(int *)local_60[1];
      if (0 < iVar29) {
        uVar2 = rtIsNaN((int)*(undefined8 *)*local_60,
                        (int)((ulonglong)*(undefined8 *)*local_60 >> 0x20));
        *(undefined1 *)*local_7c = uVar2;
        if (iVar29 != 1) {
          iVar27 = 1;
          iVar14 = 8;
          do {
            uVar2 = rtIsNaN((int)*(undefined8 *)(*local_60 + iVar14),
                            (int)((ulonglong)*(undefined8 *)(*local_60 + iVar14) >> 0x20));
            iVar14 = iVar14 + 8;
            *(undefined1 *)(*local_7c + iVar27) = uVar2;
            iVar27 = iVar27 + 1;
          } while (iVar29 != iVar27);
        }
      }
      uVar6 = *(undefined4 *)local_80[1];
      *(undefined4 *)local_80[1] = *(undefined4 *)local_7c[1];
      emxEnsureCapacity_boolean_T(local_80,uVar6);
      iVar29 = *(int *)local_7c[1];
      if ((0 < iVar29) && (*(bool *)*local_80 = *(char *)*local_7c == '\0', iVar29 != 1)) {
        iVar27 = 1;
        do {
          *(bool *)(*local_80 + iVar27) = *(char *)(*local_7c + iVar27) == '\0';
          iVar27 = iVar27 + 1;
        } while (iVar29 != iVar27);
      }
      uVar6 = *(undefined4 *)local_84[1];
      *(undefined4 *)local_84[1] = *(undefined4 *)local_78[1];
      emxEnsureCapacity_real_T1(local_84,uVar6);
      piVar3 = local_84;
      iVar29 = *(int *)local_78[1];
      if (0 < iVar29) {
        pdVar18 = (double *)*local_78;
        pdVar21 = (double *)*local_84;
        do {
          dVar41 = *pdVar18;
          pdVar18 = pdVar18 + 1;
          iVar29 = iVar29 + -1;
          *pdVar21 = dVar41 * 100.0;
          pdVar21 = pdVar21 + 1;
        } while (iVar29 != 0);
      }
      uVar45 = c_sum(local_80);
      uVar6 = (undefined4)((ulonglong)uVar45 >> 0x20);
      rdivide(piVar3,uVar6,(int)uVar45,uVar6);
      uVar10 = *(uint *)local_78[1];
      if (0 < (int)uVar10) {
        puVar33 = (undefined8 *)*local_78;
        iVar29 = *param_3;
        iVar27 = *(int *)param_3[1];
        if ((uVar10 == 1) ||
           (((undefined8 *)(iVar27 * iVar28 + iVar29) < puVar33 + uVar10 &&
            (puVar33 < (undefined8 *)(iVar27 * iVar28 + iVar29 + uVar10 * 8))))) {
          uVar26 = 0;
        }
        else {
          puVar22 = (undefined8 *)(iVar27 * iVar30 + iVar29);
          uVar26 = uVar10 & 0xfffffffe;
          puVar7 = puVar33;
          uVar13 = uVar26;
          do {
            uVar45 = *puVar7;
            in_d17 = (double)puVar7[1];
            puVar7 = puVar7 + 2;
            uVar13 = uVar13 - 2;
            *puVar22 = uVar45;
            puVar22[1] = in_d17;
            puVar22 = puVar22 + 2;
          } while (uVar13 != 0);
          if (uVar10 == uVar26) goto LAB_0001ea32;
        }
        iVar28 = uVar10 - uVar26;
        puVar7 = (undefined8 *)(iVar29 + (iVar27 * iVar12 + uVar26) * 8);
        puVar33 = puVar33 + uVar26;
        do {
          uVar45 = *puVar33;
          puVar33 = puVar33 + 1;
          iVar28 = iVar28 + -1;
          *puVar7 = uVar45;
          puVar7 = puVar7 + 1;
        } while (iVar28 != 0);
      }
LAB_0001ea32:
      puVar5 = (uint *)param_1[1];
      iVar30 = iVar30 + 8;
      uVar10 = puVar5[1];
      bVar36 = iVar12 < (int)uVar10;
      iVar12 = iVar12 + 1;
    } while (bVar36);
  }
  emxFree_real_T(&local_84);
  emxFree_boolean_T(&local_80);
  emxFree_boolean_T(&local_7c);
  emxFree_real_T(&local_78);
  emxFree_real_T(&local_74);
  emxFree_real_T(&local_70);
  emxFree_real_T(&local_6c);
  emxFree_real_T(&local_68);
  emxFree_boolean_T(&local_64);
  emxFree_real_T(&local_60);
  if (__stack_chk_guard != local_5c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void b_PT(uint *param_1,int *param_2)

{
  byte bVar1;
  byte bVar2;
  undefined1 uVar3;
  int *piVar4;
  int iVar5;
  uint *puVar6;
  undefined4 *puVar7;
  undefined4 uVar8;
  int *piVar9;
  uint uVar10;
  undefined8 *puVar11;
  int iVar12;
  uint uVar13;
  double *pdVar14;
  uint uVar15;
  undefined8 *puVar16;
  int iVar17;
  undefined8 *puVar18;
  byte *pbVar19;
  uint uVar20;
  double *pdVar21;
  undefined8 *puVar22;
  int iVar23;
  bool bVar24;
  double dVar25;
  double dVar26;
  double dVar27;
  double dVar28;
  double dVar29;
  double dVar30;
  double dVar31;
  double dVar32;
  undefined8 uVar33;
  undefined8 uVar34;
  int local_98;
  int *local_8c;
  int *local_88;
  int *local_84;
  uint *local_80;
  int *local_7c;
  int *local_78;
  int *local_74;
  uint *local_70;
  int local_6c;
  
  local_6c = __stack_chk_guard;
  piVar4 = (int *)param_2[1];
  piVar9 = (int *)param_1[1];
  iVar5 = *piVar4;
  iVar12 = piVar4[1];
  iVar17 = *piVar9;
  iVar23 = piVar9[1];
  *piVar4 = 4;
  piVar4[1] = piVar9[1] + 1;
  emxEnsureCapacity_real_T(param_2,iVar12 * iVar5);
  if (0 < *(int *)(param_1[1] + 4) * 4 + 4) {
    FUN_00022030(*param_2,*(int *)(param_1[1] + 4) * 0x20 + 0x20);
  }
  emxInit_real_T(&local_70,1);
  emxInit_boolean_T1(&local_74,2);
  emxInit_real_T1(&local_78,2);
  emxInit_real_T1(&local_7c,2);
  emxInit_real_T1(&local_80,2);
  emxInit_real_T1(&local_84,2);
  emxInit_boolean_T(&local_88,1);
  emxInit_boolean_T(&local_8c,1);
  puVar6 = (uint *)param_1[1];
  uVar10 = puVar6[1];
  if (-1 < (int)uVar10) {
    dVar25 = (double)(longlong)iVar17;
    local_98 = 0;
    dVar26 = (double)(longlong)iVar23;
    dVar27 = dVar26 * dVar25;
    iVar5 = 0;
    do {
      dVar32 = (double)(longlong)iVar5 + 1.0;
      if (dVar32 == dVar26 || dVar32 < dVar26 != (NAN(dVar32) || NAN(dVar26))) {
        uVar20 = *puVar6;
        puVar6 = (uint *)local_70[1];
        uVar10 = *puVar6;
        *puVar6 = uVar20;
        emxEnsureCapacity_real_T1(local_70,uVar10,puVar6,iVar5);
        dVar32 = dVar25;
        if (0 < (int)uVar20) {
          uVar10 = *param_1;
          iVar12 = *(int *)param_1[1];
          puVar16 = (undefined8 *)*local_70;
          if ((uVar20 == 1) ||
             ((puVar16 < (undefined8 *)(iVar12 * iVar5 * 8 + uVar10 + uVar20 * 8) &&
              ((undefined8 *)(iVar12 * iVar5 * 8 + uVar10) < puVar16 + uVar20)))) {
            uVar13 = 0;
          }
          else {
            uVar13 = uVar20 & 0xfffffffe;
            puVar22 = (undefined8 *)(iVar12 * local_98 + uVar10);
            puVar18 = puVar16;
            uVar15 = uVar13;
            do {
              uVar33 = *puVar22;
              uVar34 = puVar22[1];
              puVar22 = puVar22 + 2;
              uVar15 = uVar15 - 2;
              *puVar18 = uVar33;
              puVar18[1] = uVar34;
              puVar18 = puVar18 + 2;
            } while (uVar15 != 0);
            if (uVar20 == uVar13) goto LAB_0001f4c8;
          }
          iVar17 = uVar20 - uVar13;
          puVar18 = (undefined8 *)(uVar10 + (iVar12 * iVar5 + uVar13) * 8);
          puVar16 = puVar16 + uVar13;
          do {
            uVar33 = *puVar18;
            puVar18 = puVar18 + 1;
            iVar17 = iVar17 + -1;
            *puVar16 = uVar33;
            puVar16 = puVar16 + 1;
          } while (iVar17 != 0);
        }
      }
      else {
        iVar12 = *(int *)local_70[1];
        *(int *)local_70[1] = *puVar6 * uVar10;
        emxEnsureCapacity_real_T1(local_70,iVar12);
        uVar10 = *(int *)param_1[1] * ((int *)param_1[1])[1];
        dVar32 = dVar27;
        if (0 < (int)uVar10) {
          puVar18 = (undefined8 *)*local_70;
          puVar16 = (undefined8 *)*param_1;
          if (uVar10 == 1) {
LAB_0001f4a6:
            uVar20 = 0;
          }
          else {
            puVar22 = puVar16 + uVar10;
            bVar24 = puVar18 < puVar22;
            if (bVar24) {
              puVar22 = puVar18 + uVar10;
            }
            if (bVar24 && puVar16 < puVar22) goto LAB_0001f4a6;
            uVar20 = uVar10 & 0xfffffffe;
            puVar22 = puVar16;
            puVar11 = puVar18;
            uVar13 = uVar20;
            do {
              uVar33 = *puVar22;
              uVar34 = puVar22[1];
              puVar22 = puVar22 + 2;
              uVar13 = uVar13 - 2;
              *puVar11 = uVar33;
              puVar11[1] = uVar34;
              puVar11 = puVar11 + 2;
            } while (uVar13 != 0);
            if (uVar10 - uVar20 == 0) goto LAB_0001f4c8;
          }
          puVar16 = puVar16 + uVar20;
          puVar18 = puVar18 + uVar20;
          iVar12 = uVar10 - uVar20;
          do {
            uVar33 = *puVar16;
            puVar16 = puVar16 + 1;
            iVar12 = iVar12 + -1;
            *puVar18 = uVar33;
            puVar18 = puVar18 + 1;
          } while (iVar12 != 0);
        }
      }
LAB_0001f4c8:
      piVar4 = (int *)local_80[1];
      piVar9 = (int *)local_70[1];
      iVar12 = *piVar4;
      iVar17 = piVar4[1];
      *piVar4 = 1;
      piVar4[1] = *piVar9;
      emxEnsureCapacity_real_T(local_80,iVar17 * iVar12);
      uVar10 = *(uint *)local_70[1];
      if ((int)uVar10 < 1) {
        piVar4 = (int *)local_80[1];
      }
      else {
        puVar18 = (undefined8 *)*local_70;
        uVar20 = 0;
        puVar16 = (undefined8 *)*local_80;
        piVar4 = (int *)local_80[1];
        iVar12 = *piVar4;
        if ((uVar10 != 1) && (iVar12 == 1)) {
          puVar22 = puVar18 + uVar10;
          bVar24 = puVar16 < puVar22;
          if (bVar24) {
            puVar22 = puVar16 + uVar10;
          }
          if (bVar24 && puVar18 < puVar22) {
            uVar20 = 0;
          }
          else {
            uVar20 = uVar10 & 0xfffffffe;
            puVar22 = puVar16;
            puVar11 = puVar18;
            uVar13 = uVar20;
            do {
              uVar33 = *puVar11;
              uVar34 = puVar11[1];
              puVar11 = puVar11 + 2;
              uVar13 = uVar13 - 2;
              *puVar22 = uVar33;
              puVar22[1] = uVar34;
              puVar22 = puVar22 + 2;
            } while (uVar13 != 0);
            if (uVar10 == uVar20) goto LAB_0001f572;
          }
        }
        puVar18 = puVar18 + uVar20;
        iVar17 = uVar10 - uVar20;
        puVar16 = puVar16 + uVar20 * iVar12;
        do {
          uVar33 = *puVar18;
          puVar18 = puVar18 + 1;
          iVar17 = iVar17 + -1;
          *puVar16 = uVar33;
          puVar16 = puVar16 + iVar12;
        } while (iVar17 != 0);
      }
LAB_0001f572:
      iVar23 = piVar4[1];
      piVar4 = (int *)local_78[1];
      iVar12 = *piVar4;
      iVar17 = piVar4[1];
      *piVar4 = 5;
      piVar4[1] = iVar23;
      emxEnsureCapacity_real_T(local_78,iVar17 * iVar12);
      if ((iVar23 != 0) && (iVar12 = *(int *)(local_80[1] + 4), 0 < iVar12)) {
        puVar16 = (undefined8 *)*local_80;
        puVar18 = (undefined8 *)(*local_78 + 0x10);
        do {
          iVar12 = iVar12 + -1;
          puVar18[-2] = *puVar16;
          puVar18[-1] = *puVar16;
          *puVar18 = *puVar16;
          puVar18[1] = *puVar16;
          uVar33 = *puVar16;
          puVar16 = puVar16 + 1;
          puVar18[2] = uVar33;
          puVar18 = puVar18 + 5;
        } while (iVar12 != 0);
      }
      iVar12 = (int)(longlong)dVar32;
      piVar4 = (int *)local_7c[1];
      iVar17 = *piVar4;
      iVar23 = piVar4[1];
      *piVar4 = 5;
      piVar4[1] = iVar12;
      emxEnsureCapacity_real_T(local_7c,iVar23 * iVar17);
      if (0 < iVar12) {
        puVar7 = (undefined4 *)(*local_7c + 0x10);
        do {
          puVar7[-4] = 0;
          puVar7[-3] = 0;
          iVar12 = iVar12 + -1;
          puVar7[-2] = 0x33333333;
          puVar7[-1] = 0x400f3333;
          *puVar7 = 0xcccccccd;
          puVar7[1] = 0x4021cccc;
          puVar7[2] = 0;
          puVar7[3] = 0x40240000;
          puVar7[4] = 0;
          puVar7[5] = 0x403e0000;
          puVar7 = puVar7 + 10;
        } while (iVar12 != 0);
      }
      piVar4 = (int *)local_74[1];
      iVar17 = local_78[1];
      iVar12 = *piVar4;
      iVar23 = piVar4[1];
      *piVar4 = 5;
      piVar4[1] = *(int *)(iVar17 + 4);
      emxEnsureCapacity_boolean_T1(local_74,iVar23 * iVar12);
      iVar12 = *(int *)local_78[1] * ((int *)local_78[1])[1];
      if ((0 < iVar12) &&
         (*(bool *)*local_74 =
               *(double *)*local_78 < *(double *)*local_7c ==
               (NAN(*(double *)*local_78) || NAN(*(double *)*local_7c)), iVar12 != 1)) {
        iVar17 = 1;
        iVar23 = 8;
        do {
          pdVar14 = (double *)(*local_78 + iVar23);
          pdVar21 = (double *)(*local_7c + iVar23);
          iVar23 = iVar23 + 8;
          *(bool *)(*local_74 + iVar17) = *pdVar14 < *pdVar21 == (NAN(*pdVar14) || NAN(*pdVar21));
          iVar17 = iVar17 + 1;
        } while (iVar12 - iVar17 != 0);
      }
      piVar4 = (int *)local_84[1];
      iVar17 = local_74[1];
      iVar12 = *piVar4;
      iVar23 = piVar4[1];
      *piVar4 = 4;
      piVar4[1] = *(int *)(iVar17 + 4);
      emxEnsureCapacity_real_T(local_84,iVar23 * iVar12);
      piVar4 = (int *)local_84[1];
      iVar12 = piVar4[1];
      if ((iVar12 != 0) && (iVar17 = *(int *)(local_74[1] + 4), 0 < iVar17)) {
        pdVar14 = (double *)(*local_84 + 0x10);
        pbVar19 = (byte *)(*local_74 + 4);
        do {
          iVar17 = iVar17 + -1;
          bVar1 = pbVar19[-3];
          pdVar14[-2] = (double)(longlong)(int)((uint)bVar1 - (uint)pbVar19[-4]);
          bVar2 = pbVar19[-2];
          pdVar14[-1] = (double)(longlong)(int)((uint)bVar2 - (uint)bVar1);
          bVar1 = pbVar19[-1];
          *pdVar14 = (double)(longlong)(int)((uint)bVar1 - (uint)bVar2);
          pdVar14[1] = (double)(longlong)(int)((uint)*pbVar19 - (uint)bVar1);
          pdVar14 = pdVar14 + 4;
          pbVar19 = pbVar19 + 5;
        } while (iVar17 != 0);
      }
      iVar17 = *piVar4;
      *piVar4 = 4;
      emxEnsureCapacity_real_T(local_84,iVar17 * iVar12);
      iVar12 = ((int *)local_84[1])[1];
      iVar17 = iVar12 * *(int *)local_84[1];
      if (0 < iVar17) {
        pdVar14 = (double *)*local_84;
        do {
          iVar17 = iVar17 + -1;
          *pdVar14 = -*pdVar14;
          pdVar14 = pdVar14 + 1;
        } while (iVar17 != 0);
      }
      if (iVar12 == 0) {
        dVar32 = 0.0;
        dVar30 = 0.0;
        dVar29 = 0.0;
        dVar28 = 0.0;
      }
      else {
        pdVar14 = (double *)*local_84;
        dVar28 = (double)(longlong)(int)(longlong)pdVar14[3];
        dVar29 = (double)(longlong)(int)(longlong)pdVar14[2];
        dVar30 = (double)(longlong)(int)(longlong)pdVar14[1];
        dVar32 = (double)(longlong)(int)(longlong)*pdVar14;
        if (1 < iVar12) {
          iVar12 = iVar12 + -1;
          do {
            iVar12 = iVar12 + -1;
            dVar28 = dVar28 + (double)(longlong)(int)(longlong)pdVar14[7];
            dVar29 = dVar29 + (double)(longlong)(int)(longlong)pdVar14[6];
            dVar30 = dVar30 + (double)(longlong)(int)(longlong)pdVar14[5];
            dVar32 = dVar32 + (double)(longlong)(int)(longlong)pdVar14[4];
            pdVar14 = pdVar14 + 4;
          } while (iVar12 != 0);
        }
      }
      uVar8 = *(undefined4 *)local_88[1];
      *(undefined4 *)local_88[1] = *(undefined4 *)local_70[1];
      emxEnsureCapacity_boolean_T(local_88,uVar8);
      iVar12 = *(int *)local_70[1];
      if (0 < iVar12) {
        uVar3 = rtIsNaN((int)*(undefined8 *)*local_70,
                        (int)((ulonglong)*(undefined8 *)*local_70 >> 0x20));
        *(undefined1 *)*local_88 = uVar3;
        if (iVar12 != 1) {
          iVar17 = 1;
          iVar23 = 8;
          do {
            uVar3 = rtIsNaN((int)*(undefined8 *)(*local_70 + iVar23),
                            (int)((ulonglong)*(undefined8 *)(*local_70 + iVar23) >> 0x20));
            iVar23 = iVar23 + 8;
            *(undefined1 *)(*local_88 + iVar17) = uVar3;
            iVar17 = iVar17 + 1;
          } while (iVar12 != iVar17);
        }
      }
      uVar8 = *(undefined4 *)local_8c[1];
      *(undefined4 *)local_8c[1] = *(undefined4 *)local_88[1];
      emxEnsureCapacity_boolean_T(local_8c,uVar8);
      iVar12 = *(int *)local_88[1];
      if ((0 < iVar12) && (*(bool *)*local_8c = *(char *)*local_88 == '\0', iVar12 != 1)) {
        iVar17 = 1;
        do {
          *(bool *)(*local_8c + iVar17) = *(char *)(*local_88 + iVar17) == '\0';
          iVar17 = iVar17 + 1;
        } while (iVar12 != iVar17);
      }
      dVar31 = (double)c_sum(local_8c);
      puVar6 = (uint *)param_1[1];
      pdVar14 = (double *)(*param_2 + *(int *)param_2[1] * iVar5 * 8);
      uVar10 = puVar6[1];
      *pdVar14 = (dVar32 * 100.0) / dVar31;
      pdVar14[1] = (dVar30 * 100.0) / dVar31;
      pdVar14[2] = (dVar29 * 100.0) / dVar31;
      pdVar14[3] = (dVar28 * 100.0) / dVar31;
      local_98 = local_98 + 8;
      bVar24 = iVar5 < (int)uVar10;
      iVar5 = iVar5 + 1;
    } while (bVar24);
  }
  emxFree_boolean_T(&local_8c);
  emxFree_boolean_T(&local_88);
  emxFree_real_T(&local_84);
  emxFree_real_T(&local_80);
  emxFree_real_T(&local_7c);
  emxFree_real_T(&local_78);
  emxFree_boolean_T(&local_74);
  emxFree_real_T(&local_70);
  if (__stack_chk_guard != local_6c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void rdivide(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  int iVar1;
  undefined4 uVar2;
  double *pdVar3;
  double *pdVar4;
  double dVar5;
  
  uVar2 = *(undefined4 *)param_5[1];
  *(undefined4 *)param_5[1] = *(undefined4 *)param_1[1];
  emxEnsureCapacity_real_T1(param_5,uVar2);
  iVar1 = *(int *)param_1[1];
  if (0 < iVar1) {
    pdVar3 = (double *)*param_5;
    pdVar4 = (double *)*param_1;
    do {
      dVar5 = *pdVar4;
      pdVar4 = pdVar4 + 1;
      iVar1 = iVar1 + -1;
      *pdVar3 = dVar5 / (double)CONCAT44(param_4,param_3);
      pdVar3 = pdVar3 + 1;
    } while (iVar1 != 0);
  }
  return;
}



void rt_InitInfAndNaN(void)

{
  rtNaN = rtGetNaN();
  rtNaNF = rtGetNaNF();
  rtInf = rtGetInf();
  rtInfF = rtGetInfF();
  rtMinusInf = rtGetMinusInf();
  rtMinusInfF = rtGetMinusInfF();
  return;
}



bool rtIsInf(undefined4 param_1,undefined4 param_2)

{
  return rtInf == (double)CONCAT44(param_2,param_1) ||
         rtMinusInf == (double)CONCAT44(param_2,param_1);
}



bool rtIsInfF(float param_1)

{
  return rtInfF == param_1 || rtMinusInfF == param_1;
}



bool rtIsNaN(undefined4 param_1,undefined4 param_2)

{
  return NAN((double)CONCAT44(param_2,param_1));
}



bool rtIsNaNF(float param_1)

{
  return NAN(param_1);
}



undefined8 rtGetInf(void)

{
  return 0x7ff0000000000000;
}



undefined4 rtGetInfF(void)

{
  return 0x7f800000;
}



undefined8 rtGetMinusInf(void)

{
  return 0xfff0000000000000;
}



undefined4 rtGetMinusInfF(void)

{
  return 0xff800000;
}



undefined8 rtGetNaN(void)

{
  return 0xfff8000000000000;
}



undefined4 rtGetNaNF(void)

{
  return 0xffc00000;
}



// WARNING: Heritage AFTER dead removal. Example location: r0x00024b60 : 0x000203a8
// WARNING: Restarted to delay deadcode elimination for space: ram
// WARNING: Restarted to delay deadcode elimination for space: register
// WARNING: Restarted to delay deadcode elimination for space: stack
// WARNING: Exceeded maximum restarts with more pending

void SAFilter(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,double param_5,
             uint *param_6)

{
  undefined1 auVar1 [16];
  undefined1 auVar2 [32];
  byte bVar3;
  undefined1 uVar4;
  undefined8 *puVar5;
  int *piVar6;
  int iVar7;
  undefined4 *puVar8;
  char *pcVar9;
  undefined4 extraout_r1;
  int iVar10;
  undefined4 extraout_r1_00;
  uint uVar11;
  undefined8 *puVar12;
  undefined4 uVar13;
  undefined4 extraout_r1_01;
  undefined4 extraout_r1_02;
  uint uVar14;
  undefined8 *puVar15;
  double *pdVar16;
  int iVar17;
  undefined8 *puVar18;
  int iVar19;
  double *pdVar20;
  uint uVar21;
  int iVar22;
  double *pdVar23;
  int iVar24;
  int iVar25;
  int *piVar26;
  bool bVar27;
  uint in_fpscr;
  uint uVar28;
  double dVar29;
  double dVar30;
  undefined8 uVar31;
  double dVar32;
  undefined8 uVar33;
  double dVar34;
  double dVar35;
  double dVar36;
  double dVar37;
  undefined8 uVar39;
  double dVar40;
  undefined1 auVar38 [16];
  double dVar41;
  undefined4 uVar42;
  ulonglong uVar43;
  undefined1 in_q10 [16];
  undefined1 auVar44 [16];
  double in_stack_ffffff48;
  double local_b0;
  int *local_84;
  int *local_80;
  uint *local_7c;
  undefined4 local_78;
  int *local_74;
  int *local_70;
  int local_6c;
  
  local_6c = __stack_chk_guard;
  emxInit_real_T(&local_70,1);
  uVar42 = SUB84(param_5 * 0.5,0);
  floor(in_stack_ffffff48);
  dVar30 = (double)CONCAT44(extraout_r1,uVar42);
  uVar28 = (uint)(longlong)dVar30;
  iVar17 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  iVar10 = *(int *)local_70[1];
  uVar33 = *(undefined8 *)*param_1;
  uVar31 = ((undefined8 *)*param_1)[iVar17 + -1];
  *(int *)local_70[1] = iVar17 + uVar28 * 2;
  emxEnsureCapacity_real_T1(local_70,iVar10);
  uVar42 = SUB84((double)CONCAT44(param_4,param_3) * 0.5,0);
  floor(in_stack_ffffff48);
  if (0 < (int)uVar28) {
    puVar5 = (undefined8 *)*local_70;
    if (uVar28 == 1) {
      uVar11 = 0;
    }
    else {
      uVar11 = uVar28 & 0xfffffffe;
      uVar14 = uVar11;
      puVar18 = puVar5;
      do {
        *puVar18 = uVar33;
        puVar18[1] = uVar33;
        puVar18 = puVar18 + 2;
        uVar14 = uVar14 - 2;
      } while (uVar14 != 0);
      if (uVar11 == uVar28) goto LAB_0001fbaa;
    }
    puVar5 = puVar5 + uVar11;
    iVar10 = uVar28 - uVar11;
    do {
      *puVar5 = uVar33;
      puVar5 = puVar5 + 1;
      iVar10 = iVar10 + -1;
    } while (iVar10 != 0);
  }
LAB_0001fbaa:
  piVar26 = (int *)param_1[1];
  iVar10 = *piVar26;
  uVar14 = piVar26[1] * iVar10;
  if (0 < (int)uVar14) {
    puVar5 = (undefined8 *)*param_1;
    iVar17 = *local_70;
    if (uVar14 == 1) {
LAB_0001fbf8:
      uVar11 = 0;
    }
    else {
      puVar18 = puVar5 + uVar14;
      puVar12 = (undefined8 *)(iVar17 + uVar28 * 8);
      bVar27 = puVar12 < puVar18;
      if (bVar27) {
        puVar18 = (undefined8 *)(iVar17 + (uVar14 + uVar28) * 8);
      }
      if (bVar27 && puVar5 < puVar18) goto LAB_0001fbf8;
      uVar11 = uVar14 & 0xfffffffe;
      uVar21 = uVar11;
      puVar18 = puVar5;
      do {
        uVar33 = *puVar18;
        uVar39 = puVar18[1];
        puVar18 = puVar18 + 2;
        uVar21 = uVar21 - 2;
        *puVar12 = uVar33;
        puVar12[1] = uVar39;
        puVar12 = puVar12 + 2;
      } while (uVar21 != 0);
      if (uVar14 - uVar11 == 0) goto LAB_0001fc18;
    }
    puVar5 = puVar5 + uVar11;
    iVar24 = uVar14 - uVar11;
    puVar18 = (undefined8 *)(iVar17 + (uVar11 + uVar28) * 8);
    do {
      uVar33 = *puVar5;
      puVar5 = puVar5 + 1;
      iVar24 = iVar24 + -1;
      *puVar18 = uVar33;
      puVar18 = puVar18 + 1;
    } while (iVar24 != 0);
  }
LAB_0001fc18:
  if (0 < (int)uVar28) {
    iVar17 = *local_70;
    if (uVar28 == 1) {
      uVar21 = 0;
    }
    else {
      uVar21 = uVar28 & 0xfffffffe;
      puVar5 = (undefined8 *)(iVar17 + (uVar28 + uVar14) * 8);
      uVar11 = uVar21;
      do {
        *puVar5 = uVar31;
        puVar5[1] = uVar31;
        puVar5 = puVar5 + 2;
        uVar11 = uVar11 - 2;
      } while (uVar11 != 0);
      if (uVar21 == uVar28) goto LAB_0001fc5a;
    }
    iVar24 = uVar28 - uVar21;
    puVar5 = (undefined8 *)(iVar17 + (uVar21 + uVar28 + uVar14) * 8);
    do {
      *puVar5 = uVar31;
      puVar5 = puVar5 + 1;
      iVar24 = iVar24 + -1;
    } while (iVar24 != 0);
  }
LAB_0001fc5a:
  piVar6 = (int *)param_6[1];
  iVar17 = *piVar6;
  iVar24 = piVar6[1];
  *piVar6 = iVar10;
  piVar6[1] = piVar26[1];
  emxEnsureCapacity_real_T(param_6,iVar24 * iVar17);
  uVar28 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  if (0 < (int)uVar28) {
    puVar5 = (undefined8 *)*param_6;
    puVar18 = (undefined8 *)*param_1;
    if (uVar28 == 1) {
LAB_0001fcba:
      uVar14 = 0;
    }
    else {
      puVar12 = puVar18 + uVar28;
      bVar27 = puVar5 < puVar12;
      if (bVar27) {
        puVar12 = puVar5 + uVar28;
      }
      if (bVar27 && puVar18 < puVar12) goto LAB_0001fcba;
      uVar14 = uVar28 & 0xfffffffe;
      puVar12 = puVar5;
      puVar15 = puVar18;
      uVar11 = uVar14;
      do {
        uVar31 = *puVar15;
        uVar33 = puVar15[1];
        puVar15 = puVar15 + 2;
        uVar11 = uVar11 - 2;
        *puVar12 = uVar31;
        puVar12[1] = uVar33;
        puVar12 = puVar12 + 2;
      } while (uVar11 != 0);
      if (uVar28 - uVar14 == 0) goto LAB_0001fcd8;
    }
    puVar18 = puVar18 + uVar14;
    puVar5 = puVar5 + uVar14;
    iVar10 = uVar28 - uVar14;
    do {
      uVar31 = *puVar18;
      puVar18 = puVar18 + 1;
      iVar10 = iVar10 + -1;
      *puVar5 = uVar31;
      puVar5 = puVar5 + 1;
    } while (iVar10 != 0);
  }
LAB_0001fcd8:
  iVar10 = *(int *)local_70[1];
  emxInit_real_T1(&local_74,2);
  emxInit_real_T(&local_78,1);
  emxInit_real_T(&local_7c,1);
  iVar10 = (int)(longlong)((1.0 - (dVar30 + 1.0)) + ((double)(longlong)iVar10 - dVar30));
  if (0 < iVar10) {
    iVar17 = 0;
    dVar35 = 0.0;
    dVar34 = (double)CONCAT44(extraout_r1_00,uVar42);
    do {
      dVar29 = dVar30 + 1.0 + dVar35;
      dVar36 = dVar29 + -1.0;
      dVar32 = dVar29 + 1.0;
      uVar28 = in_fpscr & 0xfffffff | (uint)(dVar32 < dVar36) << 0x1f |
               (uint)(dVar32 == dVar36) << 0x1e | (uint)(dVar36 <= dVar32) << 0x1d;
      if ((int)uVar28 < 0) {
        piVar26 = (int *)local_74[1];
        iVar24 = *piVar26;
        iVar19 = piVar26[1];
        *piVar26 = 1;
        piVar26[1] = 0;
        emxEnsureCapacity_real_T(local_74,iVar19 * iVar24);
      }
      else {
        iVar24 = rtIsInf(SUB84(dVar36,0),(int)((ulonglong)dVar36 >> 0x20));
        if (iVar24 == 0) {
          iVar24 = rtIsInf(SUB84(dVar32,0),(int)((ulonglong)dVar32 >> 0x20));
          uVar28 = uVar28 & 0xfffffff | (uint)(dVar36 == dVar32) << 0x1e;
          if (((byte)(uVar28 >> 0x1e) != 0) && (iVar24 != 0)) goto LAB_0001fde2;
        }
        else {
          uVar28 = uVar28 & 0xfffffff | (uint)(dVar36 == dVar32) << 0x1e;
          if ((byte)(uVar28 >> 0x1e) != 0) {
LAB_0001fde2:
            piVar26 = (int *)local_74[1];
            iVar24 = *piVar26;
            iVar19 = piVar26[1];
            *piVar26 = 1;
            piVar26[1] = 1;
            emxEnsureCapacity_real_T(local_74,iVar19 * iVar24);
            *(undefined8 *)*local_74 = rtNaN;
            goto LAB_0001fe68;
          }
        }
        uVar31 = in_q10._8_8_;
        uVar28 = uVar28 & 0xfffffff | (uint)NAN(dVar36) << 0x1c;
        if ((byte)(uVar28 >> 0x1c) == 0) {
          piVar26 = (int *)local_74[1];
          iVar24 = *piVar26;
          iVar19 = piVar26[1];
          iVar22 = (int)(longlong)(dVar32 - dVar36);
          iVar25 = iVar22 + 1;
          *piVar26 = 1;
          piVar26[1] = iVar25;
          emxEnsureCapacity_real_T(local_74,iVar19 * iVar24);
          if (-1 < iVar22) {
            pdVar16 = (double *)*local_74;
            iVar19 = *(int *)local_74[1];
            iVar24 = 0;
            do {
              iVar22 = iVar24 + 1;
              *pdVar16 = dVar36 + (double)(longlong)iVar24;
              pdVar16 = pdVar16 + iVar19;
              iVar24 = iVar22;
            } while (iVar25 != iVar22);
          }
        }
        else {
          uVar13 = SUB84((dVar32 - dVar36) + 0.5,0);
          floor(in_stack_ffffff48);
          local_b0 = ABS(dVar32);
          in_stack_ffffff48 = ABS(dVar36);
          uVar28 = uVar28 & 0xfffffff | (uint)(in_stack_ffffff48 < local_b0) << 0x1f |
                   (uint)(in_stack_ffffff48 == local_b0) << 0x1e;
          uVar14 = uVar28 | (uint)(NAN(in_stack_ffffff48) || NAN(local_b0)) << 0x1c;
          bVar3 = (byte)(uVar28 >> 0x18);
          if ((!(bool)(bVar3 >> 6 & 1) && bVar3 >> 7 == ((byte)(uVar14 >> 0x1c) & 1)) ||
             (iVar24 = rtIsNaN(SUB84(local_b0,0),(int)((ulonglong)local_b0 >> 0x20)), iVar24 != 0))
          {
            local_b0 = in_stack_ffffff48;
          }
          dVar37 = (double)CONCAT44(extraout_r1_02,uVar13);
          dVar40 = dVar36 + dVar37;
          local_b0 = local_b0 * 4.440892098500626e-16;
          dVar41 = dVar40 - dVar32;
          in_q10._0_8_ = ABS(dVar41);
          in_q10._8_8_ = uVar31;
          uVar28 = uVar14 & 0xfffffff | (uint)(in_q10._0_8_ < local_b0) << 0x1f |
                   (uint)(in_q10._0_8_ == local_b0) << 0x1e |
                   (uint)(local_b0 <= in_q10._0_8_) << 0x1d;
          if ((int)uVar28 < 0) {
            dVar37 = dVar37 + 1.0;
            dVar40 = dVar32;
          }
          else {
            uVar14 = uVar14 & 0xfffffff | (uint)(dVar41 < 0.0) << 0x1f |
                     (uint)(dVar41 == 0.0) << 0x1e;
            uVar28 = uVar14 | (uint)NAN(dVar41) << 0x1c;
            bVar3 = (byte)(uVar14 >> 0x18);
            if ((bool)(bVar3 >> 6 & 1) || bVar3 >> 7 != ((byte)(uVar28 >> 0x1c) & 1)) {
              dVar37 = dVar37 + 1.0;
            }
            else {
              dVar40 = dVar36 + dVar37 + -1.0;
            }
          }
          uVar14 = uVar28 & 0xfffffff | (uint)(dVar37 < 0.0) << 0x1f | (uint)(dVar37 == 0.0) << 0x1e
          ;
          uVar28 = uVar14 | (uint)NAN(dVar37) << 0x1c;
          bVar3 = (byte)(uVar14 >> 0x18);
          dVar32 = 0.0;
          if (!(bool)(bVar3 >> 6 & 1) && bVar3 >> 7 == ((byte)(uVar28 >> 0x1c) & 1)) {
            dVar32 = dVar37;
          }
          iVar25 = (int)(longlong)dVar32;
          piVar26 = (int *)local_74[1];
          iVar24 = *piVar26;
          iVar19 = piVar26[1];
          *piVar26 = 1;
          piVar26[1] = iVar25;
          emxEnsureCapacity_real_T(local_74,iVar19 * iVar24);
          if (0 < iVar25) {
            pdVar16 = (double *)*local_74;
            *pdVar16 = dVar36;
            if (iVar25 != 1) {
              iVar19 = iVar25 + -1;
              pdVar16[iVar19] = dVar40;
              iVar24 = iVar19 / 2;
              if (4 < iVar25) {
                auVar38._8_8_ = dVar32;
                auVar38._0_8_ = 1.0;
                iVar22 = 2;
                if (2 < iVar24) {
                  iVar22 = iVar24;
                }
                pdVar20 = pdVar16 + iVar25 + -2;
                iVar22 = iVar22 + -1;
                pdVar23 = pdVar16;
                do {
                  pdVar23 = pdVar23 + 1;
                  dVar32 = auVar38._0_8_;
                  auVar38._8_8_ = dVar36 + dVar32;
                  iVar22 = iVar22 + -1;
                  auVar38._0_8_ = dVar32 + 1.0;
                  *pdVar23 = auVar38._8_8_;
                  *pdVar20 = dVar40 - dVar32;
                  pdVar20 = pdVar20 + -1;
                } while (iVar22 != 0);
              }
              if (iVar19 == iVar24 * 2) {
                pdVar16[iVar24] = (dVar36 + dVar40) * 0.5;
              }
              else {
                pdVar16[iVar24] = dVar36 + (double)(longlong)iVar24;
                (pdVar16 + iVar24)[1] = dVar40 - (double)(longlong)iVar24;
              }
            }
          }
        }
      }
LAB_0001fe68:
      uVar13 = *(undefined4 *)local_7c[1];
      *(undefined4 *)local_7c[1] = *(undefined4 *)(local_74[1] + 4);
      emxEnsureCapacity_real_T1(local_7c,uVar13);
      iVar24 = ((int *)local_74[1])[1];
      if (0 < iVar24) {
        iVar19 = *(int *)local_74[1];
        pdVar16 = (double *)*local_74;
        puVar5 = (undefined8 *)*local_7c;
        iVar25 = *local_70;
        do {
          dVar32 = *pdVar16;
          pdVar16 = pdVar16 + iVar19;
          iVar24 = iVar24 + -1;
          *puVar5 = *(undefined8 *)(iVar25 + (int)(longlong)dVar32 * 8 + -8);
          puVar5 = puVar5 + 1;
        } while (iVar24 != 0);
      }
      diff(local_7c,local_78);
      b_abs(local_78,local_7c);
      piVar26 = (int *)local_7c[1];
      iVar19 = *piVar26;
      dVar32 = *(double *)*local_7c;
      iVar24 = iVar19;
      if (1 < iVar19) {
        iVar24 = rtIsNaN(SUB84(dVar32,0),(int)((ulonglong)dVar32 >> 0x20));
        if (iVar24 == 0) {
          iVar25 = 1;
        }
        else {
          iVar22 = 8;
          iVar24 = 2;
          do {
            iVar25 = iVar24;
            iVar7 = rtIsNaN((int)*(undefined8 *)(*local_7c + iVar22),
                            (int)((ulonglong)*(undefined8 *)(*local_7c + iVar22) >> 0x20));
            if (iVar7 == 0) {
              dVar32 = *(double *)(*local_7c + iVar22);
              break;
            }
            if (iVar19 <= iVar25) break;
            iVar22 = iVar22 + 8;
            iVar24 = iVar25 + 1;
          } while (iVar7 != 0);
        }
        piVar26 = (int *)local_7c[1];
        iVar24 = *piVar26;
        iVar22 = iVar24;
        if (iVar25 < iVar24) {
          iVar22 = iVar19;
        }
        if (iVar25 < iVar22) {
          iVar19 = iVar19 - iVar25;
          pdVar16 = (double *)(*local_7c + iVar25 * 8);
          do {
            dVar36 = *pdVar16;
            pdVar16 = pdVar16 + 1;
            uVar14 = uVar28 & 0xfffffff | (uint)(dVar36 < dVar32) << 0x1f |
                     (uint)(dVar36 == dVar32) << 0x1e;
            uVar28 = uVar14 | (uint)(NAN(dVar36) || NAN(dVar32)) << 0x1c;
            bVar3 = (byte)(uVar14 >> 0x18);
            if (!(bool)(bVar3 >> 6 & 1) && bVar3 >> 7 == ((byte)(uVar28 >> 0x1c) & 1)) {
              dVar32 = dVar36;
            }
            iVar19 = iVar19 + -1;
          } while (iVar19 != 0);
        }
      }
      *piVar26 = *(int *)(local_74[1] + 4);
      emxEnsureCapacity_real_T1(local_7c,iVar24);
      iVar24 = ((int *)local_74[1])[1];
      if (0 < iVar24) {
        iVar19 = *(int *)local_74[1];
        pdVar16 = (double *)*local_74;
        puVar5 = (undefined8 *)*local_7c;
        iVar25 = *local_70;
        do {
          dVar36 = *pdVar16;
          pdVar16 = pdVar16 + iVar19;
          iVar24 = iVar24 + -1;
          *puVar5 = *(undefined8 *)(iVar25 + (int)(longlong)dVar36 * 8 + -8);
          puVar5 = puVar5 + 1;
        } while (iVar24 != 0);
      }
      diff(local_7c,local_78);
      b_abs(local_78,local_7c);
      dVar36 = (double)nansum(local_7c);
      dVar32 = dVar32 + dVar32;
      uVar28 = uVar28 & 0xfffffff | (uint)(dVar36 < dVar32) << 0x1f |
               (uint)(dVar36 == dVar32) << 0x1e;
      uVar14 = uVar28 | (uint)(NAN(dVar36) || NAN(dVar32)) << 0x1c;
      bVar3 = (byte)(uVar28 >> 0x18);
      if (((bool)(bVar3 >> 6 & 1) || bVar3 >> 7 != ((byte)(uVar14 >> 0x1c) & 1)) &&
         (iVar24 = rtIsNaN(SUB84(dVar32,0),(int)((ulonglong)dVar32 >> 0x20)), iVar24 == 0)) {
        dVar36 = dVar32;
      }
      if (dVar36 != 10.0 && dVar36 < 10.0 == NAN(dVar36)) {
        dVar36 = 10.0;
      }
      uVar28 = uVar14 & 0xfffffff | (uint)(dVar36 < 1.0) << 0x1f | (uint)(dVar36 == 1.0) << 0x1e |
               (uint)(1.0 <= dVar36) << 0x1d;
      if ((int)uVar28 < 0) {
        dVar36 = 1.0;
      }
      else {
        iVar24 = rtIsNaN(SUB84(dVar36,0),(int)((ulonglong)dVar36 >> 0x20));
        if (iVar24 != 0) {
          dVar36 = 1.0;
        }
      }
      uVar13 = SUB84((dVar30 * dVar36) / 10.0,0);
      floor(in_stack_ffffff48);
      dVar32 = (double)CONCAT44(extraout_r1_01,uVar13);
      uVar28 = uVar28 & 0xfffffff | (uint)(dVar32 < dVar34) << 0x1f |
               (uint)(dVar32 == dVar34) << 0x1e;
      uVar14 = uVar28 | (uint)(NAN(dVar32) || NAN(dVar34)) << 0x1c;
      bVar3 = (byte)(uVar28 >> 0x18);
      if (((bool)(bVar3 >> 6 & 1) || bVar3 >> 7 != ((byte)(uVar14 >> 0x1c) & 1)) &&
         (iVar24 = rtIsNaN(uVar42,extraout_r1_00), iVar24 == 0)) {
        dVar32 = dVar34;
      }
      in_fpscr = uVar14 & 0xfffffff | (uint)(dVar32 == 0.0) << 0x1e;
      if ((byte)(in_fpscr >> 0x1e) == 0) {
        dVar36 = dVar29 - dVar32;
        uVar11 = *(uint *)local_7c[1];
        dVar32 = dVar29 + dVar32;
        iVar24 = (int)(longlong)dVar32;
        uVar28 = uVar14 & 0xfffffff | (uint)(dVar36 < dVar32) << 0x1f |
                 (uint)(dVar36 == dVar32) << 0x1e;
        in_fpscr = uVar28 | (uint)(NAN(dVar36) || NAN(dVar32)) << 0x1c;
        iVar19 = (int)(longlong)dVar36 + -1;
        bVar3 = (byte)(uVar28 >> 0x18);
        if (!(bool)(bVar3 >> 6 & 1) && bVar3 >> 7 == ((byte)(in_fpscr >> 0x1c) & 1)) {
          iVar24 = 0;
          iVar19 = 0;
        }
        uVar28 = iVar24 - iVar19;
        *(uint *)local_7c[1] = uVar28;
        emxEnsureCapacity_real_T1(local_7c,uVar11);
        if (0 < (int)uVar28) {
          puVar5 = (undefined8 *)*local_7c;
          iVar25 = *local_70;
          if (uVar28 == 1) {
LAB_000200a8:
            uVar14 = 0;
          }
          else {
            puVar18 = (undefined8 *)(iVar25 + iVar24 * 8);
            puVar12 = (undefined8 *)(iVar25 + iVar19 * 8);
            bVar27 = puVar5 < puVar18;
            if (bVar27) {
              puVar18 = puVar5 + uVar28;
            }
            if (bVar27 && puVar12 < puVar18) goto LAB_000200a8;
            uVar14 = uVar28 & 0xfffffffe;
            uVar11 = uVar14;
            puVar18 = puVar5;
            do {
              uVar31 = *puVar12;
              uVar33 = puVar12[1];
              puVar12 = puVar12 + 2;
              uVar11 = uVar11 - 2;
              *puVar18 = uVar31;
              puVar18[1] = uVar33;
              puVar18 = puVar18 + 2;
            } while (uVar11 != 0);
            if (uVar28 == uVar14) goto LAB_000200d0;
          }
          puVar5 = puVar5 + uVar14;
          iVar24 = (iVar19 + uVar14) - iVar24;
          puVar18 = (undefined8 *)(iVar25 + (iVar19 + uVar14) * 8);
          do {
            uVar31 = *puVar18;
            puVar18 = puVar18 + 1;
            bVar27 = iVar24 != -1;
            iVar24 = iVar24 + 1;
            *puVar5 = uVar31;
            puVar5 = puVar5 + 1;
          } while (bVar27);
        }
LAB_000200d0:
        uVar31 = c_nanmean(local_7c);
      }
      else {
        uVar31 = *(undefined8 *)(*local_70 + (int)(longlong)dVar29 * 8 + -8);
      }
      iVar17 = iVar17 + 1;
      dVar35 = dVar35 + 1.0;
      *(undefined8 *)(*param_6 + (int)(longlong)(dVar29 - dVar30) * 8 + -8) = uVar31;
    } while (iVar17 != iVar10);
  }
  emxFree_real_T(&local_7c);
  emxFree_real_T(&local_78);
  emxFree_real_T(&local_74);
  emxFree_real_T(&local_70);
  emxInit_boolean_T1(&local_80,2);
  piVar26 = (int *)local_80[1];
  piVar6 = (int *)param_1[1];
  iVar10 = *piVar26;
  iVar17 = piVar26[1];
  *piVar26 = *piVar6;
  piVar26[1] = piVar6[1];
  emxEnsureCapacity_boolean_T1(local_80,iVar17 * iVar10);
  iVar10 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if (0 < iVar10) {
    iVar17 = 0;
    iVar24 = 0;
    do {
      uVar4 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar17),
                      (int)((ulonglong)*(undefined8 *)(*param_1 + iVar17) >> 0x20));
      iVar17 = iVar17 + 8;
      *(undefined1 *)(*local_80 + iVar24) = uVar4;
      iVar24 = iVar24 + 1;
    } while (iVar10 - iVar24 != 0);
  }
  uVar28 = ((int *)local_80[1])[1] * *(int *)local_80[1];
  if ((int)uVar28 < 1) {
    emxInit_int32_T1(&local_84,1);
    uVar42 = *(undefined4 *)local_84[1];
    *(undefined4 *)local_84[1] = 0;
    emxEnsureCapacity_int32_T1(local_84,uVar42);
    goto LAB_00020388;
  }
  if (uVar28 < 4) {
    uVar11 = 0;
    iVar10 = 0;
LAB_0002033e:
    iVar17 = uVar28 - uVar11;
    pcVar9 = (char *)(*local_80 + uVar11);
    do {
      if (*pcVar9 != '\0') {
        iVar10 = iVar10 + 1;
      }
      iVar17 = iVar17 + -1;
      pcVar9 = pcVar9 + 1;
    } while (iVar17 != 0);
  }
  else {
    uVar11 = uVar28 & 0xfffffffc;
    auVar38 = ZEXT816(0);
    auVar1 = SIMDExpandImmediate(0,0,1);
    puVar8 = (undefined4 *)*local_80;
    uVar14 = uVar11;
    do {
      uVar31 = in_q10._0_8_;
      uVar14 = uVar14 - 4;
                    // WARNING: Ignoring partial resolution of indirect
      uVar42 = *puVar8;
      auVar44 = VectorCopyLong(uVar31,1,1);
      uVar43 = VectorCompareEqual(auVar44._0_8_,0,2);
      in_q10 = VectorCopyLong(~uVar43,2,1);
      in_q10 = in_q10 & auVar1;
      auVar38 = VectorAdd(auVar38,in_q10,4);
      puVar8 = puVar8 + 1;
    } while (uVar14 != 0);
    auVar2._16_16_ = auVar38;
    auVar2._0_16_ = auVar38;
    auVar38 = VectorAdd(auVar38,auVar2._8_16_,4);
    uVar31 = CONCAT44(auVar38._4_4_,auVar38._4_4_);
    auVar1._8_8_ = uVar31;
    auVar1._0_8_ = uVar31;
    auVar38 = VectorAdd(auVar38,auVar1,4);
    iVar10 = auVar38._0_4_;
    if (uVar28 != uVar11) goto LAB_0002033e;
  }
  emxInit_int32_T1(&local_84,1);
  iVar17 = *(int *)local_84[1];
  *(int *)local_84[1] = iVar10;
  emxEnsureCapacity_int32_T1(local_84,iVar17);
  if (0 < (int)uVar28) {
    uVar14 = 0;
    iVar10 = *local_80;
    iVar17 = 0;
    do {
      pcVar9 = (char *)(iVar10 + uVar14);
      uVar14 = uVar14 + 1;
      if (*pcVar9 != '\0') {
        *(uint *)(*local_84 + iVar17 * 4) = uVar14;
        iVar17 = iVar17 + 1;
      }
    } while (uVar28 != uVar14);
  }
LAB_00020388:
  emxFree_boolean_T(&local_80);
  iVar10 = *(int *)local_84[1];
  if (0 < iVar10) {
    uVar28 = *param_6;
    piVar26 = (int *)*local_84;
    do {
      iVar10 = iVar10 + -1;
      *(undefined8 *)(uVar28 + *piVar26 * 8 + -8) = rtNaN;
      piVar26 = piVar26 + 1;
    } while (iVar10 != 0);
  }
  emxFree_int32_T(&local_84);
  if (__stack_chk_guard != local_6c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



// WARNING: Restarted to delay deadcode elimination for space: register
// WARNING: Restarted to delay deadcode elimination for space: stack

void b_SAFilter(int *param_1,int *param_2)

{
  undefined1 auVar1 [32];
  undefined1 uVar2;
  int *piVar3;
  undefined4 *puVar4;
  char *pcVar5;
  int iVar6;
  uint uVar7;
  undefined1 (*pauVar8) [16];
  undefined4 uVar9;
  undefined8 *puVar10;
  undefined1 (*pauVar11) [16];
  undefined8 *puVar12;
  int iVar13;
  uint uVar14;
  uint uVar15;
  int iVar16;
  undefined1 (*pauVar17) [16];
  undefined8 *puVar18;
  int *piVar19;
  undefined1 (*pauVar20) [16];
  bool bVar21;
  undefined8 uVar22;
  undefined8 uVar23;
  undefined1 auVar24 [16];
  undefined1 auVar25 [16];
  ulonglong uVar26;
  undefined1 in_q10 [16];
  undefined1 auVar27 [16];
  int *local_44;
  int *local_40;
  int *local_3c;
  int *local_38;
  int local_34;
  
  local_34 = __stack_chk_guard;
  emxInit_real_T(&local_38,1);
  uVar23 = *(undefined8 *)*param_1;
  iVar13 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  iVar6 = *(int *)local_38[1];
  uVar22 = ((undefined8 *)*param_1)[iVar13 + -1];
  *(int *)local_38[1] = iVar13 + 4;
  emxEnsureCapacity_real_T1(local_38,iVar6);
  piVar3 = (int *)param_1[1];
  iVar6 = *piVar3;
  puVar10 = (undefined8 *)*local_38;
  uVar14 = piVar3[1] * iVar6;
  *puVar10 = uVar23;
  puVar10[1] = uVar23;
  if (0 < (int)uVar14) {
    pauVar20 = (undefined1 (*) [16])*param_1;
    if (uVar14 == 1) {
LAB_00020480:
      uVar7 = 0;
    }
    else {
      pauVar17 = (undefined1 (*) [16])(*pauVar20 + uVar14 * 8);
      pauVar8 = (undefined1 (*) [16])(puVar10 + 2);
      bVar21 = pauVar8 < pauVar17;
      if (bVar21) {
        pauVar17 = (undefined1 (*) [16])(puVar10 + uVar14 + 2);
      }
      if (bVar21 && pauVar20 < pauVar17) goto LAB_00020480;
      uVar7 = uVar14 & 0xfffffffe;
      uVar15 = uVar7;
      pauVar17 = pauVar20;
      do {
        auVar24 = *pauVar17;
        pauVar17 = pauVar17 + 1;
        uVar15 = uVar15 - 2;
        *(longlong *)*pauVar8 = auVar24._0_8_;
        *(longlong *)(*pauVar8 + 8) = auVar24._8_8_;
        pauVar8 = pauVar8 + 1;
      } while (uVar15 != 0);
      if (uVar14 - uVar7 == 0) goto LAB_000204a2;
    }
    puVar18 = (undefined8 *)(*pauVar20 + uVar7 * 8);
    iVar13 = uVar14 - uVar7;
    puVar12 = puVar10 + uVar7 + 2;
    do {
      uVar23 = *puVar18;
      puVar18 = puVar18 + 1;
      iVar13 = iVar13 + -1;
      *puVar12 = uVar23;
      puVar12 = puVar12 + 1;
    } while (iVar13 != 0);
  }
LAB_000204a2:
  piVar19 = (int *)param_2[1];
  iVar13 = *piVar19;
  iVar16 = piVar19[1];
  *piVar19 = iVar6;
  iVar6 = piVar3[1];
  puVar10[uVar14 + 2] = uVar22;
  puVar10[uVar14 + 3] = uVar22;
  piVar19[1] = iVar6;
  emxEnsureCapacity_real_T(param_2,iVar16 * iVar13);
  uVar14 = *(int *)param_1[1] * ((int *)param_1[1])[1];
  if (0 < (int)uVar14) {
    pauVar17 = (undefined1 (*) [16])*param_2;
    pauVar20 = (undefined1 (*) [16])*param_1;
    if (uVar14 == 1) {
LAB_0002050c:
      uVar7 = 0;
    }
    else {
      pauVar8 = (undefined1 (*) [16])(*pauVar20 + uVar14 * 8);
      bVar21 = pauVar17 < pauVar8;
      if (bVar21) {
        pauVar8 = (undefined1 (*) [16])(*pauVar17 + uVar14 * 8);
      }
      if (bVar21 && pauVar20 < pauVar8) goto LAB_0002050c;
      uVar7 = uVar14 & 0xfffffffe;
      pauVar8 = pauVar17;
      pauVar11 = pauVar20;
      uVar15 = uVar7;
      do {
        auVar24 = *pauVar11;
        pauVar11 = pauVar11 + 1;
        uVar15 = uVar15 - 2;
        *(longlong *)*pauVar8 = auVar24._0_8_;
        *(longlong *)(*pauVar8 + 8) = auVar24._8_8_;
        pauVar8 = pauVar8 + 1;
      } while (uVar15 != 0);
      if (uVar14 - uVar7 == 0) goto LAB_0002052a;
    }
    puVar12 = (undefined8 *)(*pauVar20 + uVar7 * 8);
    puVar10 = (undefined8 *)(*pauVar17 + uVar7 * 8);
    iVar6 = uVar14 - uVar7;
    do {
      uVar22 = *puVar12;
      puVar12 = puVar12 + 1;
      iVar6 = iVar6 + -1;
      *puVar10 = uVar22;
      puVar10 = puVar10 + 1;
    } while (iVar6 != 0);
  }
LAB_0002052a:
  emxInit_real_T(&local_3c,1);
  if (4 < *(int *)local_38[1]) {
    iVar13 = 0;
    iVar6 = 0;
    do {
      uVar9 = *(undefined4 *)local_3c[1];
      *(undefined4 *)local_3c[1] = 5;
      emxEnsureCapacity_real_T1(local_3c,uVar9);
      puVar10 = (undefined8 *)(*local_38 + iVar6);
      puVar12 = (undefined8 *)*local_3c;
      *puVar12 = *puVar10;
      puVar12[1] = puVar10[1];
      puVar12[2] = puVar10[2];
      puVar12[3] = puVar10[3];
      puVar12[4] = puVar10[4];
      uVar22 = c_nanmean();
      iVar16 = *param_2;
      iVar13 = iVar13 + 1;
      *(int *)(iVar16 + iVar6) = (int)uVar22;
      iVar16 = iVar16 + iVar6;
      iVar6 = iVar6 + 8;
      piVar3 = (int *)local_38[1];
      *(int *)(iVar16 + 4) = (int)((ulonglong)uVar22 >> 0x20);
    } while (iVar13 < *piVar3 + -4);
  }
  emxFree_real_T(&local_3c);
  emxFree_real_T(&local_38);
  emxInit_boolean_T1(&local_40,2);
  piVar19 = (int *)param_1[1];
  piVar3 = (int *)local_40[1];
  iVar6 = *piVar3;
  iVar13 = piVar3[1];
  *piVar3 = *piVar19;
  piVar3[1] = piVar19[1];
  emxEnsureCapacity_boolean_T1(local_40,iVar13 * iVar6);
  iVar6 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  if (0 < iVar6) {
    iVar13 = 0;
    iVar16 = 0;
    do {
      uVar2 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar13),
                      (int)((ulonglong)*(undefined8 *)(*param_1 + iVar13) >> 0x20));
      iVar13 = iVar13 + 8;
      *(undefined1 *)(*local_40 + iVar16) = uVar2;
      iVar16 = iVar16 + 1;
    } while (iVar6 - iVar16 != 0);
  }
  uVar14 = ((int *)local_40[1])[1] * *(int *)local_40[1];
  if ((int)uVar14 < 1) {
    emxInit_int32_T1(&local_44,1);
    uVar9 = *(undefined4 *)local_44[1];
    *(undefined4 *)local_44[1] = 0;
    emxEnsureCapacity_int32_T1(local_44,uVar9);
    goto LAB_000206cc;
  }
  if (uVar14 < 4) {
    uVar15 = 0;
    iVar6 = 0;
LAB_00020684:
    iVar13 = uVar14 - uVar15;
    pcVar5 = (char *)(*local_40 + uVar15);
    do {
      if (*pcVar5 != '\0') {
        iVar6 = iVar6 + 1;
      }
      iVar13 = iVar13 + -1;
      pcVar5 = pcVar5 + 1;
    } while (iVar13 != 0);
  }
  else {
    uVar15 = uVar14 & 0xfffffffc;
    auVar24 = ZEXT816(0);
    auVar25 = SIMDExpandImmediate(0,0,1);
    puVar4 = (undefined4 *)*local_40;
    uVar7 = uVar15;
    do {
      uVar22 = in_q10._0_8_;
      uVar7 = uVar7 - 4;
                    // WARNING: Ignoring partial resolution of indirect
      uVar9 = *puVar4;
      auVar27 = VectorCopyLong(uVar22,1,1);
      uVar26 = VectorCompareEqual(auVar27._0_8_,0,2);
      in_q10 = VectorCopyLong(~uVar26,2,1);
      in_q10 = in_q10 & auVar25;
      auVar24 = VectorAdd(auVar24,in_q10,4);
      puVar4 = puVar4 + 1;
    } while (uVar7 != 0);
    auVar1._16_16_ = auVar24;
    auVar1._0_16_ = auVar24;
    auVar25 = VectorAdd(auVar24,auVar1._8_16_,4);
    uVar22 = CONCAT44(auVar25._4_4_,auVar25._4_4_);
    auVar24._8_8_ = uVar22;
    auVar24._0_8_ = uVar22;
    auVar24 = VectorAdd(auVar25,auVar24,4);
    iVar6 = auVar24._0_4_;
    if (uVar14 != uVar15) goto LAB_00020684;
  }
  emxInit_int32_T1(&local_44,1);
  iVar13 = *(int *)local_44[1];
  *(int *)local_44[1] = iVar6;
  emxEnsureCapacity_int32_T1(local_44,iVar13);
  if (0 < (int)uVar14) {
    uVar7 = 0;
    iVar6 = *local_40;
    iVar13 = 0;
    do {
      pcVar5 = (char *)(iVar6 + uVar7);
      uVar7 = uVar7 + 1;
      if (*pcVar5 != '\0') {
        *(uint *)(*local_44 + iVar13 * 4) = uVar7;
        iVar13 = iVar13 + 1;
      }
    } while (uVar14 != uVar7);
  }
LAB_000206cc:
  emxFree_boolean_T(&local_40);
  iVar6 = *(int *)local_44[1];
  if (0 < iVar6) {
    iVar13 = *param_2;
    piVar3 = (int *)*local_44;
    do {
      iVar6 = iVar6 + -1;
      *(undefined8 *)(iVar13 + *piVar3 * 8 + -8) = rtNaN;
      piVar3 = piVar3 + 1;
    } while (iVar6 != 0);
  }
  emxFree_int32_T(&local_44);
  if (__stack_chk_guard != local_34) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void SDBG(int *param_1,uint *param_2)

{
  uint *puVar1;
  int iVar2;
  int iVar3;
  undefined4 *puVar4;
  uint uVar5;
  int *piVar6;
  undefined8 *puVar7;
  int *piVar8;
  undefined8 *puVar9;
  int iVar10;
  uint uVar11;
  uint uVar12;
  int iVar13;
  int iVar14;
  int iVar15;
  int iVar16;
  int iVar17;
  undefined8 *puVar18;
  undefined8 *puVar19;
  bool bVar20;
  double dVar21;
  double dVar22;
  double dVar23;
  undefined8 uVar24;
  undefined8 uVar25;
  undefined8 uVar26;
  uint *local_44;
  int local_40;
  int local_3c;
  
  local_3c = __stack_chk_guard;
  emxInit_real_T1(&local_44,2);
  piVar8 = (int *)param_1[1];
  piVar6 = (int *)local_44[1];
  iVar10 = *piVar8;
  iVar3 = *piVar6;
  iVar13 = piVar6[1];
  *piVar6 = 1;
  piVar6[1] = piVar8[1];
  emxEnsureCapacity_real_T(local_44,iVar13 * iVar3);
  if ((*(int *)(local_44[1] + 4) != 0) && (puVar4 = (undefined4 *)param_1[1], 0 < (int)puVar4[1])) {
    iVar16 = -1;
    iVar13 = 1;
    iVar17 = 0;
    puVar1 = (uint *)&rtNaN;
    iVar3 = 1;
    do {
      if (iVar13 != 0) {
        puVar1 = (uint *)*puVar4;
      }
      dVar22 = rtNaN;
      if ((iVar13 != 0 && puVar1 != (uint *)0x0) && (0 < iVar10)) {
        dVar21 = 0.0;
        iVar15 = 0;
        iVar13 = iVar10;
        iVar14 = iVar17;
        do {
          iVar2 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar14),
                          (int)((ulonglong)*(undefined8 *)(*param_1 + iVar14) >> 0x20));
          if (iVar2 == 0) {
            iVar15 = iVar15 + 1;
            dVar21 = dVar21 + *(double *)(*param_1 + iVar14);
          }
          iVar14 = iVar14 + 8;
          iVar13 = iVar13 + -1;
        } while (iVar13 != 0);
        dVar22 = rtNaN;
        if (iVar15 != 0) {
          if (iVar10 < 1) {
            dVar22 = 0.0;
          }
          else {
            dVar22 = 0.0;
            iVar13 = iVar10;
            iVar14 = iVar17;
            do {
              iVar2 = rtIsNaN((int)*(undefined8 *)(*param_1 + iVar14),
                              (int)((ulonglong)*(undefined8 *)(*param_1 + iVar14) >> 0x20));
              if (iVar2 == 0) {
                dVar23 = *(double *)(*param_1 + iVar14) - dVar21 / (double)(longlong)iVar15;
                dVar22 = dVar22 + dVar23 * dVar23;
              }
              iVar14 = iVar14 + 8;
              iVar13 = iVar13 + -1;
            } while (iVar13 != 0);
          }
          iVar13 = iVar15 + -1;
          if (iVar15 + -1 == 0 || iVar15 < 1) {
            iVar13 = iVar15;
          }
          dVar22 = dVar22 / (double)(longlong)iVar13;
        }
      }
      iVar16 = iVar16 + 1;
      puVar4 = (undefined4 *)param_1[1];
      iVar17 = iVar17 + iVar10 * 8;
      iVar13 = puVar4[1];
      *(double *)(*local_44 + iVar16 * 8) = dVar22;
      bVar20 = iVar3 < iVar13;
      puVar1 = local_44;
      iVar3 = iVar3 + 1;
    } while (bVar20);
  }
  b_sqrt();
  local_40 = ((int *)param_1[1])[1] * *(int *)param_1[1];
  uVar24 = nanstd();
  piVar6 = (int *)param_2[1];
  uVar11 = local_44[1];
  iVar3 = *piVar6;
  iVar10 = piVar6[1];
  *piVar6 = 1;
  piVar6[1] = *(int *)(uVar11 + 4) + 1;
  emxEnsureCapacity_real_T(param_2,iVar10 * iVar3);
  uVar11 = ((int *)local_44[1])[1];
  if ((int)uVar11 < 1) {
    puVar19 = (undefined8 *)*param_2;
    iVar3 = *(int *)param_2[1];
  }
  else {
    puVar19 = (undefined8 *)*param_2;
    uVar12 = 0;
    iVar10 = *(int *)local_44[1];
    puVar18 = (undefined8 *)*local_44;
    iVar3 = *(int *)param_2[1];
    if ((uVar11 != 1) && (iVar3 == 1 && iVar10 == 1)) {
      puVar7 = puVar18 + uVar11;
      bVar20 = puVar19 < puVar7;
      if (bVar20) {
        puVar7 = puVar19 + uVar11;
      }
      if (bVar20 && puVar18 < puVar7) {
        uVar12 = 0;
      }
      else {
        uVar12 = uVar11 & 0xfffffffe;
        uVar5 = uVar12;
        puVar7 = puVar18;
        puVar9 = puVar19;
        do {
          uVar25 = *puVar7;
          uVar26 = puVar7[1];
          puVar7 = puVar7 + iVar10 * 2;
          uVar5 = uVar5 - 2;
          *puVar9 = uVar25;
          puVar9[1] = uVar26;
          puVar9 = puVar9 + iVar3 * 2;
        } while (uVar5 != 0);
        if (uVar11 == uVar12) goto LAB_00020942;
      }
    }
    iVar13 = uVar11 - uVar12;
    puVar18 = puVar18 + uVar12 * iVar10;
    puVar7 = puVar19 + uVar12 * iVar3;
    do {
      uVar25 = *puVar18;
      puVar18 = puVar18 + iVar10;
      iVar13 = iVar13 + -1;
      *puVar7 = uVar25;
      puVar7 = puVar7 + iVar3;
    } while (iVar13 != 0);
  }
LAB_00020942:
  puVar19[iVar3 * uVar11] = uVar24;
  emxFree_real_T(&local_44);
  if (__stack_chk_guard != local_3c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void SelectByHour(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                 double param_5,int *param_6)

{
  int iVar1;
  uint uVar2;
  int iVar3;
  undefined8 *puVar4;
  int iVar5;
  uint *puVar6;
  undefined8 *puVar7;
  int iVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  int *piVar13;
  int *piVar14;
  int iVar15;
  int iVar16;
  int iVar17;
  uint uVar18;
  int iVar19;
  uint uVar20;
  int iVar21;
  bool bVar22;
  int iVar23;
  uint uVar24;
  undefined8 uVar25;
  double dVar26;
  undefined8 uVar27;
  double dVar28;
  double dVar29;
  double dVar30;
  int *local_38;
  int *local_34;
  int *local_30 [2];
  int local_28;
  
  local_28 = __stack_chk_guard;
  emxInitMatrix_cell_wrap_1(local_30);
  emxInit_real_T1(&local_34,2);
  emxInit_real_T1(&local_38,2);
  if ((((param_5 == 24.0 || param_5 < 24.0 != NAN(param_5)) &&
       (dVar28 = (double)CONCAT44(param_4,param_3), -1 < (int)((uint)(dVar28 < 0.0) << 0x1f))) &&
      (dVar28 == 24.0 || dVar28 < 24.0 != NAN(dVar28))) &&
     (-1 < (int)((uint)(param_5 < 0.0) << 0x1f))) {
    piVar14 = (int *)param_1[1];
    dVar30 = (double)(longlong)*piVar14;
    dVar29 = (dVar30 / 24.0) * dVar28 + 1.0;
    dVar26 = (dVar30 / 24.0) * param_5;
    if (param_5 < dVar28 == (NAN(param_5) || NAN(dVar28))) {
      uVar18 = piVar14[1];
      puVar6 = (uint *)param_6[1];
      uVar24 = *puVar6;
      uVar12 = puVar6[1];
      puVar6[1] = uVar18;
      iVar8 = (int)(longlong)dVar26;
      if (dVar29 != dVar26 && dVar29 < dVar26 == (NAN(dVar29) || NAN(dVar26))) {
        iVar8 = 0;
      }
      iVar1 = (int)(longlong)dVar29 + -1;
      if (dVar29 != dVar26 && dVar29 < dVar26 == (NAN(dVar29) || NAN(dVar26))) {
        iVar1 = 0;
      }
      uVar10 = iVar8 - iVar1;
      *puVar6 = uVar10;
      emxEnsureCapacity_real_T(param_6,uVar12 * uVar24);
      if (0 < (int)uVar18) {
        iVar3 = 0;
        uVar12 = 0;
        uVar24 = uVar10 & 0xfffffffe;
        do {
          if (0 < (int)uVar10) {
            iVar16 = *param_1;
            iVar5 = *param_6;
            iVar23 = *(int *)param_6[1];
            iVar15 = *(int *)param_1[1];
            if (uVar10 == 1) {
LAB_00020cbc:
              uVar2 = 0;
            }
            else {
              puVar4 = (undefined8 *)(iVar16 + (iVar15 * uVar12 + iVar1) * 8);
              if ((iVar23 * uVar12 * 8 + iVar5 < iVar16 + (iVar15 * uVar12 + iVar8) * 8) &&
                 (puVar4 < (undefined8 *)(iVar23 * uVar12 * 8 + iVar5 + uVar10 * 8)))
              goto LAB_00020cbc;
              puVar7 = (undefined8 *)(iVar23 * iVar3 + iVar5);
              uVar2 = uVar24;
              do {
                uVar25 = *puVar4;
                uVar27 = puVar4[1];
                puVar4 = puVar4 + 2;
                uVar2 = uVar2 - 2;
                *puVar7 = uVar25;
                puVar7[1] = uVar27;
                puVar7 = puVar7 + 2;
              } while (uVar2 != 0);
              uVar2 = uVar24;
              if (uVar10 == uVar24) goto LAB_00020c6e;
            }
            iVar17 = (iVar1 - iVar8) + uVar2;
            puVar4 = (undefined8 *)(iVar5 + (iVar23 * uVar12 + uVar2) * 8);
            puVar7 = (undefined8 *)(iVar16 + (iVar15 * uVar12 + iVar1 + uVar2) * 8);
            do {
              uVar25 = *puVar7;
              puVar7 = puVar7 + 1;
              bVar22 = iVar17 != -1;
              iVar17 = iVar17 + 1;
              *puVar4 = uVar25;
              puVar4 = puVar4 + 1;
            } while (bVar22);
          }
LAB_00020c6e:
          uVar12 = uVar12 + 1;
          iVar3 = iVar3 + 8;
        } while (uVar12 != uVar18);
      }
    }
    else {
      iVar23 = (int)(longlong)dVar29;
      iVar3 = *piVar14 + 1;
      iVar1 = piVar14[1];
      iVar8 = iVar1 + 1;
      uVar12 = iVar1 - 1;
      uVar24 = (uint)(longlong)dVar26;
      if (dVar29 != dVar30 && dVar29 < dVar30 == (NAN(dVar29) || NAN(dVar30))) {
        iVar3 = 1;
      }
      if (dVar29 != dVar30 && dVar29 < dVar30 == (NAN(dVar29) || NAN(dVar30))) {
        iVar23 = 1;
      }
      uVar18 = iVar3 - iVar23;
      if ((int)((uint)(dVar26 < 1.0) << 0x1f) < 0) {
        uVar24 = 0;
      }
      iVar5 = 2;
      if (iVar1 < 2) {
        iVar5 = 1;
        iVar8 = 1;
        uVar12 = 0;
      }
      if (((uVar18 == 0) || (uVar10 = uVar12, uVar12 == 0)) &&
         ((uVar10 = iVar8 - iVar5, uVar24 == 0 || uVar10 == 0 &&
          (uVar2 = uVar12 & ~((int)uVar12 >> 0x1f), (int)uVar10 <= (int)uVar2)))) {
        uVar10 = uVar2;
      }
      puVar6 = (uint *)local_34[1];
      uVar2 = *puVar6;
      uVar9 = puVar6[1];
      *puVar6 = uVar18;
      puVar6[1] = uVar12;
      emxEnsureCapacity_real_T(local_34,uVar9 * uVar2);
      uVar2 = uVar12;
      if (uVar12 != 0) {
        uVar2 = uVar18;
      }
      if (uVar18 == 0) {
        uVar2 = uVar18;
      }
      if (uVar10 == 0) {
        uVar2 = uVar18;
      }
      if (0 < (int)uVar12) {
        iVar1 = 0;
        uVar11 = 0;
        uVar9 = uVar18 & 0xfffffffe;
        do {
          if (0 < (int)uVar18) {
            iVar16 = *local_34;
            iVar17 = *param_1;
            iVar21 = *(int *)local_34[1];
            iVar15 = *(int *)param_1[1];
            if (uVar18 == 1) {
              uVar20 = 0;
            }
            else {
              iVar19 = iVar15 * uVar11 + iVar23;
              if ((iVar21 * uVar11 * 8 + iVar16 < iVar17 + -8 + (iVar15 * uVar11 + iVar3) * 8) &&
                 ((uint)(iVar17 + -8 + iVar19 * 8) < iVar21 * uVar11 * 8 + iVar16 + uVar18 * 8)) {
                uVar20 = 0;
              }
              else {
                puVar7 = (undefined8 *)(iVar21 * iVar1 + iVar16);
                puVar4 = (undefined8 *)(iVar17 + iVar19 * 8 + -8);
                uVar20 = uVar9;
                do {
                  uVar25 = *puVar4;
                  uVar27 = puVar4[1];
                  puVar4 = puVar4 + 2;
                  uVar20 = uVar20 - 2;
                  *puVar7 = uVar25;
                  puVar7[1] = uVar27;
                  puVar7 = puVar7 + 2;
                } while (uVar20 != 0);
                uVar20 = uVar9;
                if (uVar18 == uVar9) goto LAB_00020b16;
              }
            }
            puVar4 = (undefined8 *)(iVar16 + (iVar21 * uVar11 + uVar20) * 8);
            iVar16 = (iVar23 - iVar3) + uVar20;
            puVar7 = (undefined8 *)(iVar17 + (iVar15 * uVar11 + iVar23 + uVar20) * 8 + -8);
            do {
              uVar25 = *puVar7;
              puVar7 = puVar7 + 1;
              bVar22 = iVar16 != -1;
              iVar16 = iVar16 + 1;
              *puVar4 = uVar25;
              puVar4 = puVar4 + 1;
            } while (bVar22);
          }
LAB_00020b16:
          uVar11 = uVar11 + 1;
          iVar1 = iVar1 + 8;
        } while (uVar11 != uVar12);
      }
      puVar6 = (uint *)local_30[0][1];
      uVar12 = *puVar6;
      uVar18 = puVar6[1];
      *puVar6 = uVar2;
      puVar6[1] = uVar10;
      emxEnsureCapacity_real_T(local_30[0],uVar18 * uVar12);
      if (0 < (int)uVar10) {
        uVar18 = uVar2 & 0xfffffffe;
        iVar1 = 0;
        iVar3 = 0;
        uVar12 = 0;
        do {
          if (0 < (int)uVar2) {
            iVar16 = *local_30[0];
            iVar15 = *local_34;
            iVar23 = *(int *)local_30[0][1];
            if ((uVar2 == 1) ||
               ((iVar23 * uVar12 * 8 + iVar16 < iVar15 + (uVar2 * uVar12 + uVar2) * 8 &&
                (iVar15 + uVar2 * uVar12 * 8 < iVar23 * uVar12 * 8 + iVar16 + uVar2 * 8)))) {
              uVar9 = 0;
            }
            else {
              puVar4 = (undefined8 *)(iVar23 * iVar1 + iVar16);
              puVar7 = (undefined8 *)(iVar15 + iVar3 * 8);
              uVar9 = uVar18;
              do {
                uVar25 = *puVar7;
                uVar27 = puVar7[1];
                puVar7 = puVar7 + 2;
                uVar9 = uVar9 - 2;
                *puVar4 = uVar25;
                puVar4[1] = uVar27;
                puVar4 = puVar4 + 2;
              } while (uVar9 != 0);
              uVar9 = uVar18;
              if (uVar2 == uVar18) goto LAB_00020d40;
            }
            iVar17 = uVar2 - uVar9;
            puVar7 = (undefined8 *)(iVar15 + (uVar9 + iVar3) * 8);
            puVar4 = (undefined8 *)(iVar16 + (iVar23 * uVar12 + uVar9) * 8);
            do {
              uVar25 = *puVar7;
              puVar7 = puVar7 + 1;
              iVar17 = iVar17 + -1;
              *puVar4 = uVar25;
              puVar4 = puVar4 + 1;
            } while (iVar17 != 0);
          }
LAB_00020d40:
          uVar12 = uVar12 + 1;
          iVar3 = iVar3 + uVar2;
          iVar1 = iVar1 + 8;
        } while (uVar12 != uVar10);
      }
      puVar6 = (uint *)local_38[1];
      uVar2 = iVar8 - iVar5;
      uVar12 = *puVar6;
      uVar18 = puVar6[1];
      *puVar6 = uVar24;
      puVar6[1] = uVar2;
      emxEnsureCapacity_real_T(local_38,uVar18 * uVar12);
      uVar12 = iVar8 - iVar5;
      if (iVar8 - iVar5 != 0) {
        uVar12 = uVar24;
      }
      if (uVar24 == 0) {
        uVar12 = uVar24;
      }
      if (uVar10 == 0) {
        uVar12 = uVar24;
      }
      if (0 < (int)uVar2) {
        iVar3 = iVar5 + -1;
        iVar23 = iVar5 * 8 + -8;
        iVar1 = 0;
        uVar9 = 0;
        uVar18 = uVar24 & 0xfffffffe;
        iVar8 = iVar23;
        do {
          if (0 < (int)uVar24) {
            iVar15 = *param_1;
            iVar16 = *local_38;
            iVar5 = *(int *)local_38[1];
            iVar17 = *(int *)param_1[1];
            if (uVar24 == 1) {
LAB_00020e84:
              uVar11 = 0;
            }
            else {
              iVar21 = iVar23 + uVar9 * 8;
              if ((iVar5 * uVar9 * 8 + iVar16 < iVar17 * iVar21 + iVar15 + uVar24 * 8) &&
                 ((uint)(iVar17 * iVar21 + iVar15) < iVar5 * uVar9 * 8 + iVar16 + uVar24 * 8))
              goto LAB_00020e84;
              puVar7 = (undefined8 *)(iVar5 * iVar1 + iVar16);
              puVar4 = (undefined8 *)(iVar17 * iVar8 + iVar15);
              uVar11 = uVar18;
              do {
                uVar25 = *puVar4;
                uVar27 = puVar4[1];
                puVar4 = puVar4 + 2;
                uVar11 = uVar11 - 2;
                *puVar7 = uVar25;
                puVar7[1] = uVar27;
                puVar7 = puVar7 + 2;
              } while (uVar11 != 0);
              uVar11 = uVar18;
              if (uVar24 == uVar18) goto LAB_00020e2c;
            }
            iVar21 = uVar24 - uVar11;
            puVar4 = (undefined8 *)(iVar15 + (iVar17 * iVar3 + uVar11) * 8);
            puVar7 = (undefined8 *)(iVar16 + (iVar5 * uVar9 + uVar11) * 8);
            do {
              uVar25 = *puVar4;
              puVar4 = puVar4 + 1;
              iVar21 = iVar21 + -1;
              *puVar7 = uVar25;
              puVar7 = puVar7 + 1;
            } while (iVar21 != 0);
          }
LAB_00020e2c:
          uVar9 = uVar9 + 1;
          iVar3 = iVar3 + 1;
          iVar1 = iVar1 + 8;
          iVar8 = iVar8 + 8;
        } while (uVar9 != uVar2);
      }
      piVar14 = (int *)param_6[1];
      piVar13 = (int *)local_30[0][1];
      iVar8 = *piVar14;
      iVar1 = piVar14[1];
      *piVar14 = uVar12 + *piVar13;
      piVar14[1] = piVar13[1];
      emxEnsureCapacity_real_T(param_6,iVar1 * iVar8);
      puVar6 = (uint *)local_30[0][1];
      uVar24 = puVar6[1];
      if (0 < (int)uVar24) {
        iVar1 = 0;
        uVar9 = 0;
        uVar2 = *puVar6;
        uVar18 = uVar2 & 0xfffffffe;
        iVar8 = 0;
        do {
          if (0 < (int)uVar2) {
            iVar5 = *local_30[0];
            iVar23 = *param_6;
            iVar3 = *(int *)param_6[1];
            if ((uVar2 == 1) ||
               ((iVar3 * uVar9 * 8 + iVar23 < iVar5 + (uVar2 * uVar9 + uVar2) * 8 &&
                (iVar5 + uVar2 * uVar9 * 8 < iVar3 * uVar9 * 8 + iVar23 + uVar2 * 8)))) {
              uVar11 = 0;
            }
            else {
              puVar4 = (undefined8 *)(iVar3 * iVar1 + iVar23);
              puVar7 = (undefined8 *)(iVar5 + iVar8 * 8);
              uVar11 = uVar18;
              do {
                uVar25 = *puVar7;
                uVar27 = puVar7[1];
                puVar7 = puVar7 + 2;
                uVar11 = uVar11 - 2;
                *puVar4 = uVar25;
                puVar4[1] = uVar27;
                puVar4 = puVar4 + 2;
              } while (uVar11 != 0);
              uVar11 = uVar18;
              if (uVar2 == uVar18) goto LAB_00020f16;
            }
            iVar15 = uVar2 - uVar11;
            puVar4 = (undefined8 *)(iVar5 + (uVar11 + iVar8) * 8);
            puVar7 = (undefined8 *)(iVar23 + (iVar3 * uVar9 + uVar11) * 8);
            do {
              uVar25 = *puVar4;
              puVar4 = puVar4 + 1;
              iVar15 = iVar15 + -1;
              *puVar7 = uVar25;
              puVar7 = puVar7 + 1;
            } while (iVar15 != 0);
          }
LAB_00020f16:
          uVar9 = uVar9 + 1;
          iVar8 = iVar8 + uVar2;
          iVar1 = iVar1 + 8;
        } while (uVar9 != uVar24);
      }
      if (0 < (int)uVar10) {
        uVar18 = uVar12 & 0xfffffffe;
        iVar8 = 0;
        uVar24 = 0;
        do {
          if (0 < (int)uVar12) {
            iVar23 = *param_6;
            iVar1 = *local_38;
            uVar2 = *puVar6;
            iVar3 = *(int *)param_6[1];
            if (uVar12 == 1) {
LAB_00021016:
              uVar9 = 0;
            }
            else {
              iVar5 = iVar3 * uVar24 + uVar2;
              puVar4 = (undefined8 *)(iVar23 + iVar5 * 8);
              if ((puVar4 < (undefined8 *)(iVar1 + (uVar12 * uVar24 + uVar12) * 8)) &&
                 (iVar1 + uVar12 * uVar24 * 8 < iVar23 + uVar12 * 8 + iVar5 * 8)) goto LAB_00021016;
              puVar7 = (undefined8 *)(iVar1 + iVar8 * 8);
              uVar9 = uVar18;
              do {
                uVar25 = *puVar7;
                uVar27 = puVar7[1];
                puVar7 = puVar7 + 2;
                uVar9 = uVar9 - 2;
                *puVar4 = uVar25;
                puVar4[1] = uVar27;
                puVar4 = puVar4 + 2;
              } while (uVar9 != 0);
              uVar9 = uVar18;
              if (uVar12 == uVar18) goto LAB_00020fc4;
            }
            iVar5 = uVar12 - uVar9;
            puVar4 = (undefined8 *)(iVar1 + (uVar9 + iVar8) * 8);
            puVar7 = (undefined8 *)(iVar23 + (iVar3 * uVar24 + uVar9 + uVar2) * 8);
            do {
              uVar25 = *puVar4;
              puVar4 = puVar4 + 1;
              iVar5 = iVar5 + -1;
              *puVar7 = uVar25;
              puVar7 = puVar7 + 1;
            } while (iVar5 != 0);
          }
LAB_00020fc4:
          uVar24 = uVar24 + 1;
          iVar8 = iVar8 + uVar12;
        } while (uVar24 != uVar10);
      }
    }
  }
  else {
    piVar14 = (int *)param_6[1];
    iVar8 = *piVar14;
    iVar1 = piVar14[1];
    *piVar14 = 0;
    piVar14[1] = 0;
    emxEnsureCapacity_real_T(param_6,iVar1 * iVar8);
  }
  emxFree_real_T(&local_38);
  emxFree_real_T(&local_34);
  emxFreeMatrix_cell_wrap_1(local_30);
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void b_sign(int *param_1)

{
  double *pdVar1;
  int iVar2;
  double dVar3;
  double dVar4;
  
  iVar2 = *(int *)param_1[1];
  if (iVar2 < 1) {
    return;
  }
  pdVar1 = (double *)*param_1;
  do {
    dVar3 = *pdVar1;
    dVar4 = -1.0;
    if (-1 < (int)((uint)(dVar3 < 0.0) << 0x1f)) {
      dVar4 = 1.0;
      if ((dVar3 == 0.0 || dVar3 < 0.0 != NAN(dVar3)) && (dVar4 = dVar3, dVar3 == 0.0)) {
        dVar4 = 0.0;
      }
    }
    *pdVar1 = dVar4;
    pdVar1 = pdVar1 + 1;
    iVar2 = iVar2 + -1;
  } while (iVar2 != 0);
  return;
}



void sort(int *param_1)

{
  uint uVar1;
  int iVar2;
  undefined8 *puVar3;
  uint uVar4;
  int iVar5;
  undefined8 *puVar6;
  undefined8 *puVar7;
  uint uVar8;
  int iVar9;
  uint uVar10;
  undefined8 *puVar11;
  bool bVar12;
  undefined8 uVar13;
  undefined8 uVar14;
  int local_34;
  undefined4 local_30;
  uint *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar10 = *(uint *)param_1[1];
  emxInit_real_T(&local_2c,1);
  uVar4 = *(uint *)local_2c[1];
  *(uint *)local_2c[1] = uVar10;
  emxEnsureCapacity_real_T1(local_2c,uVar4);
  if (uVar10 == 1) {
    local_34 = *(int *)param_1[1];
    emxInit_int32_T1(&local_30,1);
    if (local_34 < 1) goto LAB_00021100;
  }
  else {
    local_34 = 1;
    emxInit_int32_T1(&local_30,1);
  }
  uVar4 = uVar10 - 1;
  iVar9 = 0;
  if (uVar4 != 0) {
    uVar4 = 1;
  }
  uVar4 = uVar4 & local_34 == 1;
  uVar1 = uVar10 & 0xfffffffe;
  iVar2 = 1;
  do {
    if ((int)uVar10 < 1) {
      sortIdx(local_2c,local_30);
    }
    else {
      iVar5 = *param_1;
      puVar11 = (undefined8 *)*local_2c;
      if (uVar4 == 0) {
LAB_000211b2:
        uVar8 = 0;
LAB_000211b4:
        puVar6 = (undefined8 *)(iVar5 + (local_34 * uVar8 + iVar9) * 8);
        puVar11 = puVar11 + uVar8;
        iVar5 = uVar10 - uVar8;
        do {
          uVar13 = *puVar6;
          puVar6 = puVar6 + local_34;
          iVar5 = iVar5 + -1;
          *puVar11 = uVar13;
          puVar11 = puVar11 + 1;
        } while (iVar5 != 0);
      }
      else {
        puVar6 = (undefined8 *)(iVar5 + (uVar10 + iVar9) * 8);
        puVar7 = (undefined8 *)(iVar5 + iVar9 * 8);
        bVar12 = puVar11 < puVar6;
        if (bVar12) {
          puVar6 = puVar11 + uVar10;
        }
        puVar3 = puVar11;
        uVar8 = uVar1;
        if (bVar12 && puVar7 < puVar6) goto LAB_000211b2;
        do {
          uVar13 = *puVar7;
          uVar14 = puVar7[1];
          puVar7 = puVar7 + local_34 * 2;
          uVar8 = uVar8 - 2;
          *puVar3 = uVar13;
          puVar3[1] = uVar14;
          puVar3 = puVar3 + 2;
        } while (uVar8 != 0);
        uVar8 = uVar1;
        if (uVar10 != uVar1) goto LAB_000211b4;
      }
      sortIdx(local_2c,local_30);
      if (0 < (int)uVar10) {
        iVar5 = *param_1;
        puVar11 = (undefined8 *)*local_2c;
        if (uVar4 == 0) {
LAB_0002121c:
          uVar8 = 0;
        }
        else {
          puVar6 = puVar11 + uVar10;
          puVar7 = (undefined8 *)(iVar5 + iVar9 * 8);
          bVar12 = puVar7 < puVar6;
          if (bVar12) {
            puVar6 = (undefined8 *)(iVar5 + (uVar10 + iVar9) * 8);
          }
          puVar3 = puVar11;
          uVar8 = uVar1;
          if (bVar12 && puVar11 < puVar6) goto LAB_0002121c;
          do {
            uVar13 = puVar3[1];
            uVar8 = uVar8 - 2;
            *puVar7 = *puVar3;
            puVar7[1] = uVar13;
            puVar7 = puVar7 + local_34 * 2;
            puVar3 = puVar3 + 2;
          } while (uVar8 != 0);
          uVar8 = uVar1;
          if (uVar10 == uVar1) goto LAB_0002115e;
        }
        puVar6 = (undefined8 *)(iVar5 + (local_34 * uVar8 + iVar9) * 8);
        puVar11 = puVar11 + uVar8;
        iVar5 = uVar10 - uVar8;
        do {
          uVar13 = *puVar11;
          puVar11 = puVar11 + 1;
          iVar5 = iVar5 + -1;
          *puVar6 = uVar13;
          puVar6 = puVar6 + local_34;
        } while (iVar5 != 0);
      }
    }
LAB_0002115e:
    iVar9 = iVar9 + 1;
    bVar12 = iVar2 != local_34;
    iVar2 = iVar2 + 1;
  } while (bVar12);
LAB_00021100:
  emxFree_int32_T(&local_30);
  emxFree_real_T(&local_2c);
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void sortIdx(int *param_1,int *param_2)

{
  undefined2 uVar1;
  undefined4 uVar2;
  uint *puVar3;
  undefined4 *puVar4;
  undefined8 *puVar5;
  int iVar6;
  uint uVar7;
  int iVar8;
  double *pdVar9;
  undefined4 *puVar10;
  int iVar11;
  char *pcVar12;
  int iVar13;
  int iVar14;
  uint uVar15;
  uint uVar16;
  double *pdVar17;
  int iVar18;
  int iVar19;
  int iVar20;
  uint uVar21;
  int iVar22;
  int iVar23;
  int iVar24;
  int iVar25;
  int iVar26;
  uint uVar27;
  uint uVar28;
  int iVar29;
  undefined8 *puVar30;
  double dVar31;
  undefined8 uVar32;
  double dVar33;
  uint local_c90;
  uint local_c8c;
  uint local_c88;
  uint local_c84;
  uint local_c78;
  undefined4 local_c6c;
  int *local_c68;
  undefined4 *local_c64;
  double local_c60 [256];
  undefined4 local_460;
  undefined8 local_45c [127];
  uint uStack_64;
  undefined8 local_60;
  double adStack_58 [5];
  int iStack_2c;
  
  iStack_2c = __stack_chk_guard;
  iVar6 = *(int *)param_2[1];
  iVar14 = *(int *)param_1[1];
  *(int *)param_2[1] = iVar14;
  emxEnsureCapacity_int32_T1(param_2,iVar6);
  if (0 < iVar14) {
    FUN_00022030(*param_2,iVar14 << 2);
  }
  local_60 = 0;
  adStack_58[0] = 0.0;
  uVar21 = *(uint *)param_1[1];
  adStack_58[1] = 0.0;
  adStack_58[2] = 0.0;
  adStack_58[3] = 0.0;
  adStack_58[4] = 0.0;
  emxInit_int32_T1(&local_c64,1);
  iVar6 = *(int *)local_c64[1];
  *(int *)local_c64[1] = iVar14;
  emxEnsureCapacity_int32_T1(local_c64,iVar6);
  if (0 < iVar14) {
    FUN_00022030(*local_c64,iVar14 << 2);
  }
  emxInit_real_T(&local_c68,1);
  iVar14 = *(int *)param_1[1];
  iVar6 = *(int *)local_c68[1];
  *(int *)local_c68[1] = iVar14;
  emxEnsureCapacity_real_T1(local_c68,iVar6);
  if (0 < iVar14) {
    FUN_00022030(*local_c68,iVar14 << 3);
  }
  if ((int)uVar21 < 1) {
    iVar6 = uVar21 - 1;
    uVar27 = uVar21;
    goto joined_r0x0002170e;
  }
  local_c84 = local_c6c & 0xff;
  iVar23 = 0;
  iVar6 = 4;
  local_c88 = local_c6c >> 8 & 0xff;
  uVar27 = 0;
  local_c8c = local_c6c >> 0x10 & 0xff;
  local_c90 = local_c6c >> 0x18;
  local_c78 = 1;
  iVar14 = 0;
  iVar25 = *param_1;
  do {
    iVar25 = rtIsNaN((int)*(undefined8 *)(iVar25 + iVar23),
                     (int)((ulonglong)*(undefined8 *)(iVar25 + iVar23) >> 0x20));
    uVar27 = uVar27 + 1;
    if (iVar25 == 0) {
      iVar25 = *param_1;
      *(uint *)((int)&local_60 + iVar14 * 4) = uVar27;
      iVar11 = iVar14 + 1;
      iVar14 = iVar14 + 1;
      adStack_58[iVar11] = *(double *)(iVar25 + iVar23);
      if (iVar14 == 4) {
        uVar7 = 4;
        uVar16 = 1;
        local_c8c = 3;
        uVar28 = 2;
        if (adStack_58[4] < adStack_58[3]) {
          uVar7 = 3;
        }
        if (adStack_58[2] < adStack_58[1]) {
          uVar16 = 2;
        }
        if (adStack_58[4] < adStack_58[3]) {
          local_c8c = 4;
        }
        if (adStack_58[2] < adStack_58[1]) {
          uVar28 = 1;
        }
        local_c90 = uVar7;
        if (adStack_58[uVar16] <= adStack_58[local_c8c]) {
          local_c84 = uVar16;
          local_c88 = uVar28;
          if ((adStack_58[local_c8c] < adStack_58[uVar28]) &&
             (local_c88 = local_c8c, local_c8c = uVar28, adStack_58[uVar7] < adStack_58[uVar28])) {
            local_c90 = uVar28;
            local_c8c = uVar7;
          }
        }
        else {
          local_c90 = uVar28;
          local_c84 = local_c8c;
          local_c88 = uVar7;
          local_c8c = uVar16;
          if ((adStack_58[uVar16] <= adStack_58[uVar7]) &&
             (local_c90 = uVar7, local_c88 = uVar16, local_c8c = uVar28,
             adStack_58[uVar7] < adStack_58[uVar28])) {
            local_c90 = uVar28;
            local_c8c = uVar7;
          }
        }
        iVar14 = *param_2 + local_c78 * -4;
        *(undefined4 *)(iVar14 + iVar6) = *(undefined4 *)((int)&local_60 + (local_c90 - 1) * 4);
        iVar14 = iVar14 + iVar6;
        *(undefined4 *)(iVar14 + -0xc) = *(undefined4 *)((int)&local_60 + (local_c84 - 1) * 4);
        pdVar17 = (double *)(iVar23 + local_c78 * -8 + iVar25);
        pdVar17[-2] = adStack_58[local_c84];
        pdVar17[-1] = adStack_58[local_c88];
        *pdVar17 = adStack_58[local_c8c];
        dVar31 = adStack_58[local_c90];
        uVar2 = *(undefined4 *)((int)&local_60 + (local_c8c - 1) * 4);
        *(undefined4 *)(iVar14 + -8) = *(undefined4 *)((int)&local_60 + (local_c88 - 1) * 4);
        *(undefined4 *)(iVar14 + -4) = uVar2;
        pdVar17[1] = dVar31;
        iVar14 = 0;
      }
    }
    else {
      iVar11 = *local_c68;
      iVar25 = *param_1;
      iVar13 = uVar21 - local_c78;
      local_c78 = local_c78 + 1;
      *(uint *)(*param_2 + iVar13 * 4) = uVar27;
      *(undefined8 *)(iVar11 + iVar13 * 8) = *(undefined8 *)(iVar25 + iVar23);
    }
    iVar6 = iVar6 + 4;
    iVar23 = iVar23 + 8;
  } while (uVar21 != uVar27);
  iVar6 = uVar21 - local_c78;
  local_c6c = CONCAT31(CONCAT21(CONCAT11((char)local_c90,(char)local_c8c),(char)local_c88),
                       (char)local_c84);
  if (0 < iVar14) {
    local_c6c._2_2_ = 0;
    if (iVar14 == 2) {
      if (adStack_58[1] <= adStack_58[2]) {
LAB_000215ce:
        uVar1 = 0x201;
LAB_000215d2:
        local_c6c = CONCAT22(local_c6c._2_2_,uVar1);
        goto LAB_000215d6;
      }
LAB_000215b8:
      local_c6c = CONCAT22(local_c6c._2_2_,0x102);
      iVar23 = 1;
    }
    else if (iVar14 == 1) {
      local_c6c = 1;
LAB_000215d6:
      iVar23 = 0;
    }
    else {
      if (adStack_58[1] <= adStack_58[2]) {
        if (adStack_58[2] <= adStack_58[3]) {
          local_c6c._2_2_ = 3;
          goto LAB_000215ce;
        }
        iVar23 = 2;
        if (adStack_58[3] < adStack_58[1]) {
          uVar1 = 0x103;
          goto LAB_0002199e;
        }
        local_c6c._2_2_ = 2;
        uVar1 = 0x301;
        goto LAB_000215d2;
      }
      if (adStack_58[1] <= adStack_58[3]) {
        local_c6c._2_2_ = 3;
        goto LAB_000215b8;
      }
      iVar23 = 1;
      if (adStack_58[2] <= adStack_58[3]) {
        uVar1 = 0x302;
LAB_0002199e:
        local_c6c = (uint)CONCAT12((char)iVar23,uVar1);
      }
      else {
        local_c6c = 0x10203;
        iVar23 = 2;
      }
    }
    iVar11 = (iVar6 - iVar14) + 1;
    iVar25 = *param_2;
    *(undefined4 *)(iVar25 + iVar11 * 4) = *(undefined4 *)((int)&local_60 + iVar23 * 4);
    iVar23 = *param_1;
    *(double *)(iVar23 + iVar11 * 8) = adStack_58[(char)local_c6c];
    if (iVar14 != 1) {
      pdVar17 = (double *)(iVar23 + (uVar21 + 2) * 8 + (iVar14 + local_c78) * -8);
      pcVar12 = (char *)&local_c6c;
      iVar23 = iVar14 + -1;
      puVar3 = (uint *)(iVar25 + (uVar21 + 2) * 4 + (iVar14 + local_c78) * -4);
      do {
        pcVar12 = pcVar12 + 1;
        iVar23 = iVar23 + -1;
        *puVar3 = (&uStack_64)[*pcVar12];
        *pdVar17 = adStack_58[*pcVar12];
        pdVar17 = pdVar17 + 1;
        puVar3 = puVar3 + 1;
      } while (iVar23 != 0);
    }
  }
  iVar14 = (int)(local_c78 - 1) >> 1;
  if (2 < (int)local_c78) {
    iVar25 = *param_1;
    iVar11 = *local_c68;
    puVar4 = (undefined4 *)(*param_2 + uVar21 * 4);
    iVar13 = iVar25 + local_c78 * -8;
    iVar23 = iVar11 + local_c78 * -8;
    iVar26 = uVar21 * 8;
    iVar18 = 0;
    puVar10 = puVar4;
    do {
      iVar11 = iVar11 + -8;
      iVar25 = iVar25 + -8;
      puVar10 = puVar10 + -1;
      iVar23 = iVar23 + 8;
      iVar13 = iVar13 + 8;
      uVar2 = puVar4[(iVar18 + 1) - local_c78];
      puVar4[(iVar18 + 1) - local_c78] = *puVar10;
      iVar18 = iVar18 + 1;
      *(undefined8 *)(iVar13 + iVar26) = *(undefined8 *)(iVar11 + iVar26);
      *(undefined8 *)(iVar25 + iVar26) = *(undefined8 *)(iVar23 + iVar26);
      *puVar10 = uVar2;
    } while (iVar18 < iVar14);
  }
  if ((local_c78 - 1 & 1) == 0) {
    uVar27 = iVar6 + 1;
  }
  else {
    iVar14 = iVar6 + 1U + iVar14;
    *(undefined8 *)(*param_1 + iVar14 * 8) = *(undefined8 *)(*local_c68 + iVar14 * 8);
    uVar27 = iVar6 + 1U;
  }
joined_r0x0002170e:
  if (0 < iVar6) {
    if (((int)uVar21 < 0x100) || (iVar6 < 0xff)) {
      uVar2 = 2;
    }
    else {
      iVar6 = 1;
      iVar14 = 0;
      do {
        uVar21 = 0;
        do {
          uVar7 = 0x20 >> (uVar21 & 0xff);
          if (0 < (int)uVar7) {
            iVar25 = 1;
            iVar13 = 4 << (uVar21 & 0xff);
            iVar11 = iVar13 * 2;
            iVar23 = 1;
            if (1 < iVar11) {
              iVar23 = iVar11;
            }
            local_c78 = 0;
            do {
              if (0 < iVar13) {
                iVar26 = iVar11 * local_c78 + iVar14 * 0x100;
                iVar18 = *param_1;
                memcpy(&local_460,(void *)(*param_2 + iVar26 * 4),iVar23 << 2);
                memcpy(local_c60,(void *)(iVar18 + iVar26 * 8),iVar23 << 3);
              }
              uVar16 = 0;
              iVar18 = iVar13;
              iVar26 = (iVar25 + -1) * iVar11 + iVar6 * 0x100 + -0x101;
              do {
                iVar29 = iVar26;
                uVar28 = uVar16;
                uVar15 = (iVar13 + -1) - uVar28;
                puVar30 = (undefined8 *)((int)local_45c + uVar28 * 4);
                pdVar17 = local_c60 + uVar28 + 1;
                dVar31 = local_c60[iVar18];
                iVar8 = iVar29 + 3;
                uVar16 = uVar28;
                iVar20 = iVar29;
                while( true ) {
                  iVar26 = iVar20 + 1;
                  dVar33 = local_c60[uVar16];
                  if (dVar31 < dVar33) break;
                  uVar15 = uVar15 - 1;
                  puVar30 = (undefined8 *)((int)puVar30 + 4);
                  iVar8 = iVar8 + 1;
                  pdVar17 = pdVar17 + 1;
                  iVar19 = *param_1;
                  iVar20 = uVar16 * 4;
                  uVar16 = uVar16 + 1;
                  *(undefined4 *)(*param_2 + iVar26 * 4) =
                       *(undefined4 *)((int)local_45c + iVar20 + -4);
                  *(double *)(iVar19 + iVar26 * 8) = dVar33;
                  iVar20 = iVar26;
                  if (iVar13 <= (int)uVar16) goto LAB_000217a8;
                }
                iVar24 = *param_2;
                iVar22 = *param_1;
                iVar19 = iVar18 * 4;
                iVar18 = iVar18 + 1;
                *(undefined4 *)(iVar24 + iVar26 * 4) = *(undefined4 *)((int)local_45c + iVar19 + -4)
                ;
                *(double *)(iVar22 + iVar26 * 8) = dVar31;
              } while (iVar18 < iVar11);
              if ((int)uVar16 < iVar13) {
                iVar18 = uVar16 + 1;
                *(undefined4 *)(iVar24 + (iVar20 + 2) * 4) =
                     *(undefined4 *)((int)local_45c + uVar16 * 4 + -4);
                *(double *)(iVar22 + (iVar20 + 2) * 8) = dVar33;
                if (iVar18 != iVar13) {
                  uVar16 = iVar13 + ~uVar16;
                  if (1 < uVar16) {
                    puVar5 = (undefined8 *)(iVar24 + iVar8 * 4);
                    pdVar9 = (double *)(iVar22 + iVar8 * 8);
                    iVar18 = iVar18 + (uVar16 & 0xfffffffe);
                    uVar15 = uVar15 & 0xfffffffe;
                    do {
                      uVar32 = *puVar30;
                      puVar30 = puVar30 + 1;
                      uVar15 = uVar15 - 2;
                      dVar31 = *pdVar17;
                      dVar33 = pdVar17[1];
                      pdVar17 = pdVar17 + 2;
                      *puVar5 = uVar32;
                      puVar5 = puVar5 + 1;
                      *pdVar9 = dVar31;
                      pdVar9[1] = dVar33;
                      pdVar9 = pdVar9 + 2;
                    } while (uVar15 != 0);
                    if (uVar16 == (uVar16 & 0xfffffffe)) goto LAB_000217a8;
                  }
                  pdVar17 = local_c60 + iVar18;
                  iVar26 = iVar13 - iVar18;
                  iVar20 = (iVar29 + iVar18) - uVar28;
                  pdVar9 = (double *)(iVar22 + iVar20 * 8 + 0x10);
                  puVar10 = (undefined4 *)((int)local_45c + iVar18 * 4 + -4);
                  puVar4 = (undefined4 *)(iVar24 + iVar20 * 4 + 8);
                  do {
                    dVar31 = *pdVar17;
                    pdVar17 = pdVar17 + 1;
                    uVar2 = *puVar10;
                    iVar26 = iVar26 + -1;
                    *pdVar9 = dVar31;
                    pdVar9 = pdVar9 + 1;
                    *puVar4 = uVar2;
                    puVar10 = puVar10 + 1;
                    puVar4 = puVar4 + 1;
                  } while (iVar26 != 0);
                }
              }
LAB_000217a8:
              local_c78 = local_c78 + 1;
              iVar25 = iVar25 + 1;
            } while (local_c78 != uVar7);
          }
          uVar21 = uVar21 + 1;
        } while (uVar21 != 6);
        iVar14 = iVar14 + 1;
        iVar6 = iVar6 + 1;
      } while (iVar14 < (int)uVar27 >> 8);
      if ((uVar27 & 0xff) != 0) {
        FUN_000219b2(param_2,param_1,uVar27 & 0xffffff00,uVar27 & 0xff,2,local_c64,local_c68);
      }
      uVar2 = 8;
    }
    FUN_000219b2(param_2,param_1,0,uVar27,uVar2,local_c64,local_c68);
  }
  emxFree_real_T(&local_c68);
  emxFree_int32_T(&local_c64);
  if (__stack_chk_guard != iStack_2c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void FUN_000219b2(undefined4 param_1,undefined4 param_2,int param_3,int param_4,uint param_5,
                 undefined4 param_6,undefined4 param_7)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  int iVar6;
  
  uVar1 = param_4 >> (param_5 & 0xff);
  iVar5 = 1 << (param_5 & 0xff);
  iVar6 = iVar5;
  if (1 < (int)uVar1) {
    do {
      uVar2 = uVar1;
      if ((uVar1 & 1) != 0) {
        uVar2 = uVar1 - 1;
        iVar5 = param_4 - iVar6 * uVar2;
        if (iVar6 < iVar5) {
          FUN_00021a6c(param_1,param_2,iVar6 * uVar2 + param_3,iVar6,iVar5 - iVar6,param_6,param_7);
        }
      }
      uVar1 = uVar2 >> 1;
      iVar5 = iVar6 * 2;
      iVar3 = param_3;
      for (uVar4 = uVar2 >> 1; uVar4 != 0; uVar4 = uVar4 - 1) {
        FUN_00021a6c(param_1,param_2,iVar3,iVar6,iVar6,param_6,param_7);
        iVar3 = iVar3 + iVar5;
      }
      iVar6 = iVar5;
    } while (3 < uVar2);
  }
  if (iVar5 < param_4) {
    FUN_00021a6c(param_1,param_2,param_3,iVar5,param_4 - iVar5,param_6,param_7);
  }
  return;
}



void FUN_00021a6c(int *param_1,int *param_2,int param_3,int param_4,int param_5,uint *param_6,
                 uint *param_7)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  int iVar4;
  double *pdVar5;
  int iVar6;
  int iVar7;
  undefined4 *puVar8;
  int iVar9;
  uint uVar10;
  int iVar11;
  uint uVar12;
  undefined8 *puVar13;
  undefined4 *puVar14;
  int iVar15;
  undefined8 *puVar16;
  double *pdVar17;
  undefined8 *puVar18;
  int iVar19;
  uint uVar20;
  int iVar21;
  uint uVar22;
  int iVar23;
  undefined8 *puVar24;
  int iVar25;
  undefined8 uVar26;
  double dVar27;
  double dVar28;
  undefined8 uVar29;
  undefined8 uVar30;
  uint local_3c;
  
  if (param_5 == 0) {
    return;
  }
  uVar12 = param_5 + param_4;
  if ((int)uVar12 < 1) {
    local_3c = *param_7;
  }
  else {
    local_3c = *param_7;
    uVar22 = 0;
    puVar24 = (undefined8 *)*param_6;
    iVar15 = *param_2;
    iVar9 = *param_1;
    if (uVar12 != 1) {
      puVar18 = (undefined8 *)(iVar9 + param_3 * 4);
      uVar20 = iVar15 + param_3 * 8;
      if (((undefined8 *)(iVar9 + (uVar12 + param_3) * 4) <= puVar24 ||
           (undefined8 *)((int)puVar24 + uVar12 * 4) <= puVar18) &&
         (iVar15 + (uVar12 + param_3) * 8 <= local_3c || local_3c + uVar12 * 8 <= uVar20)) {
        uVar22 = uVar12 & 0xfffffffe;
        iVar7 = 0;
        uVar10 = uVar22;
        puVar16 = puVar24;
        do {
          uVar26 = *puVar18;
          puVar18 = puVar18 + 1;
          puVar13 = (undefined8 *)(uVar20 + iVar7);
          uVar10 = uVar10 - 2;
          uVar29 = *puVar13;
          uVar30 = puVar13[1];
          puVar13 = (undefined8 *)(local_3c + iVar7);
          iVar7 = iVar7 + 0x10;
          *puVar16 = uVar26;
          puVar16 = puVar16 + 1;
          *puVar13 = uVar29;
          puVar13[1] = uVar30;
        } while (uVar10 != 0);
        if (uVar12 == uVar22) goto LAB_00021b92;
      }
    }
    iVar7 = uVar12 - uVar22;
    iVar1 = uVar22 << 3;
    puVar8 = (undefined4 *)(iVar9 + (uVar22 + param_3) * 4);
    puVar14 = (undefined4 *)((int)puVar24 + uVar22 * 4);
    do {
      puVar24 = (undefined8 *)(iVar15 + param_3 * 8 + iVar1);
      iVar7 = iVar7 + -1;
      puVar18 = (undefined8 *)(local_3c + iVar1);
      iVar1 = iVar1 + 8;
      *puVar18 = *puVar24;
      *puVar14 = *puVar8;
      puVar8 = puVar8 + 1;
      puVar14 = puVar14 + 1;
    } while (iVar7 != 0);
  }
LAB_00021b92:
  uVar22 = *param_6;
  iVar9 = param_3 + -1;
  iVar15 = param_4;
  iVar7 = 0;
  do {
    iVar1 = iVar7;
    iVar6 = iVar9;
    iVar19 = uVar22 + iVar1 * 4;
    iVar25 = 0;
    iVar23 = 0;
    iVar11 = 0;
    uVar20 = param_4 - iVar1;
    while( true ) {
      pdVar17 = (double *)(local_3c + iVar1 * 8 + iVar23);
      dVar27 = *(double *)(local_3c + iVar15 * 8);
      dVar28 = *pdVar17;
      if (dVar27 < dVar28) break;
      iVar25 = iVar25 + -4;
      iVar7 = iVar11 * 4;
      uVar20 = uVar20 - 1;
      iVar9 = iVar11 * 4;
      iVar11 = iVar11 + 1;
      iVar3 = *param_2;
      *(undefined4 *)(*param_1 + iVar6 * 4 + iVar9 + 4) = *(undefined4 *)(iVar19 + iVar7);
      iVar9 = iVar3 + iVar6 * 8 + iVar23;
      iVar23 = iVar23 + 8;
      *(double *)(iVar9 + 8) = dVar28;
      if (param_4 <= iVar1 + iVar11) {
        return;
      }
    }
    iVar3 = *param_1;
    iVar9 = iVar15 * 4;
    iVar21 = iVar3 + iVar6 * 4;
    iVar15 = iVar15 + 1;
    iVar4 = *param_2;
    *(undefined4 *)(iVar21 + iVar11 * 4 + 4) = *(undefined4 *)(uVar22 + iVar9);
    iVar7 = iVar1 + iVar11;
    iVar23 = iVar23 + iVar4 + iVar6 * 8;
    *(double *)(iVar23 + 8) = dVar27;
    iVar9 = iVar6 + iVar11 + 1;
  } while (iVar15 < (int)uVar12);
  if (iVar7 < param_4) {
    uVar12 = (param_4 - iVar1) - iVar11;
    if (1 < uVar12) {
      puVar18 = (undefined8 *)(iVar19 - iVar25);
      pdVar5 = (double *)(iVar23 + 0x10);
      iVar9 = ((iVar6 + param_4 + iVar11) - iVar7) + 2;
      puVar24 = (undefined8 *)((iVar21 - iVar25) + 8);
      if (((undefined8 *)(uVar22 + param_4 * 4) <= puVar24 ||
           (undefined8 *)(iVar3 + iVar9 * 4) <= puVar18) &&
         ((double *)(local_3c + param_4 * 8) <= pdVar5 || (double *)(iVar4 + iVar9 * 8) <= pdVar17))
      {
        iVar7 = (uVar20 & 0xfffffffe) + iVar1 + iVar11;
        uVar20 = uVar12 & 0xfffffffe;
        do {
          uVar26 = *puVar18;
          puVar18 = puVar18 + 1;
          uVar20 = uVar20 - 2;
          dVar27 = *pdVar17;
          dVar28 = pdVar17[1];
          pdVar17 = pdVar17 + 2;
          *puVar24 = uVar26;
          puVar24 = puVar24 + 1;
          *pdVar5 = dVar27;
          pdVar5[1] = dVar28;
          pdVar5 = pdVar5 + 2;
        } while (uVar20 != 0);
        if (uVar12 == (uVar12 & 0xfffffffe)) {
          return;
        }
      }
    }
    iVar1 = (iVar6 + iVar7) - iVar1;
    puVar24 = (undefined8 *)(local_3c + iVar7 * 8);
    param_4 = param_4 - iVar7;
    puVar18 = (undefined8 *)(iVar4 + iVar1 * 8 + 0x10);
    puVar8 = (undefined4 *)(iVar3 + iVar1 * 4 + 8);
    puVar14 = (undefined4 *)(uVar22 + iVar7 * 4);
    do {
      uVar26 = *puVar24;
      puVar24 = puVar24 + 1;
      uVar2 = *puVar14;
      param_4 = param_4 + -1;
      *puVar18 = uVar26;
      puVar18 = puVar18 + 1;
      *puVar8 = uVar2;
      puVar8 = puVar8 + 1;
      puVar14 = puVar14 + 1;
    } while (param_4 != 0);
  }
  return;
}



void b_sqrt(int *param_1)

{
  double *pdVar1;
  int iVar2;
  
  iVar2 = *(int *)(param_1[1] + 4);
  if (iVar2 < 1) {
    return;
  }
  pdVar1 = (double *)*param_1;
  do {
    iVar2 = iVar2 + -1;
    *pdVar1 = SQRT(*pdVar1);
    pdVar1 = pdVar1 + 1;
  } while (iVar2 != 0);
  return;
}



void b_sum(int *param_1,double *param_2)

{
  double *pdVar1;
  int iVar2;
  double dVar3;
  double dVar4;
  
  iVar2 = *(int *)(param_1[1] + 4);
  if (iVar2 == 0) {
    *param_2 = 0.0;
    param_2[1] = 0.0;
    return;
  }
  pdVar1 = (double *)*param_1;
  dVar3 = *pdVar1;
  *param_2 = dVar3;
  dVar4 = pdVar1[1];
  param_2[1] = dVar4;
  if (iVar2 < 2) {
    return;
  }
  iVar2 = iVar2 + -1;
  do {
    iVar2 = iVar2 + -1;
    dVar3 = dVar3 + pdVar1[2];
    *param_2 = dVar3;
    dVar4 = dVar4 + pdVar1[3];
    param_2[1] = dVar4;
    pdVar1 = pdVar1 + 2;
  } while (iVar2 != 0);
  return;
}



void c_sum(void)

{
  combineVectorElements();
  return;
}



void d_sum(int *param_1,int *param_2)

{
  int *piVar1;
  int iVar2;
  double *pdVar3;
  int iVar4;
  double *pdVar5;
  int iVar6;
  double dVar7;
  double dVar8;
  
  piVar1 = (int *)param_2[1];
  iVar6 = param_1[1];
  iVar2 = *piVar1;
  iVar4 = piVar1[1];
  *piVar1 = 1;
  piVar1[1] = *(int *)(iVar6 + 4);
  emxEnsureCapacity_real_T(param_2,iVar4 * iVar2);
  iVar2 = *(int *)(param_1[1] + 4);
  if (0 < iVar2) {
    pdVar3 = (double *)*param_2;
    pdVar5 = (double *)(*param_1 + 8);
    do {
      dVar7 = pdVar5[-1];
      iVar2 = iVar2 + -1;
      *pdVar3 = dVar7;
      dVar8 = *pdVar5;
      pdVar5 = pdVar5 + 2;
      *pdVar3 = dVar7 + dVar8;
      pdVar3 = pdVar3 + 1;
    } while (iVar2 != 0);
  }
  return;
}



void sum(void)

{
  combineVectorElements();
  return;
}



void smooth_mean(int param_1,int param_2,int param_3,int param_4)

{
  int iVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  float *pfVar5;
  float *pfVar6;
  float fVar7;
  float fVar8;
  
  if (0 < param_3) {
    param_2 = param_2 + 4;
    iVar3 = 0;
    do {
      iVar1 = iVar3 - param_4 / 2;
      *(undefined4 *)(param_1 + iVar3 * 4) = 0;
      iVar4 = iVar3;
      if (0 < iVar1) {
        iVar4 = iVar3 - iVar1;
      }
      iVar1 = param_3;
      if (iVar4 + iVar3 < param_3) {
        iVar1 = iVar4 + iVar3 + 1;
      }
      pfVar5 = (float *)(param_1 + iVar3 * 4);
      iVar4 = (iVar3 * 2 + 1) - iVar1;
      fVar7 = 0.0;
      if (iVar4 < iVar1) {
        pfVar6 = (float *)(param_2 + iVar1 * -4);
        iVar2 = iVar4;
        do {
          fVar8 = *pfVar6;
          iVar2 = iVar2 + 1;
          pfVar6 = pfVar6 + 1;
          fVar7 = fVar8 + fVar7;
          *pfVar5 = fVar7;
        } while (iVar2 < iVar1);
      }
      iVar3 = iVar3 + 1;
      param_2 = param_2 + 8;
      *pfVar5 = fVar7 / (float)(longlong)(iVar1 - iVar4);
    } while (iVar3 != param_3);
  }
  return;
}



void smooth_gauss(int param_1,int param_2,int param_3,int param_4)

{
  float *__ptr;
  int iVar1;
  float *pfVar2;
  int iVar3;
  float *pfVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  int iVar9;
  float fVar10;
  float fVar11;
  float fVar12;
  
  __ptr = (float *)malloc(param_4 << 2);
  if (0 < param_3) {
    param_2 = param_2 + 4;
    iVar5 = -1;
    iVar9 = 0;
    iVar6 = 0;
    do {
      iVar1 = iVar6 - param_4 / 2;
      iVar3 = iVar6;
      if (0 < iVar1) {
        iVar3 = iVar6 - iVar1;
      }
      iVar1 = param_3;
      if (iVar3 + iVar6 < param_3) {
        iVar1 = iVar3 + iVar6 + 1;
      }
      iVar8 = (iVar6 * 2 + 1) - iVar1;
      iVar3 = iVar1 - iVar8;
      if ((iVar9 != iVar3) && (iVar9 = iVar3, 0 < iVar3)) {
        iVar7 = iVar5 + iVar1 * 2;
        fVar12 = -2.5;
        pfVar2 = __ptr;
        fVar11 = 0.0;
        do {
          fVar10 = fVar12 * fVar12 * -0.5;
          expf(fVar10);
          *pfVar2 = fVar10;
          fVar12 = fVar12 + (float)(5.0 / (double)(longlong)(iVar3 + -1));
          iVar7 = iVar7 + -1;
          fVar11 = fVar11 + fVar10;
          pfVar2 = pfVar2 + 1;
        } while (iVar7 != 0);
        iVar3 = iVar1 * -2;
        pfVar2 = __ptr;
        do {
          iVar3 = iVar3 + 1;
          *pfVar2 = *pfVar2 / fVar11;
          pfVar2 = pfVar2 + 1;
        } while (iVar5 != iVar3);
      }
      *(undefined4 *)(param_1 + iVar6 * 4) = 0;
      if (iVar8 < iVar1) {
        pfVar4 = (float *)(param_2 + iVar1 * -4);
        pfVar2 = __ptr;
        fVar11 = 0.0;
        do {
          fVar12 = *pfVar2;
          iVar8 = iVar8 + 1;
          fVar10 = *pfVar4;
          pfVar4 = pfVar4 + 1;
          pfVar2 = pfVar2 + 1;
          fVar11 = fVar11 + fVar10 * fVar12;
          *(float *)(param_1 + iVar6 * 4) = fVar11;
        } while (iVar8 < iVar1);
      }
      iVar6 = iVar6 + 1;
      param_2 = param_2 + 8;
      iVar5 = iVar5 + -2;
    } while (iVar6 != param_3);
  }
  free(__ptr);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memcpy(void *__dest,void *__src,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memcpy(__dest,__src,__n);
  return pvVar1;
}



void FUN_00022030(void *param_1,size_t param_2)

{
  memset(param_1,0,param_2);
  return;
}



void datools_terminate(void)

{
  datools_terminate();
  return;
}



void emxInit_real_T1(void)

{
  emxInit_real_T1();
  return;
}



void b_nanmean(void)

{
  b_nanmean();
  return;
}



void combineVectorElements(void)

{
  combineVectorElements();
  return;
}



void datools_initialize(void)

{
  datools_initialize();
  return;
}



void __stack_chk_fail(void)

{
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void datools_terminate(void)

{
  return;
}



void emxCreateND_real_T(void)

{
  emxCreateND_real_T();
  return;
}



void neg2nan(void)

{
  neg2nan();
  return;
}



void SAFilter(void)

{
  SAFilter();
  return;
}



void emxDestroyArray_real_T(void)

{
  emxDestroyArray_real_T();
  return;
}



void Java_com_microtechmd_cgat_CGA_selectPeriod(void)

{
  Java_com_microtechmd_cgat_CGA_selectPeriod();
  return;
}



void emxInitArray_real_T(void)

{
  emxInitArray_real_T();
  return;
}



void SelectByHour(void)

{
  SelectByHour();
  return;
}



void MBG(void)

{
  MBG();
  return;
}



void SDBG(void)

{
  SDBG();
  return;
}



void CV(void)

{
  CV();
  return;
}



void DailyTrendMean(void)

{
  DailyTrendMean();
  return;
}



void DailyTrendPrctile(void)

{
  DailyTrendPrctile();
  return;
}



void LBGD(void)

{
  LBGD();
  return;
}



void HBGD(void)

{
  HBGD();
  return;
}



void NUM(void)

{
  NUM();
  return;
}



void MAXBG(void)

{
  MAXBG();
  return;
}



void MINBG(void)

{
  MINBG();
  return;
}



void MValue(void)

{
  MValue();
  return;
}



void JINDEX(void)

{
  JINDEX();
  return;
}



void IQR(void)

{
  IQR();
  return;
}



void emxCreateWrapperND_real_T(void)

{
  emxCreateWrapperND_real_T();
  return;
}



void PT(void)

{
  PT();
  return;
}



void AAC(void)

{
  AAC();
  return;
}



void AUC(void)

{
  AUC();
  return;
}



void GRADE(void)

{
  GRADE();
  return;
}



void LAGE(void)

{
  LAGE();
  return;
}



void MAGE(void)

{
  MAGE();
  return;
}



void MAG(void)

{
  MAG();
  return;
}



void MODD(void)

{
  MODD();
  return;
}



void CONGA(void)

{
  CONGA();
  return;
}



void Pentagon(void)

{
  Pentagon();
  return;
}



void smooth_mean(void)

{
  smooth_mean();
  return;
}



void smooth_gauss(void)

{
  smooth_gauss();
  return;
}



void emxEnsureCapacity_real_T1(void)

{
  emxEnsureCapacity_real_T1();
  return;
}



void emxEnsureCapacity_real_T(void)

{
  emxEnsureCapacity_real_T();
  return;
}



void emxInit_real_T(void)

{
  emxInit_real_T();
  return;
}



void emxInit_boolean_T(void)

{
  emxInit_boolean_T();
  return;
}



void sum(void)

{
  sum();
  return;
}



void nansum(void)

{
  nansum();
  return;
}



void emxEnsureCapacity_boolean_T(void)

{
  emxEnsureCapacity_boolean_T();
  return;
}



void rtIsNaN(void)

{
  rtIsNaN();
  return;
}



void emxFree_real_T(void)

{
  emxFree_real_T();
  return;
}



void emxFree_boolean_T(void)

{
  emxFree_boolean_T();
  return;
}



void emxInit_real_T1(void)

{
  emxInit_real_T1();
  return;
}



void emxInit_boolean_T1(void)

{
  emxInit_boolean_T1();
  return;
}



void emxEnsureCapacity_boolean_T1(void)

{
  emxEnsureCapacity_boolean_T1();
  return;
}



void emxInit_int32_T(void)

{
  emxInit_int32_T();
  return;
}



void emxEnsureCapacity_int32_T(void)

{
  emxEnsureCapacity_int32_T();
  return;
}



void emxFree_int32_T(void)

{
  emxFree_int32_T();
  return;
}



void power(void)

{
  power();
  return;
}



void nanmean(void)

{
  nanmean();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double log(double __x)

{
  double dVar1;
  
  dVar1 = log(__x);
  return dVar1;
}



void rt_powd_snf(void)

{
  rt_powd_snf();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double floor(double __x)

{
  double dVar1;
  
  dVar1 = floor(__x);
  return dVar1;
}



void nanstd(void)

{
  nanstd();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * calloc(size_t __nmemb,size_t __size)

{
  void *pvVar1;
  
  pvVar1 = calloc(__nmemb,__size);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void free(void *__ptr)

{
  free(__ptr);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = malloc(__size);
  return pvVar1;
}



void rtIsInf(void)

{
  rtIsInf();
  return;
}



void b_nanmean(void)

{
  b_nanmean();
  return;
}



void percentile_array(void)

{
  percentile_array();
  return;
}



void emxInit_int32_T1(void)

{
  emxInit_int32_T1();
  return;
}



void c_nanmean(void)

{
  c_nanmean();
  return;
}



void emxEnsureCapacity_int32_T1(void)

{
  emxEnsureCapacity_int32_T1();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double exp(double __x)

{
  double dVar1;
  
  dVar1 = exp(__x);
  return dVar1;
}



void b_log10(void)

{
  b_log10();
  return;
}



void b_power(void)

{
  b_power();
  return;
}



void b_sum(void)

{
  b_sum();
  return;
}



void b_log(void)

{
  b_log();
  return;
}



void c_power(void)

{
  c_power();
  return;
}



void nullAssignment(void)

{
  nullAssignment();
  return;
}



void sort(void)

{
  sort();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double log10(double __x)

{
  double dVar1;
  
  dVar1 = log10(__x);
  return dVar1;
}



void b_abs(void)

{
  b_abs();
  return;
}



void b_SAFilter(void)

{
  b_SAFilter();
  return;
}



void emxInit_uint32_T(void)

{
  emxInit_uint32_T();
  return;
}



void emxEnsureCapacity_uint32_T(void)

{
  emxEnsureCapacity_uint32_T();
  return;
}



void diff(void)

{
  diff();
  return;
}



void b_diff(void)

{
  b_diff();
  return;
}



void emxFree_uint32_T(void)

{
  emxFree_uint32_T();
  return;
}



void b_sign(void)

{
  b_sign();
  return;
}



void d_nanmean(void)

{
  d_nanmean();
  return;
}



void rdivide(void)

{
  rdivide();
  return;
}



void b_PT(void)

{
  b_PT();
  return;
}



void d_sum(void)

{
  d_sum();
  return;
}



void b_AAC(void)

{
  b_AAC();
  return;
}



void b_AUC(void)

{
  b_AUC();
  return;
}



void b_sqrt(void)

{
  b_sqrt();
  return;
}



void d_power(void)

{
  d_power();
  return;
}



void e_power(void)

{
  e_power();
  return;
}



void f_power(void)

{
  f_power();
  return;
}



void b_exp(void)

{
  b_exp();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double ceil(double __x)

{
  double dVar1;
  
  dVar1 = ceil(__x);
  return dVar1;
}



void c_sum(void)

{
  c_sum();
  return;
}



void rtGetNaN(void)

{
  rtGetNaN();
  return;
}



void rtGetNaNF(void)

{
  rtGetNaNF();
  return;
}



void rtGetInf(void)

{
  rtGetInf();
  return;
}



void rtGetInfF(void)

{
  rtGetInfF();
  return;
}



void rtGetMinusInf(void)

{
  rtGetMinusInf();
  return;
}



void rtGetMinusInfF(void)

{
  rtGetMinusInfF();
  return;
}



void emxInitMatrix_cell_wrap_1(void)

{
  emxInitMatrix_cell_wrap_1();
  return;
}



void emxFreeMatrix_cell_wrap_1(void)

{
  emxFreeMatrix_cell_wrap_1();
  return;
}



void sortIdx(void)

{
  sortIdx();
  return;
}



double combineVectorElements(undefined4 *param_1)

{
  byte *pbVar1;
  int iVar2;
  double dVar3;
  
  iVar2 = *(int *)param_1[1];
  if (iVar2 == 0) {
    return 0.0;
  }
  pbVar1 = (byte *)*param_1;
  dVar3 = (double)*pbVar1;
  if (1 < iVar2) {
    iVar2 = iVar2 + -1;
    do {
      pbVar1 = pbVar1 + 1;
      iVar2 = iVar2 + -1;
      dVar3 = dVar3 + (double)*pbVar1;
    } while (iVar2 != 0);
  }
  return dVar3;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

float expf(float __x)

{
  float fVar1;
  
  fVar1 = expf(__x);
  return fVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memcpy(void *__dest,void *__src,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memcpy(__dest,__src,__n);
  return pvVar1;
}


