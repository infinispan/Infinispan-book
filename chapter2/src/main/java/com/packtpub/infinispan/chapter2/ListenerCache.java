package com.packtpub.infinispan.chapter2;

import java.util.Set;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

import com.packtpub.infinispan.chapter2.listener.SimpleListener;
import model.Ticket;
import utils.IOUtils;

public class ListenerCache {

	public void start()  {
		SimpleListener listener = new SimpleListener();
		
		DefaultCacheManager manager = new DefaultCacheManager();
		manager.addListener(listener);
		
		Cache<Integer, Ticket> cache = manager.getCache();
		cache.addListener(listener);
		String command = ""; // Line read from standard in
		int ticketid = 1;

		IOUtils.dumpWelcomeMessage();

		while (true){
			command = IOUtils.readLine("> ");
			if (command.equals("book")) {

				String name = IOUtils.readLine("Enter name ");
				String show = IOUtils.readLine("Enter show ");

				Ticket ticket = new Ticket(name,show);
				cache.put(ticketid, ticket);
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
				for (Integer ticket: set) {
					System.out.println(cache.get(ticket));
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
		new ListenerCache().start();

	}
	public static void log(String s){
		System.out.println(s);
	}
}
