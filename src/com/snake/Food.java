package com.snake;

import java.util.Random;

/**
 * ClassName: Food
 * Package: com.snake
 * Description:
 *
 * @Author NieHao
 * @Create 2023/10/26 11:36
 * @Version 1.0
 */
public class Food {
    public static int X;
    public static int Y;

    //随机食物位置
    private static Random random = new Random();

    public static void getFood(int[] snakeX, int[] snakeY) {
        //X = 25 + 25 * random.nextInt(39);
        //Y = 25 + 25 * random.nextInt(38);
        for (int i = 0; i < GamePanel.sLength; i++) {
            if (snakeX[i] == X && snakeY[i] == Y) {
                X = 25 + 25 * random.nextInt(31);
                Y = 25 + 25 * random.nextInt(30);
                i = 0;
            }
        }
    }
}
