package cn.bbw.mobay.app.entity.vo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.bbw.mobay.app.entity.Article;
import cn.bbw.mobay.app.entity.Folder;

public class ArticleVo extends Article {

	private Folder folder;

	private List<FolderVo> folderPathList;

	private String pictureUrl;

	public String getPictureUrl() {
		if (StringUtils.isBlank(this.getPicture())) {
			return "upload/blank.jpg";
		} else {
			return this.getPicture();
		}
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public List<FolderVo> getFolderPathList() {
		return folderPathList;
	}

	public void setFolderPathList(List<FolderVo> folderPathList) {
		this.folderPathList = folderPathList;
	}
}
