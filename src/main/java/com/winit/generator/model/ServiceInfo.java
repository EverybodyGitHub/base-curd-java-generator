package com.winit.generator.model;

public class ServiceInfo {

    private String packageStr;

    private String className;

    private EntityInfo entityInfo;

    private DaoInfo daoInfo;
    /**
     * 需要导入的包
     */
    private String importStr;
    /**
     * 基本JPA service
     */
    private String baseJpaService;

    private String BaseJpaServicePackageStr;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }

    public DaoInfo getDaoInfo() {
        return daoInfo;
    }

    public void setDaoInfo(DaoInfo daoInfo) {
        this.daoInfo = daoInfo;
    }

    public String getBaseJpaService() {
        return baseJpaService;
    }

    public void setBaseJpaService(String baseJpaService) {
        this.baseJpaService = baseJpaService;
    }

    public String getBaseJpaServicePackageStr() {
        return BaseJpaServicePackageStr;
    }

    public void setBaseJpaServicePackageStr(String baseJpaServicePackageStr) {
        BaseJpaServicePackageStr = baseJpaServicePackageStr;
    }

    public String getImportStr() {
        return importStr;
    }

    public void setImportStr(String importStr) {
        this.importStr = importStr;
    }
}
