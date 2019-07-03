package com.trainingbasket.beans;

public class SalesData {

	static int tempId;
	int id;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.MONTH_ID+"\n"
				+ this.ORDERDATE+"\n"+
				this.ORDERLINENUMBER+"\n"+
				this.ORDERNUMBER;
	}
 public static int getTempId() {
		return tempId;
	}

	public static void setTempId(int tempId) {
		SalesData.tempId = tempId;
	}

	public String getORDERNUMBER() {
		return ORDERNUMBER;
	}

	public void setORDERNUMBER(String oRDERNUMBER) {
		ORDERNUMBER = oRDERNUMBER;
	}

	public String getQUANTITYORDERED() {
		return QUANTITYORDERED;
	}

	public void setQUANTITYORDERED(String qUANTITYORDERED) {
		QUANTITYORDERED = qUANTITYORDERED;
	}

	public String getPRICEEACH() {
		return PRICEEACH;
	}

	public void setPRICEEACH(String pRICEEACH) {
		PRICEEACH = pRICEEACH;
	}

	public String getORDERLINENUMBER() {
		return ORDERLINENUMBER;
	}

	public void setORDERLINENUMBER(String oRDERLINENUMBER) {
		ORDERLINENUMBER = oRDERLINENUMBER;
	}

	public String getSALES() {
		return SALES;
	}

	public void setSALES(String sALES) {
		SALES = sALES;
	}

	public String getORDERDATE() {
		return ORDERDATE;
	}

	public void setORDERDATE(String oRDERDATE) {
		ORDERDATE = oRDERDATE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getQTR_ID() {
		return QTR_ID;
	}

	public void setQTR_ID(String qTR_ID) {
		QTR_ID = qTR_ID;
	}

	public String getMONTH_ID() {
		return MONTH_ID;
	}

	public void setMONTH_ID(String mONTH_ID) {
		MONTH_ID = mONTH_ID;
	}

	public int getId() {
		return id;
	}

String ORDERNUMBER;
	String QUANTITYORDERED;
	String PRICEEACH;
	String ORDERLINENUMBER;
	String SALES;
	String ORDERDATE;
	String STATUS;
	String QTR_ID;
	String MONTH_ID;

	public SalesData() {
		this.id = ++tempId;
	}

}
