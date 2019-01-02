package com.quick4j.serialization;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author x00015
 *	被序列化的类在kryo序列化上注册
 */
public class Serialization implements SerializationOptimizer {

	    @SuppressWarnings("rawtypes")
		public Collection<Class> getSerializableClasses() {
	        List<Class> classes = new LinkedList<Class>();
	        return classes;
	    }

}
