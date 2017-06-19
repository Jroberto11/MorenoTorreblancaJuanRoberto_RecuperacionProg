package container;


import models.MiLista;
import models.Pokemon;

public class Contenedor {
	public static MiLista<Pokemon> ml = new MiLista<>(
			(Pokemon a, Pokemon b) -> b.getNombre().compareTo(a.getNombre()));
	
}
