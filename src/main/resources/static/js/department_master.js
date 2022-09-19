;(function($) {
	var deparmentPath = "http://localhost:8080/department";
	var departments = [];
	// Lấy data Department
	function getDepartment() {
		$.ajax({
			type: "GET",
			url: `${deparmentPath}/info`,
			contentType: "application/json",
			success: function (response) {
				departments = response;
				$(".main").html(appendDepartment(response));
			} 
		});
	};
	
	// Thêm data vào DOM.
	function appendDepartment(departments) {
		var $content = '';
		$.each(departments, function(index, item) {
			$content += `
				<div class="deparment-item flex-row">
					<button class="item-td selection" 
						data-index="${item.id}" data-value="${item.departmentName}">Edit</button>
					<div class="item-td department-id">${item.id}</div>
					<div class="item-td department-name">${item.departmentName}</div>
				</div>`;
		});
		return $content;
	};
	
	function load() {
		getDepartment();
	};
	
	function clearInput() {
		var departmentId = $(".departmentId").val();
		if(departmentId) {
			$(".departmentId").val("");
			$(".departmentName").val("");
		}
		return;
	};
	
	$("#clear").click(function(e) {
		e.preventDefault();
		clearInput();
	});
	
	$("#delete").click(function(e) {
		e.preventDefault();
		var departmentId = $(".departmentId").val();
		$.ajax({
			type: "DELETE",
			url: `${deparmentPath}/delete/${departmentId}`,
			success: function (response) {
				if(departmentId) {
					departments.splice(parseInt(departmentId) - 1, 1);
					clearInput();
					$(".main").html(appendDepartment(departments));
				}
			}
		});
	});
	
	$("#add-edit").click(function(e) {
		e.preventDefault();
		var departmentId = $(".departmentId").val();
		var departmentName = $(".departmentName").val();
		// Tìm đối tượng depement bằng Id
		var findDepartment = departments.find(function(item) {
			return item.id === parseInt(departmentId);
		})
		var param = {departmentName: departmentName};
		// Nếu id là empty, null và name là empty thi input
		if(!departmentId && departmentName !== "") {
			$.ajax({
				type: "POST",
				url: `${deparmentPath}/create-department`,
				contentType: "application/json",
				data: JSON.stringify(param),
				success: function (response) {
					const department = {id: departments.length + 1, departmentName: response.departmentName};
					departments.push(department);
					$(".departmentName").val("");
					$(".main").html(appendDepartment(departments));
				}
			});
		}
		
		// Nếu chọn 1 deparment thì lấy thông tin id và name và đối tượng tìm được trong departments rồi edit
		if(departmentId && departmentName !== "" && findDepartment) {
			findDepartment.departmentName = departmentName;
			$(".departmentId").val("");
			$(".departmentName").val("");
			$.ajax({
				type: "PUT",
				url: `${deparmentPath}/edit/${departmentId}`,
				contentType: "application/json",
				data: JSON.stringify(param),
				success: function (response) {
					for (const item of departments) {
					  if (item.id === findDepartment.id) {
					    item.departmentName = response.departmentName;
					    break;
					  }
					}
					$(".departmentName").val("");
					$(".main").html(appendDepartment(departments));
				}
			});
		}
		
	});
	
	$(".content-wrapper").on("click", ".selection", function(e) {
		var departmentName = $(this).data("value");
		var departmentId = $(this).data("index");
		$(".departmentId").val(departmentId);
		$(".departmentName").val(departmentName);
		e.preventDefault();
	});
	
	load();
	
})(jQuery); 