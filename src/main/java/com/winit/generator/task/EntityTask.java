package com.winit.generator.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.winit.generator.Constants;
import com.winit.generator.config.Configuration;
import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.EntityHandler;
import com.winit.generator.model.*;
import com.winit.generator.util.PropertyUtil;

public class EntityTask extends AbstractApplicationTask {

    private static String    ENTITY_INTEGER_ID_FTL = "template/Entity_IntegerId.ftl";

    private static String    ENTITY_UUID_FTL = "template/Entity_UUID.ftl";

    private List<EntityInfo> entityInfos_integerId;
    private List<EntityInfo> entityInfos_uuid;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成实体");

        // 获取实体信息
        entityInfos_integerId = (List<EntityInfo>) context.getAttribute("entityInfos_integerId");
        entityInfos_uuid = (List<EntityInfo>) context.getAttribute("entityInfos_uuid");

        BaseHandler<EntityInfo> handler = null;
        for (EntityInfo entityInfo : entityInfos_integerId) {
            handler = new EntityHandler(ENTITY_INTEGER_ID_FTL, entityInfo);
            handler.execute(context);
        }
        for (EntityInfo entityInfo : entityInfos_uuid) {
            handler = new EntityHandler(ENTITY_UUID_FTL, entityInfo);
            handler.execute(context);
        }

        logger.info("生成实体类完成");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
        List<EntityInfo> entityInfos = entityInfos_integerId;
        entityInfos.addAll(entityInfos_uuid);

        // 组装Vo信息、组装Dao信息、service信息、endpoint信息
        List<DaoInfo> daoList = new ArrayList<DaoInfo>();
        VoInfo voInfo = null;

        List<VoInfo> voList = new ArrayList<VoInfo>();
        DaoInfo daoInfo = null;

        List<ServiceInfo> serviceInfoList = new ArrayList<ServiceInfo>();
        ServiceInfo serviceInfo = null;

        List<EndpointInfo> endpointInfoList = new ArrayList<EndpointInfo>();
        EndpointInfo endpointInfo = null;

        for (EntityInfo entityInfo : entityInfos) {
            voInfo = new VoInfo();
            daoInfo = new DaoInfo();
            serviceInfo = new ServiceInfo();
            endpointInfo = new EndpointInfo();

            voInfo.setPackageStr(Configuration.getString("vo.package"));
            voInfo.setClassName(entityInfo.getEntityName() + Constants.VO_SUFFIX);
            voInfo.setEntityInfo(entityInfo);
            voList.add(voInfo);

            daoInfo.setClassName(entityInfo.getEntityName() + Constants.DAO_SUFFIX);
            daoInfo.setEntityInfo(entityInfo);
            daoInfo.setImportStr("import " + entityInfo.getEntityPackage() + Constants.CHARACTER_DOT + entityInfo.getClassName() + Constants.CHARACTER_SPLIT);
            daoInfo.setPackageStr(Configuration.getString("dao.package"));
            daoList.add(daoInfo);

            serviceInfo.setPackageStr(Configuration.getString("service.package"));
            serviceInfo.setImportStr("import " + entityInfo.getEntityPackage() + Constants.CHARACTER_DOT + entityInfo.getClassName() + Constants.CHARACTER_SPLIT);
            serviceInfo.setDaoInfo(daoInfo);
            serviceInfo.setEntityInfo(entityInfo);
            serviceInfo.setBaseJpaService(Configuration.getString("baseJpaService.className"));
            serviceInfo.setBaseJpaServicePackageStr(Configuration.getString("baseJpaService.package"));
            serviceInfoList.add(serviceInfo);

            endpointInfo.setPackageStr(Configuration.getString("endpoint.package"));
            endpointInfo.setImportStr("import " + entityInfo.getEntityPackage() + Constants.CHARACTER_DOT + entityInfo.getClassName() + Constants.CHARACTER_SPLIT);
            endpointInfo.setClassName(entityInfo.getEntityName() + Constants.ENDPOINT_SUFFIX);
            endpointInfo.setEntityInfo(entityInfo);
            endpointInfo.setVoInfo(voInfo);
            endpointInfo.setServiceInfo(serviceInfo);
            endpointInfo.setEntityVarName(entityInfo.getEntityName().substring(0,1).toLowerCase()+entityInfo.getEntityName().substring(1,entityInfo.getEntityName().length()));
            endpointInfo.setBaseEnvelopPackageStr(Configuration.getString("endpoint.baseEnvelopPackage"));
            endpointInfo.setBaseEnvelopPackageStr(Configuration.getString("endpoint.baseRequestMappingPackage"));
            endpointInfo.setBaseRequestMappingName(Configuration.getString("endpoint.baseRequestMappingName"));
            endpointInfoList.add(endpointInfo);

        }

        context.setAttribute("daoList", daoList);
        context.setAttribute("voList", voList);
        context.setAttribute("serviceInfoList", serviceInfoList);
        context.setAttribute("endpointInfoList", endpointInfoList);
    }

    public static void main(String[] args) {
        File file = new File(
            "/D:\\devsoftware\\workspace\\winit-java-generator\\target\\classes\\template\\Entity_IntegerId.ftl");
        System.out.println(EntityTask.class.getClassLoader().getResource("").getPath());
        System.out.println(file.exists());

        PropertyUtil.setProperty("name", "qyk1");
        PropertyUtil.setProperty("NAME", "qyk22");
    }

}
