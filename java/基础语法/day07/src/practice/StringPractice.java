package practice;

public class StringPractice {
    public static void main(String[] args) {
        System.out.println(new StringPractice().myTrim(" \the  pp \n  "));
    }

    // 去除字符串的前后空白字符
    public String myTrim(String str){
        if (str.length() == 0) {
            return "";
        }
        boolean pre = false;
        boolean back = false;
        int i, j;
        for(i = 0, j = str.length() - 1; i < str.length() && j > 0;) {
            if (!pre && (str.charAt(i) == ' ' || str.charAt(i) == '\t'|| str.charAt(i) == '\n')) {
                i++;
            } else {
                pre = true;
            }
            if(!back && (str.charAt(j) == ' ' || str.charAt(j) == '\t'|| str.charAt(j) == '\n')) {
                j--;
            } else {
                back = true;
            }
            if(pre && back) {
                break;
            }
        }
        if (Math.abs(i - j) == 1) return "";
        return str.substring(i, j);
    }
}
