// package com.metrodata.ServiceEmploye.Models.Entity;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.annotation.JsonProperty.Access;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import lombok.Data;

// @AllArgsConstructor
// @NoArgsConstructor
// @Data
// @Entity
// @Table(name = "tb_privilege")
// public class Privilege {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "prv_id")
//     private Integer id;

//     @Column(nullable = false, name="prv_name")
//     private String name;

//     @ManyToMany(mappedBy = "privileges")
//     @JsonProperty(access = Access.WRITE_ONLY)
//     private List<Role> role;

// }
