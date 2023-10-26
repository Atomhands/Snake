package com.snake;

import javax.swing.*;
import javax.xml.stream.FactoryConfigurationError;

/**
 * ClassName: StartGame
 * Package: com.snake
 * Description:
 *
 * @Author NieHao
 * @Create 2023/10/26 11:14
 * @Version 1.0
 */
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("my first game -- snake");
        frame.setSize(800,800);
        frame.setName("my first game -- snake");
        //位置
        frame.setLocationRelativeTo(null);
        //固定
        frame.setResizable(false);
        //start
        frame.add(new GamePanel());
        //可见
        frame.setVisible(true);
        //关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
