package models;

public class Pokemon {
protected String nombre;
protected String numero;
protected String nivelEvo;
protected String region;
protected String tipo;
protected String comentario;

public Pokemon(String nombre, String numero, String nivelEvo, String region, String tipo, String comentario) {
	this.nombre = nombre;
	this.numero = numero;
	this.nivelEvo = nivelEvo;
	this.region = region;
	this.tipo = tipo;
	this.comentario = comentario;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public String getNivelEvo() {
	return nivelEvo;
}

public void setNivelEvo(String nivelEvo) {
	this.nivelEvo = nivelEvo;
}

public String getRegion() {
	return region;
}

public void setRegion(String region) {
	this.region = region;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getComentario() {
	return comentario;
}

public void setComentario(String comentario) {
	this.comentario = comentario;
}

}
