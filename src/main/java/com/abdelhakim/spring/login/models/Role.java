package com.abdelhakim.spring.login.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles") // Blast @Entity o @Table
public class Role {
  @Id // String hna 7ssan f MongoDB bash y-generate l-id automatic
  private String id;

  private ERole name; // MongoDB ghadi t-sauvegarder l-Enum kima houwa

  public Role() {
  }

  public Role(ERole name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }
}