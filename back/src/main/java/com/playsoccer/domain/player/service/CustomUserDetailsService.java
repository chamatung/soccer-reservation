package com.playsoccer.domain.player.service;

import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
   private final PlayerRepository playerRepository;

   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String email) {
      return createUser(email, playerRepository.findByEmail(email));
   }

   private org.springframework.security.core.userdetails.User createUser(String username, Player player) {

      List<GrantedAuthority> grantedAuthorities = player.getPlayerRoleList().stream()
              .map(authority -> new SimpleGrantedAuthority(authority.getRole().getRole()))
              .collect(Collectors.toList());

      return new org.springframework.security.core.userdetails.User(player.getEmail(),
              player.getPassword(),
              grantedAuthorities);
   }
}
