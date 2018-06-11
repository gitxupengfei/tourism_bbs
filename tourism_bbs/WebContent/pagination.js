"use strict";
/**
 * 分页类的构造函数
 * @method  Pagination
 * @author JunEnstein
 * @version 1.0
 * @param   {String}   element_id       HTML元素ID
 * @param   {Object}   custom_config    用户配置信息
 */
function Pagination(element_id, custom_config){
	// 获取HTMLElment对象
	this.container = document.getElementById(element_id);
	// 初始化分页配置
	this.initialize_config(custom_config);
	// 刷新页面
	this.refresh();
}

/**
 * 页码更新事件回调函数
 * @type {Function}
 */
Pagination.prototype.onchange = function(page){};

/**
 * 默认配置
 * @type {Object}
 */
Pagination.prototype.default_config = {
	total           : 0,				// 数据总的条目数
	current_page    : 1,				// 当前所在的页码
	page_size       : 10,				// 每一页数据所占的条目数
	home_page_name  : "首页",			// 首页按钮的名称
	end_page_name   : "尾页",			// 尾页按钮的名称
	prev_page_name  : "< 上一页",		// 上一页按钮的名称
	next_page_name  : "下一页 >",		// 下一页按钮的名称
	omit_name       : "...",			// 省略按钮的名称
	skip_name       : "跳转",			// 跳转按钮
	button_length   : 5, 				// 默认最多同时显示的页码按钮只能为奇数, 如果为偶数默认+1
	display_skip    : true,   			// 是否显示跳转按钮
	display_home    : true				// 是否显示首页和尾页
};

/**
 * 初始化
 * @param custom_config
 */
Pagination.prototype.initialize_config = function(custom_config){
	// 应用配置
	for(var key in this.default_config){
		if(custom_config.hasOwnProperty(key)){
			this[key] = custom_config[key];
		}else{
			this[key] = this.default_config[key];
		}
	}
	// 如果要显示的按钮列表的长度为偶数,则将他变为奇数
	if(this.button_length % 2 === 0) this.button_length++;

	// 初始化页码总数
	this.total_page = Math.ceil(this.total / this.page_size);
	this.set_current_page(custom_config.current_page);
};

/**
 * 设置当前页码
 * @method set_current_page
 * @author JunEnstein
 * @param  {number} current_page 页码
 */
Pagination.prototype.set_current_page = function(current_page){
	this.current_page = current_page;
	if(this.current_page < 1) this.current_page = 1;
    if(this.current_page > this.total_page) this.current_page = this.total_page;
};

/**
 * 更新当前分页参数
 * @method calculate_args
 * @author JunEnstein
 * @return {Object} 返回新的分页参数
 */
Pagination.prototype.calculate_args = function() {
	// 计算起始页码
	var half_length = Math.floor(this.button_length / 2);
	var start_page = this.current_page - half_length;
	var end_page = this.current_page + half_length;
	if(start_page < 1){
		start_page = 1;
		end_page = start_page + this.button_length - 1;
		if(end_page > this.total_page) end_page = this.total_page;
	}
	if(end_page > this.total_page){
		end_page  = this.total_page;
		start_page = end_page - this.button_length + 1;
		if(start_page < 1) start_page = 1;
	}
	// 上一页与下一页的页码计算
	var prev_page = this.current_page - 1;
	var next_page = this.current_page + 1;
	if(prev_page < 1) prev_page = 1;
	if(next_page > this.total_page) next_page = this.total_page;
	var page_data = {
		"start": start_page,
		"end": end_page,
		"prev": prev_page,
		"next": next_page
	};
	return page_data;
};

/**
 * 更新页码显示情况的函数
 * @method  refresh
 * @author JunEnstein
 */
Pagination.prototype.refresh = function(){
	var page_data = this.calculate_args();

	this.container.innerHTML = "一共" + this.total + "条记录 " + this.total_page + "页";
	console.log(this.container.innerHTML);
	// 显示首页
	if(this.display_home){
		this.create_button(1, this.current_page !== 1, this.home_page_name);
	}
	
	// 上一页
	this.create_button(page_data['prev'], this.current_page !== 1, this.prev_page_name);

	// 显示页码前的省略号
	if(page_data['start'] !== 1){
		this.create_button(undefined, false, this.omit_name);
	}

	// 页码设置
	for(var page_index = page_data['start']; page_index <= page_data['end']; page_index++){
		this.create_button(page_index, this.current_page !== page_index, undefined);
	}

	// 显示页码后的省略号
	if(page_data['end'] !== this.total_page){
		this.create_button(undefined, false, this.omit_name);
	}
	
	// 下一页
	this.create_button(page_data['next'], this.current_page !== this.total_page, this.next_page_name);

	// 显示尾页
	if(this.display_home){
		var clickable = this.current_page !== this.total_page;
		this.create_button(this.total_page, clickable, this.end_page_name);
	}

	// 创建跳转按钮
	if(this.display_skip) this.create_skip();
};

/**
 * 创建页码按钮
 * @method create_button
 * @author JunEnstein
 * @param {number}  page_number 按钮的序号(当且仅当clickable为true有效)
 * @param {boolean} clickable   是否可以点击(默认为true)
 * @param {string}  content     按钮的文字(默认等于page_number)
 */
Pagination.prototype.create_button = function(page_number, clickable, content){
	// 默认参数值的初始化
	if(clickable === undefined) clickable = true;
	if(content === undefined) content = page_number;

	// 创建标签
	var tag = "a";
	if(!clickable) tag = "strong";
	var page_button = document.createElement(tag);
	page_button.href = "javascript:void(0);";
	page_button.innerHTML = content;
	// 该按钮不能点击，直接返回button对象
	if(!clickable){
		// 追加到容器中
		this.container.appendChild(page_button);
		return ;
	}

	// 为元素设置页码值
	page_button.setAttribute("page", page_number);

	// 监听HTML的点击事件,并将值传递给回调函数
	var self = this;
	page_button.onclick = function(event){
		// 获取当前页码
		var page_number = parseInt(event.target.getAttribute("page"));
		// 更新当前页码
		self.set_current_page(page_number);
		// 更新样式
		self.refresh();
		// 将更新之后的页码传递给回调函数
		self.onchange(self.current_page);
	};
	// 追加到容器中
	this.container.appendChild(page_button);
};

/**
 * 创建一个跳转框
 * @method create_skip
 * @author JunEnstein
 */
Pagination.prototype.create_skip = function(){
	var button = document.createElement("a");
	button.href = "javascript:void(0);";
	button.innerHTML = this.skip_name;

	var input = document.createElement("input");
	input.type = "number";
	input.min = "1";
	input.max = this.total_page;
	input.style.height = button.style.height;

	var self = this;
	button.onclick = function(){
		// 获取跳转框的页码值
		if(input.value === "") return ;
		var page_number = parseInt(input.value);
		// 更新当前页码
		self.set_current_page(page_number);
		// 更新样式
		self.refresh();
		// 将更新之后的页码传递给回调函数
		self.onchange(self.current_page);
	};
	this.container.appendChild(input);
	this.container.appendChild(button);
};
