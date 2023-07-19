package com.kenny.tastetracker.Repository;

import com.kenny.tastetracker.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findRestaurantsById(Long restaurantID);

    @Query("SELECT r FROM Restaurant r WHERE r.latitude >= :latitudeMin AND r.longitude <= :latitudeMax AND r.longitude >= :longitudeMin AND r.longitude <= :longitudeMax")
    List<Restaurant> findRestaurantByLocation(@Param("latitudeMin") double latitudeMin, @Param("latitudeMax") double latitudeMax,
                                              @Param("longitudeMin") double longitudeMin, @Param("longitudeMax") double longitudeMax);
}

