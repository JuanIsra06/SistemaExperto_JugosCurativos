import java.sql.*;

import javax.swing.JOptionPane;

import Rule.*;

public class Conexion_BD {
    Connection cn = null;
    PreparedStatement query = null;
    ResultSet rs = null;
    String[] bin_enfer= new String[10];
    String[] anemia= new String[4];
    String[] anginas= new String[4];
    String[] catarro= new String[4];
    String[] gastritis= new String[4];
    String[] alergias= new String[4];
    String[] artritis= new String[4];
    String[] diabetes= new String[4];
    String[] asma= new String[4];
    String[] osteoporosis= new String[4];
    String[] hiperten= new String[4];
    String AccionSQL="", anem="", ang="", cat="",gast="",aler="", res_enf="", res_jugo="", jugo, res_descripcion="",desc, res_ingre="",ingr, enf;
    int count;
    BooleanRuleBase basedereglas = new BooleanRuleBase("basedereglas");
    RuleVariable Sup_enfer, nomEnfer,ResultadoEnfermedad, ResultadoJugo, ResultadoDescr, ResultadoIngre;


    public void obt_inf_enfer(){
        try{
            //System.out.println("\n\nConectando a base de datos...");
    
            cn = DriverManager.getConnection("jdbc:mysql://localhost/se_jugos", "root", "");//Conexion a DATABASE
            //System.out.println("Conexión exitosa");
    
            AccionSQL = "Select * FROM enfermedad_jugos";
            query = cn.prepareStatement(AccionSQL);
            rs = query.executeQuery();
    
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                anemia[0]=enf; anemia[1]=jugo; anemia[2]=desc; anemia[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                anginas[0]=enf; anginas[1]=jugo; anginas[2]=desc; anginas[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                catarro[0]=enf; catarro[1]=jugo; catarro[2]=desc; catarro[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                gastritis[0]=enf; gastritis[1]=jugo; gastritis[2]=desc; gastritis[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                alergias[0]=enf; alergias[1]=jugo; alergias[2]=desc; alergias[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                artritis[0]=enf; artritis[1]=jugo; artritis[2]=desc; artritis[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                diabetes[0]=enf; diabetes[1]=jugo; diabetes[2]=desc; diabetes[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                asma[0]=enf; asma[1]=jugo; asma[2]=desc; asma[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                osteoporosis[0]=enf; osteoporosis[1]=jugo; osteoporosis[2]=desc; osteoporosis[3]=ingr;
            }
            if (rs.next()){
                enf = rs.getString("Enfermedades");
                jugo = rs.getString("Jugo");
                desc = rs.getString("Descripcion");
                ingr = rs.getString("Ingredientes");
                hiperten[0]=enf; hiperten[1]=jugo; hiperten[2]=desc; hiperten[3]=ingr;
            }
        }catch (Exception e) {
            System.out.println("algo salio mal: "+e.getMessage());
        }
        //return anemia;
    }
    
    public int obt_num_fil(){
        try{
            //System.out.println("\n\nConectando a base de datos...");
    
            cn = DriverManager.getConnection("jdbc:mysql://localhost/se_jugos", "root", "");//Conexion a DATABASE
            //System.out.println("Conexión exitosa");
    
            AccionSQL = "Select count(*) from enfermedad_sintomas";
            query = cn.prepareStatement(AccionSQL);
            rs = query.executeQuery();
            rs.next();
            count = rs.getInt(1);//Guarda cuantas filas tiene la base de datos
        }catch(Exception e){
            System.out.println("algo salio mal: "+e.getMessage());
        }
        return count;
        
    }

    public String[] obt_num_enfer(){
        try{
            //System.out.println("\n\nConectando a base de datos...");
    
            cn = DriverManager.getConnection("jdbc:mysql://localhost/se_jugos", "root", "");//Conexion a DATABASE
            //System.out.println("Conexión exitosa");
    
            AccionSQL = "Select * FROM enfermedad_sintomas";
            query = cn.prepareStatement(AccionSQL);
            rs = query.executeQuery();
    
            if (rs.next()){
                anem = rs.getString("Dolor de cabeza")+rs.getString("Dolor de estomago")+rs.getString("Flujo de moco")
                +rs.getString("Tos")+rs.getString("Dolor de garganta")+rs.getString("Fiebre")
                +rs.getString("Fatiga")+rs.getString("Mareos");
            }
            if (rs.next()){
                ang = rs.getString("Dolor de cabeza")+rs.getString("Dolor de estomago")+rs.getString("Flujo de moco")
                +rs.getString("Tos")+rs.getString("Dolor de garganta")+rs.getString("Fiebre")
                +rs.getString("Fatiga")+rs.getString("Mareos");
            }
            if (rs.next()){
                cat = rs.getString("Dolor de cabeza")+rs.getString("Dolor de estomago")+rs.getString("Flujo de moco")
                +rs.getString("Tos")+rs.getString("Dolor de garganta")+rs.getString("Fiebre")
                +rs.getString("Fatiga")+rs.getString("Mareos");
            }
            if (rs.next()){
                gast = rs.getString("Dolor de cabeza")+rs.getString("Dolor de estomago")+rs.getString("Flujo de moco")
                +rs.getString("Tos")+rs.getString("Dolor de garganta")+rs.getString("Fiebre")
                +rs.getString("Fatiga")+rs.getString("Mareos");
            }
            if (rs.next()){
                aler = rs.getString("Dolor de cabeza")+rs.getString("Dolor de estomago")+rs.getString("Flujo de moco")
                +rs.getString("Tos")+rs.getString("Dolor de garganta")+rs.getString("Fiebre")
                +rs.getString("Fatiga")+rs.getString("Mareos");
            }
            bin_enfer[0]=anem;
            bin_enfer[1]=ang;
            bin_enfer[2]=cat;
            bin_enfer[3]=gast;
            bin_enfer[4]=aler;
        }catch (Exception e) {
            System.out.println("algo salio mal: "+e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
        }
        return bin_enfer;
    }

    public void BDR(){
        Sup_enfer = new RuleVariable(basedereglas,"");
        nomEnfer = new RuleVariable(basedereglas,"");
        ResultadoEnfermedad = new RuleVariable(basedereglas,"");
        ResultadoJugo = new RuleVariable(basedereglas, "");
        ResultadoDescr = new RuleVariable(basedereglas,"");
        ResultadoIngre = new RuleVariable(basedereglas, "");

        Condition igual = new Condition("=");
        bin_enfer = obt_num_enfer();
        obt_inf_enfer();

        Rule regla1 = new Rule(basedereglas,"regla1",
        new Clause[]{
            new Clause(Sup_enfer, igual, bin_enfer[0])},
            new Clause(ResultadoEnfermedad, igual, "Anemia")
        );
        Rule regla2 = new Rule(basedereglas,"regla2",
        new Clause[]{
            new Clause(Sup_enfer, igual, bin_enfer[1])},
            new Clause(ResultadoEnfermedad, igual, "Anginas")
        );
        Rule regla3 = new Rule(basedereglas,"regla3",
        new Clause[]{
            new Clause(Sup_enfer, igual, bin_enfer[2])},
            new Clause(ResultadoEnfermedad, igual, "Catarro")
        );
        Rule regla4 = new Rule(basedereglas,"regla4",
        new Clause[]{
            new Clause(Sup_enfer, igual, bin_enfer[3])},
            new Clause(ResultadoEnfermedad, igual, "Gastritis")
        );
        Rule regla5 = new Rule(basedereglas,"regla5",
        new Clause[]{
            new Clause(Sup_enfer, igual, bin_enfer[4])},
            new Clause(ResultadoEnfermedad, igual, "Alergias")
        );
        Rule regla6 = new Rule(basedereglas, "regla6",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, anemia[0])},
            new Clause(ResultadoJugo, igual, anemia[1])
        );
        Rule regla7 = new Rule(basedereglas, "regla7",
        new Clause[]{
            new Clause(ResultadoJugo, igual, anemia[1])},
            new Clause(ResultadoDescr, igual, anemia[2]));
        Rule regla8 = new Rule(basedereglas, "regla8",
        new Clause[]{
            new Clause(ResultadoJugo, igual, anemia[1])},
            new Clause(ResultadoIngre, igual, anemia[3])
        );
        Rule regla9 = new Rule(basedereglas, "regla9",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, anginas[0])},
            new Clause(ResultadoJugo, igual, anginas[1])
        );
        Rule regla10 = new Rule(basedereglas, "regla10",
        new Clause[]{
            new Clause(ResultadoJugo, igual, anginas[1])},
            new Clause(ResultadoDescr, igual, anginas[2]));
        Rule regla11 = new Rule(basedereglas, "regla11",
        new Clause[]{
            new Clause(ResultadoJugo, igual, anginas[1])},
            new Clause(ResultadoIngre, igual, anginas[3])
        );
        Rule regla12 = new Rule(basedereglas, "regla12",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, catarro[0])},
            new Clause(ResultadoJugo, igual, catarro[1])
        );
        Rule regla13 = new Rule(basedereglas, "regla13",
        new Clause[]{
            new Clause(ResultadoJugo, igual, catarro[1])},
            new Clause(ResultadoDescr, igual, catarro[2]));
        Rule regla14 = new Rule(basedereglas, "regla14",
        new Clause[]{
            new Clause(ResultadoJugo, igual, catarro[1])},
            new Clause(ResultadoIngre, igual, catarro[3])
        );
        Rule regla15 = new Rule(basedereglas, "regla15",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, gastritis[0])},
            new Clause(ResultadoJugo, igual, gastritis[1])
        );
        Rule regla16 = new Rule(basedereglas, "regla16",
        new Clause[]{
            new Clause(ResultadoJugo, igual, gastritis[1])},
            new Clause(ResultadoDescr, igual, gastritis[2]));
        Rule regla17 = new Rule(basedereglas, "regla17",
        new Clause[]{
            new Clause(ResultadoJugo, igual, gastritis[1])},
            new Clause(ResultadoIngre, igual, gastritis[3])
        );
        Rule regla18 = new Rule(basedereglas, "regla18",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, alergias[0])},
            new Clause(ResultadoJugo, igual, alergias[1])
        );
        Rule regla19 = new Rule(basedereglas, "regla19",
        new Clause[]{
            new Clause(ResultadoJugo, igual, alergias[1])},
            new Clause(ResultadoDescr, igual, alergias[2]));
        Rule regla20 = new Rule(basedereglas, "regla20",
        new Clause[]{
            new Clause(ResultadoJugo, igual, alergias[1])},
            new Clause(ResultadoIngre, igual, alergias[3])
        );
        Rule regla21 = new Rule(basedereglas, "regla21",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, artritis[0])},
            new Clause(ResultadoJugo, igual, artritis[1])
        );
        Rule regla22 = new Rule(basedereglas, "regla22",
        new Clause[]{
            new Clause(ResultadoJugo, igual, artritis[1])},
            new Clause(ResultadoDescr, igual, artritis[2]));
        Rule regla23 = new Rule(basedereglas, "regla23",
        new Clause[]{
            new Clause(ResultadoJugo, igual, artritis[1])},
            new Clause(ResultadoIngre, igual, artritis[3])
        );
        Rule regla24 = new Rule(basedereglas, "regla24",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, diabetes[0])},
            new Clause(ResultadoJugo, igual, diabetes[1])
        );
        Rule regla25 = new Rule(basedereglas, "regla25",
        new Clause[]{
            new Clause(ResultadoJugo, igual, diabetes[1])},
            new Clause(ResultadoDescr, igual, diabetes[2]));
        Rule regla26 = new Rule(basedereglas, "regla26",
        new Clause[]{
            new Clause(ResultadoJugo, igual, diabetes[1])},
            new Clause(ResultadoIngre, igual, diabetes[3])
        );
        Rule regla27 = new Rule(basedereglas, "regla27",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, asma[0])},
            new Clause(ResultadoJugo, igual, asma[1])
        );
        Rule regla28 = new Rule(basedereglas, "regla28",
        new Clause[]{
            new Clause(ResultadoJugo, igual, asma[1])},
            new Clause(ResultadoDescr, igual, asma[2]));
        Rule regla29 = new Rule(basedereglas, "regla29",
        new Clause[]{
            new Clause(ResultadoJugo, igual, asma[1])},
            new Clause(ResultadoIngre, igual, asma[3])
        );
        Rule regla30 = new Rule(basedereglas, "regla30",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, osteoporosis[0])},
            new Clause(ResultadoJugo, igual, osteoporosis[1])
        );
        Rule regla31 = new Rule(basedereglas, "regla31",
        new Clause[]{
            new Clause(ResultadoJugo, igual, osteoporosis[1])},
            new Clause(ResultadoDescr, igual, osteoporosis[2]));
        Rule regla32 = new Rule(basedereglas, "regla32",
        new Clause[]{
            new Clause(ResultadoJugo, igual, osteoporosis[1])},
            new Clause(ResultadoIngre, igual, osteoporosis[3])
        );
        Rule regla33 = new Rule(basedereglas, "regla33",
        new Clause[]{
            new Clause(ResultadoEnfermedad, igual, hiperten[0])},
            new Clause(ResultadoJugo, igual, hiperten[1])
        );
        Rule regla34 = new Rule(basedereglas, "regla34",
        new Clause[]{
            new Clause(ResultadoJugo, igual, hiperten[1])},
            new Clause(ResultadoDescr, igual, hiperten[2]));
        Rule regla35 = new Rule(basedereglas, "regla35",
        new Clause[]{
            new Clause(ResultadoJugo, igual, hiperten[1])},
            new Clause(ResultadoIngre, igual, hiperten[3])
        );
    }

    public String ObtenerEnfermedad(String sup_enfer){
        BDR();
        Sup_enfer.setValue(sup_enfer);
        basedereglas.forwardChain();
        res_enf = ResultadoEnfermedad.getValue();
        return res_enf;
    }

    public String ObtenerJugo(String enfermedad){
        BDR();
        ResultadoEnfermedad.setValue(enfermedad);
        basedereglas.forwardChain();
        res_jugo = ResultadoJugo.getValue();
        return res_jugo;
    }

    public String ObtenerDescricion(String jugo){
        BDR();
        ResultadoJugo.setValue(jugo);
        basedereglas.forwardChain();
        res_descripcion = ResultadoDescr.getValue();
        return res_descripcion;
    }

    public String ObtenerIngredientes(String jugo){
        BDR();
        ResultadoJugo.setValue(jugo);
        basedereglas.forwardChain();
        res_ingre = ResultadoIngre.getValue();
        return res_ingre;
    }

    /*public void main(String args []){
        
        
    }*/
}
