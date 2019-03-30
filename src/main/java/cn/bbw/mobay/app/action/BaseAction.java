/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */
package cn.bbw.mobay.app.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bbw.mobay.app.service.ArticleService;
import cn.bbw.mobay.app.service.FolderService;
import cn.bbw.mobay.app.service.HeadlineService;
import cn.bbw.mobay.app.service.TemplateService;

/**
 * 
 * @author Herbert
 * 
 */
public class BaseAction {

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected ArticleService fileService;

	@Autowired
	protected TemplateService themeService;

	@Autowired
	protected HeadlineService headlineService;

	protected final Logger logger = Logger.getLogger(this.getClass());
}
