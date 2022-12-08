import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;


public class Diagnostico extends JFrame implements ActionListener, MouseListener, ChangeListener{
    public JLabel planta1,planta2, plantas, etqSel;
    public JTextArea TA_sint;
    public JRadioButton anemia, artritis, anginas, diabetes, catarro, asma, osteo, gastritis, hiperten, alergias;
    public ButtonGroup Diagnosticos;
    public JButton botEnv, botReg;
    public int band;
    public String enfermedad;

    public Diagnostico(){
        setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Diagnostico");

        //Etiquetas
        etqSel = new JLabel("Seleccione un Diagnostico");
		etqSel.setBounds(258,13,290,31);//x,y,ancho,alto
        add(etqSel);

        //TextArea
        TA_sint = new JTextArea(" Aqui aparecera su Diagnostico");
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

        //radiobuttons
        anemia = new JRadioButton("Anemia");
        anemia.setBounds(10,70,150,31);
        add(anemia);
        artritis = new JRadioButton("Artritis");
        artritis.setBounds(10,110,160,31);
        add(artritis);
        anginas = new JRadioButton("Anginas");
        anginas.setBounds(10,150,150,31);
        add(anginas);
        diabetes = new JRadioButton("Diabetes");
        diabetes.setBounds(10,190,150,31);
        add(diabetes);
        catarro = new JRadioButton("Catarro");
        catarro.setBounds(10,230,150,31);
        add(catarro);
        asma = new JRadioButton("Asma");
        asma.setBounds(10,270,150,31);
        add(asma);
        osteo = new JRadioButton("Osteoporosis");
        osteo.setBounds(10,310,150,31);
        add(osteo);
        gastritis = new JRadioButton("Gastritis");
        gastritis.setBounds(180,70,150,31);
        add(gastritis);
        hiperten = new JRadioButton("Hipertensión");
        hiperten.setBounds(180,110,150,31);
        add(hiperten);
        alergias = new JRadioButton("Alergias");
        alergias.setBounds(180,150,150,31);
        add(alergias);
        Diagnosticos = new ButtonGroup();
        Diagnosticos.add(anemia);
        Diagnosticos.add(artritis);
        Diagnosticos.add(anginas);
        Diagnosticos.add(diabetes);
        Diagnosticos.add(catarro);
        Diagnosticos.add(asma);
        Diagnosticos.add(osteo);
        Diagnosticos.add(gastritis);
        Diagnosticos.add(hiperten);
        Diagnosticos.add(alergias);

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
        anemia.setBackground(new Color(255, 255, 255));
        anemia.setForeground(new Color(52,74,0));
        anemia.setFont(fuente2);
        artritis.setBackground(new Color(255, 255, 255));
        artritis.setForeground(new Color(52,74,0));
        artritis.setFont(fuente2);
        anginas.setBackground(new Color(255, 255, 255));
        anginas.setForeground(new Color(52,74,0));
        anginas.setFont(fuente2);
        diabetes.setBackground(new Color(255, 255, 255));
        diabetes.setForeground(new Color(52,74,0));
        diabetes.setFont(fuente2);
        catarro.setBackground(new Color(255, 255, 255));
        catarro.setForeground(new Color(52,74,0));
        catarro.setFont(fuente2);
        asma.setBackground(new Color(255, 255, 255));
        asma.setForeground(new Color(52,74,0));
        asma.setFont(fuente2);
        osteo.setBackground(new Color(255, 255, 255));
        osteo.setForeground(new Color(52,74,0));
        osteo.setFont(fuente2);
        gastritis.setBackground(new Color(255, 255, 255));
        gastritis.setForeground(new Color(52,74,0));
        gastritis.setFont(fuente2);
        hiperten.setBackground(new Color(255, 255, 255));
        hiperten.setForeground(new Color(52,74,0));
        hiperten.setFont(fuente2);
        alergias.setBackground(new Color(255, 255, 255));
        alergias.setForeground(new Color(52,74,0));
        alergias.setFont(fuente2);

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
        anemia.addChangeListener(this);
        artritis.addChangeListener(this);
        anginas.addChangeListener(this);
        diabetes.addChangeListener(this);
        catarro.addChangeListener(this);
        asma.addChangeListener(this);
        osteo.addChangeListener(this);
        gastritis.addChangeListener(this);
        hiperten.addChangeListener(this);
        alergias.addChangeListener(this);  
    }//FINAL DEL CONSTRUCTOR

    public void stateChanged(ChangeEvent accion){
        String enfer=" ";
        if (anemia.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=anemia.getText();}

        if (artritis.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=artritis.getText(); }

        if (anginas.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=anginas.getText(); }

        if (diabetes.isSelected()==true){TA_sint.setForeground(Color.BLACK); enfer=diabetes.getText(); }

        if (catarro.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=catarro.getText(); }

        if (asma.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=asma.getText(); }

        if (osteo.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=osteo.getText(); }

        if (gastritis.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=gastritis.getText(); }

        if (hiperten.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=hiperten.getText();; }

        if (alergias.isSelected()==true){ TA_sint.setForeground(Color.BLACK); enfer=alergias.getText(); }

        TA_sint.setText(" - "+ enfer);
        enfermedad = enfer;
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

        if(accion.getSource()==botEnv){
            if(enfermedad.equals(" ")){
                JOptionPane.showMessageDialog(null, "Seleccione sólo 1 síntoma", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            }else{
                Conexion_BD con_BD = new Conexion_BD();
                Sintoma.enfermedad = enfermedad;
                Sintoma.jugo = con_BD.ObtenerJugo(enfermedad);
                Sintoma.descripcion = con_BD.ObtenerDescricion(Sintoma.jugo);
                Sintoma.ingredientes = con_BD.ObtenerIngredientes(Sintoma.jugo);

                Jugos ventana4 = new Jugos();
                ventana4.setBounds(300,100,780,600);
                ventana4.setLocationRelativeTo(null);
		        ventana4.setVisible(true);
		        ventana4.setResizable(false);
                this.dispose();
            }
            
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
		Diagnostico ventana3 = new Diagnostico();
        ventana3.setBounds(300,100,780,600);
        ventana3.setLocationRelativeTo(null);
		ventana3.setVisible(true);
		ventana3.setResizable(false);
	}

}
