package com.pkusoft.ygjw.req;

import com.pkusoft.ygjw.model.PsApprs;
import java.util.List;

public class PsApprsYgjwReqParam extends PsApprs {

    private List<String> multiFilePaths;

    public List<String> getMultiFilePaths() {
        return multiFilePaths;
    }

    public void setMultiFilePaths(List<String> multiFilePaths) {
        this.multiFilePaths = multiFilePaths;
    }
}