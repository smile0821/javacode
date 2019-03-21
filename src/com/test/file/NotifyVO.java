package com.test.file;

import java.util.List;

public class NotifyVO
{
	private List<String> operationLst;
	private String operator;
	public List<String> getOperationLst() {
		return operationLst;
	}
	public void setOperationLst(List<String> operationLst) {
		this.operationLst = operationLst;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}