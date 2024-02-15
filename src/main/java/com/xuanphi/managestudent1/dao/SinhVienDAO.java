package com.xuanphi.managestudent1.dao;

import com.xuanphi.managestudent1.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);

    public SinhVien getById(int id);

    public List<SinhVien> getAll();

    public List<SinhVien> getByName(String ten);

    public SinhVien update(SinhVien sinhVien);

    public int updateAllSinhVien(String ten);

    public void delete(int id);

    public int deleteByName(String ten);
}
