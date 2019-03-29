package com.wyatabe.interview.boot.exception;

@SuppressWarnings("serial")
public class ObjectNotFoundException extends RuntimeException  {
	
	public ObjectNotFoundException(Class<?> classe, Long id) {
		super(String.format("Objeto %s com o Id = %d não econtrada.", classe.getName(), id));
	}
	
}
