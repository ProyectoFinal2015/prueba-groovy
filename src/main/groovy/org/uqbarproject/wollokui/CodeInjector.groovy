package org.uqbarproject.wollokui


class CodeInjector {
	def inject(Object unObjeto) {
		unObjeto.metaClass.setearNombre = {String unNombre ->
			delegate.nombre = unNombre + " el pistolero"
		}
	}
	
	def addListener(Object unObjeto, GameBoard miModelo){	
		unObjeto.metaClass.invokeMethod = {String methodName, args ->
			def returnValue = delegate.metaClass.getMetaMethod( methodName, args ).invoke( delegate, args )
			if (methodName.toLowerCase().contains("set"))
				miModelo.updateGameBoard(delegate)
			returnValue
		 }
	}
}
