/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package cn.bbw.mobay.app.tag;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bbw.mobay.app.plugin.TagPlugin;
import cn.bbw.mobay.app.service.FolderService;
import cn.bbw.mobay.app.util.HttpUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * folder标签
 * 
 * @author lqq
 * 
 */
@Service
public class ArticleUrlTag extends TagPlugin {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params,
			TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		String artcleId = params.get("articleId").toString();
		String basePath = HttpUtils.getBasePath(request);
		env.getOut().write(basePath + "/article/" + artcleId + ".htm");
	}

}
