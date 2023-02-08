package com.adri.AdriInternship_KhalidRasool;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer user_id;

  @Column(name="user_name")
  private String user_name;

  @Column(name="email")
  private String email;

  @Column(name="information")
  private String information;

  public User(){
    
  }

public User( String name, String email, String information) {
    //this.user_id = id;
    this.user_name = name;
    this.email = email;
    this.information = information;
  }



  public Integer getId() {
    return user_id;
  }

  public void setId(Integer id) {
    this.user_id = id;
  }

  public String getName() {
    return user_name;
  }

  public void setName(String name) {
    this.user_name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }
}
