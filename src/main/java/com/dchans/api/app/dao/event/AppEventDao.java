package com.dchans.api.app.dao.event;

import com.dchans.api.app.dto.event.AppEventDto;
import com.dchans.api.app.dto.image.AppImageDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppEventDao")
public class AppEventDao extends AbstractMapper {
    public AppEventDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<AppEventDto> selectAppEventListData(String s) {
        return selectList(s);
    }

    public AppEventDto selectAppEventDetailData(String s, AppEventDto appEventDto) {
        return selectOne(s, appEventDto);
    }

    public List<AppImageDto> selecAppEventImage(String s, AppEventDto appEventDto) {
        return selectList(s, appEventDto);
    }

}
