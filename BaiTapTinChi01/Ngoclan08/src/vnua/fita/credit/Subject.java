package vnua.fita.credit;

import java.util.Scanner;

public abstract class Subject {
	private String subjectCode;
	private String subjectName;
	private int credit; 
	
	public Subject() {
		
	}
	
	public Subject (String subjectCode, String subjectName, int credit) {
		this.subjectCode=subjectCode;
		this.subjectName=subjectName;
		this.credit=credit;
	}
	
	public abstract float calSubjectMark();
	
	public float calConversionMark() {
		float subjectMark=calSubjectMark();
		float conversionMark=-1;
		if(subjectMark <= 3.9) {
			conversionMark =0;
		}else if(subjectMark <=4.9) {
			conversionMark=1;
		}else if(subjectMark <=5.4) {
			conversionMark=1.5f;
		}else if(subjectMark<=6.4) {
			conversionMark=2;
		}else if(subjectMark <=6.9) {
			conversionMark=2.5f;
		}else if(subjectMark <=7.9) {
			conversionMark=3;
		}else if(subjectMark <=8.4) {
			conversionMark =3.5f;
		}else if(subjectMark<=10) {
			conversionMark=4;
		}
		
		return conversionMark;
	}
	
	public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade=null;
		if(subjectMark<0) {
			grade ="Error";
		}else if(subjectMark <3.9) {
			grade = "F";
		}else if(subjectMark<=4.9) {
			grade="D";
		}else if(subjectMark <=5.4) {
			grade="D+";
		}else if(subjectMark<=6.4) {
			grade="C";
		}else if(subjectMark <=6.9) {
			grade="C+";
		}else if(subjectMark <=7.9) {
			grade="B";
		}else if(subjectMark <=8.4) {
			grade ="B+";
		}else if(subjectMark <=10) {
			grade="A";
		}
		
		return grade;
	}

	//Chuyển từ hệ chữ sang hệ 4
	public float calConversionMark(String grade) {
		float conversionMark =-1;
		switch (grade) {
		case "F": 
			conversionMark=0;
			break;
		case "D":
			conversionMark=1;
			break;
		case "D+":
			conversionMark =1.5f;
			break;
		case "C":
			conversionMark =2;
			break;
		case "C+":
			conversionMark =2.5f;
			break;
		case "B":
			conversionMark =3;
			break;
		case "B+":
			conversionMark =3.5f;
			break;
		case "A":
			conversionMark =4;
			break;
		}
		
		return conversionMark;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return subjectName + "-" + subjectCode +"-" +credit +"-" +calSubjectMark() +"-"
				+ calConversionMark() +"-" +calGrade() ;
	}
}
