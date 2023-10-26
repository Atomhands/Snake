package test;

import com.snake.Data;

import javax.swing.*;
import java.net.URL;

/**
 * ClassName: Test
 * Package: test
 * Description:
 *
 * @Author NieHao
 * @Create 2023/10/26 13:03
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        URL wURL = Data.class.getResource("/statics/up.png");
        if(wURL != null){
            System.out.println(0);
        }
        //ImageIcon icon = new ImageIcon(wURL);
        //System.out.println(icon);
    }
}
