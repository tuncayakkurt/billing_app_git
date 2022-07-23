package com.billing.filetransferhandler.aop;

import com.blg.client.enums.FileTypes;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Aspect
@Component
public class FileStorageServiceAspect {

    @Before(value = "execution(* com.billing.filetransferhandler.service.FileStorageService.save(..)) and args(file)")
    public void validateFile(JoinPoint jp, MultipartFile file) {
        if (!FileTypes.isFileTypeExist(file.getOriginalFilename())) {
            throw new RuntimeException("Inappropriate file type uploaded.");
        }
    }
}
