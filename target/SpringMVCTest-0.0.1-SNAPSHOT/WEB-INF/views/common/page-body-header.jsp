<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<script type="text/javascript">
	var onDocumentReady = [];
	onDocumentReady.subscribe = function(handler) {
		var getType = {};
		if (!(handler && getType.toString.call(handler) === '[object Function]')) {
			return;
		}

		if (typeof $ == 'function') {
			$(document).ready(function() {
				handler();
			});
		} else {
			this.push(handler);
		}
	};
</script>