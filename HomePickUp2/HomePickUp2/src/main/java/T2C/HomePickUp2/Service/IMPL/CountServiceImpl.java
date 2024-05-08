package T2C.HomePickUp2.Service.IMPL;

import T2C.HomePickUp2.DTO.CountDTO;
import T2C.HomePickUp2.Entity.Count;
import T2C.HomePickUp2.Repository.CountRepository;
import T2C.HomePickUp2.Service.CountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountServiceImpl implements CountService {

    private final CountRepository countRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CountServiceImpl(CountRepository countRepository, ModelMapper modelMapper) {
        this.countRepository = countRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CountDTO getCountById(Long id) {
        return countRepository.findById(id)
                .map(count -> modelMapper.map(count, CountDTO.class))
                .orElse(null);
    }

    @Override
    public List<CountDTO> getAllCounts() {
        return countRepository.findAll().stream()
                .map(count -> modelMapper.map(count, CountDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CountDTO createCount(CountDTO countDTO) {
        Count count = modelMapper.map(countDTO, Count.class);
        return modelMapper.map(countRepository.save(count), CountDTO.class);
    }

    @Override
    public void deleteCount(Long id) {
        countRepository.deleteById(id);
    }
}
