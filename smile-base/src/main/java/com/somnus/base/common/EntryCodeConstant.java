package com.somnus.base.common;

import java.util.Map;

public class EntryCodeConstant {
	
	public static Map<String,String> entryCodeMap;

	public static Map<String, String> getEntryCodeMap() {
		return entryCodeMap;
	}

	public static void setEntryCodeMap(Map<String, String> entryCodeMap) {
		EntryCodeConstant.entryCodeMap = entryCodeMap;
	}
	
	
}
