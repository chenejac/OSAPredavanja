package rs.ac.uns.ftn.informatika.osa.spring.pr17.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.osa.spring.pr17.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
