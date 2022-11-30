package logica.juego.visitor;

import logica.juego.estrategia.Desplazamiento;
import logica.juego.estrategia.aliado.Disparar;
import logica.juego.estrategia.aliado.Explotar;
import logica.juego.estrategia.aliado.GenerarSoles;
import logica.juego.estrategia.aliado.Pasivo;
import logica.juego.estrategia.enemigo.Caminar;
import logica.juego.estrategia.enemigo.Comer;

public interface VisitorTimer {
	
	public void visit(GenerarSoles g);
	
	public void visit(Explotar e);
	
	public void visit(Pasivo p);
	
	public void visit(Disparar d);
	
	public void visit(Caminar c);
	
	public void visit(Comer c);
	
	public void visit(Desplazamiento d);
	
}
