package com.qasystem.dao;

import com.qasystem.domain.Question;
import com.qasystem.tools.StringUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface QuestionMapper {
    @Insert("insert into Question(Sid,Sname,Cid,Cname,Did,Dname,Qtitle,Qtext,Qtime,Qfile,Qunread) " +
            "values(#{Sid},#{Sname},#{Cid},#{Cname},#{Did}," +
            "#{Dname},#{Qtitle},#{Qtext},#{Qtime},#{Qfile},#{Qunread})")
    int insert(Question question);
    @Delete("delete from Question where Qid = #{Qid}")
    int delete(Long Qid);
    @Update("update Question set Qtitle=#{Qtitle},Qtext=#{Qtext},Qtime=#{Qtime},Qfile=#{Qfile} where Qid=#{Qid}")
    int updateQuestion(@Param("Qid") Long Qid,@Param("Qtitle") String Qtitle,@Param("Qtext") String Qtext,@Param("Qtime") String Qtime,@Param("Qfile") boolean Qfile);
    @Update("update Question set Qunread=#{Qunread} where Qid=#{Qid}")
    int updateUnread(@Param("Qid") Long Qid,@Param("Qunread") Integer Qunread);
    @SelectProvider(type = SearchSQLBuilder.class,method = "searchSQL")
    List<Question> searchQuestionList(Map<String,Object> param);
    @Select("select * from Question where Qid=#{Qid}")
    Question getQuestion(Long Qid);

    class SearchSQLBuilder{
        public String searchSQL(final Map<String,Object> param){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from Question where 1=1");
            if(!StringUtil.isNull((String)param.get("Sid"))){
                sql.append(" and Sid=").append((String)param.get("Sid"));
            }
            if(!StringUtil.isNull((String)param.get("Cid"))){
                sql.append(" and Cid=").append((String)param.get("Cid"));
            }
            if(!StringUtil.isNull((String)param.get("Did"))){
                sql.append(" and Did=").append((String)param.get("Did"));
            }
            if(!StringUtil.isNull((String)param.get("Sname"))){
                sql.append(" and Sname like '%").append((String)param.get("Sname")).append("%'");
            }
            if(!StringUtil.isNull((String)param.get("Cname"))){
                sql.append(" and Cname like '%").append((String)param.get("Cname")).append("%'");
            }
            if(!StringUtil.isNull((String)param.get("Dname"))){
                sql.append(" and Dname like '%").append((String)param.get("Dname")).append("%'");
            }
            if(!StringUtil.isNull((String)param.get("Qtitle"))){
                sql.append(" and Qtitle like '%").append((String)param.get("Qtitle")).append("%'");
            }
            if(!StringUtil.isNull((String)param.get("Qtext"))){
                sql.append(" and Qtext like '%").append((String)param.get("Qtext")).append("%'");
            }
            sql.append(" order by Qid desc");
            System.out.println("SQL:"+sql.toString());
            return sql.toString();
        }
    }
}
