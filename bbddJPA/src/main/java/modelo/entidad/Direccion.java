package modelo.entidad;
import javax.persistence.Embeddable;

@Embeddable
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
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
        return this.getClass().getSimpleName();
    }
	
	
}
