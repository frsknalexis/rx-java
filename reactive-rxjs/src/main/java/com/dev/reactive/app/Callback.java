package com.dev.reactive.app;

public interface Callback {

	void pushData(String data);
	
	void pushComplete();
	
	void pushError(Exception e);
}
