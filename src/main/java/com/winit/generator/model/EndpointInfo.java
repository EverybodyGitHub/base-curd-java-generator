package com.winit.generator.model;

public class EndpointInfo {

    /**
     * 包路径
     */
    private String     packageStr;

    /**
     * 需要导入的包
     */
    private String     importStr;

    /**
     * 类名
     */
    private String     className;

    /**
     * 实体信息
     */
    private EntityInfo entityInfo;

    /**
     * VO实体类包名
     */
    private VoInfo voInfo;

    /**
     * VO实体类包名
     */
    private ServiceInfo serviceInfo;

    /**
     * BaseEnvelop包名
     */
    private String baseEnvelopPackageStr;

    /**
     * rest包名
     */
    private String baseRequestMappingPackage;

    /**
     * rest
     */
    private String baseRequestMappingName;
    /**
     * 实体类变量名
     */
    private String entityVarName;

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public String getImportStr() {
        return importStr;
    }

    public void setImportStr(String importStr) {
        this.importStr = importStr;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }

    public String getBaseEnvelopPackageStr() {
        return baseEnvelopPackageStr;
    }

    public void setBaseEnvelopPackageStr(String baseEnvelopPackageStr) {
        this.baseEnvelopPackageStr = baseEnvelopPackageStr;
    }

    public String getEntityVarName() {
        return entityVarName;
    }

    public void setEntityVarName(String entityVarName) {
        this.entityVarName = entityVarName;
    }

    public String getBaseRequestMappingPackage() {
        return baseRequestMappingPackage;
    }

    public void setBaseRequestMappingPackage(String baseRequestMappingPackage) {
        this.baseRequestMappingPackage = baseRequestMappingPackage;
    }

    public String getBaseRequestMappingName() {
        return baseRequestMappingName;
    }

    public void setBaseRequestMappingName(String baseRequestMappingName) {
        this.baseRequestMappingName = baseRequestMappingName;
    }

    public VoInfo getVoInfo() {
        return voInfo;
    }

    public void setVoInfo(VoInfo voInfo) {
        this.voInfo = voInfo;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }
}
