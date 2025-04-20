package vnua.fita.credit;

public abstract  class JavaSubject extends Subject {
	private float diemCC; 
	private float diemGK; 
	private float diemCK;
	
	public JavaSubject() {
	
	}
	
	public JavaSubject(float diemCC, float diemGK,float diemCK) {
		this.diemCC = diemCC;
		this.diemGK = diemGK;
		this.diemCK = diemCK;
	}
	
	@Override
	public float calSubjectMark() {
		return (diemCC + 4*diemGK + 5*diemCK)/10;
	}
	
	
	
}

