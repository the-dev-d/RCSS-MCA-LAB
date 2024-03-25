interface P {
    int CONSTANT_P = 10;
    void methodP();
}

interface P1 extends P {
    int CONSTANT_P1 = 20;
    void methodP1();
}

interface P2 extends P {
    int CONSTANT_P2 = 30;
    void methodP2();
}

interface P12 extends P1, P2 {
    int CONSTANT_P12 = 40;
    void commonMethod();
}

class Q implements P12 {
    public void methodP() {
        System.out.println("MethodP invoked. Constant from P: " + CONSTANT_P);
    }

    public void methodP1() {
        System.out.println("MethodP1 invoked. Constant from P1: " + CONSTANT_P1);
    }

    public void methodP2() {
        System.out.println("MethodP2 invoked. Constant from P2: " + CONSTANT_P2);
    }

    public void commonMethod() {
        System.out.println("CommonMethod invoked. Constant from P12: " + CONSTANT_P12);
    }
}

class Main {
    public static void main(String[] args) {
        Q q = new Q();
        q.methodP();
        q.methodP1();
        q.methodP2();
        q.commonMethod();
    }
}

