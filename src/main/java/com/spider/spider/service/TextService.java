package com.spider.spider.service;

import com.spider.spider.model.TextEntity;
import com.spider.spider.repository.TextRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TextService {

    @Autowired
    private TextRepository textRepository;

    public TextEntity saveText(String value) {
        return textRepository.save(new TextEntity(value));
    }

    public List<TextEntity> getAllTexts() {
        return textRepository.findAll();
    }

    @Transactional
    public String deleteText(Long id) {
        if (textRepository.existsById(id)) {
            textRepository.deleteAll();
            return "Text with ID " + id + " deleted successfully!";
        } else {
            return "Text with ID " + id + " not found!";
        }
    }
}
