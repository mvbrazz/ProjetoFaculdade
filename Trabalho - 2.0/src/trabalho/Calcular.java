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
    private double magnesio;
    private int fontePotassio;
    private double quantidadeAplicadaPotassio;
    private double quantidadeAplicadaFosforo;
    private double precoFosforo;
    private double precoPotassio;
     
    public Calcular(double fosforo,int testuraSolo,double teorFosforo,double potassio,double CTCPotassiodese ,double CTCPotassioatual,double calcio,double teorCao,
            int fonteCorretivo,int fonteFosforo,int eficienciaFosforo,double PartiCalcioCTCAtual,double PartiCalcioCTCDese,double magnesio,
            int fontePotassio,double precoFosforo,double precoPotassio){
           
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
        this.magnesio = magnesio;
        this.fontePotassio = fontePotassio;
        this.precoFosforo = precoFosforo;
        this.precoPotassio = precoPotassio; 
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
       if(aux2 < 0.01){
           return 0;
       }
       else{
           aux2 = aux2 * 2;
           aux2 = aux2 * 2.29;
           aux2 = aux2*100;
           aux2 = aux2 / eficienciaFosforo;
           aux2 = aux2 / 100;
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
            
            if(aux3 > 0.001){
                aux1 = aux1 * aux3;
                aux1 = aux1 + aux2;
                aux1 = aux1 + calcio;            
            
            return aux1;
            }
            else{
                aux3 = 0;
                aux1 = aux1 * aux3;
                aux1 = aux1 + aux2;
                aux1 = aux1 + calcio;
            
            
            return aux1;
            }           
       }
    }

    //calcular magnesio
    public String calcularIdealMagnesio(){
        if(testuraSolo == 1){
            return String.valueOf(1.5);
        }
        else{
            return String.valueOf(1.0);
        }
    }
    
    public double quantidadeAplicaPotassio(){
        double aux;
        
        aux = (potassio*CTCPotassiodese) / (CTCPotassioatual - potassio);
        
        if(aux >= 0.01){
            aux = aux * 39.1 * 10;
            aux *= 2;
            aux *= 1.2;
        }
        else{
            aux = 0;
        }
        aux = aux * 100 / 85 / 100;
        
        switch(fontePotassio){
            case 1:
                aux = aux * 100 / 58;
                break;
            case 2:
                aux = aux * 100 / 52;
                break;
            case 3:
                aux = aux * 100 / 22;
                break;
            case 4:
                aux = aux * 100 / 44;
                break;
            default:
                aux = aux * 100 / 0;
                break;
        }

        quantidadeAplicadaPotassio = aux;
        return quantidadeAplicadaPotassio;
    }
    
    public double calcularCorreMagnesio(){//double calcularCorreMagnesio(){
        double aux=0;
        double aux2=0;
        double aux3=0;
        double aux4=0;
        double m60=0;
        double o66=0;        
        
        aux = teorFosforo - fosforo;
        //Q72
        if(aux < 0.01){  
             return 0.0;    
        }
        else{ //H16
             aux = aux * 2;
             aux = aux * 2.29;
             aux = ((aux *100)/eficienciaFosforo)/100; 
             
             
             switch(fonteFosforo){
                case 1:
                     aux = (aux * 100)/18; //B22
                     aux = aux*2.42;  //B24
                     aux = aux*0.28;  //M22
                     aux = aux/2.42;  //P129
                     aux =(aux *0.49924)/1000; //AM40
                     break;
                case 2:
                     aux = (aux * 100)/41;
                     aux = aux*2.42;
                     aux = aux*0.2;
                     aux = aux/2.42;
                     aux =(aux *0.33877)/1000;
                     break;
                case 3:
                     aux = (aux * 100)/48;
                     aux = aux*2.42;
                     aux = aux*0.09;
                     aux = aux/2.42;
                     aux =(aux *0.0)/1000;
                     break;
                case 4:
                     aux = (aux * 100)/45;
                     aux = aux*2.42;
                     aux = aux*0.16;
                     aux = aux/2.42;
                     aux =(aux *0.0)/1000;
                     break;
                case 5:
                     aux = (aux * 100)/18;
                     aux = aux*2.42;
                     aux = aux*0.28;
                     aux = aux/2.42;
                     aux =(aux *0.49924)/1000;
                     break;
                case 6:
                     aux = (aux * 100)/33;
                     aux = aux*2.42;
                     aux = aux*0.52;
                     aux = aux/2.42;
                     aux =(aux *0.92716)/1000;
                     break;
                case 7:
                     aux = (aux * 100)/29;
                     aux = aux*2.42;
                     aux = aux*0.52;
                     aux = aux/2.42;
                     aux =(aux *0.92716)/1000;
                     break;
                case 8:
                     aux = (aux * 100)/32;
                     aux = aux*2.42;
                     aux = aux*0.45;
                     aux = aux/2.42;
                     aux =(aux *0.80235)/1000;
                     break;
                case 9:
                     aux = (aux * 100)/24;
                     aux = aux*2.42;
                     aux = aux*0.28;
                     aux = aux/2.42;
                     aux =(aux *0.49924)/1000;
                     break;
                case 10:
                     aux = (aux * 100)/18.5;
                     aux = aux*2.42;
                     aux = aux*0.44;
                     aux = aux/2.42;
                     aux =(aux *0.795218)/1000;
                     break;
                case 11:
                     aux = (aux * 100)/52;
                     aux = aux*2.42;
                     aux = aux*0;
                     aux = aux/2.42;
                     aux =(aux *0.0)/1000;
                     break;
                case 12:
                     aux = (aux * 100)/18;
                     aux = aux*2.42;
                     aux = aux*0.18;
                     aux = aux/2.42;
                     aux =(aux *0.0)/1000;
                     break;
             }  
             
             aux2 = (calcio*PartiCalcioCTCDese)/(PartiCalcioCTCAtual-(calcio-aux));
             
             //I 105
             if(teorCao > 0.01){
                 aux3 = teorCao*0.01783;
             }
             else{
                 switch(fonteCorretivo){
                    case 1:
                         aux3 = 30.4*0.01783;
                         break;
                    case 2:
                         aux3 = 56*0.01783;
                         break;
                    case 3:
                         aux3 = 54*0.01783;
                         break;
                    case 4:
                         aux3 = 29*0.01783;
                         break;
                    case 5:
                         aux3 = 75.7*0.01783;
                         break;
                    case 6:
                         aux3 = 35*0.01783;
                         break;     
                 }
                 
             }
                
            aux2 = aux2/(aux3+aux);
             
            if(aux2 > 0.001 && aux2 >13){
                aux4 = aux2;
            }
            else{
                 aux4 = 0;
            }
            switch(fonteCorretivo){
                case 1:
                    m60 = 18*0.0248*aux4;
                    break;
                case 2:
                    m60 = 5*0.0248*aux4;
                    break;
                case 6:
                    m60 = 10*0.0248*aux4;
                    break;        
            } 
            if(fontePotassio==3){
                o66 = ((quantidadeAplicaPotassio()*0.0248)*18)/1000;
                
                o66 = 066*0.6;        
            } 
            else{
                o66 = 0;
            }
            if(fontePotassio==5){
                aux = magnesio+m60+o66+(0.0248*15);
                return aux;
            }
            else{
                aux = magnesio+m60+o66+0;
                return aux;
            }
             
        }

    }
    
    public double quantidadeAplicarFosforo(){
        
        double resultado;
        
        resultado = teorFosforo - fosforo; //E10
        //Q72
        
        if(resultado < 0.01){  
             resultado = 0.0;    
        }
        else{ //H16
             resultado *= 2;
             resultado *= 2.29;         
             resultado = ((resultado *100)/eficienciaFosforo)/100;
             
             switch(fonteFosforo){ // Conta para o B22
                 case 1:
                     resultado = resultado * 100 / 18;
                     
                     break;
                 case 2:
                     resultado = resultado * 100 / 41;
                     break;
                 case 3:
                     resultado = resultado * 100 / 48;
                     break;
                 case 4:
                     resultado = resultado * 100 / 45;
                     break;
                 case 5:
                     resultado = resultado * 100 / 18;
                     break;  
                 case 6:
                     resultado = resultado * 100 / 33;
                     break;
                 case 7:
                     resultado = resultado * 100 / 29;
                     break;
                 case 8:
                     resultado = resultado * 100 / 32;
                     break;
                 case 9:
                     resultado = resultado * 100 / 24;
                     break;
                 case 10:
                     resultado = resultado * 100 / 18.5;
                     break;
                 case 11:
                     resultado = resultado * 100 / 52;
                     break;
                 case 12:
                     resultado = resultado * 100 / 18;
                     break;        
             }
                  
        }
        return resultado*100;  
    }   
    
    public double quantidadeCorrecaoFosforo1(){
        double resultado;
                
        if(fonteFosforo == 5){
            resultado = quantidadeAplicarFosforo() * 0.15;

        }
        else{
            resultado = quantidadeAplicarFosforo() * 2.42;
            if(fonteFosforo == 1){
                resultado *= 0.1;
                resultado /= 2.42;
            }
            else if(fonteFosforo == 12){
                resultado *= 0.11;   
                resultado /= 2.42;
            }
            else{
                resultado = 0;
                resultado /= 2.42;
            }
                

        }
        return resultado;
    }
    
    public String tipoDaCorreção1(){
        if(fonteFosforo == 1 || fonteFosforo == 12){
            return "Enxofre";
        }
        else if(fonteFosforo == 5){
            return "Magnésio";
        }
        else{
            return null;
        }
    }
    
    public String tipoDaCorreção2(){
        if(fonteFosforo == 1 || fonteFosforo == 2 || fonteFosforo == 5 || 
           fonteFosforo == 6 || fonteFosforo == 7 || fonteFosforo == 8 || 
           fonteFosforo == 9 || fonteFosforo == 10 || fonteFosforo == 12){
            return "Cálcio";
        }
        else if(fonteFosforo == 3 || fonteFosforo == 4){
            return "Nitrogênio";
        }
        else{
            return null;
        }
    }
    
    public double quantidadeCorrecaoFosforo2(){
        double resultado;
             
            resultado = quantidadeAplicarFosforo() * 2.42; //Melho metodo
            switch(fonteFosforo){
                case 1:
                    resultado *= 0.28;
                    resultado /= 2.42;
                    break;
                case 2:
                    resultado *= 0.2;
                    resultado /= 2.42;
                    break;
                case 3:
                    resultado *= 0.09;
                    resultado /= 2.42;
                    break;
                case 4:
                    resultado *= 0.16;
                    resultado /= 2.42;
                    break;
                case 5:
                    resultado *= 0.28;
                    resultado /= 2.42;
                    break;
                case 6:
                    resultado *= 0.52;
                    resultado /= 2.42;
                    break; 
                case 7:
                    resultado *= 0.52;
                    resultado /= 2.42;
                    break;
                case 8:
                    resultado *= 0.45;
                    resultado /= 2.42;
                    break;
                case 9:
                    resultado *= 0.28;
                    resultado /= 2.42;
                    break; 
                case 10:
                    resultado *= 0.44;
                    resultado /= 2.42;
                    break;
                case 11:
                    resultado *= 0.0;
                    resultado /= 2.42;
                    break;
                case 12:
                    resultado *= 0.18;
                    resultado /= 2.42;
                    break;     
        }    
        
        return resultado;
    }
    
    public double calcularCustoFosforo(){
        double aux =0;
        double aux2 = quantidadeAplicarFosforo() * 2.42;
        switch(fonteFosforo){
            case 1:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 2:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 3:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 4:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 5:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break; 
            case 6:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 7:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 8:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break; 
            case 9:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 10:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;
            case 11:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break; 
            case 12:
                aux = ((precoFosforo * aux2) /1000)/2.42;
                break;   
        }
        return aux*1000;
    }
    
    public double quantidadeAplicarPotassio(){
        double aux;
        
        aux = (CTCPotassioatual - potassio) / (potassio*CTCPotassiodese);
        
        if(aux < 0.01){
            aux = 0.0;
        }
        
        aux = (aux * 39.1) * 10;
        aux *= 2;
        aux *=1.2;
        aux = aux * 100 / 85 / 100;

        switch(fontePotassio){
            case 1:
                aux = aux * 100 / 58;

                break;
            case 2:
                aux = aux * 100 / 52;
                break;
            case 3:
                aux = aux * 100 / 22;
                break;
            case 4:
                aux = aux * 100 / 44;
                break;  
            default:
                aux = aux * 100 / 0.0;
                break;     
        }
        return aux;
         
    }
    
    public double calcularCustoPotassio(){
        
        double aux = quantidadeAplicarPotassio();
        double m44;
        double resultado =0;
        
        if(testuraSolo == 1){
            m44 = 70;
        }
        else{
            m44 = 50;
        }
        
        switch(fontePotassio){
            case 1:
                resultado = precoPotassio * (aux*2.42) / 1000;
                resultado = resultado / 2.42;
                break;
            case 2:   
                resultado = precoPotassio * (aux*2.42) / 1000;
                resultado = resultado / 2.42;
                break;
            case 3:
                resultado = precoPotassio * (aux*2.42) / 1000;
                resultado = resultado / 2.42;
                break;
            case 4:
                resultado = m44 * (aux*2.42) / 1000;
                resultado = resultado / 2.42;
                
        }
        System.out.println(resultado);
        return resultado;
    }
}  


