package Projeto;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculos {
    
    //Funções auxiliares.
    
    public double [] dadosFonteFosforo(int fonteFosforo){
        double vet[] = new double[5];
        
        switch(fonteFosforo){
            case 1:
                vet[0] = 18;
                vet[1] = 0.28;
                vet[2] = 0.49924;
                break;
            case 2:    
                vet[0] = 41;
                vet[1] = 0.2;
                vet[2] = 0.33877;
                break;
            case 3:
                vet[0] = 48;
                vet[1] = 0.09;
                vet[2] = 0.0;
                break;
            case 4:
                vet[0] = 45;
                vet[1] = 0.16;
                vet[2] = 0.0;
                break;
            case 5:
                vet[0] = 18;
                vet[1] = 0.28;
                vet[2] = 0.49924;
                break;
            case 6:
                vet[0] = 33;
                vet[1] = 0.52;
                vet[2] = 0.92716;
                break;
            case 7:
                vet[0] = 29;
                vet[1] = 0.52;
                vet[2] = 0.92716;
                break;
            case 8:
                vet[0] = 32;
                vet[1] = 0.45;
                vet[2] = 0.80235;
                break;
            case 9:
                vet[0] = 24;
                vet[1] = 0.28;
                vet[2] = 0.49924;
                break;
            case 10:
                vet[0] = 18.5;
                vet[1] = 0.44;
                vet[2] = 0.795218;
                break;
            case 11:
                vet[0] = 52;
                vet[1] = 0;
                vet[2] = 0.0;
                break;
            case 12:
                vet[0] = 18;
                vet[1] = 0.18;
                vet[2] = 0.0;
                break;
            }    

        return vet;

    }
    
    public double [] dadosFonteCalMag(int fonteCorretivoCalMag){
        double vet[] = new double[3];
        
        switch(fonteCorretivoCalMag){
            case 1:
                vet[0] = 30.4;
                vet[1] = 0.28;
                vet[2] = 18;
                break;
            case 2:    
                vet[0] = 56;
                vet[1] = 0.2;
                vet[2] = 5;
                break;
            case 3:
                vet[0] = 54;
                vet[1] = 0.09;
                break;
            case 4:
                vet[0] = 29;
                vet[1] = 0.16;
                break;
            case 5:
                vet[0] = 75.7;
                vet[1] = 0.28;
                break;
            case 6:
                vet[0] = 35;
                vet[1] = 0.52;
                vet[2] = 10;
                break;
            }    

        return vet;

    }
    
    public double [] dadosFontePotassio(int fontePotassio){
        double vet[] = new double[3];
        
        switch(fontePotassio){
            case 1:
                vet[0] = 58;
                //vet[1] = 0.28;
                //vet[2] = 18;
                break;
            case 2:    
                vet[0] = 52;
                //vet[1] = 0.2;
                //vet[2] = 5;
                break;
            case 3:
                vet[0] = 22;
                //vet[1] = 0.09;
                break;
            case 4:
                vet[0] = 44;
                //vet[1] = 0.16;
                break;
            }    

        return vet;

    }
    
    //Inicio dos calculos.
    
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
            B22 /= eficienciaFosforo;
            B22 = B22*100/ (dadosFonteFosforo(fonteFosforo)[0]);
        }
        return B22;    
    }
    
    private double calcularM22(double teorFosforo,double fosforo,double eficienciaFosforo,int fonteFosforo){
       
        double M22 = calculaB22(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo);//*2.42; 
        return M22*dadosFonteFosforo(fonteFosforo)[1];
        
    }
    
    private double calculaI107(double teorDeCaO,int fonteCorretivoCalMag){
        
        double I107 = 0.0;
        
        if(teorDeCaO > 0.01){
            I107 = teorDeCaO;
            return I107 *= 0.01783;
        }    
        else{
            return dadosFonteCalMag(fonteCorretivoCalMag)[0]*0.01783;
        }
        
    }
    
    private double calculaI105(double teorFosforo,double fosforo,double eficienciaFosforo,int fonteFosforo){
        
        double I105 = calcularM22(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo);///2.42;
        
        return I105 * dadosFonteFosforo(fonteFosforo)[2]/1000;
        
    }
    
    private double calculaC66(double potassio,double CTCPotaDesejado,double CTCPotaAtual,int fontePotassio){
        
        double C66;
        
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
        
        return C66*100/dadosFontePotassio(fontePotassio)[0];
        
    }
    
    private double calculaQuantidadeCorretivoAImcorporar(double calcio,double calcioCTCDesejada,double calcioCTCAtual,
                                                         double teorFosforo,double fosforo,double eficienciaFosforo,
                                                         int fonteFosforo,double teorDeCaO,int fonteCorretivoCalMag){
        
        double quantidade = calcio*calcioCTCDesejada/calcioCTCAtual-(calcio-calculaI105(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo));
        System.out.println(quantidade);
        quantidade = quantidade / (calculaI107(teorDeCaO,fonteCorretivoCalMag) + calculaI105(teorFosforo,fosforo,eficienciaFosforo,fonteFosforo));
 
        if(quantidade > 0.0001 ){
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
        
        
        M60 = dadosFonteCalMag(fonteCorretivoCalMag)[2]*(0.0248*T70);
        
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
        
        H16 = H16*100/dadosFonteFosforo(fonteFosforo)[0];
        
        return H16*100;
    }
    
    public double[] calculaQuantidadeCorrecaoFosforo(double fosforo,double teorFosforo,int fonteFosforo,double eficienciaFosforo){
        double resultado [] = new double[2];
                
        if(fonteFosforo == 5){
            resultado[0] = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 0.15;
        }
        else{
            resultado[0] = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 2.42;
            if(fonteFosforo == 1){
                resultado[0] *= 0.1;
                resultado[0] /= 2.42;
            }
            else if(fonteFosforo == 12){
                resultado[0] *= 0.11;   
                resultado[0] /= 2.42;
            }
            else{
                resultado[0] = 0;
                resultado[0] /= 2.42;
            }
        }
        resultado[1] = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 2.42; //Melho metodo
        resultado[1] = resultado[1]*dadosFonteFosforo(fonteFosforo)[1];
        resultado[1] /= 2.42;
        
        return resultado;
    }
    
    public String [] calculaTipoDaCorreção(int fonteFosforo){
        String vet[] = new String[2];
        
        if(fonteFosforo == 1 || fonteFosforo == 12){
            vet[0] = "Enxofre";
            vet[1] = "Cálcio";
        }
        else if(fonteFosforo == 5){
            vet[0] = "Magnésio";
            vet[1] = "Cálcio";
        }
        else if(fonteFosforo == 2 || 
           fonteFosforo == 6 || fonteFosforo == 7 || fonteFosforo == 8 || 
           fonteFosforo == 9 || fonteFosforo == 10){
            vet[0] = "";
            vet[1] = "Cálcio";
        }
        else if(fonteFosforo == 3 || fonteFosforo == 4){
            vet[0] = "";
            vet[1] = "Nitrogênio";
        }    
        return vet;
    }
   
    public double calculaCustoFosforo(double fosforo,double teorFosforo,int fonteFosforo,double eficienciaFosforo,double precoFosforo){
        
        double resultado = calculaQuantidadeAplicarFosforo(fosforo,teorFosforo,fonteFosforo,eficienciaFosforo) * 2.42;
        
        resultado = precoFosforo*resultado/2.42;
        return resultado;
    }
    
    // Calculos Potassio
    
    public double calculaQuantidadeAplicarPotassio(double potassio,double CTCPotassioatual,double CTCPotassioDese,int fontePotassio){
        double resultado;
        
        resultado = (CTCPotassioatual - potassio) / (potassio*CTCPotassioDese);
        
        if(resultado < 0.01){
            resultado = 0.0;
        }
        
        resultado = (resultado * 39.1) * 10;
        resultado *= 2;
        resultado *=1.2;
        resultado = resultado * 100 / 85 / 100;
        
        resultado = resultado*100/dadosFontePotassio(fontePotassio)[0];
        return resultado * 10;
         
    }
    
    public double calculaCustoPotassio(double potassio,double CTCPotassioatual,double CTCPotassioDese,int fontePotassio,int texturaSolo,double precoPotassio){
        
        double resultado = calculaQuantidadeAplicarPotassio(potassio,CTCPotassioatual,CTCPotassioDese,fontePotassio);
        double M44;
     
        
        if(texturaSolo == 1){
            M44 = 70;
        }
        else{
            M44 = 50;
        }
        
        resultado = precoPotassio * (resultado*2.42) / 1000;
        resultado = resultado / 2.42; 
        return resultado;
    }
    
    public double calculaPartIdealPotassio(int texturaSolo){
    
        if(texturaSolo == 1 || texturaSolo == 2){
            return 3.0;
        }
        else{
            return 0.0;
        }
        
    }
    
}
