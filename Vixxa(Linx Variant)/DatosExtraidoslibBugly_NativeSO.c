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
typedef unsigned int    undefined4;
typedef unsigned long long    undefined6;
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

typedef void *__gnuc_va_list;

typedef struct timeval timeval, *Ptimeval;

typedef long __suseconds_t;

struct timeval {
    __time_t tv_sec;
    __suseconds_t tv_usec;
};

typedef struct timezone timezone, *Ptimezone;

typedef struct timezone *__timezone_ptr_t;

struct timezone {
    int tz_minuteswest;
    int tz_dsttime;
};

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

typedef enum __ptrace_request {
    PTRACE_TRACEME=0,
    PTRACE_PEEKTEXT=1,
    PTRACE_PEEKDATA=2,
    PTRACE_PEEKUSER=3,
    PTRACE_POKETEXT=4,
    PTRACE_POKEDATA=5,
    PTRACE_POKEUSER=6,
    PTRACE_CONT=7,
    PTRACE_KILL=8,
    PTRACE_SINGLESTEP=9,
    PTRACE_GETREGS=12,
    PTRACE_SETREGS=13,
    PTRACE_GETFPREGS=14,
    PTRACE_SETFPREGS=15,
    PTRACE_ATTACH=16,
    PTRACE_DETACH=17,
    PTRACE_GETFPXREGS=18,
    PTRACE_SETFPXREGS=19,
    PTRACE_SYSCALL=24,
    PTRACE_SETOPTIONS=16896,
    PTRACE_GETEVENTMSG=16897,
    PTRACE_GETSIGINFO=16898,
    PTRACE_SETSIGINFO=16899
} __ptrace_request;

typedef struct sigaction sigaction, *Psigaction;

typedef union _union_1051 _union_1051, *P_union_1051;

typedef struct siginfo siginfo, *Psiginfo;

typedef struct siginfo siginfo_t;

typedef struct __sigset_t __sigset_t, *P__sigset_t;

typedef void (*__sighandler_t)(int);

typedef union _union_1031 _union_1031, *P_union_1031;

typedef struct _struct_1032 _struct_1032, *P_struct_1032;

typedef struct _struct_1033 _struct_1033, *P_struct_1033;

typedef struct _struct_1034 _struct_1034, *P_struct_1034;

typedef struct _struct_1035 _struct_1035, *P_struct_1035;

typedef struct _struct_1036 _struct_1036, *P_struct_1036;

typedef struct _struct_1037 _struct_1037, *P_struct_1037;

typedef int __pid_t;

typedef union sigval sigval, *Psigval;

typedef union sigval sigval_t;

typedef long __clock_t;

struct _struct_1032 {
    __pid_t si_pid;
    __uid_t si_uid;
};

union sigval {
    int sival_int;
    void *sival_ptr;
};

struct _struct_1034 {
    __pid_t si_pid;
    __uid_t si_uid;
    sigval_t si_sigval;
};

struct _struct_1035 {
    __pid_t si_pid;
    __uid_t si_uid;
    int si_status;
    __clock_t si_utime;
    __clock_t si_stime;
};

struct _struct_1037 {
    long si_band;
    int si_fd;
};

struct _struct_1033 {
    int si_tid;
    int si_overrun;
    sigval_t si_sigval;
};

struct _struct_1036 {
    void *si_addr;
};

union _union_1031 {
    int _pad[29];
    struct _struct_1032 _kill;
    struct _struct_1033 _timer;
    struct _struct_1034 _rt;
    struct _struct_1035 _sigchld;
    struct _struct_1036 _sigfault;
    struct _struct_1037 _sigpoll;
};

struct __sigset_t {
    ulong __val[32];
};

union _union_1051 {
    __sighandler_t sa_handler;
    void (*sa_sigaction)(int, siginfo_t *, void *);
};

struct siginfo {
    int si_signo;
    int si_errno;
    int si_code;
    union _union_1031 _sifields;
};

struct sigaction {
    union _union_1051 __sigaction_handler;
    struct __sigset_t sa_mask;
    int sa_flags;
    void (*sa_restorer)(void);
};

typedef struct __jmp_buf_tag __jmp_buf_tag, *P__jmp_buf_tag;

typedef int __jmp_buf[6];

struct __jmp_buf_tag {
    __jmp_buf __jmpbuf;
    int __mask_was_saved;
    struct __sigset_t __saved_mask;
};

typedef struct _IO_FILE FILE;

typedef int __ssize_t;

typedef __ssize_t ssize_t;

typedef uint __useconds_t;

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

typedef int pthread_once_t;

typedef union pthread_rwlockattr_t pthread_rwlockattr_t, *Ppthread_rwlockattr_t;

union pthread_rwlockattr_t {
    char __size[8];
    long __align;
};

typedef ulong pthread_t;

typedef struct _struct_19 _struct_19, *P_struct_19;

struct _struct_19 {
    int __lock;
    uint __nr_readers;
    uint __readers_wakeup;
    uint __writer_wakeup;
    uint __nr_readers_queued;
    uint __nr_writers_queued;
    uchar __flags;
    uchar __shared;
    uchar __pad1;
    uchar __pad2;
    int __writer;
};

typedef uint pthread_key_t;

typedef union pthread_rwlock_t pthread_rwlock_t, *Ppthread_rwlock_t;

union pthread_rwlock_t {
    struct _struct_19 __data;
    char __size[32];
    long __align;
};

typedef union pthread_attr_t pthread_attr_t, *Ppthread_attr_t;

union pthread_attr_t {
    char __size[36];
    long __align;
};

typedef struct __dirstream __dirstream, *P__dirstream;

struct __dirstream {
};

typedef struct __dirstream DIR;

typedef struct dirent dirent, *Pdirent;

struct dirent {
    __ino_t d_ino;
    __off_t d_off;
    ushort d_reclen;
    uchar d_type;
    char d_name[256];
};

typedef int (*__compar_fn_t)(void *, void *);

typedef struct sigaltstack sigaltstack, *Psigaltstack;

struct sigaltstack {
    void *ss_sp;
    int ss_flags;
    size_t ss_size;
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

typedef struct Elf32_Rel Elf32_Rel, *PElf32_Rel;

struct Elf32_Rel {
    dword r_offset; // location to apply the relocation action
    dword r_info; // the symbol table index and the type of relocation
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

typedef struct GnuBuildId GnuBuildId, *PGnuBuildId;

struct GnuBuildId {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[4]; // Vendor name
    byte hash[20];
};

typedef struct Elf32_Dyn_ARM Elf32_Dyn_ARM, *PElf32_Dyn_ARM;

struct Elf32_Dyn_ARM {
    enum Elf32_DynTag_ARM d_tag;
    dword d_val;
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

typedef struct ElfNote_8_132 ElfNote_8_132, *PElfNote_8_132;

struct ElfNote_8_132 {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[8]; // Vendor name
    byte description[132]; // Blob value
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




void __cxa_atexit(void)

{
  __cxa_atexit();
  return;
}



void log2Console(void)

{
  log2Console();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

uint sleep(uint __seconds)

{
  uint uVar1;
  
  uVar1 = sleep(__seconds);
  return uVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int sigaction(int __sig,sigaction *__act,sigaction *__oact)

{
  int iVar1;
  
  iVar1 = sigaction(__sig,__act,__oact);
  return iVar1;
}



void __stack_chk_fail(void)

{
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void __emutls_get_address(void)

{
  __emutls_get_address();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_create(pthread_t *__newthread,pthread_attr_t *__attr,__start_routine *__start_routine,
                  void *__arg)

{
  int iVar1;
  
  iVar1 = pthread_create(__newthread,__attr,__start_routine,__arg);
  return iVar1;
}



void lockFile(char *param_1,int param_2)

{
  int iVar1;
  time_t tVar2;
  undefined4 uVar3;
  int *piVar4;
  char *pcVar5;
  char *pcVar6;
  int iStack_8c;
  stat sStack_88;
  int iStack_30;
  int iStack_1c;
  
  iStack_1c = __stack_chk_guard;
  if ((param_1 == (char *)0x0) || (param_2 < 1)) goto LAB_0001f7ca;
  log2Console(4,&DAT_00034c70,"Try to lock file: %s",param_1);
  iVar1 = access(param_1,0);
  if (iVar1 == 0) {
    iVar1 = stat(param_1,&sStack_88);
    if (iVar1 < 0) {
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to read size of file for: %s.";
    }
    else {
      tVar2 = time(&iStack_8c);
      if (-1 < tVar2) {
        if (param_2 < iStack_8c - iStack_30) {
          log2Console(4,&DAT_00034c70,"Lock file is expired, unlock it.");
          iVar1 = unlockFile(param_1);
          if (iVar1 != 0) goto LAB_0001f700;
          uVar3 = 5;
          pcVar5 = "Failed to unlock expired lock file.";
        }
        else {
          uVar3 = 4;
          pcVar5 = "Some one holds the lock file.";
        }
        log2Console(uVar3,&DAT_00034c70,pcVar5);
        goto LAB_0001f7ca;
      }
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to get current time for: %s.";
    }
  }
  else {
LAB_0001f700:
    iVar1 = open(param_1,0x241,0x180);
    if (-1 < iVar1) {
      write(iVar1,&DAT_00038a44,1);
      close(iVar1);
      log2Console(4,&DAT_00034c70,"Successfully locked file: %s",param_1);
      goto LAB_0001f7ca;
    }
    piVar4 = (int *)__errno();
    pcVar5 = strerror(*piVar4);
    pcVar6 = "Failed to create lock file for: %s.";
  }
  log2Console(5,&DAT_00034c70,pcVar6,pcVar5);
LAB_0001f7ca:
  if (__stack_chk_guard - iStack_1c == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - iStack_1c);
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * calloc(size_t __nmemb,size_t __size)

{
  void *pvVar1;
  
  pvVar1 = calloc(__nmemb,__size);
  return pvVar1;
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



void HandleAnr(void)

{
  HandleAnr();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int gettimeofday(timeval *__tv,__timezone_ptr_t __tz)

{
  int iVar1;
  
  iVar1 = gettimeofday(__tv,__tz);
  return iVar1;
}



void __aeabi_uidiv(void)

{
  __aeabi_uidiv();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int snprintf(char *__s,size_t __maxlen,char *__format,...)

{
  int iVar1;
  
  iVar1 = snprintf(__s,__maxlen,__format);
  return iVar1;
}



undefined * getSignalName(int param_1)

{
  if (0x1c < param_1 - 1U) {
    return &DAT_00038811;
  }
  return (&PTR_s_SIGHUP_0003c3a8)[param_1 - 1U];
}



void getSigCode(void)

{
  getSigCode();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

__pid_t getpid(void)

{
  __pid_t _Var1;
  
  _Var1 = getpid();
  return _Var1;
}



void gettid(void)

{
  gettid();
  return;
}



char * getProcessName(int param_1)

{
  char *__s;
  FILE *__stream;
  size_t sVar1;
  char cVar2;
  char *__s_00;
  bool bVar3;
  
  if (param_1 < 2) {
    __s_00 = (char *)0x0;
  }
  else {
    __s = (char *)calloc(1,0x1000);
    __s_00 = (char *)calloc(1,0x200);
    snprintf(__s,0x1000,"/proc/%d/cmdline",param_1);
    __stream = fopen(__s,"r");
    if (__stream != (FILE *)0x0) {
      fgets(__s_00,0x200,__stream);
      fclose(__stream);
    }
    if (__s_00 != (char *)0x0) {
      sVar1 = strlen(__s_00);
      cVar2 = __s_00[sVar1 - 1];
      bVar3 = cVar2 == '\n';
      if (bVar3) {
        cVar2 = '\0';
      }
      if (bVar3) {
        __s_00[sVar1 - 1] = cVar2;
      }
    }
    free(__s);
  }
  return __s_00;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void free(void *__ptr)

{
  free(__ptr);
  return;
}



void getThreadName(void)

{
  getThreadName();
  return;
}



void getAndroidApiLevel(void)

{
  getAndroidApiLevel();
  return;
}



void resetError(void)

{
  undefined4 *puVar1;
  
  puVar1 = (undefined4 *)__errno();
  *puVar1 = 0;
  return;
}



void initCrashRecordFile(void)

{
  initCrashRecordFile();
  return;
}



void backtraceStackMini(void)

{
  backtraceStackMini();
  return;
}



void saveEupInfo2File(void)

{
  saveEupInfo2File();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int open(char *__file,int __oflag,...)

{
  int iVar1;
  
  iVar1 = open(__file,__oflag);
  return iVar1;
}



void getErrorMsg(void)

{
  getErrorMsg();
  return;
}



void recordTombStoneFileHeader(undefined4 param_1,int param_2)

{
  tm tStack_150;
  time_t tStack_124;
  char acStack_120 [64];
  undefined1 auStack_e0 [92];
  undefined1 auStack_84 [92];
  int iStack_28;
  
  iStack_28 = __stack_chk_guard;
  log2Console(4,&DAT_00034c70,"create tombstone file: %s ",param_2 + 0x120);
  log2Console(4,&DAT_00034c70,"Record crash banner.");
  property_get("ro.build.fingerprint",auStack_84,"unknown");
  property_get("ro.revision",auStack_e0,"unknown");
  tStack_124 = time((time_t *)0x0);
  localtime_r(&tStack_124,&tStack_150);
  strftime(acStack_120,0x40,"%F %T",&tStack_150);
  log2Report(param_1,0,"--- --- --- --- --- --- --- Bugly NDK %s --- --- --- --- --- --- --- \n",
             "4.1.9");
  log2Report(param_1,0,"Build fingerprint: %s\n",auStack_84);
  log2Report(param_1,0,"Revision: %s\n",auStack_e0);
  log2Report(param_1,0,"ABI: %s\n",&DAT_00038b72);
  log2Report(param_1,0,"time: %s\n",acStack_120);
  log2Report(param_1,0,"pid: %d, tid: %d, name: %s  >>> %s <<<\n",*(undefined4 *)(param_2 + 4),
             *(undefined4 *)(param_2 + 8),param_2 + 0x420,param_2 + 0x220);
  if (*(int *)(param_2 + 0xc) != 0) {
    log2Report(param_1,0,"signal: %d (%s), code: %d (%s) fault addr: %s\n",*(int *)(param_2 + 0xc),
               param_2 + 200,*(undefined4 *)(param_2 + 0x14),param_2 + 0x30,param_2 + 0xe0);
    log2Report(param_1,0,"si_errno:%d, si_errnoMsg:%s, sending pid:%d, sending uid:%d",
               *(undefined4 *)(param_2 + 0x10),param_2 + 0x48,*(undefined4 *)(param_2 + 0x18),
               *(undefined4 *)(param_2 + 0x1c));
  }
  if (__stack_chk_guard == iStack_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void dumpAbortMessage(void)

{
  dumpAbortMessage();
  return;
}



void initRegisterRecordFile(void)

{
  initRegisterRecordFile();
  return;
}



void initMapRecordFile(void)

{
  initMapRecordFile();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t strlen(char *__s)

{
  size_t sVar1;
  
  sVar1 = strlen(__s);
  return sVar1;
}



undefined4 saveAppInfo2File(char *param_1,char *param_2)

{
  undefined4 uVar1;
  int iVar2;
  
  uVar1 = 0;
  if ((param_1 != (char *)0x0) && (param_2 != (char *)0x0)) {
    if (DAT_0003d8d0 == (FILE *)0x0) {
      DAT_0003d8d0 = fopen(DAT_0003d8d4,"a");
    }
    if ((*param_1 == '\0') || (*param_2 == '\0')) {
      uVar1 = 0;
    }
    else {
      log2Console(4,&DAT_00034c70,"Record %s",param_1);
      iVar2 = recordProperty(DAT_0003d8d0,param_1,param_2);
      if (iVar2 < 1) {
        log2Console(6,&DAT_00034c70,"Failed to record native log.");
      }
      log2Console(4,&DAT_00034c70,"%s has been recorded.",param_1);
      closeCrashRecordFile();
      uVar1 = 1;
    }
  }
  return uVar1;
}



void recordRegisterInfo(void)

{
  recordRegisterInfo();
  return;
}



void closeRegisterRecordFile(void)

{
  closeRegisterRecordFile();
  return;
}



undefined4 backtraceStack(undefined4 param_1,int param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  
  log2Console(3,&DAT_00034c70,"backtraceStack");
  init_dl_iterate_phdr_wrapper();
  iVar1 = backtraceStackWithLibUnwind(param_1,*(undefined4 *)(param_2 + 0x4a0),param_4);
  if (iVar1 == 0) {
    log2Console(4,&DAT_00034c70,"Failed to dump stack by libUnwind.");
  }
  else {
    log2Console(4,&DAT_00034c70,"Stack is succesfully dumped by libUnwind.");
    log2Console(3,&DAT_00034c70,"Native stack: \n%s",*(undefined4 *)(param_2 + 0x4a0));
    log2Console(4,&DAT_00034c70,"Record map file of thread: %d",*(undefined4 *)(param_2 + 8));
    recordAllMapInfo(*(undefined4 *)(param_2 + 8));
  }
  return 0;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int close(int __fd)

{
  int iVar1;
  
  iVar1 = close(__fd);
  return iVar1;
}



void closeMapRecordFile(void)

{
  if (DAT_0003d8e8 != (FILE *)0x0) {
    fclose(DAT_0003d8e8);
    DAT_0003d8e8 = (FILE *)0x0;
  }
  if (DAT_0003d8e4 != (void *)0x0) {
    free(DAT_0003d8e4);
    DAT_0003d8e4 = (void *)0x0;
  }
  return;
}



void closeElfInfoParser(void)

{
  closeElfInfoParser();
  return;
}



void saveKeyValue2File(void)

{
  saveKeyValue2File();
  return;
}



void saveNativeLog2File(void)

{
  saveNativeLog2File();
  return;
}



void closeCrashRecordFile(void)

{
  closeCrashRecordFile();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int access(char *__name,int __type)

{
  int iVar1;
  
  iVar1 = access(__name,__type);
  return iVar1;
}



void recordSystemLogWithFd(int param_1,int param_2)

{
  __pid_t __pid;
  int iVar1;
  int *piVar2;
  undefined4 uVar3;
  undefined *puVar4;
  undefined *puVar5;
  char *pcVar6;
  uint uVar7;
  char *pcVar8;
  char *pcVar9;
  uint uStack_20;
  int iStack_1c;
  
  iStack_1c = __stack_chk_guard;
  if (param_1 < 0) {
    piVar2 = (int *)__errno();
    pcVar6 = strerror(*piVar2);
    log2Console(6,&DAT_00034c70,"System log file descriptor is invalid: %d, error: %s",param_1,
                pcVar6);
    uVar3 = 0xffffffff;
  }
  else {
    log2Console(3,&DAT_00034c70,"Start to record system log by executing \'logcat\'.");
    __pid = fork();
    if (__pid < 0) {
      piVar2 = (int *)__errno();
      pcVar6 = strerror(*piVar2);
      log2Console(6,&DAT_00034c70,"Failed to fork process, error: %s",pcVar6);
      uVar3 = 0xfffffffe;
    }
    else {
      if (__pid == 0) {
        dup2(param_1,1);
        if (param_2 == 0) {
          puVar4 = &DAT_00038d2b;
          pcVar8 = "-v";
          pcVar9 = "threadtime";
          pcVar6 = "Bugly-libunwind:S";
          puVar5 = &DAT_00038d2e;
        }
        else {
          iVar1 = getAndroidApiLevel();
          pcVar6 = "dalvikvm art zygote zygote64 OpenGLRenderer";
          if (0x1b < iVar1) {
            pcVar6 = (char *)0x0;
          }
          log2Console(3,&DAT_00034c70,"Tag to filter logcat is set to: %s",pcVar6);
          if (iVar1 < 0x1c) {
            puVar4 = &DAT_00038d05;
            pcVar8 = "threadtime";
            pcVar9 = "-s";
            puVar5 = &DAT_00038d08;
          }
          else {
            puVar4 = &DAT_00038d05;
            puVar5 = &DAT_00038d08;
            pcVar8 = "threadtime";
            pcVar9 = "Bugly-libunwind:S";
            pcVar6 = (char *)0x0;
          }
        }
        execl("/system/bin/logcat","logcat",puVar4,puVar5,pcVar8,pcVar9,pcVar6);
        piVar2 = (int *)__errno();
        pcVar6 = strerror(*piVar2);
        log2Console(6,&DAT_00034c70,"Failed to execute \'logcat\', error: %s",pcVar6);
      }
      else {
        log2Console(3,&DAT_00034c70,"Pid of subprocess: %d",__pid);
        log2Console(4,&DAT_00034c70,"Wait for the subprocess to dump logcat...");
        uVar7 = 0xffffffff;
        uStack_20 = 0xffffffff;
        do {
          uVar7 = uVar7 + 1;
          if (0x7c < uVar7 >> 2) goto LAB_0001f12a;
          usleep(10000);
          waitpid(__pid,(int *)&uStack_20,1);
        } while ((uStack_20 & 0x7f) != 0);
        log2Console(4,&DAT_00034c70,"Successfully dump log by executing \'logcat\'.");
LAB_0001f12a:
        log2Console(4,&DAT_00034c70,"Finished recorded system log.");
      }
      uVar3 = 0;
    }
  }
  if (__stack_chk_guard == iStack_1c) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar3);
}



void checkJavaException(void)

{
  checkJavaException();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int usleep(__useconds_t __useconds)

{
  int iVar1;
  
  iVar1 = usleep(__useconds);
  return iVar1;
}



void __aeabi_idiv(void)

{
  __aeabi_idiv();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strstr(char *__haystack,char *__needle)

{
  char *pcVar1;
  
  pcVar1 = strstr(__haystack,__needle);
  return pcVar1;
}



void saveJavaDump2File(int param_1,char *param_2)

{
  int iVar1;
  
  log2Console(4,&DAT_00034c70,"Record Java stack.");
  if (param_1 == 0) {
    log2Console(6,&DAT_00034c70,"save jstack fail!");
    return;
  }
  if (DAT_0003d8d0 == (FILE *)0x0) {
    DAT_0003d8d0 = fopen(DAT_0003d8d4,"a");
  }
  if (((param_2 != (char *)0x0) && (*param_2 != '\0')) &&
     (iVar1 = recordProperty(DAT_0003d8d0,"jstack",param_2), iVar1 < 1)) {
    log2Console(6,&DAT_00034c70,"Failed to record java stack.");
  }
  log2Console(4,&DAT_00034c70,"Java stack has been recorded.");
  closeCrashRecordFile();
  free(DAT_0003d8d4);
  return;
}



void closeNativeLog(void)

{
  closeNativeLog();
  return;
}



void freeNativeKeyValueList(void)

{
  freeNativeKeyValueList();
  return;
}



void unlockFile(void)

{
  unlockFile();
  return;
}



void unregistSignalHanlder(void)

{
  unregistSignalHanlder();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int kill(__pid_t __pid,int __sig)

{
  int iVar1;
  
  iVar1 = kill(__pid,__sig);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void siglongjmp(__jmp_buf_tag *__env,int __val)

{
                    // WARNING: Subroutine does not return
  siglongjmp(__env,__val);
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void _exit(int __status)

{
                    // WARNING: Subroutine does not return
  _exit(__status);
}



void setLogMode(void)

{
  setLogMode();
  return;
}



void toJavaString(void)

{
  toJavaString();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int sigaltstack(sigaltstack *__ss,sigaltstack *__oss)

{
  int iVar1;
  
  iVar1 = sigaltstack(__ss,__oss);
  return iVar1;
}



void UnblockSigquit(void)

{
  UnblockSigquit();
  return;
}



void printBuglySoArch(void)

{
  printBuglySoArch();
  return;
}



void initStackBuffer(void)

{
  initStackBuffer();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_join(pthread_t __th,void **__thread_return)

{
  int iVar1;
  
  iVar1 = pthread_join(__th,__thread_return);
  return iVar1;
}



void doANativeCrash(void)

{
  doANativeCrash();
  return;
}



undefined8 doACrash(int param_1,pthread_t param_2,undefined3 param_3)

{
  int __errnum;
  char *pcVar1;
  pthread_t pStack_1c;
  undefined3 uStack_18;
  undefined1 uStack_15;
  int iStack_14;
  
  iStack_14 = __stack_chk_guard;
  _uStack_18 = CONCAT13((char)param_2,param_3);
  pStack_1c = param_2;
  if (param_1 == 0) {
    doANativeCrash(&uStack_15);
  }
  else {
    log2Console(3,&DAT_00034c70,"Create a new thread for testing crash.");
    __errnum = pthread_create(&pStack_1c,(pthread_attr_t *)0x0,doANativeCrash,&uStack_15);
    if (__errnum != 0) {
      pcVar1 = strerror(__errnum);
      log2Console(6,&DAT_00034c70,"can\'t create thread: %s\n",pcVar1);
    }
    pthread_join(pStack_1c,(void **)0x0);
  }
  if (__stack_chk_guard != iStack_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return CONCAT44(pStack_1c,param_1);
}



void appendNativeLog(void)

{
  appendNativeLog();
  return;
}



void appendWholeNativeLog(void)

{
  appendWholeNativeLog();
  return;
}



void getNativeLog(void)

{
  getNativeLog();
  return;
}



void putNativeKeyValue(void)

{
  putNativeKeyValue();
  return;
}



void parseBoolString(void)

{
  parseBoolString();
  return;
}



void SendSigquitToSignalCatcher(void)

{
  SendSigquitToSignalCatcher();
  return;
}



void backupJavaClasses(void)

{
  backupJavaClasses();
  return;
}



void getBuglyClassPathPrefix(void)

{
  getBuglyClassPathPrefix();
  return;
}



void concatString(void)

{
  concatString();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

pthread_t pthread_self(void)

{
  pthread_t pVar1;
  
  pVar1 = pthread_self();
  return pVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_kill(pthread_t __threadid,int __signo)

{
  int iVar1;
  
  iVar1 = pthread_kill(__threadid,__signo);
  return iVar1;
}



void getPendingExceptionStack(void)

{
  getPendingExceptionStack();
  return;
}



void __aeabi_memcpy(void)

{
  __aeabi_memcpy();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strcat(char *__dest,char *__src)

{
  char *pcVar1;
  
  pcVar1 = strcat(__dest,__src);
  return pcVar1;
}



undefined4 getJavaThreadStack(int *param_1,int param_2,int param_3,int param_4)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  char *pcVar4;
  
  if ((param_1 == (int *)0x0) || (param_4 < 1)) {
    pcVar4 = "env == NULL || maxLen <= 0, return!";
  }
  else {
    if (param_3 == 0) {
      uVar3 = javaTheadDump(param_1,param_4);
      return uVar3;
    }
    iVar1 = getJavaThread(param_1,*(undefined4 *)(param_2 + 8),param_3);
    if (iVar1 == 0) {
      log2Console(6,&DAT_00034c70,"Failed to get java thread with thread name: %s",param_3);
      return 0;
    }
    iVar2 = getJavaThreadName(param_1,iVar1);
    if (iVar2 != 0) {
      snprintf((char *)(param_2 + 0x420),0x80,"%s",iVar2);
    }
    uVar3 = getJavaThreadStackByThreadObject(param_1,iVar1,param_4);
    (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
    iVar1 = checkJavaException(param_1);
    if (iVar1 == 0) {
      return uVar3;
    }
    pcVar4 = "Failed to delete local reference.";
  }
  log2Console(6,&DAT_00034c70,pcVar4);
  return 0;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strncat(char *__dest,char *__src,size_t __n)

{
  char *pcVar1;
  
  pcVar1 = strncat(__dest,__src,__n);
  return pcVar1;
}



undefined4 javaStaticCall_NativeCrashHandler_GetInstance(int *param_1)

{
  undefined4 uVar1;
  int iVar2;
  
  if (((param_1 == (int *)0x0) || (jc_NativeCrashHandler == 0)) || (jm_getInstance == 0)) {
    log2Console(6,&DAT_00034c70,
                "env == NULL or jc_NativeCrashHandler == 0 or jm_getInstance == 0 , return!%p %p %p"
                ,param_1,jc_NativeCrashHandler,jm_getInstance);
    uVar1 = 0;
  }
  else {
    uVar1 = (**(code **)(*param_1 + 0x1c8))(param_1);
    iVar2 = checkJavaException(param_1);
    if (iVar2 != 0) {
      log2Console(6,&DAT_00034c70,"call getInstance fail!");
    }
  }
  return uVar1;
}



void javaCall_NativeCrashHandler_GetMHandle(void)

{
  javaCall_NativeCrashHandler_GetMHandle();
  return;
}



undefined4
javaObjectCall_NativeExceptionHandler_handleNativeException
          (int *param_1,int param_2,int param_3,char *param_4)

{
  undefined4 uVar1;
  size_t sVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  int iVar9;
  int iVar10;
  int iVar11;
  undefined4 uVar12;
  char *pcVar13;
  code *pcVar14;
  
  if ((((param_1 == (int *)0x0) || (param_2 == 0)) || (param_3 == 0)) || (param_4 == (char *)0x0)) {
    pcVar13 = "env == NULL || obj == NULL || eupInfo == NULL || nativeRQDVersion == NULL , return!";
  }
  else {
    uVar12 = *(undefined4 *)(param_3 + 4);
    uVar1 = *(undefined4 *)(param_3 + 8);
    sVar2 = strlen((char *)(param_3 + 200));
    iVar3 = toJavaString(param_1,(char *)(param_3 + 200),sVar2);
    if (iVar3 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0xe0));
    iVar4 = toJavaString(param_1,(char *)(param_3 + 0xe0),sVar2);
    if (iVar4 == 0) {
      return 0xffffffff;
    }
    pcVar13 = *(char **)(param_3 + 0x4a0);
    sVar2 = strlen(pcVar13);
    iVar5 = toJavaString(param_1,pcVar13,sVar2);
    if (iVar5 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0x120));
    iVar6 = toJavaString(param_1,(char *)(param_3 + 0x120),sVar2);
    if (iVar6 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0x30));
    iVar7 = toJavaString(param_1,(char *)(param_3 + 0x30),sVar2);
    if (iVar7 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0x48));
    iVar8 = toJavaString(param_1,(char *)(param_3 + 0x48),sVar2);
    if (iVar8 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen(param_4);
    iVar9 = toJavaString(param_1,param_4,sVar2);
    if (iVar9 == 0) {
      return 0xffffffff;
    }
    iVar10 = constructUploadExtraMessage(param_1,param_3);
    if (iVar10 == 0) {
      pcVar13 = "Failed to constructUploadExtraMessage";
    }
    else {
      if (jm_handleNativeException2 == 0) {
        pcVar14 = *(code **)(*param_1 + 0xf4);
        iVar11 = jm_handleNativeException;
      }
      else {
        log2Console(4,&DAT_00034c70,"Use new interface to handle native exception.");
        pcVar14 = *(code **)(*param_1 + 0xf4);
        iVar11 = jm_handleNativeException2;
      }
      (*pcVar14)(param_1,param_2,iVar11,uVar12,uVar1);
      iVar11 = checkJavaException(param_1);
      if (iVar11 == 0) {
        (**(code **)(*param_1 + 0x5c))(param_1,iVar3);
        iVar3 = checkJavaException(param_1);
        if (iVar3 == 0) {
          (**(code **)(*param_1 + 0x5c))(param_1,iVar4);
          iVar3 = checkJavaException(param_1);
          if (iVar3 == 0) {
            (**(code **)(*param_1 + 0x5c))(param_1,iVar5);
            iVar3 = checkJavaException(param_1);
            if (iVar3 == 0) {
              (**(code **)(*param_1 + 0x5c))(param_1,iVar6);
              iVar3 = checkJavaException(param_1);
              if (iVar3 == 0) {
                (**(code **)(*param_1 + 0x5c))(param_1,iVar7);
                iVar3 = checkJavaException(param_1);
                if (iVar3 == 0) {
                  (**(code **)(*param_1 + 0x5c))(param_1,iVar8);
                  iVar3 = checkJavaException(param_1);
                  if (iVar3 == 0) {
                    (**(code **)(*param_1 + 0x5c))(param_1,iVar9);
                    iVar3 = checkJavaException(param_1);
                    if (iVar3 == 0) {
                      (**(code **)(*param_1 + 0x5c))(param_1,iVar10);
                      iVar3 = checkJavaException(param_1);
                      if (iVar3 == 0) {
                        return 0;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        pcVar13 = "delete fail!";
      }
      else {
        pcVar13 = "call handle fail!";
      }
    }
  }
  log2Console(6,&DAT_00034c70,pcVar13);
  return 0xffffffff;
}



bool jni_putNativeKeyValue(int *param_1,undefined4 param_2,int param_3,int param_4)

{
  int iVar1;
  int iVar2;
  bool bVar3;
  
  bVar3 = false;
  if (((param_1 != (int *)0x0) && (param_3 != 0)) && (param_4 != 0)) {
    iVar1 = (**(code **)(*param_1 + 0x2a4))(param_1,param_3,0);
    if (iVar1 == 0) {
      log2Console(5,&DAT_00034c70,"jni_putNativeKeyValue: key is null.");
      bVar3 = false;
    }
    else {
      iVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_4,0);
      if (iVar2 == 0) {
        log2Console(5,&DAT_00034c70,"jni_putNativeKeyValue: value is null.");
      }
      else {
        putNativeKeyValue(iVar1,iVar2);
        (**(code **)(*param_1 + 0x2a8))(param_1,param_4,iVar2);
      }
      bVar3 = iVar2 != 0;
      (**(code **)(*param_1 + 0x2a8))(param_1,param_3,iVar1);
    }
  }
  return bVar3;
}



undefined4 jni_getNativeKeyValueList(void)

{
  return 0;
}



undefined4 jni_removeNativeKeyValue(void)

{
  return 0;
}



void jni_setNativeInfo(int *param_1,undefined4 param_2,int param_3,int param_4)

{
  undefined1 uVar1;
  int iVar2;
  char *__s;
  undefined1 *puVar3;
  size_t __maxlen;
  
  if ((param_1 == (int *)0x0) || (param_4 == 0)) {
    return;
  }
  iVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_4,0);
  log2Console(4,&DAT_00034c70,"jni_setNativeInfo: key is %d",param_3);
  if (iVar2 == 0) {
    log2Console(5,&DAT_00034c70,"jni_setNativeInfo: value is null.");
    return;
  }
  switch(param_3) {
  case 10:
    log2Console(4,&DAT_00034c70,"Set native info: app version(%s)",iVar2);
    __maxlen = 0x80;
    __s = &DAT_0003d504;
    goto LAB_0001838c;
  case 0xb:
    log2Console(4,&DAT_00034c70,"Set native info: user ID(%s)",iVar2);
    __s = &DAT_0003d584;
    goto LAB_00018348;
  case 0xc:
    log2Console(4,&DAT_00034c70,"Set native info: app channel(%s)",iVar2);
    __s = &DAT_0003d684;
    goto LAB_00018348;
  case 0xd:
    log2Console(4,&DAT_00034c70,"Set native info: app package(%s)",iVar2);
    __s = &DAT_0003d784;
LAB_00018348:
    __maxlen = 0x100;
    goto LAB_0001838c;
  case 0xe:
    log2Console(4,&DAT_00034c70,"Set native info: isAppForeground(%s)",iVar2);
    __maxlen = 0x10;
    __s = &DAT_0003d88a;
    goto LAB_0001838c;
  case 0xf:
    log2Console(4,&DAT_00034c70,"Set native info: launchTime(%s)",iVar2);
    __maxlen = 0x20;
    __s = &DAT_0003d89a;
LAB_0001838c:
    snprintf(__s,__maxlen,"%s",iVar2);
    break;
  case 0x10:
    log2Console(4,&DAT_00034c70,"Set native info: testSubThreadCrash(%s)",iVar2);
    DAT_0003d886 = parseBoolString(iVar2);
    break;
  case 0x11:
    log2Console(4,&DAT_00034c70,"Set native info: testSigabrtCrash(%s)",iVar2);
    DAT_0003d887 = parseBoolString(iVar2);
    break;
  case 0x12:
    log2Console(4,&DAT_00034c70,"Set native info: testPendingException(%s)",iVar2);
    uVar1 = parseBoolString(iVar2);
    puVar3 = &DAT_0003d885;
    goto LAB_000183ea;
  case 0x13:
    HandleAnr(2);
    break;
  case 0x14:
    SendSigquitToSignalCatcher();
    break;
  case 0x15:
    parseBoolString(iVar2);
    UnblockSigquit();
    break;
  default:
    if (param_3 == 0x3e6) {
      log2Console(4,&DAT_00034c70,"Should filter system log for SIGABRT signal: %s",iVar2);
      parseBoolString(iVar2);
      break;
    }
    if (param_3 != 999) {
      log2Console(4,&DAT_00034c70,"Key is invalid: %d",param_3);
      break;
    }
    log2Console(4,&DAT_00034c70,"Should handle in Java: %s",iVar2);
    uVar1 = parseBoolString(iVar2);
    puVar3 = &DAT_0003d004;
LAB_000183ea:
    *puVar3 = uVar1;
  }
                    // WARNING: Could not recover jumptable at 0x00018440. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(*param_1 + 0x2a8))(param_1,param_4,iVar2);
  return;
}



void jni_getSoCpuAbi(undefined4 param_1)

{
  log2Console(3,&DAT_00034c70,"call getRunningCpuAbi:%s","armeabi-v7a");
  toJavaString(param_1,"armeabi-v7a",0xc);
  return;
}



void jni_regist(int *param_1,undefined4 param_2,undefined4 param_3,int param_4,undefined4 param_5)

{
  _union_1051 _Var1;
  undefined4 uVar2;
  int iVar3;
  int *piVar4;
  char *pcVar5;
  char *pcVar6;
  char *pcVar7;
  undefined1 *puVar8;
  _union_1051 _Stack_38;
  undefined4 uStack_34;
  undefined4 uStack_30;
  int iStack_28;
  
  iStack_28 = __stack_chk_guard;
  if (param_4 == 0) {
    uVar2 = 6;
  }
  else {
    uVar2 = 3;
  }
  setLogMode(uVar2);
  log2Console(4,&DAT_00034c70,"regist start");
  toJavaString(param_1,"4.1.9",5);
  iVar3 = (**(code **)(*param_1 + 0x36c))(param_1,&jvm);
  if (iVar3 != 0) {
    piVar4 = (int *)__errno();
    pcVar5 = strerror(*piVar4);
    log2Console(6,&DAT_00034c70,"get jvm fail! %s",pcVar5);
    goto LAB_00017d80;
  }
  JAR_JNI_VERSION = param_5;
  log2Console(4,&DAT_00034c70,"JARJNIVERSION:%d");
  uVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_3,0);
  snprintf(recordFileDir,0x100,"%s",uVar2);
  pcVar5 = "native_record_lock";
  snprintf(lockFilePath,0x100,"%s/../files/%s",recordFileDir,"native_record_lock");
  log2Console(4,&DAT_00034c70,"set signal stack");
  _Stack_38.sa_handler = (__sighandler_t)calloc(1,0x4000);
  uStack_30 = 0x4000;
  uStack_34 = 0;
  if (_Stack_38.sa_handler == (__sighandler_t)0x0) {
    piVar4 = (int *)__errno();
    pcVar6 = strerror(*piVar4);
    pcVar7 = "malloc stack size fail! %s";
LAB_00017bb0:
    log2Console(6,&DAT_00034c70,pcVar7,pcVar6);
  }
  else {
    uStack_30 = 0x4000;
    iVar3 = sigaltstack((sigaltstack *)&_Stack_38,(sigaltstack *)0x0);
    if (iVar3 == -1) {
      piVar4 = (int *)__errno();
      pcVar6 = strerror(*piVar4);
      pcVar7 = "sigaltstack fail! %s";
      goto LAB_00017bb0;
    }
  }
  if (DAT_0003d0f0 == '\x01') {
    pcVar6 = "already regist, just return";
  }
  else {
    DAT_0003d0f0 = '\x01';
    uStack_34 = 0;
    _Stack_38 = (_union_1051)0x16e35;
    uStack_30 = 0x18000004;
    sigaction(4,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d134);
    sigaction(5,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d144);
    sigaction(0x10,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d1f4);
    sigaction(0xb,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d1a4);
    sigaction(6,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d154);
    sigaction(8,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d174);
    sigaction(7,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d164);
    log2Console(4,&DAT_00034c70,"regist anr sigquit handler");
    sigaction(3,(sigaction *)&_Stack_38,(sigaction *)&DAT_0003d124);
    UnblockSigquit(1);
    pcVar6 = "regist native handler";
  }
  log2Console(4,&DAT_00034c70,pcVar6);
  iVar3 = gettimeofday((timeval *)&_Stack_38,(__timezone_ptr_t)0x0);
  _Var1 = _Stack_38;
  if (iVar3 < 0) {
    piVar4 = (int *)__errno();
    puVar8 = strerror(*piVar4);
    uVar2 = 5;
    pcVar6 = "Failed to get time, error: %s";
  }
  else {
    uVar2 = __aeabi_idiv(uStack_34,1000);
    puVar8 = sysLogPath;
    snprintf(sysLogPath,0x100,"%s/%s_%lu%03lu.txt",recordFileDir,"sys_log",_Var1.sa_handler,uVar2);
    DAT_0003d02c = open(sysLogPath,0x241,0x180);
    if (DAT_0003d02c < 0) {
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to open system log file %s:, error: %s";
    }
    else {
      log2Console(4,&DAT_00034c70,"Opened system log record file: %s",sysLogPath);
      pcVar5 = "jni_log";
      puVar8 = jniLogPath;
      snprintf(jniLogPath,0x100,"%s/%s_%lu%03lu.txt",recordFileDir,"jni_log",_Var1.sa_handler,uVar2)
      ;
      DAT_0003d030 = open(jniLogPath,0x241,0x180);
      if (-1 < DAT_0003d030) {
        uVar2 = 4;
        pcVar6 = "Opened JNI log record file: %s";
        goto LAB_00017d4a;
      }
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to open JNI log file %s:, error: %s";
    }
    uVar2 = 5;
  }
LAB_00017d4a:
  log2Console(uVar2,&DAT_00034c70,pcVar6,puVar8,pcVar5);
  printBuglySoArch(0xffffffff);
  log2Console(4,&DAT_00034c70,"NativeBuglyVersion:%s","4.1.9");
  initStackBuffer(recordFileDir);
  eupInfo = calloc(1,0x4a4);
LAB_00017d80:
  if (__stack_chk_guard - iStack_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - iStack_28);
}



void jni_unregist(undefined4 param_1)

{
  unregistSignalHanlder();
  toJavaString(param_1,"4.1.9",5);
  return;
}



void jni_testCrash(void)

{
  doACrash(DAT_0003d886,DAT_0003d887);
  return;
}



undefined4 jni_appendNativeLog(int *param_1,undefined4 param_2,int param_3,int param_4,int param_5)

{
  int iVar1;
  int iVar2;
  int iVar3;
  undefined4 uVar4;
  char *pcVar5;
  
  if ((((param_1 != (int *)0x0) && (param_3 != 0)) && (param_4 != 0)) && (param_5 != 0)) {
    iVar1 = (**(code **)(*param_1 + 0x2a4))
                      (param_1,param_3,0,*(code **)(*param_1 + 0x2a4),&stack0xfffffff8);
    if (iVar1 == 0) {
      pcVar5 = "jni_appendNativeLog: level is null.";
    }
    else {
      iVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_4,0);
      if (iVar2 == 0) {
        pcVar5 = "jni_appendNativeLog: tag is null.";
      }
      else {
        iVar3 = (**(code **)(*param_1 + 0x2a4))(param_1,param_5,0);
        if (iVar3 != 0) {
          uVar4 = appendNativeLog(iVar1,iVar2,iVar3);
          (**(code **)(*param_1 + 0x2a8))(param_1,param_3,iVar1);
          (**(code **)(*param_1 + 0x2a8))(param_1,param_4,iVar2);
          (**(code **)(*param_1 + 0x2a8))(param_1,param_5,iVar3);
          return uVar4;
        }
        pcVar5 = "jni_appendNativeLog: log is null.";
      }
    }
    log2Console(5,&DAT_00034c70,pcVar5);
  }
  return 0;
}



undefined4 jni_getNativeLog(int param_1)

{
  char *__s;
  int iVar1;
  size_t sVar2;
  undefined4 uVar3;
  
  if (param_1 != 0) {
    __s = (char *)calloc(0x7801,1);
    iVar1 = getNativeLog(__s,0x7800);
    if (iVar1 != 0) {
      sVar2 = strlen(__s);
      uVar3 = toJavaString(param_1,__s,sVar2);
      free(__s);
      return uVar3;
    }
  }
  return 0;
}



undefined4 jni_appendWholeNativeLog(int *param_1,undefined4 param_2,int param_3)

{
  int iVar1;
  undefined4 uVar2;
  
  uVar2 = 0;
  if ((param_1 != (int *)0x0) && (param_3 != 0)) {
    iVar1 = (**(code **)(*param_1 + 0x2a4))(param_1,param_3,0);
    if (iVar1 == 0) {
      log2Console(5,&DAT_00034c70,"jni_appendWholeNativeLog: log is null.");
      uVar2 = 0;
    }
    else {
      uVar2 = appendWholeNativeLog();
      (**(code **)(*param_1 + 0x2a8))(param_1,param_3,iVar1);
    }
  }
  return uVar2;
}



void initCurrentMapInfoList(void)

{
  initCurrentMapInfoList();
  return;
}



void initLocalMapInfoList(void)

{
  initLocalMapInfoList();
  return;
}



void __aeabi_memclr8(void)

{
  __aeabi_memclr8();
  return;
}



void getAbortMessage(void)

{
  getAbortMessage();
  return;
}



void log2Report(void)

{
  log2Report();
  return;
}



void freeMapInfoList(void)

{
  freeMapInfoList();
  return;
}



void findModuleInMapInfoList(void)

{
  findModuleInMapInfoList();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int strcmp(char *__s1,char *__s2)

{
  int iVar1;
  
  iVar1 = strcmp(__s1,__s2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int isascii(int __c)

{
  int iVar1;
  
  iVar1 = isascii(__c);
  return iVar1;
}



void searchSymbolInElfFile(void)

{
  searchSymbolInElfFile();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strdup(char *__s)

{
  char *pcVar1;
  
  pcVar1 = strdup(__s);
  return pcVar1;
}



void getElfInfoWithSymbolTable(void)

{
  getElfInfoWithSymbolTable();
  return;
}



void init_dl_iterate_phdr_wrapper(void)

{
  init_dl_iterate_phdr_wrapper();
  return;
}



void backtraceStackWithLibUnwind(void)

{
  backtraceStackWithLibUnwind();
  return;
}



void recordAllMapInfo(void)

{
  recordAllMapInfo();
  return;
}



void miniBacktraceStackWithLibUnwind(void)

{
  miniBacktraceStackWithLibUnwind();
  return;
}



void dladdr(void)

{
  dladdr();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

FILE * fopen(char *__filename,char *__modes)

{
  FILE *pFVar1;
  
  pFVar1 = fopen(__filename,__modes);
  return pFVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fclose(FILE *__stream)

{
  int iVar1;
  
  iVar1 = fclose(__stream);
  return iVar1;
}



void log2File(void)

{
  log2File();
  return;
}



void recordRegisterInfo2File(void)

{
  recordRegisterInfo2File();
  return;
}



void initCurrentXMapInfoList(void)

{
  initCurrentXMapInfoList();
  return;
}



void recordMapInfo2File(void)

{
  recordMapInfo2File();
  return;
}



void recordHead(void)

{
  recordHead();
  return;
}



void recordProperty(void)

{
  recordProperty();
  return;
}



void getNativeKeyValueList(void)

{
  getNativeKeyValueList();
  return;
}



void recordLine(void)

{
  recordLine();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strchr(char *__s,int __c)

{
  char *pcVar1;
  
  pcVar1 = strchr(__s,__c);
  return pcVar1;
}



void getElfInfo(void)

{
  getElfInfo();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int sprintf(char *__s,char *__format,...)

{
  int iVar1;
  
  iVar1 = sprintf(__s,__format);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * fgets(char *__s,int __n,FILE *__stream)

{
  char *pcVar1;
  
  pcVar1 = fgets(__s,__n,__stream);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strncpy(char *__dest,char *__src,size_t __n)

{
  char *pcVar1;
  
  pcVar1 = strncpy(__dest,__src,__n);
  return pcVar1;
}



void searchSymbol(void)

{
  searchSymbol();
  return;
}



undefined8 GetAbortMessageAfterQ(undefined4 *param_1,char *param_2,uint param_3)

{
  int iVar1;
  undefined4 uVar2;
  char *pcVar3;
  int *piVar4;
  undefined4 unaff_r5;
  uint __n;
  
  log2Console(6,&DAT_00034c70,"get abort message after Q");
  if (param_1 == (undefined4 *)0x0) {
    pcVar3 = "maps is null";
  }
  else {
    for (; param_1 != (undefined4 *)0x0; param_1 = (undefined4 *)*param_1) {
      iVar1 = strcmp((char *)((int)param_1 + 0x27),"[anon:abort message]");
      if (iVar1 == 0) {
        log2Console(3,&DAT_00034c70,"found vma area [anon:abort message], begin check");
        piVar4 = (int *)param_1[1];
        pcVar3 = "magic 1 compare wrong";
        if ((*piVar4 == 0x6ac388f0 && piVar4[1] == -0x4e71bf78) &&
           (pcVar3 = "magic 2 compare wrong", piVar4[2] == 0x5a1de0b5 && piVar4[3] == -0x3920458b))
        {
          log2Console(3,&DAT_00034c70,"found [anon:abort message]");
          __n = piVar4[4];
          if (param_3 < (uint)piVar4[4]) {
            __n = param_3;
          }
          if (0 < (int)__n) {
            strncpy(param_2,(char *)(piVar4 + 5),__n);
            param_2[__n + 1] = '\0';
            log2Console(3,&DAT_00034c70,"the abort msg is %s",param_2);
          }
          uVar2 = 1;
          goto LAB_0001a8f4;
        }
        log2Console(4,&DAT_00034c70,pcVar3);
      }
    }
    pcVar3 = "oops, didn\'t found [anon:abort message]";
  }
  log2Console(4,&DAT_00034c70,pcVar3);
  uVar2 = 0;
LAB_0001a8f4:
  return CONCAT44(unaff_r5,uVar2);
}



void GetAbortMessageBeforeQ(void)

{
  GetAbortMessageBeforeQ();
  return;
}



void freeSymbolTable(void)

{
  freeSymbolTable();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fstat(int __fd,stat *__buf)

{
  int iVar1;
  
  iVar1 = fstat(__fd,__buf);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * mmap(void *__addr,size_t __len,int __prot,int __flags,int __fd,__off_t __offset)

{
  void *pvVar1;
  
  pvVar1 = mmap(__addr,__len,__prot,__flags,__fd,__offset);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int munmap(void *__addr,size_t __len)

{
  int iVar1;
  
  iVar1 = munmap(__addr,__len);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int strncmp(char *__s1,char *__s2,size_t __n)

{
  int iVar1;
  
  iVar1 = strncmp(__s1,__s2,__n);
  return iVar1;
}



void parseElfVersion(void)

{
  parseElfVersion();
  return;
}



void __aeabi_uldivmod(void)

{
  __aeabi_uldivmod();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void qsort(void *__base,size_t __nmemb,size_t __size,__compar_fn_t __compar)

{
  qsort(__base,__nmemb,__size,__compar);
  return;
}



void parseElf(void)

{
  parseElf();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = malloc(__size);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * bsearch(void *__key,void *__base,size_t __nmemb,size_t __size,__compar_fn_t __compar)

{
  void *pvVar1;
  
  pvVar1 = bsearch(__key,__base,__nmemb,__size,__compar);
  return pvVar1;
}



void createSymbolTable(void)

{
  createSymbolTable();
  return;
}



void searchSymbolTable(undefined4 *param_1,int param_2)

{
  void *pvVar1;
  int iStack_18;
  int iStack_14;
  
  iStack_14 = __stack_chk_guard;
  pvVar1 = (void *)0x0;
  iStack_18 = param_2;
  if ((param_1 != (undefined4 *)0x0) && (param_2 != 0)) {
    pvVar1 = bsearch(&iStack_18,(void *)*param_1,param_1[1],0xc,(__compar_fn_t)&LAB_0001b954_1);
  }
  if (__stack_chk_guard == iStack_14) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(pvVar1);
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int sscanf(char *__s,char *__format,...)

{
  int iVar1;
  
  iVar1 = sscanf(__s,__format);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int isspace(int param_1)

{
  int iVar1;
  
  iVar1 = isspace(param_1);
  return iVar1;
}



void get_elf_exec_load_bias(void)

{
  get_elf_exec_load_bias();
  return;
}



void __aeabi_memclr(void)

{
  __aeabi_memclr();
  return;
}



void initMapInfoList(int param_1,uint param_2,byte param_3)

{
  char cVar1;
  bool bVar2;
  bool bVar3;
  bool bVar4;
  bool bVar5;
  char *pcVar6;
  char *pcVar7;
  char *__s;
  FILE *__stream;
  char *pcVar8;
  size_t sVar9;
  int iVar10;
  int iVar11;
  char *pcVar12;
  undefined4 uVar13;
  int *piVar14;
  undefined4 *puVar15;
  uint uVar16;
  undefined4 *puVar17;
  byte *pbVar18;
  bool bVar19;
  int iStack_44;
  undefined4 uStack_40;
  undefined4 uStack_3c;
  char *pcStack_38;
  char *pcStack_34;
  char cStack_2d;
  char cStack_2c;
  char cStack_2b;
  int iStack_28;
  
  iStack_28 = __stack_chk_guard;
  if (1 < param_1) {
    pcVar7 = (char *)calloc(1,0x100);
    __s = (char *)calloc(1,0x400);
    sprintf(pcVar7,"/proc/%d/maps",param_1);
    log2Console(4,&DAT_00034c70,"Create map list by maps file: %s",pcVar7);
    __stream = fopen(pcVar7,"r");
    if (__stream == (FILE *)0x0) {
      piVar14 = (int *)__errno();
      pcVar7 = strerror(*piVar14);
      log2Console(4,&DAT_00034c70,"Failed to open maps file for: %s",pcVar7);
    }
    else {
      puVar17 = (undefined4 *)0x0;
LAB_0001bae8:
      pcVar8 = fgets(__s,0x400,__stream);
      if (pcVar8 != (char *)0x0) {
        if ((__s != (char *)0x0) && (sVar9 = strlen(__s), 0x31 < sVar9)) {
          log2Console(3,&DAT_00034c70,"Parsing line: %s",__s);
          pcVar8 = strchr(__s,0x28);
          if (pcVar8 != (char *)0x0) goto LAB_0001bc8a;
          iVar10 = sscanf(__s,"%lx-%lx %4s %lx %*x:%*x %lu%n",&pcStack_34,&pcStack_38,&cStack_2d,
                          &uStack_3c,&uStack_40,&iStack_44);
          if (iVar10 == 5) {
            sVar9 = strlen(&cStack_2d);
            cVar1 = cStack_2b;
            pcVar6 = pcStack_34;
            pcVar8 = pcStack_38;
            bVar2 = sVar9 == 4;
            bVar3 = bVar2 && cStack_2b == 'x';
            if ((param_2 ^ 1 | (uint)bVar3) != 1) goto LAB_0001bc6e;
            puVar15 = (undefined4 *)0x0;
            if ((pcStack_34 != (char *)0x0) && (pcStack_34 != pcStack_38)) {
              bVar4 = cStack_2c == 'w';
              bVar5 = bVar2 && cStack_2d == 'r';
              pbVar18 = (byte *)(__s + iStack_44 + 1);
              while( true ) {
                iVar10 = iStack_44;
                uVar16 = (uint)(byte)__s[iStack_44];
                iVar11 = isspace(uVar16);
                if (iVar11 == 0) break;
                iStack_44 = iVar10 + 1;
                pbVar18 = pbVar18 + 1;
              }
              iVar11 = 0;
              do {
                if (uVar16 != 10) {
                  if (uVar16 == 0) goto code_r0x0001bbf2;
                  iVar11 = iVar11 + 1;
                }
                uVar16 = (uint)*pbVar18;
                pbVar18 = pbVar18 + 1;
              } while( true );
            }
          }
          else {
            log2Console(5,&DAT_00034c70,"Failed to parse the line of maps file.");
LAB_0001bc6e:
            puVar15 = (undefined4 *)0x0;
          }
          goto LAB_0001bc70;
        }
        goto LAB_0001bc8a;
      }
      free(__s);
      free(pcVar7);
      fclose(__stream);
    }
  }
  if (__stack_chk_guard - iStack_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - iStack_28);
  }
  return;
code_r0x0001bbf2:
  pcVar12 = "<null>";
  if (iVar11 == 0) {
    iVar11 = 6;
  }
  else {
    pcVar12 = __s + iVar10;
  }
  puVar15 = (undefined4 *)calloc(1,iVar11 + 0x29);
  if (puVar15 == (undefined4 *)0x0) {
    log2Console(4,&DAT_00034c70,"Failed to alloc memory for MapInfo.");
    puVar15 = (undefined4 *)0x0;
  }
  else {
    puVar15[1] = pcVar6;
    if (((param_3 & bVar5) == 1) && (cVar1 == 'x')) {
      cVar1 = *pcVar6;
      bVar19 = cVar1 == '\x7f';
      if (bVar19) {
        cVar1 = pcVar6[1];
      }
      if (bVar19 && cVar1 == 'E') {
        cVar1 = pcVar6[2];
        bVar19 = cVar1 == 'L';
        if (bVar19) {
          cVar1 = pcVar6[3];
        }
        if (bVar19 && cVar1 == 'F') {
          uVar13 = get_elf_exec_load_bias(pcVar6);
          puVar15[6] = uVar13;
          pcVar8 = pcStack_38;
        }
      }
    }
    puVar15[2] = pcVar8;
    puVar15[3] = uStack_3c;
    puVar15[4] = uStack_40;
    puVar15[5] = 0;
    *(bool *)(puVar15 + 9) = bVar5;
    *(bool *)((int)puVar15 + 0x25) = bVar4 && bVar2;
    *(bool *)((int)puVar15 + 0x26) = bVar3;
    __aeabi_memcpy((int)puVar15 + 0x27,pcVar12,iVar11);
    *(undefined1 *)((int)puVar15 + 0x27 + iVar11) = 0;
  }
LAB_0001bc70:
  if ((puVar15 != (undefined4 *)0x0) &&
     ((puVar17 == (undefined4 *)0x0 || (puVar15[1] != puVar17[1])))) {
    *puVar15 = puVar17;
    puVar17 = puVar15;
  }
LAB_0001bc8a:
  __aeabi_memclr(__s,0x400);
  goto LAB_0001bae8;
}



void initXMapInfoList(void)

{
  initXMapInfoList();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_mutex_lock(pthread_mutex_t *__mutex)

{
  int iVar1;
  
  iVar1 = pthread_mutex_lock(__mutex);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_mutex_unlock(pthread_mutex_t *__mutex)

{
  int iVar1;
  
  iVar1 = pthread_mutex_unlock(__mutex);
  return iVar1;
}



void removeNativeKeyValue(void)

{
  removeNativeKeyValue();
  return;
}



void __aeabi_uidivmod(void)

{
  __aeabi_uidivmod();
  return;
}



void __android_log_vprint(void)

{
  __android_log_vprint();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int vsnprintf(char *__s,size_t __maxlen,char *__format,__gnuc_va_list __arg)

{
  int iVar1;
  
  iVar1 = vsnprintf(__s,__maxlen,__format,__arg);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t write(int __fd,void *__buf,size_t __n)

{
  ssize_t sVar1;
  
  sVar1 = write(__fd,__buf,__n);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t fwrite(void *__ptr,size_t __size,size_t __n,FILE *__s)

{
  size_t sVar1;
  
  sVar1 = fwrite(__ptr,__size,__n,__s);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int putc(int __c,FILE *__stream)

{
  int iVar1;
  
  iVar1 = putc(__c,__stream);
  return iVar1;
}



void recordStr(void)

{
  recordStr();
  return;
}



void constructJavaObjectArray(void)

{
  constructJavaObjectArray();
  return;
}



void insertToJavaObjectArray(void)

{
  insertToJavaObjectArray();
  return;
}



void getJavaMethodID(void)

{
  getJavaMethodID();
  return;
}



void constructUploadExtraMessage(void)

{
  constructUploadExtraMessage();
  return;
}



void getJavaThreadName(void)

{
  getJavaThreadName();
  return;
}



void javaObjectCall_Thread_GetStackTrace(void)

{
  javaObjectCall_Thread_GetStackTrace();
  return;
}



void javaStaticCall_Thread_CurrentThread(void)

{
  javaStaticCall_Thread_CurrentThread();
  return;
}



void getJavaThreadStackByThreadObject(void)

{
  getJavaThreadStackByThreadObject();
  return;
}



void getJavaStaticMethodID(void)

{
  getJavaStaticMethodID();
  return;
}



void getKeySetArrayOfMap(void)

{
  getKeySetArrayOfMap();
  return;
}



void getSameNameThreadIdArray(void)

{
  getSameNameThreadIdArray();
  return;
}



void getIndexOfIntArray(void)

{
  getIndexOfIntArray();
  return;
}



void getJavaThreadId(void)

{
  getJavaThreadId();
  return;
}



int getJavaThreadByName(int *param_1,undefined4 param_2,char *param_3)

{
  int iVar1;
  int iVar2;
  size_t __nmemb;
  int iVar3;
  void *__ptr;
  void *__base;
  size_t __nmemb_00;
  size_t sVar4;
  int iVar5;
  undefined4 uVar6;
  char *pcVar7;
  char *pcVar8;
  int iVar9;
  int iVar10;
  int iStack_58;
  size_t sStack_3c;
  
  if (param_1 == (int *)0x0) {
    return 0;
  }
  log2Console(4,&DAT_00034c70,"Try to find Java thread by Name: %s",param_3);
  iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"java/lang/Thread");
  iVar2 = checkJavaException(param_1);
  if ((iVar1 == 0) || (iVar2 != 0)) {
    pcVar7 = "Failed to find class: %s";
    pcVar8 = "java/lang/Thread";
  }
  else {
    iVar2 = getJavaStaticMethodID
                      (param_1,"java/lang/Thread","getAllStackTraces","()Ljava/util/Map;");
    if (iVar2 == 0) {
      return 0;
    }
    iVar1 = (**(code **)(*param_1 + 0x1c8))(param_1,iVar1,iVar2);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 != 0) && (iVar2 == 0)) {
      iVar2 = getKeySetArrayOfMap(param_1,iVar1);
      if (iVar2 == 0) {
        pcVar7 = "Failed to get keySet array of map!";
      }
      else {
        __nmemb = (**(code **)(*param_1 + 0x2ac))(param_1,iVar2);
        iVar3 = checkJavaException(param_1);
        if (iVar3 == 0) {
          __ptr = calloc(__nmemb,4);
          __base = calloc(__nmemb,4);
          __nmemb_00 = getSameNameThreadIdArray(param_3,__ptr,__nmemb,1);
          if ((int)__nmemb_00 < 2) {
            iStack_58 = 0;
          }
          else {
            log2Console(4,&DAT_00034c70,"Found multiple Linux threads (%d) matched the name: %s",
                        __nmemb_00,param_3);
            iStack_58 = getIndexOfIntArray(param_2,__ptr,__nmemb_00);
            log2Console(4,&DAT_00034c70,"Index of Linux thread ID array: %d",iStack_58);
          }
          sStack_3c = 0;
          for (iVar3 = 0; iVar3 < (int)__nmemb; iVar3 = iVar3 + 1) {
            iVar10 = (**(code **)(*param_1 + 0x2b4))(param_1,iVar2,iVar3);
            iVar9 = checkJavaException(param_1);
            if ((iVar10 == 0) || (iVar9 != 0)) {
              log2Console(6,&DAT_00034c70,"Failed to get array element.");
              break;
            }
            pcVar7 = (char *)getJavaThreadName(param_1,iVar10);
            if (pcVar7 == (char *)0x0) {
              log2Console(5,&DAT_00034c70,"Failed to get thread name.");
            }
            else {
              uVar6 = getJavaThreadId(param_1,iVar10);
              pcVar8 = pcVar7;
              log2Console(4,&DAT_00034c70,&DAT_0003812a,uVar6,pcVar7);
              sVar4 = strlen(pcVar7);
              iVar9 = strncmp(pcVar7,param_3,0xf);
              if (sVar4 < 0x10) {
                if (iVar9 == 0) {
                  log2Console(4,&DAT_00034c70,"Found the matched Java thread: %s",pcVar7,pcVar8);
                  goto LAB_0001df06;
                }
              }
              else if (iVar9 == 0) {
                log2Console(4,&DAT_00034c70,"Found a matched Java thread: %s",pcVar7,pcVar8);
                *(undefined4 *)((int)__base + sStack_3c * 4) = uVar6;
                sStack_3c = sStack_3c + 1;
              }
              (**(code **)(*param_1 + 0x5c))(param_1,iVar10);
              iVar9 = checkJavaException(param_1);
              if (iVar9 != 0) {
                log2Console(6,&DAT_00034c70,"Failed to delete local reference.");
                break;
              }
            }
          }
          log2Console(3,&DAT_00034c70,"Length of matched Java thread ID array: %d",sStack_3c);
          iVar10 = 0;
          if ((0 < (int)sStack_3c) && (sStack_3c == __nmemb_00)) {
            if (1 < (int)__nmemb_00) {
              qsort(__base,__nmemb_00,4,intArrayCompare);
            }
            iVar9 = *(int *)((int)__base + iStack_58 * 4);
            log2Console(3,&DAT_00034c70,"ID of Java thread matched Linux thread (%d): %d",param_2,
                        iVar9);
            iVar3 = 0;
            do {
              if ((int)__nmemb <= iVar3) goto LAB_0001dee8;
              iVar10 = (**(code **)(*param_1 + 0x2b4))(param_1,iVar2,iVar3);
              iVar5 = checkJavaException(param_1);
              if ((iVar10 == 0) || (iVar5 != 0)) {
                pcVar7 = "Failed to get array element.";
                goto LAB_0001dee2;
              }
              iVar5 = getJavaThreadId(param_1,iVar10);
              if (iVar5 == iVar9) {
                uVar6 = getJavaThreadName(param_1,iVar10);
                log2Console(3,&DAT_00034c70,"Java thread matched is: %s",uVar6);
                goto LAB_0001df06;
              }
              (**(code **)(*param_1 + 0x5c))(param_1,iVar10);
              iVar10 = checkJavaException(param_1);
              iVar3 = iVar3 + 1;
            } while (iVar10 == 0);
            pcVar7 = "Failed to delete local reference.";
LAB_0001dee2:
            log2Console(6,&DAT_00034c70,pcVar7);
LAB_0001dee8:
            iVar10 = 0;
          }
LAB_0001df06:
          (**(code **)(*param_1 + 0x5c))(param_1,iVar2);
          iVar2 = checkJavaException(param_1);
          if (iVar2 != 0) {
            log2Console(6,&DAT_00034c70,"Failed to delete local reference: keySetArray");
          }
          (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
          iVar1 = checkJavaException(param_1);
          if (iVar1 != 0) {
            log2Console(6,&DAT_00034c70,"Failed to delete local reference: map");
          }
          free(__base);
          free(__ptr);
          return iVar10;
        }
        pcVar7 = "Failed to get array length.";
      }
      log2Console(6,&DAT_00034c70,pcVar7);
      return 0;
    }
    pcVar7 = "Failed to call: %s";
    pcVar8 = "getAllStackTraces";
  }
  log2Console(6,&DAT_00034c70,pcVar7,pcVar8);
  return 0;
}



void getJavaMainThread(void)

{
  getJavaMainThread();
  return;
}



void getJavaThread(void)

{
  getJavaThread();
  return;
}



void javaTheadDump(void)

{
  javaTheadDump();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

time_t time(time_t *__timer)

{
  time_t tVar1;
  
  tVar1 = time(__timer);
  return tVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

tm * localtime(time_t *__timer)

{
  tm *ptVar1;
  
  ptVar1 = localtime(__timer);
  return ptVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t strftime(char *__s,size_t __maxsize,char *__format,tm *__tp)

{
  size_t sVar1;
  
  sVar1 = strftime(__s,__maxsize,__format,__tp);
  return sVar1;
}



void insertCircularQueue(void)

{
  insertCircularQueue();
  return;
}



void locateCircularQueue(void)

{
  locateCircularQueue();
  return;
}



void readCircularQueue(void)

{
  readCircularQueue();
  return;
}



void freeCircularQueue(void)

{
  freeCircularQueue();
  return;
}



void createCircularQueue(void)

{
  createCircularQueue();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int prctl(int __option,...)

{
  int iVar1;
  
  iVar1 = prctl(__option);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

DIR * opendir(char *__name)

{
  DIR *pDVar1;
  
  pDVar1 = opendir(__name);
  return pDVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long ptrace(__ptrace_request __request,...)

{
  long lVar1;
  
  lVar1 = ptrace(__request);
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

__pid_t waitpid(__pid_t __pid,int *__stat_loc,int __options)

{
  __pid_t _Var1;
  
  _Var1 = waitpid(__pid,__stat_loc,__options);
  return _Var1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

dirent * readdir(DIR *__dirp)

{
  dirent *pdVar1;
  
  pdVar1 = readdir(__dirp);
  return pdVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int closedir(DIR *__dirp)

{
  int iVar1;
  
  iVar1 = closedir(__dirp);
  return iVar1;
}



void __system_property_get(void)

{
  __system_property_get();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ulong strtoul(char *__nptr,char **__endptr,int __base)

{
  ulong uVar1;
  
  uVar1 = strtoul(__nptr,__endptr,__base);
  return uVar1;
}



void property_get(void)

{
  property_get();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

tm * localtime_r(time_t *__timer,tm *__tp)

{
  tm *ptVar1;
  
  ptVar1 = localtime_r(__timer,__tp);
  return ptVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

__pid_t fork(void)

{
  __pid_t _Var1;
  
  _Var1 = fork();
  return _Var1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int dup2(int __fd,int __fd2)

{
  int iVar1;
  
  iVar1 = dup2(__fd,__fd2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int execl(char *__path,char *__arg,...)

{
  int iVar1;
  
  iVar1 = execl(__path,__arg);
  return iVar1;
}



void dlerror(void)

{
  dlerror();
  return;
}



void dlopen(void)

{
  dlopen();
  return;
}



void print_dlerror(void)

{
  print_dlerror();
  return;
}



void dlsym(void)

{
  dlsym();
  return;
}



void open_library(void)

{
  open_library();
  return;
}



int get_opened_libraray_function(int param_1,int param_2)

{
  int iVar1;
  
  iVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    log2Console(4,&DAT_00034c70,"Try to find function: \'%s\'",param_2);
    iVar1 = dlsym(param_1,param_2);
    if (iVar1 == 0) {
      log2Console(5,&DAT_00034c70,"Can not locate function: \'%s\'",param_2);
      print_dlerror();
      iVar1 = 0;
    }
    else {
      log2Console(4,&DAT_00034c70,"Address of function \'%s\': %p",param_2,iVar1);
    }
  }
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int unlink(char *__name)

{
  int iVar1;
  
  iVar1 = unlink(__name);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int stat(char *__file,stat *__buf)

{
  int iVar1;
  
  iVar1 = stat(__file,__buf);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_sigmask(int __how,__sigset_t *__newmask,__sigset_t *__oldmask)

{
  int iVar1;
  
  iVar1 = pthread_sigmask(__how,__newmask,__oldmask);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long syscall(long __sysno,...)

{
  long lVar1;
  
  lVar1 = syscall(__sysno);
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_detach(pthread_t __th)

{
  int iVar1;
  
  iVar1 = pthread_detach(__th);
  return iVar1;
}



void GetAndUpdateAnrState(void)

{
  GetAndUpdateAnrState();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int dup(int __fd)

{
  int iVar1;
  
  iVar1 = dup(__fd);
  return iVar1;
}



void dynamic_load_create(void)

{
  dynamic_load_create();
  return;
}



void dynamic_load_sym(void)

{
  dynamic_load_sym();
  return;
}



void dynamic_load_destroy(void)

{
  dynamic_load_destroy();
  return;
}



void sigsetjmp(void)

{
  sigsetjmp();
  return;
}



void trim(void)

{
  trim();
  return;
}



void get_libraray_function(void)

{
  get_libraray_function();
  return;
}



void __aeabi_memclr4(void)

{
  __aeabi_memclr4();
  return;
}



void dl_iterate_phdr_wrapper(void)

{
  dl_iterate_phdr_wrapper();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * realloc(void *__ptr,size_t __size)

{
  void *pvVar1;
  
  pvVar1 = realloc(__ptr,__size);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void abort(void)

{
                    // WARNING: Subroutine does not return
  abort();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t fread(void *__ptr,size_t __size,size_t __n,FILE *__stream)

{
  size_t sVar1;
  
  sVar1 = fread(__ptr,__size,__n,__stream);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fseek(FILE *__stream,long __off,int __whence)

{
  int iVar1;
  
  iVar1 = fseek(__stream,__off,__whence);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memchr(void *__s,int __c,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memchr(__s,__c,__n);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strrchr(char *__s,int __c)

{
  char *pcVar1;
  
  pcVar1 = strrchr(__s,__c);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strcpy(char *__dest,char *__src)

{
  char *pcVar1;
  
  pcVar1 = strcpy(__dest,__src);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * getenv(char *__name)

{
  char *pcVar1;
  
  pcVar1 = getenv(__name);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int atoi(char *__nptr)

{
  int iVar1;
  
  iVar1 = atoi(__nptr);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int msync(void *__addr,size_t __len,int __flags)

{
  int iVar1;
  
  iVar1 = msync(__addr,__len,__flags);
  return iVar1;
}



void _Uelf32_memory_read(void)

{
  _Uelf32_memory_read();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long sysconf(int __name)

{
  long lVar1;
  
  lVar1 = sysconf(__name);
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_mutex_init(pthread_mutex_t *__mutex,pthread_mutexattr_t *__mutexattr)

{
  int iVar1;
  
  iVar1 = pthread_mutex_init(__mutex,__mutexattr);
  return iVar1;
}



void __aeabi_memset(void)

{
  __aeabi_memset();
  return;
}



void __aeabi_memcpy4(void)

{
  __aeabi_memcpy4();
  return;
}



void __aeabi_memmove(void)

{
  __aeabi_memmove();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

ssize_t read(int __fd,void *__buf,size_t __nbytes)

{
  ssize_t sVar1;
  
  sVar1 = read(__fd,__buf,__nbytes);
  return sVar1;
}



void _UPT_create(void)

{
  _UPT_create();
  return;
}



void _UPT_destroy(void)

{
  _UPT_destroy();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_once(pthread_once_t *__once_control,__init_routine *__init_routine)

{
  int iVar1;
  
  iVar1 = pthread_once(__once_control,__init_routine);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_rwlock_init(pthread_rwlock_t *__rwlock,pthread_rwlockattr_t *__attr)

{
  int iVar1;
  
  iVar1 = pthread_rwlock_init(__rwlock,__attr);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_rwlock_rdlock(pthread_rwlock_t *__rwlock)

{
  int iVar1;
  
  iVar1 = pthread_rwlock_rdlock(__rwlock);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_rwlock_unlock(pthread_rwlock_t *__rwlock)

{
  int iVar1;
  
  iVar1 = pthread_rwlock_unlock(__rwlock);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_rwlock_wrlock(pthread_rwlock_t *__rwlock)

{
  int iVar1;
  
  iVar1 = pthread_rwlock_wrlock(__rwlock);
  return iVar1;
}



void _UPT_find_proc_info(void)

{
  _UPT_find_proc_info();
  return;
}



void _UPT_put_unwind_info(void)

{
  _UPT_put_unwind_info();
  return;
}



void _UPT_get_dyn_info_list_addr(void)

{
  _UPT_get_dyn_info_list_addr();
  return;
}



void _UPT_access_mem(void)

{
  _UPT_access_mem();
  return;
}



void _UPT_access_reg(void)

{
  _UPT_access_reg();
  return;
}



void _UPT_access_fpreg(void)

{
  _UPT_access_fpreg();
  return;
}



void _UPT_resume(void)

{
  _UPT_resume();
  return;
}



void _UPT_get_proc_name(void)

{
  _UPT_get_proc_name();
  return;
}



void _Uarm_dwarf_find_unwind_table(void)

{
  _Uarm_dwarf_find_unwind_table();
  return;
}



void _U_dyn_info_list_addr(void)

{
  _U_dyn_info_list_addr();
  return;
}



void unw_get_reg(void)

{
  unw_get_reg();
  return;
}



void _Unwind_VRS_Pop(void)

{
  _Unwind_VRS_Pop();
  return;
}



void unw_set_reg(void)

{
  unw_set_reg();
  return;
}



void _Unwind_VRS_Get(void)

{
  _Unwind_VRS_Get();
  return;
}



void unw_save_vfp_as_X(void)

{
  unw_save_vfp_as_X();
  return;
}



void unw_get_fpreg(void)

{
  unw_get_fpreg();
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

int fflush(FILE *__stream)

{
  int iVar1;
  
  iVar1 = fflush(__stream);
  return iVar1;
}



void unw_set_fpreg(void)

{
  unw_set_fpreg();
  return;
}



void _Unwind_VRS_Set(void)

{
  _Unwind_VRS_Set();
  return;
}



void _Unwind_GetLanguageSpecificData(void)

{
  _Unwind_GetLanguageSpecificData();
  return;
}



void unw_step(void)

{
  unw_step();
  return;
}



void unw_getcontext(void)

{
  unw_getcontext();
  return;
}



void unw_init_local(void)

{
  unw_init_local();
  return;
}



void unw_get_proc_info(void)

{
  unw_get_proc_info();
  return;
}



void unw_resume(void)

{
  unw_resume();
  return;
}



void decode_eht_entry(void)

{
  decode_eht_entry();
  return;
}



void _Unwind_VRS_Interpret(void)

{
  _Unwind_VRS_Interpret();
  return;
}



void __gnu_Unwind_Find_exidx(void)

{
  __gnu_Unwind_Find_exidx();
  return;
}



void __gnu_uldivmod_helper(void)

{
  __gnu_uldivmod_helper();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int raise(int __sig)

{
  int iVar1;
  
  iVar1 = raise(__sig);
  return iVar1;
}



void __divdi3(void)

{
  __divdi3();
  return;
}



void __udivdi3(void)

{
  __udivdi3();
  return;
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

void * memcpy(void *__dest,void *__src,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memcpy(__dest,__src,__n);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void * memset(void *__s,int __c,size_t __n)

{
  void *pvVar1;
  
  pvVar1 = memset(__s,__c,__n);
  return pvVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int pthread_key_create(pthread_key_t *__key,__destr_function *__destr_function)

{
  int iVar1;
  
  iVar1 = pthread_key_create(__key,__destr_function);
  return iVar1;
}



void __aeabi_llsl(void)

{
  __aeabi_llsl();
  return;
}



void __aeabi_llsr(void)

{
  __aeabi_llsr();
  return;
}



void _FINI_1(void)

{
  __cxa_finalize(&DAT_0003d000);
  return;
}



void _FINI_0(void)

{
  if (DAT_000632a4 == 0) {
    return;
  }
  DAT_000632a4 = 0;
  pthread_key_delete(DAT_0006329c);
  return;
}



void unregistSignalHanlder(void)

{
  if (DAT_0003d0f0 == '\x01') {
    DAT_0003d0f0 = 0;
    sigaction(8,(sigaction *)&DAT_0003d174,(sigaction *)0x0);
    sigaction(4,(sigaction *)&DAT_0003d134,(sigaction *)0x0);
    sigaction(0xb,(sigaction *)&DAT_0003d1a4,(sigaction *)0x0);
    sigaction(7,(sigaction *)&DAT_0003d164,(sigaction *)0x0);
    sigaction(6,(sigaction *)&DAT_0003d154,(sigaction *)0x0);
    sigaction(5,(sigaction *)&DAT_0003d144,(sigaction *)0x0);
    sigaction(3,(sigaction *)&DAT_0003d124,(sigaction *)0x0);
    sigaction(0x10,(sigaction *)&DAT_0003d1f4,(sigaction *)0x0);
    log2Console(3,&DAT_00034c70,"Unregister signal handlers.");
    return;
  }
  return;
}



void delayRestoreSIGILLHandler(void)

{
  _union_1051 local_24;
  undefined4 uStack_20;
  undefined4 local_1c;
  int local_14;
  
  local_14 = __stack_chk_guard;
  sleep(1);
  local_24 = (_union_1051)0x16e35;
  uStack_20 = 0;
  local_1c = 0x18000004;
  sigaction(4,(sigaction *)&local_24,(sigaction *)&DAT_0003d134);
  if (__stack_chk_guard - local_14 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_14);
  }
  return;
}



void FUN_00016e34(int param_1,int param_2,undefined4 param_3)

{
  char *pcVar1;
  Elf32_Ehdr *pEVar2;
  __sighandler_t p_Var3;
  void *pvVar4;
  int *piVar5;
  int iVar6;
  undefined4 uVar7;
  size_t sVar8;
  uint uVar9;
  size_t sVar10;
  char *pcVar11;
  __pid_t _Var12;
  __jmp_buf_tag *__env;
  char *pcVar13;
  undefined4 uVar14;
  code *pcVar15;
  uint uVar16;
  _union_1051 _Var17;
  timeval local_50;
  timeval local_48;
  pthread_t pStack_40;
  _union_1051 local_3c;
  undefined4 local_38;
  code *local_34;
  undefined4 local_30;
  int *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(4,&DAT_00034c70,"receive signal signalNum:%d",param_1);
  pcVar1 = (char *)__emutls_get_address(__emutls_v_isDumpingTrace);
  if (*pcVar1 != '\0') {
    log2Console(5,&DAT_00034c70,"something wrong when dumping anr trace");
    __env = (__jmp_buf_tag *)__emutls_get_address(__emutls_v_jmpBuf);
                    // WARNING: Subroutine does not return
    siglongjmp(__env,1);
  }
  if (param_1 == 3) {
    if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
      __stack_chk_fail(__stack_chk_guard - local_28);
    }
    HandleAnr();
    return;
  }
  if ((((param_1 == 4) && (pEVar2 = *(Elf32_Ehdr **)(param_2 + 0xc), &Elf32_Ehdr_00010000 < pEVar2))
      && (DAT_0003d888 == '\0')) &&
     (DAT_0003d888 = '\x01', iVar6._0_1_ = pEVar2->e_ident_magic_num,
     iVar6._1_1_ = pEVar2->e_ident_magic_str[0], iVar6._2_1_ = pEVar2->e_ident_magic_str[1],
     iVar6._3_1_ = pEVar2->e_ident_magic_str[2], iVar6 == -0x13aef0e2)) {
    sigaction(4,(sigaction *)&DAT_0003d134,(sigaction *)0x0);
    pthread_create((pthread_t *)&local_3c,(pthread_attr_t *)0x0,delayRestoreSIGILLHandler,
                   (void *)0x0);
    log2Console(4,&DAT_00034c70,"opensslHandled return");
    goto LAB_00017978;
  }
  if (DAT_0003d889 == '\x01') {
    log2Console(4,&DAT_00034c70,"buglyHasHandled exit 1");
                    // WARNING: Subroutine does not return
    _exit(1);
  }
  DAT_0003d889 = '\x01';
  log2Console(4,&DAT_00034c70,"Register backup native handler");
  local_3c = (_union_1051)0x18b99;
  local_38 = 0;
  local_34 = (code *)0x8000004;
  sigaction(4,(sigaction *)&local_3c,(sigaction *)0x0);
  sigaction(0xb,(sigaction *)&local_3c,(sigaction *)0x0);
  sigaction(6,(sigaction *)&local_3c,(sigaction *)0x0);
  sigaction(8,(sigaction *)&local_3c,(sigaction *)0x0);
  sigaction(7,(sigaction *)&local_3c,(sigaction *)0x0);
  sigaction(5,(sigaction *)&local_3c,(sigaction *)0x0);
  sigaction(0x10,(sigaction *)&local_3c,(sigaction *)0x0);
  log2Console(4,&DAT_00034c70,"Bugly NDK version:%s","4.1.9");
  log2Console(4,&DAT_00034c70,"Old handler addresss %p",
              *(undefined4 *)(&DAT_0003d0f4 + param_1 * 0x10));
  log2Console(4,&DAT_00034c70,"HandleSignal start %d",param_1);
  lockFile(lockFilePath,10);
  log2Console(3,&DAT_00034c70,"Create a EupInfo object with size: %d ",0x4a4);
  p_Var3 = (__sighandler_t)calloc(1,0x4a4);
  *(undefined4 *)(p_Var3 + 0x20) = 0x2800;
  pvVar4 = calloc(1,0x2800);
  *(void **)(p_Var3 + 0x4a0) = pvVar4;
  if (p_Var3 == (__sighandler_t)0x0 || pvVar4 == (void *)0x0) {
    piVar5 = (int *)__errno();
    pcVar1 = strerror(*piVar5);
    log2Console(6,&DAT_00034c70,"Failed to create a EupInfo object: %s",pcVar1);
    p_Var3 = (__sighandler_t)0x0;
  }
  else {
    iVar6 = gettimeofday((timeval *)&local_3c,(__timezone_ptr_t)0x0);
    if (iVar6 < 0) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to get time: %s",pcVar1);
    }
    else {
      *(_union_1051 *)(p_Var3 + 0x28) = local_3c;
      *(undefined4 *)(p_Var3 + 0x2c) = local_38;
    }
    log2Console(3,&DAT_00034c70,"Directory for recording: %s",recordFileDir);
    uVar14 = *(undefined4 *)(p_Var3 + 0x28);
    uVar7 = __aeabi_uidiv(*(undefined4 *)(p_Var3 + 0x2c),1000);
    uVar9 = snprintf((char *)(p_Var3 + 0x120),0x100,"%s/tomb_%lu%03lu.txt",recordFileDir,uVar14,
                     uVar7);
    if (0x7fffffff < uVar9) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to set tomb path: %s",pcVar1);
    }
    log2Console(3,&DAT_00034c70,"Tomb path: %s",p_Var3 + 0x120);
    uVar9 = snprintf((char *)(p_Var3 + 0xe0),0x40,"%p",*(undefined4 *)(param_2 + 0xc),uVar14,uVar7);
    if (0x7fffffff < uVar9) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to set error addr: %s",pcVar1);
    }
    *(int *)(p_Var3 + 0xc) = param_1;
    log2Console(3,&DAT_00034c70,"Signal number: %d",param_1);
    uVar7 = getSignalName(param_1);
    uVar9 = snprintf((char *)(p_Var3 + 200),0x18,"%s",uVar7);
    if (0x7fffffff < uVar9) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to set Signal name: %s",pcVar1);
    }
    log2Console(3,&DAT_00034c70,"Signal name: %s",p_Var3 + 200);
    *(undefined4 *)(p_Var3 + 0x14) = *(undefined4 *)(param_2 + 8);
    log2Console(3,&DAT_00034c70,"Signal code: %d");
    iVar6 = *(int *)(p_Var3 + 0x14);
    if (iVar6 < 1) {
      uVar7 = *(undefined4 *)(param_2 + 0x10);
      *(undefined4 *)(p_Var3 + 0x18) = *(undefined4 *)(param_2 + 0xc);
      *(undefined4 *)(p_Var3 + 0x1c) = uVar7;
      log2Console(3,&DAT_00034c70,"Sending PID of signal: %d");
      log2Console(3,&DAT_00034c70,"Sending UID of signal: %d",*(undefined4 *)(p_Var3 + 0x1c));
      iVar6 = *(int *)(p_Var3 + 0x14);
    }
    uVar7 = getSigCode(param_1,iVar6);
    uVar9 = snprintf((char *)(p_Var3 + 0x30),0x18,"%s",uVar7);
    if (0x7fffffff < uVar9) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to set message of signal code: %s",pcVar1);
    }
    pcVar15 = p_Var3 + 0x220;
    log2Console(3,&DAT_00034c70,"Message of signal code: %s",p_Var3 + 0x30);
    *(undefined4 *)(p_Var3 + 0x10) = *(undefined4 *)(param_2 + 4);
    log2Console(3,&DAT_00034c70,"Error number of signal: %d");
    pcVar1 = strerror(*(int *)(p_Var3 + 0x10));
    uVar9 = snprintf((char *)(p_Var3 + 0x48),0x7c,"%s",pcVar1);
    if (0x7fffffff < uVar9) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to set message of error number: %s",pcVar1);
    }
    log2Console(3,&DAT_00034c70,"Message of error number: %s",p_Var3 + 0x48);
    _Var12 = getpid();
    *(__pid_t *)(p_Var3 + 4) = _Var12;
    log2Console(3,&DAT_00034c70,"PID of this process: %d",_Var12);
    uVar7 = gettid();
    *(undefined4 *)(p_Var3 + 8) = uVar7;
    log2Console(3,&DAT_00034c70,"TID of this thread: %d",uVar7);
    p_Var3[0x220] = (code)0x0;
    pvVar4 = (void *)getProcessName(*(undefined4 *)(p_Var3 + 4));
    if (pvVar4 == (void *)0x0) {
      *(undefined4 *)(p_Var3 + 0x224) = 0x6e776f;
      *(undefined4 *)pcVar15 = 0x6e6b6e75;
    }
    else {
      snprintf((char *)pcVar15,0x200,"%s",pvVar4);
      free(pvVar4);
    }
    log2Console(3,&DAT_00034c70,"Name of this process: %s",pcVar15);
    pcVar15 = p_Var3 + 0x420;
    p_Var3[0x420] = (code)0x0;
    if (*(int *)(p_Var3 + 8) == *(int *)(p_Var3 + 4)) {
      uVar7._0_1_ = 'm';
      uVar7._1_1_ = 'a';
      uVar7._2_1_ = 'i';
      uVar7._3_1_ = 'n';
      p_Var3[0x424] = (code)0x0;
LAB_000173ce:
      *(undefined4 *)pcVar15 = uVar7;
    }
    else {
      pvVar4 = (void *)getThreadName();
      if (pvVar4 == (void *)0x0) {
        uVar7._0_1_ = 'u';
        uVar7._1_1_ = 'n';
        uVar7._2_1_ = 'k';
        uVar7._3_1_ = 'n';
        *(undefined4 *)(p_Var3 + 0x424) = 0x6e776f;
        goto LAB_000173ce;
      }
      snprintf((char *)pcVar15,0x80,"%s",pvVar4);
      free(pvVar4);
    }
    log2Console(3,&DAT_00034c70,"Name of this thread: %s",pcVar15);
    uVar9 = getAndroidApiLevel();
    *(uint *)p_Var3 = uVar9 & ~((int)uVar9 >> 0x1f);
    log2Console(3,&DAT_00034c70,"API level: %d");
    *(undefined2 *)(p_Var3 + 0x24) = 0;
    log2Console(3,&DAT_00034c70,"Successfully create a EupInfo object.");
  }
  eupInfo = p_Var3;
  resetError();
  initCrashRecordFile(recordFileDir);
  log2Console(4,&DAT_00034c70,"Try to dump mini native stack.");
  backtraceStackMini(tombFd,eupInfo,param_2,param_3);
  saveEupInfo2File(eupInfo);
  log2Console(4,&DAT_00034c70,"Create a pretty tomb stone for the damned native crash.");
  pcVar15 = eupInfo + 0x120;
  iVar6 = open((char *)pcVar15,0x241,0x180);
  if (iVar6 == -1) {
    uVar7 = getErrorMsg();
    log2Console(6,&DAT_00034c70,"Failed to open file %s: %s",pcVar15,uVar7);
  }
  tombFd = iVar6;
  log2Console(4,&DAT_00034c70,"Record header of tomb stone.");
  recordTombStoneFileHeader(tombFd,eupInfo);
  if (*(int *)(eupInfo + 0xc) == 6) {
    log2Console(4,&DAT_00034c70,"Record abort message");
    dumpAbortMessage(tombFd,eupInfo);
  }
  log2Console(4,&DAT_00034c70,"Init all record files.");
  initRegisterRecordFile(recordFileDir,eupInfo + 0x120,tombFd);
  initMapRecordFile(recordFileDir,eupInfo + 0x120);
  log2Console(4,&DAT_00034c70,"Record app infos.");
  sVar8 = strlen(&DAT_0003d504);
  if (sVar8 != 0) {
    saveAppInfo2File("appVersion",&DAT_0003d504);
  }
  sVar8 = strlen(&DAT_0003d584);
  if (sVar8 != 0) {
    saveAppInfo2File("userId",&DAT_0003d584);
  }
  sVar8 = strlen(&DAT_0003d684);
  if (sVar8 != 0) {
    saveAppInfo2File("appChannel",&DAT_0003d684);
  }
  sVar8 = strlen(&DAT_0003d784);
  if (sVar8 != 0) {
    saveAppInfo2File("appPackage",&DAT_0003d784);
  }
  sVar8 = strlen(&DAT_0003d88a);
  if (sVar8 != 0) {
    saveAppInfo2File("isAppForeground",&DAT_0003d88a);
  }
  sVar8 = strlen(&DAT_0003d89a);
  if (sVar8 != 0) {
    saveAppInfo2File("launchTime",&DAT_0003d89a);
  }
  sVar8 = strlen(sysLogPath);
  if (sVar8 != 0) {
    saveAppInfo2File("sysLogPath",sysLogPath);
  }
  sVar8 = strlen(jniLogPath);
  if (sVar8 != 0) {
    saveAppInfo2File("jniLogPath",jniLogPath);
  }
  log2Console(4,&DAT_00034c70,"Record register info.");
  recordRegisterInfo(param_3);
  closeRegisterRecordFile();
  log2Console(4,&DAT_00034c70,"Try to dump full native stack.");
  backtraceStack(tombFd,eupInfo,param_2,param_3);
  saveEupInfo2File(eupInfo);
  if (tombFd != -1) {
    close(tombFd);
  }
  closeMapRecordFile();
  closeElfInfoParser();
  saveKeyValue2File(eupInfo);
  saveNativeLog2File(eupInfo);
  closeCrashRecordFile();
  iVar6 = access(sysLogPath,0);
  if (iVar6 == 0) {
    recordSystemLogWithFd(DAT_0003d02c,0);
  }
  else {
    log2Console(5,&DAT_00034c70,"Log file does not exist: %s",sysLogPath);
  }
  iVar6 = access(jniLogPath,0);
  if (iVar6 == 0) {
    recordSystemLogWithFd(DAT_0003d030,1);
  }
  else {
    log2Console(5,&DAT_00034c70,"Log file does not exist: %s",jniLogPath);
  }
  p_Var3 = eupInfo;
  _Var17.sa_handler = eupInfo;
  log2Console(4,&DAT_00034c70,"Try to handle Native Exception in Java profile through JNI.");
  if (jvm == (int *)0x0) {
    log2Console(6,&DAT_00034c70,"Jvm have not back up, should init jni regist first!");
  }
  else {
    local_2c = (int *)0x0;
    iVar6 = (**(code **)(*jvm + 0x18))(jvm,&local_2c,0x10006);
    if ((iVar6 == 0) && (local_2c != (int *)0x0)) {
      log2Console(3,&DAT_00034c70,"Successfully got JNIEnv. Checking pending exception.");
      iVar6 = checkJavaException(local_2c);
      if (iVar6 == 0) goto LAB_000177b2;
      log2Console(3,&DAT_00034c70,"A pending exception exists and will be handled.");
      local_30 = (**(code **)(*local_2c + 0x54))(local_2c,iVar6);
    }
    else {
      log2Console(5,&DAT_00034c70,"Failed to get JNIEnv.");
LAB_000177b2:
      local_30 = 0;
    }
    local_34 = p_Var3 + 0x420;
    local_38 = *(undefined4 *)(p_Var3 + 8);
    local_3c.sa_handler = _Var17.sa_handler;
    log2Console(3,&DAT_00034c70,"Create a new thread for dump java stack and upload.");
    iVar6 = pthread_create(&pStack_40,(pthread_attr_t *)0x0,(__start_routine *)&FUN_00018bec_1,
                           &local_3c);
    if (iVar6 != 0) {
      pcVar1 = strerror(iVar6);
      log2Console(6,&DAT_00034c70,"Can not create thread: %s\n",pcVar1);
    }
    uVar9 = gettimeofday(&local_48,(__timezone_ptr_t)0x0);
    if (0x7fffffff < uVar9) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to get time, error: %s",pcVar1);
    }
    sVar8 = strlen(*(char **)(p_Var3 + 0x4a0));
    log2Console(4,&DAT_00034c70,
                "Wait for the new thread to handle this native crash in Java profile...");
    uVar16 = 0xffffffff;
    do {
      uVar16 = uVar16 + 1;
      if (0x7c < uVar16 >> 2) goto LAB_00017860;
      usleep(10000);
    } while (p_Var3[0x25] == (__sighandler_t)0x0);
    log2Console(4,&DAT_00034c70,"Successfully handled this native crash in Java profile.");
LAB_00017860:
    uVar16 = gettimeofday(&local_50,(__timezone_ptr_t)0x0);
    if (0x7fffffff < uVar16) {
      piVar5 = (int *)__errno();
      pcVar1 = strerror(*piVar5);
      log2Console(5,&DAT_00034c70,"Failed to get time, error: %s",pcVar1);
    }
    if (uVar16 == 0 && uVar9 == 0) {
      iVar6 = __aeabi_idiv(local_50.tv_usec - local_48.tv_usec,1000);
      log2Console(3,&DAT_00034c70,"Finished waiting %d ms.",
                  (local_50.tv_sec - local_48.tv_sec) * 1000 + iVar6);
    }
    else {
      log2Console(3,&DAT_00034c70,"Finished waiting.");
    }
    if (p_Var3[0x25] == (__sighandler_t)0x0) {
      log2Console(4,&DAT_00034c70,"Failed to handle this native crash in Java profile.");
      pcVar1 = *(char **)(p_Var3 + 0x4a0);
      sVar10 = strlen(pcVar1);
      if (sVar8 < sVar10) {
        pcVar11 = strstr(pcVar1,"java:\n");
        pcVar13 = pcVar11 + 6;
        if (pcVar11 == (char *)0x0) {
          pcVar13 = pcVar1 + sVar8;
        }
      }
      else {
        pcVar13 = "[Failed to get Java stack]";
      }
      saveJavaDump2File(p_Var3,pcVar13);
    }
  }
  closeNativeLog();
  freeNativeKeyValueList();
  p_Var3 = eupInfo;
  if (eupInfo != (__sighandler_t)0x0) {
    free(*(void **)(eupInfo + 0x4a0));
    free(p_Var3);
    log2Console(4,&DAT_00034c70,"Clear eupInfo object.");
  }
  unlockFile(lockFilePath);
  log2Console(3,&DAT_00034c70,"Restored signal handlers.");
  unregistSignalHanlder();
  p_Var3 = eupInfo;
  _Var12 = gettid();
  log2Console(3,&DAT_00034c70,"Re-sending signal \'%s\' to thread: %d",p_Var3 + 200,_Var12);
  kill(_Var12,param_1);
LAB_00017978:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void jni_regist(int *param_1,undefined4 param_2,undefined4 param_3,int param_4,undefined4 param_5)

{
  _union_1051 _Var1;
  undefined4 uVar2;
  int iVar3;
  int *piVar4;
  char *pcVar5;
  char *pcVar6;
  char *pcVar7;
  undefined1 *puVar8;
  _union_1051 local_38;
  undefined4 local_34;
  undefined4 local_30;
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (param_4 == 0) {
    uVar2 = 6;
  }
  else {
    uVar2 = 3;
  }
  setLogMode(uVar2);
  log2Console(4,&DAT_00034c70,"regist start");
  toJavaString(param_1,"4.1.9",5);
  iVar3 = (**(code **)(*param_1 + 0x36c))(param_1,&jvm);
  if (iVar3 != 0) {
    piVar4 = (int *)__errno();
    pcVar5 = strerror(*piVar4);
    log2Console(6,&DAT_00034c70,"get jvm fail! %s",pcVar5);
    goto LAB_00017d80;
  }
  JAR_JNI_VERSION = param_5;
  log2Console(4,&DAT_00034c70,"JARJNIVERSION:%d");
  uVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_3,0);
  snprintf(recordFileDir,0x100,"%s",uVar2);
  pcVar5 = "native_record_lock";
  snprintf(lockFilePath,0x100,"%s/../files/%s",recordFileDir,"native_record_lock");
  log2Console(4,&DAT_00034c70,"set signal stack");
  local_38.sa_handler = (__sighandler_t)calloc(1,0x4000);
  local_30 = 0x4000;
  local_34 = 0;
  if (local_38.sa_handler == (__sighandler_t)0x0) {
    piVar4 = (int *)__errno();
    pcVar6 = strerror(*piVar4);
    pcVar7 = "malloc stack size fail! %s";
LAB_00017bb0:
    log2Console(6,&DAT_00034c70,pcVar7,pcVar6);
  }
  else {
    local_30 = 0x4000;
    iVar3 = sigaltstack((sigaltstack *)&local_38,(sigaltstack *)0x0);
    if (iVar3 == -1) {
      piVar4 = (int *)__errno();
      pcVar6 = strerror(*piVar4);
      pcVar7 = "sigaltstack fail! %s";
      goto LAB_00017bb0;
    }
  }
  if (DAT_0003d0f0 == '\x01') {
    pcVar6 = "already regist, just return";
  }
  else {
    DAT_0003d0f0 = '\x01';
    local_34 = 0;
    local_38 = (_union_1051)0x16e35;
    local_30 = 0x18000004;
    sigaction(4,(sigaction *)&local_38,(sigaction *)&DAT_0003d134);
    sigaction(5,(sigaction *)&local_38,(sigaction *)&DAT_0003d144);
    sigaction(0x10,(sigaction *)&local_38,(sigaction *)&DAT_0003d1f4);
    sigaction(0xb,(sigaction *)&local_38,(sigaction *)&DAT_0003d1a4);
    sigaction(6,(sigaction *)&local_38,(sigaction *)&DAT_0003d154);
    sigaction(8,(sigaction *)&local_38,(sigaction *)&DAT_0003d174);
    sigaction(7,(sigaction *)&local_38,(sigaction *)&DAT_0003d164);
    log2Console(4,&DAT_00034c70,"regist anr sigquit handler");
    sigaction(3,(sigaction *)&local_38,(sigaction *)&DAT_0003d124);
    UnblockSigquit(1);
    pcVar6 = "regist native handler";
  }
  log2Console(4,&DAT_00034c70,pcVar6);
  iVar3 = gettimeofday((timeval *)&local_38,(__timezone_ptr_t)0x0);
  _Var1 = local_38;
  if (iVar3 < 0) {
    piVar4 = (int *)__errno();
    puVar8 = strerror(*piVar4);
    uVar2 = 5;
    pcVar6 = "Failed to get time, error: %s";
  }
  else {
    uVar2 = __aeabi_idiv(local_34,1000);
    puVar8 = sysLogPath;
    snprintf(sysLogPath,0x100,"%s/%s_%lu%03lu.txt",recordFileDir,"sys_log",_Var1.sa_handler,uVar2);
    DAT_0003d02c = open(sysLogPath,0x241,0x180);
    if (DAT_0003d02c < 0) {
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to open system log file %s:, error: %s";
    }
    else {
      log2Console(4,&DAT_00034c70,"Opened system log record file: %s",sysLogPath);
      pcVar5 = "jni_log";
      puVar8 = jniLogPath;
      snprintf(jniLogPath,0x100,"%s/%s_%lu%03lu.txt",recordFileDir,"jni_log",_Var1.sa_handler,uVar2)
      ;
      DAT_0003d030 = open(jniLogPath,0x241,0x180);
      if (-1 < DAT_0003d030) {
        uVar2 = 4;
        pcVar6 = "Opened JNI log record file: %s";
        goto LAB_00017d4a;
      }
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to open JNI log file %s:, error: %s";
    }
    uVar2 = 5;
  }
LAB_00017d4a:
  log2Console(uVar2,&DAT_00034c70,pcVar6,puVar8,pcVar5);
  printBuglySoArch(0xffffffff);
  log2Console(4,&DAT_00034c70,"NativeBuglyVersion:%s","4.1.9");
  initStackBuffer(recordFileDir);
  eupInfo = calloc(1,0x4a4);
LAB_00017d80:
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void jni_unregist(undefined4 param_1)

{
  unregistSignalHanlder();
  toJavaString(param_1,"4.1.9",5);
  return;
}



void doANativeCrash(char *param_1)

{
  int iVar1;
  int *local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if (*param_1 == '\0') {
    log2Console(4,&DAT_00034c70,"Test native crash: SIGSEGV");
    log2Console(4,&DAT_00034c70,"You can not see this log for native crash will happen %f");
  }
  else {
    log2Console(4,&DAT_00034c70,"Test native crash with a Java pending exception: SIGABRT");
    local_20 = (int *)0x0;
    iVar1 = (**(code **)(*jvm + 0x18))(jvm,&local_20,0x10006);
    if (iVar1 != 0) {
      log2Console(5,&DAT_00034c70,"Failed to get env.");
      log2Console(4,&DAT_00034c70,"Begin to attach current thread...");
      iVar1 = (**(code **)(*jvm + 0x10))(jvm,&local_20,0);
      if (iVar1 != 0) {
        log2Console(6,&DAT_00034c70,"Failed to attach current thread!");
      }
    }
    if (local_20 != (int *)0x0) {
      if (DAT_0003d885 != '\0') {
        (**(code **)(*local_20 + 0x18))(local_20,"java/lang/FakeClass");
      }
      (**(code **)(*local_20 + 0x2b4))(local_20,0,0);
      (**(code **)(*local_20 + 0x18))(local_20,"java/lang/FakeClass");
    }
  }
  if (__stack_chk_guard - local_1c != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_1c);
  }
  return;
}



undefined8 doACrash(int param_1,pthread_t param_2,undefined3 param_3)

{
  int __errnum;
  char *pcVar1;
  pthread_t local_1c;
  undefined3 uStack_18;
  undefined1 uStack_15;
  int local_14;
  
  local_14 = __stack_chk_guard;
  _uStack_18 = CONCAT13((char)param_2,param_3);
  local_1c = param_2;
  if (param_1 == 0) {
    doANativeCrash(&uStack_15);
  }
  else {
    log2Console(3,&DAT_00034c70,"Create a new thread for testing crash.");
    __errnum = pthread_create(&local_1c,(pthread_attr_t *)0x0,doANativeCrash,&uStack_15);
    if (__errnum != 0) {
      pcVar1 = strerror(__errnum);
      log2Console(6,&DAT_00034c70,"can\'t create thread: %s\n",pcVar1);
    }
    pthread_join(local_1c,(void **)0x0);
  }
  if (__stack_chk_guard == local_14) {
    return CONCAT44(local_1c,param_1);
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



void jni_testCrash(void)

{
  doACrash(DAT_0003d886,DAT_0003d887);
  return;
}



undefined4 jni_appendNativeLog(int *param_1,undefined4 param_2,int param_3,int param_4,int param_5)

{
  int iVar1;
  int iVar2;
  int iVar3;
  undefined4 uVar4;
  char *pcVar5;
  
  if ((((param_1 != (int *)0x0) && (param_3 != 0)) && (param_4 != 0)) && (param_5 != 0)) {
    iVar1 = (**(code **)(*param_1 + 0x2a4))
                      (param_1,param_3,0,*(code **)(*param_1 + 0x2a4),&stack0xfffffff8);
    if (iVar1 == 0) {
      pcVar5 = "jni_appendNativeLog: level is null.";
    }
    else {
      iVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_4,0);
      if (iVar2 == 0) {
        pcVar5 = "jni_appendNativeLog: tag is null.";
      }
      else {
        iVar3 = (**(code **)(*param_1 + 0x2a4))(param_1,param_5,0);
        if (iVar3 != 0) {
          uVar4 = appendNativeLog(iVar1,iVar2,iVar3);
          (**(code **)(*param_1 + 0x2a8))(param_1,param_3,iVar1);
          (**(code **)(*param_1 + 0x2a8))(param_1,param_4,iVar2);
          (**(code **)(*param_1 + 0x2a8))(param_1,param_5,iVar3);
          return uVar4;
        }
        pcVar5 = "jni_appendNativeLog: log is null.";
      }
    }
    log2Console(5,&DAT_00034c70,pcVar5);
  }
  return 0;
}



undefined4 jni_appendWholeNativeLog(int *param_1,undefined4 param_2,int param_3)

{
  int iVar1;
  undefined4 uVar2;
  
  uVar2 = 0;
  if ((param_1 != (int *)0x0) && (param_3 != 0)) {
    iVar1 = (**(code **)(*param_1 + 0x2a4))(param_1,param_3,0);
    if (iVar1 == 0) {
      log2Console(5,&DAT_00034c70,"jni_appendWholeNativeLog: log is null.");
      uVar2 = 0;
    }
    else {
      uVar2 = appendWholeNativeLog();
      (**(code **)(*param_1 + 0x2a8))(param_1,param_3,iVar1);
    }
  }
  return uVar2;
}



undefined4 jni_getNativeLog(int param_1)

{
  char *__s;
  int iVar1;
  size_t sVar2;
  undefined4 uVar3;
  
  if (param_1 != 0) {
    __s = (char *)calloc(0x7801,1);
    iVar1 = getNativeLog(__s,0x7800);
    if (iVar1 != 0) {
      sVar2 = strlen(__s);
      uVar3 = toJavaString(param_1,__s,sVar2);
      free(__s);
      return uVar3;
    }
  }
  return 0;
}



bool jni_putNativeKeyValue(int *param_1,undefined4 param_2,int param_3,int param_4)

{
  int iVar1;
  int iVar2;
  bool bVar3;
  
  bVar3 = false;
  if (((param_1 != (int *)0x0) && (param_3 != 0)) && (param_4 != 0)) {
    iVar1 = (**(code **)(*param_1 + 0x2a4))(param_1,param_3,0);
    if (iVar1 == 0) {
      log2Console(5,&DAT_00034c70,"jni_putNativeKeyValue: key is null.");
      bVar3 = false;
    }
    else {
      iVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_4,0);
      if (iVar2 == 0) {
        log2Console(5,&DAT_00034c70,"jni_putNativeKeyValue: value is null.");
      }
      else {
        putNativeKeyValue(iVar1,iVar2);
        (**(code **)(*param_1 + 0x2a8))(param_1,param_4,iVar2);
      }
      bVar3 = iVar2 != 0;
      (**(code **)(*param_1 + 0x2a8))(param_1,param_3,iVar1);
    }
  }
  return bVar3;
}



undefined4 jni_getNativeKeyValueList(void)

{
  return 0;
}



undefined4 jni_removeNativeKeyValue(void)

{
  return 0;
}



void jni_setNativeInfo(int *param_1,undefined4 param_2,int param_3,int param_4)

{
  undefined1 uVar1;
  int iVar2;
  char *__s;
  undefined1 *puVar3;
  size_t __maxlen;
  
  if ((param_1 == (int *)0x0) || (param_4 == 0)) {
    return;
  }
  iVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,param_4,0);
  log2Console(4,&DAT_00034c70,"jni_setNativeInfo: key is %d",param_3);
  if (iVar2 == 0) {
    log2Console(5,&DAT_00034c70,"jni_setNativeInfo: value is null.");
    return;
  }
  switch(param_3) {
  case 10:
    log2Console(4,&DAT_00034c70,"Set native info: app version(%s)",iVar2);
    __maxlen = 0x80;
    __s = &DAT_0003d504;
    goto LAB_0001838c;
  case 0xb:
    log2Console(4,&DAT_00034c70,"Set native info: user ID(%s)",iVar2);
    __s = &DAT_0003d584;
    goto LAB_00018348;
  case 0xc:
    log2Console(4,&DAT_00034c70,"Set native info: app channel(%s)",iVar2);
    __s = &DAT_0003d684;
    goto LAB_00018348;
  case 0xd:
    log2Console(4,&DAT_00034c70,"Set native info: app package(%s)",iVar2);
    __s = &DAT_0003d784;
LAB_00018348:
    __maxlen = 0x100;
    goto LAB_0001838c;
  case 0xe:
    log2Console(4,&DAT_00034c70,"Set native info: isAppForeground(%s)",iVar2);
    __maxlen = 0x10;
    __s = &DAT_0003d88a;
    goto LAB_0001838c;
  case 0xf:
    log2Console(4,&DAT_00034c70,"Set native info: launchTime(%s)",iVar2);
    __maxlen = 0x20;
    __s = &DAT_0003d89a;
LAB_0001838c:
    snprintf(__s,__maxlen,"%s",iVar2);
    break;
  case 0x10:
    log2Console(4,&DAT_00034c70,"Set native info: testSubThreadCrash(%s)",iVar2);
    DAT_0003d886 = parseBoolString(iVar2);
    break;
  case 0x11:
    log2Console(4,&DAT_00034c70,"Set native info: testSigabrtCrash(%s)",iVar2);
    DAT_0003d887 = parseBoolString(iVar2);
    break;
  case 0x12:
    log2Console(4,&DAT_00034c70,"Set native info: testPendingException(%s)",iVar2);
    uVar1 = parseBoolString(iVar2);
    puVar3 = &DAT_0003d885;
    goto LAB_000183ea;
  case 0x13:
    HandleAnr(2);
    break;
  case 0x14:
    SendSigquitToSignalCatcher();
    break;
  case 0x15:
    parseBoolString(iVar2);
    UnblockSigquit();
    break;
  default:
    if (param_3 == 0x3e6) {
      log2Console(4,&DAT_00034c70,"Should filter system log for SIGABRT signal: %s",iVar2);
      parseBoolString(iVar2);
      break;
    }
    if (param_3 != 999) {
      log2Console(4,&DAT_00034c70,"Key is invalid: %d",param_3);
      break;
    }
    log2Console(4,&DAT_00034c70,"Should handle in Java: %s",iVar2);
    uVar1 = parseBoolString(iVar2);
    puVar3 = &DAT_0003d004;
LAB_000183ea:
    *puVar3 = uVar1;
  }
                    // WARNING: Could not recover jumptable at 0x00018440. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(*param_1 + 0x2a8))(param_1,param_4,iVar2);
  return;
}



void jni_getSoCpuAbi(undefined4 param_1)

{
  log2Console(3,&DAT_00034c70,"call getRunningCpuAbi:%s","armeabi-v7a");
  toJavaString(param_1,"armeabi-v7a",0xc);
  return;
}



// WARNING: Removing unreachable block (ram,0x0001866c)
// WARNING: Removing unreachable block (ram,0x00018a36)
// WARNING: Removing unreachable block (ram,0x00018a3e)
// WARNING: Removing unreachable block (ram,0x00018aac)
// WARNING: Removing unreachable block (ram,0x00018a58)
// WARNING: Removing unreachable block (ram,0x00018a74)
// WARNING: Removing unreachable block (ram,0x00018692)
// WARNING: Removing unreachable block (ram,0x0001869a)
// WARNING: Removing unreachable block (ram,0x0001869e)
// WARNING: Removing unreachable block (ram,0x00018a7e)
// WARNING: Removing unreachable block (ram,0x00018a86)
// WARNING: Removing unreachable block (ram,0x00018aa2)
// WARNING: Removing unreachable block (ram,0x000186c4)

void JNI_OnLoad(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  void *__ptr;
  int iVar4;
  void *pvVar5;
  void *pvVar6;
  char *pcVar7;
  char *pcVar8;
  
  iVar1 = __stack_chk_guard;
  iVar2 = (**(code **)(*param_1 + 0x18))
                    (param_1,&stack0xffffffd4,0x10006,*(code **)(*param_1 + 0x18),param_4);
  if (iVar2 != 0) {
    uVar3 = getErrorMsg();
    log2Console(6,&DAT_00034c70,"get env failed %s",uVar3);
    goto LAB_000188bc;
  }
  iVar2 = backupJavaClasses(0);
  if (iVar2 == 0) {
    log2Console(6,&DAT_00034c70,"backup java classes error");
    goto LAB_000188bc;
  }
  __ptr = (void *)getBuglyClassPathPrefix(0);
  if (jc_NativeCrashHandler == 0) {
    pcVar8 = (char *)concatString(__ptr,"crashreport/crash/jni/NativeCrashHandler",200);
    iVar2 = (**(code **)(iRam00000000 + 0x18))(0,pcVar8);
    free(pcVar8);
    iVar4 = checkJavaException(0);
    if (iVar4 != 0) {
LAB_00018796:
      pcVar7 = "find cls error %s ";
      goto LAB_000187a2;
    }
    if (iVar2 == 0) {
LAB_00018896:
      pcVar8 = "getted jc_NativeCrashHandler error";
    }
    else {
      jc_NativeCrashHandler = (**(code **)(iRam00000000 + 0x54))(0,iVar2);
      iVar2 = checkJavaException(0);
      if (iVar2 != 0) {
LAB_0001888c:
        pcVar7 = "new cls error %s ";
        goto LAB_000187a2;
      }
      if (jc_NativeCrashHandler != 0) goto LAB_00018580;
      pcVar8 = "jc_NativeCrashHandler null";
    }
LAB_0001889e:
    log2Console(6,&DAT_00034c70,pcVar8);
  }
  else {
LAB_00018580:
    if (jc_NativeExceptionHandler == 0) {
      pcVar8 = (char *)concatString(__ptr,"crashreport/crash/jni/NativeExceptionHandler",200);
      iVar2 = (**(code **)(iRam00000000 + 0x18))(0,pcVar8);
      free(pcVar8);
      iVar4 = checkJavaException(0);
      if (iVar4 != 0) goto LAB_00018796;
      if (iVar2 == 0) goto LAB_00018896;
      jc_NativeExceptionHandler = (**(code **)(iRam00000000 + 0x54))(0,iVar2);
      iVar2 = checkJavaException(0);
      if (iVar2 != 0) goto LAB_0001888c;
      if (jc_NativeExceptionHandler == 0) {
        pcVar8 = "jc_NativeExceptionHandler null";
        goto LAB_0001889e;
      }
    }
    if (jm_getInstance == 0) {
      pvVar5 = (void *)concatString(&DAT_00035e0b,__ptr,200);
      pvVar6 = (void *)concatString(pvVar5,"crashreport/crash/jni/NativeCrashHandler;",200);
      free(pvVar5);
      jm_getInstance =
           (**(code **)(iRam00000000 + 0x1c4))(0,jc_NativeCrashHandler,"getInstance",pvVar6);
      free(pvVar6);
      iVar2 = checkJavaException(0);
      if (iVar2 == 0) {
        if (jm_getInstance != 0) goto LAB_000185a6;
        pcVar8 = "getted jm_getInstance error";
LAB_000189ce:
        log2Console(6,&DAT_00034c70,pcVar8);
      }
      else {
        pcVar8 = "getInstance";
LAB_0001885a:
        log2Console(6,&DAT_00034c70,"find method error %s ",pcVar8);
      }
    }
    else {
LAB_000185a6:
      if (jm_getMHandle == 0) {
        pvVar5 = (void *)concatString(&DAT_00035e0b,__ptr,200);
        pvVar6 = (void *)concatString(pvVar5,"crashreport/crash/jni/NativeExceptionHandler;",200);
        free(pvVar5);
        jm_getMHandle =
             (**(code **)(iRam00000000 + 0x84))
                       (0,jc_NativeCrashHandler,"getNativeExceptionHandler",pvVar6);
        free(pvVar6);
        iVar2 = checkJavaException(0);
        if (iVar2 != 0) {
          pcVar8 = "getNativeExceptionHandler";
          goto LAB_0001885a;
        }
        if (jm_getMHandle == 0) {
          pcVar8 = "getted jm_getMHadle error";
          goto LAB_000189ce;
        }
      }
      if (jm_handleNativeException2 == 0) {
        jm_handleNativeException2 =
             (**(code **)(iRam00000000 + 0x84))
                       (0,jc_NativeExceptionHandler,"handleNativeException2",
                        "(IIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V"
                       );
        iVar2 = checkJavaException(0);
        if (iVar2 != 0) {
          log2Console(3,&DAT_00034c70,"failed to find method %s ","handleNativeException2");
        }
        if (jm_handleNativeException2 == 0) {
          log2Console(3,&DAT_00034c70,"failed to get %s","handleNativeException2");
        }
      }
      if (jm_handleNativeException == 0) {
        jm_handleNativeException =
             (**(code **)(iRam00000000 + 0x84))
                       (0,jc_NativeExceptionHandler,"handleNativeException",
                        "(IIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;)V"
                       );
        iVar2 = checkJavaException(0);
        if (iVar2 != 0) {
          pcVar7 = "find method error %s ";
          pcVar8 = "handleNativeException";
          goto LAB_000187a2;
        }
        if (jm_handleNativeException == 0) {
          pcVar8 = "getted jm_handleNativeException error";
          goto LAB_0001889e;
        }
      }
      if (jm_getAndUpdateAnrState != 0) {
LAB_00018632:
        log2Console(3,&DAT_00034c70,"backupBuglyClasses success");
        free(__ptr);
        iVar2 = (**(code **)(iRam00000000 + 0x35c))
                          (0,jc_NativeCrashHandler,&PTR_s_regist_0003d04c,3);
        if (iVar2 < 0) {
          log2Console(6,&DAT_00034c70,"register Natives error");
          checkJavaException(0);
        }
        else {
          iVar2 = (**(code **)(iRam00000000 + 0x35c))
                            (0,jc_NativeCrashHandler,&PTR_s_getSoCpuAbi_0003d040,1);
          if (iVar2 < 0) {
            log2Console(5,&DAT_00034c70,
                        "register native abi method error, please upgrade bugly jar version");
            checkJavaException(0);
          }
          else {
            log2Console(4,&DAT_00034c70,"register native abi method success");
          }
        }
        goto LAB_000188bc;
      }
      jm_getAndUpdateAnrState =
           (**(code **)(iRam00000000 + 0x84))
                     (0,jc_NativeExceptionHandler,"getAndUpdateAnrState",&DAT_00036093);
      iVar2 = checkJavaException(0);
      if (iVar2 == 0) {
        if (jm_getAndUpdateAnrState != 0) goto LAB_00018632;
        pcVar7 = "failed to get method %s";
      }
      else {
        pcVar7 = "failed to find method %s";
      }
      pcVar8 = "getAndUpdateAnrState";
LAB_000187a2:
      log2Console(6,&DAT_00034c70,pcVar7,pcVar8);
    }
  }
  log2Console(6,&DAT_00034c70,"back up bugly classes error");
  free(__ptr);
LAB_000188bc:
  if (__stack_chk_guard - iVar1 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - iVar1);
  }
  return;
}



void FUN_00018b98(int param_1)

{
  pthread_t __threadid;
  
  log2Console(4,&DAT_00034c70,"backupSignalHandler");
  if (DAT_0003d884 == '\x01') {
                    // WARNING: Subroutine does not return
    _exit(1);
  }
  DAT_0003d884 = 1;
  unlockFile(lockFilePath);
  unregistSignalHanlder();
  __threadid = pthread_self();
  pthread_kill(__threadid,param_1);
  return;
}



// WARNING: Removing unreachable block (ram,0x00018c54)
// WARNING: Removing unreachable block (ram,0x00018d2c)
// WARNING: Removing unreachable block (ram,0x00018c5a)
// WARNING: Removing unreachable block (ram,0x00018c70)
// WARNING: Removing unreachable block (ram,0x00018c84)
// WARNING: Removing unreachable block (ram,0x00018cbc)
// WARNING: Removing unreachable block (ram,0x00018cce)
// WARNING: Removing unreachable block (ram,0x00018d36)
// WARNING: Removing unreachable block (ram,0x00018cde)
// WARNING: Removing unreachable block (ram,0x00018d52)
// WARNING: Removing unreachable block (ram,0x00018da2)
// WARNING: Removing unreachable block (ram,0x00018d5a)
// WARNING: Removing unreachable block (ram,0x00018dae)
// WARNING: Removing unreachable block (ram,0x00018d62)
// WARNING: Removing unreachable block (ram,0x00018db8)
// WARNING: Removing unreachable block (ram,0x00018d7c)

void FUN_00018bec(void)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = __stack_chk_guard;
  uVar2 = gettid();
  log2Console(4,&DAT_00034c70,"New thread ID: %d",uVar2);
  if (jvm == (int *)0x0) {
    log2Console(6,&DAT_00034c70,"JVM have not been backed up, should init JNI regist first!");
  }
  else {
    log2Console(3,&DAT_00034c70,"handleNativeExceptionThread Attach thread to JVM.");
    (**(code **)(*jvm + 0x10))(jvm,&stack0xffffffd4,0);
    log2Console(6,&DAT_00034c70,"Failed to attach thread to JVM.");
    (**(code **)(*jvm + 0x14))();
  }
  if (__stack_chk_guard - iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - iVar1,__stack_chk_guard);
}



undefined4 getBackTraceMapInfoList(void)

{
  return localMapInfoList;
}



void initStackBuffer(void)

{
  DAT_0003d8c0 = calloc(1,0x40);
  DAT_0003d8c4 = calloc(1,0x4000);
  return;
}



void initLocalMapInfoList(void)

{
  if (localMapInfoList != 0) {
    return;
  }
  localMapInfoList = initCurrentMapInfoList(0,1);
  return;
}



void dumpAbortMessage(undefined4 param_1,int param_2)

{
  undefined1 auStack_420 [1028];
  int iStack_1c;
  
  iStack_1c = __stack_chk_guard;
  if (*(int *)(param_2 + 0xc) == 6) {
    initLocalMapInfoList();
    __aeabi_memclr8(auStack_420,0x401);
    getAbortMessage(localMapInfoList,auStack_420,0x400);
    log2Report(param_1,0,"\nabort message:  %s",auStack_420);
  }
  if (__stack_chk_guard != iStack_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void backtraceStackWithLibUnwind(int param_1,char *param_2,int param_3)

{
  void *__ptr;
  void *__ptr_00;
  int iVar1;
  uint uVar2;
  size_t sVar3;
  size_t sVar4;
  int iVar5;
  undefined4 uVar6;
  char *pcVar7;
  undefined4 local_438;
  uint local_434;
  char acStack_430 [1032];
  int iStack_28;
  
  iStack_28 = __stack_chk_guard;
  param_2[0] = '\0';
  param_2[1] = '\0';
  param_2[2] = '\0';
  param_2[3] = '\0';
  __ptr = calloc(1,0x40);
  if (__ptr == (void *)0x0) {
    pcVar7 = "context_";
  }
  else {
    __ptr_00 = calloc(1,0x4000);
    if (__ptr_00 != (void *)0x0) {
      FUN_00019214(param_3,__ptr);
      initLocalMapInfoList();
      log2Console(4,&DAT_00034c70,"Got unwind context.");
      iVar1 = _Uarm_init_local(__ptr_00,__ptr);
      log2Console(4,&DAT_00034c70,"Initialization of unwind finished.");
      if (iVar1 < 0) {
        log2Console(5,&DAT_00034c70,"Failed to init unwind: %d.",iVar1);
        uVar6 = 0;
      }
      else {
        __aeabi_memclr8(acStack_430,0x402);
        iVar1 = 0;
        do {
          uVar2 = _Uarm_get_reg(__ptr_00,0xe,&local_434);
          if ((int)uVar2 < 0) {
            pcVar7 = "Failed to read IP with res: %d";
LAB_000190ca:
            log2Console(5,&DAT_00034c70,pcVar7,uVar2);
            break;
          }
          if (local_434 < 0xff) {
            pcVar7 = "pc may illegal: %p";
            uVar2 = local_434;
            goto LAB_000190ca;
          }
          uVar2 = _Uarm_get_reg(__ptr_00,0xd,&local_438);
          if ((int)uVar2 < 0) {
            pcVar7 = "Failed to read SP with res: %d";
            goto LAB_000190ca;
          }
          log2Console(3,&DAT_00034c70,"pc = %p, sp = %p",local_434,local_438);
          FUN_00019258(iVar1,1,local_434,acStack_430);
          if (0 < param_1) {
            log2Report(param_1,0,"        %s\n",acStack_430);
          }
          sVar3 = strlen(acStack_430);
          pcVar7 = acStack_430 + sVar3;
          pcVar7[0] = '\n';
          pcVar7[1] = '\0';
          sVar3 = strlen(param_2);
          sVar4 = strlen(acStack_430);
          if (0x1400 - sVar3 <= sVar4) {
            log2Console(5,&DAT_00034c70,"Stack is over limit. Drop this frame and return.");
            break;
          }
          iVar1 = iVar1 + 1;
          strncat(param_2,acStack_430,0x1400 - sVar3);
          log2Console(3,&DAT_00034c70,"Append to native stack.");
          iVar5 = _Uarm_step(__ptr_00);
        } while (0 < iVar5);
        sVar3 = strlen(param_2);
        if ((sVar3 < 5) && (*(int *)(param_3 + 0x58) != 0)) {
          iVar1 = FUN_00019258(0,0,*(int *)(param_3 + 0x58) + 4,acStack_430);
          if (iVar1 != 0) {
            if (0 < param_1) {
              log2Report(param_1,0,"        %s\n",acStack_430);
            }
            sVar3 = strlen(acStack_430);
            pcVar7 = acStack_430 + sVar3;
            pcVar7[0] = '\n';
            pcVar7[1] = '\0';
            sVar3 = strlen(acStack_430);
            strncat(param_2,acStack_430,sVar3);
            log2Console(3,&DAT_00034c70,"Append to native stack.");
          }
        }
        sVar3 = strlen(param_2);
        if (sVar3 < 5) {
          snprintf(param_2,0x1400,"%s\n","[empty stack]");
        }
        free(__ptr_00);
        free(__ptr);
        if (localMapInfoList != 0) {
          freeMapInfoList();
        }
        uVar6 = 1;
      }
      goto LAB_00019178;
    }
    pcVar7 = "cursor";
  }
  log2Console(5,&DAT_00034c70,"Failed to allocate memory for %s",pcVar7);
  uVar6 = 0;
LAB_00019178:
  if (__stack_chk_guard == iStack_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar6);
}



void FUN_00019214(int param_1,undefined4 *param_2)

{
  *param_2 = *(undefined4 *)(param_1 + 0x20);
  param_2[1] = *(undefined4 *)(param_1 + 0x24);
  param_2[2] = *(undefined4 *)(param_1 + 0x28);
  param_2[3] = *(undefined4 *)(param_1 + 0x2c);
  param_2[4] = *(undefined4 *)(param_1 + 0x30);
  param_2[5] = *(undefined4 *)(param_1 + 0x34);
  param_2[6] = *(undefined4 *)(param_1 + 0x38);
  param_2[7] = *(undefined4 *)(param_1 + 0x3c);
  param_2[8] = *(undefined4 *)(param_1 + 0x40);
  param_2[9] = *(undefined4 *)(param_1 + 0x44);
  param_2[10] = *(undefined4 *)(param_1 + 0x48);
  param_2[0xb] = *(undefined4 *)(param_1 + 0x4c);
  param_2[0xc] = *(undefined4 *)(param_1 + 0x50);
  param_2[0xd] = *(undefined4 *)(param_1 + 0x54);
  param_2[0xe] = *(undefined4 *)(param_1 + 0x58);
  param_2[0xf] = *(undefined4 *)(param_1 + 0x5c);
  return;
}



void FUN_00019258(char *param_1,int param_2,int param_3,char *param_4)

{
  bool bVar1;
  undefined4 uVar2;
  void *__ptr;
  int iVar3;
  int iVar4;
  int iVar5;
  uint __c;
  int *piVar6;
  undefined *puVar7;
  char *pcVar8;
  int iVar9;
  char *pcVar10;
  int local_38;
  char *local_34;
  int local_30;
  char *local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,&DAT_00034c70,"getCallFrameByAddress");
  uVar2 = 0;
  if (param_4 == (char *)0x0) goto LAB_00019502;
  local_2c = (char *)0x0;
  local_34 = (char *)0x0;
  local_30 = 0;
  local_38 = 0;
  __ptr = (void *)FUN_00019a64(param_3,&local_2c,&local_30,&local_34,&local_38);
  log2Console(3,&DAT_00034c70,"searchIpInMaps pc: %p",param_3);
  if (localMapInfoList == 0) {
    log2Console(4,&DAT_00034c70,"There is nothing is the map info list.");
LAB_000193bc:
    pcVar10 = local_2c;
    if (local_2c != (char *)0x0) goto LAB_000193c6;
    pcVar10 = (char *)0x0;
    bVar1 = true;
LAB_0001946e:
    puVar7 = &DAT_000366a1;
    if (param_2 == 0) {
      puVar7 = &DAT_000366a4;
    }
    pcVar8 = local_34;
    iVar3 = local_38;
    if (local_34 != (char *)0x0) goto LAB_00019480;
    if (!bVar1) {
      snprintf(param_4,0x400,"#%02d    %s %08x    %s",param_1,puVar7,local_30,pcVar10);
      goto LAB_000194d6;
    }
    pcVar10 = "#%02d    %s %08x    <unknown>";
LAB_000194fc:
    snprintf(param_4,0x400,pcVar10,param_1,puVar7,param_3);
  }
  else {
    iVar3 = findModuleInMapInfoList(localMapInfoList,param_3);
    if (iVar3 == 0) goto LAB_000193bc;
    pcVar10 = (char *)(iVar3 + 0x27);
    log2Console(3,&DAT_00034c70,"searchIpInMaps, Found the module: %s",pcVar10);
    iVar4 = strcmp(pcVar10,"<null>");
    if ((iVar4 == 0) && (*(char *)(iVar3 + 0x24) != '\0')) {
      log2Console(3,&DAT_00034c70,"searchIpInMaps, UNKNOWN_MAP_MODULE_NAME");
      iVar4 = *(int *)(iVar3 + 4);
      iVar9 = 0;
      while ((__c = (uint)*(byte *)(iVar4 + iVar9), __c != 0 && (iVar5 = isascii(__c), iVar5 != 0)))
      {
        iVar9 = iVar9 + 1;
      }
      if (iVar9 != 0) {
        pcVar10 = (char *)calloc(1,iVar9 + 1);
        __aeabi_memcpy(pcVar10,iVar4,iVar9);
        log2Console(3,&DAT_00034c70,"searchIpInMaps, UNKNOWN_MAP_MODULE_NAME, found:%s",pcVar10);
      }
    }
    iVar4 = *(int *)(iVar3 + 0x18);
    if (iVar4 == 0) {
      iVar4 = *(int *)(iVar3 + 4);
      iVar3 = *(int *)(iVar3 + 0xc);
      iVar9 = (iVar3 - iVar4) + param_3;
      pcVar8 = "searchIpInMaps pc:%p start:%08x offset:%08x moduleOffset:%08x ";
    }
    else {
      iVar9 = param_3 - iVar4;
      pcVar8 = "searchIpInMaps pc:%p load_addr:%08x moduleOffset:%08x";
      iVar3 = iVar9;
    }
    log2Console(3,&DAT_00034c70,pcVar8,param_3,iVar4,iVar3);
    if (pcVar10 == (char *)0x0) goto LAB_000193bc;
    local_30 = iVar9;
    local_2c = pcVar10;
    log2Console(3,&DAT_00034c70,"getCallFrameByAddress use the maps moduleName:%s moduleOffset:%08x"
                ,pcVar10,iVar9,iVar3);
LAB_000193c6:
    iVar9 = param_3;
    log2Console(3,&DAT_00034c70,"getCallFrameByAddress Got module name: %s for pc: %p",pcVar10,
                param_3);
    iVar4 = local_30;
    pcVar8 = local_34;
    iVar3 = local_38;
    if (local_34 == (char *)0x0) {
      piVar6 = (int *)searchSymbolInElfFile(pcVar10,local_30);
      if (piVar6 == (int *)0x0) {
        log2Console(3,&DAT_00034c70,"getCallFrameByAddress Can not find function name for pc: %p",
                    param_3,iVar9);
        log2Console(3,&DAT_00034c70,
                    "getCallFrameByAddress Function with offset %p may only be contained in debug so of: %s"
                    ,iVar4,pcVar10);
        bVar1 = false;
      }
      else {
        local_34 = strdup((char *)piVar6[2]);
        local_38 = iVar4 - *piVar6;
        bVar1 = false;
      }
      goto LAB_0001946e;
    }
    log2Console(3,&DAT_00034c70,"getCallFrameByAddress Got function name: %s with offset: %p",
                local_34,local_38);
    bVar1 = false;
    puVar7 = &DAT_000366a1;
    if (param_2 == 0) {
      puVar7 = &DAT_000366a4;
    }
LAB_00019480:
    snprintf(param_4,0x400,"#%02d    %s %08x    %s (%s+%lu)",param_1,puVar7,local_30,pcVar10,pcVar8,
             iVar3);
    free(__ptr);
    if (!bVar1) {
LAB_000194d6:
      iVar3 = getElfInfoWithSymbolTable(pcVar10,1);
      if (iVar3 != 0) {
        param_3 = iVar3 + 0x94;
        puVar7 = (undefined *)(iVar3 + 0x84);
        pcVar10 = "%s [%s:%s:%s]";
        param_1 = param_4;
        goto LAB_000194fc;
      }
    }
  }
  uVar2 = 1;
LAB_00019502:
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar2);
}



void miniBacktraceStackWithLibUnwind(int param_1,char *param_2,int param_3)

{
  void *pvVar1;
  char *pcVar2;
  uint uVar3;
  size_t sVar4;
  size_t sVar5;
  int iVar6;
  undefined4 uVar7;
  char *pcVar8;
  int iVar9;
  undefined4 local_438;
  uint local_434;
  char acStack_430 [1032];
  int iStack_28;
  
  iStack_28 = __stack_chk_guard;
  log2Console(4,&DAT_00034c70,"miniBacktraceStackWithLibUnwind.");
  pvVar1 = DAT_0003d8c0;
  if (DAT_0003d8c0 == (void *)0x0) {
    pcVar8 = "Failed to allocate memory for %s";
    pcVar2 = "mini_backtrace_context_";
  }
  else {
    FUN_00019214(param_3,DAT_0003d8c0);
    pcVar2 = (char *)_Uarm_init_local(DAT_0003d8c4,pvVar1);
    log2Console(4,&DAT_00034c70,"Initialization of unwind finished.");
    if (-1 < (int)pcVar2) {
      __aeabi_memclr8(acStack_430,0x402);
      iVar9 = 0;
      do {
        uVar3 = _Uarm_get_reg(DAT_0003d8c4,0xe,&local_434);
        if ((int)uVar3 < 0) {
          pcVar2 = "Failed to read IP with res: %d";
LAB_0001971e:
          log2Console(5,&DAT_00034c70,pcVar2,uVar3);
          break;
        }
        if (local_434 < 0xff) {
          pcVar2 = "pc may illegal: %p";
          uVar3 = local_434;
          goto LAB_0001971e;
        }
        uVar3 = _Uarm_get_reg(DAT_0003d8c4,0xd,&local_438);
        if ((int)uVar3 < 0) {
          pcVar2 = "Failed to read SP with res: %d";
          goto LAB_0001971e;
        }
        log2Console(3,&DAT_00034c70,"pc = %p, sp = %p",local_434,local_438);
        FUN_00019838(iVar9,1,local_434,acStack_430);
        if (0 < param_1) {
          log2Report(param_1,0,"        %s\n",acStack_430);
        }
        sVar4 = strlen(acStack_430);
        pcVar2 = acStack_430 + sVar4;
        pcVar2[0] = '\n';
        pcVar2[1] = '\0';
        sVar4 = strlen(param_2);
        sVar5 = strlen(acStack_430);
        if (0x1400 - sVar4 <= sVar5) {
          log2Console(5,&DAT_00034c70,"Stack is over limit. Drop this frame and return.");
          break;
        }
        iVar9 = iVar9 + 1;
        strncat(param_2,acStack_430,0x1400 - sVar4);
        log2Console(3,&DAT_00034c70,"Append to native stack.");
        iVar6 = _Uarm_step(DAT_0003d8c4);
      } while (0 < iVar6);
      sVar4 = strlen(param_2);
      if ((sVar4 < 5) && (*(int *)(param_3 + 0x58) != 0)) {
        iVar9 = FUN_00019838(0,0,*(int *)(param_3 + 0x58) + 4,acStack_430);
        if (iVar9 != 0) {
          if (0 < param_1) {
            log2Report(param_1,0,"        %s\n",acStack_430);
          }
          sVar4 = strlen(acStack_430);
          pcVar2 = acStack_430 + sVar4;
          pcVar2[0] = '\n';
          pcVar2[1] = '\0';
          sVar4 = strlen(acStack_430);
          strncat(param_2,acStack_430,sVar4);
          log2Console(3,&DAT_00034c70,"Append to native stack.");
        }
      }
      free(DAT_0003d8c4);
      free(DAT_0003d8c0);
      uVar7 = 1;
      goto LAB_000197aa;
    }
    pcVar8 = "Failed to init unwind: %d.";
  }
  log2Console(5,&DAT_00034c70,pcVar8,pcVar2);
  uVar7 = 0;
LAB_000197aa:
  if (__stack_chk_guard == iStack_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar7);
}



void FUN_00019838(undefined4 param_1,int param_2,undefined4 param_3,char *param_4)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  undefined4 uVar4;
  void *__ptr;
  undefined *puVar5;
  char *__format;
  int iVar6;
  undefined4 local_38;
  int local_34;
  undefined4 local_30;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,&DAT_00034c70,"getCallFrameByAddressMini");
  uVar4 = 0;
  if (param_4 != (char *)0x0) {
    local_2c = 0;
    local_34 = 0;
    local_30 = 0;
    local_38 = 0;
    __ptr = (void *)FUN_00019a64(param_3,&local_2c,&local_30,&local_34,&local_38);
    iVar3 = local_2c;
    uVar2 = local_30;
    iVar1 = local_34;
    uVar4 = local_38;
    iVar6 = local_34;
    log2Console(4,&DAT_00034c70,
                "getCallFrameByAddressMini pc:%p moduleName:%s moduleOffset:%08x funcName:%s funcOffset:%08x"
                ,param_3,local_2c,local_30,local_34,local_38);
    puVar5 = &DAT_000366a1;
    if (param_2 == 0) {
      puVar5 = &DAT_000366a4;
    }
    if (iVar1 == 0) {
      if (iVar3 == 0) {
        __format = "#%02d    %s %08x    <unknown>";
      }
      else {
        __format = "#%02d    %s %08x    %s";
        param_3 = uVar2;
        iVar6 = iVar3;
      }
      snprintf(param_4,0x400,__format,param_1,puVar5,param_3,iVar6);
    }
    else {
      snprintf(param_4,0x400,"#%02d    %s %08x    %s (%s+%lu)",param_1,puVar5,uVar2,iVar3,iVar1,
               uVar4);
      free(__ptr);
    }
    uVar4 = 1;
  }
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar4);
  }
  return;
}



undefined4 backtraceStack(undefined4 param_1,int param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  
  log2Console(3,&DAT_00034c70,"backtraceStack");
  init_dl_iterate_phdr_wrapper();
  iVar1 = backtraceStackWithLibUnwind(param_1,*(undefined4 *)(param_2 + 0x4a0),param_4);
  if (iVar1 == 0) {
    log2Console(4,&DAT_00034c70,"Failed to dump stack by libUnwind.");
  }
  else {
    log2Console(4,&DAT_00034c70,"Stack is succesfully dumped by libUnwind.");
    log2Console(3,&DAT_00034c70,"Native stack: \n%s",*(undefined4 *)(param_2 + 0x4a0));
    log2Console(4,&DAT_00034c70,"Record map file of thread: %d",*(undefined4 *)(param_2 + 8));
    recordAllMapInfo(*(undefined4 *)(param_2 + 8));
  }
  return 0;
}



undefined4 backtraceStackMini(undefined4 param_1,int param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  
  log2Console(4,&DAT_00034c70,"init_dl_iterate_phdr_wrapper.");
  init_dl_iterate_phdr_wrapper();
  iVar1 = miniBacktraceStackWithLibUnwind(param_1,*(undefined4 *)(param_2 + 0x4a0),param_4);
  if (iVar1 == 0) {
    log2Console(3,&DAT_00034c70,"Failed to mini dump stack by libUnwind.");
  }
  else {
    log2Console(3,&DAT_00034c70,"mini backtrace: Stack is succesfully dumped by libUnwind.");
    log2Console(3,&DAT_00034c70,"mini backtrace:Native stack: \n%s",*(undefined4 *)(param_2 + 0x4a0)
               );
  }
  return 0;
}



undefined4 * FUN_00019a64(int param_1,undefined4 *param_2,int *param_3,int *param_4,int *param_5)

{
  undefined4 *__ptr;
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  int iVar4;
  
  log2Console(3,&DAT_00034c70,"searchIpInfos pc: %p",param_1);
  __ptr = (undefined4 *)calloc(1,0x10);
  iVar1 = dladdr(param_1,__ptr);
  if (iVar1 == 0) {
    log2Console(4,&DAT_00034c70,"Can not find symbol info.");
    free(__ptr);
    __ptr = (undefined4 *)0x0;
  }
  else {
    log2Console(4,&DAT_00034c70,"Found symbol info.");
    uVar3 = *__ptr;
    iVar1 = __ptr[1];
    iVar2 = param_1 - iVar1;
    *param_2 = uVar3;
    *param_3 = iVar2;
    log2Console(4,&DAT_00034c70,"searchIpInfos, fname:%s fbase:%08x moduleOffset:%08x",uVar3,iVar1,
                iVar2);
    iVar1 = __ptr[2];
    if (iVar1 != 0) {
      *param_4 = iVar1;
      iVar4 = __ptr[3];
      *param_5 = param_1 - iVar4;
      log2Console(4,&DAT_00034c70,"searchIpInfos funcName:%s funcOffset:%08x",iVar1,param_1 - iVar4,
                  iVar2);
    }
  }
  return __ptr;
}



undefined4
initBackupRecordFile(undefined4 param_1,undefined4 param_2,char *param_3,undefined4 param_4)

{
  int iVar1;
  int *piVar2;
  char *pcVar3;
  
  DAT_0003d8c8 = (char *)calloc(1,0x100);
  if (DAT_0003d8c8 != (char *)0x0) {
    param_3 = "backup_record.txt";
    iVar1 = snprintf(DAT_0003d8c8,0x100,"%s/%s",param_1,"backup_record.txt",param_4);
    if ((0 < iVar1) && (DAT_0003d8cc = fopen(DAT_0003d8c8,"w"), DAT_0003d8cc != (FILE *)0x0)) {
      return 1;
    }
  }
  piVar2 = (int *)__errno();
  pcVar3 = strerror(*piVar2);
  log2Console(5,&DAT_00034c70,"Failed to init backup record path: %s",pcVar3,param_3);
  return 0;
}



void closeBackupRecordFile(void)

{
  if (DAT_0003d8cc != (FILE *)0x0) {
    fclose(DAT_0003d8cc);
    DAT_0003d8cc = (FILE *)0x0;
  }
  if (DAT_0003d8c8 != (void *)0x0) {
    free(DAT_0003d8c8);
    DAT_0003d8c8 = (void *)0x0;
  }
  return;
}



void recordBackupInfo(undefined4 *param_1,int param_2)

{
  int iVar1;
  
  if (((param_1 != (undefined4 *)0x0) && (param_2 != 0)) && (DAT_0003d8cc != 0)) {
    log2File(DAT_0003d8cc,"Bugly NDK version:%s\n","4.1.9");
    log2File(DAT_0003d8cc,"HandleSignal start %d\n",*param_1);
    recordRegisterInfo2File(param_2,DAT_0003d8cc,0xffffffff);
    iVar1 = initCurrentXMapInfoList(1);
    if (iVar1 != 0) {
      recordMapInfo2File(iVar1,0,DAT_0003d8cc);
      freeMapInfoList(iVar1);
      return;
    }
  }
  return;
}



void closeCrashRecordFile(void)

{
  if (DAT_0003d8d0 != (FILE *)0x0) {
    fclose(DAT_0003d8d0);
    DAT_0003d8d0 = (FILE *)0x0;
  }
  return;
}



undefined4
initCrashRecordFile(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  int *piVar2;
  char *pcVar3;
  
  log2Console(4,&DAT_00034c70,"Init crash record file.",param_4,param_3,param_4);
  DAT_0003d8d4 = (char *)calloc(1,0x100);
  if (((DAT_0003d8d4 != (char *)0x0) &&
      (iVar1 = snprintf(DAT_0003d8d4,0x100,"%s/%s",param_1,"rqd_record.eup"), 0 < iVar1)) &&
     (DAT_0003d8d0 = fopen(DAT_0003d8d4,"w"), DAT_0003d8d0 != (FILE *)0x0)) {
    recordHead();
    closeCrashRecordFile();
    log2Console(4,&DAT_00034c70,"Init of crash record file finished.");
    return 1;
  }
  piVar2 = (int *)__errno();
  pcVar3 = strerror(*piVar2);
  log2Console(5,&DAT_00034c70,"Failed to init crash record path: %s",pcVar3);
  return 0;
}



void saveEupInfo2File(int param_1)

{
  int iVar1;
  size_t sVar2;
  char acStack_8c [100];
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(4,&DAT_00034c70,"Record EupInfo");
  if (param_1 == 0) {
    if (__stack_chk_guard == local_28) {
      log2Console(6,&DAT_00034c70,"save eupinfo fail!");
      return;
    }
  }
  else {
    if (DAT_0003d8d0 == (FILE *)0x0) {
      DAT_0003d8d0 = fopen(DAT_0003d8d4,"a");
    }
    iVar1 = snprintf(acStack_8c,100,
                     "ep:%d,et:%d,sig:%d,sino:%d,sico:%d,spd:%d,sud:%d,ets:%lu,etms:%lu",
                     *(undefined4 *)(param_1 + 4));
    if (0 < iVar1) {
      recordProperty(DAT_0003d8d0,"intStateStr",acStack_8c);
    }
    sVar2 = strlen((char *)(param_1 + 0xe0));
    if (sVar2 != 0) {
      recordProperty(DAT_0003d8d0,"errorAddr",(char *)(param_1 + 0xe0));
    }
    sVar2 = strlen((char *)(param_1 + 0x30));
    if (sVar2 != 0) {
      recordProperty(DAT_0003d8d0,"codeMsg",(char *)(param_1 + 0x30));
    }
    sVar2 = strlen((char *)(param_1 + 0x120));
    if (sVar2 != 0) {
      recordProperty(DAT_0003d8d0,"tombPath",(char *)(param_1 + 0x120));
    }
    sVar2 = strlen((char *)(param_1 + 200));
    if (sVar2 != 0) {
      recordProperty(DAT_0003d8d0,"signalName",(char *)(param_1 + 200));
    }
    sVar2 = strlen((char *)(param_1 + 0x48));
    if (sVar2 != 0) {
      recordProperty(DAT_0003d8d0,"errnoMsg",(char *)(param_1 + 0x48));
    }
    if (*(int *)(param_1 + 0x4a0) != 0) {
      recordProperty(DAT_0003d8d0,"stack");
    }
    sVar2 = strlen((char *)(param_1 + 0x420));
    if ((sVar2 != 0) &&
       (iVar1 = recordProperty(DAT_0003d8d0,"threadName",(char *)(param_1 + 0x420)), iVar1 < 1)) {
      log2Console(6,&DAT_00034c70,"Failed to record java thread name.");
    }
    sVar2 = strlen((char *)(param_1 + 0x220));
    if (sVar2 != 0) {
      recordProperty(DAT_0003d8d0,"processName",(char *)(param_1 + 0x220));
    }
    recordProperty(DAT_0003d8d0,"soVersion","4.1.9");
    log2Console(4,&DAT_00034c70,"EupInfo has been recorded.");
    closeCrashRecordFile();
    if (__stack_chk_guard == local_28) {
      return;
    }
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



undefined4 saveAppInfo2File(char *param_1,char *param_2)

{
  undefined4 uVar1;
  int iVar2;
  
  uVar1 = 0;
  if ((param_1 != (char *)0x0) && (param_2 != (char *)0x0)) {
    if (DAT_0003d8d0 == (FILE *)0x0) {
      DAT_0003d8d0 = fopen(DAT_0003d8d4,"a");
    }
    if ((*param_1 == '\0') || (*param_2 == '\0')) {
      uVar1 = 0;
    }
    else {
      log2Console(4,&DAT_00034c70,"Record %s",param_1);
      iVar2 = recordProperty(DAT_0003d8d0,param_1,param_2);
      if (iVar2 < 1) {
        log2Console(6,&DAT_00034c70,"Failed to record native log.");
      }
      log2Console(4,&DAT_00034c70,"%s has been recorded.",param_1);
      closeCrashRecordFile();
      uVar1 = 1;
    }
  }
  return uVar1;
}



undefined4 saveKeyValue2File(int param_1)

{
  char *__ptr;
  int iVar1;
  
  log2Console(4,&DAT_00034c70,"Record native key-value list.");
  if (param_1 != 0) {
    if (DAT_0003d8d0 == (FILE *)0x0) {
      DAT_0003d8d0 = fopen(DAT_0003d8d4,"a");
    }
    __ptr = (char *)calloc(1,0x1000);
    iVar1 = getNativeKeyValueList(__ptr,0x1000);
    if (((iVar1 != 0) && (*__ptr != '\0')) &&
       (iVar1 = recordProperty(DAT_0003d8d0,"key-value",__ptr), iVar1 < 1)) {
      log2Console(6,&DAT_00034c70,"Failed to record key-value list.");
    }
    free(__ptr);
    log2Console(4,&DAT_00034c70,"Native key-value list has been recorded.");
    closeCrashRecordFile();
    return 1;
  }
  log2Console(6,&DAT_00034c70,"save key value fail!");
  return 0;
}



undefined4 saveNativeLog2File(int param_1)

{
  char *__ptr;
  int iVar1;
  
  log2Console(4,&DAT_00034c70,"Record native log.");
  if (param_1 != 0) {
    if (DAT_0003d8d0 == (FILE *)0x0) {
      DAT_0003d8d0 = fopen(DAT_0003d8d4,"a");
    }
    __ptr = (char *)calloc(1,0x7800);
    iVar1 = getNativeLog(__ptr,0x7800);
    if (((iVar1 != 0) && (*__ptr != '\0')) &&
       (iVar1 = recordProperty(DAT_0003d8d0,"nativeLog",__ptr), iVar1 < 1)) {
      log2Console(6,&DAT_00034c70,"Failed to record native log.");
    }
    free(__ptr);
    log2Console(4,&DAT_00034c70,"Native log has been recorded.");
    closeCrashRecordFile();
    return 1;
  }
  log2Console(6,&DAT_00034c70,"save native log fail!");
  return 0;
}



void saveJavaDump2File(int param_1,char *param_2)

{
  int iVar1;
  
  log2Console(4,&DAT_00034c70,"Record Java stack.");
  if (param_1 == 0) {
    log2Console(6,&DAT_00034c70,"save jstack fail!");
    return;
  }
  if (DAT_0003d8d0 == (FILE *)0x0) {
    DAT_0003d8d0 = fopen(DAT_0003d8d4,"a");
  }
  if (((param_2 != (char *)0x0) && (*param_2 != '\0')) &&
     (iVar1 = recordProperty(DAT_0003d8d0,"jstack",param_2), iVar1 < 1)) {
    log2Console(6,&DAT_00034c70,"Failed to record java stack.");
  }
  log2Console(4,&DAT_00034c70,"Java stack has been recorded.");
  closeCrashRecordFile();
  free(DAT_0003d8d4);
  return;
}



undefined4 initRegisterRecordFile(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  int iVar1;
  int *piVar2;
  char *pcVar3;
  
  log2Console(4,&DAT_00034c70,"Init register record file.");
  DAT_0003d8dc = (char *)calloc(1,0x100);
  if (((DAT_0003d8dc != (char *)0x0) &&
      (iVar1 = snprintf(DAT_0003d8dc,0x100,"%s/%s",param_1,"reg_record.txt"), 0 < iVar1)) &&
     (DAT_0003d8e0 = fopen(DAT_0003d8dc,"w"), DAT_0003d8e0 != (FILE *)0x0)) {
    iVar1 = recordLine(DAT_0003d8e0,param_2);
    if (0 < iVar1) {
      DAT_0003d094 = param_3;
      log2Console(4,&DAT_00034c70,"Init of register record file finished.");
      return 1;
    }
    log2Console(6,&DAT_00034c70,"write register head fail");
    closeRegisterRecordFile();
  }
  piVar2 = (int *)__errno();
  pcVar3 = strerror(*piVar2);
  log2Console(5,&DAT_00034c70,"Failed to init register record path: %s",pcVar3);
  return 0;
}



void closeRegisterRecordFile(void)

{
  if (DAT_0003d8e0 != (FILE *)0x0) {
    fclose(DAT_0003d8e0);
    DAT_0003d8e0 = (FILE *)0x0;
  }
  if (DAT_0003d8dc != (void *)0x0) {
    free(DAT_0003d8dc);
    DAT_0003d8dc = (void *)0x0;
  }
  return;
}



undefined4 recordRegisterInfo2File(int param_1,int param_2,int param_3)

{
  undefined4 uVar1;
  int iVar2;
  
  uVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    iVar2 = FUN_0001a4ac(&DAT_00036d4a,*(undefined4 *)(param_1 + 0x20),param_2,param_3);
    if ((((iVar2 == 0) ||
         (((iVar2 = FUN_0001a4ac(&DAT_00036d4d,*(undefined4 *)(param_1 + 0x24),param_2,param_3),
           iVar2 == 0 ||
           (iVar2 = FUN_0001a4ac(&DAT_00036d50,*(undefined4 *)(param_1 + 0x28),param_2,param_3),
           iVar2 == 0)) ||
          (iVar2 = FUN_0001a4ac(&DAT_00036d53,*(undefined4 *)(param_1 + 0x2c),param_2,param_3),
          iVar2 == 0)))) ||
        ((((iVar2 = FUN_0001a4ac(&DAT_00036d56,*(undefined4 *)(param_1 + 0x30),param_2,param_3),
           iVar2 == 0 ||
           (iVar2 = FUN_0001a4ac(&DAT_00036d59,*(undefined4 *)(param_1 + 0x34),param_2,param_3),
           iVar2 == 0)) ||
          (iVar2 = FUN_0001a4ac(&DAT_00036d5c,*(undefined4 *)(param_1 + 0x38),param_2,param_3),
          iVar2 == 0)) ||
         (((iVar2 = FUN_0001a4ac(&DAT_00036d5f,*(undefined4 *)(param_1 + 0x3c),param_2,param_3),
           iVar2 == 0 ||
           (iVar2 = FUN_0001a4ac(&DAT_00036d62,*(undefined4 *)(param_1 + 0x40),param_2,param_3),
           iVar2 == 0)) ||
          (((iVar2 = FUN_0001a4ac(&DAT_00036d65,*(undefined4 *)(param_1 + 0x44),param_2,param_3),
            iVar2 == 0 ||
            ((((iVar2 = FUN_0001a4ac(&DAT_00036d68,*(undefined4 *)(param_1 + 0x48),param_2,param_3),
               iVar2 == 0 ||
               (iVar2 = FUN_0001a4ac(&DAT_00036d6c,*(undefined4 *)(param_1 + 0x4c),param_2,param_3),
               iVar2 == 0)) ||
              (iVar2 = FUN_0001a4ac(&DAT_00036d6f,*(undefined4 *)(param_1 + 0x50),param_2,param_3),
              iVar2 == 0)) ||
             ((iVar2 = FUN_0001a4ac(&DAT_00036d72,*(undefined4 *)(param_1 + 0x54),param_2,param_3),
              iVar2 == 0 ||
              (iVar2 = FUN_0001a4ac(&DAT_000366a4,*(undefined4 *)(param_1 + 0x58),param_2,param_3),
              iVar2 == 0)))))) ||
           (iVar2 = FUN_0001a4ac(&DAT_000366a1,*(undefined4 *)(param_1 + 0x5c),param_2,param_3),
           iVar2 == 0)))))))) ||
       (iVar2 = FUN_0001a4ac(&DAT_00036d75,*(undefined4 *)(param_1 + 0x60),param_2,param_3),
       iVar2 == 0)) {
      uVar1 = 0;
    }
    else {
      if (param_3 != -1) {
        log2Report(param_3,1,&DAT_00036d7a);
      }
      log2Console(4,&DAT_00034c70,"Record register info end");
      uVar1 = 1;
    }
  }
  return uVar1;
}



undefined4 FUN_0001a4ac(undefined4 param_1,undefined4 param_2,undefined4 param_3,int param_4)

{
  uint uVar1;
  int iVar2;
  undefined4 uVar3;
  uint uVar4;
  
  iVar2 = log2File(param_3,"%s=0x%08x\n",param_1,param_2);
  if (iVar2 < 1) {
    uVar3 = 0;
  }
  else {
    if (param_4 != -1) {
      uVar4 = DAT_0003d8d8 + 1;
      uVar1 = DAT_0003d8d8 & 3;
      DAT_0003d8d8 = uVar4;
      if (uVar1 == 0) {
        log2Report(param_4,1,&DAT_00036da0);
      }
      log2Report(param_4,0,"  %s: 0x%08x",param_1,param_2);
    }
    uVar3 = 1;
  }
  return uVar3;
}



undefined4 recordRegisterInfo(int param_1)

{
  undefined4 uVar1;
  
  if ((param_1 != 0) && (DAT_0003d8e0 != 0)) {
    uVar1 = recordRegisterInfo2File(param_1,DAT_0003d8e0,DAT_0003d094);
    return uVar1;
  }
  return 0;
}



undefined4 initMapRecordFile(undefined4 param_1,undefined4 param_2)

{
  int iVar1;
  int *piVar2;
  char *pcVar3;
  
  log2Console(4,&DAT_00034c70,"Init register record file.");
  DAT_0003d8e4 = (char *)calloc(1,0x100);
  if (((DAT_0003d8e4 != (char *)0x0) &&
      (iVar1 = snprintf(DAT_0003d8e4,0x100,"%s/%s",param_1,"map_record.txt"), 0 < iVar1)) &&
     (DAT_0003d8e8 = fopen(DAT_0003d8e4,"w"), DAT_0003d8e8 != (FILE *)0x0)) {
    iVar1 = recordLine(DAT_0003d8e8,param_2);
    if (0 < iVar1) {
      log2Console(4,&DAT_00034c70,"Init of map record file finished.");
      return 1;
    }
    log2Console(6,&DAT_00034c70,"write register head fail");
    closeRegisterRecordFile();
  }
  piVar2 = (int *)__errno();
  pcVar3 = strerror(*piVar2);
  log2Console(5,&DAT_00034c70,"Failed to init map record path: %s",pcVar3);
  return 0;
}



void closeMapRecordFile(void)

{
  if (DAT_0003d8e8 != (FILE *)0x0) {
    fclose(DAT_0003d8e8);
    DAT_0003d8e8 = (FILE *)0x0;
  }
  if (DAT_0003d8e4 != (void *)0x0) {
    free(DAT_0003d8e4);
    DAT_0003d8e4 = (void *)0x0;
  }
  return;
}



int recordMapLine(void)

{
  int iVar1;
  
  iVar1 = FUN_0001a658();
  if (iVar1 != 0) {
    iVar1 = 1;
  }
  return iVar1;
}



undefined4 FUN_0001a658(undefined4 param_1,int param_2,int param_3,int param_4,int param_5)

{
  undefined4 uVar1;
  int iVar2;
  char *pcVar3;
  int iVar4;
  
  uVar1 = 0;
  if ((param_3 != 0) && (param_5 != 0)) {
    if (param_4 == 0) {
      pcVar3 = "%08x-%08x  %s [unknown:unknown]\n";
      iVar2 = param_2;
      iVar4 = param_3;
    }
    else {
      pcVar3 = "%08x-%08x  %s [%s:%s]\n";
      iVar2 = param_4 + 0x84;
      iVar4 = param_4 + 0xa4;
    }
    iVar2 = log2File(param_5,pcVar3,param_1,param_2,param_3,iVar2,iVar4,param_4);
    if (iVar2 < 1) {
      uVar1 = 0;
    }
    else {
      uVar1 = 1;
    }
  }
  return uVar1;
}



undefined4 recordMapInfo2File(undefined4 *param_1,char *param_2,int param_3)

{
  undefined4 uVar1;
  size_t sVar2;
  char *pcVar3;
  uint uVar4;
  uint uVar5;
  char *__s;
  
  uVar1 = 0;
  if ((param_1 != (undefined4 *)0x0) && (param_3 != 0)) {
    for (; param_1 != (undefined4 *)0x0; param_1 = (undefined4 *)*param_1) {
      __s = (char *)((int)param_1 + 0x27);
      sVar2 = strlen(__s);
      if (sVar2 != 0) {
        uVar5 = (uint)*(byte *)((int)param_1 + 0x26);
        uVar4 = uVar5;
        if (uVar5 != 0) {
          uVar4 = 1;
        }
        if (param_2 != (char *)0x0) {
          pcVar3 = strstr(__s,param_2);
          if (pcVar3 != (char *)0x0) {
            pcVar3 = (char *)0x1;
          }
          if (uVar5 != 0) {
            uVar5 = 1;
          }
          uVar4 = uVar5 & (uint)pcVar3;
        }
        pcVar3 = strchr(__s,0x28);
        if (((pcVar3 == (char *)0x0) && (*__s != '[')) && (uVar4 == 1)) {
          uVar1 = getElfInfo(__s);
          FUN_0001a658(param_1[1],param_1[2],__s,uVar1,param_3);
        }
      }
    }
    uVar1 = 1;
  }
  return uVar1;
}



undefined4 recordMapInfo(int param_1)

{
  undefined4 uVar1;
  
  if ((param_1 != 0) && (DAT_0003d8e8 != 0)) {
    uVar1 = recordMapInfo2File(param_1,0);
    return uVar1;
  }
  return 0;
}



undefined4 recordAllMapInfo(int param_1)

{
  char *pcVar1;
  char *__s;
  FILE *__stream;
  char *pcVar2;
  int *piVar3;
  undefined1 *puVar4;
  
  puVar4 = &stack0xfffffff8;
  if (1 < param_1) {
    pcVar1 = (char *)calloc(1,0x100);
    __s = (char *)calloc(1,0x400);
    sprintf(pcVar1,"/proc/%d/maps",param_1);
    log2Console(4,&DAT_00034c70,"Read map file: %s",pcVar1,puVar4);
    __stream = fopen(pcVar1,"r");
    if (__stream == (FILE *)0x0) {
      piVar3 = (int *)__errno();
      pcVar1 = strerror(*piVar3);
      log2Console(4,&DAT_00034c70,"Failed to open maps file for: %s",pcVar1);
    }
    else {
      while (pcVar2 = fgets(__s,0x400,__stream), pcVar2 != (char *)0x0) {
        pcVar2 = strchr(__s,0x28);
        if ((pcVar2 == (char *)0x0) &&
           (((pcVar2 = strstr(__s,"r-x"), pcVar2 != (char *)0x0 ||
             (pcVar2 = strstr(__s,"rwx"), pcVar2 != (char *)0x0)) ||
            (pcVar2 = strstr(__s,"--x"), pcVar2 != (char *)0x0)))) {
          log2File(DAT_0003d8e8,__s);
        }
      }
      free(__s);
      free(pcVar1);
      fclose(__stream);
    }
  }
  return 0;
}



undefined8 GetAbortMessageAfterQ(undefined4 *param_1,char *param_2,uint param_3)

{
  int iVar1;
  undefined4 uVar2;
  char *pcVar3;
  int *piVar4;
  undefined4 unaff_r5;
  uint __n;
  
  log2Console(6,&DAT_00034c70,"get abort message after Q");
  if (param_1 == (undefined4 *)0x0) {
    pcVar3 = "maps is null";
  }
  else {
    for (; param_1 != (undefined4 *)0x0; param_1 = (undefined4 *)*param_1) {
      iVar1 = strcmp((char *)((int)param_1 + 0x27),"[anon:abort message]");
      if (iVar1 == 0) {
        log2Console(3,&DAT_00034c70,"found vma area [anon:abort message], begin check");
        piVar4 = (int *)param_1[1];
        pcVar3 = "magic 1 compare wrong";
        if ((*piVar4 == 0x6ac388f0 && piVar4[1] == -0x4e71bf78) &&
           (pcVar3 = "magic 2 compare wrong", piVar4[2] == 0x5a1de0b5 && piVar4[3] == -0x3920458b))
        {
          log2Console(3,&DAT_00034c70,"found [anon:abort message]");
          __n = piVar4[4];
          if (param_3 < (uint)piVar4[4]) {
            __n = param_3;
          }
          if (0 < (int)__n) {
            strncpy(param_2,(char *)(piVar4 + 5),__n);
            param_2[__n + 1] = '\0';
            log2Console(3,&DAT_00034c70,"the abort msg is %s",param_2);
          }
          uVar2 = 1;
          goto LAB_0001a8f4;
        }
        log2Console(4,&DAT_00034c70,pcVar3);
      }
    }
    pcVar3 = "oops, didn\'t found [anon:abort message]";
  }
  log2Console(4,&DAT_00034c70,pcVar3);
  uVar2 = 0;
LAB_0001a8f4:
  return CONCAT44(unaff_r5,uVar2);
}



undefined4 GetAbortMessageBeforeQ(undefined4 *param_1,char *param_2,uint param_3)

{
  int *piVar1;
  char *pcVar2;
  int iVar3;
  uint __n;
  
  log2Console(3,&DAT_00034c70,"get abort message before Q");
  if (param_1 == (undefined4 *)0x0) {
    pcVar2 = "the maps is NULL";
  }
  else {
    for (; param_1 != (undefined4 *)0x0; param_1 = (undefined4 *)*param_1) {
      iVar3 = strcmp((char *)((int)param_1 + 0x27),"/system/lib/libc.so");
      if ((iVar3 == 0) && (param_1[3] == 0)) {
        iVar3 = param_1[1];
        goto LAB_0001a9d6;
      }
    }
    iVar3 = 0;
LAB_0001a9d6:
    piVar1 = (int *)searchSymbol((int)param_1 + 0x27,"__abort_message_ptr");
    if (piVar1 != (int *)0x0) {
      __n = *(uint *)**(int **)(*piVar1 + iVar3);
      if (param_3 < __n) {
        __n = param_3;
      }
      if (0 < (int)__n) {
        strncpy(param_2,(char *)((uint *)**(int **)(*piVar1 + iVar3) + 1),__n);
        param_2[__n + 1] = '\0';
        log2Console(3,&DAT_00034c70,"the abort msg is %s",param_2);
      }
      return 1;
    }
    pcVar2 = "find __abort_message_ptr failed";
  }
  log2Console(4,&DAT_00034c70,pcVar2);
  return 0;
}



void getAbortMessage(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  int iVar1;
  
  iVar1 = getAndroidApiLevel();
  if (iVar1 < 0x1d) {
    GetAbortMessageBeforeQ(param_1,param_2,param_3);
    return;
  }
  GetAbortMessageAfterQ(param_1,param_2,param_3);
  return;
}



void freeSymbolTable(undefined4 *param_1)

{
  int iVar1;
  int iVar2;
  
  if (param_1 == (undefined4 *)0x0) {
    return;
  }
  iVar2 = 8;
  for (iVar1 = 0; iVar1 < (int)param_1[1]; iVar1 = iVar1 + 1) {
    free(*(void **)((int)*param_1 + iVar2));
    iVar2 = iVar2 + 0xc;
  }
  free((void *)*param_1);
  free(param_1);
  return;
}



void closeElfInfoParser(void)

{
  int iVar1;
  void *pvVar2;
  
  while (DAT_0003d8ec != (void *)0x0) {
    pvVar2 = *(void **)((int)DAT_0003d8ec + 8);
    if (*(int **)((int)DAT_0003d8ec + 4) != (int *)0x0) {
      iVar1 = **(int **)((int)DAT_0003d8ec + 4);
      if (iVar1 != 0) {
        freeSymbolTable(iVar1);
      }
      free(*(void **)((int)DAT_0003d8ec + 4));
    }
    free(DAT_0003d8ec);
    DAT_0003d8ec = pvVar2;
  }
  return;
}



undefined4 parseElfVersion(char *param_1,char *param_2)

{
  undefined4 uVar1;
  
  uVar1 = 0xffffffff;
  if ((param_1 != (char *)0x0) && (param_2 != (char *)0x0)) {
    strncpy(param_2,param_1,0x10);
    uVar1 = 0;
    param_2[0xf] = '\0';
  }
  return uVar1;
}



void parseElf(char *param_1,int param_2)

{
  char cVar1;
  ushort uVar2;
  char cVar3;
  short sVar4;
  uint uVar5;
  int __fd;
  int iVar6;
  char *pcVar7;
  undefined4 *puVar8;
  int iVar9;
  size_t sVar10;
  char *pcVar11;
  uint uVar12;
  undefined4 *__ptr;
  short *psVar13;
  short *psVar14;
  int iVar15;
  int *piVar16;
  undefined4 uVar17;
  uint uVar18;
  undefined4 uVar19;
  uint *puVar20;
  char *pcVar21;
  int iVar22;
  uint uVar23;
  uint uVar24;
  bool bVar25;
  char *local_cc;
  uint *local_c8;
  uint local_c0;
  uint local_b8;
  uint local_b4;
  char *local_b0;
  char *local_ac;
  void *local_a8;
  char *local_a4;
  char *local_a0;
  int local_98;
  char *local_94;
  stat sStack_90;
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (param_1 == (char *)0x0) goto LAB_0001abec;
  __fd = open(param_1,0);
  if (__fd < 0) {
    piVar16 = (int *)__errno();
    pcVar7 = strerror(*piVar16);
    log2Console(5,&DAT_00034c70,"Failed to open file: %s, for: %s",param_1,pcVar7);
    goto LAB_0001abec;
  }
  iVar6 = fstat(__fd,&sStack_90);
  if ((iVar6 < 0) ||
     (pcVar7 = (char *)mmap((void *)0x0,sStack_90.st_blksize,1,2,__fd,0), pcVar7 + 1 < (char *)0x2))
  {
    log2Console(5,&DAT_00034c70,"Failed to read size of file: %s",param_1);
  }
  else {
    if (*pcVar7 == '\x7f') {
      cVar1 = pcVar7[1];
      bVar25 = cVar1 == 'E';
      if (bVar25) {
        cVar1 = pcVar7[2];
      }
      if ((!bVar25 || cVar1 != 'L') || (pcVar7[3] != 'F')) goto LAB_0001abca;
      log2Console(4,&DAT_00034c70,"Parsing ELF file: %s",param_1);
      puVar8 = (undefined4 *)calloc(1,200);
      if (puVar8 == (undefined4 *)0x0) {
        log2Console(4,&DAT_00034c70,"Failed to alloc memory for ElfInfo");
        goto LAB_0001abde;
      }
      strncpy((char *)(puVar8 + 1),param_1,0x80);
      *(undefined1 *)((int)puVar8 + 0x83) = 0;
      cVar1 = pcVar7[4];
      if (cVar1 == '\x02') {
        sVar4 = *(short *)(pcVar7 + 0x12);
        if (sVar4 == 8) {
LAB_0001ac92:
          pcVar11 = "mips64";
LAB_0001acda:
          strncpy((char *)(puVar8 + 0x21),pcVar11,0x10);
        }
        else {
          if (sVar4 == 0xb7) {
            pcVar11 = "arm64-v8a";
            goto LAB_0001acda;
          }
          if (sVar4 == 0x3e) {
            pcVar11 = "x86_64";
            goto LAB_0001acda;
          }
          if (sVar4 == 10) goto LAB_0001ac92;
          strncpy((char *)(puVar8 + 0x21),"unknown",0x10);
          log2Console(5,&DAT_00034c70,"Failed to parse e_machine");
        }
        *(undefined1 *)((int)puVar8 + 0x93) = 0;
        uVar24 = 0xffffffff;
        uVar12 = 0xffffffff;
        iVar6 = *(int *)(pcVar7 + 0x28);
        uVar2 = *(ushort *)(pcVar7 + 0x3c);
        piVar16 = (int *)(pcVar7 + iVar6 + 4);
        local_b4 = 0xffffffff;
        local_b0 = (char *)0xffffffff;
        local_b8 = 0xffffffff;
        for (uVar18 = 0; uVar2 != uVar18; uVar18 = uVar18 + 1) {
          iVar9 = *piVar16;
          pcVar11 = pcVar7 + piVar16[-1] +
                             *(int *)(pcVar7 + (uint)*(ushort *)(pcVar7 + 0x3e) * 0x40 + iVar6 +
                                               0x18);
          uVar23 = local_b8;
          uVar5 = local_b4;
          if (iVar9 == 1) {
            sVar10 = strlen(pcVar11);
            iVar9 = strncmp(".bugly_version",pcVar11,sVar10);
            uVar23 = uVar18;
            if ((iVar9 != 0) &&
               (iVar9 = strncmp(".text",pcVar11,sVar10), uVar23 = local_b8, iVar9 == 0)) {
              uVar24 = uVar18;
            }
          }
          else {
            uVar5 = uVar18;
            if (iVar9 != 0xb) {
              if (iVar9 == 7) {
                sVar10 = strlen(pcVar11);
                iVar9 = strncmp(".note.gnu.build-id",pcVar11,sVar10);
                uVar5 = local_b4;
                if (iVar9 == 0) {
                  uVar12 = uVar18;
                }
              }
              else {
                uVar5 = local_b4;
                if (iVar9 == 2) {
                  local_b0 = (char *)uVar18;
                }
              }
            }
          }
          local_b4 = uVar5;
          local_b8 = uVar23;
          piVar16 = piVar16 + 0x10;
        }
        if (local_b8 != 0xffffffff) {
          parseElfVersion(pcVar7 + *(int *)(pcVar7 + local_b8 * 0x40 + iVar6 + 0x18),puVar8 + 0x25);
          log2Console(4,&DAT_00034c70,"SO version is: %s",puVar8 + 0x25);
        }
        if (uVar12 != 0xffffffff) {
          iVar6 = *(int *)(pcVar7 + uVar12 * 0x40 + iVar6 + 0x18);
          goto LAB_0001b176;
        }
        uVar12 = uVar24 + 1;
        if (uVar12 != 0) {
          iVar6 = uVar24 * 0x40 + iVar6;
          uVar17 = *(undefined4 *)(pcVar7 + iVar6 + 0x20);
          uVar19 = *(undefined4 *)(pcVar7 + iVar6 + 0x24);
          iVar6 = *(int *)(pcVar7 + iVar6 + 0x18);
          goto LAB_0001b1e6;
        }
      }
      else {
        if (cVar1 != '\x01') {
          log2Console(5,&DAT_00034c70,"File format error");
          goto LAB_0001abde;
        }
        switch(*(short *)(pcVar7 + 0x12)) {
        case 3:
        case 7:
          pcVar11 = "x86";
          break;
        case 4:
        case 5:
        case 6:
        case 9:
switchD_0001ac50_caseD_4:
          log2Console(5,&DAT_00034c70,"Unknown e_machine: %d");
          goto LAB_0001aea2;
        case 8:
        case 10:
          pcVar11 = "mips";
          break;
        default:
          if (*(short *)(pcVar7 + 0x12) != 0x28) goto switchD_0001ac50_caseD_4;
          strncpy((char *)(puVar8 + 0x21),"armeabi",0x10);
          bVar25 = true;
          goto LAB_0001aea4;
        }
        strncpy((char *)(puVar8 + 0x21),pcVar11,0x10);
LAB_0001aea2:
        bVar25 = false;
LAB_0001aea4:
        *(undefined1 *)((int)puVar8 + 0x93) = 0;
        iVar9 = *(int *)(pcVar7 + 0x20);
        uVar24 = 0xffffffff;
        uVar2 = *(ushort *)(pcVar7 + 0x30);
        piVar16 = (int *)(pcVar7 + iVar9 + 4);
        local_b4 = 0xffffffff;
        local_b0 = (char *)0xffffffff;
        local_b8 = 0xffffffff;
        local_c0 = 0xffffffff;
        uVar12 = 0xffffffff;
        for (uVar18 = 0; uVar2 != uVar18; uVar18 = uVar18 + 1) {
          pcVar21 = pcVar7 + piVar16[-1] +
                             *(int *)(pcVar7 + (uint)*(ushort *)(pcVar7 + 0x32) * 0x28 + iVar9 +
                                               0x10);
          uVar23 = uVar12;
          uVar5 = local_b4;
          pcVar11 = local_b0;
          if ((pcVar21 != (char *)0x0) && (sVar10 = strlen(pcVar21), sVar10 != 0)) {
            iVar6 = *piVar16;
            if (iVar6 == 1) {
              iVar6 = strncmp(".bugly_version",pcVar21,sVar10);
              uVar23 = uVar18;
              if ((iVar6 != 0) &&
                 (iVar6 = strncmp(".text",pcVar21,sVar10), uVar23 = uVar12, iVar6 == 0)) {
                uVar24 = uVar18;
              }
            }
            else {
              pcVar11 = (char *)uVar18;
              if (iVar6 != 2) {
                if (iVar6 == 7) {
                  iVar6 = strncmp(".note.gnu.build-id",pcVar21,sVar10);
                  pcVar11 = local_b0;
                  if (iVar6 == 0) {
                    local_b8 = uVar18;
                  }
                }
                else {
                  uVar5 = uVar18;
                  pcVar11 = local_b0;
                  if ((iVar6 != 0xb) && (uVar5 = local_b4, iVar6 == 0x70000003)) {
                    local_c0 = uVar18;
                  }
                }
              }
            }
          }
          local_b0 = pcVar11;
          local_b4 = uVar5;
          piVar16 = piVar16 + 10;
          uVar12 = uVar23;
        }
        if (bVar25) {
          if (local_c0 == 0xffffffff) {
            log2Console(5,&DAT_00034c70,".ARM.attributes section not found");
          }
          else {
            iVar6 = local_c0 * 0x28 + iVar9;
            pcVar11 = pcVar7 + *(int *)(pcVar7 + iVar6 + 0x10);
            if (pcVar11 != (char *)0x0) {
              if (*pcVar11 == 'A') {
                if (*(uint *)(pcVar7 + iVar6 + 0x14) < (uint)(byte)pcVar11[1]) {
                  log2Console(5,&DAT_00034c70,".ARM.attributes. section length error");
                }
                else {
                  uVar18 = 5;
                  do {
                    pcVar21 = pcVar11 + uVar18;
                    uVar18 = uVar18 + 1;
                  } while (*pcVar21 != '\0');
                  do {
                    uVar23 = uVar18;
                    if (*(uint *)(pcVar7 + iVar6 + 0x14) <= uVar23) goto switchD_0001b62e_default;
                    uVar18 = uVar23 + (byte)pcVar11[uVar23 + 1];
                  } while (pcVar11[uVar23] != '\x01');
                  local_94 = pcVar11 + uVar23 + 5;
                  pcVar11 = local_94 + (byte)pcVar11[uVar23 + 1];
                  while (local_94 < pcVar11) {
                    uVar17 = FUN_0001ba28(&local_94);
                    switch(uVar17) {
                    case 4:
                    case 5:
                    case 0x20:
                    case 0x41:
                    case 0x43:
                      pcVar21 = local_94;
                      do {
                        local_94 = pcVar21 + 1;
                        cVar3 = *pcVar21;
                        pcVar21 = local_94;
                      } while (cVar3 != '\0');
                      break;
                    case 6:
                      uVar17 = FUN_0001ba28(&local_94);
                      switch(uVar17) {
                      case 1:
                        pcVar11 = "armeabi-v4";
                        break;
                      case 2:
                        pcVar11 = "armeabi-v4t";
                        break;
                      case 3:
                        pcVar11 = "armeabi-v5t";
                        break;
                      case 4:
                        pcVar11 = "armeabi-v5te";
                        break;
                      case 5:
                        pcVar11 = "armeabi-v5tej";
                        break;
                      case 6:
                        pcVar11 = "armeabi-v6";
                        break;
                      case 7:
                        pcVar11 = "armeabi-v6kz";
                        break;
                      case 8:
                        pcVar11 = "armeabi-v6t2";
                        break;
                      case 9:
                        pcVar11 = "armeabi-v6k";
                        break;
                      case 10:
                        pcVar11 = "armeabi-v7a";
                        break;
                      case 0xb:
                        pcVar11 = "armeabi-v6-m";
                        break;
                      case 0xc:
                        pcVar11 = "armeabi-v6s-m";
                        break;
                      case 0xd:
                        pcVar11 = "armeabi-v7e-m";
                        break;
                      case 0xe:
                        pcVar11 = "armeabi-v8";
                        break;
                      default:
                        goto switchD_0001b62e_default;
                      }
                      strncpy((char *)(puVar8 + 0x21),pcVar11,0x10);
                      goto LAB_0001b126;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 0xb:
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
                    case 0x18:
                    case 0x19:
                    case 0x1a:
                    case 0x1b:
                    case 0x1c:
                    case 0x1d:
                    case 0x1e:
                    case 0x1f:
                    case 0x22:
                    case 0x24:
                    case 0x26:
                    case 0x2a:
                    case 0x2c:
                    case 0x40:
                    case 0x42:
                    case 0x44:
                    case 0x46:
                      FUN_0001ba28(&local_94);
                      break;
                    default:
                      log2Console(5,&DAT_00034c70,".ARM.attributes. subsection tag type error");
                      goto switchD_0001b62e_default;
                    }
                  }
switchD_0001b62e_default:
                  strncpy((char *)(puVar8 + 0x21),"unknown",0x10);
                  log2Console(5,&DAT_00034c70,".ARM.attributes. subsection tag type error");
LAB_0001b126:
                  *(undefined1 *)((int)puVar8 + 0x93) = 0;
                }
              }
              else {
                log2Console(5,&DAT_00034c70,
                            "It\'s not a valid .ARM.attributes section for version(%d) is not 0x41."
                           );
              }
            }
          }
        }
        if (uVar12 != 0xffffffff) {
          parseElfVersion(pcVar7 + *(int *)(pcVar7 + uVar12 * 0x28 + iVar9 + 0x10),puVar8 + 0x25);
          log2Console(4,&DAT_00034c70,"SO version is: %s",puVar8 + 0x25);
        }
        if (local_b8 == 0xffffffff) {
          uVar12 = uVar24 + 1;
          if (uVar12 != 0) {
            uVar19 = 0;
            iVar9 = uVar24 * 0x28 + iVar9;
            iVar6 = *(int *)(pcVar7 + iVar9 + 0x10);
            uVar17 = *(undefined4 *)(pcVar7 + iVar9 + 0x14);
LAB_0001b1e6:
            uVar12 = FUN_0001b780(pcVar7 + iVar6,iVar6,uVar17,uVar19,puVar8 + 0x29);
          }
        }
        else {
          iVar6 = *(int *)(pcVar7 + local_b8 * 0x28 + iVar9 + 0x10);
LAB_0001b176:
          uVar12 = FUN_0001b6e8(pcVar7 + iVar6,puVar8 + 0x29);
        }
      }
      pcVar11 = local_b0;
      if (param_2 != 0) {
        if (pcVar7 != (char *)0x0) {
          uVar12 = (uint)local_b0 & local_b4;
        }
        if (pcVar7 != (char *)0x0 && uVar12 != 0xffffffff) {
          log2Console(3,&DAT_00034c70,"symIndex = %d, dynsymIndex = %d",local_b0,local_b4);
          __ptr = (undefined4 *)calloc(1,0xc);
          if (__ptr != (undefined4 *)0x0) {
            if (cVar1 == '\x02') {
              iVar6 = *(int *)(pcVar7 + 0x28);
              if (local_b4 == 0xffffffff) {
                local_ac = (char *)0x0;
                local_c8 = (uint *)0x0;
                local_cc = (char *)0x0;
                puVar20 = (uint *)sStack_90.st_blksize;
              }
              else {
                iVar9 = local_b4 * 0x40 + iVar6;
                iVar22 = *(int *)(pcVar7 + iVar9 + 0x18);
                puVar20 = *(uint **)(pcVar7 + iVar9 + 0x28);
                local_c8 = (uint *)__aeabi_uldivmod(*(undefined4 *)(pcVar7 + iVar9 + 0x20),
                                                    *(undefined4 *)(pcVar7 + iVar9 + 0x24),
                                                    *(undefined4 *)(pcVar7 + iVar9 + 0x38),
                                                    *(undefined4 *)(pcVar7 + iVar9 + 0x3c));
                local_cc = pcVar7 + iVar22;
                local_ac = pcVar7 + *(int *)(pcVar7 + (int)puVar20 * 0x40 + iVar6 + 0x18);
              }
              if (local_b0 == (char *)0xffffffff) {
                local_a4 = (char *)0x0;
                local_98 = 0;
                local_b0 = (char *)0x0;
              }
              else {
                iVar9 = (int)local_b0 * 0x40 + iVar6;
                iVar22 = *(int *)(pcVar7 + iVar9 + 0x18);
                puVar20 = *(uint **)(pcVar7 + iVar9 + 0x28);
                local_98 = __aeabi_uldivmod(*(undefined4 *)(pcVar7 + iVar9 + 0x20),
                                            *(undefined4 *)(pcVar7 + iVar9 + 0x24),
                                            *(undefined4 *)(pcVar7 + iVar9 + 0x38),
                                            *(undefined4 *)(pcVar7 + iVar9 + 0x3c));
                local_b0 = pcVar7 + iVar22;
                local_a4 = pcVar7 + *(int *)(pcVar7 + (int)puVar20 * 0x40 + iVar6 + 0x18);
              }
              if (local_b4 == 0xffffffff) {
                iVar6 = 0;
              }
              else {
                iVar9 = 0;
                iVar6 = 0;
                psVar14 = (short *)(local_cc + 6);
                while (iVar9 < (int)local_c8) {
                  psVar13 = psVar14 + 0xc;
                  sVar4 = *psVar14;
                  iVar9 = iVar9 + 1;
                  psVar14 = psVar13;
                  if (sVar4 != 0) {
                    iVar6 = iVar6 + 1;
                  }
                }
              }
              if (pcVar11 == (char *)0xffffffff) {
                iVar9 = 0;
              }
              else {
                iVar9 = 0;
                puVar20 = (uint *)(local_b0 + 8);
                for (iVar22 = 0; iVar22 < local_98; iVar22 = iVar22 + 1) {
                  if ((((*(short *)((int)puVar20 + -2) != 0) &&
                       (sVar10 = strlen(local_a4 + puVar20[-2]), sVar10 != 0)) &&
                      (*puVar20 != 0 || puVar20[1] != 0)) && (puVar20[2] != 0 || puVar20[3] != 0)) {
                    iVar9 = iVar9 + 1;
                  }
                  puVar20 = puVar20 + 6;
                }
              }
              log2Console(3,&DAT_00034c70,"symbol_count = %d, dynsymbol_count = %d",iVar9,iVar6);
              sVar10 = iVar9 + iVar6;
              __ptr[1] = sVar10;
              local_a8 = calloc(sVar10,0xc);
              *__ptr = local_a8;
              if (local_a8 != (void *)0x0) {
                if (local_b4 == 0xffffffff) {
                  local_a0 = (char *)0x0;
                  local_c8 = puVar20;
                }
                else {
                  local_cc = local_cc + 8;
                  local_a0 = (char *)0x0;
                  for (iVar6 = 0; iVar6 < (int)local_c8; iVar6 = iVar6 + 1) {
                    if (*(short *)(local_cc + -2) != 0) {
                      pcVar21 = strdup(local_ac + *(int *)(local_cc + -8));
                      *(char **)((int)local_a8 + (int)local_a0 * 0xc + 8) = pcVar21;
                      *(undefined4 *)((int)local_a8 + (int)local_a0 * 0xc) = *(undefined4 *)local_cc
                      ;
                      *(undefined4 *)((int)local_a8 + (int)local_a0 * 0xc + 4) =
                           *(undefined4 *)(local_cc + 8);
                      local_a0 = (char *)((int)local_a0 + 1);
                    }
                    local_cc = local_cc + 0x18;
                  }
                }
                local_b4 = sVar10;
                if (pcVar11 != (char *)0xffffffff) {
                  puVar20 = (uint *)(local_b0 + 8);
                  for (iVar6 = 0; iVar6 < local_98; iVar6 = iVar6 + 1) {
                    if (*(short *)((int)puVar20 + -2) != 0) {
                      uVar12 = puVar20[-2];
                      sVar10 = strlen(local_a4 + uVar12);
                      if (sVar10 != 0) {
                        uVar18 = puVar20[1];
                        uVar24 = *puVar20 | uVar18;
                        bVar25 = uVar24 != 0;
                        if (bVar25) {
                          local_c8 = puVar20 + 2;
                          uVar24 = *local_c8;
                          uVar18 = puVar20[3];
                        }
                        if (bVar25 && (uVar24 != 0 || uVar18 != 0)) {
                          pcVar11 = strdup(local_a4 + uVar12);
                          *(char **)((int)local_a8 + (int)local_a0 * 0xc + 8) = pcVar11;
                          *(uint *)((int)local_a8 + (int)local_a0 * 0xc) = *puVar20;
                          *(uint *)((int)local_a8 + (int)local_a0 * 0xc + 4) = *local_c8;
                          local_a0 = (char *)((int)local_a0 + 1);
                        }
                      }
                    }
                    puVar20 = puVar20 + 6;
                  }
                }
                goto LAB_0001b5fc;
              }
LAB_0001b506:
              free(__ptr);
            }
            else if (cVar1 == '\x01') {
              iVar6 = *(int *)(pcVar7 + 0x20);
              if (local_b4 == 0xffffffff) {
                local_cc = (char *)0x0;
                local_ac = (char *)0x0;
                local_a4 = (char *)0x0;
              }
              else {
                iVar9 = local_b4 * 0x28 + iVar6;
                iVar22 = *(int *)(pcVar7 + iVar9 + 0x18);
                local_cc = pcVar7 + *(int *)(pcVar7 + iVar9 + 0x10);
                local_a4 = (char *)__aeabi_uidiv(*(undefined4 *)(pcVar7 + iVar9 + 0x14),
                                                 *(undefined4 *)(pcVar7 + iVar9 + 0x24));
                local_ac = pcVar7 + *(int *)(pcVar7 + iVar22 * 0x28 + iVar6 + 0x10);
              }
              if (local_b0 == (char *)0xffffffff) {
                local_b0 = (char *)0x0;
                local_a0 = (char *)0x0;
                local_98 = 0;
              }
              else {
                iVar9 = (int)local_b0 * 0x28 + iVar6;
                iVar22 = *(int *)(pcVar7 + iVar9 + 0x18);
                local_b0 = pcVar7 + *(int *)(pcVar7 + iVar9 + 0x10);
                local_98 = __aeabi_uidiv(*(undefined4 *)(pcVar7 + iVar9 + 0x14),
                                         *(undefined4 *)(pcVar7 + iVar9 + 0x24));
                local_a0 = pcVar7 + *(int *)(pcVar7 + iVar22 * 0x28 + iVar6 + 0x10);
              }
              if (local_b4 == 0xffffffff) {
                iVar6 = 0;
              }
              else {
                iVar9 = 0;
                iVar6 = 0;
                psVar14 = (short *)(local_cc + 0xe);
                while (iVar9 < (int)local_a4) {
                  psVar13 = psVar14 + 8;
                  sVar4 = *psVar14;
                  iVar9 = iVar9 + 1;
                  psVar14 = psVar13;
                  if (sVar4 != 0) {
                    iVar6 = iVar6 + 1;
                  }
                }
              }
              if (pcVar11 == (char *)0xffffffff) {
                iVar9 = 0;
              }
              else {
                iVar9 = 0;
                piVar16 = (int *)(local_b0 + 8);
                for (iVar22 = 0; iVar22 < local_98; iVar22 = iVar22 + 1) {
                  if (((*(short *)((int)piVar16 + 6) != 0) &&
                      (sVar10 = strlen(local_a0 + piVar16[-2]), sVar10 != 0)) &&
                     ((piVar16[-1] != 0 && (*piVar16 != 0)))) {
                    iVar9 = iVar9 + 1;
                  }
                  piVar16 = piVar16 + 4;
                }
              }
              log2Console(3,&DAT_00034c70,"symbol_count = %d, dynsymbol_count = %d",iVar9,iVar6);
              sVar10 = iVar9 + iVar6;
              __ptr[1] = sVar10;
              local_a8 = calloc(sVar10,0xc);
              *__ptr = local_a8;
              if (local_a8 == (void *)0x0) goto LAB_0001b506;
              if (local_b4 == 0xffffffff) {
                iVar6 = 0;
              }
              else {
                local_cc = local_cc + 8;
                iVar6 = 0;
                for (iVar9 = 0; iVar9 < (int)local_a4; iVar9 = iVar9 + 1) {
                  iVar22 = iVar6;
                  if (*(short *)(local_cc + 6) != 0) {
                    pcVar21 = strdup(local_ac + *(int *)(local_cc + -8));
                    iVar22 = iVar6 + 1;
                    *(char **)((int)local_a8 + iVar6 * 0xc + 8) = pcVar21;
                    *(undefined4 *)((int)local_a8 + iVar6 * 0xc) = *(undefined4 *)(local_cc + -4);
                    *(undefined4 *)((int)local_a8 + iVar6 * 0xc + 4) = *(undefined4 *)local_cc;
                  }
                  local_cc = local_cc + 0x10;
                  iVar6 = iVar22;
                }
              }
              local_b4 = sVar10;
              if (pcVar11 != (char *)0xffffffff) {
                piVar16 = (int *)(local_b0 + 8);
                for (iVar9 = 0; iVar9 < local_98; iVar9 = iVar9 + 1) {
                  iVar22 = iVar6;
                  if (*(short *)((int)piVar16 + 6) != 0) {
                    iVar15 = piVar16[-2];
                    sVar10 = strlen(local_a0 + iVar15);
                    if (((sVar10 != 0) && (piVar16[-1] != 0)) && (*piVar16 != 0)) {
                      pcVar11 = strdup(local_a0 + iVar15);
                      iVar22 = iVar6 + 1;
                      *(char **)((int)local_a8 + iVar6 * 0xc + 8) = pcVar11;
                      *(int *)((int)local_a8 + iVar6 * 0xc) = piVar16[-1];
                      *(int *)((int)local_a8 + iVar6 * 0xc + 4) = *piVar16;
                    }
                  }
                  piVar16 = piVar16 + 4;
                  iVar6 = iVar22;
                }
              }
LAB_0001b5fc:
              qsort(local_a8,local_b4,0xc,(__compar_fn_t)&LAB_0001ba5c_1);
              *puVar8 = __ptr;
              __ptr[2] = puVar8 + 1;
              goto LAB_0001abde;
            }
          }
        }
        *puVar8 = 0;
      }
    }
    else {
LAB_0001abca:
      log2Console(4,&DAT_00034c70,"Not a elf file: %s",param_1);
    }
LAB_0001abde:
    munmap(pcVar7,sStack_90.st_blksize);
  }
  close(__fd);
LAB_0001abec:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void FUN_0001b6e8(int *param_1,char *param_2)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  char *__s;
  
  if ((param_1 != (int *)0x0) && (param_2 != (char *)0x0)) {
    if (param_1[2] != 3) {
      log2Console(5,&DAT_00034c70,"GNU note type is not GNU_NOTE_TYPE_BUILD_ID(3).");
      return;
    }
    iVar2 = *param_1;
    uVar3 = param_1[1];
    iVar4 = -4;
    uVar1 = uVar3;
    if (uVar3 < 0x11) {
      uVar1 = 0x10;
    }
    __s = param_2;
    for (; iVar4 != 0xc; iVar4 = iVar4 + 1) {
      if (iVar4 + 4U < uVar3) {
        snprintf(__s,3,"%02x",
                 (uint)*(byte *)((int)param_1 + iVar4 + uVar1 + (iVar2 + 3U & 0xfffffffc)));
      }
      else {
        __s[2] = '\0';
        __s[0] = '0';
        __s[1] = '0';
      }
      __s = __s + 2;
    }
    param_2[0x20] = '\0';
  }
  return;
}



void FUN_0001b780(uint param_1,undefined4 param_2,uint param_3,uint param_4,char *param_5)

{
  int iVar1;
  int iVar2;
  char *__s;
  uint local_38;
  uint uStack_34;
  
  iVar1 = __stack_chk_guard;
  local_38 = param_3;
  uStack_34 = param_4;
  if ((param_1 != 0) && (param_5 != (char *)0x0)) {
    local_38 = 0;
    uStack_34 = 0;
    if (param_4 != 0 || param_4 < (0xfff < param_3)) {
      param_3 = 0x1000;
    }
    param_3 = param_1 + param_3;
    for (; param_1 < param_3; param_1 = param_1 + 0x10) {
      for (iVar2 = 0; iVar2 != 0x10; iVar2 = iVar2 + 1) {
        *(byte *)((int)&local_38 + iVar2) =
             *(byte *)(param_1 + iVar2) ^ *(byte *)((int)&local_38 + iVar2);
      }
    }
    __s = param_5;
    for (iVar2 = 0; iVar2 != 0x10; iVar2 = iVar2 + 1) {
      snprintf(__s,3,"%02x",(uint)*(byte *)((int)&local_38 + iVar2));
      __s = __s + 2;
    }
    param_5[0x20] = '\0';
  }
  if (__stack_chk_guard != iVar1) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



int getElfInfoWithSymbolTable(char *param_1,undefined4 param_2)

{
  int iVar1;
  int *piVar2;
  size_t __n;
  int iVar3;
  undefined4 *puVar4;
  char *__s;
  
  if (param_1 != (char *)0x0) {
    piVar2 = (int *)&DAT_0003d8ec;
    while (puVar4 = (undefined4 *)*piVar2, puVar4 != (undefined4 *)0x0) {
      __s = (char *)*puVar4;
      __n = strlen(__s);
      iVar3 = strncmp(__s,param_1,__n);
      if (iVar3 == 0) {
        if (puVar4[1] != 0) {
          return puVar4[1];
        }
        break;
      }
      piVar2 = puVar4 + 2;
    }
    iVar3 = parseElf(param_1,param_2);
    if (iVar3 != 0) {
      piVar2 = (int *)malloc(0xc);
      *piVar2 = iVar3 + 4;
      piVar2[1] = iVar3;
      iVar1 = (int)DAT_0003d8ec;
      if (DAT_0003d8ec != (int *)0x0) {
        piVar2[2] = *(int *)((int)DAT_0003d8ec + 8);
        *(int **)(iVar1 + 8) = piVar2;
        return iVar3;
      }
      DAT_0003d8ec = piVar2;
      piVar2[2] = 0;
      return iVar3;
    }
  }
  return 0;
}



void getElfInfo(undefined4 param_1)

{
  getElfInfoWithSymbolTable(param_1,0);
  return;
}



undefined4 getElfInfoWithinStackLine(char *param_1)

{
  char *__haystack;
  char *pcVar1;
  char *pcVar2;
  undefined4 uVar3;
  
  if (param_1 == (char *)0x0) {
    uVar3 = 0;
  }
  else {
    __haystack = strdup(param_1);
    pcVar1 = strstr(__haystack,".so");
    if (pcVar1 == (char *)0x0) {
      uVar3 = 0;
    }
    else {
      log2Console(4,&DAT_00034c70,"Parsing stack line for elfInfo: %s",param_1);
      pcVar1 = strchr(__haystack,0x2f);
      pcVar2 = strstr(pcVar1," (");
      if (pcVar2 != (char *)0x0) {
        *pcVar2 = '\0';
      }
      uVar3 = getElfInfo(pcVar1);
    }
    free(__haystack);
  }
  return uVar3;
}



void searchSymbolTable(undefined4 *param_1,int param_2)

{
  void *pvVar1;
  int local_18;
  int local_14;
  
  local_14 = __stack_chk_guard;
  pvVar1 = (void *)0x0;
  local_18 = param_2;
  if ((param_1 != (undefined4 *)0x0) && (param_2 != 0)) {
    pvVar1 = bsearch(&local_18,(void *)*param_1,param_1[1],0xc,(__compar_fn_t)&LAB_0001b954_1);
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(pvVar1);
  }
  return;
}



undefined4 createSymbolTable(undefined4 param_1)

{
  undefined4 *puVar1;
  undefined4 uVar2;
  
  puVar1 = (undefined4 *)getElfInfoWithSymbolTable(param_1,1);
  if (puVar1 == (undefined4 *)0x0) {
    uVar2 = 0;
  }
  else {
    uVar2 = *puVar1;
  }
  return uVar2;
}



undefined4 searchSymbolInElfFile(undefined4 param_1,undefined4 param_2)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = createSymbolTable();
  if (iVar1 == 0) {
    return 0;
  }
  uVar2 = searchSymbolTable(iVar1,param_2);
  return uVar2;
}



int searchSymbol(undefined4 param_1,char *param_2)

{
  int *piVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  
  piVar1 = (int *)createSymbolTable();
  if (piVar1 != (int *)0x0) {
    iVar6 = piVar1[1];
    iVar4 = 0;
    for (iVar5 = 0; iVar5 < iVar6; iVar5 = iVar5 + 1) {
      iVar2 = *piVar1;
      iVar3 = strcmp(*(char **)(iVar2 + iVar4 + 8),param_2);
      if (iVar3 == 0) {
        return iVar2 + iVar4;
      }
      iVar4 = iVar4 + 0xc;
    }
  }
  return 0;
}



int get_elf_exec_load_bias(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int *piVar1;
  int *piVar2;
  
  piVar2 = (int *)(*(int *)(param_1 + 0x1c) + param_1);
  piVar1 = piVar2 + (uint)*(ushort *)(param_1 + 0x2c) * 8;
  while( true ) {
    if (piVar1 <= piVar2) {
      return 0;
    }
    if (*piVar2 == 1) break;
    piVar2 = piVar2 + 8;
  }
  log2Console(3,&DAT_00034c70,"phdr->p_offset = %p, phdr->p_vaddr = %p",piVar2[1],piVar2[2],param_4)
  ;
  return (piVar2[1] + param_1) - piVar2[2];
}



uint FUN_0001ba28(undefined4 *param_1)

{
  byte bVar1;
  byte *pbVar2;
  uint uVar3;
  uint uVar4;
  
  if ((param_1 != (undefined4 *)0x0) && ((byte *)*param_1 != (byte *)0x0)) {
    uVar3 = 0;
    uVar4 = 0;
    pbVar2 = (byte *)*param_1;
    do {
      *param_1 = pbVar2 + 1;
      bVar1 = *pbVar2;
      uVar3 = uVar3 | (bVar1 & 0x7f) << (uVar4 & 0xff);
      uVar4 = uVar4 + 7;
      pbVar2 = pbVar2 + 1;
    } while ((int)((uint)bVar1 << 0x18) < 0);
    return uVar3;
  }
  return 0xffffffff;
}



void initMapInfoList(int param_1,uint param_2,byte param_3)

{
  char cVar1;
  bool bVar2;
  bool bVar3;
  bool bVar4;
  bool bVar5;
  char *pcVar6;
  char *pcVar7;
  char *__s;
  FILE *__stream;
  char *pcVar8;
  size_t sVar9;
  int iVar10;
  int iVar11;
  char *pcVar12;
  undefined4 uVar13;
  int *piVar14;
  undefined4 *puVar15;
  uint uVar16;
  undefined4 *puVar17;
  byte *pbVar18;
  bool bVar19;
  int local_44;
  undefined4 local_40;
  undefined4 uStack_3c;
  char *local_38;
  char *local_34;
  char cStack_2d;
  char cStack_2c;
  char cStack_2b;
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (1 < param_1) {
    pcVar7 = (char *)calloc(1,0x100);
    __s = (char *)calloc(1,0x400);
    sprintf(pcVar7,"/proc/%d/maps",param_1);
    log2Console(4,&DAT_00034c70,"Create map list by maps file: %s",pcVar7);
    __stream = fopen(pcVar7,"r");
    if (__stream == (FILE *)0x0) {
      piVar14 = (int *)__errno();
      pcVar7 = strerror(*piVar14);
      log2Console(4,&DAT_00034c70,"Failed to open maps file for: %s",pcVar7);
    }
    else {
      puVar17 = (undefined4 *)0x0;
LAB_0001bae8:
      pcVar8 = fgets(__s,0x400,__stream);
      if (pcVar8 != (char *)0x0) {
        if ((__s != (char *)0x0) && (sVar9 = strlen(__s), 0x31 < sVar9)) {
          log2Console(3,&DAT_00034c70,"Parsing line: %s",__s);
          pcVar8 = strchr(__s,0x28);
          if (pcVar8 != (char *)0x0) goto LAB_0001bc8a;
          iVar10 = sscanf(__s,"%lx-%lx %4s %lx %*x:%*x %lu%n",&local_34,&local_38,&cStack_2d,
                          &uStack_3c,&local_40,&local_44);
          if (iVar10 == 5) {
            sVar9 = strlen(&cStack_2d);
            cVar1 = cStack_2b;
            pcVar6 = local_34;
            pcVar8 = local_38;
            bVar2 = sVar9 == 4;
            bVar3 = bVar2 && cStack_2b == 'x';
            if ((param_2 ^ 1 | (uint)bVar3) != 1) goto LAB_0001bc6e;
            puVar15 = (undefined4 *)0x0;
            if ((local_34 != (char *)0x0) && (local_34 != local_38)) {
              bVar4 = cStack_2c == 'w';
              bVar5 = bVar2 && cStack_2d == 'r';
              pbVar18 = (byte *)(__s + local_44 + 1);
              while( true ) {
                iVar10 = local_44;
                uVar16 = (uint)(byte)__s[local_44];
                iVar11 = isspace(uVar16);
                if (iVar11 == 0) break;
                local_44 = iVar10 + 1;
                pbVar18 = pbVar18 + 1;
              }
              iVar11 = 0;
              do {
                if (uVar16 != 10) {
                  if (uVar16 == 0) goto code_r0x0001bbf2;
                  iVar11 = iVar11 + 1;
                }
                uVar16 = (uint)*pbVar18;
                pbVar18 = pbVar18 + 1;
              } while( true );
            }
          }
          else {
            log2Console(5,&DAT_00034c70,"Failed to parse the line of maps file.");
LAB_0001bc6e:
            puVar15 = (undefined4 *)0x0;
          }
          goto LAB_0001bc70;
        }
        goto LAB_0001bc8a;
      }
      free(__s);
      free(pcVar7);
      fclose(__stream);
    }
  }
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
code_r0x0001bbf2:
  pcVar12 = "<null>";
  if (iVar11 == 0) {
    iVar11 = 6;
  }
  else {
    pcVar12 = __s + iVar10;
  }
  puVar15 = (undefined4 *)calloc(1,iVar11 + 0x29);
  if (puVar15 == (undefined4 *)0x0) {
    log2Console(4,&DAT_00034c70,"Failed to alloc memory for MapInfo.");
    puVar15 = (undefined4 *)0x0;
  }
  else {
    puVar15[1] = pcVar6;
    if (((param_3 & bVar5) == 1) && (cVar1 == 'x')) {
      cVar1 = *pcVar6;
      bVar19 = cVar1 == '\x7f';
      if (bVar19) {
        cVar1 = pcVar6[1];
      }
      if (bVar19 && cVar1 == 'E') {
        cVar1 = pcVar6[2];
        bVar19 = cVar1 == 'L';
        if (bVar19) {
          cVar1 = pcVar6[3];
        }
        if (bVar19 && cVar1 == 'F') {
          uVar13 = get_elf_exec_load_bias(pcVar6);
          puVar15[6] = uVar13;
          pcVar8 = local_38;
        }
      }
    }
    puVar15[2] = pcVar8;
    puVar15[3] = uStack_3c;
    puVar15[4] = local_40;
    puVar15[5] = 0;
    *(bool *)(puVar15 + 9) = bVar5;
    *(bool *)((int)puVar15 + 0x25) = bVar4 && bVar2;
    *(bool *)((int)puVar15 + 0x26) = bVar3;
    __aeabi_memcpy((int)puVar15 + 0x27,pcVar12,iVar11);
    *(undefined1 *)((int)puVar15 + 0x27 + iVar11) = 0;
  }
LAB_0001bc70:
  if ((puVar15 != (undefined4 *)0x0) &&
     ((puVar17 == (undefined4 *)0x0 || (puVar15[1] != puVar17[1])))) {
    *puVar15 = puVar17;
    puVar17 = puVar15;
  }
LAB_0001bc8a:
  __aeabi_memclr(__s,0x400);
  goto LAB_0001bae8;
}



void initXMapInfoList(undefined4 param_1,undefined4 param_2)

{
  initMapInfoList(param_1,1,param_2);
  return;
}



void initCurrentXMapInfoList(undefined4 param_1)

{
  undefined4 uVar1;
  
  uVar1 = gettid();
  initXMapInfoList(uVar1,param_1);
  return;
}



void initCurrentMapInfoList(undefined4 param_1,undefined4 param_2)

{
  undefined4 uVar1;
  
  uVar1 = gettid();
  initMapInfoList(uVar1,param_1,param_2);
  return;
}



void freeMapInfoList(undefined4 *param_1)

{
  void *pvVar1;
  
  while (param_1 != (undefined4 *)0x0) {
    pvVar1 = (void *)*param_1;
    free(param_1);
    param_1 = (undefined4 *)pvVar1;
  }
  return;
}



undefined4 * findModuleInMapInfoList(undefined4 *param_1,uint param_2)

{
  undefined4 *puVar1;
  undefined4 *puVar2;
  
  puVar2 = (undefined4 *)0x0;
  if ((param_1 != (undefined4 *)0x0) && (puVar1 = param_1, param_2 != 0)) {
    for (; (puVar1 != (undefined4 *)0x0 &&
           ((param_2 < (uint)puVar1[1] || ((uint)puVar1[2] <= param_2))));
        puVar1 = (undefined4 *)*puVar1) {
    }
    while ((puVar2 = puVar1, param_1 != (undefined4 *)0x0 && (puVar1 != (undefined4 *)0x0))) {
      if (*(char *)((int)param_1 + 0x26) != '\0') {
        if (((param_1[4] != 0 || param_1[5] != 0) &&
            (param_1[4] == puVar1[4] && param_1[5] == puVar1[5])) &&
           ((uint)param_1[1] < (uint)puVar1[1])) {
          log2Console(3,&DAT_00034c70,"Fix: %p");
          puVar1 = param_1;
        }
      }
      param_1 = (undefined4 *)*param_1;
    }
  }
  return puVar2;
}



char checkMemoryReadable(undefined4 *param_1,uint param_2)

{
  char cVar1;
  
  if (param_1 == (undefined4 *)0x0) {
    return '\0';
  }
  while( true ) {
    if (param_1 == (undefined4 *)0x0) {
      log2Console(3,&DAT_00034c70,"Can not read addr: %p");
      return '\0';
    }
    if (((uint)param_1[1] <= param_2) && (param_2 < (uint)param_1[2])) break;
    param_1 = (undefined4 *)*param_1;
  }
  cVar1 = *(char *)(param_1 + 9);
  if (cVar1 != '\0') {
    cVar1 = '\x01';
  }
  return cVar1;
}



void freeNativeKeyValueList(void)

{
  undefined4 *puVar1;
  undefined4 *__ptr;
  
  if (DAT_0003d8f0 == (undefined4 *)0x0) {
    return;
  }
  pthread_mutex_lock((pthread_mutex_t *)&DAT_0003d8f4);
  __ptr = (undefined4 *)DAT_0003d8f0[1];
  while (puVar1 = DAT_0003d8f0, __ptr != (undefined4 *)0x0) {
    puVar1 = (undefined4 *)__ptr[2];
    free((void *)*__ptr);
    free((void *)__ptr[1]);
    free(__ptr);
    __ptr = puVar1;
  }
  *DAT_0003d8f0 = 0;
  puVar1[1] = 0;
  pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003d8f4);
  return;
}



void putNativeKeyValue(char *param_1,char *param_2)

{
  int *piVar1;
  undefined4 *puVar2;
  char *pcVar3;
  
  if ((param_1 != (char *)0x0) && (param_2 != (char *)0x0)) {
    if (DAT_0003d8f0 == (int *)0x0) {
      log2Console(4,&DAT_00034c70,"Initiate native key-value list.");
      pthread_mutex_lock((pthread_mutex_t *)&DAT_0003d8f4);
      if (DAT_0003d8f0 == (int *)0x0) {
        DAT_0003d8f0 = (int *)calloc(1,8);
      }
      pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003d8f4);
      log2Console(4,&DAT_00034c70,"Initialization of native key-value list have been completed.");
    }
    removeNativeKeyValue(param_1,0,0);
    puVar2 = (undefined4 *)malloc(0xc);
    pcVar3 = strdup(param_1);
    *puVar2 = pcVar3;
    pcVar3 = strdup(param_2);
    puVar2[1] = pcVar3;
    pthread_mutex_lock((pthread_mutex_t *)&DAT_0003d8f4);
    piVar1 = DAT_0003d8f0;
    puVar2[2] = DAT_0003d8f0[1];
    *piVar1 = *piVar1 + 1;
    piVar1[1] = (int)puVar2;
    pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003d8f4);
    return;
  }
  return;
}



undefined4 removeNativeKeyValue(char *param_1,char *param_2,size_t param_3)

{
  int iVar1;
  int *piVar2;
  undefined4 *puVar3;
  undefined4 uVar4;
  undefined4 *__ptr;
  undefined1 *puVar5;
  
  puVar5 = &stack0xfffffff8;
  uVar4 = 0;
  if ((param_1 != (char *)0x0) && (DAT_0003d8f0 != (int *)0x0)) {
    pthread_mutex_lock((pthread_mutex_t *)&DAT_0003d8f4);
    piVar2 = DAT_0003d8f0 + 1;
    puVar3 = (undefined4 *)0x0;
    while (__ptr = (undefined4 *)*piVar2, __ptr != (undefined4 *)0x0) {
      iVar1 = strcmp((char *)*__ptr,param_1);
      if (iVar1 == 0) {
        if ((param_2 != (char *)0x0) && (0 < (int)param_3)) {
          snprintf(param_2,param_3,"%s",__ptr[1],puVar5);
        }
        piVar2 = DAT_0003d8f0;
        if (puVar3 == (undefined4 *)0x0) {
          DAT_0003d8f0[1] = __ptr[2];
        }
        else {
          puVar3[2] = __ptr[2];
          piVar2 = DAT_0003d8f0;
        }
        *piVar2 = *piVar2 + -1;
        free((void *)*__ptr);
        free((void *)__ptr[1]);
        free(__ptr);
        uVar4 = 1;
        goto LAB_0001c018;
      }
      puVar3 = __ptr;
      piVar2 = __ptr + 2;
    }
    uVar4 = 0;
LAB_0001c018:
    pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003d8f4);
  }
  return uVar4;
}



undefined4 getNativeKeyValueList(char *param_1,int param_2)

{
  int *piVar1;
  size_t sVar2;
  size_t sVar3;
  undefined4 uVar4;
  undefined4 *puVar5;
  int iVar6;
  char *pcVar7;
  
  if (DAT_0003d8f0 == 0) {
    uVar4 = 0;
  }
  else {
    if (0x1000 < param_2) {
      log2Console(5,&DAT_00034c70,
                  "Buffer length exceeds max length. Buffer will only contain %d bytes.",0x1000,
                  &stack0xfffffff8);
    }
    pthread_mutex_lock((pthread_mutex_t *)&DAT_0003d8f4);
    iVar6 = 0;
    piVar1 = (int *)(DAT_0003d8f0 + 4);
    while (puVar5 = (undefined4 *)*piVar1, puVar5 != (undefined4 *)0x0) {
      pcVar7 = (char *)*puVar5;
      sVar2 = strlen(pcVar7);
      sVar3 = strlen((char *)puVar5[1]);
      iVar6 = sVar3 + iVar6 + sVar2 + 1;
      if (0xfff < iVar6) {
        log2Console(5,&DAT_00034c70,"Native key value exceeds max length. The rest will be dropped."
                   );
        break;
      }
      pcVar7 = strcat(param_1,pcVar7);
      sVar2 = strlen(pcVar7);
      (param_1 + sVar2)[0] = '=';
      (param_1 + sVar2)[1] = '\0';
      pcVar7 = strcat(param_1,(char *)puVar5[1]);
      sVar2 = strlen(pcVar7);
      (param_1 + sVar2)[0] = '\n';
      (param_1 + sVar2)[1] = '\0';
      piVar1 = puVar5 + 2;
    }
    pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003d8f4);
    uVar4 = 1;
  }
  return uVar4;
}



size_t * createCircularQueue(size_t param_1)

{
  size_t *__ptr;
  void *pvVar1;
  
  __ptr = (size_t *)malloc(0xc);
  if (__ptr != (size_t *)0x0) {
    pvVar1 = calloc(param_1,1);
    __ptr[1] = (size_t)pvVar1;
    if (pvVar1 != (void *)0x0) {
      __ptr[2] = 0;
      *__ptr = param_1;
      return __ptr;
    }
    free(__ptr);
  }
  return (size_t *)0x0;
}



void freeCircularQueue(void *param_1)

{
  if (param_1 == (void *)0x0) {
    return;
  }
  free(*(void **)((int)param_1 + 4));
  free(param_1);
  return;
}



void insertCircularQueue(uint *param_1,undefined1 *param_2,uint param_3)

{
  undefined1 uVar1;
  uint uVar2;
  uint extraout_r1;
  
  if ((((param_1 != (uint *)0x0) && (param_2 != (undefined1 *)0x0)) && (param_3 != 0)) &&
     (param_3 <= *param_1)) {
    for (; param_3 != 0; param_3 = param_3 - 1) {
      uVar2 = param_1[2];
      uVar1 = *param_2;
      param_1[2] = uVar2 + 1;
      *(undefined1 *)(param_1[1] + uVar2) = uVar1;
      __aeabi_uidivmod(param_1[2],*param_1);
      param_1[2] = extraout_r1;
      param_2 = param_2 + 1;
    }
  }
  return;
}



uint locateCircularQueue(uint *param_1,int param_2,uint param_3)

{
  int extraout_r1;
  uint extraout_r1_00;
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  
  if ((((param_1 != (uint *)0x0) && (param_2 != 0)) && (param_3 != 0)) &&
     (uVar2 = *param_1, param_3 <= uVar2)) {
    uVar4 = param_1[2];
    for (uVar3 = 0; uVar3 < uVar2; uVar3 = uVar3 + 1) {
      for (uVar1 = 0;
          (uVar1 < param_3 &&
          (__aeabi_uidivmod(uVar4 + uVar1,uVar2),
          *(char *)(param_1[1] + extraout_r1) == *(char *)(param_2 + uVar1))); uVar1 = uVar1 + 1) {
      }
      if (param_3 == uVar1) {
        return uVar4;
      }
      __aeabi_uidivmod(uVar4 + 1,uVar2);
      uVar4 = extraout_r1_00;
    }
  }
  return 0xffffffff;
}



uint readCircularQueue(int *param_1,int param_2,int param_3,int param_4)

{
  int extraout_r1;
  uint uVar1;
  int iVar2;
  
  uVar1 = 0xffffffff;
  if ((param_1 != (int *)0x0) && (param_2 != 0)) {
    iVar2 = *param_1;
    uVar1 = 0;
    do {
      if (iVar2 - 1U <= uVar1) break;
      *(undefined1 *)(param_2 + uVar1) = *(undefined1 *)(param_1[1] + param_3);
      iVar2 = *param_1;
      __aeabi_uidivmod(param_3 + 1,iVar2);
      uVar1 = uVar1 + 1;
      param_3 = extraout_r1;
    } while (extraout_r1 != param_4);
    *(undefined1 *)(param_2 + uVar1) = 0;
  }
  return uVar1;
}



void setLogMode(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  if (param_1 < 5) {
    log2Console(4,&DAT_00034c70,"setLogMode %d current %d",param_1,currentMode,param_4);
  }
  currentMode = param_1;
  return;
}



void log2Console(int param_1)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = __stack_chk_guard;
  if (param_1 < currentMode) {
    uVar2 = 0xffffffff;
  }
  else {
    __android_log_vprint();
    uVar2 = 0;
  }
  if (__stack_chk_guard - iVar1 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar2,__stack_chk_guard - iVar1,__stack_chk_guard);
  }
  return;
}



void log2Report(int param_1,int param_2,char *param_3,undefined4 param_4)

{
  int iVar1;
  size_t __n;
  undefined4 local_4;
  
  iVar1 = __stack_chk_guard;
  local_4 = param_4;
  if (-1 < param_1) {
    vsnprintf(&DAT_0003d8f8,0x400,param_3,&local_4);
    __n = strlen(&DAT_0003d8f8);
    write(param_1,&DAT_0003d8f8,__n);
  }
  if ((currentMode < 5) && (param_2 == 0)) {
    __android_log_vprint(4,&DAT_00034c70,param_3,&local_4);
  }
  if (__stack_chk_guard - iVar1 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - iVar1,__stack_chk_guard);
  }
  return;
}



size_t recordStr(FILE *param_1,char *param_2)

{
  size_t __n;
  size_t sVar1;
  int iVar2;
  
  if ((param_1 != (FILE *)0x0) && (param_2 != (char *)0x0)) {
    __n = strlen(param_2);
    sVar1 = fwrite(param_2,1,__n,param_1);
    if (sVar1 == __n) {
      iVar2 = putc(0,param_1);
      if (iVar2 != -1) {
        return __n;
      }
      log2Console(6,&DAT_00034c70,"Failed to write EOF to file.");
    }
    else {
      log2Console(6,&DAT_00034c70,"Failed to write string to file: %s",param_2);
    }
  }
  return 0xffffffff;
}



int recordProperty(undefined4 param_1,undefined4 param_2,undefined4 param_3)

{
  int iVar1;
  int iVar2;
  char *pcVar3;
  
  iVar1 = recordStr();
  if (iVar1 == -1) {
    pcVar3 = "write key fail";
  }
  else {
    iVar2 = recordStr(param_1,param_3);
    if (iVar2 != -1) {
      return iVar2 + iVar1;
    }
    pcVar3 = "write value fail";
  }
  log2Console(6,&DAT_00034c70,pcVar3);
  return -1;
}



int recordHead(undefined4 param_1)

{
  int iVar1;
  int iVar2;
  
  iVar1 = recordStr(param_1,"NATIVE_RQD_REPORT");
  if (iVar1 == -1) {
    log2Console(6,&DAT_00034c70,"write head fail");
  }
  else {
    iVar2 = recordProperty(param_1,"rqd_rv",&DAT_00037593);
    if (iVar2 != -1) {
      return iVar2 + iVar1;
    }
    log2Console(6,&DAT_00034c70,"write fail %s %s","rqd_rv",&DAT_00037593);
  }
  return -1;
}



void recordEnd(undefined4 param_1,undefined4 param_2)

{
  int iVar1;
  int iVar2;
  char acStack_31 [21];
  int local_1c;
  
  local_1c = __stack_chk_guard;
  iVar1 = snprintf(acStack_31,0x14,"%d",param_2);
  if (iVar1 == -1) {
    log2Console(6,&DAT_00034c70,"snprintf %d",param_2);
    acStack_31[0] = '-';
    acStack_31[1] = '1';
    acStack_31[2] = 0;
  }
  iVar1 = recordProperty(param_1,"rqd_bc",acStack_31);
  if (iVar1 == -1) {
    log2Console(6,&DAT_00034c70,"write property fail %s %d","rqd_bc",acStack_31);
  }
  else {
    iVar2 = recordStr(param_1,"NATIVE_RQD_REPORT");
    if (iVar2 != -1) {
      iVar2 = iVar2 + iVar1;
      goto LAB_0001c54e;
    }
    log2Console(6,&DAT_00034c70,"write end fail");
  }
  iVar2 = -1;
LAB_0001c54e:
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar2);
  }
  return;
}



void log2File(FILE *param_1,char *param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  int iVar2;
  size_t sVar3;
  uint uVar4;
  undefined4 *__arg;
  undefined4 local_8;
  undefined4 uStack_4;
  
  iVar1 = __stack_chk_guard;
  local_8 = param_3;
  uStack_4 = param_4;
  if (param_1 != (FILE *)0x0) {
    __arg = &local_8;
    vsnprintf(&DAT_0003d8f8,0x400,param_2,__arg);
    uVar4 = 0;
    while( true ) {
      sVar3 = strlen(&DAT_0003d8f8);
      if ((sVar3 <= uVar4) || ((byte)(&DAT_0003d8f8)[uVar4] == 0)) goto LAB_0001c606;
      iVar2 = putc((uint)(byte)(&DAT_0003d8f8)[uVar4],param_1);
      if (iVar2 == -1) break;
      uVar4 = uVar4 + 1;
    }
    log2Console(6,&DAT_00034c70,"write err at %d",uVar4,__arg);
  }
LAB_0001c606:
  if (__stack_chk_guard - iVar1 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - iVar1);
}



void recordLine(undefined4 param_1,undefined4 param_2)

{
  log2File(param_1,&DAT_000363cc,param_2);
  return;
}



int checkJavaException(int *param_1)

{
  int iVar1;
  
  iVar1 = (**(code **)(*param_1 + 0x3c))(param_1);
  if (iVar1 != 0) {
    log2Console(5,&DAT_00034c70,"A Java exception has been caught.");
    (**(code **)(*param_1 + 0x40))(param_1);
    (**(code **)(*param_1 + 0x44))(param_1);
  }
  return iVar1;
}



undefined4 getJavaMethodID(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  char *pcVar4;
  
  if (param_1 != (int *)0x0) {
    iVar1 = (**(code **)(*param_1 + 0x18))(param_1);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar4 = "Failed to find class: %s";
    }
    else {
      uVar3 = (**(code **)(*param_1 + 0x84))(param_1,iVar1,param_3,param_4);
      iVar2 = checkJavaException(param_1);
      if (iVar2 == 0) {
        (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
        return uVar3;
      }
      pcVar4 = "Failed to get method ID for specific method(Name: %s, Signature: %s).";
      param_2 = param_3;
    }
    log2Console(6,&DAT_00034c70,pcVar4,param_2);
  }
  return 0;
}



undefined4
getJavaStaticMethodID(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  char *pcVar4;
  
  if (param_1 != (int *)0x0) {
    iVar1 = (**(code **)(*param_1 + 0x18))(param_1);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar4 = "Failed to find class: %s";
    }
    else {
      uVar3 = (**(code **)(*param_1 + 0x1c4))(param_1,iVar1,param_3,param_4);
      iVar1 = checkJavaException(param_1);
      if (iVar1 == 0) {
        return uVar3;
      }
      pcVar4 = "Failed to get method ID for specific method(Name: %s, Signature: %s).";
      param_2 = param_3;
    }
    log2Console(6,&DAT_00034c70,pcVar4,param_2);
  }
  return 0;
}



int javaObjectCall_getClassName(int *param_1,int param_2)

{
  int iVar1;
  int iVar2;
  char *pcVar3;
  char *pcVar4;
  
  if (param_1 == (int *)0x0) {
    return 0;
  }
  if (param_2 == 0) {
    return 0;
  }
  if (jc_Object == 0) {
    iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"java/lang/Object");
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar3 = "find cls error %s ";
    }
    else {
      jc_Object = (**(code **)(*param_1 + 0x54))(param_1,iVar1);
      iVar1 = checkJavaException(param_1);
      if ((iVar1 == 0) && (jc_Object != 0)) goto LAB_0001c7ae;
      pcVar3 = "new cls error %s ";
    }
    pcVar4 = "java/lang/Object";
    goto LAB_0001c93a;
  }
LAB_0001c7ae:
  if (jc_Class == 0) {
    iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"java/lang/Class");
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar3 = "find obj error %s ";
    }
    else {
      jc_Class = (**(code **)(*param_1 + 0x54))(param_1,iVar1);
      iVar1 = checkJavaException(param_1);
      if ((iVar1 == 0) && (jc_Class != 0)) goto LAB_0001c7c0;
      pcVar3 = "new obj error %s ";
    }
    pcVar4 = "java/lang/Class";
LAB_0001c93a:
    log2Console(6,&DAT_00034c70,pcVar3,pcVar4);
    return 0;
  }
LAB_0001c7c0:
  if (jm_Object_getClass == 0) {
    jm_Object_getClass =
         (**(code **)(*param_1 + 0x84))(param_1,jc_Object,"getClass","()Ljava/lang/Class;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 != 0) || (jm_Object_getClass == 0)) {
      pcVar3 = "obj get class error";
      goto LAB_0001c95e;
    }
  }
  if (jm_Class_getName == 0) {
    jm_Class_getName =
         (**(code **)(*param_1 + 0x84))(param_1,jc_Class,"getName","()Ljava/lang/String;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 != 0) || (jm_Class_getName == 0)) {
      pcVar3 = "obj get class name error";
      goto LAB_0001c95e;
    }
  }
  iVar1 = (**(code **)(*param_1 + 0x88))(param_1,param_2,jm_Object_getClass);
  iVar2 = checkJavaException(param_1);
  if ((iVar1 == 0) || (iVar2 != 0)) {
    pcVar3 = "call get class fail!";
  }
  else {
    iVar1 = (**(code **)(*param_1 + 0x88))(param_1,iVar1,jm_Class_getName);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar3 = "call get calss fail!";
    }
    else {
      iVar1 = (**(code **)(*param_1 + 0x2a4))(param_1,iVar1,0);
      iVar2 = checkJavaException(param_1);
      if ((iVar1 != 0) && (iVar2 == 0)) {
        return iVar1;
      }
      pcVar3 = "jstring to char fail!";
    }
  }
LAB_0001c95e:
  log2Console(6,&DAT_00034c70,pcVar3);
  return 0;
}



undefined4 backupJavaClasses(int *param_1)

{
  int iVar1;
  int iVar2;
  char *pcVar3;
  char *pcVar4;
  
  if (jc_Thread == 0) {
    iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"java/lang/Thread");
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar3 = "find cls error %s ";
    }
    else {
      jc_Thread = (**(code **)(*param_1 + 0x54))(param_1,iVar1);
      iVar1 = checkJavaException(param_1);
      if ((iVar1 == 0) && (jc_Thread != 0)) goto LAB_0001ca00;
      pcVar3 = "new cls error %s ";
    }
    pcVar4 = "java/lang/Thread";
    goto LAB_0001cc8e;
  }
LAB_0001ca00:
  if (jc_Throwable == 0) {
    iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"java/lang/Throwable");
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar3 = "find cls error %s ";
    }
    else {
      jc_Throwable = (**(code **)(*param_1 + 0x54))(param_1,iVar1);
      iVar1 = checkJavaException(param_1);
      if ((iVar1 == 0) && (jc_Throwable != 0)) goto LAB_0001ca12;
      pcVar3 = "new cls error %s ";
    }
    pcVar4 = "java/lang/Throwable";
    goto LAB_0001cc8e;
  }
LAB_0001ca12:
  if (jc_StackTraceElement == 0) {
    iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"java/lang/StackTraceElement");
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar3 = "find cls error %s ";
    }
    else {
      jc_StackTraceElement = (**(code **)(*param_1 + 0x54))(param_1,iVar1);
      iVar1 = checkJavaException(param_1);
      if ((iVar1 == 0) && (jc_StackTraceElement != 0)) goto LAB_0001ca24;
      pcVar3 = "new cls error %s ";
    }
    pcVar4 = "java/lang/StackTraceElement";
    goto LAB_0001cc8e;
  }
LAB_0001ca24:
  if (jm_currentThread == 0) {
    jm_currentThread =
         (**(code **)(*param_1 + 0x1c4))(param_1,jc_Thread,"currentThread","()Ljava/lang/Thread;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 != 0) || (jm_currentThread == 0)) {
      pcVar3 = "find method error %s ";
      pcVar4 = "currentThread";
      goto LAB_0001cc8e;
    }
  }
  if (jm_getStackTrace == 0) {
    jm_getStackTrace =
         (**(code **)(*param_1 + 0x84))
                   (param_1,jc_Thread,"getStackTrace","()[Ljava/lang/StackTraceElement;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 == 0) && (jm_getStackTrace != 0)) goto LAB_0001ca8c;
LAB_0001cc22:
    pcVar3 = "find method error %s ";
    pcVar4 = "getStackTrace";
    goto LAB_0001cc8e;
  }
LAB_0001ca8c:
  if (jm_throwable_getStackTrace == 0) {
    jm_throwable_getStackTrace =
         (**(code **)(*param_1 + 0x84))
                   (param_1,jc_Throwable,"getStackTrace","()[Ljava/lang/StackTraceElement;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 != 0) || (jm_throwable_getStackTrace == 0)) goto LAB_0001cc22;
  }
  if (jm_throwable_getMessage == 0) {
    jm_throwable_getMessage =
         (**(code **)(*param_1 + 0x84))(param_1,jc_Throwable,"getMessage","()Ljava/lang/String;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 != 0) || (jm_throwable_getMessage == 0)) {
      pcVar3 = "find method error %s ";
      pcVar4 = "getMessage";
      goto LAB_0001cc8e;
    }
  }
  if (jm_throwable_toString == 0) {
    jm_throwable_toString =
         (**(code **)(*param_1 + 0x84))(param_1,jc_Throwable,"toString","()Ljava/lang/String;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 == 0) && (jm_throwable_toString != 0)) goto LAB_0001cb06;
  }
  else {
LAB_0001cb06:
    if (jm_toString != 0) {
      return 1;
    }
    jm_toString = (**(code **)(*param_1 + 0x84))
                            (param_1,jc_StackTraceElement,"toString","()Ljava/lang/String;");
    iVar1 = checkJavaException(param_1);
    if ((iVar1 == 0) && (jm_toString != 0)) {
      return 1;
    }
  }
  pcVar3 = "find method error %s ";
  pcVar4 = "toString";
LAB_0001cc8e:
  log2Console(6,&DAT_00034c70,pcVar3,pcVar4);
  return 0;
}



undefined4 javaStaticCall_NativeCrashHandler_GetInstance(int *param_1)

{
  undefined4 uVar1;
  int iVar2;
  
  if (((param_1 == (int *)0x0) || (jc_NativeCrashHandler == 0)) || (jm_getInstance == 0)) {
    log2Console(6,&DAT_00034c70,
                "env == NULL or jc_NativeCrashHandler == 0 or jm_getInstance == 0 , return!%p %p %p"
                ,param_1,jc_NativeCrashHandler,jm_getInstance);
    uVar1 = 0;
  }
  else {
    uVar1 = (**(code **)(*param_1 + 0x1c8))(param_1);
    iVar2 = checkJavaException(param_1);
    if (iVar2 != 0) {
      log2Console(6,&DAT_00034c70,"call getInstance fail!");
    }
  }
  return uVar1;
}



undefined4 javaCall_NativeCrashHandler_GetMHandle(int *param_1,int param_2)

{
  undefined4 uVar1;
  int iVar2;
  
  if (((param_1 == (int *)0x0) || (param_2 == 0)) || (jm_getMHandle == 0)) {
    log2Console(6,&DAT_00034c70,
                "env == NULL or nativeCrashHandlerObj == 0 or jm_getMHandle == 0 , return!");
    uVar1 = 0;
  }
  else {
    uVar1 = (**(code **)(*param_1 + 0x88))(param_1);
    iVar2 = checkJavaException(param_1);
    if (iVar2 != 0) {
      log2Console(6,&DAT_00034c70,"call getMHandle fail!");
    }
  }
  return uVar1;
}



undefined4 constructJavaObjectArray(int *param_1,undefined4 param_2,undefined4 param_3)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  char *pcVar4;
  
  iVar1 = (**(code **)(*param_1 + 0x18))(param_1);
  iVar2 = checkJavaException(param_1);
  if ((iVar1 == 0) || (iVar2 != 0)) {
    pcVar4 = "Failed to find class: %s";
  }
  else {
    uVar3 = (**(code **)(*param_1 + 0x2b0))(param_1,param_3,iVar1,0);
    iVar1 = checkJavaException(param_1);
    if (iVar1 == 0) {
      return uVar3;
    }
    pcVar4 = "Failed to new object array of type: %s";
  }
  log2Console(6,&DAT_00034c70,pcVar4,param_2);
  return 0;
}



undefined4 insertToJavaObjectArray(int *param_1)

{
  int iVar1;
  
  (**(code **)(*param_1 + 0x2b8))(param_1);
  iVar1 = checkJavaException(param_1);
  if (iVar1 != 0) {
    log2Console(6,&DAT_00034c70,"Failed to insert element to Java object array.");
    return 0;
  }
  return 1;
}



int constructUploadExtraMessage(undefined4 param_1,int param_2)

{
  int iVar1;
  size_t sVar2;
  int iVar3;
  char *pcVar4;
  
  iVar1 = constructJavaObjectArray(param_1,"java/lang/String",5);
  if (iVar1 == 0) {
    pcVar4 = "Failed to construct extra message.";
  }
  else {
    snprintf(&DAT_0003dcf8,0x80,"ExceptionThreadName=%s",param_2 + 0x420);
    log2Console(4,&DAT_00034c70,"Set name of crash thread: %s",param_2 + 0x420);
    sVar2 = strlen(&DAT_0003dcf8);
    iVar3 = toJavaString(param_1,&DAT_0003dcf8,sVar2);
    if (iVar3 == 0) {
      pcVar4 = "Failed to set thread name: %s";
LAB_0001d0f0:
      log2Console(6,&DAT_00034c70,pcVar4,&DAT_0003dcf8);
      return 0;
    }
    iVar3 = insertToJavaObjectArray(param_1,iVar1,0,iVar3);
    if (iVar3 == 0) {
      pcVar4 = "Failed to insert thread name into extra message.";
    }
    else {
      snprintf(&DAT_0003dcf8,0x80,"ExceptionProcessName=%s",param_2 + 0x220);
      log2Console(4,&DAT_00034c70,"Set name of crash process: %s",param_2 + 0x220);
      sVar2 = strlen(&DAT_0003dcf8);
      iVar3 = toJavaString(param_1,&DAT_0003dcf8,sVar2);
      if (iVar3 == 0) {
        pcVar4 = "Failed to set process name: %s";
        goto LAB_0001d0f0;
      }
      iVar3 = insertToJavaObjectArray(param_1,iVar1,1,iVar3);
      if (iVar3 == 0) {
        pcVar4 = "Failed to insert process name into extra message.";
      }
      else {
        snprintf(&DAT_0003dcf8,0x100,"SysLogPath=%s",sysLogPath);
        log2Console(4,&DAT_00034c70,"Set path of system log: %s",sysLogPath);
        sVar2 = strlen(&DAT_0003dcf8);
        iVar3 = toJavaString(param_1,&DAT_0003dcf8,sVar2);
        if (iVar3 == 0) {
          pcVar4 = "Failed to set path of system log: %s";
          goto LAB_0001d0f0;
        }
        iVar3 = insertToJavaObjectArray(param_1,iVar1,2,iVar3);
        if (iVar3 == 0) {
          pcVar4 = "Failed to insert path of system log into extra message.";
        }
        else {
          snprintf(&DAT_0003dcf8,0x100,"JniLogPath=%s",jniLogPath);
          log2Console(4,&DAT_00034c70,"Set path of JNI log: %s",jniLogPath);
          sVar2 = strlen(&DAT_0003dcf8);
          iVar3 = toJavaString(param_1,&DAT_0003dcf8,sVar2);
          if (iVar3 == 0) {
            pcVar4 = "Failed to set path of JNI log: %s";
            goto LAB_0001d0f0;
          }
          iVar3 = insertToJavaObjectArray(param_1,iVar1,3,iVar3);
          if (iVar3 == 0) {
            pcVar4 = "Failed to insert path of JNI log into extra message.";
          }
          else {
            pcVar4 = "true";
            if (*(char *)(param_2 + 0x24) == '\0') {
              pcVar4 = "false";
            }
            snprintf(&DAT_0003dcf8,0x100,"HasPendingException=%s",pcVar4);
            log2Console(4,&DAT_00034c70,"Set variable: has pending exception? %s",pcVar4);
            sVar2 = strlen(&DAT_0003dcf8);
            iVar3 = toJavaString(param_1,&DAT_0003dcf8,sVar2);
            if (iVar3 == 0) {
              pcVar4 = "Failed to set variable: has pending exception";
            }
            else {
              iVar3 = insertToJavaObjectArray(param_1,iVar1,4,iVar3);
              if (iVar3 != 0) {
                return iVar1;
              }
              pcVar4 = "Failed to insert variable (has pending exception) into extra message.";
            }
          }
        }
      }
    }
  }
  log2Console(6,&DAT_00034c70,pcVar4);
  return 0;
}



int toJavaString(int *param_1,char *param_2,int param_3,undefined4 param_4)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  int iVar5;
  int iVar6;
  char *pcVar7;
  
  if (param_2 == (char *)0x0) {
    return 0;
  }
  if (param_3 < 0) {
    return 0;
  }
  iVar1 = (**(code **)(*param_1 + 0x18))
                    (param_1,"java/lang/String",*(code **)(*param_1 + 0x18),param_4,&stack0xfffffff8
                    );
  iVar2 = checkJavaException(param_1);
  if ((iVar1 == 0) || (iVar2 != 0)) {
    pcVar7 = "Failed to find class: %s";
    param_2 = "java/lang/String";
LAB_0001d26a:
    log2Console(6,&DAT_00034c70,pcVar7,param_2);
  }
  else {
    uVar3 = getJavaMethodID(param_1,"java/lang/String","<init>","([BLjava/lang/String;)V");
    uVar4 = (**(code **)(*param_1 + 0x2c0))(param_1,param_3);
    (**(code **)(*param_1 + 0x340))(param_1,uVar4,0,param_3,param_2);
    iVar2 = checkJavaException(param_1);
    if (iVar2 == 0) {
      iVar2 = (**(code **)(*param_1 + 0x29c))(param_1,"utf-8");
      iVar5 = checkJavaException(param_1);
      if ((iVar2 != 0) && (iVar5 == 0)) {
        iVar5 = (**(code **)(*param_1 + 0x70))(param_1,iVar1,uVar3,uVar4,iVar2);
        iVar6 = checkJavaException(param_1);
        if ((iVar5 != 0) && (iVar6 == 0)) {
          (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
          (**(code **)(*param_1 + 0x5c))(param_1,iVar2);
          (**(code **)(*param_1 + 0x5c))(param_1,uVar4);
          return iVar5;
        }
        pcVar7 = "Failed to new string: %s";
        goto LAB_0001d26a;
      }
      pcVar7 = "Failed to new string: utf-8";
    }
    else {
      pcVar7 = "Failed to set region of byte array.";
    }
    log2Console(6,&DAT_00034c70,pcVar7);
  }
  return 0;
}



undefined4
javaObjectCall_NativeExceptionHandler_handleNativeException
          (int *param_1,int param_2,int param_3,char *param_4)

{
  undefined4 uVar1;
  size_t sVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  int iVar9;
  int iVar10;
  int iVar11;
  undefined4 uVar12;
  char *pcVar13;
  code *pcVar14;
  
  if ((((param_1 == (int *)0x0) || (param_2 == 0)) || (param_3 == 0)) || (param_4 == (char *)0x0)) {
    pcVar13 = "env == NULL || obj == NULL || eupInfo == NULL || nativeRQDVersion == NULL , return!";
  }
  else {
    uVar12 = *(undefined4 *)(param_3 + 4);
    uVar1 = *(undefined4 *)(param_3 + 8);
    sVar2 = strlen((char *)(param_3 + 200));
    iVar3 = toJavaString(param_1,(char *)(param_3 + 200),sVar2);
    if (iVar3 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0xe0));
    iVar4 = toJavaString(param_1,(char *)(param_3 + 0xe0),sVar2);
    if (iVar4 == 0) {
      return 0xffffffff;
    }
    pcVar13 = *(char **)(param_3 + 0x4a0);
    sVar2 = strlen(pcVar13);
    iVar5 = toJavaString(param_1,pcVar13,sVar2);
    if (iVar5 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0x120));
    iVar6 = toJavaString(param_1,(char *)(param_3 + 0x120),sVar2);
    if (iVar6 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0x30));
    iVar7 = toJavaString(param_1,(char *)(param_3 + 0x30),sVar2);
    if (iVar7 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen((char *)(param_3 + 0x48));
    iVar8 = toJavaString(param_1,(char *)(param_3 + 0x48),sVar2);
    if (iVar8 == 0) {
      return 0xffffffff;
    }
    sVar2 = strlen(param_4);
    iVar9 = toJavaString(param_1,param_4,sVar2);
    if (iVar9 == 0) {
      return 0xffffffff;
    }
    iVar10 = constructUploadExtraMessage(param_1,param_3);
    if (iVar10 == 0) {
      pcVar13 = "Failed to constructUploadExtraMessage";
    }
    else {
      if (jm_handleNativeException2 == 0) {
        pcVar14 = *(code **)(*param_1 + 0xf4);
        iVar11 = jm_handleNativeException;
      }
      else {
        log2Console(4,&DAT_00034c70,"Use new interface to handle native exception.");
        pcVar14 = *(code **)(*param_1 + 0xf4);
        iVar11 = jm_handleNativeException2;
      }
      (*pcVar14)(param_1,param_2,iVar11,uVar12,uVar1);
      iVar11 = checkJavaException(param_1);
      if (iVar11 == 0) {
        (**(code **)(*param_1 + 0x5c))(param_1,iVar3);
        iVar3 = checkJavaException(param_1);
        if (iVar3 == 0) {
          (**(code **)(*param_1 + 0x5c))(param_1,iVar4);
          iVar3 = checkJavaException(param_1);
          if (iVar3 == 0) {
            (**(code **)(*param_1 + 0x5c))(param_1,iVar5);
            iVar3 = checkJavaException(param_1);
            if (iVar3 == 0) {
              (**(code **)(*param_1 + 0x5c))(param_1,iVar6);
              iVar3 = checkJavaException(param_1);
              if (iVar3 == 0) {
                (**(code **)(*param_1 + 0x5c))(param_1,iVar7);
                iVar3 = checkJavaException(param_1);
                if (iVar3 == 0) {
                  (**(code **)(*param_1 + 0x5c))(param_1,iVar8);
                  iVar3 = checkJavaException(param_1);
                  if (iVar3 == 0) {
                    (**(code **)(*param_1 + 0x5c))(param_1,iVar9);
                    iVar3 = checkJavaException(param_1);
                    if (iVar3 == 0) {
                      (**(code **)(*param_1 + 0x5c))(param_1,iVar10);
                      iVar3 = checkJavaException(param_1);
                      if (iVar3 == 0) {
                        return 0;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        pcVar13 = "delete fail!";
      }
      else {
        pcVar13 = "call handle fail!";
      }
    }
  }
  log2Console(6,&DAT_00034c70,pcVar13);
  return 0xffffffff;
}



uint GetAndUpdateAnrState(int *param_1,undefined4 param_2)

{
  int iVar1;
  undefined4 uVar2;
  uint unaff_r5;
  
  if (jm_getAndUpdateAnrState != 0) {
    log2Console(4,&DAT_00034c70,"jni call getAndUpdateAnrState");
    unaff_r5 = (**(code **)(*param_1 + 0x94))(param_1,param_2,jm_getAndUpdateAnrState);
    iVar1 = checkJavaException(param_1);
    if (iVar1 == 0) {
      if (unaff_r5 != 0) {
        unaff_r5 = 1;
      }
    }
    else {
      uVar2 = getErrorMsg();
      log2Console(6,&DAT_00034c70,"call getAndUpdateAnrState fail:%s",uVar2);
      unaff_r5 = 0;
    }
  }
  return unaff_r5 & 0xff;
}



int getJavaThreadName(int *param_1,undefined4 param_2)

{
  int iVar1;
  int iVar2;
  int iVar3;
  
  iVar1 = getJavaMethodID(param_1,"java/lang/Thread","getName","()Ljava/lang/String;");
  if (iVar1 != 0) {
    iVar1 = (**(code **)(*param_1 + 0x88))(param_1,param_2,iVar1);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      log2Console(6,&DAT_00034c70,"Failed to call: %s","getName");
    }
    else {
      iVar2 = (**(code **)(*param_1 + 0x2a4))(param_1,iVar1,0);
      iVar3 = checkJavaException(param_1);
      if ((iVar2 != 0) && (iVar3 == 0)) {
        (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
        return iVar2;
      }
      log2Console(6,&DAT_00034c70,"Failed to get chars of Java string.");
    }
  }
  return 0;
}



undefined4 getJavaThreadId(int *param_1,undefined4 param_2)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = getJavaMethodID(param_1,"java/lang/Thread","getId",&DAT_00037d93);
  if (iVar1 != 0) {
    uVar2 = (**(code **)(*param_1 + 0xd0))(param_1,param_2,iVar1);
    iVar1 = checkJavaException(param_1);
    if (iVar1 == 0) {
      return uVar2;
    }
    log2Console(6,&DAT_00034c70,"Failed to call: %s","getId");
  }
  return 0xffffffff;
}



int javaStaticCall_Thread_CurrentThread(int *param_1)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  char *pcVar4;
  
  if (param_1 == (int *)0x0) {
    uVar3 = 6;
    pcVar4 = "env == NULL , return!";
  }
  else {
    iVar1 = (**(code **)(*param_1 + 0x1c8))(param_1,jc_Thread,jm_currentThread);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 != 0) && (iVar2 == 0)) {
      return iVar1;
    }
    uVar3 = 5;
    pcVar4 = "get thread fail!";
  }
  log2Console(uVar3,&DAT_00034c70,pcVar4);
  return 0;
}



undefined4 javaObjectCall_Thread_GetStackTrace(int *param_1,int param_2)

{
  undefined4 uVar1;
  int iVar2;
  char *pcVar3;
  
  if ((param_1 == (int *)0x0) || (param_2 == 0)) {
    uVar1 = 6;
    pcVar3 = "env == NULL || obj == NULL , return!";
  }
  else {
    uVar1 = (**(code **)(*param_1 + 0x88))(param_1,param_2,jm_getStackTrace);
    iVar2 = checkJavaException(param_1);
    if (iVar2 == 0) {
      return uVar1;
    }
    uVar1 = 5;
    pcVar3 = "call getStackTrace fail!";
  }
  log2Console(uVar1,&DAT_00034c70,pcVar3);
  return 0;
}



char * getJavaThreadStackByThreadObject
                 (int *param_1,undefined4 param_2,size_t param_3,undefined4 param_4)

{
  undefined4 uVar1;
  int iVar2;
  size_t sVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  char *pcVar9;
  size_t sVar10;
  size_t sVar11;
  char *pcVar12;
  int iVar13;
  bool bVar14;
  undefined4 uVar15;
  undefined4 *puVar16;
  
  if ((param_1 == (int *)0x0) || ((int)param_3 < 1)) {
    pcVar12 = "env == NULL || maxLen <= 0, return!";
  }
  else {
    uVar15 = param_2;
    sVar3 = param_3;
    uVar1 = getJavaThreadName();
    log2Console(3,&DAT_00034c70,"Begin to get stack of java thread: %s",uVar1,uVar15,sVar3,param_4);
    iVar2 = javaObjectCall_Thread_GetStackTrace(param_1,param_2);
    if (iVar2 == 0) {
      pcVar12 = "Failed to get stacktrace of java thread.";
    }
    else {
      log2Console(3,&DAT_00034c70,"Successfully got stacktrace of java thread.");
      sVar3 = strlen(note);
      iVar4 = (**(code **)(*param_1 + 0x2ac))(param_1,iVar2);
      if (0x13ff < (int)param_3) {
        param_3 = 0x1400;
      }
      iVar5 = checkJavaException(param_1);
      if (iVar5 == 0) {
        puVar16 = &note;
        log2Console(3,&DAT_00034c70,"Stack line: %d",iVar4);
        iVar13 = param_3 + ~sVar3;
        iVar5 = 1;
        pcVar12 = (char *)calloc(1,param_3);
        bVar14 = false;
        do {
          if ((iVar13 < 1) || (iVar4 <= iVar5)) {
            if (bVar14) {
              log2Console(5,&DAT_00034c70,*puVar16);
              pcVar9 = (char *)*puVar16;
              sVar3 = strlen(pcVar9);
              strncat(pcVar12,pcVar9,sVar3);
              return pcVar12;
            }
            return pcVar12;
          }
          iVar6 = (**(code **)(*param_1 + 0x2b4))(param_1,iVar2,iVar5);
          iVar7 = checkJavaException(param_1);
          if ((iVar6 == 0) || (iVar7 != 0)) {
            pcVar9 = "call getarrayitem fail!";
            goto LAB_0001da30;
          }
          iVar7 = (**(code **)(*param_1 + 0x88))(param_1,iVar6,jm_toString);
          iVar8 = checkJavaException(param_1);
          if ((iVar7 == 0) || (iVar8 != 0)) {
            pcVar9 = "call toString fail!";
            goto LAB_0001da30;
          }
          pcVar9 = (char *)(**(code **)(*param_1 + 0x2a4))(param_1,iVar7,0);
          iVar8 = checkJavaException(param_1);
          if ((pcVar9 == (char *)0x0) || (iVar8 != 0)) {
            pcVar9 = "call getStr fail!";
            goto LAB_0001da30;
          }
          sVar10 = strlen(pcVar9);
          sVar3 = sVar10;
          if (iVar13 <= (int)sVar10) {
            sVar3 = iVar13 - 1;
          }
          if (0 < (int)sVar3) {
            strncat(pcVar12,pcVar9,sVar3);
          }
          sVar11 = strlen(pcVar12);
          (pcVar12 + sVar11)[0] = '\n';
          (pcVar12 + sVar11)[1] = '\0';
          (**(code **)(*param_1 + 0x2a8))(param_1,iVar7,pcVar9);
          iVar7 = checkJavaException(param_1);
          if (iVar7 != 0) {
            pcVar9 = "release str fail!";
            goto LAB_0001da30;
          }
          bVar14 = (bool)(bVar14 | iVar13 <= (int)sVar10);
          (**(code **)(*param_1 + 0x5c))(param_1,iVar6);
          iVar13 = iVar13 + ~sVar3;
          iVar6 = checkJavaException(param_1);
          iVar5 = iVar5 + 1;
        } while (iVar6 == 0);
        pcVar9 = "delete loc fail!";
LAB_0001da30:
        log2Console(6,&DAT_00034c70,pcVar9);
        free(pcVar12);
        return (char *)0x0;
      }
      pcVar12 = "Failed to get array length.";
    }
  }
  log2Console(6,&DAT_00034c70,pcVar12);
  return (char *)0x0;
}



undefined4 javaTheadDump(int param_1,int param_2)

{
  int iVar1;
  undefined4 uVar2;
  char *pcVar3;
  
  log2Console(3,&DAT_00034c70,"Begin to dump stack of java current thead.");
  if ((param_1 == 0) || (param_2 < 1)) {
    pcVar3 = "env == NULL || maxLen <= 0, return!";
  }
  else {
    iVar1 = javaStaticCall_Thread_CurrentThread(param_1);
    if (iVar1 != 0) {
      log2Console(3,&DAT_00034c70,"Successfully geted java current thread.");
      uVar2 = getJavaThreadStackByThreadObject(param_1,iVar1,param_2);
      return uVar2;
    }
    pcVar3 = "Failed to get java current thread.";
  }
  log2Console(6,&DAT_00034c70,pcVar3);
  return 0;
}



int getKeySetArrayOfMap(int *param_1,int param_2)

{
  int iVar1;
  int iVar2;
  char *pcVar3;
  
  if (param_1 == (int *)0x0) {
    return 0;
  }
  if (param_2 == 0) {
    return 0;
  }
  iVar1 = getJavaMethodID(param_1,"java/util/Map","keySet","()Ljava/util/Set;");
  if (iVar1 != 0) {
    iVar1 = (**(code **)(*param_1 + 0x88))(param_1,param_2,iVar1);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar3 = "Failed to call keySet method.";
    }
    else {
      iVar2 = getJavaMethodID(param_1,"java/util/Set","toArray","()[Ljava/lang/Object;");
      if (iVar2 == 0) {
        return 0;
      }
      iVar1 = (**(code **)(*param_1 + 0x88))(param_1,iVar1,iVar2);
      iVar2 = checkJavaException(param_1);
      if ((iVar1 != 0) && (iVar2 == 0)) {
        return iVar1;
      }
      pcVar3 = "Failed to call toArray method.";
    }
    log2Console(6,&DAT_00034c70,pcVar3);
  }
  return 0;
}



int getJavaThreadByName(int *param_1,undefined4 param_2,char *param_3)

{
  int iVar1;
  int iVar2;
  size_t __nmemb;
  int iVar3;
  void *__ptr;
  void *__base;
  size_t __nmemb_00;
  size_t sVar4;
  int iVar5;
  undefined4 uVar6;
  char *pcVar7;
  char *pcVar8;
  int iVar9;
  int iVar10;
  int local_58;
  size_t local_3c;
  
  if (param_1 == (int *)0x0) {
    return 0;
  }
  log2Console(4,&DAT_00034c70,"Try to find Java thread by Name: %s",param_3);
  iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"java/lang/Thread");
  iVar2 = checkJavaException(param_1);
  if ((iVar1 == 0) || (iVar2 != 0)) {
    pcVar7 = "Failed to find class: %s";
    pcVar8 = "java/lang/Thread";
  }
  else {
    iVar2 = getJavaStaticMethodID
                      (param_1,"java/lang/Thread","getAllStackTraces","()Ljava/util/Map;");
    if (iVar2 == 0) {
      return 0;
    }
    iVar1 = (**(code **)(*param_1 + 0x1c8))(param_1,iVar1,iVar2);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 != 0) && (iVar2 == 0)) {
      iVar2 = getKeySetArrayOfMap(param_1,iVar1);
      if (iVar2 == 0) {
        pcVar7 = "Failed to get keySet array of map!";
      }
      else {
        __nmemb = (**(code **)(*param_1 + 0x2ac))(param_1,iVar2);
        iVar3 = checkJavaException(param_1);
        if (iVar3 == 0) {
          __ptr = calloc(__nmemb,4);
          __base = calloc(__nmemb,4);
          __nmemb_00 = getSameNameThreadIdArray(param_3,__ptr,__nmemb,1);
          if ((int)__nmemb_00 < 2) {
            local_58 = 0;
          }
          else {
            log2Console(4,&DAT_00034c70,"Found multiple Linux threads (%d) matched the name: %s",
                        __nmemb_00,param_3);
            local_58 = getIndexOfIntArray(param_2,__ptr,__nmemb_00);
            log2Console(4,&DAT_00034c70,"Index of Linux thread ID array: %d",local_58);
          }
          local_3c = 0;
          for (iVar3 = 0; iVar3 < (int)__nmemb; iVar3 = iVar3 + 1) {
            iVar10 = (**(code **)(*param_1 + 0x2b4))(param_1,iVar2,iVar3);
            iVar9 = checkJavaException(param_1);
            if ((iVar10 == 0) || (iVar9 != 0)) {
              log2Console(6,&DAT_00034c70,"Failed to get array element.");
              break;
            }
            pcVar7 = (char *)getJavaThreadName(param_1,iVar10);
            if (pcVar7 == (char *)0x0) {
              log2Console(5,&DAT_00034c70,"Failed to get thread name.");
            }
            else {
              uVar6 = getJavaThreadId(param_1,iVar10);
              pcVar8 = pcVar7;
              log2Console(4,&DAT_00034c70,&DAT_0003812a,uVar6,pcVar7);
              sVar4 = strlen(pcVar7);
              iVar9 = strncmp(pcVar7,param_3,0xf);
              if (sVar4 < 0x10) {
                if (iVar9 == 0) {
                  log2Console(4,&DAT_00034c70,"Found the matched Java thread: %s",pcVar7,pcVar8);
                  goto LAB_0001df06;
                }
              }
              else if (iVar9 == 0) {
                log2Console(4,&DAT_00034c70,"Found a matched Java thread: %s",pcVar7,pcVar8);
                *(undefined4 *)((int)__base + local_3c * 4) = uVar6;
                local_3c = local_3c + 1;
              }
              (**(code **)(*param_1 + 0x5c))(param_1,iVar10);
              iVar9 = checkJavaException(param_1);
              if (iVar9 != 0) {
                log2Console(6,&DAT_00034c70,"Failed to delete local reference.");
                break;
              }
            }
          }
          log2Console(3,&DAT_00034c70,"Length of matched Java thread ID array: %d",local_3c);
          iVar10 = 0;
          if ((0 < (int)local_3c) && (local_3c == __nmemb_00)) {
            if (1 < (int)__nmemb_00) {
              qsort(__base,__nmemb_00,4,intArrayCompare);
            }
            iVar9 = *(int *)((int)__base + local_58 * 4);
            log2Console(3,&DAT_00034c70,"ID of Java thread matched Linux thread (%d): %d",param_2,
                        iVar9);
            iVar3 = 0;
            do {
              if ((int)__nmemb <= iVar3) goto LAB_0001dee8;
              iVar10 = (**(code **)(*param_1 + 0x2b4))(param_1,iVar2,iVar3);
              iVar5 = checkJavaException(param_1);
              if ((iVar10 == 0) || (iVar5 != 0)) {
                pcVar7 = "Failed to get array element.";
                goto LAB_0001dee2;
              }
              iVar5 = getJavaThreadId(param_1,iVar10);
              if (iVar5 == iVar9) {
                uVar6 = getJavaThreadName(param_1,iVar10);
                log2Console(3,&DAT_00034c70,"Java thread matched is: %s",uVar6);
                goto LAB_0001df06;
              }
              (**(code **)(*param_1 + 0x5c))(param_1,iVar10);
              iVar10 = checkJavaException(param_1);
              iVar3 = iVar3 + 1;
            } while (iVar10 == 0);
            pcVar7 = "Failed to delete local reference.";
LAB_0001dee2:
            log2Console(6,&DAT_00034c70,pcVar7);
LAB_0001dee8:
            iVar10 = 0;
          }
LAB_0001df06:
          (**(code **)(*param_1 + 0x5c))(param_1,iVar2);
          iVar2 = checkJavaException(param_1);
          if (iVar2 != 0) {
            log2Console(6,&DAT_00034c70,"Failed to delete local reference: keySetArray");
          }
          (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
          iVar1 = checkJavaException(param_1);
          if (iVar1 != 0) {
            log2Console(6,&DAT_00034c70,"Failed to delete local reference: map");
          }
          free(__base);
          free(__ptr);
          return iVar10;
        }
        pcVar7 = "Failed to get array length.";
      }
      log2Console(6,&DAT_00034c70,pcVar7);
      return 0;
    }
    pcVar7 = "Failed to call: %s";
    pcVar8 = "getAllStackTraces";
  }
  log2Console(6,&DAT_00034c70,pcVar7,pcVar8);
  return 0;
}



int getJavaMainThread(int *param_1)

{
  int iVar1;
  int iVar2;
  int iVar3;
  char *pcVar4;
  char *pcVar5;
  
  if (param_1 == (int *)0x0) {
    return 0;
  }
  log2Console(4,&DAT_00034c70,"Try to get Java main thread.");
  iVar1 = (**(code **)(*param_1 + 0x18))(param_1,"android/os/Looper");
  iVar2 = checkJavaException(param_1);
  if ((iVar1 == 0) || (iVar2 != 0)) {
    pcVar4 = "Failed to find class: %s";
    pcVar5 = "android/os/Looper";
  }
  else {
    iVar2 = getJavaStaticMethodID
                      (param_1,"android/os/Looper","getMainLooper","()Landroid/os/Looper;");
    if (iVar2 == 0) {
      return 0;
    }
    iVar1 = (**(code **)(*param_1 + 0x1c8))(param_1,iVar1,iVar2);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar4 = "Failed to call: %s";
      pcVar5 = "getMainLooper";
    }
    else {
      iVar2 = getJavaMethodID(param_1,"android/os/Looper","getThread","()Ljava/lang/Thread;");
      if (iVar2 == 0) {
        return 0;
      }
      iVar2 = (**(code **)(*param_1 + 0x88))(param_1,iVar1,iVar2);
      iVar3 = checkJavaException(param_1);
      if ((iVar2 != 0) && (iVar3 == 0)) {
        (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
        iVar1 = checkJavaException(param_1);
        if (iVar1 != 0) {
          log2Console(6,&DAT_00034c70,"Failed to delete local reference.");
          return 0;
        }
        return iVar2;
      }
      pcVar4 = "Failed to call: %s";
      pcVar5 = "getThread";
    }
  }
  log2Console(6,&DAT_00034c70,pcVar4,pcVar5);
  return 0;
}



void getJavaThread(undefined4 param_1,undefined4 param_2,char *param_3)

{
  int iVar1;
  
  iVar1 = strcmp(param_3,"main");
  if (iVar1 == 0) {
    getJavaMainThread(param_1);
    return;
  }
  getJavaThreadByName(param_1,param_2,param_3);
  return;
}



undefined4 getJavaThreadStack(int *param_1,int param_2,int param_3,int param_4)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  char *pcVar4;
  
  if ((param_1 == (int *)0x0) || (param_4 < 1)) {
    pcVar4 = "env == NULL || maxLen <= 0, return!";
  }
  else {
    if (param_3 == 0) {
      uVar3 = javaTheadDump(param_1,param_4);
      return uVar3;
    }
    iVar1 = getJavaThread(param_1,*(undefined4 *)(param_2 + 8),param_3);
    if (iVar1 == 0) {
      log2Console(6,&DAT_00034c70,"Failed to get java thread with thread name: %s",param_3);
      return 0;
    }
    iVar2 = getJavaThreadName(param_1,iVar1);
    if (iVar2 != 0) {
      snprintf((char *)(param_2 + 0x420),0x80,"%s",iVar2);
    }
    uVar3 = getJavaThreadStackByThreadObject(param_1,iVar1,param_4);
    (**(code **)(*param_1 + 0x5c))(param_1,iVar1);
    iVar1 = checkJavaException(param_1);
    if (iVar1 == 0) {
      return uVar3;
    }
    pcVar4 = "Failed to delete local reference.";
  }
  log2Console(6,&DAT_00034c70,pcVar4);
  return 0;
}



char * getPendingExceptionStack(int *param_1,int param_2,size_t param_3)

{
  int iVar1;
  int iVar2;
  size_t sVar3;
  int iVar4;
  undefined4 uVar5;
  char *__dest;
  int iVar6;
  int iVar7;
  int iVar8;
  size_t sVar9;
  size_t sVar10;
  char *pcVar11;
  bool bVar12;
  int iVar13;
  
  if ((param_1 == (int *)0x0) || ((int)param_3 < 1)) {
    pcVar11 = "env == NULL || maxLen <= 0, return!";
  }
  else {
    if (param_2 == 0) {
      uVar5 = 3;
      pcVar11 = "Pending exception is NULL.";
      goto LAB_0001e2fe;
    }
    log2Console(3,&DAT_00034c70,"Begin to get stack of pending exception.");
    iVar1 = (**(code **)(*param_1 + 0x88))(param_1,param_2,jm_throwable_getStackTrace);
    iVar2 = checkJavaException(param_1);
    if ((iVar1 == 0) || (iVar2 != 0)) {
      pcVar11 = "Failed to get stacktrace of pending exception.";
    }
    else {
      log2Console(3,&DAT_00034c70,"Successfully got stacktrace of pending exception.");
      sVar3 = strlen(note);
      iVar2 = (**(code **)(*param_1 + 0x2ac))(param_1,iVar1);
      if (0x13ff < (int)param_3) {
        param_3 = 0x1400;
      }
      iVar4 = checkJavaException(param_1);
      if (iVar4 == 0) {
        log2Console(3,&DAT_00034c70,"Stack line: %d",iVar2);
        uVar5 = (**(code **)(*param_1 + 0x88))(param_1,param_2,jm_throwable_toString);
        pcVar11 = (char *)(**(code **)(*param_1 + 0x2a4))(param_1,uVar5,0);
        iVar4 = checkJavaException(param_1);
        if ((pcVar11 != (char *)0x0) && (iVar4 == 0)) {
          iVar13 = param_3 + ~sVar3;
          __dest = (char *)calloc(1,param_3);
          iVar4 = 1;
          pcVar11 = strcat(__dest,pcVar11);
          sVar3 = strlen(pcVar11);
          (__dest + sVar3)[0] = '\n';
          (__dest + sVar3)[1] = '\0';
          bVar12 = false;
          do {
            if ((iVar13 < 1) || (iVar2 <= iVar4)) {
              if (bVar12) {
                log2Console(5,&DAT_00034c70,note);
                pcVar11 = note;
                sVar3 = strlen(note);
                pcVar11 = strncat(__dest,pcVar11,sVar3);
                return pcVar11;
              }
              return __dest;
            }
            iVar6 = (**(code **)(*param_1 + 0x2b4))(param_1,iVar1,iVar4);
            iVar7 = checkJavaException(param_1);
            if ((iVar6 == 0) || (iVar7 != 0)) {
              pcVar11 = "call getarrayitem fail!";
              goto LAB_0001e4d4;
            }
            iVar7 = (**(code **)(*param_1 + 0x88))(param_1,iVar6,jm_toString);
            iVar8 = checkJavaException(param_1);
            if ((iVar7 == 0) || (iVar8 != 0)) {
              pcVar11 = "call toString fail!";
              goto LAB_0001e4d4;
            }
            pcVar11 = (char *)(**(code **)(*param_1 + 0x2a4))(param_1,iVar7,0);
            iVar8 = checkJavaException(param_1);
            if ((pcVar11 == (char *)0x0) || (iVar8 != 0)) {
              pcVar11 = "call getStr fail!";
              goto LAB_0001e4d4;
            }
            sVar9 = strlen(pcVar11);
            sVar3 = sVar9;
            if (iVar13 <= (int)sVar9) {
              sVar3 = iVar13 - 1;
            }
            if (0 < (int)sVar3) {
              strncat(__dest,pcVar11,sVar3);
            }
            sVar10 = strlen(__dest);
            (__dest + sVar10)[0] = '\n';
            (__dest + sVar10)[1] = '\0';
            (**(code **)(*param_1 + 0x2a8))(param_1,iVar7,pcVar11);
            iVar7 = checkJavaException(param_1);
            if (iVar7 != 0) {
              log2Console(6,&DAT_00034c70,"release str fail!");
              goto LAB_0001e4ec;
            }
            bVar12 = (bool)(bVar12 | iVar13 <= (int)sVar9);
            (**(code **)(*param_1 + 0x5c))(param_1,iVar6);
            iVar13 = iVar13 + ~sVar3;
            iVar6 = checkJavaException(param_1);
            iVar4 = iVar4 + 1;
          } while (iVar6 == 0);
          pcVar11 = "delete loc fail!";
LAB_0001e4d4:
          log2Console(6,&DAT_00034c70,pcVar11);
LAB_0001e4ec:
          free(__dest);
          return (char *)0x0;
        }
        pcVar11 = "Failed to get error massage of pending exception.";
      }
      else {
        pcVar11 = "Failed to get array length.";
      }
    }
  }
  uVar5 = 6;
LAB_0001e2fe:
  log2Console(uVar5,&DAT_00034c70,pcVar11);
  return (char *)0x0;
}



char * getBuglyClassPathPrefix(undefined4 param_1)

{
  char cVar1;
  char *pcVar2;
  char *__haystack;
  char *pcVar3;
  char *pcVar4;
  int iVar5;
  uint uVar6;
  
  pcVar2 = (char *)malloc(0x14);
  __aeabi_memcpy(pcVar2,"com/tencent/bugly/",0x13);
  __haystack = (char *)javaTheadDump(param_1,0x1400);
  if (__haystack == (char *)0x0) {
    log2Console(6,&DAT_00034c70,"get stack error, return default prefix");
  }
  else {
    pcVar3 = strstr(__haystack,"com.tencent.bugly.");
    if (pcVar3 == (char *)0x0) {
      log2Console(6,&DAT_00034c70,"current stack have not bugly line,return default prefix");
    }
    else {
      pcVar4 = (char *)malloc(0x80);
      iVar5 = 0;
      for (uVar6 = 0; cVar1 = pcVar3[uVar6], uVar6 < 0x7f; uVar6 = uVar6 + 1) {
        if (cVar1 == '.') {
          pcVar4[uVar6] = '/';
          if (2 < iVar5) goto LAB_0001e618;
          iVar5 = iVar5 + 1;
        }
        else {
          if (cVar1 == '\0') goto LAB_0001e600;
          pcVar4[uVar6] = cVar1;
        }
      }
      if (cVar1 == '\0') {
LAB_0001e600:
        pcVar4 = "bugly line is broken %s ,return default";
      }
      else {
        if (uVar6 != 0x7f) {
LAB_0001e618:
          free(__haystack);
          pcVar4[uVar6 + 1] = '\0';
          iVar5 = strcmp(pcVar4,"com/tencent/bugly/crashreport/");
          if (iVar5 == 0) {
            return pcVar2;
          }
          return pcVar4;
        }
        pcVar4 = "bugly line over 127 ? %s,return default";
      }
      log2Console(6,&DAT_00034c70,pcVar4,pcVar3);
    }
    free(__haystack);
  }
  return pcVar2;
}



void appendNativeLog(int param_1,int param_2,int param_3)

{
  undefined4 uVar1;
  tm *__tp;
  __pid_t _Var2;
  int iVar3;
  time_t local_78b4;
  char acStack_78b0 [30720];
  char acStack_b0 [132];
  int iStack_2c;
  
  iStack_2c = __stack_chk_guard;
  uVar1 = 0;
  if (((param_1 != 0) && (param_2 != 0)) && (param_3 != 0)) {
    if (DAT_0003ddf8 == 0) {
      FUN_0001e8ac();
    }
    __aeabi_memclr8(acStack_78b0,0x7800);
    __aeabi_memclr8(acStack_b0,0x80);
    local_78b4 = time((time_t *)0x0);
    __tp = localtime(&local_78b4);
    strftime(acStack_b0,0x80,"%m-%d %H:%M:%S",__tp);
    _Var2 = getpid();
    uVar1 = gettid();
    iVar3 = snprintf(acStack_78b0,0x7800,"%s %d %d %s %s %s",acStack_b0,_Var2,uVar1,param_1,param_2,
                     param_3);
    if (iVar3 < 0) {
      log2Console(6,&DAT_00034c70,"Failed to construct record of native log.");
      uVar1 = 0;
    }
    else {
      pthread_mutex_lock((pthread_mutex_t *)&DAT_0003ddfc);
      insertCircularQueue(DAT_0003ddf8,acStack_78b0,iVar3);
      insertCircularQueue(DAT_0003ddf8,&DAT_0003855a,3);
      pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003ddfc);
      uVar1 = 1;
    }
  }
  if (__stack_chk_guard != iStack_2c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar1);
  }
  return;
}



undefined4 appendWholeNativeLog(char *param_1)

{
  int iVar1;
  size_t sVar2;
  
  if (param_1 != (char *)0x0) {
    if (DAT_0003ddf8 == 0) {
      FUN_0001e8ac();
    }
    pthread_mutex_lock((pthread_mutex_t *)&DAT_0003ddfc);
    iVar1 = DAT_0003ddf8;
    sVar2 = strlen(param_1);
    insertCircularQueue(iVar1,param_1,sVar2);
    pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003ddfc);
    return 1;
  }
  return 0;
}



undefined4 getNativeLog(int param_1,uint param_2)

{
  undefined4 uVar1;
  int iVar2;
  char *pcVar3;
  uint uVar4;
  
  if (DAT_0003ddf8 == (uint *)0x0) {
    uVar1 = 4;
    pcVar3 = "Native log has not been initiated.";
  }
  else {
    if (param_1 == 0) {
      return 0;
    }
    if (*DAT_0003ddf8 <= param_2) {
      pthread_mutex_lock((pthread_mutex_t *)&DAT_0003ddfc);
      uVar4 = DAT_0003ddf8[2];
      iVar2 = locateCircularQueue(DAT_0003ddf8,&DAT_0003855a,3);
      uVar1 = readCircularQueue(DAT_0003ddf8,param_1,iVar2 + 3,uVar4);
      pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003ddfc);
      log2Console(3,&DAT_00034c70,"Length of native log: %d byte.",uVar1);
      return 1;
    }
    uVar1 = 6;
    pcVar3 = "Buffer is not enough to save whole native log.";
  }
  log2Console(uVar1,&DAT_00034c70,pcVar3);
  return 0;
}



void closeNativeLog(void)

{
  if (DAT_0003ddf8 == 0) {
    return;
  }
  pthread_mutex_lock((pthread_mutex_t *)&DAT_0003ddfc);
  freeCircularQueue(DAT_0003ddf8);
  DAT_0003ddf8 = 0;
  pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003ddfc);
  log2Console(4,&DAT_00034c70,"Native log had closed.");
  return;
}



void FUN_0001e8ac(void)

{
  if (DAT_0003ddf8 == 0) {
    log2Console(4,&DAT_00034c70,"Initiate native log.");
    pthread_mutex_lock((pthread_mutex_t *)&DAT_0003ddfc);
    if (DAT_0003ddf8 == 0) {
      DAT_0003ddf8 = createCircularQueue(0x7800);
      insertCircularQueue(DAT_0003ddf8,&DAT_0003855a,3);
    }
    pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003ddfc);
    log2Console(4,&DAT_00034c70,"Initialization of native log have been completed.");
    return;
  }
  return;
}



void suspendAllThread(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  char *pcVar2;
  char *pcVar3;
  int iVar4;
  DIR *__dirp;
  int iVar5;
  int iVar6;
  int *piVar7;
  long lVar8;
  uint uVar9;
  dirent *pdVar10;
  undefined4 uVar11;
  char *pcVar12;
  char *pcVar13;
  
  iVar1 = __stack_chk_guard;
  pcVar13 = (char *)0x0;
  prctl(4,1,0,0,0,param_3,param_4);
  log2Console(4,&DAT_00034c70,"Trying to suspend all threads...");
  pcVar2 = (char *)getpid();
  pcVar3 = (char *)calloc(1,0x100);
  if ((pcVar3 == (char *)0x0) || (iVar4 = snprintf(pcVar3,0x100,"/proc/%d/task",pcVar2), 0 < iVar4))
  {
    __dirp = opendir(pcVar3);
    if (__dirp != (DIR *)0x0) {
      iVar5 = gettid();
      pcVar2 = "Suspend thread: %d";
      iVar4 = -1;
      while (pdVar10 = readdir(__dirp), pdVar10 != (dirent *)0x0) {
        pcVar3 = pdVar10->d_name + 8;
        iVar6 = strcmp(pcVar3,".");
        if (((iVar6 != 0) && (iVar6 = strcmp(pcVar3,".."), iVar6 != 0)) &&
           (iVar6 = FUN_0001eb18(&stack0xffffffd4,pcVar3), iVar6 != 0)) {
          if (iVar4 != 0) {
            iVar6 = iVar5;
          }
          if (iVar4 != 0 && iVar6 != 0) {
            log2Console(4,&DAT_00034c70,pcVar2,0);
            piVar7 = (int *)__errno();
            *piVar7 = 0;
            lVar8 = ptrace(PTRACE_ATTACH,0,0,0);
            if ((lVar8 == 0) || (*piVar7 == 0)) {
              do {
                uVar9 = waitpid(0,(int *)0x0,0x40000000);
                if (uVar9 < 0x80000000) {
                  pcVar3 = "Successfully suspended thread: %d";
                  goto LAB_0001ea60;
                }
              } while (*piVar7 == 4);
              ptrace(PTRACE_DETACH,0,0,0);
            }
            else {
              pcVar13 = strerror(*piVar7);
              log2Console(4,&DAT_00034c70,"Failed to attach thread \'%d\' by ptrace for %s",0,
                          pcVar13);
            }
            pcVar3 = "Failed to suspend thread: %d";
LAB_0001ea60:
            log2Console(4,&DAT_00034c70,pcVar3,0,pcVar13);
            iVar4 = 0;
          }
        }
      }
      closedir(__dirp);
      uVar11 = 1;
      goto LAB_0001eab8;
    }
    piVar7 = (int *)__errno();
    pcVar13 = strerror(*piVar7);
    pcVar12 = "Failed to open task path \'%s\' for: %s";
    pcVar2 = pcVar3;
  }
  else {
    piVar7 = (int *)__errno();
    pcVar13 = strerror(*piVar7);
    pcVar12 = "Failed to construct task path of pid \'%d\' for: %s";
  }
  log2Console(5,&DAT_00034c70,pcVar12,pcVar2,pcVar13);
  uVar11 = 0;
LAB_0001eab8:
  if (__stack_chk_guard == iVar1) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar11);
}



undefined4 FUN_0001eb18(int *param_1,byte *param_2)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  byte *pbVar4;
  
  uVar3 = (uint)*param_2;
  if (uVar3 != 0) {
    iVar2 = 0;
    pbVar4 = param_2 + 1;
    while( true ) {
      if (uVar3 == 0) {
        *param_1 = iVar2;
        return 1;
      }
      if ((9 < (uVar3 - 0x30 & 0xff)) || (iVar1 = uVar3 + iVar2 * 10 + -0x30, iVar1 < iVar2)) break;
      uVar3 = (uint)*pbVar4;
      iVar2 = iVar1;
      pbVar4 = pbVar4 + 1;
    }
  }
  return 0;
}



undefined * getSignalName(int param_1)

{
  if (param_1 - 1U < 0x1d) {
    return (&PTR_s_SIGHUP_0003c3a8)[param_1 - 1U];
  }
  return &DAT_00038811;
}



char * getSigCode(int param_1,int param_2)

{
  char *pcVar1;
  char *pcVar2;
  char *pcVar3;
  
  if (param_2 < 1) {
    if (param_2 + 4U < 5) {
      return (&PTR_s_SI_ASYNCIO_0003c41c)[param_2 + 4U];
    }
    return "UNKNOWN_USER";
  }
  switch(param_1) {
  case 4:
    if (param_2 - 1U < 8) {
      return (&PTR_s_ILL_ILLOPC_0003c430)[param_2 - 1U];
    }
    return "UNKNOWN_SIGILL";
  case 5:
    pcVar2 = "UNKNOWN_SIGTRAP";
    pcVar1 = "TRAP_TRACE";
    pcVar3 = "TRAP_BRKPT";
    break;
  case 6:
  case 9:
  case 10:
  case 0xc:
  case 0xd:
  case 0xe:
  case 0xf:
  case 0x10:
    return "UNKNOWN_SIGNO";
  case 7:
    if (param_2 - 1U < 3) {
      return (&PTR_s_BUS_ADRALN_0003c470)[param_2 - 1U];
    }
    return "UNKNOWN_SIGBUS";
  case 8:
    if (param_2 - 1U < 8) {
      return (&PTR_s_FPE_INTDIV_0003c450)[param_2 - 1U];
    }
    return "UNKNOWN_SIGFPE";
  case 0xb:
    pcVar2 = "UNKNOWN_SIGSEGV";
    pcVar1 = "SEGV_ACCERR";
    pcVar3 = "SEGV_MAPERR";
    break;
  case 0x11:
    if (param_2 - 1U < 6) {
      return (&PTR_s_CLD_EXITED_0003c47c)[param_2 - 1U];
    }
    return "UNKNOWN_SIGCHLD";
  default:
    if (param_1 != 0x1d) {
      return "UNKNOWN_SIGNO";
    }
    if (param_2 - 1U < 6) {
      return (&PTR_s_POLL_IN_0003c494)[param_2 - 1U];
    }
    return "UNKNOWN_SIGPOLL";
  }
  if (param_2 != 2) {
    pcVar1 = pcVar2;
  }
  if (param_2 == 1) {
    pcVar1 = pcVar3;
  }
  return pcVar1;
}



char * concatString(char *param_1,char *param_2,size_t param_3)

{
  char *__s;
  size_t sVar1;
  char *__dest;
  
  __dest = (char *)0x0;
  if ((param_1 != (char *)0x0) && (param_2 != (char *)0x0)) {
    __dest = (char *)malloc(param_3);
    __s = strncpy(__dest,param_1,param_3);
    sVar1 = strlen(__s);
    strncat(__dest,param_2,~sVar1 + param_3);
  }
  return __dest;
}



char * getErrorMsg(void)

{
  int *piVar1;
  char *pcVar2;
  
  piVar1 = (int *)__errno();
  if (0 < *piVar1) {
    pcVar2 = strerror(*piVar1);
    return pcVar2;
  }
  return "";
}



void resetError(void)

{
  undefined4 *puVar1;
  
  puVar1 = (undefined4 *)__errno();
  *puVar1 = 0;
  return;
}



void printBuglySoArch(int param_1)

{
  if (0 < param_1) {
    log2Report(param_1,0,&DAT_000363cc);
    return;
  }
  return;
}



char * getThreadName(int param_1)

{
  char *__s;
  char *__s_00;
  FILE *__stream;
  size_t sVar1;
  char cVar2;
  bool bVar3;
  
  if (1 < param_1) {
    __s = (char *)calloc(1,0x1000);
    __s_00 = (char *)calloc(1,0x80);
    snprintf(__s,0x1000,"/proc/%d/comm",param_1);
    __stream = fopen(__s,"r");
    if (__stream != (FILE *)0x0) {
      fgets(__s_00,0x80,__stream);
      fclose(__stream);
    }
    free(__s);
    if (__s_00 != (char *)0x0) {
      sVar1 = strlen(__s_00);
      cVar2 = __s_00[sVar1 - 1];
      bVar3 = cVar2 == '\n';
      if (bVar3) {
        cVar2 = '\0';
      }
      if (!bVar3) {
        return __s_00;
      }
      __s_00[sVar1 - 1] = cVar2;
      return __s_00;
    }
  }
  return (char *)0x0;
}



char * getProcessName(int param_1)

{
  char *__s;
  FILE *__stream;
  size_t sVar1;
  char cVar2;
  char *__s_00;
  bool bVar3;
  
  if (param_1 < 2) {
    __s_00 = (char *)0x0;
  }
  else {
    __s = (char *)calloc(1,0x1000);
    __s_00 = (char *)calloc(1,0x200);
    snprintf(__s,0x1000,"/proc/%d/cmdline",param_1);
    __stream = fopen(__s,"r");
    if (__stream != (FILE *)0x0) {
      fgets(__s_00,0x200,__stream);
      fclose(__stream);
    }
    if (__s_00 != (char *)0x0) {
      sVar1 = strlen(__s_00);
      cVar2 = __s_00[sVar1 - 1];
      bVar3 = cVar2 == '\n';
      if (bVar3) {
        cVar2 = '\0';
      }
      if (bVar3) {
        __s_00[sVar1 - 1] = cVar2;
      }
    }
    free(__s);
  }
  return __s_00;
}



size_t property_get(undefined4 param_1,int param_2,char *param_3)

{
  size_t sVar1;
  
  sVar1 = __system_property_get();
  if ((param_3 != (char *)0x0) && ((int)sVar1 < 1)) {
    sVar1 = strlen(param_3);
    if (0x5a < (int)sVar1) {
      sVar1 = 0x5b;
    }
    __aeabi_memcpy(param_2,param_3,sVar1);
    *(undefined1 *)(param_2 + sVar1) = 0;
  }
  return sVar1;
}



void getAndroidApiLevel(void)

{
  int iVar1;
  ulong uVar2;
  char acStack_24 [16];
  int local_14;
  
  local_14 = __stack_chk_guard;
  iVar1 = __system_property_get("ro.build.version.sdk",acStack_24);
  if (iVar1 < 1) {
    log2Console(5,&DAT_00034c70,"Failed to get API level (will set to %s).",&DAT_00038aa3);
    uVar2 = 0x15;
  }
  else {
    uVar2 = strtoul(acStack_24,(char **)0x0,10);
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar2);
  }
  return;
}



void recordTombStoneFileHeader(undefined4 param_1,int param_2)

{
  tm tStack_150;
  time_t local_124;
  char acStack_120 [64];
  undefined1 auStack_e0 [92];
  undefined1 auStack_84 [92];
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(4,&DAT_00034c70,"create tombstone file: %s ",param_2 + 0x120);
  log2Console(4,&DAT_00034c70,"Record crash banner.");
  property_get("ro.build.fingerprint",auStack_84,"unknown");
  property_get("ro.revision",auStack_e0,"unknown");
  local_124 = time((time_t *)0x0);
  localtime_r(&local_124,&tStack_150);
  strftime(acStack_120,0x40,"%F %T",&tStack_150);
  log2Report(param_1,0,"--- --- --- --- --- --- --- Bugly NDK %s --- --- --- --- --- --- --- \n",
             "4.1.9");
  log2Report(param_1,0,"Build fingerprint: %s\n",auStack_84);
  log2Report(param_1,0,"Revision: %s\n",auStack_e0);
  log2Report(param_1,0,"ABI: %s\n",&DAT_00038b72);
  log2Report(param_1,0,"time: %s\n",acStack_120);
  log2Report(param_1,0,"pid: %d, tid: %d, name: %s  >>> %s <<<\n",*(undefined4 *)(param_2 + 4),
             *(undefined4 *)(param_2 + 8),param_2 + 0x420,param_2 + 0x220);
  if (*(int *)(param_2 + 0xc) != 0) {
    log2Report(param_1,0,"signal: %d (%s), code: %d (%s) fault addr: %s\n",*(int *)(param_2 + 0xc),
               param_2 + 200,*(undefined4 *)(param_2 + 0x14),param_2 + 0x30,param_2 + 0xe0);
    log2Report(param_1,0,"si_errno:%d, si_errnoMsg:%s, sending pid:%d, sending uid:%d",
               *(undefined4 *)(param_2 + 0x10),param_2 + 0x48,*(undefined4 *)(param_2 + 0x18),
               *(undefined4 *)(param_2 + 0x1c));
  }
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



undefined4 recordSystemLog(char *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  int *piVar2;
  char *pcVar3;
  undefined4 uVar4;
  
  if (param_1 == (char *)0x0) {
    uVar4 = 0xffffffff;
  }
  else {
    iVar1 = open(param_1,0x241,0x180);
    if (-1 < iVar1) {
      uVar4 = recordSystemLogWithFd(iVar1,param_2,param_3,param_4);
      return uVar4;
    }
    piVar2 = (int *)__errno();
    pcVar3 = strerror(*piVar2);
    log2Console(6,&DAT_00034c70,"Failed to open system log file %s:, error: %s",param_1,pcVar3);
    uVar4 = 0xfffffffe;
  }
  return uVar4;
}



void recordSystemLogWithFd(int param_1,int param_2)

{
  __pid_t __pid;
  int iVar1;
  int *piVar2;
  undefined4 uVar3;
  undefined *puVar4;
  undefined *puVar5;
  char *pcVar6;
  uint uVar7;
  char *pcVar8;
  char *pcVar9;
  uint local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if (param_1 < 0) {
    piVar2 = (int *)__errno();
    pcVar6 = strerror(*piVar2);
    log2Console(6,&DAT_00034c70,"System log file descriptor is invalid: %d, error: %s",param_1,
                pcVar6);
    uVar3 = 0xffffffff;
  }
  else {
    log2Console(3,&DAT_00034c70,"Start to record system log by executing \'logcat\'.");
    __pid = fork();
    if (__pid < 0) {
      piVar2 = (int *)__errno();
      pcVar6 = strerror(*piVar2);
      log2Console(6,&DAT_00034c70,"Failed to fork process, error: %s",pcVar6);
      uVar3 = 0xfffffffe;
    }
    else {
      if (__pid == 0) {
        dup2(param_1,1);
        if (param_2 == 0) {
          puVar4 = &DAT_00038d2b;
          pcVar8 = "-v";
          pcVar9 = "threadtime";
          pcVar6 = "Bugly-libunwind:S";
          puVar5 = &DAT_00038d2e;
        }
        else {
          iVar1 = getAndroidApiLevel();
          pcVar6 = "dalvikvm art zygote zygote64 OpenGLRenderer";
          if (0x1b < iVar1) {
            pcVar6 = (char *)0x0;
          }
          log2Console(3,&DAT_00034c70,"Tag to filter logcat is set to: %s",pcVar6);
          if (iVar1 < 0x1c) {
            puVar4 = &DAT_00038d05;
            pcVar8 = "threadtime";
            pcVar9 = "-s";
            puVar5 = &DAT_00038d08;
          }
          else {
            puVar4 = &DAT_00038d05;
            puVar5 = &DAT_00038d08;
            pcVar8 = "threadtime";
            pcVar9 = "Bugly-libunwind:S";
            pcVar6 = (char *)0x0;
          }
        }
        execl("/system/bin/logcat","logcat",puVar4,puVar5,pcVar8,pcVar9,pcVar6);
        piVar2 = (int *)__errno();
        pcVar6 = strerror(*piVar2);
        log2Console(6,&DAT_00034c70,"Failed to execute \'logcat\', error: %s",pcVar6);
      }
      else {
        log2Console(3,&DAT_00034c70,"Pid of subprocess: %d",__pid);
        log2Console(4,&DAT_00034c70,"Wait for the subprocess to dump logcat...");
        uVar7 = 0xffffffff;
        local_20 = 0xffffffff;
        do {
          uVar7 = uVar7 + 1;
          if (0x7c < uVar7 >> 2) goto LAB_0001f12a;
          usleep(10000);
          waitpid(__pid,(int *)&local_20,1);
        } while ((local_20 & 0x7f) != 0);
        log2Console(4,&DAT_00034c70,"Successfully dump log by executing \'logcat\'.");
LAB_0001f12a:
        log2Console(4,&DAT_00034c70,"Finished recorded system log.");
      }
      uVar3 = 0;
    }
  }
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar3);
  }
  return;
}



int intArrayCompare(int *param_1,int *param_2)

{
  return *param_1 - *param_2;
}



void getSameNameThreadIdArray(char *param_1,void *param_2,int param_3,int param_4)

{
  int iVar1;
  char *pcVar2;
  char *__s;
  int iVar3;
  DIR *__dirp;
  dirent *pdVar4;
  int *piVar5;
  char *pcVar6;
  char *pcVar7;
  byte bVar8;
  size_t __nmemb;
  int *piVar9;
  
  iVar1 = __stack_chk_guard;
  piVar9 = &__stack_chk_guard;
  if ((param_1 != (char *)0x0 && param_2 != (void *)0x0) && (0 < param_3)) {
    log2Console(4,&DAT_00034c70,"Get ID array of thread whose name is same with: %s",param_1,param_2
                ,param_3,param_4);
    pcVar2 = (char *)getpid();
    __s = (char *)calloc(1,0x100);
    if ((__s == (char *)0x0) || (iVar3 = snprintf(__s,0x100,"/proc/%d/task",pcVar2), 0 < iVar3)) {
      __dirp = opendir(__s);
      if (__dirp != (DIR *)0x0) {
        __nmemb = 0;
        while (pdVar4 = readdir(__dirp), pdVar4 != (dirent *)0x0) {
          pcVar2 = pdVar4->d_name + 8;
          iVar3 = strcmp(pcVar2,".");
          if (((iVar3 != 0) && (iVar3 = strcmp(pcVar2,".."), iVar3 != 0)) &&
             (iVar3 = FUN_0001eb18(&stack0xffffffd4,pcVar2), iVar3 != 0)) {
            pcVar2 = (char *)getThreadName(0);
            iVar3 = strncmp(param_1,pcVar2,0xf);
            if (iVar3 == 0) {
              bVar8 = 0;
              for (iVar3 = 0; iVar3 < (int)__nmemb; iVar3 = iVar3 + 1) {
                bVar8 = bVar8 | *(int *)((int)param_2 + iVar3 * 4) == 0;
              }
              log2Console(3,&DAT_00034c70,"Found a thread with same name and its ID is: %d",0);
              if (((int)__nmemb < param_3) && ((bool)(bVar8 ^ 1))) {
                *(undefined4 *)((int)param_2 + __nmemb * 4) = 0;
                __nmemb = __nmemb + 1;
              }
            }
          }
        }
        if ((1 < (int)__nmemb) && (param_4 != 0)) {
          qsort(param_2,__nmemb,4,intArrayCompare);
        }
        closedir(__dirp);
        goto LAB_0001f322;
      }
      piVar5 = (int *)__errno();
      pcVar6 = strerror(*piVar5);
      pcVar7 = "Failed to open task path \'%s\' for: %s";
      pcVar2 = __s;
    }
    else {
      piVar5 = (int *)__errno();
      pcVar6 = strerror(*piVar5);
      pcVar7 = "Failed to construct task path of pid \'%d\' for: %s";
    }
    log2Console(5,&DAT_00034c70,pcVar7,pcVar2,pcVar6);
  }
LAB_0001f322:
  if (*piVar9 - iVar1 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(*piVar9 - iVar1);
  }
  return;
}



int getIndexOfIntArray(int param_1,int param_2,int param_3)

{
  int iVar1;
  
  iVar1 = 0;
  while( true ) {
    if (param_3 <= iVar1) {
      return -1;
    }
    if (*(int *)(param_2 + iVar1 * 4) == param_1) break;
    iVar1 = iVar1 + 1;
  }
  return iVar1;
}



bool parseBoolString(char *param_1)

{
  int iVar1;
  
  iVar1 = strncmp(param_1,"true",4);
  if ((iVar1 != 0) && (iVar1 = strncmp(param_1,"True",4), iVar1 != 0)) {
    iVar1 = strncmp(param_1,"TRUE",4);
    return iVar1 == 0;
  }
  return true;
}



void print_dlerror(void)

{
  int iVar1;
  
  iVar1 = dlerror();
  if (iVar1 == 0) {
    return;
  }
  log2Console(5,&DAT_00034c70,"Dynamic linking error: %s",iVar1);
  return;
}



int open_library(int param_1)

{
  int iVar1;
  
  if (param_1 != 0) {
    log2Console(4,&DAT_00034c70,"Try to open library: %s",param_1);
    iVar1 = dlopen(param_1,1);
    if (iVar1 != 0) {
      log2Console(4,&DAT_00034c70,"Library \'%s\' is opened.",param_1);
      return iVar1;
    }
    log2Console(5,&DAT_00034c70,"Can not open library: %s",param_1);
    print_dlerror();
  }
  return 0;
}



int get_opened_libraray_function(int param_1,int param_2)

{
  int iVar1;
  
  iVar1 = 0;
  if ((param_1 != 0) && (param_2 != 0)) {
    log2Console(4,&DAT_00034c70,"Try to find function: \'%s\'",param_2);
    iVar1 = dlsym(param_1,param_2);
    if (iVar1 == 0) {
      log2Console(5,&DAT_00034c70,"Can not locate function: \'%s\'",param_2);
      print_dlerror();
      iVar1 = 0;
    }
    else {
      log2Console(4,&DAT_00034c70,"Address of function \'%s\': %p",param_2,iVar1);
    }
  }
  return iVar1;
}



undefined4 get_libraray_function(int param_1,int param_2)

{
  undefined4 uVar1;
  
  if ((param_1 != 0) && (param_2 != 0)) {
    uVar1 = open_library();
    uVar1 = get_opened_libraray_function(uVar1,param_2);
    return uVar1;
  }
  return 0;
}



undefined4 unlockFile(char *param_1)

{
  int iVar1;
  int *piVar2;
  char *pcVar3;
  
  if (param_1 != (char *)0x0) {
    log2Console(4,&DAT_00034c70,"Try to unlock file: %s",param_1);
    iVar1 = access(param_1,0);
    if ((iVar1 != 0) || (iVar1 = unlink(param_1), -1 < iVar1)) {
      log2Console(4,&DAT_00034c70,"Successfully unlock file: %s",param_1);
      return 1;
    }
    piVar2 = (int *)__errno();
    pcVar3 = strerror(*piVar2);
    log2Console(5,&DAT_00034c70,"Failed to remove lock file for: %s.",pcVar3);
  }
  return 0;
}



void lockFile(char *param_1,int param_2)

{
  int iVar1;
  time_t tVar2;
  undefined4 uVar3;
  int *piVar4;
  char *pcVar5;
  char *pcVar6;
  int local_8c;
  stat sStack_88;
  int local_30;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if ((param_1 == (char *)0x0) || (param_2 < 1)) goto LAB_0001f7ca;
  log2Console(4,&DAT_00034c70,"Try to lock file: %s",param_1);
  iVar1 = access(param_1,0);
  if (iVar1 == 0) {
    iVar1 = stat(param_1,&sStack_88);
    if (iVar1 < 0) {
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to read size of file for: %s.";
    }
    else {
      tVar2 = time(&local_8c);
      if (-1 < tVar2) {
        if (param_2 < local_8c - local_30) {
          log2Console(4,&DAT_00034c70,"Lock file is expired, unlock it.");
          iVar1 = unlockFile(param_1);
          if (iVar1 != 0) goto LAB_0001f700;
          uVar3 = 5;
          pcVar5 = "Failed to unlock expired lock file.";
        }
        else {
          uVar3 = 4;
          pcVar5 = "Some one holds the lock file.";
        }
        log2Console(uVar3,&DAT_00034c70,pcVar5);
        goto LAB_0001f7ca;
      }
      piVar4 = (int *)__errno();
      pcVar5 = strerror(*piVar4);
      pcVar6 = "Failed to get current time for: %s.";
    }
  }
  else {
LAB_0001f700:
    iVar1 = open(param_1,0x241,0x180);
    if (-1 < iVar1) {
      write(iVar1,&DAT_00038a44,1);
      close(iVar1);
      log2Console(4,&DAT_00034c70,"Successfully locked file: %s",param_1);
      goto LAB_0001f7ca;
    }
    piVar4 = (int *)__errno();
    pcVar5 = strerror(*piVar4);
    pcVar6 = "Failed to create lock file for: %s.";
  }
  log2Console(5,&DAT_00034c70,pcVar6,pcVar5);
LAB_0001f7ca:
  if (__stack_chk_guard - local_1c == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_1c);
}



byte * trim(byte *param_1)

{
  size_t sVar1;
  int iVar2;
  byte *pbVar3;
  byte *pbVar4;
  
  if (param_1 == (byte *)0x0) {
    pbVar3 = (byte *)0x0;
  }
  else {
    sVar1 = strlen((char *)param_1);
    pbVar3 = param_1;
    if (sVar1 != 0) {
      pbVar3 = param_1 + sVar1;
      while ((param_1 < pbVar3 && (iVar2 = isspace((uint)*param_1), iVar2 != 0))) {
        sVar1 = sVar1 - 1;
        param_1 = param_1 + 1;
      }
      if (sVar1 != 0) {
        do {
          pbVar4 = pbVar3;
          if (pbVar4 <= param_1) break;
          iVar2 = isspace((uint)pbVar4[-1]);
          pbVar3 = pbVar4 + -1;
        } while (iVar2 != 0);
        *pbVar4 = 0;
        pbVar3 = param_1;
      }
    }
  }
  return pbVar3;
}



void UnblockSigquit(int param_1)

{
  ulong local_18;
  ulong local_14;
  
  local_14 = __stack_chk_guard;
  local_18 = 4;
  pthread_sigmask((uint)(param_1 != 0),(__sigset_t *)&local_18,(__sigset_t *)0x0);
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void SendSigquitToSignalCatcher(void)

{
  undefined4 *puVar1;
  int iVar2;
  __pid_t _Var3;
  long __errnum;
  char *pcVar4;
  
  DataMemoryBarrier(0x1b);
  if ((DAT_0003de00 & 1) != 0) {
    log2Console(3,&DAT_00034c70,"Start to search signal catcher");
    puVar1 = (undefined4 *)malloc(4);
    iVar2 = getSameNameThreadIdArray("Signal Catcher",puVar1,1,0);
    if (iVar2 == 1) {
      log2Console(3,&DAT_00034c70,"resend sigquit to signal-catcher start,tid :%d",*puVar1);
      _Var3 = getpid();
      __errnum = syscall(0x10c,_Var3,*puVar1,3);
      pcVar4 = strerror(__errnum);
      log2Console(3,&DAT_00034c70,"resend sigquit to signal-catcher end result:%d %s",__errnum,
                  pcVar4);
    }
    DataMemoryBarrier(0x1b);
    DAT_0003de00 = 0;
    DataMemoryBarrier(0x1b);
    return;
  }
  log2Console(3,&DAT_00034c70,"not handing sigquit, just return");
  return;
}



void HandleAnr(int param_1,undefined4 param_2,pthread_t param_3)

{
  int iVar1;
  int *__arg;
  char *pcVar2;
  pthread_t pStack_18;
  int local_14;
  
  local_14 = __stack_chk_guard;
  pStack_18 = param_3;
  log2Console(4,&DAT_00034c70,"handle anr, type:%d",param_1);
  if (param_1 == 1) {
    DataMemoryBarrier(0x1b);
    DAT_0003de00 = 1;
    DataMemoryBarrier(0x1b);
  }
  if (jvm == 0) {
    pcVar2 = "JVM have not been backed up, should init JNI regist first!";
  }
  else {
    iVar1 = getAndroidApiLevel();
    if (0x14 < iVar1) {
      __arg = (int *)malloc(4);
      *__arg = param_1;
      iVar1 = pthread_create(&pStack_18,(pthread_attr_t *)0x0,(__start_routine *)0x1fa69,__arg);
      if (iVar1 != 0) {
        pcVar2 = strerror(iVar1);
        log2Console(6,&DAT_00034c70,"Can not create DumpTraceThread: %s\n",pcVar2);
        SendSigquitToSignalCatcher();
      }
      if (__stack_chk_guard == local_14) {
        return;
      }
                    // WARNING: Subroutine does not return
      __stack_chk_fail();
    }
    pcVar2 = "do not dump trace below android 5.0";
  }
  log2Console(6,&DAT_00034c70,pcVar2);
  if (__stack_chk_guard == local_14) {
    SendSigquitToSignalCatcher();
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Type propagation algorithm not settling

void FUN_0001fa68(undefined4 *param_1)

{
  pthread_t __th;
  int iVar1;
  int iVar2;
  char *pcVar3;
  uint uVar4;
  int *piVar5;
  char *pcVar6;
  int __fd;
  undefined1 *puVar7;
  int iVar8;
  undefined4 uVar9;
  timeval local_54;
  timeval local_4c;
  int local_44 [2];
  char *pcStack_3c;
  undefined4 uStack_38;
  int local_30;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,&DAT_00034c70,"anr_dump_trace");
  __th = pthread_self();
  pthread_detach(__th);
  log2Console(3,&DAT_00034c70,"anr_dump_trace dump anr trace type anr_dump_args->type is %d",
              *param_1);
  local_44[1] = 0x10006;
  pcStack_3c = "bugly_trace";
  uStack_38 = 0;
  local_44[0] = 0;
  log2Console(3,&DAT_00034c70,"anr_dump_trace Attach thread to JVM.");
  iVar1 = (**(code **)(*jvm + 0x10))(jvm,local_44,local_44 + 1);
  iVar2 = local_44[0];
  if ((iVar1 == 0) && (local_44[0] != 0)) {
    log2Console(3,&DAT_00034c70,"call IsAnr.");
    iVar1 = javaStaticCall_NativeCrashHandler_GetInstance(iVar2);
    if (iVar1 == 0) {
      pcVar3 = "Failed to get crash handler.";
LAB_0001fc30:
      log2Console(6,&DAT_00034c70,pcVar3);
LAB_0001fc36:
      uVar9 = 4;
      pcVar3 = "proc is not in anr.";
      goto LAB_0001fc40;
    }
    log2Console(3,&DAT_00034c70,"Successfully got crash handler.");
    iVar1 = javaCall_NativeCrashHandler_GetMHandle(iVar2,iVar1);
    if (iVar1 == 0) {
      pcVar3 = "Failed to get exception handler.";
      goto LAB_0001fc30;
    }
    log2Console(3,&DAT_00034c70,"Successfully got exception handler.");
    iVar2 = GetAndUpdateAnrState(iVar2,iVar1);
    if (iVar2 == 0) goto LAB_0001fc36;
    iVar2 = gettimeofday(&local_4c,(__timezone_ptr_t)0x0);
    if (iVar2 < 0) {
      piVar5 = (int *)__errno();
      pcVar3 = strerror(*piVar5);
      pcVar6 = "Failed to get start time: %s";
    }
    else {
      pcVar3 = (char *)calloc(1,0x100);
      iVar2 = __aeabi_idiv(local_4c.tv_usec,1000);
      uVar4 = snprintf(pcVar3,0x100,"%s/%s_%lu%03lu%s",recordFileDir,"manual_bugly_trace",
                       local_4c.tv_sec,iVar2,&DAT_0003929f);
      if (0x7fffffff < uVar4) {
        piVar5 = (int *)__errno();
        pcVar6 = strerror(*piVar5);
        log2Console(6,&DAT_00034c70,"Failed to set sigquit anr trace path: %s",pcVar6);
      }
      iVar1 = dup(2);
      __fd = open(pcVar3,0x241,0x180);
      if (__fd != -1) {
        log2Console(4,&DAT_00034c70,"Create a trace file %s for anr.",pcVar3);
        log2Report(__fd,1,"anr time : %lu%03lu ms\n",local_4c.tv_sec,local_4c.tv_usec);
        if ((int)((uint)(byte)JAR_JNI_VERSION << 0x1e) < 0) {
          iVar8 = dup2(__fd,2);
          if (iVar8 < 0) {
            piVar5 = (int *)__errno();
            pcVar6 = strerror(*piVar5);
            log2Console(6,&DAT_00034c70,"Failed to dup2 stderr: %s",pcVar6);
            goto LAB_0001fd3a;
          }
          local_30 = 0;
          local_2c = 0;
          iVar8 = getAndroidApiLevel();
          if (((0x1c < iVar8) &&
              (local_2c = dynamic_load_create("/apex/com.android.runtime/lib/libc++.so"),
              local_2c != 0)) ||
             (local_2c = dynamic_load_create("/system/lib/libc++.so"), local_2c != 0)) {
            DAT_0003de10 = dynamic_load_sym(local_2c,"_ZNSt3__14cerrE");
            if (DAT_0003de10 != 0) {
              log2Console(4,&DAT_00034c70,"libcpp_cerr=%p");
              if (iVar8 < 0x1e) {
                if (iVar8 == 0x1d) {
                  pcVar6 = "/apex/com.android.runtime/lib/libart.so";
                  goto LAB_0001fd46;
                }
LAB_0001fd52:
                iVar8 = dynamic_load_create("/system/lib/libart.so");
                local_30 = iVar8;
                if (iVar8 == 0) goto LAB_0001fd8c;
              }
              else {
                pcVar6 = "/apex/com.android.art/lib/libart.so";
LAB_0001fd46:
                iVar8 = dynamic_load_create(pcVar6);
                local_30 = iVar8;
                if (iVar8 == 0) goto LAB_0001fd52;
              }
              local_30 = iVar8;
              DAT_0003de0c = (undefined4 *)dynamic_load_sym(iVar8,"_ZN3art7Runtime9instance_E");
              if (DAT_0003de0c != (undefined4 *)0x0) {
                DAT_0003de08 = (code *)dynamic_load_sym(iVar8,
                                                  "_ZN3art7Runtime14DumpForSigQuitERNSt3__113basic_ostreamIcNS1_11char_traitsIcEEEE"
                                                  );
                if (DAT_0003de08 != (code *)0x0) {
                  DAT_0003de04 = '\x01';
                }
              }
            }
LAB_0001fd8c:
            dynamic_load_destroy(&local_2c);
            if (local_30 != 0) {
              dynamic_load_destroy(&local_30);
            }
          }
          if (DAT_0003de04 == '\0') {
            uVar9 = 1;
LAB_0001fdd8:
            log2Report(__fd,uVar9,"anr trace dump failed\n");
          }
          else {
            puVar7 = (undefined1 *)__emutls_get_address(__emutls_v_isDumpingTrace);
            *puVar7 = 1;
            uVar9 = __emutls_get_address(__emutls_v_jmpBuf);
            iVar8 = sigsetjmp(uVar9,1);
            if (iVar8 != 0) {
              uVar9 = 0;
              goto LAB_0001fdd8;
            }
            (*DAT_0003de08)(*DAT_0003de0c,DAT_0003de10);
            iVar8 = gettimeofday(&local_54,(__timezone_ptr_t)0x0);
            if (iVar8 < 0) {
              piVar5 = (int *)__errno();
              pcVar6 = strerror(*piVar5);
              log2Console(5,&DAT_00034c70,"Failed to get end time: %s",pcVar6);
            }
            else {
              iVar8 = __aeabi_idiv(local_54.tv_usec,1000);
              log2Report(__fd,0,"\ndump trace costs %ld ms\n",
                         (local_54.tv_sec - local_4c.tv_sec) * 1000 + (iVar8 - iVar2));
            }
          }
          log2Console(3,&DAT_00034c70,"dump trace end");
          uVar4 = dup2(iVar1,2);
          if (0x7fffffff < uVar4) {
            piVar5 = (int *)__errno();
            pcVar6 = strerror(*piVar5);
            log2Console(5,&DAT_00034c70,"Failed to restore stderr: %s",pcVar6);
          }
        }
        else {
          log2Report(__fd,1,"android trace not enable\n");
LAB_0001fd3a:
          log2Console(3,&DAT_00034c70,"dump trace end");
        }
        free(pcVar3);
        close(__fd);
        goto LAB_0001fc48;
      }
      pcVar6 = "Failed to open trace file %s";
    }
    log2Console(6,&DAT_00034c70,pcVar6,pcVar3);
  }
  else {
    uVar9 = 6;
    pcVar3 = "anr_dump_trace Failed to attach thread to JVM.";
LAB_0001fc40:
    log2Console(uVar9,&DAT_00034c70,pcVar3);
  }
  SendSigquitToSignalCatcher();
LAB_0001fc48:
  log2Console(3,&DAT_00034c70,"dump trace exit");
  puVar7 = (undefined1 *)__emutls_get_address(__emutls_v_isDumpingTrace);
  piVar5 = jvm;
  *puVar7 = 0;
  (**(code **)(*piVar5 + 0x14))(piVar5);
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void dynamic_load_create(char *param_1)

{
  void *pvVar1;
  void *pvVar2;
  FILE *__stream;
  char *pcVar3;
  int iVar4;
  void *pvVar5;
  int *piVar6;
  int iVar7;
  uint uVar8;
  int iVar9;
  undefined4 *puVar10;
  int iVar11;
  int iVar12;
  uint uVar13;
  uint uVar14;
  void *local_234;
  int local_230;
  int iStack_22c;
  stat asStack_228 [5];
  int local_28;
  
  local_28 = __stack_chk_guard;
  pvVar2 = calloc(1,0x1c);
  local_234 = pvVar2;
  if (pvVar2 == (void *)0x0) {
    pvVar2 = (void *)0x0;
  }
  else {
    iVar11 = -1;
    *(undefined4 *)((int)pvVar2 + 4) = 0xffffffff;
    *(undefined4 *)((int)pvVar2 + 8) = 0xffffffff;
    *(int *)((int)pvVar2 + 0x18) = (int)pvVar2 + 0x14;
    __stream = fopen("/proc/self/maps","r");
    if (__stream != (FILE *)0x0) {
      do {
        do {
          pcVar3 = fgets((char *)asStack_228,0x200,__stream);
          if (pcVar3 == (char *)0x0) {
            iVar11 = -1;
            goto LAB_00020024;
          }
          iVar4 = sscanf((char *)asStack_228,"%x-%*x %*4s %x %*x:%*x %*d%n",pvVar2,&iStack_22c,
                         &local_230);
          iVar11 = iVar4;
          if (iVar4 == 2) {
            iVar11 = iStack_22c;
          }
        } while (iVar4 != 2 || iVar11 != 0);
        pcVar3 = (char *)trim((char *)((int)&asStack_228[0].st_dev + local_230));
        iVar11 = strcmp(pcVar3,param_1);
      } while (iVar11 != 0);
      iVar11 = 0;
LAB_00020024:
      fclose(__stream);
    }
    pvVar2 = local_234;
    if (iVar11 == 0) {
      iVar11 = open(param_1,0x80000);
      *(int *)((int)pvVar2 + 4) = iVar11;
      if (((-1 < iVar11) && (iVar11 = fstat(iVar11,asStack_228), iVar11 == 0)) &&
         (asStack_228[0].st_blocks != 0 || asStack_228[0].st_blksize != 0)) {
        *(__blksize_t *)((int)pvVar2 + 0xc) = asStack_228[0].st_blksize;
        pvVar5 = mmap((void *)0x0,asStack_228[0].st_blksize,1,2,*(int *)((int)pvVar2 + 4),0);
        pvVar1 = local_234;
        *(void **)((int)pvVar2 + 8) = pvVar5;
        if (((pvVar5 != (void *)0xffffffff) &&
            (uVar13 = *(uint *)((int)local_234 + 0xc), 0x33 < uVar13)) &&
           (iVar11 = *(int *)((int)local_234 + 8), iVar11 != 0)) {
          for (uVar8 = 0;
              uVar8 < (uint)*(ushort *)(iVar11 + 0x2a) * (uint)*(ushort *)(iVar11 + 0x2c);
              uVar8 = uVar8 + *(ushort *)(iVar11 + 0x2a)) {
            if (uVar13 < uVar8 + *(int *)(iVar11 + 0x1c) + 0x20) goto LAB_0002002c;
            iVar4 = *(int *)(iVar11 + 0x1c) + iVar11;
            if (((*(int *)(iVar4 + uVar8) == 1) &&
                (iVar4 = iVar4 + uVar8, (*(byte *)(iVar4 + 0x18) & 1) != 0)) &&
               (*(int *)(iVar4 + 4) == 0)) {
              *(undefined4 *)((int)local_234 + 0x10) = *(undefined4 *)(iVar4 + 8);
              break;
            }
          }
          iVar4 = 0;
          uVar14 = (uint)*(ushort *)(iVar11 + 0x2e);
          uVar8 = uVar14;
          for (; uVar14 < *(ushort *)(iVar11 + 0x30) * uVar8; uVar14 = uVar14 + uVar8) {
            iVar12 = *(int *)(iVar11 + 0x20) + uVar14;
            if (uVar13 < iVar12 + 0x28U) goto LAB_0002002c;
            iVar12 = *(int *)((int)pvVar1 + 8) + iVar12;
            if (iVar12 == 0) goto LAB_0002002c;
            if ((*(int *)(iVar12 + 4) == 0xb || *(int *)(iVar12 + 4) == 2) &&
               (*(uint *)(iVar12 + 0x18) < (uint)*(ushort *)(iVar11 + 0x30))) {
              iVar9 = *(uint *)(iVar12 + 0x18) * uVar8 + *(int *)(iVar11 + 0x20);
              if ((uVar13 < iVar9 + 0x28U) ||
                 (iVar9 = *(int *)((int)pvVar1 + 8) + iVar9, iVar9 == 0)) goto LAB_0002002c;
              if (*(int *)(iVar9 + 4) == 3) {
                piVar6 = (int *)malloc(0x1c);
                if (piVar6 == (int *)0x0) goto LAB_0002002c;
                iVar7 = *(int *)(iVar12 + 0x10);
                *piVar6 = iVar7;
                iVar4 = iVar4 + 1;
                piVar6[1] = iVar7 + *(int *)(iVar12 + 0x14);
                piVar6[2] = *(int *)(iVar12 + 0x24);
                iVar12 = *(int *)(iVar9 + 0x10);
                piVar6[3] = iVar12;
                piVar6[4] = iVar12 + *(int *)(iVar9 + 0x14);
                piVar6[5] = 0;
                puVar10 = *(undefined4 **)((int)pvVar1 + 0x18);
                piVar6[6] = (int)puVar10;
                *puVar10 = piVar6;
                *(int **)((int)pvVar1 + 0x18) = piVar6 + 5;
                uVar8 = (uint)*(ushort *)(iVar11 + 0x2e);
              }
            }
          }
          pvVar2 = local_234;
          if (iVar4 != 0) goto LAB_00020036;
        }
      }
    }
LAB_0002002c:
    dynamic_load_destroy(&local_234);
    pvVar2 = (void *)0x0;
  }
LAB_00020036:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(pvVar2);
  }
  return;
}



void dynamic_load_destroy(int *param_1)

{
  void *__ptr;
  int iVar1;
  undefined4 *puVar2;
  void *pvVar3;
  
  if ((param_1 != (int *)0x0) && (iVar1 = *param_1, iVar1 != 0)) {
    if (*(void **)(iVar1 + 8) != (void *)0xffffffff) {
      munmap(*(void **)(iVar1 + 8),*(size_t *)(iVar1 + 0xc));
      iVar1 = *param_1;
    }
    if (-1 < *(int *)(iVar1 + 4)) {
      close(*(int *)(iVar1 + 4));
      iVar1 = *param_1;
    }
    __ptr = *(void **)(iVar1 + 0x14);
    while (__ptr != (void *)0x0) {
      pvVar3 = *(void **)((int)__ptr + 0x14);
      puVar2 = *(undefined4 **)((int)__ptr + 0x18);
      if (pvVar3 == (void *)0x0) {
        *(undefined4 **)(*param_1 + 0x18) = puVar2;
      }
      else {
        *(undefined4 **)((int)pvVar3 + 0x18) = puVar2;
        puVar2 = *(undefined4 **)((int)__ptr + 0x18);
      }
      *puVar2 = pvVar3;
      free(__ptr);
      __ptr = pvVar3;
    }
    free((void *)*param_1);
    *param_1 = 0;
  }
  return;
}



int dynamic_load_sym(int *param_1,char *param_2)

{
  char cVar1;
  char *__s2;
  int iVar2;
  char *pcVar3;
  int *piVar4;
  uint uVar5;
  uint uVar6;
  uint *puVar7;
  
  puVar7 = (uint *)(param_1 + 5);
  do {
    puVar7 = (uint *)*puVar7;
    if (puVar7 == (uint *)0x0) {
      return 0;
    }
    uVar6 = puVar7[1];
    for (uVar5 = *puVar7; (uVar5 < uVar6 && (uVar5 + 0x10 <= (uint)param_1[3]));
        uVar5 = uVar5 + puVar7[2]) {
      iVar2 = param_1[2];
      piVar4 = (int *)(iVar2 + uVar5);
      if (piVar4 == (int *)0x0) break;
      if ((*(short *)((int)piVar4 + 0xe) != 0) && (puVar7[3] + *piVar4 < puVar7[4])) {
        __s2 = (char *)(iVar2 + puVar7[3] + *piVar4);
        pcVar3 = __s2;
        do {
          if ((char *)(param_1[3] + iVar2) <= pcVar3) goto LAB_0002023c;
          cVar1 = *pcVar3;
          pcVar3 = pcVar3 + 1;
        } while (cVar1 != '\0');
        if ((__s2 != (char *)0x0) && (iVar2 = strcmp(param_2,__s2), iVar2 == 0)) {
          return (*param_1 + piVar4[1]) - param_1[4];
        }
      }
LAB_0002023c:
    }
    puVar7 = puVar7 + 5;
  } while( true );
}



void _Uarm_get_reg(int param_1,int param_2,undefined4 *param_3)

{
  if (param_2 != 0xe) {
    FUN_0002060c(param_1,param_2,param_3,0);
    return;
  }
  *param_3 = *(undefined4 *)(param_1 + 0xc);
  return;
}



int init_dl_iterate_phdr_wrapper(void)

{
  int iVar1;
  
  iVar1 = get_libraray_function("libc.so","dl_iterate_phdr");
  DAT_0003de14 = iVar1;
  if (iVar1 != 0) {
    iVar1 = 1;
  }
  return iVar1;
}



void dl_iterate_phdr_wrapper(code *param_1,undefined4 param_2)

{
  char cVar1;
  char *pcVar2;
  int iVar3;
  int *piVar4;
  bool bVar5;
  char *local_34;
  int local_30;
  char *local_2c;
  short local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  if (DAT_0003de14 != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x00020330. Too many branches
                    // WARNING: Treating indirect jump as call
    (*DAT_0003de14)(param_1,param_2);
    return;
  }
  if (localMapInfoList != (int *)0x0) {
    piVar4 = localMapInfoList;
    do {
      cVar1 = *(char *)((int)piVar4 + 0x26);
      bVar5 = cVar1 != '\0';
      if (bVar5) {
        cVar1 = (char)piVar4[9];
      }
      if (bVar5 && cVar1 != '\0') {
        pcVar2 = (char *)piVar4[1];
        cVar1 = *pcVar2;
        bVar5 = cVar1 == '\x7f';
        if (bVar5) {
          cVar1 = pcVar2[1];
        }
        if (bVar5 && cVar1 == 'E') {
          cVar1 = pcVar2[2];
          bVar5 = cVar1 == 'L';
          if (bVar5) {
            cVar1 = pcVar2[3];
          }
          if (bVar5 && cVar1 == 'F') {
            local_30 = (int)piVar4 + 0x27;
            local_34 = (char *)piVar4[6];
            if ((char *)piVar4[6] == (char *)0x0) {
              local_34 = pcVar2;
            }
            if (*(int *)(pcVar2 + 0x1c) != 0) {
              local_2c = pcVar2 + *(int *)(pcVar2 + 0x1c);
              local_28 = *(short *)(pcVar2 + 0x2c);
              if ((local_28 != 0) && (iVar3 = (*param_1)(&local_34,0x10,param_2), iVar3 != 0)) {
                log2Console(4,"CrashReport","Call back broke the iterating.");
                break;
              }
            }
          }
        }
      }
      piVar4 = (int *)*piVar4;
    } while (piVar4 != (int *)0x0);
  }
  if (__stack_chk_guard - local_24 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_24);
}



int _Uarm_init_local(undefined4 *param_1,undefined4 param_2)

{
  int iVar1;
  
  if (DAT_00063738 == 0) {
    FUN_00025560();
  }
  log2Console(3,"Bugly-libunwind","(cursor=%p)\n",param_1);
  iVar1 = _Uarm_local_addr_space;
  *param_1 = param_2;
  param_1[1] = iVar1;
  param_1[10] = 0;
  param_1[0xb] = 2;
  param_1[0xc] = 1;
  param_1[0xd] = 2;
  param_1[0xe] = 2;
  param_1[0xf] = 2;
  param_1[0x10] = 3;
  param_1[0x11] = 2;
  param_1[0x12] = 4;
  param_1[0x13] = 2;
  param_1[0x14] = 5;
  param_1[0x15] = 2;
  param_1[0x16] = 6;
  param_1[0x17] = 2;
  param_1[0x18] = 7;
  param_1[0x19] = 2;
  param_1[0x1a] = 8;
  param_1[0x1b] = 2;
  param_1[0x1c] = 9;
  param_1[0x1d] = 2;
  param_1[0x1e] = 10;
  param_1[0x1f] = 2;
  param_1[0x20] = 0xb;
  param_1[0x21] = 2;
  param_1[0x22] = 0xc;
  param_1[0x23] = 2;
  param_1[0x24] = 0xd;
  param_1[0x25] = 2;
  param_1[0x26] = 0xe;
  param_1[0x27] = 2;
  param_1[0x28] = 0xf;
  param_1[0x29] = 2;
  __aeabi_memclr4(param_1 + 0x2a,0x380);
  iVar1 = (**(code **)(iVar1 + 0x10))(iVar1,0xf,param_1 + 3,0,param_2);
  if (-1 < iVar1) {
    iVar1 = (**(code **)(param_1[1] + 0x10))(param_1[1],0xd,param_1 + 2,0,*param_1);
    if (-1 < iVar1) {
      param_1[4] = 0;
      param_1[5] = 0;
      param_1[0x115] = 0;
      param_1[0x116] = 0;
      param_1[0x117] = 0;
      param_1[0x118] = 0;
      param_1[0x119] = 0;
      param_1[9] = 0;
      *(byte *)(param_1 + 0x10a) = *(byte *)(param_1 + 0x10a) & 0xf0 | 2;
      iVar1 = 0;
    }
  }
  return iVar1;
}



void FUN_0002060c(undefined4 *param_1,uint param_2,undefined4 *param_3,int param_4)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  code *pcVar4;
  undefined4 local_18;
  int local_14;
  
  local_14 = __stack_chk_guard;
  if ((param_2 < 0xd) || (param_2 - 0xe < 2)) {
    iVar1 = param_1[param_2 * 2 + 10];
    uVar3 = param_1[param_2 * 2 + 0xb];
    if (param_4 == 0) {
      if (uVar3 != 0 || iVar1 != 0) {
        iVar2 = param_1[1];
        if ((uVar3 & 2) == 0) {
          (**(code **)(iVar2 + 0xc))(iVar2,iVar1,param_3,0,*param_1);
          if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
            __stack_chk_fail();
          }
          return;
        }
        (**(code **)(iVar2 + 0x10))(iVar2,iVar1,param_3,0,*param_1);
        if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
          __stack_chk_fail();
        }
        return;
      }
    }
    else {
      local_18 = *param_3;
      if (uVar3 != 0 || iVar1 != 0) {
        iVar2 = param_1[1];
        if ((uVar3 & 2) == 0) {
          pcVar4 = *(code **)(iVar2 + 0xc);
        }
        else {
          pcVar4 = *(code **)(iVar2 + 0x10);
        }
        (*pcVar4)(iVar2,iVar1,&local_18,1,*param_1);
      }
    }
  }
  else if (param_2 == 0xd || param_2 == 0x120) {
    if (param_4 == 0) {
      *param_3 = param_1[2];
    }
  }
  else {
    log2Console(3,"Bugly-libunwind","bad register number %u\n",param_2);
  }
  if (__stack_chk_guard - local_14 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_14);
  }
  return;
}



undefined4 FUN_00020778(undefined4 param_1,undefined4 param_2)

{
  log2Console(3,"Bugly-libunwind","bad register number %u\n",param_2);
  return 0xfffffffd;
}



// WARNING: Removing unreachable block (ram,0x000209c8)

void _Uarm_handle_signal_frame(undefined4 *param_1)

{
  int iVar1;
  undefined4 uVar2;
  uint uVar3;
  int iVar4;
  code *pcVar5;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar4 = param_1[2];
  if ((iVar4 == 0) ||
     (iVar1 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar4,&local_2c,0,*param_1), iVar1 < 0))
  goto LAB_000209a0;
  iVar1 = _Uarm_is_signal_frame(param_1);
  param_1[0x118] = param_1[2];
  param_1[0x119] = param_1[3];
  if (iVar1 == 2) {
    if (local_2c == iVar4 + 8) {
      uVar2 = 4;
      iVar4 = iVar4 + 0x9c;
    }
    else {
      iVar4 = iVar4 + 0x94;
      uVar2 = 2;
    }
  }
  else {
    if (iVar1 != 1) goto LAB_000209a0;
    if (local_2c == 0x5ac3c35a) {
      uVar2 = 1;
      iVar4 = iVar4 + 0x14;
    }
    else {
      uVar2 = 3;
    }
  }
  param_1[0x116] = uVar2;
  param_1[0x117] = iVar4;
  param_1[10] = iVar4 + 0xc;
  uVar3 = 0;
  param_1[0xb] = 0;
  param_1[0xc] = iVar4 + 0x10;
  param_1[0xd] = 0;
  param_1[0xe] = iVar4 + 0x14;
  param_1[0xf] = 0;
  param_1[0x10] = iVar4 + 0x18;
  param_1[0x11] = 0;
  param_1[0x12] = iVar4 + 0x1c;
  param_1[0x13] = 0;
  param_1[0x14] = iVar4 + 0x20;
  param_1[0x15] = 0;
  param_1[0x16] = iVar4 + 0x24;
  param_1[0x17] = 0;
  param_1[0x18] = iVar4 + 0x28;
  param_1[0x19] = 0;
  param_1[0x1a] = iVar4 + 0x2c;
  param_1[0x1b] = 0;
  param_1[0x1c] = iVar4 + 0x30;
  param_1[0x1d] = 0;
  param_1[0x1e] = iVar4 + 0x34;
  iVar1 = iVar4 + 0x40;
  param_1[0x1f] = 0;
  param_1[0x20] = iVar4 + 0x38;
  param_1[0x21] = 0;
  param_1[0x22] = iVar4 + 0x3c;
  param_1[0x23] = 0;
  param_1[0x24] = iVar1;
  param_1[0x25] = 0;
  param_1[0x26] = iVar4 + 0x44;
  param_1[0x27] = 0;
  param_1[0x28] = iVar4 + 0x48;
  param_1[0x29] = 0;
  if (iVar1 == 0) {
    iVar4 = 8;
LAB_0002096c:
    iVar1 = param_1[1];
    if ((uVar3 & 2) == 0) {
      pcVar5 = *(code **)(iVar1 + 0xc);
    }
    else {
      pcVar5 = *(code **)(iVar1 + 0x10);
    }
    (*pcVar5)(iVar1,iVar4,param_1 + 3,0,*param_1);
  }
  else {
    (**(code **)(param_1[1] + 0xc))(param_1[1],iVar1,param_1 + 2,0,*param_1);
    iVar4 = param_1[0x28];
    uVar3 = param_1[0x29];
    if (uVar3 != 0 || iVar4 != 0) goto LAB_0002096c;
  }
  *(byte *)(param_1 + 0x10a) = *(byte *)(param_1 + 0x10a) & 0xfb;
LAB_000209a0:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void _Uarm_step(undefined4 *param_1)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  undefined4 uVar6;
  code *pcVar7;
  uint uVar8;
  uint *puVar9;
  int local_4c;
  uint local_48 [8];
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,"Bugly-libunwind","(cursor=%p)\n",param_1);
  puVar9 = param_1 + 3;
  uVar8 = *puVar9;
  iVar4 = param_1[2];
  if ((DAT_0003d0c0 & 1) == 0) {
joined_r0x00020e84:
    if ((DAT_0003d0c0 & 4) == 0) {
LAB_00020bd4:
      if ((DAT_0003d0c0 & 2) != 0) {
        log2Console(3,"Bugly-libunwind","dwarf_step() failed (ret=%d), trying frame-chain\n",0);
        if (param_1[0x21] == 0 && param_1[0x20] == 0) goto LAB_00020cb4;
        iVar5 = param_1[1];
        if ((param_1[0x21] & 2) == 0) {
          pcVar7 = *(code **)(iVar5 + 0xc);
        }
        else {
          pcVar7 = *(code **)(iVar5 + 0x10);
        }
        iVar5 = (*pcVar7)(iVar5,param_1[0x20],&local_4c,0,*param_1);
        if (iVar5 < 0) goto LAB_00020cb4;
        __aeabi_memclr4(param_1 + 10,0x400);
        if (local_4c != 0) {
          iVar5 = (**(code **)(param_1[1] + 0xc))(param_1[1],local_4c,local_48,0,*param_1);
          if (((iVar5 < 0) || (local_48[0] = local_48[0] - 8, local_48[0] == 0)) ||
             (iVar5 = (**(code **)(param_1[1] + 0xc))(param_1[1],local_48[0],local_48,0,*param_1),
             iVar5 < 0)) goto LAB_00020cb4;
          iVar2 = local_4c + -4;
          iVar5 = local_4c;
          if ((local_48[0] & 0xffffd800) == 0xe92dd800) {
            iVar2 = local_4c + -0xc;
            iVar5 = local_4c + -4;
          }
          if ((iVar5 == 0) ||
             (iVar3 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar5,puVar9,0,*param_1),
             iVar3 == -1 || iVar3 + 1 < 0 != SCARRY4(iVar3,1))) goto LAB_00020cb4;
          param_1[0x20] = iVar2;
          param_1[0x21] = 0;
          param_1[0x22] = iVar5;
          param_1[0x23] = 0;
          *(byte *)(param_1 + 0x10a) = *(byte *)(param_1 + 0x10a) & 0xfb;
          log2Console(3,"Bugly-libunwind","ip=%x\n",param_1[3]);
          goto LAB_00020ad0;
        }
      }
      if (((DAT_0003d0c0 & 8) == 0) || (param_1[9] != 0)) goto LAB_00020cb4;
      if (param_1[0x27] == 0 && param_1[0x26] == 0) goto LAB_00020cb4;
      iVar5 = param_1[1];
      if ((param_1[0x27] & 2) == 0) {
        pcVar7 = *(code **)(iVar5 + 0xc);
      }
      else {
        pcVar7 = *(code **)(iVar5 + 0x10);
      }
      iVar5 = (*pcVar7)(iVar5,param_1[0x26],local_48,0,*param_1);
      if ((iVar5 < 0) || (local_48[0] == *puVar9)) goto LAB_00020cb4;
      *puVar9 = local_48[0];
      uVar1 = local_48[0];
      goto joined_r0x00020adc;
    }
    param_1[0x28] = 0;
    param_1[0x29] = 0;
    uVar1 = (**(code **)param_1[1])((undefined4 *)param_1[1],param_1[3],param_1 + 0x10b,1,*param_1);
    if ((int)uVar1 < 0) {
LAB_00020bc0:
      if ((uVar1 == 0xfffffffb) || (uVar1 == 0)) goto LAB_00020ad0;
      goto LAB_00020bd4;
    }
    if (param_1[0x111] != 3) goto LAB_00020bd4;
    uVar1 = FUN_000215e4(param_1,local_48);
    if (uVar1 == 0xfffffffb) goto LAB_00020ad0;
    if (((int)uVar1 < 0) || (uVar1 = FUN_000212a8(local_48,uVar1 & 0xff,param_1), (int)uVar1 < 0))
    goto LAB_00020bc0;
    uVar1 = param_1[3];
    *(byte *)(param_1 + 0x10a) = *(byte *)(param_1 + 0x10a) & 0xfb;
    if (uVar1 != 0) goto LAB_00020ae4;
    uVar1 = 0;
  }
  else {
    iVar5 = FUN_000254c4(param_1);
    log2Console(3,"Bugly-libunwind","dwarf_step()=%d\n",iVar5);
    if ((iVar5 < 1) && (iVar5 != -5 && iVar5 != 0)) goto joined_r0x00020e84;
LAB_00020ad0:
    uVar1 = *puVar9;
joined_r0x00020adc:
    if (uVar1 == 0) {
      uVar1 = 0;
    }
    else {
LAB_00020ae4:
      iVar5 = 4;
      if ((uVar1 & 1) != 0) {
        uVar6 = param_1[1];
        iVar2 = _Uarm_get_accessors(uVar6);
        if ((uVar1 < 5) ||
           (iVar2 = (**(code **)(iVar2 + 0xc))(uVar6,uVar1 - 5,local_48,0,*param_1), iVar2 < 0)) {
          iVar5 = 2;
        }
        else if ((local_48[0] & 0xe000f000) != 0xe000f000) {
          iVar5 = 2;
        }
      }
      uVar1 = *puVar9 - iVar5;
      *puVar9 = uVar1;
    }
  }
  if ((uVar1 == uVar8) && (param_1[2] == iVar4)) {
    log2Console(3,"Bugly-libunwind","%s: ip and cfa unchanged; stopping here (ip=0x%lx)\n",
                "_Uarm_step",uVar8);
  }
  else {
    param_1[9] = param_1[9] + 1;
  }
LAB_00020cb4:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void _Uarm_is_signal_frame(undefined4 *param_1)

{
  int iVar1;
  undefined4 uVar2;
  int local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  uVar2 = param_1[1];
  iVar1 = _Uarm_get_accessors(uVar2);
  (**(code **)(iVar1 + 0xc))(uVar2,param_1[3],&local_20,0,*param_1);
  if (__stack_chk_guard - local_1c != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_1c);
  }
  return;
}



undefined4 FUN_00020fcc(undefined4 *param_1,undefined4 *param_2,char *param_3)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  uint *puVar4;
  undefined4 *puVar5;
  uint uVar6;
  uint uVar7;
  undefined4 uVar8;
  code *pcVar9;
  bool bVar10;
  
  uVar8 = 0;
  puVar4 = &switchD_00020ff8::switchdataD_00020ffc;
  switch(*param_1) {
  case 0:
    puVar4 = (uint *)param_2[0x28];
    uVar2 = param_2[0x29];
    if (uVar2 == 0 && puVar4 == (uint *)0x0) {
      puVar4 = (uint *)param_2[0x26];
      uVar2 = param_2[0x27];
      param_2[0x28] = puVar4;
      param_2[0x29] = uVar2;
      if (uVar2 == 0 && puVar4 == (uint *)0x0) {
        return 0;
      }
    }
    iVar3 = param_2[1];
    puVar5 = param_2 + 3;
    goto LAB_000211a4;
  case 1:
    log2Console(3,"Bugly-libunwind","vsp = vsp - %d\n",param_1[1]);
    iVar3 = param_2[2] - param_1[1];
    break;
  case 2:
    log2Console(3,"Bugly-libunwind","vsp = vsp + %d\n",param_1[1]);
    iVar3 = param_2[2] + param_1[1];
    break;
  case 3:
    puVar5 = param_2 + 2;
    uVar2 = param_1[1];
    uVar1 = 0;
    do {
      if ((uVar2 & 1 << (uVar1 & 0xff)) != 0) {
        param_3 = "pop {r%d}\n";
        log2Console(3,"Bugly-libunwind","pop {r%d}\n",uVar1);
        puVar4 = (uint *)param_2[2];
        param_2[uVar1 * 2 + 10] = puVar4;
        param_2[uVar1 * 2 + 0xb] = 0;
        param_2[2] = puVar4 + 1;
        uVar2 = param_1[1];
      }
      uVar1 = uVar1 + 1;
    } while (uVar1 != 0x10);
    bVar10 = (uVar2 & 0x2000) == 0;
    if (!bVar10) {
      puVar4 = (uint *)param_2[0x24];
      param_3 = (char *)param_2[0x25];
    }
    if (bVar10 || param_3 == (char *)0x0 && puVar4 == (uint *)0x0) {
      return 0;
    }
    iVar3 = param_2[1];
    uVar8 = *param_2;
    if (((uint)param_3 & 2) == 0) {
      pcVar9 = *(code **)(iVar3 + 0xc);
    }
    else {
      pcVar9 = *(code **)(iVar3 + 0x10);
    }
    goto LAB_000211bc;
  case 4:
    log2Console(3,"Bugly-libunwind","vsp = r%d\n",param_1[1]);
    puVar4 = (uint *)param_2[param_1[1] * 2 + 10];
    uVar2 = param_2[param_1[1] * 2 + 0xb];
    param_2[0x24] = puVar4;
    param_2[0x25] = uVar2;
    if (uVar2 == 0 && puVar4 == (uint *)0x0) {
      return 0;
    }
    puVar5 = param_2 + 2;
    iVar3 = param_2[1];
LAB_000211a4:
    uVar8 = *param_2;
    if ((uVar2 & 2) == 0) {
      pcVar9 = *(code **)(iVar3 + 0xc);
    }
    else {
      pcVar9 = *(code **)(iVar3 + 0x10);
    }
LAB_000211bc:
    (*pcVar9)(iVar3,puVar4,puVar5,0,uVar8);
    return 0;
  case 5:
    uVar1 = param_1[1];
    uVar7 = (uVar1 << 0x18) >> 0x1c;
    uVar6 = uVar7 + (uVar1 & 0xf) + 1;
    uVar2 = uVar7 + 1;
    if (uVar7 + 1 < uVar6) {
      uVar2 = uVar6;
    }
    iVar3 = param_2[2] + uVar2 * 8 + uVar7 * -8;
    param_2[2] = iVar3;
    if ((uVar1 & 0x20000) != 0) {
      return 0;
    }
    goto LAB_00021274;
  case 6:
    uVar1 = (uint)(param_1[1] << 0x18) >> 0x1c;
    uVar6 = uVar1 + (param_1[1] & 0xf) + 1;
    uVar2 = uVar1 + 1;
    if (uVar1 + 1 < uVar6) {
      uVar2 = uVar6;
    }
    iVar3 = param_2[2] + uVar2 * 8 + uVar1 * -8;
    break;
  case 7:
    uVar2 = param_1[1];
    if ((uVar2 & 1) != 0) {
      param_2[2] = param_2[2] + 4;
    }
    if ((uVar2 & 2) != 0) {
      param_2[2] = param_2[2] + 4;
    }
    if ((uVar2 & 4) != 0) {
      param_2[2] = param_2[2] + 4;
    }
    if ((uVar2 & 8) == 0) {
      return 0;
    }
    iVar3 = param_2[2];
LAB_00021274:
    iVar3 = iVar3 + 4;
    break;
  case 8:
  case 9:
    uVar8 = 0xffffffff;
  default:
    goto switchD_00020ff8_default;
  }
  param_2[2] = iVar3;
switchD_00020ff8_default:
  return uVar8;
}



void FUN_000212a8(byte *param_1,int param_2,undefined4 param_3)

{
  byte bVar1;
  byte *pbVar2;
  int iVar3;
  byte *pbVar4;
  uint uVar5;
  sbyte sVar6;
  uint uVar7;
  undefined4 local_30;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  pbVar4 = param_1;
  do {
    if (param_1 + param_2 <= pbVar4) {
      iVar3 = 0;
      break;
    }
    pbVar2 = pbVar4 + 1;
    uVar5 = (uint)*pbVar4;
    if ((uVar5 & 0xc0) == 0x40) {
      local_30 = 1;
LAB_0002130c:
      local_2c = (uVar5 & 0x3f) * 4 + 4;
    }
    else {
      if ((*pbVar4 & 0xc0) == 0) {
        local_30 = 2;
        goto LAB_0002130c;
      }
      uVar7 = uVar5 & 0xf0;
      if (uVar7 == 0xa0) {
        local_30 = 3;
        local_2c = (0x20 << (uVar5 & 7)) - 0x10U | (uVar5 & 8) << 0xb;
      }
      else if (uVar7 == 0x90) {
        if ((uVar5 | 2) == 0x9f) {
LAB_000213b0:
          local_30 = 8;
        }
        else {
          local_2c = uVar5 & 0xf;
          local_30 = 4;
        }
      }
      else if (uVar7 == 0x80) {
        pbVar2 = pbVar4 + 2;
        if (uVar5 == 0x80 && pbVar4[1] == 0) {
          local_30 = 9;
        }
        else {
          local_30 = 3;
          local_2c = ((uint)pbVar4[1] | (uVar5 & 0xf) << 8) << 4;
        }
      }
      else {
        switch(uVar5) {
        case 0xb0:
          local_30 = 0;
          pbVar2 = param_1 + param_2;
          break;
        case 0xb1:
          bVar1 = pbVar4[1];
          if ((bVar1 == 0) || ((bVar1 & 0xf0) != 0)) {
LAB_000215b8:
            local_30 = 8;
            pbVar2 = pbVar4 + 2;
          }
          else {
            local_2c = bVar1 & 0xf;
            local_30 = 3;
            pbVar2 = pbVar4 + 2;
          }
          break;
        case 0xb2:
          uVar5 = 0;
          sVar6 = 0;
          do {
            pbVar4 = pbVar2 + 1;
            bVar1 = *pbVar2;
            uVar5 = uVar5 | (bVar1 & 0x7f) << sVar6;
            pbVar2 = pbVar4;
            sVar6 = sVar6 + 7;
          } while ((bVar1 & 0x80) != 0);
          local_30 = 2;
          local_2c = uVar5 * 4 + 0x204;
          break;
        case 0xb3:
        case 200:
        case 0xc9:
          local_30 = 5;
          local_2c = (uint)pbVar4[1];
          pbVar2 = pbVar4 + 2;
          if (uVar5 == 200) {
            local_2c = local_2c | 0x10000;
          }
          if (uVar5 != 0xb3) {
            local_2c = local_2c | 0x20000;
          }
          break;
        default:
          uVar7 = uVar5 & 0xf8;
          if (uVar7 == 0xd0 || uVar7 == 0xb8) {
            local_30 = 5;
            local_2c = uVar5 & 7 | 0x80;
            if (uVar7 == 0xd0) {
              local_2c = uVar5 & 7 | 0x20080;
            }
          }
          else if ((uVar5 + 0x40 & 0xff) < 6) {
            local_2c = uVar5 & 7 | 0xa0;
            local_30 = 6;
          }
          else if (uVar5 == 199) {
            bVar1 = pbVar4[1];
            if ((bVar1 == 0) || ((bVar1 & 0xf0) != 0)) goto LAB_000215b8;
            local_2c = bVar1 & 0xf;
            local_30 = 7;
            pbVar2 = pbVar4 + 2;
          }
          else {
            if (uVar5 != 0xc6) goto LAB_000213b0;
            local_30 = 6;
            local_2c = (uint)pbVar4[1];
            pbVar2 = pbVar4 + 2;
          }
        }
      }
    }
    iVar3 = FUN_00020fcc(&local_30,param_3);
    pbVar4 = pbVar2;
  } while (iVar3 != -1 && iVar3 + 1 < 0 == SCARRY4(iVar3,1));
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar3);
  }
  return;
}



void FUN_000215e4(undefined4 *param_1,undefined1 *param_2)

{
  bool bVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  uint uVar5;
  uint uVar6;
  undefined1 *puVar7;
  int iVar8;
  uint uVar9;
  uint local_30;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar8 = param_1[0x113];
  iVar2 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar8,&local_2c,0,*param_1);
  iVar4 = local_2c;
  if (iVar2 != -1 && iVar2 + 1 < 0 == SCARRY4(iVar2,1)) {
    iVar2 = iVar8 + 4;
    iVar3 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar2,&local_30,0,*param_1);
    if (-1 < iVar3) {
      if (local_30 == 1) {
        log2Console(3,"Bugly-libunwind","0x1 [can\'t unwind]\n");
      }
      else {
        iVar8 = iVar8 + ((iVar4 << 1) >> 1);
        if (local_30 == 0xffffffff || (int)(local_30 + 1) < 0 != SCARRY4(local_30,1)) {
          uVar5 = 3;
          log2Console(3,"Bugly-libunwind","%p compact model %d [%8.8x]\n",iVar8,
                      (local_30 << 1) >> 0x19,local_30);
          param_2[2] = (char)local_30;
          param_2[1] = (char)(local_30 >> 8);
          *param_2 = (char)(local_30 >> 0x10);
        }
        else {
          iVar4 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar2,&local_2c,0,*param_1);
          if (iVar4 == -1 || iVar4 + 1 < 0 != SCARRY4(iVar4,1)) goto LAB_000219b8;
          iVar2 = iVar2 + ((local_2c << 1) >> 1);
          iVar4 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar2,&local_30,0,*param_1);
          if (iVar4 < 0) goto LAB_000219b8;
          if (local_30 == 0xffffffff || (int)(local_30 + 1) < 0 != SCARRY4(local_30,1)) {
            uVar5 = (local_30 << 4) >> 0x1c;
            log2Console(3,"Bugly-libunwind","%p compact model %d [%8.8x]\n",iVar8,uVar5,local_30);
            bVar1 = 1 < uVar5 - 1;
            if (bVar1) {
              *param_2 = (char)(local_30 >> 0x10);
              uVar6 = 0;
            }
            else {
              uVar6 = local_30 >> 0x10 & 0xff;
              iVar2 = iVar2 + 4;
            }
            uVar9 = (uint)bVar1;
            param_2[uVar9] = (char)(local_30 >> 8);
            uVar5 = uVar9 | 2;
            (param_2 + uVar9)[1] = (char)local_30;
          }
          else {
            iVar4 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar2,&local_2c,0,*param_1);
            if (iVar4 == -1 || iVar4 + 1 < 0 != SCARRY4(iVar4,1)) goto LAB_000219b8;
            log2Console(3,"Bugly-libunwind","%p Personality routine: %8p\n",iVar8,
                        iVar2 + ((local_2c << 1) >> 1));
            iVar4 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar2 + 4,&local_30,0,*param_1);
            if (iVar4 < 0) goto LAB_000219b8;
            iVar2 = iVar2 + 8;
            param_2[2] = (char)local_30;
            uVar6 = local_30 >> 0x18;
            param_2[1] = (char)(local_30 >> 8);
            *param_2 = (char)(local_30 >> 0x10);
            uVar5 = 3;
          }
          if (uVar6 != 0) {
            iVar4 = 0;
            uVar9 = 0;
            do {
              iVar8 = (**(code **)(param_1[1] + 0xc))(param_1[1],iVar2 + iVar4,&local_30,0,*param_1)
              ;
              if (iVar8 < 0) goto LAB_000219b8;
              puVar7 = param_2 + iVar4 + uVar5;
              *puVar7 = (char)(local_30 >> 0x18);
              iVar8 = uVar9 * 4;
              uVar9 = uVar9 + 1;
              iVar4 = iVar4 + 4;
              param_2[iVar8 + uVar5 + 1] = (char)(local_30 >> 0x10);
              puVar7[3] = (char)local_30;
              puVar7[2] = (char)(local_30 >> 8);
            } while (uVar9 < uVar6);
            uVar5 = uVar5 + iVar4;
            if ((int)uVar5 < 1) goto LAB_000219b8;
          }
        }
        if (param_2[uVar5 - 1] != -0x50) {
          param_2[uVar5] = 0xb0;
        }
      }
    }
  }
LAB_000219b8:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void _Uarm_search_unwind_table(int param_1,uint param_2,int param_3,int *param_4,int param_5)

{
  int iVar1;
  undefined4 uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  int iVar7;
  bool bVar8;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (((DAT_0003d0c0 & 4) == 0) || (*(int *)(param_3 + 0x14) != 3)) {
    bVar8 = (DAT_0003d0c0 & 1) != 0;
    uVar2 = 0xfffffff6;
    uVar5 = DAT_0003d0c0;
    if (bVar8) {
      uVar5 = *(uint *)(param_3 + 0x14);
    }
    if (bVar8 && uVar5 != 3) {
      _Uarm_dwarf_search_unwind_table(param_1,param_2,param_3);
      return;
    }
    goto LAB_00021c0c;
  }
  uVar5 = *(uint *)(param_3 + 0x28);
  iVar7 = *(int *)(param_3 + 0x24);
  iVar1 = (**(code **)(param_1 + 0xc))(param_1,uVar5,&local_2c,0);
  if (iVar1 == -1 || iVar1 + 1 < 0 != SCARRY4(iVar1,1)) {
    uVar2 = 0xfffffff6;
    goto LAB_00021c0c;
  }
  uVar2 = 0xfffffff6;
  if (param_2 < uVar5 + ((local_2c << 1) >> 1)) goto LAB_00021c0c;
  iVar7 = uVar5 + iVar7;
  uVar6 = iVar7 - 8;
  iVar1 = (**(code **)(param_1 + 0xc))(param_1,uVar6,&local_2c,0);
  if (iVar1 != -1 && iVar1 + 1 < 0 == SCARRY4(iVar1,1)) {
    if (param_2 < uVar6 + ((local_2c << 1) >> 1)) {
      if (uVar5 < iVar7 - 0x10U) {
        do {
          uVar4 = ((uVar6 - uVar5 >> 1 & 0xfffffffc) + 4 & 0xfffffffb) + uVar5;
          iVar1 = (**(code **)(param_1 + 0xc))(param_1,uVar4,&local_2c,0);
          if (iVar1 == -1 || iVar1 + 1 < 0 != SCARRY4(iVar1,1)) goto LAB_00021cc0;
          uVar3 = uVar4 + ((local_2c << 1) >> 1);
          if (param_2 < uVar3) {
            uVar6 = uVar4;
          }
          if (uVar3 <= param_2) {
            uVar5 = uVar4;
          }
        } while (uVar5 < uVar6 - 8);
      }
      iVar1 = (**(code **)(param_1 + 0xc))(param_1,uVar5,&local_2c,0);
      if (iVar1 != -1 && iVar1 + 1 < 0 == SCARRY4(iVar1,1)) {
        *param_4 = uVar5 + ((local_2c << 1) >> 1);
        iVar1 = (**(code **)(param_1 + 0xc))(param_1,uVar5 + 8,&local_2c,0);
        if (iVar1 != -1 && iVar1 + 1 < 0 == SCARRY4(iVar1,1)) {
          param_4[1] = uVar5 + 8 + ((local_2c << 1) >> 1) + -1;
          uVar6 = uVar5;
          goto LAB_00021c9c;
        }
      }
    }
    else {
      iVar1 = (**(code **)(param_1 + 0xc))(param_1,uVar6,&local_2c,0);
      if (iVar1 != -1 && iVar1 + 1 < 0 == SCARRY4(iVar1,1)) {
        *param_4 = uVar6 + ((local_2c << 1) >> 1);
        param_4[1] = *(int *)(param_3 + 0xc) + -1;
LAB_00021c9c:
        uVar2 = 0;
        if (param_5 != 0) {
          param_4[6] = 3;
          param_4[7] = 8;
          param_4[8] = uVar6;
        }
        goto LAB_00021c0c;
      }
    }
  }
LAB_00021cc0:
  uVar2 = 0xfffffff8;
LAB_00021c0c:
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(uVar2);
}



void FUN_00021ce0(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                 undefined4 param_5)

{
  int iVar1;
  undefined4 local_60;
  undefined4 local_5c;
  undefined1 auStack_58 [20];
  int local_44;
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,"Bugly-libunwind","looking for IP=0x%lx\n",param_2);
  if (((DAT_0003d0c0 & 1) == 0) ||
     (iVar1 = FUN_00023530(param_1,param_2,param_3,param_4,param_5),
     iVar1 == -1 || iVar1 + 1 < 0 != SCARRY4(iVar1,1))) {
    if ((DAT_0003d0c0 & 4) != 0) {
      __aeabi_memclr8(auStack_58,0x30);
      local_44 = -1;
      local_60 = param_2;
      local_5c = param_3;
      dl_iterate_phdr_wrapper(FUN_00021e58,&local_60);
      if ((local_44 != -1) &&
         (iVar1 = _Uarm_search_unwind_table(param_1,param_2,auStack_58,param_3,param_4,param_5),
         iVar1 != -1 && iVar1 + 1 < 0 == SCARRY4(iVar1,1))) goto LAB_00021e18;
    }
    log2Console(3,"Bugly-libunwind","IP=0x%lx not found\n",param_2);
  }
LAB_00021e18:
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



undefined4 FUN_00021e58(int *param_1,undefined4 param_2,uint *param_3)

{
  int *piVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  int *piVar5;
  int *piVar6;
  int *piVar7;
  
  uVar3 = (uint)*(ushort *)(param_1 + 3);
  if (uVar3 == 0) {
    return 0;
  }
  piVar1 = (int *)param_1[2];
  piVar5 = (int *)0x0;
  piVar6 = (int *)0x0;
  do {
    uVar3 = uVar3 - 1;
    piVar7 = piVar1;
    if ((*piVar1 != 0x70000001) && (piVar7 = piVar6, *piVar1 == 1)) {
      if (((uint)(*param_1 + piVar1[2]) <= *param_3) &&
         (*param_3 < (uint)(piVar1[5] + *param_1 + piVar1[2]))) {
        piVar5 = piVar1;
      }
    }
    piVar1 = piVar1 + 8;
    piVar6 = piVar7;
  } while (0 < (int)uVar3);
  if (piVar5 == (int *)0x0 || piVar7 == (int *)0x0) {
    return 0;
  }
  param_3[7] = 3;
  iVar2 = piVar5[2];
  iVar4 = *param_1;
  param_3[4] = iVar4 + iVar2;
  param_3[5] = piVar5[5] + iVar4 + iVar2;
  param_3[9] = param_1[1];
  param_3[0xc] = *param_1 + piVar7[2];
  param_3[0xb] = piVar7[5];
  return 1;
}



undefined4 _Uarm_get_accessors(undefined4 param_1)

{
  if (DAT_00063738 != 0) {
    return param_1;
  }
  FUN_00025560();
  return param_1;
}



void _Uarm_dwarf_find_debug_frame
               (undefined4 param_1,int param_2,uint param_3,undefined4 param_4,char *param_5,
               uint param_6,uint param_7)

{
  int iVar1;
  undefined4 *puVar2;
  int iVar3;
  int iVar4;
  char *pcVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  uint *puVar13;
  uint uVar14;
  uint *puVar15;
  uint uVar16;
  uint uVar17;
  uint local_a0;
  uint local_9c;
  uint local_98;
  uint local_94;
  uint local_90;
  uint local_8c;
  uint local_70;
  void *local_68;
  uint local_64;
  uint local_60;
  uint local_54;
  undefined4 local_50;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,"Bugly-libunwind","Trying to find .debug_frame for %s\n",param_5);
  iVar1 = _Uarm_local_addr_space;
  puVar15 = (uint *)(_Uarm_local_addr_space + 0x21440);
  for (puVar13 = (uint *)*puVar15; puVar13 != (uint *)0x0; puVar13 = (uint *)puVar13[6]) {
    log2Console(3,"Bugly-libunwind","checking %p: %lx-%lx\n",puVar13,*puVar13,puVar13[1]);
    if ((*puVar13 <= param_3) && (param_3 < puVar13[1])) goto LAB_000220d4;
  }
  pcVar5 = param_5;
  if ((*param_5 == '\0') &&
     ((iVar4 = FUN_00027548(*(undefined4 *)(iVar1 + 0x21444),param_3), iVar4 == 0 ||
      (pcVar5 = strdup(*(char **)(iVar4 + 0x14)), pcVar5 == (char *)0x0)))) {
    log2Console(3,"Bugly-libunwind","tried to locate binary for 0x%llx, but no luck\n");
LAB_00022e5c:
    pcVar5 = "couldn\'t load .debug_frame\n";
  }
  else {
    iVar1 = FUN_00023eb4(pcVar5,&local_54,&local_2c,_Uarm_local_addr_space == iVar1);
    puVar13 = (uint *)0x0;
    if (iVar1 == 0) {
      puVar13 = (uint *)malloc(0x1c);
      *puVar13 = param_6;
      puVar13[1] = param_7;
      puVar13[2] = local_54;
      puVar13[3] = local_2c;
      puVar13[4] = 0;
      puVar13[6] = *puVar15;
      *puVar15 = (uint)puVar13;
    }
    if (pcVar5 != param_5) {
      free(pcVar5);
    }
    if (puVar13 == (uint *)0x0) goto LAB_00022e5c;
LAB_000220d4:
    log2Console(3,"Bugly-libunwind","loaded .debug_frame\n");
    uVar8 = puVar13[3];
    if (uVar8 != 0) {
      if (puVar13[4] == 0) {
        uVar14 = puVar13[2];
        iVar1 = _Uarm_get_accessors(_Uarm_local_addr_space);
        local_98 = 0x10;
        local_68 = calloc(0x10,8);
        if ((int)uVar8 < 1) {
          local_64 = 0;
LAB_00022eb0:
          local_68 = realloc(local_68,local_64 << 3);
        }
        else {
          puVar2 = (undefined4 *)(iVar1 + 0xc);
          local_64 = 0;
          local_70 = 0;
          uVar12 = 0;
          local_60 = 0;
          uVar9 = uVar14;
          do {
            iVar4 = _Uarm_local_addr_space;
            iVar3 = (*(code *)*puVar2)(_Uarm_local_addr_space,uVar9 & 0xfffffffc,&local_54,0,0);
            local_90 = local_54;
            uVar10 = uVar9 + 1;
            uVar11 = uVar10;
            if (-1 < iVar3) {
              iVar3 = (*(code *)*puVar2)(iVar4,uVar10 & 0xfffffffc,&local_54,0,0);
              uVar6 = uVar9 + 2;
              uVar11 = uVar6;
              if (-1 < iVar3) {
                local_90 = local_90 >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff);
                local_94 = local_54 >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff);
                if (*(int *)(iVar4 + 0x20) == 0) {
                  local_90 = local_90 & 0xff;
                  local_94 = local_94 << 8;
                }
                else {
                  local_94 = local_94 & 0xff;
                  local_90 = local_90 << 8;
                }
                iVar3 = (*(code *)*puVar2)(iVar4,uVar6 & 0xfffffffc,&local_54,0,0);
                uVar10 = local_54;
                uVar16 = uVar9 + 3;
                uVar11 = uVar16;
                if (-1 < iVar3) {
                  iVar3 = (*(code *)*puVar2)(iVar4,uVar16 & 0xfffffffc,&local_54,0,0);
                  uVar11 = uVar9 + 4;
                  if (-1 < iVar3) {
                    uVar10 = uVar10 >> ((uVar6 - (uVar6 & 0xfffffffc)) * 8 & 0xff);
                    uVar6 = local_54 >> ((uVar16 - (uVar16 & 0xfffffffc)) * 8 & 0xff);
                    if (*(int *)(iVar4 + 0x20) == 0) {
                      local_60 = ((local_94 | local_90) & 0xffff) +
                                 (uVar10 & 0xff | uVar6 << 8) * 0x10000;
                    }
                    else {
                      local_60 = uVar6 & 0xff | (uVar10 & 0xff) << 8 | (local_94 | local_90) << 0x10
                      ;
                    }
                  }
                }
              }
            }
            iVar4 = _Uarm_local_addr_space;
            if (local_60 == 0xffffffff) {
              iVar3 = (*(code *)*puVar2)(_Uarm_local_addr_space,uVar11 & 0xfffffffc,&local_54,0,0);
              local_8c = local_54;
              uVar10 = uVar11 + 1;
              if (iVar3 < 0) {
LAB_00022538:
                local_8c = 0;
                uVar6 = uVar10;
              }
              else {
                iVar3 = (*(code *)*puVar2)(iVar4,uVar10 & 0xfffffffc,&local_54,0,0);
                uVar6 = uVar11 + 2;
                if (iVar3 < 0) {
LAB_00022808:
                  local_8c = 0;
                }
                else {
                  local_8c = local_8c >> ((uVar11 - (uVar11 & 0xfffffffc)) * 8 & 0xff);
                  local_90 = local_54 >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff);
                  if (*(int *)(iVar4 + 0x20) == 0) {
                    local_8c = local_8c & 0xff;
                    local_90 = local_90 << 8;
                  }
                  else {
                    local_90 = local_90 & 0xff;
                    local_8c = local_8c << 8;
                  }
                  iVar3 = (*(code *)*puVar2)(iVar4,uVar6 & 0xfffffffc,&local_54,0,0);
                  uVar10 = local_54;
                  uVar16 = uVar11 + 3;
                  if (-1 < iVar3) {
                    iVar3 = (*(code *)*puVar2)(iVar4,uVar16 & 0xfffffffc,&local_54,0,0);
                    uVar17 = uVar11 + 4;
                    if (iVar3 < 0) {
                      local_8c = 0;
                      uVar6 = uVar17;
                      goto LAB_0002282c;
                    }
                    uVar10 = uVar10 >> ((uVar6 - (uVar6 & 0xfffffffc)) * 8 & 0xff);
                    uVar6 = local_54 >> ((uVar16 - (uVar16 & 0xfffffffc)) * 8 & 0xff);
                    if (*(int *)(iVar4 + 0x20) == 0) {
                      local_8c = ((local_90 | local_8c) & 0xffff) +
                                 (uVar10 & 0xff | uVar6 << 8) * 0x10000;
                    }
                    else {
                      local_8c = uVar6 & 0xff | (uVar10 & 0xff) << 8 | (local_90 | local_8c) << 0x10
                      ;
                    }
                    iVar3 = (*(code *)*puVar2)(iVar4,uVar17 & 0xfffffffc,&local_54,0,0);
                    local_94 = local_54;
                    uVar16 = uVar11 + 5;
                    if (-1 < iVar3) {
                      iVar3 = (*(code *)*puVar2)(iVar4,uVar16 & 0xfffffffc,&local_54,0,0);
                      uVar7 = uVar11 + 6;
                      uVar6 = uVar7;
                      if (-1 < iVar3) {
                        local_9c = local_54 >> ((uVar16 - (uVar16 & 0xfffffffc)) * 8 & 0xff);
                        local_94 = local_94 >> ((uVar17 - (uVar17 & 0xfffffffc)) * 8 & 0xff);
                        if (*(int *)(iVar4 + 0x20) == 0) {
                          local_94 = local_94 & 0xff;
                          local_9c = local_9c << 8;
                        }
                        else {
                          local_9c = local_9c & 0xff;
                          local_94 = local_94 << 8;
                        }
                        iVar3 = (*(code *)*puVar2)(iVar4,uVar7 & 0xfffffffc,&local_54,0,0);
                        uVar16 = local_54;
                        uVar10 = uVar11 + 7;
                        if (iVar3 < 0) goto LAB_00022538;
                        iVar3 = (*(code *)*puVar2)(iVar4,uVar10 & 0xfffffffc,&local_54,0,0);
                        uVar6 = uVar11 + 8;
                        if (-1 < iVar3) {
                          if (*(int *)(iVar4 + 0x20) != 0) {
                            local_8c = local_54 >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff) &
                                       0xff | (uVar16 >> ((uVar7 - (uVar7 & 0xfffffffc)) * 8 & 0xff)
                                              & 0xff) << 8 | (local_9c | local_94) << 0x10;
                          }
                          goto LAB_0002282c;
                        }
                      }
                      goto LAB_00022808;
                    }
                  }
                  local_8c = 0;
                  uVar6 = uVar16;
                }
              }
LAB_0002282c:
              iVar4 = _Uarm_local_addr_space;
              iVar3 = (*(code *)*puVar2)(_Uarm_local_addr_space,uVar6 & 0xfffffffc,&local_54,0,0);
              local_94 = local_54;
              uVar11 = local_8c + uVar6;
              if (iVar3 < 0) {
                uVar10 = 0xffffffff;
              }
              else {
                uVar10 = uVar6 + 1 & 0xfffffffc;
                iVar3 = (*(code *)*puVar2)(iVar4,uVar10,&local_54,0,0);
                if (-1 < iVar3) {
                  local_94 = local_94 >> ((uVar6 - (uVar6 & 0xfffffffc)) * 8 & 0xff);
                  local_9c = local_54 >> (((uVar6 + 1) - uVar10) * 8 & 0xff);
                  if (*(int *)(iVar4 + 0x20) == 0) {
                    local_94 = local_94 & 0xff;
                    local_9c = local_9c << 8;
                  }
                  else {
                    local_9c = local_9c & 0xff;
                    local_94 = local_94 << 8;
                  }
                  uVar16 = uVar6 + 2 & 0xfffffffc;
                  iVar3 = (*(code *)*puVar2)(iVar4,uVar16,&local_54,0,0);
                  uVar10 = local_54;
                  if (-1 < iVar3) {
                    uVar17 = uVar6 + 3 & 0xfffffffc;
                    iVar3 = (*(code *)*puVar2)(iVar4,uVar17,&local_54,0,0);
                    if (-1 < iVar3) {
                      uVar10 = uVar10 >> (((uVar6 + 2) - uVar16) * 8 & 0xff);
                      uVar16 = local_54 >> (((uVar6 + 3) - uVar17) * 8 & 0xff);
                      if (*(int *)(iVar4 + 0x20) == 0) {
                        uVar10 = ((local_9c | local_94) & 0xffff) +
                                 (uVar10 & 0xff | uVar16 << 8) * 0x10000;
                      }
                      else {
                        uVar10 = uVar16 & 0xff | (uVar10 & 0xff) << 8 |
                                 (local_9c | local_94) << 0x10;
                      }
                      uVar16 = uVar6 + 4 & 0xfffffffc;
                      iVar3 = (*(code *)*puVar2)(iVar4,uVar16,&local_54,0,0);
                      local_94 = local_54;
                      if (-1 < iVar3) {
                        uVar17 = uVar6 + 5 & 0xfffffffc;
                        iVar3 = (*(code *)*puVar2)(iVar4,uVar17,&local_54,0,0);
                        if (-1 < iVar3) {
                          local_94 = local_94 >> (((uVar6 + 4) - uVar16) * 8 & 0xff);
                          local_a0 = local_54 >> (((uVar6 + 5) - uVar17) * 8 & 0xff);
                          if (*(int *)(iVar4 + 0x20) == 0) {
                            local_94 = local_94 & 0xff;
                            local_a0 = local_a0 << 8;
                          }
                          else {
                            local_a0 = local_a0 & 0xff;
                            local_94 = local_94 << 8;
                          }
                          uVar17 = uVar6 + 6 & 0xfffffffc;
                          iVar3 = (*(code *)*puVar2)(iVar4,uVar17,&local_54,0,0);
                          uVar16 = local_54;
                          if (-1 < iVar3) {
                            uVar7 = uVar6 + 7 & 0xfffffffc;
                            iVar3 = (*(code *)*puVar2)(iVar4,uVar7,&local_54,0,0);
                            if (-1 < iVar3) {
                              uVar16 = uVar16 >> (((uVar6 + 6) - uVar17) * 8 & 0xff) & 0xff;
                              uVar12 = local_54 >> (((uVar6 + 7) - uVar7) * 8 & 0xff);
                              if (*(int *)(iVar4 + 0x20) == 0) {
                                local_70 = ((local_a0 | local_94) & 0xffff) +
                                           (uVar16 | uVar12 << 8) * 0x10000;
                                uVar12 = uVar10;
                              }
                              else {
                                uVar12 = uVar12 & 0xff | uVar16 << 8 | (local_a0 | local_94) << 0x10
                                ;
                                local_70 = uVar10;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                uVar10 = 0xffffffff;
              }
            }
            else {
              if (local_60 == 0) break;
              local_70 = 0;
              iVar3 = (*(code *)*puVar2)(_Uarm_local_addr_space,uVar11 & 0xfffffffc,&local_54,0,0);
              local_8c = local_54;
              uVar12 = 0;
              if (-1 < iVar3) {
                uVar10 = uVar11 + 1 & 0xfffffffc;
                uVar12 = 0;
                iVar3 = (*(code *)*puVar2)(iVar4,uVar10,&local_54,0,0);
                if (-1 < iVar3) {
                  local_8c = local_8c >> ((uVar11 - (uVar11 & 0xfffffffc)) * 8 & 0xff);
                  local_90 = local_54 >> (((uVar11 + 1) - uVar10) * 8 & 0xff);
                  if (*(int *)(iVar4 + 0x20) == 0) {
                    local_8c = local_8c & 0xff;
                    local_90 = local_90 << 8;
                  }
                  else {
                    local_90 = local_90 & 0xff;
                    local_8c = local_8c << 8;
                  }
                  uVar6 = uVar11 + 2 & 0xfffffffc;
                  uVar12 = 0;
                  iVar3 = (*(code *)*puVar2)(iVar4,uVar6,&local_54,0,0);
                  uVar10 = local_54;
                  if (-1 < iVar3) {
                    uVar16 = uVar11 + 3 & 0xfffffffc;
                    uVar12 = 0;
                    iVar3 = (*(code *)*puVar2)(iVar4,uVar16,&local_54,0,0);
                    if (-1 < iVar3) {
                      uVar10 = uVar10 >> (((uVar11 + 2) - uVar6) * 8 & 0xff);
                      uVar12 = local_54 >> (((uVar11 + 3) - uVar16) * 8 & 0xff);
                      if (*(int *)(iVar4 + 0x20) == 0) {
                        uVar12 = ((local_90 | local_8c) & 0xffff) +
                                 (uVar10 & 0xff | uVar12 << 8) * 0x10000;
                      }
                      else {
                        uVar12 = uVar12 & 0xff | (uVar10 & 0xff) << 8 |
                                 (local_90 | local_8c) << 0x10;
                      }
                    }
                  }
                }
              }
              uVar10 = 0;
              uVar11 = local_60 + uVar11;
            }
            if ((uVar12 != 0xffffffff || local_70 != uVar10) &&
               (local_2c = uVar9,
               iVar4 = FUN_00027580(_Uarm_local_addr_space,iVar1,&local_2c,&local_54,0,uVar14,0),
               iVar4 == 0)) {
              log2Console(3,"Bugly-libunwind","start_ip = %lx, end_ip = %lx\n",local_54,local_50);
              uVar10 = local_54;
              if (local_64 == local_98) {
                local_68 = realloc(local_68,local_64 << 4);
                local_98 = local_64 << 1;
              }
              puVar15 = (uint *)((int)local_68 + local_64 * 8);
              *puVar15 = uVar10;
              local_64 = local_64 + 1;
              puVar15[1] = uVar9 - uVar14;
            }
            uVar9 = uVar11;
          } while (uVar11 < uVar14 + uVar8);
          if (local_64 < local_98) goto LAB_00022eb0;
        }
        qsort(local_68,local_64,8,(__compar_fn_t)&LAB_00022fd0);
        puVar13[4] = (uint)local_68;
        puVar13[5] = local_64;
      }
      *(undefined4 *)(param_2 + 0x14) = 1;
      *(uint *)(param_2 + 8) = *puVar13;
      *(uint *)(param_2 + 0xc) = puVar13[1];
      *(char **)(param_2 + 0x1c) = param_5;
      *(undefined4 *)(param_2 + 0x20) = param_4;
      *(undefined4 *)(param_2 + 0x24) = 7;
      *(uint **)(param_2 + 0x28) = puVar13;
      log2Console(3,"Bugly-libunwind",
                  "found debug_frame table `%s\': segbase=0x%lx, len=%lu, gp=0x%lx, table_data=0x%lx\n"
                  ,param_5,param_4,7,*(undefined4 *)(param_2 + 0x10),puVar13);
      goto LAB_00022f40;
    }
    pcVar5 = "zero-length .debug_frame\n";
  }
  log2Console(3,"Bugly-libunwind",pcVar5);
LAB_00022f40:
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void FUN_00022fec(int *param_1,uint param_2,uint *param_3)

{
  bool bVar1;
  int iVar2;
  uint uVar3;
  uint *puVar4;
  undefined4 uVar5;
  uint *puVar6;
  undefined4 uVar7;
  uint *puVar8;
  uint uVar9;
  int *piVar10;
  char *pcVar11;
  int *piVar12;
  uint uVar13;
  uint uVar14;
  int *piVar15;
  int *piVar16;
  char *pcVar17;
  int iVar18;
  int *piVar19;
  uint uVar20;
  uint uVar21;
  uint local_38;
  uint local_34;
  char *local_30;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar2 = -1;
  if (param_2 < 0xe) goto LAB_00023484;
  uVar3 = (uint)*(ushort *)(param_1 + 3);
  if (uVar3 != 0) {
    puVar8 = (uint *)param_3[1];
    uVar21 = *param_3;
    iVar18 = *param_1;
    piVar19 = (int *)0x0;
    piVar12 = (int *)param_1[2];
    uVar20 = 0;
    uVar9 = param_3[2];
    piVar10 = (int *)0x0;
    piVar15 = (int *)0x0;
    do {
      iVar2 = *piVar12;
      uVar3 = uVar3 - 1;
      piVar16 = piVar15;
      if (iVar2 == 1) {
        uVar13 = piVar12[2] + iVar18;
        if ((uVar13 <= uVar21) && (uVar21 < piVar12[5] + uVar13)) {
          piVar19 = piVar12;
        }
        if (uVar20 < piVar12[4] + uVar13) {
          uVar20 = piVar12[4] + uVar13;
        }
      }
      else {
        piVar16 = piVar12;
        if ((iVar2 != 2) && (piVar16 = piVar15, iVar2 == 0x6474e550)) {
          piVar10 = piVar12;
        }
      }
      piVar12 = piVar12 + 8;
      piVar15 = piVar16;
    } while (0 < (int)uVar3);
    if (piVar19 != (int *)0x0) {
      bVar1 = false;
      if (piVar10 != (int *)0x0) {
        if (piVar16 == (int *)0x0) {
          param_3[8] = 0;
        }
        else {
          for (puVar4 = (uint *)(piVar16[2] + iVar18 + 4); puVar4[-1] != 0; puVar4 = puVar4 + 2) {
            if (puVar4[-1] == 3) {
              param_3[8] = *puVar4;
              break;
            }
          }
        }
        puVar8[4] = param_3[8];
        pcVar17 = (char *)(piVar10[2] + iVar18);
        if (*pcVar17 != '\x01') {
          log2Console(3,"Bugly-libunwind","table `%s\' has unexpected version %d\n",param_1[1],
                      *pcVar17);
          iVar2 = 0;
          goto LAB_00023484;
        }
        uVar5 = _Uarm_get_accessors(_Uarm_local_addr_space);
        local_30 = pcVar17 + 4;
        iVar2 = FUN_000244d4(_Uarm_local_addr_space,uVar5,&local_30,pcVar17[1],puVar8,&local_34,0);
        if ((iVar2 < 0) ||
           (puVar4 = puVar8,
           iVar2 = FUN_000244d4(_Uarm_local_addr_space,uVar5,&local_30,pcVar17[2],puVar8,&local_38,0
                               ), iVar2 < 0)) goto LAB_00023484;
        puVar6 = (uint *)(uint)(byte)pcVar17[3];
        if (puVar6 == (uint *)0x3b) {
          param_3[9] = 2;
          iVar2 = piVar19[2];
          param_3[6] = iVar2 + iVar18;
          param_3[7] = piVar19[5] + iVar2 + iVar18;
          uVar3 = param_1[1];
          uVar20 = (local_38 & 0x1fffffff) << 1;
          param_3[0xb] = uVar3;
          param_3[0xc] = (uint)pcVar17;
          param_3[0xd] = uVar20;
          param_3[0xe] = (uint)local_30;
          log2Console(3,"Bugly-libunwind",
                      "found table `%s\': segbase=0x%lx, len=%lu, gp=0x%lx, table_data=0x%lx\n",
                      uVar3,pcVar17,uVar20,param_3[8],local_30);
          bVar1 = true;
        }
        else {
          if (puVar6 == (uint *)0xff) {
            pcVar11 = "table `%s\' lacks search table; doing linear search\n";
          }
          else {
            pcVar11 = "table `%s\' has encoding 0x%x; doing linear search\n";
            puVar4 = puVar6;
          }
          log2Console(3,"Bugly-libunwind",pcVar11,param_1[1],puVar4);
          if (pcVar17[2] == -1) {
            local_38 = 0xffffffff;
          }
          uVar3 = local_38;
          if (pcVar17[1] == -1) {
                    // WARNING: Subroutine does not return
            abort();
          }
          param_3[3] = 1;
          uVar5 = _Uarm_local_addr_space;
          uVar7 = _Uarm_get_accessors(_Uarm_local_addr_space);
          local_2c = local_34;
          if (uVar3 == 0) {
            iVar2 = -10;
          }
          else {
            if (local_34 < uVar20) {
              uVar14 = 0;
              uVar13 = local_34;
              do {
                iVar2 = FUN_00027580(uVar5,uVar7,&local_2c,puVar8,0,0,0);
                if (iVar2 < 0) goto LAB_000233ec;
                if ((*puVar8 <= uVar21) && (uVar21 < puVar8[1])) {
                  if (uVar9 == 0) {
                    iVar2 = 1;
                  }
                  else {
                    local_2c = uVar13;
                    iVar2 = FUN_00027580(uVar5,uVar7,&local_2c,puVar8,uVar9,0,0);
                    if (-1 < iVar2) {
                      iVar2 = 1;
                    }
                  }
                  goto LAB_000233ec;
                }
                uVar14 = uVar14 + 1;
                if (uVar14 < uVar3) {
                  uVar13 = local_2c;
                }
              } while (uVar14 < uVar3 && uVar13 < uVar20);
            }
            iVar2 = -10;
          }
LAB_000233ec:
          bVar1 = iVar2 == 1;
        }
      }
      uVar3 = 0xffffffff;
      if (*(ushort *)(param_1 + 3) == 0) {
        uVar20 = 0;
      }
      else {
        uVar20 = 0;
        uVar9 = 0;
        do {
          if (*(int *)(param_1[2] + uVar9 * 0x20) == 1) {
            iVar2 = param_1[2] + uVar9 * 0x20;
            uVar14 = *(int *)(iVar2 + 8) + *param_1;
            uVar13 = uVar14 + *(int *)(iVar2 + 0x14);
            if (uVar20 < uVar13) {
              uVar20 = uVar13;
            }
            if (uVar14 < uVar3) {
              uVar3 = uVar14;
            }
          }
          uVar9 = uVar9 + 1;
        } while (uVar9 < *(ushort *)(param_1 + 3));
      }
      iVar2 = _Uarm_dwarf_find_debug_frame
                        (bVar1,param_3 + 0x10,uVar21,*param_1,param_1[1],uVar3,uVar20);
      goto LAB_00023484;
    }
  }
  iVar2 = 0;
LAB_00023484:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar2);
  }
  return;
}



void FUN_00023530(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                 undefined4 param_5)

{
  int iVar1;
  undefined4 local_98;
  undefined4 uStack_94;
  undefined4 uStack_90;
  int local_8c;
  undefined1 auStack_88 [20];
  int local_74;
  undefined1 auStack_58 [20];
  int local_44;
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,"Bugly-libunwind","looking for IP=0x%lx\n",param_2);
  __aeabi_memclr4(&local_8c,100);
  local_74 = -1;
  local_44 = -1;
  local_98 = param_2;
  uStack_94 = param_3;
  uStack_90 = param_4;
  iVar1 = dl_iterate_phdr_wrapper(FUN_00022fec,&local_98);
  if (iVar1 < 1) {
    log2Console(3,"Bugly-libunwind","IP=0x%lx not found\n",param_2);
  }
  else {
    iVar1 = 0;
    if ((local_8c != 0) ||
       ((local_74 != -1 &&
        (iVar1 = _Uarm_dwarf_search_unwind_table(param_1,param_2,auStack_88,param_3,param_4,param_5)
        , iVar1 != -10)))) goto LAB_0002363c;
    if (local_44 != -1) {
      iVar1 = _Uarm_dwarf_search_unwind_table(param_1,param_2,auStack_58,param_3,param_4,param_5);
      goto LAB_0002363c;
    }
  }
  iVar1 = -10;
LAB_0002363c:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar1);
  }
  return;
}



void _Uarm_dwarf_search_unwind_table
               (int param_1,uint param_2,int param_3,uint *param_4,int param_5,undefined4 param_6)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  uint *puVar13;
  uint uVar14;
  int local_78;
  uint local_54;
  uint local_48;
  uint local_44;
  uint local_40;
  uint local_34;
  uint local_30;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  piVar1 = (int *)(param_3 + 0x28);
  if (*(int *)(param_3 + 0x14) == 2) {
    uVar14 = *(int *)(param_3 + 0x24) << 2;
    local_78 = 0;
  }
  else {
    iVar2 = *piVar1;
    local_78 = *(int *)(iVar2 + 8);
    piVar1 = (int *)(iVar2 + 0x10);
    uVar14 = *(int *)(iVar2 + 0x14) << 3;
    param_1 = _Uarm_local_addr_space;
  }
  iVar2 = *piVar1;
  uVar3 = _Uarm_get_accessors(param_1);
  iVar4 = *(int *)(param_3 + 0x20);
  if (param_1 == _Uarm_local_addr_space) {
    uVar11 = 0;
    if (uVar14 >> 3 != 0) {
      uVar14 = uVar14 >> 3;
      do {
        uVar10 = uVar11 + uVar14;
        log2Console(3,"Bugly-libunwind","e->start_ip_offset = %lx\n",
                    *(undefined4 *)(iVar2 + (uVar10 >> 1) * 8));
        if ((int)(param_2 - iVar4) < *(int *)(iVar2 + (uVar10 >> 1) * 8)) {
          uVar14 = uVar10 >> 1;
        }
        else {
          uVar11 = (uVar10 >> 1) + 1;
        }
      } while (uVar11 < uVar14);
      if (uVar14 != 0) {
        puVar13 = (uint *)(iVar2 + uVar14 * 8 + -8);
        uVar14 = *puVar13;
        goto LAB_00023a60;
      }
    }
  }
  else {
    iVar5 = _Uarm_get_accessors(param_1);
    uVar11 = 0;
    if (uVar14 >> 3 != 0) {
      uVar14 = uVar14 >> 3;
      do {
        uVar10 = uVar11 + uVar14 >> 1;
        uVar8 = iVar2 + uVar10 * 8;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar8 & 0xfffffffc,&local_34,0,param_6);
        local_40 = local_34;
        if (iVar6 < 0) goto LAB_00023e44;
        uVar7 = uVar8 + 1 & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar7,&local_34,0,param_6);
        if (iVar6 < 0) goto LAB_00023e44;
        local_40 = local_40 >> ((uVar8 - (uVar8 & 0xfffffffc)) * 8 & 0xff);
        local_54 = local_34 >> (((uVar8 + 1) - uVar7) * 8 & 0xff);
        if (*(int *)(param_1 + 0x20) == 0) {
          local_40 = local_40 & 0xff;
          local_54 = local_54 << 8;
        }
        else {
          local_54 = local_54 & 0xff;
          local_40 = local_40 << 8;
        }
        uVar12 = uVar8 + 2 & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar12,&local_34,0,param_6);
        uVar7 = local_34;
        if (iVar6 < 0) goto LAB_00023e44;
        uVar9 = uVar8 + 3 & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar9,&local_34,0,param_6);
        if (iVar6 < 0) goto LAB_00023e44;
        uVar7 = uVar7 >> (((uVar8 + 2) - uVar12) * 8 & 0xff);
        uVar8 = local_34 >> (((uVar8 + 3) - uVar9) * 8 & 0xff);
        if (*(int *)(param_1 + 0x20) == 0) {
          uVar8 = ((local_54 | local_40) & 0xffff) + (uVar7 & 0xff | uVar8 << 8) * 0x10000;
        }
        else {
          uVar8 = (local_54 | local_40) << 0x10 | (uVar7 & 0xff) << 8 | uVar8 & 0xff;
        }
        if ((int)uVar8 <= (int)(param_2 - iVar4)) {
          uVar11 = uVar10 + 1;
          uVar10 = uVar14;
        }
        uVar14 = uVar10;
      } while (uVar11 < uVar10);
      if (uVar10 != 0) {
        iVar2 = iVar2 + uVar10 * 8;
        uVar11 = iVar2 - 8U & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar11,&local_34,0,param_6);
        uVar14 = local_34;
        if (iVar6 < 0) goto LAB_00023e44;
        uVar10 = iVar2 - 7U & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar10,&local_34,0,param_6);
        if (iVar6 < 0) goto LAB_00023e44;
        local_44 = local_34 >> (((iVar2 - 7U) - uVar10) * 8 & 0xff);
        uVar14 = uVar14 >> (((iVar2 - 8U) - uVar11) * 8 & 0xff);
        if (*(int *)(param_1 + 0x20) == 0) {
          uVar14 = uVar14 & 0xff;
          local_44 = local_44 << 8;
        }
        else {
          local_44 = local_44 & 0xff;
          uVar14 = uVar14 << 8;
        }
        uVar10 = iVar2 - 6U & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar10,&local_34,0,param_6);
        uVar11 = local_34;
        if (iVar6 < 0) goto LAB_00023e44;
        uVar8 = iVar2 - 5U & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar8,&local_34,0,param_6);
        if (iVar6 < 0) goto LAB_00023e44;
        uVar11 = uVar11 >> (((iVar2 - 6U) - uVar10) * 8 & 0xff);
        local_34 = local_34 >> (((iVar2 - 5U) - uVar8) * 8 & 0xff);
        if (*(int *)(param_1 + 0x20) == 0) {
          uVar14 = ((local_44 | uVar14) & 0xffff) + (uVar11 & 0xff | local_34 << 8) * 0x10000;
        }
        else {
          uVar14 = (local_44 | uVar14) << 0x10 | (uVar11 & 0xff) << 8 | local_34 & 0xff;
        }
        uVar11 = iVar2 - 4U & 0xfffffffc;
        local_34 = uVar14;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar11,&local_2c,0,param_6);
        local_44 = local_2c;
        if (iVar6 < 0) goto LAB_00023e44;
        uVar10 = iVar2 - 3U & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar10,&local_2c,0,param_6);
        if (iVar6 < 0) goto LAB_00023e44;
        local_44 = local_44 >> (((iVar2 - 4U) - uVar11) * 8 & 0xff);
        local_48 = local_2c >> (((iVar2 - 3U) - uVar10) * 8 & 0xff);
        if (*(int *)(param_1 + 0x20) == 0) {
          local_44 = local_44 & 0xff;
          local_48 = local_48 << 8;
        }
        else {
          local_48 = local_48 & 0xff;
          local_44 = local_44 << 8;
        }
        uVar10 = iVar2 - 2U & 0xfffffffc;
        iVar6 = (**(code **)(iVar5 + 0xc))(param_1,uVar10,&local_2c,0,param_6);
        uVar11 = local_2c;
        if (iVar6 < 0) goto LAB_00023e44;
        uVar8 = iVar2 - 1U & 0xfffffffc;
        iVar5 = (**(code **)(iVar5 + 0xc))(param_1,uVar8,&local_2c,0,param_6);
        if (iVar5 < 0) goto LAB_00023e44;
        puVar13 = &local_34;
        uVar11 = uVar11 >> (((iVar2 - 2U) - uVar10) * 8 & 0xff);
        local_2c = local_2c >> (((iVar2 - 1U) - uVar8) * 8 & 0xff);
        if (*(int *)(param_1 + 0x20) == 0) {
          local_30 = ((local_48 | local_44) & 0xffff) + (uVar11 & 0xff | local_2c << 8) * 0x10000;
        }
        else {
          local_30 = (local_48 | local_44) << 0x10 | (uVar11 & 0xff) << 8 | local_2c & 0xff;
        }
LAB_00023a60:
        log2Console(3,"Bugly-libunwind","ip=0x%lx, start_ip=0x%lx\n",param_2,uVar14);
        iVar2 = local_78;
        if (local_78 == 0) {
          iVar2 = iVar4;
        }
        local_2c = puVar13[1] + iVar2;
        log2Console(3,"Bugly-libunwind",
                    "e->fde_offset = %lx, segbase = %lx, debug_frame_base = %lx, fde_addr = %lx\n",
                    puVar13[1],iVar4,local_78,local_2c);
        iVar2 = FUN_00027580(param_1,uVar3,&local_2c,param_4,param_5,local_78,param_6);
        if (-1 < iVar2) {
          uVar14 = *param_4;
          if (*(int *)(param_3 + 0x14) == 1) {
            uVar14 = uVar14 + iVar4;
            *param_4 = uVar14;
            param_4[5] = 0x20;
            param_4[1] = param_4[1] + iVar4;
          }
          if ((param_2 < uVar14) || (param_4[1] <= param_2)) {
            if (param_5 != 0) {
              param_2 = param_4[8];
            }
            if ((param_5 != 0 && param_2 != 0) && (param_4[6] == 1)) {
              FUN_0002728c(&DAT_000636d8);
              param_4[8] = 0;
            }
          }
        }
        goto LAB_00023e44;
      }
    }
  }
  log2Console(3,"Bugly-libunwind","IP %lx inside range %lx-%lx, but no explicit unwind info found\n"
              ,param_2,*(undefined4 *)(param_3 + 8),*(undefined4 *)(param_3 + 0xc));
LAB_00023e44:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void FUN_00023eb4(char *param_1,int *param_2,size_t *param_3,int param_4)

{
  FILE *__stream;
  size_t sVar1;
  void *__ptr;
  size_t sVar2;
  int iVar3;
  size_t sVar4;
  void *pvVar5;
  char *__src;
  char *__dest;
  char *pcVar6;
  size_t sVar7;
  char *pcVar8;
  void *__ptr_00;
  size_t *psVar9;
  uint __nmemb;
  uint uVar10;
  char *__s;
  uint uVar11;
  long lVar12;
  undefined1 auStack_5c [32];
  long local_3c;
  ushort local_2c;
  ushort local_2a;
  int local_28;
  
  __s = (char *)0x0;
  local_28 = __stack_chk_guard;
  *param_2 = 0;
  *param_3 = 0;
  __stream = fopen(param_1,"r");
  if (__stream == (FILE *)0x0) goto LAB_00024238;
  sVar1 = fread(auStack_5c,0x34,1,__stream);
  __ptr = (void *)0x0;
  __ptr_00 = (void *)0x0;
  if (sVar1 == 1) {
    lVar12 = local_3c;
    log2Console(3,"Bugly-libunwind","opened file \'%s\'. Section header at offset %d\n",param_1,
                local_3c);
    __s = (char *)0x0;
    fseek(__stream,local_3c,0);
    __nmemb = (uint)local_2c;
    __ptr_00 = calloc(__nmemb,0x28);
    if (__ptr_00 == (void *)0x0) {
      __ptr_00 = (void *)0x0;
    }
    else {
      sVar1 = fread(__ptr_00,0x28,__nmemb,__stream);
      if (sVar1 == __nmemb) {
        sVar1 = *(size_t *)((int)__ptr_00 + (uint)local_2a * 0x28 + 0x14);
        log2Console(3,"Bugly-libunwind","loading string table of size %ld\n",sVar1,lVar12);
        __ptr = malloc(sVar1);
        __s = (char *)0x0;
        fseek(__stream,*(long *)((int)__ptr_00 + (uint)local_2a * 0x28 + 0x10),0);
        if (__ptr == (void *)0x0) {
          __ptr = (void *)0x0;
        }
        else {
          sVar2 = fread(__ptr,1,sVar1,__stream);
          if (sVar2 == sVar1) {
            __s = (char *)0x0;
            sVar2 = 0;
            if (1 < __nmemb) {
              sVar2 = 0;
              uVar11 = 1;
              __s = (char *)0x0;
              psVar9 = (size_t *)((int)__ptr_00 + 0x3c);
              do {
                if (*param_2 != 0) break;
                uVar10 = psVar9[-5];
                if (uVar10 < sVar1) {
                  if ((sVar1 < uVar10 + 0xd) ||
                     (iVar3 = strcmp((char *)((int)__ptr + uVar10),".debug_frame"), iVar3 != 0)) {
                    if ((uVar10 + 0xf <= sVar1) &&
                       (iVar3 = strcmp((char *)((int)__ptr + uVar10),".gnu_debuglink"), iVar3 == 0))
                    {
                      sVar2 = *psVar9;
                      __s = (char *)malloc(sVar2);
                      sVar7 = psVar9[-1];
                      fseek(__stream,sVar7,0);
                      if (__s == (char *)0x0) {
                        __s = (char *)0x0;
                        goto LAB_0002420c;
                      }
                      sVar4 = fread(__s,1,sVar2,__stream);
                      if (sVar4 != sVar2) goto LAB_0002420c;
                      log2Console(3,"Bugly-libunwind",
                                  "read %zd bytes of .gnu_debuglink from offset %ld\n",sVar2,sVar7);
                    }
                  }
                  else {
                    sVar7 = *psVar9;
                    *param_3 = sVar7;
                    pvVar5 = malloc(sVar7);
                    *param_2 = (int)pvVar5;
                    sVar7 = psVar9[-1];
                    fseek(__stream,sVar7,0);
                    if (((void *)*param_2 == (void *)0x0) ||
                       (sVar4 = fread((void *)*param_2,1,*param_3,__stream), sVar4 != *param_3))
                    goto LAB_0002420c;
                    log2Console(3,"Bugly-libunwind",
                                "read %zd bytes of .debug_frame from offset %ld\n",sVar4,sVar7);
                  }
                }
                uVar11 = uVar11 + 1;
                psVar9 = psVar9 + 10;
              } while (uVar11 < __nmemb);
            }
            free(__ptr);
            free(__ptr_00);
            fclose(__stream);
            if ((param_4 == -1) && (__s != (char *)0x0)) {
              free(__s);
              goto LAB_00024238;
            }
            if (((__s != (char *)0x0) && (*param_2 == 0)) &&
               (pvVar5 = memchr(__s,0,sVar2), pvVar5 != (void *)0x0)) {
              sVar1 = strlen(param_1);
              __src = (char *)malloc(sVar1 + 1);
              sVar2 = strlen(__s);
              __dest = (char *)malloc(sVar1 + sVar2 + 0x17);
              if ((__src == (char *)0x0) || (__dest == (char *)0x0)) goto LAB_0002420c;
              pcVar6 = strrchr(param_1,0x2f);
              pcVar8 = __src;
              if (pcVar6 != (char *)0x0) {
                __aeabi_memcpy(__src,param_1,(int)pcVar6 - (int)param_1);
                pcVar8 = __src + ((int)pcVar6 - (int)param_1);
              }
              *pcVar8 = '\0';
              pcVar8 = strcpy(__dest,__src);
              sVar1 = strlen(pcVar8);
              (__dest + sVar1)[0] = '/';
              (__dest + sVar1)[1] = '\0';
              pcVar8 = strcat(__dest,__s);
              iVar3 = FUN_00023eb4(pcVar8,param_2,param_3,0xffffffff);
              if (iVar3 == 1) {
                pcVar8 = strcpy(__dest,__src);
                sVar1 = strlen(pcVar8);
                builtin_strncpy(__dest + sVar1,"/.debug/",9);
                pcVar8 = strcat(__dest,__s);
                iVar3 = FUN_00023eb4(pcVar8,param_2,param_3,0xffffffff);
                if (param_4 == 1 && iVar3 == 1) {
                  __aeabi_memcpy(__dest,"/usr/lib/debug",0xf);
                  pcVar8 = strcat(__dest,__src);
                  sVar1 = strlen(pcVar8);
                  (__dest + sVar1)[0] = '/';
                  (__dest + sVar1)[1] = '\0';
                  pcVar8 = strcat(__dest,__s);
                  FUN_00023eb4(pcVar8,param_2,param_3,0xffffffff);
                }
              }
              free(__src);
              free(__dest);
            }
            free(__s);
            goto LAB_00024238;
          }
        }
        goto LAB_0002420c;
      }
    }
    __ptr = (void *)0x0;
  }
LAB_0002420c:
  free(__ptr);
  free(__ptr_00);
  free(__s);
  free((void *)*param_2);
  fclose(__stream);
LAB_00024238:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void FUN_000244d4(int param_1,int param_2,uint *param_3,uint param_4,int *param_5,uint *param_6,
                 undefined4 param_7)

{
  ushort uVar1;
  int iVar2;
  ushort uVar3;
  char *pcVar4;
  uint uVar5;
  uint uVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  int iVar12;
  uint local_4c;
  uint local_48;
  uint local_44;
  uint local_3c;
  uint local_38;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar8 = *param_3;
  if (param_4 == 0x50) {
    uVar8 = uVar8 + 3 & 0xfffffffc;
    *param_3 = uVar8 | 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar8,&local_2c,0,param_7);
    uVar8 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar8 = uVar8 & 0xff;
      uVar5 = uVar5 << 8;
    }
    else {
      uVar5 = uVar5 & 0xff;
      uVar8 = uVar8 << 8;
    }
    uVar9 = *param_3;
    *param_3 = uVar9 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9 & 0xfffffffc,&local_2c,0,param_7);
    uVar10 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar7 = *param_3;
    *param_3 = uVar7 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar7 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    local_2c = local_2c >> ((uVar7 - (uVar7 & 0xfffffffc)) * 8 & 0xff);
    uVar10 = uVar10 >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar8 = ((uVar5 | uVar8) & 0xffff) + (uVar10 & 0xff | local_2c << 8) * 0x10000;
    }
    else {
      uVar8 = (uVar5 | uVar8) << 0x10 | (uVar10 & 0xff) << 8 | local_2c & 0xff;
    }
    *param_6 = uVar8;
    goto LAB_00024ec0;
  }
  if (param_4 == 0xff) goto LAB_0002451c;
  uVar5 = param_4 & 0xf;
  switch(uVar5) {
  case 0:
  case 3:
  case 0xb:
    *param_3 = uVar8 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar8 & 0xfffffffc,&local_2c,0,param_7);
    local_44 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    local_48 = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    local_44 = local_44 >> ((uVar8 - (uVar8 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_44 = local_44 & 0xff;
      local_48 = local_48 << 8;
    }
    else {
      local_48 = local_48 & 0xff;
      local_44 = local_44 << 8;
    }
    uVar10 = *param_3;
    *param_3 = uVar10 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10 & 0xfffffffc,&local_2c,0,param_7);
    uVar5 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar9 = *param_3;
    *param_3 = uVar9 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = uVar5 >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff);
    uVar10 = local_2c >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar5 = ((local_48 | local_44) & 0xffff) + (uVar5 & 0xff | uVar10 << 8) * 0x10000;
    }
    else {
      uVar5 = (local_48 | local_44) << 0x10 | (uVar5 & 0xff) << 8 | uVar10 & 0xff;
    }
    break;
  case 1:
    *param_3 = uVar8 + 1;
    uVar10 = uVar8 & 0xfffffffc;
    uVar9 = 0;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10,&local_2c,0,param_7);
    if (-1 < iVar2) {
      uVar5 = 0;
      uVar7 = uVar8;
      do {
        uVar10 = (uVar7 - uVar10) * 8;
        uVar5 = uVar5 | (local_2c >> (uVar10 & 0xff) & 0x7f) << (uVar9 & 0xff);
        if ((local_2c >> (uVar10 & 0xff) & 0x80) == 0) goto joined_r0x000254a4;
        uVar7 = *param_3;
        *param_3 = uVar7 + 1;
        uVar10 = uVar7 & 0xfffffffc;
        iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10,&local_2c,0,param_7);
        uVar9 = uVar9 + 7;
      } while (-1 < iVar2);
    }
    goto LAB_00024ec4;
  case 2:
    *param_3 = uVar8 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar8 & 0xfffffffc,&local_2c,0,param_7);
    uVar10 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar9 = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    uVar10 = uVar10 >> ((uVar8 - (uVar8 & 0xfffffffc)) * 8 & 0xff);
    uVar5 = uVar9 & 0xff | uVar10 << 8;
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar5 = uVar10 & 0xff | uVar9 << 8;
    }
    uVar5 = uVar5 & 0xffff;
    break;
  case 4:
    *param_3 = uVar8 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar8 & 0xfffffffc,&local_2c,0,param_7);
    local_44 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    local_48 = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    local_44 = local_44 >> ((uVar8 - (uVar8 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_44 = local_44 & 0xff;
      local_48 = local_48 << 8;
    }
    else {
      local_48 = local_48 & 0xff;
      local_44 = local_44 << 8;
    }
    uVar10 = *param_3;
    *param_3 = uVar10 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10 & 0xfffffffc,&local_2c,0,param_7);
    uVar5 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar9 = *param_3;
    *param_3 = uVar9 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = uVar5 >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff);
    uVar10 = local_2c >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar5 = ((local_48 | local_44) & 0xffff) + (uVar5 & 0xff | uVar10 << 8) * 0x10000;
    }
    else {
      uVar5 = (local_48 | local_44) << 0x10 | (uVar5 & 0xff) << 8 | uVar10 & 0xff;
    }
    uVar10 = *param_3;
    *param_3 = uVar10 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10 & 0xfffffffc,&local_2c,0,param_7);
    local_48 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar9 = *param_3;
    *param_3 = uVar9 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    local_48 = local_48 >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff);
    local_4c = local_2c >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_48 = local_48 & 0xff;
      local_4c = local_4c << 8;
    }
    else {
      local_4c = local_4c & 0xff;
      local_48 = local_48 << 8;
    }
    uVar9 = *param_3;
    *param_3 = uVar9 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9 & 0xfffffffc,&local_2c,0,param_7);
    uVar10 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar7 = *param_3;
    *param_3 = uVar7 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar7 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    if (*(int *)(param_1 + 0x20) != 0) {
      uVar5 = (local_4c | local_48) << 0x10 |
              (uVar10 >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff) & 0xff) << 8 |
              local_2c >> ((uVar7 - (uVar7 & 0xfffffffc)) * 8 & 0xff) & 0xff;
    }
    break;
  default:
    pcVar4 = "unexpected encoding format 0x%x\n";
    goto LAB_000249ec;
  case 9:
    *param_3 = uVar8 + 1;
    uVar10 = uVar8 & 0xfffffffc;
    uVar9 = 0;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10,&local_2c,0,param_7);
    if (-1 < iVar2) {
      uVar5 = 0;
      uVar7 = uVar8;
      do {
        uVar10 = (uVar7 - uVar10) * 8;
        uVar5 = uVar5 | (local_2c >> (uVar10 & 0xff) & 0x7f) << (uVar9 & 0xff);
        if ((local_2c >> (uVar10 & 0xff) & 0x80) == 0) goto joined_r0x000254a4;
        uVar7 = *param_3;
        *param_3 = uVar7 + 1;
        uVar10 = uVar7 & 0xfffffffc;
        iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10,&local_2c,0,param_7);
        uVar9 = uVar9 + 7;
      } while (-1 < iVar2);
    }
    goto LAB_00024ec4;
  case 10:
    *param_3 = uVar8 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar8 & 0xfffffffc,&local_2c,0,param_7);
    uVar5 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar10 = *param_3;
    *param_3 = uVar10 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar10 = local_2c >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff);
    uVar5 = uVar5 >> ((uVar8 - (uVar8 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar1 = (ushort)uVar5 & 0xff;
      uVar3 = (ushort)(uVar10 << 8);
    }
    else {
      uVar3 = (ushort)uVar10 & 0xff;
      uVar1 = (ushort)(uVar5 << 8);
    }
    uVar5 = (uint)(short)(uVar3 | uVar1);
    break;
  case 0xc:
    *param_3 = uVar8 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar8 & 0xfffffffc,&local_2c,0,param_7);
    local_44 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    local_48 = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    local_44 = local_44 >> ((uVar8 - (uVar8 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_44 = local_44 & 0xff;
      local_48 = local_48 << 8;
    }
    else {
      local_48 = local_48 & 0xff;
      local_44 = local_44 << 8;
    }
    uVar10 = *param_3;
    *param_3 = uVar10 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10 & 0xfffffffc,&local_2c,0,param_7);
    uVar5 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar9 = *param_3;
    *param_3 = uVar9 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar5 = uVar5 >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff);
    uVar10 = local_2c >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar5 = ((local_48 | local_44) & 0xffff) + (uVar5 & 0xff | uVar10 << 8) * 0x10000;
    }
    else {
      uVar5 = (local_48 | local_44) << 0x10 | (uVar5 & 0xff) << 8 | uVar10 & 0xff;
    }
    uVar9 = *param_3;
    *param_3 = uVar9 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9 & 0xfffffffc,&local_2c,0,param_7);
    uVar10 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar7 = *param_3;
    *param_3 = uVar7 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar7 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar11 = *param_3;
    uVar10 = uVar10 >> ((uVar9 - (uVar9 & 0xfffffffc)) * 8 & 0xff);
    uVar9 = local_2c >> ((uVar7 - (uVar7 & 0xfffffffc)) * 8 & 0xff);
    iVar12 = *(int *)(param_1 + 0x20);
    *param_3 = uVar11 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar11 & 0xfffffffc,&local_2c,0,param_7);
    uVar7 = local_2c;
    uVar6 = uVar9 & 0xff | uVar10 << 8;
    if (iVar12 == 0) {
      uVar6 = uVar10 & 0xff | uVar9 << 8;
    }
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar10 = *param_3;
    *param_3 = uVar10 + 1;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10 & 0xfffffffc,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    if (*(int *)(param_1 + 0x20) != 0) {
      uVar5 = uVar6 << 0x10 | (uVar7 >> ((uVar11 - (uVar11 & 0xfffffffc)) * 8 & 0xff) & 0xff) << 8 |
              local_2c >> ((uVar10 - (uVar10 & 0xfffffffc)) * 8 & 0xff) & 0xff;
    }
  }
joined_r0x000254a4:
  if (uVar5 == 0) {
LAB_0002451c:
    iVar2 = 0;
    *param_6 = 0;
    goto LAB_00024ec4;
  }
  switch((param_4 << 0x19) >> 0x1d) {
  case 1:
    uVar5 = uVar5 + uVar8;
    break;
  default:
    uVar5 = param_4 & 0x70;
    pcVar4 = "unexpected application type 0x%x\n";
LAB_000249ec:
    log2Console(3,"Bugly-libunwind",pcVar4,uVar5);
    iVar2 = -8;
    goto LAB_00024ec4;
  case 3:
    uVar5 = param_5[4] + uVar5;
    break;
  case 4:
    uVar5 = *param_5 + uVar5;
  case 0:
  }
  if ((param_4 & 0x80) != 0) {
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_7);
    local_38 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar8 = uVar5 + 1 & 0xfffffffc;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar8,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    local_3c = local_2c >> (((uVar5 + 1) - uVar8) * 8 & 0xff);
    local_38 = local_38 >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_38 = local_38 & 0xff;
      local_3c = local_3c << 8;
    }
    else {
      local_3c = local_3c & 0xff;
      local_38 = local_38 << 8;
    }
    uVar10 = uVar5 + 2 & 0xfffffffc;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar10,&local_2c,0,param_7);
    uVar8 = local_2c;
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar9 = uVar5 + 3 & 0xfffffffc;
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar9,&local_2c,0,param_7);
    if (iVar2 < 0) goto LAB_00024ec4;
    uVar8 = uVar8 >> (((uVar5 + 2) - uVar10) * 8 & 0xff);
    local_2c = local_2c >> (((uVar5 + 3) - uVar9) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar5 = ((local_3c | local_38) & 0xffff) + (uVar8 & 0xff | local_2c << 8) * 0x10000;
    }
    else {
      uVar5 = (local_3c | local_38) << 0x10 | (uVar8 & 0xff) << 8 | local_2c & 0xff;
    }
  }
  *param_6 = uVar5;
LAB_00024ec0:
  iVar2 = 0;
LAB_00024ec4:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar2);
  }
  return;
}



int FUN_000254c4(int param_1)

{
  int iVar1;
  
  iVar1 = FUN_000295c4();
  if (-1 < iVar1) {
    iVar1 = 1;
    *(byte *)(param_1 + 0x428) = *(byte *)(param_1 + 0x428) & 0xfb;
  }
  log2Console(3,"Bugly-libunwind","returning %d\n",iVar1);
  return iVar1;
}



undefined4 FUN_00025520(void)

{
  FUN_00027008(&DAT_000636f0,0x424,0);
  FUN_00027008(&DAT_000636d8,0x28,0);
  return 0;
}



// WARNING: Removing unreachable block (ram,0x000255f0)

void FUN_00025560(void)

{
  char *__nptr;
  
  DAT_00063734 = 0xffffffff;
  pthread_mutex_lock((pthread_mutex_t *)&DAT_0003de18);
  if (DAT_00063738 == 0) {
    __nptr = getenv("UNW_ARM_UNWIND_METHOD");
    if (__nptr != (char *)0x0) {
      DAT_0003d0c0 = atoi(__nptr);
    }
    FUN_00026f38();
    FUN_00025520();
    FUN_000256b4();
    DAT_00063738 = 1;
  }
  pthread_mutex_unlock((pthread_mutex_t *)&DAT_0003de18);
  return;
}



void _Uarm_local_access_addr_space_init(int param_1)

{
  __aeabi_memclr4(param_1,0x21448);
  *(undefined **)(param_1 + 0xc) = &DAT_00025654;
  return;
}



void FUN_000256b4(void)

{
  __aeabi_memclr8(&DAT_0003de40,&UINT_00021428);
  DAT_0003de44 = 1;
  DAT_0003de20 = FUN_00021ce0;
  DAT_0003de24 = &DAT_00021f40;
  DAT_0003de28 = &LAB_00025764;
  DAT_0003de2c = FUN_0002577c;
  DAT_0003de30 = FUN_00025980;
  DAT_0003de34 = FUN_00025aa0;
  DAT_0003de38 = &LAB_00025bf8;
  DAT_0003de3c = FUN_00025bb0;
  _Uarm_flush_cache(&DAT_0003de20,0,0);
  FUN_0002ca8c();
  return;
}



undefined4
FUN_0002577c(undefined4 param_1,undefined4 *param_2,undefined4 *param_3,int param_4,int param_5)

{
  int iVar1;
  int *piVar2;
  undefined4 uVar3;
  size_t __len;
  void *__addr;
  
  if (param_5 != 0) {
    __addr = (void *)((uint)param_2 & 0xfffff000);
    __len = 0x2000;
    if ((void *)((int)param_2 + 3U & 0xfffff000) == __addr) {
      __len = 0x1000;
    }
    if (__addr == (void *)0x0) {
      return 0xffffffff;
    }
    if (((((DAT_0005f268 == (void *)0x0) || (__addr != DAT_0005f268)) &&
         ((DAT_0005f26c == (void *)0x0 || (__addr != DAT_0005f26c)))) &&
        ((DAT_0005f270 == (void *)0x0 || (__addr != DAT_0005f270)))) &&
       ((DAT_0005f274 == (void *)0x0 || (__addr != DAT_0005f274)))) {
      iVar1 = msync(__addr,__len,1);
      if (iVar1 == -1) {
        return 0xffffffff;
      }
      piVar2 = (int *)(&DAT_0005f268 + DAT_0005f278);
      if (*piVar2 != 0) {
        iVar1 = (DAT_0005f278 + 1) % 4;
        piVar2 = (int *)(&DAT_0005f268 + iVar1);
        if (*piVar2 != 0) {
          iVar1 = (iVar1 + 1) % 4;
          piVar2 = (int *)(&DAT_0005f268 + iVar1);
          if (*piVar2 != 0) {
            iVar1 = (iVar1 + 1) % 4;
            piVar2 = (int *)(&DAT_0005f268 + iVar1);
            if (*piVar2 != 0) {
              iVar1 = (iVar1 + 1) % 4;
              (&DAT_0005f268)[iVar1] = __addr;
              DAT_0005f278 = (iVar1 + 1) % 4;
              goto LAB_000258fc;
            }
          }
        }
      }
      *piVar2 = (int)__addr;
    }
  }
LAB_000258fc:
  if (param_4 == 0) {
    uVar3 = *param_2;
    *param_3 = uVar3;
    log2Console(3,"Bugly-libunwind","mem[%x] -> %x\n",param_2,uVar3);
  }
  else {
    log2Console(3,"Bugly-libunwind","mem[%x] <- %x\n",param_2,*param_3);
    *param_2 = *param_3;
  }
  return 0;
}



undefined4 FUN_00025980(undefined4 param_1,uint param_2,undefined4 *param_3,int param_4,int param_5)

{
  int iVar1;
  undefined4 uVar2;
  undefined4 *puVar3;
  undefined4 uVar4;
  char *pcVar5;
  
  iVar1 = _Uarm_is_fpreg(param_2);
  if (iVar1 == 0) {
    uVar2 = _Uarm_regname(param_2);
    log2Console(3,"Bugly-libunwind","reg = %s\n",uVar2);
    puVar3 = (undefined4 *)0x0;
    if (param_2 < 0x10) {
      puVar3 = (undefined4 *)(param_5 + param_2 * 4);
    }
    if (puVar3 != (undefined4 *)0x0) {
      if (param_4 == 0) {
        *param_3 = *puVar3;
        uVar2 = _Uarm_regname(param_2);
        uVar4 = *param_3;
        pcVar5 = "%s -> %x\n";
      }
      else {
        *puVar3 = *param_3;
        uVar2 = _Uarm_regname(param_2);
        uVar4 = *param_3;
        pcVar5 = "%s <- %x\n";
      }
      log2Console(3,"Bugly-libunwind",pcVar5,uVar2,uVar4);
      return 0;
    }
  }
  log2Console(3,"Bugly-libunwind","bad register number %u\n",param_2);
  return 0xfffffffd;
}



undefined4 FUN_00025aa0(undefined4 param_1,uint param_2,undefined8 *param_3,int param_4,int param_5)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 *puVar3;
  
  iVar1 = _Uarm_is_fpreg(param_2);
  if (iVar1 != 0) {
    puVar3 = (undefined8 *)0x0;
    if (param_2 < 0x10) {
      puVar3 = (undefined8 *)(param_5 + param_2 * 4);
    }
    if (puVar3 != (undefined8 *)0x0) {
      if (param_4 == 0) {
        *param_3 = *puVar3;
        uVar2 = _Uarm_regname(param_2);
        log2Console(3,"Bugly-libunwind","%s -> %08lx.%08lx.%08lx\n",uVar2,*(undefined4 *)param_3,
                    *(undefined4 *)((int)param_3 + 4),*(undefined4 *)(param_3 + 1));
      }
      else {
        uVar2 = _Uarm_regname(param_2);
        log2Console(3,"Bugly-libunwind","%s <- %08lx.%08lx.%08lx\n",uVar2,*(undefined4 *)param_3,
                    *(undefined4 *)((int)param_3 + 4),*(undefined4 *)(param_3 + 1));
        *puVar3 = *param_3;
      }
      return 0;
    }
  }
  log2Console(3,"Bugly-libunwind","bad register number %u\n",param_2);
  return 0xfffffffd;
}



void FUN_00025bb0(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                 undefined4 param_5,undefined4 param_6)

{
  __pid_t _Var1;
  
  _Var1 = getpid();
  FUN_00026c8c(param_1,_Var1,param_2,param_3,param_4,param_5,param_6);
  return;
}



void _Uarm_resume(undefined4 *param_1)

{
  undefined4 uVar1;
  int iVar2;
  undefined1 *puVar3;
  int iVar4;
  code *pcVar5;
  int iVar6;
  undefined4 uVar7;
  undefined1 auStack_34 [4];
  undefined1 auStack_30 [8];
  int local_28;
  
  local_28 = __stack_chk_guard;
  log2Console(3,"Bugly-libunwind","(cursor=%p)\n",param_1);
  if (param_1[3] == 0) {
    log2Console(3,"Bugly-libunwind","refusing to resume execution at address 0\n");
    uVar7 = 0xfffffff8;
  }
  else {
    uVar7 = *param_1;
    iVar4 = param_1[1];
    log2Console(3,"Bugly-libunwind","copying out cursor state\n");
    iVar6 = 0;
    do {
      uVar1 = _Uarm_regname(iVar6);
      log2Console(3,"Bugly-libunwind","copying %s %d\n",uVar1,iVar6);
      iVar2 = _Uarm_is_fpreg(iVar6);
      if (iVar2 == 0) {
        iVar2 = FUN_0002060c(param_1,iVar6,auStack_34,0);
        if (-1 < iVar2) {
          pcVar5 = *(code **)(iVar4 + 0x10);
          puVar3 = auStack_34;
          goto LAB_00025e24;
        }
      }
      else {
        iVar2 = FUN_00020778(param_1,iVar6,auStack_30,0);
        if (-1 < iVar2) {
          pcVar5 = *(code **)(iVar4 + 0x14);
          puVar3 = auStack_30;
LAB_00025e24:
          (*pcVar5)(iVar4,iVar6,puVar3,1,uVar7);
        }
      }
      iVar6 = iVar6 + 1;
    } while (iVar6 != 0x120);
    uVar7 = (**(code **)(param_1[1] + 0x18))(param_1[1],param_1,*param_1);
  }
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar7);
  }
  return;
}



void _Uelf32_memory_read(int param_1,uint param_2,undefined4 *param_3,uint param_4,int param_5)

{
  int iVar1;
  uint uVar2;
  void *pvVar3;
  int iVar4;
  uint __n;
  undefined4 local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar4 = *(int *)(param_1 + 0xc);
  iVar1 = _Uarm_get_accessors(*(undefined4 *)(param_1 + 4));
  uVar2 = *(int *)(iVar4 + 4) - param_2;
  if (uVar2 < param_4) {
    param_4 = uVar2;
  }
  uVar2 = param_2 & 3;
  if (uVar2 != 0) {
    iVar4 = (**(code **)(iVar1 + 0xc))
                      (*(undefined4 *)(param_1 + 4),param_2 & 0xfffffffc,&local_2c,0,
                       *(undefined4 *)(param_1 + 8));
    if (iVar4 != 0) goto LAB_000260b0;
    __n = 4 - uVar2;
    if (param_4 <= 4 - uVar2) {
      __n = param_4;
    }
    __aeabi_memcpy(param_3,(uint)&local_2c | uVar2,__n);
    if ((param_5 != 0) && (pvVar3 = memchr(param_3,0,__n), pvVar3 != (void *)0x0))
    goto LAB_000260b0;
    param_3 = (undefined4 *)((int)param_3 + __n);
    param_4 = param_4 - __n;
    param_2 = __n + param_2;
  }
  if (param_4 >> 2 != 0) {
    uVar2 = 0;
    do {
      iVar4 = (**(code **)(iVar1 + 0xc))
                        (*(undefined4 *)(param_1 + 4),param_2,&local_2c,0,
                         *(undefined4 *)(param_1 + 8));
      if ((iVar4 != 0) ||
         ((*param_3 = local_2c, param_5 != 0 &&
          (pvVar3 = memchr(param_3,0,4), pvVar3 != (void *)0x0)))) goto LAB_000260b0;
      uVar2 = uVar2 + 1;
      param_3 = param_3 + 1;
      param_2 = param_2 + 4;
    } while (uVar2 < param_4 >> 2);
  }
  if ((((param_4 & 3) != 0) &&
      (iVar1 = (**(code **)(iVar1 + 0xc))
                         (*(undefined4 *)(param_1 + 4),param_2,&local_2c,0,
                          *(undefined4 *)(param_1 + 8)), iVar1 == 0)) &&
     (__aeabi_memcpy(param_3,&local_2c,param_4 & 3), param_5 != 0)) {
    memchr(param_3,0,4);
  }
LAB_000260b0:
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void FUN_000260dc(undefined4 param_1,char *param_2,int param_3,uint param_4,uint param_5,
                 char *param_6,uint param_7,uint *param_8)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  uint uVar5;
  char *pcVar6;
  int iVar7;
  uint uVar8;
  int iVar9;
  int *piVar10;
  uint uVar11;
  int *piVar12;
  uint uVar13;
  int iVar14;
  uint uVar15;
  uint local_c0;
  int local_ac [3];
  uint local_a0;
  int local_9c;
  int local_98 [3];
  int local_8c;
  uint local_88;
  uint local_84;
  uint local_80;
  byte local_7c [2];
  short local_7a;
  uint local_78;
  int local_74 [5];
  undefined1 auStack_60 [28];
  int local_44;
  int local_40 [3];
  ushort local_34;
  ushort local_32;
  ushort local_30 [2];
  int local_2c;
  
  local_2c = __stack_chk_guard;
  __aeabi_memclr8(auStack_60,0x34);
  if (param_2[2] == '\0') {
    iVar3 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x1c,&local_44,4,0);
    if ((iVar3 == 4) &&
       ((local_34 != 0 ||
        ((iVar3 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x2c,&local_34,2,0),
         iVar3 == 2 && (local_34 != 0)))))) {
      uVar5 = 0;
      iVar3 = local_44;
      do {
        iVar4 = _Uelf32_memory_read(param_2,iVar3 + **(int **)(param_2 + 0xc),&local_88,4,0);
        if (iVar4 != 4) break;
        if (local_88 == 1) {
          iVar4 = _Uelf32_memory_read(param_2,iVar3 + **(int **)(param_2 + 0xc) + 4,&local_84,4,0);
          if (iVar4 != 4) break;
          if (local_84 == param_4) {
            iVar3 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + iVar3 + 8,&local_80,4,0)
            ;
            uVar5 = local_80;
            if (iVar3 == 4) goto LAB_0002627c;
            break;
          }
        }
        uVar5 = uVar5 + 1;
        iVar3 = iVar3 + 0x20;
      } while (uVar5 < local_34);
    }
  }
  else {
    iVar3 = *(int *)(param_2 + 4);
    if (*(ushort *)(iVar3 + 0x2c) != 0) {
      iVar4 = iVar3 + *(int *)(iVar3 + 0x1c);
      uVar5 = 0;
      do {
        if ((*(int *)(iVar4 + uVar5 * 0x20) == 1) &&
           (iVar7 = iVar4 + uVar5 * 0x20, *(uint *)(iVar7 + 4) == param_4)) {
          uVar5 = *(uint *)(iVar7 + 8);
LAB_0002627c:
          if (*param_2 == '\0') break;
          if (param_7 < 2) {
            pcVar6 = "lookup_symbol called with a buffer too small to hold a name %zu\n";
          }
          else {
            local_c0 = param_7 - 1;
            if (param_2[2] == '\0') {
              if (((local_40[0] == 0) &&
                  (iVar3 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x20,local_40,4,0
                                              ), iVar3 != 4)) ||
                 ((local_32 == 0 &&
                  (iVar3 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x2e,&local_32,2,
                                               0), iVar3 != 2)))) break;
              uVar13 = (uint)local_30[0];
              if (uVar13 == 0) {
                iVar3 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x30,local_30,2,0);
                if (iVar3 != 2) break;
                uVar13 = (uint)local_30[0];
              }
              iVar3 = local_40[0];
              uVar1 = (uint)local_32;
              iVar4 = **(int **)(param_2 + 0xc);
              if (uVar1 * uVar13 + local_40[0] <= (uint)((*(int **)(param_2 + 0xc))[1] - iVar4)) {
                if (uVar13 == 0) {
                  iVar4 = _Uelf32_memory_read(param_2,iVar4 + 0x30,local_30,2,0);
                  if (iVar4 != 2) break;
                  uVar1 = (uint)local_32;
                }
                if (((uVar1 == 0) &&
                    (iVar4 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x2e,&local_32,
                                                 2,0), iVar4 != 2)) || (local_30[0] == 0)) break;
                uVar13 = 0;
                do {
                  iVar4 = _Uelf32_memory_read(param_2,iVar3 + **(int **)(param_2 + 0xc) + 4,local_ac
                                              ,4,0);
                  if (iVar4 != 4) break;
                  if (local_ac[0] == 0xb || local_ac[0] == 2) {
                    iVar7 = _Uelf32_memory_read(param_2,iVar3 + **(int **)(param_2 + 0xc) + 0x18,
                                                local_98,4,0);
                    iVar4 = local_98[0];
                    if (iVar7 != 4) break;
                    if ((local_40[0] != 0) ||
                       (iVar7 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x20,
                                                    local_40,4,0), iVar7 == 4)) {
                      uVar1 = (uint)local_32;
                      if (uVar1 == 0) {
                        iVar7 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x2e,
                                                    &local_32,2,0);
                        if (iVar7 != 2) goto LAB_00026b40;
                        uVar1 = (uint)local_32;
                      }
                      iVar7 = iVar4 * uVar1 + local_40[0];
                      iVar4 = **(int **)(param_2 + 0xc);
                      uVar8 = (*(int **)(param_2 + 0xc))[1] - iVar4;
                      if (uVar8 < iVar7 + uVar1) {
                        log2Console(3,"Bugly-libunwind",
                                    "string shdr table outside of image? (%lu > %lu)\n",
                                    iVar7 + uVar1,uVar8);
                      }
                      else {
                        iVar4 = _Uelf32_memory_read(param_2,iVar7 + iVar4 + 0x10,&local_78,4,0);
                        if ((iVar4 == 4) &&
                           (iVar4 = _Uelf32_memory_read(param_2,iVar7 + **(int **)(param_2 + 0xc) +
                                                                0x14,local_74,4,0), iVar4 == 4)) {
                          if (local_74[0] + local_78 <= uVar8) {
                            log2Console(3,"Bugly-libunwind","strtab=0x%lx\n");
                            uVar1 = local_78;
                            iVar4 = _Uelf32_memory_read(param_2,iVar3 + **(int **)(param_2 + 0xc) +
                                                                0x10,&local_a0,4,0);
                            if (((iVar4 != 4) ||
                                (iVar4 = _Uelf32_memory_read(param_2,iVar3 + **(int **)(param_2 +
                                                                                       0xc) + 0x14,
                                                             &local_9c,4,0), iVar4 != 4)) ||
                               (iVar4 = _Uelf32_memory_read(param_2,iVar3 + **(int **)(param_2 + 0xc
                                                                                      ) + 0x24,
                                                            &local_8c,4,0), iVar4 != 4)) break;
                            log2Console(3,"Bugly-libunwind","symtab=0x%lx[%d]\n",local_a0,
                                        local_ac[0]);
                            uVar15 = local_9c + local_a0;
                            for (uVar8 = local_a0; uVar8 < uVar15; uVar8 = local_8c + uVar8) {
                              iVar4 = _Uelf32_memory_read(param_2,uVar8 + **(int **)(param_2 + 0xc)
                                                                  + 0xc,local_7c,1,0);
                              if ((iVar4 != 1) ||
                                 (iVar4 = _Uelf32_memory_read(param_2,uVar8 + **(int **)(param_2 +
                                                                                        0xc) + 0xe,
                                                              &local_7a,2,0), iVar4 != 2))
                              goto LAB_00026bf4;
                              if (((local_7c[0] & 0xf) == 2) && (local_7a != 0)) {
                                iVar4 = _Uelf32_memory_read(param_2,uVar8 + **(int **)(param_2 + 0xc
                                                                                      ) + 4,
                                                            &local_84,4,0);
                                if (iVar4 != 4) goto LAB_00026bf4;
                                uVar11 = local_84;
                                if (local_7a != -0xf) {
                                  uVar11 = local_84 + (param_3 - uVar5);
                                }
                                log2Console(3,"Bugly-libunwind","0x%016lx info=0x%02x\n",uVar11,
                                            local_7c[0]);
                                iVar4 = _Uelf32_memory_read(param_2,uVar8 + **(int **)(param_2 + 0xc
                                                                                      ) + 8,
                                                            &local_80,4,0);
                                if (iVar4 != 4) goto LAB_00026bf4;
                                if ((uVar11 <= param_5) && (param_5 - uVar11 < local_80)) {
                                  iVar4 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) +
                                                                      uVar8,&local_88,4,0);
                                  if (iVar4 != 4) goto LAB_00026bf4;
                                  iVar4 = **(int **)(param_2 + 0xc);
                                  uVar8 = local_88 + uVar1;
                                  if (((uVar8 <= (uint)((*(int **)(param_2 + 0xc))[1] - iVar4)) &&
                                      (!CARRY4(local_88,uVar1))) &&
                                     (iVar4 = _Uelf32_memory_read(param_2,uVar8 + iVar4,param_6,
                                                                  local_c0,1), iVar4 != 0)) {
                                    param_6[local_c0] = '\0';
                                    if (param_8 != (uint *)0x0) {
                                      *param_8 = param_5 - uVar11;
                                    }
                                    goto LAB_00026bf4;
                                  }
                                  break;
                                }
                              }
                            }
                            goto LAB_00026b38;
                          }
                          log2Console(3,"Bugly-libunwind",
                                      "string table outside of image? (%lu > %lu)\n",
                                      local_74[0] + local_78,uVar8);
                        }
                      }
                    }
                  }
                  else {
LAB_00026b38:
                    iVar3 = iVar3 + (uint)local_32;
                  }
LAB_00026b40:
                  uVar13 = uVar13 + 1;
                } while (uVar13 < local_30[0]);
                break;
              }
              pcVar6 = "section table outside of image? (%lu > %lu)\n";
            }
            else {
              iVar3 = *(int *)(param_2 + 4);
              if ((uint)*(ushort *)(iVar3 + 0x2e) * (uint)*(ushort *)(iVar3 + 0x30) +
                  *(int *)(iVar3 + 0x20) <= *(uint *)(param_2 + 8)) {
                iVar4 = iVar3 + *(int *)(iVar3 + 0x20);
                if ((iVar4 == 0) || (*(ushort *)(iVar3 + 0x30) == 0)) break;
                uVar13 = 0;
                do {
                  if (*(int *)(iVar4 + 4) == 0xb || *(int *)(iVar4 + 4) == 2) {
                    iVar14 = *(int *)(param_2 + 4);
                    uVar1 = *(uint *)(param_2 + 8);
                    iVar7 = *(int *)(iVar4 + 0x18) * (uint)*(ushort *)(iVar14 + 0x2e) +
                            *(int *)(iVar14 + 0x20);
                    uVar8 = iVar7 + (uint)*(ushort *)(iVar14 + 0x2e);
                    if (uVar1 < uVar8) {
                      log2Console(3,"Bugly-libunwind",
                                  "string shdr table outside of image? (%lu > %lu)\n",uVar8,uVar1);
                    }
                    else {
                      iVar7 = iVar14 + iVar7;
                      uVar8 = *(int *)(iVar7 + 0x14) + *(int *)(iVar7 + 0x10);
                      if (uVar1 < uVar8) {
                        log2Console(3,"Bugly-libunwind",
                                    "string table outside of image? (%lu > %lu)\n",uVar8,uVar1);
                      }
                      else {
                        iVar2 = *(int *)(iVar4 + 0x10);
                        iVar9 = *(int *)(iVar4 + 0x14);
                        log2Console(3,"Bugly-libunwind","strtab=0x%lx\n");
                        iVar7 = *(int *)(iVar7 + 0x10) + *(int *)(param_2 + 4);
                        if (iVar7 != 0) {
                          log2Console(3,"Bugly-libunwind","symtab=0x%lx[%d]\n",
                                      *(undefined4 *)(iVar4 + 0x10),*(undefined4 *)(iVar4 + 4));
                          if (0 < iVar9) {
                            piVar10 = (int *)(iVar14 + iVar2);
                            piVar12 = (int *)((int)piVar10 + iVar9);
                            do {
                              if (((*(byte *)(piVar10 + 3) & 0xf) == 2) &&
                                 (*(short *)((int)piVar10 + 0xe) != 0)) {
                                uVar1 = piVar10[1];
                                if (*(short *)((int)piVar10 + 0xe) != -0xf) {
                                  uVar1 = uVar1 + (param_3 - uVar5);
                                }
                                log2Console(3,"Bugly-libunwind","0x%016lx info=0x%02x\n",uVar1,
                                            *(byte *)(piVar10 + 3));
                                if ((uVar1 <= param_5) && (param_5 - uVar1 < (uint)piVar10[2])) {
                                  if (-1 < *piVar10) {
                                    pcVar6 = (char *)(iVar7 + *piVar10);
                                    if (pcVar6 <= (char *)(*(int *)(param_2 + 4) +
                                                          *(int *)(param_2 + 8))) {
                                      uVar8 = (int)pcVar6 - *(int *)(param_2 + 4);
                                      if (uVar8 < local_c0) {
                                        local_c0 = uVar8;
                                      }
                                      pcVar6 = strncpy(param_6,pcVar6,local_c0);
                                      pcVar6[local_c0] = '\0';
                                      if (*pcVar6 != '\0') {
                                        if (param_8 != (uint *)0x0) {
                                          *param_8 = param_5 - uVar1;
                                        }
                                        goto LAB_00026bf4;
                                      }
                                    }
                                  }
                                  break;
                                }
                              }
                              piVar10 = (int *)((int)piVar10 + *(int *)(iVar4 + 0x24));
                            } while (piVar10 < piVar12);
                          }
                          goto LAB_0002660c;
                        }
                      }
                    }
                  }
                  else {
LAB_0002660c:
                    iVar4 = iVar4 + (uint)*(ushort *)(iVar3 + 0x2e);
                  }
                  uVar13 = uVar13 + 1;
                } while (uVar13 < *(ushort *)(iVar3 + 0x30));
                break;
              }
              pcVar6 = "section table outside of image? (%lu > %lu)\n";
            }
          }
          log2Console(3,"Bugly-libunwind",pcVar6);
          break;
        }
        uVar5 = uVar5 + 1;
      } while (uVar5 < *(ushort *)(iVar3 + 0x2c));
    }
  }
LAB_00026bf4:
  if (__stack_chk_guard - local_2c == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_2c);
}



void FUN_00026c8c(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                 undefined4 param_5,undefined4 param_6,undefined4 param_7)

{
  int iVar1;
  undefined1 auStack_3c [16];
  undefined4 local_2c;
  undefined4 local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  iVar1 = _Uarm_get_elf_image(param_1,auStack_3c,param_2,param_3,&local_28,&local_2c,0,param_7);
  if (-1 < iVar1) {
    FUN_000260dc(param_6,auStack_3c,local_28,local_2c,param_3,param_4,param_5,param_6);
  }
  if (__stack_chk_guard - local_24 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_24);
  }
  return;
}



void FUN_00026d30(char *param_1,int param_2,undefined4 *param_3)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  int local_7c;
  int iStack_78;
  undefined4 local_74 [13];
  int local_40 [4];
  ushort local_30 [4];
  int local_28;
  
  local_28 = __stack_chk_guard;
  if (*param_1 != '\0') {
    if (param_1[2] == '\0') {
      iVar1 = _Uelf32_memory_read(param_1,**(int **)(param_1 + 0xc) + 0x2c,local_30,2,0);
      if (((iVar1 == 2) &&
          (iVar1 = _Uelf32_memory_read(param_1,**(int **)(param_1 + 0xc) + 0x1c,local_40,4,0),
          iVar1 == 4)) && (local_30[0] != 0)) {
        uVar3 = 0;
        iVar1 = local_40[0];
        do {
          iVar2 = _Uelf32_memory_read(param_1,iVar1 + **(int **)(param_1 + 0xc),&local_7c,4,0);
          if ((iVar2 != 4) ||
             (iVar2 = _Uelf32_memory_read(param_1,iVar1 + **(int **)(param_1 + 0xc) + 4,&iStack_78,4
                                          ,0), iVar2 != 4)) break;
          iVar2 = local_7c;
          if (local_7c == 1) {
            iVar2 = iStack_78;
          }
          if (local_7c == 1 && iVar2 == param_2) {
            iVar1 = _Uelf32_memory_read(param_1,**(int **)(param_1 + 0xc) + iVar1 + 8,local_74,4,0);
            if (iVar1 == 4) {
              *param_3 = local_74[0];
            }
            break;
          }
          uVar3 = uVar3 + 1;
          iVar1 = iVar1 + 0x20;
        } while (uVar3 < local_30[0]);
      }
    }
    else {
      iVar1 = *(int *)(param_1 + 4);
      if (*(ushort *)(iVar1 + 0x2c) != 0) {
        iVar2 = iVar1 + *(int *)(iVar1 + 0x1c);
        uVar3 = 0;
        do {
          if ((*(int *)(iVar2 + uVar3 * 0x20) == 1) &&
             (iVar4 = iVar2 + uVar3 * 0x20, *(int *)(iVar4 + 4) == param_2)) {
            *param_3 = *(undefined4 *)(iVar4 + 8);
            break;
          }
          uVar3 = uVar3 + 1;
        } while (uVar3 < *(ushort *)(iVar1 + 0x2c));
      }
    }
  }
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void FUN_00026f38(void)

{
  return;
}



void _Uarm_flush_cache(int param_1)

{
  bool bVar1;
  int *piVar2;
  int iVar3;
  
  iVar3 = *(int *)(param_1 + 0x21440);
  *(undefined4 *)(param_1 + 0x30) = 0;
  for (; iVar3 != 0; iVar3 = *(int *)(iVar3 + 0x18)) {
    if (*(void **)(iVar3 + 0x10) != (void *)0x0) {
      free(*(void **)(iVar3 + 0x10));
    }
    free(*(void **)(iVar3 + 8));
  }
  piVar2 = (int *)(param_1 + 0x28);
  *(int *)(param_1 + 0x21440) = 0;
  DataMemoryBarrier(0xb);
  do {
    bVar1 = (bool)hasExclusiveAccess(piVar2);
  } while (!bVar1);
  *piVar2 = *piVar2 + 1;
  DataMemoryBarrier(0xb);
  return;
}



void FUN_00027008(pthread_mutex_t *param_1,int param_2,uint param_3)

{
  int iVar1;
  uint uVar2;
  uint uVar3;
  
  if (DAT_00063280 == 0) {
    DAT_00063280 = sysconf(0x27);
  }
  (param_1->__data).__lock = 0;
  (param_1->__data).__count = 0;
  (param_1->__data).__owner = 0;
  (param_1->__data).__kind = 0;
  (param_1->__data).__nusers = 0;
  (param_1->__data).field5_0x14.__spins = 0;
  pthread_mutex_init(param_1,(pthread_mutexattr_t *)0x0);
  iVar1 = DAT_00063280;
  uVar3 = param_2 + 7U & 0xfffffff8;
  if (param_3 == 0) {
    uVar2 = __aeabi_uidiv(DAT_00063280,uVar3);
    param_3 = uVar2 >> 2;
    if (uVar2 >> 2 == 0) {
      param_3 = 0x10;
    }
  }
  (param_1->__data).__count = uVar3;
  (param_1->__data).__owner = (iVar1 + uVar3 * param_3 * 2) - 1 & -iVar1;
  (param_1->__data).__kind = param_3;
  FUN_000270e8(param_1);
  return;
}



void FUN_000270e8(int param_1)

{
  bool bVar1;
  undefined4 *puVar2;
  int iVar3;
  undefined4 *puVar4;
  size_t __len;
  undefined4 *puVar5;
  undefined4 *puVar6;
  int iVar7;
  
  __len = *(size_t *)(param_1 + 8);
  puVar2 = (undefined4 *)mmap((void *)0x0,__len,3,0x22,-1,0);
  if (puVar2 == (undefined4 *)0xffffffff) {
    puVar2 = (undefined4 *)0x0;
  }
  if (puVar2 == (undefined4 *)0x0) {
    __len = (*(int *)(param_1 + 4) + DAT_00063280) - 1U & -DAT_00063280;
    puVar2 = (undefined4 *)mmap((void *)0x0,__len,3,0x22,-1,0);
    if (puVar2 == (undefined4 *)0xffffffff) {
      puVar2 = (undefined4 *)0x0;
    }
    if (puVar2 == (undefined4 *)0x0) {
      __len = *(size_t *)(param_1 + 4);
      DataMemoryBarrier(0xb);
      do {
        bVar1 = (bool)hasExclusiveAccess(0x5f27c);
      } while (!bVar1);
      DataMemoryBarrier(0xb);
      puVar2 = (undefined4 *)(&DAT_0005f280 + DAT_0005f27c);
      DAT_0005f27c = DAT_0005f27c + (__len + 7 & 0xfffffff8);
    }
  }
  iVar3 = *(int *)(param_1 + 4);
  puVar4 = (undefined4 *)((int)puVar2 + (__len - iVar3));
  if (puVar2 <= puVar4) {
    iVar7 = *(int *)(param_1 + 0x10);
    puVar5 = *(undefined4 **)(param_1 + 0x14);
    do {
      puVar6 = (undefined4 *)((int)puVar2 + iVar3);
      *puVar2 = puVar5;
      iVar7 = iVar7 + 1;
      puVar5 = puVar2;
      puVar2 = puVar6;
    } while (puVar6 <= puVar4);
    *(int *)(param_1 + 0x10) = iVar7;
    *(int *)(param_1 + 0x14) = (int)puVar6 - iVar3;
  }
  return;
}



_union_13 * FUN_00027210(pthread_mutex_t *param_1)

{
  uint uVar1;
  _union_13 *p_Var2;
  
  pthread_mutex_lock(param_1);
  uVar1 = (param_1->__data).__nusers;
  if (uVar1 <= (uint)(param_1->__data).__kind) {
    FUN_000270e8(param_1);
    uVar1 = (param_1->__data).__nusers;
  }
  p_Var2 = *(_union_13 **)(param_1->__size + 0x14);
  (param_1->__data).__nusers = uVar1 - 1;
  (param_1->__data).field5_0x14 = *p_Var2;
  pthread_mutex_unlock(param_1);
  return p_Var2;
}



// WARNING: Removing unreachable block (ram,0x000272d8)

void FUN_0002728c(pthread_mutex_t *param_1,_union_13 param_2)

{
  pthread_mutex_lock(param_1);
  *(_union_13 *)param_2 = (param_1->__data).field5_0x14;
  (param_1->__data).__nusers = (param_1->__data).__nusers + 1;
  (param_1->__data).field5_0x14 = param_2;
  pthread_mutex_unlock(param_1);
  return;
}



void unw_map_set(int param_1,undefined4 *param_2)

{
  if (param_2 == (undefined4 *)0x0) {
    *(undefined4 *)(param_1 + 0x21444) = 0;
    return;
  }
  *(undefined4 *)(param_1 + 0x21444) = *param_2;
  return;
}



bool unw_map_cursor_create(int *param_1)

{
  int iVar1;
  
  iVar1 = FUN_0002c0b8(0);
  *param_1 = iVar1;
  return iVar1 == 0;
}



void unw_map_cursor_destroy(int *param_1)

{
  int iVar1;
  int iVar2;
  
  iVar1 = *param_1;
  while (iVar1 != 0) {
    iVar2 = *(int *)(iVar1 + 0x2c);
    if (*(char *)(iVar1 + 0x1e) != '\0') {
      munmap(*(void **)(iVar1 + 0x20),*(size_t *)(iVar1 + 0x24));
    }
    if (*(void **)(iVar1 + 0x14) != (void *)0x0) {
      free(*(void **)(iVar1 + 0x14));
    }
    FUN_0002728c(&DAT_00063708,iVar1);
    iVar1 = iVar2;
  }
  return;
}



void FUN_000273a8(int param_1)

{
  int iVar1;
  
  if (param_1 != 0) {
    do {
      iVar1 = *(int *)(param_1 + 0x2c);
      if (*(char *)(param_1 + 0x1e) != '\0') {
        munmap(*(void **)(param_1 + 0x20),*(size_t *)(param_1 + 0x24));
      }
      if (*(void **)(param_1 + 0x14) != (void *)0x0) {
        free(*(void **)(param_1 + 0x14));
      }
      FUN_0002728c(&DAT_00063708,param_1);
      param_1 = iVar1;
    } while (iVar1 != 0);
  }
  return;
}



void unw_map_cursor_reset(undefined4 *param_1)

{
  param_1[1] = *param_1;
  return;
}



void unw_map_cursor_clear(undefined4 *param_1)

{
  *param_1 = 0;
  param_1[1] = 0;
  return;
}



undefined4 unw_map_cursor_get_next(int param_1,undefined4 *param_2)

{
  undefined4 *puVar1;
  
  puVar1 = *(undefined4 **)(param_1 + 4);
  if (puVar1 != (undefined4 *)0x0) {
    *param_2 = *puVar1;
    param_2[1] = puVar1[1];
    param_2[2] = puVar1[2];
    param_2[3] = puVar1[3];
    param_2[5] = puVar1[4];
    param_2[4] = puVar1[5];
    *(undefined4 *)(param_1 + 4) = puVar1[0xb];
    return 1;
  }
  return 0;
}



void FUN_0002747c(void)

{
  if (DAT_00063284 == 0) {
    pthread_mutex_lock((pthread_mutex_t *)&DAT_00063288);
    if (DAT_00063284 == 0) {
      FUN_00027008(&DAT_00063708,0x30,0);
      DAT_00063284 = 1;
    }
    pthread_mutex_unlock((pthread_mutex_t *)&DAT_00063288);
  }
  FUN_00027210(&DAT_00063708);
  return;
}



uint * FUN_00027548(uint *param_1,uint param_2)

{
  while( true ) {
    if (param_1 == (uint *)0x0) {
      return (uint *)0x0;
    }
    if ((*param_1 <= param_2) && (param_2 < param_1[1])) break;
    param_1 = (uint *)param_1[0xb];
  }
  return param_1;
}



void FUN_00027580(int param_1,int param_2,uint *param_3,uint *param_4,int param_5,uint param_6,
                 undefined4 param_7)

{
  bool bVar1;
  ushort uVar2;
  int iVar3;
  int *piVar4;
  undefined4 *puVar5;
  byte bVar6;
  uint uVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  int iVar11;
  uint uVar12;
  uint uVar13;
  uint uVar14;
  uint uVar15;
  uint uVar16;
  uint uVar17;
  uint local_90;
  uint local_8c;
  uint local_88;
  uint local_80;
  uint local_70;
  uint local_68;
  int local_64;
  uint local_60;
  uint local_5c;
  uint local_58;
  uint local_54;
  uint local_50;
  uint local_4c;
  ushort local_48;
  undefined2 local_46;
  byte local_44;
  undefined1 local_43;
  byte local_42;
  uint local_3c;
  uint local_38;
  uint local_34;
  uint local_30;
  undefined1 local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar12 = *param_3;
  log2Console(3,"Bugly-libunwind","FDE @ 0x%lx\n",uVar12);
  __aeabi_memclr8(&local_68,0x28);
  local_3c = uVar12 + 1;
  puVar5 = (undefined4 *)(param_2 + 0xc);
  iVar3 = (*(code *)*puVar5)(param_1,uVar12 & 0xfffffffc,&local_30,0,param_7);
  uVar13 = local_30;
  uVar9 = local_3c;
  if (iVar3 < 0) goto LAB_00028724;
  uVar15 = local_3c & 0xfffffffc;
  local_3c = local_3c + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_30,0,param_7);
  uVar16 = local_3c;
  if (iVar3 < 0) goto LAB_00028724;
  local_80 = local_30 >> ((uVar9 - uVar15) * 8 & 0xff);
  piVar4 = (int *)(param_1 + 0x20);
  uVar13 = uVar13 >> ((uVar12 - (uVar12 & 0xfffffffc)) * 8 & 0xff);
  if (*piVar4 == 0) {
    uVar13 = uVar13 & 0xff;
    local_80 = local_80 << 8;
  }
  else {
    local_80 = local_80 & 0xff;
    uVar13 = uVar13 << 8;
  }
  uVar15 = local_3c & 0xfffffffc;
  local_3c = local_3c + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_30,0,param_7);
  uVar9 = local_30;
  uVar12 = local_3c;
  if (iVar3 < 0) goto LAB_00028724;
  uVar7 = local_3c & 0xfffffffc;
  local_3c = local_3c + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
  uVar14 = local_3c;
  if (iVar3 < 0) goto LAB_00028724;
  uVar9 = uVar9 >> ((uVar16 - uVar15) * 8 & 0xff);
  uVar12 = local_30 >> ((uVar12 - uVar7) * 8 & 0xff);
  if (*piVar4 == 0) {
    local_70 = ((local_80 | uVar13) & 0xffff) + (uVar9 & 0xff | uVar12 << 8) * 0x10000;
  }
  else {
    local_70 = uVar12 & 0xff | (uVar9 & 0xff) << 8 | (local_80 | uVar13) << 0x10;
  }
  uVar13 = param_6;
  if (local_70 == 0xffffffff) {
    uVar16 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_30,0,param_7);
    uVar9 = local_30;
    uVar12 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar7 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
    uVar15 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar9 = uVar9 >> ((uVar14 - uVar16) * 8 & 0xff);
    local_80 = local_30 >> ((uVar12 - uVar7) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = uVar9 & 0xff;
      local_80 = local_80 << 8;
    }
    else {
      local_80 = local_80 & 0xff;
      uVar9 = uVar9 << 8;
    }
    uVar14 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar14,&local_30,0,param_7);
    uVar12 = local_30;
    uVar16 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar8 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar8,&local_30,0,param_7);
    uVar7 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar16 = local_30 >> ((uVar16 - uVar8) * 8 & 0xff);
    uVar12 = uVar12 >> ((uVar15 - uVar14) * 8 & 0xff);
    if (*piVar4 == 0) {
      local_70 = ((local_80 | uVar9) & 0xffff) + (uVar12 & 0xff | uVar16 << 8) * 0x10000;
    }
    else {
      local_70 = uVar16 & 0xff | (uVar12 & 0xff) << 8 | (local_80 | uVar9) << 0x10;
    }
    uVar16 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_30,0,param_7);
    uVar9 = local_30;
    uVar12 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar14 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar14,&local_30,0,param_7);
    uVar15 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    local_88 = local_30 >> ((uVar12 - uVar14) * 8 & 0xff);
    uVar9 = uVar9 >> ((uVar7 - uVar16) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = uVar9 & 0xff;
      local_88 = local_88 << 8;
    }
    else {
      local_88 = local_88 & 0xff;
      uVar9 = uVar9 << 8;
    }
    uVar7 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
    uVar16 = local_30;
    uVar12 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar8 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar8,&local_30,0,param_7);
    uVar14 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    if (*piVar4 != 0) {
      local_70 = local_30 >> ((uVar12 - uVar8) * 8 & 0xff) & 0xff |
                 (uVar16 >> ((uVar15 - uVar7) * 8 & 0xff) & 0xff) << 8 | (local_88 | uVar9) << 0x10;
    }
    local_70 = local_70 + local_3c;
    uVar16 = local_3c & 0xfffffffc;
    *param_3 = local_70;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_30,0,param_7);
    uVar9 = local_30;
    uVar12 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar7 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
    uVar15 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    local_88 = local_30 >> ((uVar12 - uVar7) * 8 & 0xff);
    uVar9 = uVar9 >> ((uVar14 - uVar16) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = uVar9 & 0xff;
      local_88 = local_88 << 8;
    }
    else {
      local_88 = local_88 & 0xff;
      uVar9 = uVar9 << 8;
    }
    uVar7 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
    uVar12 = local_30;
    uVar16 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar10 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar10,&local_30,0,param_7);
    uVar8 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar16 = local_30 >> ((uVar16 - uVar10) * 8 & 0xff);
    uVar12 = uVar12 >> ((uVar15 - uVar7) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = ((local_88 | uVar9) & 0xffff) + (uVar12 & 0xff | uVar16 << 8) * 0x10000;
    }
    else {
      uVar9 = (local_88 | uVar9) << 0x10 | (uVar12 & 0xff) << 8 | uVar16 & 0xff;
    }
    uVar15 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_30,0,param_7);
    uVar12 = local_30;
    uVar16 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar10 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar10,&local_30,0,param_7);
    uVar7 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    iVar11 = *(int *)(param_1 + 0x20);
    uVar12 = uVar12 >> ((uVar8 - uVar15) * 8 & 0xff);
    uVar16 = local_30 >> ((uVar16 - uVar10) * 8 & 0xff);
    uVar10 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar10,&local_30,0,param_7);
    uVar8 = local_30;
    uVar15 = local_3c;
    uVar17 = uVar16 & 0xff | uVar12 << 8;
    if (iVar11 == 0) {
      uVar17 = uVar12 & 0xff | uVar16 << 8;
    }
    if (iVar3 < 0) goto LAB_00028724;
    uVar12 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar12,&local_30,0,param_7);
    if (iVar3 < 0) goto LAB_00028724;
    if (*piVar4 != 0) {
      uVar9 = uVar17 << 0x10 | (uVar8 >> ((uVar7 - uVar10) * 8 & 0xff) & 0xff) << 8 |
              local_30 >> ((uVar15 - uVar12) * 8 & 0xff) & 0xff;
    }
    bVar1 = uVar9 == 0;
    if (param_6 != 0) {
      bVar1 = uVar9 == 0xffffffff;
      uVar13 = 1;
    }
    iVar3 = 0;
    if (bVar1) goto LAB_00028724;
    uVar14 = uVar14 - uVar9;
  }
  else {
    iVar3 = -10;
    if (local_70 == 0) goto LAB_00028724;
    local_70 = local_3c + local_70;
    *param_3 = local_70;
    uVar16 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_30,0,param_7);
    uVar9 = local_30;
    uVar12 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar7 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
    uVar15 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    local_80 = local_30 >> ((uVar12 - uVar7) * 8 & 0xff);
    uVar9 = uVar9 >> ((uVar14 - uVar16) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = uVar9 & 0xff;
      local_80 = local_80 << 8;
    }
    else {
      local_80 = local_80 & 0xff;
      uVar9 = uVar9 << 8;
    }
    uVar7 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
    uVar12 = local_30;
    uVar16 = local_3c;
    if (iVar3 < 0) goto LAB_00028724;
    uVar8 = local_3c & 0xfffffffc;
    local_3c = local_3c + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar8,&local_30,0,param_7);
    if (iVar3 < 0) goto LAB_00028724;
    uVar16 = local_30 >> ((uVar16 - uVar8) * 8 & 0xff);
    uVar12 = uVar12 >> ((uVar15 - uVar7) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = ((local_80 | uVar9) & 0xffff) + (uVar12 & 0xff | uVar16 << 8) * 0x10000;
    }
    else {
      uVar9 = (local_80 | uVar9) << 0x10 | (uVar12 & 0xff) << 8 | uVar16 & 0xff;
    }
    bVar1 = uVar9 == 0;
    if (param_6 != 0) {
      bVar1 = uVar9 == 0xffffffff;
      uVar13 = 1;
    }
    iVar3 = 0;
    if (bVar1) goto LAB_00028724;
    uVar14 = uVar14 - uVar9;
  }
  if (uVar13 != 0) {
    uVar14 = uVar9 + param_6;
  }
  log2Console(3,"Bugly-libunwind","looking for CIE at address %lx\n",uVar14);
  local_4c = 0;
  local_43 = 0xff;
  local_38 = uVar14 + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar14 & 0xfffffffc,&local_34,0,param_7);
  uVar13 = local_34;
  uVar9 = local_38;
  if (iVar3 < 0) goto LAB_00028724;
  uVar16 = local_38 & 0xfffffffc;
  local_38 = local_38 + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
  uVar12 = local_38;
  if (iVar3 < 0) goto LAB_00028724;
  local_80 = local_34 >> ((uVar9 - uVar16) * 8 & 0xff);
  uVar13 = uVar13 >> ((uVar14 - (uVar14 & 0xfffffffc)) * 8 & 0xff);
  if (*piVar4 == 0) {
    uVar13 = uVar13 & 0xff;
    local_80 = local_80 << 8;
  }
  else {
    local_80 = local_80 & 0xff;
    uVar13 = uVar13 << 8;
  }
  uVar15 = local_38 & 0xfffffffc;
  local_38 = local_38 + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_34,0,param_7);
  uVar9 = local_34;
  uVar16 = local_38;
  if (iVar3 < 0) goto LAB_00028724;
  uVar7 = local_38 & 0xfffffffc;
  local_38 = local_38 + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_34,0,param_7);
  uVar14 = local_38;
  if (iVar3 < 0) goto LAB_00028724;
  uVar16 = local_34 >> ((uVar16 - uVar7) * 8 & 0xff);
  uVar9 = uVar9 >> ((uVar12 - uVar15) * 8 & 0xff);
  if (*piVar4 == 0) {
    uVar13 = ((local_80 | uVar13) & 0xffff) + (uVar9 & 0xff | uVar16 << 8) * 0x10000;
  }
  else {
    uVar13 = (local_80 | uVar13) << 0x10 | (uVar9 & 0xff) << 8 | uVar16 & 0xff;
  }
  if (uVar13 == 0xffffffff) {
    uVar9 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar9,&local_34,0,param_7);
    local_80 = local_34;
    uVar13 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar16 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
    uVar12 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    local_88 = local_34 >> ((uVar13 - uVar16) * 8 & 0xff);
    local_80 = local_80 >> ((uVar14 - uVar9) * 8 & 0xff);
    if (*piVar4 == 0) {
      local_80 = local_80 & 0xff;
      local_88 = local_88 << 8;
    }
    else {
      local_88 = local_88 & 0xff;
      local_80 = local_80 << 8;
    }
    uVar16 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
    uVar13 = local_34;
    uVar9 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar14 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar14,&local_34,0,param_7);
    uVar15 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar9 = local_34 >> ((uVar9 - uVar14) * 8 & 0xff);
    uVar13 = uVar13 >> ((uVar12 - uVar16) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar13 = ((local_88 | local_80) & 0xffff) + (uVar13 & 0xff | uVar9 << 8) * 0x10000;
    }
    else {
      uVar13 = (local_88 | local_80) << 0x10 | (uVar13 & 0xff) << 8 | uVar9 & 0xff;
    }
    uVar16 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
    uVar9 = local_34;
    uVar12 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar7 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_34,0,param_7);
    uVar14 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar12 = local_34 >> ((uVar12 - uVar7) * 8 & 0xff);
    uVar9 = uVar9 >> ((uVar15 - uVar16) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = uVar9 & 0xff;
      uVar12 = uVar12 << 8;
    }
    else {
      uVar9 = uVar9 << 8;
      uVar12 = uVar12 & 0xff;
    }
    uVar7 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_34,0,param_7);
    uVar16 = local_34;
    uVar15 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar10 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar10,&local_34,0,param_7);
    uVar8 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar15 = local_34 >> ((uVar15 - uVar10) * 8 & 0xff);
    uVar16 = uVar16 >> ((uVar14 - uVar7) * 8 & 0xff);
    iVar11 = *piVar4;
    if (iVar11 == 0) {
      uVar9 = ((uVar12 | uVar9) & 0xffff) + (uVar16 & 0xff | uVar15 << 8) * 0x10000;
    }
    else {
      uVar9 = (uVar12 | uVar9) << 0x10 | (uVar16 & 0xff) << 8 | uVar15 & 0xff;
    }
    uVar15 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_34,0,param_7);
    uVar12 = local_34;
    uVar16 = local_38;
    if (iVar11 == 0) {
      uVar9 = uVar13;
    }
    if (iVar3 < 0) goto LAB_00028724;
    uVar14 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar14,&local_34,0,param_7);
    uVar13 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar16 = local_34 >> ((uVar16 - uVar14) * 8 & 0xff);
    uVar12 = uVar12 >> ((uVar8 - uVar15) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar12 = uVar12 & 0xff;
      uVar16 = uVar16 << 8;
    }
    else {
      uVar12 = uVar12 << 8;
      uVar16 = uVar16 & 0xff;
    }
    uVar7 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_34,0,param_7);
    uVar15 = local_34;
    uVar14 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar17 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar17,&local_34,0,param_7);
    uVar10 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar14 = local_34 >> ((uVar14 - uVar17) * 8 & 0xff);
    uVar15 = uVar15 >> ((uVar13 - uVar7) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar13 = ((uVar16 | uVar12) & 0xffff) + (uVar15 & 0xff | uVar14 << 8) * 0x10000;
    }
    else {
      uVar13 = (uVar16 | uVar12) << 0x10 | (uVar15 & 0xff) << 8 | uVar14 & 0xff;
    }
    uVar16 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
    local_80 = local_34;
    uVar12 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar14 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar14,&local_34,0,param_7);
    uVar15 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    local_90 = local_34 >> ((uVar12 - uVar14) * 8 & 0xff);
    local_80 = local_80 >> ((uVar10 - uVar16) * 8 & 0xff);
    if (*piVar4 == 0) {
      local_80 = local_80 & 0xff;
      local_90 = local_90 << 8;
    }
    else {
      local_90 = local_90 & 0xff;
      local_80 = local_80 << 8;
    }
    uVar14 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar14,&local_34,0,param_7);
    uVar12 = local_34;
    uVar16 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar7 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_34,0,param_7);
    if (iVar3 < 0) goto LAB_00028724;
    uVar16 = local_34 >> ((uVar16 - uVar7) * 8 & 0xff);
    uVar12 = uVar12 >> ((uVar15 - uVar14) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar15 = ((local_90 | local_80) & 0xffff) + (uVar12 & 0xff | uVar16 << 8) * 0x10000;
    }
    else {
      uVar15 = uVar13;
      uVar13 = (local_90 | local_80) << 0x10 | (uVar12 & 0xff) << 8 | uVar16 & 0xff;
    }
    if (param_6 != 0) {
      param_6 = 0xffffffff;
    }
    if (uVar13 != param_6 || uVar15 != param_6) {
      log2Console(3,"Bugly-libunwind","Unexpected CIE id %llx\n",uVar13,uVar13,uVar15);
      goto LAB_00028714;
    }
    local_64 = uVar9 + uVar8;
  }
  else {
    uVar12 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar12,&local_34,0,param_7);
    local_90 = local_34;
    uVar9 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar15 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_34,0,param_7);
    uVar16 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    local_8c = local_34 >> ((uVar9 - uVar15) * 8 & 0xff);
    local_90 = local_90 >> ((uVar14 - uVar12) * 8 & 0xff);
    if (*piVar4 == 0) {
      local_90 = local_90 & 0xff;
      local_8c = local_8c << 8;
    }
    else {
      local_8c = local_8c & 0xff;
      local_90 = local_90 << 8;
    }
    uVar15 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_34,0,param_7);
    uVar9 = local_34;
    uVar12 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar7 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_34,0,param_7);
    if (iVar3 < 0) goto LAB_00028724;
    uVar9 = uVar9 >> ((uVar16 - uVar15) * 8 & 0xff);
    uVar12 = local_34 >> ((uVar12 - uVar7) * 8 & 0xff);
    if (*piVar4 == 0) {
      uVar9 = ((local_8c | local_90) & 0xffff) + (uVar9 & 0xff | uVar12 << 8) * 0x10000;
    }
    else {
      uVar9 = (local_8c | local_90) << 0x10 | (uVar9 & 0xff) << 8 | uVar12 & 0xff;
    }
    if (param_6 != 0) {
      param_6 = 0xffffffff;
    }
    if (uVar9 != param_6) {
      log2Console(3,"Bugly-libunwind","Unexpected CIE id %x\n");
LAB_00028714:
      iVar3 = -8;
      goto LAB_00028724;
    }
    local_64 = uVar14 + uVar13;
  }
  uVar13 = local_38;
  uVar9 = local_38 & 0xfffffffc;
  local_38 = local_38 + 1;
  iVar3 = (*(code *)*puVar5)(param_1,uVar9,&local_34,0,param_7);
  if (-1 < iVar3) {
    uVar13 = local_34 >> ((uVar13 - uVar9) * 8 & 0xff);
    if ((uVar13 & 0xff | 2) == 3) {
      uVar9 = 0;
      local_2c = 0;
      local_30 = 0;
      while( true ) {
        uVar12 = local_38;
        uVar16 = local_38 & 0xfffffffc;
        local_38 = local_38 + 1;
        iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
        if (iVar3 < 0) break;
        uVar12 = local_34 >> ((uVar12 - uVar16) * 8 & 0xff);
        if ((uVar12 & 0xff) == 0) {
          uVar9 = 0;
          uVar12 = 0;
          goto LAB_000288c0;
        }
        if (uVar9 < 4) {
          *(char *)((int)&local_30 + uVar9) = (char)uVar12;
          uVar9 = uVar9 + 1;
        }
      }
    }
    else {
      log2Console(3,"Bugly-libunwind","Got CIE version %u, expected version 1 or 3\n",uVar13 & 0xff)
      ;
      iVar3 = -9;
    }
  }
LAB_00028724:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar3);
  }
  return;
  while( true ) {
    uVar16 = (uVar16 - uVar15) * 8;
    uVar9 = uVar9 | (local_34 >> (uVar16 & 0xff) & 0x7f) << (uVar12 & 0xff);
    uVar12 = uVar12 + 7;
    if ((local_34 >> (uVar16 & 0xff) & 0x80) == 0) break;
LAB_000288c0:
    uVar16 = local_38;
    uVar15 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_34,0,param_7);
    if (iVar3 < 0) goto LAB_00028724;
  }
  uVar12 = 0;
  uVar16 = 0;
  local_58 = uVar9;
  do {
    uVar9 = local_38;
    uVar14 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar14,&local_34,0,param_7);
    uVar15 = local_38;
    if (iVar3 < 0) goto LAB_00028724;
    uVar9 = (uVar9 - uVar14) * 8;
    uVar12 = uVar12 | (local_34 >> (uVar9 & 0xff) & 0x7f) << (uVar16 & 0xff);
    uVar16 = uVar16 + 7;
  } while ((local_34 >> (uVar9 & 0xff) & 0x80) != 0);
  local_54 = uVar12;
  if ((local_34 >> (uVar9 & 0xff) & 0x40) != 0) {
    local_54 = uVar12 | -1 << (uVar16 & 0xff);
  }
  if (0x1f < uVar16) {
    local_54 = uVar12;
  }
  if ((uVar13 & 0xff) == 1) {
    uVar13 = local_38 & 0xfffffffc;
    local_38 = local_38 + 1;
    iVar3 = (*(code *)*puVar5)(param_1,uVar13,&local_34,0,param_7);
    if (iVar3 < 0) goto LAB_00028724;
    uVar13 = local_34 >> ((uVar15 - uVar13) * 8 & 0xff) & 0xff;
  }
  else {
    uVar13 = 0;
    uVar9 = 0;
    do {
      uVar12 = local_38;
      uVar16 = local_38 & 0xfffffffc;
      local_38 = local_38 + 1;
      iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
      if (iVar3 < 0) goto LAB_00028724;
      uVar12 = (uVar12 - uVar16) * 8;
      uVar13 = uVar13 | (local_34 >> (uVar12 & 0xff) & 0x7f) << (uVar9 & 0xff);
      uVar9 = uVar9 + 7;
    } while ((local_34 >> (uVar12 & 0xff) & 0x80) != 0);
  }
  local_50 = uVar13;
  uVar13 = 0;
  if ((char)local_30 == 'z') {
    local_42 = local_42 | 1;
    do {
      uVar13 = local_38;
      uVar9 = local_38 & 0xfffffffc;
      local_38 = local_38 + 1;
      iVar3 = (*(code *)*puVar5)(param_1,uVar9,&local_34,0,param_7);
      if (iVar3 < 0) goto LAB_00028724;
    } while ((local_34 & 0x80 << ((uVar13 - uVar9) * 8 & 0xff)) != 0);
    uVar13 = 1;
  }
  uVar9 = 3;
  do {
    uVar12 = local_38;
    bVar6 = (byte)uVar9;
    switch(*(char *)((int)&local_30 + uVar13)) {
    case 'L':
      uVar16 = local_38 & 0xfffffffc;
      local_38 = local_38 + 1;
      iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
      if (iVar3 < 0) goto LAB_00028724;
      local_43 = (undefined1)(local_34 >> ((uVar12 - uVar16) * 8 & 0xff));
      break;
    case 'M':
    case 'N':
    case 'O':
    case 'Q':
      goto switchD_00028dc4_caseD_4d;
    case 'P':
      uVar16 = local_38 & 0xfffffffc;
      local_38 = local_38 + 1;
      iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_34,0,param_7);
      if ((iVar3 < 0) ||
         (iVar3 = FUN_000244d4(param_1,param_2,&local_38,
                               local_34 >> ((uVar12 - uVar16) * 8 & 0xff) & 0xff,param_4,&local_4c,
                               param_7), iVar3 < 0)) goto LAB_00028724;
      break;
    case 'R':
      uVar9 = local_38 & 0xfffffffc;
      local_38 = local_38 + 1;
      iVar3 = (*(code *)*puVar5)(param_1,uVar9,&local_34,0,param_7);
      if (iVar3 < 0) goto LAB_00028724;
      uVar9 = local_34 >> ((uVar12 - uVar9) * 8 & 0xff);
      break;
    case 'S':
      local_42 = local_42 | 6;
      break;
    default:
      if (*(char *)((int)&local_30 + uVar13) != '\0') {
switchD_00028dc4_caseD_4d:
        log2Console(3,"Bugly-libunwind","Unexpected augmentation string `%s\'\n",&local_30);
        iVar3 = -8;
        if ((local_42 & 1) == 0) goto LAB_00028724;
      }
      goto LAB_00029044;
    }
    bVar6 = (byte)uVar9;
    uVar13 = uVar13 + 1;
  } while (uVar13 < 5);
LAB_00029044:
  local_68 = local_38;
  local_44 = bVar6;
  log2Console(3,"Bugly-libunwind","CIE parsed OK, augmentation = \"%s\", handler=0x%lx\n",&local_30,
              local_4c);
  bVar6 = local_44;
  iVar3 = FUN_000244d4(param_1,param_2,&local_3c,local_44,param_4,&local_34,param_7);
  if ((-1 < iVar3) &&
     (iVar3 = FUN_000244d4(param_1,param_2,&local_3c,bVar6 & 0xf,param_4,&local_38,param_7),
     -1 < iVar3)) {
    uVar13 = 0;
    *param_4 = local_34;
    param_4[1] = local_38 + local_34;
    param_4[3] = local_4c;
    if ((local_42 & 1) != 0) {
      uVar13 = 0;
      uVar9 = 0;
      do {
        uVar12 = local_3c;
        uVar16 = local_3c & 0xfffffffc;
        local_3c = local_3c + 1;
        iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_30,0,param_7);
        if (iVar3 < 0) goto LAB_00028724;
        uVar12 = (uVar12 - uVar16) * 8;
        uVar13 = uVar13 | (local_30 >> (uVar12 & 0xff) & 0x7f) << (uVar9 & 0xff);
        uVar9 = uVar9 + 7;
      } while ((local_30 >> (uVar12 & 0xff) & 0x80) != 0);
      uVar13 = local_3c + uVar13;
    }
    iVar3 = FUN_000244d4(param_1,param_2,&local_3c,local_43,param_4,param_4 + 2,param_7);
    if (-1 < iVar3) {
      log2Console(3,"Bugly-libunwind","FDE covers IP 0x%lx-0x%lx, LSDA=0x%lx\n",*param_4,param_4[1],
                  param_4[2]);
      if (param_5 != 0) {
        param_4[6] = 1;
        param_4[7] = 0x28;
        uVar12 = FUN_00027210(&DAT_000636d8);
        uVar9 = local_3c;
        param_4[8] = uVar12;
        if (uVar12 == 0) {
          iVar3 = -2;
          goto LAB_00028724;
        }
        if ((local_42 & 2) != 0) {
          uVar15 = local_3c & 0xfffffffc;
          local_3c = local_3c + 1;
          iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_30,0,param_7);
          uVar12 = local_30;
          uVar16 = local_3c;
          if (iVar3 < 0) goto LAB_00028724;
          uVar7 = local_3c & 0xfffffffc;
          local_3c = local_3c + 1;
          iVar3 = (*(code *)*puVar5)(param_1,uVar7,&local_30,0,param_7);
          uVar14 = local_3c;
          if (iVar3 < 0) goto LAB_00028724;
          uVar16 = local_30 >> ((uVar16 - uVar7) * 8 & 0xff);
          uVar12 = uVar12 >> ((uVar9 - uVar15) * 8 & 0xff);
          if (*piVar4 == 0) {
            uVar2 = (ushort)uVar12 & 0xff;
            local_48 = (ushort)(uVar16 << 8);
          }
          else {
            local_48 = (ushort)uVar16 & 0xff;
            uVar2 = (ushort)(uVar12 << 8);
          }
          local_48 = local_48 | uVar2;
          uVar16 = local_3c & 0xfffffffc;
          local_3c = local_3c + 1;
          iVar3 = (*(code *)*puVar5)(param_1,uVar16,&local_30,0,param_7);
          uVar9 = local_30;
          uVar12 = local_3c;
          if (iVar3 < 0) goto LAB_00028724;
          uVar15 = local_3c & 0xfffffffc;
          local_3c = local_3c + 1;
          iVar3 = (*(code *)*puVar5)(param_1,uVar15,&local_30,0,param_7);
          if (iVar3 < 0) goto LAB_00028724;
          uVar12 = local_30 >> ((uVar12 - uVar15) * 8 & 0xff);
          uVar9 = uVar9 >> ((uVar14 - uVar16) * 8 & 0xff);
          if (*piVar4 == 0) {
            uVar9 = uVar9 & 0xff;
            uVar12 = uVar12 << 8;
          }
          else {
            uVar12 = uVar12 & 0xff;
            uVar9 = uVar9 << 8;
          }
          local_46 = (undefined2)(uVar12 | uVar9);
          log2Console(3,"Bugly-libunwind","Found ABI marker = (abi=%u, tag=%u)\n",local_48,
                      (uVar12 | uVar9) & 0xffff);
        }
        local_60 = uVar13;
        if ((local_42 & 1) == 0) {
          local_60 = local_3c;
        }
        local_5c = local_70;
        __aeabi_memcpy(param_4[8],&local_68,0x28);
      }
      iVar3 = 0;
    }
  }
  goto LAB_00028724;
}



void FUN_000295c4(undefined4 *param_1)

{
  char cVar1;
  byte bVar2;
  ushort uVar3;
  byte *pbVar4;
  uint uVar5;
  void *pvVar6;
  ushort *puVar7;
  byte bVar8;
  uint uVar9;
  undefined4 uVar10;
  int iVar11;
  undefined4 *puVar12;
  pthread_mutex_t *__mutex;
  int iVar13;
  int iVar14;
  int iVar15;
  short *psVar16;
  undefined1 auStack_87c [1068];
  undefined1 auStack_450 [1060];
  int local_2c;
  
  local_2c = __stack_chk_guard;
  iVar15 = param_1[1];
  if (*(int *)(iVar15 + 0x24) != 0) {
    __mutex = (pthread_mutex_t *)(iVar15 + 0x34);
    if (*(int *)(iVar15 + 0x24) == 1) {
      log2Console(3,"Bugly-libunwind","acquiring lock\n");
      pthread_mutex_lock(__mutex);
    }
    iVar11 = *(int *)(iVar15 + 0x28);
    if (iVar11 != *(int *)(iVar15 + 0x23c)) {
      *(undefined4 *)(iVar15 + 0x38) = 0x7f;
      pbVar4 = (byte *)(iVar15 + 0x662);
      iVar13 = 0;
      do {
        if (iVar13 != 0) {
          *(short *)(pbVar4 + -6) = (short)iVar13 + -1;
        }
        pbVar4[-0xffffffff0000000e] = 0;
        pbVar4[-0xffffffff0000000d] = 0;
        pbVar4[-0xffffffff0000000c] = 0;
        pbVar4[-0xffffffff0000000b] = 0;
        iVar13 = iVar13 + 1;
        pbVar4[-0xffffffff00000004] = 0xff;
        pbVar4[-0xffffffff00000003] = 0xff;
        *pbVar4 = *pbVar4 & 0xfe;
        pbVar4 = pbVar4 + 0x424;
      } while (iVar13 != 0x80);
      __aeabi_memset(iVar15 + 0x3c,0x200,0xff);
      *(int *)(iVar15 + 0x23c) = iVar11;
    }
    psVar16 = (short *)(param_1 + 0x115);
    uVar5 = (uint)*psVar16;
    iVar13 = param_1[3];
    iVar11 = *psVar16 * 0x424 + iVar15;
    pbVar4 = (byte *)(iVar11 + 0x662);
    if (((*pbVar4 & 1) == 0) || (*(int *)(iVar11 + 0x654) != iVar13)) {
      uVar5 = (uint)*(ushort *)(iVar15 + ((uint)(iVar13 * 0x7f4a7c16) >> 0x18) * 2 + 0x3c);
      if (uVar5 < 0x80) {
        do {
          iVar11 = uVar5 * 0x424 + iVar15;
          pbVar4 = (byte *)(iVar11 + 0x662);
          if (((*pbVar4 & 1) != 0) && (*(int *)(iVar11 + 0x654) == iVar13)) {
            *(short *)(*(short *)((int)param_1 + 0x456) * 0x424 + iVar15 + 0x660) = (short)uVar5;
            *psVar16 = (short)uVar5;
            goto LAB_00029a1c;
          }
          uVar5 = (uint)*(ushort *)(iVar11 + 0x65e);
        } while (uVar5 < 0x100);
      }
      pvVar6 = malloc(0x850);
      if (pvVar6 == (void *)0x0) goto LAB_00029bfc;
      puVar12 = param_1 + 0x10b;
      cVar1 = *(char *)(param_1 + 0x10a);
      __aeabi_memclr4(puVar12,0x28);
      iVar13 = iVar13 + ((int)(char)(cVar1 << 6) >> 7);
      iVar11 = FUN_0002da54(param_1[1],iVar13,puVar12,1,*param_1);
      if (iVar11 == -10) {
        iVar11 = (**(code **)param_1[1])((undefined4 *)param_1[1],iVar13,puVar12,1,*param_1);
        bVar8 = 4;
        if (-1 < iVar11) goto LAB_0002991c;
      }
      else {
        bVar8 = 0xc;
LAB_0002991c:
        if ((uint)param_1[0x111] < 3) {
          bVar2 = *(byte *)(param_1 + 0x10a);
          *(byte *)(param_1 + 0x10a) = bVar2 & 0xf3 | bVar8;
          *(byte *)(param_1 + 0x10a) =
               (*(byte *)(param_1[0x113] + 0x26) >> 1 & 2 | bVar2 & 0xf1 | bVar8) ^ 2;
          if ((-1 < iVar11) &&
             (iVar11 = FUN_00029d90(param_1,pvVar6,param_1[3]),
             iVar11 != -1 && iVar11 + 1 < 0 == SCARRY4(iVar11,1))) {
            uVar3 = *(ushort *)(iVar15 + 0x38);
            uVar5 = (uint)uVar3;
            iVar13 = iVar15 + 0x240;
            iVar14 = uVar5 * 0x424 + iVar13;
            *(undefined2 *)(iVar15 + 0x38) = *(undefined2 *)(iVar14 + 0x41c);
            *(ushort *)((uint)*(ushort *)(iVar15 + 0x3a) * 0x424 + iVar13 + 0x41c) = uVar3;
            *(ushort *)(iVar15 + 0x3a) = uVar3;
            iVar11 = *(int *)(iVar14 + 0x414);
            if (iVar11 != 0) {
              puVar7 = (ushort *)(iVar15 + ((uint)(iVar11 * 0x7f4a7c16) >> 0x18) * 2 + 0x3c);
              uVar9 = (uint)*puVar7;
              if (uVar9 == uVar5) {
                *puVar7 = *(ushort *)(uVar9 * 0x424 + iVar15 + 0x65e);
              }
              else {
                do {
                  puVar7 = (ushort *)(uVar9 * 0x424 + iVar15 + 0x65e);
                  uVar9 = (uint)*puVar7;
                  if (0x7f < uVar9) goto LAB_00029c48;
                } while (uVar9 != uVar5);
                *puVar7 = *(ushort *)(uVar5 * 0x424 + iVar15 + 0x65e);
              }
            }
LAB_00029c48:
            iVar11 = param_1[3];
            iVar15 = iVar15 + ((uint)(iVar11 * 0x7f4a7c16) >> 0x18) * 2;
            *(undefined2 *)(iVar14 + 0x41e) = *(undefined2 *)(iVar15 + 0x3c);
            *(ushort *)(iVar15 + 0x3c) = uVar3;
            *(short *)(iVar14 + 0x420) = 0;
            *(int *)(iVar14 + 0x414) = iVar11;
            bVar8 = *(byte *)(iVar14 + 0x422);
            *(byte *)(iVar14 + 0x422) = bVar8 | 1;
            uVar10 = param_1[5];
            *(byte *)(iVar14 + 0x422) = bVar8 & 0xfd | 1;
            *(undefined4 *)(iVar14 + 0x418) = uVar10;
            __aeabi_memcpy4(iVar14,(int)pvVar6 + 0x42c,0x414);
            *(ushort *)((short)*(ushort *)((int)param_1 + 0x456) * 0x424 + iVar13 + 0x420) = uVar3;
            *psVar16 = *(short *)(iVar14 + 0x420);
            *(ushort *)((int)param_1 + 0x456) = uVar3;
            if ((*(byte *)(param_1 + 0x10a) & 8) == 0) {
              if ((param_1[0x113] != 0) && (param_1[0x111] == 1)) {
                FUN_0002728c(&DAT_000636d8);
                param_1[0x113] = 0;
              }
            }
            else {
              FUN_0002db1c(param_1[1],puVar12,*param_1);
            }
            free(pvVar6);
            goto LAB_00029a54;
          }
        }
      }
      iVar15 = param_1[1];
      log2Console(3,"Bugly-libunwind","unmasking signals/interrupts and releasing lock\n");
      if (*(int *)(iVar15 + 0x24) == 1) {
        pthread_mutex_unlock(__mutex);
      }
      if ((*(byte *)(param_1 + 0x10a) & 8) == 0) {
        if ((param_1[0x113] != 0) && (param_1[0x111] == 1)) {
          FUN_0002728c(&DAT_000636d8);
          param_1[0x113] = 0;
        }
      }
      else {
        FUN_0002db1c(param_1[1],puVar12,*param_1);
      }
      free(pvVar6);
    }
    else {
LAB_00029a1c:
      iVar15 = uVar5 * 0x424 + iVar15;
      param_1[5] = *(undefined4 *)(iVar15 + 0x658);
      iVar14 = iVar15 + 0x240;
      *(byte *)(param_1 + 0x10a) = (*(byte *)(param_1 + 0x10a) & 0xfd | *pbVar4 & 2) ^ 2;
LAB_00029a54:
      pvVar6 = malloc(0x424);
      if (pvVar6 != (void *)0x0) {
        __aeabi_memcpy4(pvVar6,iVar14,0x424);
        iVar15 = param_1[1];
        log2Console(3,"Bugly-libunwind","unmasking signals/interrupts and releasing lock\n");
        if (*(int *)(iVar15 + 0x24) == 1) {
          pthread_mutex_unlock(__mutex);
        }
        FUN_00029ed4(param_1,pvVar6);
        free(pvVar6);
        if (__stack_chk_guard - local_2c != 0) {
                    // WARNING: Subroutine does not return
          __stack_chk_fail(__stack_chk_guard - local_2c);
        }
        return;
      }
    }
    goto LAB_00029bfc;
  }
  puVar12 = param_1 + 0x10b;
  iVar11 = param_1[3];
  cVar1 = *(char *)(param_1 + 0x10a);
  __aeabi_memclr4(puVar12,0x28);
  iVar11 = iVar11 + ((int)(char)(cVar1 << 6) >> 7);
  iVar15 = FUN_0002da54(iVar15,iVar11,puVar12,1,*param_1);
  if (iVar15 == -10) {
    iVar15 = (**(code **)param_1[1])((undefined4 *)param_1[1],iVar11,puVar12,1,*param_1);
    bVar8 = 4;
    if (-1 < iVar15) goto LAB_0002984c;
  }
  else {
    bVar8 = 0xc;
LAB_0002984c:
    if ((uint)param_1[0x111] < 3) {
      bVar2 = *(byte *)(param_1 + 0x10a);
      *(byte *)(param_1 + 0x10a) = bVar2 & 0xf3 | bVar8;
      *(byte *)(param_1 + 0x10a) =
           (*(byte *)(param_1[0x113] + 0x26) >> 1 & 2 | bVar2 & 0xf1 | bVar8) ^ 2;
      if ((iVar15 != -1 && iVar15 + 1 < 0 == SCARRY4(iVar15,1)) &&
         (iVar15 = FUN_00029d90(param_1,auStack_87c,param_1[3]),
         iVar15 != -1 && iVar15 + 1 < 0 == SCARRY4(iVar15,1))) {
        FUN_00029ed4(param_1,auStack_450);
        if ((*(byte *)(param_1 + 0x10a) & 8) == 0) {
          if ((param_1[0x113] != 0) && (param_1[0x111] == 1)) {
            FUN_0002728c(&DAT_000636d8);
            param_1[0x113] = 0;
          }
        }
        else {
          FUN_0002db1c(param_1[1],puVar12,*param_1);
        }
        goto LAB_00029bfc;
      }
    }
  }
  if ((*(byte *)(param_1 + 0x10a) & 8) == 0) {
    if ((param_1[0x113] != 0) && (param_1[0x111] == 1)) {
      FUN_0002728c(&DAT_000636d8);
      param_1[0x113] = 0;
    }
  }
  else {
    FUN_0002db1c(param_1[1],puVar12,*param_1);
  }
LAB_00029bfc:
  if (__stack_chk_guard - local_2c != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_2c);
  }
  return;
}



void FUN_00029d90(int param_1,int param_2,undefined4 param_3)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  undefined4 *puVar4;
  undefined4 local_28;
  int local_24;
  
  local_24 = __stack_chk_guard;
  __aeabi_memclr4(param_2,0x850);
  iVar2 = 0;
  do {
    iVar3 = param_2 + iVar2;
    iVar2 = iVar2 + 8;
    *(undefined4 *)(iVar3 + 0x430) = 1;
    *(undefined4 *)(iVar3 + 0x434) = 0;
  } while (iVar2 != 0x410);
  if (*(int *)(param_1 + 0x444) - 1U < 2) {
    puVar4 = *(undefined4 **)(param_1 + 0x44c);
    *(undefined4 *)(param_1 + 0x14) = puVar4[6];
    local_28 = *puVar4;
    uVar1 = FUN_0002a3ec(param_1,param_2,0xffffffff,&local_28,puVar4[1],puVar4);
    if (-1 < (int)uVar1) {
      __aeabi_memcpy4(param_2 + 8,param_2 + 0x42c,0x424);
      local_28 = puVar4[2];
      uVar1 = FUN_0002a3ec(param_1,param_2,param_3,&local_28,puVar4[3],puVar4);
      uVar1 = uVar1 & (int)uVar1 >> 0x1f;
    }
  }
  else if (*(int *)(param_1 + 0x444) == 0) {
    log2Console(3,"Bugly-libunwind","Not yet implemented\n");
    uVar1 = 0xfffffff6;
  }
  else {
    log2Console(3,"Bugly-libunwind","Unexpected unwind-info format %d\n");
    uVar1 = 0xfffffff8;
  }
  if (__stack_chk_guard != local_24) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar1);
  }
  return;
}



// WARNING: Removing unreachable block (ram,0x0002a038)
// WARNING: Removing unreachable block (ram,0x0002a2fc)

void FUN_00029ed4(undefined4 *param_1,int param_2)

{
  bool bVar1;
  undefined4 uVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  int iVar6;
  uint uVar7;
  uint uVar8;
  undefined4 uVar9;
  uint uVar10;
  int iVar11;
  uint uVar12;
  code *pcVar13;
  uint uVar14;
  undefined8 uVar15;
  uint local_38;
  uint local_34;
  uint local_30;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar2 = *param_1;
  uVar9 = param_1[1];
  iVar3 = param_1[2];
  uVar4 = param_1[3];
  iVar5 = _Uarm_get_accessors(uVar9);
  uVar12 = *(uint *)(param_2 + 0x408);
  if (*(int *)(param_2 + 0x404) == 3) {
    iVar6 = 3;
    if (uVar12 == 0xd) {
      iVar6 = *(int *)(param_2 + 0x6c);
    }
    if (uVar12 == 0xd && iVar6 == 1) {
      local_38 = param_1[2];
    }
    else {
      if (0xf < uVar12) {
        uVar12 = 0;
      }
      iVar6 = _Uarm_get_reg(param_1,uVar12,&local_38);
      if (iVar6 < 0) goto LAB_0002a2cc;
    }
    uVar12 = local_38 + *(int *)(param_2 + 0x410);
  }
  else {
    iVar6 = uVar12 << 3;
    uVar10 = 0;
    uVar14 = 0;
    do {
      local_30 = uVar12 + 1;
      uVar15 = (**(code **)(iVar5 + 0xc))(uVar9,uVar12 & 0xfffffffc,&local_2c,0,uVar2);
      if ((int)uVar15 < 0) goto LAB_0002a03c;
      uVar7 = iVar6 + (uVar12 & 0x1ffffffc) * -8;
      iVar6 = iVar6 + 8;
      uVar10 = uVar10 | (local_2c >> (uVar7 & 0xff) & 0x7f) << (uVar14 & 0xff);
      uVar14 = uVar14 + 7;
      uVar12 = uVar12 + 1;
    } while ((local_2c >> (uVar7 & 0xff) & 0x80) != 0);
    uVar15 = FUN_0002db8c(param_1,&local_30,uVar10,&local_34,&local_2c);
    if ((int)uVar15 < 0) {
LAB_0002a03c:
      uVar12 = (uint)((ulonglong)uVar15 >> 0x20);
      iVar6 = (int)uVar15;
      bVar1 = false;
      if (iVar6 < 0) goto LAB_0002a2cc;
    }
    else {
      uVar12 = local_34;
      if (local_2c == 0) {
        bVar1 = false;
      }
      else {
        if (0xf < local_34) {
          uVar12 = 0;
        }
        bVar1 = true;
      }
    }
    iVar6 = -7;
    if (bVar1) goto LAB_0002a2cc;
  }
  uVar14 = 0;
  local_38 = uVar12;
  do {
    iVar6 = param_2 + uVar14 * 8;
    switch(*(undefined4 *)(iVar6 + 4)) {
    case 0:
      param_1[uVar14 * 2 + 10] = 0;
      param_1[uVar14 * 2 + 0xb] = 0;
      break;
    case 2:
      param_1[uVar14 * 2 + 10] = *(int *)(iVar6 + 8) + local_38;
      param_1[uVar14 * 2 + 0xb] = 0;
      break;
    case 3:
      uVar12 = *(uint *)(iVar6 + 8);
      if (0xf < uVar12) {
        uVar12 = 0;
      }
      param_1[uVar14 * 2 + 10] = uVar12;
      param_1[uVar14 * 2 + 0xb] = 2;
      break;
    case 4:
      uVar10 = 0;
      uVar7 = 0;
      iVar11 = *(uint *)(iVar6 + 8) << 3;
      uVar12 = *(uint *)(iVar6 + 8);
      do {
        local_30 = uVar12 + 1;
        iVar6 = (**(code **)(iVar5 + 0xc))(uVar9,uVar12 & 0xfffffffc,&local_2c,0,uVar2);
        if (iVar6 < 0) goto LAB_0002a208;
        uVar8 = iVar11 + (uVar12 & 0x1ffffffc) * -8;
        iVar11 = iVar11 + 8;
        uVar10 = uVar10 | (local_2c >> (uVar8 & 0xff) & 0x7f) << (uVar7 & 0xff);
        uVar7 = uVar7 + 7;
        uVar12 = uVar12 + 1;
      } while ((local_2c >> (uVar8 & 0xff) & 0x80) != 0);
      iVar6 = FUN_0002db8c(param_1,&local_30,uVar10,&local_34,&local_2c);
      if (-1 < iVar6) {
        if (local_2c == 0) {
          param_1[uVar14 * 2 + 10] = local_34;
          iVar6 = 0;
          param_1[uVar14 * 2 + 0xb] = 0;
        }
        else {
          iVar6 = 0;
          uVar12 = local_34;
          if (0xf < local_34) {
            uVar12 = 0;
          }
          param_1[uVar14 * 2 + 10] = uVar12;
          param_1[uVar14 * 2 + 0xb] = 2;
        }
      }
LAB_0002a208:
      if (iVar6 < 0) goto LAB_0002a2cc;
    }
    uVar14 = uVar14 + 1;
  } while (uVar14 < 0x80);
  param_1[2] = local_38;
  uVar12 = 0;
  if (param_1[param_1[5] * 2 + 0xb] != 0 || param_1[param_1[5] * 2 + 10] != 0) {
    iVar5 = param_1[1];
    if ((param_1[param_1[5] * 2 + 0xb] & 2) == 0) {
      pcVar13 = *(code **)(iVar5 + 0xc);
    }
    else {
      pcVar13 = *(code **)(iVar5 + 0x10);
    }
    iVar6 = (*pcVar13)(iVar5,param_1[param_1[5] * 2 + 10],&local_2c,0,*param_1);
    uVar12 = local_2c;
    if (iVar6 < 0) goto LAB_0002a2cc;
  }
  param_1[3] = uVar12;
  if (uVar12 == uVar4) {
    iVar6 = 0;
    if (param_1[2] == iVar3) {
      log2Console(3,"Bugly-libunwind","%s: ip and cfa unchanged; stopping here (ip=0x%lx)\n",
                  "apply_reg_state",uVar4);
      iVar6 = -7;
    }
  }
  else {
    iVar6 = 0;
  }
LAB_0002a2cc:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar6);
  }
  return;
}



int FUN_0002a31c(undefined4 *param_1)

{
  int iVar1;
  byte bVar2;
  int iVar3;
  undefined4 *puVar4;
  
  iVar3 = 0;
  if ((*(byte *)(param_1 + 0x10a) & 4) == 0) {
    iVar3 = param_1[3] + ((int)(char)(*(byte *)(param_1 + 0x10a) << 6) >> 7);
    puVar4 = param_1 + 0x10b;
    __aeabi_memclr4(puVar4,0x28);
    iVar1 = FUN_0002da54(param_1[1],iVar3,puVar4,0,*param_1);
    if (iVar1 == -10) {
      iVar1 = (**(code **)param_1[1])((undefined4 *)param_1[1],iVar3,puVar4,0,*param_1);
      bVar2 = 4;
      if (iVar1 < 0) {
        return iVar1;
      }
    }
    else {
      bVar2 = 0xc;
    }
    iVar3 = -10;
    if ((uint)param_1[0x111] < 3) {
      *(byte *)(param_1 + 0x10a) = *(byte *)(param_1 + 0x10a) & 0xf3 | bVar2;
      iVar3 = iVar1;
    }
  }
  return iVar3;
}



// WARNING: Type propagation algorithm not settling

void FUN_0002a3ec(uint *param_1,int param_2,uint param_3,uint *param_4,uint param_5,int param_6)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  int *piVar5;
  uint *puVar6;
  char *pcVar7;
  int iVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  uint uVar12;
  uint uVar13;
  undefined4 *puVar14;
  int *piVar15;
  uint local_68;
  uint local_64;
  int *local_4c;
  uint local_44;
  uint local_30;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  uVar1 = param_1[0x110];
  puVar6 = &_Uarm_local_addr_space;
  if ((uVar1 & 0x20) == 0) {
    puVar6 = param_1 + 1;
  }
  uVar13 = *param_1;
  uVar2 = *puVar6;
  iVar3 = _Uarm_get_accessors();
  local_30 = param_1[0x10b];
  if ((uVar1 & 0x20) != 0) {
    uVar13 = 0;
  }
  if (local_30 <= param_3) {
    puVar14 = (undefined4 *)(iVar3 + 0xc);
    piVar15 = (int *)0x0;
    local_44 = 0;
    local_4c = (int *)0x0;
    do {
      uVar1 = *param_4;
      if (param_5 <= uVar1) break;
      *param_4 = uVar1 + 1;
      iVar4 = (*(code *)*puVar14)(uVar2,uVar1 & 0xfffffffc,&local_2c,0,uVar13);
      if (iVar4 < 0) goto LAB_0002bb6c;
      uVar1 = local_2c >> ((uVar1 - (uVar1 & 0xfffffffc)) * 8 & 0xff);
      if ((uVar1 & 0xc0) != 0) {
        local_44 = uVar1 & 0x3f;
        uVar1 = uVar1 & 0xffffffc0;
      }
      switch(uVar1 & 0xff) {
      case 1:
        iVar4 = FUN_000244d4(uVar2,iVar3,param_4,*(undefined1 *)(param_6 + 0x24),param_1 + 0x10b,
                             &local_30,uVar13);
        if (iVar4 < 0) goto joined_r0x0002bb44;
        log2Console(3,"Bugly-libunwind","CFA_set_loc to 0x%lx\n",local_30);
        break;
      case 2:
        uVar1 = *param_4;
        *param_4 = uVar1 + 1;
        iVar4 = (*(code *)*puVar14)(uVar2,uVar1 & 0xfffffffc,&local_2c,0,uVar13);
        if (iVar4 < 0) goto joined_r0x0002bb44;
        local_30 = *(int *)(param_6 + 0x10) *
                   (local_2c >> ((uVar1 - (uVar1 & 0xfffffffc)) * 8 & 0xff) & 0xff) + local_30;
        log2Console(3,"Bugly-libunwind","CFA_advance_loc1 to 0x%lx\n");
        break;
      case 3:
        uVar12 = *param_4;
        *param_4 = uVar12 + 1;
        iVar4 = (*(code *)*puVar14)(uVar2,uVar12 & 0xfffffffc,&local_2c,0,uVar13);
        uVar1 = local_2c;
        if (iVar4 < 0) goto joined_r0x0002bb44;
        uVar11 = *param_4;
        *param_4 = uVar11 + 1;
        iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
        if (iVar4 < 0) goto joined_r0x0002bb44;
        uVar1 = uVar1 >> ((uVar12 - (uVar12 & 0xfffffffc)) * 8 & 0xff);
        uVar12 = local_2c >> ((uVar11 - (uVar11 & 0xfffffffc)) * 8 & 0xff);
        uVar11 = uVar12 & 0xff | uVar1 << 8;
        if (*(int *)(uVar2 + 0x20) == 0) {
          uVar11 = uVar1 & 0xff | uVar12 << 8;
        }
        local_30 = *(int *)(param_6 + 0x10) * (uVar11 & 0xffff) + local_30;
        log2Console(3,"Bugly-libunwind","CFA_advance_loc2 to 0x%lx\n");
        break;
      case 4:
        uVar1 = *param_4;
        *param_4 = uVar1 + 1;
        iVar4 = (*(code *)*puVar14)(uVar2,uVar1 & 0xfffffffc,&local_2c,0,uVar13);
        local_64 = local_2c;
        if (iVar4 < 0) goto joined_r0x0002bb44;
        uVar12 = *param_4;
        *param_4 = uVar12 + 1;
        iVar4 = (*(code *)*puVar14)(uVar2,uVar12 & 0xfffffffc,&local_2c,0,uVar13);
        if (iVar4 < 0) goto joined_r0x0002bb44;
        local_64 = local_64 >> ((uVar1 - (uVar1 & 0xfffffffc)) * 8 & 0xff);
        local_68 = local_2c >> ((uVar12 - (uVar12 & 0xfffffffc)) * 8 & 0xff);
        if (*(int *)(uVar2 + 0x20) == 0) {
          local_64 = local_64 & 0xff;
          local_68 = local_68 << 8;
        }
        else {
          local_68 = local_68 & 0xff;
          local_64 = local_64 << 8;
        }
        uVar12 = *param_4;
        *param_4 = uVar12 + 1;
        iVar4 = (*(code *)*puVar14)(uVar2,uVar12 & 0xfffffffc,&local_2c,0,uVar13);
        uVar1 = local_2c;
        if (iVar4 < 0) goto joined_r0x0002bb44;
        uVar11 = *param_4;
        *param_4 = uVar11 + 1;
        iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
        if (iVar4 < 0) goto joined_r0x0002bb44;
        uVar1 = uVar1 >> ((uVar12 - (uVar12 & 0xfffffffc)) * 8 & 0xff);
        uVar12 = local_2c >> ((uVar11 - (uVar11 & 0xfffffffc)) * 8 & 0xff);
        if (*(int *)(uVar2 + 0x20) == 0) {
          uVar1 = ((local_68 | local_64) & 0xffff) + (uVar1 & 0xff | uVar12 << 8) * 0x10000;
        }
        else {
          uVar1 = (local_68 | local_64) << 0x10 | (uVar1 & 0xff) << 8 | uVar12 & 0xff;
        }
        local_30 = *(int *)(param_6 + 0x10) * uVar1 + local_30;
        log2Console(3,"Bugly-libunwind","CFA_advance_loc4 to 0x%lx\n");
        break;
      case 5:
        uVar12 = 0;
        uVar1 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar12 = uVar12 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        uVar1 = uVar12;
        if (uVar12 < 0x80) {
          uVar9 = 0;
          uVar1 = 0;
          do {
            uVar11 = *param_4;
            *param_4 = uVar11 + 1;
            iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
            if (iVar4 < 0) goto joined_r0x0002bb44;
            uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
            uVar9 = uVar9 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
            uVar1 = uVar1 + 7;
          } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
          uVar9 = *(int *)(param_6 + 0x14) * uVar9;
          pcVar7 = "CFA_offset_extended r%lu at cf+0x%lx\n";
          goto LAB_0002b4b0;
        }
LAB_0002bbe8:
        local_44 = uVar1;
        pcVar7 = "Invalid register number %u\n";
LAB_0002bc88:
        log2Console(3,"Bugly-libunwind",pcVar7,local_44);
        goto joined_r0x0002bb44;
      case 6:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        if (uVar1 < 0x80) {
          iVar4 = param_2 + uVar1 * 8;
          *(undefined4 *)(iVar4 + 0x434) = *(undefined4 *)(iVar4 + 0x10);
          pcVar7 = "CFA_restore_extended r%lu\n";
          *(undefined4 *)(iVar4 + 0x430) = *(undefined4 *)(iVar4 + 0xc);
          goto LAB_0002b76c;
        }
        pcVar7 = "Invalid register number %u in DW_CFA_restore_extended\n";
        local_44 = uVar1;
        goto LAB_0002bbb8;
      case 7:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        if (0x7f < uVar1) {
LAB_0002bc04:
          local_44 = uVar1;
          pcVar7 = "Invalid register number %u\n";
          goto LAB_0002bc88;
        }
        pcVar7 = "CFA_undefined r%lu\n";
        iVar4 = param_2 + uVar1 * 8;
        *(undefined4 *)(iVar4 + 0x430) = 0;
        goto LAB_0002ad90;
      case 8:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        if (0x7f < uVar1) goto LAB_0002bc04;
        pcVar7 = "CFA_same_value r%lu\n";
        iVar4 = param_2 + uVar1 * 8;
        *(undefined4 *)(iVar4 + 0x430) = 1;
LAB_0002ad90:
        *(undefined4 *)(iVar4 + 0x434) = 0;
        goto LAB_0002b76c;
      case 9:
        uVar12 = 0;
        uVar1 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar12 = uVar12 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        uVar1 = uVar12;
        if (0x7f < uVar12) goto LAB_0002bbe8;
        uVar9 = 0;
        uVar1 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar9 = uVar9 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        pcVar7 = "CFA_register r%lu to r%lu\n";
        iVar4 = param_2 + uVar12 * 8;
        *(undefined4 *)(iVar4 + 0x430) = 3;
        *(uint *)(iVar4 + 0x434) = uVar9;
        goto LAB_0002b610;
      case 10:
        piVar5 = (int *)FUN_00027210(&DAT_000636f0);
        if (piVar5 == (int *)0x0) {
          log2Console(3,"Bugly-libunwind","Out of memory in DW_CFA_remember_state\n");
          goto joined_r0x0002bb44;
        }
        __aeabi_memcpy4(piVar5 + 1,param_2 + 0x430,0x410);
        *piVar5 = (int)piVar15;
        log2Console(3,"Bugly-libunwind","CFA_remember_state\n");
        piVar15 = piVar5;
        local_4c = piVar5;
        break;
      case 0xb:
        if (piVar15 == (int *)0x0) {
          log2Console(3,"Bugly-libunwind","register-state stack underflow\n");
          goto LAB_0002bb6c;
        }
        __aeabi_memcpy4(param_2 + 0x430,piVar15 + 1,0x410);
        local_4c = (int *)*piVar15;
        FUN_0002728c(&DAT_000636f0,piVar15);
        log2Console(3,"Bugly-libunwind","CFA_restore_state\n");
        piVar15 = local_4c;
        break;
      case 0xc:
        uVar12 = 0;
        uVar1 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar12 = uVar12 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        uVar1 = uVar12;
        if (0x7f < uVar12) goto LAB_0002bbe8;
        uVar9 = 0;
        uVar1 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar9 = uVar9 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        pcVar7 = "CFA_def_cfa r%lu+0x%lx\n";
        *(undefined4 *)(param_2 + 0x830) = 3;
        *(uint *)(param_2 + 0x834) = uVar12;
        *(undefined4 *)(param_2 + 0x838) = 0;
        *(uint *)(param_2 + 0x83c) = uVar9;
        goto LAB_0002b610;
      case 0xd:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        if (0x7f < uVar1) goto LAB_0002bc04;
        pcVar7 = "CFA_def_cfa_register r%lu\n";
        *(undefined4 *)(param_2 + 0x830) = 3;
        *(uint *)(param_2 + 0x834) = uVar1;
        goto LAB_0002b76c;
      case 0xe:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        pcVar7 = "CFA_def_cfa_offset 0x%lx\n";
        *(undefined4 *)(param_2 + 0x838) = 0;
        *(uint *)(param_2 + 0x83c) = uVar1;
        goto LAB_0002b76c;
      case 0xf:
        uVar1 = *param_4;
        uVar11 = 0;
        uVar12 = 0;
        *(undefined4 *)(param_2 + 0x830) = 4;
        *(uint *)(param_2 + 0x834) = uVar1;
        do {
          uVar1 = *param_4;
          *param_4 = uVar1 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar1 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar1 = (uVar1 - (uVar1 & 0xfffffffc)) * 8;
          uVar11 = uVar11 | (local_2c >> (uVar1 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar1 & 0xff) & 0x80) != 0);
        log2Console(3,"Bugly-libunwind","CFA_def_cfa_expr @ 0x%lx [%lu bytes]\n",*param_4,uVar11);
        *param_4 = *param_4 + uVar11;
        break;
      case 0x10:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        if (0x7f < uVar1) goto LAB_0002bbe8;
        uVar12 = *param_4;
        uVar9 = 0;
        iVar4 = param_2 + uVar1 * 8;
        uVar11 = 0;
        *(undefined4 *)(iVar4 + 0x430) = 4;
        *(uint *)(iVar4 + 0x434) = uVar12;
        do {
          uVar12 = *param_4;
          *param_4 = uVar12 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar12 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar12 = (uVar12 - (uVar12 & 0xfffffffc)) * 8;
          uVar9 = uVar9 | (local_2c >> (uVar12 & 0xff) & 0x7f) << (uVar11 & 0xff);
          uVar11 = uVar11 + 7;
        } while ((local_2c >> (uVar12 & 0xff) & 0x80) != 0);
        log2Console(3,"Bugly-libunwind","CFA_expression r%lu @ 0x%lx [%lu bytes]\n",uVar1,param_4,
                    uVar9);
        *param_4 = *param_4 + uVar9;
        break;
      case 0x11:
        uVar12 = 0;
        uVar1 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar12 = uVar12 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        uVar1 = uVar12;
        if (0x7f < uVar12) goto LAB_0002bbe8;
        uVar11 = 0;
        uVar1 = 0;
        do {
          uVar9 = *param_4;
          *param_4 = uVar9 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar9 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar10 = (uVar9 - (uVar9 & 0xfffffffc)) * 8;
          uVar11 = uVar11 | (local_2c >> (uVar10 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar10 & 0xff) & 0x80) != 0);
        uVar9 = uVar11;
        if ((local_2c >> (uVar10 & 0xff) & 0x40) != 0) {
          uVar9 = uVar11 | -1 << (uVar1 & 0xff);
        }
        if (0x1f < uVar1) {
          uVar9 = uVar11;
        }
        uVar9 = *(int *)(param_6 + 0x14) * uVar9;
        pcVar7 = "CFA_offset_extended_sf r%lu at cf+0x%lx\n";
LAB_0002b4b0:
        iVar4 = param_2 + uVar12 * 8;
        *(undefined4 *)(iVar4 + 0x430) = 2;
        *(uint *)(iVar4 + 0x434) = uVar9;
        goto LAB_0002b610;
      case 0x12:
        uVar12 = 0;
        uVar1 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar12 = uVar12 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar1 & 0xff);
          uVar1 = uVar1 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        uVar1 = uVar12;
        if (0x7f < uVar12) goto LAB_0002bbe8;
        uVar1 = 0;
        uVar11 = 0;
        do {
          uVar9 = *param_4;
          *param_4 = uVar9 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar9 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar10 = (uVar9 - (uVar9 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar10 & 0xff) & 0x7f) << (uVar11 & 0xff);
          uVar11 = uVar11 + 7;
        } while ((local_2c >> (uVar10 & 0xff) & 0x80) != 0);
        *(uint *)(param_2 + 0x834) = uVar12;
        *(undefined4 *)(param_2 + 0x830) = 3;
        uVar9 = uVar1;
        if ((local_2c >> (uVar10 & 0xff) & 0x40) != 0) {
          uVar9 = uVar1 | -1 << (uVar11 & 0xff);
        }
        if (0x1f < uVar11) {
          uVar9 = uVar1;
        }
        uVar9 = *(int *)(param_6 + 0x14) * uVar9;
        *(undefined4 *)(param_2 + 0x838) = 0;
        pcVar7 = "CFA_def_cfa_sf r%lu+0x%lx\n";
        *(uint *)(param_2 + 0x83c) = uVar9;
        goto LAB_0002b610;
      case 0x13:
        uVar12 = 0;
        uVar11 = 0;
        do {
          uVar1 = *param_4;
          *param_4 = uVar1 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar1 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar9 = (uVar1 - (uVar1 & 0xfffffffc)) * 8;
          uVar12 = uVar12 | (local_2c >> (uVar9 & 0xff) & 0x7f) << (uVar11 & 0xff);
          uVar11 = uVar11 + 7;
        } while ((local_2c >> (uVar9 & 0xff) & 0x80) != 0);
        uVar1 = uVar12;
        if ((local_2c >> (uVar9 & 0xff) & 0x40) != 0) {
          uVar1 = uVar12 | -1 << (uVar11 & 0xff);
        }
        if (0x1f < uVar11) {
          uVar1 = uVar12;
        }
        uVar1 = *(int *)(param_6 + 0x14) * uVar1;
        pcVar7 = "CFA_def_cfa_offset_sf 0x%lx\n";
        *(undefined4 *)(param_2 + 0x838) = 0;
        *(uint *)(param_2 + 0x83c) = uVar1;
        goto LAB_0002b76c;
      case 0x1c:
      case 0x2d:
      case 0x3c:
        local_44 = uVar1 & 0xff;
        pcVar7 = "Unexpected CFA opcode 0x%x\n";
        goto LAB_0002bbb8;
      case 0x1d:
        log2Console(3,"Bugly-libunwind","DW_CFA_MIPS_advance_loc8 on non-MIPS target\n");
        goto joined_r0x0002bb44;
      case 0x2e:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        pcVar7 = "CFA_GNU_args_size %lu\n";
        *(uint *)(param_2 + 4) = uVar1;
LAB_0002b76c:
        log2Console(3,"Bugly-libunwind",pcVar7,uVar1);
        break;
      case 0x2f:
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        if (0x7f < uVar1) goto LAB_0002bbe8;
        uVar11 = 0;
        uVar12 = 0;
        do {
          uVar10 = *param_4;
          *param_4 = uVar10 + 1;
          uVar9 = uVar13;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar10 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar10 = (uVar10 - (uVar10 & 0xfffffffc)) * 8;
          uVar11 = uVar11 | (local_2c >> (uVar10 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar10 & 0xff) & 0x80) != 0);
        pcVar7 = "CFA_GNU_negative_offset_extended cfa+0x%lx\n";
        uVar12 = *(int *)(param_6 + 0x14) * -uVar11;
        iVar4 = param_2 + uVar1 * 8;
        *(undefined4 *)(iVar4 + 0x430) = 2;
        *(uint *)(iVar4 + 0x434) = uVar12;
LAB_0002b610:
        log2Console(3,"Bugly-libunwind",pcVar7,uVar12,uVar9);
        break;
      case 0x40:
        local_30 = *(int *)(param_6 + 0x10) * local_44 + local_30;
        pcVar7 = "CFA_advance_loc to 0x%lx\n";
LAB_0002b9e0:
        log2Console(3,"Bugly-libunwind",pcVar7);
        break;
      case 0x80:
        if (0x7f < local_44) {
          pcVar7 = "Invalid register number %u in DW_cfa_OFFSET\n";
          goto LAB_0002bc88;
        }
        uVar1 = 0;
        uVar12 = 0;
        do {
          uVar11 = *param_4;
          *param_4 = uVar11 + 1;
          iVar4 = (*(code *)*puVar14)(uVar2,uVar11 & 0xfffffffc,&local_2c,0,uVar13);
          if (iVar4 < 0) goto joined_r0x0002bb44;
          uVar11 = (uVar11 - (uVar11 & 0xfffffffc)) * 8;
          uVar1 = uVar1 | (local_2c >> (uVar11 & 0xff) & 0x7f) << (uVar12 & 0xff);
          uVar12 = uVar12 + 7;
        } while ((local_2c >> (uVar11 & 0xff) & 0x80) != 0);
        iVar4 = *(int *)(param_6 + 0x14) * uVar1;
        iVar8 = param_2 + local_44 * 8;
        *(undefined4 *)(iVar8 + 0x430) = 2;
        *(int *)(iVar8 + 0x434) = iVar4;
        log2Console(3,"Bugly-libunwind","CFA_offset r%lu at cfa+0x%lx\n",local_44,iVar4);
        break;
      case 0xc0:
        if (local_44 < 0x80) {
          iVar4 = param_2 + local_44 * 8;
          *(undefined4 *)(iVar4 + 0x430) = *(undefined4 *)(iVar4 + 0xc);
          pcVar7 = "CFA_restore r%lu\n";
          *(undefined4 *)(iVar4 + 0x434) = *(undefined4 *)(iVar4 + 0x10);
          goto LAB_0002b9e0;
        }
        pcVar7 = "Invalid register number %u in DW_CFA_restore\n";
LAB_0002bbb8:
        log2Console(3,"Bugly-libunwind",pcVar7,local_44);
        goto joined_r0x0002bb44;
      }
    } while (local_30 <= param_3);
joined_r0x0002bb44:
    while (piVar15 != (int *)0x0) {
      piVar15 = (int *)*piVar15;
      FUN_0002728c(&DAT_000636f0,local_4c);
      local_4c = piVar15;
    }
  }
LAB_0002bb6c:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void _Uarm_get_elf_image(int param_1,int *param_2,int param_3,undefined4 param_4,int *param_5,
                        int *param_6,undefined4 *param_7,int param_8)

{
  char cVar1;
  __pid_t _Var2;
  int *piVar3;
  int iVar4;
  int iVar5;
  void *pvVar6;
  uint *__addr;
  char *pcVar7;
  uint uVar8;
  int iVar9;
  int *piVar10;
  bool bVar11;
  bool bVar12;
  stat local_90;
  int local_28;
  
  local_28 = __stack_chk_guard;
  _Var2 = getpid();
  if (_Var2 == param_3) {
    local_get_elf_image(param_1,param_2,param_4,param_5,param_6,param_7,param_8);
    if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
      __stack_chk_fail();
    }
    return;
  }
  piVar3 = (int *)FUN_00027548(*(undefined4 *)(param_1 + 0x21444),param_4);
  if (piVar3 == (int *)0x0) goto LAB_0002c06c;
  pthread_mutex_lock((pthread_mutex_t *)(piVar3 + 6));
  piVar10 = piVar3 + 7;
  if (*(char *)((int)piVar3 + 0x1d) != '\0') goto LAB_0002bffc;
  *(undefined1 *)((int)piVar3 + 0x1d) = 1;
  iVar4 = open((char *)piVar3[5],0);
  if (iVar4 < 0) {
LAB_0002bf30:
    if ((*(byte *)(piVar3 + 4) & 1) == 0) {
      if ((char)*piVar10 != '\0') goto LAB_0002bfe0;
    }
    else {
      bVar11 = false;
      piVar3[8] = param_1;
      piVar3[9] = param_8;
      piVar3[10] = (int)piVar3;
      iVar4 = _Uelf32_memory_read(piVar10,*piVar3,&local_90,4,0);
      if ((iVar4 == 4) && ((int)local_90.st_dev == 0x464c457f)) {
        bVar11 = false;
        uVar8 = _Uelf32_memory_read(piVar10,*piVar3 + 4,(undefined1 *)((int)&local_90.st_dev + 4),
                                    0xc,0);
        bVar12 = uVar8 == 0xc;
        if (bVar12) {
          uVar8 = (uint)local_90.st_dev._4_1_;
        }
        if (bVar12 && uVar8 == 1) {
          bVar11 = local_90.st_dev._6_1_ == '\x01';
        }
      }
      *(bool *)piVar10 = bVar11;
      if (bVar11) goto LAB_0002bfe0;
    }
  }
  else {
    iVar5 = fstat(iVar4,&local_90);
    if (iVar5 == -1) {
      close(iVar4);
      goto LAB_0002bf30;
    }
    piVar3[9] = local_90.st_blksize;
    pvVar6 = mmap((void *)0x0,local_90.st_blksize,1,2,iVar4,0);
    piVar3[8] = (int)pvVar6;
    close(iVar4);
    __addr = (uint *)piVar3[8];
    if (__addr == (uint *)0xffffffff) goto LAB_0002bf30;
    if ((uint)piVar3[9] < 7) {
LAB_0002bf18:
      *(char *)piVar10 = '\0';
LAB_0002bf20:
      munmap(__addr,piVar3[9]);
      goto LAB_0002bf30;
    }
    uVar8 = *__addr;
    bVar11 = uVar8 == 0x464c457f;
    if (bVar11) {
      uVar8 = (uint)(byte)__addr[1];
    }
    if (!bVar11 || uVar8 != 1) goto LAB_0002bf18;
    cVar1 = *(char *)((int)__addr + 6);
    *(bool *)piVar10 = cVar1 == '\x01';
    if (cVar1 != '\x01') goto LAB_0002bf20;
    *(undefined2 *)((int)piVar3 + 0x1d) = 0x101;
LAB_0002bfe0:
    iVar4 = FUN_00026d30(piVar10,piVar3[2],&local_90);
    if (iVar4 != 0) {
      piVar3[3] = (int)local_90.st_dev;
    }
  }
LAB_0002bffc:
  pthread_mutex_unlock((pthread_mutex_t *)(piVar3 + 6));
  if ((char)*piVar10 != '\0') {
    iVar4 = piVar3[8];
    iVar5 = piVar3[9];
    iVar9 = piVar3[10];
    *param_2 = piVar3[7];
    param_2[1] = iVar4;
    param_2[2] = iVar5;
    param_2[3] = iVar9;
    *param_5 = *piVar3;
    iVar4 = 0;
    if (*(char *)((int)param_2 + 2) != '\0') {
      iVar4 = piVar3[2];
    }
    *param_6 = iVar4;
    if (param_7 != (undefined4 *)0x0) {
      pcVar7 = strdup((char *)piVar3[5]);
      *param_7 = pcVar7;
    }
  }
LAB_0002c06c:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



void FUN_0002c0b8(int param_1,int param_2)

{
  char cVar1;
  char *pcVar2;
  size_t __len;
  byte *__addr;
  byte *pbVar3;
  int iVar4;
  ssize_t sVar5;
  byte *pbVar6;
  byte *pbVar7;
  uint *puVar8;
  char *pcVar9;
  uint *puVar10;
  byte *pbVar11;
  char *pcVar12;
  int iVar13;
  uint uVar14;
  uint uVar15;
  uint uVar16;
  uint uVar17;
  uint *puVar18;
  int iVar19;
  uint uVar20;
  uint uVar21;
  uint uVar22;
  uint uVar23;
  bool bVar24;
  bool bVar25;
  uint uStack_21514;
  uint *puStack_21510;
  byte *pbStack_214f4;
  bool bStack_214f0;
  ushort uStack_214ef;
  uint *puStack_214ec;
  uint uStack_214e8;
  uint *puStack_214e4;
  uint uStack_214e0;
  undefined2 uStack_214dc;
  stat local_98;
  int local_2c;
  
  pcVar12 = (char *)((uint)&uStack_214e0 | 6);
  local_2c = __stack_chk_guard;
  uStack_214dc = 0x2f63;
  uStack_214e0 = 0x6f72702f;
  pcVar9 = pcVar12;
  iVar13 = param_2;
  do {
    pcVar2 = pcVar9;
    uVar22 = iVar13 + 9;
    *pcVar2 = (char)iVar13 + (char)(iVar13 / 10) * -10 + '0';
    pcVar9 = pcVar2 + 1;
    iVar13 = iVar13 / 10;
  } while (0x12 < uVar22);
  iVar13 = (int)(pcVar2 + 1) - (int)pcVar12;
  if (1 < iVar13) {
    iVar13 = iVar13 / 2;
    pcVar9 = (char *)((uint)&uStack_214e0 | 6);
    pcVar12 = pcVar2;
    do {
      cVar1 = *pcVar9;
      iVar13 = iVar13 + -1;
      *pcVar9 = *pcVar12;
      *pcVar12 = cVar1;
      pcVar9 = pcVar9 + 1;
      pcVar12 = pcVar12 + -1;
    } while (iVar13 != 0);
  }
  builtin_strncpy(pcVar2 + 1,"/maps",6);
  iVar13 = open((char *)&uStack_214e0,0);
  if (-1 < iVar13) {
    __len = sysconf(0x27);
    __addr = (byte *)mmap((void *)0x0,__len,3,0x22,-1,0);
    if (__addr != (byte *)0xffffffff) {
      uStack_21514 = 0;
      pbVar3 = __addr + __len;
      puStack_21510 = (uint *)0x0;
      pbVar7 = pbVar3;
      puVar18 = (uint *)0x0;
LAB_0002c234:
      pbStack_214f4 = pbVar7;
      iVar19 = (int)pbVar3 - (int)pbStack_214f4;
      if (0 < iVar19) {
        iVar4 = 0;
        do {
          if (pbStack_214f4[iVar4] == 0) break;
          if (pbStack_214f4[iVar4] == 10) {
            pbVar6 = pbStack_214f4 + iVar4;
            if (pbVar6 != (byte *)0x0) goto LAB_0002c2f8;
            break;
          }
          iVar4 = iVar4 + 1;
        } while (iVar4 < iVar19);
        __aeabi_memmove(__addr,pbStack_214f4,iVar19);
      }
      sVar5 = read(iVar13,__addr + iVar19,__len - iVar19);
      if (0 < sVar5) {
        uVar22 = sVar5 + iVar19;
        pbStack_214f4 = __addr;
        if (uVar22 < __len) {
          pbStack_214f4 = pbVar3 + (-iVar19 - sVar5);
          __aeabi_memmove(pbStack_214f4,__addr,uVar22);
        }
        pbVar6 = pbStack_214f4 + sVar5 + iVar19 + -1;
        do {
          if (pbStack_214f4[iVar19] == 10) {
            pbVar6 = pbStack_214f4 + iVar19;
            break;
          }
          iVar19 = iVar19 + 1;
        } while (iVar19 < (int)uVar22);
LAB_0002c2f8:
        pbVar7 = pbVar6 + 1;
        *pbVar6 = 0;
        for (; uVar22 = (uint)*pbStack_214f4, uVar22 == 9 || uVar22 == 0x20;
            pbStack_214f4 = pbStack_214f4 + 1) {
        }
        uVar17 = 0;
        iVar19 = 0;
        do {
          uVar14 = uVar22 - 0x30;
          if (9 < uVar14) {
            if (uVar22 - 0x61 < 6) {
              uVar14 = uVar22 - 0x57;
            }
            else {
              if (5 < uVar22 - 0x41) goto LAB_0002c36c;
              uVar14 = uVar22 - 0x37;
            }
          }
          uVar17 = uVar14 | uVar17 << 4;
          uVar22 = (uint)pbStack_214f4[1 - iVar19];
          iVar19 = iVar19 + -1;
        } while( true );
      }
      close(iVar13);
      if (__addr != (byte *)0x0) goto LAB_0002ca04;
      goto LAB_0002ca10;
    }
    close(iVar13);
  }
LAB_0002ca40:
  if (__stack_chk_guard - local_2c == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_2c);
LAB_0002c36c:
  if (iVar19 != 0) {
    pbStack_214f4 = pbStack_214f4 + -iVar19;
    if (uVar22 != 0) {
      pbStack_214f4 = pbStack_214f4 + 1;
    }
    uVar14 = ~(uint)pbStack_214f4;
    for (; uVar15 = (uint)*pbStack_214f4, uVar15 == 9 || uVar15 == 0x20;
        pbStack_214f4 = pbStack_214f4 + 1) {
      uVar14 = uVar14 - 1;
    }
    uVar23 = 0;
    iVar19 = 0;
    do {
      uVar20 = uVar15 - 0x30;
      if (9 < uVar20) {
        if (uVar15 - 0x61 < 6) {
          uVar20 = uVar15 - 0x57;
        }
        else {
          if (5 < uVar15 - 0x41) goto LAB_0002c3f8;
          uVar20 = uVar15 - 0x37;
        }
      }
      uVar23 = uVar20 | uVar23 << 4;
      uVar14 = uVar14 - 1;
      uVar15 = (uint)pbStack_214f4[1 - iVar19];
      iVar19 = iVar19 + -1;
    } while( true );
  }
  goto LAB_0002c234;
LAB_0002c3f8:
  if (iVar19 != 0) {
    pbStack_214f4 = pbStack_214f4 + -iVar19;
    while (uVar15 == 9 || uVar15 == 0x20) {
      pbStack_214f4 = pbStack_214f4 + 1;
      uVar14 = uVar14 - 1;
      uVar15 = (uint)*pbStack_214f4;
    }
    uVar20 = 0;
    while ((uVar15 != 0 && (uVar15 != 9 && uVar15 != 0x20))) {
      uVar14 = uVar14 - 1;
      if (uVar20 < 0xf) {
        *(char *)((int)&local_98.st_dev + uVar20) = (char)uVar15;
        uVar20 = uVar20 + 1;
      }
      pbStack_214f4 = pbStack_214f4 + 1;
      uVar15 = (uint)*pbStack_214f4;
    }
    if (uVar20 - 1 < 0xf) {
      *(undefined1 *)((int)&local_98.st_dev + uVar20) = 0;
      for (; uVar15 = (uint)*pbStack_214f4, uVar15 == 9 || uVar15 == 0x20;
          pbStack_214f4 = pbStack_214f4 + 1) {
        uVar14 = uVar14 - 1;
      }
      uVar20 = 0;
      iVar19 = 0;
      do {
        uVar21 = uVar15 - 0x30;
        if (9 < uVar21) {
          if (uVar15 - 0x61 < 6) {
            uVar21 = uVar15 - 0x57;
          }
          else {
            if (5 < uVar15 - 0x41) goto LAB_0002c4f0;
            uVar21 = uVar15 - 0x37;
          }
        }
        uVar20 = uVar21 | uVar20 << 4;
        uVar14 = uVar14 - 1;
        uVar15 = (uint)pbStack_214f4[iVar19 + 1];
        iVar19 = iVar19 + 1;
      } while( true );
    }
  }
  goto LAB_0002c234;
LAB_0002c4f0:
  if (iVar19 != 0) {
    pbStack_214f4 = pbStack_214f4 + iVar19;
    while (uVar15 == 9 || uVar15 == 0x20) {
      pbStack_214f4 = pbStack_214f4 + 1;
      uVar14 = uVar14 - 1;
      uVar15 = (uint)*pbStack_214f4;
    }
    iVar19 = 0;
    do {
      if (9 < uVar15 - 0x30) {
        uVar21 = uVar15 - 0x61;
        bVar25 = 5 < uVar21;
        bVar24 = uVar21 == 6;
        if (bVar25) {
          uVar21 = uVar15 - 0x41;
          bVar24 = uVar21 == 5;
        }
        if ((bVar25 && 4 < uVar21) && !bVar24) goto code_r0x0002c554;
      }
      uVar15 = (uint)*(byte *)-uVar14;
      uVar14 = uVar14 - 1;
      iVar19 = iVar19 + -1;
    } while( true );
  }
  goto LAB_0002c234;
code_r0x0002c554:
  if (iVar19 != 0) {
    pbVar6 = (byte *)-uVar14;
    if (uVar15 == 0) {
      pbVar6 = pbStack_214f4 + -iVar19;
    }
    if (pbVar6 != (byte *)0x0) {
      pbVar11 = pbVar6 + 2;
      for (; uVar14 = (uint)*pbVar6, uVar14 == 9 || uVar14 == 0x20; pbVar6 = pbVar6 + 1) {
        pbVar11 = pbVar11 + 1;
      }
      iVar19 = 0;
      do {
        if (9 < uVar14 - 0x30) {
          uVar16 = uVar14 - 0x61;
          bVar24 = uVar16 == 6;
          uVar21 = uVar14;
          if (5 < uVar16) {
            uVar21 = uVar14 - 0x41;
            bVar24 = uVar21 == 5;
          }
          if ((5 < uVar16 && 4 < uVar21) && !bVar24) goto code_r0x0002c5d0;
        }
        pbVar11 = pbVar11 + 1;
        uVar14 = (uint)pbVar6[1 - iVar19];
        iVar19 = iVar19 + -1;
      } while( true );
    }
  }
  goto LAB_0002c234;
code_r0x0002c5d0:
  if (iVar19 == 0) goto LAB_0002c234;
  pbVar6 = pbVar6 + -iVar19;
  while (uVar14 == 9 || uVar14 == 0x20) {
    pbVar6 = pbVar6 + 1;
    pbVar11 = pbVar11 + 1;
    uVar14 = (uint)*pbVar6;
  }
  if (9 < uVar14 - 0x30) goto LAB_0002c234;
  iVar19 = 0;
  do {
    iVar4 = iVar19;
    iVar19 = iVar4 + -1;
    uVar14 = (uint)pbVar6[1 - iVar4];
  } while (uVar14 - 0x30 < 10);
  if (iVar19 == 0) goto LAB_0002c234;
  pbVar6 = pbVar6 + -iVar19;
  iVar4 = (int)pbVar11 - iVar4;
  while (pbVar11 = pbVar6, uVar14 == 9 || uVar14 == 0x20) {
    pbVar6 = pbVar6 + 1;
    iVar4 = iVar4 + 1;
    uVar14 = (uint)*pbVar6;
  }
  while (uVar14 == 9 || uVar14 == 0x20) {
    iVar4 = iVar4 + 1;
    uVar14 = (uint)pbVar11[1];
    pbVar11 = pbVar11 + 1;
  }
  iVar19 = 0;
  while ((uVar14 != 0 && (uVar14 != 9 && uVar14 != 0x20))) {
    pbVar11 = (byte *)(iVar4 + iVar19);
    iVar19 = iVar19 + 1;
    uVar14 = (uint)*pbVar11;
  }
  if (uVar22 != 0x2d || uVar15 != 0x3a) goto LAB_0002c234;
  uVar22 = (uint)(((uint)local_98.st_dev & 0xff) == 0x72);
  if (local_98.st_dev._1_1_ == 'w') {
    uVar22 = uVar22 | 2;
  }
  if (local_98.st_dev._2_1_ == 'x') {
    uVar22 = uVar22 | 4;
  }
  puVar8 = (uint *)FUN_0002747c();
  if (puVar8 == (uint *)0xffffffff) goto LAB_0002ca5c;
  puVar8[0xb] = (uint)puVar18;
  *puVar8 = uVar17;
  puVar8[1] = uVar23;
  puVar8[2] = uVar20;
  puVar8[3] = 0;
  puVar8[4] = uVar22;
  pcVar9 = strdup((char *)pbVar6);
  puVar8[5] = (uint)pcVar9;
  pthread_mutex_init((pthread_mutex_t *)(puVar8 + 6),(pthread_mutexattr_t *)0x0);
  pcVar9 = (char *)puVar8[5];
  *(undefined1 *)((int)puVar8 + 0x1e) = 0;
  *(undefined2 *)(puVar8 + 7) = 0;
  iVar19 = strncmp("/dev/",pcVar9,5);
  if ((iVar19 == 0) && (iVar19 = strncmp("ashmem/",pcVar9 + 5,7), iVar19 != 0)) {
    puVar8[4] = puVar8[4] | 0x8000;
  }
  puVar18 = puVar8;
  if ((((*pcVar9 == '\0') || (iVar19 = strncmp("[stack:",pcVar9,7), (uVar22 & 5) != 5)) ||
      (iVar19 == 0)) || ((*(byte *)((int)puVar8 + 0x11) & 0x80) != 0)) goto LAB_0002c234;
  if ((param_1 != 0) || (iVar19 = open(pcVar9,0), iVar19 < 0)) goto LAB_0002c864;
  iVar4 = fstat(iVar19,&local_98);
  if (iVar4 == -1) {
    close(iVar19);
    goto LAB_0002c864;
  }
  uStack_214e8 = local_98.st_blksize;
  puStack_214ec = (uint *)mmap((void *)0x0,local_98.st_blksize,1,2,iVar19,0);
  close(iVar19);
  if (puStack_214ec == (uint *)0xffffffff) goto LAB_0002c864;
  if (uStack_214e8 < 7) {
LAB_0002c84c:
    bStack_214f0 = false;
  }
  else {
    uVar22 = *puStack_214ec;
    bVar24 = uVar22 == 0x464c457f;
    if (bVar24) {
      uVar22 = (uint)(byte)puStack_214ec[1];
    }
    if (!bVar24 || uVar22 != 1) goto LAB_0002c84c;
    bStack_214f0 = *(char *)((int)puStack_214ec + 6) == '\x01';
    if (*(char *)((int)puStack_214ec + 6) == '\x01') {
      uStack_214ef = 0x101;
      iVar19 = FUN_00026d30(&bStack_214f0,uVar20,&local_98);
      if (iVar19 != 0) {
        puVar8[3] = (uint)local_98.st_dev;
      }
      munmap(puStack_214ec,uStack_214e8);
      goto LAB_0002c234;
    }
  }
  munmap(puStack_214ec,uStack_214e8);
LAB_0002c864:
  puVar10 = puStack_21510;
  if (puStack_21510 == (uint *)0x0) {
    if (param_1 == 1) {
      puVar10 = &uStack_214e0;
      _Uarm_local_access_addr_space_init(puVar10);
    }
    else {
      puStack_21510 = (uint *)0x0;
      puVar10 = (uint *)_Uarm_create_addr_space(_UPT_accessors,0);
      if (puVar10 == (uint *)0x0) goto LAB_0002c234;
      uStack_21514 = _UPT_create(param_2);
      if (uStack_21514 == 0) {
        _Uarm_destroy_addr_space(puVar10);
        puStack_21510 = (uint *)0x0;
        uStack_21514 = 0;
        goto LAB_0002c234;
      }
    }
  }
  uStack_214ef = uStack_214ef & 0xff;
  uStack_214e8 = uStack_21514;
  puStack_214ec = puVar10;
  puStack_214e4 = puVar8;
  iVar19 = _Uelf32_memory_read(&bStack_214f0,*puVar8,&local_98,4,0);
  puStack_21510 = puVar10;
  if ((iVar19 == 4) && ((uint)local_98.st_dev == 0x464c457f)) {
    uVar22 = _Uelf32_memory_read(&bStack_214f0,*puVar8 + 4,(undefined1 *)((int)&local_98.st_dev + 4)
                                 ,0xc,0);
    bVar24 = uVar22 == 0xc;
    if (bVar24) {
      uVar22 = (uint)local_98.st_dev._4_1_;
    }
    if (bVar24 && uVar22 == 1) {
      bStack_214f0 = local_98.st_dev._6_1_ == '\x01';
      if ((local_98.st_dev._6_1_ == '\x01') &&
         (iVar19 = FUN_00026d30(&bStack_214f0,puVar8[2],&local_98), iVar19 != 0)) {
        puVar8[3] = (uint)local_98.st_dev;
      }
      goto LAB_0002c234;
    }
  }
  bStack_214f0 = false;
  goto LAB_0002c234;
LAB_0002ca5c:
  close(iVar13);
LAB_0002ca04:
  munmap(__addr,__len);
LAB_0002ca10:
  if ((param_1 == 0) && (puStack_21510 != (uint *)0x0)) {
    _Uarm_destroy_addr_space();
    _UPT_destroy(uStack_21514);
  }
  goto LAB_0002ca40;
}



void FUN_0002ca8c(void)

{
  pthread_once((pthread_once_t *)&DAT_0006328c,(__init_routine *)&LAB_0002caa8);
  return;
}



uint map_local_is_readable(undefined4 param_1)

{
  int iVar1;
  uint uVar2;
  
  pthread_rwlock_rdlock((pthread_rwlock_t *)&DAT_000636b0);
  iVar1 = FUN_00027548(DAT_00063290,param_1);
  if (iVar1 == 0) {
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
  }
  else {
    uVar2 = *(uint *)(iVar1 + 0x10);
    if ((uVar2 & 0x8000) != 0) {
      pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
      return 0;
    }
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
    uVar2 = uVar2 & 1;
    if (uVar2 != 0) {
      return uVar2;
    }
  }
  iVar1 = FUN_0002ceac(param_1,1);
  return (uint)(iVar1 == 0);
}



uint map_local_is_writable(undefined4 param_1)

{
  int iVar1;
  uint uVar2;
  
  pthread_rwlock_rdlock((pthread_rwlock_t *)&DAT_000636b0);
  iVar1 = FUN_00027548(DAT_00063290,param_1);
  if (iVar1 == 0) {
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
  }
  else {
    uVar2 = *(uint *)(iVar1 + 0x10);
    if ((uVar2 & 0x8000) != 0) {
      pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
      return 0;
    }
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
    uVar2 = uVar2 & 2;
    if (uVar2 != 0) {
      return uVar2;
    }
  }
  iVar1 = FUN_0002ceac(param_1,2);
  return (uint)(iVar1 == 0);
}



void local_get_elf_image(int param_1,int *param_2,undefined4 param_3,int *param_4,int *param_5,
                        undefined4 *param_6,int param_7)

{
  char cVar1;
  int *piVar2;
  int iVar3;
  int iVar4;
  void *pvVar5;
  uint *__addr;
  char *pcVar6;
  uint uVar7;
  int iVar8;
  int *piVar9;
  bool bVar10;
  bool bVar11;
  stat local_90;
  int local_28;
  
  local_28 = __stack_chk_guard;
  pthread_rwlock_rdlock((pthread_rwlock_t *)&DAT_000636b0);
  piVar2 = (int *)FUN_00027548(DAT_00063290,param_3);
  if (piVar2 == (int *)0x0) {
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
    iVar3 = FUN_0002ceac(param_3,0);
    if (iVar3 < 0) goto LAB_0002ce4c;
    pthread_rwlock_rdlock((pthread_rwlock_t *)&DAT_000636b0);
    piVar2 = (int *)FUN_00027548(DAT_00063290,param_3);
    if (piVar2 != (int *)0x0) goto LAB_0002cbc8;
  }
  else {
LAB_0002cbc8:
    pthread_mutex_lock((pthread_mutex_t *)(piVar2 + 6));
    piVar9 = piVar2 + 7;
    if (*(char *)((int)piVar2 + 0x1d) != '\0') goto LAB_0002cdb8;
    *(undefined1 *)((int)piVar2 + 0x1d) = 1;
    iVar3 = open((char *)piVar2[5],0);
    if (iVar3 < 0) {
LAB_0002ccec:
      if ((*(byte *)(piVar2 + 4) & 1) == 0) {
        if ((char)*piVar9 != '\0') goto LAB_0002cd9c;
      }
      else {
        bVar10 = false;
        piVar2[8] = param_1;
        piVar2[9] = param_7;
        piVar2[10] = (int)piVar2;
        iVar3 = _Uelf32_memory_read(piVar9,*piVar2,&local_90,4,0);
        if ((iVar3 == 4) && ((int)local_90.st_dev == 0x464c457f)) {
          bVar10 = false;
          uVar7 = _Uelf32_memory_read(piVar9,*piVar2 + 4,(undefined1 *)((int)&local_90.st_dev + 4),
                                      0xc,0);
          bVar11 = uVar7 == 0xc;
          if (bVar11) {
            uVar7 = (uint)local_90.st_dev._4_1_;
          }
          if (bVar11 && uVar7 == 1) {
            bVar10 = local_90.st_dev._6_1_ == '\x01';
          }
        }
        *(bool *)piVar9 = bVar10;
        if (bVar10) goto LAB_0002cd9c;
      }
    }
    else {
      iVar4 = fstat(iVar3,&local_90);
      if (iVar4 == -1) {
        close(iVar3);
        goto LAB_0002ccec;
      }
      piVar2[9] = local_90.st_blksize;
      pvVar5 = mmap((void *)0x0,local_90.st_blksize,1,2,iVar3,0);
      piVar2[8] = (int)pvVar5;
      close(iVar3);
      __addr = (uint *)piVar2[8];
      if (__addr == (uint *)0xffffffff) goto LAB_0002ccec;
      if ((uint)piVar2[9] < 7) {
LAB_0002cc84:
        *(char *)piVar9 = '\0';
LAB_0002cc8c:
        munmap(__addr,piVar2[9]);
        goto LAB_0002ccec;
      }
      uVar7 = *__addr;
      bVar10 = uVar7 == 0x464c457f;
      if (bVar10) {
        uVar7 = (uint)(byte)__addr[1];
      }
      if (!bVar10 || uVar7 != 1) goto LAB_0002cc84;
      cVar1 = *(char *)((int)__addr + 6);
      *(bool *)piVar9 = cVar1 == '\x01';
      if (cVar1 != '\x01') goto LAB_0002cc8c;
      *(undefined2 *)((int)piVar2 + 0x1d) = 0x101;
LAB_0002cd9c:
      iVar3 = FUN_00026d30(piVar9,piVar2[2],&local_90);
      if (iVar3 != 0) {
        piVar2[3] = (int)local_90.st_dev;
      }
    }
LAB_0002cdb8:
    pthread_mutex_unlock((pthread_mutex_t *)(piVar2 + 6));
    if ((char)*piVar9 != '\0') {
      iVar3 = piVar2[8];
      iVar4 = piVar2[9];
      iVar8 = piVar2[10];
      *param_2 = piVar2[7];
      param_2[1] = iVar3;
      param_2[2] = iVar4;
      param_2[3] = iVar8;
      *param_4 = *piVar2;
      iVar3 = 0;
      if (*(char *)((int)param_2 + 2) != '\0') {
        iVar3 = piVar2[2];
      }
      *param_5 = iVar3;
      if (param_6 != (undefined4 *)0x0) {
        if ((char *)piVar2[5] == (char *)0x0) {
          *param_6 = 0;
        }
        else {
          pcVar6 = strdup((char *)piVar2[5]);
          *param_6 = pcVar6;
        }
      }
    }
  }
  pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
LAB_0002ce4c:
  if (__stack_chk_guard - local_28 != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_28);
  }
  return;
}



undefined4 FUN_0002ceac(undefined4 param_1,uint param_2)

{
  uint *puVar1;
  uint *puVar2;
  __pid_t _Var3;
  uint *puVar4;
  int iVar5;
  uint *puVar6;
  uint uVar7;
  uint uVar8;
  undefined4 uVar9;
  uint uVar10;
  uint *puVar11;
  
  _Var3 = getpid();
  puVar4 = (uint *)FUN_0002c0b8(1,_Var3);
  iVar5 = FUN_00027548(puVar4,param_1);
  uVar9 = 0xffffffff;
  if ((iVar5 != 0) && ((param_2 == 0 || ((*(uint *)(iVar5 + 0x10) & param_2) != 0)))) {
    pthread_rwlock_wrlock((pthread_rwlock_t *)&DAT_000636b0);
    iVar5 = FUN_00027548(DAT_00063290,param_1);
    puVar6 = puVar4;
    puVar1 = DAT_00063290;
    if ((iVar5 == 0) ||
       ((puVar11 = puVar4, puVar2 = DAT_00063290, param_2 != 0 &&
        ((*(uint *)(iVar5 + 0x10) & param_2) == 0)))) {
      for (; puVar11 = DAT_00063290, puVar2 = puVar4, puVar1 != (uint *)0x0;
          puVar1 = (uint *)puVar1[0xb]) {
        if ((char)puVar1[7] != '\0') {
          if (puVar6 != (uint *)0x0) {
            do {
              if (*puVar6 < *puVar1) goto LAB_0002cfd8;
              if ((*puVar1 == *puVar6) && (puVar1[1] == puVar6[1])) {
                uVar8 = puVar1[8];
                uVar10 = puVar1[9];
                uVar7 = puVar1[10];
                puVar6[7] = puVar1[7];
                puVar6[10] = uVar7;
                puVar6[9] = uVar10;
                puVar6[8] = uVar8;
                if (*(char *)((int)puVar6 + 0x1e) == '\0') {
                  puVar6[10] = (uint)puVar6;
                }
                *(undefined1 *)((int)puVar1 + 0x1e) = 0;
              }
              puVar6 = (uint *)puVar6[0xb];
            } while (puVar6 != (uint *)0x0);
          }
          puVar6 = (uint *)0x0;
        }
LAB_0002cfd8:
      }
    }
    DAT_00063290 = puVar2;
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
    uVar9 = 0;
    puVar4 = puVar11;
  }
  FUN_000273a8(puVar4);
  return uVar9;
}



char * map_local_get_image_name(undefined4 param_1)

{
  int iVar1;
  char *pcVar2;
  
  pthread_rwlock_rdlock((pthread_rwlock_t *)&DAT_000636b0);
  iVar1 = FUN_00027548(DAT_00063290,param_1);
  if (iVar1 == 0) {
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
    iVar1 = FUN_0002ceac(param_1,0);
    if (iVar1 < 0) {
      return (char *)0x0;
    }
    pthread_rwlock_rdlock((pthread_rwlock_t *)&DAT_000636b0);
    iVar1 = FUN_00027548(DAT_00063290,param_1);
    if (iVar1 == 0) {
      pcVar2 = (char *)0x0;
      goto LAB_0002d054;
    }
  }
  pcVar2 = strdup(*(char **)(iVar1 + 0x14));
LAB_0002d054:
  pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
  return pcVar2;
}



int _UPT_access_fpreg(undefined4 param_1,uint param_2,long *param_3,int param_4,undefined4 *param_5)

{
  int *piVar1;
  long lVar2;
  undefined4 uVar3;
  int iVar4;
  
  if (8 < param_2 >> 5) {
    return -3;
  }
  uVar3 = *param_5;
  iVar4 = *(int *)(_UPT_reg_offset + param_2 * 4);
  piVar1 = (int *)__errno();
  *piVar1 = 0;
  if (param_4 == 0) {
    lVar2 = ptrace(PTRACE_PEEKUSER,uVar3,iVar4,0);
    *param_3 = lVar2;
    if (*piVar1 != 0) {
      return -3;
    }
    lVar2 = ptrace(PTRACE_PEEKUSER,uVar3,iVar4 + 4,0);
    param_3[1] = lVar2;
  }
  else {
    ptrace(PTRACE_POKEUSER,uVar3,iVar4,*param_3);
    if (*piVar1 != 0) {
      return -3;
    }
    ptrace(PTRACE_POKEUSER,uVar3,iVar4 + 4,param_3[1]);
  }
  iVar4 = *piVar1;
  if (iVar4 != 0) {
    iVar4 = -3;
  }
  return iVar4;
}



undefined4
_UPT_access_mem(undefined4 param_1,undefined4 param_2,long *param_3,int param_4,undefined4 *param_5)

{
  int *piVar1;
  long lVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  
  uVar3 = 0xfffffff8;
  if (param_5 != (undefined4 *)0x0) {
    uVar4 = *param_5;
    piVar1 = (int *)__errno();
    *piVar1 = 0;
    if (param_4 == 0) {
      lVar2 = ptrace(PTRACE_PEEKDATA,uVar4,param_2,0);
      *param_3 = lVar2;
      if (*piVar1 == 0) {
        log2Console(3,"Bugly-libunwind","mem[%lx] -> %lx\n",param_2,lVar2);
        uVar3 = 0;
      }
    }
    else {
      log2Console(3,"Bugly-libunwind","mem[%lx] <- %lx\n",param_2,*param_3);
      ptrace(PTRACE_POKEDATA,uVar4,param_2,*param_3);
      if (*piVar1 == 0) {
        uVar3 = 0;
      }
    }
  }
  return uVar3;
}



undefined4
_UPT_access_reg(undefined4 param_1,uint param_2,long *param_3,int param_4,undefined4 *param_5)

{
  int *piVar1;
  long lVar2;
  char *pcVar3;
  undefined4 uVar4;
  
  uVar4 = *param_5;
  piVar1 = (int *)__errno();
  if (param_2 < 0x120) {
    *piVar1 = 0;
    if (param_4 == 0) {
      lVar2 = ptrace(PTRACE_PEEKUSER,uVar4,*(undefined4 *)(_UPT_reg_offset + param_2 * 4),0);
      *param_3 = lVar2;
    }
    else {
      ptrace(PTRACE_POKEUSER,uVar4,*(undefined4 *)(_UPT_reg_offset + param_2 * 4),*param_3);
    }
    if (*piVar1 == 0) {
      return 0;
    }
  }
  else {
    *piVar1 = 0x16;
  }
  uVar4 = _Uarm_regname(param_2);
  pcVar3 = strerror(*piVar1);
  log2Console(3,"Bugly-libunwind","bad register %s [%u] (error: %s)\n",uVar4,param_2,pcVar3);
  return 0xfffffffd;
}



undefined4 * _UPT_create(undefined4 param_1)

{
  undefined4 *puVar1;
  
  puVar1 = (undefined4 *)malloc(0x94);
  if (puVar1 != (undefined4 *)0x0) {
    __aeabi_memclr4(puVar1 + 1,0x90);
    puVar1[6] = 0xffffffff;
    *puVar1 = param_1;
    puVar1[0x12] = 0xffffffff;
  }
  return puVar1;
}



void _UPT_destroy(void *param_1)

{
  free(param_1);
  return;
}



void _UPT_find_proc_info(undefined4 param_1,uint param_2,undefined4 param_3,undefined4 param_4,
                        undefined4 *param_5)

{
  int iVar1;
  int iVar2;
  uint uVar3;
  undefined4 *puVar4;
  undefined4 uVar5;
  void *local_44;
  undefined1 auStack_40 [16];
  undefined4 local_30;
  undefined4 local_2c;
  int local_28;
  
  puVar4 = param_5 + 1;
  local_28 = __stack_chk_guard;
  uVar5 = *param_5;
  local_44 = (void *)0x0;
  if ((((param_5[6] == -1) || (param_2 < (uint)param_5[3])) ||
      (iVar2 = 0, (uint)param_5[4] <= param_2)) &&
     ((param_5[0x12] == -1 ||
      (((param_2 < (uint)param_5[0x1b] || (iVar2 = 0, (uint)param_5[0x1c] <= param_2)) &&
       ((param_2 < (uint)param_5[0xf] || (iVar2 = 0, (uint)param_5[0x10] <= param_2)))))))) {
    __aeabi_memclr4(puVar4,0x90);
    param_5[0x12] = 0xffffffff;
    param_5[6] = 0xffffffff;
    param_5[0x1e] = 0xffffffff;
    iVar1 = _Uarm_get_elf_image(param_1,auStack_40,uVar5,param_2,&local_2c,&local_30,&local_44,
                                param_5);
    iVar2 = -10;
    if (-1 < iVar1) {
      iVar2 = _Uarm_dwarf_find_unwind_table
                        (puVar4,auStack_40,param_1,local_44,local_2c,local_30,param_2);
      free(local_44);
      if (-1 < iVar2) {
        iVar2 = -1;
        if ((param_5[6] != -1) &&
           ((param_2 < (uint)param_5[3] || (iVar2 = param_5[6], (uint)param_5[4] <= param_2)))) {
          iVar2 = -1;
          param_5[6] = 0xffffffff;
        }
        uVar3 = 0xffffffff;
        if ((param_5[0x12] != 0xffffffff) &&
           ((param_2 < (uint)param_5[0xf] || (uVar3 = param_5[0x12], (uint)param_5[0x10] <= param_2)
            ))) {
          uVar3 = 0xffffffff;
          param_5[0x12] = 0xffffffff;
        }
        if (iVar2 == -1) {
          iVar2 = -10;
          if ((param_5[0x1e] & uVar3) != 0xffffffff) {
            iVar2 = 0;
          }
        }
        else {
          iVar2 = 0;
        }
      }
    }
  }
  iVar1 = -10;
  if ((((-1 < iVar2) &&
       ((param_5[6] == -1 ||
        (iVar1 = _Uarm_search_unwind_table(param_1,param_2,puVar4,param_3,param_4,param_5),
        iVar1 == -10)))) &&
      ((param_5[0x1e] == -1 ||
       (iVar1 = _Uarm_search_unwind_table(param_1,param_2,param_5 + 0x19,param_3,param_4,param_5),
       iVar1 == -10)))) && (iVar1 = -10, param_5[0x12] != -1)) {
    iVar1 = _Uarm_search_unwind_table(param_1,param_2,param_5 + 0xd,param_3,param_4,param_5);
  }
  if (__stack_chk_guard == local_28) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iVar1);
}



undefined4 _UPT_get_dyn_info_list_addr(void)

{
  log2Console(3,"Bugly-libunwind","looking for dyn_info list\n");
  return 0xfffffff6;
}



void _UPT_put_unwind_info(undefined4 param_1,int param_2)

{
  if (*(void **)(param_2 + 0x20) == (void *)0x0) {
    return;
  }
  free(*(void **)(param_2 + 0x20));
  *(undefined4 *)(param_2 + 0x20) = 0;
  return;
}



void _UPT_get_proc_name(undefined4 param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
                       undefined4 param_5,undefined4 *param_6)

{
  FUN_00026c8c(param_1,*param_6,param_2,param_3,param_4,param_5,param_6);
  return;
}



void _UPT_resume(undefined4 param_1,undefined4 param_2,undefined4 *param_3)

{
  ptrace(PTRACE_CONT,*param_3,0,0);
  return;
}



bool _Uarm_is_fpreg(uint param_1)

{
  return (param_1 & 0xffffffe0) == 0x100 ||
         ((param_1 & 0xfffffff8) == 0xc0 ||
         ((param_1 & 0xfffffff0) == 0x70 ||
         ((param_1 & 0xffffffe0) == 0x40 || (param_1 & 0xfffffff8 | 8) == 0x68)));
}



undefined * _Uarm_regname(int param_1)

{
  if (param_1 < 0x118) {
    return (&PTR_DAT_0003c4bc)[param_1];
  }
  return &UNK_0003a2b9;
}



undefined4 * _Uarm_create_addr_space(undefined4 *param_1,undefined4 *param_2)

{
  undefined4 *puVar1;
  undefined4 *puVar2;
  undefined4 uVar3;
  undefined4 uVar4;
  undefined4 uVar5;
  
  puVar1 = param_1;
  if (param_2 != (undefined4 *)0x0) {
    puVar1 = (undefined4 *)0x10e1;
  }
  if (((param_2 == (undefined4 *)0x0 || param_2 == puVar1) || (param_2 == (undefined4 *)0x4d2)) &&
     (puVar1 = (undefined4 *)malloc(0x21448), puVar1 != (undefined4 *)0x0)) {
    __aeabi_memclr4(puVar1 + 8,&UINT_00021428);
    uVar3 = param_1[1];
    uVar4 = param_1[2];
    uVar5 = param_1[3];
    *puVar1 = *param_1;
    puVar1[1] = uVar3;
    puVar1[2] = uVar4;
    puVar1[3] = uVar5;
    puVar2 = (undefined4 *)param_1[4];
    uVar3 = param_1[5];
    uVar4 = param_1[6];
    uVar5 = param_1[7];
    puVar1[4] = puVar2;
    puVar1[5] = uVar3;
    puVar1[6] = uVar4;
    puVar1[7] = uVar5;
    if (param_2 != (undefined4 *)0x0) {
      puVar2 = (undefined4 *)0x4d2;
    }
    puVar1[8] = (uint)(param_2 != (undefined4 *)0x0 && param_2 != puVar2);
    return puVar1;
  }
  return (undefined4 *)0x0;
}



void unw_map_local_cursor_get(undefined4 *param_1)

{
  FUN_0002ca8c();
  pthread_rwlock_wrlock((pthread_rwlock_t *)&DAT_000636b0);
  *param_1 = DAT_00063290;
  param_1[1] = DAT_00063290;
  pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
  return;
}



int unw_map_local_cursor_valid(int *param_1)

{
  int iVar1;
  
  iVar1 = *param_1 - DAT_00063290;
  if (iVar1 != 0) {
    iVar1 = -1;
  }
  return iVar1;
}



undefined4 unw_map_local_create(void)

{
  __pid_t _Var1;
  int iVar2;
  undefined4 uVar3;
  
  FUN_0002ca8c();
  pthread_rwlock_wrlock((pthread_rwlock_t *)&DAT_000636b0);
  if (DAT_00063294 == 0) {
    _Var1 = getpid();
    iVar2 = 1;
    DAT_00063290 = FUN_0002c0b8(1,_Var1);
    if (DAT_00063290 == 0) {
      uVar3 = 0xffffffff;
      goto LAB_0002d8dc;
    }
  }
  else {
    iVar2 = DAT_00063294 + 1;
  }
  uVar3 = 0;
  DAT_00063294 = iVar2;
LAB_0002d8dc:
  pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
  return uVar3;
}



void unw_map_local_destroy(void)

{
  FUN_0002ca8c();
  pthread_rwlock_wrlock((pthread_rwlock_t *)&DAT_000636b0);
  if (DAT_00063290 != 0) {
    DAT_00063294 = DAT_00063294 + -1;
    if (DAT_00063294 == 0) {
      FUN_000273a8();
      DAT_00063290 = 0;
    }
  }
  pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
  return;
}



undefined4 unw_map_local_cursor_get_next(int *param_1,undefined4 *param_2)

{
  char *pcVar1;
  undefined4 uVar2;
  undefined4 *puVar3;
  
  puVar3 = (undefined4 *)param_1[1];
  if (puVar3 != (undefined4 *)0x0) {
    FUN_0002ca8c();
    pthread_rwlock_rdlock((pthread_rwlock_t *)&DAT_000636b0);
    if (*param_1 == DAT_00063290) {
      *param_2 = *puVar3;
      param_2[1] = puVar3[1];
      param_2[2] = puVar3[2];
      param_2[3] = puVar3[3];
      param_2[5] = puVar3[4];
      if ((char *)puVar3[5] == (char *)0x0) {
        pcVar1 = (char *)0x0;
      }
      else {
        pcVar1 = strdup((char *)puVar3[5]);
      }
      param_2[4] = pcVar1;
      param_1[1] = puVar3[0xb];
      uVar2 = 1;
    }
    else {
      *param_1 = DAT_00063290;
      uVar2 = 0xfffffff8;
    }
    pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_000636b0);
    return uVar2;
  }
  return 0;
}



int FUN_0002da54(int param_1,uint param_2,undefined4 param_3,int param_4,undefined4 param_5)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  void *__ptr;
  int *piVar5;
  uint uVar6;
  size_t __nmemb;
  int iVar7;
  void *local_54;
  uint local_48;
  uint local_44;
  int local_40;
  int local_3c;
  int local_38;
  int local_34;
  undefined1 auStack_30 [4];
  uint local_2c;
  int local_28;
  undefined4 uStack_24;
  
  if (_Uarm_local_addr_space == param_1) {
    iVar7 = _U_dyn_info_list_addr();
    piVar5 = *(int **)(iVar7 + 8);
    while( true ) {
      if (piVar5 == (int *)0x0) {
        return -10;
      }
      if (((uint)piVar5[2] <= param_2) && (param_2 < (uint)piVar5[3])) break;
      piVar5 = (int *)*piVar5;
    }
    uStack_24 = param_5;
    local_28 = param_4;
    iVar7 = FUN_00030a04(param_1,param_2,param_3);
    return iVar7;
  }
  local_28 = __stack_chk_guard;
  iVar2 = _Uarm_get_accessors(param_1);
  iVar7 = *(int *)(param_1 + 0x30);
  if (*(int *)(param_1 + 0x30) == 0) {
    iVar7 = (**(code **)(iVar2 + 8))(param_1,&local_34,param_5);
    if (iVar7 < 0) {
      iVar7 = -10;
      goto LAB_00031084;
    }
    iVar7 = local_34;
    if (*(int *)(param_1 + 0x24) != 0) {
      *(int *)(param_1 + 0x30) = local_34;
    }
  }
  local_34 = iVar7;
  local_54 = (void *)0x0;
  do {
    iVar4 = local_34;
    iVar3 = (**(code **)(iVar2 + 0xc))(param_1,local_34,&local_3c,0,param_5);
    iVar7 = -10;
    if ((iVar3 < 0) ||
       (iVar4 = (**(code **)(iVar2 + 0xc))(param_1,iVar4 + 4,&local_38,0,param_5), iVar4 < 0))
    goto LAB_00031084;
    do {
      iVar4 = local_38;
      iVar7 = -10;
      if ((local_38 == 0) ||
         (((iVar3 = (**(code **)(iVar2 + 0xc))(param_1,local_38,&local_38,0,param_5), iVar3 < 0 ||
           (iVar3 = (**(code **)(iVar2 + 0xc))(param_1,iVar4 + 8,&local_44,0,param_5), iVar3 < 0))
          || (iVar3 = (**(code **)(iVar2 + 0xc))(param_1,iVar4 + 0xc,&local_48,0,param_5),
             uVar1 = local_44, uVar6 = local_48, iVar3 < 0)))) goto LAB_00030dc0;
    } while ((param_2 < local_44) || (local_48 <= param_2));
    if (local_54 == (void *)0x0) {
      local_54 = calloc(1,0x30);
    }
    *(uint *)((int)local_54 + 8) = uVar1;
    *(uint *)((int)local_54 + 0xc) = uVar6;
    iVar7 = (**(code **)(iVar2 + 0xc))(param_1,iVar4 + 0x10,(int)local_54 + 0x10,0,param_5);
    if (iVar7 < 0) {
LAB_00030dbc:
      iVar7 = -10;
    }
    else {
      uVar6 = iVar4 + 0x14U & 0xfffffffc;
      iVar7 = (**(code **)(iVar2 + 0xc))(param_1,uVar6,&local_2c,0,param_5);
      uVar6 = local_2c >> (((iVar4 + 0x14U) - uVar6) * 8 & 0xff);
      *(uint *)((int)local_54 + 0x14) = uVar6;
      if (iVar7 < 0) goto LAB_00030dbc;
      if (param_4 == 0) {
LAB_00030fe0:
        iVar7 = -10;
        iVar4 = FUN_00030a04(param_1,param_2,param_3,local_54,param_4,param_5);
        if (iVar4 == -1 || iVar4 + 1 < 0 != SCARRY4(iVar4,1)) {
          if (*(int *)((int)local_54 + 0x14) == 1) {
            if (*(void **)((int)local_54 + 0x28) != (void *)0x0) {
              free(*(void **)((int)local_54 + 0x28));
              *(undefined4 *)((int)local_54 + 0x28) = 0;
            }
          }
          else if ((*(int *)((int)local_54 + 0x14) == 0) && (*(int *)((int)local_54 + 0x2c) != 0)) {
            FUN_000315c0();
            *(undefined4 *)((int)local_54 + 0x2c) = 0;
          }
        }
        else {
          iVar7 = 0;
        }
      }
      else {
        iVar7 = iVar4 + 0x1c;
        if (uVar6 == 2) {
          iVar7 = (**(code **)(iVar2 + 0xc))(param_1,iVar7,(int)local_54 + 0x1c,0,param_5);
          if (((-1 < iVar7) &&
              (iVar7 = (**(code **)(iVar2 + 0xc))
                                 (param_1,iVar4 + 0x20,(int)local_54 + 0x20,0,param_5), -1 < iVar7))
             && ((iVar7 = (**(code **)(iVar2 + 0xc))
                                    (param_1,iVar4 + 0x24,(int)local_54 + 0x24,0,param_5),
                 -1 < iVar7 &&
                 (iVar7 = (**(code **)(iVar2 + 0xc))
                                    (param_1,iVar4 + 0x28,(int)local_54 + 0x28,0,param_5),
                 iVar7 != -1 && iVar7 + 1 < 0 == SCARRY4(iVar7,1))))) goto LAB_00030fe0;
LAB_00030f78:
          uVar6 = *(uint *)((int)local_54 + 0x14);
        }
        else {
          if (uVar6 == 1) {
            iVar7 = (**(code **)(iVar2 + 0xc))(param_1,iVar7,(int)local_54 + 0x1c,0,param_5);
            if (((-1 < iVar7) &&
                (iVar7 = (**(code **)(iVar2 + 0xc))
                                   (param_1,iVar4 + 0x20,(int)local_54 + 0x20,0,param_5), -1 < iVar7
                )) && (iVar7 = (**(code **)(iVar2 + 0xc))
                                         (param_1,iVar4 + 0x24,(int)local_54 + 0x24,0,param_5),
                      -1 < iVar7)) {
              __nmemb = *(size_t *)((int)local_54 + 0x24);
              __ptr = calloc(__nmemb,4);
              if (__ptr != (void *)0x0) {
                if (__nmemb != 0) {
                  iVar7 = 0;
                  uVar6 = 0;
                  do {
                    iVar3 = (**(code **)(iVar2 + 0xc))
                                      (param_1,iVar4 + 0x28 + iVar7,(int)__ptr + iVar7,0,param_5);
                    if (iVar3 < 0) {
                      free(__ptr);
                      goto LAB_00030fe0;
                    }
                    uVar6 = uVar6 + 1;
                    iVar7 = iVar7 + 4;
                  } while (uVar6 < __nmemb);
                }
                *(void **)((int)local_54 + 0x28) = __ptr;
                goto LAB_00030fe0;
              }
            }
            goto LAB_00030f78;
          }
          if (uVar6 == 0) {
            iVar7 = (**(code **)(iVar2 + 0xc))(param_1,iVar7,(int)local_54 + 0x1c,0,param_5);
            if ((-1 < iVar7) &&
               (iVar7 = (**(code **)(iVar2 + 0xc))
                                  (param_1,iVar4 + 0x20,(int)local_54 + 0x20,0,param_5), -1 < iVar7)
               ) {
              uVar6 = iVar4 + 0x24U & 0xfffffffc;
              iVar7 = (**(code **)(iVar2 + 0xc))(param_1,uVar6,&local_2c,0,param_5);
              *(uint *)((int)local_54 + 0x24) = local_2c >> (((iVar4 + 0x24U) - uVar6) * 8 & 0xff);
              if ((-1 < iVar7) &&
                 ((iVar7 = (**(code **)(iVar2 + 0xc))(param_1,iVar4 + 0x2c,auStack_30,0,param_5),
                  -1 < iVar7 &&
                  (iVar7 = FUN_000311d8(param_1,iVar2,auStack_30,(int)local_54 + 0x2c,param_5),
                  -1 < iVar7)))) goto LAB_00030fe0;
            }
            goto LAB_00030f78;
          }
        }
        iVar7 = -10;
        if (uVar6 == 1) {
          if (*(void **)((int)local_54 + 0x28) != (void *)0x0) {
            free(*(void **)((int)local_54 + 0x28));
            *(undefined4 *)((int)local_54 + 0x28) = 0;
          }
        }
        else if ((uVar6 == 0) && (*(int *)((int)local_54 + 0x2c) != 0)) {
          FUN_000315c0();
          *(undefined4 *)((int)local_54 + 0x2c) = 0;
        }
      }
    }
LAB_00030dc0:
    iVar4 = (**(code **)(iVar2 + 0xc))(param_1,local_34,&local_40,0,param_5);
    if (iVar4 < 0) goto LAB_00031084;
  } while (local_3c != local_40);
  if ((local_54 != (void *)0x0) && (iVar7 == -1 || iVar7 + 1 < 0 != SCARRY4(iVar7,1))) {
    free(local_54);
  }
LAB_00031084:
  if (__stack_chk_guard - local_28 == 0) {
    return iVar7;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void FUN_0002db1c(int param_1,int param_2)

{
  int iVar1;
  
  if (*(int *)(param_2 + 0x18) - 1U < 2) {
                    // WARNING: Could not recover jumptable at 0x0002db30. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 4))();
    return;
  }
  if (*(int *)(param_2 + 0x18) == 0) {
    if (_Uarm_local_addr_space == param_1) {
      return;
    }
    iVar1 = *(int *)(param_2 + 0x20);
    if (iVar1 != 0) {
      if (*(int *)(iVar1 + 0x14) == 1) {
        if (*(void **)(iVar1 + 0x28) != (void *)0x0) {
          free(*(void **)(iVar1 + 0x28));
          *(undefined4 *)(iVar1 + 0x28) = 0;
        }
      }
      else if ((*(int *)(iVar1 + 0x14) == 0) && (*(int *)(iVar1 + 0x2c) != 0)) {
        FUN_000315c0();
        *(undefined4 *)(iVar1 + 0x2c) = 0;
      }
      free(*(void **)(param_2 + 0x20));
      *(undefined4 *)(param_2 + 0x20) = 0;
    }
    return;
  }
  return;
}



void _Uarm_destroy_addr_space(void *param_1)

{
  if (*(int *)((int)param_1 + 0x21444) != 0) {
    FUN_000273a8();
  }
  free(param_1);
  return;
}



// WARNING: Type propagation algorithm not settling

void FUN_0002db8c(int *param_1,uint *param_2,int param_3,int *param_4,undefined4 *param_5)

{
  byte bVar1;
  undefined4 ******ppppppuVar2;
  undefined4 *******pppppppuVar3;
  undefined4 *******pppppppuVar4;
  int iVar5;
  int iVar6;
  undefined4 *******pppppppuVar7;
  uint uVar8;
  int iVar9;
  undefined4 ******extraout_r1;
  undefined4 ******extraout_r1_00;
  undefined4 ******extraout_r1_01;
  undefined4 ******extraout_r1_02;
  undefined4 ******extraout_r1_03;
  undefined4 ******extraout_r1_04;
  undefined4 ******extraout_r1_05;
  undefined4 ******extraout_r1_06;
  undefined4 ******extraout_r1_07;
  undefined4 ******extraout_r1_08;
  undefined4 ******extraout_r1_09;
  undefined4 ******extraout_r1_10;
  undefined4 ******extraout_r1_11;
  undefined4 ******extraout_r1_12;
  undefined4 ******extraout_r1_13;
  undefined4 ******extraout_r1_14;
  undefined4 ******extraout_r1_15;
  undefined4 ******extraout_r1_16;
  undefined4 ******extraout_r1_17;
  undefined4 ******extraout_r1_18;
  undefined4 ******ppppppuVar10;
  uint uVar11;
  char *pcVar12;
  undefined4 ******ppppppuVar13;
  undefined4 *****pppppuVar14;
  uint uVar15;
  uint uVar16;
  uint uVar17;
  uint uVar18;
  undefined4 *******pppppppuVar19;
  undefined4 *****pppppuVar20;
  uint local_168;
  uint local_164;
  uint local_160;
  uint local_15c;
  uint local_158;
  undefined4 ******local_13c;
  undefined4 *******local_138;
  undefined4 *******local_134;
  uint local_130;
  undefined4 ******local_12c [64];
  int local_2c;
  
  local_2c = __stack_chk_guard;
  local_134 = (undefined4 *******)0x0;
  local_138 = (undefined4 *******)0x0;
  pppppppuVar4 = (undefined4 *******)*param_1;
  iVar5 = param_1[1];
  iVar6 = _Uarm_get_accessors();
  uVar16 = *param_2;
  *param_5 = 0;
  pppppppuVar7 = (undefined4 *******)param_1[2];
  log2Console(3,"Bugly-libunwind","len=%lu, pushing cfa=0x%lx\n",param_3,pppppppuVar7);
  local_12c[0] = (undefined4 ******)param_1[2];
  uVar17 = *param_2;
  uVar8 = 0;
  if (uVar17 < uVar16 + param_3) {
    uVar8 = 1;
    do {
      *param_2 = uVar17 + 1;
      ppppppuVar13 = (undefined4 ******)0x0;
      pppppppuVar7 = pppppppuVar4;
      iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar17 & 0xfffffffc,&local_130,0,pppppppuVar4);
      if (iVar9 < 0) goto LAB_0002f44c;
      uVar17 = local_130 >> ((uVar17 - (uVar17 & 0xfffffffc)) * 8 & 0xff);
      pppppppuVar19 = (undefined4 *******)(uVar17 & 0xff);
      bVar1 = *(byte *)(pppppppuVar19 + 0xec47);
      uVar18 = (uint)bVar1;
      if ((bVar1 & 0xc0) != 0) {
        pppppppuVar7 = &local_134;
        ppppppuVar13 = (undefined4 ******)((uVar18 << 0x1a) >> 0x1d);
        iVar9 = FUN_0002f5fc(iVar5,iVar6,param_2,ppppppuVar13,pppppppuVar7,pppppppuVar4);
        if (iVar9 < 0) goto LAB_0002f44c;
        iVar9 = (int)(char)bVar1;
        if (iVar9 == -1 || iVar9 + 1 < 0 != SCARRY4(iVar9,1)) {
          pppppppuVar7 = &local_138;
          ppppppuVar13 = (undefined4 ******)(uVar18 & 7);
          iVar9 = FUN_0002f5fc(iVar5,iVar6,param_2,ppppppuVar13,pppppppuVar7,pppppppuVar4);
          if (iVar9 < 0) goto LAB_0002f44c;
        }
      }
      pppppppuVar3 = local_138;
      switch(uVar17 & 0xff) {
      case 3:
      case 8:
      case 10:
      case 0xc:
      case 0xe:
      case 0xf:
      case 0x10:
      case 0x11:
        pcVar12 = "OP_const(0x%lx)\n";
        goto LAB_0002dfc0;
      default:
        pcVar12 = "Unexpected opcode 0x%x\n";
LAB_0002f510:
        log2Console(3,"Bugly-libunwind",pcVar12,pppppppuVar19);
        goto LAB_0002f44c;
      case 6:
        log2Console(3,"Bugly-libunwind","OP_deref\n");
        uVar17 = uVar8 - 1;
        if (0x3f < uVar17) goto LAB_0002f360;
        pppppuVar14 = local_12c[uVar17];
        local_13c = (undefined4 ******)((int)pppppuVar14 + 1);
        iVar9 = (**(code **)(iVar6 + 0xc))
                          (iVar5,(uint)pppppuVar14 & 0xfffffffc,&local_130,0,pppppppuVar4);
        local_164 = local_130;
        ppppppuVar13 = local_13c;
        if (iVar9 < 0) goto LAB_0002f44c;
        uVar18 = (uint)local_13c & 0xfffffffc;
        local_13c = (undefined4 ******)((int)local_13c + 1);
        iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar18,&local_130,0,pppppppuVar4);
        ppppppuVar10 = local_13c;
        if (iVar9 < 0) goto LAB_0002f44c;
        local_164 = local_164 >> (((int)pppppuVar14 - ((uint)pppppuVar14 & 0xfffffffc)) * 8 & 0xff);
        local_15c = local_130 >> (((int)ppppppuVar13 - uVar18) * 8 & 0xff);
        if (*(int *)(iVar5 + 0x20) == 0) {
          local_164 = local_164 & 0xff;
          local_15c = local_15c << 8;
        }
        else {
          local_15c = local_15c & 0xff;
          local_164 = local_164 << 8;
        }
        uVar11 = (uint)local_13c & 0xfffffffc;
        local_13c = (undefined4 ******)((int)local_13c + 1);
        iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar11,&local_130,0,pppppppuVar4);
        uVar18 = local_130;
        ppppppuVar13 = local_13c;
        if (iVar9 < 0) goto LAB_0002f44c;
        uVar15 = (uint)local_13c & 0xfffffffc;
        pppppppuVar7 = pppppppuVar4;
        local_13c = (undefined4 ******)((int)local_13c + 1);
        iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar15,&local_130,0,pppppppuVar4);
        if (iVar9 < 0) goto LAB_0002f44c;
        uVar18 = uVar18 >> (((int)ppppppuVar10 - uVar11) * 8 & 0xff);
        uVar11 = local_130 >> (((int)ppppppuVar13 - uVar15) * 8 & 0xff);
        if (*(int *)(iVar5 + 0x20) == 0) {
          pppppuVar14 = (undefined4 *****)
                        (((local_15c | local_164) & 0xffff) +
                        (uVar18 & 0xff | uVar11 << 8) * 0x10000);
        }
        else {
          pppppuVar14 = (undefined4 *****)
                        ((local_15c | local_164) << 0x10 | (uVar18 & 0xff) << 8 | uVar11 & 0xff);
        }
        local_12c[uVar17] = (undefined4 ******)pppppuVar14;
        break;
      case 9:
        if (((uint)local_134 & 0x80) != 0) {
          local_134 = (undefined4 *******)((uint)local_134 | 0xffffff00);
        }
        pcVar12 = "OP_const1s(%ld)\n";
        goto LAB_0002e12c;
      case 0xb:
        if (((uint)local_134 & 0x8000) != 0) {
          local_134 = (undefined4 *******)((uint)local_134 & 0xffff | 0xffff0000);
        }
        pcVar12 = "OP_const2s(%ld)\n";
LAB_0002e12c:
        log2Console(3,"Bugly-libunwind",pcVar12);
        if (0x3f < uVar8) goto LAB_0002f468;
        local_12c[uVar8] = local_134;
        uVar8 = uVar8 + 1;
        break;
      case 0xd:
        pcVar12 = "OP_const4s(%ld)\n";
LAB_0002dfc0:
        log2Console(3,"Bugly-libunwind",pcVar12,local_134);
        if (0x3f < uVar8) goto LAB_0002f468;
        local_12c[uVar8] = local_134;
        uVar8 = uVar8 + 1;
        break;
      case 0x12:
        log2Console(3,"Bugly-libunwind","OP_dup\n");
        if (0x3f < uVar8) goto LAB_0002f468;
        uVar17 = uVar8 - 1;
joined_r0x0002e238:
        if (uVar17 < 0x40) {
          pppppuVar14 = local_12c[uVar17];
          goto LAB_0002dfa4;
        }
        pcVar12 = "Out-of-stack pick\n";
        goto LAB_0002f370;
      case 0x13:
        log2Console(3,"Bugly-libunwind","OP_drop\n");
        uVar8 = uVar8 - 1;
        if (0x3f < uVar8) goto LAB_0002f360;
        break;
      case 0x14:
        log2Console(3,"Bugly-libunwind","OP_over\n");
        if (uVar8 < 0x40) {
          uVar17 = uVar8 - 2;
          goto joined_r0x0002e238;
        }
        goto LAB_0002f468;
      case 0x15:
        log2Console(3,"Bugly-libunwind","OP_pick(%d)\n",local_134);
        if (uVar8 < 0x40) {
          uVar17 = uVar8 + ~(uint)local_134;
          goto joined_r0x0002e238;
        }
        goto LAB_0002f468;
      case 0x16:
        pcVar12 = "OP_swap\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1;
        if (0x3f >= uVar17) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (0x3f < uVar17 || (undefined4 ******)0x3f < ppppppuVar13) goto LAB_0002f360;
        pppppuVar14 = ppppppuVar10[(int)ppppppuVar13];
        ppppppuVar10[(int)ppppppuVar13] = (undefined4 *****)pcVar12;
        ppppppuVar10[uVar17] = pppppuVar14;
        break;
      case 0x17:
        pcVar12 = "OP_rot\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_00;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if ((uVar17 >= 0x40 || (undefined4 ******)0x3f < ppppppuVar13) ||
           (uVar18 = uVar8 - 3, 0x3f < uVar18)) goto LAB_0002f360;
        pppppuVar14 = ppppppuVar10[uVar18];
        pppppuVar20 = ppppppuVar10[(int)ppppppuVar13];
        ppppppuVar10[uVar18] = (undefined4 *****)pcVar12;
        ppppppuVar10[(int)ppppppuVar13] = pppppuVar14;
        ppppppuVar10[uVar17] = pppppuVar20;
        break;
      case 0x19:
        log2Console(3,"Bugly-libunwind","OP_abs\n");
        uVar17 = uVar8 - 1;
        if (0x3f < uVar17) goto LAB_0002f360;
        local_13c = local_12c[uVar17];
        if ((int)local_13c < 0) {
          local_13c = (undefined4 ******)-(int)local_13c;
        }
        local_12c[uVar17] = local_13c;
        break;
      case 0x1a:
        pcVar12 = "OP_and\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_01;
        if (0x3f >= uVar17) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (0x3f < uVar17 || (undefined4 ******)0x3f < ppppppuVar13) goto LAB_0002f360;
        pppppuVar14 = (undefined4 *****)((uint)ppppppuVar10[(int)ppppppuVar13] & (uint)pcVar12);
LAB_0002e720:
        ppppppuVar10[(int)ppppppuVar13] = pppppuVar14;
        uVar8 = uVar8 - 1;
        break;
      case 0x1b:
        log2Console(3,"Bugly-libunwind","OP_div\n");
        uVar17 = uVar8 - 1;
        ppppppuVar13 = extraout_r1_02;
        if (0x3f >= uVar17) {
          pppppppuVar19 = local_12c;
          uVar18 = uVar8 - 2;
          ppppppuVar13 = pppppppuVar19[uVar17];
          local_13c = ppppppuVar13;
        }
        if (0x3f < uVar17 || 0x3f < uVar18) goto LAB_0002f360;
        if (ppppppuVar13 == (undefined4 ******)0x0) {
          ppppppuVar13 = (undefined4 ******)0x0;
        }
        else {
          ppppppuVar13 = (undefined4 ******)__aeabi_idiv(pppppppuVar19[uVar18]);
          local_13c = ppppppuVar13;
        }
        pppppppuVar19[uVar18] = ppppppuVar13;
LAB_0002ed14:
        uVar8 = uVar8 - 1;
        break;
      case 0x1c:
        pcVar12 = "OP_minus\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_03;
        if (0x3f >= uVar17) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (0x3f < uVar17 || (undefined4 ******)0x3f < ppppppuVar13) goto LAB_0002f360;
        local_13c = (undefined4 ******)((int)ppppppuVar10[(int)ppppppuVar13] - (int)pcVar12);
        ppppppuVar10[(int)ppppppuVar13] = local_13c;
        uVar8 = uVar17;
        break;
      case 0x1d:
        log2Console(3,"Bugly-libunwind","OP_mod\n");
        uVar17 = uVar8 - 1;
        ppppppuVar13 = extraout_r1_04;
        if (uVar17 < 0x40) {
          pppppppuVar19 = local_12c;
          uVar18 = uVar8 - 2;
          ppppppuVar13 = pppppppuVar19[uVar17];
          local_13c = ppppppuVar13;
        }
        if (uVar17 < 0x40 && uVar18 < 0x40) {
          if (ppppppuVar13 == (undefined4 ******)0x0) {
            ppppppuVar13 = (undefined4 ******)0x0;
          }
          else {
            __aeabi_uidivmod(pppppppuVar19[uVar18]);
            ppppppuVar13 = extraout_r1_05;
            local_13c = extraout_r1_05;
          }
          pppppppuVar19[uVar18] = ppppppuVar13;
          goto LAB_0002ed14;
        }
        goto LAB_0002f360;
      case 0x1e:
        pcVar12 = "OP_mul\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_06;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          pcVar12 = (char *)(uVar8 - 2);
          ppppppuVar13 = (undefined4 ******)ppppppuVar10[uVar17];
          local_13c = ppppppuVar13;
        }
        if (uVar17 >= 0x40 || (char *)0x3f < pcVar12) goto LAB_0002f360;
        if (ppppppuVar13 == (undefined4 ******)0x0) {
          ppppppuVar13 = (undefined4 ******)0x0;
        }
        else {
          ppppppuVar13 = (undefined4 ******)((int)ppppppuVar10[(int)pcVar12] * (int)ppppppuVar13);
          local_13c = ppppppuVar13;
        }
        ppppppuVar10[(int)pcVar12] = ppppppuVar13;
        uVar8 = uVar17;
        break;
      case 0x1f:
        log2Console(3,"Bugly-libunwind","OP_neg\n");
        if (0x3f < uVar8) goto LAB_0002f468;
        uVar17 = uVar8 - 1;
        if (0x3f < uVar17) goto LAB_0002f360;
        local_12c[uVar17] = (undefined4 ******)-(int)local_12c[uVar17];
        break;
      case 0x20:
        log2Console(3,"Bugly-libunwind","OP_not\n");
        if (0x3f < uVar8) goto LAB_0002f468;
        uVar17 = uVar8 - 1;
        if (0x3f < uVar17) goto LAB_0002f360;
        local_12c[uVar17] = (undefined4 ******)~(uint)local_12c[uVar17];
        break;
      case 0x21:
        pcVar12 = "OP_or\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_07;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (uVar17 < 0x40 && ppppppuVar13 < (undefined4 ******)0x40) {
          pppppuVar14 = (undefined4 *****)((uint)ppppppuVar10[(int)ppppppuVar13] | (uint)pcVar12);
          goto LAB_0002e720;
        }
        goto LAB_0002f360;
      case 0x22:
        pcVar12 = "OP_plus\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_08;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (uVar17 < 0x40 && ppppppuVar13 < (undefined4 ******)0x40) {
          pppppuVar14 = (undefined4 *****)((int)pcVar12 + (int)ppppppuVar10[(int)ppppppuVar13]);
          goto LAB_0002e720;
        }
        goto LAB_0002f360;
      case 0x23:
        log2Console(3,"Bugly-libunwind","OP_plus_uconst(%lu)\n",local_134);
        uVar17 = uVar8 - 1;
        if (0x3f < uVar17) goto LAB_0002f360;
        local_13c = local_12c[uVar17];
        local_12c[uVar17] = (undefined4 ******)((int)local_134 + (int)local_13c);
        break;
      case 0x24:
        pcVar12 = "OP_shl\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_09;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (uVar17 < 0x40 && ppppppuVar13 < (undefined4 ******)0x40) {
          pppppuVar14 = (undefined4 *****)
                        ((int)ppppppuVar10[(int)ppppppuVar13] << ((uint)pcVar12 & 0xff));
          goto LAB_0002e720;
        }
        goto LAB_0002f360;
      case 0x25:
        pcVar12 = "OP_shr\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_10;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (uVar17 < 0x40 && ppppppuVar13 < (undefined4 ******)0x40) {
          pppppuVar14 = (undefined4 *****)
                        ((uint)ppppppuVar10[(int)ppppppuVar13] >> ((uint)pcVar12 & 0xff));
          goto LAB_0002e720;
        }
        goto LAB_0002f360;
      case 0x26:
        pcVar12 = "OP_shra\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_11;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (uVar17 < 0x40 && ppppppuVar13 < (undefined4 ******)0x40) {
          pppppuVar14 = (undefined4 *****)
                        ((int)ppppppuVar10[(int)ppppppuVar13] >> ((uint)pcVar12 & 0xff));
          goto LAB_0002e720;
        }
        goto LAB_0002f360;
      case 0x27:
        pcVar12 = "OP_xor\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_12;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          ppppppuVar13 = (undefined4 ******)(uVar8 - 2);
          pcVar12 = (char *)ppppppuVar10[uVar17];
          local_13c = (undefined4 ******)pcVar12;
        }
        if (uVar17 < 0x40 && ppppppuVar13 < (undefined4 ******)0x40) {
          pppppuVar14 = (undefined4 *****)((uint)ppppppuVar10[(int)ppppppuVar13] ^ (uint)pcVar12);
          goto LAB_0002e720;
        }
        goto LAB_0002f360;
      case 0x28:
        log2Console(3,"Bugly-libunwind","OP_skip(%d)\n",(int)(short)local_134);
        uVar8 = uVar8 - 1;
        if (0x3f < uVar8) goto LAB_0002f360;
        local_13c = local_12c[uVar8];
        if (local_13c != (undefined4 ******)0x0) {
          *param_2 = (int)(short)local_134 + *param_2;
        }
        break;
      case 0x29:
        pcVar12 = "OP_eq\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_13;
        if (0x3f >= uVar17) {
          ppppppuVar10 = local_12c;
          pcVar12 = (char *)(uVar8 - 2);
          ppppppuVar13 = (undefined4 ******)ppppppuVar10[uVar17];
          local_13c = ppppppuVar13;
        }
        if (0x3f < uVar17 || (char *)0x3f < pcVar12) goto LAB_0002f360;
        pppppuVar14 = (undefined4 *****)
                      (uint)((undefined4 ******)ppppppuVar10[(int)pcVar12] == ppppppuVar13);
LAB_0002e940:
        ppppppuVar10[(int)pcVar12] = pppppuVar14;
        uVar8 = uVar8 - 1;
        break;
      case 0x2a:
        pcVar12 = "OP_ge\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_14;
        if (0x3f >= uVar17) {
          ppppppuVar10 = local_12c;
          pcVar12 = (char *)(uVar8 - 2);
          ppppppuVar13 = (undefined4 ******)ppppppuVar10[uVar17];
          local_13c = ppppppuVar13;
        }
        if (0x3f < uVar17 || (char *)0x3f < pcVar12) goto LAB_0002f360;
        pppppuVar14 = (undefined4 *****)(uint)((int)ppppppuVar13 <= (int)ppppppuVar10[(int)pcVar12])
        ;
LAB_0002e8f0:
        ppppppuVar10[(int)pcVar12] = pppppuVar14;
        uVar8 = uVar8 - 1;
        break;
      case 0x2b:
        pcVar12 = "OP_gt\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_15;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          pcVar12 = (char *)(uVar8 - 2);
          ppppppuVar13 = (undefined4 ******)ppppppuVar10[uVar17];
          local_13c = ppppppuVar13;
        }
        if (uVar17 < 0x40 && pcVar12 < (char *)0x40) {
          pppppuVar14 = (undefined4 *****)
                        (uint)((int)ppppppuVar13 < (int)ppppppuVar10[(int)pcVar12]);
          goto LAB_0002e8f0;
        }
        goto LAB_0002f360;
      case 0x2c:
        pcVar12 = "OP_le\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_16;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          pcVar12 = (char *)(uVar8 - 2);
          ppppppuVar13 = (undefined4 ******)ppppppuVar10[uVar17];
          local_13c = ppppppuVar13;
        }
        if (uVar17 < 0x40 && pcVar12 < (char *)0x40) {
          pppppuVar14 = (undefined4 *****)
                        (uint)((int)ppppppuVar10[(int)pcVar12] <= (int)ppppppuVar13);
          goto LAB_0002e8f0;
        }
        goto LAB_0002f360;
      case 0x2d:
        pcVar12 = "OP_lt\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_17;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          pcVar12 = (char *)(uVar8 - 2);
          ppppppuVar13 = (undefined4 ******)ppppppuVar10[uVar17];
          local_13c = ppppppuVar13;
        }
        if (uVar17 < 0x40 && pcVar12 < (char *)0x40) {
          pppppuVar14 = (undefined4 *****)0x0;
          if ((int)ppppppuVar10[(int)pcVar12] < (int)ppppppuVar13) {
            pppppuVar14 = (undefined4 *****)0x1;
          }
          goto LAB_0002e8f0;
        }
        goto LAB_0002f360;
      case 0x2e:
        pcVar12 = "OP_ne\n";
        log2Console(3,"Bugly-libunwind");
        uVar17 = uVar8 - 1;
        ppppppuVar10 = extraout_r1_18;
        if (uVar17 < 0x40) {
          ppppppuVar10 = local_12c;
          pcVar12 = (char *)(uVar8 - 2);
          ppppppuVar13 = (undefined4 ******)ppppppuVar10[uVar17];
          local_13c = ppppppuVar13;
        }
        if (uVar17 < 0x40 && pcVar12 < (char *)0x40) {
          pppppuVar14 = (undefined4 *****)((int)ppppppuVar10[(int)pcVar12] - (int)ppppppuVar13);
          if (pppppuVar14 != (undefined4 *****)0x0) {
            pppppuVar14 = (undefined4 *****)0x1;
          }
          goto LAB_0002e940;
        }
LAB_0002f360:
        pcVar12 = "Stack underflow\n";
LAB_0002f370:
        log2Console(3,"Bugly-libunwind",pcVar12);
        goto LAB_0002f44c;
      case 0x2f:
        log2Console(3,"Bugly-libunwind","OP_skip(%d)\n",(int)(short)local_134);
        *param_2 = (int)(short)local_134 + *param_2;
        break;
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
      case 0x3a:
      case 0x3b:
      case 0x3c:
      case 0x3d:
      case 0x3e:
      case 0x3f:
      case 0x40:
      case 0x41:
      case 0x42:
      case 0x43:
      case 0x44:
      case 0x45:
      case 0x46:
      case 0x47:
      case 0x48:
      case 0x49:
      case 0x4a:
      case 0x4b:
      case 0x4c:
      case 0x4d:
      case 0x4e:
      case 0x4f:
        log2Console(3,"Bugly-libunwind","OP_lit(%d)\n",pppppppuVar19 + -0xc);
        if (0x3f < uVar8) goto LAB_0002f468;
        local_12c[uVar8] = pppppppuVar19 + -0xc;
        uVar8 = uVar8 + 1;
        break;
      case 0x50:
      case 0x51:
      case 0x52:
      case 0x53:
      case 0x54:
      case 0x55:
      case 0x56:
      case 0x57:
      case 0x58:
      case 0x59:
      case 0x5a:
      case 0x5b:
      case 0x5c:
      case 0x5d:
      case 0x5e:
      case 0x5f:
      case 0x60:
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
      case 0x6b:
      case 0x6c:
      case 0x6d:
      case 0x6e:
      case 0x6f:
        pppppppuVar19 = pppppppuVar19 + -0x14;
        log2Console(3,"Bugly-libunwind","OP_reg(r%d)\n",pppppppuVar19);
        if (0xf < (int)pppppppuVar19) {
          pppppppuVar19 = (undefined4 *******)0x0;
        }
        *param_4 = (int)pppppppuVar19;
        goto LAB_0002f3bc;
      case 0x70:
      case 0x71:
      case 0x72:
      case 0x73:
      case 0x74:
      case 0x75:
      case 0x76:
      case 0x77:
      case 0x78:
      case 0x79:
      case 0x7a:
      case 0x7b:
      case 0x7c:
      case 0x7d:
      case 0x7e:
      case 0x7f:
      case 0x80:
      case 0x81:
      case 0x82:
      case 0x83:
      case 0x84:
      case 0x85:
      case 0x86:
      case 0x87:
      case 0x88:
      case 0x89:
      case 0x8a:
      case 0x8b:
      case 0x8c:
      case 0x8d:
      case 0x8e:
      case 0x8f:
        pppppppuVar19 = pppppppuVar19 + -0x1c;
        pppppppuVar7 = local_134;
        log2Console(3,"Bugly-libunwind","OP_breg(r%d,0x%lx)\n",pppppppuVar19,local_134);
        if (0xf < (int)pppppppuVar19) {
          pppppppuVar19 = (undefined4 *******)0x0;
        }
        iVar9 = _Uarm_get_reg(param_1,pppppppuVar19,&local_13c);
        if (iVar9 < 0) goto LAB_0002f44c;
        if (0x3f < uVar8) goto LAB_0002f468;
        pppppuVar14 = (undefined4 *****)((int)local_134 + (int)local_13c);
LAB_0002dfa4:
        local_12c[uVar8] = (undefined4 ******)pppppuVar14;
        uVar8 = uVar8 + 1;
        break;
      case 0x90:
        log2Console(3,"Bugly-libunwind","OP_regx(r%d)\n",local_134);
        pppppppuVar7 = local_134;
        if ((undefined4 *******)0xf < local_134) {
          pppppppuVar7 = (undefined4 *******)0x0;
        }
        *param_4 = (int)pppppppuVar7;
LAB_0002f3bc:
        *param_5 = 1;
        goto LAB_0002f44c;
      case 0x92:
        pppppppuVar7 = local_138;
        log2Console(3,"Bugly-libunwind","OP_bregx(r%d,0x%lx)\n",local_134,local_138);
        pppppppuVar19 = local_134;
        if ((undefined4 *******)0xf < local_134) {
          pppppppuVar19 = (undefined4 *******)0x0;
        }
        iVar9 = _Uarm_get_reg(param_1,pppppppuVar19,&local_13c);
        if (-1 < iVar9) {
          if (uVar8 < 0x40) {
            pppppuVar14 = (undefined4 *****)((int)local_13c + (int)pppppppuVar3);
            goto LAB_0002dfa4;
          }
LAB_0002f468:
          pcVar12 = "Stack overflow\n";
          goto LAB_0002f370;
        }
        goto LAB_0002f44c;
      case 0x94:
        log2Console(3,"Bugly-libunwind","OP_deref_size(%d)\n",local_134);
        uVar17 = uVar8 - 1;
        if (0x3f < uVar17) goto LAB_0002f360;
        ppppppuVar13 = local_12c[uVar17];
        switch(local_134) {
        case (undefined4 *******)0x1:
          local_13c = (undefined4 ******)((int)ppppppuVar13 + 1);
          pppppppuVar7 = pppppppuVar4;
          iVar9 = (**(code **)(iVar6 + 0xc))
                            (iVar5,(uint)ppppppuVar13 & 0xfffffffc,&local_130,0,pppppppuVar4);
          if (iVar9 < 0) goto LAB_0002f44c;
          local_12c[uVar17] =
               (undefined4 ******)
               (local_130 >> (((int)ppppppuVar13 - ((uint)ppppppuVar13 & 0xfffffffc)) * 8 & 0xff) &
               0xff);
          break;
        case (undefined4 *******)0x2:
          local_13c = (undefined4 ******)((int)ppppppuVar13 + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))
                            (iVar5,(uint)ppppppuVar13 & 0xfffffffc,&local_130,0,pppppppuVar4);
          uVar18 = local_130;
          ppppppuVar10 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          uVar11 = (uint)local_13c & 0xfffffffc;
          pppppppuVar7 = pppppppuVar4;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar11,&local_130,0,pppppppuVar4);
          if (iVar9 < 0) goto LAB_0002f44c;
          uVar18 = uVar18 >> (((int)ppppppuVar13 - ((uint)ppppppuVar13 & 0xfffffffc)) * 8 & 0xff);
          uVar11 = local_130 >> (((int)ppppppuVar10 - uVar11) * 8 & 0xff);
          uVar15 = uVar11 & 0xff | uVar18 << 8;
          if (*(int *)(iVar5 + 0x20) == 0) {
            uVar15 = uVar18 & 0xff | uVar11 << 8;
          }
          local_12c[uVar17] = (undefined4 ******)(uVar15 & 0xffff);
          break;
        case (undefined4 *******)0x3:
        case (undefined4 *******)0x4:
          local_13c = (undefined4 ******)((int)ppppppuVar13 + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))
                            (iVar5,(uint)ppppppuVar13 & 0xfffffffc,&local_130,0,pppppppuVar4);
          local_164 = local_130;
          ppppppuVar10 = local_13c;
          if (-1 < iVar9) {
            uVar18 = (uint)local_13c & 0xfffffffc;
            local_13c = (undefined4 ******)((int)local_13c + 1);
            iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar18,&local_130,0,pppppppuVar4);
            ppppppuVar2 = local_13c;
            if (-1 < iVar9) {
              local_164 = local_164 >>
                          (((int)ppppppuVar13 - ((uint)ppppppuVar13 & 0xfffffffc)) * 8 & 0xff);
              local_160 = local_130 >> (((int)ppppppuVar10 - uVar18) * 8 & 0xff);
              if (*(int *)(iVar5 + 0x20) == 0) {
                local_164 = local_164 & 0xff;
                local_160 = local_160 << 8;
              }
              else {
                local_160 = local_160 & 0xff;
                local_164 = local_164 << 8;
              }
              uVar11 = (uint)local_13c & 0xfffffffc;
              local_13c = (undefined4 ******)((int)local_13c + 1);
              iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar11,&local_130,0,pppppppuVar4);
              uVar18 = local_130;
              ppppppuVar13 = local_13c;
              if (-1 < iVar9) {
                uVar15 = (uint)local_13c & 0xfffffffc;
                pppppppuVar7 = pppppppuVar4;
                local_13c = (undefined4 ******)((int)local_13c + 1);
                iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar15,&local_130,0,pppppppuVar4);
                if (-1 < iVar9) {
                  uVar18 = uVar18 >> (((int)ppppppuVar2 - uVar11) * 8 & 0xff);
                  uVar11 = local_130 >> (((int)ppppppuVar13 - uVar15) * 8 & 0xff);
                  if (*(int *)(iVar5 + 0x20) == 0) {
                    pppppuVar14 = (undefined4 *****)
                                  (((local_160 | local_164) & 0xffff) +
                                  (uVar18 & 0xff | uVar11 << 8) * 0x10000);
                  }
                  else {
                    pppppuVar14 = (undefined4 *****)
                                  (uVar11 & 0xff | (uVar18 & 0xff) << 8 |
                                  (local_160 | local_164) << 0x10);
                  }
                  if (local_134 == (undefined4 *******)0x3) {
                    pppppuVar14 = (undefined4 *****)((uint)pppppuVar14 & 0xffffff);
                  }
                  goto LAB_0002f2d8;
                }
              }
            }
          }
          goto LAB_0002f44c;
        case (undefined4 *******)0x5:
        case (undefined4 *******)0x6:
        case (undefined4 *******)0x7:
        case (undefined4 *******)0x8:
          local_13c = (undefined4 ******)((int)ppppppuVar13 + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))
                            (iVar5,(uint)ppppppuVar13 & 0xfffffffc,&local_130,0,pppppppuVar4);
          local_164 = local_130;
          ppppppuVar10 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          uVar18 = (uint)local_13c & 0xfffffffc;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar18,&local_130,0,pppppppuVar4);
          ppppppuVar2 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          local_164 = local_164 >>
                      (((int)ppppppuVar13 - ((uint)ppppppuVar13 & 0xfffffffc)) * 8 & 0xff);
          local_158 = local_130 >> (((int)ppppppuVar10 - uVar18) * 8 & 0xff);
          if (*(int *)(iVar5 + 0x20) == 0) {
            local_164 = local_164 & 0xff;
            local_158 = local_158 << 8;
          }
          else {
            local_158 = local_158 & 0xff;
            local_164 = local_164 << 8;
          }
          uVar11 = (uint)local_13c & 0xfffffffc;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar11,&local_130,0,pppppppuVar4);
          uVar18 = local_130;
          ppppppuVar13 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          uVar15 = (uint)local_13c & 0xfffffffc;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar15,&local_130,0,pppppppuVar4);
          ppppppuVar10 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          uVar18 = uVar18 >> (((int)ppppppuVar2 - uVar11) * 8 & 0xff);
          uVar11 = local_130 >> (((int)ppppppuVar13 - uVar15) * 8 & 0xff);
          if (*(int *)(iVar5 + 0x20) == 0) {
            pppppuVar14 = (undefined4 *****)
                          (((local_158 | local_164) & 0xffff) +
                          (uVar18 & 0xff | uVar11 << 8) * 0x10000);
          }
          else {
            pppppuVar14 = (undefined4 *****)
                          (uVar11 & 0xff | (uVar18 & 0xff) << 8 | (local_158 | local_164) << 0x10);
          }
          uVar18 = (uint)local_13c & 0xfffffffc;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar18,&local_130,0,pppppppuVar4);
          local_168 = local_130;
          ppppppuVar13 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          uVar11 = (uint)local_13c & 0xfffffffc;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar11,&local_130,0,pppppppuVar4);
          ppppppuVar2 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          local_168 = local_168 >> (((int)ppppppuVar10 - uVar18) * 8 & 0xff);
          local_160 = local_130 >> (((int)ppppppuVar13 - uVar11) * 8 & 0xff);
          if (*(int *)(iVar5 + 0x20) == 0) {
            local_168 = local_168 & 0xff;
            local_160 = local_160 << 8;
          }
          else {
            local_160 = local_160 & 0xff;
            local_168 = local_168 << 8;
          }
          uVar11 = (uint)local_13c & 0xfffffffc;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar11,&local_130,0,pppppppuVar4);
          uVar18 = local_130;
          ppppppuVar13 = local_13c;
          if (iVar9 < 0) goto LAB_0002f44c;
          uVar15 = (uint)local_13c & 0xfffffffc;
          pppppppuVar7 = pppppppuVar4;
          local_13c = (undefined4 ******)((int)local_13c + 1);
          iVar9 = (**(code **)(iVar6 + 0xc))(iVar5,uVar15,&local_130,0,pppppppuVar4);
          if (iVar9 < 0) goto LAB_0002f44c;
          if (*(int *)(iVar5 + 0x20) != 0) {
            pppppuVar14 = (undefined4 *****)
                          (local_130 >> (((int)ppppppuVar13 - uVar15) * 8 & 0xff) & 0xff |
                           (uVar18 >> (((int)ppppppuVar2 - uVar11) * 8 & 0xff) & 0xff) << 8 |
                          (local_160 | local_168) << 0x10);
          }
          if (local_134 != (undefined4 *******)0x8) {
            pppppuVar14 = (undefined4 *****)
                          ((uint)pppppuVar14 & -1 << (((uint)local_134 & 0x1f) << 3));
          }
LAB_0002f2d8:
          local_12c[uVar17] = (undefined4 ******)pppppuVar14;
          break;
        default:
          pcVar12 = "Unexpected DW_OP_deref_size size %d\n";
          pppppppuVar19 = local_134;
          local_13c = ppppppuVar13;
          goto LAB_0002f510;
        }
        break;
      case 0x96:
        log2Console(3,"Bugly-libunwind","OP_nop\n");
      }
      uVar17 = *param_2;
    } while (uVar17 < uVar16 + param_3);
    uVar8 = uVar8 - 1;
    if (0x3f < uVar8) {
      log2Console(3,"Bugly-libunwind","Stack underflow\n");
      goto LAB_0002f44c;
    }
  }
  pppppuVar14 = local_12c[uVar8];
  *param_4 = (int)pppppuVar14;
  log2Console(3,"Bugly-libunwind","final value = 0x%lx\n",pppppuVar14,pppppppuVar7);
LAB_0002f44c:
  if (__stack_chk_guard - local_2c != 0) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(__stack_chk_guard - local_2c);
  }
  return;
}



void FUN_0002f5fc(int param_1,int param_2,uint *param_3,int param_4,uint *param_5,undefined4 param_6
                 )

{
  int iVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  uint local_40;
  uint local_3c;
  uint local_38;
  uint local_2c;
  int local_28;
  
  if (param_4 == 7) {
    param_4 = 2;
  }
  local_28 = __stack_chk_guard;
  switch(param_4) {
  case 0:
    uVar3 = *param_3;
    *param_3 = uVar3 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar3 & 0xfffffffc,&local_2c,0,param_6);
    if (-1 < iVar1) {
      *param_5 = local_2c >> ((uVar3 - (uVar3 & 0xfffffffc)) * 8 & 0xff) & 0xff;
    }
    goto LAB_0002fe44;
  case 1:
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_6);
    uVar3 = local_2c;
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar4 = *param_3;
    *param_3 = uVar4 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar4 & 0xfffffffc,&local_2c,0,param_6);
    if (iVar1 < 0) goto LAB_0002fe44;
    local_2c = local_2c >> ((uVar4 - (uVar4 & 0xfffffffc)) * 8 & 0xff);
    uVar3 = uVar3 >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    uVar2 = local_2c & 0xff | uVar3 << 8;
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar2 = uVar3 & 0xff | local_2c << 8;
    }
    uVar2 = uVar2 & 0xffff;
    break;
  case 2:
    uVar3 = *param_3;
    *param_3 = uVar3 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar3 & 0xfffffffc,&local_2c,0,param_6);
    local_38 = local_2c;
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_6);
    if (iVar1 < 0) goto LAB_0002fe44;
    local_3c = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    local_38 = local_38 >> ((uVar3 - (uVar3 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_38 = local_38 & 0xff;
      local_3c = local_3c << 8;
    }
    else {
      local_3c = local_3c & 0xff;
      local_38 = local_38 << 8;
    }
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_6);
    uVar3 = local_2c;
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar4 = *param_3;
    *param_3 = uVar4 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar4 & 0xfffffffc,&local_2c,0,param_6);
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar3 = uVar3 >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    local_2c = local_2c >> ((uVar4 - (uVar4 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar3 = ((local_3c | local_38) & 0xffff) + (uVar3 & 0xff | local_2c << 8) * 0x10000;
    }
    else {
      uVar3 = local_2c & 0xff | (uVar3 & 0xff) << 8 | (local_3c | local_38) << 0x10;
    }
    goto LAB_0002fc60;
  case 3:
    uVar3 = *param_3;
    *param_3 = uVar3 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar3 & 0xfffffffc,&local_2c,0,param_6);
    local_38 = local_2c;
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_6);
    if (iVar1 < 0) goto LAB_0002fe44;
    local_3c = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    local_38 = local_38 >> ((uVar3 - (uVar3 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_38 = local_38 & 0xff;
      local_3c = local_3c << 8;
    }
    else {
      local_3c = local_3c & 0xff;
      local_38 = local_38 << 8;
    }
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_6);
    uVar3 = local_2c;
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar4 = *param_3;
    *param_3 = uVar4 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar4 & 0xfffffffc,&local_2c,0,param_6);
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar3 = uVar3 >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    uVar5 = local_2c >> ((uVar4 - (uVar4 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      uVar3 = ((local_3c | local_38) & 0xffff) + (uVar3 & 0xff | uVar5 << 8) * 0x10000;
    }
    else {
      uVar3 = uVar5 & 0xff | (uVar3 & 0xff) << 8 | (local_3c | local_38) << 0x10;
    }
    uVar5 = *param_3;
    *param_3 = uVar5 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_6);
    local_3c = local_2c;
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar4 = *param_3;
    *param_3 = uVar4 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar4 & 0xfffffffc,&local_2c,0,param_6);
    if (iVar1 < 0) goto LAB_0002fe44;
    local_3c = local_3c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
    local_40 = local_2c >> ((uVar4 - (uVar4 & 0xfffffffc)) * 8 & 0xff);
    if (*(int *)(param_1 + 0x20) == 0) {
      local_3c = local_3c & 0xff;
      local_40 = local_40 << 8;
    }
    else {
      local_40 = local_40 & 0xff;
      local_3c = local_3c << 8;
    }
    uVar4 = *param_3;
    *param_3 = uVar4 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar4 & 0xfffffffc,&local_2c,0,param_6);
    uVar5 = local_2c;
    if (iVar1 < 0) goto LAB_0002fe44;
    uVar2 = *param_3;
    *param_3 = uVar2 + 1;
    iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar2 & 0xfffffffc,&local_2c,0,param_6);
    if (iVar1 < 0) goto LAB_0002fe44;
    if (*(int *)(param_1 + 0x20) != 0) {
      uVar3 = local_2c >> ((uVar2 - (uVar2 & 0xfffffffc)) * 8 & 0xff) & 0xff |
              (uVar5 >> ((uVar4 - (uVar4 & 0xfffffffc)) * 8 & 0xff) & 0xff) << 8 |
              (local_40 | local_3c) << 0x10;
    }
LAB_0002fc60:
    *param_5 = uVar3;
    iVar1 = 0;
    goto LAB_0002fe44;
  case 4:
    uVar5 = 0;
    uVar3 = 0;
    do {
      uVar4 = *param_3;
      *param_3 = uVar4 + 1;
      iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar4 & 0xfffffffc,&local_2c,0,param_6);
      if (iVar1 < 0) goto LAB_0002fe44;
      uVar4 = (uVar4 - (uVar4 & 0xfffffffc)) * 8;
      uVar5 = uVar5 | (local_2c >> (uVar4 & 0xff) & 0x7f) << (uVar3 & 0xff);
      uVar3 = uVar3 + 7;
    } while ((local_2c >> (uVar4 & 0xff) & 0x80) != 0);
    *param_5 = uVar5;
    goto LAB_0002f9f4;
  case 5:
    uVar3 = 0;
    uVar5 = 0;
    do {
      uVar4 = *param_3;
      *param_3 = uVar4 + 1;
      iVar1 = (**(code **)(param_2 + 0xc))(param_1,uVar4 & 0xfffffffc,&local_2c,0,param_6);
      if (iVar1 < 0) goto LAB_0002fe44;
      uVar4 = (uVar4 - (uVar4 & 0xfffffffc)) * 8;
      uVar3 = uVar3 | (local_2c >> (uVar4 & 0xff) & 0x7f) << (uVar5 & 0xff);
      uVar5 = uVar5 + 7;
    } while ((local_2c >> (uVar4 & 0xff) & 0x80) != 0);
    uVar2 = uVar3;
    if ((local_2c >> (uVar4 & 0xff) & 0x40) != 0) {
      uVar2 = uVar3 | -1 << (uVar5 & 0xff);
    }
    if (0x1f < uVar5) {
      uVar2 = uVar3;
    }
    break;
  default:
    log2Console(3,"Bugly-libunwind","Unexpected operand type %d\n");
    iVar1 = -8;
    goto LAB_0002fe44;
  }
  *param_5 = uVar2;
LAB_0002f9f4:
  iVar1 = 0;
LAB_0002fe44:
  if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar1);
  }
  return;
}



void _Uarm_dwarf_find_unwind_table
               (int param_1,char *param_2,undefined4 param_3,undefined4 param_4,int param_5,
               int param_6,undefined4 param_7)

{
  bool bVar1;
  int *piVar2;
  undefined4 uVar3;
  int iVar4;
  uint uVar5;
  int iVar6;
  int iVar7;
  int iVar8;
  undefined4 *puVar9;
  int *piVar10;
  uint uVar11;
  uint uVar12;
  char *pcVar13;
  uint uVar14;
  int *piVar15;
  int *piVar16;
  int local_e0;
  int local_dc;
  int local_d8;
  uint local_d4;
  int *local_c4;
  int *local_c0;
  uint local_bc;
  undefined1 auStack_b8 [4];
  int local_b4;
  char *local_b0;
  int local_ac;
  uint local_a8 [2];
  undefined4 local_a0;
  int local_9c [6];
  undefined4 local_84;
  int local_80;
  int local_7c;
  int local_78 [6];
  undefined1 auStack_60 [16];
  undefined4 local_50;
  int local_44 [4];
  ushort local_34 [4];
  int local_2c;
  
  local_2c = __stack_chk_guard;
  uVar3 = 0xfffffff6;
  if (*param_2 == '\0') goto LAB_000305e8;
  if (param_2[2] == '\0') {
    iVar4 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x1c,local_44,4,0);
    if ((iVar4 != 4) ||
       (iVar4 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + 0x2c,local_34,2,0),
       iVar4 != 2)) goto LAB_000305dc;
    if (local_34[0] != 0) {
      local_d8 = 0;
      local_c4 = (int *)0x0;
      local_dc = 0;
      local_e0 = 0;
      local_d4 = 0;
      uVar5 = 0xffffffff;
      uVar12 = 0;
      local_c0 = (int *)0x0;
      iVar4 = local_44[0];
      do {
        iVar7 = _Uelf32_memory_read(param_2,iVar4 + **(int **)(param_2 + 0xc),&local_b0,4,0);
        if (iVar7 != 4) goto LAB_000305dc;
        iVar7 = local_d8;
        if ((int)local_b0 < 0x6474e550) {
          if (local_b0 == (char *)0x1) {
            iVar6 = _Uelf32_memory_read(param_2,iVar4 + **(int **)(param_2 + 0xc) + 8,local_a8,4,0);
            if (iVar6 != 4) goto LAB_000305dc;
            if (local_a8[0] < uVar5) {
              uVar5 = local_a8[0];
            }
            iVar8 = _Uelf32_memory_read(param_2,iVar4 + **(int **)(param_2 + 0xc) + 0x14,local_9c,4,
                                        0);
            iVar6 = local_9c[0];
            uVar11 = local_a8[0];
            if ((iVar8 != 4) ||
               (iVar8 = _Uelf32_memory_read(param_2,iVar4 + **(int **)(param_2 + 0xc) + 4,&local_ac,
                                            4,0), iVar8 != 4)) goto LAB_000305dc;
            if (local_ac == param_6) {
              local_d4 = local_a8[0];
              local_c0 = (int *)iVar4;
            }
            if (local_c4 < iVar6 + uVar11) {
              local_c4 = (int *)(iVar6 + uVar11);
            }
          }
          else if (local_b0 == (char *)0x2) {
            local_e0 = iVar4;
          }
        }
        else {
          iVar7 = iVar4;
          if ((local_b0 != (char *)0x6474e550) && (iVar7 = local_d8, local_b0 == (char *)0x70000001)
             ) {
            local_dc = iVar4;
          }
        }
        local_d8 = iVar7;
        uVar12 = uVar12 + 1;
        iVar4 = iVar4 + 0x20;
      } while (uVar12 < local_34[0]);
      if (local_c0 != (int *)0x0) {
        param_5 = param_5 - local_d4;
        if (local_d8 == 0) {
LAB_0003087c:
          bVar1 = false;
        }
        else {
          *(undefined4 *)(param_1 + 0x10) = 0;
          if ((local_e0 != 0) &&
             (iVar4 = _Uelf32_memory_read(param_2,local_e0 + **(int **)(param_2 + 0xc) + 4,&local_ac
                                          ,4,0), iVar4 == 4)) {
            iVar6 = local_ac + -4;
            iVar7 = **(int **)(param_2 + 0xc);
            iVar4 = (*(int **)(param_2 + 0xc))[1];
            do {
              if ((uint)(iVar4 - iVar7) <= iVar6 + 0xcU) {
LAB_00030600:
                log2Console(3,"Bugly-libunwind","DT_PLTGOT not found in dynamic header\n");
                goto LAB_0003061c;
              }
              iVar8 = _Uelf32_memory_read(param_2,iVar6 + **(int **)(param_2 + 0xc) + 4,&local_80,4,
                                          0);
              if (iVar8 != 4) goto LAB_0003061c;
              if (local_80 == 0) goto LAB_00030600;
              iVar6 = iVar6 + 8;
            } while (local_80 != 3);
            iVar4 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + iVar6,&local_7c,4,0);
            if (iVar4 == 4) {
              *(int *)(param_1 + 0x10) = local_7c;
            }
          }
LAB_0003061c:
          iVar7 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + local_d8 + 4,&local_7c,4,0
                                     );
          iVar4 = local_7c;
          if (iVar7 != 4) goto LAB_0003087c;
          iVar7 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + local_7c,&local_84,4,0);
          if (iVar7 == 4) {
            if ((local_84 & 0xff) != 1) {
              log2Console(3,"Bugly-libunwind","table has unexpected version %d\n");
              goto LAB_00030840;
            }
            __aeabi_memclr8(&local_b0,0x28);
            local_a0 = *(undefined4 *)(param_1 + 0x10);
            uVar3 = _Uarm_get_accessors(*(undefined4 *)(param_2 + 4));
            local_b4 = **(int **)(param_2 + 0xc) + iVar4 + 4;
            iVar7 = FUN_000244d4(*(undefined4 *)(param_2 + 4),uVar3,&local_b4,local_84._1_1_,
                                 &local_b0,auStack_b8,*(undefined4 *)(param_2 + 8));
            if (iVar7 == -1 || iVar7 + 1 < 0 != SCARRY4(iVar7,1)) {
              log2Console(3,"Bugly-libunwind","Failed to read encoded frame start.\n");
              goto LAB_0003087c;
            }
            iVar7 = FUN_000244d4(*(undefined4 *)(param_2 + 4),uVar3,&local_b4,local_84._2_1_,
                                 &local_b0,&local_bc,*(undefined4 *)(param_2 + 8));
            if (iVar7 == -1 || iVar7 + 1 < 0 != SCARRY4(iVar7,1)) {
              log2Console(3,"Bugly-libunwind","Failed to read fde count.\n");
LAB_0003098c:
              bVar1 = false;
            }
            else {
              if (local_84._3_1_ != ';') {
                log2Console(3,"Bugly-libunwind","Unsupported header table format %d\n");
                goto LAB_0003098c;
              }
              *(undefined4 *)(param_1 + 0x1c) = 0;
              *(uint *)(param_1 + 0x24) = (local_bc & 0x1fffffff) << 1;
              iVar7 = _Uelf32_memory_read(param_2,local_d8 + **(int **)(param_2 + 0xc) + 8,local_78,
                                          4,0);
              if ((iVar7 != 4) ||
                 (iVar7 = _Uelf32_memory_read(param_2,**(int **)(param_2 + 0xc) + local_d8 + 4,
                                              &local_7c,4,0), iVar7 != 4)) goto LAB_0003098c;
              iVar7 = **(int **)(param_2 + 0xc);
              *(int *)(param_1 + 0x20) = (local_78[0] + param_5 + iVar4) - local_7c;
              *(int *)(param_1 + 0x28) = ((local_78[0] + param_5 + local_b4) - iVar7) - local_7c;
              *(uint *)(param_1 + 8) = uVar5 + param_5;
              *(int *)(param_1 + 0xc) = (int)local_c4 + param_5;
              *(undefined4 *)(param_1 + 0x14) = 2;
              bVar1 = true;
            }
          }
          else {
            log2Console(3,"Bugly-libunwind",
                        "Failed to read dwarf_eh_frame_hdr from in memory elf image.\n");
LAB_00030840:
            bVar1 = false;
          }
        }
        if ((local_dc == 0) ||
           (iVar4 = **(int **)(param_2 + 0xc),
           (uint)((*(int **)(param_2 + 0xc))[1] - iVar4) <= local_dc + 0x20U)) {
          uVar3 = 0xfffffff6;
          if (bVar1) {
            uVar3 = 1;
          }
          goto LAB_000305e8;
        }
        iVar4 = _Uelf32_memory_read(param_2,local_dc + iVar4 + 8,local_a8,4,0);
        if ((iVar4 == 4) &&
           (iVar4 = _Uelf32_memory_read(param_2,local_dc + **(int **)(param_2 + 0xc) + 0x14,local_9c
                                        ,4,0), iVar4 == 4)) {
          *(undefined4 *)(param_1 + 0x74) = 3;
          *(int *)(param_1 + 0x84) = local_9c[0];
          *(uint *)(param_1 + 0x88) = local_a8[0] + param_5;
          *(uint *)(param_1 + 0x68) = uVar5 + param_5;
          *(int *)(param_1 + 0x6c) = (int)local_c4 + param_5;
          uVar3 = 1;
          *(undefined4 *)(param_1 + 0x7c) = param_4;
          goto LAB_000305e8;
        }
        goto LAB_000305dc;
      }
    }
    log2Console(3,"Bugly-libunwind","PT_LOAD section not found.\n");
  }
  else {
    iVar4 = *(int *)(param_2 + 4);
    if (*(ushort *)(iVar4 + 0x2c) == 0) {
      uVar3 = 0;
      goto LAB_000305e8;
    }
    piVar10 = (int *)(iVar4 + *(int *)(iVar4 + 0x1c));
    local_c4 = (int *)0x0;
    uVar5 = 0xffffffff;
    uVar11 = 0;
    piVar15 = (int *)0x0;
    uVar12 = 0;
    piVar16 = (int *)0x0;
    local_c0 = (int *)0x0;
    do {
      iVar7 = *piVar10;
      piVar2 = local_c0;
      if (iVar7 < 0x6474e550) {
        if (iVar7 == 1) {
          uVar14 = piVar10[2];
          if (piVar10[1] == param_6) {
            piVar15 = piVar10;
          }
          if (uVar12 < piVar10[5] + uVar14) {
            uVar12 = piVar10[5] + uVar14;
          }
          if (uVar14 < uVar5) {
            uVar5 = uVar14;
          }
        }
        else if (iVar7 == 2) {
          piVar16 = piVar10;
        }
      }
      else {
        piVar2 = piVar10;
        if ((iVar7 != 0x6474e550) && (piVar2 = local_c0, iVar7 == 0x70000001)) {
          local_c4 = piVar10;
        }
      }
      local_c0 = piVar2;
      uVar11 = uVar11 + 1;
      piVar10 = piVar10 + 8;
    } while (uVar11 < *(ushort *)(iVar4 + 0x2c));
    if (piVar15 == (int *)0x0) {
      uVar3 = 0;
      goto LAB_000305e8;
    }
    param_5 = param_5 - piVar15[2];
    iVar4 = param_5 + uVar5;
    iVar7 = param_5 + uVar12;
    uVar3 = 0;
    if (local_c0 == (int *)0x0) {
LAB_000303f8:
      if (local_c4 != (int *)0x0) {
        *(undefined4 *)(param_1 + 0x74) = 3;
        *(int *)(param_1 + 0x68) = iVar4;
        *(int *)(param_1 + 0x6c) = iVar7;
        *(undefined4 *)(param_1 + 0x7c) = param_4;
        *(int *)(param_1 + 0x88) = local_c4[2] + param_5;
        *(int *)(param_1 + 0x84) = local_c4[5];
        uVar3 = 1;
      }
      uVar3 = _Uarm_dwarf_find_debug_frame(uVar3,param_1 + 0x30,param_7,param_5,param_4,iVar4,iVar7)
      ;
      goto LAB_000305e8;
    }
    *(undefined4 *)(param_1 + 0x10) = 0;
    if (piVar16 != (int *)0x0) {
      iVar8 = *(int *)(param_2 + 4) + piVar16[1];
      iVar6 = -*(int *)(param_2 + 4);
      if ((uint)(iVar6 + 8 + iVar8) < *(uint *)(param_2 + 8)) {
        puVar9 = (undefined4 *)(iVar8 + 4);
        do {
          if (puVar9[-1] == 0) break;
          if (puVar9[-1] == 3) {
            *(undefined4 *)(param_1 + 0x10) = *puVar9;
            break;
          }
          uVar5 = (int)puVar9 + iVar6 + 0xc;
          puVar9 = puVar9 + 2;
        } while (uVar5 < *(uint *)(param_2 + 8));
      }
    }
    pcVar13 = (char *)(*(int *)(param_2 + 4) + local_c0[1]);
    if (*pcVar13 == '\x01') {
      uVar3 = _Uarm_get_accessors(_Uarm_local_addr_space);
      local_b0 = pcVar13 + 4;
      __aeabi_memclr8(auStack_60,0x28);
      local_50 = *(undefined4 *)(param_1 + 0x10);
      iVar6 = FUN_000244d4(_Uarm_local_addr_space,uVar3,&local_b0,pcVar13[1],auStack_60,&local_80,0)
      ;
      if (-1 < iVar6) {
        iVar6 = FUN_000244d4(_Uarm_local_addr_space,uVar3,&local_b0,pcVar13[2],auStack_60,&local_84,
                             0);
        uVar3 = 0xfffffff6;
        if (iVar6 < 0) goto LAB_000305e8;
        uVar3 = 0;
        if (pcVar13[3] == ';') {
          *(int *)(param_1 + 8) = iVar4;
          *(int *)(param_1 + 0xc) = iVar7;
          *(undefined4 *)(param_1 + 0x14) = 2;
          *(undefined4 *)(param_1 + 0x1c) = 0;
          *(uint *)(param_1 + 0x24) = (local_84 & 0x1fffffff) << 1;
          *(char **)(param_1 + 0x28) =
               local_b0 + (((local_c0[2] + param_5) - *(int *)(param_2 + 4)) - local_c0[1]);
          *(char **)(param_1 + 0x20) =
               pcVar13 + (((local_c0[2] + param_5) - *(int *)(param_2 + 4)) - local_c0[1]);
          uVar3 = 1;
        }
        goto LAB_000303f8;
      }
    }
    else {
      log2Console(3,"Bugly-libunwind","table `%s\' has unexpected version %d\n",param_4,*pcVar13);
    }
  }
LAB_000305dc:
  uVar3 = 0xfffffff6;
LAB_000305e8:
  if (__stack_chk_guard != local_2c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar3);
  }
  return;
}



undefined4
FUN_00030a04(undefined4 param_1,undefined4 param_2,undefined4 *param_3,int param_4,int param_5)

{
  undefined4 uVar1;
  int iVar2;
  
  *param_3 = *(undefined4 *)(param_4 + 8);
  param_3[1] = *(undefined4 *)(param_4 + 0xc);
  param_3[4] = *(undefined4 *)(param_4 + 0x10);
  iVar2 = *(int *)(param_4 + 0x14);
  param_3[6] = iVar2;
  if (iVar2 - 1U < 2) {
    uVar1 = _Uarm_search_unwind_table(param_1,param_2,param_4,param_3);
    return uVar1;
  }
  uVar1 = 0xfffffff8;
  if (iVar2 == 0) {
    uVar1 = *(undefined4 *)(param_4 + 0x20);
    param_3[2] = 0;
    param_3[3] = uVar1;
    uVar1 = *(undefined4 *)(param_4 + 0x24);
    param_3[7] = 0;
    param_3[5] = uVar1;
    if (param_5 != 0) {
      param_3[8] = param_4;
      return 0;
    }
    uVar1 = 0;
    param_3[8] = 0;
  }
  return uVar1;
}



void FUN_00031124(int param_1,undefined4 param_2)

{
  int iVar1;
  undefined4 uVar2;
  int local_20;
  int local_1c;
  
  local_1c = __stack_chk_guard;
  if (*(int *)(param_1 + 0x30) == 0) {
    uVar2 = 0;
  }
  else {
    iVar1 = _Uarm_get_accessors(param_1);
    iVar1 = (**(code **)(iVar1 + 0xc))(param_1,*(undefined4 *)(param_1 + 0x30),&local_20,0,param_2);
    uVar2 = 1;
    if ((-1 < iVar1) && (local_20 != *(int *)(param_1 + 0x2c))) {
      _Uarm_flush_cache(param_1,0,0);
      *(int *)(param_1 + 0x2c) = local_20;
      uVar2 = 0xffffffff;
    }
  }
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar2);
  }
  return;
}



void FUN_000311d8(undefined4 param_1,int param_2,uint *param_3,undefined4 *param_4,
                 undefined4 param_5)

{
  undefined1 *puVar1;
  int iVar2;
  uint uVar3;
  undefined1 *puVar4;
  uint uVar5;
  uint uVar6;
  undefined1 *local_34;
  int local_30;
  uint local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  *param_4 = 0;
  if (*param_3 != 0) {
    iVar2 = (**(code **)(param_2 + 0xc))(param_1,*param_3,&local_30,0,param_5);
    uVar3 = *param_3;
    uVar5 = uVar3 + 4;
    *param_3 = uVar5;
    if (-1 < iVar2) {
      *param_3 = uVar3 + 8;
      iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_5);
      uVar3 = local_2c;
      if (-1 < iVar2) {
        uVar6 = *param_3;
        *param_3 = uVar6 + 4;
        iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar6 & 0xfffffffc,&local_2c,0,param_5);
        if (-1 < iVar2) {
          uVar6 = local_2c >> ((uVar6 - (uVar6 & 0xfffffffc)) * 8 & 0xff);
          puVar4 = (undefined1 *)calloc(1,uVar6 * 0xc + 0xc);
          if (puVar4 != (undefined1 *)0x0) {
            *(uint *)(puVar4 + 4) = uVar3 >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
            *(uint *)(puVar4 + 8) = uVar6;
            if (uVar6 != 0) {
              uVar3 = 0;
              uVar5 = *param_3;
              puVar1 = puVar4;
              do {
                local_34 = puVar1 + 0xc;
                *param_3 = uVar5 + 1;
                iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_5)
                ;
                *local_34 = (char)(local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff));
                if (iVar2 < 0) goto LAB_00031574;
                uVar5 = *param_3;
                *param_3 = uVar5 + 1;
                iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_5)
                ;
                puVar1[0xd] = (char)(local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff));
                if (iVar2 < 0) goto LAB_00031574;
                uVar5 = *param_3;
                *param_3 = uVar5 + 2;
                iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_5)
                ;
                *(short *)(puVar1 + 0xe) =
                     (short)(local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff));
                if (iVar2 < 0) goto LAB_00031574;
                uVar5 = *param_3;
                *param_3 = uVar5 + 4;
                iVar2 = (**(code **)(param_2 + 0xc))(param_1,uVar5 & 0xfffffffc,&local_2c,0,param_5)
                ;
                *(uint *)(puVar1 + 0x10) = local_2c >> ((uVar5 - (uVar5 & 0xfffffffc)) * 8 & 0xff);
                if (iVar2 < 0) goto LAB_00031574;
                iVar2 = (**(code **)(param_2 + 0xc))(param_1,*param_3,puVar1 + 0x14,0,param_5);
                uVar5 = *param_3 + 4;
                *param_3 = uVar5;
                if (iVar2 < 0) goto LAB_00031574;
                uVar3 = uVar3 + 1;
                puVar1 = local_34;
              } while (uVar3 < uVar6);
            }
            if ((local_30 == 0) ||
               (iVar2 = FUN_000311d8(param_1,param_2,&local_30,puVar4,param_5), -1 < iVar2)) {
              *param_4 = puVar4;
            }
            else {
LAB_00031574:
              FUN_000315c0(puVar4);
            }
          }
        }
      }
    }
  }
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void FUN_000315c0(int *param_1)

{
  if (*param_1 != 0) {
    FUN_000315c0();
  }
  free(param_1);
  return;
}



uint * decode_eht_entry(uint *param_1,undefined4 *param_2,int *param_3)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  undefined4 uVar4;
  
  uVar1 = *param_1;
  if (-1 < (int)uVar1) {
    *param_2 = 1;
    *param_3 = (param_1[1] >> 0x18) * 4 + 4;
    return param_1 + 1;
  }
  uVar3 = (uVar1 << 4) >> 0x1c;
  if (uVar3 == 0) {
    uVar4 = 1;
    iVar2 = 4;
  }
  else {
    if (uVar3 != 3 && uVar3 != 1) {
      return (uint *)0x0;
    }
    iVar2 = ((uVar1 << 8) >> 0x18) * 4 + 4;
    uVar4 = 2;
  }
  *param_3 = iVar2;
  *param_2 = uVar4;
  return param_1;
}



void _Unwind_VRS_Interpret(undefined4 param_1,int param_2,undefined1 *param_3,undefined1 *param_4)

{
  byte bVar1;
  bool bVar2;
  int iVar3;
  undefined4 uVar4;
  uint uVar5;
  uint uVar6;
  int unaff_r6;
  uint uVar7;
  undefined1 *puVar8;
  undefined1 *puVar9;
  uint uVar10;
  
  iVar3 = __stack_chk_guard;
  bVar2 = false;
  uVar10 = 0;
  puVar9 = param_4;
LAB_00031658:
  if ((bVar2) || (param_4 <= param_3)) {
    if (uVar10 == 0) {
      unw_get_reg(param_1,0xe,&stack0xffffffd4);
      unw_set_reg(param_1,0xf,unaff_r6);
    }
    uVar4 = 8;
switchD_0003176a_caseD_b4:
    if (__stack_chk_guard == iVar3) {
      return;
    }
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar4);
  }
  puVar8 = param_3 + 1;
  uVar7 = (uint)*(byte *)(param_2 + ((uint)param_3 ^ 3));
  if (-1 < (int)(uVar7 << 0x18)) {
    unw_get_reg(param_1,0xd,&stack0xffffffd4);
    if ((int)(uVar7 << 0x19) < 0) {
      unaff_r6 = (-4 - (uVar7 * 4 & 0xfc)) + unaff_r6;
    }
    else {
      unaff_r6 = uVar7 * 4 + unaff_r6 + 4;
    }
LAB_000316f8:
    unw_set_reg(param_1,0xd);
    bVar2 = false;
    param_3 = puVar8;
    goto LAB_00031658;
  }
  switch((uVar7 & 0xf0) - 0x80 >> 4) {
  case 0:
    if ((puVar8 < param_4) &&
       (uVar5 = (uVar7 & 0xf) << 0xc | (uint)*(byte *)(param_2 + ((uint)puVar8 ^ 3)) << 4,
       uVar5 != 0)) {
      bVar2 = false;
      _Unwind_VRS_Pop(param_1,0,uVar5,0,puVar9);
      uVar10 = uVar10 | (uVar7 & 8) >> 3;
      param_3 = param_3 + 2;
      goto LAB_00031658;
    }
    break;
  case 1:
    if ((uVar7 & 0xf | 2) != 0xf) {
      puVar9 = &stack0xffffffd4;
      bVar2 = false;
      _Unwind_VRS_Get(param_1,0,uVar7 & 0xf,0);
      unw_set_reg(param_1,0xd,unaff_r6);
      param_3 = puVar8;
      goto LAB_00031658;
    }
    break;
  case 2:
    bVar2 = false;
    _Unwind_VRS_Pop(param_1,0,(0x20 << (uVar7 & 7)) - 0x10U | (uVar7 & 8) << 0xb,0,puVar9);
    param_3 = puVar8;
    goto LAB_00031658;
  case 3:
    uVar4 = 9;
    bVar2 = true;
    switch(uVar7) {
    case 0xb0:
      param_3 = puVar8;
      break;
    case 0xb1:
      if (param_4 <= puVar8) goto switchD_000316a4_default;
      bVar1 = *(byte *)(param_2 + ((uint)puVar8 ^ 3));
      uVar4 = 9;
      if ((bVar1 == 0) || ((bVar1 & 0xf0) != 0)) goto switchD_0003176a_caseD_b4;
      bVar2 = false;
      _Unwind_VRS_Pop(param_1,0,bVar1,0,puVar9);
      param_3 = param_3 + 2;
      break;
    case 0xb2:
      uVar5 = 0;
      uVar7 = 0;
      do {
        if (param_4 <= puVar8) goto switchD_000316a4_default;
        uVar6 = (uint)puVar8 ^ 3;
        puVar8 = puVar8 + 1;
        uVar6 = (uint)*(byte *)(param_2 + uVar6);
        uVar5 = uVar5 | (uVar6 & 0x7f) << (uVar7 & 0xff);
        uVar7 = uVar7 + 7;
      } while ((int)(uVar6 << 0x18) < 0);
      unw_get_reg(param_1,0xd,&stack0xffffffd4);
      unaff_r6 = unaff_r6 + uVar5 * 4 + 0x204;
      goto LAB_000316f8;
    case 0xb3:
      uVar4 = 1;
      uVar7 = (uint)*(byte *)(param_2 + ((uint)puVar8 ^ 3));
      uVar7 = (uVar7 & 0xf) + 1 | (uVar7 & 0xf0) << 0xc;
LAB_000317d2:
      _Unwind_VRS_Pop(param_1,1,uVar7,uVar4,puVar9);
      bVar2 = false;
      param_3 = param_3 + 2;
      break;
    case 0xb4:
    case 0xb5:
    case 0xb6:
    case 0xb7:
      goto switchD_0003176a_caseD_b4;
    default:
      uVar4 = 1;
LAB_000317f4:
      _Unwind_VRS_Pop(param_1,1,(uVar7 & 7) + 0x80001,uVar4,puVar9);
      bVar2 = false;
      param_3 = puVar8;
    }
    goto LAB_00031658;
  case 4:
    if ((uVar7 & 0xfe) == 200) {
      bVar1 = *(byte *)(param_2 + ((uint)puVar8 ^ 3));
      uVar5 = bVar1 & 0xf;
      uVar7 = (uint)(bVar1 >> 4) | (uint)(uVar7 == 200) << 4;
      if (uVar7 + uVar5 < 0x20) {
        uVar4 = 5;
        uVar7 = uVar5 + 1 | uVar7 << 0x10;
        goto LAB_000317d2;
      }
    }
    break;
  case 5:
    if (-1 < (int)(uVar7 << 0x1c)) {
      uVar4 = 5;
      goto LAB_000317f4;
    }
  }
switchD_000316a4_default:
  uVar4 = 9;
  goto switchD_0003176a_caseD_b4;
}



int _Unwind_VRS_Get(undefined4 param_1,int param_2,uint param_3,uint param_4,undefined4 param_5)

{
  int iVar1;
  
  if (param_2 == 1) {
    if ((param_4 | 4) != 5) {
      return 2;
    }
    if (param_4 == 1) {
      if (0xf < param_3) {
        return 2;
      }
      unw_save_vfp_as_X(param_1);
    }
    else if (0x1f < param_3) {
      return 2;
    }
    iVar1 = unw_get_fpreg(param_1,param_3 + 0x100,param_5);
  }
  else {
    if (param_2 != 0) {
      fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","_Unwind_VRS_Get_Internal",
              "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/Unwind-EHABI.cpp"
              ,0x35e,"unsupported register class");
      fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
      abort();
    }
    if (0xf < param_3) {
      return 2;
    }
    if (param_4 != 0) {
      return 2;
    }
    iVar1 = unw_get_reg(param_1,param_3,param_5);
  }
  if (iVar1 != 0) {
    iVar1 = 2;
  }
  return iVar1;
}



int _Unwind_VRS_Set(undefined4 param_1,int param_2,uint param_3,uint param_4,undefined4 *param_5)

{
  int iVar1;
  
  if (param_2 == 1) {
    if ((param_4 | 4) != 5) {
      return 2;
    }
    if (param_4 == 1) {
      if (0xf < param_3) {
        return 2;
      }
      unw_save_vfp_as_X(param_1);
    }
    else if (0x1f < param_3) {
      return 2;
    }
    iVar1 = unw_set_fpreg(param_1,param_3 + 0x100,*param_5,param_5[1]);
  }
  else {
    if (param_2 != 0) {
      fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","_Unwind_VRS_Set",
              "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/Unwind-EHABI.cpp"
              ,0x328,"unsupported register class");
      fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
      abort();
    }
    if (0xf < param_3) {
      return 2;
    }
    if (param_4 != 0) {
      return 2;
    }
    iVar1 = unw_set_reg(param_1,param_3,*param_5);
  }
  if (iVar1 != 0) {
    iVar1 = 2;
  }
  return iVar1;
}



void _Unwind_VRS_Pop(undefined4 param_1,int param_2,uint param_3,int *param_4)

{
  int iVar1;
  int iVar2;
  bool bVar3;
  uint uVar4;
  int *unaff_r6;
  uint uVar5;
  int *local_38;
  
  iVar1 = __stack_chk_guard;
  local_38 = param_4;
  if (param_2 == 1) {
    if ((((uint)param_4 | 4) == 5) &&
       (iVar2 = unw_get_reg(param_1,0xd,&stack0xffffffd4,param_4,1,param_3), iVar2 == 0)) {
      uVar4 = param_3 >> 0x10;
      uVar5 = uVar4 + (param_3 & 0xffff);
      do {
        if (uVar5 <= uVar4) {
          if (param_4 == (int *)0x1) {
            unaff_r6 = unaff_r6 + 1;
          }
          goto LAB_00031aec;
        }
        local_38 = (int *)*unaff_r6;
        iVar2 = _Unwind_VRS_Set(param_1,1,uVar4,param_4,&local_38);
        uVar4 = uVar4 + 1;
        unaff_r6 = unaff_r6 + 2;
      } while (iVar2 == 0);
    }
  }
  else {
    if (param_2 != 0) {
      fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","_Unwind_VRS_Pop",
              "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/Unwind-EHABI.cpp"
              ,0x3b8,"unsupported register class");
      fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
      abort();
    }
    if ((param_4 == (int *)0x0) &&
       (iVar2 = unw_get_reg(param_1,0xd,&local_38,0,0,param_3), iVar2 == 0)) {
      bVar3 = false;
      for (uVar5 = 0; uVar5 < 0x10; uVar5 = uVar5 + 1) {
        if ((1 << (uVar5 & 0xff) & param_3) != 0) {
          local_38 = local_38 + 1;
          iVar2 = _Unwind_VRS_Set(param_1,0,uVar5,0,&stack0xffffffd4);
          if (iVar2 != 0) goto LAB_00031ac2;
          bVar3 = (bool)(bVar3 | uVar5 == 0xd);
        }
      }
      unaff_r6 = local_38;
      if (bVar3) {
        iVar2 = 0;
      }
      else {
LAB_00031aec:
        iVar2 = unw_set_reg(param_1,0xd,unaff_r6);
        if (iVar2 != 0) {
          iVar2 = 2;
        }
      }
      goto LAB_00031ac4;
    }
  }
LAB_00031ac2:
  iVar2 = 2;
LAB_00031ac4:
  if (__stack_chk_guard == iVar1) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(iVar2);
}



undefined4 __aeabi_unwind_cpp_pr0(undefined4 param_1,int param_2,undefined4 param_3)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  
  piVar1 = (int *)_Unwind_GetLanguageSpecificData(param_3);
  if (((*(byte *)(param_2 + 0x50) & 1) == 0) && (*piVar1 != 0)) {
    return 9;
  }
  iVar2 = unw_step(param_3);
  uVar3 = 9;
  if (iVar2 == 1) {
    uVar3 = 8;
  }
  return uVar3;
}



undefined4 __aeabi_unwind_cpp_pr1(undefined4 param_1,int param_2,undefined4 param_3)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  
  piVar1 = (int *)_Unwind_GetLanguageSpecificData(param_3);
  if (((*(byte *)(param_2 + 0x50) & 1) == 0) && (*piVar1 != 0)) {
    return 9;
  }
  iVar2 = unw_step(param_3);
  uVar3 = 9;
  if (iVar2 == 1) {
    uVar3 = 8;
  }
  return uVar3;
}



undefined4 __aeabi_unwind_cpp_pr2(undefined4 param_1,int param_2,undefined4 param_3)

{
  int *piVar1;
  int iVar2;
  undefined4 uVar3;
  
  piVar1 = (int *)_Unwind_GetLanguageSpecificData(param_3);
  if (((*(byte *)(param_2 + 0x50) & 1) == 0) && (*piVar1 != 0)) {
    return 9;
  }
  iVar2 = unw_step(param_3);
  uVar3 = 9;
  if (iVar2 == 1) {
    uVar3 = 8;
  }
  return uVar3;
}



void _Unwind_RaiseException(int param_1)

{
  int iVar1;
  undefined4 uVar2;
  undefined4 local_8a8 [3];
  code *local_89c;
  undefined4 local_894;
  undefined4 local_888;
  undefined1 auStack_880 [1120];
  undefined1 auStack_420 [1028];
  int iStack_1c;
  
  iStack_1c = __stack_chk_guard;
  unw_getcontext(auStack_420);
  *(undefined4 *)(param_1 + 0xc) = 0;
  unw_init_local(auStack_880,auStack_420);
  do {
    do {
      iVar1 = unw_get_proc_info(auStack_880,local_8a8);
      if (iVar1 != 0) goto LAB_00031bfe;
    } while (local_89c == (code *)0x0);
    *(undefined4 *)(param_1 + 0x48) = local_8a8[0];
    *(undefined4 *)(param_1 + 0x4c) = local_888;
    *(undefined4 *)(param_1 + 0x50) = local_894;
    iVar1 = (*local_89c)(0,param_1,auStack_880);
  } while (iVar1 == 8);
  if (iVar1 == 6) {
    FUN_00031c30(auStack_420,auStack_880,param_1,0);
    uVar2 = 2;
  }
  else if (iVar1 == 9) {
    uVar2 = 9;
  }
  else {
LAB_00031bfe:
    uVar2 = 3;
  }
  if (__stack_chk_guard != iStack_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar2);
  }
  return;
}



void FUN_00031c30(undefined4 param_1,undefined4 param_2,int param_3,uint param_4)

{
  int iVar1;
  undefined4 uVar2;
  int iVar3;
  undefined4 local_58;
  undefined4 local_54 [3];
  code *local_48;
  undefined4 local_40;
  undefined4 local_34;
  int local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  unw_init_local(param_2,param_1);
  iVar3 = 1;
  do {
    uVar2 = 1;
    if (((param_4 & 1) != 0) && (uVar2 = 2, iVar3 == 0)) {
      unw_set_reg(param_2,0xffffffff,*(undefined4 *)(param_3 + 0x10));
      param_4 = 0;
    }
    unw_get_reg(param_2,0xfffffffe,&local_2c);
    iVar1 = unw_get_proc_info(param_2,local_54);
    if (iVar1 != 0) goto LAB_00031ce8;
    if (local_48 != (code *)0x0) {
      *(undefined4 *)(param_3 + 0x48) = local_54[0];
      *(undefined4 *)(param_3 + 0x4c) = local_34;
      *(undefined4 *)(param_3 + 0x50) = local_40;
      iVar1 = (*local_48)(uVar2,param_3,param_2);
      if (iVar1 == 7) {
        unw_get_reg(param_2,0xffffffff,&local_58);
        *(undefined4 *)(param_3 + 0x10) = local_58;
        unw_resume(param_2);
LAB_00031ce8:
        if (__stack_chk_guard != local_28) {
                    // WARNING: Subroutine does not return
          __stack_chk_fail();
        }
        return;
      }
      if (iVar1 != 8) {
        if (iVar1 == 9) {
                    // WARNING: Subroutine does not return
          abort();
        }
        goto LAB_00031ce8;
      }
      if (local_2c == *(int *)(param_3 + 0x20)) {
        fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","unwind_phase2",
                "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/Unwind-EHABI.cpp"
                ,0x268,
                "during phase1 personality function said it would stop here, but now in phase2 it did not stop here"
               );
        fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
        abort();
      }
    }
    iVar3 = iVar3 + -1;
  } while( true );
}



void _Unwind_Complete(void)

{
  return;
}



void _Unwind_Resume(undefined4 param_1)

{
  undefined1 auStack_870 [1120];
  undefined1 auStack_410 [1024];
  
  unw_getcontext(auStack_410);
  FUN_00031c30(auStack_410,auStack_870,param_1,1);
  fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","_Unwind_Resume",
          "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/Unwind-EHABI.cpp"
          ,0x2ce,"_Unwind_Resume() can\'t return");
  fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
  abort();
}



void _Unwind_GetLanguageSpecificData(undefined4 param_1)

{
  int iVar1;
  undefined1 auStack_3c [8];
  undefined4 local_34;
  int local_14;
  
  local_14 = __stack_chk_guard;
  iVar1 = unw_get_proc_info(param_1,auStack_3c);
  if (iVar1 != 0) {
    local_34 = 0;
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_34);
  }
  return;
}



void _Unwind_GetRegionStart(undefined4 param_1)

{
  int iVar1;
  undefined4 local_3c [10];
  int local_14;
  
  local_14 = __stack_chk_guard;
  iVar1 = unw_get_proc_info(param_1,local_3c);
  if (iVar1 != 0) {
    local_3c[0] = 0;
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(local_3c[0]);
  }
  return;
}



void _Unwind_DeleteException(int param_1)

{
  if (*(code **)(param_1 + 8) != (code *)0x0) {
                    // WARNING: Could not recover jumptable at 0x00031e24. Too many branches
                    // WARNING: Treating indirect jump as call
    (**(code **)(param_1 + 8))(1,param_1);
    return;
  }
  return;
}



int __gnu_unwind_frame(undefined4 param_1,undefined4 param_2)

{
  int iVar1;
  
  iVar1 = unw_step(param_2);
  iVar1 = iVar1 + -1;
  if (iVar1 != 0) {
    iVar1 = 9;
  }
  return iVar1;
}



undefined4 unw_getcontext(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 unaff_r4;
  undefined4 unaff_r5;
  undefined4 unaff_r6;
  undefined4 unaff_r7;
  undefined4 unaff_r8;
  undefined4 unaff_r9;
  undefined4 unaff_r10;
  undefined4 unaff_r11;
  undefined4 in_r12;
  undefined4 in_lr;
  
  *(int *)param_1 = param_1;
  *(undefined4 *)(param_1 + 4) = param_2;
  *(undefined4 *)(param_1 + 8) = param_3;
  *(undefined4 *)(param_1 + 0xc) = param_4;
  *(undefined4 *)(param_1 + 0x10) = unaff_r4;
  *(undefined4 *)(param_1 + 0x14) = unaff_r5;
  *(undefined4 *)(param_1 + 0x18) = unaff_r6;
  *(undefined4 *)(param_1 + 0x1c) = unaff_r7;
  *(undefined4 *)(param_1 + 0x20) = unaff_r8;
  *(undefined4 *)(param_1 + 0x24) = unaff_r9;
  *(undefined4 *)(param_1 + 0x28) = unaff_r10;
  *(undefined4 *)(param_1 + 0x2c) = unaff_r11;
  *(undefined4 *)(param_1 + 0x30) = in_r12;
  *(BADSPACEBASE **)(param_1 + 0x34) = register0x00000054;
  *(undefined4 *)(param_1 + 0x38) = in_lr;
  *(undefined4 *)(param_1 + 0x3c) = in_lr;
  return 0;
}



void FUN_00031e54(undefined8 *param_1)

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



void FUN_00031e5c(undefined8 *param_1)

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



void FUN_00031e64(undefined8 *param_1)

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



undefined4 unw_init_local(undefined4 *param_1,undefined4 param_2)

{
  *(undefined2 *)(param_1 + 0x12) = 0;
  *(undefined1 *)((int)param_1 + 0x4a) = 0;
  *param_1 = &PTR_LAB_00032024_1_0003c924;
  param_1[1] = &DAT_00063298;
  __aeabi_memcpy(param_1 + 2,param_2,0x40);
  __aeabi_memclr8(param_1 + 0x14,0x132);
  FUN_00032100(param_1,0);
  return 0;
}



undefined4 unw_get_reg(int *param_1,undefined4 param_2,undefined4 *param_3)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = (**(code **)(*param_1 + 8))(param_1);
  if (iVar1 == 0) {
    uVar2 = 0xffffe672;
  }
  else {
    uVar2 = (**(code **)(*param_1 + 0xc))(param_1,param_2);
    *param_3 = uVar2;
    uVar2 = 0;
  }
  return uVar2;
}



undefined4 unw_set_reg(int *param_1,int param_2,undefined4 param_3)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = (**(code **)(*param_1 + 8))(param_1);
  if (iVar1 == 0) {
    uVar2 = 0xffffe672;
  }
  else {
    (**(code **)(*param_1 + 0x10))(param_1,param_2,param_3);
    if (param_2 == -1) {
      uVar2 = 0;
      (**(code **)(*param_1 + 0x34))(param_1,0);
    }
    else {
      uVar2 = 0;
    }
  }
  return uVar2;
}



undefined4 unw_get_fpreg(int *param_1,undefined4 param_2,undefined8 *param_3)

{
  int iVar1;
  undefined4 uVar2;
  undefined8 uVar3;
  
  iVar1 = (**(code **)(*param_1 + 0x14))(param_1);
  if (iVar1 == 0) {
    uVar2 = 0xffffe672;
  }
  else {
    uVar3 = (**(code **)(*param_1 + 0x18))(param_1,param_2);
    *param_3 = uVar3;
    uVar2 = 0;
  }
  return uVar2;
}



undefined4 unw_set_fpreg(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = (**(code **)(*param_1 + 0x14))(param_1);
  if (iVar1 == 0) {
    uVar2 = 0xffffe672;
  }
  else {
    (**(code **)(*param_1 + 0x1c))(param_1,param_2,param_3,param_4);
    uVar2 = 0;
  }
  return uVar2;
}



void unw_step(int *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00031fa8. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(*param_1 + 0x20))();
  return;
}



undefined4 unw_get_proc_info(int *param_1,int param_2)

{
  undefined4 uVar1;
  
  (**(code **)(*param_1 + 0x24))(param_1,param_2);
  uVar1 = 0;
  if (*(int *)(param_2 + 4) == 0) {
    uVar1 = 0xffffe66b;
  }
  return uVar1;
}



undefined4 unw_resume(int *param_1)

{
  (**(code **)(*param_1 + 0x28))();
  return 0xffffe674;
}



undefined4 unw_get_proc_name(int *param_1)

{
  int iVar1;
  undefined4 uVar2;
  
  iVar1 = (**(code **)(*param_1 + 0x30))();
  uVar2 = 0xffffe674;
  if (iVar1 != 0) {
    uVar2 = 0;
  }
  return uVar2;
}



void unw_is_fpreg(int *param_1)

{
  (**(code **)(*param_1 + 0x14))();
  return;
}



void unw_regname(int *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00032010. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(*param_1 + 0x38))();
  return;
}



void unw_is_signal_frame(int *param_1)

{
  (**(code **)(*param_1 + 0x2c))();
  return;
}



void unw_save_vfp_as_X(int *param_1)

{
                    // WARNING: Could not recover jumptable at 0x00032022. Too many branches
                    // WARNING: Treating indirect jump as call
  (**(code **)(*param_1 + 0x3c))();
  return;
}



int FUN_0003205e(int *param_1)

{
  int iVar1;
  
  if ((char)param_1[0x60] != '\0') {
    return 0;
  }
  iVar1 = FUN_000323c8(param_1);
  if (iVar1 == 1) {
    (**(code **)(*param_1 + 0x34))(param_1,1);
    if ((char)param_1[0x60] != '\0') {
      return 0;
    }
    if (param_1[0x5a] != 0) {
      iVar1 = (**(code **)(*param_1 + 0xc))(param_1,0xfffffffe);
      (**(code **)(*param_1 + 0x10))(param_1,0xfffffffe,param_1[0x5a] + iVar1);
    }
    iVar1 = 1;
  }
  return iVar1;
}



void FUN_000320cc(int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  int iVar2;
  
  iVar2 = param_1[1];
  uVar1 = (**(code **)(*param_1 + 0xc))(param_1,0xffffffff);
  FUN_0003245c(iVar2,uVar1,param_2,param_3,param_4);
  return;
}



void FUN_00032100(int *param_1,int param_2)

{
  uint uVar1;
  int iVar2;
  int local_24 [2];
  int local_1c;
  
  local_1c = __stack_chk_guard;
  uVar1 = (**(code **)(*param_1 + 0xc))(param_1,0xffffffff);
  param_2 = (uVar1 & 0xfffffffe) - param_2;
  iVar2 = FUN_000324bc(param_1[1],param_2,local_24);
  if (((iVar2 == 0) || (local_24[0] == 0)) ||
     (iVar2 = FUN_00032500(param_1,param_2,local_24), iVar2 == 0)) {
    *(undefined1 *)(param_1 + 0x60) = 1;
  }
  if (__stack_chk_guard != local_1c) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



void FUN_000321a0(void)

{
  fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","getRegister",
          "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/Registers.hpp"
          ,0x5db,"unsupported arm register");
  fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
  abort();
}



void FUN_00032216(void)

{
  fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","setRegister",
          "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/Registers.hpp"
          ,0x5fe,"unsupported arm register");
  fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
  abort();
}



void FUN_000323c8(int param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4)

{
  undefined4 uVar1;
  undefined4 local_1c;
  undefined4 uStack_18;
  int local_14;
  
  local_14 = __stack_chk_guard;
  local_1c = 0;
  uStack_18 = 0;
  uVar1 = decode_eht_entry(*(undefined4 *)(param_1 + 0x178),&local_1c,&uStack_18,param_4,param_1);
  uVar1 = _Unwind_VRS_Interpret(param_1,uVar1,local_1c,uStack_18);
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar1);
  }
  return;
}



void FUN_00032428(int param_1)

{
  if (*(char *)(param_1 + 0x41) != '\0') {
    if (*(char *)(param_1 + 0x40) == '\0') {
      FUN_00032bc0(param_1 + 0x48);
    }
    else {
      FUN_00032bc8();
    }
  }
  if (*(char *)(param_1 + 0x42) == '\0') {
    return;
  }
  return;
}



void FUN_0003245c(undefined4 param_1,int param_2,char *param_3,size_t param_4,int *param_5)

{
  int iVar1;
  int iVar2;
  undefined4 uVar3;
  int unaff_r5;
  int unaff_r6;
  size_t sStack_34;
  
  iVar1 = __stack_chk_guard;
  sStack_34 = param_4;
  iVar2 = dladdr(param_2,&sStack_34,param_3,param_4,param_3);
  if ((iVar2 == 0) || (unaff_r5 == 0)) {
    uVar3 = 0;
  }
  else {
    snprintf(param_3,param_4,"%s");
    *param_5 = param_2 - unaff_r6;
    uVar3 = 1;
  }
  if (__stack_chk_guard != iVar1) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(uVar3);
  }
  return;
}



void FUN_000324bc(undefined4 param_1,undefined4 param_2,int *param_3)

{
  int iVar1;
  int local_18;
  int local_14;
  
  local_14 = __stack_chk_guard;
  local_18 = 0;
  iVar1 = __gnu_Unwind_Find_exidx(param_2,&local_18);
  *param_3 = iVar1;
  param_3[1] = local_18;
  if (iVar1 != 0) {
    iVar1 = 1;
  }
  if (__stack_chk_guard != local_14) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail(iVar1);
  }
  return;
}



void FUN_00032500(int param_1,undefined4 param_2,int param_3)

{
  bool bVar1;
  uint *puVar2;
  uint *puVar3;
  uint uVar4;
  uint uVar5;
  uint *puVar6;
  int iVar7;
  uint uVar8;
  undefined4 uVar9;
  uint uVar10;
  code *pcVar11;
  int local_38 [2];
  int *local_30;
  undefined4 local_2c;
  int local_28;
  
  local_28 = __stack_chk_guard;
  iVar7 = *(int *)(param_3 + 4);
  local_2c = param_2;
  FUN_000326cc(local_38,0,*(undefined4 *)(param_1 + 4),param_3,iVar7,*(undefined4 *)(param_1 + 4),
               param_3,&local_2c);
  if ((local_38[0] == 0) || (local_38[0] == iVar7)) goto LAB_0003262c;
  puVar3 = (uint *)(*local_30 + local_38[0] * 8);
  puVar2 = puVar3 + -1;
  uVar4 = *puVar3;
  if ((puVar2 == (uint *)0x0) || (uVar5 = *puVar2, uVar5 == 1)) goto LAB_0003262c;
  uVar10 = puVar3[-2];
  if ((int)uVar5 < 0) {
    bVar1 = true;
LAB_000325a2:
    uVar8 = (uVar5 << 4) >> 0x1c;
    if (uVar8 == 2) {
      pcVar11 = __aeabi_unwind_cpp_pr2;
      iVar7 = 1;
    }
    else {
      if (uVar8 != 1) {
        if (uVar8 != 0) {
          uVar9 = 0x32e;
          iVar7 = 0x32660;
          goto LAB_0003267a;
        }
        puVar6 = puVar2 + 1;
        if (bVar1) {
          puVar6 = (uint *)0x0;
        }
        pcVar11 = __aeabi_unwind_cpp_pr0;
        goto LAB_000325c4;
      }
      pcVar11 = __aeabi_unwind_cpp_pr1;
      iVar7 = 0;
    }
    uVar5 = (uVar5 << 8) >> 0x18;
    if (uVar5 != 0 && !(bool)(bVar1 ^ 1)) {
      uVar9 = 0x335;
      iVar7 = 0x3267c;
LAB_0003267a:
      fprintf((FILE *)isspace,"libunwind: %s %s:%d - %s\n","getInfoFromEHABISection",
              "/usr/local/google/buildbot/src/android/ndk-release-r20/external/libcxx/../../external/libunwind_llvm/src/UnwindCursor.hpp"
              ,uVar9,iVar7 + 0x851f);
      fflush((FILE *)isspace);
                    // WARNING: Subroutine does not return
      abort();
    }
    puVar6 = puVar2 + uVar5 + 1;
  }
  else {
    uVar8 = uVar5 | (uVar5 & 0x40000000) << 1;
    uVar5 = *(uint *)(uVar8 + (int)puVar2);
    puVar2 = (uint *)((int)puVar2 + uVar8);
    if ((int)uVar5 < 0) {
      bVar1 = false;
      goto LAB_000325a2;
    }
    pcVar11 = (code *)((uVar5 | (uVar5 & 0x40000000) << 1) + (int)puVar2);
    bVar1 = false;
    puVar6 = puVar2 + 1 + (puVar2[1] >> 0x18) + 1;
LAB_000325c4:
    iVar7 = 0;
  }
  *(uint **)(param_1 + 0x178) = puVar2;
  *(uint *)(param_1 + 0x158) = (uVar10 | (uVar10 & 0x40000000) << 1) + (int)(puVar3 + -2);
  *(uint *)(param_1 + 0x15c) = (int)puVar3 + (uVar4 | (uVar4 & 0x40000000) << 1);
  *(uint **)(param_1 + 0x160) = puVar6;
  *(code **)(param_1 + 0x164) = pcVar11;
  if (iVar7 != 0) {
    iVar7 = 2;
  }
  if (bVar1) {
    iVar7 = 1;
  }
  *(int *)(param_1 + 0x16c) = iVar7;
LAB_0003262c:
  if (__stack_chk_guard - local_28 == 0) {
    return;
  }
                    // WARNING: Subroutine does not return
  __stack_chk_fail(__stack_chk_guard - local_28);
}



void FUN_000326cc(void)

{
  int iVar1;
  
  iVar1 = __stack_chk_guard;
  FUN_00032714();
  if (__stack_chk_guard != iVar1) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}



int * FUN_00032714(int *param_1,int param_2,int param_3,int *param_4,int param_5,undefined4 param_6,
                  undefined4 param_7,uint *param_8)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  uint uVar4;
  
  uVar1 = param_5 - param_2;
  while (uVar4 = uVar1, uVar4 != 0) {
    iVar2 = param_2 + (uVar4 >> 1);
    uVar3 = *(uint *)(*param_4 + iVar2 * 8);
    uVar1 = uVar4 >> 1;
    if (*param_4 + iVar2 * 8 + (uVar3 | (uVar3 & 0x40000000) << 1) <= *param_8) {
      param_2 = iVar2 + 1;
      uVar1 = uVar4 + ~(uVar4 >> 1);
    }
  }
  *param_1 = param_2;
  param_1[1] = param_3;
  param_1[2] = (int)param_4;
  return param_1 + 3;
}



undefined8 FUN_00032bc0(undefined8 *param_1)

{
  return *param_1;
}



undefined8 FUN_00032bc8(undefined8 *param_1)

{
  return *param_1;
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



uint __aeabi_idiv(uint param_1,uint param_2)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  bool bVar6;
  
  if (param_2 == 0) {
    bVar6 = (int)param_1 < 0;
    if (0 < (int)param_1) {
      param_1 = 0x7fffffff;
    }
    if (bVar6) {
      param_1 = 0x80000000;
    }
    uVar1 = __aeabi_ldiv0(param_1);
    return uVar1;
  }
  uVar5 = param_1 ^ param_2;
  uVar1 = param_2;
  if ((int)param_2 < 0) {
    uVar1 = -param_2;
  }
  if (uVar1 - 1 == 0) {
    if ((int)param_2 < 0) {
      param_1 = -param_1;
    }
    return param_1;
  }
  uVar4 = param_1;
  if ((int)param_1 < 0) {
    uVar4 = -param_1;
  }
  if (uVar4 <= uVar1) {
    if (uVar4 < uVar1) {
      param_1 = 0;
    }
    if (uVar4 == uVar1) {
      param_1 = (int)uVar5 >> 0x1f | 1;
    }
    return param_1;
  }
  if ((uVar1 & uVar1 - 1) == 0) {
    uVar4 = uVar4 >> (0x1fU - LZCOUNT(uVar1) & 0xff);
    if ((int)uVar5 < 0) {
      uVar4 = -uVar4;
    }
    return uVar4;
  }
  uVar3 = uVar1 << (LZCOUNT(uVar1) - LZCOUNT(uVar4) & 0xffU);
  uVar1 = 1 << (LZCOUNT(uVar1) - LZCOUNT(uVar4) & 0xffU);
  uVar2 = 0;
  while( true ) {
    if (uVar3 <= uVar4) {
      uVar4 = uVar4 - uVar3;
      uVar2 = uVar2 | uVar1;
    }
    if (uVar3 >> 1 <= uVar4) {
      uVar4 = uVar4 - (uVar3 >> 1);
      uVar2 = uVar2 | uVar1 >> 1;
    }
    if (uVar3 >> 2 <= uVar4) {
      uVar4 = uVar4 - (uVar3 >> 2);
      uVar2 = uVar2 | uVar1 >> 2;
    }
    if (uVar3 >> 3 <= uVar4) {
      uVar4 = uVar4 - (uVar3 >> 3);
      uVar2 = uVar2 | uVar1 >> 3;
    }
    bVar6 = uVar4 == 0;
    if (!bVar6) {
      uVar1 = uVar1 >> 4;
      bVar6 = uVar1 == 0;
    }
    if (bVar6) break;
    uVar3 = uVar3 >> 4;
  }
  if ((int)uVar5 < 0) {
    uVar2 = -uVar2;
  }
  return uVar2;
}



uint FUN_00032ca8(uint param_1,uint param_2)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  bool in_NG;
  bool bVar6;
  
  uVar5 = param_1 ^ param_2;
  uVar2 = param_2;
  if (in_NG) {
    uVar2 = -param_2;
  }
  if (uVar2 - 1 == 0) {
    if ((int)param_2 < 0) {
      param_1 = -param_1;
    }
    return param_1;
  }
  uVar4 = param_1;
  if ((int)param_1 < 0) {
    uVar4 = -param_1;
  }
  if (uVar4 <= uVar2) {
    if (uVar4 < uVar2) {
      param_1 = 0;
    }
    if (uVar4 == uVar2) {
      param_1 = (int)uVar5 >> 0x1f | 1;
    }
    return param_1;
  }
  if ((uVar2 & uVar2 - 1) == 0) {
    uVar4 = uVar4 >> (0x1fU - LZCOUNT(uVar2) & 0xff);
    if ((int)uVar5 < 0) {
      uVar4 = -uVar4;
    }
    return uVar4;
  }
  uVar3 = uVar2 << (LZCOUNT(uVar2) - LZCOUNT(uVar4) & 0xffU);
  uVar2 = 1 << (LZCOUNT(uVar2) - LZCOUNT(uVar4) & 0xffU);
  uVar1 = 0;
  while( true ) {
    if (uVar3 <= uVar4) {
      uVar4 = uVar4 - uVar3;
      uVar1 = uVar1 | uVar2;
    }
    if (uVar3 >> 1 <= uVar4) {
      uVar4 = uVar4 - (uVar3 >> 1);
      uVar1 = uVar1 | uVar2 >> 1;
    }
    if (uVar3 >> 2 <= uVar4) {
      uVar4 = uVar4 - (uVar3 >> 2);
      uVar1 = uVar1 | uVar2 >> 2;
    }
    if (uVar3 >> 3 <= uVar4) {
      uVar4 = uVar4 - (uVar3 >> 3);
      uVar1 = uVar1 | uVar2 >> 3;
    }
    bVar6 = uVar4 == 0;
    if (!bVar6) {
      uVar2 = uVar2 >> 4;
      bVar6 = uVar2 == 0;
    }
    if (bVar6) break;
    uVar3 = uVar3 >> 4;
  }
  if ((int)uVar5 < 0) {
    uVar1 = -uVar1;
  }
  return uVar1;
}



void __aeabi_idivmod(int param_1,int param_2)

{
  bool bVar1;
  
  if (param_2 != 0) {
    FUN_00032ca8();
    return;
  }
  bVar1 = param_1 < 0;
  if (0 < param_1) {
    param_1 = 0x7fffffff;
  }
  if (bVar1) {
    param_1 = -0x80000000;
  }
  __aeabi_ldiv0(param_1);
  return;
}



void __aeabi_uldivmod(int param_1,int param_2,int param_3,int param_4)

{
  if (param_4 != 0 || param_3 != 0) {
    __gnu_uldivmod_helper();
    return;
  }
  if (param_2 != 0 || param_1 != 0) {
    param_2 = -1;
    param_1 = -1;
  }
  __aeabi_ldiv0(param_1,param_2);
  return;
}



void __aeabi_ldiv0(void)

{
  raise(8);
  return;
}



void __gnu_ldivmod_helper
               (uint param_1,int param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  uint uVar1;
  longlong lVar2;
  
  lVar2 = __divdi3();
  lVar2 = lVar2 * CONCAT44(param_4,param_3);
  uVar1 = (uint)lVar2;
  *param_5 = param_1 - uVar1;
  param_5[1] = param_2 - ((int)((ulonglong)lVar2 >> 0x20) + (uint)(param_1 < uVar1));
  return;
}



void __gnu_uldivmod_helper
               (uint param_1,int param_2,undefined4 param_3,undefined4 param_4,int *param_5)

{
  uint uVar1;
  longlong lVar2;
  
  lVar2 = __udivdi3();
  lVar2 = lVar2 * CONCAT44(param_4,param_3);
  uVar1 = (uint)lVar2;
  *param_5 = param_1 - uVar1;
  param_5[1] = param_2 - ((int)((ulonglong)lVar2 >> 0x20) + (uint)(param_1 < uVar1));
  return;
}



undefined4 FUN_00032e60(void)

{
  return 1;
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



void FUN_00032e84(int *param_1)

{
  int iVar1;
  int *piVar2;
  int iVar3;
  
  if (*param_1 != 0) {
    *param_1 = *param_1 + -1;
    pthread_setspecific(DAT_0006329c,param_1);
    return;
  }
  piVar2 = param_1 + 1;
  iVar3 = *piVar2;
  for (iVar1 = 0; iVar1 != iVar3; iVar1 = iVar1 + 1) {
    piVar2 = piVar2 + 1;
    if (*piVar2 != 0) {
      free(*(void **)(*piVar2 + -4));
    }
  }
  free(param_1);
  return;
}



void * FUN_00032eec(size_t *param_1)

{
  void *pvVar1;
  void *pvVar2;
  uint uVar3;
  
  uVar3 = param_1[1];
  if (uVar3 < 5) {
    pvVar1 = malloc(*param_1 + 4);
    if (pvVar1 != (void *)0x0) {
      *(void **)pvVar1 = pvVar1;
      pvVar1 = (void *)((int)pvVar1 + 4);
LAB_00032f48:
      if ((void *)param_1[3] == (void *)0x0) {
        memset(pvVar1,0,*param_1);
      }
      else {
        memcpy(pvVar1,(void *)param_1[3],*param_1);
      }
      return pvVar1;
    }
  }
  else {
    pvVar2 = malloc(uVar3 + *param_1 + 3);
    if (pvVar2 != (void *)0x0) {
      pvVar1 = (void *)((int)pvVar2 + uVar3 + 3 & -uVar3);
      *(void **)((int)pvVar1 - 4) = pvVar2;
      goto LAB_00032f48;
    }
  }
                    // WARNING: Subroutine does not return
  abort();
}



void FUN_00032f70(void)

{
  int iVar1;
  
  iVar1 = FUN_00032e60();
  if (iVar1 == 0) {
    return;
  }
  pthread_mutex_unlock((pthread_mutex_t *)&DAT_000632a0);
  return;
}



void FUN_00032f98(void)

{
  int iVar1;
  
  iVar1 = FUN_00032e60();
  if (iVar1 == 0) {
    return;
  }
  pthread_mutex_lock((pthread_mutex_t *)&DAT_000632a0);
  return;
}



void FUN_00032fc0(void)

{
  pthread_key_create(&DAT_0006329c,FUN_00032e84);
  return;
}



void FUN_00032fdc(void)

{
  int iVar1;
  
  iVar1 = FUN_00032fc0();
  if (iVar1 != 0) {
                    // WARNING: Subroutine does not return
    abort();
  }
  DAT_000632a4 = 1;
  return;
}



int FUN_00033008(void)

{
  int iVar1;
  
  iVar1 = FUN_00032e60();
  if (iVar1 != 0) {
    iVar1 = pthread_once((pthread_once_t *)&DAT_000632a8,FUN_00032fdc);
    return iVar1;
  }
  return -1;
}



void FUN_00033044(void)

{
  if (DAT_000632a4 == 0) {
    return;
  }
  DAT_000632a4 = 0;
  pthread_key_delete(DAT_0006329c);
  return;
}



int __emutls_get_address(int param_1)

{
  int iVar1;
  undefined4 uVar2;
  undefined4 *__ptr;
  pthread_key_t __key;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  
  iVar1 = FUN_00032e60();
  if (iVar1 == 0) {
    if (*(int *)(param_1 + 8) == 0) {
      uVar2 = FUN_00032eec(param_1);
      *(undefined4 *)(param_1 + 8) = uVar2;
    }
    return *(int *)(param_1 + 8);
  }
  uVar3 = *(uint *)(param_1 + 8);
  DataMemoryBarrier(0xf);
  if (uVar3 == 0) {
    FUN_00033008();
    FUN_00032f98();
    uVar3 = *(uint *)(param_1 + 8);
    if (uVar3 == 0) {
      uVar3 = DAT_000632ac + 1;
      DataMemoryBarrier(0xf);
      DAT_000632ac = uVar3;
      *(uint *)(param_1 + 8) = uVar3;
    }
    FUN_00032f70();
  }
  __ptr = (undefined4 *)pthread_getspecific(DAT_0006329c);
  if (__ptr == (undefined4 *)0x0) {
    __ptr = (undefined4 *)calloc(uVar3 + 0x22,4);
    __key = DAT_0006329c;
    if (__ptr == (undefined4 *)0x0) {
LAB_00033114:
                    // WARNING: Subroutine does not return
      abort();
    }
    *__ptr = 1;
    __ptr[1] = uVar3 + 0x20;
  }
  else {
    uVar5 = __ptr[1];
    if (uVar3 <= uVar5) goto LAB_00033184;
    uVar4 = uVar5 * 2;
    if (uVar4 < uVar3) {
      uVar4 = uVar3 + 0x20;
    }
    __ptr = (undefined4 *)realloc(__ptr,(uVar4 + 2) * 4);
    if (__ptr == (undefined4 *)0x0) goto LAB_00033114;
    __ptr[1] = uVar4;
    memset(__ptr + uVar5 + 2,0,(uVar4 - uVar5) * 4);
    __key = DAT_0006329c;
  }
  pthread_setspecific(__key,__ptr);
LAB_00033184:
  if (__ptr[uVar3 + 1] != 0) {
    return __ptr[uVar3 + 1];
  }
  iVar1 = FUN_00032eec(param_1);
  __ptr[uVar3 + 1] = iVar1;
  return iVar1;
}



void __emutls_register_common(uint *param_1,uint param_2,uint param_3,uint param_4)

{
  if (*param_1 < param_2) {
    *param_1 = param_2;
    param_1[3] = 0;
  }
  if (param_1[1] < param_3) {
    param_1[1] = param_3;
  }
  if (param_4 != 0) {
    if (param_2 == *param_1) {
      param_1[3] = param_4;
    }
    return;
  }
  return;
}



undefined8 __divdi3(uint param_1,uint param_2,uint param_3,uint param_4)

{
  uint uVar1;
  uint uVar2;
  int iVar3;
  uint uVar4;
  int iVar5;
  uint uVar6;
  uint uVar7;
  bool bVar8;
  bool bVar9;
  undefined8 uVar10;
  longlong lVar11;
  int iVar12;
  
  if ((int)param_2 < 0) {
    uVar4 = -param_1;
    uVar6 = 0xffffffff;
    param_2 = -(param_2 + (param_1 != 0));
  }
  else {
    uVar6 = 0;
    uVar4 = param_1;
  }
  uVar7 = param_3;
  if ((int)param_4 < 0) {
    uVar7 = -param_3;
    uVar6 = ~uVar6;
    param_4 = -(param_4 + (param_3 != 0));
  }
  bVar9 = param_2 <= param_4;
  bVar8 = param_4 != param_2;
  if (!bVar8) {
    bVar9 = uVar4 <= uVar7;
  }
  uVar2 = param_4;
  uVar1 = uVar7;
  if (bVar9 && (bVar8 || uVar7 != uVar4)) {
    uVar1 = 0;
    uVar2 = 0;
  }
  lVar11 = CONCAT44(uVar2,uVar1);
  if (!bVar9 || !bVar8 && uVar7 == uVar4) {
    if (param_4 == 0) {
      iVar5 = LZCOUNT(uVar7) + 0x20;
    }
    else {
      iVar5 = LZCOUNT(param_4);
    }
    if (param_2 == 0) {
      iVar3 = LZCOUNT(uVar4) + 0x20;
    }
    else {
      iVar3 = LZCOUNT(param_2);
    }
    iVar5 = iVar5 - iVar3;
    iVar12 = iVar5;
    uVar10 = __aeabi_llsl(uVar7,param_4,iVar5,iVar3,param_1,iVar5,param_3);
    uVar7 = (uint)((ulonglong)uVar10 >> 0x20);
    uVar1 = (uint)uVar10;
    bVar9 = uVar7 <= param_2;
    if (param_2 == uVar7) {
      bVar9 = uVar1 <= uVar4;
    }
    if (bVar9) {
      bVar9 = uVar4 < uVar1;
      uVar4 = uVar4 - uVar1;
      param_2 = param_2 - (uVar7 + bVar9);
      lVar11 = __aeabi_llsl(1,0,iVar5);
    }
    else {
      lVar11 = 0;
    }
    if (iVar5 != 0) {
      uVar7 = uVar7 >> 1;
      uVar1 = (uint)((byte)((ulonglong)uVar10 >> 0x20) & 1) << 0x1f | uVar1 >> 1;
      do {
        uVar2 = uVar4 - uVar1;
        iVar3 = param_2 - (uVar7 + (uVar4 < uVar1));
        bVar9 = uVar7 <= param_2;
        if (param_2 == uVar7) {
          bVar9 = uVar1 <= uVar4;
        }
        param_2 = param_2 * 2 + (uint)CARRY4(uVar4,uVar4);
        uVar4 = uVar4 * 2;
        if (bVar9) {
          param_2 = iVar3 * 2 + (uint)CARRY4(uVar2,uVar2) + (uint)(0xfffffffe < uVar2 * 2);
          uVar4 = uVar2 * 2 + 1;
        }
        iVar5 = iVar5 + -1;
      } while (iVar5 != 0);
      lVar11 = lVar11 + CONCAT44(param_2,uVar4);
      uVar7 = (uint)lVar11;
      uVar10 = __aeabi_llsr(uVar4,param_2,iVar12);
      uVar10 = __aeabi_llsl((int)uVar10,(int)((ulonglong)uVar10 >> 0x20),iVar12);
      lVar11 = CONCAT44((int)((ulonglong)lVar11 >> 0x20) -
                        ((int)((ulonglong)uVar10 >> 0x20) + (uint)(uVar7 < (uint)uVar10)),
                        uVar7 - (uint)uVar10);
    }
  }
  if (uVar6 != 0) {
    uVar6 = 1;
  }
  uVar4 = (uint)lVar11 ^ -uVar6;
  return CONCAT44(((uint)((ulonglong)lVar11 >> 0x20) ^ -(uint)(uVar6 != 0)) +
                  (uint)CARRY4(uVar6,uVar4),uVar6 + uVar4);
}



int __udivdi3(uint param_1,uint param_2,uint param_3,uint param_4)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  int iVar4;
  uint uVar5;
  int iVar6;
  int iVar7;
  uint uVar8;
  bool bVar9;
  bool bVar10;
  undefined8 uVar11;
  
  bVar9 = param_2 <= param_4;
  if (param_4 == param_2) {
    bVar9 = param_1 <= param_3;
  }
  if (bVar9 && (param_4 != param_2 || param_3 != param_1)) {
    return 0;
  }
  if (param_4 == 0) {
    iVar6 = LZCOUNT(param_3) + 0x20;
  }
  else {
    iVar6 = LZCOUNT(param_4);
  }
  if (param_2 == 0) {
    iVar4 = LZCOUNT(param_1) + 0x20;
  }
  else {
    iVar4 = LZCOUNT(param_2);
  }
  iVar6 = iVar6 - iVar4;
  uVar11 = __aeabi_llsl(param_3,param_4,iVar6,param_4,param_4);
  uVar5 = (uint)((ulonglong)uVar11 >> 0x20);
  uVar3 = (uint)uVar11;
  bVar9 = uVar5 <= param_2;
  if (param_2 == uVar5) {
    bVar9 = uVar3 <= param_1;
  }
  if (bVar9) {
    bVar9 = param_1 < uVar3;
    param_1 = param_1 - uVar3;
    param_2 = param_2 - (uVar5 + bVar9);
    iVar4 = __aeabi_llsl(1,0,iVar6);
  }
  else {
    iVar4 = 0;
  }
  if (iVar6 != 0) {
    uVar5 = uVar5 >> 1;
    uVar3 = (uint)((byte)((ulonglong)uVar11 >> 0x20) & 1) << 0x1f | uVar3 >> 1;
    iVar7 = iVar6;
    do {
      uVar8 = param_1 - uVar3;
      bVar10 = CARRY4(param_1,param_1);
      uVar1 = param_1 * 2;
      iVar2 = param_2 * 2;
      bVar9 = uVar5 <= param_2;
      if (param_2 == uVar5) {
        bVar9 = uVar3 <= param_1;
      }
      param_2 = (param_2 - (uVar5 + (param_1 < uVar3))) * 2 + (uint)CARRY4(uVar8,uVar8) +
                (uint)(0xfffffffe < uVar8 * 2);
      param_1 = uVar8 * 2 + 1;
      if (!bVar9) {
        param_2 = iVar2 + (uint)bVar10;
        param_1 = uVar1;
      }
      iVar7 = iVar7 + -1;
    } while (iVar7 != 0);
    uVar11 = __aeabi_llsr(param_1,param_2,iVar6);
    iVar6 = __aeabi_llsl((int)uVar11,(int)((ulonglong)uVar11 >> 0x20),iVar6);
    return (param_1 + iVar4) - iVar6;
  }
  return iVar4;
}



undefined8 __aeabi_llsr(uint param_1,uint param_2,uint param_3)

{
  uint uVar1;
  
  if ((int)(param_3 - 0x20) < 0) {
    uVar1 = param_1 >> (param_3 & 0xff) | param_2 << (0x20 - param_3 & 0xff);
  }
  else {
    uVar1 = param_2 >> (param_3 - 0x20 & 0xff);
  }
  return CONCAT44(param_2 >> (param_3 & 0xff),uVar1);
}



undefined8 __aeabi_llsl(uint param_1,int param_2,uint param_3)

{
  uint uVar1;
  
  if ((int)(param_3 - 0x20) < 0) {
    uVar1 = param_2 << (param_3 & 0xff) | param_1 >> (0x20 - param_3 & 0xff);
  }
  else {
    uVar1 = param_1 << (param_3 - 0x20 & 0xff);
  }
  return CONCAT44(uVar1,param_1 << (param_3 & 0xff));
}


