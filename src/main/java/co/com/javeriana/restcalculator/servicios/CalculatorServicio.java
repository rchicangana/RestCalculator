/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.restcalculator.servicios;

import co.com.javeriana.restcalculator.dto.MensajeDTO;
import co.com.javeriana.restcalculator.logica.CalculatorLogica;
import co.com.javeriana.restcalculator.util.HttpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("calculator")
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorServicio {
    
    
    @EJB
    private CalculatorLogica calculatorLogica;
    
    /**
     * 
     * @param parametros
     * @return 
     */
    @GET
    @Path("/add" + HttpUtil.PATH_MULTIPARAMETRO)
    public MensajeDTO add(@PathParam(HttpUtil.PATH_PARAM_MULTIPARAMETRO) String parametros){
        List<Double> valores = new ArrayList<>();
        HttpUtil.obtenerParametrosPath(parametros, valores);
        return calculatorLogica.add(valores);
    }
    
    /**
     * 
     * @param parametros
     * @return 
     */
    @GET
    @Path("/subs" + HttpUtil.PATH_MULTIPARAMETRO)
    public MensajeDTO subs(@PathParam(HttpUtil.PATH_PARAM_MULTIPARAMETRO) String parametros){
        List<Double> valores = new ArrayList<>();
        HttpUtil.obtenerParametrosPath(parametros, valores);
        return calculatorLogica.subs(valores);
    }
    
    /**
     * 
     * @param parametros
     * @return 
     */
    @GET
    @Path("/mult" + HttpUtil.PATH_MULTIPARAMETRO)
    public MensajeDTO mult(@PathParam(HttpUtil.PATH_PARAM_MULTIPARAMETRO) String parametros){
        List<Double> valores = new ArrayList<>();
        HttpUtil.obtenerParametrosPath(parametros, valores);
        return calculatorLogica.mult(valores);
    }
    
    /**
     * 
     * @param parametros
     * @return 
     */
    @GET
    @Path("/div" + HttpUtil.PATH_MULTIPARAMETRO_DIV)
    public MensajeDTO div(@PathParam(HttpUtil.PATH_PARAM_MULTIPARAMETRO) String parametros){
        List<Double> valores = new ArrayList<>();
        HttpUtil.obtenerParametrosPath(parametros, valores);
        return calculatorLogica.div(valores);
    }
    
}
