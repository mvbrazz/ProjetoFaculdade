package trabalho;

public class Calcular {
    
    private double fosforo; 
    private int testuraSolo;
    private double teorFosforo;
    private int fonteFosforo;
    private double potassio;
    private double CTCPotassiodese;
    private double CTCPotassioatual;
    private double calcio; 
    private double teorCao;
    private int fonteCorretivo;
    private int eficienciaFosforo;
    private double PartiCalcioCTCDese;
    private double PartiCalcioCTCAtual;
     
    public Calcular(double fosforo,int testuraSolo,double teorFosforo,double potassio,double CTCPotassiodese ,double CTCPotassioatual,double calcio,double teorCao,
            int fonteCorretivo,int fonteFosforo,int eficienciaFosforo,double PartiCalcioCTCAtual,double PartiCalcioCTCDese){
        this.fosforo = fosforo;
        this.potassio = potassio;
        this.testuraSolo = testuraSolo;
        this.teorFosforo = teorFosforo;
        this.CTCPotassiodese = CTCPotassiodese;
        this.CTCPotassioatual = CTCPotassioatual;
        this.calcio = calcio;
        this.teorCao = teorCao;
        this.fonteCorretivo = fonteCorretivo;
        this.fonteFosforo = fonteFosforo;
        this.eficienciaFosforo = eficienciaFosforo;
        this.PartiCalcioCTCDese = PartiCalcioCTCDese;
        this.PartiCalcioCTCAtual = PartiCalcioCTCAtual;
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
            aux = potassio*CTCPotassiodese;
            aux = aux/CTCPotassioatual;
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
    
    public double calcularCorreCalcio(){
        double aux1 = 0;
        double aux2 = 0;
        double aux3 = 0;
        
        //i107
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
                   aux1 = 75.7 * 0.01783;
               break;
               case 6:
                   aux1 = 35 * 0.01783;
               break;
                                    
           } 
           
       }
       //p129
       aux2 = teorFosforo - fosforo;
       System.out.printf("%f",aux2);
       if(aux2 < 0.01){
           return 0;
       }
       else{
           aux2 = aux2 * 2;
           System.out.printf("%f",aux2);
           aux2 = aux2 * 2.29;
           System.out.printf("%f",aux2);
           aux2 = aux2*100;
           System.out.printf("%f",aux2);
           aux2 = aux2 / eficienciaFosforo;
           System.out.printf("%f",aux2);
           aux2 = aux2 / 100;
           System.out.printf("%f",aux2);
           switch(fonteFosforo){ 
               case 1:
                   aux2 = (aux2*100)/18; //AL40 
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.28; //M22
                   aux2 = aux2/2.42; //P109
                   aux2 = (aux2 +0.49924)/1000; // 0. AM40
                break;
               case 2:
                   aux2 = (aux2*100)/41;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.20;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0.33877)/1000;
                break;
                case 3:
                   aux2 = (aux2*100)/48;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.09;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0)/1000;
                break;
                case 4:
                   aux2 = (aux2*100)/45;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.16;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0)/1000;
                break;
                case 5:
                   aux2 = (aux2*100)/18;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.28;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0.49924)/1000;
                break;
                case 6:
                   aux2 = (aux2*100)/33;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.52;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0.92716)/1000;
                break;
                case 7:
                   aux2 = (aux2*100)/29;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.52;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0.92716)/1000;
                break;
                case 8:
                   aux2 = (aux2*100)/32;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.45;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0.80235)/1000;
                break;
                case 9:
                   aux2 = (aux2*100)/24;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.28;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0.49924)/1000;
                break;
                case 10:
                   aux2 = (aux2*100)/18.5;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.44;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0.795218)/1000;
                break;
                case 11:
                   aux2 = (aux2*100)/52;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0)/1000;
                break;
                case 12:
                   aux2 = (aux2*100)/18;
                   aux2 = aux2*2.42;
                   aux2 = aux2*0.18;
                   aux2 = aux2/2.42;
                   aux2 = (aux2 +0)/1000;
                break;   
            } //I105
            
            aux1 = aux1 + aux2;
            
            
            aux3 = (calcio*PartiCalcioCTCDese) / PartiCalcioCTCAtual - (calcio-aux2);
            
            aux3 = aux3 / aux1;
            
            if(aux3 > 0.001 && aux3 > 0.0001){
                aux3 = aux3;
            }
            else{
                aux3 = 0;
            }
            
            aux1 = aux1 * aux3;
            aux1 = aux1 + aux2;
            aux1 = aux1 + calcio;
            
            
            return aux1;
           
       }
    }

    
}   

