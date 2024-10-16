package com.servermanagement.data.Repository;

import com.servermanagement.data.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {
     Server findByIpAddress(String ipAddress);

}
