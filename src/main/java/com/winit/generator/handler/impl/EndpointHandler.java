package com.winit.generator.handler.impl;

import com.winit.generator.Constants;
import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.DaoInfo;
import com.winit.generator.model.EndpointInfo;

import java.io.File;

public class EndpointHandler extends BaseHandler<EndpointInfo> {

    public EndpointHandler(String ftlName, EndpointInfo info){
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") + File.separator + Configuration.getString("endpoint.path")
                        + File.separator + info.getClassName() + Constants.FILE_SUFFIX_JAVA;

    }

    @Override
    public void combileParams(EndpointInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("ClassName", info.getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
        this.param.put("baseEntityPackageStr", info.getEntityInfo().getEntityPackage());
        this.param.put("baseEntityVOPackageStr", info.getVoInfo().getPackageStr());
        this.param.put("baseEnvelopPackageStr", info.getBaseEnvelopPackageStr());
        this.param.put("ServicePackageStr", info.getServiceInfo().getPackageStr());
        this.param.put("entityVarName", info.getEntityVarName());
        this.param.put("baseRequestMappingPackage", info.getBaseRequestMappingPackage());
        this.param.put("baseRequestMappingName", info.getBaseRequestMappingName());
    }

}
