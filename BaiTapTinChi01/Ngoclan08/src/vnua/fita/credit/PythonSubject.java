package vnua.fita.credit;

public abstract class PythonSubject extends Subject{
	private float diemCC;
	private float diemBTL;
	private float diemGK; 
	private float diemCK;
	
	public PythonSubject() {
	
	}
	
	public PythonSubject(float diemCC, float diemGK,float diemCK,float diemBTL) {
		this.diemCC = diemCC;
		this.diemGK = diemGK;
		this.diemCK = diemCK;
		this.diemBTL = diemBTL;
	}
	
	@Override
	public float calSubjectMark() {
		return (diemCC + 2*diemBTL + 2*diemGK + 5*diemCK)/10;
	}
}
