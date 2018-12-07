package com.wcc.base.service;

import com.wcc.base.utils.DateTimeUtils;
import com.wcc.base.entity.BaseEntity;

public class WebBaseService {

	/**
	 * 新增时设置对象的属性值<br>
	 * @param entity 新增的对象
	 */
	public static void updateCommonProperties(BaseEntity entity) {

		String systemDateTime = DateTimeUtils.getSystemDateTimeString();
		entity.setLast_update_date(systemDateTime);

	}
	
/*	public static Map<String,Object> getPageParam(EasyUIPage page, BaseEntity entity) {
		Map<String,Object> map=new HashMap<String,Object>();

		return map;
	}*/
}
