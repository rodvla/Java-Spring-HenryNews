package com.henry.news.base.service;

import com.henry.news.base.repository.WriterRepository;
import com.henry.news.base.model.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    public List<Writer> getWriters() {
        return writerRepository.findAll();
    }

    public Writer addWriter(Writer writer) {
        return writerRepository.save(writer);
    }

    public Writer getWriter(Integer id) {
        return writerRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deletewriteByid(Integer id) {
        writerRepository.deleteById(id);
    }

    public Writer editPerson(Writer write) {
        Writer writer = writerRepository.findById(write.getId()).orElse(new Writer());
        Writer editwriter = new Writer();
        editwriter.setId(writer.getId());
        if (write.getNombre() != null) {
            editwriter.setNombre(write.getNombre());
        } else {
            editwriter.setNombre(writer.getNombre());
        }
        if (write.getApellido() != null) {
            editwriter.setApellido(write.getApellido());
        } else {
            editwriter.setApellido(writer.getApellido());
        }
        if (write.getDni() != null) {
            editwriter.setDni(write.getDni());
        } else {
            editwriter.setDni(writer.getDni());
        }
        return writerRepository.save(editwriter);
    }
}
