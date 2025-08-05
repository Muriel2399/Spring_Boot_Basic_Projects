package com.telusko.SpringBootRestAPI.Repository;

import com.telusko.SpringBootRestAPI.model.UserDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserDetailsRestRespository extends PagingAndSortingRepository<UserDetails, Long> {

    List<UserDetails> findByRole(String roleAdmin);

    List<UserDetails> findFirstById(long id);
}
