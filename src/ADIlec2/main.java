package ADIlec2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        //Given a string find its first nonrepeating element index and return
        //if not return -1;
//        String s1="abbackdcdfg";
//        int idx=-1;
//        Map<Character,Integer>mpp=new HashMap<>();
//        for(int i=0;i<s1.length();i++){
//            if(mpp.containsKey(s1.charAt(i))){
//                mpp.put(s1.charAt(i),mpp.get(s1.charAt(i))+1);
//            }
//            else {
//                mpp.put(s1.charAt(i), 1);
//            }
//        }
//        for(int i=0;i<s1.length();i++){
//            if(mpp.get(s1.charAt(i)) == 1){
//                idx=i;
//                break;
//            }
//        }
//        System.out.println(idx);


        //Given a string find the length of longest substring
        // with non repeating charac

            String s2="abaacdb";
            Map<Character,Integer>mpp1=new HashMap<>();
            int st=0;
            int maxlength=0;
            for(int i=0;i<s2.length();i++){
                if(mpp1.containsKey(s2.charAt(i))){
                    st=Math.max(st,mpp1.get(s2.charAt(i))+1);
                }
                mpp1.put(s2.charAt(i),i);
                maxlength=Math.max(maxlength,i-st+1);
            }
        System.out.println("maxlength "+ maxlength);

        //given an array and a target find the index of two element in the array
        //whose sum is equal to target
    }
}
