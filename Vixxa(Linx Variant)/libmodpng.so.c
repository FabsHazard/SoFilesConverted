typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned int    dword;
typedef long long    longlong;
typedef unsigned long    ulong;
typedef unsigned char    undefined1;
typedef unsigned short    undefined2;
typedef unsigned int    undefined4;
typedef unsigned long long    undefined8;
typedef unsigned short    ushort;
typedef unsigned short    word;
typedef void _IO_lock_t;

typedef struct _IO_marker _IO_marker, *P_IO_marker;

typedef struct _IO_FILE _IO_FILE, *P_IO_FILE;

typedef long __off_t;

typedef longlong __quad_t;

typedef __quad_t __off64_t;

typedef ulong size_t;

struct _IO_FILE {
    int _flags;
    char *_IO_read_ptr;
    char *_IO_read_end;
    char *_IO_read_base;
    char *_IO_write_base;
    char *_IO_write_ptr;
    char *_IO_write_end;
    char *_IO_buf_base;
    char *_IO_buf_end;
    char *_IO_save_base;
    char *_IO_backup_base;
    char *_IO_save_end;
    struct _IO_marker *_markers;
    struct _IO_FILE *_chain;
    int _fileno;
    int _flags2;
    __off_t _old_offset;
    ushort _cur_column;
    char _vtable_offset;
    char _shortbuf[1];
    _IO_lock_t *_lock;
    __off64_t _offset;
    void *__pad1;
    void *__pad2;
    void *__pad3;
    void *__pad4;
    size_t __pad5;
    int _mode;
    char _unused2[40];
};

struct _IO_marker {
    struct _IO_marker *_next;
    struct _IO_FILE *_sbuf;
    int _pos;
};

typedef struct _IO_FILE FILE;

typedef struct __jmp_buf_tag __jmp_buf_tag, *P__jmp_buf_tag;

typedef int __jmp_buf[6];

typedef struct __sigset_t __sigset_t, *P__sigset_t;

struct __sigset_t {
    ulong __val[32];
};

struct __jmp_buf_tag {
    __jmp_buf __jmpbuf;
    int __mask_was_saved;
    struct __sigset_t __saved_mask;
};

typedef long __time_t;

typedef struct tm tm, *Ptm;

struct tm {
    int tm_sec;
    int tm_min;
    int tm_hour;
    int tm_mday;
    int tm_mon;
    int tm_year;
    int tm_wday;
    int tm_yday;
    int tm_isdst;
    long tm_gmtoff;
    char *tm_zone;
};

typedef __time_t time_t;

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

typedef struct Elf32_Sym Elf32_Sym, *PElf32_Sym;

struct Elf32_Sym {
    dword st_name;
    dword st_value;
    dword st_size;
    byte st_info;
    byte st_other;
    word st_shndx;
};

typedef struct GnuDebugLink_16 GnuDebugLink_16, *PGnuDebugLink_16;

struct GnuDebugLink_16 {
    char filename[16];
    dword crc;
};

typedef struct GnuBuildId GnuBuildId, *PGnuBuildId;

struct GnuBuildId {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[4]; // Vendor name
    byte hash[16];
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

typedef struct Elf32_Rel Elf32_Rel, *PElf32_Rel;

struct Elf32_Rel {
    dword r_offset; // location to apply the relocation action
    dword r_info; // the symbol table index and the type of relocation
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




void png_error(void)

{
                    // WARNING: Subroutine does not return
  png_error();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int memcmp(void *__s1,void *__s2,size_t __n)

{
  int iVar1;
  
  iVar1 = memcmp(__s1,__s2,__n);
  return iVar1;
}



void __stack_chk_fail(void)

{
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void __aeabi_uidiv(void)

{
  __aeabi_uidiv();
  return;
}



void png_malloc_warn(void)

{
  png_malloc_warn();
  return;
}



void png_free(void)

{
  png_free();
  return;
}



void crc32(void)

{
  crc32();
  return;
}



void __aeabi_memclr8(void)

{
  __aeabi_memclr8();
  return;
}



void png_set_mem_fn(void)

{
  png_set_mem_fn();
  return;
}



void png_set_error_fn(void)

{
  png_set_error_fn();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int setjmp(__jmp_buf_tag *__env)

{
  int iVar1;
  
  iVar1 = setjmp(__env);
  return iVar1;
}



void png_user_version_check(void)

{
  png_user_version_check();
  return;
}



void __aeabi_memcpy4(void)

{
  __aeabi_memcpy4();
  return;
}



void png_malloc_base(void)

{
  png_malloc_base();
  return;
}



void __aeabi_memclr4(void)

{
  __aeabi_memclr4();
  return;
}



void png_free_data(void)

{
  png_free_data();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void free(void *__ptr)

{
  free(__ptr);
  return;
}



void png_save_uint_32(void)

{
  png_save_uint_32();
  return;
}



void png_format_number(void)

{
  png_format_number();
  return;
}



void png_safecat(void)

{
  png_safecat();
  return;
}



void png_convert_to_rfc1123_buffer(void)

{
  png_convert_to_rfc1123_buffer();
  return;
}



void png_handle_as_unknown(void)

{
  png_handle_as_unknown();
  return;
}



void inflateReset(void)

{
  inflateReset();
  return;
}



void png_chunk_report(void)

{
  png_chunk_report();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double floor(double __x)

{
  double dVar1;
  
  dVar1 = floor(__x);
  return dVar1;
}



void png_colorspace_sync_info(void)

{
  png_colorspace_sync_info();
  return;
}



void png_benign_error(void)

{
  png_benign_error();
  return;
}



void adler32(void)

{
  adler32();
  return;
}



void png_colorspace_set_sRGB(void)

{
  png_colorspace_set_sRGB();
  return;
}



void png_icc_check_header(void)

{
  png_icc_check_header();
  return;
}



void png_icc_check_tag_table(void)

{
  png_icc_check_tag_table();
  return;
}



void png_icc_set_sRGB(void)

{
  png_icc_set_sRGB();
  return;
}



void png_check_fp_number(void)

{
  png_check_fp_number();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double frexp(double __x,int *__exponent)

{
  double dVar1;
  
  dVar1 = frexp(__x,__exponent);
  return dVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double modf(double __x,double *__iptr)

{
  double dVar1;
  
  dVar1 = modf(__x,__iptr);
  return dVar1;
}



void __aeabi_memset(void)

{
  __aeabi_memset();
  return;
}



void png_fixed_error(void)

{
  png_fixed_error();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double pow(double __x,double __y)

{
  double dVar1;
  
  dVar1 = pow(__x,__y);
  return dVar1;
}



void png_destroy_gamma_table(void)

{
  png_destroy_gamma_table();
  return;
}



void png_calloc(void)

{
  png_calloc();
  return;
}



void png_malloc(void)

{
  png_malloc();
  return;
}



void png_safe_execute(void)

{
  png_safe_execute();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fclose(FILE *__stream)

{
  int iVar1;
  
  iVar1 = fclose(__stream);
  return iVar1;
}



void png_destroy_read_struct(void)

{
  png_destroy_read_struct();
  return;
}



void png_destroy_write_struct(void)

{
  png_destroy_write_struct();
  return;
}



void png_image_free(void)

{
  png_image_free();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fprintf(FILE *__stream,char *__format,...)

{
  int iVar1;
  
  iVar1 = fprintf(__stream,__format);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fputc(int __c,FILE *__stream)

{
  int iVar1;
  
  iVar1 = fputc(__c,__stream);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void abort(void)

{
                    // WARNING: Subroutine does not return
  abort();
}



void png_chunk_error(void)

{
                    // WARNING: Subroutine does not return
  png_chunk_error();
}



void png_app_error(void)

{
  png_app_error();
  return;
}



void png_app_warning(void)

{
  png_app_warning();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void longjmp(__jmp_buf_tag *__env,int __val)

{
                    // WARNING: Subroutine does not return
  longjmp(__env,__val);
}



void png_muldiv(void)

{
  png_muldiv();
  return;
}



undefined4 png_muldiv_warn(undefined4 param_1,int param_2,int param_3,int param_4)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double dVar2;
  
  uVar1 = 0;
  if (((param_4 != 0) && (param_2 != 0)) && (param_3 != 0)) {
    uVar1 = SUB84(((double)(longlong)param_2 * (double)(longlong)param_3) /
                  (double)(longlong)param_4 + 0.5,0);
    floor((double)CONCAT44(in_lr,unaff_r7));
    dVar2 = (double)CONCAT44(extraout_r1,uVar1);
    uVar1 = (undefined4)(longlong)dVar2;
    if (2147483647.0 < dVar2) {
      uVar1 = 0;
    }
    if (dVar2 < -2147483648.0 != NAN(dVar2)) {
      uVar1 = 0;
    }
  }
  return uVar1;
}



void png_check_IHDR(void)

{
  png_check_IHDR();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

double strtod(char *__nptr,char **__endptr)

{
  double dVar1;
  
  dVar1 = strtod(__nptr,__endptr);
  return dVar1;
}



void png_fixed(void)

{
  png_fixed();
  return;
}



void png_free_jmpbuf(void)

{
  png_free_jmpbuf();
  return;
}



void __aeabi_memclr(void)

{
  __aeabi_memclr();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = malloc(__size);
  return pvVar1;
}



void __aeabi_memcpy(void)

{
  __aeabi_memcpy();
  return;
}



void png_process_some_data(void)

{
  png_process_some_data();
  return;
}



void png_push_read_IDAT(int param_1)

{
  undefined4 uVar1;
  uint uVar2;
  int iVar3;
  uint uVar4;
  byte bStack_1c;
  byte bStack_1b;
  byte bStack_1a;
  byte bStack_19;
  undefined1 auStack_18 [4];
  int iStack_14;
  
  iStack_14 = __stack_chk_guard;
  if ((*(byte *)(param_1 + 0x131) & 1) == 0) {
    if (7 < *(uint *)(param_1 + 0x2ac)) {
      png_push_fill_buffer(param_1,auStack_18,4);
      uVar1 = png_get_uint_31(param_1,auStack_18);
      *(undefined4 *)(param_1 + 0x29c) = uVar1;
      png_reset_crc(param_1);
      png_crc_read(param_1,&bStack_1c,4);
      uVar2 = (uint)bStack_1b << 0x10 | (uint)bStack_1c << 0x18 | (uint)bStack_1a << 8 |
              (uint)bStack_19;
      *(uint *)(param_1 + 0x1d8) = uVar2;
      *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 0x100;
      if (uVar2 != 0x49444154) {
        *(undefined4 *)(param_1 + 0x2b4) = 1;
        if ((*(byte *)(param_1 + 0x134) & 8) == 0) {
                    // WARNING: Subroutine does not return
          png_error(param_1,"Not enough compressed data");
        }
        goto LAB_0001d610;
      }
      uVar2 = *(uint *)(param_1 + 0x29c);
      *(uint *)(param_1 + 0x1f0) = uVar2;
      goto LAB_0001d526;
    }
  }
  else {
    uVar2 = *(uint *)(param_1 + 0x1f0);
LAB_0001d526:
    if (uVar2 != 0) {
      uVar4 = *(uint *)(param_1 + 0x2a4);
      if (uVar4 != 0) {
        if (uVar2 < uVar4) {
          uVar4 = uVar2;
        }
        png_calculate_crc(param_1,*(undefined4 *)(param_1 + 0x28c),uVar4);
        png_process_IDAT_data(param_1,*(undefined4 *)(param_1 + 0x28c),uVar4);
        uVar2 = *(int *)(param_1 + 0x1f0) - uVar4;
        *(uint *)(param_1 + 0x1f0) = uVar2;
        *(uint *)(param_1 + 0x2ac) = *(int *)(param_1 + 0x2ac) - uVar4;
        *(uint *)(param_1 + 0x2a4) = *(int *)(param_1 + 0x2a4) - uVar4;
        *(uint *)(param_1 + 0x28c) = *(int *)(param_1 + 0x28c) + uVar4;
        if (uVar2 == 0) goto LAB_0001d5d0;
      }
      uVar4 = *(uint *)(param_1 + 0x2b0);
      if (uVar4 == 0) goto LAB_0001d610;
      if (uVar2 < uVar4) {
        uVar4 = uVar2;
      }
      png_calculate_crc(param_1,*(undefined4 *)(param_1 + 0x294),uVar4);
      png_process_IDAT_data(param_1,*(undefined4 *)(param_1 + 0x294),uVar4);
      iVar3 = *(int *)(param_1 + 0x1f0) - uVar4;
      *(int *)(param_1 + 0x1f0) = iVar3;
      *(uint *)(param_1 + 0x2ac) = *(int *)(param_1 + 0x2ac) - uVar4;
      *(uint *)(param_1 + 0x2b0) = *(int *)(param_1 + 0x2b0) - uVar4;
      *(uint *)(param_1 + 0x294) = *(int *)(param_1 + 0x294) + uVar4;
      if (iVar3 != 0) goto LAB_0001d610;
    }
LAB_0001d5d0:
    if (3 < *(uint *)(param_1 + 0x2ac)) {
      png_crc_finish(param_1,0);
      *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) & 0xfffffef7 | 8;
      *(undefined4 *)(param_1 + 0x13c) = 0;
      goto LAB_0001d610;
    }
  }
  png_push_save_buffer(param_1);
LAB_0001d610:
  if (__stack_chk_guard == iStack_14) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_push_read_chunk(void)

{
  png_push_read_chunk();
  return;
}



void png_push_read_sig(void)

{
  png_push_read_sig();
  return;
}



void png_push_save_buffer(void)

{
  png_push_save_buffer();
  return;
}



void png_push_fill_buffer(void)

{
  png_push_fill_buffer();
  return;
}



void png_sig_cmp(void)

{
  png_sig_cmp();
  return;
}



void png_get_uint_31(void)

{
  png_get_uint_31();
  return;
}



void png_reset_crc(void)

{
  png_reset_crc();
  return;
}



void png_crc_read(void)

{
  png_crc_read();
  return;
}



void png_check_chunk_name(void)

{
  png_check_chunk_name();
  return;
}



void png_handle_IHDR(void)

{
  png_handle_IHDR();
  return;
}



void png_handle_IEND(void)

{
  png_handle_IEND();
  return;
}



void png_chunk_unknown_handling(void)

{
  png_chunk_unknown_handling();
  return;
}



void png_handle_unknown(void)

{
  png_handle_unknown();
  return;
}



void png_handle_PLTE(void)

{
  png_handle_PLTE();
  return;
}



void png_handle_gAMA(void)

{
  png_handle_gAMA();
  return;
}



void png_handle_cHRM(void)

{
  png_handle_cHRM();
  return;
}



void png_handle_sBIT(void)

{
  png_handle_sBIT();
  return;
}



void png_handle_sRGB(void)

{
  png_handle_sRGB();
  return;
}



void png_handle_iCCP(void)

{
  png_handle_iCCP();
  return;
}



void png_handle_tEXt(void)

{
  png_handle_tEXt();
  return;
}



void png_handle_pHYs(void)

{
  png_handle_pHYs();
  return;
}



void png_handle_zTXt(void)

{
  png_handle_zTXt();
  return;
}



void png_handle_hIST(void)

{
  png_handle_hIST();
  return;
}



void png_handle_bKGD(void)

{
  png_handle_bKGD();
  return;
}



void png_handle_sCAL(void)

{
  png_handle_sCAL();
  return;
}



void png_handle_sPLT(void)

{
  png_handle_sPLT();
  return;
}



void png_handle_oFFs(void)

{
  png_handle_oFFs();
  return;
}



void png_handle_pCAL(void)

{
  png_handle_pCAL();
  return;
}



void png_handle_tIME(void)

{
  png_handle_tIME();
  return;
}



void png_handle_tRNS(void)

{
  png_handle_tRNS();
  return;
}



void png_handle_iTXt(void)

{
  png_handle_iTXt();
  return;
}



void png_calculate_crc(void)

{
  png_calculate_crc();
  return;
}



void png_process_IDAT_data(void)

{
  png_process_IDAT_data();
  return;
}



void png_crc_finish(void)

{
  png_crc_finish();
  return;
}



void inflate(void)

{
  inflate();
  return;
}



void png_push_process_row(void)

{
  png_push_process_row();
  return;
}



void png_read_filter_row(void)

{
  png_read_filter_row();
  return;
}



void png_do_read_transformations(void)

{
  png_do_read_transformations();
  return;
}



void png_do_read_interlace(void)

{
  png_do_read_interlace();
  return;
}



void png_read_push_finish_row(void)

{
  png_read_push_finish_row();
  return;
}



void png_combine_row(void)

{
  png_combine_row();
  return;
}



void png_set_read_fn(void)

{
  png_set_read_fn();
  return;
}



void png_create_read_struct_2(void)

{
  png_create_read_struct_2();
  return;
}



void png_create_png_struct(void)

{
  png_create_png_struct();
  return;
}



void png_read_sig(void)

{
  png_read_sig();
  return;
}



void png_read_chunk_header(void)

{
  png_read_chunk_header();
  return;
}



void png_chunk_benign_error(void)

{
  png_chunk_benign_error();
  return;
}



void png_read_start_row(void)

{
  png_read_start_row();
  return;
}



void png_read_transform_info(int param_1,int *param_2,undefined4 param_3,undefined2 param_4)

{
  char cVar1;
  undefined1 uVar2;
  byte bVar3;
  char cVar4;
  ushort uVar5;
  byte bVar6;
  char cVar7;
  ushort uVar8;
  ushort uVar9;
  uint uVar10;
  bool bVar11;
  
  uVar10 = *(uint *)(param_1 + 0x138);
  if ((uVar10 & 0x1000) != 0) {
    if (*(byte *)((int)param_2 + 0x19) == 3) {
      uVar2 = 6;
      if (*(short *)(param_1 + 0x204) == 0) {
        uVar2 = 2;
      }
      *(undefined1 *)((int)param_2 + 0x19) = uVar2;
      *(undefined1 *)(param_2 + 6) = 8;
      *(undefined2 *)((int)param_2 + 0x16) = 0;
      if (*(int *)(param_1 + 0x1f8) == 0) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Palette is NULL in indexed image");
      }
    }
    else {
      if ((uVar10 & 0x2000000) != 0 && *(short *)(param_1 + 0x204) != 0) {
        *(byte *)((int)param_2 + 0x19) = *(byte *)((int)param_2 + 0x19) | 4;
      }
      bVar6 = *(byte *)(param_2 + 6);
      bVar3 = bVar6;
      if (bVar6 < 8) {
        bVar3 = 8;
      }
      if (bVar6 < 8) {
        *(byte *)(param_2 + 6) = bVar3;
      }
      *(undefined2 *)((int)param_2 + 0x16) = 0;
    }
  }
  if ((uVar10 & 0x80) != 0) {
    __aeabi_memcpy((int)param_2 + 0xaa,param_1 + 0x21c,10);
  }
  param_2[10] = *(int *)(param_1 + 0x378);
  uVar5 = *(ushort *)(param_2 + 6);
  uVar8 = uVar5 >> 8;
  if ((char)uVar5 == '\x10') {
    bVar11 = (uVar10 & 0x4000000) != 0;
    if (bVar11) {
      uVar5 = 8;
    }
    if (bVar11) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
    else {
      uVar5 = 0x10;
    }
    bVar11 = (uVar10 & 0x400) != 0;
    if (bVar11) {
      uVar5 = 8;
    }
    if (bVar11) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
  }
  bVar11 = (uVar10 & 0x4000) != 0;
  if (bVar11) {
    uVar8 = uVar8 | 2;
  }
  if (bVar11) {
    *(char *)((int)param_2 + 0x19) = (char)uVar8;
  }
  bVar11 = (uVar10 & 0x600000) != 0;
  if (bVar11) {
    uVar8 = uVar8 & 0xfd;
  }
  if (bVar11) {
    *(char *)((int)param_2 + 0x19) = (char)uVar8;
  }
  if ((((uVar10 & 0x40) != 0) && ((uVar8 | 4) == 6)) && (*(int *)(param_1 + 700) != 0)) {
    bVar11 = (uVar5 & 0xff) == 8;
    if (bVar11) {
      uVar8 = 3;
    }
    if (bVar11) {
      *(char *)((int)param_2 + 0x19) = (char)uVar8;
    }
  }
  if (((uVar5 & 0xff) == 8) && ((uVar10 & 0x200) != 0)) {
    if (uVar8 != 3) {
      uVar5 = 0x10;
    }
    if (uVar8 != 3) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
  }
  if ((uVar10 & 4) != 0) {
    uVar9 = uVar5 & 0xff;
    if (uVar9 < 8) {
      uVar5 = 8;
    }
    if (uVar9 < 8) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
  }
  cVar4 = (char)uVar5;
  if (uVar8 == 3 || (uVar8 & 2) == 0) {
    cVar7 = '\x01';
  }
  else {
    cVar7 = '\x03';
  }
  *(char *)((int)param_2 + 0x1d) = cVar7;
  bVar11 = (uVar10 & 0x40000) != 0;
  if (bVar11) {
    uVar8 = uVar8 & 0xfb;
  }
  bVar6 = (byte)uVar8;
  if (bVar11) {
    *(byte *)((int)param_2 + 0x19) = bVar6;
    param_4 = 0;
  }
  if (bVar11) {
    *(undefined2 *)((int)param_2 + 0x16) = param_4;
  }
  bVar11 = (uVar8 & 4) != 0;
  if (bVar11) {
    cVar7 = cVar7 + '\x01';
  }
  if (bVar11) {
    *(char *)((int)param_2 + 0x1d) = cVar7;
  }
  if (((uVar10 & 0x8000) != 0) && ((uVar8 | 2) == 2)) {
    cVar7 = cVar7 + '\x01';
    *(char *)((int)param_2 + 0x1d) = cVar7;
    bVar11 = (uVar10 & 0x1000000) != 0;
    if (bVar11) {
      bVar6 = bVar6 | 4;
    }
    if (bVar11) {
      *(byte *)((int)param_2 + 0x19) = bVar6;
    }
  }
  if ((uVar10 & 0x100000) != 0) {
    uVar8 = *(ushort *)(param_1 + 300);
    if ((uVar8 & 0xff) != 0) {
      *(char *)(param_2 + 6) = (char)uVar8;
      uVar5 = uVar8;
    }
    cVar4 = (char)uVar5;
    cVar1 = (char)(uVar8 >> 8);
    if (uVar8 >> 8 != 0) {
      *(char *)((int)param_2 + 0x1d) = cVar1;
      cVar7 = cVar1;
    }
  }
  bVar6 = cVar4 * cVar7;
  *(byte *)((int)param_2 + 0x1e) = bVar6;
  if (bVar6 < 8) {
    uVar10 = (uint)bVar6 * *param_2 + 7 >> 3;
  }
  else {
    uVar10 = (uint)(bVar6 >> 3) * *param_2;
  }
  param_2[3] = uVar10;
  *(uint *)(param_1 + 0x1ec) = uVar10;
  return;
}



void png_read_finish_row(void)

{
  png_read_finish_row();
  return;
}



void png_read_IDAT_data(void)

{
  png_read_IDAT_data();
  return;
}



void png_read_row(void)

{
  png_read_row();
  return;
}



void png_set_interlace_handling(void)

{
  png_set_interlace_handling();
  return;
}



void png_start_read_image(void)

{
  png_start_read_image();
  return;
}



void png_read_finish_IDAT(void)

{
  png_read_finish_IDAT();
  return;
}



void png_destroy_info_struct(void)

{
  png_destroy_info_struct();
  return;
}



void png_zfree(void)

{
  png_zfree();
  return;
}



void inflateEnd(void)

{
  inflateEnd();
  return;
}



void png_destroy_png_struct(void *param_1)

{
  undefined1 auStack_3d0 [788];
  code *pcStack_bc;
  int iStack_c;
  
  iStack_c = __stack_chk_guard;
  if (param_1 != (void *)0x0) {
    __aeabi_memcpy4(auStack_3d0,param_1,0x3c4);
    __aeabi_memclr4(param_1,0x3c4);
    if (pcStack_bc == (code *)0x0) {
      free(param_1);
    }
    else {
      (*pcStack_bc)(auStack_3d0,param_1);
    }
    png_free_jmpbuf(auStack_3d0);
  }
  if (__stack_chk_guard == iStack_c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_read_info(void)

{
  png_read_info();
  return;
}



void png_set_scale_16(void)

{
  png_set_scale_16();
  return;
}



void png_set_strip_16(void)

{
  png_set_strip_16();
  return;
}



void png_set_strip_alpha(void)

{
  png_set_strip_alpha();
  return;
}



void png_set_packing(void)

{
  png_set_packing();
  return;
}



void png_set_packswap(void)

{
  png_set_packswap();
  return;
}



void png_set_palette_to_rgb(void)

{
  png_set_palette_to_rgb();
  return;
}



void png_set_invert_mono(void)

{
  png_set_invert_mono();
  return;
}



void png_set_shift(void)

{
  png_set_shift();
  return;
}



void png_set_bgr(void)

{
  png_set_bgr();
  return;
}



void png_set_swap_alpha(void)

{
  png_set_swap_alpha();
  return;
}



void png_set_swap(void)

{
  png_set_swap();
  return;
}



void png_set_invert_alpha(void)

{
  png_set_invert_alpha();
  return;
}



void png_set_gray_to_rgb(void)

{
  png_set_gray_to_rgb();
  return;
}



void png_set_expand_16(void)

{
  png_set_expand_16();
  return;
}



void png_read_update_info(void)

{
  png_read_update_info();
  return;
}



void png_read_image(void)

{
  png_read_image();
  return;
}



void png_read_end(int param_1,int param_2)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  
  if (param_1 != 0) {
    iVar1 = png_chunk_unknown_handling(param_1,0x49444154);
    if (iVar1 == 0) {
      png_read_finish_IDAT(param_1);
    }
    if ((*(char *)(param_1 + 0x20b) == '\x03') &&
       ((int)(uint)*(ushort *)(param_1 + 0x1fc) < *(int *)(param_1 + 0x200))) {
      png_benign_error(param_1,"Read palette index exceeding num_palette");
    }
    do {
      iVar1 = png_read_chunk_header(param_1);
      iVar4 = *(int *)(param_1 + 0x1d8);
      if (iVar4 == 0x49484452) {
        png_handle_IHDR(param_1,param_2,iVar1);
      }
      else if (iVar4 == 0x49454e44) {
        png_handle_IEND(param_1,param_2,iVar1);
      }
      else if (param_2 == 0) {
LAB_0001e8e2:
        png_crc_finish(param_1,iVar1);
      }
      else {
        iVar2 = png_chunk_unknown_handling(param_1,iVar4);
        if (iVar2 == 0) {
          if (iVar4 == 0x49444154) {
            if ((iVar1 != 0) || ((*(byte *)(param_1 + 0x131) & 0x20) != 0)) {
              png_benign_error(param_1,"Too many IDATs found");
            }
            goto LAB_0001e8e2;
          }
          if (iVar4 < 0x70485973) {
            if (iVar4 < 0x68495354) {
              if (iVar4 < 0x6348524d) {
                if (iVar4 == 0x504c5445) {
                  png_handle_PLTE(param_1,param_2,iVar1);
                }
                else {
                  if (iVar4 != 0x624b4744) {
LAB_0001e856:
                    iVar2 = 0;
                    goto LAB_0001e8c0;
                  }
                  png_handle_bKGD(param_1,param_2,iVar1);
                }
              }
              else if (iVar4 == 0x6348524d) {
                png_handle_cHRM(param_1,param_2,iVar1);
              }
              else {
                if (iVar4 != 0x67414d41) goto LAB_0001e856;
                png_handle_gAMA(param_1,param_2,iVar1);
              }
            }
            else if (iVar4 < 0x69545874) {
              if (iVar4 == 0x68495354) {
                png_handle_hIST(param_1,param_2,iVar1);
              }
              else {
                if (iVar4 != 0x69434350) goto LAB_0001e856;
                png_handle_iCCP(param_1,param_2,iVar1);
              }
            }
            else if (iVar4 == 0x69545874) {
              png_handle_iTXt(param_1,param_2,iVar1);
            }
            else if (iVar4 == 0x6f464673) {
              png_handle_oFFs(param_1,param_2,iVar1);
            }
            else {
              if (iVar4 != 0x7043414c) goto LAB_0001e856;
              png_handle_pCAL(param_1,param_2,iVar1);
            }
          }
          else if (iVar4 < 0x73524742) {
            if (iVar4 < 0x7343414c) {
              if (iVar4 == 0x70485973) {
                png_handle_pHYs(param_1,param_2,iVar1);
              }
              else {
                if (iVar4 != 0x73424954) goto LAB_0001e856;
                png_handle_sBIT(param_1,param_2,iVar1);
              }
            }
            else if (iVar4 == 0x7343414c) {
              png_handle_sCAL(param_1,param_2,iVar1);
            }
            else {
              if (iVar4 != 0x73504c54) goto LAB_0001e856;
              png_handle_sPLT(param_1,param_2,iVar1);
            }
          }
          else if (iVar4 < 0x74494d45) {
            if (iVar4 == 0x73524742) {
              png_handle_sRGB(param_1,param_2,iVar1);
            }
            else {
              if (iVar4 != 0x74455874) goto LAB_0001e856;
              png_handle_tEXt(param_1,param_2,iVar1);
            }
          }
          else if (iVar4 == 0x74494d45) {
            png_handle_tIME(param_1,param_2,iVar1);
          }
          else if (iVar4 == 0x74524e53) {
            png_handle_tRNS(param_1,param_2,iVar1);
          }
          else {
            if (iVar4 != 0x7a545874) goto LAB_0001e856;
            png_handle_zTXt(param_1,param_2,iVar1);
          }
        }
        else if (iVar4 == 0x49444154) {
          if ((iVar1 != 0) || ((*(byte *)(param_1 + 0x131) & 0x20) != 0)) {
            png_benign_error(param_1,"Too many IDATs found");
          }
LAB_0001e8c0:
          png_handle_unknown(param_1,param_2,iVar1,iVar2);
        }
        else {
          png_handle_unknown(param_1,param_2,iVar1,iVar2);
          uVar3 = 0x504c5445;
          if (iVar4 == 0x504c5445) {
            uVar3 = *(uint *)(param_1 + 0x130) | 2;
          }
          if (iVar4 == 0x504c5445) {
            *(uint *)(param_1 + 0x130) = uVar3;
          }
        }
      }
    } while ((*(byte *)(param_1 + 0x130) & 0x10) == 0);
  }
  return;
}



void png_image_error(void)

{
  png_image_error();
  return;
}



void png_create_info_struct(void)

{
  png_create_info_struct();
  return;
}



void png_set_benign_errors(void)

{
  png_set_benign_errors();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

FILE * fopen(char *__filename,char *__modes)

{
  FILE *pFVar1;
  
  pFVar1 = fopen(__filename,__modes);
  return pFVar1;
}



void __errno(void)

{
  __errno();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strerror(int __errnum)

{
  char *pcVar1;
  
  pcVar1 = strerror(__errnum);
  return pcVar1;
}



void png_set_rgb_to_gray_fixed(int param_1,int param_2,uint param_3,uint param_4)

{
  code *pcVar1;
  uint uVar2;
  char *pcVar3;
  bool bVar4;
  
  if (param_1 == 0) {
    return;
  }
  if ((*(uint *)(param_1 + 0x134) & 0x40) == 0) {
    if ((*(byte *)(param_1 + 0x130) & 1) != 0) {
      *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
      if (param_2 == 3) {
        uVar2 = *(uint *)(param_1 + 0x138) | 0x200000;
      }
      else if (param_2 == 2) {
        uVar2 = *(uint *)(param_1 + 0x138) | 0x400000;
      }
      else {
        if (param_2 != 1) {
                    // WARNING: Subroutine does not return
          png_error(param_1,"invalid error action to rgb_to_gray");
        }
        uVar2 = *(uint *)(param_1 + 0x138) | 0x600000;
      }
      *(uint *)(param_1 + 0x138) = uVar2;
      bVar4 = *(char *)(param_1 + 0x20b) == '\x03';
      if (bVar4) {
        uVar2 = uVar2 | 0x1000;
      }
      if (bVar4) {
        *(uint *)(param_1 + 0x138) = uVar2;
      }
      if (-1 < (int)(param_4 | param_3)) {
        if (SBORROW4(param_3 + param_4,param_3)) {
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x2229e);
          (*pcVar1)();
        }
        if ((int)(param_3 + param_4) < 0x186a1) {
          *(short *)(param_1 + 0x2fe) = (short)((param_3 << 0xf) / 100000);
          *(short *)(param_1 + 0x300) = (short)((param_4 << 0xf) / 100000);
          *(undefined1 *)(param_1 + 0x2fd) = 1;
          return;
        }
        png_app_warning(param_1,"ignoring out of range rgb_to_gray coefficients");
      }
      if (*(short *)(param_1 + 0x2fe) != 0) {
        return;
      }
      if (*(short *)(param_1 + 0x300) != 0) {
        return;
      }
      *(undefined4 *)(param_1 + 0x2fe) = 0x5b8a1b38;
      return;
    }
    pcVar3 = "invalid before the PNG header has been read";
  }
  else {
    pcVar3 = "invalid after png_start_read_image or png_read_update_info";
  }
  png_app_error(param_1,pcVar3);
  return;
}



void png_set_background_fixed(void)

{
  png_set_background_fixed();
  return;
}



uint png_gamma_16bit_correct(uint param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double unaff_d8;
  
  if (param_1 - 1 < 0xfffe) {
    uVar1 = SUB84((double)(longlong)(int)param_1 / 65535.0,0);
    pow(unaff_d8,(double)CONCAT44(in_lr,unaff_r7));
    uVar1 = SUB84((double)CONCAT44(extraout_r1,uVar1) * 65535.0 + 0.5,0);
    floor(unaff_d8);
    param_1 = (uint)(0.0 < (double)CONCAT44(extraout_r1_00,uVar1)) *
              (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar1);
  }
  return param_1 & 0xffff;
}



void png_set_palette_to_rgb(void)

{
  png_set_palette_to_rgb();
  return;
}



void png_set_alpha_mode_fixed(void)

{
  png_set_alpha_mode_fixed();
  return;
}



void png_set_keep_unknown_chunks(void)

{
  png_set_keep_unknown_chunks();
  return;
}



void png_get_rowbytes(void)

{
  png_get_rowbytes();
  return;
}



void png_gamma_significant(void)

{
  png_gamma_significant();
  return;
}



void png_set_add_alpha(void)

{
  png_set_add_alpha();
  return;
}



void png_reciprocal(void)

{
  png_reciprocal();
  return;
}



undefined1 png_get_channels(int param_1,int param_2)

{
  undefined1 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined1 *)(param_2 + 0x1d);
  }
  return uVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t fread(void *__ptr,size_t __size,size_t __n,FILE *__stream)

{
  size_t sVar1;
  
  sVar1 = fread(__ptr,__size,__n,__stream);
  return sVar1;
}



void png_set_gamma_fixed(int param_1,int param_2,int param_3)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  
  if (param_1 == 0) {
    return;
  }
  uVar2 = *(uint *)(param_1 + 0x134);
  if ((uVar2 & 0x40) != 0) {
    png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
    return;
  }
  uVar1 = uVar2 | 0x4000;
  *(uint *)(param_1 + 0x134) = uVar1;
  if (param_2 == -3 || param_2 + 3 < 0 != SCARRY4(param_2,3)) {
    if (param_2 == -100000) {
LAB_00022018:
      uVar1 = uVar2 | 0x5000;
      param_2 = 220000;
      *(uint *)(param_1 + 0x134) = uVar1;
    }
    else if (param_2 == -50000) goto LAB_0002202a;
  }
  else {
    if (param_2 != -2) {
      if (param_2 != -1) goto LAB_00022032;
      goto LAB_00022018;
    }
LAB_0002202a:
    param_2 = 0x250ac;
  }
LAB_00022032:
  iVar3 = 0x10175;
  if (param_3 == -3 || param_3 + 3 < 0 != SCARRY4(param_3,3)) {
    if (param_3 == -100000) {
LAB_00022066:
      iVar3 = 0xb18f;
      *(uint *)(param_1 + 0x134) = uVar1 | 0x1000;
      goto LAB_0002207a;
    }
    if (param_3 == -50000) goto LAB_0002207a;
  }
  else {
    if (param_3 == -2) goto LAB_0002207a;
    if (param_3 == -1) goto LAB_00022066;
  }
  iVar3 = param_3;
  if (param_3 < 1) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"invalid file gamma in png_set_gamma");
  }
LAB_0002207a:
  if (0 < param_2) {
    *(int *)(param_1 + 0x378) = iVar3;
    *(ushort *)(param_1 + 0x3c2) = *(ushort *)(param_1 + 0x3c2) | 1;
    *(int *)(param_1 + 0x240) = param_2;
    return;
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"invalid screen gamma in png_set_gamma");
}



void png_set_expand_gray_1_2_4_to_8(void)

{
  png_set_expand_gray_1_2_4_to_8();
  return;
}



void png_colorspace_set_rgb_coefficients(void)

{
  png_colorspace_set_rgb_coefficients();
  return;
}



void png_build_gamma_table(void)

{
  png_build_gamma_table();
  return;
}



void png_reciprocal2(void)

{
  png_reciprocal2();
  return;
}



void png_gamma_correct(void)

{
  png_gamma_correct();
  return;
}



void png_gamma_8bit_correct(void)

{
  png_gamma_8bit_correct();
  return;
}



void png_do_strip_channel(void)

{
  png_do_strip_channel();
  return;
}



void png_do_invert(void)

{
  png_do_invert();
  return;
}



void png_do_check_palette_indexes(void)

{
  png_do_check_palette_indexes();
  return;
}



void png_do_bgr(void)

{
  png_do_bgr();
  return;
}



void png_do_packswap(void)

{
  png_do_packswap();
  return;
}



void png_do_swap(void)

{
  png_do_swap();
  return;
}



void png_read_data(void)

{
  png_read_data();
  return;
}



void png_crc_error(void)

{
  png_crc_error();
  return;
}



void png_set_IHDR(void)

{
  png_set_IHDR();
  return;
}



void png_set_PLTE(void)

{
  png_set_PLTE();
  return;
}



void png_colorspace_set_gamma(void)

{
  png_colorspace_set_gamma();
  return;
}



void png_colorspace_sync(void)

{
  png_colorspace_sync();
  return;
}



void png_set_sBIT(void)

{
  png_set_sBIT();
  return;
}



void png_colorspace_set_chromaticities(void)

{
  png_colorspace_set_chromaticities();
  return;
}



void png_icc_check_length(void)

{
  png_icc_check_length();
  return;
}



void inflateInit_(void)

{
  inflateInit_();
  return;
}



void png_zstream_error(void)

{
  png_zstream_error();
  return;
}



void __aeabi_uidivmod(void)

{
  __aeabi_uidivmod();
  return;
}



void png_set_sPLT(void)

{
  png_set_sPLT();
  return;
}



void png_set_tRNS(void)

{
  png_set_tRNS();
  return;
}



void png_set_bKGD(void)

{
  png_set_bKGD();
  return;
}



void png_set_hIST(void)

{
  png_set_hIST();
  return;
}



void png_set_pHYs(void)

{
  png_set_pHYs();
  return;
}



void png_set_oFFs(void)

{
  png_set_oFFs();
  return;
}



void png_set_pCAL(void)

{
  png_set_pCAL();
  return;
}



void png_set_sCAL_s(void)

{
  png_set_sCAL_s();
  return;
}



void png_set_tIME(void)

{
  png_set_tIME();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t strlen(char *__s)

{
  size_t sVar1;
  
  sVar1 = strlen(__s);
  return sVar1;
}



void png_set_text_2(void)

{
  png_set_text_2();
  return;
}



void png_set_unknown_chunks(void)

{
  png_set_unknown_chunks();
  return;
}



void png_init_read_transformations(void)

{
  png_init_read_transformations();
  return;
}



void png_colorspace_set_endpoints(void)

{
  png_colorspace_set_endpoints();
  return;
}



void png_set_cHRM_fixed(void)

{
  png_set_cHRM_fixed();
  return;
}



void png_set_cHRM_XYZ_fixed(void)

{
  png_set_cHRM_XYZ_fixed();
  return;
}



void png_set_gAMA_fixed(void)

{
  png_set_gAMA_fixed();
  return;
}



void png_check_fp_string(void)

{
  png_check_fp_string();
  return;
}



void png_ascii_from_fp(void)

{
  png_ascii_from_fp();
  return;
}



void png_ascii_from_fixed(void)

{
  png_ascii_from_fixed();
  return;
}



void png_colorspace_set_ICC(void)

{
  png_colorspace_set_ICC();
  return;
}



void png_realloc_array(void)

{
  png_realloc_array();
  return;
}



void png_malloc_array(void)

{
  png_malloc_array();
  return;
}



void png_free_buffer_list(void)

{
  png_free_buffer_list();
  return;
}



void png_set_filler(void)

{
  png_set_filler();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t fwrite(void *__ptr,size_t __size,size_t __n,FILE *__s)

{
  size_t sVar1;
  
  sVar1 = fwrite(__ptr,__size,__n,__s);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fflush(FILE *__stream)

{
  int iVar1;
  
  iVar1 = fflush(__stream);
  return iVar1;
}



void png_write_sig(void)

{
  png_write_sig();
  return;
}



void png_write_IHDR(void)

{
  png_write_IHDR();
  return;
}



void png_write_gAMA_fixed(void)

{
  png_write_gAMA_fixed();
  return;
}



void png_write_sRGB(void)

{
  png_write_sRGB();
  return;
}



void png_write_iCCP(void)

{
  png_write_iCCP();
  return;
}



void png_write_sBIT(void)

{
  png_write_sBIT();
  return;
}



void png_write_cHRM_fixed(void)

{
  png_write_cHRM_fixed();
  return;
}



void png_write_chunk(void)

{
  png_write_chunk();
  return;
}



void png_write_info_before_PLTE(void)

{
  png_write_info_before_PLTE();
  return;
}



void png_write_PLTE(void)

{
  png_write_PLTE();
  return;
}



void png_write_tRNS(void)

{
  png_write_tRNS();
  return;
}



void png_write_bKGD(void)

{
  png_write_bKGD();
  return;
}



void png_write_hIST(void)

{
  png_write_hIST();
  return;
}



void png_write_oFFs(void)

{
  png_write_oFFs();
  return;
}



void png_write_pCAL(void)

{
  png_write_pCAL();
  return;
}



void png_write_sCAL_s(void)

{
  png_write_sCAL_s();
  return;
}



void png_write_pHYs(void)

{
  png_write_pHYs();
  return;
}



void png_write_tIME(void)

{
  png_write_tIME();
  return;
}



void png_write_sPLT(void)

{
  png_write_sPLT();
  return;
}



void png_write_iTXt(void)

{
  png_write_iTXt();
  return;
}



void png_write_zTXt(void)

{
  png_write_zTXt();
  return;
}



void png_write_tEXt(void)

{
  png_write_tEXt();
  return;
}



void png_write_IEND(void)

{
  png_write_IEND();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

tm * gmtime(time_t *__timer)

{
  tm *ptVar1;
  
  ptVar1 = gmtime(__timer);
  return ptVar1;
}



void png_convert_from_struct_tm(void)

{
  png_convert_from_struct_tm();
  return;
}



void png_create_write_struct_2(void)

{
  png_create_write_struct_2();
  return;
}



void png_set_write_fn(void)

{
  png_set_write_fn();
  return;
}



void png_write_row(void)

{
  png_write_row();
  return;
}



void png_write_start_row(void)

{
  png_write_start_row();
  return;
}



void png_do_write_interlace(void)

{
  png_do_write_interlace();
  return;
}



void png_do_write_transformations(void)

{
  png_do_write_transformations();
  return;
}



void png_write_finish_row(void)

{
  png_write_finish_row();
  return;
}



void png_write_find_filter(void)

{
  png_write_find_filter();
  return;
}



void png_compress_IDAT(void)

{
  png_compress_IDAT();
  return;
}



void png_flush(void)

{
  png_flush();
  return;
}



void deflateEnd(void)

{
  deflateEnd();
  return;
}



void png_write_info(void)

{
  png_write_info();
  return;
}



void png_write_image(void)

{
  png_write_image();
  return;
}



void png_write_end(void)

{
  png_write_end();
  return;
}



void __aeabi_memset8(void)

{
  __aeabi_memset8();
  return;
}



void png_set_sRGB(void)

{
  png_set_sRGB();
  return;
}



void png_set_filter(void)

{
  png_set_filter();
  return;
}



void png_image_write_to_stdio(void)

{
  png_image_write_to_stdio();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int remove(char *__filename)

{
  int iVar1;
  
  iVar1 = remove(__filename);
  return iVar1;
}



void png_write_data(void)

{
  png_write_data();
  return;
}



void png_write_chunk_data(void)

{
  png_write_chunk_data();
  return;
}



void png_write_chunk_end(void)

{
  png_write_chunk_end();
  return;
}



void deflate(void)

{
  deflate();
  return;
}



void deflateInit2_(void)

{
  deflateInit2_();
  return;
}



void deflateReset(void)

{
  deflateReset();
  return;
}



void png_check_keyword(void)

{
  png_check_keyword();
  return;
}



void png_save_int_32(void)

{
  png_save_int_32();
  return;
}



void png_write_flush(void)

{
  png_write_flush();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int raise(int __sig)

{
  int iVar1;
  
  iVar1 = raise(__sig);
  return iVar1;
}



void __gnu_Unwind_Find_exidx(void)

{
  __gnu_Unwind_Find_exidx();
  return;
}



void __gnu_Unwind_Restore_VFP_D(void)

{
  __gnu_Unwind_Restore_VFP_D();
  return;
}



void __gnu_Unwind_Restore_VFP(void)

{
  __gnu_Unwind_Restore_VFP();
  return;
}



void __gnu_Unwind_Restore_VFP_D_16_to_31(void)

{
  __gnu_Unwind_Restore_VFP_D_16_to_31();
  return;
}



void __gnu_Unwind_Restore_WMMXD(void)

{
  __gnu_Unwind_Restore_WMMXD();
  return;
}



void __gnu_Unwind_Restore_WMMXC(void)

{
  __gnu_Unwind_Restore_WMMXC();
  return;
}



void restore_core_regs(void)

{
  restore_core_regs();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memcpy(void *__dest,void *__src,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memcpy(__dest,__src,__n);
  return pvVar1;
}



void __gnu_Unwind_RaiseException(void)

{
  __gnu_Unwind_RaiseException();
  return;
}



void _Unwind_VRS_Get(void)

{
  _Unwind_VRS_Get();
  return;
}



void _Unwind_VRS_Set(void)

{
  _Unwind_VRS_Set();
  return;
}



void __cxa_begin_cleanup(void)

{
  __cxa_begin_cleanup();
  return;
}



void __cxa_type_match(void)

{
  __cxa_type_match();
  return;
}



void __gnu_unwind_execute(void)

{
  __gnu_unwind_execute();
  return;
}



void __gnu_Unwind_Save_VFP_D(void)

{
  __gnu_Unwind_Save_VFP_D();
  return;
}



void __gnu_Unwind_Save_VFP(void)

{
  __gnu_Unwind_Save_VFP();
  return;
}



void __gnu_Unwind_Save_VFP_D_16_to_31(void)

{
  __gnu_Unwind_Save_VFP_D_16_to_31();
  return;
}



void __gnu_Unwind_Save_WMMXD(void)

{
  __gnu_Unwind_Save_WMMXD();
  return;
}



void __gnu_Unwind_Save_WMMXC(void)

{
  __gnu_Unwind_Save_WMMXC();
  return;
}



void __gnu_Unwind_Resume(void)

{
  __gnu_Unwind_Resume();
  return;
}



void __gnu_Unwind_Resume_or_Rethrow(void)

{
  __gnu_Unwind_Resume_or_Rethrow();
  return;
}



void __gnu_Unwind_ForcedUnwind(void)

{
  __gnu_Unwind_ForcedUnwind();
  return;
}



void __gnu_Unwind_Backtrace(void)

{
  __gnu_Unwind_Backtrace();
  return;
}



void _Unwind_VRS_Pop(void)

{
  _Unwind_VRS_Pop();
  return;
}



void _FINI_0(void)

{
  __cxa_finalize(&DAT_00035000);
  return;
}



void png_set_sig_bytes(int param_1,uint param_2)

{
  if (param_1 != 0) {
    if ((int)param_2 < 0) {
      param_2 = 0;
    }
    if (8 < param_2) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Too many bytes for PNG signature");
    }
    *(char *)(param_1 + 0x211) = (char)param_2;
  }
  return;
}



void png_sig_cmp(int param_1,uint param_2,size_t param_3)

{
  int iVar1;
  undefined4 local_18;
  undefined4 local_14;
  int local_c;
  
  local_c = __stack_chk_guard;
  local_14 = 0xa1a0a0d;
  local_18 = 0x474e5089;
  if (param_3 < 9) {
    if (param_3 != 0) goto LAB_000173f4;
  }
  else {
    param_3 = 8;
LAB_000173f4:
    if (param_2 < 8) {
      if (8 < param_3 + param_2) {
        param_3 = 8 - param_2;
      }
      iVar1 = memcmp((void *)(param_1 + param_2),(void *)((int)&local_18 + param_2),param_3);
      goto LAB_00017412;
    }
  }
  iVar1 = -1;
LAB_00017412:
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar1);
  }
  return;
}



undefined4 png_zalloc(int param_1,uint param_2,int param_3)

{
  uint uVar1;
  undefined4 uVar2;
  
  if ((param_1 != 0) && (uVar1 = __aeabi_uidiv(0xffffffff,param_3), param_2 < uVar1)) {
    uVar2 = png_malloc_warn(param_1,param_3 * param_2);
    return uVar2;
  }
  return 0;
}



void png_zfree(void)

{
  png_free();
  return;
}



void png_reset_crc(int param_1)

{
  undefined4 uVar1;
  
  uVar1 = crc32(0,0,0);
  *(undefined4 *)(param_1 + 500) = uVar1;
  return;
}



void png_calculate_crc(int param_1,int param_2,int param_3)

{
  bool bVar1;
  undefined4 uVar2;
  int iVar3;
  
  bVar1 = (*(uint *)(param_1 + 0x134) & 0x300) == 0x300;
  if ((*(byte *)(param_1 + 0x1db) & 0x20) == 0) {
    bVar1 = (*(uint *)(param_1 + 0x134) & 0x800) != 0;
  }
  if ((param_3 != 0) && (!bVar1)) {
    uVar2 = *(undefined4 *)(param_1 + 500);
    do {
      iVar3 = param_3;
      if (param_3 == 0) {
        iVar3 = -1;
      }
      uVar2 = crc32(uVar2,param_2,iVar3);
      param_3 = param_3 - iVar3;
      param_2 = param_2 + iVar3;
    } while (param_3 != 0);
    *(undefined4 *)(param_1 + 500) = uVar2;
  }
  return;
}



uint png_user_version_check(int param_1,int param_2)

{
  code *pcVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  uint uVar6;
  int iVar7;
  bool bVar8;
  
  if (param_2 == 0) {
    uVar4 = *(uint *)(param_1 + 0x134) | 0x20000;
    *(uint *)(param_1 + 0x134) = uVar4;
  }
  else {
    iVar3 = -1;
    iVar7 = 0;
    do {
      iVar2 = iVar3 + 1;
      if (SBORROW4(iVar2,iVar3)) {
LAB_00017544:
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x17544);
        (*pcVar1)();
      }
      uVar6 = (uint)*(byte *)(param_2 + iVar2);
      uVar4 = (uint)(byte)"1.6.22beta03"[iVar3 + 1];
      bVar8 = uVar6 != uVar4;
      if (bVar8) {
        uVar4 = *(uint *)(param_1 + 0x134) | 0x20000;
      }
      if (bVar8) {
        *(uint *)(param_1 + 0x134) = uVar4;
      }
      iVar5 = iVar7;
      if ((uVar6 == 0x2e) && (iVar5 = iVar7 + 1, SBORROW4(iVar5,iVar7))) goto LAB_00017544;
    } while (((iVar5 < 2) && (iVar2 != 0xc)) && (iVar3 = iVar2, iVar7 = iVar5, uVar6 != 0));
    uVar4 = *(uint *)(param_1 + 0x134);
  }
  return ~(uVar4 >> 0x11) & 1;
}



void png_create_png_struct
               (undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
               undefined4 param_5,undefined4 param_6,undefined4 param_7)

{
  int iVar1;
  __jmp_buf_tag _Stack_4e0;
  undefined1 auStack_3e0 [256];
  code *local_2e0;
  undefined1 *local_2dc;
  undefined4 local_2d8;
  code *local_280;
  code *pcStack_27c;
  int iStack_278;
  undefined4 local_b4;
  undefined4 local_b0;
  undefined4 local_ac;
  undefined4 local_a8;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  __aeabi_memclr8(auStack_3e0,0x3c4);
  local_b4 = 1000000;
  local_b0 = 1000000;
  local_ac = 1000;
  local_a8 = 8000000;
  png_set_mem_fn(auStack_3e0,param_5,param_6,param_7);
  png_set_error_fn(auStack_3e0,param_2,param_3,param_4);
  iVar1 = setjmp(&_Stack_4e0);
  if (iVar1 == 0) {
    local_2d8 = 0;
    local_2e0 = longjmp;
    local_2dc = (undefined1 *)&_Stack_4e0;
    iVar1 = png_user_version_check(auStack_3e0,param_1);
    if ((iVar1 != 0) && (iVar1 = png_malloc_warn(auStack_3e0,0x3c4), iVar1 != 0)) {
      local_280 = png_zalloc;
      pcStack_27c = png_zfree;
      local_2d8 = 0;
      local_2e0 = (code *)0x0;
      local_2dc = (undefined1 *)0x0;
      iStack_278 = iVar1;
      __aeabi_memcpy4(iVar1,auStack_3e0,0x3c4);
    }
  }
  if (__stack_chk_guard - local_1c != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_1c);
  }
  return;
}



int png_create_info_struct(int param_1)

{
  int iVar1;
  
  if (param_1 == 0) {
    iVar1 = 0;
  }
  else {
    iVar1 = png_malloc_base(param_1,0x10c);
    if (iVar1 != 0) {
      __aeabi_memclr4(iVar1,0x10c);
    }
  }
  return iVar1;
}



void png_destroy_info_struct(int param_1,int *param_2)

{
  int iVar1;
  
  if (((param_1 != 0) && (param_2 != (int *)0x0)) && (iVar1 = *param_2, iVar1 != 0)) {
    *param_2 = 0;
    png_free_data(param_1,iVar1,0x7fff,0xffffffff);
    __aeabi_memclr4(iVar1,0x10c);
    png_free(param_1,iVar1);
    return;
  }
  return;
}



void png_free_data(int param_1,int param_2,uint param_3,int param_4)

{
  code *pcVar1;
  uint uVar2;
  int iVar3;
  undefined4 *puVar4;
  uint *puVar5;
  bool bVar6;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    iVar3 = *(int *)(param_2 + 0x88);
    if ((iVar3 != 0) && ((*(uint *)(param_2 + 0xe8) & param_3 & 0x4000) != 0)) {
      if (param_4 == -1) {
        if (0 < *(int *)(param_2 + 0x80)) {
          png_free(param_1,*(undefined4 *)(iVar3 + 4));
          iVar3 = 1;
          do {
            if (*(int *)(param_2 + 0x80) <= iVar3) {
              iVar3 = *(int *)(param_2 + 0x88);
              goto LAB_0001772e;
            }
            png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0x88) + iVar3 * 0x1c + 4));
            bVar6 = SBORROW4(iVar3 + 1,iVar3);
            iVar3 = iVar3 + 1;
          } while (!bVar6);
          goto LAB_00017970;
        }
LAB_0001772e:
        png_free(param_1,iVar3);
        *(undefined4 *)(param_2 + 0x88) = 0;
        *(undefined4 *)(param_2 + 0x80) = 0;
      }
      else {
        png_free(param_1,*(undefined4 *)(iVar3 + param_4 * 0x1c + 4));
        *(undefined4 *)(*(int *)(param_2 + 0x88) + param_4 * 0x1c + 4) = 0;
      }
    }
    puVar5 = (uint *)(param_2 + 0xe8);
    uVar2 = *puVar5;
    if ((param_3 & uVar2 & 0x2000) != 0) {
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xffffffef;
      png_free(param_1,*(undefined4 *)(param_2 + 0x9c));
      *(undefined4 *)(param_2 + 0x9c) = 0;
      *(undefined2 *)(param_2 + 0x16) = 0;
      uVar2 = *puVar5;
    }
    if ((param_3 & uVar2 & 0x100) != 0) {
      png_free(param_1,*(undefined4 *)(param_2 + 0x100));
      png_free(param_1,*(undefined4 *)(param_2 + 0x104));
      *(undefined4 *)(param_2 + 0x100) = 0;
      *(undefined4 *)(param_2 + 0x104) = 0;
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xffffbfff;
      uVar2 = *puVar5;
    }
    if ((param_3 & uVar2 & 0x80) != 0) {
      png_free(param_1,*(undefined4 *)(param_2 + 0xd0));
      png_free(param_1,*(undefined4 *)(param_2 + 0xdc));
      *(undefined4 *)(param_2 + 0xd0) = 0;
      *(undefined4 *)(param_2 + 0xdc) = 0;
      puVar4 = *(undefined4 **)(param_2 + 0xe0);
      if (puVar4 != (undefined4 *)0x0) {
        if (*(char *)(param_2 + 0xe5) != '\0') {
          png_free(param_1,*puVar4);
          iVar3 = 1;
          do {
            if ((int)(uint)*(byte *)(param_2 + 0xe5) <= iVar3) {
              puVar4 = *(undefined4 **)(param_2 + 0xe0);
              goto LAB_00017804;
            }
            png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0xe0) + iVar3 * 4));
            bVar6 = SBORROW4(iVar3 + 1,iVar3);
            iVar3 = iVar3 + 1;
          } while (!bVar6);
          goto LAB_00017970;
        }
LAB_00017804:
        png_free(param_1,puVar4);
        *(undefined4 *)(param_2 + 0xe0) = 0;
      }
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xfffffbff;
      uVar2 = *puVar5;
    }
    if ((uVar2 & param_3 & 0x10) != 0) {
      png_free(param_1,*(undefined4 *)(param_2 + 0x74));
      png_free(param_1,*(undefined4 *)(param_2 + 0x78));
      *(undefined4 *)(param_2 + 0x74) = 0;
      *(undefined4 *)(param_2 + 0x78) = 0;
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xffffefff;
    }
    puVar4 = *(undefined4 **)(param_2 + 0xf4);
    if ((puVar4 != (undefined4 *)0x0) && ((*puVar5 & param_3 & 0x20) != 0)) {
      if (param_4 == -1) {
        if (0 < *(int *)(param_2 + 0xf8)) {
          png_free(param_1,*puVar4);
          png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0xf4) + 8));
          iVar3 = 1;
          do {
            if (*(int *)(param_2 + 0xf8) <= iVar3) {
              puVar4 = *(undefined4 **)(param_2 + 0xf4);
              goto LAB_000178e6;
            }
            png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0xf4) + iVar3 * 0x10));
            png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0xf4) + iVar3 * 0x10 + 8));
            bVar6 = SBORROW4(iVar3 + 1,iVar3);
            iVar3 = iVar3 + 1;
          } while (!bVar6);
          goto LAB_00017970;
        }
LAB_000178e6:
        png_free(param_1,puVar4);
        *(undefined4 *)(param_2 + 0xf4) = 0;
        *(undefined4 *)(param_2 + 0xf8) = 0;
        *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xffffdfff;
      }
      else {
        png_free(param_1,puVar4[param_4 * 4]);
        png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0xf4) + param_4 * 0x10 + 8));
        *(undefined4 *)(*(int *)(param_2 + 0xf4) + param_4 * 0x10) = 0;
        *(undefined4 *)(*(int *)(param_2 + 0xf4) + param_4 * 0x10 + 8) = 0;
      }
    }
    iVar3 = *(int *)(param_2 + 0xec);
    if ((iVar3 != 0) && ((*puVar5 & param_3 & 0x200) != 0)) {
      if (param_4 == -1) {
        if (0 < *(int *)(param_2 + 0xf0)) {
          png_free(param_1,*(undefined4 *)(iVar3 + 8));
          iVar3 = 1;
          do {
            if (*(int *)(param_2 + 0xf0) <= iVar3) {
              iVar3 = *(int *)(param_2 + 0xec);
              goto LAB_00017976;
            }
            png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0xec) + iVar3 * 0x14 + 8));
            bVar6 = SBORROW4(iVar3 + 1,iVar3);
            iVar3 = iVar3 + 1;
          } while (!bVar6);
LAB_00017970:
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x17970);
          (*pcVar1)();
        }
LAB_00017976:
        png_free(param_1,iVar3);
        *(undefined4 *)(param_2 + 0xec) = 0;
        *(undefined4 *)(param_2 + 0xf0) = 0;
      }
      else {
        png_free(param_1,*(undefined4 *)(iVar3 + param_4 * 0x14 + 8));
        *(undefined4 *)(*(int *)(param_2 + 0xec) + param_4 * 0x14 + 8) = 0;
      }
    }
    uVar2 = *puVar5;
    if ((param_3 & uVar2 & 8) != 0) {
      png_free(param_1,*(undefined4 *)(param_2 + 0xcc));
      *(undefined4 *)(param_2 + 0xcc) = 0;
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xffffffbf;
      uVar2 = *puVar5;
    }
    if ((param_3 & uVar2 & 0x1000) != 0) {
      png_free(param_1,*(undefined4 *)(param_2 + 0x10));
      *(undefined4 *)(param_2 + 0x10) = 0;
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xfffffff7;
      *(undefined2 *)(param_2 + 0x14) = 0;
      uVar2 = *puVar5;
    }
    if ((param_3 & uVar2 & 0x40) != 0) {
      puVar4 = *(undefined4 **)(param_2 + 0x108);
      if (puVar4 != (undefined4 *)0x0) {
        if (*(int *)(param_2 + 4) != 0) {
          png_free(param_1,*puVar4);
          if (1 < *(uint *)(param_2 + 4)) {
            uVar2 = 1;
            do {
              png_free(param_1,*(undefined4 *)(*(int *)(param_2 + 0x108) + uVar2 * 4));
              uVar2 = uVar2 + 1;
            } while (uVar2 < *(uint *)(param_2 + 4));
          }
          puVar4 = *(undefined4 **)(param_2 + 0x108);
        }
        png_free(param_1,puVar4);
        *(undefined4 *)(param_2 + 0x108) = 0;
        uVar2 = *puVar5;
      }
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xffff7fff;
    }
    if (param_4 != -1) {
      param_3 = param_3 & 0xffffbddf;
    }
    *puVar5 = uVar2 & ~param_3;
  }
  return;
}



void png_info_init_3(undefined4 *param_1,uint param_2)

{
  void *__ptr;
  
  __ptr = (void *)*param_1;
  if (__ptr != (void *)0x0) {
    if (param_2 >> 2 < 0x43) {
      *param_1 = 0;
      free(__ptr);
      __ptr = (void *)png_malloc_base(0,0x10c);
      if (__ptr == (void *)0x0) {
        return;
      }
      *param_1 = __ptr;
    }
    __aeabi_memclr4(__ptr,0x10c);
  }
  return;
}



void png_data_freer(int param_1,int param_2,int param_3,uint param_4)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    if (param_3 == 2) {
      param_4 = *(uint *)(param_2 + 0xe8) & ~param_4;
    }
    else {
      if (param_3 != 1) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Unknown freer parameter in png_data_freer");
      }
      param_4 = *(uint *)(param_2 + 0xe8) | param_4;
    }
    *(uint *)(param_2 + 0xe8) = param_4;
  }
  return;
}



undefined4 png_get_progressive_ptr(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x11c);
  }
  return uVar1;
}



void png_init_io(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x11c) = param_2;
  }
  return;
}



void png_save_int_32(void)

{
  png_save_uint_32();
  return;
}



void png_convert_to_rfc1123_buffer(int param_1,ushort *param_2)

{
  ushort uVar1;
  undefined4 uVar2;
  uint uVar3;
  uint uVar4;
  bool bVar5;
  bool bVar6;
  undefined1 auStack_1d [5];
  int local_18;
  
  local_18 = __stack_chk_guard;
  if ((((param_1 != 0) && (*param_2 < 10000)) && ((param_2[1] - 1 & 0xff) < 0xc)) &&
     ((((param_2[1] >> 8) - 1 & 0xff) < 0x1f && ((byte)param_2[2] < 0x18)))) {
    uVar1 = param_2[2] >> 8;
    bVar6 = 0x3a < uVar1;
    bVar5 = uVar1 == 0x3b;
    if (uVar1 < 0x3c) {
      bVar6 = 0x3b < (byte)param_2[3];
      bVar5 = (byte)param_2[3] == 0x3c;
    }
    if (!bVar6 || bVar5) {
      uVar2 = png_format_number(auStack_1d,&local_18,1);
      uVar3 = png_safecat(param_1,0x1d,0,uVar2);
      uVar4 = uVar3;
      if (uVar3 < 0x1c) {
        uVar4 = 0x20;
      }
      if (uVar3 < 0x1c) {
        *(char *)(param_1 + uVar3) = (char)uVar4;
        uVar3 = uVar3 + 1;
      }
      uVar3 = png_safecat(param_1,0x1d,uVar3,
                          "error writing ancillary chunked compressed data" +
                          (uint)(byte)param_2[1] * 4 + 0x2c);
      uVar4 = uVar3;
      if (uVar3 < 0x1c) {
        uVar4 = 0x20;
      }
      if (uVar3 < 0x1c) {
        *(char *)(param_1 + uVar3) = (char)uVar4;
        uVar3 = uVar3 + 1;
      }
      uVar2 = png_format_number(auStack_1d,&local_18,1,*param_2);
      uVar3 = png_safecat(param_1,0x1d,uVar3,uVar2);
      uVar4 = uVar3;
      if (uVar3 < 0x1c) {
        uVar4 = 0x20;
      }
      if (uVar3 < 0x1c) {
        *(char *)(param_1 + uVar3) = (char)uVar4;
        uVar3 = uVar3 + 1;
      }
      uVar2 = png_format_number(auStack_1d,&local_18,2,(char)param_2[2]);
      uVar3 = png_safecat(param_1,0x1d,uVar3,uVar2);
      uVar4 = uVar3;
      if (uVar3 < 0x1c) {
        uVar4 = 0x3a;
      }
      if (uVar3 < 0x1c) {
        *(char *)(param_1 + uVar3) = (char)uVar4;
        uVar3 = uVar3 + 1;
      }
      uVar2 = png_format_number(auStack_1d,&local_18,2,*(undefined1 *)((int)param_2 + 5));
      uVar3 = png_safecat(param_1,0x1d,uVar3,uVar2);
      uVar4 = uVar3;
      if (uVar3 < 0x1c) {
        uVar4 = 0x3a;
      }
      if (uVar3 < 0x1c) {
        *(char *)(param_1 + uVar3) = (char)uVar4;
        uVar3 = uVar3 + 1;
      }
      uVar2 = png_format_number(auStack_1d,&local_18,2,(char)param_2[3]);
      uVar2 = png_safecat(param_1,0x1d,uVar3,uVar2);
      png_safecat(param_1,0x1d,uVar2," +0000");
      uVar2 = 1;
      goto LAB_00017b02;
    }
  }
  uVar2 = 0;
LAB_00017b02:
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar2);
  }
  return;
}



int png_convert_to_rfc1123(int param_1)

{
  int iVar1;
  
  if (param_1 != 0) {
    iVar1 = png_convert_to_rfc1123_buffer(param_1 + 0x2c5);
    if (iVar1 != 0) {
      return param_1 + 0x2c5;
    }
  }
  return 0;
}



char * png_get_copyright(void)

{
  return 
  "\nlibpng version 1.6.22beta03 - February 8, 2016\nCopyright (c) 1998-2002,2004,2006-2016 Glenn Randers-Pehrson\nCopyright (c) 1996-1997 Andreas Dilger\nCopyright (c) 1995-1996 Guy Eric Schalnat, Group 42, Inc.\n"
  ;
}



char * png_get_libpng_ver(void)

{
  return "1.6.22beta03";
}



char * png_get_header_version(void)

{
  return " libpng version 1.6.22beta03 - February 19, 2016\n\n";
}



void png_build_grayscale_palette(int param_1,int param_2)

{
  code *pcVar1;
  undefined1 uVar2;
  uint uVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  
  if (((param_2 != 0) && (uVar3 = param_1 - 1, uVar3 < 8)) && ((0x8bU >> (uVar3 & 0xff) & 1) != 0))
  {
    iVar7 = *(int *)(&DAT_00033270 + uVar3 * 4);
    iVar8 = *(int *)(&DAT_00033250 + uVar3 * 4);
    iVar4 = 0;
    iVar6 = 0;
    do {
      uVar2 = (undefined1)iVar6;
      *(undefined1 *)(param_2 + iVar4 * 3) = uVar2;
      iVar5 = iVar4 * 3 + param_2;
      *(undefined1 *)(iVar5 + 1) = uVar2;
      *(undefined1 *)(iVar5 + 2) = uVar2;
      iVar5 = iVar4 + 1;
      if ((SBORROW4(iVar5,iVar4)) || (SBORROW4(iVar6 + iVar7,iVar6))) {
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x17cac);
        (*pcVar1)();
      }
      iVar4 = iVar5;
      iVar6 = iVar6 + iVar7;
    } while (iVar5 < iVar8);
  }
  return;
}



undefined1 png_handle_as_unknown(int param_1,int *param_2)

{
  int *piVar1;
  int *piVar2;
  
  if (((param_1 != 0) && (param_2 != (int *)0x0)) && (*(int *)(param_1 + 0x2f4) != 0)) {
    piVar2 = (int *)(*(int *)(param_1 + 0x2f4) * 5 + (int)*(int **)(param_1 + 0x2f8));
    do {
      piVar1 = (int *)((int)piVar2 - 5);
      if (*param_2 == *piVar1) {
        return *(undefined1 *)((int)piVar2 - 1);
      }
      piVar2 = piVar1;
    } while (*(int **)(param_1 + 0x2f8) < piVar1);
  }
  return 0;
}



void png_chunk_unknown_handling(undefined4 param_1,undefined4 param_2)

{
  undefined1 local_11;
  undefined1 local_10;
  undefined1 local_f;
  undefined1 local_e;
  undefined1 local_d;
  int local_c;
  
  local_c = __stack_chk_guard;
  local_11 = (undefined1)((uint)param_2 >> 0x18);
  local_10 = (undefined1)((uint)param_2 >> 0x10);
  local_f = (undefined1)((uint)param_2 >> 8);
  local_e = (undefined1)param_2;
  local_d = 0;
  png_handle_as_unknown(param_1,&local_11);
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



undefined4 png_reset_zstream(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    return 0xfffffffe;
  }
  uVar1 = inflateReset(param_1 + 0x140);
  return uVar1;
}



undefined4 png_access_version_number(void)

{
  return 0x297e;
}



void png_zstream_error(int param_1,undefined4 param_2)

{
  char *pcVar1;
  
  if (*(int *)(param_1 + 0x158) == 0) {
    switch(param_2) {
    default:
      pcVar1 = "unexpected zlib return code";
      break;
    case 1:
      pcVar1 = "unexpected end of LZ stream";
      break;
    case 2:
      pcVar1 = "missing LZ dictionary";
      break;
    case 0xfffffff9:
      pcVar1 = "unexpected zlib return";
      break;
    case 0xfffffffa:
      pcVar1 = "unsupported zlib version";
      break;
    case 0xfffffffb:
      pcVar1 = "truncated";
      break;
    case 0xfffffffc:
      pcVar1 = "insufficient memory";
      break;
    case 0xfffffffd:
      pcVar1 = "damaged LZ stream";
      break;
    case 0xfffffffe:
      pcVar1 = "bad parameters to zlib";
      break;
    case 0xffffffff:
      pcVar1 = "zlib IO error";
    }
    *(char **)(param_1 + 0x158) = pcVar1;
  }
  return;
}



void png_colorspace_set_gamma(int param_1,int *param_2,int param_3)

{
  int iVar1;
  char *pcVar2;
  uint uVar3;
  ushort uVar4;
  uint unaff_r6;
  bool bVar5;
  
  if (param_3 - 0x10U < 0x2540be31) {
    uVar4 = *(ushort *)((int)param_2 + 0x4a);
    uVar3 = *(uint *)(param_1 + 0x130);
    bVar5 = (uVar3 & 0x8000) == 0;
    if (!bVar5) {
      uVar3 = uVar4 & 8;
      unaff_r6 = 0xffff;
    }
    if (bVar5 || (uVar3 & unaff_r6) == 0) {
      if ((-1 < (short)uVar4) && (iVar1 = FUN_00017e60(param_1,param_2,param_3,1), iVar1 != 0)) {
        *param_2 = param_3;
        *(ushort *)((int)param_2 + 0x4a) = uVar4 | 9;
      }
      return;
    }
    pcVar2 = "duplicate";
  }
  else {
    uVar4 = *(ushort *)((int)param_2 + 0x4a);
    pcVar2 = "gamma value out of range";
  }
  *(ushort *)((int)param_2 + 0x4a) = uVar4 | 0x8000;
  png_chunk_report(param_1,pcVar2,1);
  return;
}



uint FUN_00017e60(undefined4 param_1,int *param_2,int param_3,uint param_4)

{
  ushort uVar1;
  undefined4 uVar2;
  undefined4 extraout_r1;
  undefined4 unaff_r4;
  double dVar3;
  undefined4 in_stack_ffffffe8;
  
  uVar1 = *(ushort *)((int)param_2 + 0x4a);
  if ((uVar1 & 1) == 0) {
LAB_00017f0a:
    param_4 = 1;
  }
  else {
    if ((param_3 != 0) && (*param_2 != 0)) {
      uVar2 = SUB84(((double)(longlong)*param_2 * 100000.0) / (double)(longlong)param_3 + 0.5,0);
      floor((double)CONCAT44(unaff_r4,in_stack_ffffffe8));
      dVar3 = (double)CONCAT44(extraout_r1,uVar2);
      if ((dVar3 <= 2147483647.0) &&
         ((dVar3 < -2147483648.0 == NAN(dVar3) && ((int)(longlong)dVar3 - 95000U < 0x2711))))
      goto LAB_00017f0a;
    }
    if ((param_4 == 2) || ((uVar1 & 0x20) != 0)) {
      png_chunk_report(param_1,"gamma value does not match sRGB",2);
      param_4 = (uint)(param_4 == 2);
    }
    else {
      png_chunk_report(param_1,"gamma value does not match libpng estimate",0);
      if (param_4 != 1) {
        param_4 = 0;
      }
    }
  }
  return param_4;
}



void png_colorspace_sync_info(undefined4 param_1,int param_2)

{
  ushort uVar1;
  uint uVar2;
  uint uVar3;
  
  uVar1 = *(ushort *)(param_2 + 0x72);
  if ((uVar1 & 0x8000) == 0) {
    uVar3 = *(uint *)(param_2 + 8) | 0x800;
    if ((uVar1 & 0x80) == 0) {
      uVar3 = *(uint *)(param_2 + 8) & 0xfffff7ff;
    }
    uVar2 = uVar3 | 4;
    if ((uVar1 & 2) == 0) {
      uVar2 = uVar3 & 0xfffffffb;
    }
    *(uint *)(param_2 + 8) = uVar2;
    if ((uVar1 & 1) == 0) {
      uVar2 = uVar2 & 0xfffffffe;
    }
    else {
      uVar2 = uVar2 | 1;
    }
    *(uint *)(param_2 + 8) = uVar2;
    return;
  }
  *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & 0xffffe7fa;
  png_free_data(param_1,param_2,0x10,0xffffffff);
  return;
}



void png_colorspace_sync(int param_1,int param_2)

{
  if (param_2 == 0) {
    return;
  }
  __aeabi_memcpy4(param_2 + 0x28,param_1 + 0x378,0x4c);
  png_colorspace_sync_info(param_1,param_2);
  return;
}



void png_colorspace_set_chromaticities
               (undefined4 param_1,int param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  undefined4 uVar2;
  undefined1 auStack_3c [36];
  int local_18;
  
  local_18 = __stack_chk_guard;
  iVar1 = FUN_00018040(auStack_3c,param_3);
  if (iVar1 == 1) {
    *(ushort *)(param_2 + 0x4a) = *(ushort *)(param_2 + 0x4a) | 0x8000;
    png_benign_error(param_1,"invalid chromaticities");
    uVar2 = 0;
  }
  else {
    if (iVar1 != 0) {
      *(ushort *)(param_2 + 0x4a) = *(ushort *)(param_2 + 0x4a) | 0x8000;
                    // WARNING: Subroutine does not return
      png_error(param_1,"internal error checking chromaticities");
    }
    uVar2 = FUN_00018a18(param_1,param_2,param_3,auStack_3c,param_4);
  }
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar2);
  }
  return;
}



void FUN_00018040(undefined4 *param_1,uint *param_2)

{
  code *pcVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  undefined4 uVar6;
  undefined4 uVar7;
  uint uVar8;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  undefined4 extraout_r1_02;
  undefined4 extraout_r1_03;
  undefined4 extraout_r1_04;
  undefined4 extraout_r1_05;
  undefined4 extraout_r1_06;
  undefined4 extraout_r1_07;
  undefined4 extraout_r1_08;
  undefined4 extraout_r1_09;
  undefined4 extraout_r1_10;
  undefined4 extraout_r1_11;
  undefined4 extraout_r1_12;
  undefined4 extraout_r1_13;
  undefined4 extraout_r1_14;
  undefined4 extraout_r1_15;
  undefined4 extraout_r1_16;
  undefined4 extraout_r1_17;
  undefined4 extraout_r1_18;
  int iVar9;
  uint uVar10;
  int iVar11;
  uint uVar12;
  int iVar13;
  uint uVar14;
  int iVar15;
  uint uVar16;
  int iVar17;
  uint uVar18;
  uint uVar19;
  int iVar20;
  double dVar21;
  double dVar22;
  double dVar23;
  undefined4 in_stack_ffffff68;
  undefined4 in_stack_ffffff6c;
  int local_8c;
  undefined1 auStack_7c [32];
  int local_5c;
  
  local_5c = __stack_chk_guard;
  uVar12 = *param_2;
  if ((uVar12 < 0x186a1) && (uVar2 = param_2[1], -1 < (int)uVar2)) {
    if (!SBORROW4(100000,uVar12)) {
      if ((((int)(100000 - uVar12) < (int)uVar2) || (uVar8 = param_2[2], 100000 < uVar8)) ||
         (uVar16 = param_2[3], (int)uVar16 < 0)) goto LAB_000187d0;
      if (!SBORROW4(100000,uVar8)) {
        if ((((int)(100000 - uVar8) < (int)uVar16) || (uVar18 = param_2[4], 100000 < uVar18)) ||
           (uVar14 = param_2[5], (int)uVar14 < 0)) goto LAB_000187d0;
        if (!SBORROW4(100000,uVar18)) {
          if ((((int)(100000 - uVar18) < (int)uVar14) || (uVar10 = param_2[6], 100000 < uVar10)) ||
             (uVar19 = param_2[7], (int)uVar19 < 5)) goto LAB_000187d0;
          if (!SBORROW4(100000,uVar10)) {
            if ((int)(100000 - uVar10) < (int)uVar19) goto LAB_000187d0;
            if ((!SBORROW4(uVar8,uVar18)) && (!SBORROW4(uVar2,uVar14))) {
              iVar13 = uVar8 - uVar18;
              iVar3 = uVar2 - uVar14;
              iVar9 = 0;
              if (iVar13 != 0 && iVar3 != 0) {
                uVar7 = SUB84(((double)(longlong)iVar13 * (double)(longlong)iVar3) / 7.0 + 0.5,0);
                floor((double)CONCAT44(in_stack_ffffff6c,in_stack_ffffff68));
                dVar21 = (double)CONCAT44(extraout_r1,uVar7);
                if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21)))
                goto LAB_000187d0;
                iVar9 = (int)(longlong)dVar21;
              }
              if ((!SBORROW4(uVar16,uVar14)) && (!SBORROW4(uVar12,uVar18))) {
                iVar17 = uVar16 - uVar14;
                iVar4 = uVar12 - uVar18;
                iVar20 = 0;
                if (iVar4 != 0 && iVar17 != 0) {
                  uVar7 = SUB84(((double)(longlong)iVar4 * (double)(longlong)iVar17) / 7.0 + 0.5,0);
                  floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                  dVar21 = (double)CONCAT44(extraout_r1_00,uVar7);
                  if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21)))
                  goto LAB_000187d0;
                  iVar20 = (int)(longlong)dVar21;
                }
                if ((!SBORROW4(iVar9,iVar20)) && (!SBORROW4(uVar19,uVar14))) {
                  iVar5 = uVar19 - uVar14;
                  iVar15 = 0;
                  if ((iVar13 != 0) && (iVar5 != 0)) {
                    uVar7 = SUB84(((double)(longlong)iVar13 * (double)(longlong)iVar5) / 7.0 + 0.5,0
                                 );
                    floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                    dVar21 = (double)CONCAT44(extraout_r1_01,uVar7);
                    if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21)))
                    goto LAB_000187d0;
                    iVar15 = (int)(longlong)dVar21;
                  }
                  if (!SBORROW4(uVar10,uVar18)) {
                    iVar11 = uVar10 - uVar18;
                    iVar13 = 0;
                    if (iVar17 != 0 && iVar11 != 0) {
                      uVar7 = SUB84(((double)(longlong)iVar17 * (double)(longlong)iVar11) / 7.0 +
                                    0.5,0);
                      floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                      dVar21 = (double)CONCAT44(extraout_r1_02,uVar7);
                      if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21)))
                      goto LAB_000187d0;
                      iVar13 = (int)(longlong)dVar21;
                    }
                    if (!SBORROW4(iVar15,iVar13)) {
                      if (iVar15 - iVar13 != 0) {
                        iVar9 = iVar9 - iVar20;
                        if (iVar9 == 0) {
                          iVar13 = 0;
                        }
                        else {
                          uVar7 = SUB84(((double)(longlong)(int)uVar19 * (double)(longlong)iVar9) /
                                        (double)(longlong)(iVar15 - iVar13) + 0.5,0);
                          floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                          dVar21 = (double)CONCAT44(extraout_r1_03,uVar7);
                          if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21)))
                          goto LAB_000187d0;
                          iVar13 = (int)(longlong)dVar21;
                        }
                        if ((int)uVar19 < iVar13) {
                          local_8c = 0;
                          if ((iVar3 != 0) && (iVar11 != 0)) {
                            uVar7 = SUB84(((double)(longlong)iVar3 * (double)(longlong)iVar11) / 7.0
                                          + 0.5,0);
                            floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                            dVar21 = (double)CONCAT44(extraout_r1_04,uVar7);
                            if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21)))
                            goto LAB_000187d0;
                            local_8c = (int)(longlong)dVar21;
                          }
                          iVar3 = 0;
                          if ((iVar4 != 0) && (iVar5 != 0)) {
                            uVar7 = SUB84(((double)(longlong)iVar4 * (double)(longlong)iVar5) / 7.0
                                          + 0.5,0);
                            floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                            dVar21 = (double)CONCAT44(extraout_r1_05,uVar7);
                            if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21)))
                            goto LAB_000187d0;
                            iVar3 = (int)(longlong)dVar21;
                          }
                          if (SBORROW4(local_8c,iVar3)) goto LAB_000189d8;
                          if (local_8c - iVar3 != 0) {
                            if (iVar9 == 0) {
                              iVar9 = 0;
                            }
                            else {
                              uVar7 = SUB84(((double)(longlong)(int)uVar19 * (double)(longlong)iVar9
                                            ) / (double)(longlong)(local_8c - iVar3) + 0.5,0);
                              floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                              dVar21 = (double)CONCAT44(extraout_r1_06,uVar7);
                              if ((2147483647.0 < dVar21) || (dVar21 < -2147483648.0 != NAN(dVar21))
                                 ) goto LAB_000187d0;
                              iVar9 = (int)(longlong)dVar21;
                            }
                            if ((int)uVar19 < iVar9) {
                              uVar7 = SUB84(10000000000.0 / (double)(longlong)(int)uVar19 + 0.5,0);
                              floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                              dVar23 = (double)(longlong)iVar13;
                              uVar6 = SUB84(10000000000.0 / dVar23 + 0.5,0);
                              floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                              dVar21 = (double)CONCAT44(extraout_r1_08,uVar6);
                              dVar22 = (double)CONCAT44(extraout_r1_07,uVar7);
                              iVar3 = (int)(longlong)dVar21;
                              iVar20 = (int)(longlong)dVar22;
                              if (dVar21 < -2147483648.0 != NAN(dVar21)) {
                                iVar3 = 0;
                              }
                              if (2147483647.0 < dVar21) {
                                iVar3 = 0;
                              }
                              if (dVar22 < -2147483648.0 != NAN(dVar22)) {
                                iVar20 = 0;
                              }
                              if (2147483647.0 < dVar22) {
                                iVar20 = 0;
                              }
                              if (!SBORROW4(iVar20,iVar3)) {
                                dVar22 = (double)(longlong)iVar9;
                                uVar7 = SUB84(10000000000.0 / dVar22 + 0.5,0);
                                floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                dVar21 = (double)CONCAT44(extraout_r1_09,uVar7);
                                iVar17 = (int)(longlong)dVar21;
                                if (dVar21 < -2147483648.0 != NAN(dVar21)) {
                                  iVar17 = 0;
                                }
                                if (2147483647.0 < dVar21) {
                                  iVar17 = 0;
                                }
                                if (!SBORROW4(iVar20 - iVar3,iVar17)) {
                                  iVar17 = (iVar20 - iVar3) - iVar17;
                                  if ((iVar17 < 1) || (iVar13 == 0)) goto LAB_000187d0;
                                  if (uVar12 == 0) {
                                    uVar7 = 0;
                                  }
                                  else {
                                    uVar7 = SUB84(((double)(longlong)(int)uVar12 * 100000.0) /
                                                  dVar23 + 0.5,0);
                                    floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                    dVar21 = (double)CONCAT44(extraout_r1_10,uVar7);
                                    if ((2147483647.0 < dVar21) ||
                                       (dVar21 < -2147483648.0 != NAN(dVar21))) goto LAB_000187d0;
                                    uVar7 = (undefined4)(longlong)dVar21;
                                  }
                                  *param_1 = uVar7;
                                  if (param_2[1] == 0) {
                                    uVar7 = 0;
                                  }
                                  else {
                                    uVar7 = SUB84(((double)(longlong)(int)param_2[1] * 100000.0) /
                                                  dVar23 + 0.5,0);
                                    floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                    dVar21 = (double)CONCAT44(extraout_r1_11,uVar7);
                                    if ((2147483647.0 < dVar21) ||
                                       (dVar21 < -2147483648.0 != NAN(dVar21))) goto LAB_000187d0;
                                    uVar7 = (undefined4)(longlong)dVar21;
                                  }
                                  param_1[1] = uVar7;
                                  if (!SBORROW4(100000,*param_2)) {
                                    iVar3 = 100000 - *param_2;
                                    if (!SBORROW4(iVar3,param_2[1])) {
                                      iVar3 = iVar3 - param_2[1];
                                      if (iVar3 == 0) {
                                        uVar7 = 0;
                                      }
                                      else {
                                        uVar7 = SUB84(((double)(longlong)iVar3 * 100000.0) / dVar23
                                                      + 0.5,0);
                                        floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                        dVar21 = (double)CONCAT44(extraout_r1_12,uVar7);
                                        if ((2147483647.0 < dVar21) ||
                                           (dVar21 < -2147483648.0 != NAN(dVar21)))
                                        goto LAB_000187d0;
                                        uVar7 = (undefined4)(longlong)dVar21;
                                      }
                                      param_1[2] = uVar7;
                                      if (iVar9 == 0) goto LAB_000187d0;
                                      if (param_2[2] == 0) {
                                        uVar7 = 0;
                                      }
                                      else {
                                        uVar7 = SUB84(((double)(longlong)(int)param_2[2] * 100000.0)
                                                      / dVar22 + 0.5,0);
                                        floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                        dVar21 = (double)CONCAT44(extraout_r1_13,uVar7);
                                        if ((2147483647.0 < dVar21) ||
                                           (dVar21 < -2147483648.0 != NAN(dVar21)))
                                        goto LAB_000187d0;
                                        uVar7 = (undefined4)(longlong)dVar21;
                                      }
                                      param_1[3] = uVar7;
                                      if (param_2[3] == 0) {
                                        uVar7 = 0;
                                      }
                                      else {
                                        uVar7 = SUB84(((double)(longlong)(int)param_2[3] * 100000.0)
                                                      / dVar22 + 0.5,0);
                                        floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                        dVar21 = (double)CONCAT44(extraout_r1_14,uVar7);
                                        if ((2147483647.0 < dVar21) ||
                                           (dVar21 < -2147483648.0 != NAN(dVar21)))
                                        goto LAB_000187d0;
                                        uVar7 = (undefined4)(longlong)dVar21;
                                      }
                                      param_1[4] = uVar7;
                                      if (!SBORROW4(100000,param_2[2])) {
                                        iVar9 = 100000 - param_2[2];
                                        if (!SBORROW4(iVar9,param_2[3])) {
                                          iVar9 = iVar9 - param_2[3];
                                          if (iVar9 == 0) {
                                            uVar7 = 0;
                                          }
                                          else {
                                            uVar7 = SUB84(((double)(longlong)iVar9 * 100000.0) /
                                                          dVar22 + 0.5,0);
                                            floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                            dVar21 = (double)CONCAT44(extraout_r1_15,uVar7);
                                            if ((2147483647.0 < dVar21) ||
                                               (dVar21 < -2147483648.0 != NAN(dVar21)))
                                            goto LAB_000187d0;
                                            uVar7 = (undefined4)(longlong)dVar21;
                                          }
                                          param_1[5] = uVar7;
                                          if (param_2[4] == 0) {
                                            uVar7 = 0;
                                          }
                                          else {
                                            uVar7 = SUB84(((double)(longlong)iVar17 *
                                                          (double)(longlong)(int)param_2[4]) /
                                                          100000.0 + 0.5,0);
                                            floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                            dVar21 = (double)CONCAT44(extraout_r1_16,uVar7);
                                            if ((2147483647.0 < dVar21) ||
                                               (dVar21 < -2147483648.0 != NAN(dVar21)))
                                            goto LAB_000187d0;
                                            uVar7 = (undefined4)(longlong)dVar21;
                                          }
                                          param_1[6] = uVar7;
                                          if (param_2[5] == 0) {
                                            uVar7 = 0;
                                          }
                                          else {
                                            uVar7 = SUB84(((double)(longlong)iVar17 *
                                                          (double)(longlong)(int)param_2[5]) /
                                                          100000.0 + 0.5,0);
                                            floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                            dVar21 = (double)CONCAT44(extraout_r1_17,uVar7);
                                            if ((2147483647.0 < dVar21) ||
                                               (dVar21 < -2147483648.0 != NAN(dVar21)))
                                            goto LAB_000187d0;
                                            uVar7 = (undefined4)(longlong)dVar21;
                                          }
                                          param_1[7] = uVar7;
                                          if (!SBORROW4(100000,param_2[4])) {
                                            iVar9 = 100000 - param_2[4];
                                            if (!SBORROW4(iVar9,param_2[5])) {
                                              iVar9 = iVar9 - param_2[5];
                                              if (iVar9 == 0) {
                                                uVar7 = 0;
                                              }
                                              else {
                                                uVar7 = SUB84(((double)(longlong)iVar17 *
                                                              (double)(longlong)iVar9) / 100000.0 +
                                                              0.5,0);
                                                floor((double)CONCAT44(iVar4,in_stack_ffffff68));
                                                dVar21 = (double)CONCAT44(extraout_r1_18,uVar7);
                                                if ((2147483647.0 < dVar21) ||
                                                   (dVar21 < -2147483648.0 != NAN(dVar21)))
                                                goto LAB_000187d0;
                                                uVar7 = (undefined4)(longlong)dVar21;
                                              }
                                              param_1[8] = uVar7;
                                              iVar9 = FUN_0001b2e8(auStack_7c,param_1);
                                              if (iVar9 == 0) {
                                                FUN_00019270(param_2,auStack_7c,5);
                                              }
                                              goto LAB_000187d0;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                              goto LAB_000189d8;
                            }
                          }
                        }
                      }
                      goto LAB_000187d0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
LAB_000189d8:
                    // WARNING: Does not return
    pcVar1 = (code *)software_udf(0xfe,0x189d8);
    (*pcVar1)();
  }
LAB_000187d0:
  if (__stack_chk_guard - local_5c != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_5c);
  }
  return;
}



undefined4
FUN_00018a18(undefined4 param_1,int param_2,undefined4 *param_3,undefined4 *param_4,int param_5)

{
  ushort uVar1;
  int iVar2;
  ushort uVar3;
  undefined4 uVar4;
  undefined4 uVar5;
  undefined4 uVar6;
  undefined4 uVar7;
  
  uVar1 = *(ushort *)(param_2 + 0x4a);
  if ((uVar1 & 0x8000) == 0) {
    if ((param_5 < 2) && ((uVar1 & 2) != 0)) {
      iVar2 = FUN_00019270(param_3,(undefined4 *)(param_2 + 4),100);
      if (iVar2 == 0) {
        *(ushort *)(param_2 + 0x4a) = uVar1 | 0x8000;
        png_benign_error(param_1,"inconsistent chromaticities");
        goto LAB_00018aa2;
      }
      if (param_5 == 0) {
        return 1;
      }
    }
    uVar4 = param_3[1];
    uVar5 = param_3[2];
    uVar6 = param_3[3];
    *(undefined4 *)(param_2 + 4) = *param_3;
    *(undefined4 *)(param_2 + 8) = uVar4;
    *(undefined4 *)(param_2 + 0xc) = uVar5;
    *(undefined4 *)(param_2 + 0x10) = uVar6;
    uVar4 = param_3[5];
    uVar5 = param_3[6];
    uVar6 = param_3[7];
    *(undefined4 *)(param_2 + 0x14) = param_3[4];
    *(undefined4 *)(param_2 + 0x18) = uVar4;
    *(undefined4 *)(param_2 + 0x1c) = uVar5;
    *(undefined4 *)(param_2 + 0x20) = uVar6;
    uVar4 = param_4[1];
    uVar5 = param_4[2];
    uVar6 = param_4[3];
    *(undefined4 *)(param_2 + 0x24) = *param_4;
    *(undefined4 *)(param_2 + 0x28) = uVar4;
    *(undefined4 *)(param_2 + 0x2c) = uVar5;
    *(undefined4 *)(param_2 + 0x30) = uVar6;
    uVar4 = param_4[5];
    uVar5 = param_4[6];
    uVar6 = param_4[7];
    uVar7 = param_4[8];
    *(undefined4 *)(param_2 + 0x34) = param_4[4];
    *(undefined4 *)(param_2 + 0x38) = uVar4;
    *(undefined4 *)(param_2 + 0x3c) = uVar5;
    *(undefined4 *)(param_2 + 0x40) = uVar6;
    *(undefined4 *)(param_2 + 0x44) = uVar7;
    iVar2 = FUN_00019270(param_3,&DAT_00032938,1000);
    uVar3 = uVar1 | 0x42;
    if (iVar2 == 0) {
      uVar3 = uVar1 & 0xffbd | 2;
    }
    uVar4 = 2;
    *(ushort *)(param_2 + 0x4a) = uVar3;
  }
  else {
LAB_00018aa2:
    uVar4 = 0;
  }
  return uVar4;
}



void png_colorspace_set_endpoints(undefined4 param_1,int param_2,int *param_3,undefined4 param_4)

{
  code *pcVar1;
  int iVar2;
  undefined4 uVar3;
  int iVar4;
  int iVar5;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  undefined4 extraout_r1_02;
  undefined4 extraout_r1_03;
  undefined4 extraout_r1_04;
  undefined4 extraout_r1_05;
  undefined4 extraout_r1_06;
  undefined4 extraout_r1_07;
  int iVar6;
  int iVar7;
  int iVar8;
  int iVar9;
  int iVar10;
  int iVar11;
  int in_r12;
  double dVar12;
  undefined4 in_stack_ffffff50;
  undefined4 in_stack_ffffff54;
  undefined1 auStack_98 [32];
  int local_78;
  int local_74;
  int local_70;
  int local_6c;
  int local_68;
  int local_64;
  int local_60;
  int local_5c;
  int local_58;
  int local_50;
  int iStack_4c;
  int iStack_48;
  int iStack_44;
  int local_40;
  int iStack_3c;
  int iStack_38;
  int iStack_34;
  int iStack_30;
  int local_28;
  
  local_28 = __stack_chk_guard;
  local_78 = *param_3;
  iVar6 = param_3[1];
  iVar10 = param_3[2];
  iVar11 = param_3[3];
  iVar4 = param_3[4];
  iVar7 = param_3[5];
  iVar9 = param_3[6];
  local_5c = param_3[7];
  local_58 = param_3[8];
  local_74 = iVar6;
  local_70 = iVar10;
  local_6c = iVar11;
  local_68 = iVar4;
  local_64 = iVar7;
  local_60 = iVar9;
  if (-1 < iVar6) {
    iVar2 = local_58;
    if (-1 < iVar4) {
      iVar2 = local_5c;
    }
    if ((((-1 < iVar4 && -1 < iVar2) && (-1 < local_78)) && (-1 < iVar11)) &&
       ((-1 < iVar9 && (-1 < iVar10)))) {
      if (-1 < iVar7) {
        in_r12 = local_58;
      }
      if (-1 < iVar7 && -1 < in_r12) {
        if (SBORROW4(0x7fffffff,iVar6)) {
LAB_00018fd0:
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x18fd0);
          (*pcVar1)();
        }
        if (iVar11 <= 0x7fffffff - iVar6) {
          iVar5 = iVar6 + iVar4;
          if ((SBORROW4(iVar5,iVar6)) || (SBORROW4(0x7fffffff,iVar5))) goto LAB_00018fd0;
          if (iVar9 <= 0x7fffffff - iVar5) {
            iVar8 = iVar5 + iVar2;
            if (SBORROW4(iVar8,iVar5)) goto LAB_00018fd0;
            if (iVar8 != 0) {
              if (iVar8 != 100000) {
                if (local_78 == 0) {
                  local_78 = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)local_78 * 100000.0) / (double)(longlong)iVar8 +
                                0.5,0);
                  floor((double)CONCAT44(in_stack_ffffff54,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_78 = (int)(longlong)dVar12;
                }
                if (iVar6 == 0) {
                  local_74 = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)iVar6 * 100000.0) / (double)(longlong)iVar8 + 0.5
                                ,0);
                  floor((double)CONCAT44(in_stack_ffffff54,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_00,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_74 = (int)(longlong)dVar12;
                }
                if (iVar10 == 0) {
                  local_70 = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)iVar10 * 100000.0) / (double)(longlong)iVar8 +
                                0.5,0);
                  floor((double)CONCAT44(iVar9,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_01,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_70 = (int)(longlong)dVar12;
                }
                if (iVar11 == 0) {
                  local_6c = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)iVar11 * 100000.0) / (double)(longlong)iVar8 +
                                0.5,0);
                  floor((double)CONCAT44(iVar9,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_02,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_6c = (int)(longlong)dVar12;
                }
                iVar6 = iVar9;
                if (iVar4 == 0) {
                  local_68 = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)iVar4 * 100000.0) / (double)(longlong)iVar8 + 0.5
                                ,0);
                  floor((double)CONCAT44(iVar9,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_03,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_68 = (int)(longlong)dVar12;
                }
                if (iVar7 == 0) {
                  local_64 = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)iVar7 * 100000.0) / (double)(longlong)iVar8 + 0.5
                                ,0);
                  floor((double)CONCAT44(iVar6,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_04,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_64 = (int)(longlong)dVar12;
                }
                if (iVar9 == 0) {
                  local_60 = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)iVar9 * 100000.0) / (double)(longlong)iVar8 + 0.5
                                ,0);
                  floor((double)CONCAT44(iVar6,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_05,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_60 = (int)(longlong)dVar12;
                }
                if (iVar2 == 0) {
                  local_5c = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)iVar2 * 100000.0) / (double)(longlong)iVar8 + 0.5
                                ,0);
                  floor((double)CONCAT44(iVar6,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_06,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_5c = (int)(longlong)dVar12;
                }
                if (in_r12 == 0) {
                  local_58 = 0;
                }
                else {
                  uVar3 = SUB84(((double)(longlong)in_r12 * 100000.0) / (double)(longlong)iVar8 +
                                0.5,0);
                  floor((double)CONCAT44(iVar6,in_stack_ffffff50));
                  dVar12 = (double)CONCAT44(extraout_r1_07,uVar3);
                  if ((2147483647.0 < dVar12) || (dVar12 < -2147483648.0 != NAN(dVar12)))
                  goto LAB_00018fa0;
                  local_58 = (int)(longlong)dVar12;
                }
              }
              iVar4 = FUN_0001b2e8(auStack_98,&local_78);
              if (iVar4 == 0) {
                local_50 = local_78;
                iStack_4c = local_74;
                iStack_48 = local_70;
                iStack_44 = local_6c;
                local_40 = local_68;
                iStack_3c = local_64;
                iStack_38 = local_60;
                iStack_34 = local_5c;
                iStack_30 = local_58;
                iVar4 = FUN_00018040(&local_50,auStack_98);
              }
              if (iVar4 != 1) {
                if (iVar4 != 0) {
                  *(ushort *)(param_2 + 0x4a) = *(ushort *)(param_2 + 0x4a) | 0x8000;
                    // WARNING: Subroutine does not return
                  png_error(param_1,"internal error checking chromaticities");
                }
                uVar3 = FUN_00018a18(param_1,param_2,auStack_98,&local_78,param_4);
                goto LAB_00018fb8;
              }
            }
          }
        }
      }
    }
  }
LAB_00018fa0:
  *(ushort *)(param_2 + 0x4a) = *(ushort *)(param_2 + 0x4a) | 0x8000;
  png_benign_error(param_1,"invalid end points");
  uVar3 = 0;
LAB_00018fb8:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar3);
  }
  return;
}



undefined4 png_colorspace_set_sRGB(undefined4 param_1,undefined4 *param_2,uint param_3)

{
  ushort uVar1;
  uint uVar2;
  char *pcVar3;
  int iVar4;
  
  uVar1 = *(ushort *)((int)param_2 + 0x4a);
  uVar2 = (uint)uVar1;
  if ((uVar1 & 0x8000) != 0) {
    return 0;
  }
  if (param_3 < 4) {
    if ((uVar1 & 4) != 0) {
      if ((param_2[0x12] & 0xffff) != param_3) {
        pcVar3 = "inconsistent rendering intents";
        goto LAB_000190ca;
      }
      uVar2 = (uint)param_2[0x12] >> 0x10;
    }
    if ((uVar2 & 0x20) == 0) {
      if (((uVar2 & 2) != 0) && (iVar4 = FUN_00019270(&DAT_00032938,param_2 + 1,100), iVar4 == 0)) {
        png_chunk_report(param_1,"cHRM chunk does not match sRGB",2);
      }
      FUN_00017e60(param_1,param_2,0xb18f,2);
      *(short *)(param_2 + 0x12) = (short)param_3;
      param_2[1] = 64000;
      param_2[2] = 33000;
      param_2[3] = 30000;
      param_2[4] = 60000;
      param_2[5] = 15000;
      param_2[6] = 6000;
      param_2[7] = 0x7a26;
      param_2[8] = 0x8084;
      param_2[9] = 0xa117;
      param_2[10] = 0x5310;
      param_2[0xb] = 0x78d;
      param_2[0xc] = 0x8bae;
      param_2[0xd] = 0x1175d;
      param_2[0xe] = 0x2e8f;
      param_2[0xf] = 0x4680;
      param_2[0x10] = 0x1c33;
      param_2[0x11] = 0x1734d;
      *param_2 = 0xb18f;
      *(ushort *)((int)param_2 + 0x4a) = *(ushort *)((int)param_2 + 0x4a) | 0xe7;
      return 1;
    }
    png_benign_error(param_1,"duplicate sRGB information ignored");
  }
  else {
    pcVar3 = "invalid sRGB rendering intent";
LAB_000190ca:
    FUN_00019104(param_1,param_2,&DAT_00030738,param_3,pcVar3);
  }
  return 0;
}



void FUN_00019104(undefined4 param_1,int param_2,undefined4 param_3,uint param_4,undefined4 param_5)

{
  undefined1 uVar1;
  int iVar2;
  undefined4 uVar3;
  int iVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  bool bVar10;
  undefined1 auStack_e8 [6];
  undefined2 auStack_e2 [95];
  int local_24;
  
  local_24 = __stack_chk_guard;
  if (param_2 != 0) {
    *(ushort *)(param_2 + 0x4a) = *(ushort *)(param_2 + 0x4a) | 0x8000;
  }
  iVar2 = png_safecat(auStack_e8,0xc4,0,"profile \'");
  uVar3 = png_safecat(auStack_e8,iVar2 + 0x4f,iVar2,param_3);
  iVar4 = png_safecat(auStack_e8,0xc4,uVar3,&DAT_00030ace);
  uVar6 = 0xffffffd0;
  uVar8 = (param_4 >> 0x18 & 0xdf) - 0x41;
  uVar5 = param_4 >> 0x18;
  iVar2 = iVar4;
  if (0x19 < uVar8) {
    bVar10 = 0x1f < uVar5;
    if (uVar5 != 0x20) {
      uVar8 = (param_4 >> 0x18) - 0x30;
      bVar10 = 8 < uVar8;
    }
    if (bVar10 && (uVar5 != 0x20 && uVar8 != 9)) goto LAB_0001922a;
  }
  uVar8 = (param_4 << 8) >> 0x18;
  if (0x19 < (param_4 >> 0x10 & 0xdf) - 0x41) {
    bVar10 = 0x1f < uVar8;
    if (uVar8 != 0x20) {
      uVar6 = (param_4 >> 0x10 & 0xff) - 0x30;
      bVar10 = 8 < uVar6;
    }
    if (bVar10 && (uVar8 != 0x20 && uVar6 != 9)) goto LAB_0001922a;
  }
  uVar6 = (param_4 >> 8 & 0xdf) - 0x41;
  uVar7 = (param_4 << 0x10) >> 0x18;
  if (0x19 < uVar6) {
    bVar10 = 0x1f < uVar7;
    if (uVar7 != 0x20) {
      uVar6 = (param_4 >> 8 & 0xff) - 0x30;
      bVar10 = 8 < uVar6;
    }
    if (bVar10 && (uVar7 != 0x20 && uVar6 != 9)) goto LAB_0001922a;
  }
  uVar9 = param_4 & 0xff;
  uVar6 = (param_4 & 0xdf) - 0x41;
  if (0x19 < uVar6) {
    bVar10 = 0x1f < uVar9;
    if (uVar9 != 0x20) {
      uVar6 = (param_4 & 0xff) - 0x30;
      bVar10 = 8 < uVar6;
    }
    if (bVar10 && (uVar9 != 0x20 && uVar6 != 9)) goto LAB_0001922a;
  }
  auStack_e8[iVar4] = 0x27;
  if (0x5e < uVar5 - 0x20) {
    uVar5 = 0x3f;
  }
  auStack_e8[iVar4 + 1] = (char)uVar5;
  uVar1 = 0x3f;
  if (uVar8 - 0x20 < 0x5f) {
    uVar1 = (undefined1)(param_4 >> 0x10);
  }
  iVar2 = iVar4 + 8;
  auStack_e8[iVar4 + 2] = uVar1;
  uVar1 = 0x3f;
  if (uVar7 - 0x20 < 0x5f) {
    uVar1 = (undefined1)(param_4 >> 8);
  }
  auStack_e8[iVar4 + 3] = uVar1;
  uVar8 = 0x3f;
  if (uVar9 - 0x20 < 0x5f) {
    uVar8 = param_4;
  }
  auStack_e8[iVar4 + 4] = (char)uVar8;
  auStack_e8[iVar4 + 5] = 0x27;
  *(undefined2 *)(auStack_e8 + iVar4 + 6) = 0x203a;
LAB_0001922a:
  png_safecat(auStack_e8,0xc4,iVar2,param_5);
  uVar3 = 1;
  if (param_2 != 0) {
    uVar3 = 2;
  }
  png_chunk_report(param_1,auStack_e8,uVar3);
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



bool FUN_00019270(int *param_1,int *param_2,int param_3)

{
  code *pcVar1;
  int iVar2;
  
  iVar2 = param_2[6];
  if (!SBORROW4(iVar2,param_3)) {
    if (param_1[6] < iVar2 - param_3) {
      return false;
    }
    if (!SBORROW4(iVar2 + param_3,iVar2)) {
      if (iVar2 + param_3 < param_1[6]) {
        return false;
      }
      iVar2 = param_2[7];
      if (!SBORROW4(iVar2,param_3)) {
        if (param_1[7] < iVar2 - param_3) {
          return false;
        }
        if (!SBORROW4(iVar2 + param_3,iVar2)) {
          if (iVar2 + param_3 < param_1[7]) {
            return false;
          }
          iVar2 = *param_2;
          if (!SBORROW4(iVar2,param_3)) {
            if (*param_1 < iVar2 - param_3) {
              return false;
            }
            if (!SBORROW4(iVar2 + param_3,iVar2)) {
              if (iVar2 + param_3 < *param_1) {
                return false;
              }
              iVar2 = param_2[1];
              if (!SBORROW4(iVar2,param_3)) {
                if (param_1[1] < iVar2 - param_3) {
                  return false;
                }
                if (!SBORROW4(iVar2 + param_3,iVar2)) {
                  if (iVar2 + param_3 < param_1[1]) {
                    return false;
                  }
                  iVar2 = param_2[2];
                  if (!SBORROW4(iVar2,param_3)) {
                    if (param_1[2] < iVar2 - param_3) {
                      return false;
                    }
                    if (!SBORROW4(iVar2 + param_3,iVar2)) {
                      if (iVar2 + param_3 < param_1[2]) {
                        return false;
                      }
                      iVar2 = param_2[3];
                      if (!SBORROW4(iVar2,param_3)) {
                        if (param_1[3] < iVar2 - param_3) {
                          return false;
                        }
                        if (!SBORROW4(iVar2 + param_3,iVar2)) {
                          if (iVar2 + param_3 < param_1[3]) {
                            return false;
                          }
                          iVar2 = param_2[4];
                          if (!SBORROW4(iVar2,param_3)) {
                            if (param_1[4] < iVar2 - param_3) {
                              return false;
                            }
                            if (!SBORROW4(iVar2 + param_3,iVar2)) {
                              if (iVar2 + param_3 < param_1[4]) {
                                return false;
                              }
                              iVar2 = param_2[5];
                              if (!SBORROW4(iVar2,param_3)) {
                                if (param_1[5] < iVar2 - param_3) {
                                  return false;
                                }
                                if (!SBORROW4(param_3 + iVar2,iVar2)) {
                                  return param_1[5] <= param_3 + iVar2;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x193d8);
  (*pcVar1)();
}



undefined4
png_icc_check_length(undefined4 param_1,undefined4 param_2,undefined4 param_3,uint param_4)

{
  if (param_4 < 0x84) {
    FUN_00019104(param_1);
    return 0;
  }
  return 1;
}



undefined4
png_icc_check_header
          (undefined4 param_1,undefined4 param_2,undefined4 param_3,uint param_4,byte *param_5,
          uint param_6)

{
  char *pcVar1;
  int iVar2;
  uint uVar3;
  uint uVar4;
  
  uVar4 = (uint)param_5[3] |
          (uint)param_5[1] << 0x10 | (uint)*param_5 << 0x18 | (uint)param_5[2] << 8;
  if (uVar4 != param_4) {
    pcVar1 = "length does not match profile";
    param_4 = uVar4;
    goto LAB_0001948a;
  }
  if (((param_4 & 3) != 0) && (3 < param_5[8])) {
    pcVar1 = "invalid length";
    goto LAB_0001948a;
  }
  uVar4 = (uint)param_5[0x83] |
          (uint)param_5[0x81] << 0x10 | (uint)param_5[0x80] << 0x18 | (uint)param_5[0x82] << 8;
  if ((0x1555554a < uVar4) || (param_4 < uVar4 * 0xc + 0x84)) {
    pcVar1 = "tag count too large";
    param_4 = uVar4;
    goto LAB_0001948a;
  }
  param_4 = (uint)param_5[0x43] |
            (uint)param_5[0x41] << 0x10 | (uint)param_5[0x40] << 0x18 | (uint)param_5[0x42] << 8;
  if (0xfffe < param_4) {
    pcVar1 = "invalid rendering intent";
    goto LAB_0001948a;
  }
  if (3 < param_4) {
    FUN_00019104(param_1,0,param_3,param_4,"intent outside defined range");
  }
  param_4 = (uint)param_5[0x27] |
            (uint)param_5[0x25] << 0x10 | (uint)param_5[0x24] << 0x18 | (uint)param_5[0x26] << 8;
  if (param_4 != 0x61637370) {
    pcVar1 = "invalid signature";
    goto LAB_0001948a;
  }
  iVar2 = memcmp(param_5 + 0x44,&DAT_00032958,0xc);
  if (iVar2 != 0) {
    FUN_00019104(param_1,0,param_3,0,"PCS illuminant is not D50");
  }
  param_4 = (uint)param_5[0x11] << 0x10 | (uint)param_5[0x10] << 0x18 | (uint)param_5[0x12] << 8 |
            (uint)param_5[0x13];
  if (param_4 == 0x47524159) {
    if ((param_6 & 2) != 0) {
      param_4 = 0x47524159;
      pcVar1 = "Gray color space not permitted on RGB PNG";
      goto LAB_0001948a;
    }
  }
  else {
    if (param_4 != 0x52474220) {
      pcVar1 = "invalid ICC profile color space";
      goto LAB_0001948a;
    }
    if ((param_6 & 2) == 0) {
      param_4 = 0x52474220;
      pcVar1 = "RGB color space not permitted on grayscale PNG";
      goto LAB_0001948a;
    }
  }
  uVar4 = (uint)param_5[0xf] |
          (uint)param_5[0xd] << 0x10 | (uint)param_5[0xc] << 0x18 | (uint)param_5[0xe] << 8;
  if ((int)uVar4 < 0x6e6d636c) {
    if (uVar4 == 0x61627374) {
      param_4 = 0x61627374;
      pcVar1 = "invalid embedded Abstract ICC profile";
      goto LAB_0001948a;
    }
    if (uVar4 == 0x6c696e6b) {
      param_4 = 0x6c696e6b;
      pcVar1 = "unexpected DeviceLink ICC profile class";
      goto LAB_0001948a;
    }
    uVar3 = 0x6d6e7472;
LAB_000195fe:
    if (uVar4 != uVar3) {
      pcVar1 = "unrecognized ICC profile class";
LAB_00019618:
      FUN_00019104(param_1,0,param_3,uVar4,pcVar1);
    }
  }
  else {
    if ((int)uVar4 < 0x73636e72) {
      if (uVar4 != 0x6e6d636c) {
        uVar3 = 0x70727472;
        goto LAB_000195fe;
      }
      uVar4 = 0x6e6d636c;
      pcVar1 = "unexpected NamedColor ICC profile class";
      goto LAB_00019618;
    }
    if (uVar4 != 0x73636e72) {
      uVar3 = 0x73706163;
      goto LAB_000195fe;
    }
  }
  uVar4 = 0x4c616220;
  param_4 = (uint)param_5[0x17] |
            (uint)param_5[0x15] << 0x10 | (uint)param_5[0x14] << 0x18 | (uint)param_5[0x16] << 8;
  if (param_4 != 0x4c616220) {
    uVar4 = 0x58595a20;
  }
  if (param_4 == 0x4c616220 || param_4 == uVar4) {
    return 1;
  }
  pcVar1 = "unexpected ICC PCS encoding";
LAB_0001948a:
  FUN_00019104(param_1,param_2,param_3,param_4,pcVar1);
  return 0;
}



undefined4
png_icc_check_tag_table
          (undefined4 param_1,undefined4 param_2,undefined4 param_3,uint param_4,int param_5)

{
  byte bVar1;
  byte bVar2;
  byte bVar3;
  byte bVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  byte *pbVar9;
  uint uVar10;
  bool bVar11;
  bool bVar12;
  
  uVar6 = (uint)*(byte *)(param_5 + 0x81) << 0x10 | (uint)*(byte *)(param_5 + 0x80) << 0x18 |
          (uint)*(byte *)(param_5 + 0x82) << 8 | (uint)*(byte *)(param_5 + 0x83);
  if (uVar6 != 0) {
    pbVar9 = (byte *)(param_5 + 0x84);
    uVar7 = 0;
    do {
      bVar1 = pbVar9[9];
      uVar5 = (uint)pbVar9[7];
      bVar2 = pbVar9[8];
      uVar8 = (uint)pbVar9[1] << 0x10 | (uint)*pbVar9 << 0x18 | (uint)pbVar9[2] << 8 |
              (uint)pbVar9[3];
      bVar3 = pbVar9[10];
      uVar10 = (uint)pbVar9[5] << 0x10 | (uint)pbVar9[4] << 0x18 | (uint)pbVar9[6] << 8 | uVar5;
      bVar4 = pbVar9[0xb];
      if ((pbVar9[7] & 3) != 0) {
        uVar5 = FUN_00019104(param_1,0,param_3,uVar8,"ICC profile tag start not a multiple of 4");
      }
      bVar12 = param_4 <= uVar10;
      bVar11 = uVar10 == param_4;
      if (!bVar12 || bVar11) {
        uVar5 = (uint)bVar1 << 0x10;
      }
      if (!bVar12 || bVar11) {
        uVar5 = uVar5 | (uint)bVar2 << 0x18;
      }
      if (!bVar12 || bVar11) {
        uVar5 = uVar5 | (uint)bVar3 << 8 | (uint)bVar4;
        bVar12 = param_4 - uVar10 <= uVar5;
        bVar11 = uVar5 == param_4 - uVar10;
      }
      if (bVar12 && !bVar11) {
        FUN_00019104(param_1,param_2,param_3,uVar8,"ICC profile tag outside profile");
        return 0;
      }
      pbVar9 = pbVar9 + 0xc;
      uVar7 = uVar7 + 1;
    } while (uVar7 < uVar6);
  }
  return 1;
}



void png_icc_set_sRGB(int param_1,undefined4 param_2,byte *param_3,int param_4)

{
  uint uVar1;
  undefined4 uVar2;
  int iVar3;
  char *pcVar4;
  int *piVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  bool bVar9;
  
  if ((*(byte *)(param_1 + 0x2c4) & 0x30) != 0x30) {
    uVar8 = 0x10000;
    uVar6 = 0;
    uVar7 = 0;
    piVar5 = &DAT_00033164;
    do {
      if ((((((uint)param_3[0x55] << 0x10 | (uint)param_3[0x54] << 0x18 | (uint)param_3[0x56] << 8 |
             (uint)param_3[0x57]) == piVar5[3]) &&
           (((uint)param_3[0x5b] |
            (uint)param_3[0x59] << 0x10 | (uint)param_3[0x58] << 0x18 | (uint)param_3[0x5a] << 8) ==
            piVar5[4])) &&
          (((uint)param_3[0x5d] << 0x10 | (uint)param_3[0x5c] << 0x18 | (uint)param_3[0x5e] << 8 |
           (uint)param_3[0x5f]) == piVar5[5])) &&
         (((uint)param_3[0x61] << 0x10 | (uint)param_3[0x60] << 0x18 | (uint)param_3[0x62] << 8 |
          (uint)param_3[99]) == piVar5[6])) {
        if (uVar7 == 0) {
          uVar8 = (uint)param_3[0x41] << 0x10 | (uint)param_3[0x40] << 0x18 |
                  (uint)param_3[0x42] << 8 | (uint)param_3[0x43];
          uVar7 = (uint)param_3[1] << 0x10 | (uint)*param_3 << 0x18 | (uint)param_3[2] << 8 |
                  (uint)param_3[3];
        }
        uVar1 = piVar5[2];
        bVar9 = uVar7 == uVar1;
        if (bVar9) {
          uVar1 = (uint)*(ushort *)((int)piVar5 + 0x1e);
        }
        if (bVar9 && uVar8 == uVar1) {
          if (param_4 == 0) {
            uVar2 = adler32(0,0,0);
            param_4 = adler32(uVar2,param_3,uVar7);
          }
          if (param_4 != *piVar5) {
LAB_0002f5f4:
            png_chunk_report(param_1,"Not recognizing known sRGB profile that has been edited",0);
            return;
          }
          uVar2 = crc32(0,0,0);
          iVar3 = crc32(uVar2,param_3,uVar7);
          if (iVar3 != piVar5[1]) goto LAB_0002f5f4;
          if (uVar6 - 5 < 2) {
            uVar2 = 2;
            pcVar4 = "known incorrect sRGB profile";
          }
          else {
            if (2 < uVar6 - 4) goto LAB_0001991c;
            uVar2 = 0;
            pcVar4 = "out-of-date sRGB profile with no signature";
          }
          png_chunk_report(param_1,pcVar4,uVar2);
LAB_0001991c:
          png_colorspace_set_sRGB
                    (param_1,param_2,
                     (uint)param_3[0x41] << 0x10 | (uint)param_3[0x40] << 0x18 |
                     (uint)param_3[0x42] << 8 | (uint)param_3[0x43]);
          return;
        }
      }
      uVar6 = uVar6 + 1;
      piVar5 = piVar5 + 8;
    } while (uVar6 < 7);
  }
  return;
}



undefined4
png_colorspace_set_ICC
          (undefined4 param_1,int param_2,undefined4 param_3,uint param_4,undefined4 param_5,
          undefined4 param_6)

{
  int iVar1;
  
  if (-1 < *(short *)(param_2 + 0x4a)) {
    if (param_4 < 0x84) {
      FUN_00019104(param_1,param_2,param_3,param_4,"too short");
    }
    else {
      iVar1 = png_icc_check_header(param_1,param_2,param_3,param_4,param_5,param_6);
      if ((iVar1 != 0) &&
         (iVar1 = png_icc_check_tag_table(param_1,param_2,param_3,param_4,param_5), iVar1 != 0)) {
        png_icc_set_sRGB(param_1,param_2,param_5,0);
        return 1;
      }
    }
  }
  return 0;
}



void png_colorspace_set_rgb_coefficients(int param_1)

{
  code *pcVar1;
  uint uVar2;
  int iVar3;
  undefined4 uVar4;
  uint uVar5;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  uint uVar6;
  uint uVar7;
  int iVar8;
  undefined4 unaff_r4;
  undefined4 unaff_r5;
  uint uVar9;
  int iVar10;
  uint uVar11;
  int iVar12;
  int iVar13;
  bool bVar14;
  double dVar15;
  
  if ((*(char *)(param_1 + 0x2fd) != '\0') || ((*(byte *)(param_1 + 0x3c2) & 2) == 0)) {
    return;
  }
  iVar3 = *(int *)(param_1 + 0x3a0);
  iVar10 = *(int *)(param_1 + 0x3ac);
  iVar8 = iVar3 + iVar10;
  if (!SBORROW4(iVar8,iVar3)) {
    iVar13 = *(int *)(param_1 + 0x3b8);
    iVar12 = iVar8 + iVar13;
    if (!SBORROW4(iVar12,iVar8)) {
      bVar14 = iVar12 == 1;
      iVar8 = iVar12 + -1;
      if (iVar12 >= 1) {
        bVar14 = iVar3 == 0;
        iVar8 = iVar3;
      }
      if (iVar8 < 0 == (iVar12 < 1 && SBORROW4(iVar12,1))) {
        if (bVar14) {
          uVar9 = 0;
        }
        else {
          uVar4 = SUB84(((double)(longlong)iVar3 * 32768.0) / (double)(longlong)iVar12 + 0.5,0);
          floor((double)CONCAT44(unaff_r5,unaff_r4));
          dVar15 = (double)CONCAT44(extraout_r1,uVar4);
          if ((2147483647.0 < dVar15) || (dVar15 < -2147483648.0 != NAN(dVar15))) goto LAB_00019c06;
          uVar9 = (uint)(longlong)dVar15;
        }
        if ((-1 < iVar10) && (uVar9 < 0x8001)) {
          if (iVar10 == 0) {
            uVar11 = 0;
          }
          else {
            uVar4 = SUB84(((double)(longlong)iVar10 * 32768.0) / (double)(longlong)iVar12 + 0.5,0);
            floor((double)CONCAT44(unaff_r5,unaff_r4));
            dVar15 = (double)CONCAT44(extraout_r1_00,uVar4);
            if ((2147483647.0 < dVar15) || (dVar15 < -2147483648.0 != NAN(dVar15)))
            goto LAB_00019c06;
            uVar11 = (uint)(longlong)dVar15;
          }
          if ((-1 < iVar13) && (uVar11 < 0x8001)) {
            if (iVar13 == 0) {
              uVar5 = 0;
            }
            else {
              uVar4 = SUB84(((double)(longlong)iVar13 * 32768.0) / (double)(longlong)iVar12 + 0.5,0)
              ;
              floor((double)CONCAT44(unaff_r5,unaff_r4));
              dVar15 = (double)CONCAT44(extraout_r1_01,uVar4);
              if (((2147483647.0 < dVar15) || (dVar15 < -2147483648.0 != NAN(dVar15))) ||
                 (uVar5 = (uint)(longlong)dVar15, 0x8000 < uVar5)) goto LAB_00019c06;
            }
            iVar3 = uVar9 + uVar11;
            if ((SBORROW4(iVar3,uVar9)) || (iVar8 = iVar3 + uVar5, SBORROW4(iVar8,iVar3)))
            goto LAB_00019c04;
            if (iVar8 < 0x8002) {
              uVar6 = (uint)(iVar8 < 0x8000);
              if (0x8000 < iVar8) {
                uVar6 = 0xffffffff;
              }
              uVar7 = uVar11;
              if (uVar6 != 0) {
                uVar2 = uVar9;
                if ((int)uVar9 <= (int)uVar11) {
                  uVar2 = uVar5;
                }
                if ((int)uVar11 < (int)uVar2) {
                  if ((int)uVar11 <= (int)uVar9) {
                    uVar11 = uVar5;
                  }
                  if ((int)uVar9 < (int)uVar11) {
                    bVar14 = SBORROW4(uVar5 + uVar6,uVar5);
                    uVar5 = uVar5 + uVar6;
                    if (bVar14) goto LAB_00019c04;
                  }
                  else {
                    bVar14 = SBORROW4(uVar6 + uVar9,uVar9);
                    uVar9 = uVar6 + uVar9;
                    if (bVar14) goto LAB_00019c04;
                  }
                }
                else {
                  uVar7 = uVar6 + uVar11;
                  if (SBORROW4(uVar7,uVar11)) goto LAB_00019c04;
                }
              }
              iVar3 = uVar9 + uVar7;
              if ((!SBORROW4(iVar3,uVar9)) && (!SBORROW4(uVar5 + iVar3,iVar3))) {
                if (uVar5 + iVar3 == 0x8000) {
                  *(short *)(param_1 + 0x2fe) = (short)uVar9;
                  *(short *)(param_1 + 0x300) = (short)uVar7;
                  return;
                }
                    // WARNING: Subroutine does not return
                png_error(param_1,"internal error handling cHRM coefficients");
              }
              goto LAB_00019c04;
            }
          }
        }
      }
LAB_00019c06:
                    // WARNING: Subroutine does not return
      png_error(param_1,"internal error handling cHRM->XYZ");
    }
  }
LAB_00019c04:
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x19c04);
  (*pcVar1)();
}



undefined4 png_muldiv(undefined4 *param_1,int param_2,int param_3,int param_4)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r4;
  undefined4 in_lr;
  double dVar2;
  
  if (param_4 == 0) {
    return 0;
  }
  if ((param_2 == 0) || (param_3 == 0)) {
    *param_1 = 0;
  }
  else {
    uVar1 = SUB84(((double)(longlong)param_2 * (double)(longlong)param_3) /
                  (double)(longlong)param_4 + 0.5,0);
    floor((double)CONCAT44(in_lr,unaff_r4));
    dVar2 = (double)CONCAT44(extraout_r1,uVar1);
    if (2147483647.0 < dVar2) {
      return 0;
    }
    if (dVar2 < -2147483648.0 != NAN(dVar2)) {
      return 0;
    }
    *param_1 = (int)(longlong)dVar2;
  }
  return 1;
}



void png_check_IHDR(int param_1,uint param_2,uint param_3,int param_4,uint param_5,int param_6,
                   int param_7,int param_8)

{
  bool bVar1;
  bool bVar2;
  uint uVar3;
  uint uVar4;
  
  uVar4 = param_5 | 4;
  if ((param_4 < 9) || (param_5 != 3)) {
    bVar1 = *(uint *)(param_1 + 0x330) < param_3 ||
            ((int)param_3 < 1 ||
            ((int)param_2 < 0 ||
            (0x1ffffff8 < (param_2 + 7 & 0xfffffff8) ||
            (*(uint *)(param_1 + 0x32c) < param_2 || param_2 == 0))));
    bVar2 = 1 < param_4 - 1U || bVar1;
    if (param_4 == 4) {
      bVar2 = bVar1;
    }
    if (param_4 == 8) {
      bVar2 = bVar1;
    }
    if (param_4 == 0x10) {
      bVar2 = bVar1;
    }
    if (uVar4 == 5) {
      bVar2 = true;
    }
    if (6 < param_5) {
      bVar2 = true;
    }
    if ((param_4 < 8) && (param_5 == 4 || uVar4 == 6)) {
      bVar2 = true;
    }
  }
  else {
    bVar2 = true;
  }
  if (1 < param_6) {
    bVar2 = true;
  }
  if (param_7 != 0) {
    bVar2 = true;
  }
  if (param_8 != 0) {
    uVar3 = *(uint *)(param_1 + 0x130) & 0x1000;
    if (((param_8 != 0x40) || ((*(uint *)(param_1 + 0x304) & 4) == 0)) || (uVar4 != 6 || uVar3 != 0)
       ) {
      bVar2 = true;
    }
    if (uVar3 != 0) goto LAB_00019dbe;
  }
  if (!bVar2) {
    return;
  }
LAB_00019dbe:
                    // WARNING: Subroutine does not return
  png_error(param_1,"Invalid IHDR data");
}



uint png_check_fp_number(uint param_1,uint param_2,uint *param_3,uint *param_4)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  
  uVar3 = *param_3;
  for (uVar2 = *param_4; uVar2 < param_2; uVar2 = uVar2 + 1) {
    uVar1 = 4;
    switch(*(char *)(param_1 + uVar2)) {
    case '+':
      break;
    case ',':
    case '/':
    case ':':
    case ';':
    case '<':
    case '=':
    case '>':
    case '?':
    case '@':
    case 'A':
    case 'B':
    case 'C':
    case 'D':
      goto switchD_00019df0_caseD_2c;
    case '-':
      uVar1 = 0x84;
      break;
    case '.':
      uVar1 = 0x10;
      break;
    case '0':
      uVar1 = 8;
      break;
    case '1':
    case '2':
    case '3':
    case '4':
    case '5':
    case '6':
    case '7':
    case '8':
    case '9':
      uVar1 = 0x108;
      break;
    case 'E':
      goto switchD_00019df0_caseD_45;
    default:
      if (*(char *)(param_1 + uVar2) != 'e') goto switchD_00019df0_caseD_2c;
switchD_00019df0_caseD_45:
      uVar1 = 0x20;
    }
    uVar1 = uVar3 & 3 | uVar1 & 0x3c;
                    // WARNING: Could not find normalized switch variable to match jumptable
    switch(uVar1 - 4) {
    case 0:
      uVar3 = uVar1 - 4 | 0x40;
      break;
    case 1:
      param_1 = param_1 >> 0x19;
      break;
    case 2:
      uVar3 = uVar3 | 0x48;
    case 3:
      break;
    default:
      if ((uVar1 != 0x20 && uVar1 != 0x21) || ((uVar3 & 8) == 0)) goto switchD_00019df0_caseD_2c;
      uVar3 = uVar3 & 0x1c0 | 2;
    }
  }
switchD_00019df0_caseD_2c:
  *param_3 = uVar3;
  *param_4 = uVar2;
  return (uVar3 << 0x1c) >> 0x1f;
}



// WARNING: Type propagation algorithm not settling

void png_check_fp_string(undefined4 param_1,uint param_2)

{
  uint local_1c [3];
  
  local_1c[2] = __stack_chk_guard;
  local_1c[0] = 0;
  local_1c[1] = 0;
  png_check_fp_number(param_1,param_2,local_1c + 1,local_1c);
  if (__stack_chk_guard - local_1c[2] != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_1c[2]);
  }
  return;
}



void png_ascii_from_fp(undefined4 param_1,byte *param_2,uint param_3,undefined4 param_4,
                      double param_5,uint param_6)

{
  code *pcVar1;
  double *__iptr;
  undefined4 uVar2;
  byte *pbVar3;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  uint uVar4;
  uint uVar5;
  int iVar6;
  uint uVar7;
  byte *pbVar8;
  byte *pbVar9;
  int iVar10;
  int iVar11;
  int iVar12;
  int iVar13;
  int iVar14;
  bool bVar15;
  double dVar16;
  double dVar17;
  undefined4 in_stack_ffffff88;
  double local_70;
  uint local_64;
  byte abStack_5f [11];
  int local_54;
  
  local_54 = __stack_chk_guard;
  if (param_6 == 0) {
    param_6 = 0xf;
  }
  if (0x10 < param_6) {
    param_6 = 0x10;
  }
  if (param_3 < param_6 + 5) {
LAB_0001a3a4:
                    // WARNING: Subroutine does not return
    png_error(param_1,"ASCII conversion buffer too small");
  }
  pbVar8 = param_2;
  if ((int)((uint)(param_5 < 0.0) << 0x1f) < 0) {
    param_5 = -param_5;
    pbVar8 = param_2 + 1;
    *param_2 = 0x2d;
    param_3 = param_3 - 1;
  }
  if ((param_5 < 2.2250738585072014e-308 == NAN(param_5)) && (param_5 <= 1.7976931348623157e+308)) {
    frexp((double)CONCAT44(param_1,in_stack_ffffff88),SUB84(param_5,0));
    if ((int)((ulonglong)((longlong)(int)local_64 * 0x4d) >> 0x20) == (int)(local_64 * 0x4d) >> 0x1f
       ) {
      local_64 = (int)(local_64 * 0x4d) >> 8;
      dVar16 = (double)FUN_0001a3c8(local_64);
      if (dVar16 < 2.2250738585072014e-308 || (dVar16 < 2.2250738585072014e-308 || dVar16 < param_5)
         ) {
        do {
          uVar7 = local_64 + 1;
          if (SBORROW4(uVar7,local_64)) goto LAB_0001a2e4;
          dVar17 = (double)FUN_0001a3c8(uVar7);
        } while ((dVar17 <= 1.7976931348623157e+308) &&
                ((dVar16 = dVar17, local_64 = uVar7,
                 (int)((uint)(dVar17 < 2.2250738585072014e-308) << 0x1f) < 0 ||
                 ((int)((uint)(dVar17 < param_5) << 0x1f) < 0))));
      }
      param_5 = param_5 / dVar16;
      if (param_5 < 1.0 == NAN(param_5)) {
        do {
          uVar7 = local_64 + 1;
          if (SBORROW4(uVar7,local_64)) goto LAB_0001a2e4;
          param_5 = param_5 / 10.0;
          local_64 = uVar7;
        } while (param_5 < 1.0 == NAN(param_5));
      }
      iVar10 = 0;
      if (0xfffffffd < local_64) {
        iVar10 = -local_64;
        local_64 = 0;
      }
      iVar13 = 0;
      dVar16 = 0.0;
      iVar11 = iVar10;
      do {
        iVar12 = iVar11 + 1;
        if ((uint)(iVar12 + iVar13) < iVar10 + param_6) {
          __iptr = SUB84(param_5 * 10.0,0);
          modf((double)CONCAT44(param_1,in_stack_ffffff88),__iptr);
          param_5 = (double)CONCAT44(extraout_r1,__iptr);
LAB_0001a146:
          pbVar3 = pbVar8;
          iVar14 = iVar13;
          if (local_70 != 0.0) {
LAB_0001a160:
            iVar13 = iVar11;
            if (iVar11 == 0) {
              iVar11 = 0;
            }
            else {
              do {
                pbVar8 = pbVar3;
                if (local_64 != 0xffffffff) {
                  if (local_64 == 0) {
                    pbVar8 = pbVar3 + 1;
                    *pbVar3 = 0x2e;
                    param_3 = param_3 - 1;
                  }
                  if (SBORROW4(local_64,1)) goto LAB_0001a2e4;
                  local_64 = local_64 - 1;
                }
                pbVar3 = pbVar8 + 1;
                *pbVar8 = 0x30;
                iVar13 = iVar13 + -1;
              } while (iVar13 != 0);
            }
            goto LAB_0001a248;
          }
          if (iVar13 == 0) {
            iVar10 = iVar10 + 1;
          }
        }
        else {
          uVar2 = SUB84(param_5 * 10.0 + 0.5,0);
          floor((double)CONCAT44(param_1,in_stack_ffffff88));
          local_70 = (double)CONCAT44(extraout_r1_00,uVar2);
          param_5 = dVar16;
          if (local_70 == 9.0 || local_70 < 9.0 != NAN(local_70)) goto LAB_0001a146;
          pbVar3 = pbVar8;
          if (iVar11 != 0) {
            iVar11 = iVar11 + -1;
            local_70 = 1.0;
            iVar14 = iVar13;
            if (iVar13 == 0) {
              iVar10 = iVar10 + -1;
            }
            goto LAB_0001a160;
          }
          uVar7 = local_64;
          if (iVar13 == 0) {
            iVar14 = 0;
          }
          else {
            do {
              pbVar3 = pbVar8 + -1;
              uVar5 = (uint)*pbVar3;
              if (uVar7 == 0xffffffff) {
                if (uVar5 == 0x2e) {
                  pbVar3 = pbVar8 + -2;
                  uVar5 = (uint)*pbVar3;
                  param_3 = param_3 + 1;
                  uVar4 = 1;
                  local_64 = 1;
                }
                else {
                  uVar4 = 0xffffffff;
                }
              }
              else {
                uVar4 = uVar7 + 1;
                local_64 = uVar4;
                if (SBORROW4(uVar4,uVar7)) goto LAB_0001a2e4;
              }
              iVar6 = uVar5 - 0x2f;
              iVar14 = iVar13 + -1;
              local_70 = (double)(longlong)iVar6;
              pbVar8 = pbVar3;
            } while ((9 < iVar6) && (bVar15 = iVar13 != 1, iVar13 = iVar14, uVar7 = uVar4, bVar15));
            iVar13 = iVar14;
            if (iVar6 < 10) goto LAB_0001a146;
          }
          if (local_64 == 0xffffffff) {
            pbVar3 = pbVar3 + -1;
            if (*pbVar3 == 0x2e) {
              local_64 = 1;
              param_3 = param_3 + 1;
            }
          }
          else {
            bVar15 = SBORROW4(local_64 + 1,local_64);
            local_64 = local_64 + 1;
            if (bVar15) goto LAB_0001a2e4;
          }
          iVar11 = 0;
          local_70 = 1.0;
LAB_0001a248:
          pbVar9 = pbVar3;
          if (local_64 != 0xffffffff) {
            if (local_64 == 0) {
              pbVar9 = pbVar3 + 1;
              *pbVar3 = 0x2e;
              param_3 = param_3 - 1;
            }
            if (SBORROW4(local_64,1)) goto LAB_0001a2e4;
            local_64 = local_64 - 1;
          }
          iVar13 = (int)(longlong)local_70 + 0x30;
          if (SBORROW4(iVar13,(int)(longlong)local_70)) goto LAB_0001a2e4;
          pbVar8 = pbVar9 + 1;
          *pbVar9 = (byte)iVar13;
          iVar13 = (iVar14 + 1) - iVar10;
          iVar10 = 0;
          iVar13 = iVar13 + iVar11;
          iVar12 = 0;
        }
      } while ((param_5 != 2.2250738585072014e-308 &&
                param_5 < 2.2250738585072014e-308 == NAN(param_5)) &&
              (iVar11 = iVar12, (uint)(iVar13 + iVar12) < iVar10 + param_6));
      if (3 < local_64 + 1) {
        pbVar3 = pbVar8 + 1;
        *pbVar8 = 0x45;
        if ((int)local_64 < 0) {
          *pbVar3 = 0x2d;
          local_64 = -local_64;
          pbVar3 = pbVar8 + 2;
          iVar10 = -2;
        }
        else {
          iVar10 = -1;
        }
        uVar7 = 0;
        if (local_64 != 0) {
          do {
            abStack_5f[uVar7 + 1] = (char)local_64 + (char)(local_64 / 10) * -10 | 0x30;
            uVar7 = uVar7 + 1;
            bVar15 = 9 < local_64;
            local_64 = local_64 / 10;
          } while (bVar15);
        }
        if ((param_3 - iVar13) + iVar10 <= uVar7) goto LAB_0001a3a4;
        uVar5 = uVar7;
        pbVar8 = pbVar3;
        if (uVar7 != 0) {
          do {
            uVar4 = uVar5 - 1;
            *pbVar8 = abStack_5f[uVar5];
            uVar5 = uVar4;
            pbVar8 = pbVar8 + 1;
          } while (uVar4 != 0);
          pbVar3 = pbVar3 + uVar7;
        }
        *pbVar3 = 0;
        goto LAB_0001a384;
      }
      while (!SBORROW4(local_64,1)) {
        local_64 = local_64 - 1;
        if ((int)local_64 < 0) {
          *pbVar8 = 0;
          goto LAB_0001a384;
        }
        *pbVar8 = 0x30;
        pbVar8 = pbVar8 + 1;
      }
    }
LAB_0001a2e4:
                    // WARNING: Does not return
    pcVar1 = (code *)software_udf(0xfe,0x1a2e4);
    (*pcVar1)();
  }
  if (param_5 < 2.2250738585072014e-308 == NAN(param_5)) {
    pbVar8[0] = 0x69;
    pbVar8[1] = 0x6e;
    pbVar8[2] = 0x66;
    pbVar8[3] = 0;
  }
  else {
    pbVar8[0] = 0x30;
    pbVar8[1] = 0;
  }
LAB_0001a384:
  if (__stack_chk_guard == local_54) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Removing unreachable block (ram,0x0001a42a)

double FUN_0001a3c8(uint param_1)

{
  bool bVar1;
  double dVar2;
  double dVar3;
  double dVar4;
  
  if ((int)param_1 < 0) {
    if ((int)param_1 < -0x133) {
      return 0.0;
    }
    param_1 = -param_1;
    bVar1 = true;
  }
  else {
    bVar1 = false;
  }
  dVar3 = 1.0;
  if (0 < (int)param_1) {
    dVar4 = 10.0;
    do {
      dVar2 = dVar3 * dVar4;
      if ((param_1 & 1) == 0) {
        dVar2 = dVar3;
      }
      dVar3 = dVar2;
      param_1 = (int)param_1 >> 1;
      dVar4 = dVar4 * dVar4;
    } while (0 < (int)param_1);
    dVar4 = 1.0 / dVar3;
    if (!bVar1) {
      dVar4 = dVar3;
    }
    return dVar4;
  }
  return dVar3;
}



// WARNING: Removing unreachable block (ram,0x0001a550)

void png_ascii_from_fixed(undefined4 param_1,char *param_2,uint param_3,uint param_4)

{
  bool bVar1;
  char *pcVar2;
  char *pcVar3;
  int iVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  char acStack_2b [11];
  int local_20;
  
  local_20 = __stack_chk_guard;
  if (param_3 < 0xd) {
LAB_0001a548:
                    // WARNING: Subroutine does not return
    png_error(param_1,"ASCII conversion buffer too small");
  }
  uVar8 = param_4;
  if (0x7fffffff < param_4) {
    *param_2 = '-';
    uVar8 = -param_4;
    if (0x7fffffff < uVar8 && param_4 != 0x80000000) goto LAB_0001a548;
    param_2 = param_2 + 1;
  }
  if (uVar8 != 0) {
    uVar9 = 0x10;
    uVar6 = 0;
    do {
      uVar5 = uVar6;
      acStack_2b[uVar5 + 1] = (char)(uVar8 % 10) + '0';
      uVar6 = uVar5 + 1;
      uVar7 = uVar9;
      if (uVar8 % 10 != 0) {
        uVar7 = uVar6;
      }
      if (uVar9 == 0x10) {
        uVar9 = uVar7;
      }
      bVar1 = 9 < uVar8;
      uVar8 = uVar8 / 10;
    } while (bVar1);
    if (uVar6 != 0) {
      pcVar2 = param_2;
      uVar8 = uVar6;
      if (5 < uVar6) {
        do {
          uVar7 = uVar8 - 1;
          *pcVar2 = acStack_2b[uVar8];
          pcVar2 = pcVar2 + 1;
          uVar8 = uVar7;
        } while (5 < uVar7);
        uVar8 = 5;
        pcVar2 = param_2 + (uVar5 - 4);
      }
      pcVar3 = pcVar2;
      if (uVar9 < 6) {
        pcVar3 = pcVar2 + 1;
        *pcVar2 = '.';
        if (uVar8 < 5) {
          iVar4 = 1;
          if (5 < uVar6) {
            iVar4 = uVar5 - 3;
          }
          if (4 < uVar6) {
            uVar6 = 5;
          }
          __aeabi_memset(param_2 + iVar4,5 - uVar6,0x30);
          pcVar3 = pcVar2 + (6 - uVar8);
        }
        for (; uVar9 <= uVar8; uVar8 = uVar8 - 1) {
          *pcVar3 = acStack_2b[uVar8];
          pcVar3 = pcVar3 + 1;
        }
      }
      goto LAB_0001a52c;
    }
  }
  *param_2 = '0';
  pcVar3 = param_2 + 1;
LAB_0001a52c:
  *pcVar3 = '\0';
  if (__stack_chk_guard == local_20) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Control flow encountered bad instruction data

void png_fixed(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
              undefined4 param_5)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r4;
  undefined4 in_lr;
  double dVar2;
  
  uVar1 = SUB84((double)CONCAT44(param_4,param_3) * 100000.0 + 0.5,0);
  floor((double)CONCAT44(in_lr,unaff_r4));
  dVar2 = (double)CONCAT44(extraout_r1,uVar1);
  if ((dVar2 == 2147483647.0 || dVar2 < 2147483647.0 != NAN(dVar2)) &&
     (-1 < (int)((uint)(dVar2 < -2147483648.0) << 0x1f))) {
    return;
  }
  png_fixed_error(param_1,param_5);
                    // WARNING: Bad instruction - Truncating control flow here
  halt_baddata();
}



undefined4 png_muldiv_warn(undefined4 param_1,int param_2,int param_3,int param_4)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double dVar2;
  
  uVar1 = 0;
  if (((param_4 != 0) && (param_2 != 0)) && (param_3 != 0)) {
    uVar1 = SUB84(((double)(longlong)param_2 * (double)(longlong)param_3) /
                  (double)(longlong)param_4 + 0.5,0);
    floor((double)CONCAT44(in_lr,unaff_r7));
    dVar2 = (double)CONCAT44(extraout_r1,uVar1);
    uVar1 = (undefined4)(longlong)dVar2;
    if (2147483647.0 < dVar2) {
      uVar1 = 0;
    }
    if (dVar2 < -2147483648.0 != NAN(dVar2)) {
      uVar1 = 0;
    }
  }
  return uVar1;
}



undefined4 png_reciprocal(int param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double dVar2;
  
  uVar1 = SUB84(10000000000.0 / (double)(longlong)param_1 + 0.5,0);
  floor((double)CONCAT44(in_lr,unaff_r7));
  dVar2 = (double)CONCAT44(extraout_r1,uVar1);
  uVar1 = (undefined4)(longlong)dVar2;
  if (dVar2 < -2147483648.0 != NAN(dVar2)) {
    uVar1 = 0;
  }
  if (2147483647.0 < dVar2) {
    uVar1 = 0;
  }
  return uVar1;
}



bool png_gamma_significant(int param_1)

{
  return 10000 < param_1 - 95000U;
}



undefined4 png_reciprocal2(int param_1,int param_2)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double dVar2;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = SUB84((1e+15 / (double)(longlong)param_1) / (double)(longlong)param_2 + 0.5,0);
    floor((double)CONCAT44(in_lr,unaff_r7));
    dVar2 = (double)CONCAT44(extraout_r1,uVar1);
    if ((dVar2 < -2147483648.0 == NAN(dVar2)) && (dVar2 <= 2147483647.0)) {
      return (int)(longlong)dVar2;
    }
  }
  return 0;
}



uint png_gamma_8bit_correct(uint param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double unaff_d8;
  
  if (param_1 - 1 < 0xfe) {
    uVar1 = SUB84((double)(longlong)(int)param_1 / 255.0,0);
    pow(unaff_d8,(double)CONCAT44(in_lr,unaff_r7));
    uVar1 = SUB84((double)CONCAT44(extraout_r1,uVar1) * 255.0 + 0.5,0);
    floor(unaff_d8);
    param_1 = (uint)(0.0 < (double)CONCAT44(extraout_r1_00,uVar1)) *
              (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar1);
  }
  return param_1 & 0xff;
}



uint png_gamma_16bit_correct(uint param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double unaff_d8;
  
  if (param_1 - 1 < 0xfffe) {
    uVar1 = SUB84((double)(longlong)(int)param_1 / 65535.0,0);
    pow(unaff_d8,(double)CONCAT44(in_lr,unaff_r7));
    uVar1 = SUB84((double)CONCAT44(extraout_r1,uVar1) * 65535.0 + 0.5,0);
    floor(unaff_d8);
    param_1 = (uint)(0.0 < (double)CONCAT44(extraout_r1_00,uVar1)) *
              (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar1);
  }
  return param_1 & 0xffff;
}



uint png_gamma_correct(int param_1,uint param_2)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  undefined4 extraout_r1_02;
  undefined4 unaff_r7;
  undefined4 in_lr;
  double unaff_d8;
  
  if (*(char *)(param_1 + 0x20c) == '\b') {
    if (param_2 - 1 < 0xfe) {
      uVar1 = SUB84((double)(longlong)(int)param_2 / 255.0,0);
      pow(unaff_d8,(double)CONCAT44(in_lr,unaff_r7));
      uVar1 = SUB84((double)CONCAT44(extraout_r1,uVar1) * 255.0 + 0.5,0);
      floor(unaff_d8);
      param_2 = (uint)(0.0 < (double)CONCAT44(extraout_r1_00,uVar1)) *
                (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar1);
    }
    param_2 = param_2 & 0xff;
  }
  else if (param_2 - 1 < 0xfffe) {
    uVar1 = SUB84((double)(longlong)(int)param_2 / 65535.0,0);
    pow(unaff_d8,(double)CONCAT44(in_lr,unaff_r7));
    uVar1 = SUB84((double)CONCAT44(extraout_r1_01,uVar1) * 65535.0 + 0.5,0);
    floor(unaff_d8);
    param_2 = (uint)(0.0 < (double)CONCAT44(extraout_r1_02,uVar1)) *
              (int)(longlong)(double)CONCAT44(extraout_r1_02,uVar1);
  }
  return param_2 & 0xffff;
}



void png_destroy_gamma_table(int param_1)

{
  code *pcVar1;
  undefined4 *puVar2;
  uint uVar3;
  int iVar4;
  bool bVar5;
  
  png_free(param_1,*(undefined4 *)(param_1 + 0x244));
  *(undefined4 *)(param_1 + 0x244) = 0;
  puVar2 = *(undefined4 **)(param_1 + 0x248);
  if (puVar2 != (undefined4 *)0x0) {
    if (SBORROW4(8,*(int *)(param_1 + 0x23c))) goto LAB_0001aa80;
    uVar3 = 8 - *(int *)(param_1 + 0x23c);
    if (uVar3 != 0x1f) {
      png_free(param_1,*puVar2);
      iVar4 = 1;
      do {
        if (1 << (uVar3 & 0xff) <= iVar4) {
          puVar2 = *(undefined4 **)(param_1 + 0x248);
          goto LAB_0001a9a0;
        }
        png_free(param_1,*(undefined4 *)(*(int *)(param_1 + 0x248) + iVar4 * 4));
        bVar5 = SBORROW4(iVar4 + 1,iVar4);
        iVar4 = iVar4 + 1;
      } while (!bVar5);
      goto LAB_0001aa80;
    }
LAB_0001a9a0:
    png_free(param_1,puVar2);
    *(undefined4 *)(param_1 + 0x248) = 0;
  }
  png_free(param_1,*(undefined4 *)(param_1 + 0x24c));
  *(undefined4 *)(param_1 + 0x24c) = 0;
  png_free(param_1,*(undefined4 *)(param_1 + 0x250));
  *(undefined4 *)(param_1 + 0x250) = 0;
  puVar2 = *(undefined4 **)(param_1 + 0x254);
  if (puVar2 != (undefined4 *)0x0) {
    if (SBORROW4(8,*(int *)(param_1 + 0x23c))) goto LAB_0001aa80;
    uVar3 = 8 - *(int *)(param_1 + 0x23c);
    if (uVar3 != 0x1f) {
      png_free(param_1,*puVar2);
      iVar4 = 1;
      do {
        if (1 << (uVar3 & 0xff) <= iVar4) {
          puVar2 = *(undefined4 **)(param_1 + 0x254);
          goto LAB_0001aa22;
        }
        png_free(param_1,*(undefined4 *)(*(int *)(param_1 + 0x254) + iVar4 * 4));
        bVar5 = SBORROW4(iVar4 + 1,iVar4);
        iVar4 = iVar4 + 1;
      } while (!bVar5);
      goto LAB_0001aa80;
    }
LAB_0001aa22:
    png_free(param_1,puVar2);
    *(undefined4 *)(param_1 + 0x254) = 0;
  }
  puVar2 = *(undefined4 **)(param_1 + 600);
  if (puVar2 == (undefined4 *)0x0) {
    return;
  }
  if (!SBORROW4(8,*(int *)(param_1 + 0x23c))) {
    uVar3 = 8 - *(int *)(param_1 + 0x23c);
    if (uVar3 == 0x1f) {
LAB_0001aa86:
      png_free(param_1,puVar2);
      *(undefined4 *)(param_1 + 600) = 0;
      return;
    }
    png_free(param_1,*puVar2);
    iVar4 = 1;
    do {
      if (1 << (uVar3 & 0xff) <= iVar4) {
        puVar2 = *(undefined4 **)(param_1 + 600);
        goto LAB_0001aa86;
      }
      png_free(param_1,*(undefined4 *)(*(int *)(param_1 + 600) + iVar4 * 4));
      bVar5 = SBORROW4(iVar4 + 1,iVar4);
      iVar4 = iVar4 + 1;
    } while (!bVar5);
  }
LAB_0001aa80:
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x1aa80);
  (*pcVar1)();
}



void png_build_gamma_table(int param_1,int param_2)

{
  byte bVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  uint uVar5;
  undefined4 extraout_r1;
  uint uVar6;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  undefined4 extraout_r1_02;
  undefined4 extraout_r1_03;
  undefined4 extraout_r1_04;
  undefined4 extraout_r1_05;
  undefined4 extraout_r1_06;
  uint uVar7;
  undefined4 uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  int iVar12;
  double dVar13;
  uint in_stack_ffffffa8;
  uint in_stack_ffffffac;
  
  if ((*(int *)(param_1 + 0x244) != 0) || (*(int *)(param_1 + 0x248) != 0)) {
    png_destroy_gamma_table(param_1);
  }
  if (param_2 < 9) {
    if (*(int *)(param_1 + 0x240) < 1) {
      uVar8 = 100000;
    }
    else {
      if (*(int *)(param_1 + 0x378) != 0) {
        uVar8 = SUB84((1e+15 / (double)(longlong)*(int *)(param_1 + 0x378)) /
                      (double)(longlong)*(int *)(param_1 + 0x240) + 0.5,0);
        floor((double)CONCAT44(in_stack_ffffffac,in_stack_ffffffa8));
        dVar13 = (double)CONCAT44(extraout_r1,uVar8);
        uVar8 = (undefined4)(longlong)dVar13;
        if ((dVar13 < -2147483648.0 == NAN(dVar13)) && (dVar13 <= 2147483647.0)) goto LAB_0001ac16;
      }
      uVar8 = 0;
    }
LAB_0001ac16:
    FUN_0001afb8(param_1,param_1 + 0x244,uVar8);
    if ((*(uint *)(param_1 + 0x138) & 0x600080) == 0) {
      return;
    }
    uVar8 = SUB84(10000000000.0 / (double)(longlong)*(int *)(param_1 + 0x378) + 0.5,0);
    floor((double)CONCAT44(in_stack_ffffffac,in_stack_ffffffa8));
    dVar13 = (double)CONCAT44(extraout_r1_00,uVar8);
    uVar8 = (undefined4)(longlong)dVar13;
    if (dVar13 < -2147483648.0 != NAN(dVar13)) {
      uVar8 = 0;
    }
    if (2147483647.0 < dVar13) {
      uVar8 = 0;
    }
    FUN_0001afb8(param_1,param_1 + 0x250,uVar8);
    if (*(int *)(param_1 + 0x240) < 1) {
      uVar8 = *(undefined4 *)(param_1 + 0x378);
    }
    else {
      uVar8 = SUB84(10000000000.0 / (double)(longlong)*(int *)(param_1 + 0x240) + 0.5,0);
      floor((double)CONCAT44(in_stack_ffffffac,in_stack_ffffffa8));
      dVar13 = (double)CONCAT44(extraout_r1_01,uVar8);
      uVar8 = (undefined4)(longlong)dVar13;
      if (dVar13 < -2147483648.0 != NAN(dVar13)) {
        uVar8 = 0;
      }
      if (2147483647.0 < dVar13) {
        uVar8 = 0;
      }
    }
    FUN_0001afb8(param_1,param_1 + 0x24c,uVar8);
    return;
  }
  if ((*(byte *)(param_1 + 0x20b) & 2) == 0) {
    uVar2 = (uint)*(byte *)(param_1 + 0x25f);
  }
  else {
    uVar6 = *(uint *)(param_1 + 0x25c);
    uVar2 = uVar6;
    if ((uVar6 & 0xff) < (uVar6 & 0xff00) >> 8) {
      uVar2 = (uVar6 & 0xff00) >> 8;
    }
    if ((uVar2 & 0xff) < (uVar6 << 8) >> 0x18) {
      uVar2 = uVar6 >> 0x10;
    }
  }
  uVar6 = 0;
  if ((uVar2 - 1 & 0xff) < 0xf) {
    uVar6 = 0x10 - uVar2;
  }
  uVar2 = uVar6;
  if ((uVar6 & 0xff) < 5) {
    uVar2 = 5;
  }
  uVar7 = *(uint *)(param_1 + 0x138) & 0x4000400;
  if (uVar7 == 0) {
    uVar2 = uVar6;
  }
  bVar1 = (byte)uVar2;
  if (8 < (uVar2 & 0xff)) {
    bVar1 = 8;
  }
  uVar2 = (uint)bVar1;
  *(uint *)(param_1 + 0x23c) = uVar2;
  iVar3 = *(int *)(param_1 + 0x240);
  if (uVar7 != 0) {
    if (0 < iVar3) {
      floor((double)CONCAT44(in_stack_ffffffac,in_stack_ffffffa8));
    }
    uVar6 = 8 - uVar2;
    in_stack_ffffffa8 = 1 << (uVar6 & 0xff);
    iVar3 = png_calloc(param_1,in_stack_ffffffa8 << 2);
    uVar7 = 0;
    *(int *)(param_1 + 0x248) = iVar3;
    do {
      uVar8 = png_malloc(param_1,0x200);
      *(undefined4 *)(iVar3 + uVar7 * 4) = uVar8;
      uVar7 = uVar7 + 1;
    } while (uVar7 < in_stack_ffffffa8);
    uVar10 = 0xff >> uVar2;
    iVar12 = 0;
    uVar7 = 0;
    iVar4 = (1 << (0x10 - uVar2 & 0xff)) + -1;
    do {
      uVar8 = SUB84((double)(longlong)(iVar12 * 0x101 + 0x80) / 65535.0,0);
      pow((double)CONCAT44(uVar2,in_stack_ffffffa8),(double)CONCAT44(iVar4,param_1));
      uVar8 = SUB84((double)CONCAT44(extraout_r1_03,uVar8) * 65535.0 + 0.5,0);
      floor((double)CONCAT44(uVar2,in_stack_ffffffa8));
      uVar5 = (iVar4 * (uint)(0.0 < (double)CONCAT44(extraout_r1_04,uVar8)) *
                       (int)(longlong)(double)CONCAT44(extraout_r1_04,uVar8) + 0x8000) / 0xffff + 1;
      uVar11 = uVar7;
      if (uVar7 < uVar5) {
        do {
          uVar7 = uVar11 & uVar10;
          uVar9 = uVar11 >> (uVar6 & 0xff);
          uVar11 = uVar11 + 1;
          *(short *)(*(int *)(iVar3 + uVar7 * 4) + uVar9 * 2) = (short)(iVar12 * 0x101);
          uVar7 = uVar5;
        } while (uVar5 != uVar11);
      }
      iVar12 = iVar12 + 1;
    } while (iVar12 != 0xff);
    in_stack_ffffffac = uVar2;
    if (uVar7 < in_stack_ffffffa8 << 8) {
      do {
        uVar11 = uVar7 & uVar10;
        uVar5 = uVar7 >> (uVar6 & 0xff);
        uVar7 = uVar7 + 1;
        *(undefined2 *)(*(int *)(iVar3 + uVar11 * 4) + uVar5 * 2) = 0xffff;
      } while (in_stack_ffffffa8 * 0x100 - uVar7 != 0);
    }
    goto LAB_0001aea2;
  }
  if (iVar3 < 1) {
    uVar8 = 100000;
  }
  else {
    if (*(int *)(param_1 + 0x378) != 0) {
      uVar8 = SUB84((1e+15 / (double)(longlong)*(int *)(param_1 + 0x378)) / (double)(longlong)iVar3
                    + 0.5,0);
      floor((double)CONCAT44(in_stack_ffffffac,in_stack_ffffffa8));
      dVar13 = (double)CONCAT44(extraout_r1_02,uVar8);
      uVar8 = (undefined4)(longlong)dVar13;
      if ((dVar13 < -2147483648.0 == NAN(dVar13)) && (dVar13 <= 2147483647.0)) goto LAB_0001ae98;
    }
    uVar8 = 0;
  }
LAB_0001ae98:
  FUN_0001b080(param_1,param_1 + 0x248,uVar2,uVar8);
LAB_0001aea2:
  if ((*(uint *)(param_1 + 0x138) & 0x600080) == 0) {
    return;
  }
  uVar8 = SUB84(10000000000.0 / (double)(longlong)*(int *)(param_1 + 0x378) + 0.5,0);
  floor((double)CONCAT44(in_stack_ffffffac,in_stack_ffffffa8));
  dVar13 = (double)CONCAT44(extraout_r1_05,uVar8);
  uVar8 = (undefined4)(longlong)dVar13;
  if (dVar13 < -2147483648.0 != NAN(dVar13)) {
    uVar8 = 0;
  }
  if (2147483647.0 < dVar13) {
    uVar8 = 0;
  }
  FUN_0001b080(param_1,param_1 + 600,uVar2,uVar8);
  if (*(int *)(param_1 + 0x240) < 1) {
    uVar8 = *(undefined4 *)(param_1 + 0x378);
  }
  else {
    uVar8 = SUB84(10000000000.0 / (double)(longlong)*(int *)(param_1 + 0x240) + 0.5,0);
    floor((double)CONCAT44(in_stack_ffffffac,in_stack_ffffffa8));
    dVar13 = (double)CONCAT44(extraout_r1_06,uVar8);
    uVar8 = (undefined4)(longlong)dVar13;
    if (dVar13 < -2147483648.0 != NAN(dVar13)) {
      uVar8 = 0;
    }
    if (2147483647.0 < dVar13) {
      uVar8 = 0;
    }
  }
  FUN_0001b080(param_1,param_1 + 0x254,uVar2,uVar8);
  return;
}



double FUN_0001afb8(undefined4 param_1,int *param_2,int param_3)

{
  int iVar1;
  undefined4 uVar2;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  int iVar3;
  undefined1 uVar4;
  int iVar5;
  double extraout_d0;
  double dVar6;
  double unaff_d8;
  double dVar7;
  double unaff_d9;
  
  iVar1 = png_malloc(param_1,0x100);
  *param_2 = iVar1;
  if (param_3 - 95000U < 0x2711) {
    iVar3 = 0;
    do {
      *(char *)(iVar1 + iVar3) = (char)iVar3;
      iVar3 = iVar3 + 1;
      dVar6 = extraout_d0;
    } while (iVar3 != 0x100);
  }
  else {
    iVar3 = 0;
    dVar6 = (double)(longlong)param_3 * 1e-05;
    dVar7 = 0.0;
    do {
      if (iVar3 - 1U < 0xfe) {
        uVar2 = SUB84(dVar7 / 255.0,0);
        pow(unaff_d8,unaff_d9);
        uVar2 = SUB84((double)CONCAT44(extraout_r1,uVar2) * 255.0 + 0.5,0);
        floor(unaff_d8);
        iVar5 = (uint)(0.0 < (double)CONCAT44(extraout_r1_00,uVar2)) *
                (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar2);
        dVar6 = (double)CONCAT44(extraout_r1_00,iVar5);
        uVar4 = (undefined1)iVar5;
      }
      else {
        uVar4 = (undefined1)iVar3;
      }
      dVar7 = dVar7 + 1.0;
      *(undefined1 *)(iVar1 + iVar3) = uVar4;
      iVar3 = iVar3 + 1;
    } while (iVar3 != 0x100);
  }
  return dVar6;
}



void FUN_0001b080(undefined4 param_1,int *param_2,int param_3,int param_4)

{
  code *pcVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  uint uVar9;
  int iVar10;
  uint uVar11;
  uint uVar12;
  double dVar13;
  double extraout_d0;
  double extraout_d0_00;
  undefined4 in_stack_ffffffa8;
  
  iVar2 = 1 << (0x10U - param_3 & 0xff);
  if (!SBORROW4(iVar2,1)) {
    iVar2 = iVar2 + -1;
    uVar9 = 8 - param_3;
    uVar8 = 1 << (uVar9 & 0xff);
    iVar3 = png_calloc(param_1,uVar8 << 2);
    uVar11 = 0;
    dVar13 = (double)(longlong)param_4;
    *param_2 = iVar3;
    uVar4 = param_4 - 95000;
    do {
      iVar5 = png_malloc(SUB84(dVar13,0),param_1,0x200);
      iVar10 = 0;
      *(int *)(iVar3 + uVar11 * 4) = iVar5;
      dVar13 = extraout_d0;
      if (uVar4 < 0x2711) {
        do {
          iVar7 = (iVar10 << (uVar9 & 0xff)) + uVar11;
          if (param_3 != 0) {
            iVar7 = __aeabi_uidiv(iVar7 * 0xffff + (1 << (0xfU - param_3 & 0xff)),iVar2);
            dVar13 = extraout_d0_00;
          }
          *(short *)(iVar5 + iVar10 * 2) = (short)iVar7;
          iVar10 = iVar10 + 1;
        } while (iVar10 != 0x100);
      }
      else {
        do {
          uVar6 = SUB84((1.0 / (double)(longlong)iVar2) *
                        (double)((iVar10 << (uVar9 & 0xff)) + uVar11),0);
          pow((double)CONCAT44(uVar4,in_stack_ffffffa8),(double)CONCAT44(uVar8,iVar3));
          uVar6 = SUB84((double)CONCAT44(extraout_r1,uVar6) * 65535.0 + 0.5,0);
          floor((double)CONCAT44(uVar4,in_stack_ffffffa8));
          uVar12 = (uint)(0.0 < (double)CONCAT44(extraout_r1_00,uVar6)) *
                   (int)(longlong)(double)CONCAT44(extraout_r1_00,uVar6);
          dVar13 = (double)(ulonglong)uVar12;
          *(short *)(iVar5 + iVar10 * 2) = (short)uVar12;
          iVar10 = iVar10 + 1;
        } while (iVar10 != 0x100);
      }
      uVar11 = uVar11 + 1;
    } while (uVar11 < uVar8);
    return;
  }
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x1b1b4);
  (*pcVar1)();
}



uint png_set_option(int param_1,uint param_2,int param_3)

{
  byte bVar1;
  int iVar2;
  uint uVar3;
  
  uVar3 = 1;
  if (((param_1 != 0) && (param_2 < 6)) && ((param_2 & 1) == 0)) {
    iVar2 = 2;
    bVar1 = *(byte *)(param_1 + 0x2c4);
    if (param_3 != 0) {
      iVar2 = 3;
    }
    uVar3 = 3 << (param_2 & 0xff);
    *(byte *)(param_1 + 0x2c4) = (byte)(iVar2 << (param_2 & 0xff)) | bVar1 & ~(byte)uVar3;
    uVar3 = (bVar1 & uVar3) >> (param_2 & 0xff);
  }
  return uVar3;
}



void png_image_free(int *param_1)

{
  if (((param_1 != (int *)0x0) && (*param_1 != 0)) && (*(int *)(*param_1 + 8) == 0)) {
    png_safe_execute(param_1,0x1b22d,param_1);
    *param_1 = 0;
  }
  return;
}



void FUN_0001b22c(undefined4 *param_1)

{
  FILE *__stream;
  undefined4 uVar1;
  int iVar2;
  int *piVar3;
  int local_38;
  int iStack_34;
  int iStack_30;
  int iStack_2c;
  int iStack_28;
  uint local_24;
  int local_20;
  
  local_20 = __stack_chk_guard;
  piVar3 = (int *)*param_1;
  iVar2 = *piVar3;
  if (iVar2 == 0) {
    uVar1 = 0;
  }
  else {
    if ((*(byte *)(piVar3 + 5) & 2) != 0) {
      __stream = *(FILE **)(iVar2 + 0x11c);
      *(byte *)(piVar3 + 5) = *(byte *)(piVar3 + 5) & 0xfd;
      if (__stream != (FILE *)0x0) {
        *(undefined4 *)(iVar2 + 0x11c) = 0;
        fclose(__stream);
      }
    }
    local_38 = *piVar3;
    iStack_34 = piVar3[1];
    iStack_30 = piVar3[2];
    iStack_2c = piVar3[3];
    iStack_28 = piVar3[4];
    local_24 = piVar3[5];
    *param_1 = &local_38;
    png_free(local_38,piVar3);
    if ((local_24 & 1) == 0) {
      png_destroy_read_struct(&local_38,(uint)&local_38 | 4,0);
    }
    else {
      png_destroy_write_struct(&local_38,(uint)&local_38 | 4);
    }
    uVar1 = 1;
  }
  if (__stack_chk_guard != local_20) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar1);
  }
  return;
}



undefined4 png_image_error(int param_1,undefined4 param_2)

{
  png_safecat(param_1 + 0x20,0x40,0,param_2);
  *(uint *)(param_1 + 0x1c) = *(uint *)(param_1 + 0x1c) | 2;
  png_image_free(param_1);
  return 0;
}



undefined4 FUN_0001b2e8(undefined4 *param_1,int *param_2)

{
  code *pcVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  undefined4 extraout_r1_01;
  undefined4 extraout_r1_02;
  undefined4 extraout_r1_03;
  undefined4 extraout_r1_04;
  undefined4 extraout_r1_05;
  undefined4 extraout_r1_06;
  int iVar4;
  undefined4 unaff_r4;
  undefined4 unaff_r5;
  int iVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  double dVar9;
  
  iVar2 = *param_2;
  iVar4 = iVar2 + param_2[1];
  if ((!SBORROW4(iVar4,iVar2)) && (iVar5 = iVar4 + param_2[2], !SBORROW4(iVar5,iVar4))) {
    if (iVar5 == 0) {
      return 1;
    }
    if (iVar2 == 0) {
      uVar3 = 0;
    }
    else {
      uVar3 = SUB84(((double)(longlong)iVar2 * 100000.0) / (double)(longlong)iVar5 + 0.5,0);
      floor((double)CONCAT44(unaff_r5,unaff_r4));
      dVar9 = (double)CONCAT44(extraout_r1,uVar3);
      if (2147483647.0 < dVar9) {
        return 1;
      }
      if (dVar9 < -2147483648.0 != NAN(dVar9)) {
        return 1;
      }
      uVar3 = (undefined4)(longlong)dVar9;
    }
    *param_1 = uVar3;
    if (param_2[1] == 0) {
      uVar3 = 0;
    }
    else {
      uVar3 = SUB84(((double)(longlong)param_2[1] * 100000.0) / (double)(longlong)iVar5 + 0.5,0);
      floor((double)CONCAT44(unaff_r5,unaff_r4));
      dVar9 = (double)CONCAT44(extraout_r1_00,uVar3);
      if (2147483647.0 < dVar9) {
        return 1;
      }
      if (dVar9 < -2147483648.0 != NAN(dVar9)) {
        return 1;
      }
      uVar3 = (undefined4)(longlong)dVar9;
    }
    param_1[1] = uVar3;
    iVar2 = param_2[3];
    iVar4 = iVar2 + param_2[4];
    if ((!SBORROW4(iVar4,iVar2)) && (iVar6 = iVar4 + param_2[5], !SBORROW4(iVar6,iVar4))) {
      if (iVar6 == 0) {
        return 1;
      }
      iVar4 = *param_2;
      iVar8 = param_2[1];
      if (iVar2 == 0) {
        uVar3 = 0;
      }
      else {
        uVar3 = SUB84(((double)(longlong)iVar2 * 100000.0) / (double)(longlong)iVar6 + 0.5,0);
        floor((double)CONCAT44(unaff_r5,unaff_r4));
        dVar9 = (double)CONCAT44(extraout_r1_01,uVar3);
        if (2147483647.0 < dVar9) {
          return 1;
        }
        if (dVar9 < -2147483648.0 != NAN(dVar9)) {
          return 1;
        }
        uVar3 = (undefined4)(longlong)dVar9;
      }
      param_1[2] = uVar3;
      if (param_2[4] == 0) {
        uVar3 = 0;
      }
      else {
        uVar3 = SUB84(((double)(longlong)param_2[4] * 100000.0) / (double)(longlong)iVar6 + 0.5,0);
        floor((double)CONCAT44(unaff_r5,unaff_r4));
        dVar9 = (double)CONCAT44(extraout_r1_02,uVar3);
        if (2147483647.0 < dVar9) {
          return 1;
        }
        if (dVar9 < -2147483648.0 != NAN(dVar9)) {
          return 1;
        }
        uVar3 = (undefined4)(longlong)dVar9;
      }
      iVar6 = iVar5 + iVar6;
      param_1[3] = uVar3;
      if (((!SBORROW4(iVar6,iVar5)) && (iVar2 = iVar4 + param_2[3], !SBORROW4(iVar2,iVar4))) &&
         (iVar4 = iVar8 + param_2[4], !SBORROW4(iVar4,iVar8))) {
        iVar5 = param_2[6];
        iVar8 = param_2[7] + iVar5;
        if ((!SBORROW4(iVar8,iVar5)) && (iVar7 = iVar8 + param_2[8], !SBORROW4(iVar7,iVar8))) {
          if (iVar7 == 0) {
            return 1;
          }
          if (iVar5 == 0) {
            uVar3 = 0;
          }
          else {
            uVar3 = SUB84(((double)(longlong)iVar5 * 100000.0) / (double)(longlong)iVar7 + 0.5,0);
            floor((double)CONCAT44(unaff_r5,unaff_r4));
            dVar9 = (double)CONCAT44(extraout_r1_03,uVar3);
            if (2147483647.0 < dVar9) {
              return 1;
            }
            if (dVar9 < -2147483648.0 != NAN(dVar9)) {
              return 1;
            }
            uVar3 = (undefined4)(longlong)dVar9;
          }
          param_1[4] = uVar3;
          if (param_2[7] == 0) {
            uVar3 = 0;
          }
          else {
            uVar3 = SUB84(((double)(longlong)param_2[7] * 100000.0) / (double)(longlong)iVar7 + 0.5,
                          0);
            floor((double)CONCAT44(unaff_r5,unaff_r4));
            dVar9 = (double)CONCAT44(extraout_r1_04,uVar3);
            if (2147483647.0 < dVar9) {
              return 1;
            }
            if (dVar9 < -2147483648.0 != NAN(dVar9)) {
              return 1;
            }
            uVar3 = (undefined4)(longlong)dVar9;
          }
          param_1[5] = uVar3;
          iVar7 = iVar7 + iVar6;
          if (((!SBORROW4(iVar7,iVar6)) && (iVar5 = param_2[6] + iVar2, !SBORROW4(iVar5,iVar2))) &&
             (iVar2 = iVar4 + param_2[7], !SBORROW4(iVar2,iVar4))) {
            if (iVar7 == 0) {
              return 1;
            }
            if (iVar5 == 0) {
              uVar3 = 0;
            }
            else {
              uVar3 = SUB84(((double)(longlong)iVar5 * 100000.0) / (double)(longlong)iVar7 + 0.5,0);
              floor((double)CONCAT44(unaff_r5,unaff_r4));
              dVar9 = (double)CONCAT44(extraout_r1_05,uVar3);
              if (2147483647.0 < dVar9) {
                return 1;
              }
              if (dVar9 < -2147483648.0 != NAN(dVar9)) {
                return 1;
              }
              uVar3 = (undefined4)(longlong)dVar9;
            }
            param_1[6] = uVar3;
            if (iVar2 != 0) {
              uVar3 = SUB84(((double)(longlong)iVar2 * 100000.0) / (double)(longlong)iVar7 + 0.5,0);
              floor((double)CONCAT44(unaff_r5,unaff_r4));
              dVar9 = (double)CONCAT44(extraout_r1_06,uVar3);
              uVar3 = 1;
              if ((dVar9 <= 2147483647.0) && (dVar9 < -2147483648.0 == NAN(dVar9))) {
                uVar3 = 0;
                param_1[7] = (int)(longlong)dVar9;
              }
              return uVar3;
            }
            param_1[7] = 0;
            return 0;
          }
        }
      }
    }
  }
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x1b71a);
  (*pcVar1)();
}



void png_error(int param_1,char *param_2)

{
  char *pcVar1;
  
  if (param_1 == 0) {
    pcVar1 = "undefined";
    if (param_2 != (char *)0x0) {
      pcVar1 = param_2;
    }
    fprintf((FILE *)0x360f8,"libpng error: %s",pcVar1);
    fputc(10,(FILE *)0x360f8);
  }
  else {
    if (*(code **)(param_1 + 0x10c) != (code *)0x0) {
      (**(code **)(param_1 + 0x10c))(param_1,param_2);
    }
    pcVar1 = "undefined";
    if (param_2 != (char *)0x0) {
      pcVar1 = param_2;
    }
    fprintf((FILE *)0x360f8,"libpng error: %s",pcVar1);
    fputc(10,(FILE *)0x360f8);
    if ((*(code **)(param_1 + 0x100) != (code *)0x0) && (*(int *)(param_1 + 0x104) != 0)) {
      (**(code **)(param_1 + 0x100))(*(int *)(param_1 + 0x104),1);
                    // WARNING: Subroutine does not return
      abort();
    }
  }
                    // WARNING: Subroutine does not return
  abort();
}



uint png_safecat(int param_1,uint param_2,uint param_3,char *param_4)

{
  char cVar1;
  char *pcVar2;
  
  if ((param_1 != 0) && (param_3 < param_2)) {
    if ((param_4 != (char *)0x0) && ((param_3 < param_2 - 1 && (cVar1 = *param_4, cVar1 != '\0'))))
    {
      pcVar2 = param_4 + 1;
      do {
        *(char *)(param_1 + param_3) = cVar1;
        param_3 = param_3 + 1;
        cVar1 = *pcVar2;
        if (param_2 - 1 <= param_3) break;
        pcVar2 = pcVar2 + 1;
      } while (cVar1 != '\0');
    }
    *(undefined1 *)(param_1 + param_3) = 0;
  }
  return param_3;
}



char * png_format_number(char *param_1,int param_2,int param_3,uint param_4)

{
  code *pcVar1;
  bool bVar2;
  char *pcVar3;
  uint uVar4;
  int iVar5;
  int iVar6;
  uint uVar7;
  int iVar8;
  
  pcVar3 = (char *)(param_2 + -1);
  *pcVar3 = '\0';
  if (param_1 < pcVar3) {
    iVar8 = 1;
    bVar2 = false;
    iVar6 = 0;
    do {
      if ((param_4 == 0) && (iVar8 <= iVar6)) {
        return pcVar3;
      }
      switch(param_3) {
      case 2:
        iVar8 = 2;
      case 1:
        pcVar3 = pcVar3 + -1;
        *pcVar3 = "0123456789ABCDEF"[param_4 % 10];
        param_4 = param_4 / 10;
        break;
      case 4:
        iVar8 = 2;
      case 3:
        pcVar3 = pcVar3 + -1;
        *pcVar3 = "0123456789ABCDEF"[param_4 & 0xf];
        param_4 = param_4 >> 4;
        break;
      case 5:
        iVar8 = 5;
        uVar7 = param_4 / 10;
        uVar4 = param_4 % 10;
        param_4 = uVar7;
        if (bVar2 || uVar4 != 0) {
          pcVar3 = pcVar3 + -1;
          *pcVar3 = "0123456789ABCDEF"[uVar4];
          bVar2 = true;
        }
        break;
      default:
        param_4 = 0;
      }
      iVar5 = iVar6 + 1;
      if (SBORROW4(iVar5,iVar6)) {
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x1b8da);
        (*pcVar1)();
      }
      if ((param_3 == 5 && iVar5 == 5) && (param_1 < pcVar3)) {
        if (bVar2) {
          pcVar3 = pcVar3 + -1;
          *pcVar3 = '.';
        }
        else if (param_4 == 0) {
          pcVar3 = pcVar3 + -1;
          *pcVar3 = '0';
          param_4 = 0;
          bVar2 = false;
        }
        else {
          bVar2 = false;
        }
      }
      iVar6 = iVar5;
    } while (param_1 < pcVar3);
  }
  return pcVar3;
}



void png_benign_error(int param_1,char *param_2)

{
  uint uVar1;
  char *pcVar2;
  bool bVar3;
  
  if ((*(byte *)(param_1 + 0x136) & 0x10) != 0) {
    return;
  }
  uVar1 = (uint)*(byte *)(param_1 + 0x131);
  bVar3 = (*(byte *)(param_1 + 0x131) & 0x80) != 0;
  if (bVar3) {
    uVar1 = *(uint *)(param_1 + 0x1d8);
  }
  if (bVar3 && uVar1 != 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,param_2);
  }
  if (*(code **)(param_1 + 0x10c) != (code *)0x0) {
    (**(code **)(param_1 + 0x10c))(param_1,param_2);
  }
  pcVar2 = "undefined";
  if (param_2 != (char *)0x0) {
    pcVar2 = param_2;
  }
  fprintf((FILE *)0x360f8,"libpng error: %s",pcVar2);
  fputc(10,(FILE *)0x360f8);
  if ((*(code **)(param_1 + 0x100) != (code *)0x0) && (*(int *)(param_1 + 0x104) != 0)) {
    (**(code **)(param_1 + 0x100))(*(int *)(param_1 + 0x104),1);
  }
                    // WARNING: Subroutine does not return
  abort();
}



void png_chunk_error(int param_1,char *param_2)

{
  code *pcVar1;
  char *pcVar2;
  uint uVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  uint uVar8;
  uint uVar9;
  char local_fa [214];
  
  if (param_1 == 0) {
    pcVar2 = "undefined";
    if (param_2 != (char *)0x0) {
      pcVar2 = param_2;
    }
    fprintf((FILE *)0x360f8,"libpng error: %s",pcVar2);
    fputc(10,(FILE *)0x360f8);
                    // WARNING: Subroutine does not return
    abort();
  }
  uVar8 = *(uint *)(param_1 + 0x1d8);
  uVar3 = 0x18;
  iVar6 = 0;
  do {
    if (SBORROW4(uVar3,8)) goto LAB_0001ba68;
    uVar9 = uVar8 >> (uVar3 & 0xff);
    iVar7 = iVar6 + 1;
    if (((uVar9 & 0xff) - 0x41 < 0x3a) && (5 < (uVar9 & 0xff) - 0x5b)) {
      if (SBORROW4(iVar7,iVar6)) goto LAB_0001ba68;
      local_fa[iVar6] = (char)uVar9;
    }
    else {
      if (SBORROW4(iVar7,iVar6)) goto LAB_0001ba68;
      local_fa[iVar6] = '[';
      if (SBORROW4(iVar6 + 2,iVar7)) goto LAB_0001ba68;
      local_fa[iVar6 + 1] = "0123456789ABCDEF"[(uVar9 << 0x18) >> 0x1c];
      if (SBORROW4(iVar6 + 3,iVar6 + 2)) goto LAB_0001ba68;
      iVar7 = iVar6 + 4;
      local_fa[iVar6 + 2] = "0123456789ABCDEF"[uVar9 & 0xf];
      if (SBORROW4(iVar7,iVar6 + 3)) goto LAB_0001ba68;
      local_fa[iVar6 + 3] = ']';
    }
    uVar3 = uVar3 - 8;
    iVar6 = iVar7;
  } while (uVar3 < 0x80000000);
  if (param_2 == (char *)0x0) {
    local_fa[iVar7] = '\0';
LAB_0001ba70:
                    // WARNING: Subroutine does not return
    png_error(param_1,local_fa);
  }
  if (!SBORROW4(iVar7 + 1,iVar7)) {
    local_fa[iVar7] = ':';
    if (!SBORROW4(iVar7 + 2,iVar7 + 1)) {
      local_fa[iVar7 + 1] = ' ';
      iVar6 = 0;
      iVar7 = iVar7 + 2;
      do {
        iVar4 = iVar7;
        if (param_2[iVar6] == '\0') break;
        iVar5 = iVar6 + 1;
        if ((SBORROW4(iVar5,iVar6)) || (iVar4 = iVar7 + 1, SBORROW4(iVar4,iVar7)))
        goto LAB_0001ba68;
        local_fa[iVar7] = param_2[iVar6];
        iVar6 = iVar5;
        iVar7 = iVar4;
      } while (iVar5 < 0xc3);
      local_fa[iVar4] = '\0';
      goto LAB_0001ba70;
    }
  }
LAB_0001ba68:
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x1ba68);
  (*pcVar1)();
}



void png_app_warning(int param_1,char *param_2)

{
  char *pcVar1;
  
  if ((*(byte *)(param_1 + 0x136) & 0x20) != 0) {
    return;
  }
  if (*(code **)(param_1 + 0x10c) != (code *)0x0) {
    (**(code **)(param_1 + 0x10c))(param_1,param_2);
  }
  pcVar1 = "undefined";
  if (param_2 != (char *)0x0) {
    pcVar1 = param_2;
  }
  fprintf((FILE *)0x360f8,"libpng error: %s",pcVar1);
  fputc(10,(FILE *)0x360f8);
  if ((*(code **)(param_1 + 0x100) != (code *)0x0) && (*(int *)(param_1 + 0x104) != 0)) {
    (**(code **)(param_1 + 0x100))(*(int *)(param_1 + 0x104),1);
  }
                    // WARNING: Subroutine does not return
  abort();
}



void png_app_error(int param_1,char *param_2)

{
  char *pcVar1;
  
  if ((*(byte *)(param_1 + 0x136) & 0x40) != 0) {
    return;
  }
  if (*(code **)(param_1 + 0x10c) != (code *)0x0) {
    (**(code **)(param_1 + 0x10c))(param_1,param_2);
  }
  pcVar1 = "undefined";
  if (param_2 != (char *)0x0) {
    pcVar1 = param_2;
  }
  fprintf((FILE *)0x360f8,"libpng error: %s",pcVar1);
  fputc(10,(FILE *)0x360f8);
  if ((*(code **)(param_1 + 0x100) != (code *)0x0) && (*(int *)(param_1 + 0x104) != 0)) {
    (**(code **)(param_1 + 0x100))(*(int *)(param_1 + 0x104),1);
  }
                    // WARNING: Subroutine does not return
  abort();
}



void png_chunk_benign_error(int param_1)

{
  if ((*(byte *)(param_1 + 0x136) & 0x10) != 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  png_chunk_error();
}



void png_chunk_report(int param_1,undefined4 param_2,int param_3)

{
  if ((*(byte *)(param_1 + 0x131) & 0x80) == 0) {
    if (param_3 < 1) {
      png_app_warning();
      return;
    }
    png_app_error();
    return;
  }
  if (1 < param_3) {
    if ((*(byte *)(param_1 + 0x136) & 0x10) == 0) {
                    // WARNING: Subroutine does not return
      png_chunk_error();
    }
    return;
  }
  return;
}



void png_fixed_error(int param_1,int param_2)

{
  code *pcVar1;
  char *pcVar2;
  char *pcVar3;
  char local_f8 [224];
  
  builtin_strncpy(local_f8,"fixed point overflow in ",0x18);
  if (param_2 == 0) {
    pcVar3 = local_f8 + 0x18;
    pcVar2 = (char *)0x0;
  }
  else {
    pcVar2 = (char *)0x0;
    do {
      pcVar3 = pcVar2;
      if (pcVar2[param_2] == '\0') break;
      local_f8[(int)(pcVar2 + 0x18)] = pcVar2[param_2];
      pcVar3 = pcVar2 + 1;
      if (SBORROW4((int)pcVar3,(int)pcVar2)) {
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x1bc6c);
        (*pcVar1)();
      }
      pcVar2 = pcVar3;
    } while ((int)pcVar3 < 0xc3);
  }
  local_f8[(int)(pcVar2 + 0x18)] = '\0';
  if (param_1 == 0) {
    fprintf((FILE *)0x360f8,"libpng error: %s",local_f8);
    fputc(10,(FILE *)0x360f8);
  }
  else {
    pcVar1 = *(code **)(param_1 + 0x10c);
    if (pcVar1 != (code *)0x0) {
      (*pcVar1)(param_1,local_f8,pcVar1,pcVar3);
    }
    fprintf((FILE *)0x360f8,"libpng error: %s",local_f8);
    fputc(10,(FILE *)0x360f8);
    if ((*(code **)(param_1 + 0x100) != (code *)0x0) && (*(int *)(param_1 + 0x104) != 0)) {
      (**(code **)(param_1 + 0x100))(*(int *)(param_1 + 0x104),1);
                    // WARNING: Subroutine does not return
      abort();
    }
  }
                    // WARNING: Subroutine does not return
  abort();
}



int png_set_longjmp_fn(int param_1,undefined4 param_2,uint param_3)

{
  int iVar1;
  uint uVar2;
  
  if (param_1 == 0) {
    return 0;
  }
  iVar1 = *(int *)(param_1 + 0x104);
  if (iVar1 == 0) {
    *(undefined4 *)(param_1 + 0x108) = 0;
    if (param_3 < 0x101) {
      *(int *)(param_1 + 0x104) = param_1;
      iVar1 = param_1;
    }
    else {
      iVar1 = png_malloc_warn(param_1,param_3);
      *(int *)(param_1 + 0x104) = iVar1;
      if (iVar1 == 0) {
        return 0;
      }
      *(uint *)(param_1 + 0x108) = param_3;
    }
  }
  else {
    uVar2 = *(uint *)(param_1 + 0x108);
    if (uVar2 == 0) {
      if (iVar1 != param_1) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Libpng jmp_buf still allocated");
      }
      uVar2 = 0x100;
    }
    if (uVar2 != param_3) {
      return 0;
    }
  }
  *(undefined4 *)(param_1 + 0x100) = param_2;
  return iVar1;
}



void png_free_jmpbuf(int param_1)

{
  int iVar1;
  int iVar2;
  __jmp_buf_tag _Stack_114;
  int local_14;
  
  local_14 = __stack_chk_guard;
  if (param_1 != 0) {
    iVar2 = *(int *)(param_1 + 0x104);
    if (iVar2 != 0) {
      iVar1 = __stack_chk_guard;
      if (iVar2 != param_1) {
        iVar1 = *(int *)(param_1 + 0x108);
      }
      if (iVar2 != param_1 && iVar1 != 0) {
        iVar1 = setjmp(&_Stack_114);
        if (iVar1 == 0) {
          *(__jmp_buf_tag **)(param_1 + 0x104) = &_Stack_114;
          *(undefined4 *)(param_1 + 0x108) = 0;
          *(code **)(param_1 + 0x100) = longjmp;
          png_free(param_1,iVar2);
        }
      }
    }
    *(undefined4 *)(param_1 + 0x100) = 0;
    *(undefined4 *)(param_1 + 0x104) = 0;
    *(undefined4 *)(param_1 + 0x108) = 0;
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_longjmp(int param_1)

{
  if (((param_1 != 0) && (*(code **)(param_1 + 0x100) != (code *)0x0)) &&
     (*(int *)(param_1 + 0x104) != 0)) {
    (**(code **)(param_1 + 0x100))();
  }
                    // WARNING: Subroutine does not return
  abort();
}



void png_set_error_fn(int param_1,undefined4 param_2,undefined4 param_3)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x10c) = param_3;
    *(undefined4 *)(param_1 + 0x110) = param_2;
  }
  return;
}



undefined4 png_get_error_ptr(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x110);
  }
  return uVar1;
}



void png_safe_error(int param_1,char *param_2)

{
  int *piVar1;
  uint uVar2;
  __jmp_buf_tag *__env;
  int iVar3;
  int iVar4;
  int *piVar5;
  char cVar6;
  uint uVar7;
  
  piVar5 = *(int **)(param_1 + 0x110);
  if (piVar5 != (int *)0x0) {
    piVar1 = piVar5 + 8;
    uVar2 = 0;
    if (param_2 != (char *)0x0) {
      cVar6 = *param_2;
      if (cVar6 == '\0') {
        uVar2 = 0;
      }
      else {
        uVar7 = 0;
        do {
          uVar2 = uVar7 + 1;
          *(char *)((int)piVar1 + uVar7) = cVar6;
          if (0x3e < uVar2) break;
          cVar6 = param_2[uVar7 + 1];
          uVar7 = uVar2;
        } while (cVar6 != '\0');
      }
    }
    *(undefined1 *)((int)piVar5 + uVar2 + 0x20) = 0;
    piVar5[7] = piVar5[7] | 2;
    if ((*piVar5 != 0) && (__env = *(__jmp_buf_tag **)(*piVar5 + 8), __env != (__jmp_buf_tag *)0x0))
    {
                    // WARNING: Subroutine does not return
      longjmp(__env,1);
    }
    cVar6 = 'b';
    iVar3 = 0;
    do {
      *(char *)((int)piVar1 + iVar3) = cVar6;
      iVar4 = iVar3 + 1;
      cVar6 = "bad longjmp: "[iVar3 + 1];
      iVar3 = iVar4;
    } while (iVar4 != 0xd);
    *(undefined1 *)((int)piVar5 + 0x2d) = 0;
    png_safecat(piVar1,0x40,0xd,param_2);
  }
                    // WARNING: Subroutine does not return
  abort();
}



void png_safe_execute(int *param_1,code *param_2,undefined4 param_3)

{
  undefined4 uVar1;
  int iVar2;
  uint local_11c;
  __jmp_buf_tag _Stack_114;
  int local_14;
  
  local_14 = __stack_chk_guard;
  uVar1 = *(undefined4 *)(*param_1 + 8);
  iVar2 = setjmp(&_Stack_114);
  local_11c = (uint)(iVar2 == 0);
  if (local_11c != 0) {
    *(__jmp_buf_tag **)(*param_1 + 8) = &_Stack_114;
    local_11c = (*param_2)(param_3);
  }
  *(undefined4 *)(*param_1 + 8) = uVar1;
  if (local_11c == 0) {
    png_image_free(param_1);
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_11c);
  }
  return;
}



uint png_get_valid(int param_1,int param_2,uint param_3)

{
  uint uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(uint *)(param_2 + 8) & param_3;
  }
  return uVar1;
}



undefined4 png_get_rowbytes(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined4 *)(param_2 + 0xc);
  }
  return uVar1;
}



undefined4 png_get_rows(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined4 *)(param_2 + 0x108);
  }
  return uVar1;
}



undefined4 png_get_image_width(int param_1,undefined4 *param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != (undefined4 *)0x0)) {
    uVar1 = *param_2;
  }
  return uVar1;
}



undefined4 png_get_image_height(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined4 *)(param_2 + 4);
  }
  return uVar1;
}



undefined1 png_get_bit_depth(int param_1,int param_2)

{
  undefined1 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined1 *)(param_2 + 0x18);
  }
  return uVar1;
}



undefined1 png_get_color_type(int param_1,int param_2)

{
  undefined1 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined1 *)(param_2 + 0x19);
  }
  return uVar1;
}



undefined1 png_get_filter_type(int param_1,int param_2)

{
  undefined1 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined1 *)(param_2 + 0x1b);
  }
  return uVar1;
}



undefined1 png_get_interlace_type(int param_1,int param_2)

{
  undefined1 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined1 *)(param_2 + 0x1c);
  }
  return uVar1;
}



undefined1 png_get_compression_type(int param_1,int param_2)

{
  undefined1 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined1 *)(param_2 + 0x1a);
  }
  return uVar1;
}



undefined4 png_get_x_pixels_per_meter(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 8) & 0x80) == 0) || (*(char *)(param_2 + 200) != '\x01')) {
      return 0;
    }
    uVar1 = *(undefined4 *)(param_2 + 0xc0);
  }
  return uVar1;
}



undefined4 png_get_y_pixels_per_meter(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 8) & 0x80) == 0) || (*(char *)(param_2 + 200) != '\x01')) {
      return 0;
    }
    uVar1 = *(undefined4 *)(param_2 + 0xc4);
  }
  return uVar1;
}



uint png_get_pixels_per_meter(int param_1,uint param_2)

{
  uint uVar1;
  bool bVar2;
  
  if (((param_1 != 0) && (param_2 != 0)) && ((*(byte *)(param_2 + 8) & 0x80) != 0)) {
    uVar1 = (uint)*(byte *)(param_2 + 200);
    bVar2 = uVar1 == 1;
    if (bVar2) {
      uVar1 = *(uint *)(param_2 + 0xc0);
      param_2 = *(uint *)(param_2 + 0xc4);
    }
    if (bVar2 && uVar1 == param_2) {
      return uVar1;
    }
  }
  return 0;
}



float png_get_pixel_aspect_ratio(int param_1,int param_2)

{
  uint uVar1;
  bool bVar2;
  float fVar3;
  
  fVar3 = 0.0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = (uint)*(byte *)(param_2 + 8);
    bVar2 = (*(byte *)(param_2 + 8) & 0x80) != 0;
    if (bVar2) {
      uVar1 = *(uint *)(param_2 + 0xc0);
    }
    if (bVar2 && uVar1 != 0) {
      fVar3 = (float)*(uint *)(param_2 + 0xc4) / (float)uVar1;
    }
  }
  return fVar3;
}



void png_get_pixel_aspect_ratio_fixed(int param_1,int param_2,undefined4 param_3,int param_4)

{
  int iVar1;
  bool bVar2;
  bool bVar3;
  bool bVar4;
  undefined4 local_10;
  int local_c;
  
  local_c = __stack_chk_guard;
  if ((param_1 != 0) && (param_2 != 0)) {
    bVar2 = (*(byte *)(param_2 + 8) & 0x80) != 0;
    if (bVar2) {
      param_4 = *(int *)(param_2 + 0xc0);
    }
    bVar3 = param_4 < 0;
    bVar4 = bVar2 && bVar3;
    if (bVar2 && param_4 != 0) {
      if (!bVar2 || !bVar3) {
        param_2 = *(int *)(param_2 + 0xc4);
        bVar4 = param_2 + -1 < 0;
      }
      if ((bVar4 == ((!bVar2 || !bVar3) && SBORROW4(param_2,1))) &&
         (iVar1 = png_muldiv(&local_10,param_2,100000), iVar1 != 0)) goto LAB_0001bfe8;
    }
  }
  local_10 = 0;
LAB_0001bfe8:
  if (__stack_chk_guard == local_c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(local_10);
}



undefined4 png_get_x_offset_microns(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 9) & 1) == 0) || (*(char *)(param_2 + 0xbc) != '\x01')) {
      return 0;
    }
    uVar1 = *(undefined4 *)(param_2 + 0xb4);
  }
  return uVar1;
}



undefined4 png_get_y_offset_microns(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 9) & 1) == 0) || (*(char *)(param_2 + 0xbc) != '\x01')) {
      return 0;
    }
    uVar1 = *(undefined4 *)(param_2 + 0xb8);
  }
  return uVar1;
}



undefined4 png_get_x_offset_pixels(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 9) & 1) == 0) || (*(char *)(param_2 + 0xbc) != '\0')) {
      return 0;
    }
    uVar1 = *(undefined4 *)(param_2 + 0xb4);
  }
  return uVar1;
}



undefined4 png_get_y_offset_pixels(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 9) & 1) == 0) || (*(char *)(param_2 + 0xbc) != '\0')) {
      return 0;
    }
    uVar1 = *(undefined4 *)(param_2 + 0xb8);
  }
  return uVar1;
}



void png_get_pixels_per_inch(int param_1,int param_2)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  bool bVar4;
  undefined4 local_10;
  uint local_c;
  
  local_c = __stack_chk_guard;
  if (((param_1 == 0) || (param_2 == 0)) || ((*(byte *)(param_2 + 8) & 0x80) == 0)) {
LAB_0001c0b8:
    uVar3 = 0;
  }
  else {
    uVar1 = (uint)*(byte *)(param_2 + 200);
    bVar4 = uVar1 == 1;
    uVar3 = __stack_chk_guard;
    if (bVar4) {
      uVar3 = *(uint *)(param_2 + 0xc0);
      uVar1 = *(uint *)(param_2 + 0xc4);
    }
    if (!bVar4 || uVar3 != uVar1) goto LAB_0001c0b8;
    if ((int)uVar3 < 0) {
      local_10 = 0;
      goto LAB_0001c0d2;
    }
  }
  iVar2 = png_muldiv(&local_10,uVar3,0x7f,5000);
  if (iVar2 == 0) {
    local_10 = 0;
  }
LAB_0001c0d2:
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_10);
  }
  return;
}



void png_get_x_pixels_per_inch(int param_1,int param_2)

{
  int iVar1;
  undefined4 local_10;
  int local_c;
  
  local_c = __stack_chk_guard;
  if ((((param_1 == 0) || (param_2 == 0)) || ((*(byte *)(param_2 + 8) & 0x80) == 0)) ||
     (*(char *)(param_2 + 200) != '\x01')) {
    iVar1 = 0;
  }
  else {
    iVar1 = *(int *)(param_2 + 0xc0);
    if (iVar1 < 0) {
      local_10 = 0;
      goto LAB_0001c140;
    }
  }
  iVar1 = png_muldiv(&local_10,iVar1,0x7f,5000);
  if (iVar1 == 0) {
    local_10 = 0;
  }
LAB_0001c140:
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_10);
  }
  return;
}



void png_get_y_pixels_per_inch(int param_1,int param_2)

{
  int iVar1;
  undefined4 local_10;
  int local_c;
  
  local_c = __stack_chk_guard;
  if ((((param_1 == 0) || (param_2 == 0)) || ((*(byte *)(param_2 + 8) & 0x80) == 0)) ||
     (*(char *)(param_2 + 200) != '\x01')) {
    iVar1 = 0;
  }
  else {
    iVar1 = *(int *)(param_2 + 0xc4);
    if (iVar1 < 0) {
      local_10 = 0;
      goto LAB_0001c1a8;
    }
  }
  iVar1 = png_muldiv(&local_10,iVar1,0x7f,5000);
  if (iVar1 == 0) {
    local_10 = 0;
  }
LAB_0001c1a8:
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_10);
  }
  return;
}



void png_get_x_offset_inches_fixed(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 9) & 1) == 0) || (*(char *)(param_2 + 0xbc) != '\x01')) {
      uVar1 = 0;
    }
    else {
      uVar1 = *(undefined4 *)(param_2 + 0xb4);
    }
  }
  png_muldiv_warn(param_1,uVar1,500,0x7f);
  return;
}



void png_get_y_offset_inches_fixed(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if (((*(byte *)(param_2 + 9) & 1) == 0) || (*(char *)(param_2 + 0xbc) != '\x01')) {
      uVar1 = 0;
    }
    else {
      uVar1 = *(undefined4 *)(param_2 + 0xb8);
    }
  }
  png_muldiv_warn(param_1,uVar1,500,0x7f);
  return;
}



float png_get_x_offset_inches(int param_1,int param_2)

{
  float fVar1;
  
  fVar1 = 0.0;
  if ((((param_1 != 0) && (param_2 != 0)) && ((*(byte *)(param_2 + 9) & 1) != 0)) &&
     (*(char *)(param_2 + 0xbc) == '\x01')) {
    fVar1 = (float)((double)(longlong)*(int *)(param_2 + 0xb4) * 3.937e-05);
  }
  return fVar1;
}



float png_get_y_offset_inches(int param_1,int param_2)

{
  float fVar1;
  
  fVar1 = 0.0;
  if ((((param_1 != 0) && (param_2 != 0)) && ((*(byte *)(param_2 + 9) & 1) != 0)) &&
     (*(char *)(param_2 + 0xbc) == '\x01')) {
    fVar1 = (float)((double)(longlong)*(int *)(param_2 + 0xb8) * 3.937e-05);
  }
  return fVar1;
}



undefined4 png_get_pHYs_dpi(int param_1,int param_2,uint *param_3,uint *param_4,uint *param_5)

{
  byte bVar1;
  undefined4 uVar2;
  double dVar3;
  
  uVar2 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 8) & 0x80) == 0) {
      return 0;
    }
    if (param_3 == (uint *)0x0) {
      uVar2 = 0;
    }
    else {
      *param_3 = *(uint *)(param_2 + 0xc0);
      uVar2 = 0x80;
    }
    if (param_4 != (uint *)0x0) {
      *param_4 = *(uint *)(param_2 + 0xc4);
      uVar2 = 0x80;
    }
    if (param_5 != (uint *)0x0) {
      bVar1 = *(byte *)(param_2 + 200);
      *param_5 = (uint)bVar1;
      if (bVar1 == 1) {
        if (param_3 != (uint *)0x0) {
          dVar3 = (double)*param_3 * 0.0254 + 0.5;
          *param_3 = (uint)(0.0 < dVar3) * (int)(longlong)dVar3;
        }
        if (param_4 != (uint *)0x0) {
          dVar3 = (double)*param_4 * 0.0254 + 0.5;
          *param_4 = (uint)(0.0 < dVar3) * (int)(longlong)dVar3;
        }
      }
      uVar2 = 0x80;
    }
  }
  return uVar2;
}



undefined1 png_get_channels(int param_1,int param_2)

{
  undefined1 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined1 *)(param_2 + 0x1d);
  }
  return uVar1;
}



int png_get_signature(int param_1,int param_2)

{
  if (param_2 != 0) {
    param_2 = param_2 + 0x20;
  }
  if (param_1 != 0) {
    param_1 = param_2;
  }
  return param_1;
}



undefined4 png_get_bKGD(int param_1,int param_2,int *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((((param_1 != 0) && (param_2 != 0)) && (uVar1 = 0, param_3 != (int *)0x0)) &&
     ((*(uint *)(param_2 + 8) & 0x20) != 0)) {
    *param_3 = param_2 + 0xaa;
    uVar1 = 0x20;
  }
  return uVar1;
}



undefined4
png_get_cHRM(int param_1,int param_2,double *param_3,double *param_4,double *param_5,double *param_6
            ,double *param_7,double *param_8,double *param_9,double *param_10)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 0x72) & 2) == 0) {
      return 0;
    }
    if (param_3 != (double *)0x0) {
      *param_3 = (double)(longlong)*(int *)(param_2 + 0x44) * 1e-05;
    }
    if (param_4 != (double *)0x0) {
      *param_4 = (double)(longlong)*(int *)(param_2 + 0x48) * 1e-05;
    }
    if (param_5 != (double *)0x0) {
      *param_5 = (double)(longlong)*(int *)(param_2 + 0x2c) * 1e-05;
    }
    if (param_6 != (double *)0x0) {
      *param_6 = (double)(longlong)*(int *)(param_2 + 0x30) * 1e-05;
    }
    if (param_7 != (double *)0x0) {
      *param_7 = (double)(longlong)*(int *)(param_2 + 0x34) * 1e-05;
    }
    if (param_8 != (double *)0x0) {
      *param_8 = (double)(longlong)*(int *)(param_2 + 0x38) * 1e-05;
    }
    if (param_9 != (double *)0x0) {
      *param_9 = (double)(longlong)*(int *)(param_2 + 0x3c) * 1e-05;
    }
    if (param_10 != (double *)0x0) {
      *param_10 = (double)(longlong)*(int *)(param_2 + 0x40) * 1e-05;
    }
    uVar1 = 4;
  }
  return uVar1;
}



undefined4
png_get_cHRM_XYZ(int param_1,int param_2,double *param_3,double *param_4,double *param_5,
                double *param_6,double *param_7,double *param_8,double *param_9,double *param_10,
                double *param_11)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 0x72) & 2) == 0) {
      return 0;
    }
    if (param_3 != (double *)0x0) {
      *param_3 = (double)(longlong)*(int *)(param_2 + 0x4c) * 1e-05;
    }
    if (param_4 != (double *)0x0) {
      *param_4 = (double)(longlong)*(int *)(param_2 + 0x50) * 1e-05;
    }
    if (param_5 != (double *)0x0) {
      *param_5 = (double)(longlong)*(int *)(param_2 + 0x54) * 1e-05;
    }
    if (param_6 != (double *)0x0) {
      *param_6 = (double)(longlong)*(int *)(param_2 + 0x58) * 1e-05;
    }
    if (param_7 != (double *)0x0) {
      *param_7 = (double)(longlong)*(int *)(param_2 + 0x5c) * 1e-05;
    }
    if (param_8 != (double *)0x0) {
      *param_8 = (double)(longlong)*(int *)(param_2 + 0x60) * 1e-05;
    }
    if (param_9 != (double *)0x0) {
      *param_9 = (double)(longlong)*(int *)(param_2 + 100) * 1e-05;
    }
    if (param_10 != (double *)0x0) {
      *param_10 = (double)(longlong)*(int *)(param_2 + 0x68) * 1e-05;
    }
    if (param_11 != (double *)0x0) {
      *param_11 = (double)(longlong)*(int *)(param_2 + 0x6c) * 1e-05;
    }
    uVar1 = 4;
  }
  return uVar1;
}



undefined4
png_get_cHRM_XYZ_fixed
          (int param_1,int param_2,undefined4 *param_3,undefined4 *param_4,undefined4 *param_5,
          undefined4 *param_6,undefined4 *param_7,undefined4 *param_8,undefined4 *param_9,
          undefined4 *param_10,undefined4 *param_11)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 0x72) & 2) == 0) {
      return 0;
    }
    if (param_3 != (undefined4 *)0x0) {
      *param_3 = *(undefined4 *)(param_2 + 0x4c);
    }
    if (param_4 != (undefined4 *)0x0) {
      *param_4 = *(undefined4 *)(param_2 + 0x50);
    }
    if (param_5 != (undefined4 *)0x0) {
      *param_5 = *(undefined4 *)(param_2 + 0x54);
    }
    if (param_6 != (undefined4 *)0x0) {
      *param_6 = *(undefined4 *)(param_2 + 0x58);
    }
    if (param_7 != (undefined4 *)0x0) {
      *param_7 = *(undefined4 *)(param_2 + 0x5c);
    }
    if (param_8 != (undefined4 *)0x0) {
      *param_8 = *(undefined4 *)(param_2 + 0x60);
    }
    if (param_9 != (undefined4 *)0x0) {
      *param_9 = *(undefined4 *)(param_2 + 100);
    }
    if (param_10 != (undefined4 *)0x0) {
      *param_10 = *(undefined4 *)(param_2 + 0x68);
    }
    if (param_11 != (undefined4 *)0x0) {
      *param_11 = *(undefined4 *)(param_2 + 0x6c);
    }
    uVar1 = 4;
  }
  return uVar1;
}



undefined4
png_get_cHRM_fixed(int param_1,int param_2,undefined4 *param_3,undefined4 *param_4,
                  undefined4 *param_5,undefined4 *param_6,undefined4 *param_7,undefined4 *param_8,
                  undefined4 *param_9,undefined4 *param_10)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 0x72) & 2) == 0) {
      return 0;
    }
    if (param_3 != (undefined4 *)0x0) {
      *param_3 = *(undefined4 *)(param_2 + 0x44);
    }
    if (param_4 != (undefined4 *)0x0) {
      *param_4 = *(undefined4 *)(param_2 + 0x48);
    }
    if (param_5 != (undefined4 *)0x0) {
      *param_5 = *(undefined4 *)(param_2 + 0x2c);
    }
    if (param_6 != (undefined4 *)0x0) {
      *param_6 = *(undefined4 *)(param_2 + 0x30);
    }
    if (param_7 != (undefined4 *)0x0) {
      *param_7 = *(undefined4 *)(param_2 + 0x34);
    }
    if (param_8 != (undefined4 *)0x0) {
      *param_8 = *(undefined4 *)(param_2 + 0x38);
    }
    if (param_9 != (undefined4 *)0x0) {
      *param_9 = *(undefined4 *)(param_2 + 0x3c);
    }
    if (param_10 != (undefined4 *)0x0) {
      *param_10 = *(undefined4 *)(param_2 + 0x40);
    }
    uVar1 = 4;
  }
  return uVar1;
}



undefined4 png_get_gAMA_fixed(int param_1,int param_2,undefined4 *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((((param_1 != 0) && (param_2 != 0)) && (uVar1 = 0, param_3 != (undefined4 *)0x0)) &&
     ((*(ushort *)(param_2 + 0x72) & 1) != 0)) {
    *param_3 = *(undefined4 *)(param_2 + 0x28);
    uVar1 = 1;
  }
  return uVar1;
}



undefined4 png_get_gAMA(int param_1,int param_2,double *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((((param_1 != 0) && (param_2 != 0)) && (uVar1 = 0, param_3 != (double *)0x0)) &&
     ((*(ushort *)(param_2 + 0x72) & 1) != 0)) {
    uVar1 = 1;
    *param_3 = (double)(longlong)*(int *)(param_2 + 0x28) * 1e-05;
  }
  return uVar1;
}



undefined4 png_get_sRGB(int param_1,int param_2,uint *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((((param_1 != 0) && (param_2 != 0)) && (uVar1 = 0, param_3 != (uint *)0x0)) &&
     ((*(uint *)(param_2 + 8) & 0x800) != 0)) {
    *param_3 = (uint)*(ushort *)(param_2 + 0x70);
    uVar1 = 0x800;
  }
  return uVar1;
}



uint png_get_iCCP(int param_1,uint param_2,undefined4 *param_3,undefined4 *param_4,
                 undefined4 *param_5,uint *param_6)

{
  uint uVar1;
  byte *pbVar2;
  uint uVar3;
  bool bVar4;
  
  uVar1 = 0;
  if (((param_1 != 0 && param_2 != 0) && (uVar1 = 0, param_6 != (uint *)0x0)) &&
     (param_5 != (undefined4 *)0x0 && param_4 != (undefined4 *)0x0)) {
    if (param_3 == (undefined4 *)0x0) {
      return uVar1;
    }
    uVar3 = *(uint *)(param_2 + 8) & 0x1000;
    bVar4 = uVar3 != 0;
    if (bVar4) {
      *param_3 = *(undefined4 *)(param_2 + 0x74);
      pbVar2 = *(byte **)(param_2 + 0x78);
      *param_5 = pbVar2;
      param_2 = (uint)*pbVar2;
      uVar3 = (uint)pbVar2[2];
      uVar1 = (uint)pbVar2[3];
      param_3 = (undefined4 *)((uint)pbVar2[1] << 0x10);
    }
    if (bVar4) {
      param_2 = (uint)param_3 | param_2 << 0x18;
    }
    if (bVar4) {
      *param_6 = uVar1 | param_2 | uVar3 << 8;
      *param_4 = 0;
      uVar1 = 0x1000;
    }
  }
  return uVar1;
}



undefined4 png_get_sPLT(int param_1,int param_2,undefined4 *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (((param_1 != 0) && (param_2 != 0)) && (param_3 != (undefined4 *)0x0)) {
    *param_3 = *(undefined4 *)(param_2 + 0xf4);
    uVar1 = *(undefined4 *)(param_2 + 0xf8);
  }
  return uVar1;
}



undefined4 png_get_hIST(int param_1,int param_2,undefined4 *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((((param_1 != 0) && (param_2 != 0)) && (uVar1 = 0, param_3 != (undefined4 *)0x0)) &&
     ((*(uint *)(param_2 + 8) & 0x40) != 0)) {
    *param_3 = *(undefined4 *)(param_2 + 0xcc);
    uVar1 = 0x40;
  }
  return uVar1;
}



undefined4
png_get_IHDR(int param_1,undefined4 *param_2,undefined4 *param_3,undefined4 *param_4,uint *param_5,
            uint *param_6,uint *param_7,uint *param_8,uint *param_9)

{
  byte bVar1;
  uint uVar2;
  undefined4 uVar3;
  
  uVar3 = 0;
  if ((param_1 != 0) && (param_2 != (undefined4 *)0x0)) {
    if (param_3 != (undefined4 *)0x0) {
      *param_3 = *param_2;
    }
    if (param_4 != (undefined4 *)0x0) {
      *param_4 = param_2[1];
    }
    if (param_5 != (uint *)0x0) {
      *param_5 = (uint)*(byte *)(param_2 + 6);
    }
    if (param_6 != (uint *)0x0) {
      *param_6 = (uint)*(byte *)((int)param_2 + 0x19);
    }
    if (param_8 != (uint *)0x0) {
      *param_8 = (uint)*(byte *)((int)param_2 + 0x1a);
    }
    if (param_9 != (uint *)0x0) {
      *param_9 = (uint)*(byte *)((int)param_2 + 0x1b);
    }
    bVar1 = *(byte *)(param_2 + 7);
    if (param_7 != (uint *)0x0) {
      *param_7 = (uint)bVar1;
    }
    uVar2 = param_2[6];
    png_check_IHDR(param_1,*param_2,param_2[1],uVar2 & 0xff,(uVar2 << 0x10) >> 0x18,(uint)bVar1,
                   (uVar2 << 8) >> 0x18,uVar2 >> 0x18);
    uVar3 = 1;
  }
  return uVar3;
}



undefined4
png_get_oFFs(int param_1,int param_2,undefined4 *param_3,undefined4 *param_4,uint *param_5)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0 && param_2 != 0) &&
     (uVar1 = 0, param_5 != (uint *)0x0 && param_4 != (undefined4 *)0x0)) {
    if (param_3 == (undefined4 *)0x0) {
      return uVar1;
    }
    if ((*(uint *)(param_2 + 8) & 0x100) != 0) {
      *param_3 = *(undefined4 *)(param_2 + 0xb4);
      *param_4 = *(undefined4 *)(param_2 + 0xb8);
      *param_5 = (uint)*(byte *)(param_2 + 0xbc);
      uVar1 = 0x100;
    }
  }
  return uVar1;
}



undefined4
png_get_pCAL(int param_1,int param_2,undefined4 *param_3,undefined4 *param_4,undefined4 *param_5,
            uint *param_6,uint *param_7,undefined4 *param_8,undefined4 *param_9)

{
  ushort uVar1;
  undefined4 uVar2;
  uint *unaff_r4;
  
  uVar2 = 0;
  if (param_1 != 0 && param_2 != 0) {
    uVar2 = 0;
    if (param_9 == (undefined4 *)0x0) {
      return uVar2;
    }
    if (param_8 != (undefined4 *)0x0) {
      unaff_r4 = param_7;
    }
    if ((((param_8 != (undefined4 *)0x0 && unaff_r4 != (uint *)0x0) && (param_6 != (uint *)0x0)) &&
        (param_5 != (undefined4 *)0x0)) &&
       (((param_4 != (undefined4 *)0x0 && (param_3 != (undefined4 *)0x0)) &&
        ((*(uint *)(param_2 + 8) & 0x400) != 0)))) {
      *param_3 = *(undefined4 *)(param_2 + 0xd0);
      *param_4 = *(undefined4 *)(param_2 + 0xd4);
      *param_5 = *(undefined4 *)(param_2 + 0xd8);
      uVar1 = *(ushort *)(param_2 + 0xe4);
      *param_6 = uVar1 & 0xff;
      *unaff_r4 = (uint)(uVar1 >> 8);
      *param_8 = *(undefined4 *)(param_2 + 0xdc);
      *param_9 = *(undefined4 *)(param_2 + 0xe0);
      uVar2 = 0x400;
    }
  }
  return uVar2;
}



undefined4
png_get_sCAL_fixed(int param_1,int param_2,uint *param_3,undefined4 *param_4,undefined4 *param_5)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if ((*(byte *)(param_2 + 9) & 0x40) == 0) {
      uVar1 = 0;
    }
    else {
      *param_3 = (uint)*(byte *)(param_2 + 0xfc);
      strtod(*(char **)(param_2 + 0x100),(char **)0x0);
      uVar1 = png_fixed(param_1);
      *param_4 = uVar1;
      strtod(*(char **)(param_2 + 0x104),(char **)0x0);
      uVar1 = png_fixed(param_1);
      *param_5 = uVar1;
      uVar1 = 0x4000;
    }
  }
  return uVar1;
}



undefined4
png_get_sCAL(int param_1,int param_2,uint *param_3,undefined8 *param_4,undefined8 *param_5)

{
  undefined4 uVar1;
  char *pcVar2;
  undefined4 extraout_r1;
  undefined4 extraout_r1_00;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    if ((*(byte *)(param_2 + 9) & 0x40) == 0) {
      return 0;
    }
    *param_3 = (uint)*(byte *)(param_2 + 0xfc);
    pcVar2 = *(char **)(param_2 + 0x100);
    strtod(pcVar2,(char **)0x0);
    *param_4 = CONCAT44(extraout_r1,pcVar2);
    pcVar2 = *(char **)(param_2 + 0x104);
    strtod(pcVar2,(char **)0x0);
    uVar1 = 0x4000;
    *param_5 = CONCAT44(extraout_r1_00,pcVar2);
  }
  return uVar1;
}



undefined4
png_get_sCAL_s(int param_1,int param_2,uint *param_3,undefined4 *param_4,undefined4 *param_5)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 9) & 0x40) == 0) {
      return 0;
    }
    *param_3 = (uint)*(byte *)(param_2 + 0xfc);
    *param_4 = *(undefined4 *)(param_2 + 0x100);
    *param_5 = *(undefined4 *)(param_2 + 0x104);
    uVar1 = 0x4000;
  }
  return uVar1;
}



undefined4
png_get_pHYs(int param_1,int param_2,undefined4 *param_3,undefined4 *param_4,uint *param_5)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 8) & 0x80) == 0) {
      return 0;
    }
    if (param_3 == (undefined4 *)0x0) {
      uVar1 = 0;
    }
    else {
      *param_3 = *(undefined4 *)(param_2 + 0xc0);
      uVar1 = 0x80;
    }
    if (param_4 != (undefined4 *)0x0) {
      *param_4 = *(undefined4 *)(param_2 + 0xc4);
      uVar1 = 0x80;
    }
    if (param_5 != (uint *)0x0) {
      *param_5 = (uint)*(byte *)(param_2 + 200);
      uVar1 = 0x80;
    }
  }
  return uVar1;
}



undefined4 png_get_PLTE(int param_1,int param_2,undefined4 *param_3,uint *param_4)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    uVar1 = 0;
    if (param_3 == (undefined4 *)0x0) {
      return uVar1;
    }
    if ((*(uint *)(param_2 + 8) & 8) != 0) {
      *param_3 = *(undefined4 *)(param_2 + 0x10);
      *param_4 = (uint)*(ushort *)(param_2 + 0x14);
      uVar1 = 8;
    }
  }
  return uVar1;
}



undefined4 png_get_sBIT(int param_1,int param_2,int *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((((param_1 != 0) && (param_2 != 0)) && (uVar1 = 0, param_3 != (int *)0x0)) &&
     ((*(uint *)(param_2 + 8) & 2) != 0)) {
    *param_3 = param_2 + 0x94;
    uVar1 = 2;
  }
  return uVar1;
}



void png_get_text(int param_1,int param_2,undefined4 *param_3,int *param_4)

{
  int iVar1;
  
  if (((param_1 == 0) || (param_2 == 0)) || (iVar1 = *(int *)(param_2 + 0x80), iVar1 < 1)) {
    iVar1 = 0;
  }
  else if (param_3 != (undefined4 *)0x0) {
    *param_3 = *(undefined4 *)(param_2 + 0x88);
  }
  if (param_4 == (int *)0x0) {
    return;
  }
  *param_4 = iVar1;
  return;
}



undefined4 png_get_tIME(int param_1,int param_2,int *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if ((((param_1 != 0) && (param_2 != 0)) && (uVar1 = 0, param_3 != (int *)0x0)) &&
     ((*(uint *)(param_2 + 8) & 0x200) != 0)) {
    *param_3 = param_2 + 0x8c;
    uVar1 = 0x200;
  }
  return uVar1;
}



undefined4 png_get_tRNS(int param_1,int param_2,undefined4 *param_3,uint *param_4,int *param_5)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_1 != 0 && param_2 != 0) {
    if ((*(byte *)(param_2 + 8) & 0x10) == 0) {
      return 0;
    }
    if (*(char *)(param_2 + 0x19) == '\x03') {
      if (param_3 == (undefined4 *)0x0) {
        uVar1 = 0;
      }
      else {
        *param_3 = *(undefined4 *)(param_2 + 0x9c);
        uVar1 = 0x10;
      }
      if (param_5 != (int *)0x0) {
        *param_5 = param_2 + 0xa0;
      }
    }
    else {
      if (param_5 == (int *)0x0) {
        uVar1 = 0;
      }
      else {
        *param_5 = param_2 + 0xa0;
        uVar1 = 0x10;
      }
      if (param_3 != (undefined4 *)0x0) {
        *param_3 = 0;
      }
    }
    if (param_4 != (uint *)0x0) {
      *param_4 = (uint)*(ushort *)(param_2 + 0x16);
      uVar1 = 0x10;
    }
  }
  return uVar1;
}



undefined4 png_get_unknown_chunks(int param_1,int param_2,undefined4 *param_3)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (((param_1 != 0) && (param_2 != 0)) && (param_3 != (undefined4 *)0x0)) {
    *param_3 = *(undefined4 *)(param_2 + 0xec);
    uVar1 = *(undefined4 *)(param_2 + 0xf0);
  }
  return uVar1;
}



undefined1 png_get_rgb_to_gray_status(int param_1)

{
  undefined1 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined1 *)(param_1 + 0x2fc);
  }
  return uVar1;
}



undefined4 png_get_user_chunk_ptr(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x2e8);
  }
  return uVar1;
}



undefined4 png_get_compression_buffer_size(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    return 0;
  }
  if ((*(byte *)(param_1 + 0x131) & 0x80) == 0) {
    uVar1 = *(undefined4 *)(param_1 + 0x17c);
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x35c);
  }
  return uVar1;
}



undefined4 png_get_user_width_max(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x32c);
  }
  return uVar1;
}



undefined4 png_get_user_height_max(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x330);
  }
  return uVar1;
}



undefined4 png_get_chunk_cache_max(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x334);
  }
  return uVar1;
}



undefined4 png_get_chunk_malloc_max(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x338);
  }
  return uVar1;
}



undefined4 png_get_io_state(int param_1)

{
  return *(undefined4 *)(param_1 + 0x360);
}



undefined4 png_get_io_chunk_type(int param_1)

{
  return *(undefined4 *)(param_1 + 0x1d8);
}



undefined4 png_get_palette_max(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0xffffffff;
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = *(undefined4 *)(param_1 + 0x200);
  }
  return uVar1;
}



void png_destroy_png_struct(void *param_1)

{
  undefined1 auStack_3d0 [788];
  code *local_bc;
  int local_c;
  
  local_c = __stack_chk_guard;
  if (param_1 != (void *)0x0) {
    __aeabi_memcpy4(auStack_3d0,param_1,0x3c4);
    __aeabi_memclr4(param_1,0x3c4);
    if (local_bc == (code *)0x0) {
      free(param_1);
    }
    else {
      (*local_bc)(auStack_3d0,param_1);
    }
    png_free_jmpbuf(auStack_3d0);
  }
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_free(int param_1,void *param_2)

{
  if ((param_1 != 0) && (param_2 != (void *)0x0)) {
    if (*(code **)(param_1 + 0x314) == (code *)0x0) {
      free(param_2);
      return;
    }
                    // WARNING: Could not recover jumptable at 0x0001cbde. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 0x314))();
    return;
  }
  return;
}



int png_calloc(undefined4 param_1,undefined4 param_2)

{
  int iVar1;
  
  iVar1 = png_malloc();
  if (iVar1 != 0) {
    __aeabi_memclr(iVar1,param_2);
  }
  return iVar1;
}



void * png_malloc(int param_1,size_t param_2)

{
  void *pvVar1;
  
  if (param_1 == 0) {
    return (void *)0x0;
  }
  if (param_2 != 0) {
    if (*(code **)(param_1 + 0x310) == (code *)0x0) {
      pvVar1 = malloc(param_2);
    }
    else {
      pvVar1 = (void *)(**(code **)(param_1 + 0x310))(param_1);
    }
    if (pvVar1 != (void *)0x0) {
      return pvVar1;
    }
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"Out of memory");
}



void * png_malloc_base(int param_1,size_t param_2)

{
  void *pvVar1;
  
  if (param_2 == 0) {
    return (void *)0x0;
  }
  if ((param_1 != 0) && (*(code **)(param_1 + 0x310) != (code *)0x0)) {
                    // WARNING: Could not recover jumptable at 0x0001cc3a. Too many branches
                    // WARNING: Treating indirect jump as call
    pvVar1 = (void *)(**(code **)(param_1 + 0x310))();
    return pvVar1;
  }
  pvVar1 = malloc(param_2);
  return pvVar1;
}



void png_malloc_array(undefined4 param_1,int param_2,int param_3)

{
  if ((0 < param_2) && (param_3 != 0)) {
    FUN_0001cc60();
    return;
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"internal error: array alloc");
}



void * FUN_0001cc60(int param_1,uint param_2,code *param_3)

{
  uint uVar1;
  void *pvVar2;
  code *UNRECOVERED_JUMPTABLE;
  
  UNRECOVERED_JUMPTABLE = param_3;
  uVar1 = __aeabi_uidiv(0xffffffff,param_3);
  if ((uVar1 < param_2) || ((int)param_3 * param_2 == 0)) {
    return (void *)0x0;
  }
  if (param_1 != 0) {
    UNRECOVERED_JUMPTABLE = *(code **)(param_1 + 0x310);
  }
  if (param_1 == 0 || UNRECOVERED_JUMPTABLE == (code *)0x0) {
    pvVar2 = malloc((int)param_3 * param_2);
    return pvVar2;
  }
                    // WARNING: Could not recover jumptable at 0x0001cc9c. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar2 = (void *)(*UNRECOVERED_JUMPTABLE)(param_1);
  return pvVar2;
}



int png_realloc_array(undefined4 param_1,int param_2,int param_3,int param_4,int param_5)

{
  code *pcVar1;
  int iVar2;
  
  if ((((param_3 < 0) || (param_4 < 1)) || (param_5 == 0)) || ((param_2 == 0 && (0 < param_3)))) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"internal error: array realloc");
  }
  if (!SBORROW4(0x7fffffff,param_3)) {
    if (param_4 <= 0x7fffffff - param_3) {
      if (SBORROW4(param_3 + param_4,param_3)) goto LAB_0001cd20;
      iVar2 = FUN_0001cc60(param_1,param_3 + param_4,param_5);
      if (iVar2 != 0) {
        if (0 < param_3) {
          __aeabi_memcpy(iVar2,param_2,param_5 * param_3);
        }
        __aeabi_memclr(iVar2 + param_5 * param_3,param_5 * param_4);
        return iVar2;
      }
    }
    return 0;
  }
LAB_0001cd20:
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x1cd20);
  (*pcVar1)();
}



void * png_malloc_default(int param_1,size_t param_2)

{
  void *pvVar1;
  
  if (param_1 == 0) {
    pvVar1 = (void *)0x0;
  }
  else if ((param_2 == 0) || (pvVar1 = malloc(param_2), pvVar1 == (void *)0x0)) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"Out of Memory");
  }
  return pvVar1;
}



void * png_malloc_warn(int param_1,size_t param_2)

{
  void *pvVar1;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    if (*(code **)(param_1 + 0x310) == (code *)0x0) {
      pvVar1 = malloc(param_2);
    }
    else {
      pvVar1 = (void *)(**(code **)(param_1 + 0x310))();
    }
    if (pvVar1 != (void *)0x0) {
      return pvVar1;
    }
  }
  return (void *)0x0;
}



void png_free_default(int param_1,void *param_2)

{
  if ((param_1 != 0) && (param_2 != (void *)0x0)) {
    free(param_2);
    return;
  }
  return;
}



int png_set_mem_fn(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x30c) = param_2;
    *(undefined4 *)(param_1 + 0x310) = param_3;
    *(undefined4 *)(param_1 + 0x314) = param_4;
    param_1 = param_1 + 0x318;
  }
  return param_1;
}



undefined4 png_get_mem_ptr(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x30c);
  }
  return uVar1;
}



void png_process_data(int param_1,int param_2,undefined4 param_3,int param_4)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    *(undefined4 *)(param_1 + 0x298) = param_3;
    *(int *)(param_1 + 0x2b0) = param_4;
    param_4 = *(int *)(param_1 + 0x2a4) + param_4;
    *(int *)(param_1 + 0x2ac) = param_4;
    *(undefined4 *)(param_1 + 0x294) = param_3;
    while (param_4 != 0) {
      png_process_some_data(param_1,param_2);
      param_4 = *(int *)(param_1 + 0x2ac);
    }
  }
  return;
}



void png_push_restore_buffer(int param_1,undefined4 param_2,int param_3)

{
  *(undefined4 *)(param_1 + 0x298) = param_2;
  *(int *)(param_1 + 0x2b0) = param_3;
  *(int *)(param_1 + 0x2ac) = param_3 + *(int *)(param_1 + 0x2a4);
  *(undefined4 *)(param_1 + 0x294) = param_2;
  return;
}



void png_process_some_data(int param_1)

{
  int iVar1;
  
  if (param_1 != 0) {
    iVar1 = *(int *)(param_1 + 0x2b4);
    if (iVar1 == 2) {
      png_push_read_IDAT();
      return;
    }
    if (iVar1 == 1) {
      png_push_read_chunk();
      return;
    }
    if (iVar1 == 0) {
      png_push_read_sig();
      return;
    }
    *(undefined4 *)(param_1 + 0x2ac) = 0;
  }
  return;
}



int png_process_data_pause(int param_1,int param_2)

{
  uint uVar1;
  
  if (param_1 != 0) {
    if (param_2 == 0) {
      uVar1 = *(uint *)(param_1 + 0x2ac);
      *(undefined4 *)(param_1 + 0x2ac) = 0;
      if (*(uint *)(param_1 + 0x2a4) < uVar1) {
        return uVar1 - *(uint *)(param_1 + 0x2a4);
      }
    }
    else {
      png_push_save_buffer();
    }
  }
  return 0;
}



void png_push_save_buffer(int param_1)

{
  uint uVar1;
  undefined1 *puVar2;
  undefined1 *puVar3;
  int iVar4;
  undefined4 uVar5;
  int iVar6;
  
  uVar1 = *(uint *)(param_1 + 0x2a4);
  if (uVar1 == 0) {
    uVar1 = 0;
  }
  else {
    puVar2 = *(undefined1 **)(param_1 + 0x28c);
    puVar3 = *(undefined1 **)(param_1 + 0x290);
    if (*(undefined1 **)(param_1 + 0x28c) != *(undefined1 **)(param_1 + 0x290)) {
      do {
        uVar1 = uVar1 - 1;
        *puVar3 = *puVar2;
        puVar2 = puVar2 + 1;
        puVar3 = puVar3 + 1;
      } while (uVar1 != 0);
      uVar1 = *(uint *)(param_1 + 0x2a4);
    }
  }
  iVar4 = *(int *)(param_1 + 0x2b0);
  if (*(uint *)(param_1 + 0x2a8) < iVar4 + uVar1) {
    if (-iVar4 - 0x101U < uVar1) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Potential overflow of save_buffer");
    }
    iVar6 = iVar4 + uVar1 + 0x100;
    uVar5 = *(undefined4 *)(param_1 + 0x290);
    iVar4 = png_malloc_warn(param_1,iVar6);
    *(int *)(param_1 + 0x290) = iVar4;
    if (iVar4 == 0) {
      png_free(param_1,uVar5);
                    // WARNING: Subroutine does not return
      png_error(param_1,"Insufficient memory for save_buffer");
    }
    __aeabi_memcpy(iVar4,uVar5,*(undefined4 *)(param_1 + 0x2a4));
    png_free(param_1,uVar5);
    *(int *)(param_1 + 0x2a8) = iVar6;
    iVar4 = *(int *)(param_1 + 0x2b0);
  }
  if (iVar4 != 0) {
    __aeabi_memcpy(*(int *)(param_1 + 0x290) + *(int *)(param_1 + 0x2a4),
                   *(undefined4 *)(param_1 + 0x294));
    *(int *)(param_1 + 0x2a4) = *(int *)(param_1 + 0x2a4) + *(int *)(param_1 + 0x2b0);
    *(undefined4 *)(param_1 + 0x2b0) = 0;
  }
  *(undefined4 *)(param_1 + 0x28c) = *(undefined4 *)(param_1 + 0x290);
  *(undefined4 *)(param_1 + 0x2ac) = 0;
  return;
}



undefined4 png_process_data_skip(undefined4 param_1)

{
  png_app_warning(param_1,
                  "png_process_data_skip is not implemented in any current version of libpng");
  return 0;
}



void png_push_read_sig(int param_1,int param_2)

{
  int iVar1;
  uint uVar2;
  uint uVar3;
  bool bVar4;
  
  param_2 = param_2 + 0x20;
  uVar3 = (uint)*(byte *)(param_1 + 0x211);
  uVar2 = 8 - uVar3;
  if (*(uint *)(param_1 + 0x2ac) < 8 - uVar3) {
    uVar2 = *(uint *)(param_1 + 0x2ac);
  }
  png_push_fill_buffer(param_1,param_2 + uVar3,uVar2);
  *(char *)(param_1 + 0x211) = *(char *)(param_1 + 0x211) + (char)uVar2;
  iVar1 = png_sig_cmp(param_2,uVar3,uVar2);
  if (iVar1 == 0) {
    uVar2 = (uint)*(byte *)(param_1 + 0x211);
    bVar4 = 7 < uVar2;
    if (bVar4) {
      uVar2 = 1;
    }
    if (bVar4) {
      *(uint *)(param_1 + 0x2b4) = uVar2;
    }
    return;
  }
  if ((uVar3 < 4) && (iVar1 = png_sig_cmp(param_2,uVar3,uVar2 - 4), iVar1 != 0)) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"Not a PNG file");
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"PNG file corrupted by ASCII conversion");
}



void png_push_read_chunk(int param_1,uint param_2)

{
  byte bVar1;
  uint uVar2;
  undefined4 uVar3;
  uint extraout_r1;
  uint uVar4;
  int iVar5;
  int iVar6;
  bool bVar7;
  byte local_24;
  byte local_23;
  byte local_22;
  byte local_21;
  undefined1 auStack_20 [4];
  int local_1c;
  
  local_1c = __stack_chk_guard;
  uVar2 = *(uint *)(param_1 + 0x130);
  uVar4 = param_2;
  if ((uVar2 & 0x100) == 0) {
    if (7 < *(uint *)(param_1 + 0x2ac)) {
      png_push_fill_buffer(param_1,auStack_20,4);
      uVar3 = png_get_uint_31(param_1,auStack_20);
      *(undefined4 *)(param_1 + 0x29c) = uVar3;
      png_reset_crc(param_1);
      png_crc_read(param_1,&local_24,4);
      *(uint *)(param_1 + 0x1d8) =
           (uint)local_23 << 0x10 | (uint)local_24 << 0x18 | (uint)local_22 << 8 | (uint)local_21;
      png_check_chunk_name(param_1);
      uVar2 = *(uint *)(param_1 + 0x130) | 0x100;
      *(uint *)(param_1 + 0x130) = uVar2;
      uVar4 = extraout_r1;
      goto LAB_0001d00a;
    }
  }
  else {
LAB_0001d00a:
    iVar6 = *(int *)(param_1 + 0x1d8);
    if (iVar6 == 0x49444154) {
      bVar7 = (uVar2 & 8) != 0;
      if (bVar7) {
        uVar2 = uVar2 | 0x2000;
      }
      if (bVar7) {
        *(uint *)(param_1 + 0x130) = uVar2;
      }
      if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Missing IHDR before IDAT");
      }
      bVar7 = (uVar2 & 2) == 0;
      if (bVar7) {
        uVar4 = (uint)*(byte *)(param_1 + 0x20b);
      }
      if (bVar7 && uVar4 == 3) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Missing PLTE before IDAT");
      }
      *(uint *)(param_1 + 0x130) = uVar2 | 4;
      iVar5 = 2;
      bVar7 = (uVar2 & 0x2000) == 0;
      *(undefined4 *)(param_1 + 0x2b4) = 2;
      if (bVar7) {
        iVar5 = *(int *)(param_1 + 0x29c);
      }
      if (bVar7 && iVar5 == 0) goto LAB_0001d438;
      if ((uVar2 & 8) != 0) {
        png_benign_error(param_1,"Too many IDATs found");
      }
    }
    if (iVar6 == 0x49454e44) {
      if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
        png_handle_IEND(param_1,param_2);
        *(undefined4 *)(param_1 + 0x2b4) = 6;
        if (*(code **)(param_1 + 0x288) != (code *)0x0) {
          (**(code **)(param_1 + 0x288))(param_1,param_2);
        }
        goto LAB_0001d138;
      }
    }
    else if (iVar6 == 0x49484452) {
      if (*(int *)(param_1 + 0x29c) != 0xd) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Invalid IHDR length");
      }
      if (0x10 < *(uint *)(param_1 + 0x2ac)) {
        png_handle_IHDR(param_1,param_2,0xd);
        goto LAB_0001d138;
      }
    }
    else {
      iVar5 = png_chunk_unknown_handling(param_1,iVar6);
      if (iVar5 == 0) {
        if (iVar6 == 0x504c5445) {
          if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
            png_handle_PLTE(param_1,param_2);
            goto LAB_0001d138;
          }
        }
        else {
          if (iVar6 == 0x49444154) {
            *(undefined4 *)(param_1 + 0x1f0) = *(undefined4 *)(param_1 + 0x29c);
            *(undefined4 *)(param_1 + 0x2b4) = 2;
            if (*(code **)(param_1 + 0x280) != (code *)0x0) {
              (**(code **)(param_1 + 0x280))(param_1,param_2);
            }
            bVar1 = *(byte *)(param_1 + 0x20e);
            if (bVar1 < 8) {
              uVar4 = (uint)bVar1 * *(int *)(param_1 + 0x1d0) + 7 >> 3;
            }
            else {
              uVar4 = (uint)(bVar1 >> 3) * *(int *)(param_1 + 0x1d0);
            }
            *(uint *)(param_1 + 0x150) = uVar4 + 1;
            *(undefined4 *)(param_1 + 0x14c) = *(undefined4 *)(param_1 + 0x1e0);
            goto LAB_0001d438;
          }
          iVar5 = *(int *)(param_1 + 0x1d8);
          if (iVar5 == 0x6348524d) {
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_cHRM(param_1,param_2);
              goto LAB_0001d138;
            }
          }
          else if (iVar5 == 0x73424954) {
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_sBIT(param_1,param_2);
              goto LAB_0001d138;
            }
          }
          else if (iVar5 == 0x67414d41) {
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_gAMA(param_1,param_2);
              goto LAB_0001d138;
            }
          }
          else if (iVar6 == 0x73524742) {
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_sRGB(param_1,param_2);
              goto LAB_0001d138;
            }
          }
          else if (iVar5 == 0x69434350) {
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_iCCP(param_1,param_2);
              goto LAB_0001d138;
            }
          }
          else if (iVar6 < 0x7343414c) {
            if (iVar6 < 0x6f464673) {
              if (iVar6 == 0x624b4744) {
                if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                  png_handle_bKGD(param_1,param_2);
                  goto LAB_0001d138;
                }
              }
              else if (iVar6 == 0x68495354) {
                if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                  png_handle_hIST(param_1,param_2);
                  goto LAB_0001d138;
                }
              }
              else {
LAB_0001d40a:
                uVar4 = *(int *)(param_1 + 0x29c) + 4;
                if (iVar6 == 0x69545874) {
                  if (uVar4 <= *(uint *)(param_1 + 0x2ac)) {
                    png_handle_iTXt(param_1,param_2);
LAB_0001d138:
                    *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) & 0xfffffeff;
                    goto LAB_0001d438;
                  }
                }
                else if (uVar4 <= *(uint *)(param_1 + 0x2ac)) {
                  png_handle_unknown(param_1,param_2,*(int *)(param_1 + 0x29c),0);
                  goto LAB_0001d138;
                }
              }
            }
            else if (iVar6 == 0x6f464673) {
              if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                png_handle_oFFs(param_1,param_2);
                goto LAB_0001d138;
              }
            }
            else if (iVar6 == 0x7043414c) {
              if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                png_handle_pCAL(param_1,param_2);
                goto LAB_0001d138;
              }
            }
            else {
              if (iVar6 != 0x70485973) goto LAB_0001d40a;
              if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                png_handle_pHYs(param_1,param_2);
                goto LAB_0001d138;
              }
            }
          }
          else if (iVar6 < 0x74494d45) {
            if (iVar6 == 0x7343414c) {
              if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                png_handle_sCAL(param_1,param_2);
                goto LAB_0001d138;
              }
            }
            else if (iVar6 == 0x73504c54) {
              if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                png_handle_sPLT(param_1,param_2);
                goto LAB_0001d138;
              }
            }
            else {
              if (iVar6 != 0x74455874) goto LAB_0001d40a;
              if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
                png_handle_tEXt(param_1,param_2);
                goto LAB_0001d138;
              }
            }
          }
          else if (iVar6 == 0x74494d45) {
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_tIME(param_1,param_2);
              goto LAB_0001d138;
            }
          }
          else if (iVar6 == 0x74524e53) {
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_tRNS(param_1,param_2);
              goto LAB_0001d138;
            }
          }
          else {
            if (iVar6 != 0x7a545874) goto LAB_0001d40a;
            if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
              png_handle_zTXt(param_1,param_2);
              goto LAB_0001d138;
            }
          }
        }
      }
      else if (*(int *)(param_1 + 0x29c) + 4U <= *(uint *)(param_1 + 0x2ac)) {
        png_handle_unknown(param_1,param_2);
        uVar4 = 0x504c5445;
        if (iVar6 == 0x504c5445) {
          uVar4 = *(uint *)(param_1 + 0x130) | 2;
        }
        if (iVar6 == 0x504c5445) {
          *(uint *)(param_1 + 0x130) = uVar4;
        }
        goto LAB_0001d138;
      }
    }
  }
  png_push_save_buffer(param_1);
LAB_0001d438:
  if (__stack_chk_guard == local_1c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_push_read_IDAT(int param_1)

{
  undefined4 uVar1;
  uint uVar2;
  int iVar3;
  uint uVar4;
  byte local_1c;
  byte local_1b;
  byte local_1a;
  byte local_19;
  undefined1 auStack_18 [4];
  int local_14;
  
  local_14 = __stack_chk_guard;
  if ((*(byte *)(param_1 + 0x131) & 1) == 0) {
    if (7 < *(uint *)(param_1 + 0x2ac)) {
      png_push_fill_buffer(param_1,auStack_18,4);
      uVar1 = png_get_uint_31(param_1,auStack_18);
      *(undefined4 *)(param_1 + 0x29c) = uVar1;
      png_reset_crc(param_1);
      png_crc_read(param_1,&local_1c,4);
      uVar2 = (uint)local_1b << 0x10 | (uint)local_1c << 0x18 | (uint)local_1a << 8 | (uint)local_19
      ;
      *(uint *)(param_1 + 0x1d8) = uVar2;
      *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 0x100;
      if (uVar2 != 0x49444154) {
        *(undefined4 *)(param_1 + 0x2b4) = 1;
        if ((*(byte *)(param_1 + 0x134) & 8) == 0) {
                    // WARNING: Subroutine does not return
          png_error(param_1,"Not enough compressed data");
        }
        goto LAB_0001d610;
      }
      uVar2 = *(uint *)(param_1 + 0x29c);
      *(uint *)(param_1 + 0x1f0) = uVar2;
      goto LAB_0001d526;
    }
  }
  else {
    uVar2 = *(uint *)(param_1 + 0x1f0);
LAB_0001d526:
    if (uVar2 != 0) {
      uVar4 = *(uint *)(param_1 + 0x2a4);
      if (uVar4 != 0) {
        if (uVar2 < uVar4) {
          uVar4 = uVar2;
        }
        png_calculate_crc(param_1,*(undefined4 *)(param_1 + 0x28c),uVar4);
        png_process_IDAT_data(param_1,*(undefined4 *)(param_1 + 0x28c),uVar4);
        uVar2 = *(int *)(param_1 + 0x1f0) - uVar4;
        *(uint *)(param_1 + 0x1f0) = uVar2;
        *(uint *)(param_1 + 0x2ac) = *(int *)(param_1 + 0x2ac) - uVar4;
        *(uint *)(param_1 + 0x2a4) = *(int *)(param_1 + 0x2a4) - uVar4;
        *(uint *)(param_1 + 0x28c) = *(int *)(param_1 + 0x28c) + uVar4;
        if (uVar2 == 0) goto LAB_0001d5d0;
      }
      uVar4 = *(uint *)(param_1 + 0x2b0);
      if (uVar4 == 0) goto LAB_0001d610;
      if (uVar2 < uVar4) {
        uVar4 = uVar2;
      }
      png_calculate_crc(param_1,*(undefined4 *)(param_1 + 0x294),uVar4);
      png_process_IDAT_data(param_1,*(undefined4 *)(param_1 + 0x294),uVar4);
      iVar3 = *(int *)(param_1 + 0x1f0) - uVar4;
      *(int *)(param_1 + 0x1f0) = iVar3;
      *(uint *)(param_1 + 0x2ac) = *(int *)(param_1 + 0x2ac) - uVar4;
      *(uint *)(param_1 + 0x2b0) = *(int *)(param_1 + 0x2b0) - uVar4;
      *(uint *)(param_1 + 0x294) = *(int *)(param_1 + 0x294) + uVar4;
      if (iVar3 != 0) goto LAB_0001d610;
    }
LAB_0001d5d0:
    if (3 < *(uint *)(param_1 + 0x2ac)) {
      png_crc_finish(param_1,0);
      *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) & 0xfffffef7 | 8;
      *(undefined4 *)(param_1 + 0x13c) = 0;
      goto LAB_0001d610;
    }
  }
  png_push_save_buffer(param_1);
LAB_0001d610:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_push_fill_buffer(int param_1,int param_2,uint param_3)

{
  uint uVar1;
  
  if (param_1 != 0) {
    uVar1 = *(uint *)(param_1 + 0x2a4);
    if (uVar1 != 0) {
      if (param_3 < uVar1) {
        uVar1 = param_3;
      }
      __aeabi_memcpy(param_2,*(undefined4 *)(param_1 + 0x28c),uVar1);
      param_2 = param_2 + uVar1;
      param_3 = param_3 - uVar1;
      *(uint *)(param_1 + 0x2ac) = *(int *)(param_1 + 0x2ac) - uVar1;
      *(uint *)(param_1 + 0x2a4) = *(int *)(param_1 + 0x2a4) - uVar1;
      *(uint *)(param_1 + 0x28c) = *(int *)(param_1 + 0x28c) + uVar1;
    }
    if ((param_3 != 0) && (uVar1 = *(uint *)(param_1 + 0x2b0), uVar1 != 0)) {
      if (param_3 < uVar1) {
        uVar1 = param_3;
      }
      __aeabi_memcpy(param_2,*(undefined4 *)(param_1 + 0x294),uVar1);
      *(uint *)(param_1 + 0x2ac) = *(int *)(param_1 + 0x2ac) - uVar1;
      *(uint *)(param_1 + 0x2b0) = *(int *)(param_1 + 0x2b0) - uVar1;
      *(uint *)(param_1 + 0x294) = *(int *)(param_1 + 0x294) + uVar1;
    }
  }
  return;
}



void png_push_have_end(int param_1)

{
  if (*(code **)(param_1 + 0x288) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x0001d6c4. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 0x288))();
    return;
  }
  return;
}



void png_push_have_info(int param_1)

{
  if (*(code **)(param_1 + 0x280) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x0001d6ce. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 0x280))();
    return;
  }
  return;
}



void png_process_IDAT_data(int param_1,int param_2,int param_3)

{
  byte bVar1;
  uint uVar2;
  uint uVar3;
  bool bVar4;
  
  if ((param_2 == 0) || (param_3 == 0)) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"No IDAT data (internal error)");
  }
  *(int *)(param_1 + 0x140) = param_2;
  *(int *)(param_1 + 0x144) = param_3;
  do {
    if ((*(byte *)(param_1 + 0x134) & 8) != 0) {
      return;
    }
    if (*(int *)(param_1 + 0x150) == 0) {
      bVar1 = *(byte *)(param_1 + 0x20e);
      if (bVar1 < 8) {
        uVar2 = (uint)bVar1 * *(int *)(param_1 + 0x1d0) + 7 >> 3;
      }
      else {
        uVar2 = (uint)(bVar1 >> 3) * *(int *)(param_1 + 0x1d0);
      }
      *(uint *)(param_1 + 0x150) = uVar2 + 1;
      *(undefined4 *)(param_1 + 0x14c) = *(undefined4 *)(param_1 + 0x1e0);
    }
    uVar2 = inflate(param_1 + 0x140,2);
    if (1 < uVar2) {
      *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 8;
      *(undefined4 *)(param_1 + 0x13c) = 0;
      if (*(uint *)(param_1 + 0x1c4) <= *(uint *)(param_1 + 0x1d4)) {
        return;
      }
      if (*(byte *)(param_1 + 0x209) < 7) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Decompression error in IDAT");
      }
      return;
    }
    uVar3 = *(uint *)(param_1 + 0x14c);
    if (uVar3 != *(uint *)(param_1 + 0x1e0)) {
      uVar3 = *(uint *)(param_1 + 0x1c4);
      bVar4 = uVar3 <= *(uint *)(param_1 + 0x1d4);
      if (!bVar4) {
        uVar3 = (uint)*(byte *)(param_1 + 0x209);
      }
      if (bVar4 || 6 < uVar3) {
        *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 8;
        *(undefined4 *)(param_1 + 0x13c) = 0;
        return;
      }
      uVar3 = *(uint *)(param_1 + 0x150);
      if (uVar3 == 0) {
        uVar3 = png_push_process_row(param_1);
      }
    }
    if (uVar2 == 1) {
      uVar3 = *(uint *)(param_1 + 0x134) | 8;
    }
    if (uVar2 == 1) {
      *(uint *)(param_1 + 0x134) = uVar3;
    }
  } while (*(int *)(param_1 + 0x144) != 0);
  return;
}



void png_push_process_row(int param_1)

{
  byte bVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  byte *pbVar5;
  undefined4 uVar6;
  char cVar7;
  ushort uVar8;
  code *pcVar9;
  uint in_r12;
  bool bVar10;
  int local_20;
  uint local_1c;
  undefined1 local_18;
  undefined1 local_17;
  undefined1 local_16;
  byte local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  local_20 = *(int *)(param_1 + 0x1d0);
  local_18 = *(undefined1 *)(param_1 + 0x20b);
  iVar3 = *(int *)(param_1 + 0x20c);
  local_17 = (undefined1)iVar3;
  local_16 = (undefined1)((uint)iVar3 >> 0x18);
  local_15 = (byte)((uint)iVar3 >> 0x10);
  uVar4 = (uint)(iVar3 << 8) >> 0x18;
  if (uVar4 < 8) {
    local_1c = uVar4 * local_20 + 7 >> 3;
  }
  else {
    local_1c = local_20 * ((uint)(iVar3 << 8) >> 0x1b);
  }
  pbVar5 = *(byte **)(param_1 + 0x1e0);
  bVar1 = *pbVar5;
  if (bVar1 != 0) {
    if (4 < bVar1) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"bad adaptive filter value");
    }
    png_read_filter_row(param_1,&local_20,pbVar5 + 1,*(int *)(param_1 + 0x1dc) + 1,bVar1);
    pbVar5 = *(byte **)(param_1 + 0x1e0);
  }
  __aeabi_memcpy(*(undefined4 *)(param_1 + 0x1dc),pbVar5,local_1c + 1);
  if (*(int *)(param_1 + 0x138) != 0) {
    png_do_read_transformations(param_1,&local_20);
  }
  if (*(byte *)(param_1 + 0x213) == 0) {
    *(byte *)(param_1 + 0x213) = local_15;
    if (*(byte *)(param_1 + 0x212) < local_15) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"progressive row overflow");
    }
  }
  else if (*(byte *)(param_1 + 0x213) != local_15) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"internal progressive row size calculation error");
  }
  bVar10 = (*(ushort *)(param_1 + 0x208) & 0xff) != 0;
  if (bVar10) {
    in_r12 = *(uint *)(param_1 + 0x138);
  }
  uVar8 = *(ushort *)(param_1 + 0x208) >> 8;
  if (!bVar10 || (in_r12 & 2) == 0) {
    pcVar9 = *(code **)(param_1 + 0x284);
    if (pcVar9 != (code *)0x0) {
      uVar6 = *(undefined4 *)(param_1 + 0x1d4);
      iVar3 = *(int *)(param_1 + 0x1e0) + 1;
      goto LAB_0001dc68;
    }
    goto LAB_0001dc6a;
  }
  if (uVar8 < 6) {
    png_do_read_interlace(&local_20,*(int *)(param_1 + 0x1e0) + 1,uVar8,in_r12);
    uVar8 = (ushort)*(byte *)(param_1 + 0x209);
  }
  switch(uVar8) {
  case 0:
    if (uVar8 == 0) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))
                    (param_1,*(int *)(param_1 + 0x1e0) + 1,*(undefined4 *)(param_1 + 0x1d4),0);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
        uVar8 = (ushort)*(byte *)(param_1 + 0x209);
      } while ((iVar2 < 8) && (iVar3 = iVar2, uVar8 == 0));
    }
    if (uVar8 == 2) {
      iVar3 = 0;
      do {
        if (uVar8 != 2) break;
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))(param_1,0,*(undefined4 *)(param_1 + 0x1d4),2);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
        uVar8 = (ushort)*(byte *)(param_1 + 0x209);
        iVar3 = iVar2;
      } while (iVar2 < 4);
    }
    cVar7 = (char)uVar8;
    if ((uVar8 == 4) && (*(uint *)(param_1 + 0x1c0) < 5)) {
      cVar7 = '\x04';
      iVar3 = 0;
      do {
        if (cVar7 != '\x04') break;
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))(param_1,0,*(undefined4 *)(param_1 + 0x1d4),4);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) {
LAB_0001dc86:
                    // WARNING: Does not return
          pcVar9 = (code *)software_udf(0xfe,0x1dc86);
          (*pcVar9)();
        }
        cVar7 = *(char *)(param_1 + 0x209);
        iVar3 = iVar2;
      } while (iVar2 < 2);
    }
    if ((cVar7 != '\x06') || (4 < *(uint *)(param_1 + 0x1c0))) goto LAB_0001dc70;
    break;
  case 1:
    if (uVar8 == 1) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))
                    (param_1,*(int *)(param_1 + 0x1e0) + 1,*(undefined4 *)(param_1 + 0x1d4),1);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
        uVar8 = (ushort)*(byte *)(param_1 + 0x209);
      } while ((iVar2 < 8) && (iVar3 = iVar2, uVar8 == 1));
    }
    if (uVar8 == 2) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))(param_1,0,*(undefined4 *)(param_1 + 0x1d4),2);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
      } while ((iVar2 < 4) && (iVar3 = iVar2, *(char *)(param_1 + 0x209) == '\x02'));
    }
    goto LAB_0001dc70;
  case 2:
    iVar3 = 0;
    do {
      if (uVar8 != 2) break;
      if (*(code **)(param_1 + 0x284) != (code *)0x0) {
        (**(code **)(param_1 + 0x284))
                  (param_1,*(int *)(param_1 + 0x1e0) + 1,*(undefined4 *)(param_1 + 0x1d4),2);
      }
      png_read_push_finish_row(param_1);
      iVar2 = iVar3 + 1;
      if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
      uVar8 = (ushort)*(byte *)(param_1 + 0x209);
      iVar3 = iVar2;
    } while (iVar2 < 4);
    cVar7 = (char)uVar8;
    if (uVar8 == 2) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))(param_1,0,*(undefined4 *)(param_1 + 0x1d4),2);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
        cVar7 = *(char *)(param_1 + 0x209);
      } while ((iVar2 < 4) && (iVar3 = iVar2, cVar7 == '\x02'));
    }
    if (cVar7 == '\x04') {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))(param_1,0,*(undefined4 *)(param_1 + 0x1d4),4);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
      } while ((iVar2 < 2) && (iVar3 = iVar2, *(char *)(param_1 + 0x209) == '\x04'));
    }
    goto LAB_0001dc70;
  case 3:
    if (uVar8 == 3) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))
                    (param_1,*(int *)(param_1 + 0x1e0) + 1,*(undefined4 *)(param_1 + 0x1d4),3);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
        uVar8 = (ushort)*(byte *)(param_1 + 0x209);
      } while ((iVar2 < 4) && (iVar3 = iVar2, uVar8 == 3));
    }
    if (uVar8 == 4) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))(param_1,0,*(undefined4 *)(param_1 + 0x1d4),4);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
      } while ((iVar2 < 2) && (iVar3 = iVar2, *(char *)(param_1 + 0x209) == '\x04'));
    }
    goto LAB_0001dc70;
  case 4:
    iVar3 = 0;
    do {
      if (uVar8 != 4) break;
      if (*(code **)(param_1 + 0x284) != (code *)0x0) {
        (**(code **)(param_1 + 0x284))
                  (param_1,*(int *)(param_1 + 0x1e0) + 1,*(undefined4 *)(param_1 + 0x1d4),4);
      }
      png_read_push_finish_row(param_1);
      iVar2 = iVar3 + 1;
      if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
      uVar8 = (ushort)*(byte *)(param_1 + 0x209);
      iVar3 = iVar2;
    } while (iVar2 < 2);
    cVar7 = (char)uVar8;
    if (uVar8 == 4) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))(param_1,0,*(undefined4 *)(param_1 + 0x1d4),4);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
        cVar7 = *(char *)(param_1 + 0x209);
      } while ((iVar2 < 2) && (iVar3 = iVar2, cVar7 == '\x04'));
    }
    goto LAB_0001dc12;
  case 5:
    if (uVar8 == 5) {
      iVar3 = 0;
      do {
        if (*(code **)(param_1 + 0x284) != (code *)0x0) {
          (**(code **)(param_1 + 0x284))
                    (param_1,*(int *)(param_1 + 0x1e0) + 1,*(undefined4 *)(param_1 + 0x1d4),5);
        }
        png_read_push_finish_row(param_1);
        iVar2 = iVar3 + 1;
        if (SBORROW4(iVar2,iVar3)) goto LAB_0001dc86;
        uVar8 = (ushort)*(byte *)(param_1 + 0x209);
      } while ((iVar2 < 2) && (iVar3 = iVar2, uVar8 == 5));
    }
    if (uVar8 != 6) goto LAB_0001dc70;
    break;
  default:
    if (*(code **)(param_1 + 0x284) != (code *)0x0) {
      (**(code **)(param_1 + 0x284))
                (param_1,*(int *)(param_1 + 0x1e0) + 1,*(undefined4 *)(param_1 + 0x1d4));
    }
    png_read_push_finish_row(param_1);
    cVar7 = *(char *)(param_1 + 0x209);
LAB_0001dc12:
    if (cVar7 != '\x06') goto LAB_0001dc70;
  }
  pcVar9 = *(code **)(param_1 + 0x284);
  if (pcVar9 != (code *)0x0) {
    uVar6 = *(undefined4 *)(param_1 + 0x1d4);
    iVar3 = 0;
    uVar8 = 6;
LAB_0001dc68:
    (*pcVar9)(param_1,iVar3,uVar6,uVar8);
  }
LAB_0001dc6a:
  png_read_push_finish_row(param_1);
LAB_0001dc70:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_push_have_row(int param_1,undefined4 param_2)

{
  if (*(code **)(param_1 + 0x284) == (code *)0x0) {
    return;
  }
                    // WARNING: Could not recover jumptable at 0x0001dcc4. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(param_1 + 0x284))
            (param_1,param_2,*(undefined4 *)(param_1 + 0x1d4),*(undefined1 *)(param_1 + 0x209));
  return;
}



void png_read_push_finish_row(int param_1)

{
  ushort uVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  uint uVar5;
  undefined1 uVar6;
  uint uVar7;
  
  uVar2 = *(int *)(param_1 + 0x1d4) + 1;
  *(uint *)(param_1 + 0x1d4) = uVar2;
  if ((*(uint *)(param_1 + 0x1c4) <= uVar2) &&
     (uVar1 = *(ushort *)(param_1 + 0x208), (uVar1 & 0xff) != 0)) {
    *(undefined4 *)(param_1 + 0x1d4) = 0;
    __aeabi_memclr(*(undefined4 *)(param_1 + 0x1dc),*(int *)(param_1 + 0x1cc) + 1);
    uVar2 = (uint)(uVar1 >> 8);
    do {
      uVar5 = uVar2 & 0xff;
      if (uVar5 == 4) {
        if (*(uint *)(param_1 + 0x1bc) < 2) goto LAB_0001dd4c;
        uVar2 = 5;
        uVar5 = uVar2;
      }
      else {
        if (uVar5 == 2) {
          if (2 < *(uint *)(param_1 + 0x1bc)) {
            uVar2 = 3;
            uVar5 = uVar2;
            goto LAB_0001dd5e;
          }
LAB_0001dd4c:
          uVar7 = uVar2 + 2;
        }
        else {
          uVar7 = uVar2 + 1;
          if ((uVar5 == 0) && (*(uint *)(param_1 + 0x1bc) < 5)) goto LAB_0001dd4c;
        }
        uVar5 = uVar7 & 0xff;
        if (7 < uVar5) {
          *(char *)(param_1 + 0x209) = (char)uVar7 + -1;
          return;
        }
        uVar2 = uVar7;
        if (6 < uVar5) {
          uVar6 = 7;
          break;
        }
      }
LAB_0001dd5e:
      uVar6 = (undefined1)uVar2;
      iVar3 = __aeabi_uidiv((*(int *)(param_1 + 0x1bc) + (uint)(byte)(&DAT_000332c0)[uVar5] + -1) -
                            (uint)(byte)"0123456789ABCDEF"[uVar5 + 0x10]);
      *(int *)(param_1 + 0x1d0) = iVar3;
      if ((*(byte *)(param_1 + 0x138) & 2) != 0) break;
      iVar4 = __aeabi_uidiv((*(int *)(param_1 + 0x1c0) + (uint)(byte)(&UNK_000332ce)[uVar5] + -1) -
                            (uint)(byte)(&UNK_000332c7)[uVar5]);
      *(int *)(param_1 + 0x1c4) = iVar4;
    } while ((iVar4 == 0) || (iVar3 == 0));
    *(undefined1 *)(param_1 + 0x209) = uVar6;
  }
  return;
}



void png_progressive_combine_row(int param_1,undefined4 param_2,int param_3)

{
  if ((param_1 != 0) && (param_3 != 0)) {
    png_combine_row(param_1,param_2,1);
    return;
  }
  return;
}



void png_set_progressive_read_fn
               (int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
               undefined4 param_5)

{
  if (param_1 == 0) {
    return;
  }
  *(undefined4 *)(param_1 + 0x280) = param_3;
  *(undefined4 *)(param_1 + 0x284) = param_4;
  *(undefined4 *)(param_1 + 0x288) = param_5;
  png_set_read_fn(param_1,param_2,png_push_fill_buffer);
  return;
}



void png_create_read_struct(void)

{
  png_create_read_struct_2();
  return;
}



int png_create_read_struct_2(void)

{
  int iVar1;
  undefined4 in_r3;
  undefined4 in_stack_00000000;
  undefined4 in_stack_00000004;
  undefined4 in_stack_00000008;
  
  iVar1 = png_create_png_struct();
  if (iVar1 != 0) {
    *(undefined4 *)(iVar1 + 0x130) = 0x8000;
    *(undefined4 *)(iVar1 + 0x35c) = 0x2000;
    *(uint *)(iVar1 + 0x134) = *(uint *)(iVar1 + 0x134) | 0x100000;
    png_set_read_fn(iVar1,0,0,in_r3,in_stack_00000000,in_stack_00000004,in_stack_00000008);
  }
  return iVar1;
}



void png_read_info(int param_1,int param_2)

{
  undefined4 uVar1;
  uint uVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  bool bVar6;
  undefined8 uVar7;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    png_read_sig(param_1,param_2);
LAB_0001dea8:
    do {
      uVar7 = png_read_chunk_header(param_1);
      uVar4 = (uint)((ulonglong)uVar7 >> 0x20);
      uVar1 = (undefined4)uVar7;
      iVar5 = *(int *)(param_1 + 0x1d8);
      uVar2 = *(uint *)(param_1 + 0x130);
      if (iVar5 == 0x49444154) {
        if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
          png_chunk_error(param_1,"Missing IHDR before IDAT");
        }
        bVar6 = (uVar2 & 2) == 0;
        if (bVar6) {
          uVar4 = (uint)*(byte *)(param_1 + 0x20b);
        }
        if (bVar6 && uVar4 == 3) {
                    // WARNING: Subroutine does not return
          png_chunk_error(param_1,"Missing PLTE before IDAT");
        }
        if ((uVar2 & 8) != 0) {
          png_chunk_benign_error(param_1,"Too many IDATs found");
          uVar2 = *(uint *)(param_1 + 0x130);
        }
        uVar2 = uVar2 | 4;
LAB_0001def8:
        *(uint *)(param_1 + 0x130) = uVar2;
      }
      else if ((uVar2 & 4) != 0) {
        uVar2 = uVar2 | 8;
        goto LAB_0001def8;
      }
      if (iVar5 == 0x49454e44) {
        png_handle_IEND(param_1,param_2,uVar1);
        goto LAB_0001dea8;
      }
      if (iVar5 == 0x49484452) {
        png_handle_IHDR(param_1,param_2,uVar1);
        goto LAB_0001dea8;
      }
      iVar3 = png_chunk_unknown_handling(param_1,iVar5);
      if (iVar3 == 0) {
        if (iVar5 == 0x504c5445) {
          png_handle_PLTE(param_1,param_2,uVar1);
          goto LAB_0001dea8;
        }
        if (iVar5 == 0x49444154) {
          *(undefined4 *)(param_1 + 0x1f0) = uVar1;
          return;
        }
        if (iVar5 < 0x70485973) {
          if (iVar5 < 0x69434350) {
            if (iVar5 < 0x67414d41) {
              if (iVar5 == 0x624b4744) {
                png_handle_bKGD(param_1,param_2,uVar1);
                goto LAB_0001dea8;
              }
              if (iVar5 == 0x6348524d) {
                png_handle_cHRM(param_1,param_2,uVar1);
                goto LAB_0001dea8;
              }
            }
            else {
              if (iVar5 == 0x67414d41) {
                png_handle_gAMA(param_1,param_2,uVar1);
                goto LAB_0001dea8;
              }
              if (iVar5 == 0x68495354) {
                png_handle_hIST(param_1,param_2,uVar1);
                goto LAB_0001dea8;
              }
            }
          }
          else if (iVar5 < 0x6f464673) {
            if (iVar5 == 0x69434350) {
              png_handle_iCCP(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
            if (iVar5 == 0x69545874) {
              png_handle_iTXt(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
          }
          else {
            if (iVar5 == 0x6f464673) {
              png_handle_oFFs(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
            if (iVar5 == 0x7043414c) {
              png_handle_pCAL(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
          }
        }
        else if (iVar5 < 0x73524742) {
          if (iVar5 < 0x7343414c) {
            if (iVar5 == 0x70485973) {
              png_handle_pHYs(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
            if (iVar5 == 0x73424954) {
              png_handle_sBIT(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
          }
          else {
            if (iVar5 == 0x7343414c) {
              png_handle_sCAL(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
            if (iVar5 == 0x73504c54) {
              png_handle_sPLT(param_1,param_2,uVar1);
              goto LAB_0001dea8;
            }
          }
        }
        else if (iVar5 < 0x74494d45) {
          if (iVar5 == 0x73524742) {
            png_handle_sRGB(param_1,param_2,uVar1);
            goto LAB_0001dea8;
          }
          if (iVar5 == 0x74455874) {
            png_handle_tEXt(param_1,param_2,uVar1);
            goto LAB_0001dea8;
          }
        }
        else {
          if (iVar5 == 0x74494d45) {
            png_handle_tIME(param_1,param_2,uVar1);
            goto LAB_0001dea8;
          }
          if (iVar5 == 0x74524e53) {
            png_handle_tRNS(param_1,param_2,uVar1);
            goto LAB_0001dea8;
          }
          if (iVar5 == 0x7a545874) {
            png_handle_zTXt(param_1,param_2,uVar1);
            goto LAB_0001dea8;
          }
        }
        png_handle_unknown(param_1,param_2,uVar1,0);
        goto LAB_0001dea8;
      }
      png_handle_unknown(param_1,param_2,uVar1);
      if (iVar5 == 0x504c5445) {
        *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 2;
        goto LAB_0001dea8;
      }
    } while (iVar5 != 0x49444154);
    *(undefined4 *)(param_1 + 0x1f0) = 0;
  }
  return;
}



void png_read_update_info(int param_1,undefined4 param_2)

{
  if (param_1 == 0) {
    return;
  }
  if ((*(byte *)(param_1 + 0x134) & 0x40) != 0) {
    png_app_error(param_1,"png_read_update_info/png_start_read_image: duplicate call");
    return;
  }
  png_read_start_row(param_1);
  png_read_transform_info(param_1,param_2);
  return;
}



void png_start_read_image(int param_1)

{
  if (param_1 == 0) {
    return;
  }
  if ((*(byte *)(param_1 + 0x134) & 0x40) != 0) {
    png_app_error(param_1,"png_start_read_image/png_read_update_info: duplicate call");
    return;
  }
  png_read_start_row();
  return;
}



void png_read_row(int param_1,int param_2,int param_3,uint param_4)

{
  byte bVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  byte *pbVar5;
  char *pcVar6;
  undefined1 *puVar7;
  undefined4 uVar8;
  int iVar9;
  uint uVar10;
  bool bVar11;
  int local_2c;
  uint local_28;
  ushort local_24;
  undefined1 local_22;
  byte local_21;
  int local_20;
  
  local_20 = __stack_chk_guard;
  if (param_1 == 0) goto LAB_0001e4c0;
  if ((*(byte *)(param_1 + 0x134) & 0x40) == 0) {
    png_read_start_row(param_1);
  }
  local_2c = *(int *)(param_1 + 0x1d0);
  iVar3 = *(int *)(param_1 + 0x20c);
  local_24 = *(ushort *)(param_1 + 0x20b);
  local_22 = (undefined1)((uint)iVar3 >> 0x18);
  local_21 = (byte)((uint)iVar3 >> 0x10);
  uVar4 = (uint)(iVar3 << 8) >> 0x18;
  if (uVar4 < 8) {
    uVar10 = uVar4 * local_2c + 7 >> 3;
  }
  else {
    uVar4 = (uint)(iVar3 << 8) >> 0x1b;
    uVar10 = local_2c * uVar4;
  }
  bVar11 = (*(ushort *)(param_1 + 0x208) & 0xff) != 0;
  if (bVar11) {
    uVar4 = (uint)*(byte *)(param_1 + 0x138);
  }
  local_28 = uVar10;
  if (bVar11 && (uVar4 & 2) != 0) {
    switch(*(ushort *)(param_1 + 0x208) >> 8) {
    case 0:
      if ((*(byte *)(param_1 + 0x1d4) & 7) != 0) {
LAB_0001e2f8:
        if (param_3 != 0) goto LAB_0001e2fe;
LAB_0001e308:
        png_read_finish_row(param_1);
        goto LAB_0001e4c0;
      }
      break;
    case 1:
      if (((*(byte *)(param_1 + 0x1d4) & 7) != 0) || (*(uint *)(param_1 + 0x1bc) < 5))
      goto LAB_0001e2f8;
      break;
    case 2:
      if ((*(uint *)(param_1 + 0x1d4) & 7) != 4) {
        if ((param_3 == 0) || ((*(uint *)(param_1 + 0x1d4) & 4) == 0)) goto LAB_0001e308;
LAB_0001e2fe:
        png_combine_row(param_1,param_3,1);
        goto LAB_0001e308;
      }
      break;
    case 3:
      if (((*(byte *)(param_1 + 0x1d4) & 3) != 0) || (*(uint *)(param_1 + 0x1bc) < 3))
      goto LAB_0001e2f8;
      break;
    case 4:
      if ((*(uint *)(param_1 + 0x1d4) & 3) != 2) {
        if ((param_3 != 0) && ((*(uint *)(param_1 + 0x1d4) & 2) != 0)) goto LAB_0001e2fe;
        goto LAB_0001e308;
      }
      break;
    case 5:
      if (((*(byte *)(param_1 + 0x1d4) & 1) != 0) || (*(uint *)(param_1 + 0x1bc) < 2))
      goto LAB_0001e2f8;
      break;
    default:
      if ((*(byte *)(param_1 + 0x1d4) & 1) == 0) goto LAB_0001e308;
    }
  }
  if ((*(byte *)(param_1 + 0x130) & 4) == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"Invalid attempt to read row data");
  }
  png_read_IDAT_data(param_1,*(undefined4 *)(param_1 + 0x1e0),uVar10 + 1);
  pbVar5 = *(byte **)(param_1 + 0x1e0);
  bVar1 = *pbVar5;
  if (bVar1 != 0) {
    if (4 < bVar1) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"bad adaptive filter value");
    }
    param_4 = *(int *)(param_1 + 0x1dc) + 1;
    png_read_filter_row(param_1,&local_2c,pbVar5 + 1,param_4,bVar1);
    pbVar5 = *(byte **)(param_1 + 0x1e0);
    uVar10 = local_28;
  }
  __aeabi_memcpy(*(undefined4 *)(param_1 + 0x1dc),pbVar5,uVar10 + 1);
  if ((((*(byte *)(param_1 + 0x304) & 4) != 0) && (*(char *)(param_1 + 0x308) == '@')) &&
     ((local_24 & 2) != 0)) {
    param_4 = 0;
    if (local_24 >> 8 == 0x10) {
      if ((local_24 & 0xff) == 2) {
        iVar3 = 6;
      }
      else {
        if ((local_24 & 0xff) != 6) goto LAB_0001e40e;
        iVar3 = 8;
      }
      if (local_2c != 0) {
        puVar7 = (undefined1 *)(*(int *)(param_1 + 0x1e0) + 6);
        iVar2 = local_2c;
        do {
          iVar2 = iVar2 + -1;
          iVar9 = (uint)CONCAT11(puVar7[-5],puVar7[-4]) + (uint)CONCAT11(puVar7[-3],puVar7[-2]);
          puVar7[-5] = (char)((uint)iVar9 >> 8);
          puVar7[-4] = (char)iVar9;
          uVar4 = (uint)CONCAT11(puVar7[-3],puVar7[-2]) + (uint)CONCAT11(puVar7[-1],*puVar7);
          param_4 = uVar4 >> 8;
          puVar7[-1] = (char)(uVar4 >> 8);
          *puVar7 = (char)uVar4;
          puVar7 = puVar7 + iVar3;
        } while (iVar2 != 0);
      }
    }
    else {
      param_4 = (uint)(local_24 >> 8);
      if (param_4 == 8) {
        if ((local_24 & 0xff) == 2) {
          iVar3 = 3;
        }
        else {
          if ((local_24 & 0xff) != 6) goto LAB_0001e40e;
          iVar3 = 4;
        }
        if (local_2c != 0) {
          pcVar6 = (char *)(*(int *)(param_1 + 0x1e0) + 1);
          iVar2 = local_2c;
          do {
            iVar2 = iVar2 + -1;
            *pcVar6 = *pcVar6 + pcVar6[1];
            param_4 = (uint)(byte)pcVar6[2] + (uint)(byte)pcVar6[1];
            pcVar6[2] = (char)param_4;
            pcVar6 = pcVar6 + iVar3;
          } while (iVar2 != 0);
        }
      }
    }
  }
LAB_0001e40e:
  if (*(int *)(param_1 + 0x138) != 0) {
    png_do_read_transformations(param_1,&local_2c);
  }
  if (*(byte *)(param_1 + 0x213) == 0) {
    *(byte *)(param_1 + 0x213) = local_21;
    if (*(byte *)(param_1 + 0x212) < local_21) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"sequential row overflow");
    }
  }
  else if (*(byte *)(param_1 + 0x213) != local_21) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"internal sequential row size calculation error");
  }
  bVar11 = (*(ushort *)(param_1 + 0x208) & 0xff) != 0;
  if (bVar11) {
    param_4 = *(uint *)(param_1 + 0x138);
  }
  if (bVar11 && (param_4 & 2) != 0) {
    if (*(ushort *)(param_1 + 0x208) >> 8 < 6) {
      png_do_read_interlace(&local_2c,*(int *)(param_1 + 0x1e0) + 1);
    }
    if (param_3 != 0) {
      png_combine_row(param_1,param_3,1);
    }
    if (param_2 != 0) {
      uVar8 = 0;
      goto LAB_0001e4a4;
    }
  }
  else {
    if (param_2 != 0) {
      png_combine_row(param_1,param_2,0xffffffff);
    }
    if (param_3 != 0) {
      uVar8 = 0xffffffff;
      param_2 = param_3;
LAB_0001e4a4:
      png_combine_row(param_1,param_2,uVar8);
    }
  }
  png_read_finish_row(param_1);
  if (*(code **)(param_1 + 0x278) != (code *)0x0) {
    (**(code **)(param_1 + 0x278))
              (param_1,*(undefined4 *)(param_1 + 0x1d4),*(undefined1 *)(param_1 + 0x209));
  }
LAB_0001e4c0:
  if (__stack_chk_guard == local_20) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_read_rows(int param_1,undefined4 *param_2,undefined4 *param_3,int param_4)

{
  if (param_1 != 0) {
    if ((param_2 == (undefined4 *)0x0) || (param_3 == (undefined4 *)0x0)) {
      if (param_2 == (undefined4 *)0x0) {
        if ((param_3 != (undefined4 *)0x0) && (param_4 != 0)) {
          do {
            png_read_row(param_1,0,*param_3);
            param_4 = param_4 + -1;
            param_3 = param_3 + 1;
          } while (param_4 != 0);
        }
      }
      else if (param_4 != 0) {
        do {
          png_read_row(param_1,*param_2,0);
          param_4 = param_4 + -1;
          param_2 = param_2 + 1;
        } while (param_4 != 0);
      }
    }
    else if (param_4 != 0) {
      do {
        png_read_row(param_1,*param_2,*param_3);
        param_4 = param_4 + -1;
        param_3 = param_3 + 1;
        param_2 = param_2 + 1;
      } while (param_4 != 0);
    }
  }
  return;
}



void png_read_image(int param_1,undefined4 *param_2)

{
  code *pcVar1;
  int iVar2;
  undefined4 *puVar3;
  int iVar4;
  uint uVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  bool bVar9;
  
  if (param_1 != 0) {
    if ((*(byte *)(param_1 + 0x134) & 0x40) == 0) {
      iVar4 = png_set_interlace_handling(param_1);
      png_start_read_image(param_1);
    }
    else {
      if (*(char *)(param_1 + 0x208) != '\0') {
        uVar5 = (uint)*(byte *)(param_1 + 0x138);
        bVar9 = (*(byte *)(param_1 + 0x138) & 2) == 0;
        if (bVar9) {
          uVar5 = *(uint *)(param_1 + 0x1c0);
        }
        if (bVar9) {
          *(uint *)(param_1 + 0x1c4) = uVar5;
        }
      }
      iVar4 = png_set_interlace_handling(param_1);
    }
    if (0 < iVar4) {
      iVar8 = *(int *)(param_1 + 0x1c0);
      iVar2 = iVar8;
      puVar3 = param_2;
      iVar7 = 0;
      do {
        for (; iVar2 != 0; iVar2 = iVar2 + -1) {
          png_read_row(param_1,*puVar3,0);
          puVar3 = puVar3 + 1;
        }
        iVar6 = iVar7 + 1;
        if (SBORROW4(iVar6,iVar7)) {
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x1e5e6);
          (*pcVar1)();
        }
        iVar2 = iVar8;
        puVar3 = param_2;
        iVar7 = iVar6;
      } while (iVar6 < iVar4);
    }
  }
  return;
}



void png_read_end(int param_1,int param_2)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  
  if (param_1 != 0) {
    iVar1 = png_chunk_unknown_handling(param_1,0x49444154);
    if (iVar1 == 0) {
      png_read_finish_IDAT(param_1);
    }
    if ((*(char *)(param_1 + 0x20b) == '\x03') &&
       ((int)(uint)*(ushort *)(param_1 + 0x1fc) < *(int *)(param_1 + 0x200))) {
      png_benign_error(param_1,"Read palette index exceeding num_palette");
    }
    do {
      iVar1 = png_read_chunk_header(param_1);
      iVar4 = *(int *)(param_1 + 0x1d8);
      if (iVar4 == 0x49484452) {
        png_handle_IHDR(param_1,param_2,iVar1);
      }
      else if (iVar4 == 0x49454e44) {
        png_handle_IEND(param_1,param_2,iVar1);
      }
      else if (param_2 == 0) {
LAB_0001e8e2:
        png_crc_finish(param_1,iVar1);
      }
      else {
        iVar2 = png_chunk_unknown_handling(param_1,iVar4);
        if (iVar2 == 0) {
          if (iVar4 == 0x49444154) {
            if ((iVar1 != 0) || ((*(byte *)(param_1 + 0x131) & 0x20) != 0)) {
              png_benign_error(param_1,"Too many IDATs found");
            }
            goto LAB_0001e8e2;
          }
          if (iVar4 < 0x70485973) {
            if (iVar4 < 0x68495354) {
              if (iVar4 < 0x6348524d) {
                if (iVar4 == 0x504c5445) {
                  png_handle_PLTE(param_1,param_2,iVar1);
                }
                else {
                  if (iVar4 != 0x624b4744) {
LAB_0001e856:
                    iVar2 = 0;
                    goto LAB_0001e8c0;
                  }
                  png_handle_bKGD(param_1,param_2,iVar1);
                }
              }
              else if (iVar4 == 0x6348524d) {
                png_handle_cHRM(param_1,param_2,iVar1);
              }
              else {
                if (iVar4 != 0x67414d41) goto LAB_0001e856;
                png_handle_gAMA(param_1,param_2,iVar1);
              }
            }
            else if (iVar4 < 0x69545874) {
              if (iVar4 == 0x68495354) {
                png_handle_hIST(param_1,param_2,iVar1);
              }
              else {
                if (iVar4 != 0x69434350) goto LAB_0001e856;
                png_handle_iCCP(param_1,param_2,iVar1);
              }
            }
            else if (iVar4 == 0x69545874) {
              png_handle_iTXt(param_1,param_2,iVar1);
            }
            else if (iVar4 == 0x6f464673) {
              png_handle_oFFs(param_1,param_2,iVar1);
            }
            else {
              if (iVar4 != 0x7043414c) goto LAB_0001e856;
              png_handle_pCAL(param_1,param_2,iVar1);
            }
          }
          else if (iVar4 < 0x73524742) {
            if (iVar4 < 0x7343414c) {
              if (iVar4 == 0x70485973) {
                png_handle_pHYs(param_1,param_2,iVar1);
              }
              else {
                if (iVar4 != 0x73424954) goto LAB_0001e856;
                png_handle_sBIT(param_1,param_2,iVar1);
              }
            }
            else if (iVar4 == 0x7343414c) {
              png_handle_sCAL(param_1,param_2,iVar1);
            }
            else {
              if (iVar4 != 0x73504c54) goto LAB_0001e856;
              png_handle_sPLT(param_1,param_2,iVar1);
            }
          }
          else if (iVar4 < 0x74494d45) {
            if (iVar4 == 0x73524742) {
              png_handle_sRGB(param_1,param_2,iVar1);
            }
            else {
              if (iVar4 != 0x74455874) goto LAB_0001e856;
              png_handle_tEXt(param_1,param_2,iVar1);
            }
          }
          else if (iVar4 == 0x74494d45) {
            png_handle_tIME(param_1,param_2,iVar1);
          }
          else if (iVar4 == 0x74524e53) {
            png_handle_tRNS(param_1,param_2,iVar1);
          }
          else {
            if (iVar4 != 0x7a545874) goto LAB_0001e856;
            png_handle_zTXt(param_1,param_2,iVar1);
          }
        }
        else if (iVar4 == 0x49444154) {
          if ((iVar1 != 0) || ((*(byte *)(param_1 + 0x131) & 0x20) != 0)) {
            png_benign_error(param_1,"Too many IDATs found");
          }
LAB_0001e8c0:
          png_handle_unknown(param_1,param_2,iVar1,iVar2);
        }
        else {
          png_handle_unknown(param_1,param_2,iVar1,iVar2);
          uVar3 = 0x504c5445;
          if (iVar4 == 0x504c5445) {
            uVar3 = *(uint *)(param_1 + 0x130) | 2;
          }
          if (iVar4 == 0x504c5445) {
            *(uint *)(param_1 + 0x130) = uVar3;
          }
        }
      }
    } while ((*(byte *)(param_1 + 0x130) & 0x10) == 0);
  }
  return;
}



void png_destroy_read_struct(int *param_1,undefined4 param_2,undefined4 param_3)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  
  if ((param_1 != (int *)0x0) && (iVar3 = *param_1, iVar3 != 0)) {
    png_destroy_info_struct(iVar3,param_3);
    png_destroy_info_struct(iVar3,param_2);
    *param_1 = 0;
    png_destroy_gamma_table(iVar3);
    png_free(iVar3,*(undefined4 *)(iVar3 + 0x318));
    *(undefined4 *)(iVar3 + 0x318) = 0;
    png_free(iVar3,*(undefined4 *)(iVar3 + 0x364));
    *(undefined4 *)(iVar3 + 0x364) = 0;
    png_free(iVar3,*(undefined4 *)(iVar3 + 0x354));
    *(undefined4 *)(iVar3 + 0x354) = 0;
    png_free(iVar3,*(undefined4 *)(iVar3 + 700));
    *(undefined4 *)(iVar3 + 700) = 0;
    png_free(iVar3,*(undefined4 *)(iVar3 + 0x2c0));
    *(undefined4 *)(iVar3 + 0x2c0) = 0;
    uVar1 = *(uint *)(iVar3 + 0x2e4);
    if ((uVar1 & 0x1000) != 0) {
      png_zfree(iVar3,*(undefined4 *)(iVar3 + 0x1f8));
      *(undefined4 *)(iVar3 + 0x1f8) = 0;
      uVar1 = *(uint *)(iVar3 + 0x2e4);
    }
    uVar2 = uVar1 & 0xffffefff;
    *(uint *)(iVar3 + 0x2e4) = uVar2;
    if ((uVar1 & 0x2000) != 0) {
      png_free(iVar3,*(undefined4 *)(iVar3 + 0x268));
      *(undefined4 *)(iVar3 + 0x268) = 0;
      uVar2 = *(uint *)(iVar3 + 0x2e4);
    }
    *(uint *)(iVar3 + 0x2e4) = uVar2 & 0xffffdfff;
    inflateEnd(iVar3 + 0x140);
    png_free(iVar3,*(undefined4 *)(iVar3 + 0x290));
    *(undefined4 *)(iVar3 + 0x290) = 0;
    png_free(iVar3,*(undefined4 *)(iVar3 + 0x344));
    *(undefined4 *)(iVar3 + 0x344) = 0;
    png_free(iVar3,*(undefined4 *)(iVar3 + 0x2f8));
    *(undefined4 *)(iVar3 + 0x2f8) = 0;
    png_destroy_png_struct(iVar3);
    return;
  }
  return;
}



void png_set_read_status_fn(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x278) = param_2;
  }
  return;
}



void png_read_png(int param_1,int param_2,uint param_3)

{
  uint uVar1;
  undefined4 *puVar2;
  undefined4 uVar3;
  uint uVar4;
  bool bVar5;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    png_read_info(param_1,param_2);
    uVar1 = *(uint *)(param_2 + 4);
    if (uVar1 < 0x40000000) {
      if ((param_3 & 0x8000) != 0) {
        uVar1 = png_set_scale_16();
      }
      if ((param_3 & 1) != 0) {
        uVar1 = png_set_strip_16();
      }
      if ((param_3 & 2) != 0) {
        uVar1 = png_set_strip_alpha();
      }
      if ((param_3 & 4) != 0) {
        uVar1 = png_set_packing();
      }
      if ((param_3 & 8) != 0) {
        uVar1 = png_set_packswap();
      }
      if ((param_3 & 0x10) != 0) {
        uVar1 = png_set_palette_to_rgb();
      }
      if ((param_3 & 0x20) != 0) {
        uVar1 = png_set_invert_mono();
      }
      bVar5 = (param_3 & 0x40) != 0;
      if (bVar5) {
        uVar1 = (uint)*(byte *)(param_2 + 8);
      }
      if (bVar5 && (uVar1 & 2) != 0) {
        png_set_shift(param_1,param_2 + 0x94);
      }
      if ((param_3 & 0x80) != 0) {
        png_set_bgr(param_1);
      }
      if ((param_3 & 0x100) != 0) {
        png_set_swap_alpha(param_1);
      }
      if ((param_3 & 0x200) != 0) {
        png_set_swap(param_1);
      }
      if ((param_3 & 0x400) != 0) {
        png_set_invert_alpha(param_1);
      }
      if ((param_3 & 0x2000) != 0) {
        png_set_gray_to_rgb(param_1);
      }
      if ((param_3 & 0x4000) != 0) {
        png_set_expand_16(param_1);
      }
      png_set_interlace_handling(param_1);
      png_read_update_info(param_1,param_2);
      png_free_data(param_1,param_2,0x40,0);
      if (*(int *)(param_2 + 0x108) == 0) {
        puVar2 = (undefined4 *)png_malloc(param_1,*(int *)(param_2 + 4) << 2);
        *(undefined4 **)(param_2 + 0x108) = puVar2;
        if (*(int *)(param_2 + 4) == 0) {
          *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x40;
        }
        else {
          *puVar2 = 0;
          uVar1 = *(uint *)(param_2 + 4);
          if (1 < uVar1) {
            uVar4 = 1;
            do {
              *(undefined4 *)(*(int *)(param_2 + 0x108) + uVar4 * 4) = 0;
              uVar4 = uVar4 + 1;
              uVar1 = *(uint *)(param_2 + 4);
            } while (uVar4 < uVar1);
          }
          *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x40;
          if (uVar1 != 0) {
            uVar1 = 0;
            do {
              uVar3 = png_malloc(param_1,*(undefined4 *)(param_2 + 0xc));
              *(undefined4 *)(*(int *)(param_2 + 0x108) + uVar1 * 4) = uVar3;
              uVar1 = uVar1 + 1;
            } while (uVar1 < *(uint *)(param_2 + 4));
          }
        }
      }
      png_read_image(param_1,*(undefined4 *)(param_2 + 0x108));
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x8000;
      png_read_end(param_1,param_2);
      return;
    }
                    // WARNING: Subroutine does not return
    png_error(param_1,"Image is too high to process with png_read_png()");
  }
  return;
}



undefined4 png_image_begin_read_from_stdio(undefined4 *param_1,int param_2)

{
  int iVar1;
  undefined4 uVar2;
  char *pcVar3;
  
  if (param_1 == (undefined4 *)0x0) {
    return 0;
  }
  if (param_1[1] == 1) {
    if (param_2 != 0) {
      iVar1 = FUN_0001ec10(param_1);
      if (iVar1 == 0) {
        return 0;
      }
      *(int *)(*(int *)*param_1 + 0x11c) = param_2;
      uVar2 = png_safe_execute(param_1,0x1ecf1,param_1);
      return uVar2;
    }
    pcVar3 = "png_image_begin_read_from_stdio: invalid argument";
  }
  else {
    pcVar3 = "png_image_begin_read_from_stdio: incorrect PNG_IMAGE_VERSION";
  }
  uVar2 = png_image_error(param_1,pcVar3);
  return uVar2;
}



void FUN_0001ec10(int *param_1)

{
  int iVar1;
  int iVar2;
  int *piVar3;
  undefined4 uVar4;
  int local_20;
  int local_1c;
  int local_18;
  
  local_18 = __stack_chk_guard;
  if (*param_1 != 0) {
    png_image_error(param_1,"png_image_read: opaque pointer not NULL");
    return;
  }
  iVar1 = png_create_read_struct_2("1.6.22beta03",param_1,png_safe_error,0);
  local_1c = iVar1;
  __aeabi_memclr4(param_1,0x60);
  param_1[1] = 1;
  if (iVar1 != 0) {
    iVar2 = png_create_info_struct(iVar1);
    local_20 = iVar2;
    if (iVar2 != 0) {
      piVar3 = (int *)png_malloc_warn(iVar1,0x18);
      if (piVar3 != (int *)0x0) {
        __aeabi_memclr4(piVar3,0x18);
        *piVar3 = iVar1;
        piVar3[1] = iVar2;
        *(undefined1 *)(piVar3 + 5) = 0;
        uVar4 = 1;
        *param_1 = (int)piVar3;
        goto LAB_0001ecbc;
      }
      png_destroy_info_struct(iVar1,&local_20);
    }
    png_destroy_read_struct(&local_1c,0,0);
  }
  uVar4 = png_image_error(param_1,"png_image_read: out of memory");
LAB_0001ecbc:
  if (__stack_chk_guard == local_18) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar4);
}



undefined4 FUN_0001ecf0(int *param_1)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  bool bVar4;
  
  iVar2 = *(int *)*param_1;
  iVar3 = ((int *)*param_1)[1];
  png_set_benign_errors(iVar2,1);
  png_read_info(iVar2,iVar3);
  param_1[2] = *(int *)(iVar2 + 0x1bc);
  param_1[3] = *(int *)(iVar2 + 0x1c0);
  uVar1 = FUN_0002023c(iVar2);
  param_1[4] = uVar1;
  if ((uVar1 & 2) != 0) {
    uVar1 = *(ushort *)(iVar2 + 0x3c2) & 0x8042;
    bVar4 = uVar1 == 2;
    if (bVar4) {
      uVar1 = param_1[5] | 1;
    }
    if (bVar4) {
      param_1[5] = uVar1;
    }
  }
  if (*(char *)(iVar2 + 0x20b) == '\x03') {
    uVar1 = (uint)*(ushort *)(iVar2 + 0x1fc);
  }
  else if (*(char *)(iVar2 + 0x20b) == '\0') {
    uVar1 = 1 << *(sbyte *)(iVar2 + 0x20c);
  }
  else {
    uVar1 = 0x100;
  }
  if (0x100 < uVar1) {
    uVar1 = 0x100;
  }
  param_1[6] = uVar1;
  return 1;
}



undefined4 png_image_begin_read_from_file(int *param_1,char *param_2)

{
  FILE *__stream;
  int iVar1;
  int *piVar2;
  char *pcVar3;
  undefined4 uVar4;
  
  if (param_1 == (int *)0x0) {
    return 0;
  }
  if (param_1[1] == 1) {
    if (param_2 == (char *)0x0) {
      pcVar3 = "png_image_begin_read_from_file: invalid argument";
    }
    else {
      __stream = fopen(param_2,"rb");
      if (__stream != (FILE *)0x0) {
        iVar1 = FUN_0001ec10(param_1);
        if (iVar1 == 0) {
          fclose(__stream);
          return 0;
        }
        *(FILE **)(*(int *)*param_1 + 0x11c) = __stream;
        *(byte *)(*param_1 + 0x14) = *(byte *)(*param_1 + 0x14) | 2;
        uVar4 = png_safe_execute(param_1,0x1ecf1,param_1);
        return uVar4;
      }
      piVar2 = (int *)__errno();
      pcVar3 = strerror(*piVar2);
    }
  }
  else {
    pcVar3 = "png_image_begin_read_from_file: incorrect PNG_IMAGE_VERSION";
  }
  uVar4 = png_image_error(param_1,pcVar3);
  return uVar4;
}



undefined4 png_image_begin_read_from_memory(int *param_1,int param_2,int param_3)

{
  int iVar1;
  undefined4 uVar2;
  char *pcVar3;
  
  if (param_1 == (int *)0x0) {
    return 0;
  }
  if (param_1[1] == 1) {
    if ((param_2 != 0) && (param_3 != 0)) {
      iVar1 = FUN_0001ec10(param_1);
      if (iVar1 == 0) {
        return 0;
      }
      *(int *)(*param_1 + 0xc) = param_2;
      *(int *)(*param_1 + 0x10) = param_3;
      *(int **)(*(int *)*param_1 + 0x11c) = param_1;
      *(undefined4 *)(*(int *)*param_1 + 0x118) = 0x1ee61;
      uVar2 = png_safe_execute(param_1,0x1ecf1,param_1);
      return uVar2;
    }
    pcVar3 = "png_image_begin_read_from_memory: invalid argument";
  }
  else {
    pcVar3 = "png_image_begin_read_from_memory: incorrect PNG_IMAGE_VERSION";
  }
  uVar2 = png_image_error(param_1,pcVar3);
  return uVar2;
}



void FUN_0001ee60(int param_1,undefined4 param_2,uint param_3)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  
  if (param_1 != 0) {
    if ((*(int **)(param_1 + 0x11c) == (int *)0x0) ||
       (iVar2 = **(int **)(param_1 + 0x11c), iVar2 == 0)) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"invalid memory read");
    }
    iVar1 = *(int *)(iVar2 + 0xc);
    if ((iVar1 == 0) || (uVar3 = *(uint *)(iVar2 + 0x10), uVar3 < param_3)) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"read beyond end of data");
    }
    __aeabi_memcpy(param_2,iVar1,param_3);
    *(uint *)(iVar2 + 0xc) = iVar1 + param_3;
    *(uint *)(iVar2 + 0x10) = uVar3 - param_3;
  }
  return;
}



// WARNING: Removing unreachable block (ram,0x0001f02c)

void png_image_finish_read(uint *param_1,undefined4 param_2,int param_3,uint param_4,int param_5)

{
  uint uVar1;
  char *pcVar2;
  int iVar3;
  uint uVar4;
  uint uVar5;
  uint *local_58;
  int iStack_54;
  uint local_50;
  int iStack_4c;
  undefined4 local_48;
  undefined4 local_44;
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (param_1 == (uint *)0x0) {
LAB_0001ef08:
    iVar3 = __stack_chk_guard - local_28;
    if (iVar3 == 0) {
      return;
    }
  }
  else {
    if (param_1[1] != 1) {
      pcVar2 = "png_image_finish_read: damaged PNG_IMAGE_VERSION";
      goto LAB_0001ef34;
    }
    iVar3 = 1;
    uVar4 = param_1[2];
    uVar5 = param_1[4] & 8;
    if (uVar5 == 0) {
      iVar3 = (param_1[4] & 3) + 1;
    }
    uVar1 = __aeabi_uidiv(0x7fffffff,iVar3);
    if (uVar1 < uVar4) {
      iVar3 = __stack_chk_guard - local_28;
      if (iVar3 != 0) goto LAB_0001ef1e;
      pcVar2 = "png_image_finish_read: row_stride too large";
      goto LAB_0001ef34;
    }
    uVar4 = iVar3 * uVar4;
    if (param_4 == 0) {
      param_4 = uVar4;
    }
    uVar1 = param_4;
    if (0x7fffffff < param_4) {
      uVar1 = -param_4;
    }
    if (uVar4 <= uVar1) {
      if (param_3 != 0) {
        uVar1 = *param_1;
      }
      if (param_3 != 0 && uVar1 != 0) {
        uVar4 = __aeabi_uidiv(0xffffffff);
        if (uVar4 < param_1[3]) {
          iVar3 = __stack_chk_guard - local_28;
          if (iVar3 == 0) {
            pcVar2 = "png_image_finish_read: image too large";
            goto LAB_0001ef34;
          }
          goto LAB_0001ef1e;
        }
        if (uVar5 != 0) {
          if (param_5 != 0) {
            uVar4 = param_1[6];
          }
          if (param_5 == 0 || uVar4 == 0) {
            iVar3 = __stack_chk_guard - local_28;
            if (iVar3 == 0) {
              pcVar2 = "png_image_finish_read[color-map]: no color-map";
              goto LAB_0001ef34;
            }
            goto LAB_0001ef1e;
          }
        }
        __aeabi_memclr8(&local_58,0x2c);
        iStack_4c = param_5;
        local_44 = 0;
        local_58 = param_1;
        iStack_54 = param_3;
        local_50 = param_4;
        local_48 = param_2;
        if (uVar5 == 0) {
          png_safe_execute(param_1,0x1fe39,&local_58);
        }
        else {
          iVar3 = png_safe_execute(param_1,0x1f06d,&local_58);
          if (iVar3 != 0) {
            png_safe_execute(param_1,0x1fc89,&local_58);
          }
        }
        png_image_free(param_1);
        goto LAB_0001ef08;
      }
    }
    iVar3 = __stack_chk_guard - local_28;
    if (iVar3 == 0) {
      pcVar2 = "png_image_finish_read: invalid argument";
LAB_0001ef34:
      png_image_error(param_1,pcVar2);
      return;
    }
  }
LAB_0001ef1e:
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iVar3);
}



void FUN_0001f06c(undefined4 *param_1)

{
  byte bVar1;
  byte bVar2;
  char cVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  undefined4 uVar7;
  undefined4 uVar8;
  uint uVar9;
  uint uVar10;
  byte *pbVar11;
  uint extraout_r1;
  undefined4 uVar12;
  uint uVar13;
  uint uVar14;
  uint uVar15;
  int iVar16;
  int iVar17;
  ushort *puVar18;
  uint uVar19;
  size_t __n;
  int iVar20;
  uint uVar21;
  uint uVar22;
  uint uVar23;
  int iVar24;
  int iVar25;
  undefined4 *puVar26;
  int iVar27;
  bool bVar28;
  bool bVar29;
  uint uVar30;
  undefined1 *local_5c;
  uint local_40;
  undefined1 local_34 [2];
  undefined2 local_32;
  undefined2 local_30;
  undefined2 local_2e;
  undefined2 local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  puVar26 = (undefined4 *)*param_1;
  uVar19 = puVar26[4];
  iVar27 = *(int *)*puVar26;
  uVar14 = uVar19 & 4;
  bVar1 = *(byte *)(iVar27 + 0x20b);
  if ((bVar1 & 4) == 0) {
    if (((uVar19 & 1) != 0) || (*(short *)(iVar27 + 0x204) == 0)) goto LAB_0001f0c0;
LAB_0001f0b2:
    if (uVar14 == 0) {
      pbVar11 = (byte *)param_1[4];
      if (pbVar11 == (byte *)0x0) {
                    // WARNING: Subroutine does not return
        png_error(iVar27,"a background color must be supplied to remove alpha/transparency");
      }
      uVar23 = (uint)pbVar11[1];
      uVar10 = uVar23;
      local_40 = uVar23;
      if ((uVar19 & 2) != 0) {
        uVar10 = (uint)*pbVar11;
        local_40 = (uint)pbVar11[2];
      }
    }
    else {
      local_40 = 0;
      uVar10 = 0;
      uVar23 = 0;
    }
  }
  else {
    if ((uVar19 & 1) == 0) goto LAB_0001f0b2;
LAB_0001f0c0:
    uVar10 = 0xff;
    uVar23 = uVar10;
    local_40 = uVar10;
    if (uVar14 != 0) {
      uVar10 = 0xffff;
      uVar23 = uVar10;
      local_40 = uVar10;
    }
  }
  if ((*(ushort *)(iVar27 + 0x3c2) & 1) == 0) {
    bVar2 = *(byte *)(iVar27 + 0x20c);
    bVar28 = bVar2 == 0x10;
    if (bVar28) {
      bVar2 = *(byte *)(puVar26 + 5);
    }
    if (bVar28 && (bVar2 & 4) == 0) {
      uVar12 = 100000;
    }
    else {
      uVar12 = 0xb18f;
    }
    *(undefined4 *)(iVar27 + 0x378) = uVar12;
    *(ushort *)(iVar27 + 0x3c2) = *(ushort *)(iVar27 + 0x3c2) | 1;
  }
  if (6 < bVar1) {
switchD_0001f136_caseD_1:
                    // WARNING: Subroutine does not return
    png_error(iVar27,"invalid PNG color type");
  }
  iVar25 = (uVar14 >> 2) + 1;
  switch(bVar1) {
  case 0:
    if (*(byte *)(iVar27 + 0x20c) < 9) {
      uVar9 = 1 << (uint)*(byte *)(iVar27 + 0x20c);
      if ((uint)puVar26[6] < uVar9) {
                    // WARNING: Subroutine does not return
        png_error(iVar27,"gray[8] color-map: too few entries");
      }
      iVar20 = __aeabi_uidiv(0xff,uVar9 - 1);
      uVar12 = 0;
      if (*(short *)(iVar27 + 0x204) == 0) {
        uVar14 = 0x100;
      }
      else {
        uVar7 = 0xff;
        if (uVar14 != 0) {
          uVar7 = 0xffff;
        }
        uVar14 = (uint)*(ushort *)(iVar27 + 0x274);
        if ((uVar19 & 1) == 0) {
          uVar12 = uVar7;
        }
      }
      uVar19 = 0;
      uVar21 = 0;
      do {
        uVar22 = uVar14;
        uVar13 = uVar10;
        uVar15 = uVar23;
        uVar4 = local_40;
        uVar7 = uVar12;
        iVar16 = iVar25;
        if (uVar14 != uVar19) {
          uVar22 = uVar19;
          uVar13 = uVar21;
          uVar15 = uVar21;
          uVar4 = uVar21;
          uVar7 = 0xff;
          iVar16 = 3;
        }
        FUN_00020274(param_1,uVar22,uVar13,uVar15,uVar4,uVar7,iVar16);
        uVar19 = uVar19 + 1;
        uVar21 = uVar21 + iVar20;
      } while (uVar19 < uVar9);
      if (*(byte *)(iVar27 + 0x20c) < 8) {
        png_set_packing(iVar27);
      }
      uVar12 = 0;
      uVar14 = 0x100;
    }
    else {
      if ((uint)puVar26[6] < 0x100) {
                    // WARNING: Subroutine does not return
        png_error(iVar27,"gray[16] color-map: too few entries");
      }
      iVar20 = 0;
      do {
        FUN_00020274(param_1,iVar20,iVar20,iVar20,iVar20,0xff,1);
        iVar20 = iVar20 + 1;
      } while (iVar20 != 0x100);
      if (*(short *)(iVar27 + 0x204) == 0) {
LAB_0001faea:
        uVar12 = 0;
        uVar14 = 0x100;
        uVar19 = 0x100;
        goto LAB_0001faf2;
      }
      if ((uVar19 & 1) == 0) {
        if (uVar23 == local_40 && uVar10 == uVar23) {
          if (uVar14 != 0) {
            uVar14 = local_40 * 0xff >> 0xf;
            iVar25 = (uint)*(ushort *)(png_sRGB_base + uVar14 * 2) +
                     ((local_40 * 0xff & 0x7fff) * (uint)(byte)png_sRGB_delta[uVar14] >> 0xc);
            goto LAB_0001f662;
          }
          goto LAB_0001fac6;
        }
        uVar12 = 0xff;
        if (uVar14 != 0) {
          uVar12 = 0xffff;
        }
      }
      else {
        uVar12 = 0;
      }
      uVar19 = 0xfe;
      FUN_00020274(param_1,0xfe,uVar10,uVar23,local_40,uVar12,iVar25);
      uVar9 = 0x100;
      uVar12 = 2;
      iVar20 = 1;
LAB_0001fa94:
      uVar14 = uVar19;
      if ((*(short *)(iVar27 + 0x204) != 0) && ((*(byte *)(iVar27 + 0x20b) & 4) == 0)) {
        png_set_palette_to_rgb(iVar27);
      }
LAB_0001faac:
      if (iVar20 != 3) {
        uVar19 = uVar9;
        if (iVar20 != 1) {
                    // WARNING: Subroutine does not return
          png_error(iVar27,"bad data option (internal error)");
        }
        goto LAB_0001faf2;
      }
    }
    break;
  default:
    goto switchD_0001f136_caseD_1;
  case 2:
  case 6:
    if ((uVar19 & 2) == 0) {
      png_set_rgb_to_gray_fixed(iVar27,1,0xffffffff,0xffffffff);
      if (*(char *)(iVar27 + 0x20b) == '\x06') {
        if ((uVar19 & 1) != 0) {
LAB_0001f680:
          if ((uint)puVar26[6] < 0x100) {
                    // WARNING: Subroutine does not return
            png_error(iVar27,"rgb[ga] color-map: too few entries");
          }
          uVar9 = FUN_00020654(param_1);
          iVar20 = 1;
          uVar19 = 0xe7;
          uVar12 = 1;
          goto LAB_0001fa94;
        }
      }
      else {
        bVar28 = (uVar19 & 1) != 0;
        uVar19 = extraout_r1;
        if (bVar28) {
          uVar19 = (uint)*(ushort *)(iVar27 + 0x204);
        }
        if (bVar28 && uVar19 != 0) goto LAB_0001f680;
      }
      if ((uint)puVar26[6] < 0x100) {
                    // WARNING: Subroutine does not return
        png_error(iVar27,"rgb[gray] color-map: too few entries");
      }
      if ((*(char *)(iVar27 + 0x20b) == '\x06') || (*(short *)(iVar27 + 0x204) != 0)) {
        iVar20 = FUN_000206f8(*(undefined4 *)(iVar27 + 0x378));
        iVar16 = 0;
        if (iVar20 == 0) goto LAB_0001f804;
        iVar20 = 3;
        do {
          FUN_00020274(param_1,iVar16,iVar16,iVar16,iVar16,0xff,3);
          iVar16 = iVar16 + 1;
        } while (iVar16 != 0x100);
      }
      else {
        iVar16 = 0;
LAB_0001f804:
        do {
          iVar20 = 1;
          FUN_00020274(param_1,iVar16,iVar16,iVar16,iVar16,0xff,1);
          iVar16 = iVar16 + 1;
        } while (iVar16 != 0x100);
      }
      if ((*(char *)(iVar27 + 0x20b) == '\x06') || (*(short *)(iVar27 + 0x204) != 0)) {
        if (iVar20 == 3) {
          uVar19 = uVar23;
          if (uVar14 >> 2 == 0) {
            uVar19 = (uint)*(ushort *)(png_sRGB_table + uVar23 * 2);
          }
          iVar16 = png_gamma_16bit_correct(uVar19,*(undefined4 *)(iVar27 + 0x378));
          uVar14 = iVar16 * 0xff + 0x807fU >> 0x10;
LAB_0001f8a2:
          FUN_00020274(param_1,uVar14,uVar23,uVar23,uVar23,0,iVar25);
          uVar23 = uVar14;
        }
        else if (uVar14 != 0) {
          uVar14 = uVar23 * 0xff >> 0xf;
          iVar25 = 2;
          uVar14 = ((uint)*(ushort *)(png_sRGB_base + uVar14 * 2) +
                   ((uVar23 * 0xff & 0x7fff) * (uint)(byte)png_sRGB_delta[uVar14] >> 0xc)) * 0x10000
                   >> 0x18;
          goto LAB_0001f8a2;
        }
        uVar12 = 0;
        local_34[0] = 0;
        local_32 = (undefined2)uVar23;
        local_30 = local_32;
        local_2e = local_32;
        local_2c = local_32;
        png_set_background_fixed(iVar27,local_34,1,0,0);
        uVar19 = 0x100;
        uVar9 = 0x100;
        goto LAB_0001fa94;
      }
      uVar12 = 0;
      uVar9 = 0x100;
      uVar14 = 0x100;
      goto LAB_0001faac;
    }
    if ((bVar1 == 6) || (*(short *)(iVar27 + 0x204) != 0)) {
      if ((uVar19 & 1) == 0) {
        if ((uint)puVar26[6] < 0xf4) {
                    // WARNING: Subroutine does not return
          png_error(iVar27,"rgb-alpha color-map: too few entries");
        }
        __n = iVar25 * ((uVar19 & 3) + 1);
        uVar19 = FUN_00020746(param_1);
        FUN_00020274(param_1,uVar19,uVar10,uVar23,local_40,0,iVar25);
        uVar21 = uVar23;
        uVar22 = uVar10;
        uVar13 = uVar23;
        if (uVar14 != 0) {
          uVar14 = uVar10 * 0xff >> 0xf;
          uVar21 = local_40 * 0xff >> 0xf;
          uVar22 = uVar23 * 0xff >> 0xf;
          uVar21 = ((uint)*(ushort *)(png_sRGB_base + uVar21 * 2) +
                   ((uint)(byte)png_sRGB_delta[uVar21] * (local_40 * 0xff & 0x7fff) >> 0xc)) *
                   0x10000 >> 0x18;
          uVar13 = ((uint)*(ushort *)(png_sRGB_base + uVar22 * 2) +
                   ((uint)(byte)png_sRGB_delta[uVar22] * (uVar23 * 0xff & 0x7fff) >> 0xc)) * 0x10000
                   >> 0x18;
          uVar22 = ((uint)*(ushort *)(png_sRGB_base + uVar14 * 2) +
                   ((uint)(byte)png_sRGB_delta[uVar14] * (uVar10 * 0xff & 0x7fff) >> 0xc)) * 0x10000
                   >> 0x18;
        }
        iVar20 = memcmp((void *)(uVar19 * __n + param_1[3]),
                        (void *)((((uVar22 * 5 + 0x82 >> 8) * 6 + (uVar13 * 5 + 0x82 >> 8)) * 6 +
                                  (uVar21 * 5 + 0x82 >> 8) & 0xff) * __n + param_1[3]),__n);
        if (iVar20 == 0) {
          local_34[0] = 0;
          local_32 = (undefined2)uVar10;
          local_30 = (undefined2)uVar23;
          local_2e = (undefined2)local_40;
          local_2c = local_30;
          png_set_background_fixed(iVar27,local_34,1,0,0);
          uVar12 = 3;
          uVar14 = 0x100;
          goto LAB_0001faf2;
        }
        iVar20 = uVar19 + 1;
        uVar14 = 0;
        do {
          uVar21 = 0;
          iVar16 = iVar20;
          do {
            uVar22 = 0;
            iVar17 = iVar16;
            do {
              uVar12 = FUN_000207bc(param_1,uVar14,1,0x80,uVar10,iVar25);
              uVar7 = FUN_000207bc(param_1,uVar21,1,0x80,uVar23,iVar25);
              uVar8 = FUN_000207bc(param_1,uVar22,1,0x80,local_40,iVar25);
              FUN_00020274(param_1,iVar17,uVar12,uVar7,uVar8,0,iVar25);
              uVar22 = uVar22 << 1 | 0x7f;
              iVar17 = iVar17 + 1;
            } while (uVar22 < 0x100);
            uVar21 = uVar21 << 1 | 0x7f;
            iVar16 = iVar16 + 3;
          } while (uVar21 < 0x100);
          uVar14 = uVar14 << 1 | 0x7f;
          iVar20 = iVar20 + 9;
        } while (uVar14 < 0x100);
      }
      else {
        if ((uint)puVar26[6] < 0xf4) {
                    // WARNING: Subroutine does not return
          png_error(iVar27,"rgb+alpha color-map: too few entries");
        }
        uVar19 = FUN_00020746(param_1);
        uVar14 = 0;
        FUN_00020274(param_1,uVar19,0xff,0xff,0xff,0,1);
        iVar25 = uVar19 + 1;
        do {
          uVar23 = 0;
          iVar20 = iVar25;
          do {
            uVar10 = 0;
            iVar16 = iVar20;
            do {
              FUN_00020274(param_1,iVar16,uVar14,uVar23,uVar10,0x80,1);
              uVar10 = uVar10 << 1 | 0x7f;
              iVar16 = iVar16 + 1;
            } while (uVar10 < 0x100);
            uVar23 = uVar23 << 1 | 0x7f;
            iVar20 = iVar20 + 3;
          } while (uVar23 < 0x100);
          uVar14 = uVar14 << 1 | 0x7f;
          iVar25 = iVar25 + 9;
        } while (uVar14 < 0x100);
      }
      uVar9 = uVar19 + 0x1c;
      iVar20 = 1;
      uVar12 = 4;
      goto LAB_0001fa94;
    }
    if ((uint)puVar26[6] < 0xd8) {
                    // WARNING: Subroutine does not return
      png_error(iVar27,"rgb color-map: too few entries");
    }
    uVar19 = FUN_00020746(param_1);
    uVar12 = 3;
    uVar14 = 0x100;
    goto LAB_0001faf2;
  case 3:
    uVar21 = (uint)*(ushort *)(iVar27 + 0x204);
    uVar22 = 0;
    if (uVar21 != 0) {
      uVar22 = *(uint *)(iVar27 + 0x268);
    }
    if (uVar22 == 0) {
      uVar21 = 0;
    }
    uVar13 = uVar22;
    if (uVar22 != 0) {
      uVar13 = 1;
    }
    uVar9 = (uint)*(ushort *)(iVar27 + 0x1fc);
    if (0x100 < uVar9) {
      uVar9 = 0x100;
    }
    if ((uint)puVar26[6] < uVar9) {
                    // WARNING: Subroutine does not return
      png_error(iVar27,"palette color-map: too few entries");
    }
    if (uVar9 != 0) {
      uVar15 = 0;
      iVar20 = *(int *)(iVar27 + 0x1f8);
      do {
        if ((((uint)(uVar15 < uVar21) & (uVar19 & 1) == 0 & uVar13) == 1) &&
           (cVar3 = *(char *)(uVar22 + uVar15), cVar3 != -1)) {
          iVar16 = iVar25;
          if (cVar3 == '\0') {
            uVar30 = 0;
            uVar4 = uVar10;
            uVar5 = uVar23;
            uVar6 = local_40;
          }
          else {
            uVar4 = FUN_000207bc(param_1,*(undefined1 *)(iVar20 + uVar15 * 3),3,cVar3,uVar10,iVar25)
            ;
            iVar17 = uVar15 * 3 + iVar20;
            uVar5 = FUN_000207bc(param_1,*(undefined1 *)(iVar17 + 1),3,
                                 *(undefined1 *)(uVar22 + uVar15),uVar23,iVar25);
            uVar6 = FUN_000207bc(param_1,*(undefined1 *)(iVar17 + 2),3,
                                 *(undefined1 *)(uVar22 + uVar15),local_40,iVar25);
            uVar30 = (uint)*(byte *)(uVar22 + uVar15);
            if (uVar14 != 0) {
              uVar30 = uVar30 * 0x101;
            }
          }
        }
        else {
          uVar4 = (uint)*(byte *)(iVar20 + uVar15 * 3);
          iVar16 = uVar15 * 3 + iVar20;
          uVar5 = (uint)*(byte *)(iVar16 + 1);
          uVar6 = (uint)*(byte *)(iVar16 + 2);
          if (uVar15 < uVar21) {
            uVar30 = (uint)*(byte *)(uVar22 + uVar15);
          }
          else {
            uVar30 = 0xff;
          }
          iVar16 = 3;
        }
        FUN_00020274(param_1,uVar15,uVar4,uVar5,uVar6,uVar30,iVar16);
        uVar15 = uVar15 + 1;
      } while (uVar15 < uVar9);
    }
    if (*(byte *)(iVar27 + 0x20c) < 8) {
      png_set_packing(iVar27);
    }
    uVar12 = 0;
    uVar14 = 0x100;
    break;
  case 4:
    if ((uVar19 & 1) == 0) {
      if (((uVar19 & 2) == 0) || (uVar23 == local_40 && uVar10 == uVar23)) {
        if ((uint)puVar26[6] < 0x100) {
                    // WARNING: Subroutine does not return
          png_error(iVar27,"gray-alpha color-map: too few entries");
        }
        iVar25 = 0;
        do {
          FUN_00020274(param_1,iVar25,iVar25,iVar25,iVar25,0xff,1);
          iVar25 = iVar25 + 1;
        } while (iVar25 != 0x100);
        local_40 = uVar23;
        if (uVar14 != 0) {
          uVar14 = uVar23 * 0xff >> 0xf;
          iVar25 = (uint)*(ushort *)(png_sRGB_base + uVar14 * 2) +
                   ((uVar23 * 0xff & 0x7fff) * (uint)(byte)png_sRGB_delta[uVar14] >> 0xc);
LAB_0001f662:
          uVar14 = (uint)(iVar25 << 0x10) >> 0x18;
          FUN_00020274(param_1,uVar14,local_40,local_40,local_40,0xffff,2);
          local_40 = uVar14;
        }
LAB_0001fac6:
        local_34[0] = 0;
        local_32 = (undefined2)local_40;
        local_30 = local_32;
        local_2e = local_32;
        local_2c = local_32;
        png_set_background_fixed(iVar27,local_34,1,0,0);
        goto LAB_0001faea;
      }
      if ((uint)puVar26[6] < 0x100) {
                    // WARNING: Subroutine does not return
        png_error(iVar27,"ga-alpha color-map: too few entries");
      }
      iVar16 = 0;
      iVar20 = 0;
      do {
        uVar19 = (iVar16 + 0x73U) / 0xe7;
        FUN_00020274(param_1,iVar20,uVar19,uVar19,uVar19,0xff,1);
        iVar20 = iVar20 + 1;
        iVar16 = iVar16 + 0x100;
      } while (iVar20 != 0xe7);
      uVar12 = 0xff;
      if (uVar14 != 0) {
        uVar12 = 0xffff;
      }
      FUN_00020274(param_1,0xe7,uVar10,uVar23,local_40,uVar12,iVar25);
      if (uVar14 >> 2 == 0) {
        uVar23 = (uint)*(ushort *)(png_sRGB_table + uVar23 * 2);
        uVar10 = (uint)*(ushort *)(png_sRGB_table + uVar10 * 2);
        local_40 = (uint)*(ushort *)(png_sRGB_table + local_40 * 2);
      }
      iVar20 = 0xe8;
      iVar25 = 1;
      local_5c = png_sRGB_table;
      do {
        iVar24 = iVar25 * 0x33;
        iVar17 = 0;
        iVar16 = iVar25 * -0x33 + 0xff;
        puVar18 = (ushort *)local_5c;
        do {
          uVar14 = (uint)*puVar18;
          uVar21 = uVar14 * iVar24 + iVar16 * uVar23;
          uVar19 = uVar14 * iVar24 + uVar10 * iVar16;
          uVar14 = uVar14 * iVar24 + iVar16 * local_40;
          uVar9 = uVar21 >> 0xf;
          uVar13 = uVar19 >> 0xf;
          uVar22 = uVar14 >> 0xf;
          FUN_00020274(param_1,iVar20 + iVar17,
                       ((uint)*(ushort *)(png_sRGB_base + uVar13 * 2) +
                       ((uint)(byte)png_sRGB_delta[uVar13] * (uVar19 & 0x7fff) >> 0xc)) * 0x10000 >>
                       0x18,((uint)*(ushort *)(png_sRGB_base + uVar9 * 2) +
                            ((uint)(byte)png_sRGB_delta[uVar9] * (uVar21 & 0x7fff) >> 0xc)) *
                            0x10000 >> 0x18,
                       ((uint)*(ushort *)(png_sRGB_base + uVar22 * 2) +
                       ((uint)(byte)png_sRGB_delta[uVar22] * (uVar14 & 0x7fff) >> 0xc)) * 0x10000 >>
                       0x18,0xff,1);
          iVar17 = iVar17 + 1;
          puVar18 = puVar18 + 0x33;
        } while (iVar17 != 6);
        iVar20 = iVar20 + 6;
        iVar25 = iVar25 + 1;
      } while (iVar25 != 5);
      uVar19 = 0x100;
      uVar12 = 1;
      uVar14 = 0xe7;
    }
    else {
      if ((uint)puVar26[6] < 0x100) {
                    // WARNING: Subroutine does not return
        png_error(iVar27,"gray+alpha color-map: too few entries");
      }
      uVar19 = FUN_00020654(param_1);
      uVar12 = 1;
      uVar14 = 0xe7;
    }
LAB_0001faf2:
    png_set_alpha_mode_fixed(iVar27,0,220000);
    uVar9 = uVar19;
  }
  if (8 < *(byte *)(iVar27 + 0x20c)) {
    png_set_scale_16();
  }
  bVar29 = 0xff < uVar9;
  bVar28 = uVar9 == 0x100;
  if (uVar9 < 0x101) {
    bVar29 = (uint)puVar26[6] <= uVar9;
    bVar28 = uVar9 == puVar26[6];
  }
  if (bVar29 && !bVar28) {
                    // WARNING: Subroutine does not return
    png_error(iVar27,"color map overflow (BAD internal error)");
  }
  puVar26[6] = uVar9;
  switch(uVar12) {
  case 0:
  case 3:
    if (uVar14 == 0x100) {
LAB_0001fb4c:
      param_1[10] = uVar12;
      if (__stack_chk_guard - local_28 == 0) {
        return;
      }
                    // WARNING: Subroutine does not return
      __stack_chk_fail(__stack_chk_guard - local_28);
    }
    break;
  case 1:
    if (uVar14 == 0xe7) goto LAB_0001fb4c;
    break;
  case 2:
    if ((uVar14 == 0xfe) && (0xfe < uVar9)) goto LAB_0001fb4c;
    break;
  case 4:
    if (uVar14 == 0xd8) goto LAB_0001fb4c;
    break;
  default:
                    // WARNING: Subroutine does not return
    png_error(iVar27,"bad processing option (internal error)");
  }
                    // WARNING: Subroutine does not return
  png_error(iVar27,"bad background index (internal error)");
}



undefined4 FUN_0001fc88(undefined4 *param_1)

{
  code *pcVar1;
  char cVar2;
  int iVar3;
  undefined4 uVar4;
  undefined4 uVar5;
  uint extraout_r1;
  uint uVar6;
  uint uVar7;
  int iVar8;
  int iVar9;
  int *piVar10;
  int iVar11;
  bool bVar12;
  
  piVar10 = (int *)*param_1;
  iVar9 = 0;
  iVar11 = *(int *)*piVar10;
  iVar8 = ((int *)*piVar10)[1];
  png_set_keep_unknown_chunks(iVar11,1,0,0xffffffff);
  png_set_keep_unknown_chunks(iVar11,0,&DAT_000332d5,6);
  if (param_1[10] == 0) {
    iVar9 = png_set_interlace_handling(iVar11);
  }
  png_read_update_info(iVar11,iVar8);
  switch(param_1[10]) {
  case 0:
    if ((*(char *)(iVar8 + 0x19) == '\x03' || *(char *)(iVar8 + 0x19) == '\0') &&
       (*(char *)(iVar8 + 0x18) == '\b')) {
LAB_0001fd70:
      iVar3 = param_1[1];
      uVar7 = param_1[2];
      if (0x7fffffff < uVar7) {
        iVar3 = (piVar10[3] + -1) * -uVar7 + iVar3;
      }
      param_1[6] = iVar3;
      param_1[7] = uVar7;
      if (iVar9 != 0) {
        while( true ) {
          if (SBORROW4(iVar9,1)) {
                    // WARNING: Does not return
            pcVar1 = (code *)software_udf(0xfe,0x1fddc);
            (*pcVar1)();
          }
          iVar9 = iVar9 + -1;
          if (iVar9 < 0) break;
          iVar8 = piVar10[3];
          if (iVar8 != 0) {
            iVar3 = param_1[6];
            do {
              png_read_row(iVar11,iVar3,0);
              iVar3 = iVar3 + uVar7;
              iVar8 = iVar8 + -1;
            } while (iVar8 != 0);
          }
        }
        return 1;
      }
      uVar4 = png_get_rowbytes(iVar11,iVar8);
      uVar4 = png_malloc(iVar11,uVar4);
      param_1[5] = uVar4;
      uVar5 = png_safe_execute(piVar10,0x208b9,param_1);
      param_1[5] = 0;
      png_free(iVar11,uVar4);
      return uVar5;
    }
    break;
  case 1:
  case 2:
    if (*(char *)(iVar8 + 0x19) == '\x04') {
      uVar7 = (uint)*(byte *)(iVar8 + 0x18);
      bVar12 = uVar7 == 8;
      uVar6 = extraout_r1;
      if (bVar12) {
        uVar7 = *(uint *)(iVar11 + 0x240);
        uVar6 = 220000;
      }
      if ((bVar12 && uVar7 == uVar6) && (piVar10[6] == 0x100)) goto LAB_0001fd70;
    }
    break;
  case 3:
    if (*(char *)(iVar8 + 0x19) == '\x02') {
      uVar7 = (uint)*(byte *)(iVar8 + 0x18);
      bVar12 = uVar7 == 8;
      uVar6 = extraout_r1;
      if (bVar12) {
        uVar7 = *(uint *)(iVar11 + 0x240);
        uVar6 = 220000;
      }
      if ((bVar12 && uVar7 == uVar6) && (piVar10[6] == 0xd8)) goto LAB_0001fd70;
    }
    break;
  case 4:
    cVar2 = *(char *)(iVar8 + 0x19);
    bVar12 = cVar2 == '\x06';
    if (bVar12) {
      cVar2 = *(char *)(iVar8 + 0x18);
    }
    if (bVar12 && cVar2 == '\b') {
      iVar3 = *(int *)(iVar11 + 0x240);
      bVar12 = iVar3 == 220000;
      if (bVar12) {
        iVar3 = piVar10[6];
      }
      if (bVar12 && iVar3 == 0xf4) goto LAB_0001fd70;
    }
  }
                    // WARNING: Subroutine does not return
  png_error(iVar11,"bad color-map processing (internal error)");
}



void FUN_0001fe38(undefined4 *param_1)

{
  code *pcVar1;
  bool bVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  undefined1 *puVar6;
  int iVar7;
  uint uVar8;
  undefined4 uVar9;
  undefined4 uVar10;
  uint uVar11;
  int *piVar12;
  uint uVar13;
  uint uVar14;
  uint uVar15;
  uint uVar16;
  int iVar17;
  uint local_34;
  ushort local_30;
  ushort local_2e;
  ushort local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  piVar12 = (int *)*param_1;
  uVar14 = piVar12[4];
  iVar17 = *(int *)*piVar12;
  iVar3 = ((int *)*piVar12)[1];
  png_set_palette_to_rgb(iVar17);
  uVar4 = FUN_0002023c(iVar17);
  uVar15 = uVar4 & 0xfffffff7 ^ uVar14;
  if ((uVar15 & 2) == 0) {
    uVar16 = 0;
  }
  else {
    if ((uVar14 & 2) == 0) {
      png_set_rgb_to_gray_fixed(iVar17,1,0xffffffff,0xffffffff);
      uVar16 = uVar4 & 1;
    }
    else {
      png_set_gray_to_rgb(iVar17);
      uVar16 = 0;
    }
    uVar15 = uVar15 & 0xfffffffd;
  }
  uVar11 = uVar14 & 4;
  if (((uVar4 & 4) == 0) || ((*(byte *)(piVar12 + 5) & 4) != 0)) {
    uVar10 = 0xffffffff;
  }
  else {
    uVar10 = 100000;
  }
  png_set_alpha_mode_fixed(iVar17,0,uVar10);
  uVar10 = 0xffffffff;
  uVar13 = uVar11;
  if (uVar11 != 0) {
    uVar10 = 100000;
    uVar13 = uVar4 & 1;
  }
  if ((uVar16 == 0) ||
     ((iVar5 = png_muldiv(&local_34,uVar10,*(undefined4 *)(iVar17 + 0x378),100000), iVar5 != 0 &&
      (iVar5 = png_gamma_significant(local_34), iVar5 == 0)))) {
    uVar16 = 0;
  }
  else if (uVar13 == 1) {
    uVar16 = 2;
    uVar13 = 0;
  }
  if ((uVar15 & 4) != 0) {
    if (uVar11 == 0) {
      png_set_scale_16(iVar17);
    }
    else {
      png_set_expand_16(iVar17);
    }
    uVar15 = uVar15 & 0xfffffffb;
  }
  if ((uVar15 & 1) == 0) {
    bVar2 = false;
  }
  else {
    if ((uVar4 & 1) == 0) {
      uVar9 = 0xff;
      if (uVar11 != 0) {
        uVar9 = 0xffff;
      }
      png_set_add_alpha(iVar17,uVar9,(uVar14 & 0x20) >> 5 ^ 1);
      if ((uVar14 & 0x20) != 0) {
        uVar15 = uVar15 & 0xffffffdf;
      }
      bVar2 = false;
    }
    else if (uVar16 == 0) {
      if (uVar11 == 0) {
        puVar6 = (undefined1 *)param_1[4];
        uVar16 = 0;
        if (puVar6 == (undefined1 *)0x0) {
          uVar13 = 2;
          bVar2 = true;
          goto LAB_0001ffe0;
        }
        local_34 = (uint)(CONCAT12(*puVar6,(short)local_34) & 0xffff00);
        local_30 = (ushort)(byte)puVar6[1];
        local_2e = (ushort)(byte)puVar6[2];
        local_2c = (ushort)(byte)puVar6[1];
        png_set_background_fixed(iVar17,&local_34,1,0,0);
      }
      else {
        png_set_strip_alpha(iVar17);
      }
      uVar16 = 0;
      bVar2 = false;
    }
    else {
      uVar16 = 2;
      bVar2 = false;
    }
LAB_0001ffe0:
    uVar15 = uVar15 & 0xfffffffe;
  }
  png_set_alpha_mode_fixed(iVar17,uVar13,uVar10);
  if ((uVar15 & 0x10) != 0) {
    if ((uVar14 & 2) == 0) {
      uVar14 = uVar14 & 0xffffffef;
    }
    else {
      png_set_bgr(iVar17);
    }
    uVar15 = uVar15 & 0xffffffef;
  }
  if ((uVar15 & 0x20) != 0) {
    if ((uVar14 & 1) == 0) {
      uVar14 = uVar14 & 0xffffffdf;
    }
    else if (uVar16 != 2) {
      png_set_swap_alpha(iVar17);
    }
    uVar15 = uVar15 & 0xffffffdf;
  }
  if (uVar11 != 0) {
    png_set_swap(iVar17);
  }
  if (uVar15 != 0) {
                    // WARNING: Subroutine does not return
    png_error(iVar17,"png_read_image: unsupported transformation");
  }
  iVar5 = 0;
  png_set_keep_unknown_chunks(iVar17,1,0,0xffffffff);
  png_set_keep_unknown_chunks(iVar17,0,&DAT_000332d5,6);
  if ((uVar16 != 2) && (!bVar2)) {
    iVar5 = png_set_interlace_handling(iVar17);
  }
  png_read_update_info(iVar17,iVar3);
  uVar4 = *(byte *)(iVar3 + 0x19) & 2;
  if ((*(byte *)(iVar3 + 0x19) & 4) == 0) {
    if (bVar2) {
                    // WARNING: Subroutine does not return
      png_error(iVar17,"png_image_read: alpha channel lost");
    }
  }
  else if (!bVar2) {
    uVar15 = uVar4;
    if (uVar16 == 2) {
      uVar15 = uVar4 | 1;
    }
    if ((uVar14 & 1) != 0) {
      uVar15 = uVar4;
    }
    uVar4 = uVar15 ^ 1;
  }
  uVar15 = *(uint *)(iVar17 + 0x138);
  if (*(char *)(iVar3 + 0x18) == '\x10') {
    uVar4 = uVar4 | 4;
  }
  uVar4 = (uVar15 & 1) << 4 | uVar4;
  uVar8 = uVar4 | 0x20;
  uVar13 = uVar8;
  if (uVar16 != 2) {
    uVar13 = uVar4;
  }
  if ((uVar14 & 0x20) == 0) {
    uVar13 = uVar4;
  }
  if ((uVar15 & 0x20000) == 0) {
    if ((uVar15 & 0x1000000) != 0) {
      uVar4 = *(uint *)(iVar17 + 0x134) & 0x80;
      if (uVar4 == 0) {
        uVar13 = uVar8;
      }
      if (uVar16 == 2 && uVar4 == 0) goto LAB_0002020e;
    }
  }
  else {
    uVar13 = uVar8;
    if (uVar16 == 2) {
LAB_0002020e:
                    // WARNING: Subroutine does not return
      png_error(iVar17,"unexpected alpha swap transformation");
    }
  }
  if (uVar13 != uVar14) {
                    // WARNING: Subroutine does not return
    png_error(iVar17,"png_read_image: invalid transformations");
  }
  iVar7 = param_1[1];
  uVar14 = param_1[2];
  uVar4 = uVar14;
  if ((uVar11 != 0) && (uVar4 = uVar14 * 2, SBORROW4(uVar4,uVar14))) {
LAB_000201dc:
                    // WARNING: Does not return
    pcVar1 = (code *)software_udf(0xfe,0x201dc);
    (*pcVar1)();
  }
  if (0x7fffffff < uVar4) {
    iVar7 = (piVar12[3] + -1) * -uVar4 + iVar7;
  }
  param_1[6] = iVar7;
  param_1[7] = uVar4;
  if (bVar2) {
    uVar10 = png_get_rowbytes(iVar17,iVar3);
    uVar10 = png_malloc(iVar17,uVar10);
    uVar9 = 0x20bbd;
  }
  else {
    if (uVar16 != 2) {
      while (!SBORROW4(iVar5,1)) {
        iVar5 = iVar5 + -1;
        if (iVar5 < 0) goto LAB_000201e0;
        iVar3 = piVar12[3];
        if (iVar3 != 0) {
          iVar7 = param_1[6];
          do {
            png_read_row(iVar17,iVar7,0);
            iVar7 = iVar7 + uVar4;
            iVar3 = iVar3 + -1;
          } while (iVar3 != 0);
        }
      }
      goto LAB_000201dc;
    }
    uVar10 = png_get_rowbytes(iVar17,iVar3);
    uVar10 = png_malloc(iVar17,uVar10);
    uVar9 = 0x20df9;
  }
  param_1[5] = uVar10;
  png_safe_execute(piVar12,uVar9,param_1);
  param_1[5] = 0;
  png_free(iVar17,uVar10);
LAB_000201e0:
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



uint FUN_0002023c(int param_1)

{
  byte bVar1;
  uint uVar2;
  
  bVar1 = *(byte *)(param_1 + 0x20b);
  uVar2 = bVar1 & 2;
  if ((bVar1 & 4) == 0) {
    if (*(short *)(param_1 + 0x204) != 0) {
      uVar2 = uVar2 | 1;
    }
  }
  else {
    uVar2 = uVar2 | 1;
  }
  if (*(char *)(param_1 + 0x20c) == '\x10') {
    uVar2 = uVar2 | 4;
  }
  return uVar2 | (bVar1 & 1) << 3;
}



void FUN_00020274(undefined4 *param_1,uint param_2,uint param_3,uint param_4,uint param_5,
                 uint param_6,int param_7)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  undefined1 *puVar4;
  uint uVar5;
  undefined4 *puVar6;
  uint uVar7;
  undefined1 *puVar8;
  undefined4 uVar9;
  int iVar10;
  uint uVar11;
  bool bVar12;
  bool bVar13;
  bool bVar14;
  bool bVar15;
  
  puVar6 = (undefined4 *)*param_1;
  bVar12 = (puVar6[4] & 2) != 0;
  bVar13 = param_4 == param_5;
  bVar14 = param_3 == param_4;
  if (0xff < param_2) {
                    // WARNING: Subroutine does not return
    png_error(*(undefined4 *)*puVar6,"color-map index out of range");
  }
  uVar11 = puVar6[4] & 4;
  bVar15 = param_7 == 3;
  if (bVar15) {
    param_7 = param_1[8];
  }
  if (bVar15 && param_7 == 0) {
    FUN_00020824(param_1);
    param_7 = param_1[8];
  }
  switch(param_7) {
  case 1:
    uVar1 = uVar11;
    if (uVar11 != 0) {
      uVar1 = 1;
    }
    if (uVar1 == 0 && (bVar12 || bVar14 && bVar13)) {
      param_7 = 1;
      goto switchD_000202e4_default;
    }
    param_6 = param_6 * 0x101;
    param_5 = (uint)*(ushort *)(png_sRGB_table + param_5 * 2);
    param_4 = (uint)*(ushort *)(png_sRGB_table + param_4 * 2);
    param_3 = (uint)*(ushort *)(png_sRGB_table + param_3 * 2);
    break;
  case 2:
    break;
  case 3:
    uVar9 = param_1[9];
    param_3 = png_gamma_16bit_correct(param_3 * 0x101,uVar9);
    param_4 = png_gamma_16bit_correct(param_4 * 0x101,uVar9);
    param_5 = png_gamma_16bit_correct(param_5 * 0x101,uVar9);
    uVar1 = uVar11;
    if (uVar11 != 0) {
      uVar1 = 1;
    }
    if (uVar1 == 0 && (bVar12 || bVar14 && bVar13)) {
      uVar2 = param_5 * 0xff >> 0xf;
      uVar1 = param_3 * 0xff >> 0xf;
      uVar5 = param_4 * 0xff >> 0xf;
      param_5 = ((uint)*(ushort *)(png_sRGB_base + uVar2 * 2) +
                ((uint)(byte)png_sRGB_delta[uVar2] * (param_5 * 0xff & 0x7fff) >> 0xc)) * 0x10000 >>
                0x18;
      param_4 = ((uint)*(ushort *)(png_sRGB_base + uVar5 * 2) +
                ((param_4 * 0xff & 0x7fff) * (uint)(byte)png_sRGB_delta[uVar5] >> 0xc)) * 0x10000 >>
                0x18;
      param_7 = 1;
      param_3 = ((uint)*(ushort *)(png_sRGB_base + uVar1 * 2) +
                ((uint)(byte)png_sRGB_delta[uVar1] * (param_3 * 0xff & 0x7fff) >> 0xc)) * 0x10000 >>
                0x18;
      goto switchD_000202e4_default;
    }
    param_6 = param_6 * 0x101;
    break;
  case 4:
    param_6 = param_6 * 0x101;
    param_5 = param_5 * 0x101;
    param_4 = param_4 * 0x101;
    param_3 = param_3 * 0x101;
    break;
  default:
    goto switchD_000202e4_default;
  }
  if (bVar12 || bVar14 && bVar13) {
    if (uVar11 == 0) {
      uVar2 = param_5 * 0xff >> 0xf;
      uVar1 = param_3 * 0xff >> 0xf;
      uVar5 = param_4 * 0xff >> 0xf;
      param_5 = ((uint)*(ushort *)(png_sRGB_base + uVar2 * 2) +
                ((uint)(byte)png_sRGB_delta[uVar2] * (param_5 * 0xff & 0x7fff) >> 0xc)) * 0x10000 >>
                0x18;
      param_4 = ((uint)*(ushort *)(png_sRGB_base + uVar5 * 2) +
                ((param_4 * 0xff & 0x7fff) * (uint)(byte)png_sRGB_delta[uVar5] >> 0xc)) * 0x10000 >>
                0x18;
      param_6 = param_6 * 0xff + 0x807f >> 0x10;
      param_7 = 1;
      param_3 = ((uint)*(ushort *)(png_sRGB_base + uVar1 * 2) +
                ((uint)(byte)png_sRGB_delta[uVar1] * (param_3 * 0xff & 0x7fff) >> 0xc)) * 0x10000 >>
                0x18;
    }
    else {
      param_7 = 2;
    }
  }
  else {
    iVar3 = param_5 * 0x93e + param_4 * 0x5b8a + param_3 * 0x1b38;
    if (uVar11 == 0) {
      uVar1 = iVar3 + 0x80;
      uVar1 = ((uVar1 & 0xffffff00) - (uVar1 >> 8)) + 0x40;
      uVar2 = uVar1 >> 0x16;
      param_4 = ((uint)*(ushort *)(png_sRGB_base + uVar2 * 2) +
                ((uint)(byte)png_sRGB_delta[uVar2] * (uVar1 * 0x400 >> 0x11) >> 0xc)) * 0x10000 >>
                0x18;
      param_6 = param_6 * 0xff + 0x807f >> 0x10;
      param_7 = 1;
      param_5 = param_4;
      param_3 = param_4;
    }
    else {
      param_4 = iVar3 + 0x4000U >> 0xf;
      param_7 = 2;
      param_5 = param_4;
      param_3 = param_4;
    }
  }
switchD_000202e4_default:
  if (param_7 != (uVar11 >> 2) + 1) {
                    // WARNING: Subroutine does not return
    png_error(*(undefined4 *)*puVar6,"bad encoding (internal error)");
  }
  uVar2 = puVar6[4];
  uVar7 = uVar2 & 0x21;
  uVar5 = uVar2 >> 3 & 2;
  uVar1 = (uint)(uVar7 == 0x21);
  if (uVar11 == 0) {
    uVar2 = uVar2 & 3;
    puVar8 = (undefined1 *)((uVar2 + 1) * param_2 + param_1[3]);
    if (uVar2 != 0) {
      if (uVar2 != 1) {
        if (uVar2 != 2) {
          puVar4 = puVar8;
          if (uVar7 != 0x21) {
            puVar4 = puVar8 + 3;
          }
          *puVar4 = (char)param_6;
        }
        uVar1 = uVar1 | uVar5;
        puVar8[uVar1 ^ 2] = (char)param_5;
        iVar3 = 1;
        if (uVar7 == 0x21) {
          iVar3 = 2;
        }
        puVar8[iVar3] = (char)param_4;
        puVar8[uVar1] = (char)param_3;
        return;
      }
      puVar8[uVar1 ^ 1] = (char)param_6;
    }
    puVar8[uVar1] = (char)param_4;
  }
  else {
    uVar2 = uVar2 & 3;
    iVar3 = param_1[3] + param_2 * (uVar2 + 1) * 2;
    if (uVar2 != 0) {
      if (uVar2 != 1) {
        if (uVar2 != 2) {
          iVar10 = 3;
          if (uVar7 == 0x21) {
            iVar10 = 0;
          }
          *(short *)(iVar3 + iVar10 * 2) = (short)param_6;
        }
        if (param_6 < 0xffff) {
          if (param_6 == 0) {
            param_5 = 0;
            param_4 = 0;
            param_3 = 0;
          }
          else {
            param_3 = (param_3 * param_6 + 0x7fff) / 0xffff;
            param_4 = (param_4 * param_6 + 0x7fff) / 0xffff;
            param_5 = (param_5 * param_6 + 0x7fff) / 0xffff;
          }
        }
        uVar1 = uVar1 | uVar5;
        *(short *)(iVar3 + (uVar1 ^ 2) * 2) = (short)param_5;
        iVar10 = 1;
        if (uVar7 == 0x21) {
          iVar10 = 2;
        }
        *(short *)(iVar3 + iVar10 * 2) = (short)param_4;
        *(short *)(iVar3 + uVar1 * 2) = (short)param_3;
        return;
      }
      *(short *)(iVar3 + (uVar1 ^ 1) * 2) = (short)param_6;
    }
    if (param_6 < 0xffff) {
      if (param_6 == 0) {
        param_4 = 0;
      }
      else {
        param_4 = (param_4 * param_6 + 0x7fff) / 0xffff;
      }
    }
    *(short *)(iVar3 + uVar1 * 2) = (short)param_4;
  }
  return;
}



undefined4 FUN_00020654(undefined4 param_1)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  
  iVar4 = 0;
  iVar2 = 0;
  do {
    uVar1 = (iVar4 + 0x73U) / 0xe7;
    FUN_00020274(param_1,iVar2,uVar1,uVar1,uVar1,0xff,1);
    iVar2 = iVar2 + 1;
    iVar4 = iVar4 + 0x100;
  } while (iVar2 != 0xe7);
  FUN_00020274(param_1,0xe7,0xff,0xff,0xff,0,1);
  iVar2 = 0xe8;
  iVar4 = 1;
  do {
    iVar3 = 0;
    iVar5 = iVar2;
    do {
      FUN_00020274(param_1,iVar5,iVar3,iVar3,iVar3,iVar4 * 0x33,1);
      iVar3 = iVar3 + 0x33;
      iVar5 = iVar5 + 1;
    } while (iVar3 != 0x132);
    iVar4 = iVar4 + 1;
    iVar2 = iVar2 + 6;
  } while (iVar4 != 5);
  return 0x100;
}



undefined4 FUN_000206f8(int param_1)

{
  code *pcVar1;
  undefined4 uVar2;
  int iVar3;
  
  if (param_1 < 100000) {
    uVar2 = 0;
    if (param_1 != 0) {
      iVar3 = param_1 * 0xb;
      if (((int)((ulonglong)((longlong)param_1 * 0xb) >> 0x20) == iVar3 >> 0x1f) &&
         (!SBORROW4(iVar3 + 2,iVar3))) {
        uVar2 = png_gamma_significant((iVar3 + 2) / 5);
        return uVar2;
      }
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x20744);
      (*pcVar1)();
    }
  }
  else {
    uVar2 = 1;
  }
  return uVar2;
}



undefined4 FUN_00020746(undefined4 param_1)

{
  int iVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  
  iVar1 = 0;
  iVar3 = 0;
  do {
    iVar5 = 0;
    iVar2 = iVar3;
    do {
      iVar6 = 0;
      iVar4 = iVar2;
      do {
        FUN_00020274(param_1,iVar4,iVar1 * 0x33,iVar5 * 0x33,iVar6,0xff,1);
        iVar6 = iVar6 + 0x33;
        iVar4 = iVar4 + 1;
      } while (iVar6 != 0x132);
      iVar5 = iVar5 + 1;
      iVar2 = iVar2 + 6;
    } while (iVar5 != 6);
    iVar1 = iVar1 + 1;
    iVar3 = iVar3 + 0x24;
  } while (iVar1 != 6);
  return 0xd8;
}



uint FUN_000207bc(undefined4 param_1,undefined4 param_2,undefined4 param_3,int param_4,
                 undefined4 param_5,int param_6)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  
  iVar1 = FUN_0002085c();
  iVar2 = FUN_0002085c(param_1,param_5,param_6);
  uVar3 = iVar2 * (0xff - param_4) + iVar1 * param_4;
  if (param_6 == 2) {
    uVar3 = uVar3 * 0x101 + (uVar3 * 0x101 >> 0x10) + 0x8000 >> 0x10;
  }
  else {
    uVar3 = ((uint)*(ushort *)(png_sRGB_base + (uVar3 >> 0xf) * 2) +
            ((uint)(byte)png_sRGB_delta[uVar3 >> 0xf] * (uVar3 & 0x7fff) >> 0xc)) * 0x10000 >> 0x18;
  }
  return uVar3;
}



void FUN_00020824(undefined4 *param_1)

{
  int iVar1;
  undefined4 uVar2;
  
  uVar2 = *(undefined4 *)(**(int **)*param_1 + 0x378);
  iVar1 = png_gamma_significant(uVar2);
  if (iVar1 == 0) {
    uVar2 = 4;
  }
  else {
    iVar1 = FUN_000206f8(uVar2);
    if (iVar1 != 0) {
      param_1[8] = 3;
      uVar2 = png_reciprocal(uVar2);
      param_1[9] = uVar2;
      return;
    }
    uVar2 = 1;
  }
  param_1[8] = uVar2;
  return;
}



uint FUN_0002085c(undefined4 *param_1,uint param_2,int param_3)

{
  if (param_3 == 3) {
    param_3 = param_1[8];
  }
  if (param_3 == 0) {
    FUN_00020824(param_1);
    param_3 = param_1[8];
  }
  switch(param_3) {
  case 1:
    param_2 = (uint)*(ushort *)(png_sRGB_table + param_2 * 2);
    break;
  case 2:
    break;
  case 3:
    param_2 = png_gamma_16bit_correct(param_2 * 0x101,param_1[9]);
    break;
  case 4:
    param_2 = param_2 * 0x101;
    break;
  default:
                    // WARNING: Subroutine does not return
    png_error(**(undefined4 **)*param_1,"unexpected encoding (internal error)");
  }
  return param_2;
}



undefined4 FUN_000208b8(undefined4 *param_1)

{
  code *pcVar1;
  char cVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  byte *pbVar6;
  undefined4 *puVar7;
  uint uVar8;
  uint uVar9;
  int iVar10;
  byte *pbVar11;
  byte bVar12;
  int iVar13;
  int iVar14;
  int iVar15;
  int iVar16;
  uint uVar17;
  uint uVar18;
  byte *pbVar19;
  int iVar20;
  uint uVar21;
  uint uVar22;
  int local_40;
  
  puVar7 = (undefined4 *)*param_1;
  local_40 = 1;
  iVar3 = *(int *)*puVar7;
  cVar2 = *(char *)(iVar3 + 0x208);
  if (cVar2 != '\0') {
    if (cVar2 != '\x01') {
                    // WARNING: Subroutine does not return
      png_error(iVar3,"unknown interlace type");
    }
    local_40 = 7;
  }
  iVar14 = param_1[7];
  iVar15 = param_1[6];
  iVar13 = param_1[10];
  iVar20 = puVar7[2];
  uVar8 = puVar7[3];
  uVar9 = 0;
  do {
    if (cVar2 == '\x01') {
      if ((int)uVar9 < 2) {
        uVar4 = 3;
      }
      else {
        if (SBORROW4(7,uVar9)) goto LAB_00020bac;
        uVar4 = (int)(7 - uVar9) >> 1;
      }
      iVar5 = 1 << (uVar4 & 0xff);
      if ((SBORROW4(iVar5,1)) || (SBORROW4(uVar9 + 1,uVar9))) goto LAB_00020bac;
      iVar5 = iVar5 + -1;
      uVar22 = (uVar9 & 1) << (3U - ((int)(uVar9 + 1) >> 1) & 0xff) & 7;
      if (SBORROW4(iVar5,uVar22)) goto LAB_00020bac;
      if ((int)uVar9 < 2) {
        uVar4 = 3;
      }
      else {
        if (SBORROW4(7,uVar9)) goto LAB_00020bac;
        uVar4 = (int)(7 - uVar9) >> 1;
      }
      if ((iVar5 - uVar22) + iVar20 >> (uVar4 & 0xff) != 0) {
        if (SBORROW4(7,uVar9)) goto LAB_00020bac;
        iVar5 = 1 << ((int)(7 - uVar9) >> 1 & 0xffU);
        uVar4 = (uVar9 & 1 ^ 1) << (3U - ((int)uVar9 >> 1) & 0xff) & 7;
        if ((int)uVar9 < 3) {
          uVar21 = 8;
        }
        else {
          if (SBORROW4(uVar9,1)) goto LAB_00020bac;
          uVar21 = 8 >> ((int)(uVar9 - 1) >> 1 & 0xffU);
        }
        goto LAB_00020a18;
      }
    }
    else {
      uVar21 = 1;
      uVar4 = 0;
      iVar5 = 1;
      uVar22 = 0;
LAB_00020a18:
      for (; uVar4 < uVar8; uVar4 = uVar4 + uVar21) {
        pbVar19 = (byte *)param_1[5];
        png_read_row(iVar3,pbVar19,0);
        if (iVar13 - 1U < 4) {
          iVar10 = uVar4 * iVar14 + iVar15;
          pbVar6 = (byte *)(iVar10 + uVar22);
          pbVar11 = (byte *)(iVar10 + iVar20);
          switch(iVar13) {
          case 1:
            if ((int)uVar22 < iVar20) {
              do {
                uVar17 = (uint)pbVar19[1];
                if (uVar17 < 0xe6) {
                  if (uVar17 < 0x1a) {
                    bVar12 = 0xe7;
                  }
                  else {
                    bVar12 = ((char)((uint)*pbVar19 * 5 + 0x82 >> 8) +
                             (char)(uVar17 * 5 + 0x82 >> 8) * '\x06') - 0x1e;
                  }
                }
                else {
                  bVar12 = (byte)((uint)*pbVar19 * 0xe7 + 0x80 >> 8);
                }
                *pbVar6 = bVar12;
                pbVar6 = pbVar6 + iVar5;
                pbVar19 = pbVar19 + 2;
              } while (pbVar6 < pbVar11);
            }
            break;
          case 2:
            if ((int)uVar22 < iVar20) {
              do {
                if (pbVar19[1] == 0) {
                  bVar12 = 0xfe;
                }
                else {
                  bVar12 = *pbVar19;
                  if (bVar12 == 0xfe) {
                    bVar12 = 0xff;
                  }
                }
                *pbVar6 = bVar12;
                pbVar6 = pbVar6 + iVar5;
                pbVar19 = pbVar19 + 2;
              } while (pbVar6 < pbVar11);
            }
            break;
          case 3:
            if ((int)uVar22 < iVar20) {
              do {
                iVar10 = ((uint)*pbVar19 * 5 + 0x82 >> 8) * 6 + ((uint)pbVar19[1] * 5 + 0x82 >> 8);
                iVar16 = iVar10 * 6 + ((uint)pbVar19[2] * 5 + 0x82 >> 8);
                if (SBORROW4(iVar16,iVar10 * 6)) goto LAB_00020bac;
                *pbVar6 = (byte)iVar16;
                pbVar6 = pbVar6 + iVar5;
                pbVar19 = pbVar19 + 3;
              } while (pbVar6 < pbVar11);
            }
            break;
          case 4:
            if ((int)uVar22 < iVar20) {
              pbVar19 = pbVar19 + 1;
              do {
                if (pbVar19[2] < 0xc4) {
                  if (pbVar19[2] < 0x40) {
                    iVar10 = 0xd8;
                  }
                  else {
                    uVar17 = (uint)(char)pbVar19[-1];
                    iVar10 = 0xd9;
                    if ((int)uVar17 < 0) {
                      iVar10 = 0xe2;
                    }
                    uVar18 = uVar17 & 0x40;
                    if (uVar18 != 0) {
                      iVar10 = iVar10 + 9;
                    }
                    if ((int)uVar17 < 0) {
                      iVar10 = iVar10 + 3;
                    }
                    if (uVar18 != 0) {
                      iVar10 = iVar10 + 3;
                    }
                    iVar10 = (uVar18 >> 6) + ((uVar17 & 0x80) >> 7) + iVar10;
                  }
                }
                else {
                  iVar16 = ((uint)pbVar19[-1] * 5 + 0x82 >> 8) * 6 +
                           ((uint)*pbVar19 * 5 + 0x82 >> 8);
                  iVar10 = iVar16 * 6 + ((uint)pbVar19[1] * 5 + 0x82 >> 8);
                  if (SBORROW4(iVar10,iVar16 * 6)) goto LAB_00020bac;
                }
                *pbVar6 = (byte)iVar10;
                pbVar6 = pbVar6 + iVar5;
                pbVar19 = pbVar19 + 4;
              } while (pbVar6 < pbVar11);
            }
          }
        }
      }
    }
    uVar4 = uVar9 + 1;
    if (SBORROW4(uVar4,uVar9)) {
LAB_00020bac:
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x20bac);
      (*pcVar1)();
    }
    if (local_40 <= (int)uVar4) {
      return 1;
    }
    cVar2 = *(char *)(iVar3 + 0x208);
    uVar9 = uVar4;
  } while( true );
}



undefined4 FUN_00020bbc(undefined4 *param_1)

{
  code *pcVar1;
  char cVar2;
  byte bVar3;
  int iVar4;
  uint uVar5;
  int iVar6;
  int iVar7;
  uint uVar8;
  undefined4 *puVar9;
  int iVar10;
  int iVar11;
  int iVar12;
  uint uVar13;
  uint uVar14;
  uint uVar15;
  uint uVar16;
  uint uVar17;
  uint uVar18;
  uint uVar19;
  int local_50;
  uint local_44;
  int local_30;
  uint local_28;
  
  puVar9 = (undefined4 *)*param_1;
  local_50 = 1;
  iVar4 = *(int *)*puVar9;
  cVar2 = *(char *)(iVar4 + 0x208);
  if (cVar2 != '\0') {
    if (cVar2 != '\x01') {
                    // WARNING: Subroutine does not return
      png_error(iVar4,"unknown interlace type");
    }
    local_50 = 7;
  }
  iVar12 = puVar9[2];
  uVar14 = puVar9[3];
  uVar19 = puVar9[4] & 2 | 1;
  iVar10 = uVar19 * iVar12;
  iVar11 = param_1[7];
  uVar17 = 0;
  do {
    if (cVar2 == '\x01') {
      if ((int)uVar17 < 2) {
        uVar5 = 3;
      }
      else {
        if (SBORROW4(7,uVar17)) goto LAB_00020dda;
        uVar5 = (int)(7 - uVar17) >> 1;
      }
      iVar6 = 1 << (uVar5 & 0xff);
      if ((SBORROW4(iVar6,1)) || (SBORROW4(uVar17 + 1,uVar17))) goto LAB_00020dda;
      iVar6 = iVar6 + -1;
      uVar5 = (uVar17 & 1) << (3U - ((int)(uVar17 + 1) >> 1) & 0xff) & 7;
      if (SBORROW4(iVar6,uVar5)) goto LAB_00020dda;
      if ((int)uVar17 < 2) {
        uVar15 = 3;
      }
      else {
        if (SBORROW4(7,uVar17)) goto LAB_00020dda;
        uVar15 = (int)(7 - uVar17) >> 1;
      }
      if ((iVar6 - uVar5) + iVar12 >> (uVar15 & 0xff) != 0) {
        if (SBORROW4(7,uVar17)) goto LAB_00020dda;
        local_30 = uVar5 * uVar19;
        local_28 = uVar19 << ((int)(7 - uVar17) >> 1 & 0xffU);
        uVar5 = (uVar17 & 1 ^ 1) << (3U - ((int)uVar17 >> 1) & 0xff) & 7;
        if ((int)uVar17 < 3) {
          local_44 = 8;
        }
        else {
          if (SBORROW4(uVar17,1)) goto LAB_00020dda;
          local_44 = 8 >> ((int)(uVar17 - 1) >> 1 & 0xffU);
        }
        goto LAB_00020d36;
      }
    }
    else {
      local_44 = 1;
      local_30 = 0;
      uVar5 = 0;
      local_28 = uVar19;
LAB_00020d36:
      for (; uVar5 < uVar14; uVar5 = uVar5 + local_44) {
        iVar6 = param_1[5];
        png_read_row(iVar4,iVar6,0);
        if (local_30 < iVar10) {
          iVar7 = uVar5 * iVar11 + param_1[6];
          uVar15 = local_30 + iVar7;
          do {
            uVar13 = (uint)*(byte *)(iVar6 + uVar19);
            if (uVar13 != 0) {
              uVar16 = 0;
              do {
                bVar3 = *(byte *)(iVar6 + uVar16);
                if (uVar13 != 0xff) {
                  uVar8 = (uint)*(ushort *)(png_sRGB_table + (uint)*(byte *)(uVar15 + uVar16) * 2) *
                          (uVar13 ^ 0xff) + (uint)bVar3 * 0xffff;
                  uVar18 = uVar8 >> 0xf;
                  bVar3 = (byte)((uint)*(ushort *)(png_sRGB_base + uVar18 * 2) +
                                 ((uint)(byte)png_sRGB_delta[uVar18] * (uVar8 & 0x7fff) >> 0xc) >> 8
                                );
                }
                *(byte *)(uVar15 + uVar16) = bVar3;
                uVar16 = uVar16 + 1;
              } while (uVar19 != uVar16);
            }
            iVar6 = iVar6 + uVar19 + 1;
            uVar15 = uVar15 + local_28;
          } while (uVar15 < (uint)(iVar7 + iVar10));
        }
      }
    }
    uVar5 = uVar17 + 1;
    if (SBORROW4(uVar5,uVar17)) {
LAB_00020dda:
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x20dda);
      (*pcVar1)();
    }
    if (local_50 <= (int)uVar5) {
      return 1;
    }
    cVar2 = *(char *)(iVar4 + 0x208);
    uVar17 = uVar5;
  } while( true );
}



undefined4 FUN_00020df8(undefined4 *param_1)

{
  code *pcVar1;
  char cVar2;
  ushort uVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  char cVar7;
  int iVar8;
  uint uVar9;
  int iVar10;
  int iVar11;
  int iVar12;
  uint uVar13;
  uint uVar14;
  int iVar15;
  int iVar16;
  undefined1 *puVar17;
  ushort *puVar18;
  byte *pbVar19;
  byte *pbVar20;
  int iVar21;
  uint uVar22;
  uint uVar23;
  int *piVar24;
  uint uVar25;
  byte bVar26;
  int iVar27;
  int iVar28;
  uint uVar29;
  ushort uVar30;
  int iVar31;
  uint local_40;
  uint local_3c;
  uint local_2c;
  
  piVar24 = (int *)*param_1;
  iVar11 = *(int *)*piVar24;
  if ((*(uint *)(iVar11 + 0x138) & 0x600000) == 0) {
                    // WARNING: Subroutine does not return
    png_error(iVar11,"lost rgb to gray");
  }
  if ((*(uint *)(iVar11 + 0x138) & 0x80) != 0) {
                    // WARNING: Subroutine does not return
    png_error(iVar11,"unexpected compose");
  }
  iVar27 = ((int *)*piVar24)[1];
  iVar12 = piVar24[2];
  uVar13 = piVar24[3];
  iVar8 = png_get_channels(iVar11,iVar27);
  if (iVar8 != 2) {
                    // WARNING: Subroutine does not return
    png_error(iVar11,"lost/gained channels");
  }
  uVar14 = piVar24[4];
  if ((uVar14 & 5) == 1) {
                    // WARNING: Subroutine does not return
    png_error(iVar11,"unexpected 8-bit transformation");
  }
  cVar7 = *(char *)(iVar11 + 0x208);
  if (cVar7 == '\0') {
    iVar8 = 1;
  }
  else {
    if (cVar7 != '\x01') {
                    // WARNING: Subroutine does not return
      png_error(iVar11,"unknown interlace type");
    }
    iVar8 = 7;
  }
  cVar2 = *(char *)(iVar27 + 0x18);
  if (cVar2 == '\x10') {
    uVar22 = uVar14 & 1;
    iVar27 = param_1[6];
    iVar10 = uVar22 + 1;
    iVar15 = param_1[7];
    uVar9 = (uint)(uVar22 == 0 || (uVar14 & 0x20) == 0);
    uVar25 = iVar15 - (iVar15 >> 0x1f) & 0xfffffffe;
    uVar14 = 0;
LAB_00021122:
    if (cVar7 == '\x01') {
      if ((int)uVar14 < 2) {
        uVar29 = 3;
      }
      else {
        if (SBORROW4(7,uVar14)) goto LAB_000212fc;
        uVar29 = (int)(7 - uVar14) >> 1;
      }
      iVar28 = 1 << (uVar29 & 0xff);
      if ((SBORROW4(iVar28,1)) || (SBORROW4(uVar14 + 1,uVar14))) goto LAB_000212fc;
      iVar28 = iVar28 + -1;
      uVar29 = (uVar14 & 1) << (3U - ((int)(uVar14 + 1) >> 1) & 0xff) & 7;
      if (SBORROW4(iVar28,uVar29)) goto LAB_000212fc;
      if ((int)uVar14 < 2) {
        uVar23 = 3;
      }
      else {
        if (SBORROW4(7,uVar14)) goto LAB_000212fc;
        uVar23 = (int)(7 - uVar14) >> 1;
      }
      if ((iVar28 - uVar29) + iVar12 >> (uVar23 & 0xff) == 0) goto LAB_000212dc;
      if (SBORROW4(7,uVar14)) goto LAB_000212fc;
      iVar16 = uVar29 * iVar10;
      iVar28 = iVar10 << ((int)(7 - uVar14) >> 1 & 0xffU);
      uVar29 = (uVar14 & 1 ^ 1) << (3U - ((int)uVar14 >> 1) & 0xff) & 7;
      if (2 < (int)uVar14) {
        if (!SBORROW4(uVar14,1)) {
          local_40 = 8 >> ((int)(uVar14 - 1) >> 1 & 0xffU);
          goto LAB_00021228;
        }
        goto LAB_000212fc;
      }
      local_40 = 8;
    }
    else {
      local_40 = 1;
      iVar16 = 0;
      uVar29 = 0;
      iVar28 = iVar10;
    }
LAB_00021228:
    if (uVar29 < uVar13) {
      iVar4 = (iVar15 / 2) * uVar29;
      iVar5 = uVar25 * uVar29;
      iVar6 = uVar25 * uVar29;
      iVar31 = iVar27;
      do {
        png_read_row(iVar11,param_1[5],0);
        if (iVar16 < iVar10 * iVar12) {
          puVar18 = (ushort *)param_1[5];
          iVar21 = iVar31;
          do {
            uVar3 = puVar18[1];
            uVar23 = (uint)uVar3;
            if (uVar23 == 0) {
              uVar30 = 0;
            }
            else {
              uVar30 = *puVar18;
              if (uVar23 != 0xffff) {
                uVar30 = (ushort)((uVar23 * uVar30 + 0x7fff) / 0xffff);
              }
            }
            *(ushort *)(iVar6 + (uVar9 ^ 1) * 2 + iVar16 * 2 + iVar21) = uVar30;
            if (uVar22 != 0) {
              *(ushort *)(iVar5 + uVar9 * 2 + iVar16 * 2 + iVar21) = uVar3;
            }
            iVar21 = iVar21 + iVar28 * 2;
            puVar18 = puVar18 + 2;
          } while ((uint)(iVar21 + (iVar4 + iVar16) * 2) <
                   iVar27 + uVar29 * (iVar15 / 2) * 2 + iVar10 * iVar12 * 2);
        }
        iVar31 = iVar31 + local_40 * uVar25;
        uVar29 = uVar29 + local_40;
      } while (uVar29 < uVar13);
    }
LAB_000212dc:
    uVar29 = uVar14 + 1;
    if (SBORROW4(uVar29,uVar14)) goto LAB_000212fc;
    if (iVar8 <= (int)uVar29) {
      return 1;
    }
    cVar7 = *(char *)(iVar11 + 0x208);
    uVar14 = uVar29;
    goto LAB_00021122;
  }
  if (cVar2 != '\b') {
                    // WARNING: Subroutine does not return
    png_error(iVar11,"unexpected bit depth");
  }
  iVar27 = param_1[6];
  iVar15 = param_1[7];
  uVar14 = 0;
LAB_00020e98:
  if (cVar7 == '\x01') {
    if ((int)uVar14 < 2) {
      uVar9 = 3;
    }
    else {
      if (SBORROW4(7,uVar14)) {
LAB_000212fc:
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x212fc);
        (*pcVar1)();
      }
      uVar9 = (int)(7 - uVar14) >> 1;
    }
    iVar10 = 1 << (uVar9 & 0xff);
    if ((SBORROW4(iVar10,1)) || (SBORROW4(uVar14 + 1,uVar14))) goto LAB_000212fc;
    iVar10 = iVar10 + -1;
    local_2c = (uVar14 & 1) << (3U - ((int)(uVar14 + 1) >> 1) & 0xff) & 7;
    if (SBORROW4(iVar10,local_2c)) goto LAB_000212fc;
    if ((int)uVar14 < 2) {
      uVar9 = 3;
    }
    else {
      if (SBORROW4(7,uVar14)) goto LAB_000212fc;
      uVar9 = (int)(7 - uVar14) >> 1;
    }
    if ((iVar10 - local_2c) + iVar12 >> (uVar9 & 0xff) == 0) goto LAB_000210ae;
    if (SBORROW4(7,uVar14)) goto LAB_000212fc;
    iVar10 = 1 << ((int)(7 - uVar14) >> 1 & 0xffU);
    uVar9 = (uVar14 & 1 ^ 1) << (3U - ((int)uVar14 >> 1) & 0xff) & 7;
    if (2 < (int)uVar14) {
      if (!SBORROW4(uVar14,1)) {
        local_3c = 8 >> ((int)(uVar14 - 1) >> 1 & 0xffU);
        goto LAB_00020fa4;
      }
      goto LAB_000212fc;
    }
    local_3c = 8;
  }
  else {
    uVar9 = 0;
    local_3c = 1;
    iVar10 = 1;
    local_2c = 0;
  }
LAB_00020fa4:
  if (param_1[4] == 0) {
    for (; uVar9 < uVar13; uVar9 = uVar9 + local_3c) {
      iVar28 = param_1[5];
      png_read_row(iVar11,iVar28,0);
      if ((int)local_2c < iVar12) {
        iVar16 = uVar9 * iVar15 + iVar27;
        pbVar19 = (byte *)(iVar16 + local_2c);
        pbVar20 = (byte *)(iVar28 + 1);
        do {
          uVar25 = (uint)*pbVar20;
          if (uVar25 != 0) {
            bVar26 = pbVar20[-1];
            if (uVar25 != 0xff) {
              uVar25 = (uint)*(ushort *)(png_sRGB_table + (uint)*pbVar19 * 2) * (uVar25 ^ 0xff) +
                       uVar25 * *(ushort *)(png_sRGB_table + (uint)bVar26 * 2);
              uVar22 = uVar25 >> 0xf;
              bVar26 = (byte)((uint)*(ushort *)(png_sRGB_base + uVar22 * 2) +
                              ((uint)(byte)png_sRGB_delta[uVar22] * (uVar25 & 0x7fff) >> 0xc) >> 8);
            }
            *pbVar19 = bVar26;
          }
          pbVar19 = pbVar19 + iVar10;
          pbVar20 = pbVar20 + 2;
        } while (pbVar19 < (byte *)(iVar12 + iVar16));
      }
    }
  }
  else if (uVar9 < uVar13) {
    uVar25 = (uint)*(byte *)(param_1[4] + 1);
    uVar3 = *(ushort *)(png_sRGB_table + uVar25 * 2);
    do {
      iVar28 = param_1[5];
      png_read_row(iVar11,iVar28,0);
      if ((int)local_2c < iVar12) {
        iVar16 = uVar9 * iVar15 + iVar27;
        puVar17 = (undefined1 *)(iVar16 + local_2c);
        pbVar19 = (byte *)(iVar28 + 1);
        do {
          uVar29 = (uint)*pbVar19;
          uVar22 = uVar25;
          if (uVar29 != 0) {
            uVar22 = (uint)pbVar19[-1];
          }
          if (uVar29 != 0 && uVar29 != 0xff) {
            uVar22 = *(ushort *)(png_sRGB_table + uVar22 * 2) * uVar29 +
                     (uVar29 ^ 0xff) * (uint)uVar3;
            uVar29 = uVar22 >> 0xf;
            uVar22 = ((uint)*(ushort *)(png_sRGB_base + uVar29 * 2) +
                     ((uint)(byte)png_sRGB_delta[uVar29] * (uVar22 & 0x7fff) >> 0xc)) * 0x10000 >>
                     0x18;
          }
          *puVar17 = (char)uVar22;
          puVar17 = puVar17 + iVar10;
          pbVar19 = pbVar19 + 2;
        } while (puVar17 < (undefined1 *)(iVar12 + iVar16));
      }
      uVar9 = uVar9 + local_3c;
    } while (uVar9 < uVar13);
  }
LAB_000210ae:
  uVar9 = uVar14 + 1;
  if (SBORROW4(uVar9,uVar14)) goto LAB_000212fc;
  if (iVar8 <= (int)uVar9) {
    return 1;
  }
  cVar7 = *(char *)(iVar11 + 0x208);
  uVar14 = uVar9;
  goto LAB_00020e98;
}



void png_read_data(int param_1)

{
  if (*(code **)(param_1 + 0x118) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x00021366. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 0x118))();
    return;
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"Call to NULL read function");
}



void png_default_read_data(int param_1,void *param_2,size_t param_3)

{
  size_t sVar1;
  
  if ((param_1 != 0) &&
     (sVar1 = fread(param_2,1,param_3,*(FILE **)(param_1 + 0x11c)), sVar1 != param_3)) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"Read Error");
  }
  return;
}



void png_set_read_fn(int param_1,undefined4 param_2,code *param_3)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x11c) = param_2;
    if (param_3 == (code *)0x0) {
      param_3 = png_default_read_data;
    }
    *(code **)(param_1 + 0x118) = param_3;
    if (*(int *)(param_1 + 0x114) != 0) {
      *(undefined4 *)(param_1 + 0x114) = 0;
    }
    *(undefined4 *)(param_1 + 0x230) = 0;
  }
  return;
}



void png_set_crc_action(int param_1,int param_2,undefined4 param_3)

{
  uint uVar1;
  int iVar2;
  
  if (param_1 == 0) {
    return;
  }
  if (param_2 != 5) {
    if (param_2 == 4) {
      uVar1 = *(uint *)(param_1 + 0x134) | 0xc00;
    }
    else if (param_2 == 3) {
      uVar1 = *(uint *)(param_1 + 0x134) & 0xfffff3ff | 0x400;
    }
    else {
      uVar1 = *(uint *)(param_1 + 0x134) & 0xfffff3ff;
    }
    *(uint *)(param_1 + 0x134) = uVar1;
  }
  switch(param_3) {
  case 1:
    uVar1 = *(uint *)(param_1 + 0x134);
    iVar2 = 2;
    goto LAB_00021422;
  default:
    uVar1 = *(uint *)(param_1 + 0x134) & 0xfffffcff;
    break;
  case 3:
    uVar1 = *(uint *)(param_1 + 0x134);
    iVar2 = 1;
LAB_00021422:
    uVar1 = uVar1 & 0xfffffcff | iVar2 << 8;
    break;
  case 4:
    uVar1 = *(uint *)(param_1 + 0x134) | 0x300;
    break;
  case 5:
    goto switchD_00021400_caseD_5;
  }
  *(uint *)(param_1 + 0x134) = uVar1;
switchD_00021400_caseD_5:
  return;
}



void png_set_background_fixed(int param_1,int param_2,int param_3,int param_4,undefined4 param_5)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  
  if (param_1 != 0) {
    uVar1 = *(uint *)(param_1 + 0x134);
    if ((uVar1 & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = uVar1 | 0x4000;
    if ((param_2 != 0) && (param_3 != 0)) {
      uVar2 = *(uint *)(param_1 + 0x138);
      uVar3 = uVar2 & 0xff7bff7f;
      *(uint *)(param_1 + 0x134) = uVar1 & 0xffffdfff | 0x4000;
      *(uint *)(param_1 + 0x138) = uVar3 | 0x40080;
      __aeabi_memcpy(param_1 + 0x21c,param_2,10);
      *(undefined4 *)(param_1 + 0x218) = param_5;
      *(char *)(param_1 + 0x216) = (char)param_3;
      if (param_4 == 0) {
        uVar3 = uVar2 & 0xff7bfe7f | 0x40080;
      }
      else {
        uVar3 = uVar3 | 0x40180;
      }
      *(uint *)(param_1 + 0x138) = uVar3;
    }
  }
  return;
}



void png_set_background(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                       undefined4 param_5,undefined4 param_6)

{
  undefined4 uVar1;
  
  uVar1 = png_fixed(param_1,param_2,param_5,param_6,"png_set_background");
  png_set_background_fixed(param_1,param_2,param_3,param_4,uVar1);
  return;
}



void png_set_scale_16(int param_1)

{
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x4000000;
  }
  return;
}



void png_set_strip_16(int param_1)

{
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x400;
  }
  return;
}



void png_set_strip_alpha(int param_1)

{
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x40000;
  }
  return;
}



void png_set_alpha_mode_fixed(int param_1,undefined4 param_2,int param_3)

{
  uint uVar1;
  int iVar2;
  bool bVar3;
  uint uVar4;
  int iVar5;
  int iVar6;
  
  if (param_1 == 0) {
    return;
  }
  uVar1 = *(uint *)(param_1 + 0x134);
  if ((uVar1 & 0x40) != 0) {
    png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
    return;
  }
  iVar6 = 0x250ac;
  *(uint *)(param_1 + 0x134) = uVar1 | 0x4000;
  if (param_3 == -3 || param_3 + 3 < 0 != SCARRY4(param_3,3)) {
    if (param_3 == -100000) {
LAB_000215f0:
      iVar6 = 220000;
      *(uint *)(param_1 + 0x134) = uVar1 | 0x5000;
    }
    else if (param_3 != -50000) {
LAB_00021602:
      iVar6 = param_3;
      if (0x989298 < param_3 - 1000U) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"output gamma out of expected range");
      }
    }
  }
  else if (param_3 != -2) {
    if (param_3 != -1) goto LAB_00021602;
    goto LAB_000215f0;
  }
  iVar2 = png_reciprocal(iVar6);
  switch(param_2) {
  case 0:
    uVar1 = *(uint *)(param_1 + 0x138) & 0xff7fffff;
    *(uint *)(param_1 + 0x138) = uVar1;
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) & 0xffffdfff;
    bVar3 = false;
    goto LAB_00021696;
  case 1:
    iVar6 = 100000;
    uVar1 = *(uint *)(param_1 + 0x138) & 0xff7fffff;
    *(uint *)(param_1 + 0x138) = uVar1;
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) & 0xffffdfff;
    bVar3 = true;
    goto LAB_00021696;
  case 2:
    uVar1 = *(uint *)(param_1 + 0x138) & 0xff7fffff;
    *(uint *)(param_1 + 0x138) = uVar1;
    uVar4 = *(uint *)(param_1 + 0x134) | 0x2000;
    break;
  case 3:
    uVar1 = *(uint *)(param_1 + 0x138) | 0x800000;
    *(uint *)(param_1 + 0x138) = uVar1;
    uVar4 = *(uint *)(param_1 + 0x134) & 0xffffdfff;
    break;
  default:
                    // WARNING: Subroutine does not return
    png_error(param_1,"invalid alpha mode");
  }
  *(uint *)(param_1 + 0x134) = uVar4;
  bVar3 = true;
LAB_00021696:
  iVar5 = *(int *)(param_1 + 0x378);
  if (*(int *)(param_1 + 0x378) == 0) {
    *(int *)(param_1 + 0x378) = iVar2;
    *(ushort *)(param_1 + 0x3c2) = *(ushort *)(param_1 + 0x3c2) | 1;
    iVar5 = iVar2;
  }
  *(int *)(param_1 + 0x240) = iVar6;
  if (bVar3) {
    *(undefined2 *)(param_1 + 0x224) = 0;
    *(int *)(param_1 + 0x218) = iVar5;
    *(undefined4 *)(param_1 + 0x21c) = 0;
    *(undefined4 *)(param_1 + 0x220) = 0;
    *(undefined1 *)(param_1 + 0x216) = 2;
    *(uint *)(param_1 + 0x138) = uVar1 & 0xfffffeff;
    if ((uVar1 & 0x80) != 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"conflicting calls to set alpha mode and background");
    }
    *(uint *)(param_1 + 0x138) = uVar1 & 0xfffffeff | 0x80;
  }
  return;
}



void png_set_alpha_mode(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  undefined4 uVar1;
  
  uVar1 = FUN_00021730(param_3);
  png_set_alpha_mode_fixed(param_1,param_2,uVar1);
  return;
}



// WARNING: Control flow encountered bad instruction data

void FUN_00021730(undefined4 param_1)

{
  undefined4 uVar1;
  undefined4 extraout_r1;
  undefined4 unaff_r4;
  undefined4 in_lr;
  double in_d0;
  double dVar2;
  
  dVar2 = in_d0;
  if ((int)((uint)(in_d0 < 128.0) << 0x1f) < 0) {
    dVar2 = in_d0 * 100000.0;
  }
  if (in_d0 != 0.0 && in_d0 < 0.0 == NAN(in_d0)) {
    in_d0 = dVar2;
  }
  uVar1 = SUB84(in_d0 + 0.5,0);
  floor((double)CONCAT44(in_lr,unaff_r4));
  dVar2 = (double)CONCAT44(extraout_r1,uVar1);
  if ((dVar2 == 2147483647.0 || dVar2 < 2147483647.0 != NAN(dVar2)) &&
     (-1 < (int)((uint)(dVar2 < -2147483647.0) << 0x1f))) {
    return;
  }
  png_fixed_error(param_1,"gamma value");
                    // WARNING: Bad instruction - Truncating control flow here
  halt_baddata();
}



void png_set_quantize(int param_1,byte *param_2,uint param_3,uint param_4,int param_5,int param_6)

{
  code *pcVar1;
  byte bVar2;
  byte bVar3;
  undefined2 uVar4;
  int iVar5;
  undefined1 *puVar6;
  undefined4 *puVar7;
  int iVar8;
  byte *pbVar9;
  byte *pbVar10;
  undefined4 uVar11;
  uint uVar12;
  int *piVar13;
  int iVar14;
  int iVar15;
  uint uVar16;
  int iVar17;
  int iVar18;
  int iVar19;
  uint uVar20;
  undefined1 uVar21;
  int iVar22;
  int iVar23;
  uint uVar24;
  int iVar25;
  int iVar26;
  uint uVar27;
  bool bVar28;
  int local_30;
  
  iVar5 = __stack_chk_guard;
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x40;
    if (param_6 == 0) {
      puVar6 = (undefined1 *)png_malloc(param_1,param_3);
      *(undefined1 **)(param_1 + 0x2c0) = puVar6;
      if (0 < (int)param_3) {
        *puVar6 = 0;
        iVar26 = 1;
        do {
          if ((int)param_3 <= iVar26) goto LAB_0002186c;
          *(char *)(*(int *)(param_1 + 0x2c0) + iVar26) = (char)iVar26;
          bVar28 = SBORROW4(iVar26 + 1,iVar26);
          iVar26 = iVar26 + 1;
        } while (!bVar28);
        goto LAB_00021fb2;
      }
    }
LAB_0002186c:
    if ((int)param_4 < (int)param_3) {
      puVar6 = (undefined1 *)png_malloc(param_1,param_3);
      if (param_5 == 0) {
        *(undefined1 **)(param_1 + 800) = puVar6;
        uVar11 = png_malloc(param_1,param_3);
        *(undefined4 *)(param_1 + 0x324) = uVar11;
        if (0 < (int)param_3) {
          iVar26 = 0;
          do {
            *(char *)(*(int *)(param_1 + 800) + iVar26) = (char)iVar26;
            *(char *)(*(int *)(param_1 + 0x324) + iVar26) = (char)iVar26;
            iVar17 = iVar26 + 1;
            if (SBORROW4(iVar17,iVar26)) goto LAB_00021fb2;
            iVar26 = iVar17;
          } while (iVar17 < (int)param_3);
        }
        iVar17 = png_calloc(param_1,0xc04);
        iVar26 = param_6;
        if (param_6 != 0) {
          iVar26 = 1;
        }
        local_30 = 0x60;
        puVar7 = (undefined4 *)0x0;
        uVar12 = param_3;
LAB_000219fe:
        if (!SBORROW4(uVar12,1)) {
          iVar18 = 0;
          do {
            if ((int)(uVar12 - 1) <= iVar18) {
              if ((puVar7 == (undefined4 *)0x0) || (local_30 < 0)) goto LAB_00021bd4;
              iVar18 = 0;
              goto LAB_00021ad4;
            }
            iVar22 = iVar18 + 1;
            if (SBORROW4(iVar22,iVar18)) goto LAB_00021fb2;
            if (iVar22 < (int)uVar12) {
              iVar19 = iVar18 * 3;
              iVar23 = iVar22;
              do {
                iVar25 = iVar23 * 3;
                iVar8 = (uint)param_2[iVar19] - (uint)param_2[iVar25];
                if (iVar8 < 0) {
                  iVar8 = -iVar8;
                }
                iVar14 = (uint)param_2[iVar19 + 1] - (uint)param_2[iVar25 + 1];
                if (iVar14 < 0) {
                  iVar14 = -iVar14;
                }
                iVar25 = (uint)param_2[iVar19 + 2] - (uint)param_2[iVar25 + 2];
                if (iVar25 < 0) {
                  iVar25 = -iVar25;
                }
                iVar25 = iVar8 + iVar14 + iVar25;
                if (iVar25 <= local_30) {
                  puVar7 = (undefined4 *)png_malloc_warn(param_1,8);
                  if (puVar7 == (undefined4 *)0x0) break;
                  *puVar7 = *(undefined4 *)(iVar17 + iVar25 * 4);
                  *(char *)(puVar7 + 1) = (char)iVar18;
                  *(char *)((int)puVar7 + 5) = (char)iVar23;
                  *(undefined4 **)(iVar17 + iVar25 * 4) = puVar7;
                }
                iVar8 = iVar23 + 1;
                if (SBORROW4(iVar8,iVar23)) goto LAB_00021fb2;
                iVar23 = iVar8;
              } while (iVar8 < (int)uVar12);
            }
            iVar18 = iVar22;
          } while (puVar7 != (undefined4 *)0x0);
          puVar7 = (undefined4 *)0x0;
          goto LAB_00021bd4;
        }
        goto LAB_00021fb2;
      }
      *(undefined1 **)(param_1 + 0x31c) = puVar6;
      if ((int)param_3 < 1) {
LAB_000218b4:
        if (!SBORROW4(param_3,1)) {
          iVar26 = param_3 - 1;
          do {
            if (iVar26 < (int)param_4) {
LAB_00021930:
              if (param_6 == 0) {
                if ((int)param_4 < 1) goto LAB_00021ce6;
                uVar12 = param_3;
                iVar26 = 0;
                goto LAB_00021c64;
              }
              if ((int)param_4 < 1) goto LAB_00021dbe;
              iVar17 = *(int *)(param_1 + 0x31c);
              iVar26 = 0;
              goto LAB_00021948;
            }
            bVar28 = true;
            iVar17 = 0;
            while (iVar18 = iVar17, iVar18 < iVar26) {
              iVar17 = iVar18 + 1;
              if (SBORROW4(iVar17,iVar18)) goto LAB_00021fb2;
              iVar22 = *(int *)(param_1 + 0x31c);
              bVar3 = *(byte *)(iVar22 + iVar18);
              if (*(ushort *)(param_5 + (uint)bVar3 * 2) <
                  *(ushort *)(param_5 + (uint)*(byte *)(iVar22 + iVar17) * 2)) {
                *(byte *)(iVar22 + iVar18) = *(byte *)(iVar22 + iVar17);
                bVar28 = false;
                *(byte *)(*(int *)(param_1 + 0x31c) + iVar17) = bVar3;
              }
            }
            if (bVar28) goto LAB_00021930;
            bVar28 = SBORROW4(iVar26,1);
            iVar26 = iVar26 + -1;
          } while (!bVar28);
        }
      }
      else {
        *puVar6 = 0;
        iVar26 = 1;
        do {
          if ((int)param_3 <= iVar26) goto LAB_000218b4;
          *(char *)(*(int *)(param_1 + 0x31c) + iVar26) = (char)iVar26;
          bVar28 = SBORROW4(iVar26 + 1,iVar26);
          iVar26 = iVar26 + 1;
        } while (!bVar28);
      }
LAB_00021fb2:
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x21fb2);
      (*pcVar1)();
    }
    goto LAB_00021dce;
  }
  goto LAB_00021f9a;
  while (iVar18 = iVar22, iVar22 <= local_30) {
LAB_00021ad4:
    for (piVar13 = *(int **)(iVar17 + iVar18 * 4); piVar13 != (int *)0x0; piVar13 = (int *)*piVar13)
    {
      uVar24 = *(uint *)(param_1 + 800);
      uVar20 = (uint)(byte)*(ushort *)(piVar13 + 1);
      if (((int)(uint)*(byte *)(uVar24 + uVar20) < (int)uVar12) &&
         (uVar27 = (uint)(*(ushort *)(piVar13 + 1) >> 8),
         (int)(uint)*(byte *)(uVar24 + uVar27) < (int)uVar12)) {
        uVar16 = uVar27;
        if ((uVar12 & 1) == 0) {
          uVar16 = uVar20;
          uVar20 = uVar27;
        }
        if (SBORROW4(uVar12,1)) goto LAB_00021fb2;
        uVar12 = uVar12 - 1;
        iVar22 = (uint)*(byte *)(uVar24 + uVar20) * 3;
        bVar3 = param_2[uVar12 * 3 + 2];
        *(undefined2 *)(param_2 + iVar22) = *(undefined2 *)(param_2 + uVar12 * 3);
        param_2[iVar22 + 2] = bVar3;
        if (0 < (int)param_3 && iVar26 == 0) {
          iVar22 = 0;
          do {
            iVar19 = *(int *)(param_1 + 0x2c0);
            uVar27 = (uint)*(byte *)(iVar19 + iVar22);
            if (uVar27 == *(byte *)(uVar24 + uVar20)) {
              pbVar10 = (byte *)(uVar24 + uVar16);
              uVar24 = (uint)*pbVar10;
              *(byte *)(iVar19 + iVar22) = *pbVar10;
              iVar19 = *(int *)(param_1 + 0x2c0);
              uVar27 = (uint)*(byte *)(iVar19 + iVar22);
            }
            uVar21 = (undefined1)uVar24;
            if (uVar27 == uVar12) {
              uVar21 = *(undefined1 *)(*(int *)(param_1 + 800) + uVar20);
            }
            if (uVar27 == uVar12) {
              *(undefined1 *)(iVar19 + iVar22) = uVar21;
            }
            iVar19 = iVar22 + 1;
            if (SBORROW4(iVar19,iVar22)) goto LAB_00021fb2;
            uVar24 = *(uint *)(param_1 + 800);
            iVar22 = iVar19;
          } while (iVar19 < (int)param_3);
        }
        *(undefined1 *)(uVar24 + *(byte *)(*(int *)(param_1 + 0x324) + uVar12)) =
             *(undefined1 *)(uVar24 + uVar20);
        *(undefined1 *)
         (*(int *)(param_1 + 0x324) + (uint)*(byte *)(*(int *)(param_1 + 800) + uVar20)) =
             *(undefined1 *)(*(int *)(param_1 + 0x324) + uVar12);
        *(char *)(*(int *)(param_1 + 800) + uVar20) = (char)uVar12;
        *(char *)(*(int *)(param_1 + 0x324) + uVar12) = (char)uVar20;
      }
      if ((int)uVar12 <= (int)param_4) goto LAB_00021bd4;
    }
    iVar22 = iVar18 + 1;
    if (SBORROW4(iVar22,iVar18)) goto LAB_00021fb2;
  }
LAB_00021bd4:
  iVar18 = 0;
  do {
    piVar13 = *(int **)(iVar17 + iVar18 * 4);
    if (piVar13 != (int *)0x0) {
      do {
        piVar13 = (int *)*piVar13;
        png_free(param_1);
      } while (piVar13 != (int *)0x0);
      puVar7 = (undefined4 *)0x0;
    }
    *(undefined4 *)(iVar17 + iVar18 * 4) = 0;
    iVar22 = iVar18 + 1;
    if (SBORROW4(iVar22,iVar18)) goto LAB_00021fb2;
    iVar18 = iVar22;
  } while (iVar22 < 0x301);
  if (SBORROW4(local_30 + 0x60,local_30)) goto LAB_00021fb2;
  local_30 = local_30 + 0x60;
  if ((int)uVar12 <= (int)param_4) goto code_r0x00021c32;
  goto LAB_000219fe;
code_r0x00021c32:
  png_free(param_1,iVar17);
  png_free(param_1,*(undefined4 *)(param_1 + 0x324));
  png_free(param_1,*(undefined4 *)(param_1 + 800));
  *(undefined4 *)(param_1 + 800) = 0;
  *(undefined4 *)(param_1 + 0x324) = 0;
  param_3 = param_4;
  goto LAB_00021dce;
  while (iVar26 = iVar18, iVar18 < (int)param_4) {
LAB_00021948:
    if ((int)param_4 <= (int)(uint)*(byte *)(iVar17 + iVar26)) {
      do {
        if (SBORROW4(param_3,1)) goto LAB_00021fb2;
        param_3 = param_3 - 1;
      } while ((int)param_4 <= (int)(uint)*(byte *)(iVar17 + param_3));
      *(undefined2 *)(param_2 + iVar26 * 3) = *(undefined2 *)(param_2 + param_3 * 3);
      param_2[iVar26 * 3 + 2] = param_2[param_3 * 3 + 2];
    }
    iVar18 = iVar26 + 1;
    if (SBORROW4(iVar18,iVar26)) goto LAB_00021fb2;
  }
  goto LAB_00021dbe;
  while (iVar26 = iVar17, iVar17 < (int)param_4) {
LAB_00021c64:
    if ((int)param_4 <= (int)(uint)*(byte *)(*(int *)(param_1 + 0x31c) + iVar26)) {
      do {
        if (SBORROW4(uVar12,1)) goto LAB_00021fb2;
        uVar12 = uVar12 - 1;
      } while ((int)param_4 <= (int)(uint)*(byte *)(*(int *)(param_1 + 0x31c) + uVar12));
      iVar17 = uVar12 * 3;
      uVar4 = *(undefined2 *)(param_2 + iVar17);
      bVar3 = param_2[iVar17 + 2];
      iVar18 = iVar26 * 3;
      bVar2 = param_2[iVar18 + 2];
      *(undefined2 *)(param_2 + iVar17) = *(undefined2 *)(param_2 + iVar18);
      param_2[iVar17 + 2] = bVar2;
      *(undefined2 *)(param_2 + iVar18) = uVar4;
      param_2[iVar18 + 2] = bVar3;
      *(char *)(*(int *)(param_1 + 0x2c0) + uVar12) = (char)iVar26;
      *(char *)(*(int *)(param_1 + 0x2c0) + iVar26) = (char)uVar12;
    }
    iVar17 = iVar26 + 1;
    if (SBORROW4(iVar17,iVar26)) goto LAB_00021fb2;
  }
LAB_00021ce6:
  if (0 < (int)param_3) {
    iVar26 = 0;
    do {
      uVar12 = (uint)*(byte *)(*(int *)(param_1 + 0x2c0) + iVar26);
      if ((int)param_4 <= (int)uVar12) {
        if ((int)param_4 < 2) {
          uVar21 = 0;
        }
        else {
          iVar18 = uVar12 * 3;
          iVar17 = (uint)param_2[iVar18] - (uint)*param_2;
          if (iVar17 < 0) {
            iVar17 = -iVar17;
          }
          iVar22 = (uint)param_2[iVar18 + 1] - (uint)param_2[1];
          iVar19 = (uint)param_2[iVar18 + 2] - (uint)param_2[2];
          if (iVar22 < 0) {
            iVar22 = -iVar22;
          }
          if (iVar19 < 0) {
            iVar19 = -iVar19;
          }
          iVar19 = iVar17 + iVar22 + iVar19;
          iVar22 = 0;
          iVar17 = 1;
          do {
            iVar25 = iVar17 * 3;
            iVar14 = iVar17 + 1;
            iVar8 = (uint)param_2[iVar18 + 1] - (uint)param_2[iVar25 + 1];
            iVar23 = (uint)param_2[iVar18] - (uint)param_2[iVar25];
            if (iVar23 < 0) {
              iVar23 = -iVar23;
            }
            if (iVar8 < 0) {
              iVar8 = -iVar8;
            }
            iVar25 = (uint)param_2[iVar18 + 2] - (uint)param_2[iVar25 + 2];
            if (iVar25 < 0) {
              iVar25 = -iVar25;
            }
            if (SBORROW4(iVar14,iVar17)) goto LAB_00021fb2;
            iVar25 = iVar8 + iVar23 + iVar25;
            if (iVar25 < iVar19) {
              iVar22 = iVar17;
            }
            uVar21 = (undefined1)iVar22;
            if (iVar25 < iVar19) {
              iVar19 = iVar25;
            }
            iVar17 = iVar14;
          } while (iVar14 < (int)param_4);
        }
        *(undefined1 *)(*(int *)(param_1 + 0x2c0) + iVar26) = uVar21;
      }
      iVar17 = iVar26 + 1;
      if (SBORROW4(iVar17,iVar26)) goto LAB_00021fb2;
      iVar26 = iVar17;
    } while (iVar17 < (int)param_3);
  }
LAB_00021dbe:
  png_free(param_1,*(undefined4 *)(param_1 + 0x31c));
  *(undefined4 *)(param_1 + 0x31c) = 0;
  param_3 = param_4;
LAB_00021dce:
  pbVar9 = *(byte **)(param_1 + 0x1f8);
  pbVar10 = pbVar9;
  if (pbVar9 == (byte *)0x0) {
    pbVar10 = param_2;
  }
  if (pbVar9 == (byte *)0x0) {
    *(byte **)(param_1 + 0x1f8) = pbVar10;
  }
  *(short *)(param_1 + 0x1fc) = (short)param_3;
  if (param_6 == 0) {
LAB_00021f9a:
    iVar26 = __stack_chk_guard - iVar5;
    if (iVar26 == 0) {
      return;
    }
  }
  else {
    uVar11 = png_calloc(param_1,0x8000);
    *(undefined4 *)(param_1 + 700) = uVar11;
    iVar26 = png_malloc(param_1,0x8000);
    __aeabi_memset(iVar26,0x8000,0xff);
    if (0 < (int)param_3) {
      iVar17 = 0;
      do {
        iVar18 = iVar17 * 3;
        uVar12 = (uint)(param_2[iVar18] >> 3);
        uVar24 = (uint)(param_2[iVar18 + 1] >> 3);
        uVar20 = (uint)(param_2[iVar18 + 2] >> 3);
        iVar18 = 0;
        do {
          if ((int)uVar12 < iVar18) {
            if (SBORROW4(iVar18,uVar12)) goto LAB_00021fb2;
            iVar22 = iVar18 - uVar12;
          }
          else {
            if (SBORROW4(uVar12,iVar18)) goto LAB_00021fb2;
            iVar22 = uVar12 - iVar18;
          }
          iVar19 = 0;
          do {
            if ((int)uVar24 < iVar19) {
              if (SBORROW4(iVar19,uVar24)) goto LAB_00021fb2;
              iVar23 = iVar19 - uVar24;
            }
            else {
              if (SBORROW4(uVar24,iVar19)) goto LAB_00021fb2;
              iVar23 = uVar24 - iVar19;
            }
            if (SBORROW4(iVar22 + iVar23,iVar22)) goto LAB_00021fb2;
            iVar8 = iVar23;
            if (iVar23 < iVar22) {
              iVar8 = iVar22;
            }
            uVar27 = 0;
            do {
              if ((int)uVar20 < (int)uVar27) {
                if (SBORROW4(uVar27,uVar20)) goto LAB_00021fb2;
                iVar25 = uVar27 - uVar20;
              }
              else {
                if (SBORROW4(uVar20,uVar27)) goto LAB_00021fb2;
                iVar25 = uVar20 - uVar27;
              }
              iVar14 = iVar25;
              if (iVar25 < iVar8) {
                iVar14 = iVar8;
              }
              iVar15 = iVar14 + iVar22 + iVar23;
              if ((SBORROW4(iVar15,iVar14)) || (iVar25 = iVar15 + iVar25, SBORROW4(iVar25,iVar15)))
              goto LAB_00021fb2;
              uVar16 = iVar18 << 10 | iVar19 << 5 | uVar27;
              if (iVar25 < (int)(uint)*(byte *)(iVar26 + uVar16)) {
                *(char *)(iVar26 + uVar16) = (char)iVar25;
                *(char *)(*(int *)(param_1 + 700) + uVar16) = (char)iVar17;
              }
              uVar16 = uVar27 + 1;
              if (SBORROW4(uVar16,uVar27)) goto LAB_00021fb2;
              uVar27 = uVar16;
            } while ((int)uVar16 < 0x20);
            iVar23 = iVar19 + 1;
            if (SBORROW4(iVar23,iVar19)) goto LAB_00021fb2;
            iVar19 = iVar23;
          } while (iVar23 < 0x20);
          iVar22 = iVar18 + 1;
          if (SBORROW4(iVar22,iVar18)) goto LAB_00021fb2;
          iVar18 = iVar22;
        } while (iVar22 < 0x20);
        iVar18 = iVar17 + 1;
        if (SBORROW4(iVar18,iVar17)) goto LAB_00021fb2;
        iVar17 = iVar18;
      } while (iVar18 < (int)param_3);
    }
    iVar26 = __stack_chk_guard - iVar5;
    if (iVar26 == 0) {
      png_free();
      return;
    }
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iVar26,iVar5);
}



void png_set_gamma_fixed(int param_1,int param_2,int param_3)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  
  if (param_1 == 0) {
    return;
  }
  uVar2 = *(uint *)(param_1 + 0x134);
  if ((uVar2 & 0x40) != 0) {
    png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
    return;
  }
  uVar1 = uVar2 | 0x4000;
  *(uint *)(param_1 + 0x134) = uVar1;
  if (param_2 == -3 || param_2 + 3 < 0 != SCARRY4(param_2,3)) {
    if (param_2 == -100000) {
LAB_00022018:
      uVar1 = uVar2 | 0x5000;
      param_2 = 220000;
      *(uint *)(param_1 + 0x134) = uVar1;
    }
    else if (param_2 == -50000) goto LAB_0002202a;
  }
  else {
    if (param_2 != -2) {
      if (param_2 != -1) goto LAB_00022032;
      goto LAB_00022018;
    }
LAB_0002202a:
    param_2 = 0x250ac;
  }
LAB_00022032:
  iVar3 = 0x10175;
  if (param_3 == -3 || param_3 + 3 < 0 != SCARRY4(param_3,3)) {
    if (param_3 == -100000) {
LAB_00022066:
      iVar3 = 0xb18f;
      *(uint *)(param_1 + 0x134) = uVar1 | 0x1000;
      goto LAB_0002207a;
    }
    if (param_3 == -50000) goto LAB_0002207a;
  }
  else {
    if (param_3 == -2) goto LAB_0002207a;
    if (param_3 == -1) goto LAB_00022066;
  }
  iVar3 = param_3;
  if (param_3 < 1) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"invalid file gamma in png_set_gamma");
  }
LAB_0002207a:
  if (0 < param_2) {
    *(int *)(param_1 + 0x378) = iVar3;
    *(ushort *)(param_1 + 0x3c2) = *(ushort *)(param_1 + 0x3c2) | 1;
    *(int *)(param_1 + 0x240) = param_2;
    return;
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"invalid screen gamma in png_set_gamma");
}



void png_set_gamma(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                  undefined4 param_5)

{
  undefined4 uVar1;
  undefined4 uVar2;
  
  uVar1 = FUN_00021730(param_3);
  uVar2 = FUN_00021730(param_5,param_1);
  png_set_gamma_fixed(param_1,uVar1,uVar2);
  return;
}



void png_set_palette_to_rgb(int param_1)

{
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x2001000;
  }
  return;
}



void png_set_expand_gray_1_2_4_to_8(int param_1)

{
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x1000;
  }
  return;
}



void png_set_expand_16(int param_1)

{
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x2001200;
  }
  return;
}



void png_set_gray_to_rgb(int param_1)

{
  if (param_1 != 0) {
    if ((*(uint *)(param_1 + 0x134) & 0x40) != 0) {
      png_app_error(param_1,"invalid after png_start_read_image or png_read_update_info");
      return;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
    png_set_expand_gray_1_2_4_to_8(param_1);
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x4000;
  }
  return;
}



void png_set_rgb_to_gray_fixed(int param_1,int param_2,uint param_3,uint param_4)

{
  code *pcVar1;
  uint uVar2;
  char *pcVar3;
  bool bVar4;
  
  if (param_1 == 0) {
    return;
  }
  if ((*(uint *)(param_1 + 0x134) & 0x40) == 0) {
    if ((*(byte *)(param_1 + 0x130) & 1) != 0) {
      *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x4000;
      if (param_2 == 3) {
        uVar2 = *(uint *)(param_1 + 0x138) | 0x200000;
      }
      else if (param_2 == 2) {
        uVar2 = *(uint *)(param_1 + 0x138) | 0x400000;
      }
      else {
        if (param_2 != 1) {
                    // WARNING: Subroutine does not return
          png_error(param_1,"invalid error action to rgb_to_gray");
        }
        uVar2 = *(uint *)(param_1 + 0x138) | 0x600000;
      }
      *(uint *)(param_1 + 0x138) = uVar2;
      bVar4 = *(char *)(param_1 + 0x20b) == '\x03';
      if (bVar4) {
        uVar2 = uVar2 | 0x1000;
      }
      if (bVar4) {
        *(uint *)(param_1 + 0x138) = uVar2;
      }
      if (-1 < (int)(param_4 | param_3)) {
        if (SBORROW4(param_3 + param_4,param_3)) {
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x2229e);
          (*pcVar1)();
        }
        if ((int)(param_3 + param_4) < 0x186a1) {
          *(short *)(param_1 + 0x2fe) = (short)((param_3 << 0xf) / 100000);
          *(short *)(param_1 + 0x300) = (short)((param_4 << 0xf) / 100000);
          *(undefined1 *)(param_1 + 0x2fd) = 1;
          return;
        }
        png_app_warning(param_1,"ignoring out of range rgb_to_gray coefficients");
      }
      if (*(short *)(param_1 + 0x2fe) != 0) {
        return;
      }
      if (*(short *)(param_1 + 0x300) != 0) {
        return;
      }
      *(undefined4 *)(param_1 + 0x2fe) = 0x5b8a1b38;
      return;
    }
    pcVar3 = "invalid before the PNG header has been read";
  }
  else {
    pcVar3 = "invalid after png_start_read_image or png_read_update_info";
  }
  png_app_error(param_1,pcVar3);
  return;
}



void png_set_rgb_to_gray(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4
                        ,undefined4 param_5,undefined4 param_6)

{
  undefined4 uVar1;
  undefined8 uVar2;
  
  uVar2 = png_fixed(param_1);
  uVar1 = png_fixed(param_1,(int)((ulonglong)uVar2 >> 0x20),param_5,param_6,
                    "rgb to gray green coefficient");
  png_set_rgb_to_gray_fixed(param_1,param_2,(int)uVar2,uVar1);
  return;
}



void png_set_read_user_transform_fn(int param_1,undefined4 param_2)

{
  *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x100000;
  *(undefined4 *)(param_1 + 0x120) = param_2;
  return;
}



void png_init_read_transformations(int param_1)

{
  code *pcVar1;
  char cVar2;
  ushort uVar3;
  byte bVar4;
  byte bVar5;
  short sVar6;
  undefined2 uVar7;
  undefined4 uVar8;
  undefined4 uVar9;
  short sVar10;
  int iVar11;
  uint uVar12;
  int iVar13;
  uint uVar14;
  int iVar15;
  uint uVar16;
  int iVar17;
  undefined4 uVar18;
  uint uVar19;
  undefined1 uVar20;
  undefined1 uVar21;
  bool bVar22;
  undefined1 local_30;
  undefined4 local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar11 = *(int *)(param_1 + 0x378);
  iVar13 = *(int *)(param_1 + 0x240);
  if (iVar11 == 0) {
    if (iVar13 == 0) {
      uVar8 = 100000;
      *(undefined4 *)(param_1 + 0x378) = 100000;
      goto LAB_00022368;
    }
    uVar8 = png_reciprocal(iVar13);
    *(undefined4 *)(param_1 + 0x378) = uVar8;
LAB_0002236c:
    iVar11 = 0;
  }
  else {
    if (iVar13 == 0) {
      uVar8 = png_reciprocal(iVar11);
LAB_00022368:
      *(undefined4 *)(param_1 + 0x240) = uVar8;
      goto LAB_0002236c;
    }
    iVar11 = png_muldiv(&local_2c,iVar11,iVar13,100000);
    if (iVar11 == 0) {
      iVar11 = 1;
    }
    else {
      iVar11 = png_gamma_significant(local_2c);
      if (iVar11 != 0) {
        iVar11 = 1;
      }
    }
  }
  *(ushort *)(param_1 + 0x3c2) = *(ushort *)(param_1 + 0x3c2) | 1;
  uVar12 = *(uint *)(param_1 + 0x138) | 0x2000;
  if (iVar11 == 0) {
    uVar12 = *(uint *)(param_1 + 0x138) & 0xffffdfff;
  }
  *(uint *)(param_1 + 0x138) = uVar12;
  if ((uVar12 & 0x40080) == 0x40000) {
    *(uint *)(param_1 + 0x138) = uVar12 & 0xfd7ffeff;
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) & 0xffffdfff;
    *(undefined2 *)(param_1 + 0x204) = 0;
  }
  iVar11 = png_gamma_significant(*(undefined4 *)(param_1 + 0x240));
  uVar12 = *(uint *)(param_1 + 0x138);
  if (iVar11 == 0) {
    uVar12 = uVar12 & 0xff7fffff;
    *(uint *)(param_1 + 0x138) = uVar12;
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) & 0xffffdfff;
  }
  if ((uVar12 & 0x600000) != 0) {
    png_colorspace_set_rgb_coefficients(param_1);
    uVar12 = *(uint *)(param_1 + 0x138);
  }
  if ((uVar12 & 0x100) == 0) {
    if ((uVar12 & 0x4080) == 0x4080) {
      uVar14 = *(uint *)(param_1 + 0x220);
      uVar3 = *(ushort *)(param_1 + 0x21e);
      if ((uint)uVar3 == (uVar14 & 0xffff)) {
        bVar22 = (uint)uVar3 == uVar14 >> 0x10;
        if (bVar22) {
          uVar14 = *(uint *)(param_1 + 0x130) | 0x800;
        }
        if (bVar22) {
          *(uint *)(param_1 + 0x130) = uVar14;
        }
        if (bVar22) {
          *(ushort *)(param_1 + 0x224) = uVar3;
        }
      }
    }
  }
  else {
    uVar14 = (uint)*(byte *)(param_1 + 0x20b);
    bVar22 = (*(byte *)(param_1 + 0x20b) & 2) == 0;
    if (bVar22) {
      uVar14 = *(uint *)(param_1 + 0x130) | 0x800;
    }
    if (bVar22) {
      *(uint *)(param_1 + 0x130) = uVar14;
    }
  }
  bVar5 = *(byte *)(param_1 + 0x20b);
  uVar14 = (uint)bVar5;
  uVar16 = uVar12;
  if (uVar14 == 3) {
    uVar14 = (uint)*(ushort *)(param_1 + 0x204);
    if (uVar14 == 0) {
      bVar22 = false;
    }
    else {
      bVar22 = false;
      iVar11 = 0;
      do {
        cVar2 = *(char *)(*(int *)(param_1 + 0x268) + iVar11);
        if (cVar2 != -1) {
          if (cVar2 != '\0') goto LAB_00022510;
          bVar22 = true;
        }
        iVar13 = iVar11 + 1;
        if (SBORROW4(iVar13,iVar11)) goto LAB_00022c08;
        iVar11 = iVar13;
      } while (iVar13 < (int)uVar14);
    }
    *(uint *)(param_1 + 0x138) = uVar12 & 0xff7fffff;
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) & 0xffffdfff;
    uVar16 = uVar12 & 0xff7fffff;
    if (!bVar22) {
      *(uint *)(param_1 + 0x138) = uVar12 & 0xff7ffe7f;
      uVar16 = uVar12 & 0xff7ffe7f;
    }
LAB_00022510:
    if ((uVar16 & 0x1100) == 0x1100) {
      iVar11 = (uint)*(byte *)(param_1 + 0x21c) * 3;
      iVar13 = iVar11 + *(int *)(param_1 + 0x1f8);
      *(ushort *)(param_1 + 0x21e) = (ushort)*(byte *)(*(int *)(param_1 + 0x1f8) + iVar11);
      *(ushort *)(param_1 + 0x220) = (ushort)*(byte *)(iVar13 + 1);
      *(ushort *)(param_1 + 0x222) = (ushort)*(byte *)(iVar13 + 2);
      if (((uVar16 & 0x2080000) == 0x80000) && (uVar14 != 0)) {
        iVar13 = *(int *)(param_1 + 0x268);
        iVar11 = 0;
        do {
          *(byte *)(iVar13 + iVar11) = ~*(byte *)(iVar13 + iVar11);
          iVar15 = iVar11 + 1;
          if (SBORROW4(iVar15,iVar11)) goto LAB_00022c08;
          iVar11 = iVar15;
        } while (iVar15 < (int)uVar14);
        uVar16 = *(uint *)(param_1 + 0x138);
      }
    }
  }
  else {
    if ((bVar5 & 4) == 0) {
      *(uint *)(param_1 + 0x138) = uVar12 & 0xff7fffff;
      *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) & 0xffffdfff;
      uVar16 = uVar12 & 0xff7fffff;
      if (*(short *)(param_1 + 0x204) == 0) {
        *(uint *)(param_1 + 0x138) = uVar12 & 0xff7ffe7f;
        uVar16 = uVar12 & 0xff7ffe7f;
      }
    }
    bVar22 = (bVar5 & 2) == 0;
    if (bVar22) {
      uVar14 = uVar16 & 0x1100;
    }
    if (bVar22 && uVar14 == 0x1100) {
      cVar2 = *(char *)(param_1 + 0x20c);
      sVar6 = *(short *)(param_1 + 0x274);
      sVar10 = *(short *)(param_1 + 0x224);
      if (cVar2 == '\x04') {
        sVar6 = sVar6 * 0x11;
        sVar10 = sVar10 * 0x11;
      }
      else if (cVar2 == '\x02') {
        sVar6 = sVar6 * 0x55;
        sVar10 = sVar10 * 0x55;
      }
      else if (cVar2 == '\x01') {
        sVar6 = sVar6 * 0xff;
        sVar10 = sVar10 * 0xff;
      }
      *(short *)(param_1 + 0x222) = sVar10;
      bVar22 = (uVar16 & 0x2000000) == 0;
      *(short *)(param_1 + 0x220) = sVar10;
      *(short *)(param_1 + 0x21e) = sVar10;
      if (bVar22) {
        *(short *)(param_1 + 0x272) = sVar6;
      }
      if (bVar22) {
        *(short *)(param_1 + 0x270) = sVar6;
      }
      if (bVar22) {
        *(short *)(param_1 + 0x26e) = sVar6;
      }
    }
  }
  if (((uVar16 & 0x380) == 0x280) && (*(char *)(param_1 + 0x20c) != '\x10')) {
    *(short *)(param_1 + 0x21e) =
         (short)((uint)*(ushort *)(param_1 + 0x21e) * 0xff + 0x807f >> 0x10);
    uVar12 = *(uint *)(param_1 + 0x220);
    *(short *)(param_1 + 0x220) = (short)((uVar12 & 0xffff) * 0xff + 0x807f >> 0x10);
    *(short *)(param_1 + 0x222) =
         (short)(((uVar12 >> 0x10) * 0x100 - (uVar12 >> 0x10)) + 0x807f >> 0x10);
    *(short *)(param_1 + 0x224) =
         (short)((uint)*(ushort *)(param_1 + 0x224) * 0xff + 0x807f >> 0x10);
  }
  if ((((uVar16 & 0x180) == 0x80) && ((uVar16 & 0x4000400) != 0)) &&
     (*(char *)(param_1 + 0x20c) == '\x10')) {
    *(short *)(param_1 + 0x21e) = *(short *)(param_1 + 0x21e) * 0x101;
    uVar12 = *(uint *)(param_1 + 0x220);
    *(short *)(param_1 + 0x220) = (short)uVar12 + (short)(uVar12 << 8);
    *(short *)(param_1 + 0x222) = (short)(uVar12 >> 0x10) + (short)((uVar12 >> 0x10) << 8);
    *(short *)(param_1 + 0x224) = *(short *)(param_1 + 0x224) * 0x101;
  }
  __aeabi_memcpy(param_1 + 0x226,param_1 + 0x21c,10);
  if ((uVar16 & 0x2000) == 0) {
    if ((uVar16 & 0x600000) != 0) {
      iVar11 = png_gamma_significant(*(undefined4 *)(param_1 + 0x378));
      if ((iVar11 != 0) ||
         (iVar11 = png_gamma_significant(*(undefined4 *)(param_1 + 0x240)), iVar11 != 0))
      goto LAB_000226b2;
      uVar16 = *(uint *)(param_1 + 0x138);
    }
    if (((uVar16 & 0x80) != 0) &&
       (((iVar11 = png_gamma_significant(*(undefined4 *)(param_1 + 0x378)), iVar11 != 0 ||
         (iVar11 = png_gamma_significant(*(undefined4 *)(param_1 + 0x240)), iVar11 != 0)) ||
        ((*(char *)(param_1 + 0x216) == '\x03' &&
         (iVar11 = png_gamma_significant(*(undefined4 *)(param_1 + 0x218)), iVar11 != 0))))))
    goto LAB_000226b2;
    uVar12 = *(uint *)(param_1 + 0x138);
    if ((uVar12 & 0x800000) != 0) {
      iVar11 = png_gamma_significant(*(undefined4 *)(param_1 + 0x240));
      if (iVar11 != 0) goto LAB_000226b2;
      uVar12 = *(uint *)(param_1 + 0x138);
    }
    if (((uVar12 & 0x80) == 0) || (*(char *)(param_1 + 0x20b) != '\x03')) goto LAB_00022a56;
    uVar3 = *(ushort *)(param_1 + 0x204);
    if (uVar3 != 0) {
      uVar12 = *(uint *)(param_1 + 0x220);
      bVar5 = *(byte *)(param_1 + 0x21e);
      iVar13 = *(int *)(param_1 + 0x1f8);
      bVar4 = (byte)(uVar12 >> 0x10);
      iVar11 = 0;
      do {
        uVar14 = (uint)*(byte *)(*(int *)(param_1 + 0x268) + iVar11);
        if (uVar14 != 0xff) {
          if (uVar14 == 0) {
            *(byte *)(iVar13 + iVar11 * 3) = bVar5;
            iVar15 = iVar11 * 3 + iVar13;
            *(char *)(iVar15 + 1) = (char)uVar12;
            *(byte *)(iVar15 + 2) = bVar4;
          }
          else {
            iVar15 = iVar11 * 3;
            iVar17 = iVar13 + iVar15;
            uVar14 = (uVar14 ^ 0xff) * (uint)bVar5 + uVar14 * *(byte *)(iVar13 + iVar15) + 0x80;
            *(char *)(iVar13 + iVar15) = (char)(uVar14 + (uVar14 >> 8 & 0xff) >> 8);
            uVar14 = (uint)*(byte *)(*(int *)(param_1 + 0x268) + iVar11);
            uVar14 = uVar14 * *(byte *)(iVar17 + 1) + (uVar14 ^ 0xff) * (uVar12 & 0xff) + 0x80;
            *(char *)(iVar17 + 1) = (char)(uVar14 + (uVar14 >> 8 & 0xff) >> 8);
            uVar14 = (uint)*(byte *)(*(int *)(param_1 + 0x268) + iVar11);
            uVar14 = uVar14 * *(byte *)(iVar17 + 2) + (uVar14 ^ 0xff) * (uint)bVar4 + 0x80;
            *(char *)(iVar17 + 2) = (char)(uVar14 + (uVar14 >> 8 & 0xff) >> 8);
          }
        }
        iVar15 = iVar11 + 1;
        if (SBORROW4(iVar15,iVar11)) goto LAB_00022c08;
        iVar11 = iVar15;
      } while (iVar15 < (int)(uint)uVar3);
      uVar12 = *(uint *)(param_1 + 0x138);
    }
    uVar12 = uVar12 & 0xffffff7f;
  }
  else {
LAB_000226b2:
    png_build_gamma_table(param_1,*(undefined1 *)(param_1 + 0x20c));
    uVar12 = *(uint *)(param_1 + 0x138);
    if ((uVar12 & 0x80) == 0) {
      if ((*(char *)(param_1 + 0x20b) != '\x03') ||
         ((uVar12 & 0x1000) != 0 && (uVar12 & 0x600000) != 0)) goto LAB_00022a56;
      uVar3 = *(ushort *)(param_1 + 0x1fc);
      if (uVar3 != 0) {
        iVar13 = *(int *)(param_1 + 0x1f8);
        iVar11 = 0;
        do {
          iVar15 = iVar11 * 3;
          *(undefined1 *)(iVar13 + iVar15) =
               *(undefined1 *)(*(int *)(param_1 + 0x244) + (uint)*(byte *)(iVar13 + iVar15));
          iVar15 = iVar13 + iVar15;
          *(undefined1 *)(iVar15 + 1) =
               *(undefined1 *)(*(int *)(param_1 + 0x244) + (uint)*(byte *)(iVar15 + 1));
          *(undefined1 *)(iVar15 + 2) =
               *(undefined1 *)(*(int *)(param_1 + 0x244) + (uint)*(byte *)(iVar15 + 2));
          iVar15 = iVar11 + 1;
          if (SBORROW4(iVar15,iVar11)) goto LAB_00022c08;
          iVar11 = iVar15;
        } while (iVar15 < (int)(uint)uVar3);
        uVar12 = *(uint *)(param_1 + 0x138);
      }
      uVar12 = uVar12 & 0xffffdfff;
    }
    else {
      if (*(char *)(param_1 + 0x20b) != '\x03') {
        cVar2 = *(char *)(param_1 + 0x216);
        if (cVar2 == '\x03') {
          uVar8 = png_reciprocal(*(undefined4 *)(param_1 + 0x218));
          uVar18 = *(undefined4 *)(param_1 + 0x218);
          uVar9 = *(undefined4 *)(param_1 + 0x240);
LAB_000227d4:
          uVar18 = png_reciprocal2(uVar18,uVar9);
        }
        else {
          if (cVar2 == '\x02') {
            uVar8 = png_reciprocal(*(undefined4 *)(param_1 + 0x378));
            uVar9 = *(undefined4 *)(param_1 + 0x240);
            uVar18 = *(undefined4 *)(param_1 + 0x378);
            goto LAB_000227d4;
          }
          if (cVar2 != '\x01') {
                    // WARNING: Subroutine does not return
            png_error(param_1,"invalid background gamma type");
          }
          uVar8 = *(undefined4 *)(param_1 + 0x240);
          uVar18 = 100000;
        }
        iVar11 = png_gamma_significant(uVar8);
        iVar13 = png_gamma_significant(uVar18);
        if (iVar11 != 0) {
          uVar7 = png_gamma_correct(param_1,*(undefined2 *)(param_1 + 0x224),uVar8);
          *(undefined2 *)(param_1 + 0x22e) = uVar7;
        }
        if (iVar13 != 0) {
          uVar7 = png_gamma_correct(param_1,*(undefined2 *)(param_1 + 0x224),uVar18);
          *(undefined2 *)(param_1 + 0x224) = uVar7;
        }
        uVar3 = *(ushort *)(param_1 + 0x21e);
        uVar12 = (uint)uVar3;
        if ((uVar12 == (*(uint *)(param_1 + 0x220) & 0xffff) &&
             uVar12 == *(uint *)(param_1 + 0x220) >> 0x10) &&
           (uVar12 == *(ushort *)(param_1 + 0x224))) {
          uVar7 = *(undefined2 *)(param_1 + 0x22e);
          *(undefined2 *)(param_1 + 0x22c) = uVar7;
          *(undefined2 *)(param_1 + 0x22a) = uVar7;
          *(undefined2 *)(param_1 + 0x228) = uVar7;
          *(ushort *)(param_1 + 0x222) = uVar3;
          *(ushort *)(param_1 + 0x220) = uVar3;
        }
        else {
          if (iVar11 != 0) {
            uVar7 = png_gamma_correct(param_1,uVar12,uVar8);
            *(undefined2 *)(param_1 + 0x228) = uVar7;
            uVar7 = png_gamma_correct(param_1,*(undefined2 *)(param_1 + 0x220),uVar8);
            *(undefined2 *)(param_1 + 0x22a) = uVar7;
            uVar7 = png_gamma_correct(param_1,*(undefined2 *)(param_1 + 0x222),uVar8);
            *(undefined2 *)(param_1 + 0x22c) = uVar7;
          }
          if (iVar13 != 0) {
            uVar7 = png_gamma_correct(param_1,*(undefined2 *)(param_1 + 0x21e),uVar18);
            *(undefined2 *)(param_1 + 0x21e) = uVar7;
            uVar7 = png_gamma_correct(param_1,*(undefined2 *)(param_1 + 0x220),uVar18);
            *(undefined2 *)(param_1 + 0x220) = uVar7;
            uVar7 = png_gamma_correct(param_1,*(undefined2 *)(param_1 + 0x222),uVar18);
            *(undefined2 *)(param_1 + 0x222) = uVar7;
          }
        }
        *(undefined1 *)(param_1 + 0x216) = 1;
        uVar12 = *(uint *)(param_1 + 0x138);
        goto LAB_00022a56;
      }
      cVar2 = *(char *)(param_1 + 0x216);
      uVar3 = *(ushort *)(param_1 + 0x1fc);
      iVar11 = *(int *)(param_1 + 0x1f8);
      if (cVar2 == '\x02') {
        iVar13 = *(int *)(param_1 + 0x244);
        iVar15 = *(int *)(param_1 + 0x250);
        uVar19 = *(uint *)(param_1 + 0x220) >> 0x10;
        uVar16 = *(uint *)(param_1 + 0x220) & 0xffff;
        uVar21 = *(undefined1 *)(iVar13 + (uint)*(ushort *)(param_1 + 0x21e));
        uVar12 = (uint)*(byte *)(iVar15 + (uint)*(ushort *)(param_1 + 0x21e));
        bVar5 = *(byte *)(iVar15 + uVar19);
        uVar14 = (uint)*(byte *)(iVar15 + uVar16);
        local_30 = *(undefined1 *)(iVar13 + uVar19);
        uVar20 = *(undefined1 *)(iVar13 + uVar16);
      }
      else {
        if (cVar2 == '\x03') {
          uVar8 = png_reciprocal(*(undefined4 *)(param_1 + 0x218));
          uVar18 = *(undefined4 *)(param_1 + 0x218);
          uVar9 = *(undefined4 *)(param_1 + 0x240);
LAB_000228d6:
          uVar18 = png_reciprocal2(uVar18,uVar9);
        }
        else {
          if (cVar2 == '\x02') {
            uVar8 = png_reciprocal(*(undefined4 *)(param_1 + 0x378));
            uVar9 = *(undefined4 *)(param_1 + 0x240);
            uVar18 = *(undefined4 *)(param_1 + 0x378);
            goto LAB_000228d6;
          }
          if (cVar2 == '\x01') {
            uVar18 = 100000;
            uVar8 = *(undefined4 *)(param_1 + 0x240);
          }
          else {
            uVar18 = 100000;
            uVar8 = uVar18;
          }
        }
        iVar13 = png_gamma_significant(uVar18);
        uVar7 = *(undefined2 *)(param_1 + 0x21e);
        if (iVar13 == 0) {
          uVar9 = *(undefined4 *)(param_1 + 0x220);
          local_30 = (undefined1)((uint)uVar9 >> 0x10);
        }
        else {
          uVar7 = png_gamma_8bit_correct(uVar7,uVar18);
          uVar9 = png_gamma_8bit_correct(*(undefined2 *)(param_1 + 0x220),uVar18);
          local_30 = png_gamma_8bit_correct(*(undefined2 *)(param_1 + 0x222),uVar18);
        }
        uVar20 = (undefined1)uVar9;
        uVar21 = (undefined1)uVar7;
        iVar13 = png_gamma_significant(uVar8);
        uVar12 = (uint)*(ushort *)(param_1 + 0x21e);
        if (iVar13 == 0) {
          uVar14 = *(uint *)(param_1 + 0x220);
          bVar5 = (byte)(uVar14 >> 0x10);
        }
        else {
          uVar12 = png_gamma_8bit_correct(uVar12,uVar8);
          uVar14 = png_gamma_8bit_correct(*(undefined2 *)(param_1 + 0x220),uVar8);
          bVar5 = png_gamma_8bit_correct(*(undefined2 *)(param_1 + 0x222),uVar8);
        }
      }
      if (uVar3 != 0) {
        iVar13 = 0;
        do {
          if ((iVar13 < (int)(uint)*(ushort *)(param_1 + 0x204)) &&
             (uVar16 = (uint)*(byte *)(*(int *)(param_1 + 0x268) + iVar13), uVar16 != 0xff)) {
            if (uVar16 == 0) {
              *(undefined1 *)(iVar11 + iVar13 * 3) = uVar21;
              iVar15 = iVar13 * 3 + iVar11;
              *(undefined1 *)(iVar15 + 1) = uVar20;
              *(undefined1 *)(iVar15 + 2) = local_30;
            }
            else {
              iVar15 = iVar13 * 3;
              uVar16 = (uVar16 ^ 0xff) * (uVar12 & 0xff) +
                       uVar16 * *(byte *)(*(int *)(param_1 + 0x250) +
                                         (uint)*(byte *)(iVar11 + iVar15)) + 0x80;
              *(undefined1 *)(iVar11 + iVar15) =
                   *(undefined1 *)
                    (*(int *)(param_1 + 0x24c) + ((uVar16 + (uVar16 >> 8 & 0xff)) * 0x10000 >> 0x18)
                    );
              iVar15 = iVar15 + iVar11;
              uVar16 = (uint)*(byte *)(*(int *)(param_1 + 0x268) + iVar13);
              uVar16 = uVar16 * *(byte *)(*(int *)(param_1 + 0x250) + (uint)*(byte *)(iVar15 + 1)) +
                       (uVar16 ^ 0xff) * (uVar14 & 0xff) + 0x80;
              *(undefined1 *)(iVar15 + 1) =
                   *(undefined1 *)
                    (*(int *)(param_1 + 0x24c) + ((uVar16 + (uVar16 >> 8 & 0xff)) * 0x10000 >> 0x18)
                    );
              uVar16 = (uint)*(byte *)(*(int *)(param_1 + 0x268) + iVar13);
              uVar16 = uVar16 * *(byte *)(*(int *)(param_1 + 0x250) + (uint)*(byte *)(iVar15 + 2)) +
                       (uVar16 ^ 0xff) * (uint)bVar5 + 0x80;
              *(undefined1 *)(iVar15 + 2) =
                   *(undefined1 *)
                    (*(int *)(param_1 + 0x24c) + ((uVar16 + (uVar16 >> 8 & 0xff)) * 0x10000 >> 0x18)
                    );
            }
          }
          else {
            iVar15 = iVar13 * 3;
            *(undefined1 *)(iVar11 + iVar15) =
                 *(undefined1 *)(*(int *)(param_1 + 0x244) + (uint)*(byte *)(iVar11 + iVar15));
            iVar15 = iVar11 + iVar15;
            *(undefined1 *)(iVar15 + 1) =
                 *(undefined1 *)(*(int *)(param_1 + 0x244) + (uint)*(byte *)(iVar15 + 1));
            *(undefined1 *)(iVar15 + 2) =
                 *(undefined1 *)(*(int *)(param_1 + 0x244) + (uint)*(byte *)(iVar15 + 2));
          }
          iVar15 = iVar13 + 1;
          if (SBORROW4(iVar15,iVar13)) goto LAB_00022c08;
          iVar13 = iVar15;
        } while (iVar15 < (int)(uint)uVar3);
      }
      uVar12 = *(uint *)(param_1 + 0x138) & 0xffffdf7f;
    }
  }
  *(uint *)(param_1 + 0x138) = uVar12;
LAB_00022a56:
  uVar14 = uVar12 & 0x1008;
  bVar22 = uVar14 == 8;
  if (bVar22) {
    uVar14 = (uint)*(byte *)(param_1 + 0x20b);
  }
  if (bVar22 && uVar14 == 3) {
    uVar14 = (uint)*(ushort *)(param_1 + 0x1fc);
    *(uint *)(param_1 + 0x138) = uVar12 & 0xfffffff7;
    uVar12 = (uint)(byte)*(ushort *)(param_1 + 0x25c);
    if (((uVar12 == 0) || (uVar12 = 8 - uVar12, (int)uVar12 < 1)) || (uVar14 == 0)) {
      uVar12 = (uint)(*(ushort *)(param_1 + 0x25c) >> 8);
    }
    else {
      iVar11 = 0;
      do {
        *(byte *)(*(int *)(param_1 + 0x1f8) + iVar11 * 3) =
             *(byte *)(*(int *)(param_1 + 0x1f8) + iVar11 * 3) >> (uVar12 & 0xff);
        iVar13 = iVar11 + 1;
        if (SBORROW4(iVar13,iVar11)) goto LAB_00022c08;
        iVar11 = iVar13;
      } while (iVar13 < (int)uVar14);
      uVar12 = (uint)*(byte *)(param_1 + 0x25d);
    }
    if (((uVar12 != 0) && (0 < (int)(8 - uVar12))) && (uVar14 != 0)) {
      iVar11 = 0;
      do {
        iVar13 = *(int *)(param_1 + 0x1f8) + iVar11 * 3;
        *(byte *)(iVar13 + 1) = *(byte *)(iVar13 + 1) >> (8 - uVar12 & 0xff);
        iVar13 = iVar11 + 1;
        if (SBORROW4(iVar13,iVar11)) goto LAB_00022c08;
        iVar11 = iVar13;
      } while (iVar13 < (int)uVar14);
    }
    if (((*(byte *)(param_1 + 0x25e) != 0) &&
        (uVar12 = 8 - *(byte *)(param_1 + 0x25e), 0 < (int)uVar12)) && (uVar14 != 0)) {
      iVar11 = 0;
      do {
        iVar13 = *(int *)(param_1 + 0x1f8) + iVar11 * 3;
        *(byte *)(iVar13 + 2) = *(byte *)(iVar13 + 2) >> (uVar12 & 0xff);
        iVar13 = iVar11 + 1;
        if (SBORROW4(iVar13,iVar11)) {
LAB_00022c08:
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x22c08);
          (*pcVar1)();
        }
        iVar11 = iVar13;
      } while (iVar13 < (int)uVar14);
    }
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_read_transform_info(int param_1,int *param_2,undefined4 param_3,undefined2 param_4)

{
  char cVar1;
  undefined1 uVar2;
  byte bVar3;
  char cVar4;
  ushort uVar5;
  byte bVar6;
  char cVar7;
  ushort uVar8;
  ushort uVar9;
  uint uVar10;
  bool bVar11;
  
  uVar10 = *(uint *)(param_1 + 0x138);
  if ((uVar10 & 0x1000) != 0) {
    if (*(byte *)((int)param_2 + 0x19) == 3) {
      uVar2 = 6;
      if (*(short *)(param_1 + 0x204) == 0) {
        uVar2 = 2;
      }
      *(undefined1 *)((int)param_2 + 0x19) = uVar2;
      *(undefined1 *)(param_2 + 6) = 8;
      *(undefined2 *)((int)param_2 + 0x16) = 0;
      if (*(int *)(param_1 + 0x1f8) == 0) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Palette is NULL in indexed image");
      }
    }
    else {
      if ((uVar10 & 0x2000000) != 0 && *(short *)(param_1 + 0x204) != 0) {
        *(byte *)((int)param_2 + 0x19) = *(byte *)((int)param_2 + 0x19) | 4;
      }
      bVar6 = *(byte *)(param_2 + 6);
      bVar3 = bVar6;
      if (bVar6 < 8) {
        bVar3 = 8;
      }
      if (bVar6 < 8) {
        *(byte *)(param_2 + 6) = bVar3;
      }
      *(undefined2 *)((int)param_2 + 0x16) = 0;
    }
  }
  if ((uVar10 & 0x80) != 0) {
    __aeabi_memcpy((int)param_2 + 0xaa,param_1 + 0x21c,10);
  }
  param_2[10] = *(int *)(param_1 + 0x378);
  uVar5 = *(ushort *)(param_2 + 6);
  uVar8 = uVar5 >> 8;
  if ((char)uVar5 == '\x10') {
    bVar11 = (uVar10 & 0x4000000) != 0;
    if (bVar11) {
      uVar5 = 8;
    }
    if (bVar11) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
    else {
      uVar5 = 0x10;
    }
    bVar11 = (uVar10 & 0x400) != 0;
    if (bVar11) {
      uVar5 = 8;
    }
    if (bVar11) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
  }
  bVar11 = (uVar10 & 0x4000) != 0;
  if (bVar11) {
    uVar8 = uVar8 | 2;
  }
  if (bVar11) {
    *(char *)((int)param_2 + 0x19) = (char)uVar8;
  }
  bVar11 = (uVar10 & 0x600000) != 0;
  if (bVar11) {
    uVar8 = uVar8 & 0xfd;
  }
  if (bVar11) {
    *(char *)((int)param_2 + 0x19) = (char)uVar8;
  }
  if ((((uVar10 & 0x40) != 0) && ((uVar8 | 4) == 6)) && (*(int *)(param_1 + 700) != 0)) {
    bVar11 = (uVar5 & 0xff) == 8;
    if (bVar11) {
      uVar8 = 3;
    }
    if (bVar11) {
      *(char *)((int)param_2 + 0x19) = (char)uVar8;
    }
  }
  if (((uVar5 & 0xff) == 8) && ((uVar10 & 0x200) != 0)) {
    if (uVar8 != 3) {
      uVar5 = 0x10;
    }
    if (uVar8 != 3) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
  }
  if ((uVar10 & 4) != 0) {
    uVar9 = uVar5 & 0xff;
    if (uVar9 < 8) {
      uVar5 = 8;
    }
    if (uVar9 < 8) {
      *(char *)(param_2 + 6) = (char)uVar5;
    }
  }
  cVar4 = (char)uVar5;
  if (uVar8 == 3 || (uVar8 & 2) == 0) {
    cVar7 = '\x01';
  }
  else {
    cVar7 = '\x03';
  }
  *(char *)((int)param_2 + 0x1d) = cVar7;
  bVar11 = (uVar10 & 0x40000) != 0;
  if (bVar11) {
    uVar8 = uVar8 & 0xfb;
  }
  bVar6 = (byte)uVar8;
  if (bVar11) {
    *(byte *)((int)param_2 + 0x19) = bVar6;
    param_4 = 0;
  }
  if (bVar11) {
    *(undefined2 *)((int)param_2 + 0x16) = param_4;
  }
  bVar11 = (uVar8 & 4) != 0;
  if (bVar11) {
    cVar7 = cVar7 + '\x01';
  }
  if (bVar11) {
    *(char *)((int)param_2 + 0x1d) = cVar7;
  }
  if (((uVar10 & 0x8000) != 0) && ((uVar8 | 2) == 2)) {
    cVar7 = cVar7 + '\x01';
    *(char *)((int)param_2 + 0x1d) = cVar7;
    bVar11 = (uVar10 & 0x1000000) != 0;
    if (bVar11) {
      bVar6 = bVar6 | 4;
    }
    if (bVar11) {
      *(byte *)((int)param_2 + 0x19) = bVar6;
    }
  }
  if ((uVar10 & 0x100000) != 0) {
    uVar8 = *(ushort *)(param_1 + 300);
    if ((uVar8 & 0xff) != 0) {
      *(char *)(param_2 + 6) = (char)uVar8;
      uVar5 = uVar8;
    }
    cVar4 = (char)uVar5;
    cVar1 = (char)(uVar8 >> 8);
    if (uVar8 >> 8 != 0) {
      *(char *)((int)param_2 + 0x1d) = cVar1;
      cVar7 = cVar1;
    }
  }
  bVar6 = cVar4 * cVar7;
  *(byte *)((int)param_2 + 0x1e) = bVar6;
  if (bVar6 < 8) {
    uVar10 = (uint)bVar6 * *param_2 + 7 >> 3;
  }
  else {
    uVar10 = (uint)(bVar6 >> 3) * *param_2;
  }
  param_2[3] = uVar10;
  *(uint *)(param_1 + 0x1ec) = uVar10;
  return;
}



void png_do_read_transformations(int param_1,uint *param_2)

{
  code *pcVar1;
  byte bVar2;
  byte bVar3;
  undefined1 uVar4;
  undefined1 uVar5;
  uint *puVar6;
  byte bVar7;
  short sVar8;
  undefined2 uVar9;
  ushort uVar10;
  short sVar11;
  char cVar12;
  undefined1 uVar13;
  uint uVar14;
  byte *pbVar15;
  undefined1 *puVar16;
  undefined1 *puVar17;
  int iVar18;
  uint uVar19;
  byte *pbVar20;
  byte *extraout_r1;
  byte bVar21;
  uint uVar22;
  undefined1 *puVar23;
  int iVar24;
  undefined4 uVar25;
  undefined2 *puVar26;
  undefined1 *puVar27;
  uint uVar28;
  uint uVar29;
  byte *unaff_r5;
  uint uVar30;
  byte *pbVar31;
  uint uVar32;
  uint uVar33;
  byte *pbVar34;
  ushort uVar35;
  int iVar36;
  int iVar37;
  int iVar38;
  bool bVar39;
  bool bVar40;
  uint local_38 [4];
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar14 = *(uint *)(param_1 + 0x1e0);
  if (uVar14 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"NULL row buffer");
  }
  if ((*(uint *)(param_1 + 0x134) & 0x4040) == 0x4000) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"Uninitialized row");
  }
  if ((*(uint *)(param_1 + 0x138) & 0x1000) != 0) {
    if ((char)param_2[2] == '\x03') {
      if ((char)(ushort)param_2[2] == '\x03') {
        iVar18 = *(int *)(param_1 + 0x1f8);
        uVar10 = (ushort)param_2[2] >> 8;
        iVar37 = *(int *)(param_1 + 0x268);
        uVar22 = *param_2;
        uVar35 = *(ushort *)(param_1 + 0x204);
        if (uVar10 < 8) {
          unaff_r5 = (byte *)(uVar14 + 1);
          if (uVar10 == 1) {
            if (uVar22 != 0) {
              puVar23 = (undefined1 *)(uVar14 + uVar22);
              uVar28 = 0;
              pbVar31 = unaff_r5 + (uVar22 - 1 >> 3);
              uVar32 = ~(uVar22 + 7) & 7;
              do {
                unaff_r5 = (byte *)(1 << (uVar32 & 0xff));
                uVar13 = (undefined1)((uint)*pbVar31 & (uint)unaff_r5);
                if (((uint)*pbVar31 & (uint)unaff_r5) != 0) {
                  uVar13 = 1;
                }
                *puVar23 = uVar13;
                if (uVar32 == 7) {
                  pbVar31 = pbVar31 + -1;
                  uVar33 = 0;
                }
                else {
                  uVar33 = uVar32 + 1;
                  if (SBORROW4(uVar33,uVar32)) goto LAB_00024bc8;
                  unaff_r5 = (byte *)0x0;
                }
                uVar28 = uVar28 + 1;
                puVar23 = puVar23 + -1;
                uVar32 = uVar33;
              } while (uVar28 < uVar22);
            }
          }
          else if (uVar10 == 2) {
            if (uVar22 != 0) {
              pbVar31 = (byte *)(uVar14 + uVar22);
              uVar28 = 0;
              unaff_r5 = unaff_r5 + (uVar22 - 1 >> 2);
              uVar32 = ~(uVar22 * 2 + 6) & 6;
              do {
                *pbVar31 = *unaff_r5 >> (uVar32 & 0xff) & 3;
                if (uVar32 == 6) {
                  unaff_r5 = unaff_r5 + -1;
                  uVar33 = 0;
                }
                else {
                  uVar33 = uVar32 + 2;
                  if (SBORROW4(uVar33,uVar32)) goto LAB_00024bc8;
                }
                uVar28 = uVar28 + 1;
                pbVar31 = pbVar31 + -1;
                uVar32 = uVar33;
              } while (uVar28 < uVar22);
            }
          }
          else if ((uVar10 == 4) && (uVar22 != 0)) {
            pbVar31 = (byte *)(uVar14 + uVar22);
            uVar28 = 0;
            unaff_r5 = unaff_r5 + (uVar22 - 1 >> 1);
            uVar32 = (uVar22 & 1) << 2;
            do {
              *pbVar31 = *unaff_r5 >> (uVar32 & 0xff) & 0xf;
              if (uVar32 == 4) {
                unaff_r5 = unaff_r5 + -1;
                uVar33 = 0;
              }
              else {
                uVar33 = uVar32 + 4;
                if (SBORROW4(uVar33,uVar32)) {
LAB_00024bc8:
                    // WARNING: Does not return
                  pcVar1 = (code *)software_udf(0xfe,0x24bc8);
                  (*pcVar1)();
                }
              }
              uVar28 = uVar28 + 1;
              pbVar31 = pbVar31 + -1;
              uVar32 = uVar33;
            } while (uVar28 < uVar22);
          }
          *(undefined1 *)((int)param_2 + 9) = 8;
          *(undefined1 *)((int)param_2 + 0xb) = 8;
          param_2[1] = uVar22;
        }
        else if (uVar10 != 8) goto LAB_00022ff6;
        if (uVar35 == 0) {
          uVar32 = uVar22 * 3;
          if (uVar22 != 0) {
            iVar37 = uVar32 - 1;
            do {
              unaff_r5 = (byte *)(uVar14 + iVar37);
              unaff_r5[1] = *(byte *)((uint)*(byte *)(uVar14 + uVar22) * 3 + iVar18 + 2);
              *(undefined1 *)(uVar14 + iVar37) =
                   *(undefined1 *)((uint)*(byte *)(uVar14 + uVar22) * 3 + iVar18 + 1);
              iVar37 = iVar37 + -3;
              pbVar31 = (byte *)(uVar14 + uVar22);
              uVar22 = uVar22 - 1;
              unaff_r5[-1] = *(byte *)(iVar18 + (uint)*pbVar31 * 3);
            } while (uVar22 != 0);
          }
          *(undefined1 *)((int)param_2 + 9) = 8;
          *(undefined1 *)((int)param_2 + 0xb) = 0x18;
          param_2[1] = uVar32;
          *(undefined1 *)(param_2 + 2) = 2;
          *(undefined1 *)((int)param_2 + 10) = 3;
        }
        else {
          uVar32 = uVar22 << 2;
          if (uVar22 != 0) {
            iVar24 = uVar22 * 4 + -1;
            do {
              unaff_r5 = (byte *)(uVar14 + iVar24);
              if ((uint)*(byte *)(uVar14 + uVar22) < (uint)uVar35) {
                bVar21 = *(byte *)(iVar37 + (uint)*(byte *)(uVar14 + uVar22));
              }
              else {
                bVar21 = 0xff;
              }
              unaff_r5[1] = bVar21;
              *(undefined1 *)(uVar14 + iVar24) =
                   *(undefined1 *)((uint)*(byte *)(uVar14 + uVar22) * 3 + iVar18 + 2);
              iVar24 = iVar24 + -4;
              unaff_r5[-1] = *(byte *)((uint)*(byte *)(uVar14 + uVar22) * 3 + iVar18 + 1);
              pbVar31 = (byte *)(uVar14 + uVar22);
              uVar22 = uVar22 - 1;
              unaff_r5[-2] = *(byte *)(iVar18 + (uint)*pbVar31 * 3);
            } while (uVar22 != 0);
          }
          *(undefined1 *)((int)param_2 + 9) = 8;
          *(undefined1 *)((int)param_2 + 0xb) = 0x20;
          param_2[1] = uVar32;
          *(undefined1 *)(param_2 + 2) = 6;
          *(undefined1 *)((int)param_2 + 10) = 4;
        }
      }
    }
    else {
      iVar18 = uVar14 + 1;
      bVar39 = (*(uint *)(param_1 + 0x138) & 0x2000000) == 0;
      if (!bVar39) {
        uVar14 = (uint)*(ushort *)(param_1 + 0x204);
      }
      if (bVar39 || uVar14 == 0) {
        iVar37 = 0;
      }
      else {
        iVar37 = param_1 + 0x26c;
      }
      FUN_00024bdc(param_2,iVar18,iVar37);
    }
  }
LAB_00022ff6:
  uVar14 = *(uint *)(param_1 + 0x138);
  if (((uVar14 & 0x40080) == 0x40000) && ((byte)((byte)param_2[2] | 2) == 6)) {
    png_do_strip_channel(param_2,*(int *)(param_1 + 0x1e0) + 1,0);
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if (((uVar14 & 0x600000) != 0) && (uVar22 = param_2[2], (uVar22 & 3) == 2)) {
    uVar32 = (uint)*(ushort *)(param_1 + 0x2fe);
    uVar28 = (uint)*(ushort *)(param_1 + 0x300);
    pbVar31 = (byte *)(*(int *)(param_1 + 0x1e0) + 1);
    uVar14 = *param_2;
    iVar18 = (0x8000 - uVar32) - uVar28;
    if ((uVar22 & 0xff00) == 0x800) {
      iVar37 = *(int *)(param_1 + 0x24c);
      if (iVar37 != 0) {
        unaff_r5 = *(byte **)(param_1 + 0x250);
      }
      if (iVar37 != 0 && unaff_r5 != (byte *)0x0) {
        if (uVar14 == 0) {
LAB_000232e8:
          bVar39 = false;
        }
        else {
          bVar39 = false;
          uVar33 = uVar14;
          pbVar20 = pbVar31;
          do {
            bVar21 = *pbVar31;
            uVar30 = (uint)bVar21;
            if (uVar30 == pbVar31[1] && uVar30 == pbVar31[2]) {
              if (*(int *)(param_1 + 0x244) != 0) {
                bVar21 = *(byte *)(*(int *)(param_1 + 0x244) + uVar30);
              }
            }
            else {
              bVar39 = true;
              bVar21 = *(byte *)(iVar37 + ((uint)unaff_r5[pbVar31[2]] * iVar18 +
                                           unaff_r5[uVar30] * uVar32 + uVar28 * unaff_r5[pbVar31[1]]
                                           + 0x4000 >> 0xf));
            }
            pbVar15 = pbVar20 + 1;
            *pbVar20 = bVar21;
            if ((uVar22 & 4) == 0) {
              pbVar31 = pbVar31 + 3;
            }
            else {
              pbVar15 = pbVar31 + 3;
              pbVar31 = pbVar31 + 4;
              pbVar20[1] = *pbVar15;
              pbVar15 = pbVar20 + 2;
            }
            uVar33 = uVar33 - 1;
            pbVar20 = pbVar15;
          } while (uVar33 != 0);
        }
      }
      else {
        bVar39 = false;
        uVar33 = uVar14;
        pbVar20 = pbVar31;
        if (uVar14 == 0) {
LAB_00023272:
          bVar39 = false;
        }
        else {
          do {
            bVar21 = *pbVar20;
            uVar30 = (uint)bVar21;
            if (uVar30 != pbVar20[1] || uVar30 != pbVar20[2]) {
              bVar39 = true;
              bVar21 = (byte)((uint)pbVar20[2] * iVar18 + pbVar20[1] * uVar28 + uVar32 * uVar30 >>
                             0xf);
            }
            pbVar15 = pbVar31 + 1;
            *pbVar31 = bVar21;
            if ((uVar22 & 4) == 0) {
              pbVar34 = pbVar20 + 3;
            }
            else {
              pbVar34 = pbVar20 + 4;
              pbVar31[1] = pbVar20[3];
              pbVar15 = pbVar31 + 2;
            }
            uVar33 = uVar33 - 1;
            pbVar31 = pbVar15;
            pbVar20 = pbVar34;
          } while (uVar33 != 0);
        }
      }
    }
    else {
      iVar37 = *(int *)(param_1 + 600);
      if ((iVar37 == 0) || (iVar24 = *(int *)(param_1 + 0x254), iVar24 == 0)) {
        bVar39 = false;
        uVar33 = uVar14;
        pbVar20 = pbVar31;
        if (uVar14 == 0) goto LAB_00023272;
        do {
          bVar21 = pbVar31[2];
          bVar7 = pbVar31[3];
          bVar2 = pbVar31[4];
          uVar30 = (uint)CONCAT11(*pbVar31,pbVar31[1]);
          bVar3 = pbVar31[5];
          uVar19 = (uint)CONCAT11(bVar2,bVar3) * iVar18 +
                   uVar30 * uVar32 + CONCAT11(bVar21,bVar7) * uVar28 + 0x4000;
          *pbVar20 = (byte)(uVar19 >> 0x17);
          pbVar20[1] = (byte)(uVar19 >> 0xf);
          if (uVar30 != CONCAT11(bVar2,bVar3)) {
            bVar39 = true;
          }
          if (uVar30 != CONCAT11(bVar21,bVar7)) {
            bVar39 = true;
          }
          if ((uVar22 & 4) == 0) {
            pbVar20 = pbVar20 + 2;
            pbVar31 = pbVar31 + 6;
          }
          else {
            pbVar20[2] = pbVar31[6];
            pbVar15 = pbVar31 + 7;
            pbVar31 = pbVar31 + 8;
            pbVar20[3] = *pbVar15;
            pbVar20 = pbVar20 + 4;
          }
          uVar33 = uVar33 - 1;
        } while (uVar33 != 0);
      }
      else {
        if (uVar14 == 0) goto LAB_000232e8;
        bVar39 = false;
        uVar33 = uVar14;
        pbVar20 = pbVar31;
        do {
          bVar21 = *pbVar20;
          bVar7 = pbVar20[1];
          uVar35 = (ushort)bVar7;
          sVar8 = CONCAT11(bVar21,bVar7);
          sVar11 = CONCAT11(pbVar20[2],pbVar20[3]);
          bVar40 = sVar8 == sVar11;
          if (bVar40) {
            sVar11 = CONCAT11(pbVar20[4],pbVar20[5]);
          }
          if (bVar40 && sVar8 == sVar11) {
            if (*(int *)(param_1 + 0x248) != 0) {
              uVar35 = *(ushort *)
                        (*(int *)(*(int *)(param_1 + 0x248) +
                                 (uint)(bVar7 >> (*(uint *)(param_1 + 0x23c) & 0xff)) * 4) +
                        (uint)bVar21 * 2);
              bVar21 = (byte)(uVar35 >> 8);
            }
          }
          else {
            uVar30 = *(uint *)(param_1 + 0x23c);
            iVar36 = (uint)*(ushort *)
                            (*(int *)(iVar37 + (uint)(pbVar20[5] >> (uVar30 & 0xff)) * 4) +
                            (uint)pbVar20[4] * 2) * iVar18 +
                     *(ushort *)
                      (*(int *)(iVar37 + (uint)(bVar7 >> (uVar30 & 0xff)) * 4) + (uint)bVar21 * 2) *
                     uVar32 + uVar28 * *(ushort *)
                                        (*(int *)(iVar37 + (uint)(pbVar20[3] >> (uVar30 & 0xff)) * 4
                                                 ) + (uint)pbVar20[2] * 2) + 0x4000;
            uVar35 = *(ushort *)
                      (*(int *)(iVar24 + (((uint)(iVar36 * 0x200) >> 0x18) >> (uVar30 & 0xff)) * 4)
                      + ((uint)(iVar36 * 2) >> 0x18) * 2);
            bVar39 = true;
            bVar21 = (byte)(uVar35 >> 8);
          }
          *pbVar31 = bVar21;
          pbVar31[1] = (byte)uVar35;
          if ((uVar22 & 4) == 0) {
            pbVar20 = pbVar20 + 6;
            pbVar31 = pbVar31 + 2;
          }
          else {
            pbVar31[2] = pbVar20[6];
            pbVar15 = pbVar20 + 7;
            pbVar20 = pbVar20 + 8;
            pbVar31[3] = *pbVar15;
            pbVar31 = pbVar31 + 4;
          }
          uVar33 = uVar33 - 1;
        } while (uVar33 != 0);
      }
    }
    cVar12 = *(char *)((int)param_2 + 10) + -2;
    *(char *)((int)param_2 + 10) = cVar12;
    bVar21 = (char)((ushort)(short)param_2[2] >> 8) * cVar12;
    *(byte *)(param_2 + 2) = (byte)(short)param_2[2] & 0xfd;
    *(byte *)((int)param_2 + 0xb) = bVar21;
    if (bVar21 < 8) {
      uVar14 = uVar14 * bVar21 + 7 >> 3;
    }
    else {
      uVar14 = uVar14 * (bVar21 >> 3);
    }
    param_2[1] = uVar14;
    if (bVar39) {
      *(undefined1 *)(param_1 + 0x2fc) = 1;
      uVar14 = *(uint *)(param_1 + 0x138);
      if ((uVar14 & 0x600000) == 0x200000) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"png_do_rgb_to_gray found nongray pixel");
      }
    }
    else {
      uVar14 = *(uint *)(param_1 + 0x138);
    }
  }
  if (((uVar14 & 0x4000) != 0) && ((*(byte *)(param_1 + 0x131) & 8) == 0)) {
    FUN_00024f98(param_2,*(int *)(param_1 + 0x1e0) + 1);
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if ((uVar14 & 0x80) != 0) {
    bVar21 = (byte)(ushort)param_2[2];
    if (bVar21 < 7) {
      uVar14 = *param_2;
      iVar37 = *(int *)(param_1 + 0x244);
      iVar38 = *(int *)(param_1 + 0x248);
      iVar36 = *(int *)(param_1 + 0x24c);
      iVar24 = *(int *)(param_1 + 0x250);
      pbVar15 = *(byte **)(param_1 + 0x254);
      uVar22 = *(uint *)(param_1 + 0x134) & 0x2000;
      iVar18 = *(int *)(param_1 + 600);
      uVar32 = uVar22 >> 0xd;
      pbVar31 = *(byte **)(param_1 + 0x1e0);
      uVar35 = (ushort)param_2[2] >> 8;
      uVar28 = *(uint *)(param_1 + 0x23c);
      pbVar20 = pbVar31 + 1;
      switch(bVar21) {
      case 0:
        switch(uVar35) {
        case 1:
          if (uVar14 != 0) {
            uVar32 = 0;
            uVar22 = 7;
            uVar35 = *(ushort *)(param_1 + 0x274);
            do {
              if ((*pbVar20 >> (uVar22 & 0xff) & 1) == uVar35) {
                if (SBORROW4(7,uVar22)) {
LAB_00024ba8:
                    // WARNING: Does not return
                  pcVar1 = (code *)software_udf(0xfe,0x24ba8);
                  (*pcVar1)();
                }
                *pbVar20 = (byte)(0x7f7f >> (7 - uVar22 & 0xff)) & *pbVar20 |
                           (char)*(undefined2 *)(param_1 + 0x224) << (uVar22 & 0xff);
              }
              if (uVar22 == 0) {
                pbVar20 = pbVar20 + 1;
                uVar22 = 7;
              }
              else {
                if (SBORROW4(uVar22,1)) goto LAB_00024ba8;
                uVar22 = uVar22 - 1;
              }
              uVar32 = uVar32 + 1;
            } while (uVar32 < uVar14);
          }
          break;
        case 2:
          if (iVar37 == 0) {
            if (uVar14 != 0) {
              uVar32 = 0;
              uVar22 = 6;
              uVar35 = *(ushort *)(param_1 + 0x274);
              do {
                if ((*pbVar20 >> (uVar22 & 0xff) & 3) == uVar35) {
                  if (SBORROW4(6,uVar22)) goto LAB_00024ba8;
                  *pbVar20 = (byte)(0x3f3f >> (6 - uVar22 & 0xff)) & *pbVar20 |
                             (char)*(undefined2 *)(param_1 + 0x224) << (uVar22 & 0xff);
                }
                if (uVar22 == 0) {
                  pbVar20 = pbVar20 + 1;
                  uVar22 = 6;
                }
                else {
                  if (SBORROW4(uVar22,2)) goto LAB_00024ba8;
                  uVar22 = uVar22 - 2;
                }
                uVar32 = uVar32 + 1;
              } while (uVar32 < uVar14);
            }
          }
          else if (uVar14 != 0) {
            uVar32 = 0;
            uVar22 = 6;
            uVar35 = *(ushort *)(param_1 + 0x274);
            do {
              uVar28 = *pbVar20 >> (uVar22 & 0xff) & 3;
              if (uVar28 == uVar35) {
                if (SBORROW4(6,uVar22)) goto LAB_00024ba8;
                bVar21 = (char)*(undefined2 *)(param_1 + 0x224) << (uVar22 & 0xff);
              }
              else {
                if (SBORROW4(6,uVar22)) goto LAB_00024ba8;
                bVar21 = (*(byte *)(iVar37 + (uVar28 | uVar28 << 2 | uVar28 << 4 | uVar28 << 6)) >>
                         6) << (uVar22 & 0xff);
              }
              *pbVar20 = bVar21 | *pbVar20 & (byte)(0x3f3f >> (6 - uVar22 & 0xff));
              if (uVar22 == 0) {
                pbVar20 = pbVar20 + 1;
                uVar22 = 6;
              }
              else {
                if (SBORROW4(uVar22,2)) goto LAB_00024ba8;
                uVar22 = uVar22 - 2;
              }
              uVar32 = uVar32 + 1;
            } while (uVar32 < uVar14);
          }
          break;
        case 3:
        case 5:
        case 6:
        case 7:
          break;
        case 4:
          if (iVar37 == 0) {
            if (uVar14 != 0) {
              uVar32 = 0;
              uVar22 = 4;
              uVar35 = *(ushort *)(param_1 + 0x274);
              do {
                if ((*pbVar20 >> (uVar22 & 0xff) & 0xf) == uVar35) {
                  if (SBORROW4(4,uVar22)) goto LAB_00024ba8;
                  *pbVar20 = (byte)(0xf0f >> (4 - uVar22 & 0xff)) & *pbVar20 |
                             (char)*(undefined2 *)(param_1 + 0x224) << (uVar22 & 0xff);
                }
                if (uVar22 == 0) {
                  pbVar20 = pbVar20 + 1;
                  uVar22 = 4;
                }
                else {
                  if (SBORROW4(uVar22,4)) goto LAB_00024ba8;
                  uVar22 = uVar22 - 4;
                }
                uVar32 = uVar32 + 1;
              } while (uVar32 < uVar14);
            }
          }
          else if (uVar14 != 0) {
            uVar32 = 0;
            uVar22 = 4;
            uVar35 = *(ushort *)(param_1 + 0x274);
            do {
              uVar28 = *pbVar20 >> (uVar22 & 0xff) & 0xf;
              if (uVar28 == uVar35) {
                if (SBORROW4(4,uVar22)) goto LAB_00024ba8;
                bVar21 = (char)*(undefined2 *)(param_1 + 0x224) << (uVar22 & 0xff);
              }
              else {
                if (SBORROW4(4,uVar22)) goto LAB_00024ba8;
                bVar21 = (*(byte *)(iVar37 + (uVar28 | uVar28 << 4)) >> 4) << (uVar22 & 0xff);
              }
              *pbVar20 = bVar21 | *pbVar20 & (byte)(0xf0f >> (4 - uVar22 & 0xff));
              if (uVar22 == 0) {
                pbVar20 = pbVar20 + 1;
                uVar22 = 4;
              }
              else {
                if (SBORROW4(uVar22,4)) goto LAB_00024ba8;
                uVar22 = uVar22 - 4;
              }
              uVar32 = uVar32 + 1;
            } while (uVar32 < uVar14);
          }
          break;
        case 8:
          if (iVar37 == 0) {
            if (uVar14 != 0) {
              uVar35 = *(ushort *)(param_1 + 0x274);
              do {
                if (*pbVar20 == uVar35) {
                  *pbVar20 = *(byte *)(param_1 + 0x224);
                }
                uVar14 = uVar14 - 1;
                pbVar20 = pbVar20 + 1;
              } while (uVar14 != 0);
            }
          }
          else if (uVar14 != 0) {
            uVar35 = *(ushort *)(param_1 + 0x274);
            do {
              if ((uint)*pbVar20 == (uint)uVar35) {
                bVar21 = *(byte *)(param_1 + 0x224);
              }
              else {
                bVar21 = *(byte *)(iVar37 + (uint)*pbVar20);
              }
              uVar14 = uVar14 - 1;
              *pbVar20 = bVar21;
              pbVar20 = pbVar20 + 1;
            } while (uVar14 != 0);
          }
          break;
        default:
          if (uVar35 == 0x10) {
            if (iVar38 == 0) {
              if (uVar14 != 0) {
                sVar8 = *(short *)(param_1 + 0x274);
                do {
                  if (CONCAT11(*pbVar20,pbVar20[1]) == sVar8) {
                    uVar9 = *(undefined2 *)(param_1 + 0x224);
                    *pbVar20 = (byte)((ushort)uVar9 >> 8);
                    pbVar20[1] = (byte)uVar9;
                  }
                  uVar14 = uVar14 - 1;
                  pbVar20 = pbVar20 + 2;
                } while (uVar14 != 0);
              }
            }
            else if (uVar14 != 0) {
              sVar8 = *(short *)(param_1 + 0x274);
              do {
                puVar26 = (undefined2 *)(param_1 + 0x224);
                if (CONCAT11(*pbVar20,pbVar20[1]) != sVar8) {
                  puVar26 = (undefined2 *)
                            (*(int *)(iVar38 + (uint)(pbVar20[1] >> (uVar28 & 0xff)) * 4) +
                            (uint)*pbVar20 * 2);
                }
                uVar14 = uVar14 - 1;
                uVar9 = *puVar26;
                *pbVar20 = (byte)((ushort)uVar9 >> 8);
                pbVar20[1] = (byte)uVar9;
                pbVar20 = pbVar20 + 2;
              } while (uVar14 != 0);
            }
          }
        }
        break;
      case 2:
        if (uVar35 == 8) {
          if (iVar37 == 0) {
            if (uVar14 != 0) {
              uVar35 = *(ushort *)(param_1 + 0x26e);
              do {
                if (*pbVar20 == uVar35) {
                  uVar22 = (uint)pbVar20[1];
                  bVar39 = uVar22 == (*(uint *)(param_1 + 0x270) & 0xffff);
                  if (bVar39) {
                    uVar22 = (uint)pbVar20[2];
                  }
                  if (bVar39 && uVar22 == *(uint *)(param_1 + 0x270) >> 0x10) {
                    *pbVar20 = *(byte *)(param_1 + 0x21e);
                    uVar25 = *(undefined4 *)(param_1 + 0x220);
                    pbVar20[1] = (byte)uVar25;
                    pbVar20[2] = (byte)((uint)uVar25 >> 0x10);
                  }
                }
                uVar14 = uVar14 - 1;
                pbVar20 = pbVar20 + 3;
              } while (uVar14 != 0);
            }
          }
          else if (uVar14 != 0) {
            uVar35 = *(ushort *)(param_1 + 0x26e);
            do {
              uVar22 = (uint)pbVar20[1];
              if ((uint)*pbVar20 == (uint)uVar35) {
                uVar32 = *(uint *)(param_1 + 0x270) & 0xffff;
                bVar39 = uVar22 == uVar32;
                if (bVar39) {
                  uVar32 = (uint)pbVar20[2];
                }
                if (!bVar39 || uVar32 != *(uint *)(param_1 + 0x270) >> 0x10) goto LAB_00023498;
                *pbVar20 = *(byte *)(param_1 + 0x21e);
                uVar25 = *(undefined4 *)(param_1 + 0x220);
                pbVar20[1] = (byte)uVar25;
                bVar21 = (byte)((uint)uVar25 >> 0x10);
              }
              else {
LAB_00023498:
                *pbVar20 = *(byte *)(iVar37 + (uint)*pbVar20);
                pbVar20[1] = *(byte *)(iVar37 + uVar22);
                bVar21 = *(byte *)(iVar37 + (uint)pbVar20[2]);
              }
              pbVar20[2] = bVar21;
              uVar14 = uVar14 - 1;
              pbVar20 = pbVar20 + 3;
            } while (uVar14 != 0);
          }
        }
        else if (iVar38 == 0) {
          if (uVar14 != 0) {
            sVar8 = *(short *)(param_1 + 0x26e);
            do {
              pbVar20 = pbVar31 + 6;
              if (CONCAT11(pbVar31[1],pbVar31[2]) == sVar8) {
                bVar21 = pbVar31[4];
                uVar32 = *(uint *)(param_1 + 0x270);
                uVar22 = (uint)CONCAT11(pbVar31[3],bVar21);
                bVar39 = uVar22 == (uVar32 & 0xffff);
                if (bVar39) {
                  uVar22 = (uint)pbVar31[5];
                  bVar21 = *pbVar20;
                }
                if (bVar39) {
                  uVar32 = uVar32 >> 0x10;
                }
                if (bVar39) {
                  uVar22 = (uint)bVar21 | uVar22 << 8;
                }
                if (bVar39 && uVar22 == uVar32) {
                  uVar9 = *(undefined2 *)(param_1 + 0x21e);
                  pbVar31[1] = (byte)((ushort)uVar9 >> 8);
                  pbVar31[2] = (byte)uVar9;
                  uVar25 = *(undefined4 *)(param_1 + 0x220);
                  pbVar31[3] = (byte)((uint)uVar25 >> 8);
                  pbVar31[4] = (byte)uVar25;
                  pbVar31[5] = (byte)((uint)uVar25 >> 0x18);
                  *pbVar20 = (byte)((uint)uVar25 >> 0x10);
                }
              }
              uVar14 = uVar14 - 1;
              pbVar31 = pbVar20;
            } while (uVar14 != 0);
          }
        }
        else if (uVar14 != 0) {
          sVar8 = *(short *)(param_1 + 0x26e);
          do {
            pbVar20 = pbVar31 + 6;
            if (CONCAT11(pbVar31[1],pbVar31[2]) == sVar8) {
              uVar22 = (uint)pbVar31[4];
              if (((uint)CONCAT11(pbVar31[3],pbVar31[4]) != (*(uint *)(param_1 + 0x270) & 0xffff))
                 || ((uint)CONCAT11(pbVar31[5],*pbVar20) != *(uint *)(param_1 + 0x270) >> 0x10))
              goto LAB_000236c4;
              uVar9 = *(undefined2 *)(param_1 + 0x21e);
              pbVar31[1] = (byte)((ushort)uVar9 >> 8);
              pbVar31[2] = (byte)uVar9;
              uVar25 = *(undefined4 *)(param_1 + 0x220);
              pbVar31[3] = (byte)((uint)uVar25 >> 8);
              pbVar31[4] = (byte)uVar25;
              bVar21 = (byte)((uint)uVar25 >> 0x10);
              pbVar31[5] = (byte)((uint)uVar25 >> 0x18);
            }
            else {
              uVar22 = (uint)pbVar31[4];
LAB_000236c4:
              uVar9 = *(undefined2 *)
                       (*(int *)(iVar38 + (uint)(pbVar31[2] >> (uVar28 & 0xff)) * 4) +
                       (uint)pbVar31[1] * 2);
              pbVar31[1] = (byte)((ushort)uVar9 >> 8);
              pbVar31[2] = (byte)uVar9;
              uVar9 = *(undefined2 *)
                       (*(int *)(iVar38 + (uVar22 >> (uVar28 & 0xff)) * 4) + (uint)pbVar31[3] * 2);
              pbVar31[3] = (byte)((ushort)uVar9 >> 8);
              pbVar31[4] = (byte)uVar9;
              uVar9 = *(undefined2 *)
                       (*(int *)(iVar38 + (uint)(*pbVar20 >> (uVar28 & 0xff)) * 4) +
                       (uint)pbVar31[5] * 2);
              bVar21 = (byte)uVar9;
              pbVar31[5] = (byte)((ushort)uVar9 >> 8);
            }
            *pbVar20 = bVar21;
            uVar14 = uVar14 - 1;
            pbVar31 = pbVar20;
          } while (uVar14 != 0);
        }
        break;
      case 4:
        if (uVar35 == 8) {
          if ((iVar37 == 0 || iVar36 == 0) || (iVar24 == 0)) {
            for (; uVar14 != 0; uVar14 = uVar14 - 1) {
              uVar22 = (uint)pbVar20[1];
              if (uVar22 != 0xff) {
                if (uVar22 == 0) {
                  bVar21 = *(byte *)(param_1 + 0x224);
                }
                else {
                  uVar22 = *pbVar20 * uVar22 + (uVar22 ^ 0xff) * (uint)*(ushort *)(param_1 + 0x224)
                           + 0x80;
                  bVar21 = (byte)(uVar22 + (uVar22 >> 8 & 0xff) >> 8);
                }
                *pbVar20 = bVar21;
              }
              pbVar20 = pbVar20 + 2;
            }
          }
          else {
            for (; uVar14 != 0; uVar14 = uVar14 - 1) {
              uVar22 = (uint)pbVar20[1];
              if (uVar22 == 0) {
                bVar21 = *(byte *)(param_1 + 0x224);
              }
              else if (uVar22 == 0xff) {
                bVar21 = *(byte *)(iVar37 + (uint)*pbVar20);
              }
              else {
                uVar22 = *(byte *)(iVar24 + (uint)*pbVar20) * uVar22 +
                         (uVar22 ^ 0xff) * (uint)*(ushort *)(param_1 + 0x22e) + 0x80;
                uVar22 = uVar22 + (uVar22 >> 8 & 0xff);
                bVar21 = (byte)(uVar22 >> 8);
                if (uVar32 == 0) {
                  bVar21 = *(byte *)(iVar36 + (uVar22 >> 8 & 0xff));
                }
              }
              *pbVar20 = bVar21;
              pbVar20 = pbVar20 + 2;
            }
          }
        }
        else {
          if (iVar38 != 0) {
            pbVar20 = pbVar15;
          }
          if ((iVar38 == 0 || pbVar20 == (byte *)0x0) || (iVar18 == 0)) {
            if (uVar14 != 0) {
              pbVar31 = pbVar31 + 2;
              do {
                uVar22 = (uint)CONCAT11(pbVar31[1],pbVar31[2]);
                if (uVar22 != 0xffff) {
                  if (uVar22 == 0) {
                    bVar21 = (byte)*(undefined2 *)(param_1 + 0x224);
                    pbVar31[-1] = (byte)((ushort)*(undefined2 *)(param_1 + 0x224) >> 8);
                  }
                  else {
                    uVar22 = (uint)*(ushort *)(param_1 + 0x224) * (uVar22 ^ 0xffff) +
                             uVar22 * CONCAT11(pbVar31[-1],*pbVar31) + 0x8000;
                    iVar18 = uVar22 + (uVar22 >> 0x10);
                    bVar21 = (byte)((uint)iVar18 >> 0x10);
                    pbVar31[-1] = (byte)((uint)iVar18 >> 0x18);
                  }
                  *pbVar31 = bVar21;
                }
                uVar14 = uVar14 - 1;
                pbVar31 = pbVar31 + 4;
              } while (uVar14 != 0);
            }
          }
          else if (uVar14 != 0) {
            pbVar31 = pbVar31 + 2;
            do {
              uVar32 = (uint)CONCAT11(pbVar31[1],pbVar31[2]);
              if (uVar32 == 0) {
                uVar32 = (uint)*(ushort *)(param_1 + 0x224);
LAB_000237a2:
                bVar21 = (byte)(uVar32 >> 8);
              }
              else {
                if (uVar32 == 0xffff) {
                  uVar32 = (uint)*(ushort *)
                                  (*(int *)(iVar38 + (uint)(*pbVar31 >> (uVar28 & 0xff)) * 4) +
                                  (uint)pbVar31[-1] * 2);
                  goto LAB_000237a2;
                }
                uVar33 = *(ushort *)
                          (*(int *)(iVar18 + (uint)(*pbVar31 >> (uVar28 & 0xff)) * 4) +
                          (uint)pbVar31[-1] * 2) * uVar32 +
                         (uint)*(ushort *)(param_1 + 0x22e) * (uVar32 ^ 0xffff) + 0x8000;
                uVar33 = uVar33 + (uVar33 >> 0x10);
                uVar32 = uVar33 >> 0x10;
                if (uVar22 == 0) {
                  uVar32 = (uint)*(ushort *)
                                  (*(int *)(pbVar15 +
                                           ((uVar33 >> 0x10 & 0xff) >> (uVar28 & 0xff)) * 4) +
                                  (uVar33 >> 0x18) * 2);
                  goto LAB_000237a2;
                }
                bVar21 = (byte)(uVar33 >> 0x18);
              }
              pbVar31[-1] = bVar21;
              uVar14 = uVar14 - 1;
              *pbVar31 = (byte)uVar32;
              pbVar31 = pbVar31 + 4;
            } while (uVar14 != 0);
          }
        }
        break;
      case 6:
        if (uVar35 == 8) {
          if ((iVar37 == 0 || iVar36 == 0) || (iVar24 == 0)) {
            if (uVar14 != 0) {
              pbVar31 = pbVar31 + 2;
              do {
                uVar22 = (uint)pbVar31[2];
                if (uVar22 != 0xff) {
                  if (uVar22 == 0) {
                    pbVar31[-1] = *(byte *)(param_1 + 0x21e);
                    uVar25 = *(undefined4 *)(param_1 + 0x220);
                    *pbVar31 = (byte)uVar25;
                    bVar21 = (byte)((uint)uVar25 >> 0x10);
                  }
                  else {
                    uVar28 = uVar22 ^ 0xff;
                    uVar32 = pbVar31[-1] * uVar22 + uVar28 * *(ushort *)(param_1 + 0x21e) + 0x80;
                    pbVar31[-1] = (byte)(uVar32 + (uVar32 >> 8 & 0xff) >> 8);
                    uVar32 = *(uint *)(param_1 + 0x220);
                    uVar33 = *pbVar31 * uVar22 + uVar28 * (uVar32 & 0xffff) + 0x80;
                    *pbVar31 = (byte)(uVar33 + (uVar33 >> 8 & 0xff) >> 8);
                    uVar22 = pbVar31[1] * uVar22 + uVar28 * (uVar32 >> 0x10) + 0x80;
                    bVar21 = (byte)(uVar22 + (uVar22 >> 8 & 0xff) >> 8);
                  }
                  pbVar31[1] = bVar21;
                }
                uVar14 = uVar14 - 1;
                pbVar31 = pbVar31 + 4;
              } while (uVar14 != 0);
            }
          }
          else if (uVar14 != 0) {
            pbVar31 = pbVar31 + 2;
            do {
              uVar22 = (uint)pbVar31[2];
              if (uVar22 == 0) {
                pbVar31[-1] = *(byte *)(param_1 + 0x21e);
                uVar25 = *(undefined4 *)(param_1 + 0x220);
                *pbVar31 = (byte)uVar25;
                bVar21 = (byte)((uint)uVar25 >> 0x10);
              }
              else if (uVar22 == 0xff) {
                pbVar31[-1] = *(byte *)(iVar37 + (uint)pbVar31[-1]);
                *pbVar31 = *(byte *)(iVar37 + (uint)*pbVar31);
                bVar21 = *(byte *)(iVar37 + (uint)pbVar31[1]);
              }
              else {
                uVar33 = uVar22 ^ 0xff;
                uVar28 = *(byte *)(iVar24 + (uint)pbVar31[-1]) * uVar22 +
                         uVar33 * *(ushort *)(param_1 + 0x228) + 0x80;
                uVar28 = uVar28 + (uVar28 >> 8 & 0xff);
                bVar21 = (byte)(uVar28 >> 8);
                if (uVar32 == 0) {
                  bVar21 = *(byte *)(iVar36 + (uVar28 >> 8 & 0xff));
                }
                pbVar31[-1] = bVar21;
                uVar28 = *(byte *)(iVar24 + (uint)*pbVar31) * uVar22 +
                         uVar33 * *(ushort *)(param_1 + 0x22a) + 0x80;
                uVar28 = uVar28 + (uVar28 >> 8 & 0xff);
                bVar21 = (byte)(uVar28 >> 8);
                if (uVar32 == 0) {
                  bVar21 = *(byte *)(iVar36 + (uVar28 >> 8 & 0xff));
                }
                *pbVar31 = bVar21;
                uVar22 = *(byte *)(iVar24 + (uint)pbVar31[1]) * uVar22 +
                         *(ushort *)(param_1 + 0x22c) * uVar33 + 0x80;
                uVar22 = uVar22 + (uVar22 >> 8 & 0xff);
                bVar21 = (byte)(uVar22 >> 8);
                if (uVar32 == 0) {
                  bVar21 = *(byte *)(iVar36 + (uVar22 >> 8 & 0xff));
                }
              }
              pbVar31[1] = bVar21;
              uVar14 = uVar14 - 1;
              pbVar31 = pbVar31 + 4;
            } while (uVar14 != 0);
          }
        }
        else {
          if (iVar38 != 0) {
            pbVar20 = pbVar15;
          }
          if ((iVar38 == 0 || pbVar20 == (byte *)0x0) || (iVar18 == 0)) {
            if (uVar14 != 0) {
              uVar22 = 0;
              do {
                uVar32 = (uint)CONCAT11(pbVar31[uVar22 * 8 + 7],pbVar31[uVar22 * 8 + 8]);
                if (uVar32 != 0xffff) {
                  if (uVar32 == 0) {
                    uVar9 = *(undefined2 *)(param_1 + 0x21e);
                    pbVar31[uVar22 * 8 + 1] = (byte)((ushort)uVar9 >> 8);
                    pbVar31[uVar22 * 8 + 2] = (byte)uVar9;
                    uVar25 = *(undefined4 *)(param_1 + 0x220);
                    pbVar31[uVar22 * 8 + 3] = (byte)((uint)uVar25 >> 8);
                    pbVar31[uVar22 * 8 + 4] = (byte)uVar25;
                    pbVar31[uVar22 * 8 + 5] = (byte)((uint)uVar25 >> 0x18);
                    pbVar31[uVar22 * 8 + 6] = (byte)((uint)uVar25 >> 0x10);
                  }
                  else {
                    uVar33 = uVar32 ^ 0xffff;
                    uVar28 = CONCAT11(pbVar31[uVar22 * 8 + 1],pbVar31[uVar22 * 8 + 2]) * uVar32 +
                             uVar33 * *(ushort *)(param_1 + 0x21e) + 0x8000;
                    iVar18 = uVar28 + (uVar28 >> 0x10);
                    pbVar31[uVar22 * 8 + 1] = (byte)((uint)iVar18 >> 0x18);
                    pbVar31[uVar22 * 8 + 2] = (byte)((uint)iVar18 >> 0x10);
                    uVar28 = CONCAT11(pbVar31[uVar22 * 8 + 3],pbVar31[uVar22 * 8 + 4]) * uVar32 +
                             uVar33 * (*(uint *)(param_1 + 0x220) & 0xffff) + 0x8000;
                    uVar32 = CONCAT11(pbVar31[uVar22 * 8 + 5],pbVar31[uVar22 * 8 + 6]) * uVar32 +
                             uVar33 * (*(uint *)(param_1 + 0x220) >> 0x10) + 0x8000;
                    iVar37 = uVar28 + (uVar28 >> 0x10);
                    iVar18 = uVar32 + (uVar32 >> 0x10);
                    pbVar31[uVar22 * 8 + 3] = (byte)((uint)iVar37 >> 0x18);
                    pbVar31[uVar22 * 8 + 4] = (byte)((uint)iVar37 >> 0x10);
                    pbVar31[uVar22 * 8 + 5] = (byte)((uint)iVar18 >> 0x18);
                    pbVar31[uVar22 * 8 + 6] = (byte)((uint)iVar18 >> 0x10);
                  }
                }
                uVar22 = uVar22 + 1;
              } while (uVar14 != uVar22);
            }
          }
          else if (uVar14 != 0) {
            uVar22 = 0;
            do {
              uVar33 = (uint)CONCAT11(pbVar31[uVar22 * 8 + 7],pbVar31[uVar22 * 8 + 8]);
              if (uVar33 == 0) {
                uVar9 = *(undefined2 *)(param_1 + 0x21e);
                pbVar31[uVar22 * 8 + 1] = (byte)((ushort)uVar9 >> 8);
                pbVar31[uVar22 * 8 + 2] = (byte)uVar9;
                uVar25 = *(undefined4 *)(param_1 + 0x220);
                pbVar31[uVar22 * 8 + 3] = (byte)((uint)uVar25 >> 8);
                pbVar31[uVar22 * 8 + 4] = (byte)uVar25;
                pbVar31[uVar22 * 8 + 5] = (byte)((uint)uVar25 >> 0x18);
                pbVar31[uVar22 * 8 + 6] = (byte)((uint)uVar25 >> 0x10);
              }
              else if (uVar33 == 0xffff) {
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar38 + (uint)(pbVar31[uVar22 * 8 + 2] >> (uVar28 & 0xff)) * 4)
                         + (uint)pbVar31[uVar22 * 8 + 1] * 2);
                pbVar31[uVar22 * 8 + 1] = (byte)((ushort)uVar9 >> 8);
                pbVar31[uVar22 * 8 + 2] = (byte)uVar9;
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar38 + (uint)(pbVar31[uVar22 * 8 + 4] >> (uVar28 & 0xff)) * 4)
                         + (uint)pbVar31[uVar22 * 8 + 3] * 2);
                pbVar31[uVar22 * 8 + 3] = (byte)((ushort)uVar9 >> 8);
                pbVar31[uVar22 * 8 + 4] = (byte)uVar9;
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar38 + (uint)(pbVar31[uVar22 * 8 + 6] >> (uVar28 & 0xff)) * 4)
                         + (uint)pbVar31[uVar22 * 8 + 5] * 2);
                pbVar31[uVar22 * 8 + 5] = (byte)((ushort)uVar9 >> 8);
                pbVar31[uVar22 * 8 + 6] = (byte)uVar9;
              }
              else {
                uVar29 = uVar33 ^ 0xffff;
                uVar30 = *(ushort *)
                          (*(int *)(iVar18 + (uint)(pbVar31[uVar22 * 8 + 2] >> (uVar28 & 0xff)) * 4)
                          + (uint)pbVar31[uVar22 * 8 + 1] * 2) * uVar33 +
                         uVar29 * *(ushort *)(param_1 + 0x228) + 0x8000;
                uVar30 = uVar30 + (uVar30 >> 0x10);
                uVar19 = uVar30 >> 0x18;
                bVar21 = (byte)(uVar30 >> 0x10);
                if (uVar32 == 0) {
                  uVar35 = *(ushort *)
                            (*(int *)(pbVar15 + ((uVar30 >> 0x10 & 0xff) >> (uVar28 & 0xff)) * 4) +
                            uVar19 * 2);
                  bVar21 = (byte)uVar35;
                  uVar19 = (uint)(uVar35 >> 8);
                }
                pbVar31[uVar22 * 8 + 1] = (byte)uVar19;
                pbVar31[uVar22 * 8 + 2] = bVar21;
                uVar30 = *(ushort *)
                          (*(int *)(iVar18 + (uint)(pbVar31[uVar22 * 8 + 4] >> (uVar28 & 0xff)) * 4)
                          + (uint)pbVar31[uVar22 * 8 + 3] * 2) * uVar33 +
                         *(ushort *)(param_1 + 0x22a) * uVar29 + 0x8000;
                uVar30 = uVar30 + (uVar30 >> 0x10);
                uVar19 = uVar30 >> 0x18;
                bVar21 = (byte)(uVar30 >> 0x10);
                if (uVar32 == 0) {
                  uVar35 = *(ushort *)
                            (*(int *)(pbVar15 + ((uVar30 >> 0x10 & 0xff) >> (uVar28 & 0xff)) * 4) +
                            uVar19 * 2);
                  bVar21 = (byte)uVar35;
                  uVar19 = (uint)(uVar35 >> 8);
                }
                pbVar31[uVar22 * 8 + 3] = (byte)uVar19;
                pbVar31[uVar22 * 8 + 4] = bVar21;
                uVar33 = *(ushort *)
                          (*(int *)(iVar18 + (uint)(pbVar31[uVar22 * 8 + 6] >> (uVar28 & 0xff)) * 4)
                          + (uint)pbVar31[uVar22 * 8 + 5] * 2) * uVar33 +
                         *(ushort *)(param_1 + 0x22c) * uVar29 + 0x8000;
                uVar33 = uVar33 + (uVar33 >> 0x10);
                uVar30 = uVar33 >> 0x18;
                bVar21 = (byte)(uVar33 >> 0x10);
                if (uVar32 == 0) {
                  uVar35 = *(ushort *)
                            (*(int *)(pbVar15 + ((uVar33 >> 0x10 & 0xff) >> (uVar28 & 0xff)) * 4) +
                            uVar30 * 2);
                  bVar21 = (byte)uVar35;
                  uVar30 = (uint)(uVar35 >> 8);
                }
                pbVar31[uVar22 * 8 + 5] = (byte)uVar30;
                pbVar31[uVar22 * 8 + 6] = bVar21;
              }
              uVar22 = uVar22 + 1;
            } while (uVar14 != uVar22);
          }
        }
      }
    }
  }
  if ((*(uint *)(param_1 + 0x138) & 0x602000) == 0x2000) {
    if ((*(uint *)(param_1 + 0x138) & 0x80) == 0) {
      bVar21 = *(byte *)(param_1 + 0x20b);
    }
    else if ((*(short *)(param_1 + 0x204) != 0) ||
            (bVar21 = *(byte *)(param_1 + 0x20b), (bVar21 & 4) != 0)) goto switchD_00023f24_caseD_1;
    if (bVar21 != 3) {
      uVar22 = *(uint *)(param_1 + 0x23c);
      iVar37 = *(int *)(param_1 + 0x244);
      iVar18 = *(int *)(param_1 + 0x248);
      uVar14 = *param_2;
      if (((iVar37 != 0) && (*(byte *)((int)param_2 + 9) < 9)) ||
         ((iVar18 != 0 && (*(byte *)((int)param_2 + 9) == 0x10)))) {
        bVar21 = (byte)(ushort)param_2[2];
        if (bVar21 < 7) {
          pbVar31 = (byte *)(*(int *)(param_1 + 0x1e0) + 1);
          uVar35 = (ushort)param_2[2] >> 8;
          switch(bVar21) {
          case 0:
            if (uVar35 == 2) {
              if (uVar14 == 0) break;
              uVar32 = 0;
              pbVar20 = pbVar31;
              do {
                uVar19 = (uint)*pbVar20;
                uVar32 = uVar32 + 4;
                uVar28 = uVar19 & 0x30;
                uVar33 = uVar19 & 0xc;
                uVar30 = uVar19 & 0xc0;
                uVar19 = uVar19 & 3;
                *pbVar20 = *(byte *)(iVar37 + (uVar33 | uVar33 << 2 | uVar33 << 4 | uVar33 >> 2)) >>
                           4 & 0xc | *(byte *)(iVar37 + (uVar30 | *pbVar20 >> 6 | uVar30 >> 2 |
                                                        uVar30 >> 4)) & 0xc0 |
                                     *(byte *)(iVar37 + (uVar28 | uVar28 << 2 | uVar28 >> 2 |
                                                        uVar28 >> 4)) >> 2 & 0x30 |
                           *(byte *)(iVar37 + (uVar19 | uVar19 << 4 | uVar19 << 6 | uVar19 << 2)) >>
                           6;
                pbVar20 = pbVar20 + 1;
              } while (uVar32 < uVar14);
              uVar35 = (ushort)*(byte *)((int)param_2 + 9);
            }
            if (uVar35 == 4) {
              if (uVar14 != 0) {
                uVar22 = 0;
                do {
                  bVar21 = *pbVar31;
                  uVar22 = uVar22 + 2;
                  uVar32 = bVar21 & 0xf;
                  *pbVar31 = *(byte *)(iVar37 + (bVar21 & 0xf0 | (uint)(bVar21 >> 4))) & 0xf0 |
                             *(byte *)(iVar37 + (uVar32 | uVar32 << 4)) >> 4;
                  pbVar31 = pbVar31 + 1;
                } while (uVar22 < uVar14);
              }
            }
            else if (uVar35 == 8) {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                *pbVar31 = *(byte *)(iVar37 + (uint)*pbVar31);
                pbVar31 = pbVar31 + 1;
              }
            }
            else if (uVar35 == 0x10) {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[1] >> (uVar22 & 0xff)) * 4) +
                         (uint)*pbVar31 * 2);
                *pbVar31 = (byte)((ushort)uVar9 >> 8);
                pbVar31[1] = (byte)uVar9;
                pbVar31 = pbVar31 + 2;
              }
            }
            break;
          case 2:
            if (uVar35 == 8) {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                *pbVar31 = *(byte *)(iVar37 + (uint)*pbVar31);
                pbVar31[1] = *(byte *)(iVar37 + (uint)pbVar31[1]);
                pbVar31[2] = *(byte *)(iVar37 + (uint)pbVar31[2]);
                pbVar31 = pbVar31 + 3;
              }
            }
            else {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[1] >> (uVar22 & 0xff)) * 4) +
                         (uint)*pbVar31 * 2);
                *pbVar31 = (byte)((ushort)uVar9 >> 8);
                pbVar31[1] = (byte)uVar9;
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[3] >> (uVar22 & 0xff)) * 4) +
                         (uint)pbVar31[2] * 2);
                pbVar31[2] = (byte)((ushort)uVar9 >> 8);
                pbVar31[3] = (byte)uVar9;
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[5] >> (uVar22 & 0xff)) * 4) +
                         (uint)pbVar31[4] * 2);
                pbVar31[4] = (byte)((ushort)uVar9 >> 8);
                pbVar31[5] = (byte)uVar9;
                pbVar31 = pbVar31 + 6;
              }
            }
            break;
          case 4:
            if (uVar35 == 8) {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                *pbVar31 = *(byte *)(iVar37 + (uint)*pbVar31);
                pbVar31 = pbVar31 + 2;
              }
            }
            else {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[1] >> (uVar22 & 0xff)) * 4) +
                         (uint)*pbVar31 * 2);
                *pbVar31 = (byte)((ushort)uVar9 >> 8);
                pbVar31[1] = (byte)uVar9;
                pbVar31 = pbVar31 + 4;
              }
            }
            break;
          case 6:
            if (uVar35 == 8) {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                *pbVar31 = *(byte *)(iVar37 + (uint)*pbVar31);
                pbVar31[1] = *(byte *)(iVar37 + (uint)pbVar31[1]);
                pbVar31[2] = *(byte *)(iVar37 + (uint)pbVar31[2]);
                pbVar31 = pbVar31 + 4;
              }
            }
            else {
              for (; uVar14 != 0; uVar14 = uVar14 - 1) {
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[1] >> (uVar22 & 0xff)) * 4) +
                         (uint)*pbVar31 * 2);
                *pbVar31 = (byte)((ushort)uVar9 >> 8);
                pbVar31[1] = (byte)uVar9;
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[3] >> (uVar22 & 0xff)) * 4) +
                         (uint)pbVar31[2] * 2);
                pbVar31[2] = (byte)((ushort)uVar9 >> 8);
                pbVar31[3] = (byte)uVar9;
                uVar9 = *(undefined2 *)
                         (*(int *)(iVar18 + (uint)(pbVar31[5] >> (uVar22 & 0xff)) * 4) +
                         (uint)pbVar31[4] * 2);
                pbVar31[4] = (byte)((ushort)uVar9 >> 8);
                pbVar31[5] = (byte)uVar9;
                pbVar31 = pbVar31 + 8;
              }
            }
          }
        }
      }
    }
  }
switchD_00023f24_caseD_1:
  uVar14 = *(uint *)(param_1 + 0x138);
  pbVar31 = (byte *)(uVar14 & 0x40080);
  if ((pbVar31 == (byte *)0x40080) &&
     (pbVar31 = (byte *)((byte)param_2[2] | 2), pbVar31 == (byte *)0x6)) {
    png_do_strip_channel(param_2,*(int *)(param_1 + 0x1e0) + 1,0);
    uVar14 = *(uint *)(param_1 + 0x138);
    pbVar31 = extraout_r1;
  }
  if ((uVar14 & 0x800000) != 0) {
    bVar39 = (param_2[2] & 4) != 0;
    if (bVar39) {
      pbVar31 = (byte *)(uint)(ushort)param_2[2];
    }
    if (bVar39 && ((uint)pbVar31 & 4) != 0) {
      uVar14 = *param_2;
      iVar18 = *(int *)(param_1 + 0x1e0) + 1;
      if ((uint)pbVar31 >> 8 == 0x10) {
        iVar37 = *(int *)(param_1 + 0x254);
        if (iVar37 != 0 && uVar14 != 0) {
          uVar32 = *(uint *)(param_1 + 0x23c);
          uVar22 = ((uint)pbVar31 & 2) * 2;
          pbVar31 = (byte *)(uVar22 + 4);
          pbVar20 = (byte *)(iVar18 + (uVar22 | 2));
          do {
            uVar14 = uVar14 - 1;
            uVar9 = *(undefined2 *)
                     (*(int *)(iVar37 + (uint)(pbVar20[1] >> (uVar32 & 0xff)) * 4) +
                     (uint)*pbVar20 * 2);
            *pbVar20 = (byte)((ushort)uVar9 >> 8);
            pbVar20[1] = (byte)uVar9;
            pbVar20 = pbVar20 + (int)pbVar31;
          } while (uVar14 != 0);
        }
      }
      else if ((((uint)pbVar31 >> 8 == 8) && (iVar37 = *(int *)(param_1 + 0x24c), iVar37 != 0)) &&
              (uVar14 != 0)) {
        uVar22 = (uint)pbVar31 & 2;
        pbVar31 = (byte *)(uVar22 + 2);
        pbVar20 = (byte *)(iVar18 + (uVar22 | 1));
        do {
          uVar14 = uVar14 - 1;
          *pbVar20 = *(byte *)(iVar37 + (uint)*pbVar20);
          pbVar20 = pbVar20 + (int)pbVar31;
        } while (uVar14 != 0);
      }
    }
  }
  uVar14 = *(uint *)(param_1 + 0x138);
  if (((uVar14 & 0x4000000) != 0) &&
     (pbVar31 = (byte *)(uint)*(byte *)((int)param_2 + 9), pbVar31 == (byte *)0x10)) {
    uVar22 = param_2[1];
    if (0 < (int)uVar22) {
      iVar37 = 0;
      iVar18 = *(int *)(param_1 + 0x1e0) + 1;
      do {
        iVar24 = iVar18 + iVar37 * 2;
        bVar21 = *(byte *)(iVar18 + iVar37 * 2);
        *(byte *)(iVar18 + iVar37) =
             bVar21 + (char)(((uint)*(byte *)(iVar24 + 1) - (uint)bVar21) * 0xffff + 0x7fff80 >>
                            0x18);
        iVar37 = iVar37 + 1;
      } while (iVar24 + 2U < uVar22 + iVar18);
      uVar14 = *(uint *)(param_1 + 0x138);
    }
    *(undefined1 *)((int)param_2 + 9) = 8;
    *(byte *)((int)param_2 + 0xb) = *(byte *)((int)param_2 + 10) << 3;
    pbVar31 = (byte *)(*param_2 * (uint)*(byte *)((int)param_2 + 10));
    param_2[1] = (uint)pbVar31;
  }
  if (((uVar14 & 0x400) != 0) &&
     (pbVar31 = (byte *)(uint)*(byte *)((int)param_2 + 9), pbVar31 == (byte *)0x10)) {
    uVar22 = param_2[1];
    if (0 < (int)uVar22) {
      puVar16 = (undefined1 *)(*(int *)(param_1 + 0x1e0) + 1);
      puVar23 = puVar16;
      puVar27 = puVar16;
      do {
        puVar17 = puVar23 + 2;
        *puVar27 = *puVar23;
        puVar23 = puVar17;
        puVar27 = puVar27 + 1;
      } while (puVar17 < puVar16 + uVar22);
      uVar14 = *(uint *)(param_1 + 0x138);
    }
    *(undefined1 *)((int)param_2 + 9) = 8;
    *(byte *)((int)param_2 + 0xb) = *(byte *)((int)param_2 + 10) << 3;
    pbVar31 = (byte *)(*param_2 * (uint)*(byte *)((int)param_2 + 10));
    param_2[1] = (uint)pbVar31;
  }
  if ((uVar14 & 0x40) != 0) {
    if (*(char *)((int)param_2 + 9) == '\b') {
      pbVar31 = *(byte **)(param_1 + 0x1e0);
      iVar18 = *(int *)(param_1 + 700);
      iVar37 = *(int *)(param_1 + 0x2c0);
      uVar35 = (ushort)param_2[2];
      uVar14 = *param_2;
      uVar22 = (uint)(uVar35 >> 8);
      if ((iVar18 == 0) || ((uVar35 & 0xff) != 2)) {
        if ((iVar18 == 0) || ((uVar35 & 0xff) != 6)) {
          if (((uVar14 != 0) && (iVar37 != 0)) && ((uVar35 & 0xff) == 3)) {
            pbVar20 = pbVar31 + 1;
            do {
              uVar14 = uVar14 - 1;
              pbVar31 = pbVar20 + 1;
              *pbVar20 = *(byte *)(iVar37 + (uint)*pbVar20);
              pbVar20 = pbVar31;
            } while (uVar14 != 0);
          }
          goto LAB_00024250;
        }
        if (uVar14 != 0) {
          uVar22 = 0;
          do {
            uVar32 = uVar22 + 1;
            pbVar31[uVar22 + 1] =
                 *(byte *)(iVar18 + ((pbVar31[uVar22 * 4 + 2] & 0xf8) << 2 |
                                     (uint)(pbVar31[uVar22 * 4 + 3] >> 3) |
                                    (pbVar31[uVar22 * 4 + 1] & 0xf8) << 7));
            uVar22 = uVar32;
          } while (uVar14 != uVar32);
          goto LAB_00024226;
        }
      }
      else if (uVar14 != 0) {
        uVar22 = 0;
        do {
          uVar32 = uVar22 + 1;
          pbVar31[uVar22 + 1] =
               *(byte *)(iVar18 + ((pbVar31[uVar22 * 3 + 2] & 0xf8) << 2 |
                                   (uint)(pbVar31[uVar22 * 3 + 3] >> 3) |
                                  (pbVar31[uVar22 * 3 + 1] & 0xf8) << 7));
          uVar22 = uVar32;
        } while (uVar14 != uVar32);
LAB_00024226:
        uVar22 = (uint)*(byte *)((int)param_2 + 9);
      }
      *(undefined1 *)(param_2 + 2) = 3;
      pbVar31 = (byte *)0x0;
      *(undefined1 *)((int)param_2 + 10) = 1;
      *(char *)((int)param_2 + 0xb) = (char)uVar22;
      if (uVar22 < 8) {
        uVar14 = uVar22 * uVar14 + 7 >> 3;
      }
      else {
        pbVar31 = (byte *)(uVar22 >> 3);
        uVar14 = (int)pbVar31 * uVar14;
      }
      param_2[1] = uVar14;
    }
LAB_00024250:
    if (param_2[1] == 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"png_do_quantize returned rowbytes=0");
    }
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if (((uVar14 & 0x200) != 0) &&
     (pbVar31 = (byte *)(uint)*(byte *)((int)param_2 + 9), pbVar31 == (byte *)0x8)) {
    pbVar31 = (byte *)(param_2[2] & 0xff);
    if (pbVar31 != (byte *)0x3) {
      uVar22 = param_2[1];
      if ((int)uVar22 < 1) {
        uVar32 = param_2[2] >> 0x10;
      }
      else {
        puVar23 = (undefined1 *)(*(int *)(param_1 + 0x1e0) + 1 + uVar22 * 2);
        puVar27 = (undefined1 *)(*(int *)(param_1 + 0x1e0) + uVar22);
        do {
          uVar13 = *puVar27;
          puVar23[-1] = uVar13;
          puVar23 = puVar23 + -2;
          *puVar23 = uVar13;
          bVar39 = puVar27 < puVar23;
          puVar27 = puVar27 + -1;
        } while (bVar39);
        uVar14 = *(uint *)(param_1 + 0x138);
        uVar32 = (uint)*(byte *)((int)param_2 + 10);
        uVar22 = param_2[1];
      }
      param_2[1] = uVar22 << 1;
      *(undefined1 *)((int)param_2 + 9) = 0x10;
      pbVar31 = (byte *)(uVar32 << 4);
      *(char *)((int)param_2 + 0xb) = (char)pbVar31;
    }
  }
  bVar39 = (uVar14 & 0x4000) != 0;
  if (bVar39) {
    pbVar31 = (byte *)(uint)*(byte *)(param_1 + 0x131);
  }
  if (bVar39 && ((uint)pbVar31 & 8) != 0) {
    FUN_00024f98(param_2,*(int *)(param_1 + 0x1e0) + 1);
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if ((uVar14 & 0x20) != 0) {
    png_do_invert(param_2,*(int *)(param_1 + 0x1e0) + 1);
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if ((uVar14 & 0x80000) != 0) {
    uVar14 = *param_2;
    iVar18 = *(int *)(param_1 + 0x1e0);
    cVar12 = (char)(ushort)param_2[2];
    uVar35 = (ushort)param_2[2] >> 8;
    if (cVar12 == '\x04') {
      if (uVar35 == 8) {
        if (uVar14 != 0) {
          pbVar31 = (byte *)(iVar18 + param_2[1]);
          do {
            uVar14 = uVar14 - 1;
            *pbVar31 = ~*pbVar31;
            pbVar31 = pbVar31 + -2;
          } while (uVar14 != 0);
        }
      }
      else if (uVar14 != 0) {
        pbVar31 = (byte *)(iVar18 + param_2[1] + -1);
        do {
          uVar14 = uVar14 - 1;
          pbVar31[1] = ~pbVar31[1];
          *pbVar31 = ~*pbVar31;
          pbVar31 = pbVar31 + -4;
        } while (uVar14 != 0);
      }
    }
    else if (cVar12 == '\x06') {
      if (uVar35 == 8) {
        if (uVar14 != 0) {
          pbVar31 = (byte *)(iVar18 + param_2[1]);
          do {
            uVar14 = uVar14 - 1;
            *pbVar31 = ~*pbVar31;
            pbVar31 = pbVar31 + -4;
          } while (uVar14 != 0);
        }
      }
      else if (uVar14 != 0) {
        pbVar31 = (byte *)(iVar18 + param_2[1] + -1);
        do {
          uVar14 = uVar14 - 1;
          pbVar31[1] = ~pbVar31[1];
          *pbVar31 = ~*pbVar31;
          pbVar31 = pbVar31 + -8;
        } while (uVar14 != 0);
      }
    }
  }
  uVar14 = *(uint *)(param_1 + 0x138);
  if (((uVar14 & 8) != 0) && (uVar35 = (ushort)param_2[2], (char)uVar35 != '\x03')) {
    uVar14 = (uint)(uVar35 >> 8);
    if ((uVar35 & 2) == 0) {
      bVar21 = *(byte *)(param_1 + 0x264);
      iVar18 = 1;
    }
    else {
      bVar21 = *(byte *)(param_1 + 0x261);
      local_38[1] = uVar14 - *(byte *)(param_1 + 0x262);
      local_38[2] = uVar14 - *(byte *)(param_1 + 0x263);
      iVar18 = 3;
    }
    pbVar31 = (byte *)(*(int *)(param_1 + 0x1e0) + 1);
    local_38[0] = uVar14 - bVar21;
    if ((uVar35 & 4) != 0) {
      local_38[iVar18] = uVar14 - *(byte *)(param_1 + 0x265);
      iVar18 = iVar18 + 1;
    }
    bVar39 = false;
    iVar37 = 0;
    do {
      if (((int)local_38[iVar37] < 1) || ((int)uVar14 <= (int)local_38[iVar37])) {
        local_38[iVar37] = 0;
      }
      else {
        bVar39 = true;
      }
      iVar24 = iVar37 + 1;
      if (SBORROW4(iVar24,iVar37)) goto LAB_00024ba6;
      iVar37 = iVar24;
    } while (iVar24 < iVar18);
    if (bVar39) {
      if (uVar14 < 8) {
        if (uVar14 == 2) {
          uVar14 = param_2[1];
          if (0 < (int)uVar14) {
            pbVar20 = pbVar31;
            do {
              pbVar15 = pbVar20 + 1;
              *pbVar20 = *pbVar20 >> 1 & 0x55;
              pbVar20 = pbVar15;
            } while (pbVar15 < pbVar31 + uVar14);
          }
        }
        else if ((uVar14 == 4) && (uVar14 = param_2[1], 0 < (int)uVar14)) {
          uVar22 = 0xf >> (local_38[0] & 0xff);
          pbVar20 = pbVar31;
          do {
            pbVar15 = pbVar20 + 1;
            *pbVar20 = *pbVar20 >> (local_38[0] & 0xff) & ((byte)uVar22 | (byte)(uVar22 << 4));
            pbVar20 = pbVar15;
          } while (pbVar15 < pbVar31 + uVar14);
        }
      }
      else if (uVar14 == 8) {
        uVar14 = param_2[1];
        if (0 < (int)uVar14) {
          iVar37 = 0;
          pbVar20 = pbVar31;
          do {
            iVar24 = iVar37 + 1;
            if (SBORROW4(iVar24,iVar37)) goto LAB_00024ba6;
            puVar6 = local_38 + iVar37;
            iVar37 = iVar24;
            if (iVar18 <= iVar24) {
              iVar37 = 0;
            }
            pbVar15 = pbVar20 + 1;
            *pbVar20 = *pbVar20 >> (*puVar6 & 0xff);
            pbVar20 = pbVar15;
          } while (pbVar15 < pbVar31 + uVar14);
        }
      }
      else if ((uVar14 == 0x10) && (0 < (int)param_2[1])) {
        pbVar20 = pbVar31 + param_2[1];
        iVar37 = 0;
        do {
          iVar24 = iVar37 + 1;
          if (SBORROW4(iVar24,iVar37)) {
LAB_00024ba6:
                    // WARNING: Does not return
            pcVar1 = (code *)software_udf(0xfe,0x24ba6);
            (*pcVar1)();
          }
          uVar35 = CONCAT11(*pbVar31,pbVar31[1]) >> (local_38[iVar37] & 0xff);
          *pbVar31 = (byte)(uVar35 >> 8);
          pbVar31[1] = (byte)uVar35;
          iVar37 = iVar24;
          if (iVar18 <= iVar24) {
            iVar37 = 0;
          }
          pbVar31 = pbVar31 + 2;
        } while (pbVar31 < pbVar20);
      }
    }
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if (((uVar14 & 4) != 0) && (bVar21 = *(byte *)((int)param_2 + 9), bVar21 < 8)) {
    iVar18 = *(int *)(param_1 + 0x1e0);
    uVar14 = *param_2;
    iVar37 = iVar18 + 1;
    if (bVar21 == 4) {
      if (uVar14 != 0) {
        iVar24 = (uVar14 & 1) << 2;
        pbVar31 = (byte *)(iVar37 + (uVar14 - 1 >> 1));
        uVar22 = uVar14;
        do {
          bVar39 = iVar24 == 4;
          bVar21 = *pbVar31 >> iVar24;
          iVar24 = 4;
          *(byte *)(iVar18 + uVar22) = bVar21 & 0xf;
          if (bVar39) {
            iVar24 = 0;
            pbVar31 = pbVar31 + -1;
          }
          uVar22 = uVar22 - 1;
        } while (uVar22 != 0);
      }
    }
    else if (bVar21 == 2) {
      if (uVar14 != 0) {
        uVar32 = ~(uVar14 * 2 + 6) & 6;
        pbVar31 = (byte *)(iVar37 + (uVar14 - 1 >> 2));
        uVar22 = uVar14;
        do {
          bVar39 = uVar32 == 6;
          uVar28 = uVar32 & 0xff;
          uVar32 = uVar32 + 2;
          *(byte *)(iVar18 + uVar22) = *pbVar31 >> uVar28 & 3;
          if (bVar39) {
            uVar32 = 0;
            pbVar31 = pbVar31 + -1;
          }
          uVar22 = uVar22 - 1;
        } while (uVar22 != 0);
      }
    }
    else if ((bVar21 == 1) && (uVar14 != 0)) {
      uVar32 = ~(uVar14 + 7) & 7;
      pbVar31 = (byte *)(iVar37 + (uVar14 - 1 >> 3));
      uVar22 = uVar14;
      do {
        bVar39 = uVar32 == 7;
        uVar28 = uVar32 & 0xff;
        uVar32 = uVar32 + 1;
        *(byte *)(iVar18 + uVar22) = *pbVar31 >> uVar28 & 1;
        if (bVar39) {
          uVar32 = 0;
          pbVar31 = pbVar31 + -1;
        }
        uVar22 = uVar22 - 1;
      } while (uVar22 != 0);
    }
    *(undefined1 *)((int)param_2 + 9) = 8;
    *(byte *)((int)param_2 + 0xb) = *(byte *)((int)param_2 + 10) << 3;
    param_2[1] = *(byte *)((int)param_2 + 10) * uVar14;
  }
  if (((char)param_2[2] == '\x03') && (-1 < *(int *)(param_1 + 0x200))) {
    png_do_check_palette_indexes(param_1,param_2);
  }
  uVar14 = *(uint *)(param_1 + 0x138);
  if ((uVar14 & 1) != 0) {
    png_do_bgr(param_2,*(int *)(param_1 + 0x1e0) + 1);
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if ((uVar14 & 0x10000) != 0) {
    png_do_packswap(param_2,*(int *)(param_1 + 0x1e0) + 1);
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if ((uVar14 & 0x8000) == 0) goto LAB_00024896;
  iVar37 = *(int *)(param_1 + 0x1e0);
  uVar32 = param_2[2] & 0xff;
  uVar22 = *param_2;
  iVar18 = iVar37 + 1;
  uVar28 = *(uint *)(param_1 + 0x134);
  uVar14 = (param_2[2] & 0xff00) >> 8;
  uVar13 = (undefined1)*(undefined2 *)(param_1 + 0x214);
  uVar5 = (undefined1)((ushort)*(undefined2 *)(param_1 + 0x214) >> 8);
  if (uVar32 == 2) {
    if (uVar14 == 0x10) {
      if ((uVar28 & 0x80) == 0) {
        if (uVar22 != 0) {
          puVar23 = (undefined1 *)(iVar37 + uVar22 * 6 + -2);
          puVar27 = (undefined1 *)(iVar37 + uVar22 * 8 + -3);
          uVar14 = uVar22;
          do {
            uVar14 = uVar14 - 1;
            puVar27[3] = puVar23[2];
            puVar27[2] = puVar23[1];
            puVar27[1] = *puVar23;
            *puVar27 = puVar23[-1];
            puVar27[-1] = puVar23[-2];
            puVar16 = puVar23 + -3;
            puVar23 = puVar23 + -6;
            puVar27[-2] = *puVar16;
            puVar27[-3] = uVar13;
            puVar27[-4] = uVar5;
            puVar27 = puVar27 + -8;
          } while (uVar14 != 0);
        }
      }
      else {
        iVar18 = iVar18 + uVar22 * 8;
        *(undefined1 *)(iVar18 + -1) = uVar13;
        *(undefined1 *)(iVar18 + -2) = uVar5;
        if (1 < uVar22) {
          puVar27 = (undefined1 *)(iVar37 + uVar22 * 8 + -4);
          puVar23 = (undefined1 *)(iVar37 + uVar22 * 6 + -2);
          iVar18 = uVar22 - 1;
          do {
            iVar18 = iVar18 + -1;
            puVar27[2] = puVar23[2];
            puVar27[1] = puVar23[1];
            *puVar27 = *puVar23;
            puVar27[-1] = puVar23[-1];
            puVar27[-2] = puVar23[-2];
            puVar16 = puVar23 + -3;
            puVar23 = puVar23 + -6;
            puVar27[-3] = *puVar16;
            puVar27[-4] = uVar13;
            puVar27[-5] = uVar5;
            puVar27 = puVar27 + -8;
          } while (iVar18 != 0);
        }
      }
      *(undefined1 *)((int)param_2 + 10) = 4;
      *(undefined1 *)((int)param_2 + 0xb) = 0x40;
      uVar22 = uVar22 << 3;
    }
    else {
      if (uVar14 != 8) goto LAB_00024896;
      if ((uVar28 & 0x80) == 0) {
        if (uVar22 != 0) {
          puVar23 = (undefined1 *)(uVar22 * 3 + iVar37);
          puVar27 = (undefined1 *)(iVar37 + uVar22 * 4 + -1);
          uVar14 = uVar22;
          do {
            uVar14 = uVar14 - 1;
            puVar27[1] = *puVar23;
            *puVar27 = puVar23[-1];
            puVar16 = puVar23 + -2;
            puVar23 = puVar23 + -3;
            puVar27[-1] = *puVar16;
            puVar27[-2] = uVar13;
            puVar27 = puVar27 + -4;
          } while (uVar14 != 0);
        }
      }
      else {
        *(undefined1 *)(iVar18 + uVar22 * 4 + -1) = uVar13;
        if (1 < uVar22) {
          puVar27 = (undefined1 *)(iVar37 + uVar22 * 3);
          puVar23 = (undefined1 *)(iVar37 + uVar22 * 4 + -2);
          iVar18 = uVar22 - 1;
          do {
            iVar18 = iVar18 + -1;
            puVar23[1] = *puVar27;
            *puVar23 = puVar27[-1];
            puVar16 = puVar27 + -2;
            puVar27 = puVar27 + -3;
            puVar23[-1] = *puVar16;
            puVar23[-2] = uVar13;
            puVar23 = puVar23 + -4;
          } while (iVar18 != 0);
        }
      }
      uVar13 = 4;
LAB_0002481c:
      *(undefined1 *)((int)param_2 + 10) = uVar13;
      *(undefined1 *)((int)param_2 + 0xb) = 0x20;
      uVar22 = uVar22 << 2;
    }
  }
  else {
    if (uVar32 != 0) goto LAB_00024896;
    if (uVar14 == 0x10) {
      if ((uVar28 & 0x80) == 0) {
        if (uVar22 != 0) {
          puVar23 = (undefined1 *)(iVar37 + uVar22 * 2 + -1);
          puVar27 = (undefined1 *)(iVar37 + uVar22 * 4 + -1);
          uVar14 = uVar22;
          do {
            uVar14 = uVar14 - 1;
            puVar27[1] = puVar23[1];
            uVar4 = *puVar23;
            puVar23 = puVar23 + -2;
            *puVar27 = uVar4;
            puVar27[-1] = uVar13;
            puVar27[-2] = uVar5;
            puVar27 = puVar27 + -4;
          } while (uVar14 != 0);
        }
      }
      else {
        iVar18 = iVar18 + uVar22 * 4;
        *(undefined1 *)(iVar18 + -1) = uVar13;
        *(undefined1 *)(iVar18 + -2) = uVar5;
        if (1 < uVar22) {
          puVar23 = (undefined1 *)(iVar37 + uVar22 * 2 + -1);
          puVar27 = (undefined1 *)(iVar37 + uVar22 * 4 + -2);
          iVar18 = uVar22 - 1;
          do {
            iVar18 = iVar18 + -1;
            *puVar27 = puVar23[1];
            uVar4 = *puVar23;
            puVar23 = puVar23 + -2;
            puVar27[-1] = uVar4;
            puVar27[-2] = uVar13;
            puVar27[-3] = uVar5;
            puVar27 = puVar27 + -4;
          } while (iVar18 != 0);
        }
      }
      uVar13 = 2;
      goto LAB_0002481c;
    }
    if (uVar14 != 8) goto LAB_00024896;
    uVar14 = uVar22;
    if ((uVar28 & 0x80) == 0) {
      for (; uVar14 != 0; uVar14 = uVar14 - 1) {
        *(undefined1 *)(iVar37 + uVar14 * 2) = *(undefined1 *)(iVar37 + uVar14);
        *(undefined1 *)(iVar37 + uVar14 * 2 + -1) = uVar13;
      }
    }
    else {
      *(undefined1 *)(iVar18 + uVar22 * 2 + -1) = uVar13;
      if (1 < uVar22) {
        do {
          *(undefined1 *)(iVar37 + uVar14 * 2 + -1) = *(undefined1 *)(iVar37 + uVar14);
          *(undefined1 *)(iVar37 + -2 + uVar14 * 2) = uVar13;
          uVar14 = uVar14 - 1;
        } while (uVar14 != 1);
      }
    }
    *(undefined1 *)((int)param_2 + 10) = 2;
    *(undefined1 *)((int)param_2 + 0xb) = 0x10;
    uVar22 = uVar22 << 1;
  }
  param_2[1] = uVar22;
LAB_00024896:
  if ((*(byte *)(param_1 + 0x13a) & 2) != 0) {
    uVar14 = *param_2;
    iVar18 = *(int *)(param_1 + 0x1e0);
    uVar22 = param_2[2] & 0xff;
    uVar32 = (param_2[2] & 0xff00) >> 8;
    if (uVar22 == 4) {
      if (uVar32 == 8) {
        if (uVar14 != 0) {
          puVar23 = (undefined1 *)(iVar18 + param_2[1] + -1);
          do {
            uVar14 = uVar14 - 1;
            uVar13 = puVar23[1];
            puVar23[1] = *puVar23;
            *puVar23 = uVar13;
            puVar23 = puVar23 + -2;
          } while (uVar14 != 0);
        }
      }
      else if (uVar14 != 0) {
        puVar23 = (undefined1 *)(iVar18 + param_2[1] + -1);
        do {
          uVar14 = uVar14 - 1;
          uVar13 = *puVar23;
          uVar5 = puVar23[1];
          puVar23[1] = puVar23[-1];
          *puVar23 = puVar23[-2];
          puVar23[-1] = uVar5;
          puVar23[-2] = uVar13;
          puVar23 = puVar23 + -4;
        } while (uVar14 != 0);
      }
    }
    else if (uVar22 == 6) {
      if (uVar32 == 8) {
        if (uVar14 != 0) {
          puVar23 = (undefined1 *)(iVar18 + param_2[1] + -1);
          do {
            uVar14 = uVar14 - 1;
            uVar13 = puVar23[1];
            puVar23[1] = *puVar23;
            *puVar23 = puVar23[-1];
            puVar23[-1] = puVar23[-2];
            puVar23[-2] = uVar13;
            puVar23 = puVar23 + -4;
          } while (uVar14 != 0);
        }
      }
      else if (uVar14 != 0) {
        puVar23 = (undefined1 *)(iVar18 + param_2[1] + -3);
        do {
          uVar14 = uVar14 - 1;
          uVar13 = puVar23[2];
          uVar5 = puVar23[3];
          puVar23[3] = puVar23[1];
          puVar23[2] = *puVar23;
          puVar23[1] = puVar23[-1];
          *puVar23 = puVar23[-2];
          puVar23[-1] = puVar23[-3];
          puVar23[-2] = puVar23[-4];
          puVar23[-3] = uVar5;
          puVar23[-4] = uVar13;
          puVar23 = puVar23 + -8;
        } while (uVar14 != 0);
      }
    }
  }
  uVar14 = *(uint *)(param_1 + 0x138);
  if ((uVar14 & 0x10) != 0) {
    png_do_swap(param_2,*(int *)(param_1 + 0x1e0) + 1);
    uVar14 = *(uint *)(param_1 + 0x138);
  }
  if ((uVar14 & 0x100000) != 0) {
    if (*(code **)(param_1 + 0x120) != (code *)0x0) {
      (**(code **)(param_1 + 0x120))(param_1,param_2,*(int *)(param_1 + 0x1e0) + 1);
    }
    uVar35 = *(ushort *)(param_1 + 300);
    if ((uVar35 & 0xff) != 0) {
      *(char *)((int)param_2 + 9) = (char)uVar35;
    }
    cVar12 = (char)(uVar35 >> 8);
    if (uVar35 >> 8 == 0) {
      cVar12 = *(char *)((int)param_2 + 10);
    }
    else {
      *(char *)((int)param_2 + 10) = cVar12;
    }
    bVar21 = cVar12 * *(char *)((int)param_2 + 9);
    *(byte *)((int)param_2 + 0xb) = bVar21;
    if (bVar21 < 8) {
      uVar14 = (uint)bVar21 * *param_2 + 7 >> 3;
    }
    else {
      uVar14 = (uint)(bVar21 >> 3) * *param_2;
    }
    param_2[1] = uVar14;
  }
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void FUN_00024bdc(uint *param_1,int param_2,int param_3)

{
  char *pcVar1;
  code *pcVar2;
  undefined2 uVar3;
  undefined2 uVar4;
  undefined2 uVar5;
  ushort uVar6;
  ushort uVar7;
  byte bVar8;
  char cVar9;
  uint uVar10;
  char *pcVar11;
  char *pcVar12;
  undefined1 *puVar13;
  undefined2 *puVar14;
  uint uVar15;
  uint uVar16;
  uint uVar17;
  int iVar18;
  byte *pbVar19;
  undefined1 uVar20;
  ushort uVar21;
  undefined1 *puVar22;
  byte *pbVar23;
  int iVar24;
  uint uVar25;
  int iVar26;
  undefined1 *puVar27;
  int iVar28;
  bool bVar29;
  
  uVar6 = (ushort)param_1[2];
  uVar25 = *param_1;
  uVar21 = uVar6 >> 8;
  if ((uVar6 & 0xff) == 0) {
    if (param_3 == 0) {
      uVar16 = 0;
    }
    else {
      uVar16 = (uint)*(ushort *)(param_3 + 8);
    }
    if (uVar21 < 8) {
      if (uVar21 == 4) {
        uVar16 = (uVar16 & 0xf) * 0x11;
        if (uVar25 != 0) {
          uVar15 = uVar25 - 1;
          iVar18 = (uVar25 & 1) << 2;
          pbVar19 = (byte *)(param_2 + (uVar15 >> 1));
          do {
            bVar29 = iVar18 == 4;
            bVar8 = *pbVar19 >> iVar18;
            iVar18 = 4;
            uVar17 = bVar8 & 0xf;
            *(byte *)(param_2 + uVar15) = (byte)uVar17 | (byte)(uVar17 << 4);
            uVar15 = uVar15 - 1;
            if (bVar29) {
              iVar18 = 0;
              pbVar19 = pbVar19 + -1;
            }
          } while (uVar15 != 0xffffffff);
        }
      }
      else if (uVar21 == 2) {
        uVar16 = (uVar16 & 3) * 0x55;
        if (uVar25 != 0) {
          pbVar23 = (byte *)(param_2 + (uVar25 - 1));
          pbVar19 = (byte *)(param_2 + (uVar25 - 1 >> 2));
          uVar17 = 0;
          uVar15 = ~(uVar25 * 2 + 6) & 6;
          do {
            uVar10 = *pbVar19 >> (uVar15 & 0xff) & 3;
            *pbVar23 = (byte)uVar10 | (byte)(uVar10 << 2) | (byte)(uVar10 << 4) |
                       (byte)(uVar10 << 6);
            if (uVar15 == 6) {
              pbVar19 = pbVar19 + -1;
              uVar10 = 0;
            }
            else {
              uVar10 = uVar15 + 2;
              if (SBORROW4(uVar10,uVar15)) goto LAB_00024f96;
            }
            uVar17 = uVar17 + 1;
            pbVar23 = pbVar23 + -1;
            uVar15 = uVar10;
          } while (uVar17 < uVar25);
        }
      }
      else if ((uVar21 == 1) && (uVar16 = -(uVar16 & 1) & 0xff, uVar25 != 0)) {
        puVar13 = (undefined1 *)(param_2 + (uVar25 - 1));
        pbVar19 = (byte *)(param_2 + (uVar25 - 1 >> 3));
        uVar17 = 0;
        uVar15 = ~(uVar25 + 7) & 7;
        do {
          uVar10 = (uint)*pbVar19 & 1 << (uVar15 & 0xff);
          uVar20 = (undefined1)uVar10;
          if (uVar10 != 0) {
            uVar20 = 0xff;
          }
          *puVar13 = uVar20;
          if (uVar15 == 7) {
            pbVar19 = pbVar19 + -1;
            uVar10 = 0;
          }
          else {
            uVar10 = uVar15 + 1;
            if (SBORROW4(uVar10,uVar15)) {
LAB_00024f96:
                    // WARNING: Does not return
              pcVar2 = (code *)software_udf(0xfe,0x24f96);
              (*pcVar2)();
            }
          }
          uVar17 = uVar17 + 1;
          puVar13 = puVar13 + -1;
          uVar15 = uVar10;
        } while (uVar17 < uVar25);
      }
      uVar21 = 8;
      *(undefined1 *)((int)param_1 + 9) = 8;
      *(undefined1 *)((int)param_1 + 0xb) = 8;
      param_1[1] = uVar25;
    }
    if (param_3 != 0) {
      if (uVar21 == 0x10) {
        if (uVar25 != 0) {
          puVar14 = (undefined2 *)(param_2 + param_1[1] * 2 + -2);
          pbVar19 = (byte *)(param_1[1] + param_2 + -1);
          uVar15 = uVar25;
          do {
            if (((uint)pbVar19[-1] == uVar16 >> 8) && ((uint)*pbVar19 == (uVar16 & 0xff))) {
              *puVar14 = 0;
            }
            else {
              *puVar14 = 0xffff;
            }
            uVar15 = uVar15 - 1;
            *(byte *)((int)puVar14 + -1) = *pbVar19;
            pbVar23 = pbVar19 + -1;
            pbVar19 = pbVar19 + -2;
            *(byte *)(puVar14 + -1) = *pbVar23;
            puVar14 = puVar14 + -2;
          } while (uVar15 != 0);
        }
      }
      else if ((uVar21 == 8) && (uVar25 != 0)) {
        uVar15 = uVar25;
        do {
          uVar20 = 0;
          if ((uint)*(byte *)(param_2 + uVar15 + -1) != (uVar16 & 0xff)) {
            uVar20 = 0xff;
          }
          *(undefined1 *)(param_2 + uVar15 * 2 + -1) = uVar20;
          *(undefined1 *)(param_2 + -2 + uVar15 * 2) = *(undefined1 *)(param_2 + uVar15 + -1);
          uVar15 = uVar15 - 1;
        } while (uVar15 != 0);
      }
      *(undefined1 *)(param_1 + 2) = 4;
      *(undefined1 *)((int)param_1 + 10) = 2;
      bVar8 = *(char *)((int)param_1 + 9) << 1;
      *(byte *)((int)param_1 + 0xb) = bVar8;
      if (bVar8 < 8) {
        uVar25 = bVar8 * uVar25 + 7 >> 3;
      }
      else {
        uVar25 = (bVar8 >> 3) * uVar25;
      }
      param_1[1] = uVar25;
    }
  }
  else if ((param_3 != 0) && ((char)uVar6 == '\x02')) {
    if (uVar21 == 0x10) {
      if (uVar25 != 0) {
        uVar6 = *(ushort *)(param_3 + 6);
        uVar21 = *(ushort *)(param_3 + 4);
        uVar7 = *(ushort *)(param_3 + 2);
        iVar18 = uVar25 * 8;
        uVar15 = param_1[1];
        iVar26 = param_2 + uVar15;
        uVar16 = uVar25;
        do {
          iVar18 = iVar18 + -8;
          iVar24 = param_2 + uVar15;
          iVar28 = param_2 + iVar18;
          if ((((((ushort)*(byte *)(iVar24 + -6) == uVar7 >> 8) &&
                (*(char *)(iVar24 + -5) == (char)uVar7)) &&
               ((ushort)*(byte *)(iVar24 + -4) == uVar21 >> 8)) &&
              ((*(char *)(iVar24 + -3) == (char)uVar21 &&
               ((ushort)*(byte *)(iVar24 + -2) == uVar6 >> 8)))) &&
             (*(char *)(iVar24 + -1) == (char)uVar6)) {
            puVar27 = (undefined1 *)(iVar26 + -4);
            *(undefined1 *)(iVar28 + 7) = 0;
            puVar22 = (undefined1 *)(iVar26 + -3);
            puVar13 = (undefined1 *)(iVar26 + -2);
            *(undefined1 *)(iVar28 + 6) = 0;
          }
          else {
            puVar13 = (undefined1 *)(param_2 + -2 + uVar15);
            *(undefined1 *)(iVar28 + 7) = 0xff;
            puVar22 = puVar13 + -1;
            puVar27 = puVar13 + -2;
            *(undefined1 *)(iVar28 + 6) = 0xff;
          }
          uVar16 = uVar16 - 1;
          *(undefined1 *)(iVar28 + 5) = *(undefined1 *)(iVar24 + -1);
          uVar15 = uVar15 - 6;
          *(undefined1 *)(iVar28 + 4) = *puVar13;
          *(undefined1 *)(iVar28 + 3) = *puVar22;
          *(undefined1 *)(iVar28 + 2) = *puVar27;
          *(undefined1 *)(iVar28 + 1) = *(undefined1 *)(iVar24 + -5);
          *(undefined1 *)(param_2 + iVar18) = *(undefined1 *)(iVar24 + -6);
          iVar26 = iVar26 + -6;
        } while (uVar16 != 0);
      }
    }
    else if ((uVar21 == 8) && (uVar25 != 0)) {
      uVar3 = *(undefined2 *)(param_3 + 4);
      uVar4 = *(undefined2 *)(param_3 + 2);
      uVar5 = *(undefined2 *)(param_3 + 6);
      pcVar12 = (char *)(param_2 + uVar25 * 4 + -2);
      pcVar11 = (char *)(param_2 + param_1[1] + -2);
      uVar16 = uVar25;
      do {
        if (pcVar11[-1] == (char)uVar4) {
          cVar9 = *pcVar11;
          bVar29 = cVar9 == (char)uVar3;
          if (bVar29) {
            cVar9 = pcVar11[1];
          }
          if (!bVar29 || cVar9 != (char)uVar5) goto LAB_00024c50;
          cVar9 = '\0';
        }
        else {
LAB_00024c50:
          cVar9 = -1;
        }
        pcVar12[1] = cVar9;
        uVar16 = uVar16 - 1;
        *pcVar12 = pcVar11[1];
        pcVar12[-1] = *pcVar11;
        pcVar1 = pcVar11 + -1;
        pcVar11 = pcVar11 + -3;
        pcVar12[-2] = *pcVar1;
        pcVar12 = pcVar12 + -4;
      } while (uVar16 != 0);
    }
    *(undefined1 *)(param_1 + 2) = 6;
    *(undefined1 *)((int)param_1 + 10) = 4;
    bVar8 = *(char *)((int)param_1 + 9) << 2;
    *(byte *)((int)param_1 + 0xb) = bVar8;
    if (bVar8 < 8) {
      uVar25 = uVar25 * bVar8 + 7 >> 3;
    }
    else {
      uVar25 = uVar25 * (bVar8 >> 3);
    }
    param_1[1] = uVar25;
  }
  return;
}



void FUN_00024f98(int *param_1,int param_2)

{
  byte bVar1;
  byte bVar2;
  char cVar3;
  uint uVar4;
  undefined1 *puVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  int iVar9;
  
  bVar1 = *(byte *)((int)param_1 + 9);
  if (7 < bVar1) {
    bVar2 = *(byte *)(param_1 + 2);
    if ((bVar2 & 2) != 0) {
      return;
    }
    iVar9 = *param_1;
    if (bVar2 == 4) {
      iVar6 = iVar9;
      if (bVar1 == 8) {
        for (; iVar6 != 0; iVar6 = iVar6 + -1) {
          iVar7 = param_2 + iVar6 * 2;
          iVar8 = param_2 + iVar6 * 4;
          *(undefined1 *)(iVar8 + -1) = *(undefined1 *)(iVar7 + -1);
          *(undefined1 *)(iVar8 + -2) = *(undefined1 *)(iVar7 + -2);
          *(undefined1 *)(iVar8 + -3) = *(undefined1 *)(iVar7 + -2);
          *(undefined1 *)(iVar8 + -4) = *(undefined1 *)(iVar7 + -2);
        }
      }
      else {
        for (; iVar6 != 0; iVar6 = iVar6 + -1) {
          iVar7 = param_2 + iVar6 * 4;
          iVar8 = param_2 + iVar6 * 8;
          *(undefined1 *)(iVar8 + -1) = *(undefined1 *)(iVar7 + -1);
          *(undefined1 *)(iVar8 + -2) = *(undefined1 *)(iVar7 + -2);
          *(undefined1 *)(iVar8 + -3) = *(undefined1 *)(iVar7 + -3);
          *(undefined1 *)(iVar8 + -4) = *(undefined1 *)(iVar7 + -4);
          *(undefined1 *)(iVar8 + -5) = *(undefined1 *)(iVar7 + -3);
          *(undefined1 *)(iVar8 + -6) = *(undefined1 *)(iVar7 + -4);
          *(undefined1 *)(iVar8 + -7) = *(undefined1 *)(iVar7 + -3);
          *(undefined1 *)(iVar8 + -8) = *(undefined1 *)(iVar7 + -4);
        }
      }
    }
    else if (bVar2 == 0) {
      iVar6 = iVar9;
      if (bVar1 == 8) {
        for (; iVar6 != 0; iVar6 = iVar6 + -1) {
          iVar7 = param_2 + iVar6;
          iVar8 = param_2 + iVar6 * 3;
          *(undefined1 *)(iVar8 + -1) = *(undefined1 *)(iVar7 + -1);
          *(undefined1 *)(iVar8 + -2) = *(undefined1 *)(iVar7 + -1);
          *(undefined1 *)(iVar8 + -3) = *(undefined1 *)(iVar7 + -1);
        }
      }
      else if (iVar9 != 0) {
        puVar5 = (undefined1 *)(param_2 + iVar9 * 6 + -1);
        do {
          iVar7 = param_2 + iVar6 * 2;
          iVar6 = iVar6 + -1;
          *puVar5 = *(undefined1 *)(iVar7 + -1);
          puVar5[-1] = *(undefined1 *)(iVar7 + -2);
          puVar5[-2] = *(undefined1 *)(iVar7 + -1);
          puVar5[-3] = *(undefined1 *)(iVar7 + -2);
          puVar5[-4] = *(undefined1 *)(iVar7 + -1);
          puVar5[-5] = *(undefined1 *)(iVar7 + -2);
          puVar5 = puVar5 + -6;
        } while (iVar6 != 0);
      }
    }
    cVar3 = *(char *)((int)param_1 + 10) + '\x02';
    *(char *)((int)param_1 + 10) = cVar3;
    bVar1 = (char)((ushort)(short)param_1[2] >> 8) * cVar3;
    *(byte *)(param_1 + 2) = (byte)(short)param_1[2] | 2;
    *(byte *)((int)param_1 + 0xb) = bVar1;
    if (bVar1 < 8) {
      uVar4 = (uint)bVar1 * iVar9 + 7 >> 3;
    }
    else {
      uVar4 = (uint)(bVar1 >> 3) * iVar9;
    }
    param_1[1] = uVar4;
  }
  return;
}



void png_get_uint_31(undefined4 param_1,byte *param_2)

{
  if ((int)((uint)param_2[3] |
           (uint)param_2[1] << 0x10 | (uint)*param_2 << 0x18 | (uint)param_2[2] << 8) < 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"PNG unsigned integer out of range");
  }
  return;
}



uint png_get_uint_32(byte *param_1)

{
  return (uint)param_1[3] |
         (uint)param_1[1] << 0x10 | (uint)*param_1 << 0x18 | (uint)param_1[2] << 8;
}



// WARNING: Removing unreachable block (ram,0x0002517c)

uint png_get_int_32(byte *param_1)

{
  uint uVar1;
  
  uVar1 = (uint)param_1[3] |
          (uint)param_1[1] << 0x10 | (uint)*param_1 << 0x18 | (uint)param_1[2] << 8;
  if ((0x7f < *param_1) && (0 < (int)uVar1)) {
    return 0;
  }
  return uVar1;
}



undefined2 png_get_uint_16(undefined1 *param_1)

{
  return CONCAT11(*param_1,param_1[1]);
}



void png_read_sig(int param_1,int param_2)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  
  uVar2 = (uint)*(byte *)(param_1 + 0x211);
  if (uVar2 < 8) {
    param_2 = param_2 + 0x20;
    iVar3 = -uVar2 + 8;
    *(undefined4 *)(param_1 + 0x360) = 0x11;
    png_read_data(param_1,param_2 + uVar2,iVar3);
    *(undefined1 *)(param_1 + 0x211) = 8;
    iVar3 = png_sig_cmp(param_2,uVar2,iVar3);
    if (iVar3 != 0) {
      if ((uVar2 < 4) && (iVar3 = png_sig_cmp(param_2,uVar2,-uVar2 + 4), iVar3 != 0)) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Not a PNG file");
      }
                    // WARNING: Subroutine does not return
      png_error(param_1,"PNG file corrupted by ASCII conversion");
    }
    uVar1 = 0;
    if (uVar2 < 3) {
      uVar1 = *(uint *)(param_1 + 0x130) | 0x1000;
    }
    if (uVar2 < 3) {
      *(uint *)(param_1 + 0x130) = uVar1;
    }
  }
  return;
}



void png_read_chunk_header(int param_1)

{
  undefined1 auStack_1c [4];
  byte local_18;
  byte local_17;
  byte local_16;
  byte local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  *(undefined4 *)(param_1 + 0x360) = 0x21;
  png_read_data(param_1,auStack_1c,8);
  png_get_uint_31(param_1,auStack_1c);
  *(uint *)(param_1 + 0x1d8) =
       (uint)local_17 << 0x10 | (uint)local_18 << 0x18 | (uint)local_16 << 8 | (uint)local_15;
  png_reset_crc(param_1);
  png_calculate_crc(param_1,&local_18,4);
  png_check_chunk_name(param_1,*(undefined4 *)(param_1 + 0x1d8));
  *(undefined4 *)(param_1 + 0x360) = 0x41;
  if (__stack_chk_guard - local_14 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_14);
  }
  return;
}



void png_check_chunk_name(undefined4 param_1,uint param_2)

{
  code *pcVar1;
  int iVar2;
  int iVar3;
  
  iVar3 = 1;
  do {
    if ((0x39 < (param_2 & 0xff) - 0x41) || ((param_2 & 0xff) - 0x5b < 6)) {
                    // WARNING: Subroutine does not return
      png_chunk_error(param_1,"invalid chunk type");
    }
    iVar2 = iVar3 + 1;
    if (SBORROW4(iVar2,iVar3)) {
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x252c6);
      (*pcVar1)();
    }
    param_2 = param_2 >> 8;
    iVar3 = iVar2;
  } while (iVar2 < 5);
  return;
}



void png_crc_read(int param_1,undefined4 param_2,undefined4 param_3)

{
  if (param_1 == 0) {
    return;
  }
  png_read_data(param_1,param_2,param_3);
  png_calculate_crc(param_1,param_2,param_3);
  return;
}



void png_crc_finish(int param_1,uint param_2)

{
  int iVar1;
  undefined4 uVar2;
  uint uVar3;
  undefined1 auStack_418 [1024];
  int local_18;
  
  local_18 = __stack_chk_guard;
  if (param_2 != 0) {
    do {
      uVar3 = param_2;
      if (0x3ff < param_2) {
        uVar3 = 0x400;
      }
      png_crc_read(param_1,auStack_418,uVar3);
      param_2 = param_2 - uVar3;
    } while (param_2 != 0);
  }
  iVar1 = png_crc_error(param_1);
  if (iVar1 == 0) {
    uVar2 = 0;
  }
  else {
    if ((*(byte *)(param_1 + 0x1db) & 0x20) == 0) {
      if ((*(uint *)(param_1 + 0x134) & 0x400) == 0) {
LAB_00025376:
                    // WARNING: Subroutine does not return
        png_chunk_error(param_1,"CRC error");
      }
    }
    else if ((*(uint *)(param_1 + 0x134) & 0x200) != 0) goto LAB_00025376;
    uVar2 = 1;
  }
  if (__stack_chk_guard == local_18) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar2);
}



void png_crc_error(int param_1)

{
  undefined4 uVar1;
  uint uVar2;
  byte local_18;
  byte local_17;
  byte local_16;
  byte local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  uVar2 = *(uint *)(param_1 + 0x134);
  if ((*(byte *)(param_1 + 0x1db) & 0x20) == 0) {
    *(undefined4 *)(param_1 + 0x360) = 0x81;
    png_read_data(param_1,&local_18,4);
    if ((uVar2 & 0x800) != 0) {
LAB_000253dc:
      uVar1 = 0;
      goto LAB_0002540a;
    }
  }
  else {
    *(undefined4 *)(param_1 + 0x360) = 0x81;
    png_read_data(param_1,&local_18,4);
    if ((uVar2 & 0x300) == 0x300) goto LAB_000253dc;
  }
  uVar1 = 0;
  if (((uint)local_17 << 0x10 | (uint)local_18 << 0x18 | (uint)local_16 << 8 | (uint)local_15) !=
      *(uint *)(param_1 + 500)) {
    uVar1 = 1;
  }
LAB_0002540a:
  if (__stack_chk_guard == local_14) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar1);
}



void png_handle_IHDR(int param_1,undefined4 param_2,int param_3)

{
  byte bVar1;
  int iVar2;
  undefined4 uVar3;
  char cVar4;
  uint uVar5;
  undefined1 auStack_29 [4];
  undefined1 auStack_25 [4];
  char local_21;
  char local_20;
  undefined1 local_1f;
  undefined1 local_1e;
  undefined1 local_1d;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) != 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"out of place");
  }
  if (param_3 == 0xd) {
    *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 1;
    png_crc_read(param_1,auStack_29,0xd);
    png_crc_finish(param_1,0);
    iVar2 = png_get_uint_31(param_1,auStack_29);
    uVar3 = png_get_uint_31(param_1,auStack_25);
    *(int *)(param_1 + 0x1bc) = iVar2;
    *(undefined4 *)(param_1 + 0x1c0) = uVar3;
    *(char *)(param_1 + 0x20c) = local_21;
    *(undefined1 *)(param_1 + 0x208) = local_1d;
    *(char *)(param_1 + 0x20b) = local_20;
    *(undefined1 *)(param_1 + 0x308) = local_1e;
    *(undefined1 *)(param_1 + 0x328) = local_1f;
    if (local_20 == '\x02') {
      cVar4 = '\x03';
    }
    else if (local_20 == '\x04') {
      cVar4 = '\x02';
    }
    else if (local_20 == '\x06') {
      cVar4 = '\x04';
    }
    else {
      cVar4 = '\x01';
    }
    *(char *)(param_1 + 0x20f) = cVar4;
    bVar1 = local_21 * cVar4;
    *(byte *)(param_1 + 0x20e) = bVar1;
    if (bVar1 < 8) {
      uVar5 = iVar2 * (uint)bVar1 + 7 >> 3;
    }
    else {
      uVar5 = iVar2 * (uint)(bVar1 >> 3);
    }
    *(uint *)(param_1 + 0x1cc) = uVar5;
    png_set_IHDR(param_1,param_2,iVar2,uVar3,local_21,local_20,local_1d,local_1f,local_1e);
    if (__stack_chk_guard == local_1c) {
      return;
    }
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
                    // WARNING: Subroutine does not return
  png_chunk_error(param_1,"invalid");
}



void png_handle_PLTE(int param_1,int param_2,uint param_3)

{
  code *pcVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  char *pcVar5;
  undefined1 *puVar6;
  int iVar7;
  undefined1 local_327;
  undefined1 local_326;
  undefined1 local_325;
  undefined1 local_324 [768];
  int local_24;
  
  local_24 = __stack_chk_guard;
  uVar2 = *(uint *)(param_1 + 0x130);
  if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((uVar2 & 2) != 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"duplicate");
  }
  if ((uVar2 & 4) == 0) {
    *(uint *)(param_1 + 0x130) = uVar2 | 2;
    if ((*(byte *)(param_1 + 0x20b) & 2) == 0) {
      png_crc_finish(param_1,param_3);
      pcVar5 = "ignored in grayscale PNG";
    }
    else if ((param_3 < 0x301) && (param_3 == (param_3 / 3) * 3)) {
      if (*(byte *)(param_1 + 0x20b) == 3) {
        iVar3 = 1 << *(sbyte *)(param_1 + 0x20c);
      }
      else {
        iVar3 = 0x100;
      }
      iVar7 = (int)param_3 / 3;
      if (iVar3 < (int)param_3 / 3) {
        iVar7 = iVar3;
      }
      if (0 < iVar7) {
        puVar6 = local_324;
        iVar3 = 0;
        do {
          png_crc_read(param_1,&local_327,3);
          *puVar6 = local_327;
          puVar6[1] = local_326;
          puVar6[2] = local_325;
          iVar4 = iVar3 + 1;
          if (SBORROW4(iVar4,iVar3)) goto LAB_000256f2;
          puVar6 = puVar6 + 3;
          iVar3 = iVar4;
        } while (iVar4 < iVar7);
      }
      if (((int)((ulonglong)((longlong)iVar7 * 3) >> 0x20) != iVar7 * 3 >> 0x1f) ||
         (SBORROW4(param_3,iVar7 * 3))) {
LAB_000256f2:
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x256f2);
        (*pcVar1)();
      }
      png_crc_finish(param_1,param_3 + iVar7 * -3);
      png_set_PLTE(param_1,param_2,local_324,iVar7);
      if (*(short *)(param_1 + 0x204) == 0) {
        if (param_2 == 0) goto LAB_000256d8;
        uVar2 = *(uint *)(param_2 + 8);
        if ((uVar2 & 0x10) != 0) {
          *(undefined2 *)(param_1 + 0x204) = 0;
          goto LAB_0002569c;
        }
      }
      else {
        *(undefined2 *)(param_1 + 0x204) = 0;
        if (param_2 == 0) {
          pcVar5 = "tRNS must be after";
          goto LAB_000256d2;
        }
LAB_0002569c:
        *(undefined2 *)(param_2 + 0x16) = 0;
        png_chunk_benign_error(param_1,"tRNS must be after");
        uVar2 = *(uint *)(param_2 + 8);
      }
      if ((uVar2 & 0x40) != 0) {
        png_chunk_benign_error(param_1,"hIST must be after");
      }
      if ((*(byte *)(param_2 + 8) & 0x20) == 0) goto LAB_000256d8;
      pcVar5 = "bKGD must be after";
    }
    else {
      png_crc_finish(param_1,param_3,param_3 * -0x55555555);
      if (*(char *)(param_1 + 0x20b) == '\x03') {
                    // WARNING: Subroutine does not return
        png_chunk_error(param_1,"invalid");
      }
      pcVar5 = "invalid";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar5 = "out of place";
  }
LAB_000256d2:
  png_chunk_benign_error(param_1,pcVar5);
LAB_000256d8:
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_IEND(int param_1,undefined4 param_2,int param_3)

{
  if ((*(uint *)(param_1 + 0x130) & 5) != 5) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"out of place");
  }
  *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 0x18;
  png_crc_finish(param_1,param_3);
  if (param_3 == 0) {
    return;
  }
  png_chunk_benign_error(param_1,"invalid");
  return;
}



void png_handle_gAMA(int param_1,undefined4 param_2,int param_3)

{
  int iVar1;
  char *pcVar2;
  uint uVar3;
  byte local_18;
  byte local_17;
  byte local_16;
  byte local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 6) == 0) {
    if (param_3 == 4) {
      png_crc_read(param_1,&local_18,4);
      iVar1 = png_crc_finish(param_1,0);
      if (iVar1 == 0) {
        uVar3 = (uint)local_17 << 0x10 | (uint)local_18 << 0x18 | (uint)local_16 << 8 |
                (uint)local_15;
        if (0x7fffffff < uVar3) {
          uVar3 = 0xffffffff;
        }
        png_colorspace_set_gamma(param_1,param_1 + 0x378,uVar3);
        png_colorspace_sync(param_1,param_2);
      }
      goto LAB_00025822;
    }
    png_crc_finish(param_1,param_3);
    pcVar2 = "invalid";
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar2 = "out of place";
  }
  png_chunk_benign_error(param_1,pcVar2);
LAB_00025822:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_sBIT(int param_1,int param_2,uint param_3)

{
  undefined1 uVar1;
  uint uVar2;
  int iVar3;
  undefined1 uVar4;
  char *pcVar5;
  undefined1 uVar6;
  uint uVar7;
  undefined4 local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 6) == 0) {
    if ((param_2 == 0) || ((*(byte *)(param_2 + 8) & 2) == 0)) {
      if (*(char *)(param_1 + 0x20b) == '\x03') {
        uVar7 = 8;
        uVar2 = 3;
      }
      else {
        uVar7 = (uint)*(byte *)(param_1 + 0x20c);
        uVar2 = (uint)*(byte *)(param_1 + 0x20f);
      }
      if ((param_3 < 5) && (uVar2 == param_3)) {
        local_20 = uVar7 * 0x1010101;
        png_crc_read(param_1,&local_20,param_3);
        iVar3 = png_crc_finish(param_1,0);
        if (iVar3 == 0) {
          if (param_3 != 0) {
            uVar2 = 0;
            do {
              if (uVar7 <= (*(byte *)((int)&local_20 + uVar2) - 1 & 0xff)) {
                pcVar5 = "invalid";
                goto LAB_0002588a;
              }
              uVar2 = uVar2 + 1;
            } while (uVar2 < param_3);
          }
          if ((*(byte *)(param_1 + 0x20b) & 2) == 0) {
            *(undefined1 *)(param_1 + 0x25f) = (undefined1)local_20;
            uVar4 = local_20._1_1_;
            uVar6 = (undefined1)local_20;
            uVar1 = (undefined1)local_20;
          }
          else {
            uVar4 = local_20._3_1_;
            uVar6 = local_20._2_1_;
            uVar1 = local_20._1_1_;
          }
          *(undefined1 *)(param_1 + 0x25c) = (undefined1)local_20;
          *(undefined1 *)(param_1 + 0x25d) = uVar1;
          *(undefined1 *)(param_1 + 0x25e) = uVar6;
          *(undefined1 *)(param_1 + 0x260) = uVar4;
          png_set_sBIT(param_1,param_2,param_1 + 0x25c);
        }
      }
      else {
        png_chunk_benign_error(param_1,"invalid");
        png_crc_finish(param_1,param_3);
      }
      goto LAB_00025890;
    }
    png_crc_finish(param_1,param_3);
    pcVar5 = "duplicate";
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar5 = "out of place";
  }
LAB_0002588a:
  png_chunk_benign_error(param_1,pcVar5);
LAB_00025890:
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_cHRM(int param_1,undefined4 param_2,int param_3)

{
  ushort uVar1;
  int iVar2;
  char *pcVar3;
  uint uVar4;
  uint local_5c;
  uint local_58;
  uint local_54;
  uint local_50;
  uint local_4c;
  uint local_48;
  uint local_44;
  uint local_40;
  byte local_3c;
  byte local_3b;
  byte local_3a;
  byte local_39;
  byte local_38;
  byte local_37;
  byte local_36;
  byte local_35;
  byte local_34;
  byte local_33;
  byte local_32;
  byte local_31;
  byte local_30;
  byte local_2f;
  byte local_2e;
  byte local_2d;
  byte local_2c;
  byte local_2b;
  byte local_2a;
  byte local_29;
  byte local_28;
  byte local_27;
  byte local_26;
  byte local_25;
  byte local_24;
  byte local_23;
  byte local_22;
  byte local_21;
  byte local_20;
  byte local_1f;
  byte local_1e;
  byte local_1d;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 6) == 0) {
    if (param_3 == 0x20) {
      png_crc_read(param_1,&local_3c,0x20);
      iVar2 = png_crc_finish(param_1,0);
      if (iVar2 != 0) goto LAB_00025ba6;
      local_44 = (uint)local_3b << 0x10 | (uint)local_3c << 0x18 | (uint)local_3a << 8 |
                 (uint)local_39;
      if (0x7fffffff < local_44) {
        local_44 = 0xffffffff;
      }
      local_40 = (uint)local_37 << 0x10 | (uint)local_38 << 0x18 | (uint)local_36 << 8 |
                 (uint)local_35;
      if (0x7fffffff < local_40) {
        local_40 = 0xffffffff;
      }
      local_5c = (uint)local_33 << 0x10 | (uint)local_34 << 0x18 | (uint)local_32 << 8 |
                 (uint)local_31;
      if (0x7fffffff < local_5c) {
        local_5c = 0xffffffff;
      }
      local_58 = (uint)local_2f << 0x10 | (uint)local_30 << 0x18 | (uint)local_2e << 8 |
                 (uint)local_2d;
      if (0x7fffffff < local_58) {
        local_58 = 0xffffffff;
      }
      local_54 = (uint)local_2b << 0x10 | (uint)local_2c << 0x18 | (uint)local_2a << 8 |
                 (uint)local_29;
      if (0x7fffffff < local_54) {
        local_54 = 0xffffffff;
      }
      local_50 = (uint)local_27 << 0x10 | (uint)local_28 << 0x18 | (uint)local_26 << 8 |
                 (uint)local_25;
      if (0x7fffffff < local_50) {
        local_50 = 0xffffffff;
      }
      local_4c = (uint)local_23 << 0x10 | (uint)local_24 << 0x18 | (uint)local_22 << 8 |
                 (uint)local_21;
      if (0x7fffffff < local_4c) {
        local_4c = 0xffffffff;
      }
      uVar4 = (uint)local_1f << 0x10 | (uint)local_20 << 0x18 | (uint)local_1e << 8 | (uint)local_1d
      ;
      local_48 = 0xffffffff;
      if (-1 < (int)uVar4) {
        local_48 = uVar4;
      }
      if (local_48 != 0xffffffff) {
        uVar4 = local_44;
        if (local_44 != 0xffffffff) {
          uVar4 = local_40;
        }
        if ((((local_44 != 0xffffffff && uVar4 != 0xffffffff) &&
             (local_5c != 0xffffffff && local_58 != 0xffffffff)) &&
            (local_54 != 0xffffffff && local_50 != 0xffffffff)) && (local_4c != 0xffffffff)) {
          uVar1 = *(ushort *)(param_1 + 0x3c2);
          if ((uVar1 & 0x8000) != 0) goto LAB_00025ba6;
          if ((uVar1 & 0x10) == 0) {
            *(ushort *)(param_1 + 0x3c2) = uVar1 | 0x10;
            png_colorspace_set_chromaticities(param_1,param_1 + 0x378,&local_5c,1);
            png_colorspace_sync(param_1,param_2);
            goto LAB_00025ba6;
          }
          *(ushort *)(param_1 + 0x3c2) = uVar1 | 0x8000;
          png_colorspace_sync(param_1,param_2);
          pcVar3 = "duplicate";
          goto LAB_00025ba0;
        }
      }
      pcVar3 = "invalid values";
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar3 = "invalid";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar3 = "out of place";
  }
LAB_00025ba0:
  png_chunk_benign_error(param_1,pcVar3);
LAB_00025ba6:
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_sRGB(int param_1,undefined4 param_2,int param_3)

{
  ushort uVar1;
  int iVar2;
  char *pcVar3;
  undefined1 local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 6) == 0) {
    if (param_3 == 1) {
      png_crc_read(param_1,&local_15,1);
      iVar2 = png_crc_finish(param_1,0);
      if ((iVar2 != 0) || (uVar1 = *(ushort *)(param_1 + 0x3c2), (uVar1 & 0x8000) != 0))
      goto LAB_00025c84;
      if ((uVar1 & 4) == 0) {
        png_colorspace_set_sRGB(param_1,param_1 + 0x378,local_15);
        png_colorspace_sync(param_1,param_2);
        goto LAB_00025c84;
      }
      *(ushort *)(param_1 + 0x3c2) = uVar1 | 0x8000;
      png_colorspace_sync(param_1,param_2);
      pcVar3 = "too many profiles";
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar3 = "invalid";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar3 = "out of place";
  }
  png_chunk_benign_error(param_1,pcVar3);
LAB_00025c84:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



// WARNING: Removing unreachable block (ram,0x00025e76)
// WARNING: Removing unreachable block (ram,0x00025ea6)
// WARNING: Removing unreachable block (ram,0x00025ec0)
// WARNING: Removing unreachable block (ram,0x00025f30)
// WARNING: Removing unreachable block (ram,0x00025ee6)
// WARNING: Removing unreachable block (ram,0x00025f36)
// WARNING: Removing unreachable block (ram,0x00025f78)
// WARNING: Removing unreachable block (ram,0x00025f48)
// WARNING: Removing unreachable block (ram,0x00025f68)
// WARNING: Removing unreachable block (ram,0x00025f72)
// WARNING: Removing unreachable block (ram,0x00025f94)
// WARNING: Removing unreachable block (ram,0x00025f98)
// WARNING: Removing unreachable block (ram,0x00025f9e)
// WARNING: Removing unreachable block (ram,0x00025fb8)
// WARNING: Removing unreachable block (ram,0x00026012)
// WARNING: Removing unreachable block (ram,0x00025fd4)
// WARNING: Removing unreachable block (ram,0x00026006)
// WARNING: Removing unreachable block (ram,0x00025dd6)

void png_handle_iCCP(int param_1,undefined4 param_2,uint param_3)

{
  int iVar1;
  char *pcVar2;
  uint uVar3;
  uint uVar4;
  bool bVar5;
  uint local_50c;
  undefined1 auStack_508 [1024];
  undefined1 local_108 [136];
  char local_80 [88];
  int local_28;
  
  local_28 = __stack_chk_guard;
  local_50c = param_3;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 6) == 0) {
    if (param_3 < 9) {
      png_crc_finish(param_1,param_3);
      if (__stack_chk_guard == local_28) {
        pcVar2 = "too short";
        goto LAB_00025d46;
      }
    }
    else {
      if ((*(ushort *)(param_1 + 0x3c2) & 0x8000) != 0) {
        png_crc_finish(param_1,param_3);
        return;
      }
      if ((*(ushort *)(param_1 + 0x3c2) & 4) == 0) {
        uVar4 = param_3;
        if (0x50 < param_3) {
          uVar4 = 0x51;
        }
        png_crc_read(param_1,local_80,uVar4);
        param_3 = param_3 - uVar4;
        local_50c = param_3;
        if (uVar4 == 0) {
          pcVar2 = "bad keyword";
        }
        else {
          uVar3 = 0;
          do {
            if (local_80[uVar3] == '\0') break;
            uVar3 = uVar3 + 1;
            bVar5 = 0x4e < uVar3;
            if (uVar3 < 0x50) {
              bVar5 = uVar4 <= uVar3;
            }
          } while (!bVar5);
          if (uVar3 - 1 < 0x4f) {
            if (uVar3 + 1 < uVar4) {
              if (local_80[uVar3 + 1] == '\0') {
                iVar1 = FUN_0002607c(param_1,0x69434350);
                if (iVar1 == 0) {
                  *(char **)(param_1 + 0x140) = local_80 + uVar3 + 2;
                  *(uint *)(param_1 + 0x144) = uVar4 - (uVar3 + 2);
                  FUN_00026138(param_1,auStack_508,&local_50c,local_108);
                  pcVar2 = *(char **)(param_1 + 0x158);
                  *(undefined4 *)(param_1 + 0x13c) = 0;
                  param_3 = local_50c;
                }
                else {
                  pcVar2 = *(char **)(param_1 + 0x158);
                }
              }
              else {
                pcVar2 = "bad compression method";
              }
            }
            else {
              pcVar2 = "bad compression method";
            }
          }
          else {
            pcVar2 = "bad keyword";
          }
        }
      }
      else {
        pcVar2 = "too many profiles";
      }
      png_crc_finish(param_1,param_3);
      *(ushort *)(param_1 + 0x3c2) = *(ushort *)(param_1 + 0x3c2) | 0x8000;
      png_colorspace_sync(param_1,param_2);
      if (pcVar2 != (char *)0x0) {
        png_chunk_benign_error(param_1,pcVar2);
      }
      if (__stack_chk_guard == local_28) {
        return;
      }
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    if (__stack_chk_guard == local_28) {
      pcVar2 = "out of place";
LAB_00025d46:
      png_chunk_benign_error(param_1,pcVar2);
      return;
    }
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void FUN_0002607c(int param_1,undefined4 param_2)

{
  int iVar1;
  undefined1 local_54;
  undefined1 local_53;
  undefined1 local_52;
  undefined1 local_51;
  int local_14;
  
  local_14 = __stack_chk_guard;
  iVar1 = *(int *)(param_1 + 0x13c);
  if (iVar1 != 0) {
    local_54 = (undefined1)((uint)iVar1 >> 0x18);
    local_53 = (undefined1)((uint)iVar1 >> 0x10);
    local_52 = (undefined1)((uint)iVar1 >> 8);
    local_51 = (undefined1)iVar1;
    png_safecat(&local_54,0x40,4," using zstream");
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,&local_54);
  }
  *(undefined4 *)(param_1 + 0x140) = 0;
  *(undefined4 *)(param_1 + 0x144) = 0;
  *(undefined4 *)(param_1 + 0x14c) = 0;
  *(undefined4 *)(param_1 + 0x150) = 0;
  if ((*(byte *)(param_1 + 0x134) & 2) == 0) {
    iVar1 = inflateInit_(param_1 + 0x140,"1.2.8",0x38);
    if (iVar1 != 0) {
LAB_000260d0:
      png_zstream_error(param_1,iVar1);
      goto LAB_000260e0;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 2;
  }
  else {
    iVar1 = inflateReset(param_1 + 0x140);
    if (iVar1 != 0) goto LAB_000260d0;
  }
  *(undefined4 *)(param_1 + 0x13c) = param_2;
LAB_000260e0:
  if (__stack_chk_guard - local_14 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_14);
  }
  return;
}



void FUN_00026138(int param_1,undefined4 param_2,uint *param_3,undefined4 param_4,int *param_5,
                 int param_6)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  undefined4 uVar4;
  int iVar5;
  uint uVar6;
  undefined4 uVar7;
  
  if (*(int *)(param_1 + 0x13c) != *(int *)(param_1 + 0x1d8)) {
    *(char **)(param_1 + 0x158) = "zstream unclaimed";
    return;
  }
  uVar7 = 2;
  *(undefined4 *)(param_1 + 0x14c) = param_4;
  *(undefined4 *)(param_1 + 0x150) = 0;
  if (param_6 != 0) {
    uVar7 = 4;
  }
  uVar6 = 0x400;
  while( true ) {
    if (*(int *)(param_1 + 0x144) == 0) {
      uVar1 = *param_3;
      if (uVar1 < uVar6) {
        uVar6 = uVar1;
      }
      *param_3 = uVar1 - uVar6;
      if (uVar6 != 0) {
        png_crc_read(param_1,param_2,uVar6);
      }
      *(undefined4 *)(param_1 + 0x140) = param_2;
      *(uint *)(param_1 + 0x144) = uVar6;
    }
    if (*(int *)(param_1 + 0x150) == 0) {
      iVar2 = *param_5;
      *param_5 = 0;
      *(int *)(param_1 + 0x150) = iVar2;
    }
    uVar4 = 0;
    if (*param_3 == 0) {
      uVar4 = uVar7;
    }
    iVar2 = inflate(param_1 + 0x140,uVar4);
    if (iVar2 != 0) break;
    if ((*param_5 == 0) && (*(int *)(param_1 + 0x150) == 0)) {
      iVar3 = 0;
      iVar5 = 0;
      iVar2 = 0;
LAB_000261e0:
      *param_5 = iVar3 + iVar5;
      *(undefined4 *)(param_1 + 0x150) = 0;
      png_zstream_error(param_1,iVar2);
      return;
    }
  }
  iVar3 = *param_5;
  iVar5 = *(int *)(param_1 + 0x150);
  goto LAB_000261e0;
}



int FUN_000261fc(int param_1,uint param_2,int param_3)

{
  int iVar1;
  
  if (*(int *)(param_1 + 0x354) != 0) {
    if (param_2 <= *(uint *)(param_1 + 0x358)) {
      return *(int *)(param_1 + 0x354);
    }
    *(undefined4 *)(param_1 + 0x354) = 0;
    *(undefined4 *)(param_1 + 0x358) = 0;
    png_free(param_1);
  }
  iVar1 = png_malloc_base(param_1,param_2);
  if (iVar1 == 0) {
    if (param_3 == 0) {
                    // WARNING: Subroutine does not return
      png_chunk_error(param_1,"insufficient memory to read chunk");
    }
    iVar1 = 0;
  }
  else {
    *(int *)(param_1 + 0x354) = iVar1;
    *(uint *)(param_1 + 0x358) = param_2;
  }
  return iVar1;
}



void png_handle_sPLT(int param_1,undefined4 param_2,uint param_3)

{
  code *pcVar1;
  int iVar2;
  char *pcVar3;
  uint uVar4;
  ushort *puVar5;
  int extraout_r1;
  byte *pbVar6;
  ushort uVar7;
  int iVar8;
  char *pcVar9;
  byte *pbVar11;
  undefined4 uVar12;
  char cVar13;
  char *local_34;
  char local_30;
  int local_2c;
  uint local_28;
  int local_24;
  char *pcVar10;
  
  local_24 = __stack_chk_guard;
  iVar2 = *(int *)(param_1 + 0x334);
  if ((iVar2 == 0) || ((iVar2 != 1 && (*(int *)(param_1 + 0x334) = iVar2 + -1, iVar2 + -1 != 1)))) {
    if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
      png_chunk_error(param_1,"missing IHDR");
    }
    if ((*(uint *)(param_1 + 0x130) & 4) == 0) {
      pcVar3 = (char *)FUN_000261fc(param_1,param_3 + 1,2);
      if (pcVar3 != (char *)0x0) {
        png_crc_read(param_1,pcVar3,param_3);
        iVar2 = png_crc_finish(param_1,0);
        if (iVar2 == 0) {
          pcVar3[param_3] = '\0';
          pcVar9 = pcVar3;
          do {
            pcVar10 = pcVar9;
            pcVar9 = pcVar10 + 1;
          } while (*pcVar10 != '\0');
          if ((1 < param_3) && (pcVar9 <= pcVar3 + (param_3 - 2))) {
            pbVar11 = (byte *)(pcVar10 + 2);
            cVar13 = *pcVar9;
            uVar12 = 10;
            if (cVar13 == '\b') {
              uVar12 = 6;
            }
            local_30 = cVar13;
            __aeabi_uidivmod(pcVar3 + (param_3 - (int)pbVar11),uVar12);
            if (((extraout_r1 == 0) &&
                (uVar4 = __aeabi_uidiv(pcVar3 + (param_3 - (int)pbVar11),uVar12), uVar4 < 0x1999999a
                )) && (local_28 = uVar4, local_2c = png_malloc_warn(param_1,uVar4 * 10),
                      local_2c != 0)) {
              if (uVar4 != 0) {
                iVar2 = 0;
                while( true ) {
                  puVar5 = (ushort *)(local_2c + iVar2 * 10);
                  if (cVar13 == '\b') {
                    *puVar5 = (ushort)*pbVar11;
                    puVar5[1] = (ushort)pbVar11[1];
                    puVar5[2] = (ushort)pbVar11[2];
                    pbVar6 = pbVar11 + 4;
                    uVar7 = (ushort)pbVar11[3];
                  }
                  else {
                    *puVar5 = CONCAT11(*pbVar11,pbVar11[1]);
                    puVar5[1] = CONCAT11(pbVar11[2],pbVar11[3]);
                    puVar5[2] = CONCAT11(pbVar11[4],pbVar11[5]);
                    pbVar6 = pbVar11 + 8;
                    uVar7 = CONCAT11(pbVar11[6],pbVar11[7]);
                  }
                  puVar5[3] = uVar7;
                  puVar5[4] = CONCAT11(*pbVar6,pbVar6[1]);
                  iVar8 = iVar2 + 1;
                  if (SBORROW4(iVar8,iVar2)) {
                    // WARNING: Does not return
                    pcVar1 = (code *)software_udf(0xfe,0x263f8);
                    (*pcVar1)();
                  }
                  if ((int)local_28 <= iVar8) break;
                  pbVar11 = pbVar6 + 2;
                  iVar2 = iVar8;
                  cVar13 = local_30;
                }
              }
              local_34 = pcVar3;
              png_set_sPLT(param_1,param_2,&local_34,1);
              png_free(param_1,local_2c);
            }
          }
        }
        goto LAB_00026348;
      }
      png_crc_finish(param_1,param_3);
      pcVar3 = "out of memory";
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar3 = "out of place";
    }
    png_chunk_benign_error(param_1,pcVar3);
  }
  else {
    png_crc_finish(param_1,param_3);
  }
LAB_00026348:
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_tRNS(int param_1,int param_2,uint param_3)

{
  char cVar1;
  uint uVar2;
  int iVar3;
  char *pcVar4;
  bool bVar5;
  undefined1 local_11e;
  undefined1 local_11d;
  undefined1 local_11c;
  undefined1 local_11b;
  undefined1 local_11a;
  undefined1 local_119;
  undefined1 auStack_118 [256];
  int local_18;
  
  local_18 = __stack_chk_guard;
  uVar2 = *(uint *)(param_1 + 0x130);
  if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((uVar2 & 4) == 0) {
    if ((param_2 == 0) || ((*(byte *)(param_2 + 8) & 0x10) == 0)) {
      cVar1 = *(char *)(param_1 + 0x20b);
      if (cVar1 == '\x03') {
        if ((uVar2 & 2) == 0) {
          png_crc_finish(param_1,param_3);
          pcVar4 = "out of place";
        }
        else {
          bVar5 = 0xff < param_3;
          if (param_3 < 0x101) {
            bVar5 = (uint)*(ushort *)(param_1 + 0x1fc) <= param_3 - 1;
          }
          if (!bVar5) {
            png_crc_read(param_1,auStack_118,param_3);
            *(short *)(param_1 + 0x204) = (short)param_3;
            goto LAB_00026560;
          }
          png_crc_finish(param_1,param_3);
          pcVar4 = "invalid";
        }
      }
      else if (cVar1 == '\x02') {
        if (param_3 == 6) {
          png_crc_read(param_1,&local_11e,6);
          *(undefined2 *)(param_1 + 0x204) = 1;
          *(ushort *)(param_1 + 0x26e) = CONCAT11(local_11e,local_11d);
          *(ushort *)(param_1 + 0x270) = CONCAT11(local_11c,local_11b);
          *(ushort *)(param_1 + 0x272) = CONCAT11(local_11a,local_119);
LAB_00026560:
          iVar3 = png_crc_finish(param_1,0);
          if (iVar3 == 0) {
            png_set_tRNS(param_1,param_2,auStack_118,*(undefined2 *)(param_1 + 0x204),
                         param_1 + 0x26c);
          }
          else {
            *(undefined2 *)(param_1 + 0x204) = 0;
          }
          goto LAB_0002653c;
        }
        png_crc_finish(param_1,param_3);
        pcVar4 = "invalid";
      }
      else if (cVar1 == '\0') {
        if (param_3 == 2) {
          png_crc_read(param_1,&local_11e,2);
          *(undefined2 *)(param_1 + 0x204) = 1;
          *(ushort *)(param_1 + 0x274) = CONCAT11(local_11e,local_11d);
          goto LAB_00026560;
        }
        png_crc_finish(param_1,param_3);
        pcVar4 = "invalid";
      }
      else {
        png_crc_finish(param_1,param_3);
        pcVar4 = "invalid with alpha channel";
      }
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar4 = "duplicate";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar4 = "out of place";
  }
  png_chunk_benign_error(param_1,pcVar4);
LAB_0002653c:
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_bKGD(int param_1,int param_2,uint param_3)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  char *pcVar5;
  byte local_24 [2];
  undefined4 local_22;
  ushort local_1e;
  ushort local_1c;
  byte local_1a;
  undefined1 local_19;
  undefined1 local_18;
  undefined1 local_17;
  undefined1 local_16;
  undefined1 local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  uVar4 = *(uint *)(param_1 + 0x130);
  if ((uVar4 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if (((uVar4 & 4) == 0) &&
     (uVar1 = (uint)*(byte *)(param_1 + 0x20b), (uVar4 & 2) != 0 || uVar1 != 3)) {
    if ((param_2 == 0) || ((*(byte *)(param_2 + 8) & 0x20) == 0)) {
      if (uVar1 == 3) {
        uVar4 = 1;
      }
      else {
        uVar4 = (uVar1 & 2) << 1 | 2;
      }
      if (uVar4 == param_3) {
        png_crc_read(param_1,&local_1a);
        iVar2 = png_crc_finish(param_1,0);
        if (iVar2 != 0) goto LAB_00026600;
        if (*(byte *)(param_1 + 0x20b) == 3) {
          local_24[0] = local_1a;
          if ((param_2 == 0) || (*(ushort *)(param_2 + 0x14) == 0)) {
            local_1e = 0;
            local_22 = 0;
          }
          else {
            if ((uint)*(ushort *)(param_2 + 0x14) <= (uint)local_1a) {
              pcVar5 = "invalid index";
              goto LAB_000265fa;
            }
            iVar2 = (uint)local_1a * 3;
            iVar3 = iVar2 + *(int *)(param_1 + 0x1f8);
            local_22 = (uint)CONCAT12(*(undefined1 *)(iVar3 + 1),
                                      (ushort)*(byte *)(*(int *)(param_1 + 0x1f8) + iVar2));
            local_1e = (ushort)*(byte *)(iVar3 + 2);
          }
LAB_000266fe:
          local_1c = 0;
        }
        else {
          local_24[0] = 0;
          local_1e = CONCAT11(local_1a,local_19);
          if ((*(byte *)(param_1 + 0x20b) & 2) != 0) {
            local_22 = CONCAT22(CONCAT11(local_18,local_17),local_1e);
            local_1e = CONCAT11(local_16,local_15);
            goto LAB_000266fe;
          }
          local_22 = CONCAT22(local_1e,local_1e);
          local_1c = local_1e;
        }
        png_set_bKGD(param_1,param_2,local_24);
        goto LAB_00026600;
      }
      png_crc_finish(param_1,param_3);
      pcVar5 = "invalid";
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar5 = "duplicate";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar5 = "out of place";
  }
LAB_000265fa:
  png_chunk_benign_error(param_1,pcVar5);
LAB_00026600:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_hIST(int param_1,int param_2,uint param_3)

{
  byte bVar1;
  int iVar2;
  char *pcVar3;
  undefined2 *puVar4;
  uint uVar5;
  undefined1 local_21e;
  undefined1 local_21d;
  undefined2 auStack_21c [256];
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 6) == 2) {
    bVar1 = 0;
    if (param_2 != 0) {
      bVar1 = *(byte *)(param_2 + 8);
    }
    if (param_2 != 0 && (bVar1 & 0x40) != 0) {
      png_crc_finish(param_1,param_3);
      pcVar3 = "duplicate";
    }
    else {
      if ((param_3 < 0x202) && (uVar5 = param_3 >> 1, uVar5 == *(ushort *)(param_1 + 0x1fc))) {
        if (uVar5 != 0) {
          puVar4 = auStack_21c;
          do {
            png_crc_read(param_1,&local_21e,2);
            uVar5 = uVar5 - 1;
            *puVar4 = CONCAT11(local_21e,local_21d);
            puVar4 = puVar4 + 1;
          } while (uVar5 != 0);
        }
        iVar2 = png_crc_finish(param_1,0);
        if (iVar2 == 0) {
          png_set_hIST(param_1,param_2,auStack_21c);
        }
        goto LAB_000267f0;
      }
      png_crc_finish(param_1,param_3);
      pcVar3 = "invalid";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar3 = "out of place";
  }
  png_chunk_benign_error(param_1,pcVar3);
LAB_000267f0:
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_pHYs(int param_1,int param_2,int param_3)

{
  int iVar1;
  char *pcVar2;
  byte local_25;
  byte local_24;
  byte local_23;
  byte local_22;
  byte local_21;
  byte local_20;
  byte local_1f;
  byte local_1e;
  undefined1 local_1d;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 4) == 0) {
    if ((param_2 == 0) || ((*(byte *)(param_2 + 8) & 0x80) == 0)) {
      if (param_3 == 9) {
        png_crc_read(param_1,&local_25,9);
        iVar1 = png_crc_finish(param_1,0);
        if (iVar1 == 0) {
          png_set_pHYs(param_1,param_2,
                       (uint)local_24 << 0x10 | (uint)local_25 << 0x18 | (uint)local_23 << 8 |
                       (uint)local_22,
                       (uint)local_20 << 0x10 | (uint)local_21 << 0x18 | (uint)local_1f << 8 |
                       (uint)local_1e,local_1d);
        }
        goto LAB_000268ee;
      }
      png_crc_finish(param_1,param_3);
      pcVar2 = "invalid";
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar2 = "duplicate";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar2 = "out of place";
  }
  png_chunk_benign_error(param_1,pcVar2);
LAB_000268ee:
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_oFFs(int param_1,int param_2,int param_3)

{
  int iVar1;
  char *pcVar2;
  uint uVar3;
  uint uVar4;
  byte local_1d;
  byte local_1c;
  byte local_1b;
  byte local_1a;
  byte local_19;
  byte local_18;
  byte local_17;
  byte local_16;
  undefined1 local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 4) == 0) {
    if ((param_2 == 0) || ((*(byte *)(param_2 + 9) & 1) == 0)) {
      if (param_3 == 9) {
        png_crc_read(param_1,&local_1d,9);
        iVar1 = png_crc_finish(param_1,0);
        if (iVar1 == 0) {
          uVar3 = (uint)local_1c << 0x10 | (uint)local_1d << 0x18 | (uint)local_1b << 8 |
                  (uint)local_1a;
          if ((local_1d & 0x80) != 0) {
            uVar3 = -(-uVar3 & 0x7fffffff);
          }
          uVar4 = (uint)local_18 << 0x10 | (uint)local_19 << 0x18 | (uint)local_17 << 8 |
                  (uint)local_16;
          if ((local_19 & 0x80) != 0) {
            uVar4 = -(-uVar4 & 0x7fffffff);
          }
          png_set_oFFs(param_1,param_2,uVar3,uVar4,local_15);
        }
        goto LAB_00026a06;
      }
      png_crc_finish(param_1,param_3);
      pcVar2 = "invalid";
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar2 = "duplicate";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar2 = "out of place";
  }
  png_chunk_benign_error(param_1,pcVar2);
LAB_00026a06:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_pCAL(int param_1,int param_2,int param_3)

{
  code *pcVar1;
  byte bVar2;
  byte *pbVar3;
  uint uVar4;
  int iVar5;
  int iVar6;
  byte *pbVar7;
  byte *pbVar8;
  char *pcVar9;
  int iVar10;
  int iVar11;
  uint uVar12;
  uint uVar13;
  
  uVar4 = *(uint *)(param_1 + 0x130);
  if ((uVar4 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((uVar4 & 4) == 0) {
    if (param_2 != 0) {
      uVar4 = (uint)*(byte *)(param_2 + 9);
    }
    if (param_2 != 0 && (uVar4 & 4) != 0) {
      png_crc_finish(param_1,param_3);
      pcVar9 = "duplicate";
    }
    else {
      iVar5 = FUN_000261fc(param_1,param_3 + 1,2);
      if (iVar5 == 0) {
        png_crc_finish(param_1,param_3);
        pcVar9 = "out of memory";
      }
      else {
        png_crc_read(param_1,iVar5,param_3);
        iVar11 = 0;
        iVar6 = png_crc_finish(param_1,0);
        if (iVar6 != 0) {
          return;
        }
        *(undefined1 *)(iVar5 + param_3) = 0;
        do {
          pcVar9 = (char *)(iVar5 + iVar11);
          iVar11 = iVar11 + 1;
        } while (*pcVar9 != '\0');
        pbVar7 = (byte *)(iVar5 + iVar11);
        if ((param_3 + iVar5) - (int)(pbVar7 + -1) < 0xd) {
          pcVar9 = "invalid";
        }
        else {
          uVar4 = (uint)pbVar7[1] << 0x10 | (uint)*pbVar7 << 0x18 | (uint)pbVar7[2] << 8 |
                  (uint)pbVar7[3];
          if ((*pbVar7 & 0x80) != 0) {
            uVar4 = -(-uVar4 & 0x7fffffff);
          }
          uVar12 = (uint)pbVar7[7] |
                   (uint)pbVar7[5] << 0x10 | (uint)pbVar7[4] << 0x18 | (uint)pbVar7[6] << 8;
          if ((pbVar7[4] & 0x80) != 0) {
            uVar12 = -(-uVar12 & 0x7fffffff);
          }
          bVar2 = pbVar7[8];
          uVar13 = (uint)pbVar7[9];
          if ((((bVar2 == 0) && (uVar13 != 2)) || (((byte)(bVar2 - 1) < 2 && (uVar13 != 3)))) ||
             ((bVar2 == 3 && (uVar13 != 4)))) {
            pcVar9 = "invalid parameter count";
          }
          else {
            pbVar7 = pbVar7 + 10;
            pbVar3 = pbVar7;
            if (3 < bVar2) {
              png_chunk_benign_error(param_1,"unrecognized equation type");
            }
            do {
              pbVar8 = pbVar3;
              pbVar3 = pbVar8 + 1;
            } while (*pbVar8 != 0);
            iVar6 = png_malloc_warn(param_1,uVar13 << 2);
            if (iVar6 != 0) {
              if (uVar13 != 0) {
                iVar11 = 0;
                do {
                  pbVar8 = pbVar8 + 1;
                  *(byte **)(iVar6 + iVar11 * 4) = pbVar8;
                  while( true ) {
                    if ((byte *)(param_3 + iVar5) < pbVar8) {
                      png_free(param_1,iVar6);
                      pcVar9 = "invalid data";
                      goto LAB_00026b5c;
                    }
                    if (*pbVar8 == 0) break;
                    pbVar8 = pbVar8 + 1;
                  }
                  iVar10 = iVar11 + 1;
                  if (SBORROW4(iVar10,iVar11)) {
                    // WARNING: Does not return
                    pcVar1 = (code *)software_udf(0xfe,0x26c1a);
                    (*pcVar1)();
                  }
                  iVar11 = iVar10;
                } while (iVar10 < (int)uVar13);
              }
              png_set_pCAL(param_1,param_2,iVar5,uVar4,uVar12,bVar2,uVar13,pbVar7,iVar6);
              png_free(param_1,iVar6);
              return;
            }
            pcVar9 = "out of memory";
          }
        }
      }
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar9 = "out of place";
  }
LAB_00026b5c:
  png_chunk_benign_error(param_1,pcVar9);
  return;
}



void png_handle_sCAL(int param_1,int param_2,uint param_3)

{
  char *pcVar1;
  int iVar2;
  char *pcVar3;
  uint uVar4;
  uint local_24;
  uint local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((*(uint *)(param_1 + 0x130) & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((*(uint *)(param_1 + 0x130) & 4) == 0) {
    if ((param_2 == 0) || ((*(byte *)(param_2 + 9) & 0x40) == 0)) {
      if (param_3 < 4) {
        png_crc_finish(param_1,param_3);
        pcVar3 = "invalid";
      }
      else {
        pcVar3 = (char *)FUN_000261fc(param_1,param_3 + 1,2);
        if (pcVar3 == (char *)0x0) {
          png_chunk_benign_error(param_1,"out of memory");
          png_crc_finish(param_1,param_3);
          goto LAB_00026d02;
        }
        png_crc_read(param_1,pcVar3,param_3);
        pcVar3[param_3] = '\0';
        iVar2 = png_crc_finish(param_1,0);
        if (iVar2 != 0) goto LAB_00026d02;
        if ((byte)(*pcVar3 - 1U) < 2) {
          local_20 = 1;
          local_24 = 0;
          iVar2 = png_check_fp_number(pcVar3,param_3,&local_24,&local_20);
          if (((iVar2 == 0) || (param_3 <= local_20)) ||
             (uVar4 = local_20 + 1, pcVar1 = pcVar3 + local_20, local_20 = uVar4, *pcVar1 != '\0'))
          {
            pcVar3 = "bad width format";
          }
          else if ((local_24 & 0x188) == 0x108) {
            local_24 = 0;
            iVar2 = png_check_fp_number(pcVar3,param_3,&local_24,&local_20);
            if ((iVar2 == 0) || (local_20 != param_3)) {
              pcVar3 = "bad height format";
            }
            else {
              if ((local_24 & 0x188) == 0x108) {
                png_set_sCAL_s(param_1,param_2,*pcVar3,pcVar3 + 1,pcVar3 + uVar4);
                goto LAB_00026d02;
              }
              pcVar3 = "non-positive height";
            }
          }
          else {
            pcVar3 = "non-positive width";
          }
        }
        else {
          pcVar3 = "invalid unit";
        }
      }
    }
    else {
      png_crc_finish(param_1,param_3);
      pcVar3 = "duplicate";
    }
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar3 = "out of place";
  }
  png_chunk_benign_error(param_1,pcVar3);
LAB_00026d02:
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_handle_tIME(int param_1,int param_2,int param_3)

{
  uint uVar1;
  int iVar2;
  char *pcVar3;
  bool bVar4;
  undefined1 local_24 [2];
  undefined1 local_22;
  undefined1 local_21;
  undefined1 local_20;
  undefined1 local_1f;
  undefined1 local_1e;
  undefined1 local_1b [2];
  undefined1 local_19;
  undefined1 local_18;
  undefined1 local_17;
  undefined1 local_16;
  undefined1 local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  uVar1 = *(uint *)(param_1 + 0x130);
  if ((uVar1 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  if ((param_2 == 0) || ((*(byte *)(param_2 + 9) & 2) == 0)) {
    bVar4 = (uVar1 & 4) != 0;
    if (bVar4) {
      uVar1 = uVar1 | 8;
    }
    if (bVar4) {
      *(uint *)(param_1 + 0x130) = uVar1;
    }
    if (param_3 == 7) {
      png_crc_read(param_1,local_1b,7);
      iVar2 = png_crc_finish(param_1,0);
      if (iVar2 == 0) {
        local_1e = local_15;
        local_1f = local_16;
        local_20 = local_17;
        local_21 = local_18;
        local_22 = local_19;
        png_set_tIME(param_1,param_2,local_24);
      }
      goto LAB_00026e7a;
    }
    png_crc_finish(param_1,param_3);
    pcVar3 = "invalid";
  }
  else {
    png_crc_finish(param_1,param_3);
    pcVar3 = "duplicate";
  }
  png_chunk_benign_error(param_1,pcVar3);
LAB_00026e7a:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void png_handle_tEXt(int param_1,undefined4 param_2,int param_3)

{
  int iVar1;
  uint uVar2;
  int iVar3;
  char *pcVar4;
  int iVar5;
  bool bVar6;
  undefined4 local_3c;
  int iStack_38;
  char *local_34;
  size_t local_30;
  undefined4 local_2c;
  undefined4 uStack_28;
  undefined4 local_24;
  int local_20;
  
  local_20 = __stack_chk_guard;
  iVar1 = *(int *)(param_1 + 0x334);
  if (iVar1 == 0) {
LAB_00026ef2:
    uVar2 = *(uint *)(param_1 + 0x130);
    if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
      png_chunk_error(param_1,"missing IHDR");
    }
    bVar6 = (uVar2 & 4) != 0;
    if (bVar6) {
      uVar2 = uVar2 | 8;
    }
    if (bVar6) {
      *(uint *)(param_1 + 0x130) = uVar2;
    }
    iVar1 = FUN_000261fc(param_1,param_3 + 1,1);
    if (iVar1 != 0) {
      png_crc_read(param_1,iVar1,param_3);
      iVar5 = 0;
      iVar3 = png_crc_finish(param_1,0);
      if (iVar3 == 0) {
        *(undefined1 *)(iVar1 + param_3) = 0;
        do {
          pcVar4 = (char *)(iVar1 + iVar5);
          iVar5 = iVar5 + 1;
        } while (*pcVar4 != '\0');
        local_3c = 0xffffffff;
        local_24 = 0;
        local_2c = 0;
        uStack_28 = 0;
        local_34 = (char *)(iVar1 + iVar5);
        if (param_3 + 1 == iVar5) {
          local_34 = local_34 + -1;
        }
        iStack_38 = iVar1;
        local_30 = strlen(local_34);
        png_set_text_2(param_1,param_2,&local_3c,1);
      }
      goto LAB_00026f78;
    }
    pcVar4 = "out of memory";
  }
  else {
    if (iVar1 == 1) {
      png_crc_finish(param_1,param_3);
      goto LAB_00026f78;
    }
    *(int *)(param_1 + 0x334) = iVar1 + -1;
    if (iVar1 + -1 != 1) goto LAB_00026ef2;
    png_crc_finish(param_1,param_3);
    pcVar4 = "no space in chunk cache";
  }
  png_chunk_benign_error(param_1,pcVar4);
LAB_00026f78:
  if (**(int **)(_FUN_00026fac + 0x26f80) != local_20) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



// WARNING: Removing unreachable block (ram,0x00026fee)
// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_00026fac(int param_1,undefined4 param_2,uint param_3)

{
  int iVar1;
  uint uVar2;
  int iVar3;
  char *pcVar4;
  int unaff_r4;
  int unaff_r6;
  int iVar5;
  char in_NG;
  bool bVar6;
  char in_OV;
  int in_stack_00000020;
  undefined4 uStack_3c;
  int iStack_38;
  int iStack_34;
  int iStack_30;
  undefined4 uStack_2c;
  undefined4 uStack_28;
  undefined4 uStack_24;
  int iStack_20;
  int iStack_1c;
  
  if (in_NG != in_OV) {
    if (param_1 == 1) {
      png_crc_finish();
    }
    else {
      uVar2 = *(uint *)(unaff_r4 + 0x130);
      if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
        png_chunk_error();
      }
      bVar6 = (uVar2 & 4) != 0;
      if (bVar6) {
        uVar2 = uVar2 | 8;
      }
      if (bVar6) {
        *(uint *)(unaff_r4 + 0x130) = uVar2;
      }
      iVar1 = FUN_000261fc();
      if (iVar1 != 0) {
        png_crc_read();
        iVar5 = 0;
        iVar3 = png_crc_finish();
        if (iVar3 == 0) {
          *(undefined1 *)(iVar1 + unaff_r6) = 0;
          do {
            pcVar4 = (char *)(iVar1 + iVar5);
            iVar5 = iVar5 + 1;
          } while (*pcVar4 != '\0');
          pcVar4 = (char *)(iVar1 + iVar5);
          if (unaff_r6 + 1 == iVar5) {
            pcVar4 = pcVar4 + -1;
          }
          strlen(pcVar4);
          png_set_text_2();
        }
        goto LAB_00026f78;
      }
    }
    png_chunk_benign_error();
LAB_00026f78:
    if (**(int **)(_FUN_00026fac + 0x26f80) != in_stack_00000020) {
                    // WARNING: Subroutine does not return
      __stack_chk_fail();
    }
    return;
  }
  iStack_1c = __stack_chk_guard;
  iVar1 = *(int *)(param_1 + 0x334);
  if (iVar1 != 0) {
    if (iVar1 == 1) {
      png_crc_finish();
      return;
    }
    *(int *)(param_1 + 0x334) = iVar1 + -1;
    if (iVar1 + -1 == 1) {
      png_crc_finish(param_1,param_3);
      iVar1 = __stack_chk_guard - iStack_1c;
      if (iVar1 == 0) {
        pcVar4 = "no space in chunk cache";
        goto LAB_00027082;
      }
      goto LAB_000270c4;
    }
  }
  uVar2 = *(uint *)(param_1 + 0x130);
  if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  bVar6 = (uVar2 & 4) != 0;
  if (bVar6) {
    uVar2 = uVar2 | 8;
  }
  if (bVar6) {
    *(uint *)(param_1 + 0x130) = uVar2;
  }
  iVar1 = FUN_000261fc(param_1,param_3,2);
  if (iVar1 == 0) {
    png_crc_finish(param_1,param_3);
    iVar1 = __stack_chk_guard - iStack_1c;
    if (iVar1 == 0) {
      pcVar4 = "out of memory";
LAB_00027082:
      png_chunk_benign_error(param_1,pcVar4);
      return;
    }
    goto LAB_000270c4;
  }
  png_crc_read(param_1,iVar1,param_3);
  iVar3 = png_crc_finish(param_1,0);
  if (iVar3 != 0) goto LAB_000270b0;
  if (param_3 == 0) {
    pcVar4 = "bad keyword";
LAB_000270aa:
    png_chunk_benign_error(param_1,pcVar4);
  }
  else {
    uVar2 = 0;
    do {
      if (*(char *)(iVar1 + uVar2) == '\0') break;
      uVar2 = uVar2 + 1;
    } while (uVar2 < param_3);
    if (0x4e < uVar2 - 1) {
      pcVar4 = "bad keyword";
      goto LAB_000270aa;
    }
    if (param_3 < uVar2 + 3) {
      pcVar4 = "truncated";
      goto LAB_000270aa;
    }
    if (*(char *)(uVar2 + iVar1 + 1) != '\0') {
      pcVar4 = "unknown compression type";
      goto LAB_000270aa;
    }
    iStack_20 = -1;
    iVar1 = FUN_0002715c(param_1,param_3,uVar2 + 2,&iStack_20);
    if (iVar1 == 1) {
      iStack_38 = *(int *)(param_1 + 0x354);
      *(undefined1 *)(iStack_38 + iStack_20 + uVar2 + 2) = 0;
      uStack_3c = 0;
      iStack_34 = iStack_38 + uVar2 + 2;
      iStack_30 = iStack_20;
      uStack_2c = 0;
      uStack_28 = 0;
      uStack_24 = 0;
      iVar1 = png_set_text_2(param_1,param_2,&uStack_3c,1);
      if (iVar1 != 0) {
        pcVar4 = "insufficient memory";
        goto LAB_000270aa;
      }
    }
    else {
      pcVar4 = *(char **)(param_1 + 0x158);
      if (pcVar4 != (char *)0x0) goto LAB_000270aa;
    }
  }
LAB_000270b0:
  iVar1 = __stack_chk_guard - iStack_1c;
  if (iVar1 == 0) {
    return;
  }
LAB_000270c4:
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iVar1,iStack_1c);
}



// WARNING: Removing unreachable block (ram,0x00026fee)

void png_handle_zTXt(int param_1,undefined4 param_2,uint param_3)

{
  int iVar1;
  uint uVar2;
  int iVar3;
  char *pcVar4;
  bool bVar5;
  undefined4 local_3c;
  int iStack_38;
  int local_34;
  int iStack_30;
  undefined4 local_2c;
  undefined4 uStack_28;
  undefined4 local_24;
  int local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  iVar1 = *(int *)(param_1 + 0x334);
  if (iVar1 != 0) {
    if (iVar1 == 1) {
      png_crc_finish();
      return;
    }
    *(int *)(param_1 + 0x334) = iVar1 + -1;
    if (iVar1 + -1 == 1) {
      png_crc_finish(param_1,param_3);
      iVar1 = __stack_chk_guard - local_1c;
      if (iVar1 == 0) {
        pcVar4 = "no space in chunk cache";
        goto LAB_00027082;
      }
      goto LAB_000270c4;
    }
  }
  uVar2 = *(uint *)(param_1 + 0x130);
  if ((uVar2 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  bVar5 = (uVar2 & 4) != 0;
  if (bVar5) {
    uVar2 = uVar2 | 8;
  }
  if (bVar5) {
    *(uint *)(param_1 + 0x130) = uVar2;
  }
  iVar1 = FUN_000261fc(param_1,param_3,2);
  if (iVar1 == 0) {
    png_crc_finish(param_1,param_3);
    iVar1 = __stack_chk_guard - local_1c;
    if (iVar1 == 0) {
      pcVar4 = "out of memory";
LAB_00027082:
      png_chunk_benign_error(param_1,pcVar4);
      return;
    }
    goto LAB_000270c4;
  }
  png_crc_read(param_1,iVar1,param_3);
  iVar3 = png_crc_finish(param_1,0);
  if (iVar3 != 0) goto LAB_000270b0;
  if (param_3 == 0) {
    pcVar4 = "bad keyword";
LAB_000270aa:
    png_chunk_benign_error(param_1,pcVar4);
  }
  else {
    uVar2 = 0;
    do {
      if (*(char *)(iVar1 + uVar2) == '\0') break;
      uVar2 = uVar2 + 1;
    } while (uVar2 < param_3);
    if (0x4e < uVar2 - 1) {
      pcVar4 = "bad keyword";
      goto LAB_000270aa;
    }
    if (param_3 < uVar2 + 3) {
      pcVar4 = "truncated";
      goto LAB_000270aa;
    }
    if (*(char *)(uVar2 + iVar1 + 1) != '\0') {
      pcVar4 = "unknown compression type";
      goto LAB_000270aa;
    }
    local_20 = -1;
    iVar1 = FUN_0002715c(param_1,param_3,uVar2 + 2,&local_20);
    if (iVar1 == 1) {
      iStack_38 = *(int *)(param_1 + 0x354);
      *(undefined1 *)(iStack_38 + local_20 + uVar2 + 2) = 0;
      local_3c = 0;
      local_34 = iStack_38 + uVar2 + 2;
      iStack_30 = local_20;
      local_2c = 0;
      uStack_28 = 0;
      local_24 = 0;
      iVar1 = png_set_text_2(param_1,param_2,&local_3c,1);
      if (iVar1 != 0) {
        pcVar4 = "insufficient memory";
        goto LAB_000270aa;
      }
    }
    else {
      pcVar4 = *(char **)(param_1 + 0x158);
      if (pcVar4 != (char *)0x0) goto LAB_000270aa;
    }
  }
LAB_000270b0:
  iVar1 = __stack_chk_guard - local_1c;
  if (iVar1 == 0) {
    return;
  }
LAB_000270c4:
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iVar1,local_1c);
}



void FUN_0002715c(int param_1,int param_2,int param_3,uint *param_4)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar1 = *(uint *)(param_1 + 0x338);
  if (uVar1 + 1 < 2) {
    uVar1 = 0xffffffff;
  }
  else if (uVar1 < param_3 + 1U) {
    png_zstream_error(param_1,0xfffffffc);
    goto LAB_00027206;
  }
  uVar1 = uVar1 - (param_3 + 1);
  if (uVar1 < *param_4) {
    *param_4 = uVar1;
  }
  iVar2 = FUN_0002607c(param_1,*(undefined4 *)(param_1 + 0x1d8));
  if ((iVar2 == 1) || (iVar2 != 0)) goto LAB_00027206;
  local_2c = param_2 - param_3;
  iVar2 = FUN_00028420(param_1,*(undefined4 *)(param_1 + 0x1d8),*(int *)(param_1 + 0x354) + param_3,
                       &local_2c,0,param_4);
  if ((iVar2 != 0) && (iVar2 == 1)) {
    iVar2 = inflateReset(param_1 + 0x140);
    if (iVar2 == 0) {
      uVar1 = *param_4;
      iVar6 = param_3 + uVar1;
      iVar5 = iVar6 + 1;
      iVar2 = png_malloc_base(param_1,iVar5);
      if (iVar2 == 0) {
        png_zstream_error(param_1,0xfffffffc);
      }
      else {
        iVar3 = FUN_00028420(param_1,*(undefined4 *)(param_1 + 0x1d8),
                             *(int *)(param_1 + 0x354) + param_3,&local_2c,iVar2 + param_3,param_4);
        if (iVar3 == 0) {
LAB_000272a0:
          iVar3 = -7;
        }
        else if (iVar3 == 1) {
          if (uVar1 != *param_4) goto LAB_000272a0;
          iVar4 = *(int *)(param_1 + 0x354);
          *(undefined1 *)(iVar2 + iVar6) = 0;
          if (param_3 != 0) {
            __aeabi_memcpy(iVar2,iVar4,param_3);
          }
          iVar3 = 1;
          *(int *)(param_1 + 0x354) = iVar2;
          *(int *)(param_1 + 0x358) = iVar5;
          iVar2 = iVar4;
        }
        png_free(param_1,iVar2);
        if ((iVar3 == 1) && (param_2 - param_3 != local_2c)) {
          png_chunk_benign_error(param_1,"extra compressed data");
        }
      }
    }
    else {
      png_zstream_error(param_1,1);
    }
  }
  *(undefined4 *)(param_1 + 0x13c) = 0;
LAB_00027206:
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



// WARNING: Removing unreachable block (ram,0x00027312)

void png_handle_iTXt(int param_1,undefined4 param_2,uint param_3)

{
  char cVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  uint uVar5;
  uint uVar6;
  char *pcVar7;
  bool bVar8;
  undefined4 local_48;
  int iStack_44;
  int local_40;
  undefined4 uStack_3c;
  int local_38;
  int local_34;
  int local_30;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar2 = *(int *)(param_1 + 0x334);
  if (iVar2 != 0) {
    if (iVar2 == 1) {
      png_crc_finish();
      return;
    }
    *(int *)(param_1 + 0x334) = iVar2 + -1;
    if (iVar2 + -1 == 1) {
      png_crc_finish(param_1,param_3);
      iVar2 = __stack_chk_guard - local_28;
      if (iVar2 == 0) {
        pcVar7 = "no space in chunk cache";
        goto LAB_000273b0;
      }
      goto LAB_000274c0;
    }
  }
  uVar3 = *(uint *)(param_1 + 0x130);
  if ((uVar3 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"missing IHDR");
  }
  bVar8 = (uVar3 & 4) != 0;
  if (bVar8) {
    uVar3 = uVar3 | 8;
  }
  if (bVar8) {
    *(uint *)(param_1 + 0x130) = uVar3;
  }
  iVar2 = FUN_000261fc(param_1,param_3 + 1,1);
  if (iVar2 == 0) {
    png_crc_finish(param_1,param_3);
    iVar2 = __stack_chk_guard - local_28;
    if (iVar2 == 0) {
      pcVar7 = "out of memory";
LAB_000273b0:
      png_chunk_benign_error(param_1,pcVar7);
      return;
    }
    goto LAB_000274c0;
  }
  png_crc_read(param_1,iVar2,param_3);
  iVar4 = png_crc_finish(param_1,0);
  if (iVar4 == 0) {
    if (param_3 == 0) {
      pcVar7 = "bad keyword";
    }
    else {
      uVar3 = 0;
      do {
        if (*(char *)(iVar2 + uVar3) == '\0') break;
        uVar3 = uVar3 + 1;
      } while (uVar3 < param_3);
      if (uVar3 - 1 < 0x4f) {
        if (param_3 < uVar3 + 5) {
          pcVar7 = "truncated";
        }
        else {
          cVar1 = *(char *)(uVar3 + iVar2 + 1);
          if (cVar1 == '\0') {
LAB_000273ea:
            local_2c = 0;
            for (uVar5 = uVar3 + 3; (uVar5 < param_3 && (*(char *)(iVar2 + uVar5) != '\0'));
                uVar5 = uVar5 + 1) {
            }
            for (uVar6 = uVar5 + 1; (uVar6 < param_3 && (*(char *)(iVar2 + uVar6) != '\0'));
                uVar6 = uVar6 + 1) {
            }
            uVar6 = uVar6 + 1;
            if ((cVar1 == '\0') && (uVar6 <= param_3)) {
              local_2c = param_3 - uVar6;
            }
            else {
              pcVar7 = "truncated";
              if ((cVar1 == '\0') || (param_3 <= uVar6)) goto LAB_000274a6;
              local_2c = -1;
              iVar4 = FUN_0002715c(param_1,param_3,uVar6,&local_2c);
              if (iVar4 == 1) {
                iVar2 = *(int *)(param_1 + 0x354);
              }
              else {
                pcVar7 = *(char **)(param_1 + 0x158);
                if (pcVar7 != (char *)0x0) goto LAB_000274a6;
              }
            }
            *(undefined1 *)(iVar2 + local_2c + uVar6) = 0;
            local_48 = 1;
            if (cVar1 != '\0') {
              local_48 = 2;
            }
            local_34 = iVar2 + uVar3 + 3;
            local_30 = iVar2 + uVar5 + 1;
            local_40 = iVar2 + uVar6;
            uStack_3c = 0;
            local_38 = local_2c;
            iStack_44 = iVar2;
            iVar2 = png_set_text_2(param_1,param_2,&local_48,1);
            if (iVar2 == 0) goto LAB_000274ac;
            pcVar7 = "insufficient memory";
          }
          else if (cVar1 == '\x01') {
            if (*(char *)(uVar3 + iVar2 + 2) == '\0') goto LAB_000273ea;
            pcVar7 = "bad compression info";
          }
          else {
            pcVar7 = "bad compression info";
          }
        }
      }
      else {
        pcVar7 = "bad keyword";
      }
    }
LAB_000274a6:
    png_chunk_benign_error(param_1,pcVar7);
  }
LAB_000274ac:
  iVar2 = __stack_chk_guard - local_28;
  if (iVar2 == 0) {
    return;
  }
LAB_000274c0:
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iVar2,local_28);
}



void png_handle_unknown(int param_1,undefined4 param_2,undefined4 param_3,int param_4)

{
  bool bVar1;
  int iVar2;
  
  if (*(int *)(param_1 + 0x2ec) == 0) {
    if (param_4 == 0) {
      param_4 = *(int *)(param_1 + 0x2f0);
    }
    if ((param_4 == 3) || ((param_4 == 2 && ((*(byte *)(param_1 + 0x1db) & 0x20) != 0)))) {
      iVar2 = FUN_00027618(param_1,param_3);
      if (iVar2 == 0) {
        param_4 = 1;
      }
    }
    else {
      png_crc_finish(param_1,param_3);
    }
LAB_00027588:
    if (param_4 == 3) {
LAB_0002759a:
      iVar2 = *(int *)(param_1 + 0x334);
      if (iVar2 == 0) {
LAB_000275c2:
        bVar1 = true;
        png_set_unknown_chunks(param_1,param_2,param_1 + 0x33c,1);
        goto LAB_000275d2;
      }
      if (iVar2 != 1) {
        if (iVar2 != 2) {
          *(int *)(param_1 + 0x334) = iVar2 + -1;
          goto LAB_000275c2;
        }
        *(undefined4 *)(param_1 + 0x334) = 1;
        png_chunk_benign_error(param_1,"no space in chunk cache");
      }
    }
    else if (param_4 == 2) goto LAB_00027590;
  }
  else {
    iVar2 = FUN_00027618(param_1,param_3);
    if (iVar2 != 0) {
      iVar2 = (**(code **)(param_1 + 0x2ec))(param_1,param_1 + 0x33c);
      if (iVar2 < 0) {
                    // WARNING: Subroutine does not return
        png_chunk_error(param_1,"error in user chunk");
      }
      if (iVar2 != 0) {
        bVar1 = true;
        goto LAB_000275d2;
      }
      if (1 < param_4) goto LAB_00027588;
      if (*(int *)(param_1 + 0x2f0) < 2) {
        png_app_warning(param_1,
                        "forcing save of an unhandled chunk; please call png_set_keep_unknown_chunks"
                       );
      }
LAB_00027590:
      if ((*(byte *)(param_1 + 0x1db) & 0x20) != 0) goto LAB_0002759a;
    }
  }
  bVar1 = false;
LAB_000275d2:
  if (*(int *)(param_1 + 0x344) != 0) {
    png_free(param_1);
  }
  *(undefined4 *)(param_1 + 0x344) = 0;
  if ((!bVar1) && ((*(byte *)(param_1 + 0x1db) & 0x20) == 0)) {
                    // WARNING: Subroutine does not return
    png_chunk_error(param_1,"unhandled critical chunk");
  }
  return;
}



undefined4 FUN_00027618(int param_1,uint param_2)

{
  undefined4 uVar1;
  int iVar2;
  
  if (*(int *)(param_1 + 0x344) != 0) {
    png_free(param_1);
    *(undefined4 *)(param_1 + 0x344) = 0;
  }
  if ((*(uint *)(param_1 + 0x338) + 1 < 2) || (param_2 <= *(uint *)(param_1 + 0x338))) {
    uVar1 = *(undefined4 *)(param_1 + 0x1d8);
    *(char *)(param_1 + 0x33c) = (char)((uint)uVar1 >> 0x18);
    *(char *)(param_1 + 0x33d) = (char)((uint)uVar1 >> 0x10);
    *(char *)(param_1 + 0x33e) = (char)((uint)uVar1 >> 8);
    *(char *)(param_1 + 0x33f) = (char)uVar1;
    *(undefined1 *)(param_1 + 0x340) = 0;
    *(uint *)(param_1 + 0x348) = param_2;
    *(char *)(param_1 + 0x34c) = (char)*(undefined4 *)(param_1 + 0x130);
    if (param_2 == 0) {
      *(undefined4 *)(param_1 + 0x344) = 0;
      goto LAB_000276b2;
    }
    iVar2 = png_malloc_warn(param_1,param_2);
    *(int *)(param_1 + 0x344) = iVar2;
  }
  else {
    iVar2 = 0;
  }
  if ((param_2 != 0) && (iVar2 == 0)) {
    png_crc_finish(param_1,param_2);
    png_chunk_benign_error(param_1,"unknown chunk exceeds memory limits");
    return 0;
  }
  if (param_2 != 0) {
    png_crc_read(param_1,iVar2,param_2);
  }
LAB_000276b2:
  png_crc_finish(param_1,0);
  return 1;
}



void png_combine_row(int param_1,byte *param_2,int param_3)

{
  byte bVar1;
  byte *pbVar2;
  int iVar3;
  uint *puVar4;
  byte bVar5;
  uint uVar6;
  uint uVar7;
  int iVar8;
  byte bVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  byte *pbVar13;
  uint uVar14;
  int iVar15;
  
  bVar5 = *(byte *)(param_1 + 0x213);
  uVar11 = (uint)bVar5;
  if (uVar11 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"internal row logic error");
  }
  uVar12 = *(uint *)(param_1 + 0x1bc);
  iVar15 = *(int *)(param_1 + 0x1e0);
  uVar14 = (uint)*(byte *)(param_1 + 0x209);
  if (*(uint *)(param_1 + 0x1ec) != 0) {
    if (uVar11 < 8) {
      uVar6 = uVar12 * uVar11 + 7 >> 3;
    }
    else {
      uVar6 = uVar12 * (bVar5 >> 3);
    }
    if (*(uint *)(param_1 + 0x1ec) != uVar6) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"internal row size calculation error");
    }
  }
  if (uVar12 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"internal row width error");
  }
  uVar6 = uVar12 * uVar11;
  pbVar13 = (byte *)(iVar15 + 1);
  uVar7 = uVar6 & 7;
  if (uVar7 == 0) {
    bVar9 = 0;
    bVar1 = 0;
    pbVar2 = (byte *)0x0;
  }
  else {
    uVar10 = uVar6 + 7 >> 3;
    if (7 < uVar11) {
      uVar10 = uVar12 * (bVar5 >> 3);
    }
    pbVar2 = param_2 + (uVar10 - 1);
    bVar1 = *pbVar2;
    if ((*(byte *)(param_1 + 0x13a) & 1) == 0) {
      bVar9 = (byte)(0xff >> uVar7);
    }
    else {
      bVar9 = (byte)(0xff << uVar7);
    }
  }
  if (((*(char *)(param_1 + 0x208) == '\0') || (5 < uVar14)) ||
     (uVar7 = *(uint *)(param_1 + 0x138), (uVar7 & 2) == 0)) {
LAB_00027780:
    uVar14 = uVar6 + 7 >> 3;
    if (7 < uVar11) {
      uVar14 = uVar12 * (bVar5 >> 3);
    }
    __aeabi_memcpy(param_2,pbVar13,uVar14);
  }
  else {
    if (param_3 == 1) {
      if ((*(byte *)(param_1 + 0x209) & 1) == 0) goto LAB_00027780;
    }
    else if (param_3 != 0) goto LAB_00027780;
    uVar6 = (uVar14 & 1) << (3 - (uVar14 + 1 >> 1) & 0xff) & 7;
    if (uVar12 <= uVar6) {
      return;
    }
    if (7 < uVar11) {
      if ((bVar5 & 7) != 0) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"invalid user transform pixel depth");
      }
      uVar7 = (uint)(bVar5 >> 3);
      pbVar13 = pbVar13 + uVar6 * uVar7;
      pbVar2 = param_2 + uVar6 * uVar7;
      uVar12 = uVar12 * uVar7 - uVar6 * uVar7;
      uVar11 = uVar7;
      if ((param_3 != 0) && (uVar11 = uVar7 << (6 - uVar14 >> 1 & 0xff), uVar12 < uVar11)) {
        uVar11 = uVar12;
      }
      uVar14 = uVar7 << (7 - uVar14 >> 1 & 0xff);
      if (uVar11 == 1) {
        *pbVar2 = *pbVar13;
        if (uVar12 <= uVar14) {
          return;
        }
        iVar3 = uVar7 * uVar6 + uVar14;
        iVar8 = 0;
        do {
          uVar12 = uVar12 - uVar14;
          param_2[iVar8 + iVar3] = *(byte *)(iVar3 + iVar15 + 1 + iVar8);
          iVar8 = iVar8 + uVar14;
        } while (uVar14 < uVar12);
        return;
      }
      if (uVar11 == 3) {
        *pbVar2 = *pbVar13;
        pbVar2[1] = pbVar13[1];
        pbVar2[2] = pbVar13[2];
        if (uVar12 <= uVar14) {
          return;
        }
        uVar11 = uVar14;
        do {
          iVar8 = uVar7 * uVar6 + iVar15 + uVar11;
          iVar3 = uVar11 + uVar7 * uVar6;
          uVar12 = uVar12 - uVar14;
          param_2[uVar11 + uVar7 * uVar6] = *(byte *)(iVar8 + 1);
          uVar11 = uVar11 + uVar14;
          param_2[iVar3 + 1] = *(byte *)(iVar8 + 2);
          param_2[iVar3 + 2] = *(byte *)(iVar8 + 3);
        } while (uVar14 < uVar12);
        return;
      }
      if (uVar11 == 2) {
        iVar3 = uVar7 * uVar6;
        do {
          param_2[iVar3] = *(byte *)(iVar15 + iVar3 + 1);
          param_2[iVar3 + 1] = *(byte *)(iVar15 + iVar3 + 2);
          if (uVar12 <= uVar14) {
            return;
          }
          uVar12 = uVar12 - uVar14;
          iVar3 = iVar3 + uVar14;
        } while (1 < uVar12);
        param_2[iVar3] = *(byte *)(iVar15 + iVar3 + 1);
        return;
      }
      if (((uVar11 < 0x10) && (((uint)pbVar2 & 1) == 0)) &&
         ((((uint)pbVar13 | uVar14 | uVar11) & 1) == 0)) {
        if ((((uint)pbVar13 | uVar14 | (uint)pbVar2 | uVar11) & 3) == 0) {
          uVar6 = uVar14 - uVar11 & 0xfffffffc;
          while( true ) {
            uVar7 = 0;
            do {
              *(undefined4 *)(pbVar2 + uVar7) = *(undefined4 *)(pbVar13 + uVar7);
              uVar7 = uVar7 + 4;
            } while (uVar11 != uVar7);
            if (uVar12 <= uVar14) break;
            uVar12 = uVar12 - uVar14;
            pbVar13 = pbVar13 + uVar7 + uVar6;
            pbVar2 = pbVar2 + uVar7 + uVar6;
            if (uVar12 < uVar11) {
              uVar11 = 0;
              do {
                pbVar2[uVar11] = pbVar13[uVar11];
                uVar11 = uVar11 + 1;
              } while (uVar11 != uVar12);
              return;
            }
          }
          return;
        }
        uVar6 = uVar14 - uVar11 & 0xfffffffe;
        while( true ) {
          uVar7 = 0;
          do {
            *(undefined2 *)(pbVar2 + uVar7) = *(undefined2 *)(pbVar13 + uVar7);
            uVar7 = uVar7 + 2;
          } while (uVar11 != uVar7);
          if (uVar12 <= uVar14) break;
          uVar12 = uVar12 - uVar14;
          pbVar13 = pbVar13 + uVar7 + uVar6;
          pbVar2 = pbVar2 + uVar7 + uVar6;
          if (uVar12 < uVar11) {
            uVar11 = 0;
            do {
              pbVar2[uVar11] = pbVar13[uVar11];
              uVar11 = uVar11 + 1;
            } while (uVar11 != uVar12);
            return;
          }
        }
        return;
      }
      __aeabi_memcpy(pbVar2,pbVar13,uVar11);
      if (uVar12 <= uVar14) {
        return;
      }
      iVar3 = uVar7 * uVar6 + uVar14;
      iVar8 = 0;
      do {
        if (uVar12 - uVar14 < uVar11) {
          uVar11 = uVar12 - uVar14;
        }
        __aeabi_memcpy(param_2 + iVar8 + iVar3,iVar3 + iVar15 + 1 + iVar8,uVar11);
        uVar12 = uVar12 - uVar14;
        iVar8 = iVar8 + uVar14;
      } while (uVar14 < uVar12);
      return;
    }
    uVar6 = __aeabi_uidiv(8,uVar11);
    if ((uVar7 & 0x10000) == 0) {
      if (param_3 == 0) {
        iVar15 = 2;
        if (uVar11 == 2) {
          iVar15 = 1;
        }
        if (uVar11 == 1) {
          iVar15 = 0;
        }
        puVar4 = (uint *)(&UNK_0003333c + iVar15 * 0x18 + uVar14 * 4);
      }
      else {
        iVar15 = 2;
        if (uVar11 == 2) {
          iVar15 = 1;
        }
        if (uVar11 == 1) {
          iVar15 = 0;
        }
        puVar4 = (uint *)(&UNK_000333a8 + iVar15 * 0xc + (uVar14 & 0xfe) * 2);
      }
    }
    else if (param_3 == 0) {
      iVar15 = 2;
      if (uVar11 == 2) {
        iVar15 = 1;
      }
      if (uVar11 == 1) {
        iVar15 = 0;
      }
      puVar4 = (uint *)(&UNK_000332f4 + uVar14 * 4 + iVar15 * 0x18);
    }
    else {
      iVar15 = 2;
      if (uVar11 == 2) {
        iVar15 = 1;
      }
      if (uVar11 == 1) {
        iVar15 = 0;
      }
      puVar4 = (uint *)(&UNK_00033384 + (uVar14 & 0xfe) * 2 + iVar15 * 0xc);
    }
    uVar11 = *puVar4;
    while( true ) {
      if ((uVar11 & 0xff) != 0) {
        if ((uVar11 & 0xff) == 0xff) {
          bVar5 = *pbVar13;
        }
        else {
          bVar5 = *param_2 & ~(byte)uVar11 | *pbVar13 & (byte)uVar11;
        }
        *param_2 = bVar5;
      }
      if (uVar12 <= uVar6) break;
      uVar11 = uVar11 >> 8 | uVar11 << 0x18;
      param_2 = param_2 + 1;
      pbVar13 = pbVar13 + 1;
      uVar12 = uVar12 - uVar6;
    }
  }
  if (pbVar2 != (byte *)0x0) {
    *pbVar2 = *pbVar2 & ~bVar9 | bVar1 & bVar9;
  }
  return;
}



void png_do_read_interlace(uint *param_1,int param_2,int param_3,uint param_4)

{
  code *pcVar1;
  byte bVar2;
  uint uVar3;
  int iVar4;
  uint uVar5;
  byte *pbVar6;
  uint uVar7;
  int iVar8;
  uint uVar9;
  byte *pbVar10;
  int iVar11;
  int iVar12;
  uint uVar13;
  uint uVar14;
  uint uVar15;
  byte *local_38;
  undefined1 auStack_30 [8];
  int local_28;
  
  local_28 = __stack_chk_guard;
  if ((param_1 != (uint *)0x0) && (param_2 != 0)) {
    uVar13 = *param_1;
    bVar2 = *(byte *)((int)param_1 + 0xb);
    iVar8 = *(int *)(&DAT_000333cc + param_3 * 4);
    uVar9 = iVar8 * uVar13;
    if (bVar2 == 4) {
      if (uVar13 != 0) {
        param_4 = param_4 & 0x10000;
        uVar5 = param_4 >> 0xe ^ 4;
        iVar12 = (param_4 >> 0xd ^ 8) - 4;
        uVar3 = 0;
        local_38 = (byte *)(param_2 + (uVar13 - 1 >> 1));
        pbVar6 = (byte *)(param_2 + (uVar9 - 1 >> 1));
        uVar7 = (uVar9 & 1 ^ param_4 >> 0x10) << 2;
        uVar13 = (uVar13 & 1 ^ param_4 >> 0x10) << 2;
        do {
          bVar2 = *local_38;
          iVar4 = 0;
          uVar15 = uVar7;
          do {
            if (SBORROW4(4,uVar15)) goto LAB_00027e58;
            *pbVar6 = (byte)(0xf0f >> (4 - uVar15 & 0xff)) & *pbVar6 |
                      (byte)((bVar2 >> (uVar13 & 0xff) & 0xf) << (uVar15 & 0xff));
            if (uVar15 == uVar5) {
              pbVar6 = pbVar6 + -1;
              uVar7 = param_4 >> 0xe;
            }
            else {
              uVar7 = uVar15 + iVar12;
              if (SBORROW4(uVar7,uVar15)) goto LAB_00027e58;
            }
            iVar11 = iVar4 + 1;
            if (SBORROW4(iVar11,iVar4)) goto LAB_00027e58;
            iVar4 = iVar11;
            uVar15 = uVar7;
          } while (iVar11 < iVar8);
          if (uVar13 == uVar5) {
            local_38 = local_38 + -1;
            uVar15 = param_4 >> 0xe;
          }
          else {
            uVar15 = uVar13 + iVar12;
            if (SBORROW4(uVar15,uVar13)) goto LAB_00027e58;
          }
          uVar3 = uVar3 + 1;
          uVar13 = uVar15;
        } while (uVar3 < *param_1);
      }
    }
    else if (bVar2 == 2) {
      uVar7 = uVar13 + 3 & 3;
      if ((param_4 & 0x10000) == 0) {
        uVar3 = 6;
        uVar7 = uVar7 << 1 ^ 6;
        uVar5 = ~(uVar9 * 2 + 6);
        iVar12 = 2;
        uVar15 = 0;
      }
      else {
        uVar15 = 6;
        uVar5 = uVar9 * 2 + 6;
        uVar7 = uVar7 << 1;
        iVar12 = -2;
        uVar3 = 0;
      }
      uVar5 = uVar5 & 6;
      if (uVar13 != 0) {
        uVar14 = 0;
        pbVar6 = (byte *)(param_2 + (uVar13 - 1 >> 2));
        pbVar10 = (byte *)(param_2 + (uVar9 - 1 >> 2));
        do {
          bVar2 = *pbVar6;
          iVar4 = 0;
          uVar13 = uVar5;
          do {
            if (SBORROW4(6,uVar13)) goto LAB_00027e58;
            *pbVar10 = (byte)(0x3f3f >> (6 - uVar13 & 0xff)) & *pbVar10 |
                       (byte)((bVar2 >> (uVar7 & 0xff) & 3) << (uVar13 & 0xff));
            if (uVar13 == uVar3) {
              pbVar10 = pbVar10 + -1;
              uVar5 = uVar15;
            }
            else {
              uVar5 = uVar13 + iVar12;
              if (SBORROW4(uVar5,uVar13)) goto LAB_00027e58;
            }
            iVar11 = iVar4 + 1;
            if (SBORROW4(iVar11,iVar4)) goto LAB_00027e58;
            iVar4 = iVar11;
            uVar13 = uVar5;
          } while (iVar11 < iVar8);
          if (uVar7 == uVar3) {
            pbVar6 = pbVar6 + -1;
            uVar13 = uVar15;
          }
          else {
            uVar13 = uVar7 + iVar12;
            if (SBORROW4(uVar13,uVar7)) goto LAB_00027e58;
          }
          uVar14 = uVar14 + 1;
          uVar7 = uVar13;
        } while (uVar14 < *param_1);
      }
    }
    else if (bVar2 == 1) {
      uVar7 = uVar13 + 7 & 7;
      if ((param_4 & 0x10000) == 0) {
        uVar3 = 7;
        uVar5 = ~(uVar9 + 7);
        uVar7 = uVar7 ^ 7;
        uVar15 = 0;
        iVar12 = 1;
      }
      else {
        uVar5 = uVar9 + 7;
        uVar15 = 7;
        uVar3 = 0;
        iVar12 = -1;
      }
      uVar5 = uVar5 & 7;
      if (uVar13 != 0) {
        uVar14 = 0;
        pbVar10 = (byte *)(param_2 + (uVar13 - 1 >> 3));
        pbVar6 = (byte *)(param_2 + (uVar9 - 1 >> 3));
        do {
          bVar2 = *pbVar10;
          iVar4 = 0;
          uVar13 = uVar5;
          do {
            if (SBORROW4(7,uVar13)) goto LAB_00027e58;
            *pbVar6 = (byte)(0x7f7f >> (7 - uVar13 & 0xff)) & *pbVar6 |
                      (byte)((bVar2 >> (uVar7 & 0xff) & 1) << (uVar13 & 0xff));
            if (uVar13 == uVar3) {
              pbVar6 = pbVar6 + -1;
              uVar5 = uVar15;
            }
            else {
              uVar5 = uVar13 + iVar12;
              if (SBORROW4(uVar5,uVar13)) goto LAB_00027e58;
            }
            iVar11 = iVar4 + 1;
            if (SBORROW4(iVar11,iVar4)) goto LAB_00027e58;
            iVar4 = iVar11;
            uVar13 = uVar5;
          } while (iVar11 < iVar8);
          if (uVar7 == uVar3) {
            pbVar10 = pbVar10 + -1;
            uVar13 = uVar15;
          }
          else {
            uVar13 = uVar7 + iVar12;
            if (SBORROW4(uVar13,uVar7)) {
LAB_00027e58:
                    // WARNING: Does not return
              pcVar1 = (code *)software_udf(0xfe,0x27e58);
              (*pcVar1)();
            }
          }
          uVar14 = uVar14 + 1;
          uVar7 = uVar13;
        } while (uVar14 < *param_1);
      }
    }
    else if (uVar13 != 0) {
      uVar7 = (uint)(bVar2 >> 3);
      iVar12 = uVar7 * (uVar13 - 1) + param_2;
      uVar13 = 0;
      param_2 = uVar7 * (uVar9 - 1) + param_2;
      do {
        __aeabi_memcpy(auStack_30,iVar12,uVar7);
        iVar4 = 0;
        do {
          __aeabi_memcpy(param_2,auStack_30,uVar7);
          iVar11 = iVar4 + 1;
          if (SBORROW4(iVar11,iVar4)) goto LAB_00027e58;
          param_2 = param_2 + -uVar7;
          iVar4 = iVar11;
        } while (iVar11 < iVar8);
        iVar12 = iVar12 + -uVar7;
        uVar13 = uVar13 + 1;
      } while (uVar13 < *param_1);
    }
    *param_1 = uVar9;
    bVar2 = *(byte *)((int)param_1 + 0xb);
    if (bVar2 < 8) {
      uVar9 = uVar9 * bVar2 + 7 >> 3;
    }
    else {
      uVar9 = uVar9 * (bVar2 >> 3);
    }
    param_1[1] = uVar9;
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_read_filter_row(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                        int param_5)

{
  code *pcVar1;
  undefined *puVar2;
  
  if (3 < param_5 - 1U) {
    return;
  }
  if (*(int *)(param_1 + 0x368) == 0) {
    puVar2 = &UNK_000285c9;
    if ((*(byte *)(param_1 + 0x20e) + 7 & 0x1f8) != 8) {
      puVar2 = &UNK_0002861f;
    }
    *(undefined1 **)(param_1 + 0x368) = &LAB_00028528_1;
    *(undefined1 **)(param_1 + 0x36c) = &LAB_00028550_1;
    *(undefined1 **)(param_1 + 0x370) = &LAB_00028568_1;
    *(undefined **)(param_1 + 0x374) = puVar2;
  }
  if (SBORROW4(param_5,1)) {
                    // WARNING: Does not return
    pcVar1 = (code *)software_udf(0xfe,0x27ed4);
    (*pcVar1)();
  }
                    // WARNING: Could not recover jumptable at 0x00027ed2. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(param_1 + (param_5 - 1U) * 4 + 0x368))(param_2,param_3,param_4);
  return;
}



void png_read_IDAT_data(int param_1,int param_2,int param_3)

{
  uint uVar1;
  undefined4 uVar2;
  int iVar3;
  int iVar4;
  char *pcVar5;
  uint uVar6;
  undefined1 auStack_428 [1024];
  int local_28;
  
  local_28 = __stack_chk_guard;
  *(int *)(param_1 + 0x14c) = param_2;
  *(undefined4 *)(param_1 + 0x150) = 0;
  if (param_2 == 0) {
    param_3 = 0;
  }
  while( true ) {
    if (*(int *)(param_1 + 0x144) == 0) {
      uVar1 = *(uint *)(param_1 + 0x1f0);
      while (uVar1 == 0) {
        png_crc_finish(param_1,0);
        uVar1 = png_read_chunk_header(param_1);
        *(uint *)(param_1 + 0x1f0) = uVar1;
        if (*(int *)(param_1 + 0x1d8) != 0x49444154) {
                    // WARNING: Subroutine does not return
          png_error(param_1,"Not enough image data");
        }
      }
      uVar6 = *(uint *)(param_1 + 0x35c);
      if (uVar1 < *(uint *)(param_1 + 0x35c)) {
        uVar6 = uVar1;
      }
      uVar2 = FUN_000261fc(param_1,uVar6,0);
      png_crc_read(param_1,uVar2,uVar6);
      *(uint *)(param_1 + 0x1f0) = *(int *)(param_1 + 0x1f0) - uVar6;
      *(undefined4 *)(param_1 + 0x140) = uVar2;
      *(uint *)(param_1 + 0x144) = uVar6;
    }
    if (param_2 == 0) {
      *(undefined1 **)(param_1 + 0x14c) = auStack_428;
      iVar3 = 0x400;
    }
    else {
      iVar3 = param_3;
      param_3 = 0;
    }
    *(int *)(param_1 + 0x150) = iVar3;
    iVar3 = inflate(param_1 + 0x140,0);
    iVar4 = *(int *)(param_1 + 0x150);
    *(undefined4 *)(param_1 + 0x150) = 0;
    if (param_2 == 0) {
      iVar4 = 0x400 - iVar4;
    }
    param_3 = iVar4 + param_3;
    if (iVar3 != 0) break;
    if (param_3 == 0) {
LAB_0002801c:
      if (__stack_chk_guard == local_28) {
        return;
      }
                    // WARNING: Subroutine does not return
      __stack_chk_fail();
    }
  }
  if (iVar3 == 1) {
    *(undefined4 *)(param_1 + 0x14c) = 0;
    *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 8;
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 8;
    if ((*(int *)(param_1 + 0x144) != 0) || (*(int *)(param_1 + 0x1f0) != 0)) {
      png_chunk_benign_error(param_1,"Extra compressed data");
    }
    if (param_3 == 0) goto LAB_0002801c;
    if (param_2 != 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Not enough image data");
    }
    pcVar5 = "Too much image data";
  }
  else {
    png_zstream_error(param_1);
    pcVar5 = *(char **)(param_1 + 0x158);
    if (param_2 != 0) {
                    // WARNING: Subroutine does not return
      png_chunk_error(param_1,pcVar5);
    }
  }
  png_chunk_benign_error(param_1,pcVar5);
  goto LAB_0002801c;
}



void png_read_finish_IDAT(int param_1)

{
  if ((*(byte *)(param_1 + 0x134) & 8) == 0) {
    png_read_IDAT_data(param_1,0,0);
    *(undefined4 *)(param_1 + 0x14c) = 0;
    if ((*(uint *)(param_1 + 0x134) & 8) == 0) {
      *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 8;
      *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 8;
    }
  }
  if (*(int *)(param_1 + 0x13c) != 0x49444154) {
    return;
  }
  *(undefined4 *)(param_1 + 0x13c) = 0;
  *(undefined4 *)(param_1 + 0x140) = 0;
  *(undefined4 *)(param_1 + 0x144) = 0;
  png_crc_finish(param_1,*(undefined4 *)(param_1 + 0x1f0));
  return;
}



void png_read_finish_row(int param_1)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  byte bVar6;
  
  uVar1 = *(int *)(param_1 + 0x1d4) + 1;
  *(uint *)(param_1 + 0x1d4) = uVar1;
  if (uVar1 < *(uint *)(param_1 + 0x1c4)) {
    return;
  }
  if (*(char *)(param_1 + 0x208) != '\0') {
    *(undefined4 *)(param_1 + 0x1d4) = 0;
    __aeabi_memclr(*(undefined4 *)(param_1 + 0x1dc),*(int *)(param_1 + 0x1cc) + 1);
    bVar6 = *(char *)(param_1 + 0x209) + 1;
    *(byte *)(param_1 + 0x209) = bVar6;
    uVar1 = (uint)bVar6;
    if (uVar1 < 7) {
      uVar4 = *(uint *)(param_1 + 0x138);
      iVar5 = *(int *)(param_1 + 0x1bc);
      do {
        iVar2 = __aeabi_uidiv((iVar5 + -1 + (uint)(byte)(&DAT_000333fd)[uVar1]) -
                              (uint)(byte)(&DAT_000333f6)[uVar1]);
        if ((uVar4 & 2) != 0) {
LAB_0002818c:
          *(int *)(param_1 + 0x1d0) = iVar2;
          return;
        }
        iVar3 = __aeabi_uidiv((*(int *)(param_1 + 0x1c0) + (uint)(byte)(&DAT_000333ef)[bVar6] + -1)
                              - (uint)(byte)(&DAT_000333e8)[bVar6]);
        *(int *)(param_1 + 0x1c4) = iVar3;
        if ((iVar3 != 0) && (iVar2 != 0)) goto LAB_0002818c;
        bVar6 = bVar6 + 1;
        *(byte *)(param_1 + 0x209) = bVar6;
        uVar1 = (uint)bVar6;
      } while (uVar1 < 7);
      *(int *)(param_1 + 0x1d0) = iVar2;
    }
  }
  png_read_finish_IDAT(param_1);
  return;
}



void png_read_start_row(int param_1)

{
  bool bVar1;
  code *pcVar2;
  uint uVar3;
  undefined4 uVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  int iVar8;
  uint uVar9;
  
  png_init_read_transformations();
  uVar7 = *(uint *)(param_1 + 0x208);
  uVar3 = (uVar7 << 0x10) >> 0x18;
  if ((uVar7 & 0xff) == 0) {
    *(undefined4 *)(param_1 + 0x1c4) = *(undefined4 *)(param_1 + 0x1c0);
    iVar8 = *(int *)(param_1 + 0x1bc);
    *(int *)(param_1 + 0x1d0) = iVar8;
    uVar9 = *(uint *)(param_1 + 0x138);
  }
  else {
    uVar5 = *(uint *)(param_1 + 0x1c0);
    uVar9 = *(uint *)(param_1 + 0x138);
    if ((uVar9 & 2) == 0) {
      uVar5 = uVar5 + 7 >> 3;
    }
    *(uint *)(param_1 + 0x1c4) = uVar5;
    iVar8 = *(int *)(param_1 + 0x1bc);
    uVar4 = __aeabi_uidiv((iVar8 + (uint)(byte)(&DAT_000333fd)[uVar3] + -1) -
                          (uint)(byte)(&DAT_000333f6)[uVar3]);
    *(undefined4 *)(param_1 + 0x1d0) = uVar4;
  }
  uVar3 = (uint)*(byte *)(param_1 + 0x20e);
  uVar7 = uVar7 >> 0x18;
  if (((uVar9 & 4) != 0) && (*(byte *)(param_1 + 0x20c) < 8)) {
    uVar3 = 8;
  }
  uVar9 = *(uint *)(param_1 + 0x138);
  if ((uVar9 & 0x1000) != 0) {
    if (uVar7 == 0) {
      uVar5 = (uint)*(ushort *)(param_1 + 0x204);
      if (uVar3 < 8) {
        uVar3 = 8;
      }
      if (uVar5 != 0) {
        uVar5 = 1;
      }
      uVar3 = uVar3 << (uVar5 & 0xff);
    }
    else if (uVar7 == 2) {
      if (*(short *)(param_1 + 0x204) != 0) {
        uVar3 = (uVar3 << 2) / 3;
      }
    }
    else if ((uVar7 == 3) && (uVar3 = 0x20, *(short *)(param_1 + 0x204) == 0)) {
      uVar3 = 0x18;
    }
  }
  uVar5 = uVar3;
  if ((uVar9 & 0x200) != 0) {
    if ((uVar9 & 0x1000) == 0) {
      uVar9 = uVar9 & 0xfffffdff;
      *(uint *)(param_1 + 0x138) = uVar9;
    }
    else if ((*(byte *)(param_1 + 0x20c) < 0x10) && (uVar5 = uVar3 * 2, SBORROW4(uVar5,uVar3)))
    goto LAB_000283fe;
  }
  uVar3 = uVar9 & 0x8000;
  uVar6 = uVar5;
  if (uVar3 != 0) {
    if (uVar7 - 2 < 2) {
      uVar6 = 0x40;
      if ((int)uVar5 < 0x21) {
        uVar6 = 0x20;
      }
    }
    else if ((uVar7 == 0) && (uVar6 = 0x20, (int)uVar5 < 9)) {
      uVar6 = 0x10;
    }
  }
  if ((uVar9 & 0x4000) != 0) {
    uVar5 = (uint)*(ushort *)(param_1 + 0x204);
    if (uVar5 != 0) {
      uVar5 = 1;
    }
    if (uVar3 != 0) {
      uVar3 = 1;
    }
    if (uVar7 != 4) {
      uVar3 = uVar3 | uVar5 & uVar9 >> 0xc;
    }
    if (uVar7 != 4 && uVar3 != 1) {
      if ((int)uVar6 < 9) {
        uVar6 = 0x18;
        if (uVar7 == 6) {
          uVar6 = 0x20;
        }
      }
      else {
        uVar6 = 0x30;
        if (uVar7 == 6) {
          uVar6 = 0x40;
        }
      }
    }
    else {
      bVar1 = (int)uVar6 < 0x11;
      uVar6 = 0x40;
      if (bVar1) {
        uVar6 = 0x20;
      }
    }
  }
  if (((uVar9 & 0x100000) != 0) &&
     (uVar3 = (uint)(byte)*(ushort *)(param_1 + 300) * (uint)(*(ushort *)(param_1 + 300) >> 8),
     uVar3 - uVar6 != 0 && (int)uVar6 <= (int)uVar3)) {
    uVar6 = uVar3;
  }
  *(char *)(param_1 + 0x212) = (char)uVar6;
  *(undefined1 *)(param_1 + 0x213) = 0;
  if (!SBORROW4(uVar6 + 7,uVar6)) {
    uVar3 = iVar8 + 7U & 0xfffffff8;
    uVar7 = uVar3 * uVar6 >> 3;
    if (7 < (int)uVar6) {
      uVar7 = uVar3 * (uVar6 >> 3);
    }
    uVar3 = uVar7 + ((int)(uVar6 + 7) >> 3) + 0x31;
    if (*(uint *)(param_1 + 0x350) < uVar3) {
      png_free(param_1,*(undefined4 *)(param_1 + 0x318));
      png_free(param_1,*(undefined4 *)(param_1 + 0x364));
      if (*(char *)(param_1 + 0x208) == '\0') {
        uVar4 = png_malloc(param_1,uVar3);
      }
      else {
        uVar4 = png_calloc(param_1,uVar3);
      }
      *(undefined4 *)(param_1 + 0x318) = uVar4;
      iVar8 = png_malloc(param_1,uVar3);
      *(int *)(param_1 + 0x364) = iVar8;
      uVar7 = *(int *)(param_1 + 0x318) + 0x20;
      *(uint *)(param_1 + 0x1e0) = (uVar7 - (uVar7 & 0xf)) + -1;
      *(uint *)(param_1 + 0x1dc) = ((iVar8 + 0x20U) - (iVar8 + 0x20U & 0xf)) + -1;
      *(uint *)(param_1 + 0x350) = uVar3;
    }
    if (*(int *)(param_1 + 0x1cc) == -1) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Row has too many bytes to allocate in memory");
    }
    __aeabi_memclr(*(undefined4 *)(param_1 + 0x1dc),*(int *)(param_1 + 0x1cc) + 1);
    if (*(int *)(param_1 + 0x354) != 0) {
      *(undefined4 *)(param_1 + 0x354) = 0;
      *(undefined4 *)(param_1 + 0x358) = 0;
      png_free(param_1);
    }
    iVar8 = FUN_0002607c(param_1,0x49444154);
    if (iVar8 == 0) {
      *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 0x40;
      return;
    }
                    // WARNING: Subroutine does not return
    png_error(param_1,*(undefined4 *)(param_1 + 0x158));
  }
LAB_000283fe:
                    // WARNING: Does not return
  pcVar2 = (code *)software_udf(0xfe,0x283fe);
  (*pcVar2)();
}



void FUN_00028420(int param_1,int param_2,undefined4 param_3,int *param_4,int param_5,int *param_6)

{
  int iVar1;
  uint uVar2;
  int iVar3;
  uint uVar4;
  undefined4 uVar5;
  int iVar6;
  int iVar7;
  undefined1 auStack_428 [1024];
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (*(int *)(param_1 + 0x13c) == param_2) {
    iVar1 = 0;
    iVar3 = *param_4;
    iVar7 = *param_6;
    *(undefined4 *)(param_1 + 0x150) = 0;
    *(undefined4 *)(param_1 + 0x140) = param_3;
    *(undefined4 *)(param_1 + 0x144) = 0;
    iVar6 = 0;
    if (param_5 != 0) {
      *(int *)(param_1 + 0x14c) = param_5;
    }
    while( true ) {
      *(int *)(param_1 + 0x144) = iVar3 + iVar6;
      if (param_5 == 0) {
        *(undefined1 **)(param_1 + 0x14c) = auStack_428;
        uVar4 = 0x400;
      }
      else {
        uVar4 = 0xffffffff;
      }
      uVar2 = iVar1 + iVar7;
      if (uVar2 < uVar4) {
        uVar4 = uVar2;
      }
      iVar7 = uVar2 - uVar4;
      *(uint *)(param_1 + 0x150) = uVar4;
      uVar5 = 0;
      if (iVar7 == 0) {
        uVar5 = 4;
      }
      iVar1 = inflate(param_1 + 0x140,uVar5);
      if (iVar1 != 0) break;
      iVar6 = *(int *)(param_1 + 0x144);
      iVar3 = 0;
      iVar1 = *(int *)(param_1 + 0x150);
    }
    iVar3 = iVar1;
    if (param_5 == 0) {
      iVar3 = 0;
    }
    if (param_5 == 0) {
      *(int *)(param_1 + 0x14c) = iVar3;
    }
    iVar3 = *(int *)(param_1 + 0x144);
    iVar7 = *(int *)(param_1 + 0x150) + iVar7;
    if (iVar7 != 0) {
      *param_6 = *param_6 - iVar7;
    }
    if (iVar3 != 0) {
      *param_4 = *param_4 - iVar3;
    }
    png_zstream_error(param_1,iVar1);
  }
  else {
    *(char **)(param_1 + 0x158) = "zstream unclaimed";
  }
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void png_set_bKGD(int param_1,int param_2,int param_3)

{
  if (((param_1 != 0) && (param_2 != 0)) && (param_3 != 0)) {
    __aeabi_memcpy(param_2 + 0xaa,param_3,10);
    *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x20;
  }
  return;
}



void png_set_cHRM_fixed(int param_1,int param_2,undefined4 param_3,undefined4 param_4,
                       undefined4 param_5,undefined4 param_6,undefined4 param_7,undefined4 param_8,
                       undefined4 param_9,undefined4 param_10)

{
  int iVar1;
  undefined4 local_38;
  undefined4 uStack_34;
  undefined4 local_30;
  undefined4 uStack_2c;
  undefined4 local_28;
  undefined4 uStack_24;
  undefined4 local_20;
  undefined4 uStack_1c;
  int local_18;
  
  local_18 = __stack_chk_guard;
  if ((param_1 != 0) && (param_2 != 0)) {
    local_38 = param_5;
    uStack_34 = param_6;
    local_30 = param_7;
    uStack_2c = param_8;
    local_28 = param_9;
    uStack_24 = param_10;
    local_20 = param_3;
    uStack_1c = param_4;
    iVar1 = png_colorspace_set_chromaticities(param_1,param_2 + 0x28,&local_38,2);
    if (iVar1 != 0) {
      *(ushort *)(param_2 + 0x72) = *(ushort *)(param_2 + 0x72) | 0x10;
    }
    png_colorspace_sync_info(param_1,param_2);
  }
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_set_cHRM_XYZ_fixed
               (int param_1,int param_2,undefined4 param_3,undefined4 param_4,undefined4 param_5,
               undefined4 param_6,undefined4 param_7,undefined4 param_8,undefined4 param_9,
               undefined4 param_10,undefined4 param_11)

{
  int iVar1;
  undefined4 local_40;
  undefined4 uStack_3c;
  undefined4 local_38;
  undefined4 uStack_34;
  undefined4 local_30;
  undefined4 uStack_2c;
  undefined4 local_28;
  undefined4 uStack_24;
  undefined4 local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((param_1 != 0) && (param_2 != 0)) {
    local_38 = param_5;
    uStack_34 = param_6;
    local_30 = param_7;
    uStack_2c = param_8;
    local_28 = param_9;
    uStack_24 = param_10;
    local_20 = param_11;
    local_40 = param_3;
    uStack_3c = param_4;
    iVar1 = png_colorspace_set_endpoints(param_1,param_2 + 0x28,&local_40,2);
    if (iVar1 != 0) {
      *(ushort *)(param_2 + 0x72) = *(ushort *)(param_2 + 0x72) | 0x10;
    }
    png_colorspace_sync_info(param_1,param_2);
  }
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_set_cHRM(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                 undefined4 param_5,undefined4 param_6,undefined4 param_7,undefined4 param_8,
                 undefined4 param_9,undefined4 param_10,undefined4 param_11,undefined4 param_12,
                 undefined4 param_13,undefined4 param_14,undefined4 param_15,undefined4 param_16,
                 undefined4 param_17,undefined4 param_18)

{
  undefined4 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  
  uVar2 = png_fixed(param_1);
  uVar3 = png_fixed(param_1,(int)((ulonglong)uVar2 >> 0x20),param_5,param_6,"cHRM White Y");
  uVar4 = png_fixed(param_1,(int)((ulonglong)uVar3 >> 0x20),param_7,param_8,"cHRM Red X");
  uVar5 = png_fixed(param_1,(int)((ulonglong)uVar4 >> 0x20),param_9,param_10,"cHRM Red Y");
  uVar6 = png_fixed(param_1,(int)((ulonglong)uVar5 >> 0x20),param_11,param_12,"cHRM Green X");
  uVar7 = png_fixed(param_1,(int)((ulonglong)uVar6 >> 0x20),param_13,param_14,"cHRM Green Y");
  uVar8 = png_fixed(param_1,(int)((ulonglong)uVar7 >> 0x20),param_15,param_16,"cHRM Blue X");
  uVar1 = png_fixed(param_1,(int)((ulonglong)uVar8 >> 0x20),param_17,param_18,"cHRM Blue Y");
  png_set_cHRM_fixed(param_1,param_2,(int)uVar2,(int)uVar3,(int)uVar4,(int)uVar5,(int)uVar6,
                     (int)uVar7,(int)uVar8,uVar1);
  return;
}



void png_set_cHRM_XYZ(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                     undefined4 param_5,undefined4 param_6,undefined4 param_7,undefined4 param_8,
                     undefined4 param_9,undefined4 param_10,undefined4 param_11,undefined4 param_12,
                     undefined4 param_13,undefined4 param_14,undefined4 param_15,undefined4 param_16
                     ,undefined4 param_17,undefined4 param_18,undefined4 param_19,
                     undefined4 param_20)

{
  undefined4 uVar1;
  undefined8 uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  undefined8 uVar9;
  
  uVar2 = png_fixed(param_1);
  uVar3 = png_fixed(param_1,(int)((ulonglong)uVar2 >> 0x20),param_5,param_6,"cHRM Red Y");
  uVar4 = png_fixed(param_1,(int)((ulonglong)uVar3 >> 0x20),param_7,param_8,"cHRM Red Z");
  uVar5 = png_fixed(param_1,(int)((ulonglong)uVar4 >> 0x20),param_9,param_10,"cHRM Green X");
  uVar6 = png_fixed(param_1,(int)((ulonglong)uVar5 >> 0x20),param_11,param_12,"cHRM Green Y");
  uVar7 = png_fixed(param_1,(int)((ulonglong)uVar6 >> 0x20),param_13,param_14,"cHRM Green Z");
  uVar8 = png_fixed(param_1,(int)((ulonglong)uVar7 >> 0x20),param_15,param_16,"cHRM Blue X");
  uVar9 = png_fixed(param_1,(int)((ulonglong)uVar8 >> 0x20),param_17,param_18,"cHRM Blue Y");
  uVar1 = png_fixed(param_1,(int)((ulonglong)uVar9 >> 0x20),param_19,param_20,"cHRM Blue Z");
  png_set_cHRM_XYZ_fixed
            (param_1,param_2,(int)uVar2,(int)uVar3,(int)uVar4,(int)uVar5,(int)uVar6,(int)uVar7,
             (int)uVar8,(int)uVar9,uVar1);
  return;
}



void png_set_gAMA_fixed(int param_1,int param_2)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    png_colorspace_set_gamma(param_1,param_2 + 0x28);
    png_colorspace_sync_info(param_1,param_2);
    return;
  }
  return;
}



void png_set_gAMA(undefined4 param_1,undefined4 param_2)

{
  undefined4 uVar1;
  
  uVar1 = png_fixed(param_1);
  png_set_gAMA_fixed(param_1,param_2,uVar1);
  return;
}



void png_set_hIST(int param_1,int param_2,undefined2 *param_3)

{
  code *pcVar1;
  undefined2 *puVar2;
  int iVar3;
  bool bVar4;
  
  if (((param_1 != 0) && (param_2 != 0)) && ((ushort)(*(short *)(param_2 + 0x14) - 1U) < 0x100)) {
    png_free_data(param_1,param_2,8,0);
    puVar2 = (undefined2 *)png_malloc_warn(param_1,0x200);
    *(undefined2 **)(param_2 + 0xcc) = puVar2;
    if (puVar2 != (undefined2 *)0x0) {
      *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 8;
      if (*(short *)(param_2 + 0x14) != 0) {
        *puVar2 = *param_3;
        iVar3 = 1;
        while (iVar3 < (int)(uint)*(ushort *)(param_2 + 0x14)) {
          *(undefined2 *)(*(int *)(param_2 + 0xcc) + iVar3 * 2) = param_3[iVar3];
          bVar4 = SBORROW4(iVar3 + 1,iVar3);
          iVar3 = iVar3 + 1;
          if (bVar4) {
                    // WARNING: Does not return
            pcVar1 = (code *)software_udf(0xfe,0x28a44);
            (*pcVar1)();
          }
        }
      }
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x40;
    }
  }
  return;
}



void png_set_IHDR(int param_1,int *param_2,int param_3,int param_4,undefined1 param_5,
                 undefined1 param_6,undefined1 param_7,undefined1 param_8,undefined1 param_9)

{
  byte bVar1;
  byte bVar2;
  uint uVar3;
  
  if (param_1 == 0) {
    return;
  }
  if (param_2 == (int *)0x0) {
    return;
  }
  *param_2 = param_3;
  param_2[1] = param_4;
  *(undefined1 *)(param_2 + 6) = param_5;
  *(undefined1 *)((int)param_2 + 0x19) = param_6;
  *(undefined1 *)((int)param_2 + 0x1a) = param_8;
  *(undefined1 *)((int)param_2 + 0x1b) = param_9;
  *(undefined1 *)(param_2 + 7) = param_7;
  png_check_IHDR(param_1,param_3,param_4,param_5,param_6,param_7,param_8,param_9);
  bVar1 = *(byte *)((int)param_2 + 0x19);
  if (bVar1 == 3) {
    bVar2 = 1;
  }
  else {
    bVar2 = bVar1 & 2 | 1;
    *(byte *)((int)param_2 + 0x1d) = bVar2;
    if ((bVar1 & 4) == 0) goto LAB_00028ab6;
    bVar2 = bVar2 + 1;
  }
  *(byte *)((int)param_2 + 0x1d) = bVar2;
LAB_00028ab6:
  bVar2 = (char)param_2[6] * bVar2;
  *(byte *)((int)param_2 + 0x1e) = bVar2;
  if (bVar2 < 8) {
    uVar3 = param_3 * (uint)bVar2 + 7 >> 3;
  }
  else {
    uVar3 = param_3 * (uint)(bVar2 >> 3);
  }
  param_2[3] = uVar3;
  return;
}



void png_set_oFFs(int param_1,int param_2,undefined4 param_3,undefined4 param_4,undefined1 param_5)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    *(undefined4 *)(param_2 + 0xb4) = param_3;
    *(undefined4 *)(param_2 + 0xb8) = param_4;
    *(undefined1 *)(param_2 + 0xbc) = param_5;
    *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x100;
  }
  return;
}



void png_set_pCAL(int param_1,int param_2,char *param_3,undefined4 param_4,undefined4 param_5,
                 uint param_6,uint param_7,char *param_8,int param_9)

{
  code *pcVar1;
  size_t sVar2;
  size_t sVar3;
  int iVar4;
  int iVar5;
  undefined4 uVar6;
  char *__s;
  
  if ((((param_1 != 0 && param_2 != 0) && (param_3 != (char *)0x0)) && (param_8 != (char *)0x0)) &&
     (((int)param_7 < 1 || (param_9 != 0)))) {
    sVar2 = strlen(param_3);
    if (3 < param_6) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid pCAL equation type");
    }
    if (0xff < param_7) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid pCAL parameter count");
    }
    if (0 < (int)param_7) {
      iVar5 = 0;
      do {
        __s = *(char **)(param_9 + iVar5 * 4);
        if (__s == (char *)0x0) {
LAB_00028c56:
                    // WARNING: Subroutine does not return
          png_error(param_1,"Invalid format for pCAL parameter");
        }
        sVar3 = strlen(__s);
        iVar4 = png_check_fp_string(__s,sVar3);
        if (iVar4 == 0) goto LAB_00028c56;
        iVar4 = iVar5 + 1;
        if (SBORROW4(iVar4,iVar5)) goto LAB_00028c60;
        iVar5 = iVar4;
      } while (iVar4 < (int)param_7);
    }
    iVar5 = png_malloc_warn(param_1,sVar2 + 1);
    *(int *)(param_2 + 0xd0) = iVar5;
    if (iVar5 != 0) {
      __aeabi_memcpy(iVar5,param_3,sVar2 + 1);
      *(undefined4 *)(param_2 + 0xd4) = param_4;
      *(undefined4 *)(param_2 + 0xd8) = param_5;
      *(char *)(param_2 + 0xe4) = (char)param_6;
      *(char *)(param_2 + 0xe5) = (char)param_7;
      sVar2 = strlen(param_8);
      iVar5 = png_malloc_warn(param_1,sVar2 + 1);
      *(int *)(param_2 + 0xdc) = iVar5;
      if (iVar5 != 0) {
        __aeabi_memcpy(iVar5,param_8,sVar2 + 1);
        if (SBORROW4(param_7 + 1,param_7)) {
LAB_00028c60:
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x28c60);
          (*pcVar1)();
        }
        iVar4 = (param_7 + 1) * 4;
        iVar5 = png_malloc_warn(param_1,iVar4);
        *(int *)(param_2 + 0xe0) = iVar5;
        if (iVar5 != 0) {
          __aeabi_memclr4(iVar5,iVar4);
          if (0 < (int)param_7) {
            iVar5 = 0;
            do {
              sVar2 = strlen(*(char **)(param_9 + iVar5 * 4));
              uVar6 = png_malloc_warn(param_1,sVar2 + 1);
              *(undefined4 *)(*(int *)(param_2 + 0xe0) + iVar5 * 4) = uVar6;
              iVar4 = *(int *)(*(int *)(param_2 + 0xe0) + iVar5 * 4);
              if (iVar4 == 0) {
                return;
              }
              __aeabi_memcpy(iVar4,*(undefined4 *)(param_9 + iVar5 * 4),sVar2 + 1);
              iVar4 = iVar5 + 1;
              if (SBORROW4(iVar4,iVar5)) goto LAB_00028c60;
              iVar5 = iVar4;
            } while (iVar4 < (int)param_7);
          }
          *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x400;
          *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x80;
        }
      }
    }
  }
  return;
}



void png_set_sCAL_s(int param_1,int param_2,int param_3,char *param_4,char *param_5)

{
  size_t sVar1;
  int iVar2;
  size_t sVar3;
  
  if (param_1 != 0 && param_2 != 0) {
    if (1 < param_3 - 1U) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid sCAL unit");
    }
    if ((((param_4 == (char *)0x0) || (sVar1 = strlen(param_4), sVar1 == 0)) || (*param_4 == '-'))
       || (iVar2 = png_check_fp_string(param_4,sVar1), iVar2 == 0)) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid sCAL width");
    }
    if (((param_5 == (char *)0x0) || (sVar3 = strlen(param_5), sVar3 == 0)) ||
       ((*param_5 == '-' || (iVar2 = png_check_fp_string(param_5,sVar3), iVar2 == 0)))) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid sCAL height");
    }
    *(char *)(param_2 + 0xfc) = (char)param_3;
    iVar2 = png_malloc_warn(param_1,sVar1 + 1);
    *(int *)(param_2 + 0x100) = iVar2;
    if (iVar2 != 0) {
      __aeabi_memcpy(iVar2,param_4,sVar1 + 1);
      iVar2 = png_malloc_warn(param_1,sVar3 + 1);
      *(int *)(param_2 + 0x104) = iVar2;
      if (iVar2 == 0) {
        png_free(param_1,*(undefined4 *)(param_2 + 0x100));
        *(undefined4 *)(param_2 + 0x100) = 0;
        return;
      }
      __aeabi_memcpy(iVar2,param_5,sVar3 + 1);
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x4000;
      *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x100;
    }
  }
  return;
}



void png_set_sCAL(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                 double param_5,double param_6)

{
  undefined4 uVar1;
  undefined1 auStack_48 [18];
  undefined1 auStack_36 [18];
  int local_24;
  
  local_24 = __stack_chk_guard;
  if ((0.0 < param_5) && (0.0 < param_6)) {
    png_ascii_from_fp(param_1,auStack_36,0x12,param_4,param_5,5);
    uVar1 = 5;
    png_ascii_from_fp(param_1,auStack_48,0x12);
    png_set_sCAL_s(param_1,param_2,param_3,auStack_36,auStack_48,(int)((ulonglong)param_6 >> 0x20),
                   uVar1);
  }
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_set_sCAL_fixed(undefined4 param_1,undefined4 param_2,undefined4 param_3,int param_4,
                       int param_5)

{
  int iVar1;
  int unaff_r7;
  bool bVar2;
  undefined1 auStack_44 [18];
  undefined1 auStack_32 [18];
  int local_20;
  
  bVar2 = SBORROW4(param_4,1);
  iVar1 = param_4 + -1;
  local_20 = __stack_chk_guard;
  if (0 < param_4) {
    bVar2 = SBORROW4(param_5,1);
    iVar1 = param_5 + -1;
    unaff_r7 = param_5;
  }
  if (iVar1 < 0 == bVar2) {
    png_ascii_from_fixed(param_1,auStack_32,0x12);
    png_ascii_from_fixed(param_1,auStack_44,0x12,unaff_r7);
    png_set_sCAL_s(param_1,param_2,param_3,auStack_32,auStack_44);
  }
  if (__stack_chk_guard != local_20) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_set_pHYs(int param_1,int param_2,undefined4 param_3,undefined4 param_4,undefined1 param_5)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    *(undefined4 *)(param_2 + 0xc0) = param_3;
    *(undefined4 *)(param_2 + 0xc4) = param_4;
    *(undefined1 *)(param_2 + 200) = param_5;
    *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x80;
  }
  return;
}



void png_set_PLTE(int param_1,int param_2,int param_3,int param_4)

{
  ushort uVar1;
  undefined4 uVar2;
  uint uVar3;
  int iVar4;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = (ushort)*(byte *)(param_2 + 0x19);
    if (uVar1 == 3) {
      uVar1 = *(ushort *)(param_2 + 0x18) >> 8;
      iVar4 = 1 << (sbyte)*(ushort *)(param_2 + 0x18);
    }
    else {
      iVar4 = 0x100;
    }
    if ((param_4 < 0) || (iVar4 < param_4)) {
      if (uVar1 == 3) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Invalid palette length");
      }
    }
    else {
      if (((param_3 == 0) && (0 < param_4)) ||
         ((param_4 == 0 && ((*(byte *)(param_1 + 0x304) & 1) == 0)))) {
                    // WARNING: Subroutine does not return
        png_error(param_1,"Invalid palette");
      }
      png_free_data(param_1,param_2,0x1000,0);
      uVar2 = png_calloc(param_1,0x300);
      *(undefined4 *)(param_1 + 0x1f8) = uVar2;
      if (0 < param_4) {
        __aeabi_memcpy(uVar2,param_3,param_4 * 3);
      }
      *(undefined4 *)(param_2 + 0x10) = uVar2;
      *(short *)(param_2 + 0x14) = (short)param_4;
      uVar3 = *(uint *)(param_2 + 0xe8);
      *(short *)(param_1 + 0x1fc) = (short)param_4;
      *(uint *)(param_2 + 0xe8) = uVar3 | 0x1000;
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 8;
    }
  }
  return;
}



void png_set_sBIT(int param_1,int param_2,undefined4 *param_3)

{
  undefined4 uVar1;
  
  if (((param_1 != 0) && (param_2 != 0)) && (param_3 != (undefined4 *)0x0)) {
    uVar1 = *param_3;
    *(undefined1 *)(param_2 + 0x98) = *(undefined1 *)(param_3 + 1);
    *(undefined4 *)(param_2 + 0x94) = uVar1;
    *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 2;
  }
  return;
}



void png_set_sRGB(int param_1,int param_2)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    png_colorspace_set_sRGB(param_1,param_2 + 0x28);
    png_colorspace_sync_info(param_1,param_2);
    return;
  }
  return;
}



void png_set_sRGB_gAMA_and_cHRM(int param_1,int param_2)

{
  int iVar1;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    iVar1 = png_colorspace_set_sRGB(param_1,param_2 + 0x28);
    if (iVar1 != 0) {
      *(ushort *)(param_2 + 0x72) = *(ushort *)(param_2 + 0x72) | 0x18;
    }
    png_colorspace_sync_info(param_1,param_2);
    return;
  }
  return;
}



void png_set_iCCP(int param_1,int param_2,char *param_3,int param_4,int param_5,undefined4 param_6)

{
  int iVar1;
  size_t sVar2;
  int iVar3;
  char *pcVar4;
  
  if ((((param_1 != 0) && (param_2 != 0)) && (param_3 != (char *)0x0)) && (param_5 != 0)) {
    if (param_4 != 0) {
      png_app_error(param_1,"Invalid iCCP compression method");
    }
    iVar1 = png_colorspace_set_ICC
                      (param_1,param_2 + 0x28,param_3,param_6,param_5,
                       *(undefined1 *)(param_2 + 0x19));
    png_colorspace_sync_info(param_1,param_2);
    if (iVar1 != 0) {
      *(ushort *)(param_2 + 0x72) = *(ushort *)(param_2 + 0x72) | 0x18;
      sVar2 = strlen(param_3);
      iVar1 = png_malloc_warn(param_1,sVar2 + 1);
      if (iVar1 == 0) {
        pcVar4 = "Insufficient memory to process iCCP chunk";
      }
      else {
        __aeabi_memcpy(iVar1,param_3,sVar2 + 1);
        iVar3 = png_malloc_warn(param_1,param_6);
        if (iVar3 != 0) {
          __aeabi_memcpy(iVar3,param_5,param_6);
          png_free_data(param_1,param_2,0x10,0);
          *(undefined4 *)(param_2 + 0x7c) = param_6;
          *(int *)(param_2 + 0x74) = iVar1;
          *(int *)(param_2 + 0x78) = iVar3;
          *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x10;
          *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x1000;
          return;
        }
        png_free(param_1,iVar1);
        pcVar4 = "Insufficient memory to process iCCP profile";
      }
      png_benign_error(param_1,pcVar4);
      return;
    }
  }
  return;
}



void png_set_text(undefined4 param_1)

{
  int iVar1;
  
  iVar1 = png_set_text_2();
  if (iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"Insufficient memory to store text");
}



undefined4 png_set_text_2(int param_1,int param_2,int param_3,int param_4)

{
  int *piVar1;
  code *pcVar2;
  int iVar3;
  char *pcVar4;
  size_t sVar5;
  size_t sVar6;
  size_t sVar7;
  int iVar8;
  undefined4 uVar9;
  uint uVar10;
  int *piVar11;
  int *piVar12;
  size_t local_2c;
  
  if (param_3 == 0) {
    return 0;
  }
  if (param_1 == 0 || param_2 == 0) {
    return 0;
  }
  if (param_4 < 1) {
    return 0;
  }
  iVar8 = *(int *)(param_2 + 0x80);
  if (SBORROW4(*(int *)(param_2 + 0x84),iVar8)) goto LAB_00029354;
  if (*(int *)(param_2 + 0x84) - iVar8 < param_4) {
    if (SBORROW4(0x7fffffff,iVar8)) goto LAB_00029354;
    if (param_4 <= 0x7fffffff - iVar8) {
      iVar3 = iVar8 + param_4;
      if (SBORROW4(iVar3,iVar8)) {
LAB_00029354:
                    // WARNING: Does not return
        pcVar2 = (code *)software_udf(0xfe,0x29354);
        (*pcVar2)();
      }
      if (iVar3 < 0x7ffffff7) {
        if (SBORROW4(iVar3 + 8U,iVar3)) goto LAB_00029354;
        uVar10 = iVar3 + 8U & 0xfffffff8;
      }
      else {
        uVar10 = 0x7fffffff;
      }
      if (SBORROW4(uVar10,iVar8)) goto LAB_00029354;
      iVar8 = png_realloc_array(param_1,*(undefined4 *)(param_2 + 0x88),iVar8,uVar10 - iVar8,0x1c);
      if (iVar8 != 0) {
        png_free(param_1,*(undefined4 *)(param_2 + 0x88));
        *(int *)(param_2 + 0x88) = iVar8;
        *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x4000;
        *(uint *)(param_2 + 0x84) = uVar10;
        goto LAB_000291ac;
      }
    }
    pcVar4 = "too many text chunks";
LAB_00029346:
    uVar9 = 1;
    png_chunk_report(param_1,pcVar4,1);
  }
  else {
LAB_000291ac:
    uVar9 = 0;
    if (0 < param_4) {
      iVar8 = 0;
      do {
        piVar11 = (int *)(param_3 + iVar8 * 0x1c);
        pcVar4 = (char *)piVar11[1];
        if (pcVar4 != (char *)0x0) {
          iVar3 = *(int *)(param_3 + iVar8 * 0x1c);
          if (iVar3 + 1U < 4) {
            piVar12 = (int *)(*(int *)(param_2 + 0x88) + *(int *)(param_2 + 0x80) * 0x1c);
            sVar5 = strlen(pcVar4);
            if (iVar3 < 1) {
              local_2c = 0;
LAB_0002921e:
              sVar6 = 0;
            }
            else {
              if ((char *)piVar11[5] == (char *)0x0) {
                local_2c = 0;
              }
              else {
                local_2c = strlen((char *)piVar11[5]);
              }
              if ((char *)piVar11[6] == (char *)0x0) goto LAB_0002921e;
              sVar6 = strlen((char *)piVar11[6]);
            }
            pcVar4 = (char *)piVar11[2];
            if ((pcVar4 == (char *)0x0) || (*pcVar4 == '\0')) {
              if (iVar3 < 1) {
                iVar3 = -1;
              }
              else {
                iVar3 = 1;
              }
              sVar7 = 0;
              *piVar12 = iVar3;
            }
            else {
              sVar7 = strlen(pcVar4);
              *piVar12 = iVar3;
            }
            iVar3 = png_malloc_base(param_1,local_2c + sVar5 + sVar6 + sVar7 + 4);
            piVar1 = piVar12 + 1;
            *piVar1 = iVar3;
            if (iVar3 == 0) {
              pcVar4 = "text chunk: out of memory";
              goto LAB_00029346;
            }
            __aeabi_memcpy(iVar3,piVar11[1],sVar5);
            *(undefined1 *)(*piVar1 + sVar5) = 0;
            if (*piVar11 < 1) {
              piVar12[5] = 0;
              piVar12[6] = 0;
              iVar3 = *piVar1 + sVar5;
            }
            else {
              iVar3 = *piVar1 + sVar5 + 1;
              piVar12[5] = iVar3;
              __aeabi_memcpy(iVar3,piVar11[5],local_2c);
              *(undefined1 *)(piVar12[5] + local_2c) = 0;
              iVar3 = piVar12[5] + local_2c + 1;
              piVar12[6] = iVar3;
              __aeabi_memcpy(iVar3,piVar11[6],sVar6);
              *(undefined1 *)(piVar12[6] + sVar6) = 0;
              iVar3 = piVar12[6] + sVar6;
            }
            iVar3 = iVar3 + 1;
            piVar12[2] = iVar3;
            if (sVar7 != 0) {
              __aeabi_memcpy(iVar3,piVar11[2],sVar7);
              iVar3 = piVar12[2];
            }
            *(undefined1 *)(iVar3 + sVar7) = 0;
            if (*piVar12 < 1) {
              sVar5 = 0;
            }
            else {
              sVar5 = sVar7;
              sVar7 = 0;
            }
            piVar12[3] = sVar7;
            piVar12[4] = sVar5;
            iVar3 = *(int *)(param_2 + 0x80) + 1;
            if (SBORROW4(iVar3,*(int *)(param_2 + 0x80))) goto LAB_00029354;
            *(int *)(param_2 + 0x80) = iVar3;
          }
          else {
            png_chunk_report(param_1,"text compression mode is out of range",1);
          }
        }
        iVar3 = iVar8 + 1;
        if (SBORROW4(iVar3,iVar8)) goto LAB_00029354;
        iVar8 = iVar3;
      } while (iVar3 < param_4);
      uVar9 = 0;
    }
  }
  return uVar9;
}



void png_set_tIME(int param_1,int param_2,undefined4 *param_3)

{
  ushort uVar1;
  undefined4 uVar2;
  bool bVar3;
  bool bVar4;
  
  if ((((param_1 != 0) && (param_2 != 0)) && (param_3 != (undefined4 *)0x0)) &&
     ((((*(byte *)(param_1 + 0x131) & 2) == 0 && ((*(ushort *)((int)param_3 + 2) - 1 & 0xff) < 0xc))
      && ((((*(ushort *)((int)param_3 + 2) >> 8) - 1 & 0xff) < 0x1f &&
          ((byte)*(ushort *)(param_3 + 1) < 0x18)))))) {
    uVar1 = *(ushort *)(param_3 + 1) >> 8;
    bVar4 = 0x3a < uVar1;
    bVar3 = uVar1 == 0x3b;
    if (uVar1 < 0x3c) {
      bVar4 = 0x3b < *(byte *)((int)param_3 + 6);
      bVar3 = *(byte *)((int)param_3 + 6) == 0x3c;
    }
    if (!bVar4 || bVar3) {
      uVar2 = *param_3;
      *(undefined4 *)(param_2 + 0x90) = param_3[1];
      *(undefined4 *)(param_2 + 0x8c) = uVar2;
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x200;
    }
  }
  return;
}



void png_set_tRNS(int param_1,int param_2,int param_3,int param_4,int param_5)

{
  undefined4 uVar1;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    if (param_3 != 0) {
      png_free_data(param_1,param_2,0x2000,0);
      uVar1 = png_malloc(param_1,0x100);
      *(undefined4 *)(param_2 + 0x9c) = uVar1;
      *(undefined4 *)(param_1 + 0x268) = uVar1;
      if (param_4 - 1U < 0x100) {
        __aeabi_memcpy(uVar1,param_3,param_4);
      }
    }
    if (param_5 == 0) {
      *(short *)(param_2 + 0x16) = (short)param_4;
      if (param_4 == 0) {
        return;
      }
    }
    else {
      __aeabi_memcpy(param_2 + 0xa0,param_5,10);
      if (param_4 == 0) {
        param_4 = 1;
      }
      *(short *)(param_2 + 0x16) = (short)param_4;
    }
    *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x10;
    *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x2000;
  }
  return;
}



void png_set_sPLT(int param_1,int param_2,int param_3,int param_4)

{
  code *pcVar1;
  int iVar2;
  size_t sVar3;
  char *pcVar4;
  int *piVar5;
  int *piVar6;
  
  if (((param_3 != 0) && (param_1 != 0 && param_2 != 0)) && (0 < param_4)) {
    iVar2 = png_realloc_array(param_1,*(undefined4 *)(param_2 + 0xf4),
                              *(undefined4 *)(param_2 + 0xf8),param_4,0x10);
    if (iVar2 == 0) {
      pcVar4 = "too many sPLT chunks";
LAB_0002954a:
      png_chunk_report(param_1,pcVar4,1);
      return;
    }
    png_free(param_1,*(undefined4 *)(param_2 + 0xf4));
    *(int *)(param_2 + 0xf4) = iVar2;
    piVar6 = (int *)(param_3 + 8);
    *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x20;
    piVar5 = (int *)(iVar2 + *(int *)(param_2 + 0xf8) * 0x10);
    do {
      if ((piVar6[-2] != 0) && (*piVar6 != 0)) {
        *(char *)(piVar5 + 1) = (char)piVar6[-1];
        sVar3 = strlen((char *)piVar6[-2]);
        iVar2 = png_malloc_base(param_1,sVar3 + 1);
        *piVar5 = iVar2;
        if (iVar2 != 0) {
          __aeabi_memcpy(iVar2,piVar6[-2],sVar3 + 1);
          iVar2 = png_malloc_array(param_1,piVar6[1],10);
          piVar5[2] = iVar2;
          if (iVar2 != 0) {
            piVar5[3] = piVar6[1];
            __aeabi_memcpy(iVar2,*piVar6,piVar6[1] * 10);
            *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x2000;
            iVar2 = *(int *)(param_2 + 0xf8) + 1;
            if (SBORROW4(iVar2,*(int *)(param_2 + 0xf8))) goto LAB_0002955e;
            piVar5 = piVar5 + 4;
            *(int *)(param_2 + 0xf8) = iVar2;
            goto LAB_0002951c;
          }
          png_free(param_1,*piVar5);
          *piVar5 = 0;
        }
        if (param_4 < 1) {
          return;
        }
        pcVar4 = "sPLT out of memory";
        goto LAB_0002954a;
      }
      png_app_error(param_1,"png_set_sPLT: invalid sPLT");
LAB_0002951c:
      if (SBORROW4(param_4,1)) {
LAB_0002955e:
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x2955e);
        (*pcVar1)();
      }
      param_4 = param_4 + -1;
      piVar6 = piVar6 + 4;
    } while (param_4 != 0);
  }
  return;
}



void png_set_unknown_chunks(int param_1,int param_2,int param_3,int param_4)

{
  code *pcVar1;
  undefined1 uVar2;
  int iVar3;
  undefined4 *puVar4;
  undefined4 *puVar5;
  
  if (((param_3 != 0 && param_1 != 0) && (param_2 != 0)) && (0 < param_4)) {
    iVar3 = png_realloc_array(param_1,*(undefined4 *)(param_2 + 0xec),
                              *(undefined4 *)(param_2 + 0xf0),param_4,0x14);
    if (iVar3 == 0) {
      png_chunk_report(param_1,"too many unknown chunks",1);
      return;
    }
    png_free(param_1,*(undefined4 *)(param_2 + 0xec));
    *(int *)(param_2 + 0xec) = iVar3;
    *(uint *)(param_2 + 0xe8) = *(uint *)(param_2 + 0xe8) | 0x200;
    if (0 < param_4) {
      puVar4 = (undefined4 *)(param_3 + 8);
      puVar5 = (undefined4 *)(iVar3 + *(int *)(param_2 + 0xf0) * 0x14);
      do {
        *puVar5 = puVar4[-2];
        *(undefined1 *)(puVar5 + 1) = 0;
        uVar2 = FUN_00029668(param_1,*(undefined1 *)(puVar4 + 2));
        *(undefined1 *)(puVar5 + 4) = uVar2;
        if (puVar4[1] == 0) {
          puVar5[2] = 0;
          puVar5[3] = 0;
LAB_00029610:
          iVar3 = *(int *)(param_2 + 0xf0) + 1;
          if (SBORROW4(iVar3,*(int *)(param_2 + 0xf0))) goto LAB_0002965e;
          puVar5 = puVar5 + 5;
          *(int *)(param_2 + 0xf0) = iVar3;
        }
        else {
          iVar3 = png_malloc_base(param_1);
          puVar5[2] = iVar3;
          if (iVar3 != 0) {
            __aeabi_memcpy(iVar3,*puVar4,puVar4[1]);
            puVar5[3] = puVar4[1];
            goto LAB_00029610;
          }
          png_chunk_report(param_1,"unknown chunk: out of memory",1);
        }
        if (SBORROW4(param_4,1)) {
LAB_0002965e:
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x2965e);
          (*pcVar1)();
        }
        param_4 = param_4 + -1;
        puVar4 = puVar4 + 5;
      } while (0 < param_4);
    }
  }
  return;
}



// WARNING: Removing unreachable block (ram,0x000296aa)

uint FUN_00029668(int param_1,uint param_2)

{
  param_2 = param_2 & 0xb;
  if (param_2 == 0) {
    if ((*(byte *)(param_1 + 0x131) & 0x80) == 0) {
      png_app_warning(param_1,"png_set_unknown_chunks now expects a valid location");
      param_2 = *(uint *)(param_1 + 0x130) & 0xb;
      if (param_2 != 0) goto LAB_00029694;
    }
                    // WARNING: Subroutine does not return
    png_error(param_1,"invalid location in png_set_unknown_chunks");
  }
LAB_00029694:
  for (; param_2 != (-param_2 & param_2); param_2 = param_2 ^ -param_2 & param_2) {
  }
  return param_2;
}



void png_set_unknown_chunk_location(int param_1,int param_2,int param_3,uint param_4)

{
  uint uVar1;
  undefined1 uVar2;
  
  if ((((param_1 != 0) && (param_2 != 0)) && (-1 < param_3)) && (param_3 < *(int *)(param_2 + 0xf0))
     ) {
    if ((param_4 & 0xb) == 0) {
      png_app_error(param_1,"invalid unknown chunk location");
      uVar1 = param_4 & 4;
      param_4 = 8;
      if (uVar1 == 0) {
        param_4 = 1;
      }
    }
    uVar2 = FUN_00029668(param_1,param_4);
    *(undefined1 *)(*(int *)(param_2 + 0xec) + param_3 * 0x14 + 0x10) = uVar2;
  }
  return;
}



void png_permit_mng_features(int param_1,uint param_2)

{
  if (param_1 == 0) {
    param_2 = 0;
  }
  else {
    param_2 = param_2 & 5;
  }
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x304) = param_2;
  }
  return;
}



void png_set_keep_unknown_chunks(int param_1,uint param_2,undefined *param_3,int param_4)

{
  uint uVar1;
  char *pcVar2;
  int iVar3;
  uint *puVar4;
  uint *puVar5;
  uint uVar6;
  undefined1 unaff_r7;
  uint *puVar7;
  
  if (param_1 == 0) {
    return;
  }
  if (3 < param_2) {
    pcVar2 = "png_set_keep_unknown_chunks: invalid keep";
LAB_00029790:
    png_app_error(param_1,pcVar2);
    return;
  }
  if (param_4 < 1) {
    *(uint *)(param_1 + 0x2f0) = param_2;
    if (param_4 == 0) {
      return;
    }
    param_4 = 0x11;
    param_3 = &UNK_00033404;
  }
  else if (param_3 == (undefined *)0x0) {
    pcVar2 = "png_set_keep_unknown_chunks: no chunk list";
    goto LAB_00029790;
  }
  uVar6 = *(uint *)(param_1 + 0x2f4);
  puVar7 = *(uint **)(param_1 + 0x2f8);
  if (puVar7 == (uint *)0x0) {
    uVar6 = 0;
  }
  if (0x33333333 < uVar6 + param_4) {
    pcVar2 = "png_set_keep_unknown_chunks: too many chunks";
    goto LAB_00029790;
  }
  if (param_2 == 0) {
    if (uVar6 != 0) goto LAB_000297c0;
  }
  else {
    puVar7 = (uint *)png_malloc(param_1,(uVar6 + param_4) * 5);
    if (uVar6 != 0) {
      __aeabi_memcpy(puVar7,*(undefined4 *)(param_1 + 0x2f8),uVar6 * 5);
    }
LAB_000297c0:
    if (puVar7 != (uint *)0x0) {
      if (param_4 != 0) {
        iVar3 = 0;
        do {
          puVar5 = puVar7;
          if (uVar6 != 0) {
            uVar1 = 0;
            do {
              unaff_r7 = *puVar5 != *(uint *)(param_3 + iVar3 * 5);
              if (!(bool)unaff_r7) {
                *(char *)((int)puVar7 + uVar1 * 5 + 4) = (char)param_2;
                goto LAB_0002980e;
              }
              uVar1 = uVar1 + 1;
              puVar5 = (uint *)((int)puVar5 + 5);
            } while (uVar1 < uVar6);
          }
          if (param_2 != 0) {
            uVar6 = uVar6 + 1;
            *puVar5 = *(uint *)(param_3 + iVar3 * 5);
            *(char *)(puVar5 + 1) = (char)param_2;
          }
LAB_0002980e:
          iVar3 = iVar3 + 1;
        } while (iVar3 != param_4);
      }
      if (uVar6 != 0) {
        iVar3 = 0;
        puVar5 = puVar7;
        puVar4 = puVar7;
        do {
          uVar1 = (uint)(byte)puVar4[1];
          if (uVar1 != 0) {
            if (puVar4 != puVar5) {
              uVar1 = *puVar4;
              unaff_r7 = (undefined1)puVar4[1];
            }
            if (puVar4 != puVar5) {
              *(undefined1 *)(puVar5 + 1) = unaff_r7;
              *puVar5 = uVar1;
            }
            iVar3 = iVar3 + 1;
            puVar5 = (uint *)((int)puVar5 + 5);
          }
          uVar6 = uVar6 - 1;
          puVar4 = (uint *)((int)puVar4 + 5);
        } while (uVar6 != 0);
        if (iVar3 != 0) goto LAB_00029850;
      }
      if (*(uint **)(param_1 + 0x2f8) != puVar7) {
        png_free(param_1,puVar7);
      }
    }
  }
  puVar7 = (uint *)0x0;
  iVar3 = 0;
LAB_00029850:
  *(int *)(param_1 + 0x2f4) = iVar3;
  if (*(uint **)(param_1 + 0x2f8) != puVar7) {
    if (*(uint **)(param_1 + 0x2f8) != (uint *)0x0) {
      png_free(param_1);
    }
    *(uint **)(param_1 + 0x2f8) = puVar7;
  }
  return;
}



void png_set_read_user_chunk_fn(int param_1,undefined4 param_2,undefined4 param_3)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x2e8) = param_2;
    *(undefined4 *)(param_1 + 0x2ec) = param_3;
  }
  return;
}



void png_set_rows(int param_1,int param_2,int param_3)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    if ((*(int *)(param_2 + 0x108) != 0) && (*(int *)(param_2 + 0x108) != param_3)) {
      png_free_data(param_1,param_2,0x40,0);
    }
    *(int *)(param_2 + 0x108) = param_3;
    if (param_3 != 0) {
      *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) | 0x8000;
    }
  }
  return;
}



void png_set_compression_buffer_size(int param_1,uint param_2)

{
  if (param_1 != 0) {
    if ((int)param_2 < 1) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"invalid compression buffer size");
    }
    if ((*(byte *)(param_1 + 0x131) & 0x80) != 0) {
      *(uint *)(param_1 + 0x35c) = param_2;
      return;
    }
    if (((5 < param_2) && (*(int *)(param_1 + 0x13c) == 0)) &&
       (*(uint *)(param_1 + 0x17c) != param_2)) {
      png_free_buffer_list(param_1,param_1 + 0x178);
      *(uint *)(param_1 + 0x17c) = param_2;
    }
  }
  return;
}



void png_set_invalid(int param_1,int param_2,uint param_3)

{
  if ((param_1 != 0) && (param_2 != 0)) {
    *(uint *)(param_2 + 8) = *(uint *)(param_2 + 8) & ~param_3;
  }
  return;
}



void png_set_user_limits(int param_1,undefined4 param_2,undefined4 param_3)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x32c) = param_2;
    *(undefined4 *)(param_1 + 0x330) = param_3;
  }
  return;
}



void png_set_chunk_cache_max(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x334) = param_2;
  }
  return;
}



void png_set_chunk_malloc_max(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x338) = param_2;
  }
  return;
}



void png_set_benign_errors(int param_1,int param_2)

{
  uint uVar1;
  
  uVar1 = *(uint *)(param_1 + 0x134) | 0x700000;
  if (param_2 == 0) {
    uVar1 = *(uint *)(param_1 + 0x134) & 0xff8fffff;
  }
  *(uint *)(param_1 + 0x134) = uVar1;
  return;
}



void png_set_check_for_invalid_index(int param_1,int param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0;
  if (param_2 < 1) {
    uVar1 = 0xffffffff;
  }
  *(undefined4 *)(param_1 + 0x200) = uVar1;
  return;
}



uint png_check_keyword(undefined4 param_1,byte *param_2,byte *param_3)

{
  uint uVar1;
  uint uVar2;
  byte *pbVar3;
  byte bVar4;
  byte bVar5;
  uint uVar6;
  bool bVar7;
  
  if (param_2 == (byte *)0x0) {
    *param_3 = 0;
    return 0;
  }
  uVar6 = 1;
  uVar1 = 0;
  bVar4 = *param_2;
  while (bVar4 != 0) {
    while( true ) {
      param_2 = param_2 + 1;
      bVar5 = bVar4 - 0x21;
      bVar7 = bVar4 < 0xa1;
      if ((0xa0 < bVar4 || bVar5 < 0x5e) || (uVar6 == 0)) break;
      bVar4 = *param_2;
      if (bVar4 == 0) goto LAB_000299c4;
    }
    if (0xa0 >= bVar4 && bVar5 >= 0x5e) {
      bVar4 = 0x20;
    }
    uVar1 = uVar1 + 1;
    uVar6 = (uint)(bVar7 && 0x5d < bVar5);
    pbVar3 = param_3 + 1;
    *param_3 = bVar4;
    param_3 = pbVar3;
    if (0x4e < uVar1) break;
    bVar4 = *param_2;
  }
LAB_000299c4:
  if (uVar6 != 0) {
    uVar6 = 1;
  }
  uVar2 = uVar1;
  if (uVar1 != 0) {
    uVar2 = 1;
  }
  bVar7 = (uVar2 & uVar6) != 0;
  if (bVar7) {
    param_3 = param_3 + -1;
  }
  *param_3 = 0;
  if (bVar7) {
    uVar1 = uVar1 - 1;
  }
  return uVar1;
}



void png_set_bgr(int param_1)

{
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 1;
  }
  return;
}



void png_set_swap(int param_1)

{
  uint uVar1;
  bool bVar2;
  
  if (param_1 != 0) {
    uVar1 = (uint)*(byte *)(param_1 + 0x20c);
    bVar2 = uVar1 == 0x10;
    if (bVar2) {
      uVar1 = *(uint *)(param_1 + 0x138) | 0x10;
    }
    if (bVar2) {
      *(uint *)(param_1 + 0x138) = uVar1;
    }
  }
  return;
}



void png_set_packing(int param_1)

{
  if ((param_1 != 0) && (*(byte *)(param_1 + 0x20c) < 8)) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 4;
    *(undefined1 *)(param_1 + 0x20d) = 8;
  }
  return;
}



void png_set_packswap(int param_1)

{
  uint uVar1;
  uint uVar2;
  
  if (param_1 != 0) {
    uVar1 = (uint)*(byte *)(param_1 + 0x20c);
    uVar2 = uVar1;
    if (uVar1 < 8) {
      uVar2 = *(uint *)(param_1 + 0x138) | 0x10000;
    }
    if (uVar1 < 8) {
      *(uint *)(param_1 + 0x138) = uVar2;
    }
  }
  return;
}



void png_set_shift(int param_1,undefined4 *param_2)

{
  undefined4 uVar1;
  
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 8;
    uVar1 = *param_2;
    *(undefined1 *)(param_1 + 0x265) = *(undefined1 *)(param_2 + 1);
    *(undefined4 *)(param_1 + 0x261) = uVar1;
  }
  return;
}



undefined4 png_set_interlace_handling(int param_1)

{
  if ((param_1 != 0) && (*(char *)(param_1 + 0x208) != '\0')) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 2;
    return 7;
  }
  return 1;
}



void png_set_filler(int param_1,undefined2 param_2,int param_3)

{
  uint uVar1;
  char *pcVar2;
  
  if (param_1 != 0) {
    if ((*(byte *)(param_1 + 0x131) & 0x80) == 0) {
      if (*(char *)(param_1 + 0x20b) == '\0') {
        if (*(byte *)(param_1 + 0x20c) < 8) {
          pcVar2 = "png_set_filler is invalid for low bit depth gray output";
          goto LAB_0002f630;
        }
        *(undefined1 *)(param_1 + 0x210) = 2;
      }
      else {
        if (*(char *)(param_1 + 0x20b) != '\x02') {
          pcVar2 = "png_set_filler: inappropriate color type";
LAB_0002f630:
          png_app_error(param_1,pcVar2);
          return;
        }
        *(undefined1 *)(param_1 + 0x210) = 4;
      }
    }
    else {
      *(undefined2 *)(param_1 + 0x214) = param_2;
    }
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x8000;
    if (param_3 == 1) {
      uVar1 = *(uint *)(param_1 + 0x134) | 0x80;
    }
    else {
      uVar1 = *(uint *)(param_1 + 0x134) & 0xffffff7f;
    }
    *(uint *)(param_1 + 0x134) = uVar1;
  }
  return;
}



void png_set_add_alpha(int param_1)

{
  uint uVar1;
  bool bVar2;
  
  if (param_1 != 0) {
    png_set_filler(param_1);
    uVar1 = *(uint *)(param_1 + 0x138);
    bVar2 = (uVar1 & 0x8000) != 0;
    if (bVar2) {
      uVar1 = uVar1 | 0x1000000;
    }
    if (bVar2) {
      *(uint *)(param_1 + 0x138) = uVar1;
    }
  }
  return;
}



void png_set_swap_alpha(int param_1)

{
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x20000;
  }
  return;
}



void png_set_invert_alpha(int param_1)

{
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x80000;
  }
  return;
}



void png_set_invert_mono(int param_1)

{
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x20;
  }
  return;
}



void png_do_invert(int param_1,byte *param_2)

{
  ushort uVar1;
  int iVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  
  uVar1 = *(ushort *)(param_1 + 8);
  if ((char)uVar1 == '\x04') {
    if (uVar1 >> 8 == 0x10) {
      uVar3 = *(uint *)(param_1 + 4);
      if (uVar3 != 0) {
        uVar4 = 0;
        do {
          param_2[uVar4] = ~param_2[uVar4];
          uVar5 = uVar4 + 4;
          param_2[uVar4 + 1] = ~param_2[uVar4 + 1];
          uVar4 = uVar5;
        } while (uVar5 < uVar3);
      }
    }
    else if ((uVar1 >> 8 == 8) && (uVar3 = *(uint *)(param_1 + 4), uVar3 != 0)) {
      uVar4 = 0;
      do {
        param_2[uVar4] = ~param_2[uVar4];
        uVar4 = uVar4 + 2;
      } while (uVar4 < uVar3);
    }
  }
  else if ((char)uVar1 == '\0') {
    for (iVar2 = *(int *)(param_1 + 4); iVar2 != 0; iVar2 = iVar2 + -1) {
      *param_2 = ~*param_2;
      param_2 = param_2 + 1;
    }
  }
  return;
}



void png_do_swap(int *param_1,undefined1 *param_2)

{
  undefined1 uVar1;
  int iVar2;
  
  if (*(char *)((int)param_1 + 9) == '\x10') {
    iVar2 = *param_1 * (uint)*(byte *)((int)param_1 + 10);
    if (iVar2 == 0) {
      return;
    }
    do {
      uVar1 = *param_2;
      iVar2 = iVar2 + -1;
      *param_2 = param_2[1];
      param_2[1] = uVar1;
      param_2 = param_2 + 2;
    } while (iVar2 != 0);
  }
  return;
}



void png_do_packswap(int param_1,byte *param_2)

{
  byte bVar1;
  int iVar2;
  byte *pbVar3;
  byte *pbVar4;
  undefined *puVar5;
  
  bVar1 = *(byte *)(param_1 + 9);
  if (bVar1 < 8) {
    iVar2 = *(int *)(param_1 + 4);
    if (bVar1 == 1) {
      puVar5 = &DAT_00033459;
    }
    else if (bVar1 == 4) {
      puVar5 = &DAT_00033659;
    }
    else {
      if (bVar1 != 2) {
        return;
      }
      puVar5 = &DAT_00033559;
    }
    if (iVar2 < 1) {
      return;
    }
    pbVar3 = param_2;
    do {
      pbVar4 = pbVar3 + 1;
      *pbVar3 = puVar5[*pbVar3];
      pbVar3 = pbVar4;
    } while (pbVar4 < param_2 + iVar2);
  }
  return;
}



void png_do_strip_channel(int param_1,undefined1 *param_2,int param_3)

{
  undefined1 uVar1;
  undefined1 *puVar2;
  undefined1 *puVar3;
  undefined1 *puVar4;
  undefined1 *puVar5;
  int iVar7;
  undefined1 *puVar8;
  undefined1 *puVar6;
  
  iVar7 = *(int *)(param_1 + 4);
  puVar3 = param_2 + iVar7;
  puVar8 = param_2;
  if (*(char *)(param_1 + 10) == '\x04') {
    if (*(char *)(param_1 + 9) == '\x10') {
      puVar4 = param_2 + 2;
      if (param_3 == 0) {
        puVar8 = param_2 + 6;
        puVar4 = param_2 + 8;
      }
      if (puVar4 < puVar3) {
        iVar7 = (iVar7 + -1) - (int)puVar4;
        puVar2 = puVar8;
        do {
          *puVar2 = *puVar4;
          puVar2[1] = puVar4[1];
          puVar2[2] = puVar4[2];
          puVar2[3] = puVar4[3];
          puVar2[4] = puVar4[4];
          puVar6 = puVar4 + 5;
          puVar4 = puVar4 + 8;
          puVar2[5] = *puVar6;
          puVar2 = puVar2 + 6;
        } while (puVar4 < puVar3);
        puVar8 = puVar8 + ((uint)(param_2 + iVar7) >> 3) * 6 + 6;
      }
      uVar1 = 0x30;
    }
    else {
      if (*(char *)(param_1 + 9) != '\b') {
        return;
      }
      puVar4 = param_2 + 1;
      if (param_3 == 0) {
        puVar8 = param_2 + 3;
        puVar4 = param_2 + 4;
      }
      if (puVar4 < puVar3) {
        iVar7 = (iVar7 + -1) - (int)puVar4;
        puVar2 = puVar8;
        do {
          *puVar2 = *puVar4;
          puVar2[1] = puVar4[1];
          puVar6 = puVar4 + 2;
          puVar4 = puVar4 + 4;
          puVar2[2] = *puVar6;
          puVar2 = puVar2 + 3;
        } while (puVar4 < puVar3);
        puVar8 = puVar8 + ((uint)(param_2 + iVar7) >> 2) * 3 + 3;
      }
      uVar1 = 0x18;
    }
    *(undefined1 *)(param_1 + 0xb) = uVar1;
    *(undefined1 *)(param_1 + 10) = 3;
    if (*(char *)(param_1 + 8) != '\x06') goto LAB_00029d62;
    uVar1 = 2;
  }
  else {
    if (*(char *)(param_1 + 10) != '\x02') {
      return;
    }
    if (*(char *)(param_1 + 9) == '\x10') {
      puVar4 = param_2 + 2;
      if (param_3 == 0) {
        puVar4 = param_2 + 4;
        puVar8 = param_2 + 2;
      }
      if (puVar4 < puVar3) {
        iVar7 = (iVar7 + -1) - (int)puVar4;
        puVar2 = puVar8;
        do {
          *puVar2 = *puVar4;
          puVar6 = puVar4 + 1;
          puVar4 = puVar4 + 4;
          puVar2[1] = *puVar6;
          puVar2 = puVar2 + 2;
        } while (puVar4 < puVar3);
        puVar8 = puVar8 + ((uint)(param_2 + iVar7) >> 1 & 0x7ffffffe) + 2;
      }
      uVar1 = 0x10;
    }
    else {
      if (*(char *)(param_1 + 9) != '\b') {
        return;
      }
      puVar4 = param_2 + 1;
      if (param_3 == 0) {
        puVar4 = param_2 + 2;
        puVar8 = param_2 + 1;
      }
      if (puVar4 < puVar3) {
        puVar2 = puVar8;
        puVar6 = puVar4;
        do {
          puVar5 = puVar6 + 2;
          *puVar2 = *puVar6;
          puVar2 = puVar2 + 1;
          puVar6 = puVar5;
        } while (puVar5 < puVar3);
        puVar8 = puVar8 + ((uint)(param_2 + ((iVar7 + -1) - (int)puVar4)) >> 1) + 1;
      }
      uVar1 = 8;
    }
    *(undefined1 *)(param_1 + 0xb) = uVar1;
    *(undefined1 *)(param_1 + 10) = 1;
    if (*(char *)(param_1 + 8) != '\x04') goto LAB_00029d62;
    uVar1 = 0;
  }
  *(undefined1 *)(param_1 + 8) = uVar1;
LAB_00029d62:
  *(int *)(param_1 + 4) = (int)puVar8 - (int)param_2;
  return;
}



void png_do_bgr(int *param_1,undefined1 *param_2)

{
  undefined1 uVar1;
  ushort uVar2;
  int iVar3;
  
  uVar2 = *(ushort *)(param_1 + 2);
  if ((uVar2 & 2) != 0) {
    iVar3 = *param_1;
    if (uVar2 >> 8 == 0x10) {
      if ((uVar2 & 0xff) == 2) {
        if (iVar3 == 0) {
          return;
        }
        do {
          uVar1 = *param_2;
          iVar3 = iVar3 + -1;
          *param_2 = param_2[4];
          param_2[4] = uVar1;
          uVar1 = param_2[1];
          param_2[1] = param_2[5];
          param_2[5] = uVar1;
          param_2 = param_2 + 6;
        } while (iVar3 != 0);
      }
      else if ((uVar2 & 0xff) == 6) {
        for (; iVar3 != 0; iVar3 = iVar3 + -1) {
          uVar1 = *param_2;
          *param_2 = param_2[4];
          param_2[4] = uVar1;
          uVar1 = param_2[1];
          param_2[1] = param_2[5];
          param_2[5] = uVar1;
          param_2 = param_2 + 8;
        }
      }
    }
    else if (uVar2 >> 8 == 8) {
      if ((uVar2 & 0xff) == 2) {
        for (; iVar3 != 0; iVar3 = iVar3 + -1) {
          uVar1 = *param_2;
          *param_2 = param_2[2];
          param_2[2] = uVar1;
          param_2 = param_2 + 3;
        }
      }
      else if ((uVar2 & 0xff) == 6) {
        for (; iVar3 != 0; iVar3 = iVar3 + -1) {
          uVar1 = *param_2;
          *param_2 = param_2[2];
          param_2[2] = uVar1;
          param_2 = param_2 + 4;
        }
      }
    }
  }
  return;
}



void png_do_check_palette_indexes(int param_1,int *param_2)

{
  byte bVar1;
  int iVar2;
  byte *pbVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  byte *pbVar7;
  
  if (((*(ushort *)(param_1 + 0x1fc) != 0) &&
      (uVar4 = (uint)*(byte *)((int)param_2 + 9),
      (int)(uint)*(ushort *)(param_1 + 0x1fc) < 1 << uVar4)) && (uVar4 - 1 < 8)) {
    iVar2 = param_2[1];
    pbVar7 = *(byte **)(param_1 + 0x1e0);
    pbVar3 = pbVar7 + iVar2;
    uVar5 = -(uint)*(byte *)((int)param_2 + 0xb) * *param_2 & 7;
    switch(uVar4) {
    case 1:
      if (0 < iVar2) {
        do {
          if (*pbVar3 >> uVar5 != 0) {
            *(undefined4 *)(param_1 + 0x200) = 1;
          }
          pbVar3 = pbVar3 + -1;
          uVar5 = 0;
        } while (pbVar7 < pbVar3);
      }
      break;
    case 2:
      if (0 < iVar2) {
        uVar4 = *(uint *)(param_1 + 0x200);
        do {
          bVar1 = *pbVar3;
          uVar6 = bVar1 >> uVar5 & 3;
          if ((int)uVar4 < (int)uVar6) {
            *(uint *)(param_1 + 0x200) = uVar6;
            bVar1 = *pbVar3;
            uVar4 = uVar6;
          }
          uVar6 = ((uint)(bVar1 >> uVar5) << 0x1c) >> 0x1e;
          if ((int)uVar4 < (int)uVar6) {
            *(uint *)(param_1 + 0x200) = uVar6;
            bVar1 = *pbVar3;
            uVar4 = uVar6;
          }
          uVar6 = ((uint)(bVar1 >> uVar5) << 0x1a) >> 0x1e;
          if ((int)uVar4 < (int)uVar6) {
            *(uint *)(param_1 + 0x200) = uVar6;
            bVar1 = *pbVar3;
            uVar4 = uVar6;
          }
          pbVar3 = pbVar3 + -1;
          bVar1 = bVar1 >> uVar5;
          uVar5 = 0;
          uVar6 = ((uint)bVar1 << 0x18) >> 0x1e;
          if ((int)uVar4 < (int)uVar6) {
            *(uint *)(param_1 + 0x200) = uVar6;
            uVar4 = uVar6;
          }
        } while (pbVar7 < pbVar3);
      }
      break;
    case 4:
      if (0 < iVar2) {
        uVar4 = *(uint *)(param_1 + 0x200);
        do {
          bVar1 = *pbVar3;
          uVar6 = bVar1 >> uVar5 & 0xf;
          if ((int)uVar4 < (int)uVar6) {
            *(uint *)(param_1 + 0x200) = uVar6;
            bVar1 = *pbVar3;
            uVar4 = uVar6;
          }
          pbVar3 = pbVar3 + -1;
          bVar1 = bVar1 >> uVar5;
          uVar5 = 0;
          uVar6 = ((uint)bVar1 << 0x18) >> 0x1c;
          if ((int)uVar4 < (int)uVar6) {
            *(uint *)(param_1 + 0x200) = uVar6;
            uVar4 = uVar6;
          }
        } while (pbVar7 < pbVar3);
      }
      break;
    case 8:
      if (0 < iVar2) {
        uVar4 = *(uint *)(param_1 + 0x200);
        do {
          uVar5 = (uint)*pbVar3;
          pbVar3 = pbVar3 + -1;
          if ((int)uVar4 < (int)uVar5) {
            *(uint *)(param_1 + 0x200) = uVar5;
            uVar4 = uVar5;
          }
        } while (pbVar7 < pbVar3);
      }
    }
  }
  return;
}



void png_set_user_transform_info
               (int param_1,undefined4 param_2,undefined1 param_3,undefined1 param_4)

{
  byte bVar1;
  bool bVar2;
  
  if (param_1 != 0) {
    bVar1 = *(byte *)(param_1 + 0x131);
    bVar2 = (bVar1 & 0x80) != 0;
    if (bVar2) {
      bVar1 = *(byte *)(param_1 + 0x134);
    }
    if (bVar2 && (bVar1 & 0x40) != 0) {
      png_app_error(param_1,"info change after png_start_read_image or png_read_update_info");
      return;
    }
    *(undefined4 *)(param_1 + 0x128) = param_2;
    *(undefined1 *)(param_1 + 300) = param_3;
    *(undefined1 *)(param_1 + 0x12d) = param_4;
  }
  return;
}



undefined4 png_get_user_transform_ptr(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x128);
  }
  return uVar1;
}



undefined4 png_get_current_row_number(int param_1)

{
  undefined4 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 0xffffffff;
  }
  else {
    uVar1 = *(undefined4 *)(param_1 + 0x1d4);
  }
  return uVar1;
}



undefined1 png_get_current_pass_number(int param_1)

{
  undefined1 uVar1;
  
  if (param_1 == 0) {
    uVar1 = 8;
  }
  else {
    uVar1 = *(undefined1 *)(param_1 + 0x209);
  }
  return uVar1;
}



void png_write_data(int param_1)

{
  if (*(code **)(param_1 + 0x114) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x00029f72. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 0x114))();
    return;
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"Call to NULL write function");
}



void png_default_write_data(int param_1,void *param_2,size_t param_3)

{
  size_t sVar1;
  
  if ((param_1 != 0) &&
     (sVar1 = fwrite(param_2,1,param_3,*(FILE **)(param_1 + 0x11c)), sVar1 != param_3)) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"Write Error");
  }
  return;
}



void png_flush(int param_1)

{
  if (*(code **)(param_1 + 0x230) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x00029fb6. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 0x230))();
    return;
  }
  return;
}



void png_default_flush(int param_1)

{
  if (param_1 == 0) {
    return;
  }
  fflush(*(FILE **)(param_1 + 0x11c));
  return;
}



void png_set_write_fn(int param_1,undefined4 param_2,code *param_3,code *param_4)

{
  int iVar1;
  bool bVar2;
  
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x11c) = param_2;
    if (param_3 == (code *)0x0) {
      param_3 = png_default_write_data;
    }
    *(code **)(param_1 + 0x114) = param_3;
    if (param_4 == (code *)0x0) {
      param_4 = png_default_flush;
    }
    *(code **)(param_1 + 0x230) = param_4;
    iVar1 = *(int *)(param_1 + 0x118);
    bVar2 = iVar1 != 0;
    if (bVar2) {
      iVar1 = 0;
    }
    if (bVar2) {
      *(int *)(param_1 + 0x118) = iVar1;
    }
  }
  return;
}



void png_write_info_before_PLTE(int param_1,undefined4 *param_2)

{
  ushort uVar1;
  uint uVar2;
  bool bVar3;
  
  if (((param_1 != 0) && (param_2 != (undefined4 *)0x0)) && ((*(byte *)(param_1 + 0x131) & 4) == 0))
  {
    png_write_sig(param_1);
    uVar2 = (uint)*(byte *)(param_1 + 0x131);
    bVar3 = (*(byte *)(param_1 + 0x131) & 0x10) != 0;
    if (bVar3) {
      uVar2 = *(uint *)(param_1 + 0x304);
    }
    if (bVar3 && uVar2 != 0) {
      *(undefined4 *)(param_1 + 0x304) = 0;
    }
    uVar2 = param_2[6];
    png_write_IHDR(param_1,*param_2,param_2[1],uVar2 & 0xff,(uVar2 << 0x10) >> 0x18,
                   (uVar2 << 8) >> 0x18,uVar2 >> 0x18,*(undefined1 *)(param_2 + 7));
    uVar1 = *(ushort *)((int)param_2 + 0x72);
    if (((uVar1 & 0x8008) == 8) && ((*(byte *)(param_2 + 2) & 1) != 0)) {
      png_write_gAMA_fixed(param_1,param_2[10]);
      uVar1 = *(ushort *)((int)param_2 + 0x72);
    }
    if (-1 < (short)uVar1) {
      uVar2 = param_2[2] & 0x800;
      if ((param_2[2] & 0x1000) == 0) {
        if (uVar2 != 0) {
          png_write_sRGB(param_1,*(undefined2 *)(param_2 + 0x1c));
        }
      }
      else {
        if (uVar2 != 0) {
          png_app_warning(param_1,"profile matches sRGB but writing iCCP instead");
        }
        png_write_iCCP(param_1,param_2[0x1d],param_2[0x1e]);
      }
    }
    if ((*(byte *)(param_2 + 2) & 2) != 0) {
      png_write_sBIT(param_1,param_2 + 0x25,*(undefined1 *)((int)param_2 + 0x19));
    }
    if (((*(ushort *)((int)param_2 + 0x72) & 0x8010) == 0x10) && ((*(byte *)(param_2 + 2) & 4) != 0)
       ) {
      png_write_cHRM_fixed(param_1,param_2 + 0xb);
    }
    FUN_0002a114(param_1,param_2,1);
    *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 0x400;
  }
  return;
}



void FUN_0002a114(int param_1,int param_2,byte param_3)

{
  int iVar1;
  uint uVar2;
  uint uVar3;
  
  if (0 < *(int *)(param_2 + 0xf0)) {
    uVar2 = *(uint *)(param_2 + 0xec);
    uVar3 = uVar2 + *(int *)(param_2 + 0xf0) * 0x14;
    do {
      if ((((*(byte *)(uVar2 + 0x10) & param_3) != 0) &&
          (iVar1 = png_handle_as_unknown(param_1,uVar2), iVar1 != 1)) &&
         (((iVar1 == 3 || ((*(byte *)(uVar2 + 3) & 0x20) != 0)) ||
          ((iVar1 == 0 && (*(int *)(param_1 + 0x2f0) == 3)))))) {
        png_write_chunk(param_1,uVar2,*(undefined4 *)(uVar2 + 8),*(undefined4 *)(uVar2 + 0xc));
      }
      uVar2 = uVar2 + 0x14;
    } while (uVar2 < uVar3);
  }
  return;
}



void png_write_info(int param_1,int param_2)

{
  code *pcVar1;
  uint uVar2;
  undefined4 *puVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  
  if (param_1 == 0 || param_2 == 0) {
    return;
  }
  png_write_info_before_PLTE(param_1,param_2);
  uVar2 = *(uint *)(param_2 + 8);
  if ((uVar2 & 8) == 0) {
    if (*(char *)(param_2 + 0x19) == '\x03') {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Valid palette required for paletted images");
    }
  }
  else {
    png_write_PLTE(param_1,*(undefined4 *)(param_2 + 0x10),*(undefined2 *)(param_2 + 0x14));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x10) != 0) {
    if (((*(byte *)(param_1 + 0x13a) & 8) != 0) && (*(char *)(param_2 + 0x19) == '\x03')) {
      uVar2 = (uint)*(ushort *)(param_2 + 0x16);
      if (0x100 < uVar2) {
        uVar2 = 0x100;
      }
      if (uVar2 != 0) {
        iVar4 = 0;
        do {
          *(byte *)(*(int *)(param_2 + 0x9c) + iVar4) = ~*(byte *)(*(int *)(param_2 + 0x9c) + iVar4)
          ;
          iVar6 = iVar4 + 1;
          if (SBORROW4(iVar6,iVar4)) goto LAB_0002a3b6;
          iVar4 = iVar6;
        } while (iVar6 < (int)uVar2);
      }
    }
    png_write_tRNS(param_1,*(undefined4 *)(param_2 + 0x9c),param_2 + 0xa0,
                   *(undefined2 *)(param_2 + 0x16),*(undefined1 *)(param_2 + 0x19));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x20) != 0) {
    png_write_bKGD(param_1,param_2 + 0xaa,*(undefined1 *)(param_2 + 0x19));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x40) != 0) {
    png_write_hIST(param_1,*(undefined4 *)(param_2 + 0xcc),*(undefined2 *)(param_2 + 0x14));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x100) != 0) {
    png_write_oFFs(param_1,*(undefined4 *)(param_2 + 0xb4),*(undefined4 *)(param_2 + 0xb8),
                   *(undefined1 *)(param_2 + 0xbc));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x400) != 0) {
    png_write_pCAL(param_1,*(undefined4 *)(param_2 + 0xd0),*(undefined4 *)(param_2 + 0xd4),
                   *(undefined4 *)(param_2 + 0xd8),(char)*(ushort *)(param_2 + 0xe4),
                   *(ushort *)(param_2 + 0xe4) >> 8,*(undefined4 *)(param_2 + 0xdc),
                   *(undefined4 *)(param_2 + 0xe0));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x4000) != 0) {
    png_write_sCAL_s(param_1,*(undefined1 *)(param_2 + 0xfc),*(undefined4 *)(param_2 + 0x100),
                     *(undefined4 *)(param_2 + 0x104));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x80) != 0) {
    png_write_pHYs(param_1,*(undefined4 *)(param_2 + 0xc0),*(undefined4 *)(param_2 + 0xc4),
                   *(undefined1 *)(param_2 + 200));
    uVar2 = *(uint *)(param_2 + 8);
  }
  if ((uVar2 & 0x200) != 0) {
    png_write_tIME(param_1,param_2 + 0x8c);
    *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 0x200;
    uVar2 = *(uint *)(param_2 + 8);
  }
  if (((uVar2 & 0x2000) != 0) && (0 < *(int *)(param_2 + 0xf8))) {
    iVar4 = 0;
    do {
      png_write_sPLT(param_1,*(int *)(param_2 + 0xf4) + iVar4 * 0x10);
      iVar6 = iVar4 + 1;
      if (SBORROW4(iVar6,iVar4)) goto LAB_0002a3b6;
      iVar4 = iVar6;
    } while (iVar6 < *(int *)(param_2 + 0xf8));
  }
  if (0 < *(int *)(param_2 + 0x80)) {
    iVar4 = 0;
    do {
      iVar6 = *(int *)(param_2 + 0x88);
      iVar5 = *(int *)(iVar6 + iVar4 * 0x1c);
      if (iVar5 < 1) {
        if (iVar5 == -1) {
          iVar6 = iVar6 + iVar4 * 0x1c;
          png_write_tEXt(param_1,*(undefined4 *)(iVar6 + 4),*(undefined4 *)(iVar6 + 8),0);
          *(undefined4 *)(*(int *)(param_2 + 0x88) + iVar4 * 0x1c) = 0xfffffffd;
        }
        else if (iVar5 == 0) {
          iVar6 = iVar6 + iVar4 * 0x1c;
          png_write_zTXt(param_1,*(undefined4 *)(iVar6 + 4),*(undefined4 *)(iVar6 + 8),0);
          *(undefined4 *)(*(int *)(param_2 + 0x88) + iVar4 * 0x1c) = 0xfffffffe;
        }
      }
      else {
        iVar6 = iVar6 + iVar4 * 0x1c;
        png_write_iTXt(param_1,iVar5,*(undefined4 *)(iVar6 + 4),*(undefined4 *)(iVar6 + 0x14),
                       *(undefined4 *)(iVar6 + 0x18),*(undefined4 *)(iVar6 + 8));
        puVar3 = (undefined4 *)(*(int *)(param_2 + 0x88) + iVar4 * 0x1c);
        if (*(int *)(*(int *)(param_2 + 0x88) + iVar4 * 0x1c) == -1) {
          *puVar3 = 0xfffffffd;
        }
        else {
          *puVar3 = 0xfffffffe;
        }
      }
      iVar6 = iVar4 + 1;
      if (SBORROW4(iVar6,iVar4)) {
LAB_0002a3b6:
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x2a3b6);
        (*pcVar1)();
      }
      iVar4 = iVar6;
    } while (iVar6 < *(int *)(param_2 + 0x80));
  }
  FUN_0002a114(param_1,param_2,2);
  return;
}



void png_write_end(int param_1,int param_2)

{
  code *pcVar1;
  int iVar2;
  undefined4 *puVar3;
  int iVar4;
  int iVar5;
  
  if (param_1 == 0) {
    return;
  }
  if ((*(byte *)(param_1 + 0x130) & 4) != 0) {
    if ((int)(uint)*(ushort *)(param_1 + 0x1fc) < *(int *)(param_1 + 0x200)) {
      png_benign_error(param_1,"Wrote palette index exceeding num_palette");
    }
    if (param_2 != 0) {
      if (((*(byte *)(param_2 + 9) & 2) != 0) && ((*(byte *)(param_1 + 0x131) & 2) == 0)) {
        png_write_tIME(param_1,param_2 + 0x8c);
      }
      if (0 < *(int *)(param_2 + 0x80)) {
        iVar5 = 0;
        do {
          iVar2 = *(int *)(param_2 + 0x88);
          iVar4 = *(int *)(iVar2 + iVar5 * 0x1c);
          if (iVar4 < 1) {
            if (iVar4 < 0) {
              if (iVar4 == -1) {
                iVar2 = iVar2 + iVar5 * 0x1c;
                png_write_tEXt(param_1,*(undefined4 *)(iVar2 + 4),*(undefined4 *)(iVar2 + 8),0);
                *(undefined4 *)(*(int *)(param_2 + 0x88) + iVar5 * 0x1c) = 0xfffffffd;
              }
            }
            else {
              iVar2 = iVar2 + iVar5 * 0x1c;
              png_write_zTXt(param_1,*(undefined4 *)(iVar2 + 4),*(undefined4 *)(iVar2 + 8),iVar4);
              *(undefined4 *)(*(int *)(param_2 + 0x88) + iVar5 * 0x1c) = 0xfffffffe;
            }
          }
          else {
            iVar2 = iVar2 + iVar5 * 0x1c;
            png_write_iTXt(param_1,iVar4,*(undefined4 *)(iVar2 + 4),*(undefined4 *)(iVar2 + 0x14),
                           *(undefined4 *)(iVar2 + 0x18),*(undefined4 *)(iVar2 + 8));
            puVar3 = (undefined4 *)(*(int *)(param_2 + 0x88) + iVar5 * 0x1c);
            if (*(int *)(*(int *)(param_2 + 0x88) + iVar5 * 0x1c) == -1) {
              *puVar3 = 0xfffffffd;
            }
            else {
              *puVar3 = 0xfffffffe;
            }
          }
          iVar2 = iVar5 + 1;
          if (SBORROW4(iVar2,iVar5)) {
                    // WARNING: Does not return
            pcVar1 = (code *)software_udf(0xfe,0x2a4e0);
            (*pcVar1)();
          }
          iVar5 = iVar2;
        } while (iVar2 < *(int *)(param_2 + 0x80));
      }
      FUN_0002a114(param_1,param_2,8);
    }
    *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 8;
    png_write_IEND(param_1);
    return;
  }
                    // WARNING: Subroutine does not return
  png_error(param_1,"No IDATs written into file");
}



void png_convert_from_struct_tm(undefined2 *param_1,undefined4 *param_2)

{
  code *pcVar1;
  int iVar2;
  
  iVar2 = param_2[5] + 0x76c;
  if (!SBORROW4(iVar2,param_2[5])) {
    *param_1 = (short)iVar2;
    iVar2 = param_2[4] + 1;
    if (!SBORROW4(iVar2,param_2[4])) {
      *(char *)(param_1 + 1) = (char)iVar2;
      *(char *)((int)param_1 + 3) = (char)param_2[3];
      *(char *)(param_1 + 2) = (char)param_2[2];
      *(char *)((int)param_1 + 5) = (char)param_2[1];
      *(char *)(param_1 + 3) = (char)*param_2;
      return;
    }
  }
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x2a530);
  (*pcVar1)();
}



void png_convert_from_time_t(undefined4 param_1,time_t param_2)

{
  tm *ptVar1;
  time_t local_10;
  int local_c;
  
  local_c = __stack_chk_guard;
  local_10 = param_2;
  ptVar1 = gmtime(&local_10);
  png_convert_from_struct_tm(param_1,ptVar1);
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_create_write_struct(void)

{
  png_create_write_struct_2();
  return;
}



int png_create_write_struct_2(void)

{
  int iVar1;
  undefined4 in_stack_00000000;
  undefined4 in_stack_00000004;
  undefined4 in_stack_00000008;
  
  iVar1 = png_create_png_struct();
  if (iVar1 != 0) {
    *(undefined4 *)(iVar1 + 0x17c) = 0x2000;
    *(undefined4 *)(iVar1 + 400) = 1;
    *(undefined4 *)(iVar1 + 0x180) = 0xffffffff;
    *(undefined4 *)(iVar1 + 0x18c) = 8;
    *(undefined4 *)(iVar1 + 0x184) = 8;
    *(undefined4 *)(iVar1 + 0x188) = 0xf;
    *(undefined4 *)(iVar1 + 0x1a0) = 8;
    *(undefined4 *)(iVar1 + 0x1a4) = 0;
    *(undefined4 *)(iVar1 + 0x194) = 0xffffffff;
    *(undefined4 *)(iVar1 + 0x198) = 8;
    *(undefined4 *)(iVar1 + 0x19c) = 0xf;
    png_set_write_fn(iVar1,0,0,0,in_stack_00000000,in_stack_00000004,in_stack_00000008);
  }
  return iVar1;
}



void png_write_rows(int param_1,undefined4 *param_2,int param_3)

{
  if ((param_1 != 0) && (param_3 != 0)) {
    do {
      png_write_row(param_1,*param_2);
      param_3 = param_3 + -1;
      param_2 = param_2 + 1;
    } while (param_3 != 0);
  }
  return;
}



void png_write_row(int param_1,undefined4 param_2,uint param_3)

{
  byte bVar1;
  uint uVar2;
  int iVar3;
  char *pcVar4;
  undefined1 *puVar5;
  int iVar6;
  int iVar7;
  bool bVar8;
  int local_24;
  uint local_20;
  undefined2 local_1c;
  char local_1a;
  byte local_19;
  int local_18;
  
  local_18 = __stack_chk_guard;
  if (param_1 == 0) goto LAB_0002a85e;
  if ((*(int *)(param_1 + 0x1d4) == 0) && (*(char *)(param_1 + 0x209) == '\0')) {
    if ((*(byte *)(param_1 + 0x131) & 4) == 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"png_write_info was never called before png_write_row");
    }
    png_write_start_row(param_1);
  }
  uVar2 = *(uint *)(param_1 + 0x208);
  bVar8 = (uVar2 & 0xff) == 0;
  if (!bVar8) {
    param_3 = (uint)*(byte *)(param_1 + 0x138);
  }
  if (bVar8 || (param_3 & 2) == 0) goto switchD_0002a652_default;
  switch((uVar2 << 0x10) >> 0x18) {
  case 0:
    bVar1 = *(byte *)(param_1 + 0x1d4) & 7;
    goto joined_r0x0002a6d4;
  case 1:
    if (((*(byte *)(param_1 + 0x1d4) & 7) == 0) && (4 < *(uint *)(param_1 + 0x1bc))) break;
    goto LAB_0002a7a6;
  case 2:
    if ((*(uint *)(param_1 + 0x1d4) & 7) != 4) goto LAB_0002a7a6;
    break;
  case 3:
    if (((*(byte *)(param_1 + 0x1d4) & 3) != 0) || (*(uint *)(param_1 + 0x1bc) < 3))
    goto LAB_0002a7a6;
    break;
  case 4:
    if ((*(uint *)(param_1 + 0x1d4) & 3) != 2) goto LAB_0002a7a6;
    break;
  case 5:
    if (((*(byte *)(param_1 + 0x1d4) & 1) != 0) || (*(uint *)(param_1 + 0x1bc) < 2))
    goto LAB_0002a7a6;
    break;
  case 6:
    bVar1 = *(byte *)(param_1 + 0x1d4) & 1;
joined_r0x0002a6d4:
    if (bVar1 != 0) break;
    goto LAB_0002a7a6;
  }
switchD_0002a652_default:
  local_1a = *(char *)(param_1 + 0x210);
  local_24 = *(int *)(param_1 + 0x1c8);
  local_19 = *(char *)(param_1 + 0x20d) * local_1a;
  local_1c = CONCAT11(*(char *)(param_1 + 0x20d),(char)(uVar2 >> 0x18));
  if (local_19 < 8) {
    local_20 = (uint)local_19 * local_24 + 7 >> 3;
  }
  else {
    local_20 = (uint)(local_19 >> 3) * local_24;
  }
  __aeabi_memcpy(*(int *)(param_1 + 0x1e0) + 1,param_2);
  if (((((*(ushort *)(param_1 + 0x208) & 0xff) != 0) && (*(ushort *)(param_1 + 0x208) >> 8 < 6)) &&
      ((*(byte *)(param_1 + 0x138) & 2) != 0)) &&
     (png_do_write_interlace(&local_24,*(int *)(param_1 + 0x1e0) + 1), local_24 == 0)) {
LAB_0002a7a6:
    png_write_finish_row(param_1);
    goto LAB_0002a85e;
  }
  if (*(int *)(param_1 + 0x138) != 0) {
    png_do_write_transformations(param_1,&local_24);
  }
  bVar1 = *(byte *)(param_1 + 0x20e);
  bVar8 = local_19 != bVar1;
  if (!bVar8) {
    bVar1 = *(byte *)(param_1 + 0x213);
  }
  if (bVar8 || local_19 != bVar1) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"internal write transform logic error");
  }
  if ((((*(byte *)(param_1 + 0x304) & 4) != 0) && (*(char *)(param_1 + 0x308) == '@')) &&
     ((local_1c & 2) != 0)) {
    if (local_1c >> 8 == 0x10) {
      if ((local_1c & 0xff) == 2) {
        iVar6 = 6;
      }
      else {
        if ((local_1c & 0xff) != 6) goto LAB_0002a82c;
        iVar6 = 8;
      }
      if (local_24 != 0) {
        puVar5 = (undefined1 *)(*(int *)(param_1 + 0x1e0) + 6);
        iVar3 = local_24;
        do {
          iVar3 = iVar3 + -1;
          iVar7 = (uint)CONCAT11(puVar5[-5],puVar5[-4]) - (uint)CONCAT11(puVar5[-3],puVar5[-2]);
          puVar5[-5] = (char)((uint)iVar7 >> 8);
          puVar5[-4] = (char)iVar7;
          iVar7 = (uint)CONCAT11(puVar5[-1],*puVar5) - (uint)CONCAT11(puVar5[-3],puVar5[-2]);
          puVar5[-1] = (char)((uint)iVar7 >> 8);
          *puVar5 = (char)iVar7;
          puVar5 = puVar5 + iVar6;
        } while (iVar3 != 0);
      }
    }
    else if (local_1c >> 8 == 8) {
      if ((local_1c & 0xff) == 2) {
        iVar6 = 3;
      }
      else {
        if ((local_1c & 0xff) != 6) goto LAB_0002a82c;
        iVar6 = 4;
      }
      if (local_24 != 0) {
        pcVar4 = (char *)(*(int *)(param_1 + 0x1e0) + 1);
        iVar3 = local_24;
        do {
          iVar3 = iVar3 + -1;
          *pcVar4 = *pcVar4 - pcVar4[1];
          pcVar4[2] = pcVar4[2] - pcVar4[1];
          pcVar4 = pcVar4 + iVar6;
        } while (iVar3 != 0);
      }
    }
  }
LAB_0002a82c:
  if (((char)local_1c == '\x03') && (-1 < *(int *)(param_1 + 0x200))) {
    png_do_check_palette_indexes(param_1,&local_24);
  }
  png_write_find_filter(param_1,&local_24);
  if (*(code **)(param_1 + 0x27c) != (code *)0x0) {
    (**(code **)(param_1 + 0x27c))
              (param_1,*(undefined4 *)(param_1 + 0x1d4),*(undefined1 *)(param_1 + 0x209));
  }
LAB_0002a85e:
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_image(int param_1,int param_2)

{
  code *pcVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  uint uVar5;
  int iVar6;
  bool bVar7;
  
  if ((param_1 != 0) && (iVar2 = png_set_interlace_handling(param_1), 0 < iVar2)) {
    uVar3 = *(uint *)(param_1 + 0x1c0);
    iVar6 = 0;
    do {
      bVar7 = uVar3 != 0;
      uVar5 = 0;
      uVar3 = 0;
      if (bVar7) {
        do {
          png_write_row(param_1,*(undefined4 *)(param_2 + uVar5 * 4));
          uVar3 = *(uint *)(param_1 + 0x1c0);
          uVar5 = uVar5 + 1;
        } while (uVar5 < uVar3);
      }
      iVar4 = iVar6 + 1;
      if (SBORROW4(iVar4,iVar6)) {
                    // WARNING: Does not return
        pcVar1 = (code *)software_udf(0xfe,0x2a8ec);
        (*pcVar1)();
      }
      iVar6 = iVar4;
    } while (iVar4 < iVar2);
  }
  return;
}



void png_set_flush(int param_1,int param_2)

{
  if (param_1 != 0) {
    if (param_2 < 0) {
      param_2 = 0;
    }
    *(int *)(param_1 + 0x234) = param_2;
  }
  return;
}



void png_write_flush(int param_1)

{
  if ((param_1 != 0) && (*(uint *)(param_1 + 0x1d4) < *(uint *)(param_1 + 0x1c4))) {
    png_compress_IDAT(param_1,0,0,2);
    *(undefined4 *)(param_1 + 0x238) = 0;
    png_flush(param_1);
    return;
  }
  return;
}



void png_destroy_write_struct(int *param_1)

{
  int iVar1;
  
  if ((param_1 != (int *)0x0) && (iVar1 = *param_1, iVar1 != 0)) {
    png_destroy_info_struct(iVar1);
    *param_1 = 0;
    if ((*(byte *)(iVar1 + 0x134) & 2) != 0) {
      deflateEnd(iVar1 + 0x140);
    }
    png_free_buffer_list(iVar1,iVar1 + 0x178);
    png_free(iVar1,*(undefined4 *)(iVar1 + 0x1e0));
    *(undefined4 *)(iVar1 + 0x1e0) = 0;
    png_free(iVar1,*(undefined4 *)(iVar1 + 0x1dc));
    png_free(iVar1,*(undefined4 *)(iVar1 + 0x1e4));
    png_free(iVar1,*(undefined4 *)(iVar1 + 0x1e8));
    *(undefined4 *)(iVar1 + 0x1dc) = 0;
    *(undefined4 *)(iVar1 + 0x1e4) = 0;
    *(undefined4 *)(iVar1 + 0x1e8) = 0;
    png_free(iVar1,*(undefined4 *)(iVar1 + 0x2f8));
    *(undefined4 *)(iVar1 + 0x2f8) = 0;
    png_destroy_png_struct(iVar1);
    return;
  }
  return;
}



void png_set_filter(int param_1,int param_2,uint param_3)

{
  int iVar1;
  undefined4 uVar2;
  undefined1 uVar3;
  uint uVar4;
  
  uVar3 = (undefined1)param_3;
  if (param_1 != 0) {
    if ((param_2 != 0) && (((uint)(param_2 == 0x40) & (*(byte *)(param_1 + 0x304) & 4) >> 2) != 1))
    {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Unknown custom filter method");
    }
    switch(param_3 & 0xff) {
    case 1:
      *(undefined1 *)(param_1 + 0x20a) = 0x10;
      break;
    case 2:
      *(undefined1 *)(param_1 + 0x20a) = 0x20;
      break;
    case 3:
      *(undefined1 *)(param_1 + 0x20a) = 0x40;
      break;
    case 4:
      *(undefined1 *)(param_1 + 0x20a) = 0x80;
      break;
    case 5:
    case 6:
    case 7:
      png_app_error(param_1,"Unknown row filter for method 0");
    case 0:
      *(undefined1 *)(param_1 + 0x20a) = 8;
      break;
    default:
      *(undefined1 *)(param_1 + 0x20a) = uVar3;
    }
    if (*(int *)(param_1 + 0x1e0) != 0) {
      iVar1 = *(int *)(param_1 + 0x1bc);
      if (*(int *)(param_1 + 0x1c0) == 1) {
        param_3 = param_3 & 0xffffff1f;
      }
      if (iVar1 == 1) {
        param_3 = param_3 & 0xffffff2f;
      }
      if (((param_3 & 0xe0) != 0) && (*(int *)(param_1 + 0x1dc) == 0)) {
        png_app_warning(param_1,"png_set_filter: UP/AVG/PAETH cannot be added after start");
        iVar1 = *(int *)(param_1 + 0x1bc);
        param_3 = param_3 & 0xffffff1f;
      }
      uVar3 = (undefined1)param_3;
      uVar4 = (uint)*(byte *)(param_1 + 0x20d) * (uint)*(byte *)(param_1 + 0x210);
      if (uVar4 < 8) {
        uVar4 = uVar4 * iVar1 + 7 >> 3;
      }
      else {
        uVar4 = (uVar4 >> 3) * iVar1;
      }
      if (*(int *)(param_1 + 0x1e4) == 0) {
        uVar2 = png_malloc(param_1,uVar4 + 1);
        *(undefined4 *)(param_1 + 0x1e4) = uVar2;
      }
      if ((1 < (uint)(((-((int)(param_3 << 0x1b) >> 0x1f) - ((int)(param_3 << 0x1a) >> 0x1f)) -
                      ((int)(param_3 << 0x19) >> 0x1f)) - ((int)(param_3 << 0x18) >> 0x1f))) &&
         (*(int *)(param_1 + 0x1e8) == 0)) {
        uVar2 = png_malloc(param_1,uVar4 + 1);
        *(undefined4 *)(param_1 + 0x1e8) = uVar2;
      }
    }
    *(undefined1 *)(param_1 + 0x20a) = uVar3;
  }
  return;
}



void png_set_filter_heuristics_fixed(void)

{
  return;
}



void png_set_compression_level(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x180) = param_2;
  }
  return;
}



void png_set_compression_mem_level(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x18c) = param_2;
  }
  return;
}



void png_set_compression_strategy(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 1;
    *(undefined4 *)(param_1 + 400) = param_2;
  }
  return;
}



void png_set_compression_window_bits(int param_1,int param_2)

{
  int iVar1;
  
  if (param_1 != 0) {
    iVar1 = param_2;
    if (param_2 < 8) {
      iVar1 = 8;
    }
    if (0xf < param_2) {
      iVar1 = 0xf;
    }
    *(int *)(param_1 + 0x188) = iVar1;
  }
  return;
}



void png_set_compression_method(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x184) = param_2;
  }
  return;
}



void png_set_text_compression_level(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x194) = param_2;
  }
  return;
}



void png_set_text_compression_mem_level(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x1a0) = param_2;
  }
  return;
}



void png_set_text_compression_strategy(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x1a4) = param_2;
  }
  return;
}



void png_set_text_compression_window_bits(int param_1,int param_2)

{
  int iVar1;
  
  if (param_1 != 0) {
    iVar1 = param_2;
    if (param_2 < 8) {
      iVar1 = 8;
    }
    if (0xf < param_2) {
      iVar1 = 0xf;
    }
    *(int *)(param_1 + 0x19c) = iVar1;
  }
  return;
}



void png_set_text_compression_method(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x198) = param_2;
  }
  return;
}



void png_set_write_status_fn(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x27c) = param_2;
  }
  return;
}



void png_set_write_user_transform_fn(int param_1,undefined4 param_2)

{
  if (param_1 != 0) {
    *(uint *)(param_1 + 0x138) = *(uint *)(param_1 + 0x138) | 0x100000;
    *(undefined4 *)(param_1 + 0x124) = param_2;
  }
  return;
}



void png_write_png(int param_1,int param_2,uint param_3)

{
  byte bVar1;
  undefined4 uVar2;
  bool bVar3;
  
  if ((param_1 == 0) || (param_2 == 0)) {
    return;
  }
  if ((*(byte *)(param_2 + 9) & 0x80) == 0) {
    png_app_error(param_1,"no rows for png_write_image to write");
    return;
  }
  bVar1 = png_write_info(param_1,param_2);
  if ((param_3 & 0x20) != 0) {
    bVar1 = png_set_invert_mono();
  }
  bVar3 = (param_3 & 0x40) != 0;
  if (bVar3) {
    bVar1 = *(byte *)(param_2 + 8);
  }
  if (bVar3 && (bVar1 & 2) != 0) {
    png_set_shift(param_1,param_2 + 0x94);
  }
  if ((param_3 & 4) != 0) {
    png_set_packing(param_1);
  }
  if ((param_3 & 0x100) != 0) {
    png_set_swap_alpha(param_1);
  }
  if ((param_3 & 0x1800) != 0) {
    if ((param_3 & 0x1000) == 0) {
      if ((param_3 & 0x800) == 0) goto LAB_0002ac04;
      uVar2 = 0;
    }
    else {
      if ((param_3 & 0x800) != 0) {
        png_app_error(param_1,"PNG_TRANSFORM_STRIP_FILLER: BEFORE+AFTER not supported");
      }
      uVar2 = 1;
    }
    png_set_filler(param_1,0,uVar2);
  }
LAB_0002ac04:
  if ((param_3 & 0x80) != 0) {
    png_set_bgr(param_1);
  }
  if ((param_3 & 0x200) != 0) {
    png_set_swap(param_1);
  }
  if ((param_3 & 8) != 0) {
    png_set_packswap(param_1);
  }
  if ((param_3 & 0x400) != 0) {
    png_set_invert_alpha(param_1);
  }
  png_write_image(param_1,*(undefined4 *)(param_2 + 0x108));
  png_write_end(param_1,param_2);
  return;
}



void png_image_write_to_memory
               (int param_1,int param_2,undefined4 *param_3,undefined4 param_4,int param_5,
               undefined4 param_6,undefined4 param_7)

{
  int iVar1;
  char *pcVar2;
  int local_58;
  int iStack_54;
  undefined4 local_50;
  undefined4 uStack_4c;
  undefined4 local_48;
  int local_38;
  undefined4 local_34;
  undefined4 local_30;
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (param_1 == 0) {
LAB_0002acf0:
    if (__stack_chk_guard - local_28 == 0) {
      return;
    }
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  if (*(int *)(param_1 + 4) == 1) {
    if (param_3 != (undefined4 *)0x0 && param_5 != 0) {
      if (param_2 == 0) {
        *param_3 = 0;
      }
      iVar1 = FUN_0002ad58(param_1);
      if (iVar1 != 0) {
        __aeabi_memclr8(&local_58,0x28);
        iStack_54 = param_5;
        local_50 = param_6;
        uStack_4c = param_7;
        local_34 = *param_3;
        local_30 = 0;
        local_58 = param_1;
        local_48 = param_4;
        local_38 = param_2;
        iVar1 = png_safe_execute(param_1,0x2adfd,&local_58);
        png_image_free(param_1);
        if (iVar1 != 0) {
          *param_3 = local_30;
        }
      }
      goto LAB_0002acf0;
    }
    pcVar2 = "png_image_write_to_memory: invalid argument";
  }
  else {
    pcVar2 = "png_image_write_to_memory: incorrect PNG_IMAGE_VERSION";
  }
  png_image_error(param_1,pcVar2);
  return;
}



void FUN_0002ad58(undefined4 *param_1)

{
  int iVar1;
  int iVar2;
  int *piVar3;
  int local_20;
  int local_1c;
  int local_18;
  
  local_18 = __stack_chk_guard;
  iVar1 = png_create_write_struct_2("1.6.22beta03",param_1,png_safe_error,0,0,0,0);
  local_1c = iVar1;
  if (iVar1 != 0) {
    iVar2 = png_create_info_struct(iVar1);
    local_20 = iVar2;
    if (iVar2 != 0) {
      piVar3 = (int *)png_malloc_warn(iVar1,0x18);
      if (piVar3 != (int *)0x0) {
        __aeabi_memclr4(piVar3,0x18);
        *piVar3 = iVar1;
        piVar3[1] = iVar2;
        *(undefined1 *)(piVar3 + 5) = 1;
        *param_1 = piVar3;
        goto LAB_0002add2;
      }
      png_destroy_info_struct(iVar1,&local_20);
    }
    png_destroy_write_struct(&local_1c,0);
  }
  png_image_error(param_1,"png_image_write_: out of memory");
LAB_0002add2:
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void FUN_0002adfc(undefined4 *param_1)

{
  png_set_write_fn(**(undefined4 **)*param_1,param_1,&LAB_0002b66c_1,&DAT_0002b69d);
  FUN_0002aef8(param_1);
  return;
}



void png_image_write_to_stdio
               (undefined4 *param_1,int param_2,undefined4 param_3,int param_4,undefined4 param_5,
               undefined4 param_6)

{
  int iVar1;
  char *pcVar2;
  undefined4 *local_50;
  int iStack_4c;
  undefined4 local_48;
  undefined4 uStack_44;
  undefined4 local_40;
  int local_20;
  
  local_20 = __stack_chk_guard;
  if (param_1 == (undefined4 *)0x0) {
LAB_0002ae90:
    if (__stack_chk_guard - local_20 == 0) {
      return;
    }
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_20);
  }
  if (param_1[1] == 1) {
    if ((param_2 != 0) && (param_4 != 0)) {
      iVar1 = FUN_0002ad58(param_1);
      if (iVar1 != 0) {
        *(int *)(*(int *)*param_1 + 0x11c) = param_2;
        __aeabi_memclr8(&local_50,0x2c);
        local_48 = param_5;
        uStack_44 = param_6;
        local_50 = param_1;
        iStack_4c = param_4;
        local_40 = param_3;
        png_safe_execute(param_1,0x2aef9,&local_50);
        png_image_free(param_1);
      }
      goto LAB_0002ae90;
    }
    pcVar2 = "png_image_write_to_stdio: invalid argument";
  }
  else {
    pcVar2 = "png_image_write_to_stdio: incorrect PNG_IMAGE_VERSION";
  }
  png_image_error(param_1,pcVar2);
  return;
}



void FUN_0002aef8(int *param_1)

{
  code *pcVar1;
  char cVar2;
  ushort uVar3;
  int iVar4;
  undefined1 uVar5;
  uint uVar6;
  undefined4 uVar7;
  undefined4 *puVar8;
  uint uVar9;
  int iVar10;
  int iVar11;
  uint uVar12;
  int iVar13;
  uint uVar14;
  uint uVar15;
  uint uVar16;
  uint uVar17;
  uint uVar18;
  int iVar19;
  uint uVar20;
  int *piVar21;
  uint uVar22;
  int iVar23;
  uint uVar24;
  int iVar25;
  uint uVar26;
  int iVar27;
  ushort *puVar28;
  bool bVar29;
  bool bVar30;
  int local_43c;
  char local_428 [256];
  undefined1 local_328 [768];
  int local_28;
  
  local_28 = __stack_chk_guard;
  piVar21 = (int *)*param_1;
  uVar24 = piVar21[4];
  bVar29 = false;
  uVar16 = uVar24 & 8;
  iVar25 = *(int *)*piVar21;
  iVar27 = ((int *)*piVar21)[1];
  if (uVar16 == 0 && (uVar24 & 4) != 0) {
    bVar29 = param_1[4] == 0;
  }
  png_set_benign_errors(iVar25,0);
  iVar19 = 1;
  uVar18 = piVar21[2];
  if ((piVar21[4] & 8U) == 0) {
    iVar19 = (piVar21[4] & 3U) + 1;
  }
  uVar6 = __aeabi_uidiv(0x7fffffff,iVar19);
  if (uVar6 < uVar18) {
                    // WARNING: Subroutine does not return
    png_error(*(undefined4 *)*piVar21,"image row stride too large");
  }
  uVar18 = iVar19 * uVar18;
  uVar6 = param_1[2];
  if (param_1[2] == 0) {
    param_1[2] = uVar18;
    uVar6 = uVar18;
  }
  if (0x7fffffff < uVar6) {
    uVar6 = -uVar6;
  }
  if (uVar6 < uVar18) {
                    // WARNING: Subroutine does not return
    png_error(*(undefined4 *)*piVar21,"supplied row stride too small");
  }
  uVar18 = __aeabi_uidiv(0xffffffff);
  uVar6 = piVar21[3];
  if (uVar18 < uVar6) {
                    // WARNING: Subroutine does not return
    png_error(*(undefined4 *)*piVar21,"memory image too large");
  }
  if (uVar16 == 0) {
    uVar7 = 8;
    if (bVar29) {
      uVar7 = 0x10;
    }
    png_set_IHDR(iVar25,iVar27,piVar21[2],uVar6,uVar7,uVar24 & 2 | (uVar24 & 1) << 2,0,0,0);
  }
  else {
    if ((param_1[3] == 0) || (uVar18 = piVar21[6], uVar18 == 0)) {
                    // WARNING: Subroutine does not return
      png_error(*(undefined4 *)*piVar21,"no color-map for color-mapped image");
    }
    if (uVar18 < 0x11) {
      if (uVar18 < 5) {
        uVar7 = 1;
        if (2 < uVar18) {
          uVar7 = 2;
        }
      }
      else {
        uVar7 = 4;
      }
    }
    else {
      uVar7 = 8;
    }
    local_43c = 0;
    png_set_IHDR(iVar25,iVar27,piVar21[2],uVar6,uVar7,3,0,0,0);
    puVar8 = (undefined4 *)*param_1;
    iVar19 = param_1[3];
    uVar22 = puVar8[4];
    uVar6 = puVar8[6];
    __aeabi_memset8(local_428,0x100,0xff);
    __aeabi_memclr8(local_328,0x300);
    uVar18 = (uint)((uVar22 & 0x21) == 0x21);
    if (0x100 < uVar6) {
      uVar6 = 0x100;
    }
    if (0 < (int)uVar6) {
      uVar17 = uVar22 & 3;
      bVar30 = (uVar22 & 0x21) == 0x21;
      uVar14 = uVar22 >> 3 & 2;
      uVar20 = uVar17 + 1;
      uVar9 = uVar17;
      if (bVar30) {
        uVar9 = 0;
      }
      iVar10 = 1;
      if (bVar30) {
        iVar10 = 2;
      }
      iVar11 = 3;
      if (bVar30) {
        iVar11 = 0;
      }
      uVar12 = uVar18 | uVar14;
      iVar23 = 0;
      do {
        iVar13 = iVar23 * uVar20;
        bVar30 = (int)((ulonglong)((longlong)iVar23 * (longlong)(int)uVar20) >> 0x20) !=
                 iVar13 >> 0x1f;
        if ((uVar22 & 4) == 0) {
          if (bVar30) goto LAB_0002b540;
          iVar13 = iVar13 + iVar19;
          if (uVar17 != 0) {
            if (uVar17 != 1) {
              if (((uVar17 != 2) &&
                  (cVar2 = *(char *)(iVar13 + iVar11), local_428[iVar23] = cVar2, cVar2 != -1)) &&
                 (local_43c = iVar23 + 1, SBORROW4(local_43c,iVar23))) goto LAB_0002b540;
              iVar4 = iVar23 * 3;
              local_328[iVar4 + 2] = *(undefined1 *)(iVar13 + (uVar12 ^ 2));
              local_328[iVar4 + 1] = *(undefined1 *)(iVar13 + iVar10);
              local_328[iVar4] = *(undefined1 *)(iVar13 + uVar12);
              goto LAB_0002b326;
            }
            cVar2 = *(char *)(iVar13 + (uVar18 ^ 1));
            local_428[iVar23] = cVar2;
            if ((cVar2 != -1) && (local_43c = iVar23 + 1, SBORROW4(local_43c,iVar23)))
            goto LAB_0002b540;
          }
          uVar5 = *(undefined1 *)(iVar13 + uVar18);
          iVar13 = iVar23 * 3;
          local_328[iVar13 + 1] = uVar5;
          local_328[iVar13] = uVar5;
          local_328[iVar13 + 2] = uVar5;
        }
        else {
          if (bVar30) goto LAB_0002b540;
          puVar28 = (ushort *)(iVar19 + iVar13 * 2);
          if ((uVar22 & 1) == 0) {
            if (2 < uVar20) {
              iVar13 = iVar23 * 3;
              uVar15 = (uint)puVar28[uVar14 ^ 2] * 0xff >> 0xf;
              local_328[iVar13 + 2] =
                   (char)((uint)*(ushort *)(png_sRGB_base + uVar15 * 2) +
                          ((uint)(byte)png_sRGB_delta[uVar15] *
                           ((uint)puVar28[uVar14 ^ 2] * 0xff & 0x7fff) >> 0xc) >> 8);
              uVar15 = (uint)puVar28[1] * 0xff >> 0xf;
              local_328[iVar13 + 1] =
                   (char)((uint)*(ushort *)(png_sRGB_base + uVar15 * 2) +
                          ((uint)(byte)png_sRGB_delta[uVar15] * ((uint)puVar28[1] * 0xff & 0x7fff)
                          >> 0xc) >> 8);
              uVar15 = (uint)puVar28[uVar14] * 0xff >> 0xf;
              local_328[iVar13] =
                   (char)((uint)*(ushort *)(png_sRGB_base + uVar15 * 2) +
                          ((uint)(byte)png_sRGB_delta[uVar15] *
                           ((uint)puVar28[uVar14] * 0xff & 0x7fff) >> 0xc) >> 8);
              goto LAB_0002b326;
            }
            uVar15 = (uint)*puVar28 * 0xff >> 0xf;
            uVar5 = (undefined1)
                    ((uint)*(ushort *)(png_sRGB_base + uVar15 * 2) +
                     ((uint)(byte)png_sRGB_delta[uVar15] * ((uint)*puVar28 * 0xff & 0x7fff) >> 0xc)
                    >> 8);
          }
          else {
            uVar3 = puVar28[uVar9];
            uVar26 = (uint)uVar3;
            iVar13 = uVar26 * 0xff + 0x807f;
            uVar15 = (uint)(iVar13 * 0x100) >> 0x18;
            cVar2 = (char)((uint)iVar13 >> 0x10);
            if ((uVar15 == 0) || (uVar15 == 0xff)) {
              uVar7 = 0;
              local_428[iVar23] = cVar2;
              if (uVar15 != 0xff) goto LAB_0002b2ac;
            }
            else {
              iVar13 = (uVar3 >> 1) + 0x7f7f8080;
              if (SBORROW4(iVar13,(uint)(uVar3 >> 1))) goto LAB_0002b540;
              local_428[iVar23] = cVar2;
              uVar7 = __aeabi_uidiv(iVar13,uVar26);
LAB_0002b2ac:
              local_43c = iVar23 + 1;
              if (SBORROW4(local_43c,iVar23)) goto LAB_0002b540;
            }
            if (2 < uVar20) {
              uVar5 = FUN_0002b93c(puVar28[uVar12 ^ 2],uVar26,uVar7);
              iVar13 = iVar23 * 3;
              local_328[iVar13 + 2] = uVar5;
              uVar5 = FUN_0002b93c(puVar28[iVar10],uVar26,uVar7);
              local_328[iVar13 + 1] = uVar5;
              uVar5 = FUN_0002b93c(puVar28[uVar12],uVar26,uVar7);
              local_328[iVar13] = uVar5;
              goto LAB_0002b326;
            }
            uVar5 = FUN_0002b93c(puVar28[uVar18],uVar26,uVar7);
          }
          iVar13 = iVar23 * 3;
          local_328[iVar13 + 1] = uVar5;
          local_328[iVar13] = uVar5;
          local_328[iVar13 + 2] = uVar5;
        }
LAB_0002b326:
        iVar13 = iVar23 + 1;
        if (SBORROW4(iVar13,iVar23)) {
LAB_0002b540:
                    // WARNING: Does not return
          pcVar1 = (code *)software_udf(0xfe,0x2b540);
          (*pcVar1)();
        }
        iVar23 = iVar13;
      } while (iVar13 < (int)uVar6);
    }
    png_set_PLTE(*(undefined4 *)*puVar8,((undefined4 *)*puVar8)[1],local_328,uVar6);
    if (0 < local_43c) {
      png_set_tRNS(*(undefined4 *)*puVar8,((undefined4 *)*puVar8)[1],local_428,local_43c,0);
    }
    puVar8[6] = uVar6;
  }
  if (bVar29) {
    png_set_gAMA_fixed(iVar25,iVar27,100000);
    if ((*(byte *)(piVar21 + 5) & 1) == 0) {
      png_set_cHRM_fixed(iVar25,iVar27,0x7a26,0x8084,64000,33000,30000,60000,15000,6000);
    }
    png_write_info(iVar25,iVar27);
    png_set_swap(iVar25);
  }
  else {
    if ((*(byte *)(piVar21 + 5) & 1) == 0) {
      png_set_sRGB(iVar25,iVar27,0);
    }
    else {
      png_set_gAMA_fixed(iVar25,iVar27,0xb18f);
    }
    png_write_info(iVar25,iVar27);
  }
  uVar18 = uVar24;
  if ((uVar24 & 0x10) != 0) {
    if ((uVar24 & 10) == 2) {
      png_set_bgr(iVar25);
    }
    uVar18 = uVar24 & 0xffffffef;
  }
  if ((uVar18 & 0x20) != 0) {
    if ((uVar16 == 0) && ((uVar18 & 1) != 0)) {
      png_set_swap_alpha(iVar25);
    }
    uVar18 = uVar18 & 0xffffffdf;
  }
  if ((uVar16 != 0) && ((uint)piVar21[6] < 0x11)) {
    png_set_packing(iVar25);
  }
  if (0xf < uVar18) {
                    // WARNING: Subroutine does not return
    png_error(iVar25,"png_write_image: unsupported transformation");
  }
  iVar19 = param_1[1];
  uVar18 = param_1[2] << ((uint)(uVar16 == 0) & (uVar24 & 4) >> 2);
  if (0x7fffffff < uVar18) {
    iVar19 = (piVar21[3] + -1) * -uVar18 + iVar19;
  }
  param_1[5] = iVar19;
  param_1[6] = uVar18;
  if ((*(byte *)(piVar21 + 5) & 2) != 0) {
    uVar7 = png_set_filter(iVar25,0,0);
    if (iVar25 != 0) {
      uVar7 = 3;
    }
    if (iVar25 != 0) {
      *(undefined4 *)(iVar25 + 0x180) = uVar7;
    }
  }
  if (((uVar24 & 5) == 5 && uVar16 == 0) || ((uVar16 == 0 && (param_1[4] != 0)))) {
    uVar7 = png_get_rowbytes(iVar25,iVar27);
    iVar19 = png_malloc(iVar25,uVar7);
    param_1[7] = iVar19;
    if (bVar29) {
      uVar7 = 0x2b6a1;
    }
    else {
      uVar7 = 0x2b7ad;
    }
    iVar10 = png_safe_execute(piVar21,uVar7,param_1);
    param_1[7] = 0;
    png_free(iVar25,iVar19);
    if (iVar10 == 0) goto LAB_0002b520;
  }
  else {
    iVar19 = piVar21[3];
    if (iVar19 != 0) {
      iVar10 = param_1[5];
      iVar11 = param_1[6];
      do {
        png_write_row(iVar25,iVar10);
        iVar10 = iVar10 + iVar11;
        iVar19 = iVar19 + -1;
      } while (iVar19 != 0);
    }
  }
  png_write_end(iVar25,iVar27);
LAB_0002b520:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



undefined4
png_image_write_to_file
          (int param_1,char *param_2,undefined4 param_3,int param_4,undefined4 param_5,
          undefined4 param_6)

{
  FILE *__stream;
  int iVar1;
  int *piVar2;
  char *pcVar3;
  undefined4 uVar4;
  
  if (param_1 == 0) {
    return 0;
  }
  if (*(int *)(param_1 + 4) == 1) {
    if ((param_2 == (char *)0x0) || (param_4 == 0)) {
      pcVar3 = "png_image_write_to_file: invalid argument";
    }
    else {
      __stream = fopen(param_2,"wb");
      if (__stream == (FILE *)0x0) {
        piVar2 = (int *)__errno();
        iVar1 = *piVar2;
      }
      else {
        iVar1 = png_image_write_to_stdio(param_1,__stream,param_3,param_4,param_5,param_6);
        if (iVar1 == 0) {
          fclose(__stream);
          remove(param_2);
          return 0;
        }
        iVar1 = fflush(__stream);
        if ((iVar1 == 0) && (((uint)__stream->_IO_read_base & 0x40) == 0)) {
          iVar1 = fclose(__stream);
          if (iVar1 == 0) {
            return 1;
          }
          piVar2 = (int *)__errno();
          iVar1 = *piVar2;
        }
        else {
          piVar2 = (int *)__errno();
          iVar1 = *piVar2;
          fclose(__stream);
        }
        remove(param_2);
      }
      pcVar3 = strerror(iVar1);
    }
  }
  else {
    pcVar3 = "png_image_write_to_file: incorrect PNG_IMAGE_VERSION";
  }
  uVar4 = png_image_error(param_1,pcVar3);
  return uVar4;
}



undefined4 FUN_0002b6a0(undefined4 *param_1)

{
  code *pcVar1;
  int iVar2;
  uint uVar3;
  uint uVar4;
  ushort uVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  undefined4 *puVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  uint uVar13;
  int iVar14;
  int iVar15;
  int iVar16;
  
  puVar9 = (undefined4 *)*param_1;
  uVar4 = puVar9[4];
  uVar6 = *(undefined4 *)*puVar9;
  if ((uVar4 & 1) == 0) {
                    // WARNING: Subroutine does not return
    png_error(uVar6,"png_write_image: internal call error");
  }
  uVar12 = param_1[7];
  uVar10 = uVar4 & 2 | 1;
  iVar14 = puVar9[3];
  uVar11 = uVar10;
  if ((uVar4 & 0x20) != 0) {
    uVar11 = 0xffffffff;
    uVar12 = uVar12 + 2;
  }
  if (iVar14 != 0) {
    iVar16 = param_1[5];
    iVar7 = puVar9[2] * (uVar10 + 1);
    if ((uVar4 & 0x20) != 0) {
      iVar16 = iVar16 + 2;
    }
    do {
      iVar15 = iVar16;
      uVar4 = uVar12;
      if (0 < iVar7) {
        do {
          uVar5 = *(ushort *)(iVar15 + uVar11 * 2);
          uVar13 = (uint)uVar5;
          iVar2 = 0;
          *(ushort *)(uVar4 + uVar11 * 2) = uVar5;
          if ((uVar13 != 0) && (uVar13 != 0xffff)) {
            uVar3 = uVar5 >> 1 | 0x7fff8000;
            if (SBORROW4(uVar3,(uint)(uVar5 >> 1))) {
LAB_0002b79a:
                    // WARNING: Does not return
              pcVar1 = (code *)software_udf(0xfe,0x2b79a);
              (*pcVar1)();
            }
            iVar2 = __aeabi_uidiv(uVar3,uVar13);
          }
          uVar4 = uVar4 + 2;
          iVar15 = iVar15 + 2;
          uVar3 = uVar10;
          do {
            uVar5 = *(ushort *)(iVar15 + -2);
            uVar8 = (uint)uVar5;
            if (uVar8 < uVar13) {
              if (uVar13 != 0xffff && uVar8 != 0) {
                uVar5 = (ushort)(iVar2 * uVar8 + 0x4000 >> 0xf);
              }
            }
            else {
              uVar5 = 0xffff;
            }
            *(ushort *)(uVar4 - 2) = uVar5;
            if (SBORROW4(uVar3,1)) goto LAB_0002b79a;
            uVar3 = uVar3 - 1;
            uVar4 = uVar4 + 2;
            iVar15 = iVar15 + 2;
          } while (0 < (int)uVar3);
        } while (uVar4 < uVar12 + iVar7 * 2);
      }
      iVar14 = iVar14 + -1;
      png_write_row(uVar6,param_1[7]);
      iVar16 = iVar16 + (param_1[6] & 0xfffffffe);
    } while (iVar14 != 0);
  }
  return 1;
}



undefined4 FUN_0002b7ac(int *param_1)

{
  code *pcVar1;
  ushort uVar2;
  undefined1 uVar3;
  undefined4 *puVar4;
  int iVar5;
  undefined1 *puVar6;
  int iVar7;
  uint uVar8;
  ushort *puVar9;
  undefined4 uVar10;
  uint uVar11;
  undefined1 *puVar12;
  undefined4 uVar13;
  uint uVar14;
  int iVar15;
  uint uVar16;
  ushort *puVar17;
  undefined1 *puVar18;
  
  puVar4 = (undefined4 *)*param_1;
  puVar17 = (ushort *)param_1[5];
  puVar12 = (undefined1 *)param_1[7];
  iVar15 = puVar4[3];
  uVar8 = puVar4[4];
  uVar16 = uVar8 & 2 | 1;
  uVar10 = *(undefined4 *)*puVar4;
  if ((uVar8 & 1) == 0) {
    if (iVar15 != 0) {
      iVar5 = puVar4[2];
      do {
        iVar15 = iVar15 + -1;
        puVar18 = puVar12;
        puVar9 = puVar17;
        if (0 < (int)(iVar5 * uVar16)) {
          do {
            uVar8 = (uint)*puVar9 * 0xff >> 0xf;
            puVar6 = puVar18 + 1;
            *puVar18 = (char)((uint)*(ushort *)(png_sRGB_base + uVar8 * 2) +
                              ((uint)(byte)png_sRGB_delta[uVar8] * ((uint)*puVar9 * 0xff & 0x7fff)
                              >> 0xc) >> 8);
            puVar18 = puVar6;
            puVar9 = puVar9 + 1;
          } while (puVar6 < puVar12 + iVar5 * uVar16);
        }
        png_write_row(uVar10,puVar12);
        puVar17 = (ushort *)((int)puVar17 + (param_1[6] & 0xfffffffeU));
      } while (iVar15 != 0);
    }
  }
  else {
    uVar11 = uVar16;
    if ((uVar8 & 0x20) != 0) {
      puVar12 = puVar12 + 1;
      uVar11 = 0xffffffff;
    }
    if (iVar15 != 0) {
      iVar5 = puVar4[2];
      if ((uVar8 & 0x20) != 0) {
        puVar17 = puVar17 + 1;
      }
      do {
        puVar9 = puVar17;
        puVar18 = puVar12;
        if (0 < (int)(iVar5 * (uVar16 + 1))) {
          do {
            uVar2 = puVar9[uVar11];
            uVar14 = (uint)uVar2;
            uVar13 = 0;
            iVar7 = uVar14 * 0xff + 0x807f;
            puVar18[uVar11] = (char)((uint)iVar7 >> 0x10);
            uVar8 = (uint)(iVar7 * 0x100) >> 0x18;
            if ((uVar8 != 0) && (uVar8 != 0xff)) {
              iVar7 = (uVar2 >> 1) + 0x7f7f8080;
              if (SBORROW4(iVar7,(uint)(uVar2 >> 1))) {
LAB_0002b930:
                    // WARNING: Does not return
                pcVar1 = (code *)software_udf(0xfe,0x2b930);
                (*pcVar1)();
              }
              uVar13 = __aeabi_uidiv(iVar7,uVar14);
            }
            puVar18 = puVar18 + 1;
            puVar9 = puVar9 + 1;
            uVar8 = uVar16;
            do {
              uVar3 = FUN_0002b93c(puVar9[-1],uVar14,uVar13);
              puVar18[-1] = uVar3;
              if (SBORROW4(uVar8,1)) goto LAB_0002b930;
              uVar8 = uVar8 - 1;
              puVar18 = puVar18 + 1;
              puVar9 = puVar9 + 1;
            } while (0 < (int)uVar8);
          } while (puVar18 < puVar12 + iVar5 * (uVar16 + 1));
        }
        iVar15 = iVar15 + -1;
        png_write_row(uVar10,param_1[7]);
        puVar17 = (ushort *)((int)puVar17 + (param_1[6] & 0xfffffffeU));
      } while (iVar15 != 0);
    }
  }
  return 1;
}



undefined1 FUN_0002b93c(uint param_1,uint param_2,int param_3)

{
  undefined1 uVar1;
  
  uVar1 = 0xff;
  if ((param_1 < param_2) && (0x7f < param_2)) {
    if (param_1 == 0) {
      uVar1 = 0;
    }
    else {
      if (param_2 < 0xff7f) {
        param_1 = param_3 * param_1 + 0x40 >> 7;
      }
      else {
        param_1 = param_1 * 0xff;
      }
      uVar1 = (undefined1)
              ((uint)*(ushort *)(png_sRGB_base + (param_1 >> 0xf) * 2) +
               ((uint)(byte)png_sRGB_delta[param_1 >> 0xf] * (param_1 & 0x7fff) >> 0xc) >> 8);
    }
  }
  return uVar1;
}



void png_do_write_transformations(int param_1,int *param_2,undefined4 param_3,code *param_4)

{
  code *pcVar1;
  char cVar2;
  undefined1 uVar3;
  undefined1 uVar4;
  ushort uVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  undefined1 *puVar9;
  int extraout_r1;
  int extraout_r1_00;
  byte *pbVar10;
  undefined2 uVar11;
  int iVar12;
  uint uVar13;
  byte *pbVar14;
  byte *pbVar15;
  byte bVar16;
  uint uVar18;
  uint uVar19;
  bool bVar20;
  int local_4c;
  uint local_48 [4];
  uint local_38 [4];
  int local_28;
  uint uVar17;
  
  local_28 = __stack_chk_guard;
  if (param_1 != 0) {
    uVar6 = *(uint *)(param_1 + 0x138);
    bVar20 = (uVar6 & 0x100000) != 0;
    if (bVar20) {
      param_4 = *(code **)(param_1 + 0x124);
    }
    if (bVar20 && param_4 != (code *)0x0) {
      (*param_4)(param_1,param_2,*(int *)(param_1 + 0x1e0) + 1);
      uVar6 = *(uint *)(param_1 + 0x138);
    }
    if ((uVar6 & 0x8000) != 0) {
      png_do_strip_channel
                (param_2,*(int *)(param_1 + 0x1e0) + 1,~(*(uint *)(param_1 + 0x134) >> 7) & 1);
      uVar6 = *(uint *)(param_1 + 0x138);
    }
    if ((uVar6 & 0x10000) != 0) {
      png_do_packswap(param_2,*(int *)(param_1 + 0x1e0) + 1);
      uVar6 = *(uint *)(param_1 + 0x138);
    }
    if ((uVar6 & 4) != 0) {
      cVar2 = *(char *)((int)param_2 + 9);
      bVar20 = cVar2 == '\b';
      if (bVar20) {
        cVar2 = *(char *)((int)param_2 + 10);
      }
      if (bVar20 && cVar2 == '\x01') {
        cVar2 = *(char *)(param_1 + 0x20c);
        pbVar14 = (byte *)(*(int *)(param_1 + 0x1e0) + 1);
        if (cVar2 == '\x01') {
          iVar12 = *param_2;
          if (iVar12 != 0) {
            uVar6 = 0;
            uVar18 = 0x80;
            pbVar10 = pbVar14;
            do {
              if (*pbVar14 != 0) {
                uVar6 = uVar6 | uVar18;
              }
              if (uVar18 < 2) {
                pbVar15 = pbVar10 + 1;
                *pbVar10 = (byte)uVar6;
                uVar18 = 0x80;
                uVar6 = 0;
              }
              else {
                uVar18 = (int)uVar18 >> 1;
                pbVar15 = pbVar10;
              }
              iVar12 = iVar12 + -1;
              pbVar14 = pbVar14 + 1;
              pbVar10 = pbVar15;
            } while (iVar12 != 0);
            if (uVar18 != 0x80) {
              *pbVar15 = (byte)uVar6;
            }
          }
        }
        else if (cVar2 == '\x02') {
          iVar12 = *param_2;
          if (iVar12 != 0) {
            uVar18 = 6;
            uVar6 = 0;
            pbVar10 = pbVar14;
            do {
              uVar6 = uVar6 | (*pbVar14 & 3) << (uVar18 & 0xff);
              if (uVar18 == 0) {
                pbVar15 = pbVar10 + 1;
                *pbVar10 = (byte)uVar6;
                uVar6 = 0;
                uVar18 = 6;
              }
              else {
                uVar18 = uVar18 - 2;
                pbVar15 = pbVar10;
              }
              iVar12 = iVar12 + -1;
              pbVar14 = pbVar14 + 1;
              pbVar10 = pbVar15;
            } while (iVar12 != 0);
            if (uVar18 != 6) {
              *pbVar15 = (byte)uVar6;
            }
          }
        }
        else if ((cVar2 == '\x04') && (iVar12 = *param_2, iVar12 != 0)) {
          uVar18 = 4;
          uVar6 = 0;
          pbVar10 = pbVar14;
          do {
            uVar6 = uVar6 | (*pbVar14 & 0xf) << (uVar18 & 0xff);
            if (uVar18 == 0) {
              pbVar15 = pbVar10 + 1;
              *pbVar10 = (byte)uVar6;
              uVar6 = 0;
              uVar18 = 4;
            }
            else {
              uVar18 = uVar18 - 4;
              pbVar15 = pbVar10;
            }
            iVar12 = iVar12 + -1;
            pbVar14 = pbVar14 + 1;
            pbVar10 = pbVar15;
          } while (iVar12 != 0);
          if (uVar18 != 4) {
            *pbVar15 = (byte)uVar6;
          }
        }
        *(char *)((int)param_2 + 9) = cVar2;
        bVar16 = cVar2 * *(char *)((int)param_2 + 10);
        *(byte *)((int)param_2 + 0xb) = bVar16;
        if (bVar16 < 8) {
          uVar6 = (uint)bVar16 * *param_2 + 7 >> 3;
        }
        else {
          uVar6 = (uint)(bVar16 >> 3) * *param_2;
        }
        param_2[1] = uVar6;
        uVar6 = *(uint *)(param_1 + 0x138);
      }
    }
    if ((uVar6 & 0x10) != 0) {
      png_do_swap(param_2,*(int *)(param_1 + 0x1e0) + 1);
      uVar6 = *(uint *)(param_1 + 0x138);
    }
    if (((uVar6 & 8) != 0) && (uVar5 = *(ushort *)(param_2 + 2), (char)uVar5 != '\x03')) {
      uVar6 = (uint)(uVar5 >> 8);
      if ((uVar5 & 2) == 0) {
        bVar16 = *(byte *)(param_1 + 0x264);
        local_4c = 1;
      }
      else {
        local_48[1] = (uint)*(byte *)(param_1 + 0x262);
        local_38[1] = uVar6 - local_48[1];
        local_48[2] = (uint)*(byte *)(param_1 + 0x263);
        local_38[2] = uVar6 - local_48[2];
        bVar16 = *(byte *)(param_1 + 0x261);
        local_4c = 3;
      }
      local_48[0] = (uint)bVar16;
      pbVar14 = (byte *)(*(int *)(param_1 + 0x1e0) + 1);
      local_38[0] = uVar6 - local_48[0];
      if ((uVar5 & 4) != 0) {
        bVar16 = *(byte *)(param_1 + 0x265);
        local_38[local_4c] = uVar6 - bVar16;
        local_48[local_4c] = (uint)bVar16;
        local_4c = local_4c + 1;
      }
      if (uVar6 < 8) {
        uVar18 = param_2[1];
        if (uVar6 == 2 && *(char *)(param_1 + 0x264) == '\x01') {
          uVar19 = 0x55;
        }
        else {
          uVar19 = 0xff;
          if (*(char *)(param_1 + 0x264) == '\x03') {
            uVar19 = 0x11;
          }
          if (uVar6 != 4) {
            uVar19 = 0xff;
          }
        }
        if (uVar18 != 0) {
          uVar6 = 0;
          do {
            uVar7 = -local_48[0];
            uVar17 = 0;
            bVar16 = 0;
            if (local_38[0] != uVar7 &&
                (int)(local_38[0] + local_48[0]) < 0 == SBORROW4(local_38[0],uVar7)) {
              uVar8 = local_38[0];
              do {
                if ((int)uVar8 < 1) {
                  uVar13 = *pbVar14 >> (-uVar8 & 0xff) & uVar19;
                }
                else {
                  uVar13 = (uint)*pbVar14 << (uVar8 & 0xff);
                }
                if (SBORROW4(uVar8,local_48[0])) {
LAB_0002beb4:
                    // WARNING: Does not return
                  pcVar1 = (code *)software_udf(0xfe,0x2beb4);
                  (*pcVar1)();
                }
                uVar8 = uVar8 - local_48[0];
                uVar17 = uVar17 | uVar13;
                bVar16 = (byte)uVar17;
              } while (uVar8 != uVar7 && (int)(uVar8 + local_48[0]) < 0 == SBORROW4(uVar8,uVar7));
            }
            uVar6 = uVar6 + 1;
            *pbVar14 = bVar16;
            pbVar14 = pbVar14 + 1;
          } while (uVar6 < uVar18);
        }
      }
      else {
        uVar18 = *param_2 * local_4c;
        if (uVar6 == 8) {
          if (uVar18 != 0) {
            uVar6 = 0;
            do {
              __aeabi_uidivmod(uVar6,local_4c);
              uVar7 = local_48[extraout_r1];
              uVar19 = -uVar7;
              uVar8 = 0;
              bVar16 = 0;
              uVar17 = local_38[extraout_r1];
              if (uVar17 != uVar19 && (int)(uVar17 + uVar7) < 0 == SBORROW4(uVar17,uVar19)) {
                do {
                  if ((int)uVar17 < 1) {
                    uVar13 = (uint)(*pbVar14 >> (-uVar17 & 0xff));
                  }
                  else {
                    uVar13 = (uint)*pbVar14 << (uVar17 & 0xff);
                  }
                  if (SBORROW4(uVar17,uVar7)) goto LAB_0002beb4;
                  uVar17 = uVar17 - uVar7;
                  uVar8 = uVar8 | uVar13;
                  bVar16 = (byte)uVar8;
                } while (uVar17 != uVar19 && (int)(uVar17 + uVar7) < 0 == SBORROW4(uVar17,uVar19));
              }
              uVar6 = uVar6 + 1;
              *pbVar14 = bVar16;
              pbVar14 = pbVar14 + 1;
            } while (uVar6 < uVar18);
          }
        }
        else if (uVar18 != 0) {
          uVar6 = 0;
          do {
            __aeabi_uidivmod(uVar6,local_4c);
            uVar7 = local_48[extraout_r1_00];
            uVar19 = -uVar7;
            uVar8 = 0;
            uVar11 = 0;
            uVar17 = local_38[extraout_r1_00];
            if (uVar17 != uVar19 && (int)(uVar17 + uVar7) < 0 == SBORROW4(uVar17,uVar19)) {
              do {
                if ((int)uVar17 < 1) {
                  uVar13 = (uint)(ushort)(CONCAT11(*pbVar14,pbVar14[1]) >> (-uVar17 & 0xff));
                }
                else {
                  uVar13 = (uint)CONCAT11(*pbVar14,pbVar14[1]) << (uVar17 & 0xff);
                }
                if (SBORROW4(uVar17,uVar7)) goto LAB_0002beb4;
                uVar17 = uVar17 - uVar7;
                uVar8 = uVar8 | uVar13;
                uVar11 = (undefined2)uVar8;
              } while (uVar17 != uVar19 && (int)(uVar17 + uVar7) < 0 == SBORROW4(uVar17,uVar19));
            }
            uVar6 = uVar6 + 1;
            *pbVar14 = (byte)((ushort)uVar11 >> 8);
            pbVar14[1] = (byte)uVar11;
            pbVar14 = pbVar14 + 2;
          } while (uVar6 < uVar18);
        }
      }
      uVar6 = *(uint *)(param_1 + 0x138);
    }
    if ((uVar6 & 0x20000) != 0) {
      puVar9 = (undefined1 *)(*(int *)(param_1 + 0x1e0) + 1);
      cVar2 = (char)*(ushort *)(param_2 + 2);
      uVar5 = *(ushort *)(param_2 + 2) >> 8;
      if (cVar2 == '\x04') {
        iVar12 = *param_2;
        if (uVar5 == 8) {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            uVar3 = *puVar9;
            *puVar9 = puVar9[1];
            puVar9[1] = uVar3;
            puVar9 = puVar9 + 2;
          }
        }
        else {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            uVar3 = *puVar9;
            uVar4 = puVar9[1];
            *puVar9 = puVar9[2];
            puVar9[1] = puVar9[3];
            puVar9[2] = uVar3;
            puVar9[3] = uVar4;
            puVar9 = puVar9 + 4;
          }
        }
      }
      else if (cVar2 == '\x06') {
        iVar12 = *param_2;
        if (uVar5 == 8) {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            uVar3 = *puVar9;
            *puVar9 = puVar9[1];
            puVar9[1] = puVar9[2];
            puVar9[2] = puVar9[3];
            puVar9[3] = uVar3;
            puVar9 = puVar9 + 4;
          }
        }
        else {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            uVar3 = *puVar9;
            uVar4 = puVar9[1];
            *puVar9 = puVar9[2];
            puVar9[1] = puVar9[3];
            puVar9[2] = puVar9[4];
            puVar9[3] = puVar9[5];
            puVar9[4] = puVar9[6];
            puVar9[5] = puVar9[7];
            puVar9[6] = uVar3;
            puVar9[7] = uVar4;
            puVar9 = puVar9 + 8;
          }
        }
      }
    }
    if ((*(byte *)(param_1 + 0x13a) & 8) != 0) {
      pbVar14 = *(byte **)(param_1 + 0x1e0);
      cVar2 = (char)*(ushort *)(param_2 + 2);
      uVar5 = *(ushort *)(param_2 + 2) >> 8;
      if (cVar2 == '\x04') {
        iVar12 = *param_2;
        if (uVar5 == 8) {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            pbVar14 = pbVar14 + 2;
            *pbVar14 = ~*pbVar14;
          }
        }
        else {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            pbVar10 = pbVar14 + 4;
            pbVar14[3] = ~pbVar14[3];
            *pbVar10 = ~*pbVar10;
            pbVar14 = pbVar10;
          }
        }
      }
      else if (cVar2 == '\x06') {
        iVar12 = *param_2;
        if (uVar5 == 8) {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            pbVar14 = pbVar14 + 4;
            *pbVar14 = ~*pbVar14;
          }
        }
        else {
          for (; iVar12 != 0; iVar12 = iVar12 + -1) {
            pbVar10 = pbVar14 + 8;
            pbVar14[7] = ~pbVar14[7];
            *pbVar10 = ~*pbVar10;
            pbVar14 = pbVar10;
          }
        }
      }
    }
    uVar6 = *(uint *)(param_1 + 0x138);
    if ((uVar6 & 1) != 0) {
      png_do_bgr(param_2,*(int *)(param_1 + 0x1e0) + 1);
      uVar6 = *(uint *)(param_1 + 0x138);
    }
    if ((uVar6 & 0x20) != 0) {
      if (__stack_chk_guard == local_28) {
        png_do_invert(param_2,*(int *)(param_1 + 0x1e0) + 1);
        return;
      }
      goto LAB_0002beb0;
    }
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
LAB_0002beb0:
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_save_uint_32(undefined1 *param_1,undefined4 param_2)

{
  *param_1 = (char)((uint)param_2 >> 0x18);
  param_1[1] = (char)((uint)param_2 >> 0x10);
  param_1[2] = (char)((uint)param_2 >> 8);
  param_1[3] = (char)param_2;
  return;
}



void png_save_uint_16(undefined1 *param_1,undefined4 param_2)

{
  *param_1 = (char)((uint)param_2 >> 8);
  param_1[1] = (char)param_2;
  return;
}



void png_write_sig(int param_1)

{
  uint uVar1;
  uint uVar2;
  undefined4 local_18;
  undefined4 local_14;
  int local_c;
  
  local_c = __stack_chk_guard;
  local_14 = 0xa1a0a0d;
  local_18 = 0x474e5089;
  *(undefined4 *)(param_1 + 0x360) = 0x12;
  png_write_data(param_1,(int)&local_18 + (uint)*(byte *)(param_1 + 0x211),
                 8 - (uint)*(byte *)(param_1 + 0x211));
  uVar1 = (uint)*(byte *)(param_1 + 0x211);
  uVar2 = uVar1;
  if (uVar1 < 3) {
    uVar2 = *(uint *)(param_1 + 0x130) | 0x1000;
  }
  if (uVar1 < 3) {
    *(uint *)(param_1 + 0x130) = uVar2;
  }
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_chunk_start(undefined4 param_1,byte *param_2)

{
  FUN_0002bf70(param_1,(uint)param_2[3] |
                       (uint)param_2[1] << 0x10 | (uint)*param_2 << 0x18 | (uint)param_2[2] << 8);
  return;
}



void FUN_0002bf70(int param_1,undefined4 param_2,undefined4 param_3)

{
  undefined1 local_1c;
  undefined1 local_1b;
  undefined1 local_1a;
  undefined1 local_19;
  undefined1 local_18;
  undefined1 local_17;
  undefined1 local_16;
  undefined1 local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x360) = 0x22;
    local_1c = (undefined1)((uint)param_3 >> 0x18);
    local_1b = (undefined1)((uint)param_3 >> 0x10);
    local_1a = (undefined1)((uint)param_3 >> 8);
    local_19 = (undefined1)param_3;
    local_18 = (undefined1)((uint)param_2 >> 0x18);
    local_17 = (undefined1)((uint)param_2 >> 0x10);
    local_16 = (undefined1)((uint)param_2 >> 8);
    local_15 = (undefined1)param_2;
    png_write_data(param_1,&local_1c,8);
    *(undefined4 *)(param_1 + 0x1d8) = param_2;
    png_reset_crc(param_1);
    png_calculate_crc(param_1,&local_18,4);
    *(undefined4 *)(param_1 + 0x360) = 0x42;
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_chunk_data(int param_1,int param_2,int param_3)

{
  if (((param_1 != 0) && (param_2 != 0)) && (param_3 != 0)) {
    png_write_data(param_1,param_2,param_3);
    png_calculate_crc(param_1,param_2,param_3);
    return;
  }
  return;
}



void png_write_chunk_end(int param_1)

{
  undefined4 uVar1;
  undefined1 local_10;
  undefined1 local_f;
  undefined1 local_e;
  undefined1 local_d;
  int local_c;
  
  local_c = __stack_chk_guard;
  if (param_1 != 0) {
    *(undefined4 *)(param_1 + 0x360) = 0x82;
    uVar1 = *(undefined4 *)(param_1 + 500);
    local_10 = (undefined1)((uint)uVar1 >> 0x18);
    local_f = (undefined1)((uint)uVar1 >> 0x10);
    local_e = (undefined1)((uint)uVar1 >> 8);
    local_d = (undefined1)uVar1;
    png_write_data(param_1,&local_10,4);
  }
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_chunk(undefined4 param_1,byte *param_2)

{
  FUN_0002c0a0(param_1,(uint)param_2[1] << 0x10 | (uint)*param_2 << 0x18 | (uint)param_2[2] << 8 |
                       (uint)param_2[3]);
  return;
}



void FUN_0002c0a0(int param_1,undefined4 param_2,undefined4 param_3,int param_4)

{
  undefined4 uVar1;
  undefined1 local_18;
  undefined1 local_17;
  undefined1 local_16;
  undefined1 local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  if (param_1 != 0) {
    if (param_4 < 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"length exceeds PNG maximum");
    }
    FUN_0002bf70(param_1,param_2,param_4);
    png_write_chunk_data(param_1,param_3,param_4);
    *(undefined4 *)(param_1 + 0x360) = 0x82;
    uVar1 = *(undefined4 *)(param_1 + 500);
    local_18 = (undefined1)((uint)uVar1 >> 0x18);
    local_17 = (undefined1)((uint)uVar1 >> 0x10);
    local_16 = (undefined1)((uint)uVar1 >> 8);
    local_15 = (undefined1)uVar1;
    png_write_data(param_1,&local_18,4);
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_free_buffer_list(undefined4 param_1,int *param_2)

{
  int *piVar1;
  
  piVar1 = (int *)*param_2;
  if (piVar1 != (int *)0x0) {
    *param_2 = 0;
    do {
      piVar1 = (int *)*piVar1;
      png_free(param_1);
    } while (piVar1 != (int *)0x0);
  }
  return;
}



void png_write_IHDR(int param_1,int param_2,undefined4 param_3,uint param_4,uint param_5,
                   undefined4 param_6,int param_7,uint param_8)

{
  code *pcVar1;
  undefined1 uVar2;
  ushort uVar3;
  uint uVar4;
  int iVar5;
  bool bVar6;
  bool bVar7;
  undefined1 local_2d;
  undefined1 local_2c;
  undefined1 local_2b;
  undefined1 local_2a;
  undefined1 local_29;
  undefined1 local_28;
  undefined1 local_27;
  undefined1 local_26;
  undefined1 local_25;
  undefined1 local_24;
  undefined1 local_23;
  undefined1 local_22;
  undefined1 local_21;
  int local_20;
  
  local_20 = __stack_chk_guard;
  switch(param_5) {
  case 0:
    if ((0x10 < param_4) || (iVar5 = 1, (1 << (param_4 & 0xff) & 0x10116U) == 0)) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid bit depth for grayscale image");
    }
    break;
  default:
                    // WARNING: Subroutine does not return
    png_error(param_1,"Invalid image color type specified");
  case 2:
    if (param_4 != 8 && param_4 != 0x10) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid bit depth for RGB image");
    }
    iVar5 = 3;
    break;
  case 3:
    if ((8 < param_4) || (iVar5 = 1, (1 << (param_4 & 0xff) & 0x116U) == 0)) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid bit depth for paletted image");
    }
    break;
  case 4:
    if (param_4 != 8 && param_4 != 0x10) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid bit depth for grayscale+alpha image");
    }
    iVar5 = 2;
    break;
  case 6:
    if (param_4 != 8 && param_4 != 0x10) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid bit depth for RGBA image");
    }
    iVar5 = 4;
  }
  *(char *)(param_1 + 0x20f) = (char)iVar5;
  if (((*(byte *)(param_1 + 0x304) & 4) == 0) || ((*(byte *)(param_1 + 0x131) & 0x10) != 0)) {
    param_7 = 0;
  }
  else if ((param_7 != 0) && ((param_5 | 4) != 6 || param_7 != 0x40)) {
    param_7 = 0;
  }
  local_25 = (undefined1)param_4;
  *(undefined1 *)(param_1 + 0x20c) = local_25;
  uVar4 = param_4 * iVar5;
  local_24 = (undefined1)param_5;
  *(undefined1 *)(param_1 + 0x20b) = local_24;
  if (1 < param_8) {
    param_8 = 1;
  }
  local_21 = (undefined1)param_8;
  *(undefined1 *)(param_1 + 0x208) = local_21;
  local_22 = (undefined1)param_7;
  *(undefined1 *)(param_1 + 0x308) = local_22;
  *(undefined1 *)(param_1 + 0x328) = 0;
  *(int *)(param_1 + 0x1bc) = param_2;
  *(undefined4 *)(param_1 + 0x1c0) = param_3;
  if ((int)((ulonglong)((longlong)(int)param_4 * (longlong)iVar5) >> 0x20) == (int)uVar4 >> 0x1f) {
    *(char *)(param_1 + 0x20e) = (char)uVar4;
    uVar4 = uVar4 & 0xff;
    if (uVar4 < 8) {
      uVar4 = uVar4 * param_2 + 7 >> 3;
    }
    else {
      uVar4 = (uVar4 >> 3) * param_2;
    }
    *(int *)(param_1 + 0x1c8) = param_2;
    *(uint *)(param_1 + 0x1cc) = uVar4;
    local_2d = (undefined1)((uint)param_2 >> 0x18);
    local_2c = (undefined1)((uint)param_2 >> 0x10);
    local_2b = (undefined1)((uint)param_2 >> 8);
    local_2a = (undefined1)param_2;
    local_29 = (undefined1)((uint)param_3 >> 0x18);
    local_28 = (undefined1)((uint)param_3 >> 0x10);
    local_27 = (undefined1)((uint)param_3 >> 8);
    local_26 = (undefined1)param_3;
    local_23 = 0;
    *(undefined1 *)(param_1 + 0x20d) = local_25;
    *(char *)(param_1 + 0x210) = (char)iVar5;
    FUN_0002c0a0(param_1,0x49484452,&local_2d,0xd);
    if ((*(ushort *)(param_1 + 0x20a) & 0xff) == 0) {
      uVar3 = *(ushort *)(param_1 + 0x20a) & 0xff00;
      bVar7 = 0x2ff < uVar3;
      bVar6 = uVar3 != 0x300;
      if (bVar6) {
        uVar3 = (ushort)*(byte *)(param_1 + 0x20c);
        bVar7 = 6 < uVar3;
      }
      if (bVar7 && (bVar6 && uVar3 != 7)) {
        uVar2 = 0xf8;
      }
      else {
        uVar2 = 8;
      }
      *(undefined1 *)(param_1 + 0x20a) = uVar2;
    }
    *(undefined4 *)(param_1 + 0x130) = 1;
    if (__stack_chk_guard != local_20) {
                    // WARNING: Subroutine does not return
      __stack_chk_fail();
    }
    return;
  }
                    // WARNING: Does not return
  pcVar1 = (code *)software_udf(0xfe,0x2c332);
  (*pcVar1)();
}



void png_write_PLTE(int param_1,undefined1 *param_2,uint param_3)

{
  byte bVar1;
  uint uVar2;
  undefined1 local_1b;
  undefined1 local_1a;
  undefined1 local_19;
  int local_18;
  
  local_18 = __stack_chk_guard;
  bVar1 = *(byte *)(param_1 + 0x20b);
  if (bVar1 == 3) {
    uVar2 = 1 << *(sbyte *)(param_1 + 0x20c);
  }
  else {
    uVar2 = 0x100;
  }
  if ((uVar2 < param_3) || ((*(uint *)(param_1 + 0x304) & 1) == 0 && param_3 == 0)) {
    if (bVar1 == 3) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"Invalid number of colors in palette");
    }
  }
  else if ((bVar1 & 2) != 0) {
    *(short *)(param_1 + 0x1fc) = (short)param_3;
    FUN_0002bf70(param_1,0x504c5445,param_3 * 3);
    if (param_3 != 0) {
      do {
        local_1b = *param_2;
        local_1a = param_2[1];
        local_19 = param_2[2];
        png_write_chunk_data(param_1,&local_1b,3);
        param_2 = param_2 + 3;
        param_3 = param_3 - 1;
      } while (param_3 != 0);
    }
    png_write_chunk_end(param_1);
    *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 2;
  }
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_compress_IDAT(int param_1,undefined4 param_2,int param_3,int param_4)

{
  int *piVar1;
  undefined4 *puVar2;
  undefined4 uVar3;
  int iVar4;
  uint uVar5;
  int *piVar6;
  int iVar7;
  int iVar8;
  bool bVar9;
  
  if (*(int *)(param_1 + 0x13c) != 0x49444154) {
    piVar1 = *(int **)(param_1 + 0x178);
    if (piVar1 == (int *)0x0) {
      puVar2 = (undefined4 *)png_malloc(param_1,*(int *)(param_1 + 0x17c) + 4);
      *(undefined4 **)(param_1 + 0x178) = puVar2;
      *puVar2 = 0;
    }
    else {
      piVar6 = (int *)*piVar1;
      if (piVar6 != (int *)0x0) {
        *piVar1 = 0;
        do {
          piVar6 = (int *)*piVar6;
          png_free(param_1);
        } while (piVar6 != (int *)0x0);
      }
    }
    uVar3 = FUN_0002c774(param_1);
    iVar4 = FUN_0002c5c0(param_1,0x49444154,uVar3);
    if (iVar4 != 0) {
LAB_0002c5b0:
                    // WARNING: Subroutine does not return
      png_error(param_1,*(undefined4 *)(param_1 + 0x158));
    }
    *(int *)(param_1 + 0x14c) = *(int *)(param_1 + 0x178) + 4;
    *(undefined4 *)(param_1 + 0x150) = *(undefined4 *)(param_1 + 0x17c);
  }
  *(undefined4 *)(param_1 + 0x140) = param_2;
  *(undefined4 *)(param_1 + 0x144) = 0;
LAB_0002c4c2:
  do {
    *(int *)(param_1 + 0x144) = param_3;
    iVar4 = deflate(param_1 + 0x140,param_4);
    param_3 = *(int *)(param_1 + 0x144);
    *(undefined4 *)(param_1 + 0x144) = 0;
    iVar8 = *(int *)(param_1 + 0x150);
    if (iVar8 == 0) {
      uVar5 = *(uint *)(param_1 + 0x178);
      iVar8 = *(int *)(param_1 + 0x17c);
      iVar7 = uVar5 + 4;
      bVar9 = (*(byte *)(param_1 + 0x130) & 4) == 0;
      if (bVar9) {
        uVar5 = (uint)*(byte *)(param_1 + 0x328);
      }
      if (bVar9 && uVar5 == 0) {
        uVar3 = FUN_0002c774(param_1);
        FUN_0002c8d4(iVar7,uVar3);
      }
      FUN_0002c0a0(param_1,0x49444154,iVar7,iVar8);
      *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 4;
      *(int *)(param_1 + 0x14c) = iVar7;
      *(int *)(param_1 + 0x150) = iVar8;
      if ((param_4 != 0) && (iVar4 == 0)) goto LAB_0002c4c2;
    }
    if (iVar4 != 0) {
      if (param_4 == 4 && iVar4 == 1) {
        uVar5 = *(uint *)(param_1 + 0x178);
        iVar4 = *(int *)(param_1 + 0x17c);
        iVar7 = uVar5 + 4;
        bVar9 = (*(byte *)(param_1 + 0x130) & 4) == 0;
        if (bVar9) {
          uVar5 = (uint)*(byte *)(param_1 + 0x328);
        }
        if (bVar9 && uVar5 == 0) {
          uVar3 = FUN_0002c774(param_1);
          FUN_0002c8d4(iVar7,uVar3);
        }
        FUN_0002c0a0(param_1,0x49444154,iVar7,iVar4 - iVar8);
        *(undefined4 *)(param_1 + 0x14c) = 0;
        *(undefined4 *)(param_1 + 0x150) = 0;
        *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 0xc;
        *(undefined4 *)(param_1 + 0x13c) = 0;
        return;
      }
      png_zstream_error(param_1,iVar4);
      goto LAB_0002c5b0;
    }
    if (param_3 == 0) {
      if (param_4 != 4) {
        return;
      }
                    // WARNING: Subroutine does not return
      png_error(param_1,"Z_OK on Z_FINISH with output space");
    }
  } while( true );
}



void FUN_0002c5c0(int param_1,int param_2,uint param_3)

{
  code *pcVar1;
  int iVar2;
  int iVar3;
  uint uVar4;
  uint uVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  bool bVar9;
  undefined1 local_64;
  undefined1 local_63;
  undefined1 local_62;
  undefined1 local_61;
  undefined1 local_60;
  undefined1 local_5f;
  undefined1 local_5e;
  undefined1 local_5d;
  undefined1 local_5c;
  undefined1 local_5b;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar2 = *(int *)(param_1 + 0x13c);
  if (iVar2 != 0) {
    local_64 = (undefined1)((uint)param_2 >> 0x18);
    local_63 = (undefined1)((uint)param_2 >> 0x10);
    local_62 = (undefined1)((uint)param_2 >> 8);
    local_61 = (undefined1)param_2;
    local_60 = 0x3a;
    local_5f = 0x20;
    local_5e = (undefined1)((uint)iVar2 >> 0x18);
    local_5d = (undefined1)((uint)iVar2 >> 0x10);
    local_5c = (undefined1)((uint)iVar2 >> 8);
    local_5b = (undefined1)iVar2;
    png_safecat(&local_64,0x40,10," using zstream");
                    // WARNING: Subroutine does not return
    png_error(param_1,&local_64);
  }
  if (param_2 == 0x49444154) {
    iVar6 = *(int *)(param_1 + 0x180);
    iVar7 = *(int *)(param_1 + 0x184);
    iVar2 = *(int *)(param_1 + 0x188);
    iVar8 = *(int *)(param_1 + 0x18c);
    if ((*(byte *)(param_1 + 0x134) & 1) == 0) {
      uVar5 = (uint)(*(char *)(param_1 + 0x20a) != '\b');
    }
    else {
      uVar5 = *(uint *)(param_1 + 400);
    }
  }
  else {
    iVar6 = *(int *)(param_1 + 0x194);
    iVar7 = *(int *)(param_1 + 0x198);
    iVar2 = *(int *)(param_1 + 0x19c);
    iVar8 = *(int *)(param_1 + 0x1a0);
    uVar5 = *(uint *)(param_1 + 0x1a4);
  }
  if (param_3 < 0x4001) {
    if (SBORROW4(iVar2,1)) {
LAB_0002c70c:
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x2c70c);
      (*pcVar1)();
    }
    for (uVar4 = 1 << (iVar2 - 1U & 0xff); param_3 + 0x106 <= uVar4; uVar4 = uVar4 >> 1) {
      if (SBORROW4(iVar2,1)) goto LAB_0002c70c;
      iVar2 = iVar2 + -1;
    }
  }
  uVar4 = *(uint *)(param_1 + 0x134);
  if ((uVar4 & 2) != 0) {
    iVar3 = *(int *)(param_1 + 0x1a8);
    bVar9 = iVar3 == iVar6;
    if (bVar9) {
      iVar3 = *(int *)(param_1 + 0x1ac);
    }
    if (bVar9 && iVar3 == iVar7) {
      iVar3 = *(int *)(param_1 + 0x1b0);
      bVar9 = iVar3 == iVar2;
      if (bVar9) {
        iVar3 = *(int *)(param_1 + 0x1b4);
      }
      if ((bVar9 && iVar3 == iVar8) && (*(uint *)(param_1 + 0x1b8) == uVar5)) goto LAB_0002c69c;
    }
    deflateEnd(param_1 + 0x140);
    uVar4 = *(uint *)(param_1 + 0x134) & 0xfffffffd;
    *(uint *)(param_1 + 0x134) = uVar4;
  }
LAB_0002c69c:
  *(undefined4 *)(param_1 + 0x140) = 0;
  *(undefined4 *)(param_1 + 0x144) = 0;
  *(undefined4 *)(param_1 + 0x14c) = 0;
  *(undefined4 *)(param_1 + 0x150) = 0;
  if ((uVar4 & 2) == 0) {
    iVar2 = deflateInit2_(param_1 + 0x140,iVar6,iVar7,iVar2,iVar8,uVar5,"1.2.8",0x38);
    if (iVar2 != 0) {
LAB_0002c6e2:
      png_zstream_error(param_1,iVar2);
      goto LAB_0002c6f2;
    }
    *(uint *)(param_1 + 0x134) = *(uint *)(param_1 + 0x134) | 2;
  }
  else {
    iVar2 = deflateReset(param_1 + 0x140);
    if (iVar2 != 0) goto LAB_0002c6e2;
  }
  *(int *)(param_1 + 0x13c) = param_2;
LAB_0002c6f2:
  if (__stack_chk_guard - local_24 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_24);
}



int FUN_0002c774(int param_1)

{
  code *pcVar1;
  byte bVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  
  uVar9 = *(uint *)(param_1 + 0x1c0);
  if ((*(uint *)(param_1 + 0x1cc) | uVar9) >> 0xf == 0) {
    if (*(char *)(param_1 + 0x208) != '\0') {
      bVar2 = *(byte *)(param_1 + 0x20e);
      iVar3 = 0;
      uVar4 = 0;
LAB_0002c7cc:
      do {
        uVar7 = uVar4;
        if (6 < (int)uVar7) {
          return iVar3;
        }
        if ((int)uVar7 < 2) {
          uVar4 = 3;
        }
        else {
          if (SBORROW4(7,uVar7)) goto LAB_0002c8d2;
          uVar4 = (int)(7 - uVar7) >> 1;
        }
        iVar5 = 1 << (uVar4 & 0xff);
        if ((SBORROW4(iVar5,1)) || (uVar4 = uVar7 + 1, SBORROW4(uVar4,uVar7))) goto LAB_0002c8d2;
        iVar5 = iVar5 + -1;
        uVar6 = (uVar7 & 1) << (3U - ((int)uVar4 >> 1) & 0xff) & 7;
        if (SBORROW4(iVar5,uVar6)) goto LAB_0002c8d2;
        if ((int)uVar7 < 2) {
          uVar8 = 3;
        }
        else {
          if (SBORROW4(7,uVar7)) goto LAB_0002c8d2;
          uVar8 = (int)(7 - uVar7) >> 1;
        }
        uVar6 = (iVar5 - uVar6) + *(int *)(param_1 + 0x1bc) >> (uVar8 & 0xff);
      } while (uVar6 == 0);
      if (bVar2 < 8) {
        uVar6 = uVar6 * bVar2 + 7 >> 3;
      }
      else {
        uVar6 = uVar6 * (bVar2 >> 3);
      }
      if ((int)uVar7 < 3) {
        uVar8 = 3;
      }
      else {
        if (SBORROW4(8,uVar7)) goto LAB_0002c8d2;
        uVar8 = (int)(8 - uVar7) >> 1;
      }
      iVar5 = 1 << (uVar8 & 0xff);
      if (!SBORROW4(iVar5,1)) {
        iVar5 = iVar5 + -1;
        uVar8 = (uVar7 & 1 ^ 1) << (3U - ((int)uVar7 >> 1) & 0xff) & 7;
        if (!SBORROW4(iVar5,uVar8)) {
          if ((int)uVar7 < 3) {
            uVar7 = 3;
          }
          else {
            if (SBORROW4(8,uVar7)) goto LAB_0002c8d2;
            uVar7 = (int)(8 - uVar7) >> 1;
          }
          iVar3 = ((iVar5 - uVar8) + uVar9 >> (uVar7 & 0xff)) * (uVar6 + 1) + iVar3;
          goto LAB_0002c7cc;
        }
      }
LAB_0002c8d2:
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x2c8d2);
      (*pcVar1)();
    }
    iVar3 = (*(uint *)(param_1 + 0x1cc) + 1) * uVar9;
  }
  else {
    iVar3 = -1;
  }
  return iVar3;
}



void FUN_0002c8d4(byte *param_1,uint param_2)

{
  byte bVar1;
  int iVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  
  if (param_2 < 0x4001) {
    bVar1 = *param_1;
    if (((bVar1 & 0xf) == 8) && ((bVar1 & 0xf0) < 0x71)) {
      uVar3 = 1 << (bVar1 >> 4) + 7;
      if (uVar3 < param_2) {
        return;
      }
      iVar2 = -(uint)(bVar1 >> 4);
      uVar5 = (uint)(bVar1 >> 4) << 4 | 8;
      uVar4 = (uint)(bVar1 >> 4) << 0xc | 0x800;
      do {
        iVar2 = iVar2 + 1;
        uVar5 = uVar5 - 0x10;
        uVar4 = uVar4 - 0x1000;
        if (iVar2 == 0) break;
        uVar3 = uVar3 >> 1;
      } while (param_2 <= uVar3);
      *param_1 = (byte)uVar5;
      uVar4 = param_1[1] & 0xe0 | uVar4;
      bVar1 = (byte)(param_1[1] & 0xe0);
      param_1[1] = (bVar1 | bVar1 - ((char)(uVar4 / 0x1f) * ' ' - (char)(uVar4 / 0x1f))) ^ 0x1f;
    }
  }
  return;
}



void png_write_IEND(int param_1)

{
  FUN_0002c0a0(param_1,0x49454e44,0,0);
  *(uint *)(param_1 + 0x130) = *(uint *)(param_1 + 0x130) | 0x10;
  return;
}



void png_write_gAMA_fixed(undefined4 param_1,undefined4 param_2)

{
  undefined1 local_10;
  undefined1 local_f;
  undefined1 local_e;
  undefined1 local_d;
  int local_c;
  
  local_c = __stack_chk_guard;
  local_10 = (undefined1)((uint)param_2 >> 0x18);
  local_f = (undefined1)((uint)param_2 >> 0x10);
  local_e = (undefined1)((uint)param_2 >> 8);
  local_d = (undefined1)param_2;
  FUN_0002c0a0(param_1,0x67414d41,&local_10,4);
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_sRGB(undefined4 param_1,undefined1 param_2)

{
  undefined1 local_d;
  int local_c;
  
  local_c = __stack_chk_guard;
  local_d = param_2;
  FUN_0002c0a0(param_1,0x73524742,&local_d,1);
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_iCCP(int param_1,undefined4 param_2,byte *param_3)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  byte *local_478;
  uint uStack_474;
  int local_470;
  undefined1 uStack_69;
  undefined1 auStack_68 [80];
  int local_18;
  
  local_18 = __stack_chk_guard;
  if (param_3 == (byte *)0x0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"No profile for iCCP chunk");
  }
  uVar3 = (uint)param_3[1] << 0x10 | (uint)*param_3 << 0x18 | (uint)param_3[2] << 8 |
          (uint)param_3[3];
  if (uVar3 < 0x84) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"ICC profile too short");
  }
  if (((param_3[3] & 3) != 0) && (3 < param_3[8])) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"ICC profile length invalid (not a multiple of 4)");
  }
  iVar1 = png_check_keyword(param_1,param_2,&uStack_69);
  if (iVar1 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"iCCP: invalid keyword");
  }
  auStack_68[iVar1] = 0;
  iVar1 = iVar1 + 2;
  local_470 = 0;
  local_478 = param_3;
  uStack_474 = uVar3;
  iVar2 = FUN_0002cb20(param_1,0x69434350,&local_478,iVar1);
  if (iVar2 != 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,*(undefined4 *)(param_1 + 0x158));
  }
  FUN_0002bf70(param_1,0x69434350,local_470 + iVar1);
  png_write_chunk_data(param_1,&uStack_69,iVar1);
  FUN_0002cc24(param_1,&local_478);
  png_write_chunk_end(param_1);
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



int FUN_0002cb20(int param_1,undefined4 param_2,undefined4 *param_3,int param_4)

{
  bool bVar1;
  int iVar2;
  int iVar3;
  undefined4 *puVar4;
  int iVar5;
  undefined4 *puVar6;
  int iVar7;
  
  iVar2 = FUN_0002c5c0(param_1,param_2,param_3[1]);
  if (iVar2 == 0) {
    iVar5 = param_3[1];
    puVar6 = (undefined4 *)(param_1 + 0x178);
    *(undefined4 *)(param_1 + 0x140) = *param_3;
    iVar3 = 0x400;
    iVar7 = 0x400;
    *(undefined4 *)(param_1 + 0x144) = 0;
    *(undefined4 **)(param_1 + 0x14c) = param_3 + 3;
    *(undefined4 *)(param_1 + 0x150) = 0x400;
    do {
      *(int *)(param_1 + 0x144) = iVar5;
      if (iVar3 == 0) {
        if (-1 < iVar7 + param_4) {
          puVar4 = (undefined4 *)*puVar6;
          if (puVar4 == (undefined4 *)0x0) {
            puVar4 = (undefined4 *)png_malloc_base(param_1,*(int *)(param_1 + 0x17c) + 4);
            if (puVar4 == (undefined4 *)0x0) goto LAB_0002cbba;
            *puVar4 = 0;
            *puVar6 = puVar4;
          }
          *(undefined4 **)(param_1 + 0x14c) = puVar4 + 1;
          *(int *)(param_1 + 0x150) = *(int *)(param_1 + 0x17c);
          iVar7 = iVar7 + *(int *)(param_1 + 0x17c);
          puVar6 = puVar4;
          goto LAB_0002cba2;
        }
LAB_0002cbba:
        iVar5 = 0;
        bVar1 = true;
        iVar2 = -4;
      }
      else {
LAB_0002cba2:
        iVar2 = deflate(param_1 + 0x140,4);
        iVar5 = *(int *)(param_1 + 0x144);
        bVar1 = false;
        *(undefined4 *)(param_1 + 0x144) = 0;
      }
      iVar3 = *(int *)(param_1 + 0x150);
    } while (!bVar1 && iVar2 == 0);
    *(undefined4 *)(param_1 + 0x150) = 0;
    param_3[2] = iVar7 - iVar3;
    if ((uint)((iVar7 - iVar3) + param_4) < 0x7fffffff) {
      png_zstream_error(param_1,iVar2);
      *(undefined4 *)(param_1 + 0x13c) = 0;
      if (iVar2 == 1 && iVar5 == 0) {
        FUN_0002c8d4(param_3 + 3,param_3[1]);
        iVar2 = 0;
      }
    }
    else {
      iVar2 = -4;
      *(char **)(param_1 + 0x158) = "compressed data too long";
      *(undefined4 *)(param_1 + 0x13c) = 0;
    }
  }
  return iVar2;
}



void FUN_0002cc24(int param_1,int param_2)

{
  int *piVar1;
  int *piVar2;
  uint uVar3;
  uint uVar4;
  bool bVar5;
  
  uVar3 = *(uint *)(param_2 + 8);
  piVar1 = *(int **)(param_1 + 0x178);
  uVar4 = uVar3;
  if (0x3ff < uVar3) {
    uVar4 = 0x400;
  }
  png_write_chunk_data(param_1,param_2 + 0xc,uVar4);
  bVar5 = uVar3 == uVar4;
  if (!bVar5 && piVar1 != (int *)0x0) {
    do {
      uVar3 = uVar3 - uVar4;
      piVar2 = piVar1 + 1;
      piVar1 = (int *)*piVar1;
      uVar4 = *(uint *)(param_1 + 0x17c);
      if (uVar3 < *(uint *)(param_1 + 0x17c)) {
        uVar4 = uVar3;
      }
      png_write_chunk_data(param_1,piVar2,uVar4);
      bVar5 = uVar3 == uVar4;
    } while ((!bVar5) && (piVar1 != (int *)0x0));
  }
  if (!bVar5) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"error writing ancillary chunked compressed data");
  }
  return;
}



void png_write_sPLT(undefined4 param_1,undefined4 *param_2)

{
  char *pcVar1;
  char cVar2;
  int iVar3;
  undefined2 *puVar4;
  int iVar5;
  int iVar6;
  undefined1 local_7e;
  undefined1 local_7d;
  undefined1 local_7c;
  undefined1 local_7b;
  undefined1 local_7a;
  undefined1 local_79;
  undefined1 local_78;
  undefined1 local_77;
  undefined1 local_76;
  undefined1 local_75;
  undefined1 auStack_74 [80];
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar6 = param_2[3];
  pcVar1 = (char *)(param_2 + 1);
  cVar2 = *pcVar1;
  iVar3 = png_check_keyword(param_1,*param_2,auStack_74);
  iVar5 = 10;
  if (cVar2 == '\b') {
    iVar5 = 6;
  }
  if (iVar3 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"sPLT: invalid keyword");
  }
  FUN_0002bf70(param_1,0x73504c54,iVar5 * iVar6 + iVar3 + 2);
  png_write_chunk_data(param_1,auStack_74,iVar3 + 1);
  png_write_chunk_data(param_1,pcVar1,1);
  if (0 < (int)param_2[3]) {
    puVar4 = (undefined2 *)param_2[2];
    do {
      local_7d = (undefined1)*puVar4;
      if (*pcVar1 == '\b') {
        local_7c = *(undefined1 *)(puVar4 + 2);
        local_7b = *(undefined1 *)(puVar4 + 3);
        local_7a = (undefined1)((ushort)puVar4[4] >> 8);
        local_79 = (undefined1)puVar4[4];
        local_7e = local_7d;
        local_7d = *(undefined1 *)(puVar4 + 1);
      }
      else {
        local_7e = (undefined1)((ushort)*puVar4 >> 8);
        local_7c = (undefined1)((ushort)puVar4[1] >> 8);
        local_7b = (undefined1)puVar4[1];
        local_7a = (undefined1)((ushort)puVar4[2] >> 8);
        local_79 = (undefined1)puVar4[2];
        local_78 = (undefined1)((ushort)puVar4[3] >> 8);
        local_77 = (undefined1)puVar4[3];
        local_76 = (undefined1)((ushort)puVar4[4] >> 8);
        local_75 = (undefined1)puVar4[4];
      }
      png_write_chunk_data(param_1,&local_7e,iVar5);
      puVar4 = puVar4 + 5;
    } while (puVar4 < (undefined2 *)(param_2[2] + param_2[3] * 10));
  }
  png_write_chunk_end(param_1);
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_sBIT(int param_1,byte *param_2,uint param_3)

{
  byte bVar1;
  int iVar2;
  byte local_18 [4];
  int local_14;
  
  local_14 = __stack_chk_guard;
  if ((param_3 & 2) == 0) {
    bVar1 = param_2[3];
    if ((bVar1 == 0) || (*(byte *)(param_1 + 0x20d) < bVar1)) goto LAB_0002ce48;
    iVar2 = 1;
    local_18[0] = bVar1;
  }
  else {
    if (param_3 == 3) {
      bVar1 = 8;
    }
    else {
      bVar1 = *(byte *)(param_1 + 0x20d);
    }
    if (((bVar1 <= (byte)(*param_2 - 1)) || (bVar1 <= (byte)(param_2[1] - 1))) ||
       (bVar1 <= (byte)(param_2[2] - 1))) goto LAB_0002ce48;
    iVar2 = 3;
    local_18[0] = *param_2;
    local_18[1] = param_2[1];
    local_18[2] = param_2[2];
  }
  if ((param_3 & 4) != 0) {
    bVar1 = param_2[4];
    if ((bVar1 == 0) || (*(byte *)(param_1 + 0x20d) < bVar1)) goto LAB_0002ce48;
    local_18[iVar2] = bVar1;
    iVar2 = iVar2 + 1;
  }
  FUN_0002c0a0(param_1,0x73424954,local_18,iVar2);
LAB_0002ce48:
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_cHRM_fixed(undefined4 param_1,undefined4 *param_2)

{
  undefined1 auStack_34 [4];
  undefined1 auStack_30 [4];
  undefined1 auStack_2c [4];
  undefined1 auStack_28 [4];
  undefined1 auStack_24 [4];
  undefined1 auStack_20 [4];
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  local_14 = __stack_chk_guard;
  png_save_int_32(auStack_34,param_2[6]);
  png_save_int_32(auStack_30,param_2[7]);
  png_save_int_32(auStack_2c,*param_2);
  png_save_int_32(auStack_28,param_2[1]);
  png_save_int_32(auStack_24,param_2[2]);
  png_save_int_32(auStack_20,param_2[3]);
  png_save_int_32(auStack_1c,param_2[4]);
  png_save_int_32(auStack_18,param_2[5]);
  FUN_0002c0a0(param_1,0x6348524d,auStack_34,0x20);
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_tRNS(int param_1,undefined4 param_2,int param_3,int param_4,int param_5)

{
  int iVar1;
  ushort uVar2;
  ushort uVar3;
  ushort uVar4;
  char *pcVar5;
  bool bVar6;
  undefined1 local_12;
  undefined1 local_11;
  undefined1 local_10;
  undefined1 local_f;
  undefined1 local_e;
  undefined1 local_d;
  int local_c;
  
  local_c = __stack_chk_guard;
  if (param_5 == 0) {
    uVar2 = *(ushort *)(param_3 + 8);
    if ((int)(uint)uVar2 < 1 << (uint)*(byte *)(param_1 + 0x20c)) {
      local_12 = (undefined1)(uVar2 >> 8);
      local_11 = (undefined1)uVar2;
      FUN_0002c0a0(param_1,0x74524e53,&local_12,2);
      goto LAB_0002cfba;
    }
    pcVar5 = "Ignoring attempt to write tRNS chunk out-of-range for bit_depth";
  }
  else if (param_5 == 2) {
    uVar2 = *(ushort *)(param_3 + 2);
    local_12 = (undefined1)(uVar2 >> 8);
    local_11 = (undefined1)uVar2;
    uVar3 = *(ushort *)(param_3 + 4);
    local_10 = (undefined1)(uVar3 >> 8);
    local_f = (undefined1)uVar3;
    uVar4 = *(ushort *)(param_3 + 6);
    local_e = (undefined1)(uVar4 >> 8);
    local_d = (undefined1)uVar4;
    if ((*(char *)(param_1 + 0x20c) != '\b') || ((ushort)(uVar3 | uVar2 | uVar4) >> 8 == 0)) {
      FUN_0002c0a0(param_1,0x74524e53,&local_12,6);
      goto LAB_0002cfba;
    }
    pcVar5 = "Ignoring attempt to write 16-bit tRNS chunk when bit_depth is 8";
  }
  else if (param_5 == 3) {
    bVar6 = SBORROW4(param_4,1);
    iVar1 = param_4 + -1;
    if (0 < param_4) {
      bVar6 = SBORROW4((uint)*(ushort *)(param_1 + 0x1fc),param_4);
      iVar1 = (uint)*(ushort *)(param_1 + 0x1fc) - param_4;
    }
    if (iVar1 < 0 == bVar6) {
      FUN_0002c0a0(param_1,0x74524e53,param_2);
      goto LAB_0002cfba;
    }
    pcVar5 = "Invalid number of transparent colors specified";
  }
  else {
    pcVar5 = "Can\'t write tRNS with an alpha channel";
  }
  png_app_warning(param_1,pcVar5);
LAB_0002cfba:
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_bKGD(int param_1,byte *param_2,uint param_3)

{
  ushort uVar1;
  ushort uVar2;
  ushort uVar3;
  byte bVar4;
  undefined4 uVar5;
  byte local_12;
  undefined1 local_11;
  undefined1 local_10;
  undefined1 local_f;
  undefined1 local_e;
  undefined1 local_d;
  int local_c;
  
  local_c = __stack_chk_guard;
  if (param_3 == 3) {
    if ((*(ushort *)(param_1 + 0x1fc) == 0) && ((*(byte *)(param_1 + 0x304) & 1) != 0)) {
      bVar4 = *param_2;
    }
    else {
      bVar4 = *param_2;
      if (*(ushort *)(param_1 + 0x1fc) <= (ushort)bVar4) goto LAB_0002d0b0;
    }
    uVar5 = 1;
    local_12 = bVar4;
  }
  else if ((param_3 & 2) == 0) {
    uVar1 = *(ushort *)(param_2 + 8);
    if (1 << *(sbyte *)(param_1 + 0x20c) <= (int)(uint)uVar1) goto LAB_0002d0b0;
    uVar5 = 2;
    local_12 = (byte)(uVar1 >> 8);
    local_11 = (undefined1)uVar1;
  }
  else {
    uVar1 = *(ushort *)(param_2 + 2);
    local_12 = (byte)(uVar1 >> 8);
    local_11 = (undefined1)uVar1;
    uVar2 = *(ushort *)(param_2 + 4);
    local_10 = (undefined1)(uVar2 >> 8);
    local_f = (undefined1)uVar2;
    uVar3 = *(ushort *)(param_2 + 6);
    local_e = (undefined1)(uVar3 >> 8);
    local_d = (undefined1)uVar3;
    if ((*(char *)(param_1 + 0x20c) == '\b') && ((ushort)(uVar3 | uVar2 | uVar1) >> 8 != 0))
    goto LAB_0002d0b0;
    uVar5 = 6;
  }
  FUN_0002c0a0(param_1,0x624b4744,&local_12,uVar5);
LAB_0002d0b0:
  if (__stack_chk_guard == local_c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_write_hIST(int param_1,int param_2,int param_3)

{
  code *pcVar1;
  undefined2 uVar2;
  int iVar3;
  int iVar4;
  undefined1 local_1f;
  undefined1 local_1e;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if (param_3 <= (int)(uint)*(ushort *)(param_1 + 0x1fc)) {
    if (SBORROW4(param_3 * 2,param_3)) {
LAB_0002d15a:
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x2d15a);
      (*pcVar1)();
    }
    FUN_0002bf70(param_1,0x68495354);
    if (0 < param_3) {
      iVar4 = 0;
      do {
        uVar2 = *(undefined2 *)(param_2 + iVar4 * 2);
        local_1f = (undefined1)((ushort)uVar2 >> 8);
        local_1e = (undefined1)uVar2;
        png_write_chunk_data(param_1,&local_1f,2);
        iVar3 = iVar4 + 1;
        if (SBORROW4(iVar3,iVar4)) goto LAB_0002d15a;
        iVar4 = iVar3;
      } while (iVar3 < param_3);
    }
    png_write_chunk_end(param_1);
  }
  if (__stack_chk_guard == local_1c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_write_tEXt(undefined4 param_1,undefined4 param_2,char *param_3)

{
  int iVar1;
  size_t sVar2;
  undefined1 auStack_6c [80];
  int local_1c;
  
  local_1c = __stack_chk_guard;
  iVar1 = png_check_keyword(param_1,param_2,auStack_6c);
  if (iVar1 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"tEXt: invalid keyword");
  }
  if ((param_3 == (char *)0x0) || (*param_3 == '\0')) {
    sVar2 = 0;
  }
  else {
    sVar2 = strlen(param_3);
    if (0x7ffffffeU - iVar1 < sVar2) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"tEXt: text too long");
    }
  }
  FUN_0002bf70(param_1,0x74455874,iVar1 + 1 + sVar2);
  png_write_chunk_data(param_1,auStack_6c,iVar1 + 1);
  if (sVar2 != 0) {
    png_write_chunk_data(param_1,param_3,sVar2);
  }
  png_write_chunk_end(param_1);
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_zTXt(int param_1,undefined4 param_2,char *param_3,int param_4)

{
  int iVar1;
  int iVar2;
  char *local_478;
  size_t sStack_474;
  int local_470;
  undefined1 uStack_69;
  undefined1 auStack_68 [80];
  int local_18;
  
  local_18 = __stack_chk_guard;
  if (param_4 == 0) {
    iVar1 = png_check_keyword(param_1,param_2,&uStack_69);
    if (iVar1 == 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"zTXt: invalid keyword");
    }
    iVar2 = iVar1 + 2;
    sStack_474 = 0;
    auStack_68[iVar1] = 0;
    if (param_3 != (char *)0x0) {
      sStack_474 = strlen(param_3);
    }
    local_470 = 0;
    local_478 = param_3;
    iVar1 = FUN_0002cb20(param_1,0x7a545874,&local_478,iVar2);
    if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,*(undefined4 *)(param_1 + 0x158));
    }
    FUN_0002bf70(param_1,0x7a545874,local_470 + iVar2);
    png_write_chunk_data(param_1,&uStack_69,iVar2);
    FUN_0002cc24(param_1,&local_478);
    png_write_chunk_end(param_1);
  }
  else {
    if (param_4 != -1) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"zTXt: invalid compression type");
    }
    png_write_tEXt(param_1,param_2,param_3);
  }
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_iTXt(int param_1,undefined4 param_2,undefined4 param_3,char *param_4,char *param_5,
                   char *param_6)

{
  bool bVar1;
  int iVar2;
  size_t sVar3;
  size_t sVar4;
  int iVar5;
  char *pcVar6;
  uint uVar7;
  int iVar8;
  uint uVar9;
  char *local_488;
  size_t sStack_484;
  size_t local_480;
  undefined1 auStack_7a [82];
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar2 = png_check_keyword(param_1,param_3,auStack_7a);
  if (iVar2 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"iTXt: invalid keyword");
  }
  switch(param_2) {
  case 0:
  case 2:
    bVar1 = true;
    break;
  case 0xffffffff:
  case 1:
    bVar1 = false;
    break;
  default:
                    // WARNING: Subroutine does not return
    png_error(param_1,"iTXt: invalid compression");
  }
  auStack_7a[iVar2 + 1] = bVar1;
  pcVar6 = "";
  auStack_7a[iVar2 + 2] = 0;
  if (param_4 == (char *)0x0) {
    param_4 = pcVar6;
  }
  sVar3 = strlen(param_4);
  if (param_5 == (char *)0x0) {
    param_5 = pcVar6;
  }
  sVar4 = strlen(param_5);
  if (param_6 == (char *)0x0) {
    param_6 = pcVar6;
  }
  sStack_484 = strlen(param_6);
  local_480 = 0;
  uVar7 = sVar3 + 1;
  iVar5 = uVar7 + iVar2 + 3;
  if (0x7ffffffdU - (iVar2 + 1) < uVar7) {
    iVar5 = 0x7fffffff;
  }
  uVar9 = sVar4 + 1;
  iVar8 = iVar5 + uVar9;
  if (0x7fffffffU - iVar5 < uVar9) {
    iVar8 = 0x7fffffff;
  }
  local_488 = param_6;
  if (bVar1) {
    iVar5 = FUN_0002cb20(param_1,0x69545874,&local_488,iVar8);
    sVar3 = local_480;
    if (iVar5 != 0) {
                    // WARNING: Subroutine does not return
      png_error(param_1,*(undefined4 *)(param_1 + 0x158));
    }
  }
  else {
    sVar3 = sStack_484;
    if (0x7fffffffU - iVar8 < sStack_484) {
                    // WARNING: Subroutine does not return
      png_error(param_1,"iTXt: uncompressed text too long");
    }
  }
  local_480 = sVar3;
  FUN_0002bf70(param_1,0x69545874,local_480 + iVar8);
  png_write_chunk_data(param_1,auStack_7a,iVar2 + 3);
  png_write_chunk_data(param_1,param_4,uVar7);
  png_write_chunk_data(param_1,param_5,uVar9);
  if (bVar1 == false) {
    png_write_chunk_data(param_1,param_6,local_480);
  }
  else {
    FUN_0002cc24(param_1,&local_488);
  }
  png_write_chunk_end(param_1);
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void png_write_oFFs(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined1 param_4)

{
  undefined1 auStack_21 [4];
  undefined1 auStack_1d [4];
  undefined1 local_19;
  int local_18;
  
  local_18 = __stack_chk_guard;
  png_save_int_32(auStack_21);
  png_save_int_32(auStack_1d,param_3);
  local_19 = param_4;
  FUN_0002c0a0(param_1,0x6f464673,auStack_21,9);
  if (__stack_chk_guard != local_18) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_pCAL(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                   int param_5,int param_6,char *param_7,int param_8)

{
  code *pcVar1;
  int iVar2;
  size_t sVar3;
  int iVar4;
  size_t sVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  undefined1 auStack_82 [80];
  undefined1 auStack_32 [4];
  undefined1 auStack_2e [4];
  undefined1 local_2a;
  undefined1 local_29;
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (3 < param_5) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"Unrecognized equation type for pCAL chunk");
  }
  iVar2 = png_check_keyword(param_1,param_2,auStack_82);
  if (iVar2 == 0) {
                    // WARNING: Subroutine does not return
    png_error(param_1,"pCAL: invalid keyword");
  }
  sVar3 = strlen(param_7);
  if (param_6 != 0) {
    sVar3 = sVar3 + 1;
  }
  iVar7 = sVar3 + iVar2 + 0xb;
  iVar4 = png_malloc(param_1,param_6 << 2);
  if (0 < param_6) {
    if (SBORROW4(param_6,1)) {
LAB_0002d62e:
                    // WARNING: Does not return
      pcVar1 = (code *)software_udf(0xfe,0x2d62e);
      (*pcVar1)();
    }
    iVar8 = 0;
    do {
      sVar5 = strlen(*(char **)(param_8 + iVar8 * 4));
      if (iVar8 != param_6 + -1) {
        sVar5 = sVar5 + 1;
      }
      iVar6 = iVar8 + 1;
      *(size_t *)(iVar4 + iVar8 * 4) = sVar5;
      if (SBORROW4(iVar6,iVar8)) goto LAB_0002d62e;
      iVar7 = iVar7 + sVar5;
      iVar8 = iVar6;
    } while (iVar6 < param_6);
  }
  FUN_0002bf70(param_1,0x7043414c,iVar7);
  png_write_chunk_data(param_1,auStack_82,iVar2 + 1);
  png_save_int_32(auStack_32,param_3);
  png_save_int_32(auStack_2e,param_4);
  local_2a = (undefined1)param_5;
  local_29 = (undefined1)param_6;
  png_write_chunk_data(param_1,auStack_32,10);
  png_write_chunk_data(param_1,param_7,sVar3);
  if (0 < param_6) {
    iVar2 = 0;
    do {
      png_write_chunk_data
                (param_1,*(undefined4 *)(param_8 + iVar2 * 4),*(undefined4 *)(iVar4 + iVar2 * 4));
      iVar7 = iVar2 + 1;
      if (SBORROW4(iVar7,iVar2)) goto LAB_0002d62e;
      iVar2 = iVar7;
    } while (iVar7 < param_6);
  }
  png_free(param_1,iVar4);
  png_write_chunk_end(param_1);
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_sCAL_s(undefined4 param_1,undefined1 param_2,char *param_3,char *param_4)

{
  size_t sVar1;
  size_t sVar2;
  uint uVar3;
  undefined1 local_64;
  undefined1 uStack_63;
  undefined1 auStack_62 [62];
  int local_24;
  
  local_24 = __stack_chk_guard;
  sVar1 = strlen(param_3);
  sVar2 = strlen(param_4);
  uVar3 = sVar1 + sVar2 + 2;
  if (uVar3 < 0x41) {
    local_64 = param_2;
    __aeabi_memcpy(&uStack_63,param_3,sVar1 + 1);
    __aeabi_memcpy(auStack_62 + sVar1,param_4,sVar2);
    FUN_0002c0a0(param_1,0x7343414c,&local_64,uVar3);
  }
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_pHYs(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined1 param_4)

{
  undefined1 local_15;
  undefined1 local_14;
  undefined1 local_13;
  undefined1 local_12;
  undefined1 local_11;
  undefined1 local_10;
  undefined1 local_f;
  undefined1 local_e;
  undefined1 local_d;
  int local_c;
  
  local_c = __stack_chk_guard;
  local_15 = (undefined1)((uint)param_2 >> 0x18);
  local_14 = (undefined1)((uint)param_2 >> 0x10);
  local_13 = (undefined1)((uint)param_2 >> 8);
  local_12 = (undefined1)param_2;
  local_11 = (undefined1)((uint)param_3 >> 0x18);
  local_10 = (undefined1)((uint)param_3 >> 0x10);
  local_f = (undefined1)((uint)param_3 >> 8);
  local_e = (undefined1)param_3;
  local_d = param_4;
  FUN_0002c0a0(param_1,0x70485973,&local_15,9);
  if (__stack_chk_guard != local_c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_tIME(undefined4 param_1,undefined2 *param_2)

{
  ushort uVar1;
  byte bVar2;
  ushort uVar3;
  byte in_r12;
  bool bVar4;
  bool bVar5;
  undefined1 local_1b;
  undefined1 local_1a;
  undefined1 local_19;
  undefined1 local_18;
  byte local_17;
  undefined1 local_16;
  byte local_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  uVar1 = param_2[1];
  uVar3 = uVar1 - 1 & 0xff;
  bVar5 = 10 < uVar3;
  bVar4 = uVar3 == 0xb;
  if (uVar3 < 0xc) {
    uVar3 = (uVar1 >> 8) - 1 & 0xff;
    bVar5 = 0x1d < uVar3;
    bVar4 = uVar3 == 0x1e;
  }
  if (!bVar5 || bVar4) {
    bVar2 = (byte)param_2[2];
    bVar5 = 0x16 < bVar2;
    bVar4 = bVar2 == 0x17;
    if (bVar2 < 0x18) {
      in_r12 = *(byte *)(param_2 + 3);
      bVar5 = 0x3b < in_r12;
      bVar4 = in_r12 == 0x3c;
    }
    if (!bVar5 || bVar4) {
      local_1b = (undefined1)((ushort)*param_2 >> 8);
      local_1a = (undefined1)*param_2;
      local_19 = (undefined1)uVar1;
      local_18 = (undefined1)(uVar1 >> 8);
      local_16 = (undefined1)((ushort)param_2[2] >> 8);
      local_17 = bVar2;
      local_15 = in_r12;
      FUN_0002c0a0(param_1,0x74494d45,&local_1b,7);
    }
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void png_write_start_row(int param_1)

{
  uint uVar1;
  undefined1 *puVar2;
  undefined4 uVar3;
  uint uVar4;
  int iVar5;
  
  uVar1 = (uint)*(byte *)(param_1 + 0x20d) * (uint)*(byte *)(param_1 + 0x210);
  if (uVar1 < 8) {
    uVar4 = uVar1 * *(int *)(param_1 + 0x1bc) + 7 >> 3;
  }
  else {
    uVar4 = (uVar1 >> 3) * *(int *)(param_1 + 0x1bc);
  }
  iVar5 = uVar4 + 1;
  *(undefined1 *)(param_1 + 0x213) = *(undefined1 *)(param_1 + 0x20e);
  *(char *)(param_1 + 0x212) = (char)uVar1;
  puVar2 = (undefined1 *)png_malloc(param_1,iVar5);
  *(undefined1 **)(param_1 + 0x1e0) = puVar2;
  *puVar2 = 0;
  uVar1 = (uint)*(byte *)(param_1 + 0x20a);
  if (*(int *)(param_1 + 0x1c0) == 1) {
    uVar1 = uVar1 & 0x1f;
  }
  if (*(int *)(param_1 + 0x1bc) == 1) {
    uVar1 = uVar1 & 0x2f;
  }
  if (uVar1 == 0) {
    uVar1 = 8;
  }
  *(char *)(param_1 + 0x20a) = (char)uVar1;
  if (((uVar1 & 0xf0) != 0) && (*(int *)(param_1 + 0x1e4) == 0)) {
    uVar3 = png_malloc(param_1,iVar5);
    *(undefined4 *)(param_1 + 0x1e4) = uVar3;
    if (1 < (((uVar1 >> 7) - ((int)(uVar1 << 0x1a) >> 0x1f)) - ((int)(uVar1 << 0x1b) >> 0x1f)) -
            ((int)(uVar1 << 0x19) >> 0x1f)) {
      uVar3 = png_malloc(param_1,iVar5);
      *(undefined4 *)(param_1 + 0x1e8) = uVar3;
    }
  }
  if ((uVar1 & 0xe0) != 0) {
    uVar3 = png_calloc(param_1,iVar5);
    *(undefined4 *)(param_1 + 0x1dc) = uVar3;
  }
  if (*(char *)(param_1 + 0x208) == '\0') {
    iVar5 = *(int *)(param_1 + 0x1c0);
  }
  else {
    iVar5 = *(int *)(param_1 + 0x1c0);
    if ((*(byte *)(param_1 + 0x138) & 2) == 0) {
      *(uint *)(param_1 + 0x1c4) = iVar5 + 7U >> 3;
      uVar1 = *(int *)(param_1 + 0x1bc) + 7U >> 3;
      goto LAB_0002d8ce;
    }
  }
  *(int *)(param_1 + 0x1c4) = iVar5;
  uVar1 = *(uint *)(param_1 + 0x1bc);
LAB_0002d8ce:
  *(uint *)(param_1 + 0x1c8) = uVar1;
  return;
}



void png_write_finish_row(int param_1)

{
  byte bVar1;
  ushort uVar2;
  uint uVar3;
  int iVar4;
  int iVar5;
  byte bVar6;
  uint uVar7;
  
  uVar3 = *(int *)(param_1 + 0x1d4) + 1;
  *(uint *)(param_1 + 0x1d4) = uVar3;
  if (uVar3 < *(uint *)(param_1 + 0x1c4)) {
    return;
  }
  uVar2 = *(ushort *)(param_1 + 0x208);
  if ((uVar2 & 0xff) != 0) {
    uVar3 = (uint)(uVar2 >> 8);
    *(undefined4 *)(param_1 + 0x1d4) = 0;
    if ((*(byte *)(param_1 + 0x138) & 2) == 0) {
      do {
        uVar3 = uVar3 + 1;
        bVar6 = (byte)uVar3;
        uVar7 = uVar3 & 0xff;
        if (6 < uVar7) break;
        iVar4 = __aeabi_uidiv((*(int *)(param_1 + 0x1bc) + (uint)(byte)(&DAT_0003376e)[uVar7] + -1)
                              - (uint)(byte)(&DAT_00033767)[uVar7]);
        bVar1 = (&DAT_00033760)[uVar7];
        *(int *)(param_1 + 0x1c8) = iVar4;
        iVar5 = __aeabi_uidiv((*(int *)(param_1 + 0x1c0) + (uint)bVar1 + -1) -
                              (uint)(byte)(&DAT_00033759)[uVar7]);
        *(int *)(param_1 + 0x1c4) = iVar5;
      } while ((iVar5 == 0) || (iVar4 == 0));
    }
    else {
      bVar6 = (char)(uVar2 >> 8) + 1;
    }
    *(byte *)(param_1 + 0x209) = bVar6;
    if (bVar6 < 7) {
      if (*(int *)(param_1 + 0x1dc) == 0) {
        return;
      }
      uVar3 = (uint)*(byte *)(param_1 + 0x210) * (uint)*(byte *)(param_1 + 0x20d);
      if (uVar3 < 8) {
        uVar3 = uVar3 * *(int *)(param_1 + 0x1bc) + 7 >> 3;
      }
      else {
        uVar3 = (uVar3 >> 3) * *(int *)(param_1 + 0x1bc);
      }
      __aeabi_memclr(*(int *)(param_1 + 0x1dc),uVar3 + 1);
      return;
    }
  }
  png_compress_IDAT(param_1,0,0,4);
  return;
}



void png_do_write_interlace(uint *param_1,undefined1 *param_2,int param_3)

{
  byte bVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  undefined1 *puVar6;
  uint uVar7;
  uint uVar8;
  undefined1 *puVar9;
  
  if (param_3 < 6) {
    bVar1 = *(byte *)((int)param_1 + 0xb);
    if (bVar1 == 4) {
      uVar8 = *param_1;
      uVar4 = (uint)(byte)(&DAT_00033767)[param_3];
      if (uVar4 < uVar8) {
        uVar7 = uVar4 << 2;
        uVar2 = 0;
        uVar3 = 4;
        bVar1 = (&DAT_0003376e)[param_3];
        uVar5 = uVar4;
        puVar6 = param_2;
        do {
          uVar2 = uVar2 | ((byte)param_2[uVar5 >> 1] >> (~uVar7 & 4) & 0xf) << (uVar3 & 0xff);
          if (uVar3 == 0) {
            puVar9 = puVar6 + 1;
            *puVar6 = (char)uVar2;
            uVar2 = 0;
            uVar3 = 4;
          }
          else {
            uVar3 = uVar3 - 4;
            puVar9 = puVar6;
          }
          uVar5 = uVar5 + bVar1;
          uVar7 = uVar7 + (uint)bVar1 * 4;
          puVar6 = puVar9;
        } while (uVar5 < uVar8);
        if (uVar3 != 4) {
          *puVar9 = (char)uVar2;
        }
      }
    }
    else if (bVar1 == 2) {
      uVar8 = *param_1;
      uVar4 = (uint)(byte)(&DAT_00033767)[param_3];
      if (uVar4 < uVar8) {
        uVar7 = uVar4 << 1;
        uVar2 = 0;
        uVar3 = 6;
        bVar1 = (&DAT_0003376e)[param_3];
        uVar5 = uVar4;
        puVar6 = param_2;
        do {
          uVar2 = uVar2 | ((byte)param_2[uVar5 >> 2] >> (~uVar7 & 6) & 3) << (uVar3 & 0xff);
          if (uVar3 == 0) {
            puVar9 = puVar6 + 1;
            *puVar6 = (char)uVar2;
            uVar3 = 6;
            uVar2 = 0;
          }
          else {
            uVar3 = uVar3 - 2;
            puVar9 = puVar6;
          }
          uVar5 = uVar5 + bVar1;
          uVar7 = uVar7 + (uint)bVar1 * 2;
          puVar6 = puVar9;
        } while (uVar5 < uVar8);
        if (uVar3 != 6) {
          *puVar9 = (char)uVar2;
        }
      }
    }
    else if (bVar1 == 1) {
      uVar8 = *param_1;
      uVar4 = (uint)(byte)(&DAT_00033767)[param_3];
      if (uVar4 < uVar8) {
        uVar2 = 0;
        uVar3 = 7;
        bVar1 = (&DAT_0003376e)[param_3];
        uVar5 = uVar4;
        puVar6 = param_2;
        do {
          uVar2 = uVar2 | ((byte)param_2[uVar5 >> 3] >> (~uVar5 & 7) & 1) << (uVar3 & 0xff);
          if (uVar3 == 0) {
            puVar9 = puVar6 + 1;
            *puVar6 = (char)uVar2;
            uVar3 = 7;
            uVar2 = 0;
          }
          else {
            uVar3 = uVar3 - 1;
            puVar9 = puVar6;
          }
          uVar5 = uVar5 + bVar1;
          puVar6 = puVar9;
        } while (uVar5 < uVar8);
        if (uVar3 != 7) {
          *puVar9 = (char)uVar2;
        }
      }
    }
    else {
      uVar8 = *param_1;
      uVar4 = (uint)(byte)(&DAT_00033767)[param_3];
      if (uVar4 < uVar8) {
        uVar2 = (uint)(bVar1 >> 3);
        puVar6 = param_2 + uVar2 * uVar4;
        bVar1 = (&DAT_0003376e)[param_3];
        uVar5 = uVar4;
        do {
          if (param_2 != puVar6) {
            __aeabi_memcpy(param_2,puVar6,uVar2);
          }
          uVar5 = uVar5 + bVar1;
          puVar6 = puVar6 + uVar2 * bVar1;
          param_2 = param_2 + uVar2;
        } while (uVar5 < uVar8);
      }
    }
    uVar4 = __aeabi_uidiv((*param_1 + (uint)(byte)(&DAT_0003376e)[param_3] + -1) - uVar4);
    *param_1 = uVar4;
    bVar1 = *(byte *)((int)param_1 + 0xb);
    if (bVar1 < 8) {
      uVar4 = bVar1 * uVar4 + 7 >> 3;
    }
    else {
      uVar4 = (bVar1 >> 3) * uVar4;
    }
    param_1[1] = uVar4;
  }
  return;
}



void png_write_find_filter(int param_1,int param_2)

{
  byte bVar1;
  byte bVar2;
  byte *pbVar3;
  uint uVar4;
  int iVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  byte *pbVar9;
  uint uVar10;
  
  uVar7 = 0xfffffeff;
  bVar1 = *(byte *)(param_1 + 0x20a);
  pbVar9 = *(byte **)(param_1 + 0x1e0);
  uVar8 = *(uint *)(param_2 + 4);
  uVar10 = *(byte *)(param_2 + 0xb) + 7 >> 3;
  if (bVar1 != 8 && (bVar1 & 8) != 0) {
    uVar7 = 0;
    pbVar3 = pbVar9;
    uVar4 = uVar8;
    if (uVar8 < 0x1ffffff) {
      for (; uVar4 != 0; uVar4 = uVar4 - 1) {
        bVar2 = pbVar3[1];
        uVar6 = (uint)bVar2;
        if (0x7fffffff < (uint)(int)(char)bVar2) {
          uVar6 = 0x100 - uVar6;
        }
        uVar7 = uVar7 + uVar6;
        pbVar3 = pbVar3 + 1;
      }
    }
    else {
      uVar4 = 1;
      do {
        uVar6 = (uint)pbVar9[uVar4];
        if (0x7fffffff < (uint)(int)(char)pbVar9[uVar4]) {
          uVar6 = 0x100 - uVar6;
        }
        uVar7 = uVar7 + uVar6;
      } while ((uVar4 < uVar8) && (uVar4 = uVar4 + 1, uVar7 < 0x1ffff00));
    }
  }
  if (bVar1 == 0x10) {
    FUN_0002dd52(param_1,uVar10,uVar8,uVar7);
    pbVar9 = *(byte **)(param_1 + 0x1e4);
LAB_0002dc7a:
    if (((bVar1 & 0x20) != 0) && (uVar4 = FUN_0002ddde(param_1,uVar8,uVar7), uVar4 < uVar7)) {
      pbVar9 = *(byte **)(param_1 + 0x1e4);
      uVar7 = uVar4;
      if (*(int *)(param_1 + 0x1e8) != 0) {
        *(int *)(param_1 + 0x1e4) = *(int *)(param_1 + 0x1e8);
        *(byte **)(param_1 + 0x1e8) = pbVar9;
      }
    }
    if (bVar1 != 0x40) goto LAB_0002dcb2;
    FUN_0002de20(param_1,uVar10,uVar8,uVar7);
    pbVar9 = *(byte **)(param_1 + 0x1e4);
  }
  else {
    if (((bVar1 & 0x10) != 0) && (uVar4 = FUN_0002dd52(param_1,uVar10,uVar8,uVar7), uVar4 < uVar7))
    {
      pbVar9 = *(byte **)(param_1 + 0x1e4);
      uVar7 = uVar4;
      if (*(int *)(param_1 + 0x1e8) != 0) {
        *(int *)(param_1 + 0x1e4) = *(int *)(param_1 + 0x1e8);
        *(byte **)(param_1 + 0x1e8) = pbVar9;
      }
    }
    if (bVar1 != 0x20) goto LAB_0002dc7a;
    FUN_0002ddde(param_1,uVar8,uVar7);
    pbVar9 = *(byte **)(param_1 + 0x1e4);
LAB_0002dcb2:
    if (((bVar1 & 0x40) != 0) && (uVar4 = FUN_0002de20(param_1,uVar10,uVar8,uVar7), uVar4 < uVar7))
    {
      pbVar9 = *(byte **)(param_1 + 0x1e4);
      uVar7 = uVar4;
      if (*(int *)(param_1 + 0x1e8) != 0) {
        *(int *)(param_1 + 0x1e4) = *(int *)(param_1 + 0x1e8);
        *(byte **)(param_1 + 0x1e8) = pbVar9;
      }
    }
    if (bVar1 == 0x80) {
      FUN_0002ded0(param_1,uVar10,uVar8,uVar7);
      pbVar9 = *(byte **)(param_1 + 0x1e4);
      goto LAB_0002dd0c;
    }
  }
  if (((bVar1 & 0x80) != 0) && (uVar8 = FUN_0002ded0(param_1,uVar10,uVar8,uVar7), uVar8 < uVar7)) {
    pbVar9 = *(byte **)(param_1 + 0x1e4);
    if (*(int *)(param_1 + 0x1e8) != 0) {
      *(int *)(param_1 + 0x1e4) = *(int *)(param_1 + 0x1e8);
      *(byte **)(param_1 + 0x1e8) = pbVar9;
    }
  }
LAB_0002dd0c:
  png_compress_IDAT(param_1,pbVar9,*(int *)(param_2 + 4) + 1,0);
  iVar5 = *(int *)(param_1 + 0x1dc);
  if (iVar5 != 0) {
    *(undefined4 *)(param_1 + 0x1dc) = *(undefined4 *)(param_1 + 0x1e0);
    *(int *)(param_1 + 0x1e0) = iVar5;
  }
  png_write_finish_row(param_1);
  uVar7 = *(int *)(param_1 + 0x238) + 1;
  *(uint *)(param_1 + 0x238) = uVar7;
  if (*(int *)(param_1 + 0x234) - 1U < uVar7) {
    png_write_flush(param_1);
    return;
  }
  return;
}



void FUN_0002dd52(int param_1,uint param_2,uint param_3,uint param_4)

{
  char cVar1;
  char cVar2;
  byte bVar3;
  uint uVar4;
  uint uVar5;
  byte *pbVar6;
  int iVar7;
  uint uVar8;
  char *pcVar9;
  undefined1 *puVar10;
  char *pcVar11;
  bool bVar12;
  
  puVar10 = *(undefined1 **)(param_1 + 0x1e4);
  pbVar6 = puVar10 + 1;
  *puVar10 = 1;
  iVar7 = *(int *)(param_1 + 0x1e0);
  pcVar11 = (char *)(iVar7 + 1);
  if (param_2 == 0) {
    uVar4 = 0;
    param_2 = 0;
  }
  else {
    uVar4 = 0;
    pcVar9 = (char *)(iVar7 + param_2 + 1);
    uVar8 = 0;
    do {
      bVar3 = pcVar11[uVar8];
      puVar10[uVar8 + 1] = bVar3;
      uVar8 = uVar8 + 1;
      uVar5 = (uint)bVar3;
      if (0x7fffffff < (uint)(int)(char)bVar3) {
        uVar5 = 0x100 - uVar5;
      }
      uVar4 = uVar4 + uVar5;
    } while (param_2 != uVar8);
    iVar7 = *(int *)(param_1 + 0x1e0);
    pbVar6 = puVar10 + param_2 + 1;
    pcVar11 = pcVar9;
  }
  if (param_2 < param_3) {
    pcVar9 = (char *)(iVar7 + 1);
    do {
      cVar1 = *pcVar9;
      cVar2 = *pcVar11;
      *pbVar6 = cVar2 - cVar1;
      uVar8 = (uint)(byte)(cVar2 - cVar1);
      if (0x7f < uVar8) {
        uVar8 = 0x100 - uVar8;
      }
      uVar4 = uVar4 + uVar8;
      bVar12 = param_4 <= uVar4;
      if (uVar4 <= param_4) {
        pcVar9 = pcVar9 + 1;
        pbVar6 = pbVar6 + 1;
        pcVar11 = pcVar11 + 1;
        param_2 = param_2 + 1;
        bVar12 = param_3 <= param_2;
      }
    } while (!bVar12);
  }
  return;
}



void FUN_0002ddde(int param_1,uint param_2,uint param_3)

{
  byte bVar1;
  uint uVar2;
  int iVar3;
  uint uVar4;
  uint uVar5;
  int iVar6;
  undefined1 *puVar7;
  bool bVar8;
  
  puVar7 = *(undefined1 **)(param_1 + 0x1e4);
  *puVar7 = 2;
  uVar2 = 0;
  if (param_2 == 0) {
    return;
  }
  iVar6 = *(int *)(param_1 + 0x1dc);
  iVar3 = *(int *)(param_1 + 0x1e0);
  uVar4 = 1;
  do {
    bVar1 = *(char *)(iVar3 + uVar4) - *(char *)(iVar6 + uVar4);
    puVar7[uVar4] = bVar1;
    uVar5 = (uint)bVar1;
    if (0x7f < uVar5) {
      uVar5 = 0x100 - uVar5;
    }
    uVar2 = uVar2 + uVar5;
  } while ((uVar2 <= param_3) && (bVar8 = uVar4 < param_2, uVar4 = uVar4 + 1, bVar8));
  return;
}



void FUN_0002de20(int param_1,uint param_2,uint param_3,uint param_4)

{
  byte bVar1;
  undefined1 *puVar2;
  uint uVar3;
  int iVar4;
  int iVar5;
  uint uVar6;
  byte *pbVar7;
  int iVar8;
  uint uVar9;
  byte *pbVar10;
  char *pcVar11;
  byte *pbVar12;
  bool bVar13;
  
  puVar2 = *(undefined1 **)(param_1 + 0x1e4);
  pbVar12 = puVar2 + 1;
  *puVar2 = 3;
  iVar4 = *(int *)(param_1 + 0x1dc);
  iVar8 = *(int *)(param_1 + 0x1e0);
  pcVar11 = (char *)(iVar8 + 1);
  pbVar10 = (byte *)(iVar4 + 1);
  if (param_2 == 0) {
    uVar3 = 0;
    param_2 = 0;
  }
  else {
    iVar5 = param_2 + 1;
    pbVar12 = puVar2 + iVar5;
    uVar3 = 0;
    uVar6 = 0;
    do {
      bVar1 = pcVar11[uVar6] - (pbVar10[uVar6] >> 1);
      puVar2[uVar6 + 1] = bVar1;
      uVar6 = uVar6 + 1;
      uVar9 = (uint)bVar1;
      if (0x7f < uVar9) {
        uVar9 = 0x100 - uVar9;
      }
      uVar3 = uVar3 + uVar9;
    } while (param_2 != uVar6);
    pbVar10 = (byte *)(iVar4 + iVar5);
    pcVar11 = (char *)(iVar8 + iVar5);
    iVar8 = *(int *)(param_1 + 0x1e0);
  }
  if (param_2 < param_3) {
    pbVar7 = (byte *)(iVar8 + 1);
    do {
      bVar1 = *pcVar11 - (char)((uint)*pbVar10 + (uint)*pbVar7 >> 1);
      *pbVar12 = bVar1;
      uVar6 = (uint)bVar1;
      if (0x7f < uVar6) {
        uVar6 = 0x100 - uVar6;
      }
      uVar3 = uVar3 + uVar6;
      bVar13 = param_4 <= uVar3;
      if (uVar3 <= param_4) {
        pbVar7 = pbVar7 + 1;
        param_2 = param_2 + 1;
        pcVar11 = pcVar11 + 1;
        pbVar10 = pbVar10 + 1;
        pbVar12 = pbVar12 + 1;
        bVar13 = param_3 <= param_2;
      }
    } while (!bVar13);
  }
  return;
}



void FUN_0002ded0(int param_1,uint param_2,uint param_3,uint param_4)

{
  char cVar1;
  undefined1 *puVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  byte bVar6;
  int iVar7;
  byte bVar8;
  char *pcVar9;
  byte *pbVar10;
  int iVar11;
  byte *pbVar12;
  int iVar13;
  byte *pbVar14;
  byte *pbVar15;
  bool bVar16;
  
  puVar2 = *(undefined1 **)(param_1 + 0x1e4);
  pbVar15 = puVar2 + 1;
  *puVar2 = 4;
  iVar11 = *(int *)(param_1 + 0x1dc);
  iVar13 = *(int *)(param_1 + 0x1e0);
  pcVar9 = (char *)(iVar13 + 1);
  pbVar10 = (byte *)(iVar11 + 1);
  if (param_2 == 0) {
    uVar3 = 0;
    param_2 = 0;
  }
  else {
    iVar7 = param_2 + 1;
    pbVar15 = puVar2 + iVar7;
    uVar3 = 0;
    uVar5 = 0;
    do {
      bVar6 = pbVar10[uVar5];
      cVar1 = pcVar9[uVar5];
      puVar2[uVar5 + 1] = cVar1 - bVar6;
      uVar5 = uVar5 + 1;
      uVar4 = (uint)(byte)(cVar1 - bVar6);
      if (0x7f < uVar4) {
        uVar4 = 0x100 - uVar4;
      }
      uVar3 = uVar3 + uVar4;
    } while (param_2 != uVar5);
    pcVar9 = (char *)(iVar13 + iVar7);
    pbVar10 = (byte *)(iVar11 + iVar7);
    iVar11 = *(int *)(param_1 + 0x1dc);
    iVar13 = *(int *)(param_1 + 0x1e0);
  }
  if (param_2 < param_3) {
    pbVar12 = (byte *)(iVar11 + 1);
    pbVar14 = (byte *)(iVar13 + 1);
    do {
      bVar6 = *pbVar12;
      cVar1 = *pcVar9;
      iVar7 = (uint)*pbVar10 - (uint)bVar6;
      iVar13 = (uint)*pbVar14 - (uint)bVar6;
      iVar11 = iVar13 + iVar7;
      if (iVar11 < 0) {
        iVar11 = -iVar11;
      }
      if (iVar13 < 0) {
        iVar13 = -iVar13;
      }
      if (iVar13 <= iVar11) {
        bVar6 = *pbVar10;
      }
      if (iVar7 < 0) {
        iVar7 = -iVar7;
      }
      bVar8 = *pbVar14;
      if (iVar11 < iVar7) {
        bVar8 = bVar6;
      }
      if (iVar13 < iVar7) {
        bVar8 = bVar6;
      }
      *pbVar15 = cVar1 - bVar8;
      uVar5 = (uint)(byte)(cVar1 - bVar8);
      if (0x7f < uVar5) {
        uVar5 = 0x100 - uVar5;
      }
      uVar3 = uVar3 + uVar5;
      bVar16 = param_4 <= uVar3;
      if (uVar3 <= param_4) {
        pbVar12 = pbVar12 + 1;
        pbVar14 = pbVar14 + 1;
        param_2 = param_2 + 1;
        pbVar10 = pbVar10 + 1;
        pcVar9 = pcVar9 + 1;
        pbVar15 = pbVar15 + 1;
        bVar16 = param_3 <= param_2;
      }
    } while (!bVar16);
  }
  return;
}



uint __aeabi_uidiv(uint param_1,uint param_2)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  bool bVar4;
  
  if (param_2 - 1 == 0) {
    return param_1;
  }
  if (param_2 == 0) {
    if (param_1 != 0) {
      param_1 = 0xffffffff;
    }
    uVar1 = __aeabi_ldiv0(param_1);
    return uVar1;
  }
  if (param_1 <= param_2) {
    return (uint)(param_1 == param_2);
  }
  if ((param_2 & param_2 - 1) == 0) {
    return param_1 >> (0x1fU - LZCOUNT(param_2) & 0xff);
  }
  uVar2 = param_2 << (LZCOUNT(param_2) - LZCOUNT(param_1) & 0xffU);
  uVar1 = 1 << (LZCOUNT(param_2) - LZCOUNT(param_1) & 0xffU);
  uVar3 = 0;
  while( true ) {
    if (uVar2 <= param_1) {
      param_1 = param_1 - uVar2;
      uVar3 = uVar3 | uVar1;
    }
    if (uVar2 >> 1 <= param_1) {
      param_1 = param_1 - (uVar2 >> 1);
      uVar3 = uVar3 | uVar1 >> 1;
    }
    if (uVar2 >> 2 <= param_1) {
      param_1 = param_1 - (uVar2 >> 2);
      uVar3 = uVar3 | uVar1 >> 2;
    }
    if (uVar2 >> 3 <= param_1) {
      param_1 = param_1 - (uVar2 >> 3);
      uVar3 = uVar3 | uVar1 >> 3;
    }
    bVar4 = param_1 == 0;
    if (!bVar4) {
      uVar1 = uVar1 >> 4;
      bVar4 = uVar1 == 0;
    }
    if (bVar4) break;
    uVar2 = uVar2 >> 4;
  }
  return uVar3;
}



void __aeabi_uidivmod(int param_1,int param_2)

{
  if (param_2 != 0) {
    __aeabi_uidiv();
    return;
  }
  if (param_1 != 0) {
    param_1 = -1;
  }
  __aeabi_ldiv0(param_1);
  return;
}



void __aeabi_ldiv0(void)

{
  raise(8);
  return;
}



int FUN_0002e094(uint *param_1)

{
  uint uVar1;
  
  uVar1 = *param_1;
  if ((uVar1 & 0x40000000) == 0) {
    uVar1 = uVar1 & 0x7fffffff;
  }
  else {
    uVar1 = uVar1 | 0x80000000;
  }
  return (int)param_1 + uVar1;
}



int FUN_0002e0ac(int param_1,int param_2,uint param_3)

{
  int iVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  
  if (param_2 == 0) {
    return 0;
  }
  iVar6 = 0;
  iVar5 = param_2 + -1;
  do {
    while( true ) {
      iVar1 = (iVar6 + iVar5) / 2;
      iVar4 = param_1 + iVar1 * 8;
      uVar2 = FUN_0002e094(iVar4);
      if (iVar1 == param_2 + -1) break;
      iVar3 = FUN_0002e094(param_1 + iVar1 * 8 + 8);
      if (param_3 < uVar2) goto LAB_0002e110;
      if (param_3 <= iVar3 - 1U) {
        return iVar4;
      }
      iVar6 = iVar1 + 1;
    }
    if (uVar2 <= param_3) {
      return iVar4;
    }
LAB_0002e110:
    if (iVar1 == iVar6) {
      return 0;
    }
    iVar5 = iVar1 + -1;
  } while( true );
}



code * FUN_0002e150(int param_1)

{
  if (param_1 == 1) {
    return __aeabi_unwind_cpp_pr1;
  }
  if (param_1 != 2) {
    if (param_1 == 0) {
      return __aeabi_unwind_cpp_pr0;
    }
    return (code *)0x0;
  }
  return __aeabi_unwind_cpp_pr2;
}



// WARNING: Removing unreachable block (ram,0x0002e1e0)

undefined4 FUN_0002e1a0(int param_1,int param_2,undefined4 param_3)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  bool bVar4;
  int local_14;
  undefined4 uStack_10;
  
  local_14 = param_2;
  uStack_10 = param_3;
  iVar1 = __gnu_Unwind_Find_exidx(param_2 + -2,&local_14,param_3,__gnu_Unwind_Find_exidx,param_1);
  if ((iVar1 == 0) || (iVar1 = FUN_0002e0ac(iVar1,local_14,param_2 + -2), iVar1 == 0)) {
    uVar2 = 9;
    *(undefined4 *)(param_1 + 0x10) = 0;
  }
  else {
    uVar2 = FUN_0002e094();
    iVar3 = *(int *)(iVar1 + 4);
    bVar4 = iVar3 == 1;
    if (bVar4) {
      iVar3 = 0;
      *(undefined4 *)(param_1 + 0x10) = 0;
    }
    *(undefined4 *)(param_1 + 0x48) = uVar2;
    if (bVar4) {
      uVar2 = 5;
    }
    else {
      if (iVar3 < 0) {
        *(int *)(param_1 + 0x4c) = iVar1 + 4;
      }
      else {
        uVar2 = FUN_0002e094();
        *(undefined4 *)(param_1 + 0x4c) = uVar2;
      }
      *(uint *)(param_1 + 0x50) = (uint)(iVar3 < 0);
      if (**(int **)(param_1 + 0x4c) < 0) {
        iVar1 = FUN_0002e150((uint)(**(int **)(param_1 + 0x4c) << 4) >> 0x1c);
        *(int *)(param_1 + 0x10) = iVar1;
        if (iVar1 == 0) {
          uVar2 = 9;
        }
        else {
          uVar2 = 0;
        }
      }
      else {
        uVar2 = FUN_0002e094();
        *(undefined4 *)(param_1 + 0x10) = uVar2;
        uVar2 = 0;
      }
    }
  }
  return uVar2;
}



void FUN_0002e2a0(uint *param_1)

{
  if ((*param_1 & 1) == 0) {
    if ((*param_1 & 2) == 0) {
      __gnu_Unwind_Restore_VFP(param_1 + 0x12);
    }
    else {
      __gnu_Unwind_Restore_VFP_D();
    }
  }
  if ((*param_1 & 4) == 0) {
    __gnu_Unwind_Restore_VFP_D_16_to_31(param_1 + 0x34);
  }
  if ((*param_1 & 8) == 0) {
    __gnu_Unwind_Restore_WMMXD(param_1 + 0x54);
  }
  if ((*param_1 & 0x10) != 0) {
    return;
  }
  __gnu_Unwind_Restore_WMMXC(param_1 + 0x74);
  return;
}



undefined4 FUN_0002e30c(int *param_1)

{
  undefined4 uVar1;
  
  if (*param_1 == 0) {
    uVar1 = 0;
  }
  else {
    uVar1 = *(undefined4 *)(*param_1 + (int)param_1);
  }
  return uVar1;
}



undefined4 FUN_0002e320(void)

{
  return 9;
}



void FUN_0002e328(void)

{
  return;
}



int FUN_0002e32c(int param_1,int param_2)

{
  int iVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  code *pcVar5;
  undefined4 uVar6;
  uint uVar7;
  undefined8 uVar8;
  undefined4 uStack_3f8;
  undefined4 uStack_3f4;
  undefined4 uStack_3f0;
  undefined4 uStack_3ec;
  undefined4 uStack_3e8;
  undefined4 uStack_3e4;
  undefined4 uStack_3e0;
  undefined4 uStack_3dc;
  undefined4 uStack_3d8;
  undefined4 uStack_3d4;
  undefined4 uStack_3d0;
  undefined4 uStack_3cc;
  undefined4 uStack_3c8;
  undefined4 uStack_3c4;
  undefined4 uStack_3c0;
  undefined4 uStack_3bc;
  undefined4 uStack_3b8;
  undefined4 uStack_3b4;
  undefined1 auStack_218 [56];
  undefined4 uStack_1e0;
  int iStack_34;
  int iStack_30;
  undefined4 uStack_2c;
  
  do {
    iVar1 = FUN_0002e1a0(param_1,*(undefined4 *)(param_2 + 0x40));
    if (iVar1 != 0) goto LAB_0002e34c;
    *(undefined4 *)(param_1 + 0x14) = *(undefined4 *)(param_2 + 0x40);
    iVar1 = param_2;
    iVar2 = (**(code **)(param_1 + 0x10))(1,param_1);
  } while (iVar2 == 8);
  if (iVar2 == 7) {
    FUN_0002e328(0,*(undefined4 *)(param_2 + 0x40));
    uVar8 = restore_core_regs(param_2 + 4);
    iVar3 = (int)((ulonglong)uVar8 >> 0x20);
    iVar2 = (int)uVar8;
    pcVar5 = *(code **)(iVar2 + 0xc);
    uVar6 = *(undefined4 *)(iVar2 + 0x18);
    uStack_3f4 = *(undefined4 *)(iVar3 + 4);
    uStack_3f0 = *(undefined4 *)(iVar3 + 8);
    uStack_3ec = *(undefined4 *)(iVar3 + 0xc);
    uStack_3e8 = *(undefined4 *)(iVar3 + 0x10);
    iVar4 = 0;
    uStack_3e4 = *(undefined4 *)(iVar3 + 0x14);
    uStack_3e0 = *(undefined4 *)(iVar3 + 0x18);
    uStack_3dc = *(undefined4 *)(iVar3 + 0x1c);
    uStack_3d8 = *(undefined4 *)(iVar3 + 0x20);
    uStack_3d4 = *(undefined4 *)(iVar3 + 0x24);
    uStack_3d0 = *(undefined4 *)(iVar3 + 0x28);
    uStack_3cc = *(undefined4 *)(iVar3 + 0x2c);
    uStack_3c8 = *(undefined4 *)(iVar3 + 0x30);
    uStack_3c4 = *(undefined4 *)(iVar3 + 0x34);
    uStack_3c0 = *(undefined4 *)(iVar3 + 0x38);
    uStack_3bc = *(undefined4 *)(iVar3 + 0x3c);
    uStack_3b8 = *(undefined4 *)(iVar3 + 0x40);
    uStack_3f8 = 0;
    uStack_2c = 0;
    iStack_34 = param_2;
    iStack_30 = param_1;
    do {
      iVar3 = FUN_0002e1a0(iVar2,uStack_3b8);
      if (iVar1 == 0) {
        uVar7 = 9;
      }
      else {
        uVar7 = 10;
      }
      if (iVar3 == 0) {
        *(undefined4 *)(iVar2 + 0x14) = uStack_3b8;
        memcpy(auStack_218,&uStack_3f8,0x1e0);
        iVar4 = (**(code **)(iVar2 + 0x10))(uVar7,iVar2,auStack_218);
        uStack_3b4 = uStack_1e0;
      }
      else {
        uVar7 = uVar7 | 0x10;
        uStack_3b4 = uStack_3c0;
      }
      iVar1 = (*pcVar5)(1,uVar7,iVar2,iVar2,&uStack_3f8,uVar6);
      if (iVar1 != 0) {
        return 9;
      }
      if (iVar3 != 0) {
        return iVar3;
      }
      memcpy(&uStack_3f8,auStack_218,0x1e0);
      iVar1 = 0;
    } while (iVar4 == 8);
    if (iVar4 == 7) {
      FUN_0002e328(0,uStack_3b8);
      restore_core_regs(&uStack_3f4);
    }
    return 9;
  }
LAB_0002e34c:
                    // WARNING: Subroutine does not return
  abort();
}



int FUN_0002e390(int param_1,int param_2,int param_3)

{
  int iVar1;
  int iVar2;
  int iVar3;
  code *pcVar4;
  undefined4 uVar5;
  uint uVar6;
  undefined4 local_3e8;
  undefined4 local_3e4;
  undefined4 uStack_3e0;
  undefined4 uStack_3dc;
  undefined4 uStack_3d8;
  undefined4 local_3d4;
  undefined4 uStack_3d0;
  undefined4 uStack_3cc;
  undefined4 uStack_3c8;
  undefined4 local_3c4;
  undefined4 uStack_3c0;
  undefined4 uStack_3bc;
  undefined4 uStack_3b8;
  undefined4 local_3b4;
  undefined4 uStack_3b0;
  undefined4 uStack_3ac;
  undefined4 local_3a8;
  undefined4 local_3a4;
  undefined1 auStack_208 [56];
  undefined4 local_1d0;
  
  pcVar4 = *(code **)(param_1 + 0xc);
  uVar5 = *(undefined4 *)(param_1 + 0x18);
  local_3e4 = *(undefined4 *)(param_2 + 4);
  uStack_3e0 = *(undefined4 *)(param_2 + 8);
  uStack_3dc = *(undefined4 *)(param_2 + 0xc);
  uStack_3d8 = *(undefined4 *)(param_2 + 0x10);
  iVar3 = 0;
  local_3d4 = *(undefined4 *)(param_2 + 0x14);
  uStack_3d0 = *(undefined4 *)(param_2 + 0x18);
  uStack_3cc = *(undefined4 *)(param_2 + 0x1c);
  uStack_3c8 = *(undefined4 *)(param_2 + 0x20);
  local_3c4 = *(undefined4 *)(param_2 + 0x24);
  uStack_3c0 = *(undefined4 *)(param_2 + 0x28);
  uStack_3bc = *(undefined4 *)(param_2 + 0x2c);
  uStack_3b8 = *(undefined4 *)(param_2 + 0x30);
  local_3b4 = *(undefined4 *)(param_2 + 0x34);
  uStack_3b0 = *(undefined4 *)(param_2 + 0x38);
  uStack_3ac = *(undefined4 *)(param_2 + 0x3c);
  local_3a8 = *(undefined4 *)(param_2 + 0x40);
  local_3e8 = 0;
  do {
    iVar1 = FUN_0002e1a0(param_1,local_3a8);
    if (param_3 == 0) {
      uVar6 = 9;
    }
    else {
      uVar6 = 10;
    }
    if (iVar1 == 0) {
      *(undefined4 *)(param_1 + 0x14) = local_3a8;
      memcpy(auStack_208,&local_3e8,0x1e0);
      iVar3 = (**(code **)(param_1 + 0x10))(uVar6,param_1,auStack_208);
      local_3a4 = local_1d0;
    }
    else {
      uVar6 = uVar6 | 0x10;
      local_3a4 = uStack_3b0;
    }
    iVar2 = (*pcVar4)(1,uVar6,param_1,param_1,&local_3e8,uVar5);
    if (iVar2 != 0) {
      return 9;
    }
    if (iVar1 != 0) {
      return iVar1;
    }
    memcpy(&local_3e8,auStack_208,0x1e0);
    param_3 = 0;
  } while (iVar3 == 8);
  if (iVar3 == 7) {
    FUN_0002e328(0,local_3a8);
    restore_core_regs(&local_3e4);
  }
  return 9;
}



undefined4 _Unwind_GetCFA(int param_1)

{
  return *(undefined4 *)(param_1 + 0x44);
}



undefined4 __gnu_Unwind_RaiseException(int param_1,int param_2)

{
  int iVar1;
  undefined4 local_1f8;
  undefined4 local_1f4;
  undefined4 uStack_1f0;
  undefined4 uStack_1ec;
  undefined4 uStack_1e8;
  undefined4 local_1e4;
  undefined4 uStack_1e0;
  undefined4 uStack_1dc;
  undefined4 uStack_1d8;
  undefined4 local_1d4;
  undefined4 uStack_1d0;
  undefined4 uStack_1cc;
  undefined4 uStack_1c8;
  undefined4 local_1c4;
  undefined4 uStack_1c0;
  undefined4 uStack_1bc;
  undefined4 local_1b8;
  
  *(undefined4 *)(param_2 + 0x40) = *(undefined4 *)(param_2 + 0x3c);
  local_1f4 = *(undefined4 *)(param_2 + 4);
  uStack_1f0 = *(undefined4 *)(param_2 + 8);
  uStack_1ec = *(undefined4 *)(param_2 + 0xc);
  uStack_1e8 = *(undefined4 *)(param_2 + 0x10);
  local_1e4 = *(undefined4 *)(param_2 + 0x14);
  uStack_1e0 = *(undefined4 *)(param_2 + 0x18);
  uStack_1dc = *(undefined4 *)(param_2 + 0x1c);
  uStack_1d8 = *(undefined4 *)(param_2 + 0x20);
  local_1d4 = *(undefined4 *)(param_2 + 0x24);
  uStack_1d0 = *(undefined4 *)(param_2 + 0x28);
  uStack_1cc = *(undefined4 *)(param_2 + 0x2c);
  uStack_1c8 = *(undefined4 *)(param_2 + 0x30);
  local_1c4 = *(undefined4 *)(param_2 + 0x34);
  uStack_1c0 = *(undefined4 *)(param_2 + 0x38);
  uStack_1bc = *(undefined4 *)(param_2 + 0x3c);
  local_1b8 = *(undefined4 *)(param_2 + 0x40);
  local_1f8 = 0xffffffff;
  do {
    iVar1 = FUN_0002e1a0(param_1,local_1b8);
    if (iVar1 != 0) {
      return 9;
    }
    iVar1 = (**(code **)(param_1 + 0x10))(0,param_1,&local_1f8);
  } while (iVar1 == 8);
  FUN_0002e2a0(&local_1f8);
  if (iVar1 == 6) {
    FUN_0002e32c(param_1,param_2);
  }
  return 9;
}



void __gnu_Unwind_ForcedUnwind(int param_1,undefined4 param_2,undefined4 param_3,int param_4)

{
  undefined4 uVar1;
  
  *(undefined4 *)(param_1 + 0x18) = param_3;
  uVar1 = *(undefined4 *)(param_4 + 0x3c);
  *(undefined4 *)(param_1 + 0xc) = param_2;
  *(undefined4 *)(param_4 + 0x40) = uVar1;
  FUN_0002e390(param_1,param_4,0);
  return;
}



void __gnu_Unwind_Resume(int param_1,int param_2)

{
  int iVar1;
  
  iVar1 = *(int *)(param_1 + 0xc);
  *(undefined4 *)(param_2 + 0x40) = *(undefined4 *)(param_1 + 0x14);
  if (iVar1 == 0) {
    iVar1 = (**(code **)(param_1 + 0x10))(2,param_1,param_2);
    if (iVar1 != 7) {
      if (iVar1 != 8) goto LAB_0002e5f0;
      FUN_0002e32c(param_1,param_2);
    }
    FUN_0002e328(0,*(undefined4 *)(param_2 + 0x40));
    restore_core_regs(param_2 + 4);
  }
  else {
    FUN_0002e390(param_1,param_2,1);
  }
LAB_0002e5f0:
                    // WARNING: Subroutine does not return
  abort();
}



void __gnu_Unwind_Resume_or_Rethrow(int param_1,int param_2)

{
  if (*(int *)(param_1 + 0xc) == 0) {
    __gnu_Unwind_RaiseException();
    return;
  }
  *(undefined4 *)(param_2 + 0x40) = *(undefined4 *)(param_2 + 0x3c);
  FUN_0002e390(param_1,param_2,0);
  return;
}



void _Unwind_Complete(void)

{
  return;
}



void _Unwind_DeleteException(int param_1)

{
  if (*(code **)(param_1 + 8) == (code *)0x0) {
    return;
  }
                    // WARNING: Could not recover jumptable at 0x0002e62c. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(param_1 + 8))(1,param_1);
  return;
}



undefined4
_Unwind_VRS_Get(int param_1,undefined4 param_2,uint param_3,int param_4,undefined4 *param_5)

{
  bool bVar1;
  
  switch(param_2) {
  case 0:
    bVar1 = param_3 == 0xf;
    if (param_3 < 0x10) {
      bVar1 = param_4 == 0;
    }
    if (bVar1) {
      *param_5 = *(undefined4 *)(param_1 + param_3 * 4 + 4);
      return 0;
    }
    break;
  case 1:
    return 1;
  case 2:
    break;
  case 3:
    return 1;
  case 4:
    return 1;
  }
  return 2;
}



undefined4 FUN_0002e68c(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 local_c;
  
  local_c = param_4;
  _Unwind_VRS_Get(param_1,0,param_2,0,&local_c,param_2,param_3);
  return local_c;
}



undefined4
_Unwind_VRS_Set(int param_1,undefined4 param_2,uint param_3,int param_4,undefined4 *param_5)

{
  bool bVar1;
  
  switch(param_2) {
  case 0:
    bVar1 = param_3 == 0xf;
    if (param_3 < 0x10) {
      bVar1 = param_4 == 0;
    }
    if (bVar1) {
      *(undefined4 *)(param_1 + param_3 * 4 + 4) = *param_5;
      return 0;
    }
    break;
  case 1:
    return 1;
  case 2:
    break;
  case 3:
    return 1;
  case 4:
    return 1;
  }
  return 2;
}



void FUN_0002e710(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  undefined4 local_c;
  
  local_c = param_3;
  _Unwind_VRS_Set(param_1,0,param_2,0,&local_c,param_2,param_3);
  return;
}



int __gnu_Unwind_Backtrace(code *param_1,undefined4 param_2,int param_3)

{
  int iVar1;
  undefined1 auStack_250 [16];
  code *local_240;
  undefined4 local_1f8;
  undefined4 local_1f4;
  undefined4 uStack_1f0;
  undefined4 uStack_1ec;
  undefined4 uStack_1e8;
  undefined4 local_1e4;
  undefined4 uStack_1e0;
  undefined4 uStack_1dc;
  undefined4 uStack_1d8;
  undefined4 local_1d4;
  undefined4 uStack_1d0;
  undefined4 uStack_1cc;
  undefined4 uStack_1c8;
  undefined4 local_1c4;
  undefined4 uStack_1c0;
  undefined4 uStack_1bc;
  undefined4 local_1b8;
  
  *(undefined4 *)(param_3 + 0x40) = *(undefined4 *)(param_3 + 0x3c);
  local_1f4 = *(undefined4 *)(param_3 + 4);
  uStack_1f0 = *(undefined4 *)(param_3 + 8);
  uStack_1ec = *(undefined4 *)(param_3 + 0xc);
  uStack_1e8 = *(undefined4 *)(param_3 + 0x10);
  local_1e4 = *(undefined4 *)(param_3 + 0x14);
  uStack_1e0 = *(undefined4 *)(param_3 + 0x18);
  uStack_1dc = *(undefined4 *)(param_3 + 0x1c);
  uStack_1d8 = *(undefined4 *)(param_3 + 0x20);
  local_1d4 = *(undefined4 *)(param_3 + 0x24);
  uStack_1d0 = *(undefined4 *)(param_3 + 0x28);
  uStack_1cc = *(undefined4 *)(param_3 + 0x2c);
  uStack_1c8 = *(undefined4 *)(param_3 + 0x30);
  local_1c4 = *(undefined4 *)(param_3 + 0x34);
  uStack_1c0 = *(undefined4 *)(param_3 + 0x38);
  uStack_1bc = *(undefined4 *)(param_3 + 0x3c);
  local_1b8 = *(undefined4 *)(param_3 + 0x40);
  local_1f8 = 0xffffffff;
  do {
    iVar1 = FUN_0002e1a0(auStack_250,local_1b8);
    if (iVar1 != 0) {
LAB_0002e7a0:
      iVar1 = 9;
      break;
    }
    FUN_0002e710(&local_1f8,0xc,auStack_250);
    iVar1 = (*param_1)(&local_1f8,param_2);
    if (iVar1 != 0) goto LAB_0002e7a0;
    iVar1 = (*local_240)(8,auStack_250,&local_1f8);
  } while ((iVar1 - 5U & 0xfffffffb) != 0);
  FUN_0002e2a0(&local_1f8);
  return iVar1;
}



// WARNING: Removing unreachable block (ram,0x0002e8b4)
// WARNING: Removing unreachable block (ram,0x0002e84c)
// WARNING: Removing unreachable block (ram,0x0002e854)
// WARNING: Removing unreachable block (ram,0x0002eb58)
// WARNING: Removing unreachable block (ram,0x0002e8b8)

undefined4 __aeabi_unwind_cpp_pr0(uint param_1,code *param_2,undefined4 param_3)

{
  ushort uVar1;
  bool bVar2;
  bool bVar3;
  uint uVar4;
  code *pcVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint *puVar9;
  uint uVar10;
  int iVar11;
  uint uVar12;
  uint *puVar13;
  code *pcStack_38;
  int iStack_34;
  uint *puStack_30;
  undefined1 uStack_2c;
  undefined1 uStack_2b;
  
  puStack_30 = (uint *)(*(int **)(param_2 + 0x4c) + 1);
  uVar10 = param_1 & 3;
  iStack_34 = **(int **)(param_2 + 0x4c) << 8;
  uStack_2b = 0;
  uStack_2c = 3;
  puVar13 = puStack_30;
  if (uVar10 == 2) {
    puVar13 = *(uint **)(param_2 + 0x38);
  }
  if ((*(uint *)(param_2 + 0x50) & 1) == 0) {
    bVar3 = false;
LAB_0002e898:
    do {
      while( true ) {
        if (*puVar13 == 0) goto LAB_0002eb50;
        uVar1 = *(ushort *)((int)puVar13 + 2);
        puVar9 = puVar13 + 1;
        uVar8 = *puVar13;
        uVar12 = (uVar1 & 0xfffffffe) + *(int *)(param_2 + 0x48);
        uVar4 = FUN_0002e68c(param_3,0xf);
        if (uVar4 < uVar12) {
          bVar2 = false;
        }
        else if (uVar4 < uVar12 + ((ushort)uVar8 & 0xfffffffe)) {
          bVar2 = true;
        }
        else {
          bVar2 = false;
        }
        uVar8 = (ushort)uVar8 & 1 | (uVar1 & 1) << 1;
        if (uVar8 != 1) break;
        if (uVar10 == 0) {
          if (bVar2) {
            uVar8 = *puVar9;
            if (puVar13[2] == 0xfffffffe) {
              return 9;
            }
            pcStack_38 = param_2 + 0x58;
            iVar7 = 1;
            if (puVar13[2] == 0xffffffff) {
LAB_0002e9c0:
              iVar11 = FUN_0002e68c(param_3,0xd);
              pcVar5 = param_2;
              if (iVar7 != 2) {
                pcVar5 = pcStack_38;
              }
              *(int *)(param_2 + 0x20) = iVar11;
              if (iVar7 == 2) {
                pcVar5 = pcVar5 + 0x2c;
                *(code **)pcVar5 = pcStack_38;
              }
LAB_0002ebd8:
              *(code **)(param_2 + 0x24) = pcVar5;
              *(uint **)(param_2 + 0x28) = puVar9;
              return 6;
            }
            uVar6 = FUN_0002e30c(puVar13 + 2);
            iVar7 = __cxa_type_match(param_2,uVar6,uVar8 >> 0x1f);
            if (iVar7 != 0) goto LAB_0002e9c0;
          }
        }
        else {
          iVar11 = *(int *)(param_2 + 0x20);
          iVar7 = FUN_0002e68c(param_3,0xd);
          if ((iVar11 == iVar7) && (puVar9 == *(uint **)(param_2 + 0x28))) {
            uVar6 = FUN_0002e094(puVar9);
            FUN_0002e710(param_3,0xf,uVar6);
LAB_0002eb20:
            uVar6 = 0;
            pcVar5 = param_2;
            goto LAB_0002ebb0;
          }
        }
        puVar13 = puVar13 + 3;
      }
      if (uVar8 != 0) {
        if (uVar8 != 2) {
          return 9;
        }
        uVar8 = *puVar9 & 0x7fffffff;
        if (uVar10 == 0) {
          if (bVar2) {
            uVar4 = ((param_1 ^ 8) << 0x1c) >> 0x1f;
            if (uVar8 == 0) {
              uVar4 = 1;
            }
            if (uVar4 != 0) {
              uVar4 = 0;
              do {
                if (uVar4 == uVar8) {
                  iVar7 = FUN_0002e68c(param_3,0xd);
                  *(int *)(param_2 + 0x20) = iVar7;
                  pcVar5 = pcStack_38;
                  goto LAB_0002ebd8;
                }
                uVar4 = uVar4 + 1;
                pcStack_38 = param_2 + 0x58;
                uVar6 = FUN_0002e30c(puVar9 + uVar4);
                iVar7 = __cxa_type_match(param_2,uVar6,0,&pcStack_38);
              } while (iVar7 == 0);
            }
          }
        }
        else {
          iVar11 = *(int *)(param_2 + 0x20);
          iVar7 = FUN_0002e68c(param_3,0xd);
          if ((iVar11 == iVar7) && (puVar9 == *(uint **)(param_2 + 0x28))) {
            *(uint *)(param_2 + 0x28) = uVar8;
            *(int *)(param_2 + 0x30) = 4;
            *(int *)(param_2 + 0x2c) = 0;
            *(uint **)(param_2 + 0x34) = puVar13 + 2;
            if ((int)*puVar9 < 0) {
              uVar6 = FUN_0002e094(puVar9 + uVar8 + 1);
              FUN_0002e710(param_3,0xf,uVar6);
              goto LAB_0002eb20;
            }
            bVar3 = true;
          }
        }
        if ((int)*puVar9 < 0) {
          puVar9 = puVar13 + 2;
        }
        puVar13 = puVar9 + uVar8 + 1;
        goto LAB_0002e898;
      }
      if (uVar10 == 0) {
        bVar2 = false;
      }
      puVar13 = puVar13 + 2;
    } while (!bVar2);
    pcVar5 = (code *)FUN_0002e094(puVar9);
    *(uint **)(param_2 + 0x38) = puVar13;
    iVar7 = __cxa_begin_cleanup(param_2);
    if (iVar7 == 0) {
      return 9;
    }
    uVar6 = 0xf;
  }
  else {
    bVar3 = false;
LAB_0002eb50:
    iVar7 = __gnu_unwind_execute(param_3,&iStack_34);
    if (iVar7 != 0) {
      return 9;
    }
    if (!bVar3) {
      return 8;
    }
    uVar6 = FUN_0002e68c(param_3,0xf);
    FUN_0002e710(param_3,0xe,uVar6);
    uVar6 = 0xf;
    pcVar5 = __cxa_call_unexpected;
  }
LAB_0002ebb0:
  FUN_0002e710(param_3,uVar6,pcVar5);
  return 7;
}



// WARNING: Removing unreachable block (ram,0x0002e8b4)
// WARNING: Removing unreachable block (ram,0x0002e834)
// WARNING: Removing unreachable block (ram,0x0002eb58)
// WARNING: Removing unreachable block (ram,0x0002e8b8)

undefined4 __aeabi_unwind_cpp_pr1(uint param_1,code *param_2,undefined4 param_3)

{
  ushort uVar1;
  bool bVar2;
  bool bVar3;
  uint uVar4;
  code *pcVar5;
  undefined4 uVar6;
  int iVar7;
  uint uVar8;
  uint *puVar9;
  uint uVar10;
  int iVar11;
  uint uVar12;
  uint *puVar13;
  code *pcStack_38;
  int iStack_34;
  uint *puStack_30;
  undefined1 uStack_2c;
  undefined1 uStack_2b;
  
  puStack_30 = *(uint **)(param_2 + 0x4c) + 1;
  uVar10 = param_1 & 3;
  uVar8 = **(uint **)(param_2 + 0x4c);
  uStack_2b = (undefined1)(uVar8 >> 0x10);
  iStack_34 = uVar8 << 0x10;
  uStack_2c = 2;
  puVar13 = puStack_30 + (uVar8 >> 0x10 & 0xff);
  if (uVar10 == 2) {
    puVar13 = *(uint **)(param_2 + 0x38);
  }
  if ((*(uint *)(param_2 + 0x50) & 1) == 0) {
    bVar3 = false;
LAB_0002e898:
    do {
      while( true ) {
        if (*puVar13 == 0) goto LAB_0002eb50;
        uVar1 = *(ushort *)((int)puVar13 + 2);
        puVar9 = puVar13 + 1;
        uVar8 = *puVar13;
        uVar12 = (uVar1 & 0xfffffffe) + *(int *)(param_2 + 0x48);
        uVar4 = FUN_0002e68c(param_3,0xf);
        if (uVar4 < uVar12) {
          bVar2 = false;
        }
        else if (uVar4 < uVar12 + ((ushort)uVar8 & 0xfffffffe)) {
          bVar2 = true;
        }
        else {
          bVar2 = false;
        }
        uVar8 = (ushort)uVar8 & 1 | (uVar1 & 1) << 1;
        if (uVar8 != 1) break;
        if (uVar10 == 0) {
          if (bVar2) {
            uVar8 = *puVar9;
            if (puVar13[2] == 0xfffffffe) {
              return 9;
            }
            pcStack_38 = param_2 + 0x58;
            iVar7 = 1;
            if (puVar13[2] == 0xffffffff) {
LAB_0002e9c0:
              iVar11 = FUN_0002e68c(param_3,0xd);
              pcVar5 = param_2;
              if (iVar7 != 2) {
                pcVar5 = pcStack_38;
              }
              *(int *)(param_2 + 0x20) = iVar11;
              if (iVar7 == 2) {
                pcVar5 = pcVar5 + 0x2c;
                *(code **)pcVar5 = pcStack_38;
              }
LAB_0002ebd8:
              *(code **)(param_2 + 0x24) = pcVar5;
              *(uint **)(param_2 + 0x28) = puVar9;
              return 6;
            }
            uVar6 = FUN_0002e30c(puVar13 + 2);
            iVar7 = __cxa_type_match(param_2,uVar6,uVar8 >> 0x1f);
            if (iVar7 != 0) goto LAB_0002e9c0;
          }
        }
        else {
          iVar11 = *(int *)(param_2 + 0x20);
          iVar7 = FUN_0002e68c(param_3,0xd);
          if ((iVar11 == iVar7) && (puVar9 == *(uint **)(param_2 + 0x28))) {
            uVar6 = FUN_0002e094(puVar9);
            FUN_0002e710(param_3,0xf,uVar6);
LAB_0002eb20:
            uVar6 = 0;
            pcVar5 = param_2;
            goto LAB_0002ebb0;
          }
        }
        puVar13 = puVar13 + 3;
      }
      if (uVar8 != 0) {
        if (uVar8 != 2) {
          return 9;
        }
        uVar8 = *puVar9 & 0x7fffffff;
        if (uVar10 == 0) {
          if (bVar2) {
            uVar4 = ((param_1 ^ 8) << 0x1c) >> 0x1f;
            if (uVar8 == 0) {
              uVar4 = 1;
            }
            if (uVar4 != 0) {
              uVar4 = 0;
              do {
                if (uVar4 == uVar8) {
                  iVar7 = FUN_0002e68c(param_3,0xd);
                  *(int *)(param_2 + 0x20) = iVar7;
                  pcVar5 = pcStack_38;
                  goto LAB_0002ebd8;
                }
                uVar4 = uVar4 + 1;
                pcStack_38 = param_2 + 0x58;
                uVar6 = FUN_0002e30c(puVar9 + uVar4);
                iVar7 = __cxa_type_match(param_2,uVar6,0,&pcStack_38);
              } while (iVar7 == 0);
            }
          }
        }
        else {
          iVar11 = *(int *)(param_2 + 0x20);
          iVar7 = FUN_0002e68c(param_3,0xd);
          if ((iVar11 == iVar7) && (puVar9 == *(uint **)(param_2 + 0x28))) {
            *(uint *)(param_2 + 0x28) = uVar8;
            *(int *)(param_2 + 0x30) = 4;
            *(int *)(param_2 + 0x2c) = 0;
            *(uint **)(param_2 + 0x34) = puVar13 + 2;
            if ((int)*puVar9 < 0) {
              uVar6 = FUN_0002e094(puVar9 + uVar8 + 1);
              FUN_0002e710(param_3,0xf,uVar6);
              goto LAB_0002eb20;
            }
            bVar3 = true;
          }
        }
        if ((int)*puVar9 < 0) {
          puVar9 = puVar13 + 2;
        }
        puVar13 = puVar9 + uVar8 + 1;
        goto LAB_0002e898;
      }
      if (uVar10 == 0) {
        bVar2 = false;
      }
      puVar13 = puVar13 + 2;
    } while (!bVar2);
    pcVar5 = (code *)FUN_0002e094(puVar9);
    *(uint **)(param_2 + 0x38) = puVar13;
    iVar7 = __cxa_begin_cleanup(param_2);
    if (iVar7 == 0) {
      return 9;
    }
    uVar6 = 0xf;
  }
  else {
    bVar3 = false;
LAB_0002eb50:
    iVar7 = __gnu_unwind_execute(param_3,&iStack_34);
    if (iVar7 != 0) {
      return 9;
    }
    if (!bVar3) {
      return 8;
    }
    uVar6 = FUN_0002e68c(param_3,0xf);
    FUN_0002e710(param_3,0xe,uVar6);
    uVar6 = 0xf;
    pcVar5 = __cxa_call_unexpected;
  }
LAB_0002ebb0:
  FUN_0002e710(param_3,uVar6,pcVar5);
  return 7;
}



// WARNING: Removing unreachable block (ram,0x0002e8bc)
// WARNING: Removing unreachable block (ram,0x0002e834)
// WARNING: Removing unreachable block (ram,0x0002eb58)
// WARNING: Removing unreachable block (ram,0x0002e8c0)
// WARNING: Removing unreachable block (ram,0x0002e8c4)

undefined4 __aeabi_unwind_cpp_pr2(uint param_1,code *param_2,undefined4 param_3)

{
  bool bVar1;
  bool bVar2;
  uint uVar3;
  code *pcVar4;
  undefined4 uVar5;
  int iVar6;
  uint uVar7;
  uint *puVar8;
  uint uVar9;
  uint uVar10;
  int iVar11;
  uint uVar12;
  uint *puVar13;
  code *local_38;
  int local_34;
  uint *local_30;
  undefined1 local_2c;
  undefined1 local_2b;
  
  local_30 = *(uint **)(param_2 + 0x4c) + 1;
  uVar9 = param_1 & 3;
  uVar7 = **(uint **)(param_2 + 0x4c);
  local_2b = (undefined1)(uVar7 >> 0x10);
  local_34 = uVar7 << 0x10;
  local_2c = 2;
  puVar13 = local_30 + (uVar7 >> 0x10 & 0xff);
  if (uVar9 == 2) {
    puVar13 = *(uint **)(param_2 + 0x38);
  }
  if ((*(uint *)(param_2 + 0x50) & 1) == 0) {
    bVar2 = false;
LAB_0002e898:
    do {
      while( true ) {
        uVar7 = *puVar13;
        if (uVar7 == 0) goto LAB_0002eb50;
        uVar10 = puVar13[1];
        puVar8 = puVar13 + 2;
        uVar12 = (uVar10 & 0xfffffffe) + *(int *)(param_2 + 0x48);
        uVar3 = FUN_0002e68c(param_3,0xf);
        if (uVar3 < uVar12) {
          bVar1 = false;
        }
        else if (uVar3 < uVar12 + (uVar7 & 0xfffffffe)) {
          bVar1 = true;
        }
        else {
          bVar1 = false;
        }
        uVar7 = uVar7 & 1 | (uVar10 & 1) << 1;
        if (uVar7 != 1) break;
        if (uVar9 == 0) {
          if (bVar1) {
            uVar7 = *puVar8;
            if (puVar13[3] == 0xfffffffe) {
              return 9;
            }
            local_38 = param_2 + 0x58;
            iVar6 = 1;
            if (puVar13[3] == 0xffffffff) {
LAB_0002e9c0:
              iVar11 = FUN_0002e68c(param_3,0xd);
              pcVar4 = param_2;
              if (iVar6 != 2) {
                pcVar4 = local_38;
              }
              *(int *)(param_2 + 0x20) = iVar11;
              if (iVar6 == 2) {
                pcVar4 = pcVar4 + 0x2c;
                *(code **)pcVar4 = local_38;
              }
LAB_0002ebd8:
              *(code **)(param_2 + 0x24) = pcVar4;
              *(uint **)(param_2 + 0x28) = puVar8;
              return 6;
            }
            uVar5 = FUN_0002e30c(puVar13 + 3);
            iVar6 = __cxa_type_match(param_2,uVar5,uVar7 >> 0x1f);
            if (iVar6 != 0) goto LAB_0002e9c0;
          }
        }
        else {
          iVar11 = *(int *)(param_2 + 0x20);
          iVar6 = FUN_0002e68c(param_3,0xd);
          if ((iVar11 == iVar6) && (puVar8 == *(uint **)(param_2 + 0x28))) {
            uVar5 = FUN_0002e094(puVar8);
            FUN_0002e710(param_3,0xf,uVar5);
LAB_0002eb20:
            uVar5 = 0;
            pcVar4 = param_2;
            goto LAB_0002ebb0;
          }
        }
        puVar13 = puVar13 + 4;
      }
      if (uVar7 != 0) {
        if (uVar7 != 2) {
          return 9;
        }
        uVar7 = *puVar8 & 0x7fffffff;
        if (uVar9 == 0) {
          if (bVar1) {
            uVar3 = ((param_1 ^ 8) << 0x1c) >> 0x1f;
            if (uVar7 == 0) {
              uVar3 = 1;
            }
            if (uVar3 != 0) {
              uVar3 = 0;
              do {
                if (uVar3 == uVar7) {
                  iVar6 = FUN_0002e68c(param_3,0xd);
                  *(int *)(param_2 + 0x20) = iVar6;
                  pcVar4 = local_38;
                  goto LAB_0002ebd8;
                }
                uVar3 = uVar3 + 1;
                local_38 = param_2 + 0x58;
                uVar5 = FUN_0002e30c(puVar8 + uVar3);
                iVar6 = __cxa_type_match(param_2,uVar5,0,&local_38);
              } while (iVar6 == 0);
            }
          }
        }
        else {
          iVar11 = *(int *)(param_2 + 0x20);
          iVar6 = FUN_0002e68c(param_3,0xd);
          if ((iVar11 == iVar6) && (puVar8 == *(uint **)(param_2 + 0x28))) {
            *(uint *)(param_2 + 0x28) = uVar7;
            *(int *)(param_2 + 0x30) = 4;
            *(int *)(param_2 + 0x2c) = 0;
            *(uint **)(param_2 + 0x34) = puVar13 + 3;
            if ((int)*puVar8 < 0) {
              uVar5 = FUN_0002e094(puVar8 + uVar7 + 1);
              FUN_0002e710(param_3,0xf,uVar5);
              goto LAB_0002eb20;
            }
            bVar2 = true;
          }
        }
        if ((int)*puVar8 < 0) {
          puVar8 = puVar13 + 3;
        }
        puVar13 = puVar8 + uVar7 + 1;
        goto LAB_0002e898;
      }
      if (uVar9 == 0) {
        bVar1 = false;
      }
      puVar13 = puVar13 + 3;
    } while (!bVar1);
    pcVar4 = (code *)FUN_0002e094(puVar8);
    *(uint **)(param_2 + 0x38) = puVar13;
    iVar6 = __cxa_begin_cleanup(param_2);
    if (iVar6 == 0) {
      return 9;
    }
    uVar5 = 0xf;
  }
  else {
    bVar2 = false;
LAB_0002eb50:
    iVar6 = __gnu_unwind_execute(param_3,&local_34);
    if (iVar6 != 0) {
      return 9;
    }
    if (!bVar2) {
      return 8;
    }
    uVar5 = FUN_0002e68c(param_3,0xf);
    FUN_0002e710(param_3,0xe,uVar5);
    uVar5 = 0xf;
    pcVar4 = __cxa_call_unexpected;
  }
LAB_0002ebb0:
  FUN_0002e710(param_3,uVar5,pcVar4);
  return 7;
}



// WARNING: Type propagation algorithm not settling

undefined4 _Unwind_VRS_Pop(uint *param_1,undefined4 param_2,uint param_3,uint param_4)

{
  undefined4 uVar1;
  uint *puVar2;
  uint uVar3;
  undefined4 *puVar4;
  int iVar5;
  uint uVar6;
  undefined4 *puVar7;
  uint uVar8;
  uint uVar9;
  undefined4 *puVar10;
  uint uVar11;
  bool bVar12;
  undefined4 auStack_1ac [33];
  undefined1 auStack_128 [124];
  undefined4 auStack_ac [36];
  
  switch(param_2) {
  case 0:
    if (param_4 != 0) {
      return 2;
    }
    iVar5 = 1;
    puVar2 = (uint *)param_1[0xe];
    do {
      if ((param_3 & 0xffff & 1 << (iVar5 - 1U & 0xff)) != 0) {
        uVar6 = *puVar2;
        puVar2 = puVar2 + 1;
        param_1[iVar5] = uVar6;
      }
      iVar5 = iVar5 + 1;
    } while (iVar5 != 0x11);
    if ((param_3 & 0x2000) != 0) {
      return 0;
    }
    param_1[0xe] = (uint)puVar2;
    return 0;
  case 1:
    if ((param_4 & 0xfffffffb) != 1) {
      return 2;
    }
    uVar6 = param_3 >> 0x10;
    param_3 = param_3 & 0xffff;
    uVar8 = param_3 + uVar6;
    if (param_4 == 1) {
      if (0x10 < uVar8) {
        return 2;
      }
      if (0xf < uVar6) {
        return 2;
      }
      uVar9 = 0;
      uVar8 = 1;
    }
    else {
      if (0x20 < uVar8) {
        return 2;
      }
      uVar9 = param_3;
      if (uVar6 < 0x10) {
        if (uVar8 < 0x11) {
          uVar9 = 0;
          uVar8 = uVar9;
          goto LAB_0002ecd4;
        }
        uVar9 = uVar8 - 0x10;
      }
      uVar8 = 0;
    }
LAB_0002ecd4:
    uVar11 = uVar9;
    if (uVar9 != 0) {
      uVar11 = 1;
    }
    if (param_4 != 5 && uVar9 != 0) {
      return 2;
    }
    if ((uVar6 < 0x10) && (uVar3 = *param_1, (uVar3 & 1) != 0)) {
      *param_1 = uVar3 & 0xfffffffe;
      if (param_4 != 5) {
        *param_1 = uVar3 & 0xfffffffc;
        __gnu_Unwind_Save_VFP(param_1 + 0x12);
        goto LAB_0002ed3c;
      }
      *param_1 = uVar3 & 0xfffffffe | 2;
      __gnu_Unwind_Save_VFP_D();
      if (uVar11 != 0) goto LAB_0002ed44;
LAB_0002ed24:
      __gnu_Unwind_Save_VFP_D(auStack_ac + 1);
LAB_0002ed70:
      if (uVar11 == 0) goto LAB_0002ed84;
      __gnu_Unwind_Save_VFP_D_16_to_31(auStack_128);
    }
    else {
LAB_0002ed3c:
      if (uVar11 == 0) {
        if (uVar8 != 0) {
          __gnu_Unwind_Save_VFP(auStack_ac + 1);
          goto LAB_0002ed84;
        }
        if (0xf < uVar6) goto LAB_0002ed84;
        goto LAB_0002ed24;
      }
LAB_0002ed44:
      if ((*param_1 & 4) != 0) {
        *param_1 = *param_1 & 0xfffffffb;
        __gnu_Unwind_Save_VFP_D_16_to_31(param_1 + 0x34);
      }
      if (uVar8 == 0) {
        if (uVar6 < 0x10) goto LAB_0002ed24;
        goto LAB_0002ed70;
      }
      __gnu_Unwind_Save_VFP(auStack_ac + 1);
    }
    param_3 = 0x10 - uVar6;
LAB_0002ed84:
    puVar4 = (undefined4 *)param_1[0xe];
    if (0 < (int)param_3) {
      for (iVar5 = 0; iVar5 != param_3 * 2; iVar5 = iVar5 + 1) {
        auStack_ac[uVar6 * 2 + iVar5 + 1U] = puVar4[iVar5];
      }
      puVar4 = puVar4 + iVar5;
    }
    if (uVar11 != 0) {
      puVar10 = puVar4 + uVar9 * 2;
      uVar9 = uVar6;
      if (uVar6 < 0x10) {
        uVar9 = 0x10;
      }
      puVar7 = auStack_1ac + uVar9 * 2;
      for (; puVar4 != puVar10; puVar4 = puVar4 + 1) {
        puVar7 = puVar7 + 1;
        *puVar7 = *puVar4;
      }
    }
    if (uVar8 != 0) {
      puVar4 = puVar4 + 1;
    }
    param_1[0xe] = (uint)puVar4;
    if (uVar8 == 0) {
      if (uVar6 < 0x10) {
        __gnu_Unwind_Restore_VFP_D(auStack_ac + 1);
      }
      if (uVar11 != 0) {
        __gnu_Unwind_Restore_VFP_D_16_to_31(auStack_128);
      }
    }
    else {
      __gnu_Unwind_Restore_VFP(auStack_ac + 1);
    }
    return 0;
  case 2:
    break;
  case 3:
    if (param_4 == 3) {
      if ((param_3 & 0xffff) + (param_3 >> 0x10) < 0x11) {
        if ((*param_1 & 8) != 0) {
          *param_1 = *param_1 & 0xfffffff7;
          __gnu_Unwind_Save_WMMXD(param_1 + 0x54);
        }
        puVar7 = auStack_ac + (param_3 >> 0x10) * 2;
        __gnu_Unwind_Save_WMMXD(auStack_ac + 1);
        puVar4 = (undefined4 *)param_1[0xe];
        puVar10 = puVar4 + (param_3 & 0xffff) * 2;
        for (; puVar4 != puVar10; puVar4 = puVar4 + 1) {
          puVar7 = puVar7 + 1;
          *puVar7 = *puVar4;
        }
        param_1[0xe] = (uint)puVar4;
        __gnu_Unwind_Restore_WMMXD(auStack_ac + 1);
        return 0;
      }
    }
    break;
  case 4:
    bVar12 = param_3 == 0x10;
    if (param_3 < 0x11) {
      bVar12 = param_4 == 0;
    }
    if (bVar12) {
      if ((*param_1 & 0x10) != 0) {
        *param_1 = *param_1 & 0xffffffef;
        __gnu_Unwind_Save_WMMXC(param_1 + 0x74);
      }
      puVar10 = auStack_ac + 1;
      __gnu_Unwind_Save_WMMXC(puVar10);
      puVar4 = (undefined4 *)param_1[0xe];
      uVar6 = 0;
      do {
        if ((param_3 & 1 << (uVar6 & 0xff)) != 0) {
          uVar1 = *puVar4;
          puVar4 = puVar4 + 1;
          puVar10[uVar6] = uVar1;
        }
        uVar6 = uVar6 + 1;
      } while (uVar6 != 4);
      param_1[0xe] = (uint)puVar4;
      __gnu_Unwind_Restore_WMMXC(puVar10);
      return 0;
    }
  }
  return 2;
}



undefined8 restore_core_regs(undefined8 *param_1)

{
  return *param_1;
}



undefined8 __gnu_Unwind_Restore_VFP(undefined8 *param_1)

{
  return *param_1;
}



void __gnu_Unwind_Save_VFP(undefined8 *param_1)

{
  undefined8 in_d0;
  undefined8 in_d1;
  undefined8 in_d2;
  undefined8 in_d3;
  undefined8 in_d4;
  undefined8 in_d5;
  undefined8 in_d6;
  undefined8 in_d7;
  undefined8 unaff_d8;
  undefined8 unaff_d9;
  undefined8 unaff_d10;
  undefined8 unaff_d11;
  undefined8 unaff_d12;
  undefined8 unaff_d13;
  undefined8 unaff_d14;
  undefined8 unaff_d15;
  
  *param_1 = in_d0;
  param_1[1] = in_d1;
  param_1[2] = in_d2;
  param_1[3] = in_d3;
  param_1[4] = in_d4;
  param_1[5] = in_d5;
  param_1[6] = in_d6;
  param_1[7] = in_d7;
  param_1[8] = unaff_d8;
  param_1[9] = unaff_d9;
  param_1[10] = unaff_d10;
  param_1[0xb] = unaff_d11;
  param_1[0xc] = unaff_d12;
  param_1[0xd] = unaff_d13;
  param_1[0xe] = unaff_d14;
  param_1[0xf] = unaff_d15;
  return;
}



undefined8 __gnu_Unwind_Restore_VFP_D(undefined8 *param_1)

{
  return *param_1;
}



void __gnu_Unwind_Save_VFP_D(undefined8 *param_1)

{
  undefined8 in_d0;
  undefined8 in_d1;
  undefined8 in_d2;
  undefined8 in_d3;
  undefined8 in_d4;
  undefined8 in_d5;
  undefined8 in_d6;
  undefined8 in_d7;
  undefined8 unaff_d8;
  undefined8 unaff_d9;
  undefined8 unaff_d10;
  undefined8 unaff_d11;
  undefined8 unaff_d12;
  undefined8 unaff_d13;
  undefined8 unaff_d14;
  undefined8 unaff_d15;
  
  *param_1 = in_d0;
  param_1[1] = in_d1;
  param_1[2] = in_d2;
  param_1[3] = in_d3;
  param_1[4] = in_d4;
  param_1[5] = in_d5;
  param_1[6] = in_d6;
  param_1[7] = in_d7;
  param_1[8] = unaff_d8;
  param_1[9] = unaff_d9;
  param_1[10] = unaff_d10;
  param_1[0xb] = unaff_d11;
  param_1[0xc] = unaff_d12;
  param_1[0xd] = unaff_d13;
  param_1[0xe] = unaff_d14;
  param_1[0xf] = unaff_d15;
  return;
}



void __gnu_Unwind_Restore_VFP_D_16_to_31(void)

{
  return;
}



void __gnu_Unwind_Save_VFP_D_16_to_31(undefined8 *param_1)

{
  undefined8 in_d16;
  undefined8 in_d17;
  undefined8 in_d18;
  undefined8 in_d19;
  undefined8 in_d20;
  undefined8 in_d21;
  undefined8 in_d22;
  undefined8 in_d23;
  undefined8 in_d24;
  undefined8 in_d25;
  undefined8 in_d26;
  undefined8 in_d27;
  undefined8 in_d28;
  undefined8 in_d29;
  undefined8 in_d30;
  undefined8 in_d31;
  
  *param_1 = in_d16;
  param_1[1] = in_d17;
  param_1[2] = in_d18;
  param_1[3] = in_d19;
  param_1[4] = in_d20;
  param_1[5] = in_d21;
  param_1[6] = in_d22;
  param_1[7] = in_d23;
  param_1[8] = in_d24;
  param_1[9] = in_d25;
  param_1[10] = in_d26;
  param_1[0xb] = in_d27;
  param_1[0xc] = in_d28;
  param_1[0xd] = in_d29;
  param_1[0xe] = in_d30;
  param_1[0xf] = in_d31;
  return;
}



int __gnu_Unwind_Restore_WMMXD(int param_1)

{
  undefined4 in_cr0;
  undefined4 in_cr1;
  undefined4 in_cr2;
  undefined4 in_cr3;
  undefined4 in_cr4;
  undefined4 in_cr5;
  undefined4 in_cr6;
  undefined4 in_cr7;
  undefined4 in_cr8;
  undefined4 in_cr9;
  undefined4 in_cr10;
  undefined4 in_cr11;
  undefined4 in_cr12;
  undefined4 in_cr13;
  undefined4 in_cr14;
  undefined4 in_cr15;
  
  coprocessor_loadlong(1,in_cr0,param_1);
  coprocessor_loadlong(1,in_cr1,param_1 + 8);
  coprocessor_loadlong(1,in_cr2,param_1 + 0x10);
  coprocessor_loadlong(1,in_cr3,param_1 + 0x18);
  coprocessor_loadlong(1,in_cr4,param_1 + 0x20);
  coprocessor_loadlong(1,in_cr5,param_1 + 0x28);
  coprocessor_loadlong(1,in_cr6,param_1 + 0x30);
  coprocessor_loadlong(1,in_cr7,param_1 + 0x38);
  coprocessor_loadlong(1,in_cr8,param_1 + 0x40);
  coprocessor_loadlong(1,in_cr9,param_1 + 0x48);
  coprocessor_loadlong(1,in_cr10,param_1 + 0x50);
  coprocessor_loadlong(1,in_cr11,param_1 + 0x58);
  coprocessor_loadlong(1,in_cr12,param_1 + 0x60);
  coprocessor_loadlong(1,in_cr13,param_1 + 0x68);
  coprocessor_loadlong(1,in_cr14,param_1 + 0x70);
  coprocessor_loadlong(1,in_cr15,param_1 + 0x78);
  return param_1 + 0x80;
}



int __gnu_Unwind_Save_WMMXD(int param_1)

{
  undefined4 in_cr0;
  undefined4 in_cr1;
  undefined4 in_cr2;
  undefined4 in_cr3;
  undefined4 in_cr4;
  undefined4 in_cr5;
  undefined4 in_cr6;
  undefined4 in_cr7;
  undefined4 in_cr8;
  undefined4 in_cr9;
  undefined4 in_cr10;
  undefined4 in_cr11;
  undefined4 in_cr12;
  undefined4 in_cr13;
  undefined4 in_cr14;
  undefined4 in_cr15;
  
  coprocessor_storelong(1,in_cr0,param_1);
  coprocessor_storelong(1,in_cr1,param_1 + 8);
  coprocessor_storelong(1,in_cr2,param_1 + 0x10);
  coprocessor_storelong(1,in_cr3,param_1 + 0x18);
  coprocessor_storelong(1,in_cr4,param_1 + 0x20);
  coprocessor_storelong(1,in_cr5,param_1 + 0x28);
  coprocessor_storelong(1,in_cr6,param_1 + 0x30);
  coprocessor_storelong(1,in_cr7,param_1 + 0x38);
  coprocessor_storelong(1,in_cr8,param_1 + 0x40);
  coprocessor_storelong(1,in_cr9,param_1 + 0x48);
  coprocessor_storelong(1,in_cr10,param_1 + 0x50);
  coprocessor_storelong(1,in_cr11,param_1 + 0x58);
  coprocessor_storelong(1,in_cr12,param_1 + 0x60);
  coprocessor_storelong(1,in_cr13,param_1 + 0x68);
  coprocessor_storelong(1,in_cr14,param_1 + 0x70);
  coprocessor_storelong(1,in_cr15,param_1 + 0x78);
  return param_1 + 0x80;
}



int __gnu_Unwind_Restore_WMMXC(int param_1)

{
  undefined4 in_cr8;
  undefined4 in_cr9;
  undefined4 in_cr10;
  undefined4 in_cr11;
  
  coprocessor_load2(1,in_cr8,param_1);
  coprocessor_load2(1,in_cr9,param_1 + 4);
  coprocessor_load2(1,in_cr10,param_1 + 8);
  coprocessor_load2(1,in_cr11,param_1 + 0xc);
  return param_1 + 0x10;
}



int __gnu_Unwind_Save_WMMXC(int param_1)

{
  undefined4 in_cr8;
  undefined4 in_cr9;
  undefined4 in_cr10;
  undefined4 in_cr11;
  
  coprocessor_store2(1,in_cr8,param_1);
  coprocessor_store2(1,in_cr9,param_1 + 4);
  coprocessor_store2(1,in_cr10,param_1 + 8);
  coprocessor_store2(1,in_cr11,param_1 + 0xc);
  return param_1 + 0x10;
}



void _Unwind_RaiseException
               (undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uStack_44;
  undefined4 uStack_40;
  undefined4 uStack_3c;
  undefined4 uStack_38;
  undefined4 uStack_34;
  
  uStack_44 = 0;
  uStack_40 = param_1;
  uStack_3c = param_2;
  uStack_38 = param_3;
  uStack_34 = param_4;
  __gnu_Unwind_RaiseException(param_1,&uStack_44,param_3,0,param_3);
  return;
}



void _Unwind_Resume(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uStack_44;
  undefined4 uStack_40;
  undefined4 uStack_3c;
  undefined4 uStack_38;
  undefined4 uStack_34;
  
  uStack_44 = 0;
  uStack_40 = param_1;
  uStack_3c = param_2;
  uStack_38 = param_3;
  uStack_34 = param_4;
  __gnu_Unwind_Resume(param_1,&uStack_44,param_3,0,param_3);
  return;
}



void ___Unwind_Resume_or_Rethrow
               (undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uStack_44;
  undefined4 uStack_40;
  undefined4 uStack_3c;
  undefined4 uStack_38;
  undefined4 uStack_34;
  
  uStack_44 = 0;
  uStack_40 = param_1;
  uStack_3c = param_2;
  uStack_38 = param_3;
  uStack_34 = param_4;
  __gnu_Unwind_Resume_or_Rethrow(param_1,&uStack_44,param_3,0,param_3);
  return;
}



void ___Unwind_ForcedUnwind(void)

{
  __gnu_Unwind_ForcedUnwind();
  return;
}



void _Unwind_Backtrace(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uStack_44;
  undefined4 uStack_40;
  undefined4 uStack_3c;
  undefined4 uStack_38;
  undefined4 uStack_34;
  
  uStack_44 = 0;
  uStack_40 = param_1;
  uStack_3c = param_2;
  uStack_38 = param_3;
  uStack_34 = param_4;
  __gnu_Unwind_Backtrace(param_1,param_2,&uStack_44,0,param_3);
  return;
}



uint FUN_0002f110(uint *param_1)

{
  char cVar1;
  uint *puVar2;
  uint uVar3;
  
  if ((char)param_1[2] == '\0') {
    if (*(char *)((int)param_1 + 9) == '\0') {
      return 0xb0;
    }
    *(char *)((int)param_1 + 9) = *(char *)((int)param_1 + 9) + -1;
    puVar2 = (uint *)param_1[1];
    param_1[1] = (uint)(puVar2 + 1);
    *param_1 = *puVar2;
    cVar1 = '\x03';
  }
  else {
    cVar1 = (char)param_1[2] + -1;
  }
  *(char *)(param_1 + 2) = cVar1;
  uVar3 = *param_1;
  *param_1 = uVar3 << 8;
  return uVar3 >> 0x18;
}



undefined4 FUN_0002f170(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 local_c;
  
  local_c = param_4;
  _Unwind_VRS_Get(param_1,0,0xc,0,&local_c,param_2,param_3);
  return local_c;
}



undefined4
thunk_FUN_0002f170(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uStack_c;
  
  uStack_c = param_4;
  _Unwind_VRS_Get(param_1,0,0xc,0,&uStack_c,param_2,param_3);
  return uStack_c;
}



undefined4 __gnu_unwind_execute(undefined4 param_1,undefined4 param_2)

{
  uint uVar1;
  undefined4 uVar2;
  uint uVar3;
  undefined4 uVar4;
  bool bVar5;
  int iVar6;
  int local_24 [2];
  
  bVar5 = false;
LAB_0002f1b0:
  do {
    while( true ) {
      uVar1 = FUN_0002f110(param_2);
      if (uVar1 == 0xb0) {
        if (!bVar5) {
          _Unwind_VRS_Get(param_1,0,0xe,0,local_24);
          _Unwind_VRS_Set(param_1,0,0xf,0,local_24);
        }
        return 0;
      }
      if ((uVar1 & 0x80) != 0) break;
      _Unwind_VRS_Get(param_1,0,0xd,0,local_24);
      iVar6 = (uVar1 & 0x3f) * 4 + 4;
      if ((uVar1 & 0x40) != 0) {
        iVar6 = -iVar6;
      }
      local_24[0] = local_24[0] + iVar6;
LAB_0002f2e4:
      _Unwind_VRS_Set(param_1,0,0xd,0,local_24);
    }
    uVar3 = uVar1 & 0xf0;
    if (uVar3 == 0x80) {
      uVar3 = FUN_0002f110(param_2);
      uVar3 = uVar3 | uVar1 << 8;
      if (uVar3 == 0x8000) {
        return 9;
      }
      uVar3 = uVar3 << 4;
      iVar6 = _Unwind_VRS_Pop(param_1,0,uVar3 & 0xffff,0);
      if (iVar6 != 0) {
        return 9;
      }
      if ((uVar3 & 0x8000) != 0) {
        bVar5 = true;
      }
      goto LAB_0002f1b0;
    }
    if (uVar3 == 0x90) {
      if ((uVar1 & 0xd) == 0xd) {
        return 9;
      }
      _Unwind_VRS_Get(param_1,0,uVar1 & 0xf,0,local_24);
      goto LAB_0002f2e4;
    }
    if (uVar3 == 0xa0) {
      uVar3 = 0xff0 >> (~uVar1 & 7) & 0xff0;
      uVar2 = 0;
      uVar4 = uVar2;
      if ((uVar1 & 8) != 0) {
        uVar3 = uVar3 | 0x4000;
      }
    }
    else if (uVar3 == 0xb0) {
      if (uVar1 == 0xb1) {
        uVar3 = FUN_0002f110(param_2);
        if (uVar3 == 0) {
          return 9;
        }
        if ((uVar3 & 0xf0) != 0) {
          return 9;
        }
        uVar2 = 0;
        uVar4 = uVar2;
      }
      else {
        if (uVar1 == 0xb2) {
          _Unwind_VRS_Get(param_1,0,0xd,0,local_24);
          uVar1 = FUN_0002f110(param_2);
          uVar3 = 2;
          while ((uVar1 & 0x80) != 0) {
            local_24[0] = local_24[0] + ((uVar1 & 0x7f) << (uVar3 & 0xff));
            uVar3 = uVar3 + 7;
            uVar1 = FUN_0002f110(param_2);
          }
          local_24[0] = local_24[0] + 0x204 + ((uVar1 & 0x7f) << (uVar3 & 0xff));
          goto LAB_0002f2e4;
        }
        if (uVar1 == 0xb3) {
          uVar1 = FUN_0002f110(param_2);
          uVar2 = 1;
          goto LAB_0002f440;
        }
        if ((uVar1 & 0xfc) == 0xb4) {
          return 9;
        }
        uVar2 = 1;
        uVar3 = (uVar1 & 7) + 1 | 0x80000;
        uVar4 = uVar2;
      }
    }
    else if (uVar3 == 0xc0) {
      if (uVar1 == 0xc6) {
        uVar1 = FUN_0002f110(param_2);
        uVar2 = 3;
LAB_0002f440:
        uVar3 = (uVar1 & 0xf) + 1 | (uVar1 & 0xf0) << 0xc;
        uVar4 = uVar2;
      }
      else if (uVar1 == 199) {
        uVar3 = FUN_0002f110(param_2);
        if (uVar3 == 0) {
          return 9;
        }
        if ((uVar3 & 0xf0) != 0) {
          return 9;
        }
        uVar2 = 4;
        uVar4 = 0;
      }
      else {
        if ((uVar1 & 0xf8) != 0xc0) {
          if (uVar1 == 200) {
            uVar1 = FUN_0002f110(param_2);
            uVar3 = (uVar1 & 0xf) + 1 | ((uVar1 & 0xf0) + 0x10) * 0x1000;
          }
          else {
            if (uVar1 != 0xc9) {
              return 9;
            }
            uVar1 = FUN_0002f110(param_2);
            uVar3 = (uVar1 & 0xf) + 1 | (uVar1 & 0xf0) << 0xc;
          }
          goto LAB_0002f514;
        }
        uVar2 = 3;
        uVar3 = (uVar1 & 0xf) + 1 | 0xa0000;
        uVar4 = uVar2;
      }
    }
    else {
      if ((uVar1 & 0xf8) != 0xd0) {
        return 9;
      }
      uVar3 = (uVar1 & 7) + 1 | 0x80000;
LAB_0002f514:
      uVar2 = 1;
      uVar4 = 5;
    }
    iVar6 = _Unwind_VRS_Pop(param_1,uVar2,uVar3,uVar4);
    if (iVar6 != 0) {
      return 9;
    }
  } while( true );
}



void __gnu_unwind_frame(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  int local_14;
  int local_10;
  undefined1 local_c;
  undefined1 local_b;
  undefined2 uStack_a;
  
  iVar1 = *(int *)(param_1 + 0x4c);
  local_14 = *(int *)(iVar1 + 4) << 8;
  local_10 = iVar1 + 8;
  uStack_a = (undefined2)((uint)param_4 >> 0x10);
  _local_c = CONCAT11(*(undefined1 *)(iVar1 + 7),3);
  __gnu_unwind_execute(param_2,&local_14,3,*(undefined1 *)(iVar1 + 7),param_1);
  return;
}



undefined4 _Unwind_GetRegionStart(void)

{
  int iVar1;
  
  iVar1 = thunk_FUN_0002f170();
  return *(undefined4 *)(iVar1 + 0x48);
}



int _Unwind_GetLanguageSpecificData(void)

{
  int iVar1;
  
  iVar1 = thunk_FUN_0002f170();
  return *(int *)(iVar1 + 0x4c) + (uint)*(byte *)(*(int *)(iVar1 + 0x4c) + 7) * 4 + 8;
}



void _Unwind_GetDataRelBase(void)

{
                    // WARNING: Subroutine does not return
  abort();
}



void _Unwind_GetTextRelBase(void)

{
                    // WARNING: Subroutine does not return
  abort();
}



void png_free(void)

{
  png_free();
  return;
}



void png_free(void)

{
  png_free();
  return;
}



void png_save_uint_32(void)

{
  png_save_uint_32();
  return;
}



void png_save_uint_32(void)

{
  png_save_uint_32();
  return;
}


