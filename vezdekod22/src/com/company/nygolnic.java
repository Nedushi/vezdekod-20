package com.company;

import java.awt.*;

import javax.swing.*;
import java.lang.Math;

public class nygolnic extends JPanel {
    static int n =4; //кол-во граней
    static int R = 140; //радиус
    static int X = 400, Y = 300;//координаты центра
    static int x[] = new int [n];//координаты точек
    static int y[] = new int [n];//
    static int x1, y1, x2, y2;
    static int j = n;

    public nygolnic(){

        JFrame jf = new JFrame();
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.getContentPane().add(this);
        jf.setVisible(true);
        jf.repaint();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        double a, b,  z = 0 ;  int i = 0; double angle = 180+(180*(n-2)) / n ;
        while(i < n){
            a = Math.cos( z/180*Math.PI);
            b = Math.sin( z/180*Math.PI);
            x[i] = X + (int)(Math.round(a) * R);
            y[i] = Y - (int)(Math.round(b) * R);
            z = z + angle;
            i++;
        }
        System.out.println();

        int x1, x2, y1, y2;

        int j = n-1;
        while(j >= 0){

            if(j > 0){
                x1 = x[j]; x2 = x[j-1];
                y1 = y[j]; y2 = y[j-1];
                g.drawLine(x1, y1, x2, y2);
                j--;
            }
            else{
                x1 = x[j]; x2 = x[n-1];
                y1 = y[j]; y2 = y[n-1];
                g.drawLine(x1, y1, x2, y2);
                j--;

            }

        }

    }

    public static void main(String[] args) throws Exception{
        nygolnic NY = new nygolnic();
        NY.repaint();
    }

}