package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame  implements KeyListener {
    final int HEIGHT = 100;
    final int WIDTH = 100;
    JPanel labelBlock;
    boolean left;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    public Window(){
        this.setLayout(null);
        this.labelBlock = new JPanel();
        labelBlock.setBounds(500,500,WIDTH,HEIGHT);
        labelBlock.setBackground(Color.blue);
        this.add(labelBlock);
        labelBlock.setVisible(true);

        this.addKeyListener(this);


        this.setSize(800,800);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        run();
    }
    public void run(){
        new Thread(()->{
            while (true){
                if (this.left && labelBlock.getX() > 0){
                    labelBlock.setBounds(labelBlock.getX() - 1, labelBlock.getY(),WIDTH, HEIGHT);
                    sleep();
                }
                if (this.right && labelBlock.getX() <700){
                    labelBlock.setBounds(labelBlock.getX() + 1, labelBlock.getY(),WIDTH, HEIGHT);
                    sleep();
                }
                if (this.up && labelBlock.getY() > 0){
                    labelBlock.setBounds(labelBlock.getX(), labelBlock.getY() - 1,WIDTH, HEIGHT);
                    sleep();
                }
                if (this.down && labelBlock.getY() < 700){
                    labelBlock.setBounds(labelBlock.getX() , labelBlock.getY() + 1,WIDTH, HEIGHT);
                    sleep();
                }
//                    while (this.labelBlock.getX() > 0){
//                    labelBlock.setBounds(labelBlock.getX() - 1, labelBlock.getY(),WIDTH, HEIGHT);
//                    sleep();
//                }
//                while (this.labelBlock.getY() < 700){
//                    labelBlock.setBounds(labelBlock.getX(), labelBlock.getY() + 1,WIDTH,HEIGHT);
//                    sleep();
//                }
//                while (this.labelBlock.getX() < 700){
//                    labelBlock.setBounds(labelBlock.getX() + 1, labelBlock.getY(),WIDTH,HEIGHT);
//                    sleep();
//                }
//                while (this.labelBlock.getY() > 0){
//                    labelBlock.setBounds(labelBlock.getX() , labelBlock.getY()-1,WIDTH,HEIGHT);
//                    sleep();
//                }
                sleep();
            }
        }).start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a'){
            this.left = true;
        }
        if (e.getKeyChar() == 'w'){
            this.up = true;
        }
        if (e.getKeyChar() == 's'){
            this.down = true;
        }
        if (e.getKeyChar() == 'd'){
            this.right = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a'){
            this.left = false;
        }
        if (e.getKeyChar() == 'w'){
            this.up = false;
        }
        if (e.getKeyChar() == 's'){
            this.down = false;
        }
        if (e.getKeyChar() == 'd'){
            this.right = false;
        }

    }
    public void sleep(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
