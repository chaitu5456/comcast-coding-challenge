package com.comcast.coding;

class Options {

	private String inputSource;
	private String numberFormat;
	private String inputData;
	
	public Options(String inputSource, String numberFormat) {
		this.inputSource = inputSource;
		this.numberFormat = numberFormat;
	}

	public String getInputSource() {
		return inputSource;
	}

	public void setInputSource(String inputSource) {
		this.inputSource = inputSource;
	}

	public String getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat(String numberFormat) {
		this.numberFormat = numberFormat;
	}

	public String getInputData() {
		return inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	@Override
	public String toString() {
		return "Options [inputSource=" + inputSource + ", numberFormat=" + numberFormat + ", inputData=" + inputData
				+ "]";
	}
	
	
}
