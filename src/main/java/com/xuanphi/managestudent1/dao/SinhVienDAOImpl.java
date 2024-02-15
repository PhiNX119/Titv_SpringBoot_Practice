package com.xuanphi.managestudent1.dao;

import com.xuanphi.managestudent1.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SinhVienDAOImpl implements SinhVienDAO {
    private EntityManager entityManager;

    @Autowired
    public SinhVienDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(SinhVien sinhVien) {
        this.entityManager.persist(sinhVien);
    }

    @Override
    public SinhVien getById(int id) {
        return this.entityManager.find(SinhVien.class, id);
    }

    @Override
    public List<SinhVien> getAll() {
        String jpql = "SELECT s FROM SinhVien s";
        return this.entityManager.createQuery(jpql, SinhVien.class).getResultList();
    }

    @Override
    public List<SinhVien> getByName(String ten) {
        String jpql = "SELECT s FROM SinhVien s WHERE s.ten LIKE :ten";
        TypedQuery<SinhVien> query = this.entityManager.createQuery(jpql, SinhVien.class);
        query.setParameter("ten","%" + ten + "%");
        return query.getResultList();
    }

    @Override
    public SinhVien update(SinhVien sinhVien) {
        return this.entityManager.merge(sinhVien);
    }

    @Override
    public int updateAllSinhVien(String ten) {
        String jpql = "UPDATE SinhVien s SET s.ten = :ten";
        Query query = this.entityManager.createQuery(jpql);
        query.setParameter("ten", ten);
        return query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        SinhVien sinhVien = this.entityManager.find(SinhVien.class, id);
        this.entityManager.remove(sinhVien);
    }

    @Override
    public int deleteByName(String ten) {
        String jpql = "DELETE FROM SinhVien s WHERE s.ten LIKE :ten";
        Query query = this.entityManager.createQuery(jpql);
        query.setParameter("ten","%" + ten + "%");
        return query.executeUpdate();
    }
}
