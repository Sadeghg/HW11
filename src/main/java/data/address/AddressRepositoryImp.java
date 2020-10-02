package data.address;

import model.Address;
import model.helper.AddressInfo;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;

public class AddressRepositoryImp extends BaseRepositoryImp<Address, Integer, AddressInfo> implements AddressRepository {
    public AddressRepositoryImp(EntityManager manager) {
        super(manager);
    }
}
