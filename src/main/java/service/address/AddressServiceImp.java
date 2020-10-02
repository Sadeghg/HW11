package service.address;

import data.address.AddressRepository;
import model.Address;
import model.helper.AddressInfo;
import template.service.BaseServiceImp;


public class AddressServiceImp extends BaseServiceImp<Address, Integer, AddressRepository, AddressInfo> implements AddressService {
    public AddressServiceImp(AddressRepository repository) {
        super(repository);
    }
}
