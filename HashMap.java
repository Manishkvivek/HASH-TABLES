package com.cg;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class HashMap<K, V> {
LinkedList<K> linkedList;
	
	public HashMap() {
		this.linkedList = new LinkedList<>();
	}
	
	public V get(K key) {
		MapNode<K, V> mapNode = (MapNode<K, V>)this.linkedList.searchValue(key);
		return (mapNode == null) ? null : mapNode.getValue();
	}
	
	public void add(K key, V value) {
		MapNode<K, V> mapNode = (MapNode<K, V>)this.linkedList.searchValue(key);
		if(mapNode == null) {
			mapNode = new MapNode<>(key, value);
			this.linkedList.append(mapNode);
		}
		else {
			mapNode.setValue(value);
		}
	}
	
	@Override
	public String toString() {
		return "MyHashMapNodes{" + LinkedHashSet + "}";
	}
	
}


