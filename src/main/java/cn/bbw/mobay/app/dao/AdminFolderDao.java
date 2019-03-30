package cn.bbw.mobay.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.bbw.mobay.app.entity.AdminFolder;
import cn.bbw.mobay.app.entity.vo.AdminFolderVo;

@Repository
public interface AdminFolderDao {

	public int addAdminFolder(AdminFolder adminFolder);

	public int deleteAdminFolder(@Param("adminId") long adminId,
			@Param("folderId") long folderId);

	public List<AdminFolderVo> getAdminFolderListById(
			@Param("adminId") long adminId);

	public AdminFolderVo getAdminFolderById(@Param("adminId") long adminId,
			@Param("folderId") long folderId);
}
