package regex_practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    1、"\"   转义字符
    2、"^"   匹配字符串开始位置
    3、"$"   匹配字符串结束位置
    4、"*"   匹配前面一个子表达式任意次数：0次～无穷次
    5、"+"   匹配前面一个子表达式至少1次： 1次～无穷次
    6、"?"   匹配前面一个子表达式0次或1次：0次～1次
    7、"{n}"     匹配前面一个子表达式n次
    8、"{n,m}"   匹配前面一个子表达式n次～m次
    9、"{n,}"    匹配前面一个子表达式至少n次
    10、"{,m}"   匹配前面一个子表达式至多m次
    11、"?"      当该字符跟在其他限制字符（*,+,?,{n},{n,m},{n,},{,m}）后面时，代表惰性匹配，尽可能少匹配
    12、"*"      当该字符跟在其他限制字符（*,+,?,{n},{n,m},{n,},{,m}）后面时，代表贪婪匹配，满足条件都会匹配
    13、"."      除开"\r\n"外的任意单个字符
    14、"(pattern)"      匹配pattern并捕获子表达式，可以用$0...$9从匹配集合中进行检索
    15、"(?:pattern)"    匹配pattern但不捕获子表达式，example：'industr?:y|ies'<==>'industry|industries'
    16、"(?=pattern)"    执行正向预测先行搜索的子表达式，非捕获匹配。example： 'windows (?=95|98|NT|2000)'可以匹配windows 2000中的windows，但不能匹配windows 3.6中的windows
    17、"（?!=pattern）" 执行反向预测先行搜索的子表达式，非捕获匹配。example：'windows (!=95|98|NT|2000)'可以匹配windows 3.6中的windows，但不能匹配windows 2000中的windows
    18、"x|y"    匹配“x”或“y”，如'(b|t)ag'匹配“bag”或者“tag”
    19、"[xyz]"  匹配“x、y、z”中的任意一个
    20、"[^xyz]" 匹配除“x、y、z”的任意字符，如[^abc]匹配“frame”中的“f”、“r”、“m”、“e”
    21、"[a-z]"
    22、"[A-Z]"
    23、"[0-9]"
    24、"[a-zA-Z0-9]"
    25、"\b"     匹配一个单词边界，如'er\b'匹配“never”中的“er”，但不匹配“verb”中的“er”
    26、"\B"     匹配非单词边界，如'er\B'匹配“verb”中的“er”，但不匹配“never”中的“er”
    27、"\d"     数字匹配，等价于'[0-9]'
    28、"\D"     非数字匹配，等价于'[^0-9]'
    29、"\w"     匹配任何字类字符(包括下划线)，等价于'[A-Za-z0-9_]'
    30、"\W"     匹配任何非字类字符，等价于'[^A-Za-z0-9_]'
    31、"\s"     匹配任何不可见字符，包括空格、制表符、换页符等，等价于'[ \f\r\n\t\v]'
    32、"\S"     匹配任何可见字符，等价于'[^ \f\r\n\t\v]'
    33、"\f"     匹配换页符
    34、"\r"     匹配回车
    35、"\n"     匹配换行
    36、"\t"     匹配制表符
    37、"\v"     匹配垂直制表符
    38、"\cx"    匹配x指示的控制字符，如'\cM'匹配control-M或回车键；注意x需在a-z或A-Z范围内，否则“c”的含义就是字符本身
    39、"\num"   把前面的捕获引用num次，注意：“num”为正整数。example：如'(.)\2'匹配2个连续的相同字符
    40、"\nm"
    41、"\\un"    匹配十六进制"n"，如\\u00A
    */
    /*
    【问题描述】小明对类似于 hello 这种单词非常感兴趣，这种单词可以正好分为四段，第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no。元音字母包括 a, e, i, o, u，共五个，其他均为辅音字母。
    【输入格式】输入一行，包含一个单词，单词中只包含小写英文字母。
    【输出格式】输出答案，或者为yes，或者为no。
    【样例输入】lanqiao
    【样例输出】yes
    【样例输入】world
    【样例输出】no
    【评测用例规模与约定】对于所有评测用例，单词中的字母个数不超过100。
    */
public class Regex_Basic {
    Scanner sc = new Scanner(System.in);
    String[]  words = new String[3];

    public void getArray(){
        for (int i = 0; i < words.length; i++) {
            System.out.println("请输入第"+(i+1)+"个字符串");
            words[i] = sc.next();
        }
    }

    public void regex(){
        String re = "^([^aeiou]+)([aeiou]+)([^aeiou]+)([aeiou]+)$";
        Pattern par = Pattern.compile(re);
        for (int i = 0; i < words.length; i++) {
            Matcher  ma = par.matcher(words[i]);
            System.out.println(ma.find());
            System.out.println(ma.start());
            System.out.println(ma.end());
            System.out.println(ma.group(0));
        }
    }

    public static void main(String[] args) {
//        Regex_Basic re = new Regex_Basic();
//        re.getArray();
//        re.regex();
//        System.out.print("a\rb\nc\r\nd");
        System.out.println("ab\ncd");
        System.out.println("ab\rcd");
        System.out.println("ab\r\ncd");
    }
}
