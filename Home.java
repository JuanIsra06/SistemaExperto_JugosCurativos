import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener, MouseListener{
    public JLabel planta1,planta2, etiqBien, etiqApp1,etiqApp2;
    public JTextArea textarea;
    public JButton botSin, botDia;
    
    public Home(){
        setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio");
       

        //Etiquetas
        etiqBien = new JLabel("Bienvenido a MERCEL");
		etiqBien.setBounds(273,7,240,31);//x,y,ancho,alto
        add(etiqBien);
        etiqApp1 = new JLabel("Esta aplicación fue creada para que puedas buscar remedios");
		etiqApp1.setBounds(64,93,660,31);//x,y,ancho,alto
        add(etiqApp1);
        etiqApp2 = new JLabel("caseros a partir de tus síntomas.");
		etiqApp2.setBounds(214,124,355,31);//x,y,ancho,alto
        add(etiqApp2);

        //Textarea
        textarea = new JTextArea();
        textarea.setBounds(0, 0, 780, 45);
        textarea.setEditable(false);
        add(textarea);

        //Botones
        botSin = new JButton("BUSCAR SÍNTOMAS");
        botSin.setBounds(320, 255, 155, 51);//x,y,ancho,alto
        botSin.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));   
        botSin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botSin);
        botDia = new JButton("BUSCAR DIAGNÓSTICO");
        botDia.setBounds(310, 330, 177, 51);//x,y,ancho,alto
        botDia.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));   
        botDia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botDia);

        //Colores y fuentes
        Font fuente = new Font("IBM Plex Sans", Font.PLAIN, 24);
        Font fuente2 = new Font("IBM Plex Sans Medium", Font.PLAIN, 15);
        getContentPane().setBackground(new Color(255, 255, 255));
        etiqBien.setForeground(new Color(255,255,255));
        etiqBien.setFont(fuente);
        etiqApp1.setFont(fuente);
        etiqApp2.setFont(fuente);
        textarea.setBackground(new Color(52,74,0));
        botSin.setFont(fuente2);
        botSin.setBackground(new Color(101,137,0));
        botSin.setForeground(new Color(255,255,255));
        botDia.setFont(fuente2);
        botDia.setBackground(new Color(101,137,0));
        botDia.setForeground(new Color(255,255,255));


        //Imagen planta
        ImageIcon img1 = new ImageIcon("imgs/planta1.png");
		planta1 = new JLabel(img1);
		planta1.setBounds(324, 380, 512, 277);//x,y,ancho,alto
		Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(planta1.getWidth(),planta1.getHeight(), Image.SCALE_DEFAULT));
		planta1.setIcon(icono1);
        add(planta1);
        ImageIcon img2 = new ImageIcon("imgs/planta1_mirror.png");
		planta2 = new JLabel(img2);
		planta2.setBounds(-56, 380, 512, 277);//x,y,ancho,alto
		Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(planta2.getWidth(),planta2.getHeight(), Image.SCALE_DEFAULT));
		planta2.setIcon(icono2);
        add(planta2);

        //ActionListener
        botSin.addActionListener(this);
        botSin.addMouseListener(this);
        botDia.addActionListener(this);
        botDia.addMouseListener(this);
    }


    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botSin){
		    Sintoma ventana2 = new Sintoma();
            ventana2.setBounds(300,100,780,600);
            ventana2.setLocationRelativeTo(null);
		    ventana2.setVisible(true);
		    ventana2.setResizable(false);
            this.dispose();
		}
        if(e.getSource() == botDia){
            Diagnostico ventana3 = new Diagnostico();
            ventana3.setBounds(300,100,780,600);
            ventana3.setLocationRelativeTo(null);
		    ventana3.setVisible(true);
		    ventana3.setResizable(false);
            this.dispose();
        }
    }//Fin del metodo boton
    
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == botSin){
		    botSin.setBackground(new Color(255, 255, 255));
            botSin.setForeground(new Color(101,137,0));
            botSin.setBorder(BorderFactory.createLineBorder(new Color(101,137,0), 3));
		}
        if(e.getSource() == botDia){
		    botDia.setBackground(new Color(255, 255, 255));
            botDia.setForeground(new Color(101,137,0));
            botDia.setBorder(BorderFactory.createLineBorder(new Color(101,137,0), 3));
		}
        
    }

    public void mouseExited(MouseEvent e) {
        if(e.getSource() == botSin){
            botSin.setBackground(new Color(101,137,0));
            botSin.setForeground(new Color(255, 255, 255));
            botSin.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		}
        if(e.getSource() == botDia){
            botDia.setBackground(new Color(101,137,0));
            botDia.setForeground(new Color(255, 255, 255));
            botDia.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		}
    }

    public static void main(String args []){
		Home ventana1 = new Home();
        ventana1.setBounds(300,100,780,600);
        ventana1.setLocationRelativeTo(null);
		ventana1.setVisible(true);
		ventana1.setResizable(false);
	}
}
