package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerDto getCustomer(UUID id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("ramon")
                .build();
    }

    @Override
    public BeerDto createCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }
}
