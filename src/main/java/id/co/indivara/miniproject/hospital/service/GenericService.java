package id.co.indivara.miniproject.hospital.service;

import id.co.indivara.miniproject.hospital.repo.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class GenericService<T> {
    @Autowired
    private GenericRepository<T> repository;

    public List<T> findAll(){
        return (List<T>) repository.findAll();
    }

    //BUAT DATA BARU
    public T save(T entity){
        return repository.save(entity);
    }
    //UPDATE DATA BARU
    public T update(Long id, T entity){
        T newEntity = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Data yang anda cari tidak ditemukkan"));
        return repository.save(entity);
    }
    //
    public T findById(Long id){
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Data yang anda cari tidak ditemukkan"));
    }
    public void delete(Long id){
        T newEntity = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Data yang anda cari tidak ditemukkan"));
        repository.deleteById(id);
    }
}