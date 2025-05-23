package baitap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CTrinhChinh {

    private List<Tuan> danhSachTuan;
    private final LocalDate ngayBatDauHK;

    public CTrinhChinh() {
        this.danhSachTuan = new ArrayList<>();
        this.ngayBatDauHK = LocalDate.of(2025, 1, 13);
    }

    private Tuan getOrCreateTuan(int soTuan) {
        for (Tuan tuan : danhSachTuan) {
            if (tuan.getSoTuan() == soTuan) {
                return tuan;
            }
        }
        Tuan tuanMoi = new Tuan(soTuan);
        danhSachTuan.add(tuanMoi);
        System.out.println("Tạo tuần mới: " + soTuan);
        return tuanMoi;
    }

    public void themLichHoc(LichHoc lichHoc) {
        String thoiGianHoc = lichHoc.getThoiGianHoc();
        if (thoiGianHoc == null || thoiGianHoc.isEmpty()) {
            System.out.println("Lỗi: Thời gian học không hợp lệ cho môn " + lichHoc.getMaMH() + ": " + thoiGianHoc);
            return;
        }
        int soThu = lichHoc.getThu();
        if (soThu < 2 || soThu > 7) {
            System.out.println("Lỗi: Thứ không hợp lệ cho môn " + lichHoc.getMaMH() + ": " + soThu);
            return;
        }
        // Chuẩn hóa thoiGianHoc
        if (thoiGianHoc.length() > 50) {
            thoiGianHoc = thoiGianHoc.substring(0, 50);
        } else if (thoiGianHoc.length() < 20) {
            thoiGianHoc = String.format("%-" + 50 + "s", thoiGianHoc).replace(' ', '-');
        }
        for (int i = 0; i < thoiGianHoc.length() && i <50; i++) {
            char c = thoiGianHoc.charAt(i);
            if (c != '-' && !Character.isDigit(c)) {
                System.out.println("Lỗi: Ký tự không hợp lệ trong thời gian học của môn " + lichHoc.getMaMH() + ": " + c);
                return;
            }
            if (c != '-') {
                int digit = Character.getNumericValue(c); // Ký tự 0-9
                // Tính tuần tương ứng
                int soTuan = (i % 10) + 1; // Tuần 1-10
                if (i >= 10) {
                    soTuan += 10; // Tuần 11-20
                }
                // Kiểm tra ký tự có khớp với tuần
                int expectedDigit = soTuan % 10;
                if (expectedDigit == 0) expectedDigit = 10;
                if (digit == (expectedDigit % 10)) {
                    Tuan tuan = getOrCreateTuan(soTuan);
                    Thu thu = tuan.getThu(soThu);
                    if (thu == null || !thu.getDsLich().contains(lichHoc)) {
                        tuan.themLichHoc(soThu, lichHoc);
                        System.out.println("Thêm lịch học: " + lichHoc.getMaMH() + " vào tuần " + soTuan + ", thứ " + soThu);
                    }
                }
            }
        }
    }

    public void hienThiThoiKhoaBieu() {
        if (danhSachTuan.isEmpty()) {
            System.out.println("Thời khóa biểu trống.");
            return;
        }
        danhSachTuan.sort((t1, t2) -> Integer.compare(t1.getSoTuan(), t2.getSoTuan()));
        for (Tuan tuan : danhSachTuan) {
            System.out.println(tuan);
        }
    }

    public List<LichHoc> timLichHocTheoThu(String soThu) {
        List<LichHoc> ketQua = new ArrayList<>();
        try {
            int thu = Integer.parseInt(soThu);
            if (thu < 2 || thu > 7) {
                System.out.println("Lỗi: Thứ không hợp lệ: " + soThu);
                return ketQua;
            }
            for (Tuan tuan : danhSachTuan) {
                Map<Integer, Thu> dsThu = tuan.getDsThu();
                Thu thuObj = dsThu.get(thu);
                if (thuObj != null) {
                    ketQua.addAll(thuObj.getDsLich());
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Định dạng thứ không hợp lệ: " + soThu);
        }
        return ketQua;
    }

    public Tuan timLichHocTheoTuan(int soTuan) {
        for (Tuan tuan : danhSachTuan) {
            if (tuan.getSoTuan() == soTuan) {
                System.out.println("Tìm thấy tuần " + soTuan + " với " + tuan.getDsThu().size() + " thứ.");
                return tuan;
            }
        }
        System.out.println("Không tìm thấy tuần " + soTuan);
        return null;
    }

    public List<LichHoc> timLichHocTheoNgay(LocalDate date) {
        List<LichHoc> ketQua = new ArrayList<>();
        int dayOfWeek = date.getDayOfWeek().getValue();
        if (dayOfWeek == 7) {
            System.out.println("Chủ Nhật không có lịch học.");
            return ketQua;
        }
        String soThu = String.valueOf(dayOfWeek + 1);
        long daysSinceStart = java.time.temporal.ChronoUnit.DAYS.between(ngayBatDauHK, date);
        int soTuan = (int) (daysSinceStart / 7) + 1;
        System.out.println("Tìm lịch học: Ngày " + date + ", thứ " + soThu + ", tuần " + soTuan);
        if (soTuan < 1 || soTuan > 20) {
            System.out.println("Ngày " + date + " ngoài phạm vi học kỳ.");
            return ketQua;
        }
        Tuan tuan = timLichHocTheoTuan(soTuan);
        if (tuan != null) {
            Thu thu = tuan.getThu(Integer.parseInt(soThu));
            if (thu != null) {
                ketQua.addAll(thu.getDsLich());
                System.out.println("Tìm thấy " + ketQua.size() + " lịch học cho thứ " + soThu + ", tuần " + soTuan);
            } else {
                System.out.println("Không tìm thấy thứ " + soThu + " trong tuần " + soTuan);
            }
        }
        return ketQua;
    }

    public int getCurrentWeek(LocalDate date) {
        long daysSinceStart = java.time.temporal.ChronoUnit.DAYS.between(ngayBatDauHK, date);
        int soTuan = (int) (daysSinceStart / 7) + 1;
        if (soTuan < 1) {
            System.out.println("Cảnh báo: Ngày " + date + " trước ngày bắt đầu học kỳ.");
        } else if (soTuan > 20) {
            System.out.println("Cảnh báo: Ngày " + date + " ngoài phạm vi học kỳ.");
        }
        return Math.max(1, Math.min(20, soTuan));
    }
}