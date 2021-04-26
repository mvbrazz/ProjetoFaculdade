package Projeto;

public class Nutrientes{

    @Override public boolean equals(Object Nutrientes){ 
        if (this.fosforo == ((Nutrientes)Nutrientes).getFosforo() && this.potassio == ((Nutrientes)Nutrientes).getPotassio() &&
            this.calcio == ((Nutrientes)Nutrientes).getCalcio() && this.magnesio == ((Nutrientes)Nutrientes).getMagnesio() &&
            this.enxofre == ((Nutrientes)Nutrientes).getEnxofre() && this.aluminio == ((Nutrientes)Nutrientes).getAluminio() &&
            this.HidrogenioAluminio == ((Nutrientes)Nutrientes).getHidrogenioAluminio()){
            return true;
        }else{return false;}
    }        
             
    private double fosforo;
    private double potassio;
    private double calcio;
    private double magnesio;
    private double enxofre;
    private double aluminio;
    private double HidrogenioAluminio;

    public Nutrientes(double fosforo,double potassio,double calcio,double magnesio,double enxofre,double aluminio,double HidrogenioAluminio){

	this.fosforo = fosforo;
	this.potassio = potassio;
        this.calcio = calcio;
	this.magnesio = magnesio;
	this.enxofre = enxofre;
	this.aluminio = aluminio;
	this.HidrogenioAluminio = HidrogenioAluminio; 

    }

    public static Nutrientes ValoresIdeais(String texturaSolo){

	if(texturaSolo.equals("argiloso")){
            return new Nutrientes(9.0,0.35,6.0,1.5,9.0,0.0,0.0);
	}
	else{
            return new Nutrientes(12.0,0.25,3.0,1.0,6.0,0.0,0.0);
	}

    }
        
    public double getFosforo() {
        return fosforo;
    }

    public double getPotassio() {
        return potassio;
    }

    public double getCalcio() {
        return calcio;
    }

    public double getMagnesio() {
        return magnesio;
    }

    public double getEnxofre() {
        return enxofre;
    }

    public double getAluminio() {
        return aluminio;
    }

    public double getHidrogenioAluminio() {
        return HidrogenioAluminio;
    }
        
}
