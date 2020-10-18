package com.cg;

import java.util.ArrayList;
import java.util.LinkedList;


public class LinkedHashMap {
	private final int numBuckets;
	ArrayList<LinkedList<K>> bucketArray;
	
	public LinkedHashMap() {
		this.numBuckets = 10;
		this.bucketArray = new ArrayList<>(numBuckets);
		for(int i =0; i < numBuckets; i++) {
			this.bucketArray.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numBuckets;
		System.out.println("Key : " + key + " HashCode : " + hashCode + " Index : " + index);
		return index;
	}
	
	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if(linkedList == null)	return null;
		MapNode<K, V> mapNode = (MapNode<K, V>)linkedList.searchValue(key);
		return (mapNode ==  null) ? null : mapNode.getValue();
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if(linkedList == null) {
			linkedList = new LinkedList<>();
			this.bucketArray.set(index, linkedList);
		}
		MapNode<K, V> mapNode = (MapNode<K, V>)linkedList.searchValue(key);
		if(mapNode == null) {
			mapNode = new MapNode<>(key, value);
			linkedList.append(mapNode);
		}
		else {
			mapNode.setValue(value);
		}
	}
	
	public MapNode<K, V> remove(K key){
		int index = this.getBucketIndex(key);
		LinkedList<K> myList = this.bucketArray.get(index);
		MapNode<K, V> mapNode = (MapNode<K, V>)myList.popValue(key);
		return (mapNode == null) ? null : mapNode;	
	}
	
}



