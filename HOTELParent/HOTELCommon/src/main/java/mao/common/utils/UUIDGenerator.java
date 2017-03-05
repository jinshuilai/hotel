/*
 * Copyright © 2016 uerp.net. All rights reserved.
 */
package mao.common.utils;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class UUIDGenerator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6167559625231163872L;

	public static String getUID() {
		UUID uuid = UUID.randomUUID();	
		ByteBuffer bbuffer = ByteBuffer.allocate(21).putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits());
		String base64 = new String(Base64.encodeBase64(bbuffer.array())).substring(0, 27);	
		if(base64.contains("/"))
		{
			base64=base64.replaceAll("/", "");
		}
		if(base64.contains("+")){
			base64=base64.replaceAll("\\+", "");
		}
		return base64+"=";
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			System.out.println(getUID());
		}
	}
}
