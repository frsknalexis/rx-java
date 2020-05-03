package com.dev.reactive.app.observable;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

public class ColdObservable {

	private static final Logger logger = LoggerFactory.getLogger(ColdObservable.class);
	
	public static void main(String...strings) {
		
		//cold observable
		logger.info("cold Observable");
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(16);
		list.add(17);
		list.add(18);
		
		Observable<Integer> source = Observable.fromIterable(list);
		source.subscribe((i) -> logger.info("onNext -> {}", i));
		
		list = getData(list);
		
		source.subscribe(i -> logger.info("onNext -> {}", i));
	}
	
	private static List<Integer> getData(List<Integer> list){
		list.add(19);
		return list;
	}
	
	//hot observable
	
}