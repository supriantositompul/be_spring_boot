package com.metrodata.ServiceEmploye.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.metrodata.ServiceEmploye.Models.Entity.Region;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Query("SELECT r FROM Region r WHERE r.name LIKE :name") // parameterized query = name paramater
    List<Region> searchNameByJPQL(@Param("name") String name);

    @Query(value = "SELECT * FROM `tb_region` r WHERE r.region_name LIKE ?1", // parameterized query = ?1
            nativeQuery = true)
    List<Region> searchNameByNative(String name);

    Optional<Region> findByName(String name);

}


