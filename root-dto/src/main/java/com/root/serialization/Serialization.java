package com.root.serialization;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.root.dto.*;

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
//			classes.add(LrzjlResult.class);
//			classes.add(LrzjlResultInteger.class);
//			classes.add(LrzjlResultLong.class);
//			classes.add(LrzjlResultList.class);
//			classes.add(LrzjlResultItem.class);
	        return classes;
	    }

}
