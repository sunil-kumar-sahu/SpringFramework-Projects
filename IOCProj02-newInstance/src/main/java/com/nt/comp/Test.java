//Test.java
package com.nt.comp;

public class Test {

		private int a=10;
		private String b="hello";
		public Test() {
			System.out.println("Test::0-param constructor");
		}
		
		public Test(int a,String b) {
			System.out.println("Test::2-param constructor");
			this.a=a;
			this.b=b;
		}
		@Override
		public String toString() {
			return "Test[a=" +a+ ",b="+b+"]";
		}

}
