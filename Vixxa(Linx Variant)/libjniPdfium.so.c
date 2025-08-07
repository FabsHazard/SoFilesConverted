typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned int    dword;
typedef long long    longlong;
typedef unsigned char    uchar;
typedef unsigned int    uint;
typedef unsigned long    ulong;
typedef unsigned long long    ulonglong;
typedef unsigned char    undefined1;
typedef unsigned short    undefined2;
typedef unsigned int    undefined3;
typedef unsigned int    undefined4;
typedef unsigned long long    undefined5;
typedef unsigned long long    undefined8;
typedef unsigned short    ushort;
typedef int    wchar_t;
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

typedef struct stat stat, *Pstat;

typedef ulonglong __u_quad_t;

typedef __u_quad_t __dev_t;

typedef ulong __ino_t;

typedef uint __mode_t;

typedef uint __nlink_t;

typedef uint __uid_t;

typedef uint __gid_t;

typedef long __blksize_t;

typedef long __blkcnt_t;

typedef struct timespec timespec, *Ptimespec;

typedef long __time_t;

struct timespec {
    __time_t tv_sec;
    long tv_nsec;
};

struct stat {
    __dev_t st_dev;
    ushort __pad1;
    __ino_t st_ino;
    __mode_t st_mode;
    __nlink_t st_nlink;
    __uid_t st_uid;
    __gid_t st_gid;
    __dev_t st_rdev;
    ushort __pad2;
    __off_t st_size;
    __blksize_t st_blksize;
    __blkcnt_t st_blocks;
    struct timespec st_atim;
    struct timespec st_mtim;
    struct timespec st_ctim;
    ulong __unused4;
    ulong __unused5;
};

typedef int __ssize_t;

typedef __ssize_t ssize_t;

typedef struct __pthread_internal_slist __pthread_internal_slist, *P__pthread_internal_slist;

struct __pthread_internal_slist {
    struct __pthread_internal_slist *__next;
};

typedef union pthread_mutex_t pthread_mutex_t, *Ppthread_mutex_t;

typedef struct __pthread_mutex_s __pthread_mutex_s, *P__pthread_mutex_s;

typedef union _union_13 _union_13, *P_union_13;

typedef struct __pthread_internal_slist __pthread_slist_t;

union _union_13 {
    int __spins;
    __pthread_slist_t __list;
};

struct __pthread_mutex_s {
    int __lock;
    uint __count;
    int __owner;
    int __kind;
    uint __nusers;
    union _union_13 field5_0x14;
};

union pthread_mutex_t {
    struct __pthread_mutex_s __data;
    char __size[24];
    long __align;
};

typedef union pthread_mutexattr_t pthread_mutexattr_t, *Ppthread_mutexattr_t;

union pthread_mutexattr_t {
    char __size[4];
    int __align;
};

typedef union pthread_cond_t pthread_cond_t, *Ppthread_cond_t;

typedef struct _struct_16 _struct_16, *P_struct_16;

struct _struct_16 {
    int __lock;
    uint __futex;
    ulonglong __total_seq;
    ulonglong __wakeup_seq;
    ulonglong __woken_seq;
    void *__mutex;
    uint __nwaiters;
    uint __broadcast_seq;
};

union pthread_cond_t {
    struct _struct_16 __data;
    char __size[48];
    longlong __align;
};

typedef uint pthread_key_t;

typedef void *__gnuc_va_list;

typedef struct rgb rgb, *Prgb;

struct rgb { // PlaceHolder Structure
};

typedef struct AndroidBitmapInfo AndroidBitmapInfo, *PAndroidBitmapInfo;

struct AndroidBitmapInfo { // PlaceHolder Structure
};

typedef struct DocumentFile DocumentFile, *PDocumentFile;

struct DocumentFile { // PlaceHolder Structure
};

typedef struct _JNIEnv _JNIEnv, *P_JNIEnv;

struct _JNIEnv { // PlaceHolder Structure
};

typedef struct _jstring _jstring, *P_jstring;

struct _jstring { // PlaceHolder Structure
};

typedef struct _jmethodID _jmethodID, *P_jmethodID;

struct _jmethodID { // PlaceHolder Structure
};

typedef struct _jobject _jobject, *P_jobject;

struct _jobject { // PlaceHolder Structure
};

typedef struct _jclass _jclass, *P_jclass;

struct _jclass { // PlaceHolder Structure
};

typedef struct __forced_unwind __forced_unwind, *P__forced_unwind;

struct __forced_unwind { // PlaceHolder Structure
};

typedef struct __pointer_type_info __pointer_type_info, *P__pointer_type_info;

struct __pointer_type_info { // PlaceHolder Structure
};

typedef struct __class_type_info __class_type_info, *P__class_type_info;

struct __class_type_info { // PlaceHolder Structure
};

typedef struct __foreign_exception __foreign_exception, *P__foreign_exception;

struct __foreign_exception { // PlaceHolder Structure
};

typedef struct __si_class_type_info __si_class_type_info, *P__si_class_type_info;

struct __si_class_type_info { // PlaceHolder Structure
};

typedef struct __pbase_type_info __pbase_type_info, *P__pbase_type_info;

struct __pbase_type_info { // PlaceHolder Structure
};

typedef struct __fundamental_type_info __fundamental_type_info, *P__fundamental_type_info;

struct __fundamental_type_info { // PlaceHolder Structure
};

typedef struct __dyncast_result __dyncast_result, *P__dyncast_result;

struct __dyncast_result { // PlaceHolder Structure
};

typedef undefined __sub_kind;

typedef struct __upcast_result __upcast_result, *P__upcast_result;

struct __upcast_result { // PlaceHolder Structure
};

typedef struct exception exception, *Pexception;

struct exception { // PlaceHolder Structure
};

typedef struct wstring wstring, *Pwstring;

struct wstring { // PlaceHolder Structure
};

typedef struct bad_alloc bad_alloc, *Pbad_alloc;

struct bad_alloc { // PlaceHolder Structure
};

typedef struct type_info type_info, *Ptype_info;

struct type_info { // PlaceHolder Structure
};

typedef struct bad_cast bad_cast, *Pbad_cast;

struct bad_cast { // PlaceHolder Structure
};

typedef struct bad_exception bad_exception, *Pbad_exception;

struct bad_exception { // PlaceHolder Structure
};

typedef struct bad_typeid bad_typeid, *Pbad_typeid;

struct bad_typeid { // PlaceHolder Structure
};

typedef struct value_type value_type, *Pvalue_type;

struct value_type { // PlaceHolder Structure
};

typedef struct exception_ptr exception_ptr, *Pexception_ptr;

struct exception_ptr { // PlaceHolder Structure
};

typedef struct Mutex Mutex, *PMutex;

struct Mutex { // PlaceHolder Structure
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




// WARNING: Unknown calling convention -- yet parameter storage is locked

int asprintf(char **__ptr,char *__fmt,...)

{
  int iVar1;
  
  iVar1 = asprintf(__ptr,__fmt);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_mutex_destroy(pthread_mutex_t *__mutex)

{
  int iVar1;
  
  iVar1 = pthread_mutex_destroy(__mutex);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t pread(int __fd,void *__buf,size_t __nbytes,__off_t __offset)

{
  ssize_t sVar1;
  
  sVar1 = pread(__fd,__buf,__nbytes,__offset);
  return sVar1;
}



void __errno(void)

{
  __errno();
  return;
}



void __android_log_print(void)

{
  __android_log_print();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_mutex_lock(pthread_mutex_t *__mutex)

{
  int iVar1;
  
  iVar1 = pthread_mutex_lock(__mutex);
  return iVar1;
}



void FPDF_InitLibrary(void)

{
  FPDF_InitLibrary();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_mutex_unlock(pthread_mutex_t *__mutex)

{
  int iVar1;
  
  iVar1 = pthread_mutex_unlock(__mutex);
  return iVar1;
}



void FPDF_CloseDocument(void)

{
  FPDF_CloseDocument();
  return;
}



void FPDF_DestroyLibrary(void)

{
  FPDF_DestroyLibrary();
  return;
}



void FPDF_LoadPage(void)

{
  FPDF_LoadPage();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int vsnprintf(char *__s,size_t __maxlen,char *__format,__gnuc_va_list __arg)

{
  int iVar1;
  
  iVar1 = vsnprintf(__s,__maxlen,__format,__arg);
  return iVar1;
}



void __stack_chk_fail(void)

{
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fstat(int __fd,stat *__buf)

{
  int iVar1;
  
  iVar1 = fstat(__fd,__buf);
  return iVar1;
}



void FPDF_LoadCustomDocument(void)

{
  FPDF_LoadCustomDocument();
  return;
}



void FPDF_GetLastError(void)

{
  FPDF_GetLastError();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void free(void *__ptr)

{
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



void FPDF_LoadMemDocument(void)

{
  FPDF_LoadMemDocument();
  return;
}



void FPDF_GetPageCount(void)

{
  FPDF_GetPageCount();
  return;
}



void FPDF_ClosePage(void)

{
  FPDF_ClosePage();
  return;
}



void FPDF_GetPageWidth(void)

{
  FPDF_GetPageWidth();
  return;
}



void FPDF_GetPageHeight(void)

{
  FPDF_GetPageHeight();
  return;
}



void ANativeWindow_fromSurface(void)

{
  ANativeWindow_fromSurface();
  return;
}



void ANativeWindow_getFormat(void)

{
  ANativeWindow_getFormat();
  return;
}



void ANativeWindow_getWidth(void)

{
  ANativeWindow_getWidth();
  return;
}



void ANativeWindow_getHeight(void)

{
  ANativeWindow_getHeight();
  return;
}



void ANativeWindow_setBuffersGeometry(void)

{
  ANativeWindow_setBuffersGeometry();
  return;
}



void ANativeWindow_lock(void)

{
  ANativeWindow_lock();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strerror(int __errnum)

{
  char *pcVar1;
  
  pcVar1 = strerror(__errnum);
  return pcVar1;
}



void FPDFBitmap_CreateEx(void)

{
  FPDFBitmap_CreateEx();
  return;
}



void FPDFBitmap_FillRect(void)

{
  FPDFBitmap_FillRect();
  return;
}



void FPDF_RenderPageBitmap(void)

{
  FPDF_RenderPageBitmap();
  return;
}



void ANativeWindow_unlockAndPost(void)

{
  ANativeWindow_unlockAndPost();
  return;
}



void ANativeWindow_release(void)

{
  ANativeWindow_release();
  return;
}



void AndroidBitmap_getInfo(void)

{
  AndroidBitmap_getInfo();
  return;
}



void AndroidBitmap_lockPixels(void)

{
  AndroidBitmap_lockPixels();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = malloc(__size);
  return pvVar1;
}



void AndroidBitmap_unlockPixels(void)

{
  AndroidBitmap_unlockPixels();
  return;
}



void FPDFBookmark_GetFirstChild(void)

{
  FPDFBookmark_GetFirstChild();
  return;
}



void FPDFBookmark_GetNextSibling(void)

{
  FPDFBookmark_GetNextSibling();
  return;
}



void FPDFBookmark_GetDest(void)

{
  FPDFBookmark_GetDest();
  return;
}



void FPDFDest_GetPageIndex(void)

{
  FPDFDest_GetPageIndex();
  return;
}



void FPDF_GetMetaText(void)

{
  FPDF_GetMetaText();
  return;
}



void FPDFBookmark_GetTitle(void)

{
  FPDFBookmark_GetTitle();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_mutex_init(pthread_mutex_t *__mutex,pthread_mutexattr_t *__mutexattr)

{
  int iVar1;
  
  iVar1 = pthread_mutex_init(__mutex,__mutexattr);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void abort(void)

{
                    // WARNING: Subroutine does not return
  abort();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_key_delete(pthread_key_t __key)

{
  int iVar1;
  
  iVar1 = pthread_key_delete(__key);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * pthread_getspecific(pthread_key_t __key)

{
  void *pvVar1;
  
  pvVar1 = pthread_getspecific(__key);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_setspecific(pthread_key_t __key,void *__pointer)

{
  int iVar1;
  
  iVar1 = pthread_setspecific(__key,__pointer);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_key_create(pthread_key_t *__key,__destr_function *__destr_function)

{
  int iVar1;
  
  iVar1 = pthread_key_create(__key,__destr_function);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memset(void *__s,int __c,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memset(__s,__c,__n);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t write(int __fd,void *__buf,size_t __n)

{
  ssize_t sVar1;
  
  sVar1 = write(__fd,__buf,__n);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

wchar_t * wmemcpy(wchar_t *__s1,wchar_t *__s2,size_t __n)

{
  wchar_t *pwVar1;
  
  pwVar1 = wmemcpy(__s1,__s2,__n);
  return pwVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

wchar_t * wmemmove(wchar_t *__s1,wchar_t *__s2,size_t __n)

{
  wchar_t *pwVar1;
  
  pwVar1 = wmemmove(__s1,__s2,__n);
  return pwVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

wchar_t * wmemset(wchar_t *__s,wchar_t __c,size_t __n)

{
  wchar_t *pwVar1;
  
  pwVar1 = wmemset(__s,__c,__n);
  return pwVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int wmemcmp(wchar_t *__s1,wchar_t *__s2,size_t __n)

{
  int iVar1;
  
  iVar1 = wmemcmp(__s1,__s2,__n);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t wcslen(wchar_t *__s)

{
  size_t sVar1;
  
  sVar1 = wcslen(__s);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

wchar_t * wmemchr(wchar_t *__s,wchar_t __c,size_t __n)

{
  wchar_t *pwVar1;
  
  pwVar1 = wmemchr(__s,__c,__n);
  return pwVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memmove(void *__dest,void *__src,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memmove(__dest,__src,__n);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int memcmp(void *__s1,void *__s2,size_t __n)

{
  int iVar1;
  
  iVar1 = memcmp(__s1,__s2,__n);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t strlen(char *__s)

{
  size_t sVar1;
  
  sVar1 = strlen(__s);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memchr(void *__s,int __c,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memchr(__s,__c,__n);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long syscall(long __sysno,...)

{
  long lVar1;
  
  lVar1 = syscall(__sysno);
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int strcmp(char *__s1,char *__s2)

{
  int iVar1;
  
  iVar1 = strcmp(__s1,__s2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_cond_destroy(pthread_cond_t *__cond)

{
  int iVar1;
  
  iVar1 = pthread_cond_destroy(__cond);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_cond_wait(pthread_cond_t *__cond,pthread_mutex_t *__mutex)

{
  int iVar1;
  
  iVar1 = pthread_cond_wait(__cond,__mutex);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_cond_signal(pthread_cond_t *__cond)

{
  int iVar1;
  
  iVar1 = pthread_cond_signal(__cond);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_cond_broadcast(pthread_cond_t *__cond)

{
  int iVar1;
  
  iVar1 = pthread_cond_broadcast(__cond);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t fwrite(void *__ptr,size_t __size,size_t __n,FILE *__s)

{
  size_t sVar1;
  
  sVar1 = fwrite(__ptr,__size,__n,__s);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fputs(char *__s,FILE *__stream)

{
  int iVar1;
  
  iVar1 = fputs(__s,__stream);
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

void * realloc(void *__ptr,size_t __size)

{
  void *pvVar1;
  
  pvVar1 = realloc(__ptr,__size);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int sprintf(char *__s,char *__format,...)

{
  int iVar1;
  
  iVar1 = sprintf(__s,__format);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int strncmp(char *__s1,char *__s2,size_t __n)

{
  int iVar1;
  
  iVar1 = strncmp(__s1,__s2,__n);
  return iVar1;
}



void __gnu_Unwind_Find_exidx(void)

{
  __gnu_Unwind_Find_exidx();
  return;
}



void FUN_00016f00(int *param_1,int param_2)

{
  *param_1 = param_2;
  param_1[2] = 0;
  param_1[param_2 + 3] = 0;
  return;
}



void FUN_00016f10(void *param_1)

{
  bool bVar1;
  int iVar2;
  int *piVar3;
  
  piVar3 = (int *)((int)param_1 + 8);
  DataMemoryBarrier(0x1f);
  do {
    ExclusiveAccess(piVar3);
    iVar2 = *piVar3;
    bVar1 = (bool)hasExclusiveAccess(piVar3);
  } while (!bVar1);
  *piVar3 = iVar2 + -1;
  DataMemoryBarrier(0x1f);
  if (0 < iVar2) {
    return;
  }
  operator_delete(param_1);
  return;
}



void FUN_00016f3c(void *param_1)

{
  bool bVar1;
  int iVar2;
  int *piVar3;
  
  piVar3 = (int *)((int)param_1 + 8);
  DataMemoryBarrier(0x1f);
  do {
    ExclusiveAccess(piVar3);
    iVar2 = *piVar3;
    bVar1 = (bool)hasExclusiveAccess(piVar3);
  } while (!bVar1);
  *piVar3 = iVar2 + -1;
  DataMemoryBarrier(0x1f);
  if (0 < iVar2) {
    return;
  }
  operator_delete(param_1);
  return;
}



void _FINI_0(void)

{
  __cxa_finalize(&DAT_0002b000);
  return;
}



void _INIT_0(void)

{
  pthread_mutex_init((pthread_mutex_t *)&DAT_0002b010,(pthread_mutexattr_t *)0x0);
  FUN_00018d84(&DAT_0002b010,0x170fd,&DAT_0002b000);
  return;
}



void _INIT_1(void)

{
  uint uVar1;
  
  DAT_0002b01c = 0;
  uVar1 = pthread_key_create(&DAT_0002b018,(__destr_function *)0x18591);
  DAT_0002b01c = '\x01' - (char)uVar1;
  if (1 < uVar1) {
    DAT_0002b01c = '\0';
  }
  FUN_00018d84(&DAT_0002b018,0x18575,&DAT_0002b000);
  return;
}



void _INIT_2(void)

{
  DAT_0002bf30 = 0;
  return;
}



void _INIT_3(void)

{
  undefined4 in_r3;
  
  DAT_0002ff68 = &PTR_LAB_0001da08_1_0002abf0;
  FUN_00018d84(&DAT_0002ff68,&LAB_0001da08_1,&DAT_0002b000);
  DAT_0002ff64 = &PTR_LAB_0001d9f8_1_0002ac30;
  FUN_00018d84(&DAT_0002ff64,&LAB_0001d9f8_1,&DAT_0002b000,in_r3);
  return;
}



char * FUN_00017084(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  char *__fmt;
  char *local_c;
  undefined4 uStack_8;
  
  local_c = (char *)0x0;
  switch(param_1) {
  case 0:
    __fmt = "No error.";
    break;
  default:
    __fmt = "Unknown error.";
    break;
  case 2:
    __fmt = "File not found or could not be opened.";
    break;
  case 3:
    __fmt = "File not in PDF format or corrupted.";
    break;
  case 4:
    __fmt = "Incorrect password.";
    break;
  case 5:
    __fmt = "Unsupported security scheme.";
    break;
  case 6:
    __fmt = "Page not found or content error.";
  }
  uStack_8 = param_3;
  asprintf(&local_c,__fmt,0,&local_c,param_1);
  return local_c;
}



// android::Mutex::~Mutex()

Mutex * __thiscall android::Mutex::~Mutex(Mutex *this)

{
  pthread_mutex_destroy((pthread_mutex_t *)this);
  return this;
}



undefined4 FUN_00017108(int param_1,__off_t param_2,void *param_3,size_t param_4)

{
  ssize_t sVar1;
  undefined4 *puVar2;
  
  sVar1 = pread(param_1,param_3,param_4,param_2);
  if (sVar1 < 0) {
    puVar2 = (undefined4 *)__errno();
    __android_log_print(6,"jniPdfium","Cannot read from file descriptor. Error:%d",*puVar2);
    return 0;
  }
  return 1;
}



void FUN_00017140(void)

{
  pthread_mutex_lock((pthread_mutex_t *)&DAT_0002b010);
  if (DAT_0002b014 == 0) {
    __android_log_print(3,"jniPdfium","Init FPDF library");
    FPDF_InitLibrary();
  }
  DAT_0002b014 = DAT_0002b014 + 1;
  pthread_mutex_unlock((pthread_mutex_t *)&DAT_0002b010);
  return;
}



// _JNIEnv::NewObject(_jclass*, _jmethodID*, ...)

void _JNIEnv::NewObject(_jclass *param_1,_jmethodID *param_2,...)

{
  undefined4 in_r2;
  undefined4 in_r3;
  undefined4 uStack_4;
  
  uStack_4 = in_r3;
  (**(code **)(*(int *)param_1 + 0x74))(param_1,param_2,in_r2,&uStack_4,param_1,&uStack_4);
  return;
}



// _JNIEnv::CallLongMethod(_jobject*, _jmethodID*, ...)

void _JNIEnv::CallLongMethod(_jobject *param_1,_jmethodID *param_2,...)

{
  undefined4 in_r2;
  undefined4 in_r3;
  undefined4 uStack_4;
  
  uStack_4 = in_r3;
  (**(code **)(*(int *)param_1 + 0xd4))(param_1,param_2,in_r2,&uStack_4,param_1,&uStack_4);
  return;
}



// _JNIEnv::NewStringUTF(char const*)

void _JNIEnv::NewStringUTF(char *param_1)

{
  (**(code **)(*(int *)param_1 + 0x29c))();
  return;
}



// _JNIEnv::GetStringUTFChars(_jstring*, unsigned char*)

void _JNIEnv::GetStringUTFChars(_jstring *param_1,uchar *param_2)

{
  (**(code **)(*(int *)param_1 + 0x2a4))();
  return;
}



// _JNIEnv::ReleaseStringUTFChars(_jstring*, char const*)

void _JNIEnv::ReleaseStringUTFChars(_jstring *param_1,char *param_2)

{
  (**(code **)(*(int *)param_1 + 0x2a8))();
  return;
}



// DocumentFile::~DocumentFile()

DocumentFile * __thiscall DocumentFile::~DocumentFile(DocumentFile *this)

{
  if (*(int *)(this + 4) != 0) {
    FPDF_CloseDocument();
  }
  pthread_mutex_lock((pthread_mutex_t *)&DAT_0002b010);
  DAT_0002b014 = DAT_0002b014 + -1;
  if (DAT_0002b014 == 0) {
    __android_log_print(3,"jniPdfium","Destroy FPDF library");
    FPDF_DestroyLibrary();
  }
  pthread_mutex_unlock((pthread_mutex_t *)&DAT_0002b010);
  return this;
}



// jniThrowException(_JNIEnv*, char const*, char const*)

undefined4 jniThrowException(_JNIEnv *param_1,char *param_2,char *param_3)

{
  int iVar1;
  _JNIEnv *p_Var2;
  char *pcVar3;
  
  p_Var2 = param_1;
  pcVar3 = param_2;
  iVar1 = (**(code **)(*(int *)param_1 + 0x18))();
  if (iVar1 == 0) {
    __android_log_print(6,"jniPdfium","Unable to find exception class %s",param_2);
  }
  else {
    iVar1 = (**(code **)(*(int *)param_1 + 0x38))
                      (param_1,iVar1,param_3,*(code **)(*(int *)param_1 + 0x38),p_Var2,pcVar3);
    if (iVar1 == 0) {
      return 0;
    }
    __android_log_print(6,"jniPdfium","Failed throwing \'%s\' \'%s\'",param_2,param_3);
  }
  return 0xffffffff;
}



void FUN_000172b4(undefined4 param_1,int param_2,undefined4 param_3)

{
  undefined4 *puVar1;
  int iVar2;
  
  if (param_2 == 0) {
    puVar1 = (undefined4 *)__cxa_allocate_exception(4);
    *puVar1 = "Get page document null";
                    // WARNING: Subroutine does not return
    __cxa_throw(puVar1,&char_const*::typeinfo,0);
  }
  if (*(int *)(param_2 + 4) != 0) {
    iVar2 = FPDF_LoadPage(*(int *)(param_2 + 4),param_3);
    if (iVar2 == 0) {
      puVar1 = (undefined4 *)__cxa_allocate_exception(4);
      *puVar1 = "Loaded page is null";
                    // WARNING: Subroutine does not return
      __cxa_throw(puVar1,&char_const*::typeinfo,0);
    }
    return;
  }
  puVar1 = (undefined4 *)__cxa_allocate_exception(4);
  *puVar1 = "Get page pdf document null";
                    // WARNING: Subroutine does not return
  __cxa_throw(puVar1,&char_const*::typeinfo,0);
}



// jniThrowExceptionFmt(_JNIEnv*, char const*, char const*, ...)

void jniThrowExceptionFmt(_JNIEnv *param_1,char *param_2,char *param_3,...)

{
  undefined4 in_r3;
  char acStack_224 [512];
  int local_24;
  undefined4 uStack_4;
  
  local_24 = __stack_chk_guard;
  uStack_4 = in_r3;
  vsnprintf(acStack_224,0x200,param_3,&uStack_4);
  jniThrowException(param_1,param_2,acStack_224);
  if (local_24 != __stack_chk_guard) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



// NewLong(_JNIEnv*, long long)

void NewLong(_JNIEnv *param_1,longlong param_2)

{
  _jmethodID *p_Var1;
  undefined4 uVar2;
  undefined4 in_r2;
  
  p_Var1 = (_jmethodID *)
           (**(code **)(*(int *)param_1 + 0x18))
                     (param_1,"java/lang/Long",in_r2,*(code **)(*(int *)param_1 + 0x18),param_1);
  uVar2 = (**(code **)(*(int *)param_1 + 0x84))(param_1,p_Var1,"<init>",&DAT_00026db7);
  _JNIEnv::NewObject((_jclass *)param_1,p_Var1,uVar2);
  return;
}



// rgbTo565(rgb*)

uint rgbTo565(rgb *param_1)

{
  return ((int)(uint)(byte)param_1[1] >> 2) << 5 | ((int)(uint)(byte)*param_1 >> 3) << 0xb |
         (uint)((byte)param_1[2] >> 3);
}



// rgbBitmapTo565(void*, int, void*, AndroidBitmapInfo*)

void rgbBitmapTo565(void *param_1,int param_2,void *param_3,AndroidBitmapInfo *param_4)

{
  undefined2 uVar1;
  uint uVar2;
  uint uVar3;
  
  for (uVar3 = 0; uVar3 < *(uint *)(param_4 + 4); uVar3 = uVar3 + 1) {
    for (uVar2 = 0; uVar2 < *(uint *)param_4; uVar2 = uVar2 + 1) {
      uVar1 = rgbTo565((rgb *)(uVar2 * 3 + (int)param_1));
      *(undefined2 *)((int)param_3 + uVar2 * 2) = uVar1;
    }
    param_1 = (void *)((int)param_1 + param_2);
    param_3 = (void *)((int)param_3 + *(int *)(param_4 + 8));
  }
  return;
}



undefined8
Java_com_shockwave_pdfium_PdfiumCore_nativeOpenDocument
          (_jstring *param_1,undefined4 param_2,int param_3,uchar *param_4)

{
  int iVar1;
  int iVar2;
  void *__ptr;
  DocumentFile *this;
  char *pcVar3;
  char *pcVar4;
  stat local_88;
  
  iVar1 = fstat(param_3,&local_88);
  if (iVar1 < 0) {
    __android_log_print(6,"jniPdfium","Error getting file size");
LAB_000174a2:
    pcVar3 = "java/io/IOException";
    pcVar4 = "File is empty";
LAB_00017516:
    jniThrowException((_JNIEnv *)param_1,pcVar3,pcVar4);
  }
  else {
    if (local_88.st_blksize == 0) goto LAB_000174a2;
    this = (DocumentFile *)operator_new(0xc);
    *(undefined4 *)(this + 4) = 0;
    FUN_00017140();
    local_88.st_dev._0_4_ = local_88.st_blksize;
    local_88.st_dev._4_4_ = 0x17109;
    local_88._8_4_ = param_3;
    if (param_4 == (uchar *)0x0) {
      iVar1 = 0;
    }
    else {
      iVar1 = _JNIEnv::GetStringUTFChars(param_1,param_4);
    }
    iVar2 = FPDF_LoadCustomDocument(&local_88,iVar1);
    if (iVar1 != 0) {
      _JNIEnv::ReleaseStringUTFChars(param_1,(char *)param_4);
    }
    if (iVar2 != 0) {
      iVar1 = (int)this >> 0x1f;
      *(int *)(this + 4) = iVar2;
      goto LAB_00017554;
    }
    DocumentFile::~DocumentFile(this);
    operator_delete(this);
    iVar1 = FPDF_GetLastError();
    if (iVar1 == 4) {
      pcVar3 = "com/shockwave/pdfium/PdfPasswordException";
      pcVar4 = "Password required or incorrect password.";
      goto LAB_00017516;
    }
    __ptr = (void *)FUN_00017084();
    jniThrowExceptionFmt
              ((_JNIEnv *)param_1,"java/io/IOException","cannot create document: %s",__ptr);
    free(__ptr);
  }
  this = (DocumentFile *)0xffffffff;
  iVar1 = -1;
LAB_00017554:
  return CONCAT44(iVar1,this);
}



longlong Java_com_shockwave_pdfium_PdfiumCore_nativeOpenMemDocument
                   (_jstring *param_1,undefined4 param_2,undefined4 param_3,uchar *param_4)

{
  DocumentFile *this;
  int iVar1;
  void *pvVar2;
  uint __n;
  void *pvVar3;
  int iVar4;
  
  this = (DocumentFile *)operator_new(0xc);
  *(undefined4 *)(this + 4) = 0;
  FUN_00017140();
  if (param_4 == (uchar *)0x0) {
    iVar1 = 0;
  }
  else {
    iVar1 = _JNIEnv::GetStringUTFChars(param_1,param_4);
  }
  pvVar2 = (void *)(**(code **)(*(int *)param_1 + 0x2e0))(param_1,param_3,0);
  __n = (**(code **)(*(int *)param_1 + 0x2ac))(param_1,param_3);
  pvVar3 = operator_new__(__n);
  pvVar3 = memcpy(pvVar3,pvVar2,__n);
  iVar4 = FPDF_LoadMemDocument(pvVar3,__n,iVar1);
  (**(code **)(*(int *)param_1 + 0x300))(param_1,param_3,pvVar2,2);
  if (iVar1 != 0) {
    _JNIEnv::ReleaseStringUTFChars(param_1,(char *)param_4);
  }
  if (iVar4 == 0) {
    DocumentFile::~DocumentFile(this);
    operator_delete(this);
    iVar1 = FPDF_GetLastError();
    if (iVar1 == 4) {
      jniThrowException((_JNIEnv *)param_1,"com/shockwave/pdfium/PdfPasswordException",
                        "Password required or incorrect password.");
    }
    else {
      pvVar2 = (void *)FUN_00017084();
      jniThrowExceptionFmt
                ((_JNIEnv *)param_1,"java/io/IOException","cannot create document: %s",pvVar2);
      free(pvVar2);
    }
    return -1;
  }
  *(int *)(this + 4) = iVar4;
  return (longlong)(int)this;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeGetPageCount
               (undefined4 param_1,undefined4 param_2,int param_3)

{
  FPDF_GetPageCount(*(undefined4 *)(param_3 + 4));
  return;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeCloseDocument
               (undefined4 param_1,undefined4 param_2,DocumentFile *param_3)

{
  if (param_3 != (DocumentFile *)0x0) {
    DocumentFile::~DocumentFile(param_3);
    operator_delete(param_3);
    return;
  }
  return;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeLoadPage
               (undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
               undefined4 param_5)

{
  FUN_000172b4(param_1,param_3,param_5);
  return;
}



undefined4
Java_com_shockwave_pdfium_PdfiumCore_nativeLoadPages
          (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int param_5,
          int param_6)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  int iVar4;
  undefined8 *puVar5;
  undefined8 uVar6;
  int aiStack_38 [2];
  undefined1 auStack_30 [4];
  undefined4 local_2c;
  
  if (param_6 < param_5) {
    uVar2 = 0;
  }
  else {
    iVar4 = (param_6 - param_5) + 1;
    iVar1 = -(iVar4 * 8 + 8);
    puVar5 = (undefined8 *)((int)aiStack_38 + iVar1);
    for (iVar3 = 0; iVar3 <= param_6 - param_5; iVar3 = iVar3 + 1) {
      local_2c = param_3;
      uVar6 = FUN_000172b4(param_1,param_3,iVar3 + param_5);
      puVar5 = puVar5 + 1;
      *puVar5 = uVar6;
      param_3 = local_2c;
    }
    uVar2 = (**(code **)(*param_1 + 0x2d0))(param_1,iVar4);
    iVar3 = *param_1;
    *(undefined1 **)((int)aiStack_38 + iVar1) = auStack_30 + iVar1;
    (**(code **)(iVar3 + 0x350))(param_1,uVar2,0,iVar4);
  }
  return uVar2;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeClosePage
               (undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  FPDF_ClosePage(param_3);
  return;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeClosePages
               (int *param_1,undefined4 param_2,undefined4 param_3)

{
  int iVar1;
  int iVar2;
  undefined4 *puVar3;
  
  iVar1 = (**(code **)(*param_1 + 0x2ac))(param_1,param_3);
  iVar2 = (**(code **)(*param_1 + 0x2f0))(param_1,param_3,0);
  puVar3 = (undefined4 *)(iVar2 + -8);
  for (iVar2 = 0; iVar2 < iVar1; iVar2 = iVar2 + 1) {
    puVar3 = puVar3 + 2;
    FPDF_ClosePage(*puVar3);
  }
  return;
}



undefined4
Java_com_shockwave_pdfium_PdfiumCore_nativeGetPageWidthPixel
          (undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int param_5)

{
  double dVar1;
  
  dVar1 = (double)FPDF_GetPageWidth(param_3);
  return (int)(longlong)((dVar1 * (double)(longlong)param_5) / 72.0);
}



undefined4
Java_com_shockwave_pdfium_PdfiumCore_nativeGetPageHeightPixel
          (undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,int param_5)

{
  double dVar1;
  
  dVar1 = (double)FPDF_GetPageHeight(param_3);
  return (int)(longlong)((dVar1 * (double)(longlong)param_5) / 72.0);
}



undefined4
Java_com_shockwave_pdfium_PdfiumCore_nativeGetPageWidthPoint
          (undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  double dVar1;
  
  dVar1 = (double)FPDF_GetPageWidth(param_3);
  return (int)(longlong)dVar1;
}



undefined4
Java_com_shockwave_pdfium_PdfiumCore_nativeGetPageHeightPoint
          (undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  double dVar1;
  
  dVar1 = (double)FPDF_GetPageHeight(param_3);
  return (int)(longlong)dVar1;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeRenderPage
               (undefined4 param_1,undefined4 param_2,int param_3,undefined4 param_4,
               undefined4 param_5,undefined4 param_6,uint param_7,uint param_8,int param_9,
               int param_10,char param_11)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  char *pcVar5;
  int iVar6;
  int local_54;
  int local_50;
  int local_4c;
  undefined4 local_44;
  
  iVar1 = ANativeWindow_fromSurface(param_1,param_5);
  if (iVar1 == 0) {
    pcVar5 = "native window pointer null";
  }
  else {
    if (param_3 != 0) {
      iVar2 = ANativeWindow_getFormat();
      if (iVar2 != 1) {
        __android_log_print(3,"jniPdfium","Set format to RGBA_8888");
        uVar3 = ANativeWindow_getWidth(iVar1);
        uVar4 = ANativeWindow_getHeight(iVar1);
        ANativeWindow_setBuffersGeometry(iVar1,uVar3,uVar4,1);
      }
      iVar2 = ANativeWindow_lock(iVar1,&local_54,0);
      if (iVar2 != 0) {
        pcVar5 = strerror(-iVar2);
        __android_log_print(6,"jniPdfium","Locking native window failed: %s",pcVar5);
        return;
      }
      uVar3 = FPDFBitmap_CreateEx(local_54,local_50,4,local_44,local_4c << 2);
      if ((param_9 < local_54) || (param_10 < local_50)) {
        FPDFBitmap_FillRect(uVar3,0,0,local_54,local_50,0x848484ff);
      }
      iVar2 = param_10;
      if (local_50 < param_10) {
        iVar2 = local_50;
      }
      if (param_11 == '\0') {
        uVar4 = 0x10;
      }
      else {
        uVar4 = 0x11;
      }
      iVar6 = param_9;
      if (local_54 <= param_9) {
        iVar6 = local_54;
      }
      FPDFBitmap_FillRect(uVar3,param_7 & ~((int)param_7 >> 0x1f),param_8 & ~((int)param_8 >> 0x1f),
                          iVar6,iVar2,0xffffffff);
      FPDF_RenderPageBitmap(uVar3,param_3,param_7,param_8,param_9,param_10,0,uVar4);
      ANativeWindow_unlockAndPost(iVar1);
      ANativeWindow_release(iVar1);
      return;
    }
    pcVar5 = "Render page pointers invalid";
  }
  __android_log_print(6,"jniPdfium",pcVar5);
  return;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeRenderPageBitmap
               (undefined4 param_1,undefined4 param_2,int param_3,undefined4 param_4,int param_5,
               undefined4 param_6,uint param_7,uint param_8,int param_9,int param_10,char param_11)

{
  int iVar1;
  void *__ptr;
  char *pcVar2;
  char *pcVar3;
  undefined4 uVar4;
  int iVar5;
  undefined4 uVar6;
  int iVar7;
  void *local_40;
  int local_3c;
  int local_38;
  int local_34;
  int local_30;
  
  if ((param_3 == 0) || (param_5 == 0)) {
    pcVar2 = "Render page pointers invalid";
LAB_000179a0:
    __android_log_print(6,"jniPdfium",pcVar2);
  }
  else {
    iVar1 = AndroidBitmap_getInfo(param_1,param_5,(AndroidBitmapInfo *)&local_3c);
    if (iVar1 < 0) {
      pcVar2 = strerror(-iVar1);
      pcVar3 = "Fetching bitmap info failed: %s";
    }
    else {
      if ((local_30 != 1) && (local_30 != 4)) {
        pcVar2 = "Bitmap format must be RGBA_8888 or RGB_565";
        goto LAB_000179a0;
      }
      iVar1 = AndroidBitmap_lockPixels(param_1,param_5,&local_40);
      if (iVar1 == 0) {
        if (local_30 == 4) {
          __ptr = malloc(local_3c * local_38 * 3);
          uVar4 = 2;
          iVar1 = local_3c * 3;
        }
        else {
          uVar4 = 4;
          __ptr = local_40;
          iVar1 = local_34;
        }
        uVar4 = FPDFBitmap_CreateEx(local_3c,local_38,uVar4,__ptr,iVar1);
        if ((param_9 < local_3c) || (param_10 < local_38)) {
          FPDFBitmap_FillRect(uVar4,0,0,local_3c,local_38,0x848484ff);
        }
        iVar7 = param_10;
        if (local_38 < param_10) {
          iVar7 = local_38;
        }
        if (param_11 == '\0') {
          uVar6 = 0x10;
        }
        else {
          uVar6 = 0x11;
        }
        iVar5 = param_9;
        if (local_3c <= param_9) {
          iVar5 = local_3c;
        }
        FPDFBitmap_FillRect(uVar4,param_7 & ~((int)param_7 >> 0x1f),
                            param_8 & ~((int)param_8 >> 0x1f),iVar5,iVar7,0xffffffff);
        FPDF_RenderPageBitmap(uVar4,param_3,param_7,param_8,param_9,param_10,0,uVar6);
        if (local_30 == 4) {
          rgbBitmapTo565(__ptr,iVar1,local_40,(AndroidBitmapInfo *)&local_3c);
          free(__ptr);
        }
        AndroidBitmap_unlockPixels(param_1,param_5);
        return;
      }
      pcVar2 = strerror(-iVar1);
      pcVar3 = "Locking bitmap failed: %s";
    }
    __android_log_print(6,"jniPdfium",pcVar3,pcVar2);
  }
  return;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeGetFirstChildBookmark
               (_JNIEnv *param_1,undefined4 param_2,int param_3,undefined4 param_4,
               _jmethodID *param_5,undefined4 param_6)

{
  undefined4 uVar1;
  int iVar2;
  
  if (param_5 == (_jmethodID *)0x0) {
    uVar1 = 0;
  }
  else {
    uVar1 = (**(code **)(*(int *)param_1 + 0x7c))(param_1,param_5);
    uVar1 = (**(code **)(*(int *)param_1 + 0x84))(param_1,uVar1,"longValue",&DAT_00026f44);
    uVar1 = _JNIEnv::CallLongMethod((_jobject *)param_1,param_5,uVar1);
  }
  iVar2 = FPDFBookmark_GetFirstChild(*(undefined4 *)(param_3 + 4),uVar1);
  if (iVar2 != 0) {
    NewLong(param_1,CONCAT44(param_6,param_5));
    return;
  }
  return;
}



void Java_com_shockwave_pdfium_PdfiumCore_nativeGetSiblingBookmark
               (_JNIEnv *param_1,undefined4 param_2,int param_3,undefined4 param_4,
               undefined4 param_5,undefined4 param_6)

{
  int iVar1;
  
  iVar1 = FPDFBookmark_GetNextSibling(*(undefined4 *)(param_3 + 4),param_5);
  if (iVar1 != 0) {
    NewLong(param_1,CONCAT44(param_6,param_5));
    return;
  }
  return;
}



ulonglong Java_com_shockwave_pdfium_PdfiumCore_nativeGetBookmarkDestIndex
                    (undefined4 param_1,undefined4 param_2,int param_3,undefined4 param_4,
                    undefined4 param_5)

{
  int iVar1;
  uint uVar2;
  
  iVar1 = FPDFBookmark_GetDest(*(undefined4 *)(param_3 + 4),param_5);
  if (iVar1 != 0) {
    uVar2 = FPDFDest_GetPageIndex(*(undefined4 *)(param_3 + 4),iVar1);
    return (ulonglong)uVar2;
  }
  return 0xffffffffffffffff;
}



// std::wstring::value_type* WriteInto<std::wstring >(std::wstring*, unsigned int)

value_type * WriteInto<>(wstring *param_1,uint param_2)

{
  FUN_00019efc();
  FUN_0001a25c(param_1,param_2 - 1);
  FUN_00019888(param_1);
  return *(value_type **)param_1;
}



undefined4
Java_com_shockwave_pdfium_PdfiumCore_nativeGetDocumentMetaText
          (_jstring *param_1,undefined4 param_2,int param_3,undefined4 param_4,uchar *param_5)

{
  int iVar1;
  uint uVar2;
  undefined4 uVar3;
  value_type *pvVar4;
  _jstring *p_Var5;
  undefined *local_24;
  int iStack_20;
  
  p_Var5 = param_1;
  local_24 = (undefined *)param_2;
  iStack_20 = param_3;
  iVar1 = _JNIEnv::GetStringUTFChars(param_1,param_5);
  if ((iVar1 == 0) ||
     (uVar2 = FPDF_GetMetaText(*(undefined4 *)(param_3 + 4),iVar1,0,0,p_Var5), uVar2 < 3)) {
    uVar3 = _JNIEnv::NewStringUTF((char *)param_1);
  }
  else {
    uVar3 = *(undefined4 *)(param_3 + 4);
    local_24 = &DAT_0002ff48;
    pvVar4 = WriteInto<>((wstring *)&local_24,uVar2 + 1);
    FPDF_GetMetaText(uVar3,iVar1,pvVar4,uVar2,p_Var5);
    _JNIEnv::ReleaseStringUTFChars(param_1,(char *)param_5);
    uVar3 = (**(code **)(*(int *)param_1 + 0x28c))(param_1,local_24,(uVar2 >> 1) - 1);
    FUN_00019738((wstring *)&local_24);
  }
  return uVar3;
}



undefined4
Java_com_shockwave_pdfium_PdfiumCore_nativeGetBookmarkTitle
          (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  uint uVar1;
  undefined4 uVar2;
  value_type *pvVar3;
  undefined *local_1c;
  undefined4 uStack_18;
  
  local_1c = (undefined *)param_2;
  uStack_18 = param_3;
  uVar1 = FPDFBookmark_GetTitle(param_3,0,0,param_4,param_1);
  if (uVar1 < 3) {
    uVar2 = _JNIEnv::NewStringUTF((char *)param_1);
  }
  else {
    local_1c = &DAT_0002ff48;
    pvVar3 = WriteInto<>((wstring *)&local_1c,uVar1 + 1);
    FPDFBookmark_GetTitle(param_3,pvVar3,uVar1);
    uVar2 = (**(code **)(*param_1 + 0x28c))(param_1,local_1c,(uVar1 >> 1) - 1);
    FUN_00019738((wstring *)&local_1c);
  }
  return uVar2;
}



void FUN_00017ca4(byte *param_1,uint *param_2)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  
  uVar4 = 0;
  uVar3 = 0;
  do {
    uVar2 = (uint)*param_1;
    uVar1 = uVar3 & 0xff;
    uVar3 = uVar3 + 7;
    uVar4 = uVar4 | (uVar2 & 0x7f) << uVar1;
    param_1 = param_1 + 1;
  } while ((int)(uVar2 << 0x18) < 0);
  if ((uVar3 < 0x20) && ((int)(uVar2 << 0x19) < 0)) {
    uVar4 = uVar4 | -1 << (uVar3 & 0xff);
  }
  *param_2 = uVar4;
  return;
}



ushort * FUN_00017cd4(uint param_1,ushort *param_2,ushort *param_3,int *param_4)

{
  uint uVar1;
  ushort uVar2;
  ushort *puVar3;
  ushort *puVar4;
  int *piVar5;
  uint uVar6;
  byte *local_1c;
  
  if (param_1 != 0x50) {
    switch(param_1 & 0xf) {
    case 0:
    case 3:
    case 0xb:
      puVar3 = param_3 + 2;
      local_1c = *(byte **)param_3;
      break;
    case 1:
      local_1c = (byte *)0x0;
      uVar6 = 0;
      puVar4 = param_3;
      do {
        puVar3 = (ushort *)((int)puVar4 + 1);
        uVar2 = *puVar4;
        uVar1 = uVar6 & 0xff;
        uVar6 = uVar6 + 7;
        local_1c = (byte *)((uint)local_1c | ((byte)uVar2 & 0x7f) << uVar1);
        puVar4 = puVar3;
      } while (((byte)uVar2 & 0x80) != 0);
      break;
    case 2:
      puVar3 = param_3 + 1;
      local_1c = (byte *)(uint)*param_3;
      break;
    case 4:
    case 0xc:
      puVar3 = param_3 + 4;
      local_1c = *(byte **)param_3;
      break;
    default:
                    // WARNING: Subroutine does not return
      abort();
    case 9:
      puVar3 = (ushort *)FUN_00017ca4(param_3,&local_1c);
      break;
    case 10:
      puVar3 = param_3 + 1;
      local_1c = (byte *)(int)(short)*param_3;
    }
    if (local_1c != (byte *)0x0) {
      if ((param_1 & 0x70) != 0x10) {
        param_3 = param_2;
      }
      local_1c = local_1c + (int)param_3;
      if ((int)(param_1 << 0x18) < 0) {
        local_1c = *(byte **)local_1c;
      }
    }
    *param_4 = (int)local_1c;
    return puVar3;
  }
  piVar5 = (int *)((uint)((int)param_3 + 3) & 0xfffffffc);
  *param_4 = *piVar5;
  return (ushort *)(piVar5 + 1);
}



undefined4 FUN_00017d84(uint param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  if (param_1 == 0xff) {
    return 0;
  }
  param_1 = param_1 & 0x70;
  if (param_1 == 0x20) {
    uVar1 = _Unwind_GetTextRelBase(param_2,param_2,param_3,param_4);
    return uVar1;
  }
  if (param_1 < 0x21) {
    if (param_1 == 0) {
      return 0;
    }
    if (param_1 == 0x10) {
      return 0;
    }
  }
  else {
    if (param_1 == 0x40) {
      uVar1 = _Unwind_GetRegionStart(param_2,param_2,param_3,param_4);
      return uVar1;
    }
    if (param_1 == 0x50) {
      return 0;
    }
    if (param_1 == 0x30) {
      uVar1 = _Unwind_GetDataRelBase(param_2,param_2,param_3,param_4);
      return uVar1;
    }
  }
                    // WARNING: Subroutine does not return
  abort();
}



void FUN_00017dd0(int param_1,char *param_2,int *param_3,undefined4 param_4)

{
  char cVar1;
  byte bVar2;
  uint uVar3;
  int iVar4;
  undefined4 uVar5;
  byte *pbVar6;
  byte *pbVar7;
  uint uVar8;
  uint uVar9;
  char *pcVar10;
  
  iVar4 = param_1;
  if (param_1 != 0) {
    iVar4 = _Unwind_GetRegionStart();
  }
  *param_3 = iVar4;
  pcVar10 = param_2 + 1;
  cVar1 = *param_2;
  if (cVar1 == -1) {
    param_3[1] = iVar4;
  }
  else {
    uVar5 = FUN_00017d84(cVar1,param_1);
    pcVar10 = (char *)FUN_00017cd4(cVar1,uVar5,pcVar10,param_3 + 1,param_4);
  }
  cVar1 = *pcVar10;
  pbVar6 = (byte *)(pcVar10 + 1);
  *(char *)(param_3 + 5) = cVar1;
  if (cVar1 == -1) {
    param_3[3] = 0;
  }
  else {
    uVar8 = 0;
    uVar9 = 0;
    *(undefined1 *)(param_3 + 5) = 0x90;
    pbVar7 = pbVar6;
    do {
      pbVar6 = pbVar7 + 1;
      bVar2 = *pbVar7;
      uVar3 = uVar9 & 0xff;
      uVar9 = uVar9 + 7;
      uVar8 = uVar8 | (bVar2 & 0x7f) << uVar3;
      pbVar7 = pbVar6;
    } while ((int)((uint)bVar2 << 0x18) < 0);
    param_3[3] = (int)(pbVar6 + uVar8);
  }
  uVar9 = 0;
  uVar8 = 0;
  *(byte *)((int)param_3 + 0x15) = *pbVar6;
  pbVar6 = pbVar6 + 1;
  do {
    pbVar7 = pbVar6 + 1;
    bVar2 = *pbVar6;
    uVar3 = uVar8 & 0xff;
    uVar8 = uVar8 + 7;
    uVar9 = uVar9 | (bVar2 & 0x7f) << uVar3;
    pbVar6 = pbVar7;
  } while ((int)((uint)bVar2 << 0x18) < 0);
  param_3[4] = (int)(pbVar7 + uVar9);
  return;
}



undefined4 __cxa_get_exception_ptr(int param_1)

{
  return *(undefined4 *)(param_1 + 0x24);
}



undefined4 __cxa_begin_catch(char *param_1)

{
  undefined4 *puVar1;
  int iVar2;
  char *pcVar3;
  char *pcVar4;
  undefined4 uVar5;
  int iVar6;
  
  puVar1 = (undefined4 *)__cxa_get_globals();
  pcVar3 = param_1 + -0x20;
  pcVar4 = (char *)*puVar1;
  if (((((*param_1 == 'G') && (param_1[1] == 'N')) && (param_1[2] == 'U')) &&
      ((param_1[3] == 'C' && (param_1[4] == 'C')))) &&
     ((param_1[5] == '+' && ((param_1[6] == '+' && ((byte)param_1[7] < 2)))))) {
    iVar6 = *(int *)(param_1 + -0xc);
    if (iVar6 < 0) {
      iVar6 = -iVar6;
    }
    iVar2 = puVar1[1];
    *(int *)(param_1 + -0xc) = iVar6 + 1;
    puVar1[1] = iVar2 + -1;
    if (pcVar3 != pcVar4) {
      *(char **)(param_1 + -0x10) = pcVar4;
      *puVar1 = pcVar3;
    }
    uVar5 = *(undefined4 *)(param_1 + 0x24);
    _Unwind_Complete(param_1);
    return uVar5;
  }
  if (pcVar4 == (char *)0x0) {
    *puVar1 = pcVar3;
    return 0;
  }
                    // WARNING: Subroutine does not return
  std::terminate();
}



void __cxa_end_catch(void)

{
  int *piVar1;
  int iVar2;
  byte bVar3;
  int iVar4;
  undefined4 in_r3;
  
  piVar1 = (int *)__cxa_get_globals_fast();
  iVar2 = *piVar1;
  if (iVar2 == 0) {
    return;
  }
  bVar3 = *(byte *)(iVar2 + 0x20);
  if (((((bVar3 != 0x47) || (bVar3 = *(byte *)(iVar2 + 0x21), bVar3 != 0x4e)) ||
       (bVar3 = *(byte *)(iVar2 + 0x22), bVar3 != 0x55)) ||
      ((bVar3 = *(byte *)(iVar2 + 0x23), bVar3 != 0x43 ||
       (bVar3 = *(byte *)(iVar2 + 0x24), bVar3 != 0x43)))) ||
     ((bVar3 = *(byte *)(iVar2 + 0x25), bVar3 != 0x2b ||
      ((bVar3 = *(byte *)(iVar2 + 0x26), bVar3 != 0x2b ||
       (bVar3 = *(byte *)(iVar2 + 0x27), 1 < bVar3)))))) {
    *piVar1 = 0;
    _Unwind_DeleteException(iVar2 + 0x20,bVar3,piVar1,in_r3);
    return;
  }
  iVar4 = *(int *)(iVar2 + 0x14);
  if (iVar4 < 0) {
    iVar4 = iVar4 + 1;
    if (iVar4 == 0) {
      *piVar1 = *(int *)(iVar2 + 0x10);
    }
  }
  else {
    iVar4 = iVar4 + -1;
    if (iVar4 == 0) {
      iVar4 = *(int *)(iVar2 + 0x10);
      *piVar1 = iVar4;
      _Unwind_DeleteException(iVar2 + 0x20,iVar4,piVar1,in_r3);
      return;
    }
    if (iVar4 == -1) {
                    // WARNING: Subroutine does not return
      std::terminate();
    }
  }
  *(int *)(iVar2 + 0x14) = iVar4;
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::uncaught_exception()

int std::uncaught_exception(void)

{
  int iVar1;
  
  iVar1 = __cxa_get_globals();
  iVar1 = *(int *)(iVar1 + 4);
  if (iVar1 != 0) {
    iVar1 = 1;
  }
  return iVar1;
}



// operator new(unsigned int)

void * operator_new(uint param_1)

{
  void *pvVar1;
  undefined4 *puVar2;
  
  if (param_1 == 0) {
    param_1 = 1;
  }
  pvVar1 = malloc(param_1);
  if (pvVar1 == (void *)0x0) {
    do {
      if (DAT_0002ff38 == (code *)0x0) {
        puVar2 = (undefined4 *)__cxa_allocate_exception(4);
        *puVar2 = &PTR__bad_alloc_1_0002a7f8;
                    // WARNING: Subroutine does not return
        __cxa_throw(puVar2,&std::bad_alloc::typeinfo,0x18ddd);
      }
      (*DAT_0002ff38)();
      pvVar1 = malloc(param_1);
    } while (pvVar1 == (void *)0x0);
    return pvVar1;
  }
  return pvVar1;
}



bool FUN_0001840c(char *param_1)

{
  if ((((*param_1 == 'G') && (param_1[1] == 'N')) && (param_1[2] == 'U')) &&
     (((param_1[3] == 'C' && (param_1[4] == 'C')) && ((param_1[5] == '+' && (param_1[6] == '+'))))))
  {
    return (byte)param_1[7] < 2;
  }
  return false;
}



void FUN_00018448(int param_1)

{
  int iVar1;
  
  if (param_1 != 0) {
    __cxa_begin_catch();
    iVar1 = FUN_0001840c(param_1);
    if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
      __cxxabiv1::__terminate(*(_func_void **)(param_1 + -0x14));
    }
  }
                    // WARNING: Subroutine does not return
  std::terminate();
}



void __cxa_call_unexpected(int param_1)

{
  int iVar1;
  _func_void *p_Var2;
  
  iVar1 = FUN_0001840c();
  if (iVar1 != 0) {
    p_Var2 = *(_func_void **)(param_1 + -0x18);
    __cxa_begin_catch(param_1);
                    // WARNING: Subroutine does not return
    __cxxabiv1::__unexpected(p_Var2);
  }
  __cxa_begin_catch(param_1);
  std::unexpected();
  __cxa_begin_catch();
                    // WARNING: Subroutine does not return
  std::terminate();
}



pthread_key_t * FUN_00018574(pthread_key_t *param_1)

{
  if (param_1 != (pthread_key_t *)0x0) {
    if ((char)param_1[1] != '\0') {
      pthread_key_delete(*param_1);
    }
    *(undefined1 *)(param_1 + 1) = 0;
  }
  return param_1;
}



void FUN_00018590(int *param_1)

{
  int iVar1;
  int iVar2;
  
  if (param_1 != (int *)0x0) {
    iVar1 = *param_1;
    while (iVar1 != 0) {
      iVar2 = *(int *)(iVar1 + 0x10);
      _Unwind_DeleteException(iVar1 + 0x20);
      iVar1 = iVar2;
    }
    free(param_1);
    return;
  }
  return;
}



undefined * __cxa_get_globals_fast(void)

{
  undefined *puVar1;
  
  if (DAT_0002b01c == '\0') {
    return &DAT_0002b020;
  }
  puVar1 = (undefined *)pthread_getspecific(DAT_0002b018);
  return puVar1;
}



undefined4 * __cxa_get_globals(void)

{
  int iVar1;
  undefined4 *__pointer;
  
  __pointer = (undefined4 *)&DAT_0002b020;
  if ((DAT_0002b01c != '\0') &&
     (__pointer = (undefined4 *)pthread_getspecific(DAT_0002b018), __pointer == (undefined4 *)0x0))
  {
    __pointer = (undefined4 *)malloc(0xc);
    if ((__pointer == (undefined4 *)0x0) ||
       (iVar1 = pthread_setspecific(DAT_0002b018,__pointer), iVar1 != 0)) {
                    // WARNING: Subroutine does not return
      std::terminate();
    }
    *__pointer = 0;
    __pointer[1] = 0;
    __pointer[2] = 0;
  }
  return __pointer;
}



void __cxa_throw(int param_1,undefined4 param_2,undefined4 param_3)

{
  undefined4 uVar1;
  undefined4 uVar2;
  int iVar3;
  
  iVar3 = __cxa_get_globals();
  uVar2 = __cxxabiv1::__unexpected_handler;
  uVar1 = __cxxabiv1::__terminate_handler;
  *(int *)(iVar3 + 4) = *(int *)(iVar3 + 4) + 1;
  *(undefined4 *)(param_1 + -0x78) = param_2;
  *(undefined4 *)(param_1 + -0x80) = 1;
  *(undefined4 *)(param_1 + -0x70) = uVar2;
  *(undefined4 *)(param_1 + -0x6c) = uVar1;
  *(undefined1 *)(param_1 + -0x58) = 0x47;
  *(undefined1 **)(param_1 + -0x50) = &LAB_00018640_1;
  *(undefined1 *)(param_1 + -0x55) = 0x43;
  *(undefined1 *)(param_1 + -0x54) = 0x43;
  *(undefined1 *)(param_1 + -0x53) = 0x2b;
  *(undefined1 *)(param_1 + -0x52) = 0x2b;
  *(undefined4 *)(param_1 + -0x74) = param_3;
  *(undefined1 *)(param_1 + -0x57) = 0x4e;
  *(undefined1 *)(param_1 + -0x56) = 0x55;
  *(undefined1 *)(param_1 + -0x51) = 0;
  ___Unwind_RaiseException(param_1 + -0x58);
  __cxa_begin_catch(param_1 + -0x58);
                    // WARNING: Subroutine does not return
  std::terminate();
}



void __cxa_rethrow(void)

{
  int *piVar1;
  int iVar2;
  
  piVar1 = (int *)__cxa_get_globals();
  iVar2 = *piVar1;
  piVar1[1] = piVar1[1] + 1;
  if (iVar2 != 0) {
    if (((((*(char *)(iVar2 + 0x20) == 'G') && (*(char *)(iVar2 + 0x21) == 'N')) &&
         (*(char *)(iVar2 + 0x22) == 'U')) &&
        ((*(char *)(iVar2 + 0x23) == 'C' && (*(char *)(iVar2 + 0x24) == 'C')))) &&
       ((*(char *)(iVar2 + 0x25) == '+' &&
        ((*(char *)(iVar2 + 0x26) == '+' && (*(byte *)(iVar2 + 0x27) < 2)))))) {
      *(int *)(iVar2 + 0x14) = -*(int *)(iVar2 + 0x14);
    }
    else {
      *piVar1 = 0;
    }
    ___Unwind_Resume_or_Rethrow(iVar2 + 0x20);
    __cxa_begin_catch(iVar2 + 0x20);
  }
                    // WARNING: Subroutine does not return
  std::terminate();
}



// __cxxabiv1::__fundamental_type_info::~__fundamental_type_info()

__fundamental_type_info * __thiscall
__cxxabiv1::__fundamental_type_info::~__fundamental_type_info(__fundamental_type_info *this)

{
  *(undefined ***)this = &PTR____fundamental_type_info_1_0002a6e8;
  FUN_0001cea4();
  return this;
}



// __cxxabiv1::__fundamental_type_info::~__fundamental_type_info()

__fundamental_type_info * __thiscall
__cxxabiv1::__fundamental_type_info::~__fundamental_type_info(__fundamental_type_info *this)

{
  ~__fundamental_type_info(this);
  operator_delete(this);
  return this;
}



// std::exception::~exception()

void __thiscall std::exception::~exception(exception *this)

{
  *(undefined ***)this = &PTR__exception_1_0002a788;
  return;
}



// std::bad_exception::~bad_exception()

bad_exception * __thiscall std::bad_exception::~bad_exception(bad_exception *this)

{
  *(undefined ***)this = &PTR__bad_exception_1_0002a728;
  exception::~exception((exception *)this);
  return this;
}



// __cxxabiv1::__forced_unwind::~__forced_unwind()

void __thiscall __cxxabiv1::__forced_unwind::~__forced_unwind(__forced_unwind *this)

{
  *(undefined ***)this = &PTR____forced_unwind_1_0002a758;
  return;
}



// __cxxabiv1::__foreign_exception::~__foreign_exception()

void __thiscall __cxxabiv1::__foreign_exception::~__foreign_exception(__foreign_exception *this)

{
  *(undefined ***)this = &PTR____foreign_exception_1_0002a770;
  return;
}



// std::exception::what() const

char * std::exception::what(void)

{
  return "std::exception";
}



// std::bad_exception::what() const

char * std::bad_exception::what(void)

{
  return "std::bad_exception";
}



// std::exception::~exception()

exception * __thiscall std::exception::~exception(exception *this)

{
  ~exception(this);
  operator_delete(this);
  return this;
}



// std::bad_exception::~bad_exception()

bad_exception * __thiscall std::bad_exception::~bad_exception(bad_exception *this)

{
  ~bad_exception(this);
  operator_delete(this);
  return this;
}



// __cxxabiv1::__forced_unwind::~__forced_unwind()

__forced_unwind * __thiscall __cxxabiv1::__forced_unwind::~__forced_unwind(__forced_unwind *this)

{
  ~__forced_unwind(this);
  operator_delete(this);
  return this;
}



// __cxxabiv1::__foreign_exception::~__foreign_exception()

__foreign_exception * __thiscall
__cxxabiv1::__foreign_exception::~__foreign_exception(__foreign_exception *this)

{
  ~__foreign_exception(this);
  operator_delete(this);
  return this;
}



// operator delete(void*)

void operator_delete(void *param_1)

{
  if (param_1 == (void *)0x0) {
    return;
  }
  free(param_1);
  return;
}



void __cxa_end_cleanup(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = __gnu_end_cleanup();
                    // WARNING: Subroutine does not return
  ___Unwind_Resume(uVar1,param_2,param_3,param_4);
}



int __cxa_type_match(char *param_1,int *param_2,undefined4 param_3,undefined4 *param_4)

{
  int iVar1;
  undefined **ppuVar2;
  int iVar3;
  char *local_1c;
  
  if ((((*param_1 == 'G') && (param_1[1] == 'N')) && (param_1[2] == 'U')) && (param_1[3] == 'C')) {
    if (((param_1[4] == 'F') && (param_1[5] == 'O')) &&
       ((param_1[6] == 'R' && (param_1[7] == '\0')))) {
      ppuVar2 = &__cxxabiv1::__forced_unwind::typeinfo;
      local_1c = (char *)0x0;
      goto LAB_0001889a;
    }
    if (((param_1[4] == 'C') && (param_1[5] == '+')) &&
       ((param_1[6] == '+' && ((byte)param_1[7] < 2)))) {
      if (param_1[7] == 1) {
        local_1c = *(char **)(param_1 + -0x20);
        ppuVar2 = *(undefined ***)(local_1c + -0x78);
      }
      else {
        ppuVar2 = *(undefined ***)(param_1 + -0x20);
        local_1c = param_1 + 0x58;
      }
      goto LAB_0001889a;
    }
  }
  local_1c = (char *)0x0;
  ppuVar2 = &__cxxabiv1::__foreign_exception::typeinfo;
LAB_0001889a:
  iVar3 = 1;
  iVar1 = (**(code **)(*ppuVar2 + 8))(ppuVar2);
  if (iVar1 != 0) {
    iVar3 = 2;
    local_1c = *(char **)local_1c;
  }
  iVar1 = (**(code **)(*param_2 + 0x10))(param_2,ppuVar2,&local_1c,1);
  if (iVar1 != 0) {
    *param_4 = local_1c;
    iVar1 = iVar3;
  }
  return iVar1;
}



undefined4 __cxa_begin_cleanup(char *param_1)

{
  int iVar1;
  int iVar2;
  
  iVar1 = __cxa_get_globals();
  if (((((*param_1 == 'G') && (param_1[1] == 'N')) && (param_1[2] == 'U')) &&
      ((param_1[3] == 'C' && (param_1[4] == 'C')))) &&
     ((param_1[5] == '+' && ((param_1[6] == '+' && ((byte)param_1[7] < 2)))))) {
    iVar2 = *(int *)(param_1 + -4);
    *(int *)(param_1 + -4) = iVar2 + 1;
    if (iVar2 + 1 == 1) {
      *(undefined4 *)(param_1 + -8) = *(undefined4 *)(iVar1 + 8);
      *(char **)(iVar1 + 8) = param_1 + -0x20;
      return 1;
    }
  }
  else {
    if (*(int *)(iVar1 + 8) != 0) {
                    // WARNING: Subroutine does not return
      std::terminate();
    }
    *(char **)(iVar1 + 8) = param_1 + -0x20;
  }
  return 1;
}



int __gnu_end_cleanup(void)

{
  int iVar1;
  int iVar2;
  int iVar3;
  
  iVar1 = __cxa_get_globals();
  iVar3 = *(int *)(iVar1 + 8);
  if (iVar3 == 0) {
                    // WARNING: Subroutine does not return
    std::terminate();
  }
  if (((((*(char *)(iVar3 + 0x20) == 'G') && (*(char *)(iVar3 + 0x21) == 'N')) &&
       (*(char *)(iVar3 + 0x22) == 'U')) &&
      ((*(char *)(iVar3 + 0x23) == 'C' && (*(char *)(iVar3 + 0x24) == 'C')))) &&
     ((*(char *)(iVar3 + 0x25) == '+' &&
      ((*(char *)(iVar3 + 0x26) == '+' && (*(byte *)(iVar3 + 0x27) < 2)))))) {
    iVar2 = *(int *)(iVar3 + 0x1c) + -1;
    *(int *)(iVar3 + 0x1c) = iVar2;
    if (iVar2 == 0) {
      *(undefined4 *)(iVar1 + 8) = *(undefined4 *)(iVar3 + 0x18);
      *(undefined4 *)(iVar3 + 0x18) = 0;
      return iVar3 + 0x20;
    }
  }
  else {
    *(undefined4 *)(iVar1 + 8) = 0;
  }
  return iVar3 + 0x20;
}



// __cxxabiv1::__terminate(void (*)())

void __cxxabiv1::__terminate(_func_void *param_1)

{
  (*param_1)();
                    // WARNING: Subroutine does not return
  abort();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::terminate()

void std::terminate(void)

{
                    // WARNING: Subroutine does not return
  __cxxabiv1::__terminate(__cxxabiv1::__terminate_handler);
}



// __cxxabiv1::__unexpected(void (*)())

void __cxxabiv1::__unexpected(_func_void *param_1)

{
  (*param_1)();
                    // WARNING: Subroutine does not return
  std::terminate();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::unexpected()

void std::unexpected(void)

{
                    // WARNING: Subroutine does not return
  __cxxabiv1::__unexpected(__cxxabiv1::__unexpected_handler);
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::set_terminate(void (*)())

undefined4 std::set_terminate(_func_void *param_1)

{
  undefined4 uVar1;
  
  uVar1 = __cxxabiv1::__terminate_handler;
  __cxxabiv1::__terminate_handler = param_1;
  return uVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::set_unexpected(void (*)())

undefined4 std::set_unexpected(_func_void *param_1)

{
  undefined4 uVar1;
  
  uVar1 = __cxxabiv1::__unexpected_handler;
  __cxxabiv1::__unexpected_handler = param_1;
  return uVar1;
}



// operator new[](unsigned int)

void * operator_new__(uint param_1)

{
  void *pvVar1;
  
  pvVar1 = operator_new(param_1);
  return pvVar1;
}



void FUN_00018b28(void)

{
  undefined4 *puVar1;
  undefined4 in_r3;
  
  puVar1 = (undefined4 *)__cxa_allocate_exception(4);
  *puVar1 = &PTR_LAB_00018ad0_1_0002a7b8;
                    // WARNING: Subroutine does not return
  __cxa_throw(puVar1,&PTR_PTR____si_class_type_info_1_0002a798,&LAB_00018ad0_1,
              &PTR_LAB_00018ad0_1_0002a7b8,in_r3);
}



void FUN_00018b50(void)

{
  undefined4 *puVar1;
  undefined4 in_r3;
  
  puVar1 = (undefined4 *)__cxa_allocate_exception(4);
  *puVar1 = &PTR_LAB_00018ab8_1_0002a7d0;
                    // WARNING: Subroutine does not return
  __cxa_throw(puVar1,&PTR_PTR____si_class_type_info_1_0002a7a4,&LAB_00018ab8_1,
              &PTR_LAB_00018ab8_1_0002a7d0,in_r3);
}



int __cxa_allocate_exception(int param_1)

{
  void *__s;
  int iVar1;
  int extraout_r1;
  uint uVar2;
  uint uVar3;
  
  __s = malloc(param_1 + 0x80U);
  if (__s != (void *)0x0) {
LAB_00018b88:
    memset(__s,0,0x80);
    return (int)__s + 0x80;
  }
  iVar1 = pthread_mutex_lock((pthread_mutex_t *)&DAT_0002bf30);
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    FUN_00018b28();
  }
  if (param_1 + 0x80U < 0x201) {
    uVar3 = 0;
    uVar2 = DAT_0002bf34;
    do {
      if (-1 < (int)(uVar2 << 0x1f)) {
        DAT_0002bf34 = DAT_0002bf34 | 1 << (uVar3 & 0xff);
        __s = (void *)(uVar3 * 0x200 + 0x2bf38);
        iVar1 = pthread_mutex_unlock((pthread_mutex_t *)&DAT_0002bf30);
        if (iVar1 != 0) {
          FUN_00018b50();
          if (extraout_r1 == -1) {
                    // WARNING: Subroutine does not return
            __cxa_call_unexpected();
          }
                    // WARNING: Subroutine does not return
          __cxa_end_cleanup();
        }
        goto LAB_00018b88;
      }
      uVar3 = uVar3 + 1;
      uVar2 = uVar2 >> 1;
    } while (uVar3 != 0x20);
  }
                    // WARNING: Subroutine does not return
  std::terminate();
}



void __cxa_free_exception(uint param_1)

{
  int iVar1;
  int extraout_r1;
  
  if ((param_1 < 0x2bf38) || (0x2ff37 < param_1)) {
    free((void *)(param_1 - 0x80));
    return;
  }
  iVar1 = pthread_mutex_lock((pthread_mutex_t *)&DAT_0002bf30);
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    FUN_00018b28();
  }
  DAT_0002bf34 = DAT_0002bf34 & ~(1 << (param_1 - 0x2bf38 >> 9 & 0xff));
  iVar1 = pthread_mutex_unlock((pthread_mutex_t *)&DAT_0002bf30);
  if (iVar1 != 0) {
    FUN_00018b50();
    if (extraout_r1 == -1) {
                    // WARNING: Subroutine does not return
      __cxa_call_unexpected();
    }
                    // WARNING: Subroutine does not return
    __cxa_end_cleanup();
  }
  return;
}



void * __cxa_allocate_dependent_exception(void)

{
  void *__s;
  int iVar1;
  uint uVar2;
  uint uVar3;
  
  __s = malloc(0x78);
  if (__s != (void *)0x0) {
LAB_00018c8c:
    memset(__s,0,0x78);
    return __s;
  }
  iVar1 = pthread_mutex_lock((pthread_mutex_t *)&DAT_0002bf30);
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    FUN_00018b28();
  }
  uVar2 = 0;
  uVar3 = DAT_0002b02c;
  do {
    if (-1 < (int)(uVar3 << 0x1f)) {
      DAT_0002b02c = DAT_0002b02c | 1 << (uVar2 & 0xff);
      __s = (void *)(uVar2 * 0x78 + 0x2b030);
      iVar1 = pthread_mutex_unlock((pthread_mutex_t *)&DAT_0002bf30);
      if (iVar1 == 0) goto LAB_00018c8c;
      FUN_00018b50();
      break;
    }
    uVar2 = uVar2 + 1;
    uVar3 = uVar3 >> 1;
  } while (uVar2 != 0x20);
                    // WARNING: Subroutine does not return
  std::terminate();
}



void __cxa_free_dependent_exception(void *param_1)

{
  int iVar1;
  int extraout_r1;
  
  if ((param_1 < (void *)0x2b030) || ((void *)0x2bf2f < param_1)) {
    free(param_1);
    return;
  }
  iVar1 = pthread_mutex_lock((pthread_mutex_t *)&DAT_0002bf30);
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    FUN_00018b28();
  }
  DAT_0002b02c = DAT_0002b02c & ~(1 << (((int)param_1 - 0x2b030U) / 0x78 & 0xff));
  iVar1 = pthread_mutex_unlock((pthread_mutex_t *)&DAT_0002bf30);
  if (iVar1 != 0) {
    FUN_00018b50();
    if (extraout_r1 == -1) {
                    // WARNING: Subroutine does not return
      __cxa_call_unexpected();
    }
                    // WARNING: Subroutine does not return
    __cxa_end_cleanup();
  }
  return;
}



void FUN_00018d84(undefined4 param_1,undefined4 param_2)

{
  __cxa_atexit(param_2,param_1);
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::set_new_handler(void (*)())

undefined4 std::set_new_handler(_func_void *param_1)

{
  undefined4 uVar1;
  
  uVar1 = DAT_0002ff38;
  DAT_0002ff38 = param_1;
  return uVar1;
}



void __cxa_pure_virtual(void)

{
  write(2,"pure virtual method called\n",0x1b);
                    // WARNING: Subroutine does not return
  std::terminate();
}



void __cxa_deleted_virtual(void)

{
  write(2,"deleted virtual method called\n",0x1e);
                    // WARNING: Subroutine does not return
  std::terminate();
}



// std::bad_alloc::what() const

char * std::bad_alloc::what(void)

{
  return "std::bad_alloc";
}



// std::bad_alloc::~bad_alloc()

bad_alloc * __thiscall std::bad_alloc::~bad_alloc(bad_alloc *this)

{
  *(undefined ***)this = &PTR__bad_alloc_1_0002a7f8;
  exception::~exception((exception *)this);
  return this;
}



// std::bad_alloc::~bad_alloc()

bad_alloc * __thiscall std::bad_alloc::~bad_alloc(bad_alloc *this)

{
  ~bad_alloc(this);
  operator_delete(this);
  return this;
}



uint FUN_00018e3c(int *param_1,uint param_2,undefined4 param_3)

{
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    return param_2;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c(param_3);
}



size_t FUN_00019040(int *param_1,wchar_t *param_2,uint param_3,uint param_4)

{
  uint __n;
  int iVar1;
  
  iVar1 = *param_1;
  if (*(uint *)(iVar1 + -0xc) < param_4) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::copy");
  }
  __n = *(uint *)(iVar1 + -0xc) - param_4;
  if (param_3 <= __n) {
    __n = param_3;
  }
  if (__n != 0) {
    if (__n == 1) {
      *param_2 = *(wchar_t *)(iVar1 + param_4 * 4);
      return 1;
    }
    wmemcpy(param_2,(wchar_t *)(iVar1 + param_4 * 4),__n);
  }
  return __n;
}



void FUN_00019084(int *param_1,int *param_2)

{
  int iVar1;
  int iVar2;
  
  iVar1 = *param_1;
  if (*(int *)(iVar1 + -4) < 0) {
    *(undefined4 *)(iVar1 + -4) = 0;
  }
  iVar2 = *param_2;
  if (*(int *)(iVar2 + -4) < 0) {
    *(undefined4 *)(iVar2 + -4) = 0;
  }
  *param_1 = iVar2;
  *param_2 = iVar1;
  return;
}



undefined4 FUN_000190b0(undefined4 param_1)

{
  FUN_00019084();
  return param_1;
}



undefined4 FUN_000190bc(undefined4 param_1)

{
  FUN_00019084();
  return param_1;
}



uint FUN_000190d0(int *param_1,wchar_t *param_2,uint param_3,uint param_4)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  wchar_t *pwVar4;
  bool bVar5;
  
  uVar1 = *(uint *)(*param_1 + -0xc);
  if (param_4 == 0) {
    if (uVar1 < param_3) {
      param_3 = 0xffffffff;
    }
    return param_3;
  }
  if ((param_4 <= uVar1) && (param_3 <= uVar1 - param_4)) {
    uVar3 = param_3 + 1;
    pwVar4 = (wchar_t *)(*param_1 + param_3 * 4);
    do {
      if ((*pwVar4 == *param_2) && (iVar2 = wmemcmp(pwVar4 + 1,param_2 + 1,param_4 - 1), iVar2 == 0)
         ) {
        return uVar3 - 1;
      }
      bVar5 = uVar3 <= uVar1 - param_4;
      uVar3 = uVar3 + 1;
      pwVar4 = pwVar4 + 1;
    } while (bVar5);
  }
  return 0xffffffff;
}



void FUN_00019148(undefined4 param_1,wchar_t *param_2,undefined4 param_3)

{
  size_t sVar1;
  
  sVar1 = wcslen(param_2);
  FUN_000190d0(param_1,param_2,param_3,sVar1);
  return;
}



int FUN_00019168(int *param_1,wchar_t param_2,uint param_3)

{
  wchar_t *pwVar1;
  int iVar2;
  
  iVar2 = *param_1;
  if ((param_3 < *(uint *)(iVar2 + -0xc)) &&
     (pwVar1 = wmemchr((wchar_t *)(iVar2 + param_3 * 4),param_2,*(uint *)(iVar2 + -0xc) - param_3),
     pwVar1 != (wchar_t *)0x0)) {
    return (int)pwVar1 - iVar2 >> 2;
  }
  return -1;
}



uint FUN_000191e4(int *param_1,wchar_t *param_2,uint param_3)

{
  int iVar1;
  size_t __n;
  uint uVar2;
  wchar_t *__s1;
  bool bVar3;
  
  __n = wcslen(param_2);
  uVar2 = *(uint *)(*param_1 + -0xc);
  if (__n <= uVar2) {
    uVar2 = uVar2 - __n;
    if (param_3 <= uVar2) {
      uVar2 = param_3;
    }
    __s1 = (wchar_t *)(*param_1 + uVar2 * 4);
    do {
      iVar1 = wmemcmp(__s1,param_2,__n);
      if (iVar1 == 0) {
        return uVar2;
      }
      bVar3 = uVar2 != 0;
      uVar2 = uVar2 - 1;
      __s1 = __s1 + -1;
    } while (bVar3);
  }
  return 0xffffffff;
}



uint FUN_00019240(int *param_1,wchar_t *param_2,uint param_3,size_t param_4)

{
  wchar_t *pwVar1;
  int iVar2;
  int iVar3;
  
  if ((param_4 != 0) && (iVar2 = *param_1, param_3 < *(uint *)(iVar2 + -0xc))) {
    iVar3 = param_3 << 2;
    do {
      pwVar1 = (wchar_t *)(iVar2 + iVar3);
      iVar3 = iVar3 + 4;
      pwVar1 = wmemchr(param_2,*pwVar1,param_4);
      if (pwVar1 != (wchar_t *)0x0) {
        return param_3;
      }
      iVar2 = *param_1;
      param_3 = param_3 + 1;
    } while (param_3 < *(uint *)(iVar2 + -0xc));
  }
  return 0xffffffff;
}



void FUN_00019294(undefined4 param_1,wchar_t *param_2,undefined4 param_3)

{
  size_t sVar1;
  
  sVar1 = wcslen(param_2);
  FUN_00019240(param_1,param_2,param_3,sVar1);
  return;
}



uint FUN_00019310(int *param_1,wchar_t *param_2,uint param_3)

{
  wchar_t *pwVar1;
  size_t __n;
  int iVar2;
  uint uVar3;
  int iVar4;
  
  __n = wcslen(param_2);
  iVar4 = *param_1;
  if (__n != 0 && *(int *)(iVar4 + -0xc) != 0) {
    uVar3 = *(int *)(iVar4 + -0xc) - 1;
    if (param_3 < uVar3) {
      uVar3 = param_3;
    }
    iVar2 = uVar3 << 2;
    while( true ) {
      pwVar1 = (wchar_t *)(iVar4 + iVar2);
      iVar2 = iVar2 + -4;
      pwVar1 = wmemchr(param_2,*pwVar1,__n);
      if (pwVar1 != (wchar_t *)0x0) {
        return uVar3;
      }
      if (uVar3 == 0) break;
      iVar4 = *param_1;
      uVar3 = uVar3 - 1;
    }
  }
  return 0xffffffff;
}



uint FUN_00019388(int *param_1,wchar_t *param_2,uint param_3)

{
  wchar_t *pwVar1;
  size_t __n;
  int iVar2;
  int iVar3;
  
  __n = wcslen(param_2);
  iVar2 = *param_1;
  if (param_3 < *(uint *)(iVar2 + -0xc)) {
    iVar3 = param_3 << 2;
    do {
      pwVar1 = (wchar_t *)(iVar2 + iVar3);
      iVar3 = iVar3 + 4;
      pwVar1 = wmemchr(param_2,*pwVar1,__n);
      if (pwVar1 == (wchar_t *)0x0) {
        return param_3;
      }
      iVar2 = *param_1;
      param_3 = param_3 + 1;
    } while (param_3 < *(uint *)(iVar2 + -0xc));
  }
  return 0xffffffff;
}



uint FUN_000193e4(int *param_1,wchar_t *param_2,uint param_3,size_t param_4)

{
  wchar_t *pwVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  
  iVar4 = *param_1;
  if (*(int *)(iVar4 + -0xc) != 0) {
    uVar3 = *(int *)(iVar4 + -0xc) - 1;
    if (param_3 < uVar3) {
      uVar3 = param_3;
    }
    iVar2 = uVar3 << 2;
    while( true ) {
      pwVar1 = (wchar_t *)(iVar4 + iVar2);
      iVar2 = iVar2 + -4;
      pwVar1 = wmemchr(param_2,*pwVar1,param_4);
      if (pwVar1 == (wchar_t *)0x0) {
        return uVar3;
      }
      if (uVar3 == 0) break;
      iVar4 = *param_1;
      uVar3 = uVar3 - 1;
    }
  }
  return 0xffffffff;
}



void FUN_00019434(undefined4 param_1,wchar_t *param_2,undefined4 param_3)

{
  size_t sVar1;
  
  sVar1 = wcslen(param_2);
  FUN_000193e4(param_1,param_2,param_3,sVar1);
  return;
}



int FUN_0001956c(int *param_1,uint param_2,uint param_3,wchar_t *param_4)

{
  size_t sVar1;
  int iVar2;
  uint __n;
  uint uVar3;
  
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    uVar3 = *(uint *)(*param_1 + -0xc) - param_2;
    if (param_3 <= uVar3) {
      uVar3 = param_3;
    }
    sVar1 = wcslen(param_4);
    __n = sVar1;
    if (uVar3 <= sVar1) {
      __n = uVar3;
    }
    iVar2 = wmemcmp((wchar_t *)(*param_1 + param_2 * 4),param_4,__n);
    if (iVar2 == 0) {
      iVar2 = uVar3 - sVar1;
    }
    return iVar2;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::compare");
}



void FUN_00019644(uint param_1,uint param_2)

{
  uint uVar1;
  void *pvVar2;
  
  if (0xffffffe < param_1) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::_S_create");
  }
  if (param_2 < param_1) {
    if (param_1 < param_2 << 1) {
      param_1 = param_2 << 1;
    }
    uVar1 = (param_1 + 4) * 4;
    if (param_1 <= param_2 || uVar1 + 0x10 < 0x1001) goto LAB_00019690;
    param_1 = param_1 + (0x1000 - (uVar1 + 0x10 & 0xfff) >> 2);
    if (0xffffffd < param_1) {
      param_1 = 0xffffffe;
    }
  }
  uVar1 = (param_1 + 4) * 4;
LAB_00019690:
  pvVar2 = operator_new(uVar1);
  *(uint *)((int)pvVar2 + 4) = param_1;
  *(undefined4 *)((int)pvVar2 + 8) = 0;
  return;
}



int * FUN_00019738(int *param_1)

{
  undefined1 auStack_c [4];
  
  if ((undefined *)(*param_1 + -0xc) != &DAT_0002ff3c) {
    FUN_00016f10((undefined *)(*param_1 + -0xc),auStack_c);
  }
  return param_1;
}



void FUN_0001975c(int *param_1,size_t param_2,int param_3,int param_4)

{
  int iVar1;
  wchar_t *__s2;
  wchar_t *__s1;
  wchar_t wVar2;
  size_t __n;
  undefined1 auStack_2c [8];
  
  __s1 = (wchar_t *)*param_1;
  wVar2 = (param_4 - param_3) + __s1[-3];
  __n = (__s1[-3] - param_2) - param_3;
  if (((uint)__s1[-2] < (uint)wVar2) || (L'\0' < __s1[-1])) {
    iVar1 = FUN_00019644(wVar2,__s1[-2],auStack_2c);
    __s2 = (wchar_t *)*param_1;
    __s1 = (wchar_t *)(iVar1 + 0xc);
    if (param_2 != 0) {
      if (param_2 == 1) {
        *(wchar_t *)(iVar1 + 0xc) = *__s2;
      }
      else {
        wmemcpy(__s1,__s2,param_2);
        __s2 = (wchar_t *)*param_1;
      }
    }
    if (__n != 0) {
      if (__n == 1) {
        __s1[param_4 + param_2] = __s2[param_2 + param_3];
      }
      else {
        wmemcpy(__s1 + param_4 + param_2,__s2 + param_2 + param_3,__n);
        __s2 = (wchar_t *)*param_1;
      }
    }
    if (__s2 + -3 != (wchar_t *)&DAT_0002ff3c) {
      FUN_00016f10(__s2 + -3,auStack_2c);
    }
    *param_1 = (int)__s1;
  }
  else if (param_3 != param_4 && __n != 0) {
    if (__n == 1) {
      __s1[param_4 + param_2] = __s1[param_2 + param_3];
    }
    else {
      wmemmove(__s1 + param_4 + param_2,__s1 + param_2 + param_3,__n);
      __s1 = (wchar_t *)*param_1;
    }
  }
  if (__s1 + -3 != (wchar_t *)&DAT_0002ff3c) {
    FUN_00016f00(__s1 + -3,wVar2);
  }
  return;
}



void FUN_00019854(undefined4 *param_1)

{
  undefined *puVar1;
  
  puVar1 = (undefined *)*param_1;
  if (puVar1 != &DAT_0002ff48) {
    if (0 < *(int *)(puVar1 + -4)) {
      FUN_0001975c(param_1,0,0,0);
      puVar1 = (undefined *)*param_1;
    }
    *(undefined4 *)(puVar1 + -4) = 0xffffffff;
  }
  return;
}



void FUN_00019888(int *param_1)

{
  if (-1 < *(int *)(*param_1 + -4)) {
    FUN_00019854();
    return;
  }
  return;
}



int FUN_00019898(int *param_1)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_00019854();
    iVar1 = *param_1;
  }
  return iVar1;
}



int * FUN_000198b0(int *param_1,int *param_2)

{
  int iVar1;
  
  iVar1 = *param_2;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_00019854(param_2);
    iVar1 = *param_2;
  }
  *param_1 = iVar1;
  return param_1;
}



int FUN_000198d0(int *param_1)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_00019854();
    iVar1 = *param_1;
  }
  return iVar1 + *(int *)(iVar1 + -0xc) * 4;
}



int FUN_000198f0(int *param_1,int param_2)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_00019854();
    iVar1 = *param_1;
  }
  return iVar1 + param_2 * 4;
}



int FUN_0001990c(int *param_1)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_00019854();
    iVar1 = *param_1;
  }
  return iVar1;
}



int FUN_00019924(int *param_1)

{
  int iVar1;
  int iVar2;
  
  iVar2 = *param_1;
  iVar1 = *(int *)(iVar2 + -0xc);
  if (-1 < *(int *)(iVar2 + -4)) {
    FUN_00019854();
    iVar2 = *param_1;
  }
  return iVar2 + (iVar1 + -1) * 4;
}



int FUN_00019948(int *param_1,uint param_2)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (param_2 < *(uint *)(iVar1 + -0xc)) {
    if (-1 < *(int *)(iVar1 + -4)) {
      FUN_00019854();
      iVar1 = *param_1;
    }
    return iVar1 + param_2 * 4;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::at");
}



int * FUN_000199b0(int *param_1,uint param_2,uint param_3,undefined4 param_4)

{
  uint uVar1;
  
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    uVar1 = *(uint *)(*param_1 + -0xc) - param_2;
    if (uVar1 < param_3) {
      param_3 = uVar1;
    }
    FUN_0001975c(param_1,param_2,param_3,0,param_4);
    return param_1;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::erase");
}



int * FUN_00019a2c(int *param_1,int param_2,int param_3,size_t param_4,wchar_t param_5)

{
  if ((uint)((0xffffffe - *(int *)(*param_1 + -0xc)) + param_3) < param_4) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::_M_replace_aux");
  }
  FUN_0001975c();
  if (param_4 != 0) {
    if (param_4 == 1) {
      *(wchar_t *)(*param_1 + param_2 * 4) = param_5;
      return param_1;
    }
    wmemset((wchar_t *)(*param_1 + param_2 * 4),param_5,param_4);
  }
  return param_1;
}



void FUN_00019a84(int *param_1,undefined4 param_2,undefined4 param_3)

{
  FUN_00019a2c(param_1,0,*(undefined4 *)(*param_1 + -0xc),param_2,param_3);
  return;
}



void FUN_00019abc(int *param_1,uint param_2,undefined4 param_3,undefined4 param_4)

{
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    FUN_00019a2c(param_1,param_2,0,param_3,param_4);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::insert");
}



int FUN_00019ae4(int *param_1,int param_2,undefined4 param_3)

{
  int iVar1;
  int iVar2;
  
  iVar2 = param_2 - *param_1 >> 2;
  FUN_00019a2c(param_1,iVar2,0,1,param_3);
  iVar1 = *param_1;
  *(undefined4 *)(iVar1 + -4) = 0xffffffff;
  return iVar1 + iVar2 * 4;
}



void FUN_00019b10(int *param_1,uint param_2,uint param_3)

{
  uint uVar1;
  
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    uVar1 = *(uint *)(*param_1 + -0xc) - param_2;
    if (uVar1 < param_3) {
      param_3 = uVar1;
    }
    FUN_00019a2c(param_1,param_2,param_3);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::replace");
}



int * FUN_00019b6c(int *param_1,int param_2,undefined4 param_3,wchar_t *param_4,size_t param_5)

{
  FUN_0001975c();
  if (param_5 != 0) {
    if (param_5 == 1) {
      *(wchar_t *)(*param_1 + param_2 * 4) = *param_4;
      return param_1;
    }
    wmemcpy((wchar_t *)(*param_1 + param_2 * 4),param_4,param_5);
  }
  return param_1;
}



undefined4 * FUN_00019ba0(undefined4 *param_1,wchar_t *param_2,size_t param_3)

{
  undefined4 *puVar1;
  uint uVar2;
  wchar_t *__s1;
  
  __s1 = (wchar_t *)*param_1;
  if (0xffffffe < param_3) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::assign");
  }
  if (((param_2 < __s1) || (__s1 + __s1[-3] < param_2)) || (L'\0' < __s1[-1])) {
    puVar1 = (undefined4 *)FUN_00019b6c(param_1,0,__s1[-3],param_2,param_3);
    return puVar1;
  }
  uVar2 = (int)param_2 - (int)__s1 >> 2;
  if (uVar2 < param_3) {
    if (uVar2 == 0) goto LAB_00019bf4;
    if (param_3 != 1) {
      wmemmove(__s1,param_2,param_3);
      __s1 = (wchar_t *)*param_1;
      goto LAB_00019bf4;
    }
  }
  else if (param_3 != 1) {
    wmemcpy(__s1,param_2,param_3);
    __s1 = (wchar_t *)*param_1;
    goto LAB_00019bf4;
  }
  *__s1 = *param_2;
LAB_00019bf4:
  if (__s1 + -3 != (wchar_t *)&DAT_0002ff3c) {
    FUN_00016f00(__s1 + -3,param_3);
  }
  return param_1;
}



undefined4 FUN_00019c38(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  FUN_00019ba0(param_1,param_2,param_3);
  return param_1;
}



void FUN_00019c54(undefined4 param_1,int *param_2,uint param_3,uint param_4)

{
  uint uVar1;
  
  uVar1 = *(uint *)(*param_2 + -0xc);
  if (param_3 <= uVar1) {
    uVar1 = uVar1 - param_3;
    if (param_4 <= uVar1) {
      uVar1 = param_4;
    }
    FUN_00019ba0(param_1,*param_2 + param_3 * 4,uVar1);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::assign");
}



void FUN_00019cb4(undefined4 param_1,wchar_t *param_2,undefined4 param_3,undefined4 param_4)

{
  size_t sVar1;
  
  sVar1 = wcslen(param_2);
  FUN_00019ba0(param_1,param_2,sVar1,param_4);
  return;
}



uint * FUN_00019cd0(uint *param_1,uint param_2,uint param_3,uint param_4)

{
  size_t __n;
  wchar_t *__s2;
  uint uVar1;
  wchar_t *__s1;
  uint uVar2;
  int iVar3;
  
  uVar2 = *param_1;
  uVar1 = *(uint *)(uVar2 - 0xc);
  if (uVar1 < param_2) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::insert");
  }
  if (param_4 <= 0xffffffe - uVar1) {
    if (((param_3 < uVar2) || (uVar2 + uVar1 * 4 < param_3)) || (0 < *(int *)(uVar2 - 4))) {
      param_1 = (uint *)FUN_00019b6c(param_1,param_2,0,param_3,param_4);
    }
    else {
      FUN_0001975c(param_1,param_2,0);
      iVar3 = (int)(param_3 - uVar2) >> 2;
      uVar1 = *param_1;
      __s2 = (wchar_t *)(uVar1 + iVar3 * 4);
      __s1 = (wchar_t *)(uVar1 + param_2 * 4);
      if (__s2 + param_4 <= __s1) {
        if (param_4 == 1) {
          *(undefined4 *)(uVar1 + param_2 * 4) = *(undefined4 *)(uVar1 + iVar3 * 4);
          return param_1;
        }
        wmemcpy(__s1,__s2,param_4);
        return param_1;
      }
      if (__s2 < __s1) {
        __n = (int)__s1 - (int)__s2 >> 2;
        if (__n == 1) {
          *(undefined4 *)(uVar1 + param_2 * 4) = *(undefined4 *)(uVar1 + iVar3 * 4);
        }
        else {
          wmemcpy(__s1,__s2,__n);
        }
        if (param_4 - __n == 1) {
          __s1[__n] = __s1[param_4];
        }
        else {
          wmemcpy(__s1 + __n,__s1 + param_4,param_4 - __n);
        }
      }
      else if (param_4 == 1) {
        *(wchar_t *)(uVar1 + param_2 * 4) = __s2[1];
      }
      else {
        wmemcpy(__s1,__s2 + param_4,param_4);
      }
    }
    return param_1;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac00("basic_string::insert");
}



void FUN_00019e58(int *param_1)

{
  uint uVar1;
  
  uVar1 = *(uint *)(*param_1 + -0xc) - 1;
  if (uVar1 <= *(uint *)(*param_1 + -0xc)) {
    FUN_0001975c(param_1,uVar1,1,0);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::erase");
}



undefined * FUN_00019eac(size_t *param_1,undefined4 param_2,int param_3)

{
  undefined *puVar1;
  size_t __n;
  
  puVar1 = (undefined *)FUN_00019644(*param_1 + param_3,param_1[1],param_2);
  __n = *param_1;
  if (__n != 0) {
    if (__n == 1) {
      *(size_t *)(puVar1 + 0xc) = param_1[3];
      __n = *param_1;
    }
    else {
      wmemcpy((wchar_t *)(puVar1 + 0xc),(wchar_t *)(param_1 + 3),__n);
      __n = *param_1;
    }
  }
  if (puVar1 != &DAT_0002ff3c) {
    FUN_00016f00(puVar1,__n);
  }
  return puVar1 + 0xc;
}



void FUN_00019efc(int *param_1,uint param_2)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  undefined1 auStack_14 [4];
  
  iVar3 = *param_1;
  if ((param_2 != *(uint *)(iVar3 + -8)) || (0 < *(int *)(iVar3 + -4))) {
    uVar1 = *(uint *)(iVar3 + -0xc);
    if (param_2 < uVar1) {
      iVar2 = 0;
    }
    else {
      iVar2 = param_2 - uVar1;
    }
    iVar3 = FUN_00019eac((uint *)(iVar3 + -0xc),auStack_14,iVar2);
    if ((undefined *)(*param_1 + -0xc) != &DAT_0002ff3c) {
      FUN_00016f10((undefined *)(*param_1 + -0xc),auStack_14);
    }
    *param_1 = iVar3;
  }
  return;
}



int * FUN_00019f7c(int *param_1,int *param_2)

{
  wchar_t *__s2;
  int iVar1;
  wchar_t __n;
  int iVar2;
  uint uVar3;
  
  __s2 = (wchar_t *)*param_2;
  __n = __s2[-3];
  if (__n != L'\0') {
    iVar1 = *param_1;
    iVar2 = *(int *)(iVar1 + -0xc);
    uVar3 = iVar2 + __n;
    if ((*(uint *)(iVar1 + -8) < uVar3) || (0 < *(int *)(iVar1 + -4))) {
      FUN_00019efc(param_1,uVar3);
      iVar1 = *param_1;
      __s2 = (wchar_t *)*param_2;
      iVar2 = *(int *)(iVar1 + -0xc);
    }
    if (__n == L'\x01') {
      *(wchar_t *)(iVar1 + iVar2 * 4) = *__s2;
    }
    else {
      wmemcpy((wchar_t *)(iVar1 + iVar2 * 4),__s2,__n);
      iVar1 = *param_1;
    }
    if ((undefined *)(iVar1 + -0xc) != &DAT_0002ff3c) {
      FUN_00016f00((undefined *)(iVar1 + -0xc),uVar3);
    }
  }
  return param_1;
}



undefined4 *
FUN_0001a14c(undefined4 *param_1,wchar_t *param_2,undefined4 param_3,undefined4 param_4)

{
  size_t __n;
  wchar_t *pwVar1;
  wchar_t *pwVar2;
  undefined4 unaff_r4;
  undefined4 unaff_r5;
  int iVar3;
  wchar_t wVar4;
  
  __n = wcslen(param_2);
  if (__n != 0) {
    pwVar2 = (wchar_t *)*param_1;
    pwVar1 = (wchar_t *)pwVar2[-3];
    if (0xffffffeU - (int)pwVar1 < __n) {
                    // WARNING: Subroutine does not return
      FUN_0001ac00("basic_string::append");
    }
    wVar4 = __n + (int)pwVar1;
    if (((uint)pwVar2[-2] < (uint)wVar4) || (L'\0' < pwVar2[-1])) {
      if ((param_2 < pwVar2) || (pwVar1 = pwVar2 + (int)pwVar1, pwVar1 < param_2)) {
        FUN_00019efc(param_1,wVar4,pwVar1,pwVar2,param_4,unaff_r4,unaff_r5);
        pwVar2 = (wchar_t *)*param_1;
        pwVar1 = (wchar_t *)pwVar2[-3];
      }
      else {
        iVar3 = (int)param_2 - (int)pwVar2;
        FUN_00019efc(param_1,wVar4,pwVar1,pwVar2,param_4,unaff_r4,unaff_r5);
        pwVar2 = (wchar_t *)*param_1;
        pwVar1 = (wchar_t *)pwVar2[-3];
        param_2 = pwVar2 + (iVar3 >> 2);
      }
    }
    if (__n == 1) {
      pwVar2[(int)pwVar1] = *param_2;
    }
    else {
      wmemcpy(pwVar2 + (int)pwVar1,param_2,__n);
      pwVar2 = (wchar_t *)*param_1;
    }
    if (pwVar2 + -3 != (wchar_t *)&DAT_0002ff3c) {
      FUN_00016f00(pwVar2 + -3,wVar4);
    }
  }
  return param_1;
}



undefined4 *
FUN_0001a17c(undefined4 *param_1,wchar_t *param_2,undefined4 param_3,undefined4 param_4)

{
  size_t __n;
  wchar_t *pwVar1;
  wchar_t *pwVar2;
  undefined4 unaff_r4;
  undefined4 unaff_r5;
  int iVar3;
  wchar_t wVar4;
  
  __n = wcslen(param_2);
  if (__n != 0) {
    pwVar2 = (wchar_t *)*param_1;
    pwVar1 = (wchar_t *)pwVar2[-3];
    if (0xffffffeU - (int)pwVar1 < __n) {
                    // WARNING: Subroutine does not return
      FUN_0001ac00("basic_string::append");
    }
    wVar4 = __n + (int)pwVar1;
    if (((uint)pwVar2[-2] < (uint)wVar4) || (L'\0' < pwVar2[-1])) {
      if ((param_2 < pwVar2) || (pwVar1 = pwVar2 + (int)pwVar1, pwVar1 < param_2)) {
        FUN_00019efc(param_1,wVar4,pwVar1,pwVar2,param_4,unaff_r4,unaff_r5);
        pwVar2 = (wchar_t *)*param_1;
        pwVar1 = (wchar_t *)pwVar2[-3];
      }
      else {
        iVar3 = (int)param_2 - (int)pwVar2;
        FUN_00019efc(param_1,wVar4,pwVar1,pwVar2,param_4,unaff_r4,unaff_r5);
        pwVar2 = (wchar_t *)*param_1;
        pwVar1 = (wchar_t *)pwVar2[-3];
        param_2 = pwVar2 + (iVar3 >> 2);
      }
    }
    if (__n == 1) {
      pwVar2[(int)pwVar1] = *param_2;
    }
    else {
      wmemcpy(pwVar2 + (int)pwVar1,param_2,__n);
      pwVar2 = (wchar_t *)*param_1;
    }
    if (pwVar2 + -3 != (wchar_t *)&DAT_0002ff3c) {
      FUN_00016f00(pwVar2 + -3,wVar4);
    }
  }
  return param_1;
}



int * FUN_0001a25c(int *param_1,uint param_2)

{
  int *piVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  
  uVar3 = *(uint *)(*param_1 + -0xc);
  if (0xffffffe < param_2) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::resize");
  }
  if (param_2 <= uVar3) {
    if (uVar3 <= param_2) {
      return param_1;
    }
    piVar1 = (int *)FUN_0001975c(param_1,param_2,uVar3 - param_2,0);
    return piVar1;
  }
  param_2 = param_2 - uVar3;
  if (param_2 != 0) {
    iVar2 = *param_1;
    iVar4 = *(int *)(iVar2 + -0xc);
    if (0xffffffeU - iVar4 < param_2) {
                    // WARNING: Subroutine does not return
      FUN_0001ac00("basic_string::append");
    }
    uVar3 = param_2 + iVar4;
    if ((*(uint *)(iVar2 + -8) < uVar3) || (0 < *(int *)(iVar2 + -4))) {
      FUN_00019efc(param_1,uVar3);
      iVar2 = *param_1;
      iVar4 = *(int *)(iVar2 + -0xc);
    }
    if (param_2 == 1) {
      *(undefined4 *)(iVar2 + iVar4 * 4) = 0;
    }
    else {
      wmemset((wchar_t *)(iVar2 + iVar4 * 4),L'\0',param_2);
      iVar2 = *param_1;
    }
    if ((undefined *)(iVar2 + -0xc) != &DAT_0002ff3c) {
      FUN_00016f00((undefined *)(iVar2 + -0xc),uVar3);
    }
  }
  return param_1;
}



void FUN_0001a264(int *param_1,undefined4 param_2)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  
  iVar2 = *param_1;
  iVar1 = *(int *)(iVar2 + -0xc);
  uVar3 = iVar1 + 1;
  if ((*(uint *)(iVar2 + -8) < uVar3) || (0 < *(int *)(iVar2 + -4))) {
    FUN_00019efc(param_1,uVar3);
    iVar2 = *param_1;
    iVar1 = *(int *)(iVar2 + -0xc);
  }
  *(undefined4 *)(iVar2 + iVar1 * 4) = param_2;
  if ((undefined *)(iVar2 + -0xc) == &DAT_0002ff3c) {
    return;
  }
  FUN_00016f00((undefined *)(iVar2 + -0xc),uVar3);
  return;
}



wchar_t * FUN_0001a690(wchar_t *param_1,wchar_t *param_2,undefined4 param_3,undefined4 param_4)

{
  undefined *puVar1;
  wchar_t *__s1;
  size_t __n;
  
  if (param_1 == param_2) {
    return (wchar_t *)&DAT_0002ff48;
  }
  if (param_1 == (wchar_t *)0x0) {
    if (param_2 != (wchar_t *)0x0) {
                    // WARNING: Subroutine does not return
      FUN_0001aaec("basic_string::_S_construct null not valid");
    }
    puVar1 = (undefined *)FUN_00019644();
    __s1 = (wchar_t *)(puVar1 + 0xc);
    __n = 0;
  }
  else {
    __n = (int)param_2 - (int)param_1 >> 2;
    puVar1 = (undefined *)FUN_00019644(__n,0,param_3,(int)param_2 - (int)param_1,param_4);
    __s1 = (wchar_t *)(puVar1 + 0xc);
    if (__n == 1) {
      *(wchar_t *)(puVar1 + 0xc) = *param_1;
      goto LAB_0001a6b6;
    }
  }
  wmemcpy(__s1,param_1,__n);
LAB_0001a6b6:
  if (puVar1 != &DAT_0002ff3c) {
    FUN_00016f00(puVar1,__n);
  }
  return __s1;
}



undefined4 * FUN_0001a708(undefined4 *param_1,int param_2,int param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001a690(param_2,param_2 + param_3 * 4,param_4,0);
  *param_1 = uVar1;
  return param_1;
}



uint * FUN_0001a724(uint *param_1,uint param_2,uint param_3,uint param_4,uint param_5)

{
  uint *puVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  int iVar5;
  undefined1 auStack_28 [4];
  int local_24 [2];
  
  uVar2 = *param_1;
  uVar3 = *(uint *)(uVar2 - 0xc);
  if (uVar3 < param_2) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::replace");
  }
  uVar4 = uVar3 - param_2;
  if (param_3 <= uVar3 - param_2) {
    uVar4 = param_3;
  }
  if ((0xffffffe - uVar3) + uVar4 < param_5) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::replace");
  }
  if (((param_4 < uVar2) || (uVar2 + uVar3 * 4 < param_4)) || (0 < *(int *)(uVar2 - 4))) {
    puVar1 = (uint *)FUN_00019b6c(param_1,param_2,uVar4,param_4,param_5);
    return puVar1;
  }
  if (uVar2 + param_2 * 4 < param_4 + param_5 * 4) {
    if (param_4 < uVar2 + (uVar4 + param_2) * 4) {
      FUN_0001a708(local_24,param_4,param_5,auStack_28);
      puVar1 = (uint *)FUN_00019b6c(param_1,param_2,uVar4,local_24[0],param_5);
      if ((undefined *)(local_24[0] + -0xc) == &DAT_0002ff3c) {
        return puVar1;
      }
      FUN_00016f10((undefined *)(local_24[0] + -0xc),auStack_28);
      return puVar1;
    }
    iVar5 = (param_5 + ((int)(param_4 - uVar2) >> 2)) - uVar4;
  }
  else {
    iVar5 = (int)(param_4 - uVar2) >> 2;
  }
  FUN_0001975c(param_1,param_2,uVar4,param_5);
  uVar2 = *param_1;
  if (param_5 != 1) {
    wmemcpy((wchar_t *)(uVar2 + param_2 * 4),(wchar_t *)(uVar2 + iVar5 * 4),param_5);
    return param_1;
  }
  *(undefined4 *)(uVar2 + param_2 * 4) = *(undefined4 *)(uVar2 + iVar5 * 4);
  return param_1;
}



void FUN_0001a860(void)

{
  int *in_r3;
  uint in_stack_00000000;
  
  if (*(uint *)(*in_r3 + -0xc) < in_stack_00000000) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::replace");
  }
  FUN_0001a724();
  return;
}



void FUN_0001a894(undefined4 param_1,undefined4 param_2,undefined4 param_3,wchar_t *param_4)

{
  size_t sVar1;
  
  sVar1 = wcslen(param_4);
  FUN_0001a724(param_1,param_2,param_3,param_4,sVar1);
  return;
}



void FUN_0001a8b8(int *param_1,int param_2,int param_3)

{
  FUN_0001a724(param_1,param_2 - *param_1 >> 2,param_3 - param_2 >> 2);
  return;
}



void FUN_0001a8ec(int *param_1,int param_2,int param_3,wchar_t *param_4)

{
  size_t sVar1;
  
  sVar1 = wcslen(param_4);
  FUN_0001a724(param_1,param_2 - *param_1 >> 2,param_3 - param_2 >> 2,param_4,sVar1);
  return;
}



undefined4 * FUN_0001a9d4(undefined4 *param_1,int param_2,int param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001a690(param_2,param_2 + param_3 * 4,param_4,0);
  *param_1 = uVar1;
  return param_1;
}



undefined4 *
FUN_0001a9fc(undefined4 *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001a690(param_2,param_3,param_4,0);
  *param_1 = uVar1;
  return param_1;
}



void FUN_0001aaec(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d6e0(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002aa6c,0x1d481);
}



void FUN_0001ab48(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d704(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002aa90,0x1d4ed);
}



void FUN_0001aba4(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d71c(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002a9f0,&LAB_0001d524_1);
}



void FUN_0001ac00(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d734(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002aac0,&LAB_0001d55c_1);
}



void FUN_0001ac5c(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d74c(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002aa9c,&LAB_0001d594_1);
}



void FUN_0001acb8(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d764(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002ab30,0x1d5cd);
}



void FUN_0001ad14(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d788(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002aaa8,0x1d639);
}



void FUN_0001ad70(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d7a0(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002aa60,&LAB_0001d670_1);
}



void FUN_0001adcc(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d7b8(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002aab4,&LAB_0001d6a8_1);
}



void FUN_0001ae28(undefined4 param_1)

{
  undefined4 uVar1;
  undefined1 auStack_1c [4];
  undefined1 auStack_18 [4];
  int local_14;
  
  uVar1 = __cxa_allocate_exception(8);
  FUN_0001cd0c(&local_14,param_1,auStack_1c);
  FUN_0001d840(uVar1,&local_14);
  FUN_0001bb18(local_14 + -0xc,auStack_18);
                    // WARNING: Subroutine does not return
  __cxa_throw(uVar1,&PTR_PTR____si_class_type_info_1_0002ab58,0x1d7d5);
}



void FUN_0001ae78(undefined4 param_1)

{
  undefined4 *puVar1;
  int *piVar2;
  undefined1 auStack_20 [4];
  int local_1c [2];
  
  puVar1 = (undefined4 *)__cxa_allocate_exception(0x10);
  piVar2 = (int *)FUN_0001daec();
  (**(code **)(*piVar2 + 0xc))(local_1c,piVar2,param_1);
  FUN_0001d764(puVar1,local_1c);
  FUN_0001bb18(local_1c[0] + -0xc,auStack_20);
  puVar1[2] = param_1;
  puVar1[3] = piVar2;
  *puVar1 = &PTR_LAB_0001da60_1_0002aba0;
                    // WARNING: Subroutine does not return
  __cxa_throw(puVar1,&PTR_PTR____si_class_type_info_1_0002abd8,&LAB_0001da60_1);
}



void FUN_0001aef0(undefined4 param_1)

{
  undefined4 *puVar1;
  undefined4 uVar2;
  undefined1 auStack_24 [4];
  undefined1 auStack_20 [4];
  int local_1c [2];
  
  puVar1 = (undefined4 *)__cxa_allocate_exception(0x10);
  uVar2 = FUN_0001b1f4();
  FUN_0001cd0c(local_1c,"std::future_error",auStack_20);
  FUN_0001d6e0(puVar1,local_1c);
  FUN_0001bb18(local_1c[0] + -0xc,auStack_24);
  puVar1[2] = param_1;
  puVar1[3] = uVar2;
  *puVar1 = &PTR_LAB_0001b060_1_0002a840;
                    // WARNING: Subroutine does not return
  __cxa_throw(puVar1,&PTR_PTR____si_class_type_info_1_0002a8bc,&LAB_0001b060_1);
}



undefined4 * FUN_0001b0d4(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001b0d4_1_0002a878;
  FUN_0001d87c(param_1 + 3);
  if ((undefined4 *)param_1[1] != (undefined4 *)0x0) {
    (*(code *)**(undefined4 **)param_1[1])();
  }
  param_1[1] = 0;
  return param_1;
}



void * FUN_0001b0fc(void *param_1)

{
  FUN_0001b0d4();
  operator_delete(param_1);
  return param_1;
}



undefined4 * FUN_0001b1f4(void)

{
  int iVar1;
  uint uVar2;
  
  uVar2 = DAT_0002ff50 & 1;
  if ((uVar2 == 0) && (iVar1 = __cxa_guard_acquire(&DAT_0002ff50), iVar1 != 0)) {
    DAT_0002ff4c = (undefined **)uVar2;
    FUN_0001dad0(&DAT_0002ff4c);
    DAT_0002ff4c = &PTR_LAB_0001b028_1_0002a890;
    __cxa_guard_release(&DAT_0002ff50);
    FUN_00018d84(&DAT_0002ff4c,&LAB_0001b028_1,&DAT_0002b000);
  }
  return &DAT_0002ff4c;
}



uint FUN_0001b2a0(int *param_1,uint param_2,undefined4 param_3)

{
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    return param_2;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c(param_3);
}



size_t FUN_0001b494(int *param_1,undefined1 *param_2,uint param_3,uint param_4)

{
  uint __n;
  int iVar1;
  
  iVar1 = *param_1;
  if (*(uint *)(iVar1 + -0xc) < param_4) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::copy");
  }
  __n = *(uint *)(iVar1 + -0xc) - param_4;
  if (param_3 <= __n) {
    __n = param_3;
  }
  if (__n != 0) {
    if (__n == 1) {
      *param_2 = *(undefined1 *)(iVar1 + param_4);
      return 1;
    }
    memcpy(param_2,(void *)(iVar1 + param_4),__n);
  }
  return __n;
}



void FUN_0001b4d4(int *param_1,int *param_2)

{
  int iVar1;
  int iVar2;
  
  iVar1 = *param_1;
  if (*(int *)(iVar1 + -4) < 0) {
    *(undefined4 *)(iVar1 + -4) = 0;
  }
  iVar2 = *param_2;
  if (*(int *)(iVar2 + -4) < 0) {
    *(undefined4 *)(iVar2 + -4) = 0;
  }
  *param_1 = iVar2;
  *param_2 = iVar1;
  return;
}



undefined4 FUN_0001b500(undefined4 param_1)

{
  FUN_0001b4d4();
  return param_1;
}



undefined4 FUN_0001b50c(undefined4 param_1)

{
  FUN_0001b4d4();
  return param_1;
}



uint FUN_0001b520(int *param_1,char *param_2,uint param_3,uint param_4)

{
  char cVar1;
  uint uVar2;
  int iVar3;
  char *pcVar4;
  uint uVar5;
  int iVar6;
  bool bVar7;
  
  iVar6 = *param_1;
  uVar2 = *(uint *)(iVar6 + -0xc);
  if (param_4 == 0) {
    if (uVar2 < param_3) {
      param_3 = 0xffffffff;
    }
    return param_3;
  }
  if ((param_4 <= uVar2) && (param_3 <= uVar2 - param_4)) {
    cVar1 = *param_2;
    uVar5 = param_3 + 1;
    pcVar4 = (char *)(iVar6 + param_3);
    do {
      if ((*pcVar4 == cVar1) && (iVar3 = memcmp(pcVar4 + 1,param_2 + 1,param_4 - 1), iVar3 == 0)) {
        return (int)pcVar4 - iVar6;
      }
      bVar7 = uVar5 <= uVar2 - param_4;
      uVar5 = uVar5 + 1;
      pcVar4 = pcVar4 + 1;
    } while (bVar7);
  }
  return 0xffffffff;
}



void FUN_0001b598(undefined4 param_1,char *param_2,undefined4 param_3)

{
  size_t sVar1;
  
  sVar1 = strlen(param_2);
  FUN_0001b520(param_1,param_2,param_3,sVar1);
  return;
}



int FUN_0001b5b8(int *param_1,int param_2,uint param_3)

{
  void *pvVar1;
  int iVar2;
  
  iVar2 = *param_1;
  if ((param_3 < *(uint *)(iVar2 + -0xc)) &&
     (pvVar1 = memchr((void *)(param_3 + iVar2),param_2,*(uint *)(iVar2 + -0xc) - param_3),
     pvVar1 != (void *)0x0)) {
    return (int)pvVar1 - iVar2;
  }
  return -1;
}



uint FUN_0001b628(int *param_1,char *param_2,uint param_3)

{
  int iVar1;
  size_t __n;
  uint uVar2;
  int iVar3;
  bool bVar4;
  
  __n = strlen(param_2);
  iVar3 = *param_1;
  uVar2 = *(uint *)(iVar3 + -0xc);
  if (__n <= uVar2) {
    uVar2 = uVar2 - __n;
    if (param_3 <= uVar2) {
      uVar2 = param_3;
    }
    do {
      iVar1 = memcmp((void *)(iVar3 + uVar2),param_2,__n);
      if (iVar1 == 0) {
        return uVar2;
      }
      bVar4 = uVar2 != 0;
      uVar2 = uVar2 - 1;
    } while (bVar4);
  }
  return 0xffffffff;
}



uint FUN_0001b67c(int *param_1,void *param_2,uint param_3,size_t param_4)

{
  void *pvVar1;
  uint uVar2;
  int iVar3;
  
  if (param_4 != 0) {
    iVar3 = *param_1;
    uVar2 = *(uint *)(iVar3 + -0xc);
    if (param_3 < uVar2) {
      do {
        pvVar1 = memchr(param_2,(uint)*(byte *)(iVar3 + param_3),param_4);
        if (pvVar1 != (void *)0x0) {
          return param_3;
        }
        param_3 = param_3 + 1;
      } while (param_3 < uVar2);
    }
  }
  return 0xffffffff;
}



void FUN_0001b6c0(undefined4 param_1,char *param_2,undefined4 param_3)

{
  size_t sVar1;
  
  sVar1 = strlen(param_2);
  FUN_0001b67c(param_1,param_2,param_3,sVar1);
  return;
}



uint FUN_0001b734(int *param_1,char *param_2,uint param_3)

{
  void *pvVar1;
  size_t __n;
  int iVar2;
  uint uVar3;
  int iVar4;
  bool bVar5;
  
  __n = strlen(param_2);
  iVar4 = *param_1;
  iVar2 = *(int *)(iVar4 + -0xc);
  if (__n != 0 && iVar2 != 0) {
    uVar3 = iVar2 - 1;
    if (param_3 < uVar3) {
      uVar3 = param_3;
    }
    do {
      pvVar1 = memchr(param_2,(uint)*(byte *)(iVar4 + uVar3),__n);
      if (pvVar1 != (void *)0x0) {
        return uVar3;
      }
      bVar5 = uVar3 != 0;
      uVar3 = uVar3 - 1;
    } while (bVar5);
  }
  return 0xffffffff;
}



uint FUN_0001b79c(int *param_1,char *param_2,uint param_3)

{
  void *pvVar1;
  size_t __n;
  int iVar2;
  uint uVar3;
  
  __n = strlen(param_2);
  iVar2 = *param_1;
  uVar3 = *(uint *)(iVar2 + -0xc);
  if (param_3 < uVar3) {
    do {
      pvVar1 = memchr(param_2,(uint)*(byte *)(iVar2 + param_3),__n);
      if (pvVar1 == (void *)0x0) {
        return param_3;
      }
      param_3 = param_3 + 1;
    } while (param_3 < uVar3);
  }
  return 0xffffffff;
}



uint FUN_0001b7f4(int *param_1,void *param_2,uint param_3,size_t param_4)

{
  void *pvVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  bool bVar5;
  
  iVar4 = *param_1;
  iVar2 = *(int *)(iVar4 + -0xc);
  if (iVar2 != 0) {
    uVar3 = iVar2 - 1;
    if (param_3 < uVar3) {
      uVar3 = param_3;
    }
    do {
      pvVar1 = memchr(param_2,(uint)*(byte *)(iVar4 + uVar3),param_4);
      if (pvVar1 == (void *)0x0) {
        return uVar3;
      }
      bVar5 = uVar3 != 0;
      uVar3 = uVar3 - 1;
    } while (bVar5);
  }
  return 0xffffffff;
}



void FUN_0001b840(undefined4 param_1,char *param_2,undefined4 param_3)

{
  size_t sVar1;
  
  sVar1 = strlen(param_2);
  FUN_0001b7f4(param_1,param_2,param_3,sVar1);
  return;
}



void FUN_0001ba38(uint param_1,uint param_2)

{
  void *pvVar1;
  
  if (0x3ffffffc < param_1) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::_S_create");
  }
  if (param_2 < param_1) {
    if (param_1 < param_2 << 1) {
      param_1 = param_2 << 1;
    }
    if ((param_2 < param_1 && 0x1000 < param_1 + 0x1d) &&
       (param_1 = (param_1 + 0x1000) - (param_1 + 0x1d & 0xfff), 0x3ffffffb < param_1)) {
      param_1 = 0x3ffffffc;
    }
  }
  pvVar1 = operator_new(param_1 + 0xd);
  *(uint *)((int)pvVar1 + 4) = param_1;
  *(undefined4 *)((int)pvVar1 + 8) = 0;
  return;
}



size_t * FUN_0001ba98(size_t param_1,int param_2)

{
  size_t *psVar1;
  size_t *__s;
  undefined *puVar2;
  bool bVar3;
  
  if (param_1 != 0) {
    psVar1 = (size_t *)FUN_0001ba38(param_1,0);
    __s = psVar1 + 3;
    if (param_1 == 1) {
      *(char *)(psVar1 + 3) = (char)param_2;
    }
    else {
      __s = (size_t *)memset(__s,param_2,param_1);
    }
    puVar2 = &DAT_0002ff54;
    bVar3 = psVar1 != (size_t *)&DAT_0002ff54;
    if (bVar3) {
      *psVar1 = param_1;
      puVar2 = (undefined *)0x0;
    }
    if (bVar3) {
      psVar1[2] = (size_t)puVar2;
    }
    if (bVar3) {
      *(char *)((int)__s + param_1) = (char)puVar2;
    }
    return __s;
  }
  return (size_t *)&DAT_0002ff60;
}



undefined4 * FUN_0001bae8(undefined4 *param_1,undefined4 param_2)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001ba98(0,0,param_2);
  *param_1 = uVar1;
  return param_1;
}



undefined4 *
FUN_0001bafc(undefined4 *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001ba98(param_2,param_3,param_4);
  *param_1 = uVar1;
  return param_1;
}



void operator_delete(void *param_1)

{
  operator_delete(param_1);
  return;
}



void FUN_0001bb18(undefined *param_1)

{
  if (param_1 == &DAT_0002ff54) {
    return;
  }
  FUN_00016f3c();
  return;
}



int * FUN_0001bb2c(int *param_1)

{
  undefined1 auStack_c [4];
  
  if ((undefined *)(*param_1 + -0xc) != &DAT_0002ff54) {
    FUN_00016f3c((undefined *)(*param_1 + -0xc),auStack_c);
  }
  return param_1;
}



void FUN_0001bb50(int *param_1,size_t param_2,int param_3,int param_4)

{
  int iVar1;
  undefined *__dest;
  uint uVar2;
  size_t __n;
  undefined1 auStack_2c [8];
  
  __dest = (undefined *)*param_1;
  uVar2 = (param_4 - param_3) + *(int *)(__dest + -0xc);
  __n = (*(int *)(__dest + -0xc) - param_2) - param_3;
  if ((*(uint *)(__dest + -8) < uVar2) || (0 < *(int *)(__dest + -4))) {
    iVar1 = FUN_0001ba38(uVar2,*(uint *)(__dest + -8),auStack_2c);
    __dest = (undefined *)(iVar1 + 0xc);
    if (param_2 != 0) {
      if (param_2 == 1) {
        *(undefined1 *)(iVar1 + 0xc) = *(undefined1 *)*param_1;
      }
      else {
        memcpy(__dest,(undefined1 *)*param_1,param_2);
      }
    }
    if (__n != 0) {
      if (__n == 1) {
        __dest[param_4 + param_2] = *(undefined1 *)(*param_1 + param_2 + param_3);
      }
      else {
        memcpy(__dest + param_4 + param_2,(void *)(*param_1 + param_2 + param_3),__n);
      }
    }
    if ((undefined *)(*param_1 + -0xc) != &DAT_0002ff54) {
      FUN_00016f3c((undefined *)(*param_1 + -0xc),auStack_2c);
    }
    *param_1 = (int)__dest;
  }
  else if (param_3 != param_4 && __n != 0) {
    if (__n == 1) {
      __dest[param_4 + param_2] = __dest[param_2 + param_3];
      __dest = (undefined *)*param_1;
    }
    else {
      memmove(__dest + param_4 + param_2,__dest + param_2 + param_3,__n);
      __dest = (undefined *)*param_1;
    }
  }
  if (__dest != &DAT_0002ff60) {
    *(uint *)(__dest + -0xc) = uVar2;
    *(undefined4 *)(__dest + -4) = 0;
    __dest[uVar2] = 0;
  }
  return;
}



void FUN_0001bc48(undefined4 *param_1)

{
  undefined *puVar1;
  
  puVar1 = (undefined *)*param_1;
  if (puVar1 != &DAT_0002ff60) {
    if (0 < *(int *)(puVar1 + -4)) {
      FUN_0001bb50(param_1,0,0,0);
      puVar1 = (undefined *)*param_1;
    }
    *(undefined4 *)(puVar1 + -4) = 0xffffffff;
  }
  return;
}



int FUN_0001bc8c(int *param_1)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_0001bc48();
    iVar1 = *param_1;
  }
  return iVar1;
}



int * FUN_0001bca4(int *param_1,int *param_2)

{
  int iVar1;
  
  iVar1 = *param_2;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_0001bc48(param_2);
    iVar1 = *param_2;
  }
  *param_1 = iVar1;
  return param_1;
}



int FUN_0001bcc4(int *param_1)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_0001bc48();
    iVar1 = *param_1;
  }
  return *(int *)(iVar1 + -0xc) + iVar1;
}



int FUN_0001bce0(int *param_1,int param_2)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_0001bc48();
    iVar1 = *param_1;
  }
  return iVar1 + param_2;
}



int FUN_0001bcfc(int *param_1)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (-1 < *(int *)(iVar1 + -4)) {
    FUN_0001bc48();
    iVar1 = *param_1;
  }
  return iVar1;
}



int FUN_0001bd14(int *param_1)

{
  int iVar1;
  int iVar2;
  
  iVar2 = *param_1;
  iVar1 = *(int *)(iVar2 + -0xc);
  if (-1 < *(int *)(iVar2 + -4)) {
    FUN_0001bc48();
    iVar2 = *param_1;
  }
  return iVar2 + iVar1 + -1;
}



int FUN_0001bd34(int *param_1,uint param_2)

{
  int iVar1;
  
  iVar1 = *param_1;
  if (param_2 < *(uint *)(iVar1 + -0xc)) {
    if (-1 < *(int *)(iVar1 + -4)) {
      FUN_0001bc48();
      iVar1 = *param_1;
    }
    return iVar1 + param_2;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::at");
}



int * FUN_0001bd98(int *param_1,uint param_2,uint param_3,undefined4 param_4)

{
  uint uVar1;
  
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    uVar1 = *(uint *)(*param_1 + -0xc) - param_2;
    if (uVar1 < param_3) {
      param_3 = uVar1;
    }
    FUN_0001bb50(param_1,param_2,param_3,0,param_4);
    return param_1;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::erase");
}



int * FUN_0001be0c(int *param_1,int param_2,int param_3,uint param_4,byte param_5)

{
  if ((uint)((0x3ffffffc - *(int *)(*param_1 + -0xc)) + param_3) < param_4) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::_M_replace_aux");
  }
  FUN_0001bb50();
  if (param_4 != 0) {
    if (param_4 == 1) {
      *(byte *)(*param_1 + param_2) = param_5;
    }
    else {
      memset((void *)(*param_1 + param_2),(uint)param_5,param_4);
    }
  }
  return param_1;
}



void FUN_0001be60(int *param_1,undefined4 param_2,undefined4 param_3)

{
  FUN_0001be0c(param_1,0,*(undefined4 *)(*param_1 + -0xc),param_2,param_3);
  return;
}



void FUN_0001be98(int *param_1,uint param_2,undefined4 param_3,undefined4 param_4)

{
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    FUN_0001be0c(param_1,param_2,0,param_3,param_4);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::insert");
}



int FUN_0001bec0(int *param_1,int param_2,undefined4 param_3)

{
  int iVar1;
  int iVar2;
  
  iVar2 = *param_1;
  FUN_0001be0c(param_1,param_2 - iVar2,0,1,param_3);
  iVar1 = *param_1;
  *(undefined4 *)(iVar1 + -4) = 0xffffffff;
  return iVar1 + (param_2 - iVar2);
}



void FUN_0001bee8(int *param_1,uint param_2,uint param_3)

{
  uint uVar1;
  
  if (param_2 <= *(uint *)(*param_1 + -0xc)) {
    uVar1 = *(uint *)(*param_1 + -0xc) - param_2;
    if (uVar1 < param_3) {
      param_3 = uVar1;
    }
    FUN_0001be0c(param_1,param_2,param_3);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::replace");
}



void FUN_0001bf2c(int *param_1,int param_2,undefined4 param_3,undefined4 param_4)

{
  FUN_0001be0c(param_1,param_2 - *param_1,0,param_3,param_4);
  return;
}



int * FUN_0001bf44(int *param_1,int param_2,undefined4 param_3,undefined1 *param_4,size_t param_5)

{
  FUN_0001bb50();
  if (param_5 != 0) {
    if (param_5 == 1) {
      *(undefined1 *)(*param_1 + param_2) = *param_4;
      return param_1;
    }
    memcpy((void *)(*param_1 + param_2),param_4,param_5);
  }
  return param_1;
}



undefined4 * FUN_0001bf74(undefined4 *param_1,undefined *param_2,size_t param_3)

{
  undefined4 *puVar1;
  undefined1 uVar2;
  undefined *__dest;
  
  __dest = (undefined *)*param_1;
  if (0x3ffffffc < param_3) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::assign");
  }
  if (((param_2 < __dest) || (__dest + *(int *)(__dest + -0xc) < param_2)) ||
     (0 < *(int *)(__dest + -4))) {
    puVar1 = (undefined4 *)FUN_0001bf44(param_1,0,*(int *)(__dest + -0xc),param_2,param_3);
    return puVar1;
  }
  if ((uint)((int)param_2 - (int)__dest) < param_3) {
    if (param_2 == __dest) goto LAB_0001bfc4;
    if (param_3 != 1) {
      memmove(__dest,param_2,param_3);
      __dest = (undefined *)*param_1;
      goto LAB_0001bfc4;
    }
  }
  else if (param_3 != 1) {
    memcpy(__dest,param_2,param_3);
    __dest = (undefined *)*param_1;
    goto LAB_0001bfc4;
  }
  *__dest = *param_2;
  __dest = (undefined *)*param_1;
LAB_0001bfc4:
  uVar2 = 0x54;
  if (__dest != &DAT_0002ff60) {
    *(size_t *)(__dest + -0xc) = param_3;
    uVar2 = 0;
    *(undefined4 *)(__dest + -4) = 0;
  }
  if (__dest != &DAT_0002ff60) {
    __dest[param_3] = uVar2;
  }
  return param_1;
}



undefined4 FUN_0001c010(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  FUN_0001bf74(param_1,param_2,param_3);
  return param_1;
}



void FUN_0001c02c(undefined4 param_1,int *param_2,uint param_3,uint param_4)

{
  uint uVar1;
  
  uVar1 = *(uint *)(*param_2 + -0xc);
  if (param_3 <= uVar1) {
    uVar1 = uVar1 - param_3;
    if (param_4 <= uVar1) {
      uVar1 = param_4;
    }
    FUN_0001bf74(param_1,*param_2 + param_3,uVar1);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::assign");
}



void FUN_0001c088(undefined4 param_1,char *param_2,undefined4 param_3,undefined4 param_4)

{
  size_t sVar1;
  
  sVar1 = strlen(param_2);
  FUN_0001bf74(param_1,param_2,sVar1,param_4);
  return;
}



uint * FUN_0001c0a4(uint *param_1,uint param_2,uint param_3,uint param_4)

{
  void *__src;
  uint uVar1;
  void *__dest;
  uint uVar2;
  int iVar3;
  size_t __n;
  
  uVar2 = *param_1;
  uVar1 = *(uint *)(uVar2 - 0xc);
  if (uVar1 < param_2) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::insert");
  }
  if (param_4 <= 0x3ffffffc - uVar1) {
    if (((param_3 < uVar2) || (uVar1 + uVar2 < param_3)) || (0 < *(int *)(uVar2 - 4))) {
      param_1 = (uint *)FUN_0001bf44(param_1,param_2,0,param_3,param_4);
    }
    else {
      iVar3 = param_3 - uVar2;
      FUN_0001bb50(param_1,param_2,0);
      uVar1 = *param_1;
      __src = (void *)(uVar1 + iVar3);
      __dest = (void *)(uVar1 + param_2);
      if ((void *)((int)__src + param_4) <= __dest) {
        if (param_4 == 1) {
          *(undefined1 *)(uVar1 + param_2) = *(undefined1 *)(uVar1 + iVar3);
          return param_1;
        }
        memcpy(__dest,__src,param_4);
        return param_1;
      }
      if (__src < __dest) {
        __n = (int)__dest - (int)__src;
        if (__n == 1) {
          *(undefined1 *)(uVar1 + param_2) = *(undefined1 *)(uVar1 + iVar3);
        }
        else {
          __dest = memcpy(__dest,__src,__n);
        }
        if (param_4 - __n == 1) {
          *(undefined1 *)((int)__dest + __n) = *(undefined1 *)((int)__dest + param_4);
        }
        else {
          memcpy((void *)((int)__dest + __n),(void *)((int)__dest + param_4),param_4 - __n);
        }
      }
      else if (param_4 == 1) {
        *(undefined1 *)(uVar1 + param_2) = *(undefined1 *)((int)__src + 1);
      }
      else {
        memcpy(__dest,(void *)((int)__src + param_4),param_4);
      }
    }
    return param_1;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac00("basic_string::insert");
}



void FUN_0001c1bc(undefined4 param_1,undefined4 param_2,int *param_3,uint param_4,uint param_5)

{
  uint uVar1;
  
  uVar1 = *(uint *)(*param_3 + -0xc);
  if (param_4 <= uVar1) {
    uVar1 = uVar1 - param_4;
    if (param_5 <= uVar1) {
      uVar1 = param_5;
    }
    FUN_0001c0a4(param_1,param_2,*param_3 + param_4,uVar1);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::insert");
}



void FUN_0001c1ec(undefined4 param_1,undefined4 param_2,char *param_3)

{
  size_t sVar1;
  
  sVar1 = strlen(param_3);
  FUN_0001c0a4(param_1,param_2,param_3,sVar1);
  return;
}



void FUN_0001c218(int *param_1)

{
  uint uVar1;
  
  uVar1 = *(uint *)(*param_1 + -0xc) - 1;
  if (uVar1 <= *(uint *)(*param_1 + -0xc)) {
    FUN_0001bb50(param_1,uVar1,1,0);
    return;
  }
                    // WARNING: Subroutine does not return
  FUN_0001ac5c("basic_string::erase");
}



void FUN_0001c26c(size_t *param_1,undefined4 param_2,int param_3,undefined4 param_4)

{
  size_t *psVar1;
  size_t *__dest;
  size_t __n;
  undefined *puVar2;
  bool bVar3;
  
  psVar1 = (size_t *)FUN_0001ba38(*param_1 + param_3,param_1[1],param_2,param_2,param_4);
  __n = *param_1;
  __dest = psVar1 + 3;
  if (__n != 0) {
    __dest = psVar1 + 3;
    if (__n == 1) {
      *(char *)(psVar1 + 3) = (char)param_1[3];
      __n = *param_1;
    }
    else {
      __dest = (size_t *)memcpy(__dest,param_1 + 3,__n);
      __n = *param_1;
    }
  }
  puVar2 = &DAT_0002ff54;
  bVar3 = psVar1 != (size_t *)&DAT_0002ff54;
  if (bVar3) {
    *psVar1 = __n;
    puVar2 = (undefined *)0x0;
  }
  if (bVar3) {
    psVar1[2] = (size_t)puVar2;
  }
  if (bVar3) {
    *(char *)((int)__dest + __n) = (char)puVar2;
  }
  return;
}



void FUN_0001c2b8(int *param_1,uint param_2)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  undefined1 auStack_14 [4];
  
  iVar3 = *param_1;
  if ((param_2 != *(uint *)(iVar3 + -8)) || (0 < *(int *)(iVar3 + -4))) {
    uVar1 = *(uint *)(iVar3 + -0xc);
    if (param_2 < uVar1) {
      iVar2 = 0;
    }
    else {
      iVar2 = param_2 - uVar1;
    }
    iVar3 = FUN_0001c26c((uint *)(iVar3 + -0xc),auStack_14,iVar2);
    if ((undefined *)(*param_1 + -0xc) != &DAT_0002ff54) {
      FUN_00016f3c((undefined *)(*param_1 + -0xc),auStack_14);
    }
    *param_1 = iVar3;
  }
  return;
}



int * FUN_0001c338(int *param_1,undefined4 *param_2)

{
  undefined1 *__src;
  int iVar1;
  undefined *puVar2;
  size_t __n;
  int iVar3;
  uint uVar4;
  
  __src = (undefined1 *)*param_2;
  __n = *(size_t *)(__src + -0xc);
  if (__n != 0) {
    iVar1 = *param_1;
    iVar3 = *(int *)(iVar1 + -0xc);
    uVar4 = iVar3 + __n;
    if ((*(uint *)(iVar1 + -8) < uVar4) || (0 < *(int *)(iVar1 + -4))) {
      FUN_0001c2b8(param_1,uVar4);
      iVar1 = *param_1;
      __src = (undefined1 *)*param_2;
      iVar3 = *(int *)(iVar1 + -0xc);
    }
    if (__n == 1) {
      *(undefined1 *)(iVar1 + iVar3) = *__src;
    }
    else {
      memcpy((void *)(iVar1 + iVar3),__src,__n);
    }
    puVar2 = (undefined *)*param_1;
    if (puVar2 != &DAT_0002ff60) {
      *(uint *)(puVar2 + -0xc) = uVar4;
      *(undefined4 *)(puVar2 + -4) = 0;
      puVar2[uVar4] = 0;
    }
  }
  return param_1;
}



undefined4 * FUN_0001c508(undefined4 *param_1,char *param_2,undefined4 param_3,undefined4 param_4)

{
  size_t __n;
  char cVar1;
  char *pcVar2;
  char *pcVar3;
  undefined *puVar4;
  undefined4 unaff_r4;
  undefined4 unaff_r5;
  int iVar5;
  char *pcVar6;
  
  __n = strlen(param_2);
  if (__n != 0) {
    pcVar3 = (char *)*param_1;
    pcVar2 = *(char **)(pcVar3 + -0xc);
    if (0x3ffffffcU - (int)pcVar2 < __n) {
                    // WARNING: Subroutine does not return
      FUN_0001ac00("basic_string::append");
    }
    pcVar6 = pcVar2 + __n;
    if ((*(char **)(pcVar3 + -8) < pcVar6) || (0 < *(int *)(pcVar3 + -4))) {
      if ((param_2 < pcVar3) || (pcVar2 = pcVar2 + (int)pcVar3, pcVar2 < param_2)) {
        FUN_0001c2b8(param_1,pcVar6,pcVar2,pcVar3,param_4,unaff_r4,unaff_r5);
        pcVar3 = (char *)*param_1;
        pcVar2 = *(char **)(pcVar3 + -0xc);
      }
      else {
        iVar5 = (int)param_2 - (int)pcVar3;
        FUN_0001c2b8(param_1,pcVar6,pcVar2,pcVar3,param_4,unaff_r4,unaff_r5);
        pcVar3 = (char *)*param_1;
        param_2 = pcVar3 + iVar5;
        pcVar2 = *(char **)(pcVar3 + -0xc);
      }
    }
    if (__n == 1) {
      pcVar3[(int)pcVar2] = *param_2;
    }
    else {
      memcpy(pcVar3 + (int)pcVar2,param_2,__n);
    }
    puVar4 = (undefined *)*param_1;
    cVar1 = 'T';
    if (puVar4 != &DAT_0002ff60) {
      *(char **)(puVar4 + -0xc) = pcVar6;
      cVar1 = '\0';
      *(undefined4 *)(puVar4 + -4) = 0;
    }
    if (puVar4 != &DAT_0002ff60) {
      pcVar6[(int)puVar4] = cVar1;
    }
  }
  return param_1;
}



undefined4 * FUN_0001c538(undefined4 *param_1,char *param_2,undefined4 param_3,undefined4 param_4)

{
  size_t __n;
  char cVar1;
  char *pcVar2;
  char *pcVar3;
  undefined *puVar4;
  undefined4 unaff_r4;
  undefined4 unaff_r5;
  int iVar5;
  char *pcVar6;
  
  __n = strlen(param_2);
  if (__n != 0) {
    pcVar3 = (char *)*param_1;
    pcVar2 = *(char **)(pcVar3 + -0xc);
    if (0x3ffffffcU - (int)pcVar2 < __n) {
                    // WARNING: Subroutine does not return
      FUN_0001ac00("basic_string::append");
    }
    pcVar6 = pcVar2 + __n;
    if ((*(char **)(pcVar3 + -8) < pcVar6) || (0 < *(int *)(pcVar3 + -4))) {
      if ((param_2 < pcVar3) || (pcVar2 = pcVar2 + (int)pcVar3, pcVar2 < param_2)) {
        FUN_0001c2b8(param_1,pcVar6,pcVar2,pcVar3,param_4,unaff_r4,unaff_r5);
        pcVar3 = (char *)*param_1;
        pcVar2 = *(char **)(pcVar3 + -0xc);
      }
      else {
        iVar5 = (int)param_2 - (int)pcVar3;
        FUN_0001c2b8(param_1,pcVar6,pcVar2,pcVar3,param_4,unaff_r4,unaff_r5);
        pcVar3 = (char *)*param_1;
        param_2 = pcVar3 + iVar5;
        pcVar2 = *(char **)(pcVar3 + -0xc);
      }
    }
    if (__n == 1) {
      pcVar3[(int)pcVar2] = *param_2;
    }
    else {
      memcpy(pcVar3 + (int)pcVar2,param_2,__n);
    }
    puVar4 = (undefined *)*param_1;
    cVar1 = 'T';
    if (puVar4 != &DAT_0002ff60) {
      *(char **)(puVar4 + -0xc) = pcVar6;
      cVar1 = '\0';
      *(undefined4 *)(puVar4 + -4) = 0;
    }
    if (puVar4 != &DAT_0002ff60) {
      pcVar6[(int)puVar4] = cVar1;
    }
  }
  return param_1;
}



int * FUN_0001c554(int *param_1,uint param_2,int param_3)

{
  undefined1 uVar1;
  int iVar2;
  undefined *puVar3;
  int iVar4;
  uint uVar5;
  
  if (param_2 != 0) {
    iVar2 = *param_1;
    iVar4 = *(int *)(iVar2 + -0xc);
    if (0x3ffffffcU - iVar4 < param_2) {
                    // WARNING: Subroutine does not return
      FUN_0001ac00("basic_string::append");
    }
    uVar5 = param_2 + iVar4;
    if ((*(uint *)(iVar2 + -8) < uVar5) || (0 < *(int *)(iVar2 + -4))) {
      FUN_0001c2b8(param_1,uVar5);
      iVar2 = *param_1;
      iVar4 = *(int *)(iVar2 + -0xc);
    }
    if (param_2 == 1) {
      *(char *)(iVar2 + iVar4) = (char)param_3;
    }
    else {
      memset((void *)(iVar2 + iVar4),param_3,param_2);
    }
    puVar3 = (undefined *)*param_1;
    uVar1 = 0x54;
    if (puVar3 != &DAT_0002ff60) {
      *(uint *)(puVar3 + -0xc) = uVar5;
      uVar1 = 0;
      *(undefined4 *)(puVar3 + -4) = 0;
    }
    if (puVar3 != &DAT_0002ff60) {
      puVar3[uVar5] = uVar1;
    }
  }
  return param_1;
}



void FUN_0001c624(int *param_1,undefined1 param_2)

{
  int iVar1;
  int iVar2;
  undefined *puVar3;
  uint uVar4;
  
  iVar2 = *param_1;
  iVar1 = *(int *)(iVar2 + -0xc);
  uVar4 = iVar1 + 1;
  if ((*(uint *)(iVar2 + -8) < uVar4) || (0 < *(int *)(iVar2 + -4))) {
    FUN_0001c2b8(param_1,uVar4);
    iVar2 = *param_1;
    iVar1 = *(int *)(iVar2 + -0xc);
  }
  *(undefined1 *)(iVar2 + iVar1) = param_2;
  puVar3 = (undefined *)*param_1;
  if (puVar3 == &DAT_0002ff60) {
    return;
  }
  *(uint *)(puVar3 + -0xc) = uVar4;
  *(undefined4 *)(puVar3 + -4) = 0;
  puVar3[uVar4] = 0;
  return;
}



int * FUN_0001c700(int *param_1,int *param_2)

{
  bool bVar1;
  int *piVar2;
  int iVar3;
  undefined1 auStack_c [4];
  
  iVar3 = *param_2;
  if (*(int *)(iVar3 + -4) < 0) {
    iVar3 = FUN_0001c26c((undefined *)(iVar3 + -0xc),auStack_c,0);
    *param_1 = iVar3;
    return param_1;
  }
  if ((undefined *)(iVar3 + -0xc) != &DAT_0002ff54) {
    piVar2 = (int *)(iVar3 + -4);
    DataMemoryBarrier(0x1f);
    do {
      ExclusiveAccess(piVar2);
      bVar1 = (bool)hasExclusiveAccess(piVar2);
    } while (!bVar1);
    *piVar2 = *piVar2 + 1;
    DataMemoryBarrier(0x1f);
  }
  *param_1 = iVar3;
  return param_1;
}



size_t * FUN_0001ca48(undefined1 *param_1,undefined1 *param_2)

{
  size_t *psVar1;
  size_t *__dest;
  undefined *puVar2;
  size_t __n;
  bool bVar3;
  
  if (param_1 == param_2) {
    return (size_t *)&DAT_0002ff60;
  }
  if (param_1 == (undefined1 *)0x0) {
    if (param_2 != (undefined1 *)0x0) {
                    // WARNING: Subroutine does not return
      FUN_0001aaec("basic_string::_S_construct null not valid");
    }
    psVar1 = (size_t *)FUN_0001ba38();
    __dest = psVar1 + 3;
    __n = 0;
  }
  else {
    __n = (int)param_2 - (int)param_1;
    psVar1 = (size_t *)FUN_0001ba38(__n,0);
    __dest = psVar1 + 3;
    if (__n == 1) {
      *(undefined1 *)(psVar1 + 3) = *param_1;
      goto LAB_0001ca6c;
    }
  }
  __dest = (size_t *)memcpy(__dest,param_1,__n);
LAB_0001ca6c:
  puVar2 = &DAT_0002ff54;
  bVar3 = psVar1 != (size_t *)&DAT_0002ff54;
  if (bVar3) {
    *psVar1 = __n;
    puVar2 = (undefined *)0x0;
  }
  if (bVar3) {
    psVar1[2] = (size_t)puVar2;
  }
  if (bVar3) {
    *(char *)((int)__dest + __n) = (char)puVar2;
  }
  return __dest;
}



undefined4 * FUN_0001cabc(undefined4 *param_1,int param_2,int param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001ca48(param_2,param_2 + param_3,param_4,0);
  *param_1 = uVar1;
  return param_1;
}



uint * FUN_0001cad4(uint *param_1,uint param_2,uint param_3,uint param_4,uint param_5)

{
  uint *puVar1;
  uint uVar2;
  uint uVar3;
  int iVar4;
  uint uVar5;
  undefined1 auStack_20 [4];
  int local_1c;
  
  uVar2 = *param_1;
  uVar3 = *(uint *)(uVar2 - 0xc);
  if (uVar3 < param_2) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::replace");
  }
  uVar5 = uVar3 - param_2;
  if (param_3 <= uVar3 - param_2) {
    uVar5 = param_3;
  }
  if ((0x3ffffffc - uVar3) + uVar5 < param_5) {
                    // WARNING: Subroutine does not return
    FUN_0001ac00("basic_string::replace");
  }
  if (((param_4 < uVar2) || (uVar3 + uVar2 < param_4)) || (0 < *(int *)(uVar2 - 4))) {
    puVar1 = (uint *)FUN_0001bf44(param_1,param_2,uVar5,param_4,param_5);
    return puVar1;
  }
  if (uVar2 + param_2 < param_4 + param_5) {
    if (param_4 < uVar5 + param_2 + uVar2) {
      FUN_0001cabc(&local_1c,param_4,param_5,auStack_20);
      puVar1 = (uint *)FUN_0001bf44(param_1,param_2,uVar5,local_1c,param_5);
      if ((undefined *)(local_1c + -0xc) == &DAT_0002ff54) {
        return puVar1;
      }
      FUN_00016f3c((undefined *)(local_1c + -0xc),auStack_20);
      return puVar1;
    }
    iVar4 = ((param_4 - uVar2) + param_5) - uVar5;
  }
  else {
    iVar4 = param_4 - uVar2;
  }
  FUN_0001bb50(param_1,param_2,uVar5,param_5);
  uVar2 = *param_1;
  if (param_5 != 1) {
    memcpy((void *)(uVar2 + param_2),(void *)(uVar2 + iVar4),param_5);
    return param_1;
  }
  *(undefined1 *)(uVar2 + param_2) = *(undefined1 *)(uVar2 + iVar4);
  return param_1;
}



void FUN_0001cbfc(void)

{
  int *in_r3;
  uint in_stack_00000000;
  
  if (*(uint *)(*in_r3 + -0xc) < in_stack_00000000) {
                    // WARNING: Subroutine does not return
    FUN_0001ac5c("basic_string::replace");
  }
  FUN_0001cad4();
  return;
}



void FUN_0001cc2c(undefined4 param_1,undefined4 param_2,undefined4 param_3,char *param_4)

{
  size_t sVar1;
  
  sVar1 = strlen(param_4);
  FUN_0001cad4(param_1,param_2,param_3,param_4,sVar1);
  return;
}



void FUN_0001cc50(int *param_1,int param_2,int param_3)

{
  FUN_0001cad4(param_1,param_2 - *param_1,param_3 - param_2);
  return;
}



void FUN_0001cc7c(int *param_1,int param_2,int param_3,char *param_4)

{
  size_t sVar1;
  
  sVar1 = strlen(param_4);
  FUN_0001cad4(param_1,param_2 - *param_1,param_3 - param_2,param_4,sVar1);
  return;
}



undefined4 * FUN_0001cd0c(undefined4 *param_1,char *param_2,undefined4 param_3)

{
  size_t sVar1;
  undefined4 uVar2;
  char *pcVar3;
  
  pcVar3 = (char *)0xffffffff;
  if (param_2 != (char *)0x0) {
    sVar1 = strlen(param_2);
    pcVar3 = param_2 + sVar1;
  }
  uVar2 = FUN_0001ca48(param_2,pcVar3,param_3,0);
  *param_1 = uVar2;
  return param_1;
}



undefined4 * FUN_0001cd34(undefined4 *param_1,int param_2,int param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001ca48(param_2,param_3 + param_2,param_4,0);
  *param_1 = uVar1;
  return param_1;
}



undefined4 *
FUN_0001cd58(undefined4 *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  
  uVar1 = FUN_0001ca48(param_2,param_3,param_4,0);
  *param_1 = uVar1;
  return param_1;
}



undefined4 __cxa_guard_acquire(uint *param_1)

{
  uint uVar1;
  undefined4 uVar2;
  bool bVar3;
  undefined4 local_24;
  
  if ((*param_1 & 1) != 0) {
    return 0;
  }
LAB_0001cdae:
  DataMemoryBarrier(0x1f);
  do {
    ExclusiveAccess(param_1);
    local_24 = *param_1;
    bVar3 = local_24 == 0;
    if (!bVar3) goto LAB_0001cdc4;
    bVar3 = (bool)hasExclusiveAccess(param_1);
  } while (!bVar3);
  *param_1 = 0x100;
LAB_0001cdc4:
  DataMemoryBarrier(0x1f);
  if (bVar3) {
    uVar2 = 1;
  }
  else {
    uVar2 = 0;
    if (local_24 != 1) {
      if (local_24 != 0x100) goto LAB_0001cde0;
      DataMemoryBarrier(0x1f);
      do {
        ExclusiveAccess(param_1);
        uVar1 = *param_1;
        bVar3 = uVar1 == 0x100;
        if (!bVar3) goto LAB_0001ce0e;
        bVar3 = (bool)hasExclusiveAccess(param_1);
      } while (!bVar3);
      *param_1 = 0x10100;
LAB_0001ce0e:
      DataMemoryBarrier(0x1f);
      local_24 = 0x10100;
      if (bVar3) goto LAB_0001cde0;
      if (uVar1 != 1) goto code_r0x0001ce18;
    }
  }
  return uVar2;
code_r0x0001ce18:
  if (uVar1 != 0) {
LAB_0001cde0:
    syscall(0xf0,param_1,0,local_24,0);
  }
  goto LAB_0001cdae;
}



void __cxa_guard_abort(uint *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  bool bVar1;
  uint uVar2;
  
  DataMemoryBarrier(0x1f);
  do {
    ExclusiveAccess(param_1);
    uVar2 = *param_1;
    bVar1 = (bool)hasExclusiveAccess(param_1);
  } while (!bVar1);
  *param_1 = 0;
  DataMemoryBarrier(0x1f);
  if ((uVar2 & 0x10000) != 0) {
    syscall(0xf0,param_1,1,0x7fffffff,param_4);
    return;
  }
  return;
}



void __cxa_guard_release(uint *param_1)

{
  bool bVar1;
  uint uVar2;
  
  DataMemoryBarrier(0x1f);
  do {
    ExclusiveAccess(param_1);
    uVar2 = *param_1;
    bVar1 = (bool)hasExclusiveAccess(param_1);
  } while (!bVar1);
  *param_1 = 1;
  DataMemoryBarrier(0x1f);
  if ((uVar2 & 0x10000) != 0) {
    syscall(0xf0,param_1,1,0x7fffffff);
    return;
  }
  return;
}



void FUN_0001cea4(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001cea4_1_0002a8d0;
  return;
}



undefined4 FUN_0001ceb4(void)

{
  return 0;
}



undefined4 * FUN_0001cec0(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001cea4_1_0002a8d0;
  operator_delete(param_1);
  return param_1;
}



int FUN_0001ced8(int param_1,int param_2)

{
  uint uVar1;
  int iVar2;
  char *__s2;
  
  if (param_2 == param_1) {
    return 1;
  }
  if (**(char **)(param_1 + 4) != '*') {
    __s2 = *(char **)(param_2 + 4);
    if (*__s2 == '*') {
      __s2 = __s2 + 1;
    }
    uVar1 = strcmp(*(char **)(param_1 + 4),__s2);
    iVar2 = 1 - uVar1;
    if (1 < uVar1) {
      iVar2 = 0;
    }
    return iVar2;
  }
  return 0;
}



// std::bad_typeid::what() const

char * std::bad_typeid::what(void)

{
  return "std::bad_typeid";
}



// std::bad_typeid::~bad_typeid()

bad_typeid * __thiscall std::bad_typeid::~bad_typeid(bad_typeid *this)

{
  *(undefined ***)this = &PTR__bad_typeid_1_0002a8f8;
  exception::~exception((exception *)this);
  return this;
}



// std::bad_typeid::~bad_typeid()

bad_typeid * __thiscall std::bad_typeid::~bad_typeid(bad_typeid *this)

{
  ~bad_typeid(this);
  operator_delete(this);
  return this;
}



// __cxxabiv1::__si_class_type_info::~__si_class_type_info()

__si_class_type_info * __thiscall
__cxxabiv1::__si_class_type_info::~__si_class_type_info(__si_class_type_info *this)

{
  *(undefined ***)this = &PTR____si_class_type_info_1_0002a920;
  __class_type_info::~__class_type_info((__class_type_info *)this);
  return this;
}



// __cxxabiv1::__si_class_type_info::~__si_class_type_info()

__si_class_type_info * __thiscall
__cxxabiv1::__si_class_type_info::~__si_class_type_info(__si_class_type_info *this)

{
  ~__si_class_type_info(this);
  operator_delete(this);
  return this;
}



// __cxxabiv1::__si_class_type_info::__do_find_public_src(int, void const*,
// __cxxabiv1::__class_type_info const*, void const*) const

undefined4 __thiscall
__cxxabiv1::__si_class_type_info::__do_find_public_src
          (__si_class_type_info *this,int param_1,void *param_2,__class_type_info *param_3,
          void *param_4)

{
  undefined4 uVar1;
  int iVar2;
  
  if ((param_4 == param_2) && (iVar2 = FUN_0001ced8(this,param_3), iVar2 != 0)) {
    return 6;
  }
  uVar1 = (**(code **)(**(int **)(this + 8) + 0x20))
                    (*(int **)(this + 8),param_1,param_2,param_3,param_4);
  return uVar1;
}



// __cxxabiv1::__si_class_type_info::__do_dyncast(int, __cxxabiv1::__class_type_info::__sub_kind,
// __cxxabiv1::__class_type_info const*, void const*, __cxxabiv1::__class_type_info const*, void
// const*, __cxxabiv1::__class_type_info::__dyncast_result&) const

int __thiscall
__cxxabiv1::__si_class_type_info::__do_dyncast
          (__si_class_type_info *this,int param_1,int param_3,int param_4,int param_5,
          undefined4 param_6,int param_7,int *param_8)

{
  int iVar1;
  int iVar2;
  
  iVar2 = param_4;
  iVar1 = FUN_0001ced8(this,param_4);
  if (iVar1 == 0) {
    if ((param_5 == param_7) && (iVar2 = FUN_0001ced8(this,param_6), iVar2 != 0)) {
      param_8[2] = param_3;
    }
    else {
      iVar1 = (**(code **)(**(int **)(this + 8) + 0x1c))
                        (*(int **)(this + 8),param_1,param_3,param_4,param_5,param_6,param_7,param_8
                        );
    }
  }
  else {
    *param_8 = param_5;
    param_8[1] = param_3;
    if (-1 < param_1) {
      if (param_7 == param_5 + param_1) {
        iVar2 = 6;
      }
      else {
        iVar2 = 1;
      }
      param_8[3] = iVar2;
      return 0;
    }
    if (param_1 == -2) {
      iVar2 = 1;
      iVar1 = 0;
    }
    if (param_1 == -2) {
      param_8[3] = iVar2;
    }
    else {
      iVar1 = 0;
    }
  }
  return iVar1;
}



// __cxxabiv1::__si_class_type_info::__do_upcast(__cxxabiv1::__class_type_info const*, void const*,
// __cxxabiv1::__class_type_info::__upcast_result&) const

void __thiscall
__cxxabiv1::__si_class_type_info::__do_upcast
          (__si_class_type_info *this,__class_type_info *param_1,void *param_2,
          __upcast_result *param_3)

{
  int iVar1;
  __upcast_result *p_Var2;
  
  p_Var2 = param_3;
  iVar1 = __class_type_info::__do_upcast((__class_type_info *)this,param_1,param_2,param_3);
  if (iVar1 == 0) {
    (**(code **)(**(int **)(this + 8) + 0x18))(*(int **)(this + 8),param_1,param_2,param_3,p_Var2);
  }
  return;
}



// __cxxabiv1::__class_type_info::__do_upcast(__cxxabiv1::__class_type_info const*, void**) const

bool __thiscall
__cxxabiv1::__class_type_info::__do_upcast
          (__class_type_info *this,__class_type_info *param_1,void **param_2)

{
  bool bVar1;
  void *local_28;
  uint local_24;
  undefined4 local_20;
  undefined4 local_1c;
  
  local_28 = (void *)0x0;
  local_24 = 0;
  local_1c = 0;
  local_20 = 0x10;
  (**(code **)(*(int *)this + 0x18))(this,param_1,*param_2,&local_28);
  bVar1 = (local_24 & 6) == 6;
  if (bVar1) {
    *param_2 = local_28;
  }
  return bVar1;
}



// __cxxabiv1::__class_type_info::__do_find_public_src(int, void const*,
// __cxxabiv1::__class_type_info const*, void const*) const

undefined4 __thiscall
__cxxabiv1::__class_type_info::__do_find_public_src
          (__class_type_info *this,int param_1,void *param_2,__class_type_info *param_3,
          void *param_4)

{
  undefined4 uVar1;
  
  if (param_4 == param_2) {
    uVar1 = 6;
  }
  else {
    uVar1 = 1;
  }
  return uVar1;
}



// __cxxabiv1::__class_type_info::~__class_type_info()

__class_type_info * __thiscall
__cxxabiv1::__class_type_info::~__class_type_info(__class_type_info *this)

{
  *(undefined ***)this = &PTR____class_type_info_1_0002a960;
  FUN_0001cea4();
  return this;
}



// __cxxabiv1::__class_type_info::~__class_type_info()

__class_type_info * __thiscall
__cxxabiv1::__class_type_info::~__class_type_info(__class_type_info *this)

{
  ~__class_type_info(this);
  operator_delete(this);
  return this;
}



// __cxxabiv1::__class_type_info::__do_upcast(__cxxabiv1::__class_type_info const*, void const*,
// __cxxabiv1::__class_type_info::__upcast_result&) const

void __thiscall
__cxxabiv1::__class_type_info::__do_upcast
          (__class_type_info *this,__class_type_info *param_1,void *param_2,__upcast_result *param_3
          )

{
  int iVar1;
  
  iVar1 = FUN_0001ced8();
  if (iVar1 != 0) {
    *(void **)param_3 = param_2;
    *(undefined4 *)(param_3 + 0xc) = 8;
    *(undefined4 *)(param_3 + 4) = 6;
  }
  return;
}



// __cxxabiv1::__class_type_info::__do_catch(std::type_info const*, void**, unsigned int) const

void __thiscall
__cxxabiv1::__class_type_info::__do_catch
          (__class_type_info *this,type_info *param_1,void **param_2,uint param_3)

{
  int iVar1;
  uint uVar2;
  
  uVar2 = param_3;
  iVar1 = FUN_0001ced8();
  if ((iVar1 == 0) && (param_3 < 4)) {
    (**(code **)(*(int *)param_1 + 0x14))
              (param_1,this,param_2,*(code **)(*(int *)param_1 + 0x14),uVar2);
    return;
  }
  return;
}



// __cxxabiv1::__class_type_info::__do_dyncast(int, __cxxabiv1::__class_type_info::__sub_kind,
// __cxxabiv1::__class_type_info const*, void const*, __cxxabiv1::__class_type_info const*, void
// const*, __cxxabiv1::__class_type_info::__dyncast_result&) const

undefined4 __thiscall
__cxxabiv1::__class_type_info::__do_dyncast
          (__class_type_info *this,undefined4 param_2,int param_3,undefined4 param_4,int param_5,
          undefined4 param_6,int param_7,int *param_8)

{
  int iVar1;
  
  if ((param_5 == param_7) && (iVar1 = FUN_0001ced8(this,param_6), iVar1 != 0)) {
    param_8[2] = param_3;
    return 0;
  }
  iVar1 = FUN_0001ced8(this,param_4);
  if (iVar1 != 0) {
    *param_8 = param_5;
    param_8[1] = param_3;
    param_8[3] = 1;
  }
  return 0;
}



// __cxxabiv1::__pointer_type_info::__is_pointer_p() const

undefined4 __cxxabiv1::__pointer_type_info::__is_pointer_p(void)

{
  return 1;
}



// __cxxabiv1::__pointer_type_info::~__pointer_type_info()

__pointer_type_info * __thiscall
__cxxabiv1::__pointer_type_info::~__pointer_type_info(__pointer_type_info *this)

{
  *(undefined ***)this = &PTR____pointer_type_info_1_0002a9a8;
  __pbase_type_info::~__pbase_type_info((__pbase_type_info *)this);
  return this;
}



// __cxxabiv1::__pointer_type_info::~__pointer_type_info()

__pointer_type_info * __thiscall
__cxxabiv1::__pointer_type_info::~__pointer_type_info(__pointer_type_info *this)

{
  ~__pointer_type_info(this);
  operator_delete(this);
  return this;
}



// __cxxabiv1::__pointer_type_info::__pointer_catch(__cxxabiv1::__pbase_type_info const*, void**,
// unsigned int) const

uint __thiscall
__cxxabiv1::__pointer_type_info::__pointer_catch
          (__pointer_type_info *this,__pbase_type_info *param_1,void **param_2,uint param_3)

{
  uint uVar1;
  undefined8 uVar2;
  
  if (param_3 < 2) {
    uVar2 = FUN_0001ced8(*(undefined4 *)(this + 0xc),&void::typeinfo);
    if ((int)uVar2 != 0) {
      uVar1 = (**(code **)(**(int **)(param_1 + 0xc) + 0xc))
                        (*(int **)(param_1 + 0xc),(int)((ulonglong)uVar2 >> 0x20),param_2);
      return (uVar1 ^ 1) & 0xff;
    }
  }
  uVar1 = (**(code **)(**(int **)(this + 0xc) + 0x10))
                    (*(int **)(this + 0xc),*(undefined4 *)(param_1 + 0xc),param_2,param_3 + 2);
  return uVar1;
}



// std::__exception_ptr::exception_ptr::_M_safe_bool_dummy()

void std::__exception_ptr::exception_ptr::_M_safe_bool_dummy(void)

{
  return;
}



// std::__exception_ptr::exception_ptr::exception_ptr()

void __thiscall std::__exception_ptr::exception_ptr::exception_ptr(exception_ptr *this)

{
  *(undefined4 *)this = 0;
  return;
}



// std::__exception_ptr::exception_ptr::exception_ptr(void
// (std::__exception_ptr::exception_ptr::*)())

void __thiscall
std::__exception_ptr::exception_ptr::exception_ptr(exception_ptr *this,_func_void *param_1)

{
  *(undefined4 *)this = 0;
  return;
}



// std::__exception_ptr::exception_ptr::_M_addref()

void __thiscall std::__exception_ptr::exception_ptr::_M_addref(exception_ptr *this)

{
  bool bVar1;
  int *piVar2;
  
  if (*(int *)this != 0) {
    piVar2 = (int *)(*(int *)this + -0x80);
    DataMemoryBarrier(0x1f);
    do {
      ExclusiveAccess(piVar2);
      bVar1 = (bool)hasExclusiveAccess(piVar2);
    } while (!bVar1);
    *piVar2 = *piVar2 + 1;
    DataMemoryBarrier(0x1f);
  }
  return;
}



// std::__exception_ptr::exception_ptr::exception_ptr(void*)

exception_ptr * __thiscall
std::__exception_ptr::exception_ptr::exception_ptr(exception_ptr *this,void *param_1)

{
  *(void **)this = param_1;
  _M_addref(this);
  return this;
}



// std::__exception_ptr::exception_ptr::exception_ptr(std::__exception_ptr::exception_ptr const&)

exception_ptr * __thiscall
std::__exception_ptr::exception_ptr::exception_ptr(exception_ptr *this,exception_ptr *param_1)

{
  *(undefined4 *)this = *(undefined4 *)param_1;
  _M_addref(this);
  return this;
}



// std::__exception_ptr::exception_ptr::_M_release()

void __thiscall std::__exception_ptr::exception_ptr::_M_release(exception_ptr *this)

{
  bool bVar1;
  int iVar2;
  int *piVar3;
  int iVar4;
  
  iVar4 = *(int *)this;
  if (iVar4 != 0) {
    piVar3 = (int *)(iVar4 + -0x80);
    DataMemoryBarrier(0x1f);
    do {
      ExclusiveAccess(piVar3);
      iVar2 = *piVar3;
      bVar1 = (bool)hasExclusiveAccess(piVar3);
    } while (!bVar1);
    *piVar3 = iVar2 + -1;
    DataMemoryBarrier(0x1f);
    if (iVar2 + -1 == 0) {
      if (*(code **)(iVar4 + -0x74) != (code *)0x0) {
        (**(code **)(iVar4 + -0x74))(*(undefined4 *)this);
      }
      __cxa_free_exception(*(undefined4 *)this);
      *(undefined4 *)this = 0;
    }
  }
  return;
}



// std::__exception_ptr::exception_ptr::~exception_ptr()

exception_ptr * __thiscall std::__exception_ptr::exception_ptr::~exception_ptr(exception_ptr *this)

{
  _M_release(this);
  return this;
}



// std::__exception_ptr::exception_ptr::_M_get() const

undefined4 __thiscall std::__exception_ptr::exception_ptr::_M_get(exception_ptr *this)

{
  return *(undefined4 *)this;
}



// std::__exception_ptr::exception_ptr::swap(std::__exception_ptr::exception_ptr&)

void __thiscall
std::__exception_ptr::exception_ptr::swap(exception_ptr *this,exception_ptr *param_1)

{
  undefined4 uVar1;
  
  uVar1 = *(undefined4 *)this;
  *(undefined4 *)this = *(undefined4 *)param_1;
  *(undefined4 *)param_1 = uVar1;
  return;
}



// std::__exception_ptr::exception_ptr::TEMPNAMEPLACEHOLDERVALUE(std::__exception_ptr::exception_ptr
// const&)

exception_ptr * __thiscall
std::__exception_ptr::exception_ptr::operator=(exception_ptr *this,exception_ptr *param_1)

{
  exception_ptr aeStack_14 [8];
  
  exception_ptr(aeStack_14,param_1);
  swap(aeStack_14,this);
  ~exception_ptr(aeStack_14);
  return this;
}



// std::__exception_ptr::exception_ptr::TEMPNAMEPLACEHOLDERVALUE() const

int __thiscall std::__exception_ptr::exception_ptr::operator!(exception_ptr *this)

{
  int iVar1;
  
  iVar1 = 1 - *(uint *)this;
  if (1 < *(uint *)this) {
    iVar1 = 0;
  }
  return iVar1;
}



// std::__exception_ptr::exception_ptr::operator void (std::__exception_ptr::exception_ptr::*)()()
// const

_func_void * __thiscall
std::__exception_ptr::exception_ptr::operator_cast_to_function_pointer(exception_ptr *this)

{
  int *in_r1;
  
  if (*in_r1 != 0) {
    *(undefined4 *)(this + 4) = 0;
    *(undefined4 *)this = 0x1d1c5;
    return (_func_void *)this;
  }
  *(undefined4 *)this = 0;
  *(undefined4 *)(this + 4) = 0;
  return (_func_void *)this;
}



// std::__exception_ptr::exception_ptr::__cxa_exception_type() const

undefined4 __thiscall std::__exception_ptr::exception_ptr::__cxa_exception_type(exception_ptr *this)

{
  return *(undefined4 *)(*(int *)this + -0x78);
}



// std::__exception_ptr::TEMPNAMEPLACEHOLDERVALUE(std::__exception_ptr::exception_ptr const&,
// std::__exception_ptr::exception_ptr const&)

bool std::__exception_ptr::operator==(exception_ptr *param_1,exception_ptr *param_2)

{
  return *(int *)param_1 == *(int *)param_2;
}



// std::__exception_ptr::TEMPNAMEPLACEHOLDERVALUE(std::__exception_ptr::exception_ptr const&,
// std::__exception_ptr::exception_ptr const&)

byte std::__exception_ptr::operator!=(exception_ptr *param_1,exception_ptr *param_2)

{
  byte bVar1;
  
  bVar1 = operator==(param_1,param_2);
  return bVar1 ^ 1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked
// std::current_exception()

void std::current_exception(void)

{
  exception_ptr *in_r0;
  int *piVar1;
  undefined4 *puVar2;
  
  piVar1 = (int *)__cxa_get_globals();
  puVar2 = (undefined4 *)*piVar1;
  if ((((((puVar2 != (undefined4 *)0x0) && (*(char *)(puVar2 + 8) == 'G')) &&
        (*(char *)((int)puVar2 + 0x21) == 'N')) &&
       ((*(char *)((int)puVar2 + 0x22) == 'U' && (*(char *)((int)puVar2 + 0x23) == 'C')))) &&
      ((*(char *)(puVar2 + 9) == 'C' &&
       ((*(char *)((int)puVar2 + 0x25) == '+' && (*(char *)((int)puVar2 + 0x26) == '+')))))) &&
     (*(byte *)((int)puVar2 + 0x27) < 2)) {
    if (*(byte *)((int)puVar2 + 0x27) == 1) {
      puVar2 = (undefined4 *)*puVar2;
    }
    else {
      puVar2 = puVar2 + 0x1e;
    }
    __exception_ptr::exception_ptr::exception_ptr(in_r0,puVar2);
    return;
  }
  __exception_ptr::exception_ptr::exception_ptr(in_r0);
  return;
}



// std::rethrow_exception(std::__exception_ptr::exception_ptr)

void std::rethrow_exception(exception_ptr *param_1)

{
  bool bVar1;
  int iVar2;
  int iVar3;
  int *piVar4;
  int *piVar5;
  
  iVar3 = __exception_ptr::exception_ptr::_M_get(param_1);
  piVar4 = (int *)__cxa_allocate_dependent_exception();
  piVar5 = (int *)(iVar3 + -0x80);
  *piVar4 = iVar3;
  DataMemoryBarrier(0x1f);
  do {
    ExclusiveAccess(piVar5);
    bVar1 = (bool)hasExclusiveAccess(piVar5);
  } while (!bVar1);
  *piVar5 = *piVar5 + 1;
  iVar2 = __cxxabiv1::__unexpected_handler;
  iVar3 = __cxxabiv1::__terminate_handler;
  DataMemoryBarrier(0x1f);
  *(undefined1 *)(piVar4 + 8) = 0x47;
  piVar4[1] = iVar2;
  piVar4[2] = iVar3;
  *(undefined1 *)((int)piVar4 + 0x21) = 0x4e;
  *(undefined1 *)((int)piVar4 + 0x22) = 0x55;
  *(undefined1 *)((int)piVar4 + 0x27) = 1;
  piVar4[10] = (int)&LAB_0001d1c8_1;
  *(undefined1 *)((int)piVar4 + 0x23) = 0x43;
  *(undefined1 *)(piVar4 + 9) = 0x43;
  *(undefined1 *)((int)piVar4 + 0x25) = 0x2b;
  *(undefined1 *)((int)piVar4 + 0x26) = 0x2b;
  ___Unwind_RaiseException(piVar4 + 8);
  __cxa_begin_catch(piVar4 + 8);
                    // WARNING: Subroutine does not return
  terminate();
}



// std::bad_cast::what() const

char * std::bad_cast::what(void)

{
  return "std::bad_cast";
}



// std::bad_cast::~bad_cast()

bad_cast * __thiscall std::bad_cast::~bad_cast(bad_cast *this)

{
  *(undefined ***)this = &PTR__bad_cast_1_0002a9e0;
  exception::~exception((exception *)this);
  return this;
}



// std::bad_cast::~bad_cast()

bad_cast * __thiscall std::bad_cast::~bad_cast(bad_cast *this)

{
  ~bad_cast(this);
  operator_delete(this);
  return this;
}



exception * FUN_0001d480(exception *param_1)

{
  bool bVar1;
  undefined *puVar2;
  int *piVar3;
  int iVar4;
  
  puVar2 = (undefined *)(*(int *)(param_1 + 4) + -0xc);
  *(undefined ***)param_1 = &PTR_FUN_0001d480_1_0002aad8;
  if (puVar2 != &DAT_0002ff54) {
    piVar3 = (int *)(*(int *)(param_1 + 4) + -4);
    DataMemoryBarrier(0x1f);
    do {
      ExclusiveAccess(piVar3);
      iVar4 = *piVar3;
      bVar1 = (bool)hasExclusiveAccess(piVar3);
    } while (!bVar1);
    *piVar3 = iVar4 + -1;
    DataMemoryBarrier(0x1f);
    if (iVar4 < 1) {
      operator_delete(puVar2);
    }
  }
  std::exception::~exception(param_1);
  return param_1;
}



void * FUN_0001d4d8(void *param_1)

{
  FUN_0001d480();
  operator_delete(param_1);
  return param_1;
}



undefined4 * FUN_0001d4ec(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d4ec_1_0002aa50;
  FUN_0001d480();
  return param_1;
}



exception * FUN_0001d5cc(exception *param_1)

{
  bool bVar1;
  undefined *puVar2;
  int *piVar3;
  int iVar4;
  
  puVar2 = (undefined *)(*(int *)(param_1 + 4) + -0xc);
  *(undefined ***)param_1 = &PTR_FUN_0001d5cc_1_0002aa08;
  if (puVar2 != &DAT_0002ff54) {
    piVar3 = (int *)(*(int *)(param_1 + 4) + -4);
    DataMemoryBarrier(0x1f);
    do {
      ExclusiveAccess(piVar3);
      iVar4 = *piVar3;
      bVar1 = (bool)hasExclusiveAccess(piVar3);
    } while (!bVar1);
    *piVar3 = iVar4 + -1;
    DataMemoryBarrier(0x1f);
    if (iVar4 < 1) {
      operator_delete(puVar2);
    }
  }
  std::exception::~exception(param_1);
  return param_1;
}



void * FUN_0001d624(void *param_1)

{
  FUN_0001d5cc();
  operator_delete(param_1);
  return param_1;
}



undefined4 * FUN_0001d638(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d638_1_0002ab20;
  FUN_0001d5cc();
  return param_1;
}



undefined4 * FUN_0001d6e0(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d480_1_0002aad8;
  FUN_0001c700(param_1 + 1);
  return param_1;
}



undefined4 * FUN_0001d704(undefined4 *param_1)

{
  FUN_0001d6e0();
  *param_1 = &PTR_FUN_0001d4ec_1_0002aa50;
  return param_1;
}



undefined4 * FUN_0001d71c(undefined4 *param_1)

{
  FUN_0001d6e0();
  *param_1 = &PTR_LAB_0001d524_1_0002aa80;
  return param_1;
}



undefined4 * FUN_0001d734(undefined4 *param_1)

{
  FUN_0001d6e0();
  *param_1 = &PTR_LAB_0001d55c_1_0002ab08;
  return param_1;
}



undefined4 * FUN_0001d74c(undefined4 *param_1)

{
  FUN_0001d6e0();
  *param_1 = &PTR_LAB_0001d594_1_0002aaf0;
  return param_1;
}



undefined4 * FUN_0001d764(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d5cc_1_0002aa08;
  FUN_0001c700(param_1 + 1);
  return param_1;
}



undefined4 * FUN_0001d788(undefined4 *param_1)

{
  FUN_0001d764();
  *param_1 = &PTR_FUN_0001d638_1_0002ab20;
  return param_1;
}



undefined4 * FUN_0001d7a0(undefined4 *param_1)

{
  FUN_0001d764();
  *param_1 = &PTR_LAB_0001d670_1_0002aa20;
  return param_1;
}



undefined4 * FUN_0001d7b8(undefined4 *param_1)

{
  FUN_0001d764();
  *param_1 = &PTR_LAB_0001d6a8_1_0002aa38;
  return param_1;
}



exception * FUN_0001d7d4(exception *param_1)

{
  bool bVar1;
  undefined *puVar2;
  int *piVar3;
  int iVar4;
  
  puVar2 = (undefined *)(*(int *)(param_1 + 4) + -0xc);
  *(undefined ***)param_1 = &PTR_FUN_0001d7d4_1_0002ab48;
  if (puVar2 != &DAT_0002ff54) {
    piVar3 = (int *)(*(int *)(param_1 + 4) + -4);
    DataMemoryBarrier(0x1f);
    do {
      ExclusiveAccess(piVar3);
      iVar4 = *piVar3;
      bVar1 = (bool)hasExclusiveAccess(piVar3);
    } while (!bVar1);
    *piVar3 = iVar4 + -1;
    DataMemoryBarrier(0x1f);
    if (iVar4 < 1) {
      operator_delete(puVar2);
    }
  }
  std::exception::~exception(param_1);
  return param_1;
}



void * FUN_0001d82c(void *param_1)

{
  FUN_0001d7d4();
  operator_delete(param_1);
  return param_1;
}



undefined4 * FUN_0001d840(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d7d4_1_0002ab48;
  FUN_0001c700(param_1 + 1);
  return param_1;
}



pthread_cond_t * FUN_0001d87c(pthread_cond_t *param_1)

{
  pthread_cond_destroy(param_1);
  return param_1;
}



void FUN_0001d888(pthread_cond_t *param_1,undefined4 *param_2)

{
  int iVar1;
  pthread_cond_t *ppVar2;
  undefined4 *puVar3;
  code *UNRECOVERED_JUMPTABLE_00;
  
  iVar1 = pthread_cond_wait(param_1,(pthread_mutex_t *)*param_2);
  if (iVar1 == 0) {
    return;
  }
  UNRECOVERED_JUMPTABLE_00 = (code *)0x1d899;
  ppVar2 = (pthread_cond_t *)FUN_0001ae78();
  iVar1 = pthread_cond_signal(ppVar2);
  if (iVar1 == 0) {
                    // WARNING: Could not recover jumptable at 0x0001d8a0. Too many branches
                    // WARNING: Treating indirect jump as call
    (*UNRECOVERED_JUMPTABLE_00)();
    return;
  }
  UNRECOVERED_JUMPTABLE_00 = (code *)0x1d8a7;
  ppVar2 = (pthread_cond_t *)FUN_0001ae78();
  iVar1 = pthread_cond_broadcast(ppVar2);
  if (iVar1 == 0) {
                    // WARNING: Could not recover jumptable at 0x0001d8b0. Too many branches
                    // WARNING: Treating indirect jump as call
    (*UNRECOVERED_JUMPTABLE_00)();
    return;
  }
  puVar3 = (undefined4 *)FUN_0001ae78();
  *puVar3 = 0;
  puVar3[1] = 0;
  return;
}



pthread_cond_t * FUN_0001d8c0(pthread_cond_t *param_1)

{
  pthread_cond_destroy(param_1);
  return param_1;
}



undefined4 * FUN_0001d8cc(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d8cc_1_0002ab78;
  FUN_0001d5cc();
  return param_1;
}



undefined4 * FUN_0001d904(undefined4 *param_1,undefined4 param_2)

{
  bool bVar1;
  int *piVar2;
  int iVar3;
  undefined1 auStack_1c [8];
  int local_14;
  
  FUN_0001cd0c(&local_14,"regex_error",auStack_1c);
  FUN_0001d764(param_1,&local_14);
  if ((undefined *)(local_14 + -0xc) != &DAT_0002ff54) {
    piVar2 = (int *)(local_14 + -4);
    DataMemoryBarrier(0x1f);
    do {
      ExclusiveAccess(piVar2);
      iVar3 = *piVar2;
      bVar1 = (bool)hasExclusiveAccess(piVar2);
    } while (!bVar1);
    *piVar2 = iVar3 + -1;
    DataMemoryBarrier(0x1f);
    if (iVar3 < 1) {
      operator_delete((undefined *)(local_14 + -0xc));
    }
  }
  param_1[2] = param_2;
  *param_1 = &PTR_FUN_0001d8cc_1_0002ab78;
  return param_1;
}



void FUN_0001d998(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d998_1_0002abb8;
  return;
}



bool FUN_0001d9b0(int *param_1,undefined4 param_2,int *param_3)

{
  int local_18;
  int local_14;
  
  (**(code **)(*param_1 + 0x10))(&local_18,param_1,param_2);
  if (local_14 == param_3[1]) {
    return local_18 == *param_3;
  }
  return false;
}



undefined4 FUN_0001da98(undefined4 param_1,undefined4 param_2,int param_3)

{
  char *pcVar1;
  undefined1 auStack_c [4];
  
  pcVar1 = strerror(param_3);
  FUN_0001cd0c(param_1,pcVar1,auStack_c);
  return param_1;
}



undefined4 FUN_0001dab4(undefined4 param_1,undefined4 param_2,int param_3)

{
  char *pcVar1;
  undefined1 auStack_c [4];
  
  pcVar1 = strerror(param_3);
  FUN_0001cd0c(param_1,pcVar1,auStack_c);
  return param_1;
}



void FUN_0001dad0(undefined4 *param_1)

{
  *param_1 = &PTR_FUN_0001d998_1_0002abb8;
  return;
}



undefined4 * FUN_0001daec(void)

{
  return &DAT_0002ff68;
}



// __gnu_cxx::__verbose_terminate_handler()

void __gnu_cxx::__verbose_terminate_handler(void)

{
  int iVar1;
  char *__s;
  char *__s_00;
  int local_1c [2];
  
  if (DAT_0002ff6c != '\0') {
    fwrite("terminate called recursively\n",1,0x1d,(FILE *)0x301d4);
                    // WARNING: Subroutine does not return
    abort();
  }
  DAT_0002ff6c = 1;
  iVar1 = __cxa_current_exception_type();
  if (iVar1 != 0) {
    __s = *(char **)(iVar1 + 4);
    if (*__s == '*') {
      __s = __s + 1;
    }
    local_1c[0] = -1;
    __s_00 = (char *)__cxa_demangle(__s,0,0,local_1c);
    fwrite("terminate called after throwing an instance of \'",1,0x30,(FILE *)0x301d4);
    if (local_1c[0] == 0) goto LAB_0001db86;
    fputs(__s,(FILE *)0x301d4);
    do {
      fwrite(&DAT_00027430,1,2,(FILE *)0x301d4);
      if (local_1c[0] == 0) {
        free(__s_00);
      }
      __cxa_rethrow();
LAB_0001db86:
      fputs(__s_00,(FILE *)0x301d4);
    } while( true );
  }
  fwrite("terminate called without an active exception\n",1,0x2d,(FILE *)0x301d4);
                    // WARNING: Subroutine does not return
  abort();
}



// __cxxabiv1::__pbase_type_info::~__pbase_type_info()

__pbase_type_info * __thiscall
__cxxabiv1::__pbase_type_info::~__pbase_type_info(__pbase_type_info *this)

{
  *(undefined ***)this = &PTR____pbase_type_info_1_0002ac58;
  FUN_0001cea4();
  return this;
}



// __cxxabiv1::__pbase_type_info::~__pbase_type_info()

__pbase_type_info * __thiscall
__cxxabiv1::__pbase_type_info::~__pbase_type_info(__pbase_type_info *this)

{
  ~__pbase_type_info(this);
  operator_delete(this);
  return this;
}



// __cxxabiv1::__pbase_type_info::__do_catch(std::type_info const*, void**, unsigned int) const

int __thiscall
__cxxabiv1::__pbase_type_info::__do_catch
          (__pbase_type_info *this,type_info *param_1,void **param_2,uint param_3)

{
  int iVar1;
  int iVar2;
  
  iVar1 = FUN_0001ced8();
  if (iVar1 == 0) {
    if (param_1 == (type_info *)0x0) {
                    // WARNING: Subroutine does not return
      __cxa_bad_typeid(*(undefined4 *)(*(int *)this + -4));
    }
    iVar2 = FUN_0001ced8(*(undefined4 *)(*(int *)this + -4),*(undefined4 *)(*(int *)param_1 + -4));
    if (((iVar2 != 0) && ((int)(param_3 << 0x1f) < 0)) &&
       ((*(uint *)(param_1 + 8) & ~*(uint *)(this + 8)) == 0)) {
      if (-1 < (int)(*(uint *)(this + 8) << 0x1f)) {
        param_3 = param_3 & 0xfffffffe;
      }
      iVar1 = (**(code **)(*(int *)this + 0x18))(this,param_1,param_2,param_3);
    }
  }
  return iVar1;
}



void __cxa_bad_cast(void)

{
  undefined4 *puVar1;
  undefined4 in_r3;
  
  puVar1 = (undefined4 *)__cxa_allocate_exception(4);
  *puVar1 = &PTR__bad_cast_1_0002a9e0;
                    // WARNING: Subroutine does not return
  __cxa_throw(puVar1,&std::bad_cast::typeinfo,0x1d449,&PTR__bad_cast_1_0002a9e0,in_r3);
}



void __cxa_bad_typeid(void)

{
  undefined4 *puVar1;
  undefined4 in_r3;
  
  puVar1 = (undefined4 *)__cxa_allocate_exception(4);
  *puVar1 = &PTR__bad_typeid_1_0002a8f8;
                    // WARNING: Subroutine does not return
  __cxa_throw(puVar1,&std::bad_typeid::typeinfo,0x1cf19,&PTR__bad_typeid_1_0002a8f8,in_r3);
}



// WARNING: Function: __gnu_thumb1_case_sqi replaced with injection: switchS8_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001dd3a)
// WARNING: Removing unreachable block (ram,0x0001dd3a)

undefined4 * FUN_0001dd2c(int param_1,undefined4 param_2,int param_3,int param_4)

{
  undefined4 *puVar1;
  int iVar2;
  
  switch(param_2) {
  case 1:
  case 2:
  case 3:
  case 4:
  case 0xb:
  case 0x21:
  case 0x2b:
  case 0x2d:
  case 0x35:
  case 0x36:
  case 0x37:
  case 0x38:
  case 0x39:
  case 0x3b:
  case 0x3c:
  case 0x3e:
  case 0x4a:
  case 0x4b:
    if (param_3 == 0) {
      return (undefined4 *)0x0;
    }
  case 0x2a:
  case 0x30:
    if (param_4 == 0) {
LAB_0001dd38:
      return (undefined4 *)0x0;
    }
    iVar2 = *(int *)(param_1 + 0x14);
    if (*(int *)(param_1 + 0x18) <= iVar2) {
      return (undefined4 *)0x0;
    }
    break;
  default:
    goto LAB_0001dd38;
  case 9:
  case 10:
  case 0xc:
  case 0xd:
  case 0xe:
  case 0xf:
  case 0x10:
  case 0x11:
  case 0x12:
  case 0x13:
  case 0x14:
  case 0x15:
  case 0x16:
  case 0x17:
  case 0x22:
  case 0x23:
  case 0x24:
  case 0x25:
  case 0x26:
  case 0x28:
  case 0x33:
  case 0x34:
  case 0x3a:
  case 0x3d:
  case 0x41:
  case 0x42:
  case 0x43:
  case 0x47:
  case 0x48:
  case 0x49:
    if (param_3 == 0) {
      return (undefined4 *)0x0;
    }
  case 0x19:
  case 0x1a:
  case 0x1b:
  case 0x1c:
  case 0x1d:
  case 0x1e:
  case 0x1f:
  case 0x20:
  case 0x29:
  case 0x2e:
  case 0x2f:
    iVar2 = *(int *)(param_1 + 0x14);
    if (*(int *)(param_1 + 0x18) <= iVar2) {
      return (undefined4 *)0x0;
    }
  }
  puVar1 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar2 * 0xc);
  *(int *)(param_1 + 0x14) = iVar2 + 1;
  if (puVar1 != (undefined4 *)0x0) {
    *puVar1 = param_2;
    puVar1[1] = param_3;
    puVar1[2] = param_4;
    return puVar1;
  }
  return (undefined4 *)0x0;
}



undefined4 * FUN_0001ddc8(int param_1,int param_2,int param_3)

{
  int iVar1;
  undefined4 *puVar2;
  
  iVar1 = *(int *)(param_1 + 0x14);
  if (iVar1 < *(int *)(param_1 + 0x18)) {
    puVar2 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar1 * 0xc);
    *(int *)(param_1 + 0x14) = iVar1 + 1;
    if (((puVar2 != (undefined4 *)0x0) && (param_2 != 0)) && (param_3 != 0)) {
      *puVar2 = 0;
      puVar2[1] = param_2;
      puVar2[2] = param_3;
      return puVar2;
    }
  }
  return (undefined4 *)0x0;
}



int * FUN_0001de00(int param_1,int *param_2,int param_3)

{
  char cVar1;
  int iVar2;
  undefined4 uVar3;
  char *pcVar4;
  int *piVar5;
  
  pcVar4 = *(char **)(param_1 + 0xc);
  cVar1 = *pcVar4;
  piVar5 = param_2;
  do {
    if ((cVar1 == 'V') || (cVar1 == 'r')) {
      *(char **)(param_1 + 0xc) = pcVar4 + 1;
      if (cVar1 == 'r') {
        uVar3 = 0x19;
        if (param_3 != 0) {
          uVar3 = 0x1c;
        }
      }
      else {
        if (cVar1 != 'V') goto LAB_0001de20;
        uVar3 = 0x1a;
        if (param_3 != 0) {
          uVar3 = 0x1d;
        }
      }
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + 9;
      iVar2 = FUN_0001dd2c(param_1,uVar3,0,0);
      *piVar5 = iVar2;
    }
    else {
      if (cVar1 != 'K') {
        if (param_3 != 0) {
          return piVar5;
        }
        if (cVar1 != 'F') {
          return piVar5;
        }
        if (piVar5 == param_2) {
          return piVar5;
        }
        do {
          param_2 = (int *)*param_2;
          iVar2 = *param_2;
          if (iVar2 == 0x1a) {
            *param_2 = 0x1d;
          }
          else if (iVar2 == 0x1b) {
            *param_2 = 0x1e;
          }
          else if (iVar2 == 0x19) {
            *param_2 = 0x1c;
          }
          param_2 = param_2 + 1;
        } while (piVar5 != param_2);
        return piVar5;
      }
      *(char **)(param_1 + 0xc) = pcVar4 + 1;
LAB_0001de20:
      uVar3 = 0x1b;
      if (param_3 != 0) {
        uVar3 = 0x1e;
      }
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + 6;
      iVar2 = FUN_0001dd2c(param_1,uVar3,0,0);
      *piVar5 = iVar2;
    }
    if (iVar2 == 0) {
      return (int *)0x0;
    }
    pcVar4 = *(char **)(param_1 + 0xc);
    piVar5 = (int *)(iVar2 + 4);
    cVar1 = *pcVar4;
  } while( true );
}



undefined4 FUN_0001ded8(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  char cVar1;
  undefined4 uVar2;
  
  cVar1 = **(char **)(param_1 + 0xc);
  if (cVar1 == 'O') {
    if (cVar1 != 'R') {
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + 3;
      uVar2 = 0x20;
      goto LAB_0001defa;
    }
  }
  else if (cVar1 != 'R') {
    return param_2;
  }
  *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + 2;
  uVar2 = 0x1f;
LAB_0001defa:
  *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
  uVar2 = FUN_0001dd2c(param_1,uVar2,param_2,0,param_4);
  return uVar2;
}



void FUN_0001df1c(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  char *pcVar2;
  char *pcVar3;
  char cVar4;
  
  pcVar2 = *(char **)(param_1 + 0xc);
  cVar4 = *pcVar2;
  pcVar3 = pcVar2;
  if (cVar4 == '.') {
    if (((byte)(pcVar2[1] + 0x9fU) < 0x1a) || (pcVar2[1] == '_')) {
      pcVar3 = pcVar2 + 2;
      cVar4 = pcVar2[2];
      while (((byte)(cVar4 + 0x9fU) < 0x1a || (cVar4 == '_'))) {
        pcVar3 = pcVar3 + 1;
        cVar4 = *pcVar3;
      }
    }
    else {
      cVar4 = '.';
    }
  }
  while (cVar4 == '.') {
    while( true ) {
      if (9 < (byte)(pcVar3[1] - 0x30U)) goto LAB_0001df62;
      cVar4 = pcVar3[2];
      pcVar3 = pcVar3 + 2;
      if (9 < (byte)(cVar4 - 0x30U)) break;
      do {
        pcVar3 = pcVar3 + 1;
      } while ((byte)(*pcVar3 - 0x30U) < 10);
      if (*pcVar3 != '.') goto LAB_0001df62;
    }
  }
LAB_0001df62:
  *(char **)(param_1 + 0xc) = pcVar3;
  uVar1 = FUN_0001ddc8(param_1,pcVar2,(int)pcVar3 - (int)pcVar2,pcVar3,param_4);
  FUN_0001dd2c(param_1,0x4b,param_2,uVar1);
  return;
}



undefined4 * FUN_0001dfc4(int param_1,int param_2)

{
  uint uVar1;
  undefined4 uVar2;
  int iVar3;
  undefined4 *puVar4;
  byte *pbVar5;
  uint uVar6;
  undefined4 *puVar7;
  char *pcVar8;
  uint uVar9;
  int iVar10;
  uint uVar11;
  int iVar12;
  int iVar13;
  
  pcVar8 = *(char **)(param_1 + 0xc);
  if (*pcVar8 != 'S') {
    return (undefined4 *)0x0;
  }
  *(char **)(param_1 + 0xc) = pcVar8 + 1;
  if (pcVar8[1] == '\0') {
    uVar9 = 0;
LAB_0001dfea:
    uVar11 = *(uint *)(param_1 + 8) >> 3 & 1;
    if ((param_2 != 0) && (uVar11 != 1)) {
      uVar11 = (uint)((byte)(**(char **)(param_1 + 0xc) + 0xbdU) < 2);
    }
    pbVar5 = &DAT_00029bf0;
    while (*pbVar5 != uVar9) {
      pbVar5 = pbVar5 + 0x1c;
      if (pbVar5 == &UNK_00029cb4) {
        return (undefined4 *)0x0;
      }
    }
    iVar13 = *(int *)(pbVar5 + 0x14);
    if (iVar13 == 0) {
      iVar12 = *(int *)(param_1 + 0x18);
      iVar10 = *(int *)(param_1 + 0x14);
    }
    else {
      uVar2 = *(undefined4 *)(pbVar5 + 0x18);
      iVar10 = *(int *)(param_1 + 0x14);
      iVar12 = *(int *)(param_1 + 0x18);
      puVar7 = (undefined4 *)0x0;
      if (iVar10 < iVar12) {
        iVar3 = iVar10 * 0xc;
        iVar10 = iVar10 + 1;
        puVar4 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar3);
        *(int *)(param_1 + 0x14) = iVar10;
        if (puVar4 != (undefined4 *)0x0) {
          puVar4[1] = iVar13;
          *puVar4 = 0x18;
          puVar4[2] = uVar2;
          puVar7 = puVar4;
        }
      }
      *(undefined4 **)(param_1 + 0x2c) = puVar7;
    }
    if (uVar11 == 0) {
      uVar2 = *(undefined4 *)(pbVar5 + 4);
      iVar13 = *(int *)(pbVar5 + 8);
    }
    else {
      uVar2 = *(undefined4 *)(pbVar5 + 0xc);
      iVar13 = *(int *)(pbVar5 + 0x10);
    }
    *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + iVar13;
    if (iVar12 <= iVar10) {
      return (undefined4 *)0x0;
    }
    puVar7 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar10 * 0xc);
    *(int *)(param_1 + 0x14) = iVar10 + 1;
    if (puVar7 != (undefined4 *)0x0) {
      *puVar7 = 0x18;
      puVar7[1] = uVar2;
      puVar7[2] = iVar13;
      return puVar7;
    }
    return (undefined4 *)0x0;
  }
  *(char **)(param_1 + 0xc) = pcVar8 + 2;
  uVar9 = (uint)(byte)pcVar8[1];
  uVar11 = uVar9 - 0x30;
  if (((uVar11 & 0xff) < 10) || (uVar9 == 0x5f)) {
    if (uVar9 == 0x5f) {
      uVar1 = 0;
      goto LAB_0001e084;
    }
  }
  else if (0x19 < uVar9 - 0x41) goto LAB_0001dfea;
  uVar6 = 0;
  do {
    if ((uVar11 & 0xff) < 10) {
      uVar1 = (uVar6 * 0x24 + uVar9) - 0x30;
    }
    else {
      if (0x19 < (uVar9 - 0x41 & 0xff)) {
        return (undefined4 *)0x0;
      }
      uVar1 = (uVar6 * 0x24 + uVar9) - 0x37;
    }
    if (uVar1 < uVar6) {
      return (undefined4 *)0x0;
    }
    pbVar5 = *(byte **)(param_1 + 0xc);
    if (*pbVar5 == 0) {
      uVar9 = 0;
    }
    else {
      *(byte **)(param_1 + 0xc) = pbVar5 + 1;
      uVar9 = (uint)*pbVar5;
      if (uVar9 == 0x5f) break;
    }
    uVar11 = uVar9 - 0x30;
    uVar6 = uVar1;
  } while( true );
  uVar1 = uVar1 + 1;
LAB_0001e084:
  if (*(uint *)(param_1 + 0x20) <= uVar1) {
    return (undefined4 *)0x0;
  }
  *(int *)(param_1 + 0x28) = *(int *)(param_1 + 0x28) + 1;
  return *(undefined4 **)(uVar1 * 4 + *(int *)(param_1 + 0x1c));
}



int FUN_0001e190(undefined4 *param_1)

{
  int iVar1;
  uint uVar2;
  byte *pbVar3;
  bool bVar4;
  
  pbVar3 = (byte *)*param_1;
  uVar2 = (uint)*pbVar3;
  bVar4 = uVar2 == 0x6e;
  if (bVar4) {
    *param_1 = pbVar3 + 1;
    uVar2 = (uint)pbVar3[1];
  }
  if ((uVar2 - 0x30 & 0xff) < 10) {
    pbVar3 = (byte *)*param_1;
    iVar1 = 0;
    do {
      pbVar3 = pbVar3 + 1;
      iVar1 = iVar1 * 10 + uVar2;
      *param_1 = pbVar3;
      uVar2 = (uint)*pbVar3;
      iVar1 = iVar1 + -0x30;
    } while ((uVar2 - 0x30 & 0xff) < 10);
  }
  else {
    iVar1 = 0;
  }
  if (bVar4) {
    iVar1 = -iVar1;
  }
  return iVar1;
}



undefined4 * FUN_0001e1e4(int param_1)

{
  undefined4 uVar1;
  int iVar2;
  undefined4 *puVar3;
  
  iVar2 = *(int *)(param_1 + 0x14);
  if (iVar2 < *(int *)(param_1 + 0x18)) {
    puVar3 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar2 * 0xc);
    *(int *)(param_1 + 0x14) = iVar2 + 1;
    if (puVar3 != (undefined4 *)0x0) {
      *puVar3 = 0x40;
      uVar1 = FUN_0001e190(param_1 + 0xc);
      puVar3[1] = uVar1;
      return puVar3;
    }
  }
  return (undefined4 *)0x0;
}



int FUN_0001e214(int param_1)

{
  int iVar1;
  char *pcVar2;
  
  pcVar2 = *(char **)(param_1 + 0xc);
  if (*pcVar2 == '_') {
    iVar1 = 0;
LAB_0001e23c:
    *(char **)(param_1 + 0xc) = pcVar2 + 1;
  }
  else {
    if (*pcVar2 != 'n') {
      iVar1 = FUN_0001e190(param_1 + 0xc);
      pcVar2 = *(char **)(param_1 + 0xc);
      iVar1 = iVar1 + 1;
      if (*pcVar2 == '_') goto LAB_0001e23c;
    }
    iVar1 = -1;
  }
  return iVar1;
}



undefined4 * FUN_0001e244(int param_1)

{
  int iVar1;
  int iVar2;
  undefined4 *puVar3;
  
  if (**(char **)(param_1 + 0xc) == 'T') {
    *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
    iVar1 = FUN_0001e214();
    if (-1 < iVar1) {
      iVar2 = *(int *)(param_1 + 0x14);
      *(int *)(param_1 + 0x28) = *(int *)(param_1 + 0x28) + 1;
      if (iVar2 < *(int *)(param_1 + 0x18)) {
        puVar3 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar2 * 0xc);
        *(int *)(param_1 + 0x14) = iVar2 + 1;
        if (puVar3 == (undefined4 *)0x0) {
          return (undefined4 *)0x0;
        }
        *puVar3 = 5;
        puVar3[1] = iVar1;
        return puVar3;
      }
    }
  }
  return (undefined4 *)0x0;
}



uint FUN_0001e28c(int param_1)

{
  uint uVar1;
  
  uVar1 = 1;
  if (**(char **)(param_1 + 0xc) == '_') {
    *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
    uVar1 = FUN_0001e190(param_1 + 0xc);
    uVar1 = ~uVar1 >> 0x1f;
  }
  return uVar1;
}



undefined4 FUN_0001e2ac(int param_1)

{
  char cVar1;
  int iVar2;
  int iVar3;
  undefined4 uVar4;
  char *pcVar5;
  void *__s1;
  
  iVar2 = FUN_0001e190(param_1 + 0xc);
  if (iVar2 < 1) {
    uVar4 = 0;
  }
  else {
    __s1 = *(void **)(param_1 + 0xc);
    if (*(int *)(param_1 + 4) - (int)__s1 < iVar2) {
      uVar4 = 0;
    }
    else {
      pcVar5 = (char *)((int)__s1 + iVar2);
      *(char **)(param_1 + 0xc) = pcVar5;
      if ((*(int *)(param_1 + 8) << 0x1d < 0) && (*pcVar5 == '$')) {
        *(char **)(param_1 + 0xc) = pcVar5 + 1;
      }
      if ((((iVar2 < 10) || (iVar3 = memcmp(__s1,"_GLOBAL_",8), iVar3 != 0)) ||
          ((cVar1 = *(char *)((int)__s1 + 8), cVar1 != '.' && ((cVar1 != '_' && (cVar1 != '$'))))))
         || (*(char *)((int)__s1 + 9) != 'N')) {
        uVar4 = FUN_0001ddc8(param_1,__s1,iVar2);
      }
      else {
        *(int *)(param_1 + 0x30) = (*(int *)(param_1 + 0x30) + 0x16) - iVar2;
        uVar4 = FUN_0001ddc8(param_1,"(anonymous namespace)",0x15);
      }
    }
    *(undefined4 *)(param_1 + 0x2c) = uVar4;
  }
  return uVar4;
}



undefined4 FUN_0001e338(int param_1,uint param_2)

{
  byte *pbVar1;
  
  if (param_2 == 0) {
    pbVar1 = *(byte **)(param_1 + 0xc);
    if (*pbVar1 == 0) {
      return 0;
    }
    *(byte **)(param_1 + 0xc) = pbVar1 + 1;
    param_2 = (uint)*pbVar1;
  }
  if (param_2 == 0x68) {
    FUN_0001e190(param_1 + 0xc);
LAB_0001e380:
    if (**(char **)(param_1 + 0xc) == '_') {
      *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
      return 1;
    }
    return 0;
  }
  if (param_2 == 0x76) {
    FUN_0001e190(param_1 + 0xc);
    if (**(char **)(param_1 + 0xc) == '_') {
      *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
      FUN_0001e190(param_1 + 0xc);
      goto LAB_0001e380;
    }
  }
  return 0;
}



int FUN_0001e394(int param_1,int *param_2)

{
  int iVar1;
  int *piVar2;
  
  if (*(int *)(param_1 + 0x110) == 0) {
    *(undefined4 *)(param_1 + 0x118) = 1;
    iVar1 = 0;
  }
  else {
    iVar1 = *param_2;
    piVar2 = *(int **)(*(int *)(*(int *)(param_1 + 0x110) + 4) + 8);
    if ((piVar2 == (int *)0x0) || (*piVar2 != 0x2f)) {
LAB_0001e3c8:
      iVar1 = 0;
    }
    else {
      if (iVar1 < 1) {
        if (iVar1 != 0) {
          return 0;
        }
      }
      else {
        do {
          piVar2 = (int *)piVar2[2];
          iVar1 = iVar1 + -1;
          if ((piVar2 == (int *)0x0) || (*piVar2 != 0x2f)) goto LAB_0001e3c8;
        } while (iVar1 != 0);
      }
      iVar1 = piVar2[1];
    }
  }
  return iVar1;
}



// WARNING: Function: __gnu_thumb1_case_sqi replaced with injection: switchS8_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001e408)
// WARNING: Removing unreachable block (ram,0x0001e408)

int * FUN_0001e3e4(undefined4 param_1,undefined4 *param_2)

{
  int *piVar1;
  
  if (param_2 != (undefined4 *)0x0) {
    do {
      switch(*param_2) {
      case 0:
      case 6:
      case 0x18:
      case 0x27:
      case 0x31:
      case 0x3f:
      case 0x44:
      case 0x46:
      case 0x49:
      case 0x4a:
        goto LAB_0001e406;
      case 5:
        piVar1 = (int *)FUN_0001e394(param_1,param_2 + 1);
        if ((piVar1 != (int *)0x0) && (*piVar1 == 0x2f)) {
          return piVar1;
        }
        goto LAB_0001e406;
      case 7:
      case 8:
      case 0x32:
        goto switchD_0001e408_caseD_7;
      }
      piVar1 = (int *)FUN_0001e3e4(param_1,param_2[1]);
      if (piVar1 != (int *)0x0) {
        return piVar1;
      }
switchD_0001e408_caseD_7:
      param_2 = (undefined4 *)param_2[2];
    } while (param_2 != (undefined4 *)0x0);
  }
LAB_0001e406:
  return (int *)0x0;
}



void FUN_0001e46c(void *param_1,size_t param_2,int *param_3)

{
  void *pvVar1;
  uint uVar2;
  size_t __size;
  
  __size = param_3[2];
  uVar2 = param_3[1] + 1 + param_2;
  if (__size < uVar2) {
    if (param_3[3] != 0) {
      return;
    }
    if ((__size != 0) || (__size = 2, 2 < uVar2)) {
      do {
        __size = __size * 2;
      } while (__size < uVar2);
    }
    pvVar1 = realloc((void *)*param_3,__size);
    if (pvVar1 == (void *)0x0) {
      free((void *)*param_3);
      *param_3 = 0;
      param_3[1] = 0;
      param_3[2] = 0;
      param_3[3] = 1;
      return;
    }
    *param_3 = (int)pvVar1;
    param_3[2] = __size;
  }
  if (param_3[3] == 0) {
    memcpy((void *)(*param_3 + param_3[1]),param_1,param_2);
    *(undefined1 *)(*param_3 + param_2 + param_3[1]) = 0;
    param_3[1] = param_3[1] + param_2;
  }
  return;
}



undefined4 FUN_0001e4f0(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  int *piVar2;
  undefined4 uVar3;
  char *pcVar4;
  char cVar5;
  int iVar6;
  char *pcVar7;
  
  pcVar7 = *(char **)(param_1 + 0xc);
  if (*pcVar7 != 'L') {
    return 0;
  }
  pcVar4 = pcVar7 + 1;
  *(char **)(param_1 + 0xc) = pcVar4;
  cVar5 = pcVar7[1];
  if (cVar5 == 'Z') {
    if (cVar5 == '_') goto LAB_0001e52a;
    cVar5 = 'Z';
  }
  else {
    if (cVar5 != '_') {
      piVar2 = (int *)FUN_0001e97c(param_1);
      if (piVar2 == (int *)0x0) {
        return 0;
      }
      if ((*piVar2 == 0x27) && (*(int *)(piVar2[1] + 0x10) != 0)) {
        *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) - *(int *)(piVar2[1] + 4);
      }
      pcVar4 = *(char **)(param_1 + 0xc);
      uVar1 = 0x3b;
      cVar5 = *pcVar4;
      pcVar7 = pcVar4;
      if (cVar5 == 'n') {
        pcVar7 = pcVar4 + 1;
        *(char **)(param_1 + 0xc) = pcVar7;
        uVar1 = 0x3c;
        cVar5 = pcVar4[1];
      }
      pcVar4 = pcVar7;
      if (cVar5 == 'E') {
        iVar6 = 0;
      }
      else {
        do {
          if (cVar5 == '\0') {
            return 0;
          }
          pcVar4 = pcVar4 + 1;
          *(char **)(param_1 + 0xc) = pcVar4;
          cVar5 = *pcVar4;
        } while (cVar5 != 'E');
        iVar6 = (int)pcVar4 - (int)pcVar7;
      }
      uVar3 = FUN_0001ddc8(param_1,pcVar7,iVar6);
      uVar1 = FUN_0001dd2c(param_1,uVar1,piVar2,uVar3);
      pcVar4 = *(char **)(param_1 + 0xc);
      cVar5 = *pcVar4;
      goto LAB_0001e51c;
    }
LAB_0001e52a:
    pcVar4 = pcVar7 + 2;
    *(char **)(param_1 + 0xc) = pcVar4;
    cVar5 = pcVar7[2];
    uVar1 = 0;
    if (cVar5 != 'Z') goto LAB_0001e51c;
  }
  *(char **)(param_1 + 0xc) = pcVar4 + 1;
  uVar1 = FUN_0001f184(param_1,0,cVar5,pcVar7,param_4);
  pcVar4 = *(char **)(param_1 + 0xc);
  cVar5 = *pcVar4;
LAB_0001e51c:
  if (cVar5 != 'E') {
    return 0;
  }
  *(char **)(param_1 + 0xc) = pcVar4 + 1;
  return uVar1;
}



// WARNING: Function: __gnu_thumb1_case_sqi replaced with injection: switchS8_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001e60e)
// WARNING: Removing unreachable block (ram,0x0001e60e)

int FUN_0001e5b8(int param_1)

{
  char cVar1;
  int iVar2;
  char *pcVar3;
  char *pcVar4;
  int *piVar5;
  undefined4 uVar6;
  int local_14;
  
  pcVar3 = *(char **)(param_1 + 0xc);
  uVar6 = *(undefined4 *)(param_1 + 0x2c);
  if ((byte)(*pcVar3 + 0xb7U) < 2) {
    pcVar4 = pcVar3 + 1;
    *(char **)(param_1 + 0xc) = pcVar4;
    cVar1 = pcVar3[1];
    if (cVar1 == 'E') {
      *(char **)(param_1 + 0xc) = pcVar3 + 2;
      local_14 = FUN_0001dd2c(param_1,0x2f,0,0);
    }
    else {
      local_14 = 0;
      piVar5 = &local_14;
      do {
        switch(cVar1) {
        case 'I':
        case 'J':
          iVar2 = FUN_0001e5b8(param_1);
          break;
        default:
          iVar2 = FUN_0001e97c(param_1);
          break;
        case 'L':
          iVar2 = FUN_0001e4f0(param_1);
          break;
        case 'X':
          *(char **)(param_1 + 0xc) = pcVar4 + 1;
          iVar2 = FUN_0001f9f8(param_1);
          if (**(char **)(param_1 + 0xc) != 'E') goto LAB_0001e634;
          *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
        }
        if (iVar2 == 0) goto LAB_0001e634;
        iVar2 = FUN_0001dd2c(param_1,0x2f,iVar2,0);
        *piVar5 = iVar2;
        if (iVar2 == 0) goto LAB_0001e634;
        pcVar4 = *(char **)(param_1 + 0xc);
        cVar1 = *pcVar4;
        piVar5 = (int *)(iVar2 + 8);
      } while (cVar1 != 'E');
      *(char **)(param_1 + 0xc) = pcVar4 + 1;
      *(undefined4 *)(param_1 + 0x2c) = uVar6;
    }
  }
  else {
LAB_0001e634:
    local_14 = 0;
  }
  return local_14;
}



// WARNING: Function: __gnu_thumb1_case_sqi replaced with injection: switchS8_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001e6a8)
// WARNING: Removing unreachable block (ram,0x0001e6a8)

int FUN_0001e674(int param_1)

{
  int iVar1;
  undefined4 uVar2;
  undefined4 uVar3;
  int iVar4;
  int *piVar5;
  undefined1 *puVar6;
  char *pcVar7;
  int iVar8;
  int iVar9;
  int *piVar10;
  char cVar11;
  int local_24 [2];
  
  puVar6 = *(undefined1 **)(param_1 + 0xc);
  switch(*puVar6) {
  case 0x4c:
  case 0x55:
    iVar1 = FUN_0001f780(param_1);
    return iVar1;
  default:
    iVar1 = FUN_0001f780(param_1);
    if (**(char **)(param_1 + 0xc) != 'I') {
      return iVar1;
    }
    if ((iVar1 != 0) && (iVar8 = *(int *)(param_1 + 0x20), iVar8 < *(int *)(param_1 + 0x24))) {
      *(int *)(iVar8 * 4 + *(int *)(param_1 + 0x1c)) = iVar1;
      *(int *)(param_1 + 0x20) = iVar8 + 1;
      uVar3 = FUN_0001e5b8(param_1);
      iVar1 = FUN_0001dd2c(param_1,4,iVar1,uVar3);
      return iVar1;
    }
    break;
  case 0x4e:
    *(undefined1 **)(param_1 + 0xc) = puVar6 + 1;
    piVar10 = (int *)FUN_0001de00(param_1,local_24,1);
    if (piVar10 != (int *)0x0) {
      iVar8 = FUN_0001ded8(param_1,0);
      pcVar7 = *(char **)(param_1 + 0xc);
      cVar11 = *pcVar7;
      iVar1 = 0;
joined_r0x0001e730:
      if (cVar11 != '\0') {
        if (cVar11 != 'D') goto LAB_0001e738;
        if ((pcVar7[1] & 0xdfU) != 0x54) goto LAB_0001e826;
        iVar4 = FUN_0001e97c(param_1);
joined_r0x0001e87a:
        if (iVar1 != 0) {
          uVar3 = 1;
          goto LAB_0001e834;
        }
        do {
          iVar1 = iVar4;
          if (cVar11 == 'S') {
LAB_0001e860:
            pcVar7 = *(char **)(param_1 + 0xc);
            cVar11 = *pcVar7;
            goto joined_r0x0001e730;
          }
          pcVar7 = *(char **)(param_1 + 0xc);
          if (*pcVar7 != 'E') {
            if ((iVar4 != 0) && (iVar9 = *(int *)(param_1 + 0x20), iVar9 < *(int *)(param_1 + 0x24))
               ) {
              *(int *)(iVar9 * 4 + *(int *)(param_1 + 0x1c)) = iVar4;
              *(int *)(param_1 + 0x20) = iVar9 + 1;
              goto LAB_0001e860;
            }
            break;
          }
          cVar11 = 'E';
LAB_0001e738:
          if ((((byte)(cVar11 - 0x30U) < 10) || ((byte)(cVar11 + 0x9fU) < 0x1a)) ||
             ((cVar11 == 'C' || ((cVar11 == 'U' || (cVar11 == 'L')))))) goto LAB_0001e826;
          if (cVar11 == 'S') {
            iVar4 = FUN_0001dfc4(param_1,1);
            goto joined_r0x0001e87a;
          }
          if (cVar11 != 'I') goto LAB_0001e76e;
          if (iVar1 == 0) break;
          iVar4 = FUN_0001e5b8(param_1);
          uVar3 = 4;
LAB_0001e834:
          iVar4 = FUN_0001dd2c(param_1,uVar3,iVar1,iVar4);
        } while( true );
      }
LAB_0001e78e:
      *piVar10 = 0;
      return 0;
    }
    break;
  case 0x53:
    if (puVar6[1] == 't') {
      *(undefined1 **)(param_1 + 0xc) = puVar6 + 2;
      uVar3 = FUN_0001ddc8(param_1,&DAT_000274a4,3);
      uVar2 = FUN_0001f780(param_1);
      iVar1 = FUN_0001dd2c(param_1,1,uVar3,uVar2);
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + 3;
      if (**(char **)(param_1 + 0xc) != 'I') {
        return iVar1;
      }
      if (iVar1 == 0) {
        return 0;
      }
      iVar8 = *(int *)(param_1 + 0x20);
      if (*(int *)(param_1 + 0x24) <= iVar8) {
        return 0;
      }
      *(int *)(iVar8 * 4 + *(int *)(param_1 + 0x1c)) = iVar1;
      *(int *)(param_1 + 0x20) = iVar8 + 1;
    }
    else {
      iVar1 = FUN_0001dfc4(param_1,0);
      if (**(char **)(param_1 + 0xc) != 'I') {
        return iVar1;
      }
    }
    uVar3 = FUN_0001e5b8(param_1);
    iVar1 = FUN_0001dd2c(param_1,4,iVar1,uVar3);
    return iVar1;
  case 0x5a:
    *(undefined1 **)(param_1 + 0xc) = puVar6 + 1;
    uVar3 = FUN_0001f184(param_1,0);
    pcVar7 = *(char **)(param_1 + 0xc);
    if (*pcVar7 == 'E') {
      *(char **)(param_1 + 0xc) = pcVar7 + 1;
      if (pcVar7[1] == 's') {
        *(char **)(param_1 + 0xc) = pcVar7 + 2;
        iVar1 = FUN_0001e28c(param_1);
        if (iVar1 == 0) {
          return 0;
        }
        piVar10 = (int *)FUN_0001ddc8(param_1,"string literal",0xe);
      }
      else {
        if (pcVar7[1] == 'd') {
          *(char **)(param_1 + 0xc) = pcVar7 + 2;
          iVar1 = FUN_0001e214(param_1);
          if (iVar1 < 0) {
            return 0;
          }
        }
        else {
          iVar1 = -1;
        }
        piVar5 = (int *)FUN_0001e674(param_1);
        if ((((piVar5 != (int *)0x0) && (*piVar5 != 0x44)) && (*piVar5 != 0x46)) &&
           (iVar8 = FUN_0001e28c(param_1), iVar8 == 0)) {
          return 0;
        }
        piVar10 = piVar5;
        if (iVar1 != -1) {
          iVar8 = *(int *)(param_1 + 0x14);
          piVar10 = (int *)0x0;
          if (iVar8 < *(int *)(param_1 + 0x18)) {
            piVar10 = (int *)(*(int *)(param_1 + 0x10) + iVar8 * 0xc);
            *(int *)(param_1 + 0x14) = iVar8 + 1;
            if (piVar10 != (int *)0x0) {
              *piVar10 = 0x45;
              piVar10[2] = iVar1;
              piVar10[1] = (int)piVar5;
            }
          }
        }
      }
      iVar1 = FUN_0001dd2c(param_1,2,uVar3,piVar10);
      return iVar1;
    }
  }
  return 0;
LAB_0001e826:
  iVar4 = FUN_0001f780(param_1);
  goto joined_r0x0001e87a;
LAB_0001e76e:
  if (cVar11 == 'T') {
    iVar4 = FUN_0001e244(param_1);
    goto joined_r0x0001e87a;
  }
  if (cVar11 == 'E') {
    *piVar10 = iVar1;
    if (iVar1 == 0) {
      return 0;
    }
    if (iVar8 != 0) {
      *(int *)(iVar8 + 4) = local_24[0];
      local_24[0] = iVar8;
    }
    if (**(char **)(param_1 + 0xc) != 'E') {
      return 0;
    }
    *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
    return local_24[0];
  }
  if ((cVar11 != 'M') || (iVar1 == 0)) goto LAB_0001e78e;
  *(char **)(param_1 + 0xc) = pcVar7 + 1;
  cVar11 = pcVar7[1];
  pcVar7 = pcVar7 + 1;
  goto joined_r0x0001e730;
}



// WARNING: Function: __gnu_thumb1_case_shi replaced with injection: switch16_shi_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001e9a2)
// WARNING (jumptable): Removing unreachable block (ram,0x0001eb8e)
// WARNING: Removing unreachable block (ram,0x0001e9a2)
// WARNING: Removing unreachable block (ram,0x0001eb8e)

int * FUN_0001e97c(int param_1)

{
  byte bVar1;
  int *piVar2;
  int *piVar3;
  undefined4 uVar4;
  int **ppiVar5;
  byte *pbVar6;
  ushort uVar7;
  byte *pbVar8;
  byte *pbVar9;
  uint uVar10;
  int iVar11;
  char *pcVar12;
  undefined *puVar13;
  bool bVar14;
  int *local_1c [2];
  
  pbVar8 = *(byte **)(param_1 + 0xc);
  uVar10 = (uint)*pbVar8;
  if (((uVar10 == 0x72) || (uVar10 == 0x56)) || (uVar10 == 0x4b)) {
    piVar2 = (int *)FUN_0001de00(param_1,local_1c,0);
    if (piVar2 == (int *)0x0) {
      return (int *)0x0;
    }
    piVar3 = (int *)FUN_0001e97c(param_1);
    *piVar2 = (int)piVar3;
    if (piVar3 == (int *)0x0) {
      return (int *)0x0;
    }
    if (*piVar3 - 0x1fU < 2) {
      iVar11 = piVar3[1];
      piVar3[1] = (int)local_1c[0];
      local_1c[0] = (int *)*piVar2;
      *piVar2 = iVar11;
    }
    if (local_1c[0] == (int *)0x0) {
      return (int *)0x0;
    }
    iVar11 = *(int *)(param_1 + 0x20);
    if (*(int *)(param_1 + 0x24) <= iVar11) {
      return (int *)0x0;
    }
    *(int **)(iVar11 * 4 + *(int *)(param_1 + 0x1c)) = local_1c[0];
    *(int *)(param_1 + 0x20) = iVar11 + 1;
    return local_1c[0];
  }
  switch(uVar10) {
  case 0x30:
  case 0x31:
  case 0x32:
  case 0x33:
  case 0x34:
  case 0x35:
  case 0x36:
  case 0x37:
  case 0x38:
  case 0x39:
  case 0x4e:
  case 0x5a:
    local_1c[0] = (int *)FUN_0001e674(param_1);
    break;
  default:
    goto switchD_0001e9a2_caseD_3a;
  case 0x41:
    pbVar6 = pbVar8 + 1;
    *(byte **)(param_1 + 0xc) = pbVar6;
    if (pbVar8[1] == 0x5f) {
      iVar11 = 0;
    }
    else {
      pbVar9 = pbVar6;
      if ((byte)(pbVar8[1] - 0x30) < 10) {
        do {
          pbVar9 = pbVar9 + 1;
          *(byte **)(param_1 + 0xc) = pbVar9;
        } while ((byte)(*pbVar9 - 0x30) < 10);
        iVar11 = FUN_0001ddc8(param_1,pbVar6,(int)pbVar9 - (int)pbVar6);
      }
      else {
        iVar11 = FUN_0001f9f8(param_1);
      }
      if ((iVar11 == 0) || (pbVar6 = *(byte **)(param_1 + 0xc), *pbVar6 != 0x5f)) goto LAB_0001eb0a;
    }
    *(byte **)(param_1 + 0xc) = pbVar6 + 1;
    uVar4 = FUN_0001e97c(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x2a,iVar11,uVar4);
    break;
  case 0x43:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    uVar4 = FUN_0001e97c(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x25,uVar4,0);
    break;
  case 0x44:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    if (pbVar8[1] == 0) {
      return (int *)0x0;
    }
    *(byte **)(param_1 + 0xc) = pbVar8 + 2;
    switch(pbVar8[1]) {
    case 0x46:
      iVar11 = *(int *)(param_1 + 0x14);
      local_1c[0] = (int *)0x0;
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        local_1c[0] = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
      }
      *local_1c[0] = 0x2c;
      bVar14 = (byte)(pbVar8[2] - 0x30) < 10;
      *(ushort *)(local_1c[0] + 2) = (ushort)bVar14;
      if (bVar14) {
        FUN_0001e190(param_1 + 0xc);
      }
      piVar2 = local_1c[0];
      iVar11 = FUN_0001e97c(param_1);
      piVar2[1] = iVar11;
      if (local_1c[0][1] == 0) {
        return (int *)0x0;
      }
      FUN_0001e190(param_1 + 0xc);
      pcVar12 = *(char **)(param_1 + 0xc);
      uVar7 = 0;
      if (*pcVar12 != '\0') {
        *(char **)(param_1 + 0xc) = pcVar12 + 1;
        uVar7 = (ushort)(*pcVar12 == 's');
      }
      *(ushort *)((int)local_1c[0] + 10) = uVar7;
      return local_1c[0];
    default:
      goto switchD_0001e9a2_caseD_3a;
    case 0x54:
    case 0x74:
      uVar4 = FUN_0001f9f8(param_1);
      local_1c[0] = (int *)FUN_0001dd2c(param_1,0x41,uVar4,0);
      if (local_1c[0] == (int *)0x0) {
        return (int *)0x0;
      }
      pcVar12 = *(char **)(param_1 + 0xc);
      if (*pcVar12 == '\0') {
        return (int *)0x0;
      }
      *(char **)(param_1 + 0xc) = pcVar12 + 1;
      if (*pcVar12 != 'E') {
        return (int *)0x0;
      }
      goto LAB_0001eaa6;
    case 0x61:
      piVar2 = (int *)FUN_0001ddc8(param_1,&DAT_000274a8,4);
      return piVar2;
    case 100:
      iVar11 = *(int *)(param_1 + 0x14);
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
        if (piVar2 != (int *)0x0) {
          *piVar2 = 0x27;
          puVar13 = &DAT_00029ed0;
          piVar2[1] = (int)&DAT_00029ed0;
          goto LAB_0001ee52;
        }
LAB_0001f08a:
        puVar13 = (undefined *)piVar2[1];
        goto LAB_0001ee52;
      }
      goto LAB_0001f058;
    case 0x65:
      iVar11 = *(int *)(param_1 + 0x14);
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
        if (piVar2 != (int *)0x0) {
          *piVar2 = 0x27;
          puVar13 = &DAT_00029ee4;
          piVar2[1] = (int)&DAT_00029ee4;
          goto LAB_0001eda6;
        }
LAB_0001f082:
        puVar13 = (undefined *)piVar2[1];
        goto LAB_0001eda6;
      }
      break;
    case 0x66:
      iVar11 = *(int *)(param_1 + 0x14);
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
        if (piVar2 != (int *)0x0) {
          *piVar2 = 0x27;
          puVar13 = &DAT_00029ebc;
          piVar2[1] = (int)&DAT_00029ebc;
          goto LAB_0001edde;
        }
LAB_0001f08e:
        puVar13 = (undefined *)piVar2[1];
        goto LAB_0001edde;
      }
      goto LAB_0001f060;
    case 0x68:
      iVar11 = *(int *)(param_1 + 0x14);
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
        if (piVar2 != (int *)0x0) {
          *piVar2 = 0x27;
          puVar13 = &DAT_00029ef8;
          piVar2[1] = (int)&DAT_00029ef8;
          goto LAB_0001edde;
        }
        goto LAB_0001f08e;
      }
LAB_0001f060:
      piVar2 = (int *)0x0;
      puVar13 = puRam00000004;
LAB_0001edde:
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + *(int *)(puVar13 + 4);
      return piVar2;
    case 0x69:
      iVar11 = *(int *)(param_1 + 0x14);
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
        if (piVar2 != (int *)0x0) {
          *piVar2 = 0x27;
          puVar13 = &DAT_00029f20;
          piVar2[1] = (int)&DAT_00029f20;
          goto LAB_0001eda6;
        }
        goto LAB_0001f082;
      }
      break;
    case 0x6e:
      iVar11 = *(int *)(param_1 + 0x14);
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
        if (piVar2 != (int *)0x0) {
          *piVar2 = 0x27;
          piVar2[1] = (int)&DAT_00029f34;
          puVar13 = &DAT_00029f34;
          goto LAB_0001eda6;
        }
        goto LAB_0001f082;
      }
      break;
    case 0x70:
      uVar4 = FUN_0001e97c(param_1);
      local_1c[0] = (int *)FUN_0001dd2c(param_1,0x49,uVar4,0);
      goto LAB_0001eaa0;
    case 0x73:
      iVar11 = *(int *)(param_1 + 0x14);
      if (iVar11 < *(int *)(param_1 + 0x18)) {
        piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
        *(int *)(param_1 + 0x14) = iVar11 + 1;
        if (piVar2 != (int *)0x0) {
          *piVar2 = 0x27;
          puVar13 = &DAT_00029f0c;
          piVar2[1] = (int)&DAT_00029f0c;
          goto LAB_0001ee52;
        }
        goto LAB_0001f08a;
      }
LAB_0001f058:
      piVar2 = (int *)0x0;
      puVar13 = puRam00000004;
LAB_0001ee52:
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + *(int *)(puVar13 + 4);
      return piVar2;
    case 0x76:
      if (pbVar8[2] == 0x5f) {
        *(byte **)(param_1 + 0xc) = pbVar8 + 3;
        iVar11 = FUN_0001f9f8(param_1);
      }
      else {
        iVar11 = FUN_0001e1e4(param_1);
      }
      if ((iVar11 == 0) || (**(char **)(param_1 + 0xc) != '_')) goto LAB_0001eb0a;
      *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
      uVar4 = FUN_0001e97c(param_1);
      local_1c[0] = (int *)FUN_0001dd2c(param_1,0x2d,iVar11,uVar4);
      goto LAB_0001eaa0;
    }
    piVar2 = (int *)0x0;
    puVar13 = puRam00000004;
LAB_0001eda6:
    *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + *(int *)(puVar13 + 4);
    return piVar2;
  case 0x46:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    if (pbVar8[1] == 0x59) {
      *(byte **)(param_1 + 0xc) = pbVar8 + 2;
    }
    uVar4 = FUN_0001f148(param_1,1);
    local_1c[0] = (int *)FUN_0001ded8(param_1,uVar4);
    if (**(char **)(param_1 + 0xc) != 'E') goto LAB_0001eb0a;
    *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
    break;
  case 0x47:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    uVar4 = FUN_0001e97c(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x26,uVar4,0);
    break;
  case 0x4d:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    uVar4 = FUN_0001e97c(param_1);
    ppiVar5 = (int **)FUN_0001de00(param_1,local_1c,1);
    if (ppiVar5 != (int **)0x0) {
      piVar2 = (int *)FUN_0001e97c(param_1);
      *ppiVar5 = piVar2;
      if (piVar2 != (int *)0x0) {
        if (ppiVar5 != local_1c) {
          iVar11 = *piVar2;
          if (iVar11 - 0x1fU < 2) {
            piVar3 = (int *)piVar2[1];
            piVar2[1] = (int)local_1c[0];
            local_1c[0] = *ppiVar5;
            iVar11 = *piVar3;
            *ppiVar5 = piVar3;
          }
          if (iVar11 != 0x29) {
            if ((local_1c[0] == (int *)0x0) ||
               (iVar11 = *(int *)(param_1 + 0x20), *(int *)(param_1 + 0x24) <= iVar11))
            goto LAB_0001eb0a;
            *(int **)(iVar11 * 4 + *(int *)(param_1 + 0x1c)) = local_1c[0];
            *(int *)(param_1 + 0x20) = iVar11 + 1;
          }
        }
        local_1c[0] = (int *)FUN_0001dd2c(param_1,0x2b,uVar4,local_1c[0]);
        break;
      }
    }
LAB_0001eb0a:
    local_1c[0] = (int *)0x0;
    break;
  case 0x4f:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    uVar4 = FUN_0001e97c(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x24,uVar4,0);
    break;
  case 0x50:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    uVar4 = FUN_0001e97c(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x22,uVar4,0);
    break;
  case 0x52:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    uVar4 = FUN_0001e97c(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x23,uVar4,0);
    break;
  case 0x53:
    bVar1 = pbVar8[1];
    if (((9 < (byte)(bVar1 - 0x30)) && (bVar1 != 0x5f)) && (0x19 < (byte)(bVar1 + 0xbf))) {
      local_1c[0] = (int *)FUN_0001e674(param_1);
      if (local_1c[0] == (int *)0x0) {
        return (int *)0x0;
      }
      if (*local_1c[0] == 0x18) {
        return local_1c[0];
      }
      goto LAB_0001eaa6;
    }
    local_1c[0] = (int *)FUN_0001dfc4(param_1,0);
    if (**(char **)(param_1 + 0xc) != 'I') {
      return local_1c[0];
    }
LAB_0001ece2:
    piVar2 = local_1c[0];
    uVar4 = FUN_0001e5b8(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,4,piVar2,uVar4);
    break;
  case 0x54:
    local_1c[0] = (int *)FUN_0001e244(param_1);
    if (**(char **)(param_1 + 0xc) == 'I') {
      if (local_1c[0] == (int *)0x0) {
        return (int *)0x0;
      }
      iVar11 = *(int *)(param_1 + 0x20);
      if (*(int *)(param_1 + 0x24) <= iVar11) {
        return (int *)0x0;
      }
      *(int **)(iVar11 * 4 + *(int *)(param_1 + 0x1c)) = local_1c[0];
      *(int *)(param_1 + 0x20) = iVar11 + 1;
      goto LAB_0001ece2;
    }
    break;
  case 0x55:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    local_1c[0] = (int *)FUN_0001e2ac(param_1);
    uVar4 = FUN_0001e97c(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x21,uVar4,local_1c[0]);
    break;
  case 0x61:
  case 0x62:
  case 99:
  case 100:
  case 0x65:
  case 0x66:
  case 0x67:
  case 0x68:
  case 0x69:
  case 0x6a:
  case 0x6c:
  case 0x6d:
  case 0x6e:
  case 0x6f:
  case 0x73:
  case 0x74:
  case 0x76:
  case 0x77:
  case 0x78:
  case 0x79:
  case 0x7a:
    iVar11 = *(int *)(param_1 + 0x14);
    if (iVar11 < *(int *)(param_1 + 0x18)) {
      piVar2 = (int *)(*(int *)(param_1 + 0x10) + iVar11 * 0xc);
      *(int *)(param_1 + 0x14) = iVar11 + 1;
      puVar13 = puRam00000004;
      if (piVar2 != (int *)0x0) {
        *piVar2 = 0x27;
        piVar2[1] = (int)(&UNK_00029cb4 + (uVar10 - 0x61) * 0x14);
        puVar13 = &UNK_00029cb4 + (uVar10 - 0x61) * 0x14;
      }
    }
    else {
      piVar2 = (int *)0x0;
      puVar13 = puRam00000004;
    }
    *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + *(int *)(puVar13 + 4);
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    return piVar2;
  case 0x75:
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    uVar4 = FUN_0001e2ac(param_1);
    local_1c[0] = (int *)FUN_0001dd2c(param_1,0x28,uVar4,0);
  }
LAB_0001eaa0:
  if (local_1c[0] != (int *)0x0) {
LAB_0001eaa6:
    iVar11 = *(int *)(param_1 + 0x20);
    if (iVar11 < *(int *)(param_1 + 0x24)) {
      *(int **)(iVar11 * 4 + *(int *)(param_1 + 0x1c)) = local_1c[0];
      *(int *)(param_1 + 0x20) = iVar11 + 1;
      return local_1c[0];
    }
  }
switchD_0001e9a2_caseD_3a:
  return (int *)0x0;
}



int FUN_0001f0b8(int param_1)

{
  char *pcVar1;
  int iVar2;
  char cVar3;
  int *piVar4;
  int local_14 [2];
  
  pcVar1 = *(char **)(param_1 + 0xc);
  local_14[0] = 0;
  cVar3 = *pcVar1;
  if (((cVar3 == '\0') || (cVar3 == 'E')) || (cVar3 == '.')) {
    return 0;
  }
  piVar4 = local_14;
  do {
    if (cVar3 == 'O') {
      cVar3 = pcVar1[1];
joined_r0x0001f0da:
      if (cVar3 == 'E') {
LAB_0001f118:
        if (local_14[0] == 0) {
          return 0;
        }
        if (*(int *)(local_14[0] + 8) != 0) {
          return local_14[0];
        }
        if (**(int **)(local_14[0] + 4) != 0x27) {
          return local_14[0];
        }
        iVar2 = (*(int **)(local_14[0] + 4))[1];
        if (*(int *)(iVar2 + 0x10) == 9) {
          *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) - *(int *)(iVar2 + 4);
          *(undefined4 *)(local_14[0] + 4) = 0;
          return local_14[0];
        }
        return local_14[0];
      }
    }
    else if (cVar3 == 'R') {
      cVar3 = pcVar1[1];
      goto joined_r0x0001f0da;
    }
    iVar2 = FUN_0001e97c(param_1);
    if (iVar2 == 0) {
      return 0;
    }
    iVar2 = FUN_0001dd2c(param_1,0x2e,iVar2,0);
    *piVar4 = iVar2;
    if (iVar2 == 0) {
      return 0;
    }
    pcVar1 = *(char **)(param_1 + 0xc);
    cVar3 = *pcVar1;
    piVar4 = (int *)(iVar2 + 8);
    if (((cVar3 == '\0') || (cVar3 == 'E')) || (cVar3 == '.')) goto LAB_0001f118;
  } while( true );
}



undefined4 FUN_0001f148(int param_1,int param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  
  if (**(char **)(param_1 + 0xc) == 'J') {
    *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
  }
  else {
    iVar3 = 0;
    if (param_2 == 0) goto LAB_0001f15a;
  }
  iVar3 = FUN_0001e97c(param_1);
  if (iVar3 == 0) {
    return 0;
  }
LAB_0001f15a:
  iVar1 = FUN_0001f0b8(param_1);
  if (iVar1 == 0) {
    return 0;
  }
  uVar2 = FUN_0001dd2c(param_1,0x29,iVar3,iVar1,param_4);
  return uVar2;
}



// WARNING: Function: __gnu_thumb1_case_shi replaced with injection: switch16_shi_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001f254)
// WARNING (jumptable): Removing unreachable block (ram,0x0001f350)
// WARNING (jumptable): Removing unreachable block (ram,0x0001f2d2)
// WARNING: Removing unreachable block (ram,0x0001f254)
// WARNING: Removing unreachable block (ram,0x0001f350)
// WARNING: Removing unreachable block (ram,0x0001f2d2)

uint * FUN_0001f184(int param_1,int param_2)

{
  uint *puVar1;
  char cVar2;
  uint *puVar3;
  undefined4 uVar4;
  undefined4 uVar5;
  uint *puVar6;
  int iVar7;
  int iVar8;
  char *pcVar9;
  uint uVar10;
  int *piVar11;
  undefined4 *puVar12;
  undefined4 *puVar13;
  int iVar14;
  char *pcVar15;
  
  pcVar9 = *(char **)(param_1 + 0xc);
  if ((*pcVar9 != 'T') && (*pcVar9 != 'G')) {
    puVar3 = (uint *)FUN_0001e674();
    if ((puVar3 != (uint *)0x0) && ((param_2 != 0 && (-1 < *(int *)(param_1 + 8) << 0x1f)))) {
      uVar10 = *puVar3;
      while (uVar10 - 0x1c < 5) {
        puVar3 = (uint *)puVar3[1];
        uVar10 = *puVar3;
      }
      if (uVar10 != 2) {
        return puVar3;
      }
      piVar11 = (int *)puVar3[2];
      iVar7 = *piVar11;
      while (iVar7 - 0x1cU < 5) {
        piVar11 = (int *)piVar11[1];
        iVar7 = *piVar11;
      }
      puVar3[2] = (uint)piVar11;
      return puVar3;
    }
    if (puVar3 == (uint *)0x0) {
      return (uint *)0x0;
    }
    if (**(char **)(param_1 + 0xc) == '\0') {
      return puVar3;
    }
    puVar6 = puVar3;
    if (**(char **)(param_1 + 0xc) == 'E') {
      return puVar3;
    }
    do {
      uVar10 = *puVar6;
      if (uVar10 == 4) {
        puVar12 = (undefined4 *)puVar6[1];
        if (puVar12 == (undefined4 *)0x0) goto switchD_0001f350_caseD_3;
        goto LAB_0001f344;
      }
    } while (((3 < uVar10) && (uVar10 - 0x1c < 5)) &&
            (puVar1 = puVar6 + 1, puVar6 = (uint *)*puVar1, (uint *)*puVar1 != (uint *)0x0));
switchD_0001f350_caseD_7:
    uVar5 = 0;
    goto LAB_0001f1ce;
  }
  iVar7 = *(int *)(param_1 + 0x30);
  *(int *)(param_1 + 0x30) = iVar7 + 0x14;
  if (*pcVar9 != 'T') {
    if ((*pcVar9 == 'G') && (*(char **)(param_1 + 0xc) = pcVar9 + 1, pcVar9[1] != '\0')) {
      *(char **)(param_1 + 0xc) = pcVar9 + 2;
      switch(pcVar9[1]) {
      case 'A':
        uVar5 = FUN_0001f184(param_1,0);
        puVar3 = (uint *)FUN_0001dd2c(param_1,0x17,uVar5,0);
        return puVar3;
      case 'R':
        uVar5 = FUN_0001e674(param_1);
        uVar4 = FUN_0001e1e4(param_1);
        puVar3 = (uint *)FUN_0001dd2c(param_1,0x16,uVar5,uVar4);
        return puVar3;
      case 'T':
        if ((pcVar9[2] != '\0') && (*(char **)(param_1 + 0xc) = pcVar9 + 3, pcVar9[2] == 'n')) {
          uVar5 = FUN_0001f184(param_1,0);
          puVar3 = (uint *)FUN_0001dd2c(param_1,0x48,uVar5,0);
          return puVar3;
        }
        uVar5 = FUN_0001f184(param_1,0);
        puVar3 = (uint *)FUN_0001dd2c(param_1,0x47,uVar5,0);
        return puVar3;
      case 'V':
        uVar5 = FUN_0001e674(param_1);
        puVar3 = (uint *)FUN_0001dd2c(param_1,0x13,uVar5,0);
        return puVar3;
      case 'r':
        iVar7 = FUN_0001e190(param_1 + 0xc);
        if ((1 < iVar7) && (pcVar9 = *(char **)(param_1 + 0xc), *pcVar9 != '\0')) {
          pcVar15 = pcVar9 + 1;
          *(char **)(param_1 + 0xc) = pcVar15;
          if (*pcVar9 == '_') {
            iVar7 = iVar7 + -1;
            puVar12 = (undefined4 *)0x0;
            while (*pcVar15 != '\0') {
              if (*pcVar15 == '$') {
                cVar2 = pcVar15[1];
                if (cVar2 == 'S') {
                  uVar5 = 0x2f;
                }
                else if (cVar2 == '_') {
                  uVar5 = 0x2e;
                }
                else {
                  if (cVar2 != '$') break;
                  uVar5 = 0x24;
                }
                iVar8 = *(int *)(param_1 + 0x14);
                if (iVar8 < *(int *)(param_1 + 0x18)) {
                  puVar13 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar8 * 0xc);
                  *(int *)(param_1 + 0x14) = iVar8 + 1;
                  if (puVar13 != (undefined4 *)0x0) {
                    puVar13[1] = uVar5;
                    pcVar15 = (char *)(*(int *)(param_1 + 0xc) + 2);
                    *puVar13 = 0x3f;
                    iVar8 = -2;
                    *(char **)(param_1 + 0xc) = pcVar15;
                    goto LAB_0001f42c;
                  }
                }
                *(int *)(param_1 + 0xc) = *(int *)(param_1 + 0xc) + 2;
                break;
              }
              iVar14 = 0;
              do {
                if ((pcVar15[iVar14] == '\0') || (pcVar15[iVar14] == '$')) break;
                iVar14 = iVar14 + 1;
              } while (iVar14 < iVar7);
              puVar13 = (undefined4 *)FUN_0001ddc8(param_1,pcVar15,iVar14);
              iVar8 = -iVar14;
              pcVar15 = (char *)(*(int *)(param_1 + 0xc) + iVar14);
              *(char **)(param_1 + 0xc) = pcVar15;
              if (puVar13 == (undefined4 *)0x0) break;
LAB_0001f42c:
              iVar7 = iVar7 + iVar8;
              if ((puVar12 != (undefined4 *)0x0) &&
                 (puVar13 = (undefined4 *)FUN_0001dd2c(param_1,0x3e), puVar13 == (undefined4 *)0x0))
              break;
              puVar12 = puVar13;
              if (iVar7 < 1) {
                puVar3 = (uint *)FUN_0001dd2c(param_1,0x3d,puVar13,0);
                return puVar3;
              }
            }
          }
        }
      }
    }
    goto switchD_0001f254_caseD_42;
  }
  *(char **)(param_1 + 0xc) = pcVar9 + 1;
  if (pcVar9[1] == '\0') goto switchD_0001f254_caseD_42;
  *(char **)(param_1 + 0xc) = pcVar9 + 2;
  switch(pcVar9[1]) {
  case 'C':
    uVar5 = FUN_0001e97c(param_1);
    iVar7 = FUN_0001e190(param_1 + 0xc);
    if ((-1 < iVar7) && (**(char **)(param_1 + 0xc) == '_')) {
      *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
      uVar4 = FUN_0001e97c(param_1);
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + 5;
      puVar3 = (uint *)FUN_0001dd2c(param_1,0xb,uVar4,uVar5);
      return puVar3;
    }
  default:
    goto switchD_0001f254_caseD_42;
  case 'F':
    uVar5 = FUN_0001e97c(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,0xe,uVar5,0);
    break;
  case 'H':
    uVar5 = FUN_0001e674(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,0x14,uVar5,0);
    break;
  case 'I':
    uVar5 = FUN_0001e97c(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,0xc,uVar5,0);
    break;
  case 'J':
    uVar5 = FUN_0001e97c(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,0x12,uVar5,0);
    break;
  case 'S':
    uVar5 = FUN_0001e97c(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,0xd,uVar5,0);
    break;
  case 'T':
    *(int *)(param_1 + 0x30) = iVar7 + 10;
    uVar5 = FUN_0001e97c(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,10,uVar5,0);
    break;
  case 'V':
    *(int *)(param_1 + 0x30) = iVar7 + 0xf;
    uVar5 = FUN_0001e97c(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,9,uVar5,0);
    break;
  case 'W':
    uVar5 = FUN_0001e674(param_1);
    puVar3 = (uint *)FUN_0001dd2c(param_1,0x15,uVar5,0);
    break;
  case 'c':
    iVar7 = FUN_0001e338(param_1,0);
    if ((iVar7 != 0) && (iVar7 = FUN_0001e338(param_1,0), iVar7 != 0)) {
      uVar5 = FUN_0001f184(param_1,0);
      puVar3 = (uint *)FUN_0001dd2c(param_1,0x11,uVar5,0);
      return puVar3;
    }
    goto switchD_0001f254_caseD_42;
  case 'h':
    iVar7 = FUN_0001e338(param_1,0x68);
    if (iVar7 != 0) {
      uVar5 = FUN_0001f184(param_1,0);
      puVar3 = (uint *)FUN_0001dd2c(param_1,0xf,uVar5,0);
      return puVar3;
    }
    goto switchD_0001f254_caseD_42;
  case 'v':
    iVar7 = FUN_0001e338(param_1,0x76);
    if (iVar7 != 0) {
      uVar5 = FUN_0001f184(param_1,0);
      puVar3 = (uint *)FUN_0001dd2c(param_1,0x10,uVar5,0);
      return puVar3;
    }
switchD_0001f254_caseD_42:
    puVar3 = (uint *)0x0;
  }
  return puVar3;
LAB_0001f344:
  switch(*puVar12) {
  case 1:
  case 2:
    break;
  default:
    goto switchD_0001f350_caseD_3;
  case 7:
  case 8:
  case 0x33:
    goto switchD_0001f350_caseD_7;
  }
  puVar12 = (undefined4 *)puVar12[2];
  if (puVar12 == (undefined4 *)0x0) goto code_r0x0001f3c0;
  goto LAB_0001f344;
code_r0x0001f3c0:
  uVar5 = 1;
  goto LAB_0001f1ce;
switchD_0001f350_caseD_3:
  uVar5 = 1;
LAB_0001f1ce:
  uVar5 = FUN_0001f148(param_1,uVar5);
  puVar3 = (uint *)FUN_0001dd2c(param_1,3,puVar3,uVar5);
  return puVar3;
}



undefined4 * FUN_0001f688(int param_1)

{
  byte bVar1;
  byte bVar2;
  int iVar3;
  undefined4 uVar4;
  uint uVar5;
  undefined4 *puVar6;
  int iVar7;
  byte *pbVar8;
  int iVar9;
  uint uVar10;
  
  pbVar8 = *(byte **)(param_1 + 0xc);
  if (*pbVar8 == 0) {
    bVar2 = 0;
    uVar10 = 0;
  }
  else {
    *(byte **)(param_1 + 0xc) = pbVar8 + 1;
    bVar2 = *pbVar8;
    uVar10 = 0;
    if (pbVar8[1] != 0) {
      *(byte **)(param_1 + 0xc) = pbVar8 + 2;
      uVar10 = (uint)pbVar8[1];
    }
    if (bVar2 == 0x76) {
      if ((uVar10 - 0x30 & 0xff) < 10) {
        iVar3 = FUN_0001e2ac(param_1);
        iVar9 = *(int *)(param_1 + 0x14);
        if (*(int *)(param_1 + 0x18) <= iVar9) {
          return (undefined4 *)0x0;
        }
        puVar6 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar9 * 0xc);
        *(int *)(param_1 + 0x14) = iVar9 + 1;
        if (puVar6 == (undefined4 *)0x0) {
          return (undefined4 *)0x0;
        }
        if (iVar3 == 0) {
          return (undefined4 *)0x0;
        }
        puVar6[2] = iVar3;
        *puVar6 = 0x32;
        puVar6[1] = uVar10 - 0x30;
        return puVar6;
      }
    }
    else if ((uVar10 == 0x76) && (bVar2 == 99)) {
      uVar4 = FUN_0001e97c(param_1);
      puVar6 = (undefined4 *)FUN_0001dd2c(param_1,0x33,uVar4,0);
      return puVar6;
    }
  }
  iVar9 = 0;
  iVar3 = 0x3d;
  do {
    iVar7 = (iVar3 - iVar9) / 2 + iVar9;
    pbVar8 = *(byte **)(&UNK_00029f48 + iVar7 * 0x10);
    bVar1 = *pbVar8;
    if (bVar2 == bVar1) {
      uVar5 = (uint)pbVar8[1];
      if (uVar10 == uVar5) {
        iVar3 = *(int *)(param_1 + 0x14);
        if (*(int *)(param_1 + 0x18) <= iVar3) {
          return (undefined4 *)0x0;
        }
        puVar6 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar3 * 0xc);
        *(int *)(param_1 + 0x14) = iVar3 + 1;
        if (puVar6 != (undefined4 *)0x0) {
          *puVar6 = 0x31;
          puVar6[1] = &UNK_00029f48 + iVar7 * 0x10;
          return puVar6;
        }
        return (undefined4 *)0x0;
      }
      if (uVar5 <= uVar10) goto LAB_0001f732;
    }
    else if (bVar1 <= bVar2) {
LAB_0001f732:
      iVar9 = iVar7 + 1;
      iVar7 = iVar3;
    }
    iVar3 = iVar7;
    if (iVar9 == iVar7) {
      return (undefined4 *)0x0;
    }
  } while( true );
}



// WARNING: Function: __gnu_thumb1_case_sqi replaced with injection: switchS8_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001f942)
// WARNING (jumptable): Removing unreachable block (ram,0x0001f996)
// WARNING: Removing unreachable block (ram,0x0001f942)
// WARNING: Removing unreachable block (ram,0x0001f996)
// WARNING: Type propagation algorithm not settling

int * FUN_0001f780(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  int iVar2;
  char cVar3;
  char *pcVar4;
  char *pcVar5;
  int iVar6;
  int iVar7;
  int *piVar8;
  int *piVar9;
  
  pcVar4 = *(char **)(param_1 + 0xc);
  cVar3 = *pcVar4;
  if ((byte)(cVar3 - 0x30U) < 10) {
    piVar8 = (int *)FUN_0001e2ac();
    pcVar5 = *(char **)(param_1 + 0xc);
    cVar3 = *pcVar5;
    goto joined_r0x0001f7e8;
  }
  if ((byte)(cVar3 + 0x9fU) < 0x1a) {
    piVar8 = (int *)FUN_0001f688();
    if ((piVar8 != (int *)0x0) && (*piVar8 == 0x31)) {
      pcVar4 = *(char **)piVar8[1];
      *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + ((undefined4 *)piVar8[1])[2] + 7;
      iVar2 = strcmp(pcVar4,"li");
      if (iVar2 == 0) {
        uVar1 = FUN_0001e2ac(param_1);
        piVar8 = (int *)FUN_0001dd2c(param_1,0x35,piVar8,uVar1);
        pcVar5 = *(char **)(param_1 + 0xc);
        cVar3 = *pcVar5;
        goto joined_r0x0001f7e8;
      }
    }
  }
  else {
    if ((byte)(cVar3 + 0xbdU) < 2) {
      piVar9 = *(int **)(param_1 + 0x2c);
      if (piVar9 != (int *)0x0) {
        if (*piVar9 == 0) {
          *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + piVar9[2];
          cVar3 = *pcVar4;
        }
        else if (*piVar9 == 0x18) {
          *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + piVar9[2];
          cVar3 = *pcVar4;
        }
      }
      if (cVar3 == 'C') {
        switch(pcVar4[1]) {
        case '1':
          iVar2 = 1;
          break;
        case '2':
          iVar2 = 2;
          break;
        case '3':
          iVar2 = 3;
          break;
        default:
LAB_0001f7da:
          return (int *)0x0;
        case '5':
          iVar2 = 4;
        }
        iVar7 = *(int *)(param_1 + 0x14);
        pcVar5 = pcVar4 + 2;
        *(char **)(param_1 + 0xc) = pcVar5;
        if (iVar7 < *(int *)(param_1 + 0x18)) {
          piVar8 = (int *)(*(int *)(param_1 + 0x10) + iVar7 * 0xc);
          *(int *)(param_1 + 0x14) = iVar7 + 1;
          if ((piVar8 != (int *)0x0) && (piVar9 != (int *)0x0)) {
            *piVar8 = 7;
            piVar8[1] = iVar2;
            piVar8[2] = (int)piVar9;
            cVar3 = pcVar4[2];
            goto joined_r0x0001f7e8;
          }
        }
      }
      else {
        if (cVar3 != 'D') {
          piVar8 = (int *)0x0;
          pcVar5 = pcVar4;
          goto joined_r0x0001f7e8;
        }
        switch(pcVar4[1]) {
        case '0':
          iVar2 = 1;
          break;
        case '1':
          iVar2 = 2;
          break;
        case '2':
          iVar2 = 3;
          break;
        default:
          goto LAB_0001f7da;
        case '5':
          iVar2 = 4;
        }
        iVar7 = *(int *)(param_1 + 0x14);
        pcVar5 = pcVar4 + 2;
        *(char **)(param_1 + 0xc) = pcVar5;
        if (iVar7 < *(int *)(param_1 + 0x18)) {
          piVar8 = (int *)(*(int *)(param_1 + 0x10) + iVar7 * 0xc);
          *(int *)(param_1 + 0x14) = iVar7 + 1;
          if ((piVar8 != (int *)0x0) && (piVar9 != (int *)0x0)) {
            *piVar8 = 8;
            piVar8[1] = iVar2;
            piVar8[2] = (int)piVar9;
            cVar3 = pcVar4[2];
            goto joined_r0x0001f7e8;
          }
        }
      }
      piVar8 = (int *)0x0;
      pcVar5 = pcVar4 + 2;
      cVar3 = *pcVar5;
      goto joined_r0x0001f7e8;
    }
    if (cVar3 != 'L') {
      if (cVar3 != 'U') {
        return (int *)0x0;
      }
      if (pcVar4[1] == 'l') {
        pcVar5 = pcVar4 + 1;
        *(char **)(param_1 + 0xc) = pcVar5;
        cVar3 = pcVar4[1];
        if (cVar3 == 'l') {
          *(char **)(param_1 + 0xc) = pcVar4 + 2;
          iVar2 = FUN_0001f0b8();
          pcVar5 = *(char **)(param_1 + 0xc);
          cVar3 = *pcVar5;
          if ((iVar2 != 0) && (cVar3 == 'E')) {
            *(char **)(param_1 + 0xc) = pcVar5 + 1;
            iVar7 = FUN_0001e214(param_1);
            if ((-1 < iVar7) && (iVar6 = *(int *)(param_1 + 0x14), iVar6 < *(int *)(param_1 + 0x18))
               ) {
              piVar8 = (int *)(*(int *)(param_1 + 0x10) + iVar6 * 0xc);
              *(int *)(param_1 + 0x14) = iVar6 + 1;
              if (piVar8 != (int *)0x0) {
                piVar8[1] = iVar2;
                piVar8[2] = iVar7;
                *piVar8 = 0x44;
                iVar2 = *(int *)(param_1 + 0x20);
                if (iVar2 < *(int *)(param_1 + 0x24)) goto LAB_0001f876;
              }
            }
            goto LAB_0001f93a;
          }
        }
      }
      else {
        if (pcVar4[1] != 't') {
          return (int *)0x0;
        }
        pcVar5 = pcVar4 + 1;
        *(char **)(param_1 + 0xc) = pcVar5;
        cVar3 = pcVar4[1];
        if (cVar3 == 't') {
          *(char **)(param_1 + 0xc) = pcVar4 + 2;
          iVar2 = FUN_0001e214();
          if ((-1 < iVar2) && (iVar7 = *(int *)(param_1 + 0x14), iVar7 < *(int *)(param_1 + 0x18)))
          {
            piVar8 = (int *)(*(int *)(param_1 + 0x10) + iVar7 * 0xc);
            *(int *)(param_1 + 0x14) = iVar7 + 1;
            if (piVar8 != (int *)0x0) {
              piVar8[1] = iVar2;
              *piVar8 = 0x46;
              iVar2 = *(int *)(param_1 + 0x20);
              if (iVar2 < *(int *)(param_1 + 0x24)) {
LAB_0001f876:
                *(int **)(iVar2 * 4 + *(int *)(param_1 + 0x1c)) = piVar8;
                *(int *)(param_1 + 0x20) = iVar2 + 1;
                goto LAB_0001f81a;
              }
            }
          }
LAB_0001f93a:
          pcVar5 = *(char **)(param_1 + 0xc);
          piVar8 = (int *)0x0;
          cVar3 = *pcVar5;
          goto joined_r0x0001f7e8;
        }
      }
      piVar8 = (int *)0x0;
      goto joined_r0x0001f7e8;
    }
    *(char **)(param_1 + 0xc) = pcVar4 + 1;
    piVar8 = (int *)FUN_0001e2ac();
    if (piVar8 == (int *)0x0) {
      return (int *)0x0;
    }
    iVar2 = FUN_0001e28c(param_1);
    if (iVar2 == 0) {
      return (int *)0x0;
    }
  }
LAB_0001f81a:
  pcVar5 = *(char **)(param_1 + 0xc);
  cVar3 = *pcVar5;
joined_r0x0001f7e8:
  while (cVar3 == 'B') {
    *(char **)(param_1 + 0xc) = pcVar5 + 1;
    uVar1 = FUN_0001e2ac(param_1);
    piVar8 = (int *)FUN_0001dd2c(param_1,0x4a,piVar8,uVar1,param_4);
    pcVar5 = *(char **)(param_1 + 0xc);
    cVar3 = **(char **)(param_1 + 0xc);
  }
  return piVar8;
}



// WARNING: Function: __gnu_thumb1_case_uhi replaced with injection: switch16_uhi_r0
// WARNING (jumptable): Removing unreachable block (ram,0x0001fb3c)
// WARNING: Removing unreachable block (ram,0x0001fb3c)

undefined4 * FUN_0001f9f8(int param_1)

{
  char cVar1;
  bool bVar2;
  int *piVar3;
  undefined4 uVar4;
  undefined4 *puVar5;
  int iVar6;
  undefined4 uVar7;
  undefined4 uVar8;
  char *pcVar9;
  int iVar10;
  
  pcVar9 = *(char **)(param_1 + 0xc);
  cVar1 = *pcVar9;
  if (cVar1 == 'L') {
    puVar5 = (undefined4 *)FUN_0001e4f0();
    return puVar5;
  }
  if (cVar1 == 'T') {
    puVar5 = (undefined4 *)FUN_0001e244();
    return puVar5;
  }
  if (cVar1 == 's') {
    if (pcVar9[1] == 'r') {
      *(char **)(param_1 + 0xc) = pcVar9 + 2;
      uVar4 = FUN_0001e97c();
      uVar7 = FUN_0001f780(param_1);
      if (**(char **)(param_1 + 0xc) == 'I') {
        uVar8 = FUN_0001e5b8();
        uVar7 = FUN_0001dd2c(param_1,4,uVar7,uVar8);
        puVar5 = (undefined4 *)FUN_0001dd2c(param_1,1,uVar4,uVar7);
        return puVar5;
      }
      puVar5 = (undefined4 *)FUN_0001dd2c(param_1,1,uVar4,uVar7);
      return puVar5;
    }
    if (pcVar9[1] == 'p') {
      *(char **)(param_1 + 0xc) = pcVar9 + 2;
      uVar4 = FUN_0001f9f8();
      puVar5 = (undefined4 *)FUN_0001dd2c(param_1,0x49,uVar4,0);
      return puVar5;
    }
  }
  else if (cVar1 == 'f') {
    if (pcVar9[1] == 'p') {
      *(char **)(param_1 + 0xc) = pcVar9 + 2;
      if (pcVar9[2] == 'T') {
        *(char **)(param_1 + 0xc) = pcVar9 + 3;
        iVar10 = 0;
      }
      else {
        iVar10 = FUN_0001e214();
        iVar10 = iVar10 + 1;
        if (iVar10 == 0) {
          return (undefined4 *)0x0;
        }
      }
      iVar6 = *(int *)(param_1 + 0x14);
      if (iVar6 < *(int *)(param_1 + 0x18)) {
        puVar5 = (undefined4 *)(*(int *)(param_1 + 0x10) + iVar6 * 0xc);
        *(int *)(param_1 + 0x14) = iVar6 + 1;
        if (puVar5 == (undefined4 *)0x0) {
          return (undefined4 *)0x0;
        }
        *puVar5 = 6;
        puVar5[1] = iVar10;
        return puVar5;
      }
      return (undefined4 *)0x0;
    }
  }
  else {
    if ((byte)(cVar1 - 0x30U) < 10) {
LAB_0001fa26:
      puVar5 = (undefined4 *)FUN_0001f780(param_1);
      if (puVar5 == (undefined4 *)0x0) {
        return (undefined4 *)0x0;
      }
      if (**(char **)(param_1 + 0xc) != 'I') {
        return puVar5;
      }
      uVar4 = FUN_0001e5b8(param_1);
      puVar5 = (undefined4 *)FUN_0001dd2c(param_1,4,puVar5,uVar4);
      return puVar5;
    }
    if (cVar1 == 'o') {
      if (pcVar9[1] == 'n') {
        *(char **)(param_1 + 0xc) = pcVar9 + 2;
        goto LAB_0001fa26;
      }
    }
    else if (((cVar1 == 't') || (cVar1 == 'i')) && (pcVar9[1] == 'l')) {
      uVar4 = 0;
      if (cVar1 == 't') {
        uVar4 = FUN_0001e97c(param_1);
        pcVar9 = *(char **)(param_1 + 0xc);
      }
      *(char **)(param_1 + 0xc) = pcVar9 + 2;
      uVar7 = FUN_0001fe00(param_1,0x45);
      puVar5 = (undefined4 *)FUN_0001dd2c(param_1,0x30,uVar4,uVar7);
      return puVar5;
    }
  }
  piVar3 = (int *)FUN_0001f688(param_1);
  if (piVar3 == (int *)0x0) {
    return (undefined4 *)0x0;
  }
  iVar10 = *piVar3;
  if (iVar10 == 0x31) {
    puVar5 = (undefined4 *)piVar3[1];
    pcVar9 = (char *)*puVar5;
    *(int *)(param_1 + 0x30) = *(int *)(param_1 + 0x30) + puVar5[2] + -2;
    iVar6 = strcmp(pcVar9,"st");
    if (iVar6 != 0) {
      iVar6 = puVar5[3];
      goto LAB_0001fb34;
    }
    uVar4 = FUN_0001e97c(param_1);
    goto LAB_0001faa2;
  }
  if (iVar10 == 0x32) {
    pcVar9 = (char *)0x0;
    iVar6 = piVar3[1];
LAB_0001fb34:
    switch(iVar6) {
    case 0:
      puVar5 = (undefined4 *)FUN_0001dd2c(param_1,0x34,piVar3,0);
      return puVar5;
    case 1:
      goto switchD_0001fb3c_caseD_1;
    case 2:
      if (((*(char **)piVar3[1])[1] == 'c') &&
         ((cVar1 = **(char **)piVar3[1], (byte)(cVar1 + 0x9dU) < 2 || ((byte)(cVar1 + 0x8eU) < 2))))
      {
        uVar4 = FUN_0001e97c(param_1);
      }
      else {
        uVar4 = FUN_0001f9f8(param_1);
      }
      iVar10 = strcmp(pcVar9,"cl");
      if (iVar10 == 0) {
        uVar7 = FUN_0001fe00(param_1,0x45);
      }
      else {
        iVar10 = strcmp(pcVar9,"dt");
        if ((iVar10 == 0) || (iVar10 = strcmp(pcVar9,"pt"), iVar10 == 0)) {
          uVar7 = FUN_0001f780(param_1);
          if (**(char **)(param_1 + 0xc) == 'I') {
            uVar8 = FUN_0001e5b8(param_1);
            uVar7 = FUN_0001dd2c(param_1,4,uVar7,uVar8);
          }
        }
        else {
          uVar7 = FUN_0001f9f8(param_1);
        }
      }
      uVar4 = FUN_0001dd2c(param_1,0x37,uVar4,uVar7);
      puVar5 = (undefined4 *)FUN_0001dd2c(param_1,0x36,piVar3,uVar4);
      return puVar5;
    case 3:
      iVar10 = strcmp(pcVar9,"qu");
      if (iVar10 == 0) {
        uVar4 = FUN_0001f9f8(param_1);
        uVar7 = FUN_0001f9f8(param_1);
        uVar8 = FUN_0001f9f8(param_1);
      }
      else {
        if (*pcVar9 != 'n') {
          return (undefined4 *)0x0;
        }
        if ((pcVar9[1] != 'a') && (pcVar9[1] != 'w')) {
          return (undefined4 *)0x0;
        }
        uVar4 = FUN_0001fe00(param_1,0x5f);
        uVar7 = FUN_0001e97c(param_1);
        pcVar9 = *(char **)(param_1 + 0xc);
        cVar1 = *pcVar9;
        if (cVar1 == 'E') {
          *(char **)(param_1 + 0xc) = pcVar9 + 1;
          uVar8 = 0;
        }
        else if (cVar1 == 'p') {
          if (pcVar9[1] != 'i') {
            return (undefined4 *)0x0;
          }
          *(char **)(param_1 + 0xc) = pcVar9 + 2;
          uVar8 = FUN_0001fe00(param_1,0x45);
        }
        else {
          if ((cVar1 != 'i') || (pcVar9[1] != 'l')) {
            return (undefined4 *)0x0;
          }
          uVar8 = FUN_0001f9f8(param_1);
        }
      }
      uVar7 = FUN_0001dd2c(param_1,0x3a,uVar7,uVar8);
      uVar4 = FUN_0001dd2c(param_1,0x39,uVar4,uVar7);
      puVar5 = (undefined4 *)FUN_0001dd2c(param_1,0x38,piVar3,uVar4);
      return puVar5;
    default:
      return (undefined4 *)0x0;
    }
  }
  if (iVar10 != 0x33) {
    return (undefined4 *)0x0;
  }
  bVar2 = false;
LAB_0001fa7e:
  if (**(char **)(param_1 + 0xc) != '_') goto LAB_0001fa88;
  *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
  uVar4 = FUN_0001fe00(param_1,0x45);
LAB_0001fa90:
  if (bVar2) {
    uVar4 = FUN_0001dd2c(param_1,0x37,uVar4);
  }
LAB_0001faa2:
  puVar5 = (undefined4 *)FUN_0001dd2c(param_1,0x35,piVar3,uVar4);
  return puVar5;
switchD_0001fb3c_caseD_1:
  bVar2 = false;
  if ((pcVar9 != (char *)0x0) &&
     (((cVar1 = *pcVar9, cVar1 == 'm' || (cVar1 == 'p')) && (bVar2 = false, pcVar9[1] == cVar1)))) {
    bVar2 = true;
    if (**(char **)(param_1 + 0xc) == '_') {
      *(char **)(param_1 + 0xc) = *(char **)(param_1 + 0xc) + 1;
      bVar2 = false;
    }
  }
  if (iVar10 == 0x33) goto LAB_0001fa7e;
LAB_0001fa88:
  uVar4 = FUN_0001f9f8(param_1);
  goto LAB_0001fa90;
}



int FUN_0001fe00(int param_1,uint param_2)

{
  int iVar1;
  int *piVar2;
  int local_14;
  
  local_14 = 0;
  piVar2 = &local_14;
  if (**(byte **)(param_1 + 0xc) == param_2) {
    *(byte **)(param_1 + 0xc) = *(byte **)(param_1 + 0xc) + 1;
    local_14 = FUN_0001dd2c(param_1,0x2e,0,0);
  }
  else {
    do {
      iVar1 = FUN_0001f9f8(param_1);
      if (iVar1 == 0) {
        return 0;
      }
      iVar1 = FUN_0001dd2c(param_1,0x2e,iVar1,0);
      *piVar2 = iVar1;
      if (iVar1 == 0) {
        return 0;
      }
      piVar2 = (int *)(iVar1 + 8);
    } while (**(byte **)(param_1 + 0xc) != param_2);
    *(byte **)(param_1 + 0xc) = *(byte **)(param_1 + 0xc) + 1;
  }
  return local_14;
}



void FUN_0001fe5c(int param_1,char *param_2)

{
  char cVar1;
  size_t sVar2;
  code *pcVar3;
  int iVar4;
  int iVar5;
  char *pcVar6;
  
  sVar2 = strlen(param_2);
  if (sVar2 != 0) {
    pcVar6 = param_2 + sVar2;
    iVar5 = *(int *)(param_1 + 0x100);
    do {
      cVar1 = *param_2;
      if (iVar5 == 0xff) {
        *(undefined1 *)(param_1 + 0xff) = 0;
        pcVar3 = *(code **)(param_1 + 0x108);
        (*pcVar3)(param_1,0xff,*(undefined4 *)(param_1 + 0x10c),pcVar3,pcVar3,
                  *(undefined4 *)(param_1 + 0x10c));
        *(int *)(param_1 + 0x120) = *(int *)(param_1 + 0x120) + 1;
        iVar4 = 1;
        iVar5 = 0;
      }
      else {
        iVar4 = iVar5 + 1;
      }
      *(int *)(param_1 + 0x100) = iVar4;
      *(char *)(param_1 + iVar5) = cVar1;
      param_2 = param_2 + 1;
      *(char *)(param_1 + 0x104) = cVar1;
      iVar5 = iVar4;
    } while (param_2 != pcVar6);
  }
  return;
}


/*
Unable to decompile 'FUN_0001fee4'
Cause: 
Low-level Error: Error recovering jumptable: Bad partial clone
*/


void FUN_00023d64(int param_1,undefined4 param_2,int *param_3)

{
  undefined1 uVar1;
  int iVar2;
  code *pcVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  
  if (*param_3 == 0x31) {
    iVar2 = *(int *)(param_3[1] + 4);
    iVar7 = *(int *)(param_3[1] + 8);
    if (iVar7 != 0) {
      iVar6 = 0;
      iVar5 = *(int *)(param_1 + 0x100);
      do {
        uVar1 = *(undefined1 *)(iVar2 + iVar6);
        if (iVar5 == 0xff) {
          *(undefined1 *)(param_1 + 0xff) = 0;
          pcVar3 = *(code **)(param_1 + 0x108);
          (*pcVar3)(param_1,0xff,*(undefined4 *)(param_1 + 0x10c),pcVar3,pcVar3,
                    *(undefined4 *)(param_1 + 0x10c));
          *(int *)(param_1 + 0x120) = *(int *)(param_1 + 0x120) + 1;
          iVar4 = 1;
          iVar5 = 0;
        }
        else {
          iVar4 = iVar5 + 1;
        }
        *(int *)(param_1 + 0x100) = iVar4;
        *(undefined1 *)(param_1 + iVar5) = uVar1;
        iVar6 = iVar6 + 1;
        *(undefined1 *)(param_1 + 0x104) = uVar1;
        iVar5 = iVar4;
      } while (iVar7 != iVar6);
    }
  }
  else if (*(int *)(param_1 + 0x118) == 0) {
    FUN_0001fee4();
  }
  return;
}



void FUN_00023e08(int param_1,undefined4 param_2,uint *param_3,undefined4 param_4)

{
  bool bVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  
  uVar3 = *param_3;
  if (((uVar3 < 2) || (uVar3 == 0x30)) || (uVar3 == 6)) {
    iVar4 = *(int *)(param_1 + 0x118);
    bVar1 = true;
  }
  else {
    iVar4 = *(int *)(param_1 + 0x100);
    if (iVar4 == 0xff) {
      *(bool *)(param_1 + 0xff) = uVar3 == 0x30;
      (**(code **)(param_1 + 0x108))
                (param_1,0xff,*(undefined4 *)(param_1 + 0x10c),*(code **)(param_1 + 0x108),param_4);
      *(int *)(param_1 + 0x120) = *(int *)(param_1 + 0x120) + 1;
      iVar2 = 1;
      iVar4 = 0;
    }
    else {
      iVar2 = iVar4 + 1;
    }
    *(int *)(param_1 + 0x100) = iVar2;
    *(undefined1 *)(param_1 + iVar4) = 0x28;
    *(undefined1 *)(param_1 + 0x104) = 0x28;
    iVar4 = *(int *)(param_1 + 0x118);
    bVar1 = false;
  }
  if (iVar4 == 0) {
    FUN_0001fee4(param_1,param_2,param_3);
    if (bVar1) {
      return;
    }
  }
  else if (bVar1) {
    return;
  }
  iVar4 = *(int *)(param_1 + 0x100);
  if (iVar4 == 0xff) {
    *(bool *)(param_1 + 0xff) = bVar1;
    (**(code **)(param_1 + 0x108))(param_1,0xff,*(undefined4 *)(param_1 + 0x10c));
    iVar2 = 1;
    *(int *)(param_1 + 0x120) = *(int *)(param_1 + 0x120) + 1;
    iVar4 = 0;
  }
  else {
    iVar2 = iVar4 + 1;
  }
  *(int *)(param_1 + 0x100) = iVar2;
  *(undefined1 *)(param_1 + iVar4) = 0x29;
  *(undefined1 *)(param_1 + 0x104) = 0x29;
  return;
}



bool FUN_00023ed4(char *param_1,code *param_2,undefined4 param_3)

{
  char cVar1;
  int iVar2;
  size_t sVar3;
  undefined4 uVar4;
  char cVar5;
  char *pcVar6;
  uint uVar7;
  bool bVar8;
  undefined1 auStack_188 [4];
  undefined4 local_184;
  char *local_180;
  char *local_17c;
  uint local_178;
  char *local_174;
  undefined1 *local_170;
  undefined4 local_16c;
  int local_168;
  int local_164;
  undefined4 local_160;
  size_t local_15c;
  undefined4 local_158;
  undefined4 local_154;
  undefined4 local_150;
  undefined1 auStack_14c [256];
  int iStack_4c;
  undefined1 uStack_48;
  code *pcStack_44;
  undefined4 uStack_40;
  undefined4 uStack_3c;
  undefined4 uStack_38;
  int iStack_34;
  undefined4 uStack_30;
  undefined4 uStack_2c;
  
  cVar5 = *param_1;
  local_184 = param_3;
  if ((cVar5 == '_') && (param_1[1] == 'Z')) {
    uVar7 = 1;
  }
  else {
    iVar2 = strncmp(param_1,"_GLOBAL_",8);
    uVar7 = 0;
    if ((iVar2 == 0) && (((cVar1 = param_1[8], cVar1 == '.' || (cVar1 == '_')) || (cVar1 == '$'))))
    {
      cVar1 = param_1[9];
      if (((cVar1 == 'I') || (uVar7 = 0, cVar1 == 'D')) && (uVar7 = 0, param_1[10] == '_')) {
        uVar7 = (cVar1 != 'I') + 2;
      }
    }
  }
  local_15c = strlen(param_1);
  local_17c = param_1 + local_15c;
  local_168 = local_15c * 2;
  local_178 = 0x11;
  local_16c = 0;
  local_160 = 0;
  local_158 = 0;
  local_154 = 0;
  local_150 = 0;
  local_170 = auStack_188 + -(local_15c * 0x18 + 8);
  local_164 = (int)local_170 - (local_15c * 4 + 10 & 0xfffffff8);
  local_180 = param_1;
  local_174 = param_1;
  if (uVar7 == 1) {
    if (cVar5 == '_') {
      local_174 = param_1 + 1;
      cVar5 = param_1[1];
      if (cVar5 == 'Z') {
        local_174 = param_1 + 2;
        iVar2 = FUN_0001f184(&local_180,1);
        if ((local_178 & 1) == 0) {
LAB_000240b2:
          cVar5 = *local_174;
        }
        else {
          cVar5 = *local_174;
          while (cVar5 == '.') {
            cVar5 = local_174[1];
            if (((0x19 < (byte)(cVar5 + 0x9fU)) && (cVar5 != '_')) && (9 < (byte)(cVar5 - 0x30U)))
            goto LAB_000240b2;
            iVar2 = FUN_0001df1c(&local_180,iVar2);
            cVar5 = *local_174;
          }
        }
      }
      else {
        iVar2 = 0;
      }
    }
    else {
      iVar2 = 0;
    }
  }
  else if ((uVar7 == 0) || (3 < uVar7)) {
    iVar2 = FUN_0001e97c(&local_180);
    cVar5 = *local_174;
  }
  else {
    pcVar6 = param_1 + 0xb;
    if ((param_1[0xb] == '_') && (param_1[0xc] == 'Z')) {
      local_174 = param_1 + 0xd;
      uVar4 = FUN_0001f184(&local_180,0);
    }
    else {
      local_174 = pcVar6;
      sVar3 = strlen(pcVar6);
      uVar4 = FUN_0001ddc8(&local_180,pcVar6,sVar3);
    }
    iVar2 = FUN_0001dd2c(&local_180,(((uVar7 - 2) - (uVar7 - 3)) - (uint)(uVar7 - 2 == 0)) + 0x42,
                         uVar4,0);
    pcVar6 = local_174;
    sVar3 = strlen(local_174);
    local_174 = pcVar6 + sVar3;
    cVar5 = *local_174;
  }
  bVar8 = false;
  if (cVar5 == '\0') {
    if (iVar2 == 0) {
      bVar8 = false;
    }
    else {
      iStack_4c = 0;
      uStack_48 = 0;
      uStack_3c = 0;
      uStack_38 = 0;
      uStack_30 = 0;
      uStack_2c = 0;
      uStack_40 = local_184;
      iStack_34 = 0;
      pcStack_44 = param_2;
      FUN_0001fee4(auStack_14c,0x11,iVar2);
      iVar2 = iStack_4c;
      auStack_14c[iStack_4c] = 0;
      (*pcStack_44)(auStack_14c,iVar2,uStack_40);
      bVar8 = iStack_34 == 0;
    }
  }
  return bVar8;
}



char * __cxa_demangle(int param_1,char *param_2,uint *param_3,int *param_4)

{
  int iVar1;
  size_t sVar2;
  char *__src;
  uint uVar3;
  char *local_28;
  undefined4 local_24;
  uint local_20;
  int local_1c;
  
  if ((param_1 == 0) || ((param_2 != (char *)0x0 && (param_3 == (uint *)0x0)))) {
    if (param_4 == (int *)0x0) {
      return (char *)0x0;
    }
    *param_4 = -3;
    return (char *)0x0;
  }
  local_28 = (char *)0x0;
  local_24 = 0;
  local_20 = 0;
  local_1c = 0;
  iVar1 = FUN_00023ed4(param_1,0x1e46d,&local_28);
  __src = local_28;
  if (iVar1 == 0) {
    free(local_28);
    if (param_4 == (int *)0x0) {
      return (char *)0x0;
    }
  }
  else {
    uVar3 = 1;
    if (local_1c == 0) {
      uVar3 = local_20;
    }
    if (local_28 != (char *)0x0) {
      if (param_2 == (char *)0x0) {
        if (param_3 == (uint *)0x0) goto LAB_00024184;
      }
      else {
        sVar2 = strlen(local_28);
        if (sVar2 < *param_3) {
          memcpy(param_2,__src,sVar2 + 1);
          free(__src);
          __src = param_2;
          goto LAB_00024184;
        }
        free(param_2);
      }
      *param_3 = uVar3;
LAB_00024184:
      if (param_4 != (int *)0x0) {
        *param_4 = 0;
        return __src;
      }
      return __src;
    }
    if (param_4 == (int *)0x0) {
      return (char *)0x0;
    }
    if (uVar3 == 1) {
      iVar1 = 1;
      goto LAB_000241a2;
    }
  }
  iVar1 = 2;
LAB_000241a2:
  *param_4 = -iVar1;
  return (char *)0x0;
}



undefined4 __gcclibcxx_demangle_callback(int param_1,int param_2)

{
  int iVar1;
  undefined4 uVar2;
  
  if ((param_1 == 0) || (param_2 == 0)) {
    uVar2 = 0xfffffffd;
  }
  else {
    iVar1 = FUN_00023ed4();
    uVar2 = 0;
    if (iVar1 == 0) {
      uVar2 = 0xfffffffe;
    }
  }
  return uVar2;
}



int * __cxa_current_exception_type(void)

{
  undefined4 *puVar1;
  int *piVar2;
  
  puVar1 = (undefined4 *)__cxa_get_globals();
  piVar2 = (int *)*puVar1;
  if (piVar2 != (int *)0x0) {
    if (*(char *)((int)piVar2 + 0x27) == '\x01') {
      piVar2 = (int *)(*piVar2 + -0x78);
    }
    piVar2 = (int *)*piVar2;
  }
  return piVar2;
}



// WARNING: This is an inlined function

void __gnu_thumb1_case_sqi(void)

{
  return;
}



// WARNING: This is an inlined function

void __gnu_thumb1_case_uqi(void)

{
  return;
}



// WARNING: This is an inlined function

undefined8 __gnu_thumb1_case_shi(undefined4 param_1,undefined4 param_2)

{
  return CONCAT44(param_2,param_1);
}



// WARNING: This is an inlined function

undefined8 __gnu_thumb1_case_uhi(undefined4 param_1,undefined4 param_2)

{
  return CONCAT44(param_2,param_1);
}



// WARNING: This is an inlined function

undefined8 __gnu_thumb1_case_si(undefined4 param_1,undefined4 param_2)

{
  return CONCAT44(param_2,param_1);
}



int FUN_00024278(uint *param_1)

{
  uint uVar1;
  
  uVar1 = *param_1;
  if ((int)(uVar1 << 1) < 0) {
    uVar1 = uVar1 | 0x80000000;
  }
  else {
    uVar1 = uVar1 & 0x7fffffff;
  }
  return (int)param_1 + uVar1;
}



int FUN_0002428a(int param_1,int param_2,uint param_3)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  
  if (param_2 == 0) {
    return 0;
  }
  iVar5 = 0;
  iVar6 = param_2 + -1;
LAB_0002429c:
  do {
    iVar3 = (iVar5 + iVar6) / 2;
    iVar4 = param_1 + iVar3 * 8;
    uVar1 = FUN_00024278(iVar4);
    if (iVar3 == param_2 + -1) {
      if (uVar1 <= param_3) {
        return iVar4;
      }
    }
    else {
      iVar2 = FUN_00024278(iVar3 * 8 + 8 + param_1);
      if (uVar1 <= param_3) {
        if (param_3 <= iVar2 - 1U) {
          return iVar4;
        }
        iVar5 = iVar3 + 1;
        goto LAB_0002429c;
      }
    }
    if (iVar3 == iVar5) {
      return 0;
    }
    iVar6 = iVar3 + -1;
  } while( true );
}



undefined4 FUN_000242f2(int param_1)

{
  if (param_1 == 1) {
    return 0x24991;
  }
  if (param_1 != 2) {
    if (param_1 == 0) {
      return 0x2498d;
    }
    return 0;
  }
  return 0x24995;
}



// WARNING: Removing unreachable block (ram,0x00024340)

undefined4 FUN_00024324(int param_1,int param_2,undefined4 param_3)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  int local_14;
  
  local_14 = param_2;
  iVar1 = __gnu_Unwind_Find_exidx(param_2 + -2,&local_14,param_3,__gnu_Unwind_Find_exidx,param_1);
  if (iVar1 == 0) {
    iVar1 = 0;
  }
  else {
    iVar1 = FUN_0002428a(iVar1,local_14,param_2 + -2);
    if (iVar1 != 0) {
      uVar2 = FUN_00024278();
      iVar3 = *(int *)(iVar1 + 4);
      *(undefined4 *)(param_1 + 0x48) = uVar2;
      if (iVar3 == 1) {
        *(undefined4 *)(param_1 + 0x10) = 0;
        return 5;
      }
      if (-1 < iVar3) {
        uVar2 = FUN_00024278();
        *(undefined4 *)(param_1 + 0x4c) = uVar2;
      }
      else {
        *(int *)(param_1 + 0x4c) = iVar1 + 4;
      }
      *(uint *)(param_1 + 0x50) = (uint)(-1 >= iVar3);
      if (**(int **)(param_1 + 0x4c) < 0) {
        iVar1 = FUN_000242f2((uint)(**(int **)(param_1 + 0x4c) << 4) >> 0x1c);
        *(int *)(param_1 + 0x10) = iVar1;
        if (iVar1 != 0) {
          return 0;
        }
        return 9;
      }
      uVar2 = FUN_00024278();
      *(undefined4 *)(param_1 + 0x10) = uVar2;
      return 0;
    }
  }
  *(int *)(param_1 + 0x10) = iVar1;
  return 9;
}



void FUN_000243c8(uint *param_1)

{
  if (-1 < (int)(*param_1 << 0x1f)) {
    if ((*param_1 & 2) == 0) {
      __gnu_Unwind_Restore_VFP(param_1 + 0x12);
    }
    else {
      __gnu_Unwind_Restore_VFP_D();
    }
  }
  if (-1 < (int)(*param_1 << 0x1d)) {
    __gnu_Unwind_Restore_VFP_D_16_to_31(param_1 + 0x34);
  }
  if (-1 < (int)(*param_1 << 0x1c)) {
    __gnu_Unwind_Restore_WMMXD(param_1 + 0x54);
  }
  if (-1 < (int)(*param_1 << 0x1b)) {
    __gnu_Unwind_Restore_WMMXC(param_1 + 0x74);
    return;
  }
  return;
}



undefined4 FUN_00024416(int *param_1)

{
  if (*param_1 != 0) {
    return *(undefined4 *)(*param_1 + (int)param_1);
  }
  return 0;
}



undefined4 FUN_00024422(void)

{
  return 9;
}



void FUN_00024426(void)

{
  return;
}



int FUN_00024428(int param_1,int param_2)

{
  int iVar1;
  int iVar2;
  int iVar3;
  code *pcVar4;
  undefined4 uVar5;
  uint uVar6;
  int iVar7;
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
    iVar1 = FUN_00024324(param_1,*(undefined4 *)(param_2 + 0x40));
    if (iVar1 != 0) goto LAB_0002443a;
    *(undefined4 *)(param_1 + 0x14) = *(undefined4 *)(param_2 + 0x40);
    iVar1 = param_2;
    iVar2 = (**(code **)(param_1 + 0x10))(1,param_1);
  } while (iVar2 == 8);
  if (iVar2 == 7) {
    FUN_00024426(0,*(undefined4 *)(param_2 + 0x40));
    uVar8 = restore_core_regs(param_2 + 4);
    iVar7 = (int)((ulonglong)uVar8 >> 0x20);
    iVar2 = (int)uVar8;
    pcVar4 = *(code **)(iVar2 + 0xc);
    uVar5 = *(undefined4 *)(iVar2 + 0x18);
    uStack_3f4 = *(undefined4 *)(iVar7 + 4);
    uStack_3f0 = *(undefined4 *)(iVar7 + 8);
    uStack_3ec = *(undefined4 *)(iVar7 + 0xc);
    uStack_3e8 = *(undefined4 *)(iVar7 + 0x10);
    uStack_3e4 = *(undefined4 *)(iVar7 + 0x14);
    uStack_3e0 = *(undefined4 *)(iVar7 + 0x18);
    uStack_3dc = *(undefined4 *)(iVar7 + 0x1c);
    uStack_3d8 = *(undefined4 *)(iVar7 + 0x20);
    uStack_3d4 = *(undefined4 *)(iVar7 + 0x24);
    uStack_3d0 = *(undefined4 *)(iVar7 + 0x28);
    uStack_3cc = *(undefined4 *)(iVar7 + 0x2c);
    uStack_3c8 = *(undefined4 *)(iVar7 + 0x30);
    uStack_3c4 = *(undefined4 *)(iVar7 + 0x34);
    uStack_3c0 = *(undefined4 *)(iVar7 + 0x38);
    uStack_3bc = *(undefined4 *)(iVar7 + 0x3c);
    uStack_3b8 = *(undefined4 *)(iVar7 + 0x40);
    iVar7 = 0;
    uStack_3f8 = 0;
    uStack_2c = 0;
    iStack_34 = param_2;
    iStack_30 = param_1;
    while( true ) {
      iVar3 = FUN_00024324(iVar2,uStack_3b8);
      if (iVar1 == 0) {
        uVar6 = 9;
      }
      else {
        uVar6 = 10;
      }
      if (iVar3 == 0) {
        *(undefined4 *)(iVar2 + 0x14) = uStack_3b8;
        memcpy(auStack_218,&uStack_3f8,0x1e0);
        iVar7 = (**(code **)(iVar2 + 0x10))(uVar6,iVar2,auStack_218);
        uStack_3b4 = uStack_1e0;
      }
      else {
        uVar6 = uVar6 | 0x10;
        uStack_3b4 = uStack_3c0;
      }
      iVar1 = (*pcVar4)(1,uVar6,iVar2,iVar2,&uStack_3f8,uVar5);
      if (iVar1 != 0) {
        return 9;
      }
      if (iVar3 != 0) {
        return iVar3;
      }
      memcpy(&uStack_3f8,auStack_218,0x1e0);
      if (iVar7 != 8) break;
      iVar1 = 0;
    }
    if (iVar7 == 7) {
      FUN_00024426(0,uStack_3b8);
      restore_core_regs(&uStack_3f4);
    }
    return 9;
  }
LAB_0002443a:
                    // WARNING: Subroutine does not return
  abort();
}



int FUN_00024462(int param_1,int param_2,int param_3)

{
  int iVar1;
  int iVar2;
  code *pcVar3;
  undefined4 uVar4;
  uint uVar5;
  int iVar6;
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
  undefined4 local_3b0;
  undefined4 uStack_3ac;
  undefined4 local_3a8;
  undefined4 local_3a4;
  undefined1 auStack_208 [56];
  undefined4 local_1d0;
  
  pcVar3 = *(code **)(param_1 + 0xc);
  uVar4 = *(undefined4 *)(param_1 + 0x18);
  local_3e4 = *(undefined4 *)(param_2 + 4);
  uStack_3e0 = *(undefined4 *)(param_2 + 8);
  uStack_3dc = *(undefined4 *)(param_2 + 0xc);
  uStack_3d8 = *(undefined4 *)(param_2 + 0x10);
  local_3d4 = *(undefined4 *)(param_2 + 0x14);
  uStack_3d0 = *(undefined4 *)(param_2 + 0x18);
  uStack_3cc = *(undefined4 *)(param_2 + 0x1c);
  uStack_3c8 = *(undefined4 *)(param_2 + 0x20);
  local_3c4 = *(undefined4 *)(param_2 + 0x24);
  uStack_3c0 = *(undefined4 *)(param_2 + 0x28);
  uStack_3bc = *(undefined4 *)(param_2 + 0x2c);
  uStack_3b8 = *(undefined4 *)(param_2 + 0x30);
  local_3b4 = *(undefined4 *)(param_2 + 0x34);
  local_3b0 = *(undefined4 *)(param_2 + 0x38);
  uStack_3ac = *(undefined4 *)(param_2 + 0x3c);
  local_3a8 = *(undefined4 *)(param_2 + 0x40);
  iVar6 = 0;
  local_3e8 = 0;
  while( true ) {
    iVar1 = FUN_00024324(param_1,local_3a8);
    if (param_3 == 0) {
      uVar5 = 9;
    }
    else {
      uVar5 = 10;
    }
    if (iVar1 == 0) {
      *(undefined4 *)(param_1 + 0x14) = local_3a8;
      memcpy(auStack_208,&local_3e8,0x1e0);
      iVar6 = (**(code **)(param_1 + 0x10))(uVar5,param_1,auStack_208);
      local_3a4 = local_1d0;
    }
    else {
      uVar5 = uVar5 | 0x10;
      local_3a4 = local_3b0;
    }
    iVar2 = (*pcVar3)(1,uVar5,param_1,param_1,&local_3e8,uVar4);
    if (iVar2 != 0) {
      return 9;
    }
    if (iVar1 != 0) {
      return iVar1;
    }
    memcpy(&local_3e8,auStack_208,0x1e0);
    if (iVar6 != 8) break;
    param_3 = 0;
  }
  if (iVar6 == 7) {
    FUN_00024426(0,local_3a8);
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
    iVar1 = FUN_00024324(param_1,local_1b8);
    if (iVar1 != 0) {
      return 9;
    }
    iVar1 = (**(code **)(param_1 + 0x10))(0,param_1,&local_1f8);
  } while (iVar1 == 8);
  FUN_000243c8(&local_1f8);
  if (iVar1 == 6) {
    FUN_00024428(param_1,param_2);
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
  FUN_00024462(param_1,param_4,0);
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
      if (iVar1 != 8) goto LAB_000245dc;
      FUN_00024428(param_1,param_2);
    }
    FUN_00024426(0,*(undefined4 *)(param_2 + 0x40));
    restore_core_regs(param_2 + 4);
  }
  else {
    FUN_00024462(param_1,param_2,1);
  }
LAB_000245dc:
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
  FUN_00024462(param_1,param_2,0);
  return;
}



void _Unwind_Complete(void)

{
  return;
}



void _Unwind_DeleteException(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  code *pcVar1;
  
  pcVar1 = *(code **)(param_1 + 8);
  if (pcVar1 != (code *)0x0) {
    (*pcVar1)(1,param_1,param_3,pcVar1,param_4);
  }
  return;
}



undefined4
_Unwind_VRS_Get(int param_1,undefined4 param_2,uint param_3,int param_4,undefined4 *param_5)

{
  switch(param_2) {
  case 0:
    if ((param_4 == 0) && (param_3 < 0x10)) {
      *param_5 = *(undefined4 *)(param_1 + param_3 * 4 + 4);
      return 0;
    }
    break;
  case 1:
  case 3:
  case 4:
    return 1;
  }
  return 2;
}



undefined4 FUN_0002462c(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 local_c;
  
  local_c = param_4;
  _Unwind_VRS_Get(param_1,0,param_2,0,&local_c,param_2,param_3);
  return local_c;
}



undefined4
_Unwind_VRS_Set(int param_1,undefined4 param_2,uint param_3,int param_4,undefined4 *param_5)

{
  switch(param_2) {
  case 0:
    if ((param_4 == 0) && (param_3 < 0x10)) {
      *(undefined4 *)(param_1 + param_3 * 4 + 4) = *param_5;
      return 0;
    }
    break;
  case 1:
  case 3:
  case 4:
    return 1;
  }
  return 2;
}



void FUN_00024670(undefined4 param_1,undefined4 param_2,undefined4 param_3)

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
    iVar1 = FUN_00024324(auStack_250,local_1b8);
    if (iVar1 != 0) break;
    FUN_00024670(&local_1f8,0xc,auStack_250);
    iVar1 = (*param_1)(&local_1f8,param_2);
    if (iVar1 != 0) break;
    iVar1 = (*local_240)(8,auStack_250,&local_1f8);
    if (iVar1 == 5) goto LAB_000246f4;
  } while (iVar1 != 9);
  iVar1 = 9;
LAB_000246f4:
  FUN_000243c8(&local_1f8);
  return iVar1;
}



// WARNING: Removing unreachable block (ram,0x00024778)
// WARNING: Removing unreachable block (ram,0x00024732)
// WARNING: Removing unreachable block (ram,0x00024736)
// WARNING: Removing unreachable block (ram,0x00024948)

undefined4 __aeabi_unwind_cpp_pr0(uint param_1,code *param_2,undefined4 param_3)

{
  ushort uVar1;
  bool bVar2;
  uint uVar3;
  uint *puVar4;
  undefined4 uVar5;
  int iVar6;
  code *pcVar7;
  uint uVar8;
  int iVar9;
  uint *puVar10;
  uint uVar11;
  bool bVar12;
  uint uVar13;
  bool bVar14;
  code *pcStack_38;
  int iStack_34;
  uint *puStack_30;
  undefined1 uStack_2c;
  undefined1 uStack_2b;
  
  puStack_30 = (uint *)(*(int **)(param_2 + 0x4c) + 1);
  uVar13 = param_1 & 3;
  iStack_34 = **(int **)(param_2 + 0x4c) << 8;
  uStack_2b = 0;
  uStack_2c = 3;
  puVar10 = puStack_30;
  if (uVar13 == 2) {
    puVar10 = *(uint **)(param_2 + 0x38);
  }
  if ((*(uint *)(param_2 + 0x50) & 1) == 0) {
    pcVar7 = param_2 + 0x58;
    bVar12 = false;
LAB_00024768:
    do {
      while( true ) {
        if (*puVar10 == 0) goto LAB_00024944;
        uVar11 = *puVar10;
        puVar4 = puVar10 + 1;
        uVar1 = *(ushort *)((int)puVar10 + 2);
        uVar8 = (uVar1 & 0xfffffffe) + *(int *)(param_2 + 0x48);
        uVar3 = FUN_0002462c(param_3,0xf);
        bVar14 = uVar3 < uVar8 + ((ushort)uVar11 & 0xfffffffe);
        bVar2 = uVar8 <= uVar3 && bVar14;
        uVar11 = (ushort)uVar11 & 1 | (uVar1 & 1) << 1;
        if (uVar11 != 1) break;
        if (uVar13 == 0) {
          if (bVar2) {
            uVar11 = *puVar4;
            if (puVar10[2] == 0xfffffffe) {
              return 9;
            }
            iVar6 = 1;
            pcStack_38 = pcVar7;
            if (puVar10[2] == 0xffffffff) {
LAB_0002483a:
              uVar5 = FUN_0002462c(param_3,0xd);
              *(undefined4 *)(param_2 + 0x20) = uVar5;
              if (iVar6 == 2) {
                pcVar7 = param_2 + 0x2c;
                *(code **)pcVar7 = pcStack_38;
LAB_000248ea:
                *(code **)(param_2 + 0x24) = pcVar7;
              }
              else {
                *(code **)(param_2 + 0x24) = pcStack_38;
              }
              *(uint **)(param_2 + 0x28) = puVar4;
              return 6;
            }
            uVar5 = FUN_00024416(puVar10 + 2);
            iVar6 = __cxa_type_match(param_2,uVar5,uVar11 >> 0x1f,&pcStack_38);
            if (iVar6 != 0) goto LAB_0002483a;
          }
        }
        else {
          iVar9 = *(int *)(param_2 + 0x20);
          iVar6 = FUN_0002462c(param_3,0xd);
          if ((iVar9 == iVar6) && (puVar4 == *(uint **)(param_2 + 0x28))) {
LAB_00024870:
            uVar5 = FUN_00024278(puVar4);
            FUN_00024670(param_3,0xf,uVar5);
            uVar5 = 0;
            pcVar7 = param_2;
            goto LAB_00024884;
          }
        }
        puVar10 = puVar10 + 3;
      }
      if (uVar11 != 0) {
        if (uVar11 != 2) {
          return 9;
        }
        uVar11 = *puVar4 & 0x7fffffff;
        if (uVar13 == 0) {
          if ((bVar2) && (((param_1 & 8) == 0 || (uVar11 == 0)))) {
            uVar3 = 0;
            do {
              if (uVar3 == uVar11) {
                uVar5 = FUN_0002462c(param_3,0xd);
                *(undefined4 *)(param_2 + 0x20) = uVar5;
                pcVar7 = pcStack_38;
                goto LAB_000248ea;
              }
              uVar3 = uVar3 + 1;
              pcStack_38 = pcVar7;
              uVar5 = FUN_00024416(puVar4 + uVar3);
              iVar6 = __cxa_type_match(param_2,uVar5,0,&pcStack_38);
            } while (iVar6 == 0);
          }
        }
        else {
          iVar9 = *(int *)(param_2 + 0x20);
          iVar6 = FUN_0002462c(param_3,0xd);
          if ((iVar9 == iVar6) && (puVar4 == *(uint **)(param_2 + 0x28))) {
            *(undefined4 *)(param_2 + 0x30) = 4;
            *(uint *)(param_2 + 0x28) = uVar11;
            *(undefined4 *)(param_2 + 0x2c) = 0;
            *(uint **)(param_2 + 0x34) = puVar10 + 2;
            if ((int)*puVar4 < 0) {
              puVar4 = puVar4 + uVar11 + 1;
              goto LAB_00024870;
            }
            bVar12 = true;
          }
        }
        if ((int)*puVar4 < 0) {
          puVar4 = puVar10 + 2;
        }
        puVar10 = puVar4 + uVar11 + 1;
        goto LAB_00024768;
      }
      puVar10 = puVar10 + 2;
    } while ((uVar13 == 0) || (uVar8 > uVar3 || !bVar14));
    pcVar7 = (code *)FUN_00024278(puVar4);
    *(uint **)(param_2 + 0x38) = puVar10;
    iVar6 = __cxa_begin_cleanup(param_2);
    if (iVar6 == 0) {
      return 9;
    }
    uVar5 = 0xf;
  }
  else {
    bVar12 = false;
LAB_00024944:
    iVar6 = __gnu_unwind_execute(param_3,&iStack_34);
    if (iVar6 != 0) {
      return 9;
    }
    if (!bVar12) {
      return 8;
    }
    uVar5 = FUN_0002462c(param_3,0xf);
    FUN_00024670(param_3,0xe,uVar5);
    uVar5 = 0xf;
    pcVar7 = (code *)0x18469;
  }
LAB_00024884:
  FUN_00024670(param_3,uVar5,pcVar7);
  return 7;
}



// WARNING: Removing unreachable block (ram,0x00024778)
// WARNING: Removing unreachable block (ram,0x00024722)
// WARNING: Removing unreachable block (ram,0x00024948)

undefined4 __aeabi_unwind_cpp_pr1(uint param_1,code *param_2,undefined4 param_3)

{
  ushort uVar1;
  bool bVar2;
  uint uVar3;
  uint *puVar4;
  undefined4 uVar5;
  int iVar6;
  code *pcVar7;
  uint uVar8;
  int iVar9;
  uint *puVar10;
  uint uVar11;
  bool bVar12;
  uint uVar13;
  bool bVar14;
  code *pcStack_38;
  int iStack_34;
  int *piStack_30;
  undefined1 uStack_2c;
  byte bStack_2b;
  
  piStack_30 = *(int **)(param_2 + 0x4c) + 1;
  uVar13 = param_1 & 3;
  iStack_34 = **(int **)(param_2 + 0x4c);
  bStack_2b = (byte)((uint)iStack_34 >> 0x10);
  iStack_34 = iStack_34 << 0x10;
  uStack_2c = 2;
  puVar10 = (uint *)(piStack_30 + bStack_2b);
  if (uVar13 == 2) {
    puVar10 = *(uint **)(param_2 + 0x38);
  }
  if ((*(uint *)(param_2 + 0x50) & 1) == 0) {
    pcVar7 = param_2 + 0x58;
    bVar12 = false;
LAB_00024768:
    do {
      while( true ) {
        if (*puVar10 == 0) goto LAB_00024944;
        uVar11 = *puVar10;
        puVar4 = puVar10 + 1;
        uVar1 = *(ushort *)((int)puVar10 + 2);
        uVar8 = (uVar1 & 0xfffffffe) + *(int *)(param_2 + 0x48);
        uVar3 = FUN_0002462c(param_3,0xf);
        bVar14 = uVar3 < uVar8 + ((ushort)uVar11 & 0xfffffffe);
        bVar2 = uVar8 <= uVar3 && bVar14;
        uVar11 = (ushort)uVar11 & 1 | (uVar1 & 1) << 1;
        if (uVar11 != 1) break;
        if (uVar13 == 0) {
          if (bVar2) {
            uVar11 = *puVar4;
            if (puVar10[2] == 0xfffffffe) {
              return 9;
            }
            iVar6 = 1;
            pcStack_38 = pcVar7;
            if (puVar10[2] == 0xffffffff) {
LAB_0002483a:
              uVar5 = FUN_0002462c(param_3,0xd);
              *(undefined4 *)(param_2 + 0x20) = uVar5;
              if (iVar6 == 2) {
                pcVar7 = param_2 + 0x2c;
                *(code **)pcVar7 = pcStack_38;
LAB_000248ea:
                *(code **)(param_2 + 0x24) = pcVar7;
              }
              else {
                *(code **)(param_2 + 0x24) = pcStack_38;
              }
              *(uint **)(param_2 + 0x28) = puVar4;
              return 6;
            }
            uVar5 = FUN_00024416(puVar10 + 2);
            iVar6 = __cxa_type_match(param_2,uVar5,uVar11 >> 0x1f,&pcStack_38);
            if (iVar6 != 0) goto LAB_0002483a;
          }
        }
        else {
          iVar9 = *(int *)(param_2 + 0x20);
          iVar6 = FUN_0002462c(param_3,0xd);
          if ((iVar9 == iVar6) && (puVar4 == *(uint **)(param_2 + 0x28))) {
LAB_00024870:
            uVar5 = FUN_00024278(puVar4);
            FUN_00024670(param_3,0xf,uVar5);
            uVar5 = 0;
            pcVar7 = param_2;
            goto LAB_00024884;
          }
        }
        puVar10 = puVar10 + 3;
      }
      if (uVar11 != 0) {
        if (uVar11 != 2) {
          return 9;
        }
        uVar11 = *puVar4 & 0x7fffffff;
        if (uVar13 == 0) {
          if ((bVar2) && (((param_1 & 8) == 0 || (uVar11 == 0)))) {
            uVar3 = 0;
            do {
              if (uVar3 == uVar11) {
                uVar5 = FUN_0002462c(param_3,0xd);
                *(undefined4 *)(param_2 + 0x20) = uVar5;
                pcVar7 = pcStack_38;
                goto LAB_000248ea;
              }
              uVar3 = uVar3 + 1;
              pcStack_38 = pcVar7;
              uVar5 = FUN_00024416(puVar4 + uVar3);
              iVar6 = __cxa_type_match(param_2,uVar5,0,&pcStack_38);
            } while (iVar6 == 0);
          }
        }
        else {
          iVar9 = *(int *)(param_2 + 0x20);
          iVar6 = FUN_0002462c(param_3,0xd);
          if ((iVar9 == iVar6) && (puVar4 == *(uint **)(param_2 + 0x28))) {
            *(undefined4 *)(param_2 + 0x30) = 4;
            *(uint *)(param_2 + 0x28) = uVar11;
            *(undefined4 *)(param_2 + 0x2c) = 0;
            *(uint **)(param_2 + 0x34) = puVar10 + 2;
            if ((int)*puVar4 < 0) {
              puVar4 = puVar4 + uVar11 + 1;
              goto LAB_00024870;
            }
            bVar12 = true;
          }
        }
        if ((int)*puVar4 < 0) {
          puVar4 = puVar10 + 2;
        }
        puVar10 = puVar4 + uVar11 + 1;
        goto LAB_00024768;
      }
      puVar10 = puVar10 + 2;
    } while ((uVar13 == 0) || (uVar8 > uVar3 || !bVar14));
    pcVar7 = (code *)FUN_00024278(puVar4);
    *(uint **)(param_2 + 0x38) = puVar10;
    iVar6 = __cxa_begin_cleanup(param_2);
    if (iVar6 == 0) {
      return 9;
    }
    uVar5 = 0xf;
  }
  else {
    bVar12 = false;
LAB_00024944:
    iVar6 = __gnu_unwind_execute(param_3,&iStack_34);
    if (iVar6 != 0) {
      return 9;
    }
    if (!bVar12) {
      return 8;
    }
    uVar5 = FUN_0002462c(param_3,0xf);
    FUN_00024670(param_3,0xe,uVar5);
    uVar5 = 0xf;
    pcVar7 = (code *)0x18469;
  }
LAB_00024884:
  FUN_00024670(param_3,uVar5,pcVar7);
  return 7;
}



// WARNING: Removing unreachable block (ram,0x0002477e)
// WARNING: Removing unreachable block (ram,0x00024722)
// WARNING: Removing unreachable block (ram,0x00024948)

undefined4 __aeabi_unwind_cpp_pr2(uint param_1,code *param_2,undefined4 param_3)

{
  bool bVar1;
  uint uVar2;
  uint *puVar3;
  undefined4 uVar4;
  int iVar5;
  code *pcVar6;
  uint uVar7;
  uint uVar8;
  int iVar9;
  uint *puVar10;
  uint uVar11;
  bool bVar12;
  uint uVar13;
  bool bVar14;
  code *local_38;
  int local_34;
  int *local_30;
  undefined1 local_2c;
  byte local_2b;
  
  local_30 = *(int **)(param_2 + 0x4c) + 1;
  uVar13 = param_1 & 3;
  local_34 = **(int **)(param_2 + 0x4c);
  local_2b = (byte)((uint)local_34 >> 0x10);
  local_34 = local_34 << 0x10;
  local_2c = 2;
  puVar10 = (uint *)(local_30 + local_2b);
  if (uVar13 == 2) {
    puVar10 = *(uint **)(param_2 + 0x38);
  }
  if ((*(uint *)(param_2 + 0x50) & 1) == 0) {
    pcVar6 = param_2 + 0x58;
    bVar12 = false;
LAB_00024768:
    do {
      while( true ) {
        uVar11 = *puVar10;
        if (uVar11 == 0) goto LAB_00024944;
        uVar8 = puVar10[1];
        puVar3 = puVar10 + 2;
        uVar7 = (uVar8 & 0xfffffffe) + *(int *)(param_2 + 0x48);
        uVar2 = FUN_0002462c(param_3,0xf);
        bVar14 = uVar2 < uVar7 + (uVar11 & 0xfffffffe);
        bVar1 = uVar7 <= uVar2 && bVar14;
        uVar11 = uVar11 & 1 | (uVar8 & 1) << 1;
        if (uVar11 != 1) break;
        if (uVar13 == 0) {
          if (bVar1) {
            uVar11 = *puVar3;
            if (puVar10[3] == 0xfffffffe) {
              return 9;
            }
            iVar5 = 1;
            local_38 = pcVar6;
            if (puVar10[3] == 0xffffffff) {
LAB_0002483a:
              uVar4 = FUN_0002462c(param_3,0xd);
              *(undefined4 *)(param_2 + 0x20) = uVar4;
              if (iVar5 == 2) {
                pcVar6 = param_2 + 0x2c;
                *(code **)pcVar6 = local_38;
LAB_000248ea:
                *(code **)(param_2 + 0x24) = pcVar6;
              }
              else {
                *(code **)(param_2 + 0x24) = local_38;
              }
              *(uint **)(param_2 + 0x28) = puVar3;
              return 6;
            }
            uVar4 = FUN_00024416(puVar10 + 3);
            iVar5 = __cxa_type_match(param_2,uVar4,uVar11 >> 0x1f,&local_38);
            if (iVar5 != 0) goto LAB_0002483a;
          }
        }
        else {
          iVar9 = *(int *)(param_2 + 0x20);
          iVar5 = FUN_0002462c(param_3,0xd);
          if ((iVar9 == iVar5) && (puVar3 == *(uint **)(param_2 + 0x28))) {
LAB_00024870:
            uVar4 = FUN_00024278(puVar3);
            FUN_00024670(param_3,0xf,uVar4);
            uVar4 = 0;
            pcVar6 = param_2;
            goto LAB_00024884;
          }
        }
        puVar10 = puVar10 + 4;
      }
      if (uVar11 != 0) {
        if (uVar11 != 2) {
          return 9;
        }
        uVar11 = *puVar3 & 0x7fffffff;
        if (uVar13 == 0) {
          if ((bVar1) && (((param_1 & 8) == 0 || (uVar11 == 0)))) {
            uVar2 = 0;
            do {
              if (uVar2 == uVar11) {
                uVar4 = FUN_0002462c(param_3,0xd);
                *(undefined4 *)(param_2 + 0x20) = uVar4;
                pcVar6 = local_38;
                goto LAB_000248ea;
              }
              uVar2 = uVar2 + 1;
              local_38 = pcVar6;
              uVar4 = FUN_00024416(puVar3 + uVar2);
              iVar5 = __cxa_type_match(param_2,uVar4,0,&local_38);
            } while (iVar5 == 0);
          }
        }
        else {
          iVar9 = *(int *)(param_2 + 0x20);
          iVar5 = FUN_0002462c(param_3,0xd);
          if ((iVar9 == iVar5) && (puVar3 == *(uint **)(param_2 + 0x28))) {
            *(undefined4 *)(param_2 + 0x30) = 4;
            *(uint *)(param_2 + 0x28) = uVar11;
            *(undefined4 *)(param_2 + 0x2c) = 0;
            *(uint **)(param_2 + 0x34) = puVar10 + 3;
            if ((int)*puVar3 < 0) {
              puVar3 = puVar3 + uVar11 + 1;
              goto LAB_00024870;
            }
            bVar12 = true;
          }
        }
        if ((int)*puVar3 < 0) {
          puVar3 = puVar10 + 3;
        }
        puVar10 = puVar3 + uVar11 + 1;
        goto LAB_00024768;
      }
      puVar10 = puVar10 + 3;
    } while ((uVar13 == 0) || (uVar7 > uVar2 || !bVar14));
    pcVar6 = (code *)FUN_00024278(puVar3);
    *(uint **)(param_2 + 0x38) = puVar10;
    iVar5 = __cxa_begin_cleanup(param_2);
    if (iVar5 == 0) {
      return 9;
    }
    uVar4 = 0xf;
  }
  else {
    bVar12 = false;
LAB_00024944:
    iVar5 = __gnu_unwind_execute(param_3,&local_34);
    if (iVar5 != 0) {
      return 9;
    }
    if (!bVar12) {
      return 8;
    }
    uVar4 = FUN_0002462c(param_3,0xf);
    FUN_00024670(param_3,0xe,uVar4);
    uVar4 = 0xf;
    pcVar6 = (code *)0x18469;
  }
LAB_00024884:
  FUN_00024670(param_3,uVar4,pcVar6);
  return 7;
}



undefined4 _Unwind_VRS_Pop(uint *param_1,undefined4 param_2,uint param_3,uint param_4)

{
  undefined4 uVar1;
  undefined4 *puVar2;
  uint *puVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  int iVar7;
  uint uVar8;
  bool bVar9;
  undefined4 auStack_1a0 [32];
  undefined1 auStack_120 [128];
  undefined4 local_a0 [34];
  
  switch(param_2) {
  case 0:
    if (param_4 != 0) {
      return 2;
    }
    puVar3 = (uint *)param_1[0xe];
    uVar5 = 0;
    do {
      if ((1 << (uVar5 & 0xff) & param_3 & 0xffff) != 0) {
        uVar4 = *puVar3;
        puVar3 = puVar3 + 1;
        param_1[uVar5 + 1] = uVar4;
      }
      uVar5 = uVar5 + 1;
    } while (uVar5 != 0x10);
    if ((param_3 & 0x2000) != 0) {
      return 0;
    }
    param_1[0xe] = (uint)puVar3;
    return 0;
  case 1:
    if ((param_4 & 0xfffffffb) != 1) {
      return 2;
    }
    uVar4 = param_3 >> 0x10;
    param_3 = param_3 & 0xffff;
    uVar5 = param_3 + uVar4;
    if (param_4 == 1) {
      if (0x10 < uVar5) {
        return 2;
      }
      if (0xf < uVar4) {
        return 2;
      }
LAB_00024aea:
      uVar5 = 0;
LAB_00024aec:
      uVar6 = *param_1;
      if ((int)(uVar6 << 0x1f) < 0) {
        *param_1 = uVar6 & 0xfffffffe;
        if (param_4 == 5) {
          *param_1 = uVar6 & 0xfffffffe | 2;
          __gnu_Unwind_Save_VFP_D();
        }
        else {
          *param_1 = uVar6 & 0xfffffffc;
          __gnu_Unwind_Save_VFP(param_1 + 0x12);
        }
      }
    }
    else {
      if (0x20 < uVar5) {
        return 2;
      }
      if (uVar4 < 0x10) {
        if (uVar5 < 0x11) goto LAB_00024aea;
        uVar5 = uVar5 - 0x10;
      }
      else {
        uVar5 = param_3;
        if (param_3 == 0) goto LAB_00024b50;
      }
      if (param_4 != 5) {
        return 2;
      }
      if (uVar4 < 0x10) goto LAB_00024aec;
    }
    if ((uVar5 != 0) && ((int)(*param_1 << 0x1d) < 0)) {
      *param_1 = *param_1 & 0xfffffffb;
      __gnu_Unwind_Save_VFP_D_16_to_31(param_1 + 0x34);
    }
    if (param_4 == 1) {
      __gnu_Unwind_Save_VFP(local_a0);
      if (uVar5 == 0) goto LAB_00024b50;
    }
    else {
      if (uVar4 < 0x10) {
        __gnu_Unwind_Save_VFP_D(local_a0);
      }
      if (uVar5 == 0) goto LAB_00024b50;
      __gnu_Unwind_Save_VFP_D_16_to_31(auStack_120);
    }
    param_3 = 0x10 - uVar4;
LAB_00024b50:
    uVar6 = param_1[0xe];
    if (0 < (int)param_3) {
      iVar7 = param_3 << 1;
      puVar2 = (undefined4 *)(uVar6 - 4);
      while (bVar9 = iVar7 != 0, iVar7 = iVar7 + -1, bVar9) {
        puVar2 = puVar2 + 1;
        *(undefined4 *)((int)local_a0 + (uVar4 * 8 - uVar6) + (int)puVar2) = *puVar2;
      }
      uVar6 = uVar6 + param_3 * 8;
    }
    if (uVar5 != 0) {
      uVar8 = uVar4;
      if (uVar4 < 0x10) {
        uVar8 = 0x10;
      }
      iVar7 = 0;
      do {
        auStack_1a0[uVar8 * 2 + iVar7] = *(undefined4 *)(uVar6 + iVar7 * 4);
        iVar7 = iVar7 + 1;
      } while (iVar7 != uVar5 * 2);
      uVar6 = uVar6 + iVar7 * 4;
    }
    if (param_4 == 1) {
      uVar6 = uVar6 + 4;
    }
    param_1[0xe] = uVar6;
    if (param_4 == 1) {
      __gnu_Unwind_Restore_VFP(local_a0);
    }
    else {
      if (uVar4 < 0x10) {
        __gnu_Unwind_Restore_VFP_D(local_a0);
      }
      if (uVar5 != 0) {
        __gnu_Unwind_Restore_VFP_D_16_to_31(auStack_120);
      }
    }
    return 0;
  case 3:
    if (param_4 == 3) {
      uVar5 = param_3 & 0xffff;
      if (uVar5 + (param_3 >> 0x10) < 0x11) {
        if ((int)(*param_1 << 0x1c) < 0) {
          *param_1 = *param_1 & 0xfffffff7;
          __gnu_Unwind_Save_WMMXD(param_1 + 0x54);
        }
        iVar7 = uVar5 << 1;
        __gnu_Unwind_Save_WMMXD(local_a0);
        uVar4 = param_1[0xe];
        puVar2 = (undefined4 *)(uVar4 - 4);
        while (bVar9 = iVar7 != 0, iVar7 = iVar7 + -1, bVar9) {
          puVar2 = puVar2 + 1;
          *(undefined4 *)((int)local_a0 + ((param_3 >> 0x10) * 8 - uVar4) + (int)puVar2) = *puVar2;
        }
        param_1[0xe] = uVar4 + uVar5 * 8;
        __gnu_Unwind_Restore_WMMXD(local_a0);
        return 0;
      }
    }
    break;
  case 4:
    if ((param_4 == 0) && (param_3 < 0x11)) {
      if ((int)(*param_1 << 0x1b) < 0) {
        *param_1 = *param_1 & 0xffffffef;
        __gnu_Unwind_Save_WMMXC(param_1 + 0x74);
      }
      __gnu_Unwind_Save_WMMXC(local_a0);
      puVar2 = (undefined4 *)param_1[0xe];
      uVar5 = 0;
      do {
        if ((1 << (uVar5 & 0xff) & param_3) != 0) {
          uVar1 = *puVar2;
          puVar2 = puVar2 + 1;
          local_a0[uVar5] = uVar1;
        }
        uVar5 = uVar5 + 1;
      } while (uVar5 != 4);
      param_1[0xe] = (uint)puVar2;
      __gnu_Unwind_Restore_WMMXC(local_a0);
      return 0;
    }
  }
  return 2;
}



undefined8 restore_core_regs(undefined8 *param_1)

{
  *(undefined4 *)(*(int *)((int)param_1 + 0x34) + -4) = *(undefined4 *)((int)param_1 + 0x3c);
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
  
  coprocessor_load(1,in_cr8,param_1);
  coprocessor_load(1,in_cr9,param_1 + 4);
  coprocessor_load(1,in_cr10,param_1 + 8);
  coprocessor_load(1,in_cr11,param_1 + 0xc);
  return param_1 + 0x10;
}



int __gnu_Unwind_Save_WMMXC(int param_1)

{
  undefined4 in_cr8;
  undefined4 in_cr9;
  undefined4 in_cr10;
  undefined4 in_cr11;
  
  coprocessor_store(1,in_cr8,param_1);
  coprocessor_store(1,in_cr9,param_1 + 4);
  coprocessor_store(1,in_cr10,param_1 + 8);
  coprocessor_store(1,in_cr11,param_1 + 0xc);
  return param_1 + 0x10;
}



void ___Unwind_RaiseException
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



void ___Unwind_Resume(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

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



void _Unwind_ForcedUnwind(void)

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



uint FUN_00024d68(uint *param_1)

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



undefined4 FUN_00024d94(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 local_c;
  
  local_c = param_4;
  _Unwind_VRS_Get(param_1,0,0xc,0,&local_c,param_2,param_3);
  return local_c;
}



undefined4
thunk_FUN_00024d94(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uStack_c;
  
  uStack_c = param_4;
  _Unwind_VRS_Get(param_1,0,0xc,0,&uStack_c,param_2,param_3);
  return uStack_c;
}



undefined4 __gnu_unwind_execute(int *param_1,undefined4 param_2,undefined4 param_3,int param_4)

{
  uint uVar1;
  uint uVar2;
  undefined4 uVar3;
  uint uVar4;
  undefined4 uVar5;
  bool bVar6;
  int iVar7;
  int *piVar8;
  undefined4 uVar9;
  int local_24;
  
  bVar6 = false;
  piVar8 = param_1;
  uVar9 = param_2;
  local_24 = param_4;
LAB_00024dc0:
  do {
    while( true ) {
      uVar2 = FUN_00024d68(param_2);
      if (uVar2 == 0xb0) {
        if (!bVar6) {
          _Unwind_VRS_Get(param_1,0,0xe,0,&local_24,uVar9,param_3);
          _Unwind_VRS_Set(param_1,0,0xf,0,&local_24);
        }
        return 0;
      }
      if ((uVar2 & 0x80) != 0) break;
      _Unwind_VRS_Get(param_1,0,0xd,0,&local_24,uVar9,param_3);
      iVar7 = (uVar2 & 0x3f) * 4 + 4;
      if ((uVar2 & 0x40) != 0) {
        iVar7 = -iVar7;
      }
      local_24 = local_24 + iVar7;
LAB_00024e86:
      piVar8 = &local_24;
      _Unwind_VRS_Set(param_1,0,0xd,0);
    }
    uVar4 = uVar2 & 0xf0;
    if (uVar4 == 0x80) {
      uVar4 = FUN_00024d68(param_2);
      uVar4 = uVar4 | uVar2 << 8;
      if (uVar4 == 0x8000) {
        return 9;
      }
      uVar4 = uVar4 << 4;
      iVar7 = _Unwind_VRS_Pop(param_1,0,uVar4 & 0xffff,0,piVar8);
      if (iVar7 != 0) {
        return 9;
      }
      if ((uVar4 & 0x8000) != 0) {
        bVar6 = true;
      }
      goto LAB_00024dc0;
    }
    if (uVar4 == 0x90) {
      if ((uVar2 & 0xd) == 0xd) {
        return 9;
      }
      _Unwind_VRS_Get(param_1,0,uVar2 & 0xf,0,&local_24,uVar9,param_3);
      goto LAB_00024e86;
    }
    if (uVar4 == 0xa0) {
      uVar4 = 0xff0 >> (~uVar2 & 7) & 0xff0;
      if ((int)(uVar2 << 0x1c) < 0) {
        uVar4 = uVar4 | 0x4000;
      }
      uVar3 = 0;
      uVar5 = uVar3;
    }
    else if (uVar4 == 0xb0) {
      if (uVar2 == 0xb1) {
        uVar4 = FUN_00024d68(param_2);
        if (uVar4 == 0) {
          return 9;
        }
        if ((uVar4 & 0xf0) != 0) {
          return 9;
        }
        uVar3 = 0;
        uVar5 = uVar3;
      }
      else {
        if (uVar2 == 0xb2) {
          uVar4 = 2;
          _Unwind_VRS_Get(param_1,0,0xd,0,&local_24,uVar9,param_3);
          uVar2 = FUN_00024d68(param_2);
          while ((uVar2 & 0x80) != 0) {
            uVar1 = uVar4 & 0xff;
            uVar4 = uVar4 + 7;
            local_24 = local_24 + ((uVar2 & 0x7f) << uVar1);
            uVar2 = FUN_00024d68(param_2);
          }
          local_24 = ((uVar2 & 0x7f) << (uVar4 & 0xff)) + local_24 + 0x204;
          goto LAB_00024e86;
        }
        if (uVar2 == 0xb3) {
          uVar2 = FUN_00024d68(param_2);
          uVar3 = 1;
          goto LAB_00024f68;
        }
        if ((uVar2 & 0xfc) == 0xb4) {
          return 9;
        }
        uVar3 = 1;
        uVar4 = (uVar2 & 7) + 1 | 0x80000;
        uVar5 = uVar3;
      }
    }
    else if (uVar4 == 0xc0) {
      if (uVar2 == 0xc6) {
        uVar2 = FUN_00024d68(param_2);
        uVar3 = 3;
LAB_00024f68:
        uVar4 = (uVar2 & 0xf) + 1 | (uVar2 & 0xf0) << 0xc;
        uVar5 = uVar3;
      }
      else if (uVar2 == 199) {
        uVar4 = FUN_00024d68(param_2);
        if (uVar4 == 0) {
          return 9;
        }
        if ((uVar4 & 0xf0) != 0) {
          return 9;
        }
        uVar3 = 4;
        uVar5 = 0;
      }
      else {
        if ((uVar2 & 0xf8) != 0xc0) {
          if (uVar2 == 200) {
            uVar2 = FUN_00024d68(param_2);
            uVar4 = (uVar2 & 0xf0) + 0x10;
          }
          else {
            if (uVar2 != 0xc9) {
              return 9;
            }
            uVar2 = FUN_00024d68(param_2);
            uVar4 = uVar2 & 0xf0;
          }
          uVar4 = (uVar2 & 0xf) + 1 | uVar4 << 0xc;
          goto LAB_00024ff6;
        }
        uVar3 = 3;
        uVar4 = (uVar2 & 0xf) + 1 | 0xa0000;
        uVar5 = uVar3;
      }
    }
    else {
      if ((uVar2 & 0xf8) != 0xd0) {
        return 9;
      }
      uVar4 = (uVar2 & 7) + 1 | 0x80000;
LAB_00024ff6:
      uVar3 = 1;
      uVar5 = 5;
    }
    iVar7 = _Unwind_VRS_Pop(param_1,uVar3,uVar4,uVar5,piVar8);
    if (iVar7 != 0) {
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
  
  iVar1 = thunk_FUN_00024d94();
  return *(undefined4 *)(iVar1 + 0x48);
}



int _Unwind_GetLanguageSpecificData(void)

{
  int iVar1;
  
  iVar1 = thunk_FUN_00024d94();
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


