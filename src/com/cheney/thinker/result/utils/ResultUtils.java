package com.cheney.thinker.result.utils;

import com.alibaba.fastjson.JSON;
import com.cheney.thinker.result.core.ResultCode;
import com.cheney.thinker.result.core.ResultGenerator;

public final class ResultUtils {
	
	public static String success() {
		return JSON.toJSONString(ResultGenerator.genSuccessResult());
	}
	
	public static String success(String msg) {
		return JSON.toJSONString(ResultGenerator.genSuccessResult(msg));
	}
	
	public static String success(Object data) {
		return JSON.toJSONString(ResultGenerator.genSuccessResult(data));
	}
	
	public static String fail() {
		return JSON.toJSONString(ResultGenerator.genFailResult());
	}
	
	public static String fail(ResultCode code) {
		return JSON.toJSONString(ResultGenerator.genFailResult(code));
	}

    public static String fail(Exception e, String defaultMessage) {
    	return JSON.toJSONString(ResultGenerator.genFailResult(CheckUtils.getMessageOrDefault(e, defaultMessage)));
    }
    
    public static String fail(ResultCode code, Exception e, String defaultMessage) {
    	return JSON.toJSONString(ResultGenerator.genFailResult(code, CheckUtils.getMessageOrDefault(e, defaultMessage)));
    }

}
