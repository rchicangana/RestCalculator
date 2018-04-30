/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.restcalculator.logica;

import co.com.javeriana.restcalculator.dto.MensajeDTO;
import co.com.javeriana.restcalculator.util.ConstantesComunes;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class CalculatorLogica {
    
    
    /**
     * Suma los valores encontrados en el list de entrada
     * @param mapa
     * @return 
     */
    public MensajeDTO add(List<Double> mapa){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            salida.setResultado(mapa.stream().mapToDouble(i->i).sum());
            salida.setEstado(ConstantesComunes.CodigosResultado.OK.name());
        } catch (Exception e) {
            salida.setEstado(ConstantesComunes.CodigosResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
    /**
     * Permite restar los valores del map
     * @param mapa
     * @return 
     */
    public MensajeDTO subs(List<Double> mapa){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            salida.setResultado(mapa.stream().reduce(mapa.get(0)*2, (a,b) -> a - b));
            salida.setEstado(ConstantesComunes.CodigosResultado.OK.name());
        } catch (Exception e) {
            salida.setEstado(ConstantesComunes.CodigosResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
    /**
     * Permite multiplicar los valores del map
     * @param mapa
     * @return 
     */
    public MensajeDTO mult(List<Double> mapa){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            salida.setResultado(mapa.stream().reduce(Double.valueOf(1), (a,b) -> a * b));
            salida.setEstado(ConstantesComunes.CodigosResultado.OK.name());
        } catch (Exception e) {
            salida.setEstado(ConstantesComunes.CodigosResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
    /**
     * Permite dividir los valores del map
     * @param mapa
     * @return 
     */
    public MensajeDTO div(List<Double> mapa){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            
            Optional<Double> cero = mapa.stream().filter(s -> s==0).findFirst();
            if(!cero.isPresent()){
                salida.setResultado(mapa.stream().reduce(mapa.get(0)*mapa.get(0), (a,b) -> a / b));
                salida.setEstado(ConstantesComunes.CodigosResultado.OK.name());
            } else {
                salida.setEstado(ConstantesComunes.CodigosResultado.ERROR.name());
                salida.setMensaje("No es posible enviar el valor cero en la division");
            }
            
            
        } catch (Exception e) {
            salida.setEstado(ConstantesComunes.CodigosResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
}
