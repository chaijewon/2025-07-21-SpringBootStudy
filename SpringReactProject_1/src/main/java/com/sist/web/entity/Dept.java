package com.sist.web.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="dept")
@Data
public class Dept {
  @Id
  private int deptno;
  
  private String dname;
  private String loc;
  
  @OneToMany(mappedBy = "dept")
  private List<Emp> empList=new ArrayList<>();
}
