package ite.ite204.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ite.ite204.models.Java_Mid;

public interface Java_MidRepository extends JpaRepository<Java_Mid, Integer> {
    // Custom query methods can be defined here if needed
    // For example, find by name or major
    List<Java_Mid> findByName(String name);
    List<Java_Mid> findByMajor(String major);

}
