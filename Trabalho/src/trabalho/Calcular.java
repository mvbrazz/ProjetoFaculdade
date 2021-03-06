package trabalho;

public class Calcular {
    
    private double fosforo; 
    private int testuraSolo;
    private double teorFosforo;
    private int fonteSolo;
    private double potassio;
    private double CTCdese;
    private double CTCatual;
    private double calcio; 
    private double teorCao;
    private int fonteCorretivo;
     
    public Calcular(double fosforo,int testuraSolo,double teorFosforo,double potassio,double CTCdese ,double CTCatual,double calcio,double teorCao,
            int fonteCorretivo){
        this.fosforo = fosforo;
        this.potassio = potassio;
        this.testuraSolo = testuraSolo;
        this.teorFosforo = teorFosforo;
        this.CTCdese = CTCdese;
        this.CTCatual = CTCatual;
        this.calcio = calcio;
        this.teorCao = teorCao;
        this.fonteCorretivo = fonteCorretivo;
    }
    
    //Calculos do Fosforo
    public String calcularIdealFosforo(){
        if(testuraSolo == 1){
            return String.valueOf(9.0);
        }
        else{
            return String.valueOf(12.0);
        }
    }
    
    public String calcularCorreFosforo(){
             
        if(teorFosforo > 0.01){
            return String.valueOf(teorFosforo);
            
        }
        else{
            return String.valueOf(fosforo);
        }
       
    }
    
    //Calculos do potassio
    public String calcularIdealPotassio(){
        if(testuraSolo == 1){
            return String.valueOf(0.35);
        }
        else{
            return String.valueOf(0.25);
        }
    }
    
    public String calcularCorrePotassio(){
        double aux;
        
        if(potassio > 0.5){
            return String.valueOf(potassio);
            
        }
        else{
            aux = potassio*CTCdese;
            aux = aux/CTCatual;
            aux = aux - potassio;
            
            if( aux < 0.01){
                return String.valueOf(potassio);
            }
            else{
                aux = aux + potassio;
                return String.valueOf(aux);
            }
        }
       
    }
    
    //calcular calcio
    public String calcularIdealCalcio(){
        if(testuraSolo == 1){
            return String.valueOf(6.0);
        }
        else{
            return String.valueOf(4.0);
        }
    }
    
    public void calcularCorreCalcio(){
        double aux1;
        double aux2;
        
        
       if(teorCao > 0.01){
           aux1 = teorCao*0.01783;
       }
       else{
           switch(fonteCorretivo){
               case 1:
                   aux1 = 30.4 * 0.01783;
               break;
               case 2:
                   aux1 = 56 * 0.01783;
               break;
               case 3:
                   aux1 = 54 * 0.01783;
               break;
               case 4:
                   aux1 = 29 * 0.01783;
               break;
               case 5:
                   aux1 = 75 * 0.01783;
               break;
               case 6:
                   aux1 = 35 * 0.01783;
               break;
                                    
           }
           
           
       }
    }
    
}   

