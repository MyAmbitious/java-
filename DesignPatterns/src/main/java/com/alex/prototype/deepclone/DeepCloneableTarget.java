package com.alex.prototype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cloneName;

	private String cloneClass;

	public DeepCloneableTarget(String cloneName, String cloneClass) {
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}

	//因为该类的成员变量都是 String 所以默认的浅拷贝都会克隆
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
