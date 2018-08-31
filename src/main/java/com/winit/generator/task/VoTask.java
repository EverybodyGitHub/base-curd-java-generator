package com.winit.generator.task;

import java.util.List;

import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.VoHandler;
import com.winit.generator.model.VoInfo;
import org.apache.commons.lang3.StringUtils;

public class VoTask extends AbstractApplicationTask {

    private static String VO_INTEGER_ID_FTL = "template/Vo_UUID.ftl";
    private static String VO_UUID_FTL = "template/Vo_UUID.ftl";
    private List<VoInfo>  voList;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成vo");
        voList = (List<VoInfo>) context.getAttribute("voList");

        BaseHandler<VoInfo> handler = null;
        for (VoInfo voInfo : voList) {
            if(StringUtils.equalsIgnoreCase(voInfo.getEntityInfo().getPropTypes().get("id"),"integer")){
                handler = new VoHandler(VO_INTEGER_ID_FTL, voInfo);
            }else{
                handler = new VoHandler(VO_UUID_FTL, voInfo);
            }
            handler.execute(context);
        }
        logger.info("结束生成vo");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);

        // 组装ManagerInfo、CommandInfo
       /* List<ManagerInfo> managerInfos = new ArrayList<ManagerInfo>();
        List<CommandInfo> commandInfos = new ArrayList<CommandInfo>();
        ManagerInfo managerInfo = null;
        CommandInfo commandInfo = null;
        for (VoInfo voInfo : voList) {
            managerInfo = new ManagerInfo();
            commandInfo = new CommandInfo();

            EntityInfo entityInfo = voInfo.getEntityInfo();

            managerInfo.setClassName(entityInfo.getEntityName() + Constants.MANAGER_SUFFIX);
            managerInfo.setEntityDesc(entityInfo.getEntityDesc());
            managerInfo.setPackageStr(Configuration.getString("manager.package"));
            managerInfo.setVoClassName(voInfo.getClassName());
            managerInfo.setVoType(voInfo.getPackageStr() + Constants.CHARACTER_DOT + voInfo.getClassName());
            managerInfo.setVoInfo(voInfo);

            commandInfo.setEntityName(entityInfo.getEntityName());
            commandInfo.setPackageStr(Configuration.getString("command.package"));
            commandInfo.setVoClassName(voInfo.getClassName());
            commandInfo.setVoType(voInfo.getPackageStr() + Constants.CHARACTER_DOT + voInfo.getClassName());
            commandInfo.setClassName(entityInfo.getEntityName() + Constants.COMMAND_SUFFIX);
            commandInfo.setGetClassName("Get" + entityInfo.getEntityName() + Constants.COMMAND_SUFFIX);
            commandInfo.setQueryClassName(entityInfo.getEntityName() + "Query" + Constants.COMMAND_SUFFIX);
            commandInfo.setBatchClassName(entityInfo.getEntityName() + "Batch" + Constants.COMMAND_SUFFIX);
            commandInfo.setListClassName("List" + entityInfo.getEntityName() + Constants.COMMAND_SUFFIX);

            managerInfos.add(managerInfo);
            commandInfos.add(commandInfo);
        }
        context.setAttribute("managerInfos", managerInfos);
        context.setAttribute("commandInfos", commandInfos);*/

    }

}
