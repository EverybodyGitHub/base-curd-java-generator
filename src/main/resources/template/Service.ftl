package ${packageStr};

import ${baseEntityDaoPackageStr}.${entityClassName}Dao;
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
public class ${entityClassName}Service extends ${baseJpaService}<${entityClassName}, ${entityClassName}Dao> {
}
