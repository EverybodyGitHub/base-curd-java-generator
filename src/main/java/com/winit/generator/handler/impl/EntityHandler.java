package com.winit.generator.handler.impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import com.winit.generator.Constants;
import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.EntityInfo;
import com.winit.generator.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

public class EntityHandler extends BaseHandler<EntityInfo> {

    public EntityHandler(String ftlName, EntityInfo info) {
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") + File.separator
                + Configuration.getString("entity.path") + File.separator + info.getClassName()
                + Constants.FILE_SUFFIX_JAVA;

    }

    @Override
    public void combileParams(EntityInfo entityInfo) {
        this.param.put("packageStr", entityInfo.getEntityPackage());
        StringBuilder sb = new StringBuilder();
        for (String str : entityInfo.getImports()) {
            sb.append("import ").append(str).append(";\r\n");
        }
        this.param.put("importStr", sb.toString());
        this.param.put("tableName", entityInfo.getTableName());
        this.param.put("entityDesc", entityInfo.getEntityDesc());
        this.param.put("className", entityInfo.getClassName());

        // 生成属性，getter,setter方法
        sb = new StringBuilder();
        StringBuilder sbMethods = new StringBuilder();
        Map<String, String> propRemarks = entityInfo.getPropRemarks();
        Map<String, String> propColumns = entityInfo.getPropNameColumnNames();
        for (Entry<String, String> entry : entityInfo.getPropTypes().entrySet()) {
            String propName = entry.getKey();
            String propType = entry.getValue();
            if (StringUtils.equalsIgnoreCase("id", propName)) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase("createTime", propName) && propColumns.containsKey("createUser")) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase("createUser", propName)) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase("createUserName", propName)) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase("updateUser", propName)) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase("updateUserName", propName)) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase("updateTime", propName)) {
                continue;
            }

            // 注释、类型、名称
            sb.append("    /**\n")
                    .append("\t * " + propRemarks.get(propName)+"\n")
                    .append("\t */\r\n");

            if(StringUtils.equalsIgnoreCase("date",propType)){
                sb.append("\t")
                        .append("@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\", timezone = \"GMT+08:00\")\n");
            }
            sb.append("\t")
                    .append("private ")
                    .append(propType)
                    .append(" ")
                    .append(propName)
                    .append(";\r\n\n");

            sbMethods.append("\t")
                    .append("@Column(name = \"" + propColumns.get(propName) + "\")\n")
                    .append("    public ")
                    .append(propType)
                    .append(" get")
                    .append(propName.substring(0, 1).toUpperCase())
                    .append(propName.substring(1))
                    .append("() {\r\n")
                    .append("        return ")
                    .append(propName)
                    .append(";\r\n")
                    .append("    }\r\n")
                    .append("    public void set")
                    .append(propName.substring(0, 1).toUpperCase())
                    .append(propName.substring(1))
                    .append("(")
                    .append(propType)
                    .append(" ")
                    .append(propName)
                    .append(") {\r\n")
                    .append("        this.")
                    .append(propName)
                    .append(" = ")
                    .append(propName)
                    .append(";\r\n    }\r\n")
                    .append("\r\n");
        }

        this.param.put("propertiesStr", sb.toString());
        this.param.put("methodStr", sbMethods.toString());
        this.param.put("serialVersionNum", StringUtil.generate16LongNum());
    }
}
