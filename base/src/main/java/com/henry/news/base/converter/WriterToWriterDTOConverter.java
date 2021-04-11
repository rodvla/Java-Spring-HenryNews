package com.henry.news.base.converter;

import com.henry.news.base.model.Writer;
import com.henry.news.base.model.dto.WriterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WriterToWriterDTOConverter implements Converter<Writer, WriterDTO> {

    private final ModelMapper modelMapper;

    public WriterToWriterDTOConverter(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public  WriterDTO convert(Writer source) {
        return modelMapper.map(source, WriterDTO.class);
    }
}
