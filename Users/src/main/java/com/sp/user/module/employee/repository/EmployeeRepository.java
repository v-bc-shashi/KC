package com.sp.user.module.employee.repository;

import com.sp.user.base.repository.BaseRepository;
import com.sp.user.module.employee.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<EmployeeEntity, EmployeeEntity.PrimaryKey> {



}
