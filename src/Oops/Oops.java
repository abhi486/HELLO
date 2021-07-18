package Oops;

import Oops.models.A;
import Oops.models.A.B;
import Oops.models.A.C;

public class Oops {

    static {
        System.out.println("in Block 1");
    }
    static {
        System.out.println("in Block 2");
    }
    public static void main(String[] args) {
        A a = new A();
        B b = a.new B();
        C c = new A.C();
        System.out.println("main");
    }
    static {
        System.out.println("in Block 3");
    }
}
