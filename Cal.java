import java.util.Scanner;

public class Cal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("input a number please");
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        String[] digit = Cal.return_digit(num);
        String res = Cal.multiplys(digit[0],"1");
        for(int i=1; i<digit.length;i++) {
            res = Cal.multiplys(res,digit[i]);
        }
        System.out.println("the digit product is" + res);
    }
    public static String[] return_digit(String num){
        String[] result = new String[num.length()];
        for( int i=0; i<num.length();i++){
            result[i] = String.valueOf(num.charAt(i));
        }
        return result;
    }

    public static String multiplys(String num1,String num2){
        int len1 = num1.length();
        int len = len1 + 1;
        int[] mul = new int[len];
        for(int i=len1-1;i>=0;i--){
            int a = num1.charAt(i) - '0';
            int k = 1 + i;
            int b = num2.charAt(0) - '0';
            int temp = mul[k] + a * b;
            mul[k] = temp % 10;
            mul[k - 1] = mul[k - 1] + temp / 10;
            k--;
        }
        int i = 0;
        while(i<len-1 && mul[i] == 0){
            i++;
        }
        StringBuffer sbuffer = new StringBuffer();
        for(;i<len;i++){
            sbuffer.append(mul[i]);
        }
        return sbuffer.toString();
    }


}