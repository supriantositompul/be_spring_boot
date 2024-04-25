// package com.metrodata.ServiceEmploye.Models.Entity;

// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.annotation.JsonProperty.Access;
// import java.util.List;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.MapsId;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Entity
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "user")
// public class User {

//     @Id // * -> primary key = not null & unique
//     private Integer id;

//     @Column(nullable = false, unique = true)
//     private String username;

//     @Column(nullable = false)
//     private String password;

//     private Boolean isEnabled = true;

//     @OneToOne
//     @MapsId
//     @JoinColumn(name = "id")
//     @JsonProperty(access = Access.WRITE_ONLY)
//     private Employee employee;

//     @ManyToMany(fetch = FetchType.EAGER)
//     @JoinTable(name = "tb_tr_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//     private List<Role> roles;
// }
