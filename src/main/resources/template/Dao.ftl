package ${packageStr};

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

${importStr}

/**
 * 
 * ${entityDesc} 数据库访问层
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author} 	1.0  		${time} 	Created
 *
 * </pre>
 * @since 1.
 */
public interface ${className} extends PagingAndSortingRepository<${entityClassName}, ${idType}>, JpaSpecificationExecutor<${entityClassName}>  {
}