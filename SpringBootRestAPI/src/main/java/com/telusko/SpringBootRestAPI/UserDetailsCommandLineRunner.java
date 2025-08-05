package com.telusko.SpringBootRestAPI;
import com.telusko.SpringBootRestAPI.Repository.UserDetailsRepository;
import com.telusko.SpringBootRestAPI.model.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserDetailsRepository repository;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void run(String... args) throws Exception {
        logger.info("UserDetailsCommandLineRunner");
        repository.save(new UserDetails("Muriel", "ROLE_ADMIN"));
        repository.save(new UserDetails("Samira", "ROLE_USER"));
        repository.save(new UserDetails("Sitara", "ROLE_ADMIN"));

        List<UserDetails> users = repository.findAll();
        users.forEach(u -> System.out.println(u));

        List<UserDetails> specificUsers = repository.findByRole("ROLE_ADMIN");
        specificUsers.forEach(u -> System.out.println(u.getName()));

        List<UserDetails> speciaficUsers2 = repository.findFirstById(2);
        speciaficUsers2.forEach(u -> System.out.println(u.getName()));

    }


}
