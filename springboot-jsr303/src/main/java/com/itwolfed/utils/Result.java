package com.itwolfed.utils;


import lombok.Getter;
import lombok.Setter;

/**
 * 自定义响应结构
 */
@Getter
@Setter
public class Result {

	// 响应业务状态
	private Integer status;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;


	public Result() {

	}

	public static Result ok(Object data) {

		return new Result(200 , data);
	}

	public static Result ok() {
		return new Result(200 , null);
	}

	public static Result build(Integer status, String msg) {
		return new Result(status, msg, null);
	}


	public static Result build(Integer status, String msg , Object data) {
		return new Result(status,msg,data);
	}

	public Result(Integer status,String msg) {
		this.status = status;
		this.msg = msg;
	}


	public Result(Integer status,Object data) {
		this.status = status;
		this.data = data;
	}

	public Result(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

}