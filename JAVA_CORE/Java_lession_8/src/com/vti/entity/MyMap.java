package com.vti.entity;

import java.util.HashMap;

public class MyMap<K, V> {
	private K key;
	private V value;

	public MyMap(K key, V value) {

		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
