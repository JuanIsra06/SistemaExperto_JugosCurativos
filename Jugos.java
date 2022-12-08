import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Jugos extends JFrame implements ActionListener, MouseListener{
    public JLabel frutas, etqSerec, pos_enfer,nomJugo ;
    public JTextArea TA_jugo;
    public JButton botEnv, botReg;
    public String todo="";
    
    public Jugos(){
        setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Jugos");

        //Unir String
        todo = "\n" + "\n"+ Sintoma.descripcion + "\n\nIngredientes:\n"+ Sintoma.ingredientes + "\n";

        //Etiquetas
        etqSerec = new JLabel("Resultados");
		etqSerec.setBounds(329,20,121,31);//x,y,ancho,alto
        add(etqSerec);
        pos_enfer = new JLabel("Posible enfermedad: " + Sintoma.enfermedad);
		pos_enfer.setBounds(75,60,367,31);//x,y,ancho,alto
        add(pos_enfer);
        nomJugo = new JLabel("Jugo recomendado: "+Sintoma.jugo);
		nomJugo.setBounds(75,100,367,31);//x,y,ancho,alto
        add(nomJugo);

        //TextArea
        TA_jugo = new JTextArea(todo);
        TA_jugo.setBounds(75, 100, 630, 280);
        TA_jugo.setEditable(false);
        add(TA_jugo);

        //Botones
        botReg = new JButton("REGRESAR");
        botReg.setBounds(50, 400, 140, 50);//x,y,ancho,alto
        botReg.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        botReg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botReg);


        //Fuentes y colores
        Font fuente = new Font("IBM Plex Sans", Font.PLAIN, 24);
        Font fuente2 = new Font("IBM Plex Sans Medium", Font.PLAIN, 15);
        Font fuente3 = new Font("IBM Plex Sans SemiBold", Font.PLAIN, 17);
        getContentPane().setBackground(new Color(255, 255, 255));
        etqSerec.setFont(fuente);
        pos_enfer.setForeground(new Color(52,74,0));
        pos_enfer.setFont(fuente3);
        nomJugo.setForeground(new Color(52,74,0));
        nomJugo.setFont(fuente3);
        TA_jugo.setBackground(new Color(255,255,255));
        TA_jugo.setForeground(new Color(52,74,0));
        TA_jugo.setFont(fuente2);
        botReg.setBackground(new Color(101,137,0));
        botReg.setForeground(new Color(255,255,255));
        botReg.setFont(fuente);

        //Imagen planta
        ImageIcon img1 = new ImageIcon("imgs/frutas.png");
		frutas = new JLabel(img1);
		frutas.setBounds(-62, 310, 905, 300);//x,y,ancho,alto
		Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(frutas.getWidth(),frutas.getHeight(), Image.SCALE_DEFAULT));
		frutas.setIcon(icono1);
        add(frutas);

        //Listeners
        botReg.addActionListener(this);
        botReg.addMouseListener(this);
    }

    public void actionPerformed(ActionEvent accion) {
		if(accion.getSource() == botReg){
		    Home ventana1 = new Home();
            ventana1.setBounds(300,100,780,600);
            ventana1.setLocationRelativeTo(null);
		    ventana1.setVisible(true);
		    ventana1.setResizable(false);
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
        if(e.getSource() == botEnv){
		    botEnv.setBackground(new Color(255, 255, 255));
            botEnv.setForeground(new Color(101,137,0));
            botEnv.setBorder(BorderFactory.createLineBorder(new Color(101,137,0), 3));
		}
        if(e.getSource() == botReg){
		    botReg.setBackground(new Color(255, 255, 255));
            botReg.setForeground(new Color(101,137,0));
            botReg.setBorder(BorderFactory.createLineBorder(new Color(101,137,0), 3));
		}
    }

    public void mouseExited(MouseEvent e) {
        if(e.getSource() == botEnv){
            botEnv.setBackground(new Color(101,137,0));
            botEnv.setForeground(new Color(255, 255, 255));
            botEnv.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		}
        if(e.getSource() == botReg){
            botReg.setBackground(new Color(101,137,0));
            botReg.setForeground(new Color(255, 255, 255));
            botReg.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		}
    }

    public static void main(String args []){
		Jugos ventana4 = new Jugos();
        ventana4.setBounds(300,100,780,600);
        ventana4.setLocationRelativeTo(null);
		ventana4.setVisible(true);
		ventana4.setResizable(false);
	}
}
