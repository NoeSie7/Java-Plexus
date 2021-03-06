package es.plexus.cedei.practicaExtra;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener {

    private JLabel texto, texto1;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton boton;          // boton con una determinada accion


    public Ventana() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Nominados con mas votos");                   // colocamos titulo a la ventana
        this.setSize(410, 310);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        // creamos los componentes
        texto = new JLabel();
        texto1 = new JLabel();
        caja = new JTextField();
        boton = new JButton();
        // configuramos los componentes
        //texto.setText("Nominado 1");    // colocamos un texto a la etiqueta
        //texto.setBounds(25, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        //texto.setText("Nominado 2");    // colocamos un texto a la etiqueta
        //texto.setBounds(75, 50, 100, 25);
        //caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        //boton.setText("Mostrar Mensaje");   // colocamos un texto al boton
        //boton.setBounds(50, 100, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        //boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        // adicionamos los componentes a la ventana
        //this.add(texto);
        //this.add(caja);
        //this.add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
        JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");    // mostramos un mensaje (frame, mensaje)
    } 

}
