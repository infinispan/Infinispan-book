package com.packtpub.infinispan.chapter4;

import java.io.IOException;
import java.util.Set;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

import model.Ticket;
import utils.IOUtils;

public class ClusterCache {

	public void start()  {
		DefaultCacheManager m=null;
		try {
			m = new DefaultCacheManager("cluster.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cache<Integer, Ticket> cache = m.getCache("clusteredCache");

	 
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
		new ClusterCache().start();

	}
	public static void log(String s){
		System.out.println(s);
	}
}
