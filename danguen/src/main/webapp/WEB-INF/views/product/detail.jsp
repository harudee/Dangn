<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<h1>Detail</h1>

<article id="content" data-id="257918484">

	<h1 class="hide">위닉스 제습기 판매합니다.</h1>

	<section id="article-images">
		<h3 class="hide">이미지</h3>
		<div id="image-slider">
			<div class="slider-wrap">
				<div class="slider" data-article-id="257918484">
					<a
						href="/images?image_index=0&amp;object_id=257918484&amp;object_type=Article">
						<div>
							<div class="image-wrap" data-image-id="1044704436"
								data-image-index="1">
								<img
									data-lazy="https://dnvefa72aowie.cloudfront.net/origin/article/202107/b57052f6ced8e13a55355723814ec618b393bcc9244a69db6b9d06b2a8922bf0.webp?q=95&amp;s=1440x1440&amp;t=inside"
									class="portrait" alt='위닉스 제습기 판매합니다.의 사진 1' src="" />
							</div>
						</div>
					</a> <a
						href="/images?image_index=1&amp;object_id=257918484&amp;object_type=Article">
						<div>
							<div class="image-wrap" data-image-id="1044704434"
								data-image-index="2">
								<img
									data-lazy="https://dnvefa72aowie.cloudfront.net/origin/article/202107/0096f031cc09bc22376bacf952756422374a7572cc5d570662e6193da905b6b5.webp?q=95&amp;s=1440x1440&amp;t=inside"
									class="landscape" alt='위닉스 제습기 판매합니다.의 사진 2' src="" />
							</div>
						</div>
					</a> <a
						href="/images?image_index=2&amp;object_id=257918484&amp;object_type=Article">
						<div>
							<div class="image-wrap" data-image-id="1044704430"
								data-image-index="3">
								<img
									data-lazy="https://dnvefa72aowie.cloudfront.net/origin/article/202107/346b0f2e87a4b15e4b5b6da9acba5e18cc334e3a55c773d0f6bf472d5fbaa1c9.webp?q=95&amp;s=1440x1440&amp;t=inside"
									class="portrait" alt='위닉스 제습기 판매합니다.의 사진 3' src="" />
							</div>
						</div>
					</a> <a
						href="/images?image_index=3&amp;object_id=257918484&amp;object_type=Article">
						<div>
							<div class="image-wrap" data-image-id="1044704440"
								data-image-index="4">
								<img
									data-lazy="https://dnvefa72aowie.cloudfront.net/origin/article/202107/72d7f7f44a378de2e1ae79872ad5b2574b766c332b41537876109c1ccb277bd2.webp?q=95&amp;s=1440x1440&amp;t=inside"
									class="portrait" alt='위닉스 제습기 판매합니다.의 사진 4' src="" />
							</div>
						</div>
					</a> <a
						href="/images?image_index=4&amp;object_id=257918484&amp;object_type=Article">
						<div>
							<div class="image-wrap" data-image-id="1044704442"
								data-image-index="5">
								<img
									data-lazy="https://dnvefa72aowie.cloudfront.net/origin/article/202107/f042924afc76781426a881cc4c0591117cc6ab60eec070e9d3ceadcb1474acea.webp?q=95&amp;s=1440x1440&amp;t=inside"
									class="portrait" alt='위닉스 제습기 판매합니다.의 사진 5' src="" />
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>

	<section id="article-profile">
		<a id="article-profile-link" href="/u/9AlrovKAParZXezg">
			<h3 class="hide">프로필</h3>
			<div class="space-between">
				<div>
					<div id="article-profile-image">
						<img alt="리키맘"
							src="https://d1unjqcospf8gs.cloudfront.net/assets/users/default_profile_80-7e50c459a71e0e88c474406a45bbbdce8a3bf2ed4f2efcae59a064e39ea9ff30.png" />
					</div>
					<div id="article-profile-left">
						<div id="nickname">username</div>
						<div id="region-name">addr</div>
					</div>
				</div>

			</div>
		</a>
	</section>

	<section id="article-description">
		<h1 property="schema:name" id="article-title" style="margin-top: 0px;">title</h1>
		<p id="article-category">
			생활가전 ∙
			<time> 2시간 전 </time>
		</p>
		<p property="schema:priceValidUntil" datatype="xsd:date"
			content="2023-07-09"></p>
		<p rel="schema:url" resource="https://www.daangn.com/257918484"></p>
		<p property="schema:priceCurrency" content="KRW"></p>
		<p id="article-price" property="schema:price" content="50000.0"
			style="font-size: 18px; font-weight: bold;">50,000원</p>
		<div property="schema:description" id="article-detail">
			<p>content</p>
		</div>
		<p id="article-counts">관심 10 ∙ 채팅 55 ∙ 조회 365</p>
	</section>

	<!-- Comment -->
	<!-- comment insert -->
	<div>
		<textarea rows="3" cols="50" id="msg"></textarea>
		<input type="button" class="btn btn-secondary btn-sm" id="btnComment"
			value="댓글쓰기">
	</div>

</article>




<hr />
<div id="replyResult"></div>


<div>
	<table class="table table-borderless">
		<c:forEach items="${product.comments }" var="comment">
			<tr>
				<td>${comment.itemid }</td>
				<td>${comment.content }</td>
				<td><fmt:formatDate value="${comment.regdate }"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
</div>

<script>
	/* commentList view */
	/* var init = function(){
	 $.ajax({
	 type:"get",
	 url:"/reply/commentList/"+${"#itemid"}.val()
	 /* Private field '#itemid' must be declared in an enclosing class 
	 })
	 .done(function(resp){
	 var str="";
	 $.each(resp, function(key, val){
	 str += val.itemid+" "
	 str += val.content+" "
	 str += val.regdate+" "
	 str += "<a href='javascript: fdel("+val.id+")'>삭제</a><br>"
	 })
	 $("#replyResult").html(str);
	 })
	 .fail(function(e){
	 alert("error : "+e);
	 })
	 }//function init */

	/* comment insert */
	$("#btnComment").click(function() {
		alert($("#itemid").val());

		if ($("#msg").val() == "") {
			alert("댓글을 적으세요");
			return;
		}
		var data = {
			"product" : $("#itemid").val(),
			"content" : $("#msg").val()
		}
		$.ajax({
			type : "POST",
			url : "/reply/insert/" + $("#itemid").val(),
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(data),

		}).done(function() {
			alert("댓글 추가 성공");
			location.href = "/product/detail";
		}).fail(function() {
			alert("댓글 추가 실패");
		})

	})

	//댓글삭제
	function fdel(id) {
		alert(id);
		//alert(cnum) 나오는지 테스트
		/* if(!confirm('정말 삭제할까요?'))
			return false;
		$.ajax({
			type:"delete",
			url:"/reply/delete/"+cnum
		})
		.done(function(resp){
			alert(resp+"번 댓글 삭제 성공")
			init();//삭제된 뒤 리스트 보기
			
		})
		.fail(function(e){
			alert("댓글 삭제 실패")
		}) */
	}//fdel
</script>

<%@ include file="../includes/footer.jsp"%>