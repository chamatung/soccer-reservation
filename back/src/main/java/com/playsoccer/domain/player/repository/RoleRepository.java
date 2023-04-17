package com.playsoccer.domain.player.repository;

import com.playsoccer.domain.player.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, String> {

}
