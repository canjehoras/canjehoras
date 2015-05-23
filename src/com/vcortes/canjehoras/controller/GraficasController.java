package com.vcortes.canjehoras.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;
import com.vcortes.canjehoras.utils.JSONArray;
import com.vcortes.canjehoras.utils.JSONObject;

public class GraficasController extends BaseController{
	
	public static final Log log = LogFactory.getLog(GraficasController.class);
	private UsuarioBL usuarioBL;
	private TruequeBL truequeBL;

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}
	
	public ModelAndView verGraficas(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		ModelAndView model = new ModelAndView(Constantes.GRAFICAS); 
		return model;
	}
	
	public ModelAndView datosGraficas(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		JSONObject o = new JSONObject();
		JSONArray listSeries = new JSONArray();
		try{
			
			Long idUsuario = null;
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			if(null !=usuario){
				idUsuario = usuario.getId();
			}
			/* Trueques totales del usuario por mes */
			//String sql = new String("SELECT COUNT(id), YEAR(FECHA_ALTA), MONTH(FECHA_ALTA) FROM trueque WHERE ID_USUARIO = " + idUsuario + " AND FECHA_ALTA > NOW() - INTERVAL 6 MONTH GROUP BY YEAR(FECHA_ALTA), MONTH(FECHA_ALTA)");
			String sql = new String("SELECT COUNT(id), YEAR(FECHA_ALTA), MONTH(FECHA_ALTA) FROM trueque WHERE ID_USUARIO = " + idUsuario + 
					" AND YEAR(FECHA_ALTA) = YEAR(NOW()) GROUP BY YEAR(FECHA_ALTA), MONTH(FECHA_ALTA)");
			
			List totales = truequeBL.executeSQL(sql);
			Integer[] canjesTotales = getListFromResult(totales);			
			
			JSONObject o1 = new JSONObject();
			o1.put("name", "Publicados");
			o1.put("data", getListFromArray(canjesTotales));
			listSeries.put(0, o1);

			/* Trueques canjeados del usuario por mes */
			String sql2 = new String("SELECT COUNT(t.id), YEAR(FECHA_ALTA), MONTH(FECHA_ALTA) FROM trueque t INNER JOIN canje c on t.ID = c.ID_TRUEQUE WHERE c.ID_USUARIO IS NOT NULL "
					+ " AND YEAR(FECHA_ALTA) = YEAR(NOW()) GROUP BY YEAR(FECHA_ALTA), MONTH(FECHA_ALTA)");
			
			List canjeados = truequeBL.executeSQL(sql2);
			Integer[] canjesCanjeados = getListFromResult(canjeados);			
			
			JSONObject o2 = new JSONObject();
			o2.put("name", "Canjeados");
			o2.put("data", getListFromArray(canjesCanjeados));
			listSeries.put(1, o2);
			
			o.put("series", listSeries);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return enviarRespuestaAJAX(response, o.toString());
	}

	private Integer[] getListFromResult(List totales) {
		Integer[] canjesTotales = new Integer[12];
		Arrays.fill(canjesTotales, new Integer("0"));
		
		for (int i = 0; i < totales.size(); i++) {
			Object[] valores = (Object[]) totales.get(i);
			Integer mes = (Integer) valores[2];
			canjesTotales[mes-1] = ((BigInteger)valores[0]).intValue();
		}
		return canjesTotales;
	}
	
	
	private String getMonth(Integer mes){
		String[] str = {"Enero",      
				   "Febrero",
				   "Marzo",        
				   "Abril",        
				   "Mayo",          
				   "Junio",         
				   "Julio",         
				   "Agosto",       
				   "Septiembre",    
				   "Octubre",      
				   "Noviembre",     
				   "Diciembre"};
		
		return str[mes];
	}

	
	public ModelAndView graficas(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		ModelAndView model = new ModelAndView(Constantes.GRAFICAS); 

		Long idUsuario = null;
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		if(null !=usuario){
			idUsuario = usuario.getId();
		}

		JSONObject respuesta = new JSONObject();
		try {
			List<Trueque> listado = truequeBL.graficaTrueque(idUsuario);
		       if (listado != null) {
		           ArrayList<JSONObject> arrayRespuesta = new ArrayList<JSONObject>();
		           JSONObject oJSONVacio = new JSONObject();
		           oJSONVacio.put("value", "");
		           oJSONVacio.put("label", "");
		           arrayRespuesta.add(oJSONVacio);
		           for (Trueque l: listado) {
		               JSONObject oJSON = new JSONObject();
		               oJSON.put("fecha", l.getFecha_alta());
		               //oJSON.put("pulsacion", l.getTipo());
		               arrayRespuesta.add(oJSON);
		           }
		           respuesta.put("lecturas", arrayRespuesta);
		       }
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
		//return enviarRespuestaAJAX(response, respuesta.toString());
	}
	
/**	public ActionForward listaLecturas(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Throwable {
	       
        ClaseForm claseForm = (ClaseForm) form;
      
       JSONObject respuesta = new JSONObject();
      
       List<Lecturas> listadoLecturas = lecturasBL.findBySesion(new Long(1));
       if (listadoLecturas != null) {
           ArrayList<JSONObject> arrayRespuesta = new ArrayList<JSONObject>();
           JSONObject oJSONVacio = new JSONObject();
           oJSONVacio.put("value", "");
           oJSONVacio.put("label", "");
           arrayRespuesta.add(oJSONVacio);
           for (Lecturas l: listadoLecturas) {
               JSONObject oJSON = new JSONObject();
               oJSON.put("fecha", l.getFecha_lectura());
               oJSON.put("pulsacion", l.getPulsaciones());
               arrayRespuesta.add(oJSON);
           }
           respuesta.put("lecturas", arrayRespuesta);
       }
       return enviarRespuestaAJAX(response, respuesta.toString());
   }
*/
	
}
