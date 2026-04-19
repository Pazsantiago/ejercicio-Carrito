import java.util.List;
import java.util.Date;

class Pais{
	private String nombre;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
}

class Provincia{
	private String nombre;
	private Pais pais;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public Pais getPais() { return pais; }
	public void setPais(Pais pais) { this.pais = pais; }
}

class Ciudad{
	private String nombre;
	private Provincia provincia;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public Provincia getProvincia() { return provincia; }
	public void setProvincia(Provincia provincia) { this.provincia = provincia; }
}

class Direccion {
	private String calle1;
	private String calle2;
	private Integer altura;
	private Boolean sinAltura;
	private Integer piso;
	private Integer cuerpo;
	private String departamento;
	private Ciudad ciudad;

	public String getCalle1() { return calle1; }
	public void setCalle1(String calle1) { this.calle1 = calle1; }

	public String getCalle2() { return calle2; }
	public void setCalle2(String calle2) { this.calle2 = calle2; }

	public Integer getAltura() { return altura; }
	public void setAltura(Integer altura) { this.altura = altura; }

	public Boolean getSinAltura() { return sinAltura; }
	public void setSinAltura(Boolean sinAltura) { this.sinAltura = sinAltura; }

	public Integer getPiso() { return piso; }
	public void setPiso(Integer piso) { this.piso = piso; }

	public Integer getCuerpo() { return cuerpo; }
	public void setCuerpo(Integer cuerpo) { this.cuerpo = cuerpo; }

	public String getDepartamento() { return departamento; }
	public void setDepartamento(String departamento) { this.departamento = departamento; }

	public Ciudad getCiudad() { return ciudad; }
	public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }
	
	public String getDireccion() {
		return "Pais: " + ciudad + ciudad.getProvincia().getPais().getNombre() 
		+ " Provincia: " + ciudad.getProvincia().getNombre() + " Ciudad: " + ciudad.getNombre() 
		+ " calle1: " + calle1 + " altura: " + altura + " depto: " + departamento; 
	}
	
	public String getLatitud() {
		return calle1 + calle2 + altura + piso; 
		//Lo hacemos asi porque sino tenemos que usar la formula de semiverseno/distancia ortodrómica
	}
	public String getLongitud() {
		return calle1 + calle2 + altura + piso; 
		//Idém.
	}
	
//	public Boolean estaHabilitadaEnvio() {
//		??????	
//	}
}

class Cliente {
	private String nombre;
	private String apellido;
	private String email;
	private List<Direccion> direcciones;
	private List<Carrito> carritos;
	private List<Tarjeta> tarjeta;
	private Boolean esPreferencial;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public List<Direccion> getDirecciones() { return direcciones; }
	public void setDirecciones(List<Direccion> direcciones) { this.direcciones = direcciones; }

	public List<Carrito> getCarritos() { return carritos; }
	public void setCarritos(List<Carrito> carritos) { this.carritos = carritos; }

	public List<Tarjeta> getTarjeta() { return tarjeta; }
	public void setTarjeta(List<Tarjeta> tarjeta) { this.tarjeta = tarjeta; }

	public Boolean getEsPreferencial() { return esPreferencial; }
	public void setEsPreferencial(Boolean esPreferencial) { this.esPreferencial = esPreferencial; }
	
//	public Double getMontoDeuda() {
//		??????
//	}
	
	public Boolean estaHabilitado() {
		boolean estaHabilitado = false;
		for(Tarjeta tarjetaActual : tarjeta) {
			estaHabilitado = tarjetaActual.getEstaHabilitada();
		}
		return estaHabilitado;
	}
}

enum Estado {
    EN_PROCESO,
    CERRADO
}

class Carrito {
	private List<Item> items;
	private Date fechaCompra;
	private Cliente cliente;
	private Direccion direccionEnvio;
	private Direccion direccionCobro;
	private List<Pago> pagos;
	private Estado estado;
	
	public List<Item> getItems() { return items; }
	public void setItems(List<Item> items) { this.items = items; }

	public Date getFechaCompra() { return fechaCompra; }
	public void setFechaCompra(Date fechaCompra) { this.fechaCompra = fechaCompra; }

	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }

	public Direccion getDireccionEnvio() { return direccionEnvio; }
	public void setDireccionEnvio(Direccion direccionEnvio) { this.direccionEnvio = direccionEnvio; }

	public Direccion getDireccionCobro() { return direccionCobro; }
	public void setDireccionCobro(Direccion direccionCobro) { this.direccionCobro = direccionCobro; }
	public List<Pago> getPagos() { return pagos; }
	public void setPagos(List<Pago> pagos) { this.pagos = pagos; }

	public Estado getEstado() { return estado; }
	private void setEstado(Estado estado) { this.estado = estado; }
	
	public void cerrar() {
		setEstado(Estado.CERRADO);
	}
	
