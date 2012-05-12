package com.packtpub.infinispan.chapter4.model;

import java.io.Serializable;

public class Ticket implements Serializable {
@Override
	public String toString() {
		return "Ticket [name=" + name + ", show=" + show + "]";
	}
private String name;
private String show;
public Ticket(String name, String show) {
	super();
	this.name = name;
	this.show = show;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getShow() {
	return show;
}
public void setShow(String show) {
	this.show = show;
}
}
