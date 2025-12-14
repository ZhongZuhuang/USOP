package com.michael.usop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.michael.usop.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    // 注释修正：所有提及的实体类都改为 UsersEntity（与泛型一致）
    // BaseMapper<UsersEntity> 已提供的核心方法（实际返回/参数是 UsersEntity）：
    // 1. 新增：int insert(UsersEntity entity) → 插入一条记录
    // 2. 删除：int deleteById(Serializable id) → 根据 ID 删除（支持 Long/Integer 等 Serializable 类型）
    // 3. 修改：int updateById(UsersEntity entity) → 根据 ID 修改
    // 4. 单查：UsersEntity selectById(Serializable id) → 根据 ID 查询（支持 Integer 类型 ID）
    // 5. 列表查：List<UsersEntity> selectList(Wrapper<UsersEntity> queryWrapper) → 条件查询
    // 6. 统计：long selectCount(Wrapper<UsersEntity> queryWrapper) → 统计记录数
    // 7. 批量操作：List<UsersEntity> selectBatchIds(Collection<? extends Serializable> idList) → 批量查询
}