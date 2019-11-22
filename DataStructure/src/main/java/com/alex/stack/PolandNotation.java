package com.alex.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//后缀表达式 也就是逆波兰表达式
public class PolandNotation {


    public static void main(String[] args) {

        //java实现中缀表达式转换成后缀表达式
        //具体要求 1+((2+3)×4)-5 >= 1 2 3 + 4 × + 5 –

        /**
         * 具体步骤如下:
         * 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
         * 从左至右扫描中缀表达式；
         * 遇到操作数时，将其压s2；
         * 遇到运算符时，比较其与s1栈顶运算符的优先级：
         * 如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
         * 否则，若优先级比栈顶运算符的高，也将运算符压入s1；
         * 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
         * 遇到括号时：  (1) 如果是左括号“(”，则直接压入s1 (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
         * 重复步骤2至5，直到表达式的最右边
         * 将s1中剩余的运算符依次弹出并压入s2
         * 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
         *
         */
        //先定义一个中缀表达式
        String expression = "1+((2+3)×4)-5";
        final List<String> listString = toInfixExpressionList(expression);
        System.out.println("中缀表达式为："+listString);
        final List<String> suffixExpressionList = parseSuffixExpressionList(listString);
        System.out.println("其对应的后缀表达式为："+suffixExpressionList);
        int result = calculate(suffixExpressionList);//16
        System.out.println(suffixExpressionList + "= " + result);
        //
        // //    先定义一个逆波兰表达式
        // //   (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 -
        // String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";//76
        // List<String> rpnList = getListString(suffixExpression);
        // int result = calculate(rpnList);
        // System.out.println(suffixExpression + "= " + result);
    }


    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        //因为s2这个栈在整个转换过程中 没有pop操作 而且后面我们还需要逆序输出 我们可以直接使用ArrayList代替
        List<String> s2 = new ArrayList<>();
        for (String str : ls) {
            if (str.equals("(")) {
                s1.push(str);
            } else if (str.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.empty() && !s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将左小括号弹出 消除小括号
            } else if (str.matches("\\d+")) {
                //数字则直接加入到s2中
                s2.add(str);
            } else {
                //当str的优先级小于等于s1栈顶运算符的优先级是 将s1栈顶的运算符弹出并加入到s2中  并且str再次和s1中栈顶操作符的优先级进行比较
                while (!s1.empty() && priority(str) <= priority(s1.peek())) {
                    s2.add(s1.pop());
                }
                //  循环结束后 还需要将str压入栈中
                s1.push(str);
            }
        }
        //将s1中剩余的运算符一次弹出并加入到s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static List<String> toInfixExpressionList(String s) {
        //    定义一个List,存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int index = 0;//用于遍历中缀表达式字符串的指针 用于遍历中缀表达式字符串
        StringBuilder str;
        char c;
        do {
            //如果c是一个非数字 则直接加入到ls中
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
                ls.add(String.valueOf(c));
                index++;
            } else {//如果是数字 则需要考虑多位数的情况
                str = new StringBuilder(); //asill码 '0'[48] '9'[57]
                while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57) {
                    str.append(c);
                    index++;
                }
                ls.add(str.toString());
            }
        } while (index < s.length());
        return ls;
    }

    //返回运算符的优先级别 数字越大 则优先级就越高
    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/")||oper.equals("×") ) {
            return 1;
        } else if (oper.equals("+") || oper.equals("-")) {
            return 0;
        } else {
            return -1;
        }
    }

    public static List<String> getListString(String suffixExpression) {
        //    将suffixExpression分割 转换成List返回
        return Arrays.asList(suffixExpression.split(" "));

    }

    //    完成对逆波兰表达式的运算
    //从左至右扫描，将3和4压入堆栈；
    // 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
    // 将5入栈；
    // 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
    // 将6入栈；
    // 最后是-运算符，计算出35-6的值，即29，由此得出最终结果
    public static int calculate(List<String> ls) {
        Stack<Integer> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        for (String str : ls) {

            if (!stack.empty() && isOper(str)) {
                stack.push(cal(stack.pop(), stack.pop(), str));
            } else if (str.matches("\\d+")) {//匹配的是多位数
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static boolean isOper(String s) {
        return s.equals("×") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("*");
    }

    public static int cal(int num1, int num2, String oper) {
        int res = 0;
        switch (oper) {
            case "×":
                res = num1 * num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num2 - num1;
                break;
            case "/":
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
