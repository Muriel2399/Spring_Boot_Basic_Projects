package com.telusko.SpringBootRestAPI.Repository;

import com.telusko.SpringBootRestAPI.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    List<UserDetails> findByRole(String roleAdmin);

    List<UserDetails> findFirstById(long id);
}
