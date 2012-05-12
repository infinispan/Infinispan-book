package com.packtpub.infinispan.chapter3;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

import com.packtpub.infinispan.chapter3.model.Ticket;
import com.packtpub.infinispan.chapter3.utils.IOUtils;

public class InterceptorCache {

	public void start()  {
		DefaultCacheManager m=null;
		try {
			m = new DefaultCacheManager("interceptor.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cache<Integer, Ticket> cache = m.getCache("cacheWithCustomInterceptors");        

		 
		int ticketid = 1;

		while (ticketid < 1500){

			String name = UUID.randomUUID().toString();
			String show = UUID.randomUUID().toString();

			Ticket ticket = new Ticket(name,show);
			cache.put(ticketid, ticket);
			ticketid++;
		}


	}

	public static void main(String[] args) {
		new InterceptorCache().start();

	}
	public static void log(String s){
		System.out.println(s);
	}
}
