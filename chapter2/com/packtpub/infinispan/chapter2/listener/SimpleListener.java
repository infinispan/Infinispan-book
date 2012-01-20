package com.packtpub.infinispan.chapter2.listener;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryRemoved;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryRemovedEvent;
import org.infinispan.notifications.cachemanagerlistener.annotation.CacheStarted;
import org.infinispan.notifications.cachemanagerlistener.annotation.CacheStopped;
import org.infinispan.notifications.cachemanagerlistener.event.CacheStartedEvent;
import org.infinispan.notifications.cachemanagerlistener.event.CacheStoppedEvent;

@Listener
public class SimpleListener {
	@CacheEntryCreated
	public void dataAdded(CacheEntryCreatedEvent event) {
		if (event.isPre()) {
			System.out.println("Going to add new entry " + event.getKey() + " created in the cache");
		}
		else {
			System.out.println("Added new entry " + event.getKey() + " to the cache"); 
		}
	}
	@CacheEntryRemoved
	public void dataRemoved(CacheEntryRemovedEvent event) {
		if (event.isPre()) {
			System.out.println("Going to remove entry " + event.getKey() + " created in the cache");
		}
		else {
			System.out.println("Removed entry " + event.getKey() + " from the cache"); 
		}

	}
	@CacheStarted
	public void cacheStarted(CacheStartedEvent event) {
		System.out.println("Cache Started");
	}
	@CacheStopped
	public void cacheStopped(CacheStoppedEvent event) {
		System.out.println("Cache Stopped");
	}
}
