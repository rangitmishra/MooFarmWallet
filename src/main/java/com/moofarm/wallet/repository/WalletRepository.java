package com.moofarm.wallet.repository;

import com.moofarm.wallet.model.entity.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Serializable> {
}
