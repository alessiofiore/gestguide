var Navigation = function() {
	
	var initNavMenu = function() {
		var ctx = '${pageContext.request.contextPath}';
		$(".nav").load(ctx + "/navigation"); 
	}
	
	return {

		// main function to initiate all plugins
		init: function () {
			initNavMenu(); 
		}

	};

}();

//$( document ).ready(function() {
//	var ctx = '<%=request.getContextPath()%>';
//	$(".nav").load(ctx + "/navigation"); 
//});