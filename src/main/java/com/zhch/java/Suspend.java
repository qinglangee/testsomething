package com.zhch.java;

public class Suspend extends Thread {
    @Override
    public void run() {
        synchronized ( this ) {
        while ( true )
        ;
        }
    }


    public static void main(String[] args) {
        Thread thread = new Suspend();
        thread.start();


        try {
        sleep( 1000 );
        } catch (InterruptedException e) {
        }


        thread.suspend();


        synchronized (thread) { // dead lock
        System.out.println( "got the lock" );
        thread.resume();
        }
    }
}

