package Projeto;
import java.text.DecimalFormat;

public class Calculos {

    //private String arredondar(Double valor) {
        //return new DecimalFormat("###,##0.00").format(valor);
    //}    
    
    private double calculaNecessidadeKaAdicionar(double potassio,double CTCPotaDesejado,double CTCPotaAtual){  //f51
	return potassio*CTCPotaDesejado/CTCPotaAtual-potassio;
    }
    
    private double calculaB22(double teorFosforo,double fosforo,double eficienciaFosforo,int fonteFosforo){  //f51
	double B22 = teorFosforo-fosforo;

        if(B22 < 0.01){
            B22 = 0;
        }
        else{
            B22 *= 2;
            B22 *= 2.29;
            B22 *= 100;
            B22 /= eficienciaFosforo;
            B22 /= 100;
            
            switch(fonteFosforo){
                case 1:
                     B22 = (B22 * 100)/18; //B22
                     break;
                case 2:
                     B22 = (B22 * 100)/41;
                     break;
                case 3:
                     B22 = (B22 * 100)/48;
                     break;
                case 4:
                     B22 = (B22 * 100)/45;
                     break;
                case 5:
                     B22 = (B22 * 100)/18;
                     break;
                case 6:
                     B22 = (B22 * 100)/33;
                     break;
                case 7:
                     B22 = (B22 * 100)/29;
                     break;
                case 8:
                     B22 = (B22 * 100)/32;
                     break;
                case 9:
                     B22 = (B22 * 100)/24;
                     break;
                case 10:
                     B22 = (B22 * 100)/18.5;
                     break;
                case 11:
                     B22 = (B22 * 100)/52;
                     break;
                case 12:
                     B22 = (B22 * 100)/18;
                     break;
            }
        
        }
        return B22;    
    }
    
    private double calcularM22(double teorFosforo,double fosforo,double eficienciaFosforo,int fonteFosforo){
        double M22 = calculaB22(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo)*2.42;
        switch(fonteFosforo){
            case 1:
                M22 = M22*0.28;
                break;
            case 2:
                M22 = M22*0.2;
                break;    
            case 3:
                M22 = M22*0.09;
                break;        
            case 4:
                M22 = M22*0.16;
                break;
            case 5:    
                M22 = M22*0.28;
                break;        
            case 6:
                M22 = M22*0.52;
                break;        
            case 7:
                M22 = M22*0.52;
                break;        
            case 8: 
                M22 = M22*0.45;
                break;        
            case 9:
                M22 = M22*0.28;
                break;
            case 10:
                M22 = M22*0.44;
                break;
            case 11:
                M22 = M22*0;
                break;        
            case 12:
                M22 = M22*0.18;
                break;        
        }
        return M22;
    }
    
    private double calculaI107(double teorDeCaO,int fonteCorretivoCalMag){
        double I107 = 0.0;
        
        if(teorDeCaO > 0.01){
            I107 = teorDeCaO;
        }    
        else{
            switch(fonteCorretivoCalMag){
                case 1:
                    I107 = 30.4;
                    break;
                case 2:
                    I107 = 56;
                    break;
                case 3:
                    I107 = 54;
                    break;
                case 4:
                    I107 = 29;
                    break;
                case 5:
                    I107 = 75.7;
                    break;
                case 6:
                    I107 = 35;
                    break;    
            } 
        }
        return I107 = I107*0.01783;
    }
    
    private double calculaI105(double teorFosforo,double fosforo,double eficienciaFosforo,int fonteFosforo){
        double I105 = calcularM22(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo)/2.42;
        
        switch(fonteFosforo){
            case 1:
                I105 =(I105 *0.49924)/1000;
                break;
            case 2:
                I105 =(I105 *0.33877)/1000;
                break;
            case 3:
                I105 =(I105 *0.0)/1000;
                break;
            case 4:
                I105 =(I105 *0.0)/1000;
                break;
            case 5:
                I105 =(I105 *0.49924)/1000;
                break;
            case 6:
                I105 =(I105 *0.92716)/1000;
                break;
            case 7:
                I105 =(I105 *0.92716)/1000;
                break;
            case 8:
                I105 =(I105 *0.80235)/1000;
                break;
            case 9:
                I105 =(I105 *0.49924)/1000;
                break;
            case 10:
                I105 =(I105 *0.795218)/1000;
                break;
            case 11:
                I105 =(I105 *0.0)/1000;
                break;
            case 12:
                I105 =(I105 *0.0)/1000;
                     break;
        }      
        return I105;
    } //erro?
    
