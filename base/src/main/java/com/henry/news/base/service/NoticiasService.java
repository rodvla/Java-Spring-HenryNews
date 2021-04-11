package com.henry.news.base.service;

import com.henry.news.base.model.Noticias;
import com.henry.news.base.model.PaginationResponse;
import com.henry.news.base.model.Writer;
import com.henry.news.base.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;

@Service
public class NoticiasService {

    @Autowired
    private NoticiasRepository noticiasRepository;
    private WriterService writerService;

    public NoticiasService(NoticiasRepository noticiasRepository, WriterService writerService) {
        this.noticiasRepository = noticiasRepository;
        this.writerService = writerService;
    }

    public Noticias getNoticiasById(Integer id) {
        return noticiasRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public Noticias addNoticia(Noticias noticia){
        return noticiasRepository.save(noticia);
    }

    public List<Noticias> getAll(){
        return noticiasRepository.findAll();
    }

    public PaginationResponse<Noticias> getAll(Integer page, Integer size) {
        if(!Objects.isNull(page) && !Objects.isNull(size)){
            Pageable pageable = PageRequest.of(page, size);
            Page<Noticias> noticiasPage = noticiasRepository.findAll(pageable);
            return new PaginationResponse<>(noticiasPage.getContent(), noticiasPage.getTotalPages(), noticiasPage.getTotalElements());
        }
        List<Noticias> noticiasList = noticiasRepository.findAll();
        return new PaginationResponse<>(noticiasList, 1, (long) noticiasList.size());
    }

    public void addWriter(Integer id, Integer writerID) {
        Noticias noticias = getNoticiasById(id);
        Writer writer = writerService.getWriter(writerID);
        noticias.setOwner(writer);
        noticiasRepository.save(noticias);

    }

    public void deletewriteByid(Integer id) {
        noticiasRepository.deleteById(id);
    }
}