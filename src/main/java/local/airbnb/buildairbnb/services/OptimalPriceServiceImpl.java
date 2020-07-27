package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.models.OptimalPrice;
import local.airbnb.buildairbnb.repository.ListingRepository;
import local.airbnb.buildairbnb.repository.OptimalPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "optimalpriceService")
public class OptimalPriceServiceImpl implements OptimalPriceService
{
    @Autowired
    OptimalPriceRepository optimalPriceRepository;

    @Override
    public OptimalPrice save(long id, OptimalPrice price)
    {
        price.setOptimalpriceid(id);
        System.out.println(price);
        return optimalPriceRepository.save(price);
    }
}