    private double calculaC66(double potassio,double CTCPotaDesejado,double CTCPotaAtual,int fontePotassio){
        double C66;
        double G62=0;
        
        if(calculaNecessidadeKaAdicionar(potassio,CTCPotaDesejado,CTCPotaAtual) >= 0.01){
            C66 = calculaNecessidadeKaAdicionar(potassio,CTCPotaDesejado,CTCPotaAtual);     
        }
        else{
            C66 = 0;
        }
        C66 = C66*39.1*10;
        C66 *= 2;
        C66 *= 1.2;
        C66 = ((C66*100)/85)/100;
        
        switch(fontePotassio){
            case 1:
                G62 = 58;
                break;
            case 2:
                G62 = 52;
                break;
            case 3:
                G62 = 22;
                break;
            case 4:
                G62 = 44;
                break;
        }
        return C66*100/G62;
        
    }
    
    private double calculaQuantidadeCorretivoAImcorporar(double calcio,double calcioCTCDesejada,double calcioCTCAtual,
                                                         double teorFosforo,double fosforo,double eficienciaFosforo,
                                                         int fonteFosforo,double teorDeCaO,int fonteCorretivoCalMag){
        
        double quantidade = calcio*calcioCTCDesejada/calcioCTCAtual-(calcio-calculaI105(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo));
        System.out.println(quantidade);
        quantidade = quantidade / (calculaI107(teorDeCaO,fonteCorretivoCalMag) + calculaI105(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo));
 
        if(quantidade > 0.0001 ){  // Ajuda
            return quantidade;        
        }
        else{
            return 0.0;
        }
    }
    
    public double calculaFosforoCorrigido(double teorFosforo){
	if(teorFosforo > 0.01){
        	return teorFosforo;
	}
	else{
		return 0.0;
	}
    }
    
    public double calculaPotassioCorrigido(double potassio,double CTCPotaDesejado,double CTCPotaAtual){

	if(potassio > 0.5){ 
		return potassio;
	}
	else{ 
		if(calculaNecessidadeKaAdicionar(potassio,CTCPotaDesejado,CTCPotaAtual) < 0.01){
			return potassio;
		}
		else{
			return calculaNecessidadeKaAdicionar(potassio,CTCPotaDesejado,CTCPotaAtual)+potassio;
		}
	}
    }
    
    public double calculaCalcioCorrigido(double calcio,double teorDeCaO,int fonteCorretivoCalMag,  // Dar uma olhada depois
                                         double teorFosforo,double fosforo,double eficienciaFosforo,
                                         int fonteFosforo,double calcioCTCDesejada,double calcioCTCAtual){
        
        double calcioCorrigido = calculaI107(teorDeCaO,fonteCorretivoCalMag)+calculaI105(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo);    
        double resultado;
        
        resultado = calculaQuantidadeCorretivoAImcorporar(calcio,calcioCTCDesejada,calcioCTCAtual,teorFosforo,fosforo,eficienciaFosforo,fonteFosforo,teorDeCaO,fonteCorretivoCalMag)/calcioCorrigido;
        resultado *= calcioCorrigido;
        resultado += calculaI105(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo);
        System.out.printf("resultado: %f",resultado);

        return resultado;

    }   
    
    public double calculaMagnesioCorrigido(double magnesio,int fonteCorretivoCalMag,double calcio,double calcioCTCDesejada,double calcioCTCAtual,
                                                         double teorFosforo,double fosforo,double eficienciaFosforo,int fonteFosforo,double teorDeCaO,int fontePotassio,
                                                         double potassio,double CTCPotaDesejado,double CTCPotaAtual){
        double M60;
        double O66;
        double N70;
        double T70 = calculaQuantidadeCorretivoAImcorporar(calcio,calcioCTCDesejada,calcioCTCAtual,
                                                         teorFosforo,fosforo,eficienciaFosforo,
                                                         fonteFosforo,teorDeCaO,fonteCorretivoCalMag);                                         
                                                         
        switch(fonteCorretivoCalMag){
            case 1:
                M60 = 18*(0.0248*T70);
                break;
            case 2:    
                M60 = 5*(0.0248*T70);
                break;
            case 6:
                M60 = 10*(0.0248*T70);
                break;
            default:
                M60 = 0.0;
                break;
        }
        
        if(fontePotassio == 3){
            
            O66 = 18*0.0248*(calculaC66(potassio,CTCPotaDesejado,CTCPotaAtual,fontePotassio)/1000);
            O66 = O66*0.6;
        
        }
        else{
            O66 = 0.0;
        }
        
        if(fonteFosforo == 5){
            N70 = 0.0248*15;
            N70 *= 0.6; 
        }
        else{
            N70 = 0.0;
            N70 *= 0.6; 
        }
        return magnesio+M60+O66+N70;
}
    
    
    // Calculos Cmol
    
