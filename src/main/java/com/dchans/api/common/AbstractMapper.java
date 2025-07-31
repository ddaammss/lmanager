package com.dchans.api.common;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

public class AbstractMapper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private SqlSessionTemplate sqlSession;

    public AbstractMapper(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    protected void printQueryId(String queryId) {
        if (logger.isDebugEnabled()) {
            logger.debug("\t QueryId  \t:  " + queryId);
            System.out.println("\t QueryId  \t:  " + queryId);
            System.out.println("\t getConnection  \t:  " + sqlSession.getConnection());
        }
    }

    /**
     * 입력 처리 SQL mapping 을 실행한다.
     *
     * @param queryId -  입력 처리 SQL mapping 쿼리 ID
     * @return DBMS가 지원하는 경우 insert 적용 결과 count
     */
    public int insert(String queryId) {
        printQueryId(queryId);
        return sqlSession.insert(queryId);
    }

    /**
     * 입력 처리 SQL mapping 을 실행한다.
     *
     * @param queryId         -  입력 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 입력 처리 SQL mapping 입력 데이터를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @return DBMS가 지원하는 경우 insert 적용 결과 count
     */
    public int insert(String queryId, Object parameterObject) {
        printQueryId(queryId);
        return sqlSession.insert(queryId, parameterObject);
    }

    /**
     * 수정 처리 SQL mapping 을 실행한다.
     *
     * @param queryId - 수정 처리 SQL mapping 쿼리 ID
     * @return DBMS가 지원하는 경우 update 적용 결과 count
     */
    public int update(String queryId) {
        printQueryId(queryId);
        return sqlSession.update(queryId);
    }

    /**
     * 수정 처리 SQL mapping 을 실행한다.
     *
     * @param queryId         - 수정 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 수정 처리 SQL mapping 입력 데이터(key 조건 및 변경 데이터)를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @return DBMS가 지원하는 경우 update 적용 결과 count
     */
    public int update(String queryId, Object parameterObject) {
        printQueryId(queryId);
        return sqlSession.update(queryId, parameterObject);
    }

    /**
     * 삭제 처리 SQL mapping 을 실행한다.
     *
     * @param queryId - 삭제 처리 SQL mapping 쿼리 ID
     * @return DBMS가 지원하는 경우 delete 적용 결과 count
     */
    public int delete(String queryId) {
        printQueryId(queryId);
        return sqlSession.delete(queryId);
    }

    /**
     * 삭제 처리 SQL mapping 을 실행한다.
     *
     * @param queryId         - 삭제 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 삭제 처리 SQL mapping 입력 데이터(일반적으로 key 조건)를  세팅한 파라메터 객체(보통 VO 또는 Map)
     * @return DBMS가 지원하는 경우 delete 적용 결과 count
     */
    public int delete(String queryId, Object parameterObject) {
        printQueryId(queryId);
        return sqlSession.delete(queryId, parameterObject);
    }

    //CHECKSTYLE:OFF

    /**
     * 명명규칙에 맞춰 selectOne()로 변경한다.
     *
     * @param queryId         - 단건 조회 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 단건 조회 처리 SQL mapping 입력 데이터(key)를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)
     * @deprecated select() 메소드로 대체
     */
    //CHECKSTYLE:ON
    @Deprecated
    public Object selectByPk(String queryId, Object parameterObject) {
        printQueryId(queryId);
        return sqlSession.selectOne(queryId, parameterObject);
    }

    /**
     * 단건조회 처리 SQL mapping 을 실행한다.
     *
     * @param queryId - 단건 조회 처리 SQL mapping 쿼리 ID
     * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)
     */
    public <T> T selectOne(String queryId) {
        return sqlSession.selectOne(queryId);
    }

    /**
     * 단건조회 처리 SQL mapping 을 실행한다.
     *
     * @param queryId         - 단건 조회 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 단건 조회 처리 SQL mapping 입력 데이터(key)를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)
     */
    public <T> T selectOne(String queryId, Object parameterObject) {
        printQueryId(queryId);
        return sqlSession.selectOne(queryId, parameterObject);
    }

    /**
     * 결과 목록을 Map 을 변환한다.
     * 모든 구문이 파라미터를 필요로 하지는 않기 때문에, 파라미터 객체를 요구하지 않는 형태로 오버로드되었다.
     *
     * @param queryId - 단건 조회 처리 SQL mapping 쿼리 ID
     * @param mapKey  - 결과 객체의 프로퍼티 중 하나를 키로 사용
     * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)의 Map
     */
    public <K, V> Map<K, V> selectMap(String queryId, String mapKey) {
        printQueryId(queryId);
        return sqlSession.selectMap(queryId, mapKey);
    }

    /**
     * 결과 목록을 Map 을 변환한다.
     * 모든 구문이 파라미터를 필요로 하지는 않기 때문에, 파라미터 객체를 요구하지 않는 형태로 오버로드되었다.
     *
     * @param queryId         - 단건 조회 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 맵 조회 처리 SQL mapping 입력 데이터(조회 조건)를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @param mapKey          - 결과 객체의 프로퍼티 중 하나를 키로 사용
     * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)의 Map
     */
    public <K, V> Map<K, V> selectMap(String queryId, Object parameterObject, String mapKey) {
        return sqlSession.selectMap(queryId, parameterObject, mapKey);
    }

    /**
     * 결과 목록을 Map 을 변환한다.
     * 모든 구문이 파라미터를 필요로 하지는 않기 때문에, 파라미터 객체를 요구하지 않는 형태로 오버로드되었다.
     *
     * @param queryId - 단건 조회 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 맵 조회 처리 SQL mapping 입력 데이터(조회 조건)를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @param mapKey - 결과 객체의 프로퍼티 중 하나를 키로 사용
     * @param rowBounds - 특정 개수 만큼의 레코드를 건너띄게 함
     *
     * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)의 Map

    public <K, V> Map<K, V> selectMap(String queryId, Object parameterObject, String mapKey, RowBounds rowBounds) {
    printQueryId(queryId);
    return sqlSession.selectMap(queryId, parameterObject, mapKey, rowBounds);
    }
     */
    //CHECKSTYLE:OFF

    /**
     * 명명규칙에 맞춰 selectList()로 변경한다.
     *
     * @deprecated List<?> 메소드로 대체
     */
    //CHECKSTYLE:ON
    @Deprecated
    public List<?> list(String queryId, Object parameterObject) {
        printQueryId(queryId);
        return sqlSession.selectList(queryId, parameterObject);
    }

    /**
     * 리스트 조회 처리 SQL mapping 을 실행한다.
     *
     * @param queryId - 리스트 조회 처리 SQL mapping 쿼리 ID
     * @return 결과 List 객체 - SQL mapping 파일에서 지정한  resultType/resultMap 에 의한 결과 객체(보통 VO 또는 Map)의 List
     */
    public <E> List<E> selectList(String queryId) {
        printQueryId(queryId);
        return sqlSession.selectList(queryId);
    }

    /**
     * selectFirstRow
     * <pre>
     * 리스트 조회 후 가장 처음 로우만 리턴한다.
     * </pre>
     *
     * @param queryId         : 리스트 조회 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 리스트 조회 처리 SQL mapping 입력 데이터(조회 조건)를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @return 결과 List 객체 : SQL mapping 파일에서 지정한  resultType/resultMap 에 의한 결과 객체(보통 VO 또는 Map)
     */
    public <E> E selectFirstRow(String queryId, Object parameterObject) { //Generics를 사용하기 위해서는 메소드 시그니쳐에서 접근제어자 다음에 사용할 Type의 매개변수를 <..>로 지정해줘야함. 그래야 메소드 내부에서 Genrics을 사용할수있음.
        printQueryId(queryId);

        List<E> resultList = sqlSession.selectList(queryId, parameterObject);
        E result = null;
        if (!CollectionUtils.isEmpty(resultList)) {
            result = resultList.get(0);
        }

        return result;
    }

    /**
     * selectFirstRow
     * <pre>
     * 리스트 조회 후 가장 처음 로우만 리턴한다.
     * </pre>
     *
     * @param queryId : 리스트 조회 처리 SQL mapping 쿼리 ID
     * @return 결과 List 객체 : SQL mapping 파일에서 지정한  resultType/resultMap 에 의한 결과 객체(보통 VO 또는 Map)
     */
    public <E> E selectFirstRow(String queryId) { //Generics를 사용하기 위해서는 메소드 시그니쳐에서 접근제어자 다음에 사용할 Type의 매개변수를 <..>로 지정해줘야함. 그래야 메소드 내부에서 Genrics을 사용할수있음.
        printQueryId(queryId);

        List<E> resultList = sqlSession.selectList(queryId);
        E result = null;
        if (!CollectionUtils.isEmpty(resultList)) {
            result = resultList.get(0);
        }

        return result;
    }

    /**
     * 리스트 조회 처리 SQL mapping 을 실행한다.
     *
     * @param queryId         - 리스트 조회 처리 SQL mapping 쿼리 ID
     * @param parameterObject - 리스트 조회 처리 SQL mapping 입력 데이터(조회 조건)를 세팅한 파라메터 객체(보통 VO 또는 Map)
     * @return 결과 List 객체 - SQL mapping 파일에서 지정한  resultType/resultMap 에 의한 결과 객체(보통 VO 또는 Map)의 List
     */
    public <E> List<E> selectList(String queryId, Object parameterObject) {
        printQueryId(queryId);
        return sqlSession.selectList(queryId, parameterObject);
    }

}
