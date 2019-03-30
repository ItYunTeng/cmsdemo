package cn.bbw.mobay.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.bbw.mobay.app.entity.Headline;
import cn.bbw.mobay.app.entity.vo.HeadlineVo;

@Repository
public interface HeadlineDao {

	public int addHeadline(Headline headline);

	public List<HeadlineVo> getHeadlineList();

	public HeadlineVo getHeadlineById(@Param("headlineId") long headlineId);

	public int deleteHeadline(@Param("headlineId") long headlineId);

	public int updateHeadlineById(@Param("headlineId") long headlineId,
			@Param("name") String name, @Param("picture") String picture,
			@Param("url") String url);

	public void updateSortById(@Param("headlineId") long headlineId,
			@Param("sort") int sort);

}
