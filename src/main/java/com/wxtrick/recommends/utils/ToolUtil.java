package com.wxtrick.recommends.utils;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.util.Stack;

/**
 * @author tianyi
 * @date 2018-05-18 12:47
 */
@Slf4j
public class ToolUtil {

    public static JSONObject badString(String bad){
        StringBuffer good=new StringBuffer();
        int a=-1,b=0;
        Stack<Integer> stack=new Stack<>();
        for (Integer i=0;i<bad.length();i++) {

            //TODO 日常处理
            if (bad.charAt(i)=='\"'){
                if (i==0||i==1){
                    continue;
                }else if(i==bad.length()-1){
                    good.append(bad.charAt(i));
                    System.out.print(bad.charAt(i));
                    break;
                }//else if(bad.charAt(i-2)==','||bad.charAt(i-2)=='{'||bad.charAt(i+1)==':'){
                else if(( (bad.charAt(i-2)==','||bad.charAt(i-1)=='{')
                        &&bad.charAt(bad.indexOf('\"',i+1)+1 )==':')||bad.charAt(i+1)==':'){
                    continue;
                }
            }
            good.append(bad.charAt(i));
            System.out.print(bad.charAt(i));
            //处理特殊节选段
            if (bad.charAt(i) == '{') {
                a = i;
                b=1;
                stack.push(i);
                while (!stack.empty()) {
                    if (bad.charAt(a+b)=='{'){
                        stack.push(a+b);
                    }else if (bad.charAt(a+b)=='}'){
                        stack.pop();
                    }
                    b++;
                }
                good.append(IntoBad(bad.substring(a, a+b))+"}");
                i = a+b-1;
                System.out.print(bad.charAt(i));
                //good.append();
            }
        }
        return JSONObject.fromObject(good.toString());
    }

    public static String IntoBad(String input){
        StringBuffer good=new StringBuffer();
        StringBuffer temp=new StringBuffer(input);
        temp.deleteCharAt(0);
        temp.deleteCharAt(temp.length()-1);
        String bad=temp.toString();
        int a=-1,b=0;
        Stack<Integer> stack=new Stack<>();
        for (Integer i=0;i<bad.length();i++) {

            //TODO 日常处理
            if (bad.charAt(i)=='\"'){
                char temppp='.';
                boolean b11=false;
                boolean b12=false;
                boolean b2=false;
                boolean B1=false;
                int ttt=0;
                if (i==0||i==1){
                    continue;
                }else if(i==bad.length()-1){
                    good.append(bad.charAt(i));
                    System.out.print(bad.charAt(i));
                    break;
                }//else if(bad.charAt(i-2)==','||bad.charAt(i-2)=='{'||bad.charAt(i+1)==':'){
                else if(( (bad.charAt(i-2)==','||bad.charAt(i-1)=='{')
                        &&bad.charAt(bad.indexOf('\"',i+1)+1 )==':')||bad.charAt(i+1)==':'){
                    continue;
                }
            }
            good.append(bad.charAt(i));
            System.out.print(bad.charAt(i));
            //处理特殊节选段
            if (bad.charAt(i) == '{') {
                a = i;
                b=1;
                stack.push(i);
                while (!stack.empty()) {
                    if (bad.charAt(a+b)=='{'){
                        stack.push(a+b);
                    }else if (bad.charAt(a+b)=='}'){
                        stack.pop();
                    }
                    b++;
                }
                good.append(IntoBad(bad.substring(a, a+b))+"}");
                i = a+b-1;
                System.out.print(bad.charAt(i));
                //good.append();
            }
        }
        if (good.toString().equals("")){
            return bad;
        }else {
            return good.toString();
        }
    }
}
