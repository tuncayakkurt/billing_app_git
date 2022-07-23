package com.blg.client.enums;

import org.springframework.util.StringUtils;

import java.util.Locale;

public enum FileTypes {
    TXT;

    FileTypes() {
    }

    public static boolean isFileTypeExist(String filename) {
        String type = StringUtils.getFilenameExtension(filename);
        for (FileTypes fileType : FileTypes.values()) {
            if (fileType.toString().equals(type.toUpperCase(Locale.ROOT))) return true;
        }
        return false;
    }
}
