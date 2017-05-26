package mx.com.amx.unotv.sitemap.proceso;

import mx.com.amx.unotv.sitemap.bo.IGeneraSiteMapBO;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ProcesoGeneraSiteMap implements ApplicationContextAware {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	private IGeneraSiteMapBO generaSiteMapBO;

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		logger.info("************ En contexto GeneraSiteMap UnoNoticas [obtieneSecuencia] ********************");
		try{
			generaSiteMapBO.obtieneSecuenciaActual();
		}catch(Exception e)
		{
			logger.info("Error al iniciar secuencia");			
		}
	} 
	
	public void iniciaGeneracionSiteMap()
	{
		logger.info("Inicia iniciaGeneracionSiteMap UnoTV");
		try{
			generaSiteMapBO.inicializaProceso();
		}catch(Exception e){
			logger.info("Hubo un error en iniciaGeneracionSiteMap "+e.getMessage());
		}
		
	}

	/**
	 * @return the generaSiteMapBO
	 */
	public IGeneraSiteMapBO getGeneraSiteMapBO() {
		return generaSiteMapBO;
	}

	/**
	 * @param generaSiteMapBO the generaSiteMapBO to set
	 */
	public void setGeneraSiteMapBO(IGeneraSiteMapBO generaSiteMapBO) {
		this.generaSiteMapBO = generaSiteMapBO;
	}

	
}
