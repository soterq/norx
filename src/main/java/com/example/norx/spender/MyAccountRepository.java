package com.example.norx.spender;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyAccountRepository extends JpaRepository<MyAccount,Long> {
}
