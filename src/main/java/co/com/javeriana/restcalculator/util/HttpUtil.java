/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.restcalculator.util;

import java.util.List;
import java.util.Map;

/**
 *
 * @author rchic
 */
public class HttpUtil {
    public static final String PATH_MULTIPARAMETRO = "{parametros:(/?(-?[0-9]+))*}";
    public static final String PATH_MULTIPARAMETRO_DIV = "{parametros:(/?(-?[1-9]+))*}";
    public static final String PATH_PARAM_MULTIPARAMETRO = "parametros";
    
    public static void obtenerParametrosPath(String path, List<Double> mapaParametros){
        String [] parametros = path.split("/");
        int i = 0;
        for (String parametro : parametros) {
            i++;
            if(!"".equals(parametro)){
                mapaParametros.add(Double.valueOf(parametro));
            }
        }
        
    }
    
    
}
