/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package cn.bbw.mobay.app.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bbw.mobay.app.entity.Folder;
import cn.bbw.mobay.app.exception.FolderNotFoundException;
import cn.bbw.mobay.app.plugin.TagPlugin;
import cn.bbw.mobay.app.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Service
public class FolderTag extends TagPlugin {

	@Autowired
	private FolderService folderService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		Integer folderId = Integer.parseInt(params.get("folderId").toString());

		try {
			Folder folder = folderService.getFolderById(folderId);
			env.setVariable("tag_folder", DEFAULT_WRAPPER.wrap(folder));
		} catch (FolderNotFoundException e) {
			env.setVariable("tag_folder", DEFAULT_WRAPPER.wrap(new Folder()));
		}
		body.render(env.getOut());
	}

}
