package org.uqbarproject.entes

import org.uqbarproject.wollokui.GameBoard

class CodeInjector {
	def inject(Object unObjeto) {
		unObjeto.metaClass.setearNombre = {String unNombre ->
			delegate.nombre = unNombre + " el pistolero"
		}
	}
	
	def addListener(Object unObjeto, GameBoard miModelo){	
		unObjeto.metaClass.invokeMethod = {String methodName, args ->
			if (methodName.toLowerCase().contains("set"))
				miModelo.updateGameBoard(delegate)
		 }
	}
}
