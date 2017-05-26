package mx.com.amx.unotv.sitemap.dto;

public class NotaDTO {
	
	private String fcIdContenido;
	private String fcTitulo;
	private String fcLinkDetalle;
	private String fcNombre;
	private String fcFechaModificacion;
	private String fcFechaPubli;
	private String fcKeyWords;
	
	


	/**
	 * @return the fcIdContenido
	 */
	public String getFcIdContenido() {
		return fcIdContenido;
	}




	/**
	 * @param fcIdContenido the fcIdContenido to set
	 */
	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}




	/**
	 * @return the fcTitulo
	 */
	public String getFcTitulo() {
		return fcTitulo;
	}




	/**
	 * @param fcTitulo the fcTitulo to set
	 */
	public void setFcTitulo(String fcTitulo) {
		this.fcTitulo = fcTitulo;
	}




	/**
	 * @return the fcLinkDetalle
	 */
	public String getFcLinkDetalle() {
		return fcLinkDetalle;
	}




	/**
	 * @param fcLinkDetalle the fcLinkDetalle to set
	 */
	public void setFcLinkDetalle(String fcLinkDetalle) {
		this.fcLinkDetalle = fcLinkDetalle;
	}




	/**
	 * @return the fcNombre
	 */
	public String getFcNombre() {
		return fcNombre;
	}




	/**
	 * @param fcNombre the fcNombre to set
	 */
	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}




	/**
	 * @return the fcFechaModificacion
	 */
	public String getFcFechaModificacion() {
		return fcFechaModificacion;
	}




	/**
	 * @param fcFechaModificacion the fcFechaModificacion to set
	 */
	public void setFcFechaModificacion(String fcFechaModificacion) {
		this.fcFechaModificacion = fcFechaModificacion;
	}




	/**
	 * @return the fcFechaPubli
	 */
	public String getFcFechaPubli() {
		return fcFechaPubli;
	}




	/**
	 * @param fcFechaPubli the fcFechaPubli to set
	 */
	public void setFcFechaPubli(String fcFechaPubli) {
		this.fcFechaPubli = fcFechaPubli;
	}




	/**
	 * @return the fcKeyWords
	 */
	public String getFcKeyWords() {
		return fcKeyWords;
	}




	/**
	 * @param fcKeyWords the fcKeyWords to set
	 */
	public void setFcKeyWords(String fcKeyWords) {
		this.fcKeyWords = fcKeyWords;
	}




	public String toString() {

		String NEW_LINE = System.getProperty("line.separator");
		StringBuffer result = new StringBuffer();
		result.append(" [Begin of Class] " + NEW_LINE);
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		result.append(" fcIdContenido: _" + this.getFcIdContenido() + "_"+ NEW_LINE);
		result.append(" fcTitulo: _" + this.getFcTitulo() + "_" + NEW_LINE);
		 /*
		 * result.append(" fcDescripcion: _" + this.getFcDescripcion() + "_" +
		 * NEW_LINE); result.append(" fcEscribio: _" + this.getFcEscribio() +
		 * "_" + NEW_LINE); result.append(" fcImgPrincipal: _" +
		 * this.getFcImgPrincipal() + "_" + NEW_LINE);
		 * result.append(" fcFechaPublicacion: _" + this.getFdFechaPublicacion()
		 * + "_" + NEW_LINE); result.append(" fcHora: _" + this.getFcHora() +
		 * "_" + NEW_LINE); result.append(" fcFuente: _" + this.getFcFuente() +
		 * "_" + NEW_LINE); result.append(" fcLugar: _" + this.getFcLugar() +
		 * "_" + NEW_LINE); result.append(" fcPieFoto: _" + this.getFcPieFoto()
		 * + "_" + NEW_LINE); result.append(" clGaleriaImagenes: _" +
		 * this.getClGaleriaImagenes() + "_" + NEW_LINE);
		 * result.append(" fcIdVideoYouTube: _" + this.getFcIdVideoYouTube() +
		 * "_" + NEW_LINE); result.append(" fcIdVideoOoyala: _" +
		 * this.getFcIdVideoOoyala() + "_" + NEW_LINE);
		 * result.append(" fcIdPlayerOoyala: _" + this.getFcIdPlayerOoyala() +
		 * "_" + NEW_LINE); result.append(" fcKeywords	: _" +
		 * this.getFcKeywords() + "_" + NEW_LINE); result.append(" fcFecha: _" +
		 * this.getFcFecha() + "_" + NEW_LINE); result.append(" fcHora: _" +
		 * this.getFcHora() + "_" + NEW_LINE);
		 */
		result.append(" [End of Class] " + NEW_LINE);
		result.append("}");
		NEW_LINE = null;

		return result.toString();
	}
}
