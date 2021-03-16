package com.dlls.pecacerta.api.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SuppressWarnings("rawtypes")
@Component
public class ServiceFactory {
	    private final Map<String, BaseService> impletationMap = new HashMap<>();

	    @Autowired
	    ApplicationContext context;

	    @PostConstruct
	    public void initialize() {
	        populateDataMapperMap(context.getBeansOfType(BaseService.class).values().iterator());
	    }

	    private void populateDataMapperMap(final Iterator<BaseService> classIterator) {
	        while (classIterator.hasNext()) {
				BaseService abstractClassImpl = (BaseService) classIterator.next();
	            impletationMap.put(abstractClassImpl.getClass().getName(), abstractClassImpl);

	        }
	    }
}
