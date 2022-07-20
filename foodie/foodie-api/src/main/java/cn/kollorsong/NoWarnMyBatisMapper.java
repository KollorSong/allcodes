package cn.kollorsong;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用于解决启动报错 ：No MyBatis mapper was found in '[cn.kollorsong]
 * Application中MapperScan用的是tx.Mybatis导致的
 */
@Mapper
public interface NoWarnMyBatisMapper {
}
