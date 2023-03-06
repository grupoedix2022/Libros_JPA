package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="direccion")
@XmlType(propOrder = {
		"tipoVia",
	    "nombreVia",
	    "ciudad"
	})
public class Direccion {
	
	private String tipoVia;
	private String nombreVia;
	private String ciudad;
			
	public Direccion() {
		super();
	}
	public Direccion(String tipoVia, String nombreVia, String ciudad) {
		super();
		this.tipoVia = tipoVia;
		this.nombreVia = nombreVia;
		this.ciudad = ciudad;
	}
	
	@XmlAttribute
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	@XmlAttribute
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	@XmlAttribute
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String toString() {
        return this.getClass().getSimpleName();
    }
	
}
