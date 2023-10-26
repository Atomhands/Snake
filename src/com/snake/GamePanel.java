package com.snake;

import org.omg.CORBA.DATA_CONVERSION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ClassName: GamePanel
 * Package: com.snake
 * Description:
 *
 * @Author NieHao
 * @Create 2023/10/26 11:37
 * @Version 1.0
 */
// 实现KeyListener 键盘监听    ActionListener操作监听
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //snake position
    public static int[] snakeX = new int[50];
    public static int[] snakeY = new int[50];
    //snake length
    public static int sLength;
    //food position
    int foodX;
    int foodY;
    //snake towards
    Towards direct;
    //score
    int score;
    //count time
    Timer timer = new Timer(100, this);
    //isStart
    boolean isStart;
    //isFail
    boolean isFail;

    //移动逻辑

    /**
     * actionPerformed()方法及paintComponent()方法都是在事件分派Swing线程中被调用，该方法也会自动调用，不需要手动调用
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //判断游戏状态
        if (isStart && !isFail) {
            //吃食物
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                sLength++;
                score += 9;
                Food.getFood(snakeX, snakeY);
                foodX = Food.X;
                foodY = Food.Y;
            }
            //snake move
            for (int i = sLength - 1; i > 0; i--) {

                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            if (direct == Towards.W) {
                snakeY[0] -= 25;
                if (snakeY[0] <0) isFail = true;
            } else if (direct == Towards.S) {
                snakeY[0] += 25;
                if (snakeY[0] >775) isFail = true;
            } else if (direct == Towards.A) {
                snakeX[0] -= 25;
                if (snakeX[0] < 0) isFail = true;
            } else if (direct == Towards.D) {
                snakeX[0] += 25;
                if (snakeX[0] > 800) isFail = true;
            }


            // 吃到自己
            for (int i = 1; i < sLength; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                }
            }
            repaint();
        }
        //timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //获取键盘输入参数
    @Override
    public void keyPressed(KeyEvent e) {
        //获取键盘按下的按键
        int key = e.getKeyCode();
        switch (key) {
            // 按下空格 若失败重新开始游戏，否则暂停游戏
            case KeyEvent.VK_SPACE:
                if (isFail) {
                    isFail = false;
                    // 重新初始化
                    init();
                } else {
                    isStart = !isStart;
                }
                repaint();
                break;
            //实现转向
            case KeyEvent.VK_W:
                if (direct != Towards.S) {
                    direct = Towards.W;
                }
                break;
            case KeyEvent.VK_S:
                if (direct != Towards.W) {
                    direct = Towards.S;
                }
                break;
            case KeyEvent.VK_A:
                if (direct != Towards.D) {
                    direct = Towards.A;
                }
                break;
            case KeyEvent.VK_D:
                if (direct != Towards.A) {
                    direct = Towards.D;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //初始化游戏
    private void init() {
        sLength = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;
        //
        snakeX[1] = 75;
        snakeY[1] = 100;
        //
        snakeX[2] = 50;
        snakeY[2] = 100;
        //枚举方向 向右
        direct = Towards.D;
        isStart = false;
        isFail = false;
        score = 0;
        //food
        Food.getFood(snakeX,snakeY);
        foodX = Food.X;
        foodY = Food.Y;
        timer.start();
    }

    // 重写绘制元件方法，手动重写，图形版的main()方法，是会自执行的
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.PINK);
        graphics.setColor(Color.GRAY);
        //游戏填充区域
        graphics.fillRect(0, 25, 800, 800);
        //snake 头部行动方向
        if (direct == Towards.W) {
            Data.w.paintIcon(this, graphics, snakeX[0], snakeY[0]);
            System.out.println("W");
        } else if (direct == Towards.S) {
            Data.s.paintIcon(this, graphics, snakeX[0], snakeY[0]);
            System.out.println("S");
        }
        if (direct == Towards.D) {
            Data.d.paintIcon(this, graphics, snakeX[0], snakeY[0]);
            System.out.println("D");
        } else if (direct == Towards.A) {
            Data.a.paintIcon(this, graphics, snakeX[0], snakeY[0]);
            System.out.println("A");
        }
        //snake body
        for (int i = 1; i < sLength; i++) {
            Data.body.paintIcon(this, graphics, snakeX[i], snakeY[i]);
        }
//        if(snakeX[0]==foodX&&snakeY[0]==foodY){
//            Data.food.paintIcon(this,graphics,snakeX[sLength-1],snakeY[sLength-1]);
//        }
        Data.food.paintIcon(this,graphics,foodX,foodY);
        // painting score
        graphics.setColor(Color.yellow);
        graphics.setFont(new Font("宋体", Font.BOLD, 25));
        graphics.drawString("当前长度: " + sLength, 150, 25);
        graphics.drawString("当前积分: " + score, 450, 25);
        //isStart
        if (!isStart) {
            graphics.setColor(Color.green);
            graphics.setFont(new Font("宋体", Font.BOLD, 40));
            graphics.drawString("press space to startGame: " + score, 50, 500);
            Data.food.paintIcon(this,graphics,foodX,foodY);
        }
        if (isFail) {
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("宋体", Font.BOLD, 40));
            graphics.drawString("press space continue the startGame: " + score, 50, 500);
        }
    }

    //初始化
    public GamePanel() {
        init();
        //设置游戏焦点
        this.setFocusable(true);
        this.addKeyListener(this);
    }
}
