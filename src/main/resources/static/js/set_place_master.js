$(function(){
	$(".edit").click(function(){
		let id = $(this).val();
		let name = $('#'+id).find('.name').text();

		$('#id_value').val(id);
		$('#name_value').val(name);
		$('#delete').prop('disabled',false);


	});
});


$(function(){
	$("#clear").click(function(){

		$('#id_value').val($('#next_id').val());
		$('#name_value').val("");
		$('#delete').prop('disabled',true);

	});
});


$(function(){
	$("#insert_update").click(function(){
		let postId = $('#id_value').val();
		let postName = $('#name_value').val();
		let nextId = $('#next_id').val();
		let editType = "";
		let editTypeVal = "";

		if(postName == ""){
			alert("※名前を入力してください。");
			return false;
		}

		if(postId != nextId){
			editType="update";
			editTypeVal = "更新";
		}else{
			editType='insert';
			editTypeVal = "登録";
		}

		$('#edit_type').val(editType);
		if(window.confirm(editTypeVal+"を行ってよろしいですか？")){

		}else{
			$('#edit_type').val("");
			return false;
		}

	});
});


$(function(){
	$("#delete").click(function(){
		let postId = $('#id_value').val();
		let name = $('#'+postId).find('.name').text();


		$('#edit_type').val('delete');
		if(window.confirm("【"+postId+":"+name+"】の削除を行ってよろしいですか？")){

		}else{
			$('#edit_type').val("");
			return false;
		}

	});
});