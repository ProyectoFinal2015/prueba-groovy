package org.uqbarproject.wollokui

class GameBoard {
	def updated
	def objetosVivientes = []
	
	public GameBoard(){
		updated = false
	}
	
	def addObject(Object unObjeto){
		this.objetosVivientes.add(unObjeto)
	}	
	
	def updateGameBoard(Object unObjeto){
		this.updated = true
	}
	
}
