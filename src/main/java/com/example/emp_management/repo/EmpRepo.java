package com.example.emp_management.repo;

import com.example.emp_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Employee c SET c.name = :name,c.address= :address,c.email = :email,c.phone = :phone,c.salary = :salary WHERE c.id = :id")
    int updateEmp(@Param(value = "id")Integer id,@Param(value = "name") String name,@Param(value = "address")String address ,@Param(value = "email")String email,
                  @Param(value = "phone") String phone,@Param(value = "salary") Integer salary
                  );

}
