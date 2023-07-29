layui.use(['table', 'form', 'jquery', 'layer'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		form = layui.form;

	var book_tb=table.render({
		elem: '#book_tb',
		url: '/book/list',
		cols: [
			[{
				field: 'bookId',
				title: 'ID',
				width: 110,
				fixed: 'left',
				sort: true
			}, {
				field: 'bookName',
				title: '书名',
				width: 120
			}, {
				field: 'isbn',
				title: 'ISBN',
				width: 120,
				templet: function(res) {
					return '<em>' + res.isbn + '</em>'
				}
			}, {
				field: 'press',
				title: '出版社',
				width: 120
			}, {
				field: 'author',
				title: '作者',
				width: 100
			}, {
				field: 'publicationDate',
				title: '出版日期',
				width: 120
			}, {
				field: 'status',
				title: '在馆状态',
				width: 100,
				templet: function(res) {
					return res.status ? '借出' : '在馆';
				}
			}, {
				field: 'price',
				title: '价格',
				width: 80
			},{
				field: 'typestr',
				title: '类型',
				width: 100
			}, {
				field: 'createTime',
				title: '上架时间',
				width: 120
			}, {
				fixed: 'right',
				title: '操作',
				toolbar: '#barDemo',
				width: 150
			}
			]
		],
		page: true,
		height:500
	});

	//监听行工具事件
	table.on('tool(book_tb)', function(obj) {
		var data = obj.data;
		// console.log(obj);
		if (obj.event === 'del') {
			layer.confirm('真的删除行么',{icon:3},function(index) {
				$.ajax({
					url:'/book/list/'+data.bookId,
					type:'delete',
					dataType:'json',
					success: function (res) {
						if (res.code != 0) {
							return layer.msg("删除失败："+res.msg,{icon:2});
						}
						return layer.msg("删除成功", {icon: 1, time: 1300}, function () {
							obj.del();
						});
					}
				});
				layer.close(index);
			});
		} else if (obj.event === 'edit') {
			layer.open({
				type:1,
				title: '编辑书籍',
				content:$("#book_form_tmpl").html(),
				area: ['400px', '490px'],
				btn:['更新'],
				yes:function(index1){
					let bookId = $("#bookId").val(),
						bookName = $("#bookName").val(),
						isbn = $("#isbn").val(),
						press = $("#press").val(),
						author = $("#author").val(),
						publicationDate = $("#publicationDate").val(),
						price = $("#price").val(),
						type = $("#types").val();
					/*if(bookName.length==0 || isbn.length==0){
						return layer.msg("书名或ISBN不能为空!",{icon:2});
					}*/
					let new_data = {
						'bookName': bookName,
						'isbn': isbn,
						'press': press,
						'author': author,
						'publicationDate': publicationDate,
						'price': price,
						'type' : type,
					};
					// console.log(new_data);
					$.ajax({
						url:'/book/list/'+bookId,
						type:'PUT',
						data: JSON.stringify(new_data),
						contentType:'application/json',
						dataType: 'json',
						success:function (res) {
							if(res.code!=0){
								return layer.msg(res.msg, {icon: 2});
							}
							return layer.msg("更新成功",{icon:1,time:1300},function () {
								obj.update(new_data);
								layer.close(index1);
								location.reload();
							});
						}
					});
				},
				success:function(){
					// 填充表单（编辑状态）
					// form.val("book-form",data);
					$.get("/type/list",(res)=>{
						if(res.code!=0){
							return layer.msg(res.msg,{icon:2});
						}
						$.each(res.data,(index,d)=>{
							console.log(d);
							if (data.type==d.typeId){
								$("#types").append(new Option(d.typeName,d.typeId,true,true));
							}else{
								$("#types").append(new Option(d.typeName,d.typeId));
							}
							layui.use('form', function () {
								var form = layui.form;
								form.render("select");
							});

						})

					});
					form.val("book-form", {
						"bookId": data.bookId // "name": "value"
						,"bookName": data.bookName
						,"isbn": data.isbn
						,"author": data.author
						,"press": data.press
						,"publicationDate": data.publicationDate
						,"price": data.price

					});
					form.render(null,"book-form");
					$("#bookId").attr("disabled",true);
				}
			});
		}
	});

	//点击添加按钮事件
	$("#add_btn").click(function(){
		layer.open({
			type:1,
			title: '添加书籍',
			content:$("#book_form_tmpl").html(),
			area: ['400px', '490px'],
			btn:['添加'],
			yes:function(index){
				let bookName=$("#bookName").val(),
					isbn=$("#isbn").val(),
					press=$("#press").val(),
					author=$("#author").val(),
					publicationDate=$("#publicationDate").val(),
					price=$("#price").val(),
					type = $("#types").val();
				let data={
					'bookName':bookName,
					'isbn':isbn,
					'press':press,
					'author':author,
					'publicationDate':publicationDate,
					'price': price,
					'type': type
				}
				$.ajax({
					url:'/book/list',
					type:'post',
					data: JSON.stringify(data),
					contentType: 'application/json',
					dataType:'json',
					success:function (res) {
						if(res.code!=0){
							return layer.msg(res.msg,{icon:2});
						}
						return layer.msg("添加成功",{icon:1,time:1300},function () {
							layer.close(index);
							location.reload();
						})
					}
				});
			},
			success:function(){
				$("#bookId").val("不需要填写").attr("disabled",true);
				$.get("/type/list",(res)=>{
					if(res.code!=0){
						return layer.msg(res.msg,{icon:2});
					}
					$.each(res.data,(index,d)=>{
						$("#types").append(new Option(d.typeName,d.typeId));
						layui.use('form', function () {
							var form = layui.form;
							form.render("select");
						});

					})

				});
			}
		});
	});

	//搜索
	var book_tb_this;
	form.on('submit(search_btn)', function(data) {
		if (book_tb_this != null) {
			book_tb_this.where={};
		}
		book_tb.reload({
			url:'/book/search',
			where:data.field,
			page:{
				curr:1
			},
			done:function () {
				book_tb_this = this;
			}
		});
		return false;
	});

});
