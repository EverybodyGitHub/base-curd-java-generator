package ${packageStr};

import ${baseEntityDaoPackageStr}.${entityName}Dao;
import ${baseJpaServicePackageStr}.${baseJpaService};
import org.springframework.stereotype.Service;
${importStr}

/**
 * 
 * ${entityDesc}服务service
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author}    1.0  ${time} Created
 *
 * </pre>
 * @since 1.
 */
@Service
public class ${className} extends ${baseJpaService}<${entityName}DO, ${entityName}Dao> {
}
