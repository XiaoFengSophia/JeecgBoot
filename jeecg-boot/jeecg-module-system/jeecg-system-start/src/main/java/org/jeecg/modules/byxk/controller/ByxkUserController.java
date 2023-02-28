package org.jeecg.modules.byxk.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.modules.byxk.config.AsyncTest;
import org.jeecg.modules.byxk.service.IByxkUserService;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.byxk.entity.ByxkUser;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

/**
 * @Description: 白云新科用户表
 * @Author: jeecg-boot
 * @Date:   2023-02-16
 * @Version: V1.0
 */
@Api(tags="白云新科用户表")
@RestController
@RequestMapping("/byxk/byxkUser")
@Slf4j
public class ByxkUserController extends JeecgController<ByxkUser, IByxkUserService> {
	@Autowired
	private IByxkUserService byxkUserService;


	@Autowired
	private AsyncTest asyncTest;
	
	/**
	 * 分页列表查询
	 *
	 * @param byxkUser
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "白云新科用户表-分页列表查询")
	@ApiOperation(value="白云新科用户表-分页列表查询", notes="白云新科用户表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ByxkUser>> queryPageList(ByxkUser byxkUser,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ByxkUser> queryWrapper = QueryGenerator.initQueryWrapper(byxkUser, req.getParameterMap());
		Page<ByxkUser> page = new Page<ByxkUser>(pageNo, pageSize);
		IPage<ByxkUser> pageList = byxkUserService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param byxkUser
	 * @return
	 */
	@AutoLog(value = "白云新科用户表-添加")
	@ApiOperation(value="白云新科用户表-添加", notes="白云新科用户表-添加")
	//@RequiresPermissions("byxk:byxk_user:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ByxkUser byxkUser) {
		byxkUserService.save(byxkUser);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param byxkUser
	 * @return
	 */
	@AutoLog(value = "白云新科用户表-编辑")
	@ApiOperation(value="白云新科用户表-编辑", notes="白云新科用户表-编辑")
	//@RequiresPermissions("byxk:byxk_user:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ByxkUser byxkUser) {
		byxkUserService.updateById(byxkUser);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "白云新科用户表-通过id删除")
	@ApiOperation(value="白云新科用户表-通过id删除", notes="白云新科用户表-通过id删除")
	//@RequiresPermissions("byxk:byxk_user:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		byxkUserService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "白云新科用户表-批量删除")
	@ApiOperation(value="白云新科用户表-批量删除", notes="白云新科用户表-批量删除")
	//@RequiresPermissions("byxk:byxk_user:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.byxkUserService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "白云新科用户表-通过id查询")
	@ApiOperation(value="白云新科用户表-通过id查询", notes="白云新科用户表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ByxkUser> queryById(@RequestParam(name="id",required=true) String id) {
		ByxkUser byxkUser = byxkUserService.getById(id);
		if(byxkUser==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(byxkUser);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param byxkUser
    */
    //@RequiresPermissions("byxk:byxk_user:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ByxkUser byxkUser) {
        return super.exportXls(request, byxkUser, ByxkUser.class, "白云信科用户表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("byxk:byxk_user:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ByxkUser.class);
    }

    @RequestMapping("testAsync")
	public void testAsync() {
		asyncTest.syncOut();
		System.out.println("Main ThreadId: " + Thread.currentThread().getId());
	}

}
