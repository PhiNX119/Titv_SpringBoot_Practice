package com.xuanphi.managestudent1.common;

import com.xuanphi.managestudent1.dao.SinhVienDAOImpl;
import com.xuanphi.managestudent1.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    public static Scanner scanner = new Scanner(System.in);

    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl) {
        return runner -> {
            System.out.println("HELLO WORLD");
            while (true) {
                inMenu();
                int choose = scanner.nextInt();
                scanner.nextLine();
                if (choose == 1) {
                    themSinhVien(sinhVienDAOImpl);
                } else if (choose == 2) {
                    timSinhVien(sinhVienDAOImpl);
                } else if (choose == 3) {
                    for (SinhVien s : sinhVienDAOImpl.getAll()) {
                        System.out.println(s);
                    }
                } else if (choose == 4) {
                    timSinhVienBangTen(sinhVienDAOImpl);
                } else if (choose == 5) {
                    capNhatSinhVienTheoId(sinhVienDAOImpl);
                } else if (choose == 6) {
                    timSinhVienBangTen(sinhVienDAOImpl);
                } else if (choose == 7) {
                    xoaSinhVienTheoId(sinhVienDAOImpl);
                } else if (choose == 8) {
                    xoaSinhVienTheoTen(sinhVienDAOImpl);
                } else {
                    return;
                }
            }
        };
    }


    public void themSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        //Lay tong tin sinh vien
        System.out.print("Nhap ho dem: ");
        String ho_dem = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String ten = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();
        SinhVien sinhVien = new SinhVien(ho_dem, ten, email);
        //Luu vao CSDL
        sinhVienDAOImpl.save(sinhVien);
    }

    private void timSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        System.out.print("Nhap ma sinh vien: ");
        int id = scanner.nextInt();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if (sinhVien == null) {
            System.out.println("Khong tim thay.");
        } else {
            System.out.println(sinhVien);
        }
    }

    public void timSinhVienBangTen(SinhVienDAOImpl sinhVienDAOImpl) {
        System.out.print("Nhap ten sinh vien: ");
        String ten = scanner.nextLine();
        List<SinhVien> sinhViens = sinhVienDAOImpl.getByName(ten);
        if (sinhViens.size() == 0) {
            System.out.println("Khong tim thay.");
        } else {
            for (SinhVien s : sinhViens) {
                System.out.println(s);
            }
        }
    }

    private void capNhatSinhVienTheoId(SinhVienDAOImpl sinhVienDAOImpl) {
        System.out.print("Nhap id sinh vien: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if (sinhVien == null) {
            System.out.println("Khong tim thay.");
        } else {
            System.out.print("Nhap ho dem: ");
            String hoDem = scanner.nextLine();
            sinhVien.setHoDem(hoDem);
            System.out.print("Nhap ten: ");
            String ten = scanner.nextLine();
            sinhVien.setTen(ten);
            System.out.print("Nhap email: ");
            String email = scanner.nextLine();
            sinhVien.setEmail(email);
            sinhVienDAOImpl.update(sinhVien);
            System.out.println(sinhVien);
        }
    }

    private void capNhatTatCaSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        System.out.print("Nhap ten: ");
        String ten = scanner.nextLine();
        int rows = sinhVienDAOImpl.updateAllSinhVien(ten);
        if (rows <= 0) {
            System.out.println("Cap nhat khong thanh cong.");
        }
    }

    private void xoaSinhVienTheoId(SinhVienDAOImpl sinhVienDAOImpl) {
        System.out.print("Nhap id sinh vien: ");
        int id = scanner.nextInt();
        sinhVienDAOImpl.delete(id);
    }

    private void xoaSinhVienTheoTen(SinhVienDAOImpl sinhVienDAOImpl) {
        System.out.print("Nhap ten: ");
        String ten = scanner.nextLine();
        int rows = sinhVienDAOImpl.deleteByName(ten);
        if (rows <= 0) {
            System.out.println("Cap nhat khong thanh cong.");
        }
    }

    public void inMenu() {
        System.out.println("=======================");
        System.out.print("MENU:\n" +
                "1. Them sinh vien\n" +
                "2. Tim sinh vien\n" +
                "3. Danh sach sinh vien\n" +
                "4. Tim sinh vien theo ten\n" +
                "5. Cap nhat sinh vien theo id\n" +
                "6. Cap nhat tat ca sinh vien\n" +
                "7. Xoa sinh vien theo id\n" +
                "8. Xoa sinh vien theo ten\n" +
                "Lua chon: ");
    }
}