    public double calculaScmol(double calcio,double magnesio,double potassio){
        double total = calcio+magnesio+potassio;
        if(total > 0.01){
            return total;
        }        
        else{ 
            return 0.0;
        }             
    }
    
    public double calculaCTCcmol(double calcio,double magnesio,double potassio,double H_AL){
        double total = calculaScmol(calcio,magnesio,potassio)+H_AL;
        if(total > 0.01){
            return total;
        }        
        else{ 
            return 0.0;
        }             
    }
    
    public double calculaVAtual(double calcio,double magnesio,double potassio,double H_AL){
        return (100 * calculaScmol(calcio,magnesio,potassio))/calculaCTCcmol(calcio,magnesio,potassio,H_AL);
    }
    
    public double calculaMoPerc(double mo){
        
        if(mo >0.01){
            return mo/10;
        }
        else{
            return 0;
        }
    }
    
    public double calculaCarbono(double mo){
        
        if(mo >0.01){
            return calculaMoPerc(mo)/1.72*10;
        }
        else{
            return 0.0;
        }
    }
    
    // Calculos Fósforo
    
    public double calculaQuantidadeAplicarFosforo(double fosforo,double teorFosforo,int fonteFosforo,double eficienciaFosforo){
        double H16;
        H16 = teorFosforo-fosforo;
        
        if(H16 > 0.01){
            H16 *= 2;
            H16 *= 2.29;
            H16 = H16*100/eficienciaFosforo/100;
        }
        else{
            H16 = 0.0;
            H16 *= 2;
            H16 *= 2.29;
            H16 = H16*100/eficienciaFosforo/100;
        }
        
        switch(fonteFosforo){
            case 1:
                H16 = H16*100/18;
                break;
            case 2:
                H16 = H16*100/41;
                break; 
            case 3:
                H16 = H16*100/48;
                break;
            case 4:
                H16 = H16*100/45;
                break; 
            case 5:
                H16 = H16*100/18;
                break;
            case 6:
                H16 = H16*100/33;
                break; 
            case 7:
                H16 = H16*100/29;
                break;
            case 8:
                H16 = H16*100/32;
                break; 
            case 9:
                H16 = H16*100/24;
                break;
            case 10:
                H16 = H16*100/18.5;
                break; 
            case 11:
                H16 = H16*100/52;
                break;
            case 12:
                H16 = H16*100/18;
                break;    
        }        
        return H16*100;
    }
    
    public double calculaQuantidadeCorrecaoFosforo1(double fosforo,double teorFosforo,int fonteFosforo,double eficienciaFosforo){
        double resultado;
                
        if(fonteFosforo == 5){
            resultado = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 0.15;
        }
        else{
            resultado = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 2.42;
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
    
    public String calculaTipoDaCorreção1(double fonteFosforo){
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
    
    public String calculaTipoDaCorreção2(double fonteFosforo){
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
    
    public double calculaQuantidadeCorrecaoFosforo2(double fosforo,double teorFosforo,int fonteFosforo,double eficienciaFosforo){
        double resultado;
             
            resultado = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 2.42; //Melho metodo
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
    
    public double calculaCustoFosforo(double fosforo,double teorFosforo,int fonteFosforo,double eficienciaFosforo,double precoFosforo){
        
        double resultado = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 2.42;
        
        switch(fonteFosforo){
            case 1:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 2:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 3:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 4:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 5:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break; 
            case 6:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 7:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 8:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break; 
            case 9:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 10:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;
            case 11:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break; 
            case 12:
                resultado = ((precoFosforo * resultado) /1000)/2.42;
                break;   
        }
        return resultado*1000;
    }
    
    
}
