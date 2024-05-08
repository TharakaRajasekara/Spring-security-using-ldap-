package T2C.HomePickUp2.Service;

import T2C.HomePickUp2.DTO.CountDTO;

import java.util.List;

public interface CountService {
    CountDTO getCountById(Long id);
    List<CountDTO> getAllCounts();
    CountDTO createCount(CountDTO countDTO);
    void deleteCount(Long id);
}