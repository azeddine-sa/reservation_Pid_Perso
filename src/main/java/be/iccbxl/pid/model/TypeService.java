package be.iccbxl.pid.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAllTypes(){
        List<Type> types = new ArrayList<>();
        
        typeRepository.findAll().forEach(types::add);

        return types;
    }

    public Type getType(String id){
        int indice = Integer.parseInt(id);

        return typeRepository.findById(indice);
    }
    
    public void addType(Type type){
        typeRepository.save(type);
    }

    public void updateType(Type type){
        typeRepository.save(type);
    }

    public void deleteArtist(String id){
        Long indice = (long) Integer.parseInt(id);

        typeRepository.deleteById(indice);
    }
    
}
