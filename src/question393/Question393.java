package question393;

import java.net.Socket;

/**
 * @author Dell
 */
public class Question393 {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.validUtf8(new int[]{228,189,160,229,165,189,13,10});
        System.out.println(b);
    }
}

class Solution {
    public boolean validUtf8(int[] data) {
        int index = 0;
        int n = data.length;
        StringBuffer[] binary = new StringBuffer[n];
        for(int i = 0; i < n; i++){
            binary[i] = new StringBuffer(Integer.toBinaryString(data[i]));
            while(binary[i].length() < 8){
                binary[i].insert(0, "0");
            }
            System.out.println(binary[i]);
        }
        if(n == 1){
            if(binary[0].charAt(0) == '0'){
                //System.out.println(1);
                return true;
            }else{
                //System.out.println(2);
                return false;
            }
        }else{
            while(index < n){
                int i = 0;
                System.out.println(index);
                for(; i < binary[index].length(); i++){
                    if(binary[index].charAt(i) != '1'){
                        break;
                    }
                }
                if(i > 4){
                    //System.out.println(false);
                    return false;
                }
                //binary[index]总共包含的“1”的个数为i个,后面跟随i - 1个开头为“10”的字符
                System.out.println(i);
                while(i - 1 > 0){
                    //System.out.println(index);
                    if(index == n - 1){
                        return false;
                    }
                    if(!"10".equals(binary[++index].toString().substring(0, 2))){
                        return false;
                    }
                    i--;
                }
                //针对单个“10”打头的字符，返回false
                if(index < n - 1 && "10".equals(binary[++index].toString().substring(0, 2))){
                    //System.out.println(binary[index].toString().substring(0, 2));
                    return false;
                }
                //++index;
            }
        }
        return true;
    }
}
