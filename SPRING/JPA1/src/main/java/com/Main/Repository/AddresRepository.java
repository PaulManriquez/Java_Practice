package com.Main.Repository;

import com.Main.Entitys.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresRepository extends CrudRepository<Address,Integer> {
}
