/*-
 * Copyright (c) 2004-2014 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package com.tt.sabamiso.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author usr160056
 * @since 2014/02/05
 */
//ignore "bytes" when return json format
@JsonIgnoreProperties({"bytes"}) 
public class FileMeta {

      private String fileName;
      private String fileSize;
      private String fileType;
   
      private byte[] bytes;

    
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
    /**
     * @return the fileSize
     */
    public String getFileSize() {
        return fileSize;
    }

    
    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    
    /**
     * @return the fileType
     */
    public String getFileType() {
        return fileType;
    }

    
    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    
    /**
     * @return the bytes
     */
    public byte[] getBytes() {
        return bytes;
    }

    
    /**
     * @param bytes the bytes to set
     */
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

}
