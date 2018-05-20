package com.wxtrick.recommends.utils;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tianyi
 * @date 2018-05-18 19:47
 */
class ToolUtilTest {
    @Test
    void badString() {

        String bad="{\"rating\": {\"max\": 10, \"average\": 6.9, \"stars\": \"35\", \"min\": 0}, \"reviews_count\": 7, \"wish_count\": 487, \"douban_site\": \"\", \"year\": \"2006\", \"images\": {\"small\": \"http://img3.doubanio.com\\/view\\/photo\\/s_ratio_poster\\/public\\/p2226378048.jpg\", \"large\": \"http://img3.doubanio.com\\/view\\/photo\\/s_ratio_poster\\/public\\/p2226378048.jpg\", \"medium\": \"http://img3.doubanio.com\\/view\\/photo\\/s_ratio_poster\\/public\\/p2226378048.jpg\"}, \"alt\": \"https:\\/\\/movie.douban.com\\/subject\\/2257094\\/\", \"id\": \"2257094\", \"mobile_url\": \"https:\\/\\/movie.douban.com\\/subject\\/2257094\\/mobile\", \"title\": \"\\u6b7b\\u795e\\u5267\\u573a\\u7248\\uff1a\\u65e0\\u4eba\\u7684\\u56de\\u5fc6\", \"do_count\": null, \"share_url\": \"http:\\/\\/m.douban.com\\/movie\\/subject\\/2257094\", \"seasons_count\": null, \"schedule_url\": \"\", \"episodes_count\": null, \"countries\": [\"\\u65e5\\u672c\"], \"genres\": [\"\\u52a8\\u753b\", \"\\u52a8\\u4f5c\", \"\\u5192\\u9669\"], \"collect_count\": 6002, \"casts\": [{\"alt\": \"https:\\/\\/movie.douban.com\\/celebrity\\/1028326\\/\", \"avatars\": {\"small\": \"http://img7.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p5793.jpg\", \"large\": \"http://img7.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p5793.jpg\", \"medium\": \"http://img7.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p5793.jpg\"}, \"name\": \"\\u68ee\\u7530\\u6210\\u4e00\", \"id\": \"1028326\"}, {\"alt\": \"https:\\/\\/movie.douban.com\\/celebrity\\/1016839\\/\", \"avatars\": {\"small\": \"http://img3.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p10428.jpg\", \"large\": \"http://img3.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p10428.jpg\", \"medium\": \"http://img3.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p10428.jpg\"}, \"name\": \"\\u6298\\u7b20\\u5bcc\\u7f8e\\u5b50\", \"id\": \"1016839\"}, {\"alt\": \"https:\\/\\/movie.douban.com\\/celebrity\\/1033828\\/\", \"avatars\": {\"small\": \"http://img7.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p1386076902.2.jpg\", \"large\": \"http://img7.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p1386076902.2.jpg\", \"medium\": \"http://img7.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p1386076902.2.jpg\"}, \"name\": \"\\u658b\\u85e4\\u5343\\u548c\", \"id\": \"1033828\"}, {\"alt\": \"https:\\/\\/movie.douban.com\\/celebrity\\/1046231\\/\", \"avatars\": {\"small\": \"http://img3.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p1500366673.47.jpg\", \"large\": \"http://img3.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p1500366673.47.jpg\", \"medium\": \"http://img3.doubanio.com\\/view\\/celebrity\\/s_ratio_celebrity\\/public\\/p1500366673.47.jpg\"}, \"name\": \"\\u6c5f\\u539f\\u6b63\\u58eb\", \"id\": \"1046231\"}], \"current_season\": null, \"original_title\": \"\\u5287\\u5834\\u7248 BLEACH \\u30d6\\u30ea\\u30fc\\u30c1 MEMORIES OF NOBODY\", \"summary\": \"\\u5b81\\u9759\\u7965\\u548c\\u7684\\u7a7a\\u5ea7\\u9547\\u8fce\\u6765\\u91d1\\u9ec4\\u8272\\u7684\\u79cb\\u5929\\uff0c\\u9ed1\\u5d0e\\u4e00\\u62a4\\uff08\\u68ee\\u7530\\u6210\\u4e00 \\u914d\\u97f3\\uff09\\u548c\\u673d\\u6728\\u9732\\u742a\\u4e9a\\uff08\\u6298\\u7b20\\u5bcc\\u7f8e\\u5b50 \\u914d\\u97f3\\uff09\\u521a\\u521a\\u5904\\u7406\\u5b8c\\u865a\\u4f5c\\u4e71\\u7684\\u4e8b\\u4ef6\\uff0c\\u9547\\u8f66\\u7ad9\\u65c1\\u4fbf\\u51fa\\u73b0\\u6210\\u7fa4\\u7684\\u6b20\\u9b42\\u3002\\u5b83\\u4eec\\u56db\\u5904\\u6e38\\u8d70\\uff0c\\u4efb\\u4f55\\u9a71\\u9010\\u65b9\\u6cd5\\u90fd\\u5931\\u53bb\\u6548\\u529b\\u3002\\u6b63\\u5f53\\u4ed6\\u4eec\\u4e00\\u7b79\\u83ab\\u5c55\\u4e4b\\u65f6\\uff0c\\u6301\\u6709\\u65a9\\u9b42\\u5200\\u201c\\u5f25\\u52d2\\u4e38\\u201d\\u7684\\u6b7b\\u795e\\u5c11\\u5973\\u831c\\u96eb\\u7a81\\u7136\\u51fa\\u73b0\\uff0c\\u5e76\\u6210\\u529f\\u9a71\\u6563\\u6b20\\u9b42\\u3002\\u9732\\u742a\\u4e9a\\u5bf9\\u4e00\\u8fde\\u4e32\\u7684\\u4e8b\\u4ef6\\u9887\\u611f\\u4e0d\\u5b89\\uff0c\\u4e8e\\u662f\\u56de\\u5230\\u5c38\\u9b42\\u754c\\u8c03\\u67e5\\u3002\\u4ece\\u62a4\\u5ef7\\u5341\\u4e09\\u961f\\u7684\\u53e3\\u4e2d\\uff0c\\u4e00\\u62a4\\u5f97\\u77e5\\u73b0\\u4e16\\u548c\\u5c38\\u9b42\\u754c\\u4e2d\\u95f4\\u7684\\u65ad\\u754c\\u51fa\\u73b0\\u65b0\\u7684\\u7a7a\\u95f4\\uff0c\\u5e76\\u4e14\\u4e0d\\u65ad\\u81a8\\u80c0\\uff0c\\u5bfc\\u81f4\\u73b0\\u4e16\\u4e0e\\u5c38\\u9b42\\u754c\\u76f8\\u901a\\u3002\\u8fd9\\u4e00\\u5207\\u5e76\\u975e\\u81ea\\u7136\\u5f62\\u6210\\uff0c\\u4f3c\\u4e4e\\u6709\\u4eba\\u6b63\\u6697\\u4e2d\\u64cd\\u7eb5\\u7740\\u4e00\\u5207\\uff0c\\u800c\\u831c\\u96eb\\u6b63\\u662f\\u8fd9\\u8d77\\u4e8b\\u4ef6\\u7684\\u5173\\u952e\\u2026\\u2026\\n\\u672c\\u7247\\u6839\\u636e\\u65e5\\u672c\\u6f2b\\u753b\\u5bb6\\u4e45\\u4fdd\\u5e26\\u4eba\\u7684\\u540c\\u540d\\u539f\\u8457\\u6539\\u7f16\\uff0c\\u7cfb\\u8be5\\u52a8\\u753b\\u7684\\u7b2c\\u4e00\\u90e8\\u5267\\u573a\\u7248\\u3002\\u00a9\\u8c46\\u74e3\", \"subtype\": \"movie\", \"directors\": [{\"alt\": null, \"avatars\": null, \"name\": \"\\u963f\\u90e8\\u8bb0\\u4e4b\", \"id\": null}], \"comments_count\": 433, \"ratings_count\": 4829, \"aka\": [\"Bleach\\u5267\\u573a\\u7248 \\u522b\\u5904\\u7684\\u8bb0\\u5fc6\", \"Bleach\\u5267\\u573a\\u7248 \\u65e0\\u4eba\\u7684\\u8bb0\\u5fc6\", \"Bleach\\u5267\\u573a\\u7248 Memories of Nobody\", \"\\u6b7b\\u795e\\u5267\\u573a\\u7248\", \"Bleach: The Movie - Memories of Nobody\", \"\\u6b7b\\u795e\\u5267\\u573a\\u7248\\uff1a\\u65e0\\u4eba\\u7684\\u56de\\u5fc6\"]}";
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
        //System.out.println(good.toString());
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