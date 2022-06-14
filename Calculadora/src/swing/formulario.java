package swing;

import Acciones.Division;
import Acciones.Multiplicacion;
import Acciones.Resta;
import Acciones.Suma;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulario implements ActionListener{
    JButton jbmas,jbborun,jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10,jbpunto,jbigual,jbmenos,jbentre,jbpor,jbborrar;
    JPanel  jp2;
    JLabel jl1, jl2, jl3,jl4;
    int val = 0;


    int operacion  =0;
    int resultado =0;

    public formulario(){
        JFrame frMain = new JFrame("Calculadora");
        frMain.setLayout(new BorderLayout(100, 20));
        jl1 = new JLabel(); //texto
        jl2 = new JLabel(); //texto
        jl3 = new JLabel(); //texto
        jl4 = new JLabel(); //texto
        jl1.setText("0");
        jl2.setText("0");
        jl3.setText("0");
        jl4.setText("0");
        mostrarBot();
        frMain.add(jl1, BorderLayout.BEFORE_FIRST_LINE);
        frMain.add(jl2, BorderLayout.CENTER);
        frMain.add(jp2, BorderLayout.SOUTH);
        frMain.setSize(400, 300);
        frMain.setVisible(true);
        frMain.setResizable(false);

        frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jbmas.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

               val=(Suma.Opsumar(resultado));

            }
        });
        jbmenos.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                jl1.setText("Ingrese el valor");
                val=(Resta.Opresta(resultado));

            }
        });
        jbpor.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                jl1.setText("Ingrese el valor");
                val=(Multiplicacion.Opmulti(resultado));

            }
        });
        jbentre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText("Ingrese el valor");
                val=(Division.Opdivision(resultado));

            }
        });

        jbigual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (operacion) {
                    case 1 -> {
                        resultado *= val;
                        jl2.setText("Resultado: " + resultado);
                    }
                    case 2 -> {
                        resultado = val / resultado;
                        jl2.setText("Resultado: " + resultado);
                    }
                    case 3 -> {
                        resultado = val - resultado;
                        jl2.setText("Resultado: " + resultado);
                    }
                    case 4 -> {
                        resultado =resultado+ val;
                        jl2.setText("Resultado: " + resultado);
                    }
                    default -> {
                    }
                }




            }
        });
    }
    public void mostrarBot(){//metodo donde se encontrara el jpanel que contiene los botones
        jp2 = new JPanel(new GridLayout(5, 5, 1, 5));
        jbmas = new JButton("+");
        jbborun=new JButton("<");
        jb1= new JButton("1");
        jb2 = new JButton("2");
        jb3 = new JButton("3");
        jb4 = new JButton("4");
        jb5 = new JButton("5");
        jb6 = new JButton("6");
        jb7 = new JButton("7");
        jb8 = new JButton("8");
        jb9 = new JButton("9");
        jb10 = new JButton("0");
        jbpunto = new JButton(".");
        jbigual = new JButton("=");
        jbmenos = new JButton("-");
        jbentre = new JButton("/");
        jbpor = new JButton("*");
        jbborrar = new JButton("C");

        //añadiendo los botones al jpanel

        jp2.add(jb7);
        jp2.add(jb8);
        jp2.add(jb9);
        jp2.add(jbborrar);
        jp2.add(jb4);
        jp2.add(jb5);
        jp2.add(jb6);
        jp2.add(jbpor);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jbentre);
        jp2.add(jb10);
        jp2.add(jbigual);
        jp2.add(jbmenos);
        jp2.add(jbmas);


        //añadiendo el listener para el evento del click

        jbmas.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);
        jb9.addActionListener(this);
        jb10.addActionListener(this);
        jbpunto.addActionListener(this);
        jbigual.addActionListener(this);
        jbmenos.addActionListener(this);
        jbentre.addActionListener(this);
        jbpor.addActionListener(this);
        jbborrar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        switch (e.getActionCommand()) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                jl1.setText(e.getActionCommand());
                jl2.setText(e.getActionCommand());
                resultado = Integer.parseInt(e.getActionCommand());
            }
            case "C" -> {
                jl1.setText("");
                jl2.setText("");
            }
        }
        switch (e.getActionCommand()) {
            case "*" -> {
                operacion = 1;
                jl1.setText(e.getActionCommand());
            }
            case "/" -> {
                operacion = 2;
                jl1.setText(e.getActionCommand());
            }
            case "-" -> {
                operacion = 3;
                jl1.setText(e.getActionCommand());
            }
            case "+" -> {
                operacion = 4;
                jl1.setText(e.getActionCommand());
            }
            default -> {
            }
        }
    }




}

