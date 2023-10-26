package com.snake;

import javax.swing.*;
import java.net.URL;

/**
 * ClassName: Data
 * Package: com.snake
 * Description:
 *
 * @Author NieHao
 * @Create 2023/10/26 11:23
 * @Version 1.0
 */
public class Data {
    /*
    * 静态资源加载
    */
    public static URL wURL = Data.class.getResource("/statics/up.png");
    public static URL aURL = Data.class.getResource("/statics/left.png");
    public static URL sURL = Data.class.getResource("/statics/down.png");
    public static URL dURL = Data.class.getResource("/statics/right.png");
    public static URL foodURL = Data.class.getResource("/statics/food.png");
    public static URL bodyURL = Data.class.getResource("/statics/body.png");
    public static ImageIcon w = new ImageIcon(wURL);
    public static ImageIcon a = new ImageIcon(aURL);
    public static ImageIcon s = new ImageIcon(sURL);
    public static ImageIcon d = new ImageIcon(dURL);

    public static ImageIcon food = new ImageIcon(foodURL);
    public static ImageIcon body = new ImageIcon(bodyURL);

//    static {
//        assert wURL != null;
//        assert aURL != null;
//        assert sURL != null;
//        assert dURL != null;
//        assert foodURL != null;
//        assert bodyURL != null;
//        w = new ImageIcon(wURL);
//        a = new ImageIcon(aURL);
//        s = new ImageIcon(sURL);
//        d = new ImageIcon(dURL);
//        food = new ImageIcon(foodURL);
//        body = new ImageIcon(bodyURL);
//    }
}
