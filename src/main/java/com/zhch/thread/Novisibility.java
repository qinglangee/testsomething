package com.zhch.thread;

public class Novisibility {  
    private static boolean ready;  
    private static int     number;  
   
    private static class ReaderThread extends Thread {  
        public void run() {  
            while (!ready) {  
                Thread.yield();  
            }  
            System.out.println(number);  
        }  
    }
   /*
    * java -server Novisibility  // 服务器模式运行, 输出0
    * java -d32 Novisibility  // 32位机器上单机模式运行, 输出42
    * java -d64 Novisibility  // 64位机器上单机模式运行, 输出42
    * 实际运行没见到输出0的, 输出0是因为JIT优化代码, 可是没见到
    */
    public static void main(String[] args) {  
        new ReaderThread().start();  
        number = 42;  
        ready = true;  
    }
}  
