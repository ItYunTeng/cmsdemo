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

import cn.bbw.mobay.app.constant.MediaConstant;
import cn.bbw.mobay.app.entity.Media;
import cn.bbw.mobay.app.entity.vo.PageVo;
import cn.bbw.mobay.app.plugin.TagPlugin;
import cn.bbw.mobay.app.service.MediaService;

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
public class MediaPageTag extends TagPlugin {

	@Autowired
	private MediaService attachmentService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		// 获取页面的参数
		Integer kindId = Integer.parseInt(params.get("kindId").toString());
		MediaConstant.Kind kind = MediaConstant.Kind.valueOf(params.get("kind")
				.toString());
		Integer pageNum = Integer.parseInt(params.get("p").toString());
		Integer rows = Integer.parseInt(params.get("rows").toString());
		// 获得目录列表
		PageVo<Media> pageVo = attachmentService.getMediaPageByKindId(kindId,
				kind, rows, pageNum);
		env.setVariable("tag_attachment_page", DEFAULT_WRAPPER.wrap(pageVo));
		body.render(env.getOut());
	}

}
