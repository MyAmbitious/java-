package com.alex.jvm.others;
/**
 * 所有的java虚拟机实现必须在每个类或接口被java程序“首次主动使用”时才初始化他们
 * 主动使用的七中情况
 * 1 创建类的实例
 * 2 访问某个类或者接口的静态变量，或者对该静态变量赋值
 * 3 调用类的静态方法
 * 4 反射
 * 5 初始化一个类的子类
 * 6 java虚拟机启动时被标明为启用类的类 main JavaTest
 * 7 jdk1.7 开始提供的动态语言支持：
 * java.lang.invoke.MethodHandle实例的解析结果REF_getStatic,REF_putStatic,
 * REF_invokeStatic句柄对应的类没有初始化 则初始化
 */

/**
 * 链接：https://www.nowcoder.com/discuss/226834
 * <p>
 * <p>
 * 9. 静态变量和静态代码块的执行顺序？
 * <p>
 * 答：静态变量先于静态代码块执行，整个执行顺序是：
 * <p>
 * 附：父类静态变量初始化---》父类静态代码块-------》子类静态变量初始化------》子类静态语句块--------》父类变量初始化----------》
 * 父类代码块----------》父类构造函数 ------》子类变量初始化--------》子类语句块----------》子类构造函数；
 */
class CodeZY {
    //jvm语法规定 new出来的对象的执行顺序 静态变量>静态代码块>构造代码块>构造方法
    public static int a = 20;

    public CodeZY() {
        System.out.println("Code的构造方法111");
    }

    {
        System.out.println("Code的构造块222");
    }

    static {
        System.out.println("Code的静态代码块333执行,静态变量a的值已经完成了初始化，a=" + a);
    }
}

public class CodeBlockTest {
    //构造方法和构造代码块 只会在new对象的时候执行
    {
        System.out.println("CodeBlockTest的构造块444");
    }

    static {
        System.out.println("CodeBlockTest的静态代码块555");
    }

    public CodeBlockTest() {
        System.out.println("CodeBlockTest的构造方法666");
    }

    public static void main(String[] args) {
        //555 777 444 666 333 222 111 222 111 444 666
        System.out.println("CodeBlockTest的main方法 777");
        new CodeZY();
        System.out.println("================");
        new CodeZY();
        System.out.println("===============");
        new CodeBlockTest();//CodeBlockTest方法初始化
    }

    /**
     * CodeBlockTest的静态代码块555
     * CodeBlockTest的main方法 777
     * Code的静态代码块333执行,静态变量a的值已经完成了初始化，a=20
     * Code的构造块222
     * Code的构造方法111
     * ================
     * Code的构造块222
     * Code的构造方法111
     * ===============
     * CodeBlockTest的构造块444
     * CodeBlockTest的构造方法666
     */
}
