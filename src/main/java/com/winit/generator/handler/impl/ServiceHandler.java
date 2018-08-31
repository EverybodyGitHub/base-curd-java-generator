package com.winit.generator.handler.impl;

import java.io.File;

import com.winit.generator.Constants;
import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.ServiceInfo;

public class ServiceHandler extends BaseHandler<ServiceInfo> {

    public ServiceHandler(String ftlName, ServiceInfo info){
        this.info = info;
        this.ftlName = ftlName;
        this.savePath = Configuration.getString("base.baseDir") + File.separator
                        + Configuration.getString("service.path") + File.separator + info.getEntityInfo().getEntityName()
                        + Constants.FILE_SUFFIX_JAVA;
    }

    @Override
    public void combileParams(ServiceInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("baseEntityPackageStr", info.getEntityInfo().getEntityPackage());
        this.param.put("baseEntityDaoPackageStr", info.getDaoInfo().getPackageStr());
        this.param.put("baseJpaServicePackageStr", info.getBaseJpaServicePackageStr());
        this.param.put("entityClassName", info.getEntityInfo().getEntityName());
        this.param.put("baseJpaService", info.getBaseJpaService());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
    }

}
