package mx.com.amx.unotv.sitemap.bo;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import mx.com.amx.unotv.sitemap.dto.NotaDTO;
import mx.com.amx.unotv.sitemap.dto.ParametrosDTO;
import mx.com.amx.unotv.sitemap.util.CambiosXML;
import mx.com.amx.unotv.sitemap.util.CargaProperties;
import mx.com.amx.unotv.sitemap.util.LlamadasWS;

import org.apache.log4j.Logger;


public class GeneraSiteMapBOImpl implements IGeneraSiteMapBO {

	private final Logger log = Logger.getLogger(this.getClass().getName());
	
	ParametrosDTO parametrosDTO =new ParametrosDTO();
	LlamadasWS llamadasWS=null;
	
	
	public void generarXML() throws Exception {
		
	    	DOMSource sourceRet  = new DOMSource();
			//ObtenerProperties obtenerProperties = new ObtenerProperties();
			//String linkseccion = "";
			try {
				//Obtengo las noticias de la base
				CargaProperties cargaProperties=new CargaProperties();
				parametrosDTO=cargaProperties.obtenerPropiedades("ambiente.resources.properties");
				 
				//String rutaArchivo=parametrosDTO.getRutaLocal()+parametrosDTO.getNombreSiteMap()+".xml";
				String rutaArchivo=parametrosDTO.getRutaArchivo()+parametrosDTO.getNombreSiteMap()+".xml";
				
				llamadasWS=new LlamadasWS(); 
				List<NotaDTO> rssList=llamadasWS.getElementosNewsSiteMap(100);
				log.info("Num de Notas para el SiteMap: "+rssList.size());
				
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	    		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	    		org.w3c.dom.Document docXML = docBuilder.newDocument();
	    		docXML.createTextNode("<?xml version='1.0' encoding='UTF-8'?>");
				org.w3c.dom.Element rootElement = docXML.createElement("urlset");

	    		
	    		rootElement.setAttribute("xmlns", "http://www.sitemaps.org/schemas/sitemap/0.9");
	    		rootElement.setAttribute("xmlns:news","http://www.google.com/schemas/sitemap-news/0.9");
					    						
	    		docXML.appendChild(rootElement);
	    		 
	    		if ( rssList != null && rssList.size() > 0 ){
	        		
					// SE RECORRE EL ARREGLO DE NOTICIAS
	        		for ( int i=0; i < rssList.size() ; i++ ){

	            		StringBuffer sb = new StringBuffer();

						org.jdom.Element question = new org.jdom.Element("item");
						
						org.w3c.dom.Element url = docXML.createElement("url");
						rootElement.appendChild(url);
						
						org.w3c.dom.Element loc = docXML.createElement("loc");
		        		loc.appendChild(docXML.createCDATASection(rssList.get(i).getFcLinkDetalle()));
						

						org.w3c.dom.Element noticiaXML = docXML.createElement("news:news");
						rootElement.appendChild(noticiaXML);

						sb.delete(0, sb.length());

						org.jdom.Element item = new org.jdom.Element("item");

						// PUBLICATION
						org.w3c.dom.Element publication = docXML.createElement("news:publication");
						
						// TITLE PUBLICATION
						org.w3c.dom.Element titlePub = docXML.createElement("news:name");
						String tituloPub = "Uno TV Noticias";
						titlePub.appendChild(docXML.createCDATASection(tituloPub));
						publication.appendChild(titlePub);
						//
						org.w3c.dom.Element lg = docXML.createElement("news:language");
	                    // LANGUAGE
						lg.appendChild(docXML.createCDATASection("es"));
	            		//
						publication.appendChild(lg);
						
						
						// GENRES
						org.w3c.dom.Element genres = docXML.createElement("news:genres");
						genres.appendChild(docXML.createCDATASection("UserGenerated"));
						//
						// TITLE
						org.w3c.dom.Element title = docXML.createElement("news:title");
						String titulo = rssList.get(i).getFcTitulo();
						title.appendChild(docXML.createCDATASection(titulo));
						
						//
						org.w3c.dom.Element pubDate = docXML.createElement("news:publication_date");
						// PUBLICATION DATE
						pubDate.appendChild(docXML.createCDATASection( rssList.get(i).getFcFechaPubli()));
						//
						org.w3c.dom.Element key = docXML.createElement("news:keywords");
						//KEYWORDS
						key.appendChild(docXML.createCDATASection( rssList.get(i).getFcKeyWords()));
						
						url.appendChild(loc);
						noticiaXML.appendChild(publication);
						noticiaXML.appendChild(genres);
						noticiaXML.appendChild(pubDate);
						noticiaXML.appendChild(title);
						noticiaXML.appendChild(key);
						url.appendChild(noticiaXML);
	            		
	            		question.addContent( item );

	        		}
	        		
	        		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        		Transformer transformer = transformerFactory.newTransformer();
	        		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        		DOMSource source = new DOMSource(docXML);

	        		sourceRet = source;
	        	    	        		
	        		File f = new File (rutaArchivo);
	        		StreamResult result = new StreamResult( f );
	        		transformer.transform(sourceRet, result);
	        		log.info("Archivo "+rutaArchivo+" generado Satisfactoriamente ");
	        		//CambiosXML cambiosXml=new CambiosXML();
	        		//cambiosXml.readAndModifyXML(parametrosDTO);
	        		
	        		if(parametrosDTO.getAmbiente().equalsIgnoreCase("desarrollo"))
	        			transfiereWebServer(parametrosDTO);
	    		} 
			// end if
	    	
			}catch (Exception e){
				log.error("Error generarXML: ",e);
			}
	}
	
	public void inicializaProceso() throws Exception {
		log.info("En inicializaProceso ");
		try{
			generarXML();
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}
		
	

	public void transfiereWebServer(ParametrosDTO parametrosDTO) throws Exception {
		try {	
				//Properties propiedades = new Properties();
			 	//propiedades.load(this.getClass().getResourceAsStream( "/ApplicationResources.properties" ));
			 	String rutaShell=parametrosDTO.getRutaShell();
			 	String pathLocal=parametrosDTO.getRutaArchivo();
			 	String pathRemote=parametrosDTO.getRutaWebServer();
			 	String comando = rutaShell + " " + pathLocal + " " + pathRemote;		
				log.info("Comando: "+comando);
				Runtime r = Runtime.getRuntime();
				r.exec(comando);
			} catch(Exception e) {
				throw new Exception(e.getMessage());
			}		
		
	}
	
	public void inciaSecuencia() throws Exception{
		try {
			llamadasWS=new LlamadasWS(); 
			llamadasWS.getSecuencia();
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public void obtieneSecuenciaActual() throws Exception{
		try {
			llamadasWS=new LlamadasWS(); 
			llamadasWS.getSecuenciaActual();
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public boolean createFolders(String carpetaContenido) {
		boolean success = false;
		try {						
			File carpetas = new File(carpetaContenido) ;
			if(!carpetas.exists()) {   
				success = carpetas.mkdirs();					
			} else 
				success = true;							
		} catch (Exception e) {
			success = false;
			log.error("Ocurrio error al crear las carpetas: ", e);
		} 
		return success;
	}
}
