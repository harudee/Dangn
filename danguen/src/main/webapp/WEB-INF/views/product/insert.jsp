<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<section id="content">
	<article id="container">
		<h1>π₯λΉκ·Όκ±°λ κΈμ°κΈ°</h1>
		
		<form action="insert" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="itemname">μνλͺ:</label> <input type="text"
					class="form-control" id="itemname" name="itemname"
					placeholder="Enter itemid">
			</div>

			<div class="form-group row">
				<label for="inputFile" class="col-sm-2 col-form-label"> <strong>μ²¨λΆνμΌ</strong></label>
				<div class="col-sm-10">
					<div class="custom-file" id="inputFile">
						<input name="file" type="file" class="custom-file-input"
							id="customFile"> <label class="custom-file-label"
							for="customFile">νμΌμ μ νν΄ μ£ΌμΈμ.</label>
					</div>
				</div>
			</div>

			<div class="form-group">

				<label for="username">νλ§€μλͺ:</label> <input type="text" id="username"
					name="username" class="form-control"
					value="${principal.user.username}" readonly="readonly" />
			</div>

			<div class="form-group">
				<label for="content">μνλ΄μ©:</label> <textarea id="content"  rows="5" cols="50" name="content" id="content"
					class="form-control" placeholder="κ²μκΈ λ΄μ©μ μμ±ν΄ μ£ΌμΈμ, κ°ν λ° νλ§€κΈμ§ νλͺ©μ κ²μκ° μ νλ  μ μμ΅λλ€"></textarea>
			</div>
			<div class="form-group">
				<label for="price">κ°κ²©:</label> <input type="number"
					class="form-control" id="price" placeholder="Enter price"
					name="price">
			</div>
			<button type="submit" class="btn btn-primary">μνλ±λ‘</button>
		</form>
	</article>
</section>

<script>
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>

</body>
</html>