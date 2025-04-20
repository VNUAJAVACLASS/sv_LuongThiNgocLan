package bai_toan_tin_chi;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		UserDao userDao=new UserDao();
		SubjectDao subjectDao= new SubjectDao();
		UserSubjectDao userSubjectDao = new UserSubjectDao();
		UserSubjectView userSubjectView = new UserSubjectView();
		
		while(true) {
			System.out.println("\n---Danh sach chon---");
			System.out.println("1.Them user");
			System.out.println("2.Them subject");
			System.out.println("3.Gan mon hoc vua roi cho user(va nhap 5 diem)");
			System.out.println("4.Xem user hoc mon gi va diem");
			System.out.println("Chon: ");
			
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1:
				System.out.println("Nhap ho ten: ");
				String hoTen=sc.nextLine();
				System.out.println("Nhap dia chi: ");
				String diachi=sc.nextLine();
				System.out.println("Nhap mat khau: ");
				String matkhau = sc.nextLine();
				System.out.println("Nhap loai:");
				String loai=sc.nextLine();
				User user= new User(hoTen, diachi, matkhau, loai);
				userDao.addUser(user);
				break;
			
			case 2:
				System.out.println("Nhap ten mon hoc: ");
				String tenMh=sc.nextLine();
				System.out.println("Nhap so tin chi: ");
				int soTC = sc.nextInt();
				System.out.println("Nhap he so 1:");
				int heSo1=sc.nextInt();
				System.out.println("Nhap he so 2:");
				int heSo2=sc.nextInt();
				System.out.println("Nhap he so 3:");
				int heSo3=sc.nextInt();
				System.out.println("Nhap he so 4:");
				int heSo4=sc.nextInt();
				System.out.println("Nhap he so 5:");
				int heSo5=sc.nextInt();
				Subject subject = new Subject(tenMh, soTC, heSo1, heSo2, heSo3, heSo4, heSo5);
				subjectDao.addSubject(subject);
				break;
				
			case 3:
				System.out.println("Nhap ma nguoi dung: ");
				int maND=sc.nextInt();
				System.out.println("Nhap ma mon hoc: ");
				int maMH = sc.nextInt();
				System.out.println("Nhap diem 1:");
				float diem1=sc.nextFloat();
				System.out.println("Nhap diem 2:");
				float diem2=sc.nextFloat();
				System.out.println("Nhap diem 3:");
				float diem3=sc.nextFloat();
				System.out.println("Nhap diem 4:");
				float diem4=sc.nextFloat();
				System.out.println("Nhap diem 5:");
				float diem5=sc.nextFloat();
				UserSubject userSubject = new UserSubject(maND, maMH, diem1, diem2, diem3, diem4, diem5);
				userSubjectDao.addUserSubject(userSubject);
				break;
				
			case 4:
				userSubjectView.showUserSubject();
				break;
			}
		}
	}
}
