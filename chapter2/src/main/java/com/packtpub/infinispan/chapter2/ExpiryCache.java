package com.packtpub.infinispan.chapter2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

import model.Ticket;
import utils.IOUtils;

public class ExpiryCache {

	public void start()  {
		DefaultCacheManager m = new DefaultCacheManager();
		Cache<Integer, Ticket> cache = m.getCache();
		String command = ""; // Line read from standard in
		int ticketid = 1;
		
		IOUtils.dumpWelcomeMessage();
		
		while (!(command.equals("quit"))){
			command = IOUtils.readLine("> ");
			if (command.equals("book")) {
				
				String name = IOUtils.readLine("Enter name ");
				String show = IOUtils.readLine("Enter show ");
				
				Ticket ticket = new Ticket(name,show);
				cache.put(ticketid, ticket, 60, TimeUnit.SECONDS);
				
				log("Booked ticket "+ticket);
				ticketid++;
			}
			else if (command.equals("pay")) {
				Integer id = new Integer(IOUtils.readLine("Enter ticketid "));
				Ticket ticket = cache.remove(id);
				log("Checked out ticket "+ticket);
			}
			else if (command.equals("list")) {
				Set <Integer> set = cache.keySet();
				for (Integer id: set) {
					log(id + " " +cache.get(id));
				}
            }
			else if (command.equals("quit")) {
				cache.stop();
				log("Bye");
				break;
			}
			else {
				log("Unknown command "+command);
				IOUtils.dumpWelcomeMessage();
			}
		}
		
		
		 
		
	}
	
	public static void main(String[] args) {
		new ExpiryCache().start();

	}
    public static void log(String s){
    	System.out.println(s);
    }
}
