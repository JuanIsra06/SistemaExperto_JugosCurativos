import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class Sintoma extends JFrame implements ActionListener, MouseListener, ChangeListener{
    public JLabel plantas, etqSel;
    public JTextArea TA_sint;
    public JCheckBox ch_DC, ch_DE, ch_FM, ch_T, ch_DG, ch_Nas, ch_Fie, ch_Fat;
    public JButton botEnv, botReg;
    public static String res, enfermedad, jugo, descripcion, ingredientes;
    //public static int ban_DC=0,ban_DE=0,ban_FM=0, ban_T=0, ban_DG=0, ban_Nas=0, ban_Fie=0, ban_Fat=0;

    
    public Sintoma(){
        setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sintomas");

        //Etiquetas
        etqSel = new JLabel("Seleccione sus sintomas");
		etqSel.setBounds(258,13,270,31);//x,y,ancho,alto
        add(etqSel);

        //TextArea
        TA_sint = new JTextArea(" Aqui apareceran sus sintomas");
        TA_sint.setBounds(390, 70, 363, 298);
        TA_sint.setEditable(false);
        add(TA_sint);

        //Botones
        botEnv = new JButton("BUSCAR");
        botEnv.setBounds(510, 400, 140, 50);//x,y,ancho,alto
        botEnv.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        botEnv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botEnv);
        botReg = new JButton("REGRESAR");
        botReg.setBounds(20, 400, 140, 50);//x,y,ancho,alto
        botReg.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        botReg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(botReg);

        //checkbox
        ch_DC = new JCheckBox("Dolor de cabeza");
        ch_DC.setBounds(10,70,150,31);
        add(ch_DC);
        ch_DE = new JCheckBox("Dolor de estomago");
        ch_DE.setBounds(10,110,160,31);
        add(ch_DE);
        ch_FM = new JCheckBox("Flujo de moco");
        ch_FM.setBounds(10,150,150,31);
        add(ch_FM);
        ch_T = new JCheckBox("Tos");
        ch_T.setBounds(10,190,150,31);
        add(ch_T);
        ch_DG = new JCheckBox("Dolor de garganta");
        ch_DG.setBounds(10,230,150,31);
        add(ch_DG);
        ch_Fie = new JCheckBox("Fiebre");
        ch_Fie.setBounds(10,270,150,31 );
        add(ch_Fie);
        ch_Fat = new JCheckBox("Fatiga");
        ch_Fat.setBounds(10,310,150,31);
        add(ch_Fat);
        ch_Nas = new JCheckBox("Mareos/Náuseas");
        ch_Nas.setBounds(10,350,150,31);
        add(ch_Nas);

        //Colores y fuentes
        Font fuente = new Font("IBM Plex Sans", Font.PLAIN, 24);
        Font fuente2 = new Font("IBM Plex Sans Medium", Font.PLAIN, 15);
        getContentPane().setBackground(new Color(255, 255, 255));
        etqSel.setFont(fuente);
        botEnv.setBackground(new Color(101,137,0));
        botEnv.setForeground(new Color(255,255,255));
        botEnv.setFont(fuente);
        botReg.setBackground(new Color(101,137,0));
        botReg.setForeground(new Color(255,255,255));
        botReg.setFont(fuente);
        TA_sint.setBackground(new Color(217, 217, 217));
        TA_sint.setForeground(new Color(153, 153, 153));
        TA_sint.setFont(fuente2);
        ch_DC.setBackground(new Color(255, 255, 255));
        ch_DC.setForeground(new Color(52,74,0));
        ch_DC.setFont(fuente2);
        ch_DE.setBackground(new Color(255, 255, 255));
        ch_DE.setForeground(new Color(52,74,0));
        ch_DE.setFont(fuente2);
        ch_FM.setBackground(new Color(255, 255, 255));
        ch_FM.setForeground(new Color(52,74,0));
        ch_FM.setFont(fuente2);
        ch_T.setBackground(new Color(255, 255, 255));
        ch_T.setForeground(new Color(52,74,0));
        ch_T.setFont(fuente2);
        ch_DG.setBackground(new Color(255, 255, 255));
        ch_DG.setForeground(new Color(52,74,0));
        ch_DG.setFont(fuente2);
        ch_Nas.setBackground(new Color(255, 255, 255));
        ch_Nas.setForeground(new Color(52,74,0));
        ch_Nas.setFont(fuente2);
        ch_Fie.setBackground(new Color(255, 255, 255));
        ch_Fie.setForeground(new Color(52,74,0));
        ch_Fie.setFont(fuente2);
        ch_Fat.setBackground(new Color(255, 255, 255));
        ch_Fat.setForeground(new Color(52,74,0));
        ch_Fat.setFont(fuente2);

        //Imagen planta
        ImageIcon img1 = new ImageIcon("imgs/plantas1.png");
		plantas = new JLabel(img1);
		plantas.setBounds(-22, 460, 824, 228);//x,y,ancho,alto
		Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(plantas.getWidth(),plantas.getHeight(), Image.SCALE_DEFAULT));
		plantas.setIcon(icono1);
        add(plantas);


        //ActionListener
        botEnv.addActionListener(this);
        botEnv.addMouseListener(this);
        botReg.addActionListener(this);
        botReg.addMouseListener(this);
        ch_DC.addChangeListener(this);
        ch_DE.addChangeListener(this);
        ch_FM.addChangeListener(this);
        ch_T.addChangeListener(this);
        ch_DG.addChangeListener(this);
        ch_Nas.addChangeListener(this);
        ch_Fie.addChangeListener(this);
        ch_Fat.addChangeListener(this);
    }//FINAL DEL CONSTRUCTOR

    public void stateChanged(ChangeEvent accion){
        String cadena = "";
        
        if (ch_DC.isSelected()==true){ TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Dolor de cabeza\n"; }

        if (ch_DE.isSelected()==true){ TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Dolor de estomago\n"; }

        if (ch_FM.isSelected()==true){ TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Flujo de moco\n"; }

        if (ch_T.isSelected()==true){ TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Tos\n"; }

        if (ch_DG.isSelected()==true){ TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Dolor de garganta\n"; }

        if (ch_Fie.isSelected()==true){ TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Fiebre\n"; }

        if (ch_Fat.isSelected()==true){ TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Fatiga\n"; }

        if (ch_Nas.isSelected()==true){  TA_sint.setForeground(Color.BLACK); cadena = cadena + " - Mareos/Náuseas\n"; }

        TA_sint.setText(cadena);
    }

    public void actionPerformed(ActionEvent accion) {
        String aux;
        //String[] num_enfer= new String[10];
        //String[] jugo_enfer= new String[10];
        int ban_DC=0,ban_DE=0,ban_FM=0, ban_T=0, ban_DG=0, ban_Nas=0, ban_Fie=0, ban_Fat=0;

        if (ch_DC.isSelected()){ ban_DC=1; }

        if (ch_DE.isSelected()){ ban_DE=1; }

        if (ch_FM.isSelected()){ ban_FM=1; }

        if (ch_T.isSelected()){ ban_T=1; }

        if (ch_DG.isSelected()){ ban_DG=1; }

        if (ch_Fie.isSelected()){ ban_Fie=1; }

        if (ch_Fat.isSelected()){ ban_Fat=1; }

        if (ch_Nas.isSelected()){ ban_Nas=1; }
        aux = Integer.toString(ban_DC)+Integer.toString(ban_DE)+Integer.toString(ban_FM)
        +Integer.toString(ban_T)+Integer.toString(ban_DG)+Integer.toString(ban_Fie)
        +Integer.toString(ban_Fat)+Integer.toString(ban_Nas);

        if(accion.getSource() == botReg){
		    Home ventana1 = new Home();
            ventana1.setBounds(300,100,780,600);
            ventana1.setLocationRelativeTo(null);
		    ventana1.setVisible(true);
		    ventana1.setResizable(false);
            this.dispose();
		}

        if(accion.getSource()==botEnv){
            Conexion_BD con_BD = new Conexion_BD();
            //num_enfer = con_BD.obt_num_enfer();

            if (aux.equals("00000000")){
                JOptionPane.showMessageDialog(null, "Seleccione por lo menos 1 síntoma", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            }else{
                con_BD.obt_inf_enfer();
                con_BD.BDR();
                enfermedad = con_BD.ObtenerEnfermedad(aux);
                jugo = con_BD.ObtenerJugo(enfermedad);
                descripcion = con_BD.ObtenerDescricion(jugo);
                ingredientes = con_BD.ObtenerIngredientes(jugo);
                /*System.out.println(enfermedad);
                /*System.out.println(jugo);
                System.out.println(descripcion);
                System.out.println(ingredientes);*/
                if (enfermedad == null){
                    JOptionPane.showMessageDialog(null, "Lo siento, no hay una enfermedad para esos sintomas.\nIntente otra combinación.", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }else{
                    Jugos ventana4 = new Jugos();
                    ventana4.setBounds(300,100,780,600);
                    ventana4.setLocationRelativeTo(null);
		            ventana4.setVisible(true);
		            ventana4.setResizable(false);
                    this.dispose(); 
                }
                
            }
            
            
            
        }//FIN DE LA ACCION DEL BOTON ENVIAR
		
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
        
		Sintoma ventana2 = new Sintoma();
        ventana2.setBounds(300,100,780,600);
        ventana2.setLocationRelativeTo(null);
		ventana2.setVisible(true);
		ventana2.setResizable(false);
       
        
	}

}
