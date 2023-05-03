package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Complaint;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComplaintDao extends BaseMapper<Complaint> {


}