//	public Double getMontoPagado() {
//		???
//	}
//	public Double getMontoCarrito() {
//		???
//	}
//	public void getMontoDeuda() {
//		???
//	}
}

class Pago {
	private Carrito carrito;
	private Tarjeta tarjeta;
	private Double monto;

	public Carrito getCarrito() { return carrito; }
	public void setCarrito(Carrito carrito) { this.carrito = carrito; }

	public Tarjeta getTarjeta() { return tarjeta; }
	public void setTarjeta(Tarjeta tarjeta) { this.tarjeta = tarjeta; }

	public Double getMonto() { return monto; }
	public void setMonto(Double monto) { this.monto = monto; }
	
	public Boolean verificarTarjeta() { 
		return tarjeta.getEstaHabilitada();
	}
}

class Tarjeta {
	private String nombre;
	private MarcaTarjeta marcaTarjeta;
	private String ultimos4digitos;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public MarcaTarjeta getMarcaTarjeta() { return marcaTarjeta; }
	public void setMarcaTarjeta(MarcaTarjeta marcaTarjeta) { this.marcaTarjeta = marcaTarjeta; }

	public String getUltimos4digitos() { return ultimos4digitos; }
	public void setUltimos4digitos(String ultimos4digitos) { this.ultimos4digitos = ultimos4digitos; }
	
	public Boolean getEstaHabilitada() {
		if(MarcaTarjeta.valueOf(marcaTarjeta.toString()) == marcaTarjeta) {
			return true;
		}
		return false;
	}
}

enum MarcaTarjeta {
    VISA,
    MASTERCARD,
    NARANJA
}

class Item {
	private Carrito carrito;
	private Producto producto;
	private Integer cantidad;
	private Double precioUnitario;

	public Carrito getCarrito() { return carrito; }
	public void setCarrito(Carrito carrito) { this.carrito = carrito; }

	public Producto getProducto() { return producto; }
	public void setProducto(Producto producto) { this.producto = producto; }

	public Integer getCantidad() { return cantidad; }
	public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

	public Double getPrecioUnitario() { return precioUnitario; }
	public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }

	public double getPrecio() {
		return cantidad * precioUnitario;
	}
	
	public double getPrecioOficial() {
		return producto.getPrecio(carrito.getFechaCompra());
	}
	
	public double getDescuento() {
		return getPrecioOficial() - getPrecio();
	}
}

class Producto {
	private String EAN13;
	private String nombre;
	private List<PrecioProducto> preciosHistoricos;

	public String getEAN13() { return EAN13; }
	public void setEAN13(String eAN13) { EAN13 = eAN13; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public List<PrecioProducto> getPreciosHistoricos() { return preciosHistoricos; }
	public void setPreciosHistoricos(List<PrecioProducto> preciosHistoricos) { this.preciosHistoricos = preciosHistoricos; }

	public Double getPrecio(Date fechaVigencia) {
		for(PrecioProducto precioHistorico : preciosHistoricos) {
			if(precioHistorico.getCumpleVigencia(fechaVigencia)) {
				return precioHistorico.getPrecio();
			}
		}
		return 0.0;
	}
	
	public String getNombreCorto() {
		return nombre.split(" ")[0];
	}
}

class PrecioProducto {
	private Date fechaInicioVigencia;
	private Date fechaFinVigencia;
	private Double precio;

	public Date getFechaInicioVigencia() { return fechaInicioVigencia; }
	public void setFechaInicioVigencia(Date fechaInicioVigencia) { this.fechaInicioVigencia = fechaInicioVigencia; }

	public Date getFechaFinVigencia() { return fechaFinVigencia; }
	public void setFechaFinVigencia(Date fechaFinVigencia) { this.fechaFinVigencia = fechaFinVigencia; }

	public Double getPrecio() { return precio; }
	public void setPrecio(Double precio) { this.precio = precio; }
	
	public Boolean getCumpleVigencia(Date fecha) {
		return (fecha.after(fechaInicioVigencia) && fecha.after(fechaFinVigencia));
	}
}


public class EjercicioDelCarrito {
	public static void main(String[] args) {
		
	}
}
