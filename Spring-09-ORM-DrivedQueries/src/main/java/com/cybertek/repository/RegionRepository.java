package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {
    //display all regions in Canada
    List<Region> findByCountry(String country);

    //Display all regions in canada without duplicates
    List<Region> findDistinctByCountry(String country);

    //display all regions with country name includes "United"
    List<Region> findByCountryContaining(String country);

    //display all countries with country names includes "United" in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    //Display top 2 regions in canada
    List<Region> findTop2ByCountry(String country);
}
