package mx.com.amx.unotv.sitemap.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import mx.com.amx.unotv.sitemap.dto.ParametrosDTO;

import org.apache.log4j.Logger;

public class CambiosXML {
	
private static final Logger log = Logger.getLogger(CambiosXML.class);
	
	private void generaXmlAgain(String rutaGuardado, String CadenaAGuardar){
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	        	log.info("Guardando archivo Modificado: "+rutaGuardado);
	            fichero = new FileWriter(rutaGuardado, false);
	            pw = new PrintWriter(fichero);
	            pw.println(CadenaAGuardar);
	 
	        } catch (Exception e) {
	        	log.error("Error en generaXmlAgain: "+e);
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	        	   log.error("Error en generaXmlAgain[2]: "+e2);
	              e2.printStackTrace();
	           }
	        }
	}
	public void readAndModifyXML(ParametrosDTO parametrosDTO){
		
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      StringBuffer cadenaXML=new StringBuffer();
	      try {
	    	  String absolutePathReadXML=parametrosDTO.getRutaLocal() +parametrosDTO.getNombreSiteMap()+".xml";
	    	  String absolutePathSaveXML=parametrosDTO.getRutaArchivo() +parametrosDTO.getNombreSiteMap()+".xml";
	    	  log.info("Leyendo archivo para modificar: "+absolutePathReadXML);
	          archivo = new File (absolutePathReadXML);
	          fr = new FileReader (archivo);
	          br = new BufferedReader(fr);
	          
	          String linea;
	          while((linea=br.readLine())!=null){
	        	  cadenaXML.append(linea);
	          }
	          
		      String convertida="";
		      convertida=cadenaXML.toString().replaceAll("xmlns:news=\"http://www.google.com/schemas/sitemap-news/0.9\"", "LUGARA_WCM");
		      convertida=convertida.replaceAll("xmls=\"http://www.sitemaps.org/schemas/sitemap/0.9\"", "LUGARB_WCM");
		      
		      convertida=convertida.replaceAll("LUGARA_WCM","xmls=\"http://www.sitemaps.org/schemas/sitemap/0.9\"");
		      convertida=convertida.replaceAll("LUGARB_WCM","xmlns:news=\"http://www.google.com/schemas/sitemap-news/0.9\"");
		      
		      generaXmlAgain(absolutePathSaveXML, convertida);
	       }
	       catch(Exception e){
	          log.error("Error en readAndModifyXML: "+e);
	       }finally{
	          try{                    
	             if( null != fr ){   
	                fr.close();     
	             }                  
	          }catch (Exception e2){ 
	        	  log.error("Error en readAndModifyXML [2]: "+e2);
	          }
	       }
	 
	}
	
}
