<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<section id="content">
	<article id="container">
		<h1>🥕당근거래 글쓰기</h1>
		
		<form action="insert" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="itemname">상품명:</label> <input type="text"
					class="form-control" id="itemname" name="itemname"
					placeholder="Enter itemid">
			</div>

			<div class="form-group row">
				<label for="inputFile" class="col-sm-2 col-form-label"> <strong>첨부파일</strong></label>
				<div class="col-sm-10">
					<div class="custom-file" id="inputFile">
						<input name="file" type="file" class="custom-file-input"
							id="customFile"> <label class="custom-file-label"
							for="customFile">파일을 선택해 주세요.</label>
					</div>
				</div>
			</div>

			<div class="form-group">

				<label for="username">판매자명:</label> <input type="text" id="username"
					name="username" class="form-control"
					value="${principal.user.username}" readonly="readonly" />
			</div>

			<div class="form-group">
				<label for="content">상품내용:</label> <textarea id="content"  rows="5" cols="50" name="content" id="content"
					class="form-control" placeholder="게시글 내용을 작성해 주세요, 가품 및 판매금지 품목은 게시가 제한될 수 있습니다"></textarea>
			</div>
			<div class="form-group">
				<label for="price">가격:</label> <input type="number"
					class="form-control" id="price" placeholder="Enter price"
					name="price">
			</div>
			<button type="submit" class="btn btn-primary">상품등록</button>
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