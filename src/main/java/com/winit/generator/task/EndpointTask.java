package com.winit.generator.task;

import com.winit.generator.Constants;
import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.DaoHandler;
import com.winit.generator.handler.impl.EndpointHandler;
import com.winit.generator.model.DaoInfo;
import com.winit.generator.model.EndpointInfo;
import com.winit.generator.model.MapperInfo;

import java.util.ArrayList;
import java.util.List;

public class EndpointTask extends AbstractApplicationTask {

    private static String  ENDPOINT_FTL = "template/endpoint.ftl";

    private List<EndpointInfo> endpointInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成endpoint");

        endpointInfos = (List<EndpointInfo>) context.getAttribute("endpointInfoList");

        BaseHandler<EndpointInfo> handler = null;
        for (EndpointInfo endpointInfo : endpointInfos) {
            handler = new EndpointHandler(ENDPOINT_FTL, endpointInfo);
            handler.execute(context);
        }

        logger.info("生成endpoint完成");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);

       /* List<MapperInfo> mapperInfos = new ArrayList<MapperInfo>();
        MapperInfo mapperInfo = null;
        for (EndpointInfo endpointInfo : endpointInfos) {
            mapperInfo = new MapperInfo();
            mapperInfo.setDaoInfo(daoInfo);
            mapperInfo.setEntityInfo(daoInfo.getEntityInfo());
            mapperInfo.setFileName(daoInfo.getEntityInfo().getEntityName() + Constants.MAPPER_XML_SUFFIX);
            mapperInfo.setNamespace(daoInfo.getPackageStr() + Constants.CHARACTER_DOT + daoInfo.getClassName());
            mapperInfos.add(mapperInfo);
        }
        context.setAttribute("mapperInfos", mapperInfos);
    }*/
    }

}
