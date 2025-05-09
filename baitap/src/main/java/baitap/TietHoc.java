package baitap;

public enum TietHoc {
	TIET_1("06:45"), TIET_2("07:35"), TIET_3("08:25"), TIET_4("09:15"), TIET_5("10:05"), TIET_6("10:55"),
	TIET_7("11:45"), TIET_8("12:35"), TIET_9("13:25"), TIET_10("14:15"), TIET_11("15:05"), TIET_12("15:55");

	private final String gioBD;

	TietHoc(String gioBD) {
		this.gioBD = gioBD;
	}

	public String getGioBD() {
		return gioBD;
	}

	public static String getGio(int tiet) {
		if (tiet >= 1 && tiet <= 12)
			return values()[tiet - 1].getGioBD();
		return "??:??";
	}
}
