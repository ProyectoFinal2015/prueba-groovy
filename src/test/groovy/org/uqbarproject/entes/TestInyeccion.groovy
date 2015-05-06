package org.uqbarproject.entes

import org.junit.Assert;
import org.junit.Before
import org.junit.Test
import org.uqbarproject.wollokui.GameBoard

class TestInyeccion {
	def pepe
	def pedro
	def CodeInjector inyectorDeCodigo
	def tablero
	
	@Before
	def void init(){
		this.pepe = new PersonaGroovy()
		this.pedro = new Persona()
		this.inyectorDeCodigo = new CodeInjector()
		this.tablero = new GameBoard()
	}
	
	@Test
	def void inyectounMetodoSetNombre(){
		inyectorDeCodigo.inject(pepe)
		pepe.setearNombre("pepito")
		Assert.assertEquals("pepito el pistolero",pepe.getNombre())
	}
	
	@Test
	def void inyectounMetodoSetNombreJava(){
		inyectorDeCodigo.inject(pedro)
		pedro.setearNombre("pedrito")
		Assert.assertEquals("pedrito el pistolero",pedro.getNombre())
	}
	
	@Test
	def void prueboSetPropertyConListener(){
		inyectorDeCodigo.addListener(pepe,tablero)
		pepe.setNombre("pepin")
		Assert.assertEquals(true,tablero.getUpdated())
	}
	
	@Test
	def void prueboSetPropertyConListenerJava(){
		inyectorDeCodigo.addListener(pedro,tablero)
		pedro.setNombre("pepin")
		Assert.assertEquals(true,tablero.getUpdated())
	}
	
	@Test
	def void prueboMetodoNoSetYNoModificaElTablero(){
		inyectorDeCodigo.addListener(pepe,tablero)
		pepe.metodoAlPedo()
		Assert.assertEquals(false,tablero.getUpdated())
	}
}
