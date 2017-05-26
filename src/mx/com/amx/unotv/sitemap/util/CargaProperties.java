package mx.com.amx.unotv.sitemap.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import mx.com.amx.unotv.sitemap.dto.ParametrosDTO;

public class CargaProperties {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public ParametrosDTO obtenerPropiedades(String properties) {
		ParametrosDTO parametrosDTO = new ParametrosDTO();		 
		try {	    		
			Properties propsTmp = new Properties();
			propsTmp.load(this.getClass().getResourceAsStream( "/general.properties" ));
			String ambiente = propsTmp.getProperty("ambiente");
			String rutaProperties = propsTmp.getProperty(properties.replace("ambiente", ambiente));
			Properties props = new Properties();
			
			props.load(new FileInputStream(new File(rutaProperties)));				
			parametrosDTO.setAmbiente(ambiente);
			parametrosDTO.setNombreSiteMap(props.getProperty("nombreSiteMap"));
			parametrosDTO.setRutaLocal(props.getProperty("rutaLocal"));
			parametrosDTO.setRutaArchivo(props.getProperty("rutaArchivo"));
			parametrosDTO.setRutaShell(props.getProperty("rutaShell"));
			parametrosDTO.setRutaWebServer(props.getProperty("rutaWebServer"));
			parametrosDTO.setTamanioArchivo(props.getProperty("tamanioArchivo"));
			parametrosDTO.setURL_WS_BASE(props.getProperty("URL_WS_BASE"));
			
		} catch (Exception ex) {
			parametrosDTO = new ParametrosDTO();
			logger.error("No se encontro el Archivo de propiedades: ", ex);			
		}
		return parametrosDTO;
    }
	
	
}
