package com.valid;

import org.junit.jupiter.api.Test;

public class Main {
   private static final int n = 10;
   @Test
   void testFib0() {
      System.out.println(Fib.fib0(n));
   }

   @Test
   void testFib1() {
      System.out.println(Fib.fib1(n));
   }

   @Test
   void testFib2() {
      System.out.println(Fib.fib2(n));
   }

   @Test
   void testFib3() {
      System.out.println(Fib.fib3(n));
   }

   @Test
   void testHanoi() {
      Hanoi.hanoi(3, "A", "B", "C");
   }

   @Test
   void testTaliCall() {
      System.out.println(TailCall.fac(4));;
   }
}
