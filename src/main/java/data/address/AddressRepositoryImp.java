package data.address;

import model.Address;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;

public class AddressRepositoryImp extends BaseRepositoryImp<Address, Integer> implements AddressRepository {
    public AddressRepositoryImp(EntityManager manager) {
        super(manager);
    }
}
