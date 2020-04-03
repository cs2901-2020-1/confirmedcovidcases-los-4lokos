package cs_utec.cs2901.business;

import cs_utec.cs2901.data.DailyCases;
import cs_utec.cs2901.repositories.DailyCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DailyCasesBusiness {

    @Autowired
    private DailyCasesRepository dailyCasesRepository;

    public DailyCases create(DailyCases newDailyCase){
        return dailyCasesRepository.save(newDailyCase);
    }


    /**
     *Obtiene todos los dailycases
     * @return dailycases
     */
    public List<DailyCases> findAll(){
        List<DailyCases> items = new ArrayList<>();
        for (DailyCases item: dailyCasesRepository.findAll()){
                items.add(item);
        }
        return items;
    }

    public DailyCases update(DailyCases item){
        DailyCases a = dailyCasesRepository.findById(item.getId()).get();
        if (a!=null){
            return dailyCasesRepository.save(item);
        }else{
            return a;
        }

    }

    public void delete(DailyCases item){
        dailyCasesRepository.delete(item);
    }
    public void delete(long id){dailyCasesRepository.deleteById(id);}
}
