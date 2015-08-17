package com.imgur.sdk.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/16/14
 * Time: 6:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceRequestParams {

    private Map<String, String> vars = new HashMap<String, String>();
    private Map<String, ArrayList<String>> multipleVars = new HashMap<String, ArrayList<String>>();
    private Map<String, String> files = new HashMap<String, String>();
    private boolean isUploadBinaryFile = false;

    public boolean isUploadBinaryFile() {
        if(files!=null && !files.isEmpty()){
            isUploadBinaryFile = true;
        } else {
            isUploadBinaryFile = false;
        }
        return isUploadBinaryFile;
    }

    public void setUploadBinaryFile(boolean uploadBinaryFile) {
        isUploadBinaryFile = uploadBinaryFile;
    }

    public Map<String, String> getVars() {
        return vars;
    }

    public void setVars(Map<String, String> vars) {
        this.vars = vars;
    }

    public Map<String, ArrayList<String>> getMultipleVars() {
        return multipleVars;
    }

    public void setMultipleVars(Map<String, ArrayList<String>> multipleVars) {
        this.multipleVars = multipleVars;
    }

    public Map<String, String> getFiles() {
        return files;
    }

    public void setFiles(Map<String, String> files) {
        this.files = files;
    }
}
