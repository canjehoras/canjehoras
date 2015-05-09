package com.vcortes.canjehoras.controller;

import java.util.ArrayList;
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
		               oJSON.put("pulsacion", l.getTipo());
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
