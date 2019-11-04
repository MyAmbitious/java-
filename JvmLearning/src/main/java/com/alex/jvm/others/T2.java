package com.alex.jvm.others;
//jvm参数调优 分配最小最大的内存 并打印出分配内存的具体信息
//-Xms1024m -Xmx1024m -XX:+PrintGCDetails

/**
 * -Xmx:MAX_MEMORY=1029177344:(字节),981.5MB
 * -Xms:TotalMemory=1029177344:(字节),981.5MB
 * Heap
 *  PSYoungGen      total 305664K, used 20971K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 262144K, 8% used [0x00000000eab00000,0x00000000ebf7afb8,0x00000000fab00000)
 *   from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
 *   to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
 *  ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
 *   object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
 *  Metaspace       used 3217K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 346K, capacity 388K, committed 512K, reserved 1048576K
 */
public class T2 {
    public static void main(String[] args) {
        // 获取本机的cpu逻辑核数 4
        // System.out.println(Runtime.getRuntime().availableProcessors());
        final long maxMemory = Runtime.getRuntime().maxMemory();
        final long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx:MAX_MEMORY="+maxMemory+":(字节),"+(maxMemory/(double)1024/1024)+"MB");//最大 MAX_MEMORY=5702680576:(字节),5438.5MB
        System.out.println("-Xms:TotalMemory="+maxMemory+":(字节),"+(totalMemory/(double)1024/1024)+"MB");//最小 totalMemory=5702680576:(字节),368.0MB
    }
}
