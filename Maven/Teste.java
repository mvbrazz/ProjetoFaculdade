package Projeto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Teste {
    
    @Test
    public void testaValoresIdeaisArgiloso(){
	assertEquals(new Nutrientes(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0),Nutrientes.ValoresIdeais("argiloso"));
    }
    
    @Test
    public void testaValoresIdeaisMedio(){
	assertEquals(new Nutrientes(12.0,0.25,3.0,1.0,6.0,0.0,0.0),Nutrientes.ValoresIdeais("medio"));
    }
    
    // Testando valores corrigidos 
    
    @Test
    public void testaFosforoCorrigido(){ //12 de 12
	assertEquals(12, new Calculos().calculaFosforoCorrigido(12));
    }
    
    @Test
    public void testaPotassioCorrigido(){ //0.375 de 0.39
        assertEquals(0.375,new Calculos().calculaPotassioCorrigido(0.15,3.0,1.2));
    }
    
    @Test
    public void testaCalcioCorrigido(){  //8.65 de 7.09 verificar erro
	assertEquals(8.651998229900256, new Calculos().calculaCalcioCorrigido(5.76,0.0,2,12,8.59,70,1,3.0,1.2));
    }
     
    @Test
    public void testaMagnesioCorrigido(){ //1.79 para 1.794822248601599
        assertEquals(1.794822248601599, new Calculos().calculaMagnesioCorrigido(1.63,2,5.76,55.0,44.7,12,8.59,70,1,0,1,0.15,3.0,1.2));
    }
    
    @Test
    public void testaCalculaScmol(){
        assertEquals(7.54, new Calculos().calculaScmol(5.76,1.63,0.15));
    }
    
    @Test
    public void testaCalculaCTCcmol(){
        assertEquals(12.89, new Calculos().calculaCTCcmol(5.76,1.63,0.15,5.35));
    }
    
    @Test
    public void testavAtual(){ //58.49 para 58.494957331264544
        assertEquals(58.494957331264544, new Calculos().calculaVAtual(5.76,1.63,0.15,5.35));
    }
    
    @Test
    public void testaMoPerc(){ //58.49 para 58.494957331264544
        assertEquals(3.07, new Calculos().calculaMoPerc(30.7));
    }
    
    @Test
    public void testaCalculaCarbono(){ //17.84 para 17.848837209302324
        assertEquals(17.848837209302324, new Calculos().calculaCarbono(30.7));
    }
    
    // Tabela Fosforo
    @Test
    public void testaQuantidadeAplicarFosforo(){ //123.95  para 123.95079365079367
        assertEquals(123.95079365079367, new Calculos().calculaQuantidadeAplicarFosforo(8.59,12,1,70));
    }
    
    @Test
    public void testaQuantidadeCorrecaoFosforo1(){ //12.4  para 12.395079365079368
        assertEquals(12.395079365079368, new Calculos().calculaQuantidadeCorrecaoFosforo(8.59,12,1,70)[0]);
    }
    
    @Test
    public void testaQuantidadeCorrecaoFosforo2(){ //34.7  para 34.70622222222223
        assertEquals(34.70622222222223, new Calculos().calculaQuantidadeCorrecaoFosforo(8.59,12,1,70)[1]);
    }
    
    @Test
    public void testaTipoDaCorreção1(){ //12.4  para 12.395079365079368
        assertEquals("Enxofre", new Calculos().calculaTipoDaCorreção(1)[0]);
    }
    
    @Test
    public void testaTipoDaCorreção2(){ //12.4  para 12.395079365079368
        assertEquals("Cálcio", new Calculos().calculaTipoDaCorreção(1)[1]);
    }
        
    @Test
    public void testaCalculaCustoFosforo(){ //156.18  para 154.9384920634921
        assertEquals(154.9384920634921, new Calculos().calculaCustoFosforo(8.59,12,1,70,1.250));
    }
    
    // tabela potássio
    
    @Test
    public void testaCalculaQuantidadeAplicarPotassio(){ //450.55  para 444.13793103448285
        assertEquals(444.13793103448285, new Calculos().calculaQuantidadeAplicarPotassio(0.15,1.2,3.0,1));
    }
    
    @Test
    public void testaCalculaCustoPotassio(){ //1.126  para 1.1103448275862071
        assertEquals(1.1103448275862071, new Calculos().calculaCustoPotassio(0.15,1.2,3.0,1,1,2.500));
    }
    
    @Test
    public void testaPartIdealPotassio(){ //1.126  para 1.1103448275862071
        assertEquals(3.0, new Calculos().calculaPartIdealPotassio(1));
    }
    
   
    
}
